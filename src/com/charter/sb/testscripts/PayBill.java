package com.charter.sb.testscripts;

import org.openqa.selenium.WebDriver;

import com.charter.sb.beans.RunManagerInfo;
import com.charter.sb.controllers.Initialization;
import com.charter.sb.services.CharterAppFunctions;
import com.charter.sb.services.PaybillService;
import com.charter.sb.utils.CommonFunctions;
import com.charter.sb.utils.ReportingFunctions;
import com.charter.sb.utils.RunManager;

public class PayBill extends Initialization {
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	PaybillService pb=new PaybillService();
	public static boolean blnFlag = false;
	long startTime = System.currentTimeMillis();
	long endtime = System.currentTimeMillis();

	/*
	 * Verify if standard users have access to bill payment Created by Manavi
	 * Date : 16/11/2015
	 */

	public synchronized void Sprint27_FN_VerifyStdUser_PayBill(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {

		try {

			
			for (int iCount = 0; iCount < 4; iCount++) {
				switch (iCount) {
					case 0 :
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVerifyBillingLink(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = pb.FnPayBillLink(driver,runManagerInfoObj);
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
	public synchronized void Sprint27_FN_BillPay_OptionsUI(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0 :
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnBilling(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = pb.FnBillPayOptionsTab(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = pb.FnBillPayOptionsUI(driver,runManagerInfoObj);
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
	public synchronized void Sprint27_FnVerifyPayBillUI_CheckingSaving(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 7; iCount++) {
				switch (iCount) {
					case 0 :
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnPayBillLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FnClickOneTime_Checking_SavingsOption(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = pb.FnVerifyPayBillUI_CheckingSaving(driver,runManagerInfoObj);
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
	 * Billing > Pay Bill screen > One Time Checking/Savings > Verify Payment
	 * Information Screen Created by Jhansi Date : Dec 9,2015 TC Name:Billing >
	 * Pay Bill screen > One Time Checking/Savings > Verify Payment Information
	 * Screen TC#:34 Iteration3
	 * Method:Sprint27_PayBill_OTP_CheckingSavings_VerifyPaymentInfo
	 */
	public synchronized void Sprint27_PayBill_OTP_CheckingSavings_VerifyPaymentInfo(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		
		try {
			
			
					

			for (int iCount = 0; iCount < 7; iCount++) {
				switch (iCount) {
					case 0 :
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
						blnFlag = app.FnClickPayBillOption(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = pb.OTP_CheckingsSavings_FillDetails(driver,runManagerInfoObj);
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

	public synchronized void Sprint27_Fn_invalidAccountAndValidRoutingNumber(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnPayBillLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FnClickOneTime_Checking_SavingsOption(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = pb.FnInvalidAccountAndValidRoutingNumber(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.FnVerify_PayBillButton_Disabled(driver,runManagerInfoObj);
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
	

	public synchronized void PayBill_CompletePayment(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		
		try {
			
			
					

			for (int iCount = 0; iCount < 7; iCount++) {

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
						System.out.println("Case2");
						blnFlag = app.FnVerifyAndClickBillingLink(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case3");
						blnFlag = app.FnClickPayBillOption(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case3");
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case4");
						blnFlag = pb.Paybill_completePaymentconfirm(driver,runManagerInfoObj);
						break;
					case 6 :
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
	// Priyanka[17-11-2015]
	// this script completes payment and checks the content in Payment
	// confirmation screen and returns to overview//

	public synchronized void PayBill_CompletePayment_ReturnToOverview(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		
		try {
			
			
					

			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0 :
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
						
						blnFlag = app.FnClickPayBillOption(driver,runManagerInfoObj);
						break;
					case 4 :
						
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 5 :
						
						blnFlag = pb.Paybill_completePaymentconfirm_Overview(driver,runManagerInfoObj);
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
	// Priyanka[18-11-2015]//
	/*
	 * This script will navigate the user to Support page from Verify your
	 * payment page
	 */

	public synchronized void PayBill_VerifyPayment_NavigateToSupport(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		
		try {
			
			
					

			for (int iCount = 0; iCount < 7; iCount++) {

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
						System.out.println("Case2");
						blnFlag = app.FnVerifyAndClickBillingLink(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case3");
						blnFlag = app.FnClickPayBillOption(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case4");
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case5");
						blnFlag = pb.Paybill_VerifyPayment_support(driver,runManagerInfoObj);
						break;
					case 6 :
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
	 * Verify that the routing number field accept only 9-digit numbers. Created
	 * by Manavi Date : 3/11/2015
	 */

	public synchronized void Sprint27_FN_RoutingNumberValidation(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
				case 0 :
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnPayBillLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FnClickOneTime_Checking_SavingsOption(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = pb.FnValidateRoutingNumber(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.FnVerify_PayBillButton_Disabled(driver,runManagerInfoObj);
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
	 * Verify that the Bank Account number field accepts only numbers. Created
	 * by Manavi Date : 16/11/2015
	 */

	public synchronized void Sprint27_FN_BankAccountNumberValidation(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
				case 0 :
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnPayBillLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FnClickOneTime_Checking_SavingsOption(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = pb.FnValidateBankAccountNumber(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.FnVerify_PayBillButton_Disabled(driver,runManagerInfoObj);
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
	 * Verify the error display on entry of invalid payment amount in the pay
	 * bill page Created by Manavi Date : 16/11/2015
	 */

	public synchronized void Sprint27_FN_PaymentAmountFieldValidation(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnPayBillLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FnClickOneTime_Checking_SavingsOption(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = pb.FnValidatePaymentAmountField(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.FnVerify_PayBillButton_Disabled(driver,runManagerInfoObj);
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
	 * Verify that clicking on support link takes the user to the support page
	 * for payment options Created by Manavi Date : 17/11/2015
	 */

	public synchronized void Sprint27_FN_VerifySupportLink_CheckingSavings(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {

		try {

			
			
			
					
			for (int iCount = 0; iCount < 7; iCount++) {
				switch (iCount) {
					case 0 :
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnPayBillLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FnClickOneTime_Checking_SavingsOption(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = pb.FnVerifyClickSupportLink(driver,runManagerInfoObj);
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
	 * Verify that clicking on support link takes the user to the support page
	 * for payment options Created by Manavi Date : 17/11/2015
	 */

	public synchronized void Sprint27_FN_VerifySupportLink_CreditDebit(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {

		try {

			
			
			
					
			for (int iCount = 0; iCount < 7; iCount++) {
				switch (iCount) {
					case 0 :
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnPayBillLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FnClickOneTime_Credit_Debit_Option(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = pb.FnVerifyClickSupportLink(driver,runManagerInfoObj);
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
	 * Verify whether error message is getting displayed Created by Manavi Date
	 * : 17/11/2015
	 */

	public synchronized void Sprint27_FN_VerifyPayNow_InvalidRouting_ValidAccount(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {

		try {

			
			
			
					
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnPayBillLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FnClickOneTime_Checking_SavingsOption(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = pb.FnValidateInvalidRouting_ValidAccount(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.FnVerify_PayBillButton_Disabled(driver,runManagerInfoObj);
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
	 * Verify that the Bank Account number field accepts only numbers. Created
	 * by Harpreet Kaur Date : 16/11/2015
	 */

	public synchronized void Sprint27_FN_Verify_InvalidPaymentAmount(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnPayBillLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FnClickOneTime_Checking_SavingsOption(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = pb.FnValidatePaymentAmountLimit(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.FnVerify_PayBillButton_Disabled(driver,runManagerInfoObj);
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
	public synchronized void Sprint27_Fn_creditOrDebit_errorMessage_invalidCard(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 9; iCount++) {
				switch (iCount) {
					case 0 :
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
						blnFlag = app.FnClickPayBillOption(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FnClickOneTime_Credit_Debit_Option(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = pb.fnCreditOrDebitErrorMessageInvalidCard(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FnVerify_PayBillButton_Disabled(driver,runManagerInfoObj);
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
	public synchronized void Sprint27_Fn_creditOrDebit_errorMessage_cardValidation(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 9; iCount++) {
				switch (iCount) {
					case 0 :
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
						blnFlag = app.FnClickPayBillOption(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FnClickOneTime_Credit_Debit_Option(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = pb.fnCreditOrDebitErrorMessageCardValidation(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FnVerify_PayBillButton_Disabled(driver,runManagerInfoObj);
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
	 * Verify that an error message gets displayed when one of the required
	 * fields is left blank Created by Harpreet Kaur Date :20/11/2015
	 */

	public synchronized void Sprint27_Fn_PayBill_BlankFieldsValidations(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 11; iCount++) {
				switch (iCount) {
					case 0 :
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnPayBillLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FnClickOneTime_Checking_SavingsOption(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = pb.FnBlank_Routing_Number(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = pb.FnBlank_Account_Number(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = pb.FnBlank_PaymentAmount(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = pb.FnBlank_PaymentDate(driver,runManagerInfoObj);
						break;
					case 9 :
						blnFlag = app.FnVerify_PayBillButton_Disabled(driver,runManagerInfoObj);
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
	/*
	 * Verify that on clicking 'Edit Payment Details' takes the user back to the
	 * payment information screen to edit payment details Created by Manavi Date
	 * : 24/11/2015
	 */

	public synchronized void Sprint27_FN_VerifyEditPayment_PayBill(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {

		try {

			
			
			
					
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnPayBillLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FnClickOneTime_Checking_SavingsOption(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = pb.FnValidateEditPaymentOption(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = pb.FnClickPayBillButtonAndVerify(driver,runManagerInfoObj);
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
	 * Verify that an error message gets displayed when one of the required
	 * fields is left blank Created by Manavi Date : 24/11/2015
	 */

	public synchronized void Sprint27_FN_BlankFieldsValidation_PayBill(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {

		try {

			
			
			
					
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnPayBillLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FnClickOneTime_Credit_Debit_Option(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = pb.FnValidateBlankCardFields(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.FnVerify_PayBillButton_Disabled(driver,runManagerInfoObj);
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
	 * Verify that on clicking 'Edit Payment Details' takes the user back to the
	 * payment information screen to edit payment details Created by Manavi Date
	 * : 24/11/2015
	 */

	public synchronized void Sprint27_FN_VerifyEditPayment_PayBill_Credit_Debit(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {

		try {

			
			
			
					
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnPayBillLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FnClickOneTime_Credit_Debit_Option(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = pb.FnValidateEditPaymentOption_Credit_Debit(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = pb.FnClickPayBillButtonAndVerify_Credit_Debit(driver,runManagerInfoObj);
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
	public synchronized void Sprint27_FN_BillPay_Options_Save(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0 :
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
						blnFlag = pb.FnBillPayOptionsTab(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = pb.FnBillPayOptions_Save(driver,runManagerInfoObj);
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
	 * Verify if the user is able to select a previous date for the payment in
	 * the pay bill page Created by Harpreet Kaur Date : 24/11/2015
	 */

	public synchronized void Sprint27_Fn_PayBill_DateFieldsValidations(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 14; iCount++) {
				switch (iCount) {
					case 0 :
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnPayBillLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FnClickOneTime_Checking_SavingsOption(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = pb.FnEnterValid_Routing_Account_Number(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = pb.FnEnterPaymentAmount(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = pb.Fn_VerifyPaymentDateField_PreviousDate(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = app.FnVerify_PayBillButton_Disabled(driver,runManagerInfoObj);
						break;
					case 9 :
						blnFlag = pb.Fn_VerifyPaymentDateField_CurrentDate(driver,runManagerInfoObj);
						break;
					case 10 :
						blnFlag = pb.FnVerifyPayBill_Button(driver,runManagerInfoObj);
						break;
					case 11 :
						blnFlag = app.Fn_VerifyPaymentDateField_FutureDate(driver,runManagerInfoObj);
						break;
					case 12 :
						blnFlag = pb.FnVerifyPayBill_Button(driver,runManagerInfoObj);
						break;
					case 13 :
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
	 * Verify if the user is able to select a previous date for the payment in
	 * the pay bill page Created by Harpreet Kaur Date : 24/11/2015
	 */

	public synchronized void Sprint27_Fn_PayBill_DateFieldsValidation(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 14; iCount++) {
				switch (iCount) {
					case 0 :
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnPayBillLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FnClickOneTime_Credit_Debit_Option(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = pb.FnEnterValidCardDetails(driver,runManagerInfoObj);
						break;

					case 6 :
						blnFlag = pb.FnEnterPaymentAmount(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = pb.Fn_VerifyPaymentDateField_PreviousDate(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = app.FnVerify_PayBillButton_Disabled(driver,runManagerInfoObj);
						break;
					case 9 :
						blnFlag = pb.Fn_VerifyPaymentDateField_CurrentDate(driver,runManagerInfoObj);
						break;
					case 10 :
						blnFlag = pb.FnVerifyPayBill_Button(driver,runManagerInfoObj);
						break;
					case 11 :
						blnFlag = app.Fn_VerifyPaymentDateField_FutureDate(driver,runManagerInfoObj);
						break;
					case 12 :
						blnFlag = pb.FnVerifyPayBill_Button(driver,runManagerInfoObj);
						break;
					case 13 :
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
	 * Verify that the Bank Account number field accepts only numbers. Created
	 * by Harpreet Kaur Date : 17/11/2015
	 */

	public synchronized void Sprint27_FN_Verify_PaymentAmount(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 10; iCount++) {
				switch (iCount) {
					case 0 :
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnPayBillLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FnClickOneTime_Checking_SavingsOption(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = pb.FnEnterValid_Routing_Account_Number(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = pb.FnEnterPaymentAmount(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = pb.FnEnterPaymentDate(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = pb.FnClickPayBillButton_ConfirmNavigation(driver,runManagerInfoObj);
						break;
					case 9 :
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
	public synchronized void Sprint27_Fn_checkingOrSavings_validAccountAndRoutingNumber(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 10; iCount++) {
				switch (iCount) {
					case 0 :
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnPayBillLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FnClickOneTime_Checking_SavingsOption(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = pb.FnEnterValid_Routing_Account_Number(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = pb.FnEnterPaymentAmount(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = pb.FnEnterPaymentDate(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = pb.FnClickPayBillButton_ConfirmNavigation(driver,runManagerInfoObj);
						break;
					case 9 :
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
	public synchronized void Sprint27_Fn_checkingOrSavings_oneTimePaymentConfirmation(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 7; iCount++) {
				switch (iCount) {
					case 0 :
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
						blnFlag = app.FnClickPayBillOption(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = pb.fnCheckingOrSavingsOneTimePaymentConfirmation(driver,runManagerInfoObj);
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
		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
		repfn.FnCom_ThrowException(e,driver);
		}
		//repfn.FnUpdateEndTest(runManagerInfoObj);
	}
	public synchronized void Sprint27_Fn_creditOrDebit_errorMessage_invalidExpirationDate(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 10; iCount++) {
				switch (iCount) {
					case 0 :
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
						blnFlag = app.FnClickPayBillOption(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FnClickOneTime_Credit_Debit_Option(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.EditCreditCard(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = pb.fnCreditOrDebitErrorMessageinvalidExpirationDate(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = pb.FnVerify_PayBillButtonDisabled(driver,runManagerInfoObj);
						break;
					case 9 :
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
	 * Verify that the Bank Account number field accepts only numbers. Created
	 * by Neha Punia Date : 17/11/2015
	 */

	public synchronized void Sprint27_FN_PaymentAmountValidations(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnPayBillLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FnClickOneTime_Credit_Debit_Option(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = pb.FnPaymentAmountFieldValidation(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = pb.FnVerify_PayBillButtonDisabled(driver,runManagerInfoObj);
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
	 * Verifying the display of payment amount and due date when the user has a
	 * credit balance in the View Statements screen. Created by Manavi Date :
	 * 28/11/2015
	 */

	public synchronized void Sprint27_FN_VerifyCreditPayment_DueDate(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0 :
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVerifyDueDate(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnVerifyAndClickBillingLink(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = pb.FnVerifyCreditBalanceDue(driver,runManagerInfoObj);
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
	 * Verify the UI of pay bill screen Created by Manavi Date : 28/11/2015
	 */

	public synchronized void Sprint27_FN_VerifyPayBill_UI(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0 :
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnPayBillLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = pb.FnVerifyPayBillUI(driver,runManagerInfoObj);
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
	 * Verify that if the user is displayed with view statement page on clicking
	 * view details link Created by Manavi Date : 28/11/2015
	 */

	public synchronized void Sprint27_FN_VerifyViewStatementsNavigation(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0 :
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnPayBillLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = pb.FnVerifyAndClickViewStatementsLink(driver,runManagerInfoObj);
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
	 * Verify that Credit/Debit Card option is selected as the default payment
	 * option Created by Manavi Date : 28/11/2015
	 */

	public synchronized void Sprint27_FN_VerifyDefaultSelection_PaymentType(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0 :
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnPayBillLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = pb.FnVerifyDefaultSelection_PaymentType(driver,runManagerInfoObj);
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
	 * Verify that the auto pay option is greyed out with an "x" in replace of
	 * the radio button when user is delinquent in their balance Created by
	 * Manavi Date : 30/11/2015
	 */

	public synchronized void Sprint27_FN_VerifyAutoPayDisabledAndMessage(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0 :
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnPayBillLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = pb.FnVerifyAutoPayOption(driver,runManagerInfoObj);
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
	public synchronized void Sprint27_FnVerifyPayBillUI_CreditDebit(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 7; iCount++) {
				switch (iCount) {
					case 0 :
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnPayBillLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FnClickOneTime_Credit_Debit_Option(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = pb.FnVerifyPayBillUI_CreditDebit(driver,runManagerInfoObj);
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
	public synchronized void Sprint27_FnCreditDebitUI_RequiredFieldsIndicator(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 7; iCount++) {
				switch (iCount) {
					case 0 :
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnPayBillLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FnClickOneTime_Credit_Debit_Option(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = pb.FnVerifyCreditDebitUI_RequiredFields(driver,runManagerInfoObj);
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
	 * Verify that clicking on support link takes the user to the support page
	 * for payment options Created by Manavi Date : 7/12/2015
	 */

	public synchronized void Sprint27_FN_VerifySupportLink_EditPayment(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {

		try {

			
			
			
					
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnPayBillLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FnClickOneTime_Checking_SavingsOption(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = pb.FnValidateEditPaymentOption(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = pb.FnVerifySupportLink_PaymentVerification(driver,runManagerInfoObj);
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
	public synchronized void Sprint27_Fn_checkingOrSavings_HelpIcon(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
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
						blnFlag = app.FnClickPayBillOption(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FnClickOneTime_Checking_SavingsOption(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = pb.fncheckingOrSavingsHelpIcon(driver,runManagerInfoObj);
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
	public synchronized void Sprint27_Fn_overpaidCurrentBill(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 7; iCount++) {
				switch (iCount) {
					case 0 :
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
						blnFlag = app.FnClickPayBillOption(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = pb.fnOverpaidCurrentBill(driver,runManagerInfoObj);
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
		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
		repfn.FnCom_ThrowException(e,driver);
		}
		//repfn.FnUpdateEndTest(runManagerInfoObj);
	}
	public synchronized void Sprint27_FnCheckingSavingUI_RequiredFieldsIndicator(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 7; iCount++) {
				switch (iCount) {
					case 0 :
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnPayBillLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FnClickOneTime_Checking_SavingsOption(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = pb.FnVerifyCheckingSaving_RequiredFields(driver,runManagerInfoObj);
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
	public synchronized void Sprint28_FN_BillPayOptionsUI(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0 :
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
						blnFlag = pb.FnBillPayOptionsTab(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = pb.FnBillPayOptionsUI(driver,runManagerInfoObj);
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
	public synchronized void Sprint28_FN_BillPay_Options_Cancel(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0 :
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
						blnFlag = pb.FnBillPayOptionsTab(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = pb.FnBillPayOptions_cancel(driver,runManagerInfoObj);
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
	public synchronized void Sprint28_FN_BillPayOptions_OnlineAndPaperBillToOnlineBillSave(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0 :
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
						blnFlag = pb.FnBillPayOptionsTab(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = pb.FnBillPayOptions_PaperAndOnlineBillToOnlineBillSave(driver,runManagerInfoObj);
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
	public synchronized void Sprint28_FnBillPayOptions_OnlineToPaperAndOnlineBillSave(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0 :
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
						blnFlag = pb.FnBillPayOptionsTab(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = pb.FnBillPayOptions_OnlineToPaperAndOnlineBillSave(driver,runManagerInfoObj);
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

	public synchronized void Sprint28_Fn_checkingOrSavings_AutoPayPaymentConfirmation(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
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
						blnFlag = app.FnClickPayBillOption(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FnClickAutoPay_Checking_Saving_Option(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = pb.fnCheckingOrSavingsAutoPayPaymentConfirmation(driver,runManagerInfoObj);
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
	/*
	 * Verifying if the user has the option to know the Other Payment Methods
	 * Created by Manavi Date : 8/12/2015
	 */

	public synchronized void Sprint28_FN_OtherPaymentOptionsUI(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 7; iCount++) {
				switch (iCount) {
					case 0 :
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
						blnFlag = app.FnClickPayBillOption(driver,runManagerInfoObj);
						break;
					/*
					 * case 1: blnFlag= app.FnBilling(driver,runManagerInfoObj); break; case 2: blnFlag=
					 * app.fnPayBillTab(driver,runManagerInfoObj); break;
					 */
					case 4 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = pb.FnVerifyOtherPaymentOptionsUI(driver,runManagerInfoObj);
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
	public synchronized void Sprint28_Fn_checkingOrSavings_AutoPayPaymentUI(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
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
						blnFlag = app.FnClickPayBillOption(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FnClickAutoPay_Checking_Saving_Option(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = pb.fnCheckingOrSavingsAutoPayPaymentUI(driver,runManagerInfoObj);
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
	public synchronized void Sprint28_Fn_checkingOrSavingsRequiredField(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
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
						blnFlag = app.FnClickPayBillOption(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FnClickAutoPay_Checking_Saving_Option(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = pb.fnCheckingOrSavingsRequiredField(driver,runManagerInfoObj);
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
	public synchronized void Sprint28_Fn_creditOrDebit_AutoPay_errorMessage(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 9; iCount++) {
				switch (iCount) {
					case 0 :
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
						blnFlag = app.FnClickPayBillOption(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FnClickAutoPay_Credit_Debit_Option(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = pb.fnCreditOrDebitAutoPayErrorMessage(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FnVerify_PayBillButton_Disabled(driver,runManagerInfoObj);
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
	 * My Profile>Security Settings>Password>Required fields Created by Saranya
	 * Date : 12/16/2015
	 */
	
	/*
	 * Verify if standard users have access to view their BillPayOptions Created
	 * by Saranya Date : 12/16/2015
	 */

	public synchronized void Sprint28_FN_Billing_StandardUser(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 3; iCount++) {
				switch (iCount) {
					case 0 :
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = pb.FnBilling_Standard(driver,runManagerInfoObj);
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
	public synchronized void Sprint28_Fn_autoPayCheckingSavingsTC(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
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
						blnFlag = app.FnClickPayBillOption(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FnClickAutoPay_Checking_Saving_Option(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = pb.fnCheckingOrSavingsAutoPayPaymentConfirmation_WithoutTC(driver,runManagerInfoObj);
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
	public synchronized void Sprint28_Fn_autoPayCreditCardTC(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
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
						blnFlag = app.FnClickPayBillOption(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FnClickAutoPay_Credit_Debit_Option(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = pb.fnCreditDebitAutoPayPaymentConfirmation_WithoutTC(driver,runManagerInfoObj);
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
	public synchronized void Sprint28_Fn_autoPayCheckingSavingsSupportLink(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 9; iCount++) {
				switch (iCount) {
					case 0 :
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
						blnFlag = app.FnClickPayBillOption(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FnClickAutoPay_Checking_Saving_Option(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = pb.FnValidateEditPaymentOption_AutoPay(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = pb.fnAutoPayCreditCardSupportLink(driver,runManagerInfoObj);
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
	public synchronized void Sprint28_AutoPay_UIValidation(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
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
						blnFlag = app.FnClickPayBillOption(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FnClickAutoPay_Credit_Debit_Option(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = pb.Autopay_UI(driver,runManagerInfoObj);
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
	 * Billing > Pay Bill screen > Auto Pay Credit Card > Verify error message
	 * displayed on invalid card Created by Saranya Date : 12/18/2015
	 */

	public synchronized void Sprint28_Fn_creditOrDebit_AutoPay_InvalidCardNo_ErrorMSG(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 9; iCount++) {
				switch (iCount) {
					case 0 :
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
						blnFlag = app.FnClickPayBillOption(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FnClickAutoPay_Credit_Debit_Option(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = pb.fnCreditOrDebitAutoPayErrorMessage(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FnVerify_PayBillButton_Disabled(driver,runManagerInfoObj);
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
	 * Verify that an error message gets displayed when one of the required
	 * fields is left blank Created by Saranya Date : 12/18/2015
	 */

	public synchronized void Sprint28_Fn_cnCreditOrDebitAutoPayBlankFeild_ErrorMessage(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 9; iCount++) {
				switch (iCount) {
					case 0 :
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
						blnFlag = app.FnClickPayBillOption(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FnClickAutoPay_Credit_Debit_Option(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = pb.FnValidateBlankCardFields(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FnVerify_PayBillButton_Disabled(driver,runManagerInfoObj);
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
	 * Billing > Pay Bill screen > Auto Pay Credit Card > Auto Pay
	 * confirmation_Return to Overview Created by Saranya Date : 12/18/2015
	 */

	public synchronized void Sprint28_Fn_Credit_Debit_AutoPayPaymentConfirmation(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
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
						blnFlag = app.FnClickPayBillOption(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FnClickAutoPay_Credit_Debit_Option(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = pb.fnCreditDebitAutoPayPaymentConfirmation(driver,runManagerInfoObj);
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
	public synchronized void Sprint28_FN_VerifySupportLink_PaymentInformation(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {

		try {

			
			
			
					
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
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
						blnFlag = app.FnClickPayBillOption(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FnClickAutoPay_Credit_Debit_Option(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = pb.FnVerifyClickSupportLink(driver,runManagerInfoObj);
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
	 * Verifying if the user has the option to know the Other Payment Methods
	 * Created by Manavi Date : 8/12/2015
	 */

	public synchronized void Sprint28_FN_OtherPayment_VerifyPaymentFrequency(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 7; iCount++) {
				switch (iCount) {
					case 0 :
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					/*
					 * case 1: blnFlag=app.FnVerifyAndClickBillingLink(driver,runManagerInfoObj); break;
					 * case 2: blnFlag=app.FnClickPayBillOption(driver,runManagerInfoObj); break;
					 */
					case 2 :
						blnFlag = app.FnBilling(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.fnPayBillTab(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.fnCancelAutoPay(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = pb.FnVerifyPaymentFrequency_OtherPaymentSelected(driver,runManagerInfoObj);
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

	public synchronized void Sprint30_PastDueAdminUser(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 4; iCount++) {
				switch (iCount) {
					case 0 :
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
}
