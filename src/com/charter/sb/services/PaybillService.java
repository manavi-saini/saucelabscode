package com.charter.sb.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.charter.sb.beans.RunManagerInfo;
import com.charter.sb.controllers.Initialization;
import com.charter.sb.resources.MB_PageObjects;
import com.charter.sb.utils.CommonFunctions;
import com.charter.sb.utils.ReportingFunctions;
import com.charter.sb.utils.RunManager;

public class PaybillService extends Initialization{
	MB_PageObjects mbo = new MB_PageObjects();
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	public static boolean blnFlag = false;
	List all = new ArrayList();
	
	
	 public synchronized boolean FnPayBillLink(WebDriver driver, RunManagerInfo runManagerInfoObj){
     	  
     	  try{
     		  Thread.sleep(10000);
     		  if(cnf.FnExplicitWait("XPATH", mbo.payBill_Link_V2,driver)){
     			  repfn.FnUpdateTestStepResHTML("Verify Pay Bill button is displayed for Standard User","Pay Bill button is displayed for Standard User","FAIL",runManagerInfoObj);
     			  blnFlag=false;
     		  }
     		  else{
     			  repfn.FnUpdateTestStepResHTML("Verify Pay Bill button is displayed for Standard User","Pay Bill button is not displayed for Standard User","PASS",runManagerInfoObj);
     			  blnFlag=true;
     			  
     		  }
     	  }
     	  
     	  catch (Exception e)

   		{
   			repfn.FnUpdateTestStepResHTML("Verify User is able to verify Pay Bill button on Home page",
   					"User is able to verify Pay Bill button on Home page due to some exception","FAIL",runManagerInfoObj);

   	      	 blnFlag=false;
   			System.err.println("Message : "+e.getMessage());
   			System.err.println("Cause : "+e.getCause());
   			
   		}
   		m1.put("STEPSTATUS", blnFlag);
   		return blnFlag;
     	  
       }

	
	

		public synchronized boolean FnSaveAutoPay(WebDriver driver, RunManagerInfo runManagerInfoObj) {

			try{

				driver.switchTo().frame("iFrameResizer0");
				if(cnf.FnExplicitWait("XPATH", mbo.PayNowButton,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is displayed", "Save Auto-Pay button is displayed", "PASS",runManagerInfoObj);
					WebElement PayNowButton=driver.findElement(By.xpath(mbo.PayNowButton));
					if(PayNowButton.isEnabled()){
						repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is enabled", "Save Auto-Pay button is enabled", "PASS",runManagerInfoObj);
						if(cnf.JSClick(PayNowButton,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is clicked", "Save Auto-Pay button is clicked", "PASS",runManagerInfoObj);
							Thread.sleep(3000);

							if(cnf.FnExplicitWait("XPATH", mbo.PayBill_VerifyPaymentPage,driver))
							{
								repfn.FnUpdateTestStepResHTML("Verify if user is navigated to Verify Payment Information", "User is navigated to Verify Payment Information", "PASS",runManagerInfoObj);

								if(cnf.FnExplicitWait("XPATH", mbo.acceptTermsAndConditions,driver)){
									repfn.FnUpdateTestStepResHTML("Verify \'Accept Terms and Conditions\' checkbox is displayed", "\'Accept Terms and Conditions\' checkbox is displayed", "PASS",runManagerInfoObj);
									WebElement acceptTermsAndConditions=driver.findElement(By.xpath(mbo.acceptTermsAndConditions));
									if(cnf.JSClick(acceptTermsAndConditions,driver)){
										repfn.FnUpdateTestStepResHTML("Verify \'Accept Terms and Conditions\' checkbox is selected", "\'Accept Terms and Conditions\' checkbox is selected", "PASS",runManagerInfoObj);

										if(cnf.FnExplicitWait("XPATH", mbo.PayNowButton,driver))
										{
											WebElement PayNowButtonOne=driver.findElement(By.xpath(mbo.PayNowButton));
											if(PayNowButtonOne.isEnabled()){
												repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is displayed and enabled", "Save Auto-Pay button is displayed and enabled", "PASS",runManagerInfoObj);

												if(cnf.JSClick(PayNowButtonOne,driver)){
													repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is clicked", "Save Auto-Pay button is clicked", "PASS",runManagerInfoObj);
													Thread.sleep(5000);
													
													if(cnf.FnExplicitlessWait("XPATH", mbo.payementIssue, driver))
													{
														WebElement paymentIssue=driver.findElement(By.xpath(mbo.payementIssue));
														repfn.FnUpdateTestStepResHTML("Verify AutoPay option get confirmed sucessfully or not", "AutoPay option did not get confirm due to some payement issue as messgae displayed: "+paymentIssue.getText(), "FAIL",runManagerInfoObj);
														blnFlag=false;
													}
													else{
													if(cnf.FnExplicitWait("XPATH", mbo.billingReturnToOverview,driver))
													{
														repfn.FnUpdateTestStepResHTML("Verify AutoPay option get confirmed sucessfully or not", "AutoPay option get confirmed sucessfully", "PASS",runManagerInfoObj);
														repfn.FnUpdateTestStepResHTML("Verify \'Return To Overview\' button is displayed", "\'Return To Overview\' button is displayed", "PASS",runManagerInfoObj);
														WebElement returnToOverview=driver.findElement(By.xpath(mbo.billingReturnToOverview));
														if(cnf.JSClick(returnToOverview,driver)){
															repfn.FnUpdateTestStepResHTML("Verify \'Return To Overview\' button is clicked", "\'Return To Overview\' button is clicked", "PASS",runManagerInfoObj);

															Thread.sleep(5000);
															if(cnf.FnExplicitWait("Xpath", mbo.Home_OverviewLabel,driver)){
																repfn.FnUpdateTestStepResHTML("Verify User Return back to Overview Page","User Return back to Overview Page","PASS",runManagerInfoObj);
																blnFlag=true;
															}
															else if (cnf.FnExplicitWait("Xpath", mbo.v1_overview,driver)) {
																repfn.FnUpdateTestStepResHTML("Verify User Return back to Overview Page","User Return back to Overview Page","PASS",runManagerInfoObj);
																blnFlag=true;
															}
															else{
																repfn.FnUpdateTestStepResHTML("Verify User Return back to Overview Page","User is not Return back to Overview Page","FAIL",runManagerInfoObj);
																blnFlag=false;
															}
														}
														else{
															repfn.FnUpdateTestStepResHTML("Verify \'Return To Overview\' button is clicked", "\'Return To Overview\' button is not clicked", "FAIL",runManagerInfoObj);
															blnFlag=false;
														}
													}
													else{
														repfn.FnUpdateTestStepResHTML("Verify \'Return To Overview\' button is displayed", "\'Return To Overview\' button is not displayed", "FAIL",runManagerInfoObj);
														blnFlag=false;
													}
												}
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is clicked", "Save Auto-Pay button is not clicked", "FAIL",runManagerInfoObj);
													blnFlag=false;
												}
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is displayed and enabled", "Save Auto-Pay button is not displayed and enabled", "FAIL",runManagerInfoObj);
												blnFlag=false;
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is displayed", "Save Auto-Pay button is not displayed", "FAIL",runManagerInfoObj);
											blnFlag=false;
										}

									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify \'Accept Terms and Conditions\' checkbox is selected", "\'Accept Terms and Conditions\' checkbox is not selected", "FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify \'Accept Terms and Conditions\' checkbox is displayed", "\'Accept Terms and Conditions\' checkbox is not displayed", "FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify if user is navigated to Verify Payment Information", "User is not navigated to Verify Payment Information", "FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is clicked", "Save Auto-Pay button is not clicked", "FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is enabled", "Save Auto-Pay button is not enabled", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is displayed", "Save Auto-Pay button is not displayed", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				driver.switchTo().defaultContent();
			}

			catch (Exception e)

			{		
				blnFlag=false;
				repfn.FnUpdateTestStepResHTML("Verify if user has navigated to auto pay confirmation page", "User has not navigated to auto pay confirmation page due to some exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}

			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}

		public synchronized boolean fnCheckingOrSavingsAutoPayPaymentConfirmation(WebDriver driver, RunManagerInfo runManagerInfoObj) {
			try
			{
				boolean blnFlag1 = FnEnterValid_Routing_Account_Number(driver,runManagerInfoObj);
				boolean blnFlag2 = FnSaveAutoPay(driver,runManagerInfoObj);
				driver.navigate().refresh();

				if(blnFlag1 && blnFlag2){
					repfn.FnUpdateTestStepResHTML("Verify User is able to complete payment sucessfully and navigate back to Overview page","User is able to complete payment sucessfully and navigate back to Overview page","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User is able to complete payment sucessfully and navigate back to Overview page","User is not able to complete payment sucessfully and navigate back to Overview page","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			catch (Exception e)

			{		
				repfn.FnUpdateTestStepResHTML("Verify User is able to complete payment sucessfully and navigate back to Overview page","User is not able to complete payment sucessfully and navigate back to Overview page due to some exception","FAIL",runManagerInfoObj);
				blnFlag=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}

			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		  public synchronized boolean FnEnterValid_Routing_Account_Number(WebDriver driver, RunManagerInfo runManagerInfoObj){

	    	   String validRoutingNumber = "122000247";
	    	   String validBankAccountNumber = "0888271156";


	    	   try{

	    		   driver.switchTo().frame("iFrameResizer0");

	    		   if(cnf.FnExplicitWait("XPATH", mbo.RoutingNumber,driver)){
	    			   repfn.FnUpdateTestStepResHTML("Verify Routing Number field is displayed under Payment Information option",
	    					   "Routing Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
	    			   WebElement RoutingNumber=driver.findElement(By.xpath(mbo.RoutingNumber));
	    			   RoutingNumber.sendKeys(validRoutingNumber);
	    			   repfn.FnUpdateTestStepResHTML("Verify Routing Number is entered","Routing Number entered :" +validRoutingNumber,"PASS",runManagerInfoObj);
	    			  
	    			   if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader,driver)){
	    				   WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
	    				   cnf.JSClick(PaymentInformationHeader,driver);
	    				   blnFlag=true;
	    			   }
	    			   else{
	    				   repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
	    				   blnFlag=false;
	    			   }


	    		   }
	    		   else{
	    			   repfn.FnUpdateTestStepResHTML("Verify Routing Number field is displayed under Payment Information option",
	    					   "Routing Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
	    			   blnFlag=false;
	    		   }

	    		   /*driver.switchTo().defaultContent();


	                  		driver.switchTo().frame("iFrameResizer0");*/

	    		   if(cnf.FnExplicitWait("XPATH", mbo.BankAccountNumber,driver)){
	    			   repfn.FnUpdateTestStepResHTML("Verify Bank Account Number field is displayed under Payment Information option",
	    					   "Bank Account Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
	    			   WebElement BankAccountNumber=driver.findElement(By.xpath(mbo.BankAccountNumber));
	    			   BankAccountNumber.sendKeys(validBankAccountNumber);
	    			   repfn.FnUpdateTestStepResHTML("Verify Bank Account Number is entered","Bank Account Number entered:" +validBankAccountNumber,"PASS",runManagerInfoObj);

	    			   if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader,driver)){
	    				   WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
	    				   cnf.JSClick(PaymentInformationHeader,driver);
	    				   blnFlag=true;
	    			   }
	    			   else{
	    				   repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
	    				   blnFlag=false;
	    			   }


	    		   }
	    		   else{
	    			   repfn.FnUpdateTestStepResHTML("Verify Bank Account Number field is displayed under Payment Information option",
	    					   "Bank Account Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
	    			   blnFlag=false;
	    		   }

	    		   driver.switchTo().defaultContent();




	    	   }

	    	   catch (Exception e)

	    	   {
	    		   repfn.FnUpdateTestStepResHTML("Verify User is able to enter valid Routing Number and Account Number",
	    				   "User is not able to enter valid Routing Number and Account Number due to some exception","FAIL",runManagerInfoObj);
	    		   blnFlag=false;
	    		   System.err.println("Message : "+e.getMessage());
	    		   System.err.println("Cause : "+e.getCause());

	    	   }
	    	   m1.put("STEPSTATUS", blnFlag);
	    	   return blnFlag;

	       }
	      
	       public synchronized boolean autoPayCheckingSavingsTC(WebDriver driver, RunManagerInfo runManagerInfoObj) {
	    		try
	    		{
	    			driver.switchTo().frame("iFrameResizer0");
	    			if(cnf.FnExplicitWait("XPATH", mbo.PayNowButton,driver))
	    			{
	    				repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is displayed", "Save Auto-Pay button is displayed", "PASS",runManagerInfoObj);
	    				WebElement PayNowButton=driver.findElement(By.xpath(mbo.PayNowButton));
	    				if(PayNowButton.isEnabled()){
	    					repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is enabled", "Save Auto-Pay button is enabled", "PASS",runManagerInfoObj);
	    					if(cnf.JSClick(PayNowButton,driver)){
	    						repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is clicked", "Save Auto-Pay button is clicked", "PASS",runManagerInfoObj);
	    						Thread.sleep(3000);

	    						if(cnf.FnExplicitWait("XPATH", mbo.PayBill_VerifyPaymentPage,driver))
	    						{
	    							repfn.FnUpdateTestStepResHTML("Verify if user is navigated to Verify Payment Information", "User is navigated to Verify Payment Information", "PASS",runManagerInfoObj);

	    							if(cnf.FnExplicitWait("XPATH", mbo.acceptTermsAndConditions,driver)){
	    								repfn.FnUpdateTestStepResHTML("Verify \'Accept Terms and Conditions\' checkbox is displayed", "\'Accept Terms and Conditions\' checkbox is displayed", "PASS",runManagerInfoObj);
	    								WebElement acceptTermsAndConditions=driver.findElement(By.xpath(mbo.acceptTermsAndConditions));

	    								if(acceptTermsAndConditions.isSelected()){
	    									repfn.FnUpdateTestStepResHTML("Verify \'Accept Terms and Conditions\' checkbox is not selected", "\'Accept Terms and Conditions\' checkbox is selected", "FAIL",runManagerInfoObj);
	    									blnFlag=false;
	    								}
	    								else{
	    									repfn.FnUpdateTestStepResHTML("Verify \'Accept Terms and Conditions\' checkbox is not selected", "\'Accept Terms and Conditions\' checkbox is not selected", "PASS",runManagerInfoObj);
	    									if(cnf.FnExplicitWait("XPATH", mbo.PayNowButton,driver))
	    									{
	    										WebElement PayNowButtonOne=driver.findElement(By.xpath(mbo.PayNowButton));
	    										if(PayNowButtonOne.isEnabled()){
	    											repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is not enabled", "Save Auto-Pay button is enabled", "FAIL",runManagerInfoObj);
	    											blnFlag=false;
	    										}
	    										else{
	    											repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is not enabled", "Save Auto-Pay button is not enabled", "PASS",runManagerInfoObj);
	    											if(cnf.FnExplicitWait("XPATH", mbo.cancelButtonPayBill,driver)){
	    												repfn.FnUpdateTestStepResHTML("Verify if Cancel button is present", "Cancel button is present", "PASS",runManagerInfoObj);
	    												WebElement cancelButton=driver.findElement(By.xpath(mbo.cancelButtonPayBill));
	    												if(cnf.JSClick(cancelButton,driver))
	    												{
	    													repfn.FnUpdateTestStepResHTML("Verify if Cancel button is clicked", "Cancel button is clicked", "PASS",runManagerInfoObj);
	    													if(cnf.FnExplicitWait("XPATH", mbo.okButtonPayBill,driver)){
	    														repfn.FnUpdateTestStepResHTML("Verify if OK button is present", "OK button is present", "PASS",runManagerInfoObj);
	    														WebElement okButton=driver.findElement(By.xpath(mbo.okButtonPayBill));
	    														if(cnf.JSClick(okButton,driver))
	    														{
	    															blnFlag=true;
	    															repfn.FnUpdateTestStepResHTML("Verify if OK button is clicked in popup", "OK button is clicked in popup", "PASS",runManagerInfoObj);
	    														}
	    														else
	    														{
	    															blnFlag=false;
	    															repfn.FnUpdateTestStepResHTML("Verify if OK button is clicked in popup", "OK button is not clicked in popup", "FAIL",runManagerInfoObj);
	    														}
	    													}
	    													else{
	    														repfn.FnUpdateTestStepResHTML("Verify if OK button is present", "OK button is not present", "FAIL",runManagerInfoObj);
	    														blnFlag=false;
	    													}
	    												}
	    												else{
	    													repfn.FnUpdateTestStepResHTML("Verify if Cancel button is clicked", "Cancel button is not clicked", "FAIL",runManagerInfoObj);
	    													blnFlag=false;
	    												}
	    											}
	    											else{
	    												repfn.FnUpdateTestStepResHTML("Verify if Cancel button is present", "Cancel button is not present", "FAIL",runManagerInfoObj);
	    												blnFlag=false;
	    											}											
	    										}
	    									}
	    									else{
	    										repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is displayed", "Save Auto-Pay button is not displayed", "FAIL",runManagerInfoObj);
	    										blnFlag=false;
	    									}
	    								}
	    							}
	    							else{
	    								repfn.FnUpdateTestStepResHTML("Verify \'Accept Terms and Conditions\' checkbox is displayed", "\'Accept Terms and Conditions\' checkbox is not displayed", "FAIL",runManagerInfoObj);
	    								blnFlag=false;
	    							}
	    						}
	    						else
	    						{
	    							repfn.FnUpdateTestStepResHTML("Verify if user is navigated to Verify Payment Information", "User is not navigated to Verify Payment Information", "FAIL",runManagerInfoObj);
	    							blnFlag=false;
	    						}
	    					}
	    					else{
	    						repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is clicked", "Save Auto-Pay button is not clicked", "FAIL",runManagerInfoObj);
	    						blnFlag=false;
	    					}
	    				}
	    				else{
	    					repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is enabled", "Save Auto-Pay button is not enabled", "FAIL",runManagerInfoObj);
	    					blnFlag=false;
	    				}
	    			}
	    			else{
	    				repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is displayed", "Save Auto-Pay button is not displayed", "FAIL",runManagerInfoObj);
	    				blnFlag=false;
	    			}

	    			driver.switchTo().defaultContent();

	    		}
	    		 catch (Exception e)

	    		 {		
	    			 blnFlag=false;
	    			 System.err.println("Message : "+e.getMessage());
	    			 System.err.println("Cause : "+e.getCause());
	    			 repfn.FnUpdateTestStepResHTML("Verify if User is not navigated from Verify Payment Information as Terms/Conditions not accepted", "User is navigated from Verify Payment Information when Terms/Conditions not accepted due to some exception", "FAIL",runManagerInfoObj);
	    		 }
	    		 m1.put("STEPSTATUS", blnFlag);
	    		 return blnFlag;
	    	}

		public synchronized boolean fnCheckingOrSavingsAutoPayPaymentConfirmation_WithoutTC(WebDriver driver, RunManagerInfo runManagerInfoObj) {
			try
			{
				boolean blnFlag1 = FnEnterValid_Routing_Account_Number(driver,runManagerInfoObj);
				if(blnFlag1){
					boolean blnFlag2 = autoPayCheckingSavingsTC(driver,runManagerInfoObj);
					if(blnFlag2){
						repfn.FnUpdateTestStepResHTML("Verify User is not able to proceed with payment if the T&C is not agreed to.","User is not able to proceed with payment if the T&C is not agreed to.","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify User is not able to proceed with payment if the T&C is not agreed to.","User is able to proceed with payment if the T&C is not agreed to.","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User is able to enter valid Routing Number and Account Number",
		 				   "User is not able to enter valid Routing Number and Account Number","FAIL",runManagerInfoObj);
		 		   blnFlag=false;
				}
				
				driver.navigate().refresh();


			}
			catch (Exception e)

			{		
				repfn.FnUpdateTestStepResHTML("Verify User is not able to proceed with payment if the T&C is not agreed to.","User is able to proceed with payment if the T&C is not agreed to due to some exception","FAIL",runManagerInfoObj);
				blnFlag=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}

			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}

		public synchronized boolean fnCreditDebitAutoPayPaymentConfirmation(WebDriver driver, RunManagerInfo runManagerInfoObj) {
			try
			{
				boolean blnFlag1 = app.EditCreditCard(driver,runManagerInfoObj);
				boolean blnFlag2 = EditExpDate(driver,runManagerInfoObj);
				boolean blnFlag3 = FnSaveAutoPay(driver,runManagerInfoObj);
				driver.navigate().refresh();

				if(blnFlag1 && blnFlag2 && blnFlag3){
					repfn.FnUpdateTestStepResHTML("Verify User is able to complete payment sucessfully and navigate back to Overview page","User is able to complete payment sucessfully and navigate back to Overview page","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User is able to complete payment sucessfully and navigate back to Overview page","User is not able to complete payment sucessfully and navigate back to Overview page","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			catch (Exception e)

			{		
				repfn.FnUpdateTestStepResHTML("Verify User is able to complete payment sucessfully and navigate back to Overview page","User is not able to complete payment sucessfully and navigate back to Overview page due to some exception","FAIL",runManagerInfoObj);
				blnFlag=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}

			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		
		 //To key-in valid Expiry Date//

		 public synchronized boolean EditExpDate(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
		 {
			 try
			 {
				 
				 driver.switchTo().frame("iFrameResizer0");
				 //String Date=m1.get("ExpDate").toString();
				 SimpleDateFormat curFormater = new SimpleDateFormat("MM/dd/yyyy"); 
				 Calendar calendar=Calendar.getInstance();
				 calendar.add(Calendar.YEAR, 2);
				 Date dateObj = calendar.getTime(); 
				 String paymentDateInString=curFormater.format(dateObj);
				 String dateArray[]=paymentDateInString.split("/");
				 String month=dateArray[0];
				 String year=dateArray[2];
				 String expDate=month+"/"+year;

				 if(cnf.FnExplicitWait("XPATH", mbo.PayBill_ExpiryDate,driver))
				 {
					 System.out.println("Exp date present");
					 repfn.FnUpdateTestStepResHTML("Verify if Expiry Date field is present", "Expiry Date field is present", "PASS",runManagerInfoObj);
					 WebElement EditEDate=driver.findElement(By.xpath(mbo.PayBill_ExpiryDate));

					 EditEDate.sendKeys(expDate);
					 repfn.FnUpdateTestStepResHTML("Enter a valid Expiry Date", "A valid Expiry Date is entered: "+EditEDate.getAttribute("value"), "PASS",runManagerInfoObj);
					 blnFlag=true;
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if Expiry Date field is present", "Expiry Date field is not present", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
				 
				 driver.switchTo().defaultContent();

			 }
			 catch(Exception e)
			 {
				 System.err.println("Message : "+e.getMessage());
				 System.err.println("Cause : "+e.getCause());	
				 repfn.FnUpdateTestStepResHTML("Verify if Expiry Date field is present", "Expiry Date field is not present due to some exception", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;

		 }


	
		 //To key-in valid Payment Date//

		 public synchronized boolean EditPayDate(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
		 {
			 try
			 {
				 driver.switchTo().frame("iFrameResizer0");
				 //String Date=m1.get("PaymentDate").toString();
				 SimpleDateFormat curFormater = new SimpleDateFormat("MM/dd/yyyy"); 
				 Calendar calendar=Calendar.getInstance();
				 calendar.add(Calendar.DATE, 2);
				 Date dateObj = calendar.getTime(); 
				 String paymentDateInString=curFormater.format(dateObj);
				 String dateArray[]=paymentDateInString.split("/");
				 String month=dateArray[0];
				 String day=dateArray[1];
				 String year=dateArray[2];
				 String validPaymentDateChrome = (month)+"/"+day;
				 String Browser=m1.get("BROWSER").toString();
				 if(cnf.FnExplicitWait("XPATH", mbo.PayBill_PaymentDate,driver))
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if Payment Date field is present", "Payment Date field is present", "PASS",runManagerInfoObj);
					 WebElement EditPay=driver.findElement(By.xpath(mbo.PayBill_PaymentDate));
					 if(Browser.equalsIgnoreCase("chrome"))
					 {
						 EditPay.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),validPaymentDateChrome);
						 repfn.FnUpdateTestStepResHTML("Enter a valid Payment Date", "A valid Payment Date is entered: "+EditPay.getAttribute("value"), "PASS",runManagerInfoObj);
						 blnFlag=true;
					 }
					 else
					 {
						 EditPay.sendKeys(paymentDateInString,Keys.TAB);
						 blnFlag=true;
						 repfn.FnUpdateTestStepResHTML("Verify if user is able to enter the payment date", "User is able to enter the payment date: "+paymentDateInString, "PASS",runManagerInfoObj);
					 }
				 }
				 else
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if Payment Date field is present", "Payment Date field is not present", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
				 
				 driver.switchTo().defaultContent();

			 }
			 catch(Exception e)
			 {
				 System.err.println("Message : "+e.getMessage());
				 System.err.println("Cause : "+e.getCause());	
				 repfn.FnUpdateTestStepResHTML("Verify if Payment Date field is present", "Payment Date field is not present due to some exception", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;

		 }
		 public synchronized boolean fnAutoPayCreditCardTC(WebDriver driver, RunManagerInfo runManagerInfoObj) {
				try
				{
					driver.switchTo().frame("iFrameResizer0");
					if(cnf.FnExplicitWait("XPATH", mbo.PayNowButton,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is displayed", "Save Auto-Pay button is displayed", "PASS",runManagerInfoObj);
						WebElement PayNowButton=driver.findElement(By.xpath(mbo.PayNowButton));
						if(PayNowButton.isEnabled()){
							repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is enabled", "Save Auto-Pay button is enabled", "PASS",runManagerInfoObj);
							if(cnf.JSClick(PayNowButton,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is clicked", "Save Auto-Pay button is clicked", "PASS",runManagerInfoObj);
								Thread.sleep(3000);

								if(cnf.FnExplicitWait("XPATH", mbo.PayBill_VerifyPaymentPage,driver))
								{
									repfn.FnUpdateTestStepResHTML("Verify if user is navigated to Verify Payment Information", "User is navigated to Verify Payment Information", "PASS",runManagerInfoObj);

									if(cnf.FnExplicitWait("XPATH", mbo.acceptTermsAndConditions,driver)){
										repfn.FnUpdateTestStepResHTML("Verify \'Accept Terms and Conditions\' checkbox is displayed", "\'Accept Terms and Conditions\' checkbox is displayed", "PASS",runManagerInfoObj);
										WebElement acceptTermsAndConditions=driver.findElement(By.xpath(mbo.acceptTermsAndConditions));

										if(acceptTermsAndConditions.isSelected()){
											repfn.FnUpdateTestStepResHTML("Verify \'Accept Terms and Conditions\' checkbox is not selected", "\'Accept Terms and Conditions\' checkbox is selected", "FAIL",runManagerInfoObj);
											blnFlag=false;
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify \'Accept Terms and Conditions\' checkbox is not selected", "\'Accept Terms and Conditions\' checkbox is not selected", "PASS",runManagerInfoObj);
											if(cnf.FnExplicitWait("XPATH", mbo.PayNowButton,driver))
											{
												WebElement PayNowButtonOne=driver.findElement(By.xpath(mbo.PayNowButton));
												if(PayNowButtonOne.isEnabled()){
													repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is not enabled", "Save Auto-Pay button is enabled", "FAIL",runManagerInfoObj);
													blnFlag=false;
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is not enabled", "Save Auto-Pay button is not enabled", "PASS",runManagerInfoObj);
													if(cnf.FnExplicitWait("XPATH", mbo.cancelButtonPayBill,driver)){
														repfn.FnUpdateTestStepResHTML("Verify if Cancel button is present", "Cancel button is present", "PASS",runManagerInfoObj);
														WebElement cancelButton=driver.findElement(By.xpath(mbo.cancelButtonPayBill));
														if(cnf.JSClick(cancelButton,driver))
														{
															repfn.FnUpdateTestStepResHTML("Verify if Cancel button is clicked", "Cancel button is clicked", "PASS",runManagerInfoObj);
															if(cnf.FnExplicitWait("XPATH", mbo.okButtonPayBill,driver)){
																repfn.FnUpdateTestStepResHTML("Verify if OK button is present", "OK button is present", "PASS",runManagerInfoObj);
																WebElement okButton=driver.findElement(By.xpath(mbo.okButtonPayBill));
																if(cnf.JSClick(okButton,driver))
																{
																	blnFlag=true;
																	repfn.FnUpdateTestStepResHTML("Verify if OK button is clicked in popup", "OK button is clicked in popup", "PASS",runManagerInfoObj);
																}
																else
																{
																	blnFlag=false;
																	repfn.FnUpdateTestStepResHTML("Verify if OK button is clicked in popup", "OK button is not clicked in popup", "FAIL",runManagerInfoObj);
																}
															}
															else{
																repfn.FnUpdateTestStepResHTML("Verify if OK button is present", "OK button is not present", "FAIL",runManagerInfoObj);
																blnFlag=false;
															}
														}
														else{
															repfn.FnUpdateTestStepResHTML("Verify if Cancel button is clicked", "Cancel button is not clicked", "FAIL",runManagerInfoObj);
															blnFlag=false;
														}
													}
													else{
														repfn.FnUpdateTestStepResHTML("Verify if Cancel button is present", "Cancel button is not present", "FAIL",runManagerInfoObj);
														blnFlag=false;
													}											
												}
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is displayed", "Save Auto-Pay button is not displayed", "FAIL",runManagerInfoObj);
												blnFlag=false;
											}
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify \'Accept Terms and Conditions\' checkbox is displayed", "\'Accept Terms and Conditions\' checkbox is not displayed", "FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else
								{
									repfn.FnUpdateTestStepResHTML("Verify if user is navigated to Verify Payment Information", "User is not navigated to Verify Payment Information", "FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is clicked", "Save Auto-Pay button is not clicked", "FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is enabled", "Save Auto-Pay button is not enabled", "FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is displayed", "Save Auto-Pay button is not displayed", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}

					driver.switchTo().defaultContent();

				}
				 catch (Exception e)

				 {		
					 blnFlag=false;
					 System.err.println("Message : "+e.getMessage());
					 System.err.println("Cause : "+e.getCause());
					 repfn.FnUpdateTestStepResHTML("Verify if User is not navigated from Verify Payment Information as Terms/Conditions not accepted", "User is navigated from Verify Payment Information when Terms/Conditions not accepted due to some exception", "FAIL",runManagerInfoObj);
				 }
				 m1.put("STEPSTATUS", blnFlag);
				 return blnFlag;
			}
		 public synchronized boolean FnBillPayOptionsUI(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
			 try
			 {
				 if(cnf.FnExplicitWait("XPATH", mbo.deliveryOption,driver))
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if User is able to see the title \"Modify Delivery Options\"", "User is able to see the title \"Modify Delivery Options\"", "PASS",runManagerInfoObj);
					 blnFlag=true;
				 }
				 else
				 {
					 blnFlag=false;
					 repfn.FnUpdateTestStepResHTML("Verify if User is able to see the title \"Modify Delivery Options\"", "User is not able to see the title \"Modify Delivery Options\"", "FAIL",runManagerInfoObj);
				 }
				 
				 if(cnf.FnExplicitWait("XPATH", mbo.onlineBill,driver))
				 {
					 if(cnf.FnExplicitWait("XPATH", mbo.onlineBillText,driver)){
						 WebElement onlineBillText = driver.findElement(By.xpath(mbo.onlineBillText));
						 repfn.FnUpdateTestStepResHTML("Verify if \"Online Bill\" radio button is displayed with description text", "\"Online Bill\" radio button is displayed with description text: "+onlineBillText.getText(), "PASS",runManagerInfoObj);
						 blnFlag=true;
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify if \"Online Bill\" radio button is displayed with description text", "\"Online Bill\" radio button is not displayed with description text", "FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if \"Online Bill\" radio button is displayed", "\"Online Bill\" radio button is not displayed", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
				 
				 if(cnf.FnExplicitWait("XPATH", mbo.paperAndOnlineBill,driver))
				 {
					 if(cnf.FnExplicitWait("XPATH", mbo.paperBillText,driver)){
						 WebElement paperBillText = driver.findElement(By.xpath(mbo.paperBillText));
						 repfn.FnUpdateTestStepResHTML("Verify if \"Paper & Online Bill\" radio button is displayed with description text", "\"Paper & Online Bill\" radio button is displayed with description text: "+paperBillText.getText(), "PASS",runManagerInfoObj);
						 blnFlag=true;
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify if \"Paper & Online Bill\" radio button is displayed with description text", "\"Paper & Online Bill\" radio button is not displayed with description text", "FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if \"Paper & Online Bill\" radio button is displayed", "\"Paper & Online Bill\" radio button is not displayed", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
				 
				 if(cnf.FnExplicitWait("XPATH", mbo.cancelButtonForBillPay,driver))
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if User is able to see the Cancel link ", "User is able to see the Cancel link", "PASS",runManagerInfoObj); 
					 blnFlag=true;
				 }
				 else{
					 blnFlag=false;
					 repfn.FnUpdateTestStepResHTML("Verify if User is able to see the Cancel link ", "User is not able to see the Cancel link", "FAIL",runManagerInfoObj);
				 }
				 
				 if(cnf.FnExplicitWait("XPATH", mbo.disabledSavebutton,driver))
				 {
					 blnFlag=true;
					 repfn.FnUpdateTestStepResHTML("Verify if disabled Save button is displayed", "Disabled Save button is displayed", "PASS",runManagerInfoObj);
				 }
				 else
				 {
					 blnFlag=false;
					 repfn.FnUpdateTestStepResHTML("Verify if disabled Save button is displayed", "Disabled Save button is not displayed", "FAIL",runManagerInfoObj);
				 }
				 
			 }
			 catch (Exception e)
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if user is able to verify the bill pay options UI", "User is not able to verify the bill pay options UI due to some exception", "FAIL",runManagerInfoObj);
				 System.err.println("Message : "+e.getMessage());
				 System.err.println("Cause : "+e.getCause());
				 blnFlag=false;
			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;
		}
		
	         
		 public synchronized boolean FnInvalidAccountAndValidRoutingNumber(WebDriver driver, RunManagerInfo runManagerInfoObj)
		 {

			 String routingNumber = "";
			 String invalidAccountNumber = "";
			 String errorMessage = "";

			 try{

				 driver.switchTo().frame("iFrameResizer0");

				 if(cnf.FnExplicitWait("XPATH", mbo.RoutingNumber,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify Routing Number field is displayed under Payment Information option",
							 "Routing Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
					 WebElement RoutingNumber=driver.findElement(By.xpath(mbo.RoutingNumber));
					 routingNumber = m1.get("RoutingNumber").toString(); 
					 RoutingNumber.sendKeys(routingNumber,Keys.TAB);
					 repfn.FnUpdateTestStepResHTML("Verify Routing Number is entered","Routing Number " +routingNumber + "is entered","PASS",runManagerInfoObj);
					 blnFlag=true;
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify Routing Number field is displayed under Payment Information option",
							 "Routing Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }


				 if(cnf.FnExplicitWait("XPATH", mbo.BankAccountNumber,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify Bank Account Number field is displayed under Payment Information option",
							 "Bank Account Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
					 WebElement BankAccountNumber=driver.findElement(By.xpath(mbo.BankAccountNumber));
					 invalidAccountNumber = m1.get("InvalidAccount").toString(); 
					 BankAccountNumber.sendKeys(invalidAccountNumber,Keys.TAB);
					 repfn.FnUpdateTestStepResHTML("Verify Bank Account Number is entered","Bank Account Number " +invalidAccountNumber + "is entered","PASS",runManagerInfoObj);
					 blnFlag=true;
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify Bank Account Number field is displayed under Payment Information option",
							 "Bank Account Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }


				 if(cnf.FnExplicitWait("XPATH", mbo.BankAccountNumberError,driver)){
					 WebElement BankAccountNumberError=driver.findElement(By.xpath(mbo.BankAccountNumberError));
					 errorMessage = BankAccountNumberError.getAttribute("textContent");
					 repfn.FnUpdateTestStepResHTML("Verify Bank Account Number Error Message is displayed","Bank Account Number Error Message: " +errorMessage + "is displayed","PASS",runManagerInfoObj);
					 blnFlag=true;      				
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify Bank Account Number Error Message is displayed",
							 "Bank Account Number Error Message is not displayed when this number is entered: " +invalidAccountNumber,"FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }

				 driver.switchTo().defaultContent();

			 }

			 catch (Exception e)

			 {
				 repfn.FnUpdateTestStepResHTML("Verify User is able to get the error message on entering invalid account number",
						 "User is not able to get the error message on entering invalid account number due to some exception","FAIL",runManagerInfoObj);

				 blnFlag=false;
				 System.err.println("Message : "+e.getMessage());
				 System.err.println("Cause : "+e.getCause());

			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;
		 }
		public synchronized boolean fnCreditDebitAutoPayPaymentConfirmation_WithoutTC(WebDriver driver, RunManagerInfo runManagerInfoObj) {
			try
			{
				boolean blnFlag1 = app.EditCreditCard(driver,runManagerInfoObj);
				boolean blnFlag2 = EditExpDate(driver,runManagerInfoObj);
				if(blnFlag1 && blnFlag2){
					boolean blnFlag3 = fnAutoPayCreditCardTC(driver,runManagerInfoObj);
					if(blnFlag3){
						repfn.FnUpdateTestStepResHTML("Verify User is not able to proceed with payment if the T&C is not agreed to.","User is not able to proceed with payment if the T&C is not agreed to.","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify User is not able to proceed with payment if the T&C is not agreed to.","User is able to proceed with payment if the T&C is not agreed to.","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User is able to enter Credit Card and Expiry Date","User is not able to enter Credit Card and Expiry Date","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				driver.navigate().refresh();


			}
			catch (Exception e)

			{		
				repfn.FnUpdateTestStepResHTML("Verify User is not able to proceed with payment if the T&C is not agreed to.","User is able to proceed with payment if the T&C is not agreed to due to some exception","FAIL",runManagerInfoObj);
				blnFlag=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}

			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		public synchronized boolean FnVerifyPayBillUI_CheckingSaving(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
			
			
			
			try{
				
				driver.switchTo().frame("iFrameResizer0");
				
				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_PayBillOptionsText,driver)){
					WebElement PayBill_PayBillOptionsText=driver.findElement(By.xpath(mbo.PayBill_PayBillOptionsText));
					if(PayBill_PayBillOptionsText.getAttribute("textContent").contains("Pay Bill Options")){
						repfn.FnUpdateTestStepResHTML("Verify Pay Bill Options Header text is displayed", "Pay Bill Options Header text is displayed","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Pay Bill Options Header text is displayed", "Pay Bill Options Header text is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Pay Bill Options Header text is displayed", "Pay Bill Options Header text is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_SelectPaymentTypeText,driver)){
					WebElement PayBill_SelectPaymentTypeText=driver.findElement(By.xpath(mbo.PayBill_SelectPaymentTypeText));
					if(PayBill_SelectPaymentTypeText.getAttribute("textContent").contains("Select Payment Type")){
						repfn.FnUpdateTestStepResHTML("Verify Select Payment Type text is displayed under Pay Bill Options Header", 
								"Select Payment Type text is displayed under Pay Bill Options Header","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Select Payment Type text is displayed under Pay Bill Options Header", 
								"Select Payment Type text is not displayed under Pay Bill Options Header","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Select Payment Type text is displayed under Pay Bill Options Header", 
							"Select Payment Type text is not displayed under Pay Bill Options Header","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				
				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_Credit_Debit_Text,driver)){
					WebElement PayBill_Credit_Debit_Text=driver.findElement(By.xpath(mbo.PayBill_Credit_Debit_Text));
					if(PayBill_Credit_Debit_Text.getAttribute("textContent").contains("Credit/Debit Card")){
						repfn.FnUpdateTestStepResHTML("Verify Credit/Debit Card sub-option is displayed under Select Payment Type Option", 
								"Credit/Debit Card sub-option is displayed under Select Payment Type Option","PASS",runManagerInfoObj);				
						blnFlag=true;				
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Credit/Debit Card sub-option is displayed under Select Payment Type Option", 
								"Credit/Debit Card sub-option is not displayed under Select Payment Type Option","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Credit/Debit Card sub-option is displayed under Select Payment Type Option", 
							"Credit/Debit Card sub-option is not displayed under Select Payment Type Option","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_Checking_Savings_Text,driver)){
					WebElement PayBill_Checking_Savings_Text=driver.findElement(By.xpath(mbo.PayBill_Checking_Savings_Text));
					if(PayBill_Checking_Savings_Text.getAttribute("textContent").contains("Checking/Savings")){
						repfn.FnUpdateTestStepResHTML("Verify Checking/Savings sub-option is displayed under Select Payment Type Option", 
								"Checking/Savings sub-option is displayed under Select Payment Type Option","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Checking/Savings sub-option is displayed under Select Payment Type Option", 
								"Checking/Savings sub-option is not displayed under Select Payment Type Option","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Checking/Savings sub-option is displayed under Select Payment Type Option", 
							"Checking/Savings sub-option is not displayed under Select Payment Type Option","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_OtherPaymentMethods_Text,driver)){
					WebElement PayBill_OtherPaymentMethods_Text=driver.findElement(By.xpath(mbo.PayBill_OtherPaymentMethods_Text));
					if(PayBill_OtherPaymentMethods_Text.getAttribute("textContent").contains("Other Payment Methods")){
						repfn.FnUpdateTestStepResHTML("Verify Other Payment Methods sub-option is displayed under Select Payment Type Option", 
								"Other Payment Methods sub-option is displayed under Select Payment Type Option","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Other Payment Methods sub-option is displayed under Select Payment Type Option", 
								"Other Payment Methods sub-option is not displayed under Select Payment Type Option","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Other Payment Methods sub-option is displayed under Select Payment Type Option", 
							"Other Payment Methods sub-option is not displayed under Select Payment Type Option","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_SelectPaymentFrequencyText,driver)){
					WebElement PayBill_SelectPaymentFrequencyText=driver.findElement(By.xpath(mbo.PayBill_SelectPaymentFrequencyText));
					if(PayBill_SelectPaymentFrequencyText.getAttribute("textContent").contains("Select Payment Frequency")){
						repfn.FnUpdateTestStepResHTML("Verify Select Payment Frequency text is displayed under Pay Bill Options Header", 
								"Select Payment Frequency text is displayed under Pay Bill Options Header","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Select Payment Frequency text is displayed under Pay Bill Options Header", 
								"Select Payment Frequency text is not displayed under Pay Bill Options Header","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Select Payment Frequency text is displayed under Pay Bill Options Header", 
							"Select Payment Frequency text is not displayed under Pay Bill Options Header","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.PaymentFrequency_AutoPay_Text,driver)){
					WebElement PaymentFrequency_AutoPay_Text=driver.findElement(By.xpath(mbo.PaymentFrequency_AutoPay_Text));
					if(PaymentFrequency_AutoPay_Text.getAttribute("textContent").contains("Auto-Pay (Recurring)")){
						repfn.FnUpdateTestStepResHTML("Verify Auto-Pay (Recurring) sub-option is displayed under Select Payment Frequency Option", 
								"Auto-Pay (Recurring) sub-option is displayed under Select Payment Frequency Option","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Auto-Pay (Recurring) sub-option is displayed under Select Payment Frequency Option", 
								"Auto-Pay (Recurring) sub-option is not displayed under Select Payment Frequency Option","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Auto-Pay (Recurring) sub-option is displayed under Select Payment Frequency Option", 
							"Auto-Pay (Recurring) sub-option is not displayed under Select Payment Frequency Option","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.PaymentFrequency_OneTime_Text,driver)){
					WebElement PaymentFrequency_OneTime_Text=driver.findElement(By.xpath(mbo.PaymentFrequency_OneTime_Text));
					if(PaymentFrequency_OneTime_Text.getAttribute("textContent").contains("One-Time")){
						repfn.FnUpdateTestStepResHTML("Verify One-Time sub-option is displayed under Select Payment Frequency Option", 
								"One-Time sub-option is displayed under Select Payment Frequency Option","PASS",runManagerInfoObj);

						//driver.switchTo().defaultContent();
						//driver.switchTo().frame("iFrameResizer0");
						//if(cnf.FnExplicitWait("XPATH", mbo.PaymentFrequency_OneTime_Selection)){
						if(cnf.isElementExistOne("XPATH", mbo.PaymentFrequency_OneTime_Selection,driver)){
							WebElement PaymentFrequency_OneTime_Selection=driver.findElement(By.xpath(mbo.PaymentFrequency_OneTime_Selection));
							String selectionState = PaymentFrequency_OneTime_Selection.getAttribute("aria-checked");

							if(selectionState.equalsIgnoreCase("true")){
								repfn.FnUpdateTestStepResHTML("Verify One-Time radio button is selected by default", 
										"One-Time radio button is selected by default","PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify One-Time radio button is selected by default", 
										"One-Time radio button is not selected by default","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							blnFlag=false;
						}				
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify One-Time sub-option is displayed under Select Payment Frequency Option", 
								"One-Time sub-option is not displayed under Select Payment Frequency Option","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify One-Time sub-option is displayed under Select Payment Frequency Option", 
							"One-Time sub-option is not displayed under Select Payment Frequency Option","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader,driver)){
					WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
					if(PaymentInformationHeader.getAttribute("textContent").contains("Payment Information")){
						repfn.FnUpdateTestStepResHTML("Verify Payment Information Header text is displayed", "Payment Information Header text is displayed","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Payment Information Header text is displayed", "Payment Information Header text is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Payment Information Header text is displayed", "Payment Information Header text is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_BankInformation_Text,driver)){
					WebElement PayBill_BankInformation_Text=driver.findElement(By.xpath(mbo.PayBill_BankInformation_Text));
					if(PayBill_BankInformation_Text.getAttribute("textContent").contains("Bank Information")){
						repfn.FnUpdateTestStepResHTML("Verify Bank Information text is displayed under Payment Information Header", 
								"Bank Information text is displayed under Payment Information Header","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Bank Information text is displayed under Payment Information Header", 
								"Bank Information text is not displayed under Payment Information Header","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Bank Information text is displayed under Payment Information Header", 
							"Bank Information text is not displayed under Payment Information Header","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_AccountType_Text,driver)){
					WebElement PayBill_AccountType_Text=driver.findElement(By.xpath(mbo.PayBill_AccountType_Text));
					if(PayBill_AccountType_Text.getAttribute("textContent").contains("Account Type")){
						repfn.FnUpdateTestStepResHTML("Verify Account Type text is displayed under Bank Information Heading", 
								"Account Type text is displayed under Bank Information Heading","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Account Type text is displayed under Bank Information Heading", 
								"Account Type text is not displayed under Bank Information Heading","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Account Type text is displayed under Bank Information Heading", 
							"Account Type text is not displayed under Bank Information Heading","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_Checking_Text,driver)){
					WebElement PayBill_Checking_Text=driver.findElement(By.xpath(mbo.PayBill_Checking_Text));
					if(PayBill_Checking_Text.getAttribute("textContent").contains("Checking")){
						repfn.FnUpdateTestStepResHTML("Verify Checking sub-option text is displayed under Account Type Option", 
								"Checking sub-option text is displayed under Account Type Option","PASS",runManagerInfoObj);
						
						if(cnf.FnExplicitWait("XPATH", mbo.PayBill_Checking_RadioButton,driver)){					
							repfn.FnUpdateTestStepResHTML("Verify Checking radio button is displayed under Account Type Option", 
									"Checking radio button is displayed under Account Type Option","PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Checking radio button is displayed under Account Type Option", 
									"Checking radio button is not displayed under Account Type Option","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
						
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Checking sub-option text is displayed under Account Type Option", 
								"Checking sub-option text is not displayed under Account Type Option","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Checking sub-option text is displayed under Account Type Option", 
							"Checking sub-option text is not displayed under Account Type Option","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_Savings_Text,driver)){
					WebElement PayBill_Savings_Text=driver.findElement(By.xpath(mbo.PayBill_Savings_Text));
					if(PayBill_Savings_Text.getAttribute("textContent").contains("Savings")){
						repfn.FnUpdateTestStepResHTML("Verify Savings sub-option text is displayed under Account Type Option", 
								"Savings sub-option text is displayed under Account Type Option","PASS",runManagerInfoObj);
						
						if(cnf.FnExplicitWait("XPATH", mbo.PayBill_Savings_RadioButton,driver)){					
							repfn.FnUpdateTestStepResHTML("Verify Savings radio button is displayed under Account Type Option", 
									"Savings radio button is displayed under Account Type Option","PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Savings radio button is displayed under Account Type Option", 
									"Savings radio button is not displayed under Account Type Option","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
						
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Savings sub-option text is displayed under Account Type Option", 
								"Savings sub-option text is not displayed under Account Type Option","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Savings sub-option text is displayed under Account Type Option", 
							"Savings sub-option text is not displayed under Account Type Option","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_RoutingNumberText,driver)){
					WebElement PayBill_RoutingNumberText=driver.findElement(By.xpath(mbo.PayBill_RoutingNumberText));
					if(PayBill_RoutingNumberText.getAttribute("textContent").contains("9-Digit Routing Number")){
						repfn.FnUpdateTestStepResHTML("Verify 9-Digit Routing Number sub-heading is displayed under Account Type Option", 
								"9-Digit Routing Number sub-heading is displayed under Account Type Option","PASS",runManagerInfoObj);
						
						if(cnf.FnExplicitWait("XPATH", mbo.RoutingNumber,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Routing Number input field is displayed under Routing Number sub-heading", 
									"Routing Number input field is displayed under Routing Number sub-heading","PASS",runManagerInfoObj);
							
							if(cnf.FnExplicitWait("XPATH", mbo.PayBill_RoutingNumberToolTip,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Routing Number Tool Tip icon is displayed along Routing Number input field", 
										"Routing Number Tool Tip icon is displayed along Routing Number input field","PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Routing Number Tool Tip icon is displayed along Routing Number input field", 
										"Routing Number Tool Tip icon is not displayed along Routing Number input field","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Routing Number input field is displayed under Routing Number sub-heading", 
									"Routing Number input field is not displayed under Routing Number sub-heading","FAIL",runManagerInfoObj);
							blnFlag=false;
							
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify 9-Digit Routing Number sub-heading is displayed under Account Type Option", 
								"9-Digit Routing Number sub-heading is not displayed under Account Type Option","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify 9-Digit Routing Number sub-heading is displayed under Account Type Option", 
							"9-Digit Routing Number sub-heading is not displayed under Account Type Option","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_AccountNumberText,driver)){
					WebElement PayBill_AccountNumberText=driver.findElement(By.xpath(mbo.PayBill_AccountNumberText));
					if(PayBill_AccountNumberText.getAttribute("textContent").contains("Bank Account Number")){
						repfn.FnUpdateTestStepResHTML("Verify Bank Account Number sub-heading is displayed under Account Type Option", 
								"Bank Account Number sub-heading is displayed under Account Type Option","PASS",runManagerInfoObj);
						
						if(cnf.FnExplicitWait("XPATH", mbo.BankAccountNumber,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Bank Account Number input field is displayed under Bank Account Number sub-heading", 
									"Bank Account Number input field is displayed under Bank Account Number sub-heading","PASS",runManagerInfoObj);
							
							if(cnf.FnExplicitWait("XPATH", mbo.PayBill_AccountNumberToolTip,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Bank Account Number Tool Tip icon is displayed along Bank Account Number input field", 
										"Bank Account Number Tool Tip icon is displayed along Bank Account Number input field","PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Bank Account Number Tool Tip icon is displayed along Bank Account Number input field", 
										"Bank Account Number Tool Tip icon is not displayed along Bank Account Number input field","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Bank Account Number input field is displayed under Bank Account Number sub-heading", 
									"Bank Account Number input field is not displayed under Bank Account Number sub-heading","FAIL",runManagerInfoObj);
							blnFlag=false;
							
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Bank Account Number sub-heading is displayed under Account Type Option", 
								"Bank Account Number sub-heading is not displayed under Account Type Option","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Bank Account Number sub-heading is displayed under Account Type Option", 
							"Bank Account Number sub-heading is not displayed under Account Type Option","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CardImage,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Image of a sample check leaf is displayed showing Routing number & Account number and Check number", 
							"Image of a sample check leaf is displayed showing Routing number & Account number and Check number","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Image of a sample check leaf is displayed showing Routing number & Account number and Check number", 
							"Image of a sample check leaf is not displayed showing Routing number & Account number and Check number","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_AmountAndDate_Text,driver)){
					WebElement PayBill_AmountAndDate_Text=driver.findElement(By.xpath(mbo.PayBill_AmountAndDate_Text));
					if(PayBill_AmountAndDate_Text.getAttribute("textContent").contains("Amount & Date")){
						repfn.FnUpdateTestStepResHTML("Verify Amount & Date text is displayed under Payment Information Header", 
								"Amount & Date text is displayed under Payment Information Header","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Amount & Date text is displayed under Payment Information Header", 
								"Amount & Date text is not displayed under Payment Information Header","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Amount & Date text is displayed under Payment Information Header", 
							"Amount & Date text is not displayed under Payment Information Header","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_AmountDue_Text,driver)){
					WebElement PayBill_AmountDue_Text=driver.findElement(By.xpath(mbo.PayBill_AmountDue_Text));
					if(PayBill_AmountDue_Text.getAttribute("textContent").contains("Amount Due")){
						repfn.FnUpdateTestStepResHTML("Verify Amount Due text is displayed under Amount & Date Option", 
								"Amount Due text is displayed under Amount & Date Option","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Amount Due text is displayed under Amount & Date Option", 
								"Amount Due text is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Amount Due text is displayed under Amount & Date Option", 
							"Amount Due text is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_AmountDue,driver)){
					WebElement PayBill_AmountDue=driver.findElement(By.xpath(mbo.PayBill_AmountDue));
						repfn.FnUpdateTestStepResHTML("Verify Amount Due is displayed under Amount & Date Option", 
								"Amount Due: "+PayBill_AmountDue.getText()+" is displayed under Amount & Date Option","PASS",runManagerInfoObj);
						blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Amount Due is displayed under Amount & Date Option", 
							"Amount Due is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_DueBy_Text,driver)){
					WebElement PayBill_DueBy_Text=driver.findElement(By.xpath(mbo.PayBill_DueBy_Text));
					if(PayBill_DueBy_Text.getAttribute("textContent").contains("Due By")){
						repfn.FnUpdateTestStepResHTML("Verify Due By text is displayed under Amount & Date Option", 
								"Due By text is displayed under Amount & Date Option","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Due By text is displayed under Amount & Date Option", 
								"Due By text is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Due By text is displayed under Amount & Date Option", 
							"Due By text is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_DueByDate,driver)){
					WebElement PayBill_DueByDate=driver.findElement(By.xpath(mbo.PayBill_DueByDate));
						repfn.FnUpdateTestStepResHTML("Verify Amount Due Date is displayed under Amount & Date Option", 
								"Amount Due Date: "+PayBill_DueByDate.getText()+" is displayed under Amount & Date Option","PASS",runManagerInfoObj);
						blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Amount Due Date is displayed under Amount & Date Option", 
							"Amount Due Date is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_PaymentAmount_Text,driver)){
					WebElement PayBill_PaymentAmount_Text=driver.findElement(By.xpath(mbo.PayBill_PaymentAmount_Text));
					if(PayBill_PaymentAmount_Text.getAttribute("textContent").contains("Payment Amount")){
						repfn.FnUpdateTestStepResHTML("Verify Payment Amount sub-heading is displayed under Amount & Date Option", 
								"Payment Amount sub-heading is displayed under Amount & Date Option","PASS",runManagerInfoObj);
						
						if(cnf.FnExplicitWait("XPATH", mbo.PaymentAmount,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Payment Amount input field is displayed under Payment Amount sub-heading", 
									"Payment Amount input field is displayed under Payment Amount sub-heading","PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Payment Amount input field is displayed under Payment Amount sub-heading", 
									"Payment Amount input field is not displayed under Payment Amount sub-heading","FAIL",runManagerInfoObj);
							blnFlag=false;
							
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Payment Amount sub-heading is displayed under Amount & Date Option", 
								"Payment Amount sub-heading is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Payment Amount sub-heading is displayed under Amount & Date Option", 
							"Payment Amount sub-heading is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_PaymentDate_Text,driver)){
					WebElement PayBill_PaymentDate_Text=driver.findElement(By.xpath(mbo.PayBill_PaymentDate_Text));
					if(PayBill_PaymentDate_Text.getAttribute("textContent").contains("Payment Date")){
						repfn.FnUpdateTestStepResHTML("Verify Payment Date sub-heading is displayed under Amount & Date Option", 
								"Payment Date sub-heading is displayed under Amount & Date Option","PASS",runManagerInfoObj);
						
						if(cnf.FnExplicitWait("XPATH", mbo.PaymentDate,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Payment Date input field is displayed under Payment Date sub-heading", 
									"Payment Date input field is displayed under Payment Date sub-heading","PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Payment Date input field is displayed under Payment Date sub-heading", 
									"Payment Date input field is not displayed under Payment Date sub-heading","FAIL",runManagerInfoObj);
							blnFlag=false;
							
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Payment Date sub-heading is displayed under Amount & Date Option", 
								"Payment Date sub-heading is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Payment Date sub-heading is displayed under Amount & Date Option", 
							"Payment Date sub-heading is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.SupportLinkPayBill,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Support Link is displayed on Pay Bill page", 
								"Support Link is displayed on Pay Bill page","PASS",runManagerInfoObj);
						blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Support Link is displayed on Pay Bill page", 
							"Support Link is not displayed on Pay Bill page","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.PayNowButton,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Pay Now button is displayed on Pay Bill page", 
							"Pay Now button is displayed on Pay Bill page","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Pay Now button is displayed on Pay Bill page", 
							"Pay Now button is not displayed on Pay Bill page","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				driver.switchTo().defaultContent();

			}
			
			catch(Exception e)
			{
				blnFlag=false;
				repfn.FnUpdateTestStepResHTML("Verify User is able to verify UI on Pay Bill page", "User is not able to verify UI on Pay Bill page due to some exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		public synchronized boolean PaymentInfo_OTP_CheckingSaving_Checked(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
		{
			String checkingRadioBtnStatus="";
			try
			{
				driver.switchTo().frame("iFrameResizer0");
				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_PaymentInfo,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the display of Payment Info section in Paybill screen","Payment Info section is displayed for OTP-Checkings/Savings with the header:"+" "+driver.findElement(By.xpath(mbo.PayBill_PaymentInfo_Hdr)).getText(),"PASS",runManagerInfoObj);
					if(cnf.FnExplicitWait("XPATH", mbo.PaymentInfo_CheckingRadioBtn,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the display of Checkings radio button in Payment Info section","Checkings radio button is present in Payment Info section","PASS",runManagerInfoObj);
						WebElement CheckingsRadioBtn=driver.findElement(By.xpath(mbo.PaymentInfo_CheckingRadioBtn));

						if(cnf.isElementExistOne("XPATH", mbo.PaymentInfo_CheckingRadioBtn_Selection,driver)){
							WebElement PaymentInfo_CheckingRadioBtn_Selection=driver.findElement(By.xpath(mbo.PaymentInfo_CheckingRadioBtn_Selection));
							checkingRadioBtnStatus=PaymentInfo_CheckingRadioBtn_Selection.getAttribute("aria-required");
							if(checkingRadioBtnStatus.equalsIgnoreCase("true"))
							{
								repfn.FnUpdateTestStepResHTML("Verify Checkings radio button in Payment Info section is checked","Checkings radio button is checked already","PASS",runManagerInfoObj);
								blnFlag=true;
							}

							else if(checkingRadioBtnStatus.equalsIgnoreCase("false"))
							{
								repfn.FnUpdateTestStepResHTML("Verify Checkings radio button in Payment Info section is checked","Checkings radio button is not checked already","PASS",runManagerInfoObj);
								if(cnf.JSClick(CheckingsRadioBtn,driver))
								{
									repfn.FnUpdateTestStepResHTML("Verify Checkings radio button in Payment Info section is clicked","Checkings radio button is clicked","PASS",runManagerInfoObj);
									checkingRadioBtnStatus=PaymentInfo_CheckingRadioBtn_Selection.getAttribute("aria-required");
									if(checkingRadioBtnStatus.equalsIgnoreCase("true"))
									{
										repfn.FnUpdateTestStepResHTML("Verify Checkings radio button in Payment Info section is checked","Checkings radio button is checked","PASS",runManagerInfoObj);
										blnFlag=true;
									}
									else
									{
										repfn.FnUpdateTestStepResHTML("Verify Checkings radio button in Payment Info section is checked","Checkings radio button is not checked","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else
								{
									repfn.FnUpdateTestStepResHTML("Verify Checkings radio button in Payment Info section is clicked","Checkings radio button is not clicked","FAIL",runManagerInfoObj);
									blnFlag=false;
								}

							}

						}
						else{
							blnFlag=false;
						}

					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the display of Checkings radio button in Payment Info section","Checkings radio button is not present in Payment Info section","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the display of Payment Info section in Paybill screen","Payment Info section is not displayed for OTP-Checkings/Savings","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				driver.switchTo().defaultContent();
			}

			catch(Exception e)
			{
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause()); 
				repfn.FnUpdateTestStepResHTML("Verify the display of Payment Info section in Paybill screen","Payment Info section is not displayed and checked for OTP-Checkings/Savings due to some exception","FAIL",runManagerInfoObj);
				blnFlag=false;

			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		
		public synchronized boolean PaymentInfo_OTP_CheckingSaving_FillDetails(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
		{

			Date d=Calendar.getInstance().getTime();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

			String currentDate=sdf.format(d);

			String dateArray[]=currentDate.split("/");
			String year=dateArray[0];
			String month=dateArray[1];
			String day=dateArray[2];
			String CurrentPaymentDate = (month)+"/"+(day)+"/"+year;
			String CurrentPaymentDateChrome = (month)+"/"+(day);
			System.out.println(CurrentPaymentDate);
			System.out.println(CurrentPaymentDateChrome);

			try
			{

				driver.switchTo().frame("iFrameResizer0");
				if(cnf.FnExplicitWait("XPATH", mbo.PaymentInfo_RoutingNum,driver)){
					String RoutingNumber=m1.get("RoutingNumber").toString();
					repfn.FnUpdateTestStepResHTML("Verify Routing Number field is displayed under Payment Information option",
							"Routing Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
					WebElement PaymentInfo_RoutingNum=driver.findElement(By.xpath(mbo.PaymentInfo_RoutingNum));
					PaymentInfo_RoutingNum.sendKeys(RoutingNumber);
					repfn.FnUpdateTestStepResHTML("Verify Routing Number is entered","Routing Number: " +RoutingNumber + " is entered","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Routing Number field is displayed under Payment Information option",
							"Routing Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
					blnFlag=false;
				}


				if(cnf.FnExplicitWait("XPATH", mbo.PaymentInfo_AccNum,driver)){
					String BankAccountNumber=m1.get("BankAccountNumber").toString();
					repfn.FnUpdateTestStepResHTML("Verify Bank Account Number field is displayed under Payment Information option",
							"Bank Account Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
					WebElement PaymentInfo_AccNum=driver.findElement(By.xpath(mbo.PaymentInfo_AccNum));
					PaymentInfo_AccNum.sendKeys(BankAccountNumber);
					repfn.FnUpdateTestStepResHTML("Verify Bank Account Number is entered","Bank Account Number:  " +BankAccountNumber + " is entered","PASS",runManagerInfoObj);
					blnFlag=true;
				} 
				else{
					repfn.FnUpdateTestStepResHTML("Verify Bank Account Number field is displayed under Payment Information option",
							"Bank Account Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				String Amount=m1.get("Amount").toString();
				if(cnf.FnExplicitWait("XPATH", mbo.PaymentInfo_Amt,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if Payment Amount field is displayed", "Payment Amount field is displayed", "PASS",runManagerInfoObj);
					WebElement PayBill_CreditDebit_Amount=driver.findElement(By.xpath(mbo.PaymentInfo_Amt));
					if(PayBill_CreditDebit_Amount.isDisplayed())
					{
						PayBill_CreditDebit_Amount.sendKeys(Amount,Keys.TAB);
						repfn.FnUpdateTestStepResHTML("Enter a valid Payment Amount","Payment Amount is entered" , "PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Enter a valid Payment Amount","Payment Amount is not entered" , "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify if Payment Amount field is displayed", "Payment Amount field is not displayed", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}


				if(cnf.FnExplicitWait("XPATH", mbo.PaymentInfo_Date,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Payment Date field is displayed under Payment Information option",
							"Payment Amount Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
					WebElement PayBill_CreditDebit_PayDate=driver.findElement(By.xpath(mbo.PaymentInfo_Date));

					String Browser=m1.get("BROWSER").toString();
					System.out.println("Browser is:   "+Browser);
					if(Browser.equalsIgnoreCase("chrome"))
					{
						PayBill_CreditDebit_PayDate.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),CurrentPaymentDateChrome);
						repfn.FnUpdateTestStepResHTML("Verify Payment Date is entered","Payment date entered: " +CurrentPaymentDateChrome ,"PASS",runManagerInfoObj);

					}else {
						PayBill_CreditDebit_PayDate.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),CurrentPaymentDate);
						repfn.FnUpdateTestStepResHTML("Verify Payment Date is entered","Payment date entered: " +CurrentPaymentDate ,"PASS",runManagerInfoObj);
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Payment Date field is displayed under Payment Information option",
							"Payment Date field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
					blnFlag=false;
				}


				if(cnf.FnExplicitWait("XPATH", mbo.PaymentInfo_PayNowBtn,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the display of Pay now button in Payment Info section","Pay now button is displayed in Payment Info section","PASS",runManagerInfoObj);
					WebElement PayNowBtn=driver.findElement(By.xpath(mbo.PaymentInfo_PayNowBtn));
					Thread.sleep(5000);
					if(PayNowBtn.isEnabled())
					{
						repfn.FnUpdateTestStepResHTML("Verify the Pay now button is enabled in Payment Info section","Pay now button is enabled in Payment Info section as all the fields are filled","PASS",runManagerInfoObj);
						if(cnf.JSClick(PayNowBtn,driver))
						{
							Thread.sleep(3000);
							repfn.FnUpdateTestStepResHTML("Verify the Pay now button is clicked","Pay now button is clicked","PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("XPATH", mbo.PaymentInfo_VerifyPaymentInfo_Hdr,driver))
							{
								repfn.FnUpdateTestStepResHTML("Verify if user is taken to Verify Payment Info screen on click of Pay now button","User is taken to Verify Payment Info screen on click of Pay now button","PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify if user is taken to Verify Payment Info screen on click of Pay now button","User is not taken to Verify Payment Info screen on click of Pay now button","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else
						{
							repfn.FnUpdateTestStepResHTML("Verify the Pay now button is clicked","Pay now button is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the Pay now button is enabled in Payment Info section","Pay now button is not enabled in Payment Info section though all the fields are not filled","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the display of Pay now button in Payment Info section","Pay now button is not displayed in Payment Info section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				driver.switchTo().defaultContent();
			}

			catch(Exception e)
			{
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());	
				repfn.FnUpdateTestStepResHTML("Verify User is able to navigate to Payment Information screen","User is not able to navigate to Payment Information screen due to some exception","FAIL",runManagerInfoObj);
				blnFlag=false;

			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}
		public synchronized boolean Q2Wall_OTP_CheckingsSavings_FillDetails(WebDriver driver, RunManagerInfo runManagerInfoObj)
		{
			try
			{
				driver.switchTo().frame("iFrameResizer0");
				OTPChecked(driver,runManagerInfoObj);
				Thread.sleep(2000);
				CheckingSavingsChecked(driver,runManagerInfoObj);
				
				Q2Wall_PaymentInfo_OTP_CheckingSaving_Checked(driver,runManagerInfoObj);
				PaymentInfo_OTP_CheckingSaving_FillDetails(driver,runManagerInfoObj);
				//VerifyPaymentInfo();
				
				Q2wall_VerifyPaymentInfo(driver,runManagerInfoObj);
				driver.navigate().refresh();
				app.AlertAccept(driver,runManagerInfoObj);
				driver.switchTo().defaultContent();
				blnFlag=true;
			}
			catch(Exception e)
			{
				System.err.println("Message : "+e.getMessage());
		  System.err.println("Cause : "+e.getCause());	
			
			}
			 m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
		}
		public synchronized boolean Q2wall_VerifyPaymentInfo(WebDriver driver, RunManagerInfo runManagerInfoObj)
		{
			List all = new ArrayList();
			try
			{
				//driver.switchTo().defaultContent();
				/*if(cnf.isElementExist(By.xpath(mbo.Q2Wall_PaymentInfo_VerifyPaymentInfo)))
			       {
				    repfn.FnUpdateTestStepResHTML("Verify if user is is Verify Payment Info screen","User is in Verify Payment Info screen","PASS",runManagerInfoObj);
		      */
				    driver.switchTo().frame("iFrameResizer0");
				    
				    if(cnf.isElementExist(By.xpath(mbo.Q2Wall_PaymentInfo_VerifyPaymentInfo_Hdr),driver))
		      {
				    repfn.FnUpdateTestStepResHTML("Verify the Verify Payment Info screen is displayed with title","Verify Payment Info screen is displayed with title"+" "+driver.findElement(By.xpath(mbo.Q2Wall_PaymentInfo_VerifyPaymentInfo_Hdr)).getText(),"PASS",runManagerInfoObj);
		          blnFlag=true;
		      }
		      else
		      {
		      	repfn.FnUpdateTestStepResHTML("Verify the Verify Payment Info screen is displayed with title","Verify Payment Info screen is displayed without title","FAIL",runManagerInfoObj);
		          blnFlag=false;
		      }
		      if(cnf.isElementExist(By.xpath(mbo.Q2Wall_VerifyPaymentInfo_Hdr),driver))
		      {
				    repfn.FnUpdateTestStepResHTML("Verify the Verify Payment Info screen is displayed with sub heading","Verify Payment Info screen is displayed with sub heading"+" "+driver.findElement(By.xpath(mbo.Q2Wall_VerifyPaymentInfo_Hdr)).getText(),"PASS",runManagerInfoObj);
		          blnFlag=true;
		      }
		      else
		      {
		      	repfn.FnUpdateTestStepResHTML("Verify the Verify Payment Info screen is displayed with sub heading","Verify Payment Info screen is displayed without sub heading","FAIL",runManagerInfoObj);
		          blnFlag=false;
		      }
		      
		      if(cnf.isElementExist(By.xpath(mbo.Q2Wall_VerifyPaymentInfo_AllDetails),driver))
		      {
				   List <WebElement> details=driver.findElements(By.xpath(mbo.Q2Wall_VerifyPaymentInfo_AllDetails));
				   for(int j=0;j<details.size();j++)
				   {
					all.add(details.get(j).getText());
		      	repfn.FnUpdateTestStepResHTML("Verify the display of Details in Verify Payment Info screen ",details.get(j).getText()+" "+"is displayed in Verify Payment Info screen","PASS",runManagerInfoObj);
		         
				   }
				   if(Pattern.matches("\\*([0-9]{4})",all.get(0).toString()))
						   {
					   repfn.FnUpdateTestStepResHTML("Verify if Routing number is masked and only 4 characters are displayed","Routing number is masked and only 4 characters are displayed"+all.get(0).toString(), "PASS",runManagerInfoObj);
						  blnFlag=true;
						   }
				   else
				   {
					 repfn.FnUpdateTestStepResHTML("Verify if Routing number is masked and only 4 characters are displayed","Routing number is not masked and only 4 characters are displayed", "FAIL",runManagerInfoObj);
						  blnFlag=false;
				   }
				   if(Pattern.matches("\\*([0-9]{4})",all.get(1).toString()))
					   {
				   repfn.FnUpdateTestStepResHTML("Verify if Account number is masked and only 4 characters are displayed","Account number is masked and only 4 characters are displayed"+all.get(1).toString(), "PASS",runManagerInfoObj);
					  blnFlag=true;
					   }
			   else
			   {
				 repfn.FnUpdateTestStepResHTML("Verify if Account number is masked and only 4 characters are displayed","Account number is not masked and only 4 characters are displayed", "FAIL",runManagerInfoObj);
				  blnFlag=false;
			   }
			  
				   if(all.get(2).toString().equalsIgnoreCase("Checking"))
				   {
					   repfn.FnUpdateTestStepResHTML("Verify the Account type is Checkings/Savings in Verify payment info screen","Account type is Checkings in Verify payment info screen","PASS",runManagerInfoObj);
				       blnFlag=true;
				   }
				   else if(all.get(2).toString().equalsIgnoreCase("Savings"))
				   {
					 repfn.FnUpdateTestStepResHTML("Verify the Account type is Checkings/Savings in Verify payment info screen","Account type is Savings in Verify payment info screen","PASS",runManagerInfoObj);
				       blnFlag=false;
				   }
				 if(Pattern.matches("(\\$([0-9]{1}||[0-9]{2}||[0-9]{3})\\.[0-9]{2})", all.get(3).toString()))	
				 {
					 blnFlag=true;
					 repfn.FnUpdateTestStepResHTML("Verify if \"Amount\" in format \"$XX.XX\" is correct", "\"Amount\" format  is correct: "+all.get(3).toString(), "PASS",runManagerInfoObj);
					 
				 }
				 else
				 {
					 blnFlag=false;
					 repfn.FnUpdateTestStepResHTML("Verify if \"Amount\" in format \"$XX.XX\" is correct", "\"Amount\" format  is not correct ", "FAIL",runManagerInfoObj);
				 }
		     if(cnf.isValidFormat("mm/dd/yy",all.get(4).toString()))
		    	{
		    	 blnFlag=true;
					 repfn.FnUpdateTestStepResHTML("Verify if \"Date\" in format \"mm/dd/yy\" is correct", "\"Date\" format  is correct: "+all.get(4).toString(), "PASS",runManagerInfoObj);
					 
				 }
				 else
				 {
					 blnFlag=false;
					 repfn.FnUpdateTestStepResHTML("Verify if \"Date\" in format \"mm/dd/yy\" is correct", "\"Date\" format  is not correct ", "FAIL",runManagerInfoObj);
				 }

		      }
		      else
		      {
				    repfn.FnUpdateTestStepResHTML("Verify the display of Edit Payment details link in Verify Payment Info screen ","Edit Payment details link is not displayed in Verify Payment Info screen","FAIL",runManagerInfoObj);
		          blnFlag=false;
		      }
		      if(cnf.isElementExist(By.xpath(mbo.VerifyPaymentInfo_EditPayLink),driver))
		      {
				    repfn.FnUpdateTestStepResHTML("Verify the display of Edit Payment details link in Verify Payment Info screen ","Edit Payment details link is displayed in Verify Payment Info screen","PASS",runManagerInfoObj);
		          blnFlag=true;
		      }
		      else
		      {
				    repfn.FnUpdateTestStepResHTML("Verify the display of Edit Payment details link in Verify Payment Info screen ","Edit Payment details link is not displayed in Verify Payment Info screen","FAIL",runManagerInfoObj);
		          blnFlag=false;
		      }
		      
		      if(cnf.isElementExist(By.xpath(mbo.VerifyPaymentInfo_SupportLink),driver))
		      {
				    repfn.FnUpdateTestStepResHTML("Verify the display of Support link in Verify Payment Info screen ","Support link is displayed in Verify Payment Info screen","PASS",runManagerInfoObj);
		          blnFlag=true;
		      }
		      else
		      {
				    repfn.FnUpdateTestStepResHTML("Verify the display of Support link in Verify Payment Info screen ","Support link is not displayed in Verify Payment Info screen","FAIL",runManagerInfoObj);
		          blnFlag=false;
		          
		      }
		      
		      if(cnf.isElementExist(By.xpath(mbo.Q2wall_Cancelbutton),driver))
		      {
				    repfn.FnUpdateTestStepResHTML("Verify the display of Cancel button in Verify Payment Info screen ","Cancel button is displayed in Verify Payment Info screen","PASS",runManagerInfoObj);
		          blnFlag=true;
		      }
		      else
		      {
				    repfn.FnUpdateTestStepResHTML("Verify the display of Cancel button in Verify Payment Info screen ","Cancel button is not displayed in Verify Payment Info screen","FAIL",runManagerInfoObj);
		          blnFlag=false;
		          
		      }
		      
		      if(cnf.isElementExist(By.xpath(mbo.VerifyPaymentInfo_CompletePaymentBtn),driver))
		      {
				    repfn.FnUpdateTestStepResHTML("Verify the display of Complete payment button in Verify Payment Info screen ","Complete payment button is displayed in Verify Payment Info screen","PASS",runManagerInfoObj);
		          blnFlag=true;
		      }
		      else
		      {
				    repfn.FnUpdateTestStepResHTML("Verify the display of Complete payment button in Verify Payment Info screen ","Complete payment button is not displayed in Verify Payment Info screen","FAIL",runManagerInfoObj);
		          blnFlag=false;
		          
		      }
		      /*  }
			      else
			       {
					    repfn.FnUpdateTestStepResHTML("Verify if user is is Verify Payment Info screen","User is not in Verify Payment Info screen","FAIL",runManagerInfoObj);
		       blnFlag=false;
			       }*/
				
			}
			catch(Exception e)
			{
				System.err.println("Message : "+e.getMessage());
			  System.err.println("Cause : "+e.getCause());	
			
			}
			 m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

			}




		//Verify Payment Info screen-Checking radio button check
		public synchronized boolean Q2Wall_PaymentInfo_OTP_CheckingSaving_Checked(WebDriver driver, RunManagerInfo runManagerInfoObj)
		{
			String checkingRadioBtnStatus="";
			try
			{
				if(cnf.isElementExist(By.xpath(mbo.PayBill_PaymentInfo),driver))
			    {
					repfn.FnUpdateTestStepResHTML("Verify the display of Payment Info section in Paybill screen","Payment Info section is displayed for OTP-Checkings/Savings with the header"+" "+driver.findElement(By.xpath(mbo.Q2Wall_PayBill_PaymentInfo_Hdr)).getText(),"PASS",runManagerInfoObj);
			        if(cnf.isElementExist(By.xpath(mbo.PaymentInfo_CheckingRadioBtn),driver))
			        {
						repfn.FnUpdateTestStepResHTML("Verify the display of Checkings radio button in Payment Info section","Checkings radio button is present in Payment Info section","PASS",runManagerInfoObj);
						 WebElement CheckingsRadioBtn=driver.findElement(By.xpath(mbo.PaymentInfo_CheckingRadioBtn));
						 checkingRadioBtnStatus=CheckingsRadioBtn.getAttribute("aria-checked");
							if(checkingRadioBtnStatus.equalsIgnoreCase("true"))
							{
								repfn.FnUpdateTestStepResHTML("Verify Checkings radio button in Payment Info section is checked","Checkings radio button is checked already","PASS",runManagerInfoObj);
						       blnFlag=true;
							}
							else if(checkingRadioBtnStatus.equalsIgnoreCase("false"))
							{
								repfn.FnUpdateTestStepResHTML("Verify Checkings radio button in Payment Info section is checked","Checkings radio button is not checked already","PASS",runManagerInfoObj);
					              if(cnf.JSClick(CheckingsRadioBtn,driver))
					              {
					  				repfn.FnUpdateTestStepResHTML("Verify Checkings radio button in Payment Info section is clicked","Checkings radio button is clicked","PASS",runManagerInfoObj);
									 checkingRadioBtnStatus=CheckingsRadioBtn.getAttribute("aria-checked");
					  				if(checkingRadioBtnStatus.equalsIgnoreCase("true"))
					  				{
					  					repfn.FnUpdateTestStepResHTML("Verify Checkings radio button in Payment Info section is checked","Checkings radio button is checked","PASS",runManagerInfoObj);
					  				    blnFlag=true;
					  				}
					  				else
					  				{
					  					repfn.FnUpdateTestStepResHTML("Verify Checkings radio button in Payment Info section is checked","Checkings radio button is not checked","FAIL",runManagerInfoObj);
					                      blnFlag=false;
					  				}
					              }
					              else
					              {
					  				repfn.FnUpdateTestStepResHTML("Verify Checkings radio button in Payment Info section is clicked","Checkings radio button is not clicked","FAIL",runManagerInfoObj);
					                  blnFlag=false;
					              }
							
							}
			        }
			        else
			        {
						repfn.FnUpdateTestStepResHTML("Verify the display of Checkings radio button in Payment Info section","Checkings radio button is not present in Payment Info section","FAIL",runManagerInfoObj);

			        }
			    }
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the display of Payment Info section in Paybill screen","Payment Info section is not displayed for OTP-Checkings/Savings","FAIL",runManagerInfoObj);
		      blnFlag=false;
				}
		}

			catch(Exception e)
			{
				System.err.println("Message : "+e.getMessage());
			  System.err.println("Cause : "+e.getCause());	
			
			}
			 m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
			}




		public synchronized boolean VerifyPaymentInfo(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
		{

			try
			{
				driver.switchTo().frame("iFrameResizer0");
				if(cnf.FnExplicitWait("XPATH", mbo.PaymentInfo_VerifyPaymentInfo,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if user is is Verify Payment Info screen","User is in Verify Payment Info screen","PASS",runManagerInfoObj);

					if(cnf.FnExplicitWait("XPATH", mbo.PaymentInfo_VerifyPaymentInfo_Hdr,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the Verify Payment Info screen is displayed with title","Verify Payment Info screen is displayed with title:"+" "+driver.findElement(By.xpath(mbo.PaymentInfo_VerifyPaymentInfo_Hdr)).getText(),"PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the Verify Payment Info screen is displayed with title","Verify Payment Info screen is displayed without title","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

					if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentInfo_Hdr,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the Verify Payment Info screen is displayed with sub heading","Verify Payment Info screen is displayed with sub heading:"+" "+driver.findElement(By.xpath(mbo.VerifyPaymentInfo_Hdr)).getText(),"PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the Verify Payment Info screen is displayed with sub heading","Verify Payment Info screen is displayed without sub heading","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

					if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentInfo_AllDetails,driver))
					{
						List <WebElement> details=driver.findElements(By.xpath(mbo.VerifyPaymentInfo_AllDetails));
						for(int j=0;j<details.size();j++)
						{
							all.add(details.get(j).getText());
							repfn.FnUpdateTestStepResHTML("Verify the display of Details in Verify Payment Info screen ",details.get(j).getText()+" "+"is displayed in Verify Payment Info screen","PASS",runManagerInfoObj);

						}
						if(Pattern.matches("\\*([0-9]{4})",all.get(1).toString()))
						{
							repfn.FnUpdateTestStepResHTML("Verify if Routing number is masked and only 4 characters are displayed","Routing number is masked and only 4 characters are displayed "+all.get(1).toString(), "PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else
						{
							repfn.FnUpdateTestStepResHTML("Verify if Routing number is masked and only 4 characters are displayed","Routing number is not masked and only 4 characters are displayed", "FAIL",runManagerInfoObj);
							blnFlag=false;
						}
						if(Pattern.matches("\\*([0-9]{4})",all.get(3).toString()))
						{
							repfn.FnUpdateTestStepResHTML("Verify if Account number is masked and only 4 characters are displayed","Account number is masked and only 4 characters are displayed "+all.get(3).toString(), "PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else
						{
							repfn.FnUpdateTestStepResHTML("Verify if Account number is masked and only 4 characters are displayed","Account number is not masked and only 4 characters are displayed", "FAIL",runManagerInfoObj);
							blnFlag=false;
						}

						if(all.get(5).toString().equalsIgnoreCase("Checking"))
						{
							repfn.FnUpdateTestStepResHTML("Verify the Account type is Checkings/Savings in Verify payment info screen","Account type is Checkings in Verify payment info screen","PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else if(all.get(5).toString().equalsIgnoreCase("Savings"))
						{
							repfn.FnUpdateTestStepResHTML("Verify the Account type is Checkings/Savings in Verify payment info screen","Account type is Savings in Verify payment info screen","PASS",runManagerInfoObj);
							blnFlag=false;
						}
						if(Pattern.matches("(\\$([0-9]{1}||[0-9]{2}||[0-9]{3})\\.[0-9]{2})", all.get(7).toString()))	
						{
							blnFlag=true;
							repfn.FnUpdateTestStepResHTML("Verify if \"Amount\" in format \"$XX.XX\" is correct", "\"Amount\" format  is correct: "+all.get(7).toString(), "PASS",runManagerInfoObj);

						}
						else
						{
							blnFlag=false;
							repfn.FnUpdateTestStepResHTML("Verify if \"Amount\" in format \"$XX.XX\" is correct", "\"Amount\" format  is not correct ", "FAIL",runManagerInfoObj);
						}
						if(cnf.isValidFormat("mm/dd/yy",all.get(9).toString()))
						{
							blnFlag=true;
							repfn.FnUpdateTestStepResHTML("Verify if \"Date\" in format \"mm/dd/yy\" is correct", "\"Date\" format  is correct: "+all.get(9).toString(), "PASS",runManagerInfoObj);

						}
						else
						{
							blnFlag=false;
							repfn.FnUpdateTestStepResHTML("Verify if \"Date\" in format \"mm/dd/yy\" is correct", "\"Date\" format  is not correct ", "FAIL",runManagerInfoObj);
						}

					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the display of Edit Payment details link in Verify Payment Info screen ","Edit Payment details link is not displayed in Verify Payment Info screen","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

					if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentInfo_EditPayLink,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the display of Edit Payment details link in Verify Payment Info screen ","Edit Payment details link is displayed in Verify Payment Info screen","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the display of Edit Payment details link in Verify Payment Info screen ","Edit Payment details link is not displayed in Verify Payment Info screen","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

					if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentInfo_SupportLink,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the display of Support link in Verify Payment Info screen ","Support link is displayed in Verify Payment Info screen","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the display of Support link in Verify Payment Info screen ","Support link is not displayed in Verify Payment Info screen","FAIL",runManagerInfoObj);
						blnFlag=false;

					}

					if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentInfo_CancelBtn,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the display of Cancel button in Verify Payment Info screen ","Cancel button is displayed in Verify Payment Info screen","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the display of Cancel button in Verify Payment Info screen ","Cancel button is not displayed in Verify Payment Info screen","FAIL",runManagerInfoObj);
						blnFlag=false;

					}

					if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentInfo_CompletePaymentBtn,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the display of Complete payment button in Verify Payment Info screen ","Complete payment button is displayed in Verify Payment Info screen","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the display of Complete payment button in Verify Payment Info screen ","Complete payment button is not displayed in Verify Payment Info screen","FAIL",runManagerInfoObj);
						blnFlag=false;

					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify if user is is Verify Payment Info screen","User is not in Verify Payment Info screen","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				driver.switchTo().defaultContent();
			}
			catch(Exception e)
			{
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());	
				repfn.FnUpdateTestStepResHTML("Verify if User is able to verify User details on Verify Payment Info screen","User is able to verify User details on Verify Payment Info screen due to some exception","FAIL",runManagerInfoObj);
				blnFlag=false;

			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}
		 public synchronized boolean FnBillPayOptions_cancel(WebDriver driver, RunManagerInfo runManagerInfoObj) {
			 try
			 {

				 if(cnf.FnExplicitWait("XPATH", mbo.onlineBill,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify \"Online Bill\" radio button is displayed", "\"Online Bill\" radio button is displayed", "PASS",runManagerInfoObj);
					 WebElement onlineBill=driver.findElement(By.xpath(mbo.onlineBill));
					 if(onlineBill.isSelected()){
						 repfn.FnUpdateTestStepResHTML("Verify \"Online Bill\" radio button is pre-selected", "\"Online Bill\" radio button is pre-selected", "PASS",runManagerInfoObj);

						 if(cnf.FnExplicitWait("XPATH", mbo.paperAndOnlineBill,driver)){
							 repfn.FnUpdateTestStepResHTML("Verify \"Paper & Online Bill\" radio button is displayed", "\"Paper & Online Bill\" radio button is displayed", "PASS",runManagerInfoObj);
							 WebElement paperAndOnlineBill=driver.findElement(By.xpath(mbo.paperAndOnlineBill));
							 if(cnf.JSClick(paperAndOnlineBill,driver)){
								 repfn.FnUpdateTestStepResHTML("Verify \"Paper & Online Bill\" radio button is selected", "\"Paper & Online Bill\" radio button is selected", "PASS",runManagerInfoObj);

								 if(cnf.FnExplicitWait("XPATH", mbo.cancelButtonForBillPay,driver)){
									 repfn.FnUpdateTestStepResHTML("Verify Cancel button is displayed", "Cancel button is displayed", "PASS",runManagerInfoObj);
									 WebElement cancelButtonForBillPay=driver.findElement(By.xpath(mbo.cancelButtonForBillPay));
									 if(cnf.JSClick(cancelButtonForBillPay,driver)){
										 repfn.FnUpdateTestStepResHTML("Verify Cancel button is clicked", "Cancel button is clicked", "PASS",runManagerInfoObj);
										 Thread.sleep(5000);

										 boolean blnFlag1 = FnBillPayOptionsTab(driver,runManagerInfoObj);
										 Thread.sleep(5000);
										 if(blnFlag1){
											 if(cnf.FnExplicitWait("XPATH", mbo.paperAndOnlineBill,driver)){
												 WebElement paperAndOnlineBillOne=driver.findElement(By.xpath(mbo.paperAndOnlineBill));
												 if(paperAndOnlineBillOne.isSelected()){
													 blnFlag=false;
													 repfn.FnUpdateTestStepResHTML("Check whether the selection of \"Paper & Online Bill\" in previous step is not saved", "Selection of \"Paper & Online Bill\"  in previous step is saved", "FAIL",runManagerInfoObj);
												 }
												 else{
													 blnFlag=true;
													 repfn.FnUpdateTestStepResHTML("Check whether the selection of \"Paper & Online Bill\" in previous step is not saved", "Selection of \"Paper & Online Bill\"  in previous step is not saved", "PASS",runManagerInfoObj);
												 }
											 }
											 else{
												 repfn.FnUpdateTestStepResHTML("Verify \"Paper & Online Bill\" radio button is displayed", "\"Paper & Online Bill\" radio button is not displayed", "FAIL",runManagerInfoObj);
												 blnFlag=false;
											 }
										 }
										 else{
											 repfn.FnUpdateTestStepResHTML("Verify User is navigated to Bill Pay Options page","User is not navigated to Bill Pay Options page","FAIL",runManagerInfoObj);
											 blnFlag=false;
										 }

									 }
									 else{
										 repfn.FnUpdateTestStepResHTML("Verify Cancel button is clicked", "Cancel button is not clicked", "FAIL",runManagerInfoObj);
										 blnFlag=false;
									 }
								 }
								 else{
									 repfn.FnUpdateTestStepResHTML("Verify Cancel button is displayed", "Cancel button is not displayed", "FAIL",runManagerInfoObj);
									 blnFlag=false;
								 }
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify \"Paper & Online Bill\" radio button is selected", "\"Paper & Online Bill\" radio button is not selected", "FAIL",runManagerInfoObj);
								 blnFlag=false;
							 }
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify \"Paper & Online Bill\" radio button is displayed", "\"Paper & Online Bill\" radio button is not displayed", "FAIL",runManagerInfoObj);
							 blnFlag=false;
						 }
					 }
					 else{
						 if(cnf.FnExplicitWait("XPATH", mbo.paperAndOnlineBill,driver)){
							 repfn.FnUpdateTestStepResHTML("Verify \"Paper & Online Bill\" radio button is displayed", "\"Paper & Online Bill\" radio button is displayed", "PASS",runManagerInfoObj);
							 WebElement paperAndOnlineBill=driver.findElement(By.xpath(mbo.paperAndOnlineBill));
							 if(paperAndOnlineBill.isSelected()){
								 repfn.FnUpdateTestStepResHTML("Verify \"Paper & Online Bill\" radio button is pre-selected", "\"Paper & Online Bill\" radio button is pre-selected", "PASS",runManagerInfoObj);

								 if(cnf.FnExplicitWait("XPATH", mbo.onlineBill,driver)){
									 repfn.FnUpdateTestStepResHTML("Verify \"Online Bill\" radio button is displayed", "\"Online Bill\" radio button is displayed", "PASS",runManagerInfoObj);
									 WebElement onlineBillOne=driver.findElement(By.xpath(mbo.onlineBill));
									 if(cnf.JSClick(onlineBillOne,driver)){
										 repfn.FnUpdateTestStepResHTML("Verify \"Online Bill\" radio button is selected", "\"Online Bill\" radio button is selected", "PASS",runManagerInfoObj);

										 if(cnf.FnExplicitWait("XPATH", mbo.cancelButtonForBillPay,driver)){
											 repfn.FnUpdateTestStepResHTML("Verify Cancel button is displayed", "Cancel button is displayed", "PASS",runManagerInfoObj);
											 WebElement cancelButtonForBillPay=driver.findElement(By.xpath(mbo.cancelButtonForBillPay));
											 if(cnf.JSClick(cancelButtonForBillPay,driver)){
												 repfn.FnUpdateTestStepResHTML("Verify Cancel button is clicked", "Cancel button is clicked", "PASS",runManagerInfoObj);
												 Thread.sleep(5000);

												 boolean blnFlag1 = FnBillPayOptionsTab(driver,runManagerInfoObj);
												 Thread.sleep(5000);
												 if(blnFlag1){
													 if(cnf.FnExplicitWait("XPATH", mbo.onlineBill,driver)){
														 WebElement onlineBillTwo=driver.findElement(By.xpath(mbo.onlineBill));
														 if(onlineBillTwo.isSelected()){
															 blnFlag=false;
															 repfn.FnUpdateTestStepResHTML("Check whether the selection of \"Online Bill\" in previous step is not saved", "Selection of \"Online Bill\"  in previous step is saved", "FAIL",runManagerInfoObj);
														 }
														 else{
															 blnFlag=true;
															 repfn.FnUpdateTestStepResHTML("Check whether the selection of \"Online Bill\" in previous step is not saved", "Selection of \"Online Bill\"  in previous step is not saved", "PASS",runManagerInfoObj);
														 }
													 }
													 else{
														 repfn.FnUpdateTestStepResHTML("Verify \"Online Bill\" radio button is displayed", "\"Online Bill\" radio button is not displayed", "FAIL",runManagerInfoObj);
														 blnFlag=false;
													 }
												 }
												 else{
													 repfn.FnUpdateTestStepResHTML("Verify User is navigated to Bill Pay Options page","User is not navigated to Bill Pay Options page","FAIL",runManagerInfoObj);
													 blnFlag=false;
												 }

											 }
											 else{
												 repfn.FnUpdateTestStepResHTML("Verify Cancel button is clicked", "Cancel button is not clicked", "FAIL",runManagerInfoObj);
												 blnFlag=false;
											 }
										 }
										 else{
											 repfn.FnUpdateTestStepResHTML("Verify Cancel button is displayed", "Cancel button is not displayed", "FAIL",runManagerInfoObj);
											 blnFlag=false;
										 }
									 }
									 else{
										 repfn.FnUpdateTestStepResHTML("Verify \"Online Bill\" radio button is selected", "\"Online Bill\" radio button is not selected", "FAIL",runManagerInfoObj);
										 blnFlag=false;
									 }
								 }
								 else{
									 repfn.FnUpdateTestStepResHTML("Verify \"Online Bill\" radio button is displayed", "\"Online Bill\" radio button is not displayed", "FAIL",runManagerInfoObj);
									 blnFlag=false;
								 }
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify \"Paper & Online Bill\" radio button is pre-selected", "\"Paper & Online Bill\" radio button is not pre-selected", "FAIL",runManagerInfoObj);
								 blnFlag=false;
							 }
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify \"Paper & Online Bill\" radio button is displayed", "\"Paper & Online Bill\" radio button is not displayed", "FAIL",runManagerInfoObj);
							 blnFlag=false;
						 }
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify \"Online Bill\" radio button is displayed", "\"Online Bill\" radio button is not displayed", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }

			 }
			 catch (Exception e)
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if user is able to cancel the changes made to the bill delivery method", "User is not able to cancel the changes made to the bill delivery method due to some exception", "FAIL",runManagerInfoObj);
				 System.err.println("Message : "+e.getMessage());
				 System.err.println("Cause : "+e.getCause());
				 blnFlag=false;
			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;
		 }
		 public synchronized boolean FnBillPayOptions_OnlineToPaperAndOnlineBillSave(WebDriver driver, RunManagerInfo runManagerInfoObj) {
				try
				{
					 if(cnf.FnExplicitWait("XPATH", mbo.paperAndOnlineBill,driver)){
						 repfn.FnUpdateTestStepResHTML("Verify \"Paper & Online Bill\" radio button is displayed", "\"Paper & Online Bill\" radio button is displayed", "PASS",runManagerInfoObj);
						 WebElement paperAndOnlineBill=driver.findElement(By.xpath(mbo.paperAndOnlineBill));
						 if(paperAndOnlineBill.isSelected()){
							 repfn.FnUpdateTestStepResHTML("Verify \"Paper & Online Bill\" radio button is pre-selected", "\"Paper & Online Bill\" radio button is pre-selected", "PASS",runManagerInfoObj);

							 if(cnf.FnExplicitWait("XPATH", mbo.onlineBill,driver)){
								 repfn.FnUpdateTestStepResHTML("Verify \"Online Bill\" radio button is displayed", "\"Online Bill\" radio button is displayed", "PASS",runManagerInfoObj);
								 WebElement onlineBill=driver.findElement(By.xpath(mbo.onlineBill));

								 if(cnf.JSClick(onlineBill,driver)){
									 repfn.FnUpdateTestStepResHTML("Verify \"Online Bill\" radio button is selected", "\"Online Bill\" radio button is selected", "PASS",runManagerInfoObj);

									 if(cnf.JSClick(paperAndOnlineBill,driver)){
										 repfn.FnUpdateTestStepResHTML("Verify \"Paper & Online Bill\" radio button is selected", "\"Paper & Online Bill\" radio button is selected", "PASS",runManagerInfoObj);

										 if(cnf.FnExplicitWait("XPATH", mbo.saveButtonForBillPay,driver)){
											 repfn.FnUpdateTestStepResHTML("Verify Save button is displayed", "Save button is displayed", "PASS",runManagerInfoObj);
											 WebElement saveButtonForBillPay=driver.findElement(By.xpath(mbo.saveButtonForBillPay));
											 if(cnf.JSClick(saveButtonForBillPay,driver)){
												 repfn.FnUpdateTestStepResHTML("Verify Save button is clicked", "Save button is clicked", "PASS",runManagerInfoObj);
												 Thread.sleep(5000);

												 if(cnf.FnExplicitWait("XPATH", mbo.returnToBillingButton,driver)){
													 repfn.FnUpdateTestStepResHTML("Verify \"Return to Billing\" button is displayed", "\"Return to Billing\" button is displayed", "PASS",runManagerInfoObj);
													 WebElement returnToBillingButton=driver.findElement(By.xpath(mbo.returnToBillingButton));
													 if(cnf.JSClick(returnToBillingButton,driver)){
														 repfn.FnUpdateTestStepResHTML("Verify \"Return to Billing\" button is clicked", "\"Return to Billing\" button is clicked", "PASS",runManagerInfoObj);

														 boolean blnFlag1 = FnBillPayOptionsTab(driver,runManagerInfoObj);
														 Thread.sleep(5000);
														 if(blnFlag1){
															 if(cnf.FnExplicitWait("XPATH", mbo.paperAndOnlineBill,driver)){
																 WebElement paperAndOnlineBillOne=driver.findElement(By.xpath(mbo.paperAndOnlineBill));
																 if(paperAndOnlineBillOne.isSelected()){
																	 blnFlag=true;
																	 repfn.FnUpdateTestStepResHTML("Check whether the selection of \"Paper & Online Bill\" in previous step is saved", "Selection of \"Paper & Online Bill\"  in previous step is saved", "PASS",runManagerInfoObj);
																 }
																 else{
																	 blnFlag=false;
																	 repfn.FnUpdateTestStepResHTML("Check whether the selection of \"Paper & Online Bill\" in previous step is saved", "Selection of \"Paper & Online Bill\"  in previous step is not saved", "FAIL",runManagerInfoObj);
																 }
															 }
															 else{
																 repfn.FnUpdateTestStepResHTML("Verify \"Paper & Online Bill\" radio button is displayed", "\"Paper & Online Bill\" radio button is not displayed", "FAIL",runManagerInfoObj);
																 blnFlag=false;
															 }
														 }
														 else{
															 repfn.FnUpdateTestStepResHTML("Verify User is navigated to Bill Pay Options page","User is not navigated to Bill Pay Options page","FAIL",runManagerInfoObj);
															 blnFlag=false;
														 }
													 }
													 else{
														 repfn.FnUpdateTestStepResHTML("Verify \"Return to Billing\" button is clicked", "\"Return to Billing\" button is not clicked", "FAIL",runManagerInfoObj);
														 blnFlag=false;
													 }
												 }
												 else{
													 repfn.FnUpdateTestStepResHTML("Verify \"Return to Billing\" button is displayed", "\"Return to Billing\" button is not displayed", "FAIL",runManagerInfoObj);
													 blnFlag=false;
												 }
											 }
											 else{
												 repfn.FnUpdateTestStepResHTML("Verify Save button is clicked", "Save button is not clicked", "FAIL",runManagerInfoObj);
												 blnFlag=false;
											 }
										 }
										 else{
											 repfn.FnUpdateTestStepResHTML("Verify Save button is displayed", "Save button is not displayed", "FAIL",runManagerInfoObj);
											 blnFlag=false;
										 }
									 }
									 else{
										 repfn.FnUpdateTestStepResHTML("Verify \"Paper & Online Bill\" radio button is selected", "\"Paper & Online Bill\" radio button is not selected", "FAIL",runManagerInfoObj);
										 blnFlag=false;
									 }
								 }
								 else{
									 repfn.FnUpdateTestStepResHTML("Verify \"Online Bill\" radio button is selected", "\"Online Bill\" radio button is not selected", "FAIL",runManagerInfoObj);
									 blnFlag=false;
								 }
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify \"Online Bill\" radio button is displayed", "\"Online Bill\" radio button is not displayed", "FAIL",runManagerInfoObj);
								 blnFlag=false;
							 }
						 }
						 else{
							 if(cnf.JSClick(paperAndOnlineBill,driver)){
								 repfn.FnUpdateTestStepResHTML("Verify \"Paper & Online Bill\" radio button is selected", "\"Paper & Online Bill\" radio button is selected", "PASS",runManagerInfoObj);

								 if(cnf.FnExplicitWait("XPATH", mbo.saveButtonForBillPay,driver)){
									 repfn.FnUpdateTestStepResHTML("Verify Save button is displayed", "Save button is displayed", "PASS",runManagerInfoObj);
									 WebElement saveButtonForBillPay=driver.findElement(By.xpath(mbo.saveButtonForBillPay));
									 if(cnf.JSClick(saveButtonForBillPay,driver)){
										 repfn.FnUpdateTestStepResHTML("Verify Save button is clicked", "Save button is clicked", "PASS",runManagerInfoObj);
										 Thread.sleep(5000);

										 if(cnf.FnExplicitWait("XPATH", mbo.returnToBillingButton,driver)){
											 repfn.FnUpdateTestStepResHTML("Verify \"Return to Billing\" button is displayed", "\"Return to Billing\" button is displayed", "PASS",runManagerInfoObj);
											 WebElement returnToBillingButton=driver.findElement(By.xpath(mbo.returnToBillingButton));
											 if(cnf.JSClick(returnToBillingButton,driver)){
												 repfn.FnUpdateTestStepResHTML("Verify \"Return to Billing\" button is clicked", "\"Return to Billing\" button is clicked", "PASS",runManagerInfoObj);

												 boolean blnFlag1 = FnBillPayOptionsTab(driver,runManagerInfoObj);
												 Thread.sleep(5000);
												 if(blnFlag1){
													 if(cnf.FnExplicitWait("XPATH", mbo.paperAndOnlineBill,driver)){
														 WebElement paperAndOnlineBillTwo=driver.findElement(By.xpath(mbo.paperAndOnlineBill));
														 if(paperAndOnlineBillTwo.isSelected()){
															 blnFlag=true;
															 repfn.FnUpdateTestStepResHTML("Check whether the selection of \"Paper & Online Bill\" in previous step is saved", "Selection of \"Paper & Online Bill\"  in previous step is saved", "PASS",runManagerInfoObj);
														 }
														 else{
															 blnFlag=false;
															 repfn.FnUpdateTestStepResHTML("Check whether the selection of \"Paper & Online Bill\" in previous step is saved", "Selection of \"Paper & Online Bill\"  in previous step is not saved", "FAIL",runManagerInfoObj);
														 }
													 }
													 else{
														 repfn.FnUpdateTestStepResHTML("Verify \"Paper & Online Bill\" radio button is displayed", "\"Paper & Online Bill\" radio button is not displayed", "FAIL",runManagerInfoObj);
														 blnFlag=false;
													 }
												 }
												 else{
													 repfn.FnUpdateTestStepResHTML("Verify User is navigated to Bill Pay Options page","User is not navigated to Bill Pay Options page","FAIL",runManagerInfoObj);
													 blnFlag=false;
												 }
											 }
											 else{
												 repfn.FnUpdateTestStepResHTML("Verify \"Return to Billing\" button is clicked", "\"Return to Billing\" button is not clicked", "FAIL",runManagerInfoObj);
												 blnFlag=false;
											 }
										 }
										 else{
											 repfn.FnUpdateTestStepResHTML("Verify \"Return to Billing\" button is displayed", "\"Return to Billing\" button is not displayed", "FAIL",runManagerInfoObj);
											 blnFlag=false;
										 }
									 }
									 else{
										 repfn.FnUpdateTestStepResHTML("Verify Save button is clicked", "Save button is not clicked", "FAIL",runManagerInfoObj);
										 blnFlag=false;
									 }
								 }
								 else{
									 repfn.FnUpdateTestStepResHTML("Verify Save button is displayed", "Save button is not displayed", "FAIL",runManagerInfoObj);
									 blnFlag=false;
								 }
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify \"Paper & Online Bill\" radio button is selected", "\"Paper & Online Bill\" radio button is not selected", "FAIL",runManagerInfoObj);
								 blnFlag=false;
							 }
						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify \"Paper & Online Bill\" radio button is displayed", "\"Paper & Online Bill\" radio button is not displayed", "FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 
				}
				catch (Exception e)


			    {
			    	repfn.FnUpdateTestStepResHTML("Verify if user is able to save the changes made to the bill delivery method", "User is not able to save the changes made to the bill delivery method due to some exception", "FAIL",runManagerInfoObj);
			           System.err.println("Message : "+e.getMessage());
			           System.err.println("Cause : "+e.getCause());
			           
			    }
			    m1.put("STEPSTATUS", blnFlag);
			    return blnFlag;
				
			}
		 public synchronized boolean FnBillPayOptions_PaperAndOnlineBillToOnlineBillSave(WebDriver driver, RunManagerInfo runManagerInfoObj) {
			 try
			 {
				 if(cnf.FnExplicitWait("XPATH", mbo.onlineBill,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify \"Online Bill\" radio button is displayed", "\"Online Bill\" radio button is displayed", "PASS",runManagerInfoObj);
					 WebElement onlineBill=driver.findElement(By.xpath(mbo.onlineBill));
					 if(onlineBill.isSelected()){
						 repfn.FnUpdateTestStepResHTML("Verify \"Online Bill\" radio button is pre-selected", "\"Online Bill\" radio button is pre-selected", "PASS",runManagerInfoObj);

						 if(cnf.FnExplicitWait("XPATH", mbo.paperAndOnlineBill,driver)){
							 repfn.FnUpdateTestStepResHTML("Verify \"Paper & Online Bill\" radio button is displayed", "\"Paper & Online Bill\" radio button is displayed", "PASS",runManagerInfoObj);
							 WebElement paperAndOnlineBill=driver.findElement(By.xpath(mbo.paperAndOnlineBill));

							 if(cnf.JSClick(paperAndOnlineBill,driver)){
								 repfn.FnUpdateTestStepResHTML("Verify \"Paper & Online Bill\" radio button is selected", "\"Paper & Online Bill\" radio button is selected", "PASS",runManagerInfoObj);

								 if(cnf.JSClick(onlineBill,driver)){
									 repfn.FnUpdateTestStepResHTML("Verify \"Online Bill\" radio button is selected", "\"Online Bill\" radio button is selected", "PASS",runManagerInfoObj);

									 if(cnf.FnExplicitWait("XPATH", mbo.saveButtonForBillPay,driver)){
										 repfn.FnUpdateTestStepResHTML("Verify Save button is displayed", "Save button is displayed", "PASS",runManagerInfoObj);
										 WebElement saveButtonForBillPay=driver.findElement(By.xpath(mbo.saveButtonForBillPay));
										 if(cnf.JSClick(saveButtonForBillPay,driver)){
											 repfn.FnUpdateTestStepResHTML("Verify Save button is clicked", "Save button is clicked", "PASS",runManagerInfoObj);
											 Thread.sleep(6000);

											 if(cnf.FnExplicitWait("XPATH", mbo.returnToBillingButton,driver)){
												 repfn.FnUpdateTestStepResHTML("Verify \"Return to Billing\" button is displayed", "\"Return to Billing\" button is displayed", "PASS",runManagerInfoObj);
												 WebElement returnToBillingButton=driver.findElement(By.xpath(mbo.returnToBillingButton));
												 if(cnf.JSClick(returnToBillingButton,driver)){
													 repfn.FnUpdateTestStepResHTML("Verify \"Return to Billing\" button is clicked", "\"Return to Billing\" button is clicked", "PASS",runManagerInfoObj);

													 boolean blnFlag1 = FnBillPayOptionsTab(driver,runManagerInfoObj);
													 Thread.sleep(5000);
													 if(blnFlag1){
														 if(cnf.FnExplicitWait("XPATH", mbo.onlineBill,driver)){
															 WebElement onlineBillTwo=driver.findElement(By.xpath(mbo.onlineBill));
															 if(onlineBillTwo.isSelected()){
																 blnFlag=true;
																 repfn.FnUpdateTestStepResHTML("Check whether the selection of \"Online Bill\" in previous step is saved", "Selection of \"Online Bill\"  in previous step is saved", "PASS",runManagerInfoObj);
															 }
															 else{
																 blnFlag=false;
																 repfn.FnUpdateTestStepResHTML("Check whether the selection of \"Online Bill\" in previous step is saved", "Selection of \"Online Bill\"  in previous step is not saved", "FAIL",runManagerInfoObj);
															 }
														 }
														 else{
															 repfn.FnUpdateTestStepResHTML("Verify \"Online Bill\" radio button is displayed", "\"Online Bill\" radio button is not displayed", "FAIL",runManagerInfoObj);
															 blnFlag=false;
														 }
													 }
													 else{
														 repfn.FnUpdateTestStepResHTML("Verify User is navigated to Bill Pay Options page","User is not navigated to Bill Pay Options page","FAIL",runManagerInfoObj);
														 blnFlag=false;
													 }
												 }
												 else{
													 repfn.FnUpdateTestStepResHTML("Verify \"Return to Billing\" button is clicked", "\"Return to Billing\" button is not clicked", "FAIL",runManagerInfoObj);
													 blnFlag=false;
												 }
											 }
											 else{
												 repfn.FnUpdateTestStepResHTML("Verify \"Return to Billing\" button is displayed", "\"Return to Billing\" button is not displayed", "FAIL",runManagerInfoObj);
												 blnFlag=false;
											 }
										 }
										 else{
											 repfn.FnUpdateTestStepResHTML("Verify Save button is clicked", "Save button is not clicked", "FAIL",runManagerInfoObj);
											 blnFlag=false;
										 }
									 }
									 else{
										 repfn.FnUpdateTestStepResHTML("Verify Save button is displayed", "Save button is not displayed", "FAIL",runManagerInfoObj);
										 blnFlag=false;
									 }
								 }
								 else{
									 repfn.FnUpdateTestStepResHTML("Verify \"Online Bill\" radio button is selected", "\"Online Bill\" radio button is not selected", "FAIL",runManagerInfoObj);
									 blnFlag=false;
								 }
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify \"Paper & Online Bill\" radio button is selected", "\"Paper & Online Bill\" radio button is not selected", "FAIL",runManagerInfoObj);
								 blnFlag=false;
							 }
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify \"Paper & Online Bill\" radio button is displayed", "\"Paper & Online Bill\" radio button is not displayed", "FAIL",runManagerInfoObj);
							 blnFlag=false;
						 }
					 }
					 else{
						 if(cnf.JSClick(onlineBill,driver)){
							 repfn.FnUpdateTestStepResHTML("Verify \"Online Bill\" radio button is selected", "\"Online Bill\" radio button is selected", "PASS",runManagerInfoObj);

							 if(cnf.FnExplicitWait("XPATH", mbo.saveButtonForBillPay,driver)){
								 repfn.FnUpdateTestStepResHTML("Verify Save button is displayed", "Save button is displayed", "PASS",runManagerInfoObj);
								 WebElement saveButtonForBillPay=driver.findElement(By.xpath(mbo.saveButtonForBillPay));
								 if(cnf.JSClick(saveButtonForBillPay,driver)){
									 repfn.FnUpdateTestStepResHTML("Verify Save button is clicked", "Save button is clicked", "PASS",runManagerInfoObj);
									 Thread.sleep(8000);

									 if(cnf.FnExplicitWait("XPATH", mbo.returnToBillingButton,driver)){
										 repfn.FnUpdateTestStepResHTML("Verify \"Return to Billing\" button is displayed", "\"Return to Billing\" button is displayed", "PASS",runManagerInfoObj);
										 WebElement returnToBillingButton=driver.findElement(By.xpath(mbo.returnToBillingButton));
										 if(cnf.JSClick(returnToBillingButton,driver)){
											 repfn.FnUpdateTestStepResHTML("Verify \"Return to Billing\" button is clicked", "\"Return to Billing\" button is clicked", "PASS",runManagerInfoObj);

											 boolean blnFlag1 = FnBillPayOptionsTab(driver,runManagerInfoObj);
											 Thread.sleep(5000);
											 if(blnFlag1){
												 if(cnf.FnExplicitWait("XPATH", mbo.onlineBill,driver)){
													 WebElement onlineBillTwo=driver.findElement(By.xpath(mbo.onlineBill));
													 if(onlineBillTwo.isSelected()){
														 blnFlag=true;
														 repfn.FnUpdateTestStepResHTML("Check whether the selection of \"Online Bill\" in previous step is saved", "Selection of \"Online Bill\"  in previous step is saved", "PASS",runManagerInfoObj);
													 }
													 else{
														 blnFlag=false;
														 repfn.FnUpdateTestStepResHTML("Check whether the selection of \"Online Bill\" in previous step is saved", "Selection of \"Online Bill\"  in previous step is not saved", "FAIL",runManagerInfoObj);
													 }
												 }
												 else{
													 repfn.FnUpdateTestStepResHTML("Verify \"Online Bill\" radio button is displayed", "\"Online Bill\" radio button is not displayed", "FAIL",runManagerInfoObj);
													 blnFlag=false;
												 }
											 }
											 else{
												 repfn.FnUpdateTestStepResHTML("Verify User is navigated to Bill Pay Options page","User is not navigated to Bill Pay Options page","FAIL",runManagerInfoObj);
												 blnFlag=false;
											 }
										 }
										 else{
											 repfn.FnUpdateTestStepResHTML("Verify \"Return to Billing\" button is clicked", "\"Return to Billing\" button is not clicked", "FAIL",runManagerInfoObj);
											 blnFlag=false;
										 }
									 }
									 else{
										 repfn.FnUpdateTestStepResHTML("Verify \"Return to Billing\" button is displayed", "\"Return to Billing\" button is not displayed", "FAIL",runManagerInfoObj);
										 blnFlag=false;
									 }
								 }
								 else{
									 repfn.FnUpdateTestStepResHTML("Verify Save button is clicked", "Save button is not clicked", "FAIL",runManagerInfoObj);
									 blnFlag=false;
								 }
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify Save button is displayed", "Save button is not displayed", "FAIL",runManagerInfoObj);
								 blnFlag=false;
							 }
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify \"Online Bill\" radio button is selected", "\"Online Bill\" radio button is not selected", "FAIL",runManagerInfoObj);
							 blnFlag=false;
						 }
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify \"Online Bill\" radio button is displayed", "\"Online Bill\" radio button is not displayed", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 catch (Exception e)


			 {
				 repfn.FnUpdateTestStepResHTML("Verify if user is able to save the changes from paper and online bill to online bill", "User is not able to save the changes from paper and online bill to online bill due to some exception", "FAIL",runManagerInfoObj);
				 System.err.println("Message : "+e.getMessage());
				 System.err.println("Cause : "+e.getCause());
				 blnFlag=false;

			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;

		 }
		 
		 public synchronized boolean EditPaymentInfo(WebDriver driver, RunManagerInfo runManagerInfoObj)
		 {
		 	try
		 	{
		 		driver.switchTo().frame("iFrameResizer0");
		 		app.EditCreditCard(driver,runManagerInfoObj);
		 		EditExpDate(driver,runManagerInfoObj);
		 		app.EditPayAmnt(driver,runManagerInfoObj);
		 		EditPayDate(driver,runManagerInfoObj);
		 	/*	PayBill_Calender();
		 		PayBill_Calender_SelectDate();*/
		 		app.PayBill_PayNow(driver,runManagerInfoObj);
		 		VerifyPaymentIno(driver,runManagerInfoObj);
		 		Paybill_EditPayment(driver,runManagerInfoObj);
		 		PayBill_VerifyEntry(driver,runManagerInfoObj);
		 		driver.navigate().refresh();
		 		app.AlertAccept(driver,runManagerInfoObj);
		 		driver.switchTo().defaultContent();
		 		blnFlag=true;
		 	}
		 	catch(Exception e)
		 	{
		 		System.err.println("Message : "+e.getMessage());
		         System.err.println("Cause : "+e.getCause());	
		 	
		 	}
		 	 m1.put("STEPSTATUS", blnFlag);
		      return blnFlag;
		 }
		 //To verify if Field values are retained in Paybill page after Edit Payment Info link is clicked//

		 public synchronized boolean PayBill_VerifyEntry(WebDriver driver, RunManagerInfo runManagerInfoObj)
		 {
		 	try
		 	{
		 		
		 		
		 		
		 		
		 		if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CardNum,driver))
		 		{
		 			String CCNo=m1.get("CardNum").toString();
		 			WebElement Card=driver.findElement(By.xpath(mbo.PayBill_CardNum));
		 			repfn.FnUpdateTestStepResHTML("Verify if Credit Card Number is displayed", "CreditCard Number is displayed", "PASS",runManagerInfoObj);
		 			if(Card.getAttribute("value").equals(CCNo))
		 			{
		 				repfn.FnUpdateTestStepResHTML("Verify if Credit Card number is displayed with pre-selected values", "Credit Card number is displayed with pre-selected values: " +Card.getAttribute("value"), "PASS",runManagerInfoObj);
		 				blnFlag=true;
		 			}
		 			else
		 			{
		 				repfn.FnUpdateTestStepResHTML("Verify if Credit Card number is displayed with pre-selected values", "Credit Card number is not displayed with pre-selected values", "FAIL",runManagerInfoObj);
		 				blnFlag=false;	
		 			}
		 		}
		 		else
		 		{
		 			repfn.FnUpdateTestStepResHTML("Verify if Credit Card Number is displayed", "CreditCard Number is not displayed", "FAIL",runManagerInfoObj);
		 			blnFlag=false;
		 		}
		 		
		 		if(cnf.FnExplicitWait("XPATH", mbo.PayBill_ExpiryDate,driver))
		 		{
		 			String ExpiryDate=m1.get("ExpDate").toString();
		 			WebElement ExpDate=driver.findElement(By.xpath(mbo.PayBill_ExpiryDate));
		 			repfn.FnUpdateTestStepResHTML("Verify if Expiry Date is displayed", "Expiry Date is displayed", "PASS",runManagerInfoObj);
		 			if(ExpDate.getAttribute("value").equals(ExpiryDate))
		 			{
		 				repfn.FnUpdateTestStepResHTML("Verify if Expiry Date is displayed with pre-selected values", "Expiry Date is displayed with pre-selected values: " +ExpDate.getAttribute("value"), "PASS",runManagerInfoObj);
		 				blnFlag=true;
		 			}
		 			else
		 			{
		 				repfn.FnUpdateTestStepResHTML("Verify if Expiry Date is displayed with pre-selected values", "Expiry Date is not displayed with pre-selected values", "FAIL",runManagerInfoObj);
		 				blnFlag=false;	
		 			}
		 		}
		 		else
		 		{
		 			repfn.FnUpdateTestStepResHTML("Verify if Expiry Date is displayed", "Expiry Date is not displayed", "FAIL",runManagerInfoObj);
		 			blnFlag=false;
		 		}
		 		
		 		if(cnf.FnExplicitWait("XPATH", mbo.Paybill_Amount,driver))
		 		{
		 			String PayMount=m1.get("Amount").toString();
		 			WebElement PayAmount=driver.findElement(By.xpath(mbo.Paybill_Amount));
		 			repfn.FnUpdateTestStepResHTML("Verify if Payment amount is displayed", "Payment amount is displayed", "PASS",runManagerInfoObj);
		 			if(PayAmount.getAttribute("value").equals(PayMount))
		 			{
		 				repfn.FnUpdateTestStepResHTML("Verify if Payment Amount is displayed with pre-selected values", "Payment Amount is displayed with pre-selected values: " +PayAmount.getAttribute("value"), "PASS",runManagerInfoObj);
		 				blnFlag=true;
		 			}
		 			else
		 			{
		 				repfn.FnUpdateTestStepResHTML("Verify if Payment Amount is displayed with pre-selected values", "Payment Amount is not displayed with pre-selected values", "FAIL",runManagerInfoObj);
		 				blnFlag=false;	
		 			}
		 		}
		 		else
		 		{
		 			repfn.FnUpdateTestStepResHTML("Verify if Payment Amount is displayed", "Payment Amount is not displayed", "FAIL",runManagerInfoObj);
		 			blnFlag=false;
		 		}
		 		
		 		
		 	}
		 	catch(Exception e)
		 	{
		 		System.err.println("Message : "+e.getMessage());
		         System.err.println("Cause : "+e.getCause());	
		 	}
		 	 m1.put("STEPSTATUS", blnFlag);
		      return blnFlag;
		 }
		 public synchronized boolean Paybill_EditPayment(WebDriver driver, RunManagerInfo runManagerInfoObj)
		 {
		 	try
		 	{
		 		if(cnf.FnExplicitWait("XPATH", mbo.Paybill_EditPamentInfo,driver))
		 		{
		 			WebElement Edit=driver.findElement(By.xpath(mbo.Paybill_EditPamentInfo));
		 			repfn.FnUpdateTestStepResHTML("Verify if Edit Payment Info link is present", "Edit Payment Info Link is present", "PASS",runManagerInfoObj);
		 			if(Edit.isDisplayed())
		 			{
		 				Thread.sleep(1000);
		 				cnf.JSClick(Edit,driver);
		 				repfn.FnUpdateTestStepResHTML("Click the Edit Payment Info link", "Edit Payment Info link is clicked", "PASS",runManagerInfoObj);
		 				if(cnf.FnExplicitWait("XPATH", mbo.PayBillpage,driver))
		 				{
		 					repfn.FnUpdateTestStepResHTML("Verify if User is taken to previous Pay Bill screen", "User is taken to the previous Pay Bill screen", "PASS",runManagerInfoObj);
		 					blnFlag=true;
		 				}
		 				else
		 				{
		 					repfn.FnUpdateTestStepResHTML("Verify if User is taken to previous Pay Bill screen", "User is not taken to the previous Pay Bill screen", "FAIL",runManagerInfoObj);
		 					blnFlag=false;
		 				}
		 			}
		 			else
		 			{
		 				repfn.FnUpdateTestStepResHTML("Click the Edit Payment Info link", "Edit Payment Info link is not clicked", "FAIL",runManagerInfoObj);
		 				blnFlag=false;
		 			}
		 		}
		 		else
		 		{
		 			repfn.FnUpdateTestStepResHTML("Verify if Edit Payment Info link is present", "Edit Payment Info Link is not present", "FAIL",runManagerInfoObj);
		 			blnFlag=false;
		 		}
		 	}
		 	catch(Exception e)
		 	{
		 		System.err.println("Message : "+e.getMessage());
		         System.err.println("Cause : "+e.getCause());	
		 	
		 	}
		 	 m1.put("STEPSTATUS", blnFlag);
		      return blnFlag;
		 }

		 public synchronized boolean VerifyPaymentIno(WebDriver driver, RunManagerInfo runManagerInfoObj)
		 {
		 	try
		 	{
		 		
		 		
		 		
		 		
		 		if(cnf.FnExplicitWait("XPATH", mbo.VerifyPay_Card,driver))
		 		{
		 			String CCNo=m1.get("CardNum").toString();
		 			String CC=CCNo;
		 			int length=CC.length();
		 			String LastCC=CCNo.substring(12);
		 			System.out.println("Digits"+LastCC);
		 			WebElement Card=driver.findElement(By.xpath(mbo.VerifyPay_Card));
		 			repfn.FnUpdateTestStepResHTML("Verify if Credit Card Number is displayed", "CreditCard Number is displayed", "PASS",runManagerInfoObj);
		 			if(Card.getAttribute("textContent").contains("Visa *"+LastCC))
		 			{
		 				
		 				repfn.FnUpdateTestStepResHTML("Verify if Credit Card number entered in Pay bill page is retained in Verify Payment Information screen", "Credit Card number entered in Pay bill page is retained in Verify Payment Information screen: " +Card.getAttribute("textContent"), "PASS",runManagerInfoObj);
		 				blnFlag=true;
		 			}
		 			else
		 			{
		 				repfn.FnUpdateTestStepResHTML("Verify if Credit Card number entered in Pay bill page is retained in Verify Payment Information screen", "Credit Card number entered in Pay bill page is not retained in Verify Payment Information screen", "FAIL",runManagerInfoObj);
		 				blnFlag=false;	
		 			}
		 		}
		 		else
		 		{
		 			repfn.FnUpdateTestStepResHTML("Verify if Credit Card Number is displayed", "CreditCard Number is not displayed", "FAIL",runManagerInfoObj);
		 			blnFlag=false;
		 		}
		 		
		 		if(cnf.FnExplicitWait("XPATH", mbo.VerifyPay_ExpDate,driver))
		 		{
		 			String ExpiryDate=m1.get("ExpDate").toString();
		 			WebElement ExpDate=driver.findElement(By.xpath(mbo.VerifyPay_ExpDate));
		 			repfn.FnUpdateTestStepResHTML("Verify if Expiry Date is displayed", "Expiry Date is displayed", "PASS",runManagerInfoObj);
		 			if(ExpDate.getAttribute("textContent").equals(ExpiryDate))
		 			{
		 				repfn.FnUpdateTestStepResHTML("Verify if Expiry Date entered in Pay bill page is retained in Verify Payment Information screen", "Expiry Date entered in Pay bill page is retained in Verify Payment Information screen: " +ExpDate.getAttribute("textContent"), "PASS",runManagerInfoObj);
		 				blnFlag=true;
		 			}
		 			else
		 			{
		 				repfn.FnUpdateTestStepResHTML("Verify if Expiry Date entered in Pay bill page is retained in Verify Payment Information screen", "Expiry Date entered in Pay bill page is not retained in Verify Payment Information screen", "FAIL",runManagerInfoObj);
		 				blnFlag=false;	
		 			}
		 		}
		 		else
		 		{
		 			repfn.FnUpdateTestStepResHTML("Verify if Expiry Date is displayed", "Expiry Date is not displayed", "FAIL",runManagerInfoObj);
		 			blnFlag=false;
		 		}
		 		
		 		if(cnf.FnExplicitWait("XPATH", mbo.VerifyPay_Amount,driver))
		 		{
		 			String PayMount=m1.get("Amount").toString();
		 			WebElement PayAmount=driver.findElement(By.xpath(mbo.VerifyPay_Amount));
		 			repfn.FnUpdateTestStepResHTML("Verify if Payment amount is displayed", "Payment amount is displayed", "PASS",runManagerInfoObj);
		 			if(PayAmount.getAttribute("textContent").contains("$"+PayMount))
		 			{
		 				repfn.FnUpdateTestStepResHTML("Verify if Payment Amount entered in Pay bill page is retained in Verify Payment Information screen", "Payment Amount entered in Pay bill page is retained in Verify Payment Information screen: " +PayAmount.getAttribute("textContent"), "PASS",runManagerInfoObj);
		 				blnFlag=true;
		 			}
		 			else
		 			{
		 				repfn.FnUpdateTestStepResHTML("Verify if Payment Amount entered in Pay bill page is retained in Verify Payment Information screen", "Payment Amount entered in Pay bill page is not retained in Verify Payment Information screen", "FAIL",runManagerInfoObj);
		 				blnFlag=false;	
		 			}
		 		}
		 		else
		 		{
		 			repfn.FnUpdateTestStepResHTML("Verify if Payment Amount is displayed", "Payment Amount is not displayed", "FAIL",runManagerInfoObj);
		 			blnFlag=false;
		 		}
		 		
		 		
		 	}
		 	catch(Exception e)
		 	{
		 		System.err.println("Message : "+e.getMessage());
		         System.err.println("Cause : "+e.getCause());	
		 	}
		 	 m1.put("STEPSTATUS", blnFlag);
		      return blnFlag;
		 }
		

		
		public synchronized boolean OTP_CheckingsSavings_FillDetails(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
		{
			try
			{
				boolean blnFlag1 = OTPChecked(driver,runManagerInfoObj);
				boolean blnFlag2 = CheckingSavingsChecked(driver,runManagerInfoObj);
				boolean blnFlag3 = PaymentInfo_OTP_CheckingSaving_Checked(driver,runManagerInfoObj);
				boolean blnFlag4 = PaymentInfo_OTP_CheckingSaving_FillDetails(driver,runManagerInfoObj);
				boolean blnFlag5 = VerifyPaymentInfo(driver,runManagerInfoObj);
				driver.navigate().refresh();
				app.AlertAccept(driver,runManagerInfoObj);
				driver.switchTo().defaultContent();

				if(blnFlag1 && blnFlag2 && blnFlag3 && blnFlag4 && blnFlag5){
					repfn.FnUpdateTestStepResHTML("Verify User is able to verify Payment Information screen","User is able to verify Payment Information screen","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User is able to verify Payment Information screen","User is not able to verify Payment Information screen","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

			}
			catch(Exception e)
			{
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				repfn.FnUpdateTestStepResHTML("Verify User is able to verify Payment Information screen","User is not able to verify Payment Information screen due to some exception ","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		public synchronized boolean CheckingSavingsChecked(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
		{
			String checkCheckingsSavingsStatus="";
			try
			{
				driver.switchTo().frame("iFrameResizer0");
				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CheckingsSavings_RadioBtn,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence Checkings/Savings radio button in Paybill screen","Checkings/Savings radio button is present","PASS",runManagerInfoObj);
					WebElement CheckingsSavingsRadioBtn=driver.findElement(By.xpath(mbo.PayBill_CheckingsSavings_RadioBtn));
					
					if(cnf.isElementExistOne("XPATH", mbo.PayBill_CheckingsSavings_RadioBtn_Selection,driver)){
						WebElement PayBill_CheckingsSavings_RadioBtn_Selection=driver.findElement(By.xpath(mbo.PayBill_CheckingsSavings_RadioBtn_Selection));
						checkCheckingsSavingsStatus=PayBill_CheckingsSavings_RadioBtn_Selection.getAttribute("aria-checked");
						if(checkCheckingsSavingsStatus.equalsIgnoreCase("true"))
						{
							repfn.FnUpdateTestStepResHTML("Verify Checkings/Savings radio button in Paybill screen is checked","Checkings/Savings radio button is checked already","PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else if(checkCheckingsSavingsStatus.equalsIgnoreCase("false"))
						{
							repfn.FnUpdateTestStepResHTML("Verify Checkings/Savings radio button in Paybill screen is checked","Checkings/Savings radio button is not checked already","PASS",runManagerInfoObj);
							Thread.sleep(1000);
							if(cnf.JSClick(CheckingsSavingsRadioBtn,driver))
							{
								Thread.sleep(1000);
								repfn.FnUpdateTestStepResHTML("Verify Checkings/Savings radio button in Paybill screen is clicked","Checkings/Savings radio button is clicked","PASS",runManagerInfoObj);
								checkCheckingsSavingsStatus=PayBill_CheckingsSavings_RadioBtn_Selection.getAttribute("aria-checked");
								if(checkCheckingsSavingsStatus.equalsIgnoreCase("true"))
								{
									repfn.FnUpdateTestStepResHTML("Verify Checkings/Savings radio button in Paybill screen is checked","Checkings/Savings radio button is checked","PASS",runManagerInfoObj);
									blnFlag=true;
								}
								else
								{
									repfn.FnUpdateTestStepResHTML("Verify Checkings/Savings radio button in Paybill screen is checked","Checkings/Savings radio button is not checked","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify Checkings/Savings radio button in Paybill screen is clicked","Checkings/Savings radio button is not clicked","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
					}

					else{
						blnFlag=false;
					}			
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence Checkings/Savings radio button in Paybill screen","Checkings/Savings radio button is not present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				driver.switchTo().defaultContent();
			}
			catch(Exception e)
			{
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());	
				repfn.FnUpdateTestStepResHTML("Verify the presence Checkings/Savings radio button in Paybill screen","Checkings/Savings radio button is not present and clicked due to some exception","FAIL",runManagerInfoObj);
				blnFlag=false;

			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		public synchronized boolean OTPChecked(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
		{
			String checkOTPStatus="";
			try
			{
				driver.switchTo().frame("iFrameResizer0");
				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_OTP_RadioBtn,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence OTP radio button in Paybill screen","OTP radio button is present","PASS",runManagerInfoObj);
					WebElement OTPRadioBtn=driver.findElement(By.xpath(mbo.PayBill_OTP_RadioBtn));
					
					if(cnf.isElementExistOne("XPATH", mbo.PaymentFrequency_OneTime_Selection,driver)){
						WebElement PaymentFrequency_OneTime_Selection=driver.findElement(By.xpath(mbo.PaymentFrequency_OneTime_Selection));
						checkOTPStatus = PaymentFrequency_OneTime_Selection.getAttribute("aria-checked");

						if(checkOTPStatus.equalsIgnoreCase("true"))
						{
							repfn.FnUpdateTestStepResHTML("Verify OTP radio button in Paybill screen is checked","OTP radio button is checked already","PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify OTP radio button in Paybill screen is checked","OTP radio button is not checked already","PASS",runManagerInfoObj);
							if(cnf.JSClick(OTPRadioBtn,driver)){
								repfn.FnUpdateTestStepResHTML("Verify OTP radio button in Paybill screen is clicked","OTP radio button is clicked","PASS",runManagerInfoObj);
								checkOTPStatus = PaymentFrequency_OneTime_Selection.getAttribute("aria-checked");
								if(checkOTPStatus.equalsIgnoreCase("true"))
								{
									repfn.FnUpdateTestStepResHTML("Verify OTP radio button in Paybill screen is checked","OTP radio button is checked already","PASS",runManagerInfoObj);
									blnFlag=true;
								}
								else
								{
									repfn.FnUpdateTestStepResHTML("Verify OTP radio button in Paybill screen is checked","OTP radio button is not checked","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify OTP radio button in Paybill screen is clicked","OTP radio button is not clicked","FAIL",runManagerInfoObj);
								blnFlag=false;
							}

						}
					}
					else{
						System.out.println("input not displayed");
						blnFlag=false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence OTP radio button in Paybill screen","OTP radio button is not present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				driver.switchTo().defaultContent();
			}
			catch(Exception e)
			{
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				repfn.FnUpdateTestStepResHTML("Verify the presence OTP radio button in Paybill screen","OTP radio button is not present and checked due to some exception","FAIL",runManagerInfoObj);
				blnFlag=false;

			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		public synchronized boolean fncheckingOrSavingsHelpIcon(WebDriver driver, RunManagerInfo runManagerInfoObj)
		{
			try
			{
				driver.switchTo().frame("iFrameResizer0");

				if(cnf.FnExplicitWait("XPATH", mbo.routingNumberHelpIcon,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if Help icon is displayed next to Routing number field", "Help icon is displayed next to Routing number field", "PASS",runManagerInfoObj);
					WebElement helpIconRouting=driver.findElement(By.xpath(mbo.routingNumberHelpIcon));
					if(cnf.JSClick(helpIconRouting,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify if User has clicked the help icon next to Routing number field", "User has clicked the help icon next to Routing number field", "PASS",runManagerInfoObj);
						if(cnf.FnExplicitWait("ID", mbo.modalDescription,driver)){
							WebElement modalDescripion=driver.findElement(By.id(mbo.modalDescription));
							if(modalDescripion.getText().equalsIgnoreCase("Please enter your nine digit bank routing number."))
							{
								repfn.FnUpdateTestStepResHTML("Verify if User is able to see modal pop up with message", "User is able to see modal pop up with message: "+modalDescripion.getText(), "PASS",runManagerInfoObj);
								if(cnf.FnExplicitWait("XPATH", mbo.okButtonModal,driver)){
									repfn.FnUpdateTestStepResHTML("Verify if User is able to see \"ok\" button in modal popup", "User is able to see \"ok\" button in modal popup", "PASS",runManagerInfoObj);
									WebElement okButtonModal=driver.findElement(By.xpath(mbo.okButtonModal));
									if(cnf.JSClick(okButtonModal,driver))
									{
										repfn.FnUpdateTestStepResHTML("Verify if User has clicked \"ok\" button in modal popup", "User has clicked \"ok\" button in modal popup", "PASS",runManagerInfoObj);
										blnFlag=true;
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify if User has clicked \"ok\" button in modal popup", "User has not clicked \"ok\" button in modal popup", "FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									blnFlag=false;
									repfn.FnUpdateTestStepResHTML("Verify if user is able to see \"ok\" button in modal popup", "User is not able to see \"ok\" button in modal popup", "FAIL",runManagerInfoObj);
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify if User is able to see modal pop up with message", "User is not able to see modal pop up with message", "FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify if User is able to see modal pop up with message", "User is not able to see modal pop up with message", "FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify if User has clicked the help icon next to Routing number field", "User has not clicked the help icon next to Routing number field", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify if Help icon is displayed next to Routing number field", "Help icon is not displayed next to Routing number field", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				if(cnf.FnExplicitWait("XPATH", mbo.accountNumberHelpIcon,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if Help icon is displayed next to Account number field", "Help icon is displayed next to Account number field", "PASS",runManagerInfoObj);
					WebElement helpIconAccount=driver.findElement(By.xpath(mbo.accountNumberHelpIcon));
					Thread.sleep(3000);
					if(cnf.ElementClick1(helpIconAccount))
					{
						repfn.FnUpdateTestStepResHTML("Verify if User has clicked the help icon next to Account number field", "User has clicked the help icon next to Account number field", "PASS",runManagerInfoObj);
						if(cnf.FnExplicitWait("ID", mbo.modalDescription,driver)){
							WebElement modalDescripion=driver.findElement(By.id(mbo.modalDescription));
							if(modalDescripion.getText().equalsIgnoreCase("Please enter your bank account number."))
							{
								repfn.FnUpdateTestStepResHTML("Verify if User is able to see modal pop up with message", "User is able to see modal pop up with message: "+modalDescripion.getText(), "PASS",runManagerInfoObj);
								if(cnf.FnExplicitWait("XPATH", mbo.okButtonModal,driver)){
									repfn.FnUpdateTestStepResHTML("Verify if User is able to see \"ok\" button in modal popup", "User is able to see \"ok\" button in modal popup", "PASS",runManagerInfoObj);
									WebElement okButtonModal=driver.findElement(By.xpath(mbo.okButtonModal));
									if(cnf.JSClick(okButtonModal,driver))
									{
										repfn.FnUpdateTestStepResHTML("Verify if User has clicked \"ok\" button in modal popup", "User has clicked \"ok\" button in modal popup", "PASS",runManagerInfoObj);
										blnFlag=true;
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify if User has clicked \"ok\" button in modal popup", "User has not clicked \"ok\" button in modal popup", "FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									blnFlag=false;
									repfn.FnUpdateTestStepResHTML("Verify if user is able to see \"ok\" button in modal popup", "User is not able to see \"ok\" button in modal popup", "FAIL",runManagerInfoObj);
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify if User is able to see modal pop up with message", "User is not able to see modal pop up with message", "FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify if User is able to see modal pop up with message", "User is not able to see modal pop up with message", "FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify if User has clicked the help icon next to Account number field", "User has not clicked the help icon next to Account number field", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify if Help icon is displayed next to Account number field", "Help icon is not displayed next to Account number field", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				driver.switchTo().defaultContent();
			}
			catch (Exception e)

			{		
				blnFlag=false;
				repfn.FnUpdateTestStepResHTML("Verify if Help icon is displayed next to Account number and Routing Number field", "Help icon is not displayed next to Account number and Routing Number field due to some exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}

			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}

		 public synchronized boolean FnBillPayOptionsTab(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
			 try{			
				 if(cnf.FnExplicitWait("XPATH", mbo.billPayOptionsTab,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify Bill pay options link is displayed","Bill pay options link is displayed","PASS",runManagerInfoObj);
					 WebElement billPayOptionTab=driver.findElement(By.xpath(mbo.billPayOptionsTab));
					 if(cnf.JSClick(billPayOptionTab,driver))
					 {
						 repfn.FnUpdateTestStepResHTML("Verify Bill pay options link is clicked","Bill pay options link is clicked","PASS",runManagerInfoObj);
						 
						 Thread.sleep(2000);
	    				  if(cnf.FnExplicitWait("XPATH", mbo.PageVerificationOne,driver)){
	     					  WebElement payBill_PageVerification_1=driver.findElement(By.xpath(mbo.PageVerificationOne));
	     					  if(payBill_PageVerification_1.getAttribute("textContent").equalsIgnoreCase("Billing")){
	     						  if(cnf.FnExplicitWait("XPATH", mbo.PageVerificationTwo,driver)){
	     							  WebElement payBill_PageVerification_2=driver.findElement(By.xpath(mbo.PageVerificationTwo));
	     							  if(payBill_PageVerification_2.getAttribute("textContent").equalsIgnoreCase("Bill Pay Options")){
	     								  repfn.FnUpdateTestStepResHTML("Verify User is navigated to Bill Pay Options page","User is navigated to Bill Pay Options page","PASS",runManagerInfoObj);
	     								  blnFlag=true;
	     							  }

	     							  else{
	     								  repfn.FnUpdateTestStepResHTML("Verify User is navigated to Bill Pay Options page","User is not navigated to Bill Pay Options page","FAIL",runManagerInfoObj);
	     								  blnFlag=false;
	     							  }
	     						  }
	     					  }
	     				  }
					 }
					 else
					 {
						 repfn.FnUpdateTestStepResHTML("Verify Bill pay options link is clicked","Bill pay options link is not clicked","FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify Bill pay options link is displayed","Bill pay options link is not displayed","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }

			 catch (Exception e)
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if user is navigated to bill pay options Page", "User is not navigated to bill pay options page due to some exception", "FAIL",runManagerInfoObj);
				 System.err.println("Message : "+e.getMessage());
				 System.err.println("Cause : "+e.getCause());
				 blnFlag=false;
			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;
		 }

		 public synchronized boolean Q2Wall_OTP_CheckingsSavings_EditPaymentCheck(WebDriver driver, RunManagerInfo runManagerInfoObj)
		 {
		 	try
		 	{
		 		driver.switchTo().frame("iFrameResizer0");
		 		
		 		Thread.sleep(5000);
		 		OTPChecked(driver,runManagerInfoObj);
		 		Thread.sleep(2000);
		 		CheckingSavingsChecked(driver,runManagerInfoObj);
		 		
		 		Q2Wall_PaymentInfo_OTP_CheckingSaving_Checked(driver,runManagerInfoObj);
		 		PaymentInfo_OTP_CheckingSaving_FillDetails(driver,runManagerInfoObj);
		 		//VerifyPaymentInfo();
		 		
		 		Q2wall_VerifyPaymentInfo(driver,runManagerInfoObj);
		 		
		 		driver.switchTo().defaultContent();
		 		blnFlag=true;
		 	}
		 	catch(Exception e)
		 	{
		 		System.err.println("Message : "+e.getMessage());
		   System.err.println("Cause : "+e.getCause());	
		 	
		 	}
		 	 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
		 }
		 //To navigate to support page from Verify Payment screen//

		 public synchronized boolean Paybill_VerifyPayment_support(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
		 {
			 try
			 {	
				 boolean blnFlag1 = app.EditCreditCard(driver,runManagerInfoObj);
				 boolean blnFlag2 = EditExpDate(driver,runManagerInfoObj);
				 boolean blnFlag3 = app.EditPayAmnt(driver,runManagerInfoObj);
				 boolean blnFlag4 = EditPayDate(driver,runManagerInfoObj);
				 boolean blnFlag5 = app.PayBill_PayNow(driver,runManagerInfoObj);
				 
				 if(blnFlag1 && blnFlag2 && blnFlag3 && blnFlag4 && blnFlag5){
					 boolean blnFlag6 = PayBill_Support(driver,runManagerInfoObj);
					 if(blnFlag6){
						 repfn.FnUpdateTestStepResHTML("Verify User is able to navigate from Payment Confirmation page to Support page","User is able to navigate from Payment Confirmation page to Support page","PASS",runManagerInfoObj);
						 blnFlag=true;
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify User is able to navigate from Payment Confirmation page to Support page","User is not able to navigate from Payment Confirmation page to Support page","FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if user is navigated to Verify Payment Information", "User is not navigated to Verify Payment Information", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
				 
				 driver.navigate().refresh();
			 }
			 catch(Exception e)
			 {
				 System.err.println("Message : "+e.getMessage());
				 System.err.println("Cause : "+e.getCause());
				 repfn.FnUpdateTestStepResHTML("Verify User is able to navigate from Payment Confirmation page to Support page","User is not able to navigate from Payment Confirmation page to Support page due to some exception","FAIL",runManagerInfoObj);
				 blnFlag=false;

			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;
		 }
		 //To click on support link from Verify Payment info page//


		 public synchronized boolean PayBill_Support(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
			 try{
				 driver.switchTo().frame("iFrameResizer0");
				 
				 if(cnf.FnExplicitWait("XPATH", mbo.VerifyPay_Support,driver))
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if Support link is present", "Support link is present", "PASS",runManagerInfoObj);
					 WebElement Support=driver.findElement(By.xpath(mbo.VerifyPay_Support));

					 if(cnf.JSClick(Support,driver)){
						 repfn.FnUpdateTestStepResHTML("Verify Click on Support link", "Support link is clicked", "PASS",runManagerInfoObj);
						 Thread.sleep(3000);
						app.AlertAccept(driver,runManagerInfoObj);
						 driver.switchTo().defaultContent();
						 Thread.sleep(3000);
						 if(cnf.FnExplicitWait("XPATH",mbo.Supportpage,driver))
						 {
							 repfn.FnUpdateTestStepResHTML("Verify User is navigated to Support page","User is navigated to support Page","PASS",runManagerInfoObj);
							 blnFlag=true;
							 Thread.sleep(1000);		            
						 }
						 else
						 {
							 repfn.FnUpdateTestStepResHTML("Verify User is navigated to Support page","User is not navigated to support Page","FAIL",runManagerInfoObj);
							 blnFlag=false; 
						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify Click on Support link", "Support link is not clicked", "FAIL",runManagerInfoObj);
						 blnFlag=false; 
					 }
				 }
				 else
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if Support link is present", "Support link is not present", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }

				 driver.switchTo().defaultContent();

			 }

			 catch (Exception e)

			 {
				 System.err.println("Message : "+e.getMessage());
				 System.err.println("Cause : "+e.getCause());
				 repfn.FnUpdateTestStepResHTML("Verify User is navigated to Support page","User is not navigated to support Page due to some exception","FAIL",runManagerInfoObj);
				 blnFlag=false; 

			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;
		 }

		
		
		
		 public synchronized boolean fnVerifyAutopayEnabledUI(WebDriver driver, RunManagerInfo runManagerInfoObj)
		 {
		 	try
		 	{
		 		driver.switchTo().frame("iFrameResizer0");
		 		if(cnf.FnExplicitWait("XPATH",mbo.CurrentBillSection,driver))
		 		{
		 			repfn.FnUpdateTestStepResHTML("Verify the presence of current bill section in pay bill screen", "Current bill section is present in pay bill screen", "PASS",runManagerInfoObj);

		 		if(cnf.FnExplicitWait("XPATH",mbo.PayBillOption,driver)){
		 			
		 			repfn.FnUpdateTestStepResHTML("Verify the presence of Pay Bill Options titles in pay bill screen", "Pay Bill Options titles is present in pay bill screen"+" "+driver.findElement(By.xpath(mbo.Q2Wall_PayBill_AccNumTitle)).getText(), "PASS",runManagerInfoObj);
		 			blnFlag=true;
		 		}
		 		else
		 		{
		 			repfn.FnUpdateTestStepResHTML("Verify the presence of Pay Bill Options titles in pay bill screen", "Pay Bill Options titles is not present in pay bill screen", "FAIL",runManagerInfoObj);
		           blnFlag=false;
		 		}
		 		if(cnf.isElementExist(By.xpath(mbo.PayBill_AccNumTitle),driver))
		 		{
		 			repfn.FnUpdateTestStepResHTML("Verify the presence of Account number title in pay bill screen", "Account number title is present in pay bill screen"+" "+driver.findElement(By.xpath(mbo.Q2Wall_PayBill_AccNumTitle)).getText(), "PASS",runManagerInfoObj);
		 		blnFlag=true;
		 		}
		 		else
		 		{
		 			repfn.FnUpdateTestStepResHTML("Verify the presence of Account number title in pay bill screen", "Account number title is not present in pay bill screen", "FAIL",runManagerInfoObj);
		           blnFlag=false;
		 		}
		 		  if(cnf.isElementExist(By.xpath(mbo.PayBill_AccNum),driver))
		 		  {
		 				repfn.FnUpdateTestStepResHTML("Verify the presence of Account number in pay bill screen", "Account number is present in pay bill screen"+" "+driver.findElement(By.xpath(mbo.Q2Wall_PayBill_AccNum)).getText(), "PASS",runManagerInfoObj);
		               blnFlag=true;
		 		  }
		 		  else
		 		  {
		 				repfn.FnUpdateTestStepResHTML("Verify the presence of Account number in pay bill screen", "Account number is not present in pay bill screen", "FAIL",runManagerInfoObj);
		              blnFlag=false;
		 		  }
		 		  if(cnf.isElementExist(By.xpath(mbo.PayBill_CurrentBillAmt),driver))
		 		  {
		 		       WebElement Q2Wall_PayBill_CurrentBillAmt=driver.findElement(By.xpath(mbo.PayBill_CurrentBillAmt));
		                String amount=Q2Wall_PayBill_CurrentBillAmt.getText();
		 			   repfn.FnUpdateTestStepResHTML("Verify Current bill amount is displayed or not","Current bill amount is displayed as: "+amount,"PASS",runManagerInfoObj);
		 			   if(cnf.verifyAmountFormat(amount)){
		 				repfn.FnUpdateTestStepResHTML("Verify Current bill amount is displayed in format $X,XXX.XX","Current bill Amount is displayed as per format:"+amount,"PASS",runManagerInfoObj);
		               blnFlag=true;
		 			  }
		 			  else{
		 					repfn.FnUpdateTestStepResHTML("Verify Current bill amount is displayed in format $X,XXX.XX","Current bill Amount is not displayed as:"+amount,"FAIL",runManagerInfoObj);
		 					blnFlag=false;
		 				}
		 		  }
		 		  else
		 		  {
		 			  repfn.FnUpdateTestStepResHTML("Verify the presence of current bill amount in pay bill screen", "Current Bill amount is not present in pay bill screen", "FAIL",runManagerInfoObj);
		             blnFlag=false;
		 		  }
		 		  
		 		  if(cnf.isElementExist(By.xpath(mbo.PayBill_StatementDate),driver))
		 		  {
		 		      repfn.FnUpdateTestStepResHTML("Verify statement date is displayed in pay bill screen","Statement date is present in pay bill screen","PASS",runManagerInfoObj);
		 				WebElement PayBill_StatementDate=driver.findElement(By.xpath(mbo.PayBill_StatementDate));
		 				String date=PayBill_StatementDate.getText();
		 				String date5[]=date.split("-");
		 				String date1=date5[0];
		 				if(cnf.isValidFormat("mm/dd/yy",date1)){
		 				repfn.FnUpdateTestStepResHTML("Verify the presence of statement date in pay bill screen in format mm/dd/yy", "Statement date is present as per the format in pay bill screen", "PASS",runManagerInfoObj);
		               blnFlag=true;
		 			  }
		 			  else{
		 				repfn.FnUpdateTestStepResHTML("Verify the presence of statement date in pay bill screen in format mm/dd/yy","Statement date is not displayed as per the format in pay bill screen","FAIL",runManagerInfoObj);
		 				blnFlag=false;
		 			}			
		 		  }
		 		  else
		 		  {
		 			  repfn.FnUpdateTestStepResHTML("erify statement date is displayed in pay bill screen","Statement date is not present in pay bill screen", "FAIL",runManagerInfoObj);
		             blnFlag=false;
		 		  }
		 		  
		 		  if(cnf.FnExplicitlessWait_untilClickable("XPATH", "//a[@ng-click='navigate(URL.currentBill)']",driver))
		 			{
		 				blnFlag=true;
		 				repfn.FnUpdateTestStepResHTML("Verify if user is able to see details link in pay bill screen", "User is able to see details link in pay bill screen", "PASS",runManagerInfoObj);
		 				}
		 				
		 				else
		 			{
		 				blnFlag=false;
		 				repfn.FnUpdateTestStepResHTML("Verify if user is able to see details link in pay bill screen", "User is not able to see details link in pay bill screen", "FAIL",runManagerInfoObj);
		 			}
		 			
		 			if(cnf.FnExplicitlessWait_untilClickable("XPATH", "//div[@ng-show='isDisabled']/i[@class='icon icon--blue-4 autopay__icon sb_ic_autopay_f']",driver))
		 					{
		 						blnFlag=true;
		 						repfn.FnUpdateTestStepResHTML("Verify if auto pay icon is present for the user in the View statements page", "Auto pay icon is present for the user in the View statements page", "PASS",runManagerInfoObj);
		 						if(cnf.FnExplicitWait("XPATH", "//div/Strong[contains(.,'Auto-Pay On')]",driver))
		 						{
		 							blnFlag=true;
		 							repfn.FnUpdateTestStepResHTML("Verify if verbiage \"Auto-Pay On\" is present along with auto pay icon", "Verbiage \"Auto-Pay On\" is present along with auto pay icon", "PASS",runManagerInfoObj);
		 							if(cnf.FnExplicitWait("XPATH", "//div[@class='pmt-date-txt ng-scope']",driver))
		 							{
		 								blnFlag=true;
		 								repfn.FnUpdateTestStepResHTML("Verify if verbiage \"Next Payment Scheduled\" is present along with auto pay icon", "Verbiage \"Next Payment Scheduled\" is present along with auto pay icon", "PASS",runManagerInfoObj);	
		 							}
		 							else
		 							{
		 								blnFlag=true;
		 								repfn.FnUpdateTestStepResHTML("Verify if verbiage \"Next Payment Scheduled\" is present along with auto pay icon", "Verbiage \"Next Payment Scheduled\" is present along with auto pay icon", "PASS",runManagerInfoObj);
		 							}
		 						}
		 						else
		 						{
		 							blnFlag=false;
		 							repfn.FnUpdateTestStepResHTML("Verify if verbiage \"Auto-Pay On\" is present along with auto pay icon", "Verbiage \"Auto-Pay On\" is not present along with auto pay icon", "FAIL",runManagerInfoObj);
		 						}
		 					}
		 					else
		 					{
		 						blnFlag=false;
		 						repfn.FnUpdateTestStepResHTML("Verify if auto pay icon is present for the user in the View statements page", "Auto pay icon is not present for the user in the View statements page", "FAIL",runManagerInfoObj);
		 					}
		 				
		 		
		 		  
		 		  if(cnf.isElementExist(By.xpath(mbo.Q2Wall_PayBill_DueByTitle),driver))
		 		  {
		 				repfn.FnUpdateTestStepResHTML("Verify the presence of due by title in pay bill screen", "Due By title is present in pay bill screen"+" "+driver.findElement(By.xpath(mbo.Q2Wall_PayBill_DueByTitle)).getText(), "PASS",runManagerInfoObj);
		               blnFlag=true;
		 		  }
		 		  else
		 		  {
		 			  repfn.FnUpdateTestStepResHTML("Verify the presence of Due By title in pay bill screen", "Due by title is not present in pay bill screen", "FAIL",runManagerInfoObj);
		             blnFlag=false;
		 		  }
		 		  
		 		  if(cnf.isElementExist(By.xpath(mbo.Q2Wall_PayBill_DueBy),driver))		  
		 		  {
		 		       repfn.FnUpdateTestStepResHTML("Verify Due by date is displayed in pay bill screen","Due by date is present in pay bill screen","PASS",runManagerInfoObj);
		 		      WebElement Q2Wall_PayBill_DueBy=driver.findElement(By.xpath(mbo.Q2Wall_PayBill_DueBy));
		 				String date2=Q2Wall_PayBill_DueBy.getText();
		 				String date4[]=date2.split("-");
		 				String date3=date4[0];
		 				if(cnf.isValidFormat("mm/dd/yy",date3)){
		 				repfn.FnUpdateTestStepResHTML("Verify the presence of Due by date in the format mm/dd/yy in pay bill screen", "Due by date is present in pay bill screen as per the format", "PASS",runManagerInfoObj);
		               blnFlag=true;
		 			  }
		 			  else
		 		  {
		 			  repfn.FnUpdateTestStepResHTML("Verify the presence of Due by date in the format mm/dd/yy in pay bill screen", "Due by date is not present in pay bill screen as per the format", "FAIL",runManagerInfoObj);
		             blnFlag=false;
		 		  } 
		 		  }
		 		  else
		 		  {
		 			  repfn.FnUpdateTestStepResHTML("Verify Due by date is displayed in pay bill screen","Due by date is not present in pay bill screen", "FAIL",runManagerInfoObj);
		             blnFlag=false;
		 		  }
		 		
		 		 if(cnf.isElementExist(By.xpath(mbo.VerifyPaymentInfo_Details),driver))
		         {
		 		   List <WebElement> details=driver.findElements(By.xpath(mbo.VerifyPaymentInfo_Details));
		 		   for(int j=0;j<details.size();j++)
		 		   {
		 			all.add(details.get(j).getText());
		         	repfn.FnUpdateTestStepResHTML("Verify the display of Details in Verify Payment Info screen ",details.get(j).getText()+" "+"is displayed in Verify Payment Info screen","PASS",runManagerInfoObj);
		            
		 		   }
		 		  /* if(Pattern.matches("\\*([0-9]{4})",all.get(1).toString()))
		 				   {
		 			   repfn.FnUpdateTestStepResHTML("Verify if Routing number is masked and only 4 characters are displayed","Routing number is masked and only 4 characters are displayed"+all.get(1).toString(), "PASS",runManagerInfoObj);
		 				  blnFlag=true;
		 				   }
		 		   else
		 		   {
		 			 repfn.FnUpdateTestStepResHTML("Verify if Routing number is masked and only 4 characters are displayed","Routing number is not masked and only 4 characters are displayed", "FAIL",runManagerInfoObj);
		 				  blnFlag=false;
		 		   }*/

		 		   if(all.get(1).toString().equalsIgnoreCase("visa"))
		 		   {
		 			   repfn.FnUpdateTestStepResHTML("Verify the Payment type is Visa in Verify payment info screen","Payment type is Visa in Verify payment info screen","PASS",runManagerInfoObj);
		 		       blnFlag=true;
		 		   }
		 		   
		 		   {
		 			 repfn.FnUpdateTestStepResHTML("Verify the Payment type is Visa in Verify payment info screen","Payment type is not Visa in Verify payment info screen","PASS",runManagerInfoObj);
		 		       blnFlag=false;
		 		   }
		 		   if(Pattern.matches("\\*([0-9]{4})",all.get(2).toString()))
		 			   {
		 		   repfn.FnUpdateTestStepResHTML("Verify if Account number is masked and only 4 characters are displayed","Account number is masked and only 4 characters are displayed"+all.get(3).toString(), "PASS",runManagerInfoObj);
		 			  blnFlag=true;
		 			   }
		 	   else
		 	   {
		 		 repfn.FnUpdateTestStepResHTML("Verify if Account number is masked and only 4 characters are displayed","Account number is not masked and only 4 characters are displayed", "FAIL",runManagerInfoObj);
		 		  blnFlag=false;
		 	   }
		        if(cnf.isValidFormat("mm/dd/yy",all.get(3).toString()))
		       	{
		       	 blnFlag=true;
		 			 repfn.FnUpdateTestStepResHTML("Verify if \"Date\" in format \"mm/dd/yy\" is correct", "\"Date\" format  is correct: "+all.get(9).toString(), "PASS",runManagerInfoObj);
		 			 
		 		 }
		 		 else
		 		 {
		 			 blnFlag=false;
		 			 repfn.FnUpdateTestStepResHTML("Verify if \"Date\" in format \"mm/dd/yy\" is correct", "\"Date\" format  is not correct ", "FAIL",runManagerInfoObj);
		 		 }

		         }
		         else
		         {
		 		    repfn.FnUpdateTestStepResHTML("Verify the display of  Payment details link in Verify Payment Info screen ","Edit Payment details link is not displayed in Verify Payment Info screen","FAIL",runManagerInfoObj);
		             blnFlag=false;
		         }
		 		}
		 		else
		 		{
		 			repfn.FnUpdateTestStepResHTML("Verify the presence of current bill section in pay bill screen", "Current bill section is not present in pay bill screen", "FAIL",runManagerInfoObj);
		           blnFlag=false;
		 		}
		 		driver.switchTo().defaultContent();
		 		 driver.navigate().back();
		 	
		 	
		 }
		 	  catch (Exception e)

		 	    {
		 	           repfn.FnUpdateTestStepResHTML("Verify User is in current bill section","User is not in current bill section due to some exception ","FAIL",runManagerInfoObj);


		 	           System.err.println("Message : "+e.getMessage());
		 	           System.err.println("Cause : "+e.getCause());
		 	           blnFlag=false;
		 	    }
		 	    m1.put("STEPSTATUS", blnFlag);
		 	    return blnFlag;
		 }
		 //To click on Complete Payment//


	
		 public synchronized boolean Paybill_completePaymentconfirm_Overview(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
		 {
			 try
			 {
				 boolean blnFlag1 = app.EditCreditCard(driver,runManagerInfoObj);
				 boolean blnFlag2 = EditExpDate(driver,runManagerInfoObj);
				 boolean blnFlag3 = app.EditPayAmnt(driver,runManagerInfoObj);
				 boolean blnFlag4 = EditPayDate(driver,runManagerInfoObj);
				 boolean blnFlag5 = app.PayBill_PayNow(driver,runManagerInfoObj);
				 boolean blnFlag6 = app.PayBill_completePayment(driver,runManagerInfoObj);
				 boolean blnFlag7 = app.PayBill_confirmSuccess(driver,runManagerInfoObj);
				 boolean blnFlag8 = app.PayBill_ReturnToOverview(driver,runManagerInfoObj);
				 driver.navigate().refresh();

				 if(blnFlag1 && blnFlag2 && blnFlag3 && blnFlag4 && blnFlag5 && blnFlag6 && blnFlag7 && blnFlag8){
					 repfn.FnUpdateTestStepResHTML("Verify User is able to complete payment sucessfully and navigate back to Overview page","User is able to complete payment sucessfully and navigate back to Overview page","PASS",runManagerInfoObj);
					 blnFlag=true;
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify User is able to complete payment sucessfully and navigate back to Overview page","User is not able to complete payment sucessfully and navigate back to Overview page","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }

			 }
			 catch(Exception e)
			 {
				 System.err.println("Message : "+e.getMessage());
				 System.err.println("Cause : "+e.getCause());	
				 repfn.FnUpdateTestStepResHTML("Verify User is able to complete payment sucessfully and navigate back to Overview page","User is not able to complete payment sucessfully and navigate back to Overview page due to some exception","FAIL",runManagerInfoObj);
				 blnFlag=false;

			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;
		 }
		 
		 public synchronized boolean Paybill_completePaymentconfirm(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
		 {
			 try
			 {
				 boolean blnFlag1 = app.EditCreditCard(driver,runManagerInfoObj);
				 boolean blnFlag2 = EditExpDate(driver,runManagerInfoObj);
				 boolean blnFlag3 = app.EditPayAmnt(driver,runManagerInfoObj);
				 boolean blnFlag4 = EditPayDate(driver,runManagerInfoObj);
				 boolean blnFlag5 = app.PayBill_PayNow(driver,runManagerInfoObj);
				 if(blnFlag1 && blnFlag2 && blnFlag3 && blnFlag4 && blnFlag5){
					 boolean blnFlag6 = app.PayBill_completePayment(driver,runManagerInfoObj);
					 if(blnFlag6){
						 boolean blnFlag7 = app.PayBill_confirmSuccess(driver,runManagerInfoObj);
						 if(blnFlag7){
							 driver.navigate().refresh();
							 driver.switchTo().defaultContent();
							 repfn.FnUpdateTestStepResHTML("Verify User is able to complete payment sucessfully ","User is able to complete payment sucessfully","PASS",runManagerInfoObj);
							 blnFlag=true;
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify User is able to complete payment sucessfully ","User is not able to complete payment sucessfully","FAIL",runManagerInfoObj);
							 blnFlag=false;
						 }				 
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify if Payment confirmation screen is displayed", "Payment confirmation screen is not displayed", "FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if user is navigated to Verify Payment Information", "User is not navigated to Verify Payment Information", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 catch(Exception e)
			 {
				 System.err.println("Message : "+e.getMessage());
				 System.err.println("Cause : "+e.getCause());
				 repfn.FnUpdateTestStepResHTML("Verify User is able to complete payment sucessfully ","User is not able to complete payment sucessfully due to some exception","FAIL",runManagerInfoObj);
				 blnFlag=false;

			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;
		 }


		
		 
		
		       public synchronized boolean Fn_VerifyPaymentDateField_CurrentDate(WebDriver driver, RunManagerInfo runManagerInfoObj){
		         	
		    	   Date d=Calendar.getInstance().getTime();
		    	    
		           SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		           
		           String currentDate=sdf.format(d);
		           
		           String dateArray[]=currentDate.split("/");
		           String year=dateArray[0];
		           String month=dateArray[1];
		           String day=dateArray[2];
		    	   String PreviousPaymentDate = (month)+"/"+(day)+"/"+year;
		    	   String PreviousPaymentDateChrome = (month)+"/"+(day);
		       
		       	
		       	try{
		       		
		       		driver.switchTo().frame("iFrameResizer0");
		       		
		       		if(cnf.FnExplicitWait("XPATH", mbo.PaymentDate,driver)){
		       			repfn.FnUpdateTestStepResHTML("Verify Payment Date field is displayed under Payment Information option",
		         					"Payment Amount Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
		       			WebElement PaymentDate=driver.findElement(By.xpath(mbo.PaymentDate));
		       		
		       			String Browser=m1.get("BROWSER").toString();
		       			System.out.println("Browser is:   "+Browser);
		       		if(Browser.equalsIgnoreCase("chrome"))
		       		{
		       			PaymentDate.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),PreviousPaymentDateChrome,Keys.TAB);
		       			repfn.FnUpdateTestStepResHTML("Verify Current Payment Date is entered","Payment date entered: " +PreviousPaymentDateChrome ,"PASS",runManagerInfoObj);
		       			
		       			
		       		}else {
		       			PaymentDate.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),PreviousPaymentDate);
		       			repfn.FnUpdateTestStepResHTML("Verify Current Payment Date is entered","Payment date entered: " +PreviousPaymentDate ,"PASS",runManagerInfoObj);
		       		}
		       		
		       			
		       			if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader,driver)){
		       				WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
		           			cnf.JSClick(PaymentInformationHeader,driver);
		       			}
		       			else{
		       				repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
		       				blnFlag=false;
		       			}
		       			
		       			
		    				
		       			
		       		}
		       		else{
		       			repfn.FnUpdateTestStepResHTML("Verify Payment Date field is displayed under Payment Information option",
		         					"Payment Date field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		       			blnFlag=false;
		       		}
		       		
		       		driver.switchTo().defaultContent();
		       		
		       		
		       	}
		      	
		      	catch (Exception e)

		    		{
		    			repfn.FnUpdateTestStepResHTML("Verify User is able to verify blank Payment date",
		    					"User is not able to verify blank Payment date due to some exception","FAIL",runManagerInfoObj);

		    	      	 blnFlag=false;
		    			System.err.println("Message : "+e.getMessage());
		    			System.err.println("Cause : "+e.getCause());
		    			
		    		}
		    		m1.put("STEPSTATUS", blnFlag);
		    		return blnFlag;
		      	
		        	
		        }
		       public synchronized boolean FnEnterPaymentDate(WebDriver driver, RunManagerInfo runManagerInfoObj){
		       	
		    	   Date d=Calendar.getInstance().getTime();
		    	    
		           SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		           
		           String currentDate=sdf.format(d);
		           
		           String dateArray[]=currentDate.split("/");
		           String year=dateArray[0];
		           String month=dateArray[1];
		           String day=dateArray[2];
		           
		    	   String validPaymentDate = (month)+"/"+day+"/"+year;
		    	   String validPaymentDateChrome = (month)+"/"+day;
		       	String errorMessage = " ";
		       
		       	String errorStatusThree = "Please enter a valid payment date.";
		       	
		       	try{
		       		
		       		driver.switchTo().frame("iFrameResizer0");
		       		
		       		if(cnf.FnExplicitWait("XPATH", mbo.PaymentDate,driver)){
		       			repfn.FnUpdateTestStepResHTML("Verify Payment Date field is displayed under Payment Information option",
		         					"Payment Amount Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
		       			WebElement PaymentDate=driver.findElement(By.xpath(mbo.PaymentDate));
		       		
		       			String Browser=m1.get("BROWSER").toString();
		       			System.out.println("Browser is:   "+Browser);
		       		if(Browser.equalsIgnoreCase("chrome"))
		       		{
		       			PaymentDate.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),validPaymentDateChrome);
		       			repfn.FnUpdateTestStepResHTML("Verify Payment Date is entered","Payment date entered: " +validPaymentDateChrome ,"PASS",runManagerInfoObj);
		       			
		       			
		       		}else {
		       			PaymentDate.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),validPaymentDate);
		       			repfn.FnUpdateTestStepResHTML("Verify Payment Date is entered","Payment date entered: " +validPaymentDate ,"PASS",runManagerInfoObj);
		       		}
		       		
		       			
		       			if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader,driver)){
		       				WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
		           			cnf.JSClick(PaymentInformationHeader,driver);
		       			}
		       			else{
		       				repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
		       				blnFlag=false;
		       			}
		       			
		       				
		       				
		       			
		       			
		       		}
		       		else{
		       			repfn.FnUpdateTestStepResHTML("Verify Payment Date field is displayed under Payment Information option",
		         					"Payment Date field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		       			blnFlag=false;
		       		}
		       		
		       		driver.switchTo().defaultContent();
		       		
		       	
		       	}
		      	
		      	catch (Exception e)

		    		{
		    			repfn.FnUpdateTestStepResHTML("Verify User is able to verify blank Payment date",
		    					"User is not able to verify blank Payment date due to some exception","FAIL",runManagerInfoObj);

		    	      	 blnFlag=false;
		    			System.err.println("Message : "+e.getMessage());
		    			System.err.println("Cause : "+e.getCause());
		    			
		    		}
		    		m1.put("STEPSTATUS", blnFlag);
		    		return blnFlag;
		      	
		        	
		        }
		       public synchronized boolean fnCancelPendingPayment(WebDriver driver, RunManagerInfo runManagerInfoObj) {
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
		  				 boolean blnFlag1 =app.FnMakeFuturePayment(driver,runManagerInfoObj);
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
		  
		      
		     
		  	 public synchronized boolean fnCancelPendingPaymentOne(WebDriver driver, RunManagerInfo runManagerInfoObj) {
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

		  	 public synchronized boolean FnPaymentHistoryInfo(WebDriver driver, RunManagerInfo runManagerInfoObj) {
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
		  	public synchronized boolean FnBillPayOptions_Save(WebDriver driver, RunManagerInfo runManagerInfoObj) {
		  		try
		  		{
		  			if(cnf.FnExplicitWait("XPATH", mbo.onlineBill,driver)){
		  				repfn.FnUpdateTestStepResHTML("Verify \"Online Bill\" radio button is displayed", "\"Online Bill\" radio button is displayed", "PASS",runManagerInfoObj);
		  				WebElement onlineBill=driver.findElement(By.xpath(mbo.onlineBill));
		  				if(onlineBill.isSelected()){
		  					repfn.FnUpdateTestStepResHTML("Verify \"Online Bill\" radio button is pre-selected", "\"Online Bill\" radio button is pre-selected", "PASS",runManagerInfoObj);

		  					if(cnf.FnExplicitWait("XPATH", mbo.paperAndOnlineBill,driver)){
		  						repfn.FnUpdateTestStepResHTML("Verify \"Paper & Online Bill\" radio button is displayed", "\"Paper & Online Bill\" radio button is displayed", "PASS",runManagerInfoObj);
		  						WebElement paperAndOnlineBill=driver.findElement(By.xpath(mbo.paperAndOnlineBill));
		  						if(cnf.JSClick(paperAndOnlineBill,driver)){
		  							repfn.FnUpdateTestStepResHTML("Verify \"Paper & Online Bill\" radio button is selected", "\"Paper & Online Bill\" radio button is selected", "PASS",runManagerInfoObj);

		  							if(cnf.FnExplicitWait("XPATH", mbo.saveButtonForBillPay,driver)){
		  								repfn.FnUpdateTestStepResHTML("Verify Save button is displayed", "Save button is displayed", "PASS",runManagerInfoObj);
		  								WebElement saveButtonForBillPay=driver.findElement(By.xpath(mbo.saveButtonForBillPay));
		  								if(cnf.JSClick(saveButtonForBillPay,driver)){
		  									repfn.FnUpdateTestStepResHTML("Verify Save button is clicked", "Save button is clicked", "PASS",runManagerInfoObj);
		  									Thread.sleep(5000);

		  									if(cnf.FnExplicitWait("XPATH", mbo.returnToBillingButton,driver)){
		  										repfn.FnUpdateTestStepResHTML("Verify \"Return to Billing\" button is displayed", "\"Return to Billing\" button is displayed", "PASS",runManagerInfoObj);
		  										WebElement returnToBillingButton=driver.findElement(By.xpath(mbo.returnToBillingButton));
		  										if(cnf.JSClick(returnToBillingButton,driver)){
		  											repfn.FnUpdateTestStepResHTML("Verify \"Return to Billing\" button is clicked", "\"Return to Billing\" button is clicked", "PASS",runManagerInfoObj);

		  											boolean blnFlag1 = FnBillPayOptionsTab(driver,runManagerInfoObj);
		  											Thread.sleep(5000);
		  											if(blnFlag1){
		  												if(cnf.FnExplicitWait("XPATH", mbo.paperAndOnlineBill,driver)){
		  													WebElement paperAndOnlineBillOne=driver.findElement(By.xpath(mbo.paperAndOnlineBill));
		  													if(paperAndOnlineBillOne.isSelected()){
		  														blnFlag=true;
		  														repfn.FnUpdateTestStepResHTML("Check whether the selection of \"Paper & Online Bill\" in previous step is saved", "Selection of \"Paper & Online Bill\"  in previous step is saved", "PASS",runManagerInfoObj);
		  													}
		  													else{
		  														blnFlag=false;
		  														repfn.FnUpdateTestStepResHTML("Check whether the selection of \"Paper & Online Bill\" in previous step is saved", "Selection of \"Paper & Online Bill\"  in previous step is not saved", "FAIL",runManagerInfoObj);
		  													}
		  												}
		  												else{
		  													repfn.FnUpdateTestStepResHTML("Verify \"Paper & Online Bill\" radio button is displayed", "\"Paper & Online Bill\" radio button is not displayed", "FAIL",runManagerInfoObj);
		  													blnFlag=false;
		  												}
		  											}
		  											else{
		  												repfn.FnUpdateTestStepResHTML("Verify User is navigated to Bill Pay Options page","User is not navigated to Bill Pay Options page","FAIL",runManagerInfoObj);
		  												blnFlag=false;
		  											}
		  										}
		  										else{
		  											repfn.FnUpdateTestStepResHTML("Verify \"Return to Billing\" button is clicked", "\"Return to Billing\" button is not clicked", "FAIL",runManagerInfoObj);
		  											blnFlag=false;
		  										}
		  									}
		  									else{
		  										repfn.FnUpdateTestStepResHTML("Verify \"Return to Billing\" button is displayed", "\"Return to Billing\" button is not displayed", "FAIL",runManagerInfoObj);
		  										blnFlag=false;
		  									}
		  								}
		  								else{
		  									repfn.FnUpdateTestStepResHTML("Verify Save button is clicked", "Save button is not clicked", "FAIL",runManagerInfoObj);
		  									blnFlag=false;
		  								}
		  							}
		  							else{
		  								repfn.FnUpdateTestStepResHTML("Verify Save button is displayed", "Save button is not displayed", "FAIL",runManagerInfoObj);
		  								blnFlag=false;
		  							}
		  						}
		  						else{
		  							repfn.FnUpdateTestStepResHTML("Verify \"Paper & Online Bill\" radio button is selected", "\"Paper & Online Bill\" radio button is not selected", "FAIL",runManagerInfoObj);
		  							blnFlag=false;
		  						}
		  					}
		  					else{
		  						repfn.FnUpdateTestStepResHTML("Verify \"Paper & Online Bill\" radio button is displayed", "\"Paper & Online Bill\" radio button is not displayed", "FAIL",runManagerInfoObj);
		  						blnFlag=false;
		  					}
		  				}
		  				else{
		  					if(cnf.FnExplicitWait("XPATH", mbo.paperAndOnlineBill,driver)){
		  						repfn.FnUpdateTestStepResHTML("Verify \"Paper & Online Bill\" radio button is displayed", "\"Paper & Online Bill\" radio button is displayed", "PASS",runManagerInfoObj);
		  						WebElement paperAndOnlineBill=driver.findElement(By.xpath(mbo.paperAndOnlineBill));
		  						if(paperAndOnlineBill.isSelected()){
		  							repfn.FnUpdateTestStepResHTML("Verify \"Paper & Online Bill\" radio button is pre-selected", "\"Paper & Online Bill\" radio button is pre-selected", "PASS",runManagerInfoObj);

		  							if(cnf.FnExplicitWait("XPATH", mbo.onlineBill,driver)){
		  								repfn.FnUpdateTestStepResHTML("Verify \"Online Bill\" radio button is displayed", "\"Online Bill\" radio button is displayed", "PASS",runManagerInfoObj);
		  								WebElement onlineBillOne=driver.findElement(By.xpath(mbo.onlineBill));
		  								if(cnf.JSClick(onlineBillOne,driver)){
		  									repfn.FnUpdateTestStepResHTML("Verify \"Online Bill\" radio button is selected", "\"Online Bill\" radio button is selected", "PASS",runManagerInfoObj);

		  									if(cnf.FnExplicitWait("XPATH", mbo.saveButtonForBillPay,driver)){
		  										repfn.FnUpdateTestStepResHTML("Verify Save button is displayed", "Save button is displayed", "PASS",runManagerInfoObj);
		  										WebElement saveButtonForBillPay=driver.findElement(By.xpath(mbo.saveButtonForBillPay));
		  										if(cnf.JSClick(onlineBillOne,driver)){
		  											repfn.FnUpdateTestStepResHTML("Verify Save button is clicked", "Save button is clicked", "PASS",runManagerInfoObj);
		  											Thread.sleep(5000);

		  											if(cnf.FnExplicitWait("XPATH", mbo.returnToBillingButton,driver)){
		  												repfn.FnUpdateTestStepResHTML("Verify \"Return to Billing\" button is displayed", "\"Return to Billing\" button is displayed", "PASS",runManagerInfoObj);
		  												WebElement returnToBillingButton=driver.findElement(By.xpath(mbo.returnToBillingButton));
		  												if(cnf.JSClick(returnToBillingButton,driver)){
		  													repfn.FnUpdateTestStepResHTML("Verify \"Return to Billing\" button is clicked", "\"Return to Billing\" button is clicked", "PASS",runManagerInfoObj);

		  													boolean blnFlag1 = FnBillPayOptionsTab(driver,runManagerInfoObj);
		  													Thread.sleep(5000);
		  													if(blnFlag1){
		  														if(cnf.FnExplicitWait("XPATH", mbo.onlineBill,driver)){
		  															WebElement onlineBillTwo=driver.findElement(By.xpath(mbo.onlineBill));
		  															if(onlineBillTwo.isSelected()){
		  																blnFlag=true;
		  																repfn.FnUpdateTestStepResHTML("Check whether the selection of \"Online Bill\" in previous step is saved", "Selection of \"Online Bill\"  in previous step is saved", "PASS",runManagerInfoObj);
		  															}
		  															else{
		  																blnFlag=false;
		  																repfn.FnUpdateTestStepResHTML("Check whether the selection of \"Online Bill\" in previous step is saved", "Selection of \"Online Bill\"  in previous step is not saved", "FAIL",runManagerInfoObj);
		  															}
		  														}
		  														else{
		  															repfn.FnUpdateTestStepResHTML("Verify \"Online Bill\" radio button is displayed", "\"Online Bill\" radio button is not displayed", "FAIL",runManagerInfoObj);
		  															blnFlag=false;
		  														}
		  													}
		  													else{
		  														repfn.FnUpdateTestStepResHTML("Verify User is navigated to Bill Pay Options page","User is not navigated to Bill Pay Options page","FAIL",runManagerInfoObj);
		  														blnFlag=false;
		  													}
		  												}
		  												else{
		  													repfn.FnUpdateTestStepResHTML("Verify \"Return to Billing\" button is clicked", "\"Return to Billing\" button is not clicked", "FAIL",runManagerInfoObj);
		  													blnFlag=false;
		  												}
		  											}
		  											else{
		  												repfn.FnUpdateTestStepResHTML("Verify \"Return to Billing\" button is displayed", "\"Return to Billing\" button is not displayed", "FAIL",runManagerInfoObj);
		  												blnFlag=false;
		  											}
		  										}
		  										else{
		  											repfn.FnUpdateTestStepResHTML("Verify Save button is clicked", "Save button is not clicked", "FAIL",runManagerInfoObj);
		  											blnFlag=false;
		  										}
		  									}
		  									else{
		  										repfn.FnUpdateTestStepResHTML("Verify Save button is displayed", "Save button is not displayed", "FAIL",runManagerInfoObj);
		  										blnFlag=false;
		  									}
		  								}
		  								else{
		  									repfn.FnUpdateTestStepResHTML("Verify \"Online Bill\" radio button is selected", "\"Online Bill\" radio button is not selected", "FAIL",runManagerInfoObj);
		  									blnFlag=false;
		  								}
		  							}
		  							else{
		  								repfn.FnUpdateTestStepResHTML("Verify \"Online Bill\" radio button is displayed", "\"Online Bill\" radio button is not displayed", "FAIL",runManagerInfoObj);
		  								blnFlag=false;
		  							}
		  						}
		  						else{
		  							repfn.FnUpdateTestStepResHTML("Verify \"Paper & Online Bill\" radio button is pre-selected", "\"Paper & Online Bill\" radio button is not pre-selected", "FAIL",runManagerInfoObj);
		  							blnFlag=false;
		  						}
		  					}
		  					else{
		  						repfn.FnUpdateTestStepResHTML("Verify \"Paper & Online Bill\" radio button is displayed", "\"Paper & Online Bill\" radio button is not displayed", "FAIL",runManagerInfoObj);
		  						blnFlag=false;
		  					}
		  				}
		  			}
		  			else{
		  				repfn.FnUpdateTestStepResHTML("Verify \"Online Bill\" radio button is displayed", "\"Online Bill\" radio button is not displayed", "FAIL",runManagerInfoObj);
		  				blnFlag=false;
		  			}
		  		}
		  		catch (Exception e)
		  		{
		  			repfn.FnUpdateTestStepResHTML("Verify if User is able to save the changes made to the bill delivery method", "User is not able to save the changes made to the bill delivery method due to some exception", "FAIL",runManagerInfoObj);
		  			System.err.println("Message : "+e.getMessage());
		  			System.err.println("Cause : "+e.getCause());
		  			blnFlag=false;
		  		}
		  		m1.put("STEPSTATUS", blnFlag);
		  		return blnFlag;
		  	}
		  	public synchronized boolean fnCheckingOrSavingsOneTimePaymentConfirmation(WebDriver driver, RunManagerInfo runManagerInfoObj)
		  	{
		  		try
		  		{
		  			boolean blnFlag1 = app.FnClickOneTime_Checking_SavingsOption(driver,runManagerInfoObj);
		  			boolean blnFlag2 = FnEnterValid_Routing_Account_Number(driver,runManagerInfoObj);
		  			boolean blnFlag3 = app.EditPayAmnt(driver,runManagerInfoObj);
		  			boolean blnFlag4 = EditPayDate(driver,runManagerInfoObj);
		  			boolean blnFlag5 = app.PayBill_PayNow(driver,runManagerInfoObj);
		  			boolean blnFlag6 = app.PayBill_completePayment(driver,runManagerInfoObj);
		  			boolean blnFlag7 = app.PayBill_confirmSuccess(driver,runManagerInfoObj);
		  			boolean blnFlag8 = app.PayBill_ReturnToOverview(driver,runManagerInfoObj);
		  			
		  			driver.navigate().refresh();

		  			if(blnFlag1 && blnFlag2 && blnFlag3 && blnFlag4 && blnFlag5 && blnFlag6 && blnFlag7 && blnFlag8){
		  				repfn.FnUpdateTestStepResHTML("Verify User is able to complete payment sucessfully and navigate back to Overview page","User is able to complete payment sucessfully and navigate back to Overview page","PASS",runManagerInfoObj);
		  				blnFlag=true;
		  			}
		  			else{
		  				repfn.FnUpdateTestStepResHTML("Verify User is able to complete payment sucessfully and navigate back to Overview page","User is not able to complete payment sucessfully and navigate back to Overview page","FAIL",runManagerInfoObj);
		  				blnFlag=false;
		  			}

		  		}
		  		catch (Exception e)

		  		 {		
		  			 blnFlag=false;
		  			 repfn.FnUpdateTestStepResHTML("Verify if user is able to return to Overview page on one time checking/Saving payment", "User is not able to return to Overview page on one time checking/Saving payment due to some exception", "FAIL",runManagerInfoObj);
		  			 System.err.println("Message : "+e.getMessage());
		  			 System.err.println("Cause : "+e.getCause());
		  		 }
		  		
		  		 m1.put("STEPSTATUS", blnFlag);
		  		 return blnFlag;
		  	}
		  	 public synchronized boolean FnValidateRoutingNumber(WebDriver driver, RunManagerInfo runManagerInfoObj){

		    	   String invalidRoutingNumberOne = "1205484789";
		    	   String invalidRoutingNumberTwo = "12054";
		    	   String invalidRoutingNumberThree = "12adb%1&@";
		    	   String errorMessage = "";
		    	   boolean errorStatusOne = false;
		    	   boolean errorStatusTwo = false;
		    	   boolean errorStatusThree = false;

		    	   try{

		    		   driver.switchTo().frame("iFrameResizer0");

		    		   if(cnf.FnExplicitWait("XPATH", mbo.RoutingNumber,driver)){
		    			   repfn.FnUpdateTestStepResHTML("Verify Routing Number field is displayed under Payment Information option",
		    					   "Routing Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
		    			   WebElement RoutingNumber=driver.findElement(By.xpath(mbo.RoutingNumber));
		    			   RoutingNumber.sendKeys(invalidRoutingNumberOne);
		    			   repfn.FnUpdateTestStepResHTML("Verify Routing Number is entered","Routing Number " +invalidRoutingNumberOne + "is entered","PASS",runManagerInfoObj);

		    			   if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader,driver)){
		    				   WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
		    				   cnf.JSClick(PaymentInformationHeader,driver);
		    			   }
		    			   else{
		    				   repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
		    				   blnFlag=false;
		    			   }



		    			   if(cnf.FnExplicitWait("XPATH", mbo.RoutingNumberError,driver)){
		    				   WebElement RoutingNumberError=driver.findElement(By.xpath(mbo.RoutingNumberError));
		    				   errorMessage = RoutingNumberError.getAttribute("textContent");
		    				   repfn.FnUpdateTestStepResHTML("Verify Routing Number Error Message is displayed","Routing Number Error Message: " +errorMessage + "is displayed","PASS",runManagerInfoObj);
		    				   blnFlag=true;
		    				   errorStatusOne = true;

		    			   }
		    			   else{
		    				   repfn.FnUpdateTestStepResHTML("Verify Routing Number Error Message is displayed",
		    						   "Routing Number Error Message is not displayed when this number is entered: " +invalidRoutingNumberOne,"FAIL",runManagerInfoObj);
		    				   blnFlag=false;
		    			   }

		    			   Thread.sleep(2000);

		    			   RoutingNumber.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),invalidRoutingNumberTwo);
		    			   repfn.FnUpdateTestStepResHTML("Verify Routing Number is entered","Routing Number " +invalidRoutingNumberTwo + "is entered","PASS",runManagerInfoObj);

		    			   if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader,driver)){
		    				   WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
		    				   cnf.JSClick(PaymentInformationHeader,driver);
		    			   }
		    			   else{
		    				   repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
		    				   blnFlag=false;
		    			   }

		    			   if(cnf.FnExplicitWait("XPATH", mbo.RoutingNumberError,driver)){
		    				   WebElement RoutingNumberError=driver.findElement(By.xpath(mbo.RoutingNumberError));
		    				   errorMessage = RoutingNumberError.getAttribute("textContent");
		    				   repfn.FnUpdateTestStepResHTML("Verify Routing Number Error Message is displayed","Routing Number Error Message: " +errorMessage + "is displayed","PASS",runManagerInfoObj);
		    				   blnFlag=true;
		    				   errorStatusTwo = true;

		    			   }
		    			   else{
		    				   repfn.FnUpdateTestStepResHTML("Verify Routing Number Error Message is displayed",
		    						   "Routing Number Error Message is not displayed when this number is entered: " +invalidRoutingNumberTwo,"FAIL",runManagerInfoObj);
		    				   blnFlag=false;
		    			   }

		    			   Thread.sleep(2000);

		    			   RoutingNumber.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),invalidRoutingNumberThree);
		    			   repfn.FnUpdateTestStepResHTML("Verify Routing Number is entered","Routing Number " +invalidRoutingNumberThree + "is entered","PASS",runManagerInfoObj);

		    			   if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader,driver)){
		    				   WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
		    				   cnf.JSClick(PaymentInformationHeader,driver);
		    			   }
		    			   else{
		    				   repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
		    				   blnFlag=false;
		    			   }

		    			   if(cnf.FnExplicitWait("XPATH", mbo.RoutingNumberError,driver)){
		    				   WebElement RoutingNumberError=driver.findElement(By.xpath(mbo.RoutingNumberError));
		    				   errorMessage = RoutingNumberError.getAttribute("textContent");
		    				   repfn.FnUpdateTestStepResHTML("Verify Routing Number Error Message is displayed","Routing Number Error Message is displayed:  " +errorMessage,"PASS",runManagerInfoObj);
		    				   blnFlag=true;
		    				   errorStatusThree = true;

		    			   }
		    			   else{
		    				   repfn.FnUpdateTestStepResHTML("Verify Routing Number Error Message is displayed",
		    						   "Routing Number Error Message is not displayed when this number is entered: " +invalidRoutingNumberThree,"FAIL",runManagerInfoObj);
		    				   blnFlag=false;
		    			   }

		    			   if(errorStatusOne && errorStatusTwo && errorStatusThree){
		    				   repfn.FnUpdateTestStepResHTML("Verify Routing Number Error Message is displayed for all the three invalid Routing numbers",
		    						   "Routing Number Error Message is displayed for all the three invalid Routing numbers","PASS",runManagerInfoObj);
		    				   blnFlag=true;
		    			   }
		    			   else{
		    				   repfn.FnUpdateTestStepResHTML("Verify Routing Number Error Message is displayed for all the three invalid Routing numbers",
		    						   "Routing Number Error Message is not displayed for all the three invalid Routing numbers","FAIL",runManagerInfoObj);
		    				   blnFlag=false;
		    			   }

		    		   }
		    		   else{
		    			   repfn.FnUpdateTestStepResHTML("Verify Routing Number field is displayed under Payment Information option",
		    					   "Routing Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		    			   blnFlag=false;
		    		   }

		    		   driver.switchTo().defaultContent();


		    	   }

		    	   catch (Exception e)

		    	   {
		    		   repfn.FnUpdateTestStepResHTML("Verify User is able to verify invalid Routing Number entered",
		    				   "User is not able to verify invalid Routing Number entered due to some exception","FAIL",runManagerInfoObj);

		    		   blnFlag=false;
		    		   System.err.println("Message : "+e.getMessage());
		    		   System.err.println("Cause : "+e.getCause());

		    	   }
		    	   m1.put("STEPSTATUS", blnFlag);
		    	   return blnFlag;

		       }
		  	  public synchronized boolean FnValidateBankAccountNumber(WebDriver driver, RunManagerInfo runManagerInfoObj){
		          	
		          	String invalidBankAccountNumber = "011a27!!56";
		          	String errorMessage = "";
		          	boolean errorStatusOne = false;
		          	
		          	try{
		          		
		          		driver.switchTo().frame("iFrameResizer0");
		          		
		          		if(cnf.FnExplicitWait("XPATH", mbo.BankAccountNumber,driver)){
		          			repfn.FnUpdateTestStepResHTML("Verify Bank Account Number field is displayed under Payment Information option",
		            					"Bank Account Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
		          			WebElement BankAccountNumber=driver.findElement(By.xpath(mbo.BankAccountNumber));
		          			BankAccountNumber.sendKeys(invalidBankAccountNumber);
		          			repfn.FnUpdateTestStepResHTML("Verify Bank Account Number is entered","Bank Account Number " +invalidBankAccountNumber + "is entered","PASS",runManagerInfoObj);
		          			
		          			if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader,driver)){
		          				WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
		              			cnf.JSClick(PaymentInformationHeader,driver);
		          			}
		          			else{
		          				repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
		          				blnFlag=false;
		          			}
		          				
		          			
		          			
		          			if(cnf.FnExplicitWait("XPATH", mbo.BankAccountNumberError,driver)){
		          				WebElement BankAccountNumberError=driver.findElement(By.xpath(mbo.BankAccountNumberError));
		          				errorMessage = BankAccountNumberError.getAttribute("textContent");
		          				repfn.FnUpdateTestStepResHTML("Verify Bank Account Number Error Message is displayed","Bank Account Number Error Message is displayed:  " +errorMessage,"PASS",runManagerInfoObj);
		          				blnFlag=true;
		          				errorStatusOne = true;
		          				
		          			}
		          			else{
		          				repfn.FnUpdateTestStepResHTML("Verify Bank Account Number Error Message is displayed",
		          						"Bank Account Number Error Message is not displayed when this number is entered: " +invalidBankAccountNumber,"FAIL",runManagerInfoObj);
		          				blnFlag=false;
		          			}
		          			
		          			
		          			
		          			
		          			if(errorStatusOne){
		          				repfn.FnUpdateTestStepResHTML("Verify Bank Account Number Error Message is displayed for invalid Bank Account number",
		          						"Bank Account Number Error Message is displayed for invalid Bank Account number","PASS",runManagerInfoObj);
		          				blnFlag=true;
		          			}
		          			else{
		          				repfn.FnUpdateTestStepResHTML("Verify Bank Account Number Error Message is displayed for invalid Bank Account number",
		          						"Bank Account Number Error Message is not displayed for invalid Bank Account number","FAIL",runManagerInfoObj);
		          				blnFlag=false;
		          			}
		          			
		          		}
		          		else{
		          			repfn.FnUpdateTestStepResHTML("Verify Bank Account Number field is displayed under Payment Information option",
		            					"Bank Account Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		          			blnFlag=false;
		          		}
		          		
		          		driver.switchTo().defaultContent();
		          		
		          	
		          	}
		          	
		          	catch (Exception e)

		        		{
		        			repfn.FnUpdateTestStepResHTML("Verify User is able to verify invalid Account Number entered",
		        					"User is not able to verify invalid Account Number entered due to some exception","FAIL",runManagerInfoObj);

		        	      	 blnFlag=false;
		        			System.err.println("Message : "+e.getMessage());
		        			System.err.println("Cause : "+e.getCause());
		        			
		        		}
		        		m1.put("STEPSTATUS", blnFlag);
		        		return blnFlag;
		          	
		          }
		  	  public synchronized boolean FnValidatePaymentAmountField(WebDriver driver, RunManagerInfo runManagerInfoObj){
		         	
		    	   String invalidPaymentAmountOne = "1a%1@";
		          	String invalidPaymentAmountTwo = "0";
		          	String invalidPaymentAmountThree = "30000";
		          	String errorMessage = "";
		          	boolean errorStatusOne = false;
		          	boolean errorStatusTwo = false;
		          	boolean errorStatusThree = false;
		          	
		          	try{
		          		
		          		driver.switchTo().frame("iFrameResizer0");
		          		
		          		if(cnf.FnExplicitWait("XPATH", mbo.PaymentAmount,driver)){
		          			repfn.FnUpdateTestStepResHTML("Verify Payment Amount field is displayed under Payment Information option",
		            					"Payment Amount Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
		          			WebElement PaymentAmount=driver.findElement(By.xpath(mbo.PaymentAmount));
		          			PaymentAmount.sendKeys(invalidPaymentAmountOne);
		          			repfn.FnUpdateTestStepResHTML("Verify Payment Amount is entered","Payment Amount: " +invalidPaymentAmountOne + "is entered","PASS",runManagerInfoObj);
		          			
		          			if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader,driver)){
		          				WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
		              			cnf.JSClick(PaymentInformationHeader,driver);
		          			}
		          			else{
		          				repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
		          				blnFlag=false;
		          			}
		          				
		          			
		          			
		          			if(cnf.FnExplicitWait("XPATH", mbo.PaymentAmountError,driver)){
		          				WebElement PaymentAmountError=driver.findElement(By.xpath(mbo.PaymentAmountError));
		          				errorMessage = PaymentAmountError.getAttribute("textContent");
		          				repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed","Payment Amount Error Message is displayed:  " +errorMessage,"PASS",runManagerInfoObj);
		          				blnFlag=true;
		          				errorStatusOne = true;
		          				
		          			}
		          			else{
		          				repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed",
		          						"Payment Amount Error Message is not displayed when this number is entered: " +invalidPaymentAmountOne,"FAIL",runManagerInfoObj);
		          				blnFlag=false;
		          			}
		          			
		          			Thread.sleep(2000);
		          			
		          			PaymentAmount.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),invalidPaymentAmountTwo);
		          			repfn.FnUpdateTestStepResHTML("Verify Payment Amount is entered","Payment Amount:  " +invalidPaymentAmountTwo + "is entered","PASS",runManagerInfoObj);
		          			
		          			if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader,driver)){
		          				WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
		              			cnf.JSClick(PaymentInformationHeader,driver);
		          			}
		          			else{
		          				repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
		          				blnFlag=false;
		          			}
		          			
		          			if(cnf.FnExplicitWait("XPATH", mbo.PaymentAmountError,driver)){
		          				WebElement PaymentAmountError=driver.findElement(By.xpath(mbo.PaymentAmountError));
		          				errorMessage = PaymentAmountError.getAttribute("textContent");
		          				repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed","Payment Amount Error Message is displayed:  " +errorMessage,"PASS",runManagerInfoObj);
		          				blnFlag=true;
		          				errorStatusTwo = true;
		          				
		          			}
		          			else{
		          				repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed",
		          						"Payment Amount Error Message is not displayed when this number is entered: " +invalidPaymentAmountTwo,"FAIL",runManagerInfoObj);
		          				blnFlag=false;
		          			}
		          			
		          			Thread.sleep(2000);
		          			
		          			PaymentAmount.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),invalidPaymentAmountThree);
		          			repfn.FnUpdateTestStepResHTML("Verify Payment Amount is entered","Payment Amount: " +invalidPaymentAmountThree + "is entered","PASS",runManagerInfoObj);
		          			
		          			if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader,driver)){
		          				WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
		              			cnf.JSClick(PaymentInformationHeader,driver);
		          			}
		          			else{
		          				repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
		          				blnFlag=false;
		          			}
		          			
		          			if(cnf.FnExplicitWait("XPATH", mbo.PaymentAmountError,driver)){
		          				WebElement PaymentAmountError=driver.findElement(By.xpath(mbo.PaymentAmountError));
		          				errorMessage = PaymentAmountError.getAttribute("textContent");
		          				repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed","Payment Amount Error Message is displayed:  " +errorMessage,"PASS",runManagerInfoObj);
		          				blnFlag=true;
		          				errorStatusThree = true;
		          				
		          			}
		          			else{
		          				repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed",
		          						"Payment Amount Error Message is not displayed when this number is entered: " +invalidPaymentAmountThree,"FAIL",runManagerInfoObj);
		          				blnFlag=false;
		          			}
		          			
		          			if(errorStatusOne && errorStatusTwo && errorStatusThree){
		          				repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed for all the three invalid Payment Amounts entered",
		          						"Payment Amount Error Message is displayed for all the three invalid Payment Amounts entered","PASS",runManagerInfoObj);
		          				blnFlag=true;
		          			}
		          			else{
		          				repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed for all the three invalid Payment Amounts entered",
		          						"Payment Amount Error Message is not displayed for all the three invalid Payment Amounts entered","FAIL",runManagerInfoObj);
		          				blnFlag=false;
		          			}
		          			
		          		}
		          		else{
		          			repfn.FnUpdateTestStepResHTML("Verify Payment Amount field is displayed under Payment Information option",
		            					"Payment Amount field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		          			blnFlag=false;
		          		}
		          		
		          		driver.switchTo().defaultContent();
		          		
		          	
		          	}
		         	
		         	catch (Exception e)

		       		{
		       			repfn.FnUpdateTestStepResHTML("Verify User is able to verify invalid Payment Amount entered",
		       					"User is not able to verify invalid Payment Amount entered due to some exception","FAIL",runManagerInfoObj);

		       	      	 blnFlag=false;
		       			System.err.println("Message : "+e.getMessage());
		       			System.err.println("Cause : "+e.getCause());
		       			
		       		}
		       		m1.put("STEPSTATUS", blnFlag);
		       		return blnFlag;
		         	
		         }
		  	  public synchronized boolean FnVerifyClickSupportLink(WebDriver driver, RunManagerInfo runManagerInfoObj){
		    	  
		    	  try{
		    		  
		    		  driver.switchTo().frame("iFrameResizer0");
		    		  
		 			 if(cnf.FnExplicitWait("XPATH", mbo.SupportLinkPayBill,driver)){
		 				 repfn.FnUpdateTestStepResHTML("Verify Support link is displayed on Pay Bill page", "Support link is displayed on Pay Bill page","PASS",runManagerInfoObj);
		 				 //String oldTab = driver.getWindowHandle();
		 				 WebElement Support_Link=driver.findElement(By.xpath(mbo.SupportLinkPayBill));
		 				 cnf.ScrollToView(Support_Link,driver);
		 				 ArrayList<String> oldTab = new ArrayList<String>(driver.getWindowHandles());
		 				 cnf.ScrollToView(Support_Link,driver);
		 				 cnf.JSClick(Support_Link,driver);
		 				 repfn.FnUpdateTestStepResHTML("Verify Support Link is clicked", "Support Link is clicked","PASS",runManagerInfoObj);
		 				 Thread.sleep(5000);

		 				 ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		 				 //System.out.println(newTab.size());

		 				 if(newTab.size() == oldTab.size()){
		 					 repfn.FnUpdateTestStepResHTML("Verify Support Page is opened in same tab", "Support Page is opened in same tab","PASS",runManagerInfoObj);
		 					 blnFlag=true;
		 				 }
		 				 else{
		 					 repfn.FnUpdateTestStepResHTML("Verify Support Page is opened in same tab", "Support Page is opened in new tab","FAIL",runManagerInfoObj);
		 					 blnFlag=false;
		 				 }

		 				 
		 				 if(cnf.FnExplicitWait("XPATH", mbo.SupportPageVerification,driver)){
		 					 repfn.FnUpdateTestStepResHTML("Verify User is on Support Page", "User is on Support Page","PASS",runManagerInfoObj);
		 					 blnFlag=true;
		 				 }
		 				 else{
		 					 repfn.FnUpdateTestStepResHTML("Verify User is on Support Page", "User is not on Support Page","FAIL",runManagerInfoObj);
		 					 blnFlag=false;
		 				 }


		 			 }
		 			 else{
		 				 repfn.FnUpdateTestStepResHTML("Verify Support link is displayed", "Support link is not displayed","FAIL",runManagerInfoObj);
		 				 blnFlag=false;
		 			 }
		 			 
		 			 
		 			driver.switchTo().defaultContent();
		    		  
		    	  }
		    	  
		    	  catch (Exception e)

		   		{
		   			repfn.FnUpdateTestStepResHTML("Verify User is able to verify Support Link on Pay Bill page",
		   					"User is not able to verify Support Link on Pay Bill page due to some exception","FAIL",runManagerInfoObj);

		   	      	 blnFlag=false;
		   			System.err.println("Message : "+e.getMessage());
		   			System.err.println("Cause : "+e.getCause());
		   			
		   		}
		   		m1.put("STEPSTATUS", blnFlag);
		   		return blnFlag;
		    	  
		    	  
		      }
		  	  public synchronized boolean FnValidateInvalidRouting_ValidAccount(WebDriver driver, RunManagerInfo runManagerInfoObj){
		    	  
		    	  String invalidRoutingNumber = "";
		   	   	  String accountNumber = "";
		   	   	  String errorMessage = "";
		    	  
		    	  try{
		    		  
		    		  driver.switchTo().frame("iFrameResizer0");
		         		
		         		if(cnf.FnExplicitWait("XPATH", mbo.RoutingNumber,driver)){
		         			repfn.FnUpdateTestStepResHTML("Verify Routing Number field is displayed under Payment Information option",
		           					"Routing Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
		         			WebElement RoutingNumber=driver.findElement(By.xpath(mbo.RoutingNumber));
		         			invalidRoutingNumber=m1.get("InvalidRouting").toString();
		         			RoutingNumber.sendKeys(invalidRoutingNumber);
		         			repfn.FnUpdateTestStepResHTML("Verify Routing Number is entered","Routing Number " +invalidRoutingNumber + "is entered","PASS",runManagerInfoObj);
		         			blnFlag=true;
		         		}
		         		else{
		         			repfn.FnUpdateTestStepResHTML("Verify Routing Number field is displayed under Payment Information option",
		           					"Routing Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		         			blnFlag=false;
		         		}
		         		
		         		
		         		if(cnf.FnExplicitWait("XPATH", mbo.BankAccountNumber,driver)){
		          			repfn.FnUpdateTestStepResHTML("Verify Bank Account Number field is displayed under Payment Information option",
		            					"Bank Account Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
		          			WebElement BankAccountNumber=driver.findElement(By.xpath(mbo.BankAccountNumber));
		          			accountNumber=m1.get("BankAccountNumber").toString();
		          			BankAccountNumber.sendKeys(accountNumber);
		          			repfn.FnUpdateTestStepResHTML("Verify Bank Account Number is entered","Bank Account Number " +accountNumber + "is entered","PASS",runManagerInfoObj);
		          			blnFlag=true;
		         		}
		         		else{
		         			repfn.FnUpdateTestStepResHTML("Verify Bank Account Number field is displayed under Payment Information option",
		        					"Bank Account Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		         			blnFlag=false;
		         		}
		         		
		         		
		         		if(cnf.FnExplicitWait("XPATH", mbo.RoutingNumberError,driver)){
		       				WebElement RoutingNumberError=driver.findElement(By.xpath(mbo.RoutingNumberError));
		       				errorMessage = RoutingNumberError.getAttribute("textContent");
		       				repfn.FnUpdateTestStepResHTML("Verify Routing Number Error Message is displayed","Routing Number Error Message: " +errorMessage + "is displayed","PASS",runManagerInfoObj);
		       				blnFlag=true;      				
		       			}
		       			else{
		       				repfn.FnUpdateTestStepResHTML("Verify Routing Number Error Message is displayed",
		       						"Routing Number Error Message is not displayed when this number is entered: " +invalidRoutingNumber,"FAIL",runManagerInfoObj);
		       				blnFlag=false;
		       			}
		         		
		         		driver.switchTo().defaultContent();
		         		
		    	  }
		    	  
		    	  catch (Exception e)

		     		{
		     			repfn.FnUpdateTestStepResHTML("Verify User is able to get the error message on entering invalid routing number",
		     					"User is not able to get the error message on entering invalid routing number due to some exception","FAIL",runManagerInfoObj);

		     	      	 blnFlag=false;
		     			System.err.println("Message : "+e.getMessage());
		     			System.err.println("Cause : "+e.getCause());
		     			
		     		}
		     		m1.put("STEPSTATUS", blnFlag);
		     		return blnFlag;
		      }
		  	 public synchronized boolean FnValidatePaymentAmountLimit(WebDriver driver, RunManagerInfo runManagerInfoObj){
		        	
		    	  
		          	String invalidPaymentAmountThree = "30000";
		          	String errorMessage = "";
		          
		          	boolean errorStatusThree = false;
		          	
		          	try{
		          		
		          		driver.switchTo().frame("iFrameResizer0");
		          		
		          		if(cnf.FnExplicitWait("XPATH", mbo.PaymentAmount,driver)){
		          			repfn.FnUpdateTestStepResHTML("Verify Payment Amount field is displayed under Payment Information option",
		            					"Payment Amount Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
		          			WebElement PaymentAmount=driver.findElement(By.xpath(mbo.PaymentAmount));
		          		
		          			
		          			PaymentAmount.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),invalidPaymentAmountThree);
		          			repfn.FnUpdateTestStepResHTML("Verify Payment Amount is entered","Payment Amount entered:$ " +invalidPaymentAmountThree ,"PASS",runManagerInfoObj);
		          			
		          			if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader,driver)){
		          				WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
		              			cnf.JSClick(PaymentInformationHeader,driver);
		          			}
		          			else{
		          				repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
		          				blnFlag=false;
		          			}
		          			
		          			if(cnf.FnExplicitWait("XPATH", mbo.PaymentAmountError,driver)){
		          				WebElement PaymentAmountError=driver.findElement(By.xpath(mbo.PaymentAmountError));
		          				errorMessage = PaymentAmountError.getAttribute("textContent");
		          				repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed","Payment Amount Error Message is displayed:  " +errorMessage,"PASS",runManagerInfoObj);
		          				blnFlag=true;
		          				errorStatusThree = true;
		          				
		          			}
		          			else{
		          				repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed",
		          						"Payment Amount Error Message is not displayed when this number is entered: " +invalidPaymentAmountThree,"FAIL",runManagerInfoObj);
		          				blnFlag=false;
		          			}
		          			
		          			
		          		}
		          		else{
		          			repfn.FnUpdateTestStepResHTML("Verify Payment Amount field is displayed under Payment Information option",
		            					"Payment Amount field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		          			blnFlag=false;
		          		}
		          		
		          		driver.switchTo().defaultContent();
		          		
		          	
		          	}
		         	
		         	catch (Exception e)

		       		{
		       			repfn.FnUpdateTestStepResHTML("Verify User is able to verify invalid Payment Amount entered",
		       					"User is not able to verify invalid Payment Amount entered due to some exception","FAIL",runManagerInfoObj);

		       	      	 blnFlag=false;
		       			System.err.println("Message : "+e.getMessage());
		       			System.err.println("Cause : "+e.getCause());
		       			
		       		}
		       		m1.put("STEPSTATUS", blnFlag);
		       		return blnFlag;
		         	
		         }
		  	public synchronized boolean fnCreditOrDebitErrorMessageInvalidCard(WebDriver driver, RunManagerInfo runManagerInfoObj) {
		  		
		  		String invalidCardNumber = "";
		  		try
		  		{
		  			driver.switchTo().frame("iFrameResizer0");
		  			if(cnf.FnExplicitWait("XPATH", mbo.billingCardNumber,driver))
		  			{
		  				repfn.FnUpdateTestStepResHTML("Verify if Card number field to enter card number is present","Card number field to enter card number is present","PASS",runManagerInfoObj);
		  				WebElement billingCardNumber=driver.findElement(By.xpath(mbo.billingCardNumber));
		  				invalidCardNumber = m1.get("InvalidCardNum").toString();
		  				billingCardNumber.sendKeys(invalidCardNumber,Keys.TAB);
		  				repfn.FnUpdateTestStepResHTML("Verify if User has entered the card number","User has entered the card number: "+invalidCardNumber,"PASS",runManagerInfoObj);
		  				
		  	/*  			if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader)){
		  	  				WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
		  	      			cnf.JSClick(PaymentInformationHeader);
		  	  			}
		  	  			else{
		  	  				repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
		  	  				blnFlag=false;
		  	  			}*/
		  				
		  				if(cnf.FnExplicitWait("XPATH", mbo.errorMessageForInvalidCard,driver))
		  				{
		  					WebElement errorMessageForInvalidCard=driver.findElement(By.xpath(mbo.errorMessageForInvalidCard));
		  					repfn.FnUpdateTestStepResHTML("Verify if Error message is displayed for incorrect card number","Error message is displayed for incorrect card number: "+errorMessageForInvalidCard.getText(),"PASS",runManagerInfoObj);
		  					blnFlag=true;
		  				}
		  				else{
		  					blnFlag=false;
		  					repfn.FnUpdateTestStepResHTML("Verify if Error message is displayed for incorrect card number","Error message is not displayed for incorrect card number","FAIL",runManagerInfoObj);
		  				}
		  			}
		  			else
		  			{
		  				blnFlag=false;
		  				repfn.FnUpdateTestStepResHTML("Verify if Card number field to enter card number is present","Card number field to enter card number is not present","FAIL",runManagerInfoObj);
		  			}
		  			
		  			driver.switchTo().defaultContent();
		  		}
		  		 catch (Exception e)

		  		 {		
		  			 blnFlag=false;
		  			 System.err.println("Message : "+e.getMessage());
		  			 System.err.println("Cause : "+e.getCause());
		  			 repfn.FnUpdateTestStepResHTML("Verify if Error message is displayed for incorrect card number","Error message is not displayed for incorrect card number due to some exception","FAIL",runManagerInfoObj);
		  		 }
		  		 m1.put("STEPSTATUS", blnFlag);
		  		 return blnFlag;
		  	}

		  	public synchronized boolean fnCreditOrDebitErrorMessageCardValidation(WebDriver driver, RunManagerInfo runManagerInfoObj) {
		  		
		  		String invalidCardNumber = "";
		  		try
		  		{
		  			driver.switchTo().frame("iFrameResizer0");
		  			if(cnf.FnExplicitWait("XPATH", mbo.billingCardNumber,driver))
		  			{
		  				repfn.FnUpdateTestStepResHTML("Verify if Card number field to enter card number is present","Card number field to enter card number is present","PASS",runManagerInfoObj);
		  				WebElement billingCardNumber=driver.findElement(By.xpath(mbo.billingCardNumber));
		  				invalidCardNumber = m1.get("InvalidCardNum").toString();
		  				billingCardNumber.sendKeys(invalidCardNumber);
		  				repfn.FnUpdateTestStepResHTML("Verify if User has entered the card number","User has entered the card number: "+invalidCardNumber,"PASS",runManagerInfoObj);
		  				
		  	  			if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader,driver)){
		  	  				WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
		  	      			cnf.JSClick(PaymentInformationHeader,driver);
		  	  			}
		  	  			else{
		  	  				repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
		  	  				blnFlag=false;
		  	  			}
		  				
		  				if(cnf.FnExplicitWait("XPATH", mbo.errorMessageForInvalidCard,driver))
		  				{
		  					WebElement errorMessageForInvalidCard=driver.findElement(By.xpath(mbo.errorMessageForInvalidCard));
		  					repfn.FnUpdateTestStepResHTML("Verify if Error message is displayed for incorrect card number","Error message is displayed for incorrect card number: "+errorMessageForInvalidCard.getText(),"PASS",runManagerInfoObj);
		  					blnFlag=true;
		  				}
		  				else{
		  					blnFlag=false;
		  					repfn.FnUpdateTestStepResHTML("Verify if Error message is displayed for incorrect card number","Error message is not displayed for incorrect card number","FAIL",runManagerInfoObj);
		  				}
		  			}
		  			else
		  			{
		  				blnFlag=false;
		  				repfn.FnUpdateTestStepResHTML("Verify if Card number field to enter card number is present","Card number field to enter card number is not present","FAIL",runManagerInfoObj);
		  			}
		  			
		  			driver.switchTo().defaultContent();
		  		}
		  		 catch (Exception e)

		  		 {		
		  			 blnFlag=false;
		  			 System.err.println("Message : "+e.getMessage());
		  			 System.err.println("Cause : "+e.getCause());
		  			 repfn.FnUpdateTestStepResHTML("Verify if Error message is displayed for incorrect card number","Error message is not displayed for incorrect card number due to some exception","FAIL",runManagerInfoObj);
		  		 }
		  		 m1.put("STEPSTATUS", blnFlag);
		  		 return blnFlag;
		  	}
		  	 public synchronized boolean FnBlank_Routing_Number(WebDriver driver, RunManagerInfo runManagerInfoObj){
		         	
		         	String validRoutingNumber = "   ";
		         	String error_msg_routing="";
		         
		        	String errorStatusRouting="Please enter a valid routing number.";
		         	try{
		         		
		         		driver.switchTo().frame("iFrameResizer0");
		         		
		         		if(cnf.FnExplicitWait("XPATH", mbo.RoutingNumber,driver)){
		         			repfn.FnUpdateTestStepResHTML("Verify Routing Number field is displayed under Payment Information option",
		           					"Routing Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
		         			WebElement RoutingNumber=driver.findElement(By.xpath(mbo.RoutingNumber));
		         			RoutingNumber.sendKeys(validRoutingNumber,Keys.TAB);
		         			repfn.FnUpdateTestStepResHTML("Verify Routing Number is entered blank","Routing Number entered :" +validRoutingNumber,"PASS",runManagerInfoObj);
		         			
		         			if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader,driver)){
		         				WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
		             			cnf.JSClick(PaymentInformationHeader,driver);
		         			}
		         			else{
		         				repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
		         				blnFlag=false;
		         			}
		         			Thread.sleep(2000);
		         			if(cnf.FnExplicitWait("XPATH", mbo.RoutingNumberError,driver)){
		           				WebElement RoutingNumberError=driver.findElement(By.xpath(mbo.RoutingNumberError));
		           				error_msg_routing = RoutingNumberError.getAttribute("textContent");
		           				repfn.FnUpdateTestStepResHTML("Verify Routing Number Error Message is displayed and the Routing field should get higlighted indicating the error.","The Routing field getting higlighted by indicating Error Message: " +error_msg_routing,"PASS",runManagerInfoObj);
		           				if(errorStatusRouting.equalsIgnoreCase(error_msg_routing)){
		              				repfn.FnUpdateTestStepResHTML("Verify Please enter a valid routing number error message is displayed when Blank field for routing number",
		              						"Please enter a valid routing number error message is displayed","PASS",runManagerInfoObj);
		              						blnFlag=true;
		              			}
		              			else{
		              				repfn.FnUpdateTestStepResHTML("Verify Please enter a valid routing number error message is displayed when Blank field for routing number",
		              						"Please enter a valid routing number error message is not displayed","FAIL",runManagerInfoObj);
		              				blnFlag=false;
		              			}
		           				
		           				
		           			}
		           			else{
		           				repfn.FnUpdateTestStepResHTML("Verify Routing Number Error Message is displayed nd the Routing field should get higlighted indicating the error.",
		           						" Routing field not get higlighted as Routing Number Error Message is not displayed ","FAIL",runManagerInfoObj);
		           				blnFlag=false;
		           			}
		         				
		         			
		         		}
		         		else{
		         			repfn.FnUpdateTestStepResHTML("Verify Routing Number field is displayed under Payment Information option",
		           					"Routing Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		         			blnFlag=false;
		         		}
		         		
		         		driver.switchTo().defaultContent();
		                 
		              
		         	
		         	}
		         	
		         	catch (Exception e)

		       		{
		       			repfn.FnUpdateTestStepResHTML("Verify User is able to verify blank Routing Number",
		       					"User is not able to verify blank Routing Number due to some exception","FAIL",runManagerInfoObj);

		       	      	 blnFlag=false;
		       			System.err.println("Message : "+e.getMessage());
		       			System.err.println("Cause : "+e.getCause());
		       			
		       		}
		       		m1.put("STEPSTATUS", blnFlag);
		       		return blnFlag;
		         	
		         }
		  	  public synchronized boolean FnBlank_Account_Number(WebDriver driver, RunManagerInfo runManagerInfoObj){
		        	
		        	
		        	String Blank_BankAccountNumber = " ";
		        	String error_msg_bankAccount=" ";
		        	String errorStatusOne="Please enter a valid account number.";
		      
		        	try{
		        		
		        		driver.switchTo().frame("iFrameResizer0");
		        		
		                		
		        		if(cnf.FnExplicitWait("XPATH", mbo.BankAccountNumber,driver)){
		         			repfn.FnUpdateTestStepResHTML("Verify Bank Account Number field is displayed under Payment Information option",
		           					"Bank Account Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
		         			WebElement BankAccountNumber=driver.findElement(By.xpath(mbo.BankAccountNumber));
		         			BankAccountNumber.sendKeys(Blank_BankAccountNumber,Keys.TAB);
		         			repfn.FnUpdateTestStepResHTML("Verify Bank Account Number is entered blank","Bank Account Number: " +Blank_BankAccountNumber + "is entered","PASS",runManagerInfoObj);
		         			
		         			if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader,driver)){
		         				WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
		             			cnf.JSClick(PaymentInformationHeader,driver);
		         			}
		         			else{
		         				repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
		         				blnFlag=false;
		         			}
		         				
		         			
		         			Thread.sleep(2000);
		         			if(cnf.FnExplicitWait("XPATH", mbo.BankAccountNumberError,driver)){
		         				WebElement BankAccountNumberError=driver.findElement(By.xpath(mbo.BankAccountNumberError));
		         				error_msg_bankAccount = BankAccountNumberError.getAttribute("textContent");
		         				repfn.FnUpdateTestStepResHTML("Verify Bank Account Number field should get higlighted and Error Message is displayed when field left blank"," Bank Account Number field getting higlighted and Error Message is displayed:  " +error_msg_bankAccount,"PASS",runManagerInfoObj);
		         			
		         				if(errorStatusOne.equalsIgnoreCase(error_msg_bankAccount)){
		             				repfn.FnUpdateTestStepResHTML("Verify Please enter a valid account number error message is displayed when Blank field for Bank Account number",
		             						"Please enter a valid account number error message is displayed","PASS",runManagerInfoObj);
		             				blnFlag=true;
		             			}
		             			else{
		             				repfn.FnUpdateTestStepResHTML("Verify Please enter a valid account number error message is displayed when Blank field for Bank Account number",
		             						"Please enter a valid account number error message is not displayed","FAIL",runManagerInfoObj);
		             				blnFlag=false;
		             			}
		         				
		         				
		         			}
		         			else{
		         				repfn.FnUpdateTestStepResHTML("Verify Bank Account Number field should get higlighted and Error Message is displayed when field left blank",
		         						"Bank Account Number Error Message is not displayed when field left blank","FAIL",runManagerInfoObj);
		         				blnFlag=false;
		         			}
		         			
		         			
		         			
		         		}
		         		else{
		         			repfn.FnUpdateTestStepResHTML("Verify Bank Account Number field is displayed under Payment Information option",
		           					"Bank Account Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		         			blnFlag=false;
		         		}
		         		
		                		driver.switchTo().defaultContent();
		                		
		               
		        		
		        	
		        	}
		        	
		        	catch (Exception e)

		      		{
		      			repfn.FnUpdateTestStepResHTML("Verify User is able to verify blank account Number ",
		      					"User is not able to verify blank account Number due to some exception","FAIL",runManagerInfoObj);

		      	      	 blnFlag=false;
		      			System.err.println("Message : "+e.getMessage());
		      			System.err.println("Cause : "+e.getCause());
		      			
		      		}
		      		m1.put("STEPSTATUS", blnFlag);
		      		return blnFlag;
		        	
		        }
		  	 public synchronized boolean FnBlank_PaymentAmount(WebDriver driver, RunManagerInfo runManagerInfoObj){
		        	
		     	  
		         	String invalidPaymentAmountThree = " ";
		         	String errorMessage = " ";
		         
		         	String errorStatusThree = "Please enter an amount between $1 and $25000.";
		         	
		         	try{
		         		
		         		driver.switchTo().frame("iFrameResizer0");
		         		
		         		if(cnf.FnExplicitWait("XPATH", mbo.PaymentAmount,driver)){
		         			repfn.FnUpdateTestStepResHTML("Verify Payment Amount field is displayed under Payment Information option",
		           					"Payment Amount Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
		         			WebElement PaymentAmount=driver.findElement(By.xpath(mbo.PaymentAmount));
		         		
		         			
		         			PaymentAmount.sendKeys(invalidPaymentAmountThree,Keys.TAB);
		         			repfn.FnUpdateTestStepResHTML("Verify Payment Amount is entered","Payment Amount entered:$ " +invalidPaymentAmountThree ,"PASS",runManagerInfoObj);
		         			
		         			if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader,driver)){
		         				WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
		             			cnf.JSClick(PaymentInformationHeader,driver);
		         			}
		         			else{
		         				repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
		         				blnFlag=false;
		         			}
		         			
		         			if(cnf.FnExplicitWait("XPATH", mbo.PaymentAmountError,driver)){
		         				WebElement PaymentAmountError=driver.findElement(By.xpath(mbo.PaymentAmountError));
		         				errorMessage = PaymentAmountError.getAttribute("textContent");
		         				repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed","Payment Amount Error Message is displayed:  " +errorMessage,"PASS",runManagerInfoObj);     			
		         				blnFlag=true;        				
		         			}
		         			else{
		         				repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed",
		         						"Payment Amount Error Message is not displayed when field is left blank ","FAIL",runManagerInfoObj);
		         				blnFlag=false;
		         			}        			
		         		}
		         		else{
		         			repfn.FnUpdateTestStepResHTML("Verify Payment Amount field is displayed under Payment Information option",
		           					"Payment Amount field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		         			blnFlag=false;
		         		}
		         		
		         		driver.switchTo().defaultContent();
		         		
		         	
		         	}
		        	
		        	catch (Exception e)

		      		{
		      			repfn.FnUpdateTestStepResHTML("Verify User is able to verify blank Payment Amount ",
		      					"User is not able to verify blank Payment Amount  due to some exception","FAIL",runManagerInfoObj);

		      	      	 blnFlag=false;
		      			System.err.println("Message : "+e.getMessage());
		      			System.err.println("Cause : "+e.getCause());
		      			
		      		}
		      		m1.put("STEPSTATUS", blnFlag);
		      		return blnFlag;
		        	
		        }
		       
		       public synchronized boolean FnBlank_PaymentDate(WebDriver driver, RunManagerInfo runManagerInfoObj){
		          	
		      	  
		        	String blankPaymentDate = " ";
		        	String errorMessage = " ";
		        
		        	String errorStatusThree = "Please enter a valid payment date.";
		        	
		        	try{
		        		
		        		driver.switchTo().frame("iFrameResizer0");
		        		
		        		if(cnf.FnExplicitWait("XPATH", mbo.PaymentDate,driver)){
		        			repfn.FnUpdateTestStepResHTML("Verify Payment Date field is displayed under Payment Information option",
		          					"Payment Amount Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
		        			WebElement PaymentDate=driver.findElement(By.xpath(mbo.PaymentDate));
		        		
		        			
		        			PaymentDate.sendKeys(blankPaymentDate,Keys.TAB);
		        			repfn.FnUpdateTestStepResHTML("Verify Payment Date is entered","Payment date entered: " +blankPaymentDate ,"PASS",runManagerInfoObj);
		        			
		        			if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader,driver)){
		        				WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
		            			cnf.JSClick(PaymentInformationHeader,driver);
		        			}
		        			else{
		        				repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
		        				blnFlag=false;
		        			}
		        			Thread.sleep(2000);
		        			if(cnf.FnExplicitWait("XPATH", mbo.PaymentDateError,driver)){
		        				WebElement PaymentDateError=driver.findElement(By.xpath(mbo.PaymentDateError));
		        				errorMessage = PaymentDateError.getAttribute("textContent");
		        				repfn.FnUpdateTestStepResHTML("Verify Payment Date Error Message is displayed","Payment Date Error Message is displayed:  " +errorMessage,"PASS",runManagerInfoObj);
		        				blnFlag=true;
		/*        				if(errorStatusThree.equalsIgnoreCase(errorMessage)){
		            				repfn.FnUpdateTestStepResHTML("Verify Please enter a valid payment date  error message is displayed when Blank field left for Payement date ",
		            						"Please enter a valid payment date is displayed","PASS",runManagerInfoObj);
		            					blnFlag=true;
		            			}
		            			else{
		            				repfn.FnUpdateTestStepResHTML("Verify Please enter a valid payment date error message is displayed when Blank field left for Payement date",
		            						"Please enter a valid payment date. is not displayed","FAIL",runManagerInfoObj);
		            				blnFlag=false;
		            			}*/
		        				
		        				
		        			}
		        			else{
		        				repfn.FnUpdateTestStepResHTML("Verify Payment Date Error Message is displayed",
		        						"Payment Date Error Message is not displayed when field is left blank ","FAIL",runManagerInfoObj);
		        				blnFlag=false;
		        			}
		        			
		        			
		        		}
		        		else{
		        			repfn.FnUpdateTestStepResHTML("Verify Payment Date field is displayed under Payment Information option",
		          					"Payment Date field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		        			blnFlag=false;
		        		}
		        		
		        		driver.switchTo().defaultContent();
		        		
		        	
		        	}
		       	
		       	catch (Exception e)

		     		{
		     			repfn.FnUpdateTestStepResHTML("Verify User is able to verify blank Payment date",
		     					"User is not able to verify blank Payment date due to some exception","FAIL",runManagerInfoObj);

		     	      	 blnFlag=false;
		     			System.err.println("Message : "+e.getMessage());
		     			System.err.println("Cause : "+e.getCause());
		     			
		     		}
		     		m1.put("STEPSTATUS", blnFlag);
		     		return blnFlag;
		       	
		       }
		      
		       public synchronized boolean FnValidateEditPaymentOption(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
		    		  
		    	    String routingNumber = "122000247";
		    	    String accountNumber = "0888271156";
		    	    String paymentAmount = "1";
		    	    Calendar date = Calendar.getInstance();
		    	 
		    	 System.out.println("Toady Date is:"+date);
		    	 int year = date.get(Calendar.YEAR);
		    	 int month = date.get(Calendar.MONTH);
		    	 int day = date.get(Calendar.DAY_OF_MONTH);
		    	 String dayTwo = Integer.toString(day);
		    	 String monthTwo = Integer.toString(month);
		    	 String yearTwo = Integer.toString(year);
		    	 int monthOne = 0;
		    	 String dayThree = "";
		    	 String monthThree = "";
		    	 System.out.println("DAY ISSSSSSS"+month);
		    	    String validPaymentDate = "";
		    	    String validPaymentDateChrome = "";
		    	    String errorMessage = " ";

		    	 String errorStatusThree = "Please enter a valid payment date.";
		    	    
		    	   try{

		    	        driver.switchTo().frame("iFrameResizer0");
		    	        
		    	        if(cnf.FnExplicitWait("XPATH", mbo.RoutingNumber,driver)){
		    	               repfn.FnUpdateTestStepResHTML("Verify Routing Number field is displayed under Payment Information option",
		    	                            "Routing Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
		    	               WebElement RoutingNumber=driver.findElement(By.xpath(mbo.RoutingNumber));
		    	               RoutingNumber.sendKeys(routingNumber);
		    	               repfn.FnUpdateTestStepResHTML("Verify Routing Number is entered","Routing Number: " +routingNumber + "is entered","PASS",runManagerInfoObj);
		    	               blnFlag=true;
		    	        }
		    	        else{
		    	               repfn.FnUpdateTestStepResHTML("Verify Routing Number field is displayed under Payment Information option",
		    	                            "Routing Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		    	               blnFlag=false;
		    	        }
		    	        
		    	        
		    	        if(cnf.FnExplicitWait("XPATH", mbo.BankAccountNumber,driver)){
		    	               repfn.FnUpdateTestStepResHTML("Verify Bank Account Number field is displayed under Payment Information option",
		    	                           "Bank Account Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
		    	               WebElement BankAccountNumber=driver.findElement(By.xpath(mbo.BankAccountNumber));
		    	               BankAccountNumber.sendKeys(accountNumber);
		    	               repfn.FnUpdateTestStepResHTML("Verify Bank Account Number is entered","Bank Account Number:  " +accountNumber + "is entered","PASS",runManagerInfoObj);
		    	               blnFlag=true;
		    	        } 
		    	        else{
		    	               repfn.FnUpdateTestStepResHTML("Verify Bank Account Number field is displayed under Payment Information option",
		    	                            "Bank Account Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		    	               blnFlag=false;
		    	        }
		    	        
		    	        if(cnf.FnExplicitWait("XPATH", mbo.PaymentAmount,driver)){
		    	               repfn.FnUpdateTestStepResHTML("Verify Payment Amount field is displayed under Payment Information option",
		    	                           "Payment Amount Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
		    	               WebElement PaymentAmount=driver.findElement(By.xpath(mbo.PaymentAmount));
		    	               PaymentAmount.sendKeys(paymentAmount);
		    	               repfn.FnUpdateTestStepResHTML("Verify Payment Amount is entered","Payment Amount:  " +paymentAmount + "is entered","PASS",runManagerInfoObj);
		    	               blnFlag=true;
		    	        }
		    	        else{
		    	               repfn.FnUpdateTestStepResHTML("Verify Payment Amount field is displayed under Payment Information option",
		    	                            "Payment Amount Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		    	               blnFlag=false;
		    	        }
		    	        
		    	        
		    	        if(cnf.FnExplicitWait("XPATH", mbo.PaymentDate,driver)){
		    	               repfn.FnUpdateTestStepResHTML("Verify Payment Date field is displayed under Payment Information option",
		    	                            "Payment Amount Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
		    	               WebElement PaymentDate=driver.findElement(By.xpath(mbo.PaymentDate));
		    	               

		    	               if((month+1)<10){
		    	            	   	 monthOne = month+1;
		    	            	   	 String value = Integer.toString(monthOne);
		    	                     monthThree = "0"+value;
		    	                     System.out.println(monthThree);
		    	               }
		    	               else{
		    	                     monthThree = Integer.toString((month+1));
		    	               }
		    	               
		    	               if(day < 10){
		    	            	   dayThree = "0"+dayTwo;
		    	            	   System.out.println(dayThree);
		    	               }
		    	               else{
		    	                   dayThree = dayTwo;
		    	               }
		    	               
		    	               validPaymentDate = monthThree+"/"+dayThree+"/"+yearTwo;
		    	               validPaymentDateChrome = monthThree+"/"+dayThree;
		    	               
		    	              // System.out.println(dayOne);
		    	               System.out.println(validPaymentDate);
		    	               System.out.println(validPaymentDateChrome);
		    	               
		    	               String Browser=m1.get("BROWSER").toString();
		    	               System.out.println("Browser is:   "+Browser);
		    	               if(Browser.equalsIgnoreCase("chrome"))
		    	               {
		    	                      PaymentDate.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),validPaymentDateChrome);
		    	                     repfn.FnUpdateTestStepResHTML("Verify Payment Date is entered","Payment date entered: " +validPaymentDateChrome ,"PASS",runManagerInfoObj);

		    	               }else {
		    	                      PaymentDate.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),validPaymentDate);
		    	                     repfn.FnUpdateTestStepResHTML("Verify Payment Date is entered","Payment date entered: " +validPaymentDate ,"PASS",runManagerInfoObj);
		    	               }
		    	                    
		    	                    
		    							 if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader,driver)){
		    			                     WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
		    			                     cnf.JSClick(PaymentInformationHeader,driver);
		    			                     blnFlag=true;
		    			               }
		    			               else{
		    			                     repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
		    			                     blnFlag=false;
		    			               }
		    						
		    	      	

		    	              
		    	        }
		    	        else{
		    	               repfn.FnUpdateTestStepResHTML("Verify Payment Date field is displayed under Payment Information option",
		    	                            "Payment Date field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		    	               blnFlag=false;
		    	        }
		    	        
		    	        driver.switchTo().defaultContent();
		    	        
		    	   }
		    	   
		    	   catch (Exception e)

		    	        {
		    	               repfn.FnUpdateTestStepResHTML("Verify User is able to verify Pay Bill button on Home page",
		    	                            "User is able to verify Pay Bill button on Home page due to some exception","FAIL",runManagerInfoObj);

		    	        blnFlag=false;
		    	               System.err.println("Message : "+e.getMessage());
		    	               System.err.println("Cause : "+e.getCause());
		    	               
		    	        }
		    	        m1.put("STEPSTATUS", blnFlag);
		    	        return blnFlag;
		    	   
		    	}
		       public synchronized boolean FnClickPayBillButtonAndVerify(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
		    	   
		    	   String routingNumberOne = "";
		    	   String accountNumberOne = "";
		    	   String paymentDateOne = "";
		    	   String routingNumber = "";
		    	   String accountNumber = "";
		    	   String paymentAmount = "";
		    	   String paymentDate = "";
		    	   String month = "";
		    	   String day = "";
		    	   String year = "";

		    	   try{
		    	          
		    	          driver.switchTo().frame("iFrameResizer0");
		    	          
		    	          if(cnf.FnExplicitWait("XPATH", mbo.RoutingNumber,driver)){
		    	                 WebElement RoutingNumber=driver.findElement(By.xpath(mbo.RoutingNumber));
		    	                 routingNumberOne = RoutingNumber.getAttribute("value");       
		    	                 int length = routingNumberOne.length();
		    	                 routingNumber = routingNumberOne.substring((length-4));
		    	                 System.out.println(routingNumber);
		    	                 blnFlag=true;
		    	          }
		    	          else{
		    	                 repfn.FnUpdateTestStepResHTML("Verify Routing Number field is displayed under Payment Information option",
		    	                              "Routing Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		    	                 blnFlag=false;
		    	          }
		    	          
		    	          if(cnf.FnExplicitWait("XPATH", mbo.BankAccountNumber,driver)){
		    	                 WebElement BankAccountNumber=driver.findElement(By.xpath(mbo.BankAccountNumber));
		    	                 accountNumberOne = BankAccountNumber.getAttribute("value");
		    	                 int length = accountNumberOne.length();
		    	                 accountNumber = accountNumberOne.substring((length-4));
		    	                 System.out.println(accountNumber);
		    	                 blnFlag=true;
		    	          } 
		    	          else{
		    	                 repfn.FnUpdateTestStepResHTML("Verify Bank Account Number field is displayed under Payment Information option",
		    	                              "Bank Account Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		    	                 blnFlag=false;
		    	          }
		    	          
		    	          if(cnf.FnExplicitWait("XPATH", mbo.PaymentAmount,driver)){
		    	                 WebElement PaymentAmount=driver.findElement(By.xpath(mbo.PaymentAmount));
		    	                 paymentAmount = PaymentAmount.getAttribute("value");
		    	                 blnFlag=true;
		    	          }
		    	          else{
		    	                 repfn.FnUpdateTestStepResHTML("Verify Payment Amount field is displayed under Payment Information option",
		    	                              "Payment Amount Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		    	                 blnFlag=false;
		    	          }
		    	          
		    	          if(cnf.FnExplicitWait("XPATH", mbo.PaymentDate,driver)){
		    	                 WebElement PaymentDate=driver.findElement(By.xpath(mbo.PaymentDate));
		    	                 paymentDateOne = PaymentDate.getAttribute("value");
		    	                 String Browser=m1.get("BROWSER").toString();
		    	                 System.out.println("Browser is:   "+Browser);
		    	                 if(Browser.equalsIgnoreCase("chrome"))
		    	                 {
		    	              	   String[] one = paymentDateOne.split("-");
		    	                     month = one[1];
		    	                     day = one[2];
		    	                     String yearOne = one[0];
		    	                     year = yearOne.substring((2));
		    	                     paymentDate = month+"/"+day+"/"+year;
		    	                     System.out.println(paymentDate);
		    	                     blnFlag=true;
		    	                 }
		    	                 else
		    	                 {
		    	              	   String[] one = paymentDateOne.split("/");
		    	                     month = one[0];
		    	                     day = one[1];
		    	                     String yearOne = one[2];
		    	                     year = yearOne.substring((2));
		    	                     paymentDate = month+"/"+day+"/"+year;
		    	                     System.out.println(paymentDate);
		    	                     blnFlag=true;
		    	                 }
		    	          }
		    	          else{
		    	                 repfn.FnUpdateTestStepResHTML("Verify Payment Date field is displayed under Payment Information option",
		    	                              "Payment Date field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		    	                 blnFlag=false;
		    	          }
		    	          
		    	          Thread.sleep(2000);
		    	          if(cnf.FnExplicitWait("XPATH", mbo.PayNowButton,driver)){
		    	                 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(mbo.PayNowButton)));   
		    	                 repfn.FnUpdateTestStepResHTML("Verify Pay Now button is displayed","Pay Now button is displayed","PASS",runManagerInfoObj);
		    	                 WebElement PayNowButton=driver.findElement(By.xpath(mbo.PayNowButton));
		    	                 //cnf.ScrollToView(PayNowButton);
		    	                 if(PayNowButton.isEnabled()){
		    	                       repfn.FnUpdateTestStepResHTML("Verify Pay Now button is enabled","Pay Now button is enabled.","PASS",runManagerInfoObj);
		    	                       if(cnf.JSClick(PayNowButton,driver)){
		    	                              repfn.FnUpdateTestStepResHTML("Verify Pay Now button is clicked","Pay Now button is clicked.","PASS",runManagerInfoObj);
		    	                              
		    	                              Thread.sleep(5000);
		    	                              
		    	                              if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentPageOne,driver)){
		    	                                     WebElement VerifyPaymentPageOne=driver.findElement(By.xpath(mbo.VerifyPaymentPageOne));
		    	                                     if(VerifyPaymentPageOne.getText().contains("Verify Payment Information")){
		    	                                            repfn.FnUpdateTestStepResHTML("Verify User is navigated to Verify Payment page","User is navigated to Verify Payment page","PASS",runManagerInfoObj);
		    	                                            
		    	                                            if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentPage_RoutingNumber,driver)){
		    	                                                   WebElement VerifyPaymentPage_RoutingNumber=driver.findElement(By.xpath(mbo.VerifyPaymentPage_RoutingNumber));
		    	                                                   if(VerifyPaymentPage_RoutingNumber.getAttribute("textContent").contains(routingNumber)){
		    	                                                          repfn.FnUpdateTestStepResHTML("Verify Correct Routing Number is displayed","Correct Routing Number is displayed","PASS",runManagerInfoObj);
		    	                                                          blnFlag=true;
		    	                                                   }
		    	                                                   else{
		    	                                                          repfn.FnUpdateTestStepResHTML("Verify Correct Routing Number is displayed","Correct Routing Number is not displayed","FAIL",runManagerInfoObj);
		    	                                                          blnFlag=false;
		    	                                                          
		    	                                                   }
		    	                                            }
		    	                                            else{
		    	                                                   repfn.FnUpdateTestStepResHTML("Verify Correct Routing Number is displayed","Correct Routing Number is not displayed","FAIL",runManagerInfoObj);
		    	                                                          blnFlag=false;
		    	                                            }
		    	                                            
		    	                                            if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentPageOne_AccountNumber,driver)){
		    	                                                   WebElement VerifyPaymentPageOne_AccountNumber=driver.findElement(By.xpath(mbo.VerifyPaymentPageOne_AccountNumber));
		    	                                                   if(VerifyPaymentPageOne_AccountNumber.getAttribute("textContent").contains(accountNumber)){
		    	                                                          repfn.FnUpdateTestStepResHTML("Verify Correct Account Number is displayed","Correct Account Number is displayed","PASS",runManagerInfoObj);
		    	                                                          blnFlag=true;
		    	                                                   }
		    	                                                   else{
		    	                                                          repfn.FnUpdateTestStepResHTML("Verify Correct Account Number is displayed","Correct Account Number is not displayed","FAIL",runManagerInfoObj);
		    	                                                          blnFlag=false;
		    	                                                          
		    	                                                   }
		    	                                            }
		    	                                            else{
		    	                                                   repfn.FnUpdateTestStepResHTML("Verify Correct Account Number is displayed","Correct Account Number is not displayed","FAIL",runManagerInfoObj);
		    	                                                          blnFlag=false;
		    	                                            }
		    	                                            
		    	                                            if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentPageOne_PaymentAmount,driver)){
		    	                                                   WebElement VerifyPaymentPageOne_PaymentAmount=driver.findElement(By.xpath(mbo.VerifyPaymentPageOne_PaymentAmount));
		    	                                                   if(VerifyPaymentPageOne_PaymentAmount.getAttribute("textContent").contains(paymentAmount)){
		    	                                                          repfn.FnUpdateTestStepResHTML("Verify Correct Payment Amount is displayed","Correct Payment Amount is displayed","PASS",runManagerInfoObj);
		    	                                                          blnFlag=true;
		    	                                                   }
		    	                                                   else{
		    	                                                          repfn.FnUpdateTestStepResHTML("Verify Correct Payment Amount is displayed","Correct Payment Amount is not displayed","FAIL",runManagerInfoObj);
		    	                                                          blnFlag=false;
		    	                                                          
		    	                                                   }
		    	                                            }
		    	                                            else{
		    	                                                   repfn.FnUpdateTestStepResHTML("Verify Correct Payment Amount is displayed","Correct Payment Amount is not displayed","FAIL",runManagerInfoObj);
		    	                                                          blnFlag=false;
		    	                                            }
		    	                                            
		    	                                            if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentPageOne_PaymentDate,driver)){
		    	                                                   WebElement VerifyPaymentPageOne_PaymentDate=driver.findElement(By.xpath(mbo.VerifyPaymentPageOne_PaymentDate));
		    	                                                   System.out.println(VerifyPaymentPageOne_PaymentDate.getAttribute("textContent"));
		    	                                                   if(VerifyPaymentPageOne_PaymentDate.getAttribute("textContent").contains(paymentDate)){
		    	                                                          repfn.FnUpdateTestStepResHTML("Verify Correct Payment Date is displayed","Correct Payment Date is displayed","PASS",runManagerInfoObj);
		    	                                                          blnFlag=true;
		    	                                                   }
		    	                                                   else{
		    	                                                          repfn.FnUpdateTestStepResHTML("Verify Correct Payment Date is displayed","Correct Payment Date is not displayed","FAIL",runManagerInfoObj);
		    	                                                          blnFlag=false;
		    	                                                          
		    	                                                   }
		    	                                            }
		    	                                            else{
		    	                                                   repfn.FnUpdateTestStepResHTML("Verify Correct Payment Date is displayed","Correct Payment Date is not displayed","FAIL",runManagerInfoObj);
		    	                                                          blnFlag=false;
		    	                                            }
		    	                                            
		    	                                            if(cnf.FnExplicitWait("XPATH", mbo.EditPaymentDetailsLink,driver)){
		    	                                                   repfn.FnUpdateTestStepResHTML("Verify Edit Payment Details link is displayed","Edit Payment Details link is displayed","PASS",runManagerInfoObj);
		    	                                                   WebElement EditPaymentDetailsLink=driver.findElement(By.xpath(mbo.EditPaymentDetailsLink));
		    	                                                   if(cnf.JSClick(EditPaymentDetailsLink,driver)){
		    	                                                          repfn.FnUpdateTestStepResHTML("Verify Edit Payment Details link is clicked","Edit Payment Details link is clicked","PASS",runManagerInfoObj);
		    	                                                          
		    	                                                          Thread.sleep(5000);
		    	                                                          
		    	                                                          if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader,driver)){
		    	                                                                 repfn.FnUpdateTestStepResHTML("Verify User is navigated back to Pay Bill page","User is navigated back to Pay Bill page","PASS",runManagerInfoObj);
		    	                                                                 
		    	                                                                 if(cnf.FnExplicitWait("XPATH", mbo.RoutingNumber,driver)){
		    	                                                                       WebElement RoutingNumber=driver.findElement(By.xpath(mbo.RoutingNumber));
		    	                                                                        if(RoutingNumber.getAttribute("value").equalsIgnoreCase(routingNumberOne)){
		    	                                                                              repfn.FnUpdateTestStepResHTML("Verify Previously entered Routing Number is pre-populated in Routing Number field",
		    	                                                                                            "Previously entered Routing Number is pre-populated in Routing Number field","PASS",runManagerInfoObj);
		    	                                                                              blnFlag=true;
		    	                                                                       }
		    	                                                                       else{
		    	                                                                              repfn.FnUpdateTestStepResHTML("Verify Previously entered Routing Number is pre-populated in Routing Number field",
		    	                                                                                            "Previously entered Routing Number is not pre-populated in Routing Number field","FAIL",runManagerInfoObj);
		    	                                                                              blnFlag=false;
		    	                                                                       }
		    	                                                                 }
		    	                                                                 else{
		    	                                                                        repfn.FnUpdateTestStepResHTML("Verify Routing Number field is displayed","Routing Number field is not displayed","FAIL",runManagerInfoObj);
		    	                                                                       blnFlag=false;
		    	                                                                 }
		    	                                                                 
		    	                                                                 if(cnf.FnExplicitWait("XPATH", mbo.BankAccountNumber,driver)){
		    	                                                                       WebElement BankAccountNumber=driver.findElement(By.xpath(mbo.BankAccountNumber));
		    	                                                                        if(BankAccountNumber.getAttribute("value").equalsIgnoreCase(accountNumberOne)){
		    	                                                                              repfn.FnUpdateTestStepResHTML("Verify Previously entered Account Number is pre-populated in Account Number field",
		    	                                                                                            "Previously entered Account Number is pre-populated in Account Number field","PASS",runManagerInfoObj);
		    	                                                                              blnFlag=true;
		    	                                                                       }
		    	                                                                       else{
		    	                                                                              repfn.FnUpdateTestStepResHTML("Verify Previously entered Account Number is pre-populated in Account Number field",
		    	                                                                                            "Previously entered Account Number is not pre-populated in Account Number field","FAIL",runManagerInfoObj);
		    	                                                                              blnFlag=false;
		    	                                                                       }
		    	                                                                 }
		    	                                                                 else{
		    	                                                                        repfn.FnUpdateTestStepResHTML("Verify Account Number field is displayed","Account Number field is not displayed","FAIL",runManagerInfoObj);
		    	                                                                       blnFlag=false;
		    	                                                                 }
		    	                                                                 
		    	                                                                 if(cnf.FnExplicitWait("XPATH", mbo.PaymentAmount,driver)){
		    	                                                                       WebElement PaymentAmount=driver.findElement(By.xpath(mbo.PaymentAmount));
		    	                                                                        if(PaymentAmount.getAttribute("value").equalsIgnoreCase(paymentAmount)){
		    	                                                                              repfn.FnUpdateTestStepResHTML("Verify Previously entered Payment Amount is pre-populated in Payment Amount field",
		    	                                                                                            "Previously entered Payment Amount is pre-populated in Payment Amount field","PASS",runManagerInfoObj);
		    	                                                                              blnFlag=true;
		    	                                                                       }
		    	                                                                       else{
		    	                                                                              repfn.FnUpdateTestStepResHTML("Verify Previously entered Payment Amount is pre-populated in Payment Amount field",
		    	                                                                                            "Previously entered Payment Amount is not pre-populated in Payment Amount field","FAIL",runManagerInfoObj);
		    	                                                                              blnFlag=false;
		    	                                                                       }
		    	                                                                 }
		    	                                                                 else{
		    	                                                                        repfn.FnUpdateTestStepResHTML("Verify Payment Amount field is displayed","Payment Amount field is not displayed","FAIL",runManagerInfoObj);
		    	                                                                       blnFlag=false;
		    	                                                                 }
		    	                                                                 
		    	                                                                 if(cnf.FnExplicitWait("XPATH", mbo.PaymentDate,driver)){
		    	                                                                       WebElement PaymentDate=driver.findElement(By.xpath(mbo.PaymentDate));
		    	                                                                        if(PaymentDate.getAttribute("value").equalsIgnoreCase(paymentDateOne)){
		    	                                                                              repfn.FnUpdateTestStepResHTML("Verify Previously entered Payment Date is pre-populated in Payment Date field",
		    	                                                                                            "Previously entered Payment Date is pre-populated in Payment Date field","PASS",runManagerInfoObj);
		    	                                                                              blnFlag=true;
		    	                                                                       }
		    	                                                                       else{
		    	                                                                              repfn.FnUpdateTestStepResHTML("Verify Previously entered Payment Date is pre-populated in Payment Date field",
		    	                                                                                            "Previously entered Payment Date is not pre-populated in Payment Date field","FAIL",runManagerInfoObj);
		    	                                                                              blnFlag=false;
		    	                                                                       }
		    	                                                                 }
		    	                                                                 else{
		    	                                                                        repfn.FnUpdateTestStepResHTML("Verify Payment Date field is displayed","Payment Date field is not displayed","FAIL",runManagerInfoObj);
		    	                                                                       blnFlag=false;
		    	                                                                 }
		    	                                                                 
		    	                                                                 
		    	                                                          }
		    	                                                          else{
		    	                                                                 repfn.FnUpdateTestStepResHTML("Verify User is navigated back to Pay Bill page","User is not navigated back to Pay Bill page","FAIL",runManagerInfoObj);
		    	                                                                 blnFlag=false;
		    	                                                          }
		    	                                                          
		    	                                                   }
		    	                                                   else{
		    	                                                          repfn.FnUpdateTestStepResHTML("Verify Edit Payment Details link is clicked","Edit Payment Details link is not clicked","FAIL",runManagerInfoObj);
		    	                                                          blnFlag=false;
		    	                                                   }
		    	                                            }
		    	                                            else{
		    	                                                   repfn.FnUpdateTestStepResHTML("Verify Edit Payment Details link is displayed","Edit Payment Details link is not displayed","FAIL",runManagerInfoObj);
		    	                                                   blnFlag=false;
		    	                                            }
		    	                                            
		    	                                     }
		    	                                     else{
		    	                                            repfn.FnUpdateTestStepResHTML("Verify User is navigated to Verify Payment page","User is not navigated to Verify Payment page","FAIL",runManagerInfoObj);
		    	                                            blnFlag=false;
		    	                                     }
		    	                              }
		    	                       }
		    	                       else{
		    	                              repfn.FnUpdateTestStepResHTML("Verify Pay Now button is clicked","Pay Now button is not clicked.","FAIL",runManagerInfoObj);
		    	                              blnFlag=false;
		    	                       }
		    	                 }
		    	                 else{
		    	                       repfn.FnUpdateTestStepResHTML("Verify Pay Now button is enabled","Pay Now button is not enabled","FAIL",runManagerInfoObj);
		    	                       blnFlag=false;
		    	                 }
		    	          }
		    	          else{
		    	                 repfn.FnUpdateTestStepResHTML("Verify Pay Now button is displayed","Pay Now button is not displayed","FAIL",runManagerInfoObj);
		    	                 blnFlag=false;
		    	          }
		    	          
		    	          driver.switchTo().defaultContent();
		    	          
		    	          Thread.sleep(5000);
		    	          if(cnf.FnExplicitWait("XPATH", mbo.ViewStatementsLink,driver)){
		    	                 repfn.FnUpdateTestStepResHTML("Verify View Statements Link is displayed","View Statements Link is displayed","PASS",runManagerInfoObj);
		    	                 WebElement ViewStatementsLink=driver.findElement(By.xpath(mbo.ViewStatementsLink));
		    	                 if(cnf.JSClick(ViewStatementsLink,driver)){
		    	                       repfn.FnUpdateTestStepResHTML("Verify View Statements Link is clicked","View Statements Link is clicked","PASS",runManagerInfoObj);
		    	                       WebElement ConfirmCancel=driver.findElement(By.xpath(mbo.ConfirmCancel));
		    	                              if(cnf.FnExplicitWait("XPATH", mbo.ConfirmCancel,driver)){
		    	                                     repfn.FnUpdateTestStepResHTML("Verify Confirm Navigation pop-up is displayed", "Confirm Navigation pop-up is displayed","PASS",runManagerInfoObj);
		    	                                     cnf.JSClick(ConfirmCancel,driver);
		    	                                     repfn.FnUpdateTestStepResHTML("Verify Navigation to View Statements page", "Navigation to View Statements page is done","PASS",runManagerInfoObj);
		    	                                     Thread.sleep(5000);
		    	                                     blnFlag=true;
		    	                              }
		    	                              else{
		    	                                     repfn.FnUpdateTestStepResHTML("Verify Confirm Navigation pop-up is displayed", "Confirm Navigation pop-up is not displayed","FAIL",runManagerInfoObj);
		    	                                     blnFlag=false;
		    	                              }
		    	                       
		    	                 }
		    	                 else{
		    	                       repfn.FnUpdateTestStepResHTML("Verify View Statements Link is clicked","View Statements Link is not clicked","FAIL",runManagerInfoObj);
		    	                       blnFlag=false;
		    	                 }
		    	                 
		    	                 
		    	          }
		    	          else{
		    	                 repfn.FnUpdateTestStepResHTML("Verify View Statements Link is displayed","View Statements Link is not displayed","FAIL",runManagerInfoObj);
		    	                 blnFlag=false;
		    	          }
		    	          
		    	   }
		    	   
		    	   catch (Exception e)

		    	   {
		    	          repfn.FnUpdateTestStepResHTML("Verify User is able to verify Pay Bill informatio",
		    	                       "User is able to verify Pay Bill information due to some exception","FAIL",runManagerInfoObj);

		    	   blnFlag=false;
		    	          System.err.println("Message : "+e.getMessage());
		    	          System.err.println("Cause : "+e.getCause());
		    	          
		    	   }
		    	   m1.put("STEPSTATUS", blnFlag);
		    	   return blnFlag;
		    	   
		    	  }
		       public synchronized boolean FnValidateBlankCardFields(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
		    		
		    		String invalidCardNumber = "";
		    		String invalidExpirationDate = "";
		    		String errorMessage = "";
		    		
		    		try{
		    			
		    			driver.switchTo().frame("iFrameResizer0");
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.CardNumber,driver)){
		    				repfn.FnUpdateTestStepResHTML("Verify Card Number field is displayed","Card Number field is displayed","PASS",runManagerInfoObj);
		    				WebElement CardNumber=driver.findElement(By.xpath(mbo.CardNumber));
		    				CardNumber.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),invalidCardNumber);
		    				repfn.FnUpdateTestStepResHTML("Verify Invalid Card Number is entered","Invalid Card Number is entered: "+invalidCardNumber,"PASS",runManagerInfoObj);
		    				
		    				if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader,driver)){
		    					WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
		    					cnf.JSClick(PaymentInformationHeader,driver);
		    					blnFlag=true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    				
		    				if(cnf.FnExplicitWait("XPATH", mbo.CardNumberError,driver)){
		    	   				WebElement CardNumberError=driver.findElement(By.xpath(mbo.CardNumberError));
		    	   				errorMessage = CardNumberError.getAttribute("textContent");
		    	   				repfn.FnUpdateTestStepResHTML("Verify Card Number Error Message is displayed","Card Number Error Message: " +errorMessage + "is displayed","PASS",runManagerInfoObj);
		    	   				blnFlag=true;
		    	   				
		    	   			}
		    	   			else{
		    	   				repfn.FnUpdateTestStepResHTML("Verify Card Number Error Message is displayed",
		    	   						"Card Number Error Message is not displayed when this number is entered: " +invalidCardNumber,"FAIL",runManagerInfoObj);
		    	   				blnFlag=false;
		    	   			}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Card Number field is displayed","Card Number field is not displayed","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.ExpirationDate,driver)){
		    				repfn.FnUpdateTestStepResHTML("Verify Expiration Date field is displayed","Expiration Date field is displayed","PASS",runManagerInfoObj);
		    				WebElement ExpirationDate=driver.findElement(By.xpath(mbo.ExpirationDate));
		    				ExpirationDate.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),invalidExpirationDate);
		    				repfn.FnUpdateTestStepResHTML("Verify Expiration Date is entered","Expiration Date is entered: "+invalidExpirationDate,"PASS",runManagerInfoObj);
		    				
		    				if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader,driver)){
		    					WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
		    					cnf.JSClick(PaymentInformationHeader,driver);
		    					blnFlag=true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    				
		    				if(cnf.FnExplicitWait("XPATH", mbo.ExpirationDateError,driver)){
		    	   				WebElement ExpirationDateError=driver.findElement(By.xpath(mbo.ExpirationDateError));
		    	   				errorMessage = ExpirationDateError.getAttribute("textContent");
		    	   				repfn.FnUpdateTestStepResHTML("Verify Expiration Date Error Message is displayed","Expiration Date Error Message: " +errorMessage + "is displayed","PASS",runManagerInfoObj);
		    	   				blnFlag=true;
		    	   				
		    	   			}
		    	   			else{
		    	   				repfn.FnUpdateTestStepResHTML("Verify Expiration Date Error Message is displayed",
		    	   						"Expiration Date Error Message is not displayed when this date is entered: " +invalidExpirationDate,"FAIL",runManagerInfoObj);
		    	   				blnFlag=false;
		    	   			}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Expiration Date field is displayed","Expiration Date field is not displayed","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			driver.switchTo().defaultContent();
		    		}
		    		
		    		catch (Exception e)

		    		{
		    			repfn.FnUpdateTestStepResHTML("Verify User is able to verify Pay Bill information",
		    					"User is able to verify Pay Bill information due to some exception","FAIL",runManagerInfoObj);

		    	      	 blnFlag=false;
		    			System.err.println("Message : "+e.getMessage());
		    			System.err.println("Cause : "+e.getCause());
		    			
		    		}
		    		m1.put("STEPSTATUS", blnFlag);
		    		return blnFlag;
		    		
		    	}
		       public synchronized boolean FnValidateEditPaymentOption_Credit_Debit(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
		    		  
		    		String CardNumber = "4444444444444448";
		    		String ExpirationDate = "12/2016";
		    	    String paymentAmount = "1";
		    	    Calendar date = Calendar.getInstance();
		    	 
		    	 System.out.println("Toady Date is:"+date);
		    	 int year = date.get(Calendar.YEAR);
		    	 int month = date.get(Calendar.MONTH);
		    	 int day = date.get(Calendar.DAY_OF_MONTH);
		    	 int dayOne = 0;
		    	 int monthOne = 0;
		    	 System.out.println("DAY ISSSSSSS"+month);
		    	    String validPaymentDate = "";
		    	    String validPaymentDateChrome = "";
		    	    String errorMessage = " ";

		    	 String errorStatusThree = "Please enter a valid payment date.";
		    	    
		    	   try{

		    	        driver.switchTo().frame("iFrameResizer0");
		    	        
		    	        if(cnf.FnExplicitWait("XPATH", mbo.CardNumber,driver)){
		    				repfn.FnUpdateTestStepResHTML("Verify Card Number field is displayed","Card Number field is displayed","PASS",runManagerInfoObj);
		    				WebElement cardNumber=driver.findElement(By.xpath(mbo.CardNumber));
		    				cardNumber.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),CardNumber);
		    				repfn.FnUpdateTestStepResHTML("Verify Card Number is entered","Card Number is entered: "+CardNumber,"PASS",runManagerInfoObj);
		    				blnFlag=true;
		    		
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Card Number field is displayed","Card Number field is not displayed","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    	        
		    	        if(cnf.FnExplicitWait("XPATH", mbo.ExpirationDate,driver)){
		    				repfn.FnUpdateTestStepResHTML("Verify Expiration Date field is displayed","Expiration Date field is displayed","PASS",runManagerInfoObj);
		    				WebElement expirationDate=driver.findElement(By.xpath(mbo.ExpirationDate));
		    				expirationDate.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),ExpirationDate);
		    				repfn.FnUpdateTestStepResHTML("Verify Expiration Date is entered","Expiration Date is entered: "+ExpirationDate,"PASS",runManagerInfoObj);
		    				blnFlag=true;
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Expiration Date field is displayed","Expiration Date field is not displayed","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    	        
		    	        if(cnf.FnExplicitWait("XPATH", mbo.PaymentAmount,driver)){
		    	               repfn.FnUpdateTestStepResHTML("Verify Payment Amount field is displayed under Payment Information option",
		    	                           "Payment Amount Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
		    	               WebElement PaymentAmount=driver.findElement(By.xpath(mbo.PaymentAmount));
		    	               PaymentAmount.sendKeys(paymentAmount);
		    	               repfn.FnUpdateTestStepResHTML("Verify Payment Amount is entered","Payment Amount:  " +paymentAmount + "is entered","PASS",runManagerInfoObj);
		    	               blnFlag=true;
		    	        }
		    	        else{
		    	               repfn.FnUpdateTestStepResHTML("Verify Payment Amount field is displayed under Payment Information option",
		    	                            "Payment Amount Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		    	               blnFlag=false;
		    	        }
		    	        
		    	        
		    	        if(cnf.FnExplicitWait("XPATH", mbo.PaymentDate,driver)){
		    	               repfn.FnUpdateTestStepResHTML("Verify Payment Date field is displayed under Payment Information option",
		    	                            "Payment Amount Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
		    	               WebElement PaymentDate=driver.findElement(By.xpath(mbo.PaymentDate));
		    	               
		    	               if((month+1)<10){
		    	                     monthOne = Integer.parseInt("0"+month);
		    	               }
		    	               else{
		    	                     monthOne = month;
		    	               }
		    	               
		    	               if(day < 10){
		    	                     dayOne = Integer.parseInt("0"+day);
		    	               }
		    	               else{
		    	                     dayOne = day;
		    	               }
		    	               
		    	               validPaymentDate = (monthOne+1)+"/"+dayOne+"/"+year;
		    	               validPaymentDateChrome = (monthOne+1)+"/"+dayOne;
		    	               
		    	               String Browser=m1.get("BROWSER").toString();
		    	               System.out.println("Browser is:   "+Browser);
		    	               if(Browser.equalsIgnoreCase("chrome"))
		    	               {
		    	                      PaymentDate.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),validPaymentDateChrome);
		    	                     repfn.FnUpdateTestStepResHTML("Verify Payment Date is entered","Payment date entered: " +validPaymentDateChrome ,"PASS",runManagerInfoObj);
		    	                     
		    	               }else {
		    	                      PaymentDate.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),validPaymentDate);
		    	                     repfn.FnUpdateTestStepResHTML("Verify Payment Date is entered","Payment date entered: " +validPaymentDate ,"PASS",runManagerInfoObj);
		    	               }

		    	             
		    						 if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader,driver)){
		    		                     WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
		    		                     cnf.JSClick(PaymentInformationHeader,driver);
		    		                     blnFlag=true;
		    		               }
		    		               else{
		    		                     repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
		    		                     blnFlag=false;
		    		               }
		    					 
		    	              
		    	        }
		    	        else{
		    	               repfn.FnUpdateTestStepResHTML("Verify Payment Date field is displayed under Payment Information option",
		    	                            "Payment Date field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		    	               blnFlag=false;
		    	        }
		    	        
		    	        driver.switchTo().defaultContent();
		    	        
		    	   }
		    	   
		    	   catch (Exception e)

		    	        {
		    	               repfn.FnUpdateTestStepResHTML("Verify User is able to verify Pay Bill button on Home page",
		    	                            "User is able to verify Pay Bill button on Home page due to some exception","FAIL",runManagerInfoObj);

		    	        blnFlag=false;
		    	               System.err.println("Message : "+e.getMessage());
		    	               System.err.println("Cause : "+e.getCause());
		    	               
		    	        }
		    	        m1.put("STEPSTATUS", blnFlag);
		    	        return blnFlag;
		    	   
		    	}
		       public synchronized boolean FnClickPayBillButtonAndVerify_Credit_Debit(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
		    	   
		    	   String cardNumberOne = "";
		    	   String paymentDateOne = "";
		    	   String cardNumber = "";
		    	   String expirationDate = "";
		    	   String paymentAmount = "";
		    	   String paymentDate = "";
		    	   String month = "";
		    	   String day = "";
		    	   String year = "";

		    	   try{
		    	          
		    	          driver.switchTo().frame("iFrameResizer0");
		    	          
		    	          if(cnf.FnExplicitWait("XPATH", mbo.CardNumber,driver)){
		    	                 WebElement CardNumber=driver.findElement(By.xpath(mbo.CardNumber));
		    	                 cardNumberOne = CardNumber.getAttribute("value");       
		    	                 int length = cardNumberOne.length();
		    	                 cardNumber = cardNumberOne.substring((length-4));
		    	                 System.out.println(cardNumber);
		    	                 blnFlag=true;
		    	          }
		    	          else{
		    	                 repfn.FnUpdateTestStepResHTML("Verify Card Number field is displayed under Payment Information option",
		    	                              "Card Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		    	                 blnFlag=false;
		    	          }
		    	          
		    	          if(cnf.FnExplicitWait("XPATH", mbo.ExpirationDate,driver)){
		    	                 WebElement ExpirationDate=driver.findElement(By.xpath(mbo.ExpirationDate));
		    	                 expirationDate = ExpirationDate.getAttribute("value");
		    	                 blnFlag=true;
		    	          } 
		    	          else{
		    	                 repfn.FnUpdateTestStepResHTML("Verify Expiration Date field is displayed under Payment Information option",
		    	                              "Expiration Date field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		    	                 blnFlag=false;
		    	          }
		    	          
		    	          if(cnf.FnExplicitWait("XPATH", mbo.PaymentAmount,driver)){
		    	                 WebElement PaymentAmount=driver.findElement(By.xpath(mbo.PaymentAmount));
		    	                 paymentAmount = PaymentAmount.getAttribute("value");
		    	                 blnFlag=true;
		    	          }
		    	          else{
		    	                 repfn.FnUpdateTestStepResHTML("Verify Payment Amount field is displayed under Payment Information option",
		    	                              "Payment Amount Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		    	                 blnFlag=false;
		    	          }
		    	          
		    	          if(cnf.FnExplicitWait("XPATH", mbo.PaymentDate,driver)){
		    	                 WebElement PaymentDate=driver.findElement(By.xpath(mbo.PaymentDate));
		    	                 paymentDateOne = PaymentDate.getAttribute("value");
		    	                 String Browser=m1.get("BROWSER").toString();
		    	                 System.out.println("Browser is:   "+Browser);
		    	                 if(Browser.equalsIgnoreCase("chrome"))
		    	                 {
		    	              	   String[] one = paymentDateOne.split("-");
		    	                     month = one[1];
		    	                     day = one[2];
		    	                     String yearOne = one[0];
		    	                     year = yearOne.substring((2));
		    	                     paymentDate = month+"/"+day+"/"+year;
		    	                     System.out.println(paymentDate);
		    	                     blnFlag=true;
		    	                 }
		    	                 else
		    	                 {
		    	              	   String[] one = paymentDateOne.split("/");
		    	                     month = one[0];
		    	                     day = one[1];
		    	                     String yearOne = one[2];
		    	                     year = yearOne.substring((2));
		    	                     paymentDate = month+"/"+day+"/"+year;
		    	                     System.out.println(paymentDate);
		    	                     blnFlag=true;
		    	                 }
		    	          }
		    	          else{
		    	                 repfn.FnUpdateTestStepResHTML("Verify Payment Date field is displayed under Payment Information option",
		    	                              "Payment Date field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		    	                 blnFlag=false;
		    	          }
		    	          
		    	          Thread.sleep(2000);
		    	          if(cnf.FnExplicitWait("XPATH", mbo.PayNowButton,driver)){
		    	                 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(mbo.PayNowButton)));   
		    	                 repfn.FnUpdateTestStepResHTML("Verify Pay Now button is displayed","Pay Now button is displayed","PASS",runManagerInfoObj);
		    	                 WebElement PayNowButton=driver.findElement(By.xpath(mbo.PayNowButton));
		    	                 //cnf.ScrollToView(PayNowButton);
		    	                 if(PayNowButton.isEnabled()){
		    	                       repfn.FnUpdateTestStepResHTML("Verify Pay Now button is enabled","Pay Now button is enabled.","PASS",runManagerInfoObj);
		    	                       if(cnf.JSClick(PayNowButton,driver)){
		    	                              repfn.FnUpdateTestStepResHTML("Verify Pay Now button is clicked","Pay Now button is clicked.","PASS",runManagerInfoObj);
		    	                              
		    	                              Thread.sleep(5000);
		    	                              
		    	                              if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentPageOne,driver)){
		    	                                     WebElement VerifyPaymentPageOne=driver.findElement(By.xpath(mbo.VerifyPaymentPageOne));
		    	                                     if(VerifyPaymentPageOne.getText().contains("Verify Payment Information")){
		    	                                            repfn.FnUpdateTestStepResHTML("Verify User is navigated to Verify Payment page","User is navigated to Verify Payment page","PASS",runManagerInfoObj);
		    	                                            
		    	                                            if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentPage_CardNumber,driver)){
		    	                                                   WebElement VerifyPaymentPage_CardNumber=driver.findElement(By.xpath(mbo.VerifyPaymentPage_CardNumber));
		    	                                                   if(VerifyPaymentPage_CardNumber.getAttribute("textContent").contains(cardNumber)){
		    	                                                          repfn.FnUpdateTestStepResHTML("Verify Correct Card Number is displayed","Correct Card Number is displayed","PASS",runManagerInfoObj);
		    	                                                          blnFlag=true;
		    	                                                   }
		    	                                                   else{
		    	                                                          repfn.FnUpdateTestStepResHTML("Verify Correct Card Number is displayed","Correct Card Number is not displayed","FAIL",runManagerInfoObj);
		    	                                                          blnFlag=false;
		    	                                                          
		    	                                                   }
		    	                                            }
		    	                                            else{
		    	                                                   repfn.FnUpdateTestStepResHTML("Verify Correct Card Number is displayed","Correct Card Number is not displayed","FAIL",runManagerInfoObj);
		    	                                                          blnFlag=false;
		    	                                            }
		    	                                            
		    	                                            if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentPageOne_ExpirationDate,driver)){
		    	                                                   WebElement VerifyPaymentPageOne_ExpirationDate=driver.findElement(By.xpath(mbo.VerifyPaymentPageOne_ExpirationDate));
		    	                                                   if(VerifyPaymentPageOne_ExpirationDate.getAttribute("textContent").contains(expirationDate)){
		    	                                                          repfn.FnUpdateTestStepResHTML("Verify Correct Expiration Date is displayed","Correct Expiration Date is displayed","PASS",runManagerInfoObj);
		    	                                                          blnFlag=true;
		    	                                                   }
		    	                                                   else{
		    	                                                          repfn.FnUpdateTestStepResHTML("Verify Correct Expiration Date is displayed","Correct Expiration Date is not displayed","FAIL",runManagerInfoObj);
		    	                                                          blnFlag=false;
		    	                                                          
		    	                                                   }
		    	                                            }
		    	                                            else{
		    	                                                   repfn.FnUpdateTestStepResHTML("Verify Correct Expiration Date is displayed","Correct Expiration Date is not displayed","FAIL",runManagerInfoObj);
		    	                                                          blnFlag=false;
		    	                                            }
		    	                                            
		    	                                            if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentPageOne_PaymentAmount,driver)){
		    	                                                   WebElement VerifyPaymentPageOne_PaymentAmount=driver.findElement(By.xpath(mbo.VerifyPaymentPageOne_PaymentAmount));
		    	                                                   if(VerifyPaymentPageOne_PaymentAmount.getAttribute("textContent").contains(paymentAmount)){
		    	                                                          repfn.FnUpdateTestStepResHTML("Verify Correct Payment Amount is displayed","Correct Payment Amount is displayed","PASS",runManagerInfoObj);
		    	                                                          blnFlag=true;
		    	                                                   }
		    	                                                   else{
		    	                                                          repfn.FnUpdateTestStepResHTML("Verify Correct Payment Amount is displayed","Correct Payment Amount is not displayed","FAIL",runManagerInfoObj);
		    	                                                          blnFlag=false;
		    	                                                          
		    	                                                   }
		    	                                            }
		    	                                            else{
		    	                                                   repfn.FnUpdateTestStepResHTML("Verify Correct Payment Amount is displayed","Correct Payment Amount is not displayed","FAIL",runManagerInfoObj);
		    	                                                          blnFlag=false;
		    	                                            }
		    	                                            
		    	                                            if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentPageOne_PaymentDate,driver)){
		    	                                                   WebElement VerifyPaymentPageOne_PaymentDate=driver.findElement(By.xpath(mbo.VerifyPaymentPageOne_PaymentDate));
		    	                                                   System.out.println(VerifyPaymentPageOne_PaymentDate.getAttribute("textContent"));
		    	                                                   if(VerifyPaymentPageOne_PaymentDate.getAttribute("textContent").contains(paymentDate)){
		    	                                                          repfn.FnUpdateTestStepResHTML("Verify Correct Payment Date is displayed","Correct Payment Date is displayed","PASS",runManagerInfoObj);
		    	                                                          blnFlag=true;
		    	                                                   }
		    	                                                   else{
		    	                                                          repfn.FnUpdateTestStepResHTML("Verify Correct Payment Date is displayed","Correct Payment Date is not displayed","FAIL",runManagerInfoObj);
		    	                                                          blnFlag=false;
		    	                                                          
		    	                                                   }
		    	                                            }
		    	                                            else{
		    	                                                   repfn.FnUpdateTestStepResHTML("Verify Correct Payment Date is displayed","Correct Payment Date is not displayed","FAIL",runManagerInfoObj);
		    	                                                          blnFlag=false;
		    	                                            }
		    	                                            
		    	                                            if(cnf.FnExplicitWait("XPATH", mbo.EditPaymentDetailsLink,driver)){
		    	                                                   repfn.FnUpdateTestStepResHTML("Verify Edit Payment Details link is displayed","Edit Payment Details link is displayed","PASS",runManagerInfoObj);
		    	                                                   WebElement EditPaymentDetailsLink=driver.findElement(By.xpath(mbo.EditPaymentDetailsLink));
		    	                                                   if(cnf.JSClick(EditPaymentDetailsLink,driver)){
		    	                                                          repfn.FnUpdateTestStepResHTML("Verify Edit Payment Details link is clicked","Edit Payment Details link is clicked","PASS",runManagerInfoObj);
		    	                                                          
		    	                                                          Thread.sleep(5000);
		    	                                                          
		    	                                                          if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader,driver)){
		    	                                                                 repfn.FnUpdateTestStepResHTML("Verify User is navigated back to Pay Bill page","User is navigated back to Pay Bill page","PASS",runManagerInfoObj);
		    	                                                                 
		    	                                                                 if(cnf.FnExplicitWait("XPATH", mbo.CardNumber,driver)){
		    	                                                                       WebElement VerifyPaymentPage_CardNumber=driver.findElement(By.xpath(mbo.CardNumber));
		    	                                                                        if(VerifyPaymentPage_CardNumber.getAttribute("value").equalsIgnoreCase(cardNumberOne)){
		    	                                                                              repfn.FnUpdateTestStepResHTML("Verify Previously entered Card Number is pre-populated in Card Number field",
		    	                                                                                            "Previously entered Card Number is pre-populated in Card Number field","PASS",runManagerInfoObj);
		    	                                                                              blnFlag=true;
		    	                                                                       }
		    	                                                                       else{
		    	                                                                              repfn.FnUpdateTestStepResHTML("Verify Previously entered Card Number is pre-populated in Card Number field",
		    	                                                                                            "Previously entered Card Number is not pre-populated in Card Number field","FAIL",runManagerInfoObj);
		    	                                                                              blnFlag=false;
		    	                                                                       }
		    	                                                                 }
		    	                                                                 else{
		    	                                                                        repfn.FnUpdateTestStepResHTML("Verify Card Number field is displayed","Card Number field is not displayed","FAIL",runManagerInfoObj);
		    	                                                                       blnFlag=false;
		    	                                                                 }
		    	                                                                 
		    	                                                                 if(cnf.FnExplicitWait("XPATH", mbo.ExpirationDate,driver)){
		    	                                                                       WebElement VerifyPaymentPageOne_ExpirationDate=driver.findElement(By.xpath(mbo.ExpirationDate));
		    	                                                                        if(VerifyPaymentPageOne_ExpirationDate.getAttribute("value").equalsIgnoreCase(expirationDate)){
		    	                                                                              repfn.FnUpdateTestStepResHTML("Verify Previously entered Expiration Date is pre-populated in Expiration Date field",
		    	                                                                                            "Previously entered Expiration Date is pre-populated in Expiration Date field","PASS",runManagerInfoObj);
		    	                                                                              blnFlag=true;
		    	                                                                       }
		    	                                                                       else{
		    	                                                                              repfn.FnUpdateTestStepResHTML("Verify Previously entered Expiration Date is pre-populated in Expiration Date field",
		    	                                                                                            "Previously entered Expiration Date is not pre-populated in Expiration Date field","FAIL",runManagerInfoObj);
		    	                                                                              blnFlag=false;
		    	                                                                       }
		    	                                                                 }
		    	                                                                 else{
		    	                                                                        repfn.FnUpdateTestStepResHTML("Verify Expiration Date field is displayed","Expiration Date field is not displayed","FAIL",runManagerInfoObj);
		    	                                                                       blnFlag=false;
		    	                                                                 }
		    	                                                                 
		    	                                                                 if(cnf.FnExplicitWait("XPATH", mbo.PaymentAmount,driver)){
		    	                                                                       WebElement PaymentAmount=driver.findElement(By.xpath(mbo.PaymentAmount));
		    	                                                                        if(PaymentAmount.getAttribute("value").equalsIgnoreCase(paymentAmount)){
		    	                                                                              repfn.FnUpdateTestStepResHTML("Verify Previously entered Payment Amount is pre-populated in Payment Amount field",
		    	                                                                                            "Previously entered Payment Amount is pre-populated in Payment Amount field","PASS",runManagerInfoObj);
		    	                                                                              blnFlag=true;
		    	                                                                       }
		    	                                                                       else{
		    	                                                                              repfn.FnUpdateTestStepResHTML("Verify Previously entered Payment Amount is pre-populated in Payment Amount field",
		    	                                                                                            "Previously entered Payment Amount is not pre-populated in Payment Amount field","FAIL",runManagerInfoObj);
		    	                                                                              blnFlag=false;
		    	                                                                       }
		    	                                                                 }
		    	                                                                 else{
		    	                                                                        repfn.FnUpdateTestStepResHTML("Verify Payment Amount field is displayed","Payment Amount field is not displayed","FAIL",runManagerInfoObj);
		    	                                                                       blnFlag=false;
		    	                                                                 }
		    	                                                                 
		    	                                                                 if(cnf.FnExplicitWait("XPATH", mbo.PaymentDate,driver)){
		    	                                                                       WebElement PaymentDate=driver.findElement(By.xpath(mbo.PaymentDate));
		    	                                                                        if(PaymentDate.getAttribute("value").equalsIgnoreCase(paymentDateOne)){
		    	                                                                              repfn.FnUpdateTestStepResHTML("Verify Previously entered Payment Date is pre-populated in Payment Date field",
		    	                                                                                            "Previously entered Payment Date is pre-populated in Payment Date field","PASS",runManagerInfoObj);
		    	                                                                              blnFlag=true;
		    	                                                                       }
		    	                                                                       else{
		    	                                                                              repfn.FnUpdateTestStepResHTML("Verify Previously entered Payment Date is pre-populated in Payment Date field",
		    	                                                                                            "Previously entered Payment Date is not pre-populated in Payment Date field","FAIL",runManagerInfoObj);
		    	                                                                              blnFlag=false;
		    	                                                                       }
		    	                                                                 }
		    	                                                                 else{
		    	                                                                        repfn.FnUpdateTestStepResHTML("Verify Payment Date field is displayed","Payment Date field is not displayed","FAIL",runManagerInfoObj);
		    	                                                                       blnFlag=false;
		    	                                                                 }
		    	                                                                 
		    	                                                                 
		    	                                                          }
		    	                                                          else{
		    	                                                                 repfn.FnUpdateTestStepResHTML("Verify User is navigated back to Pay Bill page","User is not navigated back to Pay Bill page","FAIL",runManagerInfoObj);
		    	                                                                 blnFlag=false;
		    	                                                          }
		    	                                                          
		    	                                                   }
		    	                                                   else{
		    	                                                          repfn.FnUpdateTestStepResHTML("Verify Edit Payment Details link is clicked","Edit Payment Details link is not clicked","FAIL",runManagerInfoObj);
		    	                                                          blnFlag=false;
		    	                                                   }
		    	                                            }
		    	                                            else{
		    	                                                   repfn.FnUpdateTestStepResHTML("Verify Edit Payment Details link is displayed","Edit Payment Details link is not displayed","FAIL",runManagerInfoObj);
		    	                                                   blnFlag=false;
		    	                                            }
		    	                                            
		    	                                     }
		    	                                     else{
		    	                                            repfn.FnUpdateTestStepResHTML("Verify User is navigated to Verify Payment page","User is not navigated to Verify Payment page","FAIL",runManagerInfoObj);
		    	                                            blnFlag=false;
		    	                                     }
		    	                              }
		    	                       }
		    	                       else{
		    	                              repfn.FnUpdateTestStepResHTML("Verify Pay Now button is clicked","Pay Now button is not clicked.","FAIL",runManagerInfoObj);
		    	                              blnFlag=false;
		    	                       }
		    	                 }
		    	                 else{
		    	                       repfn.FnUpdateTestStepResHTML("Verify Pay Now button is enabled","Pay Now button is not enabled","FAIL",runManagerInfoObj);
		    	                       blnFlag=false;
		    	                 }
		    	          }
		    	          else{
		    	                 repfn.FnUpdateTestStepResHTML("Verify Pay Now button is displayed","Pay Now button is not displayed","FAIL",runManagerInfoObj);
		    	                 blnFlag=false;
		    	          }
		    	          
		    	          driver.switchTo().defaultContent();
		    	          
		    	          Thread.sleep(5000);
		    	          if(cnf.FnExplicitWait("XPATH", mbo.ViewStatementsLink,driver)){
		    	                 repfn.FnUpdateTestStepResHTML("Verify View Statements Link is displayed","View Statements Link is displayed","PASS",runManagerInfoObj);
		    	                 WebElement ViewStatementsLink=driver.findElement(By.xpath(mbo.ViewStatementsLink));
		    	                 if(cnf.JSClick(ViewStatementsLink,driver)){
		    	                       repfn.FnUpdateTestStepResHTML("Verify View Statements Link is clicked","View Statements Link is clicked","PASS",runManagerInfoObj);
		    	                       WebElement ConfirmCancel=driver.findElement(By.xpath(mbo.ConfirmCancel));
		    	                              if(cnf.FnExplicitWait("XPATH", mbo.ConfirmCancel,driver)){
		    	                                     repfn.FnUpdateTestStepResHTML("Verify Confirm Navigation pop-up is displayed", "Confirm Navigation pop-up is displayed","PASS",runManagerInfoObj);
		    	                                     cnf.JSClick(ConfirmCancel,driver);
		    	                                     repfn.FnUpdateTestStepResHTML("Verify Navigation to View Statements page", "Navigation to View Statements page is done","PASS",runManagerInfoObj);
		    	                                     Thread.sleep(5000);
		    	                                     blnFlag=true;
		    	                              }
		    	                              else{
		    	                                     repfn.FnUpdateTestStepResHTML("Verify Confirm Navigation pop-up is displayed", "Confirm Navigation pop-up is not displayed","FAIL",runManagerInfoObj);
		    	                                     blnFlag=false;
		    	                              }
		    	                       
		    	                 }
		    	                 else{
		    	                       repfn.FnUpdateTestStepResHTML("Verify View Statements Link is clicked","View Statements Link is not clicked","FAIL",runManagerInfoObj);
		    	                       blnFlag=false;
		    	                 }
		    	                 
		    	                 
		    	          }
		    	          else{
		    	                 repfn.FnUpdateTestStepResHTML("Verify View Statements Link is displayed","View Statements Link is not displayed","FAIL",runManagerInfoObj);
		    	                 blnFlag=false;
		    	          }
		    	          
		    	   }
		    	   
		    	   catch (Exception e)

		    	   {
		    	          repfn.FnUpdateTestStepResHTML("Verify User is able to verify Pay Bill informatio",
		    	                       "User is able to verify Pay Bill information due to some exception","FAIL",runManagerInfoObj);

		    	   blnFlag=false;
		    	          System.err.println("Message : "+e.getMessage());
		    	          System.err.println("Cause : "+e.getCause());
		    	          
		    	   }
		    	   m1.put("STEPSTATUS", blnFlag);
		    	   return blnFlag;
		    	   
		    	  }
		       public synchronized boolean FnEnterPaymentAmount(WebDriver driver, RunManagerInfo runManagerInfoObj){
		          	
		       	  
		        	String validPaymentAmount = "1";
		        
		        
		        	boolean errorStatusThree = false;
		        	
		        	try{
		        		
		        		driver.switchTo().frame("iFrameResizer0");
		        		
		        		if(cnf.FnExplicitWait("XPATH", mbo.PaymentAmount,driver)){
		        			repfn.FnUpdateTestStepResHTML("Verify Payment Amount field is displayed under Payment Information option",
		          					"Payment Amount Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
		        			WebElement PaymentAmount=driver.findElement(By.xpath(mbo.PaymentAmount));
		        		
		        			
		        			PaymentAmount.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),validPaymentAmount);
		        			repfn.FnUpdateTestStepResHTML("Verify Payment Amount is entered","Payment Amount entered:$ " +validPaymentAmount ,"PASS",runManagerInfoObj);
		        			
		        			if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader,driver)){
		        				WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
		            			cnf.JSClick(PaymentInformationHeader,driver);
		        			}
		        			else{
		        				repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
		        				blnFlag=false;
		        			}
		        			
		        			
		        			
		        			
		        		}
		        		else{
		        			repfn.FnUpdateTestStepResHTML("Verify Payment Amount field is displayed under Payment Information option",
		          					"Payment Amount field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		        			blnFlag=false;
		        		}
		        		
		        		driver.switchTo().defaultContent();
		        		
		        	
		        	}
		       	
		       	catch (Exception e)

		     		{
		     			repfn.FnUpdateTestStepResHTML("Verify User is able to verify invalid Payment Amount entered",
		     					"User is not able to verify invalid Payment Amount entered due to some exception","FAIL",runManagerInfoObj);

		     	      	 blnFlag=false;
		     			System.err.println("Message : "+e.getMessage());
		     			System.err.println("Cause : "+e.getCause());
		     			
		     		}
		     		m1.put("STEPSTATUS", blnFlag);
		     		return blnFlag;
		       	
		       }
		       public synchronized boolean Fn_VerifyPaymentDateField_PreviousDate(WebDriver driver, RunManagerInfo runManagerInfoObj){
		       
		          Date d=Calendar.getInstance().getTime();
		    
		          SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		          
		          String currentDate=sdf.format(d);
		          
		          String dateArray[]=currentDate.split("/");
		          String year=dateArray[0];
		          String month=dateArray[1];
		          String day=dateArray[2];
		       
		         
		          int previousday=Integer.parseInt(day)-1;
		           
		    	   String PreviousPaymentDate = (month)+"/"+previousday+"/"+year;
		    	   String PreviousPaymentDateChrome = (month)+"/"+previousday;
		       		
		    	  
		       	
		       	try{
		       		
		       		driver.switchTo().frame("iFrameResizer0");
		       		
		       		if(cnf.FnExplicitWait("XPATH", mbo.PaymentDate,driver)){
		       			repfn.FnUpdateTestStepResHTML("Verify Payment Date field is displayed under Payment Information option",
		         					"Payment Amount Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
		       			WebElement PaymentDate=driver.findElement(By.xpath(mbo.PaymentDate));
		       		
		       			String Browser=m1.get("BROWSER").toString();
		       			System.out.println("Browser is:   "+Browser);
		       		if(Browser.equalsIgnoreCase("chrome"))
		       		{
		       			PaymentDate.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),PreviousPaymentDateChrome,Keys.TAB);
		       			repfn.FnUpdateTestStepResHTML("Verify Previuos Payment Date is entered","Payment date entered: " +PreviousPaymentDateChrome ,"PASS",runManagerInfoObj);
		       			
		       			
		       		}else {
		       			PaymentDate.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),PreviousPaymentDate);
		       			repfn.FnUpdateTestStepResHTML("Verify Previuos Payment Date is entered","Payment date entered: " +PreviousPaymentDate ,"PASS",runManagerInfoObj);
		       		}
		       		
		       			
		       			if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader,driver)){
		       				WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
		           			cnf.JSClick(PaymentInformationHeader,driver);
		       			}
		       			else{
		       				repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
		       				blnFlag=false;
		       			}
		       			
		    				
		       			
		       		}
		       		else{
		       			repfn.FnUpdateTestStepResHTML("Verify Payment Date field is displayed under Payment Information option",
		         					"Payment Date field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		       			blnFlag=false;
		       		}
		       		
		       		driver.switchTo().defaultContent();
		       		
		       		
		       	}
		      	
		      	catch (Exception e)

		    		{
		    			repfn.FnUpdateTestStepResHTML("Verify User is able to verify blank Payment date",
		    					"User is not able to verify blank Payment date due to some exception","FAIL",runManagerInfoObj);

		    	      	 blnFlag=false;
		    			System.err.println("Message : "+e.getMessage());
		    			System.err.println("Cause : "+e.getCause());
		    			
		    		}
		    		m1.put("STEPSTATUS", blnFlag);
		    		return blnFlag;
		      	
		        	
		        }
		       
		       public synchronized boolean FnVerifyPayBill_Button(WebDriver driver, RunManagerInfo runManagerInfoObj){
		          	
		          	try{
		          		
		          		driver.switchTo().frame("iFrameResizer0");
		          		Thread.sleep(2000);
		          		if(cnf.FnExplicitWait("XPATH", mbo.PayNowButton,driver)){
		          			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(mbo.PayNowButton)));   
		          			repfn.FnUpdateTestStepResHTML("Verify Pay Now button is displayed","Pay Now button is displayed","PASS",runManagerInfoObj);
		          			WebElement PayNowButton=driver.findElement(By.xpath(mbo.PayNowButton));
		          			//cnf.ScrollToView(PayNowButton);
		          			if(PayNowButton.isEnabled()){
		          				repfn.FnUpdateTestStepResHTML("Verify Pay Now button is enabled","Pay Now button is enabled.","PASS",runManagerInfoObj);
		          				
		          				blnFlag=true;
		          			}
		          			else{
		          				repfn.FnUpdateTestStepResHTML("Verify Pay Now button is enabled","Pay Now button is not enabled","FAIL",runManagerInfoObj);
		          				blnFlag=false;
		          			}
		          		}
		          		else{
		          			repfn.FnUpdateTestStepResHTML("Verify Pay Now button is displayed","Pay Now button is not displayed","FAIL",runManagerInfoObj);
		          			blnFlag=false;
		          		}
		          		
		          		
		          		driver.switchTo().defaultContent();
		          		
		          		
		          		
		          	}
		          	
		          	catch (Exception e)

		        		{
		        			repfn.FnUpdateTestStepResHTML("Verify User is able to verify Pay Now button on Pay Bill page",
		        					"User is able to verify Pay Now button on Pay Bill page due to some exception","FAIL",runManagerInfoObj);

		        	      	 blnFlag=false;
		        			System.err.println("Message : "+e.getMessage());
		        			System.err.println("Cause : "+e.getCause());
		        			
		        		}
		        		m1.put("STEPSTATUS", blnFlag);
		        		return blnFlag;
		          }
		       public synchronized boolean FnEnterValidCardDetails(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
		    		
		    		String validCardNumber = "5555555555555557";
		    		String validExpirationDate = "12/2016";
		    		
		    		
		    		try{
		    			
		    			driver.switchTo().frame("iFrameResizer0");
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.CardNumber,driver)){
		    				repfn.FnUpdateTestStepResHTML("Verify Card Number field is displayed","Card Number field is displayed","PASS",runManagerInfoObj);
		    				WebElement CardNumber=driver.findElement(By.xpath(mbo.CardNumber));
		    				CardNumber.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),validCardNumber);
		    				repfn.FnUpdateTestStepResHTML("Verify valid Card Number is entered","Valid Card Number is entered: "+validCardNumber,"PASS",runManagerInfoObj);
		    				
		    				if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader,driver)){
		    					WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
		    					cnf.JSClick(PaymentInformationHeader,driver);
		    					blnFlag=true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    				
		    				
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Card Number field is displayed","Card Number field is not displayed","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.ExpirationDate,driver)){
		    				repfn.FnUpdateTestStepResHTML("Verify Expiration Date field is displayed","Expiration Date field is displayed","PASS",runManagerInfoObj);
		    				WebElement ExpirationDate=driver.findElement(By.xpath(mbo.ExpirationDate));
		    				ExpirationDate.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),validExpirationDate);
		    				repfn.FnUpdateTestStepResHTML("Verify Expiration Date is entered","Expiration Date is entered: "+validExpirationDate,"PASS",runManagerInfoObj);
		    				
		    				if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader,driver)){
		    					WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
		    					cnf.JSClick(PaymentInformationHeader,driver);
		    					blnFlag=true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    				
		    				
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Expiration Date field is displayed","Expiration Date field is not displayed","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			driver.switchTo().defaultContent();
		    		}
		    		
		    		catch (Exception e)

		    		{
		    			repfn.FnUpdateTestStepResHTML("Verify User is able to verify Pay Bill information",
		    					"User is able to verify Pay Bill information due to some exception","FAIL",runManagerInfoObj);

		    	      	 blnFlag=false;
		    			System.err.println("Message : "+e.getMessage());
		    			System.err.println("Cause : "+e.getCause());
		    			
		    		}
		    		m1.put("STEPSTATUS", blnFlag);
		    		return blnFlag;
		    		
		    	}
		       public synchronized boolean FnClickPayBillButton_ConfirmNavigation(WebDriver driver, RunManagerInfo runManagerInfoObj){
		          	
		          	try{
		          		
		          		driver.switchTo().frame("iFrameResizer0");
		          		Thread.sleep(2000);
		          		if(cnf.FnExplicitWait("XPATH", mbo.PayNowButton,driver)){
		          			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(mbo.PayNowButton)));   
		          			repfn.FnUpdateTestStepResHTML("Verify Pay Now button is displayed","Pay Now button is displayed","PASS",runManagerInfoObj);
		          			WebElement PayNowButton=driver.findElement(By.xpath(mbo.PayNowButton));
		          			//cnf.ScrollToView(PayNowButton);
		          			if(PayNowButton.isEnabled()){
		          				repfn.FnUpdateTestStepResHTML("Verify Pay Now button is enabled","Pay Now button is enabled.","PASS",runManagerInfoObj);
		          				if(cnf.JSClick(PayNowButton,driver)){
		          					repfn.FnUpdateTestStepResHTML("Verify Pay Now button is clicked or not","Pay Now button is clicked.","PASS",runManagerInfoObj);
		          					Thread.sleep(2000);
		          	          		 if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentPageOne,driver)){
		          	                     WebElement VerifyPaymentPageOne=driver.findElement(By.xpath(mbo.VerifyPaymentPageOne));
		          	                     if(VerifyPaymentPageOne.getText().contains("Verify Payment Information")){
		          	                            repfn.FnUpdateTestStepResHTML("Verify User is navigated to Verify Payment page","User is navigated to Verify Payment page as title displayed as: "+VerifyPaymentPageOne.getText(),"PASS",runManagerInfoObj);
		          	                            blnFlag=true;
		          	                     }
		          	     
		          	                     else{
		          	                            repfn.FnUpdateTestStepResHTML("Verify User is navigated to Verify Payment page","User is not navigated to Verify Payment page","FAIL",runManagerInfoObj);
		          	                            blnFlag=false;
		          	                     }
		          	          		 }else{
		          	          			repfn.FnUpdateTestStepResHTML("Verify Payment Information title is getting displayed","Payment Information title is not getting displayed","FAIL",runManagerInfoObj);
		          	                    blnFlag=false;
		          	          		 }
		          				}
		          				else{
		          					repfn.FnUpdateTestStepResHTML("Verify Pay Now button is clicked or not","Pay Now button is not clicked.","FAIL",runManagerInfoObj);
		          					blnFlag=true;
		          				}
		          			
		          			}
		          			else{
		          				repfn.FnUpdateTestStepResHTML("Verify Pay Now button is not enabled","Pay Now button is not enabled","FAIL",runManagerInfoObj);
		          				blnFlag=false;
		          			}
		          		}
		          		else{
		          			repfn.FnUpdateTestStepResHTML("Verify Pay Now button is displayed","Pay Now button is not displayed","FAIL",runManagerInfoObj);
		          			blnFlag=false;
		          		}
		          		
		          		
		          		driver.switchTo().defaultContent();
		          		
		          		Thread.sleep(5000);
		          		if(cnf.FnExplicitWait("XPATH", mbo.ViewStatementsLink,driver)){
		          			repfn.FnUpdateTestStepResHTML("Verify View Statements Link is displayed","View Statements Link is displayed","PASS",runManagerInfoObj);
		          			WebElement ViewStatementsLink=driver.findElement(By.xpath(mbo.ViewStatementsLink));
		          			if(cnf.JSClick(ViewStatementsLink,driver)){
		          				repfn.FnUpdateTestStepResHTML("Verify View Statements Link is clicked","View Statements Link is clicked","PASS",runManagerInfoObj);
		          				WebElement ConfirmCancel=driver.findElement(By.xpath(mbo.ConfirmCancel));
		   						if(cnf.FnExplicitWait("XPATH", mbo.ConfirmCancel,driver)){
		   							repfn.FnUpdateTestStepResHTML("Verify Confirm Navigation pop-up is displayed", "Confirm Navigation pop-up is displayed","PASS",runManagerInfoObj);
		   							cnf.JSClick(ConfirmCancel,driver);
		   							repfn.FnUpdateTestStepResHTML("Verify Navigation to View Statements page", "Navigation to View Statements page is done","PASS",runManagerInfoObj);
		   							Thread.sleep(5000);
		   							blnFlag=true;
		   						}
		   						else{
		   							repfn.FnUpdateTestStepResHTML("Verify Confirm Navigation pop-up is displayed", "Confirm Navigation pop-up is not displayed","FAIL",runManagerInfoObj);
		   							blnFlag=false;
		   						}
		          				
		          			}
		          			else{
		          				repfn.FnUpdateTestStepResHTML("Verify View Statements Link is clicked","View Statements Link is not clicked","FAIL",runManagerInfoObj);
		          				blnFlag=false;
		          			}
		          			
		          			
		          		}
		          		else{
		          			repfn.FnUpdateTestStepResHTML("Verify View Statements Link is displayed","View Statements Link is not displayed","FAIL",runManagerInfoObj);
		          			blnFlag=false;
		          		}
		          		
		          		 
		          	}
		          	
		          	catch (Exception e)

		        		{
		        			repfn.FnUpdateTestStepResHTML("Verify User is able to verify Pay Now button on Pay Bill page",
		        					"User is able to verify Pay Now button on Pay Bill page due to some exception","FAIL",runManagerInfoObj);

		        	      	 blnFlag=false;
		        			System.err.println("Message : "+e.getMessage());
		        			System.err.println("Cause : "+e.getCause());
		        			
		        		}
		        		m1.put("STEPSTATUS", blnFlag);
		        		return blnFlag;
		          }
		       
		       public synchronized boolean fnCreditOrDebitErrorMessageinvalidExpirationDate(WebDriver driver, RunManagerInfo runManagerInfoObj)
		       {
		       	String invalidExpDate = "11/2010";
		       	try
		       	{

		       		driver.switchTo().frame("iFrameResizer0");
		       		if(cnf.FnExplicitWait("ID", mbo.billingExpirationDate,driver))
		       		{
		       			repfn.FnUpdateTestStepResHTML("Verify if Expiration Date field is present","Expiration Date field is present","PASS",runManagerInfoObj);
		       			WebElement billingExpirationDate=driver.findElement(By.id(mbo.billingExpirationDate));
		       			billingExpirationDate.sendKeys(invalidExpDate,Keys.TAB);
		       			repfn.FnUpdateTestStepResHTML("Verify if User has entered the Expiry Date","User has entered the Expiry Date: "+invalidExpDate,"PASS",runManagerInfoObj);



		       			if(cnf.FnExplicitWait("XPATH", mbo.errorMessageForExpirationDate,driver))
		       			{
		       				WebElement errorMessageForExpirationDate=driver.findElement(By.xpath(mbo.errorMessageForExpirationDate));
		       				repfn.FnUpdateTestStepResHTML("Verify if Error message is displayed for incorrect Expiry Date","Error message is displayed for incorrect Expiry Date: "+errorMessageForExpirationDate.getText(),"PASS",runManagerInfoObj);
		       				blnFlag=true;
		       			}
		       			else{
		       				blnFlag=false;
		       				repfn.FnUpdateTestStepResHTML("Verify if Error message is displayed for incorrect Expiry Date","Error message is not displayed for incorrect Expiry Date","FAIL",runManagerInfoObj);
		       			}
		       		}
		       		else
		       		{
		       			blnFlag=false;
		       			repfn.FnUpdateTestStepResHTML("Verify if Expiration Date field is present","Expiration Date field is not present","FAIL",runManagerInfoObj);
		       		}

		       		driver.switchTo().defaultContent();

		       	}
		       	catch (Exception e)

		       	{		
		       		blnFlag=false;
		       		repfn.FnUpdateTestStepResHTML("Verify if user is displayed with error message for incorrect expiration date","User is not displayed with error message for incorrect expiration date due to some exception","FAIL",runManagerInfoObj);
		       		System.err.println("Message : "+e.getMessage());
		       		System.err.println("Cause : "+e.getCause());
		       	}

		       	m1.put("STEPSTATUS", blnFlag);
		       	return blnFlag;
		       }
		       public synchronized boolean FnPaymentAmountFieldValidation(WebDriver driver, RunManagerInfo runManagerInfoObj){


		    		String invalidPaymentAmountOne = "1a%1@";
		    		String invalidPaymentAmountTwo = "0";
		    		String invalidPaymentAmountThree = "30000";
		    		String errorMessage = "";
		    		String errorStatusMsg = "Please enter an amount between $1 and $25000.";
		    		boolean errorStatusOne = false;
		    		boolean errorStatusTwo = false;
		    		boolean errorStatusThree = false;

		    		try{

		    			driver.switchTo().frame("iFrameResizer0");

		    			if(cnf.FnExplicitWait("XPATH", mbo.PaymentAmount,driver)){
		    				repfn.FnUpdateTestStepResHTML("Verify Payment Amount field is displayed under Payment Information option",
		    						"Payment Amount Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
		    				WebElement PaymentAmount=driver.findElement(By.xpath(mbo.PaymentAmount));
		    				PaymentAmount.sendKeys(invalidPaymentAmountOne,Keys.TAB);
		    				repfn.FnUpdateTestStepResHTML("Verify Payment Amount is entered","Payment Amount: " +invalidPaymentAmountOne + "is entered","PASS",runManagerInfoObj);

		    	/*			if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader)){
		    					WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
		    					cnf.JSClick(PaymentInformationHeader);
		    					blnFlag=true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}*/



		    				if(cnf.FnExplicitWait("XPATH", mbo.PaymentAmountError,driver)){
		    					WebElement PaymentAmountError=driver.findElement(By.xpath(mbo.PaymentAmountError));
		    					errorMessage = PaymentAmountError.getAttribute("textContent");
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed","Payment Amount Error Message is displayed:  " +errorMessage,"PASS",runManagerInfoObj);
		    					blnFlag=true; 
		    					errorStatusOne = true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed",
		    							"Payment Amount Error Message is not displayed when this number is entered: " +invalidPaymentAmountOne,"FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}

		    				Thread.sleep(2000);

		    				PaymentAmount.clear();
		    				PaymentAmount.sendKeys(invalidPaymentAmountTwo);
		    				repfn.FnUpdateTestStepResHTML("Verify Payment Amount is entered","Payment Amount:  " +invalidPaymentAmountTwo + "is entered","PASS",runManagerInfoObj);

		    	/*			if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader)){
		    					WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
		    					cnf.JSClick(PaymentInformationHeader);
		    					blnFlag=true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}*/

		    				if(cnf.FnExplicitWait("XPATH", mbo.PaymentAmountError,driver)){
		    					WebElement PaymentAmountError=driver.findElement(By.xpath(mbo.PaymentAmountError));
		    					errorMessage = PaymentAmountError.getAttribute("textContent");
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed","Payment Amount Error Message is displayed:  " +errorMessage,"PASS",runManagerInfoObj);
		    					blnFlag=true;   
		    					errorStatusTwo = true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed",
		    							"Payment Amount Error Message is not displayed when this number is entered: " +invalidPaymentAmountTwo,"FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}

		    				Thread.sleep(2000);

		    				PaymentAmount.clear();
		    				PaymentAmount.sendKeys(invalidPaymentAmountThree);
		    				repfn.FnUpdateTestStepResHTML("Verify Payment Amount is entered","Payment Amount: " +invalidPaymentAmountThree + "is entered","PASS",runManagerInfoObj);

		    	/*			if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader)){
		    					WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
		    					cnf.JSClick(PaymentInformationHeader);
		    					blnFlag=true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}*/

		    				if(cnf.FnExplicitWait("XPATH", mbo.PaymentAmountError,driver)){
		    					WebElement PaymentAmountError=driver.findElement(By.xpath(mbo.PaymentAmountError));
		    					errorMessage = PaymentAmountError.getAttribute("textContent");
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed","Payment Amount Error Message is displayed:  " +errorMessage,"PASS",runManagerInfoObj);
		    					blnFlag=true;  
		    					errorStatusThree = true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed",
		    							"Payment Amount Error Message is not displayed when this number is entered: " +invalidPaymentAmountThree,"FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}

		    				if(errorStatusOne && errorStatusTwo && errorStatusThree){
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed for all the three invalid Payment Amounts entered",
		    							"Payment Amount Error Message is displayed for all the three invalid Payment Amounts entered","PASS",runManagerInfoObj);
		    					blnFlag=true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed for all the three invalid Payment Amounts entered",
		    							"Payment Amount Error Message is not displayed for all the three invalid Payment Amounts entered","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}

		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Payment Amount field is displayed under Payment Information option",
		    						"Payment Amount field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}

		    			driver.switchTo().defaultContent();


		    		}

		    		catch (Exception e)

		    		{
		    			repfn.FnUpdateTestStepResHTML("Verify User is able to verify invalid Payment Amount entered",
		    					"User is not able to verify invalid Payment Amount entered due to some exception","FAIL",runManagerInfoObj);

		    			blnFlag=false;
		    			System.err.println("Message : "+e.getMessage());
		    			System.err.println("Cause : "+e.getCause());

		    		}
		    		m1.put("STEPSTATUS", blnFlag);
		    		return blnFlag;

		    	}
		    	 
		       public synchronized boolean FnVerify_PayBillButtonDisabled(WebDriver driver, RunManagerInfo runManagerInfoObj){
		          	
		          	try{
		          		
		          		driver.switchTo().frame("iFrameResizer0");
		          		Thread.sleep(2000);
		          		if(cnf.FnExplicitWait("XPATH", mbo.PayNowButton,driver)){
		          			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(mbo.PayNowButton)));   
		          			repfn.FnUpdateTestStepResHTML("Verify Pay Now button is displayed","Pay Now button is displayed","PASS",runManagerInfoObj);
		          			WebElement PayNowButton=driver.findElement(By.xpath(mbo.PayNowButton));
		          			//cnf.ScrollToView(PayNowButton);
		          			if(PayNowButton.isEnabled()){
		          				repfn.FnUpdateTestStepResHTML("Verify Pay Now button is not enabled","Pay Now button is  enabled.","FAIL",runManagerInfoObj);
		          				
		          				blnFlag=false;
		          			}
		          			else{
		          				repfn.FnUpdateTestStepResHTML("Verify Pay Now button is not enabled","Pay Now button is not enabled","PASS",runManagerInfoObj);
		          				blnFlag=true;
		          			}
		          		}
		          		else{
		          			repfn.FnUpdateTestStepResHTML("Verify Pay Now button is displayed","Pay Now button is not displayed","FAIL",runManagerInfoObj);
		          			blnFlag=false;
		          		}
		          		
		          		
		          		driver.switchTo().defaultContent();
		          		
		          		Thread.sleep(5000);
		          		if(cnf.FnExplicitWait("XPATH", mbo.ViewStatementsLink,driver)){
		          			repfn.FnUpdateTestStepResHTML("Verify View Statements Link is displayed","View Statements Link is displayed","PASS",runManagerInfoObj);
		          			WebElement ViewStatementsLink=driver.findElement(By.xpath(mbo.ViewStatementsLink));
		          			if(cnf.JSClick(ViewStatementsLink,driver)){
		          				repfn.FnUpdateTestStepResHTML("Verify View Statements Link is clicked","View Statements Link is clicked","PASS",runManagerInfoObj);
		          			
		   						if(cnf.FnExplicitWait("XPATH", mbo.ConfirmCancel,driver)){
		   							WebElement ConfirmCancel=driver.findElement(By.xpath(mbo.ConfirmCancel));
		   							repfn.FnUpdateTestStepResHTML("Verify Confirm Navigation pop-up is displayed", "Confirm Navigation pop-up is displayed","PASS",runManagerInfoObj);
		   							cnf.JSClick(ConfirmCancel,driver);
		   							repfn.FnUpdateTestStepResHTML("Verify Navigation to View Statements page", "Navigation to View Statements page is done","PASS",runManagerInfoObj);
		   							Thread.sleep(5000);
		   							blnFlag=true;
		   						}
		   						else{
		   							repfn.FnUpdateTestStepResHTML("Verify Confirm Navigation pop-up is displayed", "Confirm Navigation pop-up is not displayed","FAIL",runManagerInfoObj);
		   							blnFlag=false;
		   						}
		          				
		          			}
		          			else{
		          				repfn.FnUpdateTestStepResHTML("Verify View Statements Link is clicked","View Statements Link is not clicked","FAIL",runManagerInfoObj);
		          				blnFlag=false;
		          			}
		          			
		          			
		          		}
		          		else{
		          			repfn.FnUpdateTestStepResHTML("Verify View Statements Link is displayed","View Statements Link is not displayed","FAIL",runManagerInfoObj);
		          			blnFlag=false;
		          		}
		          		
		          		
		          	}
		          	
		          	catch (Exception e)

		        		{
		        			repfn.FnUpdateTestStepResHTML("Verify User is able to verify Pay Now button on Pay Bill page",
		        					"User is able to verify Pay Now button on Pay Bill page due to some exception","FAIL",runManagerInfoObj);

		        	      	 blnFlag=false;
		        			System.err.println("Message : "+e.getMessage());
		        			System.err.println("Cause : "+e.getCause());
		        			
		        		}
		        		m1.put("STEPSTATUS", blnFlag);
		        		return blnFlag;
		          }
		      
		       public synchronized boolean FnVerifyCreditBalanceDue(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
		    		try{
		    			if(cnf.FnExplicitWait("XPATH", mbo.CurrentBalanceDueText_ViewStatements,driver)){
		    				repfn.FnUpdateTestStepResHTML("Verify Current Balance Due is displayed on View Stataments page", "Current Balance Due is displayed on View Stataments page", "PASS",runManagerInfoObj);
		    				
		    				if(cnf.FnExplicitWait("XPATH", mbo.CurrentBalanceDueAmount_ViewStatements,driver)){
		    					WebElement CurrentBalanceDueAmount_ViewStatements=driver.findElement(By.xpath(mbo.CurrentBalanceDueAmount_ViewStatements));
		    					String Amount = CurrentBalanceDueAmount_ViewStatements.getText();
		    					if(Amount.equalsIgnoreCase("$0.00")){
		    						repfn.FnUpdateTestStepResHTML("Verify Current Balance Due Amount is displayed on View Stataments page", "Current Balance Due Amount displayed on View Stataments page is: "+Amount+". Hence, no credit amount is due", "FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Current Balance Due Amount is displayed on View Stataments page", "Current Balance Due Amount displayed on View Stataments page is: "+Amount, "PASS",runManagerInfoObj);
		    						blnFlag=true;
		    					}
		    				}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Current Balance Due is displayed on View Stataments page", "Current Balance Due is not displayed on View Stataments page", "FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    		}
		    		
		    		catch(Exception e)
		    		{
		    			blnFlag=false;
		    			repfn.FnUpdateTestStepResHTML("Verify Due Date is displayed on Overview page", "Due Date is not displayed on Overview page due to some exception", "FAIL",runManagerInfoObj);
		    			System.err.println("Message : "+e.getMessage());
		    			System.err.println("Cause : "+e.getCause());
		    		}
		    		m1.put("STEPSTATUS", blnFlag);
		    		return blnFlag;
		    	}
		       public synchronized boolean FnVerifyPayBillUI(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
		    		
		    		try{
		    			
		    			driver.switchTo().frame("iFrameResizer0");
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_PayBillOptionsText,driver)){
		    				WebElement PayBill_PayBillOptionsText=driver.findElement(By.xpath(mbo.PayBill_PayBillOptionsText));
		    				if(PayBill_PayBillOptionsText.getAttribute("textContent").contains("Pay Bill Options")){
		    					repfn.FnUpdateTestStepResHTML("Verify Pay Bill Options Header text is displayed", "Pay Bill Options Header text is displayed","PASS",runManagerInfoObj);
		    					blnFlag=true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Pay Bill Options Header text is displayed", "Pay Bill Options Header text is not displayed","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Pay Bill Options Header text is displayed", "Pay Bill Options Header text is not displayed","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_SelectPaymentTypeText,driver)){
		    				WebElement PayBill_SelectPaymentTypeText=driver.findElement(By.xpath(mbo.PayBill_SelectPaymentTypeText));
		    				if(PayBill_SelectPaymentTypeText.getAttribute("textContent").contains("Select Payment Type")){
		    					repfn.FnUpdateTestStepResHTML("Verify Select Payment Type text is displayed under Pay Bill Options Header", 
		    							"Select Payment Type text is displayed under Pay Bill Options Header","PASS",runManagerInfoObj);
		    					blnFlag=true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Select Payment Type text is displayed under Pay Bill Options Header", 
		    							"Select Payment Type text is not displayed under Pay Bill Options Header","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Select Payment Type text is displayed under Pay Bill Options Header", 
		    						"Select Payment Type text is not displayed under Pay Bill Options Header","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_Credit_Debit_Text,driver)){
		    				WebElement PayBill_Credit_Debit_Text=driver.findElement(By.xpath(mbo.PayBill_Credit_Debit_Text));
		    				if(PayBill_Credit_Debit_Text.getAttribute("textContent").contains("Credit/Debit Card")){
		    					repfn.FnUpdateTestStepResHTML("Verify Credit/Debit Card sub-option is displayed under Select Payment Type Option", 
		    							"Credit/Debit Card sub-option is displayed under Select Payment Type Option","PASS",runManagerInfoObj);

		    					if(cnf.FnExplicitWait("XPATH", mbo.PayBill_Credit_Debit,driver)){
		    						repfn.FnUpdateTestStepResHTML("Verify Credit/Debit Card Radio button is displayed under Select Payment Type option",
		    								"Credit/Debit Card Radio button is displayed under Select Payment Type option","PASS",runManagerInfoObj);
		    						WebElement PayBill_Credit_Debit=driver.findElement(By.xpath(mbo.PayBill_Credit_Debit));

		    						if(cnf.isElementExistOne("XPATH", mbo.PayBill_Credit_Debit_Selection,driver)){
		    							WebElement PayBill_Credit_Debit_Selection=driver.findElement(By.xpath(mbo.PayBill_Credit_Debit_Selection));
		    							String selectionState = PayBill_Credit_Debit_Selection.getAttribute("aria-checked");

		    							if(selectionState.equalsIgnoreCase("true")){
		    								repfn.FnUpdateTestStepResHTML("Verify Credit/Debit radio button is selected by default", 
		    										"Credit/Debit radio button is selected by default","PASS",runManagerInfoObj);
		    								blnFlag=true;
		    							}
		    							else{
		    								if(cnf.JSClick(PayBill_Credit_Debit,driver)){
		    									repfn.FnUpdateTestStepResHTML("Verify Credit/Debit Radio button is clicked under Select Payment Frequency option",
		    											"Credit/Debit Radio button is clicked under Select Payment Type option","PASS",runManagerInfoObj);
		    									blnFlag=true;
		    								}
		    								else{
		    									repfn.FnUpdateTestStepResHTML("Verify Credit/Debit Radio button is clicked under Select Payment Frequency option",
		    											"Credit/Debit Radio button is not clicked under Select Payment Type option","FAIL",runManagerInfoObj);
		    									blnFlag=false;
		    								}
		    							}
		    						}
		    						else{
		    							blnFlag=false;
		    						}
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Credit/Debit Card Radio button is displayed under Select Payment Type option",
		    								"Credit/Debit Card Radio button is not displayed under Select Payment Type option","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Credit/Debit Card sub-option is displayed under Select Payment Type Option", 
		    							"Credit/Debit Card sub-option is not displayed under Select Payment Type Option","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Credit/Debit Card sub-option is displayed under Select Payment Type Option", 
		    						"Credit/Debit Card sub-option is not displayed under Select Payment Type Option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_Checking_Savings_Text,driver)){
		    				WebElement PayBill_Checking_Savings_Text=driver.findElement(By.xpath(mbo.PayBill_Checking_Savings_Text));
		    				if(PayBill_Checking_Savings_Text.getAttribute("textContent").contains("Checking/Savings")){
		    					repfn.FnUpdateTestStepResHTML("Verify Checking/Savings sub-option is displayed under Select Payment Type Option", 
		    							"Checking/Savings sub-option is displayed under Select Payment Type Option","PASS",runManagerInfoObj);
		    					blnFlag=true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Checking/Savings sub-option is displayed under Select Payment Type Option", 
		    							"Checking/Savings sub-option is not displayed under Select Payment Type Option","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Checking/Savings sub-option is displayed under Select Payment Type Option", 
		    						"Checking/Savings sub-option is not displayed under Select Payment Type Option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_OtherPaymentMethods_Text,driver)){
		    				WebElement PayBill_OtherPaymentMethods_Text=driver.findElement(By.xpath(mbo.PayBill_OtherPaymentMethods_Text));
		    				if(PayBill_OtherPaymentMethods_Text.getAttribute("textContent").contains("Other Payment Methods")){
		    					repfn.FnUpdateTestStepResHTML("Verify Other Payment Methods sub-option is displayed under Select Payment Type Option", 
		    							"Other Payment Methods sub-option is displayed under Select Payment Type Option","PASS",runManagerInfoObj);
		    					blnFlag=true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Other Payment Methods sub-option is displayed under Select Payment Type Option", 
		    							"Other Payment Methods sub-option is not displayed under Select Payment Type Option","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Other Payment Methods sub-option is displayed under Select Payment Type Option", 
		    						"Other Payment Methods sub-option is not displayed under Select Payment Type Option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_SelectPaymentFrequencyText,driver)){
		    				WebElement PayBill_SelectPaymentFrequencyText=driver.findElement(By.xpath(mbo.PayBill_SelectPaymentFrequencyText));
		    				if(PayBill_SelectPaymentFrequencyText.getAttribute("textContent").contains("Select Payment Frequency")){
		    					repfn.FnUpdateTestStepResHTML("Verify Select Payment Frequency text is displayed under Pay Bill Options Header", 
		    							"Select Payment Frequency text is displayed under Pay Bill Options Header","PASS",runManagerInfoObj);
		    					blnFlag=true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Select Payment Frequency text is displayed under Pay Bill Options Header", 
		    							"Select Payment Frequency text is not displayed under Pay Bill Options Header","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Select Payment Frequency text is displayed under Pay Bill Options Header", 
		    						"Select Payment Frequency text is not displayed under Pay Bill Options Header","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PaymentFrequency_AutoPay_Text,driver)){
		    				WebElement PaymentFrequency_AutoPay_Text=driver.findElement(By.xpath(mbo.PaymentFrequency_AutoPay_Text));
		    				if(PaymentFrequency_AutoPay_Text.getAttribute("textContent").contains("Auto-Pay (Recurring)")){
		    					repfn.FnUpdateTestStepResHTML("Verify Auto-Pay (Recurring) sub-option is displayed under Select Payment Frequency Option", 
		    							"Auto-Pay (Recurring) sub-option is displayed under Select Payment Frequency Option","PASS",runManagerInfoObj);
		    					blnFlag=true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Auto-Pay (Recurring) sub-option is displayed under Select Payment Frequency Option", 
		    							"Auto-Pay (Recurring) sub-option is not displayed under Select Payment Frequency Option","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Auto-Pay (Recurring) sub-option is displayed under Select Payment Frequency Option", 
		    						"Auto-Pay (Recurring) sub-option is not displayed under Select Payment Frequency Option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PaymentFrequency_OneTime_Text,driver)){
		    				WebElement PaymentFrequency_OneTime_Text=driver.findElement(By.xpath(mbo.PaymentFrequency_OneTime_Text));
		    				if(PaymentFrequency_OneTime_Text.getAttribute("textContent").contains("One-Time")){
		    					repfn.FnUpdateTestStepResHTML("Verify One-Time sub-option is displayed under Select Payment Frequency Option", 
		    							"One-Time sub-option is displayed under Select Payment Frequency Option","PASS",runManagerInfoObj);

		    					if(cnf.FnExplicitWait("XPATH", mbo.PaymentFrequency_OneTime,driver)){
		    						repfn.FnUpdateTestStepResHTML("Verify One Time Radio button is displayed under Select Payment Frequency option",
		    								"One Time Radio button is displayed under Select Payment Type option","PASS",runManagerInfoObj);
		    						WebElement PaymentFrequency_OneTime=driver.findElement(By.xpath(mbo.PaymentFrequency_OneTime));

		    						if(cnf.isElementExistOne("XPATH", mbo.PaymentFrequency_OneTime_Selection,driver)){
		    							WebElement PaymentFrequency_OneTime_Selection=driver.findElement(By.xpath(mbo.PaymentFrequency_OneTime_Selection));
		    							String selectionState = PaymentFrequency_OneTime_Selection.getAttribute("aria-checked");

		    							if(selectionState.equalsIgnoreCase("true")){
		    								repfn.FnUpdateTestStepResHTML("Verify One-Time radio button is selected by default", 
		    										"One-Time radio button is selected by default","PASS",runManagerInfoObj);
		    								blnFlag=true;
		    							}
		    							else{
		    								if(cnf.JSClick(PaymentFrequency_OneTime,driver)){
		    									repfn.FnUpdateTestStepResHTML("Verify One Time Radio button is clicked under Select Payment Frequency option",
		    											"One Time Radio button is clicked under Select Payment Type option","PASS",runManagerInfoObj);
		    									blnFlag=true;
		    								}
		    								else{
		    									repfn.FnUpdateTestStepResHTML("Verify One Time Radio button is clicked under Select Payment Frequency option",
		    											"One Time Radio button is not clicked under Select Payment Type option","FAIL",runManagerInfoObj);
		    									blnFlag=false;
		    								}
		    							}
		    						}
		    						else{
		    							blnFlag=false;
		    						}
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify One Time Radio button is displayed under Select Payment Frequency option",
		    								"One Time Radio button is not displayed under Select Payment Type option","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify One-Time sub-option is displayed under Select Payment Frequency Option", 
		    							"One-Time sub-option is not displayed under Select Payment Frequency Option","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify One-Time sub-option is displayed under Select Payment Frequency Option", 
		    						"One-Time sub-option is not displayed under Select Payment Frequency Option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader,driver)){
		    				WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
		    				if(PaymentInformationHeader.getAttribute("textContent").contains("Payment Information")){
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Information Header text is displayed", "Payment Information Header text is displayed","PASS",runManagerInfoObj);
		    					blnFlag=true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Information Header text is displayed", "Payment Information Header text is not displayed","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Payment Information Header text is displayed", "Payment Information Header text is not displayed","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_Credit_DebitCard_Text,driver)){
		    				WebElement PayBill_Credit_DebitCard_Text=driver.findElement(By.xpath(mbo.PayBill_Credit_DebitCard_Text));
		    				if(PayBill_Credit_DebitCard_Text.getAttribute("textContent").contains("Credit/Debit Card")){
		    					repfn.FnUpdateTestStepResHTML("Verify Credit/Debit Card text is displayed under Payment Information Header", 
		    							"Credit/Debit Card text is displayed under Payment Information Header","PASS",runManagerInfoObj);
		    					blnFlag=true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Credit/Debit Card text is displayed under Payment Information Header", 
		    							"Credit/Debit Card text is not displayed under Payment Information Header","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Credit/Debit Card text is displayed under Payment Information Header", 
		    						"Credit/Debit Card text is not displayed under Payment Information Header","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CardNumber_Text,driver)){
		    				WebElement PayBill_CardNumber_Text=driver.findElement(By.xpath(mbo.PayBill_CardNumber_Text));
		    				if(PayBill_CardNumber_Text.getAttribute("textContent").contains("Card Number")){
		    					repfn.FnUpdateTestStepResHTML("Verify Card Number sub-heading is displayed under Credit/Debit Card Option", 
		    							"Card Number sub-heading is displayed under Credit/Debit Card Option","PASS",runManagerInfoObj);
		    					
		    					if(cnf.FnExplicitWait("XPATH", mbo.CardNumber,driver)){
		    						repfn.FnUpdateTestStepResHTML("Verify Card Number input field is displayed under Card Number sub-heading", 
		    								"Card Number input field is displayed under Card Number sub-heading","PASS",runManagerInfoObj);
		    						blnFlag=true;
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Card Number input field is displayed under Card Number sub-heading", 
		    								"Card Number input field is not displayed under Card Number sub-heading","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    						
		    					}
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Card Number sub-heading is displayed under Credit/Debit Card Option", 
		    							"Card Number sub-heading is not displayed under Credit/Debit Card Option","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Card Number sub-heading is displayed under Credit/Debit Card Option", 
		    						"Card Number sub-heading is not displayed under Credit/Debit Card Option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_ExpirationDate_Text,driver)){
		    				WebElement PayBill_ExpirationDate_Text=driver.findElement(By.xpath(mbo.PayBill_ExpirationDate_Text));
		    				if(PayBill_ExpirationDate_Text.getAttribute("textContent").contains("Expiration Date")){
		    					repfn.FnUpdateTestStepResHTML("Verify Expiration Date sub-heading is displayed under Credit/Debit Card Option", 
		    							"Expiration Date sub-heading is displayed under Credit/Debit Card Option","PASS",runManagerInfoObj);
		    					
		    					if(cnf.FnExplicitWait("XPATH", mbo.ExpirationDate,driver)){
		    						repfn.FnUpdateTestStepResHTML("Verify Expiration Date input field is displayed under Expiration Date sub-heading", 
		    								"Expiration Date input field is displayed under Expiration Date sub-heading","PASS",runManagerInfoObj);
		    						blnFlag=true;
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Expiration Date input field is displayed under Expiration Date sub-heading", 
		    								"Expiration Date input field is not displayed under Expiration Date sub-heading","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    						
		    					}
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Expiration Date sub-heading is displayed under Credit/Debit Card Option", 
		    							"Expiration Date sub-heading is not displayed under Credit/Debit Card Option","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Expiration Date sub-heading is displayed under Credit/Debit Card Option", 
		    						"Expiration Date sub-heading is not displayed under Credit/Debit Card Option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_AmountAndDate_Text,driver)){
		    				WebElement PayBill_AmountAndDate_Text=driver.findElement(By.xpath(mbo.PayBill_AmountAndDate_Text));
		    				if(PayBill_AmountAndDate_Text.getAttribute("textContent").contains("Amount & Date")){
		    					repfn.FnUpdateTestStepResHTML("Verify Amount & Date text is displayed under Payment Information Header", 
		    							"Amount & Date text is displayed under Payment Information Header","PASS",runManagerInfoObj);
		    					blnFlag=true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Amount & Date text is displayed under Payment Information Header", 
		    							"Amount & Date text is not displayed under Payment Information Header","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Amount & Date text is displayed under Payment Information Header", 
		    						"Amount & Date text is not displayed under Payment Information Header","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_AmountDue_Text,driver)){
		    				WebElement PayBill_AmountDue_Text=driver.findElement(By.xpath(mbo.PayBill_AmountDue_Text));
		    				if(PayBill_AmountDue_Text.getAttribute("textContent").contains("Amount Due")){
		    					repfn.FnUpdateTestStepResHTML("Verify Amount Due text is displayed under Amount & Date Option", 
		    							"Amount Due text is displayed under Amount & Date Option","PASS",runManagerInfoObj);
		    					blnFlag=true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Amount Due text is displayed under Amount & Date Option", 
		    							"Amount Due text is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Amount Due text is displayed under Amount & Date Option", 
		    						"Amount Due text is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_AmountDue,driver)){
		    				WebElement PayBill_AmountDue=driver.findElement(By.xpath(mbo.PayBill_AmountDue));
		    					repfn.FnUpdateTestStepResHTML("Verify Amount Due is displayed under Amount & Date Option", 
		    							"Amount Due: "+PayBill_AmountDue.getText()+" is displayed under Amount & Date Option","PASS",runManagerInfoObj);
		    					blnFlag=true;
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Amount Due is displayed under Amount & Date Option", 
		    						"Amount Due is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_DueBy_Text,driver)){
		    				WebElement PayBill_DueBy_Text=driver.findElement(By.xpath(mbo.PayBill_DueBy_Text));
		    				if(PayBill_DueBy_Text.getAttribute("textContent").contains("Due By")){
		    					repfn.FnUpdateTestStepResHTML("Verify Due By text is displayed under Amount & Date Option", 
		    							"Due By text is displayed under Amount & Date Option","PASS",runManagerInfoObj);
		    					blnFlag=true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Due By text is displayed under Amount & Date Option", 
		    							"Due By text is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Due By text is displayed under Amount & Date Option", 
		    						"Due By text is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_DueByDate,driver)){
		    				WebElement PayBill_DueByDate=driver.findElement(By.xpath(mbo.PayBill_DueByDate));
		    					repfn.FnUpdateTestStepResHTML("Verify Amount Due Date is displayed under Amount & Date Option", 
		    							"Amount Due Date: "+PayBill_DueByDate.getText()+" is displayed under Amount & Date Option","PASS",runManagerInfoObj);
		    					blnFlag=true;
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Amount Due Date is displayed under Amount & Date Option", 
		    						"Amount Due Date is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_PaymentAmount_Text,driver)){
		    				WebElement PayBill_PaymentAmount_Text=driver.findElement(By.xpath(mbo.PayBill_PaymentAmount_Text));
		    				if(PayBill_PaymentAmount_Text.getAttribute("textContent").contains("Payment Amount")){
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Amount sub-heading is displayed under Amount & Date Option", 
		    							"Payment Amount sub-heading is displayed under Amount & Date Option","PASS",runManagerInfoObj);
		    					
		    					if(cnf.FnExplicitWait("XPATH", mbo.PaymentAmount,driver)){
		    						repfn.FnUpdateTestStepResHTML("Verify Payment Amount input field is displayed under Payment Amount sub-heading", 
		    								"Payment Amount input field is displayed under Payment Amount sub-heading","PASS",runManagerInfoObj);
		    						blnFlag=true;
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Payment Amount input field is displayed under Payment Amount sub-heading", 
		    								"Payment Amount input field is not displayed under Payment Amount sub-heading","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    						
		    					}
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Amount sub-heading is displayed under Amount & Date Option", 
		    							"Payment Amount sub-heading is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Payment Amount sub-heading is displayed under Amount & Date Option", 
		    						"Payment Amount sub-heading is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_PaymentDate_Text,driver)){
		    				WebElement PayBill_PaymentDate_Text=driver.findElement(By.xpath(mbo.PayBill_PaymentDate_Text));
		    				if(PayBill_PaymentDate_Text.getAttribute("textContent").contains("Payment Date")){
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Date sub-heading is displayed under Amount & Date Option", 
		    							"Payment Date sub-heading is displayed under Amount & Date Option","PASS",runManagerInfoObj);
		    					
		    					if(cnf.FnExplicitWait("XPATH", mbo.PaymentDate,driver)){
		    						repfn.FnUpdateTestStepResHTML("Verify Payment Date input field is displayed under Payment Date sub-heading", 
		    								"Payment Date input field is displayed under Payment Date sub-heading","PASS",runManagerInfoObj);
		    						blnFlag=true;
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Payment Date input field is displayed under Payment Date sub-heading", 
		    								"Payment Date input field is not displayed under Payment Date sub-heading","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    						
		    					}
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Date sub-heading is displayed under Amount & Date Option", 
		    							"Payment Date sub-heading is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Payment Date sub-heading is displayed under Amount & Date Option", 
		    						"Payment Date sub-heading is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			driver.switchTo().defaultContent();

		    		}
		    		
		    		catch(Exception e)
		    		{
		    			blnFlag=false;
		    			repfn.FnUpdateTestStepResHTML("Verify User is able to verify UI on Pay Bill page", "User is not able to verify UI on Pay Bill page due to some exception", "FAIL",runManagerInfoObj);
		    			System.err.println("Message : "+e.getMessage());
		    			System.err.println("Cause : "+e.getCause());
		    		}
		    		m1.put("STEPSTATUS", blnFlag);
		    		return blnFlag;
		    	}
		       public synchronized boolean FnVerifyAndClickViewStatementsLink(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
		    		try{
		    			if(cnf.FnExplicitWait("XPATH", mbo.ViewStatementsLink,driver)){
		    	   			repfn.FnUpdateTestStepResHTML("Verify View Statements Link is displayed","View Statements Link is displayed","PASS",runManagerInfoObj);
		    	   			WebElement ViewStatementsLink=driver.findElement(By.xpath(mbo.ViewStatementsLink));
		    	   			if(cnf.JSClick(ViewStatementsLink,driver)){
		    	   				repfn.FnUpdateTestStepResHTML("Verify View Statements Link is clicked","View Statements Link is clicked","PASS",runManagerInfoObj);
		    	   				
		    	   				Thread.sleep(5000);
		    	   				
		    					if(cnf.FnExplicitWait("XPATH",mbo.PageVerificationOne,driver)){
		    						WebElement PageVerificationOne=driver.findElement(By.xpath(mbo.PageVerificationOne));
		    						if(PageVerificationOne.getAttribute("textContent").equalsIgnoreCase("Billing")){
		    							if(cnf.FnExplicitWait("XPATH",mbo.PageVerificationTwo,driver)){
		    								WebElement PageVerificationTwo=driver.findElement(By.xpath(mbo.PageVerificationTwo));
		    								if(PageVerificationTwo.getAttribute("textContent").equalsIgnoreCase("View Statements")){
		    									repfn.FnUpdateTestStepResHTML("Verify User is navigated to View Statements page", "User is navigated to View Statements page","PASS",runManagerInfoObj);
		    									blnFlag	=true;
		    								}
		    								else{
		    									repfn.FnUpdateTestStepResHTML("Verify User is navigated to View Statements page", "User is not navigated to View Statements page","FAIL",runManagerInfoObj);
		    									blnFlag	=false;
		    								}
		    							}
		    						}
		    						else{
		    							repfn.FnUpdateTestStepResHTML("Verify User is navigated to Manage Users page", "User is not navigated to Manage Users page","FAIL",runManagerInfoObj);
		    							blnFlag	=false;
		    						}	
		    					}
		    	   				
		    	   			}
		    	   			else{
		    	   				repfn.FnUpdateTestStepResHTML("Verify View Statements Link is clicked","View Statements Link is not clicked","FAIL",runManagerInfoObj);
		    	   				blnFlag=false;
		    	   			}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify View Statements Link is displayed","View Statements Link is not displayed","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    		}
		    		
		    		catch(Exception e)
		    		{
		    			blnFlag=false;
		    			repfn.FnUpdateTestStepResHTML("Verify User is able to navigate to View Statements page", "User is not able to navigate to View Statements page due to some exception", "FAIL",runManagerInfoObj);
		    			System.err.println("Message : "+e.getMessage());
		    			System.err.println("Cause : "+e.getCause());
		    		}
		    		m1.put("STEPSTATUS", blnFlag);
		    		return blnFlag;
		    	}
		       public synchronized boolean FnVerifyDefaultSelection_PaymentType(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

		    		try{
		    			driver.switchTo().frame("iFrameResizer0");

		    			// Credit/Debit Radio button
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_Credit_Debit,driver)){
		    				repfn.FnUpdateTestStepResHTML("Verify Credit/Debit Card Radio button is displayed under Select Payment Type option",
		    						"Credit/Debit Card Radio button is displayed under Select Payment Type option","PASS",runManagerInfoObj);
		    				WebElement PayBill_Credit_Debit=driver.findElement(By.xpath(mbo.PayBill_Credit_Debit));

		    				if(cnf.isElementExistOne("XPATH", mbo.PayBill_Credit_Debit_Selection,driver)){
		    					WebElement PayBill_Credit_Debit_Selection=driver.findElement(By.xpath(mbo.PayBill_Credit_Debit_Selection));
		    					String selectionState = PayBill_Credit_Debit_Selection.getAttribute("aria-checked");

		    					if(selectionState.equalsIgnoreCase("true")){
		    						repfn.FnUpdateTestStepResHTML("Verify Credit/Debit radio button is selected by default", 
		    								"Credit/Debit radio button is selected by default","PASS",runManagerInfoObj);
		    						blnFlag=true;
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Credit/Debit radio button is selected by default", 
		    								"Credit/Debit radio button is not selected by default","PASS",runManagerInfoObj);
		    						blnFlag=false;
		    					}
		    				}
		    				else{
		    					blnFlag=false;
		    				}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Credit/Debit Card Radio button is displayed under Select Payment Type option",
		    						"Credit/Debit Card Radio button is not displayed under Select Payment Type option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}

		    			driver.switchTo().defaultContent();
		    		}

		    		catch(Exception e)
		    		{
		    			blnFlag=false;
		    			repfn.FnUpdateTestStepResHTML("Verify Credit/Debit option is selected by default on Pay Bill page", "Credit/Debit option is selected by default on Pay Bill page due to some exception", "FAIL",runManagerInfoObj);
		    			System.err.println("Message : "+e.getMessage());
		    			System.err.println("Cause : "+e.getCause());
		    		}
		    		m1.put("STEPSTATUS", blnFlag);
		    		return blnFlag;

		    	}
		       public synchronized boolean FnVerifyAutoPayOption(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
		    		
		    		String disabledState = "";
		    		
		    		try{
		    			
		    			driver.switchTo().frame("iFrameResizer0");
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PaymentFrequency_AutoPayOption,driver)){
		    				repfn.FnUpdateTestStepResHTML("Verify Auto-Pay radio button is displayed on Pay Bill page ", "Auto-Pay radio button is displayed on Pay Bill page", "PASS",runManagerInfoObj);
		    				WebElement PaymentFrequency_AutoPayOption=driver.findElement(By.xpath(mbo.PaymentFrequency_AutoPayOption));
		    				
		    				if(cnf.isElementExistOne("XPATH", mbo.PaymentFrequency_AutoPayOption_Selection,driver)){
		    					WebElement PaymentFrequency_AutoPayOption_Selection=driver.findElement(By.xpath(mbo.PaymentFrequency_AutoPayOption_Selection));
		    					disabledState = PaymentFrequency_AutoPayOption_Selection.getAttribute("disabled");
		    					
		    					if(disabledState.equalsIgnoreCase("disabled")){
		    						repfn.FnUpdateTestStepResHTML("Verify Auto-Pay radio button is disabled", "Auto-Pay radio button is greyed-out and is disabled", "PASS",runManagerInfoObj);
		    						blnFlag=true;
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Auto-Pay radio button is disabled", "Auto-Pay radio button is not disabled", "FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}
		    				}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Auto-Pay radio button is displayed on Pay Bill page ", "Auto-Pay radio button is not displayed on Pay Bill page", "FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			driver.switchTo().defaultContent();
		    		}
		    		
		    		catch(Exception e)
		    		{
		    			blnFlag=false;
		    			repfn.FnUpdateTestStepResHTML("Verify User is able to verify disabled Auto-Pay option for delinquent user", "User is not able to verify disabled Auto-Pay option for delinquent user due to some exception", "FAIL",runManagerInfoObj);
		    			System.err.println("Message : "+e.getMessage());
		    			System.err.println("Cause : "+e.getCause());
		    		}
		    		m1.put("STEPSTATUS", blnFlag);
		    		return blnFlag;
		    	}
		       public synchronized boolean FnVerifyPayBillUI_CreditDebit(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
		    		
		    		try{
		    			
		    			driver.switchTo().frame("iFrameResizer0");
		    			
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_Credit_DebitCard_Text,driver)){
		    				WebElement PayBill_Credit_DebitCard_Text=driver.findElement(By.xpath(mbo.PayBill_Credit_DebitCard_Text));
		    				if(PayBill_Credit_DebitCard_Text.getAttribute("textContent").contains("Credit/Debit Card")){
		    					repfn.FnUpdateTestStepResHTML("Verify Credit/Debit Card title is displayed under Payment Information Header", 
		    							"Credit/Debit Card title is displayed under Payment Information Header","PASS",runManagerInfoObj);
		    					blnFlag=true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Credit/Debit Card title is displayed under Payment Information Header", 
		    							"Credit/Debit Card title is not displayed under Payment Information Header","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Credit/Debit Card title is displayed under Payment Information Header", 
		    						"Credit/Debit Card title is not displayed under Payment Information Header","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CardNumber_Text,driver)){
		    				WebElement PayBill_CardNumber_Text=driver.findElement(By.xpath(mbo.PayBill_CardNumber_Text));
		    				if(PayBill_CardNumber_Text.getAttribute("textContent").contains("Card Number")){
		    					repfn.FnUpdateTestStepResHTML("Verify Card Number sub-heading is displayed under Credit/Debit Card Option", 
		    							"Card Number sub-heading is displayed under Credit/Debit Card Option","PASS",runManagerInfoObj);
		    					
		    					if(cnf.FnExplicitWait("XPATH", mbo.CardNumber,driver)){
		    						repfn.FnUpdateTestStepResHTML("Verify Card Number input field is displayed under Card Number sub-heading", 
		    								"Card Number input field is displayed under Card Number sub-heading","PASS",runManagerInfoObj);
		    						blnFlag=true;
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Card Number input field is displayed under Card Number sub-heading", 
		    								"Card Number input field is not displayed under Card Number sub-heading","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    						
		    					}
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Card Number sub-heading is displayed under Credit/Debit Card Option", 
		    							"Card Number sub-heading is not displayed under Credit/Debit Card Option","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Card Number sub-heading is displayed under Credit/Debit Card Option", 
		    						"Card Number sub-heading is not displayed under Credit/Debit Card Option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_ExpirationDate_Text,driver)){
		    				WebElement PayBill_ExpirationDate_Text=driver.findElement(By.xpath(mbo.PayBill_ExpirationDate_Text));
		    				if(PayBill_ExpirationDate_Text.getAttribute("textContent").contains("Expiration Date")){
		    					repfn.FnUpdateTestStepResHTML("Verify Expiration Date sub-heading is displayed under Credit/Debit Card Option", 
		    							"Expiration Date sub-heading is displayed under Credit/Debit Card Option","PASS",runManagerInfoObj);
		    					
		    					if(cnf.FnExplicitWait("XPATH", mbo.ExpirationDate,driver)){
		    						repfn.FnUpdateTestStepResHTML("Verify Expiration Date input field is displayed under Expiration Date sub-heading", 
		    								"Expiration Date input field is displayed under Expiration Date sub-heading","PASS",runManagerInfoObj);
		    						blnFlag=true;
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Expiration Date input field is displayed under Expiration Date sub-heading", 
		    								"Expiration Date input field is not displayed under Expiration Date sub-heading","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    						
		    					}
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Expiration Date sub-heading is displayed under Credit/Debit Card Option", 
		    							"Expiration Date sub-heading is not displayed under Credit/Debit Card Option","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Expiration Date sub-heading is displayed under Credit/Debit Card Option", 
		    						"Expiration Date sub-heading is not displayed under Credit/Debit Card Option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_AmountAndDate_Text,driver)){
		    				WebElement PayBill_AmountAndDate_Text=driver.findElement(By.xpath(mbo.PayBill_AmountAndDate_Text));
		    				if(PayBill_AmountAndDate_Text.getAttribute("textContent").contains("Amount & Date")){
		    					repfn.FnUpdateTestStepResHTML("Verify Amount & Date title is displayed under Payment Information Header", 
		    							"Amount & Date title is displayed under Payment Information Header","PASS",runManagerInfoObj);
		    					blnFlag=true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Amount & Date title is displayed under Payment Information Header", 
		    							"Amount & Date title is not displayed under Payment Information Header","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Amount & Date title is displayed under Payment Information Header", 
		    						"Amount & Date title is not displayed under Payment Information Header","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_AmountDue_Text,driver)){
		    				WebElement PayBill_AmountDue_Text=driver.findElement(By.xpath(mbo.PayBill_AmountDue_Text));
		    				if(PayBill_AmountDue_Text.getAttribute("textContent").contains("Amount Due")){
		    					repfn.FnUpdateTestStepResHTML("Verify Amount Due text is displayed under Amount & Date Option", 
		    							"Amount Due text is displayed under Amount & Date Option","PASS",runManagerInfoObj);
		    					blnFlag=true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Amount Due text is displayed under Amount & Date Option", 
		    							"Amount Due text is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Amount Due text is displayed under Amount & Date Option", 
		    						"Amount Due text is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_AmountDue,driver)){
		    				WebElement PayBill_AmountDue=driver.findElement(By.xpath(mbo.PayBill_AmountDue));
		    					repfn.FnUpdateTestStepResHTML("Verify Amount Due is displayed under Amount & Date Option", 
		    							"Amount Due: "+PayBill_AmountDue.getText()+" is displayed under Amount & Date Option","PASS",runManagerInfoObj);
		    					String amount=PayBill_AmountDue.getText();
		    					if(cnf.verifyAmountFormat(amount)){
		    						repfn.FnUpdateTestStepResHTML("Verify Amount Due is displayed in valid format $XX.XX", 
		    								"Amount Due is displayed in valid format: "+PayBill_AmountDue.getText()+" is displayed under Amount & Date Option","PASS",runManagerInfoObj);
		    					blnFlag=true;
		    					}else{
		    						repfn.FnUpdateTestStepResHTML("Verify Amount Due is displayed in valid format $XX.XX", 
		    								"Amount Due is not displayed in valid format: "+PayBill_AmountDue.getText()+" is displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    					blnFlag=true;
		    					}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Amount Due is displayed under Amount & Date Option", 
		    						"Amount Due is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_DueBy_Text,driver)){
		    				WebElement PayBill_DueBy_Text=driver.findElement(By.xpath(mbo.PayBill_DueBy_Text));
		    				if(PayBill_DueBy_Text.getAttribute("textContent").contains("Due By")){
		    					repfn.FnUpdateTestStepResHTML("Verify Due By text is displayed under Amount & Date Option", 
		    							"Due By text is displayed under Amount & Date Option","PASS",runManagerInfoObj);
		    					blnFlag=true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Due By text is displayed under Amount & Date Option", 
		    							"Due By text is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Due By text is displayed under Amount & Date Option", 
		    						"Due By text is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_DueByDate,driver)){
		    				WebElement PayBill_DueByDate=driver.findElement(By.xpath(mbo.PayBill_DueByDate));
		    					repfn.FnUpdateTestStepResHTML("Verify Amount Due Date is displayed under Amount & Date Option", 
		    							"Amount Due Date: "+PayBill_DueByDate.getText()+" is displayed under Amount & Date Option","PASS",runManagerInfoObj);
		    					String date=PayBill_DueByDate.getText();
		    					if(cnf.isValidFormat("mm/dd/yy", date)){
		    						repfn.FnUpdateTestStepResHTML("Verify Amount Due Date is displayed under Amount & Date Option in valid format mm/dd/yy", 
		    								"Amount Due Date: "+PayBill_DueByDate.getText()+" is displayed under Amount & Date Option","PASS",runManagerInfoObj);
		    					blnFlag=true;
		    					}else{
		    						repfn.FnUpdateTestStepResHTML("Verify Amount Due Date is displayed under Amount & Date Option in valid format mm/dd/yy", 
		    								"Amount Due Date: "+PayBill_DueByDate.getText()+" is not displayed in valid format","FAIL",runManagerInfoObj);
		    					}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Amount Due Date is displayed under Amount & Date Option", 
		    						"Amount Due Date is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_PaymentAmount_Text,driver)){
		    				WebElement PayBill_PaymentAmount_Text=driver.findElement(By.xpath(mbo.PayBill_PaymentAmount_Text));
		    				if(PayBill_PaymentAmount_Text.getAttribute("textContent").contains("Payment Amount")){
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Amount sub-heading is displayed under Amount & Date Option", 
		    							"Payment Amount sub-heading is displayed under Amount & Date Option","PASS",runManagerInfoObj);
		    					
		    					if(cnf.FnExplicitWait("XPATH", mbo.PaymentAmount,driver)){
		    						repfn.FnUpdateTestStepResHTML("Verify Payment Amount input field is displayed under Payment Amount sub-heading", 
		    								"Payment Amount input field is displayed under Payment Amount sub-heading","PASS",runManagerInfoObj);
		    						blnFlag=true;
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Payment Amount input field is displayed under Payment Amount sub-heading", 
		    								"Payment Amount input field is not displayed under Payment Amount sub-heading","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    						
		    					}
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Amount sub-heading is displayed under Amount & Date Option", 
		    							"Payment Amount sub-heading is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Payment Amount sub-heading is displayed under Amount & Date Option", 
		    						"Payment Amount sub-heading is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_PaymentDate_Text,driver)){
		    				WebElement PayBill_PaymentDate_Text=driver.findElement(By.xpath(mbo.PayBill_PaymentDate_Text));
		    				if(PayBill_PaymentDate_Text.getAttribute("textContent").contains("Payment Date")){
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Date sub-heading is displayed under Amount & Date Option", 
		    							"Payment Date sub-heading is displayed under Amount & Date Option","PASS",runManagerInfoObj);
		    					
		    					if(cnf.FnExplicitWait("XPATH", mbo.PaymentDate,driver)){
		    						repfn.FnUpdateTestStepResHTML("Verify Payment Date input field is displayed under Payment Date sub-heading", 
		    								"Payment Date input field is displayed under Payment Date sub-heading","PASS",runManagerInfoObj);
		    						blnFlag=true;
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Payment Date input field is displayed under Payment Date sub-heading", 
		    								"Payment Date input field is not displayed under Payment Date sub-heading","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    						
		    					}
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Date sub-heading is displayed under Amount & Date Option", 
		    							"Payment Date sub-heading is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Payment Date sub-heading is displayed under Amount & Date Option", 
		    						"Payment Date sub-heading is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			driver.switchTo().defaultContent();

		    		}
		    		
		    		catch(Exception e)
		    		{
		    			blnFlag=false;
		    			repfn.FnUpdateTestStepResHTML("Verify User is able to verify UI on Pay Bill page", "User is not able to verify UI on Pay Bill page due to some exception", "FAIL",runManagerInfoObj);
		    			System.err.println("Message : "+e.getMessage());
		    			System.err.println("Cause : "+e.getCause());
		    		}
		    		m1.put("STEPSTATUS", blnFlag);
		    		return blnFlag;
		    	}
		       public synchronized boolean FnVerifyCreditDebitUI_RequiredFields(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
		    		
		    		try{
		    			
		    			driver.switchTo().frame("iFrameResizer0");
		    			
		    			
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CardNumber_RequiredText,driver)){
		    				WebElement PayBill_CardNumber_RequiredText=driver.findElement(By.xpath(mbo.PayBill_CardNumber_RequiredText));
		    				if(PayBill_CardNumber_RequiredText.getAttribute("class").contains("required")){
		    					repfn.FnUpdateTestStepResHTML("Verify Card Number title is marked as required field (*) under Credit/Debit Card Option", 
		    							"Card Number title is marked as required field (*)","PASS",runManagerInfoObj);
		    					blnFlag=true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Card Number title is marked as required field (*) under Credit/Debit Card Option", 
		    							"Card Number title is not marked as required field (*)","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    					
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Credit/Debit Card title is displayed under Payment Information Header", 
		    						"Credit/Debit Card title is not displayed under Payment Information Header","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_ExpirationDate_RequiredText,driver)){
		    				WebElement PayBill_ExpirationDate_Text=driver.findElement(By.xpath(mbo.PayBill_ExpirationDate_Text));
		    				if(PayBill_ExpirationDate_Text.getAttribute("class").contains("required")){
		    					repfn.FnUpdateTestStepResHTML("Verify Expiration Date title is marked as required field(*) under Credit/Debit Card Option", 
		    							" Expiration Date title is marked as required field(*)","PASS",runManagerInfoObj);
		    					blnFlag=true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Expiration Date title is marked as required field(*) under Credit/Debit Card Option", 
		    							" Expiration Date title is not marked as required field(*)","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}		
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Expiration Date sub-heading is displayed under Credit/Debit Card Option", 
		    						"Expiration Date sub-heading is not displayed under Credit/Debit Card Option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_PaymentAmount_RequiredText,driver)){
		    				WebElement PayBill_PaymentAmount_Text=driver.findElement(By.xpath(mbo.PayBill_PaymentAmount_Text));
		    				if(PayBill_PaymentAmount_Text.getAttribute("class").contains("required")){
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Amount title is marked as required field(*) under Amount & Date Option", 
		    							"Payment Amount title is marked as required field under Amount & Date Option","PASS",runManagerInfoObj);
		    					
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Amount title is marked as required field(*) under Amount & Date Option", 
		    							"Payment Amount title is not marked as required field under Amount & Date Option","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Payment Amount sub-heading is displayed under Amount & Date Option", 
		    						"Payment Amount sub-heading is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_PaymentDate_RequiredText,driver)){
		    				WebElement PayBill_PaymentDate_Text=driver.findElement(By.xpath(mbo.PayBill_PaymentDate_Text));
		    				if(PayBill_PaymentDate_Text.getAttribute("class").contains("required")){
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Date title is marked as required field(*) under Amount & Date Option", 
		    							"Payment Date title is marked as required field(*) under Amount & Date Option","PASS",runManagerInfoObj);
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Date title is marked as required field(*) under Amount & Date Option", 
		    							"Payment Date title is not marked as required field(*) under Amount & Date Option","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Payment Date sub-heading is displayed under Amount & Date Option", 
		    						"Payment Date sub-heading is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			driver.switchTo().defaultContent();

		    		}
		    		
		    		catch(Exception e)
		    		{
		    			blnFlag=false;
		    			repfn.FnUpdateTestStepResHTML("Verify User is able to verify UI on Pay Bill page", "User is not able to verify UI on Pay Bill page due to some exception", "FAIL",runManagerInfoObj);
		    			System.err.println("Message : "+e.getMessage());
		    			System.err.println("Cause : "+e.getCause());
		    		}
		    		m1.put("STEPSTATUS", blnFlag);
		    		return blnFlag;
		    	}
		       public synchronized boolean FnVerifySupportLink_PaymentVerification(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
		    		
		    		String routingNumberOne = "";
		    		String accountNumberOne = "";
		    		String routingNumber = "";
		    		String accountNumber = "";
		    		String paymentAmount = "";
		    		String paymentDate = "";
		    		String paymentDateChrome="";
		    		String month = "";
		    		String day = "";
		    		String year = "";
		    		
		    		try{
		    			
		    	driver.switchTo().frame("iFrameResizer0");
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.RoutingNumber,driver)){
		    				WebElement RoutingNumber=driver.findElement(By.xpath(mbo.RoutingNumber));
		    				routingNumberOne = RoutingNumber.getAttribute("value");	
		    				int length = routingNumberOne.length();
		    				routingNumber = routingNumberOne.substring((length-4));
		    				System.out.println(routingNumber);
		    				blnFlag=true;
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Routing Number field is displayed under Payment Information option",
		    						"Routing Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.BankAccountNumber,driver)){
		    				WebElement BankAccountNumber=driver.findElement(By.xpath(mbo.BankAccountNumber));
		    				accountNumberOne = BankAccountNumber.getAttribute("value");
		    				int length = accountNumberOne.length();
		    				accountNumber = accountNumberOne.substring((length-4));
		    				System.out.println(accountNumber);
		    				blnFlag=true;
		    			} 
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Bank Account Number field is displayed under Payment Information option",
		    						"Bank Account Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PaymentAmount,driver)){
		    				WebElement PaymentAmount=driver.findElement(By.xpath(mbo.PaymentAmount));
		    				paymentAmount = PaymentAmount.getAttribute("value");
		    				blnFlag=true;
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Payment Amount field is displayed under Payment Information option",
		    						"Payment Amount Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PaymentDate,driver)){
		    				WebElement PaymentDate=driver.findElement(By.xpath(mbo.PaymentDate));
		    				String paymentDateOne = PaymentDate.getAttribute("value");
		    				System.out.println(paymentDateOne);

		    				String Browser=m1.get("BROWSER").toString();
		    				System.out.println("Browser is:   "+Browser);
		    				if(Browser.equalsIgnoreCase("chrome"))
		    				{
		    					System.out.println(paymentDateOne);
		    					String two[] = paymentDateOne.split("-");
		    					month = two[1];
		    					day = two[2];
		    					String yearTwo = two[0];
		    					year = yearTwo.substring((2));
		    					paymentDate = month+"/"+day;
		    				}
		    				else{

		    					String[] one = paymentDateOne.split("/");
		    					System.out.println(one.length);
		    					month = one[0];
		    					day = one[1];
		    					String yearOne = one[2];
		    					year = yearOne.substring((2));
		    					paymentDate = month+"/"+day+"/"+year;

		    				}
		    				
		    				
		    						
		    				System.out.println(paymentDate);
		    				blnFlag=true;

		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Payment Date field is displayed under Payment Information option",
		    						"Payment Date field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    	   		Thread.sleep(2000);
		    	   		
		    	   		if(cnf.FnExplicitWait("XPATH", mbo.PayNowButton,driver)){
		    	   			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(mbo.PayNowButton)));   
		    	   			repfn.FnUpdateTestStepResHTML("Verify Pay Now button is displayed","Pay Now button is displayed","PASS",runManagerInfoObj);
		    	   			WebElement PayNowButton=driver.findElement(By.xpath(mbo.PayNowButton));
		    	   			//cnf.ScrollToView(PayNowButton);
		    	   			if(PayNowButton.isEnabled()){
		    	   				repfn.FnUpdateTestStepResHTML("Verify Pay Now button is enabled","Pay Now button is enabled.","PASS",runManagerInfoObj);
		    	   				if(cnf.JSClick(PayNowButton,driver)){
		    	   					repfn.FnUpdateTestStepResHTML("Verify Pay Now button is clicked","Pay Now button is clicked.","PASS",runManagerInfoObj);
		    	   					
		    	   					Thread.sleep(5000);
		    	   					
		    	   					if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentPageOne,driver)){
		    	   						WebElement VerifyPaymentPageOne=driver.findElement(By.xpath(mbo.VerifyPaymentPageOne));
		    	   						if(VerifyPaymentPageOne.getText().contains("Verify Payment Information")){
		    	   							repfn.FnUpdateTestStepResHTML("Verify User is navigated to Verify Payment page","User is navigated to Verify Payment page","PASS",runManagerInfoObj);
		    	   							
		    	   							if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentPage_RoutingNumber,driver)){
		    	   								WebElement VerifyPaymentPage_RoutingNumber=driver.findElement(By.xpath(mbo.VerifyPaymentPage_RoutingNumber));
		    	   								if(VerifyPaymentPage_RoutingNumber.getAttribute("textContent").contains(routingNumber)){
		    	   									repfn.FnUpdateTestStepResHTML("Verify Correct Routing Number is displayed","Correct Routing Number is displayed","PASS",runManagerInfoObj);
		    	   									blnFlag=true;
		    	   								}
		    	   								else{
		    	   									repfn.FnUpdateTestStepResHTML("Verify Correct Routing Number is displayed","Correct Routing Number is not displayed","FAIL",runManagerInfoObj);
		    	   									blnFlag=false;
		    	   									
		    	   								}
		    	   							}
		    	   							else{
		    	   								repfn.FnUpdateTestStepResHTML("Verify Correct Routing Number is displayed","Correct Routing Number is not displayed","FAIL",runManagerInfoObj);
		    										blnFlag=false;
		    	   							}
		    	   							
		    	   							if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentPageOne_AccountNumber,driver)){
		    	   								WebElement VerifyPaymentPageOne_AccountNumber=driver.findElement(By.xpath(mbo.VerifyPaymentPageOne_AccountNumber));
		    	   								if(VerifyPaymentPageOne_AccountNumber.getAttribute("textContent").contains(accountNumber)){
		    	   									repfn.FnUpdateTestStepResHTML("Verify Correct Account Number is displayed","Correct Account Number is displayed","PASS",runManagerInfoObj);
		    	   									blnFlag=true;
		    	   								}
		    	   								else{
		    	   									repfn.FnUpdateTestStepResHTML("Verify Correct Account Number is displayed","Correct Account Number is not displayed","FAIL",runManagerInfoObj);
		    	   									blnFlag=false;
		    	   									
		    	   								}
		    	   							}
		    	   							else{
		    	   								repfn.FnUpdateTestStepResHTML("Verify Correct Account Number is displayed","Correct Account Number is not displayed","FAIL",runManagerInfoObj);
		    										blnFlag=false;
		    	   							}
		    	   							
		    	   							if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentPageOne_PaymentAmount,driver)){
		    	   								WebElement VerifyPaymentPageOne_PaymentAmount=driver.findElement(By.xpath(mbo.VerifyPaymentPageOne_PaymentAmount));
		    	   								if(VerifyPaymentPageOne_PaymentAmount.getAttribute("textContent").contains(paymentAmount)){
		    	   									repfn.FnUpdateTestStepResHTML("Verify Correct Payment Amount is displayed","Correct Payment Amount is displayed","PASS",runManagerInfoObj);
		    	   									blnFlag=true;
		    	   								}
		    	   								else{
		    	   									repfn.FnUpdateTestStepResHTML("Verify Correct Payment Amount is displayed","Correct Payment Amount is not displayed","FAIL",runManagerInfoObj);
		    	   									blnFlag=false;
		    	   									
		    	   								}
		    	   							}
		    	   							else{
		    	   								repfn.FnUpdateTestStepResHTML("Verify Correct Payment Amount is displayed","Correct Payment Amount is not displayed","FAIL",runManagerInfoObj);
		    										blnFlag=false;
		    	   							}
		    	   							
		    	   							if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentPageOne_PaymentDate,driver)){
		    	   								WebElement VerifyPaymentPageOne_PaymentDate=driver.findElement(By.xpath(mbo.VerifyPaymentPageOne_PaymentDate));
		    	   								System.out.println(VerifyPaymentPageOne_PaymentDate.getAttribute("textContent"));
		    	   								if(VerifyPaymentPageOne_PaymentDate.getAttribute("textContent").contains(paymentDate)){
		    	   									repfn.FnUpdateTestStepResHTML("Verify Correct Payment Date is displayed","Correct Payment Date is displayed","PASS",runManagerInfoObj);
		    	   									blnFlag=true;
		    	   								}
		    	   								else{
		    	   									repfn.FnUpdateTestStepResHTML("Verify Correct Payment Date is displayed","Correct Payment Date is not displayed","FAIL",runManagerInfoObj);
		    	   									blnFlag=false;
		    	   									
		    	   								}
		    	   							}
		    	   							else{
		    	   								repfn.FnUpdateTestStepResHTML("Verify Correct Payment Date is displayed","Correct Payment Date is not displayed","FAIL",runManagerInfoObj);
		    										blnFlag=false;
		    	   							}
		    	   							
		    	   							if(cnf.FnExplicitWait("XPATH", mbo.SupportLinkPayBill,driver)){
		    	   			 				 repfn.FnUpdateTestStepResHTML("Verify Support link is displayed on Pay Bill page", "Support link is displayed on Pay Bill page","PASS",runManagerInfoObj);
		    	   			 				 WebElement Support_Link=driver.findElement(By.xpath(mbo.SupportLinkPayBill));
		    	   			 				 ArrayList<String> oldTab = new ArrayList<String>(driver.getWindowHandles());
		    	   			 				 cnf.ScrollToView(Support_Link,driver);

		    	   			 				 if(cnf.JSClick(Support_Link,driver)){
		    	   			 					 repfn.FnUpdateTestStepResHTML("Verify Support Link is clicked", "Support Link is clicked","PASS",runManagerInfoObj);

		    	   			 					 Thread.sleep(5000);
		    	   			 					 if(cnf.isAlertPresent()){
		    	   			 						 driver.switchTo().alert();
		    	   			 						 String ErrMsg=driver.switchTo().alert().getText();
		    	   			 						 System.out.println(ErrMsg);
		    	   			 						 //repfn.FnUpdateTestStepResHTML("verify .... ",".......","PASS/WARNING");// update the reporting function based on your requirement
		    	   			 						 //  blnFlag1=false;
		    	   			 						 driver.switchTo().alert().accept();
		    	   			 						 driver.switchTo().defaultContent();
		    	   			 						 //Thread.sleep(5000);

		    	   			 					 }else{
		    	   			 						 //repfn.FnUpdateTestStepResHTML("verify .... ",".......","PASS/WARNING");// update the reporting function based on your requirement
		    	   			 						 return false;                                                 
		    	   			 					 }


		    	   			 				 }
		    	   			 				 else{
		    	   			 					repfn.FnUpdateTestStepResHTML("Verify Support Link is clicked", "Support Link is not clicked","FAIL",runManagerInfoObj);
		    	   			 					blnFlag=false;
		    	   			 				 }
		    	   			 				 

		    	   			 				 Thread.sleep(5000);

		    	   			 				 ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		    	   			 				 //System.out.println(newTab.size());

		    	   			 				 if(newTab.size() == oldTab.size()){
		    	   			 					 repfn.FnUpdateTestStepResHTML("Verify Support Page is opened in same tab", "Support Page is opened in same tab","PASS",runManagerInfoObj);
		    	   			 					 blnFlag=true;
		    	   			 				 }
		    	   			 				 else{
		    	   			 					 repfn.FnUpdateTestStepResHTML("Verify Support Page is opened in same tab", "Support Page is opened in new tab","FAIL",runManagerInfoObj);
		    	   			 					 blnFlag=false;
		    	   			 				 }

		    	   			 				 
		    	   			 				 if(cnf.FnExplicitWait("XPATH", mbo.SupportPageVerification,driver)){
		    	   			 					 repfn.FnUpdateTestStepResHTML("Verify User is on Support Page", "User is on Support Page","PASS",runManagerInfoObj);
		    	   			 					 blnFlag=true;
		    	   			 				 }
		    	   			 				 else{
		    	   			 					 repfn.FnUpdateTestStepResHTML("Verify User is on Support Page", "User is not on Support Page","FAIL",runManagerInfoObj);
		    	   			 					 blnFlag=false;
		    	   			 				 }


		    	   			 			 }
		    	   			 			 else{
		    	   			 				 repfn.FnUpdateTestStepResHTML("Verify Support link is displayed", "Support link is not displayed","FAIL",runManagerInfoObj);
		    	   			 				 blnFlag=false;
		    	   			 			 }
		    	   							
		    	   						}
		    	   						else{
		    	   							repfn.FnUpdateTestStepResHTML("Verify User is navigated to Verify Payment page","User is not navigated to Verify Payment page","FAIL",runManagerInfoObj);
		    	   							blnFlag=false;
		    	   						}
		    	   					}
		    	   				}
		    	   				else{
		    	   					repfn.FnUpdateTestStepResHTML("Verify Pay Now button is clicked","Pay Now button is not clicked.","FAIL",runManagerInfoObj);
		    	   					blnFlag=false;
		    	   				}
		    	   			}
		    	   			else{
		    	   				repfn.FnUpdateTestStepResHTML("Verify Pay Now button is enabled","Pay Now button is not enabled","FAIL",runManagerInfoObj);
		    	   				blnFlag=false;
		    	   			}
		    	   		}
		    	   		else{
		    	   			repfn.FnUpdateTestStepResHTML("Verify Pay Now button is displayed","Pay Now button is not displayed","FAIL",runManagerInfoObj);
		    	   			blnFlag=false;
		    	   		}
		    	   		
		    		}
		    		
		    		catch (Exception e)

		    		{
		    			repfn.FnUpdateTestStepResHTML("Verify User is able to navigate to Support page from Payment Verification page",
		    					"User is not able to navigate to Support page from Payment Verification page due to some exception","FAIL",runManagerInfoObj);

		    	      	 blnFlag=false;
		    			System.err.println("Message : "+e.getMessage());
		    			System.err.println("Cause : "+e.getCause());
		    			
		    		}
		    		m1.put("STEPSTATUS", blnFlag);
		    		return blnFlag;
		    		
		    	}
		       public synchronized boolean fnOverpaidCurrentBill(WebDriver driver, RunManagerInfo runManagerInfoObj) {
		    		try
		    		{
		    			driver.switchTo().frame("iFrameResizer0");
		    			if(cnf.FnExplicitWait("XPATH", mbo.dueByField,driver))
		    			{
		    				WebElement dueByDate=driver.findElement(By.xpath(mbo.overpaidBill));
		    				blnFlag=true;
		    				repfn.FnUpdateTestStepResHTML("Verify if \"Due by\" field is displayed in pay bill screen", "\"Due by\" field is displayed in pay bill screen","PASS",runManagerInfoObj);
		    				if(dueByDate.getText().contains("Credit Balance - Do Not Pay"))
		    				{
		    					blnFlag=true;
		    					repfn.FnUpdateTestStepResHTML("Verify if \"Credit Balance - Do Not Pay\"  is displayed instead of the date for Due By Date field", "\"Credit Balance - Do Not Pay\"  is displayed instead of the date for Due By Date field","PASS",runManagerInfoObj);
		    				}
		    				else
		    				{
		    					blnFlag=false;
		    					repfn.FnUpdateTestStepResHTML("Verify if \"Credit Balance - Do Not Pay\"  is displayed instead of the date for Due By Date field", "\"Credit Balance - Do Not Pay\"  is not displayed instead of the date for Due By Date field","FAIL",runManagerInfoObj);
		    				}			
		    			}
		    			else
		    			{
		    				blnFlag=false;
		    				repfn.FnUpdateTestStepResHTML("Verify if \"Due by\" field is displayed in Pay bill screen", "\"Due by\" field is not displayed in Pay bill screen","FAIL",runManagerInfoObj);
		    			}

		    			driver.switchTo().defaultContent();
		    		}
		    		catch(Exception e)
		    		{
		    			blnFlag=false;
		    			System.err.println("Message : "+e.getMessage());
		    			System.err.println("Cause : "+e.getCause());
		    			repfn.FnUpdateTestStepResHTML("Verify if \"Credit Balance - Do Not Pay\"  is displayed instead of the date for Due By Date field", "\"Credit Balance - Do Not Pay\"  is not displayed instead of the date for Due By Date field due to some exception","FAIL",runManagerInfoObj);
		    		}
		    		m1.put("STEPSTATUS", blnFlag);
		    		return blnFlag;
		    	}
		       public synchronized boolean FnVerifyCheckingSaving_RequiredFields(WebDriver driver, RunManagerInfo runManagerInfoObj){
		    		
		    		try{
		    			
		    			driver.switchTo().frame("iFrameResizer0");
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.Routing_Number_Required_Text,driver)){
		    				WebElement Routing_Number_Text=driver.findElement(By.xpath(mbo.Routing_Number_Required_Text));
		    				if(Routing_Number_Text.getAttribute("class").contains("required")){
		    					repfn.FnUpdateTestStepResHTML("Verify Routing Number title is marked as required field (*) under Checking/Saving Option", 
		    							"Routing Number title is marked as required field (*)","PASS",runManagerInfoObj);
		    					blnFlag=true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Routing Number title is marked as required field (*) under Checking/Saving Option", 
		    							"Routing Number title is not marked as required field (*)","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    					
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Routing Number title is displayed under Payment Information Header", 
		    						"Routing Number title is not displayed under Payment Information Header","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_AccountNumberText,driver)){
		    				WebElement Account_Number_Text=driver.findElement(By.xpath(mbo.PayBill_AccountNumberText));
		    				if(Account_Number_Text.getAttribute("class").contains("required")){
		    					repfn.FnUpdateTestStepResHTML("Verify Account Number title is marked as required field(*) under Checking/Saving Option", 
		    							" Account Number title is marked as required field(*)","PASS",runManagerInfoObj);
		    					blnFlag=true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Account Number title is marked as required field(*) under Checking/Saving Option", 
		    							" Account Number title is not marked as required field(*)","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}		
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Account Number is displayed under Checking/Saving Option", 
		    						"Account Number is not displayed under Credit/Debit Card Option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_PaymentAmount_RequiredText,driver)){
		    				WebElement PayBill_PaymentAmount_Text=driver.findElement(By.xpath(mbo.PayBill_PaymentAmount_Text));
		    				if(PayBill_PaymentAmount_Text.getAttribute("class").contains("required")){
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Amount title is marked as required field(*) under Amount & Date Option", 
		    							"Payment Amount title is marked as required field under Amount & Date Option","PASS",runManagerInfoObj);
		    					blnFlag=true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Amount title is marked as required field(*) under Amount & Date Option", 
		    							"Payment Amount title is not marked as required field under Amount & Date Option","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Payment Amount sub-heading is displayed under Amount & Date Option", 
		    						"Payment Amount sub-heading is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			if(cnf.FnExplicitWait("XPATH", mbo.PayBill_PaymentDate_RequiredText,driver)){
		    				WebElement PayBill_PaymentDate_Text=driver.findElement(By.xpath(mbo.PayBill_PaymentDate_Text));
		    				if(PayBill_PaymentDate_Text.getAttribute("class").contains("required")){
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Date title is marked as required field(*) under Amount & Date Option", 
		    							"Payment Date title is marked as required field(*) under Amount & Date Option","PASS",runManagerInfoObj);
		    					blnFlag=true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Payment Date title is marked as required field(*) under Amount & Date Option", 
		    							"Payment Date title is not marked as required field(*) under Amount & Date Option","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    			}
		    			else{
		    				repfn.FnUpdateTestStepResHTML("Verify Payment Date sub-heading is displayed under Amount & Date Option", 
		    						"Payment Date sub-heading is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			}
		    			
		    			driver.switchTo().defaultContent();

		    		}
		    		
		    		catch(Exception e)
		    		{
		    			blnFlag=false;
		    			repfn.FnUpdateTestStepResHTML("Verify User is able to verify Required fields for Checking/Savings option on Pay Bill page", "User is not able to verify Required fields for Checking/Savings option on Pay Bill page due to some exception", "FAIL",runManagerInfoObj);
		    			System.err.println("Message : "+e.getMessage());
		    			System.err.println("Cause : "+e.getCause());
		    		}
		    		m1.put("STEPSTATUS", blnFlag);
		    		return blnFlag;
		    	}


		       public synchronized boolean FnVerifyOtherPaymentOptionsUI(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
		    		
		    		try{
		    			
		    			driver.switchTo().frame("iFrameResizer0");
		    			
		    			  // Other Payment Methods Radio button
		    			  if(cnf.FnExplicitWait("XPATH", mbo.PayBill_OtherPaymentMethods,driver)){
		    				repfn.FnUpdateTestStepResHTML("Verify Other Payment Methods Radio button is displayed under Select Payment Type option",
		    						"Other Payment Methods Radio button is displayed under Select Payment Type option","PASS",runManagerInfoObj);
		    				WebElement PayBill_OtherPaymentMethods=driver.findElement(By.xpath(mbo.PayBill_OtherPaymentMethods));
		    				if(cnf.JSClick(PayBill_OtherPaymentMethods,driver)){
		    					repfn.FnUpdateTestStepResHTML("Verify Other Payment Methods Radio button under Select Payment Type option is clicked ",
		    	   					"Other Payment Methods Radio button under Select Payment Type option is clicked ","PASS",runManagerInfoObj);
		    					blnFlag=true;
		    				}
		    				else{
		    					repfn.FnUpdateTestStepResHTML("Verify Other Payment Methods Radio button under Select Payment Type option is clicked ",
		    	   					"Other Payment Methods Radio button under Select Payment Type option is not clicked ","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    				}
		    				
		    			  }
		    			  else{
		    				repfn.FnUpdateTestStepResHTML("Verify Other Payment Methods Radio button is displayed under Select Payment Type option",
		    						"Other Payment Methods Radio button is not displayed under Select Payment Type option","FAIL",runManagerInfoObj);
		    				blnFlag=false;
		    			  }
		    			  
		    			  if(cnf.FnExplicitWait("XPATH", mbo.OtherPayment_PayByPhoneHeading,driver)){
		    				  WebElement OtherPayment_PayByPhoneHeading=driver.findElement(By.xpath(mbo.OtherPayment_PayByPhoneHeading));
		    				  repfn.FnUpdateTestStepResHTML("Verify Pay By Phone Heading is displayed under Payment Information Header",
		    							"Pay By Phone Heading is displayed under Payment Information Header, Text displayed as: "+OtherPayment_PayByPhoneHeading.getText(),"PASS",runManagerInfoObj);
		    				  blnFlag=true;
		    			  }
		    			  else{
		    				  repfn.FnUpdateTestStepResHTML("Verify Pay By Phone Heading is displayed under Payment Information Header",
		    							"Pay By Phone Heading is not displayed under Payment Information Header","FAIL",runManagerInfoObj);
		    				  blnFlag=false;
		    			  }
		    			  
		    			  if(cnf.FnExplicitWait("XPATH", mbo.OtherPayment_PayByPhoneOptionOne,driver)){
		    				  WebElement OtherPayment_PayByPhoneOptionOne=driver.findElement(By.xpath(mbo.OtherPayment_PayByPhoneOptionOne));
		    				  repfn.FnUpdateTestStepResHTML("Verify Pay By Phone Option One is displayed under Pay By Phone Heading",
		    							"Pay By Phone Option One is displayed under Pay By Phone Heading, Text displayed as: "+OtherPayment_PayByPhoneOptionOne.getText(),"PASS",runManagerInfoObj);
		    				  blnFlag=true;
		    			  }
		    			  else{
		    				  repfn.FnUpdateTestStepResHTML("Verify Pay By Phone Option One is displayed under Pay By Phone Heading",
		    							"Pay By Phone Option One is not displayed under Pay By Phone Heading","FAIL",runManagerInfoObj);
		    				  blnFlag=false;
		    			  }
		    			  
		    			  if(cnf.FnExplicitWait("XPATH", mbo.OtherPayment_PayByPhoneOptionTwo,driver)){
		    				  WebElement OtherPayment_PayByPhoneOptionTwo=driver.findElement(By.xpath(mbo.OtherPayment_PayByPhoneOptionTwo));
		    				  repfn.FnUpdateTestStepResHTML("Verify Pay By Phone Option Two is displayed under Pay By Phone Heading",
		    							"Pay By Phone Option Two is displayed under Pay By Phone Heading, Text displayed as: "+OtherPayment_PayByPhoneOptionTwo.getText(),"PASS",runManagerInfoObj);
		    				  blnFlag=true;
		    			  }
		    			  else{
		    				  repfn.FnUpdateTestStepResHTML("Verify Pay By Phone Option Two is displayed under Pay By Phone Heading",
		    							"Pay By Phone Option Two is not displayed under Pay By Phone Heading","FAIL",runManagerInfoObj);
		    				  blnFlag=false;
		    			  }
		    			  
		    			  if(cnf.FnExplicitWait("XPATH", mbo.OtherPayment_PayByMailHeading,driver)){
		    				  WebElement OtherPayment_PayByMailHeading=driver.findElement(By.xpath(mbo.OtherPayment_PayByMailHeading));
		    				  repfn.FnUpdateTestStepResHTML("Verify Pay By Mail Heading is displayed under Payment Information Header",
		    							"Pay By Mail Heading is displayed under Payment Information Header, Text displayed as: "+OtherPayment_PayByMailHeading.getText(),"PASS",runManagerInfoObj);
		    				  blnFlag=true;
		    			  }
		    			  else{
		    				  repfn.FnUpdateTestStepResHTML("Verify Pay By Mail Heading is displayed under Payment Information Header",
		    							"Pay By Mail Heading is not displayed under Payment Information Header","FAIL",runManagerInfoObj);
		    				  blnFlag=false;
		    			  }
		    			  
		    			  if(cnf.FnExplicitWait("XPATH", mbo.OtherPayment_PayByMailText,driver)){
		    				  WebElement OtherPayment_PayByMailText=driver.findElement(By.xpath(mbo.OtherPayment_PayByMailText));
		    				  repfn.FnUpdateTestStepResHTML("Verify Pay By Mail text is displayed under Pay By Mail Heading",
		    							"Pay By Mail text is displayed under Pay By Mail Heading, Text displayed as: "+OtherPayment_PayByMailText.getText(),"PASS",runManagerInfoObj);
		    				  blnFlag=true;
		    			  }
		    			  else{
		    				  repfn.FnUpdateTestStepResHTML("Verify Pay By Mail text is displayed under Pay By Mail Heading",
		    							"Pay By Mail text is not displayed under Pay By Mail Heading","FAIL",runManagerInfoObj);
		    				  blnFlag=false;
		    			  }
		    			  
		    			  if(cnf.FnExplicitWait("XPATH", mbo.OtherPayment_OnlineBankingHeading,driver)){
		    				  WebElement OtherPayment_OnlineBankingHeading=driver.findElement(By.xpath(mbo.OtherPayment_OnlineBankingHeading));
		    				  repfn.FnUpdateTestStepResHTML("Verify Online Banking Heading is displayed under Payment Information Header",
		    							"Online Banking Heading is displayed under Payment Information Header, Text displayed as: "+OtherPayment_OnlineBankingHeading.getText(),"PASS",runManagerInfoObj);
		    				  blnFlag=true;
		    			  }
		    			  else{
		    				  repfn.FnUpdateTestStepResHTML("Verify Online Banking Heading is displayed under Payment Information Header",
		    							"Online Banking Heading is not displayed under Payment Information Header","FAIL",runManagerInfoObj);
		    				  blnFlag=false;
		    			  }
		    			  
		    			  if(cnf.FnExplicitWait("XPATH", mbo.OtherPayment_OnlineBankingText,driver)){
		    				  WebElement OtherPayment_OnlineBankingText=driver.findElement(By.xpath(mbo.OtherPayment_OnlineBankingText));
		    				  repfn.FnUpdateTestStepResHTML("Verify Online Banking text is displayed under Online Banking Heading",
		    							"Online Banking text is displayed under Online Banking Heading, Text displayed as: "+OtherPayment_OnlineBankingText.getText(),"PASS",runManagerInfoObj);
		    				  blnFlag=true;
		    			  }
		    			  else{
		    				  repfn.FnUpdateTestStepResHTML("Verify Online Banking text is displayed under Online Banking Heading",
		    							"Online Banking text is not displayed under Online Banking Heading","FAIL",runManagerInfoObj);
		    				  blnFlag=false;
		    			  }
		    			  
		    			  driver.switchTo().defaultContent();

		    		}
		    		
		    		catch (Exception e)
		    		 {
		    			 repfn.FnUpdateTestStepResHTML("Verify if User is able to verify UI of Other Payment Methods on Pay Bill page", "User is not able to verify UI of Other Payment Methods on Pay Bill page due to some exception", "FAIL",runManagerInfoObj);
		    			 System.err.println("Message : "+e.getMessage());
		    			 System.err.println("Cause : "+e.getCause());
		    			 blnFlag=false;
		    		 }
		    		 m1.put("STEPSTATUS", blnFlag);
		    		 return blnFlag;
		       }
		    		 public synchronized boolean fnCheckingOrSavingsAutoPayPaymentUI(WebDriver driver, RunManagerInfo runManagerInfoObj) {
		    				try
		    				{

		    					driver.switchTo().frame("iFrameResizer0");

		    					if(cnf.FnExplicitWait("XPATH", mbo.PayBill_PayBillOptionsText,driver)){
		    						WebElement PayBill_PayBillOptionsText=driver.findElement(By.xpath(mbo.PayBill_PayBillOptionsText));
		    						if(PayBill_PayBillOptionsText.getAttribute("textContent").contains("Pay Bill Options")){
		    							repfn.FnUpdateTestStepResHTML("Verify Pay Bill Options Header text is displayed", "Pay Bill Options Header text is displayed","PASS",runManagerInfoObj);
		    							blnFlag=true;
		    						}
		    						else{
		    							repfn.FnUpdateTestStepResHTML("Verify Pay Bill Options Header text is displayed", "Pay Bill Options Header text is not displayed","FAIL",runManagerInfoObj);
		    							blnFlag=false;
		    						}
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Pay Bill Options Header text is displayed", "Pay Bill Options Header text is not displayed","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					if(cnf.FnExplicitWait("XPATH", mbo.PayBill_SelectPaymentTypeText,driver)){
		    						WebElement PayBill_SelectPaymentTypeText=driver.findElement(By.xpath(mbo.PayBill_SelectPaymentTypeText));
		    						if(PayBill_SelectPaymentTypeText.getAttribute("textContent").contains("Select Payment Type")){
		    							repfn.FnUpdateTestStepResHTML("Verify Select Payment Type text is displayed under Pay Bill Options Header", 
		    									"Select Payment Type text is displayed under Pay Bill Options Header","PASS",runManagerInfoObj);
		    							blnFlag=true;
		    						}
		    						else{
		    							repfn.FnUpdateTestStepResHTML("Verify Select Payment Type text is displayed under Pay Bill Options Header", 
		    									"Select Payment Type text is not displayed under Pay Bill Options Header","FAIL",runManagerInfoObj);
		    							blnFlag=false;
		    						}
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Select Payment Type text is displayed under Pay Bill Options Header", 
		    								"Select Payment Type text is not displayed under Pay Bill Options Header","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}


		    					if(cnf.FnExplicitWait("XPATH", mbo.PayBill_Credit_Debit_Text,driver)){
		    						WebElement PayBill_Credit_Debit_Text=driver.findElement(By.xpath(mbo.PayBill_Credit_Debit_Text));
		    						if(PayBill_Credit_Debit_Text.getAttribute("textContent").contains("Credit/Debit Card")){
		    							repfn.FnUpdateTestStepResHTML("Verify Credit/Debit Card sub-option is displayed under Select Payment Type Option", 
		    									"Credit/Debit Card sub-option is displayed under Select Payment Type Option","PASS",runManagerInfoObj);				
		    							blnFlag=true;				
		    						}
		    						else{
		    							repfn.FnUpdateTestStepResHTML("Verify Credit/Debit Card sub-option is displayed under Select Payment Type Option", 
		    									"Credit/Debit Card sub-option is not displayed under Select Payment Type Option","FAIL",runManagerInfoObj);
		    							blnFlag=false;
		    						}
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Credit/Debit Card sub-option is displayed under Select Payment Type Option", 
		    								"Credit/Debit Card sub-option is not displayed under Select Payment Type Option","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					if(cnf.FnExplicitWait("XPATH", mbo.PayBill_Checking_Savings_Text,driver)){
		    						WebElement PayBill_Checking_Savings_Text=driver.findElement(By.xpath(mbo.PayBill_Checking_Savings_Text));
		    						if(PayBill_Checking_Savings_Text.getAttribute("textContent").contains("Checking/Savings")){
		    							repfn.FnUpdateTestStepResHTML("Verify Checking/Savings sub-option is displayed under Select Payment Type Option", 
		    									"Checking/Savings sub-option is displayed under Select Payment Type Option","PASS",runManagerInfoObj);
		    							blnFlag=true;
		    						}
		    						else{
		    							repfn.FnUpdateTestStepResHTML("Verify Checking/Savings sub-option is displayed under Select Payment Type Option", 
		    									"Checking/Savings sub-option is not displayed under Select Payment Type Option","FAIL",runManagerInfoObj);
		    							blnFlag=false;
		    						}
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Checking/Savings sub-option is displayed under Select Payment Type Option", 
		    								"Checking/Savings sub-option is not displayed under Select Payment Type Option","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					if(cnf.FnExplicitWait("XPATH", mbo.PayBill_OtherPaymentMethods_Text,driver)){
		    						WebElement PayBill_OtherPaymentMethods_Text=driver.findElement(By.xpath(mbo.PayBill_OtherPaymentMethods_Text));
		    						if(PayBill_OtherPaymentMethods_Text.getAttribute("textContent").contains("Other Payment Methods")){
		    							repfn.FnUpdateTestStepResHTML("Verify Other Payment Methods sub-option is displayed under Select Payment Type Option", 
		    									"Other Payment Methods sub-option is displayed under Select Payment Type Option","PASS",runManagerInfoObj);
		    							blnFlag=true;
		    						}
		    						else{
		    							repfn.FnUpdateTestStepResHTML("Verify Other Payment Methods sub-option is displayed under Select Payment Type Option", 
		    									"Other Payment Methods sub-option is not displayed under Select Payment Type Option","FAIL",runManagerInfoObj);
		    							blnFlag=false;
		    						}
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Other Payment Methods sub-option is displayed under Select Payment Type Option", 
		    								"Other Payment Methods sub-option is not displayed under Select Payment Type Option","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					if(cnf.FnExplicitWait("XPATH", mbo.PayBill_SelectPaymentFrequencyText,driver)){
		    						WebElement PayBill_SelectPaymentFrequencyText=driver.findElement(By.xpath(mbo.PayBill_SelectPaymentFrequencyText));
		    						if(PayBill_SelectPaymentFrequencyText.getAttribute("textContent").contains("Select Payment Frequency")){
		    							repfn.FnUpdateTestStepResHTML("Verify Select Payment Frequency text is displayed under Pay Bill Options Header", 
		    									"Select Payment Frequency text is displayed under Pay Bill Options Header","PASS",runManagerInfoObj);
		    							blnFlag=true;
		    						}
		    						else{
		    							repfn.FnUpdateTestStepResHTML("Verify Select Payment Frequency text is displayed under Pay Bill Options Header", 
		    									"Select Payment Frequency text is not displayed under Pay Bill Options Header","FAIL",runManagerInfoObj);
		    							blnFlag=false;
		    						}
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Select Payment Frequency text is displayed under Pay Bill Options Header", 
		    								"Select Payment Frequency text is not displayed under Pay Bill Options Header","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					if(cnf.FnExplicitWait("XPATH", mbo.PaymentFrequency_AutoPay_Text,driver)){
		    						WebElement PaymentFrequency_AutoPay_Text=driver.findElement(By.xpath(mbo.PaymentFrequency_AutoPay_Text));
		    						if(PaymentFrequency_AutoPay_Text.getAttribute("textContent").contains("Auto-Pay (Recurring)")){
		    							repfn.FnUpdateTestStepResHTML("Verify Auto-Pay (Recurring) sub-option is displayed under Select Payment Frequency Option", 
		    									"Auto-Pay (Recurring) sub-option is displayed under Select Payment Frequency Option","PASS",runManagerInfoObj);

		    							if(cnf.isElementExistOne("XPATH", mbo.PaymentFrequency_AutoPay_Selection,driver)){
		    								WebElement PaymentFrequency_AutoPay_Selection=driver.findElement(By.xpath(mbo.PaymentFrequency_AutoPay_Selection));
		    								String selectionState = PaymentFrequency_AutoPay_Selection.getAttribute("aria-checked");

		    								if(selectionState.equalsIgnoreCase("true")){
		    									repfn.FnUpdateTestStepResHTML("Verify Auto-Pay (Recurring) radio button is selected by default", 
		    											"Auto-Pay (Recurring) radio button is selected by default","PASS",runManagerInfoObj);
		    									blnFlag=true;
		    								}
		    								else{
		    									repfn.FnUpdateTestStepResHTML("Verify Auto-Pay (Recurring) radio button is selected by default", 
		    											"Auto-Pay (Recurring) radio button is not selected by default","FAIL",runManagerInfoObj);
		    									blnFlag=false;
		    								}
		    							}
		    							else{
		    								blnFlag=false;
		    							}
		    						}
		    						else{
		    							repfn.FnUpdateTestStepResHTML("Verify Auto-Pay (Recurring) sub-option is displayed under Select Payment Frequency Option", 
		    									"Auto-Pay (Recurring) sub-option is not displayed under Select Payment Frequency Option","FAIL",runManagerInfoObj);
		    							blnFlag=false;
		    						}
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Auto-Pay (Recurring) sub-option is displayed under Select Payment Frequency Option", 
		    								"Auto-Pay (Recurring) sub-option is not displayed under Select Payment Frequency Option","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					if(cnf.FnExplicitWait("XPATH", mbo.PaymentFrequency_OneTime_Text,driver)){
		    						WebElement PaymentFrequency_OneTime_Text=driver.findElement(By.xpath(mbo.PaymentFrequency_OneTime_Text));
		    						if(PaymentFrequency_OneTime_Text.getAttribute("textContent").contains("One-Time")){
		    							repfn.FnUpdateTestStepResHTML("Verify One-Time sub-option is displayed under Select Payment Frequency Option", 
		    									"One-Time sub-option is displayed under Select Payment Frequency Option","PASS",runManagerInfoObj);
		    							blnFlag=true;
		    						}
		    						else{
		    							repfn.FnUpdateTestStepResHTML("Verify One-Time sub-option is displayed under Select Payment Frequency Option", 
		    									"One-Time sub-option is not displayed under Select Payment Frequency Option","FAIL",runManagerInfoObj);
		    							blnFlag=false;
		    						}
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify One-Time sub-option is displayed under Select Payment Frequency Option", 
		    								"One-Time sub-option is not displayed under Select Payment Frequency Option","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader,driver)){
		    						WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
		    						if(PaymentInformationHeader.getAttribute("textContent").contains("Payment Information")){
		    							repfn.FnUpdateTestStepResHTML("Verify Payment Information Header text is displayed", "Payment Information Header text is displayed","PASS",runManagerInfoObj);
		    							blnFlag=true;
		    						}
		    						else{
		    							repfn.FnUpdateTestStepResHTML("Verify Payment Information Header text is displayed", "Payment Information Header text is not displayed","FAIL",runManagerInfoObj);
		    							blnFlag=false;
		    						}
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Payment Information Header text is displayed", "Payment Information Header text is not displayed","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					if(cnf.FnExplicitWait("XPATH", mbo.PayBill_BankInformation_Text,driver)){
		    						WebElement PayBill_BankInformation_Text=driver.findElement(By.xpath(mbo.PayBill_BankInformation_Text));
		    						if(PayBill_BankInformation_Text.getAttribute("textContent").contains("Bank Information")){
		    							repfn.FnUpdateTestStepResHTML("Verify Bank Information text is displayed under Payment Information Header", 
		    									"Bank Information text is displayed under Payment Information Header","PASS",runManagerInfoObj);
		    							blnFlag=true;
		    						}
		    						else{
		    							repfn.FnUpdateTestStepResHTML("Verify Bank Information text is displayed under Payment Information Header", 
		    									"Bank Information text is not displayed under Payment Information Header","FAIL",runManagerInfoObj);
		    							blnFlag=false;
		    						}
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Bank Information text is displayed under Payment Information Header", 
		    								"Bank Information text is not displayed under Payment Information Header","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					if(cnf.FnExplicitWait("XPATH", mbo.PayBill_AccountType_Text,driver)){
		    						WebElement PayBill_AccountType_Text=driver.findElement(By.xpath(mbo.PayBill_AccountType_Text));
		    						if(PayBill_AccountType_Text.getAttribute("textContent").contains("Account Type")){
		    							repfn.FnUpdateTestStepResHTML("Verify Account Type text is displayed under Bank Information Heading", 
		    									"Account Type text is displayed under Bank Information Heading","PASS",runManagerInfoObj);
		    							blnFlag=true;
		    						}
		    						else{
		    							repfn.FnUpdateTestStepResHTML("Verify Account Type text is displayed under Bank Information Heading", 
		    									"Account Type text is not displayed under Bank Information Heading","FAIL",runManagerInfoObj);
		    							blnFlag=false;
		    						}
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Account Type text is displayed under Bank Information Heading", 
		    								"Account Type text is not displayed under Bank Information Heading","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					if(cnf.FnExplicitWait("XPATH", mbo.PayBill_Checking_Text,driver)){
		    						WebElement PayBill_Checking_Text=driver.findElement(By.xpath(mbo.PayBill_Checking_Text));
		    						if(PayBill_Checking_Text.getAttribute("textContent").contains("Checking")){
		    							repfn.FnUpdateTestStepResHTML("Verify Checking sub-option text is displayed under Account Type Option", 
		    									"Checking sub-option text is displayed under Account Type Option","PASS",runManagerInfoObj);

		    							if(cnf.FnExplicitWait("XPATH", mbo.PayBill_Checking_RadioButton,driver)){					
		    								repfn.FnUpdateTestStepResHTML("Verify Checking radio button is displayed under Account Type Option", 
		    										"Checking radio button is displayed under Account Type Option","PASS",runManagerInfoObj);
		    								blnFlag=true;
		    							}
		    							else{
		    								repfn.FnUpdateTestStepResHTML("Verify Checking radio button is displayed under Account Type Option", 
		    										"Checking radio button is not displayed under Account Type Option","FAIL",runManagerInfoObj);
		    								blnFlag=false;
		    							}

		    						}
		    						else{
		    							repfn.FnUpdateTestStepResHTML("Verify Checking sub-option text is displayed under Account Type Option", 
		    									"Checking sub-option text is not displayed under Account Type Option","FAIL",runManagerInfoObj);
		    							blnFlag=false;
		    						}
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Checking sub-option text is displayed under Account Type Option", 
		    								"Checking sub-option text is not displayed under Account Type Option","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					if(cnf.FnExplicitWait("XPATH", mbo.PayBill_Savings_Text,driver)){
		    						WebElement PayBill_Savings_Text=driver.findElement(By.xpath(mbo.PayBill_Savings_Text));
		    						if(PayBill_Savings_Text.getAttribute("textContent").contains("Savings")){
		    							repfn.FnUpdateTestStepResHTML("Verify Savings sub-option text is displayed under Account Type Option", 
		    									"Savings sub-option text is displayed under Account Type Option","PASS",runManagerInfoObj);

		    							if(cnf.FnExplicitWait("XPATH", mbo.PayBill_Savings_RadioButton,driver)){					
		    								repfn.FnUpdateTestStepResHTML("Verify Savings radio button is displayed under Account Type Option", 
		    										"Savings radio button is displayed under Account Type Option","PASS",runManagerInfoObj);
		    								blnFlag=true;
		    							}
		    							else{
		    								repfn.FnUpdateTestStepResHTML("Verify Savings radio button is displayed under Account Type Option", 
		    										"Savings radio button is not displayed under Account Type Option","FAIL",runManagerInfoObj);
		    								blnFlag=false;
		    							}

		    						}
		    						else{
		    							repfn.FnUpdateTestStepResHTML("Verify Savings sub-option text is displayed under Account Type Option", 
		    									"Savings sub-option text is not displayed under Account Type Option","FAIL",runManagerInfoObj);
		    							blnFlag=false;
		    						}
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Savings sub-option text is displayed under Account Type Option", 
		    								"Savings sub-option text is not displayed under Account Type Option","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					if(cnf.FnExplicitWait("XPATH", mbo.PayBill_RoutingNumberText,driver)){
		    						WebElement PayBill_RoutingNumberText=driver.findElement(By.xpath(mbo.PayBill_RoutingNumberText));
		    						if(PayBill_RoutingNumberText.getAttribute("textContent").contains("9-Digit Routing Number")){
		    							repfn.FnUpdateTestStepResHTML("Verify 9-Digit Routing Number sub-heading is displayed under Account Type Option", 
		    									"9-Digit Routing Number sub-heading is displayed under Account Type Option","PASS",runManagerInfoObj);

		    							if(cnf.FnExplicitWait("XPATH", mbo.RoutingNumber,driver)){
		    								repfn.FnUpdateTestStepResHTML("Verify Routing Number input field is displayed under Routing Number sub-heading", 
		    										"Routing Number input field is displayed under Routing Number sub-heading","PASS",runManagerInfoObj);

		    								if(cnf.FnExplicitWait("XPATH", mbo.PayBill_RoutingNumberToolTip,driver)){
		    									repfn.FnUpdateTestStepResHTML("Verify Routing Number Tool Tip icon is displayed along Routing Number input field", 
		    											"Routing Number Tool Tip icon is displayed along Routing Number input field","PASS",runManagerInfoObj);
		    									blnFlag=true;
		    								}
		    								else{
		    									repfn.FnUpdateTestStepResHTML("Verify Routing Number Tool Tip icon is displayed along Routing Number input field", 
		    											"Routing Number Tool Tip icon is not displayed along Routing Number input field","FAIL",runManagerInfoObj);
		    									blnFlag=false;
		    								}
		    							}
		    							else{
		    								repfn.FnUpdateTestStepResHTML("Verify Routing Number input field is displayed under Routing Number sub-heading", 
		    										"Routing Number input field is not displayed under Routing Number sub-heading","FAIL",runManagerInfoObj);
		    								blnFlag=false;

		    							}
		    						}
		    						else{
		    							repfn.FnUpdateTestStepResHTML("Verify 9-Digit Routing Number sub-heading is displayed under Account Type Option", 
		    									"9-Digit Routing Number sub-heading is not displayed under Account Type Option","FAIL",runManagerInfoObj);
		    							blnFlag=false;
		    						}
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify 9-Digit Routing Number sub-heading is displayed under Account Type Option", 
		    								"9-Digit Routing Number sub-heading is not displayed under Account Type Option","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					if(cnf.FnExplicitWait("XPATH", mbo.PayBill_AccountNumberText,driver)){
		    						WebElement PayBill_AccountNumberText=driver.findElement(By.xpath(mbo.PayBill_AccountNumberText));
		    						if(PayBill_AccountNumberText.getAttribute("textContent").contains("Bank Account Number")){
		    							repfn.FnUpdateTestStepResHTML("Verify Bank Account Number sub-heading is displayed under Account Type Option", 
		    									"Bank Account Number sub-heading is displayed under Account Type Option","PASS",runManagerInfoObj);

		    							if(cnf.FnExplicitWait("XPATH", mbo.BankAccountNumber,driver)){
		    								repfn.FnUpdateTestStepResHTML("Verify Bank Account Number input field is displayed under Bank Account Number sub-heading", 
		    										"Bank Account Number input field is displayed under Bank Account Number sub-heading","PASS",runManagerInfoObj);

		    								if(cnf.FnExplicitWait("XPATH", mbo.PayBill_AccountNumberToolTip,driver)){
		    									repfn.FnUpdateTestStepResHTML("Verify Bank Account Number Tool Tip icon is displayed along Bank Account Number input field", 
		    											"Bank Account Number Tool Tip icon is displayed along Bank Account Number input field","PASS",runManagerInfoObj);
		    									blnFlag=true;
		    								}
		    								else{
		    									repfn.FnUpdateTestStepResHTML("Verify Bank Account Number Tool Tip icon is displayed along Bank Account Number input field", 
		    											"Bank Account Number Tool Tip icon is not displayed along Bank Account Number input field","FAIL",runManagerInfoObj);
		    									blnFlag=false;
		    								}
		    							}
		    							else{
		    								repfn.FnUpdateTestStepResHTML("Verify Bank Account Number input field is displayed under Bank Account Number sub-heading", 
		    										"Bank Account Number input field is not displayed under Bank Account Number sub-heading","FAIL",runManagerInfoObj);
		    								blnFlag=false;

		    							}
		    						}
		    						else{
		    							repfn.FnUpdateTestStepResHTML("Verify Bank Account Number sub-heading is displayed under Account Type Option", 
		    									"Bank Account Number sub-heading is not displayed under Account Type Option","FAIL",runManagerInfoObj);
		    							blnFlag=false;
		    						}
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Bank Account Number sub-heading is displayed under Account Type Option", 
		    								"Bank Account Number sub-heading is not displayed under Account Type Option","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CardImage,driver)){
		    						repfn.FnUpdateTestStepResHTML("Verify Image of a sample check leaf is displayed showing Routing number & Account number and Check number", 
		    								"Image of a sample check leaf is displayed showing Routing number & Account number and Check number","PASS",runManagerInfoObj);
		    						blnFlag=true;
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Image of a sample check leaf is displayed showing Routing number & Account number and Check number", 
		    								"Image of a sample check leaf is not displayed showing Routing number & Account number and Check number","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					if(cnf.FnExplicitWait("XPATH", mbo.PayBill_AmountAndDate_Text,driver)){
		    						WebElement PayBill_AmountAndDate_Text=driver.findElement(By.xpath(mbo.PayBill_AmountAndDate_Text));
		    						if(PayBill_AmountAndDate_Text.getAttribute("textContent").contains("Amount & Date")){
		    							repfn.FnUpdateTestStepResHTML("Verify Amount & Date text is displayed under Payment Information Header", 
		    									"Amount & Date text is displayed under Payment Information Header","PASS",runManagerInfoObj);
		    							blnFlag=true;
		    						}
		    						else{
		    							repfn.FnUpdateTestStepResHTML("Verify Amount & Date text is displayed under Payment Information Header", 
		    									"Amount & Date text is not displayed under Payment Information Header","FAIL",runManagerInfoObj);
		    							blnFlag=false;
		    						}
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Amount & Date text is displayed under Payment Information Header", 
		    								"Amount & Date text is not displayed under Payment Information Header","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					if(cnf.FnExplicitWait("XPATH", mbo.PayBill_AmountDue_Text,driver)){
		    						WebElement PayBill_AmountDue_Text=driver.findElement(By.xpath(mbo.PayBill_AmountDue_Text));
		    						if(PayBill_AmountDue_Text.getAttribute("textContent").contains("Amount Due")){
		    							repfn.FnUpdateTestStepResHTML("Verify Amount Due text is displayed under Amount & Date Option", 
		    									"Amount Due text is displayed under Amount & Date Option","PASS",runManagerInfoObj);
		    							blnFlag=true;
		    						}
		    						else{
		    							repfn.FnUpdateTestStepResHTML("Verify Amount Due text is displayed under Amount & Date Option", 
		    									"Amount Due text is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    							blnFlag=false;
		    						}
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Amount Due text is displayed under Amount & Date Option", 
		    								"Amount Due text is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					if(cnf.FnExplicitWait("XPATH", mbo.PayBill_AmountDue,driver)){
		    						WebElement PayBill_AmountDue=driver.findElement(By.xpath(mbo.PayBill_AmountDue));
		    						repfn.FnUpdateTestStepResHTML("Verify Amount Due is displayed under Amount & Date Option", 
		    								"Amount Due: "+PayBill_AmountDue.getText()+" is displayed under Amount & Date Option","PASS",runManagerInfoObj);
		    						blnFlag=true;
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Amount Due is displayed under Amount & Date Option", 
		    								"Amount Due is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					if(cnf.FnExplicitWait("XPATH", mbo.PayBill_DueBy_Text,driver)){
		    						WebElement PayBill_DueBy_Text=driver.findElement(By.xpath(mbo.PayBill_DueBy_Text));
		    						if(PayBill_DueBy_Text.getAttribute("textContent").contains("Due By")){
		    							repfn.FnUpdateTestStepResHTML("Verify Due By text is displayed under Amount & Date Option", 
		    									"Due By text is displayed under Amount & Date Option","PASS",runManagerInfoObj);
		    							blnFlag=true;
		    						}
		    						else{
		    							repfn.FnUpdateTestStepResHTML("Verify Due By text is displayed under Amount & Date Option", 
		    									"Due By text is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    							blnFlag=false;
		    						}
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Due By text is displayed under Amount & Date Option", 
		    								"Due By text is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					if(cnf.FnExplicitWait("XPATH", mbo.PayBill_DueByDate,driver)){
		    						WebElement PayBill_DueByDate=driver.findElement(By.xpath(mbo.PayBill_DueByDate));
		    						repfn.FnUpdateTestStepResHTML("Verify Amount Due Date is displayed under Amount & Date Option", 
		    								"Amount Due Date: "+PayBill_DueByDate.getText()+" is displayed under Amount & Date Option","PASS",runManagerInfoObj);
		    						blnFlag=true;
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Amount Due Date is displayed under Amount & Date Option", 
		    								"Amount Due Date is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					if(cnf.FnExplicitWait("XPATH", mbo.SupportLinkPayBill,driver)){
		    						repfn.FnUpdateTestStepResHTML("Verify Support Link is displayed on Pay Bill page", 
		    								"Support Link is displayed on Pay Bill page","PASS",runManagerInfoObj);
		    						blnFlag=true;
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Support Link is displayed on Pay Bill page", 
		    								"Support Link is not displayed on Pay Bill page","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					if(cnf.FnExplicitWait("XPATH", mbo.PayNowButton,driver)){
		    						repfn.FnUpdateTestStepResHTML("Verify Pay Now button is displayed on Pay Bill page", 
		    								"Pay Now button is displayed on Pay Bill page","PASS",runManagerInfoObj);
		    						blnFlag=true;
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Pay Now button is displayed on Pay Bill page", 
		    								"Pay Now button is not displayed on Pay Bill page","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					driver.switchTo().defaultContent();

		    				}
		    				catch (Exception e)

		    				{		
		    					blnFlag=false;
		    					System.err.println("Message : "+e.getMessage());
		    					System.err.println("Cause : "+e.getCause());
		    					repfn.FnUpdateTestStepResHTML("Verify User is able to verify Pay Bill page UI for Auto-Pay Checking/Savings Option", 
		    							"User is not able to verify Pay Bill page UI for Auto-Pay Checking/Savings Option due to some exception","FAIL",runManagerInfoObj);
		    				}

		    				m1.put("STEPSTATUS", blnFlag);
		    				return blnFlag;
		    			}
		    		 public synchronized boolean fnCheckingOrSavingsRequiredField(WebDriver driver, RunManagerInfo runManagerInfoObj) {
		    				try
		    				{

		    					driver.switchTo().frame("iFrameResizer0");

		    					if(cnf.FnExplicitWait("XPATH", mbo.Routing_Number_Required_Text,driver)){
		    						WebElement Routing_Number_Text=driver.findElement(By.xpath(mbo.Routing_Number_Required_Text));
		    						if(Routing_Number_Text.getAttribute("class").contains("required")){
		    							repfn.FnUpdateTestStepResHTML("Verify Routing Number title is marked as required field (*) under Checking/Saving Option", 
		    									"Routing Number title is marked as required field (*)","PASS",runManagerInfoObj);
		    							blnFlag=true;
		    						}
		    						else{
		    							repfn.FnUpdateTestStepResHTML("Verify Routing Number title is marked as required field (*) under Checking/Saving Option", 
		    									"Routing Number title is not marked as required field (*)","FAIL",runManagerInfoObj);
		    							blnFlag=false;
		    						}

		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Routing Number title is displayed under Payment Information Header", 
		    								"Routing Number title is not displayed under Payment Information Header","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					if(cnf.FnExplicitWait("XPATH", mbo.PayBill_AccountNumberText,driver)){
		    						WebElement Account_Number_Text=driver.findElement(By.xpath(mbo.PayBill_AccountNumberText));
		    						if(Account_Number_Text.getAttribute("class").contains("required")){
		    							repfn.FnUpdateTestStepResHTML("Verify Account Number title is marked as required field(*) under Checking/Saving Option", 
		    									" Account Number title is marked as required field(*)","PASS",runManagerInfoObj);
		    							blnFlag=true;
		    						}
		    						else{
		    							repfn.FnUpdateTestStepResHTML("Verify Account Number title is marked as required field(*) under Checking/Saving Option", 
		    									" Account Number title is not marked as required field(*)","FAIL",runManagerInfoObj);
		    							blnFlag=false;
		    						}		
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Account Number is displayed under Checking/Saving Option", 
		    								"Account Number is not displayed under Credit/Debit Card Option","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					if(cnf.FnExplicitWait("XPATH", mbo.requiredTextInPayBill,driver))
		    					{
		    						blnFlag=true;
		    						repfn.FnUpdateTestStepResHTML("Verify if text \"*Required\" is displayed in top right corner","\"*Required\" text is displayed in top right corner","PASS",runManagerInfoObj);
		    					}
		    					else
		    					{
		    						blnFlag=false;
		    						repfn.FnUpdateTestStepResHTML("Verify if text \"*Required\" is displayed in top right corner","\"*Required\" text is not displayed in top right corner","FAIL",runManagerInfoObj);
		    					}


		    					driver.switchTo().defaultContent();


		    				}
		    				catch(Exception e)
		    				{
		    					blnFlag=false;
		    					System.err.println("Message : "+e.getMessage());
		    					System.err.println("Cause : "+e.getCause());
		    					repfn.FnUpdateTestStepResHTML("Verify User is able to verify Required Fields for Auto-Pay Checking/Savings Option", "User is able to verify Required Fields for Auto-Pay Checking/Savings Option due to some exception","FAIL",runManagerInfoObj);
		    				}
		    				m1.put("STEPSTATUS", blnFlag);
		    				return blnFlag;
		    			}
		    		 public synchronized boolean fnCreditOrDebitAutoPayErrorMessage(WebDriver driver, RunManagerInfo runManagerInfoObj) {
		    				
		    				String invalidCardNumber = "";
		    				try
		    				{
		    					driver.switchTo().frame("iFrameResizer0");
		    					if(cnf.FnExplicitWait("XPATH", mbo.billingCardNumber,driver))
		    					{
		    						repfn.FnUpdateTestStepResHTML("Verify if Card number field to enter card number is present","Card number field to enter card number is present","PASS",runManagerInfoObj);
		    						WebElement billingCardNumber=driver.findElement(By.xpath(mbo.billingCardNumber));
		    						invalidCardNumber = m1.get("InvalidCardNum").toString();
		    						billingCardNumber.sendKeys(invalidCardNumber);
		    						repfn.FnUpdateTestStepResHTML("Verify if User has entered the card number","User has entered the card number: "+invalidCardNumber,"PASS",runManagerInfoObj);
		    						
		    			  			if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader,driver)){
		    			  				WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
		    			      			cnf.JSClick(PaymentInformationHeader,driver);
		    			  			}
		    			  			else{
		    			  				repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
		    			  				blnFlag=false;
		    			  			}
		    						
		    						if(cnf.FnExplicitWait("XPATH", mbo.errorMessageForInvalidCard,driver))
		    						{
		    							WebElement errorMessageForInvalidCard=driver.findElement(By.xpath(mbo.errorMessageForInvalidCard));
		    							repfn.FnUpdateTestStepResHTML("Verify if Error message is displayed for incorrect card number","Error message is displayed for incorrect card number: "+errorMessageForInvalidCard.getText(),"PASS",runManagerInfoObj);
		    							blnFlag=true;
		    						}
		    						else{
		    							blnFlag=false;
		    							repfn.FnUpdateTestStepResHTML("Verify if Error message is displayed for incorrect card number","Error message is not displayed for incorrect card number","FAIL",runManagerInfoObj);
		    						}
		    					}
		    					else
		    					{
		    						blnFlag=false;
		    						repfn.FnUpdateTestStepResHTML("Verify if Card number field to enter card number is present","Card number field to enter card number is not present","FAIL",runManagerInfoObj);
		    					}
		    					
		    					driver.switchTo().defaultContent();
		    				}
		    				 catch (Exception e)

		    				 {		
		    					 blnFlag=false;
		    					 System.err.println("Message : "+e.getMessage());
		    					 System.err.println("Cause : "+e.getCause());
		    					 repfn.FnUpdateTestStepResHTML("Verify if Error message is displayed for incorrect card number","Error message is not displayed for incorrect card number due to some exception","FAIL",runManagerInfoObj);
		    				 }
		    				 m1.put("STEPSTATUS", blnFlag);
		    				 return blnFlag;

		    			}
		    		
		    		 public synchronized boolean FnVerifyPaymentFrequency_OtherPaymentSelected(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
		    				
		    				boolean paymentFreqHeading = false;
		    				boolean oneTimeOption = false;
		    				boolean AutoPayOption = false;
		    				
		    				try{
		    					
		    					driver.switchTo().frame("iFrameResizer0");
		    					
		    					  // Other Payment Methods Radio button
		    					  if(cnf.FnExplicitWait("XPATH", mbo.PayBill_OtherPaymentMethods,driver)){
		    						repfn.FnUpdateTestStepResHTML("Verify Other Payment Methods Radio button is displayed under Select Payment Type option",
		    								"Other Payment Methods Radio button is displayed under Select Payment Type option","PASS",runManagerInfoObj);
		    						WebElement PayBill_OtherPaymentMethods=driver.findElement(By.xpath(mbo.PayBill_OtherPaymentMethods));
		    						if(cnf.JSClick(PayBill_OtherPaymentMethods,driver)){
		    							repfn.FnUpdateTestStepResHTML("Verify Other Payment Methods Radio button under Select Payment Type option is clicked ",
		    			 					"Other Payment Methods Radio button under Select Payment Type option is clicked ","PASS",runManagerInfoObj);
		    							blnFlag=true;
		    						}
		    						else{
		    							repfn.FnUpdateTestStepResHTML("Verify Other Payment Methods Radio button under Select Payment Type option is clicked ",
		    			 					"Other Payment Methods Radio button under Select Payment Type option is not clicked ","FAIL",runManagerInfoObj);
		    							blnFlag=false;
		    						}
		    						
		    					  }
		    					  else{
		    						repfn.FnUpdateTestStepResHTML("Verify Other Payment Methods Radio button is displayed under Select Payment Type option",
		    								"Other Payment Methods Radio button is not displayed under Select Payment Type option","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					  }
		    					  
		    					  if(cnf.FnExplicitWait("XPATH", mbo.PayBill_SelectPaymentFrequencyText,driver)){
		    						  //WebElement PaymentFrequency=driver.findElement(By.xpath(mbo.PayBill_SelectPaymentFrequencyText));
		    						 // System.out.println(PaymentFrequency.getAttribute("hidden"));
		    						  
		    						  repfn.FnUpdateTestStepResHTML("Verify Select Payment Frequency heading is not displayed",
		    				 					"Select Payment Frequency heading is displayed","FAIL",runManagerInfoObj);
		    						  blnFlag=false;
		    					  }
		    					  else{
		    						  paymentFreqHeading = true;
		    						  blnFlag=true;
		    					  }
		    					  
		    					  if(cnf.FnExplicitWait("XPATH", mbo.PaymentFrequency_OneTime,driver)){
		    						 // WebElement PaymentFrequency=driver.findElement(By.xpath(mbo.PaymentFrequency_OneTime));
		    						 // System.out.println(PaymentFrequency.getAttribute("hidden"));
		    						  repfn.FnUpdateTestStepResHTML("Verify One Time radio button is not displayed",
		    				 					"One Time radio button is displayed","FAIL",runManagerInfoObj);
		    						  blnFlag=false;
		    					  }
		    					  else{
		    						  oneTimeOption = true;
		    						  blnFlag=true;
		    					  }
		    					  
		    					  if(cnf.FnExplicitWait("XPATH", mbo.PaymentFrequency_AutoPay,driver)){
		    						//  WebElement PaymentFrequency=driver.findElement(By.xpath(mbo.PaymentFrequency_AutoPay));
		    						//  System.out.println(PaymentFrequency.getAttribute("hidden"));
		    						  repfn.FnUpdateTestStepResHTML("Verify Auto-pay radio button is not displayed",
		    				 					"Auto-pay radio button is displayed","FAIL",runManagerInfoObj);
		    						  blnFlag=false;
		    					  }
		    					  else{
		    						  AutoPayOption = true;
		    						  blnFlag=true;
		    					  }
		    					  
		    					  if(paymentFreqHeading && paymentFreqHeading && AutoPayOption){
		    						  
		    						  repfn.FnUpdateTestStepResHTML("Verify Payment Frequency section (One-Time/Auto-Pay) is not displayed on selecting Other Payment Methods Option",
		    				 					"Payment Frequency section (One-Time/Auto-Pay) is not displayed on selecting Other Payment Methods Option","PASS",runManagerInfoObj);
		    						  blnFlag=true;
		    					  }
		    					  else{
		    						  repfn.FnUpdateTestStepResHTML("Verify Payment Frequency section (One-Time/Auto-Pay) is not displayed on selecting Other Payment Methods Option",
		    				 					"Payment Frequency section (One-Time/Auto-Pay) is displayed on selecting Other Payment Methods Option","FAIL",runManagerInfoObj);
		    						  blnFlag=false;
		    					  }
		    					  
		    					  driver.switchTo().defaultContent();
		    					
		    				}
		    				
		    				catch (Exception e)
		    				 {
		    					 repfn.FnUpdateTestStepResHTML("Verify if User is able to verify Payment Frequency option on Pay Bill page", "User is not able to verify Payment Frequency option on Pay Bill page on Pay Bill page due to some exception", "FAIL",runManagerInfoObj);
		    					 System.err.println("Message : "+e.getMessage());
		    					 System.err.println("Cause : "+e.getCause());
		    					 blnFlag=false;
		    				 }
		    				 m1.put("STEPSTATUS", blnFlag);
		    				 return blnFlag;
		    			}
		    		 public synchronized boolean Autopay_UI(WebDriver driver, RunManagerInfo runManagerInfoObj){
		    				try{

		    					driver.switchTo().frame("iFrameResizer0");


		    					if(cnf.FnExplicitWait("XPATH", mbo.PayBill_Credit_DebitCard_Text,driver)){
		    						WebElement PayBill_Credit_DebitCard_Text=driver.findElement(By.xpath(mbo.PayBill_Credit_DebitCard_Text));
		    						if(PayBill_Credit_DebitCard_Text.getAttribute("textContent").contains("Credit/Debit Card")){
		    							repfn.FnUpdateTestStepResHTML("Verify Credit/Debit Card title is displayed under Payment Information Header", 
		    									"Credit/Debit Card title is displayed under Payment Information Header","PASS",runManagerInfoObj);
		    							blnFlag=true;
		    						}
		    						else{
		    							repfn.FnUpdateTestStepResHTML("Verify Credit/Debit Card title is displayed under Payment Information Header", 
		    									"Credit/Debit Card title is not displayed under Payment Information Header","FAIL",runManagerInfoObj);
		    							blnFlag=false;
		    						}
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Credit/Debit Card title is displayed under Payment Information Header", 
		    								"Credit/Debit Card title is not displayed under Payment Information Header","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CardNumber_Text,driver)){
		    						WebElement PayBill_CardNumber_Text=driver.findElement(By.xpath(mbo.PayBill_CardNumber_Text));
		    						if(PayBill_CardNumber_Text.getAttribute("textContent").contains("Card Number")){
		    							repfn.FnUpdateTestStepResHTML("Verify Card Number sub-heading is displayed under Credit/Debit Card Option", 
		    									"Card Number sub-heading is displayed under Credit/Debit Card Option","PASS",runManagerInfoObj);

		    							if(cnf.FnExplicitWait("XPATH", mbo.CardNumber,driver)){
		    								repfn.FnUpdateTestStepResHTML("Verify Card Number input field is displayed under Card Number sub-heading", 
		    										"Card Number input field is displayed under Card Number sub-heading","PASS",runManagerInfoObj);
		    								blnFlag=true;
		    							}
		    							else{
		    								repfn.FnUpdateTestStepResHTML("Verify Card Number input field is displayed under Card Number sub-heading", 
		    										"Card Number input field is not displayed under Card Number sub-heading","FAIL",runManagerInfoObj);
		    								blnFlag=false;

		    							}
		    						}
		    						else{
		    							repfn.FnUpdateTestStepResHTML("Verify Card Number sub-heading is displayed under Credit/Debit Card Option", 
		    									"Card Number sub-heading is not displayed under Credit/Debit Card Option","FAIL",runManagerInfoObj);
		    							blnFlag=false;
		    						}
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Card Number sub-heading is displayed under Credit/Debit Card Option", 
		    								"Card Number sub-heading is not displayed under Credit/Debit Card Option","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					if(cnf.FnExplicitWait("XPATH", mbo.PayBill_ExpirationDate_Text,driver)){
		    						WebElement PayBill_ExpirationDate_Text=driver.findElement(By.xpath(mbo.PayBill_ExpirationDate_Text));
		    						if(PayBill_ExpirationDate_Text.getAttribute("textContent").contains("Expiration Date")){
		    							repfn.FnUpdateTestStepResHTML("Verify Expiration Date sub-heading is displayed under Credit/Debit Card Option", 
		    									"Expiration Date sub-heading is displayed under Credit/Debit Card Option","PASS",runManagerInfoObj);

		    							if(cnf.FnExplicitWait("XPATH", mbo.ExpirationDate,driver)){
		    								repfn.FnUpdateTestStepResHTML("Verify Expiration Date input field is displayed under Expiration Date sub-heading", 
		    										"Expiration Date input field is displayed under Expiration Date sub-heading","PASS",runManagerInfoObj);
		    								blnFlag=true;
		    							}
		    							else{
		    								repfn.FnUpdateTestStepResHTML("Verify Expiration Date input field is displayed under Expiration Date sub-heading", 
		    										"Expiration Date input field is not displayed under Expiration Date sub-heading","FAIL",runManagerInfoObj);
		    								blnFlag=false;

		    							}
		    						}
		    						else{
		    							repfn.FnUpdateTestStepResHTML("Verify Expiration Date sub-heading is displayed under Credit/Debit Card Option", 
		    									"Expiration Date sub-heading is not displayed under Credit/Debit Card Option","FAIL",runManagerInfoObj);
		    							blnFlag=false;
		    						}
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Expiration Date sub-heading is displayed under Credit/Debit Card Option", 
		    								"Expiration Date sub-heading is not displayed under Credit/Debit Card Option","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					if(cnf.FnExplicitWait("XPATH", mbo.PayBill_AmountAndDate_Text,driver)){
		    						WebElement PayBill_AmountAndDate_Text=driver.findElement(By.xpath(mbo.PayBill_AmountAndDate_Text));
		    						if(PayBill_AmountAndDate_Text.getAttribute("textContent").contains("Amount & Date")){
		    							repfn.FnUpdateTestStepResHTML("Verify Amount & Date title is displayed under Payment Information Header", 
		    									"Amount & Date title is displayed under Payment Information Header","PASS",runManagerInfoObj);
		    							blnFlag=true;
		    						}
		    						else{
		    							repfn.FnUpdateTestStepResHTML("Verify Amount & Date title is displayed under Payment Information Header", 
		    									"Amount & Date title is not displayed under Payment Information Header","FAIL",runManagerInfoObj);
		    							blnFlag=false;
		    						}
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Amount & Date title is displayed under Payment Information Header", 
		    								"Amount & Date title is not displayed under Payment Information Header","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					if(cnf.FnExplicitWait("XPATH", mbo.PayBill_AmountDue_Text,driver)){
		    						WebElement PayBill_AmountDue_Text=driver.findElement(By.xpath(mbo.PayBill_AmountDue_Text));
		    						if(PayBill_AmountDue_Text.getAttribute("textContent").contains("Amount Due")){
		    							repfn.FnUpdateTestStepResHTML("Verify Amount Due text is displayed under Amount & Date Option", 
		    									"Amount Due text is displayed under Amount & Date Option","PASS",runManagerInfoObj);
		    							blnFlag=true;
		    						}
		    						else{
		    							repfn.FnUpdateTestStepResHTML("Verify Amount Due text is displayed under Amount & Date Option", 
		    									"Amount Due text is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    							blnFlag=false;
		    						}
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Amount Due text is displayed under Amount & Date Option", 
		    								"Amount Due text is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					if(cnf.FnExplicitWait("XPATH", mbo.PayBill_AmountDue,driver)){
		    						WebElement PayBill_AmountDue=driver.findElement(By.xpath(mbo.PayBill_AmountDue));
		    						repfn.FnUpdateTestStepResHTML("Verify Amount Due is displayed under Amount & Date Option", 
		    								"Amount Due: "+PayBill_AmountDue.getText()+" is displayed under Amount & Date Option","PASS",runManagerInfoObj);
		    						String amount=PayBill_AmountDue.getText();
		    						if(cnf.verifyAmountFormat(amount)){
		    							repfn.FnUpdateTestStepResHTML("Verify Amount Due is displayed in valid format $XX.XX", 
		    									"Amount Due is displayed in valid format: "+PayBill_AmountDue.getText()+" is displayed under Amount & Date Option","PASS",runManagerInfoObj);
		    							blnFlag=true;
		    						}else{
		    							repfn.FnUpdateTestStepResHTML("Verify Amount Due is displayed in valid format $XX.XX", 
		    									"Amount Due is not displayed in valid format: "+PayBill_AmountDue.getText()+" is displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    							blnFlag=true;
		    						}
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Amount Due is displayed under Amount & Date Option", 
		    								"Amount Due is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					if(cnf.FnExplicitWait("XPATH", mbo.PayBill_DueBy_Text,driver)){
		    						WebElement PayBill_DueBy_Text=driver.findElement(By.xpath(mbo.PayBill_DueBy_Text));
		    						if(PayBill_DueBy_Text.getAttribute("textContent").contains("Due By")){
		    							repfn.FnUpdateTestStepResHTML("Verify Due By text is displayed under Amount & Date Option", 
		    									"Due By text is displayed under Amount & Date Option","PASS",runManagerInfoObj);
		    							blnFlag=true;
		    						}
		    						else{
		    							repfn.FnUpdateTestStepResHTML("Verify Due By text is displayed under Amount & Date Option", 
		    									"Due By text is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    							blnFlag=false;
		    						}
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Due By text is displayed under Amount & Date Option", 
		    								"Due By text is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					if(cnf.FnExplicitWait("XPATH", mbo.PayBill_DueByDate,driver)){
		    						WebElement PayBill_DueByDate=driver.findElement(By.xpath(mbo.PayBill_DueByDate));
		    						repfn.FnUpdateTestStepResHTML("Verify Amount Due Date is displayed under Amount & Date Option", 
		    								"Amount Due Date: "+PayBill_DueByDate.getText()+" is displayed under Amount & Date Option","PASS",runManagerInfoObj);
		    						String date=PayBill_DueByDate.getText();
		    						if(cnf.isValidFormat("mm/dd/yy", date)){
		    							repfn.FnUpdateTestStepResHTML("Verify Amount Due Date is displayed under Amount & Date Option in valid format mm/dd/yy", 
		    									"Amount Due Date: "+PayBill_DueByDate.getText()+" is displayed under Amount & Date Option","PASS",runManagerInfoObj);
		    							blnFlag=true;
		    						}else{
		    							repfn.FnUpdateTestStepResHTML("Verify Amount Due Date is displayed under Amount & Date Option in valid format mm/dd/yy", 
		    									"Amount Due Date: "+PayBill_DueByDate.getText()+" is not displayed in valid format","FAIL",runManagerInfoObj);
		    						}
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Amount Due Date is displayed under Amount & Date Option", 
		    								"Amount Due Date is not displayed under Amount & Date Option","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					if(cnf.FnExplicitWait("XPATH", mbo.SupportLinkPayBill,driver)){
		    						repfn.FnUpdateTestStepResHTML("Verify Support Link is displayed on Pay Bill page", 
		    								"Support Link is displayed on Pay Bill page","PASS",runManagerInfoObj);
		    						blnFlag=true;
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Support Link is displayed on Pay Bill page", 
		    								"Support Link is not displayed on Pay Bill page","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    					if(cnf.FnExplicitWait("XPATH", mbo.PayNowButton,driver)){
		    						repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is displayed on Pay Bill page", 
		    								"Save Auto-Pay button is displayed on Pay Bill page","PASS",runManagerInfoObj);
		    						blnFlag=true;
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is displayed on Pay Bill page", 
		    								"Save Auto-Pay button is not displayed on Pay Bill page","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}


		    					driver.switchTo().defaultContent();

		    				}
		    				catch (Exception e)

		    				{		
		    					repfn.FnUpdateTestStepResHTML("Verify User is able to verify Pay Bill UI for Auto-Pay Credit Debit option", "User is not able to verify Pay Bill UI for Auto-Pay Credit Debit option due to some exception", "FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    					System.err.println("Message : "+e.getMessage());
		    					System.err.println("Cause : "+e.getCause());
		    				}
		    				m1.put("STEPSTATUS", blnFlag);
		    				return blnFlag;
		    			}
		    		 public synchronized boolean AutoPay_CheckUI(WebDriver driver, RunManagerInfo runManagerInfoObj){
		    				try{
		    					if(cnf.FnExplicitWait("Xpath", mbo.autopay_enrollLink,driver)){
		    						
		    						repfn.FnUpdateTestStepResHTML("Verify Whether Autopay Enroll Link is present","Autopay Enroll Link is present","PASS",runManagerInfoObj);
		    						repfn.FnUpdateTestStepResHTML("Verify  Autopay is not Enrolled so we need to Enroll autopay for this account ","Autopay is not Enrolled so we need to Enroll autopay for this account","PASS",runManagerInfoObj);

		    						WebElement autopay_enrollLink=driver.findElement(By.xpath(mbo.autopay_enrollLink));
		    						if(cnf.ElementClick(autopay_enrollLink,driver)){
		    							repfn.FnUpdateTestStepResHTML("Verify Whether Autopay Enroll Link is clicked","Autopay Enroll Link is clicked","PASS",runManagerInfoObj);
		    							blnFlag=Autopay_UI(driver,runManagerInfoObj);
		    							driver.switchTo().defaultContent();
		    							
		    						
		    			          	/* blnFlag=FnBilling();
		    			          	
		    			       
		    			          	 blnFlag=FnVerifyViewStatementPage();
		    			          	
		    							blnFlag=AutopayIcon_ViewStatementPage();*/
		    						}
		    						else{
		    							repfn.FnUpdateTestStepResHTML("Verify Whether Autopay Enroll Link is clicked","Autopay Enroll Link is not clicked","FAIL",runManagerInfoObj);
		    							blnFlag=false;
		    						}
		    					}
		    					else if (cnf.FnExplicitWait("Xpath", mbo.autopay_ManageLink,driver)) {
		    						repfn.FnUpdateTestStepResHTML("Verify Whether Autopay Enroll Link is present Indicates autpay already enrolled","Autopay Enroll Link is present Indicates autpay already enrolled","PASS",runManagerInfoObj);
		    						
		    						 blnFlag=app.FnBilling(driver,runManagerInfoObj);
		    			       	
		    				        blnFlag=app.PayBill(driver,runManagerInfoObj); 
		    			      	 blnFlag=app.Autopay_Cancel(driver,runManagerInfoObj);
		    			      	 blnFlag=app.Loginarrow(driver,runManagerInfoObj);
		    			      	 blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
		    			      	blnFlag=app.FnBilling(driver,runManagerInfoObj);
		    			      	 blnFlag=app.FnPayBillLinkClick(driver,runManagerInfoObj);
		    						//blnFlag=FnVerifyCurrentStatementUI();
		    						blnFlag=Autopay_UI(driver,runManagerInfoObj);
		    						driver.switchTo().defaultContent();
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Whether Autopay Enroll Link/Manage Auto pay is present","Autopay Enroll Link/Manage Auto pay is not present","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}
		    				}
		    				catch (Exception e)
		    				{
		    					repfn.FnUpdateTestStepResHTML("Verify whether user is in Charge Details section","User is in Charge Details section","FAIL",runManagerInfoObj);


		    					System.err.println("Message : "+e.getMessage());
		    					System.err.println("Cause : "+e.getCause());
		    					blnFlag=false;
		    				}
		    				m1.put("STEPSTATUS", blnFlag);
		    				return blnFlag;
		    			}
		    		 public synchronized boolean FnValidateEditPaymentOption_AutoPay(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
		    			  
		    			    String routingNumber = "122000247";
		    			    String accountNumber = "0888271156";
		    			    
		    			   try{

		    			        driver.switchTo().frame("iFrameResizer0");
		    			        
		    			        if(cnf.FnExplicitWait("XPATH", mbo.RoutingNumber,driver)){
		    			               repfn.FnUpdateTestStepResHTML("Verify Routing Number field is displayed under Payment Information option",
		    			                            "Routing Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
		    			               WebElement RoutingNumber=driver.findElement(By.xpath(mbo.RoutingNumber));
		    			               RoutingNumber.sendKeys(routingNumber);
		    			               repfn.FnUpdateTestStepResHTML("Verify Routing Number is entered","Routing Number: " +routingNumber + "is entered","PASS",runManagerInfoObj);
		    			               blnFlag=true;
		    			        }
		    			        else{
		    			               repfn.FnUpdateTestStepResHTML("Verify Routing Number field is displayed under Payment Information option",
		    			                            "Routing Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		    			               blnFlag=false;
		    			        }
		    			        
		    			        
		    			        if(cnf.FnExplicitWait("XPATH", mbo.BankAccountNumber,driver)){
		    			               repfn.FnUpdateTestStepResHTML("Verify Bank Account Number field is displayed under Payment Information option",
		    			                           "Bank Account Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
		    			               WebElement BankAccountNumber=driver.findElement(By.xpath(mbo.BankAccountNumber));
		    			               BankAccountNumber.sendKeys(accountNumber);
		    			               repfn.FnUpdateTestStepResHTML("Verify Bank Account Number is entered","Bank Account Number:  " +accountNumber + "is entered","PASS",runManagerInfoObj);
		    			               blnFlag=true;
		    			        } 
		    			        else{
		    			               repfn.FnUpdateTestStepResHTML("Verify Bank Account Number field is displayed under Payment Information option",
		    			                            "Bank Account Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		    			               blnFlag=false;
		    			        }
		    			        
		    			               
		    			        driver.switchTo().defaultContent();
		    			        
		    			   }
		    			   
		    			   catch (Exception e)

		    			        {
		    			               repfn.FnUpdateTestStepResHTML("Verify User is able to verify Pay Bill button on Home page",
		    			                            "User is able to verify Pay Bill button on Home page due to some exception","FAIL",runManagerInfoObj);

		    			        blnFlag=false;
		    			               System.err.println("Message : "+e.getMessage());
		    			               System.err.println("Cause : "+e.getCause());
		    			               
		    			        }
		    			        m1.put("STEPSTATUS", blnFlag);
		    			        return blnFlag;
		    			   
		    			}


		    		 public synchronized boolean fnAutoPayCreditCardSupportLink(WebDriver driver, RunManagerInfo runManagerInfoObj) {
		    				
		    				String routingNumberOne = "";
		    				String accountNumberOne = "";
		    				String routingNumber = "";
		    				String accountNumber = "";
		    				String paymentAmount = "";
		    				String paymentDate = "";
		    				String paymentDateChrome="";
		    				String month = "";
		    				String day = "";
		    				String year = "";
		    				
		    				try{
		    					
		    			driver.switchTo().frame("iFrameResizer0");
		    					
		    					if(cnf.FnExplicitWait("XPATH", mbo.RoutingNumber,driver)){
		    						WebElement RoutingNumber=driver.findElement(By.xpath(mbo.RoutingNumber));
		    						routingNumberOne = RoutingNumber.getAttribute("value");	
		    						int length = routingNumberOne.length();
		    						routingNumber = routingNumberOne.substring((length-4));
		    						System.out.println(routingNumber);
		    						blnFlag=true;
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Routing Number field is displayed under Payment Information option",
		    								"Routing Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}
		    					
		    					if(cnf.FnExplicitWait("XPATH", mbo.BankAccountNumber,driver)){
		    						WebElement BankAccountNumber=driver.findElement(By.xpath(mbo.BankAccountNumber));
		    						accountNumberOne = BankAccountNumber.getAttribute("value");
		    						int length = accountNumberOne.length();
		    						accountNumber = accountNumberOne.substring((length-4));
		    						System.out.println(accountNumber);
		    						blnFlag=true;
		    					} 
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify Bank Account Number field is displayed under Payment Information option",
		    								"Bank Account Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}

		    			   		Thread.sleep(2000);
		    			   		
		    			   		if(cnf.FnExplicitWait("XPATH", mbo.PayNowButton,driver)){
		    			   			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(mbo.PayNowButton)));   
		    			   			repfn.FnUpdateTestStepResHTML("Verify Save Auto Pay button is displayed","Save Auto Pay button is displayed","PASS",runManagerInfoObj);
		    			   			WebElement PayNowButton=driver.findElement(By.xpath(mbo.PayNowButton));
		    			   			//cnf.ScrollToView(PayNowButton);
		    			   			if(PayNowButton.isEnabled()){
		    			   				repfn.FnUpdateTestStepResHTML("Verify Save Auto Pay button is enabled","Save Auto Pay button is enabled.","PASS",runManagerInfoObj);
		    			   				if(cnf.JSClick(PayNowButton,driver)){
		    			   					repfn.FnUpdateTestStepResHTML("Verify Save Auto Pay button is clicked","Save Auto Pay button is clicked.","PASS",runManagerInfoObj);
		    			   					
		    			   					Thread.sleep(5000);
		    			   					
		    			   					if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentPageOne,driver)){
		    			   						WebElement VerifyPaymentPageOne=driver.findElement(By.xpath(mbo.VerifyPaymentPageOne));
		    			   						if(VerifyPaymentPageOne.getText().contains("Verify Payment Information")){
		    			   							repfn.FnUpdateTestStepResHTML("Verify User is navigated to Verify Payment page","User is navigated to Verify Payment page","PASS",runManagerInfoObj);
		    			   							
		    			   							if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentPage_RoutingNumber,driver)){
		    			   								WebElement VerifyPaymentPage_RoutingNumber=driver.findElement(By.xpath(mbo.VerifyPaymentPage_RoutingNumber));
		    			   								if(VerifyPaymentPage_RoutingNumber.getAttribute("textContent").contains(routingNumber)){
		    			   									repfn.FnUpdateTestStepResHTML("Verify Correct Routing Number is displayed","Correct Routing Number is displayed","PASS",runManagerInfoObj);
		    			   									blnFlag=true;
		    			   								}
		    			   								else{
		    			   									repfn.FnUpdateTestStepResHTML("Verify Correct Routing Number is displayed","Correct Routing Number is not displayed","FAIL",runManagerInfoObj);
		    			   									blnFlag=false;
		    			   									
		    			   								}
		    			   							}
		    			   							else{
		    			   								repfn.FnUpdateTestStepResHTML("Verify Correct Routing Number is displayed","Correct Routing Number is not displayed","FAIL",runManagerInfoObj);
		    												blnFlag=false;
		    			   							}
		    			   							
		    			   							if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentPageOne_AccountNumber,driver)){
		    			   								WebElement VerifyPaymentPageOne_AccountNumber=driver.findElement(By.xpath(mbo.VerifyPaymentPageOne_AccountNumber));
		    			   								if(VerifyPaymentPageOne_AccountNumber.getAttribute("textContent").contains(accountNumber)){
		    			   									repfn.FnUpdateTestStepResHTML("Verify Correct Account Number is displayed","Correct Account Number is displayed","PASS",runManagerInfoObj);
		    			   									blnFlag=true;
		    			   								}
		    			   								else{
		    			   									repfn.FnUpdateTestStepResHTML("Verify Correct Account Number is displayed","Correct Account Number is not displayed","FAIL",runManagerInfoObj);
		    			   									blnFlag=false;
		    			   									
		    			   								}
		    			   							}
		    			   							else{
		    			   								repfn.FnUpdateTestStepResHTML("Verify Correct Account Number is displayed","Correct Account Number is not displayed","FAIL",runManagerInfoObj);
		    												blnFlag=false;
		    			   							}
		    			   							 							
		    			   							if(cnf.FnExplicitWait("XPATH", mbo.SupportLinkPayBill,driver)){
		    			   			 				 repfn.FnUpdateTestStepResHTML("Verify Support link is displayed on Pay Bill page", "Support link is displayed on Pay Bill page","PASS",runManagerInfoObj);
		    			   			 				 WebElement Support_Link=driver.findElement(By.xpath(mbo.SupportLinkPayBill));
		    			   			 				 ArrayList<String> oldTab = new ArrayList<String>(driver.getWindowHandles());
		    			   			 				 cnf.ScrollToView(Support_Link,driver);

		    			   			 				 if(cnf.JSClick(Support_Link,driver)){
		    			   			 					 repfn.FnUpdateTestStepResHTML("Verify Support Link is clicked", "Support Link is clicked","PASS",runManagerInfoObj);

		    			   			 					 Thread.sleep(5000);
		    			   			 					 if(cnf.isAlertPresent()){
		    			   			 						 driver.switchTo().alert();
		    			   			 						 String ErrMsg=driver.switchTo().alert().getText();
		    			   			 						 System.out.println(ErrMsg);
		    			   			 						 //repfn.FnUpdateTestStepResHTML("verify .... ",".......","PASS/WARNING");// update the reporting function based on your requirement
		    			   			 						 //  blnFlag1=false;
		    			   			 						 driver.switchTo().alert().accept();
		    			   			 						 driver.switchTo().defaultContent();
		    			   			 						 //Thread.sleep(5000);

		    			   			 					 }else{
		    			   			 						 //repfn.FnUpdateTestStepResHTML("verify .... ",".......","PASS/WARNING");// update the reporting function based on your requirement
		    			   			 						 return false;                                                 
		    			   			 					 }


		    			   			 				 }
		    			   			 				 else{
		    			   			 					repfn.FnUpdateTestStepResHTML("Verify Support Link is clicked", "Support Link is not clicked","FAIL",runManagerInfoObj);
		    			   			 					blnFlag=false;
		    			   			 				 }
		    			   			 				 

		    			   			 				 Thread.sleep(5000);

		    			   			 				 ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		    			   			 				 //System.out.println(newTab.size());

		    			   			 				 if(newTab.size() == oldTab.size()){
		    			   			 					 repfn.FnUpdateTestStepResHTML("Verify Support Page is opened in same tab", "Support Page is opened in same tab","PASS",runManagerInfoObj);
		    			   			 					 blnFlag=true;
		    			   			 				 }
		    			   			 				 else{
		    			   			 					 repfn.FnUpdateTestStepResHTML("Verify Support Page is opened in same tab", "Support Page is opened in new tab","FAIL",runManagerInfoObj);
		    			   			 					 blnFlag=false;
		    			   			 				 }

		    			   			 				 
		    			   			 				 if(cnf.FnExplicitWait("XPATH", mbo.SupportPageVerification,driver)){
		    			   			 					 repfn.FnUpdateTestStepResHTML("Verify User is on Support Page", "User is on Support Page","PASS",runManagerInfoObj);
		    			   			 					 blnFlag=true;
		    			   			 				 }
		    			   			 				 else{
		    			   			 					 repfn.FnUpdateTestStepResHTML("Verify User is on Support Page", "User is not on Support Page","FAIL",runManagerInfoObj);
		    			   			 					 blnFlag=false;
		    			   			 				 }


		    			   			 			 }
		    			   			 			 else{
		    			   			 				 repfn.FnUpdateTestStepResHTML("Verify Support link is displayed", "Support link is not displayed","FAIL",runManagerInfoObj);
		    			   			 				 blnFlag=false;
		    			   			 			 }
		    			   							
		    			   						}
		    			   						else{
		    			   							repfn.FnUpdateTestStepResHTML("Verify User is navigated to Verify Payment page","User is not navigated to Verify Payment page","FAIL",runManagerInfoObj);
		    			   							blnFlag=false;
		    			   						}
		    			   					}
		    			   				}
		    			   				else{
		    			   					repfn.FnUpdateTestStepResHTML("Verify Save Auto Pay button is clicked","Save Auto Pay button is not clicked.","FAIL",runManagerInfoObj);
		    			   					blnFlag=false;
		    			   				}
		    			   			}
		    			   			else{
		    			   				repfn.FnUpdateTestStepResHTML("Verify Save Auto Pay button is enabled","Save Auto Pay button is not enabled","FAIL",runManagerInfoObj);
		    			   				blnFlag=false;
		    			   			}
		    			   		}
		    			   		else{
		    			   			repfn.FnUpdateTestStepResHTML("Verify Save Auto Pay button is displayed","Save Auto Pay button is not displayed","FAIL",runManagerInfoObj);
		    			   			blnFlag=false;
		    			   		}
		    			   		
		    			   		driver.switchTo().defaultContent();
		    			   		
		    				}
		    				
		    				catch (Exception e)

		    				{
		    					repfn.FnUpdateTestStepResHTML("Verify User is able to navigate to Support page from Payment Verification page",
		    							"User is not able to navigate to Support page from Payment Verification page due to some exception","FAIL",runManagerInfoObj);
		    			      	 blnFlag=false;
		    					System.err.println("Message : "+e.getMessage());
		    					System.err.println("Cause : "+e.getCause());
		    					
		    				}
		    				m1.put("STEPSTATUS", blnFlag);
		    				return blnFlag;
		    				
		    			}
		    		 public synchronized boolean FnBilling_Standard(WebDriver driver, RunManagerInfo runManagerInfoObj){
		    				try{
		    					
		    					
		    					if(cnf.isElementExist(By.xpath(mbo.Billing),driver)){
		    					
		    						System.out.println("Billing page");
		    						repfn.FnUpdateTestStepResHTML("Verify if a standard user is able navigate to BillPayOptions page.","A standard user role should is  be able to access BillPayOptions page","FAIL",runManagerInfoObj);
		    						blnFlag=false;
		    					}
		    					else{
		    						repfn.FnUpdateTestStepResHTML("Verify if a standard user is able navigate to BillPayOptions page.","A standard user role should not be able to access BillPayOptions page","PASS",runManagerInfoObj);
		    						blnFlag=true;
		    					}

		    				}

		    				catch (Exception e)

		    				{
		    					repfn.FnUpdateTestStepResHTML("Verify if a standard user is able navigate to BillPayOptions page.","A standard user role should is  be able to access BillPayOptions page due to some exception","FAIL",runManagerInfoObj);
		    					blnFlag=false;
		    					System.err.println("Message : "+e.getMessage());
		    					System.err.println("Cause : "+e.getCause());

		    				}
		    				m1.put("STEPSTATUS", blnFlag);
		    				return blnFlag;
		    			}
}
