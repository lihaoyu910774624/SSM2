package com.yuanjun.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuanjun.bean.SsmCategory;
import com.yuanjun.bean.SsmCity;
import com.yuanjun.bean.SsmUser;
import com.yuanjun.comm.UserListMessage;
import com.yuanjun.comm.AdminUtil;
import com.yuanjun.comm.MapMessage;
import com.yuanjun.comm.Message;
import com.yuanjun.comm.PhoneVadation;
import com.yuanjun.service.SsmCategoryService;
import com.yuanjun.service.SsmCityService;
import com.yuanjun.service.SsmUserService;
import com.yuanjun.vo.UserInfo;

@Controller
@RequestMapping("/ManageUse")
@CrossOrigin
public class ManageUserControl {
	
	@Autowired
	private   SsmUserService ssmUserService;
	@Autowired
	private SsmCategoryService ssmCategoryService;
	@Autowired
	private SsmCityService ssmCityService ;
	@Autowired
	private AdminUtil util ;
	@RequestMapping(value = "/queryUser",method=RequestMethod.POST)
	@ResponseBody	
	public UserListMessage queryUser(
			
			@RequestParam(value="phone") String phone,
			@RequestParam(value="currPage",required=false,defaultValue="1") int currPage,
			@RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize )
	{   
		
		UserListMessage listMessage = new UserListMessage ();
		
		List<UserInfo> data = null;

      int firstIndex = (currPage - 1) * pageSize;

      int lastIndex = currPage * pageSize;
     
      int sumCount = ssmUserService.getCount();
    
      int sumPage =    (int) Math.ceil(Double.valueOf(sumCount)/pageSize)    ;    
		data = ssmUserService.getUserinfoByPhone(phone,firstIndex,lastIndex);
		if(data!=null&&data.size()>0) {
			listMessage.setCode("1");
			listMessage.setMsg("成功");
			listMessage.setData(data);
			listMessage.setCurrPage(currPage);
			listMessage.setSumPage(sumPage);
			listMessage.setPhone(phone);
			
		}else {
			listMessage.setCode("0");
			listMessage.setMsg("失败");
			listMessage.setData(data);
			listMessage.setCurrPage(1);
			listMessage.setSumPage(1);			
			listMessage.setPhone(phone);
			
		}
		
		return listMessage ;
	}
	
	
	@RequestMapping(value = "/deleteUser",method=RequestMethod.POST)
	@ResponseBody	
	public Message deleteUser(
			@RequestParam(value="adminId") String adminId,
			@RequestParam(value="userid") String userid ) {
		Message reMsg = new Message();
		Boolean isAdmin =   util.isAdmin(adminId);
		if(!isAdmin) {			
			reMsg.setCode("0");
			reMsg.setMsg("0");
			return reMsg ;
		}
		SsmUser ssmUser = new SsmUser();
		ssmUser.setUserid(userid);
		ssmUser.setFlag("0");
		int index = ssmUserService.updateByPrimaryKeySelective(ssmUser);
		if(index>0) {
			reMsg.setCode("1");
			reMsg.setMsg("成功");
		}else {
			reMsg.setCode("0");
			reMsg.setMsg("失败");					
			return reMsg;
		}
		return reMsg ;
	}
	
	@RequestMapping(value = "/updateUser",method=RequestMethod.POST)
	@ResponseBody	
	public Message updateUser(
			@RequestParam(value="adminId") String adminId,
			@RequestParam(value="userid") String userid,
			@RequestParam(value="categoryid") String categoryid ,
			@RequestParam(value="cityid") String cityid,
			@RequestParam(value="phone") String phone,
			@RequestParam(value="name") String name,
			@RequestParam(value="password") String password
			) {
		Message reMsg = new Message();
		Boolean isAdmin =   util.isAdmin(adminId);
		if(!isAdmin) {			
			reMsg.setCode("0");
			reMsg.setMsg("0");
			return reMsg ;
		}
		
				Boolean isPhone =   PhoneVadation.isPhone(phone);
				if(!isPhone) {					
					reMsg.setCode("0");
					reMsg.setMsg("手机无效");							
					return reMsg;					
				}
				
				if(password.replace(" ", "").length()>20) {					
					reMsg.setCode("0");
					reMsg.setMsg("密码长度不能大于20位");							
					return reMsg;
				}
				
				if(name.replace(" ", "").length()>10) {					
					reMsg.setCode("0");
					reMsg.setMsg("用户名长度不能小于10位");							
					return reMsg;
				}
				
				SsmCategory category =	 ssmCategoryService.selectByPrimaryKey(Integer.valueOf(categoryid));
				if(category==null) {
					
					reMsg.setCode("0");
					reMsg.setMsg("categoryid无效");							
					return reMsg;
					
				}
				SsmCity city = ssmCityService.selectByPrimaryKey(Short.valueOf(cityid));
				if(city==null) {
					reMsg.setCode("0");
					reMsg.setMsg("cityid无效");							
					return reMsg;
					
				}
		
		
		SsmUser ssmUser = new SsmUser();
		ssmUser.setUserid(userid);
		ssmUser.setCategoryid(categoryid);
		ssmUser.setCityid(cityid);
		ssmUser.setPhone(phone);
		ssmUser.setName(name);
		ssmUser.setPassword(password);
		int index = ssmUserService.updateByPrimaryKeySelective(ssmUser);
		if(index>0) {
			reMsg.setCode("1");
			reMsg.setMsg("成功");
		}else {
			reMsg.setCode("0");
			reMsg.setMsg("失败");					
			return reMsg;
		}
		return reMsg ;
	}
	
	@RequestMapping(value = "/getUserById",method=RequestMethod.POST)
	@ResponseBody	
	public MapMessage getUserById(
			

			@RequestParam(value="userid") String userid	)	  
			 {
		
		MapMessage msg = new MapMessage ();	
	
		Map<String,String> data = new HashMap<String,String>();
		UserInfo info = ssmUserService.getUserInfoById(userid);
		if(info!=null) {
			data.put("userid", info.getUserid());
			data.put("phone", info.getPhone());
			data.put("password", info.getPassword());
			data.put("name", info.getName());
			data.put("addtime", info.getAddtime());
			data.put("cityid", info.getCityid());
			data.put("categoryid", info.getCategoryid());			
			data.put("category", info.getCategory());
			data.put("city", info.getCity());
			msg.setCode("1");
			msg.setMsg("成功");
			msg.setData(data);
		}else {
			msg.setCode("0");
			msg.setMsg("失败");
			msg.setData(data);
			
		}
		return msg ;
	}
	
}
