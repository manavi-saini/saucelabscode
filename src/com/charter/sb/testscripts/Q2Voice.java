package com.charter.sb.testscripts;

import org.openqa.selenium.WebDriver;

import com.charter.sb.beans.RunManagerInfo;
import com.charter.sb.controllers.Initialization;
import com.charter.sb.services.CharterAppFunctions;
import com.charter.sb.services.Q2VoiceService;
import com.charter.sb.utils.CommonFunctions;
import com.charter.sb.utils.ReportingFunctions;
import com.charter.sb.utils.RunManager;

public class Q2Voice extends Initialization {
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	public static boolean blnFlag = false;
	long startTime = System.currentTimeMillis();
	long endtime = System.currentTimeMillis();

	Q2VoiceService vs=new Q2VoiceService();
	

	

	public synchronized void BlockAContact(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
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
						blnFlag = vs.FnBlockContact(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case5");
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
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
	public synchronized void UnBlockAContact(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
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
						blnFlag = app.FnUnBlockContact(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case5");
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
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
	public synchronized void CancelBlock(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
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
						System.out.println("Case2");
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case3");
						blnFlag = app.fn_callLogBlock(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case4");
						blnFlag = vs.FnCancelBlock(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case5");
						blnFlag = app.FN_BackButtonClick(driver,runManagerInfoObj);
						break;
					case 6 :
						System.out.println("Case5");
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
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
	public synchronized void UnknownCall_Block(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			for (int iCount = 0; iCount < 7; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
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
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
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
	 * Verify that the user has an option to block phone numbers that are not
	 * added to the user's contact list Created by Manavi Date : 9/12/2015
	 */

	public synchronized void Sprint28_FN_VerifyBlockOption_UnsavedContact(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.fn_callLogBlock(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = vs.FnVerifyBlockOption_UnsavedContact(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
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
	 * Verify that the user has an option to block phone numbers that are not
	 * added to the user's contact list Created by Manavi Date : 9/12/2015
	 */

	public synchronized void Sprint28_FN_VerifyBlockOption_SavedContact(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.fn_callLogBlock(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FnVerifyBlockOption_SavedContact(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
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
	// Priyanka [10/13/2015]
	// To add duplicate forwarding Number in Manage Forwarding Lines//

	public synchronized void DuplicateForwardingNumber(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		try {
			

			for (int iCount = 0; iCount < 9; iCount++) {
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
						blnFlag = app.FnVerifyMessagesPage(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case3");
						blnFlag = app.VoiceSettings(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case4");
						blnFlag = vs.Fn_FwdAllCallsOptionCheck(driver,runManagerInfoObj);
						break;
					case 6 :
						System.out.println("Case5");
						blnFlag = app.ManageForwardingLines(driver,runManagerInfoObj);
						break;
					case 7 :
						System.out.println("Case6");
						blnFlag = vs.FN_AddDuplicateNumber(driver,runManagerInfoObj);
						break;
					case 8 :
						System.out.println("Case7");
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
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
	// Priyanka [10/13/2015]
	// to add emergency Number as Forwarding contact//

	public synchronized void EmergencyforwardingNumber(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		try {
			

			for (int iCount = 0; iCount <8; iCount++) {

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
						blnFlag = app.VoiceSettings(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case4");
						blnFlag = vs.Fn_FwdAllCallsOptionCheck(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case5");
						blnFlag = app.ManageForwardingLines(driver,runManagerInfoObj);
						break;
					case 6 :
						System.out.println("Case6");
						blnFlag = vs.FN_emergencycontact(driver,runManagerInfoObj);
						break;
					case 7 :
						System.out.println("Case7");
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
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
	// Priyanka [10/14/2015]
	// To verify the UI of the Call Forwarding Window//

	public synchronized void ForwardingWindowUI(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
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
						System.out.println("Case2");
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case3");
						blnFlag = app.FN_ForwardCallLogClick(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case4");
						blnFlag = vs.FN_StatusOnretrieval(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case5");
						blnFlag = vs.FN_ForwardingwindowUI(driver,runManagerInfoObj);
						break;
					case 6 :
						System.out.println("Case6");
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
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
	// To verify if the Call Forwarding Status can be changed//

	public synchronized void ForwardingStatusChange(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
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
						blnFlag = app.FN_ForwardCallLogClick(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case4");
						blnFlag = app.FN_ForwardCallLogList_firstContact(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case5");
						blnFlag = app.ForwardingStatus_change(driver,runManagerInfoObj);
						break;
					case 6 :
						System.out.println("Case6");
						blnFlag = app.SaveChanges_ForwardingCallManager(driver,runManagerInfoObj);
						break;
					case 7 :
						System.out.println("Case7");
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
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
	// Priyanka [10/14/2015]
	// To add and delete new external Forwarding destination//

	public synchronized void NewExternalForwardingDestination(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		
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
						System.out.println("Case2");
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case3");
						blnFlag = app.FN_ForwardCallLogClick(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case3");
						blnFlag = vs.FN_OpenExternalForwardLine(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case5");
						blnFlag = vs.FN_AddNewExternalforwardingDestination(driver,runManagerInfoObj);
						break;
					case 6 :
						System.out.println("Case6");
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
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

	public synchronized void DeleteExternalForwardingDestination(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		
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
						System.out.println("Case2");
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case3");
						blnFlag = app.FN_ForwardCallLogClick(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case3");
						blnFlag = vs.FN_OpenExternalForwardLine(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case5");
						blnFlag = vs.FN_DeleteNewExternalforwardingDestination(driver,runManagerInfoObj);
						break;
					case 6 :
						System.out.println("Case6");
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
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

	public synchronized void FN_CreateNewUser_AssignAdminLine(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			for (int iCount = 0; iCount < 12; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnManageUserLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FN_addNewUserClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FNEnteringData_FN_LN_Email_phone(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FnNextbuttonClick(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.FN_StandardPermissionclick(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FnNextbuttonClick(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = app.fnManageVoice(driver,runManagerInfoObj);
						break;
					case 9 :
						blnFlag = app.FnConfirmbuttonClick(driver,runManagerInfoObj);
						break;
					case 10 :
						blnFlag = vs.FN_sucessMessageVerification(driver,runManagerInfoObj);
						break;
					case 11 :
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
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
	public synchronized void Sprint31_AdminSelectsAdmin(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
		
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;

					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnManageUserClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = vs.AdminvsAdmin(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
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
	 * Verify that the user is unable to access Voice settings menu from Manage
	 * Lines page since the currently selected line is not displayed in the
	 * breadcrumb navigation of the page and the user does not know which line
	 * is being edited. Created by Manavi Date : 30/11/2015
	 */

	public synchronized void Sprint31_FN_VerifyVoiceSettings_ManageLinesPage(WebDriver driver, RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnManageLinkClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = vs.FnVerifyVoiceSettings_ManageLines(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
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
	 * Verify that the user is unable to access Voice settings menu from
	 * Forwarding Manager page since the currently selected line is not
	 * displayed in the breadcrumb navigation of the page and the user does not
	 * know which line is being edited. Created by Manavi Date : 30/11/2015
	 */

	public synchronized void Sprint31_FN_VerifyVoiceSettings_ForwardingManagerPage(WebDriver driver, RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnForwardingManagerClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = vs.FnVerifyVoiceSettings_ForwardingManager(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
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
	 * Verify if Standard user is able to download call logs Created by Jhansi
	 * Date : Dec 8,2015 TC Name:My Downloads Page - Q2 > Standard user TC#:132
	 * Iteration3 Method:Sprint31_FN_ExportCallLog_StdUser
	 */

	public synchronized void Sprint31_FN_ExportCallLog_StdUser(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			for (int iCount = 0; iCount < 4; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = vs.Fn_StdUser_BillingSection(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
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

	public synchronized void FN_ExportCallLogsCancel_accountOwner(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVerifyAndClickBillingLink(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnVerifyAndClickExportCallLog(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FnVerifyExportOptions_Cancel(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
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
	 * Verify if the user is able Export call logs from the View Statements page
	 * and cancel the export. Created by Jhansi Date : Dec 7,2015 TC Name:My
	 * Downloads Page - Q2 > Export and Cancel_Billing user TC#:127 Iteration3
	 * Method:Sprint31_FN_Cancel_ExportCallLog
	 */

	public synchronized void Sprint31_FN_Cancel_ExportCallLog(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.Fn_Ovw_ViewStatements(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = vs.Fn_ChargeDetails_Phone_ExportCallLog(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
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
	 * Verify if the user is able Export call logs from the View Statements page
	 * and cancel the export. Created by Manavi Date : 27/11/2015
	 */

	public synchronized void Sprint31_FN_ExportCallLogs_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
				
				    case 0:
					    System.out.println("Case 0");
					    blnFlag=app.UserLogin(driver,runManagerInfoObj);
					    break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVerifyAndClickBillingLink(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnVerifyAndClickExportCallLog(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FnVerifyExportOptions_Cancel(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
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

}