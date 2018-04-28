package com.charter.sb.testscripts;

import org.openqa.selenium.WebDriver;

import com.charter.sb.beans.RunManagerInfo;
import com.charter.sb.controllers.Initialization;
import com.charter.sb.services.CharterAppFunctions;
import com.charter.sb.services.ConcurrentSBnetUXService;
import com.charter.sb.utils.CommonFunctions;
import com.charter.sb.utils.ReportingFunctions;
import com.charter.sb.utils.RunManager;

public class ConcurrentSBnetUX extends Initialization {
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	public static boolean blnFlag = false;
	long startTime = System.currentTimeMillis();
	long endtime = System.currentTimeMillis();
	ConcurrentSBnetUXService ux=new ConcurrentSBnetUXService();
	
	public synchronized void Q1LogoutQ2Login(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			System.out.println("Before running test scripts" + startTime);
			 
			 
					 
			String Username = m1.get("AppUser").toString();
			repfn.FnUpdateTestStepResHTML("Login using V1 user",
					"Logged in using V1 user:" + Username, "PASS",runManagerInfoObj);

			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;

					case 1 :
						blnFlag = ux.Q1Logout(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.CommonLogoutNavigateTohomePage(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = ux.FN_LoginUsingQ1_Q2User(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = ux.FnOverviewPageV2(driver,runManagerInfoObj);
						break;

				/*
				 * case 4: blnFlag=app.FN_CommonLoginWithoutReports(); break;
				 */

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
	public synchronized void Q2LogoutQ1Login(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			 
			 
					 
			String Username = m1.get("AppUser").toString();
			repfn.FnUpdateTestStepResHTML("Login using V2 user",
					"Logged in using V2 user:" + Username, "PASS",runManagerInfoObj);

			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;

					case 1 :
						blnFlag = ux.Q2Logout(driver,runManagerInfoObj);
						break;

					case 2 :
						blnFlag = app.CommonLogoutNavigateTohomePage(driver,runManagerInfoObj);
						break;

					case 3 :
						blnFlag = ux.FN_LoginUsingQ1_Q2User(driver,runManagerInfoObj);
						break;

					case 4 :
						blnFlag = app.FnOverviewPageV1(driver,runManagerInfoObj);
						break;
				/*
				 * case 4: blnFlag=app.FN_CommonLoginWithoutReports(); break;
				 */
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
	public synchronized void UnauthenticatedUser(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			System.out.println("Before running test scripts" + startTime);
			 
			 
					 

			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = ux.fn_unauthenticatedUser(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = ux.SpectrumLogoClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.Loginarrow(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.LoginUser(driver,runManagerInfoObj);
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
	public synchronized void HeaderChange(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			System.out.println("Before running test scripts" + startTime);
			 
			 
					 

			for (int iCount = 0; iCount < 2; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = ux.HeaderChanges(driver,runManagerInfoObj);
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
	public synchronized void Sprint31_V1Support(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			 
			 
					 
			String Username = m1.get("AppUser").toString();
			repfn.FnUpdateTestStepResHTML("Login using V1 user",
					"Logged in using V1 user:" + Username, "PASS",runManagerInfoObj);

			for (int iCount = 0; iCount < 4; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = app.FnOverviewPageV1(driver,runManagerInfoObj);
						break;

					case 2 :
						blnFlag = ux.V1_Support(driver,runManagerInfoObj);
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
	public synchronized void Sprint31_V2Support(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			 
			 
					 
			String Username = m1.get("AppUser").toString();
			repfn.FnUpdateTestStepResHTML("Login using V2 user",
					"Logged in using V2 user:" + Username, "PASS",runManagerInfoObj);
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
						blnFlag = ux.V2_Support(driver,runManagerInfoObj);
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
	public synchronized void Sprint31_FN_V2UsersWithoutPhoneService(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
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
						blnFlag = ux.FnCheckVoiceTile(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnManageUserLinkClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = ux.V2UsersWithoutPhoneService(driver,runManagerInfoObj);
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
		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnCom_ThrowException(e,driver);
		}
		//repfn.FnUpdateEndTest(runManagerInfoObj);
	}
	public synchronized void Sprint31_FN_V2UsersWithoutPhoneServiceNewUser(WebDriver driver, RunManagerInfo runManagerInfoObj)
			throws Exception {

		try {
			
			System.out.println("Before running test scripts" + startTime);

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
						blnFlag = ux.FnCheckVoiceTile(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnManageUserLinkClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = ux.V2UsersWithoutPhoneServiceNewUser(driver,runManagerInfoObj);
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
		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnCom_ThrowException(e,driver);
		}
		//repfn.FnUpdateEndTest(runManagerInfoObj);
	}
	/*
	 * Verify if the user is able to access Phone options from Manage users page
	 * Created by Manavi Date : 9/12/2015
	 */

	public synchronized void Sprint31_FN_VerifyPhoneService_ManageUser_NoVoiceService(WebDriver driver, RunManagerInfo runManagerInfoObj)
			throws Exception {
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
						blnFlag = ux.FnVerifyServiceManageUsers_WithNoVoiceService(driver,runManagerInfoObj);
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

}