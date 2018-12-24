package com.yuanjun.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuanjun.bean.SsmCategory;
import com.yuanjun.bean.SsmQuestionChapter;
import com.yuanjun.bean.SsmQuestionChapterExample;
import com.yuanjun.bean.SsmQuestionChapterExample.Criteria;
import com.yuanjun.comm.AdminUtil;
import com.yuanjun.comm.CatalogListMessage;
import com.yuanjun.comm.ChapterListMessage;
import com.yuanjun.comm.ChapterMapMessage;
import com.yuanjun.comm.MapMessage;
import com.yuanjun.comm.Message;
import com.yuanjun.service.SsmCategoryService;
import com.yuanjun.service.SsmQuestionChapterService;
import com.yuanjun.vo.Catalog;
import com.yuanjun.vo.CatalogMap;
import com.yuanjun.vo.ChapterDto;
import com.yuanjun.vo.ChapterDtoListMessage;
import com.yuanjun.vo.QuestionInfo;

@Controller
@RequestMapping("/QuestionChapter")
@CrossOrigin
public class QuestionChapterControl {
	@Autowired
	private AdminUtil util ;
	@Autowired  
	private  SsmQuestionChapterService ssmQuestionChapterService ;
	@Autowired
	private SsmCategoryService ssmCategoryService ;
	@RequestMapping(value = "/findById",method=RequestMethod.POST)
	@ResponseBody	
	public ChapterMapMessage getById(
			@RequestParam(value="adminId") String adminId,
			@RequestParam(value="chapterId",required=true)String chapterId) {	
		ChapterMapMessage message = new ChapterMapMessage();
		CatalogMap data = new CatalogMap();
		Boolean isAdmin =   util.isAdmin(adminId);
		if(!isAdmin) {			
			message.setCode("0");
			message.setMsg("0");
			return message ;
		}
		Map<String,String> questionInfo =new  HashMap<String,String>();	
		List<Catalog> subject = new ArrayList<Catalog>();
		
		QuestionInfo info = ssmQuestionChapterService.getById(chapterId);
		
		if(info!=null) {
			subject = ssmQuestionChapterService.getCatalogByPid( info.getCategoryPId());
			questionInfo.put("chapterId", info.getChapterId());
			questionInfo.put("sortNo", String.valueOf(info.getSortNo()));
			questionInfo.put("title", info.getTitle());
			questionInfo.put("categoryPId", info.getCategoryPId());
			questionInfo.put("categoryTitle", info.getCategoryTitle());
			questionInfo.put("categoryId", info.getCategoryId());
			questionInfo.put("category", info.getCategory());
			questionInfo.put("addtime", info.getAddTime());
			data.setQuestionInfo(questionInfo);
			data.setSubject(subject);			
			message.setData(data);
			message.setCode("1");
			message.setMsg("数据查询成功");
			message.setData(data);
		}else {
			message.setCode("0");
			message.setMsg("没有查到数据");
			message.setData(data);
		}
		
		return message ;
		
	}
	
	@RequestMapping(value = "/queryCategory",method=RequestMethod.POST)
	@ResponseBody
	public  CatalogListMessage     queryCategory(
			
			
			@RequestParam(value="pid",required=true)String pid
			
			)
	{
		CatalogListMessage message = new CatalogListMessage();
		
		List<String> ids = new ArrayList<String>();
		ids.add("0");
		ids.add("1");
		ids.add("2");
		ids.add("3");		
			if(!ids.contains(pid)) {
				message.setCode("0");
				message.setMsg("pid不在有效取值范围内");			
				return message ;
			}
			
		
			List<Catalog> data = new ArrayList<Catalog>();
			data = ssmQuestionChapterService.getCatalogByPid(pid);
			message.setCode("1");
			message.setMsg("数据查询成功");
			message.setData(data);
		
		return message ;
	}
	
	@RequestMapping(value = "/queryCategoryIdAndPid",method=RequestMethod.POST)
	@ResponseBody
	public  ChapterDtoListMessage     queryCategoryIdAndPid(
			@RequestParam(value="adminId") String adminId,
			@RequestParam(value="categoryId") String categoryId,
			@RequestParam(value="pid",required=true)String pid
			
			)
	{
		ChapterDtoListMessage message = new ChapterDtoListMessage();
		Boolean isAdmin =   util.isAdmin(adminId);
		if(!isAdmin) {			
			message.setCode("0");
			message.setMsg("0");
			return message ;
		}
		List<String> ids = new ArrayList<String>();
		ids.add("0");
		ids.add("1");
		ids.add("2");
		ids.add("3");		
			if(!ids.contains(pid)) {
				message.setCode("0");
				message.setMsg("pid不在有效取值范围内");			
				return message ;
			}
			if(categoryId!=null&&!"".equals(categoryId)) {
				SsmCategory  category = ssmCategoryService.selectByPrimaryKey(Integer.valueOf(categoryId));
				if(category==null) {			
					message.setCode("0");
					message.setMsg("categoryId不在有效取值范围内");
					return message ;
				}else if(!category.getPid().equals(Integer.valueOf(pid))) {
					message.setCode("0");
					message.setMsg("categoryId不在有效取值范围内");
					return message ;
				}
			}
		
			List<ChapterDto> data = new ArrayList<ChapterDto>();
			data = ssmQuestionChapterService.getChapterByIdAndPid(categoryId, pid);
			message.setCode("1");
			message.setMsg("数据查询成功");
			message.setData(data);
		
		return message ;
	}
	
	
	
	@RequestMapping(value = "/findAll",method=RequestMethod.POST)
	@ResponseBody	
	public ChapterListMessage getAll(
			@RequestParam(value="adminId") String adminId,
			@RequestParam(value="categoryId")String categoryId,
			@RequestParam(value="categoryPId")String categoryPId,
			@RequestParam(value="title")String title,
			@RequestParam(value="currPage",required=false,defaultValue="1") int currPage,
			@RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize ) {
		ChapterListMessage msg = new ChapterListMessage();
		Boolean isAdmin =   util.isAdmin(adminId);
		if(!isAdmin) {			
			msg.setCode("0");
			msg.setMsg("0");
			return msg ;
		}		
		List<String> ids = new ArrayList<String>();
		ids.add("0");
		ids.add("1");
		ids.add("2");
		ids.add("3");
		if(categoryPId!=null&&!"".equals(categoryPId)) {
			if(!ids.contains(categoryPId)) {
				msg.setCode("0");
				msg.setMsg("pid不在有效取值范围内");			
				return msg ;
			}
		}
		List<QuestionInfo> data = new ArrayList<QuestionInfo>();
		
      int start = (currPage - 1) * pageSize;

      int end = currPage * pageSize;
  
      SsmQuestionChapterExample   ssmQuestionChapterExample = new SsmQuestionChapterExample();
      Criteria criteria   =ssmQuestionChapterExample.createCriteria();
      criteria.andFlagEqualTo((byte)1);
      long sumCount = ssmQuestionChapterService.countByExample(ssmQuestionChapterExample);
     
      int sumPage =    (int) Math.ceil(Double.valueOf(sumCount)/pageSize)    ;  
      data = ssmQuestionChapterService.getAll(categoryId, categoryPId, title, start, end);
     
      msg.setCode("1");
      msg.setMsg("数据查询成功");
      msg.setCurrPage(currPage);
      msg.setSumPage(sumPage);
      msg.setData(data);
		return msg ;
	}
	
	@RequestMapping(value = "/add",method=RequestMethod.POST)
	@ResponseBody
	public Message addChapter(
			@RequestParam(value="adminId") String adminId,
			@RequestParam(value="categoryId")String categoryId,
			@RequestParam(value="categoryPId")String categoryPId,
			@RequestParam(value="title")String title,
			@RequestParam(value="sortNo")String sortNo			
			) 	
	{
		Message message = new Message();
		Boolean isAdmin =   util.isAdmin(adminId);
		if(!isAdmin) {			
			message.setCode("0");
			message.setMsg("0");
			return message ;
		}
		
		List<String> ids = new ArrayList<String>();
		ids.add("0");
		ids.add("1");
		ids.add("2");
		ids.add("3");
		if(categoryPId!=null&&!"".equals(categoryPId)) {
			if(!ids.contains(categoryPId)) {
				message.setCode("0");
				message.setMsg("pid不在有效取值范围内");			
				return message ;
			}
		}
		if(categoryId!=null&&!"".equals(categoryId)) {
			SsmCategory  category = ssmCategoryService.selectByPrimaryKey(Integer.valueOf(categoryId));
			if(category==null) {			
				message.setCode("0");
				message.setMsg("categoryId不在有效取值范围内");
				return message ;
			}else if(!category.getPid().equals(Integer.valueOf(categoryPId))) {
				message.setCode("0");
				message.setMsg("categoryId不在有效取值范围内");
				return message ;
			}
		}
		
		if(title!=null&&!"".equals(title)) {
			
			if(title.length()>255) {
				message.setCode("0");
				message.setMsg("title长度大于255");
				return message ;
			}
		}
		
		
		 String chapterId = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		SsmQuestionChapter chapter = new SsmQuestionChapter();		
		chapter.setChapterId(chapterId);
		chapter.setCategoryId(Integer.valueOf(categoryId));
		chapter.setCategoryPid(Byte.valueOf(categoryPId));
		chapter.setTitle(title);
		chapter.setSortNo( Byte.valueOf(categoryPId));
	   int 	index  = ssmQuestionChapterService.insertSelective(chapter);
	   if(index>0) {
		   message.setCode("1");
		   message.setMsg("数据保存成功");
	   }else {
		   message.setCode("0");
		   message.setMsg("数据保存失败");
		   return message ;
	   }	
		return message ;
	}
	
	@RequestMapping(value = "/delete",method=RequestMethod.POST)
	@ResponseBody
	public Message deleteChapter(
			@RequestParam(value="adminId") String adminId,
			@RequestParam(value="chapterId")String chapterId  )
	
	{
		  Message message = new Message();
		  Boolean isAdmin =   util.isAdmin(adminId);
			if(!isAdmin) {			
				message.setCode("0");
				message.setMsg("0");
				return message ;
			}
		  SsmQuestionChapterExample   example = new SsmQuestionChapterExample();
	      Criteria criteria   = example.createCriteria();
	      criteria.andFlagEqualTo((byte)1);
	      criteria.andChapterIdEqualTo(chapterId);
	      SsmQuestionChapter chapter = new SsmQuestionChapter();
	      chapter.setFlag((byte)0);
	      int  index =  ssmQuestionChapterService.updateByExampleSelective(chapter, example);
	      if(index>0) {
			   message.setCode("1");
			   message.setMsg("数据删除成功");
		   }else {
			   message.setCode("0");
			   message.setMsg("数据删除失败");
			   return message ;
		   }
		return message ;
	}
	@RequestMapping(value = "/update",method=RequestMethod.POST)
	@ResponseBody
	public Message updateChapter(
			@RequestParam(value="adminId") String adminId,
			@RequestParam(value="chapterId")String chapterId ,
			@RequestParam(value="categoryId")String categoryId,
			@RequestParam(value="categoryPId")String categoryPId,
			@RequestParam(value="title")String title,
			@RequestParam(value="sortNo")String sortNo	
			) 
	
	
	{
		Message message = new Message();
		Boolean isAdmin =   util.isAdmin(adminId);
		if(!isAdmin) {			
			message.setCode("0");
			message.setMsg("0");
			return message ;
		}
		List<String> ids = new ArrayList<String>();
		ids.add("0");
		ids.add("1");
		ids.add("2");
		ids.add("3");
		if(!ids.contains(categoryPId)) {
			message.setCode("0");
			message.setMsg("pid不在有效取值范围内");			
			return message ;
		}
		SsmCategory  category = ssmCategoryService.selectByPrimaryKey(Integer.valueOf(categoryId));
		if(category==null) {			
			message.setCode("0");
			message.setMsg("categoryId不在有效取值范围内");
			return message ;
		}
		if(title.length()>255) {
			message.setCode("0");
			message.setMsg("title长度不能大于255");
			return message ;
		}
		  SsmQuestionChapterExample   example = new SsmQuestionChapterExample();
	      Criteria criteria   = example.createCriteria();
	      criteria.andFlagEqualTo((byte)1);
	      criteria.andChapterIdEqualTo(chapterId);
	      SsmQuestionChapter chapter = new SsmQuestionChapter();
	      chapter.setCategoryId(Integer.valueOf(categoryId));
	      chapter.setCategoryPid(Byte.valueOf(categoryPId));
	      chapter.setTitle(title);
	      chapter.setSortNo(Byte.valueOf(sortNo));	     
	      int  index =  ssmQuestionChapterService.updateByExampleSelective(chapter, example);
	      if(index>0) {
			   message.setCode("1");
			   message.setMsg("数据更新成功");
		   }else {
			   message.setCode("0");
			   message.setMsg("数据更新失败");
			   return message ;
		   }	
		return message ;
	}
	
	
	
	
	
	
	

}
