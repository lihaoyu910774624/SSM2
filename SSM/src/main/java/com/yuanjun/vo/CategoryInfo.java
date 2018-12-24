package com.yuanjun.vo;

import java.util.Date;

public class CategoryInfo {
	
	    private Integer id;

	    private Integer pid;

	    private String title;
	    
	    private String categoryTitle;

	    private Date addtime;
	    

		public String getCategoryTitle() {
			return categoryTitle;
		}

		public void setCategoryTitle(String categoryTitle) {
			this.categoryTitle = categoryTitle;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getPid() {
			return pid;
		}

		public void setPid(Integer pid) {
			this.pid = pid;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public Date getAddtime() {
			return addtime;
		}

		public void setAddtime(Date addtime) {
			this.addtime = addtime;
		}


}
