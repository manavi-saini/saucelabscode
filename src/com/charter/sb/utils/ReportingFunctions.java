package com.charter.sb.utils;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;	
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.imageio.ImageIO;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//import com.mercury.qualitycenter.otaclient.ClassFactory;
//import com.mercury.qualitycenter.otaclient.ITDConnection;


import com.charter.sb.beans.RunManagerInfo;
import com.charter.sb.beans.TestStepDetails;
import com.charter.sb.controllers.Initialization;
import com.charter.sb.services.CharterAppFunctions;
//import org.json.JSONWriter;

public class ReportingFunctions extends Initialization{
	public static int  stepCounter1= 0;
	public static final String INTERMEDIATE_LOGIN = "Login_During_User_Change";
	public static final String INTERMEDIATE_LOGOUT = "Logout_During_User_Change";
	public static String ExcelFileName;
	public static String StartTime;
	public static String EndTime;
	public static String ModuleStartTime;
	public static String ModuleEndTime;
	public static String appUser;
	public String[] MapKeys;
	public static int intCounter=1;
	private static List<List<HSSFCell>> cellGrid;
	public static String getBrowser;
	
	
	public static final String USERNAME = "AnandaveluR";
	public static final String ACCESS_KEY = "83f1c268-f65f-4037-9ce8-a28aa83f4848";
	public  final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
/*=====================================================================================================
	Function FnAssignEnvValues
	Parameters: None	 
	Description: This function is used assign values to a map variables
	Author: Dhivya Durairaj
	Created Date: Mar 10, 2014
	=====================================================================================================*/
	
	/*public void FnAssignEnvValues(String strBrowser,Map Env,String strManualTC)
	{
		
		m1.put("BROWSER", strBrowser);	
		m1.put("MANUALTC", strManualTC);
		assignEnvFromMap(Env);
	 
	}   */
	@SuppressWarnings("unchecked")
	public void FnAssignEnvValues(String strBrowser,Map Env,RunManagerInfo runManagerInfoObj)
	{
		
		m1.put("BROWSER", runManagerInfoObj.getStrBrowser());	
		m1.put("MANUALTC", runManagerInfoObj.getStrManualTC());
		m1.put("TESTCASEID", runManagerInfoObj.getStrTestCaseId());
		m1.put("TESTPROPERTY", runManagerInfoObj.getStrTestProperty());
		m1.put("APPMODULE", runManagerInfoObj.getAppmodule());
		m1.put("SCENARIO", runManagerInfoObj.getStrScenario());
		m1.put("JIRANO", runManagerInfoObj.getStrJiraNo());
		m1.put("USERCATEGORYY", runManagerInfoObj.getStrUsrCat());
		m1.put("USERID", runManagerInfoObj.getStrTestCaseUser());
		m1.put("PASSWORD", runManagerInfoObj.getStrTestCasePwd());
		
	
		String[] MapKeys=new String[Env.size()];
		
		Iterator itr = Env.keySet().iterator();
		int intC=0;
	    while(itr.hasNext())
	    {
	        String key = (String) itr.next();
	        MapKeys[intC]=key;
	        if(intC<Env.size())
	        {
	        	intC++;
	        }
	    }
	    
	    for(int i=0;i<MapKeys.length;i++)
	    {
	    	String strKey=MapKeys[i];
	    	String strValue=(String) Env.get(strKey).toString();
	    	//System.out.println(strKey + "--- "+ strValue);	   
	    	
	    	m1.put(strKey,strValue);
	    	
	    }
	 
	} 
	
	public void setAppUser(String User){
		appUser = User;
	}
	
	public String getAppUser(){
		return appUser;
	}

	public void assignEnvFromMap(Map Env) {
		String[] MapKeys = new String[Env.size()];

		Iterator itr = Env.keySet().iterator();
		int intC = 0;
		while (itr.hasNext()) {
			String key = (String) itr.next();
			MapKeys[intC] = key;
			if (intC < Env.size()) {
				intC++;
			}
		}
		for (int i = 0; i < MapKeys.length; i++) {
			String strKey = MapKeys[i];
			String strValue = (String) Env.get(strKey).toString();
			// System.out.println(strKey + "--- "+ strValue);
			m1.put(strKey, strValue);

		}
	}
	
/*=====================================================================================================
	Function FnCom_UpdateTCMapping
	Parameters: strWorkBookName 
	Description: This function is used to identify modules with the Execution flag "Y" & get the env details
	Author: Dhivya Durairaj
	Created Date: Mar 07, 2014
	=====================================================================================================*/
	public void FnCom_UpdateTCMapping(String strWorkBookName,String strCaseName) throws Exception, WriteException, IndexOutOfBoundsException	
	{
		
		String strStatus= m1.get("TS_STATUS").toString();				
		String strResultsFolder=m1.get("RESULTS_FOLDER").toString();
		strResultsFolder=strResultsFolder.replace("/", "\\");
		
		String StrResFile=m1.get("QCFileName").toString();
		String strTime=m1.get("StartTime").toString();				
		String p=m1.get("PLATFORM").toString();
		if(p.equalsIgnoreCase("MAC"))
		{
			StrResFile = StrResFile.replace("/", "//");
			strResultsFolder=strResultsFolder.replace("/", "//");
			
			
		}else{
		StrResFile = StrResFile.replace("/", "\\");
		strResultsFolder=strResultsFolder.replace("/", "\\");
		}
		
		try{			
			
			
			File outputWorkbook = new File(strWorkBookName);
			Workbook strWorkBook = Workbook.getWorkbook(new File(strWorkBookName));
			int intRowCount = strWorkBook.getSheet("Modules").getRows();
			int intColCount = strWorkBook.getSheet("Modules").getColumns();			
			String[] arrColHeader=new String[intColCount];
			
			int intR1=strWorkBook.getSheet("Modules").findCell(strCaseName).getRow();			
			WritableWorkbook w2 = Workbook.createWorkbook(outputWorkbook, strWorkBook);
			w2.copy(strWorkBook);
	
			Label label = new Label(3, intR1, strStatus);
			w2.getSheet("Modules").addCell(label);
			w2.getSheet("Modules").addCell(new Label(4, intR1, strTime));
			w2.getSheet("Modules").addCell(new Label(5, intR1, strResultsFolder));
			w2.getSheet("Modules").addCell(new Label(6, intR1, StrResFile));			
			w2.write();
			w2.close();
		}catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

/*=====================================================================================================
	Function FnCreateResFolder
	Parameters: None	 
	Description: This function is used to create a results folder in drive
	Author: Dhivya Durairaj
	Created Date: Mar 10, 2014
	=====================================================================================================*/
	public void FnCreateResFolder()
	{
		
		File f=new File(m1.get("RESULTS_PATH").toString());
		f.mkdirs();
		
		if(f.exists())		
			System.out.println("results folder created successfully");
		else
			System.out.println("results folder not created");
		/*
		 File[] rootDrive = File.listRoots();
		   
		   for(File sysDrive : rootDrive){
			   if(sysDrive.getAbsolutePath().contentEquals("C:\\"))
			   {
				   	File theDirMod = new File("C:\\CableVision");
					theDirMod.mkdir();
					if(theDirMod.exists())
					{
						String f=m1.get("RESULTS_PATH").toString();
						File theDir = new File(f);
			  		    theDir.mkdir();
			  		    m1.put("RESULTS_PATH", f);
					}
		  		    break;
		  		}
		   }*/
	}
	

	

/*=====================================================================================================
	Function CreateSummaryHTML
	Parameters:Module Name, Case Name	 
	Description: This function is used to create summary html reports
	Author: Dhivya Durairaj
	Created Date: Mar 10, 2014
	=====================================================================================================*/
	public void CreateSummaryHTML(String mod, String strBrowser)
	{
		try{
			char[] c= new char[34];			
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf1= new SimpleDateFormat("ddMMyyyy");
	    	String strTime=sdf1.format(cal.getTime());
	    	
	    	SimpleDateFormat sdf2= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
	    	ModuleStartTime=sdf2.format(cal.getTime());
			
	    	SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy_HH_mm_ss");
	    	String strTime1=sdf.format(cal.getTime());
	    	
	    	
			//IF RESULTS PATH IS NOT FOUND. CREATE IT FIRST
	    	String fp,strFileName;			
			String p=m1.get("PLATFORM").toString();
			if(p.equalsIgnoreCase("MAC"))
			{
				fp=m1.get("RESULTS_PATH").toString()+"//ExecSummary";
				strFileName=fp+"//"+mod+"_"+strTime+".html";		
			}else{
				fp=m1.get("RESULTS_PATH").toString()+"\\ExecSummary";
				strFileName=fp+"\\"+mod+"_"+strTime+".html";	
			}
			File f=new File(fp);
			f.mkdirs();
			if(f.exists())
			{
				   m1.put("SUMMARY", fp);				   
			}else{
				System.out.println("not exists");
			}
			
			
			
			System.out.println("HTML File" + strFileName);
			
			String summaryHTMLKey="SummaryHTML"+mod;
			m1.put(summaryHTMLKey,strFileName);
			
			//create summary excel file
								
			//create & update html file
			FileOutputStream fo = new FileOutputStream(strFileName);
			OutputStreamWriter objResFile = new OutputStreamWriter(new FileOutputStream(strFileName));
						
			objResFile.write("<html>");
			objResFile.write("<head>");

			objResFile.write("<meta http-equiv=" + "Content-Language" + "content=" + "en-us>");

			objResFile.write("<meta http-equiv="+ "Content-Type" + "content=" + "text/html; charset=windows-1252" + ">");
		///Title name of the HTMLreport
			objResFile.write("<title> Charter.Net Automation Test Execution Summary</title>");

			objResFile.write("</head>");
			objResFile.write("<body>");
			//'#800080,#800000
			objResFile.write("<blockquote>");
			objResFile.write("<table border=2 bordercolor=" + "#640E27 id=table1 width=1700 height=31 bordercolorlight=" + "#640E27>");
			objResFile.write("<tr>");
			objResFile.write("<td COLSPAN = 15");
			//' Main header
			objResFile.write("<p align=center><font color=#000080 size=4 face= "+ c+"Copperplate Gothic Bold"+c + ">  Automation Test Execution Summary" + "</font><font face= " + c+"Copperplate Gothic Bold"+c + "></font> </p>");		
			objResFile.write("</td>");	
			objResFile.write("</tr>");
			
		//Including the Test Script Name in the html report
			objResFile.write("<tr>");
			objResFile.write("<td COLSPAN = 15 >");	
			objResFile.write("<p align=justify><b><font color=#000080 size=2 face= Verdana>"+ "Module Name:"+  mod);
		    objResFile.write("</td>");
		    objResFile.write("</tr>");

		  //Including the Test Script Name in the html report
			objResFile.write("<tr>");
			objResFile.write("<td COLSPAN = 15 >");	
			objResFile.write("<p align=justify><b><font color=#000080 size=2 face= Verdana>"+ "Browser Executed:" + strBrowser);
		    objResFile.write("</td>");
		    objResFile.write("</tr>");
		    
		  //Including the Test Script Name in the html report
			objResFile.write("<tr>");
			objResFile.write("<td COLSPAN = 15 >");	
			objResFile.write("<p align=justify><b><font color=#000080 size=2 face= Verdana>"+ "Execution Start time:" + ModuleStartTime);
	     	String ModuleStartTimeKey="ModuleStartTime"+mod;
	     	m1.put(ModuleStartTimeKey, ModuleStartTime);
		    objResFile.write("</td>");
		    objResFile.write("</tr>");
		    
		//Including the Current Time of the result generated
			objResFile.write("<tr>");
			objResFile.write("<td COLSPAN = 15 >");	
			objResFile.write("<p align=justify><b><font color=#000080 size=2 face= Verdana>"+ "DATE :" +  strTime1 );	
			objResFile.write("</td>");	
			objResFile.write("</tr>");

			//Including the Step No
			
			/*//'1 Including the TestType
			objResFile.write("<td width=" + "275>");
			objResFile.write("<p align=" + "center" + ">" + "<b><font face=" + "Verdana " + "size=" + "2" + ">" + "Test Type</b></td>");
			
			
			//'2 Including the Application
			objResFile.write("<td width=" + "275>");
			objResFile.write("<p align=" + "center" + ">" + "<b><font face=" + "Verdana " + "size=" + "2" + ">" + "Application</b></td>");
			
			//'3 Including the ProductVersion
			objResFile.write("<td width=" + "275>");
			objResFile.write("<p align=" + "center" + ">" + "<b><font face=" + "Verdana " + "size=" + "2" + ">" + "ProductVersion</b></td>");
			
			*/
			//'4 Including the Module
			objResFile.write("<td width=" + "75>");
			objResFile.write("<p align=" + "center" + ">" + "<b><font face=" + "Verdana " + "size=" + "2" + ">" + "S.NO</b></td>");
			
			objResFile.write("<td width=" + "275>");
			objResFile.write("<p align=" + "center" + ">" + "<b><font face=" + "Verdana " + "size=" + "2" + ">" + "Module</b></td>");
			
			
			
			//'5 Including the TestcaseId
			objResFile.write("<td width=" + "275>");
			objResFile.write("<p align=" + "center" + ">" + "<b><font face=" + "Verdana " + "size=" + "2" + ">" + "TestcaseId</b></td>");
			
			
		//'	6 'Including the Step Description
			objResFile.write("<td width=" + "275>");
			objResFile.write("<p align=" + "center><b><font face=" + "Verdana " + "size=" + "2" + ">" + "Test Case Name</b></td>");
		
			
			
			//'	13 'Including the Scenario
			objResFile.write("<td width=" + "275>");
			objResFile.write("<p align=" + "center><b><font face=" + "Verdana " + "size=" + "2" + ">" + "Scenario</b></td>");
			
			/*//'	14 'Including the TestEnvironment
			objResFile.write("<td width=" + "275>");
			objResFile.write("<p align=" + "center><b><font face=" + "Verdana " + "size=" + "2" + ">" + "Test Environment</b></td>");
			*/
			
			/*//'	15 'Including the OS/Browser
			objResFile.write("<td width=" + "275>");
			objResFile.write("<p align=" + "center><b><font face=" + "Verdana " + "size=" + "2" + ">" + "OS/Browser/Version</b></td>");
			 */
			
			/* //'7 Including the  TestProperties
			objResFile.write("<td width=" + "275" + ">");
			objResFile.write("<p align=" + "center" + ">" + "<b><font face=" + "Verdana " + "size=" + "2" + ">" + "Test Properties</b></td>");
			
			*/
			 
			
			/* //'8 Including the  UserCategory
			objResFile.write("<td width=" + "275" + ">");
			objResFile.write("<p align=" + "center" + ">" + "<b><font face=" + "Verdana " + "size=" + "2" + ">" + "User Category</b></td>");
			*/
			
			
			
			
			//'9 Including the  Execution Results
			objResFile.write("<td width=" + "275" + ">");
			objResFile.write("<p align=" + "center" + ">" + "<b><font face=" + "Verdana " + "size=" + "2" + ">" + "Execution Status</b></td>");
			
			//'10 Including the Results Path
			objResFile.write("<td width=" + "300" + ">");
			objResFile.write("<p align=" + "center" + ">" + "<b><font face=" + "Verdana " + "size=" + "2" + ">" + "Reason For Failure</b></td>");
			
			
			/*
			//'11 Including the  JiraTicketNo
			objResFile.write("<td width=" + "275" + ">");
			objResFile.write("<p align=" + "center" + ">" + "<b><font face=" + "Verdana " + "size=" + "2" + ">" + "JiraTicketNo</b></td>");
			*/
			
			//'Including the Results Path
			/*objResFile.write("<td width=" + "275>");
			objResFile.write("<p align=" + "center" + ">" + "<b><font face=" + "Verdana " + "size=" + "2" + ">" + "Results File Name</b></td>");*/
			
			//'12 Time of execution
			objResFile.write("<td width=" + "275>");
			objResFile.write("<p align=" + "center" + ">" + "<b><font face=" + "Verdana " + "size=" + "2" + ">" + "Time</b></td>");
			
			//'Time of execution
			objResFile.write("</tr>");
			objResFile.write("</blockquote>");
			objResFile.write("</body>");
			objResFile.write("</html>");
		    objResFile.close();
		    String TestcaseCountKey="TestcaseCount"+mod;
		    m1.put(TestcaseCountKey,"0");
		    String TestCasePassedKey="TestCasePassed"+mod;
			m1.put(TestCasePassedKey, "0");
			  String TestCaseFailedKey="TestCaseFailed"+mod;
			m1.put( TestCaseFailedKey, "0");
			String TestCaseWarningKey="TestCaseWarning"+mod;
			m1.put(TestCaseWarningKey, "0");
			String TestCaseAbortKey="TestCaseAbort"+mod;
			m1.put(TestCaseAbortKey, "0");
		    
		    
		}catch(Exception e)
		{
			System.err.println("	Function : FnCreateSummaryHTML");
			System.err.println("	Message : "+e.getMessage());
			System.err.println("	Cause : "+e.getCause());
		}
	}
	

	
	

/*=====================================================================================================
	Function FnUpdateSummaryHTML
	Parameters:Test Case Name, Results status, results path, time	 
	Description: This function is used to create summary html reports
	Author: Nirmal
	Created Date: Apr 7, 2015
	=====================================================================================================*/
	public synchronized   void FnUpdateSummaryHTML(RunManagerInfo runManagerInfoObj)
	{		
		try{
			
			
			String strCaseName=runManagerInfoObj.getStrCaseName();
			String overallResultKey="OVERALLSTATUS"+runManagerInfoObj.getStrTestCaseId();
			String strResultStatus=m1.get(overallResultKey).toString();
			summaryHelper(strCaseName, strResultStatus,runManagerInfoObj);	
			JsonUtility JsonUtility=new JsonUtility();
			JsonUtility.updateJsonReports(runManagerInfoObj,strResultStatus);
		}catch(Exception e)
		{
			System.err.println("	Message : "+e.getMessage());
			System.err.println("	Cause : "+e.getCause());
		}
	}
			
			public void summaryHelper(String strCaseName, String strResultStatus,RunManagerInfo runManagerInfoObj){
				try{
					String summaryHTMLKey="SummaryHTML"+runManagerInfoObj.getAppmodule();
					String FileName=m1.get(summaryHTMLKey).toString();
					
					
			//String strCaseName=m1.get("TESTCASE").toString();
					
					String TestcaseCountKey="TestcaseCount"+runManagerInfoObj.getAppmodule();
				   
				    String TestCasePassedKey="TestCasePassed"+runManagerInfoObj.getAppmodule();
				
					  String TestCaseFailedKey="TestCaseFailed"+runManagerInfoObj.getAppmodule();
					
					String TestCaseWarningKey="TestCaseWarning"+runManagerInfoObj.getAppmodule();
					
					String TestCaseAbortKey="TestCaseAbort"+runManagerInfoObj.getAppmodule();
					
					
					
					
					
					String TesCaseCount=m1.get(TestcaseCountKey).toString();
					String PassedCount=m1.get(TestCasePassedKey).toString();
					String FailedCount=m1.get(TestCaseFailedKey).toString();
					String WarningCount=m1.get(TestCaseWarningKey).toString();
					String AbortCount=m1.get(TestCaseAbortKey).toString();
					int Count=Integer.valueOf(TesCaseCount);
						int TestcaseCount=Count+1;
						
						m1.put(TestcaseCountKey, TestcaseCount);
						
						int PCount=Integer.valueOf(PassedCount);
						
						
						int FCount=Integer.valueOf(FailedCount);
						
						int WCount=Integer.valueOf(WarningCount);
						int ACount=Integer.valueOf(AbortCount);
			
			System.out.println("Summary Html overall status:"+strResultStatus);
			String strBrowser=runManagerInfoObj.getStrBrowser();
			
			String strVersion=runManagerInfoObj.getBrowserVersion();
			System.out.println("Version: "+strVersion);
			
			String strOS=m1.get("OS_NAME").toString();
			
			String strOsBrowserVer=strOS+"/"+strBrowser+"/"+strVersion;
			
			//String strTestPropp = m1.get("TESTPROPERTY").toString();
			
			String strTestCaseId=runManagerInfoObj.getStrTestCaseId();
			
			//String strTestType=m1.get("TestType").toString();
			
			//String strApplication=m1.get("ApplicationName").toString();
			
			//String strProductVersion=m1.get("ProductVersion").toString();
			
			//String strUserCategory=m1.get("USERCATEGORYY").toString();
			
			
			//String strEnvironment=m1.get("Env").toString();
			
			String strAppMod=runManagerInfoObj.getAppmodule();
			
			String strScenario=runManagerInfoObj.getStrScenario();
			//String strJiraNo=m1.get("JIRANO").toString();
			
			
			
			
			
//			Calendar cal = Calendar.getInstance();
//			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//			strTime=sdf.format(cal.getTime());
			String strTime=m1.get("StartTime").toString();	
			
			File fo = new File(FileName);
			if(fo.exists())
			{	
				OutputStreamWriter objResFile = new OutputStreamWriter(new FileOutputStream(FileName,true));
				//'	Test Type
				//objResFile.write("<td width=" + "275>");
				//objResFile.write("<p align=" + "center><font face=" + "Verdana " + "size=" + "2" + ">" + strTestType+" </td>");
				
				
			/*	//'	Application
				objResFile.write("<td width=" + "275>");
				objResFile.write("<p align=" + "center><font face=" + "Verdana " + "size=" + "2" + ">" + strApplication+" </td>");
				*/
				
				
				/*//'	ProductVersion
				objResFile.write("<td width=" + "275>");
				objResFile.write("<p align=" + "center><font face=" + "Verdana " + "size=" + "2" + ">" + strProductVersion+" </td>");
				*/
				objResFile.write("<td width=" + "75>");
				objResFile.write("<p align=" + "center><font face=" + "Verdana " + "size=" + "2" + ">" + TestcaseCount+" </td>");
				
				
				//'	Module
				objResFile.write("<td width=" + "275>");
				objResFile.write("<p align=" + "center><font face=" + "Verdana " + "size=" + "2" + ">" + strAppMod+" </td>");
				
				
				
				//'	TestCaseId
				objResFile.write("<td width=" + "275>");
				objResFile.write("<p align=" + "center><font face=" + "Verdana " + "size=" + "2" + ">" + strTestCaseId+" </td>");
				
				
			//'	Test Case Name
				objResFile.write("<td width=" + "275>");
				objResFile.write("<p align=" + "center><font face=" + "Verdana " + "size=" + "2" + ">" + strCaseName+" </td>");
				
				//Scenario
				objResFile.write("<td width=" + "275>");
				objResFile.write("<p align=" + "center><font face=" + "Verdana " + "size=" + "2" + ">" + strScenario+" </td>");
			
				
				/*//'	Test Environment
				objResFile.write("<td width=" + "275>");
				objResFile.write("<p align=" + "center><font face=" + "Verdana " + "size=" + "2" + ">" + strEnvironment+" </td>");
				*/
				
			/*	
				//'	OS/Browser
				objResFile.write("<td width=" + "275>");
				objResFile.write("<p align=" + "center><font face=" + "Verdana " + "size=" + "2" + ">" + strOsBrowserVer+" </td>");
				*/
				
				
				/*//'	Test Properrty
				objResFile.write("<td width=" + "275>");
				objResFile.write("<p align=" + "center><font face=" + "Verdana " + "size=" + "2" + ">" + strTestPropp+" </td>");
				*/
/*
				//'	UserCategory
				objResFile.write("<td width=" + "275>");
				objResFile.write("<p align=" + "center><font face=" + "Verdana " + "size=" + "2" + ">" + strUserCategory+" </td>");
				*/
				
				//Overall status
				objResFile.write("<td width=" + "275" + ">");
				if(strResultStatus.equalsIgnoreCase("BLOCKED")){
					objResFile.write("<p align=" + "center" + ">" + "<font face=" + "Verdana " + "size=" + "2" + ">" +strResultStatus+"</td>");
				}
				else{
					String strResultsPath=runManagerInfoObj.getQCFileName();
					String RESULTS_FOLDERkey="RESULTS_FOLDER"+runManagerInfoObj.getStrTestCaseId();
					String strResultsFolder=m1.get(RESULTS_FOLDERkey).toString();
					strResultsFolder=strResultsFolder.replace("/", "\\");
				
				if(strResultStatus.equalsIgnoreCase("PASS"))
				{
					int TestCasePassed=PCount+1;
					m1.put(TestCasePassedKey, TestCasePassed);

					objResFile.write("<p align=" + "center" + ">" + "<font face=" + "Verdana " + "size=" + "2" + ">" + ""
							+ "<a href='" + strResultsFolder + "\\" + strResultsPath +"' target=_blank style='color:#00FF00'>" +strResultStatus+"</a></td>");
				}else if(strResultStatus.equalsIgnoreCase("FAIL"))
					{
					int TestCaseFailed=FCount+1;
					m1.put(TestCaseFailedKey, TestCaseFailed);
	
					objResFile.write("<p align=" + "center" + ">" + "<font face=" + "Verdana " + "size=" + "2" + " color=" + "#FF0000" + ">" +
								"<a href='" + strResultsFolder + "\\" + strResultsPath +"' target=_blank style='color:#FF0000'>" +strResultStatus+"</a></td>");
					}
					else if(strResultStatus.equalsIgnoreCase("ABORT"))
				{
						int TestCaseAbort=ACount+1;
						m1.put(TestCaseAbortKey, TestCaseAbort);
						objResFile.write("<p align=" + "center" + ">" + "<font face=" + "Verdana " + "size=" + "2" + " color=" + "#FF0000" + ">" +
							"<a href='" + strResultsFolder + "\\" + strResultsPath +"' target=_blank style='color:#FF0000'>" +strResultStatus+"</a></td>");
					}
					else 
				{
						int TestCaseWarning=WCount+1;
						m1.put(TestCaseWarningKey, TestCaseWarning);

					objResFile.write("<p align=" + "center" + ">" + "<font face=" + "Verdana " + "size=" + "2" + ">" +strResultStatus+"</td>");
				}
				}
				
				//Results path
				/*objResFile.write("<td width=" + "275" + ">");
				objResFile.write("<p align=" + "center" + ">" + "<font face=" + "Verdana " + "size=" + "2" + ">" + strResultsFolder + "</font>" + "</td>");*/
				
				objResFile.write("<td width=" + "275" + ">");
			objResFile.write("<p align=" + "center" + ">" + "<font face=" + "Verdana " + "size=" + "2" + ">");
			String failedStepKey="FAILEDSTEPNAME"+runManagerInfoObj.getStrTestCaseId();
			String ActualResultKey="ACTUALRESULT"+runManagerInfoObj.getStrTestCaseId();
			if(strResultStatus.equalsIgnoreCase("FAIL") && null != m1.get(failedStepKey) && null != m1.get(ActualResultKey)){
				
				String strFailedStep = m1.get(failedStepKey).toString();
				String strActResult = m1.get(ActualResultKey).toString();
				objResFile.write("Failed at step : " + strFailedStep);
				objResFile.write("<br>Actual Result : " + strActResult);
			}
			else if(strResultStatus.equalsIgnoreCase("PASS")){ //Changed status to ABORT instead of BLOCKED
			
				objResFile.write("NA");

			}
				else if(strResultStatus.equalsIgnoreCase("ABORT") && null != m1.get("BLOCKEDREASON")){ //Changed status to ABORT instead of BLOCKED
					//objResFile.write(m1.get("BLOCKEDREASON").toString());
					String strFailedStep = m1.get(failedStepKey).toString();
					String strActResult = m1.get(ActualResultKey).toString();
					objResFile.write("Failed at step : " + strFailedStep);
					objResFile.write("<br>Actual Result : " + strActResult);
				}
			objResFile.write("</font>" + "</td>");
				
				//Results path
				/*objResFile.write("<td width=" + "275" + ">");
				objResFile.write("<p align=" + "center" + ">" + "<font face=" + "Verdana " + "size=" + "2" + ">" + strResultsPath + "</font>" + "</td>");*/
				/*//'	JIRA
				objResFile.write("<td width=" + "275>");
				objResFile.write("<p align=" + "center><font face=" + "Verdana " + "size=" + "2" + ">" + strJiraNo+" </td>");
				*/
				//Execution Start Time
				objResFile.write("<td width=" + "275>");
				objResFile.write("<p align=" + "center" + ">" + "<font face=" + "Verdana " + "size=" + "2" + ">" +strTime+ "</td>");
				objResFile.write("</tr>");
				objResFile.close();
				
				/*String strBro=m1.get("BrowserVersion").toString();
				File fo1 = new File(FileName);
				
				File fo2=new File(strBro+"_"+FileName);
				fo1.renameTo(fo2);*/
				
				//Added to write ABORT TCs into xls
				if(strResultStatus.equalsIgnoreCase("ABORT") && null != m1.get("BLOCKEDREASON")){
					m1.put("MANUALTC",strCaseName);
					m1.put("SCENARIO",strScenario);
					 FnUpdateSummaryXL(intCounter,runManagerInfoObj);
					 intCounter=intCounter+1;
				 }
				
			}else
			{
				System.out.println("File does not exists");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("	Message : "+e.getMessage());
			System.err.println("	Cause : "+e.getCause());
		}
	}

	

	/*=====================================================================================================
		Function FnSummaryHTMLWrapper
		Parameters:Test Case Name, Results status, results path, time	 
		Description: This function is used to create summary html reports
		Author: Dhivya Durairaj
		Created Date: Mar 10, 2014
		=====================================================================================================*/
		public void FnSummaryHTMLWrapper(String module)
		{		
			try{	
				String summaryHTMLKey="SummaryHTML"+module;
				String FileName=m1.get(summaryHTMLKey).toString();
			
				
				Calendar cal = Calendar.getInstance();			
				SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
		    	String strTime=sdf1.format(cal.getTime());
		    	ModuleEndTime=strTime;
		    	Date d=sdf1.parse(ModuleStartTime);
				Date dd=sdf1.parse(ModuleEndTime);
				
				long diff = dd.getTime() - d.getTime();			
				double diffInMins = diff / ((double) 1000 * 60);			
				System.out.println("Module end time "+ModuleEndTime);
				File fo = new File(FileName);
				if(fo.exists())
				{				
					OutputStreamWriter objResFile = new OutputStreamWriter(new FileOutputStream(FileName,true));
					
					String TestcaseCountKey="TestcaseCount"+module;
					   
				    String TestCasePassedKey="TestCasePassed"+module;
				
					  String TestCaseFailedKey="TestCaseFailed"+module;
					
					String TestCaseWarningKey="TestCaseWarning"+module;
					
					String TestCaseAbortKey="TestCaseAbort"+module;
					
					

					objResFile.write("<tr>");
					objResFile.write("<td COLSPAN = 15 >");	
					objResFile.write("<p align=justify><b><font size=2 face= Verdana> Number of Test Cases Executed:<font color=#000080 size=2 face= Verdana>"
					+ m1.get(TestcaseCountKey).toString()+"&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; <font color=#000000 size=2 face= Verdana>PASSED:<font color=#008000 size=2 face= Verdana>" +m1.get(TestCasePassedKey).toString()+ " &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"+"<font color=#000000 size=2 face= Verdana>FAILED:"
							+"<font color=#FF0000 size=2 face= Verdana>"+m1.get(TestCaseFailedKey).toString()+"&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; <font color=#000000 size=2 face= Verdana>WARNING:<font color=#000080 size=2 face= Verdana>" +m1.get(TestCaseWarningKey).toString()+
							"&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; <font color=#000000 size=2 face= Verdana>ABORT:<font color=#FFA500 size=2 face= Verdana>" +m1.get(TestCaseAbortKey).toString());
		
					objResFile.write("</td>");
				    objResFile.write("</tr>");
					objResFile.write("<tr>");
					objResFile.write("<td COLSPAN = 15 >");	
					objResFile.write("<p align=justify><b><font color=#000080 size=2 face= Verdana>"+ "Execution End Time:"+  strTime);
					
					
					
				    objResFile.write("</td>");
				    objResFile.write("</tr>");
				    
				    objResFile.write("<tr>");
					objResFile.write("<td COLSPAN = 15 >");	
					objResFile.write("<p align=justify><b><font color=#000080 size=2 face= Verdana>"+ "Overall Execution Time (in Mins):"+  Math.round(diffInMins));
					
					
					
					objResFile.write("</td>");
				    objResFile.write("</tr>");
				    objResFile.close();
				}
			}catch(Exception e)
			{
				e.printStackTrace();
				System.err.println("	Message : "+e.getMessage());
				System.err.println("	Cause : "+e.getCause());
			}
		}
	
	public synchronized void FnUpdateSummaryXL(int intCounter,RunManagerInfo runManagerInfoObj) throws Exception, WriteException, IndexOutOfBoundsException	
	{
		String strWorkBookName=m1.get("SummaryXL").toString();
        
		String strCaseName=runManagerInfoObj.getStrCaseName();
		//Use Test Case Name instead of Test Script name
		String overallResultKey="OVERALLSTATUS"+runManagerInfoObj.getStrTestCaseId();
		String strStatus=m1.get(overallResultKey).toString();	
		
		System.out.println("Status:"  + strStatus);
		String RESULTS_FOLDERkey="RESULTS_FOLDER"+runManagerInfoObj.getStrTestCaseId();
		String strResultsFolder=m1.get(RESULTS_FOLDERkey).toString();
		strResultsFolder=strResultsFolder.replace("/", "\\");
		
		
		String StrResFile=runManagerInfoObj.getQCFileName(); // This line has error
		String strTime=m1.get("StartTime").toString();				
		String strTimeForProdStatus = m1.get("StartTimeForXLS").toString();
		StrResFile = StrResFile.replace("/", "\\");
		String strManualTC=m1.get("MANUALTC").toString();
		strResultsFolder=strResultsFolder.replace("/", "\\");
		StrResFile = StrResFile.replace("/", "\\");
		
		String strEnvironment=m1.get("AppURL").toString();
		String strBrowser=runManagerInfoObj.getStrBrowser();
		
		String strVersion=runManagerInfoObj.getBrowserVersion();
		String strOS=m1.get("OS_NAME").toString();
		String strOsBrowserVer=strOS+"','"+strBrowser+"','"+strVersion+"'}\"";
		String strEnvironment1="\"{'"+strEnvironment+"','"+strOsBrowserVer;
		System.out.println(strEnvironment1);
		String strPerformtype=m1.get("PerformType").toString();
		
		String strTestPropp = runManagerInfoObj.getStrTestProperty();
		
		String strTestCaseId=runManagerInfoObj.getStrTestCaseId();
		//String strTestType=m1.get("TestType").toString();
		String strApplication=m1.get("ApplicationName").toString();
		String strProductVersion=m1.get("ProductVersion").toString();
		String strUserCategory=runManagerInfoObj.getStrUsrCat();
//		String status_Date=m1.get("StatusWithDate").toString();
		
		String strAppMod=runManagerInfoObj.getAppmodule();
		String strScenario=runManagerInfoObj.getStrScenario();
		String strJiraNo=runManagerInfoObj.getStrJiraNo();
		
	    UUID id=new UUID(1, 0);
	    String idvalue= id.randomUUID().toString();
	    System.out.println(idvalue);
	    
		try{
			File outputWorkbook = new File(strWorkBookName);
			Workbook strWorkBook = Workbook.getWorkbook(new File(strWorkBookName));
			WritableWorkbook w2 = Workbook.createWorkbook(outputWorkbook, strWorkBook);
			w2.copy(strWorkBook);	
			//Label label = new Label(0, intCounter, strManualTC);
			//Label label = new Label(0, intCounter, strTestType);
			//w2.getSheet("Summary").addCell(label);
				
			w2.getSheet("Summary").addCell(new Label(0, intCounter, strApplication));
			w2.getSheet("Summary").addCell(new Label(1, intCounter, strProductVersion));
			w2.getSheet("Summary").addCell(new Label(2, intCounter,strAppMod));
			w2.getSheet("Summary").addCell(new Label(3, intCounter, strTestCaseId));
			w2.getSheet("Summary").addCell(new Label(4, intCounter, strCaseName));
			w2.getSheet("Summary").addCell(new Label(5, intCounter, strScenario));
			w2.getSheet("Summary").addCell(new Label(6, intCounter, strEnvironment1));
			//w2.getSheet("Summary").addCell(new Label(8, intCounter, strPerformtype));
			
			w2.getSheet("Summary").addCell(new Label(7, intCounter, strTestPropp));
			//w2.getSheet("Summary").addCell(new Label(10, intCounter, strUserCategory));
			w2.getSheet("Summary").addCell(new Label(8, intCounter, strStatus));
			//w2.getSheet("Summary").addCell(new Label(13, intCounter, strJiraNo));
			//w2.getSheet("Summary").addCell(new Label(14, intCounter, idvalue));
			w2.getSheet("Summary").addCell(new Label(9, intCounter, strTime));
			/*if(strStatus.equalsIgnoreCase("FAIL") && null != m1.get("FAILEDSTEPNAME") && null != m1.get("ACTUALRESULT")){
				System.out.println("Inside Failed");
				String strFailedStep = m1.get("FAILEDSTEPNAME").toString();
				String strActResult = m1.get("ACTUALRESULT").toString();
				w2.getSheet("Summary").addCell(new Label(11, intCounter, "Failed at step : " + strFailedStep + "\nActual Result : " + strActResult));				
			}
			else if(strStatus.equalsIgnoreCase("ABORT")){
				System.out.println("Inside Abort");
				String strBlockedReason = m1.get("BLOCKEDREASON").toString();
				w2.getSheet("Summary").addCell(new Label(11, intCounter, "Abort Reason: " + strBlockedReason));				
			}
			else
			{
				System.out.println("Inside Pass");
				w2.getSheet("Summary").addCell(new Label(11, intCounter, "NA"));
			}*/
			w2.write();
			w2.close();	
			
			FnConverXltoCSV(strWorkBookName);		
		}catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Function : FnCreateSummaryHTML");
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
		}
		
	}
	
	
	/*=====================================================================================================
	Function CreateOutputXLS
	Parameters: Module Name, Test Case Name	 
	Description: This function is used to create an excel sheet with reports
	Author: Dhivya Durairaj
	Created Date: Feb 20, 2014
	=====================================================================================================*/
	@SuppressWarnings("unchecked")
	public String CreateOutputXLS(RunManagerInfo runManagerInfoObj)
	{
		try{
			
			m1.put("TS_STATUS","null");		
		    
			//FnInitializeBrowser();
			Calendar cal = Calendar.getInstance();
	    	cal.getTime();    	
	    	SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
	    	String strTime=sdf1.format(cal.getTime());
	    	StartTime=strTime;
	    	
	    	SimpleDateFormat sdfXl= new SimpleDateFormat("(H:mm a)");
	    	sdfXl.setTimeZone(TimeZone.getTimeZone("America/Denver"));
	    	String strTimeForXLS=sdfXl.format(cal.getTime());
	    	m1.put("StartTime", StartTime);
	    	m1.put("StartTimeForXLS", strTimeForXLS);
	    	
	    	SimpleDateFormat sdf2 = new SimpleDateFormat("ddMMyyyy");
	    	String t= sdf2.format(cal.getTime());
	    	
	    	SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
	    	String time=sdf.format(cal.getTime());	    	
			String filename=m1.get("RESULTS_PATH").toString();
			String modKey="MODULE"+runManagerInfoObj.getStrTestCaseId();
			String testKey="TESTCASE"+runManagerInfoObj.getStrTestCaseId();
			m1.put(modKey, runManagerInfoObj.getAppmodule());
			m1.put(testKey, runManagerInfoObj.getStrCaseName());
			
			//IF RESULTS PATH IS NOT FOUND. CREATE IT FIRST
			File dir=new File(m1.get("RESULTS_PATH").toString());
			String fp,strFileName,resfldr;			
			String p=m1.get("PLATFORM").toString();
			if(p.equalsIgnoreCase("MAC"))
			{
				fp=m1.get("RESULTS_PATH").toString()+"//ExecSummary";	
				resfldr=filename+"//Modules//"+(runManagerInfoObj.getAppmodule())+"//"+time+"//"+(runManagerInfoObj.getStrCaseName());
				
			}else{
				fp=m1.get("RESULTS_PATH").toString()+"\\ExecSummary";
				resfldr=filename+"\\Modules\\"+(runManagerInfoObj.getAppmodule())+"\\"+time+"\\"+(runManagerInfoObj.getStrCaseName());
			}
			if(dir.exists())
			{
				File f=new File(fp);
				f.mkdir();
				if(f.exists())
				{
					   m1.put("SUMMARY", fp);
				}
			}else{
				FnCreateResFolder();
			}
			
			//String resfldr=filename+"\\Modules\\"+strModuleName+"\\"+time+"\\"+strCaseName;
			File theDirMod = new File(resfldr);
			theDirMod.mkdirs();
			String  RESULTS_FOLDERkey="RESULTS_FOLDER"+runManagerInfoObj.getStrTestCaseId();
  		    m1.put(RESULTS_FOLDERkey, resfldr);
  		    
  			if(theDirMod.exists())
  			{	
  				String ExcelFileName=null;		
  				if(p.equalsIgnoreCase("MAC"))
  				{
  					ExcelFileName=resfldr+"//"+runManagerInfoObj.getStrTestCaseId()+"_"+t+".xls";
  				}
  				else
  				{
  					ExcelFileName=resfldr+"\\"+runManagerInfoObj.getStrTestCaseId()+"_"+t+".xls";
  				}
  				CreateOutputHTML(runManagerInfoObj.getStrCaseName(),ExcelFileName,strTime,runManagerInfoObj.getStrTestCaseId());
  				
  				//String QCFileName=runManagerInfoObj.getStrCaseName()+"_"+t+".html";
  				String QCFileName=runManagerInfoObj.getStrTestCaseId()+"_"+t+".html";
  				String QCFileNameKey=QCFileName+(runManagerInfoObj.getStrTestCaseId());
  				m1.put(QCFileNameKey, QCFileName);	
  				
  				runManagerInfoObj.setQCFileName(QCFileName);
  			}
		}catch(Exception e)
		{
			e.printStackTrace();
			ExcelFileName=null;
			System.err.println("	Message : "+e.getMessage());
			System.err.println("	Cause : "+e.getCause());
		}
		return ExcelFileName;
	}
	
	
	
	public synchronized WebDriver FnInitializeBrowser(RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			if (runManagerInfoObj.getStrBrowser().equalsIgnoreCase("Firefox")) {
				System.setProperty("java.net.preferIPv4Stack", "true");
				DesiredCapabilities caps = DesiredCapabilities.firefox();
				System.out.println("Inside Initilize Browser Running On thread " + Thread.currentThread().getName());
				caps.setCapability("platform", "Windows 7");
				caps.setCapability("version", "44");
				caps.setCapability("name", runManagerInfoObj.getStrCaseName());
				System.out.println(" B4 Inside Initilize Browser Running , After WEb Driver instantiation.");
				driver = new RemoteWebDriver(new URL(URL), caps);
				driver.manage().deleteAllCookies();
				String appUrl = m1.get("AppURL").toString();
				driver.get(appUrl);
				runManagerInfoObj.setBrowserVersion("Firefox");
				System.out.println("Inside Initilize Browser Running , After WEb Driver instantiation.");

			} else if (runManagerInfoObj.getStrBrowser().equalsIgnoreCase("Chrome")) {
				System.setProperty("java.net.preferIPv4Stack", "true");
				DesiredCapabilities caps = DesiredCapabilities.chrome();
				System.out.println("Inside Initilize Browser Running On thread " + Thread.currentThread().getName());
				caps.setCapability("platform", "Windows 7");
				caps.setCapability("version", "52.0");
				//caps.setCapability("chromedriverVersion", "2.22");
				caps.setCapability("name", runManagerInfoObj.getStrCaseName());
				System.out.println(" B4 Inside Initilize Browser Running , After WEb Driver instantiation.");
				driver = new RemoteWebDriver(new URL(URL), caps);
				driver.manage().deleteAllCookies();
				String appUrl = m1.get("AppURL").toString();
				driver.get(appUrl);
				System.out.println("After driver");
				runManagerInfoObj.setBrowserVersion("Chrome");
				System.out.println("Inside Initilize Browser Running , After WEb Driver instantiation.");
			}

			else if (runManagerInfoObj.getStrBrowser().equalsIgnoreCase("IE")) {
				System.setProperty("java.net.preferIPv4Stack", "true");
				DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
				System.out.println("Inside Initilize Browser Running On thread " + Thread.currentThread().getName());
				caps.setCapability("platform", "Windows 7");
				caps.setCapability("version", "11");
			//	caps.setCapability("iedriverVersion", "2.46.0");
				caps.setCapability("name", runManagerInfoObj.getStrCaseName());
				System.out.println(" B4 Inside Initilize Browser Running , After WEb Driver instantiation.");
				driver = new RemoteWebDriver(new URL(URL), caps);
				driver.manage().deleteAllCookies();
				String appUrl = m1.get("AppURL").toString();
				driver.get(appUrl);
				runManagerInfoObj.setBrowserVersion("IE");
				System.out.println("Inside Initilize Browser Running , After WEb Driver instantiation.");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return driver;
	}

/*=====================================================================================================
	Function CreateOutputHTML
	Parameters:Test Case Name, File Name and Time	 
	Description: This function is used to create html reports
	Author: Dhivya Durairaj
	Created Date: Feb 20, 2014
	=====================================================================================================*/
	public String CreateOutputHTML(String strCaseName, String strFileName, String StartTime,String strTestCaseId)
 {
		try {
			String modKeyName = "MODULE" + strTestCaseId;
			String mod = m1.get(modKeyName).toString();

			char[] c = new char[34];
			strFileName = strFileName.replace(".xls", ".html");
			String keyName = "HTMLFile" + strTestCaseId;
			m1.put(keyName, strFileName);
			FileOutputStream fo = new FileOutputStream(strFileName);
			OutputStreamWriter objResFile = new OutputStreamWriter(new FileOutputStream(strFileName));
			// objResFile.write("hello");

			objResFile.write("<html>");
			objResFile.write("<head>");

			objResFile.write("<meta http-equiv=" + "Content-Language" + "content=" + "en-us>");

			objResFile.write("<meta http-equiv=" + "Content-Type" + "content=" + "text/html; charset=windows-1252" + ">");
			// /Title name of the HTMLreport
			objResFile.write("<title> Charter .Net Automation Test Execution Results</title>");

			objResFile.write("</head>");
			objResFile.write("<body>");
			// '#800080,#800000
			objResFile.write("<blockquote>");
			objResFile.write("<table border=2 bordercolor=" + "#640E27 id=table1 width=1200 height=31 bordercolorlight=" + "#640E27>");
			objResFile.write("<tr>");
			objResFile.write("<td COLSPAN = 6");
			// ' Main header
			objResFile.write("<p align=center><font color=#000080 size=4 face= " + c + "Copperplate Gothic Bold" + c + ">  Automation Test Execution Results For Module - " + mod
					+ "</font><font face= " + c + "Copperplate Gothic Bold" + c + "></font> </p>");
			objResFile.write("</td>");
			objResFile.write("</tr>");

			// Including the Test Script Name in the html report
			objResFile.write("<tr>");
			objResFile.write("<td COLSPAN = 6 >");
			objResFile.write("<p align=justify><b><font color=#000080 size=2 face= Verdana>" + "Test Script Name :" + strCaseName);
			objResFile.write("</td>");
			objResFile.write("</tr>");

			// Including the Current Time of the result generated
			objResFile.write("<tr>");
			objResFile.write("<td COLSPAN = 6 >");
			objResFile.write("<p align=justify><b><font color=#000080 size=2 face= Verdana>" + "DATE :" + StartTime + " MST");
			objResFile.write("</td>");
			objResFile.write("</tr>");

			// Including the Step No

			// '	'Including the Step Description
			objResFile.write("<td width=" + "275>");
			objResFile.write("<p align=" + "center><b><font face=" + "Verdana " + "size=" + "2" + ">" + "Step Description </b></td>");
			// 'Including the Expected Results

			objResFile.write("<td width=" + "275" + ">");
			objResFile.write("<p align=" + "center" + ">" + "<b><font face=" + "Verdana " + "size=" + "2" + ">" + "Actual result</b></td>");
			// 'Including the Actual Results
			objResFile.write("<td width=" + "125>");
			objResFile.write("<p align=" + "center" + ">" + "<b><font face=" + "Verdana " + "size=" + "2" + ">" + "Status</b></td>");
			// 'Status of the current Step
			objResFile.write("<td width=" + "125>");
			objResFile.write("<p align=" + "center" + ">" + "<b><font face=" + "Verdana " + "size=" + "2" + ">" + "Time</b></td>");
			// 'Time of execution
			// objResFile.write("<tr>");
			// objResFile.write("<td width=" + "50>");
			// objResFile.write("<p align=" + "center><b><font face=" +
			// "Verdana " + "size=" + "2" + ">" + " Time  </b></td>");
			objResFile.write("</tr>");
			objResFile.write("</blockquote>");
			objResFile.write("</body>");
			objResFile.write("</html>");
			objResFile.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("	Message : " + e.getMessage());
			System.err.println("	Cause : " + e.getCause());
		}
		return strFileName;
	}

	public synchronized void FnUpdateTestStepResHTML(String StepDesc, String ActStatus,String strResultStatus,RunManagerInfo runManagerInfoObj)
	{		
		try{
			//Velu
			if (strResultStatus != null && (strResultStatus.trim().equalsIgnoreCase("PASS") || strResultStatus.trim().contains("WARNING")) )
			{				
			} else
			{
				RunManager.TestCaseFailed = true;
			}
			
			String strEnvironment=m1.get("AppURL").toString();
			String strApplication=m1.get("ApplicationName").toString();
			
			
			String strThreadKey =  (runManagerInfoObj.getStrTestCaseId() +"_") + Thread.currentThread().hashCode();
				

			String strAppurl = m1.get("AppURL").toString();
			String strProductVersion=m1.get("ProductVersion").toString();
			String strAppMod=runManagerInfoObj.getAppmodule();
			int ModulePassPercentage = 0;
			String strTestCaseId=runManagerInfoObj.getStrTestCaseId();
			String strTestCaseStatus = "PASS";
			int ProjectPassPercentage = 0;
			Date CurrentTime = new Date();
			long millisec = CurrentTime.getTime()-RunManager.PreviousTime.getTime();
			String strTestReqData = "\"{'"+ m1.get("AppURL").toString() +"','"+ m1.get("OS_NAME").toString() +"','"+ runManagerInfoObj.getStrBrowser() +"','"+ runManagerInfoObj.getBrowserVersion() +"','"+ "ProjectUUID:" + RunManager.testprojectuuid +"','"+ "ModuleUUID:" + RunManager.testmoduleuuid +"','" + "TestCaseUUID:" + RunManager.testcaseuuid +"','"+ "TestStepUUID:" + RunManager.teststepuuid +"'}\"";
					
			try{
				strPresentDir = getRelativePath();
				String[] path=strPresentDir.split("Workspace");
				System.out.println("first val: "+ path[0]);
				String p=path[0]+"ExecReports";	
				
				String machinetype=getPlat();
				String filepath ="";
				
				if(machinetype.equalsIgnoreCase("MAC"))
				{
					filepath=p+"//ExecSummary//funtestres1.xls";
				}
				else{
					filepath=p+"\\ExecSummary\\funtestres1.xls";
						
					}
			FileInputStream fis7 = new FileInputStream(filepath);
			HSSFWorkbook wb7 = new HSSFWorkbook(fis7);
		     HSSFSheet sheet7 = wb7.getSheet("funtestres1");
		     
		       HSSFRow row7     = sheet7.createRow(RunManager.intRowCounter++);
		        row7.createCell(0).setCellValue(strEnvironment);
		        row7.createCell(1).setCellValue(strApplication); 
	     		row7.createCell(2).setCellValue(RunManager.testprojectuuid);
	     		row7.createCell(3).setCellValue(RunManager.testmoduleuuid);
	     		row7.createCell(4).setCellValue(RunManager.testcaseuuid);
	     		row7.createCell(5).setCellValue(RunManager.teststepuuid);
	     		row7.createCell(6).setCellValue(StepDesc);
	     		if(strResultStatus != null && (strResultStatus.trim().equalsIgnoreCase("PASS") || strResultStatus.trim().contains("WARNING")) )
	     			row7.createCell(7).setCellValue("PASS");
	     		else
	     			row7.createCell(7).setCellValue("FAIL");
	     		row7.createCell(8).setCellValue(strAppurl);
	     		row7.createCell(9).setCellValue(strProductVersion);
	     		row7.createCell(10).setCellValue(strAppMod);
	     		row7.createCell(11).setCellValue(ModulePassPercentage);
	     		row7.createCell(12).setCellValue(strTestCaseId);
	     		row7.createCell(13).setCellValue(strTestCaseStatus);
	     		row7.createCell(14).setCellValue(strAppurl);
	     		row7.createCell(15).setCellValue("null");
	     		row7.createCell(16).setCellValue("null");
	     		row7.createCell(17).setCellValue(ProjectPassPercentage);
	     		row7.createCell(18).setCellValue(millisec);
	     		row7.createCell(19).setCellValue(CurrentTime.toString());
	     		row7.createCell(20).setCellValue(strTestReqData);
	     		row7.createCell(21).setCellValue(ActStatus);
	     		
	     		
	     		SimpleDateFormat sdfXl= new SimpleDateFormat("(H:mm a)");
		    	sdfXl.setTimeZone(TimeZone.getTimeZone("America/Denver"));
		    	Calendar cal = Calendar.getInstance();
		    	String PreviousDate=sdfXl.format(cal.getTime());
		    	
	     		
	     		
	     		row7.createCell(22).setCellValue(RunManager.PreviousTime.toString());
	     		row7.createCell(23).setCellValue(RunManager.strTestType);
	     		FileOutputStream  fos7 =new FileOutputStream(filepath);
	     		wb7.write(fos7);            
			    fos7.close();	
			    fis7.close();
		       RunManager.PreviousTime = CurrentTime;
		       RunManager.teststepuuid = "maxTimeuuid('"+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(new Date())+"')";;
			}catch(Exception e)
			{
				System.out.println("File handling exception occured :" + e.getMessage());
				}
			//Velu
			
			
			StepCounter=StepCounter+1;
			//D:/SBNetCode/SBNet/CharterSBExecReports/ExecSummary/Calls_01072016_14_57_17.html
			
			String keyName="HTMLFile"+runManagerInfoObj.getStrTestCaseId();
			String FileName=m1.get(keyName).toString();
			System.out.println("Thread file Name: "+FileName);
			String strTime;
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
			strTime=sdf.format(cal.getTime());
			String strStep="01";
			File fo = new File(FileName);
			
			  TestStepDetails TestStepDetailsObj=new TestStepDetails();
			if(fo.exists())
			{
				
				OutputStreamWriter objResFile = new OutputStreamWriter(new FileOutputStream(FileName,true));
				//'	'Including the Step Description
					objResFile.write("<td width=" + "275>");
					objResFile.write("<p align=" + "center><font face=" + "Verdana " + "size=" + "2" + ">" + StepDesc+" </td>");
					TestStepDetailsObj.setStepDesc(StepDesc);
					
					//'Including the  Expected Results
					objResFile.write("<td width=" + "275" + ">");
					objResFile.write("<p align=" + "center" + ">" + "<font face=" + "Verdana " + "size=" + "2" + ">" +ActStatus+"</td>");
					
					TestStepDetailsObj.setActualResult(ActStatus);
					
					objResFile.write("<td width=" + "275" + ">");
					if(strResultStatus.equalsIgnoreCase("PASS")){
						objResFile.write("<p align=" + "center" + ">" + "<b><font face=" + "Verdana " + "size=" + "2" + " color=" + "#008000" + ">" + strResultStatus + "</font></b>" + "</td>");
			
					String overallResultKey="OVERALLSTATUS"+runManagerInfoObj.getStrTestCaseId();
					m1.put(overallResultKey, "PASS");
					TestStepDetailsObj.setResult("PASS");
					}
					
					else if(strResultStatus.equalsIgnoreCase("FAIL"))
					{
						
					
						String overallResultKey="OVERALLSTATUS"+runManagerInfoObj.getStrTestCaseId();
						m1.put(overallResultKey, "FAIL");
						
						
						String failedStepKey="FAILEDSTEPNAME"+runManagerInfoObj.getStrTestCaseId();
						m1.put(failedStepKey, StepDesc);
						
						String actualResutKey="ACTUALRESULT"+runManagerInfoObj.getStrTestCaseId();
						m1.put(actualResutKey, ActStatus);
						
						
						
						
					//	String path=takeScreenshot(runManagerInfoObj);
						
						objResFile.write("<p align=" + "center" + ">" + " <b><font face=" + "Verdana " + "size=" + "2" + " color=" + "#FF0000" + ">" + strResultStatus + " </font></b>" + "</td>");
					
						TestStepDetailsObj.setResult(strResultStatus);
					
					}
					else if(strResultStatus.equalsIgnoreCase("WARNING"))
					{
				
						String overallResultKey="OVERALLSTATUS"+runManagerInfoObj.getStrTestCaseId();
						m1.put(overallResultKey, "PASSED WITH WARNING");
					//	String path=takeScreenshot(runManagerInfoObj);
						
						objResFile.write("<p align=" + "center" + ">" + " <b><font face=" + "Verdana " + "size=" + "2" + " color=" + "#FF9933" + ">" + strResultStatus + "</font></b>" + "</td>");
					
						TestStepDetailsObj.setResult(strResultStatus);
					
					}else if(strResultStatus.equalsIgnoreCase("DONE") )
					{
						
						
						String overallResultKey="OVERALLSTATUS"+runManagerInfoObj.getStrTestCaseId();
						m1.put(overallResultKey, "ABORT");
				
						String failedStepKey="FAILEDSTEPNAME"+runManagerInfoObj.getStrTestCaseId();
						m1.put(failedStepKey, StepDesc);
						
						String actualResutKey="ACTUALRESULT"+runManagerInfoObj.getStrTestCaseId();
						m1.put(actualResutKey, ActStatus);
						
						String path=takeScreenshot(runManagerInfoObj);
						
						objResFile.write("<p align=" + "center" + ">" + " <b><font face=" + "Verdana " + "size=" + "2" + " color=" + "#FF0000" + "> <a href="+ path+ " target="+ "_blank" +"> " + strResultStatus + " </a></font></b>" + "</td>");
					
						TestStepDetailsObj.setResult(strResultStatus);
					}
					//Added else condition to add Abort cases to xls
					else if(null != strResultStatus)
					{
						
						
						String overallResultKey="OVERALLSTATUS"+runManagerInfoObj.getStrTestCaseId();
						m1.put(overallResultKey, "ABORT");
					
						
						String failedStepKey="FAILEDSTEPNAME"+runManagerInfoObj.getStrTestCaseId();
						m1.put(failedStepKey, StepDesc);
						
						String actualResutKey="ACTUALRESULT"+runManagerInfoObj.getStrTestCaseId();
						m1.put(actualResutKey, ActStatus);
						
						String path=takeScreenshot(runManagerInfoObj);
						
						objResFile.write("<p align=" + "center" + ">" + " <b><font face=" + "Verdana " + "size=" + "2" + " color=" + "#FF0000" + "> <a href="+ path+ " target="+ "_blank" +"> " + strResultStatus + " </a></font></b>" + "</td>");
						
						TestStepDetailsObj.setResult(strResultStatus);
					
					}
					//'Status of the current Step
					objResFile.write("<td width=" + "125>");
					objResFile.write("<p align=" + "center" + ">" + "<font face=" + "Verdana " + "size=" + "2" + ">" +strTime+ "</td>");
					
					
					if(stepCounter1<1 && !threadCount.containsKey(strThreadKey)){
						
					threadCount.put(strThreadKey, stepCounter1++);
					
					}
					else if(!threadCount.containsKey(strThreadKey)){
								threadCount.put(strThreadKey, 0);
					}
					else{
						int tempValue = threadCount.get(strThreadKey);
						tempValue++;
						threadCount.put(strThreadKey, tempValue);
					}
					if(threadCount.containsKey(strThreadKey)){
					runManagerInfoObj.setTestCounter(threadCount.get(strThreadKey));
					TestStepDetailsObj.setTime(strTime);
					stepCounter1 = threadCount.get(strThreadKey);
					String stepKey="Step"+runManagerInfoObj.getTestCounter()+runManagerInfoObj.getStrTestCaseId();
					TestDetailsMap.put(stepKey, TestStepDetailsObj);
					System.out.println("Step key in reporting function"+ stepCounter1 +" Thread Name" + strThreadKey);
			
					}
					
					objResFile.write("</tr>");
					objResFile.close();
			}else
			{
				System.out.println("File does not exists");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("	Message : "+e.getMessage());
			System.err.println("	Cause : "+e.getCause());
		}
		
	}

	
	 public synchronized int increment(int counter) {
	        return counter++;
	    }

	
	public synchronized void FnUpdateEndTest( RunManagerInfo runManagerInfoObj)
	{		
		Lock lock = new ReentrantLock();
		try{
			//Velu
			RunManager.testcaseuuid = "maxTimeuuid('"+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(new Date())+"')";;
			if(RunManager.TestCaseFailed)
			{
				RunManager.TestCaseFail++;
				strPresentDir = getRelativePath();
				String[] path=strPresentDir.split("Workspace");
				System.out.println("first val: "+ path[0]);
				String p=path[0]+"ExecReports";	
				
				String machinetype=getPlat();
				String filepath ="";
				
				if(machinetype.equalsIgnoreCase("MAC"))
				{
					filepath=p+"//ExecSummary//funtestres1.xls";
				}
				else{
					filepath=p+"\\ExecSummary\\funtestres1.xls";
						
					}
				FileInputStream fis = new FileInputStream(filepath);
				HSSFWorkbook wb = new HSSFWorkbook(fis);
			     HSSFSheet sheet = wb.getSheet("funtestres1");
			    int count=0;
			     while(RunManager.startTestCase != RunManager.intRowCounter)
			     {
			    	 System.out.println("counter:"+count++);
			    	 
			    	 HSSFRow row     = sheet.getRow(RunManager.startTestCase++);
			    	 if(null != row)
			    	 row.getCell(13).setCellValue("FAIL");
			     }
			     FileOutputStream  fos =new FileOutputStream(filepath);
			     wb.write(fos);            
			     fos.close();	
			     fis.close();
			     
			}
			else
			{
				RunManager.TestCasePass++;
			}
			RunManager.TestCaseFailed = false;
			RunManager.startTestCase = RunManager.intRowCounter;
			 //Anandavelu - start
			strPresentDir = getRelativePath();
			String[] path=strPresentDir.split("Workspace");
			System.out.println("first val: "+ path[0]);
			String p=path[0]+"ExecReports";	
			
			String machinetype=getPlat();
			String filepath ="";
			
			if(machinetype.equalsIgnoreCase("MAC"))
			{
				filepath=p+"//ExecSummary//funtestres1.xls";
			}
			else{
				filepath=p+"\\ExecSummary\\funtestres1.xls";
					
				}
			 FileInputStream fis8 = new FileInputStream(filepath);
			 HSSFWorkbook wb8 = new HSSFWorkbook(fis8);
		     HSSFSheet sheet8 = wb8.getSheet("funtestres1");		    
		     HSSFRow row8     = sheet8.getRow(RunManager.startTestCase - 1);
		     if(null != row8)
		     {
		     String Envir = row8.getCell(0).getStringCellValue();
		     String applic = row8.getCell(1).getStringCellValue();
		     String tcuuid = row8.getCell(4).getStringCellValue();
		     String modname = row8.getCell(10).getStringCellValue();
		     String tcname = runManagerInfoObj.getStrTestCaseId();
		     String tcres = row8.getCell(13).getStringCellValue();
		     fis8.close();
		      if(machinetype.equalsIgnoreCase("MAC"))
				{
					filepath=p+"//ExecSummary//funprojfeatfuntestres1.xls";
					m1.put("csv7",filepath);
				}
				else
				{
					filepath=p+"\\ExecSummary\\funprojfeatfuntestres1.xls";	
					m1.put("csv7",filepath);
				}
		      
		      	HSSFWorkbook wb3;
		      	HSSFSheet sheet3;
		      	 HSSFRow row3;
		      	FileInputStream fis3 = null;
		      	FileOutputStream fos3;		      	
		      	if (RunManager.testCaseCount == 0)
				 {
			      	wb3 = new HSSFWorkbook();
					sheet3 = wb3.createSheet("funprojfeatfuntestres1");
					
					 row3     = sheet3.createRow(0);     	
		     		row3.createCell(0).setCellValue("environment "); 
		     		row3.createCell(1).setCellValue("project"); 
		     		row3.createCell(2).setCellValue("feature");
		     		row3.createCell(3).setCellValue("function");
		     		row3.createCell(4).setCellValue("function_run_id");
		     		row3.createCell(5).setCellValue("function_result");
				 }
		      	else
		      	{
		      		fis3 = new FileInputStream(filepath);
		      		wb3 = new HSSFWorkbook(fis3);
		      		sheet3 = wb3.getSheet("funprojfeatfuntestres1");
		      	}				      	
	     		row3     = sheet3.createRow(++RunManager.testCaseCount);
	     		row3.createCell(0).setCellValue(Envir); 
	     		row3.createCell(1).setCellValue(applic); 
	     		row3.createCell(2).setCellValue(modname);
	     		row3.createCell(3).setCellValue(tcname);
	     		row3.createCell(4).setCellValue(tcuuid);
	     		row3.createCell(5).setCellValue(tcres);
	     		fos3=new FileOutputStream(filepath);
				  wb3.write(fos3);            
			      fos3.close();
			      if (fis3 != null)
			      {
			    	  fis3.close();
			      }
		     
			      if(machinetype.equalsIgnoreCase("MAC"))
					{
						filepath=p+"//ExecSummary//funfuntestres1.xls";
						m1.put("csv6",filepath);
					}
					else
					{
						filepath=p+"\\ExecSummary\\funfuntestres1.xls";	
						m1.put("csv6",filepath);
					}
			      	HSSFWorkbook wb5;
			      	HSSFSheet sheet5;
			      	HSSFRow row5;
			      	FileInputStream fis5 = null;
			      	FileOutputStream fos5;
			      	if (RunManager.testCaseCount == 1)
					 {
				      	wb5 = new HSSFWorkbook();
						sheet5 = wb5.createSheet("funfuntestres1");
						 row5     = sheet5.createRow(0);
			     		row5.createCell(0).setCellValue("function");
			     		row5.createCell(1).setCellValue("function_run_id");
			     		row5.createCell(2).setCellValue("function_result");
					 }
			      	else
			      	{
			      		fis5 = new FileInputStream(filepath);
			      		wb5 = new HSSFWorkbook(fis5);
			      		sheet5 = wb5.getSheet("funfuntestres1");
			      	}				      	
		     		row5     = sheet5.createRow(RunManager.testCaseCount);
		     		row5.createCell(0).setCellValue(tcname);
		     		row5.createCell(1).setCellValue(tcuuid);
		     		row5.createCell(2).setCellValue(tcres);
		     		fos5=new FileOutputStream(filepath);
					  wb5.write(fos5);            
				      fos5.close();
				      if (fis5 != null)
				    	  fis5.close();
				      
				      if(machinetype.equalsIgnoreCase("MAC"))
						{
							filepath=p+"//ExecSummary//funfeatfuntestres1.xls";
							m1.put("csv5",filepath);
						}
						else
						{
							filepath=p+"\\ExecSummary\\funfeatfuntestres1.xls";	
							m1.put("csv5",filepath);
						}
				      	HSSFWorkbook wb6;
				      	HSSFSheet sheet6;
				      	HSSFRow row6;
				      	FileInputStream fis6 = null;
				      	FileOutputStream fos6;
				      	if (RunManager.testCaseCount == 1)
						 {
					      	wb6 = new HSSFWorkbook();
							sheet6 = wb6.createSheet("funfeatfuntestres1");
							 row6     = sheet6.createRow(0);
							 row6.createCell(0).setCellValue("feature");
				     		row6.createCell(1).setCellValue("function");
				     		row6.createCell(2).setCellValue("function_run_id");
				     		row6.createCell(3).setCellValue("function_result");
						 }
				      	else
				      	{
				      		fis6 = new FileInputStream(filepath);
				      		wb6 = new HSSFWorkbook(fis6);
				      		sheet6 = wb6.getSheet("funfeatfuntestres1");
				      	}				      	
			     		row6     = sheet6.createRow(RunManager.testCaseCount);
			     		row6.createCell(0).setCellValue(modname);
			     		row6.createCell(1).setCellValue(tcname);
			     		row6.createCell(2).setCellValue(tcuuid);
			     		row6.createCell(3).setCellValue(tcres);
			     		fos6=new FileOutputStream(filepath);
						  wb6.write(fos6);            
					      fos6.close();					                
					      if (fis6 != null)
					    	  fis6.close();
		     //Anandavelu -end
			//Velu
			String keyName="HTMLFile"+runManagerInfoObj.getStrTestCaseId();
			String FileName=m1.get(keyName).toString();			
			Calendar cal = Calendar.getInstance();			
			SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
	    	String strTime=sdf1.format(cal.getTime());
	    	EndTime=strTime;
	    	Date d=sdf1.parse(StartTime);
			Date dd=sdf1.parse(EndTime);
			
			long diff = dd.getTime() - d.getTime();			
			double diffInMins = diff / ((double) 1000 * 60);			
			String overallStatusKey="OVERALLSTATUS"+runManagerInfoObj.getStrTestCaseId();
			File fo = new File(FileName);
			if(fo.exists())
			{				
				OutputStreamWriter objResFile = new OutputStreamWriter(new FileOutputStream(FileName,true));
				
				objResFile.write("<tr>");
				objResFile.write("<td COLSPAN = 5 >");	
				objResFile.write("<p align=justify><b><font color=#000080 size=2 face= Verdana>"+ "Execution End Time:"+  strTime + " MST");
			    objResFile.write("</td>");
			    objResFile.write("</tr>");
			    
			    objResFile.write("<tr>");
				objResFile.write("<td COLSPAN = 5 >");	
				objResFile.write("<p align=justify><b><font color=#000080 size=2 face= Verdana>"+ "Overall Execution Status:"+  m1.get(overallStatusKey).toString());
			    objResFile.write("</td>");
			    objResFile.write("</tr>");
			    
			    objResFile.write("<tr>");
				objResFile.write("<td COLSPAN = 5 >");	
				objResFile.write("<p align=justify><b><font color=#000080 size=2 face= Verdana>"+ "Overall Execution Time (in Mins):"+  Math.round(diffInMins));
			    objResFile.write("</td>");
			    objResFile.write("</tr>");
			    objResFile.close();
			}else
			{
				System.out.println("File does not exists");
			}
			//String FileNameEdit=m1.get("SummaryJSONFNL").toString();
			 String strCaseName=runManagerInfoObj.getStrCaseName();
			 
			 			
			
		    	String ModuleEndTime=sdf1.format(cal.getTime());
		    	String moduleEndKey="moduleEndTime"+runManagerInfoObj.getAppmodule();
				m1.put(moduleEndKey, ModuleEndTime);
			 
			 FnUpdateSummaryHTML( runManagerInfoObj);
			 
			 
			 
			 if(!strCaseName.equalsIgnoreCase(INTERMEDIATE_LOGIN) && !strCaseName.equalsIgnoreCase(INTERMEDIATE_LOGOUT)){
				 FnUpdateSummaryXL(intCounter,runManagerInfoObj);
				 intCounter=intCounter+1;
			 }
		     }
			 
		     
				
				
				
				
		     
		     
			// FnCloseDriver();
		}catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("	Message : "+e.getMessage());
			System.err.println("	Cause : "+e.getCause());
		}
	
		
	}
	
	
	public String takeScreenshot(RunManagerInfo runManagerInfoObj)
	{
		String screenshotPath;
		try
		{
			String RESULTS_FOLDERkey="RESULTS_FOLDER"+runManagerInfoObj.getStrTestCaseId();
		   	String filename=m1.get(RESULTS_FOLDERkey).toString();
		System.out.println("fILENAME:"+filename);
  		   
  		   	//File theDir = new File(filename+"\\Screenshots");
  		   	//theDir.mkdir();
  		   	Calendar cal = Calendar.getInstance();
  		   	SimpleDateFormat sdf1= new SimpleDateFormat("ddMMyyyy_HH_mm_ss");
	    	String strTime=sdf1.format(cal.getTime());
	    	
			String StrFileName="Step"+StepCounter+"_"+strTime;
  		   	File theDir;
			String p=m1.get("PLATFORM").toString();
			
			if(p.equalsIgnoreCase("MAC"))
			{
				theDir = new File(filename+"//Screenshots");			
				screenshotPath=filename+"//Screenshots//"+StrFileName+".png";
				//screenshotPath=screenshotPath.replace("/", "\\");
			}else{
				theDir = new File(filename+"\\Screenshots");
				screenshotPath=filename+"\\Screenshots\\"+StrFileName+".png";
				screenshotPath=screenshotPath.replace("/", "\\");
			}

  		   	theDir.mkdir();
			
			this.captureScreenShot(screenshotPath,"png");	
			
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(screenshotPath), true);
			
		} catch (Exception e)
		{
			String RESULTS_FOLDERkey="RESULTS_FOLDER"+runManagerInfoObj.getStrTestCaseId();
			screenshotPath=m1.get(RESULTS_FOLDERkey).toString();
		
			e.printStackTrace();
			//throw new FrameworkException("Error while writing screenshot to file");
		}
		return screenshotPath;
	}
	
	public void captureScreenShot(String fileName,String strImageType)
	{
		try
		{
			Dimension dimScreen = Toolkit.getDefaultToolkit().getScreenSize();
		/*	int iWidth = dimScreen.width;
			int iHeight = dimScreen.height;		
			this.screenCapture(fileName, strImageType, 0, 0, iWidth, iHeight);*/
						
			Rectangle recScreen = new Rectangle(dimScreen);
			//Capture screen shot
			Robot robot = new Robot();
			BufferedImage bufScreenImage = robot.createScreenCapture(recScreen);
			//Save captured image to specified file format
			ImageIO.write(bufScreenImage, strImageType, new File(fileName));
			bufScreenImage.flush();
			
		}
		catch(Exception exception)
		{
		}		
	}
	
	public void screenCapture (String strDestFilename,String strImageType, int x, int y, int width, int height)
	{
		try
		{
			Rectangle recScreen = new Rectangle(x, y, width, height);
			//Capture screen shot
			Robot robot = new Robot();
			BufferedImage bufScreenImage = robot.createScreenCapture(recScreen);
			//Save captured image to specified file format
			ImageIO.write(bufScreenImage, strImageType, new File(strDestFilename));
			bufScreenImage.flush();
		}
		catch (Exception exception) 
		{
		}
	}
		
	public synchronized void FnCom_AbortExec(WebDriver driver,RunManagerInfo runManagerInfoObj)
	{	
		FnCloseDriver(driver);	
	}
	public void FnCom_AbortExec_Q2LoggedIn()
		
	{
		try{
			boolean status =  false;
			//FnCom_LogoutOnErr();			
			m1.put("TS_STATUS","FAIL");
		
			CharterAppFunctions charapp=new CharterAppFunctions();
			//status = charapp.FnNavigateBack_Payment_WG();		
			if(status){
				System.out.println("inside if block, nothing to do");
				// Do nothing
			}
			else{
				System.out.println("inside else block, login again");
			//	charapp.FnVerifySignInLinkAndClick();
			//	charapp.FnUserLogin_WallOfGarden();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());			
		}	
	
		//FnCloseDriver();	
	}
	public void FnCom_ThrowException(Exception e,WebDriver driver) throws Exception
	{
		FnCom_LogoutOnErr(driver);
		String strTC=m1.get("TESTCASE").toString();			
		System.err.println(strTC);			
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	
//		FnUpdateTestStepResHTML("Catch Exception", "Catch Exception in test script: "+strTC+ " ;Execution Aborted","DONE");
		
		//FnUpdateEndTest(runManagerInfoObj);
		CharterAppFunctions charapp=new CharterAppFunctions();
		//charapp.FnFeedback();
		
	}
	
	public void FnCloseDriver(WebDriver driver)
	{
		driver.quit();
	}
	/*=====================================================================================================
	Function closeBrowserForLogoutFailure
	Parameters:None 
	Description: Close the browser after deletion of cookies
	Author: Shanmuga Priya Ganesan
	Created Date: Feb 26, 2015
	=====================================================================================================*/
	public void closeBrowserForLogoutFailure(){
		try{
			driver.manage().deleteAllCookies();
			driver.close();	
		}catch(Exception e)
		{	
		}	
	
		driver.quit();
	}
	
	
	public boolean FnCom_LogoutOnErr(WebDriver driver)
	{
		boolean blnFlag=false;
		try{			
			//FnFeedback();
			if(driver.getTitle().contains("spectrumbusiness.net"))
					{
				driver.quit();
					}
		}catch(Exception e)
		{			
			e.printStackTrace();
			//FnUpdateTestStepResHTML("Click Sign out button", "Sign Out Action is not performed","FAIL");
			//driver.close();
			blnFlag=false;
			System.err.println("	Message : "+e.getMessage());
			System.err.println("	Cause : "+e.getCause());
			
		}
		return blnFlag;
	}
	
	/*=====================================================================================================
	Function checkInitialLoginStatus
	Parameters: None	 
	Description: This function checks whether initial Login was successful and returns boolean based on the status
	Author: Shanmuga Priya Ganesan
	Created Date: Feb 25, 2015
	=====================================================================================================*/
	
	public boolean checkInitialLoginStatus(){
		boolean initLoginSuccess = false;
		if(null != m1.get("initialLogin") && (m1.get("initialLogin").toString()).equalsIgnoreCase("PASS")){
			initLoginSuccess = true;
		}
		return initLoginSuccess;
		
		
	}
	
	
	///Method added for converting Excel file to CSV formatted file
	//
	//
	//
	//
	public static void FnConverXltoCSV(String workbookPath) throws IOException, ParseException{
		
		try {
            cellGrid = new ArrayList<List<HSSFCell>>();
            FileInputStream myInput = new FileInputStream(workbookPath);
            POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);
            HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);
            HSSFSheet mySheet = myWorkBook.getSheetAt(0);
            Iterator<?> rowIter = mySheet.rowIterator();

            while (rowIter.hasNext()) {
                HSSFRow myRow = (HSSFRow) rowIter.next();
                Iterator<?> cellIter = myRow.cellIterator();
                List<HSSFCell> cellRowList = new ArrayList<HSSFCell>();
                while (cellIter.hasNext()) {
                    HSSFCell myCell = (HSSFCell) cellIter.next();
                    
                    cellRowList.add(myCell);
                }
                cellGrid.add(cellRowList);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		String strCassendratablename="triage_test_results";	
		//C:\Users\nirmalkumar_r01\workspace\Traige_Framework\Charter3.01_CSVExecReports\ExecSummary
		String CassandraFilePath = workbookPath.substring(0, workbookPath.lastIndexOf("\\"));
		CassandraFilePath = CassandraFilePath + "\\"+strCassendratablename + ".csv";
		System.out.println(CassandraFilePath);
		File file = new File(CassandraFilePath);
        //File file = new File(workbookPath.replace(".html", "").replace(".xlsx", "")  + ".csv");
        PrintStream stream = new PrintStream(file);
        int totalsize=0;
        for (int i = 0; i < cellGrid.size(); i++) {
            List<HSSFCell> cellRowList = cellGrid.get(i);
            for (int j = 0; j < cellRowList.size(); j++) {
                HSSFCell myCell = (HSSFCell) cellRowList.get(j);
                String stringCellValue = myCell.toString();
                if(totalsize==cellRowList.size()-1)
                {
                	
	                if(i>0)
	                {
		                SimpleDateFormat timeconv= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
		                Date d=timeconv.parse(stringCellValue);
		                SimpleDateFormat printconv= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		                
		                String executiontime=printconv.format(d);
						String strtime=executiontime+"+0000";
						stream.print(strtime);
	                }
	                else
	                {
	                	stream.print(stringCellValue.replace("\n", ""));
	                }
				
                }
                else
                {
                	stream.print(stringCellValue.replace("\n", "") + ",");
                }
                totalsize++;
                
               
            }
            stream.println("");
            totalsize=0;
        }
 
        stream.close();
	}
	
public static void FnConverXltoCSV2(String workbookPath) throws IOException, ParseException{
		
		try {
            cellGrid = new ArrayList<List<HSSFCell>>();
            FileInputStream myInput = new FileInputStream(workbookPath);
            POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);
            HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);
            HSSFSheet mySheet = myWorkBook.getSheetAt(0);
            Iterator<?> rowIter = mySheet.rowIterator();

            while (rowIter.hasNext()) {
                HSSFRow myRow = (HSSFRow) rowIter.next();
                Iterator<?> cellIter = myRow.cellIterator();
                List<HSSFCell> cellRowList = new ArrayList<HSSFCell>();
                while (cellIter.hasNext()) {
                    HSSFCell myCell = (HSSFCell) cellIter.next();
                    
                    cellRowList.add(myCell);
                }
                cellGrid.add(cellRowList);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		String strCassendratablename="functional_test_results";		//1/13/2016
		//C:\Users\nirmalkumar_r01\workspace\Traige_Framework\Charter3.01_CSVExecReports\ExecSummary
		String CassandraFilePath = workbookPath.substring(0, workbookPath.lastIndexOf("\\"));
		CassandraFilePath = CassandraFilePath + "\\reportsInCSV\\";
		File newFile = new File(CassandraFilePath);
		if(!newFile.exists())
		{
			newFile.mkdirs();
		}
		CassandraFilePath = CassandraFilePath + "\\"+strCassendratablename + ".csv";
		System.out.println(CassandraFilePath);
		File file = new File(CassandraFilePath);
        //File file = new File(workbookPath.replace(".html", "").replace(".xlsx", "")  + ".csv");
        PrintStream stream = new PrintStream(file);
        int totalsize=0;
        for (int i = 0; i < cellGrid.size(); i++) {
            List<HSSFCell> cellRowList = cellGrid.get(i);
            for (int j = 0; j < cellRowList.size(); j++) {
                HSSFCell myCell = (HSSFCell) cellRowList.get(j);
                String stringCellValue = myCell.toString();
                stringCellValue = stringCellValue.replace(",", " ");
                System.out.println(stringCellValue);
                if(totalsize==cellRowList.size()-2||totalsize==cellRowList.size()-5)
                {
                	
	               if(i>0)
	                {
	            	   try{
		                SimpleDateFormat timeconv= new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");
		                Date d=timeconv.parse(stringCellValue);
		                SimpleDateFormat printconv= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");       	   
		                
		               
		               stringCellValue=printconv.format(d).toString();
	            	   }
	            	   catch(Exception e){
	            		   System.out.println("Error in time conversion");
	            		   	SimpleDateFormat timeconv= new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");
			                Date d=timeconv.parse(Calendar.getInstance().getTime().toString());
			                SimpleDateFormat printconv= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			                stringCellValue=printconv.format(d).toString();
	            	   }
		               
						stream.print(stringCellValue.replace("\n", "") + ",");
					
	                }
	                else
	                {
	                	stream.print(stringCellValue.replace("\n", "") + ",");
	                }
				
                }
                else
                {
                	if(totalsize!= cellRowList.size()-1){
                	stream.print(stringCellValue.replace("\n", "") + ",");
                	}else{
                		stream.print(stringCellValue.replace("\n", " "));
                	}
                }
                totalsize++;
                
               
            }
            stream.println("");
            totalsize=0;
        }
 
        stream.close();
	}
public static void FnConverXltoCSV4(String workbookPath) throws IOException, ParseException{
	
	try {
        cellGrid = new ArrayList<List<HSSFCell>>();
        FileInputStream myInput = new FileInputStream(workbookPath);
        POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);
        HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);
        HSSFSheet mySheet = myWorkBook.getSheetAt(0);
        Iterator<?> rowIter = mySheet.rowIterator();

        while (rowIter.hasNext()) {
            HSSFRow myRow = (HSSFRow) rowIter.next();
            Iterator<?> cellIter = myRow.cellIterator();
            List<HSSFCell> cellRowList = new ArrayList<HSSFCell>();
            while (cellIter.hasNext()) {
                HSSFCell myCell = (HSSFCell) cellIter.next();
                
                cellRowList.add(myCell);
            }
            cellGrid.add(cellRowList);
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
	String strCassendratablename="functional_func_test_results";	//1/13/2016
	//C:\Users\nirmalkumar_r01\workspace\Traige_Framework\Charter3.01_CSVExecReports\ExecSummary
	String CassandraFilePath = workbookPath.substring(0, workbookPath.lastIndexOf("\\"));
	CassandraFilePath = CassandraFilePath + "\\reportsInCSV\\";
	CassandraFilePath = CassandraFilePath + "\\"+strCassendratablename + ".csv";
	System.out.println(CassandraFilePath);
	File file = new File(CassandraFilePath);
    //File file = new File(workbookPath.replace(".html", "").replace(".xlsx", "")  + ".csv");
    PrintStream stream = new PrintStream(file);
    int totalsize=0;
    for (int i = 0; i < cellGrid.size(); i++) {
        List<HSSFCell> cellRowList = cellGrid.get(i);
        for (int j = 0; j < cellRowList.size(); j++) {
            HSSFCell myCell = (HSSFCell) cellRowList.get(j);
            String stringCellValue = myCell.toString();
            stringCellValue = stringCellValue.replace(",", " ");
            if(totalsize==cellRowList.size()-1)
            {
            	
             /*   if(i>0)
                {
	                SimpleDateFormat timeconv= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
	                Date d=timeconv.parse(stringCellValue);
	                SimpleDateFormat printconv= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	                
	                String executiontime=printconv.format(d);
					String strtime=executiontime+"+0000";
					stream.print(strtime);
                }
                else
                {
                */	stream.print(stringCellValue.replace("\n", ""));
             
			
            }
            else
            {
            	stream.print(stringCellValue.replace("\n", "") + ",");
            }
            totalsize++;
            
           
        }
        stream.println("");
        totalsize=0;
    }

    stream.close();
}
public static void FnConverXltoCSV5(String workbookPath) throws IOException, ParseException{
	
	try {
        cellGrid = new ArrayList<List<HSSFCell>>();
        FileInputStream myInput = new FileInputStream(workbookPath);
        POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);
        HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);
        HSSFSheet mySheet = myWorkBook.getSheetAt(0);
        Iterator<?> rowIter = mySheet.rowIterator();

        while (rowIter.hasNext()) {
            HSSFRow myRow = (HSSFRow) rowIter.next();
            Iterator<?> cellIter = myRow.cellIterator();
            List<HSSFCell> cellRowList = new ArrayList<HSSFCell>();
            while (cellIter.hasNext()) {
                HSSFCell myCell = (HSSFCell) cellIter.next();
                
                cellRowList.add(myCell);
            }
            cellGrid.add(cellRowList);
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
	String strCassendratablename="functional_ins_reference";	//1/13/2016
	//C:\Users\nirmalkumar_r01\workspace\Traige_Framework\Charter3.01_CSVExecReports\ExecSummary
	String CassandraFilePath = workbookPath.substring(0, workbookPath.lastIndexOf("\\"));
	CassandraFilePath = CassandraFilePath + "\\reportsInCSV\\";
	CassandraFilePath = CassandraFilePath + "\\"+strCassendratablename + ".csv";
	System.out.println(CassandraFilePath);
	File file = new File(CassandraFilePath);
    //File file = new File(workbookPath.replace(".html", "").replace(".xlsx", "")  + ".csv");
    PrintStream stream = new PrintStream(file);
    int totalsize=0;
    for (int i = 0; i < cellGrid.size(); i++) {
        List<HSSFCell> cellRowList = cellGrid.get(i);
        for (int j = 0; j < cellRowList.size(); j++) {
            HSSFCell myCell = (HSSFCell) cellRowList.get(j);
            String stringCellValue = myCell.toString();
            stringCellValue = stringCellValue.replace(",", " ");
            if(totalsize==cellRowList.size()-1)
            {
            	
             /*   if(i>0)
                {
	                SimpleDateFormat timeconv= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
	                Date d=timeconv.parse(stringCellValue);
	                SimpleDateFormat printconv= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	                
	                String executiontime=printconv.format(d);
					String strtime=executiontime+"+0000";
					stream.print(strtime);
                }
                else
                {
                */	stream.print(stringCellValue.replace("\n", ""));
             
			
            }
            else
            {
            	stream.print(stringCellValue.replace("\n", "") + ",");
            }
            totalsize++;
            
           
        }
        stream.println("");
        totalsize=0;
    }

    stream.close();
}
public static void FnConverXltoCSV6(String workbookPath) throws IOException, ParseException{
	
	try {
        cellGrid = new ArrayList<List<HSSFCell>>();
        FileInputStream myInput = new FileInputStream(workbookPath);
        POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);
        HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);
        HSSFSheet mySheet = myWorkBook.getSheetAt(0);
        Iterator<?> rowIter = mySheet.rowIterator();

        while (rowIter.hasNext()) {
            HSSFRow myRow = (HSSFRow) rowIter.next();
            Iterator<?> cellIter = myRow.cellIterator();
            List<HSSFCell> cellRowList = new ArrayList<HSSFCell>();
            while (cellIter.hasNext()) {
                HSSFCell myCell = (HSSFCell) cellIter.next();
                
                cellRowList.add(myCell);
            }
            cellGrid.add(cellRowList);
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
	String strCassendratablename="functional_project_feature_func_test_results";	//1/13/2016
	//C:\Users\nirmalkumar_r01\workspace\Traige_Framework\Charter3.01_CSVExecReports\ExecSummary
	String CassandraFilePath = workbookPath.substring(0, workbookPath.lastIndexOf("\\"));
	CassandraFilePath = CassandraFilePath + "\\reportsInCSV\\";
	CassandraFilePath = CassandraFilePath + "\\"+strCassendratablename + ".csv";
	System.out.println(CassandraFilePath);
	File file = new File(CassandraFilePath);
    //File file = new File(workbookPath.replace(".html", "").replace(".xlsx", "")  + ".csv");
    PrintStream stream = new PrintStream(file);
    int totalsize=0;
    for (int i = 0; i < cellGrid.size(); i++) {
        List<HSSFCell> cellRowList = cellGrid.get(i);
        for (int j = 0; j < cellRowList.size(); j++) {
            HSSFCell myCell = (HSSFCell) cellRowList.get(j);
            String stringCellValue = myCell.toString();
            stringCellValue = stringCellValue.replace(",", " ");
            if(totalsize==cellRowList.size()-1)
            {
            	
             /*   if(i>0)
                {
	                SimpleDateFormat timeconv= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
	                Date d=timeconv.parse(stringCellValue);
	                SimpleDateFormat printconv= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	                
	                String executiontime=printconv.format(d);
					String strtime=executiontime+"+0000";
					stream.print(strtime);
                }
                else
                {
                */	stream.print(stringCellValue.replace("\n", ""));
             
			
            }
            else
            {
            	stream.print(stringCellValue.replace("\n", "") + ",");
            }
            totalsize++;
            
           
        }
        stream.println("");
        totalsize=0;
    }

    stream.close();
}
public static void FnConverXltoCSV7(String workbookPath) throws IOException, ParseException{
	
	try {
        cellGrid = new ArrayList<List<HSSFCell>>();
        FileInputStream myInput = new FileInputStream(workbookPath);
        POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);
        HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);
        HSSFSheet mySheet = myWorkBook.getSheetAt(0);
        Iterator<?> rowIter = mySheet.rowIterator();

        while (rowIter.hasNext()) {
            HSSFRow myRow = (HSSFRow) rowIter.next();
            Iterator<?> cellIter = myRow.cellIterator();
            List<HSSFCell> cellRowList = new ArrayList<HSSFCell>();
            while (cellIter.hasNext()) {
                HSSFCell myCell = (HSSFCell) cellIter.next();
                
                cellRowList.add(myCell);
            }
            cellGrid.add(cellRowList);
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
	String strCassendratablename="functional_project_feature_test_results";	//1/13/2016
	//C:\Users\nirmalkumar_r01\workspace\Traige_Framework\Charter3.01_CSVExecReports\ExecSummary
	String CassandraFilePath = workbookPath.substring(0, workbookPath.lastIndexOf("\\"));
	CassandraFilePath = CassandraFilePath + "\\reportsInCSV\\";
	CassandraFilePath = CassandraFilePath + "\\"+strCassendratablename + ".csv";
	System.out.println(CassandraFilePath);
	File file = new File(CassandraFilePath);
    //File file = new File(workbookPath.replace(".html", "").replace(".xlsx", "")  + ".csv");
    PrintStream stream = new PrintStream(file);
    int totalsize=0;
    for (int i = 0; i < cellGrid.size(); i++) {
        List<HSSFCell> cellRowList = cellGrid.get(i);
        for (int j = 0; j < cellRowList.size(); j++) {
            HSSFCell myCell = (HSSFCell) cellRowList.get(j);
            String stringCellValue = myCell.toString();
            stringCellValue = stringCellValue.replace(",", " ");
            if(totalsize==cellRowList.size()-1)
            {
            	
             /*   if(i>0)
                {
	                SimpleDateFormat timeconv= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
	                Date d=timeconv.parse(stringCellValue);
	                SimpleDateFormat printconv= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	                
	                String executiontime=printconv.format(d);
					String strtime=executiontime+"+0000";
					stream.print(strtime);
                }
                else
                {
                */	stream.print(stringCellValue.replace("\n", ""));
             
			
            }
            else
            {
            	stream.print(stringCellValue.replace("\n", "") + ",");
            }
            totalsize++;
            
           
        }
        stream.println("");
        totalsize=0;
    }

    stream.close();
}
public static void FnConverXltoCSV8(String workbookPath) throws IOException, ParseException{
	
	try {
        cellGrid = new ArrayList<List<HSSFCell>>();
        FileInputStream myInput = new FileInputStream(workbookPath);
        POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);
        HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);
        HSSFSheet mySheet = myWorkBook.getSheetAt(0);
        Iterator<?> rowIter = mySheet.rowIterator();

        while (rowIter.hasNext()) {
            HSSFRow myRow = (HSSFRow) rowIter.next();
            Iterator<?> cellIter = myRow.cellIterator();
            List<HSSFCell> cellRowList = new ArrayList<HSSFCell>();
            while (cellIter.hasNext()) {
                HSSFCell myCell = (HSSFCell) cellIter.next();
                
                cellRowList.add(myCell);
            }
            cellGrid.add(cellRowList);
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
	String strCassendratablename="functional_project_test_results";	//1/13/2016
	//C:\Users\nirmalkumar_r01\workspace\Traige_Framework\Charter3.01_CSVExecReports\ExecSummary
	String CassandraFilePath = workbookPath.substring(0, workbookPath.lastIndexOf("\\"));
	CassandraFilePath = CassandraFilePath + "\\reportsInCSV\\";
	CassandraFilePath = CassandraFilePath + "\\"+strCassendratablename + ".csv";
	System.out.println(CassandraFilePath);
	File file = new File(CassandraFilePath);
    //File file = new File(workbookPath.replace(".html", "").replace(".xlsx", "")  + ".csv");
    PrintStream stream = new PrintStream(file);
    int totalsize=0;
    for (int i = 0; i < cellGrid.size(); i++) {
        List<HSSFCell> cellRowList = cellGrid.get(i);
        for (int j = 0; j < cellRowList.size(); j++) {
            HSSFCell myCell = (HSSFCell) cellRowList.get(j);
            String stringCellValue = myCell.toString();
            stringCellValue = stringCellValue.replace(",", " ");
            if(totalsize==cellRowList.size()-1)
            {
            	
             /*   if(i>0)
                {
	                SimpleDateFormat timeconv= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
	                Date d=timeconv.parse(stringCellValue);
	                SimpleDateFormat printconv= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	                
	                String executiontime=printconv.format(d);
					String strtime=executiontime+"+0000";
					stream.print(strtime);
                }
                else
                {
                */	stream.print(stringCellValue.replace("\n", ""));
             
			
            }
            else
            {
            	stream.print(stringCellValue.replace("\n", "") + ",");
            }
            totalsize++;
            
           
        }
        stream.println("");
        totalsize=0;
    }

    stream.close();
}

public static void FnConverXltoCSV3(String workbookPath) throws IOException, ParseException{
	
	try {
        cellGrid = new ArrayList<List<HSSFCell>>();
        FileInputStream myInput = new FileInputStream(workbookPath);
        POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);
        HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);
        HSSFSheet mySheet = myWorkBook.getSheetAt(0);
        Iterator<?> rowIter = mySheet.rowIterator();

        while (rowIter.hasNext()) {
            HSSFRow myRow = (HSSFRow) rowIter.next();
            Iterator<?> cellIter = myRow.cellIterator();
            List<HSSFCell> cellRowList = new ArrayList<HSSFCell>();
            while (cellIter.hasNext()) {
                HSSFCell myCell = (HSSFCell) cellIter.next();
                
                cellRowList.add(myCell);
            }
            cellGrid.add(cellRowList);
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
	String strCassendratablename="functional_feature_func_test_results";	//1/13/2016
	//C:\Users\nirmalkumar_r01\workspace\Traige_Framework\Charter3.01_CSVExecReports\ExecSummary
	String CassandraFilePath = workbookPath.substring(0, workbookPath.lastIndexOf("\\"));
	CassandraFilePath = CassandraFilePath + "\\reportsInCSV\\";
	CassandraFilePath = CassandraFilePath + "\\"+strCassendratablename + ".csv";
	System.out.println(CassandraFilePath);
	File file = new File(CassandraFilePath);
    //File file = new File(workbookPath.replace(".html", "").replace(".xlsx", "")  + ".csv");
    PrintStream stream = new PrintStream(file);
    int totalsize=0;
    for (int i = 0; i < cellGrid.size(); i++) {
        List<HSSFCell> cellRowList = cellGrid.get(i);
        for (int j = 0; j < cellRowList.size(); j++) {
            HSSFCell myCell = (HSSFCell) cellRowList.get(j);
            String stringCellValue = myCell.toString();
            stringCellValue = stringCellValue.replace(",", " ");
            if(totalsize==cellRowList.size()-1)
            {
            	
             /*   if(i>0)
                {
	                SimpleDateFormat timeconv= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
	                Date d=timeconv.parse(stringCellValue);
	                SimpleDateFormat printconv= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	                
	                String executiontime=printconv.format(d);
					String strtime=executiontime+"+0000";
					stream.print(strtime);
                }
                else
                {
                */	stream.print(stringCellValue.replace("\n", ""));
             
			
            }
            else
            {
            	stream.print(stringCellValue.replace("\n", "") + ",");
            }
            totalsize++;
            
           
        }
        stream.println("");
        totalsize=0;
    }

    stream.close();
}

	public String getPlat()
	{
		String s=m1.get("PLATFORM").toString();
		return s;
	}
}