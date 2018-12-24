package com.yuanjun.control;

import java.text.SimpleDateFormat;
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
import com.yuanjun.bean.SsmCategoryExample;
import com.yuanjun.bean.SsmCategoryExample.Criteria;
import com.yuanjun.comm.AdminUtil;
import com.yuanjun.comm.CategoryListMessage;
import com.yuanjun.comm.MapMessage;
import com.yuanjun.comm.Message;
import com.yuanjun.service.SsmCategoryService;
import com.yuanjun.vo.CategoryInfo;

@Controller
@RequestMapping("/Category")
@CrossOrigin
public class CategoryControl {
	@Autowired
	private SsmCategoryService ssmCategoryService ;
	@Autowired
	private AdminUtil util ;
	@RequestMapping(value = "/getAll",method=RequestMethod.POST)
	@ResponseBody	
	public CategoryListMessage findAll(
			@RequestParam(value="adminId") String adminId,
			@RequestParam(value="pid",required=true) Integer pid) {	
		
		CategoryListMessage message = new CategoryListMessage ();
		Boolean isAdmin =   util.isAdmin(adminId);
		if(!isAdmin) {			
			message.setCode("0");
			message.setMsg("0");
			return message ;
		}
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(0);
		ids.add(1);
		ids.add(2);
		ids.add(3);
		if(!ids.contains(pid)) {
			message.setCode("0");
			message.setMsg("pid不在有效范围内");
			
			return message ;
		}
		
		List<CategoryInfo> data  = new ArrayList<CategoryInfo>();
		data = ssmCategoryService.selectAll(pid);
		
		message.setCode("1");
		message.setMsg("成功");
		message.setData(data);
		return message ;
		
	}
	
	
	
	@RequestMapping(value = "/getById",method=RequestMethod.POST)
	@ResponseBody	
	public MapMessage getById(
			@RequestParam(value="adminId") String adminId,
			@RequestParam(value="id",required=true) Integer id) {	
		
		MapMessage message = new MapMessage();
		Boolean isAdmin =   util.isAdmin(adminId);
		if(!isAdmin) {			
			message.setCode("0");
			message.setMsg("0");
			return message ;
		}
		Map<String,String> data = new HashMap<String,String>();
		CategoryInfo categoryInfo = new CategoryInfo();
		categoryInfo = ssmCategoryService.selectById(id);
		data.put("id", String.valueOf(categoryInfo.getId()));
		data.put("pid", String.valueOf(categoryInfo.getPid()));
		data.put("title", categoryInfo.getTitle());
		data.put("categoryTitle", categoryInfo.getCategoryTitle());		
		data.put("addtime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(categoryInfo.getAddtime()));
		message.setCode("1");
		message.setMsg("成功");
		message.setData(data);
		return message ;
		
	}
	
	@RequestMapping(value = "/add",method=RequestMethod.POST)
	@ResponseBody	
	public Message addCategory(
			@RequestParam(value="adminId") String adminId,
			@RequestParam(value="pid" ,required=true) Integer pid,
			                  @RequestParam(value="title")	String title )		
		{
		Message message = new Message();
		Boolean isAdmin =   util.isAdmin(adminId);
		if(!isAdmin) {			
			message.setCode("0");
			message.setMsg("0");
			return message ;
		}
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		if(!ids.contains(pid)) {
			message.setCode("0");
			message.setMsg("pid不在有效范围内");
			return message ;
		}
		
		SsmCategory category = new SsmCategory ();
		category.setPid(pid);
		category.setTitle(title);
		int index=ssmCategoryService.insertSelective(category);
		if(index>0) {
			message.setCode("1");
			message.setMsg("成功");
		}else {
			message.setCode("0");
			message.setMsg("失败");			
		}
		return message ;
	}
	
	@RequestMapping(value = "/delete",method=RequestMethod.POST)
	@ResponseBody	
	public Message deleteCategory(
			@RequestParam(value="adminId") String adminId,
			@RequestParam(value="id",required=true) Integer id)	
	    {
		Message message = new  Message ();
		Boolean isAdmin =   util.isAdmin(adminId);
		if(!isAdmin) {			
			message.setCode("0");
			message.setMsg("0");
			return message ;
		}
		
		SsmCategoryExample example = new SsmCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andFlagEqualTo((byte)1);
		criteria.andIdEqualTo(id);		
		SsmCategory category = new SsmCategory();
		category.setFlag((byte)0);
		int	index =  ssmCategoryService.updateByExampleSelective(category, example);
	    if(index>0) {
	    	message.setCode("1");
	    	message.setMsg("成功");
	    }else {	    	
	    	message.setCode("0");
	    	message.setMsg("失败");
	    	
	    }
		return message ;
	}
	@RequestMapping(value = "/update",method=RequestMethod.POST)
	@ResponseBody	
	public Message updateCategory(
			@RequestParam(value="adminId") String adminId,
			@RequestParam(value="id",required=true) Integer id,			
			                      @RequestParam(value="pid") Integer pid,
			                      @RequestParam(value="title") String title )		
	       {   
		        Message message = new  Message ();
		        Boolean isAdmin =   util.isAdmin(adminId);
				if(!isAdmin) {			
					message.setCode("0");
					message.setMsg("0");
					return message ;
				}
		        List<Integer> ids = new ArrayList<Integer>();
				ids.add(1);
				ids.add(2);
				ids.add(3);
				if(!ids.contains(pid)) {
					message.setCode("0");
					message.setMsg("pid不在有效范围内");
					return message ;
				}
		        SsmCategoryExample example = new SsmCategoryExample();
		 		Criteria criteria = example.createCriteria();
		 		criteria.andFlagEqualTo((byte)1);		 		
		 		criteria.andIdEqualTo(id);
		 		SsmCategory category = new SsmCategory();
		 		category.setPid(pid);
		 		category.setTitle(title);
		 		int	index =  ssmCategoryService.updateByExampleSelective(category, example);
		 		if(index>0) 
		 		{
		 			message.setCode("1");
			    	message.setMsg("成功");
		 		}else {
		 			message.setCode("0");
			    	message.setMsg("失败");
		 		}
		 		
		return message ;
	}
}
