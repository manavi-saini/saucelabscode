package com.charter.sb.testscripts;

import org.openqa.selenium.WebDriver;

import com.charter.sb.beans.RunManagerInfo;
import com.charter.sb.controllers.Initialization;
import com.charter.sb.services.CharterAppFunctions;
import com.charter.sb.services.MessagesService;
import com.charter.sb.utils.CommonFunctions;
import com.charter.sb.utils.ReportingFunctions;
import com.charter.sb.utils.RunManager;

public class Messages extends Initialization {
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	public static boolean blnFlag = false;
	long startTime = System.currentTimeMillis();
	long endtime = System.currentTimeMillis();
	MessagesService msg=new MessagesService();


	public synchronized void VoiceMultiCheck(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			for (int iCount = 0; iCount < 5; iCount++) {

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
						blnFlag = msg.VoiceIcons_check(driver,runManagerInfoObj);
						break;
					case 4 :
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
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	public synchronized void VoiceSingleCheck(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			for (int iCount = 0; iCount < 5; iCount++) {

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
						System.out.println("Case3");
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case3");
						blnFlag = msg.VoiceIcons_SingleLinecheck(driver,runManagerInfoObj);
						break;
					case 4 :
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
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	public synchronized void DeleteMessages_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			for (int iCount = 0; iCount < 5; iCount++) {

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
						System.out.println("Case3");
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case3");
						blnFlag = msg.Deletemessages_Cancel(driver,runManagerInfoObj);
						break;
					case 4 :
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
	public synchronized void DeleteMessages_Confirm(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			for (int iCount = 0; iCount < 5; iCount++) {

				switch (iCount) {
					case 0 :
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case3");
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case3");
						blnFlag = msg.Deletemessages_Confirm(driver,runManagerInfoObj);
						break;
					case 4 :
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
	/*
	 * Verifying if the user is able to successfully block the contact that sent
	 * the voice message. Created by Harpreet_Kaur16 Date : 10/5/2015
	 */
	public synchronized void Sprint24_BlockContact(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = msg.fn_blockNumber(driver,runManagerInfoObj);
						break;
					case 4 :
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
	 * Verifying if the user is able to block the contact that sent the voice
	 * message and cancel the changes before saving. Created by Harpreet_Kaur16
	 * Date : 10/5/2015
	 */
	public synchronized void Sprint24_BlockContactCancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = msg.fn_blockNumberCancel(driver,runManagerInfoObj);
						break;
					case 4 :
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
	 * Verifying if the user is able to make mass changes to the list of
	 * messages so that the user does not have to manage each message
	 * individually. Created by Saranya Date : 9/18/2015
	 */
	public synchronized void Sprint24_DeleteMessage_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = msg.FNDeletePromptCancelCheck(driver,runManagerInfoObj);
						break;
					case 4 :
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
	 * Verifying if the user is able to make mass changes to the list of
	 * messages so that the user does not have to manage each message
	 * individually. Created by Saranya Date : 9/18/2015
	 */
	public synchronized void Sprint24_DeleteMessage_Confirm(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = msg.FNDeleteMessageConfirm(driver,runManagerInfoObj);
						break;
					case 4 :
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
	 * Verifying if the user is able to cancel permanent delete all the voice
	 * messages. Created by Manavi Date : 9/10/2015
	 */

	public synchronized void Sprint27_FN_AllVoiceMessages_CancelDelete(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

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
						blnFlag = app.FnVerifyMessagesPage(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = msg.FnCancelDeleteVoiceMessages(driver,runManagerInfoObj);
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

	public synchronized void Sprint27_FN_ViewDeletedMessages(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
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
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = msg.fnViewDeletedMessages(driver,runManagerInfoObj);
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
	 * Verifying if the user is able to permanently delete all the voice
	 * messages Created by Manavi Date : 9/10/2015
	 */

	public synchronized void Sprint27_FN_AllVoiceMessages_Delete(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

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
						blnFlag = app.FnVerifyMessagesPage(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = msg.FnDeleteVoiceMessages(driver,runManagerInfoObj);
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
	 * Verifying if the user is able to permanently delete a single voice
	 * message Created by Manavi Date : 9/10/2015
	 */

	public synchronized void Sprint27_FN_VoiceMessage_Delete(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = app.FnVerifyMessagesPage(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = msg.FnDeleteVoiceMessage(driver,runManagerInfoObj);
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
	 * Verifying if the user is able to cancel permanent delete a single voice
	 * message. Created by Manavi Date : 9/10/2015
	 */

	public synchronized void Sprint27_FN_VoiceMessage_CancelDelete(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = app.FnVerifyMessagesPage(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = msg.FnCancelDeleteVoiceMessage(driver,runManagerInfoObj);
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
	 * Verifying if the user is able to go back to messages page from Deleted
	 * Messages page. Created by Manavi Date : 13/10/2015
	 */

	public synchronized void Sprint27_FN_CheckGoBackToMessagesOption(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

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
						blnFlag = app.FnVerifyMessagesPage(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = msg.FnVerifyGoBackToMessages(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FnVerifyMessagesPage(driver,runManagerInfoObj);
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

	

}