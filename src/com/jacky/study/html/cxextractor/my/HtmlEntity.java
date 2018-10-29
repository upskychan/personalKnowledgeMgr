package com.jacky.study.html.cxextractor.my;

import java.util.ArrayList;
import java.util.List;

public class HtmlEntity {
	private String title;
	private String content;
	private List<ImgEntity> pics = new ArrayList<ImgEntity>();
	
	public HtmlEntity(String title) {
		this.title = title;
		this.content = "";
	}

	public HtmlEntity(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<ImgEntity> getPics() {
		return pics;
	}

	public void setPics(List<ImgEntity> pics) {
		this.pics = pics;
	}

}
