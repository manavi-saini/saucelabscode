package com.charter.sb.services;

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

public class Q2NotificationsService extends Initialization {
	MB_PageObjects mbo = new MB_PageObjects();
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	public static boolean blnFlag = false;
	public synchronized boolean PastDue_AccountOwner(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
	{
		try
		{
			if(cnf.FnExplicitWait("XPATH", mbo.Past_Due,driver)){
				WebElement PastDueText=driver.findElement(By.xpath(mbo.Past_Due)); 
				String PastDue_Text = PastDueText.getText();
				repfn.FnUpdateTestStepResHTML("Verify whether Past Due text is displayed for Account Owner", "Past Due text is displayed for Account Owner","PASS" ,runManagerInfoObj); 
				if(PastDue_Text.contains("Past Due Balance - Due Now"))
				{
					repfn.FnUpdateTestStepResHTML("Verify Past Due text displayed", "Past Due text displayed is: "+PastDue_Text,"PASS" ,runManagerInfoObj); 
					if(cnf.FnExplicitWait("XPATH", mbo.Pay_Bill,driver)){
						repfn.FnUpdateTestStepResHTML("Verify whether Pay Bill option is displayed", "Pay Bill option is displayed","PASS" ,runManagerInfoObj); 

						WebElement PayBill=driver.findElement(By.xpath(mbo.Pay_Bill)); 
						if(cnf.JSClick(PayBill,driver)){
							repfn.FnUpdateTestStepResHTML("Check whether Pay Bill button is clicked", "Pay bill button is clicked","PASS" ,runManagerInfoObj);

							Thread.sleep(5000);

							if(cnf.FnExplicitWait("XPATH", mbo.PayBill_Page,driver)){
								WebElement PayBillPage=driver.findElement(By.xpath(mbo.PayBill_Page)); 
								String PayBillNavigation = PayBillPage.getText();
								if(PayBillNavigation.contains("Pay Bill"))
								{
									repfn.FnUpdateTestStepResHTML("Check whether User is navigated to Pay Bill Page", "User is navigated to Pay Bill Page","PASS" ,runManagerInfoObj);	 
									blnFlag=true;
								}
								else
								{
									repfn.FnUpdateTestStepResHTML("Check whether User is navigated to Pay Bill Page", "User is not navigated to Pay Bill Page","FAIL" ,runManagerInfoObj);
									blnFlag=false;
								}
							} 
							else
							{
								repfn.FnUpdateTestStepResHTML("Check whether User is navigated to Pay Bill Page", "User is not  navigated to Pay Bill Page","FAIL" ,runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Check whether Pay Bill button is clicked", "Pay bill button is not clicked","FAIL" ,runManagerInfoObj);
							blnFlag=false;
						}
					} 
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify whether Pay Bill option is displayed", "Pay Bill option is not displayed","FAIL" ,runManagerInfoObj); 
						blnFlag=false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify Past Due text displayed", "Past Due text displayed is: "+PastDue_Text,"FAIL" ,runManagerInfoObj); 
					blnFlag=false;
				}
			} 
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify whether Past Due text is displayed for Account Owner", "Past Due text is not displayed for Account Owner. User Account is not Past Due","PASS" ,runManagerInfoObj); 
				blnFlag=true;
			}
		}
		catch(Exception e)
		{
			repfn.FnUpdateTestStepResHTML("Verify whether User is able to check the account is past due for Account Owner","User is not able to check the account is past due for Account Owner due to some exception","FAIL" ,runManagerInfoObj);
			blnFlag=false;
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());

		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;

	}

	public synchronized boolean PastDue_StandardUser(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
	{
		try
		{
			if(cnf.FnExplicitWait("XPATH", mbo.Past_Due,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Past Due Billing notification and Bill details are not displayed for a Standard User", "Past Due Billing notification and Bill details are displayed for a Standard User","FAIL" ,runManagerInfoObj); 
				blnFlag=false;
			} 
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify Past Due Billing notification and Bill details are not displayed for a Standard User", "Past Due Billing notification and Bill details are not displayed for a Standard User","PASS" ,runManagerInfoObj); 
				blnFlag=true;
			}
		}
		catch(Exception e)
		{
			repfn.FnUpdateTestStepResHTML("Verify whether User is able to check the account is past due for a Standard User","User is not able to check the account is past due for a Standard User due to some exception","FAIL" ,runManagerInfoObj);
			blnFlag=false;
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());

		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;

	}
	public synchronized boolean PastDue_BillingUser(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
	{
		try
		{
			if(cnf.FnExplicitWait("XPATH", mbo.Past_Due,driver)){
				WebElement PastDueText=driver.findElement(By.xpath(mbo.Past_Due)); 
				String PastDue_Text = PastDueText.getText();
				repfn.FnUpdateTestStepResHTML("Verify whether Past Due text is displayed for Billing User", "Past Due text is displayed for Billing User","PASS" ,runManagerInfoObj); 
				if(PastDue_Text.contains("Past Due Balance - Due Now"))
				{
					repfn.FnUpdateTestStepResHTML("Verify Past Due text displayed", "Past Due text displayed is: "+PastDue_Text,"PASS" ,runManagerInfoObj); 
					if(cnf.FnExplicitWait("XPATH", mbo.Pay_Bill,driver)){
						repfn.FnUpdateTestStepResHTML("Verify whether Pay Bill option is displayed", "Pay Bill option is displayed","PASS" ,runManagerInfoObj); 

						WebElement PayBill=driver.findElement(By.xpath(mbo.Pay_Bill)); 
						if(cnf.JSClick(PayBill,driver)){
							repfn.FnUpdateTestStepResHTML("Check whether Pay Bill button is clicked", "Pay bill button is clicked","PASS" ,runManagerInfoObj);

							Thread.sleep(5000);

							if(cnf.FnExplicitWait("XPATH", mbo.PayBill_Page,driver)){
								WebElement PayBillPage=driver.findElement(By.xpath(mbo.PayBill_Page)); 
								String PayBillNavigation = PayBillPage.getText();
								if(PayBillNavigation.contains("Pay Bill"))
								{
									repfn.FnUpdateTestStepResHTML("Check whether User is navigated to Pay Bill Page", "User is navigated to Pay Bill Page","PASS" ,runManagerInfoObj);	 
									blnFlag=true;
								}
								else
								{
									repfn.FnUpdateTestStepResHTML("Check whether User is navigated to Pay Bill Page", "User is not navigated to Pay Bill Page","FAIL" ,runManagerInfoObj);
									blnFlag=false;
								}
							} 
							else
							{
								repfn.FnUpdateTestStepResHTML("Check whether User is navigated to Pay Bill Page", "User is not  navigated to Pay Bill Page","FAIL" ,runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Check whether Pay Bill button is clicked", "Pay bill button is not clicked","FAIL" ,runManagerInfoObj);
							blnFlag=false;
						}
					} 
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify whether Pay Bill option is displayed", "Pay Bill option is not displayed","FAIL" ,runManagerInfoObj); 
						blnFlag=false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify Past Due text displayed", "Past Due text displayed is: "+PastDue_Text,"FAIL" ,runManagerInfoObj); 
					blnFlag=false;
				}
			} 
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify whether Past Due text is displayed for Billing User", "Past Due text is not displayed for Billing User. User Account is not Past Due","PASS" ,runManagerInfoObj); 
				blnFlag=true;
			}
		}
		catch(Exception e)
		{
			repfn.FnUpdateTestStepResHTML("Verify whether User is able to check the account is past due:","User is not able to check the account is past due","FAIL" ,runManagerInfoObj);
			blnFlag=false;
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());

		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;

	}

	public synchronized boolean Voice_UnreadMessages(WebDriver driver, RunManagerInfo runManagerInfoObj)
	{
		try
		{
			if(cnf.FnExplicitWait("XPATH", mbo.Voice_Notifications_Line,driver))
			{
				List <WebElement> Phone=driver.findElements(By.xpath(mbo.Voice_Notifications_Line));
				for(int i=0;i<Phone.size();i++){
					repfn.FnUpdateTestStepResHTML("Verify if Voice Notifications are present", "Voice Notifications are present for: "+Phone.get(i).getText(), "PASS" ,runManagerInfoObj);
					blnFlag=true;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.Voice_Notifications_UnreadMessages,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if Notifications is displayed for Unread messages", "Notifications is displayed for unread messages for phone line: "+Phone.get(0).getText(), "PASS" ,runManagerInfoObj);
					List<WebElement> Voice_Notifications_UnreadMessages=driver.findElements(By.xpath(mbo.Voice_Notifications_UnreadMessages));
					if(cnf.JSClick(Voice_Notifications_UnreadMessages.get(0),driver)){
						repfn.FnUpdateTestStepResHTML("Verify whether Unread messages notification for the Voice Line is clicked", "Unread messages notification for the Voice Line is clicked","PASS" ,runManagerInfoObj);
						
						if(cnf.FnExplicitWait("XPATH", mbo.Navigate_To_Voice_Page,driver)){

							WebElement Voice_Page=driver.findElement(By.xpath(mbo.Navigate_To_Voice_Page));
							String Voice_Page_text=Voice_Page.getText();
							if(Voice_Page_text.contains("Messages"))
							{
								repfn.FnUpdateTestStepResHTML("Check whether the user is navigated to Messages page on clicking Unread messages", "User is navigated to Messages Page" ,"PASS" ,runManagerInfoObj); 
								blnFlag=true;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Check whether the user is navigated to Messages page on clicking Unread messages", "User is not navigated to Messages Page" ,"FAIL" ,runManagerInfoObj);	 
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Check whether the user is navigated to Messages page ", "User is not navigated to Messages Page" ,"FAIL" ,runManagerInfoObj); 
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify whether Unread messages notification for the Voice Line is clicked", "Unread messages notification for the Voice Line is not clicked","FAIL" ,runManagerInfoObj);
						blnFlag=false;
					}
				}
				else
				{
					if(cnf.FnExplicitWait("XPATH", mbo.No_Notifications,driver))
					{
						WebElement No_Notifications=driver.findElement(By.xpath(mbo.No_Notifications));
						repfn.FnUpdateTestStepResHTML("Check whether Notifications present for Unread Messages for the Voice Line", "No Notifications present for Unread Messages for the Voice Line as notification displayed as: "+No_Notifications.getText(),"FAIL" ,runManagerInfoObj);   
						blnFlag=false;
					}
					else 
					{
						repfn.FnUpdateTestStepResHTML("Check whether Unread Messages are present for the Voice Line", "Unread messages are not present for the voice line" ,"FAIL" ,runManagerInfoObj);   
						blnFlag=false;
					}
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if Voice Notifications are present", "Voice Notifications are not present", "FAIL" ,runManagerInfoObj);
				blnFlag=false;
			}
		}

		catch(Exception e)
		{

			repfn.FnUpdateTestStepResHTML("Verify whether User is able to verify Un-read messages in Navigation panel","User is not able to verify Un-read messages in Navigation panel","FAIL" ,runManagerInfoObj);
			blnFlag=false;
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());

		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;

	}
	public synchronized boolean Calllog_MissedCalls(WebDriver driver, RunManagerInfo runManagerInfoObj)
	{
		try
		{
			if(cnf.FnExplicitWait("XPATH", mbo.Voice_Notifications_Line,driver))
			{
				List <WebElement> Phone=driver.findElements(By.xpath(mbo.Voice_Notifications_Line));
				for(int i=0;i<Phone.size();i++){
					repfn.FnUpdateTestStepResHTML("Verify if Voice Notifications are present", "Voice Notifications are present for: "+Phone.get(i).getText(), "PASS" ,runManagerInfoObj);
					blnFlag=true;
				}

				if(cnf.FnExplicitWait("XPATH", mbo.Voice_Notifications_MissedCalls,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if Notifications is displayed when there are missed calls", "Notification is displayed when there are missed calls", "PASS" ,runManagerInfoObj);
					List <WebElement> Voice_Notifications_MissedCalls=driver.findElements(By.xpath(mbo.Voice_Notifications_MissedCalls));
					repfn.FnUpdateTestStepResHTML("Verify if the number of missed calls is displayed in the Notifications panel", "Missed calls notification is being displayed for phone Line: "+Phone.get(0).getText()+". Text displayed is: "+Voice_Notifications_MissedCalls.get(0).getText(), "PASS" ,runManagerInfoObj);
					if(cnf.JSClick(Voice_Notifications_MissedCalls.get(0),driver)){
						repfn.FnUpdateTestStepResHTML("Check whether missed calls notification for the Voice Line is clicked", "Missed call notification for the Voice Line is clicked","PASS" ,runManagerInfoObj);

						if(cnf.FnExplicitWait("XPATH", mbo.Calllog_Page,driver)){

							WebElement Calls_Page=driver.findElement(By.xpath(mbo.Calllog_Page));
							String Calls_Page_text=Calls_Page.getText();
							if(Calls_Page_text.contains("Call Log"))
							{
								repfn.FnUpdateTestStepResHTML("Check whether the User is navigated to Call logs page on clicking missed calls", "User is navigated to Call logs Page" ,"PASS" ,runManagerInfoObj); 
								blnFlag=true;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Check whether the User is navigated to Call logs page on clicking missed calls", "User is not navigated to Call logs Page" ,"FAIL" ,runManagerInfoObj);	 
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Check whether the user is navigated to Call logs page ", "User is not navigated to Call logs Page" ,"FAIL" ,runManagerInfoObj); 
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Check whether missed calls notification for the Voice Line is clicked", "Missed call notification for the Voice Line is not clicked","FAIL" ,runManagerInfoObj);
						blnFlag=false;
					}
				}
				else if(cnf.FnExplicitWait("XPATH", mbo.Overview_NoMissedCall,driver))
				{
					WebElement No_MissedCalls=driver.findElement(By.xpath(mbo.Overview_NoMissedCall));
					repfn.FnUpdateTestStepResHTML("Check whether missed calls present for the Voice Line", "No missed calls present for the Voice Line as notification displayed as: "+No_MissedCalls.getText(),"FAIL" ,runManagerInfoObj);   
					blnFlag=false;
				}
				else if(cnf.FnExplicitWait("XPATH", mbo.No_Notifications,driver))
				{
					WebElement No_Notifications=driver.findElement(By.xpath(mbo.No_Notifications));
					repfn.FnUpdateTestStepResHTML("Check whether Notifications present  for the Voice Line", "No Notifications present for the Voice Line as notification displayed as: "+No_Notifications.getText(),"FAIL" ,runManagerInfoObj);   
					blnFlag=false;
				} 
				else 
				{
					repfn.FnUpdateTestStepResHTML("Check whether Missed calls are present for the Voice Line", "Missed calls are not present for the voice line" ,"FAIL" ,runManagerInfoObj);   
					blnFlag=false;
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if Voice Notifications are present", "Voice Notifications are not present", "FAIL" ,runManagerInfoObj);
				blnFlag=false;
			}
		}

		catch(Exception e)
		{
			repfn.FnUpdateTestStepResHTML("Verify whether User is able to verify Un-read messages in Navigation panel","User is not able to verify Un-read messages in Navigation panel","FAIL" ,runManagerInfoObj);
			blnFlag=false;
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;

	}

}
