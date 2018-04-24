package com.amd.entity;
/**
 * 实体类Results
 * @author amyz
 * @date Apr 18, 2018 @time 9:58:44 AM
 */

public class Result {
	
	private long id;
	
	private String dumpFile;
	
	private String endTime;
	
	private String bugcheck;
	
	private String summary;   
	
	private String information;

	public Result() {
		super();
	}

	public Result(int id, String dumpFile, String endTime, String bugcheck, String summary, String information) {
		super();
		this.id = id;
		this.dumpFile = dumpFile;
		this.endTime = endTime;
		this.bugcheck = bugcheck;
		this.summary = summary;
		this.information = information;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDumpFile() {
		return dumpFile;
	}

	public void setDumpFile(String dumpFile) {
		this.dumpFile = dumpFile;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getBugcheck() {
		return bugcheck;
	}

	public void setBugcheck(String bugcheck) {
		this.bugcheck = bugcheck;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	@Override
	public String toString() {
		return "Result [id=" + id + ", dumpFile=" + dumpFile + ", endTime=" + endTime + ", bugcheck=" + bugcheck
				+ ", summary=" + summary + ", information=" + information + "]";
	}	
	
}
