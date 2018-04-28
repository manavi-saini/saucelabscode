package com.charter.sb.testscripts;

import org.openqa.selenium.WebDriver;

import com.charter.sb.beans.RunManagerInfo;
import com.charter.sb.controllers.Initialization;
import com.charter.sb.services.CharterAppFunctions;
import com.charter.sb.services.ViewStatementsService;
import com.charter.sb.utils.CommonFunctions;
import com.charter.sb.utils.ReportingFunctions;
import com.charter.sb.utils.RunManager;

public class ViewStatements extends Initialization {
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	public static boolean blnFlag = false;
	long startTime = System.currentTimeMillis();
	long endtime = System.currentTimeMillis();
	ViewStatementsService vs=new ViewStatementsService();
	
	public synchronized void Sprint27_FN_VerifyStdUser_ViewStatements(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {

		try {

			
			for (int iCount = 0; iCount < 4; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVerifyBillingLink(driver,runManagerInfoObj);
						break;
					case 3 :
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
	public synchronized void Sprint27_FN_taxesAndFees(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVerifyAndClickBillingLink(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = vs.FnTaxesandFees(driver,runManagerInfoObj);
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
		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnCom_ThrowException(e,driver);
		}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
	}
	public synchronized void Sprint27_FN_paymentReceived(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVerifyAndClickBillingLink(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = vs.FnPaymentReceived(driver,runManagerInfoObj);
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
		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnCom_ThrowException(e,driver);
		}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
	}
	public synchronized void Sprint27_FN_payBillButton(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVerifyAndClickBillingLink(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = vs.FNPayBillButtonClick(driver,runManagerInfoObj);
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
		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnCom_ThrowException(e,driver);
		}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
	}

	public synchronized void Sprint27_FN_VerifyLearnMoreTaxesAndFees(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
		
					
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVerifyAndClickBillingLink(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = vs.FnLearnMoreinTaxesAndFees(driver,runManagerInfoObj);
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

	/**
	 * Gurleen
	 */
	public synchronized void Sprint27_FN_ViewStatements_ChargeDetail_SubSection_Tooltip(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			
		
					
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.Fn_Ovw_ViewStatements(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = vs.Fn_ChargeDetails_ToolTip(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = vs.Fn_ViewStatementsOkClick(driver,runManagerInfoObj);
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
	 * Gurleen
	 */
	public synchronized void Sprint27_FN_ViewStatements_ChargeDetail_TotalAmount(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			
		
					
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.Fn_Ovw_ViewStatements(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = vs.Fn_ViewStatementsTotalAmount(driver,runManagerInfoObj);
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
	 * Verify that the Modal window is diaplyed on click of learn more icon.
	 * Created by Neha Punia Date : 24/11/2015
	 */

	public synchronized void Sprint27_FN_VerifyDefaultViewStatement(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
					
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnBilling(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = vs.FnVerifyDefaultView(driver,runManagerInfoObj);
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
	 * Verify that user is able to view the Charge Details section in the View
	 * Statements screen Created by Jhansi Date : Nov 25,2015 TC Name:View
	 * Statements > Charge Details TC#:88 Iteration 3
	 * Method:Sprint27_FN_ViewStatements_ChargeDetailsSec
	 */
	public synchronized void Sprint27_FN_ViewStatements_ChargeDetailsSec(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			for (int iCount = 0; iCount < 4; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.Fn_Ovw_ViewStatements(driver,runManagerInfoObj);
						break;
					case 3 :
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
	 * Verify that user is able to view the Charge Details sub sections section
	 * in the View Statements screen Created by Jhansi Date : Nov 25,2015 TC
	 * Name:View Statements > Charge Details> sub sections TC#:89 Iteration 3
	 * Method:Sprint27_FN_ViewStatements_ChargeDetail_SubSection
	 */
	public synchronized void Sprint27_FN_ViewStatements_ChargeDetail_SubSection(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
					
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.Fn_Ovw_ViewStatements(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = vs.Fn_ChargeDetails_SubSection(driver,runManagerInfoObj);
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
	 * Verify the details of each subsections for the Line of Business products
	 * Created by Jhansi Date : Nov 2,2015 TC Name:View Statements > Charge
	 * Details> sub sections> Details TC#:90 Iteration3
	 * Method:Sprint27_FN_ViewStatements_ChargeDetail_SubSection_Details
	 */
	public synchronized void Sprint27_FN_ViewStatements_ChargeDetail_SubSection_Details(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
		
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.Fn_Ovw_ViewStatements(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = vs.Fn_ChargeDetails_SpectrumInet_Details(driver,runManagerInfoObj);
						break;
					/*case 4 :
						blnFlag = vs.Fn_ChargeDetails_SpectrumTV_Details(driver,runManagerInfoObj);
						break;*/
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
	 * Verify the details of each Phone details Created by Jhansi Date : Nov
	 * 27,2015 TC Name:View Statements > Charge Details> sub sections >Phone
	 * Details TC#:91 Iteration3
	 * Method:Sprint27_FN_ViewStatements_ChargeDetail_PhoneDetails
	 */
	public synchronized void Sprint27_FN_ViewStatements_ChargeDetail_PhoneDetails(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
		
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.Fn_Ovw_ViewStatements(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = vs.Fn_ChargeDetails_Phone_Details(driver,runManagerInfoObj);
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
	 * Verifying the details of the View Statement screen for the current
	 * statement Created by Harpreet Kaur Date : Nov 26,2015
	 */
	public synchronized void Sprint27_FN_verify_CurrentStatementUI(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
		
					
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnBilling(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = vs.FnVerifyViewStatementPage(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = vs.FnVerifyCurrentStatementUI(driver,runManagerInfoObj);
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
	public synchronized void Sprint27_FN_verify_PreviousStatementUI(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
		
					
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnBilling(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = vs.FnVerifyViewStatementPage(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = vs.FnVerifyPreviousStatementUI(driver,runManagerInfoObj);
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
	 * Verify the export call log presence Created by Jhansi Date : Nov 28,2015
	 * TC Name:View Statements > Charge Details> sub sections> Phone
	 * Details>export call log TC#:92 Iteration3
	 * Method:Sprint27_FN_ViewStatements_ChargeDetail_Phone_ExportCallLog
	 */

	public synchronized void Sprint27_FN_ViewStatements_ChargeDetail_Phone_ExportCallLog(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
		
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.Fn_Ovw_ViewStatements(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = vs.Fn_ChargeDetails_Phone_ExportCallLog_Presence(driver,runManagerInfoObj);
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
	public synchronized void Sprint27_Fn_autoPayEnabledAccount(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 9; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnPayBillLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = vs.FnAutoPay_UsingCreditCard_Step1(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = vs.FnAutoPay_UsingCreditCard_Step2_Step3(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.FnBilling(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = vs.FnautoPayEnabledAccount(driver,runManagerInfoObj);
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
		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnCom_ThrowException(e,driver);
		}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
	}
	/*
	 * Verify that for the top 50 rate codes that the user sees a tooltip
	 * Created by Manavi Date : 8/12/2015
	 */

	public synchronized void Sprint27_FN_VerifyToolTip_Services(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
		
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVerifyAndClickBillingLink(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = vs.FnVerifyToolTip(driver,runManagerInfoObj);
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
	 * Verify that the statement selector, download statement, & export call log
	 * options are available in the universal toolbar Created by Manavi Date :
	 * 8/12/2015
	 */

	public synchronized void Sprint27_FN_VerifyUniversalToolbarOptions(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
		
					
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVerifyAndClickBillingLink(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = vs.FnVerifyUniversalToolbarOptions(driver,runManagerInfoObj);
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
	public synchronized void Sprint27_FN_VerifyViewStatementScreen_Services(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVerifyAndClickBillingLink(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = vs.FnVerifyStatementScreen(driver,runManagerInfoObj);
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
	public synchronized void Sprint28_FN_ChargeDetailsLineOfBusiness(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnBilling(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = vs.FnLineOfBusiness(driver,runManagerInfoObj);
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
		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnCom_ThrowException(e,driver);
		}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
	}
	/*
	 * View Statements > Charge Details>Line of Business>Triple play Customer
	 * Created by Saranya Date : 12/16/2015
	 */

	public synchronized void Sprint28_FN_ViewStatements_ChargeDetail_SubSection_TriplePlay(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
		
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.Fn_Ovw_ViewStatements(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = vs.Fn_ChargeDetails_SubSection(driver,runManagerInfoObj);
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
	 * View Statements > Charge Details>Line of Business>Single subscription
	 * customer Created by Saranya Date : 12/16/2015
	 */
	public synchronized void Sprint28_FN_ViewStatements_ChargeDetail_SubSection_SinglePlay(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			
		
					
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.Fn_Ovw_ViewStatements(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = vs.Fn_ChargeDetails_SubSection_SingleSubscription(driver,runManagerInfoObj);
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
	 * View Statements > Charge Details>Line of Business>Combo customer Created
	 * by Saranya Date : 12/16/2015
	 */
	public synchronized void Sprint28_FN_ViewStatements_ChargeDetail_SubSection_DoublePlay(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			
		
					
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.Fn_Ovw_ViewStatements(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = vs.Fn_ChargeDetails_SubSection_DoubleSubscription(driver,runManagerInfoObj);
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
	 * Verify that export logs option gets displayed for phone numbers
	 * associated with the account Created by Saranya Date : 12/17/2015
	 */

	public synchronized void Sprint31_FN_ExportCallLogs_ExportPopUp(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
		
					
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
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
	 * Verify that the total amount displayed for Charter Business services
	 * includes all of the Lines of Business the user is subscribed to Created
	 * by Saranya Date : 12/17/2015
	 */

	public synchronized void Sprint28_FN_ChargeDetail_TotalAmount_Details(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
		
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.Fn_Ovw_ViewStatements(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = vs.Fn_ChargeDetails_SpectrumInet_AmountDetails(driver,runManagerInfoObj);
						break;
					/*case 4 :
						blnFlag =vs.Fn_ChargeDetails_SpectrumTV_AmountDetails(driver,runManagerInfoObj);
						break;*/
					case 5 :
						blnFlag = vs.Fn_ChargeDetails_SpectrumPhone_AmountDetails(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = vs.Fn_ChargeDetails_TotalAmountDetails(driver,runManagerInfoObj);
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
	 * View Statements >Auto Pay enabled> UI Created by Saranya Date :
	 * 12/17/2015
	 */

	public synchronized void Sprint28_FN_verify_AutopayUI_CurrentStateMentUI(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			
		
					
			for (int iCount = 0; iCount < 4; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = vs.AutopayEnroll(driver,runManagerInfoObj);
						break;

					case 3 :
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
	public synchronized void Sprint28_FN_payBillButton(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVerifyAndClickBillingLink(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnClickPayBillOption(driver,runManagerInfoObj);
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
		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnCom_ThrowException(e,driver);
		}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
	}
	public synchronized void Sprint28_FN_paymentReceived(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVerifyAndClickBillingLink(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = vs.FnPaymentReceived(driver,runManagerInfoObj);
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
		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnCom_ThrowException(e,driver);
		}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
	}

	/*
	 * Verifying the details of the View Statement screen for the current
	 * statement Created by Saranya Date : 12/10/2015
	 */
	public synchronized void Sprint28_FN_verify_CurrentStatementUI(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
		
					
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVerifyAndClickBillingLink(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = vs.FnVerifyCurrentStatementUI(driver,runManagerInfoObj);
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
	 * Verifying the details of the View Statement screen for the Previous
	 * statement Created by Saranya Date : 12/10/2015
	 */
	public synchronized void Sprint28_FN_verify_PreviousStatementUI(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
		
					
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnBilling(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = vs.FnVerifyViewStatementPage(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = vs.FnVerifyPreviousStatementUI(driver,runManagerInfoObj);
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
	public synchronized void Sprint28_FN_chargeDetails(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnBilling(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = vs.FnTaxesandFees(driver,runManagerInfoObj);
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
		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnCom_ThrowException(e,driver);
		}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
	}
	/*
	 * 
	 * Gurleen
	 */
	public synchronized void ViewStatements_DefaultView(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
		
					

			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						System.out.println("Case1");
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case 2");
						blnFlag = vs.Fn_ViewStatements(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case 3");
						blnFlag = vs.Fn_ViewStatements_DefaultView(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case 4");
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
	 * 
	 * Gurleen
	 */

	public synchronized void ViewStatements_UniversalToolbar(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			
			

			for (int iCount = 0; iCount < 5; iCount++) {

				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						System.out.println("Case1");
						blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case 2");
						blnFlag = vs.Fn_ViewStatements(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case 3");
						blnFlag = vs.Fn_ViewStatements_UniversalToolbar(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case 4");
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
