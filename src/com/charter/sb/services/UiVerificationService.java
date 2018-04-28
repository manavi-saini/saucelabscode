package com.charter.sb.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.charter.sb.beans.RunManagerInfo;
import com.charter.sb.controllers.Initialization;
import com.charter.sb.resources.MB_PageObjects;
import com.charter.sb.utils.CommonFunctions;
import com.charter.sb.utils.ReportingFunctions;
import com.charter.sb.utils.RunManager;

public class UiVerificationService extends Initialization {
	MB_PageObjects mbo = new MB_PageObjects();
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	public static boolean blnFlag = false;
	Random rg=new Random();
	int randomInt = rg.nextInt(10000);
	public synchronized boolean UserRecovery(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
	{
		try
		{
			if(cnf.FnExplicitWait("XPATH", mbo.ForgotUserNamePassword,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify if Forgot UserName/Password link is displayed", "Forgot UserName/Password Link is displayed", "PASS",runManagerInfoObj);
				WebElement Recovery=driver.findElement(By.xpath(mbo.ForgotUserNamePassword));

				if(cnf.JSClick(Recovery,driver)){
					repfn.FnUpdateTestStepResHTML("Verify if Forgot UserName/Password link is clicked", "Forgot UserName/Password Link is clicked", "PASS",runManagerInfoObj);

					if(cnf.FnExplicitWait("XPATH", mbo.VerifyRecoveryUsernamePwdpage,driver)){
						repfn.FnUpdateTestStepResHTML("Verify if Forgot Username/Password page is displayed","Forgot Username/Password page is displayed","PASS",runManagerInfoObj);
						
						if(cnf.FnExplicitWait("XPATH", mbo.SpectrumLogoClick,driver)){
							WebElement SpectrumLogoClick=driver.findElement(By.xpath(mbo.SpectrumLogoClick));
							if(cnf.JSClick(SpectrumLogoClick,driver)){
							repfn.FnUpdateTestStepResHTML("Verify if spectrum logo is clicked","Spectrum logo is clicked","PASS",runManagerInfoObj);
							blnFlag=true;
							}
							else{
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify if spectrum logo is clicked","Spectrum logo is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify if Forgot Username/Password page is displayed","Forgot Username/Password page is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify if Forgot UserName/Password link is clicked", "Forgot UserName/Password Link is not clicked", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if Forgot UserName/Password link is displayed", "Forgot UserName/Password Link is not displayed", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}

		}
		catch (Exception e)

		{
			repfn.FnUpdateTestStepResHTML("Verify if User is navigated to forgot Username/Password Page", "User is not navigated to Forgot Username/Password page due to some exception", "FAIL",runManagerInfoObj);
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			blnFlag=false;
			//repfn.FnUpdateTestStepResHTML("Verify if the shelf services and equipment in the overwiew page is displayed", "verify did not happen ","FAIL",runManagerInfoObj);
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	public synchronized boolean CreateNewId(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
	{
		try
		{
			if(cnf.FnExplicitWait("XPATH", mbo.CreateNewId,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Create New Spectrum Account link is displayed","Create New Spectrum Account link is displayed","PASS",runManagerInfoObj);
				WebElement NewId=driver.findElement(By.xpath(mbo.CreateNewId));
				if(cnf.JSClick(NewId,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Create New Spectrum Account link is clicked","Create New Spectrum Account link is clicked","PASS",runManagerInfoObj);
					
					if(cnf.FnExplicitWait("XPATH", mbo.CreateNewIdpage,driver)){
						repfn.FnUpdateTestStepResHTML("Verify if Create New Account page is displayed","Create New account page is displayed","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify if Create New Account page is displayed","Create New account page is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Create New Spectrum Account link is clicked","Create New Spectrum Account link is not clicked","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Create New Spectrum Account link is displayed","Create New Spectrum Account link is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		catch (Exception e)

		{
			repfn.FnUpdateTestStepResHTML("Verify if user is navigated to create New Account Page", "User is not navigated to Create New Account page due to some exception", "FAIL",runManagerInfoObj);
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			blnFlag=false;
			//repfn.FnUpdateTestStepResHTML("Verify if the shelf services and equipment in the overwiew page is displayed", "verify did not happen ","FAIL",runManagerInfoObj);
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	
	 
	public synchronized boolean FN_FooterLinkClick(WebDriver driver, RunManagerInfo runManagerInfoObj){
		try{
			if(cnf.FnExplicitWait("XPATH",mbo.FooterDotLink,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify Footer Dot Link is displayed", "Footer Dot Link is displayed","PASS",runManagerInfoObj);
				WebElement FooterDotLink=driver.findElement(By.xpath(mbo.FooterDotLink));
				cnf.ScrollToView(FooterDotLink,driver);
				
				if(cnf.JSClick(FooterDotLink,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Footer Dot Link is clicked ", "Footer Dot Link is clicked ","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Footer Dot Link is clicked ", "Footer Dot Link is not clicked ","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify Footer Dot Link is displayed", "Footer Dot Link is not displayed", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}


		catch(Exception e)
		{

			repfn.FnUpdateTestStepResHTML("FooterDotLink is displayed and clicked ", "FooterDotLink is not displayed and not clicked due to some exception","FAIL",runManagerInfoObj);
			blnFlag=false;
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;

	}
public synchronized boolean LogoutUser(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
		
		try{
			if(cnf.FnExplicitWait("XPATH", mbo.headerDropdown,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify if Header dropdown link is displayed","Header dropdown link is displayed","PASS",runManagerInfoObj);
				WebElement headerDropdown=driver.findElement(By.xpath(mbo.headerDropdown));
				if(cnf.JSClick(headerDropdown,driver)){
					repfn.FnUpdateTestStepResHTML("Verify if Header dropdown link is clicked","Header dropdown link is clicked","PASS",runManagerInfoObj);
					if(cnf.FnExplicitWait("XPATH", mbo.LogoutHeader,driver)){
						repfn.FnUpdateTestStepResHTML("Verify if Sign Out link is displayed","Sign Out link is displayed","PASS",runManagerInfoObj);
						WebElement LogoutHeader=driver.findElement(By.xpath(mbo.LogoutHeader));
						if(cnf.JSClick(LogoutHeader,driver)){
							repfn.FnUpdateTestStepResHTML("Verify if Sign Out link is clicked","Sign Out link is clicked","PASS",runManagerInfoObj);
							Thread.sleep(3000);
							if(driver.getCurrentUrl().contains("index.html")){
								repfn.FnUpdateTestStepResHTML("Verify User is navigated to Login Page URL","User is navigated to login page URL: "+driver.getCurrentUrl(),"PASS",runManagerInfoObj);

								if(cnf.FnExplicitWait("XPATH", mbo.Logo,driver)){
									WebElement Homeredirect=driver.findElement(By.xpath(mbo.Logo));
									cnf.JSClick(Homeredirect,driver);
									Thread.sleep(5000);
									if(driver.getCurrentUrl().contains("login")){
										repfn.FnUpdateTestStepResHTML("Verify User is navigated to Home page URL","User is navigated to Home page URL","PASS",runManagerInfoObj);
										blnFlag=true;
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify User is navigated to Home page URL","User is not navigated to Home page URL","FAIL",runManagerInfoObj);
										blnFlag=false;
									}							
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify if Spectrum Business Logo is displayed","Spectrum Business Logo is not displayed","FAIL",runManagerInfoObj);
									blnFlag=false;
								}		
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify User is navigated to Logout URL","User is not navigated to Logout URL","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify if Sign Out link is clicked","Sign Out link is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify if Sign Out link is displayed","Sign Out link is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}				
				else{
					repfn.FnUpdateTestStepResHTML("Verify if Header dropdown link is clicked","Header dropdown link is not clicked","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify if Header dropdown link is displayed","Header dropdown link is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		
		catch (Exception e)

		{
			repfn.FnUpdateTestStepResHTML("Verify User is able to logout", "User is not able to logout due to some exception","FAIL",runManagerInfoObj);
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			blnFlag=false;
			//repfn.FnUpdateTestStepResHTML("Verify if the shelf services and equipment in the overwiew page is displayed", "verify did not happen ","FAIL",runManagerInfoObj);
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
public synchronized boolean FnVerifySupportLinkNavigation_Footer(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
	
	try{
		// Techincal Support Link
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_TechicalSupport,driver)){
			repfn.FnUpdateTestStepResHTML("Verify \'Technical Support\' Link is displayed under Support Header", "\'Technical Support\' Link is displayed under Support Header","PASS",runManagerInfoObj);
			
			WebElement Footer_TechicalSupport=driver.findElement(By.xpath(mbo.Footer_TechicalSupport));
			ArrayList<String> oldTab = new ArrayList<String>(driver.getWindowHandles());
			if(cnf.JSClick(Footer_TechicalSupport,driver)){
				repfn.FnUpdateTestStepResHTML("Verify \'Technical Support\' Link is clicked", "\'Technical Support\' Link is clicked","PASS",runManagerInfoObj);
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
				
				if(driver.getCurrentUrl().contains("support")){
					repfn.FnUpdateTestStepResHTML("Verify User is navigated to Support page", "User is navigated to Support page","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User is navigated to Support page", "User is not navigated to Support page","FAIL",runManagerInfoObj);
					blnFlag=false;
				}				
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify \'Technical Support\' Link is clicked", "\'Technical Support\' Link is not clicked","FAIL",runManagerInfoObj);
				blnFlag=false;
			}			
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Technical Support\' Link is displayed under Support Header", "\'Technical Support\' Link is not displayed under Support Header","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		
	}
	
	catch (Exception e)

	{
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		repfn.FnUpdateTestStepResHTML("Verify User is navigated to Support page", "User is not navigated to Support page due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;

	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean FN_FooterLinkManageAccountSectionClick(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
	try{
		
		//Footer_ManageAccount
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_ManageAccount,driver)){
			repfn.FnUpdateTestStepResHTML("Verify \'Manage Account\' Header is displayed in Expanded Footer", "\'Manage Account\' Header is displayed in Expanded Footer","PASS",runManagerInfoObj);
			blnFlag=true;
		}			
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Manage Account\' Header is displayed in Expanded Footer", "\'Manage Account\' Header is not displayed in Expanded Footer","FAIL",runManagerInfoObj);
			blnFlag=false;
		}


		// Footer_Overview

		if(cnf.FnExplicitWait("XPATH",mbo.Footer_Overview,driver)){
			repfn.FnUpdateTestStepResHTML("Verify \'Overview\' link is displayed under Manage Account Header", "\'Overview\' link is displayed under Manage Account Header","PASS",runManagerInfoObj);
			WebElement Footer_Overview=driver.findElement(By.xpath(mbo.Footer_Overview));

			if(cnf.JSClick(Footer_Overview,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify \'Overview\' link is clicked", "\'Overview\' link is clicked","PASS",runManagerInfoObj);
				Thread.sleep(2000);
				if(cnf.FnExplicitWait("XPATH", mbo.Home_OverviewLabel,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify User is navigated to Overview Page","User is navigated to overview page","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User is navigated to Overview Page","User is not navigated to overview page","PASS",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify \'Overview\' link is clicked", "\'Overview\' link is not clicked","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Overview\' link is displayed under Manage Account Header", "\'Overview\' link is not displayed under Manage Account Header","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		
		Thread.sleep(3000);
		blnFlag=FN_FooterLinkClick(driver, runManagerInfoObj);
		//Footer_BillingTrans
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_BillingTrans,driver)){
			repfn.FnUpdateTestStepResHTML("Verify \'Billing and Transactions\' link is displayed under Manage Account Header", "\'Billing and Transactions\' link is displayed under Manage Account Header","PASS",runManagerInfoObj);
			WebElement Footer_BillingTrans=driver.findElement(By.xpath(mbo.Footer_BillingTrans));
			if(cnf.JSClick(Footer_BillingTrans,driver))
			{					
				repfn.FnUpdateTestStepResHTML("Verify \'Billing and Transactions\' link is clicked", "\'Billing and Transactions\' link is clicked","PASS",runManagerInfoObj);
				Thread.sleep(10000);
				 if(cnf.FnExplicitWait("XPATH", mbo.PageVerificationOne,driver)){
					 WebElement payBill_PageVerification_1=driver.findElement(By.xpath(mbo.PageVerificationOne));
					 if(payBill_PageVerification_1.getAttribute("textContent").equalsIgnoreCase("Billing")){
						 if(cnf.FnExplicitWait("XPATH", mbo.PageVerificationTwo,driver)){
							 WebElement payBill_PageVerification_2=driver.findElement(By.xpath(mbo.PageVerificationTwo));
							 if(payBill_PageVerification_2.getAttribute("textContent").equalsIgnoreCase("Pay Bill")){
								 repfn.FnUpdateTestStepResHTML("Verify User is navigated to Pay Bill Page","User is navigated to Pay Bill page","PASS",runManagerInfoObj);
								 blnFlag=true;
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify User is navigated to Pay Bill Page","User is not navigated to Pay Bill page","FAIL",runManagerInfoObj);
								 blnFlag=false;
							 }
						 }
					 }
				 }
				 
				blnFlag=FN_FooterLinkClick(driver, runManagerInfoObj);

			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify \'Billing and Transactions\' link is clicked", "\'Billing and Transactions\' link is not clicked","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Billing and Transactions\' link is displayed under Manage Account Header", "\'Billing and Transactions\' link is not displayed under Manage Account Header","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		

		Thread.sleep(5000);

		//Footer_CurrentBill
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_CurrentBill,driver)){
			repfn.FnUpdateTestStepResHTML("Verify \'View Current Bill\' link is displayed under Manage Account Header", "\'View Current Bill\' link is displayed under Manage Account Header","PASS",runManagerInfoObj);
			
			WebElement Footer_CurrentBill=driver.findElement(By.xpath(mbo.Footer_CurrentBill));
			if(cnf.JSClick(Footer_CurrentBill,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify \'View Current Bill\' link is clicked", "\'View Current Bill\' link is clicked","PASS",runManagerInfoObj);
				Thread.sleep(7000);
				
				 if(cnf.FnExplicitWait("XPATH", mbo.PageVerificationOne,driver)){
					 WebElement payBill_PageVerification_1=driver.findElement(By.xpath(mbo.PageVerificationOne));
					 if(payBill_PageVerification_1.getAttribute("textContent").equalsIgnoreCase("Billing")){
						 if(cnf.FnExplicitWait("XPATH", mbo.PageVerificationTwo,driver)){
							 WebElement payBill_PageVerification_2=driver.findElement(By.xpath(mbo.PageVerificationTwo));
							 if(payBill_PageVerification_2.getAttribute("textContent").equalsIgnoreCase("View Statements")){
								 repfn.FnUpdateTestStepResHTML("Verify User is navigated to View Statements Page","User is navigated to View Statements page","PASS",runManagerInfoObj);
								 blnFlag=true;
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify User is navigated to View Statements Page","User is not navigated to View Statements page","FAIL",runManagerInfoObj);
								 blnFlag=false;
							 }
						 }
					 }
				 }
				driver.navigate().refresh();
				blnFlag=FN_FooterLinkClick(driver, runManagerInfoObj);

			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify \'View Current Bill\' link is clicked", "\'View Current Bill\' link is not clicked","FAIL",runManagerInfoObj);
				blnFlag=false;

			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'View Current Bill\' link is displayed under Manage Account Header", "\'View Current Bill\' link is not displayed under Manage Account Header","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		
		Thread.sleep(5000);
		
			
		//Footer_BillDelivery
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_BillDelivery,driver)){
			repfn.FnUpdateTestStepResHTML("Verify \'Bill Delivery Options\' link is displayed under Manage Account Header", "\'Bill Delivery Options\' link is displayed under Manage Account Header","PASS",runManagerInfoObj);
			WebElement Footer_BillDelivery=driver.findElement(By.xpath(mbo.Footer_BillDelivery));
			
			if(cnf.JSClick(Footer_BillDelivery,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify \'Bill Delivery Options\' link is clicked", "\'Bill Delivery Options\' link is clicked","PASS",runManagerInfoObj);
				Thread.sleep(5000);
				
				 if(cnf.FnExplicitWait("XPATH", mbo.PageVerificationOne,driver)){
					 WebElement payBill_PageVerification_1=driver.findElement(By.xpath(mbo.PageVerificationOne));
					 if(payBill_PageVerification_1.getAttribute("textContent").equalsIgnoreCase("Billing")){
						 if(cnf.FnExplicitWait("XPATH", mbo.PageVerificationTwo,driver)){
							 WebElement payBill_PageVerification_2=driver.findElement(By.xpath(mbo.PageVerificationTwo));
							 if(payBill_PageVerification_2.getAttribute("textContent").equalsIgnoreCase("Bill Pay Options")){
								 repfn.FnUpdateTestStepResHTML("Verify User is navigated to Bill Pay Options Page","User is navigated to Bill Pay Options page","PASS",runManagerInfoObj);
								 blnFlag=true;
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify User is navigated to Bill Pay Options Page","User is not navigated to Bill Pay Options page","FAIL",runManagerInfoObj);
								 blnFlag=false;
							 }
						 }
					 }
				 }
				 
				driver.navigate().refresh();
				blnFlag=FN_FooterLinkClick(driver, runManagerInfoObj);

			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify \'Bill Delivery Options\' link is clicked", "\'Bill Delivery Options\' link is not clicked","FAIL",runManagerInfoObj);
				blnFlag=false;	
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Bill Delivery Options\' link is displayed under Manage Account Header", "\'Bill Delivery Options\' link is not displayed under Manage Account Header","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		
		Thread.sleep(5000);

		//Footer_BussinessProfile
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_BussinessProfile,driver)){
			repfn.FnUpdateTestStepResHTML("Verify \'Edit Business Profile\' link is displayed under Manage Account Header", "\'Edit Business Profile\' link is displayed under Manage Account Header","PASS",runManagerInfoObj);
			WebElement Footer_BussinessProfile=driver.findElement(By.xpath(mbo.Footer_BussinessProfile));

			if(cnf.JSClick(Footer_BussinessProfile,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify \'Edit Business Profile\' link is clicked", "\'Edit Business Profile\' link is clicked","PASS",runManagerInfoObj);
				Thread.sleep(5000);
				
				 if(cnf.FnExplicitWait("XPATH", mbo.PageVerificationOne,driver)){
					 WebElement payBill_PageVerification_1=driver.findElement(By.xpath(mbo.PageVerificationOne));
					 if(payBill_PageVerification_1.getAttribute("textContent").equalsIgnoreCase("Company")){
						 if(cnf.FnExplicitWait("XPATH", mbo.PageVerificationTwo,driver)){
							 WebElement payBill_PageVerification_2=driver.findElement(By.xpath(mbo.PageVerificationTwo));
							 if(payBill_PageVerification_2.getAttribute("textContent").equalsIgnoreCase("Profile")){
								 repfn.FnUpdateTestStepResHTML("Verify User is navigated to Company Profile Page","User is navigated to Company Profile page","PASS",runManagerInfoObj);
								 blnFlag=true;
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify User is navigated to Company Profile Page","User is not navigated to Company Profile page","FAIL",runManagerInfoObj);
								 blnFlag=false;
							 }
						 }
					 }
				 }
				 
				driver.navigate().refresh();
				blnFlag=FN_FooterLinkClick(driver, runManagerInfoObj);

			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify \'Edit Business Profile\' link is clicked", "\'Edit Business Profile\' link is not clicked","FAIL",runManagerInfoObj);
				blnFlag=false;

			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Edit Business Profile\' link is displayed under Manage Account Header", "\'Edit Business Profile\' link is not displayed under Manage Account Header","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}


	catch(Exception e)
	{
		blnFlag	=false;
		repfn.FnUpdateTestStepResHTML("Verify User is able to verify Footer links navigation ", "User is able to verify Footer links navigation due to some execption","FAIL",runManagerInfoObj);
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;

}
public synchronized boolean FN_FooterLinkSupportSectionClick(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
	try{
		// Support Label
		if(cnf.FnExplicitWait("XPATH",mbo.FooterSupportLabel,driver)){
			repfn.FnUpdateTestStepResHTML("Verify \'Support\' Header is displayed in Expanded Footer", "\'Support\' Header is displayed in Expanded Footer","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Support\' Header is displayed in Expanded Footer", "\'Support\' Header is not displayed in Expanded Footer","FAIL",runManagerInfoObj);
			blnFlag=false;
		}


		// Techincal Support Link
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_TechicalSupport,driver)){
			repfn.FnUpdateTestStepResHTML("Verify \'Technical Support\' Link is displayed under Support Header", "\'Technical Support\' Link is displayed under Support Header","PASS",runManagerInfoObj);
			
			WebElement Footer_TechicalSupport=driver.findElement(By.xpath(mbo.Footer_TechicalSupport));
			if(cnf.JSClick(Footer_TechicalSupport,driver)){
				repfn.FnUpdateTestStepResHTML("Verify \'Technical Support\' Link is clicked", "\'Technical Support\' Link is clicked","PASS",runManagerInfoObj);
				Thread.sleep(5000);
				if(driver.getCurrentUrl().contains("support")){
					repfn.FnUpdateTestStepResHTML("Verify User is navigated to Support page", "User is navigated to Support page","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User is navigated to Support page", "User is not navigated to Support page","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				blnFlag=FN_FooterLinkClick(driver, runManagerInfoObj);
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify \'Technical Support\' Link is clicked", "\'Technical Support\' Link is not clicked","FAIL",runManagerInfoObj);
				blnFlag=false;
			}			
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Technical Support\' Link is displayed under Support Header", "\'Technical Support\' Link is not displayed under Support Header","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		
		String parentHandle = driver.getWindowHandle(); 
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_FiberCoaxLabel,driver)){
			repfn.FnUpdateTestStepResHTML("Verify \'Fiber and Coax Availability Map\' Link is displayed under Support Header", "\'Fiber and Coax Availability Map\' Link is displayed under Support Header","PASS",runManagerInfoObj);
			WebElement Footer_FiberCoaxLabel=driver.findElement(By.xpath(mbo.Footer_FiberCoaxLabel));
			Thread.sleep(5000);
			if(cnf.ElementClick1(Footer_FiberCoaxLabel))
			{					
				repfn.FnUpdateTestStepResHTML("Verify \'Fiber and Coax Availability Map\' Link is clicked", "\'Fiber and Coax Availability Map\' Link is clicked","PASS",runManagerInfoObj);
				for (String winHandle : driver.getWindowHandles()) 
				{
					driver.switchTo().window(winHandle);
					driver.manage().window().maximize();// switch focus of WebDriver to the next found window handle (that's your newly opened window)
				}
				
				Thread.sleep(5000);
				
				if(cnf.FnExplicitWait("XPATH", mbo.NewTab_LogoCheck,driver)){
					if(driver.getCurrentUrl().contains("fibermap")){
						repfn.FnUpdateTestStepResHTML("Verify User is redirected to Fiber and Coax Availability Map page", "User is redirected to Fiber and Coax Availability Map page","PASS",runManagerInfoObj);
						Thread.sleep(5000);
						driver.close();
						Thread.sleep(5000);
						driver.switchTo().window(parentHandle);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify User is redirected to Fiber and Coax Availability Map page", "User is not redirected to Fiber and Coax Availability Map page","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Spectrum Business logo is displayed", "Spectrum Business logo is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify \'Fiber and Coax Availability Map\' Link is clicked", "\'Fiber and Coax Availability Map\' Link is not clicked","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Fiber and Coax Availability Map\' Link is displayed under Support Header", "\'Fiber and Coax Availability Map\' Link is not displayed under Support Header","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		
		String parentHandleOne = driver.getWindowHandle(); 
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_CharterStore,driver)){
			repfn.FnUpdateTestStepResHTML("Verify \'Find a Charter Store\' Link is displayed under Support Header", "\'Find a Charter Store\' Link is displayed under Support Header","PASS",runManagerInfoObj);
			WebElement Footer_CharterStore=driver.findElement(By.xpath(mbo.Footer_CharterStore));
			if(cnf.ElementClick1(Footer_CharterStore))
			{					
				repfn.FnUpdateTestStepResHTML("Verify \'Find a Charter Store\' Link is clicked", "\'Find a Charter Store\' Link is clicked","PASS",runManagerInfoObj);
				for (String winHandle : driver.getWindowHandles()) 
				{
					driver.switchTo().window(winHandle);
					driver.manage().window().maximize();// switch focus of WebDriver to the next found window handle (that's your newly opened window)
				}
				
				Thread.sleep(5000);
				if(cnf.FnExplicitWait("XPATH", mbo.NewTab_LogoCheck,driver)){
					if(driver.getCurrentUrl().contains("store")){
						repfn.FnUpdateTestStepResHTML("Verify User is redirected to Charter Store page", "User is redirected to Charter Store page","PASS",runManagerInfoObj);
						Thread.sleep(5000);
						driver.close();
						Thread.sleep(5000);
						driver.switchTo().window(parentHandleOne);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify User is redirected to Charter Store page", "User is not redirected to Charter Store page","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Spectrum Business logo is displayed", "Spectrum Business logo is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify \'Find a Charter Store\' Link is clicked", "\'Find a Charter Store\' Link is not clicked","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Find a Charter Store\' Link is displayed under Support Header", "\'Find a Charter Store\' Link is not displayed under Support Header","FAIL",runManagerInfoObj);
			blnFlag=false;
		}

	}


	catch(Exception e)
	{
		blnFlag	=false;
		repfn.FnUpdateTestStepResHTML("Verify User is able to verify Footer links navigation ", "User is able to verify Footer links navigation due to some execption","FAIL",runManagerInfoObj);
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;

}
public synchronized boolean FN_FooterLinkManageAccountSection(WebDriver driver, RunManagerInfo runManagerInfoObj){
	try{
		//Footer_ManageAccount
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_ManageAccount,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify \'Manage Account\' Header is displayed in the Expanded Footer", "\'Manage Account\' Header is displayed in the Expanded Footer","PASS",runManagerInfoObj);
			blnFlag=true;
		}

		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Manage Account\' Header is displayed in the Expanded Footer", "\'Manage Account\' Header is not displayed in the Expanded Footer","FAIL",runManagerInfoObj);
			blnFlag=false;
		}

		// Footer_Overview

		if(cnf.FnExplicitWait("XPATH",mbo.Footer_Overview,driver))
		{

			repfn.FnUpdateTestStepResHTML("Verify \'Overview\' Link is displayed under Manage Account Header", "\'Overview\' Link is displayed under Manage Account Header","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Overview\' Link is displayed under Manage Account Header", "\'Overview\' Link is not displayed under Manage Account Header","FAIL",runManagerInfoObj);
			blnFlag=false;
		}

		//Footer_BillingTrans
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_BillingTrans,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify \'Billing and Transactions\' link is displayed under Manage Account Header ", "\'Billing and Transactions\' link is displayed under Manage Account Header","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Billing and Transactions\' link is displayed under Manage Account Header ", "\'Billing and Transactions\' link is not displayed under Manage Account Header","FAIL",runManagerInfoObj);
			blnFlag=false;
		}

		//Footer_CurrentBill
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_CurrentBill,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify \'View Current Bill\' link is displayed under Manage Account Header ", "\'View Current Bill\' link is displayed under Manage Account Header","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'View Current Bill\' link is displayed under Manage Account Header ", "\'View Current Bill\' link is not displayed under Manage Account Header","FAIL",runManagerInfoObj);
			blnFlag=false;
		}

		//Footer_BillDelivery
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_BillDelivery,driver))
		{

			repfn.FnUpdateTestStepResHTML("Verify \'Bill Delivery Options\' link is displayed under Manage Account Header ", "\'Bill Delivery Options\' link is displayed under Manage Account Header","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Bill Delivery Options\' link is displayed under Manage Account Header ", "\'Bill Delivery Options\' link is not displayed under Manage Account Header","FAIL",runManagerInfoObj);
			blnFlag=false;
		}



		//Footer_BussinessProfile
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_BussinessProfile,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify \'Edit Business Profile\' link is displayed under Manage Account Header ", "\'Edit Business Profile\' link is displayed under Manage Account Header","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Edit Business Profile\' link is displayed under Manage Account Header ", "\'Edit Business Profile\' link is not displayed under Manage Account Header","FAIL",runManagerInfoObj);
			blnFlag=false;
		}

	}


	catch(Exception e)
	{
		repfn.FnUpdateTestStepResHTML("Verify User is able to verify Footer Links under Manage Account header in the Expanded Footer ", "User is not able to verify Footer Links under Manage Account header in the Expanded Footer due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;

}




/**
 * Method Name : FN_FooterLinkCharterCorporateSection()
 * Method Description : This method is used to  verify CharterCorporateSection section in footer Link
 * @param none
 * @return Boolean
 * @author Saranya
 * @throws Exception
 * Date:10/14/2015
 */

public synchronized boolean FN_FooterLinkCharterCorporateSection(WebDriver driver, RunManagerInfo runManagerInfoObj){
	try{
		//Footer_CharterCorporate
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_CharterCorporate,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify \'Charter Corporate\' Header is displayed in the Expanded Footer ", "\'Charter Corporate\' Header is displayed in the Expanded Footer ","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Charter Corporate\' Header is displayed in the Expanded Footer ", "\'Charter Corporate\' Header is not displayed in the Expanded Footer ","FAIL",runManagerInfoObj);
			blnFlag=false;
		}



		// Footer_AboutUs

		if(cnf.FnExplicitWait("XPATH",mbo.Footer_AboutUs,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify \'About Us\' link is displayed under Charter Corporate Header ", "\'About Us\' link is displayed under Charter Corporate Header","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'About Us\' link is displayed under Charter Corporate Header ", "\'About Us\' link is not displayed under Charter Corporate Header ","FAIL",runManagerInfoObj);
			blnFlag=false;
		}



		//Footer_Guarantee
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_Guarantee,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify \'Guarantee\' link is displayed under Charter Corporate Header ", "\'Guarantee\' link is displayed under Charter Corporate Header","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Guarantee\' link is displayed under Charter Corporate Header ", "\'Guarantee\' link is not displayed under Charter Corporate Header ","FAIL",runManagerInfoObj);
			blnFlag=false;
		}

		//Footer_CharterLogo
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_CharterLogo,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify \'Charter Communications\' Logo is displayed in the Expanded Footer ", "\'Charter Communications\' Logo is displayed in the Expanded Footer ","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Charter Communications\' Logo is displayed in the Expanded Footer ", "\'Charter Communications\' Logo is not displayed in the Expanded Footer ","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}


	catch(Exception e)
	{
		repfn.FnUpdateTestStepResHTML("Verify User is able to verify Footer Links under Charter Corporate header in the Expanded Footer ", "User is not able to verify Footer Links under Charter Corporate header in the Expanded Footer due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;

}





/**
 * Method Name : FN_FooterSection()
 * Method Description : This method is used to  verify PrivatePolicies,Copy rights,terms,facebook,twitter and Linkedin sections in footer Link
 * @param none
 * @return Boolean
 * @author Saranya
 * @throws Exception
 * Date:10/14/2015
 */

public synchronized boolean FN_FooterSection(WebDriver driver, RunManagerInfo runManagerInfoObj){
	try{

		//Footer_PrivatePolicies
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_PrivatePolicies,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify \'Privacy Policies\' Link is displayed in the Expanded Footer ", "\'Privacy Policies\' Link is displayed in the Expanded Footer ","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Privacy Policies\' Link is displayed in the Expanded Footer ", "\'Privacy Policies\' Link is not displayed in the Expanded Footer ","FAIL",runManagerInfoObj);
			blnFlag=false;
		}



		//Footer_TermsService
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_TermsService,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify \'Terms Of Service\' Link is displayed in the Expanded Footer ", "\'Terms Of Service\' Link is displayed in the Expanded Footer ","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Terms Of Service\' Link is displayed in the Expanded Footer ", "\'Terms Of Service\' Link is not displayed in the Expanded Footer ","FAIL",runManagerInfoObj);
			blnFlag=false;
		}


		//Footer_CharterComm
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_CharterComm,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify \'Charter Copyright\' Logo is displayed in the Expanded Footer ", "\'Charter Copyright\' Logo is displayed in the Expanded Footer ","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Charter Copyright\' Logo is displayed in the Expanded Footer ", "\'Charter Copyright\' Logo is not displayed in the Expanded Footer ","FAIL",runManagerInfoObj);
			blnFlag=false;
		}


		//Footer_Linkedin
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_Linkedin,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify \'LinkedIn\' link is displayed in the Expanded Footer", "\'LinkedIn\' link is displayed in the Expanded Footer","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'LinkedIn\' link is displayed in the Expanded Footer", "\'LinkedIn\' link is not displayed in the Expanded Footer","FAIL",runManagerInfoObj);
			blnFlag=false;
		}


		//Footer_TermsService
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_facebook,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify \'Facebook\' link is displayed in the Expanded Footer", "\'Facebook\' link is displayed in the Expanded Footer","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Facebook\' link is displayed in the Expanded Footer", "\'Facebook\' link is not displayed in the Expanded Footer","FAIL",runManagerInfoObj);
			blnFlag=false;
		}




		//Footer_Twitter
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_Twitter,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify \'Twitter\' link is displayed in the Expanded Footer", "\'Twitter\' link is displayed in the Expanded Footer","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Twitter\' link is displayed in the Expanded Footer", "\'Twitter\' link is not displayed in the Expanded Footer","FAIL",runManagerInfoObj);
			blnFlag=false;
		}

	}


	catch(Exception e)
	{
		repfn.FnUpdateTestStepResHTML("Verify User is able to verify Footer Links in the Expanded Footer ", "User is not able to verify Footer Links in the Expanded Footer due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;

}
public synchronized boolean FN_FooterLinkSupportSection(WebDriver driver, RunManagerInfo runManagerInfoObj){
	try{
		//Footer Support Label
		if(cnf.FnExplicitWait("XPATH",mbo.FooterSupportLabel,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify \'Support\' Header is displayed in the Expanded Footer ", "\'Support\' Header is displayed in the Expanded Footer","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Support\' Header is displayed in the Expanded Footer", "\'Support\' Header is not displayed in the Expanded Footer","FAIL",runManagerInfoObj);
			blnFlag=false;
		}



		//Footer_TechicalSupport
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_TechicalSupport,driver)){			
			repfn.FnUpdateTestStepResHTML("Verify \'Technical Support\'Link is displayed under Support Header", "\'Technical Support\'Link is displayed under Support Header","PASS",runManagerInfoObj);
			blnFlag=true;
		}	
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Technical Support\'Link is displayed under Support Header", "\'Technical Support\'Link is not displayed under Support Header","FAIL",runManagerInfoObj);
			blnFlag=false;
		}

		// Footer_FiberCoaxLabel 

		if(cnf.FnExplicitWait("XPATH",mbo.Footer_FiberCoaxLabel,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify \'Fiber and Coax Availability Map\'Link is displayed under Support Header", "\'Fiber and Coax Availability Map\'Link is displayed under Support Header","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Fiber and Coax Availability Map\'Link is displayed under Support Header", "\'Fiber and Coax Availability Map\'Link is not displayed under Support Header","FAIL",runManagerInfoObj);
			blnFlag=false;
		}



		//Footer_CharterStore

		if(cnf.FnExplicitWait("XPATH",mbo.Footer_CharterStore,driver)){
			repfn.FnUpdateTestStepResHTML("Verify \'Find a Charter Store\'Link is displayed under Support Header", "\'Find a Charter Store\'Link is displayed under Support Header","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Find a Charter Store\'Link is displayed under Support Header", "\'Find a Charter Store\'Link is not displayed under Support Header","FAIL",runManagerInfoObj);
			blnFlag=false;
		}

		driver.navigate().refresh();
	}


	catch(Exception e)
	{
		repfn.FnUpdateTestStepResHTML("Verify User is able to verify Footer Links", "User is not able to verify Footer Links due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;

}

public synchronized boolean FooterLinks_AllPages(WebDriver driver, RunManagerInfo runManagerInfoObj)
{
	try
	{
		//To verify if footer links are displayed in Voice Page://
		app.FnVoiceClick(driver, runManagerInfoObj);
		FN_FooterLinkClick(driver, runManagerInfoObj);
		FN_FooterLinkManageAccountSection( driver,  runManagerInfoObj);
		FN_FooterLinkCharterCorporateSection( driver,  runManagerInfoObj);
		FN_FooterSection( driver,  runManagerInfoObj);
		FN_FooterLinkSupportSection( driver,  runManagerInfoObj);
		driver.navigate().refresh();
		app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);

		//To verify if footer links are displayed in Billing page://

		app.FnBilling(driver, runManagerInfoObj);
		FN_FooterLinkClick(driver, runManagerInfoObj);
		FN_FooterLinkManageAccountSection(driver, runManagerInfoObj);
		FN_FooterLinkCharterCorporateSection(driver, runManagerInfoObj);
		FN_FooterSection(driver, runManagerInfoObj);
		FN_FooterLinkSupportSection(driver, runManagerInfoObj);
		driver.navigate().refresh();
		app.FnNavigateBackOverviewPage(driver, runManagerInfoObj);

		//To verify if footer links are displayed in Manage users page://
		app.FnManageUserClick(driver, runManagerInfoObj);
		FN_FooterLinkClick(driver, runManagerInfoObj);
		FN_FooterLinkManageAccountSection(driver, runManagerInfoObj);
		FN_FooterLinkCharterCorporateSection(driver, runManagerInfoObj);
		FN_FooterSection(driver, runManagerInfoObj);
		FN_FooterLinkSupportSection(driver, runManagerInfoObj);
		driver.navigate().refresh();
		app.FnNavigateBackOverviewPage(driver, runManagerInfoObj);

		//To verify if footer links are displayed in My Profile page://

		app.FnMyProfile(driver, runManagerInfoObj);
		FN_FooterLinkClick(driver, runManagerInfoObj);
		FN_FooterLinkManageAccountSection(driver, runManagerInfoObj);
		FN_FooterLinkCharterCorporateSection(driver, runManagerInfoObj);
		FN_FooterSection(driver, runManagerInfoObj);
		FN_FooterLinkSupportSection(driver, runManagerInfoObj);
		driver.navigate().refresh();
		app.FnNavigateBackOverviewPage(driver, runManagerInfoObj);

		//To verify if footer links are displayed in Company Profile page://

		app.FnCompanyProfile(driver, runManagerInfoObj);
		FN_FooterLinkClick(driver, runManagerInfoObj);
		FN_FooterLinkManageAccountSection(driver, runManagerInfoObj);
		FN_FooterLinkCharterCorporateSection(driver, runManagerInfoObj);
		FN_FooterSection(driver, runManagerInfoObj);
		FN_FooterLinkSupportSection(driver, runManagerInfoObj);
		driver.navigate().refresh();
		app.FnNavigateBackOverviewPage(driver, runManagerInfoObj);

		//To verify if footer links are displayed in support page://

		FnSupport(driver, runManagerInfoObj);
		FN_FooterLinkClick(driver, runManagerInfoObj);
		FN_FooterLinkManageAccountSection(driver, runManagerInfoObj);
		FN_FooterLinkCharterCorporateSection(driver, runManagerInfoObj);
		FN_FooterSection(driver, runManagerInfoObj);
		FN_FooterLinkSupportSection(driver, runManagerInfoObj);
		driver.navigate().refresh();
		app.FnNavigateBackOverviewPage(driver, runManagerInfoObj);
	}
	catch (Exception e)

	{
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		blnFlag =  false;
		repfn.FnUpdateTestStepResHTML("Verify if the Footer links are common in all pages", "Footer links are not common in all pages due to some exception","FAIL",runManagerInfoObj);
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean FN_FooterLinkCharterCorporateSectionClick(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
	try{
		//Footer_CharterCorporate
		// Charter Corporate Label
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_CharterCorporate,driver)){
			repfn.FnUpdateTestStepResHTML("Verify \'Charter Corporate\' Header is displayed in Expanded Footer", "\'Charter Corporate\' Header is displayed in Expanded Footer","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Charter Corporate\' Header is displayed in Expanded Footer", "\'Charter Corporate\' Header is not displayed in Expanded Footer","FAIL",runManagerInfoObj);
			blnFlag=false;
		}

		Thread.sleep(5000);
		// Footer_AboutUs
		blnFlag=FN_aboutUs(driver, runManagerInfoObj);

		Thread.sleep(5000);
		//Footer_Guarantee
		blnFlag=FN_Guarantee(driver, runManagerInfoObj);
		
		//Footer_CharterLogo
		// Charter Communications Logo
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_CharterLogo,driver)){
			repfn.FnUpdateTestStepResHTML("Verify \'Charter Communications Logo\' is displayed in Expanded Footer", "\'Charter Communications Logo\' is displayed in Expanded Footer","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Charter Communications Logo\' is displayed in Expanded Footer", "\'Charter Communications Logo\' is not displayed in Expanded Footer","FAIL",runManagerInfoObj);
			blnFlag=false;
		}

	}

	catch(Exception e)
	{
		blnFlag	=false;
		repfn.FnUpdateTestStepResHTML("Verify User is able to verify Footer links navigation ", "User is able to verify Footer links navigation due to some execption","FAIL",runManagerInfoObj);
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;

}
public synchronized boolean FN_aboutUs(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
{
	try
	{
		String parentHandle = driver.getWindowHandle(); 
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_AboutUs,driver)){
			repfn.FnUpdateTestStepResHTML("Verify \'About Us\' Link is displayed under Charter Corporate Header", "\'About Us\' Link is displayed under Charter Corporate Header","PASS",runManagerInfoObj);
			WebElement Footer_AboutUs=driver.findElement(By.xpath(mbo.Footer_AboutUs));
			
			Thread.sleep(5000);
			
			if(cnf.ElementClick1(Footer_AboutUs))
			{	
				
				repfn.FnUpdateTestStepResHTML("Verify \'About Us\' Link is clicked", "\'About Us\' Link is clicked","PASS",runManagerInfoObj);
				
				Thread.sleep(5000);
				for (String winHandle : driver.getWindowHandles()) 
				{
					driver.switchTo().window(winHandle);
					driver.manage().window().maximize();// switch focus of WebDriver to the next found window handle (that's your newly opened window)
				}
				
				Thread.sleep(5000);
				
				if(cnf.FnExplicitWait("XPATH", mbo.Footer_AboutUsPage,driver)){
					repfn.FnUpdateTestStepResHTML("Verify User is redirected to About Us page", "User is redirected to About Us page","PASS",runManagerInfoObj);
					Thread.sleep(8000);
					
					driver.close();
					
					Thread.sleep(5000);
					driver.switchTo().window(parentHandle);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User is redirected to About Us page", "User is not redirected to About Us page","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify \'About Us\' Link is clicked", "\'About Us\' Link is not clicked","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'About Us\' Link is displayed under Charter Corporate Header", "\'About Us\' Link is not displayed under Charter Corporate Header","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		
	}
	catch (Exception e)
	{
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		repfn.FnUpdateTestStepResHTML("Verify User is redirected to About Us page", "User is not redirected to About Us page due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}

//To validate the navigation to a different window when Guarantee is clicked//
public synchronized boolean FnVerifyFooterLinks_StandardUser(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

	try{
		
		
		if(cnf.FnExplicitWait("XPATH",mbo.FooterDotLink,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Footer Dots Link is displayed in Footer Section", "Footer Dots Link is displayed in Footer Section","PASS",runManagerInfoObj);
			WebElement FooterDotLink=driver.findElement(By.xpath(mbo.FooterDotLink));
			cnf.ScrollToView(FooterDotLink,driver);
			if(cnf.JSClick(FooterDotLink,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Footer Dots Link is clicked", "Footer Dots Link is clicked","PASS",runManagerInfoObj);

				// Support Label
				if(cnf.FnExplicitWait("XPATH",mbo.FooterSupportLabel,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Support Label is displayed in Expanded Footer Section", "Support Label is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Support Label is displayed in Expanded Footer Section", "Support Label is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Techincal Support Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_TechicalSupport,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Technical Support\' Link is displayed under Support Label", "\'Technical Support\' Link is displayed under Support Label","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Technical Support\' Link is displayed under Support Label", "\'Technical Support\' Link is not displayed under Support Label","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Fiber and Coax Availability Map Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_FiberCoaxLabel,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Fiber and Coax Availability Map\' Link is displayed under Support Label", "\'Fiber and Coax Availability Map\' Link is displayed under Support Label","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Fiber and Coax Availability Map\' Link is displayed under Support Label", "\'Fiber and Coax Availability Map\' Link is not displayed under Support Label","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Find a Charter Store Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_CharterStore,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Find a Charter Store\' Link is displayed under Support Label", "\'Find a Charter Store\' Link is displayed under Support Label","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Find a Charter Store\' Link is displayed under Support Label", "\'Find a Charter Store\' Link is not displayed under Support Label","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Manage Account Label
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_ManageAccount,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Manage Account Label is displayed in Expanded Footer Section", "Manage Account Label is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Manage Account Label is displayed in Expanded Footer Section", "Manage Account Label is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Overview Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_Overview,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Overview\' Link is displayed under Manage Account Label", "\'Overview\' Link is displayed under Manage Account Label","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Overview\' Link is displayed under Manage Account Label", "\'Overview\' Link is not displayed under Manage Account Label","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Charter Corporate Label
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_CharterCorporate,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Charter Corporate Label is displayed in Expanded Footer Section", "Charter Corporate Label is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Charter Corporate Label is displayed in Expanded Footer Section", "Charter Corporate Label is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// About Us Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_AboutUs,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'About Us\' Link is displayed under Charter Corporate Label", "\'About Us\' Link is displayed under Charter Corporate Label","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'About Us\' Link is displayed under Charter Corporate Label", "\'About Us\' Link is not displayed under Charter Corporate Label","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Guarantee Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_Guarantee,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Guarantee\' Link is displayed under Charter Corporate Label", "\'Guarantee\' Link is displayed under Charter Corporate Label","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Guarantee\' Link is displayed under Charter Corporate Label", "\'Guarantee\' Link is not displayed under Charter Corporate Label","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Charter Communications Logo
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_CharterLogo,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Charter Communications Logo\' is displayed in Expanded Footer Section", "\'Charter Communications Logo\' is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Charter Communications Logo\' is displayed in Expanded Footer Section", "\'Charter Communications Logo\' is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Charter Copyright Logo
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_CharterComm,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Charter Copyright Logo\' is displayed in Expanded Footer Section", "\'Charter Copyright Logo\' is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Charter Copyright Logo\' is displayed in Expanded Footer Section", "\'Charter Copyright Logo\' is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Privacy Policies Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_PrivatePolicies,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Privacy Policies\' Link is displayed in Expanded Footer Section", "\'Privacy Policies\' Link is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Privacy Policies\' Link is displayed in Expanded Footer Section", "\'Privacy Policies\' Link is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Terms of Service Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_TermsService,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Terms of Service\' Link is displayed in Expanded Footer Section", "\'Terms of Service\' Link is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Terms of Service\' Link is displayed in Expanded Footer Section", "\'Terms of Service\' Link is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// LinkedIn Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_Linkedin,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'LinkedIn\' Link is displayed in Expanded Footer Section", "\'LinkedIn\' Link is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'LinkedIn\' Link is displayed in Expanded Footer Section", "\'LinkedIn\' Link is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Facebook Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_facebook,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Facebook\' Link is displayed in Expanded Footer Section", "\'Facebook\' Link is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Facebook\' Link is displayed in Expanded Footer Section", "\'Facebook\' Link is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Twitter Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_Twitter,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Twitter\' Link is displayed in Expanded Footer Section", "\'Twitter\' Link is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Twitter\' Link is displayed in Expanded Footer Section", "\'Twitter\' Link is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Footer Dot Link
				if(cnf.FnExplicitWait("XPATH",mbo.FooterDotLink,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Footer Dots Link is displayed in Expanded Footer Section", "Footer Dots Link is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Footer Dots Link is displayed in Expanded Footer Section", "Footer Dots Link is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Footer Dots Link is clicked", "Footer Dots Link is not clicked","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Footer Dots Link is displayed in Footer Section", "Footer Dots Link is not displayed in Footer Section","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}

	catch (Exception e)

	{		
		repfn.FnUpdateTestStepResHTML("Verify if User is able to verify Footer Links for Standard User", "User is not able to verify Footer Links for Standard User due to some exception", "FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}

	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean FnVerifyFooterLinks_UnAuthenticatedUser(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

	try{
		
		
		if(cnf.FnExplicitWait("XPATH",mbo.FooterDotLink,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Footer Dots Link is displayed in Footer Section", "Footer Dots Link is displayed in Footer Section","PASS",runManagerInfoObj);
			WebElement FooterDotLink=driver.findElement(By.xpath(mbo.FooterDotLink));
			cnf.ScrollToView(FooterDotLink,driver);
			if(cnf.JSClick(FooterDotLink,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Footer Dots Link is clicked", "Footer Dots Link is clicked","PASS",runManagerInfoObj);

				// Support Label
				if(cnf.FnExplicitWait("XPATH",mbo.FooterSupportLabel,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Support Label is displayed in Expanded Footer Section", "Support Label is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Support Label is displayed in Expanded Footer Section", "Support Label is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Techincal Support Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_TechicalSupport,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Technical Support\' Link is displayed under Support Label", "\'Technical Support\' Link is displayed under Support Label","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Technical Support\' Link is displayed under Support Label", "\'Technical Support\' Link is not displayed under Support Label","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Fiber and Coax Availability Map Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_FiberCoaxLabel,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Fiber and Coax Availability Map\' Link is displayed under Support Label", "\'Fiber and Coax Availability Map\' Link is displayed under Support Label","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Fiber and Coax Availability Map\' Link is displayed under Support Label", "\'Fiber and Coax Availability Map\' Link is not displayed under Support Label","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Find a Charter Store Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_CharterStore,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Find a Charter Store\' Link is displayed under Support Label", "\'Find a Charter Store\' Link is displayed under Support Label","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Find a Charter Store\' Link is displayed under Support Label", "\'Find a Charter Store\' Link is not displayed under Support Label","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Charter Corporate Label
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_CharterCorporate,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Charter Corporate Label is displayed in Expanded Footer Section", "Charter Corporate Label is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Charter Corporate Label is displayed in Expanded Footer Section", "Charter Corporate Label is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// About Us Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_AboutUs,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'About Us\' Link is displayed under Charter Corporate Label", "\'About Us\' Link is displayed under Charter Corporate Label","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'About Us\' Link is displayed under Charter Corporate Label", "\'About Us\' Link is not displayed under Charter Corporate Label","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Guarantee Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_Guarantee,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Guarantee\' Link is displayed under Charter Corporate Label", "\'Guarantee\' Link is displayed under Charter Corporate Label","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Guarantee\' Link is displayed under Charter Corporate Label", "\'Guarantee\' Link is not displayed under Charter Corporate Label","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Charter Communications Logo
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_CharterLogo,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Charter Communications Logo\' is displayed in Expanded Footer Section", "\'Charter Communications Logo\' is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Charter Communications Logo\' is displayed in Expanded Footer Section", "\'Charter Communications Logo\' is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Charter Copyright Logo
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_CharterComm,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Charter Copyright Logo\' is displayed in Expanded Footer Section", "\'Charter Copyright Logo\' is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Charter Copyright Logo\' is displayed in Expanded Footer Section", "\'Charter Copyright Logo\' is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Privacy Policies Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_PrivatePolicies,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Privacy Policies\' Link is displayed in Expanded Footer Section", "\'Privacy Policies\' Link is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Privacy Policies\' Link is displayed in Expanded Footer Section", "\'Privacy Policies\' Link is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Terms of Service Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_TermsService,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Terms of Service\' Link is displayed in Expanded Footer Section", "\'Terms of Service\' Link is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Terms of Service\' Link is displayed in Expanded Footer Section", "\'Terms of Service\' Link is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// LinkedIn Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_Linkedin,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'LinkedIn\' Link is displayed in Expanded Footer Section", "\'LinkedIn\' Link is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'LinkedIn\' Link is displayed in Expanded Footer Section", "\'LinkedIn\' Link is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Facebook Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_facebook,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Facebook\' Link is displayed in Expanded Footer Section", "\'Facebook\' Link is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Facebook\' Link is displayed in Expanded Footer Section", "\'Facebook\' Link is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Twitter Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_Twitter,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Twitter\' Link is displayed in Expanded Footer Section", "\'Twitter\' Link is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Twitter\' Link is displayed in Expanded Footer Section", "\'Twitter\' Link is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Footer Dot Link
				if(cnf.FnExplicitWait("XPATH",mbo.FooterDotLink,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Footer Dots Link is displayed in Expanded Footer Section", "Footer Dots Link is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Footer Dots Link is displayed in Expanded Footer Section", "Footer Dots Link is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Footer Dots Link is clicked", "Footer Dots Link is not clicked","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Footer Dots Link is displayed in Footer Section", "Footer Dots Link is not displayed in Footer Section","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}

	catch (Exception e)

	{		
		repfn.FnUpdateTestStepResHTML("Verify if User is able to verify Footer Links for UnAuthenticated User", "User is not able to verify Footer Links for UnAuthenticated User due to some exception", "FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}

	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}

public synchronized boolean FnVerifyFooterLinks_AdminUser(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

	try{
		
		
		if(cnf.FnExplicitWait("XPATH",mbo.FooterDotLink,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Footer Dots Link is displayed in Footer Section", "Footer Dots Link is displayed in Footer Section","PASS",runManagerInfoObj);
			WebElement FooterDotLink=driver.findElement(By.xpath(mbo.FooterDotLink));
			cnf.ScrollToView(FooterDotLink,driver);
			if(cnf.JSClick(FooterDotLink,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Footer Dots Link is clicked", "Footer Dots Link is clicked","PASS",runManagerInfoObj);

				// Support Label
				if(cnf.FnExplicitWait("XPATH",mbo.FooterSupportLabel,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Support Label is displayed in Expanded Footer Section", "Support Label is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Support Label is displayed in Expanded Footer Section", "Support Label is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Techincal Support Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_TechicalSupport,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Technical Support\' Link is displayed under Support Label", "\'Technical Support\' Link is displayed under Support Label","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Technical Support\' Link is displayed under Support Label", "\'Technical Support\' Link is not displayed under Support Label","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Fiber and Coax Availability Map Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_FiberCoaxLabel,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Fiber and Coax Availability Map\' Link is displayed under Support Label", "\'Fiber and Coax Availability Map\' Link is displayed under Support Label","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Fiber and Coax Availability Map\' Link is displayed under Support Label", "\'Fiber and Coax Availability Map\' Link is not displayed under Support Label","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Find a Charter Store Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_CharterStore,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Find a Charter Store\' Link is displayed under Support Label", "\'Find a Charter Store\' Link is displayed under Support Label","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Find a Charter Store\' Link is displayed under Support Label", "\'Find a Charter Store\' Link is not displayed under Support Label","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Manage Account Label
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_ManageAccount,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Manage Account Label is displayed in Expanded Footer Section", "Manage Account Label is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Manage Account Label is displayed in Expanded Footer Section", "Manage Account Label is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Overview Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_Overview,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Overview\' Link is displayed under Manage Account Label", "\'Overview\' Link is displayed under Manage Account Label","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Overview\' Link is displayed under Manage Account Label", "\'Overview\' Link is not displayed under Manage Account Label","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				// Billing And Transactions Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_BillingTrans,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Billing And Transactions\' Link is displayed under Manage Account Label", "\'Billing And Transactions\' Link is displayed under Manage Account Label","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Billing And Transactions\' Link is displayed under Manage Account Label", "\'Billing And Transactions\' Link is not displayed under Manage Account Label","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				// View Current Bill Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_CurrentBill,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'View Current Bill\' Link is displayed under Manage Account Label", "\'View Current Bill\' Link is displayed under Manage Account Label","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'View Current Bill\' Link is displayed under Manage Account Label", "\'View Current Bill\' Link is not displayed under Manage Account Label","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				// Bill Delivery Options Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_BillDelivery,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Bill Delivery Options\' Link is displayed under Manage Account Label", "\'Bill Delivery Options\' Link is displayed under Manage Account Label","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Bill Delivery Options\' Link is displayed under Manage Account Label", "\'Bill Delivery Options\' Link is not displayed under Manage Account Label","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				// Edit Business Profile Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_BussinessProfile,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Edit Business Profile\' Link is displayed under Manage Account Label", "\'Edit Business Profile\' Link is displayed under Manage Account Label","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Edit Business Profile\' Link is displayed under Manage Account Label", "\'Edit Business Profile\' Link is not displayed under Manage Account Label","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Charter Corporate Label
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_CharterCorporate,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Charter Corporate Label is displayed in Expanded Footer Section", "Charter Corporate Label is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Charter Corporate Label is displayed in Expanded Footer Section", "Charter Corporate Label is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// About Us Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_AboutUs,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'About Us\' Link is displayed under Charter Corporate Label", "\'About Us\' Link is displayed under Charter Corporate Label","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'About Us\' Link is displayed under Charter Corporate Label", "\'About Us\' Link is not displayed under Charter Corporate Label","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Guarantee Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_Guarantee,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Guarantee\' Link is displayed under Charter Corporate Label", "\'Guarantee\' Link is displayed under Charter Corporate Label","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Guarantee\' Link is displayed under Charter Corporate Label", "\'Guarantee\' Link is not displayed under Charter Corporate Label","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Charter Communications Logo
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_CharterLogo,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Charter Communications Logo\' is displayed in Expanded Footer Section", "\'Charter Communications Logo\' is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Charter Communications Logo\' is displayed in Expanded Footer Section", "\'Charter Communications Logo\' is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Charter Copyright Logo
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_CharterComm,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Charter Copyright Logo\' is displayed in Expanded Footer Section", "\'Charter Copyright Logo\' is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Charter Copyright Logo\' is displayed in Expanded Footer Section", "\'Charter Copyright Logo\' is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Privacy Policies Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_PrivatePolicies,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Privacy Policies\' Link is displayed in Expanded Footer Section", "\'Privacy Policies\' Link is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Privacy Policies\' Link is displayed in Expanded Footer Section", "\'Privacy Policies\' Link is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Terms of Service Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_TermsService,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Terms of Service\' Link is displayed in Expanded Footer Section", "\'Terms of Service\' Link is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Terms of Service\' Link is displayed in Expanded Footer Section", "\'Terms of Service\' Link is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// LinkedIn Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_Linkedin,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'LinkedIn\' Link is displayed in Expanded Footer Section", "\'LinkedIn\' Link is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'LinkedIn\' Link is displayed in Expanded Footer Section", "\'LinkedIn\' Link is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Facebook Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_facebook,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Facebook\' Link is displayed in Expanded Footer Section", "\'Facebook\' Link is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Facebook\' Link is displayed in Expanded Footer Section", "\'Facebook\' Link is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Twitter Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_Twitter,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Twitter\' Link is displayed in Expanded Footer Section", "\'Twitter\' Link is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Twitter\' Link is displayed in Expanded Footer Section", "\'Twitter\' Link is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Footer Dot Link
				if(cnf.FnExplicitWait("XPATH",mbo.FooterDotLink,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Footer Dots Link is displayed in Expanded Footer Section", "Footer Dots Link is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Footer Dots Link is displayed in Expanded Footer Section", "Footer Dots Link is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Footer Dots Link is clicked", "Footer Dots Link is not clicked","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Footer Dots Link is displayed in Footer Section", "Footer Dots Link is not displayed in Footer Section","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}

	catch (Exception e)

	{		
		repfn.FnUpdateTestStepResHTML("Verify if User is able to verify Footer Links for Admin User", "User is not able to verify Footer Links for Admin User due to some exception", "FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}

	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean FN_PrivatePolicies(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
{
	try
	{
			String parentHandle = driver.getWindowHandle(); 
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_PrivatePolicies,driver)){
			repfn.FnUpdateTestStepResHTML("Verify \'Privacy Policies\' Link is displayed in Expanded Footer", "\'Privacy Policies\' Link is displayed in Expanded Footer","PASS",runManagerInfoObj);
			WebElement Footer_PrivatePolicies=driver.findElement(By.xpath(mbo.Footer_PrivatePolicies));
			Thread.sleep(5000);
			if(cnf.ElementClick1(Footer_PrivatePolicies))
			{
				repfn.FnUpdateTestStepResHTML("Verify \'Privacy Policies\' Link is clicked", "\'Privacy Policies\' Link is clicked","PASS",runManagerInfoObj);

				Thread.sleep(5000);

				for (String winHandle : driver.getWindowHandles()) 
				{
					driver.switchTo().window(winHandle);
					driver.manage().window().maximize();// switch focus of WebDriver to the next found window handle (that's your newly opened window)
				}

				if(cnf.FnExplicitWait("XPATH", mbo.NewTab_LogoCheck,driver)){
					System.out.println(driver.getCurrentUrl());
					if(driver.getCurrentUrl().contains("privacy-policy")){
						repfn.FnUpdateTestStepResHTML("Verify User is redirected to Privacy Policies page", "User is redirected to Privacy Policies page","PASS",runManagerInfoObj);
						driver.close();
						driver.switchTo().window(parentHandle);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify User is redirected to Privacy Policies page", "User is not redirected to Privacy Policies page","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Spectrum Business logo is displayed", "Spectrum Business logo is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify \'Privacy Policies\' Link is clicked", "\'Privacy Policies\' Link is not clicked","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Privacy Policies\' Link is displayed in Expanded Footer", "\'Privacy Policies\' Link is not displayed in Expanded Footer","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}
	
	catch(Exception e)
	{
		blnFlag	=false;
		repfn.FnUpdateTestStepResHTML("Verify User is redirected to Privacy Policies page", "User is not redirected to Privacy Policies page due to some exception","FAIL",runManagerInfoObj);
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean FN_FooterSectionclick(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
	try{

		// Privacy Policies Link
		FN_PrivatePolicies( driver, runManagerInfoObj);


		// Terms of Service Link
		FN_TermsOfService(driver, runManagerInfoObj);


		// Charter Communications Logo
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_CharterLogo,driver)){
			repfn.FnUpdateTestStepResHTML("Verify \'Charter Communications Logo\' is displayed in Expanded Footer", "\'Charter Communications Logo\' is displayed in Expanded Footer","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Charter Communications Logo\' is displayed in Expanded Footer", "\'Charter Communications Logo\' is not displayed in Expanded Footer","FAIL",runManagerInfoObj);
			blnFlag=false;
		}


		//Footer_Linkedin
		blnFlag=FN_LinkedIn(driver, runManagerInfoObj);
		
		Thread.sleep(5000);

		//Footer_Facebook
		blnFlag=FN_Facebook(driver, runManagerInfoObj);
		
		Thread.sleep(5000);

		//Footer_Twitter
		blnFlag=FN_Twitter(driver, runManagerInfoObj);

	}

	catch(Exception e)
	{
		blnFlag	=false;
		repfn.FnUpdateTestStepResHTML("Verify User is able to verify Footer links navigation ", "User is able to verify Footer links navigation due to some execption","FAIL",runManagerInfoObj);
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean FN_TermsOfService(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
{
	try
	{
		String parentHandle = driver.getWindowHandle(); 
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_TermsService,driver)){
			repfn.FnUpdateTestStepResHTML("Verify \'Terms of Service\' Link is displayed in Expanded Footer", "\'Terms of Service\' Link is displayed in Expanded Footer","PASS",runManagerInfoObj);
			WebElement Footer_TermsService=driver.findElement(By.xpath(mbo.Footer_TermsService));
			Thread.sleep(5000);
			if(cnf.ElementClick1(Footer_TermsService))
			{
				repfn.FnUpdateTestStepResHTML("Verify \'Terms of Service\' Link is clicked", "\'Terms of Service\' Link is clicked","PASS",runManagerInfoObj);
				Thread.sleep(5000);

				for (String winHandle : driver.getWindowHandles()) 
				{
					driver.switchTo().window(winHandle);
					driver.manage().window().maximize();// switch focus of WebDriver to the next found window handle (that's your newly opened window)
				}
				
				Thread.sleep(5000);
				
				if(driver.getCurrentUrl().contains("services")){
					repfn.FnUpdateTestStepResHTML("Verify User is redirected to Terms of Service page", "User is redirected to Terms of Service page","PASS",runManagerInfoObj);
					driver.close();
					driver.switchTo().window(parentHandle);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User is redirected to Terms of Service page", "User is not redirected to Terms of Service page","FAIL",runManagerInfoObj);
					blnFlag=false;
				}


			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify \'Terms of Service\' Link is clicked", "\'Terms of Service\' Link is not clicked","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Terms of Service\' Link is displayed in Expanded Footer", "\'Terms of Service\' Link is not displayed in Expanded Footer","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}
	catch(Exception e)
	{
		blnFlag	=false;
		repfn.FnUpdateTestStepResHTML("Verify User is redirected to Terms of Service page", "User is not redirected to Terms of Service page due to some exception","FAIL",runManagerInfoObj);
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}


//To validate the navigation to a different window when LinkedIn is clicked//



//To validate the navigation to a different window when Charter Store  is clicked//

public synchronized boolean FN_Charterstore(WebDriver driver, RunManagerInfo runManagerInfoObj)
{
	try
	{
		String parentHandle = driver.getWindowHandle(); 
		cnf.FnExplicitWait("XPATH",mbo.Footer_CharterStore,driver);
		WebElement Footer_store=driver.findElement(By.xpath(mbo.Footer_CharterStore));
		if(Footer_store.isDisplayed()){

			repfn.FnUpdateTestStepResHTML("Footer_store is displayed  ", "Footer_store is displayed  ","PASS",runManagerInfoObj);
			if(cnf.ElementClick(Footer_store,driver))
			{
				for (String winHandle : driver.getWindowHandles()) 
				{
					driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
					Thread.sleep(3000);
				}
				/*cnf.FnExplicitWait("XPATH", mbo.Footer_TermsServicePage);
													WebElement Terms_Page=driver.findElement(By.xpath(mbo.Footer_TermsServicePage));*/
				System.out
				.println("Current url:"+driver.getCurrentUrl());
				if(driver.getCurrentUrl().contains("store"))
				{
					repfn.FnUpdateTestStepResHTML("charterstore page is displayed  ", "charterstore page is displayed  ","PASS",runManagerInfoObj);

					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("charterstore page is not displayed  ", "charterstore page is not displayed  ","FAIL",runManagerInfoObj);
					blnFlag=false;

				}
				//driver.close();
				driver.switchTo().window(parentHandle);
				System.out
				.println("Current url:"+driver.getCurrentUrl());
			}

		}
		else{
			repfn.FnUpdateTestStepResHTML("Footer_store is displayed  ", "Footer_store is not  displayed ","FAIL",runManagerInfoObj);
			blnFlag=false;
		}

	}
	catch (Exception e)
	{
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}	
public synchronized boolean fnHeaderAuthenticatedUserUI(WebDriver driver, RunManagerInfo runManagerInfoObj) {
	try
	{
		if(cnf.FnExplicitWait("XPATH", mbo.SpectrumLogoClick,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify if Spectrum Business logo is displayed in header", "Spectrum Business logo is displayed in header", "PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else
		{
			blnFlag=false;
			repfn.FnUpdateTestStepResHTML("Verify if Spectrum Business logo is displayed in header", "Spectrum Business logo is not displayed in header", "FAIL",runManagerInfoObj);
		}
		
		if(cnf.FnExplicitWait("XPATH", mbo.supportHeader,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify if Support icon with link is displayed in header", "Support icon with link is displayed in header", "PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else
		{
			blnFlag=false;
			repfn.FnUpdateTestStepResHTML("Verify if Support icon with link is displayed in header", "Support icon with link is not displayed in header", "FAIL",runManagerInfoObj);
		}
		
		if(cnf.FnExplicitWait("XPATH", mbo.helloUser,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify if \"Hello, User\"  is displayed in header", "\"Hello, User\"  is displayed in header: "+driver.findElement(By.xpath(mbo.helloUser)).getText(), "PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else
		{
			blnFlag=false;
			repfn.FnUpdateTestStepResHTML("Verify if \"Hello, User\"  is displayed in header", "\"Hello, User\"  is not displayed in header", "FAIL",runManagerInfoObj);
		}
		
		if(cnf.FnExplicitWait("XPATH", mbo.companyName,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify if \"Company Name\"  is displayed in header", "\"Company Name\"  is displayed in header: "+driver.findElement(By.xpath(mbo.companyName)).getText(), "PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else
		{
			blnFlag=false;
			repfn.FnUpdateTestStepResHTML("Verify if \"Company Name\"  is displayed in header", "\"Company Name\"  is not displayed in header", "FAIL",runManagerInfoObj);
		}
		
		if(cnf.FnExplicitWait("XPATH", mbo.LoginBtn,driver))
		{
			WebElement dropdown=driver.findElement(By.xpath(mbo.LoginBtn));
			repfn.FnUpdateTestStepResHTML("Verify if Login drop down is displayed in header", "Login drop down is displayed in header", "PASS",runManagerInfoObj);
			if(cnf.JSClick(dropdown,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify if User has clicked drop down displayed in header", "User has clicked drop down displayed in header", "PASS",runManagerInfoObj);
				
				if(cnf.FnExplicitWait("XPATH", mbo.accountDropDown,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if \"Account Number\" is displayed in dropdown", "\"Account Number\"  is displayed in dropdown: "+driver.findElement(By.xpath(mbo.accountDropDown)).getText(), "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					blnFlag=false;
					repfn.FnUpdateTestStepResHTML("Verify if \"Account Number\"  is displayed in dropdown", "\"Account Number\"  is not displayed in dropdown", "FAIL",runManagerInfoObj);
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.profileDropDown,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if \"My Profile\"  is displayed in dropdown", "\"My Profile\"  is displayed in dropdown", "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					blnFlag=false;
					repfn.FnUpdateTestStepResHTML("Verify if \"My Profile\"  is displayed in dropdown", "\"My Profile\"  is not displayed in dropdown", "FAIL",runManagerInfoObj);
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.companyDropDown,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if \"Company profile\"  is displayed in dropdown", "\"Company profile\"  is displayed in dropdown", "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					blnFlag=false;
					repfn.FnUpdateTestStepResHTML("Verify if \"Company profile\"  is displayed in dropdown", "\"Company profile\"  is not displayed in dropdown", "FAIL",runManagerInfoObj);
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.signoutDropDown,driver))
				{
					blnFlag=true;
					repfn.FnUpdateTestStepResHTML("Verify if \"Sign Out\"  is displayed in dropdown", "\"Sign Out\"  is displayed in dropdown", "PASS",runManagerInfoObj);
					driver.navigate().refresh();
				}
				else
				{
					blnFlag=false;
					repfn.FnUpdateTestStepResHTML("Verify if \"Sign Out\"  is displayed in dropdown", "\"Sign Out\"  is not displayed in dropdown", "FAIL",runManagerInfoObj);
				}
			}
			else
			{
				blnFlag=false;
				repfn.FnUpdateTestStepResHTML("Verify if User has clicked drop down displayed in header", "User has not clicked drop down displayed in header", "FAIL",runManagerInfoObj);
			}
		}
		else
		{
			blnFlag=false;
			repfn.FnUpdateTestStepResHTML("Verify if Login drop down is displayed in header", "Login drop down  is not displayed in header", "FAIL",runManagerInfoObj);
		}
		
		
	}
	catch(Exception e)
	{
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		repfn.FnUpdateTestStepResHTML("Verify User is able to verify header links UI", "User is not able to verify header links UI due to some exception", "FAIL",runManagerInfoObj);
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean Fn_HeaderUI(WebDriver driver, RunManagerInfo runManagerInfoObj)
{

	try
	{

		Thread.sleep(1000);
		if(driver.getCurrentUrl().contains("smb1/dashboard.html#/"))
		{

			Thread.sleep(1000);
			repfn.FnUpdateTestStepResHTML("Verify if user is in Overview page", "User is in Overview page", "PASS",runManagerInfoObj);
			if(cnf.FnExplicitWait("XPATH", mbo.V1_OvwLabel,driver))
			{
				WebElement ovw=driver.findElement(By.xpath(mbo.V1_OvwLabel));
				repfn.FnUpdateTestStepResHTML("Verify the overview header", "User is in the Overview page with the header"+" "+ovw.getText(), "PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else if(cnf.FnExplicitWait("XPATH", mbo.Home_OverviewLabel,driver))
			{
				WebElement ovw=driver.findElement(By.xpath(mbo.Home_OverviewLabel));
				repfn.FnUpdateTestStepResHTML("Verify the overview header", "User is in the Overview page with the header"+" "+ovw.getText(), "PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify the overview header", "User is in the Overview page without header", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify if user is in Overview page", "User is not in Overview page", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}


		//Hello text
		if(cnf.FnExplicitWait("XPATH", mbo.Header_HelloTxt,driver))
		{
			WebElement Hellotxt=driver.findElement(By.xpath(mbo.Header_HelloTxt));
			repfn.FnUpdateTestStepResHTML("Verify the presence of 'Hello, User' text", "'Hello,User' text is present in overview header"+" "+Hellotxt.getText(),"PASS",runManagerInfoObj);
			if(Hellotxt.getText().contains("Hello"))
			{
				repfn.FnUpdateTestStepResHTML("Verify the presence of 'Hello' in the header text", "'Hello' text is present in header text", "PASS",runManagerInfoObj);
				blnFlag=false;
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify the presence of 'Hello' in the header text", "'Hello' text is not present in header text", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
			
			String[] User=Hellotxt.getText().split(", ");
			System.out.println(User[1]); 
			String name = m1.get("AppUser").toString().toLowerCase();
			if(name.contains(User[1]))
			{
				repfn.FnUpdateTestStepResHTML("Verify the presence of logged in username in the header text", "Logged in username is present in header text", "PASS",runManagerInfoObj);
				blnFlag=false;
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify the presence of logged in username the header text", "Logged in username is not present in header text", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of 'Hello, User' text", "'Hello,User' text is not present in overview header","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		//Company Name
		if(cnf.FnExplicitWait("XPATH", mbo.Header_cmpyName,driver))
		{
			WebElement cmpyname=driver.findElement(By.xpath(mbo.Header_cmpyName));
			repfn.FnUpdateTestStepResHTML("Verify the presence of Company Name in the header", "Company name is present in overview header"+" "+cmpyname.getText(),"PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of Company Name in the header", "Company name is not present in overview header","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		if(cnf.FnExplicitWait("Xpath", mbo.LoginBtn,driver)){
			repfn.FnUpdateTestStepResHTML("Verify if the arrow to expand Logged in Profile details is displayed",
					"Arrow to expand Logged In Profile Details is displayed","PASS",runManagerInfoObj);
			WebElement LoginBtn=driver.findElement(By.xpath(mbo.LoginBtn));
			if(cnf.JSClick(LoginBtn,driver)){
				repfn.FnUpdateTestStepResHTML("Verify if the arrow to expand Logged in Profile details is clicked",
						"Arrow to expand Logged in Profile details is clicked","PASS",runManagerInfoObj);
				//Account number
				if(cnf.FnExplicitWait("XPATH", mbo.Header_AcctNum,driver))
				{
					WebElement Accnum=driver.findElement(By.xpath(mbo.Header_AcctNum));
					repfn.FnUpdateTestStepResHTML("Verify the presence of Account number", "Account Number is present"+" "+Accnum.getText(), "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Account number", "Account Number is not present", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				//Security code
				if(cnf.FnExplicitWait("XPATH", mbo.Header_SecCode,driver))
				{

					List<WebElement> secCode=driver.findElements(By.xpath(mbo.Header_SecCode));
					for(int i=0;i<secCode.size();i++)
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Security code", "Security code is present"+" "+secCode.get(i).getText(), "PASS",runManagerInfoObj);
					}
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Security code", "Security code is not present", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				//Company Profile
				if(cnf.FnExplicitWait("XPATH", mbo.Header_CmpyProfile,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of 'View Company Profile'", "'View Company Profile' is present", "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of 'View Company Profile'", "'View Company Profile' is not present", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				//View My Profile
				if(!cnf.FnExplicitWait("XPATH", mbo.Header_MyProfile,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify 'View My Profile' is removed from the V1 aunthenticated user header" , "'View My Profile' is removed from the V1 aunthenticated user header", "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify 'View My Profile' is removed from the V1 aunthenticated user header" , "'View My Profile' is not removed from the V1 aunthenticated user header", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				//Overview
				if(cnf.FnExplicitWait("Xpath", mbo.OverviewLink,driver)){
					repfn.FnUpdateTestStepResHTML("Verify OverView Link is displayed","OverView Link is displayed","PASS",runManagerInfoObj);
					WebElement OverviewLink=driver.findElement(By.xpath(mbo.OverviewLink));
					Thread.sleep(2000);
					if(cnf.JSClick(OverviewLink,driver)){
						repfn.FnUpdateTestStepResHTML("Verify OverView Link is clicked","OverView Link is clicked","PASS",runManagerInfoObj);						

						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						if(cnf.FnExplicitWait("Xpath", mbo.Home_OverviewLabel,driver)){
							repfn.FnUpdateTestStepResHTML("Verify User Return back to Overview Page","User Return back to Overview Page","PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else if(cnf.FnExplicitWait("Xpath", mbo.v1_overview,driver)) {
							repfn.FnUpdateTestStepResHTML("Verify User Return back to Overview Page","User Return back to Overview Page","PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User Return back to Overview Page","User is not Return back to Overview Page","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify OverView Link is clicked","OverView Link is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify OverView Link is displayed","OverView Link is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

			}
			else
			{

				repfn.FnUpdateTestStepResHTML("Verify if the arrow to expand Logged in Profile details is clicked",
						"Arrow to expand Logged in Profile details is not clicked","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify if the arrow to expand Logged in Profile details is displayed",
					"Arrow to expand Logged In Profile Details is not displayed","FAIL",runManagerInfoObj);		
		}

	}
	 catch (Exception e)

	 {		
		 blnFlag=false;
		 repfn.FnUpdateTestStepResHTML("Verify the user is in Overview page", "User is not in overview page due to some exception", "FAIL",runManagerInfoObj);
		 System.err.println("Message : "+e.getMessage());
		 System.err.println("Cause : "+e.getCause());
	 }
	 m1.put("STEPSTATUS", blnFlag);
	 return blnFlag;
}
public synchronized boolean HeaderSupport(WebDriver driver, RunManagerInfo runManagerInfoObj)
{
	 try
	 {
		 if(cnf.FnExplicitWait("XPATH", mbo.V1_Support,driver)){
			 WebElement Support_Myacc=driver.findElement(By.xpath(mbo.V1_Support));

			 repfn.FnUpdateTestStepResHTML("Verify if Support link is displayed in the header","Support link is displayed in the header","PASS",runManagerInfoObj);
			 if(cnf.JSClick(Support_Myacc,driver)){
				 repfn.FnUpdateTestStepResHTML("Verify if Support link is clicked","Support link is clicked","PASS",runManagerInfoObj);
				 Thread.sleep(3000);

				 if(cnf.FnExplicitWait("Xpath", "//h1[contains(.,'Search Support')]",driver)){
					 System.out.println("Support page");
					 repfn.FnUpdateTestStepResHTML("Verify if the Shared Support page is displayed","Shared Support page is displayed","PASS",runManagerInfoObj);
					 blnFlag=true;

				 }
				 else{
					 System.out.println("Support page");
					 repfn.FnUpdateTestStepResHTML("Verify if the Shared Support page is displayed","Shared Support page is not displayed","FAIL",runManagerInfoObj);
					 blnFlag=false;

				 }
			 }
			 else{ 
				repfn.FnUpdateTestStepResHTML("Verify if Support link is clicked","Support link is not clicked","FAIL",runManagerInfoObj);
			 	blnFlag=false;
			 }
		 }
		 else{
			 repfn.FnUpdateTestStepResHTML("Verify if Support link is displayed in the header","Support link is not displayed in the header","FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }


	 }
	 catch(Exception e)
	 {
		 blnFlag	=false;
		 repfn.FnUpdateTestStepResHTML("Login to Spectrum Business.net ", "Login is not performed due to exception","FAIL",runManagerInfoObj);

	 }
	 return blnFlag;
}



public synchronized boolean HeaderLinks(WebDriver driver, RunManagerInfo runManagerInfoObj)
{
	try
	{

		if(cnf.FnExplicitWait("XPATH",mbo.SpectrumLogo ,driver))
		{
			WebElement Spectrum_Logo=driver.findElement(By.xpath(mbo.SpectrumLogo));
			if(Spectrum_Logo.isDisplayed())
			{
				System.out.println("Spectrum Logo is displayed");
				repfn.FnUpdateTestStepResHTML("Verify if Spectrum Logo is displayed","spectrum Logo is displayed","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else
			{
				System.out.println("Spectrum Logo is not displayed");
				repfn.FnUpdateTestStepResHTML("Verify if Spectrum Logo is displayed","spectrum Logo is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		if(cnf.FnExplicitWait("XPATH",mbo.SupportBtn,driver))
		{
			WebElement Support_Button=driver.findElement(By.xpath(mbo.SupportBtn));
			if(Support_Button.isDisplayed())
			{
				System.out.println("Support Link is displayed");
				repfn.FnUpdateTestStepResHTML("Verify if support Link is displayed","Support Link is displayed","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else
			{
				System.out.println("Support Link is not displayed");
				repfn.FnUpdateTestStepResHTML("Verify if support Link is displayed","Support Link is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		if(cnf.FnExplicitWait("XPATH", mbo.SignInBtn,driver))
		{
			
			
				repfn.FnUpdateTestStepResHTML("Verify if Sign In Button is displayed","Sign In Button is displayed","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else
			{
				
				repfn.FnUpdateTestStepResHTML("Verify if Sign In Button is displayed","Sign In Button is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		
	}
	catch (Exception e)

	{
		repfn.FnUpdateTestStepResHTML("Verify if all the Header links are present", "All the Header links are not present", "FAIL",runManagerInfoObj);
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		//repfn.FnUpdateTestStepResHTML("Verify if the shelf services and equipment in the overwiew page is displayed", "verify did not happen ","FAIL",runManagerInfoObj);
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean Authenticated_UI(WebDriver driver, RunManagerInfo runManagerInfoObj) {
	try
	{
		if(cnf.FnExplicitWait("XPATH", mbo.SpectrumLogoClick,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify if Spectrum Business logo is displayed in header", "Spectrum Business logo is displayed in header", "PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else
		{
			blnFlag=false;
			repfn.FnUpdateTestStepResHTML("Verify if Spectrum Business logo is displayed in header", "Spectrum Business logo is not displayed in header", "FAIL",runManagerInfoObj);
		}
		
		if(cnf.FnExplicitWait("XPATH", mbo.SupportBtn,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify if Support icon with link is displayed in header", "Support icon with link is displayed in header", "PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else
		{
			blnFlag=false;
			repfn.FnUpdateTestStepResHTML("Verify if Support icon with link is displayed in header", "Support icon with link is not displayed in header", "FAIL",runManagerInfoObj);
		}
		
		if(cnf.FnExplicitWait("XPATH", mbo.helloUser,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify if \"Hello, User\"  is displayed in header", "\"Hello, User\"  is displayed in header: "+driver.findElement(By.xpath(mbo.helloUser)).getText(), "PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else
		{
			blnFlag=false;
			repfn.FnUpdateTestStepResHTML("Verify if \"Hello, User\"  is displayed in header", "\"Hello, User\"  is not displayed in header", "FAIL",runManagerInfoObj);
		}
		
		if(cnf.FnExplicitWait("XPATH", mbo.companyName,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify if \"Company Name\"  is displayed in header", "\"Company Name\"  is displayed in header: "+driver.findElement(By.xpath(mbo.companyName)).getText(), "PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else
		{
			blnFlag=false;
			repfn.FnUpdateTestStepResHTML("Verify if \"Company Name\"  is displayed in header", "\"Company Name\"  is not displayed in header", "FAIL",runManagerInfoObj);
		}
		
		if(cnf.FnExplicitWait("XPATH", mbo.LoginBtn,driver))
		{
			WebElement dropdown=driver.findElement(By.xpath(mbo.LoginBtn));
			repfn.FnUpdateTestStepResHTML("Verify if Login drop down is displayed in header", "Login drop down is displayed in header", "PASS",runManagerInfoObj);
			if(cnf.JSClick(dropdown,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify if User has clicked drop down displayed in header", "User has clicked drop down displayed in header", "PASS",runManagerInfoObj);
				
				if(cnf.FnExplicitWait("XPATH", mbo.accountDropDown,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if \"Account Number\" is displayed in dropdown", "\"Account Number\"  is displayed in dropdown: "+driver.findElement(By.xpath(mbo.accountDropDown)).getText(), "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					blnFlag=false;
					repfn.FnUpdateTestStepResHTML("Verify if \"Account Number\"  is displayed in dropdown", "\"Account Number\"  is not displayed in dropdown", "FAIL",runManagerInfoObj);
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.profileDropDown,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if \"My Profile\"  is displayed in dropdown", "\"My Profile\"  is displayed in dropdown", "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					blnFlag=false;
					repfn.FnUpdateTestStepResHTML("Verify if \"My Profile\"  is displayed in dropdown", "\"My Profile\"  is not displayed in dropdown", "FAIL",runManagerInfoObj);
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.companyDropDown,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if \"Company profile\"  is displayed in dropdown", "\"Company profile\"  is displayed in dropdown", "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					blnFlag=false;
					repfn.FnUpdateTestStepResHTML("Verify if \"Company profile\"  is displayed in dropdown", "\"Company profile\"  is not displayed in dropdown", "FAIL",runManagerInfoObj);
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.signoutDropDown,driver))
				{
					blnFlag=true;
					repfn.FnUpdateTestStepResHTML("Verify if \"Sign Out\"  is displayed in dropdown", "\"Sign Out\"  is displayed in dropdown", "PASS",runManagerInfoObj);
					driver.navigate().refresh();
				}
				else
				{
					blnFlag=false;
					repfn.FnUpdateTestStepResHTML("Verify if \"Sign Out\"  is displayed in dropdown", "\"Sign Out\"  is not displayed in dropdown", "FAIL",runManagerInfoObj);
				}
			}
			else
			{
				blnFlag=false;
				repfn.FnUpdateTestStepResHTML("Verify if User has clicked drop down displayed in header", "User has not clicked drop down displayed in header", "FAIL",runManagerInfoObj);
			}
		}
		else
		{
			blnFlag=false;
			repfn.FnUpdateTestStepResHTML("Verify if Login drop down is displayed in header", "Login drop down  is not displayed in header", "FAIL",runManagerInfoObj);
		}
		
		
	}
	catch(Exception e)
	{
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		repfn.FnUpdateTestStepResHTML("Verify User is able to verify header links UI", "User is not able to verify header links UI due to some exception", "FAIL",runManagerInfoObj);
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean FnVerifyFooterLinks_BillingUser(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

	try{
		
		
		if(cnf.FnExplicitWait("XPATH",mbo.FooterDotLink,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Footer Dots Link is displayed in Footer Section", "Footer Dots Link is displayed in Footer Section","PASS",runManagerInfoObj);
			WebElement FooterDotLink=driver.findElement(By.xpath(mbo.FooterDotLink));
			cnf.ScrollToView(FooterDotLink,driver);
			if(cnf.JSClick(FooterDotLink,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Footer Dots Link is clicked", "Footer Dots Link is clicked","PASS",runManagerInfoObj);

				// Support Label
				if(cnf.FnExplicitWait("XPATH",mbo.FooterSupportLabel,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Support Label is displayed in Expanded Footer Section", "Support Label is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Support Label is displayed in Expanded Footer Section", "Support Label is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Techincal Support Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_TechicalSupport,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Technical Support\' Link is displayed under Support Label", "\'Technical Support\' Link is displayed under Support Label","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Technical Support\' Link is displayed under Support Label", "\'Technical Support\' Link is not displayed under Support Label","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Fiber and Coax Availability Map Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_FiberCoaxLabel,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Fiber and Coax Availability Map\' Link is displayed under Support Label", "\'Fiber and Coax Availability Map\' Link is displayed under Support Label","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Fiber and Coax Availability Map\' Link is displayed under Support Label", "\'Fiber and Coax Availability Map\' Link is not displayed under Support Label","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Find a Charter Store Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_CharterStore,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Find a Charter Store\' Link is displayed under Support Label", "\'Find a Charter Store\' Link is displayed under Support Label","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Find a Charter Store\' Link is displayed under Support Label", "\'Find a Charter Store\' Link is not displayed under Support Label","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Manage Account Label
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_ManageAccount,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Manage Account Label is displayed in Expanded Footer Section", "Manage Account Label is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Manage Account Label is displayed in Expanded Footer Section", "Manage Account Label is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Overview Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_Overview,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Overview\' Link is displayed under Manage Account Label", "\'Overview\' Link is displayed under Manage Account Label","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Overview\' Link is displayed under Manage Account Label", "\'Overview\' Link is not displayed under Manage Account Label","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				// Billing And Transactions Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_BillingTrans,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Billing And Transactions\' Link is displayed under Manage Account Label", "\'Billing And Transactions\' Link is displayed under Manage Account Label","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Billing And Transactions\' Link is displayed under Manage Account Label", "\'Billing And Transactions\' Link is not displayed under Manage Account Label","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				// View Current Bill Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_CurrentBill,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'View Current Bill\' Link is displayed under Manage Account Label", "\'View Current Bill\' Link is displayed under Manage Account Label","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'View Current Bill\' Link is displayed under Manage Account Label", "\'View Current Bill\' Link is not displayed under Manage Account Label","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				// Bill Delivery Options Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_BillDelivery,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Bill Delivery Options\' Link is displayed under Manage Account Label", "\'Bill Delivery Options\' Link is displayed under Manage Account Label","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Bill Delivery Options\' Link is displayed under Manage Account Label", "\'Bill Delivery Options\' Link is not displayed under Manage Account Label","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Charter Corporate Label
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_CharterCorporate,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Charter Corporate Label is displayed in Expanded Footer Section", "Charter Corporate Label is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Charter Corporate Label is displayed in Expanded Footer Section", "Charter Corporate Label is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// About Us Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_AboutUs,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'About Us\' Link is displayed under Charter Corporate Label", "\'About Us\' Link is displayed under Charter Corporate Label","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'About Us\' Link is displayed under Charter Corporate Label", "\'About Us\' Link is not displayed under Charter Corporate Label","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Guarantee Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_Guarantee,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Guarantee\' Link is displayed under Charter Corporate Label", "\'Guarantee\' Link is displayed under Charter Corporate Label","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Guarantee\' Link is displayed under Charter Corporate Label", "\'Guarantee\' Link is not displayed under Charter Corporate Label","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Charter Communications Logo
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_CharterLogo,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Charter Communications Logo\' is displayed in Expanded Footer Section", "\'Charter Communications Logo\' is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Charter Communications Logo\' is displayed in Expanded Footer Section", "\'Charter Communications Logo\' is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Charter Copyright Logo
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_CharterComm,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Charter Copyright Logo\' is displayed in Expanded Footer Section", "\'Charter Copyright Logo\' is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Charter Copyright Logo\' is displayed in Expanded Footer Section", "\'Charter Copyright Logo\' is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Privacy Policies Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_PrivatePolicies,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Privacy Policies\' Link is displayed in Expanded Footer Section", "\'Privacy Policies\' Link is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Privacy Policies\' Link is displayed in Expanded Footer Section", "\'Privacy Policies\' Link is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Terms of Service Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_TermsService,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Terms of Service\' Link is displayed in Expanded Footer Section", "\'Terms of Service\' Link is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Terms of Service\' Link is displayed in Expanded Footer Section", "\'Terms of Service\' Link is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// LinkedIn Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_Linkedin,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'LinkedIn\' Link is displayed in Expanded Footer Section", "\'LinkedIn\' Link is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'LinkedIn\' Link is displayed in Expanded Footer Section", "\'LinkedIn\' Link is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Facebook Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_facebook,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Facebook\' Link is displayed in Expanded Footer Section", "\'Facebook\' Link is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Facebook\' Link is displayed in Expanded Footer Section", "\'Facebook\' Link is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Twitter Link
				if(cnf.FnExplicitWait("XPATH",mbo.Footer_Twitter,driver)){
					repfn.FnUpdateTestStepResHTML("Verify \'Twitter\' Link is displayed in Expanded Footer Section", "\'Twitter\' Link is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Twitter\' Link is displayed in Expanded Footer Section", "\'Twitter\' Link is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				// Footer Dot Link
				if(cnf.FnExplicitWait("XPATH",mbo.FooterDotLink,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Footer Dots Link is displayed in Expanded Footer Section", "Footer Dots Link is displayed in Expanded Footer Section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Footer Dots Link is displayed in Expanded Footer Section", "Footer Dots Link is not displayed in Expanded Footer Section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Footer Dots Link is clicked", "Footer Dots Link is not clicked","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Footer Dots Link is displayed in Footer Section", "Footer Dots Link is not displayed in Footer Section","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}

	catch (Exception e)

	{		
		repfn.FnUpdateTestStepResHTML("Verify if User is able to verify Footer Links for Billing User", "User is not able to verify Footer Links for Billing User due to some exception", "FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}

	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean FN_LinkedIn(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
{
	try
	{
		String parentHandle = driver.getWindowHandle(); 
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_Linkedin,driver)){
			repfn.FnUpdateTestStepResHTML("Verify \'LinkedIn\' Link is displayed in Expanded Footer", "\'LinkedIn\' Link is displayed in Expanded Footer","PASS",runManagerInfoObj);
			WebElement Footer_LinkedIn=driver.findElement(By.xpath(mbo.Footer_Linkedin));
			Thread.sleep(5000);
			if(cnf.ElementClick1(Footer_LinkedIn))
			{
				repfn.FnUpdateTestStepResHTML("Verify \'LinkedIn\' Link is clicked", "\'LinkedIn\' Link is clicked","PASS",runManagerInfoObj);
				Thread.sleep(5000);
				for (String winHandle : driver.getWindowHandles()) 
				{
					driver.switchTo().window(winHandle);
					driver.manage().window().maximize();// switch focus of WebDriver to the next found window handle (that's your newly opened window)
				}
				
				Thread.sleep(5000);
				if(driver.getCurrentUrl().contains("linkedin")){
					repfn.FnUpdateTestStepResHTML("Verify User is navigated to LinkedIn page", "User is navigated to LinkedIn page","PASS",runManagerInfoObj);
					driver.close();
					driver.switchTo().window(parentHandle);	
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User is navigated to LinkedIn page", "User is not navigated to LinkedIn page","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify \'LinkedIn\' Link is clicked", "\'LinkedIn\' Link is not clicked","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'LinkedIn\' Link is displayed in Expanded Footer", "\'LinkedIn\' Link is not displayed in Expanded Footer","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		
	}
	catch (Exception e)
	{
		repfn.FnUpdateTestStepResHTML("Verify User is navigated to LinkedIn page", "User is not navigated to LinkedIn page due to some exception","FAIL",runManagerInfoObj);
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		blnFlag=false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}

//To validate the navigation to a different window when Facebook is clicked//

public synchronized boolean FN_Facebook(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
{
	try
	{
		String parentHandle = driver.getWindowHandle(); 
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_facebook,driver)){
			repfn.FnUpdateTestStepResHTML("Verify \'Facebook\' Link is displayed in Expanded Footer", "\'Facebook\' Link is displayed in Expanded Footer","PASS",runManagerInfoObj);
			WebElement Footer_facebook=driver.findElement(By.xpath(mbo.Footer_facebook));
			Thread.sleep(5000);
			if(cnf.ElementClick1(Footer_facebook))
			{
				repfn.FnUpdateTestStepResHTML("Verify \'Facebook\' Link is clicked", "\'Facebook\' Link is clicked","PASS",runManagerInfoObj);
				Thread.sleep(5000); 
				for (String winHandle : driver.getWindowHandles()) 
				{
					driver.switchTo().window(winHandle);
					driver.manage().window().maximize();// switch focus of WebDriver to the next found window handle (that's your newly opened window)
				}
				
				Thread.sleep(5000);
				if(driver.getCurrentUrl().contains("facebook")){
					repfn.FnUpdateTestStepResHTML("Verify User is navigated to Facebook page", "User is navigated to Facebook page","PASS",runManagerInfoObj);
					driver.close();
					driver.switchTo().window(parentHandle);	
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User is navigated to Facebook page", "User is not navigated to Facebook page","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify \'Facebook\' Link is clicked", "\'Facebook\' Link is not clicked","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Facebook\' Link is displayed in Expanded Footer", "\'Facebook\' Link is not displayed in Expanded Footer","FAIL",runManagerInfoObj);
			blnFlag=false;
		}

	}
	catch (Exception e)
	{
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		blnFlag=false;
		repfn.FnUpdateTestStepResHTML("Verify User is navigated to Facebook page", "User is not navigated to Facebook page due to some exception","FAIL",runManagerInfoObj);
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}

//To validate the navigation to a different window when Twitter is clicked//

public synchronized boolean FN_Twitter(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
{
	try
	{
		String parentHandle = driver.getWindowHandle(); 
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_Twitter,driver)){
			repfn.FnUpdateTestStepResHTML("Verify \'Twitter\' Link is displayed in Expanded Footer", "\'Twitter\' Link is displayed in Expanded Footer","PASS",runManagerInfoObj);
			WebElement Footer_Twitter=driver.findElement(By.xpath(mbo.Footer_Twitter));
			Thread.sleep(5000);
			if(cnf.ElementClick1(Footer_Twitter))
			{
				repfn.FnUpdateTestStepResHTML("Verify \'Twitter\' Link is clicked", "\'Twitter\' Link is clicked","PASS",runManagerInfoObj);
				Thread.sleep(15000);
				
				for (String winHandle : driver.getWindowHandles()) 
				{
					driver.switchTo().window(winHandle);
					driver.manage().window().maximize();// switch focus of WebDriver to the next found window handle (that's your newly opened window)
				}
				
				Thread.sleep(10000);
				driver.navigate().refresh();
				Thread.sleep(1000);
				System.out.println("URL"+driver.getCurrentUrl());
				if(driver.getCurrentUrl().contains("twitter")){
					repfn.FnUpdateTestStepResHTML("Verify User is navigated to Twitter page", "User is navigated to Twitter page","PASS",runManagerInfoObj);
					driver.close();
					driver.switchTo().window(parentHandle);	
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User is navigated to Twitter page", "User is not navigated to Twitter page","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify \'Twitter\' Link is clicked", "\'Twitter\' Link is not clicked","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Twitter\' Link is displayed in Expanded Footer", "\'Twitter\' Link is not displayed in Expanded Footer","FAIL",runManagerInfoObj);
			blnFlag=false;
		}

	}
	catch (Exception e)
	{
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		blnFlag=false;
		repfn.FnUpdateTestStepResHTML("Verify User is navigated to Twitter page", "User is not navigated to Twitter page due to some exception","FAIL",runManagerInfoObj);
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
//To validate the navigation to a different window when Fibre coax  is clicked//

public synchronized boolean FN_Fibre(WebDriver driver, RunManagerInfo runManagerInfoObj)
{
	try
	{
		String parentHandle = driver.getWindowHandle(); 
		cnf.FnExplicitWait("XPATH",mbo.Footer_FiberCoaxLabel,driver);
		WebElement Footer_Fibre=driver.findElement(By.xpath(mbo.Footer_FiberCoaxLabel));
		if(Footer_Fibre.isDisplayed()){

			repfn.FnUpdateTestStepResHTML("Footer_Fibre is displayed  ", "Footer_Fibre is displayed  ","PASS",runManagerInfoObj);
			if(cnf.ElementClick(Footer_Fibre,driver))
			{
				for (String winHandle : driver.getWindowHandles()) 
				{
					driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
					Thread.sleep(3000);
				}
				/*cnf.FnExplicitWait("XPATH", mbo.Footer_TermsServicePage);
													WebElement Terms_Page=driver.findElement(By.xpath(mbo.Footer_TermsServicePage));*/
				System.out
				.println("Current url:"+driver.getCurrentUrl());
				if(driver.getCurrentUrl().contains("fibermap"))
				{
					repfn.FnUpdateTestStepResHTML("fibre page is displayed  ", "fibre page is displayed  ","PASS",runManagerInfoObj);

					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("fibre page is not displayed  ", "fibre page is not displayed  ","FAIL",runManagerInfoObj);
					blnFlag=false;

				}
				//driver.close();
				driver.switchTo().window(parentHandle);
			}

		}
		else{
			repfn.FnUpdateTestStepResHTML("Footer_Fibre is displayed  ", "Footer_Fibre is not  displayed ","FAIL",runManagerInfoObj);
			blnFlag=false;
		}

	}
	catch (Exception e)
	{
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}	
public synchronized boolean FN_Guarantee(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
{
	try
	{
		String parentHandle = driver.getWindowHandle(); 
		if(cnf.FnExplicitWait("XPATH",mbo.Footer_Guarantee,driver)){
			repfn.FnUpdateTestStepResHTML("Verify \'Guarantee\' Link is displayed under Charter Corporate Header", "\'Guarantee\' Link is displayed under Charter Corporate Header","PASS",runManagerInfoObj);
			WebElement Footer_Guarantee=driver.findElement(By.xpath(mbo.Footer_Guarantee));
			
			Thread.sleep(5000);
			if(cnf.ElementClick1(Footer_Guarantee))
			{
				
				repfn.FnUpdateTestStepResHTML("Verify \'Guarantee\' Link is clicked", "\'Guarantee\' Link is clicked","PASS",runManagerInfoObj);
				
				Thread.sleep(5000);
				for (String winHandle : driver.getWindowHandles()) 
				{
					driver.switchTo().window(winHandle);
					driver.manage().window().maximize();// switch focus of WebDriver to the next found window handle (that's your newly opened window)
				}
				
				Thread.sleep(5000); 
				
				if(cnf.FnExplicitWait("XPATH", mbo.NewTab_LogoCheck,driver)){
					if(driver.getCurrentUrl().contains("guarantee")){
						repfn.FnUpdateTestStepResHTML("Verify User is redirected to Guarantee page", "User is redirected to Guarantee page","PASS",runManagerInfoObj);
						Thread.sleep(8000);
						
						driver.close();
						
						Thread.sleep(5000);
						driver.switchTo().window(parentHandle);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify User is redirected to Guarantee page", "User is not redirected to Guarantee page","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Spectrum Business logo is displayed", "Spectrum Business logo is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify \'Guarantee\' Link is clicked", "\'Guarantee\' Link is not clicked","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Guarantee\' Link is displayed under Charter Corporate Header", "\'Guarantee\' Link is not displayed under Charter Corporate Header","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}
	catch (Exception e)
	{
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		repfn.FnUpdateTestStepResHTML("Verify User is redirected to Guarantee page", "User is not redirected to Guarantee page due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean FnSupport(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
	try{
		if(cnf.FnExplicitWait("XPATH", mbo.Support_MyAccount,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Support link is displayed","Support link is displayed","PASS",runManagerInfoObj);
			WebElement Support_Myacc=driver.findElement(By.xpath(mbo.Support_MyAccount));

			if(cnf.JSClick(Support_Myacc,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Support link is clicked","Support link is clicked","PASS",runManagerInfoObj);
				Thread.sleep(5000);

				if(driver.getCurrentUrl().contains("support")){
					repfn.FnUpdateTestStepResHTML("Verify User is in support page","User is in support page","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User is in support page","User is not in support page","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Support link is clicked","Support link is not clicked","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Support link is displayed","Support link is not displayed","FAIL",runManagerInfoObj);
			blnFlag=false;
		}

	}

	catch (Exception e)

	{
		repfn.FnUpdateTestStepResHTML("Verify if User is navigated to support page", "User is not navigated to Support page due to some exception", "FAIL",runManagerInfoObj);
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		blnFlag=false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}



	public synchronized boolean HeaderLinks_Authenticated(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
	{
		try
		{

			if(cnf.FnExplicitWait("XPATH",mbo.SpectrumLogo,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify if Spectrum Business Logo is displayed","Spectrum Business Logo is displayed","PASS",runManagerInfoObj);
				WebElement SpectrumLogo=driver.findElement(By.xpath(mbo.SpectrumLogo));
				if(cnf.JSClick(SpectrumLogo,driver)){
					repfn.FnUpdateTestStepResHTML("Verify if Spectrum Business Logo is clicked","Spectrum Business Logo is clicked","PASS",runManagerInfoObj);
					Thread.sleep(5000);
					if(driver.getCurrentUrl().contains("login")){
						repfn.FnUpdateTestStepResHTML("Verify User is navigated to Index page URL","User is navigated to Index page URL: "+driver.getCurrentUrl(),"PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify User is navigated to Index page URL","User is not navigated to Index page URL","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify if Spectrum Business Logo is clicked","Spectrum Business Logo is not clicked","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if Spectrum Business Logo is displayed","Spectrum Business Logo is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

			if(cnf.FnExplicitWait("XPATH",mbo.SupportBtn,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify if Support Link is displayed","Support Link is displayed","PASS",runManagerInfoObj);
				WebElement SupportBtn=driver.findElement(By.xpath(mbo.SupportBtn));
				if(cnf.JSClick(SupportBtn,driver)){

					repfn.FnUpdateTestStepResHTML("Verify if Support Link is clicked","Support Link is clicked","PASS",runManagerInfoObj);
					Thread.sleep(5000);
					if(driver.getCurrentUrl().contains("support")){
						repfn.FnUpdateTestStepResHTML("Verify User is navigated to Support page URL","User is navigated to Support page URL: "+driver.getCurrentUrl(),"PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify User is navigated to Support page URL","User is not navigated to Support page URL","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify if Support Link is clicked","Support Link is not clicked","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if Support Link is displayed","Support Link is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}


		}
		catch (Exception e)

		{
			repfn.FnUpdateTestStepResHTML("Verify if the Header links are displayed as expected for an authenticated user", "Header links are not displayed as expected for an authenticated user due to some exception","FAIL",runManagerInfoObj);
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			blnFlag=false;
			//repfn.FnUpdateTestStepResHTML("Verify if the shelf services and equipment in the overwiew page is displayed", "verify did not happen ","FAIL",runManagerInfoObj);
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	
}
