package com.yuanjun.vo.frontStudy;

import java.util.List;

public class StudyQuestion {
	private    String id ;
	private    String questionid ;
	private    String title ;
	private    String type ;
	private    String correctanswer ;
	private    String myanser ;
    private	List<StudyOption> studyOptionList ;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCorrectanswer() {
		return correctanswer;
	}
	public void setCorrectanswer(String correctanswer) {
		this.correctanswer = correctanswer;
	}
	public String getMyanser() {
		return myanser;
	}
	public void setMyanser(String myanser) {
		this.myanser = myanser;
	}
	public List<StudyOption> getStudyOptionList() {
		return studyOptionList;
	}
	public void setStudyOptionList(List<StudyOption> studyOptionList) {
		this.studyOptionList = studyOptionList;
	}
    
	
	
	
	

}
