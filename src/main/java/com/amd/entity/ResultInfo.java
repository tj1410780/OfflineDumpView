package com.amd.entity;
/**
 * 用来封装分析好的结果文件中的xml字符串（information字段）的节点信息
 * @author amyz
 * @date Apr 23, 2018 @time 10:24:37 AM
 */
public class ResultInfo {
	
	private int order;
	
	private String title;
	
	private String information;

	public ResultInfo() {
		super();
	}

	public ResultInfo(int order, String title, String information) {
		super();
		this.order = order;
		this.title = title;
		this.information = information;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
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
		return "ResultInfo [order=" + order + ", title=" + title + ", information=" + information + "]";
	}
	
}
