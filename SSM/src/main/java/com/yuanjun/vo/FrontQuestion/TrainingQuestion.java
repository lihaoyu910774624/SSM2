package com.yuanjun.vo.FrontQuestion;

import java.util.List;

public class TrainingQuestion {
	
	private    String questionid ;
	private    String title ;
	private    String type ;
	private    String correctanswer ;
	
	private List<TrainingOption> option ;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getCorrectanswer() {
		return correctanswer;
	}
	public void setCorrectanswer(String correctanswer) {
		this.correctanswer = correctanswer;
	}
	public List<TrainingOption> getOption() {
		return option;
	}
	public void setOption(List<TrainingOption> option) {
		this.option = option;
	}
	

}
