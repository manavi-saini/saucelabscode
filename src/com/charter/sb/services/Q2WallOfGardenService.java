package com.charter.sb.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

public class Q2WallOfGardenService extends Initialization {
	MB_PageObjects mbo = new MB_PageObjects();
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	public static boolean blnFlag = false;
	
	
public synchronized boolean Q2_Logout(WebDriver driver,RunManagerInfo runManagerInfoObj){
	
	try{
		if(cnf.FnExplicitWait("XPATH", mbo.Q2_Arrow,driver))
		{
			WebElement Arrow=driver.findElement(By.xpath(mbo.Q2_Arrow));
			cnf.JSClick(Arrow,driver);
			System.out.println("Click on Arrow");
			repfn.FnUpdateTestStepResHTML("Verify and click on the arrow to view the Logged in user profile", "Logged in profile details are displayed","PASS",runManagerInfoObj);
			if(cnf.FnExplicitWait("XPATH", mbo.Q2_SignOutLink,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify if Sign Out link is present", "Sign Out link is present", "PASS",runManagerInfoObj);
				WebElement SignOut=driver.findElement(By.xpath(mbo.Q2_SignOutLink));
				if(cnf.JSClick(SignOut,driver))
				{
					repfn.FnUpdateTestStepResHTML("Click on SignOut", "SignOut link is clicked", "PASS",runManagerInfoObj);
					Thread.sleep(1000);
					if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_SignInLink,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify if user is navigated to Sign-In page", "User is navigated to Sign In Page", "PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{

						repfn.FnUpdateTestStepResHTML("Verify if user is navigated to Sign-In page", "User is not navigated to Sign In Page", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
						}
				else
				{

					repfn.FnUpdateTestStepResHTML("Click on SignOut", "SignOut link is not clickable", "FAIL",runManagerInfoObj);
						blnFlag=false;
				}
					
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if Sign Out link is present", "Sign Out link is not present", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify and click on the arrow to view the Logged in user profile", "Not able to expand the logged-in profile details","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}
	
	catch (Exception e)

		{
			repfn.FnUpdateTestStepResHTML("Verify if user is able to logout successfully", "User is not able to logout successfully", "FAIL",runManagerInfoObj);
			blnFlag=false;

	      	 
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
}


	public synchronized boolean FnNavigateToWallOfGardenURL(WebDriver driver,RunManagerInfo runManagerInfoObj){

		boolean blnFlag=false;
		 
		String AppEnvironment=m1.get("AppURL").toString();
		System.out.println("inside fn launch:"+ AppEnvironment);

		try{

			System.out.println("inside try");
			
			String Appurl=m1.get("AppURL").toString();
			System.out.println("App url: " + Appurl);

			driver.navigate().to(Appurl);

			if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_ServiceAnnPageVerification,driver)){
				repfn.FnUpdateTestStepResHTML("Verify User is on Service Announcement Page", "User is on Service Announcement Page", "PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify User is on Service Announcement Page", "User is not on Service Announcement Page", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		catch(Exception e)
		{
			repfn.FnUpdateTestStepResHTML("Login to Charter-Wall of Garden application", "Login to Charter-Wall of Garden not performed","FAIL",runManagerInfoObj);
			blnFlag=false;
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
		}		
		m1.put("STEPSTATUS", blnFlag);
		System.out.println( "launch flag: "+blnFlag);
		return blnFlag;

	}
	 public synchronized boolean CommonLogout_WallOfGarden(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception
	 {
		 try
		 {
			 if(cnf.FnExplicitWait("XPATH",mbo.Q2Wall_HeaderDropdown,driver))
			 {
				 repfn.FnUpdateTestStepResHTML("Verify Logged user Drop down link is displayed", "Logged user Dropdown link is displayed","PASS",runManagerInfoObj); 
				 WebElement Q2Wall_HeaderDropdown=driver.findElement(By.xpath(mbo.Q2Wall_HeaderDropdown));
				 if(cnf.JSClick(Q2Wall_HeaderDropdown,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify Logged user Drop down link is clicked", "Logged user Drop down link is clicked","PASS",runManagerInfoObj); 
					 
					 Thread.sleep(5000);
					 if(cnf.FnExplicitWait("XPATH",mbo.Q2Wall_SignOut,driver)){
						 repfn.FnUpdateTestStepResHTML("Check Whether Sign out link is displayed in the Drop down", "Sign out link is displayed in the Drop down","PASS",runManagerInfoObj);
						 
						 WebElement Q2Wall_SignOut=driver.findElement(By.xpath(mbo.Q2Wall_SignOut));
						 if(cnf.JSClick(Q2Wall_SignOut,driver)){
							 repfn.FnUpdateTestStepResHTML("Check Whether Sign out link is clicked", "Sign out link is clicked","PASS",runManagerInfoObj);
							 
							 if(cnf.isAlertPresent()){
									driver.switchTo().alert();
									String ErrMsg=driver.switchTo().alert().getText();
									System.out.println(ErrMsg);
									//repfn.FnUpdateTestStepResHTML("verify .... ",".......","PASS/WARNING");// update the reporting function based on your requirement
									driver.switchTo().alert().dismiss();
									driver.switchTo().defaultContent();
									Thread.sleep(5000);

								}else{
									//repfn.FnUpdateTestStepResHTML("verify .... ",".......","PASS/WARNING");// update the reporting function based on your requirement
									System.out.println("No alert present");                                              
								}
							 
							 blnFlag = true;
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Check Whether Sign out link is clicked", "Sign out link is not clicked","FAIL",runManagerInfoObj);
							 blnFlag = false;
						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Check Whether Sign out button is displayed in the Drop down", "Sign out button is not displayed in the Drop down","FAIL",runManagerInfoObj);
						 blnFlag = false;
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify Logged user Drop down link is clicked", "Logged user Drop down link is not clicked","FAIL",runManagerInfoObj); 
					 blnFlag = false;
				 }
			 }
			 else 
			 {
				 repfn.FnUpdateTestStepResHTML("Verify Logged user Drop down link is displayed", "Logged user Dropdown link is not displayed ","FAIL",runManagerInfoObj); 				 
				 blnFlag = false;
			 }


		 }
		 catch(Exception e)
		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
			 blnFlag	=false;
			 repfn.FnUpdateTestStepResHTML("Logout of Spectrum Business.net ", "Logout is not performed due to exception","FAIL",runManagerInfoObj);	
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }
	 public synchronized boolean FnVerifySignInPageUI(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{
			
			try{
				
				if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_SpectrumBusinessLogo,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Spectrum Business logo is displayed", "Spectrum Business logo is displayed", "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Spectrum Business logo is displayed", "Spectrum Business logo is not displayed", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_SignInPageTitle,driver)){
					WebElement Q2Wall_SignInPageTitle=driver.findElement(By.xpath(mbo.Q2Wall_SignInPageTitle));
					repfn.FnUpdateTestStepResHTML("Verify Sign In Page title is displayed", "Sign In Page title is displayed as: "+Q2Wall_SignInPageTitle.getText(), "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Sign In Page title is displayed", "Sign In Page title is not displayed", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_SignInPageSubTitle,driver)){
					WebElement Q2Wall_SignInPageSubTitle=driver.findElement(By.xpath(mbo.Q2Wall_SignInPageSubTitle));
					repfn.FnUpdateTestStepResHTML("Verify Sign In Page sub-title is displayed", "Sign In Page sub-title is displayed as: "+Q2Wall_SignInPageSubTitle.getText(), "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Sign In Page sub-title is displayed", "Sign In Page sub-title is not displayed", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_SignInPageText,driver)){
					WebElement Q2Wall_SignInPageText=driver.findElement(By.xpath(mbo.Q2Wall_SignInPageText));
					repfn.FnUpdateTestStepResHTML("Verify Sign In Page text is displayed", "Sign In Page text is displayed as: "+Q2Wall_SignInPageText.getText(), "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Sign In Page text is displayed", "Sign In Page text is not displayed", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_SignInUserNameHeading,driver)){
					WebElement Q2Wall_SignInUserNameHeading=driver.findElement(By.xpath(mbo.Q2Wall_SignInUserNameHeading));
					repfn.FnUpdateTestStepResHTML("Verify User Name Heading is displayed", "User Name Heading is displayed with text as: "+Q2Wall_SignInUserNameHeading.getText(), "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User Name Heading is displayed", "User Name Heading is not displayed", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_SignInUserNameRequired,driver)){
					WebElement Q2Wall_SignInUserNameRequired=driver.findElement(By.xpath(mbo.Q2Wall_SignInUserNameRequired));
					repfn.FnUpdateTestStepResHTML("Verify Required field indicator is displayed for Username field", "Required field indicator is displayed for Username field as: "+Q2Wall_SignInUserNameRequired.getText(), "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Required field indicator is displayed for Username field", "Required field indicator is not displayed for Username field", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_SignInUserNameField,driver)){
					repfn.FnUpdateTestStepResHTML("Verify User Name Input field is displayed", "User Name Input field is displayed", "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User Name Input field is displayed", "User Name Input field is not displayed", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_SignInForgotUsernameLink,driver)){
					WebElement Q2Wall_SignInForgotUsernameLink=driver.findElement(By.xpath(mbo.Q2Wall_SignInForgotUsernameLink));
					repfn.FnUpdateTestStepResHTML("Verify Forgot UserName link is displayed", "Forgot UserName link is displayed with text as: "+Q2Wall_SignInForgotUsernameLink.getText(), "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Forgot UserName link is displayed", "Forgot UserName link is not displayed", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				//
				
				if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_SignInPasswordHeading,driver)){
					WebElement Q2Wall_SignInPasswordHeading=driver.findElement(By.xpath(mbo.Q2Wall_SignInPasswordHeading));
					repfn.FnUpdateTestStepResHTML("Verify Password Heading is displayed", "Password Heading is displayed with text as: "+Q2Wall_SignInPasswordHeading.getText(), "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Password Heading is displayed", "Password Heading is not displayed", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_SignInPasswordRequired,driver)){
					WebElement Q2Wall_SignInPasswordRequired=driver.findElement(By.xpath(mbo.Q2Wall_SignInPasswordRequired));
					repfn.FnUpdateTestStepResHTML("Verify Required field indicator is displayed for Password field", "Required field indicator is displayed for Password field as: "+Q2Wall_SignInPasswordRequired.getText(), "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Required field indicator is displayed for Password field", "Required field indicator is not displayed for Password field", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_SignInPasswordField,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Password Input field is displayed", "Password Input field is displayed", "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Password Input field is displayed", "Password Input field is not displayed", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_SignInForgotPasswordLink,driver)){
					WebElement Q2Wall_SignInForgotPasswordLink=driver.findElement(By.xpath(mbo.Q2Wall_SignInForgotPasswordLink));
					repfn.FnUpdateTestStepResHTML("Verify Forgot Password link is displayed", "Forgot Password link is displayed with text as: "+Q2Wall_SignInForgotPasswordLink.getText(), "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Forgot Password link is displayed", "Forgot Password link is not displayed", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_SignInButton,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Sign In button is displayed", "Sign In button is displayed", "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Sign In button is displayed", "Sign In button is not displayed", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_CustomerCareVerbiageOne,driver)){
					WebElement Q2Wall_CustomerCareVerbiageOne=driver.findElement(By.xpath(mbo.Q2Wall_CustomerCareVerbiageOne));
					if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_CustomerCareVerbiageTwo,driver)){
						WebElement Q2Wall_CustomerCareVerbiageTwo=driver.findElement(By.xpath(mbo.Q2Wall_CustomerCareVerbiageTwo));
						repfn.FnUpdateTestStepResHTML("Verify Customer Care Verbiage is displayed correctly", 
								"Customer Care Verbiage is displayed as: "+Q2Wall_CustomerCareVerbiageOne.getText()+" \n "+Q2Wall_CustomerCareVerbiageTwo.getText(), "PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Customer Care Verbiage is displayed correctly", "Customer Care Verbiage is not displayed correctly", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Customer Care Verbiage is displayed correctly", "Customer Care Verbiage is not displayed correctly", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				
				if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_SpectrumBusinessLogo,driver)){
					WebElement Q2Wall_SpectrumBusinessLogo=driver.findElement(By.xpath(mbo.Q2Wall_SpectrumBusinessLogo));
					cnf.ScrollToView(Q2Wall_SpectrumBusinessLogo,driver);
					if(cnf.JSClick(Q2Wall_SpectrumBusinessLogo,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Spectrum Business logo is clicked", "Spectrum Business logo is clicked", "PASS",runManagerInfoObj);
						if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_SignInPageSubTitle,driver)){
							WebElement Q2Wall_SignInPageSubTitle=driver.findElement(By.xpath(mbo.Q2Wall_SignInPageSubTitle));
							if(Q2Wall_SignInPageSubTitle.getAttribute("textContent").equalsIgnoreCase("Sign In")){
								repfn.FnUpdateTestStepResHTML("Verify User is still on Login page after clicking Spectrum Business Logo", "User is still on Login page after clicking Spectrum Business Logo. Hence, Spectrum Business Logo is disabled", "PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify User is still on Login page after clicking Spectrum Business Logo", "User is not on Login page after clicking Spectrum Business Logo. Hence, Spectrum Business Logo is not disabled", "FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Sign In Page sub-title is displayed", "Sign In Page sub-title is not displayed", "FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Spectrum Business logo is clicked", "Spectrum Business logo is not clicked", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Spectrum Business logo is displayed", "Spectrum Business logo is not displayed", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}

			}
			
			catch(Exception e)
			{
				blnFlag=false;
				repfn.FnUpdateTestStepResHTML("Verify User is able to verify Sign In page UI of Wall of Garden", "User is not able to verify Sign In page UI of Wall of Garden due to some exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
	 public synchronized boolean Q2Wall_NotificationPage_PayNowbuttonclick(WebDriver driver,RunManagerInfo runManagerInfoObj){
			try{

				if(cnf.FnExplicitWait("Xpath",mbo.Q2Wall_AccountPastDueLabel,driver)){
					repfn.FnUpdateTestStepResHTML("Verify User is now on the Notification page ","User is now on the Notification page","PASS",runManagerInfoObj);			
						if(cnf.FnExplicitWait("Xpath",mbo.Q2Wall_PayNowbtn,driver)){
							repfn.FnUpdateTestStepResHTML("Verify User is able to see online payment option ","User is able to see online payment option","PASS",runManagerInfoObj);
							WebElement paybutton=driver.findElement(By.xpath(mbo.Q2Wall_PayNowbtn));
							if(cnf.JSClick(paybutton,driver)){
								repfn.FnUpdateTestStepResHTML("Verify User selects Online Payment option ","Online Payment is Clicked","PASS",runManagerInfoObj);
								Thread.sleep(7000);
								
								if(cnf.FnExplicitWait("Xpath", mbo.Q2Wall_PaybillLabel,driver)){
									repfn.FnUpdateTestStepResHTML("Verify User is now on the Pay bill page  ","User is now on the Pay bill page","PASS",runManagerInfoObj);
									blnFlag=true;
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify User is now on the Pay bill page  ","User is not in the Pay bill page","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User selects Online Payment  ","Online Payment is not  Clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify User is able to see online payment option ","User is not able to see online payment option","FAIL",runManagerInfoObj);
						blnFlag=false;
						
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User is now on the Notification page ","User is not in the Notification page","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

			}

			catch (Exception e)

			{
				repfn.FnUpdateTestStepResHTML("Verify User is navigated on the Pay bill page  ","User is not navigated on the Pay bill page due to some exception","FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}


		public synchronized boolean Q2Wall_FnValidateRoutingNumber(WebDriver driver,RunManagerInfo runManagerInfoObj){
		 	
		 	String invalidRoutingNumberOne = "1205484789";
		 	String invalidRoutingNumberTwo = "12054";
		 	String invalidRoutingNumberThree = "12adb%1&@";
		 	String errorMessage = "";
		 	boolean errorStatusOne = false;
		 	boolean errorStatusTwo = false;
		 	boolean errorStatusThree = false;
		 	
		 	try{
		 		
		 		driver.switchTo().frame("iFrameResizer0");
		 		
		 		if(cnf.FnExplicitWait("XPATH", mbo.Q2wall_RoutingNumber,driver)){
		 			repfn.FnUpdateTestStepResHTML("Verify Routing Number field is displayed under Payment Information option",
		   					"Routing Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
		 			WebElement RoutingNumber=driver.findElement(By.xpath(mbo.Q2wall_RoutingNumber));
		 			RoutingNumber.sendKeys(invalidRoutingNumberOne);
		 			repfn.FnUpdateTestStepResHTML("Verify Routing Number is entered with more than 9 digits","Routing Number :" +invalidRoutingNumberOne + "is entered  ","PASS",runManagerInfoObj);
		 			
		 			if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_CheckImg,driver)){
		   				WebElement Q2Wall_CheckImg=driver.findElement(By.xpath(mbo.Q2Wall_CheckImg));
		   				cnf.JSClick(Q2Wall_CheckImg,driver);
		   			}
		   			else{
		   				repfn.FnUpdateTestStepResHTML("Verify Check image is displayed and clicked","Check image is not displayed and clicked","FAIL",runManagerInfoObj);
		   				blnFlag=false;
		   			}
		 				
		 			
		 			
		 			if(cnf.FnExplicitWait("XPATH", mbo.RoutingNumberError,driver)){
		 				WebElement RoutingNumberError=driver.findElement(By.xpath(mbo.RoutingNumberError));
		 				errorMessage = RoutingNumberError.getAttribute("textContent");
		 				repfn.FnUpdateTestStepResHTML("Verify Routing Number Error Message is displayed ","Routing Number Error Message: " +errorMessage + "is displayed","PASS",runManagerInfoObj);
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
		 			repfn.FnUpdateTestStepResHTML("Verify Routing Number is entered with less than 9 digits","Routing Number " +invalidRoutingNumberTwo + "is entered  ","PASS",runManagerInfoObj);
		 			
		 			if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_CheckImg,driver)){
		   				WebElement Q2Wall_CheckImg=driver.findElement(By.xpath(mbo.Q2Wall_CheckImg));
		   				cnf.JSClick(Q2Wall_CheckImg,driver);
		   			}
		   			else{
		   				repfn.FnUpdateTestStepResHTML("Verify Check image is displayed and clicked","Check image is not displayed and clicked","FAIL",runManagerInfoObj);
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
		 			repfn.FnUpdateTestStepResHTML("Verify Routing Number is entered with specail characters","Routing Number " +invalidRoutingNumberThree + "is entered","PASS",runManagerInfoObj);
		 			
		 			if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_CheckImg,driver)){
		   				WebElement Q2Wall_CheckImg=driver.findElement(By.xpath(mbo.Q2Wall_CheckImg));
		   				cnf.JSClick(Q2Wall_CheckImg,driver);
		   				blnFlag=true;
		   			}
		   			else{
		   				repfn.FnUpdateTestStepResHTML("Verify Check image is displayed and clicked","Check image is not displayed and clicked","FAIL",runManagerInfoObj);
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

		public synchronized boolean Q2Wall_FnVerifyPayBillButton(WebDriver driver,RunManagerInfo runManagerInfoObj){
		 	
		 	try{
		 		
		 		driver.switchTo().frame("iFrameResizer0");
		 		Thread.sleep(2000);
		 		if(cnf.FnExplicitWait("XPATH", mbo.PayNowButton,driver)){
		 			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(mbo.PayNowButton)));   
		 			repfn.FnUpdateTestStepResHTML("Verify Pay Now button is displayed","Pay Now button is displayed","PASS",runManagerInfoObj);
		 			WebElement PayNowButton=driver.findElement(By.xpath(mbo.PayNowButton));
		 			//cnf.ScrollToView(PayNowButton);
		 			if(PayNowButton.isEnabled()){
		 				repfn.FnUpdateTestStepResHTML("Verify Pay Now button is enabled","Pay Now button is enabled.","FAIL",runManagerInfoObj);				
		 				blnFlag=false;
		 			}
		 			else{
		 				repfn.FnUpdateTestStepResHTML("Verify Pay Now button is enabled","Pay Now button is not enabled","PASS",runManagerInfoObj);
		 				blnFlag=true;
		 			}
		 		}
		 		else{
		 			if(cnf.FnExplicitWait("XPATH", mbo.PayNowButton_WG,driver)){
		 	 			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(mbo.PayNowButton)));   
		 	 			repfn.FnUpdateTestStepResHTML("Verify Pay Now button is displayed","Pay Now button is displayed","PASS",runManagerInfoObj);
		 	 			WebElement PayNowButton=driver.findElement(By.xpath(mbo.PayNowButton_WG));
		 	 			//cnf.ScrollToView(PayNowButton);
		 	 			if(PayNowButton.isEnabled()){
		 	 				repfn.FnUpdateTestStepResHTML("Verify Pay Now button is enabled","Pay Now button is enabled.","FAIL",runManagerInfoObj);				
		 	 				blnFlag=false;
		 	 			}
		 	 			else{
		 	 				repfn.FnUpdateTestStepResHTML("Verify Pay Now button is enabled","Pay Now button is not enabled","PASS",runManagerInfoObj);
		 	 				blnFlag=true;
		 	 			}
		 	 		}
		 	 		else{
		 	 			repfn.FnUpdateTestStepResHTML("Verify Pay Now button is displayed","Pay Now button is not displayed","FAIL",runManagerInfoObj);
		 	 			blnFlag=false;
		 	 		}
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


		public synchronized boolean Q2Wall_CancelbuttonClick(WebDriver driver,RunManagerInfo runManagerInfoObj){
			try{
				driver.switchTo().frame("iFrameResizer0");
				if(cnf.FnExplicitlessWait("Xpath",mbo.Q2wall_Cancelbutton,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Cancel button is displayed","Cancel button is displayed","PASS",runManagerInfoObj);
					WebElement Q2wall_Cancelbutton=driver.findElement(By.xpath(mbo.Q2wall_Cancelbutton));
					if(cnf.JSClick(Q2wall_Cancelbutton,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Cancel button is clicked","Cancel button is clicked","PASS",runManagerInfoObj);
						Thread.sleep(1000);

						if(cnf.isAlertPresent()){
							//driver.switchTo().alert();
							String ErrMsg=driver.switchTo().alert().getText();
							System.out.println(ErrMsg);
							//repfn.FnUpdateTestStepResHTML("verify .... ",".......","PASS/WARNING");// update the reporting function based on your requirement
							driver.switchTo().alert().accept();
							driver.switchTo().defaultContent();
						}
						else{
							//repfn.FnUpdateTestStepResHTML("verify .... ",".......","PASS/WARNING");// update the reporting function based on your requirement
							System.out.println("No alert present");                                              
						}
						
						Thread.sleep(3000);

						if(cnf.FnExplicitWait("Xpath",mbo.Q2Wall_AccountPastDueLabel,driver)){
							repfn.FnUpdateTestStepResHTML("Verify User is navigated back to Notification page ","User is navigated back to Notification page","PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User is navigated back to Notification page ","User is not navigated back to Notification page","FAIL",runManagerInfoObj);
							blnFlag=false;
						}

					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Cancel button is clicked","Cancel button is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}			
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Cancel button is displayed","Cancel button is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				driver.switchTo().defaultContent();

			}
			catch (Exception e)

			{
				repfn.FnUpdateTestStepResHTML("Verify Cancel button is displayed and clicked","Cancel button is not displayed and not clicked due to some exception","FAIL",runManagerInfoObj);

				blnFlag=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());

			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}


		public synchronized boolean Q2Wall_CancelClick(WebDriver driver,RunManagerInfo runManagerInfoObj){
			try{
				//driver.switchTo().frame("iFrameResizer0");
				if(cnf.FnExplicitlessWait("Xpath",mbo.Q2wall_Cancelbutton,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Cancel button is displayed","Cancel button is displayed","PASS",runManagerInfoObj);
					WebElement Q2wall_Cancelbutton=driver.findElement(By.xpath(mbo.Q2wall_Cancelbutton));
					if(cnf.ElementClick(Q2wall_Cancelbutton,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Cancel button is clicked","Cancel button is clicked","PASS",runManagerInfoObj);
						Thread.sleep(3000);

						if(cnf.isAlertPresent()){
							//driver.switchTo().alert();
							String ErrMsg=driver.switchTo().alert().getText();
							System.out.println(ErrMsg);
							//repfn.FnUpdateTestStepResHTML("verify .... ",".......","PASS/WARNING");// update the reporting function based on your requirement
							driver.switchTo().alert().accept();
							driver.switchTo().defaultContent();
							Thread.sleep(5000);
						}
						else{
							//repfn.FnUpdateTestStepResHTML("verify .... ",".......","PASS/WARNING");// update the reporting function based on your requirement
							System.out.println("No alert present");                                              
						}
						
					//	Thread.sleep(8000);

						if(cnf.FnExplicitWait("Xpath",mbo.Q2Wall_AccountPastDueLabel,driver)){
							repfn.FnUpdateTestStepResHTML("Verify User is navigated back to Notification page ","User is navigated back to Notification page","PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User is navigated back to Notification page ","User is not navigated back to Notification page","FAIL",runManagerInfoObj);
							blnFlag=false;
						}

					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Cancel button is clicked","Cancel button is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}			
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Cancel button is displayed","Cancel button is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

			}
			catch (Exception e)

			{
				repfn.FnUpdateTestStepResHTML("Verify Cancel button is displayed and clicked","Cancel button is not displayed and not clicked due to some exception","FAIL",runManagerInfoObj);

				blnFlag=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());

			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}


		public synchronized boolean Q2Wall_FnValidateBankAccountNumber(WebDriver driver,RunManagerInfo runManagerInfoObj){

			String invalidBankAccountNumber = "011a27!!56";
			String errorMessage = "";
			boolean errorStatusOne = false;

			try{

				driver.switchTo().frame("iFrameResizer0");

				if(cnf.FnExplicitWait("XPATH", mbo.Q2wall_BankAccountNumber,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Bank Account Number field is displayed under Payment Information option",
							"Bank Account Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
					WebElement BankAccountNumber=driver.findElement(By.xpath(mbo.Q2wall_BankAccountNumber));
					BankAccountNumber.sendKeys(invalidBankAccountNumber);
					repfn.FnUpdateTestStepResHTML("Verify Bank Account Number is entered with special character","Bank Account Number " +invalidBankAccountNumber + "is entered","PASS",runManagerInfoObj);

					if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_CheckImg,driver)){
						WebElement Q2Wall_CheckImg=driver.findElement(By.xpath(mbo.Q2Wall_CheckImg));
						cnf.JSClick(Q2Wall_CheckImg,driver);
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Check image is displayed and clicked","Check image is not displayed and clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}



					if(cnf.FnExplicitWait("XPATH", mbo.Q2wall_BankAccountNumberError,driver)){
						WebElement BankAccountNumberError=driver.findElement(By.xpath(mbo.Q2wall_BankAccountNumberError));
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
		public synchronized boolean fnPayBillPaymentTypeOptions(WebDriver driver,RunManagerInfo runManagerInfoObj) {
			try
			{
				driver.switchTo().frame("iFrameResizer0");
				Thread.sleep(1000);
				if(cnf.FnExplicitlessWait_untilClickable("ID",mbo.creditDebitCard,driver))
				{
					blnFlag=true;
					repfn.FnUpdateTestStepResHTML("Verify if Payment type option \"Credit/Debit Card\" in pay bill screen is present", "Payment type option \"Credit/Debit Card\" in pay bill screen  is present", "PASS",runManagerInfoObj);
				}
				else
				{
					blnFlag=false;
					repfn.FnUpdateTestStepResHTML("Verify if Payment type option \"Credit/Debit Card\" in pay bill screen is present", "Payment type option \"Credit/Debit Card\" in pay bill screen  is not present", "FAIL",runManagerInfoObj);
				}

				if(cnf.FnExplicitlessWait_untilClickable("ID",mbo.checkingSavingsAccount,driver))
				{
					blnFlag=true;
					repfn.FnUpdateTestStepResHTML("Verify if Payment type option \"Checking/Savings\" in pay bill screen is present", "Payment type option \"Checking/Savings\" in pay bill screen  is present", "PASS",runManagerInfoObj);
				}
				else
				{
					blnFlag=false;
					repfn.FnUpdateTestStepResHTML("Verify if Payment type option \"Checking/Savings\" in pay bill screen is present", "Payment type option \"Checking/Savings\" in pay bill screen  is not present", "FAIL",runManagerInfoObj);
				}

				if(cnf.FnExplicitlessWait_untilClickable("ID",mbo.otherPaymentOption,driver))
				{
					blnFlag=true;
					repfn.FnUpdateTestStepResHTML("Verify if Payment type option \"Other Payment Methods\" in pay bill screen  is present", "Payment type option \"Other Payment Methods\" in pay bill screen  is present", "PASS",runManagerInfoObj);
				}
				else
				{
					blnFlag=false;
					repfn.FnUpdateTestStepResHTML("Verify if Payment type option \"Other Payment Methods\" in pay bill screen is present", "Payment type option \"Other Payment Methods\" in pay bill screen  is not present", "FAIL",runManagerInfoObj);
				}
				driver.switchTo().defaultContent();


			}
			catch(Exception e)
			{

				blnFlag=false;
				repfn.FnUpdateTestStepResHTML("Verify if payment type options in pay bill screen is present", "Payment type options in pay bill screen  is not present due to some exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		public synchronized boolean fnPayBillPaymentFrequencyOptions(WebDriver driver,RunManagerInfo runManagerInfoObj) {
			try
			{
				driver.switchTo().frame("iFrameResizer0");
				if(cnf.FnExplicitWait("ID",mbo.autoPayId,driver))
				{
					blnFlag=true;
					repfn.FnUpdateTestStepResHTML("Verify if Payment frequency option \"Auto-Pay (Recurring)\" in pay bill screen  is present", "Payment frequency option \"Auto-Pay (Recurring)\" in pay bill screen  is present", "PASS",runManagerInfoObj);
				}
				else
				{
					blnFlag=false;
					repfn.FnUpdateTestStepResHTML("Verify if Payment frequency option \"Auto-Pay (Recurring)\" in pay bill screen  is present", "Payment frequency option \"Auto-Pay (Recurring)\" in pay bill screen  is not present", "FAIL",runManagerInfoObj);
				}
				if(cnf.FnExplicitWait("ID",mbo.oneTimePayment,driver))
				{
					blnFlag=true;
					repfn.FnUpdateTestStepResHTML("Verify if Payment frequency option \"One- Time\" in pay bill screen  is present", "Payment frequency option \"One- Time\" in pay bill screen  is present", "PASS",runManagerInfoObj);
				}
				else
				{
					blnFlag=false;
					repfn.FnUpdateTestStepResHTML("Verify if Payment frequency option \"One- Time\" in pay bill screen  is present", "Payment frequency option \"One- Time\" in pay bill screen  is not present", "FAIL",runManagerInfoObj);
				}
				driver.switchTo().defaultContent();

			}
			catch(Exception e)
			{
				blnFlag=false;
				repfn.FnUpdateTestStepResHTML("Verify if Payment frequency options in pay bill screen is present", "Payment frequency options  in pay bill screen  is not present due to some exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}


		public synchronized boolean EditPayAmnt_Errors(WebDriver driver,RunManagerInfo runManagerInfoObj)
		{
			try
			{
				driver.switchTo().frame("iFrameResizer0");
			
				EditPayAmnt_AlphabetsSymbols(driver,runManagerInfoObj);
				EditPayAmnt_EqualToZero(driver,runManagerInfoObj);
				EditPayAmnt_LessThanZero(driver,runManagerInfoObj);
				EditPayAmnt_GreaterThan25000(driver,runManagerInfoObj);
				//Q2Wall_CancelbuttonClick();
						
					}
			catch(Exception e)
			{
				System.err.println("Message : "+e.getMessage());
		        System.err.println("Cause : "+e.getCause());	
			}
			 m1.put("STEPSTATUS", blnFlag);
		     return blnFlag;

		}
		public synchronized boolean EditPayAmnt_AlphabetsSymbols(WebDriver driver,RunManagerInfo runManagerInfoObj)
		{
			try
			{
				
				if(cnf.FnExplicitWait("XPATH", mbo.Paybill_Amount,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if Payment Amount field is present", "Payment Amount field is present", "PASS",runManagerInfoObj);
					WebElement EditPay=driver.findElement(By.xpath(mbo.Paybill_Amount));
					if(EditPay.isDisplayed())
					{
						//Editcard.clear();
						EditPay.sendKeys("abc*d",Keys.TAB);
						repfn.FnUpdateTestStepResHTML("Enter a Payment amount which has alphabets and symbols in it", "Payment amount which has alphabets and symbols in it are entered: "+EditPay.getText(), "PASS",runManagerInfoObj);
						if(cnf.FnExplicitWait("XPATH", mbo.PayBill_AmountError,driver))
						{
							repfn.FnUpdateTestStepResHTML("Verify if error message is displayed", "Please enter an amount between $0 and $25,000. is displayed as the error message", "PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("XPATH", mbo.PayBill_Save,driver))
							{
								WebElement Save=driver.findElement(By.xpath(mbo.PayBill_Save));
							
								if(!Save.isEnabled())
								{
									repfn.FnUpdateTestStepResHTML("Verify if Pay Now button is enabled", "Pay Now button is not enabled", "PASS",runManagerInfoObj);
									blnFlag=true;
								}
								else
								{
									repfn.FnUpdateTestStepResHTML("Verify if Pay Now button is enabled", "Pay Now button is  enabled", "FAIL",runManagerInfoObj);
									blnFlag=false;	
								}
							}
						}
						else
						{
							repfn.FnUpdateTestStepResHTML("Verify if error message is displayed", "Error message is not displayed", "FAIL",runManagerInfoObj);
							
							blnFlag=false;
						}
						
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Enter a Payment amount which has alphabets and symbols in it", "Payment amount which has alphabets and symbols in it are not entered", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}

				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify if Payment Amount field is present", "Payment Amount field is not present", "FAIL",runManagerInfoObj);
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

		public synchronized boolean EditPayAmnt_EqualToZero(WebDriver driver,RunManagerInfo runManagerInfoObj)
		{
			try
			{
				
				if(cnf.FnExplicitWait("XPATH", mbo.Paybill_Amount,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if Payment Amount field is present", "Payment Amount field is present", "PASS",runManagerInfoObj);
					WebElement EditPay=driver.findElement(By.xpath(mbo.Paybill_Amount));
					if(EditPay.isDisplayed())
					{
						EditPay.clear();
						EditPay.sendKeys("0",Keys.TAB);
						repfn.FnUpdateTestStepResHTML("Enter the Payment amount as 0", "Payment amount is entered as 0", "PASS",runManagerInfoObj);
						if(cnf.FnExplicitWait("XPATH", mbo.PayBill_AmountError,driver))
						{
							repfn.FnUpdateTestStepResHTML("Verify if error message is displayed", "Please enter an amount between $0 and $25,000. is displayed as the error message", "PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("XPATH", mbo.PayBill_Save,driver))
							{
								WebElement Save=driver.findElement(By.xpath(mbo.PayBill_Save));
							
								if(!Save.isEnabled())
								{
									repfn.FnUpdateTestStepResHTML("Verify if Pay Now button is enabled", "Pay Now button is not enabled", "PASS",runManagerInfoObj);
									blnFlag=true;
								}
								else
								{
									repfn.FnUpdateTestStepResHTML("Verify if Pay Now button is enabled", "Pay Now button is  enabled", "FAIL",runManagerInfoObj);
									blnFlag=false;	
								}
							}
						}
						else
						{
							repfn.FnUpdateTestStepResHTML("Verify if error message is displayed", "Error message is not displayed", "FAIL",runManagerInfoObj);
							
							blnFlag=false;
						}
						
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Enter the Payment amount as 0", "Payment amount is not entered as 0", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}

				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify if Payment Amount field is present", "Payment Amount field is not present", "FAIL",runManagerInfoObj);
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

		public synchronized boolean EditPayAmnt_LessThanZero(WebDriver driver,RunManagerInfo runManagerInfoObj)
		{
			try
			{
				
				if(cnf.FnExplicitWait("XPATH", mbo.Paybill_Amount,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if Payment Amount field is present", "Payment Amount field is present", "PASS",runManagerInfoObj);
					WebElement EditPay=driver.findElement(By.xpath(mbo.Paybill_Amount));
					if(EditPay.isDisplayed())
					{
						EditPay.clear();
						EditPay.sendKeys("-1",Keys.TAB);
						repfn.FnUpdateTestStepResHTML("Enter the Payment amount less than 0", "A Payment amount less than 0 is entered"+EditPay.getText(), "PASS",runManagerInfoObj);
						if(cnf.FnExplicitWait("XPATH", mbo.PayBill_AmountError,driver))
						{
							repfn.FnUpdateTestStepResHTML("Verify if error message is displayed", "Please enter an amount between $0 and $25,000. is displayed as the error message", "PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("XPATH", mbo.PayBill_Save,driver))
							{
								WebElement Save=driver.findElement(By.xpath(mbo.PayBill_Save));
							
								if(!Save.isEnabled())
								{
									repfn.FnUpdateTestStepResHTML("Verify if Pay Now button is enabled", "Pay Now button is not enabled", "PASS",runManagerInfoObj);
									blnFlag=true;
								}
								else
								{
									repfn.FnUpdateTestStepResHTML("Verify if Pay Now button is enabled", "Pay Now button is  enabled", "FAIL",runManagerInfoObj);
									blnFlag=false;	
								}
							}
						}
						else
						{
							repfn.FnUpdateTestStepResHTML("Verify if error message is displayed", "Error message is not displayed", "FAIL",runManagerInfoObj);
							
							blnFlag=false;
						}
						
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Enter the Payment amount less than 0", "A Payment amount less than 0 is not entered", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}

				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify if Payment Amount field is present", "Payment Amount field is not present", "FAIL",runManagerInfoObj);
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

		public synchronized boolean EditPayAmnt_GreaterThan25000(WebDriver driver,RunManagerInfo runManagerInfoObj)
		{
			try
			{
				
				if(cnf.FnExplicitWait("XPATH", mbo.Paybill_Amount,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if Payment Amount field is present", "Payment Amount field is present", "PASS",runManagerInfoObj);
					WebElement EditPay=driver.findElement(By.xpath(mbo.Paybill_Amount));
					if(EditPay.isDisplayed())
					{
						EditPay.clear();
						EditPay.sendKeys("25001",Keys.TAB);
						repfn.FnUpdateTestStepResHTML("Enter the Payment amount greater than 25000", "A Payment amount greater than 25000 is entered"+EditPay.getText(), "PASS",runManagerInfoObj);
						if(cnf.FnExplicitWait("XPATH", mbo.PayBill_AmountError,driver))
						{
							repfn.FnUpdateTestStepResHTML("Verify if error message is displayed", "Please enter an amount between $0 and $25,000. is displayed as the error message", "PASS",runManagerInfoObj);
							
							if(cnf.FnExplicitWait("XPATH", mbo.PayBill_Save,driver))
							{
								WebElement Save=driver.findElement(By.xpath(mbo.PayBill_Save));
							
								if(!Save.isEnabled())
								{
									repfn.FnUpdateTestStepResHTML("Verify if Pay Now button is enabled", "Pay Now button is not enabled", "PASS",runManagerInfoObj);
									blnFlag=true;
								}
								else
								{
									repfn.FnUpdateTestStepResHTML("Verify if Pay Now button is enabled", "Pay Now button is  enabled", "FAIL",runManagerInfoObj);
									blnFlag=false;	
								}
							}
						}
						else
						{
							repfn.FnUpdateTestStepResHTML("Verify if error message is displayed", "Error message is not displayed", "FAIL",runManagerInfoObj);
							
							blnFlag=false;
						}
						
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Enter the Payment amount greater than 25000", "A Payment amount greater than 25000 is not entered", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}

				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify if Payment Amount field is present", "Payment Amount field is not present", "FAIL",runManagerInfoObj);
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


		public synchronized boolean Q2Wall_FnValidatePaymentAmount(WebDriver driver,RunManagerInfo runManagerInfoObj){
		   	
		   	String invalidPaymentAmountOne = "0.1";
		   	String invalidPaymentAmountTwo = "2500000";
		   	String invalidPaymentAmountThree = "abc@#$";
		   	String errorMessage = "";
		   	boolean errorStatusOne = false;
		   	boolean errorStatusTwo = false;
		   	boolean errorStatusThree = false;
		   	
		   	try{
		   		
		   		driver.switchTo().frame("iFrameResizer0");
		   		
		   		if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_PaymentAmount,driver)){
		   			repfn.FnUpdateTestStepResHTML("Verify Payment Amount field is displayed under Payment Information option",
		     					"Payment Amount field is displayed under Payment Information option","PASS",runManagerInfoObj);
		   			WebElement PaymentAmount=driver.findElement(By.xpath(mbo.Q2Wall_PaymentAmount));
		   			PaymentAmount.sendKeys("250");
		   			PaymentAmount.clear();
		   			PaymentAmount.sendKeys(invalidPaymentAmountOne);
		   			repfn.FnUpdateTestStepResHTML("Verify Payment Amount is entered with less than $1","Payment Amount :" +invalidPaymentAmountOne + "is entered  ","PASS",runManagerInfoObj);
		   			
		   			if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_CheckImg,driver)){
		   				WebElement Q2Wall_CheckImg=driver.findElement(By.xpath(mbo.Q2Wall_CheckImg));
		   				cnf.JSClick(Q2Wall_CheckImg,driver);
		   			}
		   			else{
		   				repfn.FnUpdateTestStepResHTML("Verify Check image is displayed and clicked","Check image is not displayed and clicked","FAIL",runManagerInfoObj);
		   				blnFlag=false;
		   			}
		   				
		   			
		   			
		   			if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_paymentAmountError,driver)){
		   				WebElement Q2Wall_paymentAmountError=driver.findElement(By.xpath(mbo.Q2Wall_paymentAmountError));
		   				errorMessage = Q2Wall_paymentAmountError.getAttribute("textContent");
		   				repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed ","Payment Amount Error Message: " +errorMessage + "is displayed","PASS",runManagerInfoObj);
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
		   			repfn.FnUpdateTestStepResHTML("Verify Payment Amount is entered with greater than $25000","Routing Number " +invalidPaymentAmountTwo + "is entered  ","PASS",runManagerInfoObj);
		   			
		   			
		   			if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_CheckImg,driver)){
		   				WebElement Q2Wall_CheckImg=driver.findElement(By.xpath(mbo.Q2Wall_CheckImg));
		   				cnf.JSClick(Q2Wall_CheckImg,driver);
		   			}
		   			else{
		   				repfn.FnUpdateTestStepResHTML("Verify Check image is displayed and clicked","Check image is not displayed and clicked","FAIL",runManagerInfoObj);
		   				blnFlag=false;
		   			}
		   				
		   			
		   			if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_paymentAmountError,driver)){
		   				WebElement Q2Wall_paymentAmountError=driver.findElement(By.xpath(mbo.Q2Wall_paymentAmountError));
		   				errorMessage = Q2Wall_paymentAmountError.getAttribute("textContent");
		   				repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed","Payment Amount Error Message: " +errorMessage + "is displayed","PASS",runManagerInfoObj);
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
		   			repfn.FnUpdateTestStepResHTML("Verify Payment Amount is entered with special/Alaphabets characters","Routing Number " +invalidPaymentAmountThree + "is entered","PASS",runManagerInfoObj);
		   			
		   			
		   			if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_CheckImg,driver)){
		   				WebElement Q2Wall_CheckImg=driver.findElement(By.xpath(mbo.Q2Wall_CheckImg));
		       			cnf.JSClick(Q2Wall_CheckImg,driver);
		   			}
		   			else{
		   				repfn.FnUpdateTestStepResHTML("Verify Check image is displayed and clicked","Check image is not displayed and clicked","FAIL",runManagerInfoObj);
		   				blnFlag=false;
		   			}
		   				
		   			
		   			if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_paymentAmountError,driver)){
		   				WebElement Q2Wall_paymentAmountError=driver.findElement(By.xpath(mbo.Q2Wall_paymentAmountError));
		   				errorMessage = Q2Wall_paymentAmountError.getAttribute("textContent");
		   				repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed ","Routing Number Error Message is displayed:  " +errorMessage,"PASS",runManagerInfoObj);
		   				blnFlag=true;
		   				errorStatusThree = true;
		   				
		   			}
		   			else{
		   				repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed",
		   						"Payment Amount Error Message is not displayed when this number is entered: " +invalidPaymentAmountThree,"FAIL",runManagerInfoObj);
		   				blnFlag=false;
		   			}
		   			
		   			if(errorStatusOne && errorStatusTwo && errorStatusThree){
		   				repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed for all the three invalid Payment Amount",
		   						"Payment Amount Error Message is displayed for all the three invalid Routing numbers","PASS",runManagerInfoObj);
		   				blnFlag=true;
		   			}
		   			else{
		   				repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed for all the three invalid Payment Amount",
		   						"Payment Amount Error Message is not displayed for all the three invalid Routing numbers","FAIL",runManagerInfoObj);
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
		public synchronized boolean VerifyPayBillScreen(WebDriver driver,RunManagerInfo runManagerInfoObj)
		{
			try
			{
				driver.switchTo().frame("iFrameResizer0");
				if(cnf.FnExplicitWait("XPATH",mbo.Q2Wall_PayBillScreen,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Current bill section in pay bill screen", "Current bill section is present in pay bill screen", "PASS",runManagerInfoObj);


					if(cnf.isElementExist(By.xpath(mbo.Q2Wall_PayBill_AccNumTitle),driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Account number title in pay bill screen", "Account number title is present in pay bill screen:"+" "+driver.findElement(By.xpath(mbo.Q2Wall_PayBill_AccNumTitle)).getText(), "PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Account number title in pay bill screen", "Account number title is not present in pay bill screen", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					if(cnf.isElementExist(By.xpath(mbo.Q2Wall_PayBill_AccNum),driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Account number in pay bill screen", "Account number is present in pay bill screen:"+" "+driver.findElement(By.xpath(mbo.Q2Wall_PayBill_AccNum)).getText(), "PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Account number in pay bill screen", "Account number is not present in pay bill screen", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					if(cnf.isElementExist(By.xpath(mbo.Q2Wall_PayBill_CurrentBillAmt),driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Current bill amount in pay bill screen", "Current Bill amount is present in pay bill screen:"+" "+driver.findElement(By.xpath(mbo.Q2Wall_PayBill_CurrentBillAmt)).getText(), "PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Current bill amount in pay bill screen", "Current Bill amount is not present in pay bill screen", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					if(cnf.isElementExist(By.xpath(mbo.Q2Wall_PayBill_StatementTitle),driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Statement title in pay bill screen", "Statement title is present in pay bill screen:"+" "+driver.findElement(By.xpath(mbo.Q2Wall_PayBill_StatementTitle)).getText(), "PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Statement title in pay bill screen", "Statement title is not present in pay bill screen", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					if(cnf.isElementExist(By.xpath(mbo.Q2Wall_PayBill_StatementDate),driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Statement date in pay bill screen", "Statement date is present in pay bill screen:"+" "+driver.findElement(By.xpath(mbo.Q2Wall_PayBill_StatementDate)).getText(), "PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Statement date in pay bill screen", "Statement date is not present in pay bill screen", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					if(cnf.isElementExist(By.xpath(mbo.Q2Wall_PayBill_DueByTitle),driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Due by title in pay bill screen", "Due By title is present in pay bill screen:"+" "+driver.findElement(By.xpath(mbo.Q2Wall_PayBill_DueByTitle)).getText(), "PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Due By title in pay bill screen", "Due by title is not present in pay bill screen", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					if(cnf.isElementExist(By.xpath(mbo.Q2Wall_PayBill_DueBy),driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Due by date in pay bill screen", "Due by date is present in pay bill screen"+" "+driver.findElement(By.xpath(mbo.Q2Wall_PayBill_DueBy)).getText(), "PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Due by date in pay bill screen", "Due by date is not present in pay bill screen", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Current bill section in pay bill screen", "Current bill section is not present in pay bill screen", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				driver.switchTo().defaultContent();

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
		public synchronized boolean CreditDebitPaymentOptionDefault(WebDriver driver,RunManagerInfo runManagerInfoObj)
		{
			try
			{
				driver.switchTo().frame("iFrameResizer0");
				if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_PayBill_SelectPaymentType,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Select payment type section in pay bill screen", "Select payment type section is present in pay bill screen", "PASS",runManagerInfoObj);
					if(cnf.isElementExist(By.xpath(mbo.Q2Wall_PayBill_CreditDebitOption),driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Credit/Debit option", "Credit/Debit option is present", "PASS",runManagerInfoObj);
						if(cnf.isElementExist(By.xpath(mbo.Q2Wall_PayBill_CreditDebitRadioBtn),driver))
						{
							repfn.FnUpdateTestStepResHTML("Verify the presence of Credit/Debit radio button", "Credit/Debit radio button is present", "PASS",runManagerInfoObj);
							if(driver.findElement(By.xpath(mbo.Q2Wall_PayBill_CreditDebitRadioBtn)).getAttribute("aria-checked").equalsIgnoreCase("true"))
							{
								repfn.FnUpdateTestStepResHTML("Verify the Credit/Debit radio button is selected by default", "Credit/Debit radio button is selected by default", "PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify the Credit/Debit radio button is selected by default", "Credit/Debit radio button is not selected by default", "FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else
						{
							repfn.FnUpdateTestStepResHTML("Verify the presence of Credit/Debit radio button", "Credit/Debit radio button is not present", "FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Credit/Debit option", "Credit/Debit option is not present", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Select payment type section in pay bill screen", "Select payment type section is not present in pay bill screen", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				driver.switchTo().defaultContent();
			}
			catch (Exception e)

			{
				repfn.FnUpdateTestStepResHTML("Verify Credit/Debit option is selected by default","Credit/Debit option is not selected by default due to some exception ","FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		public synchronized boolean OTPDefault(WebDriver driver,RunManagerInfo runManagerInfoObj)
		{
			try
			{
				driver.switchTo().frame("iFrameResizer0");
				if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_PayBill_PaymentFreq,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Payment frequency section in pay bill screen", "Payment frequency section is present in pay bill screen", "PASS",runManagerInfoObj);
					if(cnf.isElementExist(By.xpath(mbo.Q2Wall_PayBill_OTPOption),driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of OTP option", "OTP option is present", "PASS",runManagerInfoObj);
						if(cnf.isElementExist(By.xpath(mbo.Q2Wall_PayBill_OTPRadioBtn),driver))
						{
							repfn.FnUpdateTestStepResHTML("Verify the presence of OTP radio button", "OTP radio button is present", "PASS",runManagerInfoObj);
							if(driver.findElement(By.xpath(mbo.Q2Wall_PayBill_OTPRadioBtn)).getAttribute("aria-checked").equalsIgnoreCase("true"))
							{
								repfn.FnUpdateTestStepResHTML("Verify the OTP radio button is selected by default", "OTP radio button is selected by default", "PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify the OTP radio button is selected by default", "OTP radio button is not selected by default", "FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else
						{
							repfn.FnUpdateTestStepResHTML("Verify the presence of OTP radio button", "OTP radio button is not present", "FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of OTP option", "OTP option is not present", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Payment frequency section in pay bill screen", "Payment frequency section is not present in pay bill screen", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				driver.switchTo().defaultContent();

			}
			catch (Exception e)

			{
				repfn.FnUpdateTestStepResHTML("Verify OTP option is selected by default","OTP option is not selected by default due to some exception ","FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		
		public synchronized boolean FnValidateEditPaymentOption_CreditDebit_WG(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{

			Date d=Calendar.getInstance().getTime();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

			String currentDate=sdf.format(d);

			String dateArray[]=currentDate.split("/");
			String year=dateArray[0];
			String month=dateArray[1];
			String day=dateArray[2];
			String CurrentPaymentDate = (month)+"/"+(day)+"/"+year;
			String CurrentPaymentDateChrome = (month)+"/"+(day);
			String expMonthOne = null;
			System.out.println(CurrentPaymentDate);
			System.out.println(CurrentPaymentDateChrome);

		    String errorMessage = " ";

			String errorStatusThree = "Please enter a valid payment date.";

			try{
				
				driver.switchTo().frame("iFrameResizer0");

				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_CardNum,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if Card Number field is displayed", "Card Number field is displayed", "PASS",runManagerInfoObj);
					String CardNumber=m1.get("CardNumber").toString();
					WebElement Card=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_CardNum));
					if(Card.isDisplayed())
					{
						Card.sendKeys(CardNumber,Keys.TAB);
						repfn.FnUpdateTestStepResHTML("Enter a valid Credit/Debit Card number","Credit/Debit Card number is entered" , "PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Enter a valid Credit/Debit Card number","Credit/Debit Card number is not entered" , "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify if Card Number field is displayed", "Card Number field is not displayed", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}


				String ExpMonth=m1.get("ExpMonth").toString();
				System.out.println("0"+ExpMonth);
				int expMonth = Integer.parseInt(ExpMonth);

				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_ExpMonth,driver))
				{
					if((expMonth)<10){
						expMonthOne = "0"+ExpMonth;
						System.out.println(expMonthOne);
					}
					else{
						expMonthOne = ExpMonth;
					}
					
					WebElement ExpDate_Month=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_ExpMonth));
					ExpDate_Month.sendKeys(expMonthOne,Keys.TAB);
					repfn.FnUpdateTestStepResHTML("Click on a particular month", "A particular month is selected", "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Click on a particular month", "A particular month is selected", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				String ExpYear=m1.get("ExpYear").toString();
				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_ExpYear,driver))
				{
					WebElement PayBill_CreditDebit_ExpYear=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_ExpYear));
					PayBill_CreditDebit_ExpYear.sendKeys(ExpYear,Keys.TAB);
					repfn.FnUpdateTestStepResHTML("Click on a particular year", "A particular year is selected", "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Click on a particular year", "A particular year is selected", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				String Amount=m1.get("Amount").toString();
				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_Amount,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if Payment Amount field is displayed", "Payment Amount field is displayed", "PASS",runManagerInfoObj);
					WebElement PayBill_CreditDebit_Amount=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_Amount));
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


				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_PayDate,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Payment Date field is displayed under Payment Information option",
							"Payment Amount Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
					WebElement PayBill_CreditDebit_PayDate=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_PayDate));


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

					/*               if(cnf.FnExplicitlessWait_untilClickable("XPATH", mbo.billingPayNowButton))
						 {
							 WebElement payNow=driver.findElement(By.xpath(mbo.billingPayNowButton));
							 cnf.JSClick(payNow);

							 Thread.sleep(5000);
							 blnFlag=true;
							 repfn.FnUpdateTestStepResHTML("Verify if user has clicked the pay now button", "User has clicked the pay now button", "PASS",runManagerInfoObj);
							 if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader)){
			                     WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
			                     cnf.JSClick(PaymentInformationHeader);
			                     blnFlag=true;
			               }
			               else{
			                     repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
			                     blnFlag=false;
			               }
						 }
						 else
						 {
							 blnFlag=false;
							 repfn.FnUpdateTestStepResHTML("Verify if user has clicked the pay now button", "User has not clicked the pay now button", "FAIL",runManagerInfoObj);
						 }*/

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
		public synchronized boolean Q2Wall_FnValidateBlankFeildErrorMsg_CardNumber(WebDriver driver,RunManagerInfo runManagerInfoObj){

			String errorMessage = "";

			try{

				driver.switchTo().frame("iFrameResizer0");

				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_CardNum,driver)){
					repfn.FnUpdateTestStepResHTML("Verify if Card Number field is displayed", "Card Number field is displayed", "PASS",runManagerInfoObj);
					WebElement PayBill_CreditDebit_CardNum=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_CardNum));
					PayBill_CreditDebit_CardNum.click();
					PayBill_CreditDebit_CardNum.sendKeys(Keys.TAB);
					repfn.FnUpdateTestStepResHTML("Leave the Card Number text entry field blank and try to proceed.","Card Number field is left blank  ","PASS",runManagerInfoObj);

					Thread.sleep(2000);

					if(cnf.FnExplicitWait("XPATH", mbo.CardNumberError,driver)){
						WebElement CardNumberError=driver.findElement(By.xpath(mbo.CardNumberError));
						errorMessage = CardNumberError.getAttribute("textContent");
						repfn.FnUpdateTestStepResHTML("Verify Card Number Error Message is displayed ","Card Number Error Message: " +errorMessage + "is displayed when Routing Number feild is left blank","PASS",runManagerInfoObj);
						blnFlag=true; 				
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Card Number Error Message is displayed",
								"Card Number Error Message is not displayed when Routing Number feild is left blank  " ,"FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify if Card Number field is displayed", "Card Number field is not displayed", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}

			catch (Exception e)

			{
				repfn.FnUpdateTestStepResHTML("Verify Card Number Error Message is displayed",
						"Card Number Error Message is not displayed due to some exception  " ,"FAIL",runManagerInfoObj);
				blnFlag=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());

			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}

		public synchronized boolean Q2Wall_FnValidateBlankFeildErrorMsg_ExpiryDate(WebDriver driver,RunManagerInfo runManagerInfoObj){

			String errorMessage = "";

			try{


				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_ExpMonth,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Expiration Date field is displayed under Payment Information option",
							"Expiration Date field is displayed under Payment Information option","PASS",runManagerInfoObj);
					WebElement PayBill_CreditDebit_ExpMonth=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_ExpMonth));
					PayBill_CreditDebit_ExpMonth.click();
					PayBill_CreditDebit_ExpMonth.sendKeys(Keys.TAB);
					repfn.FnUpdateTestStepResHTML("Leave the Expiration Date text entry field blank and try to proceed.","Expiration Date feild is left blank  ","PASS",runManagerInfoObj);

					Thread.sleep(2000);

					if(cnf.FnExplicitWait("XPATH", mbo.ExpirationDateError,driver)){
						WebElement ExpirationDateError=driver.findElement(By.xpath(mbo.ExpirationDateError));
						errorMessage = ExpirationDateError.getAttribute("textContent");
						repfn.FnUpdateTestStepResHTML("Verify Expiration Date Error Message is displayed ","Expiration Date Error Message: " +errorMessage + "is displayed when Routing Number feild is left blank","PASS",runManagerInfoObj);
						blnFlag=true; 				
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Expiration Date Error Message is displayed",
								"Expiration Date Error Message is not displayed when Routing Number feild is left blank  " ,"FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Expiration Date field is displayed under Payment Information option",
							"Expiration Date field is not  displayed under Payment Information option","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}

			catch (Exception e)

			{
				repfn.FnUpdateTestStepResHTML("Verify Expiration Date Error Message is displayed",
						"Expiration Date Error Message is not displayed due to some exception  " ,"FAIL",runManagerInfoObj);
				blnFlag=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());

			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}
		public synchronized boolean FnClickPayBillButtonAndVerify_CreditDebit_WG_EditLink(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{

			String cardNumberOne = "";
			String paymentDateOne = "";
			String cardNumber = "";
			String expirationMonth = "";
			String expirationYear = "";
			String expirationDate = "";
			String paymentAmount = "";
			String paymentDate = "";
			String month = "";
			String day = "";
			String year = "";

			try{

				driver.switchTo().frame("iFrameResizer0");

				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_CardNum,driver)){
					WebElement PayBill_CreditDebit_CardNum=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_CardNum));
					cardNumberOne = PayBill_CreditDebit_CardNum.getAttribute("value");       
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

				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_ExpMonth,driver)){
					WebElement ExpDate_Month=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_ExpMonth));
					expirationMonth = ExpDate_Month.getAttribute("value");
					if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_ExpYear,driver)){
						WebElement PayBill_CreditDebit_ExpYear=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_ExpYear));
						expirationYear = PayBill_CreditDebit_ExpYear.getAttribute("value");
						expirationDate = expirationMonth+"/"+expirationYear;
						System.out.println(expirationDate);
						blnFlag=true;
					}	               
				} 
				else{
					repfn.FnUpdateTestStepResHTML("Verify Expiration Date field is displayed under Payment Information option",
							"Expiration Date field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_Amount,driver)){
					WebElement PaymentAmount=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_Amount));
					paymentAmount = PaymentAmount.getAttribute("value");
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Payment Amount field is displayed under Payment Information option",
							"Payment Amount Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_PayDate,driver)){
					WebElement PaymentDate=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_PayDate));
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
						paymentDate = month+"/"+day;

					}else {
						String[] one = paymentDateOne.split("/");
						month = one[0];
						day = one[1];
						String yearOne = one[2];
						year = yearOne.substring((2));
						paymentDate = month+"/"+day+"/"+year;
					}

					System.out.println("Final payment date: "+paymentDate);
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
							if(cnf.FnExplicitWait("XPATH", mbo.VerifyPay_Heading,driver))
							{
								repfn.FnUpdateTestStepResHTML("Check if Verify Payment Information heading is displayed", "Verify Payment Information heading is displayed", "PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Check if Verify Payment Information heading is displayed", "Verify Payment Information heading is not displayed", "FAIL",runManagerInfoObj);
								blnFlag=false; 
							}

							if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentInfo_Hdr,driver))
							{
								repfn.FnUpdateTestStepResHTML("Check if Payment Summary sub-heading  is displayed", "Payment Summary sub- heading is displayed", "PASS",runManagerInfoObj);

								if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_VerifyCard,driver)){
									WebElement PayBill_CreditDebit_VerifyCard=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_VerifyCard));
									if(PayBill_CreditDebit_VerifyCard.getAttribute("textContent").contains(cardNumber)){
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

								if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_VerifyExp,driver)){
									WebElement PayBill_CreditDebit_VerifyExp=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_VerifyExp));
									if(PayBill_CreditDebit_VerifyExp.getAttribute("textContent").contains(expirationDate)){
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

								if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_VerifyAmnt,driver)){
									WebElement PayBill_CreditDebit_VerifyAmnt=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_VerifyAmnt));
									if(PayBill_CreditDebit_VerifyAmnt.getAttribute("textContent").contains(paymentAmount)){
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

								if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_VerifyPayDate,driver)){
									WebElement PayBill_CreditDebit_VerifyPayDate=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_VerifyPayDate));
									System.out.println(PayBill_CreditDebit_VerifyPayDate.getAttribute("textContent"));
									if(PayBill_CreditDebit_VerifyPayDate.getAttribute("textContent").contains(paymentDate)){
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

								if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentInfo_EditPayLink,driver)){
									repfn.FnUpdateTestStepResHTML("Verify Edit Payment Details link is displayed","Edit Payment Details link is displayed","PASS",runManagerInfoObj);
									WebElement VerifyPaymentInfo_EditPayLink=driver.findElement(By.xpath(mbo.VerifyPaymentInfo_EditPayLink));
									if(cnf.JSClick(VerifyPaymentInfo_EditPayLink,driver)){
										repfn.FnUpdateTestStepResHTML("Verify Edit Payment Details link is clicked","Edit Payment Details link is clicked","PASS",runManagerInfoObj);

										Thread.sleep(5000);
										
										driver.switchTo().defaultContent();

										blnFlag = Q2Wall_Fn_ConfirmationPop(driver,runManagerInfoObj);
										
										driver.switchTo().frame("iFrameResizer0");

										if(blnFlag){

											if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_CardNum,driver)){
												WebElement PayBill_CreditDebit_CardNum=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_CardNum));
												if(PayBill_CreditDebit_CardNum.getAttribute("value").equalsIgnoreCase(cardNumberOne)){
													repfn.FnUpdateTestStepResHTML("Verify Previously entered Card Number is pre-populated in Card Number field",
															"Previously entered Card Number is pre-populated in Card Number field","PASS",runManagerInfoObj);
													blnFlag=true;
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify Previously entered Card Number is pre-populated in Routing Number field",
															"Previously entered Card Number is not pre-populated in Routing Number field","FAIL",runManagerInfoObj);
													blnFlag=false;
												}
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify Card Number field is displayed","Card Number field is not displayed","FAIL",runManagerInfoObj);
												blnFlag=false;
											}
											
											

											if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_ExpMonth,driver)){
												WebElement PayBill_CreditDebit_ExpMonth=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_ExpMonth));
												if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_ExpYear,driver)){
													WebElement PayBill_CreditDebit_ExpYear=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_ExpYear));
													if(PayBill_CreditDebit_ExpMonth.getAttribute("value").contains(expirationMonth) && 
														PayBill_CreditDebit_ExpYear.getAttribute("value").contains(expirationYear)){
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
													repfn.FnUpdateTestStepResHTML("Verify Expiration Year field is displayed","Expiration Year field is not displayed","FAIL",runManagerInfoObj);
													blnFlag=false;
												}
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify Expiration Month field is displayed","Expiration Month field is not displayed","FAIL",runManagerInfoObj);
												blnFlag=false;
											}

											if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_Amount,driver)){
												WebElement PaymentAmount=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_Amount));
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

											if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_PayDate,driver)){
												WebElement PaymentDate=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_PayDate));
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
											repfn.FnUpdateTestStepResHTML("Verify User is navigated back to the Pay Bill screen ","User is not navigated back to the Pay Bill screen ","FAIL",runManagerInfoObj);
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
							else
							{
								repfn.FnUpdateTestStepResHTML("Check if Payment Summary sub-heading  is displayed", "Payment Summary sub- heading is not displayed", "FAIL",runManagerInfoObj);
								blnFlag=false; 
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
		public synchronized boolean FnClickPayBillButtonAndVerify_CreditDebit_WG(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{

			String cardNumberOne = "";
			String paymentDateOne = "";
			String cardNumber = "";
			String expirationMonth = "";
			String expirationYear = "";
			String expirationDate = "";
			String paymentAmount = "";
			String paymentDate = "";
			String month = "";
			String day = "";
			String year = "";

			try{

				driver.switchTo().frame("iFrameResizer0");

				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_CardNum,driver)){
					WebElement PayBill_CreditDebit_CardNum=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_CardNum));
					cardNumberOne = PayBill_CreditDebit_CardNum.getAttribute("value");       
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

				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_ExpMonth,driver)){
					WebElement ExpDate_Month=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_ExpMonth));
					expirationMonth = ExpDate_Month.getAttribute("value");
					if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_ExpYear,driver)){
						WebElement PayBill_CreditDebit_ExpYear=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_ExpYear));
						expirationYear = PayBill_CreditDebit_ExpYear.getAttribute("value");
						expirationDate = expirationMonth+"/"+expirationYear;
						System.out.println(expirationDate);
						blnFlag=true;
					}	               
				} 
				else{
					repfn.FnUpdateTestStepResHTML("Verify Expiration Date field is displayed under Payment Information option",
							"Expiration Date field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_Amount,driver)){
					WebElement PayBill_CreditDebit_Amount=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_Amount));
					paymentAmount = PayBill_CreditDebit_Amount.getAttribute("value");
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Payment Amount field is displayed under Payment Information option",
							"Payment Amount Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_PayDate,driver)){
					WebElement PayBill_CreditDebit_PayDate=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_PayDate));
					paymentDateOne = PayBill_CreditDebit_PayDate.getAttribute("value");
					System.out.println("payment date: "+paymentDateOne);
					String Browser=m1.get("BROWSER").toString();
					System.out.println("Browser is:   "+Browser);
					if(Browser.equalsIgnoreCase("chrome"))
					{
						String[] one = paymentDateOne.split("-");
						month = one[1];
						day = one[2];
						String yearOne = one[0];
						year = yearOne.substring((2));
						paymentDate = month+"/"+day;

					}else {
						String[] one = paymentDateOne.split("/");
						month = one[0];
						day = one[1];
						String yearOne = one[2];
						year = yearOne.substring((2));
						paymentDate = month+"/"+day+"/"+year;
					}

					System.out.println("Final payment date: "+paymentDate);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Payment Date field is displayed under Payment Information option",
							"Payment Date field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				Thread.sleep(5000);
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
							if(cnf.FnExplicitWait("XPATH", mbo.VerifyPay_Heading,driver))
							{
								repfn.FnUpdateTestStepResHTML("Check if Verify Payment Information heading is displayed", "Verify Payment Information heading is displayed", "PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Check if Verify Payment Information heading is displayed", "Verify Payment Information heading is not displayed", "FAIL",runManagerInfoObj);
								blnFlag=false; 
							}

							if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentInfo_Hdr,driver))
							{
								repfn.FnUpdateTestStepResHTML("Check if Payment Summary sub-heading  is displayed", "Payment Summary sub- heading is displayed", "PASS",runManagerInfoObj);

								if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_VerifyCard,driver)){
									WebElement PayBill_CreditDebit_VerifyCard=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_VerifyCard));
									if(PayBill_CreditDebit_VerifyCard.getAttribute("textContent").contains(cardNumber)){
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

								if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_VerifyExp,driver)){
									WebElement PayBill_CreditDebit_VerifyExp=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_VerifyExp));
									if(PayBill_CreditDebit_VerifyExp.getAttribute("textContent").contains(expirationDate)){
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

								if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_VerifyAmnt,driver)){
									WebElement PayBill_CreditDebit_VerifyAmnt=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_VerifyAmnt));
									if(PayBill_CreditDebit_VerifyAmnt.getAttribute("textContent").contains(paymentAmount)){
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

								if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_VerifyPayDate,driver)){
									WebElement PayBill_CreditDebit_VerifyPayDate=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_VerifyPayDate));
									System.out.println(PayBill_CreditDebit_VerifyPayDate.getAttribute("textContent"));
									if(PayBill_CreditDebit_VerifyPayDate.getAttribute("textContent").contains(paymentDate)){
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

								if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentInfo_EditPayLink,driver))
								{
									repfn.FnUpdateTestStepResHTML("Verify if Edit Pay Link is present", "Edit Pay Link is present", "PASS",runManagerInfoObj);
									blnFlag=true;
								}
								else
								{
									repfn.FnUpdateTestStepResHTML("Verify if Edit Pay Link is present", "Edit Pay Link is not present", "FAIL",runManagerInfoObj);
									blnFlag=false;
								}
								if(cnf.FnExplicitWait("XPATH", mbo.CreditDebit_VerifyPay_Cancel,driver))
								{
									repfn.FnUpdateTestStepResHTML("Verify if Cancel button is present", "Cancel payment button is present", "PASS",runManagerInfoObj);
									blnFlag=true;
								}
								else
								{
									repfn.FnUpdateTestStepResHTML("Verify if Cancel button is present", "Cancel payment button is not present", "FAIL",runManagerInfoObj);
									blnFlag=false;
								}

								if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentInfo_CompletePaymentBtn,driver))
								{
									repfn.FnUpdateTestStepResHTML("Verify if Complete Payment button is present", "Complete payment button is present", "PASS",runManagerInfoObj);
									blnFlag=true;
								}
								else
								{
									repfn.FnUpdateTestStepResHTML("Verify if Complete Payment button is present", "Complete Payment button is not present", "FAIL",runManagerInfoObj);
									blnFlag=false;
								}

							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Check if Payment Summary sub-heading  is displayed", "Payment Summary sub- heading is not displayed", "FAIL",runManagerInfoObj);
								blnFlag=false; 
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

		public synchronized boolean FnClickPayBillButtonAndVerify_CheckingSavings_WG(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{

			String routingNumberOne = "";
			String paymentDateOne = "";
			String routingNumber = "";
			String accountNumberOne = "";
			String accountNumberTwo = "";
			String expirationDate = "";
			String paymentAmount = "";
			String paymentDate = "";
			String month = "";
			String day = "";
			String year = "";

			try{

				driver.switchTo().frame("iFrameResizer0");

				if(cnf.FnExplicitWait("XPATH", mbo.Q2wall_RoutingNumber,driver)){
					WebElement Q2wall_RoutingNumber=driver.findElement(By.xpath(mbo.Q2wall_RoutingNumber));
					routingNumberOne = Q2wall_RoutingNumber.getAttribute("value");       
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

				if(cnf.FnExplicitWait("XPATH", mbo.Q2wall_BankAccountNumber,driver)){
					WebElement BankAccountNumber=driver.findElement(By.xpath(mbo.Q2wall_BankAccountNumber));
					accountNumberOne = BankAccountNumber.getAttribute("value");
					int length = accountNumberOne.length();
					accountNumberTwo = accountNumberOne.substring((length-4));
					System.out.println(accountNumberTwo);
					blnFlag=true;
				} 
				else{
					repfn.FnUpdateTestStepResHTML("Verify Bank Account Number field is displayed under Payment Information option",
							"Bank Account Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_Amount,driver)){
					WebElement PayBill_CreditDebit_Amount=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_Amount));
					paymentAmount = PayBill_CreditDebit_Amount.getAttribute("value");
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Payment Amount field is displayed under Payment Information option",
							"Payment Amount Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_PayDate,driver)){
					WebElement PayBill_CreditDebit_PayDate=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_PayDate));
					paymentDateOne = PayBill_CreditDebit_PayDate.getAttribute("value");
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

					}else {
						String[] one = paymentDateOne.split("/");
						month = one[0];
						day = one[1];
						String yearOne = one[2];
						year = yearOne.substring((2));
						paymentDate = month+"/"+day+"/"+year;
					}

					System.out.println("Final payment date: "+paymentDate);
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
							if(cnf.FnExplicitWait("XPATH", mbo.VerifyPay_Heading,driver))
							{
								repfn.FnUpdateTestStepResHTML("Check if Verify Payment Information heading is displayed", "Verify Payment Information heading is displayed", "PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Check if Verify Payment Information heading is displayed", "Verify Payment Information heading is not displayed", "FAIL",runManagerInfoObj);
								blnFlag=false; 
							}

							if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentInfo_Hdr,driver))
							{
								repfn.FnUpdateTestStepResHTML("Check if Payment Summary sub-heading  is displayed", "Payment Summary sub- heading is displayed", "PASS",runManagerInfoObj);

								if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_VerifyCard,driver)){
									WebElement PayBill_CreditDebit_VerifyCard=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_VerifyCard));
									if(PayBill_CreditDebit_VerifyCard.getAttribute("textContent").contains(routingNumber)){
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

								if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_VerifyExp,driver)){
									WebElement PayBill_CreditDebit_VerifyExp=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_VerifyExp));
									if(PayBill_CreditDebit_VerifyExp.getAttribute("textContent").contains(accountNumberTwo)){
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

								if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_VerifyAmnt,driver)){
									WebElement PayBill_CreditDebit_VerifyAmnt=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_VerifyAmnt));
									if(PayBill_CreditDebit_VerifyAmnt.getAttribute("textContent").contains(paymentAmount)){
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

								if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_VerifyPayDate,driver)){
									WebElement PayBill_CreditDebit_VerifyPayDate=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_VerifyPayDate));
									System.out.println(PayBill_CreditDebit_VerifyPayDate.getAttribute("textContent"));
									if(PayBill_CreditDebit_VerifyPayDate.getAttribute("textContent").contains(paymentDate)){
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

								if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentInfo_EditPayLink,driver))
								{
									repfn.FnUpdateTestStepResHTML("Verify if Edit Pay Link is present", "Edit Pay Link is present", "PASS",runManagerInfoObj);
									blnFlag=true;
								}
								else
								{
									repfn.FnUpdateTestStepResHTML("Verify if Edit Pay Link is present", "Edit Pay Link is not present", "FAIL",runManagerInfoObj);
									blnFlag=false;
								}
								if(cnf.FnExplicitWait("XPATH", mbo.CreditDebit_VerifyPay_Cancel,driver))
								{
									repfn.FnUpdateTestStepResHTML("Verify if Cancel button is present", "Cancel payment button is present", "PASS",runManagerInfoObj);
									blnFlag=true;
								}
								else
								{
									repfn.FnUpdateTestStepResHTML("Verify if Cancel button is present", "Cancel payment button is not present", "FAIL",runManagerInfoObj);
									blnFlag=false;
								}

								if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentInfo_CompletePaymentBtn,driver))
								{
									repfn.FnUpdateTestStepResHTML("Verify if Complete Payment button is present", "Complete payment button is present", "PASS",runManagerInfoObj);
									blnFlag=true;
								}
								else
								{
									repfn.FnUpdateTestStepResHTML("Verify if Complete Payment button is present", "Complete Payment button is not present", "FAIL",runManagerInfoObj);
									blnFlag=false;
								}

							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Check if Payment Summary sub-heading  is displayed", "Payment Summary sub- heading is not displayed", "FAIL",runManagerInfoObj);
								blnFlag=false; 
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


			public synchronized boolean FnValidateEditPaymentOption_CheckingSavings_WG(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{
			  
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
		    String errorMessage = " ";

		 String errorStatusThree = "Please enter a valid payment date.";
		    
		   try{

		        driver.switchTo().frame("iFrameResizer0");
		        
		        if(cnf.FnExplicitWait("XPATH", mbo.Q2wall_RoutingNumber,driver)){
		        	String RoutingNumber=m1.get("RoutingNumber").toString();
		               repfn.FnUpdateTestStepResHTML("Verify Routing Number field is displayed under Payment Information option",
		                            "Routing Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
		               WebElement Q2wall_RoutingNumber=driver.findElement(By.xpath(mbo.Q2wall_RoutingNumber));
		               Q2wall_RoutingNumber.sendKeys(RoutingNumber);
		               repfn.FnUpdateTestStepResHTML("Verify Routing Number is entered","Routing Number: " +RoutingNumber + " is entered","PASS",runManagerInfoObj);
		               blnFlag=true;
		        }
		        else{
		               repfn.FnUpdateTestStepResHTML("Verify Routing Number field is displayed under Payment Information option",
		                            "Routing Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		               blnFlag=false;
		        }
		        
		        
		        if(cnf.FnExplicitWait("XPATH", mbo.Q2wall_BankAccountNumber,driver)){
		        	String BankAccountNumber=m1.get("BankAccountNumber").toString();
		               repfn.FnUpdateTestStepResHTML("Verify Bank Account Number field is displayed under Payment Information option",
		                           "Bank Account Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
		               WebElement Q2wall_BankAccountNumber=driver.findElement(By.xpath(mbo.Q2wall_BankAccountNumber));
		               Q2wall_BankAccountNumber.sendKeys(BankAccountNumber);
		               repfn.FnUpdateTestStepResHTML("Verify Bank Account Number is entered","Bank Account Number:  " +BankAccountNumber + " is entered","PASS",runManagerInfoObj);
		               blnFlag=true;
		        } 
		        else{
		               repfn.FnUpdateTestStepResHTML("Verify Bank Account Number field is displayed under Payment Information option",
		                            "Bank Account Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
		               blnFlag=false;
		        }
		        
		        String Amount=m1.get("Amount").toString();
				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_Amount,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if Payment Amount field is displayed", "Payment Amount field is displayed", "PASS",runManagerInfoObj);
					WebElement PayBill_CreditDebit_Amount=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_Amount));
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


				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_PayDate,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Payment Date field is displayed under Payment Information option",
							"Payment Amount Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
					WebElement PayBill_CreditDebit_PayDate=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_PayDate));

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

					/*               if(cnf.FnExplicitlessWait_untilClickable("XPATH", mbo.billingPayNowButton))
						 {
							 WebElement payNow=driver.findElement(By.xpath(mbo.billingPayNowButton));
							 cnf.JSClick(payNow);

							 Thread.sleep(5000);
							 blnFlag=true;
							 repfn.FnUpdateTestStepResHTML("Verify if user has clicked the pay now button", "User has clicked the pay now button", "PASS",runManagerInfoObj);
							 if(cnf.FnExplicitWait("XPATH", mbo.PaymentInformationHeader)){
			                     WebElement PaymentInformationHeader=driver.findElement(By.xpath(mbo.PaymentInformationHeader));
			                     cnf.JSClick(PaymentInformationHeader);
			                     blnFlag=true;
			               }
			               else{
			                     repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
			                     blnFlag=false;
			               }
						 }
						 else
						 {
							 blnFlag=false;
							 repfn.FnUpdateTestStepResHTML("Verify if user has clicked the pay now button", "User has not clicked the pay now button", "FAIL",runManagerInfoObj);
						 }*/

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
			public synchronized boolean Q2Wall_FnValidateBlankFeildErrorMsg_RoutingNumber(WebDriver driver,RunManagerInfo runManagerInfoObj){

				String errorMessage = "";

				try{

					driver.switchTo().frame("iFrameResizer0");

					if(cnf.FnExplicitWait("XPATH", mbo.Q2wall_RoutingNumber,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Routing Number field is displayed under Payment Information option",
								"Routing Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
						WebElement RoutingNumber=driver.findElement(By.xpath(mbo.Q2wall_RoutingNumber));
						RoutingNumber.click();
						RoutingNumber.sendKeys(Keys.TAB);
						repfn.FnUpdateTestStepResHTML("Leave the Routing Number text entry field blank and try to proceed.","Routing Number feild is left blank  ","PASS",runManagerInfoObj);

						Thread.sleep(2000);

						if(cnf.FnExplicitWait("XPATH", mbo.RoutingNumberError,driver)){
							WebElement RoutingNumberError=driver.findElement(By.xpath(mbo.RoutingNumberError));
							errorMessage = RoutingNumberError.getAttribute("textContent");
							repfn.FnUpdateTestStepResHTML("Verify Routing Number Error Message is displayed ","Routing Number Error Message: " +errorMessage + "is displayed when Routing Number feild is left blank","PASS",runManagerInfoObj);
							blnFlag=true; 				
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Routing Number Error Message is displayed",
									"Routing Number Error Message is not displayed when Routing Number feild is left blank  " ,"FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Routing Number field is displayed under Payment Information option",
								"Routing Number field is not  displayed under Payment Information option","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}

				catch (Exception e)

				{
					repfn.FnUpdateTestStepResHTML("Verify Routing Number Error Message is displayed",
							"Routing Number Error Message is not displayed due to some exception  " ,"FAIL",runManagerInfoObj);
					blnFlag=false;
					System.err.println("Message : "+e.getMessage());
					System.err.println("Cause : "+e.getCause());

				}
				m1.put("STEPSTATUS", blnFlag);
				return blnFlag;

			}

			public synchronized boolean Q2Wall_FnValidateBlankFeildErrorMsg_AccountNumber(WebDriver driver,RunManagerInfo runManagerInfoObj){

				String errorMessage = "";

				try{

					if(cnf.FnExplicitWait("XPATH", mbo.Q2wall_BankAccountNumber,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Bank Account Number field is displayed under Payment Information option",
								"Bank Account Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
						WebElement BankAccountNumber=driver.findElement(By.xpath(mbo.Q2wall_BankAccountNumber));
						BankAccountNumber.sendKeys(Keys.TAB);
						repfn.FnUpdateTestStepResHTML("Leave the Bank Account number text entry field blank and try to proceed.","Bank Account Number feild is left blank","PASS",runManagerInfoObj);


						Thread.sleep(2000);

						if(cnf.FnExplicitWait("XPATH", mbo.Q2wall_BankAccountNumberError,driver)){
							WebElement BankAccountNumberError=driver.findElement(By.xpath(mbo.Q2wall_BankAccountNumberError));
							errorMessage = BankAccountNumberError.getAttribute("textContent");
							repfn.FnUpdateTestStepResHTML("Verify Bank Account Number Error Message is displayed","Bank Account Number Error Message is displayed:  " +errorMessage+" when Bank Account Number feild is left blank","PASS",runManagerInfoObj);
							blnFlag=true;				
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Bank Account Number Error Message is displayed",
									"Bank Account Number Error Message is not displayed when Bank Account Number feild is left blank " ,"FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Bank Account Number field is displayed under Payment Information option",
								"Bank Account Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}

				catch (Exception e)

				{
					repfn.FnUpdateTestStepResHTML("Verify Bank Account Number Error Message is displayed",
							"Bank Account Number Error Message is not displayed due to some exception  " ,"FAIL",runManagerInfoObj);
					blnFlag=false;
					System.err.println("Message : "+e.getMessage());
					System.err.println("Cause : "+e.getCause());

				}
				m1.put("STEPSTATUS", blnFlag);
				return blnFlag;

			}


			public synchronized boolean Q2Wall_FnValidateBlankFeildErrorMsg_PaymentAmount(WebDriver driver,RunManagerInfo runManagerInfoObj){

				String errorMessage = "";

				try{

					if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_PaymentAmount,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Payment Amount field is displayed under Payment Information option",
								"Payment Amount field is displayed under Payment Information option","PASS",runManagerInfoObj);
						WebElement PaymentAmount=driver.findElement(By.xpath(mbo.Q2Wall_PaymentAmount));
						PaymentAmount.sendKeys(Keys.TAB);

						repfn.FnUpdateTestStepResHTML("Leave the Payment Amount text entry field blank and try to proceed.","Payment Amount feild is left blank ","PASS",runManagerInfoObj);

						Thread.sleep(2000);

						if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_paymentAmountError,driver)){
							WebElement Q2Wall_paymentAmountError=driver.findElement(By.xpath(mbo.Q2Wall_paymentAmountError));
							errorMessage = Q2Wall_paymentAmountError.getAttribute("textContent");
							repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed ","Payment Amount Error Message: " +errorMessage + "is displayed Payment Amount feild is left blank","PASS",runManagerInfoObj);
							blnFlag=true;


						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed",
									"Payment Amount Error Message is not displayed when Payment Amount feild is left blank  " ,"FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Payment Amount field is displayed under Payment Information option",
								"Payment Amount field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}

				catch (Exception e)

				{
					repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed",
							"Payment Amount Error Message is not displayed due to some exception " ,"FAIL",runManagerInfoObj);
					blnFlag=false;	      	
					System.err.println("Message : "+e.getMessage());
					System.err.println("Cause : "+e.getCause());

				}
				m1.put("STEPSTATUS", blnFlag);
				return blnFlag;

			}



			public synchronized boolean Q2Wall_FnValidateBlankFeildErrorMsg_PaymentDate(WebDriver driver,RunManagerInfo runManagerInfoObj){

				String errorMessage = "";

				try{

					if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_paymentDate,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Payment Date field is displayed under Payment Information option",
								"Payment Date field is displayed under Payment Information option","PASS",runManagerInfoObj);
						WebElement Q2Wall_paymentDate=driver.findElement(By.xpath(mbo.Q2Wall_paymentDate));
						Q2Wall_paymentDate.click();
						Q2Wall_paymentDate.sendKeys(Keys.TAB);
						repfn.FnUpdateTestStepResHTML("Leave the Payment Date text entry field blank and try to proceed.","Payment Date feild is left blank ","PASS",runManagerInfoObj);

						Thread.sleep(2000);

						if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_paymentDateError,driver)){
							WebElement Q2Wall_paymentDateError=driver.findElement(By.xpath(mbo.Q2Wall_paymentDateError));
							errorMessage = Q2Wall_paymentDateError.getAttribute("textContent");
							repfn.FnUpdateTestStepResHTML("Verify Payment Date Error Message is displayed ","Payment Date Error Message: " +errorMessage + "is displayed Payment Date feild is left blank","PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Payment Date Error Message is displayed",
									"Payment Date Error Message is not displayed when Payment Date feild is left blank  " ,"FAIL",runManagerInfoObj);
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
					repfn.FnUpdateTestStepResHTML("Verify Payment Date Error Message is displayed",
							"Payment Date Error Message is not displayed due to some exception " ,"FAIL",runManagerInfoObj);
					blnFlag=false;
					System.err.println("Message : "+e.getMessage());
					System.err.println("Cause : "+e.getCause());

				}
				m1.put("STEPSTATUS", blnFlag);
				return blnFlag;

			}

			public synchronized boolean Q2Wall_Fn_ConfirmationPop(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{
				try{
					if(cnf.FnExplicitWait("XPATH",mbo.Q2_ConfirmationNavigation,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify Confirmation Navigation popup is displayed after clicking Edit link ","Confirmation Navigation popup is displayed after clicking Edit link","PASS",runManagerInfoObj);
						if(cnf.FnExplicitWait("XPATH",mbo.Q2_Confirmbutton,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Confirm button is displayed","Confirm button is displayed","PASS",runManagerInfoObj);
							WebElement Confirmbutton=driver.findElement(By.xpath(mbo.Q2_Confirmbutton));
							if(cnf.JSClick(Confirmbutton,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Confirm button is clicked","Confirm button is clicked","PASS",runManagerInfoObj);
								Thread.sleep(5000);

								driver.switchTo().frame("iFrameResizer0");

								if(cnf.FnExplicitWait("XPATH",mbo.PaymentInfo_PayNowBtn,driver)){
									repfn.FnUpdateTestStepResHTML("Verify User is navigated back to the Pay Bill screen ","User is navigated back to the Pay Bill screen ","PASS",runManagerInfoObj);
									blnFlag=true;
								}
								else{
									
									if(cnf.FnExplicitWait("XPATH",mbo.VerifyPaymentInfo_EditPayLink,driver)){
										WebElement editbtn=driver.findElement(By.xpath(mbo.VerifyPaymentInfo_EditPayLink));
										if(cnf.JSClick(editbtn,driver)){
											if(cnf.FnExplicitWait("XPATH",mbo.PaymentInfo_PayNowBtn,driver)){

												repfn.FnUpdateTestStepResHTML("Verify User is navigated back to the Pay Bill screen ","User is navigated back to the Pay Bill screen ","PASS",runManagerInfoObj);
												blnFlag=true;
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify User is navigated back to the Pay Bill screen ","User is not navigated back to the Pay Bill screen ","FAIL",runManagerInfoObj);
												blnFlag=false;
											}
										}
									}


								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Confirm button is clicked","Confirm button is not clicked","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Confirm button is displayed","Confirm button is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}

					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify Confirmation Navigation popup is displayed after clicking Edit link","Confirmation Navigation popup is not  displayed after clicking Edit link","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					driver.switchTo().defaultContent();
				}
				catch(Exception e)
				{
					System.err.println("Message : "+e.getMessage());
					System.err.println("Cause : "+e.getCause());	
					repfn.FnUpdateTestStepResHTML("Verify Confirm button is displayed and clicked","Confirm button is not  displayed and not  clicked due to some exception","FAIL",runManagerInfoObj);

					blnFlag=false;

				}
				 m1.put("STEPSTATUS", blnFlag);
				return blnFlag;
			}

public synchronized boolean CreditDebit_EmptyAccNo(WebDriver driver,RunManagerInfo runManagerInfoObj)
{
	 try
	 {
		 driver.switchTo().frame("iFrameResizer0");
		 if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_CardNum,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify if Card Number field is displayed", "Card Number field is displayed", "PASS",runManagerInfoObj);
			WebElement Card=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_CardNum));
			if(Card.isDisplayed())
			{
				Card.sendKeys("",Keys.TAB);
				repfn.FnUpdateTestStepResHTML("Do not enter any account number","Account number field is left blank" , "PASS",runManagerInfoObj);
				if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_Edit_CardError,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if error message is displayed", "Please enter a valid Credit Card error message is displayed", "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify if error message is displayed", "Error message is not displayed", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Do not enter any account number","Account number field is not left blank" , "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify if Card Number field is displayed", "Card Number field is not displayed", "FAIL",runManagerInfoObj);
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
public synchronized boolean CreditDebit_EmptyExpiryDate(WebDriver driver,RunManagerInfo runManagerInfoObj)
{
	 try
	 {
		if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_ExpMonth,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify if Expiry Month field is displayed", "Expiry Month field is displayed", "PASS",runManagerInfoObj);
			WebElement Card=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_ExpMonth));
			if(Card.isDisplayed())
			{
				/*//cnf.JSClick(Card);
				Thread.sleep(1000);
				repfn.FnUpdateTestStepResHTML("Click on the dropdown", "A list of months are displayed", "PASS",runManagerInfoObj);
				if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_SelectExpMonth))
				{
					WebElement Month=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_SelectExpMonth));
					cnf.JSClick(Month);
					repfn.FnUpdateTestStepResHTML("Click on a particular month", "A particular month is selected", "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Click on a particular month", "A particular month is not selected", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				*/
				
				//PayBill_CreditDebit_Selectdropdown();
				repfn.FnUpdateTestStepResHTML("Do not select any Expiration Date from the dropdown", "Expiration Date field is left blank", "PASS",runManagerInfoObj);
				WebElement Amount=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_Amount));
				Amount.sendKeys("10.00",Keys.TAB);
				if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_Edit_ExpError,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if error message is displayed ", "Please enter a valid Expiration Date error message is displayed", "PASS",runManagerInfoObj);
					if(cnf.FnExplicitWait("XPATH", mbo.PaymentInfo_PayNowBtn,driver))
					{
						WebElement PayNow=driver.findElement(By.xpath(mbo.PaymentInfo_PayNowBtn));
						if(!PayNow.isEnabled())
						{
							repfn.FnUpdateTestStepResHTML("Verify if Pay Now button is disabled", "PAy Now button is disabled", "PASS",runManagerInfoObj);
							blnFlag=true;

						}
						else
						{
							repfn.FnUpdateTestStepResHTML("Verify if Pay Now button is disabled", "PAy Now button is enabled", "FAIL",runManagerInfoObj);
							blnFlag=false;

						}
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify if error message is displayed ", "Please enter a valid Expiration Date error message is displayed", "PASS",runManagerInfoObj);
					blnFlag=true;
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Do not select any Expiration Date from the dropdown", "Expiration Date field is not left blank", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
			
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify if Expiry Month field is displayed", "Expiry Month field is not displayed", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		
		driver.switchTo().defaultContent();
	 }
	 catch(Exception e)
	 {
		 System.err.println("Message : "+e.getMessage());
		 System.err.println("Cause : "+e.getCause());	
	 }
	 m1.put("STEPSTATUS", blnFlag);
	 return blnFlag;

}
public synchronized boolean RecoverUserName_Radiobtn(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception
{
	 try
	 {
		 if(cnf.FnExplicitWait("XPATH", mbo.RecoverUserName,driver)){
			 repfn.FnUpdateTestStepResHTML("Verify if Recover Username option is present", "Recover Username option is present", "PASS",runManagerInfoObj);
			 WebElement User=driver.findElement(By.xpath(mbo.RecoverUserName));
			 if(User.isSelected()){
				 repfn.FnUpdateTestStepResHTML("Verify if Recover Username option is selected", "Recover Username option is selected", "PASS",runManagerInfoObj);
				 blnFlag=true;
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify if Recover Username option is selected", "Recover Username option is not selected", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }
		 else{
			 repfn.FnUpdateTestStepResHTML("Verify if Recover Username option is present", "Recover Username option is not present", "FAIL",runManagerInfoObj);
			 blnFlag=false;				 
		 }
	 }
	 catch(Exception e)
	 {
		 System.err.println("Message : "+e.getMessage());
		 System.err.println("Cause : "+e.getCause());
		 repfn.FnUpdateTestStepResHTML("Verify if Recover Username option is present", "Recover Username option is not present due to some exception", "FAIL",runManagerInfoObj);
		 blnFlag=false;
	 }
	 m1.put("STEPSTATUS", blnFlag);
	 return blnFlag;
}

public synchronized boolean ResetPassword_Radiobtn_WG(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception
{
	 try
	 {
		 if(cnf.FnExplicitWait("ID", mbo.resetPasswordRB,driver)){
			 repfn.FnUpdateTestStepResHTML("Verify if Reset Password option is present", "Reset Password option is present", "PASS",runManagerInfoObj);
			 WebElement resetPasswordRB=driver.findElement(By.id(mbo.resetPasswordRB));
			 if(resetPasswordRB.isSelected()){
				 repfn.FnUpdateTestStepResHTML("Verify if Reset Password option is selected", "Reset Password option is selected", "PASS",runManagerInfoObj);
				 blnFlag=true;
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify if Reset Password option is selected", "Recover Username option is not selected", "FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }
		 else{
			 repfn.FnUpdateTestStepResHTML("Verify if Reset Password option is present", "Reset Password option is not present", "FAIL",runManagerInfoObj);
			 blnFlag=false;				 
		 }
	 }
	 catch(Exception e)
	 {
		 System.err.println("Message : "+e.getMessage());
		 System.err.println("Cause : "+e.getCause());
		 repfn.FnUpdateTestStepResHTML("Verify if Reset Password option is present", "Reset Password option is not present due to some exception", "FAIL",runManagerInfoObj);
		 blnFlag=false;
	 }
	 m1.put("STEPSTATUS", blnFlag);
	 return blnFlag;
}
public synchronized boolean Q2_UserRecovery(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception
{
	try
	{
		if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_ForgotUserName,driver))
		{
			WebElement Recovery=driver.findElement(By.xpath(mbo.Q2Wall_ForgotUserName));
			System.out.println("Recovery Link is displayed");
			repfn.FnUpdateTestStepResHTML("Verify if Forgot UserName/Password link is present", "Forgot UserName/Password Link is present", "PASS",runManagerInfoObj);
			if(cnf.JSClick(Recovery,driver)){
				System.out.println("Recovery Link is clicked");
				repfn.FnUpdateTestStepResHTML("Verify Click on Forgot UserName/Password link", "Forgot UserName/Password link is clicked", "PASS",runManagerInfoObj);
				Thread.sleep(1000);
				if(cnf.FnExplicitWait("XPATH", mbo.VerifyRecoveryUsernamePwdpage,driver))
				{
					System.out.println("User is redirected to Recovery page");
					repfn.FnUpdateTestStepResHTML("Verify if Forgot Username/Password page is displayed","Forgot Username/Pwd page is displayed","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					System.out.println("User is not redirected to Recovery page");
					repfn.FnUpdateTestStepResHTML("Verify if Forgot Username/Password page is displayed","Forgot Username/Pwd page is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;

				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Click on Forgot UserName/Password link", "Forgot UserName/Password link is not clicked", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify if Forgot UserName/Password link is present", "Forgot UserName/Password Link is not present", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}

	}
	catch (Exception e)

	{
		repfn.FnUpdateTestStepResHTML("Verify if user is navigated to forgot Username/Password Page", "User is not navigated to Forgot Username/Password page due to some exception", "FAIL",runManagerInfoObj);
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		blnFlag=false;
		//repfn.FnUpdateTestStepResHTML("Verify if the shelf services and equipment in the overwiew page is displayed", "verify did not happen ","FAIL",runManagerInfoObj);
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean Empty(WebDriver driver,RunManagerInfo runManagerInfoObj)
{
	 try
	 {	
		 String Empty1=m1.get("BlankAccNum").toString();
		 String Empty2=m1.get("EmptyCode").toString();
		 if(cnf.FnExplicitWait("XPATH", mbo.AccNumber,driver)){
			 repfn.FnUpdateTestStepResHTML("Verify Account Number input field is displayed", "Account Number input field is displayed", "PASS",runManagerInfoObj);
			 WebElement AccountNo=driver.findElement(By.xpath(mbo.AccNumber));
			 AccountNo.clear();
			 AccountNo.sendKeys(Empty1,Keys.TAB);
			 repfn.FnUpdateTestStepResHTML("Verify No Account Number is added", "Account Number field is left empty", "PASS",runManagerInfoObj);
			 blnFlag=true;
		 }
		 else{
			 repfn.FnUpdateTestStepResHTML("Verify Account Number input field is displayed", "Account Number input field is not displayed", "FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }

		 if(cnf.FnExplicitWait("XPATH", mbo.ForgotUsername_SecurityCode,driver)){
			 repfn.FnUpdateTestStepResHTML("Verify Security Code input field is displayed", "Security Code input field is displayed", "PASS",runManagerInfoObj);
			 WebElement Code=driver.findElement(By.xpath(mbo.ForgotUsername_SecurityCode));
			 Code.clear();
			 Code.sendKeys(Empty2,Keys.TAB);
			 repfn.FnUpdateTestStepResHTML("Verify No Security Code is added", "Security Code field is left empty", "PASS",runManagerInfoObj);
			 blnFlag=true;
		 }
		 else{
			 repfn.FnUpdateTestStepResHTML("Verify Security Code input field is displayed", "Security Code input field is not displayed", "FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }


		 blnFlag = Next(driver,runManagerInfoObj);
		 
		 if(blnFlag){
			 blnFlag=true;
		 }
		 else{
			 blnFlag=false;
		 }

		 driver.navigate().refresh();

	 }
	 catch(Exception e)
	 {
		 System.err.println("Message : "+e.getMessage());
		 System.err.println("Cause : "+e.getCause());	
	 }
	 m1.put("STEPSTATUS", blnFlag);
	 return blnFlag;
}
public synchronized boolean ForgotUsername_Checkcriterias(WebDriver driver,RunManagerInfo runManagerInfoObj)
{
	 try
	 {
		 RecoverUserName_Radiobtn(driver,runManagerInfoObj);
		 Empty(driver,runManagerInfoObj);
		 EditAccNumber(driver,runManagerInfoObj);
		 EditCode(driver,runManagerInfoObj);
		 Next(driver,runManagerInfoObj);
		 driver.navigate().refresh();
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
public synchronized boolean EditAccNumber(WebDriver driver,RunManagerInfo runManagerInfoObj)
{
	 try
	 {
		 String Account=m1.get("AccountNumber").toString();

		 cnf.FnExplicitWait("XPATH", mbo.AccNumber,driver);
		 WebElement AccountNo=driver.findElement(By.xpath(mbo.AccNumber));

		 if(AccountNo.isDisplayed())
		 {

			 AccountNo.sendKeys(Account,Keys.TAB);
			 repfn.FnUpdateTestStepResHTML("Enter an invalid Account Number", "Invalid Account Number is entered" +Account, "PASS",runManagerInfoObj);
			 blnFlag=true;
		 }
		 else
		 {
			 repfn.FnUpdateTestStepResHTML("Enter an invalid Account Number", "Invalid Account Number is not entered" +Account, "FAIL",runManagerInfoObj);
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

//To key-in Security Code//

public synchronized boolean EditCode(WebDriver driver,RunManagerInfo runManagerInfoObj)
{
	 try
	 {
		 String Account=m1.get("SecurityCode").toString();

		 cnf.FnExplicitWait("XPATH", mbo.ForgotUsername_SecurityCode,driver);
		 WebElement AccountNo=driver.findElement(By.xpath(mbo.ForgotUsername_SecurityCode));

		 if(AccountNo.isDisplayed())
		 {

			 AccountNo.sendKeys(Account,Keys.TAB);
			 repfn.FnUpdateTestStepResHTML("Enter an invalid Security Code", "Invalid Security Code is entered" +Account, "PASS",runManagerInfoObj);
			 blnFlag=true;
		 }
		 else
		 {
			 repfn.FnUpdateTestStepResHTML("Enter an invalid Security Code", "Invalid Security code is not entered" +Account, "FAIL",runManagerInfoObj);
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

//To click on Next//

public synchronized boolean Next(WebDriver driver,RunManagerInfo runManagerInfoObj)
{
	 try
	 {
		 if(cnf.FnExplicitWait("XPATH", mbo.forgotUsername_Next,driver))
		 {
			 repfn.FnUpdateTestStepResHTML("Verify if Next button is displayed", "Next button is displayed", "PASS",runManagerInfoObj);
			 WebElement forgotUsername_Next=driver.findElement(By.xpath(mbo.forgotUsername_Next));
			 if(forgotUsername_Next.isEnabled()){
				 repfn.FnUpdateTestStepResHTML("Verify if Next button is not enabled", "Next button is enabled", "FAIL",runManagerInfoObj);
				 blnFlag= false;
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify if Next button is not enabled", "Next button is not enabled", "PASS",runManagerInfoObj);
				 blnFlag= true;
			 }
		 }
		 else{
			 repfn.FnUpdateTestStepResHTML("Verify if Next button is displayed", "Next button is not displayed", "FAIL",runManagerInfoObj);
			 blnFlag= false;
		 }
			
	 }
	 catch(Exception e)
	 {
		 System.err.println("Message : "+e.getMessage());
		 System.err.println("Cause : "+e.getCause());
		 repfn.FnUpdateTestStepResHTML("Verify if Next button is displayed", "Next button is not displayed due to some exception", "FAIL",runManagerInfoObj);
		 blnFlag= false;
	 }
	 m1.put("STEPSTATUS", blnFlag);
	 return blnFlag;

}
public synchronized boolean ValidAccount(WebDriver driver,RunManagerInfo runManagerInfoObj)
{
	 try
	 {
		 String Account=m1.get("CorrectAccNo").toString();

		 cnf.FnExplicitWait("XPATH", mbo.AccNumber,driver);
		 WebElement AccountNo=driver.findElement(By.xpath(mbo.AccNumber));

		 if(AccountNo.isDisplayed())
		 {

			 AccountNo.sendKeys(Account,Keys.TAB);
			 repfn.FnUpdateTestStepResHTML("Enter an invalid Account Number", "Invalid Account Number is entered" +Account, "PASS",runManagerInfoObj);
			 blnFlag=true;
		 }
		 else
		 {
			 repfn.FnUpdateTestStepResHTML("Enter an valid Account Number", "valid Account Number is not entered" , "FAIL",runManagerInfoObj);
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

//To key-in valid Security Code//
public synchronized boolean validCode(WebDriver driver,RunManagerInfo runManagerInfoObj)
{
	 try
	 {
		 String Account=m1.get("RightCode").toString();

		 cnf.FnExplicitWait("XPATH", mbo.ForgotUsername_SecurityCode,driver);
		 WebElement AccountNo=driver.findElement(By.xpath(mbo.ForgotUsername_SecurityCode));

		 if(AccountNo.isDisplayed())
		 {

			 AccountNo.sendKeys(Account,Keys.TAB);
			 repfn.FnUpdateTestStepResHTML("Enter an valid Security Code", "valid Security Code is entered" +Account, "PASS",runManagerInfoObj);
			 blnFlag=true;
		 }
		 else
		 {
			 repfn.FnUpdateTestStepResHTML("Enter an valid Security Code", "valid Security code is not entered" , "FAIL",runManagerInfoObj);
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

//To key-in valid Security Answer//
public synchronized boolean EditValidSecurityAnswer(WebDriver driver,RunManagerInfo runManagerInfoObj)
{
	 try
	 {
		 String Right=m1.get("Validanswer").toString();
		 if(cnf.FnExplicitWait("XPATH",mbo.SecurityAnswer,driver))
		 {
			 WebElement Answer=driver.findElement(By.xpath(mbo.SecurityAnswer));
			 repfn.FnUpdateTestStepResHTML("Verify if Security answer textbox is present", "Security Answer textbox is present", "PASS",runManagerInfoObj);
			 Answer.sendKeys(Right,Keys.TAB);
			 repfn.FnUpdateTestStepResHTML("Enter an valid Security answer", "Valid security answer is entered", "PASS",runManagerInfoObj);
			 blnFlag=true;

		 }
		 else
		 {
			 repfn.FnUpdateTestStepResHTML("Verify if Security answer textbox is present", "Security Answer textbox is not present", "FAIL",runManagerInfoObj);
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
public synchronized boolean EditInValidSecurityAnswer(WebDriver driver,RunManagerInfo runManagerInfoObj)
{
	 try
	 {
		 String Right=m1.get("WrongAnswer").toString();
		 if(cnf.FnExplicitWait("XPATH",mbo.SecurityAnswer,driver))
		 {
			 WebElement Answer=driver.findElement(By.xpath(mbo.SecurityAnswer));
			 repfn.FnUpdateTestStepResHTML("Verify if Security answer textbox is present", "Security Answer textbox is present", "PASS",runManagerInfoObj);
			 Answer.sendKeys(Right,Keys.TAB);
			 repfn.FnUpdateTestStepResHTML("Enter an invalid Security answer", "InValid security answer is entered", "PASS",runManagerInfoObj);
			 blnFlag=true;

		 }
		 else
		 {
			 repfn.FnUpdateTestStepResHTML("Verify if Security answer textbox is present", "Security Answer textbox is not present", "FAIL",runManagerInfoObj);
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

public synchronized boolean Securityanswer_CancelTwice(WebDriver driver,RunManagerInfo runManagerInfoObj)
{
	 try
	 {
		 ValidAccount(driver,runManagerInfoObj);
		 validCode(driver,runManagerInfoObj);
		 Next(driver,runManagerInfoObj);
		 EditInValidSecurityAnswer(driver,runManagerInfoObj);
		 Answer_CancelTwice(driver,runManagerInfoObj);
		 blnFlag=true;

	 }
	 catch(Exception e)
	 {

		 System.err.println("Message : "+e.getMessage());
		 System.err.println("Cause : "+e.getCause());
		 repfn.FnUpdateTestStepResHTML("Verify if the Security Answer entered could be cancelled and taken to the previous page", "Security Answer entered could not be entered and the user is not taken to the previous page", "FAIL",runManagerInfoObj);
		 blnFlag=false;
	 }
	 m1.put("STEPSTATUS", blnFlag);
	 return blnFlag;
}

public synchronized boolean Answer_CancelTwice(WebDriver driver,RunManagerInfo runManagerInfoObj)
{
	 try
	 {
		 WebElement Answer=driver.findElement(By.xpath(mbo.SecurityAnswer));		
		 WebElement cancelButton = driver.findElement(By.xpath(mbo.forgotPwd_Cancel));

		 if(cnf.FnExplicitlessWait_untilClickable("XPATH", mbo.forgotPwd_Cancel,driver))
		 {
			 cnf.JSClick(cancelButton,driver);
			 Thread.sleep(5000);
			 blnFlag=true;
			 repfn.FnUpdateTestStepResHTML("Verify if user has clicked the cancel button "
					 , " User has clicked the cancel button ", "PASS",runManagerInfoObj);
			 Alert alert=driver.switchTo().alert();
			 alert.dismiss();
			 Thread.sleep(5000);
			 repfn.FnUpdateTestStepResHTML("Verify if user has clicked the cancel button in confirmation pop up "
					 , " User has clicked the cancel button in confirmation pop up", "PASS",runManagerInfoObj);
			 if(!Answer.getAttribute("value").toString().isEmpty())
			 {
				 blnFlag=true;
				 repfn.FnUpdateTestStepResHTML("Check whether the security answer is retained afer clicking cancel from confimation popup "
						 , " Security answer is retained: "+Answer.getAttribute("value").toString(), "PASS",runManagerInfoObj);

				 if(cnf.JSClick(cancelButton,driver))
				 {
					 blnFlag=true;
					 Thread.sleep(5000);
					 repfn.FnUpdateTestStepResHTML("Verify if user has clicked the cancel button again "
							 , " User has clicked the cancel button again", "PASS",runManagerInfoObj);
					 Alert alertTemp=driver.switchTo().alert();
					 alertTemp.accept();
					 Thread.sleep(5000);
					 repfn.FnUpdateTestStepResHTML("Verify if user has clicked the ok button in confirmation pop up "
							 , " User has clicked the ok button in confirmation pop up", "PASS",runManagerInfoObj);
				 }
				 else
				 {
					 blnFlag=false;
					 repfn.FnUpdateTestStepResHTML("Verify if user has clicked the cancel button again"
							 , " User has not clicked the cancel button again", "FAIL",runManagerInfoObj);
				 }
			 }


			 else
			 {
				 blnFlag=false;
				 repfn.FnUpdateTestStepResHTML("Check whether the Security Answer is retained afer clicking cancel from confimation popup "
						 , "Security Answer is not retained: ", "FAIL",runManagerInfoObj);
			 }

		 }
		 else
		 {
			 blnFlag=false;
			 repfn.FnUpdateTestStepResHTML("Verify if user has clicked the cancel button "
					 , " User has not clicked the cancel button ", "FAIL",runManagerInfoObj);


		 }
	 }


	 catch (Exception e)
	 {
		 repfn.FnUpdateTestStepResHTML("Verify if user is able to cancel the details entered to recover the username "
				 , " User is not able to cancel the details entered to recover the username due to some exception", "FAIL",runManagerInfoObj);
		 System.err.println("Message : "+e.getMessage());
		 System.err.println("Cause : "+e.getCause());

	 }
	 m1.put("STEPSTATUS", blnFlag);
	 return blnFlag;
}	

public synchronized boolean ResetPwd_CancelTwice(WebDriver driver,RunManagerInfo runManagerInfoObj)
{
	 try
	 {

		 WebElement accountNumberField = driver.findElement(By.xpath(mbo.AccNumber));
		 WebElement securityCode = driver.findElement(By.xpath(mbo.ForgotUsername_SecurityCode));

		 WebElement cancelButton = driver.findElement(By.xpath(mbo.forgotPwd_Cancel));

		 if(cnf.FnExplicitlessWait_untilClickable("XPATH", mbo.forgotPwd_Cancel,driver))
		 {
			 cnf.JSClick(cancelButton,driver);
			 Thread.sleep(5000);
			 blnFlag=true;
			 repfn.FnUpdateTestStepResHTML("Verify if user has clicked the cancel button "
					 , " User has clicked the cancel button ", "PASS",runManagerInfoObj);
			 Alert alert=driver.switchTo().alert();
			 alert.dismiss();
			 Thread.sleep(5000);
			 repfn.FnUpdateTestStepResHTML("Verify if user has clicked the cancel button in confirmation pop up "
					 , " User has clicked the cancel button in confirmation pop up", "PASS",runManagerInfoObj);
			 if(!accountNumberField.getAttribute("value").toString().isEmpty())
			 {
				 blnFlag=true;
				 repfn.FnUpdateTestStepResHTML("Check whether the account number is retained afer clicking cancel from confimation popup "
						 , " Account number is retained: "+accountNumberField.getAttribute("value").toString(), "PASS",runManagerInfoObj);
				 if(!securityCode.getAttribute("value").toString().isEmpty())
				 {
					 blnFlag=true;
					 repfn.FnUpdateTestStepResHTML("Check whether the security code is retained afer clicking cancel from confimation popup "
							 , " Security code is retained ", "PASS",runManagerInfoObj);
					 if(cnf.JSClick(cancelButton,driver))
					 {
						 blnFlag=true;
						 Thread.sleep(5000);
						 repfn.FnUpdateTestStepResHTML("Verify if user has clicked the cancel button again "
								 , " User has clicked the cancel button again", "PASS",runManagerInfoObj);
						 Alert alertTemp=driver.switchTo().alert();
						 alertTemp.accept();
						 Thread.sleep(5000);
						 repfn.FnUpdateTestStepResHTML("Verify if user has clicked the ok button in confirmation pop up "
								 , " User has clicked the ok button in confirmation pop up", "PASS",runManagerInfoObj);
					 }
					 else
					 {
						 blnFlag=false;
						 repfn.FnUpdateTestStepResHTML("Verify if user has clicked the cancel button again"
								 , " User has not clicked the cancel button again", "FAIL",runManagerInfoObj);
					 }
				 }
				 else
				 {
					 blnFlag=false;
					 repfn.FnUpdateTestStepResHTML("Check whether the security code is retained afer clicking cancel from confimation popup "
							 , " Security code is not retained ", "FAIL",runManagerInfoObj);
				 }
			 }
			 else
			 {
				 blnFlag=false;
				 repfn.FnUpdateTestStepResHTML("Check whether the account number is retained afer clicking cancel from confimation popup "
						 , " Account number is not retained: ", "FAIL",runManagerInfoObj);
			 }

		 }
		 else
		 {
			 blnFlag=false;
			 repfn.FnUpdateTestStepResHTML("Verify if user has clicked the cancel button "
					 , " User has not clicked the cancel button ", "FAIL",runManagerInfoObj);


		 }
	 }


	 catch (Exception e)
	 {
		 repfn.FnUpdateTestStepResHTML("Verify if user is able to cancel the details entered to recover the username "
				 , " User is not able to cancel the details entered to recover the username due to some exception", "FAIL",runManagerInfoObj);
		 System.err.println("Message : "+e.getMessage());
		 System.err.println("Cause : "+e.getCause());

	 }
	 m1.put("STEPSTATUS", blnFlag);
	 return blnFlag;
}	
public synchronized boolean Q2Wall_ValidateRequiredFieldIndicator(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{
	
	try{
		
		if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_CardNumber_HeaderText,driver)){
			repfn.FnUpdateTestStepResHTML("Verify \'Card Number\' Heading is displayed", "\'Card Number\' Heading is displayed", "PASS",runManagerInfoObj);
			WebElement Q2Wall_CardNumber_HeaderText=driver.findElement(By.xpath(mbo.Q2Wall_CardNumber_HeaderText));
			if(Q2Wall_CardNumber_HeaderText.getText().contains("*")){
				repfn.FnUpdateTestStepResHTML("Verify Required field indicator \'*\' is displayed for \'Card Number\' field", "Required field indicator \'*\' is displayed for \'Card Number\' field", "PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Required field indicator \'*\' is displayed for \'Card Number\' field", "Required field indicator \'*\' is not displayed for \'Card Number\' field", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Card Number\' Heading is displayed", "\'Card Number\' Heading is not displayed", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		
		if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_ExpirationDate_HeaderText,driver)){
			repfn.FnUpdateTestStepResHTML("Verify \'Expiration Date\' Heading is displayed", "\'Expiration Date\' Heading is displayed", "PASS",runManagerInfoObj);
			WebElement Q2Wall_ExpirationDate_HeaderText=driver.findElement(By.xpath(mbo.Q2Wall_ExpirationDate_HeaderText));
			if(Q2Wall_ExpirationDate_HeaderText.getText().contains("*")){
				repfn.FnUpdateTestStepResHTML("Verify Required field indicator \'*\' is displayed for \'Expiration Date\' field", "Required field indicator \'*\' is displayed for \'Expiration Date\' field", "PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Required field indicator \'*\' is displayed for \'Expiration Date\' field", "Required field indicator \'*\' is not displayed for \'Expiration Date\' field", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Expiration Date\' Heading is displayed", "\'Expiration Date\' Heading is not displayed", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		
		if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_PaymentAmount_HeaderText,driver)){
			repfn.FnUpdateTestStepResHTML("Verify \'Payment Amount\' Heading is displayed", "\'Payment Amount\' Heading is displayed", "PASS",runManagerInfoObj);
			WebElement Q2Wall_PaymentAmount_HeaderText=driver.findElement(By.xpath(mbo.Q2Wall_PaymentAmount_HeaderText));
			if(Q2Wall_PaymentAmount_HeaderText.getText().contains("*")){
				repfn.FnUpdateTestStepResHTML("Verify Required field indicator \'*\' is displayed for \'Payment Amount\' field", "Required field indicator \'*\' is displayed for \'Payment Amount\' field", "PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Required field indicator \'*\' is displayed for \'Payment Amount\' field", "Required field indicator \'*\' is not displayed for \'Payment Amount\' field", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Payment Amount\' Heading is displayed", "\'Payment Amount\' Heading is not displayed", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		
		if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_PaymentDate_HeaderText,driver)){
			repfn.FnUpdateTestStepResHTML("Verify \'Payment Date\' Heading is displayed", "\'Payment Date\' Heading is displayed", "PASS",runManagerInfoObj);
			WebElement Q2Wall_PaymentDate_HeaderText=driver.findElement(By.xpath(mbo.Q2Wall_PaymentDate_HeaderText));
			if(Q2Wall_PaymentDate_HeaderText.getText().contains("*")){
				repfn.FnUpdateTestStepResHTML("Verify Required field indicator \'*\' is displayed for \'Payment Date\' field", "Required field indicator \'*\' is displayed for \'Payment Date\' field", "PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Required field indicator \'*\' is displayed for \'Payment Date\' field", "Required field indicator \'*\' is not displayed for \'Payment Date\' field", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Payment Date\' Heading is displayed", "\'Payment Date\' Heading is not displayed", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		
		if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_RequiredText,driver)){
			WebElement Q2Wall_RequiredText=driver.findElement(By.xpath(mbo.Q2Wall_RequiredText));			
			if(Q2Wall_RequiredText.getText().contains("Required Text")){
				repfn.FnUpdateTestStepResHTML("Verify \'Required Text\' is displayed in right corner", "\'Required Text\' is displayed in right corner", "PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify \'Required Text\' is displayed in right corner", "\'Required Text\' is not displayed in right corner", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Required Text\' is displayed in right corner", "\'Required Text\' is not displayed in right corner", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		
	}
	
	catch(Exception e)
	 {
		 repfn.FnUpdateTestStepResHTML("Verify User is able to verify Required fields indicator on Pay Bill page", "User is not able to verify Required fields indicator on Pay Bill page due to some exception", "FAIL",runManagerInfoObj);
		 blnFlag=false;
		 System.err.println("Message : "+e.getMessage());
		 System.err.println("Cause : "+e.getCause());	
	 }
	 m1.put("STEPSTATUS", blnFlag);
	 return blnFlag;
	
}
public synchronized boolean FnLocationFinder_UI(WebDriver driver,RunManagerInfo runManagerInfoObj)
{
	try
	{
		if(cnf.FnExplicitWait("XPATH", mbo.PaymentCenterTitle,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of Payment center title", "Payment center title:"+" "+driver.findElement(By.xpath(mbo.PaymentCenterTitle)).getText()+" "+"is displayed", "PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of Payment center title", "Payment center title is not displayed", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		
		if(cnf.FnExplicitWait("XPATH", mbo.PaymentCenterDesc,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of Payment center description", "Payment center description:"+" "+driver.findElement(By.xpath(mbo.PaymentCenterDesc)).getText()+" "+"is displayed", "PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of Payment center description", "Payment center description is not displayed", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		
		if(cnf.FnExplicitWait("XPATH", mbo.FindLocationLink,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of Find location link", "Find a location link is displayed", "PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of Find location link", "Find a location link is not displayed", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}
	catch (Exception e)

	{
		repfn.FnUpdateTestStepResHTML("Verify User is able to verify Location finder Option UI","User is not able to verify Location finder Option UI due to some exception ","FAIL",runManagerInfoObj);
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		blnFlag=false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
//Jhansi Dec 14,2015
//Location Finder page UI
public synchronized boolean FnLocationFinderPage_UI(WebDriver driver,RunManagerInfo runManagerInfoObj)
{
	try
	{
		if(cnf.FnExplicitWait("XPATH", mbo.FindLocationLink,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of Find location link", "Find a location link is displayed", "PASS",runManagerInfoObj);
			WebElement LocationLink=driver.findElement(By.xpath(mbo.FindLocationLink));
			if(cnf.JSClick(LocationLink,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify if Find a location link is clicked", "Find a location link is clicked", "PASS",runManagerInfoObj);

				Thread.sleep(10000);
				if(cnf.FnExplicitWait("XPATH", mbo.FindLocationUI_Content,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if User is taken to Location Finder page", "User is taken to location finder page", "PASS",runManagerInfoObj);
					if(cnf.FnExplicitWait("XPATH", mbo.FindLocationUI_Hdr,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Location Finder page header", "Location finder page is present with the header"+" "+driver.findElement(By.xpath(mbo.FindLocationUI_Hdr)).getText(), "PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Location Finder page header", "Location finder page is not present", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					if(cnf.FnExplicitWait("XPATH", mbo.FindLocationUI_txt,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Location Finder page text", "Location finder page is present with the text"+" "+driver.findElement(By.xpath(mbo.FindLocationUI_txt)).getText(), "PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Location Finder page text", "Location finder page is present without the text", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					if(cnf.FnExplicitWait("XPATH", mbo.FindLocationUI_Searchtxtbox,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of search text box in Location Finder page", "Search text box is present in Location finder page", "PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of search text box in Location Finder page", "Search text box is not present in Location finder page", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					if(cnf.FnExplicitWait("XPATH", mbo.FindLocationUI_GoBtn,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Go button in Location Finder page", "Go button is present in Location finder page", "PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Go button in Location Finder page", "Go button is not present in Location finder page", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify if User is taken to Location Finder page", "User is not taken to location finder page", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if Find a location link is clicked", "Find a location link is not clicked", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of Find location link", "Find a location link is not displayed", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}
	catch (Exception e)

	{
		repfn.FnUpdateTestStepResHTML("Verify User is in Location finder page","User is not in location finder page due to some exception ","FAIL",runManagerInfoObj);
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		blnFlag=false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
	//Jhansi Dec 14,2015
//Spectrum logo,Header and Footer links
public synchronized boolean Presence_Hdr_Footer_Links(WebDriver driver,RunManagerInfo runManagerInfoObj)
{
	String Url="";
	try
	{
		if(cnf.FnExplicitWait("XPATH", mbo.Spec_Logo,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of Spectrum logo in the header", "Spectrum logo is present in the header", "PASS",runManagerInfoObj);
			WebElement SpecLogo=driver.findElement(By.xpath(mbo.Spec_Logo));
			Url=driver.getCurrentUrl();  
			if(cnf.JSClick(SpecLogo,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify the Spectrum logo is clicked", "Spectrum logo is clicked", "PASS",runManagerInfoObj);
				if(driver.getCurrentUrl().equals(Url))
				{
					repfn.FnUpdateTestStepResHTML("Verify no action is triggered on click of Spectrum logo", "No action is triggered on click of Spectrum logo", "PASS",runManagerInfoObj);
					blnFlag=true;

				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify no action is triggered on click of Spectrum logo", "Action is triggered on click of Spectrum logo", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify the Spectrum logo is clicked", "Spectrum logo is not clicked", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of Spectrum logo in the header", "Spectrum logo is not present in the header", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		
		if(!cnf.FnExplicitWait("XPATH", mbo.Hdr_Links,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of header links in the header", "Header links are not present in the header", "PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of header links in the header", "Header links are present in the header", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		
		if(!cnf.FnExplicitWait("XPATH", mbo.Footer_Links,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of footer links in the header", "Footer links are not present in the header", "PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of footer links in the header", "Footer links are present in the header", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}	
	}
	catch (Exception e)

	{
		repfn.FnUpdateTestStepResHTML("Verify User is able to verify Header/Footer links on Location finder page","User is not able to verify Header/Footer links on Location finder page due to some exception ","FAIL",runManagerInfoObj);
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		blnFlag=false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
//Jhansi Dec 14,2015
//Location Finder page Navigation
public synchronized boolean FnLocationFinderPage_Navigation(WebDriver driver,RunManagerInfo runManagerInfoObj)
{
	try
	{
		if(cnf.isElementExist(By.xpath(mbo.FindLocationLink),driver))
		{
			WebElement LocationLink=driver.findElement(By.xpath(mbo.FindLocationLink));
			if(cnf.JSClick(LocationLink,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify if Find a location link is clicked", "Find a location link is clicked", "PASS",runManagerInfoObj);
				if(cnf.FnExplicitWait("XPATH", mbo.FindLocationUI_Content,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if user is taken to Location Finder page", "User is taken to location finder page", "PASS",runManagerInfoObj);
					
					Thread.sleep(8000);
					if(cnf.isElementExist(By.xpath(mbo.FindLocationUI_Hdr),driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Location Finder page header", "Location finder page is present with the header"+" "+driver.findElement(By.xpath(mbo.FindLocationUI_Hdr)).getText(), "PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Location Finder page header", "Location finder page is not present", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify if user is taken to Location Finder page", "User is not taken to location finder page", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if Find a location link is clicked", "Find a location link is not clicked", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of Find location link", "Find a location link is not displayed", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}
	catch (Exception e)

	  {
	         repfn.FnUpdateTestStepResHTML("Verify User is in Location finder page","User is not in location finder page due to some exception ","FAIL",runManagerInfoObj);


	         System.err.println("Message : "+e.getMessage());
	         System.err.println("Cause : "+e.getCause());
	         blnFlag=false;
	  }
	  m1.put("STEPSTATUS", blnFlag);
	  return blnFlag;
	}
//Jhansi Dec 14,2015
//Phone UI
public synchronized boolean FnPhone_UI(WebDriver driver,RunManagerInfo runManagerInfoObj)
{
	String PhoneHdr="";
	String PhoneDesc="";
	try
	{ 
		if(cnf.FnExplicitWait("XPATH", mbo.Phone_Hdr,driver))
		{
			PhoneHdr=driver.findElement(By.xpath(mbo.Phone_Hdr)).getText();
			repfn.FnUpdateTestStepResHTML("Verify the presence of Phone title in notification page", "Phone title"+" "+PhoneHdr+" "+"is present in notification page for user option to pay the bill using phone", "PASS",runManagerInfoObj);	
			blnFlag=true;
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of Phone title in notification page", "Phone title is not present in notification page for user option to pay the bill using phone", "FAIL",runManagerInfoObj);	
			blnFlag=false;
		}
		if(cnf.FnExplicitWait("XPATH", mbo.Phone_Description,driver))
		{
			PhoneDesc=driver.findElement(By.xpath(mbo.Phone_Description)).getText();
			repfn.FnUpdateTestStepResHTML("Verify the presence of Phone description in notification page", "Phone description"+" "+PhoneDesc+" "+"is present in notification page for user option to pay the bill using phone", "PASS",runManagerInfoObj);	
			blnFlag=true;
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of Phone description in notification page", "Phone description is not present in notification page for user option to pay the bill using phone", "FAIL",runManagerInfoObj);	
			blnFlag=false;
		}

	}
	catch (Exception e)

	{
		repfn.FnUpdateTestStepResHTML("Verify User is able to verify Phone options UI","User is not able to verify Phone options UI due to some exception ","FAIL",runManagerInfoObj);
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		blnFlag=false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean FnPayOnline_UI(WebDriver driver,RunManagerInfo runManagerInfoObj)
{
	String payOnline="";
	String payOnlineDesc="";
	try
	{
		if(cnf.FnExplicitWait("XPATH", mbo.PayOnline_Hdr,driver))
		{
			payOnline=driver.findElement(By.xpath(mbo.PayOnline_Hdr)).getText();
			repfn.FnUpdateTestStepResHTML("Verify the presence of Pay online title in notification page", "Pay online title"+" "+payOnline+" "+"is present in notification page for user option to pay the bill online", "PASS",runManagerInfoObj);	
			blnFlag=true;
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of Phone title in notification page", "Phone title is not present in notification page for user option to pay the bill online", "FAIL",runManagerInfoObj);	
			blnFlag=false;
		}
		if(cnf.FnExplicitWait("XPATH", mbo.PayOnline_Desc,driver))
		{
			payOnlineDesc=driver.findElement(By.xpath(mbo.PayOnline_Desc)).getText();
			repfn.FnUpdateTestStepResHTML("Verify the presence of Pay online description in notification page", "Pay online description"+" "+payOnlineDesc+" "+"is present in notification page for user option to pay the bill online", "PASS",runManagerInfoObj);	
			blnFlag=true;
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of Pay online description in notification page", "Pay online description is not present in notification page for user option to pay the bill online", "FAIL",runManagerInfoObj);	
			blnFlag=false;
		}
		if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_PayNowbtn,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of 'PAY NOW' link", "'PAY NOW' link is present", "PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of 'PAY NOW' link", "'PAY NOW' link is not present", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}

	}
	catch (Exception e)

	  {
    repfn.FnUpdateTestStepResHTML("Verify User is able to verify Pay Now Option UI","User is not able to verify Pay Now Option UI due to some exception ","FAIL",runManagerInfoObj);
	         System.err.println("Message : "+e.getMessage());
	         System.err.println("Cause : "+e.getCause());
	         blnFlag=false;
	  }
	  m1.put("STEPSTATUS", blnFlag);
	  return blnFlag;
}
//Jhansi Dec 14,2016
//Mail UI
public synchronized boolean FnMail_UI(WebDriver driver,RunManagerInfo runManagerInfoObj)
{
	String mailHdr="";
	String MailDesc="";
	try
	{
		if(cnf.FnExplicitWait("XPATH", mbo.Mail_Hdr,driver))
		{
			mailHdr=driver.findElement(By.xpath(mbo.Mail_Hdr)).getText();
			repfn.FnUpdateTestStepResHTML("Verify the presence of Mail title in notification page", "Mail title"+" "+mailHdr+" "+"is present in notification page for user option to mail in the payment", "PASS",runManagerInfoObj);	
			blnFlag=true;
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of Mail title in notification page", "Mail title is not present in notification page for user option to mail in the payment", "FAIL",runManagerInfoObj);	
			blnFlag=false;
		}
		if(cnf.FnExplicitWait("XPATH", mbo.Mail_Desc,driver))
		{
			MailDesc=driver.findElement(By.xpath(mbo.Mail_Desc)).getText();
			repfn.FnUpdateTestStepResHTML("Verify the presence of Mail description in notification page", "Mail description"+" "+MailDesc+" "+"is present in notification page for user option to mail in the payment", "PASS",runManagerInfoObj);	
			blnFlag=true;
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of Mail description in notification page", "Mail description is not present in notification page for user option to mail in the payment", "FAIL",runManagerInfoObj);	
			blnFlag=false;
		}

	}
	catch (Exception e)

	{
		repfn.FnUpdateTestStepResHTML("Verify User is able to verify Mail options UI","User is not able to verify Mail options UI due to some exception ","FAIL",runManagerInfoObj);
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		blnFlag=false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
//Jhansi Dec 14,2015
//Verifying if the user is able to see an option to Pay bill
public synchronized boolean PaymentOption_UI(WebDriver driver,RunManagerInfo runManagerInfoObj)
{
	try
	{
		if(cnf.FnExplicitWait("XPATH", mbo.PaymentOptions_Content,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of Payment options content", "Payment options content is present", "PASS",runManagerInfoObj);
			if(cnf.FnExplicitWait("XPATH", mbo.PaymentOptions_PgHdr,driver))
			{
				WebElement PgHdr=driver.findElement(By.xpath(mbo.PaymentOptions_PgHdr));
				repfn.FnUpdateTestStepResHTML("Verify the presence of Payment options page header", "Payment options page header is present"+" "+PgHdr.getText(), "PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify the presence of Payment options page header", "Payment options page header is not present", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
			if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_AccountPastDueText,driver))
			{
				WebElement AccountPastTxt=driver.findElement(By.xpath(mbo.Q2Wall_AccountPastDueText));
				repfn.FnUpdateTestStepResHTML("Verify the presence of Payment options title", "Payment options title is present"+" "+AccountPastTxt.getText(), "PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify the presence of Payment options title", "Payment options title is not present", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
			if(cnf.FnExplicitWait("XPATH", mbo.PaymentOptions_Txt,driver))
			{
				WebElement PaymentOptionTxt=driver.findElement(By.xpath(mbo.PaymentOptions_Txt));
				repfn.FnUpdateTestStepResHTML("Verify the presence of Payment options text", "Payment options text is present"+" "+PaymentOptionTxt.getText(), "PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify the presence of Payment options text", "Payment options text is not present", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of Payment options content", "Payment options content is not present", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}
	catch (Exception e)

	{
		repfn.FnUpdateTestStepResHTML("Verify User is able to verify Payment Option UI","User is not able to verify Payment Option UI due to some exception ","FAIL",runManagerInfoObj);
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		blnFlag=false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean forgotPassword_WG(WebDriver driver,RunManagerInfo runManagerInfoObj) {
	try
	{
		if(cnf.FnExplicitlessWait_untilClickable("XPATH", mbo.forgotPasswordDevWG,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify Forgot Password link is displayed on Login page", "Forgot Password link is displayed on Login page", "PASS",runManagerInfoObj);
			WebElement forgotPasswordDevWG=driver.findElement(By.xpath(mbo.forgotPasswordDevWG));
			if(cnf.JSClick(forgotPasswordDevWG,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify if User has clicked Forgot Password link", "User has clicked Forgot Password link", "PASS",runManagerInfoObj);
				
				if(cnf.FnExplicitWait("XPATH", mbo.VerifyRecoveryUsernamePwdpage,driver))
				{
					System.out.println("User is redirected to Recovery page");
					repfn.FnUpdateTestStepResHTML("Verify if Forgot Username/Password page is displayed","Forgot Username/Pwd page is displayed","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					System.out.println("User is not redirected to Recovery page");
					repfn.FnUpdateTestStepResHTML("Verify if Forgot Username/Password page is displayed","Forgot Username/Pwd page is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;

				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify if User has clicked Forgot Password link", "User has not clicked Forgot Password link", "FAIL",runManagerInfoObj);
				blnFlag = false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Forgot Password link is displayed on Login page", "Forgot Password link is not displayed on Login page", "FAIL",runManagerInfoObj);
			blnFlag = false;
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
public synchronized boolean Q2Wall_EditAccNumber(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception
{
	 try
	 {
		 String Account=m1.get("Account Number").toString();
		 if(cnf.FnExplicitWait("XPATH", mbo.AccNumber,driver))
		 {
			 repfn.FnUpdateTestStepResHTML("Verify Account Number field is displayed", "Account Number field is displayed", "PASS",runManagerInfoObj);
			 WebElement AccountNo=driver.findElement(By.xpath(mbo.AccNumber));
			 AccountNo.sendKeys(Account,Keys.TAB);
			 repfn.FnUpdateTestStepResHTML("Enter an valid Account Number", "Valid Account Number is entered: " +Account, "PASS",runManagerInfoObj);
			 blnFlag=true;
		 }
		 else
		 {
			 repfn.FnUpdateTestStepResHTML("Verify Account Number field is displayed", "Account Number field is not displayed", "FAIL",runManagerInfoObj);
			 blnFlag=false;	
		 }
	 }
	 catch(Exception e)
	 {
		 System.err.println("Message : "+e.getMessage());
		 System.err.println("Cause : "+e.getCause());
		 repfn.FnUpdateTestStepResHTML("Verify Account Number field is displayed", "Account Number field is not displayed due to some exception", "FAIL",runManagerInfoObj);
		 blnFlag=false;
	 }
	 m1.put("STEPSTATUS", blnFlag);
	 return blnFlag;

}

//To key-in Security Code//

public synchronized boolean Q2Wall_EditCode(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception
{
	 try
	 {
		 String SecurityCode=m1.get("SecurityCode").toString();
		 if(cnf.FnExplicitWait("XPATH", mbo.ForgotUsername_SecurityCode,driver))
		 {
			 repfn.FnUpdateTestStepResHTML("Verify Security Code field is displayed", "Security Code field is displayed", "PASS",runManagerInfoObj);
			 WebElement ForgotUsername_SecurityCode=driver.findElement(By.xpath(mbo.ForgotUsername_SecurityCode));
			 ForgotUsername_SecurityCode.sendKeys(SecurityCode,Keys.TAB);
			 repfn.FnUpdateTestStepResHTML("Enter an valid Security Code", "Valid Security Code is entered: " +SecurityCode, "PASS",runManagerInfoObj);
			 blnFlag=true;
		 }
		 else
		 {
			 repfn.FnUpdateTestStepResHTML("Verify Security Code field is displayed", "Security Code field is not displayed", "FAIL",runManagerInfoObj);
			 blnFlag=false;	
		 }
	 }
	 catch(Exception e)
	 {
		 System.err.println("Message : "+e.getMessage());
		 System.err.println("Cause : "+e.getCause());
		 repfn.FnUpdateTestStepResHTML("Verify Security Code field is displayed", "Security Code field is not displayed due to some exception", "FAIL",runManagerInfoObj);
		 blnFlag=false;
	 }
	 m1.put("STEPSTATUS", blnFlag);
	 return blnFlag;

}
public synchronized boolean Q2Wall_SecurityAnswer(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception
{
	 try
	 {
		 if(cnf.FnExplicitlessWait_untilClickable("XPATH", mbo.nextButtonRP,driver))
		 {
			 repfn.FnUpdateTestStepResHTML("Verify if Next button is displayed", "Next button is displayed", "PASS",runManagerInfoObj);
			 WebElement nextButton=driver.findElement(By.xpath(mbo.nextButtonRP));
			 if(cnf.JSClick(nextButton,driver)){
				 repfn.FnUpdateTestStepResHTML("Verify if Next button is clicked", "Next button is clicked", "PASS",runManagerInfoObj);

				 String SecurityAnswer=m1.get("SecurityAnswer").toString();
				 if(cnf.FnExplicitWait("ID", mbo.securityAnswerRP,driver))
				 {
					 repfn.FnUpdateTestStepResHTML("Verify Security Answer field is displayed", "Security Answer field is displayed", "PASS",runManagerInfoObj);
					 WebElement securityAnswerRP=driver.findElement(By.id(mbo.securityAnswerRP));
					 securityAnswerRP.sendKeys(SecurityAnswer,Keys.TAB);
					 repfn.FnUpdateTestStepResHTML("Enter an valid Security Answer", "Valid Security Answer is entered: " +SecurityAnswer, "PASS",runManagerInfoObj);
					 blnFlag=true;
				 }
				 else
				 {
					 repfn.FnUpdateTestStepResHTML("Verify Security Answer field is displayed", "Security Answer field is not displayed", "FAIL",runManagerInfoObj);
					 blnFlag=false;	
				 }
			 }
			 else
			 {
				 blnFlag=false;
				 repfn.FnUpdateTestStepResHTML("Verify if Next button is clicked", "Next button is not clicked", "FAIL",runManagerInfoObj);
			 }
		 }
		 else
		 {
			 blnFlag=false;
			 repfn.FnUpdateTestStepResHTML("Verify if Next button is displayed", "Next button is not displayed", "FAIL",runManagerInfoObj);
		 }
	 }
	 catch(Exception e)
	 {
		 System.err.println("Message : "+e.getMessage());
		 System.err.println("Cause : "+e.getCause());
		 repfn.FnUpdateTestStepResHTML("Verify Security Answer field is displayed", "Security Answer field is not displayed due to some exception", "FAIL",runManagerInfoObj);
		 blnFlag=false;
	 }
	 m1.put("STEPSTATUS", blnFlag);
	 return blnFlag;

}


public synchronized boolean Q2Wall_UserRecover_CancelbuttonClick_ConfirmAlertDismiss(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception
{
	try
	{

		if(cnf.FnExplicitWait("Xpath",mbo.Q2wall_Cancelbtn,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Cancel button is displayed","Cancel button is displayed","PASS",runManagerInfoObj);
			WebElement Q2wall_Cancelbutton=driver.findElement(By.xpath(mbo.Q2wall_Cancelbtn));
			if(cnf.JSClick(Q2wall_Cancelbutton,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Cancel button is clicked","Cancel button is clicked","PASS",runManagerInfoObj);
				Thread.sleep(3000);

				if(cnf.isAlertPresent()){
					driver.switchTo().alert();
					String ErrMsg=driver.switchTo().alert().getText();
					System.out.println(ErrMsg);
					driver.switchTo().alert().dismiss();
					driver.switchTo().defaultContent();
					Thread.sleep(5000);
				}
				else{
					//repfn.FnUpdateTestStepResHTML("verify .... ",".......","PASS/WARNING");// update the reporting function based on your requirement
					System.out.println("No alert present");                                              
				}

				String SecurityCode=m1.get("SecurityCode").toString();
				if(cnf.FnExplicitWait("XPATH", mbo.ForgotUsername_SecurityCode,driver))
				{
					WebElement SecurityCode1=driver.findElement(By.xpath(mbo.ForgotUsername_SecurityCode));
					if(SecurityCode1.getAttribute("value").equals(SecurityCode)){
						repfn.FnUpdateTestStepResHTML("Verify Security Code Value after Cancelling Alert popup", "No changes are made to Security Code Value after Cancelling Alert popup", "PASS",runManagerInfoObj);
						blnFlag=true; 
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Security Code Value after Cancelling Alert popup", "Changes are made to Security Code Value after Cancelling Alert popup", "FAIL",runManagerInfoObj);
						blnFlag=false; 
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify Security Code field is displayed", "Security Code field is not displayed", "FAIL",runManagerInfoObj);
					blnFlag=false;	
				}

				String Account=m1.get("Account Number").toString();
				if(cnf.FnExplicitWait("XPATH", mbo.AccNumber,driver))
				{
					WebElement AccNumber=driver.findElement(By.xpath(mbo.AccNumber));
					if(AccNumber.getAttribute("value").equals(Account)){
						repfn.FnUpdateTestStepResHTML("Verify Account Number Value after Cancelling Alert popup", "No changes are made to Account Number Value after Cancelling Alert popup", "PASS",runManagerInfoObj);
						blnFlag=true; 
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Account Number Value after Cancelling Alert popup", "Changes are made to Account Number Value after Cancelling Alert popup", "FAIL",runManagerInfoObj);
						blnFlag=false; 
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify Account Number field is displayed", "Account Number field is not displayed", "FAIL",runManagerInfoObj);
					blnFlag=false;	
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Cancel button is clicked","Cancel button is not clicked","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Cancel button is displayed","Cancel button is not displayed","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}
	catch(Exception e)
	{
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		blnFlag=false;
		repfn.FnUpdateTestStepResHTML("Verify User is displayed with the same screen without any changes to entered values after clicking cancel in alert popup","User is not displayed with the same screen without any changes to entered values after clicking cancel in alert popup due to some exception","FAIL",runManagerInfoObj);
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;

}
public synchronized boolean forgotPasswordInvalidSecurityAnswer(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{
	try
	{
		if(cnf.FnExplicitlessWait_untilClickable("XPATH", mbo.nextButtonRP,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify if Next button is displayed", "Next button is displayed", "PASS",runManagerInfoObj);
			WebElement nextButton=driver.findElement(By.xpath(mbo.nextButtonRP));
			if(cnf.JSClick(nextButton,driver)){
				repfn.FnUpdateTestStepResHTML("Verify if Next button is clicked", "Next button is clicked", "PASS",runManagerInfoObj);
				
				Thread.sleep(3000);

				if(cnf.FnExplicitWait("XPATH", mbo.nextButtonRP,driver))
				{
					WebElement disabledNext=driver.findElement(By.xpath(mbo.nextButtonRP));
					if(disabledNext.isEnabled()){
						blnFlag=false;
						repfn.FnUpdateTestStepResHTML("User verifies Next button without entering security answer ", "Next button is enabled", "FAIL",runManagerInfoObj);
					}
					else{
						repfn.FnUpdateTestStepResHTML("User verifies Next button without entering Security Answer ", "Next button is not enabled", "PASS",runManagerInfoObj);
						String SecurityAnswer=m1.get("SecurityAnswer").toString();
						if(cnf.FnExplicitWait("ID", mbo.securityAnswerRP,driver))
						{
							repfn.FnUpdateTestStepResHTML("Verify Security Answer field is displayed", "Security Answer field is displayed", "PASS",runManagerInfoObj);
							WebElement securityAnswerRP=driver.findElement(By.id(mbo.securityAnswerRP));
							securityAnswerRP.sendKeys(SecurityAnswer,Keys.TAB);
							repfn.FnUpdateTestStepResHTML("Enter an valid Security Answer", "Valid Security Answer is entered: " +SecurityAnswer, "PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else
						{
							repfn.FnUpdateTestStepResHTML("Verify Security Answer field is displayed", "Security Answer field is not displayed", "FAIL",runManagerInfoObj);
							blnFlag=false;	
						}

						if(cnf.FnExplicitWait("XPATH", mbo.nextButtonRP,driver))
						{
							WebElement nextButtonRP=driver.findElement(By.xpath(mbo.nextButtonRP));
							if(nextButtonRP.isEnabled()){
								repfn.FnUpdateTestStepResHTML("User verifies Next button without entering Security Answer ", "Next button is enabled", "PASS",runManagerInfoObj);
								if(cnf.JSClick(nextButtonRP,driver)){
									repfn.FnUpdateTestStepResHTML("Verify if Next button is clicked", "Next button is clicked", "PASS",runManagerInfoObj);
									if(cnf.FnExplicitWait("XPATH", "//div[@class='block-error-header']//span[@class='alert-icon']",driver))
									{
										blnFlag=true;
										repfn.FnUpdateTestStepResHTML("Verify if error message is displayed", "Error message is displayed", "PASS",runManagerInfoObj);
									}
									else
									{
										blnFlag=false;
										repfn.FnUpdateTestStepResHTML("Verify if error message is displayed", "Error message is not displayed", "FAIL",runManagerInfoObj);
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify if Next button is clicked", "Next button is not clicked", "FAIL",runManagerInfoObj);
									blnFlag=false;	
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("User verifies Next button without entering Security Answer ", "Next button is not enabled", "FAIL",runManagerInfoObj);
								blnFlag=false;	
							}
						}
						else
						{
							blnFlag=false;
							repfn.FnUpdateTestStepResHTML("Verify if Next button is displayed", "Next button is not displayed", "FAIL",runManagerInfoObj);
						}

					}					
				}
				else
				{
					blnFlag=false;
					repfn.FnUpdateTestStepResHTML("Verify if Next button is displayed", "Next button is not displayed", "FAIL",runManagerInfoObj);
				}
			}
			else
			{
				blnFlag=false;
				repfn.FnUpdateTestStepResHTML("Verify if Next button is clicked", "Next button is not clicked", "FAIL",runManagerInfoObj);
			}
		}
		else
		{
			blnFlag=false;
			repfn.FnUpdateTestStepResHTML("Verify if Next button is displayed", "Next button is not displayed", "FAIL",runManagerInfoObj);			
		}

	}
	catch(Exception e)
	{
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());	
		blnFlag=false;
		repfn.FnUpdateTestStepResHTML("Verify Security Answer field is displayed", "Security Answer field is not displayed due to some exception", "FAIL",runManagerInfoObj);
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}

public synchronized boolean FN_SearchText_EnterKey(WebDriver driver,RunManagerInfo runManagerInfoObj){
	try{

		if(cnf.FnExplicitWait("XPATH", mbo.FindLocationUI_Searchtxtbox,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of search text box in Location Finder page", "Search text box is present in Location finder page", "PASS",runManagerInfoObj);
			WebElement SearchTextbox=driver.findElement(By.xpath(mbo.FindLocationUI_Searchtxtbox));

			SearchTextbox.sendKeys(m1.get("Pincode").toString());

			repfn.FnUpdateTestStepResHTML("Enter the required keyword in the search text entry field.", "User should be able to key in the value.", "PASS",runManagerInfoObj);
			SearchTextbox.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			repfn.FnUpdateTestStepResHTML("Verify User Click on the ENTER key ","'Enter' Key is clicked", "PASS",runManagerInfoObj);
			blnFlag=FN_LocationFinder_SearchResults(driver,runManagerInfoObj);

			if(blnFlag){
				blnFlag =  true;
			}
			else{
				blnFlag =  false;
			}

		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of search text box in Location Finder page", "Search text box is not present in Location finder page", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}
	catch (Exception e)

	{
		repfn.FnUpdateTestStepResHTML("Verify the presence of search text box in Location Finder page", "Search text box is not present in Location finder page due to some exception", "FAIL",runManagerInfoObj);
		blnFlag=false;

		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;

}

public synchronized boolean FN_SearchText_GoButton(WebDriver driver,RunManagerInfo runManagerInfoObj){
	try{

		if(cnf.FnExplicitWait("XPATH", mbo.FindLocationUI_Searchtxtbox,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of search text box in Location Finder page", "Search text box is present in Location finder page", "PASS",runManagerInfoObj);
			WebElement SearchTextbox=driver.findElement(By.xpath(mbo.FindLocationUI_Searchtxtbox));
			SearchTextbox.clear();
			SearchTextbox.sendKeys(m1.get("NewPincode").toString());
			repfn.FnUpdateTestStepResHTML("Enter the required keyword in the search text entry field.", "User should be able to key in the value.", "PASS",runManagerInfoObj);

			if(cnf.FnExplicitWait("XPATH", mbo.FindLocationUI_GoBtn,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify the presence of Go button in Location Finder page", "Go button is present in Location finder page", "PASS",runManagerInfoObj);
				WebElement gotobutton=driver.findElement(By.xpath(mbo.FindLocationUI_GoBtn));
				if(cnf.JSClick(gotobutton,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Go button in Location Finder page is clicked", "Go button in Location Finder page is clicked", "PASS",runManagerInfoObj);

					Thread.sleep(3000);
					blnFlag=FN_LocationFinder_SearchResults(driver,runManagerInfoObj);

					if(blnFlag){
						blnFlag=true;
					}
					else{
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Go button in Location Finder page is clicked", "Go button in Location Finder page is not clicked", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify the presence of Go button in Location Finder page", "Go button is not present in Location finder page", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of search text box in Location Finder page", "Search text box is not present in Location finder page", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}
	catch (Exception e)

	{
		repfn.FnUpdateTestStepResHTML("Verify the presence of search text box in Location Finder page", "Search text box is not present in Location finder page due to some exception", "FAIL",runManagerInfoObj);
		blnFlag=false;

		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}
    m1.put("STEPSTATUS", blnFlag);
    return blnFlag;
  
}

public synchronized boolean FN_LocationFinder_SearchResults(WebDriver driver,RunManagerInfo runManagerInfoObj){
	try{

		if(cnf.FnExplicitWait("Xpath", mbo.SearchResults,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of search Results", "Search Result is displayed", "PASS",runManagerInfoObj);
			List<WebElement> SearchResults_Clientaddress=driver.findElements(By.xpath(mbo.SearchResults_Clientaddress));
			System.out.println(SearchResults_Clientaddress.size());
			if(SearchResults_Clientaddress.size()<=3 && SearchResults_Clientaddress.size()>0)
			{
				for(int i=0;i<SearchResults_Clientaddress.size();i++)
				{
					repfn.FnUpdateTestStepResHTML("Verify that the top 3 closest locations to the client's service address are displayed ","The top 3 closest locations to the client's service address are displayed: "+SearchResults_Clientaddress.get(i).getText(), "PASS",runManagerInfoObj);
				}

				if(cnf.FnExplicitWait("Xpath", mbo.SearchResults_Clientaddress_Duration,driver))
				{
					List<WebElement> SearchResults_Clientaddress_Duration=driver.findElements(By.xpath(mbo.SearchResults_Clientaddress_Duration));

					for(int i=0;i<SearchResults_Clientaddress_Duration.size();i++){
						repfn.FnUpdateTestStepResHTML("Verify that the hours of operation are displayed for each location","The hours of operation are displayed for location "+(i+1), "PASS",runManagerInfoObj);
					}
					blnFlag=true;

				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify that the hours of operation are displayed for each location","The hours of operation are not displayed for each location", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify that the top 3 closest locations to the client's service address are displayed ","The top 3 closest locations to the client's service address are not  displayed", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify the presence of search Results", "Search Result is not displayed", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}
	catch (Exception e)

    {
		// repfn.FnUpdateTestStepResHTML("Verify that the hours of operation & client address are displayed are displayed for each location","the hours of operation & client address are not  displayed for each location due to some exception", "FAIL",runManagerInfoObj);
         //blnFlag=false;

           System.err.println("Message : "+e.getMessage());
           System.err.println("Cause : "+e.getCause());
          
    }
    m1.put("STEPSTATUS", blnFlag);
    return blnFlag;
  
}


//Saranya[12/15/2015]




public synchronized boolean Q2Wall_FnValidBankAccountNumber(WebDriver driver,RunManagerInfo runManagerInfoObj){
	
	String validBankAccountNumber = m1.get("BankAccountNumber").toString();

	
	try{
		
		driver.switchTo().frame("iFrameResizer0");
		
		if(cnf.FnExplicitWait("XPATH", mbo.Q2wall_BankAccountNumber,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Bank Account Number field is displayed under Payment Information option",
  					"Bank Account Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
			WebElement BankAccountNumber=driver.findElement(By.xpath(mbo.Q2wall_BankAccountNumber));
			BankAccountNumber.sendKeys(validBankAccountNumber);
			repfn.FnUpdateTestStepResHTML("Verify  valid Bank Account Number is entered ","Bank Account Number: " +validBankAccountNumber + " is entered","PASS",runManagerInfoObj);
			
			if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_CheckImg,driver)){
 				WebElement Q2Wall_CheckImg=driver.findElement(By.xpath(mbo.Q2Wall_CheckImg));
 				cnf.JSClick(Q2Wall_CheckImg,driver);
 				repfn.FnUpdateTestStepResHTML("Verify Check image is displayed and clicked","Check image is displayed and clicked","PASS",runManagerInfoObj);
 				blnFlag=true;
 			}
 			else{
 				repfn.FnUpdateTestStepResHTML("Verify Check image is displayed and clicked","Check image is not displayed and clicked","FAIL",runManagerInfoObj);
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




public synchronized boolean Q2Wall_FnValidPaymentAmount(WebDriver driver,RunManagerInfo runManagerInfoObj){
 	
 	String validPaymentAmountOne = m1.get("Amount").toString();
 	
 	
 	try{
 		
 		driver.switchTo().frame("iFrameResizer0");
 		
 		if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_PaymentAmount,driver)){
 			repfn.FnUpdateTestStepResHTML("Verify Payment Amount field is displayed under Payment Information option",
   					"Payment Amount field is displayed under Payment Information option","PASS",runManagerInfoObj);
 			WebElement PaymentAmount=driver.findElement(By.xpath(mbo.Q2Wall_PaymentAmount));
 		
 			PaymentAmount.sendKeys(validPaymentAmountOne);
 			repfn.FnUpdateTestStepResHTML("Verify  Valid Payment Amount is entered ","Payment Amount : " +validPaymentAmountOne + " is entered  ","PASS",runManagerInfoObj);
 			
 			if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_CheckImg,driver)){
 				WebElement Q2Wall_CheckImg=driver.findElement(By.xpath(mbo.Q2Wall_CheckImg));
 				cnf.JSClick(Q2Wall_CheckImg,driver);
 				repfn.FnUpdateTestStepResHTML("Verify Check image is displayed and clicked","Check image is displayed and clicked","PASS",runManagerInfoObj);
 				blnFlag=true;
 			}
 			else{
 				repfn.FnUpdateTestStepResHTML("Verify Check image is displayed and clicked","Check image is not displayed and clicked","FAIL",runManagerInfoObj);
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


public synchronized boolean Q2Wall_FnValidRoutingNumber(WebDriver driver,RunManagerInfo runManagerInfoObj){
 	
 	String validRoutingNumberOne = m1.get("RoutingNumber").toString();
 
 	
 	try{
 		
 		driver.switchTo().frame("iFrameResizer0");
 		
 		if(cnf.FnExplicitWait("XPATH", mbo.Q2wall_RoutingNumber,driver)){
 			repfn.FnUpdateTestStepResHTML("Verify Routing Number field is displayed under Payment Information option",
   					"Routing Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
 			WebElement RoutingNumber=driver.findElement(By.xpath(mbo.Q2wall_RoutingNumber));
 			RoutingNumber.sendKeys(validRoutingNumberOne);
 			repfn.FnUpdateTestStepResHTML("Verify Valid Routing Number is entered ","Routing Number : " +validRoutingNumberOne + " is entered  ","PASS",runManagerInfoObj);
 			
 			if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_CheckImg,driver)){
 				WebElement Q2Wall_CheckImg=driver.findElement(By.xpath(mbo.Q2Wall_CheckImg));
 				cnf.JSClick(Q2Wall_CheckImg,driver);
 				repfn.FnUpdateTestStepResHTML("Verify Check image is displayed and clicked","Check image is displayed and clicked","PASS",runManagerInfoObj);
 				blnFlag=true;
 			}
 			else{
 				repfn.FnUpdateTestStepResHTML("Verify Check image is displayed and clicked","Check image is not displayed and clicked","FAIL",runManagerInfoObj);
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



public synchronized boolean Q2Wall_Fn_VerifyPaymentDateField_PreviousDate(WebDriver driver,RunManagerInfo runManagerInfoObj){

	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.DATE,-1);
	Date d=cal.getTime();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

	String currentDate=sdf.format(d);

	String dateArray[]=currentDate.split("/");
	String year=dateArray[0];
	String month=dateArray[1];
	String day=dateArray[2];
	System.out.println(day);
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
				PaymentDate.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),PreviousPaymentDateChrome);
				repfn.FnUpdateTestStepResHTML("Verify Previuos Payment Date is entered","Payment date entered: " +PreviousPaymentDateChrome ,"PASS",runManagerInfoObj);


			}else {
				PaymentDate.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),PreviousPaymentDate);
				repfn.FnUpdateTestStepResHTML("Verify Previuos Payment Date is entered","Payment date entered: " +PreviousPaymentDate ,"PASS",runManagerInfoObj);
			}


			if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_CheckImg,driver)){
				WebElement Q2Wall_CheckImg=driver.findElement(By.xpath(mbo.Q2Wall_CheckImg));
				cnf.JSClick(Q2Wall_CheckImg,driver);
				repfn.FnUpdateTestStepResHTML("Verify Check image is displayed and clicked","Check image is displayed and clicked","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Check image is displayed and clicked","Check image is not displayed and clicked","FAIL",runManagerInfoObj);
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

public synchronized boolean Q2Wall_Fn_VerifyPaymentDateField_FutureDate(WebDriver driver,RunManagerInfo runManagerInfoObj){

	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.DATE,5);
	Date d=cal.getTime();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

	String currentDate=sdf.format(d);

	String dateArray[]=currentDate.split("/");
	String year=dateArray[0];
	String month=dateArray[1];
	String day=dateArray[2];
	String FuturePaymentDate = (month)+"/"+(day)+"/"+year;
	String FuturePaymentDateChrome = (month)+"/"+(day);


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
				PaymentDate.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),FuturePaymentDateChrome);
				repfn.FnUpdateTestStepResHTML("Verify Future Payment Date is entered","Payment date entered: " +FuturePaymentDateChrome ,"PASS",runManagerInfoObj);


			}else {
				PaymentDate.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),FuturePaymentDate);
				repfn.FnUpdateTestStepResHTML("Verify Future Payment Date is entered","Payment date entered: " +FuturePaymentDate ,"PASS",runManagerInfoObj);
			}


			if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_CheckImg,driver)){
				WebElement Q2Wall_CheckImg=driver.findElement(By.xpath(mbo.Q2Wall_CheckImg));
				cnf.JSClick(Q2Wall_CheckImg,driver);
				repfn.FnUpdateTestStepResHTML("Verify Check image is displayed and clicked","Check image is displayed and clicked","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Check image is displayed and clicked","Check image is not displayed and clicked","FAIL",runManagerInfoObj);
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
public synchronized boolean Q2Wall_Fn_VerifyPaymentDateField_CurrentDate(WebDriver driver,RunManagerInfo runManagerInfoObj){

	Date d=Calendar.getInstance().getTime();

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

	String currentDate=sdf.format(d);

	String dateArray[]=currentDate.split("/");
	String year=dateArray[0];
	String month=dateArray[1];
	String day=dateArray[2];
	String CurrentPaymentDate = (month)+"/"+(day)+"/"+year;
	String CurrentPaymentDateChrome = (month)+"/"+(day);


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
				PaymentDate.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),CurrentPaymentDateChrome);
				repfn.FnUpdateTestStepResHTML("Verify Current Payment Date is entered","Payment date entered: " +CurrentPaymentDateChrome ,"PASS",runManagerInfoObj);


			}else {
				PaymentDate.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),CurrentPaymentDate);
				repfn.FnUpdateTestStepResHTML("Verify Current Payment Date is entered","Payment date entered: " +CurrentPaymentDate ,"PASS",runManagerInfoObj);
			}


			if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_CheckImg,driver)){
				WebElement Q2Wall_CheckImg=driver.findElement(By.xpath(mbo.Q2Wall_CheckImg));
				cnf.JSClick(Q2Wall_CheckImg,driver);
				repfn.FnUpdateTestStepResHTML("Verify Check image is displayed and clicked","Check image is displayed and clicked","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Check image is displayed and clicked","Check image is not displayed and clicked","FAIL",runManagerInfoObj);
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


public synchronized boolean Q2Wall_FnVerifyPayBillButtonEnabled(WebDriver driver,RunManagerInfo runManagerInfoObj){

	try{

		driver.switchTo().frame("iFrameResizer0");
		Thread.sleep(2000);
		if(cnf.FnExplicitWait("XPATH", mbo.PayNowButton,driver)){
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(mbo.PayNowButton)));   
			repfn.FnUpdateTestStepResHTML("Verify Pay Now button is displayed","Pay Now button is displayed","PASS",runManagerInfoObj);
			WebElement PayNowButton=driver.findElement(By.xpath(mbo.PayNowButton));
			//cnf.ScrollToView(PayNowButton);
			if(PayNowButton.isEnabled()){
				repfn.FnUpdateTestStepResHTML("Verify Pay Now button is enabled","Pay Now button is enabled","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Pay Now button is enabled","Pay Now button is not enabled.","FAIL",runManagerInfoObj);
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

/*
 * 
 * EDIT UI
 */


/*
 * 
 * Verify the UI of the User details window in Edit mode
 * 
 * 
 */




public synchronized boolean Q2Wall_CreditDebit_PreviousDate(WebDriver driver,RunManagerInfo runManagerInfoObj)
{
	  
	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.DATE,-1);
	Date d=cal.getTime();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

	String currentDate=sdf.format(d);

	String dateArray[]=currentDate.split("/");
	String year=dateArray[0];
	String month=dateArray[1];
	String day=dateArray[2];
	System.out.println(day);
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
				PaymentDate.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),PreviousPaymentDateChrome);
				repfn.FnUpdateTestStepResHTML("Verify Previuos Payment Date is entered","Payment date entered: " +PreviousPaymentDateChrome ,"PASS",runManagerInfoObj);


			}
			else {
				PaymentDate.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),PreviousPaymentDate);
				repfn.FnUpdateTestStepResHTML("Verify Previuos Payment Date is entered","Payment date entered: " +PreviousPaymentDate ,"PASS",runManagerInfoObj);
			}


			/*if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_CheckImg)){
					WebElement Q2Wall_CheckImg=driver.findElement(By.xpath(mbo.Q2Wall_CheckImg));
					cnf.JSClick(Q2Wall_CheckImg);
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Check image is displayed and clicked","Check image is not displayed and clicked","FAIL",runManagerInfoObj);
					blnFlag=false;
				}*/
		}
		else
		{
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

public synchronized boolean Q2Wall_CreditDebit_FutureDate(WebDriver driver,RunManagerInfo runManagerInfoObj){

	Calendar cal   =Calendar.getInstance();
	cal.add(Calendar.DATE,5);
	Date d=cal.getTime();
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
				PaymentDate.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),PreviousPaymentDateChrome);
				repfn.FnUpdateTestStepResHTML("Verify Future Payment Date is entered","Payment date entered: " +PreviousPaymentDateChrome ,"PASS",runManagerInfoObj);


			}else {
				PaymentDate.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),PreviousPaymentDate);
				repfn.FnUpdateTestStepResHTML("Verify Future Payment Date is entered","Payment date entered: " +PreviousPaymentDate ,"PASS",runManagerInfoObj);
			}


			/*if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_CheckImg)){
					WebElement Q2Wall_CheckImg=driver.findElement(By.xpath(mbo.Q2Wall_CheckImg));
					cnf.JSClick(Q2Wall_CheckImg);
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Check image is displayed and clicked","Check image is not displayed and clicked","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			 */


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
	public synchronized boolean Q2Wall_CreditDebit_CurrentDate(WebDriver driver,RunManagerInfo runManagerInfoObj){
		
		Date d=Calendar.getInstance().getTime();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		String currentDate=sdf.format(d);

		String dateArray[]=currentDate.split("/");
		String year=dateArray[0];
		String month=dateArray[1];
		String day=dateArray[2];
		String CurrentPaymentDate = (month)+"/"+(day)+"/"+year;
		String CurrentPaymentDateChrome = (month)+"/"+(day);

		
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
				PaymentDate.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),CurrentPaymentDateChrome);
				repfn.FnUpdateTestStepResHTML("Verify Current Payment Date is entered","Payment date entered: " +CurrentPaymentDateChrome ,"PASS",runManagerInfoObj);
				
				
			}else {
				PaymentDate.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),CurrentPaymentDate);
				repfn.FnUpdateTestStepResHTML("Verify Current Payment Date is entered","Payment date entered: " +CurrentPaymentDate ,"PASS",runManagerInfoObj);
			}
			
				
			/*if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_CheckImg)){
					WebElement Q2Wall_CheckImg=driver.findElement(By.xpath(mbo.Q2Wall_CheckImg));
					cnf.JSClick(Q2Wall_CheckImg);
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Check image is displayed and clicked","Check image is not displayed and clicked","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				*/
				
					
				
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

	public synchronized boolean Q2Wall_VerifyPayBillButtonEnabled(WebDriver driver,RunManagerInfo runManagerInfoObj){
	   	
	   	try{
	   		
	   		driver.switchTo().frame("iFrameResizer0");
	   		Thread.sleep(2000);
	   		if(cnf.FnExplicitWait("XPATH", mbo.PayNowButton,driver)){
	   			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(mbo.PayNowButton)));   
	   			repfn.FnUpdateTestStepResHTML("Verify Pay Now button is displayed","Pay Now button is displayed","PASS",runManagerInfoObj);
	   			WebElement PayNowButton=driver.findElement(By.xpath(mbo.PayNowButton));
	   			//cnf.ScrollToView(PayNowButton);
	   			if(PayNowButton.isEnabled()){
	   				repfn.FnUpdateTestStepResHTML("Verify Pay Now button is enabled","Pay Now button is enabled","PASS",runManagerInfoObj);
	   				blnFlag=true;
	   			}
	   			else{
               repfn.FnUpdateTestStepResHTML("Verify Pay Now button is enabled","Pay Now button is not enabled.","FAIL",runManagerInfoObj);
	   				
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
	
      
	  public synchronized boolean CreditDebit_AccNo(WebDriver driver,RunManagerInfo runManagerInfoObj)
	  {
	  	String CardNumber = m1.get("CardNumber").toString();
	  	
	  	 try
	  	 {
	  		 driver.switchTo().frame("iFrameResizer0");
	  		 if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_CardNum,driver))
	  		 {
	  			 repfn.FnUpdateTestStepResHTML("Verify if Card Number field is displayed", "Card Number field is displayed", "PASS",runManagerInfoObj);
	  			 WebElement Card=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_CardNum));
	  			 Card.sendKeys(CardNumber,Keys.TAB);
	  			 repfn.FnUpdateTestStepResHTML("Enter a valid Credit/Debit Card number","Credit/Debit Card number is entered" , "PASS",runManagerInfoObj);
	  			 blnFlag=true;			 
	  		 }
	  		 else
	  		 {
	  			 repfn.FnUpdateTestStepResHTML("Verify if Card Number field is displayed", "Card Number field is not displayed", "FAIL",runManagerInfoObj);
	  			 blnFlag=false;
	  		 }

	  		 driver.switchTo().defaultContent();
	  	 }
	  	 catch(Exception e)
	  	 {
	  		 System.err.println("Message : "+e.getMessage());
	  		 System.err.println("Cause : "+e.getCause());	
	  		 repfn.FnUpdateTestStepResHTML("Verify if Card Number field is displayed", "Card Number field is not displayed", "FAIL",runManagerInfoObj);
	  		 blnFlag=false;
	  	 }
	  	 m1.put("STEPSTATUS", blnFlag);
	  	 return blnFlag;

	  }

	  public synchronized boolean CreditDebit_ExpiryDate(WebDriver driver,RunManagerInfo runManagerInfoObj)
	  {
	  	String expMonthOne = null;
	  	try
	  	{
	  		driver.switchTo().frame("iFrameResizer0");
	  		String ExpMonth=m1.get("ExpMonth").toString();
	  		System.out.println("0"+ExpMonth);
	  		int expMonth = Integer.parseInt(ExpMonth);

	  		if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_ExpMonth,driver))
	  		{
	  			repfn.FnUpdateTestStepResHTML("Verify if Expiry Month field is displayed", "Expiry Month field is displayed", "PASS",runManagerInfoObj);
	  			if((expMonth)<10){
	  				expMonthOne = "0"+ExpMonth;
	  				System.out.println(expMonthOne);
	  			}
	  			else{
	  				expMonthOne = ExpMonth;
	  			}

	  			WebElement ExpDate_Month=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_ExpMonth));
	  			ExpDate_Month.sendKeys(expMonthOne,Keys.TAB);
	  			repfn.FnUpdateTestStepResHTML("Verify particular month is entered", "A particular month is entered", "PASS",runManagerInfoObj);
	  			blnFlag=true;


	  			//Thread.sleep(3000);
	  			//PayBill_CreditDebit_Selectdropdown();		
	  		}
	  		else{
	  			repfn.FnUpdateTestStepResHTML("Verify if Expiry Month field is displayed", "Expiry Month field is not displayed", "FAIL",runManagerInfoObj);
	  			blnFlag=false;
	  		}

	  		driver.switchTo().defaultContent();

	  	}
	  	catch(Exception e)
	  	{
	  		System.err.println("Message : "+e.getMessage());
	  		System.err.println("Cause : "+e.getCause());	
	  	}
	  	m1.put("STEPSTATUS", blnFlag);
	  	return blnFlag;

	  }

	  public synchronized boolean CreditDebit_ExpiryYear(WebDriver driver,RunManagerInfo runManagerInfoObj)
	  {
	  	 try
	  	 {
	  		 driver.switchTo().frame("iFrameResizer0");
	  		 String ExpYear=m1.get("ExpYear").toString();
	  		 if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_ExpYear,driver))
	  		 {
	  			 repfn.FnUpdateTestStepResHTML("Verify if Expiry Year field is displayed", "Expiry Year field is displayed", "PASS",runManagerInfoObj);
	  			 WebElement PayBill_CreditDebit_ExpYear=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_ExpYear));
	  			 PayBill_CreditDebit_ExpYear.sendKeys(ExpYear,Keys.TAB);
	  			 repfn.FnUpdateTestStepResHTML("Verify particular year is entered", "A particular year is entered", "PASS",runManagerInfoObj);
	  			 blnFlag=true;

	  			 //Thread.sleep(3000);
	  			 //PayBill_CreditDebit_SelectdropdownYear();
	  		 }
	  		 else{
	  			 repfn.FnUpdateTestStepResHTML("Verify if Expiry Year field is displayed", "Expiry Year field is not displayed", "FAIL",runManagerInfoObj);
	  			 blnFlag=false;
	  		 }

	  		 driver.switchTo().defaultContent();
	  	 }
	  	 catch(Exception e)
	  	 {
	  		 System.err.println("Message : "+e.getMessage());
	  		 System.err.println("Cause : "+e.getCause());	
	  	 }
	  	 m1.put("STEPSTATUS", blnFlag);
	  	 return blnFlag;

	  }

	  public synchronized boolean CreditDebit_PayAmount(WebDriver driver,RunManagerInfo runManagerInfoObj)
	  {
	  	 try
	  	 {
	  		 driver.switchTo().frame("iFrameResizer0");
	  		 if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_Amount,driver))
	  		 {
	  			 repfn.FnUpdateTestStepResHTML("Verify if Payment Amount field is displayed", "Payment Amount field is displayed", "PASS",runManagerInfoObj);
	  			 WebElement Card=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_Amount));
	  			 if(Card.isDisplayed())
	  			 {
	  				 Card.sendKeys("10.00",Keys.TAB);
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

	  		 driver.switchTo().defaultContent();
	  	 }
	  	 catch(Exception e)
	  	 {
	  		 System.err.println("Message : "+e.getMessage());
	  		 System.err.println("Cause : "+e.getCause());	
	  	 }
	  	 m1.put("STEPSTATUS", blnFlag);
	  	 return blnFlag;

	  }

	  public synchronized boolean CreditDebit_PayDate(WebDriver driver,RunManagerInfo runManagerInfoObj)
	  {
	  	 try
	  	 {
	  		 SimpleDateFormat curFormater = new SimpleDateFormat("MM/dd/yyyy"); 
	  		 Calendar calendar=Calendar.getInstance();
	  		 calendar.add(Calendar.DATE, 2);
	  		 Date dateObj = calendar.getTime(); 
	  		 String paymentDateInString=curFormater.format(dateObj);
	  		 String dateArray[]=paymentDateInString.split("/");
	          String month=dateArray[0];
	          String day=dateArray[1];
	          String year=dateArray[2];
	          String validPaymentDateChrome = (month)+"/"+day+"/"+year;
	  		if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_PayDate,driver))
	  		{
	  			repfn.FnUpdateTestStepResHTML("Verify if Payment Date field is displayed", "Payment Date field is displayed", "PASS",runManagerInfoObj);
	  			WebElement Card=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_PayDate));
	  			if(Card.isDisplayed())
	  			{
	  				Card.sendKeys(validPaymentDateChrome,Keys.TAB);
	  				repfn.FnUpdateTestStepResHTML("Enter a valid Payment Date","Payment Date is entered" , "PASS",runManagerInfoObj);
	  				blnFlag=true;
	  			}
	  			else
	  			{
	  				repfn.FnUpdateTestStepResHTML("Enter a valid Payment Date","Payment Date is not entered" , "FAIL",runManagerInfoObj);
	  				blnFlag=false;
	  			}
	  		}
	  		else
	  		{
	  			repfn.FnUpdateTestStepResHTML("Verify if Payment Date field is displayed", "Payment Date field is not displayed", "FAIL",runManagerInfoObj);
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

	  public synchronized boolean VerifyPay_AllFields(WebDriver driver,RunManagerInfo runManagerInfoObj)
	  {
	  	 try
	  	 {
	  		 if(cnf.FnExplicitWait("XPATH", mbo.VerifyPay_Heading,driver))
	  		 {
	  			 repfn.FnUpdateTestStepResHTML("Check if Verify Payment Information heading is displayed", "Verify Payment Information heading is displayed", "PASS",runManagerInfoObj);
	  			 blnFlag=true;
	  		 }
	  		 else
	  		 {
	  			 repfn.FnUpdateTestStepResHTML("Check if Verify Payment Information heading is displayed", "Verify Payment Information heading is not displayed", "FAIL",runManagerInfoObj);
	  			 blnFlag=false; 
	  		 }
	  		 
	  		 if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentInfo_Hdr,driver))
	  		 {
	  			 repfn.FnUpdateTestStepResHTML("Check if Payment Summary sub-heading  is displayed", "Payment Summary sub- heading is displayed", "PASS",runManagerInfoObj);
	  			 blnFlag=true; 
	  		 }
	  		 else
	  		 {
	  			 repfn.FnUpdateTestStepResHTML("Check if Payment Summary sub-heading  is displayed", "Payment Summary sub- heading is not displayed", "FAIL",runManagerInfoObj);
	  			 blnFlag=false; 
	  		 }
	  		 if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_VerifyCard,driver))
	  		 {
	  			 String Card=m1.get("Lastfourdigitscard").toString();
	  			 WebElement No=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_VerifyCard));
	  			 repfn.FnUpdateTestStepResHTML("Verify if Card Number is displayed", "Card Number is displayed", "PASS",runManagerInfoObj);
	  			 if(No.getAttribute("textContent").contains("Visa *"+Card))
	  			 {
	  				 repfn.FnUpdateTestStepResHTML("Verify if Credit Card number entered in Pay bill page is retained in Verify Payment Information screen", "Credit Card number entered in Pay bill page is retained in Verify Payment Information screen" , "PASS",runManagerInfoObj);
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
	  			 repfn.FnUpdateTestStepResHTML("Verify if Card Number is displayed", "Card Number is not displayed", "FAIL",runManagerInfoObj);
	  			 blnFlag=false;
	  		 }
	  		
	  		 
	  		 if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_VerifyExp,driver))
	  	 		{
	  	 			String ExpiryDate=m1.get("ExpDate").toString();
	  	 			WebElement ExpDate=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_VerifyExp));
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
	  	 		
	  	 		if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_VerifyAmnt,driver))
	  	 		{
	  	 			String PayMount=m1.get("Amount").toString();
	  	 			WebElement PayAmount=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_VerifyAmnt));
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
	  	 		
	  	 		/*if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_VerifyPayDate))
	  	 		{
	  	 			String Date=m1.get("PayDate").toString();
	  	 			WebElement PayDate=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_VerifyPayDate));
	  	 			repfn.FnUpdateTestStepResHTML("Verify if Payment Date is displayed", "Payment Date is displayed", "PASS",runManagerInfoObj);
	  	 			if(PayDate.getAttribute("textContent").contains(Date))
	  	 			{
	  	 				repfn.FnUpdateTestStepResHTML("Verify if Payment Date entered in Pay bill page is retained in Verify Payment Information screen", "Payment Date entered in Pay bill page is retained in Verify Payment Information screen: " +PayDate.getAttribute("textContent"), "PASS",runManagerInfoObj);
	  	 				blnFlag=true;
	  	 			}
	  	 			else
	  	 			{
	  	 				repfn.FnUpdateTestStepResHTML("Verify if Payment Date entered in Pay bill page is retained in Verify Payment Information screen", "Payment Date entered in Pay bill page is not retained in Verify Payment Information screen", "FAIL",runManagerInfoObj);
	  	 				blnFlag=false;	
	  	 			}
	  	 		}
	  	 		else
	  	 		{
	  	 			repfn.FnUpdateTestStepResHTML("Verify if Payment Date is displayed", "Payment Date is not displayed", "FAIL",runManagerInfoObj);
	  	 			blnFlag=false;
	  	 		}
	  */	 		
	  	 		if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentInfo_EditPayLink,driver))
	  	 		{
	  	 			repfn.FnUpdateTestStepResHTML("Verify if Edit Pay Link is present", "Edit Pay Link is present", "PASS",runManagerInfoObj);
	  	 			blnFlag=true;
	  	 		}
	  	 		else
	  	 		{
	  	 			repfn.FnUpdateTestStepResHTML("Verify if Edit Pay Link is present", "Edit Pay Link is not present", "FAIL",runManagerInfoObj);
	  	 			blnFlag=false;
	  	 		}
	  	 		if(cnf.FnExplicitWait("XPATH", mbo.CreditDebit_VerifyPay_Cancel,driver))
	  	 		{
	  	 			repfn.FnUpdateTestStepResHTML("Verify if Cancel button is present", "Cancel payment button is present", "PASS",runManagerInfoObj);
	  	 			blnFlag=true;
	  	 		}
	  	 		else
	  	 		{
	  	 			repfn.FnUpdateTestStepResHTML("Verify if Cancel button is present", "Cancel payment button is not present", "FAIL",runManagerInfoObj);
	  	 			blnFlag=false;
	  	 		}
	  	 		
	  	 		if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentInfo_CompletePaymentBtn,driver))
	  	 		{
	  	 			repfn.FnUpdateTestStepResHTML("Verify if Complete Payment button is present", "Complete payment button is present", "PASS",runManagerInfoObj);
	  	 			blnFlag=true;
	  	 		}
	  	 		else
	  	 		{
	  	 			repfn.FnUpdateTestStepResHTML("Verify if Complete Payment button is present", "Complete Payment button is not present", "FAIL",runManagerInfoObj);
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
	  public synchronized boolean CreditDebitPaymentSelection(WebDriver driver,RunManagerInfo runManagerInfoObj)
	  {
	  	try
	  	{
	  		Thread.sleep(5000);
	  		driver.switchTo().frame("iFrameResizer0");
	  		if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_PayBill_SelectPaymentType,driver))
	  		{
	  			repfn.FnUpdateTestStepResHTML("Verify the presence of select payment type section in pay bill screen", "Select payment type section is present in pay bill screen", "PASS",runManagerInfoObj);
	  			if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_PayBill_CreditDebitOption,driver))
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of Credit/Debit option", "Credit/Debit option is present", "PASS",runManagerInfoObj);
	  				if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_PayBill_CreditDebitRadioBtn,driver))
	  				{
	  					repfn.FnUpdateTestStepResHTML("Verify the presence of Credit/Debit radio button", "Credit/Debit radio button is present", "PASS",runManagerInfoObj);
	  					WebElement CreditDebitRadioBtn=driver.findElement(By.xpath(mbo.Q2Wall_PayBill_CreditDebitRadioBtn));
	  					if(cnf.JSClick(CreditDebitRadioBtn,driver))
	  					{
	  						repfn.FnUpdateTestStepResHTML("Verify the Credit/Debit radio button is clicked", "Credit/Debit radio button is clicked", "PASS",runManagerInfoObj);
	  						if(CreditDebitRadioBtn.isSelected())
	  						{
	  							repfn.FnUpdateTestStepResHTML("Verify the Credit/Debit radio button is checked", "Credit/Debit radio button is checked", "PASS",runManagerInfoObj);
	  							blnFlag=true;
	  						}
	  						else
	  						{
	  							repfn.FnUpdateTestStepResHTML("Verify the Credit/Debit radio button is checked", "Credit/Debit radio button is not checked", "FAIL",runManagerInfoObj);
	  							blnFlag=false;
	  						}
	  					}
	  					else
	  					{
	  						repfn.FnUpdateTestStepResHTML("Verify the Credit/Debit radio button is clicked", "Credit/Debit radio button is not clicked", "FAIL",runManagerInfoObj);
	  						blnFlag=false;
	  					}

	  				}
	  				else
	  				{
	  					repfn.FnUpdateTestStepResHTML("Verify the presence of Credit/Debit radio button", "Credit/Debit radio button is not present", "FAIL",runManagerInfoObj);
	  					blnFlag=false;
	  				}
	  			}
	  			else
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of Credit/Debit option", "Credit/Debit option is not present", "FAIL",runManagerInfoObj);
	  				blnFlag=false;
	  			}
	  		}
	  		else
	  		{
	  			repfn.FnUpdateTestStepResHTML("Verify the presence of select payment type section in pay bill screen", "Select payment type section is not present in pay bill screen", "FAIL",runManagerInfoObj);
	  			blnFlag=false;
	  		}
	  		driver.switchTo().defaultContent();

	  	}
	  	catch (Exception e)

	  	{
	  		repfn.FnUpdateTestStepResHTML("Verify User is in select payment type section","User is not in select payment type section due to some exception ","FAIL",runManagerInfoObj);


	  		System.err.println("Message : "+e.getMessage());
	  		System.err.println("Cause : "+e.getCause());
	  		blnFlag=false;
	  	}
	  	m1.put("STEPSTATUS", blnFlag);
	  	return blnFlag;
	  }
	  //Jhansi Dec 16,2015
	  //Verify the OTP is selected
	  public synchronized boolean OTPSelection(WebDriver driver,RunManagerInfo runManagerInfoObj)
	  {
	  	try
	  	{
	  		driver.switchTo().frame("iFrameResizer0");
	  		if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_PayBill_PaymentFreq,driver))
	  		{
	  			repfn.FnUpdateTestStepResHTML("Verify the presence of payment frequency section in pay bill screen", "Payment frequency section is present in pay bill screen", "PASS",runManagerInfoObj);
	  			if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_PayBill_OTPOption,driver))
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of OTP option", "OTP option is present", "PASS",runManagerInfoObj);
	  				if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_PayBill_OTPRadioBtn,driver))
	  				{
	  					repfn.FnUpdateTestStepResHTML("Verify the presence of OTP radio button", "OTP radio button is present", "PASS",runManagerInfoObj);
	  					WebElement OTPRadioBtn=driver.findElement(By.xpath(mbo.Q2Wall_PayBill_OTPRadioBtn));
	  					if(cnf.JSClick(OTPRadioBtn,driver))
	  					{
	  						repfn.FnUpdateTestStepResHTML("Verify the OTP radio button is clicked", "OTP radio button is clicked", "PASS",runManagerInfoObj);

	  						if(OTPRadioBtn.isSelected())
	  						{
	  							repfn.FnUpdateTestStepResHTML("Verify the OTP radio button is checked", "OTP radio button is checked", "PASS",runManagerInfoObj);
	  							blnFlag=true;
	  						}
	  						else
	  						{
	  							repfn.FnUpdateTestStepResHTML("Verify the OTP radio button is checked", "OTP radio button is not checked", "FAIL",runManagerInfoObj);
	  							blnFlag=false;
	  						}
	  					}
	  					else
	  					{
	  						repfn.FnUpdateTestStepResHTML("Verify the OTP radio button is clicked", "OTP radio button is not clicked", "FAIL",runManagerInfoObj);
	  						blnFlag=false;
	  					}


	  				}
	  				else
	  				{
	  					repfn.FnUpdateTestStepResHTML("Verify the presence of OTP radio button", "OTP radio button is not present", "FAIL",runManagerInfoObj);
	  					blnFlag=false;
	  				}
	  			}
	  			else
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of OTP option", "OTP option is not present", "FAIL",runManagerInfoObj);
	  				blnFlag=false;
	  			}
	  		}
	  		else
	  		{
	  			repfn.FnUpdateTestStepResHTML("Verify the presence of payment frequency section in pay bill screen", "Payment frequency section is not present in pay bill screen", "FAIL",runManagerInfoObj);
	  			blnFlag=false;
	  		}
	  		driver.switchTo().defaultContent();

	  	}
	  	catch (Exception e)

	  	{
	  		repfn.FnUpdateTestStepResHTML("Verify User is in payment frequency section","User is not in payment frequency section due to some exception ","FAIL",runManagerInfoObj);


	  		System.err.println("Message : "+e.getMessage());
	  		System.err.println("Cause : "+e.getCause());
	  		blnFlag=false;
	  	}
	  	m1.put("STEPSTATUS", blnFlag);
	  	return blnFlag;
	  }
	  //Jhansi Dec 16,2015
	  //Verify the payment info screen for credit/debit-OTPin Q2 wall of garden
	  public synchronized boolean PaymentInfo_CreditDebit_OTP(WebDriver driver,RunManagerInfo runManagerInfoObj)
	  {
	  	try
	  	{
	  		driver.switchTo().frame("iFrameResizer0");
	  		if(cnf.FnExplicitWait("XPATH",mbo.PayBill_PaymentInfo,driver))
	  		{

	  			repfn.FnUpdateTestStepResHTML("Verify the presence of Payment info section for OTP-CreditDebit", "Payment info section for OTP-CreditDebit is present", "PASS",runManagerInfoObj);
	  			if(cnf.FnExplicitWait("XPATH",mbo.PaymentInfo_CreditDebit_Hdr,driver))
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of CreditDebit title in payment info section", "CreditDebit is present in Payment info section with the title"+" "+driver.findElement(By.xpath(mbo.PaymentInfo_CreditDebit_Hdr)).getAttribute("textContent").toString() , "PASS",runManagerInfoObj);
	  				blnFlag=true;  
	  			}
	  			else
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of CreditDebit title in payment info section", "CreditDebit is present in Payment info section without the title","FAIL",runManagerInfoObj);
	  				blnFlag=false;
	  			}
	  			if(cnf.FnExplicitWait("XPATH",mbo.Q2Wall_CardNumber_HeaderText,driver))
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of Credit card title in payment info section", "Credit card header is present in Payment info section with the title"+" "+driver.findElement(By.xpath(mbo.Q2Wall_CardNumber_HeaderText)).getAttribute("textContent").toString() , "PASS",runManagerInfoObj);
	  				blnFlag=true;  
	  			}
	  			else
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of Credit card title in payment info section", "Credit card header is not present in Payment info section" , "FAIL",runManagerInfoObj);
	  				blnFlag=false;
	  			}
	  			if(cnf.FnExplicitWait("XPATH",mbo.PayBill_CreditDebit_CardNum,driver))
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of Credit card text box in payment info section", "Credit card text box is present in Payment info section", "PASS",runManagerInfoObj);
	  				blnFlag=true;  
	  			}
	  			else
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of Credit card text box in payment info section", "Credit card text box is not present in Payment info section", "FAIL",runManagerInfoObj);
	  				blnFlag=false;
	  			}
	  			if(cnf.FnExplicitWait("XPATH",mbo.Q2Wall_ExpirationDate_HeaderText,driver))
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of Expiration date title in payment info section", "Expiration date header is present in Payment info section with the title"+" "+driver.findElement(By.xpath(mbo.Q2Wall_ExpirationDate_HeaderText)).getAttribute("textContent").toString() , "PASS",runManagerInfoObj);
	  				blnFlag=true;  
	  			}
	  			else
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of Expiration date title in payment info section", "Expiration date title is not present in Payment info section", "FAIL",runManagerInfoObj);
	  				blnFlag=false;
	  			}
	  			if(cnf.FnExplicitWait("XPATH",mbo.PayBill_CreditDebit_ExpMonth,driver))
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of Expiration month date picker in payment info section", "Expiration month date picker is present in Payment info section", "PASS",runManagerInfoObj);
	  				blnFlag=true;  
	  			}
	  			else
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of Expiration month date picker in payment info section", "Expiration month date picker is not present in Payment info section", "FAIL",runManagerInfoObj);
	  				blnFlag=false;
	  			}
	  			if(cnf.FnExplicitWait("XPATH",mbo.PayBill_CreditDebit_ExpYear,driver))
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of Expiration year date picker in payment info section", "Expiration year date picker is present in Payment info section", "PASS",runManagerInfoObj);
	  				blnFlag=true;  
	  			}
	  			else
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of Expiration year date picker in payment info section", "Expiration year date picker is not present in Payment info section", "FAIL",runManagerInfoObj);
	  				blnFlag=false;
	  			}
	  			if(cnf.FnExplicitWait("XPATH",mbo.PaymentInfo_AmtDate_Hdr,driver))
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of Amount & date title in payment info section", "Amount & date header is present in Payment info section with the title"+" "+driver.findElement(By.xpath(mbo.PaymentInfo_AmtDate_Hdr)).getAttribute("textContent").toString() , "PASS",runManagerInfoObj);
	  				blnFlag=true;  
	  			}
	  			else
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of Amount & date title in payment info section", "Amount & date title is not present in Payment info section", "FAIL",runManagerInfoObj);
	  				blnFlag=false;
	  			}
	  			if(cnf.FnExplicitWait("XPATH",mbo.PaymentInfo_AmtDue_Hdr,driver))
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of Amount due title in payment info section", "Amount due header is present in Payment info section with the title"+" "+driver.findElement(By.xpath(mbo.PaymentInfo_AmtDue_Hdr)).getAttribute("textContent").toString() , "PASS",runManagerInfoObj);
	  				blnFlag=true;  
	  			}
	  			else
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of Amount due title in payment info section", "Amount due title is not present in Payment info section", "FAIL",runManagerInfoObj);
	  				blnFlag=false;
	  			}
	  			
	  			if(cnf.FnExplicitWait("XPATH",mbo.PaymentInfo_Amtdue,driver))
	  			{
	  				boolean status = false;
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of Amount due in payment info section", "Amount due is present in Payment info section with the amount"+" "+driver.findElement(By.xpath(mbo.PaymentInfo_Amtdue)).getAttribute("textContent").toString() , "PASS",runManagerInfoObj);
	  				WebElement amt=driver.findElement(By.xpath(mbo.PaymentInfo_Amtdue)); 
	  /*				if(Pattern.matches("(\\$([0-9]{1}||[0-9]{2}||[0-9]{3})\\.[0-9]{2})",amt.getText().toString()))
	  				{
	  					repfn.FnUpdateTestStepResHTML("Verify the Amount due in payment info section is formatted as expected", "Amount due is formatted in Payment info section as expected", "PASS",runManagerInfoObj);
	  					blnFlag=true;
	  				}
	  				else
	  				{
	  					repfn.FnUpdateTestStepResHTML("Verify the Amount due in payment info section is formatted as expected", "Amount due is not formatted in Payment info section as expected", "FAIL",runManagerInfoObj);
	  					blnFlag=false;
	  				}*/
	  				status = cnf.verifyAmountFormat(amt.getText().toString());
	  				if(status){
	  					repfn.FnUpdateTestStepResHTML("Verify the Amount due in payment info section is formatted as expected", "Amount due is formatted in Payment info section as expected", "PASS",runManagerInfoObj);
	  					blnFlag=true;
	  				}
	  				else{
	  					repfn.FnUpdateTestStepResHTML("Verify the Amount due in payment info section is formatted as expected", "Amount due is not formatted in Payment info section as expected", "FAIL",runManagerInfoObj);
	  					blnFlag=false;
	  				}
	  			}
	  			else
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of Amount due in payment info section", "Amount due is not present in Payment info section", "FAIL",runManagerInfoObj);
	  				blnFlag=false;
	  			}
	  			
	  			if(cnf.FnExplicitWait("XPATH",mbo.PaymentInfo_DueBy,driver))
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of due by title in payment info section", "Due by header is present in Payment info section with the title"+" "+driver.findElement(By.xpath(mbo.PaymentInfo_DueBy)).getAttribute("textContent").toString() , "PASS",runManagerInfoObj);
	  				blnFlag=true;  
	  			}
	  			else
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of due by title in payment info section", "Due by title is not present in Payment info section", "FAIL",runManagerInfoObj);
	  				blnFlag=false;
	  			}
	  			if(cnf.FnExplicitWait("XPATH",mbo.PaymentInfo_DueByDate,driver))
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of due by date in payment info section", "Due by date is present in Payment info section with the date"+" "+driver.findElement(By.xpath(mbo.PaymentInfo_DueByDate)).getAttribute("textContent").toString() , "PASS",runManagerInfoObj);
	  				blnFlag=true;  
	  			}
	  			else
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of due by date in payment info section", "Due by date is not present in Payment info section", "FAIL",runManagerInfoObj);
	  				blnFlag=false;
	  			}
	  			if(cnf.FnExplicitWait("XPATH",mbo.Q2Wall_PaymentAmount_HeaderText,driver))
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of Payment Amount title in payment info section", "Payment Amount header is present in Payment info section with the title"+" "+driver.findElement(By.xpath(mbo.Q2Wall_PaymentAmount_HeaderText)).getAttribute("textContent").toString() , "PASS",runManagerInfoObj);
	  				blnFlag=true;  
	  			}
	  			else
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of Payment amount title in payment info section", "Payment Amount title is not present in Payment info section", "FAIL",runManagerInfoObj);
	  				blnFlag=false;
	  			}
	  			if(cnf.FnExplicitWait("XPATH",mbo.PayBill_CreditDebit_Amount,driver))
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of payment amount text box in payment info section", "Payment amount text box is present in Payment info section", "PASS",runManagerInfoObj);
	  				blnFlag=true;  
	  			}
	  			else
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of Payment amount text box in payment info section", "Payment amount text box is not present in Payment info section", "FAIL",runManagerInfoObj);
	  				blnFlag=false;
	  			}
	  			if(cnf.FnExplicitWait("XPATH",mbo.Q2Wall_PaymentDate_HeaderText,driver))
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of Payment date title in payment info section", "Payment date header is present in Payment info section with the title"+" "+driver.findElement(By.xpath(mbo.Q2Wall_PaymentDate_HeaderText)).getAttribute("textContent").toString() , "PASS",runManagerInfoObj);
	  				blnFlag=true;  
	  			}
	  			else
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of Payment date title in payment info section", "Payment date title is not present in Payment info section", "FAIL",runManagerInfoObj);
	  				blnFlag=false;
	  			}
	  			if(cnf.FnExplicitWait("XPATH",mbo.PayBill_CreditDebit_PayDate,driver))
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of payment date text box in payment info section", "Payment date text box is present in Payment info section", "PASS",runManagerInfoObj);
	  				blnFlag=true;  
	  			}
	  			else
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of Payment date text box in payment info section", "Payment date text box is not present in Payment info section", "FAIL",runManagerInfoObj);
	  				blnFlag=false;
	  			}
	  			String Browser=m1.get("BROWSER").toString();
	  			if(Browser.contains("firefox"))
	  			{
	  				if(cnf.FnExplicitWait("XPATH",mbo.PayBill_DatePicker,driver))
	  				{
	  					repfn.FnUpdateTestStepResHTML("Verify the presence of payment date picker in payment info section", "Payment date picker is present in Payment info section", "PASS",runManagerInfoObj);
	  					blnFlag=true;  
	  				}
	  				else
	  				{
	  					repfn.FnUpdateTestStepResHTML("Verify the presence of Payment date picker in payment info section", "Payment date picker is not present in Payment info section", "FAIL",runManagerInfoObj);
	  					blnFlag=false;
	  				}
	  			}
	  			else 
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of Payment date picker in chrome browser", "Payment date picker is not present in chrome browser", "PASS",runManagerInfoObj);
	  				blnFlag=true;
	  			}

	  /*			if(cnf.FnExplicitWait("XPATH",mbo.VerifyPaymentInfo_SupportLink))
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of support link in payment info section", "Support link is present in Payment info section", "PASS",runManagerInfoObj);
	  				blnFlag=true;  
	  			}
	  			else
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of support link in payment info section", "Support link is not present in Payment info section", "FAIL",runManagerInfoObj);
	  				blnFlag=false;
	  			}*/

	  			if(cnf.FnExplicitWait("XPATH",mbo.CreditDebit_VerifyPay_Cancel,driver))
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of Cancel button in payment info section", "Cancel button is present in Payment info section", "PASS",runManagerInfoObj);
	  				blnFlag=true;  
	  			}
	  			else
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of Cancel button in payment info section", "Cancel button is not present in Payment info section", "FAIL",runManagerInfoObj);
	  				blnFlag=false;
	  			}

	  			if(cnf.FnExplicitWait("XPATH",mbo.PaymentInfo_PayNowBtn,driver))
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of Pay now button in payment info section", "Pay Now button is present in Payment info section", "PASS",runManagerInfoObj);
	  				blnFlag=true;  
	  			}
	  			else
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the presence of Pay Now button in payment info section", "Pay Now button is not present in Payment info section", "FAIL",runManagerInfoObj);
	  				blnFlag=false;
	  			}
	  		}
	  		else
	  		{
	  			repfn.FnUpdateTestStepResHTML("Verify the presence of Payment info section for OTP-CreditDebit", "Payment info section for OTP-CreditDebit is not present", "FAIL",runManagerInfoObj);
	  			blnFlag=false;
	  		}
	  		driver.switchTo().defaultContent();
	  	}
	  	catch (Exception e)

	  	  {
	  	         repfn.FnUpdateTestStepResHTML("Verify User is in Payment info section","User is not in payment info section due to some exception ","FAIL",runManagerInfoObj);


	  	         System.err.println("Message : "+e.getMessage());
	  	         System.err.println("Cause : "+e.getCause());
	  	         blnFlag=false;
	  	  }
	  	  m1.put("STEPSTATUS", blnFlag);
	  	  return blnFlag;
	  	}
	  //Jhansi Dec 16,2015
	  //Type of Card used-OTP-Credit/Debit
	  public synchronized boolean TypeOfCardUsed(WebDriver driver,RunManagerInfo runManagerInfoObj)
	  {

	  	boolean flagOne = false;
	  	boolean flagTwo = false;
	  	boolean flagThree = false;
	  	try
	  	{
	  		driver.switchTo().frame("iFrameResizer0");
	  		if(cnf.FnExplicitWait("XPATH",mbo.PayBill_PaymentInfo,driver))
	  		{
	  			// cnf.ScrollToView(driver.findElement(By.xpath(mbo.PayBill_PaymentInfo)));
	  			repfn.FnUpdateTestStepResHTML("Verify the presence of Payment info section for OTP-CreditDebit", "Payment info section for OTP-CreditDebit is present", "PASS",runManagerInfoObj);
	  			flagOne = VisaCardType(driver,runManagerInfoObj);
	  			flagTwo = MasterCardType(driver,runManagerInfoObj);
	  			flagThree = DiscoverType(driver,runManagerInfoObj);
	  			
	  			if(flagOne && flagTwo && flagThree){
	  				blnFlag=true;
	  			}
	  			else{
	  				repfn.FnUpdateTestStepResHTML("Verify User is able to verify type of card number displayed", "User is not able to verify type of card number displayed", "FAIL",runManagerInfoObj);
	  				blnFlag=false;
	  			}
	  			/*if(cnf.isAlertPresent())
	  			{
	  				AlertAccept();    
	  			}
	  			else
	  			{
	  				System.out.println("No alert is present");
	  			}*/
	  			
	  		}		

	  		else
	  		{
	  			repfn.FnUpdateTestStepResHTML("Verify the presence of Payment info section for OTP-CreditDebit", "Payment info section for OTP-CreditDebit is not present", "FAIL",runManagerInfoObj);
	  			blnFlag=false;
	  		}
	  		driver.switchTo().defaultContent();
	  	}
	  	catch (Exception e)

	  	{
	  		repfn.FnUpdateTestStepResHTML("Verify User is in Payment info section","User is not in payment info section due to some exception ","FAIL",runManagerInfoObj);


	  		System.err.println("Message : "+e.getMessage());
	  		System.err.println("Cause : "+e.getCause());
	  		blnFlag=false;
	  	}
	  	m1.put("STEPSTATUS", blnFlag);
	  	return blnFlag;
	  }
	  //Jhansi Dec 16,2015
	  //Visa card type
	  public synchronized boolean VisaCardType(WebDriver driver,RunManagerInfo runManagerInfoObj)
	  {
	  	String Visa= m1.get("Visa").toString();
	  	try
	  	{
	  		if(cnf.FnExplicitWait("XPATH",mbo.PayBill_CreditDebit_CardNum,driver))
	  		{
	  			repfn.FnUpdateTestStepResHTML("Verify the presence of Credit card text box in payment info section", "Credit card text box is present in Payment info section", "PASS",runManagerInfoObj);
	  			WebElement CardNum=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_CardNum));
	  			CardNum.sendKeys(Visa);
	  			if(CardNum!=null)
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the Credit card text box is filled with Visa card number", "Credit card text box is filled with Visa card number"+" "+CardNum.getText(), "PASS",runManagerInfoObj);
	  				if(cnf.FnExplicitWait("XPATH", mbo.CardTypeICon,driver))
	  				{
	  					repfn.FnUpdateTestStepResHTML("Verify the Credit card icon is present for the card number filled", "Credit card icon is present for the card number filled", "PASS",runManagerInfoObj);
	  					WebElement cardType=driver.findElement(By.xpath(mbo.CardTypeICon));
	  					if(cardType.getAttribute("title").toString().equalsIgnoreCase("Visa"))
	  					{
	  						repfn.FnUpdateTestStepResHTML("Verify the Credit card icon displayed is Visa", "Credit card icon displayed is Visa ", "PASS",runManagerInfoObj);
	  						blnFlag=true;
	  					}
	  					else
	  					{
	  						repfn.FnUpdateTestStepResHTML("Verify the Credit card icon displayed is Visa", "Credit card icon displayed is Visa ", "PASS",runManagerInfoObj);
	  						blnFlag=false;
	  					}
	  				}
	  				else
	  				{
	  					repfn.FnUpdateTestStepResHTML("Verify the Credit card icon is present for the card number filled", "Credit card icon is not present for the card number filled", "FAIL",runManagerInfoObj);
	  					blnFlag=false;
	  				}

	  			}
	  			else
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the Credit card text box is filled with Visa card number", "Credit card text box is not filled with Visa card number", "FAIL",runManagerInfoObj);
	  				blnFlag=false;
	  			}
	  		}
	  		else
	  		{
	  			repfn.FnUpdateTestStepResHTML("Verify the presence of Credit card text box in payment info section", "Credit card text box is not present in Payment info section", "FAIL",runManagerInfoObj);
	  			blnFlag=false;
	  		}
	  	}
	  	catch (Exception e)

	  	{
	  		repfn.FnUpdateTestStepResHTML("Verify User is in Payment info section","User is not in payment info section due to some exception ","FAIL",runManagerInfoObj);


	  		System.err.println("Message : "+e.getMessage());
	  		System.err.println("Cause : "+e.getCause());
	  		blnFlag=false;
	  	}
	  	m1.put("STEPSTATUS", blnFlag);
	  	return blnFlag;
	  }
	  //Jhansi Dec 16,2015
	  //Master card type
	  public synchronized boolean MasterCardType(WebDriver driver,RunManagerInfo runManagerInfoObj)
	  {
	  	String MasterCard=m1.get("MasterCard").toString();
	  	try
	  	{
	  	  if(cnf.FnExplicitWait("XPATH",mbo.PayBill_CreditDebit_CardNum,driver))
	  	     {
	  		  	 repfn.FnUpdateTestStepResHTML("Verify the presence of Credit card text box in payment info section", "Credit card text box is present in Payment info section", "PASS",runManagerInfoObj);
	  			 WebElement CardNum=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_CardNum));
	  			 CardNum.clear();
	  		     CardNum.sendKeys(MasterCard);
	  		    if(CardNum!=null)
	  		      {
	  		  	    repfn.FnUpdateTestStepResHTML("Verify the Credit card text box is filled with MasterCard card number", "Credit card text box is filled with MasterCard card number"+" "+CardNum.getText(), "PASS",runManagerInfoObj);
	  		  	    if(cnf.FnExplicitWait("XPATH", mbo.CardTypeICon,driver))
	  		  	    {
	  			  	    repfn.FnUpdateTestStepResHTML("Verify the Credit card icon is present for the card number filled", "Credit card icon is present for the card number filled", "PASS",runManagerInfoObj);
	  		  	        WebElement cardType=driver.findElement(By.xpath(mbo.CardTypeICon));
	  			  	    if(cardType.getAttribute("title").toString().equalsIgnoreCase("mastercard"))
	  			  	    {
	  				  	    repfn.FnUpdateTestStepResHTML("Verify the Credit card icon displayed is Mastercard", "Credit card icon displayed is Mastercard", "PASS",runManagerInfoObj);
	                   blnFlag=true;
	  			  	    }
	  			  	    else
	  			  	    {
	  				  	    repfn.FnUpdateTestStepResHTML("Verify the Credit card icon displayed is Mastercard", "Credit card icon displayed is Mastercard", "PASS",runManagerInfoObj);
	                   blnFlag=false;
	  			  	    }
	  		  	    }
	  		  	    else
	  		  	    {
	  			  	    repfn.FnUpdateTestStepResHTML("Verify the Credit card icon is present for the card number filled", "Credit card icon is not present for the card number filled", "FAIL",runManagerInfoObj);
	               blnFlag=false;
	  		  	    }

	  		    }
	  		    else
	  		    {
	  	  	    repfn.FnUpdateTestStepResHTML("Verify the Credit card text box is filled with Mastercard card number", "Credit card text box is not filled with Mastercard card number", "FAIL",runManagerInfoObj);
	  	  	    blnFlag=false;
	  		    }
	  	        }
	  	      else
	  	      {
	  		  	    repfn.FnUpdateTestStepResHTML("Verify the presence of Credit card text box in payment info section", "Credit card text box is not present in Payment info section", "FAIL",runManagerInfoObj);
	           blnFlag=false;
	  	      }
	  	}
	  	catch (Exception e)

	  	  {
	  	         repfn.FnUpdateTestStepResHTML("Verify User is in Payment info section","User is not in payment info section due to some exception ","FAIL",runManagerInfoObj);


	  	         System.err.println("Message : "+e.getMessage());
	  	         System.err.println("Cause : "+e.getCause());
	  	         blnFlag=false;
	  	  }
	  	  m1.put("STEPSTATUS", blnFlag);
	  	  return blnFlag;
	  }

	  //Jhansi Dec 16,2015
	  //Master card type
	  public synchronized boolean DiscoverType(WebDriver driver,RunManagerInfo runManagerInfoObj)
	  {
	  	String Discover=m1.get("Discover").toString();
	  	try
	  	{
	  		if(cnf.FnExplicitWait("XPATH",mbo.PayBill_CreditDebit_CardNum,driver))
	  		{
	  			repfn.FnUpdateTestStepResHTML("Verify the presence of Credit card text box in payment info section", "Credit card text box is present in Payment info section", "PASS",runManagerInfoObj);
	  			WebElement CardNum=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_CardNum));
	  			CardNum.clear();
	  			CardNum.sendKeys(Discover);
	  			if(CardNum!=null)
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the Credit card text box is filled with Discover card number", "Credit card text box is filled with Discover card number"+" "+CardNum.getText(), "PASS",runManagerInfoObj);
	  				if(cnf.FnExplicitWait("XPATH", mbo.CardTypeICon,driver))
	  				{
	  					repfn.FnUpdateTestStepResHTML("Verify the Credit card icon is present for the card number filled", "Credit card icon is present for the card number filled", "PASS",runManagerInfoObj);
	  					WebElement cardType=driver.findElement(By.xpath(mbo.CardTypeICon));
	  					if(cardType.getAttribute("title").toString().equalsIgnoreCase("discover"))
	  					{
	  						repfn.FnUpdateTestStepResHTML("Verify the Credit card icon displayed is Discover", "Credit card icon displayed is Discover", "PASS",runManagerInfoObj);
	  						blnFlag=true;
	  					}
	  					else
	  					{
	  						repfn.FnUpdateTestStepResHTML("Verify the Credit card icon displayed is Discover", "Credit card icon displayed is Discover", "PASS",runManagerInfoObj);
	  						blnFlag=false;
	  					}
	  				}
	  				else
	  				{
	  					repfn.FnUpdateTestStepResHTML("Verify the Credit card icon is present for the card number filled", "Credit card icon is not present for the card number filled", "FAIL",runManagerInfoObj);
	  					blnFlag=false;
	  				}

	  			}
	  			else
	  			{
	  				repfn.FnUpdateTestStepResHTML("Verify the Credit card text box is filled with Discover card number", "Credit card text box is not filled with Discover card number", "FAIL",runManagerInfoObj);
	  				blnFlag=false;
	  			}
	  		}
	  		else
	  		{
	  			repfn.FnUpdateTestStepResHTML("Verify the presence of Credit card text box in payment info section", "Credit card text box is not present in Payment info section", "FAIL",runManagerInfoObj);
	  			blnFlag=false;
	  		}
	  	}
	  	catch (Exception e)

	  	{
	  		repfn.FnUpdateTestStepResHTML("Verify User is in Payment info section","User is not in payment info section due to some exception ","FAIL",runManagerInfoObj);


	  		System.err.println("Message : "+e.getMessage());
	  		System.err.println("Cause : "+e.getCause());
	  		blnFlag=false;
	  	}
	  	m1.put("STEPSTATUS", blnFlag);
	  	return blnFlag;
	  }
	  public synchronized boolean FnQ2WallOfGarden_PaymentAmountFieldValidation(WebDriver driver,RunManagerInfo runManagerInfoObj){

		    
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
		               
		               if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_PaymentAmount,driver)){
		                     repfn.FnUpdateTestStepResHTML("Verify Payment Amount field is displayed under Payment Information option",
		                                   "Payment Amount Number field is displayed under Payment Information option","PASS",runManagerInfoObj);
		                     WebElement Q2Wall_PaymentAmount=driver.findElement(By.xpath(mbo.Q2Wall_PaymentAmount));
		                     Q2Wall_PaymentAmount.sendKeys(invalidPaymentAmountOne);
		                     repfn.FnUpdateTestStepResHTML("Verify Payment Amount is entered","Payment Amount: " +invalidPaymentAmountOne + "is entered","PASS",runManagerInfoObj);
		                     
		                     if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_PaymentInformationHeader,driver)){
		                            WebElement Q2Wall_PaymentInformationHeader=driver.findElement(By.xpath(mbo.Q2Wall_PaymentInformationHeader));
		                            cnf.JSClick(Q2Wall_PaymentInformationHeader,driver);
		                     }
		                     else{
		                            repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
		                            blnFlag=false;
		                     }
		                            
		                     
		                     
		                     if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_paymentAmountError,driver)){
		                            WebElement Q2Wall_paymentAmountError=driver.findElement(By.xpath(mbo.Q2Wall_paymentAmountError));
		                            errorMessage = Q2Wall_paymentAmountError.getAttribute("textContent");
		                            repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed","Payment Amount Error Message is displayed:  " +errorMessage,"PASS",runManagerInfoObj);
		                            blnFlag=true;
		                            
		                            if(errorStatusMsg.equalsIgnoreCase(errorMessage)){
		                            repfn.FnUpdateTestStepResHTML("Please enter an amount between $1 and $25000 error message is displayed",
		                                          "Please enter an amount between $0 and $25000. is displayed","PASS",runManagerInfoObj);
		                            errorStatusOne = true;
		                            blnFlag=true;
		                     }
		                     else{
		                            repfn.FnUpdateTestStepResHTML("Please enter an amount between $1 and $25000 error message is displayed",
		                                          "Please enter an amount between $0 and $25000 is not displayed","FAIL",runManagerInfoObj);
		                            blnFlag=false;
		                     }

		                            
		                     }
		                     else{
		                            repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed",
		                                          "Payment Amount Error Message is not displayed when this number is entered: " +invalidPaymentAmountOne,"FAIL",runManagerInfoObj);
		                            blnFlag=false;
		                     }
		                     
		                     Thread.sleep(2000);
		                     
		                     Q2Wall_PaymentAmount.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),invalidPaymentAmountTwo);
		                     repfn.FnUpdateTestStepResHTML("Verify Payment Amount is entered","Payment Amount:  " +invalidPaymentAmountTwo + "is entered","PASS",runManagerInfoObj);
		                     
		                     if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_PaymentInformationHeader,driver)){
		                            WebElement Q2Wall_PaymentInformationHeader=driver.findElement(By.xpath(mbo.Q2Wall_PaymentInformationHeader));
		                            cnf.JSClick(Q2Wall_PaymentInformationHeader,driver);
		                     }
		                     else{
		                            repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
		                            blnFlag=false;
		                     }
		                     
		                     if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_paymentAmountError,driver)){
		                            WebElement Q2Wall_paymentAmountError=driver.findElement(By.xpath(mbo.Q2Wall_paymentAmountError));
		                            errorMessage = Q2Wall_paymentAmountError.getAttribute("textContent");
		                            repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed","Payment Amount Error Message is displayed:  " +errorMessage,"PASS",runManagerInfoObj);
		                            blnFlag=true;
		                            if(errorStatusMsg.equalsIgnoreCase(errorMessage)){
		                            repfn.FnUpdateTestStepResHTML("Please enter an amount between $1 and $25000 error message is displayed",
		                                          "Please enter an amount between $1 and $25,000. is displayed","PASS",runManagerInfoObj);
		                            errorStatusTwo = true;
		                            blnFlag=true;
		                     }
		                     else{
		                            repfn.FnUpdateTestStepResHTML("Please enter an amount between $1 and $25000 error message is displayed",
		                                          "Please enter an amount between $1 and $25000 is not displayed","FAIL",runManagerInfoObj);
		                            blnFlag=false;
		                     }
		                            
		                                                              
		                     }
		                     else{
		                            repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed",
		                                          "Payment Amount Error Message is not displayed when this number is entered: " +invalidPaymentAmountTwo,"FAIL",runManagerInfoObj);
		                            blnFlag=false;
		                     }
		                     
		                     Thread.sleep(2000);
		                     
		                     Q2Wall_PaymentAmount.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),invalidPaymentAmountThree);
		                     repfn.FnUpdateTestStepResHTML("Verify Payment Amount is entered","Payment Amount: " +invalidPaymentAmountThree + "is entered","PASS",runManagerInfoObj);
		                     
		                     if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_PaymentInformationHeader,driver)){
		                            WebElement Q2Wall_PaymentInformationHeader=driver.findElement(By.xpath(mbo.Q2Wall_PaymentInformationHeader));
		                            cnf.JSClick(Q2Wall_PaymentInformationHeader,driver);
		                     }
		                     else{
		                            repfn.FnUpdateTestStepResHTML("Verify Payment Information Header is displayed and clicked","Payment Information Header is not displayed and clicked","FAIL",runManagerInfoObj);
		                            blnFlag=false;
		                     }
		                     
		                     if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_paymentAmountError,driver)){
		                            WebElement Q2Wall_paymentAmountError=driver.findElement(By.xpath(mbo.Q2Wall_paymentAmountError));
		                            errorMessage = Q2Wall_paymentAmountError.getAttribute("textContent");
		                            repfn.FnUpdateTestStepResHTML("Verify Payment Amount Error Message is displayed","Payment Amount Error Message is displayed:  " +errorMessage,"PASS",runManagerInfoObj);
		                            blnFlag=true;
		                            if(errorStatusMsg.equalsIgnoreCase(errorMessage)){
		                            repfn.FnUpdateTestStepResHTML("Please enter an amount between $1 and $25000 error message is displayed",
		                                          "Please enter an amount between $1 and $25000 is displayed","PASS",runManagerInfoObj);
		                            errorStatusThree = true;
		                            blnFlag=true;
		                     }
		                     else{
		                            repfn.FnUpdateTestStepResHTML("Please enter an amount between $1 and $25000 error message is displayed",
		                                          "Please enter an amount between $1 and $25000 is not displayed","FAIL",runManagerInfoObj);
		                            blnFlag=false;
		                     }
		                             
		                            
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
	  public synchronized boolean FnViewDetailsLinkClick(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{


			try{

				driver.switchTo().frame("iFrameResizer0");

				if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_ViewDetails_Link,driver)){
					repfn.FnUpdateTestStepResHTML("Verify View Details Link is displayed on Pay Bill page","View Details Link is displayed on Pay Bill page","PASS",runManagerInfoObj);
					WebElement Q2Wall_ViewDetails_Link=driver.findElement(By.xpath(mbo.Q2Wall_ViewDetails_Link));
					if(cnf.JSClick(Q2Wall_ViewDetails_Link,driver)){
						repfn.FnUpdateTestStepResHTML("Verify View Details Link is clicked","View Details Link is clicked","PASS",runManagerInfoObj);
						Thread.sleep(5000);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify View Details Link is clicked","View Details Link is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify View Details Link is displayed on Pay Bill page","View Details Link is not displayed on Pay Bill page","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				driver.switchTo().defaultContent();

			}

			catch (Exception e)

			{
				repfn.FnUpdateTestStepResHTML("Verify View Details Link is displayed on Pay Bill page","View Details Link is not displayed on Pay Bill page due to some exception","FAIL",runManagerInfoObj);
				blnFlag=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());

			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}
	  public synchronized boolean VerifyStatementDetailsWindow(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{


			try{

				driver.switchTo().frame("iFrameResizer0");

				if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_ViewDetails_DialogBox,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Statement Details Dialog box is displayed on Pay Bill page","Statement Details Dialog box is displayed on Pay Bill page","PASS",runManagerInfoObj);

					if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_ViewDetails_DialogBox_CloseButton,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Close button is displayed in Statement Details Dialog box","Close button is displayed in Statement Details Dialog box","PASS",runManagerInfoObj);
						WebElement Q2Wall_ViewDetails_DialogBox_CloseButton=driver.findElement(By.xpath(mbo.Q2Wall_ViewDetails_DialogBox_CloseButton));
						if(cnf.JSClick(Q2Wall_ViewDetails_DialogBox_CloseButton,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Close button is clicked","Close button is clicked","PASS",runManagerInfoObj);
							Thread.sleep(5000);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Close button is clicked","Close button is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Close button is displayed in Statement Details Dialog box","Close button is not displayed in Statement Details Dialog box","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Statement Details Dialog box is displayed on Pay Bill page","Statement Details Dialog box is not displayed on Pay Bill page","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				driver.switchTo().defaultContent();

			}

			catch (Exception e)

			{
				repfn.FnUpdateTestStepResHTML("Verify Statement Details Dialog box is displayed on Pay Bill page","Statement Details Dialog box is not displayed on Pay Bill page due to some exception","FAIL",runManagerInfoObj);
				blnFlag=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());

			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}

		public synchronized boolean FnValidateNoResultsDisplay_EnterKey(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{


			try{

				if(cnf.FnExplicitWait("XPATH", mbo.FindLocationUI_Searchtxtbox,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of search text box in Location Finder page", "Search text box is present in Location finder page", "PASS",runManagerInfoObj);
					WebElement SearchTextbox=driver.findElement(By.xpath(mbo.FindLocationUI_Searchtxtbox));

					SearchTextbox.sendKeys(m1.get("Pincode").toString());

					repfn.FnUpdateTestStepResHTML("Enter the required keyword in the search text entry field.", "User should be able to key in the value.", "PASS",runManagerInfoObj);
					SearchTextbox.sendKeys(Keys.ENTER);
					Thread.sleep(3000);
					repfn.FnUpdateTestStepResHTML("Verify User Click on the ENTER key ","'Enter' Key is clicked", "PASS",runManagerInfoObj);
					
					if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_LocationFinder_NoResultsMessage,driver)){
						WebElement Q2Wall_LocationFinder_NoResultsMessage=driver.findElement(By.xpath(mbo.Q2Wall_LocationFinder_NoResultsMessage));
						repfn.FnUpdateTestStepResHTML("Verify No Results Message is displayed", "No Results Message is displayed as: "+Q2Wall_LocationFinder_NoResultsMessage.getText(), "PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify No Results Message is displayed", "No Results Message is not displayed", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of search text box in Location Finder page", "Search text box is not present in Location finder page", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}

			catch (Exception e)

			{
				repfn.FnUpdateTestStepResHTML("Verify the presence of search text box in Location Finder page", "Search text box is not present in Location finder page due to some exception", "FAIL",runManagerInfoObj);
				blnFlag=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());

			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}

		public synchronized boolean FnValidateNoResultsDisplay_GoButton(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{


			try{

				if(cnf.FnExplicitWait("XPATH", mbo.FindLocationUI_Searchtxtbox,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of search text box in Location Finder page", "Search text box is present in Location finder page", "PASS",runManagerInfoObj);
					WebElement SearchTextbox=driver.findElement(By.xpath(mbo.FindLocationUI_Searchtxtbox));
					SearchTextbox.clear();
					SearchTextbox.sendKeys(m1.get("Pincode").toString());
					repfn.FnUpdateTestStepResHTML("Enter the required keyword in the search text entry field.", "User should be able to key in the value.", "PASS",runManagerInfoObj);

					if(cnf.FnExplicitWait("XPATH", mbo.FindLocationUI_GoBtn,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Go button in Location Finder page", "Go button is present in Location finder page", "PASS",runManagerInfoObj);
						WebElement gotobutton=driver.findElement(By.xpath(mbo.FindLocationUI_GoBtn));
						if(cnf.JSClick(gotobutton,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Go button in Location Finder page is clicked", "Go button in Location Finder page is clicked", "PASS",runManagerInfoObj);

							Thread.sleep(3000);
							if(cnf.FnExplicitWait("XPATH", mbo.Q2Wall_LocationFinder_NoResultsMessage,driver)){
								WebElement Q2Wall_LocationFinder_NoResultsMessage=driver.findElement(By.xpath(mbo.Q2Wall_LocationFinder_NoResultsMessage));
								repfn.FnUpdateTestStepResHTML("Verify No Results Message is displayed", "No Results Message is displayed as: "+Q2Wall_LocationFinder_NoResultsMessage.getText(), "PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify No Results Message is displayed", "No Results Message is not displayed", "FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Go button in Location Finder page is clicked", "Go button in Location Finder page is not clicked", "FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Go button in Location Finder page", "Go button is not present in Location finder page", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of search text box in Location Finder page", "Search text box is not present in Location finder page", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}

			catch (Exception e)

			{
				repfn.FnUpdateTestStepResHTML("Verify the presence of search text box in Location Finder page", "Search text box is not present in Location finder page due to some exception", "FAIL",runManagerInfoObj);
				blnFlag=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());

			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}
		public synchronized boolean FnVerify_saveAutoPayButtonDisabled(WebDriver driver,RunManagerInfo runManagerInfoObj){
		  	
		  	try{
		  		
		  		driver.switchTo().frame("iFrameResizer0");
		  		Thread.sleep(2000);
		  		if(cnf.FnExplicitWait("XPATH", "//button[@disabled='disabled'][contains(.,'Save Auto-Pay')]",driver)){
		  			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//button[@disabled='disabled'][contains(.,'Save Auto-Pay')]")));   
		  			repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is displayed","Save Auto-Pay button is displayed","PASS",runManagerInfoObj);
		  			WebElement disabledAutoPay=driver.findElement(By.xpath("//button[@disabled='disabled'][contains(.,'Save Auto-Pay')]"));
		  			//cnf.ScrollToView(PayNowButton);
		  			if(disabledAutoPay.isEnabled()){
		  				repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is not enabled","Save Auto-Pay button is  enabled.","FAIL",runManagerInfoObj);
		  				
		  				blnFlag=false;
		  			}
		  			else{
		  				repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is not enabled","Save Auto-Pay button is not enabled","PASS",runManagerInfoObj);
		  				blnFlag=true;
		  			}
		  		}
		  		else{
		  			repfn.FnUpdateTestStepResHTML("Verify Save Auto-Pay button is displayed","Save Auto-Pay button is not displayed","FAIL",runManagerInfoObj);
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
public synchronized boolean Q2Wall_ResetPassword_CancelbuttonClick_ConfirmAlertDismiss(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception
{
	try
	{

		if(cnf.FnExplicitWait("Xpath",mbo.Q2wall_Cancelbtn,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Cancel button is displayed","Cancel button is displayed","PASS",runManagerInfoObj);
			WebElement Q2wall_Cancelbutton=driver.findElement(By.xpath(mbo.Q2wall_Cancelbtn));
			if(cnf.JSClick(Q2wall_Cancelbutton,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Cancel button is clicked","Cancel button is clicked","PASS",runManagerInfoObj);
				Thread.sleep(3000);

				if(cnf.isAlertPresent()){
					driver.switchTo().alert();
					String ErrMsg=driver.switchTo().alert().getText();
					System.out.println(ErrMsg);
					driver.switchTo().alert().dismiss();
					driver.switchTo().defaultContent();
					Thread.sleep(5000);
				}
				else{
					//repfn.FnUpdateTestStepResHTML("verify .... ",".......","PASS/WARNING");// update the reporting function based on your requirement
					System.out.println("No alert present");                                              
				}

				String SecurityAnswer=m1.get("SecurityAnswer").toString();
				if(cnf.FnExplicitWait("ID", mbo.securityAnswerRP,driver))
				{
					WebElement securityAnswerRP=driver.findElement(By.id(mbo.securityAnswerRP));
					if(securityAnswerRP.getAttribute("value").equals(SecurityAnswer)){
						repfn.FnUpdateTestStepResHTML("Verify Security Answer Value after Cancelling Alert popup", "No changes are made to Security Answer Value after Cancelling Alert popup", "PASS",runManagerInfoObj);
						blnFlag=true; 
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Security Answer Value after Cancelling Alert popup", "Changes are made to Security Answer Value after Cancelling Alert popup", "FAIL",runManagerInfoObj);
						blnFlag=false; 
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify Security Answer field is displayed", "Security Answer field is not displayed", "FAIL",runManagerInfoObj);
					blnFlag=false;	
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Cancel button is clicked","Cancel button is not clicked","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Cancel button is displayed","Cancel button is not displayed","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}
	catch(Exception e)
	{
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		blnFlag=false;
		repfn.FnUpdateTestStepResHTML("Verify User is displayed with the same screen without any changes to entered values after clicking cancel in alert popup","User is not displayed with the same screen without any changes to entered values after clicking cancel in alert popup due to some exception","FAIL",runManagerInfoObj);
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;

}


public synchronized boolean ResetPwd_step1_Cancel(WebDriver driver,RunManagerInfo runManagerInfoObj)
{
	 try
	 {
		 EditAccNumber(driver,runManagerInfoObj);
		 EditCode(driver,runManagerInfoObj);	
		 ResetPwd_CancelTwice(driver,runManagerInfoObj);
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
//To check if Recover Password is enabled//

public synchronized boolean ResetPassword_Radiobtn(WebDriver driver,RunManagerInfo runManagerInfoObj)
{
	 try
	 {
		 cnf.FnExplicitWait("XPATH", mbo.ResetPassword,driver);
		 WebElement User=driver.findElement(By.xpath(mbo.ResetPassword));
		 if(User.isDisplayed()&& User.isSelected())
		 {
			 repfn.FnUpdateTestStepResHTML("Verify if Reset Password option is present and selected", "Reset Password option is present and selected", "PASS",runManagerInfoObj);
			 blnFlag=true;
		 }
		 else if(User.isDisplayed() && !User.isSelected())
		 {
			 repfn.FnUpdateTestStepResHTML("Verify if Reset Password option is present and selected", "Reset Password option is present but not selected", "PASS",runManagerInfoObj);
			 Thread.sleep(3000);
			 cnf.JSClick(User,driver);
			 repfn.FnUpdateTestStepResHTML("Select the Reset Password radio button", "Reset Password radio button is selected", "PASS",runManagerInfoObj);
			 blnFlag=true;
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
public synchronized boolean FnClickPayBillButtonAndVerify_CheckingSavings_WG_EditLink(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{

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

		if(cnf.FnExplicitWait("XPATH", mbo.Q2wall_RoutingNumber,driver)){
			WebElement RoutingNumber=driver.findElement(By.xpath(mbo.Q2wall_RoutingNumber));
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

		if(cnf.FnExplicitWait("XPATH", mbo.Q2wall_BankAccountNumber,driver)){
			WebElement BankAccountNumber=driver.findElement(By.xpath(mbo.Q2wall_BankAccountNumber));
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

		if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_Amount,driver)){
			WebElement PaymentAmount=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_Amount));
			paymentAmount = PaymentAmount.getAttribute("value");
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Payment Amount field is displayed under Payment Information option",
					"Payment Amount Number field is not displayed under Payment Information option","FAIL",runManagerInfoObj);
			blnFlag=false;
		}

		if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_PayDate,driver)){
			WebElement PaymentDate=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_PayDate));
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

			}else {
				String[] one = paymentDateOne.split("/");
				month = one[0];
				day = one[1];
				String yearOne = one[2];
				year = yearOne.substring((2));
				paymentDate = month+"/"+day+"/"+year;
			}

			System.out.println("Final payment date: "+paymentDate);
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
					if(cnf.FnExplicitWait("XPATH", mbo.VerifyPay_Heading,driver))
					{
						repfn.FnUpdateTestStepResHTML("Check if Verify Payment Information heading is displayed", "Verify Payment Information heading is displayed", "PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Check if Verify Payment Information heading is displayed", "Verify Payment Information heading is not displayed", "FAIL",runManagerInfoObj);
						blnFlag=false; 
					}

					if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentInfo_Hdr,driver))
					{
						repfn.FnUpdateTestStepResHTML("Check if Payment Summary sub-heading  is displayed", "Payment Summary sub- heading is displayed", "PASS",runManagerInfoObj);

						if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_VerifyCard,driver)){
							WebElement PayBill_CreditDebit_VerifyCard=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_VerifyCard));
							if(PayBill_CreditDebit_VerifyCard.getAttribute("textContent").contains(routingNumber)){
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

						if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_VerifyExp,driver)){
							WebElement PayBill_CreditDebit_VerifyExp=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_VerifyExp));
							if(PayBill_CreditDebit_VerifyExp.getAttribute("textContent").contains(accountNumber)){
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

						if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_VerifyAmnt,driver)){
							WebElement PayBill_CreditDebit_VerifyAmnt=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_VerifyAmnt));
							if(PayBill_CreditDebit_VerifyAmnt.getAttribute("textContent").contains(paymentAmount)){
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

						if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_VerifyPayDate,driver)){
							WebElement PayBill_CreditDebit_VerifyPayDate=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_VerifyPayDate));
							System.out.println(PayBill_CreditDebit_VerifyPayDate.getAttribute("textContent"));
							if(PayBill_CreditDebit_VerifyPayDate.getAttribute("textContent").contains(paymentDate)){
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

						if(cnf.FnExplicitWait("XPATH", mbo.VerifyPaymentInfo_EditPayLink,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Edit Payment Details link is displayed","Edit Payment Details link is displayed","PASS",runManagerInfoObj);
							WebElement VerifyPaymentInfo_EditPayLink=driver.findElement(By.xpath(mbo.VerifyPaymentInfo_EditPayLink));
							if(cnf.JSClick(VerifyPaymentInfo_EditPayLink,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Edit Payment Details link is clicked","Edit Payment Details link is clicked","PASS",runManagerInfoObj);

								Thread.sleep(5000);
								
								driver.switchTo().defaultContent();

								blnFlag = Q2Wall_Fn_ConfirmationPop(driver,runManagerInfoObj);
								
								driver.switchTo().frame("iFrameResizer0");

								if(blnFlag){

									if(cnf.FnExplicitWait("XPATH", mbo.Q2wall_RoutingNumber,driver)){
										WebElement RoutingNumber=driver.findElement(By.xpath(mbo.Q2wall_RoutingNumber));
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

									if(cnf.FnExplicitWait("XPATH", mbo.Q2wall_BankAccountNumber,driver)){
										WebElement BankAccountNumber=driver.findElement(By.xpath(mbo.Q2wall_BankAccountNumber));
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

									if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_Amount,driver)){
										WebElement PaymentAmount=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_Amount));
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

									if(cnf.FnExplicitWait("XPATH", mbo.PayBill_CreditDebit_PayDate,driver)){
										WebElement PaymentDate=driver.findElement(By.xpath(mbo.PayBill_CreditDebit_PayDate));
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
									repfn.FnUpdateTestStepResHTML("Verify User is navigated back to the Pay Bill screen ","User is not navigated back to the Pay Bill screen ","FAIL",runManagerInfoObj);
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
					else
					{
						repfn.FnUpdateTestStepResHTML("Check if Payment Summary sub-heading  is displayed", "Payment Summary sub- heading is not displayed", "FAIL",runManagerInfoObj);
						blnFlag=false; 
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

public synchronized boolean Q2Wall_CancelbuttonClick_ConfirmAlert(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{
	try{

		if(cnf.FnExplicitWait("Xpath",mbo.Q2wall_Cancelbtn,driver)){
			WebElement Q2wall_Cancelbutton=driver.findElement(By.xpath(mbo.Q2wall_Cancelbtn));
			if(cnf.JSClick(Q2wall_Cancelbutton,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Cancel button is clicked","Cancel button is clicked","PASS",runManagerInfoObj);
				Thread.sleep(3000);
				if(cnf.isAlertPresent()){
					driver.switchTo().alert();
					String ErrMsg=driver.switchTo().alert().getText();
					System.out.println(ErrMsg);
					driver.switchTo().alert().accept();
					driver.switchTo().defaultContent();
					Thread.sleep(5000);
				}
				else{
					//repfn.FnUpdateTestStepResHTML("verify .... ",".......","PASS/WARNING");// update the reporting function based on your requirement
					System.out.println("No alert present");                                              
				}

				if(cnf.FnExplicitWait("XPATH", mbo.Q2_SignIn_PageHeader,driver))
				{					
					repfn.FnUpdateTestStepResHTML("Verify User is navigated back to Login page", "User is navigated back to Login page where they accessed Forgot Username screen from" , "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify User is navigated back to Login page", "User is not navigated back to Login page where they accessed Forgot Username screen from" , "FAIL",runManagerInfoObj);
					blnFlag=false;	
				}

			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Cancel button is clicked","Cancel button is not clicked","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
	}
	catch (Exception e)

	{
		repfn.FnUpdateTestStepResHTML("Verify User is navigated back to Login page", "User is not navigated back to Login page where they accessed Forgot Username screen from due to some exception" , "FAIL",runManagerInfoObj);
		blnFlag=false;	
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}










}
