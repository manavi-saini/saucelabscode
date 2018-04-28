package com.charter.sb.testscripts;

import org.openqa.selenium.WebDriver;

import com.charter.sb.beans.RunManagerInfo;
import com.charter.sb.controllers.Initialization;
import com.charter.sb.services.CharterAppFunctions;
import com.charter.sb.services.Q2WallOfGardenService;
import com.charter.sb.utils.CommonFunctions;
import com.charter.sb.utils.ReportingFunctions;
import com.charter.sb.utils.RunManager;

public class Q2WallOfGarden extends Initialization {
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	public static boolean blnFlag = false;
	long startTime = System.currentTimeMillis();
	long endtime = System.currentTimeMillis();
	Q2WallOfGardenService qw=new Q2WallOfGardenService();
	
	public synchronized void SignInClick(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			


			for (int iCount = 0; iCount < 3; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = qw.FnNavigateToWallOfGardenURL(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
					break;
				}
			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}

	

	public synchronized void Q2_FinalLogout(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {

			blnFlag = true;
			
			
			for (int iCount = 0; iCount < 2; iCount++) {

				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = qw.Q2_Logout(driver,runManagerInfoObj);
						break;
				/*
				 * case 1: blnFlag=app.CommonLogoutNavigateTohomePage(); break;
				 */

				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
					break;
				}
			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
			driver.close();
			driver.quit();
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}


	

	/*
	 * Verifying the UI of the Sign-in page for Walled Garden flow Created by
	 * Manavi Date : 2/12/2015
	 */

	public synchronized void Q2WallOfGarden_FN_VerifySignInPageUI(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			for (int iCount = 0; iCount < 2; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = qw.FnVerifySignInPageUI(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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
	 * Verify if the account owner is able to sign into the Walled Garden flow
	 * Created by Manavi Date : 2/12/2015
	 */

	public synchronized void Q2WallOfGarden_FN_Login_AccountOwner(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			for (int iCount = 0; iCount < 2; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = app.FnUserLogin_WallOfGarden(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
					m1.put("initialLogin", "FAIL");
					break;
				} else {
					m1.put("initialLogin", "PASS");
				}
			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}

	/*
	 * Verify if Admin user is able to sign into the Walled Garden flow Created
	 * by Manavi Date : 3/12/2015
	 */

	public synchronized void Q2WallOfGarden_FN_Login_AdminUser(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			     
	
			for (int iCount = 0; iCount < 2; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = app.FnUserLogin_WallOfGarden(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
					m1.put("initialLogin", "FAIL");
					break;
				} else {
					m1.put("initialLogin", "PASS");
				}
			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}

	/*
	 * Verify if Billing user is able to sign into the Walled Garden flow
	 * Created by Manavi Date : 3/12/2015
	 */

	public synchronized void Q2WallOfGarden_FN_Login_BillingUser(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			       
			       
				   
			for (int iCount = 0; iCount < 2; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = app.FnUserLogin_WallOfGarden(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
					m1.put("initialLogin", "FAIL");
					break;
				} else {
					m1.put("initialLogin", "PASS");
				}
			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}

	/*
	 * Verify if Standard user is able to sign into the Walled Garden flow
	 * Created by Manavi Date : 3/12/2015
	 */

	public synchronized void Q2WallOfGarden_FN_Login_StandardUser(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			       
			       
				   
			for (int iCount = 0; iCount < 2; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = app.FnUserLogin_WallOfGarden(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
					m1.put("initialLogin", "FAIL");
					break;
				} else {
					m1.put("initialLogin", "PASS");
				}
			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}

	public synchronized void Q2WallOfGarden_Fn_payBillPaymentTypeOptions(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			       
			       
				   
			for (int iCount = 0; iCount < 4; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1:
						blnFlag = qw.Q2Wall_NotificationPage_PayNowbuttonclick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = qw.fnPayBillPaymentTypeOptions(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnNavigateBack_Payment_WG(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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
	public synchronized void Q2WallOfGarden_Fn_payBillPaymentFrequencyOptions(WebDriver driver, RunManagerInfo runManagerInfoObj)
			throws Exception {

		try {
			
			       
			       
				   
			for (int iCount = 0; iCount < 4; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = qw.Q2Wall_NotificationPage_PayNowbuttonclick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = qw.fnPayBillPaymentFrequencyOptions(driver,runManagerInfoObj);
						break;
					case 3:
						blnFlag = app.FnNavigateBack_Payment_WG(driver,runManagerInfoObj);
						break;

				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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
	 * Payment Options > Online Payment > Pay Bill screen > One Time
	 * Checking/Savings > Routing number validation Created by Saranya Date :
	 * 11/12/2015
	 */
	public synchronized void Q2WallOfGarden_FN_RoutingNumberValidation(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			       
			       
				   
			for (int iCount = 0; iCount < 7; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = qw.Q2Wall_NotificationPage_PayNowbuttonclick(driver,runManagerInfoObj);
						break;
					case 2:
						blnFlag = app.FnClickOneTime_Checking_SavingsOption(driver,runManagerInfoObj);
						break;
					case 3:
						blnFlag = qw.Q2Wall_FnValidateRoutingNumber(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = qw.Q2Wall_FnVerifyPayBillButton(driver,runManagerInfoObj);
						break;
					case 5:
						blnFlag = qw.Q2Wall_CancelbuttonClick(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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
	 * Payment Option > Online Payment > Pay Bill screen > One Time
	 * Checking/Savings > Bank Account number validation Created by Saranya Date
	 * : 11/12/2015
	 */
	public synchronized void Q2WallOfGarden_FN_AccountNumberValidation(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			       
			       
				   
			for (int iCount = 0; iCount < 7; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
				
					case 1 :
						blnFlag = qw.Q2Wall_NotificationPage_PayNowbuttonclick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnClickOneTime_Checking_SavingsOption(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = qw.Q2Wall_FnValidateBankAccountNumber(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = qw.Q2Wall_FnVerifyPayBillButton(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = qw.Q2Wall_CancelbuttonClick(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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
	 * This script is to verify the error message displayed when invalid Payment
	 * amount is entered in the PAy Bill screen Created By: Priyanka Created On:
	 * 12-11-2015
	 */
	public synchronized void Q2WallOfGarden_Payamount_Invalid(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			       
			       
				   
			for (int iCount = 0; iCount < 4; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag =qw.Q2Wall_NotificationPage_PayNowbuttonclick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = qw.EditPayAmnt_Errors(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = qw.Q2Wall_CancelbuttonClick(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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
	 * Payment Option > Online Payment > Pay Bill screen > One Time
	 * Checking/Savings > Payment Amount validation Created by Saranya Date :
	 * 11/12/2015
	 */
	public synchronized void Q2WallOfGarden_FN_PaymentAmountValidation(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			       
			       
				   
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = qw.Q2Wall_NotificationPage_PayNowbuttonclick(driver,runManagerInfoObj);
						break;
					case 2:
						blnFlag = app.FnClickOneTime_Checking_SavingsOption(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = qw.Q2Wall_FnValidatePaymentAmount(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = qw.Q2Wall_FnVerifyPayBillButton(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = qw.Q2Wall_CancelbuttonClick(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
					break;
				}
			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}

	// Jhansi
	// Verify pay bill screen
	// Iteration-4
	// Sl#:45

	public synchronized void Q2WallOfGarden_Fn_PayBillScreen(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			       
			       
				   
			for (int iCount = 0; iCount < 4; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = qw.Q2Wall_NotificationPage_PayNowbuttonclick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = qw.VerifyPayBillScreen(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = qw.Q2Wall_CancelbuttonClick(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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
	// Jhansi
	// Verify default payment method
	// Iteration-4
	// Sl#:52

	public synchronized void Q2WallOfGarden_Fn_PayBill_DefaultPaymentType(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			       
			       
				   
			for (int iCount = 0; iCount < 4; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag =qw.Q2Wall_NotificationPage_PayNowbuttonclick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = qw.CreditDebitPaymentOptionDefault(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = qw.Q2Wall_CancelbuttonClick(driver,runManagerInfoObj);
						break;
				}
				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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
	// Jhansi
	// Verify default payment frequency
	// Iteration-4
	// Sl#:53

	public synchronized void Q2WallOfGarden_Fn_PayBill_DefaultPaymentFrequency(WebDriver driver, RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			       
			       
				   
			for (int iCount = 0; iCount < 4; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = qw.Q2Wall_NotificationPage_PayNowbuttonclick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = qw.OTPDefault(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = qw.Q2Wall_CancelbuttonClick(driver,runManagerInfoObj);
						break;

				}
				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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
	 * This script is used to navigate to Verify Payment screen Created By:
	 * Priyanka Created On: 12-12-2015
	 */

	public synchronized void Q2WallOfGarden_VerifyPaymentInfo(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			       
			       
				   
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = qw.Q2Wall_NotificationPage_PayNowbuttonclick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnClickOneTime_Credit_Debit_Option(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag =qw.FnValidateEditPaymentOption_CreditDebit_WG(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = qw.FnClickPayBillButtonAndVerify_CreditDebit_WG(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = qw.Q2Wall_CancelbuttonClick(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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
	 * Payment Option > Online Payment > Pay Bill screen > One Time
	 * Checking/Savings > Blank fields validation Created by Saranya Date :
	 * 12/12/2015
	 */
	public synchronized void Q2WallOfGarden_FN_OneTime_CheckingSavings_BlankErrorMSGValidation(WebDriver driver, RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			       
			       
				   
			for (int iCount = 0; iCount < 9; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1:
						blnFlag = qw.Q2Wall_NotificationPage_PayNowbuttonclick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnClickOneTime_Checking_SavingsOption(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = qw.Q2Wall_FnValidateBlankFeildErrorMsg_RoutingNumber(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = qw.Q2Wall_FnValidateBlankFeildErrorMsg_AccountNumber(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = qw.Q2Wall_FnValidateBlankFeildErrorMsg_PaymentAmount(driver,runManagerInfoObj);
						break;
					case 6:
						blnFlag = qw.Q2Wall_FnValidateBlankFeildErrorMsg_PaymentDate(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = qw.Q2Wall_FnVerifyPayBillButton(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = qw.Q2Wall_CancelbuttonClick(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
					break;
				}
			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}

	public synchronized void Q2WallOfGarden_FN_OneTime_CreditDebit_BlankErrorMSGValidation(WebDriver driver, RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			       
			       
				   
			for (int iCount = 0; iCount < 9; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = qw.Q2Wall_NotificationPage_PayNowbuttonclick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnClickOneTime_Credit_Debit_Option(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag =qw.Q2Wall_FnValidateBlankFeildErrorMsg_CardNumber(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = qw.Q2Wall_FnValidateBlankFeildErrorMsg_ExpiryDate(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = qw.Q2Wall_FnValidateBlankFeildErrorMsg_PaymentAmount(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = qw.Q2Wall_FnValidateBlankFeildErrorMsg_PaymentDate(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = qw.Q2Wall_FnVerifyPayBillButton(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = qw.Q2Wall_CancelbuttonClick(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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
	 * Payment Option > Online Payment > Pay Bill screen > One Time
	 * Checking/Savings > Verify Payment Information Screen Created by Saranya
	 * Date : 12/12/2015
	 */
	public synchronized void Q2Wall_PayBill_OTP_CheckingSavings_VerifyPaymentInfo(WebDriver driver, RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			       
			       
				   
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag =qw.Q2Wall_NotificationPage_PayNowbuttonclick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnClickOneTime_Checking_SavingsOption(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = qw.FnValidateEditPaymentOption_CheckingSavings_WG(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = qw.FnClickPayBillButtonAndVerify_CheckingSavings_WG(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = qw.Q2Wall_CancelbuttonClick(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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
	 * This script is used to verify the Edit Payment link Created By: Priyanka
	 * Created On: 12-12-2015 Modified On: 12-14-2015
	 */

	public synchronized void Q2WallOfGarden_CreditDebit_EditPaymentInfo(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			       
			       
				   
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = qw.Q2Wall_NotificationPage_PayNowbuttonclick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnClickOneTime_Credit_Debit_Option(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = qw.FnValidateEditPaymentOption_CreditDebit_WG(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = qw.FnClickPayBillButtonAndVerify_CreditDebit_WG_EditLink(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = qw.Q2Wall_CancelbuttonClick(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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
	 * This script is used to verify the Edit Payment link Created By: Priyanka
	 * Created On: 12-12-2015 Modified On: 12-14-2015
	 */

	public synchronized void Q2WallOfGarden_CreditDebit_Blankfields_Error(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			       
			       
				   
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = qw.Q2Wall_NotificationPage_PayNowbuttonclick(driver,runManagerInfoObj);
						break;

					case 2 :
						blnFlag = qw.CreditDebit_EmptyAccNo(driver,runManagerInfoObj);
						break;
						
					case 3 :
						blnFlag = qw.CreditDebit_EmptyExpiryDate(driver,runManagerInfoObj);
						break;
					/*
					 * case 4: blnFlag=app.CreditDebit_ExpiryYear(); break; case
					 * 5: blnFlag=app.CreditDebit_PayAmount(); break; case 6:
					 * blnFlag=app.CreditDebit_PayDate(); break; case 7:
					 * blnFlag=app.PayBill_CreditDebit_PayNow(); break;
					 */
					/*
					 * case 8: blnFlag=app.VerifyPay_AllFields(); break;
					 */

					/*
					 * case 8: blnFlag=app.PayBill_CreditDebit_EditPayment();
					 * break;
					 */

					case 4 :
						blnFlag = qw.Q2Wall_CancelbuttonClick(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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
	 * This script is used to verify the mandatory criteria in Forgot Username
	 * page Created By: Priyanka Created On: 12-12-2015
	 */

	public synchronized void Q2WallOfGarden_ForgotUserName_Blankfields(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			       
			       
				   
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
				  
					case 1 :
						blnFlag = qw.Q2_UserRecovery(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = qw.RecoverUserName_Radiobtn(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = qw.Empty(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = qw.Q2Wall_CancelbuttonClick_ConfirmAlert(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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
	 * Verify that a required field indicator (*) appears on the fields that are
	 * required for payment Created by Manavi Date : 14/12/2015
	 */

	public synchronized void Q2WallOfGarden_FN_OneTime_CreditDebit_RequiredFieldsValidation(WebDriver driver, RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			       
			       
				   
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = qw.Q2Wall_NotificationPage_PayNowbuttonclick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = qw.CreditDebitPaymentOptionDefault(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = qw.OTPDefault(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = qw.Q2Wall_ValidateRequiredFieldIndicator(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = qw.Q2Wall_CancelbuttonClick(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
					m1.put("initialLogin", "FAIL");
					break;
				} else {
					m1.put("initialLogin", "PASS");
				}
			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	// Jhansi
	// Location Finder - Verify UI
	// Iteration-4
	// Sl#:42

	public synchronized void Q2WallOfGarden_Fn_LocationFinder_UI(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1:
						blnFlag = qw.FnLocationFinder_UI(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = qw.FnLocationFinderPage_UI(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = qw.Presence_Hdr_Footer_Links(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FnNavigateBack_Payment_WG(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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
	// Jhansi
	// Payment Options - Verify option to pay bill in person
	// Iteration-4
	// Sl#:16

	public synchronized void Q2WallOfGarden_Fn_PaymentOption_InPerson(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			       
			       
				   
			for (int iCount = 0; iCount < 4; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = qw.FnLocationFinder_UI(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = qw.FnLocationFinderPage_Navigation(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnNavigateBack_Payment_WG(driver,runManagerInfoObj);
						break;

				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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
	// Jhansi
	// Payment Options - Verify option to pay using phone
	// Iteration-4
	// Sl#:16

	public synchronized void Q2WallOfGarden_Fn_PaymentOption_Phone(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			       
			       
				   
			for (int iCount = 0; iCount < 3; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = qw.FnPhone_UI(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnNavigateBack_Payment_WG(driver,runManagerInfoObj);
						break;

				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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
	// Jhansi
	// Payment Options - Verify option to pay online
	// Iteration-4
	// Sl#:14

	public synchronized void Q2WallOfGarden_Fn_PaymentOption_PayOnline(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			       
			       
				   
			for (int iCount = 0; iCount < 4; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = qw.FnPayOnline_UI(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = qw.Q2Wall_NotificationPage_PayNowbuttonclick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnNavigateBack_Payment_WG(driver,runManagerInfoObj);
						break;
				}
				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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
	// Jhansi
	// Payment Options - Verify option to mail in the payment
	// Iteration-4
	// Sl#:17

	public synchronized void Q2WallOfGarden_Fn_PaymentOption_Mail(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 3; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = qw.FnMail_UI(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnNavigateBack_Payment_WG(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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
	// Jhansi
	// Payment Options - Verify UI
	// Iteration-4
	// Sl#:17

	public synchronized void Q2WallOfGarden_Fn_PaymentOption_UI(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 7; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = qw.PaymentOption_UI(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = qw.FnPayOnline_UI(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = qw.FnPhone_UI(driver,runManagerInfoObj);
						break;
					case 4:
						blnFlag = qw.FnLocationFinder_UI(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = qw.FnMail_UI(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.FnNavigateBack_Payment_WG(driver,runManagerInfoObj);
						break;
				}
				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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

	public synchronized void Q2WallOfGarden_Fn_forgotPasswordCancelStep2(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			       
			       
				   

			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;

					case 1 :
						blnFlag = qw.forgotPassword_WG(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = qw.ResetPassword_Radiobtn_WG(driver,runManagerInfoObj);
						break;
					case 3:
						blnFlag = qw.Q2Wall_EditAccNumber(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = qw.Q2Wall_EditCode(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = qw.Q2Wall_SecurityAnswer(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = qw.Q2Wall_ResetPassword_CancelbuttonClick_ConfirmAlertDismiss(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = qw.Q2Wall_CancelbuttonClick_ConfirmAlert(driver,runManagerInfoObj);
						break;

				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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

	public synchronized void Q2WallOfGarden_Fn_forgotPasswordInvalidSecurityAnswer(WebDriver driver, RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			       
			       
				   
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;

					case 1 :
						blnFlag = qw.forgotPassword_WG(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = qw.ResetPassword_Radiobtn_WG(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = qw.Q2Wall_EditAccNumber(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = qw.Q2Wall_EditCode(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = qw.forgotPasswordInvalidSecurityAnswer(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = qw.Q2Wall_ResetPassword_CancelbuttonClick_ConfirmAlertDismiss(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = qw.Q2Wall_CancelbuttonClick_ConfirmAlert(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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
	 * This script is used to enter valid account details in Forgot Password
	 * screen and clicking cancel twice to undo the entries Created By: Priyanka
	 * Created On: 12-15-2015
	 */
	public synchronized void Q2WallOfGarden_Fn_forgotPasswordCancelTwiceStep1(WebDriver driver, RunManagerInfo runManagerInfoObj)
			throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 7; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;

					case 1 :
						blnFlag = qw.forgotPassword_WG(driver,runManagerInfoObj);
						break;
					case 2:
						blnFlag = qw.ResetPassword_Radiobtn_WG(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = qw.Q2Wall_EditAccNumber(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = qw.Q2Wall_EditCode(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = qw.Q2Wall_UserRecover_CancelbuttonClick_ConfirmAlertDismiss(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = qw.Q2Wall_CancelbuttonClick_ConfirmAlert(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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
	 * Payment Option > Online Payment > Pay Bill screen > One Time
	 * Checking/Savings > Verify Payment Information_Edit Payment Information
	 * Created by Saranya Date : 12/14/2015
	 */
	public synchronized void Q2Wall_PayBill_OTP_CheckingSavings_EditpaymentDetailsCheck(WebDriver driver, RunManagerInfo runManagerInfoObj)
			throws Exception {
		
		try {
			       
			       
				   

			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = qw.Q2Wall_NotificationPage_PayNowbuttonclick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnClickOneTime_Checking_SavingsOption(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = qw.FnValidateEditPaymentOption_CheckingSavings_WG(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag =qw.FnClickPayBillButtonAndVerify_CheckingSavings_WG_EditLink(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = qw.Q2Wall_CancelbuttonClick(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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
	 * Location Finder - Search_Results Created by Saranya Date : 12/15/2015
	 */

	public synchronized void Q2WallOfGarden_Fn_LocationFinder_SearchResults(WebDriver driver, RunManagerInfo runManagerInfoObj)
			throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = qw.FnLocationFinder_UI(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = qw.FnLocationFinderPage_UI(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = qw.FN_SearchText_EnterKey(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = qw.FN_SearchText_GoButton(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FnNavigateBack_Payment_WG(driver,runManagerInfoObj);
						break;
				}
				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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
	 * Payment Option > Online Payment > Pay Bill screen > One Time
	 * Checking/Savings > Payment Date field validation Created by Saranya Date
	 * : 12/15/2015
	 */

	public synchronized void Q2WallOfGarden_Fn_PayBill_DateFieldsValidations(WebDriver driver, RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			       
			       
				   
			for (int iCount = 0; iCount < 13; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;

					case 1 :
						blnFlag = qw.Q2Wall_NotificationPage_PayNowbuttonclick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnClickOneTime_Checking_SavingsOption(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = qw.Q2Wall_FnValidRoutingNumber(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = qw.Q2Wall_FnValidBankAccountNumber(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = qw.Q2Wall_FnValidPaymentAmount(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = qw.Q2Wall_Fn_VerifyPaymentDateField_PreviousDate(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FnVerify_PayBillButton_Disabled(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = qw.Q2Wall_Fn_VerifyPaymentDateField_CurrentDate(driver,runManagerInfoObj);
						break;
					case 9 :
						blnFlag = qw.Q2Wall_FnVerifyPayBillButtonEnabled(driver,runManagerInfoObj);
						break;
					case 10 :
						blnFlag = qw.Q2Wall_Fn_VerifyPaymentDateField_FutureDate(driver,runManagerInfoObj);
						break;
					case 11 :
						blnFlag = qw.Q2Wall_FnVerifyPayBillButtonEnabled(driver,runManagerInfoObj);
						break;
					case 12 :
						blnFlag = qw.Q2Wall_CancelbuttonClick(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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
	 * Location Finder - Search_Results Created by Priyanka Date : 12/15/2015
	 */

	public synchronized void Q2WallOfGarden_Fn_LocationFinder(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
		try {
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = qw.FnLocationFinder_UI(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = qw.FnLocationFinderPage_UI(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = qw.FN_SearchText_EnterKey(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FnNavigateBack_Payment_WG(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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
	 * Payment Option > Online Payment > Pay Bill screen > One Time Credit/Debit
	 * Card > Payment Date field validation Created by Priyanka Date :
	 * 12/15/2015
	 */

	public synchronized void Q2WallOfGarden_CreditDebit_PaymentDateValidation(WebDriver driver, RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			       
			       
				   
			for (int iCount = 0; iCount < 13; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = qw.Q2Wall_NotificationPage_PayNowbuttonclick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = qw.CreditDebit_AccNo(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = qw.CreditDebit_ExpiryDate(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = qw.CreditDebit_ExpiryYear(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = qw.CreditDebit_PayAmount(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = qw.Q2Wall_CreditDebit_PreviousDate(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.Verify_PayBillButton_Disabled(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = qw.Q2Wall_CreditDebit_CurrentDate(driver,runManagerInfoObj);
						break;
					case 9 :
						blnFlag = qw.Q2Wall_VerifyPayBillButtonEnabled(driver,runManagerInfoObj);
						break;
					case 10 :
						blnFlag = qw.Q2Wall_CreditDebit_FutureDate(driver,runManagerInfoObj);
						break;
					case 11 :
						blnFlag = qw.Q2Wall_VerifyPayBillButtonEnabled(driver,runManagerInfoObj);
						break;
					case 12 :
						blnFlag = qw.Q2Wall_CancelbuttonClick(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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
	 * User tries to cancel the details entered to recover the username Created
	 * by Saranya Date : 12/15/2015
	 */
	public synchronized void Q2WallOfGarden_ForgotUserName_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			       
			       
				   
			for (int iCount = 0; iCount < 7; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = qw.Q2_UserRecovery(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = qw.RecoverUserName_Radiobtn(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = qw.Q2Wall_EditAccNumber(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = qw.Q2Wall_EditCode(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = qw.Q2Wall_UserRecover_CancelbuttonClick_ConfirmAlertDismiss(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = qw.Q2Wall_CancelbuttonClick_ConfirmAlert(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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
	 * Payment Options -> Online payment using Onetime- Credit / Debit card
	 * Created by Jhansi Date : Dec 16,2015 TC#:19 Iteration4
	 * Method:Q2WallOfGarden_PayBill_OTP_CreditDebit_VerifyPaymentInfo
	 */
	public synchronized void Q2WallOfGarden_PayBill_OTP_CreditDebit_VerifyPaymentInfo(WebDriver driver, RunManagerInfo runManagerInfoObj)
			throws Exception {
		
		try {
			       
			       
				   

			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag =qw.Q2Wall_NotificationPage_PayNowbuttonclick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = qw.CreditDebitPaymentSelection(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = qw.OTPSelection(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = qw.PaymentInfo_CreditDebit_OTP(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FnNavigateBack_Payment_WG(driver,runManagerInfoObj);
						break;
				}
				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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
	 * Payment Option > Pay Bill screen > One Time Credit/Debit Card > Type of
	 * card used Created by Jhansi Date : Dec 16,2015 TC#:21 Iteration4
	 * Method:Q2WallOfGarden_PayBill_OTP_CreditDebit_VerifyPaymentInfo
	 */
	public synchronized void Q2WallOfGarden_PayBill_OTP_CreditDebit_TypeOfCard(WebDriver driver, RunManagerInfo runManagerInfoObj)
			throws Exception {
		
		try {
			       
			       
				   

			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = qw.Q2Wall_NotificationPage_PayNowbuttonclick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = qw.CreditDebitPaymentSelection(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = qw.OTPSelection(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = qw.TypeOfCardUsed(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = qw.Q2Wall_CancelbuttonClick(driver,runManagerInfoObj);
						break;

				}
				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
					break;
				}
			}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	public synchronized void Q2WallOfGarden_PayBill_OTP_CreditDebit_PaymentAmountFieldValidation(WebDriver driver, RunManagerInfo runManagerInfoObj)
			throws Exception {
		
		try {
			       
			       
				   

			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag =qw.Q2Wall_NotificationPage_PayNowbuttonclick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = qw.CreditDebitPaymentSelection(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = qw.OTPSelection(driver,runManagerInfoObj);
						break;
					case 4:
						blnFlag = qw.FnQ2WallOfGarden_PaymentAmountFieldValidation(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = qw.Q2Wall_CancelbuttonClick(driver,runManagerInfoObj);
						break;

				}
				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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
	 * Verify that clicking on View Details link takes the user to the View Bill
	 * screen of their current bill Created By: Manavi
	 */

	public synchronized void Q2WallOfGarden_PayBill_ViewDetailsLink(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		try {
			       
			       
				   

			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = qw.Q2Wall_NotificationPage_PayNowbuttonclick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = qw.FnViewDetailsLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = qw.VerifyStatementDetailsWindow(driver,runManagerInfoObj);
						break;
					case 4:
						blnFlag = qw.Q2Wall_CancelbuttonClick(driver,runManagerInfoObj);
						break;

				}
				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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
	 * Verifying if message is displayed on when there are no locations for the
	 * entered search keyword Created By: Manavi
	 */

	public synchronized void Q2WallOfGarden_Location_NoResultsDisplay(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		try {
			       
			       
				   

			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
					case 1 :
						blnFlag = qw.FnLocationFinderPage_Navigation(driver,runManagerInfoObj);
						break;
					case 2:
						blnFlag = qw.FnValidateNoResultsDisplay_EnterKey(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = qw.FnValidateNoResultsDisplay_GoButton(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FnNavigateBack_Payment_WG(driver,runManagerInfoObj);
						break;

				}
				if (!blnFlag) {
					repfn.FnCom_AbortExec_Q2LoggedIn();
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