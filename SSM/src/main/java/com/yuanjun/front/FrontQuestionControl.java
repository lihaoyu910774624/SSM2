package com.yuanjun.front;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuanjun.bean.SsmQuestion;
import com.yuanjun.bean.SsmQuestionExample;
import com.yuanjun.bean.SsmQuestionStudy;
import com.yuanjun.bean.SsmQuestionStudyExample;
import com.yuanjun.bean.SsmVipRecord;
import com.yuanjun.bean.SsmVipRecordExample;
import com.yuanjun.comm.Message;
import com.yuanjun.service.SsmQuestionOptionService;
import com.yuanjun.service.SsmQuestionService;
import com.yuanjun.service.SsmQuestionStudyService;
import com.yuanjun.service.SsmUserService;
import com.yuanjun.service.SsmVipRecordService;
import com.yuanjun.vo.UserInfo;
import com.yuanjun.vo.FrontQuestion.TrainingOption;
import com.yuanjun.vo.FrontQuestion.TrainingQuestion;
import com.yuanjun.vo.FrontQuestion.TrainingQuestionListMessage;

@Controller
@RequestMapping("/FrontQuestion")
@CrossOrigin
public class FrontQuestionControl {
	@Autowired
	private   SsmQuestionStudyService ssmQuestionStudyService ;
	@Autowired
	private SsmVipRecordService ssmVipRecordService ;
	@Autowired
	private   SsmUserService ssmUserService;
	@Autowired
	private SsmQuestionOptionService ssmQuestionOptionService ;
	@Autowired
	 private   SsmQuestionService ssmQuestionService;
	@RequestMapping(value="/chapterTraining", method=RequestMethod.POST)
	@ResponseBody 
	public TrainingQuestionListMessage chapterTraining(
			@RequestParam(value="category_pid" ,defaultValue="") String category_pid,
			@RequestParam(value="category_id") String category_id,
			@RequestParam(value="chapter_id") String chapter_id,
			@RequestParam(value="userid") String userid,
			@RequestParam(value="currPage",required=false,defaultValue="1") Integer currPage,
			@RequestParam(value="pageSize",required=false,defaultValue="85") Integer pageSize 
			
			) {
		
		TrainingQuestionListMessage message = new TrainingQuestionListMessage ();
		List<TrainingQuestion> data = new ArrayList<TrainingQuestion>();
		if("".equals(category_pid)) {
			
			message.setCode("0");
			message.setMsg("pid不能位空");	
			return message ;
		}
		List<String> ids = new ArrayList<String>();
		ids.add("1");
		ids.add("2");
		ids.add("3");		
			if(!ids.contains(category_pid)) {
				message.setCode("0");
				message.setMsg("pid不在有效取值范围内");			
				return message ;
			}
			
			if("1".equals(category_pid)) {
				message.setCategoryPidTitle("保险高管任职资格考试(中介)");
				
			}
			if("2".equals(category_pid)) {
				message.setCategoryPidTitle("保险高管任职资格考试(寿险)");
				
			}
			if("3".equals(category_pid)) {
				message.setCategoryPidTitle("保险高管任职资格考试(产险)");
				
			}
		// 首先 验证身份  免费用户  ，或者是没有购买产品的用户 只能是免费的题
		UserInfo user    =ssmUserService.getUserInfoById(userid);
		if(user==null) {
			
    	    long danxuan = ssmQuestionService.countByType(category_pid, category_id, chapter_id, 1, 1);
    	    
    	    long duoxuan = ssmQuestionService.countByType(category_pid, category_id, chapter_id, 1, 2);
    	  
    	    long panduan = ssmQuestionService.countByType(category_pid, category_id, chapter_id, 1, 3);
    	    
			// 该用户没有登陆 游客身份 只能显示15道题
			 data=ssmQuestionService.findTrainingQuestionFree(category_pid, category_id,chapter_id, 0, 14,userid);
			if (data != null && data.size() > 0) {
				for (int i = 0; i < data.size(); i++) {
					TrainingQuestion trainingQuestion = data.get(i);
					List<TrainingOption> options = trainingQuestion.getOption();
					for (int j = 0; j < options.size(); j++) {
						TrainingOption TrainingOption = options.get(j);
						TrainingOption.setFlag("0");
					}

				}

			}else {
				
				 message.setCode("0");
				 message.setMsg("查询不到数据");
				 return message ;
			}

			 message.setCode("1");
			 message.setMsg("游客身份只能显示15题");
			 message.setCurrPage("1");
			 message.setSumPage("1");
			 message.setDanxuan(danxuan);
			 message.setDuoxuan(duoxuan);
			 message.setPanduan(panduan);
			 message.setData(data);
			 return message ;
		}else {
			SsmVipRecordExample  ssmVipRecordExample = new SsmVipRecordExample ();
			SsmVipRecordExample.Criteria ssmVipRecordCriteria = ssmVipRecordExample.createCriteria();
			ssmVipRecordCriteria.andFlagEqualTo((byte)1);
			ssmVipRecordCriteria.andCategoryidEqualTo(Integer.valueOf(category_id));
			ssmVipRecordCriteria.andCategorypidEqualTo(Integer.valueOf(category_pid));
			ssmVipRecordCriteria.andUserIdEqualTo(userid);
			List<SsmVipRecord> ssmVipRecordList = ssmVipRecordService.selectByExample(ssmVipRecordExample);
			    if(ssmVipRecordList!=null&&ssmVipRecordList.size()>0) {
			    	
			    	SsmVipRecord ssmVipRecord = ssmVipRecordList.get(0); 
			    	long exprietime = ssmVipRecord.getExprietime();
			    	long now = (int)System.currentTimeMillis()/1000;
			    	if(now<exprietime) {
			    		// vip 还在有效期内  显示所有题的内容
			    		int start = (currPage - 1) * pageSize;
			    	    int end = currPage * pageSize;			    	    
			    	    SsmQuestionExample example = new SsmQuestionExample();
			    	    SsmQuestionExample.Criteria ssmQuestionExampleCriteria = example.createCriteria();
			    	    ssmQuestionExampleCriteria.andFlagEqualTo((byte)1);	     
			    	    long sumCount  =  ssmQuestionService.countByExample(example);
			    	    int sumPage =    (int) Math.ceil(Double.valueOf(sumCount)/pageSize)    ;  			    	    
			    	    data=ssmQuestionService.findTrainingQuestion(category_pid, category_id,chapter_id, start, end,userid); 
			    	    long danxuan = ssmQuestionService.countByType(category_pid, category_id, chapter_id, 2, 1);
			    	    
			    	    long duoxuan = ssmQuestionService.countByType(category_pid, category_id, chapter_id, 2, 2);
			    	  
			    	    long panduan = ssmQuestionService.countByType(category_pid, category_id, chapter_id, 2, 3);
			    	    if(data!=null&&data.size()>0) {
			    	    	for (int i = 0; i < data.size(); i++) {
								TrainingQuestion trainingQuestion = data.get(i);
								List<TrainingOption> options = trainingQuestion.getOption();
								for (int j = 0; j < options.size(); j++) {
									TrainingOption TrainingOption = options.get(j);
									TrainingOption.setFlag("0");
								}

							}

			    	    	 message.setCode("1");
							 message.setMsg("数据查询成功");
							 message.setDanxuan(danxuan);
							 message.setDuoxuan(duoxuan);
							 message.setPanduan(panduan);
							 message.setCurrPage(String.valueOf(currPage));
							 message.setSumPage(String.valueOf(sumPage));
							 message.setData(data);
			    	    }else {
			    	    	 message.setCode("0");
							 message.setMsg("查询不到数据");
			    	    }
			    	     
			    		
			    	}else {

			    	    long danxuan = ssmQuestionService.countByType(category_pid, category_id, chapter_id, 1, 1);
			    	    
			    	    long duoxuan = ssmQuestionService.countByType(category_pid, category_id, chapter_id, 1, 2);
			    	  
			    	    long panduan = ssmQuestionService.countByType(category_pid, category_id, chapter_id, 1, 3);
			    		// vip 过期  至显示免费题目
			    		 data=ssmQuestionService.findTrainingQuestionFree(category_pid, category_id,chapter_id, 0, 14,userid);
			    		 if (data != null && data.size() > 0) {
			 				for (int i = 0; i < data.size(); i++) {
			 					TrainingQuestion trainingQuestion = data.get(i);
			 					List<TrainingOption> options = trainingQuestion.getOption();
			 					for (int j = 0; j < options.size(); j++) {
			 						TrainingOption TrainingOption = options.get(j);
			 						TrainingOption.setFlag("0");
			 					}

			 				}

			 			}else {
			 				
			 				 message.setCode("0");
							 message.setMsg("查询不到数据");
			 			}
						 message.setCode("1");
						 message.setMsg("成功");
						 message.setDanxuan(danxuan);
						 message.setDuoxuan(duoxuan);
						 message.setPanduan(panduan);
						 message.setCurrPage("1");
						 message.setSumPage("1");
						 message.setData(data);
						 return message ;
			    		
			    		
			    	}
			    } else {
		    	    long danxuan = ssmQuestionService.countByType(category_pid, category_id, chapter_id, 1, 1);
		    	    
		    	    long duoxuan = ssmQuestionService.countByType(category_pid, category_id, chapter_id, 1, 2);
		    	  
		    	    long panduan = ssmQuestionService.countByType(category_pid, category_id, chapter_id, 1, 3);
		    		// 没有查找到购买记录  显示免费题目
		    		 data=ssmQuestionService.findTrainingQuestionFree(category_pid, category_id,chapter_id, 0, 14,userid);
					 message.setCode("1");
					 message.setMsg("成功");
					 message.setDanxuan(danxuan);
					 message.setDuoxuan(duoxuan);
					 message.setPanduan(panduan);
					 message.setCurrPage("1");
					 message.setSumPage("1");
					 message.setData(data);
					 return message ;
			    }
			
		}
		return message ;
	}
	
	@RequestMapping(value="/saveQuestionStudy", method=RequestMethod.POST)
	@ResponseBody 
	public Message saveQuestionStudy( 
			@RequestParam(value="userid") String userid,
			@RequestParam(value="questionid") String questionid,
			@RequestParam(value="category_pid") String category_pid,
			@RequestParam(value="category_id") String category_id,
			@RequestParam(value="chapter_id") String chapter_id,
			@RequestParam(value="myanser") String myanser
			
			)
	{
		Message message = new Message();
		List<String> ids = new ArrayList<String>();
		ids.add("1");
		ids.add("2");
		ids.add("3");		
			if(!ids.contains(category_pid)) {
				message.setCode("0");
				message.setMsg("pid不在有效取值范围内");			
				return message ;
			}
		
		SsmQuestionStudy ssmQuestionStudy = new SsmQuestionStudy ();
		ssmQuestionStudy.setUserid(userid);
		ssmQuestionStudy.setQuestionid(questionid);
		ssmQuestionStudy.setCategoryid(Byte.valueOf(category_id));
		ssmQuestionStudy.setCategorypid(Byte.valueOf(category_pid));
		ssmQuestionStudy.setChapterid(chapter_id);
		ssmQuestionStudy.setMyanser(myanser);
		
		
		
		SsmQuestionExample example = new SsmQuestionExample();
	    SsmQuestionExample.Criteria ssmQuestionExampleCriteria = example.createCriteria();
	    ssmQuestionExampleCriteria.andFlagEqualTo((byte)1);
	    ssmQuestionExampleCriteria.andCategoryidEqualTo(Byte.valueOf(category_pid));
	    ssmQuestionExampleCriteria.andSubjectidEqualTo(Byte.valueOf(category_id));
	    ssmQuestionExampleCriteria.andChapteridEqualTo(chapter_id);
	    ssmQuestionExampleCriteria.andQuestionidEqualTo(questionid);
	    List<SsmQuestion> ssmQuestionList =  ssmQuestionService.selectByExample(example);
	    if(ssmQuestionList!=null&&ssmQuestionList.size()>0) {
	    	SsmQuestion ssmQuestion = ssmQuestionList.get(0);
	    	System.out.println(ssmQuestion.toString());
	    	if("1".equals(String.valueOf(ssmQuestion.getType()))||"3".equals(String.valueOf(ssmQuestion.getType()))) {
	    		
					    		String correctanswer = ssmQuestion.getCorrectanswer();
					    		System.out.println(correctanswer);
					    		if(myanser.equals(ssmQuestion.getCorrectanswer())) {
					    			ssmQuestionStudy.setKind((byte)1);	
					    			ssmQuestionStudy.setStatus((byte)1);
					    			
					    		}else {
					    			ssmQuestionStudy.setKind((byte)2);	
					    			ssmQuestionStudy.setStatus((byte)2);
					    		}
	    	}else {
	    		
				String[] arrMyanser = myanser.split(",");
				Arrays.sort(arrMyanser);
				String correctanswer = ssmQuestion.getCorrectanswer();
				String[] arrCorrectanswer = correctanswer.split(",");
				Arrays.sort(arrCorrectanswer);
				Boolean isRight = Arrays.equals(arrMyanser, arrCorrectanswer);
	    	    if(isRight) {
	    	    	ssmQuestionStudy.setKind((byte)1);	
	    			ssmQuestionStudy.setStatus((byte)1);
	    	    	
	    	    }else {
	    	    	ssmQuestionStudy.setKind((byte)2);	
	    			ssmQuestionStudy.setStatus((byte)2);
	    	    }
	    	
	    	}
	    	
	    }
	    
	    
	    
	    SsmQuestionStudyExample ssmQuestionStudyExample = new SsmQuestionStudyExample();
	    SsmQuestionStudyExample.Criteria  ssmQuestionStudyCriteria =  ssmQuestionStudyExample.createCriteria();
	    ssmQuestionStudyCriteria.andFlagEqualTo((byte)1);
	    ssmQuestionStudyCriteria.andCategoryidEqualTo(Byte.valueOf(category_id));
	    ssmQuestionStudyCriteria.andCategorypidEqualTo(Byte.valueOf(category_pid));
	    ssmQuestionStudyCriteria.andUseridEqualTo(userid);
	    ssmQuestionStudyCriteria.andQuestionidEqualTo(questionid);
	    List<SsmQuestionStudy> studyList = ssmQuestionStudyService.selectByExample(ssmQuestionStudyExample);
	    int index = 0;
	     if(studyList!=null&&studyList.size()>0) {
	    	 index = ssmQuestionStudyService.updateByExampleSelective(ssmQuestionStudy, ssmQuestionStudyExample);
	     } else {
	    	 index =ssmQuestionStudyService.insertSelective(ssmQuestionStudy);
	     }
	    
	    
		   
		  if(index>0) {
			  message.setCode("1");
			  message.setMsg("数据保存成功");
		  }else {
			  message.setCode("1");
			  message.setMsg("数据保存失败");
		  }
		  // 章节总题数
		  
		  
		  
		return message ;
	}
	
	
	
	
	
	
	
	
}
