package com.charter.sb.testscripts;

import org.openqa.selenium.WebDriver;

import com.charter.sb.beans.RunManagerInfo;
import com.charter.sb.controllers.Initialization;
import com.charter.sb.services.CharterAppFunctions;
import com.charter.sb.services.OverviewService;
import com.charter.sb.utils.CommonFunctions;
import com.charter.sb.utils.ReportingFunctions;
import com.charter.sb.utils.RunManager;

public class Overview extends Initialization {
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	public static boolean blnFlag = false;
	long startTime = System.currentTimeMillis();
	long endtime = System.currentTimeMillis();
	OverviewService os=new OverviewService();
	
	
	/*
	 * Overview Applications > Notification Panel_Account Owner,Overview
	 * Applications > Notification Panel_Admin,Overview Applications >
	 * Notification Panel_Billing User,Overview Applications > Notification
	 * Panel_Standard User Created by Jhansi Date : Dec 9,2015 TC Name:1-4
	 * TC#:1-4 Iteration4 Method:Sprint30_FN_OvwApp_NotificationPanel_User
	 */

	public synchronized void Sprint30_FN_OvwApp_NotificationPanel_User(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = os.Fn_User_NotificationPanel(driver,runManagerInfoObj);
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
	 * Overview Applications > Notification Panel_Account Owner,Overview
	 * Applications > Notification Panel_Admin,Overview Applications >
	 * Notification Panel_Billing User Created by Jhansi Date : Dec 9,2015 TC
	 * Name:1-3 TC#:1-3 Iteration4
	 * Method:Sprint30_FN_OvwApp_NotificationPanel_NoMsg
	 */

	public synchronized void Sprint30_FN_OvwApp_NotificationPanel_NoMsg(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = os.Fn_User_NotificationPanel_NoMsg(driver,runManagerInfoObj);
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
	public synchronized void Sprint30_PastDueAdminUser(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = app.PastDue_AdminUser(driver,runManagerInfoObj);
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
		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnCom_ThrowException(e,driver);
		}
		//repfn.FnUpdateEndTest(runManagerInfoObj);
	}
	/*
	 * To verify if Notifications panel in Overview page is displaying the
	 * correct number of Unread messagesCreated By: PriyankaCreated On:
	 * 12-16-2015
	 */

	public synchronized void Voice_Notifications_MultipleVoiceLine(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = os.Voice_MoreThanOneLine(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case 3");
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case 4");
						blnFlag = app.Voice_Line1(driver,runManagerInfoObj);
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
	 * Function: This script will verify if No Notifications to Display message
	 * is displayed when there are no Notifications Created By: Priyanka Created
	 * On: 12/7/2015
	 */
	public synchronized void Sprint30_FN_Voice_NoNotifications(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = os.Fn_User_NotificationPanel_NoMsg(driver,runManagerInfoObj);
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
	 * Verify whether Spectrum Business Logo routes to the Index page. Created
	 * by Manavi Date : 28/11/2015
	 */

	public synchronized void Sprint35_FN_VerifySBLogoClickNavigation_NonLoggedInUser(WebDriver driver, RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			  
			  
					  
			for (int iCount = 0; iCount < 10; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = os.FnVerifyAndClickLoginLink(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = os.FnVerifyAndClickSpectrumBusinessLogo(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.CommonLogoutNavigateTohomePage(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = os.FnVerifyAndClickRegisterAccountLink(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = os.FnVerifyAndSpectrumBusinessLogoClick(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = os.FnVerifyIndexPage(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FnVerifyNewTabOpenedOnSupportClick(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = os.FnVerifyAndClickSpectrumBusinessLogoSupportPage(driver,runManagerInfoObj);
						break;
					case 9 :
						blnFlag = os.FnVerifyIndexPage(driver,runManagerInfoObj);
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
	 * Verify whether Spectrum Business Logo routes to the Index page. Created
	 * by Manavi Date : 28/11/2015
	 */

	public synchronized void Sprint35_FN_VerifySBLogoClickNavigation_LoggedInUser(WebDriver driver, RunManagerInfo runManagerInfoObj)
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
						blnFlag = os.FnVerifyAndSpectrumBusinessLogoClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = os.FnVerifyIndexPage(driver,runManagerInfoObj);
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

	public synchronized void Overview_PayBillButton(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = os.FnVerifyPayBillButtonNavigation(driver,runManagerInfoObj);
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
	public synchronized void Overview_AutoPayDisabledAccount(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = os.FnVerifyNotificationSection(driver,runManagerInfoObj);
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
	public synchronized void Overview_EnrollAutoPayLink(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = os.FnVerifyEnrollAutoPayButtonNavigation(driver,runManagerInfoObj);
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
	public synchronized void Overview_ViewStatementsLink(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = os.FnVerifyViewStatementsLinkNavigation(driver,runManagerInfoObj);
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
	public synchronized void Overview_ViewPaymentHistorysLink(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			  
			  
					  
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1:
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = os.FnVerifyPaymentHistoryLinkNavigation(driver,runManagerInfoObj);
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
	public synchronized void Overview_VerifyAutoPayIcon(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = os.FnVerifyAutoPayIconNavigation(driver,runManagerInfoObj);
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
	public synchronized void Overview_VerifyManageAutoPayLink(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			  
			  
					  
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1:
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = os.FnVerifyManageAutoPayLinkNavigation(driver,runManagerInfoObj);
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
	public synchronized void Overview_AutoPayeEnabledAccount(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = os.FnVerifyNotificationSections(driver,runManagerInfoObj);
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
	public synchronized void Overview_VerifySectionsDisplayed(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = os.FnVerifySectionsDisplayed(driver,runManagerInfoObj);
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
}