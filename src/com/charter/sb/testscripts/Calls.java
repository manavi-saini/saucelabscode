package com.charter.sb.testscripts;

import org.openqa.selenium.WebDriver;

import com.charter.sb.beans.RunManagerInfo;
import com.charter.sb.controllers.Initialization;
import com.charter.sb.services.CallsService;
import com.charter.sb.services.CharterAppFunctions;
import com.charter.sb.utils.CommonFunctions;
import com.charter.sb.utils.ReportingFunctions;
import com.charter.sb.utils.RunManager;

public class Calls extends Initialization {
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	CallsService cs=new CallsService();
	public static boolean blnFlag = false;
	long startTime = System.currentTimeMillis();
	long endtime = System.currentTimeMillis();

	

	public synchronized void CallLogs_MissedCalls(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			for (int iCount = 0; iCount < 7; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						Thread.sleep(1000);
						break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						Thread.sleep(1000);
						break;
					case 3 :
						blnFlag = app.FnCallLogClick(driver,runManagerInfoObj);
						Thread.sleep(1000);
						break;
					case 4 :
						blnFlag = cs.fn_CallLogsListDisplay(driver,runManagerInfoObj);
						Thread.sleep(1000);
						break;
					case 5 :
						blnFlag = cs.fn_FilteredMissedCallLogVerification(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
						break;
				}
				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}

	public synchronized void CallLogs_AllCalls(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			for (int iCount = 0; iCount < 7; iCount++) {
				switch (iCount) {
					case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;	
					case 1 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						Thread.sleep(1000);
						break;
					case 3 :
						blnFlag = app.FnCallLogClick(driver,runManagerInfoObj);
						Thread.sleep(1000);
						break;
					case 4 :
						blnFlag = cs.fn_CallLogsListDisplay(driver,runManagerInfoObj);
						Thread.sleep(1000);
						break;
					case 5 :
						blnFlag = cs.fn_FilteredAllCallLogVerification(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}

	public synchronized void FN_VerifyNoMissedCallFilter(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			
			for (int iCount = 0; iCount < 6; iCount++) {

				switch (iCount) {
					case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
					System.out.println("Case1");
					blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
					break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnCallLogClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = cs.FN_VerifyNoMissedCallFilter(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
						break;

				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}

	/**
	 * Script Description : This method is to Export Missed call list from call
	 * log
	 * 
	 * @author Ajoy
	 * @param placeholder
	 * @throws Exception
	 */
	public synchronized void Sprint24_ExportMissedCalls(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
					System.out.println("Case1");
					blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
					break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnCallLogClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = cs.VoiceExportDownLoadClick(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = cs.CallLog_Export_MissedCall(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = cs.FN_ExportbuttonClick(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}

	/**
	 * Description : This method is to Export Received call list from call log
	 * 
	 * @author Ajoy
	 * @param placeholder
	 * @throws Exception
	 */

	public synchronized void Sprint24_ExportReceivedCalls(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
					System.out.println("Case1");
					blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
					
					break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnCallLogClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = cs.VoiceExportDownLoadClick(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = cs.CallLog_Export_ReceivedCall(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = cs.FN_ExportbuttonClick(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}

	/**
	 * Description : This method is to Export Dialed call list from call log
	 * 
	 * @author Ajoy
	 * @param placeholder
	 * @throws Exception
	 */

	public synchronized void Sprint24_ExportDialedCalls(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
					System.out.println("Case1");
					blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
					
					break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnCallLogClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = cs.VoiceExportDownLoadClick(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = cs.CallLog_Export_DialedCall(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = cs.FN_ExportbuttonClick(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/**
	 * Description : This method is to block the contact and save
	 * 
	 * @author Ajoy
	 * @param placeholder
	 * @throws Exception
	 *             Modified:saranya[10/29/2015]
	 */

	public synchronized void Sprint24_CallBlock_Save(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {

			
			
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
					System.out.println("Case1");
					blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
					
					break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnCallLogClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = cs.Fn_callLogBlock_Cancel(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = cs.fn_callLogBlockSave(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.FN_manageLine_backbtnClick(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/**
	 * Script Description : This method is to block the unsaved contacts and
	 * cancel the action
	 * 
	 * @author Ajoy
	 * @param placeholder
	 * @throws Exception
	 *             Modified:saranya[10/29/2015]
	 */

	public synchronized void Sprint24_CallBlock(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
					System.out.println("Case1");
					blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
					
					break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnCallLogClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = cs.Fn_callLogBlock_Cancel(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = cs.FN_BlockingContact_Cancel(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.FN_manageLine_backbtnClick(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	public synchronized void Sprint24_BlockUnknownNumber(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			for (int iCount = 0; iCount < 7; iCount++) {
				switch (iCount) {
					case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
					System.out.println("Case1");
					blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
					break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnCallLogClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.fn_CommonFunction_CallLogUnknownNumber(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.fn_callLogBlockUnknownNumber(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
						break;

				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user is able to edit the saved contacts from the call
	 * details window in the call logs page and cancel the changes. Created by
	 * Saranya Date : 9/28/2015
	 */
	public synchronized void Sprint25_FnCallLog_EditExistingNo_cancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
					System.out.println("Case1");
					blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
					break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.Fn_CallLogClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = cs.Fn_Savedcontact_Click(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = cs.Fn_CallLog_EditClick(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = cs.Fn_CallLog_FirstName_LastNameEdit_Cancel(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	public synchronized void Sprint25_callDetails_UnsavedContactsToExisting(WebDriver driver, RunManagerInfo runManagerInfoObj)
			throws Exception {

		try {
			
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
					System.out.println("Case1");
					blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
					break;
					case 2 :
						System.out.println("Case2");
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case2");
						blnFlag = app.FnCallLogClick(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case3");
						blnFlag = cs.fnAddToExistingSave(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case4");
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}

	public synchronized void CallLogs(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
					System.out.println("Case1");
					blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
					break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						Thread.sleep(1000);
						break;
					case 3 :
						blnFlag = app.FnCallLogClick(driver,runManagerInfoObj);
						Thread.sleep(1000);
						break;
					case 4 :
						blnFlag = cs.fn_CallLogsListDisplay(driver,runManagerInfoObj);
						Thread.sleep(1000);
						break;
					case 5 :
						blnFlag = cs.fn_FilteredAllCallLogVerification(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = cs.fn_FilteredMissedCallLogVerification(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
						break;
				}
				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}

	public synchronized void UnSavedCallLogDetails(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			for (int iCount = 0; iCount < 6; iCount++) {

				switch (iCount) {
					case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
					System.out.println("Case1");
					blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
					break;
					case 2 :
						System.out.println("Case2");
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case3");
						blnFlag = app.fn_callLogBlock(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case4");
						blnFlag = cs.FnUnSavedCallLogDetails(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case5");
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
						break;
				}
				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}
	public synchronized void Sprint25_callDetails_UnsavedContactsSave(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			for (int iCount = 0; iCount < 6; iCount++) {

				switch (iCount) {
					case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
					System.out.println("Case1");
					blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
					break;
					case 2 :
						System.out.println("Case2");
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case3");
						blnFlag = app.fn_callLogBlock(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case3");
						blnFlag = cs.fnUnsavedContactsSave(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case5");
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}

			//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}
	public synchronized void Sprint25_AddtoContacts(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			for (int iCount = 0; iCount < 6; iCount++) {

				switch (iCount) {
					case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
					System.out.println("Case1");
					blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
					break;
					case 2 :
						System.out.println("Case2");
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case3");
						blnFlag = app.FnCallLogClick(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case4");
						blnFlag = cs.fn_callLog_Save_Cancel(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case5");
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}

	public synchronized void Sprint25_FnCallLog_Search_FN_AllFilter_Selected(WebDriver driver, RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
					System.out.println("Case1");
					blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
					break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnCallLogClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = cs.FnCallLog_SearchBar(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = cs.FnCallLog_AllFilter(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.FnCallLog_Search_FNLN(driver,runManagerInfoObj);
						break;
					case 7 :
				
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}

	public synchronized void Sprint25_FnSearchByLastName(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
					System.out.println("Case1");
					blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
					break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnCallLogClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = cs.FnCallLog_SearchBar(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = cs.FnCallLog_AllFilter(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = cs.fnSearchByLastName(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}

		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnCom_ThrowException(e,driver);
		}
		//repfn.FnUpdateEndTest(runManagerInfoObj);
	}

	public synchronized void Sprint25_FnSearchByPhoneNumber(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
					System.out.println("Case1");
					blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
					break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnCallLogClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = cs.FnCallLog_SearchBar(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = cs.FnCallLog_AllFilter(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = cs.fnSearchByPhoneNumber(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnCom_ThrowException(e,driver);
		}
		//repfn.FnUpdateEndTest(runManagerInfoObj);
	}

	public synchronized void Sprint25_FnSearchByFirstName(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
					System.out.println("Case1");
					blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
					break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnCallLogClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = cs.FnCallLog_SearchBar(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = cs.fn_FilteredMissedCallLogVerification(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.FnCallLog_Search_FNLN(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnCom_ThrowException(e,driver);
		}
		//repfn.FnUpdateEndTest(runManagerInfoObj);
	}

	public synchronized void Sprint25_MissedcallFilterLastName(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		try {
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;	
					case 1 :
					System.out.println("Case1");
					blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
					break;
					case 2 :
						System.out.println("Case2");
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case3");
						blnFlag = app.FnCallLogClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = cs.FnCallLog_SearchBar(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = cs.fn_FilteredMissedCallLogVerification(driver,runManagerInfoObj);
						break;
					case 6 :
						
						blnFlag = cs.fnSearchByLastName(driver,runManagerInfoObj);
						break;
					case 7 :
				
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}
	public synchronized void Sprint25_MissedcallFilterPhoneNo(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			for (int iCount = 0; iCount < 8; iCount++) {

				switch (iCount) {
					case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
					System.out.println("Case1");
					blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
					break;
					case 2 :
						System.out.println("Case2");
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case3");
						blnFlag = app.FnCallLogClick(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case4");
						blnFlag = cs.FnCallLog_SearchBar(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case5");
						blnFlag = cs.fn_FilteredMissedCallLogVerification(driver,runManagerInfoObj);
						break;
					case 6 :
						System.out.println("Case6");
						blnFlag = cs.fnSearchByPhoneNumber(driver,runManagerInfoObj);
						break;
					case 7 :
						System.out.println("Case7");
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}

	

	public synchronized void Sprint25_CallLogExistingContact(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			for (int iCount = 0; iCount < 6; iCount++) {

				switch (iCount) {
					case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
					System.out.println("Case1");
					blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
					break;
					case 2 :
						System.out.println("Case2");
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case3");
						blnFlag = app.FnCallLogClick(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case4");
						blnFlag = cs.Fn_AddToExistingContacts(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case5");
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}

	public synchronized void IncominCallsIndicator(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		try {
			String Browser = m1.get("BROWSER").toString();
			for (int iCount = 0; iCount < 8; iCount++) {

				switch (iCount) {
					case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case2");
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case3");
						blnFlag = app.fn_callLogBlock(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case4");
						blnFlag = cs.FnIncomingCalls(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case5");
						blnFlag = cs.FnMissedCalls(driver,runManagerInfoObj);
						break;
					case 6 :
						System.out.println("Case6");
						blnFlag = cs.FnDialledCalls(driver,runManagerInfoObj);
						break;
					case 7 :
						System.out.println("Case7");
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}
	public synchronized void SavedCallLogDetails(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case2");
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case3");
						blnFlag = app.fn_callLogBlock(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case4");
						blnFlag = cs.FnSavedCallLogs(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case5");
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
						break;
				}
				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}

	public synchronized void CallLogs_DateAndTime(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			for (int iCount = 0; iCount < 6; iCount++) {

				switch (iCount) {
					case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case2");
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case3");
						blnFlag = app.fn_callLogBlock(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case4");
						blnFlag = cs.FnCallLogs_DateandTime(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case5");
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}

	/*
	 * Call Log > Call Details_Edit saved contact & Save.Created by Saranya Date
	 * :10/14 /2015/
	 */

	public synchronized void FN_SavedContactLogEdit(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			
			for (int iCount = 0; iCount < 8; iCount++) {

				switch (iCount) {
					case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
					System.out.println("Case1");
					blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
					break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.Fn_CallLogClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = cs.Fn_Savedcontact_Click(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = cs.Fn_CallLog_EditClick(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = cs.Fn_CallLog_FirstName_LastNameEdit(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}

	public synchronized void SavedContactsDetails(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
		

			for (int iCount = 0; iCount < 8; iCount++) {

				switch (iCount) {
					case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1:
						System.out.println("Case 1");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case 2");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case 3");
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case 4");
						blnFlag = app.fn_callLogBlock(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case 5");
						blnFlag = cs.Fn_Savedcontact_Click(driver,runManagerInfoObj);
						break;
					case 6 :
						System.out.println("Case 6");
						blnFlag = cs.FnSavedcontactdetails(driver,runManagerInfoObj);
						break;
					case 7 :
						System.out.println("Case 7");
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}
	
}