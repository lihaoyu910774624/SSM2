package com.yuanjun.vo.simulate;

import java.util.List;

public class WrongSimulateVo {
	private    String questionid ;
	private    String title ;
	private    String type ;
	private    String correctanswer ;
	private    String myanswer ;
	private    String analysis ;
	private    String  score ;
	private List<QuestionOption> option ;
	
	
	
	public String getAnalysis() {
		return analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
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

	

	public String getMyanswer() {
		return myanswer;
	}

	public void setMyanswer(String myanswer) {
		this.myanswer = myanswer;
	}

	public List<QuestionOption> getOption() {
		return option;
	}

	public void setOption(List<QuestionOption> option) {
		this.option = option;
	}
	
	
	
	

}
