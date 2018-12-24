package com.yuanjun.comm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.yuanjun.bean.SsmAdmin;
import com.yuanjun.bean.SsmAdminExample;
import com.yuanjun.bean.SsmAdminExample.Criteria;
import com.yuanjun.service.SsmAdminService;
import com.yuanjun.service.SsmAdminServiceImpl;

@Component
public class AdminUtil {
	
	@Autowired
	private	SsmAdminService ssmAdminService;
	

	public SsmAdminService getSsmAdminService() {
		return ssmAdminService;
	}

	public void setSsmAdminService(SsmAdminService ssmAdminService) {
		this.ssmAdminService = ssmAdminService;
	}

	private String admin ;
	
	   public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public  Boolean isAdmin(String adminId) {
		Boolean isAm = false ;
		
		SsmAdminExample example = new SsmAdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andFlagEqualTo((byte)1);
		criteria.andAdminidEqualTo(adminId);
		List<SsmAdmin> data = ssmAdminService.selectByExample(example);
		if(data!=null&&data.size()>0) {
			isAm = true ;			
		}
		
		return isAm ;
	}
	
	

}
