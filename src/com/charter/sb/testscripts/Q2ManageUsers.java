package com.charter.sb.testscripts;

import org.openqa.selenium.WebDriver;

import com.charter.sb.beans.RunManagerInfo;
import com.charter.sb.controllers.Initialization;
import com.charter.sb.services.CharterAppFunctions;
import com.charter.sb.services.Q2ManageUsersService;
import com.charter.sb.utils.CommonFunctions;
import com.charter.sb.utils.ReportingFunctions;
import com.charter.sb.utils.RunManager;

public class Q2ManageUsers extends Initialization {
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	public static boolean blnFlag = false;
	long startTime = System.currentTimeMillis();
	long endtime = System.currentTimeMillis();
	Q2ManageUsersService q2=new Q2ManageUsersService();
	
	
	/*
	 * Verify if the user is able to view a list of all users associated with
	 * the account. Created by Saranya Date : 9/15/2015
	 */
	public synchronized void Sprint29_ManageUserList(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			 
			 
					 
			for (int iCount = 0; iCount < 4; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnManageUserLinkClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = q2.FnUserNameListVerification(driver,runManagerInfoObj);
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

	/*
	 * Verify the display details of the user list associated with the account
	 * Created by Saranya Date : 9/15/2015
	 */
	public synchronized void Sprint29_ManageUserListDetails(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			 
			 
					 
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnManageUserLinkClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = q2.FnUserNameListVerification(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = q2.FnUserRoleListVerification(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = q2.FnUserServiceListVerification(driver,runManagerInfoObj);
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
	 * Verify the display details of the user list associated with the account
	 * Created by Saranya Date : 9/15/2015
	 */
	public synchronized void Sprint29_ManageUserArrowDetailLinkPopUp(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			 
			 
					 
			for (int iCount = 0; iCount < 4; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnManageUserLinkClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = q2.FnUSerDetailLinkPopup(driver,runManagerInfoObj);
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
	/*
	 * Verify the UI of the User details window. Created by Saranya Date :
	 * 9/16/2015
	 */
	public synchronized void Sprint29_ManageUserArrowDetailLinkPopUpDetails(WebDriver driver, RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			 
			 
					 
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnManageUserLinkClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = q2.FnSelectUser(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = q2.FnUSerDetailLinkPopup_DetailCheck(driver,runManagerInfoObj);
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
	 * Verify the UI of the User details window. Created by Saranya Date :
	 * 9/16/2015
	 */
	public synchronized void Sprint29_ManageUserEditModeUIVerification(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			 
			 
					 
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnManageUserLinkClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = q2.FNEditUserUSer_Admin(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = q2.FNEditUserUserCheck_Admin(driver,runManagerInfoObj);
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
	 * Verify if the Admin is able to modify the permissions of the selected
	 * user Created by Saranya Date : 9/16/2015
	 */
	public synchronized void Sprint29_AdminUserRoleChange(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			 
			 
					 
			String Username = m1.get("AppUser").toString();
			repfn.FnUpdateTestStepResHTML("Login using Admin User ",
					"Logged in Using  Admin User: " + Username, "PASS",runManagerInfoObj);

			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnManageUserLinkClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = q2.FNEditUserUSer_Admin(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = q2.FnAdminRoleChange(driver,runManagerInfoObj);
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
	 * Verify if the Admin is able to modify the permissions of the selected
	 * user Created by Saranya Date : 9/16/2015
	 */
	public synchronized void Sprint29_AdminUserNameChange(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			 
			 
					 
			String Username = m1.get("AppUser").toString();
			repfn.FnUpdateTestStepResHTML("Login using Admin User ",
					"Logged in Using  Admin User: " + Username, "PASS",runManagerInfoObj);

			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnManageUserLinkClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = q2.FNEditUserUSer_Admin(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = q2.FnAdminUserNameChange(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = q2.FnUserNameVerificationAfterChange(driver,runManagerInfoObj);
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
	 * Verify if the user is able to view a list of all users associated with
	 * the account. Created by Saranya Date : 12/9/2015
	 */
	public synchronized void Sprint29_ManageUserList_SortingOrderCheck(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			 
			 
					 
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnManageUserLinkClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = q2.FnUserNameListVerification(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = q2.FN_ManagerUserName_SortingA_Z(driver,runManagerInfoObj);
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
	public synchronized void Sprint30_ManageUsers_DeleteUserCancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			 
			 
					 

			for (int iCount = 0; iCount < 5; iCount++) {

				switch (iCount) {

					case 0 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						System.out.println("Case 2");
						blnFlag = app.FnManageUserLinkClick(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case 3");
						blnFlag = app.FNManageusers_UserClick(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case 4");
						blnFlag = q2.FNManageusers_EditandDeleteClick(driver,runManagerInfoObj);
						break;
					case 4 :
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

}