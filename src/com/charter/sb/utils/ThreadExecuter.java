package com.charter.sb.utils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;










import com.charter.sb.beans.ReportingInfo;
import com.charter.sb.beans.RunManagerInfo;

import java.net.URL;

public class ThreadExecuter extends Thread {

	public static final String USERNAME = "AnandaveluR";
	public static final String ACCESS_KEY = "83f1c268-f65f-4037-9ce8-a28aa83f4848";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY
			+ "@ondemand.saucelabs.com:80/wd/hub";
	
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
	RunManagerInfo runManagerInfoObj;
	
	public ThreadExecuter(RunManagerInfo runmangerInfo) {
		this.strModuleName = runmangerInfo.getAppmodule();
		this.strManualTC =runmangerInfo.getStrManualTC() ;
		this.strCaseName = runmangerInfo.getStrCaseName();
		this.strBrowser = runmangerInfo.getStrBrowser();
		this.strTestCaseId = runmangerInfo.getStrTestCaseId();
		this.StrTestProperty = runmangerInfo.getStrTestProperty();
		this.Appmodule = runmangerInfo.getAppmodule();
		this.strJiraNo = runmangerInfo.getStrJiraNo();
		this.strScenario = runmangerInfo.getStrScenario();
		this.strUsrCat = runmangerInfo.getStrUsrCat();
		this.strTestCaseUser = runmangerInfo.getStrTestCaseUser();
		this.strTestCasePwd = runmangerInfo.getStrTestCasePwd();
		this.runManagerInfoObj = runmangerInfo;
	}

	

	public synchronized void run() {
		RunManager runManggerObj = new RunManager();
		
		try {
		
			System.out.println("Thread state " +Thread.currentThread().getState());
			System.out.println("Thread Name " +Thread.currentThread().getName());
			ReportingFunctions sf = new ReportingFunctions();
			System.out.println(" Thread run() Method");
			sf.CreateSummaryHTML(runManagerInfoObj.getAppmodule(),runManagerInfoObj.getStrBrowser());
			
			runManggerObj.FnCom_ExecuteTC(runManagerInfoObj);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
}
