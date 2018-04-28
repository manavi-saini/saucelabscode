package com.charter.sb.testscripts;

import org.openqa.selenium.WebDriver;

import com.charter.sb.beans.RunManagerInfo;
import com.charter.sb.controllers.Initialization;
import com.charter.sb.services.CharterAppFunctions;
import com.charter.sb.services.ManageUsersService;
import com.charter.sb.utils.CommonFunctions;
import com.charter.sb.utils.ReportingFunctions;
import com.charter.sb.utils.RunManager;

public class ManageUsers extends Initialization {
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	public static boolean blnFlag = false;
	long startTime = System.currentTimeMillis();
	long endtime = System.currentTimeMillis();
	ManageUsersService mu=new ManageUsersService();
	
	public synchronized void Sprint29_Fn_createNewUserAssignVoiceServiceCancelAtStep3(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
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
						blnFlag = app.FnManageUserClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnClickAddNewUser(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.fnProfileData(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.fnSelectRole(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = mu.fnManageVoiceCancel(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
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
	public synchronized void Sprint29_Fn_createNewUserAssignVoiceServiceBackAtStep3(WebDriver driver, RunManagerInfo runManagerInfoObj)
			throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
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
						blnFlag = app.FnManageUserClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnClickAddNewUser(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.fnProfileData(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.fnSelectRole(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = mu.fnManageVoiceBack(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
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
	/**
	 * Gurleen 17-11-2015 Manage Users Cancel Changes
	 * 
	 */
	public synchronized void Sprint29_ManageUsers_Modify_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						System.out.println("Case 2");
						blnFlag = app.FnManageUserLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case 3");
						blnFlag = app.FNManageusers_UserClick(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case 4");
						blnFlag = mu.FNManageusers_EditClick(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case 5");
						blnFlag = mu.FNManageusers_EditCancelClick(driver,runManagerInfoObj);
						break;
					case 6 :
						System.out.println("Case 6");
						blnFlag = mu.FNManageusers_EditClick(driver,runManagerInfoObj);
						break;
					case 7 :
						System.out.println("Case 7");
						blnFlag = mu.FNManageusers_EditChangesCancel(driver,runManagerInfoObj);
						break;
					case 8 :
						System.out.println("Case 9");
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
	public synchronized void Sprint29_Fn_ManageUsersSearch(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
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
						blnFlag = app.FnManageUsers(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = mu.fnManageUsersSearch(driver,runManagerInfoObj);
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
		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnCom_ThrowException(e,driver);
		}
		//repfn.FnUpdateEndTest(runManagerInfoObj);
	}
	/*
	 * Function: This script is used to select a permission in step-2 of create
	 * new user, cancel it, again cancel in the confirmation popup and then
	 * confirm the cancel Created By: Priyanka Created On: 19-11-2015
	 */

	public synchronized void FN_CreateNewUser_step2_CancelTwice(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = mu.FN_NewUser_step2_Cancelclick(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = mu.FN_NewUser_step2_Confirmationpopup_Cancelclick(driver,runManagerInfoObj);
						break;
					case 9 :
						blnFlag = mu.FN_NewUser_step2_Cancelclick(driver,runManagerInfoObj);
						break;
					case 10 :
						blnFlag = mu.FN_NewUser_step2_Confirmationpopup_Confirmclick(driver,runManagerInfoObj);
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
	/*
	 * Function: This script is used to select a permission in step-2 of create
	 * new user, cancel it, again cancel in the confirmation popup and then
	 * confirm the cancel Created By: Priyanka Created On: 19-11-2015
	 */

	public synchronized void FN_CreateNewUser_step2_BackClick(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = mu.FN_NewUser_step2_BackButton(driver,runManagerInfoObj);
						break;
					case 8 :
						System.out.println("Case 10");
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
	 * Verify that the Account Owner/ Administrator user is in Step 4 of
	 * creating a New User and cancel Created by Manavi Date : 27/11/2015
	 */

	public synchronized void Sprint29_FN_CreateNewUser_Step4_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			 
			 
					 
			for (int iCount = 0; iCount < 10; iCount++) {
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
						blnFlag = app.FnClickAddNewUser(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = mu.FnFillUserDetailsTabOne(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = mu.FnFillUserDetailsTabTwo(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = mu.FnFillUserDetailsTabThree(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = mu.FnFillUserDetailsTabFour_Cancel(driver,runManagerInfoObj);
						break;
					case 8 :
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
	 * Verify that the Account Owner/ Administrator user is in Step 4 of
	 * creating a New User and click on <Back Created by Manavi Date :
	 * 27/11/2015
	 */

	public synchronized void Sprint29_FN_CreateNewUser_Step4_Back(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = app.FnManageUserClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnClickAddNewUser(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = mu.FnFillUserDetailsTabOne(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = mu.FnFillUserDetailsTabTwo(driver,runManagerInfoObj);
						break;
					case 6:
						blnFlag = mu.FnFillUserDetailsTabThree(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = mu.FnFillUserDetailsTabFour_Back(driver,runManagerInfoObj);
						break;
					case 8 :
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
	 * Verify if the Account owner or admin is able to successfully delete a
	 * user from the list. Created by Manavi Date : 19/11/2015
	 */

	public synchronized void Sprint30_FN_DeleteUser_Admin(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = app.FnManageUserClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = mu.FnGetManageUsersList(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = mu.FnEditLink_ManagerUser(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = mu.FnDeleteUser(driver,runManagerInfoObj);
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
	public synchronized void Sprint30_Fn_createNewUserAssignVoiceService(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
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
						blnFlag = app.FnManageUsers(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnClickAddNewUser(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.fnProfileData(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.fnSelectRole(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.fnManageVoice(driver,runManagerInfoObj);
						break;
					case 7:
						blnFlag = mu.fnManageConfirm(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
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
	public synchronized void Sprint30_Fn_createNewUserAssignVoiceServiceSkip(WebDriver driver, RunManagerInfo runManagerInfoObj)
			throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
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
						blnFlag = app.FnManageUsers(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnClickAddNewUser(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.fnProfileData(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.fnSelectRole(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = mu.fnManageVoiceSkip(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = mu.fnManageConfirmSkip(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
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
	 * Function: This script is used to Verify that the Account Owner/
	 * Administrator user is in Step 3 of creating a New User and skips the step
	 * before making any changes Created By: Priyanka Created On: 18-11-2015
	 */

	public synchronized void FN_CreateNewUser_SkipStep3_BeforeChanges(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			 
			 
					 
			for (int iCount = 0; iCount < 13; iCount++) {
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
						blnFlag = mu.FN_NewUser_step3_UI(driver,runManagerInfoObj);
						break;
					case 9 :
						blnFlag = mu.FnSkipButtonClick(driver,runManagerInfoObj);
						break;
					case 10 :
						blnFlag = mu.FnConfirmbuttonClickdummy(driver,runManagerInfoObj);
						break;
					case 11 :
						blnFlag = mu.FN_sucessMessageVerificationdummy(driver,runManagerInfoObj);
						break;
					case 12 :
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
	 * GURLEEN Verify if the Account owner or the Administrator has an option to
	 * delete users from the system
	 */
	public synchronized void Sprint30_ManageUsers_DeleteUserOption(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						System.out.println("Case 2");
						blnFlag = app.FnManageUserLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case 3");
						blnFlag = app.FNManageusers_UserClick(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case 4");
						blnFlag = mu.FNManageusers_EditClickDeleteOption(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case 5");
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
	/*
	 * iteration 4 SPRINT 30 TC-80 Verify the delete option on trying to delete
	 * an Account owner from the user list by the account owner *
	 */
	public synchronized void Sprint30_ManageUsers_DeleteAccountOwner_AccountOwner(WebDriver driver, RunManagerInfo runManagerInfoObj)
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
						System.out.println("Case 2");
						blnFlag = app.FnManageUserLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case 3");
						blnFlag = mu.FNManageusers_AccountOwner(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case 4");
						blnFlag = mu.FNManageusers_EditClickDeleteCheck(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case 5");
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

	public synchronized void Sprint30_ManageUsers_DeleteAccountOwner_AdminUser(WebDriver driver, RunManagerInfo runManagerInfoObj)
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
						System.out.println("Case 2");
						blnFlag = app.FnManageUserLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case 3");
						blnFlag = mu.FNManageusers_AccountOwner(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case 4");
						blnFlag = mu.FNManageusers_EditClickDeleteCheck(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case 5");
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

	public synchronized void Sprint30_ManageUsers_DeleteAdminByAccOwner(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						System.out.println("Case 2");
						blnFlag = app.FnManageUserLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case 3");
						blnFlag = mu.FNManageusers_Admin(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case 4");
						blnFlag = mu.FNManageusers_EditandDeleteOption(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case 5");
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
	public synchronized void Sprint30_ManageUsers_DeleteAdminByAdmin(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						System.out.println("Case 2");
						blnFlag = app.FnManageUserLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case 3");
						blnFlag = mu.FNManageusers_Admin(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case 4");
						blnFlag = mu.FNManageusers_EditandDeleteOption(driver,runManagerInfoObj);
						break;
					case 5:
						System.out.println("Case 5");
						blnFlag = mu.FNManageusers_AdminUser(driver,runManagerInfoObj);
						break;
					case 6 :
						System.out.println("Case 6");
						blnFlag = mu.FNManageusers_EditClickDeleteCheck_user(driver,runManagerInfoObj);
						break;
					case 7 :
						System.out.println("Case 7");
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
	public synchronized void Sprint30_Fn_manageUsersEditUser_ModifyContactInformation(WebDriver driver, RunManagerInfo runManagerInfoObj)
			throws Exception {

		try {
			
			 
			System.out.println("Before running test scripts" + startTime);
			 
					 

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
						blnFlag = app.FnManageUsers(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = mu.FnManageUsersEditUser_ModifyContactInformation(driver,runManagerInfoObj);
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
		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnCom_ThrowException(e,driver);
		}
		//repfn.FnUpdateEndTest(runManagerInfoObj);
	}
	/*
	 * Verify if the Admin is able to modify the permissions of the selected
	 * user. Created by Manavi Date : 26/11/2015
	 */

	public synchronized void Sprint30_FN_ModifyUserPermissions_Admin(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = app.FnManageUserClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = mu.FnGetManageUsersList(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = mu.FnEditLink_ManagerUser(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = mu.FnModifyUserPermissions(driver,runManagerInfoObj);
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
	public synchronized void Sprint30_Fn_EditUserUniqueEmailID(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
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
						blnFlag = app.FnManageUsers(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = mu.fnEditUserUniqueEmailID(driver,runManagerInfoObj);
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
		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnCom_ThrowException(e,driver);
		}
		//repfn.FnUpdateEndTest(runManagerInfoObj);
	}
	public synchronized void Sprint30_Fn_manageUsersEditUser_UserDetails(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
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
						blnFlag = app.FnManageUsers(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = mu.FnManageUsersEditUser_UserDetails(driver,runManagerInfoObj);
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
		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnCom_ThrowException(e,driver);
		}
		//repfn.FnUpdateEndTest(runManagerInfoObj);
	}
	/*
	 * Verify the UI of the User details window. Gurleen
	 */

	public synchronized void Sprint30_ManageUsers_EditUserUI(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						System.out.println("Case 2");
						blnFlag = app.FnManageUserLinkClick(driver,runManagerInfoObj);
						break;

					case 3 :
						System.out.println("Case 3");
						blnFlag = app.FNManageusers_UserClick(driver,runManagerInfoObj);
						break;

					case 4 :
						System.out.println("Case 4");
						blnFlag = mu.FNManageusers_EditClick(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case 5");
						blnFlag = mu.FNManageusers_EditUI(driver,runManagerInfoObj);
						break;
					case 6 :
						System.out.println("Case 6");
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
	/*
	 * Verify the UI of the User details window. Gurleen
	 */

	public synchronized void Sprint30_ManageUsers_EditUserEditUI(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						System.out.println("Case 2");
						blnFlag = app.FnManageUserLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case 3");
						blnFlag = app.FNManageusers_UserClick(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case 4");
						blnFlag = mu.FNManageusers_EditClick(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case 5");
						blnFlag = mu.FNManageusers_Edit_EditUserUI(driver,runManagerInfoObj);
						break;
					case 6 :
						System.out.println("Case 6");
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
	/*
	 * Verify that the Account Owner/ Administrator user is in Step 3 of
	 * creating a New User and click on <Back before making any changes Created
	 * by Manavi Date : 7/12/2015
	 */

	public synchronized void Sprint30_FN_CreateNewUser_Step4_Back(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = app.FnManageUserClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnClickAddNewUser(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = mu.FnFillUserDetailsTabOne(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = mu.FnFillUserDetailsTabTwo(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = mu.FnFillUserDetailsTabThree_Back(driver,runManagerInfoObj);
						break;
					case 7 :
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
	 * Gurleen
	 */
	public synchronized void Sprint30_ManageUsers_ResetPassword(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						System.out.println("Case 2");
						blnFlag = app.FnManageUserLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case 3");
						blnFlag = mu.FNManageusers_ResetPassword(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case 4");
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
	public synchronized void FN_ManageUser_Edit_CancelTwice(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
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
						blnFlag = app.FnManageUsers(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = mu.ManageUsers_FirstUserclick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = mu.ManageUsers_editLinkclick(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = mu.FnManageUsersEditUser_ModifyInfo(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = mu.FN_ManageUsers_close(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = mu.FN_ManageUsers_Cancel(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = mu.FN_ManageUsers_close(driver,runManagerInfoObj);
						break;
					case 9 :
						blnFlag = mu.FN_ManageUsers_Confirm(driver,runManagerInfoObj);
						break;
					case 10 :
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
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
}