package com.charter.sb.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.charter.sb.beans.RunManagerInfo;
import com.charter.sb.controllers.Initialization;
import com.charter.sb.resources.MB_PageObjects;
import com.charter.sb.utils.CommonFunctions;
import com.charter.sb.utils.ReportingFunctions;
import com.charter.sb.utils.RunManager;

public class PaymentHistoryService extends Initialization{
	MB_PageObjects mbo = new MB_PageObjects();
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	public static boolean blnFlag = false;
	
	 public synchronized boolean fnCancelPendingPayment(WebDriver driver,RunManagerInfo runManagerInfoObj) {
		 int paymentDetailsSize;
		 
		 try{
			 if(cnf.FnExplicitWait("XPATH", mbo.paymentHistoryRows,driver))
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if user is able to see the list of payment history", "User is able to see the list of payment history", "PASS",runManagerInfoObj);
				 List<WebElement> paymentDetails=driver.findElements(By.xpath(mbo.paymentHistoryRows));
				 paymentDetailsSize=paymentDetails.size();
				 outerLoop:
				 for(int i=0;i<=paymentDetails.size();i++)
				 {
					 if(cnf.FnExplicitWait("XPATH", mbo.pendingStatus,driver)){
						 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Status of the payment listed", "User is able to see Status of the payment listed", "PASS",runManagerInfoObj);
						 List<WebElement> pendingStatusList=driver.findElements(By.xpath(mbo.pendingStatus));
						 List <WebElement> pendingPayment=new ArrayList<WebElement>();
						 
						 for(WebElement we: pendingStatusList){
							 if(we.getText().contains("Pending")){
								 pendingPayment.add(we);
							 }
						 }
						 
						 if(pendingPayment.size() > 0){
							 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Pending Payment History List", "User is able to see Pending Payment History List", "PASS",runManagerInfoObj);

							 for(WebElement we1: pendingPayment){
								 if(cnf.FnExplicitWait("XPATH", mbo.paymentDateOne,driver)){
									 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Date of the payment listed", "User is able to see Date of the payment listed", "PASS",runManagerInfoObj);
									 WebElement checkPaymentDate = driver.findElement(By.xpath("//"+we1.getTagName()+"[@class='"+we1.getAttribute("class")+"']"+"/preceding-sibling::div[contains(@class,'sb-billing-column--payment-date')]"));
									 String paymentDateInString=checkPaymentDate.getText();
									 double currentDate=Calendar.getInstance().getTimeInMillis();
									 SimpleDateFormat curFormater = new SimpleDateFormat("MM/dd/yy"); 
									 Date dateObj = curFormater.parse(paymentDateInString); 
									 Calendar calendar = Calendar.getInstance();
									 calendar.setTime(dateObj);
									 double futureDate=calendar.getTimeInMillis();
									 if(futureDate > currentDate)
									 {
										 repfn.FnUpdateTestStepResHTML("Verify if the date is a future date", "Date is a future date: "+paymentDateInString, "PASS",runManagerInfoObj);
										 if(cnf.FnExplicitWait("XPATH", mbo.cancelPendingPayment,driver))
										 {
											 repfn.FnUpdateTestStepResHTML("Verify if user is able to see an option to cancel his pending payment", "User is able to see an option to cancel his pending payment", "PASS",runManagerInfoObj);
											 WebElement cancelPendingPayment=driver.findElement(By.xpath("//"+we1.getTagName()+"[@class='"+we1.getAttribute("class")+"']"+"/following-sibling::div[contains(@class,'sb-billing-column--amount')]/a[contains(@class,'cancel-link')]"));
											 if(cnf.JSClick(cancelPendingPayment,driver))
											 {
												 repfn.FnUpdateTestStepResHTML("Verify if Cancel link is clicked", "Cancel link is clicked", "PASS",runManagerInfoObj);
												 Thread.sleep(5000);
												 Alert alert=driver.switchTo().alert();
												 alert.accept();
												 repfn.FnUpdateTestStepResHTML("Verify if user is able to click \"Ok\" in confirmation popup", "User is able to click the confirmation popup", "PASS",runManagerInfoObj);
												 Thread.sleep(5000);
												 
												 if(cnf.FnExplicitWait("XPATH", mbo.CancelpaymentSuccessMessage,driver)){
													 WebElement CancelpaymentSuccessMessage=driver.findElement(By.xpath(mbo.CancelpaymentSuccessMessage));
													 if(CancelpaymentSuccessMessage.getText().contains("canceled")){
														 if(cnf.FnExplicitWait("XPATH", mbo.paymentHistoryRows,driver)){
															 List<WebElement> paymentDetailsAfterListCancel=driver.findElements(By.xpath(mbo.paymentHistoryRows));
															 if(paymentDetailsAfterListCancel.size()==paymentDetailsSize)
															 {
																 blnFlag=false;
																 repfn.FnUpdateTestStepResHTML("Verify if user has cancelled the payment successfully", "User is not able to cancel the payment successfully", "FAIL",runManagerInfoObj);
															 }
															 else
															 {
																 blnFlag=true;
																 repfn.FnUpdateTestStepResHTML("Verify if user has cancelled the payment successfully", "User is able to cancel the payment successfully", "PASS",runManagerInfoObj);
															 }
														 }
														 else{
															 blnFlag=true;
															 repfn.FnUpdateTestStepResHTML("Verify if user has cancelled the payment successfully", "User is able to cancel the payment successfully", "PASS",runManagerInfoObj);
														 }
													 }
													 else{
														 blnFlag=false;
														 repfn.FnUpdateTestStepResHTML("Verify Pending Payment Cancellation message is displayed", "Pending Payment Cancellation message is not displayed", "FAIL",runManagerInfoObj); 
													 }
												 }
												 else{
													 blnFlag=false;
													 repfn.FnUpdateTestStepResHTML("Verify Pending Payment Cancellation message is displayed", "Pending Payment Cancellation message is not displayed", "FAIL",runManagerInfoObj);
												 }																							 
											 }
											 else{
												 blnFlag=false;
												 repfn.FnUpdateTestStepResHTML("Verify if Cancel link is clicked", "Cancel link is not clicked", "FAIL",runManagerInfoObj);
											 }
										 }
										 else{
											 repfn.FnUpdateTestStepResHTML("Verify if user is able to see an option to cancel his pending payment", "User is not able to see an option to cancel his pending payment", "FAIL",runManagerInfoObj);
											 blnFlag=false;
										 }
									 }
									 else
									 {
										 blnFlag=false;
										 repfn.FnUpdateTestStepResHTML("Verify if the date is a future date", "Date is not a future date: "+paymentDateInString, "FAIL",runManagerInfoObj);
									 }
								 }
								 else{
									 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Date of the payment listed", "User is not able to see Date of the payment listed", "FAIL",runManagerInfoObj);
									 blnFlag=false;
								 }	
								 break outerLoop;	
							 }
							 													 
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Pending Payment History List", "User is not able to see Pending Payment History List. No record present with pending payment", "PASS",runManagerInfoObj);
							 boolean blnFlag1 = app.FnMakeFuturePayment(driver,runManagerInfoObj);
							 if(blnFlag1){
								 boolean blnFlag2 = fnCancelPendingPayment(driver,runManagerInfoObj);
								 if(blnFlag2){
									 blnFlag=true;
								 }
								 else{
									 blnFlag=false;
								 }
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify User is able to complete future payment sucessfully","User is not able to complete future payment sucessfully","FAIL",runManagerInfoObj);
								 blnFlag=false;
							 }
						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Status of the payment listed", "User is not able to see Status of the payment listed", "FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
			 }
			 else
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if user is able to see the list of payment history", "User is not able to see the list of payment history. No row is added", "PASS",runManagerInfoObj);
				 boolean blnFlag1 = app.FnMakeFuturePayment(driver,runManagerInfoObj);
				 if(blnFlag1){
					 boolean blnFlag2 = fnCancelPendingPayment(driver,runManagerInfoObj);
					 if(blnFlag2){
						 blnFlag=true;
					 }
					 else{
						 blnFlag=false;
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify User is able to complete future payment sucessfully","User is not able to complete future payment sucessfully","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
		 } 
		 
		 catch (Exception e)
		 {
			 repfn.FnUpdateTestStepResHTML("Verify if user is able to cancel pending payment", "User is not able to cancel pending payment due to some exception", "FAIL",runManagerInfoObj);
			 System.err.println("Message : " + e.getMessage());
			 System.err.println("Cause : " + e.getCause());
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }
	
	 public synchronized boolean fnCancelPendingPaymentOne(WebDriver driver,RunManagerInfo runManagerInfoObj) {
		 int paymentDetailsSize;
		 
		 try{
			 if(cnf.FnExplicitWait("XPATH", mbo.paymentHistoryRows,driver))
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if user is able to see the list of payment history", "User is able to see the list of payment history", "PASS",runManagerInfoObj);
				 List<WebElement> paymentDetails=driver.findElements(By.xpath(mbo.paymentHistoryRows));
				 paymentDetailsSize=paymentDetails.size();
				 outerLoop:
				 for(int i=0;i<=paymentDetails.size();i++)
				 {
					 if(cnf.FnExplicitWait("XPATH", mbo.pendingStatus,driver)){
						 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Status of the payment listed", "User is able to see Status of the payment listed", "PASS",runManagerInfoObj);
						 List<WebElement> pendingStatusList=driver.findElements(By.xpath(mbo.pendingStatus));
						 List <WebElement> pendingPayment=new ArrayList<WebElement>();
						 
						 for(WebElement we: pendingStatusList){
							 if(we.getText().contains("Pending")){
								 pendingPayment.add(we);
							 }
						 }
						 
						 if(pendingPayment.size() > 0){
							 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Pending Payment History List", "User is able to see Pending Payment History List", "PASS",runManagerInfoObj);

							 for(WebElement we1: pendingPayment){
								 if(cnf.FnExplicitWait("XPATH", mbo.paymentDateOne,driver)){
									 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Date of the payment listed", "User is able to see Date of the payment listed", "PASS",runManagerInfoObj);
									 WebElement checkPaymentDate = driver.findElement(By.xpath("//"+we1.getTagName()+"[@class='"+we1.getAttribute("class")+"']"+"/preceding-sibling::div[contains(@class,'sb-billing-column--payment-date')]"));
									 String paymentDateInString=checkPaymentDate.getText();
									 double currentDate=Calendar.getInstance().getTimeInMillis();
									 SimpleDateFormat curFormater = new SimpleDateFormat("MM/dd/yy"); 
									 Date dateObj = curFormater.parse(paymentDateInString); 
									 Calendar calendar = Calendar.getInstance();
									 calendar.setTime(dateObj);
									 double futureDate=calendar.getTimeInMillis();
									 if(futureDate > currentDate)
									 {
										 repfn.FnUpdateTestStepResHTML("Verify if the date is a future date", "Date is a future date: "+paymentDateInString, "PASS",runManagerInfoObj);
										 if(cnf.FnExplicitWait("XPATH", mbo.cancelPendingPayment,driver))
										 {
											 repfn.FnUpdateTestStepResHTML("Verify if user is able to see an option to cancel his pending payment", "User is able to see an option to cancel his pending payment", "PASS",runManagerInfoObj);
											 WebElement cancelPendingPayment=driver.findElement(By.xpath("//"+we1.getTagName()+"[@class='"+we1.getAttribute("class")+"']"+"/following-sibling::div[contains(@class,'sb-billing-column--amount')]/a[contains(@class,'cancel-link')]"));
											 if(cnf.JSClick(cancelPendingPayment,driver))
											 {
												 repfn.FnUpdateTestStepResHTML("Verify if Cancel link is clicked", "Cancel link is clicked", "PASS",runManagerInfoObj);
												 Thread.sleep(5000);
												 Alert alert=driver.switchTo().alert();
												 alert.accept();
												 repfn.FnUpdateTestStepResHTML("Verify if user is able to click \"Ok\" in confirmation popup", "User is able to click the confirmation popup", "PASS",runManagerInfoObj);
												 Thread.sleep(5000);
												 
												 if(cnf.FnExplicitWait("XPATH", mbo.CancelpaymentSuccessMessage,driver)){
													 WebElement CancelpaymentSuccessMessage=driver.findElement(By.xpath(mbo.CancelpaymentSuccessMessage));
													 if(CancelpaymentSuccessMessage.getText().contains("canceled")){
														 if(cnf.FnExplicitWait("XPATH", mbo.paymentHistoryRows,driver)){
															 List<WebElement> paymentDetailsAfterListCancel=driver.findElements(By.xpath(mbo.paymentHistoryRows));
															 if(paymentDetailsAfterListCancel.size()==paymentDetailsSize)
															 {
																 blnFlag=false;
																 repfn.FnUpdateTestStepResHTML("Verify if user has cancelled the payment successfully", "User is not able to cancel the payment successfully", "FAIL",runManagerInfoObj);
															 }
															 else
															 {
																 blnFlag=true;
																 repfn.FnUpdateTestStepResHTML("Verify if user has cancelled the payment successfully", "User is able to cancel the payment successfully", "PASS",runManagerInfoObj);
															 }
														 }
														 else{
															 blnFlag=true;
															 repfn.FnUpdateTestStepResHTML("Verify if user has cancelled the payment successfully", "User is able to cancel the payment successfully", "PASS",runManagerInfoObj);
														 }
													 }
													 else{
														 blnFlag=false;
														 repfn.FnUpdateTestStepResHTML("Verify Pending Payment Cancellation message is displayed", "Pending Payment Cancellation message is not displayed", "FAIL",runManagerInfoObj); 
													 }
												 }
												 else{
													 blnFlag=false;
													 repfn.FnUpdateTestStepResHTML("Verify Pending Payment Cancellation message is displayed", "Pending Payment Cancellation message is not displayed", "FAIL",runManagerInfoObj);
												 }																							 
											 }
											 else{
												 blnFlag=false;
												 repfn.FnUpdateTestStepResHTML("Verify if Cancel link is clicked", "Cancel link is not clicked", "FAIL",runManagerInfoObj);
											 }
										 }
										 else{
											 repfn.FnUpdateTestStepResHTML("Verify if user is able to see an option to cancel his pending payment", "User is not able to see an option to cancel his pending payment", "FAIL",runManagerInfoObj);
											 blnFlag=false;
										 }
									 }
									 else
									 {
										 blnFlag=false;
										 repfn.FnUpdateTestStepResHTML("Verify if the date is a future date", "Date is not a future date: "+paymentDateInString, "FAIL",runManagerInfoObj);
									 }
								 }
								 else{
									 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Date of the payment listed", "User is not able to see Date of the payment listed", "FAIL",runManagerInfoObj);
									 blnFlag=false;
								 }	
								 break outerLoop;	
							 }
							 													 
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Pending Payment History List", "User is not able to see Pending Payment History List. No record present with pending payment", "PASS",runManagerInfoObj);
							 blnFlag=true;
						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Status of the payment listed", "User is not able to see Status of the payment listed", "FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
			 }
			 else
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if user is able to see the list of payment history", "User is not able to see the list of payment history. No row is added", "PASS",runManagerInfoObj);
				 blnFlag=true;
			 }
		 } 
		 
		 catch (Exception e)
		 {
			 repfn.FnUpdateTestStepResHTML("Verify if user is able to cancel pending payment", "User is not able to cancel pending payment due to some exception", "FAIL",runManagerInfoObj);
			 System.err.println("Message : " + e.getMessage());
			 System.err.println("Cause : " + e.getCause());
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }
	 public synchronized boolean FnPaymentHistoryInfo(WebDriver driver,RunManagerInfo runManagerInfoObj) {
		 try
		 {
			 if(cnf.FnExplicitWait("XPATH", mbo.paymentHistoryRows,driver))
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if user is able to see the list of payment history", "User is able to see the list of payment history", "PASS",runManagerInfoObj);
				 List<WebElement> paymentDetails=driver.findElements(By.xpath(mbo.paymentHistoryRows));
				 outerLoop:
					 for(int i=0;i<=paymentDetails.size();i++)
					 {
						 if(cnf.FnExplicitWait("XPATH", mbo.pendingStatus,driver)){
							 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Status of the payment listed", "User is able to see Status of the payment listed", "PASS",runManagerInfoObj);
							 List<WebElement> pendingStatusList=driver.findElements(By.xpath(mbo.pendingStatus));
							 List <WebElement> pendingPayment=new ArrayList<WebElement>();
							 List <WebElement> previousPayment=new ArrayList<WebElement>();
							 
							 for(WebElement we: pendingStatusList){
								 if(we.getText().contains("Pending")){
									 pendingPayment.add(we);
								 }
							 }
							 												 
							 if(pendingPayment.size() > 0){
								 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Pending Payment History List", "User is able to see Pending Payment History List", "PASS",runManagerInfoObj);
								 for(WebElement we1:pendingPayment)
								 {
									 if(cnf.FnExplicitWait("XPATH", mbo.paymentDateOne,driver)){
										 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Date of the payment listed", "User is able to see Date of the payment listed", "PASS",runManagerInfoObj);
										 WebElement futureDate = driver.findElement(By.xpath("//"+we1.getTagName()+"[@class='"+we1.getAttribute("class")+"']"+"/preceding-sibling::div[contains(@class,'sb-billing-column--payment-date')]"));										 
										 repfn.FnUpdateTestStepResHTML("Verify if Payment date is displayed for Pending Payment record", "Payment date is displayed for Pending Payment record: "+futureDate.getText(), "PASS",runManagerInfoObj);
										 blnFlag=true;
									 }
									 else{
										 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Date of the payment listed", "User is not able to see Date of the payment listed", "FAIL",runManagerInfoObj);
										 blnFlag=false;
									 }
									 
									 if(cnf.FnExplicitWait("XPATH", mbo.paymentTypeOne,driver)){
										 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Type of the payment listed", "User is able to see Type of the payment listed", "PASS",runManagerInfoObj);
										 WebElement paymentType=driver.findElement(By.xpath("//"+we1.getTagName()+"[@class='"+we1.getAttribute("class")+"']"+"/preceding-sibling::div[contains(@class,'sb-billing-column--type')]"));									 
										 repfn.FnUpdateTestStepResHTML("Verify if Payment Type is displayed for Pending Payment record", "Payment Type is displayed for Pending Payment record: "+paymentType.getText(), "PASS",runManagerInfoObj);
										 blnFlag=true;
									 }
									 else{
										 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Type of the payment listed", "User is not able to see Type of the payment listed", "FAIL",runManagerInfoObj);
										 blnFlag=false;
									 }
									 
									 if(cnf.FnExplicitWait("XPATH", mbo.paymentAmountOne,driver)){
										 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Amount of the payment listed", "User is able to see Amount of the payment listed", "PASS",runManagerInfoObj);
										 WebElement paymentAmount=driver.findElement(By.xpath("//"+we1.getTagName()+"[@class='"+we1.getAttribute("class")+"']"+"/following-sibling::div[contains(@class,'sb-billing-column--amount')]/span[contains(@class,'payment-amount')]"));							 
										 repfn.FnUpdateTestStepResHTML("Verify if Payment Amount is displayed for Pending Payment record", "Payment Amount is displayed for Pending Payment record: "+paymentAmount.getText(), "PASS",runManagerInfoObj);
										 blnFlag=true;
									 }
									 else{
										 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Amount of the payment listed", "User is not able to see Amount of the payment listed", "FAIL",runManagerInfoObj);
										 blnFlag=false;
									 }
									 break;
								 }
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Pending Payment History List", "User is not able to see Pending Payment History List. No record present with pending payment", "PASS",runManagerInfoObj);
								 boolean blnFlag1 = app.FnMakeFuturePayment(driver,runManagerInfoObj);
								 if(blnFlag1){
									 boolean blnFlag2 = FnPaymentHistoryInfo(driver,runManagerInfoObj);
									 if(blnFlag2){
										 blnFlag=true;
									 }
									 else{
										 blnFlag=false;
									 }
								 }
								 else{
									 repfn.FnUpdateTestStepResHTML("Verify User is able to complete future payment sucessfully","User is not able to complete future payment sucessfully","FAIL",runManagerInfoObj);
									 blnFlag=false;
								 }
							 }
							 
							 for(WebElement we3: pendingStatusList){
								 if(!(we3.getText().contains("Pending"))){
									 previousPayment.add(we3);
								 }
							 }
							 
							 if(previousPayment.size() > 0){
								 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Previous Payment History List", "User is able to see Previous Payment History List", "PASS",runManagerInfoObj);
								 for(WebElement we2:previousPayment)
								 {
									 if(cnf.FnExplicitWait("XPATH", mbo.paymentDateOne,driver)){
										 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Date of the payment listed", "User is able to see Date of the payment listed", "PASS",runManagerInfoObj);
										 WebElement futureDate = driver.findElement(By.xpath("//"+we2.getTagName()+"[@class='"+we2.getAttribute("class")+"']"+"/preceding-sibling::div[contains(@class,'sb-billing-column--payment-date')]"));										 
										 repfn.FnUpdateTestStepResHTML("Verify if Payment date is displayed for Pending Payment record", "Payment date is displayed for Pending Payment record: "+futureDate.getText(), "PASS",runManagerInfoObj);
										 blnFlag=true;
									 }
									 else{
										 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Date of the payment listed", "User is not able to see Date of the payment listed", "FAIL",runManagerInfoObj);
										 blnFlag=false;
									 }
									 
									 if(cnf.FnExplicitWait("XPATH", mbo.paymentTypeOne,driver)){
										 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Type of the payment listed", "User is able to see Type of the payment listed", "PASS",runManagerInfoObj);
										 WebElement paymentType=driver.findElement(By.xpath("//"+we2.getTagName()+"[@class='"+we2.getAttribute("class")+"']"+"/preceding-sibling::div[contains(@class,'sb-billing-column--type')]"));									 
										 repfn.FnUpdateTestStepResHTML("Verify if Payment Type is displayed for Pending Payment record", "Payment Type is displayed for Pending Payment record: "+paymentType.getText(), "PASS",runManagerInfoObj);
										 blnFlag=true;
									 }
									 else{
										 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Type of the payment listed", "User is not able to see Type of the payment listed", "FAIL",runManagerInfoObj);
										 blnFlag=false;
									 }
									 
									 if(cnf.FnExplicitWait("XPATH", mbo.paymentAmountOne,driver)){
										 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Amount of the payment listed", "User is able to see Amount of the payment listed", "PASS",runManagerInfoObj);
										 WebElement paymentAmount=driver.findElement(By.xpath("//"+we2.getTagName()+"[@class='"+we2.getAttribute("class")+"']"+"/following-sibling::div[contains(@class,'sb-billing-column--amount')]/span[contains(@class,'payment-amount')]"));							 
										 repfn.FnUpdateTestStepResHTML("Verify if Payment Amount is displayed for Pending Payment record", "Payment Amount is displayed for Pending Payment record: "+paymentAmount.getText(), "PASS",runManagerInfoObj);
										 blnFlag=true;
									 }
									 else{
										 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Amount of the payment listed", "User is not able to see Amount of the payment listed", "FAIL",runManagerInfoObj);
										 blnFlag=false;
									 }
									 break;
								 }
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Previous Payment History List", "User is not able to see Previous Payment History List. No Previous payment record present", "FAIL",runManagerInfoObj);
								 blnFlag=true;
							 }
							 break outerLoop;
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Status of the payment listed", "User is not able to see Status of the payment listed", "FAIL",runManagerInfoObj);
							 blnFlag=false;
						 }
					 }
			 }
			 else
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if user is able to see the list of payment history", "User is not able to see the list of payment history. No row is added", "PASS",runManagerInfoObj);
				 boolean blnFlag1 = app.FnMakeFuturePayment(driver,runManagerInfoObj);
				 if(blnFlag1){
					 boolean blnFlag2 = FnPaymentHistoryInfo(driver,runManagerInfoObj);
					 if(blnFlag2){
						 blnFlag=true;
					 }
					 else{
						 blnFlag=false;
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify User is able to complete future payment sucessfully","User is not able to complete future payment sucessfully","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
		 }
		 
		 catch (Exception e)
		 {
			 repfn.FnUpdateTestStepResHTML("Verify whether previous payments are displayed under Payment History", "Previous payments are not displayed under Payment History due to some exception", "FAIL",runManagerInfoObj);
			 System.err.println("Message : " + e.getMessage());
			 System.err.println("Cause : " + e.getCause());
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }

	 public synchronized boolean FnTypesOfPreviousPayments(WebDriver driver,RunManagerInfo runManagerInfoObj) {
			try
			{
				if(cnf.FnExplicitWait("XPATH", mbo.paymentHistoryRows,driver))
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if user is able to see the list of payment history", "User is able to see the list of payment history", "PASS",runManagerInfoObj);
					 List<WebElement> paymentDetails=driver.findElements(By.xpath(mbo.paymentHistoryRows));
					 for(int i=0;i<=paymentDetails.size();i++)
					 {
						 if(cnf.FnExplicitWait("XPATH", mbo.pendingStatus,driver)){
							 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Status of the payment listed", "User is able to see Status of the payment listed", "PASS",runManagerInfoObj);
							 List<WebElement> pendingStatusList=driver.findElements(By.xpath(mbo.pendingStatus));
							 List <WebElement> pendingPayment=new ArrayList<WebElement>();
							 List <WebElement> processingPayment=new ArrayList<WebElement>();
							 List <WebElement> completedPayment=new ArrayList<WebElement>();
							 
							 for(WebElement we: pendingStatusList){
								 if(we.getText().contains("Pending")){
									 pendingPayment.add(we);
								 }
							 }
							 
							 if(pendingPayment.size() > 0){
								 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Pending Payment History List", "User is able to see Pending Payment History List", "PASS",runManagerInfoObj);
								 blnFlag=true;
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify if user is able to see the list of payment history", "User is not able to see the list of payment history. No row is added", "PASS",runManagerInfoObj);
								 boolean blnFlag1 = app.FnMakeFuturePayment(driver,runManagerInfoObj);
								 if(blnFlag1){
									 boolean blnFlag2 = FnTypesOfPreviousPayments(driver,runManagerInfoObj);
									 if(blnFlag2){
										 blnFlag=true;
									 }
									 else{
										 blnFlag=false;
									 }
								 }
								 else{
									 repfn.FnUpdateTestStepResHTML("Verify User is able to complete future payment sucessfully","User is not able to complete future payment sucessfully","FAIL",runManagerInfoObj);
									 blnFlag=false;
								 }
							 }
							 
							 for(WebElement we1: pendingStatusList){
								 if(we1.getText().contains("Processing")){
									 processingPayment.add(we1);
								 }
							 }
							 
							 if(processingPayment.size() > 0){
								 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Processing Payment History List", "User is able to see Processing Payment History List", "PASS",runManagerInfoObj);
								 blnFlag=true;
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Processing Payment History List", "User is not able to see Processing Payment History List. No record with Processing status present.", "FAIL",runManagerInfoObj);
								 blnFlag=true;
							 }
							 
							 for(WebElement we2: pendingStatusList){
								 if(we2.getText().contains("Completed")){
									 completedPayment.add(we2);
								 }
							 }
							 
							 if(completedPayment.size() > 0){
								 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Completed Payment History List", "User is able to see Completed Payment History List", "PASS",runManagerInfoObj);
								 blnFlag=true;
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Completed Payment History List", "User is not able to see Completed Payment History List. No record with Completed status present.", "FAIL",runManagerInfoObj);
								 blnFlag=true;
							 }
							 
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify if user is able to see Status of the payment listed", "User is not able to see Status of the payment listed", "FAIL",runManagerInfoObj);
							 blnFlag=false;
						 }
						 break;
					 }
				 }
				else
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if user is able to see the list of payment history", "User is not able to see the list of payment history. No row is added", "PASS",runManagerInfoObj);
					 boolean blnFlag1 = app.FnMakeFuturePayment(driver,runManagerInfoObj);
					 if(blnFlag1){
						 boolean blnFlag2 = FnTypesOfPreviousPayments(driver,runManagerInfoObj);
						 if(blnFlag2){
							 blnFlag=true;
						 }
						 else{
							 blnFlag=false;
						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify User is able to complete future payment sucessfully","User is not able to complete future payment sucessfully","FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
			}
			catch (Exception e)

			{
				blnFlag=false;
				repfn.FnUpdateTestStepResHTML("Verify if user is able to view all types of previous payment history", "User is not able to view all types of previous payment history due to some exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : " + e.getMessage());
				System.err.println("Cause : " + e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
	 public synchronized boolean FnlastSixMonthsPaymentHistory(WebDriver driver,RunManagerInfo runManagerInfoObj) {
		 try
		 {
			 if(cnf.FnExplicitWait("XPATH", mbo.paymentHistoryRows,driver))
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if user is able to see the list of payment history", "User is able to see the list of payment history", "PASS",runManagerInfoObj);
				 List<WebElement> paymentDetails=driver.findElements(By.xpath(mbo.paymentHistoryRows));
				 WebElement getLastRowInPaymentHistory=paymentDetails.get(paymentDetails.size()-1);
				 System.out.println("//"+getLastRowInPaymentHistory.getTagName()+"[@ng-repeat='"+getLastRowInPaymentHistory.getAttribute("ng-repeat")+"']"+"/div[contains(@class,'sb-billing-column--payment-date')]");
				 WebElement getLastDateInPaymentHistory = driver.findElement(By.xpath("//"+getLastRowInPaymentHistory.getTagName()+"[@ng-repeat='"+getLastRowInPaymentHistory.getAttribute("ng-repeat")+"']"+"/div[contains(@class,'sb-billing-column--payment-date')]"));
				 double currentDate=Calendar.getInstance().getTimeInMillis();
				 String lastPaymentDate=getLastDateInPaymentHistory.getText();
				 SimpleDateFormat curFormater = new SimpleDateFormat("MM/dd/yy"); 
				 Date dateObj = curFormater.parse(lastPaymentDate); 
				 Calendar calendar = Calendar.getInstance();
				 calendar.setTime(dateObj);
				 double lastDateInMillis=calendar.getTimeInMillis();
				 double diffOfDate=currentDate-lastDateInMillis;
				 double monthsFactor=(double)1000*60*60*24*30.5;
				 double diffInMonths=Math.ceil((double) (diffOfDate/monthsFactor));

				 if(diffInMonths<=6)
				 {
					 blnFlag=true;
					 repfn.FnUpdateTestStepResHTML("Verify if only last six months payments are displayed under payment history", "Payment history contains only the last six month details: "+lastPaymentDate, "PASS",runManagerInfoObj);
				 }
				 else
				 {
					 blnFlag=false;
					 repfn.FnUpdateTestStepResHTML("Verify if only last six months payments are displayed under payment history", "Payment history doesn't contains the last six month details: "+lastPaymentDate, "FAIL",runManagerInfoObj);
				 }
			 }
			 else
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if user is able to see the list of payment history", "User is not able to see the list of payment history. No row is added", "PASS",runManagerInfoObj);
				 boolean blnFlag1 = app.FnMakeFuturePayment(driver,runManagerInfoObj);
				 if(blnFlag1){
					 boolean blnFlag2 = FnlastSixMonthsPaymentHistory(driver,runManagerInfoObj);
					 if(blnFlag2){
						 blnFlag=true;
					 }
					 else{
						 blnFlag=false;
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify User is able to complete future payment sucessfully","User is not able to complete future payment sucessfully","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
		 }

		 catch (Exception e)
		 {
			 repfn.FnUpdateTestStepResHTML("Verify whether only the last six months  payments are displayed under Payment History", "Payment history doesn't contains the last month details due to some exception", "FAIL",runManagerInfoObj);
			 System.err.println("Message : " + e.getMessage());
			 System.err.println("Cause : " + e.getCause());
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }
}
