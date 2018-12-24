package com.yuanjun.front;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.cci.connection.ConnectionFactoryUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.mysql.fabric.xmlrpc.base.Array;
import com.yuanjun.bean.SsmQuestionExample;
import com.yuanjun.bean.SsmQuestionStudy;
import com.yuanjun.bean.SsmQuestionStudyExample;
import com.yuanjun.bean.SsmUser;
import com.yuanjun.comm.MapMessage;
import com.yuanjun.comm.Message;
import com.yuanjun.service.SsmQuestionOptionService;
import com.yuanjun.service.SsmQuestionService;
import com.yuanjun.service.SsmQuestionStudyService;
import com.yuanjun.service.SsmUserService;
import com.yuanjun.vo.FrontQuestion.TrainingOption;
import com.yuanjun.vo.FrontQuestion.TrainingQuestion;
import com.yuanjun.vo.FrontQuestion.TrainingQuestionListMessage;
import com.yuanjun.vo.frontStudy.AnserDto;
import com.yuanjun.vo.frontStudy.QuestionStudyModel;
import com.yuanjun.vo.frontStudy.StudyInfoListMessage;
import com.yuanjun.vo.frontStudy.StudyOption;
import com.yuanjun.vo.frontStudy.StudyQuestion;
import com.yuanjun.vo.frontStudy.StudyTitleListMessage;
import com.yuanjun.vo.frontStudy.StudyTitleVo;

@Controller
@RequestMapping("/Study")
@CrossOrigin
public class FrontStudyControl {
	
	@Autowired
	private   SsmUserService ssmUserService;
	@Autowired
	 private SsmQuestionStudyService ssmQuestionStudyService ;
	@Autowired
	private SsmQuestionOptionService ssmQuestionOptionService ;
	@Autowired
	 private   SsmQuestionService ssmQuestionService;
	@RequestMapping(value="/getTtitle",method=RequestMethod.POST)
	@ResponseBody
	public StudyTitleListMessage getCategoryTitle (
			@RequestParam(value="userid") String userid
			) {
		StudyTitleListMessage message = new StudyTitleListMessage ();
		 List<StudyTitleVo> data = new ArrayList<StudyTitleVo>(); 
		// 校验  userid 表里面是否存在  不能为空 
	  	   List<SsmUser>  userList= ssmUserService.selectByPrimaryKey(userid); 
	  	   if(userList!=null&&userList.size()>0) {
	  		   // sql固定条件 flag=1   kind=2（表示未掌握）  
	  		   data = ssmQuestionStudyService.getCategoryTitle(userid);
	  		  message.setCode("1"); 
	  		  message.setMsg("数据查询成功");
	  		  message.setData(data);
	  	   }else {
	  		  message.setCode("0"); 
	  		  message.setMsg("该用户不存在");
	  		  return  message ;
	  	   }
		return message ;
	}
	
	
	@RequestMapping(value="/getStudyInfoByUserId", method=RequestMethod.POST)
	@ResponseBody 
	public  StudyInfoListMessage      getStudyInfoByUserId(
			
			@RequestParam(value="category_id") String category_id,			
			@RequestParam(value="userid") String userid,
			@RequestParam(value="currPage",required=false,defaultValue="1") Integer currPage,
			@RequestParam(value="pageSize",required=false,defaultValue="10") Integer pageSize 
			) {
		
		
		StudyInfoListMessage message = new StudyInfoListMessage ();
		
		 List<StudyQuestion> data = new ArrayList<StudyQuestion>();
		
    		int start = (currPage - 1) * pageSize;
    	    int end = currPage * pageSize*4;//每道题有4个答案  所以一道题会有4个记录		记录条数会多4倍	    	    
    	   
    	    SsmQuestionStudyExample  ssmQuestionStudyExample = new SsmQuestionStudyExample();
    	    SsmQuestionStudyExample.Criteria     ssmQuestionStudyCriteria    =  ssmQuestionStudyExample.createCriteria(); 
    	    // 判断flag
    	    ssmQuestionStudyCriteria.andFlagEqualTo((byte)1);
    	    ssmQuestionStudyCriteria.andKindEqualTo((byte)2);//'1已掌握，2未掌握'  只显示未掌握的
    	    long sumCount  =  ssmQuestionStudyService.countByExample(ssmQuestionStudyExample);
    	    
    	    int sumPage =    (int) Math.ceil(Double.valueOf(sumCount)/pageSize)    ;  			    	    
    	    data=ssmQuestionStudyService.getStudyInfoByUserId( category_id, start, end, userid); 
    	    
    	    if(data!=null&&data.size()>0) {
    	    	for (int i = 0; i < data.size(); i++) {
    	    		StudyQuestion studyQuestion = data.get(i);
    	    		List<StudyOption> studyOptionList  = studyQuestion.getStudyOptionList();
					for (int j = 0; j < studyOptionList.size(); j++) {
						StudyOption studyOption = studyOptionList.get(j);
						studyOption.setFlag("0");
					}

				}

    	    	 message.setCode("1");
				 message.setMsg("数据查询成功");
				
				 message.setCurrPage(String.valueOf(currPage));
				 message.setSumPage(String.valueOf(sumPage));
				 message.setData(data);
    	    }else {
    	    	 message.setCode("0");
				 message.setMsg("查询不到数据");
    	    }
		return message ;
	}
	
	
	@RequestMapping(value="/saveStudy", method=RequestMethod.POST)
	@ResponseBody 
	public Message saveStudy(
			
			@RequestParam(value="category_pid" ,defaultValue="") String category_pid,
			@RequestParam(value="category_id") String category_id,			
			@RequestParam(value="userid") String userid,
			@RequestParam(value="ansers") String ansers
			
			) {		
		    Message message = new Message();
		    List<AnserDto> anserList = JSON.parseArray(ansers, AnserDto.class);
		    QuestionStudyModel questionStudyModel = new QuestionStudyModel();
		    questionStudyModel.setUserid(userid);
		    questionStudyModel.setCategoryid(category_id);
		    questionStudyModel.setCategorypid(category_pid);
		    questionStudyModel.setAnserList(anserList);
		    int index = ssmQuestionStudyService.saveStudyAll(questionStudyModel);
		    
		    if(index>0) {
		    	message.setCode("1");
		    	message.setMsg("数据保存成功");
		    }else {
		    	
		    	message.setCode("0");
		    	message.setMsg("数据保存失败");
		    }
		
		return message ;
	}
	@RequestMapping(value="/updateStudyKind", method=RequestMethod.POST)
	@ResponseBody 
	public Message updateStudyKind(
			@RequestParam(value="userid") String userid,
			@RequestParam(value="id") String id
			) {
	    Message message = new Message();
	    
	  
	    SsmQuestionStudy ssmQuestionStudy = new SsmQuestionStudy();
	    ssmQuestionStudy.setKind((byte)1);//'1已掌握，2未掌握',  从未掌握状态改成已掌握状态
	    ssmQuestionStudy.setId(Integer.valueOf(id));
	    ssmQuestionStudy.setUserid(userid);
	    int index = ssmQuestionStudyService.updateByPrimaryKeySelective(ssmQuestionStudy);
	    if(index>0) {
	    	message.setCode("1");
	    	message.setMsg("数据更新成功");
	    	
	    }else {
	    	
	    	message.setCode("0");
	    	message.setMsg("数据查询失败");
	    }
	    
	    
	    return   message ;
	}
}
