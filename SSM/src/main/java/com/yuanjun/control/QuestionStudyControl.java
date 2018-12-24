package com.yuanjun.control;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuanjun.bean.SsmAdminExample;
import com.yuanjun.bean.SsmQuestionStudy;
import com.yuanjun.comm.AdminUtil;
import com.yuanjun.comm.MapMessage;
import com.yuanjun.comm.Message;
import com.yuanjun.service.SsmQuestionStudyService;
@Controller
@RequestMapping("/QuestionStudy")
@CrossOrigin
public class QuestionStudyControl {
	@Autowired
	private AdminUtil util ;
	@Autowired
	private SsmQuestionStudyService ssmQuestionStudyService;
	@RequestMapping(value = "/add",method=RequestMethod.POST)
	@ResponseBody	
	private Message addQuestionStudy(
			@RequestParam(value="adminId") String adminId,
			@RequestParam(value="questionid") String questionid,
			@RequestParam(value="status") String status,
			@RequestParam(value="kind") String kind
			
			) {
		Message  message = new Message ();
		/*Boolean isAdmin =   util.isAdmin(adminId);
		if(!isAdmin) {			
			message.setCode("0");
			message.setMsg("0");
			return message ;
		}	
		//需要对入参做一些校验  questionid   status  kind
		// 待完善
		SsmQuestionStudy study = new SsmQuestionStudy ();
		study.setKind(new Byte(kind));
		study.setQuestionid(Integer.valueOf(questionid));
		study.setStatus(new Byte(status));
	  int 	index  = ssmQuestionStudyService.insertSelective(study);
	  if(index>0) {
			message.setCode("1");
			message.setMsg("数据更新成功");
		}else {
			message.setCode("0");
			message.setMsg("数据更新失败");}
		*/
		return message ;
	}
	
	@RequestMapping(value = "/delete",method=RequestMethod.POST)
	@ResponseBody	
	private Message deleteQuestionStudy(
			@RequestParam(value="adminId") String adminId,
			@RequestParam(value="id") String id
			) {
		Message  message = new Message ();
		Boolean isAdmin =   util.isAdmin(adminId);
		if(!isAdmin) {			
			message.setCode("0");
			message.setMsg("0");
			return message ;
		}	
		
		/*SsmAdminExample example = new SsmAdminExample() ;
		SsmAdminExample.Criteria cri = example.createCriteria();
		cri.andFlagEqualTo((byte)1);
		cri.andIdEqualTo(Integer.valueOf(id));
		SsmQuestionStudy study = new SsmQuestionStudy ();
		study.setFlag((byte)0);	
	  int 	index  = ssmQuestionStudyService.updateByExampleSelective(study, example);
	  if(index>0) {
			message.setCode("1");
			message.setMsg("数据删除成功");
		}else {
			message.setCode("0");
			message.setMsg("数据删除失败");}
		*/
		return message ;
	}
	
	@RequestMapping(value = "/update",method=RequestMethod.POST)
	@ResponseBody	
	private Message updateQuestionStudy(
			@RequestParam(value="adminId") String adminId,
			@RequestParam(value="id") String id,
			@RequestParam(value="questionid") String questionid,
			@RequestParam(value="status") String status,
			@RequestParam(value="kind") String kind
			) {
		Message  message = new Message ();
		Boolean isAdmin =   util.isAdmin(adminId);
		if(!isAdmin) {			
			message.setCode("0");
			message.setMsg("0");
			return message ;
		}	
		
		/*SsmAdminExample example = new SsmAdminExample() ;
		SsmAdminExample.Criteria cri = example.createCriteria();
		cri.andFlagEqualTo((byte)1);
		cri.andIdEqualTo(Integer.valueOf(id));
		SsmQuestionStudy study = new SsmQuestionStudy ();
		study.setKind(new Byte(kind));
		study.setQuestionid(Integer.valueOf(questionid));
		study.setStatus(new Byte(status));	
	  int 	index  = ssmQuestionStudyService.updateByExampleSelective(study, example);
	  if(index>0) {
			message.setCode("1");
			message.setMsg("数据更新成功");
		}else {
			message.setCode("0");
			message.setMsg("数据更新失败");}*/
		
		return message ;
	}
	
	@RequestMapping(value = "/getById",method=RequestMethod.POST)
	@ResponseBody	
	private MapMessage getById(
			@RequestParam(value="adminId") String adminId,
			
			@RequestParam(value="id") String id
			
			) {
		MapMessage  message = new MapMessage ();
		Map<String,String> data = new HashMap<String,String>();
		Boolean isAdmin =   util.isAdmin(adminId);
		if(!isAdmin) {			
			message.setCode("0");
			message.setMsg("0");
			return message ;
		}	
		
		SsmQuestionStudy study = new SsmQuestionStudy ();
		study = ssmQuestionStudyService.selectByPrimaryKey(Integer.valueOf(id));
	    data.put("questionid", String.valueOf(study.getQuestionid()));
	    data.put("status", String.valueOf(study.getStatus()) );
	    data.put("kind", String.valueOf(study.getKind()));
		return message ;
	}
	
	    //查找所有 待确定
	
	

}
