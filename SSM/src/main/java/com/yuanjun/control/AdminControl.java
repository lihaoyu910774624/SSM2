package com.yuanjun.control;

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

import com.yuanjun.bean.SsmAdmin;
import com.yuanjun.bean.SsmAdminExample;
import com.yuanjun.bean.SsmAdminExample.Criteria;
import com.yuanjun.comm.MapMessage;
import com.yuanjun.service.SsmAdminService;
@Controller
@RequestMapping("/Admin")
@CrossOrigin
public class AdminControl {
	@Autowired
   private	SsmAdminService ssmAdminService;
	
	@RequestMapping(value = "/AdminLogin",method=RequestMethod.POST)
	@ResponseBody	
	public MapMessage getById (
			@RequestParam(value="nameAdmin") String nameAdmin,
            @RequestParam(value="passwordAdmin") String passwordAdmin			
			) {
		
		MapMessage message = new MapMessage();
		Map<String,String> data = new HashMap<String,String>();
		SsmAdminExample example = new SsmAdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andFlagEqualTo((byte)1);
		criteria.andNameEqualTo(nameAdmin);
		criteria.andPasswordEqualTo(passwordAdmin);
		List<SsmAdmin> list = ssmAdminService.selectByExample(example);
		if(list!=null&&list.size()>0) {
			SsmAdmin admin = list.get(0);
			data.put("adminId", admin.getAdminid());			
			message.setCode("1");
			message.setMsg("数据查找成功");
			message.setData(data);
		}else {
			data.put("", "");
			message.setCode("0");
			message.setMsg("数据查找失败");
			message.setData(data);
			return message ;
		}
		return message ;
	}
	
	
	
	
	

}
