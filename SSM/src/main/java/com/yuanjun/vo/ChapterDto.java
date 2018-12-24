package com.yuanjun.vo;

public class ChapterDto {
    private String chapterId ;
    private String title ;
	public String getChapterId() {
		return chapterId;
	}
	public void setChapterId(String chapterId) {
		this.chapterId = chapterId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "ChapterDto [chapterId=" + chapterId + ", title=" + title + "]";
	}
	
    
}
