package com.charter.sb.utils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.awt.Robot;

import org.apache.commons.exec.LogOutputStream;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;

import com.charter.sb.beans.RunManagerInfo;
import com.charter.sb.controllers.Initialization;
import com.charter.sb.services.CharterAppFunctions;

import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

//import TestScripts.*;

public class RunManager extends Initialization{
	
	ReportingFunctions sf=new ReportingFunctions();
	Initialization li=new Initialization();
	//QCFunctions qcfn=new QCFunctions();
	public int intRowCount=0, intEnvRow=0;
	public int intColCount=0, intEnvCol=0;
	public String strCaseName=null;
	public String strModuleName=null;
	public String strBrowser=null;
	public String strEnvironment=null;
	public String envVariable = null;
	public boolean blnExeStatus;
	public static Map testdata= new HashMap<String, String>();
	public static Map Env= new HashMap<String, String>();	
	public static String[] strModValues;
	
	
	public String ManualTestCaseName=null;
	public String TestScriptName=null;
	public String strStatus=null;
	public String strResFolder=null;
	public String strResFile=null;
	public String strExecTime=null;
	public final int MAX_Permissible_Thread= 40;

	//Velu
	
	public static int startTestProject = 1;
	public static int startTestCase = 1;
	public static int startTestModule = 1;
	public static int TestCasePass = 0;
	public static int TestCaseFail = 0;
	public static boolean TestCaseFailed = false;
	
	public static String testprojectuuid = null;
	public static String testmoduleuuid = null;
	public static String testcaseuuid = null;
	public static String teststepuuid = null;
	public static Date PreviousTime=new Date();
	public static int intRowCounter = 1;
	public static String strTestType = "Scheduled"; 
	public static double[] modulePassPercentage;
	public static int testCaseCount = 0; //Anandavelu
	
	
	public static void initializeReportingCSV()
	{	
		
		
		testCaseCount = 0; 	//Anandavelu 
		startTestProject = 1;
		startTestCase = 1;
		startTestModule = 1;
		TestCasePass = 0;
		TestCaseFail = 0;
		TestCaseFailed = false;
	
		
		
		testprojectuuid ="maxTimeuuid('"+newDate(1)+"')";
		testmoduleuuid = "maxTimeuuid('"+newDate(2)+"')";
		testcaseuuid = "maxTimeuuid('"+newDate(3)+"')";
		teststepuuid = "maxTimeuuid('"+newDate(4)+"')";
		PreviousTime = new Date();
		intRowCounter = 1;
		strTestType = "Scheduled"; 
		modulePassPercentage = null;
		
		String strPresDir = getRelativePath();
		String[] path=strPresDir.split("Workspace");
		System.out.println("first val: "+ path[0]);
		String p=path[0]+"ExecReports";	
		
		Initialization.getCurrentPlatform();
		String machinetype= m1.get("PLATFORM").toString();;
		String filepath ="";
		
		if(machinetype.equalsIgnoreCase("MAC"))
		{
			filepath=p+"//ExecSummary//";
			try{
				File file = new File(filepath);
				if (!file.exists()) {				
					if (file.mkdirs())
						System.out.println("Directory successfully created");
					else
					System.out.println("Failed to create directory");
				}
			}catch(Exception e)
			{
				System.out.println("Exception to create directory: " + e.getMessage());
			}
			filepath += "funtestres1.xls";
			m1.put("csv",filepath);
		}
		else{
			filepath=p+"\\ExecSummary\\";
			try{
				File file = new File(filepath);
				if (!file.exists()) {				
					if (file.mkdirs())
						System.out.println("Directory successfully created");
					else
					System.out.println("Failed to create directory");
				}
			}catch(Exception e)
			{
				System.out.println("Exception to create directory: " + e.getMessage());
			}
			filepath += "funtestres1.xls";			
			m1.put("csv",filepath);
		}
		
		
		try{			
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("funtestres1");
		
			 FileOutputStream fos =new FileOutputStream(filepath);
			 HSSFRow row     = sheet.createRow(0);     	
     		row.createCell(0).setCellValue("environment "); 
     		row.createCell(1).setCellValue("project"); 
     		row.createCell(2).setCellValue("project_run_id");
     		row.createCell(3).setCellValue("feature_run_id");
     		row.createCell(4).setCellValue("function_run_id");
     		row.createCell(5).setCellValue("api_run_id");
     		row.createCell(6).setCellValue("api");
     		row.createCell(7).setCellValue("api_result");
     		row.createCell(8).setCellValue("completeurl");
     		row.createCell(9).setCellValue("componentversion");
     		row.createCell(10).setCellValue("feature");
     		row.createCell(11).setCellValue("feature_result");
     		row.createCell(12).setCellValue("function");
     		row.createCell(13).setCellValue("function_result");
     		row.createCell(14).setCellValue("hostname");
     		row.createCell(15).setCellValue("macaddress");
     		row.createCell(16).setCellValue("methodtype");
     		row.createCell(17).setCellValue("project_result");
     		row.createCell(18).setCellValue("testdurationinms");
     		row.createCell(19).setCellValue("testendsat");
     		row.createCell(20).setCellValue("testrequestdata");
     		row.createCell(21).setCellValue("testresponsedata");
     		row.createCell(22).setCellValue("teststartsat");
     		row.createCell(23).setCellValue("testtype");     		
			  wb.write(fos);            
		      fos.close();	
	      
//	      HSSFWorkbook wb1 = new HSSFWorkbook();
//	      wb1.getSheet("funtestres1");
//	       fos =new FileOutputStream(filepath);
//	       HSSFRow row1     = sheet.createRow(1);
//	       HSSFRow row0     = sheet.getRow(0);
//	       row0.getCell(0).setCellValue("hi");
//	       row1.createCell(0).setCellValue("hi");
//	       wb.write(fos);
	      
		}catch(Exception e)
		{System.out.println("File handling exception occured :" + e.getMessage());}
	}
		//Velu
	
	
/*=====================================================================================================
	Function FnCom_GetModule
	Parameters: strWorkBookName 
	Description: This function is used to identify modules with the Execution flag "Y" & get the env details
	Author: Dhivya Durairaj
	Created Date: Mar 07, 2014
	=====================================================================================================*/
	public String[] FnCom_GetModule(String strWorkBookName)	
	{
		try{			
			Workbook strWorkBook = Workbook.getWorkbook(new File(strWorkBookName));
			intRowCount=strWorkBook.getSheet("Modules").getRows();
			intColCount=strWorkBook.getSheet("Modules").getColumns();	
			System.out.println("intRowCount: "+intRowCount);
			System.out.println("intColCount: "+intColCount);
			String[] arrColHeader=new String[intColCount];
			int intC=0;
			for(int i=0;i<intRowCount;i++)
			{
				String strExecFlag=strWorkBook.getSheet("Modules").getCell(1, i).getContents();
			//	System.out.println(strExecFlag);
				if(strExecFlag.equalsIgnoreCase("Y"))
				{
					intC=intC+1;
				}
			}
			
			//System.out.println("Yes val: " + intC);
			strModValues = new String[intC];
			int Counter=0;
			//fetch env related data
			for(int iLoop=0;iLoop<intRowCount;iLoop++)
			{
				String strExecFlag=strWorkBook.getSheet("Modules").getCell(1, iLoop).getContents();
				//System.out.println(strExecFlag);
				if(strExecFlag.equalsIgnoreCase("Y"))
				{
					strModuleName=strWorkBook.getSheet("Modules").getCell(0, iLoop).getContents();	
					strBrowser=strWorkBook.getSheet("Modules").getCell(2, iLoop).getContents();
					strEnvironment=strWorkBook.getSheet("Modules").getCell(3, iLoop).getContents();
					moduledetails.put(iLoop, strModuleName);
			//		System.out.println("Counter: "+ Counter + "iLoop: "+iLoop);
					if(Counter<=intC)
					{
						strModValues[Counter]=strModuleName+";"+ strBrowser+";"+ strEnvironment ;					
				//		System.out.println("mod value" + strModValues[Counter]);
						Counter=Counter+1;
					}
				/*	if(!strEnvironment.isEmpty())
					{
						int intRowCount1=strWorkBook.getSheet("Environment").getRows();
						int intColCount1=strWorkBook.getSheet("Environment").getColumns();
						int intR1=strWorkBook.getSheet("Environment").findCell(strEnvironment).getRow();
						String[] arrColHeader1=new String[intColCount1];
						for(int i1=0;i1<intColCount1;i1++)
						{
							arrColHeader1[i1]=strWorkBook.getSheet("Environment").getCell(i1, 0).getContents();	
							String strVal1=strWorkBook.getSheet("Environment").getCell(i1, intR1).getContents();				
							Env.put(arrColHeader1[i1], strVal1);
						}
					//	break;
					}*/
				}
			}
		
		}catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Velu
		if(strModValues != null  && strModValues.length > 0)
		{
			modulePassPercentage = new double[strModValues.length];	
		}
		//Velu
		
		
		return strModValues;
		
	}
	
	public void FnCom_GetEnvParam(String Wb, String strEnv)
	{
		
		try{
			
			{
				Workbook strWorkBook = Workbook.getWorkbook(new File(Wb));
				int intRowCount1=strWorkBook.getSheet("Environment").getRows();
				int intColCount1=strWorkBook.getSheet("Environment").getColumns();
				int intR1=strWorkBook.getSheet("Environment").findCell(strEnv).getRow();
				String[] arrColHeader1=new String[intColCount1];
				System.out.println(arrColHeader1);
				for(int i1=0;i1<intColCount1;i1++)
				{
					arrColHeader1[i1]=strWorkBook.getSheet("Environment").getCell(i1, 0).getContents();	
					//System.out.println(arrColHeader1[i1]);
					String strVal1=strWorkBook.getSheet("Environment").getCell(i1, intR1).getContents();	
					//System.out.println(strVal1);
					Env.put(arrColHeader1[i1], strVal1);
					//System.out.println(Env.get(arrColHeader1[i1].toString()));
					
				}
		}		
			
		}catch(Exception e){			
			System.err.println("Run Manager error :");
			System.err.println("	Function : FnCom_GetParam");
			System.err.println("	Message : "+e.getMessage());
			System.err.println("	Cause : "+e.getCause());
			e.printStackTrace();			
		}	
	}

	
	/*=====================================================================================================
	Function Name:FnGetParam
	Parameters: strWorkBookName 
	Description: This function is used to execute the test scripts with the Execution flag "Y"
	Author: Dhivya Durairaj
	Created Date: Jan 10, 2014
	=====================================================================================================*/
	
	//public String FnCom_GetParam(String strWorkBookName, String strModuleName, String strBrowser,String strEnv)	
	public String FnCom_GetParam(String strWorkBookName, String strModuleName, String strBrowser,String strEnv,String strTestType)	
	{
		try{
			int intFlag=0;
			int intFlagSynthetic=0;
			int intFlagExpanded=0;
			int intScript=0;
			int intManualTC=0;
			int threadCounter=0;
			int maxThreadCount=50;
			int intTestCaseId=0;
			int intTestUser=0;
			int intTestPwd=0;
			int intAppModule=0;
			int intScenario=0;
			int intJiraNo=0;
			int intUserCat=0;
			boolean DailyFlag=false;
			boolean SyntheticFlag=false;
			boolean ExpandedFlag=false;
			Env.put("BROWSER", strBrowser);
			//sf.CreateSummaryHTML(strModuleName,strBrowser);
			Workbook strWorkBook = Workbook.getWorkbook(new File(strWorkBookName));
			intRowCount=strWorkBook.getSheet(strModuleName).getRows();
			intColCount=strWorkBook.getSheet(strModuleName).getColumns();	
			System.out.println(intRowCount+intColCount);
			String[] arrColHeader=new String[intColCount];
			if(strTestType.equals("Daily"))
			{
				DailyFlag=true;
			}
			if(strTestType.equals("Synthetic"))
			{
				SyntheticFlag=true;
			}
			if(strTestType.equals("Expanded"))
			{
				ExpandedFlag=true;
			}
			for(int iLoop=0;iLoop<intColCount;iLoop++)
			{
				String strFlag=strWorkBook.getSheet(strModuleName).getCell(iLoop, 0).getContents();
				
				
				if((strFlag.contains("Script")))
				{
					intScript=iLoop;
				}
				
				if((strFlag.contains("DailyExec")&& DailyFlag==true))
				{
					intFlag=iLoop;			
				}
				
				if((strFlag.contains("SyntheticExec")&& SyntheticFlag==true))
				{
					intFlagSynthetic=iLoop;			
				}
				
				if((strFlag.contains("ExpandedExec")&&ExpandedFlag==true))
				{
					intFlagExpanded=iLoop;			
				}
				if(strFlag.contains("Case"))
				{
					intManualTC=iLoop;	
				}
		
				if(strFlag.contains("Id"))
				{
					intTestCaseId=iLoop;	
				}
				
				if(strFlag.contains("AppUser"))
				{
					intTestUser=iLoop;	
				}
				if(strFlag.contains("Pwd"))
				{
					intTestPwd=iLoop;	
				}
				
				if(strFlag.contains("AppModule"))
				{
					intAppModule=iLoop;	
				}
				
				if(strFlag.contains("Scenario"))
				{
					intScenario=iLoop;	
				}
				
				if(strFlag.contains("JIRATicketNo"))
				{
					intJiraNo=iLoop;	
				}
				
				if(strFlag.contains("UserCategory"))
				{
					intUserCat=iLoop;	
				}
				
				
			}
			
			for(int iLoop=0;iLoop<intRowCount;iLoop++)
			{
				
				String strExecFlag=strWorkBook.getSheet(strModuleName).getCell(intFlag, iLoop).getContents();
				if(ExpandedFlag==true)
				{
					strExecFlag=strWorkBook.getSheet(strModuleName).getCell(intFlagExpanded, iLoop).getContents();
				}
				if(DailyFlag==true)
				{
					strExecFlag=strWorkBook.getSheet(strModuleName).getCell(intFlag, iLoop).getContents();
				}
				if(SyntheticFlag==true)
				{
					strExecFlag=strWorkBook.getSheet(strModuleName).getCell(intFlagSynthetic, iLoop).getContents();
				}
				if(strExecFlag.equalsIgnoreCase("Y") )
				{
					
					threadCounter++;
				
				}
				
			}
			System.out.println("No. of threads to be run"+threadCounter);
			
			
			
			for(int iLoop=0;iLoop<intRowCount;iLoop++)
			{	
				boolean userChnged = false;
				
				String strExecFlag=strWorkBook.getSheet(strModuleName).getCell(intFlag, iLoop).getContents();
				if(ExpandedFlag==true)
				{
					strExecFlag=strWorkBook.getSheet(strModuleName).getCell(intFlagExpanded, iLoop).getContents();
				}
				if(DailyFlag==true)
				{
					strExecFlag=strWorkBook.getSheet(strModuleName).getCell(intFlag, iLoop).getContents();
				}
				if(SyntheticFlag==true)
				{
					strExecFlag=strWorkBook.getSheet(strModuleName).getCell(intFlagSynthetic, iLoop).getContents();
				}
				if(strExecFlag.equalsIgnoreCase("Y")) //removed code (iloop==1)
				{
					
					//Testcase 1 is considered to be the mandatory testcase
					boolean blockTC = false;
					strCaseName=strWorkBook.getSheet(strModuleName).getCell(intScript, iLoop).getContents();
					String strManualTC=strWorkBook.getSheet(strModuleName).getCell(intManualTC, iLoop).getContents();
					
					String strTestCaseId=strWorkBook.getSheet(strModuleName).getCell(intTestCaseId, iLoop).getContents();
					
					String strTestCaseUser=strWorkBook.getSheet(strModuleName).getCell(intTestUser, iLoop).getContents();
					String strTestCasePwd=strWorkBook.getSheet(strModuleName).getCell(intTestPwd, iLoop).getContents();
					String strTestProperty="\"{'"+strTestCaseUser+"','"+strTestCasePwd+"'}\"";
					String appmodule=strWorkBook.getSheet(strModuleName).getCell(intAppModule, iLoop).getContents();
					String strScenario=strWorkBook.getSheet(strModuleName).getCell(intScenario, iLoop).getContents();
					String strJiraNo=strWorkBook.getSheet(strModuleName).getCell(intJiraNo, iLoop).getContents();
					String strUsrCat=strWorkBook.getSheet(strModuleName).getCell(intUserCat, iLoop).getContents();
					int intR=strWorkBook.getSheet(strModuleName).findCell(strManualTC).getRow();
					int intC=strWorkBook.getSheet(strModuleName).findCell(strManualTC).getColumn();
					sf.setAppUser(strTestCaseUser);
					
					
					
					for(int i=0;i<intColCount;i++)
					{
						String strVal=strWorkBook.getSheet(strModuleName).getCell(i, 0).getContents();				
						arrColHeader[i]=strVal;	
						System.out.println("str"+strVal);
					}
					
					
				
					for(int j=0;j<intColCount;j++)	
					{
						String strVal=strWorkBook.getSheet(strModuleName).getCell(j, intR).getContents();
						String header=arrColHeader[j];
						System.out.println("head"+header );
						
					
						if(strVal.equalsIgnoreCase("#env"))
						{
							strVal=Env.get(header).toString();		
							
							System.out.println(strVal);
						}else{
							Env.put(header, strVal);
							System.out.println(strVal+Env);
						}
						
						testdata.put(arrColHeader[j],strVal);				
					}
					
					
					RunManagerInfo runManagerInfo=new RunManagerInfo(strModuleName,
							strManualTC, strCaseName,strBrowser,
							strTestCaseId, strTestProperty,
							appmodule,strJiraNo,strScenario,
							strUsrCat,strTestCaseUser,
							strTestCasePwd);
					runManagerInfoList.add(runManagerInfo);
					
				}
				 
				 
			}
			
		}catch (BiffException e) {

			System.err.println("Run Manager error :");
			System.err.println("	Function : FnCom_GetParam");
			System.err.println("	Message : "+e.getMessage());
			System.err.println("	Cause : "+e.getCause());
			
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
		
			System.err.println("Run Manager error :");
			System.err.println("	Function : FnCom_GetParam");
			System.err.println("	Message : "+e.getMessage());
			System.err.println("	Cause : "+e.getCause());
			e.printStackTrace();
			
		}
		catch(Exception ex){
			System.err.println("Exception occured :");
			System.err.println("	Function : FnCom_GetParam");
			System.err.println("	Message : "+ex.getMessage());
			System.err.println("	Cause : "+ex.getCause());
			ex.printStackTrace();
		}
//		sf.FnSummaryHTMLWrapper();		
		return strCaseName;		
	}
	
	 public void executeTask(int modLength,List<String> mod){
		 Iterator<RunManagerInfo> iter = runManagerInfoList.iterator();
		 ExecutorService executor = Executors.newFixedThreadPool(MAX_Permissible_Thread);
		 ReportingFunctions repFunObj = new ReportingFunctions();
		 RunManagerInfo runMangeInfo = null;
		 while(iter.hasNext()){
			 	runMangeInfo = iter.next();	
				Runnable testObbbj = new ThreadExecuter(runMangeInfo);
				executor.execute(testObbbj);
		
		 }
		 executor.shutdown();
			try {
				executor.awaitTermination(1000, TimeUnit.SECONDS);
				} catch (InterruptedException e) {
				  System.out.println("Thread terminates due to " +  e.getMessage());
				}
			 Iterator<RunManagerInfo> iter1 = runManagerInfoList.iterator();
			 System.out.println("THREADS END-------------------------/n----------");
			 while(iter1.hasNext()){
				 runMangeInfo = iter1.next();
				 repFunObj.FnUpdateEndTest(runMangeInfo);
				
			 }
			 for(int i=0;i<modLength;i++){
				
				 String module=mod.get(i);
			 sf.FnSummaryHTMLWrapper(module);	
			 }
	 }

	/*=====================================================================================================
	Function Name: logoutOnUserChange
	Parameters: strModuleName, strTestcaseName
	Description: Performs logout when there is a change in username
	Author: Shanmuga Priya Ganesan
	Created Date: Feb 26, 2015
	=====================================================================================================*/
//	public boolean logoutOnUserChange(String strModuleName, String strTestcaseName){
//		String Environment = m1.get("Env").toString();
//		System.out.println(Environment);
//		boolean isLogoutSuccess = false;
//		CharterAppFunctions app=new CharterAppFunctions();
//	//	sf.updateOverallStatusInMap("PASS", strTestcaseName);
//		//sf.CreateOutputXLS(strModuleName,strTestcaseName);
//		if(Environment.contains("WG")){
//			isLogoutSuccess=app.FnlogoutGeneric_DevWG();
//		}
//		else{
//			if(strModuleName.contains("Login"))
//			{
//				isLogoutSuccess=true;
//			}
//			else
//			{
//				isLogoutSuccess=app.FnlogoutGeneric();
//			}
//		}
//
//	//	sf.FnUpdateEndTest();
//		return isLogoutSuccess;
//	}
	/*=====================================================================================================
	Function Name: logoutOnUserChange
	Parameters: strModuleName, strTestcaseName
	Description: Performs logout when there is a change in username
	Author: Shanmuga Priya Ganesan
	Created Date: Feb 26, 2015
	=====================================================================================================*/
	public synchronized boolean LaunchCharterApp(RunManagerInfo runManagerInfoObj,WebDriver driver){
		boolean isLoginSuccess = false;
		
		CharterAppFunctions app=new CharterAppFunctions();
		//sf.updateOverallStatusInMap("PASS", strTestcaseName);
		//sf.CreateOutputXLS(strModuleName,strTestcaseName);
		isLoginSuccess=app.FnLaunchCharterApp(driver,runManagerInfoObj);  
		//sf.FnUpdateEndTest();
		return isLoginSuccess;
	}
	
	/*=====================================================================================================
	Function Name: Fn_ExecuteTC
	Parameters: strCaseName, Map object 
	Description: This function is used to execute the Method. The test case name is the method name and 
	all the data table value are passed as Map object
	Author: Dhivya Durairaj
	Created Date: Jan 10, 2014
=====================================================================================================*/
	//public void FnCom_ExecuteTC(String strModuleName, String strManualTC,String strCaseName,String strBrowser)
	@SuppressWarnings({"unchecked", "rawtypes", "unused"})
	public synchronized void FnCom_ExecuteTC(RunManagerInfo runManagerInfoObj)
	{
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
    	String TestStartTime=sdf1.format(cal.getTime());
		String TeststrtTimeKey="TestStartTime"+runManagerInfoObj.getStrTestCaseId();
		m1.put(TeststrtTimeKey,TestStartTime);
		
		
		Class noparams[] = {};
		try{
			sf.FnAssignEnvValues(strBrowser,Env,runManagerInfoObj);
			WebDriver driver=sf.FnInitializeBrowser(runManagerInfoObj);
			CharterAppFunctions app=new CharterAppFunctions();
			String ClassName="com.charter.sb.testscripts."+runManagerInfoObj.getAppmodule();
			Class cls = Class.forName(ClassName);
			Object obj = cls.newInstance();			
			RunManager runManggerObj = new RunManager();
			sf.CreateOutputXLS(runManagerInfoObj);
			boolean blnFlag=runManggerObj.LaunchCharterApp(runManagerInfoObj,driver);
			if(blnFlag){	
			Class[] argTypes = { WebDriver.class,RunManagerInfo.class };	
			Method method = cls.getMethod(runManagerInfoObj.getStrCaseName(),argTypes);
			method.invoke(obj,driver,runManagerInfoObj);
			System.out.println("Method name:"+method);
			}   
			else{
				
				ReportingFunctions repfn = new ReportingFunctions();
				repfn.FnCom_AbortExec(driver,runManagerInfoObj);
			}
			
		}catch(Exception e){			
			System.err.println("Run Manager error :");
			System.err.println("	Function : FnCom_GetParam");
			System.err.println("	Message : "+e.getMessage());
			System.err.println("	Cause : "+e.getCause());
			e.printStackTrace();			
		}
		
        		
	}

	
/*=====================================================================================================
	Function Name: FnGenerateXLSummary
	Parameters: strPath -  path to store the excel summary file
	Description: This function is used to create a summary excel sheet
	Author: Dhivya Durairaj
	Created Date: Mar 11, 2014
=====================================================================================================*/
	public String FnGenerateXLSummary(String strPath)
	{	
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf1= new SimpleDateFormat("ddMMyyyy_HH_mm_ss");
	    String strTime=sdf1.format(cal.getTime());
		
    	SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy_HH_mm_ss");
    	String strTime1=sdf.format(cal.getTime());
		//IF RESULTS PATH IS NOT FOUND. CREATE IT FIRST
    	
		//String fp=m1.get("RESULTS_PATH").toString()+"\\ExecSummary";
    	String fp;
		String strFileName1;
		String p=sf.getPlat();
		
		if(p.equalsIgnoreCase("MAC"))
		{
		fp=strPath+"//ExecSummary//";	
		strFileName1=fp+"//BatchExecSummary"+".xls";
		}
		else{
				fp=strPath+"\\ExecSummary\\";	
				strFileName1=fp+"\\BatchExecSummary"+".xls";
				
			}
		

		File f=new File(fp);
		f.mkdirs();
		if(f.exists())
		{
			 //  m1.put("SUMMARY", fp);				   
		}else{
			System.out.println("not exists");
		}
		

		//String strFileName1=fp+"\\BatchExecSummary"+"_"+strTime+".xls";
			//FileOutputStream fo1 = new FileOutputStream(strFileName1);
		try{
			File file = new File(strFileName1);
			WritableWorkbook workbook = Workbook.createWorkbook(file);
		    workbook.createSheet("Summary", 0);
		    //workbook.getSheet("Summary").addCell(new Label(0, 0, "testtype"));
		    workbook.getSheet("Summary").addCell(new Label(0, 0, "applicationname"));
		    workbook.getSheet("Summary").addCell(new Label(1, 0, "applicationversion"));
		    workbook.getSheet("Summary").addCell(new Label(2, 0, "modulename"));
		    workbook.getSheet("Summary").addCell(new Label(3, 0, "testcaseid"));
		    workbook.getSheet("Summary").addCell(new Label(4, 0, "testcasename"));
		    workbook.getSheet("Summary").addCell(new Label(5, 0, "testscenario"));
		    workbook.getSheet("Summary").addCell(new Label(6, 0, "testenvironment "));
		    //workbook.getSheet("Summary").addCell(new Label(8, 0, "testperformtype"));
		    workbook.getSheet("Summary").addCell(new Label(7, 0, "testproperties"));
		    //workbook.getSheet("Summary").addCell(new Label(10, 0, "usercategory"));
		     
		   
		    //workbook.getSheet("Summary").addCell(new Label(11, 0, "reason"));
		    workbook.getSheet("Summary").addCell(new Label(8, 0, "status"));
		    
		    //workbook.getSheet("Summary").addCell(new Label(13, 0, "jiraticketno"));
		    //workbook.getSheet("Summary").addCell(new Label(14, 0, "rowid"));
		    workbook.getSheet("Summary").addCell(new Label(9, 0, "testperformedonat"));
		    /*if(status_Date.equals("true"))
		    {
		    	workbook.getSheet("Summary").addCell(new Label(15, 0, "Prod Status \n MST"));
		    }*/
		    
		    
		    workbook.write();
		    workbook.close();
		    
		    //m1.put("SummaryXL",strFileName1);
		}catch(Exception e){			
			System.err.println("Run Manager error :");
			System.err.println("	Function : FnCom_GetParam");
			System.err.println("	Message : "+e.getMessage());
			System.err.println("	Cause : "+e.getCause());
			e.printStackTrace();			
		}	
		return strFileName1;
	}
	public String FnGenerateJSONSummary(String strPath)
	{	
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf1= new SimpleDateFormat("ddMMyyyy_HH_mm_ss");
	    String strTime=sdf1.format(cal.getTime());
		
    	SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy_HH_mm_ss");
    	String strTime1=sdf.format(cal.getTime());
    	    	
		//IF RESULTS PATH IS NOT FOUND. CREATE IT FIRST
    	
		//String fp=m1.get("RESULTS_PATH").toString()+"\\ExecSummary";
		String fp=strPath+"\\ExecSummary";
		File f=new File(fp);
		f.mkdirs();
		if(f.exists())
		{
			 //  m1.put("SUMMARY", fp);				   
		}else{
			System.out.println("not exists");
		}
		

		String strFileName1=fp+"\\JSONExecSummary"+"_"+strTime+".txt";
			//FileOutputStream fo1 = new FileOutputStream(strFileName1);
		
try{
			FileOutputStream fo = new FileOutputStream(strFileName1);
			OutputStreamWriter objResFile = new OutputStreamWriter(new FileOutputStream(strFileName1));
			
			/*objResFile.write("{");
			objResFile.write("\"Report\":");
			objResFile.write("{");
			objResFile.write("\"TEST_case\":");
			objResFile.write("[");
			
			objResFile.write("]");
			objResFile.write("}");
			objResFile.write("}");*/
			
				    

		    objResFile.close();
			
			
		    }catch(Exception e){			
			System.err.println("Run Manager error :");
			System.err.println("	Function : FnCom_GetParam");
			System.err.println("	Message : "+e.getMessage());
			System.err.println("	Cause : "+e.getCause());
			e.printStackTrace();			
		}	
		return strFileName1;
	}
	

/*=====================================================================================================
	Function Name: FnUpdateTestQCResults
	Parameters: String strWorkBookName,ITDConnection con,String testFolderPath,String strTestSet
	Description: This function is used to update results to qc test set
	Author: Dhivya Durairaj
	Created Date: Mar 11, 2014
=====================================================================================================*/
	
/*	public void FnUpdateTestQCResults(String strWorkBookName,ITDConnection con,String testFolderPath,String strTestSet) throws Exception, IOException
	{	
		Workbook strWorkBook = Workbook.getWorkbook(new File(strWorkBookName));
		intRowCount=strWorkBook.getSheet("Summary").getRows();
		intColCount=strWorkBook.getSheet("Summary").getColumns();
		String[] arrColHeader=new String[intColCount];
		
		for(int i1=0;i1<intColCount;i1++)
		{
			arrColHeader[i1]=strWorkBook.getSheet("Summary").getCell(i1, 0).getContents();	
		}
		
		for(int iLoop=1;iLoop<intRowCount;iLoop++)
		{	
			for(int i=0;i<intColCount;i++)
			{
				String strVal=strWorkBook.getSheet("Summary").getCell(i, iLoop).getContents();
				if(arrColHeader[i].equalsIgnoreCase("ManualTestCaseName"))
					ManualTestCaseName=strVal;
				else if(arrColHeader[i].equalsIgnoreCase("TestScriptName"))				
					TestScriptName=strVal;
				else if(arrColHeader[i].equalsIgnoreCase("Execution Status"))
				{
					if(strVal.equalsIgnoreCase("PASS"))
					{
						strVal="Passed";
					}else{
						strVal="Failed";
					}					
					strStatus=strVal;					
				}
				else if(arrColHeader[i].equalsIgnoreCase("Folder Location"))				
					strResFolder=strVal;
				else if(arrColHeader[i].equalsIgnoreCase("Results File Name"))				
					strResFile=strVal;
				else if(arrColHeader[i].equalsIgnoreCase("Execution Time"))				
					strExecTime=strVal;
				
				
				
			}
			
			qcfn.FnUpdateTestResult(con, testFolderPath,strTestSet,strResFile,strResFolder,ManualTestCaseName,strStatus,strExecTime);
			
		}	
		
		
		
	}*/
	
	private static String newDate(int delay) {
		Date date = Calendar.getInstance().getTime();
		date.setSeconds(date.getSeconds()+delay);
		return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(date);
		
	}
}