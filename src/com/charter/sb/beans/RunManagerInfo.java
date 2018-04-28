package com.charter.sb.beans;

public class RunManagerInfo {
	public RunManagerInfo(String strModuleName, String strManualTC,
			String strCaseName, String strBrowser, String strTestCaseId,
			String strTestProperty, String appmodule, String strJiraNo,
			String strScenario, String strUsrCat, String strTestCaseUser,
			String strTestCasePwd) {
		this.strModuleName = strModuleName;
		this.strManualTC = strManualTC;
		this.strCaseName = strCaseName;
		this.strBrowser = strBrowser;
		this.strTestCaseId = strTestCaseId;
		this.StrTestProperty = strTestProperty;
		this.Appmodule = appmodule;
		this.strJiraNo = strJiraNo;
		this.strScenario = strScenario;
		this.strUsrCat = strUsrCat;
		this.strTestCaseUser = strTestCaseUser;
		this.strTestCasePwd = strTestCasePwd;
	}
	String strModuleName ;
	String strManualTC  ;
	String strCaseName ;
	String strBrowser ;
	String strTestCaseId ;
	String StrTestProperty;
	String Appmodule ;
	String strJiraNo  ;
	String strScenario ;
	String strUsrCat;
	String strTestCaseUser;
	String strTestCasePwd ;
	String QCFileName;
	String browserVersion;
	int testCounter;
	String AppUrl;
	public String getAppUrl() {
		return AppUrl;
	}
	public void setAppUrl(String appUrl) {
		AppUrl = appUrl;
	}
	public int getTestCounter() {
		return testCounter;
	}
	public void setTestCounter(int testCounter) {
		this.testCounter = testCounter;
	}
	public String getBrowserVersion() {
		return browserVersion;
	}
	public void setBrowserVersion(String browserVersion) {
		this.browserVersion = browserVersion;
	}
	public String getQCFileName() {
		return QCFileName;
	}
	public void setQCFileName(String qCFileName) {
		QCFileName = qCFileName;
	}
	public String getStrModuleName() {
		return strModuleName;
	}
	public void setStrModuleName(String strModuleName) {
		this.strModuleName = strModuleName;
	}
	public String getStrManualTC() {
		return strManualTC;
	}
	public void setStrManualTC(String strManualTC) {
		this.strManualTC = strManualTC;
	}
	public String getStrCaseName() {
		return strCaseName;
	}
	public void setStrCaseName(String strCaseName) {
		this.strCaseName = strCaseName;
	}
	public String getStrBrowser() {
		return strBrowser;
	}
	public void setStrBrowser(String strBrowser) {
		this.strBrowser = strBrowser;
	}
	public String getStrTestCaseId() {
		return strTestCaseId;
	}
	public void setStrTestCaseId(String strTestCaseId) {
		this.strTestCaseId = strTestCaseId;
	}
	public String getStrTestProperty() {
		return StrTestProperty;
	}
	public void setStrTestProperty(String strTestProperty) {
		StrTestProperty = strTestProperty;
	}
	public String getAppmodule() {
		return Appmodule;
	}
	public void setAppmodule(String appmodule) {
		Appmodule = appmodule;
	}
	public String getStrJiraNo() {
		return strJiraNo;
	}
	public void setStrJiraNo(String strJiraNo) {
		this.strJiraNo = strJiraNo;
	}
	public String getStrScenario() {
		return strScenario;
	}
	public void setStrScenario(String strScenario) {
		this.strScenario = strScenario;
	}
	public String getStrUsrCat() {
		return strUsrCat;
	}
	public void setStrUsrCat(String strUsrCat) {
		this.strUsrCat = strUsrCat;
	}
	public String getStrTestCaseUser() {
		return strTestCaseUser;
	}
	public void setStrTestCaseUser(String strTestCaseUser) {
		this.strTestCaseUser = strTestCaseUser;
	}
	public String getStrTestCasePwd() {
		return strTestCasePwd;
	}
	public void setStrTestCasePwd(String strTestCasePwd) {
		this.strTestCasePwd = strTestCasePwd;
	}




}
