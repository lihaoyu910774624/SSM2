package com.yuanjun.front;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.yuanjun.bean.SsmQuestion;
import com.yuanjun.bean.SsmQuestionExample;
import com.yuanjun.bean.SsmQuestionStudy;
import com.yuanjun.bean.SsmQuestionStudyExample;
import com.yuanjun.bean.SsmSimulate;
import com.yuanjun.bean.SsmSimulateExample;
import com.yuanjun.bean.SsmSimulateQuestion;
import com.yuanjun.bean.SsmSimulateQuestionExample;
import com.yuanjun.bean.SsmVipRecord;
import com.yuanjun.bean.SsmVipRecordExample;
import com.yuanjun.comm.Message;
import com.yuanjun.service.SsmQuestionOptionService;
import com.yuanjun.service.SsmQuestionService;
import com.yuanjun.service.SsmQuestionStudyService;
import com.yuanjun.service.SsmSimulateQuestionService;
import com.yuanjun.service.SsmSimulateService;
import com.yuanjun.service.SsmUserService;
import com.yuanjun.service.SsmVipRecordService;
import com.yuanjun.vo.UserInfo;
import com.yuanjun.vo.FrontQuestion.TrainingOption;
import com.yuanjun.vo.FrontQuestion.TrainingQuestion;
import com.yuanjun.vo.FrontQuestion.TrainingQuestionListMessage;
import com.yuanjun.vo.simulate.MyanserSimulate;
import com.yuanjun.vo.simulate.SimulateInfo;
import com.yuanjun.vo.simulate.SimulateInfoMessage;
import com.yuanjun.vo.simulate.SimulateQuestion;
import com.yuanjun.vo.simulate.SimulateQuestionListMessage;
import com.yuanjun.vo.simulate.SimulateVo;
import com.yuanjun.vo.simulate.WrongSimulateMessage;
import com.yuanjun.vo.simulate.WrongSimulateVo;
import com.yuanjun.vo.simulateQuestion.simulateQuestionVo;

@Controller
@RequestMapping("/FrontQuestion")
@CrossOrigin
public class FrontQuestionControl {
	@Autowired
	private  SsmSimulateQuestionService  ssmSimulateQuestionService;
	@Autowired
	private SsmSimulateService ssmSimulateService ;
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
			 message.setKind("1");//表示免费用户
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
			    	long now = System.currentTimeMillis()/1000;
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
							 message.setKind("2");//表示vip用户
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

			    	    long danxuan = ssmQuestionService.countByType(category_pid, category_id, "0", 1, 1);
			    	    
			    	    long duoxuan = ssmQuestionService.countByType(category_pid, category_id, "0", 1, 2);
			    	  
			    	    long panduan = ssmQuestionService.countByType(category_pid, category_id, "0", 1, 3);
			    		// vip 过期  至显示免费题目
			    		 data=ssmQuestionService.findTrainingQuestionFree(category_pid, category_id,"0", 0, 14,userid);
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
						 message.setKind("1");//表示免费用户
						 message.setDanxuan(danxuan);
						 message.setDuoxuan(duoxuan);
						 message.setPanduan(panduan);
						 message.setCurrPage("1");
						 message.setSumPage("1");
						 message.setData(data);
						 return message ;
			    		
			    		
			    	}
			    } else {
		    	    long danxuan = ssmQuestionService.countByType(category_pid, category_id, "0", 1, 1);
		    	    
		    	    long duoxuan = ssmQuestionService.countByType(category_pid, category_id, "0", 1, 2);
		    	  
		    	    long panduan = ssmQuestionService.countByType(category_pid, category_id, "0", 1, 3);
		    		// 没有查找到购买记录  显示免费题目
		    		 data=ssmQuestionService.findTrainingQuestionFree(category_pid, category_id,"0", 0, 14,userid);
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
					 message.setKind("1");//表示免费用户
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
	
	
	@RequestMapping(value="/getSimulateQuestion", method=RequestMethod.POST)
	@ResponseBody 
	public SimulateQuestionListMessage simulateQuestion(
			@RequestParam(value="userid") String userid,			
			@RequestParam(value="category_pid") String category_pid,
			@RequestParam(value="category_id") String category_id
				
			) {
		SimulateQuestionListMessage message = new SimulateQuestionListMessage();
		SimulateVo  vo = new SimulateVo ();
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
		//校验是否为合法用户 
		UserInfo user    =ssmUserService.getUserInfoById(userid);	
			if(user==null) {
				message.setCode("0");
				message.setMsg("0");			
				return message ;
			}
			
			SsmSimulate ssmSimulate = new SsmSimulate ();
			String simulateid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		    long  startTime = System.currentTimeMillis()/1000;	       // 考试起始时间
		    long  endTime = startTime+60*70;// 70分钟后考试时间结束
			ssmSimulate.setUserid(userid);
			ssmSimulate.setSimulateid(simulateid);
			ssmSimulate.setStartTime((int)startTime);
			ssmSimulate.setEndTime((int)endTime);
			//保存新加字段 pid
			// ssmSimulate
			ssmSimulateService.insertSelective(ssmSimulate);
			
			// 将数据放入返回值总
			message.setSimulateid(simulateid);
			message.setStartTime(startTime);
			message.setEndTime(endTime);
			
		//按分类出题 判断用户是否为当前分类的付费用户
			SsmVipRecordExample  ssmVipRecordExample = new SsmVipRecordExample ();
			SsmVipRecordExample.Criteria ssmVipRecordCriteria = ssmVipRecordExample.createCriteria();
			ssmVipRecordCriteria.andFlagEqualTo((byte)1);			
			ssmVipRecordCriteria.andCategorypidEqualTo(Integer.valueOf(category_pid));
			ssmVipRecordCriteria.andCategoryidEqualTo(Integer.valueOf(category_id));
			ssmVipRecordCriteria.andUserIdEqualTo(userid);
			List<SsmVipRecord> ssmVipRecordList = ssmVipRecordService.selectByExample(ssmVipRecordExample);
			    if(ssmVipRecordList!=null&&ssmVipRecordList.size()>0) {			    	
			    	SsmVipRecord ssmVipRecord = ssmVipRecordList.get(0); 
			    	long exprietime = ssmVipRecord.getExprietime();
			    	long now = System.currentTimeMillis()/1000;
			    	if(now<exprietime) {
			    		// 获取随机id
			    		Integer id =   ssmQuestionService.getRoundId() ;
			    		
			    		// vip 还在有效期内  显示所有题的内容
			    		//付费 			    		
			    		// 单选40题
			    		List<SimulateQuestion> danxuan = new ArrayList<SimulateQuestion>();
			    		 danxuan = ssmQuestionService.getSimulateDanxuan(userid,category_id, category_pid,id,40);
			    		 if(danxuan.size()<40) {
			    			 int size = 40-danxuan.size();//不足40题的补足的数量
			    		List<SimulateQuestion>  danxuanReverse =ssmQuestionService.getSimulateReverse(userid, category_id, category_pid, id, size, 1);
			    		danxuan.addAll(danxuanReverse);//凑够40题
			    		 }
			    		
			    		// 多选 15题
			    		 List<SimulateQuestion> duoxuan = new ArrayList<SimulateQuestion>();
			    		 duoxuan = ssmQuestionService.getSimulateDuoxuan(userid, category_id,category_pid,id,15);
			    		if(duoxuan.size()<15) {
			    			 int size = 15-danxuan.size();
			    			List<SimulateQuestion>  duoxuanReverse =ssmQuestionService.getSimulateReverse(userid, category_id, category_pid, id, size, 2);
			    			duoxuan.addAll(duoxuanReverse);
			    		}
			    		
			    		
			    		// 判断30题			    
			    		List<SimulateQuestion> panduan = new ArrayList<SimulateQuestion>();
			    		 panduan = ssmQuestionService.getSimulatePanduan(userid, category_id,category_pid,id,30);
			    		 if(panduan.size()<30) {
			    			 int size = 15-panduan.size();
			    			 List<SimulateQuestion>  panduanReverse =ssmQuestionService.getSimulateReverse(userid, category_id, category_pid, id, size, 3); 
			    			 panduan.addAll(panduanReverse);
			    			 
			    		 }
			    		vo.setDanxuan(danxuan);
			    		vo.setDuoxuan(duoxuan);
			    		vo.setPanduan(panduan);
			    		message.setData(vo);
			    		
			    	}else {
			    		/*// vip 过期显示免费的题 标志物是免费的题  
			    		// 单选
			    		List<SimulateQuestion> danxuan = ssmQuestionService.getSimulateQuestionFree(userid, category_pid, "1");
			    		// 多选 
			    		List<SimulateQuestion> duoxuan = ssmQuestionService.getSimulateQuestionFree(userid, category_pid, "2");
			    		// 判断			    		
			    		List<SimulateQuestion> panduan = ssmQuestionService.getSimulateQuestionFree(userid, category_pid, "3");
			    		vo.setDanxuan(danxuan);
			    		vo.setDuoxuan(duoxuan);
			    		vo.setPanduan(panduan);*/
			    		//message.setData(vo);
			    		message.setCode("0");
						message.setMsg("0");			
						return message ;
			    		
			    	}
			    }else {
			    	/*//没有付费则返回免费15题
			    	// 单选
		    		List<SimulateQuestion> danxuan = ssmQuestionService.getSimulateQuestionFree(userid, category_pid, "1");
		    		// 多选 
		    		List<SimulateQuestion> duoxuan = ssmQuestionService.getSimulateQuestionFree(userid, category_pid, "2");
		    		// 判断			    		
		    		List<SimulateQuestion> panduan = ssmQuestionService.getSimulateQuestionFree(userid, category_pid, "3");
		    		vo.setDanxuan(danxuan);
		    		vo.setDuoxuan(duoxuan);
		    		vo.setPanduan(panduan);
		    		message.setData(vo);*/
		    		message.setCode("0");
					message.setMsg("0");			
					return message ;
			    	
			    }
			    message.setCode("1");
				message.setMsg("成功");
		return message ;
	}
	
	
	
	@RequestMapping(value="/saveSimulateQuestion", method=RequestMethod.POST)
	@ResponseBody 
	public Message saveSimulateQuestion(
			@RequestParam(value="userid") String userid,
			@RequestParam(value="simulateid")  String simulateid ,
			@RequestParam(value="myanser") String myanser,
			@RequestParam(value="category_pid") String category_pid,
			@RequestParam(value="category_id") String category_id
			) {		
		  Message message = new Message ();
		  List<simulateQuestionVo> list = new ArrayList<simulateQuestionVo>();
		//解析 myanser 100条记录
		List<MyanserSimulate> myanserSimulateList = JSON.parseArray(myanser, MyanserSimulate.class);
		
		
		//校验是否为合法用户 
				UserInfo user    =ssmUserService.getUserInfoById(userid);	
					if(user==null) {
						message.setCode("0");
						message.setMsg("0");			
						return message ;
					}
					SsmVipRecordExample  ssmVipRecordExample = new SsmVipRecordExample ();
					SsmVipRecordExample.Criteria ssmVipRecordCriteria = ssmVipRecordExample.createCriteria();
					ssmVipRecordCriteria.andFlagEqualTo((byte)1);
					ssmVipRecordCriteria.andCategorypidEqualTo(Integer.valueOf(category_pid));
					ssmVipRecordCriteria.andCategoryidEqualTo(Integer.valueOf(category_id));
					ssmVipRecordCriteria.andUserIdEqualTo(userid);
					List<SsmVipRecord> ssmVipRecordList = ssmVipRecordService.selectByExample(ssmVipRecordExample);
					    if(ssmVipRecordList!=null&&ssmVipRecordList.size()>0) {	
					    	SsmVipRecord ssmVipRecord = ssmVipRecordList.get(0); 
					    	long exprietime = ssmVipRecord.getExprietime();
					    	long now = System.currentTimeMillis()/1000;
					    	int sumScore = 0;//记录得分总数
					    	if(now<exprietime) {
					    		// 保存100条记录
					    		for(int i=0;i<myanserSimulateList.size();i++) {
					    			MyanserSimulate anser= myanserSimulateList.get(i);
					    			simulateQuestionVo  vo = new simulateQuestionVo ();
					    			//SsmSimulateQuestion simulate = new SsmSimulateQuestion();
					    			/*simulate.setSimulateid(simulateid);
					    			simulate.setQuestionid(anser.getQuestionid());
					    			simulate.setMyanswer(anser.getMyanser());
					    			simulate.setScore((byte)anser.getScore());
					    			simulate.setFlag((byte)1);
					    			ssmSimulateQuestionService.insertSelective(simulate);*/
					    			
					    			vo.setSimulateid(simulateid);
					    			vo.setQuestionid(anser.getQuestionid());
					    			vo.setMyanswer(anser.getMyanser());
					    			vo.setScore(anser.getScore());
					    			list.add(vo);
					    			
					    			sumScore=sumScore+anser.getScore();
					    		}
					    		//批量保存
					    	 int index =	ssmSimulateQuestionService.saveAllSimulateQuestion(list);
					    	 if(index>0) {
					    		 //数据保存成功 不做更改
					    	 }else {
					    		 message.setCode("0");
									message.setMsg("数据保存失败");			
									return message ;
					    		 
					    	 }
					    		// 添加更新ssm_simulate 分数
					    		SsmSimulateExample ssmSimulateExample = new SsmSimulateExample();
					    		SsmSimulateExample.Criteria ssmSimulateExampleCriteria = ssmSimulateExample.createCriteria();
					    		ssmSimulateExampleCriteria.andFlagEqualTo((byte)1);
					    		ssmSimulateExampleCriteria.andSimulateidEqualTo(simulateid);
					    		SsmSimulate ssmSimulate = new SsmSimulate();
					    		ssmSimulate.setScore(sumScore);
					    		ssmSimulateService.updateByExampleSelective(ssmSimulate, ssmSimulateExample);
					    	}else {
					    		message.setCode("0");
								message.setMsg("0");			
								return message ;
					    	}
					    	
					    }else {
					    	message.setCode("0");
							message.setMsg("0");			
							return message ;
					    }	    		
					
		
		message.setCode("1");
		message.setMsg("保存成功");
		return message ;
	}
	
	
	
	
	@RequestMapping(value="/getSimulateInfo", method=RequestMethod.POST)
	@ResponseBody 
	public SimulateInfoMessage getSimulateInfo(
			@RequestParam(value="userid") String userid) {
		SimulateInfoMessage message = new SimulateInfoMessage ();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<SimulateInfo> data = new ArrayList<>();
		data =  ssmSimulateService.getSimulateInfo(userid);
		if(data!=null&&data.size()>0) {
			for(int i=0;i<data.size();i++) {
				SimulateInfo info = new SimulateInfo ();
				info = data.get(i);
				Date date = new Date(Long.valueOf(info.getStart_time())*1000L);
				String sDateTime = sdf.format(date); 
				info.setStart_time(sDateTime);
			}
		}
		
		message.setCode("1");
		message.setMsg("成功");
		message.setData(data);
		return message ;
	}
	
	@RequestMapping(value="/getWrongSimulate", method=RequestMethod.POST)
	@ResponseBody 
	public WrongSimulateMessage getWrongSimulate(
			@RequestParam(value="userid") String userid,
			@RequestParam(value="simulateid") String simulateid) {
		WrongSimulateMessage message = new WrongSimulateMessage();
		SsmSimulateExample ssmSimulateExample = new SsmSimulateExample ();
		SsmSimulateExample.Criteria ssmSimulateExampleCriteria = ssmSimulateExample.createCriteria();
		ssmSimulateExampleCriteria.andUseridEqualTo(userid);
		ssmSimulateExampleCriteria.andSimulateidEqualTo(simulateid);
		ssmSimulateExampleCriteria.andFlagEqualTo((byte)1);
		List<SsmSimulate> ssmSimulateList =   ssmSimulateService.selectByExample(ssmSimulateExample);
		List<WrongSimulateVo> data = new ArrayList<WrongSimulateVo>();
		if(ssmSimulateList!=null&&ssmSimulateList.size()>0) {
			
		 data= ssmSimulateQuestionService.getWrongSimulate(simulateid);
		 message.setCode("1");
		 message.setMsg("获取成功");
		 message.setData(data);
			
		}else {
			 message.setCode("0");
			 message.setMsg("获取失败");	
		}
		return message ;
	}
	@RequestMapping(value="/updateSimulateScore", method=RequestMethod.POST)
	@ResponseBody
	public Message updateSimulateScore(
			@RequestParam(value="userid") String userid,
			@RequestParam(value="simulateid") String simulateid,
			@RequestParam(value="type") String type ,
			@RequestParam(value="questionid") String questionid 
			) {
		Message message = new  Message ();
		
		
			
			SsmSimulateQuestionExample ssmSimulateQuestionExample = new SsmSimulateQuestionExample();
			SsmSimulateQuestionExample.Criteria ssmSimulateQuestionExampleCriteria = ssmSimulateQuestionExample.createCriteria();
			ssmSimulateQuestionExampleCriteria.andSimulateidEqualTo(simulateid);
			ssmSimulateQuestionExampleCriteria.andQuestionidEqualTo(questionid);
			SsmSimulateQuestion ssmSimulateQuestion = new SsmSimulateQuestion();
			if("1".equals(type)||"3".equals(type)) {
				ssmSimulateQuestion.setScore((byte)1);
				
				
			}else if("2".equals(type)) {
				
				ssmSimulateQuestion.setScore((byte)2);
			}
			
			int index = ssmSimulateQuestionService.updateByExampleSelective(ssmSimulateQuestion, ssmSimulateQuestionExample);
			if(index>0) {
				message.setCode("1");
				message.setMsg("操作成功");
			}else {
				message.setCode("0");
				message.setMsg("操作失败");
			}
			SsmSimulateExample ssmSimulateExample = new SsmSimulateExample ();
			SsmSimulateExample.Criteria ssmSimulateExampleCriteria = ssmSimulateExample.createCriteria();
			ssmSimulateExampleCriteria.andUseridEqualTo(userid);
			ssmSimulateExampleCriteria.andSimulateidEqualTo(simulateid);
			ssmSimulateExampleCriteria.andScoreEqualTo(0);
			long count = ssmSimulateService.countByExample(ssmSimulateExample);
		    if(count==0) {
		    	SsmSimulate ssmSimulate = new SsmSimulate ();
		    	ssmSimulate.setFlag((byte)0);
		    	ssmSimulateService.updateByExampleSelective(ssmSimulate, ssmSimulateExample);
		    }
		
	  return	 message ;
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
	    		
				String[] arrMyanser = myanser.split("");
				Arrays.sort(arrMyanser);
				String correctanswer = ssmQuestion.getCorrectanswer();
				String[] arrCorrectanswer = correctanswer.split("");
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
