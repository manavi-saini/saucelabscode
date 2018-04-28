package com.charter.sb.testscripts;

import org.openqa.selenium.WebDriver;

import com.charter.sb.beans.RunManagerInfo;
import com.charter.sb.controllers.Initialization;
import com.charter.sb.services.CharterAppFunctions;
import com.charter.sb.services.UiVerificationService;
import com.charter.sb.utils.CommonFunctions;
import com.charter.sb.utils.ReportingFunctions;
import com.charter.sb.utils.RunManager;

public class UiVerification extends Initialization {
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	public static boolean blnFlag = false;
	long startTime = System.currentTimeMillis();
	long endtime = System.currentTimeMillis();
	UiVerificationService us=new UiVerificationService();
	

	public synchronized void VerifyLinks_AccountOwner(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

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
						blnFlag = us.HeaderLinks_Authenticated(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case2");
						blnFlag = us.LogoutUser(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case2");
						blnFlag = app.Loginarrow(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case2");
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
	public synchronized void VerifyLogin_UnAuthenticatedUser(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			 
			 
					  

			for (int iCount = 0; iCount < 4; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						System.out.println("Case1");
						blnFlag = app.Verifylogin(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case1");
						blnFlag = app.LoginUser(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case1");
						blnFlag = us.LogoutUser(driver,runManagerInfoObj);
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

	public synchronized void VerifyLinks_UnAuthenticatedUser(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			 
			 
					  

			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						System.out.println("Case1");
						blnFlag = app.Verifylogin(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case1");
						blnFlag = us.UserRecovery(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case1");
						blnFlag = app.Loginarrow(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case1");
						blnFlag = us.CreateNewId(driver,runManagerInfoObj);
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

	public synchronized void Sprint30_VerifySupportLinkNavigation(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						System.out.println("Case1");
						blnFlag = app.FnVerifyNewTabOpenedOnSupportClick(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case1");
						blnFlag = us.FN_FooterLinkClick(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case1");
						blnFlag = us.FnVerifySupportLinkNavigation_Footer(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case1");
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
	// to verify if Footer Links are consistent across all pages//

	public synchronized void FooterLinkssharedpages(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			 
			 
					  

			for (int iCount = 0; iCount < 4; iCount++) {

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
						blnFlag = us.FooterLinks_AllPages(driver,runManagerInfoObj);
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
	// To verify the navigation of each link in the footer//

	public synchronized void FN_FooterSectionVerificationLinks(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = us.FN_FooterLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = us.FN_FooterLinkManageAccountSectionClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = us.FN_FooterLinkCharterCorporateSectionClick(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = us.FN_FooterLinkSupportSectionClick(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = us.FN_FooterLinkClick(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = us.FN_FooterSectionclick(driver,runManagerInfoObj);
						break;
					case 9 :
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
	 * Verify the UI of Footer - Expanded View for as any SB.net Standard user
	 * in V1/V2/CMS/Shared pages. Created by Manavi Date : 9/12/2015
	 */

	public synchronized void Sprint30_FN_VerifyFooterLinks_StandardUser(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = us.FnVerifyFooterLinks_StandardUser(driver,runManagerInfoObj);
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
	 * Verify Footer - Expanded view for as any unauthenticated user in
	 * V1/V2/CMS/Shared pages. Created by Manavi Date : 9/12/2015
	 */

	public synchronized void Sprint30_FN_VerifyFooterLinks_UnAuthenticatedUser(WebDriver driver, RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			 
			 
					  
			for (int iCount = 0; iCount < 2; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = us.FnVerifyFooterLinks_UnAuthenticatedUser(driver,runManagerInfoObj);
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
	 * Verify the UI of Footer - Expanded View for as any SB.net Admin user in
	 * V1/V2/CMS/Shared pages. Created by Manavi Date : 10/12/2015
	 */

	public synchronized void Sprint30_FN_VerifyFooterLinks_AdminUser(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = us.FnVerifyFooterLinks_AdminUser(driver,runManagerInfoObj);
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
	 * Verify the UI of Footer - Expanded View as any SB.net Billing user in
	 * V1/V2/CMS/Shared pages Created by Manavi Date : 10/12/2015
	 */

	public synchronized void Sprint30_FN_VerifyFooterLinks_BillingUser(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = us.FnVerifyFooterLinks_BillingUser(driver,runManagerInfoObj);
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
	 * This script is used to verify header links for authenticated user other
	 * than account number Created By: Priyanka Created On: 12-10-2015
	 */
	public synchronized void FN_NotAccountOwner_HeaderUI(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 3; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = us.Authenticated_UI(driver,runManagerInfoObj);
						break;
				/*
				 * case 2: blnFlag= app.CommonLogout(driver,runManagerInfoObj); break;
				 */
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
	 * This function is used to verify the Header UI of an unauthenticated user
	 * Created On: 12-11-2015 Created By: Priyanka
	 */
	public synchronized void FN_V2_VerifyUI_UnAuthenticatedUser(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		
		try {
			 
			 
					  

			for (int iCount = 0; iCount < 3; iCount++) {

				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;

					case 1 :
						System.out.println("Case1");
						blnFlag = us.HeaderLinks(driver,runManagerInfoObj);
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
	public synchronized void FN_FooterSection_CollapsedView_UI(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = us.FN_FooterLinkClick(driver,runManagerInfoObj);
						break;

					case 3 :
						blnFlag = us.FN_PrivatePolicies(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = us.FN_TermsOfService(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = us.FN_LinkedIn(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = us.FN_Facebook(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = us.FN_Twitter(driver,runManagerInfoObj);
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
	public synchronized void Sprint30_Fn_headerAuthenticatedUserUI(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount <= 3; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = us.fnHeaderAuthenticatedUserUI(driver,runManagerInfoObj);
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
	public synchronized void HeaderSupport(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			System.out.println("Before running test scripts" + startTime);
			 
			 
					  

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
						blnFlag = us.HeaderSupport(driver,runManagerInfoObj);
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
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}
	/*
	 * Header changes - V1 only> Authenticated user UI_Account owner Created by
	 * Jhansi Date : 12/28/2015
	 */

	public synchronized void Sprint31_FN_Header_V1_AuthenticatedUser_AccountOwner(WebDriver driver, RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			 
			 
					  
			for (int iCount = 0; iCount < 4; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;

					case 1 :
						blnFlag = us.Fn_HeaderUI(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.CommonLogoutNavigateTohomePage(driver,runManagerInfoObj);
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