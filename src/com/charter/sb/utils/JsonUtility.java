package com.charter.sb.utils;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import com.charter.sb.beans.RunManagerInfo;
import com.charter.sb.beans.TestStepDetails;
import com.charter.sb.controllers.Initialization;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class JsonUtility  extends Initialization{
	public String testKey ;
	public static HashMap<String,Integer> counterMap=new HashMap<String, Integer>();
	public static HashMap<String,Integer> PassedCounterMap=new HashMap<String, Integer>();
	public static HashMap<String,Integer> FailedCounterMap=new HashMap<String, Integer>();
	public static HashMap<String,Integer> abortCounterMap=new HashMap<String, Integer>();
	public static HashMap<String,Integer> warningCounterMap=new HashMap<String, Integer>();
	public static int count = 0;
	public static int passedCounter=0;
	public static int failedCounter=0;
	public static int abortCounter=0;
	public static int passedWarningCounter=0;
	public static Date startTime=new Date();
	String modulestartTime;
	
	FileWriter file = null;
	@SuppressWarnings({"unchecked", "unused"})
	public void generateJsonReports() {
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
    	String ExecutionStartTime=sdf1.format(cal.getTime());
		m1.put("ExecutionStartTime", ExecutionStartTime);
		JsonObject automationTestSummary = new JsonObject();
	
		try{
			char[] c= new char[34];		
			
			
			//IF RESULTS PATH IS NOT FOUND. CREATE IT FIRST
	    	String fp,strFileName;			
			String p=m1.get("PLATFORM").toString();
			if(p.equalsIgnoreCase("MAC"))
			{
				fp=m1.get("RESULTS_PATH").toString()+"//ExecSummary";
				strFileName=fp+"//"+"BatchExecutionSummary.json";		
			}else{
				fp=m1.get("RESULTS_PATH").toString()+"\\ExecSummary";
				strFileName=fp+"\\"+"BatchExecutionSummary.json";	
			}
			
				String FileKey="ExecutionSummary.json";
				m1.put(FileKey, strFileName);
				CreateJsonObjects(strFileName);			
		}catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("	Message : "+e.getMessage());
			System.err.println("	Cause : "+e.getCause());
		}

	}
	
	
	
	@SuppressWarnings("unused")
	public  void CreateJsonObjects(String  strFileName) {
		JsonObject automationTestSummary = new JsonObject();
		JsonObject testSummary = new JsonObject();
		JsonArray reportResultArray = new JsonArray();
		JsonObject spectrumBusinessSummaryObj = new JsonObject();
		
		automationTestSummary.add("Module Execution Summary", reportResultArray);
		spectrumBusinessSummaryObj.add("Spectrum Business Automation Execution Report", automationTestSummary);
	
		try {

			 file = new FileWriter(strFileName);
			file.write(spectrumBusinessSummaryObj.toString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({"unchecked", "unused"})
	public synchronized void updateJsonReports(RunManagerInfo runManagerInfoObj,String strResultStatus){
		
		
		String ModuleStartTimeKey="ModuleStartTime"+runManagerInfoObj.getAppmodule();
		String moduleEndKey="moduleEndTime"+runManagerInfoObj.getAppmodule();
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
		Date modendTime;
		Date modstartTime;
		String modDiffTimeKey="modDiffTime"+runManagerInfoObj.getAppmodule();
		try {
			modendTime = sdf.parse(m1.get(moduleEndKey).toString());
			modstartTime=sdf.parse(m1.get(ModuleStartTimeKey).toString());
			long diff = modendTime.getTime() - modstartTime.getTime();			
			double ModuleExecdiffInMins = Math.round(diff / ((double) 1000 * 60));	
			
			m1.put(modDiffTimeKey, ModuleExecdiffInMins);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Calendar cal = Calendar.getInstance();
		
    	String ExecutionEndTime=sdf.format(cal.getTime());
		m1.put("ExecutionEndTime", ExecutionEndTime);
		JsonParser parser = new JsonParser();
		count++;
        try {     
    		int modCount = 0;
			String fileKey="ExecutionSummary.json";
			boolean isExist = false;
			String strJsonFileName=m1.get(fileKey).toString();
			Object obj = parser.parse(new FileReader(strJsonFileName));
            JsonObject jsonObject =  (JsonObject) obj;
            JsonObject moduleInfo= null;
            JsonArray jsoarry = null;
            boolean  notExist =true;
            JsonObject testScriptObj = null;
            JsonArray testSummaryArray= null;
            JsonObject jsonObjectSpectrum = jsonObject.getAsJsonObject("Spectrum Business Automation Execution Report");
            jsonObjectSpectrum.addProperty("Enviornment URL", runManagerInfoObj.getAppUrl());
            JsonArray jsonObjectModule = jsonObjectSpectrum.getAsJsonArray("Module Execution Summary");
            if(jsonObjectModule.size()!= 0)
            	{
            	for(int i =0;i<=jsonObjectModule.size()-1;i++){
            	JsonObject jsonModObj = (JsonObject) jsonObjectModule.get(i);	
            	String moduleInfoStr = jsonModObj.get("Module Name").toString();
            	if(moduleInfoStr.contains(runManagerInfoObj.getAppmodule())){
            	jsoarry = jsonObjectModule.getAsJsonArray();
            	moduleInfo = jsonModObj.getAsJsonObject();
            	jsoarry.remove(jsonModObj);
            	int cnt = counterMap.get(runManagerInfoObj.getAppmodule());
            	cnt++;
            	counterMap.put(runManagerInfoObj.getAppmodule(), cnt);
            	testSummaryArray = (JsonArray) moduleInfo.get("Test Script Excecution Summary");
            	isExist = true;
            	  if(strResultStatus=="PASS")
      			{
      				passedCounter++;
      				int cnt1 = PassedCounterMap.get(runManagerInfoObj.getAppmodule());
      				cnt1++;
      				PassedCounterMap.put(runManagerInfoObj.getAppmodule(), cnt1);
      			}
      			else if(strResultStatus=="FAIL"){
      				failedCounter++;
      				int cnt1  = FailedCounterMap.get(runManagerInfoObj.getAppmodule());;
      				cnt1++;
      				FailedCounterMap.put(runManagerInfoObj.getAppmodule(),cnt1);
      				
      			}
      			else if(strResultStatus=="ABORT")
      			{
      				abortCounter++;
      				int cnt1 =abortCounterMap.get(runManagerInfoObj.getAppmodule());
      				cnt1++;
      				abortCounterMap.put(runManagerInfoObj.getAppmodule(),cnt1);
      			}
      			else {
      				passedWarningCounter++;
      				int cnt1 =warningCounterMap.get(runManagerInfoObj.getAppmodule());
      				cnt1++;
      				warningCounterMap.put(runManagerInfoObj.getAppmodule(),cnt1);
      			}
            	notExist = false;
            	break;
            }
            	}
           if(notExist)
            {
            	moduleInfo = new JsonObject();
            	jsoarry = jsonObjectModule.getAsJsonArray();
                moduleInfo.addProperty("Module Name",runManagerInfoObj.getAppmodule());
                moduleInfo.addProperty("Browser Executed", runManagerInfoObj.getStrBrowser());
                moduleInfo.addProperty("Module execution Start Time",m1.get(ModuleStartTimeKey).toString() );
                int cnt = 0;
                cnt++;
                 counterMap.put(runManagerInfoObj.getAppmodule(), cnt);
                moduleInfo.addProperty("Date", new Date().toString());
                testSummaryArray = new JsonArray();
                if(strResultStatus=="PASS")
      			{
      				int cnt1 =1;
      				PassedCounterMap.put(runManagerInfoObj.getAppmodule(), cnt1);
      				FailedCounterMap.put(runManagerInfoObj.getAppmodule(),0);
      				abortCounterMap.put(runManagerInfoObj.getAppmodule(),0);
      				warningCounterMap.put(runManagerInfoObj.getAppmodule(),0);
            }
      			
      			else if(strResultStatus=="FAIL"){
      				int cnt1  = 1;
      				FailedCounterMap.put(runManagerInfoObj.getAppmodule(),cnt1);
      				PassedCounterMap.put(runManagerInfoObj.getAppmodule(), 0);
      				abortCounterMap.put(runManagerInfoObj.getAppmodule(),0);
      				warningCounterMap.put(runManagerInfoObj.getAppmodule(),0);
      			}
      			else if(strResultStatus=="ABORT")
      			{
      				int cnt1  = 1;
      				abortCounterMap.put(runManagerInfoObj.getAppmodule(),cnt1);
      				FailedCounterMap.put(runManagerInfoObj.getAppmodule(),0);
      				PassedCounterMap.put(runManagerInfoObj.getAppmodule(), 0);
      				warningCounterMap.put(runManagerInfoObj.getAppmodule(),0);
      			}
      			else {
      				int cnt1  = 1;
      				warningCounterMap.put(runManagerInfoObj.getAppmodule(),cnt1);
      				FailedCounterMap.put(runManagerInfoObj.getAppmodule(),0);
      				PassedCounterMap.put(runManagerInfoObj.getAppmodule(), 0);
      				abortCounterMap.put(runManagerInfoObj.getAppmodule(),0);
      			}
            }
            	}
            else{
           moduleInfo= new JsonObject();
           jsoarry = new JsonArray();
           moduleInfo.addProperty("Module Name",runManagerInfoObj.getAppmodule());
           moduleInfo.addProperty("Browser Executed", runManagerInfoObj.getStrBrowser());
           moduleInfo.addProperty("Module execution Start Time",m1.get(ModuleStartTimeKey).toString() );
           moduleInfo.addProperty("Date", new Date().toString());
           int cnt = 0;
           PassedCounterMap.put(runManagerInfoObj.getAppmodule(), cnt);
           FailedCounterMap.put(runManagerInfoObj.getAppmodule(), cnt);
           warningCounterMap.put(runManagerInfoObj.getAppmodule(), cnt);
           abortCounterMap.put(runManagerInfoObj.getAppmodule(), cnt);
           cnt++;
           if(strResultStatus=="PASS")
			{
				passedCounter++;
				int cnt1 = 0;
				cnt1++;
				PassedCounterMap.put(runManagerInfoObj.getAppmodule(), cnt1);
			}
			else if(strResultStatus=="FAIL"){
				failedCounter++;
				int cnt1 = 0;
				cnt1++;
				FailedCounterMap.put(runManagerInfoObj.getAppmodule(),cnt1);
			}
			else if(strResultStatus=="ABORT")
			{
				abortCounter++;
				int cnt1 = 0;
				cnt1++;
				abortCounterMap.put(runManagerInfoObj.getAppmodule(),cnt1);
			}
			else {
				passedWarningCounter++;
				int cnt1 =0;
				cnt1++;
				warningCounterMap.put(runManagerInfoObj.getAppmodule(),cnt1);
			}
           counterMap.put(runManagerInfoObj.getAppmodule(),cnt);
           testSummaryArray = new JsonArray();
            }
            testScriptObj = new JsonObject();
            testScriptObj.addProperty("S.No.", count);
            testScriptObj.addProperty("Module",runManagerInfoObj.getAppmodule());
            testScriptObj.addProperty("TestCaseId",runManagerInfoObj.getStrTestCaseId());
            testScriptObj.addProperty("Test Case Name",runManagerInfoObj.getStrCaseName());
            testScriptObj.addProperty("Scenario",runManagerInfoObj.getStrScenario());
            
            String TeststrtTimeKey="TestStartTime"+runManagerInfoObj.getStrTestCaseId();
            testScriptObj.addProperty("Test script Start Time",m1.get(TeststrtTimeKey).toString());
			
			// Hard Coded Values need to remove
			JsonArray individualTestSriptArray = new JsonArray();
			String TestScriptEndTime=null;
			for(int testSteps=0;testSteps<=runManagerInfoObj.getTestCounter();testSteps++){
				
				testKey="Step"+testSteps+runManagerInfoObj.getStrTestCaseId();
				System.out.println(testKey);
				TestStepDetails TestStepDetailsobj=TestDetailsMap.get(testKey);
				
				JsonObject scriptObj = new JsonObject();
				scriptObj.addProperty("Step Description", TestStepDetailsobj.getStepDesc());
				scriptObj.addProperty("Actual result", TestStepDetailsobj.getActualResult());
				scriptObj.addProperty("Status", TestStepDetailsobj.getResult());
				scriptObj.addProperty("Step Time", TestStepDetailsobj.getTime());
				TestScriptEndTime=TestStepDetailsobj.getTime();
				individualTestSriptArray.add(scriptObj);
				
			}

			testScriptObj.add("Test Script Step Details", individualTestSriptArray);
			testScriptObj.addProperty("Overall Execution Status",strResultStatus);
			if(strResultStatus=="FAIL"||strResultStatus=="ABORT"){
			String FailedAtStep="FAILEDSTEPNAME"+runManagerInfoObj.getStrTestCaseId();
			String failedatStep=m1.get(FailedAtStep).toString();
			
			String actualResultStr="ACTUALRESULT"+runManagerInfoObj.getStrTestCaseId();
			String actualResult=m1.get(actualResultStr).toString();
			
			String ReasonForFailure="Failed at step:"+failedatStep+" Actual Result:"+actualResult;
			testScriptObj.addProperty("Reason For Failure", ReasonForFailure);
			}
			else{
				testScriptObj.addProperty("Reason For Failure", "NA");
			}
			
			String testStrtTime=m1.get(TeststrtTimeKey).toString();
			System.out.println(testStrtTime);
			Date strt=sdf.parse(m1.get(TeststrtTimeKey).toString());
			System.out.println(TestScriptEndTime);
			Date testEndTime=sdf.parse(TestScriptEndTime);
			
			long diff1 = testEndTime.getTime() - strt.getTime();			
			double TestdiffInMins = Math.round(diff1/ ((double) 1000 * 60));	
			
			testScriptObj.addProperty("Test script End Time",TestScriptEndTime);
			testScriptObj.addProperty("Overall Test Script Execution Time ",TestdiffInMins);
			testSummaryArray.add(testScriptObj);
			
			moduleInfo.add("Test Script Excecution Summary", testSummaryArray);
			moduleInfo.addProperty("Number of Test Cases Executed", counterMap.get(runManagerInfoObj.getAppmodule()));
			moduleInfo.addProperty("PASSED", PassedCounterMap.get(runManagerInfoObj.getAppmodule()));
			moduleInfo.addProperty("FAILED", FailedCounterMap.get(runManagerInfoObj.getAppmodule()));
			moduleInfo.addProperty("WARNING", warningCounterMap.get(runManagerInfoObj.getAppmodule()));
			moduleInfo.addProperty("ABORT", abortCounterMap.get(runManagerInfoObj.getAppmodule()));
			moduleInfo.addProperty("Module Execution End Time",m1.get(moduleEndKey).toString());
			moduleInfo.addProperty("Overall module Execution Time (in Mins)", m1.get(modDiffTimeKey).toString());
			jsoarry.add(moduleInfo);
			
			
			DecimalFormat df= new DecimalFormat("#.##");
			float passPercentage = (passedCounter*100.0f)/count;
			float failPercentage=(failedCounter*100.0f)/count;
			float abortPercentage=(abortCounter*100.0f)/count;
			float WarningPercentage=(passedWarningCounter*100.0f)/count;
			
			
			Date d=sdf.parse(m1.get("ExecutionStartTime").toString());
			Date dd=sdf.parse(m1.get("ExecutionEndTime").toString());
			long diff2 = dd.getTime() - d.getTime();			
			double TotalExecdiffInMins = diff2/ ((double) 1000 * 60);	
			
			jsonObjectSpectrum.addProperty("Total Execution Start Time", m1.get("ExecutionStartTime").toString());
			jsonObjectSpectrum.addProperty("Total Execution End Time", m1.get("ExecutionEndTime").toString());
			jsonObjectSpectrum.addProperty("Overall Execution Time (in Mins)", Math.round(TotalExecdiffInMins));
			jsonObjectSpectrum.add("Module Execution Summary", jsoarry);
			jsonObjectSpectrum.addProperty("Total Number of Test Cases Executed", count);
			jsonObjectSpectrum.addProperty("PASSED(%):", df.format(passPercentage));
			jsonObjectSpectrum.addProperty("FAILED(%):",df.format(failPercentage));
			jsonObjectSpectrum.addProperty("WARNING(%):", df.format(WarningPercentage));
			jsonObjectSpectrum.addProperty("ABORT(%):", df.format(abortPercentage));
			jsonObjectSpectrum.addProperty("Overall Execution Time (in Mins)", Math.round(TotalExecdiffInMins));
			jsonObject.add("Spectrum Business Automation Execution Report",jsonObjectSpectrum);
			
			file = new FileWriter(strJsonFileName);
			file.write(jsonObject.toString());
			file.flush();
			file.close();
        }
        
        
        catch(Exception e){
        	e.printStackTrace();
        }
	}
}
