package com.amd.entity;
/**
 * 该对象用于统计每个bugcheck的记录数
 * @author amyz
 * @date Apr 19, 2018 @time 9:46:24 AM
 */
public class BugcheckCount implements Comparable<BugcheckCount>{
	
	private String bugcheck;
	
	private long number;

	public BugcheckCount() {  
		super();   
	}

	public BugcheckCount(String bugcheck, long number) {
		super();
		this.bugcheck = bugcheck;
		this.number = number;
	}

	public String getBugcheck() {
		return bugcheck;
	}

	public void setBugcheck(String bugcheck) {
		this.bugcheck = bugcheck;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}
	
	public int compareTo(BugcheckCount o) {
		long i = this.getNumber() - o.getNumber();
		return (int)i;
	}
	
	@Override
	public String toString() {
		return "BugcheckList [bugcheck=" + bugcheck + ", number=" + number + "]";
	}

}
