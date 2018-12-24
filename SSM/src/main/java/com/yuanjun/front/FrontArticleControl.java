package com.yuanjun.front;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuanjun.bean.SsmCategory;
import com.yuanjun.bean.SsmCategoryExample;
import com.yuanjun.bean.SsmQuestionChapter;
import com.yuanjun.bean.SsmQuestionChapterExample;
import com.yuanjun.bean.SsmQuestionExample;
import com.yuanjun.bean.SsmQuestionStudyExample;
import com.yuanjun.service.SsmCategoryService;
import com.yuanjun.service.SsmQuestionChapterService;
import com.yuanjun.service.SsmQuestionService;
import com.yuanjun.service.SsmQuestionStudyService;
import com.yuanjun.vo.front.CatalongListMessage;
import com.yuanjun.vo.front.Chapter;
import com.yuanjun.vo.front.Subject;

@Controller
@RequestMapping("/Front")
@CrossOrigin
public class FrontArticleControl {
	@Autowired
	private   SsmQuestionStudyService ssmQuestionStudyService ;
	@Autowired
	private SsmCategoryService ssmCategoryService ;
	@Autowired  
	private  SsmQuestionChapterService ssmQuestionChapterService ;
	@Autowired
	 private   SsmQuestionService ssmQuestionService;
	@RequestMapping(value="/getCatalog", method=RequestMethod.POST)
	@ResponseBody 
	public CatalongListMessage   getCatalog(
			@RequestParam(value="pid",defaultValue="")String pid,
			 @RequestParam(value="userid",defaultValue="")String userid 
			) {
		CatalongListMessage message = new CatalongListMessage();
		List<Subject> data = new ArrayList<Subject>() ;
	if("".equals(pid)) {
			
			message.setCode("0");
			message.setMsg("pid不能位空");	
			return message ;
		}
		List<String> ids = new ArrayList<String>();
		ids.add("1");
		ids.add("2");
		ids.add("3");		
			if(!ids.contains(pid)) {
				message.setCode("0");
				message.setMsg("pid不在有效取值范围内");			
				return message ;
			}
			
			if("1".equals(pid)) {
				message.setCategoryPidTitle("保险高管任职资格考试(中介)");
				
			}
			if("2".equals(pid)) {
				message.setCategoryPidTitle("保险高管任职资格考试(寿险)");
				
			}
			if("3".equals(pid)) {
				message.setCategoryPidTitle("保险高管任职资格考试(产险)");
				
			}
			
		SsmCategoryExample example = new SsmCategoryExample();
		SsmCategoryExample.Criteria  criteriaCategory = example.createCriteria();
		criteriaCategory.andFlagEqualTo((byte)1);
		criteriaCategory.andPidEqualTo(Integer.valueOf(pid));
		List<SsmCategory> ssmCategoryList = ssmCategoryService.selectByExample(example);
		
		try {
			if(ssmCategoryList!=null&& ssmCategoryList.size()>0) {			
				for(int i=0;i<ssmCategoryList.size();i++) {				
					SsmCategory ssmCategory  = ssmCategoryList.get(i);
					Subject subject = new Subject();//存放二级目录相关信息
					subject.setCategoryId(String.valueOf(ssmCategory.getId()));
					subject.setCategoryTitle(ssmCategory.getTitle());
					// 前端标记 默认值 无需操作
					subject.setFlag("0");
					// 查出question表下二级目录题目的总条数
					SsmQuestionExample ssmQuestionExample = new SsmQuestionExample();
					SsmQuestionExample.Criteria  ssmQuestionCriteria = ssmQuestionExample.createCriteria();
					ssmQuestionCriteria.andFlagEqualTo((byte)1);
					ssmQuestionCriteria.andSubjectidEqualTo(Byte.valueOf(ssmCategory.getId()+""));
					long sunCount =      ssmQuestionService.countByExample(ssmQuestionExample);
					subject.setSumCount(String.valueOf(sunCount));
					
					
					
					List<Chapter>  chapterList = new ArrayList<Chapter>();//存放章节相关信息
					SsmQuestionChapterExample  ssmQuestionChapterExample= new SsmQuestionChapterExample ();
					SsmQuestionChapterExample.Criteria ssmQuestionChapterCriteria = ssmQuestionChapterExample.createCriteria();
					ssmQuestionChapterCriteria.andFlagEqualTo((byte)1);
					ssmQuestionChapterCriteria.andCategoryIdEqualTo(ssmCategory.getId());				
					List<SsmQuestionChapter> ssmQuestionChapterList = ssmQuestionChapterService.selectByExample(ssmQuestionChapterExample);
					if(ssmQuestionChapterList!=null&&ssmQuestionChapterList.size()>0) {
						for(int j=0;j<ssmQuestionChapterList.size();j++) {
							SsmQuestionChapter ssmQuestionChapter =    ssmQuestionChapterList.get(j);
							Chapter chapter = new Chapter();
							chapter.setChapterId(ssmQuestionChapter.getChapterId());
							chapter.setChapterTitle(ssmQuestionChapter.getTitle());
							// 已经练习过的条数
							SsmQuestionStudyExample ssmQuestionStudyExample = new SsmQuestionStudyExample ();
							SsmQuestionStudyExample.Criteria  ssmQuestionStudyCriteria = ssmQuestionStudyExample.createCriteria();
							ssmQuestionStudyCriteria.andFlagEqualTo((byte)1);
							ssmQuestionStudyCriteria.andUseridEqualTo(userid);
							ssmQuestionStudyCriteria.andChapteridEqualTo(ssmQuestionChapter.getChapterId());
							long     trainCount    =  ssmQuestionStudyService.countByExample(ssmQuestionStudyExample);
							
							//章节下的总条数
							 long  total = ssmQuestionService.countByChapter(ssmQuestionChapter.getChapterId());
							 chapter.setTrainCount(trainCount);
							 chapter.setTotal(total);
							chapterList.add(chapter);
						}
					}
					
					subject.setChapterList(chapterList);
					data.add(subject);
				}
			}
		} catch (Exception e) {	
			message.setCode("0");
			message.setMsg("数据查找失败");
			e.printStackTrace();
			return message ;
		}
		message.setData(data);
		message.setCode("1");
		message.setMsg("数据查找成功");
		return message ;
	}  

}
