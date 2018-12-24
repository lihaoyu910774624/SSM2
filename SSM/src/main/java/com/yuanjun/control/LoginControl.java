package com.yuanjun.control;
 
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuanjun.bean.SsmCategory;
import com.yuanjun.bean.SsmCity;
import com.yuanjun.bean.SsmCode;
import com.yuanjun.bean.SsmUser;
import com.yuanjun.bean.SsmUserExample;
import com.yuanjun.comm.AdminUtil;
import com.yuanjun.comm.MapMessage;

import com.yuanjun.comm.PhoneVadation;

import com.yuanjun.comm.SmsUtil;
import com.yuanjun.service.SsmCategoryService;
import com.yuanjun.service.SsmCityService;
import com.yuanjun.service.SsmCodeService;
import com.yuanjun.service.SsmUserService;

 
@Controller
@RequestMapping("/login")
@CrossOrigin
public class LoginControl {
	@Autowired
	private SsmCodeService ssmCodeService;
	@Autowired
	private   SsmUserService ssmUserService;
	@Autowired
	private SsmCategoryService ssmCategoryService;
	@Autowired
	private SsmCityService ssmCityService ;
	
	

	@RequestMapping(value = "/getMessage", params="phone",method=RequestMethod.POST)
	@ResponseBody	
	public MapMessage phoneMessage( 
			String phone) {
		MapMessage reMsg = new MapMessage();
		Map data = new HashMap();
		
		
		
		Boolean isPhone =   PhoneVadation.isPhone(phone);
		if(!isPhone) {
			data.put("code", "");
			reMsg.setCode("0");
			reMsg.setMsg("手机号错误");
			reMsg.setData(data);			
			return reMsg;
			
		}
	
		SsmUser ssmUser =	ssmUserService.selectByPhone(phone);
		if(ssmUser !=null) {
			if(!"1".equals(ssmUser.getFlag())) {
				data.put("code", "");
				reMsg.setCode("0");
				reMsg.setMsg("手机号码无效，重新注册");
				reMsg.setData(data);			
				return reMsg;
				
			}
			
		}
		
		
		long now = System.currentTimeMillis()/1000;
		ssmCodeService.deleteByEexpiretim(now);
		List<SsmCode> ssmCodeList =ssmCodeService.selectByPhoneDesc(phone);
		
		if(ssmCodeList!=null&&ssmCodeList.size()>0) {
			if(null!=ssmCodeList.get(0)) {
				if(now<ssmCodeList.get(0).getExpiretime()) {
					data.put("code", "");
					reMsg.setCode("0");
					reMsg.setMsg("验证码还在有效期内");
					reMsg.setData(data);			
					return reMsg;
				}
			}
		}	
		
		
		int num =(int)(Math.random()*9000)+1000;
		
		SmsUtil smsUtil = new SmsUtil();
		smsUtil.setCode(num+"");
		smsUtil.setMobile(phone);
		Boolean isSendSuccess = false;
		try {
			 isSendSuccess =  smsUtil.sendSms();
			 if(isSendSuccess) {
				
					SsmCode ssmCodeDto  = new SsmCode();
					ssmCodeDto.setPhone(phone);
					ssmCodeDto.setCodenum(num+"");
					
					String timestamp = String.valueOf(new Date().getTime()/1000); 		
					ssmCodeDto.setExpiretime(Integer.valueOf(timestamp)+600);
				
					ssmCodeService.insertSelective(ssmCodeDto);
					
					data.put("code", "");
					reMsg.setCode("1");
					reMsg.setMsg("验证码发送成功");
					reMsg.setData(data);
					System.out.println(reMsg);
			 }
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			data.put("code", "");
			reMsg.setCode("0");
			reMsg.setMsg("获取验证码失败");
			reMsg.setData(data);			
			return reMsg;
		}
		return reMsg;
	}
	@RequestMapping(value = "/register", params= {"phone","codenum","password","password2","name","categoryid","cityid"},
			method=RequestMethod.POST)
	@ResponseBody
	public MapMessage phoneMessageLogin( 
			String phone,  String codenum,String password,String password2,String name,String categoryid,String cityid) {
		MapMessage reMsg = new MapMessage();
		Map data = new HashMap();
				Boolean isPhone =   PhoneVadation.isPhone(phone);
				if(!isPhone) {					
					data.put("code", "");					
					reMsg.setCode("0");
					reMsg.setMsg("手机号码无效");
					reMsg.setData(data);			
					return reMsg;
					
				}
				SsmUserExample example = new SsmUserExample();
				SsmUserExample.Criteria criteria = example.createCriteria();
				criteria.andFlagEqualTo((byte)1);
				criteria.andPhoneEqualTo(phone);
				List<SsmUser> ssmUserList=	ssmUserService.selectByExample(example);	
			     if(ssmUserList!=null&&ssmUserList.size()>0) {
			    	    data.put("code", "");
						reMsg.setCode("0");
						reMsg.setMsg("手机号码已经注册");
						reMsg.setData(data);			
						return reMsg;
			    	 
			     }
				
		long now = System.currentTimeMillis()/1000;
					
		SsmCode	ssmCode	=ssmCodeService.selectByPhoneAndCodenum(phone, codenum);
		if(ssmCode==null) {
			data.put("code", "");
			reMsg.setCode("0");
			reMsg.setMsg("短信验证码失效");
			reMsg.setData(data);			
			return reMsg;
		}else if(now>ssmCode.getExpiretime()) {
			data.put("code", "");
			reMsg.setCode("0");
			reMsg.setMsg("短信验证码超时");
			reMsg.setData(data);			
			return reMsg;
			
		}
		
		if(!password.equals(password2)) {
			data.put("code", "");
			reMsg.setCode("0");
			reMsg.setMsg("两次密码不一致");
			reMsg.setData(data);			
			return reMsg;
		}
		
		if(password.replace(" ", "").length()>10) {
			data.put("code", "");
			reMsg.setCode("0");
			reMsg.setMsg("密码要大于10位");
			reMsg.setData(data);			
			return reMsg;
		}
		
		SsmCategory ssmCategory  = ssmCategoryService.selectByPrimaryKey(Integer.valueOf(categoryid));
		if(null==ssmCategory) {
			data.put("code", "");
			reMsg.setCode("0");
			reMsg.setMsg("categoryid无效");
			reMsg.setData(data);			
			return reMsg;			
		}
		
		SsmCity ssmCity	= ssmCityService.selectByPrimaryKey(Short.valueOf(cityid)); 
		if(null==ssmCity) {
			data.put("code", "");
			reMsg.setCode("0");
			reMsg.setMsg("cityid无效");
			reMsg.setData(data);			
			return reMsg;
			
		}
		
	   String userid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		
		SsmUser  ssmUser = new SsmUser();
		ssmUser.setUserid(userid);
		ssmUser.setPhone(phone);
		ssmUser.setPassword(password);
		ssmUser.setName(name);
		ssmUser.setCategoryid(categoryid);
		ssmUser.setCityid(cityid);
		   int userRow = ssmUserService.insertSelective(ssmUser);
		if(userRow>0) {
			
			data.put("userid", userid);
			reMsg.setCode("1");
			reMsg.setMsg("注册成功");
			reMsg.setData(data);
			
			ssmCodeService.deleteByPrimaryKey(ssmCode.getId());
		}else {
			
			data.put("code", "");
			reMsg.setCode("0");
			reMsg.setMsg("ssm_user保存失败");
			reMsg.setData(data);			
			return reMsg;
			
		}
		
		return reMsg;
	}
	
	@RequestMapping(value = "/ppLogin", params= {"phone","password"},
			method=RequestMethod.POST)
	@ResponseBody
	public MapMessage  pplogin (String phone, String password ) {		
		MapMessage reMsg = new MapMessage();
		Map data = new HashMap();
		
		
		Boolean isPhone =   PhoneVadation.isPhone(phone);
		if(!isPhone) {					
			data.put("code", "");					
			reMsg.setCode("0");
			reMsg.setMsg("手机号码无效");
			reMsg.setData(data);			
			return reMsg;
			
		}
				if(password.replace(" ", "").length()>10) {
					data.put("code", "");
					reMsg.setCode("0");
					reMsg.setMsg("密码长度不能低于10位");
					reMsg.setData(data);			
					return reMsg;
				}
				SsmUserExample example = new SsmUserExample();
				SsmUserExample.Criteria criteria = example.createCriteria();
				criteria.andFlagEqualTo((byte)1);
				criteria.andPhoneEqualTo(phone);
				List<SsmUser> ssmUserList=	ssmUserService.selectByExample(example);
				
		if(null!=ssmUserList&&ssmUserList.size()==1) {
			SsmUser	ssmUser = ssmUserList.get(0);
			if(StringUtils.isNotBlank(password)&&password.equals(ssmUser.getPassword())) {
				
				data.put("userid", ssmUser.getUserid());
				data.put("phone", ssmUser.getPhone());
				data.put("password", ssmUser.getPassword());
				data.put("name", ssmUser.getName());
				data.put("categoryid", ssmUser.getCategoryid());
				data.put("cityid", ssmUser.getCityid());
				reMsg.setCode("1");
				reMsg.setMsg("登录成功");
				reMsg.setData(data);
			}else {
				data.put("code", "");
				reMsg.setCode("0");
				reMsg.setMsg("密码不正确");
				reMsg.setData(data);			
				return reMsg;
				
			}
			
			
		}else {
			data.put("code", "");
			reMsg.setCode("0");
			reMsg.setMsg("手机号码不正确");
			reMsg.setData(data);			
			return reMsg;
		}
		
		
		return reMsg ;
	}
	
	@RequestMapping(value = "/LoginByCode", params= {"phone","codenum"},
			method=RequestMethod.POST)
	@ResponseBody
	public MapMessage  LoginByCode (String phone, String codenum ) {		
		MapMessage reMsg = new MapMessage();
		Map data = new HashMap();
		
		
		Boolean isPhone =   PhoneVadation.isPhone(phone);
		if(!isPhone) {					
			data.put("code", "");					
			reMsg.setCode("0");
			reMsg.setMsg("手机号码无效");
			reMsg.setData(data);			
			return reMsg;
			
		}
		
		     SsmUser  ssmUser=	ssmUserService.selectByPhone(phone);
		     SsmCode ssmCode=   ssmCodeService.selectByPhoneAndCodenum(phone, codenum);
		if(ssmUser!=null) {
			  if(ssmCode!=null) {
				  long now = System.currentTimeMillis()/1000;
					if(now<ssmCode.getExpiretime()) {
						reMsg.setCode("1");
					    reMsg.setMsg("登陆成功");
					    data.put("userid", ssmUser.getUserid());
						data.put("phone", ssmUser.getPhone());
						data.put("password", ssmUser.getPassword());
						data.put("name", ssmUser.getName());
						data.put("categoryid", ssmUser.getCategoryid());
						data.put("cityid", ssmUser.getCityid());
					    data.put("userid", ssmUser.getUserid());
					    reMsg.setData(data);
					    ssmCodeService.deleteByEexpiretim(now);
					}else {
						reMsg.setCode("0");
					    reMsg.setMsg("短信验证已经过期");
					    data.put("", "");
					}
				  
			  }else {
				  
				    reMsg.setCode("0");
				    reMsg.setMsg("短信验证无效");
				    data.put("", "");
				  
				  
				  
			  }
			
				
			    
		}else {
			reMsg.setCode("0");
		    reMsg.setMsg("账号不存在");
		    data.put("", "");
		    reMsg.setData(data);
		    return reMsg ;
		}
		return reMsg ;
	}
	
	
	
	
}