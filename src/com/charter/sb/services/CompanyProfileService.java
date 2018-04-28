package com.charter.sb.services;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.charter.sb.beans.RunManagerInfo;
import com.charter.sb.controllers.Initialization;
import com.charter.sb.resources.MB_PageObjects;
import com.charter.sb.utils.CommonFunctions;
import com.charter.sb.utils.ReportingFunctions;
import com.charter.sb.utils.RunManager;

public class CompanyProfileService extends Initialization{
	MB_PageObjects mbo = new MB_PageObjects();
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	public static boolean blnFlag = false;
	
	
	
	@SuppressWarnings("static-access")
	public synchronized boolean MyProfile_UI(WebDriver driver,RunManagerInfo runManagerInfoObj)
	{
		try
		{
			if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_FirstName,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify if First Name is displayed", "First Name is displayed", "PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if First Name is displayed", "First Name is not displayed", "FAIL",runManagerInfoObj);
				blnFlag=false;

			}

			if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_LastName,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify if Last Name is displayed", "Last Name is displayed", "PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if Last Name is displayed", "Last Name is not displayed", "FAIL",runManagerInfoObj);
				blnFlag=false;

			}


			if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_Email,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify if Email address is displayed", "Email address is displayed", "PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if email address is displayed", "Email address is not displayed", "FAIL",runManagerInfoObj);
				blnFlag=false;

			}

			if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_PhoneNumber,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify if Phone Number is displayed", "Phone Number is displayed", "PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if Phone Number is displayed", "Phone Number is not displayed", "FAIL",runManagerInfoObj);
				blnFlag=false;

			}



			if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_Save,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify if save button is displayed", "Save button is displayed", "PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if Save button is displayed", "Save button is not displayed", "FAIL",runManagerInfoObj);
				blnFlag=false;

			}

		//	driver.navigate().refresh();
		}
		catch(Exception e)
		{
			repfn.FnUpdateTestStepResHTML("Verify if UI Check of my profile is done", "UI Check of my profile is not done due to some exception", "FAIL",runManagerInfoObj);
			blnFlag=false;
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());

		}

		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;

	}
	 @SuppressWarnings("static-access")
	public synchronized boolean FnVerifyAndClickMyProfileLink(WebDriver driver,RunManagerInfo runManagerInfoObj){

		 try{
			 if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_Link,driver)){
				 WebElement MyProfile_Link=driver.findElement(By.xpath(mbo.MyProfile_Link));
				 repfn.FnUpdateTestStepResHTML("Verify My Profile link is present in Home page", 
						 "My Profile link is present in Home page","PASS",runManagerInfoObj);
				 Thread.sleep(5000);
				 cnf.ScrollToView(MyProfile_Link,driver);
				 if(cnf.JSClick(MyProfile_Link,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify My Profile link is clicked", "My Profile link is clicked","PASS",runManagerInfoObj);
					 Thread.sleep(5000);
					 blnFlag=true;
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify My Profile link is clicked", "My Profile link is not clicked","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }

			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify My Profile link is present in Home page", 
						 "My Profile link is not present in Home page","FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }

		 catch(Exception e)
		 {
			 repfn.FnUpdateTestStepResHTML("Verify My Profile link is present in Home page and clicked", "My Profile link is not present in Home page and not clicked due to some exception.","FAIL",runManagerInfoObj);
			 blnFlag=false;
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());

		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }
	 public synchronized boolean FnMyProfile(WebDriver driver,RunManagerInfo runManagerInfoObj){
			try{
				
				if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_MyAccount,driver)){
					repfn.FnUpdateTestStepResHTML("Verify My Profile link is displayed","My Profile link is displayed","PASS",runManagerInfoObj);
					WebElement MyProf=driver.findElement(By.xpath(mbo.MyProfile_MyAccount));

					if(cnf.JSClick(MyProf,driver)){
						System.out.println("My Profile page");
						repfn.FnUpdateTestStepResHTML("Verify My Profile link is getting displayed","My Profile link is getting displayed","PASS",runManagerInfoObj);
						Thread.sleep(5000);
						blnFlag=true;
						/*if(cnf.FnExplicitWait("XPATH", mbo.PageVerificationTwo,driver)){
							WebElement payBill_PageVerification_2=driver.findElement(By.xpath(mbo.PageVerificationTwo));
							if(payBill_PageVerification_2.getAttribute("textContent").equalsIgnoreCase("My Profile")){
								repfn.FnUpdateTestStepResHTML("Verify User is navigated to My Profile Page","User is navigated to My Profile page","PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify User is navigated to My Profile Page","User is not navigated to My Profile page","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User is able to verify current page","User is not able to verify current page","FAIL",runManagerInfoObj);
							blnFlag=false;
						}*/
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify My Profile link is clicked","My Profile link is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify My Profile link is displayed","My Profile link is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}

			catch (Exception e)

			{
				repfn.FnUpdateTestStepResHTML("Verify if user is navigated to My Profile Page", "User is not navigated to My Profile page due to some exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		//to navigate to Company Profile page//

		//To navigate to My Profile page//
	 public synchronized boolean MyProfile_SecuritySettings(WebDriver driver,RunManagerInfo runManagerInfoObj){
		 try{

			 if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_SecuritySettings,driver)){
				 repfn.FnUpdateTestStepResHTML("Verify Security settings tab is displayed","Security settings tab is displayed","PASS",runManagerInfoObj);
				 WebElement SS_Profile=driver.findElement(By.xpath(mbo.MyProfile_SecuritySettings));
				 if(cnf.JSClick(SS_Profile,driver)){
					 repfn.FnUpdateTestStepResHTML("Click Security settings tab","Security Settings tab is clicked","PASS",runManagerInfoObj); 
					 System.out.println("Security Settings page");
					 Thread.sleep(10000);
					 if(cnf.FnExplicitWait("XPATH", mbo.PageVerificationTwo,driver)){
						 WebElement payBill_PageVerification_2=driver.findElement(By.xpath(mbo.PageVerificationTwo));
						 if(payBill_PageVerification_2.getAttribute("textContent").equalsIgnoreCase("Security Settings")){
							 repfn.FnUpdateTestStepResHTML("Verify User is navigated to Security Settings Page","User is navigated to Security Settings page","PASS",runManagerInfoObj);
							 blnFlag=true;
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify User is navigated to Security Settings Page","User is not navigated to Security Settings page","FAIL",runManagerInfoObj);
							 blnFlag=false;
						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify User is able to verify current page","User is not able to verify current page","FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Click Security settings tab","Security Settings tab is not  clicked","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }				 
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify User in Security Settings page","User is not in Security Settings page","FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }

		 }

		 catch (Exception e)

		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
			 repfn.FnUpdateTestStepResHTML("Verify User in Security Settings page","User is not in Security Settings page due to some exception","FAIL",runManagerInfoObj);
			 blnFlag=false;

		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }
	 public synchronized boolean MyProfile_SecuritySettings_UI(WebDriver driver,RunManagerInfo runManagerInfoObj)
	 {
	 	try
	 	{
	 		if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_SS_Heading,driver))
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if title-UpdatePassword is displayed", "UpdatePassword Title is displayed", "PASS",runManagerInfoObj);
	 			blnFlag=true;
	 		}
	 		else
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if title-UpdatePassword is displayed", "UpdatePasswordSecurity Code Title is not displayed", "FAIL",runManagerInfoObj);
	 			blnFlag=false;

	 		}



	 		if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_SS_NewPasswordLabel,driver)&& cnf.FnExplicitWait("XPATH", mbo.MyProfile_SS_NewPasswordasterisk,driver))
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if New Password Label with * is displayed", "New Password Label with * is displayed", "PASS",runManagerInfoObj);
	 			blnFlag=true;
	 		}
	 		else
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if New Password Label with * is displayed", "New Password Label with * is not displayed", "FAIL",runManagerInfoObj);
	 			blnFlag=false;

	 		}

	 		if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_SS_ConfirmPasswordLabel,driver)&& cnf.FnExplicitWait("XPATH", mbo.MyProfile_SS_confirmPasswordasterisk,driver))
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if Confirm Password LAbel with * is displayed", "Confirm Password Label with * is displayed", "PASS",runManagerInfoObj);
	 			blnFlag=true;
	 		}
	 		else
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if Confirm Password LAbel with * is displayed", "Confirm Password LAbel with * is not displayed", "FAIL",runManagerInfoObj);
	 			blnFlag=false;

	 		}

	 		if(cnf.FnExplicitWait("XPATH", mbo.Helpicon,driver))
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if Tooltip is displayed", "Tool tip is displayed", "PASS",runManagerInfoObj);
	 			blnFlag=true;
	 		}
	 		else
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if Tool tip is displayed", "Tool tip is not displayed", "FAIL",runManagerInfoObj);
	 			blnFlag=false;

	 		}

	 		if(cnf.FnExplicitWait("XPATH", mbo.Passwordchecklist,driver))
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if Password checklist is displayed", "Password checklist is displayed", "PASS",runManagerInfoObj);
	 			blnFlag=true;
	 		}
	 		else
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if Password checklist is displayed", "Password checklist is not displayed", "FAIL",runManagerInfoObj);
	 			blnFlag=false;

	 		}

	 		if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_SS_Password,driver))
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if text box to enter password is displayed", "text box to enter password is displayed", "PASS",runManagerInfoObj);
	 			blnFlag=true;
	 		}
	 		else
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if text box to enter password is displayed", "text box to enter password is not displayed", "FAIL",runManagerInfoObj);
	 			blnFlag=false;

	 		}


	 		if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_SS_ConfirmPassword,driver))
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if textbox to retype password is displayed", "textbox to retype password is displayed", "PASS",runManagerInfoObj);
	 			blnFlag=true;
	 		}
	 		else
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if textbox to retype password is displayed", "textbox to retype password is not displayed", "FAIL",runManagerInfoObj);
	 			blnFlag=false;

	 		}

	 		if(cnf.FnExplicitWait("XPATH", mbo.MyProf_SS_Save,driver))
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if save button is displayed", "Save button is displayed", "PASS",runManagerInfoObj);
	 			blnFlag=true;
	 		}
	 		else
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if Save button is displayed", "Save button is not displayed", "FAIL",runManagerInfoObj);
	 			blnFlag=false;

	 		}

	 		driver.navigate().refresh();
	 	}
	 	catch(Exception e)
	 	{
	 		System.err.println("Message : "+e.getMessage());
	 		System.err.println("Cause : "+e.getCause());
	 		repfn.FnUpdateTestStepResHTML("Verify if UI Check of Security page is done", "UI Check of Security page is not done due to some exception", "FAIL",runManagerInfoObj);
	 		blnFlag=false;
	 	}

	 	m1.put("STEPSTATUS", blnFlag);
	 	return blnFlag;

	 }
	 public synchronized boolean FN_PasswordHelpIcon_Check(WebDriver driver,RunManagerInfo runManagerInfoObj){
			try{
				if(cnf.FnExplicitWait("Xpath", mbo.HelpIcon,driver)){
					WebElement HelpIcon=driver.findElement(By.xpath(mbo.HelpIcon));
					repfn.FnUpdateTestStepResHTML("Verify 'Help Icon' is displayed near New Password field","Help Icon' is displayed near New Password field","PASS",runManagerInfoObj);
					if(cnf.JSClick(HelpIcon,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Help Icon is Clicked  ","Help Icon is Clicked ","PASS",runManagerInfoObj);
						if(cnf.FnExplicitWait("Xpath", mbo.HelpToolTip,driver)){
							WebElement HelpToolTip=driver.findElement(By.xpath(mbo.HelpToolTip));
							repfn.FnUpdateTestStepResHTML("Verify Help Tool Tip Popup is displayed  ","Help Tool Tip Popup is displayed ","PASS",runManagerInfoObj);
							
							if(cnf.FnExplicitWait("Xpath", mbo.OkButton,driver)){
								WebElement OkButton=driver.findElement(By.xpath(mbo.OkButton));	
								if(cnf.JSClick(OkButton,driver)){
									repfn.FnUpdateTestStepResHTML("Verify OK button is clicked","OK button is clicked","PASS",runManagerInfoObj);
									blnFlag=true;
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify OK button is clicked","OK button is not clicked","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify OK button is displayed","OK button is not displayed","FAIL",runManagerInfoObj);
								driver.navigate().refresh();
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Help Tool Tip Popup is displayed  ","Help Tool Tip Popup is not  displayed ","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Help Icon is Clicked  ","Help Icon is not  Clicked ","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify 'Help Icon' is displayed near New Password field","Help Icon' is not  displayed near New Password field","FAIL",runManagerInfoObj);
					blnFlag=false;

				}
			}
			
			catch (Exception e)

			{
				repfn.FnUpdateTestStepResHTML("Verify 'Help Icon' is displayed near New Password feild","Help Icon' is not  displayed near New Password feild due to some exception","FAIL",runManagerInfoObj);
				blnFlag=false;

				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}


	 public synchronized boolean FnVerifyAndClickSecuritySettingsLink(WebDriver driver,RunManagerInfo runManagerInfoObj){

		 try{

			 if(cnf.FnExplicitWait("XPATH", mbo.SecuritySettingsLink,driver)){
				 WebElement SecuritySettingsLink=driver.findElement(By.xpath(mbo.SecuritySettingsLink));
				 repfn.FnUpdateTestStepResHTML("Verify Security Settings link is displayed", 
						 "Security Settings link is displayed","PASS",runManagerInfoObj);
				 Thread.sleep(5000);
				 cnf.ScrollToView(SecuritySettingsLink,driver);
				 if(cnf.JSClick(SecuritySettingsLink,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify Security Settings link is clicked", "Security Settings link is clicked","PASS",runManagerInfoObj);
					 Thread.sleep(5000);

					  if(cnf.FnExplicitWait("XPATH", mbo.PageVerificationOne,driver)){
    					  WebElement payBill_PageVerification_1=driver.findElement(By.xpath(mbo.PageVerificationOne));
    					  if(payBill_PageVerification_1.getAttribute("textContent").equalsIgnoreCase("Profile")){
    						  if(cnf.FnExplicitWait("XPATH", mbo.PageVerificationTwo,driver)){
    							  WebElement payBill_PageVerification_2=driver.findElement(By.xpath(mbo.PageVerificationTwo));
    							  if(payBill_PageVerification_2.getAttribute("textContent").equalsIgnoreCase("Security Settings")){
    								  repfn.FnUpdateTestStepResHTML("Verify User is navigated to Security Settings page","User is navigated to Security Settings page","PASS",runManagerInfoObj);
    								  blnFlag=true;
    							  }

    							  else{
    								  repfn.FnUpdateTestStepResHTML("Verify User is navigated to Security Settings page","User is not navigated to Security Settings page","FAIL",runManagerInfoObj);
    								  blnFlag=false;
    							  }
    						  }
    					  }
    				  }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify Security Settings link is clicked", "Security Settings link is not clicked","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify Security Settings link is displayed", 
						 "Security Settings link is not displayed","FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }

		 catch(Exception e)
		 {
			 repfn.FnUpdateTestStepResHTML("Verify Security Settings link is present in Home page and clicked", "Security Settings link is not present in Home page and not clicked due to some exception.","FAIL",runManagerInfoObj);
			 blnFlag=false;
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());

		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }
	 public synchronized boolean FnVerifySecurityQA_RequiredFields(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{
			
			try{
				
				if(cnf.FnExplicitWait("XPATH", mbo.SecurityQuestionText,driver)){
					 WebElement SecurityQuestionText=driver.findElement(By.xpath(mbo.SecurityQuestionText));
					 if(SecurityQuestionText.getText().contains("*")){
						 repfn.FnUpdateTestStepResHTML("Verify \'*\' indicator is displayed for Security Question field", "\'*\' indicator is displayed for Security Question field", "PASS", runManagerInfoObj);
						 blnFlag=true;
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify \'*\' indicator is displayed for Security Question field", "\'*\' indicator is not displayed for Security Question field", "FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }			 
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify Security Question text is displayed", "Security Question text is not displayed", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
				
				if(cnf.FnExplicitWait("XPATH", mbo.SecurityAnswerText,driver)){
					 WebElement SecurityAnswerText=driver.findElement(By.xpath(mbo.SecurityAnswerText));
					 if(SecurityAnswerText.getText().contains("*")){
						 repfn.FnUpdateTestStepResHTML("Verify \'*\' indicator is displayed for Security Answer field", "\'*\' indicator is displayed for Security Answer field", "PASS",runManagerInfoObj);
						 blnFlag=true;
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify \'*\' indicator is displayed for Security Answer field", "\'*\' indicator is not displayed for Security Answer field", "FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify Security Answer text is displayed", "Security Answer text is not displayed", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
				
				if(cnf.FnExplicitWait("XPATH", mbo.SecurityQARequiredText,driver)){
					WebElement SecurityQARequiredText=driver.findElement(By.xpath(mbo.SecurityQARequiredText));
					repfn.FnUpdateTestStepResHTML("Verify Required text is displayed in Security Q/A section in upper right corner", "Required text is displayed in Security Q/A section in upper right corner as: "+SecurityQARequiredText.getText(), "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Required text is displayed in Security Q/A section in upper right corner", "Required text is not displayed in Security Q/A section in upper right corner", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			
			catch (Exception e)

			 {		
				 repfn.FnUpdateTestStepResHTML("Verify if User is able to verify Security Question/Answer Required Fields on Security Settings page", "User is able to verify Security Question/Answer Required Fields on Security Settings page due to some exception", "FAIL",runManagerInfoObj);
				 blnFlag=false;
				 System.err.println("Message : "+e.getMessage());
				 System.err.println("Cause : "+e.getCause());
			 }
			
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;
		}	
	 @SuppressWarnings("static-access")
	public synchronized boolean FnCompanyProfile(WebDriver driver, RunManagerInfo runManagerInfoObj){
			try{
				if(cnf.FnExplicitWait("XPATH", mbo.CompanyProfile_MyAccount,driver)){
					WebElement CompanyProfile=driver.findElement(By.xpath(mbo.CompanyProfile_MyAccount));

					repfn.FnUpdateTestStepResHTML("Verify Company Profile link is displayed","Verify Company Profile Link is displayed","PASS",runManagerInfoObj);
					if(cnf.JSClick(CompanyProfile,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Company Profile link is clicked","Verify Company Profile Link is clicked","PASS",runManagerInfoObj);
						Thread.sleep(5000);
						// if(driver.getCurrentUrl().contains("company/profile")){
						if(cnf.FnExplicitWait("XPATH",mbo.CompanyProfileurl,driver)){
							repfn.FnUpdateTestStepResHTML("Verify User in Company Profile page","User in Company Profile page","PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User in Company Profile page","User is not in Company Profile page","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Company Profile link is clicked","Verify Company Profile Link is not  clicked","FAIL",runManagerInfoObj);
						blnFlag=true;
					}					
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Company Profile link is displayed","Verify Company Profile Link is not  displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}

			catch (Exception e)

			{
				repfn.FnUpdateTestStepResHTML("Verify if User is navigated to Company Profile page", "User is not navigated to Company Profile page due to some exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
	 @SuppressWarnings("static-access")
	public synchronized boolean FnCompanyProfile_SecuritySettings(WebDriver driver, RunManagerInfo runManagerInfoObj){
		 try{		
			 if( cnf.FnExplicitWait("XPATH", mbo.CompanyProfile_SecuritySettings,driver)){
				 repfn.FnUpdateTestStepResHTML("Verify Security Settings Link is present","Security Settings Link is present","PASS",runManagerInfoObj);
				 WebElement SecuritySetting=driver.findElement(By.xpath(mbo.CompanyProfile_SecuritySettings));
				 if(cnf.JSClick(SecuritySetting,driver)){
					 System.out.println("Security Settings page");
					 repfn.FnUpdateTestStepResHTML("Verify  Security Settings Link is clicked","Security Settings Link is clicked","PASS",runManagerInfoObj);

					 if(cnf.FnExplicitWait("XPATH", mbo.PageVerificationOne,driver)){
						 WebElement payBill_PageVerification_1=driver.findElement(By.xpath(mbo.PageVerificationOne));
						 if(payBill_PageVerification_1.getAttribute("textContent").equalsIgnoreCase("Company")){
							 if(cnf.FnExplicitWait("XPATH", mbo.PageVerificationTwo,driver)){
								 WebElement payBill_PageVerification_2=driver.findElement(By.xpath(mbo.PageVerificationTwo));
								 if(payBill_PageVerification_2.getAttribute("textContent").equalsIgnoreCase("Security")){
									 repfn.FnUpdateTestStepResHTML("Verify User is navigated to Security Settings Page","User is navigated to Security Settings page","PASS",runManagerInfoObj);
									 blnFlag=true;
									 Thread.sleep(5000);
								 }
								 else{
									 repfn.FnUpdateTestStepResHTML("Verify User is navigated to Security Settings Page","User is not navigated to Security Settings page","FAIL",runManagerInfoObj);
									 blnFlag=false;
								 }
							 }
						 }
					 }
				 }			 
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if User in Security Settings page","User is not in Security Settings page","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify  Security Settings Link is present","Security Settings Link is not present","FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }

		 catch (Exception e)

		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
			 repfn.FnUpdateTestStepResHTML("Verify  Security Settings Link is present and clicked","Security Settings Link is not present and clicked due to some exception","FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }
	 public synchronized boolean SecurityCode_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 boolean blnFlag1 = NewSecurityCode(driver,runManagerInfoObj);
			 boolean blnFlag2 = ReenterSecurityCode(driver,runManagerInfoObj);
			 if(blnFlag1 && blnFlag2){
				 boolean blnFlag3 = SecuritySettings_Cancel(driver,runManagerInfoObj);
				 if(blnFlag3){
					 boolean blnFlag4 = ShowCode(driver,runManagerInfoObj);
					 if(blnFlag4){
						 boolean blnFlag5 = VerifyCode_Cancel(driver,runManagerInfoObj);
						 if(blnFlag5){
							 repfn.FnUpdateTestStepResHTML("Verify if Editing Security Code is canceled", "Editing Security Code is canceled", "PASS",runManagerInfoObj);
							 blnFlag=true;
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify if Editing Security Code is canceled", "Editing Security Code is not canceled", "FAIL",runManagerInfoObj);
							 blnFlag=false;
						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify if the Show Code and Hide Code links are displayed", "Show Code and Hide Code links are not displayed", "FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify Cancel button is displayed and clicked", "Cancel button is not displayed and clicked", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify if Security Code is entered", "Security Code is not entered", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
			 repfn.FnUpdateTestStepResHTML("Verify if Editing Security Code is canceled", "Editing Security Code is not canceled due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }
	 public synchronized boolean NewSecurityCode(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {		
			 
			 System.out.println(m1);
			 //int RandomInt=randomInt;
			 String Code=m1.get("SecurityCode").toString();	
			 
			 if(cnf.FnExplicitWait("XPATH", mbo.SS_NewSecuritycode,driver))
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if \'New Security Code\' input field is displayed", "\'New Security Code\' input field is displayed", "PASS",runManagerInfoObj);
				 WebElement Pin=driver.findElement(By.xpath(mbo.SS_NewSecuritycode));
				 Pin.sendKeys(Code);
				 repfn.FnUpdateTestStepResHTML("Verify if \'New Security Code\' is entered", "\'New Security Code\' is entered: " +Code, "PASS",runManagerInfoObj);
				 blnFlag=true;
			 }
			 else
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if \'New Security Code\' input field is displayed", "\'New Security Code\' input field is not displayed", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
			 repfn.FnUpdateTestStepResHTML("Verify if New Security Code can be entered", "New Security Code cannot be entered due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }

	 //To reenter Security code for confirmation//

	 public synchronized boolean ReenterSecurityCode(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 //int RandomInt=randomInt;
			 String Code=m1.get("SecurityCode").toString();		
			 if( cnf.FnExplicitWait("XPATH", mbo.SS_Pinconfirmation,driver))
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if \'Retype New Security Code\' input field is displayed", "\'Retype New Security Code\' input field is displayed", "PASS",runManagerInfoObj);
				 WebElement Pin=driver.findElement(By.xpath(mbo.SS_Pinconfirmation));
				if(cnf.JSClick(Pin, driver)){
				 Thread.sleep(3000);
				 Pin.sendKeys(Code);
				 repfn.FnUpdateTestStepResHTML("Verify if Security Code can be re-entered in \'Retype New Security Code\' field", "Security Code can be re-entered in the \'Retype New Security Code\' field: " +Code, "PASS",runManagerInfoObj);
				 blnFlag=true;
				}
				else{
					blnFlag=false;
				}
			 }
			 else
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if \'Retype New Security Code\' input field is displayed", "\'Retype New Security Code\' input field is not displayed", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());	
			 repfn.FnUpdateTestStepResHTML("Verify if Security Code can be re-entered in \'Retype New Security Code\' field", "Security Code cannot be re-entered in the \'Retype New Security Code\' field due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;

	 }
	 public synchronized boolean SecuritySettings_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {		
			 if(cnf.FnExplicitWait("XPATH", mbo.SecurityProfile_Cancel,driver))
			 {
				 WebElement Cancel=driver.findElement(By.xpath(mbo.SecurityProfile_Cancel));
				 System.out.println("Cancel displayed");
				 repfn.FnUpdateTestStepResHTML("Verify if Cancel button is present", "Cancel button is present", "PASS",runManagerInfoObj);
				 Thread.sleep(2000);

				 if(cnf.JSClick(Cancel,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify if Cancel button is clicked", "Cancel button is clicked", "PASS",runManagerInfoObj);
					 blnFlag=true;
				 }
				 else{
					 //Thread.sleep(1000);
					 repfn.FnUpdateTestStepResHTML("Verify if Cancel is clicked", "Cancel is not clicked", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 else
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if Cancel button is present", "Cancel button is not present", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());	
			 repfn.FnUpdateTestStepResHTML("Verify if Cancel is clicked", "Cancel is not  clicked due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;

	 }
	 public synchronized boolean ShowCode(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 if(cnf.FnExplicitWait("XPATH", mbo.SS_showCode,driver))
			 {
				 WebElement Showcode=driver.findElement(By.xpath(mbo.SS_showCode));
				 System.out.println("show code displayed");
				 repfn.FnUpdateTestStepResHTML("Verify if Show Code Link is displayed", "Show Code link is displayed", "PASS",runManagerInfoObj);
				 Thread.sleep(1000);
				 if(cnf.JSClick(Showcode,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify if Show Code Link is clicked", "Show Code link is clicked", "PASS",runManagerInfoObj);
					 if(cnf.FnExplicitWait("XPATH", mbo.SS_HideCode,driver))
					 {
						 //WebElement HideCode=driver.findElement(By.xpath(mbo.SS_HideCode));
						 repfn.FnUpdateTestStepResHTML("Verify if Hide Code link is displayed", "Hide Code link is displayed", "PASS",runManagerInfoObj);
						 //cnf.JSClick(HideCode);
						 blnFlag=true;
					 }
					 else
					 {
						 repfn.FnUpdateTestStepResHTML("Verify if Hide Code link is displayed", "Hide Code Link is not displayed", "FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if Show Code Link is clicked", "Show Code link is not clicked", "FAIL",runManagerInfoObj);
                     blnFlag=false;
				 }
			 }
			 else
			 {
				 System.out.println("changes not saved");
				 repfn.FnUpdateTestStepResHTML("Verify if the changes made are cancelled", "Changes made are not cancelled", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }

		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
			 repfn.FnUpdateTestStepResHTML("Verify if the Show Code and Hide Code links are displayed", "Show Code and Hide Code links are not displayed due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }

	 public synchronized boolean VerifyCode_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			// int RandomInt=randomInt;
			 String Code=m1.get("SecurityCode").toString();				 
			 if(cnf.FnExplicitWait("Xpath", mbo.SS_CodeValue,driver)){
				 WebElement CodeCheck=driver.findElement(By.xpath(mbo.SS_CodeValue));
				 System.out.println("Code value"+Code);
				 repfn.FnUpdateTestStepResHTML("Verify if the Default code value is displayed", "Default code value is displayed: "+CodeCheck.getAttribute("textContent"), "PASS",runManagerInfoObj);
				 if(!CodeCheck.getAttribute("textContent").contains(Code))
				 {
					 System.out.println("changes cancelled");
					 repfn.FnUpdateTestStepResHTML("Verify Changes are canceled", "Changes are canceled", "PASS",runManagerInfoObj);
					 blnFlag=true;
				 }
				 else
				 {
					 repfn.FnUpdateTestStepResHTML("Verify Changes are canceled", "Changes are not canceled", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 } 
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify if the Default code value is displayed", "Default code value is not displayed", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
			 repfn.FnUpdateTestStepResHTML("Verify if the changes made are cancelled", "Changes made are not cancelled due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }

	 public synchronized boolean SecurityCode_Save(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 
			 boolean blnFlag1 = NewSecurityCode(driver,runManagerInfoObj);
			 boolean blnFlag2 = ReenterSecurityCode(driver,runManagerInfoObj);
			 if(blnFlag1 && blnFlag2){
				 boolean blnFlag3 = SecuritySettings_Save(driver,runManagerInfoObj);
				 if(blnFlag3){
					 boolean blnFlag4 = ShowCode(driver,runManagerInfoObj);
					 if(blnFlag4){
						 boolean blnFlag5 = VerifyCode_Save(driver,runManagerInfoObj);
						 if(blnFlag5){
							 repfn.FnUpdateTestStepResHTML("Verify if Security Code is edited", "Security Code is edited", "PASS",runManagerInfoObj);
							 blnFlag=true;
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify if Security Code is edited", "Security Code is edited", "FAIL",runManagerInfoObj);
							 blnFlag=false;
						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify if the Show Code and Hide Code links are displayed", "Show Code and Hide Code links are not displayed", "FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify Save button is displayed and clicked", "Save button is not displayed and clicked", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify if Security Code is entered", "Security Code is not entered", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }			 
		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
			 repfn.FnUpdateTestStepResHTML("Verify if Security Code is edited", "Security Code is not edited due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }
	 @SuppressWarnings("static-access")
	public synchronized boolean SecuritySettings_Save(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {			
			 if(cnf.FnExplicitWait("XPATH", mbo.SecuritySettings_Save,driver))
			 {
				 WebElement Save=driver.findElement(By.xpath(mbo.SecuritySettings_Save));
				 System.out.println("Save displayed");
				 repfn.FnUpdateTestStepResHTML("Verify if Save button is present", "Save button is present", "PASS",runManagerInfoObj);
				 Thread.sleep(5000);
				 if(Save.isEnabled())
				 {
					 System.out.println("Save enabled");
					 repfn.FnUpdateTestStepResHTML("Verify if Save button is enabled", "Save button is enabled", "PASS",runManagerInfoObj);
					 Thread.sleep(2000);
					 if(cnf.JSClick(Save,driver)){
						 repfn.FnUpdateTestStepResHTML("Verify if Save button is clicked", "Save button is clicked", "PASS",runManagerInfoObj);
						 System.out.println("Save clicked");
						 if(cnf.FnExplicitWait("XPATH", mbo.SecuritySettings_SuccessSaveMessage,driver))
						 {
							 WebElement SecuritySettings_SuccessSaveMessage=driver.findElement(By.xpath(mbo.SecuritySettings_SuccessSaveMessage));
							 repfn.FnUpdateTestStepResHTML("Verify if Success Message is displayed", " Success message is displayed: "+SecuritySettings_SuccessSaveMessage.getText(), "PASS",runManagerInfoObj);
							 blnFlag=true;
						 }
						 else
						 {
							 repfn.FnUpdateTestStepResHTML("Verify if Success Message is displayed", "Success message is not displayed", "FAIL",runManagerInfoObj);
							 blnFlag=false;	
						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify if Save button is clicked", "Save button is not clicked", "FAIL",runManagerInfoObj);
						 blnFlag=false;	
					 }					
				 }
				 else 
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if Save button is enabled", "Save button is not enabled", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 else
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if Save button is present", "Save button is not present", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }
		 catch(Exception e)
		 {
			 
			 repfn.FnUpdateTestStepResHTML("Verify if Success Message is displayed", "Success message is not displayed due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag=false;	
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());	
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;

	 }
	 public synchronized boolean VerifyCode_Save(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 //int RandomInt=randomInt;
			 String Code=m1.get("SecurityCode").toString();
			 
			 if(cnf.FnExplicitWait("XPATH", mbo.SS_CodeValue,driver)){
				 repfn.FnUpdateTestStepResHTML("Verify security code is displayed ", "Security Code is  displayed", "PASS",runManagerInfoObj);
				 WebElement CodeCheck=driver.findElement(By.xpath(mbo.SS_CodeValue));
				 System.out.println("Code value"+Code);
				 if(CodeCheck.getAttribute("textContent").contains(Code))
				 {
					 System.out.println("changes saved");
					 repfn.FnUpdateTestStepResHTML("Verify if the New security code is saved", "New security Code is saved: "+CodeCheck.getAttribute("textContent"), "PASS",runManagerInfoObj);
					 blnFlag=true;
				 }
				 else
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if the New Security code is saved", "New Security Code is not saved", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 } 
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify security code is displayed ", "Security Code is not displayed", "FAIL",runManagerInfoObj);
 
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
	 public synchronized boolean InvalidSecurityCode(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 boolean blnFlag1 = SecurityCode_InvalidLength(driver,runManagerInfoObj);
			 boolean blnFlag2 = SecurityCode_consecutiveNumbers(driver,runManagerInfoObj);
			 boolean blnFlag3 = SecurityCode_SameNumbers(driver,runManagerInfoObj);
			 boolean blnFlag4 = SecuritySettings_Cancel(driver,runManagerInfoObj);
			 if(blnFlag1 && blnFlag2 && blnFlag3 && blnFlag4){
				 repfn.FnUpdateTestStepResHTML("Verify that the user is displayed with error message on entering invalid security code", "User is displayed with error message on entering invalid security code", "PASS",runManagerInfoObj);
				 blnFlag=true;
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify that the user is displayed with error message on entering invalid security code", "User is not displayed with error message on entering invalid security code", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
			 repfn.FnUpdateTestStepResHTML("Verify that the user is displayed with error message on entering invalid security code", "User is not displayed with error message on entering invalid security code due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }
	 public synchronized boolean SecurityCode_InvalidLength(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 //String Browser=m1.get("Browser").toString();
			 String Browser=runManagerInfoObj.getBrowserVersion();
			 System.out.println("Browser" +Browser);
			 if(Browser.equalsIgnoreCase("chrome") || Browser.equalsIgnoreCase("firefox"))
			 {
				 String Code="5486";			 
				 if(cnf.FnExplicitWait("XPATH", mbo.SS_NewSecuritycode,driver))
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if New Security Code input field is displayed", "New Security Code input field is displayed", "PASS",runManagerInfoObj);
					 WebElement Pin=driver.findElement(By.xpath(mbo.SS_NewSecuritycode));
					 if(cnf.JSClick(Pin, driver)){
					 Pin.sendKeys(Code);
					 repfn.FnUpdateTestStepResHTML("Verify if New Security Code can be entered", "New Security Code can be entered: " +Code, "PASS",runManagerInfoObj);
					 }else{
						 repfn.FnUpdateTestStepResHTML("Verify if New Security Code can be entered", "New Security Code can not be entered: " +Code, "FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
					 if(cnf.FnExplicitWait("XPATH", mbo.SS_InvalidSecurityCode,driver))
					 {
						 WebElement Error=driver.findElement(By.xpath(mbo.SS_InvalidSecurityCode));
						 repfn.FnUpdateTestStepResHTML("Verify if Security Code error message is displayed", "Security Code error message is displayed as: "+Error.getAttribute("textContent"), "FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
					 else
					 {
						 repfn.FnUpdateTestStepResHTML("Verify if Security Code error message is displayed", "Error Message is not displayed", "PASS",runManagerInfoObj);
						 blnFlag=true;
					 }
				 }
				 else
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if New Security Code input field is displayed", "New Security Code input field is not displayed", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 else if(Browser.equalsIgnoreCase("IE"))
			 {
				 String Code="55655";
				 int length = Code.length();

				 if(cnf.FnExplicitWait("XPATH", mbo.SS_NewSecuritycode,driver))
				 {
					 WebElement Pin=driver.findElement(By.xpath(mbo.SS_NewSecuritycode));
					 if(cnf.JSClick(Pin, driver)){
						 Pin.sendKeys(Code);
					 }
					 int lengthOne =Pin.getAttribute("value").length();
					 if(lengthOne != length){
						 repfn.FnUpdateTestStepResHTML("Verify if User can enter more than 4 characters of New Security Code", "User is restricted to enter only 4 characters", "PASS",runManagerInfoObj);
						 blnFlag=true;
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify if User can enter more than 4 characters of New Security Code", "User is not restricted to enter only 4 characters", "FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
				 else
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if New Security Code can be entered", "New Security Code cannot be entered", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }	
		 }
		 catch(Exception e)
		 {

			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
			 repfn.FnUpdateTestStepResHTML("Verify if error message is displayed on entering invalid length Security code", "Error Message is not displayed on entering invalid length Security code due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }
	 public synchronized boolean SecurityCode_consecutiveNumbers(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 String Code="1234";		 
			 if(cnf.FnExplicitWait("XPATH", mbo.SS_NewSecuritycode,driver))
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if New Security Code input field is displayed", "New Security Code input field is displayed", "PASS",runManagerInfoObj);
				 WebElement Pin=driver.findElement(By.xpath(mbo.SS_NewSecuritycode));
				 Pin.clear();
				 if(cnf.JSClick(Pin, driver)){
					 Pin.sendKeys(Code);
				 repfn.FnUpdateTestStepResHTML("Verify if New Security Code can be entered", "New Security Code can be entered: " +Code, "PASS",runManagerInfoObj);
				 blnFlag=true;
				 }
				 else{
					 blnFlag=false;
					 repfn.FnUpdateTestStepResHTML("Verify if New Security Code can be entered", "New Security Code can not be entered: " +Code, "FAIL",runManagerInfoObj);
				 }
				 if(cnf.FnExplicitWait("XPATH", mbo.SS_InvalidSecurityCode,driver))
				 {
					 WebElement Error=driver.findElement(By.xpath(mbo.SS_InvalidSecurityCode));
					 repfn.FnUpdateTestStepResHTML("Verify if Security codes error message is displayed", "Security codes error message is displayed: "+Error.getAttribute("textContent"), "PASS",runManagerInfoObj);
					 blnFlag=true;				 
				 }
				 else
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if Security codes error message is displayed", "Error Message is not displayed", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 else
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if New Security Code input field is displayed", "New Security Code input field is not displayed", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }
		 catch(Exception e)
		 {

			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
			 repfn.FnUpdateTestStepResHTML("Verify if error message is displayed when consecutive numbers are entered", "Error Message is not displayed when consecutive numbers are entered due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }
	 public synchronized boolean SecurityCode_SameNumbers(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 String Code="1111";			 
			 if(cnf.FnExplicitWait("XPATH", mbo.SS_NewSecuritycode,driver))
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if New Security Code input field is displayed", "New Security Code input field is displayed", "PASS",runManagerInfoObj);
				 WebElement Pin=driver.findElement(By.xpath(mbo.SS_NewSecuritycode));
				 Pin.clear();
				 if(cnf.JSClick(Pin, driver)){
					 Pin.sendKeys(Code);
				 repfn.FnUpdateTestStepResHTML("Verify if New Security Code can be entered", "New Security Code can be entered: " +Code, "PASS",runManagerInfoObj);
				 blnFlag=true;	
				 }else{
					 blnFlag=false;
					 repfn.FnUpdateTestStepResHTML("Verify if New Security Code can be entered", "New Security Code can not be entered: " +Code, "FAIL",runManagerInfoObj);
				 }
				 if(cnf.FnExplicitWait("XPATH", mbo.SS_InvalidSecurityCode,driver))
				 {
					 WebElement Error=driver.findElement(By.xpath(mbo.SS_InvalidSecurityCode));
					 repfn.FnUpdateTestStepResHTML("Verify if Security codes error message is displayed", "Security codes error message is displayed: "+Error.getAttribute("textContent"), "PASS",runManagerInfoObj);
					 blnFlag=true;					 
				 }
				 else
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if Security codes error message is displayed", "Error Message is not displayed", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 else
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if New Security Code input field is displayed", "New Security Code input field is not displayed", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }
		 catch(Exception e)
		 {

			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
			 repfn.FnUpdateTestStepResHTML("Verify if error message is displayed on entering same numbers", "Error Message is not displayed on entering same numbers due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }



	
	
	

	
	 public synchronized boolean CompanyProfile_Save(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {			
			 if(cnf.FnExplicitWait("XPATH", mbo.CompanyProfile_Save,driver))
			 {
				 WebElement Save=driver.findElement(By.xpath(mbo.CompanyProfile_Save));
				 System.out.println("Save displayed");
				 repfn.FnUpdateTestStepResHTML("Verify if Save button is present", "Save button is present", "PASS",runManagerInfoObj);
				 Thread.sleep(5000);
				 if(Save.isEnabled())
				 {
					 System.out.println("Save enabled");
					 repfn.FnUpdateTestStepResHTML("Verify if Save button is enabled", "Save button is enabled", "PASS",runManagerInfoObj);
					 Thread.sleep(5000);
					 if(cnf.JSClick(Save,driver)){
						 System.out.println("Save clicked");
						 repfn.FnUpdateTestStepResHTML("Verify if Save button is clicked", "Save button is clicked", "PASS",runManagerInfoObj);
						 
						 Thread.sleep(3000);
						 String Street=m1.get("Street2").toString();
						 if(cnf.FnExplicitWait("XPATH", mbo.CompanyProfile_StreetAddress3_editable,driver))
						 {
							 WebElement CompanyProfile_StreetAddress3_editable=driver.findElement(By.xpath(mbo.CompanyProfile_StreetAddress3_editable));
							 if(CompanyProfile_StreetAddress3_editable.getAttribute("value").contains(Street)){
								 repfn.FnUpdateTestStepResHTML("Verify if the Changes made are saved", "Changes made are saved", "PASS",runManagerInfoObj);
								 blnFlag=true;
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify if the Changes made are saved", "Changes made are not saved", "FAIL",runManagerInfoObj);
								 blnFlag=false;
							 }
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify if Address Street 2 is displayed", "Address Street 2 is not displayed", "FAIL",runManagerInfoObj);
							 blnFlag=false;
						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify if Save button is clicked", "Save button is not  clicked", "FAIL",runManagerInfoObj);
						 blnFlag=false; 
					 }
				 }
				 else 
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if Save button is enabled", "Save button is not enabled", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 else
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if Save button is present", "Save button is not present", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
			 repfn.FnUpdateTestStepResHTML("Verify if Save button is present and clicked", "Save button is not present and clicked due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;

	 }
	 public synchronized boolean FnVerifyAndClickCompanyProfileLink(WebDriver driver, RunManagerInfo runManagerInfoObj){

		 try{
			 
			 if(cnf.FnExplicitWait("XPATH", mbo.CompanyProfile_Link,driver)){
				 WebElement CompanyProfile_Link=driver.findElement(By.xpath(mbo.CompanyProfile_Link));
				 repfn.FnUpdateTestStepResHTML("Verify Company Profile link is present in Home page", 
						 "Company Profile link is present in Home page","PASS",runManagerInfoObj);
				 cnf.ScrollToView(CompanyProfile_Link,driver);
				 if(cnf.JSClick(CompanyProfile_Link,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify Company Profile link is clicked", "Company Profile link is clicked","PASS",runManagerInfoObj);
					 Thread.sleep(2000);
					 
					 if(cnf.FnExplicitWait("XPATH", mbo.PageVerificationOne,driver)){
						 WebElement payBill_PageVerification_1=driver.findElement(By.xpath(mbo.PageVerificationOne));
						 if(payBill_PageVerification_1.getAttribute("textContent").contains("Company")){
							 if(cnf.FnExplicitWait("XPATH", mbo.PageVerificationTwo,driver)){
								 WebElement payBill_PageVerification_2=driver.findElement(By.xpath(mbo.PageVerificationTwo));
								 if(payBill_PageVerification_2.getAttribute("textContent").contains("Profile")){
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
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify Company Profile link is clicked", "Company Profile link is not  clicked","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify Company Profile link is present in Home page",  "Company Profile link is not present in Home page","FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }

		 catch(Exception e)
		 {
			 repfn.FnUpdateTestStepResHTML("Verify Company Profile link is present in Home page and clicked", "Company Profile link is not present in Home page and not clicked due to some exception.","FAIL",runManagerInfoObj);
			 blnFlag=false;
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());

		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }
	 public synchronized boolean FnVerifyAndClickSupportLink(WebDriver driver, RunManagerInfo runManagerInfoObj){

		 try{
			 Thread.sleep(2000);			 
			 if(cnf.FnExplicitWait("XPATH", mbo.Support_Link,driver)){
				 WebElement Support_Link=driver.findElement(By.xpath(mbo.Support_Link));
				 repfn.FnUpdateTestStepResHTML("Verify Support link is present in Home page", "Support link is present in Home page","PASS",runManagerInfoObj);
				 if(cnf.JSClick(Support_Link,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify Support link is clicked", "Support link is clicked","PASS",runManagerInfoObj);
					 Thread.sleep(5000);
					 if(cnf.FnExplicitWait("XPATH", mbo.SupportPageVerification,driver)){
						 repfn.FnUpdateTestStepResHTML("Verify Logged-in User is on Support Page", "Logged-in User is on Support Page","PASS",runManagerInfoObj);
						 blnFlag=true;
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify Logged-in User is on Support Page", "Logged-in User is not on Support Page","FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify Support link is clicked", "Support link is not clicked","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify Support link is present in Home page", "Support link is not present in Home page","FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }

		 catch(Exception e)
		 {
			 repfn.FnUpdateTestStepResHTML("Verify Support link is present in Home page and clicked", "Support link is not present in Home page and not clicked due to some exception.","FAIL",runManagerInfoObj);
			 blnFlag=false;
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());

		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }
	 public synchronized boolean CompanyProfile_UI(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
	 	try
	 	{
	 		if(cnf.FnExplicitWait("XPATH", mbo.CompanyProfile_CompanyName,driver))
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if Company Name is displayed", "Company Name is displayed", "PASS",runManagerInfoObj);
	 			blnFlag=true;
	 		}
	 		else
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if Company Name is displayed", "Company Name is not displayed", "FAIL",runManagerInfoObj);
	 			blnFlag=false;

	 		}

	 		if(cnf.FnExplicitWait("XPATH", mbo.CompanyProfile_UserName,driver))
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if  User Name is displayed", "User Name is displayed", "PASS",runManagerInfoObj);
	 			blnFlag=true;
	 		}
	 		else
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if User Name is displayed", " User Name is not displayed", "FAIL",runManagerInfoObj);
	 			blnFlag=false;

	 		}

	 		if(cnf.FnExplicitWait("XPATH", mbo.CompanyProfile_AccNo,driver))
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if Account Number is displayed", "Account Number is displayed", "PASS",runManagerInfoObj);
	 			blnFlag=true;
	 		}
	 		else
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if Account Number is displayed", "Account Number is not displayed", "FAIL",runManagerInfoObj);
	 			blnFlag=false;

	 		}

	 		if(cnf.FnExplicitWait("XPATH", mbo.CompanyProfile_ServiceAddress,driver))
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if Service Address is displayed", "Service Address is displayed", "PASS",runManagerInfoObj);
	 			blnFlag=true;
	 		}
	 		else
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if Service Address is displayed", "Service Address is not displayed", "FAIL",runManagerInfoObj);
	 			blnFlag=false;

	 		}

	 		if(cnf.FnExplicitWait("XPATH", mbo.CP_SS_ServiceAddressCheckbox,driver))
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if Use Service Address checkbox is displayed", "Use Service Address checkbox is displayed", "PASS",runManagerInfoObj);
	 			blnFlag=true;
	 		}
	 		else
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if Use Service Address checkbox is displayed", "Use Service Address checkbox is not displayed", "FAIL",runManagerInfoObj);
	 			blnFlag=false;

	 		}

	 		if(cnf.FnExplicitWait("XPATH", mbo.CompanyProfile_Logo,driver))
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if company Logo is displayed", "Company Logo is displayed", "PASS",runManagerInfoObj);
	 			blnFlag=true;
	 		}
	 		else
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if Company Logo is displayed", "Company Logo is not displayed", "FAIL",runManagerInfoObj);
	 			blnFlag=false;

	 		}

	 		if(cnf.FnExplicitWait("XPATH", mbo.CompanyProfile_LogoChangeLink,driver))
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if link to Add/change Logo is displayed", "Link to Add/Change Logo is displayed", "PASS",runManagerInfoObj);
	 			blnFlag=true;
	 		}
	 		else
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if link to Add/Change Logo is displayed", "Link to Add/Change Logo is not displayed", "FAIL",runManagerInfoObj);
	 			blnFlag=false;

	 		}

	 		if(cnf.FnExplicitWait("XPATH", mbo.CompanyProfile_BillingAddress,driver))
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if Billing address is displayed", "Billing Address is displayed", "PASS",runManagerInfoObj);
	 			blnFlag=true;
	 		}
	 		else
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if Billing address is displayed", "Billing Address is not displayed", "FAIL",runManagerInfoObj);
	 			blnFlag=false;

	 		}
	 		if(cnf.FnExplicitWait("XPATH", mbo.CompanyProfile_Cancel,driver))
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if Cancel button is displayed", "Cancel button is displayed", "PASS",runManagerInfoObj);
	 			blnFlag=true;
	 		}
	 		else
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if Cancel Button is displayed", "Cancel Button is not displayed", "FAIL",runManagerInfoObj);
	 			blnFlag=false;

	 		}

	 		if(cnf.FnExplicitWait("XPATH", mbo.CompanyProfile_Save,driver))
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if save button is displayed", "Save button is displayed", "PASS",runManagerInfoObj);
	 			blnFlag=true;
	 		}
	 		else
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if Save button is displayed", "Save button is not displayed", "FAIL",runManagerInfoObj);
	 			blnFlag=false;		
	 		}

	 		driver.navigate().refresh();
	 	}
	 	catch(Exception e)
	 	{
	 		System.err.println("Message : "+e.getMessage());
	 		System.err.println("Cause : "+e.getCause());
	 		repfn.FnUpdateTestStepResHTML("Verify if UI Check for Company profile is done", "UI Check for Company profile is not done due to some exception", "FAIL",runManagerInfoObj);
	 		blnFlag=false;
	 	}

	 	m1.put("STEPSTATUS", blnFlag);
	 	return blnFlag;

	 }

	 public synchronized boolean CompanyProfile_SecuritySettings_UI(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
	 	try
	 	{
	 		if(cnf.FnExplicitWait("XPATH", mbo.CP_SS_Heading,driver))
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if title-Security Code is displayed", "Security Code Title is displayed", "PASS",runManagerInfoObj);
	 			blnFlag=true;
	 		}
	 		else
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if title-Security Code is displayed", "Security Code Title is not displayed", "FAIL",runManagerInfoObj);
	 			blnFlag=false;
	 		}

	 		if(cnf.FnExplicitWait("XPATH", mbo.SS_showCode,driver))
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if  Show Code Link is displayed", "Show Code Link is displayed", "PASS",runManagerInfoObj);
	 			blnFlag=true;
	 		}
	 		else
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if Show Code Link is displayed", " Show Code Link is not displayed", "FAIL",runManagerInfoObj);
	 			blnFlag=false;
	 		}

	 		if(cnf.FnExplicitWait("XPATH", mbo.CP_SS_NewPinLabel,driver)&& cnf.FnExplicitWait("XPATH", mbo.CP_SS_NewPinLabelRegd,driver))
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if New Pin Label with * is displayed", "New Pin Label with * is displayed", "PASS",runManagerInfoObj);
	 			blnFlag=true;
	 		}
	 		else
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if New Pin Label with * is displayed", "New Pin Label with * is not displayed", "FAIL",runManagerInfoObj);
	 			blnFlag=false;

	 		}

	 		if(cnf.FnExplicitWait("XPATH", mbo.CP_SS_RetypePinLabel,driver)&& cnf.FnExplicitWait("XPATH", mbo.CP_SS_RetypePinLabelReqd,driver))
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if Retype Pin LAbel with * is displayed", "Retype Pin Label with * is displayed", "PASS",runManagerInfoObj);
	 			blnFlag=true;
	 		}
	 		else
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if Retype Pin LAbel with * is displayed", "Retype Pin LAbel with * is not displayed", "FAIL",runManagerInfoObj);
	 			blnFlag=false;

	 		}

	 		if(cnf.FnExplicitWait("XPATH", mbo.CP_SS_Tooltip,driver))
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if Tooltip is displayed", "Tool tip is displayed", "PASS",runManagerInfoObj);
	 			blnFlag=true;
	 		}
	 		else
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if Tool tip is displayed", "Tool tip is not displayed", "FAIL",runManagerInfoObj);
	 			blnFlag=false;

	 		}

	 		if(cnf.FnExplicitWait("XPATH", mbo.SS_NewSecuritycode,driver))
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if text box to enter New pin is displayed", "text box to enter New pin is displayed", "PASS",runManagerInfoObj);
	 			blnFlag=true;
	 		}
	 		else
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if text box to enter New pin is displayed", "text box to enter New pin is not displayed", "FAIL",runManagerInfoObj);
	 			blnFlag=false;

	 		}

	 		if(cnf.FnExplicitWait("XPATH", mbo.SS_Pinconfirmation,driver))
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if text box to retype pin is displayed", "text box to retype pin is displayed", "PASS",runManagerInfoObj);
	 			blnFlag=true;
	 		}
	 		else
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if text box to retype pin is displayed", "text box to retype pin is not displayed", "FAIL",runManagerInfoObj);
	 			blnFlag=false;

	 		}


	 		if(cnf.FnExplicitWait("XPATH", mbo.SecurityProfile_Cancel,driver))
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if Cancel button is displayed", "Cancel button is displayed", "PASS",runManagerInfoObj);
	 			blnFlag=true;
	 		}
	 		else
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if Cancel Button is displayed", "Cancel Button is not displayed", "FAIL",runManagerInfoObj);
	 			blnFlag=false;

	 		}

	 		if(cnf.FnExplicitWait("XPATH", mbo.CompanyProfile_Save,driver))
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if save button is displayed", "Save button is displayed", "PASS",runManagerInfoObj);
	 			blnFlag=true;
	 		}
	 		else
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify if Save button is displayed", "Save button is not displayed", "FAIL",runManagerInfoObj);
	 			blnFlag=false;

	 		}

	 		driver.navigate().refresh();
	 	}
	 	catch(Exception e)
	 	{
	 		System.err.println("Message : "+e.getMessage());
	 		System.err.println("Cause : "+e.getCause());
	 		repfn.FnUpdateTestStepResHTML("Verify if UI check is done for Security page", "UI check is not  done for security page due to some exception", "FAIL",runManagerInfoObj);
	 		blnFlag=false;    
	 	}

	 	m1.put("STEPSTATUS", blnFlag);
	 	return blnFlag;

	 }

	
	 public synchronized boolean CP_SS_ShowCode(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
	 	try
	 	{
	 			
	 		if(cnf.FnExplicitWait("XPATH", mbo.SS_showCode,driver))
	 		{
	 			WebElement Showcode=driver.findElement(By.xpath(mbo.SS_showCode));
	 			System.out.println("show code displayed");
	 			repfn.FnUpdateTestStepResHTML("Verify if Show Code Link is displayed", "Show Code link is displayed", "PASS",runManagerInfoObj);
	 			Thread.sleep(1000);
	 			if(cnf.JSClick(Showcode,driver)){
	 				repfn.FnUpdateTestStepResHTML("Verify Click on the Show Code Link", "Show code Link is clicked", "PASS",runManagerInfoObj);
	 				if(cnf.FnExplicitWait("XPATH", mbo.SS_HideCode,driver))
	 				{				
	 					WebElement HideCode=driver.findElement(By.xpath(mbo.SS_HideCode));
	 					repfn.FnUpdateTestStepResHTML("Verify if Hide Code link is displayed", "Hide Code link is displayed", "PASS",runManagerInfoObj);
	 					if(cnf.JSClick(HideCode,driver))
	 					{
	 						repfn.FnUpdateTestStepResHTML("Click on the Hide Code Link", "Hide code Link is clicked", "PASS",runManagerInfoObj);
	 						if(cnf.FnExplicitWait("XPATH", mbo.SS_showCode,driver))
	 						{
	 							repfn.FnUpdateTestStepResHTML("Verify if Show Code link is displayed again", "Show Code link is displayed again", "PASS",runManagerInfoObj);
	 							blnFlag=true;
	 						}
	 						else
	 						{
	 							repfn.FnUpdateTestStepResHTML("Verify if Show Code link is displayed again", "Show Code link is not displayed again", "FAIL",runManagerInfoObj);
	 							blnFlag=false;	
	 						}							
	 					}
	 					else
	 					{
	 						repfn.FnUpdateTestStepResHTML("Verify Click on the Hide Code Link", "Hide code Link is not clickable", "FAIL",runManagerInfoObj);
	 						blnFlag=false;
	 					}				
	 				}
	 				else
	 				{
	 					repfn.FnUpdateTestStepResHTML("Verify if Hide Code link is displayed", "Hide Code link is not displayed", "FAIL",runManagerInfoObj);
	 					blnFlag=false;
	 				}
	 			}
	 			else{
	 				repfn.FnUpdateTestStepResHTML("Verify Click on the Show Code Link", "Show code Link is not clicked", "FAIL",runManagerInfoObj);
	 				blnFlag=false;			
	 			}		
	 		}
	 		else
	 		{
	 			System.out.println("changes not saved");
	 			repfn.FnUpdateTestStepResHTML("Verify if Show Code Link is displayed", "Show Code link is not displayed", "FAIL",runManagerInfoObj);
	 			blnFlag=false;		
	 		}
	 		
	 	}
	 	catch(Exception e)
	 	{
	 		System.err.println("Message : "+e.getMessage());
	         System.err.println("Cause : "+e.getCause());
	         repfn.FnUpdateTestStepResHTML("Verify if Show/Hide Code link is displayed", "Show/Hide Code link is not displayed due to some exception", "FAIL",runManagerInfoObj);
	 		blnFlag=false;
	 	}
	 	 m1.put("STEPSTATUS", blnFlag);
	      return blnFlag;
	 }
	 public synchronized boolean FN_Edit_ServiceAddresschecked(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 boolean blnFlag1 = FnCompanyProfile_UseServiceAddress(driver,runManagerInfoObj);
			 if(blnFlag1){
				 boolean blnFlag2 = CP_EditableBillingaddress(driver,runManagerInfoObj);			 
				 if(blnFlag2){
					 repfn.FnUpdateTestStepResHTML("Verify if the Service Address is auto-populated on the billing address field on selecting the \"Use Service Address\" check box ", 
							 "Service Address is auto-populated on the billing address field on selecting the \"Use Service Address\" check box ", "PASS",runManagerInfoObj);
					 blnFlag = true;
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if the Service Address is auto-populated on the billing address field on selecting the \"Use Service Address\" check box ", 
							 "Service Address is not auto-populated on the billing address field on selecting the \"Use Service Address\" check box ", "FAIL",runManagerInfoObj);
					 blnFlag = false;
				 }
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify if User Service Address checkbox is present and checked", "User Service Address checkbox is not present and checked", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
			 repfn.FnUpdateTestStepResHTML("Verify if the Service Address is auto-populated on the billing address field on selecting the \"Use Service Address\" check box ", 
					 "Service Address is not auto-populated on the billing address field on selecting the \"Use Service Address\" check box due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag = false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }
	 public synchronized boolean EditstreetLine2(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 String Street=m1.get("Street2").toString();

			 if(cnf.FnExplicitWait("XPATH", mbo.CompanyProfile_StreetAddress3_editable,driver))
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if Street Address Line 2 input field is displayed", "Street Address Line 2 input field is displayed", "PASS",runManagerInfoObj);
				 WebElement Editstreet=driver.findElement(By.xpath(mbo.CompanyProfile_StreetAddress3_editable));
				 Editstreet.clear();
				 Editstreet.sendKeys(Street);
				 repfn.FnUpdateTestStepResHTML("Verify if Street Address Line 2 can be edited", "Street Address Line 2 can be edited. Street Address added: "+Street, "PASS",runManagerInfoObj);
				 blnFlag=true; 
			 }
			 else
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if Street Address Line 2 input field is displayed", "Street Address Line 2 input field is not displayed", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());	
			 repfn.FnUpdateTestStepResHTML("Verify if Street Address Line 2 can be edited", "Street Address Line 2 cannot be edited due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;

	 }
	 public synchronized boolean EditSaveBillingaddress(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {

			 boolean blnFlag1 = Uncheck_ServiceAddress(driver,runManagerInfoObj);
			 if(blnFlag1){
				 boolean blnFlag2 = EditstreetLine1(driver,runManagerInfoObj);
				 boolean blnFlag3 = EditstreetLine2(driver,runManagerInfoObj);
				 boolean blnFlag4 = EditstreetLine3(driver,runManagerInfoObj);
				 boolean blnFlag5 = EditCity(driver,runManagerInfoObj); 
				 boolean blnFlag6 = CompanyProfile_Save(driver,runManagerInfoObj);
				 Thread.sleep(1000);
				 
				 if(blnFlag2 && blnFlag3 && blnFlag4 && blnFlag5 && blnFlag6){
					 repfn.FnUpdateTestStepResHTML("Verify if the user is able to save the changes made in the billing address data fields", 
							 "User is able to save the changes made in the billing address data fields", "PASS",runManagerInfoObj);
					 blnFlag = true;
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if the user is able to save the changes made in the billing address data fields", 
							 "User is not able to save the changes made in the billing address data fields", "FAIL",runManagerInfoObj);
					 blnFlag = false;
				 }	
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify if User Service Address checkbox is present ", "User Service Address checkbox is not present", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }		 
		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
			 repfn.FnUpdateTestStepResHTML("Verify if the user is able to save the changes made in the billing address data fields", 
					 "User is not able to save the changes made in the billing address data fields due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag = false;
		 }

		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }

	 public synchronized boolean EditBillingAddress(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 boolean blnFlag1 = Uncheck_ServiceAddress(driver,runManagerInfoObj);
			 if(blnFlag1){
				 boolean blnFlag2 = EditstreetLine2(driver,runManagerInfoObj);
				 boolean blnFlag3 = EditCity(driver,runManagerInfoObj); 
				 boolean blnFlag4 = CompanyProfile_Cancel(driver,runManagerInfoObj);
				 Thread.sleep(1000);
				 
				 if(blnFlag2 && blnFlag3 && blnFlag4){
					 repfn.FnUpdateTestStepResHTML("Verify if the user is able to cancel the changes made in the billing address data fields", 
							 "User is able to cancel the changes made in the billing address data fields", "PASS",runManagerInfoObj);
					 blnFlag = true;
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if the user is able to cancel the changes made in the billing address data fields", 
							 "User is not able to cancel the changes made in the billing address data fields", "FAIL",runManagerInfoObj);
					 blnFlag = false;
				 }	
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify if User Service Address checkbox is present ", "User Service Address checkbox is not present", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }

		 
		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
			 repfn.FnUpdateTestStepResHTML("Verify if the user is able to cancel the changes made in the billing address data fields", 
					 "User is not able to cancel the changes made in the billing address data fields due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag = false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }
	 public synchronized boolean Uncheck_ServiceAddress(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 if(cnf.FnExplicitWait("XPATH", mbo.CompanyProfile_ServiceAddresscheckbox,driver)){
				 repfn.FnUpdateTestStepResHTML("Verify if User Service Address checkbox is present ", "User Service Address checkbox is present", "PASS",runManagerInfoObj);
				 WebElement CompanyProfile_ServiceAddress=driver.findElement(By.xpath(mbo.CompanyProfile_ServiceAddresscheckbox));
				 
				 if(cnf.isElementExistOne("XPATH", mbo.CompanyProfile_ServiceAddresscheckbox_Selection,driver)){
					 WebElement CompanyProfile_ServiceAddresscheckbox_Selection=driver.findElement(By.xpath(mbo.CompanyProfile_ServiceAddresscheckbox_Selection));
					 String selectionState = CompanyProfile_ServiceAddresscheckbox_Selection.getAttribute("aria-checked");
					 if(selectionState.equalsIgnoreCase("true")){
						 System.out.println("Use Service Address checkbox selected");
						 repfn.FnUpdateTestStepResHTML("Verify if User Service Address checkbox is present and already checked", "User Service Address checkbox is present and already checked", "PASS",runManagerInfoObj);
						 if(cnf.JSClick(CompanyProfile_ServiceAddress,driver)){
							 repfn.FnUpdateTestStepResHTML("Verify if User Service Address checkbox is un-checked", "User Service Address checkbox is un-checked", "PASS",runManagerInfoObj);
							 System.out.println("Checkbox checked");
							 blnFlag=true;						 
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify if User Service Address checkbox is un-checked", "User Service Address checkbox is not un-checked", "FAIL",runManagerInfoObj);							 
							 blnFlag=false;
						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify if User Service Address checkbox is un-checked", "User Service Address checkbox is un-checked", "PASS",runManagerInfoObj);
						 blnFlag=true;
					 }
				 }
				 else{
					 blnFlag=false;
				 }
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify if User Service Address checkbox is present ", "User Service Address checkbox is not  present", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }

		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
			 repfn.FnUpdateTestStepResHTML("Verify if User Service Address checkbox is checked", "User Service Address checkbox is not checked due to some exception", "FAIL",runManagerInfoObj);			 
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;

	 }

	 public synchronized boolean EditstreetLine1(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 String Street=m1.get("Street").toString();	
			
			 if(cnf.FnExplicitWait("XPATH", mbo.CompanyProfile_StreetAddress2,driver))
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if Street Address Line 1 input field is displayed", " Street Address Line 1 input field is displayed", "PASS",runManagerInfoObj);
				 WebElement Editstreet1=driver.findElement(By.xpath(mbo.CompanyProfile_StreetAddress2));
				 Editstreet1.clear();
				 Editstreet1.sendKeys(Street);
				 repfn.FnUpdateTestStepResHTML("Verify if Street Address Line 1 can be edited", "Street Address Line 1 can be edited. Street1 added: " +Street, "PASS",runManagerInfoObj);
				 blnFlag=true;
			 }
			 else
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if Street Address Line 1 input field is displayed", " Street Address Line 1 input field is not displayed", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());	
			 repfn.FnUpdateTestStepResHTML("Verify if Street Address Line 1 can be edited", "Street Address Line 1 cannot be edited due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;

	 }


	 //To edit Street address line 2//

	
	 //To edit street address line 3//

	 public synchronized boolean EditstreetLine3(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 String Street=m1.get("Street3").toString();	
						 
			 if(cnf.FnExplicitWait("XPATH", mbo.CompanyProfile_StreetAddress4_Editable,driver))
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if Street Address Line 3 input field is displayed", "Street Address Line 3 input field is displayed", "PASS",runManagerInfoObj);
				 WebElement Editstreet=driver.findElement(By.xpath(mbo.CompanyProfile_StreetAddress4_Editable));
				 Editstreet.clear();
				 Editstreet.sendKeys(Street);
				 repfn.FnUpdateTestStepResHTML("Verify if Street Address Line 3 can be edited", "Street Address Line 3 can be edited. Street3 added: "+Street, "PASS",runManagerInfoObj);
				 blnFlag=true;
			 }
			 else
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if Street Address Line 3 input field is displayed", "Street Address Line 3 input field is not displayed", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());	
			 repfn.FnUpdateTestStepResHTML("Verify if Street Address Line 3 can be edited", "Street Address Line 3 cannot be edited due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;

	 }

	 public synchronized boolean EditCity(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 String city=m1.get("City").toString();	

			 Thread.sleep(1000);
			 if(cnf.FnExplicitWait("XPATH", mbo.CompanyProfile_City_Editable,driver))
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if City input field is displayed", "City input field is displayed", "PASS",runManagerInfoObj);
				 WebElement Editcity=driver.findElement(By.xpath(mbo.CompanyProfile_City_Editable));
				 Editcity.clear();
				 Editcity.sendKeys(city);
				 repfn.FnUpdateTestStepResHTML("Verify if City can be edited", "City can be edited. City added: "+city, "PASS",runManagerInfoObj);
				 blnFlag=true;
			 }
			 else
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if City input field is displayed", "City input field is not displayed", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());	
			 repfn.FnUpdateTestStepResHTML("Verify if City can be edited", "City cannot be edited due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;

	 }


	 public synchronized boolean CompanyProfile_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 if(cnf.FnExplicitWait("XPATH", mbo.CompanyProfile_Cancel,driver))
			 {
				 WebElement Cancel=driver.findElement(By.xpath(mbo.CompanyProfile_Cancel));
				 System.out.println("Cancel displayed");
				 repfn.FnUpdateTestStepResHTML("Verify if Cancel button is present", "Cancel button is present", "PASS",runManagerInfoObj);
				 Thread.sleep(2000);
				 if(cnf.JSClick(Cancel,driver)){
					 Thread.sleep(1000);
					 repfn.FnUpdateTestStepResHTML("Verify if the Cancel button is clicked", "Cancel button is clicked", "PASS",runManagerInfoObj);
					 
					 String Street=m1.get("Street2").toString();
					 if(cnf.FnExplicitWait("XPATH", mbo.CompanyProfile_StreetAddress3_editable,driver))
					 {
						 WebElement CompanyProfile_StreetAddress3_editable=driver.findElement(By.xpath(mbo.CompanyProfile_StreetAddress3_editable));
						 if(CompanyProfile_StreetAddress3_editable.getAttribute("value").contains(Street)){
							 repfn.FnUpdateTestStepResHTML("Verify if the Changes made are cancelled", "Changes made are not cancelled", "FAIL",runManagerInfoObj);
							 blnFlag=false; 
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify if the Changes made are cancelled", "Changes made are cancelled", "PASS",runManagerInfoObj);
							 blnFlag=true;
						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify if Address Street 2 is displayed", "Address Street 2 is not displayed", "FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if the Cancel button is clicked", "Cancel button is not clicked", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }


				 if(cnf.FnExplicitWait("XPATH", mbo.CompanyProfile_ServiceAddresscheckbox,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify if User Service Address checkbox is present ", "User Service Address checkbox is present", "PASS",runManagerInfoObj);
					 WebElement CompanyProfile_ServiceAddress=driver.findElement(By.xpath(mbo.CompanyProfile_ServiceAddresscheckbox));
					 if(CompanyProfile_ServiceAddress.isSelected() || CompanyProfile_ServiceAddress.isEnabled()){
						 System.out.println("Use Service Address checkbox selected");
						 repfn.FnUpdateTestStepResHTML("Verify if the changes made are cancelled", "Changes made are cancelled", "PASS",runManagerInfoObj);
						 //cnf.JSClick(CompanyProfile_ServiceAddress);
						 blnFlag=true;
					 }
					 else
					 {
						 repfn.FnUpdateTestStepResHTML("Verify if the changes made are cancelled", "Changes made are not cancelled", "FAIL",runManagerInfoObj);
						 //cnf.JSClick(CompanyProfile_ServiceAddress);
						 blnFlag=false; 
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if User Service Address checkbox is present ", "User Service Address checkbox is not present", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 else
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if Cancel button is present", "Cancel button is not present", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());	
			 repfn.FnUpdateTestStepResHTML("Verify if Cancel button is present", "Cancel button is not present due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;

	 }
	 public synchronized boolean FnCompanyProfile_UseServiceAddress(WebDriver driver, RunManagerInfo runManagerInfoObj){
		 try{

			 if(cnf.FnExplicitWait("XPATH", mbo.CompanyProfile_ServiceAddresscheckbox,driver)){
				 repfn.FnUpdateTestStepResHTML("Verify if User Service Address checkbox is present ", "User Service Address checkbox is present", "PASS",runManagerInfoObj);
				 WebElement CompanyProfile_ServiceAddress=driver.findElement(By.xpath(mbo.CompanyProfile_ServiceAddresscheckbox));
				 //System.out.println(CompanyProfile_ServiceAddress.isSelected());
				 
				 if(cnf.isElementExistOne("XPATH", mbo.CompanyProfile_ServiceAddresscheckbox_Selection,driver)){
					 WebElement CompanyProfile_ServiceAddresscheckbox_Selection=driver.findElement(By.xpath(mbo.CompanyProfile_ServiceAddresscheckbox_Selection));
					 String selectionState = CompanyProfile_ServiceAddresscheckbox_Selection.getAttribute("aria-checked");
					 if(selectionState.equalsIgnoreCase("true")){
						 System.out.println("Use Service Address checkbox selected");
						 repfn.FnUpdateTestStepResHTML("Verify if User Service Address checkbox is present and already checked", "User Service Address checkbox is present and already checked", "PASS",runManagerInfoObj);
						 blnFlag=true;
					 }
					 else{
						 System.out.println("checkbox is not selected");
						 repfn.FnUpdateTestStepResHTML("Verify if User Service Address checkbox is present and already checked", "User Service Address checkbox is present but not checked", "PASS",runManagerInfoObj);
						 if(cnf.JSClick(CompanyProfile_ServiceAddress,driver)){
							 repfn.FnUpdateTestStepResHTML("Verify if User Service Address checkbox is checked", "User Service Address checkbox is checked", "PASS",runManagerInfoObj);
							 System.out.println("Checkbox checked");
							 blnFlag=true;					 
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify if User Service Address checkbox is checked", "User Service Address checkbox is not  checked", "FAIL",runManagerInfoObj);
							 blnFlag=false;
						 }	
					 }
				 }
				 else{
					 blnFlag=false;
				 }
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify if User Service Address checkbox is present ", "User Service Address checkbox is not  present ", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }

		 catch (Exception e)

		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
			 repfn.FnUpdateTestStepResHTML("Verify if User Service Address checkbox is present ", "User Service Address checkbox is not present due to some exception ", "FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);;
		 return blnFlag;
	 }
	 public synchronized boolean CP_EditableBillingaddress(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			
			 if( cnf.FnExplicitWait("XPATH", mbo.CompanyProfile_StreetAddress1,driver))
			 {
				 System.out.println("Street address label displayed");
				 repfn.FnUpdateTestStepResHTML("Verify if Street Address label is displayed", "Street Address Label is displayed", "PASS",runManagerInfoObj);
				 blnFlag=true;
			 }
			 else
			 {
				 System.out.println("Street address label not displayed");
				 repfn.FnUpdateTestStepResHTML("Verify if Street Address label is displayed", "Street Address Label is not displayed", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }

			 			
			 if(cnf.FnExplicitWait("XPATH", mbo.CompanyProfile_StreetAddress2,driver))
			 {
				 WebElement StreetAddressLabel1=driver.findElement(By.xpath(mbo.CompanyProfile_StreetAddress2));
				 System.out.println("Street address1 displayed");
				 repfn.FnUpdateTestStepResHTML("Verify if Street Address line 1 is displayed", "Street Address Line 1 is displayed", "PASS",runManagerInfoObj);
				 Thread.sleep(1000);
				 if(cnf.JSClick(StreetAddressLabel1,driver)){
					 System.out.println("Street line1 clicked");
					 repfn.FnUpdateTestStepResHTML("Verify if Street Address Line 1 is editable", "Street Address Line 1 is editable", "PASS",runManagerInfoObj);
					 blnFlag=true;
				 }
				 else{					
					 repfn.FnUpdateTestStepResHTML("Verify if Street Address Line 1 is editable", "Street Address Line 1 is not editable", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 else
			 {
				 System.out.println("Street address Line 1 is not displayed");
				 repfn.FnUpdateTestStepResHTML("Verify if Street Address line 1 is displayed", "Street Address Line 1 is not displayed", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }

			
			 if(cnf.FnExplicitWait("XPATH", mbo.CompanyProfile_StreetAddress3_Noneditable,driver))
			 {
				 System.out.println("Street address2 displayed");
				 repfn.FnUpdateTestStepResHTML("Verify if Street Address line 2 is displayed and non editable", "Street Address Line 2 is displayed and non editable", "PASS",runManagerInfoObj);
				 blnFlag=true;
			 }
			 else
			 {
				 System.out.println("Street address Line 2 is not displayed");
				 repfn.FnUpdateTestStepResHTML("Verify if Street Address line 2 is displayed", "Street Address Line 2 is not displayed", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }

			
			 if(cnf.FnExplicitWait("XPATH", mbo.CompanyProfile_StreetAddress4_NonEditable,driver))
			 {
				 System.out.println("Street address3 displayed");
				 repfn.FnUpdateTestStepResHTML("Verify if Street Address line 3 is displayed and non editable", "Street Address Line 3 is displayed and non editable", "PASS",runManagerInfoObj);
				 blnFlag=true;
			 }
			 else
			 {
				 System.out.println("Street address Line 3 is not displayed");
				 repfn.FnUpdateTestStepResHTML("Verify if Street Address line 3 is displayed", "Street Address Line 3 is not displayed", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		
			 if(cnf.FnExplicitWait("XPATH", mbo.CompanyProfile_State_NonEditable,driver))
			 {
				 System.out.println("State displayed");
				 repfn.FnUpdateTestStepResHTML("Verify if State is displayed and non editable", "State is displayed and non editable", "PASS",runManagerInfoObj);
				 blnFlag=true;
			 }
			 else
			 {
				 System.out.println("State is not displayed");
				 repfn.FnUpdateTestStepResHTML("Verify if State is displayed", "State is not displayed", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
			 
			 
			 if(cnf.FnExplicitWait("XPATH", mbo.CompanyProfile_ZipCode_NonEditable,driver))
			 {
				 System.out.println("Zip displayed");
				 repfn.FnUpdateTestStepResHTML("Verify if Zip code is displayed and non editable", "Zip Code is displayed and non editable", "PASS",runManagerInfoObj);
				 blnFlag=true;
			 }
			 else
			 {
				 System.out.println("Zip is not displayed");
				 repfn.FnUpdateTestStepResHTML("Verify if Zip code is displayed", "Zip Code is not displayed", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }

			
			 if(cnf.FnExplicitWait("XPATH", mbo.CompanyProfile_City_NonEditable,driver))
			 {
				 System.out.println("City displayed");
				 repfn.FnUpdateTestStepResHTML("Verify if City is displayed and non editable", "City is displayed and non editable", "PASS",runManagerInfoObj);
				 blnFlag=true;
			 }
			 else
			 {
				 System.out.println("City is not displayed");
				 repfn.FnUpdateTestStepResHTML("Verify if City is displayed", "City is not displayed", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }

			 driver.navigate().refresh();
		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
			 repfn.FnUpdateTestStepResHTML("Verify if User is able to verify Address fields on Company Profile page", "User is not able to verify Address fields on Company Profile page due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }

		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;

	 }
	 public synchronized boolean MyProfile_EditAndSave(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 boolean blnFlag1 = EditFirstName(driver,runManagerInfoObj);
			 boolean blnFlag2 = EditLastName(driver,runManagerInfoObj);
			 boolean blnFlag3 = EditPhoneNumber(driver,runManagerInfoObj);
			 boolean blnFlag4 = EditEmailid(driver,runManagerInfoObj);
			 if(blnFlag1 && blnFlag2 && blnFlag3 && blnFlag4){
				 boolean blnFlag5 = MyProfile_Save(driver,runManagerInfoObj);
				 if(blnFlag5){
					 boolean blnFlag6 = MyProfile_VerifySave(driver,runManagerInfoObj);
					 if(blnFlag6){
						 repfn.FnUpdateTestStepResHTML("Verify if Profile Editing Changes are saved", "Profile Editing Changes are saved", "PASS",runManagerInfoObj);
						 blnFlag=true;
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify if Profile Editing Changes are saved", "Profile Editing Changes are not saved", "FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if Profile Update Success Message is displayed", "Profile Update Success Message is not displayed", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify if User Details are edited", "User Details are not edited", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
			 repfn.FnUpdateTestStepResHTML("Verify if User is able to edit profile and save", "User is not able to edit profile and save due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }
	 public synchronized boolean EditFirstName(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 String FirstName=m1.get("FirstName").toString();				 
			 if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_FirstName,driver))
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if First Name input field is displayed", "First Name input field is displayed", "PASS",runManagerInfoObj);
				 WebElement Name=driver.findElement(By.xpath(mbo.MyProfile_FirstName));
				 Name.clear();
				 Name.sendKeys(FirstName);
				 repfn.FnUpdateTestStepResHTML("Verify if First Name can be edited", "First Name can be edited: "+FirstName, "PASS",runManagerInfoObj);
				 blnFlag=true;
			 }
			 else
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if First Name input field is displayed", "First Name input field is not displayed", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());	
			 repfn.FnUpdateTestStepResHTML("Verify if First Name can be edited", "First Name cannot be edited due to exception ", "FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }


	 //To edit Last Name in My Profile page//


	 public synchronized boolean EditLastName(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 String LastName=m1.get("LastName").toString();			
			 if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_LastName,driver))
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if Last Name input field is displayed", "Last Name input field is displayed", "PASS",runManagerInfoObj);
				 WebElement Name=driver.findElement(By.xpath(mbo.MyProfile_LastName));
				 Name.clear();
				 Name.sendKeys(LastName);
				 repfn.FnUpdateTestStepResHTML("Verify if Last Name can be edited", "Last Name can be edited: "+LastName, "PASS",runManagerInfoObj);
				 blnFlag=true;
			 }
			 else
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if Last Name input field is displayed", "Last Name input field is not displayed", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());	
			 repfn.FnUpdateTestStepResHTML("Verify if Last Name can be edited", "Last Name cannot be edited due to some exception ", "FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;

	 }


	 //to edit Phone Number in My Profile page//



	 public synchronized boolean EditPhoneNumber(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 String Phone=m1.get("Phone").toString();			 
			 if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_PhoneNumber,driver))
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if Phone Number input field is displayed", "Phone Number input field is displayed", "PASS",runManagerInfoObj); 
				 WebElement Number=driver.findElement(By.xpath(mbo.MyProfile_PhoneNumber));
				 Number.clear();
				 Number.sendKeys(Phone);
				 repfn.FnUpdateTestStepResHTML("Verify if Phone Number can be edited", "Phone Number can be edited: "+Phone, "PASS",runManagerInfoObj);
				 blnFlag=true;
			 }
			 else
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if Phone Number input field is displayed", "Phone Number input field is not displayed", "FAIL",runManagerInfoObj); 
				 blnFlag=false;
			 }
		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
			 repfn.FnUpdateTestStepResHTML("Verify if Phone Number can be edited", "Phone Number cannot be edited due to some exception ", "FAIL",runManagerInfoObj);
			 blnFlag=false;
			 
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;

	 }

	 // To edit Email in My Profile page//

	 public synchronized boolean EditEmailid(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 String Emailaddress=m1.get("Email").toString();		 
			 if( cnf.FnExplicitWait("XPATH", mbo.MyProfile_Email,driver))
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if Email Address input field is displayed", "Email Address input field is displayed", "PASS",runManagerInfoObj); 
				 WebElement Email=driver.findElement(By.xpath(mbo.MyProfile_Email));
				 Email.clear();
				if(cnf.JSClick(Email, driver)){
				 Email.sendKeys(Emailaddress);
				 repfn.FnUpdateTestStepResHTML("Verify if Email id can be edited", "Email id can be edited: "+Emailaddress, "PASS",runManagerInfoObj);
				 
				 blnFlag=true;
				}else{
					 repfn.FnUpdateTestStepResHTML("Verify if Email id can be edited", "Email id can not be edited: "+Emailaddress, "FAIL",runManagerInfoObj);
					 
					 blnFlag=false;
				}
			 }
			 else
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if Email Address input field is displayed", "Email Address input field is not displayed", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
			 repfn.FnUpdateTestStepResHTML("Verify if email id can be edited", "Email id cannot be edited: ", "FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;

	 }
	 public synchronized boolean MyProfile_Save(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {		
			 if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_Save,driver))
			 {
				 System.out.println("Save displayed");
				 WebElement Save=driver.findElement(By.xpath(mbo.MyProfile_Save));
				 repfn.FnUpdateTestStepResHTML("Verify if Save button is present", "Save button is present", "PASS",runManagerInfoObj);
				 Thread.sleep(5000);
				 if(Save.isEnabled())
				 {
					 System.out.println("Save enabled");
					 repfn.FnUpdateTestStepResHTML("Verify if Save button is enabled", "Save button is enabled", "PASS",runManagerInfoObj);
					
					 if(cnf.JSClick(Save,driver)){
						 Thread.sleep(5000);
						 System.out.println("Save clicked");
						 repfn.FnUpdateTestStepResHTML("Verify if Save button is clicked", "Save button is clicked", "PASS",runManagerInfoObj);						 
						 if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_SaveSuccess,driver))
						 {
							 repfn.FnUpdateTestStepResHTML("Verify if Success Message is displayed", " \'Profile Updated Successfully\' message is displayed", "PASS",runManagerInfoObj);
							 blnFlag=true;
						 }
						 else
						 {
							 repfn.FnUpdateTestStepResHTML("Verify if Success Message is displayed", "Success message is not displayed", "FAIL",runManagerInfoObj);
							 blnFlag=false;	
						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify if Save button is clicked", "Save button is not clicked", "FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
				 else 
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if Save button is enabled", "Save button is not enabled", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 else
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if Save button is present", "Save button is not present", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());	
			 repfn.FnUpdateTestStepResHTML("Verify if Success Message is displayed", "Success message is not displayed due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag=false;	
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;

	 }
	 public synchronized boolean MyProfile_VerifySave(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 String Name=m1.get("FirstName").toString();	

			 if(cnf.FnExplicitWait("XPATH",mbo.MyProfile_FirstName,driver)){
				 repfn.FnUpdateTestStepResHTML("Verify First Name Textbox is present", "First Name Textbox is present", "PASS",runManagerInfoObj);
				 WebElement FName=driver.findElement(By.xpath(mbo.MyProfile_FirstName));
				 System.out.println("first name"+Name);
				 if(FName.getAttribute("value").contains(Name))
				 {
					 System.out.println("changes saved");
					 repfn.FnUpdateTestStepResHTML("Verify if the changes made are saved", "Changes made are saved", "PASS",runManagerInfoObj);
					 blnFlag=true;
				 }
				 else
				 {
					 System.out.println("changes not saved");
					 repfn.FnUpdateTestStepResHTML("Verify if the changes made are saved", "Changes made are not saved", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify First Name Textbox is present", "First Name Textbox is not present", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
			 repfn.FnUpdateTestStepResHTML("Verify if Profile Editing Changes are saved", "Profile Editing Changes are not saved due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }
	 public synchronized boolean MyProfile_Mandatory(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 boolean blnFlag1 = MyProfile_Error_FName(driver,runManagerInfoObj);
			 boolean blnFlag2 = MyProfile_Error_LName(driver,runManagerInfoObj);
			 boolean blnFlag3 = MyProfile_Error_Email(driver,runManagerInfoObj);
			 if(blnFlag1 && blnFlag2 && blnFlag3){
				 repfn.FnUpdateTestStepResHTML("Verify if Error message is displayed on entering blank values in First Name, Last Name and Email input fields", 
						 "Error message is displayed on entering blank values in First Name, Last Name and Email input fields", "PASS",runManagerInfoObj);
				 boolean blnFlag4 = MyProfile_EditAndSave(driver,runManagerInfoObj);
				 if(blnFlag4){
					 repfn.FnUpdateTestStepResHTML("Verify if Profile Editing Changes are saved", "Profile Editing Changes are saved", "PASS",runManagerInfoObj);
					 blnFlag=true;
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if Profile Editing Changes are saved", "Profile Editing Changes are not saved", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify if Error message is displayed on entering blank values in First Name, Last Name and Email input fields", 
						 "Error message is not displayed on entering blank values in First Name, Last Name and Email input fields", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }

		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());	
			 repfn.FnUpdateTestStepResHTML("Verify if Error message is displayed on entering blank values in First Name, Last Name and Email input fields", 
					 "Error message is not displayed on entering blank values in First Name, Last Name and Email input fields due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }
	 public synchronized boolean MyProfile_Error_FName(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 //String Code=m1.get("FirstName").toString();			 
			 if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_FirstName,driver))
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if First Name field is displayed", "First Name field is displayed", "PASS",runManagerInfoObj);
				 WebElement Name=driver.findElement(By.xpath(mbo.MyProfile_FirstName));
				 Name.clear();
				 if(cnf.JSClick(Name, driver)){
				 Name.sendKeys("");
				 repfn.FnUpdateTestStepResHTML("Verify if First Name field is left Empty", "First Name field is left empty", "PASS",runManagerInfoObj);
				blnFlag=true;
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if First Name field is left Empty", "First Name field is not left empty", "FAIL",runManagerInfoObj);
						blnFlag=false;
				 }
				 if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_fnnameerror,driver))
				 {
					 WebElement Error=driver.findElement(By.xpath(mbo.MyProfile_fnnameerror));
					 repfn.FnUpdateTestStepResHTML("Verify if Error message is displayed", "Error message is displayed: "+Error.getAttribute("textContent"), "PASS",runManagerInfoObj);
					 blnFlag=true;
				 }
				 else
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if Error message is displayed", "Error Message is not displayed", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 else
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if First Name field is displayed", "First Name field is not displayed", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }
		 catch(Exception e)
		 {
			 repfn.FnUpdateTestStepResHTML("Verify if Invalid First Name error is displayed", "Invalid First Name error is not displayed due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag=false;	
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }

	 public synchronized boolean MyProfile_Error_LName(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 //String LName=m1.get("LastName").toString();
			
			 if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_LastName,driver))
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if Last Name field is displayed", "Last Name field is displayed", "PASS",runManagerInfoObj);
				 WebElement LastName=driver.findElement(By.xpath(mbo.MyProfile_LastName));
				 LastName.clear();
				 if(cnf.JSClick(LastName, driver)){
				 LastName.sendKeys("");
				 repfn.FnUpdateTestStepResHTML("Verify if Last Name field is left Empty", "Last Name field is left empty", "PASS",runManagerInfoObj);
				 blnFlag=true;
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if Last Name field is left Empty", "Last Name field is not left empty", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
				 
				 if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_lnameerror,driver))
				 {
					 WebElement Error=driver.findElement(By.xpath(mbo.MyProfile_lnameerror));
						 repfn.FnUpdateTestStepResHTML("Verify if Error message is displayed", "Error message is displayed: "+Error.getAttribute("textContent"), "PASS",runManagerInfoObj);
						 blnFlag=true;

				 }
				 else
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if Error message is displayed", "Error Message is not displayed", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 else
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if Last Name field is displayed", "Last Name field is not displayed", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }
		 catch(Exception e)
		 {
			 repfn.FnUpdateTestStepResHTML("Verify if Invalid Last Name error is displayed", "Invalid Last Name error is not displayed due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag=false;	
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }

	 public synchronized boolean MyProfile_Error_Email(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 //String LName=m1.get("NewEmail").toString();			 
			 if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_Email,driver))
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if Email id field is displayed", "Email id field is displayed", "PASS",runManagerInfoObj);
				 WebElement EmailId=driver.findElement(By.xpath(mbo.MyProfile_Email));
				 EmailId.clear();
				 if(cnf.JSClick(EmailId, driver)){
				 EmailId.sendKeys("");
				 repfn.FnUpdateTestStepResHTML("Verify if Email id field is left Empty", "Email id field is left empty", "PASS",runManagerInfoObj);
				 blnFlag=true;
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if Email id field is left Empty", "Email id field is not empty", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
				 if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_emailerror,driver))
				 {
					 WebElement Error=driver.findElement(By.xpath(mbo.MyProfile_emailerror));
					 repfn.FnUpdateTestStepResHTML("Verify if Error message is displayed", "Error message is displayed: "+Error.getAttribute("textContent"), "PASS",runManagerInfoObj);
					 blnFlag=true;

				 }
				 else
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if Error message is displayed", "Error Message is not displayed", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 else
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if email id field is displayed", "Email id field is not displayed", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }
		 catch(Exception e)
		 {
			 repfn.FnUpdateTestStepResHTML("Verify if Invalid Email error is displayed", "Invalid Email error is not displayed due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag=false;	
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }
	
	 public synchronized boolean SecuritySettings_Usernameerror(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
				 String Password= m1.get("AppUser").toString();
				 if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_SS_Password,driver))
				 {
					 WebElement NewPassword=driver.findElement(By.xpath(mbo.MyProfile_SS_Password));
					 if(cnf.JSClick(NewPassword, driver))
					 {
					 NewPassword.sendKeys(Password);
					 repfn.FnUpdateTestStepResHTML("Verify if Password can be entered in the New Password field", "Password can be entered in the New Password field: " +Password, "PASS",runManagerInfoObj);
					blnFlag=true;
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify if Password can be entered in the New Password field", "Password can be entered in the New Password field: " +Password, "PASS",runManagerInfoObj);
							blnFlag=false;
					 }
					 if(cnf.FnExplicitWait("XPATH", mbo.PasswordsameUserid,driver))
					 {
						 repfn.FnUpdateTestStepResHTML("Verify if the following error message is displayed: Cannot be a case insensitive match with Username", "\'Cannot be a case insensitive match with Username\' error is displayed", "PASS",runManagerInfoObj);
						 blnFlag=true;
					 }
					 else
					 {
						 repfn.FnUpdateTestStepResHTML("Verify if the following error message is displayed: Cannot be a case insensitive match with Username", "\'Cannot be a case insensitive match with Username\' error is not displayed", "FAIL",runManagerInfoObj);
						 blnFlag=false;

					 }
				 }
				 else
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if Password can be entered in the New Password field", "Password cannot be entered in the New Password field" , "FAIL",runManagerInfoObj);
					 blnFlag=false;	
				 }
			 		 
		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());	
			 repfn.FnUpdateTestStepResHTML("Verify if Password can be entered in the New Password field", "Password cannot be entered in the New Password field due to some exception" , "FAIL",runManagerInfoObj);
			 blnFlag=false;	
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;

	 }
	 public synchronized boolean SecuritySettings_Symbolserror(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 String Password=m1.get("Symbols").toString();

			 if( cnf.FnExplicitWait("XPATH", mbo.MyProfile_SS_Password,driver))
			 { 
				 WebElement NewPassword=driver.findElement(By.xpath(mbo.MyProfile_SS_Password));
				 NewPassword.clear();
				 if(cnf.JSClick(NewPassword, driver)){
				 NewPassword.sendKeys(Password);
				repfn.FnUpdateTestStepResHTML("Verify if Password can be entered in the New Password field", "Password can be entered in the New Password field" +Password, "PASS",runManagerInfoObj);
				blnFlag=true;
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if Password can be entered in the New Password field", "Password can not entered in the New Password field" +Password, "FAIL",runManagerInfoObj);
						blnFlag=false;
				 }
				 if(cnf.FnExplicitWait("XPATH", mbo.SymbolsError,driver))
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if the following error message is displayed: Cannot use  (backslash) or  (quote) characters", "\'Cannot use  (backslash) or  (quote) characters\' error is displayed", "PASS",runManagerInfoObj);
					 blnFlag=true;
				 }
				 else
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if the following error message is displayed: Cannot use  (backslash) or  (quote) characters", "\'Cannot use  (backslash) or  (quote) characters\' error is not displayed", "FAIL",runManagerInfoObj);
					 blnFlag=false;

				 }
			 }
			 else
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if Password can be entered in the New Password field", "Password cannot be entered in the New Password field" , "FAIL",runManagerInfoObj);
				 blnFlag=false;	
			 }
		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
			 repfn.FnUpdateTestStepResHTML("Verify if Password can be entered in the New Password field", "Password cannot be entered in the New Password field due to some exception" , "FAIL",runManagerInfoObj);
			 blnFlag=false;	
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;

	 }

	 //To check if error message is displayed when some common phrase is entered in the password fields//

	 public synchronized boolean SecuritySettings_Phraseerror(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 String Password="charter";

			 if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_SS_Password,driver))
			 {
				 WebElement NewPassword=driver.findElement(By.xpath(mbo.MyProfile_SS_Password));
				 NewPassword.clear();
				 if(cnf.JSClick(NewPassword, driver)){
				 NewPassword.sendKeys(Password);
				 repfn.FnUpdateTestStepResHTML("Verify if Password can be entered in the New Password field", "Password can be entered in the New Password field" +Password, "PASS",runManagerInfoObj);
				blnFlag=true;
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if Password can be entered in the New Password field", "Password not entered in the New Password field" +Password, "FAIL",runManagerInfoObj);
						blnFlag=false;
				 }
				 if(cnf.FnExplicitWait("XPATH", mbo.CommonPhrase,driver))
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if the following error message is displayed: Cannot match a common phrase (password, changeme, charter, 123, abc, zxy, default)", "\'Cannot match a common phrase (password, changeme, charter, 123, abc, zxy, default)\' error is displayed", "PASS",runManagerInfoObj);
					 blnFlag=true;
				 }
				 else
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if the following error message is displayed: Cannot match a common phrase (password, changeme, charter, 123, abc, zxy, default)", "\'Cannot match a common phrase (password, changeme, charter, 123, abc, zxy, default)\' error is not displayed", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 else
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if Password can be entered in the New Password field", "Password cannot be entered in the New Password field" , "FAIL",runManagerInfoObj);
				 blnFlag=false;	
			 }
		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
			 repfn.FnUpdateTestStepResHTML("Verify if Password can be entered in the New Password field", "Password cannot be entered in the New Password field due to some exception" , "FAIL",runManagerInfoObj);
			 blnFlag=false;	
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;

	 }

	 // To check if the checklist points are dynamically changing to green//


	 public synchronized boolean SecuritySettings_Green(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 String Password="Testing01#$QW3";

			 if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_SS_Password,driver))
			 {
				 WebElement NewPassword=driver.findElement(By.xpath(mbo.MyProfile_SS_Password));
				 NewPassword.clear();
				 if(cnf.JSClick(NewPassword, driver)){
				 NewPassword.sendKeys(Password);
				 repfn.FnUpdateTestStepResHTML("Verify if Password can be entered in the New Password field", "Password can be entered in the New Password field" +Password, "PASS",runManagerInfoObj);
				 blnFlag=true;
				 }else{
					 repfn.FnUpdateTestStepResHTML("Verify if Password can be entered in the New Password field", "Password not entered in the New Password field" +Password, "FAIL",runManagerInfoObj);
					 blnFlag=false; 
				 }
				 
				 
				 if(cnf.FnExplicitWait("XPATH", mbo.CorrectLength,driver)&& cnf.FnExplicitWait("XPATH", mbo.CorrectUppercase,driver)&& cnf.FnExplicitWait("XPATH", mbo.CorrectLowercase,driver) && cnf.FnExplicitWait("XPATH", mbo.CorrectNumber,driver))

				 {
					 repfn.FnUpdateTestStepResHTML("Verify if the checklist dynamically changes to green if a password that meets the criteria is entered", "The checklist dynamically changes to green if a password that meets the criteria is entered", "PASS",runManagerInfoObj);
					 blnFlag=true;
				 }
				 else
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if the checklist dynamically changes to green if a password that meets the criteria is entered", "the checklist does not dynamically change to green if a password that meets the criteria is entered", "FAIL",runManagerInfoObj);
					 blnFlag=false;

				 }

			 }
			 else
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if Password can be entered in the New Password field", "Password cannot be entered in the New Password field" , "FAIL",runManagerInfoObj);
				 blnFlag=false;	
			 }
		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());	
			 repfn.FnUpdateTestStepResHTML("Verify if Password can be entered in the New Password field", "Password cannot be entered in the New Password field due to some exception" , "FAIL",runManagerInfoObj);
			 blnFlag=false;	
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;

	 }

	 // To check if the checklist points are dynamically changing to red//


	 public synchronized boolean SecuritySettings_Red(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 String Password="123";

			 if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_SS_Password,driver))
			 {
				 WebElement NewPassword=driver.findElement(By.xpath(mbo.MyProfile_SS_Password));
				 NewPassword.clear();
				 if(cnf.JSClick(NewPassword, driver)){
				 NewPassword.sendKeys(Password);
				 repfn.FnUpdateTestStepResHTML("Verify if Password can be entered in the New Password field", "Password can be entered in the New Password field" +Password, "PASS",runManagerInfoObj);
				 blnFlag=true;
				 NewPassword.click();
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if Password can be entered in the New Password field", "Password not entered in the New Password field" +Password, "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
				 Thread.sleep(5000);
				 if(cnf.FnExplicitWait("XPATH", mbo.InCorrectLength,driver)&& cnf.FnExplicitWait("XPATH", mbo.InCorrectUppercase,driver)&& cnf.FnExplicitWait("XPATH", mbo.InCorrectLowercase,driver))

				 {
					 repfn.FnUpdateTestStepResHTML("Verify if the checklist dynamically changes to red if a password that does not meet the criteria is entered", "The checklist dynamically changes to red if a password that does not meet the criteria is entered", "PASS",runManagerInfoObj);
					 blnFlag=true;
				 }
				 else
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if the checklist dynamically changes to red if a password that does not meet the criteria is entered"," The checklist does not dynamically change to red if a password that does not meet the criteria is entered", "FAIL",runManagerInfoObj);
					 blnFlag=false;

				 }

			 }
			 else
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if Password can be entered in the New Password field", "Password cannot be entered in the New Password field" , "FAIL",runManagerInfoObj);
				 blnFlag=false;	
			 }
		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());	
			 repfn.FnUpdateTestStepResHTML("Verify if Password can be entered in the New Password field", "Password cannot be entered in the New Password field due to some exception" , "FAIL",runManagerInfoObj);
			 blnFlag=false;	
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;

	 }
	 //To navigate to Security Settings tab in My Profile page//


	

	 // Function to check the dynamic changes when a password is entered//

	 public synchronized boolean PasswordCheck(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 SecuritySettings_Usernameerror(driver,runManagerInfoObj);
			 Thread.sleep(1000);
			 SecuritySettings_Symbolserror(driver,runManagerInfoObj);
			 Thread.sleep(1000);
			 SecuritySettings_Phraseerror(driver,runManagerInfoObj);
			 Thread.sleep(1000);
			 SecuritySettings_Red(driver,runManagerInfoObj);
			 Thread.sleep(1000);
			 SecuritySettings_Green(driver,runManagerInfoObj);
			 Thread.sleep(1000);
			 SecuritySettings_Strong(driver,runManagerInfoObj);
			 Thread.sleep(1000);
			 driver.navigate().refresh();
			 app.AlertAccept(driver,runManagerInfoObj);
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

	 public synchronized boolean SecuritySettings_Strong(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 
			 if(cnf.FnExplicitWait("XPATH", mbo.Passwordstrength_strongenabled,driver))
			 {
				 WebElement Strongshow=driver.findElement(By.xpath(mbo.Passwordstrength_strongenabled));
				 if(Strongshow.isEnabled())
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if the password entered is of Strong strength", "Password entered is of Strong strength", "PASS",runManagerInfoObj);
					 blnFlag=true;
				 }
				 else
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if the password entered is of Strong strength", "Password entered is not of Strong strength", "FAIL",runManagerInfoObj);
					 blnFlag=false;	
				 }
			 }
			 else if(cnf.FnExplicitWait("XPATH", mbo.Passwordstrength_Fairenabled,driver)){
				 WebElement FAIRshow=driver.findElement(By.xpath(mbo.Passwordstrength_Fairenabled));
				 if(FAIRshow.isEnabled())
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if the password entered is of Fair strength", "Password entered is of Fair strength", "PASS",runManagerInfoObj);
					 blnFlag=true;
				 }
				 else
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if the password entered is of Fair strength", "Password entered is not of Fair strength", "FAIL",runManagerInfoObj);
					 blnFlag=false;	
				 }
			 }
			 else if(cnf.FnExplicitWait("XPATH", mbo.Passwordstrength_Moderateenabled,driver)){
				 WebElement Passwordstrength_Moderateenabled=driver.findElement(By.xpath(mbo.Passwordstrength_Moderateenabled));
				 if(Passwordstrength_Moderateenabled.isEnabled())
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if the password entered is of Moderate strength", "Password entered is of Moderate strength", "PASS",runManagerInfoObj);
					 blnFlag=true;
				 }
				 else
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if the password entered is of Moderate strength", "Password entered is not of Moderate strength", "FAIL",runManagerInfoObj);
					 blnFlag=false;	
				 }
			 }				
		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());	
			 repfn.FnUpdateTestStepResHTML("Verify if the password entered is of Strong strength", "Password entered is not of Strong strength due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag=false;	
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;

	 }

	 
	 public synchronized boolean PasswordCheck1(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			
			 Thread.sleep(1000);
			 driver.navigate().refresh();
			 app.AlertAccept(driver,runManagerInfoObj);
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
	
	


	 public synchronized boolean FnClearPasswordFields(WebDriver driver, RunManagerInfo runManagerInfoObj){

		 String password = "Demo12test";
		 try{
			 if(cnf.FnExplicitWait("XPATH", mbo.SSPasswordField,driver)){
				 WebElement SSPasswordField=driver.findElement(By.xpath(mbo.SSPasswordField));
				 repfn.FnUpdateTestStepResHTML("Verify Password field is displayed", "Password field is displayed","PASS",runManagerInfoObj);
				 SSPasswordField.sendKeys(password);
				 repfn.FnUpdateTestStepResHTML("Verify new password is entered in Password field", "New password is entered in Password field: "+password,"PASS",runManagerInfoObj);
				 blnFlag=true;
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify Password field is displayed", "Password field is not displayed","FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }

			 if(cnf.FnExplicitWait("XPATH", mbo.SSRetypePasswordField,driver)){
				 WebElement SSRetypePasswordField=driver.findElement(By.xpath(mbo.SSRetypePasswordField));
				 repfn.FnUpdateTestStepResHTML("Verify Retype Password field is displayed", "Retype Password field is displayed","PASS",runManagerInfoObj);
				 SSRetypePasswordField.sendKeys(password);
				 repfn.FnUpdateTestStepResHTML("Verify new password is entered in Retype Password field", "New password is entered in Retype Password field","PASS",runManagerInfoObj);

				 Thread.sleep(2000);
				 if(cnf.FnExplicitWait("XPATH", mbo.clearInput,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify Clear option is displayed", "Clear option is displayed","PASS",runManagerInfoObj);
					 WebElement clearInput=driver.findElement(By.xpath(mbo.clearInput));
					 Thread.sleep(2000);
					 if(cnf.JSClick(clearInput,driver)){
						 repfn.FnUpdateTestStepResHTML("Verify Clear option is clicked", "Clear option is clicked","PASS",runManagerInfoObj);
						 if(SSRetypePasswordField.getAttribute("value").equalsIgnoreCase("") || SSRetypePasswordField.getAttribute("value") == null){
							 repfn.FnUpdateTestStepResHTML("Verify Retype Password field is cleared", "Retype Password field is cleared","PASS",runManagerInfoObj);
							 blnFlag=true;
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify Retype Password field is cleared", "Retype Password field is not cleared","FAIL",runManagerInfoObj);
							 blnFlag=false;
						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify Clear option is clicked", "Clear option is not clicked","FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify Clear option is displayed", "Clear option is not displayed","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify Retype Password field is displayed", "Retype Password field is not displayed","FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }

			 if(cnf.FnExplicitWait("XPATH", mbo.SSPasswordField,driver)){
				 WebElement SSPasswordFieldOne=driver.findElement(By.xpath(mbo.SSPasswordField));
				 // cnf.ScrollToView(SSPasswordField);
				 cnf.JSClick(SSPasswordFieldOne,driver);
				 repfn.FnUpdateTestStepResHTML("Verify Navigation and click on Password Field", "Navigation and click on Password Field is done","PASS",runManagerInfoObj);
				 if(cnf.FnExplicitWait("XPATH", mbo.clearInput,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify Clear option is displayed", "Clear option is displayed","PASS",runManagerInfoObj);
					 WebElement clearInputOne=driver.findElement(By.xpath(mbo.clearInput));
					 Thread.sleep(2000);
					 if(cnf.JSClick(clearInputOne,driver)){
						 repfn.FnUpdateTestStepResHTML("Verify Clear option is clicked", "Clear option is clicked","PASS",runManagerInfoObj);
						 if(SSPasswordFieldOne.getAttribute("value").equalsIgnoreCase("") || SSPasswordFieldOne.getAttribute("value") == null){
							 repfn.FnUpdateTestStepResHTML("Verify Password field is cleared", "Password field is cleared","PASS",runManagerInfoObj);
							 Thread.sleep(2000);
							 blnFlag=true;
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify Password field is cleared", "Password field is not cleared","FAIL",runManagerInfoObj);
							 blnFlag=false;
						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify Clear option is clicked", "Clear option is not clicked","FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify Clear option is displayed", "Clear option is not displayed","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify Navigation and click on Password Field", "Navigation and click on Password Field is not done","FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }

		 catch(Exception e)
		 {
			 repfn.FnUpdateTestStepResHTML("Verify Password and Retype Password fields are getting cleared on clicking the Clear Option", 
					 "Password and Retype Password fields are not getting cleared on clicking the Clear Option due to some exception.","FAIL",runManagerInfoObj);
			 blnFlag=false;
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());

		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;

	 }


	 public synchronized boolean FnNavigateToProfilePage(WebDriver driver, RunManagerInfo runManagerInfoObj){

		 try{
			 Thread.sleep(2000);
			
			 if(cnf.FnExplicitWait("XPATH", mbo.ProfileLink,driver)){
				 WebElement ProfileLink=driver.findElement(By.xpath(mbo.ProfileLink));
				 repfn.FnUpdateTestStepResHTML("Verify Profile link is displayed", "Profile link is displayed","PASS",runManagerInfoObj);
				 if(cnf.JSClick(ProfileLink,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify Profile link is clicked", "Profile link is clicked","PASS",runManagerInfoObj);
					 WebElement ConfirmCancel=driver.findElement(By.xpath(mbo.ConfirmCancel));
					 if(cnf.FnExplicitWait("XPATH", mbo.ConfirmCancel,driver)){
						 repfn.FnUpdateTestStepResHTML("Verify Confirm Navigation pop-up is displayed", "Confirm Navigation pop-up is displayed","PASS",runManagerInfoObj);
						 if(cnf.JSClick(ConfirmCancel,driver)){
							 repfn.FnUpdateTestStepResHTML("Verify Cancel button is clicked in the comfirmation popup", "Cancel button is clicked in the comfirmation popup","PASS",runManagerInfoObj);
							 Thread.sleep(5000);
							 repfn.FnUpdateTestStepResHTML("Verify Navigation to Profile page", "Navigation to Profile page is done","PASS",runManagerInfoObj);

							 blnFlag=true;
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify Cancel button is clicked in the comfirmation popup", "Cancel button is not  clicked in the comfirmation popup","FAIL",runManagerInfoObj);
                             blnFlag=false;
						 }
						
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify Confirm Navigation pop-up is displayed", "Confirm Navigation pop-up is not displayed","FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify Profile link is clicked", "Profile link is not clicked","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }

			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify Profile link is displayed", "Profile link is not displayed","FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }

		 catch(Exception e)
		 {
			 repfn.FnUpdateTestStepResHTML("Verify User is able to navigate to Profile page",  "User is able to navigate to Profile page due to some exception.","FAIL",runManagerInfoObj);
			 blnFlag=false;
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());

		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;


	 }
	 public synchronized boolean FN_NewPasswordRequiredFeildIcon_Check(WebDriver driver, RunManagerInfo runManagerInfoObj){
			try{
				if(cnf.FnExplicitWait("Xpath", mbo.NewPasswordLabel,driver)){
					WebElement NewPasswordLabel=driver.findElement(By.xpath(mbo.NewPasswordLabel));
					repfn.FnUpdateTestStepResHTML("Verify 'New Password' Label is displayed in Security setting page","'New Password' Label is displayed as "+NewPasswordLabel.getAttribute("innerHTML")+"in Security setting page","PASS",runManagerInfoObj);
					if(cnf.FnExplicitWait("XPATH", mbo.NewPassword_RequiredIcon,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Required Icon is displayed for 'New Password' Feild ","Required Icon is displayed for 'New Password' Feild","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Required Icon is displayed for 'New Password' Feild ","Required Icon is not  displayed for 'New Password' Feild","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify 'New Password' Label is displayed in Security setting page","'New Password' Label is not displayed in Security setting page","FAIL",runManagerInfoObj);
					blnFlag=false;

				}
			}
			
			catch (Exception e)

			{
				repfn.FnUpdateTestStepResHTML("Verify Required Icon is displayed for 'New Password' Feild ","Required Icon is not  displayed for 'New Password' Feild due to some exception","FAIL",runManagerInfoObj);
				blnFlag=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}

	 public synchronized boolean FN_RetypePasswordRequiredFeildIcon_Check(WebDriver driver, RunManagerInfo runManagerInfoObj){
			try{
				if(cnf.FnExplicitWait("Xpath", mbo.RetypePasswordLabel,driver)){
					WebElement RetypePasswordLabel=driver.findElement(By.xpath(mbo.RetypePasswordLabel));
					repfn.FnUpdateTestStepResHTML("Verify 'Retype New Password' Label is displayed in Security setting page","' Retype New Password' Label is displayed as "+RetypePasswordLabel.getAttribute("innerHTML")+"in Security setting page","PASS",runManagerInfoObj);
					if(cnf.FnExplicitWait("XPATH", mbo.RetypePasswordRequiredIcon,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Required Icon is displayed for ' Retype New Password' Feild ","Required Icon is displayed for 'Retype New Password' Feild","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Required Icon is displayed for ' Retype New Password' Feild ","Required Icon is not  displayed for 'Retype New Password' Feild","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify ' Retype New Password' Label is displayed in Security setting page","' Retype New Password' Label is not displayed in Security setting page","FAIL",runManagerInfoObj);
					blnFlag=false;

				}
			}
			
			catch (Exception e)

			{
				repfn.FnUpdateTestStepResHTML("Verify Required Icon is displayed for ' Retype New Password' Feild ","Required Icon is not  displayed for 'Retype New Password' Feild due to some exception","FAIL",runManagerInfoObj);
				blnFlag=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}



	
		 public synchronized boolean SS_Password(WebDriver driver, RunManagerInfo runManagerInfoObj)
		 {
			 try
			 {
				 if(cnf.FnExplicitWait("Xpath", mbo.MyProfile_SS_Password,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify if Password field is present", "Password field is present", "PASS",runManagerInfoObj);
					 WebElement Pwd=driver.findElement(By.xpath(mbo.MyProfile_SS_Password));
					 if(Pwd.getAttribute("value").isEmpty()){
						 repfn.FnUpdateTestStepResHTML("Verify if New Password field is blank ", "New Password field is blank", "PASS",runManagerInfoObj);
						 blnFlag = true;
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify if New Password field is blank ", "New Password field is not blank", "FAIL",runManagerInfoObj);
						 blnFlag = false;
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if Password field is present", "Password field is not present", "FAIL",runManagerInfoObj);
					 blnFlag = false;
				 }
				 
				 if(cnf.FnExplicitWait("Xpath", mbo.MyProfile_SS_ConfirmPassword,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify if Confirm Password field is present", "Confirm Password field is present", "PASS",runManagerInfoObj);
					 WebElement MyProfile_SS_ConfirmPassword=driver.findElement(By.xpath(mbo.MyProfile_SS_ConfirmPassword));
					 if(MyProfile_SS_ConfirmPassword.getAttribute("value").isEmpty()){
						 repfn.FnUpdateTestStepResHTML("Verify if Confirm Password field is blank ", "Confirm Password field is blank", "PASS",runManagerInfoObj);
						 blnFlag = true;
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify if Confirm Password field is blank ", "Confirm Password field is not blank", "FAIL",runManagerInfoObj);
						 blnFlag = false;
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if Confirm Password field is present", "Confirm Password field is not present", "FAIL",runManagerInfoObj);
					 blnFlag = false;
				 }
						 
			 }
			 catch(Exception e)
			 {
				 System.err.println("Message : "+e.getMessage());
				 System.err.println("Cause : "+e.getCause());
				 repfn.FnUpdateTestStepResHTML("Verify if New Password and Confirm Password fields are blank ", "New Password and Confirm Password fields are not blank due to some exception", "FAIL",runManagerInfoObj);
				 blnFlag = false;
			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;

		 }

		 //

		 public synchronized boolean SS_Passwordmasked(WebDriver driver, RunManagerInfo runManagerInfoObj)
		 {
			 String Password = m1.get("Password").toString();	
			 try
			 {
				 if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_SS_Password,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify if Password field is present", "Password field is present", "PASS",runManagerInfoObj);
					 WebElement Pwd=driver.findElement(By.xpath(mbo.MyProfile_SS_Password));
					if(cnf.JSClick(Pwd, driver)){
					 Pwd.sendKeys(Password);
					 repfn.FnUpdateTestStepResHTML("Type a password", "Password is entered", "PASS",runManagerInfoObj);
					 blnFlag=true;
					}else{
						 repfn.FnUpdateTestStepResHTML("Type a password", "Password is not entered", "FAIL",runManagerInfoObj);
						 blnFlag=false;
					}
					 if(Pwd.getAttribute("type").equals("password")){
						 repfn.FnUpdateTestStepResHTML("Verify if the Password entered is masked", "Password entered is masked", "PASS",runManagerInfoObj);
						 blnFlag=true;
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify if the Password entered is masked", "Password entered is not masked", "FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if Password field is present", "Password field is not present", "FAIL",runManagerInfoObj);	
					 blnFlag=false;
				 }
				 
				 if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_SS_ConfirmPassword,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify if Confirm Password field is present", "Confirm Password field is present", "PASS",runManagerInfoObj);
					 WebElement MyProfile_SS_ConfirmPassword=driver.findElement(By.xpath(mbo.MyProfile_SS_ConfirmPassword));
					 if(cnf.JSClick(MyProfile_SS_ConfirmPassword, driver)){
					 MyProfile_SS_ConfirmPassword.sendKeys(Password);
					 repfn.FnUpdateTestStepResHTML("Re-type the password", "Password is re-entered", "PASS",runManagerInfoObj);
					 blnFlag=true;
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Re-type the password", "Password is not re-entered", "FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
					 if(MyProfile_SS_ConfirmPassword.getAttribute("type").equals("password")){
						 repfn.FnUpdateTestStepResHTML("Verify if the Password re-entered is masked", "Password re-entered is masked", "PASS",runManagerInfoObj);
						 blnFlag=true;
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify if the Password re-entered is masked", "Password re-entered is not masked", "FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if Confirm Password field is present", "Confirm Password field is not present", "FAIL",runManagerInfoObj);	
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

		 public synchronized boolean MyProfile_SS_Save(WebDriver driver, RunManagerInfo runManagerInfoObj)
		 {
			 try
			 {			
				 if(cnf.FnExplicitWait("XPATH", mbo.MyProf_SS_Save,driver))
				 {
					 WebElement Save=driver.findElement(By.xpath(mbo.MyProf_SS_Save));
					 System.out.println("Save displayed");
					 repfn.FnUpdateTestStepResHTML("Verify if Save button is present", "Save button is present", "PASS",runManagerInfoObj);
					 Thread.sleep(5000);
					 if(Save.isEnabled())
					 {
						 System.out.println("Save enabled");
						 repfn.FnUpdateTestStepResHTML("Verify if Save button is enabled", "Save button is enabled", "PASS",runManagerInfoObj);
						 Thread.sleep(2000);
						 if(cnf.JSClick(Save,driver)){
							 repfn.FnUpdateTestStepResHTML("Verify if Save button is clicked", "Save button is clicked", "PASS",runManagerInfoObj);
							 System.out.println("Save clicked");
							// repfn.FnUpdateTestStepResHTML("Verify if Save button is clicked", "Save button is clicked", "PASS");
							 if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_SaveSuccess,driver))
							 {
								 repfn.FnUpdateTestStepResHTML("Verify if Success Message is displayed", " 'Profile Updated Successfully' message is displayed", "PASS",runManagerInfoObj);
								 blnFlag=true;
								//driver.navigate().refresh();
							 }
							 else
							 {
								 repfn.FnUpdateTestStepResHTML("Verify if Success Message is displayed", "Success message is not displayed", "FAIL",runManagerInfoObj);
								 blnFlag=false;	
							 }
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify if Save button is clicked", "Save button is not clicked", "FAIL",runManagerInfoObj);
							 blnFlag=false;	
						 }					
					 }
					 else 
					 {
						 repfn.FnUpdateTestStepResHTML("Verify if Save button is enabled", "Save button is not enabled", "FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
				 else
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if Save button is present", "Save button is not present", "FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 catch(Exception e)
			 {
				 
				 repfn.FnUpdateTestStepResHTML("Verify if Success Message is displayed", "Success message is not displayed due to some exception", "FAIL",runManagerInfoObj);
				 blnFlag=false;	
				 System.err.println("Message : "+e.getMessage());
				 System.err.println("Cause : "+e.getCause());	
			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;

		 }

		 public synchronized boolean SS_Passwordentry(WebDriver driver, RunManagerInfo runManagerInfoObj)
		 {
			 String Password = m1.get("Password").toString();
			 try
			 {
				 if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_SS_Password,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify if Password field is present", "Password field is present", "PASS",runManagerInfoObj);
					 WebElement Pwd=driver.findElement(By.xpath(mbo.MyProfile_SS_Password));
					 if(cnf.JSClick(Pwd, driver)){
					 Pwd.sendKeys(Password);
					 repfn.FnUpdateTestStepResHTML("Type a password", "Password is entered", "PASS",runManagerInfoObj);
					 blnFlag=true;
					 }else{
						 repfn.FnUpdateTestStepResHTML("Type a password", "Password is not entered", "FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if Password field is present", "Password field is not present", "FAIL",runManagerInfoObj);	
					 blnFlag=false;
				 }
				 
				 if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_SS_ConfirmPassword,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify if Confirm Password field is present", "Confirm Password field is present", "PASS",runManagerInfoObj);
					 WebElement MyProfile_SS_ConfirmPassword=driver.findElement(By.xpath(mbo.MyProfile_SS_ConfirmPassword));
					if(cnf.JSClick(MyProfile_SS_ConfirmPassword, driver)){
					 MyProfile_SS_ConfirmPassword.sendKeys(Password);
					 repfn.FnUpdateTestStepResHTML("Re-type the password", "Password is re-entered", "PASS",runManagerInfoObj);
					 blnFlag=true;
					}else{
						repfn.FnUpdateTestStepResHTML("Re-type the password", "Password is not re-entered", "FAIL",runManagerInfoObj);
						 blnFlag=false;
					}
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if Confirm Password field is present", "Confirm Password field is not present", "FAIL",runManagerInfoObj);	
					 blnFlag=false;
				 }	
			 }
			 catch(Exception e)
			 {
				 repfn.FnUpdateTestStepResHTML("Verify if Password field is present", "Password field is not present due to some exception", "FAIL",runManagerInfoObj);	
				 blnFlag=false;
				 System.err.println("Message : "+e.getMessage());
				 System.err.println("Cause : "+e.getCause());
			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;

		 }


		 public synchronized boolean MyProfile_SS_VerifySave(WebDriver driver, RunManagerInfo runManagerInfoObj)
		 {
			 try
			 {
				 String Pwds="Testing01";
	 
				 if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_SS_Password,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify Password feild is present ", "Password feild is present", "PASS",runManagerInfoObj);
					 WebElement FName=driver.findElement(By.xpath(mbo.MyProfile_SS_Password));
					 System.out.println("first name"+Pwds);
					 if(FName.getAttribute("value").contains(Pwds))
					 {
						 System.out.println("changes saved");
						 repfn.FnUpdateTestStepResHTML("Verify if the changes made are saved", "Changes made are saved", "PASS",runManagerInfoObj);
						 blnFlag=true;
					 }
					 else
					 {
						 System.out.println("changes not saved");
						 repfn.FnUpdateTestStepResHTML("Verify if the changes made are saved", "Changes made are not saved", "FAIL",runManagerInfoObj);
						 blnFlag=false;


					 } 
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify Password feild is present ", "Password feild is not present", "FAIL",runManagerInfoObj);

				 }
				 

			 }
			 catch(Exception e)
			 {
				 System.err.println("Message : "+e.getMessage());
				 System.err.println("Cause : "+e.getCause());
				 repfn.FnUpdateTestStepResHTML("Verify if the changes made are saved", "Changes made are not saved due to some exeception", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;
		 }


		 //Function to save Passwords in Security Settings page-My Profile//

		 public synchronized boolean MyProfile_SecuritySettings_PasswordSave(WebDriver driver, RunManagerInfo runManagerInfoObj)
		 {  
			 
			 try
			 {
				 
				 
			blnFlag=	 SS_Passwordentry(driver,runManagerInfoObj);
			blnFlag=	 SecuritySettings_Strong(driver,runManagerInfoObj);
			blnFlag=	 MyProfile_SS_Save(driver,runManagerInfoObj);
			blnFlag=	 MyProfile_SS_VerifySave(driver,runManagerInfoObj);
				 
				 

			 }
			 catch(Exception e)
			 {
				 System.err.println("Message : "+e.getMessage());
				 System.err.println("Cause : "+e.getCause());
			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;


		 }

		 public synchronized boolean ChangeSecurityQuestionAnswer(WebDriver driver, RunManagerInfo runManagerInfoObj) {
			 
			 int index = Integer.valueOf(m1.get("Index").toString());
			 String Answer = m1.get("Answer").toString();
			 
			 try {
				 
				 if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_SS_SecurityQuestion,driver)){	 
					 repfn.FnUpdateTestStepResHTML("Verify if Security Question drop-down is displayed", "Security Question drop-down is displayed", "PASS",runManagerInfoObj);
					 WebElement SecurityQuestion = driver.findElement(By.xpath(mbo.MyProfile_SS_SecurityQuestion));
					 Select SecurityQuestions = new Select(SecurityQuestion);
					 SecurityQuestions.selectByIndex(index);
					 repfn.FnUpdateTestStepResHTML("Verify if Security Question is getting selected", "Security Question selected", "PASS",runManagerInfoObj);
					 blnFlag = true;
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if Security Question drop-down is displayed", "Security Question drop-down is not displayed", "FAIL",runManagerInfoObj);
					 blnFlag = false;
				 }
				 
				 if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_SS_SecurityAnswer,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify if Security Answer field is displayed", "Security Answer field is displayed", "PASS",runManagerInfoObj);
					 WebElement SecurityAnswer = driver.findElement(By.xpath(mbo.MyProfile_SS_SecurityAnswer));
					 SecurityAnswer.clear();
					 SecurityAnswer.sendKeys(Answer);
					 repfn.FnUpdateTestStepResHTML("Verify if Security Answer is getting entered", "Security Answer entered", "PASS",runManagerInfoObj);
					 Thread.sleep(3000);
					 blnFlag = true;
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if Security Answer field is displayed", "Security Answer field is not displayed", "FAIL",runManagerInfoObj);
					 blnFlag = false;
				 }
				 
				 if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_SS_SecuritySaveButton,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify if Save button is displayed", "Save button is displayed", "PASS",runManagerInfoObj);
					 WebElement SaveButton = driver.findElement(By.xpath(mbo.MyProfile_SS_SecuritySaveButton));
					 if(SaveButton.isEnabled()) {
						 repfn.FnUpdateTestStepResHTML("Verify if Save button is enabled", "Save button is enabled", "PASS",runManagerInfoObj);
						 if(cnf.JSClick(SaveButton,driver)){
							 repfn.FnUpdateTestStepResHTML("Verify if Save button is clicked", "Save button is clicked", "PASS",runManagerInfoObj);
							 if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_SS_SecuritySuccessMessage,driver)) {
								 WebElement SuccessMessage = driver.findElement(By.xpath(mbo.MyProfile_SS_SecuritySuccessMessage));
								 repfn.FnUpdateTestStepResHTML("Verify if Security Q&A is saved successfully", "Security Q&A saved successfully. Success Message is displayed: "+SuccessMessage.getText(), "PASS",runManagerInfoObj);
								 blnFlag = true;
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify if Security Q&A is saved successfully", "Security Q&A is not saved", "FAIL",runManagerInfoObj);
								 blnFlag = false;
								 if(cnf.isElementExist(By.xpath("//p[@ ng-if='!options.useHtml' and .='Update failed.']"),driver)){
									 repfn.FnUpdateTestStepResHTML("Verify Getting Update failed error message is getting displayed", " Getting Update failed error message is getting displayed", "FAIL",runManagerInfoObj);
									 driver.navigate().refresh();
									 app.AlertAccept(driver,runManagerInfoObj);
									 blnFlag=false;
								 }
							 }
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify if Save button is clicked", "Save button is not clicked", "FAIL",runManagerInfoObj);
							 blnFlag=false;
							 if(cnf.isElementExist(By.xpath("//p[@ ng-if='!options.useHtml' and .='Update failed.']"),driver)){
								 repfn.FnUpdateTestStepResHTML("Verify Getting Update failed error message is getting displayed", " Getting Update failed error message is getting displayed", "FAIL",runManagerInfoObj);
								 driver.navigate().refresh();
								 app.AlertAccept(driver,runManagerInfoObj);
								 blnFlag=false;
							 }
						 }
					 }
					 else {
						 repfn.FnUpdateTestStepResHTML("Verify if Save button is enabled", "Save button is not enabled", "FAIL",runManagerInfoObj);
						 blnFlag = false;
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if Save button is displayed", "Save button is not displayed", "FAIL",runManagerInfoObj);
					 blnFlag = false;
				 }
			 } 
			 
			 catch (Exception e) {
				 System.err.println("Message : " + e.getMessage());
				 System.err.println("Cause : " + e.getCause());
				 repfn.FnUpdateTestStepResHTML("Verify if Security Q&A is saved successfully", "Security Q&A is not saved due to some exception", "FAIL",runManagerInfoObj);
				 blnFlag = false;
			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;
		 }
		 
	public synchronized boolean SecurityAnswer_ClearFields(WebDriver driver, RunManagerInfo runManagerInfoObj) {
			 
			 String Answer = m1.get("Answer").toString();
			 
			 try {
				 			 
				 if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_SS_SecurityAnswer,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify if Security Answer field is displayed", "Security Answer field is displayed", "PASS",runManagerInfoObj);
					 WebElement SecurityAnswer = driver.findElement(By.xpath(mbo.MyProfile_SS_SecurityAnswer));
					 SecurityAnswer.clear();
					 SecurityAnswer.sendKeys(Answer);
					 repfn.FnUpdateTestStepResHTML("Verify if Security Answer is getting entered", "Security Answer entered", "PASS",runManagerInfoObj);
					 Thread.sleep(3000);
					 blnFlag = true;
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if Security Answer field is displayed", "Security Answer field is not displayed", "FAIL",runManagerInfoObj);
					 blnFlag = false;
				 }
				 
				 if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_SS_SecurityAnswerX,driver)) {
					 repfn.FnUpdateTestStepResHTML("Verify if X is getting displayed at the end of Security Answer text-field", "X is getting displayed", "PASS",runManagerInfoObj);
					 WebElement SecurityAnswerX = driver.findElement(By.xpath(mbo.MyProfile_SS_SecurityAnswerX));
					 if(cnf.JSClick(SecurityAnswerX,driver)){
						 repfn.FnUpdateTestStepResHTML("Verify if X is clicked which is  displayed at the end of Security Answer text-field", "X is getting displayed and clicked", "PASS",runManagerInfoObj);
						 
						 if(cnf.FnExplicitWait("XPATH", mbo.MyProfile_SS_SecurityAnswer,driver)){
							 WebElement SecurityAnswerOne = driver.findElement(By.xpath(mbo.MyProfile_SS_SecurityAnswer));
							 if (SecurityAnswerOne.getText().isEmpty() || SecurityAnswerOne.getText().equalsIgnoreCase("")) {
								 repfn.FnUpdateTestStepResHTML("Verify if clicking on X is clearing text-field", "Security Answer text-field is cleared", "PASS",runManagerInfoObj);
								 blnFlag = true;
							 } 
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify if clicking on X is clearing text-field", "Security Answer text-field is not cleared", "FAIL",runManagerInfoObj);
								 blnFlag = false;
							 }
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify if Security Answer field is displayed", "Security Answer field is not displayed", "FAIL",runManagerInfoObj);
							 blnFlag = false;
						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify if X is clicked which is  displayed at the end of Security Answer text-field", "X is getting displayed and not clicked", "FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
				 else {
					 repfn.FnUpdateTestStepResHTML("Verify if X is getting displayed at the end of Security Answer text-field", "X is not getting displayed", "FAIL",runManagerInfoObj);
					 blnFlag = false;
				 }
			 } 
			 
			 catch (Exception e) {
				 System.err.println("Message : " + e.getMessage());
				 System.err.println("Cause : " + e.getCause());
				 repfn.FnUpdateTestStepResHTML("Verify if Security Answer is cleared on clicking X option", "Security Answer is not cleared on clicking X option due to some exception", "FAIL",runManagerInfoObj);
				 blnFlag = false;
			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;
		 }
	public synchronized boolean FnVerifySecurityQAOptions(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
		
		try{
			
			 if(cnf.FnExplicitWait("XPATH", mbo.SecurityQuestion_AnswerHeading,driver)){
				 WebElement SecurityQuestion_AnswerHeading=driver.findElement(By.xpath(mbo.SecurityQuestion_AnswerHeading));
				 repfn.FnUpdateTestStepResHTML("Verify Security Question/Answer Heading is displayed", "Security Question/Answer Heading is displayed: "+SecurityQuestion_AnswerHeading.getText(), "PASS",runManagerInfoObj);
				 blnFlag=true;
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify Security Question/Answer Heading is displayed", "Security Question/Answer Heading is not displayed", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
			 
			 if(cnf.FnExplicitWait("XPATH", mbo.SecurityQuestionText,driver)){
				 WebElement SecurityQuestionText=driver.findElement(By.xpath(mbo.SecurityQuestionText));
				 repfn.FnUpdateTestStepResHTML("Verify Security Question text is displayed", "Security Question text is displayed: "+SecurityQuestionText.getText(), "PASS",runManagerInfoObj);
				 blnFlag=true;
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify Security Question text is displayed", "Security Question text is not displayed", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
			 
			 if(cnf.FnExplicitWait("XPATH", mbo.SecurityQuestionInput,driver)){
				 repfn.FnUpdateTestStepResHTML("Verify Security Question drop-down is displayed", "Security Question drop-down is displayed", "PASS",runManagerInfoObj);
				 blnFlag=true;
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify Security Question drop-down is displayed", "Security Question drop-down is not displayed", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
			 
			 if(cnf.FnExplicitWait("XPATH", mbo.SecurityAnswerText,driver)){
				 WebElement SecurityAnswerText=driver.findElement(By.xpath(mbo.SecurityAnswerText));
				 repfn.FnUpdateTestStepResHTML("Verify Security Answer text is displayed", "Security Answer text is displayed: "+SecurityAnswerText.getText(), "PASS",runManagerInfoObj);
				 blnFlag=true;
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify Security Answer text is displayed", "Security Answer text is not displayed", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
			 
			 if(cnf.FnExplicitWait("XPATH", mbo.SecurityAnswerInput,driver)){
				 repfn.FnUpdateTestStepResHTML("Verify Security Answer Input field is displayed", "Security Answer Input field is displayed", "PASS",runManagerInfoObj);
				 blnFlag=true;
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify Security Answer Input field is displayed", "Security Answer Input field is not displayed", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
			 
			 if(cnf.FnExplicitWait("XPATH", mbo.SecurityQASaveButton,driver)){
				 repfn.FnUpdateTestStepResHTML("Verify Save button is displayed in Security Q/A section", "Save button is displayed in Security Q/A section", "PASS",runManagerInfoObj);
				 blnFlag=true;
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify Save button is displayed in Security Q/A section", "Save button is not displayed in Security Q/A section", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
			 
			 if(cnf.FnExplicitWait("XPATH", mbo.Support_Link,driver)){
				 repfn.FnUpdateTestStepResHTML("Verify Support link is displayed on Security Settings page", "Support link is displayed on Security Settings page", "PASS",runManagerInfoObj);
				 blnFlag=true;
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify Support link is displayed on Security Settings page", "Support link is not displayed on Security Settings page", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
				 
		}
		
		catch (Exception e)

		 {		
			 repfn.FnUpdateTestStepResHTML("Verify if User is able to verify Security Question/Answer Options on Security Settings page", "User is able to verify Security Question/Answer Options on Security Settings page due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag=false;
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
		 }
		
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	}
	


}
