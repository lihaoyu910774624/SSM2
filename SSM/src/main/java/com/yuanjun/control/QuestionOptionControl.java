package com.yuanjun.control;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuanjun.bean.SsmQuestionOption;
import com.yuanjun.bean.SsmQuestionOptionExample;
import com.yuanjun.comm.AdminUtil;
import com.yuanjun.comm.MapMessage;
import com.yuanjun.comm.Message;
import com.yuanjun.comm.QuestionOptionListMessage;
import com.yuanjun.service.SsmQuestionOptionService;

@Controller
@RequestMapping("/QuestionOption")
@CrossOrigin
public class QuestionOptionControl {
	@Autowired
	private AdminUtil util ;
	@Autowired
	private SsmQuestionOptionService ssmQuestionOptionService ;
	@RequestMapping(value="/findAll", method=RequestMethod.POST)
	@ResponseBody
	public QuestionOptionListMessage getAll(
			@RequestParam(value="adminId") String adminId	,			
			@RequestParam(value="title") String title	,			
			@RequestParam(value="currPage",required=false,defaultValue="1") int currPage,
			@RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize ) {
		QuestionOptionListMessage message = new QuestionOptionListMessage ();
	/*	Boolean isAdmin =   util.isAdmin(adminId);
		if(!isAdmin) {			
			message.setCode("0");
			message.setMsg("0");
			return message ;
		}		
		int start = (currPage - 1) * pageSize;
	    int end = currPage * pageSize;
		SsmQuestionOptionExample example = new SsmQuestionOptionExample();
		SsmQuestionOptionExample.Criteria criteria=   example.createCriteria() ;
		criteria.andFlagEqualTo((byte)1);
		long sumCount = ssmQuestionOptionService.countByExample(example);		
		int sumPage =    (int) Math.ceil(Double.valueOf(sumCount)/pageSize)    ;
		//List<SsmQuestionOption> data= ssmQuestionOptionService.getAll(title, String.valueOf(start), String.valueOf(end));		
		message.setCode("1");
		message.setMsg("分页查询成功");
		message.setCurrPage(currPage);
		message.setSumPage(sumPage);
		message.setData(data);*/
		return message ;
	}
	
	
	
	
	@RequestMapping(value="/findById", method=RequestMethod.POST)
	@ResponseBody
	public MapMessage getById(
			@RequestParam(value="adminId") String adminId	,	
			@RequestParam(value="questionid")String questionid) {
		MapMessage message = new MapMessage ();
		/*Map<String,String> data = new HashMap<String,String>();
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Boolean isAdmin =   util.isAdmin(adminId);
		if(!isAdmin) {			
			message.setCode("0");
			message.setMsg("0");
			return message ;
		}		
		SsmQuestionOptionExample example = new SsmQuestionOptionExample();
		SsmQuestionOptionExample.Criteria criteria=   example.createCriteria() ;
		criteria.andFlagEqualTo((byte)1);
		criteria.andQuestionidEqualTo(Integer.valueOf(questionid));		
		List<SsmQuestionOption> list= ssmQuestionOptionService.selectByExample(example);
		if(list!=null&&list.size()>0) {
			SsmQuestionOption sqo = new SsmQuestionOption();
			sqo= list.get(0);
			data.put("questionid", String.valueOf(sqo.getQuestionid()));
			data.put("no", sqo.getNo());
			data.put("title", sqo.getTitle());
			data.put("addtime", sdf.format(sqo.getAddtime()));
			message.setCode("1");
			message.setMsg("数据查询成功");
		}else {
			message.setCode("0");
			message.setMsg("数据查询失败");
		}*/
		return message ;
	}
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	@ResponseBody
	public Message deleteQuestionOption(
			@RequestParam(value="adminId") String adminId	,	
			@RequestParam(value="questionid")String questionid) {
		Message message = new Message ();
		/*Boolean isAdmin =   util.isAdmin(adminId);
		if(!isAdmin) {			
			message.setCode("0");
			message.setMsg("0");
			return message ;
		}		
		SsmQuestionOptionExample example = new SsmQuestionOptionExample();
		SsmQuestionOptionExample.Criteria criteria=   example.createCriteria() ;
		criteria.andFlagEqualTo((byte)1);
		criteria.andQuestionidEqualTo(Integer.valueOf(questionid));
		SsmQuestionOption sqo = new SsmQuestionOption();
		sqo.setFlag((byte)0);
		int index = ssmQuestionOptionService.updateByExampleSelective(sqo, example);
		if(index>0) {
			message.setCode("1");
			message.setMsg("数据删除成功");
		}else {
			message.setCode("0");
			message.setMsg("数据删除失败");
		}*/
		return message ;
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	@ResponseBody
	public Message updateQuestionOption(
			@RequestParam(value="adminId") String adminId	,	
			@RequestParam(value="questionid")String questionid,
			@RequestParam(value="no")String no,
			@RequestParam(value="title")String title) {
		Message message = new Message ();
		/*Boolean isAdmin =   util.isAdmin(adminId);
		if(!isAdmin) {			
			message.setCode("0");
			message.setMsg("0");
			return message ;
		}		
		
      if(StringUtils.isNotBlank(title)) {
			
			if(title.length()>255) {
				message.setCode("0");
				message.setMsg("title长度大于255");
				return message ;
			}
		}
		SsmQuestionOptionExample example = new SsmQuestionOptionExample();
		SsmQuestionOptionExample.Criteria criteria=   example.createCriteria() ;
		criteria.andFlagEqualTo((byte)1);
		criteria.andQuestionidEqualTo(Integer.valueOf(questionid));
		SsmQuestionOption sqo = new SsmQuestionOption();
		sqo.setNo(no);
		sqo.setTitle(title);
		int index = ssmQuestionOptionService.updateByExampleSelective(sqo, example);
		if(index>0) {
			message.setCode("1");
			message.setMsg("数据更新成功");
		}else {
			message.setCode("0");
			message.setMsg("数据更新失败");
		}*/
		return message ;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public Message addQuestionOption(
			@RequestParam(value="adminId") String adminId	,	
			@RequestParam(value="no")String no,
			@RequestParam(value="questionid")String title
			) {
		Message message = new Message ();
		Boolean isAdmin =   util.isAdmin(adminId);
		if(!isAdmin) {			
			message.setCode("0");
			message.setMsg("0");
			return message ;
		}
		
		 if(StringUtils.isNotBlank(title)) {
				
				if(title.length()>255) {
					message.setCode("0");
					message.setMsg("title长度大于255");
					return message ;
				}
			}
		
		SsmQuestionOption sqo = new SsmQuestionOption();
		sqo.setNo(no);
		sqo.setTitle(title);
		int index = ssmQuestionOptionService.insertSelective(sqo);
		if(index>0) {
			message.setCode("1");
			message.setMsg("数据添加成功");
		}else {
			message.setCode("0");
			message.setMsg("数据添加失败");
		}
		return message ;
	}
	
	
	
	
}
