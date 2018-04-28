package com.charter.sb.controllers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.iphone.IPhoneDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Platform;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.charter.sb.beans.ReportingInfo;
import com.charter.sb.beans.RunManagerInfo;
import com.charter.sb.beans.TestStepDetails;
import com.thoughtworks.selenium.Selenium;


public class Initialization {
	
	public static HashMap<String, Integer> threadCount = new HashMap<String, Integer>();
	//public static Map<String, Map<String,TestStepDetails>> TestDetails = new HashMap<String, Map<String,TestStepDetails>>();//This is one instance of the   map you want to store in the above map
	 public static Hashtable<String, TestStepDetails> TestDetailsMap=new Hashtable();
	 public static Map<Integer,String> moduledetails=new HashMap<Integer,String>();
	 public static List<RunManagerInfo> runManagerInfoList = new ArrayList<RunManagerInfo>();
	public static ReportingInfo ReportingInfoObj=new ReportingInfo();
	String[] strConfigValues = new String[35];
	public String strPresentDir;
	public static Map m1= new HashMap<String, String>();
	public static Selenium selenium;
	
	public  WebDriver driver;
	public static String strBrowser;
	public static String strEnv;
	public static String strPath;
	public static String strBaseURL;
	public static Actions actions;	
	public static int StepCounter;
	public static StringBuffer verificationErrors = new StringBuffer();	
	public int iIndex;
	public int count;
	public String[][] arr=new String[100][100];

	/**
	* Method Name : getRelativePath
	* Method Description : This method is used get the relative path
	* @param None
	* @return path
	* @author Dhivya Durairaj
	* @throws none
	*/
	
	public static String getRelativePath()
	{
		String relativePath = new File(System.getProperty("user.dir")).getAbsolutePath();
		return relativePath;
	}
	
	/**
	* Method Name : getConfigValues
	* Method Description : This method is used get the values from Config.properties file
	* @param Map -- all the config values are mapped to a hash map
	* @return none
	* @author Dhivya Durairaj
	* @throws none
	*/
	@SuppressWarnings({"unchecked", "unused"})
	@BeforeSuite
	public void getConfigValues(){
		try{
			//To read the file paths from property file
			this.readProperty();
			
			//Changing format of paths
			//Getting present directory - actual path
			strPresentDir = getRelativePath();
			String[] path=strPresentDir.split("Workspace");
			System.out.println("first val: "+ path[0]);
			String p=path[0]+"ExecReports";	
			String strClassName = getClass().getGenericSuperclass().toString();
			int iIndexDot=strClassName.lastIndexOf(".");
			String strTestSuiteName=strClassName.substring(iIndexDot+1);			
			//Formatting path of Library
			strConfigValues[1]=strConfigValues[0].replaceFirst("../", "");
			strConfigValues[1]=strConfigValues[0].replaceAll("/", ".");			
			m1.put("EXECUTION_ENGINE", strConfigValues[0]);			
			m1.put("LIBRARY_PATH", strConfigValues[1]);
			//Formatting path Test Scripts
			if(strConfigValues[2].startsWith("../", 0)){
				strConfigValues[2]=strConfigValues[2].replaceFirst("..", "");		
				strConfigValues[2]= strPresentDir+strConfigValues[2].toString();
			}		
			m1.put("TESTSCRIPTS_PATH", strConfigValues[2]);
			//Formatting path Datasheets	
			if(strConfigValues[3].startsWith("../", 0)){
				strConfigValues[3]=strConfigValues[3].replaceFirst("..", "");
				strConfigValues[3]= strPresentDir+strConfigValues[3].toString();
			}
			//Formatting path Results Path
			m1.put("DATASHEET_PATH", strConfigValues[3]);
			
//			if(strConfigValues[4].startsWith("../", 0)){
//				strConfigValues[4]=strConfigValues[4].replaceFirst("..", "");
//				strConfigValues[4]= strPresentDir+strConfigValues[4].toString();
//			}			
			m1.put("RESULTS_PATH", p);
			//Formatting path Tools Path
			
			if(strConfigValues[4].startsWith("../", 0)){
				strConfigValues[4]=strConfigValues[4].replaceFirst("..", "");
				strConfigValues[4]= strPresentDir+strConfigValues[4].toString();
			}			
			m1.put("TOOLS_PATH", strConfigValues[4]);
			//m1.put("BROWSER", strConfigValues[5]);
			m1.put("OS_NAME", strConfigValues[6]);
			m1.put("RUNMGR",strConfigValues[7]);
			m1.put("TS_STATUS","null");
			m1.put("ONERR_TS_STOP",strConfigValues[8]);
			m1.put("ONERR_Mod_STOP",strConfigValues[9]);
			m1.put("ONERR_Exe_STOP",strConfigValues[10]);
			m1.put("QCExecFlag",strConfigValues[11]);
			m1.put("STEPSTATUS", "");
			m1.put("TestSetFolder",strConfigValues[12]);
			m1.put("TestSet",strConfigValues[13]);
			
			m1.put("FIREFOX_PATH",strConfigValues[14]);
			
			m1.put("ApplicationName", strConfigValues[15]);
			m1.put("ProductVersion", strConfigValues[16]);
			m1.put("TestType", strConfigValues[17]);
			//m1.put("VERSION", strConfigValues[18]);
			m1.put("StatusWithDate", strConfigValues[19]);
			m1.put("PerformType", strConfigValues[20]);
			
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Initialization file error :");
			System.err.println("	Function : getfilePath");
			System.err.println("	Message : "+e.getMessage());
			System.err.println("	Cause : "+e.getCause());
		}
	}
	
	
	/**
	* Method Name : getConfigValues
	* Method Description : This method is used read the values from Config.properties file
	* @param None
	* @return path
	* @author Dhivya Durairaj
	* @throws FileNotFoundException,IOException
	*/
	private void readProperty() throws FileNotFoundException,IOException{
		
		//Variables to hold the property values
		
		Properties pConfigFile = new Properties();
		try {			
			Initialization.getCurrentPlatform();
			//Load the property file
			strPresentDir = getRelativePath();		
			
			String p=m1.get("PLATFORM").toString();
			String val;
			
			//String p=m1.get("PLATFORM").toString();
			if(
					p.equalsIgnoreCase("MAC"))
			{
				val="/src/Library/Config.properties";
			}else{
				val="\\src\\com\\charter\\sb\\config\\Config.properties";
			}
			
			String strConfig=strPresentDir+val;
			System.out.println(strConfig);
			FileReader configFile = new FileReader(strConfig);
			
		//	InputStream configFile = this.getClass().getClassLoader().getResourceAsStream("Library/Config.properties");			
			pConfigFile.load(configFile);
			System.out.println("after load");
			
			//To read the properties
			//Choose the execution engine
			strConfigValues[0] = pConfigFile.getProperty("EXECUTION_ENGINE");
			
			//File paths
			strConfigValues[1] = pConfigFile.getProperty("LIBRARY_PATH");	
			strConfigValues[2] = pConfigFile.getProperty("TESTSCRIPTS_PATH");
			strConfigValues[3] = pConfigFile.getProperty("DATASHEET_PATH");		
		//	strConfigValues[4] = pConfigFile.getProperty("RESULTS_PATH");		
			strConfigValues[4] = pConfigFile.getProperty("TOOLS_PATH");
		  //  strConfigValues[5] = pConfigFile.getProperty("BROWSER");
			strConfigValues[6] = pConfigFile.getProperty("OS_NAME");
			
			strConfigValues[7] = pConfigFile.getProperty("RUNMGR");
			
			strConfigValues[8] = pConfigFile.getProperty("ONERR_TS_STOP");
			strConfigValues[9] = pConfigFile.getProperty("ONERR_Mod_STOP");
			strConfigValues[10] = pConfigFile.getProperty("ONERR_Exe_STOP");
			strConfigValues[11] = pConfigFile.getProperty("QCExecFlag");
			strConfigValues[12] = pConfigFile.getProperty("TestSetFolder");	
			strConfigValues[13] = pConfigFile.getProperty("TestSet");	
			strConfigValues[14] = pConfigFile.getProperty("FIREFOX_PATH");	
			strConfigValues[15] = pConfigFile.getProperty("Application");
			strConfigValues[16] = pConfigFile.getProperty("ProductVersion");
			strConfigValues[17] = pConfigFile.getProperty("TestType");
			//strConfigValues[18] = pConfigFile.getProperty("VERSION");
			strConfigValues[19] = pConfigFile.getProperty("StatusWithDate");
			strConfigValues[20] = pConfigFile.getProperty("PerformType");
			
		} 
		catch (FileNotFoundException fe) {
			
			System.err.println("Initialization file error :");
			System.err.println("	Function : readProperty");
			System.err.println("	Message : "+fe.getMessage());
			System.err.println("	Cause : "+fe.getCause());
		} 
		catch (IOException ioe) {
			
			System.err.println("Initialization file error :");
			System.err.println("	Function : readProperty");
			System.err.println("	Message : "+ioe.getMessage());
			System.err.println("	Cause : "+ioe.getCause());
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Initialization file error :");
			System.err.println("	Function : readProperty");
			System.err.println("	Message : "+e.getMessage());
			System.err.println("	Cause : "+e.getCause());
		}
	}
	
	public static void getCurrentPlatform()
	{
		Platform p=Platform.getCurrent();		
		String pf=p.name().toString();
		m1.put("PLATFORM", pf);
	}
		
	

	

	/**
	* Method Name : tearDown
	* Method Description : This method is quit the driver after test
	* @param  None
	* @return none
	* @author Dhivya Durairaj
	* @throws Exception
	*/	
	@AfterSuite
	public void tearDown() throws Exception {
		try{
		//selenium.stop();
			driver.quit();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());			
		}
	}


	/**
	* Method Name : getPlatform
	* Method Description : This method is used to get the platform
	* @param  platform name
	* @return platform reference
	* @author Dhivya Durairaj
	* @throws Exception
	*/
	
	public static Platform getPlatform(String platformName)
	{
		Platform  platform = null;		
		if(platformName.equalsIgnoreCase("windows"))
			platform = Platform.WINDOWS;
		if(platformName.equalsIgnoreCase("android"))
			platform = Platform.ANDROID;
		if(platformName.equalsIgnoreCase("any"))
			platform = Platform.ANY;
		if(platformName.equalsIgnoreCase("xp"))
			platform = Platform.XP;
		if(platformName.equalsIgnoreCase("vista"))
			platform = Platform.VISTA;
		if(platformName.equalsIgnoreCase("unix"))
			platform = Platform.UNIX;
		if(platformName.equalsIgnoreCase("mac"))
			platform = Platform.MAC;
		if(platformName.equalsIgnoreCase("linux"))
			platform = Platform.LINUX;
		return platform;
	}	
	

	
}
