package com.charter.sb.testscripts;

import org.openqa.selenium.WebDriver;

import com.charter.sb.beans.RunManagerInfo;
import com.charter.sb.controllers.Initialization;
import com.charter.sb.services.CharterAppFunctions;
import com.charter.sb.services.PaymentHistoryService;
import com.charter.sb.utils.CommonFunctions;
import com.charter.sb.utils.ReportingFunctions;
import com.charter.sb.utils.RunManager;

public class PaymentHistory extends Initialization {
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	public static boolean blnFlag = false;
	long startTime = System.currentTimeMillis();
	long endtime = System.currentTimeMillis();
	PaymentHistoryService ph=new PaymentHistoryService();

	/*
	 * Verifying if the user is able to go to Billing > Payment History page.
	 * Created by Manavi Date : 27/10/2015
	 */

	public synchronized void Sprint27_FN_VerifyStdUser_PaymentHistory(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {

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
	public synchronized void Sprint27_FN_CancelPendingPayment(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		
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
						blnFlag = app.FnBilling(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnPaymentHistoryTab(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = ph.fnCancelPendingPayment(driver,runManagerInfoObj);
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
	public synchronized void Sprint27_FN_paymentHistoryInfo(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
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
						blnFlag = app.FnBilling(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnPaymentHistoryTab(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = ph.FnPaymentHistoryInfo(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = ph.fnCancelPendingPaymentOne(driver,runManagerInfoObj);
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
	public synchronized void Sprint27_FN_lastSixMonthsPaymentHistory(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
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
						blnFlag = app.FnBilling(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnPaymentHistoryTab(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = ph.FnlastSixMonthsPaymentHistory(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = ph.fnCancelPendingPaymentOne(driver,runManagerInfoObj);
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
	public synchronized void Sprint27_FN_typesOfPreviousPayments(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		
		System.out.println("Before running test scripts" + startTime);
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
						blnFlag = app.FnBilling(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnPaymentHistoryTab(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = ph.FnTypesOfPreviousPayments(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = ph.fnCancelPendingPaymentOne(driver,runManagerInfoObj);
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
}
