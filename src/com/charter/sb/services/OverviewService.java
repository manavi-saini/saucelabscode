package com.charter.sb.services;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.charter.sb.beans.RunManagerInfo;
import com.charter.sb.controllers.Initialization;
import com.charter.sb.resources.MB_PageObjects;
import com.charter.sb.utils.CommonFunctions;
import com.charter.sb.utils.ReportingFunctions;
import com.charter.sb.utils.RunManager;

public class OverviewService extends Initialization{

	MB_PageObjects mbo = new MB_PageObjects();
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	public static boolean blnFlag = false;
	
	
	public synchronized boolean Fn_User_NotificationPanel_NoMsg(WebDriver driver, RunManagerInfo runManagerInfoObj)
	{
		String msg="";
		try{
			if(cnf.FnExplicitWait("XPATH",mbo.OvwApp_NotificationPanel_NoMsg,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify whether No message verbiage is displayed in notification panel when there are no messages","No message verbiage: "+" "+driver.findElement(By.xpath(mbo.OvwApp_NotificationPanel_NoMsg)).getText()+" "+ " is displayed in notification panel when there are no messages","PASS",runManagerInfoObj);

				msg=driver.findElement(By.xpath(mbo.OvwApp_NotificationPanel_NoMsg)).getText();
				if(msg.equalsIgnoreCase("No notifications at this time"))
				{
					repfn.FnUpdateTestStepResHTML("Verify whether No message verbiage is displayed in notification panel as expected","No message verbiage: "+" "+driver.findElement(By.xpath(mbo.OvwApp_NotificationPanel_NoMsg)).getText()+" "+ " is displayed in notification panel as expected","PASS",runManagerInfoObj);
					blnFlag=true; 
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify whether No message verbiage is displayed in notification panel as expected","No message verbiage "+" "+driver.findElement(By.xpath(mbo.OvwApp_NotificationPanel_NoMsg)).getText()+" "+ " is not displayed in notification panel not as expected","FAIL",runManagerInfoObj);
					blnFlag=false; 
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify whether No message verbiage is displayed in notification panel when there are no messages","Notification panel is displayed with details when there are messages","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		catch(Exception e)
		{
			repfn.FnUpdateTestStepResHTML("Verify whether User is able to verify No Message Verbiage in Notification Panel","User is able to verify No Message Verbiage in Notification Panel due to some exception","FAIL",runManagerInfoObj);
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			blnFlag=false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	public synchronized boolean Voice_MoreThanOneLine(WebDriver driver, RunManagerInfo runManagerInfoObj)
	{
		

		try
		{
			if(cnf.FnExplicitWait("XPATH", mbo.Voice_Notifications_Line,driver))
			{
				List <WebElement> Phone=driver.findElements(By.xpath(mbo.Voice_Notifications_Line));
				for(int i=0;i<Phone.size();i++){
					repfn.FnUpdateTestStepResHTML("Verify if Voice Notifications are present", "Voice Notifications are present for: "+Phone.get(i).getText(), "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.Voice_Notifications_PhoneLine,driver))
				{
					List<WebElement> Voice_Notifications_PhoneLine= driver.findElements(By.xpath(mbo.Voice_Notifications_PhoneLine));
					if(Voice_Notifications_PhoneLine.size() == Phone.size()){
						repfn.FnUpdateTestStepResHTML("Verify if Notifications are grouped according to different phone lines", "Notifications are grouped according to different phone lines", "PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify if Notifications are grouped according to different phone lines", "Notifications are not grouped according to different phone lines", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify if Missed Call and Message Notifications are displayed", "Missed Call and Message Notifications are not displayed", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if Voice Notifications are present", "Voice Notifications are not present", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		catch(Exception e)
		{
			repfn.FnUpdateTestStepResHTML("Verify if Voice Notifications are present for a particular voice line", "Voice Notifications are not present for a particular voice line due to some exception", "FAIL",runManagerInfoObj);
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());	
			blnFlag=false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;

	}
	
	
	public synchronized boolean Fn_User_NotificationPanel(WebDriver driver, RunManagerInfo runManagerInfoObj)
	{
		try{
			if(cnf.FnExplicitWait("XPATH", mbo.OvwApp_NotificationPanel,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify whether Account Owner/Admin/Billing user/Standard user is able to view Notification panel on Account Dashboard page","Account Owner/Admin/Billing user/Standard user: "+" "+m1.get("AppUser").toString()+ " "+" is able to view Notification panel on Account Dashboard page with the header title: "+" "+driver.findElement(By.xpath(mbo.OvwApp_NotificationHdr)).getText(),"PASS",runManagerInfoObj);
				blnFlag=true; 
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify whether Account Owner/Admin/Billing user/Standard user is able to view Notification panel on Account Dashboard page","Account Owner/Admin/Billing user/Standard user is not able to view Notification panel on Account Dashboard page","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		catch(Exception e)
		{
			repfn.FnUpdateTestStepResHTML("Verify User is able to verify Notification Panel","User is able to verify Notification Panel due to some exception","FAIL",runManagerInfoObj);
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			blnFlag=false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	public synchronized boolean FnVerifyAndClickRegisterAccountLink(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
		try{
			 
			 if(cnf.FnExplicitWait("XPATH", mbo.UnauthenticatedUser_SharedHomePage_RegisterAccount,driver)){
				 repfn.FnUpdateTestStepResHTML("Verify Register Account Link is present on Index Page for Non-logged in user", 
						 "Register Account Link is present on Index Page for Non-logged in user","PASS",runManagerInfoObj);
				 WebElement RegisterAccountLink=driver.findElement(By.xpath(mbo.UnauthenticatedUser_SharedHomePage_RegisterAccount));
				 cnf.ScrollToView(RegisterAccountLink,driver);
				 if(cnf.JSClick(RegisterAccountLink,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify Register Account Link is clicked", "Register Account Link is clicked","PASS",runManagerInfoObj);
					 
					 Thread.sleep(5000);

					 
					 if(cnf.FnExplicitWait("XPATH", mbo.RegisterAccountPageVerification,driver)){
						 WebElement RegisterAccountPageVerification=driver.findElement(By.xpath(mbo.RegisterAccountPageVerification));
						 if(RegisterAccountPageVerification.getAttribute("textContent").contains("Account Registration")){
							 repfn.FnUpdateTestStepResHTML("Verify User is on Account Registration Page", "User is on Account Registration Page","PASS",runManagerInfoObj);
							 blnFlag=true;
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify User is on Account Registration Page", "User is not on Account Registration Page","FAIL",runManagerInfoObj);
							 blnFlag=false;
						 }
					 }
					 
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify Register Account Link is clicked", "Register Account Link is not clicked","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
				 
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify Register Account Link is present on Index Page for Non-logged in user", 
						 "Register Account Link is not present on Index Page for Non-logged in user","FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }
		
		catch(Exception e)
		{
			blnFlag=false;
			repfn.FnUpdateTestStepResHTML("Verify User is on Register Account page", "User is not on Register Account page due to some exception", "FAIL",runManagerInfoObj);
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	public synchronized boolean FnVerifyAndSpectrumBusinessLogoClick(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

		 try{
			 
			 Thread.sleep(5000);
	

				 if(cnf.FnExplicitWait("XPATH", mbo.SpectrumBusinessLogo,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Logo is displayed", 
							 "Spectrum Business Logo is displayed","PASS",runManagerInfoObj);
					 WebElement SpectrumBusinessLogo=driver.findElement(By.xpath(mbo.SpectrumBusinessLogo));
					// cnf.ScrollToView(SpectrumBusinessLogo);
				if(cnf.JSClick(SpectrumBusinessLogo,driver)){
						 repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Logo is clicked", "Spectrum Business Logo is clicked","PASS",runManagerInfoObj);
						 blnFlag=true;
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Logo is clicked", "Spectrum Business Logo is not clicked","FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
					 
					 Thread.sleep(2000);

				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Logo is displayed", 
							 "Spectrum Business Logo is not displayed","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }

		 }

		 catch(Exception e)
		 {
			 repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Logo is displayed and clicked", "Spectrum Business Logo is not displayed and not clicked due to some exception.","FAIL",runManagerInfoObj);
			 blnFlag=false;
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());

		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }
	 public synchronized boolean FnVerifyAndClickLoginLink(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

		 try{
			 
			 if(cnf.FnExplicitWait("XPATH", mbo.LoginWindow,driver)){
				 repfn.FnUpdateTestStepResHTML("Verify Login window is present on Index Page for Non-logged in user", 
						 "Login window is present on Index Page for Non-logged in user","PASS",runManagerInfoObj);
				 blnFlag=true;
				
				 
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify Login window is present on Index Page for Non-logged in user", 
						 "Login window is not present on Index Page for Non-logged in user","FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }

		 catch(Exception e)
		 {
			 repfn.FnUpdateTestStepResHTML("Verify Login window is present on Index Page for Non-logged in user", 
					 "Login window is not present on Index Page for Non-logged in user due to some exception.","FAIL",runManagerInfoObj);
			 blnFlag=false;
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());

		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }
	 public synchronized boolean FnVerifyAndClickSpectrumBusinessLogo(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

		 try{
			 
			 Thread.sleep(5000);
	

				 if(cnf.FnExplicitWait("XPATH", mbo.SpectrumBusinessLogo,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Logo is displayed", 
							 "Spectrum Business Logo is displayed","PASS",runManagerInfoObj);
					 WebElement SpectrumBusinessLogo=driver.findElement(By.xpath(mbo.SpectrumBusinessLogo));
					// cnf.ScrollToView(SpectrumBusinessLogo);
					 /*if(cnf.JSClick(SpectrumBusinessLogo)){
						 repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Logo is clicked", "Spectrum Business Logo is clicked","PASS",runManagerInfoObj);
						 blnFlag=true;
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Logo is clicked", "Spectrum Business Logo is not clicked","FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }*/
					 
					 Thread.sleep(2000);

				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Logo is displayed", 
							 "Spectrum Business Logo is not displayed","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
		

		 }

		 catch(Exception e)
		 {
			 repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Logo is displayed and clicked", "Spectrum Business Logo is not displayed and not clicked due to some exception.","FAIL",runManagerInfoObj);
			 blnFlag=false;
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());

		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }
	 public synchronized boolean FnVerifyIndexPage(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

		 try{
			 
			
			 if(cnf.FnExplicitWait("XPATH", mbo.LoginWindow,driver)){
				 repfn.FnUpdateTestStepResHTML("Verify User is on Index Page", "User is on Index Page","PASS",runManagerInfoObj);
				 Thread.sleep(2000);
				 blnFlag=true;
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify User is on Index Page", "User is not on Index Page","FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }

		 catch(Exception e)
		 {
			 repfn.FnUpdateTestStepResHTML("Verify User is on Index Page", "User is not on Index Page due to some exception.","FAIL",runManagerInfoObj);
			 blnFlag=false;
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());

		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }
	 public synchronized boolean FnVerifyAndClickSpectrumBusinessLogoSupportPage(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

		 try{
			 
			 Thread.sleep(5000);
			 

				 if(cnf.FnExplicitWait("XPATH", mbo.SpectrumBusinessLogo,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Logo is displayed", 
							 "Spectrum Business Logo is displayed","PASS",runManagerInfoObj);
					 WebElement SpectrumBusinessLogo=driver.findElement(By.xpath(mbo.SpectrumBusinessLogo));
					 cnf.ScrollToView(SpectrumBusinessLogo,driver);
					 if(cnf.JSClick(SpectrumBusinessLogo,driver)){
						 repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Logo is clicked", "Spectrum Business Logo is clicked","PASS",runManagerInfoObj);
						 blnFlag=true;
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Logo is clicked", "Spectrum Business Logo is not clicked","FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
					 
					 Thread.sleep(2000);

				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Logo is displayed", 
							 "Spectrum Business Logo is not displayed","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			

		 }

		 catch(Exception e)
		 {
			 repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Logo is displayed and clicked", "Spectrum Business Logo is not displayed and not clicked due to some exception.","FAIL",runManagerInfoObj);
			 blnFlag=false;
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());

		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }
	 public synchronized boolean FnVerifyPayBillButtonNavigation(WebDriver driver, RunManagerInfo runManagerInfoObj) {
			try{
				if(cnf.FnExplicitWait("XPATH", mbo.Pay_Bill,driver)){
					repfn.FnUpdateTestStepResHTML("Verify whether Pay Bill option is displayed", "Pay Bill option is displayed","PASS",runManagerInfoObj); 

					WebElement PayBill=driver.findElement(By.xpath(mbo.Pay_Bill)); 
					if(cnf.JSClick(PayBill,driver)){
						repfn.FnUpdateTestStepResHTML("Check whether Pay Bill button is clicked", "Pay bill button is clicked","PASS",runManagerInfoObj);

						Thread.sleep(5000);

						if(cnf.FnExplicitWait("XPATH", mbo.PayBill_Page,driver)){
							WebElement PayBillPage=driver.findElement(By.xpath(mbo.PayBill_Page)); 
							String PayBillNavigation = PayBillPage.getText();
							if(PayBillNavigation.contains("Pay Bill"))
							{
								repfn.FnUpdateTestStepResHTML("Check whether User is navigated to Pay Bill Page", "User is navigated to Pay Bill Page","PASS",runManagerInfoObj);	 
								blnFlag=true;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Check whether User is navigated to Pay Bill Page", "User is not navigated to Pay Bill Page","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						} 
						else
						{
							repfn.FnUpdateTestStepResHTML("Check whether User is navigated to Pay Bill Page", "User is not  navigated to Pay Bill Page","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Check whether Pay Bill button is clicked", "Pay bill button is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				} 
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify whether Pay Bill option is displayed", "Pay Bill option is not displayed","FAIL",runManagerInfoObj); 
					blnFlag=false;
				}
			}
			 catch (Exception e)

			 {
			        repfn.FnUpdateTestStepResHTML("Verify User is able to verify Pay Bill Button Navigation",
			                     "User is not able to verify Pay Bill Navigation due to some exception","FAIL",runManagerInfoObj);

			 blnFlag=false;
			        System.err.println("Message : "+e.getMessage());
			        System.err.println("Cause : "+e.getCause());
			        
			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;

		}
	 public synchronized boolean FnVerifyNotificationSection(WebDriver driver, RunManagerInfo runManagerInfoObj) {
			try{
				if(cnf.FnExplicitWait("XPATH", mbo.CurrentBillTitle,driver)){
					repfn.FnUpdateTestStepResHTML("Verify whether Current Bill title is displayed", "Current Bill title is displayed","PASS",runManagerInfoObj); 
				}else{
					repfn.FnUpdateTestStepResHTML("Verify whether Current Bill title is displayed", "Current Bill title is not displayed","FAIL",runManagerInfoObj); 
					blnFlag=false;
				}
				if(cnf.FnExplicitWait("XPATH", mbo.EnrollAutoPayLink,driver)){
					repfn.FnUpdateTestStepResHTML("Verify whether Enroll in Autopay link is displayed", "Enroll in Autopay link is displayed","PASS",runManagerInfoObj); 
					} 
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify whether Enroll in Autopay link is displayed", "Enroll in Autopay link is not displayed","FAIL",runManagerInfoObj); 
					blnFlag=false;
				}
				if(cnf.FnExplicitWait("XPATH", mbo.ViewstatementsLink,driver)){
					repfn.FnUpdateTestStepResHTML("Verify whether View Statements link is displayed", "View Statements link is displayed","PASS",runManagerInfoObj); 
					} 
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify whether View Statements link is displayed", "View Statements link is not displayed","FAIL",runManagerInfoObj); 
					blnFlag=false;
				}
				if(cnf.FnExplicitWait("XPATH", mbo.PaymentHistoryLink,driver)){
					repfn.FnUpdateTestStepResHTML("Verify whether Payment History link is displayed", "Payment History link is displayed","PASS",runManagerInfoObj); 
					} 
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify whether Payment History link is displayed", "Payment History link is not displayed","FAIL",runManagerInfoObj); 
					blnFlag=false;
				}
				if(cnf.FnExplicitWait("XPATH", mbo.Pay_Bill,driver)){
					repfn.FnUpdateTestStepResHTML("Verify whether Pay Bill button is displayed", "Pay Bill button is displayed","PASS",runManagerInfoObj); 
				}else{
					repfn.FnUpdateTestStepResHTML("Verify whether Pay Bill Button is displayed", "Pay Bill Button is not displayed","FAIL",runManagerInfoObj); 
					blnFlag=false;
				}
				if(cnf.FnExplicitWait("XPATH", mbo.BillAmount,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Bill amount is displayed under Current bill title is displayed", "Bill amount is displayed under urrent Bill title is displayed","PASS",runManagerInfoObj); 
					WebElement BillAmount= driver.findElement(By.xpath(mbo.BillAmount)); 
					String Billamount=BillAmount.getText();
					if(cnf.verifyAmountFormat(Billamount)){

						repfn.FnUpdateTestStepResHTML("Verify Bill amount is displayed in format $X XXX.XX","Previous Balance Amount is displayed as:"+Billamount,"PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Bill amount is displayed in format $X XXX.XX","Previous Balance Amount is not displayed as per format:"+Billamount,"FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				
				}else{
					repfn.FnUpdateTestStepResHTML("Verify whether Bill amount is displayed under Current Bill title is displayed", "Bill amount is displayed under Current Bill title is not displayed","FAIL",runManagerInfoObj); 
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.StatementTitle,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Statement: Title is displayed is displayed", "Statement: Title is displayed is displayed","PASS",runManagerInfoObj); 
					if(cnf.FnExplicitWait("XPATH", mbo.StatementDate,driver)){
					WebElement StatementDate= driver.findElement(By.xpath(mbo.StatementDate)); 
					String Statementdate=StatementDate.getText();
					if(cnf.isValidFormat("mm/dd/yy",Statementdate)){

						repfn.FnUpdateTestStepResHTML("Verify Statement date displayed in the format 'MM/DD/YY' ","Statement date is displayed as:"+Statementdate,"PASS",runManagerInfoObj);
						blnFlag=true;
					}else{
						repfn.FnUpdateTestStepResHTML("Verify Statement date displayed is in the format 'MM/DD/YY'","Statement date is not displayed as:"+Statementdate,"FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					}else{
						repfn.FnUpdateTestStepResHTML("Verify whether Statement date is displayed ", "Statement Date is not displayed","FAIL",runManagerInfoObj); 
						blnFlag=false;
					}
				
				}else{
					repfn.FnUpdateTestStepResHTML("Verify whether Statement title is displayed ", "Statement title is displayed is not displayed","FAIL",runManagerInfoObj); 
					blnFlag=false;
				}
				if(cnf.FnExplicitWait("XPATH", mbo.DueByTitle,driver)){
					repfn.FnUpdateTestStepResHTML("Verify DueBy: Title is displayed is displayed", "DueBy: Title is displayed is displayed","PASS",runManagerInfoObj); 
					if(cnf.FnExplicitWait("XPATH", mbo.DueByDate,driver)){
							
					WebElement DueByDate= driver.findElement(By.xpath(mbo.StatementDate)); 
					String DueBydate=DueByDate.getText();
					if(cnf.isValidFormat("mm/dd/yy",DueBydate)){

						repfn.FnUpdateTestStepResHTML("Verify DueBydate date displayed in the format 'MM/DD/YY' ","DueBydate date is displayed as:"+DueBydate,"PASS",runManagerInfoObj);
						blnFlag=true;
					}else{
						repfn.FnUpdateTestStepResHTML("Verify DueBydate date displayed is in the format 'MM/DD/YY'","DueBydate date is not displayed as:"+DueBydate,"FAIL",runManagerInfoObj);
						blnFlag=false;
					}
						}else{
							repfn.FnUpdateTestStepResHTML("Verify whether DueBy date is displayed ", "DueBy Date is not displayed","FAIL",runManagerInfoObj); 
							blnFlag=false;
						}
				
				}else{
					repfn.FnUpdateTestStepResHTML("Verify whether DueBy: title is displayed ", "DueBy: title is not displayed","FAIL",runManagerInfoObj); 
					blnFlag=false;
				}
				
			}
			 catch (Exception e)

			 {
			        repfn.FnUpdateTestStepResHTML("Verify User is able to verify Notifications section for autopay disabled account",
			                     "User is not able to verify Notifications section for autopay disabled account due to some exception","FAIL",runManagerInfoObj);

			 blnFlag=false;
			        System.err.println("Message : "+e.getMessage());
			        System.err.println("Cause : "+e.getCause());
			        
			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;
		}
	 public synchronized boolean FnVerifyEnrollAutoPayButtonNavigation(WebDriver driver, RunManagerInfo runManagerInfoObj) {
			try{
				if(cnf.FnExplicitWait("XPATH", mbo.EnrollAutoPayLink,driver)){
					repfn.FnUpdateTestStepResHTML("Verify whether Enroll in AutoPay link is displayed", "Enroll in AutoPay link is displayed","PASS",runManagerInfoObj); 

					WebElement EnrollAutoPayLink=driver.findElement(By.xpath(mbo.EnrollAutoPayLink)); 
					if(cnf.JSClick(EnrollAutoPayLink,driver)){
						repfn.FnUpdateTestStepResHTML("Check whether Enroll in AutoPay Bill link is clicked", "Enroll in AutoPay link is clicked","PASS",runManagerInfoObj);

						Thread.sleep(5000);

						if(cnf.FnExplicitWait("XPATH", mbo.PayBill_Page,driver)){
							WebElement PayBillPage=driver.findElement(By.xpath(mbo.PayBill_Page)); 
							String PayBillNavigation = PayBillPage.getText();
							if(PayBillNavigation.contains("Pay Bill"))
							{
								repfn.FnUpdateTestStepResHTML("Check whether User is navigated to Pay Bill Page", "User is navigated to Pay Bill Page","PASS",runManagerInfoObj);	 
								blnFlag=true;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Check whether User is navigated to Pay Bill Page", "User is not navigated to Pay Bill Page","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						} 
						else
						{
							repfn.FnUpdateTestStepResHTML("Check whether User is navigated to Pay Bill Page", "User is not  navigated to Pay Bill Page","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Check whether Enroll in AutoPay link is clicked", "Enroll in AutoPay link is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				} 
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify whether Enroll in AutoPay link is displayed", "Enroll in AutoPay link is not displayed","FAIL",runManagerInfoObj); 
					blnFlag=false;
				}
			}
			 catch (Exception e)

			 {
			        repfn.FnUpdateTestStepResHTML("Verify User is able to verify Enroll in AutoPay link Navigation",
			                     "User is not able to verify Enroll in AutoPay link Navigation due to some exception","FAIL",runManagerInfoObj);

			 blnFlag=false;
			        System.err.println("Message : "+e.getMessage());
			        System.err.println("Cause : "+e.getCause());
			        
			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;
		}
	 public synchronized boolean FnVerifyViewStatementsLinkNavigation(WebDriver driver, RunManagerInfo runManagerInfoObj) {
			try{
				if(cnf.FnExplicitWait("XPATH", mbo.ViewstatementsLink,driver)){
					repfn.FnUpdateTestStepResHTML("Verify whether View statements link is displayed", "View statements link is displayed","PASS",runManagerInfoObj); 

					WebElement ViewstatementsLink=driver.findElement(By.xpath(mbo.ViewstatementsLink)); 
					if(cnf.JSClick(ViewstatementsLink,driver)){
						repfn.FnUpdateTestStepResHTML("Check whether View statements link is clicked", "View statements link is clicked","PASS",runManagerInfoObj);

						Thread.sleep(5000);

						if(cnf.FnExplicitWait("XPATH", mbo.ViewStatements_Page,driver)){
							WebElement ViewStatementsPage=driver.findElement(By.xpath(mbo.ViewStatements_Page)); 
							String ViewStatementsPageNavigation = ViewStatementsPage.getText();
							if(ViewStatementsPageNavigation.contains("View Statements"))
							{
								repfn.FnUpdateTestStepResHTML("Check whether User is navigated to View Statements Page", "User is navigated to View Statements Page","PASS",runManagerInfoObj);	 
								blnFlag=true;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Check whether User is navigated to View Statements Page", "User is not navigated to View Statements Page","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						} 
						else
						{
							repfn.FnUpdateTestStepResHTML("Check whether User is navigated to View Statements Page", "User is not  navigated to View Statements Page","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Check whether View statements link is clicked", "View statements link is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				} 
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify whether View statements link is displayed", "View statements link is not displayed","FAIL",runManagerInfoObj); 
					blnFlag=false;
				}
			}
			 catch (Exception e)

			 {
			        repfn.FnUpdateTestStepResHTML("Verify User is able to verify Enroll in AutoPay link Navigation",
			                     "User is not able to verify Enroll in AutoPay link Navigation due to some exception","FAIL",runManagerInfoObj);

			 blnFlag=false;
			        System.err.println("Message : "+e.getMessage());
			        System.err.println("Cause : "+e.getCause());
			        
			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;
			 }
	 public synchronized boolean FnVerifyPaymentHistoryLinkNavigation(WebDriver driver, RunManagerInfo runManagerInfoObj) {
			try{
				if(cnf.FnExplicitWait("XPATH", mbo.PaymentHistoryLink,driver)){
					repfn.FnUpdateTestStepResHTML("Verify whether Payment History link is displayed", "Payment History link is displayed","PASS",runManagerInfoObj); 

					WebElement PaymentHistoryLink=driver.findElement(By.xpath(mbo.PaymentHistoryLink)); 
					if(cnf.JSClick(PaymentHistoryLink,driver)){
						repfn.FnUpdateTestStepResHTML("Check whether Payment History link is clicked", "Payment History link is clicked","PASS",runManagerInfoObj);

						Thread.sleep(5000);

						if(cnf.FnExplicitWait("XPATH", mbo.PaymentHistory_Page,driver)){
							WebElement PaymentHistoryPage=driver.findElement(By.xpath(mbo.PaymentHistory_Page)); 
							String PaymentHistoryPageNavigation = PaymentHistoryPage.getText();
							if(PaymentHistoryPageNavigation.contains("Payment History"))
							{
								repfn.FnUpdateTestStepResHTML("Check whether User is navigated to Payment History Page", "User is navigated to Payment History Page","PASS",runManagerInfoObj);	 
								blnFlag=true;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Check whether User is navigated to Payment History Page", "User is not navigated to Payment History Page","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						} 
						else
						{
							repfn.FnUpdateTestStepResHTML("Check whether User is navigated to Payment History Page", "User is not  navigated to Payment History Page","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Check whether Payment History link is clicked", "View Payment History is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				} 
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify whether Payment History link is displayed", "Payment History link is not displayed","FAIL",runManagerInfoObj); 
					blnFlag=false;
				}
			}
			 catch (Exception e)

			 {
			        repfn.FnUpdateTestStepResHTML("Verify User is able to verify Enroll in AutoPay link Navigation",
			                     "User is not able to verify Enroll in AutoPay link Navigation due to some exception","FAIL",runManagerInfoObj);

			 blnFlag=false;
			        System.err.println("Message : "+e.getMessage());
			        System.err.println("Cause : "+e.getCause());
			        
			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;
		}


	 public synchronized boolean FnVerifyAutoPayIconNavigation(WebDriver driver, RunManagerInfo runManagerInfoObj) {
			try{
				if(cnf.FnExplicitWait("XPATH", mbo.AutoPayIcon,driver)){
					repfn.FnUpdateTestStepResHTML("Verify whether Auto Pay Icon is displayed", "Auto Pay Icon is displayed","PASS",runManagerInfoObj); 

					WebElement AutoPayIcon=driver.findElement(By.xpath(mbo.AutoPayIcon)); 
					if(cnf.JSClick(AutoPayIcon,driver)){
						repfn.FnUpdateTestStepResHTML("Check whether Auto Pay Icon is clicked", "Auto Pay Icon is clicked","PASS",runManagerInfoObj);

						Thread.sleep(5000);

						if(cnf.FnExplicitWait("XPATH", mbo.PayBill_Page,driver)){
							WebElement PayBillPage=driver.findElement(By.xpath(mbo.PayBill_Page)); 
							String PayBillNavigation = PayBillPage.getText();
							if(PayBillNavigation.contains("Pay Bill"))
							{
								repfn.FnUpdateTestStepResHTML("Check whether User is navigated to Pay Bill Page", "User is navigated to Pay Bill Page","PASS",runManagerInfoObj);	 
								blnFlag=true;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Check whether User is navigated to Pay Bill Page", "User is not navigated to Pay Bill Page","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						} 
						else
						{
							repfn.FnUpdateTestStepResHTML("Check whether User is navigated to Pay Bill Page", "User is not  navigated to Pay Bill Page","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Check whether Auto Pay Icon is clicked", " Auto Pay Icon is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				} 
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify whether Auto Pay Icon is displayed", "Manage Auto Pay Icon is not displayed","FAIL",runManagerInfoObj); 
					blnFlag=false;
				}
			}
			 catch (Exception e)

			 {
			        repfn.FnUpdateTestStepResHTML("Verify User is able to verify Auto Pay Icon Navigation",
			                     "User is not able to verify Auto Pay Icon Navigation due to some exception","FAIL",runManagerInfoObj);

			 blnFlag=false;
			        System.err.println("Message : "+e.getMessage());
			        System.err.println("Cause : "+e.getCause());
			        
			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;
		}
	 public synchronized boolean FnVerifyManageAutoPayLinkNavigation(WebDriver driver, RunManagerInfo runManagerInfoObj) {
			try{
				if(cnf.FnExplicitWait("XPATH", mbo.ManageAutoPayLink,driver)){
					repfn.FnUpdateTestStepResHTML("Verify whether Manage Auto Pay Link is displayed", "Manage Auto Pay Link is displayed","PASS",runManagerInfoObj); 

					WebElement ManageAutoPayLink=driver.findElement(By.xpath(mbo.ManageAutoPayLink)); 
					if(cnf.JSClick(ManageAutoPayLink,driver)){
						repfn.FnUpdateTestStepResHTML("Check whether Manage Auto Pay Link is clicked", "Manage Auto Pay Link is clicked","PASS",runManagerInfoObj);

						Thread.sleep(5000);

						if(cnf.FnExplicitWait("XPATH", mbo.PayBill_Page,driver)){
							WebElement PayBillPage=driver.findElement(By.xpath(mbo.PayBill_Page)); 
							String PayBillNavigation = PayBillPage.getText();
							if(PayBillNavigation.contains("Pay Bill"))
							{
								repfn.FnUpdateTestStepResHTML("Check whether User is navigated to Pay Bill Page", "User is navigated to Pay Bill Page","PASS",runManagerInfoObj);	 
								blnFlag=true;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Check whether User is navigated to Pay Bill Page", "User is not navigated to Pay Bill Page","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						} 
						else
						{
							repfn.FnUpdateTestStepResHTML("Check whether User is navigated to Pay Bill Page", "User is not  navigated to Pay Bill Page","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Check whether Manage Auto Pay link is clicked", "Manage Auto Pay link is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				} 
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify whether Manage Auto Pay link is displayed", "Manage Auto Pay link is not displayed","FAIL",runManagerInfoObj); 
					blnFlag=false;
				}
			}
			 catch (Exception e)

			 {
			        repfn.FnUpdateTestStepResHTML("Verify User is able to verify Manage Auto Pay Link Navigation",
			                     "User is not able to verify Mange Auto Pay Link Navigation due to some exception","FAIL",runManagerInfoObj);

			 blnFlag=false;
			        System.err.println("Message : "+e.getMessage());
			        System.err.println("Cause : "+e.getCause());
			        
			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;
		}
	 public synchronized boolean FnVerifyNotificationSections(WebDriver driver, RunManagerInfo runManagerInfoObj) {
			try{
				if(cnf.FnExplicitWait("XPATH", mbo.CurrentBillTitle,driver)){
					repfn.FnUpdateTestStepResHTML("Verify whether Current Bill title is displayed", "Current Bill title is displayed","PASS",runManagerInfoObj); 
				}else{
					repfn.FnUpdateTestStepResHTML("Verify whether Current Bill title is displayed", "Current Bill title is not displayed","FAIL",runManagerInfoObj); 
					blnFlag=false;
				}
				if(cnf.FnExplicitWait("XPATH", mbo.ManageAutoPayLink,driver)){
					repfn.FnUpdateTestStepResHTML("Verify whether Manage Autopay link is displayed", "Manage Autopay link is displayed","PASS",runManagerInfoObj); 
					} 
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify whether Manage Autopay link is displayed", "Manage Autopay link is not displayed","FAIL",runManagerInfoObj); 
					blnFlag=false;
				}
				if(cnf.FnExplicitWait("XPATH", mbo.ViewstatementsLink,driver)){
					repfn.FnUpdateTestStepResHTML("Verify whether View Statements link is displayed", "View Statements link is displayed","PASS",runManagerInfoObj); 
					} 
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify whether View Statements link is displayed", "View Statements link is not displayed","FAIL",runManagerInfoObj); 
					blnFlag=false;
				}
				if(cnf.FnExplicitWait("XPATH", mbo.PaymentHistoryLink,driver)){
					repfn.FnUpdateTestStepResHTML("Verify whether Payment History link is displayed", "Payment History link is displayed","PASS",runManagerInfoObj); 
					} 
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify whether Payment History link is displayed", "Payment History link is not displayed","FAIL",runManagerInfoObj); 
					blnFlag=false;
				}
				if(cnf.FnExplicitWait("XPATH", mbo.AutoPayIcon,driver)){
					repfn.FnUpdateTestStepResHTML("Verify whether Auto Pay Icon is displayed", "Auto Pay Icon is displayed","PASS",runManagerInfoObj); 
				}else{
					repfn.FnUpdateTestStepResHTML("Verify whether Auto Pay Icon is displayed", "Auto Pay Icon is not displayed","FAIL",runManagerInfoObj); 
					blnFlag=false;
				}
				if(cnf.FnExplicitWait("XPATH", mbo.AutoPayOnText,driver)){
					WebElement AutoPayOnText=driver.findElement(By.xpath(mbo.AutoPayOnText));
					String text=AutoPayOnText.getText();
					repfn.FnUpdateTestStepResHTML("Verify whether Auto Pay text is displayed", "Auto Pay text is displayed as:"+text,"PASS",runManagerInfoObj); 
				}else{
					repfn.FnUpdateTestStepResHTML("Verify whether Auto Pay text is displayed", "Auto Pay text is not displayed","FAIL",runManagerInfoObj); 
					blnFlag=false;
				}
				if(cnf.FnExplicitWait("XPATH", mbo.BillAmount,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Bill amount is displayed under Current bill title is displayed", "Bill amount is displayed under urrent Bill title is displayed","PASS",runManagerInfoObj); 
					WebElement BillAmount= driver.findElement(By.xpath(mbo.BillAmount)); 
					String Billamount=BillAmount.getText();
					if(cnf.verifyAmountFormat(Billamount)){

						repfn.FnUpdateTestStepResHTML("Verify Bill amount is displayed in format $X XXX.XX","Previous Balance Amount is displayed as:"+Billamount,"PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Bill amount is displayed in format $X XXX.XX","Previous Balance Amount is not displayed as per format:"+Billamount,"FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				
				}else{
					repfn.FnUpdateTestStepResHTML("Verify whether Bill amount is displayed under Current Bill title is displayed", "Bill amount is displayed under Current Bill title is not displayed","FAIL",runManagerInfoObj); 
					blnFlag=false;
				}
				
			
				/*if(cnf.FnExplicitWait("XPATH", mbo.DueByTitle)){
					repfn.FnUpdateTestStepResHTML("Verify DueBy: Title is displayed is displayed", "DueBy: Title is displayed is displayed","PASS",runManagerInfoObj); 
					if(cnf.FnExplicitWait("XPATH", mbo.DueByDate)){
							
					WebElement DueByDate= driver.findElement(By.xpath(mbo.StatementDate)); 
					String DueBydate=DueByDate.getText();
					if(cnf.isValidFormat("mm/dd/yy",DueBydate)){

						repfn.FnUpdateTestStepResHTML("Verify DueBydate date displayed in the format 'MM/DD/YY' ","DueBydate date is displayed as:"+DueBydate,"PASS",runManagerInfoObj);
						blnFlag=true;
					}else{
						repfn.FnUpdateTestStepResHTML("Verify DueBydate date displayed is in the format 'MM/DD/YY'","DueBydate date is not displayed as:"+DueBydate,"FAIL",runManagerInfoObj);
						blnFlag=false;
					}
						}else{
							repfn.FnUpdateTestStepResHTML("Verify whether DueBy date is displayed ", "DueBy Date is not displayed","FAIL",runManagerInfoObj); 
							blnFlag=false;
						}
				
				}else{
					repfn.FnUpdateTestStepResHTML("Verify whether DueBy: title is displayed ", "DueBy: title is not displayed","FAIL",runManagerInfoObj); 
					blnFlag=false;
				}*/
				
			}
			 catch (Exception e)

			 {
			        repfn.FnUpdateTestStepResHTML("Verify User is able to verify Notifications section for autopay disabled account",
			                     "User is not able to verify Notifications section for autopay disabled account due to some exception","FAIL",runManagerInfoObj);

			 blnFlag=false;
			        System.err.println("Message : "+e.getMessage());
			        System.err.println("Cause : "+e.getCause());
			        
			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;
		}
	 public synchronized boolean FnVerifySectionsDisplayed(WebDriver driver, RunManagerInfo runManagerInfoObj) {
			try{
				if(cnf.FnExplicitWait("XPATH", mbo.SpectrumServicesSection,driver)){
					repfn.FnUpdateTestStepResHTML("Verify whether Spectrum Services Section is displayed", "Spectrum Services Section is displayed","PASS",runManagerInfoObj); 
				}else{
					repfn.FnUpdateTestStepResHTML("Verify whether Spectrum Services Section  is displayed", "Spectrum Services Section is not displayed","FAIL",runManagerInfoObj); 
					blnFlag=false;
				}
				if(cnf.FnExplicitWait("XPATH", mbo.MoreServicesSection,driver)){
					repfn.FnUpdateTestStepResHTML("Verify whether More Services Section is displayed", "More Services Section is displayed","PASS",runManagerInfoObj); 
				}else{
					repfn.FnUpdateTestStepResHTML("Verify whether More Services Section is displayed", "More Services Section is not displayed","FAIL",runManagerInfoObj); 
					blnFlag=false;
				}
				if(cnf.FnExplicitWait("XPATH", mbo.AccountServicesSection,driver)){
					repfn.FnUpdateTestStepResHTML("Verify whether Account Section is displayed", "Account Section is displayed","PASS",runManagerInfoObj); 
				}else{
					repfn.FnUpdateTestStepResHTML("Verify whether Account Sectione is displayed", "Account Section is not displayed","FAIL",runManagerInfoObj); 
					blnFlag=false;
				}
			}
			 catch (Exception e)

			 {
			        repfn.FnUpdateTestStepResHTML("Verify User is able to verify sections on Overview Page",
			                     "User is not able to verify sections on Overview page due to some exception","FAIL",runManagerInfoObj);

			 blnFlag=false;
			        System.err.println("Message : "+e.getMessage());
			        System.err.println("Cause : "+e.getCause());
			        
			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;
		}

}
