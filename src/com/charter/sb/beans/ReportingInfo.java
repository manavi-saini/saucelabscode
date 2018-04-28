package com.charter.sb.beans;

import java.util.Calendar;
import java.util.Date;

public class ReportingInfo {
	
	public Calendar executionStartTime;
	public Calendar executionEndTime;
	public String moduleStartTime;
	public Date moduleEndTime;
	public Date TestStartTime;
	public Date TestEndTime;
	
	
	public Calendar getExecutionStartTime() {
		return executionStartTime;
	}
	public void setExecutionStartTime(Calendar calendar) {
		this.executionStartTime = calendar;
	}
	public Calendar getExecutionEndTime() {
		return executionEndTime;
	}
	public void setExecutionEndTime(Calendar executionEndTime) {
		this.executionEndTime = executionEndTime;
	}
	public String getModuleStartTime() {
		return moduleStartTime;
	}
	public void setModuleStartTime(String moduleStartTime) {
		this.moduleStartTime = moduleStartTime;
	}
	public Date getModuleEndTime() {
		return moduleEndTime;
	}
	public void setModuleEndTime(Date moduleEndTime) {
		this.moduleEndTime = moduleEndTime;
	}
	public Date getTestStartTime() {
		return TestStartTime;
	}
	public void setTestStartTime(Date testStartTime) {
		TestStartTime = testStartTime;
	}
	public Date getTestEndTime() {
		return TestEndTime;
	}
	public void setTestEndTime(Date testEndTime) {
		TestEndTime = testEndTime;
	}
	


}
