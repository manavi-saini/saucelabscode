package com.charter.sb.testscripts;

import org.openqa.selenium.WebDriver;

import com.charter.sb.beans.RunManagerInfo;
import com.charter.sb.controllers.Initialization;
import com.charter.sb.services.CharterAppFunctions;
import com.charter.sb.services.VoiceSettingsService;
import com.charter.sb.utils.CommonFunctions;
import com.charter.sb.utils.ReportingFunctions;
import com.charter.sb.utils.RunManager;

public class VoiceSettings extends Initialization {
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	public static boolean blnFlag = false;
	long startTime = System.currentTimeMillis();
	long endtime = System.currentTimeMillis();

	VoiceSettingsService vss=new VoiceSettingsService();

	// Iteration-3
	/*
	 * Priyanka[18-11-2015] This script will validate the UI of Change voice pin
	 * window//
	 */

	public synchronized void VoiceSettings_ChangeVoicePinUI(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		
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
						blnFlag = app.VoiceSettings(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = vss.Fn_ChangeVoicePinUI(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = vss.ChangeVoiceMailPin_close(driver,runManagerInfoObj);
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
	// Neha[10/06/2015]
	public synchronized void Sprint27_FN_VoicemailPinSave(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = app.VoiceSettings(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = vss.Fn_SaveVoicemailPin(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = vss.ChangeVoiceMailPin_close(driver,runManagerInfoObj);
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
	// Neha[10/06/2015]
	public synchronized void Sprint27_FN_VoicemailPinCancel(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = app.VoiceSettings(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = vss.Fn_CancelSaveVoicemailPin(driver,runManagerInfoObj);
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
	/*
	 * Verifying if the user has the option to access forward all calls feature.
	 * Created by Manavi Date : 14/10/2015
	 */

	public synchronized void Sprint27_FN_CheckForwardCallsFeature(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {

		try {

			
			for (int iCount = 0; iCount < 8; iCount++) {
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
						blnFlag = app.FnVerifyMessagesPage(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = vss.FnVerifyCallForward(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = vss.VerifyCallForwardOptions(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = vss.CloseVoiceSettings(driver,runManagerInfoObj);
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
	/*
	 * Verify that all the phone lines associated to the account are displayedon
	 * the 'Forwarding Call Manager' page (except toll free numbers)Created by
	 * Saranya Date :12/10 /2015/
	 */

	public synchronized void Sprint29_FN_VerifyForwardLineDetails_Page(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			for (int iCount = 0; iCount < 9; iCount++) {
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
						blnFlag = app.FN_ForwardCallLogClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = vss.Fn_ForwardInternal_External_Lines_LabelCheck(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = vss.Fn_ForwardTo_If_LabelCheck(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = vss.Fn_RecevingLabelLabelCheck(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = vss.Fn_StatusLabelCheck(driver,runManagerInfoObj);
						break;
					case 8 :
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

	public synchronized void Sprint27_FN_VoicemailGreeting(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			for (int iCount = 0; iCount < 11; iCount++) {
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
						blnFlag = app.VoiceSettings(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = vss.Fn_VoicemailGreetingsClick(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = vss.Fn_VoicemailGreetingsTitle(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = vss.Fn_VoicemailGreetingsPlay(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = vss.Fn_VoicemailGreetingsClose(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = vss.Fn_VoicemailGreetingsSave(driver,runManagerInfoObj);
						break;
					case 9 :
						blnFlag = vss.Fn_VoicemailGreetingsDropdown(driver,runManagerInfoObj);
						break;
					case 10 :
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

	public synchronized void Sprint29_Fn_VoiceSettingsCallForwardingUI(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
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
						blnFlag = app.VoiceSettings(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = vss.fnVoiceSettingsCallForwardingUI(driver,runManagerInfoObj);
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
		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnCom_ThrowException(e,driver);
		}
		//repfn.FnUpdateEndTest(runManagerInfoObj);
	}
	/*
	 * Verify the UI of Forwarding Call Manager screen Created by Jhansi Date :
	 * Dec 8,2015 TC Name:Voice >Forwarding Call Manager>UI TC#:45 Iteration4
	 * Method:Sprint29_FN_Voice_ForwardingCallManager_UI
	 */
	public synchronized void Sprint29_FN_Voice_ForwardingCallManager_UI(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = app.FN_ForwardCallLogClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = vss.Fn_FwdingManagerScreen_UI(driver,runManagerInfoObj);
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
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verify the Manage forwarding numbers> UI Created by Jhansi Date : Dec
	 * 1,2015 TC Name:Voice Settings > Call Forwarding > Manage forwarding
	 * numbers> UI TC#:29 Iteration3
	 * Method:Sprint29_FN_VoiceSettings_CallFwding_ManageFwdingUI
	 */
	public synchronized void Sprint29_FN_VoiceSettings_CallFwding_ManageFwdingUI(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
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
						blnFlag = app.VoiceSettings(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = vss.FN_NavigateFwdAllCalls(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = vss.FN_FwdAllCalls_Menus(driver,runManagerInfoObj);
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
	 * Verify the Voice Settings > Call Forwarding > Manage forwarding numbers_
	 * UI Created by Jhansi Date : Dec 7,2015 TC Name:Voice Settings > Call
	 * Forwarding > Manage forwarding numbers_ UI TC#:31 Iteration4
	 * Method:Sprint29_FN_VoiceSettings_CallFwding_ManageFwdingNumbers_UI
	 */
	public synchronized void Sprint29_FN_VoiceSettings_CallFwding_ManageFwdingNumbers_UI(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			for (int iCount = 0; iCount < 9; iCount++) {

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
						blnFlag = app.VoiceSettings(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = vss.FN_NavigateFwdAllCalls(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = vss.FN_FwdAllCalls_Menus(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = vss.FN_ManageFwdLine_PopUp(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = vss.FN_ManageFwdLine_PopUp_Options(driver,runManagerInfoObj);
						break;
					case 8 :
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
	// To verify if the Call Forwarding Status can be changed//

	public synchronized void ForwardingStatusChange(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		
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
					/*
					 * case 6: System.out.println("Case7");
					 * blnFlag=app.FN_ForwardCallLogList_firstContact(); break;
					 * 
					 * case 7: System.out.println("Case8");
					 * blnFlag=app.ForwardingStatus_change(); break; case 8:
					 * System.out.println("Case9");
					 * blnFlag=app.SaveChanges_ForwardingCallManager(); break;
					 */
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
	public synchronized void Sprint29_Fn_voiceSettingUpdateAdmin(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
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
						blnFlag = app.FnCallLogClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = vss.fnVerifyVoiceSetting(driver,runManagerInfoObj);
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
		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnCom_ThrowException(e,driver);
		}
		//repfn.FnUpdateEndTest(runManagerInfoObj);
	}

	/*
	 * Verify if the user is able to see the list of previously used phone lines
	 * on switching on call forwarding Created by Jhansi Date : Dec 8,2015 TC
	 * Name:Voice Settings > Call Forwarding > Manage forwarding numbers_Forward
	 * all calls>Numbers display TC#:30 Iteration4
	 * Method:Sprint29_FN_VoiceSettings_CallFwding_ManageFwdingNumbers_UI
	 */
	public synchronized void Sprint29_FN_VoiceSettings_CallFwding_ManageFwding_NumbersDisplay(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
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
						blnFlag = app.VoiceSettings(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = vss.FN_NavigateFwdAllCalls(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = vss.FN_FwdAllCalls_CallFwding_NumbersDisplay(driver,runManagerInfoObj);
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

	/*
	 * Voice>Voice Settings > Call Forwarding>Enable Forward Immediately / No
	 * Ring Voice>Voice Settings > Call Forwarding>Enable Forward Busy/No Answer
	 * Voice>Voice Settings > Call Forwarding>save Created by Saranya Date :
	 * 10/20/2015
	 */

	public synchronized void ForwardAllCallsTo_StatusMethodContact_ON_Off(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {

		
		try {
			String Browser = m1.get("BROWSER").toString();
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
						System.out.println("Case3");
						blnFlag = app.VoiceSettings(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case4");
						blnFlag = vss.Fn_FwdAllCallsOption1(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case5");
						blnFlag = app.ForwardCallsTo_Off(driver,runManagerInfoObj);
						break;
					case 6 :
						System.out.println("Case4");
						blnFlag = vss.Fn_FwdAllCallsOption1(driver,runManagerInfoObj);
						break;
					case 7 :
						System.out.println("Case5");
						blnFlag = app.ForwardCallsTo_On(driver,runManagerInfoObj);
						break;
					case 8 :
						System.out.println("Case6");
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
	 * Voice>Voice Settings > Call Forwarding>cancel Created by Saranya Date :
	 * 10/20/2015
	 */

	public synchronized void ForwardAllCallsTo_StatusMethodContact_On_OFF_Cancel(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {

		
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
						System.out.println("Case3");
						blnFlag = app.VoiceSettings(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case4");
						blnFlag = vss.Fn_FwdAllCallsOption1(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case5");
						blnFlag = vss.ForwardCallsTo_Off_Cancel(driver,runManagerInfoObj);
						break;
					case 6 :
						System.out.println("Case6");
						blnFlag = vss.Fn_FwdAllCallsOption1(driver,runManagerInfoObj);
						break;
					case 7 :
						System.out.println("Case7");
						blnFlag = vss.ForwardCallsTo_On_Cancel(driver,runManagerInfoObj);
						break;
					case 8 :
						System.out.println("Case8");
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