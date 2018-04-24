package com.amd.entity;
/**
 * 用来封装分析好的结果文件中的xml字符串（information字段）的节点信息
 * @author amyz
 * @date Apr 23, 2018 @time 10:24:37 AM
 */
public class ResultInfo {
	private String title;
	
	private String information;

	public ResultInfo() {
		super();
	}

	public ResultInfo(String title, String information) {
		super();
		this.title = title;
		this.information = information;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	@Override
	public String toString() {
		return "ResultInfo [title=" + title + ", information=" + information + "]";
	}
	
	
}
