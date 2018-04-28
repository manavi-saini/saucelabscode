package com.charter.sb.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.charter.sb.beans.RunManagerInfo;
import com.charter.sb.controllers.Initialization;
import com.charter.sb.resources.MB_PageObjects;
import com.charter.sb.utils.CommonFunctions;
import com.charter.sb.utils.ReportingFunctions;
import com.charter.sb.utils.RunManager;

public class CallsService extends Initialization{
	MB_PageObjects mbo = new MB_PageObjects();
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	public static boolean blnFlag = false;
	WebElement Contact_Edited;
	Random rg=new Random();
	int randomInt = rg.nextInt(10000);
	
	@SuppressWarnings("static-access")
	public synchronized boolean fn_CallLogsListDisplay(WebDriver driver, RunManagerInfo runManagerInfoObj)
	{
		try
		{
			blnFlag = false;
			int listSize = 0;

			//SPRINT 25_Call Log > List_ Logs display - The call log section should display only the last 100 items
			if(cnf.FnExplicitWait("XPATH",mbo.Voice_CallLogsList,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Call List is displayed", "Call List is displayed", "PASS",runManagerInfoObj);
				listSize = driver.findElements(By.xpath(mbo.Voice_CallLogsList)).size();
				Thread.sleep(1000);
				if(listSize <= 100)
				{
					blnFlag = true;
					repfn.FnUpdateTestStepResHTML("Verify the Call List is displayed with only last 100 calls", "Call List is displayed with only last 100 calls", "PASS",runManagerInfoObj);
				}
				else
				{
					blnFlag = false;
					repfn.FnUpdateTestStepResHTML("Verify the Call List is displayed with only last 100 calls", "Call List is not displayed with only last 100 calls", "FAIL",runManagerInfoObj);
				}

				//SPRINT 25_Call Log > List_View more information- An option to view more information should be present against each of the call logs listed in the page.
				if(listSize == driver.findElements(By.xpath(mbo.Voice_CallLogs_MoreDetailsLink)).size())
				{
					blnFlag = true;
					repfn.FnUpdateTestStepResHTML("Verify Option to view more information is displayed for all the logs displayed in the call logs page", "Option to view more information is displayed for all the logs displayed in the call logs page", "PASS",runManagerInfoObj);
				}
				else 
				{
					blnFlag = false;
					repfn.FnUpdateTestStepResHTML("Verify Option to view more information is displayed for all the logs displayed in the call logs page", "Option to view more information is not displayed for all the logs", "FAIL",runManagerInfoObj);
				}
			}
			else{
				blnFlag = false;
				repfn.FnUpdateTestStepResHTML("Verify Call List is displayed", "Call List is not displayed", "FAIL",runManagerInfoObj);
			}

		}
		catch (Exception e)
		{
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			repfn.FnUpdateTestStepResHTML("Verify More than 100 calls are displayed in  call log page", "More than 100 calls are not displayed in call Log page due to some exception", "FAIL",runManagerInfoObj);
			blnFlag = false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	 @SuppressWarnings({"static-access", "unchecked"})
	public synchronized boolean fn_FilteredAllCallLogVerification(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 
			 blnFlag = false;
			 
			 if(cnf.FnExplicitWait("XPATH", mbo.Voice_CallLogFilter,driver)){
				 repfn.FnUpdateTestStepResHTML("Verify Filter dropdown is displayed", "Filter dropdown is displayed", "PASS",runManagerInfoObj);
				 
				 WebElement callLogsFilter = driver.findElement(By.xpath(mbo.Voice_CallLogFilter));
				 if(cnf.JSClick(callLogsFilter,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify Filter dropdown is clicked", "Filter dropdown is clicked", "PASS",runManagerInfoObj);
					 Thread.sleep(3000);
					 
					 if(cnf.FnExplicitWait("XPATH",mbo.Voice_FilterAll,driver)){
						 repfn.FnUpdateTestStepResHTML("Verify All CallLog filter is displayed", "All CallLog filter is displayed", "PASS",runManagerInfoObj);
						 WebElement ALL_callFilter = driver.findElement(By.xpath(mbo.Voice_FilterAll));
						 if(cnf.JSClick(ALL_callFilter,driver)){
							 repfn.FnUpdateTestStepResHTML("Verify All CallLog filter is clicked", "All CallLog filter is clicked", "PASS",runManagerInfoObj);
							 if(cnf.FnExplicitWait("XPATH", mbo.voice_CallListtype,driver)){
								 List<WebElement> CallList=driver.findElements(By.xpath(mbo.voice_CallListtype));
								 
								 if(CallList.size() > 0){
									 for(WebElement w:CallList){
										 System.out.println(w.getAttribute("innerHTML"));
										 if(w.getAttribute("innerHTML").contains("Outgoing") ||w.getAttribute("innerHTML").contains("Incoming")||w.getAttribute("innerHTML").contains("Outgoing")||w.getAttribute("innerHTML").contains("Missed")){
											 repfn.FnUpdateTestStepResHTML("Verify All callLog filter is displayed with incoming outgoing and missed calls", "All callLog filter is displayed with incoming outgoing and missed calls", "PASS",runManagerInfoObj);
											 blnFlag=true;
											 break;
										 }
									 }
								 }
								 else{
									 repfn.FnUpdateTestStepResHTML("Verify Call logs are displayed on selecting \'All\' filter", " Call logs are not displayed on selecting \'All\' filter", "FAIL",runManagerInfoObj);
									 blnFlag = false;
								 }
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify Call logs are displayed on selecting \'All\' filter", " Call logs are not displayed on selecting \'All\' filter", "FAIL",runManagerInfoObj);
								 blnFlag = false;
							 }
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify All CallLog filter is clicked", "All CallLog filter is not clicked", "FAIL",runManagerInfoObj);
							 blnFlag = false;
						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify All CallLog filter is displayed", "All CallLog filter is not displayed", "FAIL",runManagerInfoObj);
						 blnFlag = false;
					 }
					 
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify Filter dropdown is clicked", "Filter dropdown is not clicked", "FAIL",runManagerInfoObj);
					 blnFlag = false;
				 }
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify Filter dropdown is displayed", "Filter dropdown is not displayed", "FAIL",runManagerInfoObj);
				 blnFlag = false;
			 }
		 }
		 catch (Exception e)
		 {

			 repfn.FnUpdateTestStepResHTML("Verify All callLog filter is displayed with incoming outgoing and missed calls", "All callLog filter is not  displayed with incoming outgoing and missed calls due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag = false;
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }

	 @SuppressWarnings("static-access")
	public synchronized boolean fn_FilteredMissedCallLogVerification(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {			 
			 blnFlag = false;
			 
			 if(cnf.FnExplicitWait("XPATH", mbo.Voice_CallLogFilter,driver)){
				 repfn.FnUpdateTestStepResHTML("Verify Filter dropdown is displayed", "Filter dropdown is displayed", "PASS",runManagerInfoObj); 
				 WebElement callLogsFilter = driver.findElement(By.xpath(mbo.Voice_CallLogFilter));
				 if(cnf.JSClick(callLogsFilter,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify Filter dropdown is clicked", "Filter dropdown is clicked", "PASS",runManagerInfoObj);
					 
					 Thread.sleep(3000);
					 
					 if(cnf.FnExplicitWait("XPATH",mbo.Voice_FilterMissed,driver)){
						 repfn.FnUpdateTestStepResHTML("Verify Missed callLog filter is displayed", "Missed callLog filter is displayed", "PASS",runManagerInfoObj);
						 WebElement Voice_FilterMissed = driver.findElement(By.xpath(mbo.Voice_FilterMissed));
						 if(cnf.JSClick(Voice_FilterMissed,driver)){
							 repfn.FnUpdateTestStepResHTML("Verify Missed callLog filter is clicked", "Missed callLog filter is clicked", "PASS",runManagerInfoObj);
							 
							 if(cnf.FnExplicitWait("XPATH", mbo.voice_CallListtype,driver)){
								 List<WebElement> CallList=driver.findElements(By.xpath(mbo.voice_CallListtype));
								 
								 if(CallList.size() > 0){
									 for(WebElement w:CallList){
										 System.out.println(w.getAttribute("innerHTML"));
										 if(w.getAttribute("innerHTML").contains("Missed")){
											 repfn.FnUpdateTestStepResHTML("Verify Missed callLog filter is displayed with only with missed calls", "Missed callLog filter is displayed with only with missed calls", "PASS",runManagerInfoObj);
											 blnFlag = true;
											 break;
										 }
									 }
								 }
								 else{
									 repfn.FnUpdateTestStepResHTML("Verify Call logs are displayed on selecting \'Missed\' filter", " Call logs are not displayed on selecting \'Missed\' filter", "FAIL",runManagerInfoObj);
									 blnFlag = false;
								 }
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify Call logs are displayed on selecting \'Missed\' filter", " Call logs are not displayed on selecting \'Missed\' filter", "FAIL",runManagerInfoObj);
								 blnFlag = false;
							 }
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify Missed callLog filter is clicked", "Missed callLog filter is not clicked", "FAIL",runManagerInfoObj);
							 blnFlag = false;
						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify Missed callLog filter is displayed", "Missed callLog filter is not displayed", "FAIL",runManagerInfoObj);
						 blnFlag = false;
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify Filter dropdown is clicked", "Filter dropdown is not clicked", "FAIL",runManagerInfoObj);
					 blnFlag = false;
				 }
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify Filter dropdown is displayed", "Filter dropdown is not displayed", "FAIL",runManagerInfoObj);
				 blnFlag = false;
			 }
		 }
		 catch (Exception e)
		 {

			 repfn.FnUpdateTestStepResHTML("Verify Missed callLog filter is displayed with only with missed calls", "Missed callLog filter is  not displayed with only with missed calls due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag = false;
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }
	 @SuppressWarnings("static-access")
	public synchronized boolean FN_VerifyNoMissedCallFilter(WebDriver driver, RunManagerInfo runManagerInfoObj){
		 try{

			 if(cnf.FnExplicitWait("XPATH",mbo.Voice_VoiceLineDropdown,driver)){
				 repfn.FnUpdateTestStepResHTML("Verify if VoicelineDropdown is displayed","VoicelineDropdown is displayed","PASS",runManagerInfoObj);
				 WebElement VoicelineDropdown=driver.findElement(By.xpath(mbo.Voice_VoiceLineDropdown));
				 if(cnf.JSClick(VoicelineDropdown,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify if VoicelineDropdown is clicked","VoicelineDropdown is clicked","PASS",runManagerInfoObj);

					 if(cnf.FnExplicitWait("XPATH",mbo.Voice_LineList,driver)){
						 repfn.FnUpdateTestStepResHTML("Verify  Voiceline list is displayed","Voiceline list is displayed","PASS",runManagerInfoObj); 
						 List<WebElement> voiceLineList=driver.findElements(By.xpath(mbo.Voice_LineList));
						 if(voiceLineList.get(1).isDisplayed()){
							 if(cnf.JSClick(voiceLineList.get(1),driver)){
								 repfn.FnUpdateTestStepResHTML("Verify New Voiceline is clicked and User is able to change the Line","New Voiceline is clicked and User is able to change the Line","PASS",runManagerInfoObj);

								 if(cnf.FnExplicitWait("XPATH", mbo.Voice_CallLogFilterDisabled,driver)){
									 WebElement callLogsFilter = driver.findElement(By.xpath(mbo.Voice_CallLogFilterDisabled));
									 if(callLogsFilter.getText().contains("All")){
										 repfn.FnUpdateTestStepResHTML("Verify Missed callLog filter is not displayed and only All call fiter is displayed by default", "Missed callLog filter is not displayed and only All call fiter is displayed by default", "PASS",runManagerInfoObj);
										 blnFlag=true;
									 }
									 else{
										 repfn.FnUpdateTestStepResHTML("Verify Missed callLog filter is not displayed and only All call fiter is displayed by default", "Missed callLog filter is displayed and only All call fiter is not displayed by default", "FAIL",runManagerInfoObj);
										 blnFlag=false;
									 }
								 }
								 
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify New Voiceline is clicked and User is able to change the Line","New Voiceline is not clicked and User is not able to change the Line","FAIL",runManagerInfoObj);
								 blnFlag=false;
							 }
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify New Voiceline is displayed","New Voiceline is not displayed","FAIL",runManagerInfoObj);
							 blnFlag=false;
						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify  Voiceline list is displayed","Voiceline list is not displayed","FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if VoicelineDropdown is clicked","VoicelineDropdown is not clicked","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 else{
				 if(cnf.FnExplicitWait("XPATH",mbo.Voice_SingleLine,driver)){
					 WebElement Voice_SingleLine=driver.findElement(By.xpath(mbo.Voice_SingleLine));
					 repfn.FnUpdateTestStepResHTML("Verify if VoicelineDropdown is displayed","VoicelineDropdown is not displayed. Only Single Voice Line is assigned. "+Voice_SingleLine.getText(),"PASS",runManagerInfoObj);
					 if(cnf.FnExplicitWait("XPATH", mbo.Voice_CallLogFilterDisabled,driver)){
						 WebElement callLogsFilter = driver.findElement(By.xpath(mbo.Voice_CallLogFilterDisabled));
						 if(callLogsFilter.getText().contains("All")){
							 repfn.FnUpdateTestStepResHTML("Verify Missed callLog filter is not displayed and only All call fiter is displayed by default", "Missed callLog filter is not displayed and only All call fiter is displayed by default", "PASS",runManagerInfoObj);
							 blnFlag=true;
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify Missed callLog filter is not displayed and only All call fiter is displayed by default", "Missed callLog filter is displayed and only All call fiter is not displayed by default", "FAIL",runManagerInfoObj);
							 blnFlag=false;
						 }
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if VoicelineDropdown is displayed","VoicelineDropdown is not displayed. Single Voice Line is also not assigned.","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
				 
			 }
		 }
		 catch (Exception e)

		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
			 repfn.FnUpdateTestStepResHTML("Verify Missed callLog filter is  not displayed and only All call fiter is displayed by default", "Missed callLog filter is  displayed and only All call fiter is not  displayed by default due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }	
	 @SuppressWarnings({"unchecked", "static-access"})
	public synchronized boolean VoiceExportDownLoadClick(WebDriver driver, RunManagerInfo runManagerInfoObj){
			try{
				
				if(cnf.FnExplicitWait("Xpath", mbo.VoiceExport_DownloadBtn,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Export Call DownLoad Button is displayed","Export Call DownLoad Button is displayed","PASS",runManagerInfoObj);
					WebElement ExportDownLoad=driver.findElement(By.xpath(mbo.VoiceExport_DownloadBtn));
					if(cnf.JSClick(ExportDownLoad,driver)){
						Thread.sleep(1000);
						repfn.FnUpdateTestStepResHTML("Verify Export Call DownLoad Button is Clicked ","Export Call DownLoad Buttonk is Clicked","PASS",runManagerInfoObj);					
						if(driver.getCurrentUrl().contains("/call-logs/"))
						{
							repfn.FnUpdateTestStepResHTML("Verify CallLog  Page is Loaded "," CallLog  Page is Loaded","PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify  CallLog  Page is Loaded "," CallLog  Page is Loaded","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Export Call DownLoad Button is Clicked ","Export Call DownLoad Buttonk is not Clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Export Call DownLoad Button is displayed","Export Call DownLoad Button is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}

			catch (Exception e)

			{
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				repfn.FnUpdateTestStepResHTML("Verify CallLog Link is  Clicked and page is loaded "," CallLog Link is  Clicked and page is not  loaded due to some exception","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
	 /*
		 * Call log export Missed call
		 * Method Name : Demo CallLog_Export_MissedCall
		 * Method Description : This method is to export call logs for missed calls
		 * @return None
		 * @author Ajoy
		 * @param placeholder 
		 * @throws Exception
		 */

		@SuppressWarnings("static-access")
		public synchronized boolean CallLog_Export_MissedCall(WebDriver driver, RunManagerInfo runManagerInfoObj)
		{
			try{

				if(cnf.FnExplicitWait("XPATH", mbo.ExportCalls_MissedCalls,driver)){
					repfn.FnUpdateTestStepResHTML("Check whether Export Missed Calls CheckBox is displayed", "Export Missed Calls CheckBox is displayed","PASS",runManagerInfoObj);
					blnFlag	=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Check whether Export Missed Calls CheckBox is displayed", "Export Missed Calls CheckBox is not displayed","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.ExportCalls_DailledCalls,driver)){
					repfn.FnUpdateTestStepResHTML("Check whether Export Dialled Calls CheckBox is displayed", "Export Dialled Calls CheckBox is displayed","PASS",runManagerInfoObj);
					blnFlag	=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Check whether Export Dialled Calls CheckBox is displayed", "Export Dialled Calls CheckBox is not displayed","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.ExportCalls_ReceivedCalls,driver)){
					repfn.FnUpdateTestStepResHTML("Check whether Export Received Calls CheckBox is displayed", "Export Received Calls CheckBox is displayed","PASS",runManagerInfoObj);
					blnFlag	=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Check whether Export Received Calls CheckBox is displayed", "Export Received Calls CheckBox is not displayed","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
				
				//UnCheck Dialled Calls Check Box
				if(cnf.FnExplicitWait("XPATH", mbo.ExportCalls_DailledCalls,driver)){
					WebElement ExportCalls_DailledCalls=driver.findElement(By.xpath(mbo.ExportCalls_DailledCalls));	
					if(cnf.JSClick(ExportCalls_DailledCalls,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Export Dialled Calls CheckBox is unchecked", "Export Dialled Calls CheckBox is unchecked","PASS",runManagerInfoObj);
						blnFlag	=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Export Dialled Calls CheckBox is unchecked", "Export Dialled Calls CheckBox is not unchecked","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
				}			
				else
				{
					repfn.FnUpdateTestStepResHTML("Check whether Export Dialled Calls CheckBox is displayed", "Export Dialled Calls CheckBox is not displayed","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
				
				//UnCheck Received Calls Check Box
				if(cnf.FnExplicitWait("XPATH", mbo.ExportCalls_ReceivedCalls,driver)){
					WebElement ExportCalls_ReceivedCalls=driver.findElement(By.xpath(mbo.ExportCalls_ReceivedCalls));
					if(cnf.JSClick(ExportCalls_ReceivedCalls,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Export Received Calls CheckBox is unchecked", "Export Received Calls CheckBox is unchecked","PASS",runManagerInfoObj);
						blnFlag	=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Export Received Calls CheckBox is unchecked", "Export Received Calls CheckBox is not unchecked","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Check whether Export Received Calls CheckBox is displayed", "Export Received Calls CheckBox is not displayed","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
				
			}
			catch(Exception e)
			{
				blnFlag	=false;
				//repfn.FnUpdateTestStepResHTML("Login to Spectrum Business.net ", "Login is not performed due to exception","FAIL",runManagerInfoObj);
				repfn.FnUpdateTestStepResHTML("Check whether Export Missed Calls is displayed and selected", "Export Missed Calls check box is not displayed and selected due to some exception","PASS",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		 @SuppressWarnings("static-access")
		public synchronized boolean FN_ExportbuttonClick(WebDriver driver, RunManagerInfo runManagerInfoObj){
			 try{
				 
				 String message = null;
				 
				 if(cnf.FnExplicitWait("XPATH", mbo.Exportbutton,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify the Export button is displayed", "Export button is displayed","PASS",runManagerInfoObj);
					 WebElement Exportbutton=driver.findElement(By.xpath(mbo.Exportbutton));
					 if(cnf.JSClick(Exportbutton,driver)){
						 repfn.FnUpdateTestStepResHTML("Verify the Export button is clicked", "Export button is clicked","PASS",runManagerInfoObj);
						 
						 message = cnf.listFile(cnf.FILE_DIR, cnf.FILE_TEXT_EXT1);
						 if(!message.contains("no files end with"))
						 {
							 repfn.FnUpdateTestStepResHTML("Verify if Export call can be read in CSV form","Export call can be read in CSV form","PASS",runManagerInfoObj);
							 blnFlag=true;

						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify if Export call can be read in CSV form","Export call cannot be read in CSV form","FAIL",runManagerInfoObj);
							 blnFlag=false;
						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify the Export button is clicked", "Export button is not clicked","FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify the Export button is displayed", "Export button is not displayed","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }

			 catch(Exception e)
			 {
				 System.err.println("Message : "+e.getMessage());
				 System.err.println("Cause : "+e.getCause());
				 repfn.FnUpdateTestStepResHTML("Verify the Export button is displayed and clicked ", "Export button is  not displayed and  not clicked due to some exception","FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;
		 }
		 /*
			 * Call log export Dialed call
			 * Method Name : Demo CallLog_Export_DialedCall
			 * Method Description : This method is to export call logs for missed calls
			 * @return None
			 * @author Ajoy
			 * @param placeholder 
			 * @throws Exception
			 */

			@SuppressWarnings("static-access")
			public synchronized boolean CallLog_Export_DialedCall(WebDriver driver, RunManagerInfo runManagerInfoObj)
			{

				try{


					if(cnf.FnExplicitWait("XPATH", mbo.ExportCalls_MissedCalls,driver)){
						repfn.FnUpdateTestStepResHTML("Check whether Export Missed Calls CheckBox is displayed", "Export Missed Calls CheckBox is displayed","PASS",runManagerInfoObj);
						blnFlag	=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Check whether Export Missed Calls CheckBox is displayed", "Export Missed Calls CheckBox is not displayed","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
					
					if(cnf.FnExplicitWait("XPATH", mbo.ExportCalls_DailledCalls,driver)){
						repfn.FnUpdateTestStepResHTML("Check whether Export Dialled Calls CheckBox is displayed", "Export Dialled Calls CheckBox is displayed","PASS",runManagerInfoObj);
						blnFlag	=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Check whether Export Dialled Calls CheckBox is displayed", "Export Dialled Calls CheckBox is not displayed","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
					
					if(cnf.FnExplicitWait("XPATH", mbo.ExportCalls_ReceivedCalls,driver)){
						repfn.FnUpdateTestStepResHTML("Check whether Export Received Calls CheckBox is displayed", "Export Received Calls CheckBox is displayed","PASS",runManagerInfoObj);
						blnFlag	=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Check whether Export Received Calls CheckBox is displayed", "Export Received Calls CheckBox is not displayed","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
					
					//UnCheck Missed Calls Check Box
					if(cnf.FnExplicitWait("XPATH", mbo.ExportCalls_MissedCalls,driver)){
						WebElement ExportCalls_MissedCalls=driver.findElement(By.xpath(mbo.ExportCalls_MissedCalls));					
							if(cnf.JSClick(ExportCalls_MissedCalls,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Export Missed Calls CheckBox is unchecked", "Export Missed Calls CheckBox is unchecked","PASS",runManagerInfoObj);
								blnFlag	=true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Export Missed Calls CheckBox is unchecked", "Export Missed Calls CheckBox is not unchecked","FAIL",runManagerInfoObj);
								blnFlag	=false;
							}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Check whether Export Missed Calls CheckBox is displayed", "Export Missed Calls CheckBox is not displayed","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
					
					//UnCheck Received Calls Check Box
					if(cnf.FnExplicitWait("XPATH", mbo.ExportCalls_ReceivedCalls,driver)){
						WebElement ExportCalls_ReceivedCalls=driver.findElement(By.xpath(mbo.ExportCalls_ReceivedCalls));				
							if(cnf.JSClick(ExportCalls_ReceivedCalls,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Export Received Calls CheckBox is unchecked", "Export Received Calls CheckBox is unchecked","PASS",runManagerInfoObj);
								blnFlag	=true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Export Received Calls CheckBox is unchecked", "Export Received Calls CheckBox is not unchecked","FAIL",runManagerInfoObj);
								blnFlag	=false;
							}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Check whether Export Received Calls CheckBox is displayed", "Export Received Calls CheckBox is not displayed","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
					
					
				}
				catch(Exception e)
				{
					blnFlag	=false;
					repfn.FnUpdateTestStepResHTML("Check whether Export Dialled Calls are displayed and clicked ", "Export Dialled Calls are not displayed and not clicked due to some exception","FAIL",runManagerInfoObj);
					System.err.println("Message : "+e.getMessage());
					System.err.println("Cause : "+e.getCause());
				}
				m1.put("STEPSTATUS", blnFlag);
				return blnFlag;
			}
			/**
			 * Method Name : Demo CallLogs Block and Cancel
			 * Method Description : This method is to block the unsaved contacts and cancel the action
			 * @author Ajoy
			 * @param placeholder 
			 * @throws Exception
			 */

			@SuppressWarnings("static-access")
			public synchronized boolean Fn_callLogBlock_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
			{

				try{


					if(cnf.FnExplicitWait("XPATH", mbo.Calllog_logList,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Call logs are displayed"," Call logs are displayed","PASS",runManagerInfoObj);
						List <WebElement> ContactNumber=driver.findElements(By.xpath(mbo.Calllog_logList));
						List <WebElement> ContactNumbers=new ArrayList();
						
						for(WebElement Contacts:ContactNumber)
						{
							String ContactsText=Contacts.getText();
							if(ContactsText.contains("("))
							{
								ContactNumbers.add(Contacts);
							}
						}
						
						if(ContactNumbers.size()>0){
							repfn.FnUpdateTestStepResHTML("Verify Call logs are displayed for Unsaved Contact","Call logs are displayed for Unsaved Contact","PASS",runManagerInfoObj);
							if(cnf.JSClick(ContactNumbers.get(0),driver)){
								repfn.FnUpdateTestStepResHTML("Verify whether Unsaved contact is clicked", " Unsaved contact clicked is: "+ContactNumbers.get(0).getText(),"PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify whether Unsaved contact is clicked", " Unsaved contact is not clicked ","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Call logs are displayed for Unsaved Contact","Call logs are not displayed for Unsaved Contact","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Call logs are displayed"," Call logs are not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

				}

				catch (Exception e)

				{
					System.err.println("Message : "+e.getMessage());
					System.err.println("Cause : "+e.getCause());
					repfn.FnUpdateTestStepResHTML("Verify whether the user is able to block a contact", "The user is not able to block a contact due to some exception","PASS",runManagerInfoObj);	
					blnFlag=false;
				}
				m1.put("STEPSTATUS", blnFlag);
				return blnFlag;
			}

			/**
			 * Method Name : Demo fn_callLogBlockSave
			 * Method Description : This method is to block the unsaved contacts and save
			 * @author Ajoy
			 * @param placeholder 
			 * @throws Exception
			 */

			public synchronized boolean fn_callLogBlockSave(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
			{

				try{
					
					if(cnf.FnExplicitWait("XPATH", mbo.Calllog_block,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify whether Block link is getting displayed", "Block link is getting displayed ","PASS",runManagerInfoObj);
						WebElement BlockMessages=driver.findElement(By.xpath(mbo.Calllog_block));
						if(cnf.JSClick(BlockMessages,driver)){
							repfn.FnUpdateTestStepResHTML("Verify whether Block link is clicked", "Block link is clicked ","PASS",runManagerInfoObj);
							blnFlag=app.FN_ConfirmationPop_Saveclick(driver, runManagerInfoObj);
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify whether Block link is clicked", "Block link is not clicked ","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else if(cnf.FnExplicitWait("XPATH", mbo.Calllog_Unblock,driver)){
						repfn.FnUpdateTestStepResHTML("Verify whether Block link is getting displayed", "Block link is not getting displayed. Contact is already blocked","PASS",runManagerInfoObj);
						WebElement Calllog_Unblock=driver.findElement(By.xpath(mbo.Calllog_Unblock));
						if(cnf.JSClick(Calllog_Unblock,driver)){
							repfn.FnUpdateTestStepResHTML("Verify whether UnBlock link is clicked", "UnBlock link is clicked to unblock the contact","PASS",runManagerInfoObj);
							Thread.sleep(5000);
							
							if(cnf.FnExplicitWait("XPATH", mbo.Calllog_block,driver))
							{
								repfn.FnUpdateTestStepResHTML("Verify whether Block link is getting displayed", "Block link is getting displayed ","PASS",runManagerInfoObj);
								WebElement BlockMessages=driver.findElement(By.xpath(mbo.Calllog_block));
								if(cnf.JSClick(BlockMessages,driver)){
									repfn.FnUpdateTestStepResHTML("Verify whether Block link is clicked", "Block link is clicked ","PASS",runManagerInfoObj);
									blnFlag=app.FN_ConfirmationPop_Saveclick(driver, runManagerInfoObj);
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify whether Block link is clicked", "Block link is not clicked ","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify whether Block link is getting displayed", "Block link is not  getting displayed  ","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify whether UnBlock link is clicked", "UnBlock link is not clicked to unblock the contact","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
				}

				catch (Exception e)

				{
					System.err.println("Message : "+e.getMessage());
					System.err.println("Cause : "+e.getCause());
					repfn.FnUpdateTestStepResHTML("Verify the user is able to block the unsaved contacts and save", "The user is  not able to block the unsaved contacts and save due to some exception","FAIL",runManagerInfoObj);		
					blnFlag=false;
				}
				m1.put("STEPSTATUS", blnFlag);
				return blnFlag;
			}
		
			public synchronized boolean FN_BlockingContact_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
				 try{

					 if(cnf.FnExplicitWait("XPATH", mbo.Calllog_block,driver))
					 {
						 repfn.FnUpdateTestStepResHTML("Verify whether Block link is getting displayed", "Block link is getting displayed ","PASS",runManagerInfoObj);
						 WebElement BlockMessages=driver.findElement(By.xpath(mbo.Calllog_block));
						 if(cnf.JSClick(BlockMessages,driver)){
							 repfn.FnUpdateTestStepResHTML("Verify whether Block link is clicked", "Block link is clicked ","PASS",runManagerInfoObj);
							 blnFlag=app.FN_ConfirmationPop_Cancelclick(driver, runManagerInfoObj);
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify whether Block link is clicked", "Block link is not clicked ","FAIL",runManagerInfoObj);
							 blnFlag=false;
						 }
					 }
					 else if(cnf.FnExplicitWait("XPATH", mbo.Calllog_Unblock,driver)){
						 repfn.FnUpdateTestStepResHTML("Verify whether Block link is getting displayed", "Block link is not getting displayed. Contact is already blocked","PASS",runManagerInfoObj);
						 WebElement Calllog_Unblock=driver.findElement(By.xpath(mbo.Calllog_Unblock));
						 if(cnf.JSClick(Calllog_Unblock,driver)){
							 repfn.FnUpdateTestStepResHTML("Verify whether UnBlock link is clicked", "UnBlock link is clicked to unblock the contact","PASS",runManagerInfoObj);
							 Thread.sleep(5000);

							 if(cnf.FnExplicitWait("XPATH", mbo.Calllog_block,driver))
							 {
								 repfn.FnUpdateTestStepResHTML("Verify whether Block link is getting displayed", "Block link is getting displayed ","PASS",runManagerInfoObj);
								 WebElement BlockMessages=driver.findElement(By.xpath(mbo.Calllog_block));
								 if(cnf.JSClick(BlockMessages,driver)){
									 repfn.FnUpdateTestStepResHTML("Verify whether Block link is clicked", "Block link is clicked ","PASS",runManagerInfoObj);
									 blnFlag=app.FN_ConfirmationPop_Cancelclick(driver, runManagerInfoObj);
								 }
								 else{
									 repfn.FnUpdateTestStepResHTML("Verify whether Block link is clicked", "Block link is not clicked ","FAIL",runManagerInfoObj);
									 blnFlag=false;
								 }
							 }
							 else
							 {
								 repfn.FnUpdateTestStepResHTML("Verify whether Block link is getting displayed", "Block link is not  getting displayed  ","FAIL",runManagerInfoObj);
								 blnFlag=false;
							 }
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify whether UnBlock link is clicked", "UnBlock link is not clicked to unblock the contact","FAIL",runManagerInfoObj);
							 blnFlag=false;
						 }
					 }
				 }
				 catch(Exception e)
				 {
					 repfn.FnUpdateTestStepResHTML("Verify whether Block link is getting displayed", "Block link is not  getting displayed  ","FAIL",runManagerInfoObj);
					 blnFlag=false;
					 System.err.println("Message : "+e.getMessage());
					 System.err.println("Cause : "+e.getCause());

				 }
				 m1.put("STEPSTATUS", blnFlag);
				 return blnFlag;
			 }
			/**
			 * Method Name : Fn_Savedcontact_Click
			 * Method Description : This method is used to click Saved contact in the logs
			 * @param none
			 * @return Boolean
			 * @author Saranya
			 * @throws Exception
			 * Date:10/14/2015
			 */

			@SuppressWarnings("static-access")
			public synchronized boolean Fn_Savedcontact_Click(WebDriver driver, RunManagerInfo runManagerInfoObj)
			{
				try
				{
					if(cnf.FnExplicitWait("XPATH", mbo.Savedcontacts,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Call Log List is displayed", "Call Log List is displayed","PASS",runManagerInfoObj);
						List <WebElement> ContactNumber=driver.findElements(By.xpath(mbo.Savedcontacts));  
						List <WebElement> ContactNumbers=new ArrayList<WebElement>(); 
						for(WebElement Contact:ContactNumber){
							String Contacts=Contact.getText();
							if(!(Contacts.contains("Unknown") || Contacts.contains("(")))
							{
								ContactNumbers.add(Contact);
							}
							
						}
						
						if(ContactNumbers.size() > 0){
							repfn.FnUpdateTestStepResHTML("Verify if Saved contacts exist in the Call Log List", "Saved contacts exist in the Call Log List ","PASS",runManagerInfoObj);
							Contact_Edited=ContactNumbers.get(0);
							if(cnf.JSClick(ContactNumbers.get(0),driver)){
								repfn.FnUpdateTestStepResHTML("Verify Saved Contact is clicked", "Saved Contact is clicked","PASS",runManagerInfoObj);
								Thread.sleep(2000);
								
								if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
									repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);
									blnFlag=true;
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
						  	        blnFlag=false;
								}
								
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Saved Contact is clicked", "Saved Contact is not clicked","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify if Saved contacts exist in the Call Log List", "Saved contacts does not exist in the Call Log List. Contacts needs to saved. ","PASS",runManagerInfoObj);
							boolean blnFlag1 = fnUnsavedContactsSave(driver, runManagerInfoObj);
							if(blnFlag1){
								boolean blnFlag2 = Fn_Savedcontact_Click(driver, runManagerInfoObj);
								if(blnFlag2){
									blnFlag=true;
								}
								else{
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify whether Contact is saved or not", "Contact is not saved in the list ","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Call Log List is displayed", "Call Log List is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

				}

				catch (Exception e)

				{
					System.err.println("Message : "+e.getMessage());
					System.err.println("Cause : "+e.getCause());
					repfn.FnUpdateTestStepResHTML("Verify if saved contacts details are displayed", "Saved contacts details are not  displayed due to some exception ","PASS",runManagerInfoObj);
					blnFlag=false;
				}
				m1.put("STEPSTATUS", blnFlag);
				return blnFlag;

			}


			/**
			 * Method Name : Fn_CallLog_EditClick
			 * Method Description : This method is used to click edit button
			 * @param none
			 * @return Boolean
			 * @author Saranya
			 * @throws Exception
			 * Date:10/14/2015
			 */

			public synchronized boolean Fn_CallLog_EditClick(WebDriver driver, RunManagerInfo runManagerInfoObj){
				try{

					Thread.sleep(2000);
					if(cnf.FnExplicitWait("XPATH", mbo.CallLogedit,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Edit link is displayed in User Details page","Edit link is displayed in User Details page","PASS",runManagerInfoObj);
						WebElement Editbtn=driver.findElement(By.xpath(mbo.CallLogedit));
						if(cnf.JSClick(Editbtn,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Edit link is clicked","Edit link is clicked","PASS",runManagerInfoObj);
							
							if(cnf.FnExplicitWait("XPATH", mbo.EditModeUserForm,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Edit Contact form is displayed", "Edit Contact form is displayed","PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Edit Contact form is displayed", "Edit Contact form is not displayed","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
							
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Edit link is clicked","Edit link is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Edit link is displayed in User Details page","Edit link is not displayed in User Details page","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
				}
				
				catch (Exception e)

				{
					System.err.println("Message : "+e.getMessage());
					System.err.println("Cause : "+e.getCause());
					repfn.FnUpdateTestStepResHTML("Verify  Edit button is clicked "," Edit button is not clicked due to some exception","FAIL",runManagerInfoObj);
			      	 blnFlag=false;
				}
				m1.put("STEPSTATUS", blnFlag);
				return blnFlag;
			}
			public synchronized boolean Fn_CallLog_FirstName_LastNameEdit_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj){
				
				String fullName = "";
				try{
					
					if(cnf.FnExplicitWait("XPATH", mbo.EditMode_firstName,driver)){
						WebElement firstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
					
							String oldFirstName = firstName.getAttribute("value");
							firstName.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"Richa"+randomInt);
							String newFirstName = firstName.getAttribute("value");
							if(newFirstName != oldFirstName){
								repfn.FnUpdateTestStepResHTML("Verify First Name field is modified ","First Name field is modified","PASS",runManagerInfoObj); 
								blnFlag	=true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify First Name field is modified ","First Name field is not modified","FAIL",runManagerInfoObj);
								blnFlag	=false;
							}
							
						
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify First Name field is displayed ","First Name field is not displayed","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
					
					WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
					String newNameFirst = FirstName.getAttribute("value");
					
					if(cnf.FnExplicitWait("XPATH", mbo.EditMode_LastName,driver)){
						WebElement LastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
						
							String oldLastName = LastName.getAttribute("value");
							LastName.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"Kapoor");
							String newLastName = LastName.getAttribute("value");
							if(newLastName != oldLastName){
								 repfn.FnUpdateTestStepResHTML("Verify Last Name field is modified ","Last Name field is modified","PASS",runManagerInfoObj);
						      	 blnFlag=true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Last Name field is modified ","Last Name field is not modified","FAIL",runManagerInfoObj);
						      	 blnFlag=false;
							}
								
						
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Last Name field is displayed ","Last Name field is not displayed","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
					
					WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
					String newNameLast = lastName.getAttribute("value");
					
					fullName = newNameFirst+ " " +newNameLast;
					
					Thread.sleep(3000);
					
					Thread.sleep(2000);
					if(cnf.FnExplicitWait("XPATH", mbo.CancelEdit,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Cancel link is displayed in Edit Contact form","Cancel link is displayed in Edit Contact form","PASS",runManagerInfoObj);
						WebElement CancelEdit=driver.findElement(By.xpath(mbo.CancelEdit));
						if(cnf.JSClick(CancelEdit,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Cancel link is clicked in Edit Contact form","Cancel link is clicked in Edit Contact form","PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("XPATH", mbo.ConfirmCancel,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Confirmation pop-up is present or not", 
										"Confirmation pop-up is present","PASS",runManagerInfoObj);
								repfn.FnUpdateTestStepResHTML("Verify Cancel link is displayed in Confirm pop-up", "Cancel link is displayed in Confirm pop-up","PASS",runManagerInfoObj);
								WebElement ConfirmCancel=driver.findElement(By.xpath(mbo.ConfirmCancel));
								if(cnf.JSClick(ConfirmCancel,driver)){
									repfn.FnUpdateTestStepResHTML("Verify Confirm link is clicked in Confirm pop-up","Confirm link is clicked in Confirm pop-up","PASS",runManagerInfoObj);
									blnFlag	=true;
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Confirm link is clicked in Confirm pop-up","Confirm link is not clicked in Confirm pop-up","FAIL",runManagerInfoObj);
									blnFlag	=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Confirmation pop-up is present or not", "Confirmation pop-up is not present","FAIL",runManagerInfoObj);
								repfn.FnUpdateTestStepResHTML("Verify Cancel link is displayed in Confirm pop-up", "Cancel link is not displayed in Confirm pop-up","FAIL",runManagerInfoObj);
								blnFlag	=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Cancel link is clicked in Edit Contact form","Cancel link is not clicked in Edit Contact form","FAIL",runManagerInfoObj);
							blnFlag	=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Cancel link is displayed in Edit Contact form","Cancel link is not displayed in Edit Contact form","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
					
					//FnCancelAndGoBack();
					
					driver.navigate().refresh();
					
					if(cnf.FnExplicitWait("XPATH",mbo.searchBar,driver)){
						WebElement Search_Field=driver.findElement(By.xpath(mbo.searchBar));
						cnf.ScrollToView(Search_Field,driver);
						Search_Field.clear();
						Search_Field.sendKeys(fullName);
						repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
						Thread.sleep(2000);

						if(cnf.FnExplicitWait("XPATH",mbo.Contacts_CallLog_Arrow,driver)){
							List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_CallLog_Arrow));
							repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","FAIL",runManagerInfoObj);
							blnFlag=false;
							Search_Field.clear();
						}	
						else{
							repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List. Hence, Contact is not edited","PASS",runManagerInfoObj);
							blnFlag=true;
							Search_Field.clear();
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ","Search field is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

				}
				catch (Exception e)

				{
					System.err.println("Message : "+e.getMessage());
					System.err.println("Cause : "+e.getCause());
					repfn.FnUpdateTestStepResHTML("Verify EditMode_firstName/Lastname is able to edit","EditMode_firstName/Lastname is not able to edit due to some exception","FAIL",runManagerInfoObj);
			     	 blnFlag=false;
					
				}
				m1.put("STEPSTATUS", blnFlag);
				return blnFlag;	
			}
			@SuppressWarnings("static-access")
			public synchronized boolean fnAddToExistingSave(WebDriver driver, RunManagerInfo runManagerInfoObj)
			{
				boolean blnFlag=false;	
				String ContactsText = "";
				String FName = "";

				try{

					if(cnf.FnExplicitWait("XPATH", mbo.Calllog_logList,driver)){
						repfn.FnUpdateTestStepResHTML("Verify whether call logs are present or not", "Call logs are present","PASS",runManagerInfoObj);
						List <WebElement> ContactNumber=driver.findElements(By.xpath(mbo.Calllog_logList));
						List <WebElement> UnsavedContacts=new ArrayList<WebElement>();
						for(WebElement Contacts:ContactNumber)
						{
							if(Contacts.getText().startsWith("(") || Contacts.getText().matches("[0-9]+"))
							{
								UnsavedContacts.add(Contacts);

							}
						}

						if(UnsavedContacts.size()>0){
							repfn.FnUpdateTestStepResHTML("Verify whether any Unsaved number present or not", "Unsaved numbers are present","PASS",runManagerInfoObj);
							ContactsText=UnsavedContacts.get(0).getText();
							if(cnf.JSClick(UnsavedContacts.get(0),driver)){
								repfn.FnUpdateTestStepResHTML("Verify Unsaved Contact is clicked or not", "Unsaved Contact is clicked","PASS",runManagerInfoObj);
								try{

									if(cnf.FnExplicitWait("XPATH", mbo.Calllog_Unblock,driver)){
										repfn.FnUpdateTestStepResHTML("Verify Unblock link is displayed", "Unblock link is displayed. Hence, contact is blocked.","PASS",runManagerInfoObj);
										WebElement Call_UnBlock=driver.findElement(By.xpath(mbo.Calllog_Unblock));
										if(cnf.JSClick(Call_UnBlock,driver)){
											repfn.FnUpdateTestStepResHTML("Verify Unblock link is clicked", "Unblock link is clicked","PASS",runManagerInfoObj); 
											blnFlag=true;
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Unblock link is clicked", "Unblock link is not clicked","FAIL",runManagerInfoObj); 
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Unblock link is displayed", "Unblock link is not displayed. Hence, contact is not blocked.","PASS",runManagerInfoObj);
										blnFlag=true;
									}


								}
								catch(NoSuchElementException e)
								{
									System.out.println("Contact is not blocked , Add contact Link is present for Contact"+ContactsText);

								}

								if(cnf.FnExplicitWait("XPATH", mbo.AddToExistingContacts,driver)){
									repfn.FnUpdateTestStepResHTML("Verify Add To Contacts link is displayed", "Add To Contacts link is displayed","PASS",runManagerInfoObj);
									WebElement AddToExistingContacts=driver.findElement(By.xpath(mbo.AddToExistingContacts));
									if(cnf.JSClick(AddToExistingContacts,driver)){
										repfn.FnUpdateTestStepResHTML("Verify Add To Contacts link is clicked", "Add To Contacts link is clicked","PASS",runManagerInfoObj);
										if(cnf.FnExplicitWait("XPATH", mbo.Search,driver)){
											repfn.FnUpdateTestStepResHTML("Verify Whether Search field is getting displayed", "Search field is getting displayed pass","PASS",runManagerInfoObj); 
											blnFlag = true;
										}
										else
										{
											repfn.FnUpdateTestStepResHTML("Verify Whether Search field is getting displayed", "Search field is not getting displayed pass","FAIL",runManagerInfoObj);   
											blnFlag = false;
										}

										if(cnf.FnExplicitWait("XPATH", mbo.Search_Icon,driver)){
											repfn.FnUpdateTestStepResHTML("Verify Whether Search Icon is getting displayed", "Search Icon is getting displayed pass","PASS",runManagerInfoObj);  
											blnFlag = true;
										}
										else
										{
											repfn.FnUpdateTestStepResHTML("Verify Whether Search Icon is getting displayed", "Search Icon is not getting displayed pass","FAIL",runManagerInfoObj); 
											blnFlag = false;
										}

										if(cnf.FnExplicitWait("XPATH", mbo.ExistingContactList,driver)){
											repfn.FnUpdateTestStepResHTML("Verify Whether Contact list is displayed", "Contact list is displayed","PASS",runManagerInfoObj);  
											List <WebElement> Existing_List=driver.findElements(By.xpath(mbo.ExistingContactList));
											if(Existing_List.size()>0){
												FName=Existing_List.get(0).getText();
												if(cnf.JSClick(Existing_List.get(0),driver)){
													repfn.FnUpdateTestStepResHTML("Verify Whether a Contact is clicked", "A Contact is clicked","PASS",runManagerInfoObj); 
													if(cnf.FnExplicitWait("XPATH", mbo.Populated_Number,driver)){
														repfn.FnUpdateTestStepResHTML("Verify whether Phone number field is present in details section", "Phone number field is present in details section ","PASS",runManagerInfoObj);
														WebElement Number=driver.findElement(By.xpath(mbo.Populated_Number));
														String Populated_Number= Number.getText();
														if(ContactsText.contains(Populated_Number))
														{
															repfn.FnUpdateTestStepResHTML("Verify Whether Selected Number is pre-populated", "Selected Number is pre-populated: "+Populated_Number+": "+ContactsText,"PASS",runManagerInfoObj);
															blnFlag = true;
														}
														else
														{
															repfn.FnUpdateTestStepResHTML("Verify Whether Selected Number is pre-populated "+ContactsText, "Selected Number is not getting pre-populated: "+Populated_Number+": "+ContactsText,"FAIL",runManagerInfoObj);
															blnFlag = false;	 
														} 

													}
													else{
														repfn.FnUpdateTestStepResHTML("Verify whether Phone number field is present in details section", "Phone number field is not present in details section ","FAIL",runManagerInfoObj);
														blnFlag=false;
													}

													driver.manage().window().setSize(new Dimension(100, 100));
													driver.manage().window().maximize();

													if(cnf.FnExplicitWait("XPATH", mbo.Call_ContactSave,driver)){
														repfn.FnUpdateTestStepResHTML("Verify whether Save Contact option is present", "Save contact option is present ","PASS",runManagerInfoObj);
														WebElement Call_ContactSave=driver.findElement(By.xpath(mbo.Call_ContactSave));
														Thread.sleep(5000);
														if(cnf.JSClick(Call_ContactSave,driver)){
															repfn.FnUpdateTestStepResHTML("Verify whether Save Contact option is clicked", "Save contact option is clicked ","PASS",runManagerInfoObj);
															Thread.sleep(5000);
															if(cnf.FnExplicitWait("XPATH", mbo.SaveNotWorkingText,driver)){
																repfn.FnUpdateTestStepResHTML("Verify Save functionality working or not","Save functionality not working","FAIL",runManagerInfoObj);
																blnFlag=false;
																if(cnf.FnExplicitWaitFeedback("XPATH", mbo.Cancel_Button,driver))
																{
																	WebElement close=driver.findElement(By.xpath(mbo.Cancel_Button));
																	if(cnf.JSClick(close,driver)){
																		repfn.FnUpdateTestStepResHTML("Verify Cancel button is clicked","Cancel button is clicked","PASS",runManagerInfoObj);
																		blnFlag=false;
																		Thread.sleep(2000);
																		WebElement Confrm=driver.findElement(By.xpath(mbo.Confirm_btn));
																		System.out.println("click aftr save not working");
																		if(cnf.JSClick(Confrm,driver))
																		{
																			repfn.FnUpdateTestStepResHTML("Verify Confirm button is clicked","Confirm button is clicked","PASS",runManagerInfoObj);
																			Thread.sleep(2000);
																			driver.navigate().refresh();
																			Thread.sleep(2000);
																			//repfn.FnUpdateTestStepResHTML("Verify User is moved back to contacts page","User is moved back to contacts page","PASS",runManagerInfoObj);
																			blnFlag=false;
																		}
																		else{
																			repfn.FnUpdateTestStepResHTML("Verify Confirm button is clicked","Confirm button is not clicked","FAIL",runManagerInfoObj);
																			blnFlag=false;
																		}
																	}
																	else{
																		repfn.FnUpdateTestStepResHTML("Verify Cancel button is clicked","Cancel button is not clicked","FAIL",runManagerInfoObj);
																		blnFlag=false;
																	}
																}
																else{
																	repfn.FnUpdateTestStepResHTML("Verify Cancel button is displayed","Cancel button is not displayed","FAIL",runManagerInfoObj);
																	blnFlag=false;
																}
															}
															else{
																if(cnf.FnExplicitWait("XPATH", mbo.Calldetails_Back,driver)){
																	repfn.FnUpdateTestStepResHTML("Verify whether Back option is displayed", "Back option is displayed","PASS",runManagerInfoObj);
																	WebElement back=driver.findElement(By.xpath(mbo.Calldetails_Back));
																	if(cnf.JSClick(back,driver)){
																		repfn.FnUpdateTestStepResHTML("Verify whether Back option is clicked", "Back option is clicked","PASS",runManagerInfoObj);
																		blnFlag = true;


																		driver.navigate().refresh();

																		if(cnf.FnExplicitWait("XPATH", mbo.Call_Searchbox,driver)){
																			repfn.FnUpdateTestStepResHTML("Verify whether Search bar is present or not", "Search bar is present ","PASS",runManagerInfoObj);
																			WebElement Searchbox=driver.findElement(By.xpath(mbo.Call_Searchbox));
																			Searchbox.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),FName);
																			repfn.FnUpdateTestStepResHTML("Verify First Name is entered in Search field", "First Name is entered in Search field ","PASS",runManagerInfoObj);
																			if(cnf.FnExplicitWait("XPATH", mbo.Calllog_logList,driver)){
																				repfn.FnUpdateTestStepResHTML("Verify whether call list present or not after searching ", "Call list is present after searching ","PASS",runManagerInfoObj);
																				List<WebElement> ContactName=driver.findElements(By.xpath(mbo.Calllog_logList));
																				
																				if(cnf.JSClick(ContactName.get(0),driver)){
																					repfn.FnUpdateTestStepResHTML("Verify Saved Contact is clicked", "Saved Contact is clicked","PASS",runManagerInfoObj);
																					Thread.sleep(5000);
																					if(cnf.FnExplicitWait("XPATH", mbo.Contact_NumberList,driver)){
																						repfn.FnUpdateTestStepResHTML("Verify whether Contact List present or not", "Contact List is present  ","PASS",runManagerInfoObj);
																						List<WebElement> Contact_NumberList=driver.findElements(By.xpath(mbo.Contact_NumberList));
																						for(WebElement contact :Contact_NumberList)
																						{
																							String cntct=contact.getText();
																							System.out.println("Added contact: "+ContactsText);
																							System.out.println("contact in the list:"+cntct);
																							if(cntct.equalsIgnoreCase(ContactsText))
																							{
																								blnFlag=true;
																								break;
																							}
																						}
																						if(blnFlag){
																							repfn.FnUpdateTestStepResHTML("Verify whether Contact is saved to existing contact or not", "Contact is saved to the already existing contact Name: "+FName,"PASS",runManagerInfoObj);
																							blnFlag=true;
																						}else{
																							repfn.FnUpdateTestStepResHTML("Verify whether Contact is saved to existing contact or not", "Contact is not saved to the already existing contact Name: "+FName,"FAIL",runManagerInfoObj);
																							blnFlag=false;
																						}

																						Thread.sleep(5000);
																						if(cnf.FnExplicitWait("XPATH", mbo.Calldetails_Back,driver)){
																							repfn.FnUpdateTestStepResHTML("Verify whether Back option is present or not", "Back option is present ","PASS",runManagerInfoObj);
																							WebElement Back=driver.findElement(By.xpath(mbo.Calldetails_Back));
																							if(cnf.JSClick(Back,driver)){
																								repfn.FnUpdateTestStepResHTML("Verify whether Back option is clicked or not", "Back option is clicked ","PASS",runManagerInfoObj);
																								Thread.sleep(2000);
																								blnFlag=true;
																							}
																							else{
																								repfn.FnUpdateTestStepResHTML("Verify whether Back option is clicked or not", "Back option is not clicked ","FAIL",runManagerInfoObj);
																								blnFlag=false;
																							}

																						}else{
																							repfn.FnUpdateTestStepResHTML("Verify whether Back option is present or not", "Back option is not present ","FAIL",runManagerInfoObj);
																							blnFlag=false;
																						}


																					}else{
																						repfn.FnUpdateTestStepResHTML("Verify whether Contact List present or not", "Contact List not present  ","FAIL",runManagerInfoObj);
																						blnFlag=false;
																					}
																				}
																				else{
																					repfn.FnUpdateTestStepResHTML("Verify Saved Contact is clicked", "Saved Contact is not clicked","FAIL",runManagerInfoObj);
																					blnFlag=false;
																				}

																			}
																			else{
																				repfn.FnUpdateTestStepResHTML("Verify whether call list present or not after searching ", "call list not present after searching  ","FAIL",runManagerInfoObj);
																				blnFlag=false;
																			}
																		}
																		else{
																			repfn.FnUpdateTestStepResHTML("Verify whether Search bar present or not", "Search bar is not present ","FAIL",runManagerInfoObj);
																			blnFlag=false;
																		}
																	}
																	else{
																		repfn.FnUpdateTestStepResHTML("Verify whether Back option is clicked", "Back option is not clicked","FAIL",runManagerInfoObj);
																		blnFlag = false;
																	}
																}
																else{
																	repfn.FnUpdateTestStepResHTML("Verify whether Back option is displayed", "Back option is not displayed","FAIL",runManagerInfoObj);
																	blnFlag = false;
																}
															}
														}
														else{
															repfn.FnUpdateTestStepResHTML("Verify whether Save Contact option is clicked", "Save contact option is not clicked ","FAIL",runManagerInfoObj);
															blnFlag = false;
														}
													}
													else{
														repfn.FnUpdateTestStepResHTML("Verify whether Save Contact option is present", "Save contact option is not present ","FAIL",runManagerInfoObj);
													}

												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify Whether a Contact is clicked", "A Contact is not clicked","FAIL",runManagerInfoObj);
													blnFlag = false;
												}
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify Whether Contact list is displayed", "Contact list is not displayed","FAIL",runManagerInfoObj);
												blnFlag = false;
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Whether Contact list is displayed", "Contact list is not displayed","FAIL",runManagerInfoObj);
											blnFlag = false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Add To Contacts link is clicked", "Add To Contacts link is not clicked","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Add To Contacts link is displayed", "Add To Contacts link is not displayed","FAIL",runManagerInfoObj);
									blnFlag=false;
								}

							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Unsaved Contact is clicked or not", "Unsaved Contact is not clicked","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify whether any Unsaved number present or not", "Unsaved numbers are not present","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify whether call logs are present or not", "Call logs are not present","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}

				catch (Exception e)
				{
					repfn.FnUpdateTestStepResHTML("Verifying if the user is able to edit existing contact and add the number for calls from unsaved numbers from the call details window in the call logs page and save the changes.", " user is not able to edit existing contact and add the number for calls from unsaved numbers from the call details window in the call logs page and save the changes due to some exception","FAIL",runManagerInfoObj);
					blnFlag=false;
					System.err.println("Message : "+e.getMessage());
					System.err.println("Cause : "+e.getCause());
				}
				driver.navigate().refresh();
				m1.put("STEPSTATUS", blnFlag);
				System.out.println("Add to contact"+blnFlag);
				return blnFlag;
			}
			public synchronized boolean FnUnSavedCallLogDetails(WebDriver driver, RunManagerInfo runManagerInfoObj)
			{

				WebElement UnSavedContact = null;
				ArrayList<String> al = new ArrayList<String>();
				ArrayList<String> bl = new ArrayList<String>();
				
				try
				{	

					if(cnf.FnExplicitWait("XPATH",mbo.Savedcontacts,driver)){
						List <WebElement> SavedCallLogDetails=driver.findElements(By.xpath(mbo.Savedcontacts));
						List <WebElement> ContactNumbers=new ArrayList<WebElement>(); 

						for(WebElement Contact:SavedCallLogDetails){
							String Contacts=Contact.getText();
							if(Contacts.startsWith("(")||Contacts.matches("[0-9]+"))
							{
								ContactNumbers.add(Contact);
							}
						}

						if(ContactNumbers.size() > 0){
							repfn.FnUpdateTestStepResHTML("Verify if Unsaved call List is displayed", "Unsaved call List is displayed","PASS",runManagerInfoObj);
							
							for(int i=0;i<ContactNumbers.size();i++){
								if(cnf.JSClick(ContactNumbers.get(i),driver)){
									repfn.FnUpdateTestStepResHTML("Verify Unsaved Contact " +(i+1) +"is clicked", "Unsaved Contact " +(i+1)+ "is clicked","PASS",runManagerInfoObj);
									Thread.sleep(2000);
									if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
										repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);
										
										if(cnf.FnExplicitWait("XPATH",mbo.CreateNewContact,driver)){
											repfn.FnUpdateTestStepResHTML("Verify Create New Contact link is displayed ","Create New Contact link is displayed","PASS",runManagerInfoObj);
											blnFlag=true;
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Create New Contact link is displayed ","Create New Contact link is not displayed","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
										
										if(cnf.FnExplicitWait("XPATH",mbo.AddToExistingContact,driver)){
											repfn.FnUpdateTestStepResHTML("Verify Add To Existing Contact link is displayed ","Add To Existing Contact link is displayed","PASS",runManagerInfoObj);
											blnFlag=true;
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Add To Existing Contact link is displayed ","Add To Existing Contact link is not displayed","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
										
										if(cnf.FnExplicitWait("XPATH", mbo.Calldetails_Back,driver)){
											repfn.FnUpdateTestStepResHTML("Verify Back Link is displayed ","Back Link is displayed","PASS",runManagerInfoObj);
											WebElement Calldetails_Back=driver.findElement(By.xpath(mbo.Calldetails_Back));
											if(cnf.JSClick(Calldetails_Back,driver)){
												repfn.FnUpdateTestStepResHTML("Verify Back Link is clicked ","Back Link is clicked","PASS",runManagerInfoObj);
												blnFlag=true;
												Thread.sleep(2000);
												break;
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify Back Link is clicked ","Back Link is not clicked","FAIL",runManagerInfoObj);
												blnFlag=false;
												break;
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Back Link is displayed ","Back Link is not displayed","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
									
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Unsaved Contact is clicked", "Unsaved Contact is not clicked","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify if Unsaved call List is displayed", "Unsaved call List is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}

					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Contacts are displayed", "Contacts are not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

				}


				catch (Exception e)

				{
					System.err.println("Message : "+e.getMessage());
					System.err.println("Cause : "+e.getCause());
					repfn.FnUpdateTestStepResHTML("Verify if Unsaved Call Log Details are displayed", "Unsaved Call Log Details are not displayed due to some exception","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				m1.put("STEPSTATUS", blnFlag);
				return blnFlag;

			}
			
			@SuppressWarnings("static-access")
			public synchronized boolean fnUnsavedContactsSave(WebDriver driver, RunManagerInfo runManagerInfoObj)
			{
				boolean blnFlag=false;	
				String Name="Alex_";
				String lastName = "Pinto";
				String FirstName=cnf.generateRandomString();
				try{

					//Call log lists received
					if(cnf.FnExplicitWait("XPATH", mbo.Calllog_logList,driver)){
						repfn.FnUpdateTestStepResHTML("Verify whether any Call Log present or not", "Call Logs are present","PASS",runManagerInfoObj);
						List <WebElement> ContactNumber=driver.findElements(By.xpath(mbo.Calllog_logList));
						List <WebElement> ContactNumbers=new ArrayList<WebElement>();
						for(WebElement Contacts:ContactNumber)
						{
							if(Contacts.getText().startsWith("(")||Contacts.getText().matches("[0-9]+"))
							{
								ContactNumbers.add(Contacts);

							}
						}


						if(ContactNumbers.size()>0){

							String ContactsText=ContactNumbers.get(0).getText();	
							repfn.FnUpdateTestStepResHTML("Verify whether any call present from Unsaved Contact", "Call present from Unsaved Contact: "+ContactsText,"PASS",runManagerInfoObj);
							if(cnf.JSClick(ContactNumbers.get(0),driver)){
								repfn.FnUpdateTestStepResHTML("Verify Unsaved Contact is clicked", "Unsaved Contact is clicked","PASS",runManagerInfoObj);

								if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
									repfn.FnUpdateTestStepResHTML("Verify Call details section is loaded", "Call details section is loaded","PASS",runManagerInfoObj);

									try{
										Thread.sleep(5000);
										if(cnf.FnExplicitWait("XPATH", mbo.Voice_UnBlock,driver)){
											WebElement Call_UnBlock=driver.findElement(By.xpath(mbo.Voice_UnBlock));
											cnf.JSClick(Call_UnBlock,driver);
											blnFlag=true;
										}
										else{
											blnFlag=false;
										}
									}
									catch(NoSuchElementException e)
									{
										System.out.println("Contact is not blocked , Add contact Link is present for Contact");
									}

									if(cnf.FnExplicitWait("XPATH", mbo.Call_CreateNewContactLink,driver)){
										WebElement Call_CreateNewContactLink=driver.findElement(By.xpath(mbo.Call_CreateNewContactLink));
										Thread.sleep(5000);
										repfn.FnUpdateTestStepResHTML("Verify Create New Contact option is present", "Create New Contact is present","PASS",runManagerInfoObj);
										if(cnf.JSClick(Call_CreateNewContactLink,driver)){
											repfn.FnUpdateTestStepResHTML("Verify Create New Contact option is clicked or not", "Create New Contact is clicked","PASS",runManagerInfoObj);
											if(cnf.FnExplicitWait("ID", mbo.Call_ContactFirstName,driver)){
												repfn.FnUpdateTestStepResHTML("Verify First Name field is displayed", "First Name field is displayed","PASS",runManagerInfoObj);
												WebElement Call_ContactFirstName=driver.findElement(By.id(mbo.Call_ContactFirstName));
												Call_ContactFirstName.sendKeys(Name+FirstName);
												repfn.FnUpdateTestStepResHTML("Verify whether Contact First Name is added or not", "Contact First Name added as: "+Name+FirstName,"PASS",runManagerInfoObj);
												
												if(cnf.FnExplicitWait("ID", mbo.Call_ContactLastName,driver)){
													repfn.FnUpdateTestStepResHTML("Verify Last Name field is displayed", "Last Name field is displayed","PASS",runManagerInfoObj);
													WebElement Call_ContactLastName=driver.findElement(By.id(mbo.Call_ContactLastName));
													Call_ContactLastName.sendKeys(lastName);
													repfn.FnUpdateTestStepResHTML("Verify whether Contact Last Name is added or not", "Contact Last Name added as: "+lastName,"PASS",runManagerInfoObj);
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify Last Name field is displayed", "Last Name field is not displayed","FAIL",runManagerInfoObj);
													repfn.FnUpdateTestStepResHTML("Verify whether Contact Last Name is added or not", "Contact Last Name is not added","FAIL",runManagerInfoObj);
													blnFlag=false;
												}

												driver.manage().window().setSize(new Dimension(100, 100));
												driver.manage().window().maximize();

												if(cnf.FnExplicitWait("XPATH", mbo.Call_ContactSave,driver)){
													WebElement Call_ContactSave=driver.findElement(By.xpath(mbo.Call_ContactSave));
													repfn.FnUpdateTestStepResHTML("Verify whether Contact save option is present or not", "Contact save option is present ","PASS",runManagerInfoObj);

													if(cnf.JSClick(Call_ContactSave,driver)){
														repfn.FnUpdateTestStepResHTML("Verify whether Contact save option is clicked or not", "Contact save option is clicked ","PASS",runManagerInfoObj);

														if(cnf.FnExplicitWait("XPATH", mbo.SaveNotWorkingText,driver)){
															repfn.FnUpdateTestStepResHTML("Verify Save functionality working or not","Save functionality not working","FAIL",runManagerInfoObj);
															blnFlag=false;
															if(cnf.FnExplicitWaitFeedback("XPATH", mbo.Cancel_Button,driver))
															{
																WebElement close=driver.findElement(By.xpath(mbo.Cancel_Button));
																if(cnf.JSClick(close,driver)){
																	repfn.FnUpdateTestStepResHTML("Verify Cancel button is clicked","Cancel button is clicked","PASS",runManagerInfoObj);
																	blnFlag=false;
																	Thread.sleep(2000);
																	WebElement Confrm=driver.findElement(By.xpath(mbo.Confirm_btn));
																	System.out.println("click aftr save not working");
																	if(cnf.JSClick(Confrm,driver))
																	{
																		repfn.FnUpdateTestStepResHTML("Verify Confirm button is clicked","Confirm button is clicked","PASS",runManagerInfoObj);
																		Thread.sleep(2000);
																		driver.navigate().refresh();
																		Thread.sleep(2000);
																		//repfn.FnUpdateTestStepResHTML("Verify User is moved back to contacts page","User is moved back to contacts page","PASS",runManagerInfoObj);
																		blnFlag=false;
																	}
																	else{
																		repfn.FnUpdateTestStepResHTML("Verify Confirm button is clicked","Confirm button is not clicked","FAIL",runManagerInfoObj);
																		blnFlag=false;
																	}
																}
																else{
																	repfn.FnUpdateTestStepResHTML("Verify Cancel button is clicked","Cancel button is not clicked","FAIL",runManagerInfoObj);
																	blnFlag=false;
																}
															}
															else{
																repfn.FnUpdateTestStepResHTML("Verify Cancel button is displayed","Cancel button is not displayed","FAIL",runManagerInfoObj);
																blnFlag=false;
															}
														}
														else{
															Thread.sleep(5000);
															if(cnf.FnExplicitWait("XPATH", mbo.Call_Searchbox,driver)){
																WebElement Searchbox=driver.findElement(By.xpath(mbo.Call_Searchbox));
																Searchbox.sendKeys(Name+FirstName);
																if(cnf.FnExplicitWait("XPATH", mbo.Calllog_logList,driver)){
																	List<WebElement> ContactName=driver.findElements(By.xpath(mbo.Calllog_logList));
																	String contctName=ContactName.get(0).getText();
																	if(contctName.contains(Name+FirstName)){
																		repfn.FnUpdateTestStepResHTML("Verify whether Contact is saved or not", "Contact is saved in the list as :"+Name+FirstName,"PASS",runManagerInfoObj);
																		blnFlag=true;
																		Searchbox.clear();
																	}
																	else{
																		repfn.FnUpdateTestStepResHTML("Verify whether Contact is saved or not", "Contact is not saved in the list ","FAIL",runManagerInfoObj);
																		blnFlag=false;
																		Searchbox.clear();
																	}
																}
																else{
																	repfn.FnUpdateTestStepResHTML("Verify whether Contact is saved or not", "Contact is not saved in the list ","FAIL",runManagerInfoObj);
																	blnFlag=false;
																}
															}
															else{
																repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ","Search field is not displayed","FAIL",runManagerInfoObj);
																blnFlag=false;
															}
														}
													}
													else{
														repfn.FnUpdateTestStepResHTML("Verify whether Contact save option is clicked or not", "Contact save option is not clicked ","FAIL",runManagerInfoObj);
														blnFlag=false;
													}
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify whether Contact save option is present or not", "Contact save option is not present ","FAIL",runManagerInfoObj);
													blnFlag=false;
												}
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify First Name field is displayed", "First Name field is not displayed","FAIL",runManagerInfoObj);
												blnFlag=false;
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Create New Contact option is clicked or not", "Create New Contact is not clicked","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Create New Contact option is present", "Create New contact option is not present for: "+ContactsText,"FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Call details section is loaded", "Call details section is not loaded","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Unsaved Contact is clicked", "Unsaved Contact is not clicked","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}else{
							repfn.FnUpdateTestStepResHTML("Verify whether any Call present for unsaved Number", "No call present in Call log for unsaved Number","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}else{
						repfn.FnUpdateTestStepResHTML("Verify whether any Call Log present or not", "Call Logs are not present","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}

				catch (Exception e)
				{	
					repfn.FnUpdateTestStepResHTML("Verifying if the user is able to create new contact for calls from unsaved numbers from the call details window in the call logs page and save the changes.", " user is not able to create new contact for calls from unsaved numbers from the call details window in the call logs page and save the changes due to some exception","FAIL",runManagerInfoObj);
					blnFlag=false;
					System.err.println("Message : "+e.getMessage());
					System.err.println("Cause : "+e.getCause());
				}
				driver.navigate().refresh();
				m1.put("STEPSTATUS", blnFlag);
				System.out.println("Add to contact"+blnFlag);
				return blnFlag;
			}

			 public synchronized boolean fn_callLog_Save_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj) 
			 {
				 //boolean blnFlag=false;	
				 try{

					 if(cnf.FnExplicitWait("XPATH", mbo.Calllog_logList,driver)){
						 repfn.FnUpdateTestStepResHTML("Verify whether call logs are present or not", "Call logs are present","PASS",runManagerInfoObj);
						 List <WebElement> ContactNumber=driver.findElements(By.xpath(mbo.Calllog_logList));
						 List <WebElement> ContactNumbers=new ArrayList<WebElement>();
						 for(WebElement Contacts:ContactNumber)
						 {
							 if(Contacts.getText().startsWith("("))
							 {
								 ContactNumbers.add(Contacts);

							 }
						 }

						 if(ContactNumbers.size()>0){
							 repfn.FnUpdateTestStepResHTML("Verify whether any Unsaved number present or not", "Unsaved numbers are present","PASS",runManagerInfoObj);

							 String ContactsText=ContactNumbers.get(0).getText();	
							 if(cnf.JSClick(ContactNumbers.get(0),driver)){
								 repfn.FnUpdateTestStepResHTML("Verify Unsaved Contact is clicked or not", "Unsaved Contact is clicked","PASS",runManagerInfoObj);
								 try{

									 if(cnf.FnExplicitWait("XPATH", mbo.Calllog_Unblock,driver)){
										 repfn.FnUpdateTestStepResHTML("Verify Unblock link is displayed", "Unblock link is displayed. Hence, contact is blocked.","PASS",runManagerInfoObj);
										 WebElement Call_UnBlock=driver.findElement(By.xpath(mbo.Calllog_Unblock));
										 if(cnf.JSClick(Call_UnBlock,driver)){
											 repfn.FnUpdateTestStepResHTML("Verify Unblock link is clicked", "Unblock link is clicked","PASS",runManagerInfoObj); 
											 blnFlag=true;
										 }
										 else{
											 repfn.FnUpdateTestStepResHTML("Verify Unblock link is clicked", "Unblock link is not clicked","FAIL",runManagerInfoObj); 
											 blnFlag=false;
										 }
									 }
									 else{
										 repfn.FnUpdateTestStepResHTML("Verify Unblock link is displayed", "Unblock link is not displayed. Hence, contact is not blocked.","PASS",runManagerInfoObj);
										 blnFlag=true;
									 }


								 }
								 catch(NoSuchElementException e)
								 {
									 System.out.println("Contact is not blocked , Add contact Link is present for Contact "+ContactsText);

								 }


								 if(cnf.FnExplicitWait("XPATH", mbo.Call_CreateNewContactLink,driver)){
									 repfn.FnUpdateTestStepResHTML("Verify Create New Contact link is displayed", "Create New Contact link is displayed","PASS",runManagerInfoObj);
									 WebElement Call_CreateNewContactLink=driver.findElement(By.xpath(mbo.Call_CreateNewContactLink));
									 if(cnf.JSClick(Call_CreateNewContactLink,driver)){
										 repfn.FnUpdateTestStepResHTML("Verify Create New Contact link is clicked", "Create New Contact link is clicked","PASS",runManagerInfoObj);
										 Thread.sleep(5000);

										 if(cnf.FnExplicitWait("ID", mbo.Call_ContactFirstName,driver)){
											 repfn.FnUpdateTestStepResHTML("Verify First Name field is displayed", "First Name field is displayed","PASS",runManagerInfoObj);
											 WebElement Call_ContactFirstName=driver.findElement(By.id(mbo.Call_ContactFirstName));
											 Call_ContactFirstName.sendKeys("TestCancel");
											 repfn.FnUpdateTestStepResHTML("Check whether First name is entered ", "First name is entered:TestCancel","PASS",runManagerInfoObj);

											 driver.manage().window().setSize(new Dimension(100, 100));
											 driver.manage().window().maximize();

											 if(cnf.FnExplicitWait("XPATH", mbo.AddToContacts_Cancel,driver)){
												 repfn.FnUpdateTestStepResHTML("Check whether Cancel link is present or not ", " Cancel link is present","PASS",runManagerInfoObj);
												 WebElement AddToContacts_Cancel=driver.findElement(By.xpath(mbo.AddToContacts_Cancel));
												 if(cnf.JSClick(AddToContacts_Cancel,driver)){
													 repfn.FnUpdateTestStepResHTML("Check whether Cancel link is clicked ", " Cancel link is clicked","PASS",runManagerInfoObj);
													 if(cnf.FnExplicitWait("XPATH", mbo.AddToContacts_ConfirmPopup,driver)){
														 repfn.FnUpdateTestStepResHTML("Check whether Cancel confirmation popup is present or not ", " Cancel confirmation popup is present ","PASS",runManagerInfoObj);
														 WebElement AddToContacts_Confirm=driver.findElement(By.xpath(mbo.AddToContacts_ConfirmPopup));
														 if(cnf.JSClick(AddToContacts_Confirm,driver)){
															 repfn.FnUpdateTestStepResHTML("Check whether Confirm Button is Clicked ", " Confirm button is Clicked","PASS",runManagerInfoObj);

															 driver.navigate().refresh();

															 if(cnf.FnExplicitWait("XPATH", mbo.Call_Searchbox,driver)){
																 repfn.FnUpdateTestStepResHTML("Check whether search bar is present or not ", " Search bar is  present ","PASS",runManagerInfoObj);
																 WebElement Searchbox=driver.findElement(By.xpath(mbo.Call_Searchbox));
																 Searchbox.sendKeys(ContactsText);
																 repfn.FnUpdateTestStepResHTML("Verify Search Text is entered in Search bar", " Search Text is entered in Search bar","PASS",runManagerInfoObj);
																 if(cnf.FnExplicitWait("XPATH", mbo.Calllog_logList,driver)){
																	 repfn.FnUpdateTestStepResHTML("Verify whether call log present or not after searching", "Call logs are present after searching ","PASS",runManagerInfoObj);
																	 List<WebElement> ContactName=driver.findElements(By.xpath(mbo.Calllog_logList));
																	 WebElement ContactNameOne = ContactName.get(0);
																	 String contctName=ContactNameOne.getText();
																	 if(contctName.contains(ContactsText)){
																		 repfn.FnUpdateTestStepResHTML("Verify whether Contact is not saved", "Contact is not saved as unsaved contact as present in list : "+ContactsText,"PASS",runManagerInfoObj);
																		 blnFlag=true;
																	 }
																	 else{
																		 repfn.FnUpdateTestStepResHTML("Verify whether Contact is not saved", "Contact is saved in the list ","FAIL",runManagerInfoObj);
																		 blnFlag=false;
																	 }
																 }
																 else{
																	 repfn.FnUpdateTestStepResHTML("Verify whether call log present or not after searching", "Call logs are not present after searching ","FAIL",runManagerInfoObj);
																	 blnFlag=false;
																 }
															 }
															 else{
																 repfn.FnUpdateTestStepResHTML("Check whether search bar is present or not ", " Search bar is not present ","FAIL",runManagerInfoObj);
																 blnFlag=false;
															 }
														 }
														 else{
															 repfn.FnUpdateTestStepResHTML("Check whether Confirm Button is Clicked ", " Confirm button is not Clicked","FAIL",runManagerInfoObj);
															 blnFlag=false;
														 }
													 }
												 }
												 else{
													 repfn.FnUpdateTestStepResHTML("Check whether Cancel link is clicked ", " Cancel link is not clicked","FAIL",runManagerInfoObj);
													 blnFlag=false;
												 }
											 }
											 else{
												 repfn.FnUpdateTestStepResHTML("Check whether Cancel link is present or not ", " Cancel link is not present","FAIL",runManagerInfoObj);
												 blnFlag=false;
											 }									 
										 }
										 else{
											 repfn.FnUpdateTestStepResHTML("Verify First Name field is displayed", "First Name field is not displayed","FAIL",runManagerInfoObj);
											 blnFlag=false;
										 }
									 }
									 else{
										 repfn.FnUpdateTestStepResHTML("Verify Create New Contact link is clicked", "Create New Contact link is not clicked","FAIL",runManagerInfoObj);
										 blnFlag=false;
									 }
								 }
								 else{
									 repfn.FnUpdateTestStepResHTML("Verify Create New Contact link is displayed", "Create New Contact link is not displayed","FAIL",runManagerInfoObj);
									 blnFlag=false;
								 }

							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify Unsaved Contact is clicked or not", "Unsaved Contact is not clicked","FAIL",runManagerInfoObj);
								 blnFlag=false;
							 }

						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify whether any Unsaved number present or not", "Unsaved numbers are not present","FAIL",runManagerInfoObj);
							 blnFlag=false;
						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify whether call logs are present or not", "Call logs are not present","FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }

				 catch (Exception e)

				 {	
					 repfn.FnUpdateTestStepResHTML("Verifying if the user is able to create new contact for calls from unsaved numbers from the call details window in the call logs page and discard the changes.", " user is not able to create new contact for calls from unsaved numbers from the call details window in the call logs page and discard the changes due to some exception","FAIL",runManagerInfoObj);
					 blnFlag=false;
					 System.err.println("Message : "+e.getMessage());
					 System.err.println("Cause : "+e.getCause());

				 }
				 driver.navigate().refresh();
				 m1.put("STEPSTATUS", blnFlag);
				 System.out.println("Add to contact"+blnFlag);
				 return blnFlag;
			 }
			 public synchronized boolean FnCallLog_SearchBar(WebDriver driver, RunManagerInfo runManagerInfoObj)
			 {
				 try
				 {
					 //Presence of Search bar
					 if(cnf.FnExplicitWait("XPATH", mbo.CallLog_SearchBar,driver)){
						 repfn.FnUpdateTestStepResHTML("Verify the presence of search bar in call log", "Search bar is present in call log section","PASS",runManagerInfoObj);
						 WebElement SearchBar= driver.findElement(By.xpath(mbo.CallLog_SearchBar));

						 //Presence of search icon(magnifying glass) in Search bar
						 if(cnf.FnExplicitWait("XPATH", mbo.CallLog_SearchIcon_MagnifyingGlass,driver)){
							 repfn.FnUpdateTestStepResHTML("Verify the presence of search icon in search bar", "Search icon is present in search bar","PASS",runManagerInfoObj);

							 //Presence of default text(search) in search bar
							 if(SearchBar.getAttribute("placeholder").equals("Search"))
							 {
								 System.out.println(SearchBar.getAttribute("placeholder"));
								 repfn.FnUpdateTestStepResHTML("Verify the presence of default text 'Search' in search bar", "Default text 'Search' is present in search bar","PASS",runManagerInfoObj);
								 blnFlag=true;  
							 }
							 else
							 {
								 repfn.FnUpdateTestStepResHTML("Verify the presence of default text 'Search' in search bar", "Default text 'Search' is not present in search bar","FAIL",runManagerInfoObj);
								 blnFlag=false;  
							 }

						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify the presence of search icon in search bar", "Search icon is not present in search bar","FAIL",runManagerInfoObj);
							 blnFlag = false;
						 }

					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify the presence of search bar in call log", "Search bar is not present in call log section","FAIL",runManagerInfoObj);
						 blnFlag = false;
					 }
				 }
				 catch(Exception e)
				 {
					 repfn.FnUpdateTestStepResHTML("Verify the presence of search bar in call log", "Search bar is not present in call log section due to some exception.","FAIL",runManagerInfoObj);
					 blnFlag = false;
					 System.err.println("Message : "+e.getMessage());
					 System.err.println("Cause : "+e.getCause());

				 }
				 m1.put("STEPSTATUS", blnFlag);
				 return blnFlag;

			 }
			 
			 
			 public synchronized boolean FnCallLog_AllFilter(WebDriver driver, RunManagerInfo runManagerInfoObj)
			 {
				 try
				 {
					//Presence of All filter
					 if(cnf.FnExplicitWait("XPATH", mbo.CallLog_AllFilter,driver)){
						 repfn.FnUpdateTestStepResHTML("Verify the presence of All filter near Search bar", "All filter is present near search bar","PASS",runManagerInfoObj);
						 WebElement AllFilter=driver.findElement(By.xpath(mbo.CallLog_AllFilter));
						 if(cnf.JSClick(AllFilter,driver)){
							 repfn.FnUpdateTestStepResHTML("Verify All filter is clicked", "All filter is clicked","PASS",runManagerInfoObj);
							 
							//Dropdown of All filter options
							 if(cnf.FnExplicitWait("XPATH",mbo.CallLog_AllFilter_Dropdown,driver)){
								 repfn.FnUpdateTestStepResHTML("Verify All Filter Drop-down is displayed", "All Filter Drop-down is displayed","PASS",runManagerInfoObj);
								 List<WebElement> AllFilterList = driver.findElements(By.xpath(mbo.CallLog_AllFilter_Dropdown_Options));
								 System.out.println("All filter contains"+" "+AllFilterList.size()+" "+"elements");	
								 for( int i=0; i<AllFilterList.size();i++)
								 {

									 repfn.FnUpdateTestStepResHTML("Verify All filter options", "All filter option is: "+AllFilterList.get(i).getAttribute("innerHTML"),"PASS",runManagerInfoObj);

									 //Select All option from All filter drodpown
									 if(AllFilterList.get(i).getAttribute("innerHTML").contains("All"))
									 {
										 cnf.JSClick(AllFilterList.get(i),driver);
										 repfn.FnUpdateTestStepResHTML("Verify All option is clicked under All filter", "All option is clicked under All filter","PASS",runManagerInfoObj);
										 blnFlag=true;
										 //Verify the All option is selected
										 if(AllFilter.getText().equals("All"))
										 {
											 repfn.FnUpdateTestStepResHTML("Verify All option is selected under All filter", "All option is selected under All filter","PASS",runManagerInfoObj);
											 blnFlag=true; 
										 }
										 break;
									 }
									 else
									 {
										 repfn.FnUpdateTestStepResHTML("Verify Missed option is available under All filter", "Missed option is available under All filter","FAIL",runManagerInfoObj);
										 blnFlag=false;
									 }
								 }
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify All Filter Drop-down is displayed", "All Filter Drop-down is not displayed","FAIL",runManagerInfoObj);
								 blnFlag = false;
							 }
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify All filter is clicked", "All filter is not clicked","FAIL",runManagerInfoObj);
							 blnFlag = false;
						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify the presence of All filter near Search bar", "All filter is not present near search bar","FAIL",runManagerInfoObj);
						 blnFlag = false;
					 }
					 
				 }
				 catch(Exception e)
				 {
					 repfn.FnUpdateTestStepResHTML("Verify the presence of All filter near Search bar", "All filter is not present near search bar and not clicked due to some exception.","FAIL",runManagerInfoObj);
					 blnFlag = false;
					 System.err.println("Message : "+e.getMessage());
					 System.err.println("Cause : "+e.getCause());

				 }
				 m1.put("STEPSTATUS", blnFlag);
				 return blnFlag;
			 }
			 public synchronized boolean fnSearchByLastName(WebDriver driver, RunManagerInfo runManagerInfoObj) throws InterruptedException {
					
					try
					{
						 if(cnf.FnExplicitWait("XPATH", mbo.CallLog_SearchBar,driver)){
							 repfn.FnUpdateTestStepResHTML("Verify Search bar is displayed", "Search bar is displayed","PASS",runManagerInfoObj);
							 WebElement SearchBar= driver.findElement(By.xpath(mbo.CallLog_SearchBar));
							 SearchBar.clear();
							 SearchBar.sendKeys("Lisa");
							 repfn.FnUpdateTestStepResHTML("Verify text is entered in Search field", "Text is entered in Search field","PASS",runManagerInfoObj);
							 if(cnf.FnExplicitWait("XPATH", mbo.CallLog_SearchBar_XIcon,driver)){
								 WebElement clearIcon= driver.findElement(By.xpath(mbo.CallLog_SearchBar_XIcon));
								 repfn.FnUpdateTestStepResHTML("Verify the presence of 'x' icon when user puts focus on the search field ", "'x' icon is present when user puts focus on the search field","PASS",runManagerInfoObj);
								 if(cnf.JSClick(clearIcon,driver)){
									 repfn.FnUpdateTestStepResHTML("Verify 'X' option is clicked to clear the Search field", "'X' option is clicked to clear the Search field","PASS",runManagerInfoObj);
									 if(SearchBar.getAttribute("textContent").equalsIgnoreCase("")){
										 repfn.FnUpdateTestStepResHTML("Verify Search text is cleared", "Search text is cleared","PASS",runManagerInfoObj); 

										 if(cnf.FnExplicitWait("XPATH", mbo.Savedcontacts,driver)){
											 repfn.FnUpdateTestStepResHTML("Verify Call Log List is displayed", "Call Log List is displayed","PASS",runManagerInfoObj);
											 List <WebElement> ContactNumber=driver.findElements(By.xpath(mbo.Savedcontacts));  
											 List <WebElement> ContactNumbers=new ArrayList<WebElement>(); 

											 for(WebElement Contact:ContactNumber){
												 String Contacts=Contact.getText();
												 if(!(Contacts.contains("Unknown") || Contacts.contains("(")))
												 {
													 ContactNumbers.add(Contact);
												 }					
											 }
											 
											 if(ContactNumbers.size() > 0){
												 repfn.FnUpdateTestStepResHTML("Verify if Saved contacts exist in the Call Log List", "Saved contacts exist in the Call Log List ","PASS",runManagerInfoObj);
												 List <WebElement> lastNameList=new ArrayList<WebElement>(); 
												 
												 for(WebElement we:ContactNumbers){
													 String[] name=we.getText().split(" ");
													 String lname = name[1];
													 if(!(lname.isEmpty()))
													 {
														 lastNameList.add(we);
													 }					
												 }
												 									 
												 if(lastNameList.size() > 0){
													 repfn.FnUpdateTestStepResHTML("Verify if Saved contacts with Last Name exist in the Call Log List", "Saved contacts with Last Name exist in the Call Log List ","PASS",runManagerInfoObj);
													 String[] lastName1 = lastNameList.get(0).getText().split(" ");
													 String lastName = lastName1[1];
													 
													 SearchBar.clear();
													 SearchBar.sendKeys(lastName);
													 repfn.FnUpdateTestStepResHTML("Verify Last Name is entered in Search field", "Last Name is entered in Search field: "+lastName,"PASS",runManagerInfoObj);
													 
													 if(cnf.FnExplicitWait("XPATH", mbo.CallLog_AllFilter_FN_FilteredList,driver)){
														 List<WebElement> FilteredList =driver.findElements(By.xpath(mbo.CallLog_AllFilter_FN_FilteredList));
														 for(int j=0; j<FilteredList.size();j++)
														 {
															 String filteredName=driver.findElements(By.xpath(mbo.CallLog_AllFilter_FN_FilteredListName)).get(j).getText();
															 if(filteredName.contains(lastName)){
																 blnFlag=true; 
																 break;
															 }
															 else{
																 blnFlag=false;
																 break;
															 }
														 }
														 if(blnFlag){
															 repfn.FnUpdateTestStepResHTML("Verify the filtered call logs are the search results of the entered Last Name","Filtered call logs are the search results of the entered Last Name: "+lastName,"PASS",runManagerInfoObj);
															 blnFlag=true;
														 }
														 else{
															 repfn.FnUpdateTestStepResHTML("Verify the filtered call logs are the search results of the entered Last Name","Filtered call logs are not the search results of the entered Last Name: "+lastName,"FAIL",runManagerInfoObj);
															 blnFlag=false;
														 }
													 }
													 else{
														 repfn.FnUpdateTestStepResHTML("Verify Call log is displayed after searching with Last Name", "Call log is not displayed after searching with Last Name","FAIL",runManagerInfoObj);
														 blnFlag=false;
													 }
												 }
												 else{
													 repfn.FnUpdateTestStepResHTML("Verify if Saved contacts with Last Name exist in the Call Log List", "Saved contacts with Last Name does not exist in the Call Log List. Contact needs to be updated ","PASS",runManagerInfoObj);
													 boolean blnFlag1 = Fn_Savedcontact_Click(driver,runManagerInfoObj);
													 if(blnFlag1){
														 boolean blnFlag2 = Fn_CallLog_EditClick(driver,runManagerInfoObj);
														 if(blnFlag2){
															 boolean blnFlag3 = Fn_CallLog_FirstName_LastNameEdit(driver,runManagerInfoObj);
															 if(blnFlag3){
																 boolean blnFlag4 = fnSearchByLastName(driver,runManagerInfoObj);
																 if(blnFlag4){
																	 blnFlag=true;
																 }
																 else{
																	 blnFlag=false;
																 }
															 }
															 else{
																 repfn.FnUpdateTestStepResHTML("Verify Contact Name is modified ","Contact Name is not modified" ,"FAIL",runManagerInfoObj);
																 blnFlag=false;
															 }
														 }
														 else{
															 repfn.FnUpdateTestStepResHTML("Verify Edit Contact form is displayed", "Edit Contact form is not displayed","FAIL",runManagerInfoObj);
															 blnFlag=false;
														 }
													 }
													 else{
														 repfn.FnUpdateTestStepResHTML("Verify whether Saved Contact is clicked or not", "Saved Contact is not clicked","FAIL",runManagerInfoObj);
														 blnFlag=false;
													 }
												 }
											 }
											 else{
												 repfn.FnUpdateTestStepResHTML("Verify if Saved contacts exist in the Call Log List", "Saved contacts does not exist in the Call Log List ","PASS",runManagerInfoObj);
												 boolean blnFlag1 = fnUnsavedContactsSave(driver,runManagerInfoObj);								 
												 if(blnFlag1){
													 boolean blnFlag2 = fnSearchByLastName(driver,runManagerInfoObj);
													 if(blnFlag2){
														 blnFlag=true;
													 }
													 else{
														 blnFlag=false;
													 }
												 }
												 else{
													 repfn.FnUpdateTestStepResHTML("Verify whether Contact is saved or not", "Contact is not saved in the list ","FAIL",runManagerInfoObj);
													 blnFlag=false;
												 }
											 }
										 }
										 else{
											 repfn.FnUpdateTestStepResHTML("Verify Call Log List is displayed", "Call Log List is not displayed","FAIL",runManagerInfoObj);
											 blnFlag=false;
										 }
									 }
									 else{
										 repfn.FnUpdateTestStepResHTML("Verify Search text is cleared", "Search text is not cleared","FAIL",runManagerInfoObj);
										 blnFlag=false;
									 }
								 }
								 else{
									 repfn.FnUpdateTestStepResHTML("Verify 'X' option is clicked to clear the Search field", "'X' option is not clicked to clear the Search field","FAIL",runManagerInfoObj);
									 blnFlag=false;
								 }
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify the presence of 'x' icon when user puts focus on the search field ", "'x' icon is absent when user puts focus on the search field","FAIL",runManagerInfoObj);
								 blnFlag=false;
							 }
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify Search bar is displayed", "Search bar is not displayed","FAIL",runManagerInfoObj);
							 blnFlag=false;
						 }
					 
					}
					
					catch(Exception e)
					{
						repfn.FnUpdateTestStepResHTML("Verify if search by last name is successfull"," Search by last name is not successfull due to some exception", "FAIL",runManagerInfoObj);
						System.err.println("Message : "+e.getMessage());
						System.err.println("Cause : "+e.getCause());
						blnFlag=false;
					}
					m1.put("STEPSTATUS", blnFlag);
					return blnFlag;

				}


			 @SuppressWarnings("static-access")
			public synchronized boolean fnSearchByPhoneNumber(WebDriver driver, RunManagerInfo runManagerInfoObj) {
					
					try
					{
						 if(cnf.FnExplicitWait("XPATH", mbo.CallLog_SearchBar,driver)){
							 repfn.FnUpdateTestStepResHTML("Verify Search bar is displayed", "Search bar is displayed","PASS",runManagerInfoObj);
							 WebElement SearchBar= driver.findElement(By.xpath(mbo.CallLog_SearchBar));
							 SearchBar.clear();
							 SearchBar.sendKeys("Lisa");
							 repfn.FnUpdateTestStepResHTML("Verify text is entered in Search field", "Text is entered in Search field","PASS",runManagerInfoObj);
							 if(cnf.FnExplicitWait("XPATH", mbo.CallLog_SearchBar_XIcon,driver)){
								 WebElement clearIcon= driver.findElement(By.xpath(mbo.CallLog_SearchBar_XIcon));
								 repfn.FnUpdateTestStepResHTML("Verify the presence of 'x' icon when user puts focus on the search field ", "'x' icon is present when user puts focus on the search field","PASS",runManagerInfoObj);
								 if(cnf.JSClick(clearIcon,driver)){
									 repfn.FnUpdateTestStepResHTML("Verify 'X' option is clicked to clear the Search field", "'X' option is clicked to clear the Search field","PASS",runManagerInfoObj);
									 if(SearchBar.getAttribute("textContent").equalsIgnoreCase("")){
										 repfn.FnUpdateTestStepResHTML("Verify Search text is cleared", "Search text is cleared","PASS",runManagerInfoObj); 

										 if(cnf.FnExplicitWait("XPATH", mbo.Savedcontacts,driver)){
											 repfn.FnUpdateTestStepResHTML("Verify Call Log List is displayed", "Call Log List is displayed","PASS",runManagerInfoObj);
											 List <WebElement> ContactNumber=driver.findElements(By.xpath(mbo.Savedcontacts));  
											 List <WebElement> ContactNumbers=new ArrayList<WebElement>(); 

											 for(WebElement Contact:ContactNumber){
												 String Contacts=Contact.getText();
												 if(Contacts.startsWith("(") || Contacts.matches("[0-9]+"))
												 {
													 ContactNumbers.add(Contact);
												 }					
											 }
											 
											 if(ContactNumbers.size() > 0){
												 repfn.FnUpdateTestStepResHTML("Verify if UnSaved contacts exist in the Call Log List", "UnSaved contacts exist in the Call Log List ","PASS",runManagerInfoObj);
												 String phoneNumber = ContactNumbers.get(0).getText();
												 
												 SearchBar.clear();
												 SearchBar.sendKeys(phoneNumber);
												 repfn.FnUpdateTestStepResHTML("Verify Phone Number is entered in Search field", "Phone Number is entered in Search field: "+phoneNumber,"PASS",runManagerInfoObj);
												 
												 if(cnf.FnExplicitWait("XPATH", mbo.CallLog_AllFilter_FN_FilteredList,driver)){
													 List<WebElement> FilteredList =driver.findElements(By.xpath(mbo.CallLog_AllFilter_FN_FilteredList));
													 for(int j=0; j<FilteredList.size();j++)
													 {
														 String filteredName=driver.findElements(By.xpath(mbo.CallLog_AllFilter_FN_FilteredListName)).get(j).getText();
														 if(filteredName.contains(phoneNumber)){
															 blnFlag=true; 
															 break;
														 }
														 else{
															 blnFlag=false;
															 break;
														 }
													 }
													 if(blnFlag){
														 repfn.FnUpdateTestStepResHTML("Verify the filtered call logs are the search results of the entered Phone Number","Filtered call logs are the search results of the entered Phone Number: "+phoneNumber,"PASS",runManagerInfoObj);
														 blnFlag=true;
													 }
													 else{
														 repfn.FnUpdateTestStepResHTML("Verify the filtered call logs are the search results of the entered Phone Number","Filtered call logs are not the search results of the entered Phone Number: "+phoneNumber,"FAIL",runManagerInfoObj);
														 blnFlag=false;
													 }
												 }
												 else{
													 repfn.FnUpdateTestStepResHTML("Verify Call log is displayed after searching with Phone Number", "Call log is not displayed after searching with Phone Number","FAIL",runManagerInfoObj);
													 blnFlag=false;
												 }
											 }
											 else{
												 repfn.FnUpdateTestStepResHTML("Verify if UnSaved contacts exist in the Call Log List", "UnSaved contacts does not exist in the Call Log List ","FAIL",runManagerInfoObj);
												 blnFlag=false;
											 }
										 }
										 else{
											 repfn.FnUpdateTestStepResHTML("Verify Call Log List is displayed", "Call Log List is not displayed","FAIL",runManagerInfoObj);
											 blnFlag=false;
										 }
									 }
									 else{
										 repfn.FnUpdateTestStepResHTML("Verify Search text is cleared", "Search text is not cleared","FAIL",runManagerInfoObj);
										 blnFlag=false;
									 }
								 }
								 else{
									 repfn.FnUpdateTestStepResHTML("Verify 'X' option is clicked to clear the Search field", "'X' option is not clicked to clear the Search field","FAIL",runManagerInfoObj);
									 blnFlag=false;
								 }
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify the presence of 'x' icon when user puts focus on the search field ", "'x' icon is absent when user puts focus on the search field","FAIL",runManagerInfoObj);
								 blnFlag=false;
							 }
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify Search bar is displayed", "Search bar is not displayed","FAIL",runManagerInfoObj);
							 blnFlag=false;
						 }
					 
					}
					
					catch(Exception e)
					{
						repfn.FnUpdateTestStepResHTML("Verify if search by phone number is successfull "," Search by phone number is not successfull due to some exception", "FAIL",runManagerInfoObj);
						System.err.println("Message : "+e.getMessage());
						System.err.println("Cause : "+e.getCause());
					}
					m1.put("STEPSTATUS", blnFlag);
					return blnFlag;

				}


			 public synchronized boolean Fn_AddToExistingContacts(WebDriver driver, RunManagerInfo runManagerInfoObj)
			 {

				 String PhoneNumber = "";
				 try
				 { 
					 if(cnf.FnExplicitWait("XPATH", mbo.Calllog_logList,driver)){
						 repfn.FnUpdateTestStepResHTML("Verify whether call logs are present or not", "Call logs are present","PASS",runManagerInfoObj);
						 List <WebElement> ContactNumber=driver.findElements(By.xpath(mbo.Calllog_logList));
						 List <WebElement> ContactNumbers=new ArrayList<WebElement>();
						 if(ContactNumber.size()>0){
							 for(WebElement Contacts:ContactNumber)
							 {
								 if(Contacts.getText().startsWith("(") || Contacts.getText().matches("[0-9]+"))
								 {
									 ContactNumbers.add(Contacts);

								 }
							 }

							 if(ContactNumbers.size()>0){
								 repfn.FnUpdateTestStepResHTML("Verify whether any Unsaved number present or not", "Unsaved numbers are present","PASS",runManagerInfoObj);
								 PhoneNumber=ContactNumbers.get(0).getText();
								 if(cnf.JSClick(ContactNumbers.get(0),driver)){
									 repfn.FnUpdateTestStepResHTML("Verify Unsaved Contact is clicked or not", "Unsaved Contact is clicked","PASS",runManagerInfoObj);
									 try{

										 if(cnf.FnExplicitWait("XPATH", mbo.Calllog_Unblock,driver)){
											 repfn.FnUpdateTestStepResHTML("Verify Unblock link is displayed", "Unblock link is displayed. Hence, contact is blocked.","PASS",runManagerInfoObj);
											 WebElement Call_UnBlock=driver.findElement(By.xpath(mbo.Calllog_Unblock));
											 if(cnf.JSClick(Call_UnBlock,driver)){
												 repfn.FnUpdateTestStepResHTML("Verify Unblock link is clicked", "Unblock link is clicked","PASS",runManagerInfoObj); 
												 blnFlag=true;
											 }
											 else{
												 repfn.FnUpdateTestStepResHTML("Verify Unblock link is clicked", "Unblock link is not clicked","FAIL",runManagerInfoObj); 
												 blnFlag=false;
											 }
										 }
										 else{
											 repfn.FnUpdateTestStepResHTML("Verify Unblock link is displayed", "Unblock link is not displayed. Hence, contact is not blocked.","PASS",runManagerInfoObj);
											 blnFlag=true;
										 }


									 }
									 catch(NoSuchElementException e)
									 {
										 System.out.println("Contact is not blocked , Add contact Link is present for Contact"+PhoneNumber);

									 }

									 Thread.sleep(4000);
									 if(cnf.FnExplicitWait("XPATH", mbo.AddToExistingContacts,driver)){
										 repfn.FnUpdateTestStepResHTML("Verify Add To Contacts link is displayed", "Add To Contacts link is displayed","PASS",runManagerInfoObj);
										 WebElement AddToExistingContacts=driver.findElement(By.xpath(mbo.AddToExistingContacts));
										 if(cnf.JSClick(AddToExistingContacts,driver)){
											 repfn.FnUpdateTestStepResHTML("Verify Add To Contacts link is clicked", "Add To Contacts link is clicked","PASS",runManagerInfoObj);
											 if(cnf.FnExplicitWait("XPATH", mbo.Search,driver)){
												 repfn.FnUpdateTestStepResHTML("Verify Whether Search field is getting displayed", "Search field is getting displayed pass","PASS",runManagerInfoObj); 
												 blnFlag = true;
											 }
											 else
											 {
												 repfn.FnUpdateTestStepResHTML("Verify Whether Search field is getting displayed", "Search field is not getting displayed pass","FAIL",runManagerInfoObj);   
												 blnFlag = false;
											 }

											 if(cnf.FnExplicitWait("XPATH", mbo.Search_Icon,driver)){
												 repfn.FnUpdateTestStepResHTML("Verify Whether Search Icon is getting displayed", "Search Icon is getting displayed pass","PASS",runManagerInfoObj);  
												 blnFlag = true;
											 }
											 else
											 {
												 repfn.FnUpdateTestStepResHTML("Verify Whether Search Icon is getting displayed", "Search Icon is not getting displayed pass","FAIL",runManagerInfoObj); 
												 blnFlag = false;
											 }

											 if(cnf.FnExplicitWait("XPATH", mbo.ExistingContactList,driver)){
												 repfn.FnUpdateTestStepResHTML("Verify Whether Contact list is displayed", "Contact list is displayed","PASS",runManagerInfoObj);  
												 List <WebElement> Existing_List=driver.findElements(By.xpath(mbo.ExistingContactList));
												 if(Existing_List.size()>0){
													 if(cnf.JSClick(Existing_List.get(0),driver)){
														 repfn.FnUpdateTestStepResHTML("Verify Whether a Contact is clicked", "A Contact is clicked","PASS",runManagerInfoObj); 
														 if(cnf.FnExplicitWait("XPATH", mbo.Populated_Number,driver)){
															 repfn.FnUpdateTestStepResHTML("Verify whether Phone number field is present in details section", "Phone number field is present in details section ","PASS",runManagerInfoObj);
															 WebElement Number=driver.findElement(By.xpath(mbo.Populated_Number));
															 String Populated_Number= Number.getText();
															 if(PhoneNumber.contains(Populated_Number))
															 {
																 repfn.FnUpdateTestStepResHTML("Verify Whether Selected Number is pre-populated", "Selected Number is pre-populated:"+Populated_Number+":"+PhoneNumber,"PASS",runManagerInfoObj);
																 blnFlag = true;
															 }
															 else
															 {
																 repfn.FnUpdateTestStepResHTML("Verify Whether Selected Number is pre-populated"+PhoneNumber, "Selected Number is not getting pre-populated:"+Populated_Number+":"+PhoneNumber,"FAIL",runManagerInfoObj);
																 blnFlag = false;	 
															 } 

														 }
														 else{
															 repfn.FnUpdateTestStepResHTML("Verify whether Phone number field is present in details section", "Phone number field is not present in details section ","FAIL",runManagerInfoObj);
															 blnFlag=false;
														 }


														 if(cnf.FnExplicitWait("XPATH", mbo.Cancel_Button,driver)){
															 repfn.FnUpdateTestStepResHTML("Verify whether Cancel option present or not", "Cancel option is present ","PASS",runManagerInfoObj);
															 WebElement Cancel=driver.findElement(By.xpath(mbo.Cancel_Button));
															 if(cnf.JSClick(Cancel,driver)){
																 repfn.FnUpdateTestStepResHTML("Verify Whether Cancel link is clicked", "Cancel link is clicked","PASS",runManagerInfoObj);
																 if(cnf.FnExplicitWait("XPATH", mbo.Confirm_Popup,driver)){
																	 repfn.FnUpdateTestStepResHTML("Verify whether Cancel confirmation popup present or not", "Cancel confirmation popup present ","PASS",runManagerInfoObj);
																	 WebElement Confirm_Cancel=driver.findElement(By.xpath(mbo.Confirm_Popup));
																	 if(cnf.JSClick(Confirm_Cancel,driver)){
																		 repfn.FnUpdateTestStepResHTML("Verify Whether Confirm button is clicked in the popup", "Confirm button is clicked","PASS",runManagerInfoObj);
																		 blnFlag=true;
																	 }
																	 else{
																		 repfn.FnUpdateTestStepResHTML("Verify Whether Confirm button is clicked in the popup", "Confirm button is not clicked","FAIL",runManagerInfoObj);
																		 blnFlag=false;
																	 }
																 }
																 else{
																	 repfn.FnUpdateTestStepResHTML("Verify whether Cancel confirmation popup present or not", "Cancel confirmation popup not present ","FAIL",runManagerInfoObj);
																	 blnFlag=false;
																 }
															 }
															 else{
																 repfn.FnUpdateTestStepResHTML("Verify Whether Cancel link is clicked", "Cancel link is not clicked","FAIL",runManagerInfoObj);
																 blnFlag=false;
															 }
														 }
														 else{
															 repfn.FnUpdateTestStepResHTML("Verify whether Cancel option present or not", "Cancel option is not present ","FAIL",runManagerInfoObj);
															 blnFlag=false;
														 }
													 }
													 else{
														 repfn.FnUpdateTestStepResHTML("Verify Whether a Contact is clicked", "A Contact is not clicked","FAIL",runManagerInfoObj);
														 blnFlag = false;
													 }
												 }
												 else{
													 repfn.FnUpdateTestStepResHTML("Verify Whether Contact list is displayed", "Contact list is not displayed","FAIL",runManagerInfoObj);
													 blnFlag = false;
												 }
											 }
											 else{
												 repfn.FnUpdateTestStepResHTML("Verify Whether Contact list is displayed", "Contact list is not displayed","FAIL",runManagerInfoObj);
												 blnFlag = false;
											 }

										 }
										 else{
											 repfn.FnUpdateTestStepResHTML("Verify Add To Contacts link is clicked", "Add To Contacts link is not clicked","FAIL",runManagerInfoObj);
											 blnFlag=false;
										 }
									 }
									 else{
										 repfn.FnUpdateTestStepResHTML("Verify Add To Contacts link is displayed", "Add To Contacts link is not displayed","FAIL",runManagerInfoObj);
										 blnFlag=false;
									 }

								 }
								 else{
									 repfn.FnUpdateTestStepResHTML("Verify Unsaved Contact is clicked or not", "Unsaved Contact is not clicked","FAIL",runManagerInfoObj);
									 blnFlag=false;
								 }
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify whether any Unsaved number present or not", "Unsaved numbers are not present","FAIL",runManagerInfoObj);
								 blnFlag=false;
							 }
						 }
						 Thread.sleep(2000);
						 driver.navigate().refresh();

						 if(cnf.FnExplicitWait("XPATH", mbo.Call_Searchbox,driver)){
							 repfn.FnUpdateTestStepResHTML("Verify whether Search bar present or not", "Search bar is present ","PASS",runManagerInfoObj);
							 WebElement Searchbox=driver.findElement(By.xpath(mbo.Call_Searchbox));
							 Searchbox.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),PhoneNumber);
							 if(cnf.FnExplicitWait("XPATH", mbo.Calllog_logList,driver)){
								 repfn.FnUpdateTestStepResHTML("Verify whether call list present or not after searching ", "call list present after searching ","PASS",runManagerInfoObj);
								 List<WebElement> ContactName=driver.findElements(By.xpath(mbo.Calllog_logList));
								 String contctName=ContactName.get(0).getText();
								 if(contctName.contains(PhoneNumber)){
									 repfn.FnUpdateTestStepResHTML("Verify whether Contact is saved or not", "Contact is not saved to the existing contact as contact present in call list as:"+PhoneNumber,"PASS",runManagerInfoObj);
									 blnFlag=true;
								 }
								 else{
									 repfn.FnUpdateTestStepResHTML("Verify whether Contact is saved or not", "Contact is saved in the list ","FAIL",runManagerInfoObj);
									 blnFlag=false;
								 }
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify whether call list present or not after searching ", "Call list not present after searching  ","FAIL",runManagerInfoObj);
								 blnFlag=false;
							 }
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify whether Search bar present or not", "Search bar is not present ","FAIL",runManagerInfoObj);
							 blnFlag=false;
						 }

					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify whether call logs are present or not", "Call logs are not present","FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
				 catch(Exception e)
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if the user is able to cancel the unsaved contact added to Existing contacts in call log page", 
							 "user is not able to cancel the unsaved contact added to Existing contacts in call log page due to some exception.","FAIL",runManagerInfoObj);  
					 blnFlag =false;
					 System.err.println("Message : "+e.getMessage());
					 System.err.println("Cause : "+e.getCause());

				 }
				 driver.navigate().refresh();
				 return blnFlag;
			 }
			 public synchronized boolean FnIncomingCalls(WebDriver driver, RunManagerInfo runManagerInfoObj)
				{
					try
					{	
						if(cnf.FnExplicitWait("XPATH", mbo.IncomingCallsList,driver)){
							List<WebElement> ReceivedCall=driver.findElements(By.xpath(mbo.IncomingCallsList));
							repfn.FnUpdateTestStepResHTML("Verify if Incoming Calls are displayed", "Incoming Calls are displayed. No of incoming calls displayed: "+ReceivedCall.size(), "PASS",runManagerInfoObj);
							blnFlag=true;

						}else{
							repfn.FnUpdateTestStepResHTML("Verify if Incoming Calls are displayed", "Incoming Calls are not displayed", "FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}

					catch (Exception e)
					{
						System.err.println("Message : "+e.getMessage());
						System.err.println("Cause : "+e.getCause());
						repfn.FnUpdateTestStepResHTML("verify if Incoming Calls are displayed", "Incoming Calls are not displayed due to some exception", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					m1.put("STEPSTATUS", blnFlag);
					return blnFlag;
				}
				
				public synchronized boolean FnMissedCalls(WebDriver driver, RunManagerInfo runManagerInfoObj)
				{
					try
					{	
						if(cnf.FnExplicitWait("XPATH", mbo.MissedCallsList,driver)){
							List<WebElement> MissedCallsList=driver.findElements(By.xpath(mbo.MissedCallsList));
							repfn.FnUpdateTestStepResHTML("Verify if Missed Calls are displayed", "Missed Calls are displayed. No of incoming calls displayed: "+MissedCallsList.size(), "PASS",runManagerInfoObj);
							blnFlag=true;

						}else{
							repfn.FnUpdateTestStepResHTML("Verify if Missed Calls are displayed", "Missed Calls are not displayed", "FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}

					catch (Exception e)
					{
						System.err.println("Message : "+e.getMessage());
						System.err.println("Cause : "+e.getCause());
						repfn.FnUpdateTestStepResHTML("verify if Missed Calls are displayed", "Missed Calls are not displayed due to some exception", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					m1.put("STEPSTATUS", blnFlag);
					return blnFlag;
				}
				
				public synchronized boolean FnDialledCalls(WebDriver driver, RunManagerInfo runManagerInfoObj)
				{
					try
					{	
						if(cnf.FnExplicitWait("XPATH", mbo.OutgoingCallsList,driver)){
							List<WebElement> OutgoingCallsList=driver.findElements(By.xpath(mbo.OutgoingCallsList));
							repfn.FnUpdateTestStepResHTML("Verify if Dialled Calls are displayed", "Dialled Calls are displayed. No of incoming calls displayed: "+OutgoingCallsList.size(), "PASS",runManagerInfoObj);
							blnFlag=true;

						}else{
							repfn.FnUpdateTestStepResHTML("Verify if Dialled Calls are displayed", "Dialled Calls are not displayed", "FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}

					catch (Exception e)
					{
						System.err.println("Message : "+e.getMessage());
						System.err.println("Cause : "+e.getCause());
						repfn.FnUpdateTestStepResHTML("verify if Dialled Calls are displayed", "Dialled Calls are not displayed due to some exception", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					m1.put("STEPSTATUS", blnFlag);
					return blnFlag;
				}
				public synchronized boolean FnSavedCallLogs(WebDriver driver, RunManagerInfo runManagerInfoObj)
				{
					try
					{	
						if(cnf.FnExplicitWait("XPATH", mbo.Savedcontacts,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Call Log List is displayed", "Call Log List is displayed","PASS",runManagerInfoObj);
							List <WebElement> ContactNumber=driver.findElements(By.xpath(mbo.Savedcontacts));  
							List <WebElement> ContactNumbers=new ArrayList<WebElement>(); 
							
							for(WebElement Contact:ContactNumber){
								String Contacts=Contact.getText();
								if(!(Contacts.contains("Unknown") || Contacts.contains("(")))
								{
									ContactNumbers.add(Contact);
								}					
							}
							
							if(ContactNumbers.size() > 0){
								repfn.FnUpdateTestStepResHTML("Verify if Saved contacts exist in the Call Log List", "Saved contacts exist in the Call Log List ","PASS",runManagerInfoObj);
								
								if(cnf.FnExplicitWait("XPATH",mbo.PhoneType,driver)){
									repfn.FnUpdateTestStepResHTML("Verify Phone Type List is displayed", "Phone Type List is displayed ","PASS",runManagerInfoObj);
									List <WebElement> PhoneType=driver.findElements(By.xpath(mbo.PhoneType));
									List <WebElement> phoneType1=new ArrayList<WebElement>();
															
									for(WebElement we:PhoneType){
										String type=we.getText();
										if(!(type.isEmpty()))
										{
											phoneType1.add(we);
										}					
									}
									
									if(phoneType1.size()>0){
										repfn.FnUpdateTestStepResHTML("Verify if Names and Call type is displayed", "Name is displayed as: "+ContactNumbers.get(0).getText()+" and Call type is displayed: "+phoneType1.get(0).getText(),"PASS",runManagerInfoObj);
										blnFlag=true;
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify if Names and Call type is displayed", "Call type is displayed is not displayed for: "+ContactNumbers.get(0).getText(),"FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Phone Type List is displayed", "Phone Type List is not displayed ","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify if Saved contacts exist in the Call Log List", "Saved contacts does not exist in the Call Log List ","PASS",runManagerInfoObj);
								boolean blnFlag1 = fnUnsavedContactsSave(driver,runManagerInfoObj);
								if(blnFlag1){
									boolean blnFlag2 = FnSavedCallLogs(driver,runManagerInfoObj);
									if(blnFlag2){
										blnFlag=true;
									}
									else{
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify whether Contact is saved or not", "Contact is not saved in the list ","FAIL",runManagerInfoObj);
									blnFlag=false;
								}					
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Call Log List is displayed", "Call Log List is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}

					catch (Exception e)

					{
						System.err.println("Message : "+e.getMessage());
						System.err.println("Cause : "+e.getCause());
						repfn.FnUpdateTestStepResHTML("Verify if saved Call Logs are displayed", "Saved Call Logs are not displayed ","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					m1.put("STEPSTATUS", blnFlag);
					return blnFlag;

				}
				public synchronized boolean FnCallLogs_DateandTime(WebDriver driver, RunManagerInfo runManagerInfoObj)
				{
					try
					{	
						if(cnf.FnExplicitWait("XPATH",mbo.TimeDisplay ,driver)){
							List <WebElement> DateAndTime=driver.findElements(By.xpath(mbo.TimeDisplay));
							for(WebElement we:DateAndTime)
							{
								if(we.getText().contains(":"))
								{
									System.out.println("The call was made today"+we.getText());
									repfn.FnUpdateTestStepResHTML("Verify if Call was made today", "Call was made today: "+we.getText(),"PASS",runManagerInfoObj);
									blnFlag=true;
								}
								else{
									if(we.getText().contains("/"))
									{
										System.out.println("The call was not made today"+we.getText());
										repfn.FnUpdateTestStepResHTML("Verify if Call was made today", "Call was not made today: "+we.getText(),"PASS",runManagerInfoObj);
										blnFlag=true;  
									}
								}
							}
						}

						driver.navigate().refresh();
					}

					catch (Exception e)
					{
						System.err.println("Message : "+e.getMessage());
						System.err.println("Cause : "+e.getCause());
						repfn.FnUpdateTestStepResHTML("Verify if Call details of today's call is displayed", "Call details of today's call is not  displayed due to some exeption","FAIL",runManagerInfoObj);
						blnFlag=false;		
					}
					m1.put("STEPSTATUS", blnFlag);
					return blnFlag;

				}
				public synchronized boolean Fn_CallLog_FirstName_LastNameEdit(WebDriver driver, RunManagerInfo runManagerInfoObj){

					String fullName = "";
					try{

						if(cnf.FnExplicitWait("XPATH", mbo.EditMode_firstName,driver)){
							WebElement firstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
							if(firstName.isDisplayed()){
								String oldFirstName = firstName.getAttribute("value");
								firstName.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"Richa"+randomInt);
								String newFirstName = firstName.getAttribute("value");
								if(newFirstName != oldFirstName){
									repfn.FnUpdateTestStepResHTML("Verify First Name field is modified ","First Name field is modified","PASS",runManagerInfoObj); 
									blnFlag	=true;
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify First Name field is modified ","First Name field is not modified","FAIL",runManagerInfoObj);
									blnFlag	=false;
								}

							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify First Name field is displayed ","First Name field is not displayed","FAIL",runManagerInfoObj);
							blnFlag	=false;
						}

						WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
						String newNameFirst = FirstName.getAttribute("value");

						if(cnf.FnExplicitWait("XPATH", mbo.EditMode_LastName,driver)){
							WebElement LastName=driver.findElement(By.xpath(mbo.EditMode_LastName));

							String oldLastName = LastName.getAttribute("value");
							LastName.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"Kapoor");
							String newLastName = LastName.getAttribute("value");
							if(newLastName != oldLastName){
								repfn.FnUpdateTestStepResHTML("Verify Last Name field is modified ","Last Name field is modified","PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Last Name field is modified ","Last Name field is not modified","FAIL",runManagerInfoObj);
								blnFlag=false;
							}


						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Last Name field is displayed ","Last Name field is not displayed","FAIL",runManagerInfoObj);
							blnFlag	=false;
						}

						WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
						String newNameLast = lastName.getAttribute("value");

						fullName = newNameFirst+ " " +newNameLast;

						driver.manage().window().setSize(new Dimension(100, 100));
						driver.manage().window().maximize();

						blnFlag=app.FnSaveDataAndGoBack(driver,runManagerInfoObj);


						if(blnFlag){
							if(cnf.FnExplicitWait("XPATH",mbo.searchBar,driver)){
								WebElement Search_Field=driver.findElement(By.xpath(mbo.searchBar));
								cnf.ScrollToView(Search_Field,driver);
								Search_Field.clear();
								Search_Field.sendKeys(fullName);
								repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
								Thread.sleep(2000);

								List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_CallLog_Arrow));
								if(Contacts_Arrow.get(0).isDisplayed()){
									repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
									if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
										repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
										if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
											repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

											Thread.sleep(2000);
											if(cnf.FnExplicitWait("XPATH", mbo.personalDetailVerificationOne,driver)){
												List<WebElement> personalDetails_Verification=driver.findElements(By.xpath(mbo.personalDetailVerificationOne));
												if(personalDetails_Verification.get(0).getText().equalsIgnoreCase(fullName)){
													repfn.FnUpdateTestStepResHTML("Verify Contact Name is modified ","Contact Name is modified. New name is: "+fullName ,"PASS",runManagerInfoObj);
													blnFlag=true;
													Search_Field.clear();
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify Contact Name is modified ","Contact Name is not modified" ,"FAIL",runManagerInfoObj);
													blnFlag=false;
												}
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify Contact Name is displayed ","Contact Name is not displayed" ,"FAIL",runManagerInfoObj);
												blnFlag=false;
											}

										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}

						}else{

							//	repfn.FnUpdateTestStepResHTML("Verify Save functionality working or not","Save functionality not working","FAIL",runManagerInfoObj);

							if(cnf.FnExplicitWaitFeedback("XPATH", mbo.Cancel_Button,driver))
							{
								WebElement close=driver.findElement(By.xpath(mbo.Cancel_Button));
								if(cnf.JSClick(close,driver)){
									repfn.FnUpdateTestStepResHTML("Verify Cancel button is clicked","Cancel button is clicked","PASS",runManagerInfoObj);
									blnFlag=false;
									Thread.sleep(2000);
									WebElement Confrm=driver.findElement(By.xpath(mbo.Confirm_btn));
									System.out.println("click aftr save not working");
									if(cnf.JSClick(Confrm,driver))
									{
										repfn.FnUpdateTestStepResHTML("Verify Confirm button is clicked","Confirm button is clicked","PASS",runManagerInfoObj);
										Thread.sleep(2000);
										driver.navigate().refresh();
										Thread.sleep(2000);
										//repfn.FnUpdateTestStepResHTML("Verify User is moved back to contacts page","User is moved back to contacts page","PASS",runManagerInfoObj);
										blnFlag=false;
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Confirm button is clicked","Confirm button is not clicked","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Cancel button is clicked","Cancel button is not clicked","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Cancel button is displayed","Cancel button is not displayed","FAIL",runManagerInfoObj);
								blnFlag=false;
							}

						}
					}
					catch (Exception e)

					{
						System.err.println("Message : "+e.getMessage());
						System.err.println("Cause : "+e.getCause());
						repfn.FnUpdateTestStepResHTML("Verify EditMode_firstName/Lastname is able to edit","EditMode_firstName/Lastname is not able to edit due to some exception","FAIL",runManagerInfoObj);
						blnFlag=false;

					}
					m1.put("STEPSTATUS", blnFlag);
					return blnFlag;	
				}
				
				public synchronized boolean FnSavedcontactdetails(WebDriver driver, RunManagerInfo runManagerInfoObj)
				{
					try
					{	

						if(cnf.FnExplicitWait("XPATH",mbo.CallInfo,driver)){
							repfn.FnUpdateTestStepResHTML("Verify if Call information Label is displayed", "Call Information Label is displayed","PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify if Call information Label is displayed", "Call Information Label is not  displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
						
						if(cnf.FnExplicitWait("XPATH",mbo.Name,driver)){
							WebElement Name=driver.findElement(By.xpath(mbo.Name));
							repfn.FnUpdateTestStepResHTML("Verify if Contact Name is displayed", "Contact Name is displayed: "+Name.getText(),"PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify if Contact Name is displayed", "Contact Name is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;         		
						}

						if(cnf.FnExplicitWait("XPATH",mbo.CallType,driver)){
							WebElement CallType=driver.findElement(By.xpath(mbo.CallType));
							repfn.FnUpdateTestStepResHTML("Verify if Calltype is displayed", "Calltype is displayed: "+CallType.getText(),"PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify if Calltype is displayed", "Calltype is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}


						if(cnf.FnExplicitWait("XPATH",mbo.Date,driver)){
							WebElement Date=driver.findElement(By.xpath(mbo.Date));
							repfn.FnUpdateTestStepResHTML("Verify if Call Date is displayed", "Call Date is displayed: "+Date.getText(),"PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify if Call Date is displayed", "Call Date is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}


						if(cnf.FnExplicitWait("XPATH",mbo.Time,driver)){
							WebElement Time=driver.findElement(By.xpath(mbo.Time));
							repfn.FnUpdateTestStepResHTML("Verify if Call Time is displayed", "Call Time is displayed: "+Time.getText(),"PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify if Call Time is displayed", "Call Time is  not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}


						if(cnf.FnExplicitWait("XPATH",mbo.Duration,driver)){
							WebElement Duration=driver.findElement(By.xpath(mbo.Duration));
							repfn.FnUpdateTestStepResHTML("Verify if Call Duration is displayed", "Call Duration is displayed: "+Duration.getText(),"PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify if Call Duration is displayed", "Call Duration is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;	
						}


						if(cnf.FnExplicitWait("XPATH",mbo.WorkNumber,driver)){
							WebElement Work=driver.findElement(By.xpath(mbo.WorkNumber));
							repfn.FnUpdateTestStepResHTML("Verify if Phone number is displayed", "Phone number is displayed: "+Work.getText(),"PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else
						{
							repfn.FnUpdateTestStepResHTML("Verify if Phone number is displayed", "Phone number is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}


						if(cnf.FnExplicitWait("XPATH",mbo.EmailAddress,driver)){
							List<WebElement> Email=driver.findElements(By.xpath(mbo.EmailAddress));
							repfn.FnUpdateTestStepResHTML("Verify if Email address is displayed", "Email address is displayed: "+Email.get(0).getText(),"PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else
						{
							repfn.FnUpdateTestStepResHTML("Verify if Email address is displayed", "Email address is not displayed. Email address is not added.","PASS",runManagerInfoObj);
							blnFlag=true;
						}


						if(cnf.FnExplicitWait("XPATH",mbo.Address,driver)){				
							if(cnf.FnExplicitWait("XPATH",mbo.StreetAddress,driver)){
								List<WebElement> StreetAddress=driver.findElements(By.xpath(mbo.StreetAddress));
								repfn.FnUpdateTestStepResHTML("Verify if Street Address is displayed", "Street Address is displayed: "+StreetAddress.get(0).getText(),"PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify if Street Address is displayed", "Street Address is not displayed","FAIL",runManagerInfoObj);
								blnFlag=false;
							}								
						}
						else
						{
							repfn.FnUpdateTestStepResHTML("Verify if Address is displayed", "Address is not displayed. Address is not added.","PASS",runManagerInfoObj);
							blnFlag=true;
						}

					} 

					catch (Exception e)

					{
						System.err.println("Message : "+e.getMessage());
						System.err.println("Cause : "+e.getCause());
						repfn.FnUpdateTestStepResHTML("Verify if Saved contact Details are displayed", "Saved contact Details are not displayed due to some exception  ","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					m1.put("STEPSTATUS", blnFlag);
					return blnFlag;

				}

				public synchronized boolean CallLog_Export_ReceivedCall(WebDriver driver, RunManagerInfo runManagerInfoObj)
				{

					try{
						
						if(cnf.FnExplicitWait("XPATH", mbo.ExportCalls_MissedCalls,driver)){
							repfn.FnUpdateTestStepResHTML("Check whether Export Missed Calls CheckBox is displayed", "Export Missed Calls CheckBox is displayed","PASS",runManagerInfoObj);
							blnFlag	=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Check whether Export Missed Calls CheckBox is displayed", "Export Missed Calls CheckBox is not displayed","FAIL",runManagerInfoObj);
							blnFlag	=false;
						}
						
						if(cnf.FnExplicitWait("XPATH", mbo.ExportCalls_DailledCalls,driver)){
							repfn.FnUpdateTestStepResHTML("Check whether Export Dialled Calls CheckBox is displayed", "Export Dialled Calls CheckBox is displayed","PASS",runManagerInfoObj);
							blnFlag	=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Check whether Export Dialled Calls CheckBox is displayed", "Export Dialled Calls CheckBox is not displayed","FAIL",runManagerInfoObj);
							blnFlag	=false;
						}
						
						if(cnf.FnExplicitWait("XPATH", mbo.ExportCalls_ReceivedCalls,driver)){
							repfn.FnUpdateTestStepResHTML("Check whether Export Received Calls CheckBox is displayed", "Export Received Calls CheckBox is displayed","PASS",runManagerInfoObj);
							blnFlag	=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Check whether Export Received Calls CheckBox is displayed", "Export Received Calls CheckBox is not displayed","FAIL",runManagerInfoObj);
							blnFlag	=false;
						}
						
						//UnCheck Dialled Calls Check Box
						if(cnf.FnExplicitWait("XPATH", mbo.ExportCalls_DailledCalls,driver)){
							WebElement ExportCalls_DailledCalls=driver.findElement(By.xpath(mbo.ExportCalls_DailledCalls));
								if(cnf.JSClick(ExportCalls_DailledCalls,driver)){
									repfn.FnUpdateTestStepResHTML("Verify Export Dialled Calls CheckBox is unchecked", "Export Dialled Calls CheckBox is unchecked","PASS",runManagerInfoObj);
									blnFlag	=true;
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Export Dialled Calls CheckBox is unchecked", "Export Dialled Calls CheckBox is not unchecked","FAIL",runManagerInfoObj);
									blnFlag	=false;
								}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Check whether Export Dialled Calls CheckBox is displayed", "Export Dialled Calls CheckBox is not displayed","FAIL",runManagerInfoObj);
							blnFlag	=false;
						}
						
						//UnCheck Missed Calls Check Box
						if(cnf.FnExplicitWait("XPATH", mbo.ExportCalls_MissedCalls,driver)){
							WebElement ExportCalls_MissedCalls=driver.findElement(By.xpath(mbo.ExportCalls_MissedCalls));				
								if(cnf.JSClick(ExportCalls_MissedCalls,driver)){
									repfn.FnUpdateTestStepResHTML("Verify Export Missed Calls CheckBox is unchecked", "Export Missed Calls CheckBox is unchecked","PASS",runManagerInfoObj);
									blnFlag	=true;
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Export Missed Calls CheckBox is unchecked", "Export Missed Calls CheckBox is not unchecked","FAIL",runManagerInfoObj);
									blnFlag	=false;
								}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Check whether Export Missed Calls CheckBox is displayed", "Export Missed Calls CheckBox is not displayed","FAIL",runManagerInfoObj);
							blnFlag	=false;
						}
						
					
					}
					catch(Exception e)
					{
						blnFlag	=false;
						repfn.FnUpdateTestStepResHTML("Check whether Export Received Calls is displayed and clicked", "Export Received Calls is not  displayed and not clicked due to some exception","FAIL",runManagerInfoObj);
						System.err.println("Message : "+e.getMessage());
						System.err.println("Cause : "+e.getCause());
					}
					m1.put("STEPSTATUS", blnFlag);
					return blnFlag;
				}


}
