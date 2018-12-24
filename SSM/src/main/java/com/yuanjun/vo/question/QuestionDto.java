package com.yuanjun.vo.question;

public class QuestionDto {
	
	
	private String questionid;
	// title 标题 string
	private String title;
	private String categoryPidTitle;
	private String categoryidTitle;
	private String chapterTitle;
	// type 1单选题2多选题3判断题
	private String type;
	// status试题状态 1有效，2无效
	private String status;
	private String addtime;
	private String browse;
	private String kind;
	private String sort_no;
	
	
	public String getSort_no() {
		return sort_no;
	}
	public void setSort_no(String sort_no) {
		this.sort_no = sort_no;
	}
	public String getQuestionid() {
		return questionid;
	}
	public void setQuestionid(String questionid) {
		this.questionid = questionid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategoryPidTitle() {
		return categoryPidTitle;
	}
	public void setCategoryPidTitle(String categoryPidTitle) {
		this.categoryPidTitle = categoryPidTitle;
	}
	public String getCategoryidTitle() {
		return categoryidTitle;
	}
	public void setCategoryidTitle(String categoryidTitle) {
		this.categoryidTitle = categoryidTitle;
	}
	public String getChapterTitle() {
		return chapterTitle;
	}
	public void setChapterTitle(String chapterTitle) {
		this.chapterTitle = chapterTitle;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	public String getBrowse() {
		return browse;
	}
	public void setBrowse(String browse) {
		this.browse = browse;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	
	  
	  
	
	  
	  
	
	  

}
