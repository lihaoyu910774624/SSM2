package com.yuanjun.vo;

import java.util.Date;

public class ArticlInfo {
	
	    private String id;

	    private String title;

	   
		private String addtime;

	    private String content;
	    private String categoryId;
	     
	    private String categoryTitle ;
	    public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAddtime() {
			return addtime;
		}

		public void setAddtime(String addtime) {
			this.addtime = addtime;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(String categoryId) {
			this.categoryId = categoryId;
		}

		public String getCategoryTitle() {
			return categoryTitle;
		}

		public void setCategoryTitle(String categoryTitle) {
			this.categoryTitle = categoryTitle;
		}

	
	

}
