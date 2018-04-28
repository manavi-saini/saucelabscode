package com.charter.sb.services;

import java.util.List;
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

public class ConcurrentSBnetUXService extends Initialization{
	MB_PageObjects mbo = new MB_PageObjects();
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	public static boolean blnFlag = false;
	
	 public synchronized boolean Q1Logout(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 blnFlag=app.CommonLogout(driver,runManagerInfoObj);

			 if(cnf.FnExplicitWait("XPATH",mbo.SharedLogout,driver))
			 {
				 repfn.FnUpdateTestStepResHTML("Check Whether User V1 user is navigated to shared logout page", "V1 user is navigated to shared logout page","PASS",runManagerInfoObj);											
				 blnFlag = true;

			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Check Whether User V1 user is navigated to shared logout page", "V1 user is not navigated to shared logout page","FAIL",runManagerInfoObj);
				 blnFlag = false;
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
	 public synchronized boolean FN_LoginUsingQ1_Q2User(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
	 {
		 boolean blnFlag=false;
		 try
		 {
			 //driver.manage().window().maximize();
			 String strUserName1=m1.get("AppUsernameChangeUser").toString();
			 String strPwd1=m1.get("AppPwd").toString();
			 System.out.println("user id: "+strUserName1);
			 System.out.println("pwd: "+strPwd1);
			 String Appurl=driver.getCurrentUrl();
			 Thread.sleep(8000);
			 System.out.println("title in IE::::::"+driver.getTitle().toString());
			 if(driver.getTitle().toString().contains("SpectrumBusiness.net - Sign In") )
			 {

				 //Set UserName
				 if(cnf.FnExplicitWait("Xpath",mbo.LoginWindow,driver)){
					 WebElement userName=driver.findElement(By.xpath(mbo.UserName));
					 userName.sendKeys(strUserName1);
					 repfn.FnUpdateTestStepResHTML("Enter User ID: " +strUserName1, "User ID is entered","PASS",runManagerInfoObj);
					 blnFlag = true;	
				 }
				 else
				 {
					 repfn.FnUpdateTestStepResHTML("Enter User ID: " +strUserName1, "User ID is not entered","FAIL",runManagerInfoObj);
					 blnFlag = false;	
				 }

				 // Set Password
				 
				 if(cnf.FnExplicitWait("Xpath",mbo.Password,driver)){
					 WebElement Password=driver.findElement(By.xpath(mbo.Password));
					 Password.sendKeys(strPwd1);
					 repfn.FnUpdateTestStepResHTML("Enter Password", "Password is entered","PASS",runManagerInfoObj);
					 blnFlag = true;
				 }
				 else
				 {
					 repfn.FnUpdateTestStepResHTML("Enter Password", "Password is not entered","FAIL",runManagerInfoObj);					
					 blnFlag = false;	
				 }
				 
				 if(cnf.FnExplicitWait("Xpath",mbo.SignInBtn,driver)){
					 WebElement signin=driver.findElement(By.xpath(mbo.SignInBtn));
					 cnf.JSClick(signin,driver);
					 cnf.JSClick(signin,driver);
					 repfn.FnUpdateTestStepResHTML("Verify Click on Sign in Button", "Sign in Button is Clicked","PASS",runManagerInfoObj);
					 Thread.sleep(5000);
				 }
				 //Click on Sign in Button

			
				 if(blnFlag){
					 blnFlag = true;
					 repfn.FnUpdateTestStepResHTML("Veriy whether login is success or not", "User logged in succesfully", "PASS",runManagerInfoObj);
				 }
				 else
				 {
					 blnFlag= false;
					 repfn.FnUpdateTestStepResHTML("Veriy whether login is success or not", "Login Failed", "FAIL",runManagerInfoObj);				
				 }
			 }


			 else
			 {   
				 repfn.FnUpdateTestStepResHTML("Launch Charter.net url: "+Appurl, "Home page is not displayed","FAIL",runManagerInfoObj);
				 blnFlag = false;
			 }
		 }
		 catch(Exception e)
		 {
			 blnFlag = false;
			 repfn.FnUpdateTestStepResHTML("Login to Charter.net ", "Login is not performed due to exception","FAIL",runManagerInfoObj);
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());

		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }
	 public synchronized boolean FnOverviewPageV2(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
		 try{
			 Thread.sleep(2000);	
			 if(cnf.FnExplicitWait("XPATH", mbo.Home_OverviewLabel,driver))
			 {
				 repfn.FnUpdateTestStepResHTML("Verify whether User is in Overview Page or not","User is navigated to V2 overview page","PASS",runManagerInfoObj);
				 repfn.FnUpdateTestStepResHTML("Verify whether Overview label is displayed or not","Overview label is displayed","PASS",runManagerInfoObj);
				 blnFlag=true;


			 }else
			 {
				 repfn.FnUpdateTestStepResHTML("Verify whether User is in Overview Page or not","User is not in v2 overview page","WARNING",runManagerInfoObj);
				
				 String StgAppurl=m1.get("AppURL").toString().trim();
				 driver.get(StgAppurl+"smb1/dashboard.html#/");
				 if(cnf.FnExplicitWait("XPATH", mbo.v1_overview,driver))
				 {

					 repfn.FnUpdateTestStepResHTML("Verify whether User is navigated to Overview Page or not","User is navigated to V2 overview page","PASS",runManagerInfoObj);
					 repfn.FnUpdateTestStepResHTML("Verify whether Overview label is displayed or not","Overview label is displayed","PASS",runManagerInfoObj);
					 blnFlag=true;
				 }else
				 {
					 repfn.FnUpdateTestStepResHTML("Verify whether User is navigated to Overview Page or not","User is not navigated to overview page","FAIL",runManagerInfoObj);
					 blnFlag=false;

				 }
			 }

		 }

		 catch (Exception e)

		 {
			 repfn.FnUpdateTestStepResHTML("Verify whether User is navigated to Overview Page or not","User is not navigated to overview page due to some exception","FAIL",runManagerInfoObj);
			 blnFlag=false;
			 if(!cnf.FnExplicitWait("XPATH", mbo.v1_overview,driver))
			 {

				 driver.close();
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				 repfn.FnInitializeBrowser(runManagerInfoObj);
				 app.FnLaunchCharterApp(driver,runManagerInfoObj);
				 repfn.FnUpdateTestStepResHTML("Verify whether User is in Overview page", "User is in Overview page", "PASS",runManagerInfoObj);
				 blnFlag=true;
			 }
			 else
			 {
				 repfn.FnUpdateTestStepResHTML("Verify whether User is in Overview page", "User is not in Overview page", "FAIL",runManagerInfoObj);
				 blnFlag=false; 
			 }
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());

		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }
	 public synchronized boolean Q2Logout(WebDriver driver, RunManagerInfo runManagerInfoObj)
	 {
		 try
		 {
			 blnFlag=app.CommonLogout(driver,runManagerInfoObj);
			 if(cnf.FnExplicitWait("XPATH",mbo.LoginWindow,driver)){
			 WebElement Logout=driver.findElement(By.xpath(mbo.LoginWindow));
			 
				 repfn.FnUpdateTestStepResHTML("Check Whether User V2 user is navigated to shared logout page", "V2 user is navigated to shared logout page","PASS",runManagerInfoObj);											
				 blnFlag = true;

			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Check Whether User V2 user is navigated to shared logout page", "V2 user is not navigated to shared logout page","FAIL",runManagerInfoObj);
				 blnFlag = false;
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
	 public synchronized boolean fn_unauthenticatedUser(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
	 {

		 String url = "";
		 try{
			 
			 if(cnf.FnExplicitWait("XPATH", mbo.Logo,driver)){
				 repfn.FnUpdateTestStepResHTML("Verify Spectrum business Logo is displayed on Home Page", "Spectrum business Logo is displayed on Home Page","PASS",runManagerInfoObj);
				 WebElement SpectrumLogo=driver.findElement(By.xpath(mbo.Logo));
				 if(cnf.JSClick(SpectrumLogo,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify Spectrum business Logo is clicked", "Spectrum business Logo is clicked","PASS",runManagerInfoObj);
					 Thread.sleep(3000);
					 
					 if(cnf.FnExplicitWait("XPATH", mbo.LoginWindow,driver)){
						 repfn.FnUpdateTestStepResHTML("Verify User is navigated to Shared Home page", "User is navigated to Shared Home page","PASS",runManagerInfoObj);
						 
						 //Check Signin Button
						 if(cnf.FnExplicitWait("XPATH", mbo.UnauthenticatedUser_SharedHomePage_SignIn,driver)){
							 repfn.FnUpdateTestStepResHTML("Check Whether Sign In button is displayed", "Sign In button is displayed","PASS",runManagerInfoObj);
							 blnFlag = true;							 
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Check Whether Sign In button is displayed", "Sign In button is not displayed","FAIL",runManagerInfoObj);
							 blnFlag = false;
						 }

								
						 //Check Register Account Button
								
						 if( cnf.FnExplicitWait("XPATH", mbo.UnauthenticatedUser_SharedHomePage_RegisterAccount,driver)){
							 repfn.FnUpdateTestStepResHTML("Check Whether Register Account button is displayed", "Register Account button is displayed","PASS",runManagerInfoObj);
							 blnFlag = true;
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Check Whether Register Account button is displayed", "Register Account button is not displayed","FAIL",runManagerInfoObj);
							 blnFlag = false;
						 }
						 
						 if(cnf.FnExplicitWait("XPATH", mbo.UnauthenticatedUser_SharedHomePage_RegisterAccount,driver)){
							 WebElement RegisterAccount=driver.findElement(By.xpath(mbo.UnauthenticatedUser_SharedHomePage_RegisterAccount));
							 if(cnf.JSClick(RegisterAccount,driver)){
								 repfn.FnUpdateTestStepResHTML("Check Whether Register Account button is clicked", "Register Account button is clicked","PASS",runManagerInfoObj);
								 Thread.sleep(5000);
								 
								 if(cnf.FnExplicitWait("XPATH", mbo.RegisterAccountPageVerification,driver)){
									 WebElement RegisterAccountPageVerification=driver.findElement(By.xpath(mbo.RegisterAccountPageVerification));
									 if(RegisterAccountPageVerification.getAttribute("textContent").equalsIgnoreCase("Account Registration")){
										 repfn.FnUpdateTestStepResHTML("Verify User is navigated to \'Register Account\' Page", "User is navigated to \'Register Account\' Page","PASS",runManagerInfoObj);
										 blnFlag = true;
									 }
									 else{
										 repfn.FnUpdateTestStepResHTML("Verify User is navigated to \'Register Account\' Page", "User is not navigated to \'Register Account\' Page","FAIL",runManagerInfoObj);
										 blnFlag = false;
									 }
								 }
								 else{
									 repfn.FnUpdateTestStepResHTML("Verify User is navigated to \'Register Account\' Page", "User is not navigated to \'Register Account\' Page","FAIL",runManagerInfoObj);
									 blnFlag = false;
								 }								 
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Check Whether Register Account button is clicked", "Register Account button is not clicked","FAIL",runManagerInfoObj);
								 blnFlag = false;
							 }
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Check Whether Register Account button is displayed", "Register Account button is not displayed","FAIL",runManagerInfoObj);
							 blnFlag = false;
						 }
						 
						 boolean blnFlag1 = SpectrumLogoClick(driver,runManagerInfoObj);
						 
						 if(blnFlag1){
							 
							 if(cnf.FnExplicitWait("XPATH", mbo.UnauthenticatedUser_SharedHomePage_SignIn,driver)){/*
								 WebElement SignIn=driver.findElement(By.xpath(mbo.UnauthenticatedUser_SharedHomePage_SignIn));
								 if(cnf.JSClick(SignIn)){
									 repfn.FnUpdateTestStepResHTML("Check Whether Sign In button is clicked", "Sign In button is clicked","PASS",runManagerInfoObj);
									 Thread.sleep(5000);
									 
									 if(cnf.FnExplicitWait("XPATH", mbo.SignInPageVerification)){
										 WebElement SignInPageVerification=driver.findElement(By.xpath(mbo.SignInPageVerification));
										 if(SignInPageVerification.getAttribute("textContent").equalsIgnoreCase("Sign In")){
											 repfn.FnUpdateTestStepResHTML("Verify User is navigated to \'Sign In\' Page", "User is navigated to \'Sign In\' Page","PASS",runManagerInfoObj);
											 blnFlag = true;
										 }
										 else{
											 repfn.FnUpdateTestStepResHTML("Verify User is navigated to \'Sign In\' Page", "User is not navigated to \'Sign In\' Page","FAIL",runManagerInfoObj);
											 blnFlag = false;
										 }
									 }
									 else{
										 repfn.FnUpdateTestStepResHTML("Verify User is navigated to \'Sign In\' Page", "User is not navigated to \'Sign In\' Page","FAIL",runManagerInfoObj);
										 blnFlag = false;
									 }
								 }
								 else{
									 repfn.FnUpdateTestStepResHTML("Check Whether Sign In button is clicked", "Sign In button is not clicked","FAIL",runManagerInfoObj);
									 blnFlag = false;
								 }
							 */}
							 else{
								 repfn.FnUpdateTestStepResHTML("Check Whether Sign In button is displayed", "Sign In button is not displayed","FAIL",runManagerInfoObj);
								 blnFlag = false;
							 }
							 
							//Click Register Account Shared LogIn

							 if( cnf.FnExplicitWait("XPATH", mbo.UnauthenticatedUser_SharedSignInPage_RegisterAccount,driver)){
								 repfn.FnUpdateTestStepResHTML("Check Whether Register Account button is displayed on Shared Login page", "Register Account button is displayed on Shared Login page","PASS",runManagerInfoObj);
								 WebElement SharedSignInPage_RegisterAccount=driver.findElement(By.xpath(mbo.UnauthenticatedUser_SharedSignInPage_RegisterAccount));
								 if(cnf.JSClick(SharedSignInPage_RegisterAccount,driver)){
									 repfn.FnUpdateTestStepResHTML("Check Whether Register Account button is clicked", "Register Account button is clicked","PASS",runManagerInfoObj);
									 Thread.sleep(5000);
									 
									 if(cnf.FnExplicitWait("XPATH", mbo.RegisterAccountPageVerification,driver)){
										 WebElement RegisterAccountPageVerification=driver.findElement(By.xpath(mbo.RegisterAccountPageVerification));
										 if(RegisterAccountPageVerification.getAttribute("textContent").equalsIgnoreCase("Account Registration")){
											 repfn.FnUpdateTestStepResHTML("Verify User is navigated to \'Register Account\' Page", "User is navigated to \'Register Account\' Page","PASS",runManagerInfoObj);
											 
											 if(cnf.FnExplicitWait("XPATH", mbo.Logo,driver)){
												 WebElement SpectrumLogoOne=driver.findElement(By.xpath(mbo.Logo));
												 cnf.JSClick(SpectrumLogoOne,driver);
												 blnFlag = true;
												 Thread.sleep(3000);
											 }
											 else{
												 repfn.FnUpdateTestStepResHTML("Verify Spectrum business Logo is displayed on Home Page", "Spectrum business Logo is not displayed on Home Page","FAIL",runManagerInfoObj);
												 blnFlag = false;
											 }
										 }
										 else{
											 repfn.FnUpdateTestStepResHTML("Verify User is navigated to \'Register Account\' Page", "User is not navigated to \'Register Account\' Page","FAIL",runManagerInfoObj);
											 blnFlag = false;
										 }
									 }
									 else{
										 repfn.FnUpdateTestStepResHTML("Verify User is navigated to \'Register Account\' Page", "User is not navigated to \'Register Account\' Page","FAIL",runManagerInfoObj);
										 blnFlag = false;
									 }	
								 }
								 else{
									 repfn.FnUpdateTestStepResHTML("Check Whether Register Account button is clicked", "Register Account button is not clicked","FAIL",runManagerInfoObj);
									 blnFlag = false;
								 }
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Check Whether Register Account button is displayed on Shared Login page", "Register Account button is not displayed on Shared Login page","FAIL",runManagerInfoObj);
								 blnFlag = false;
							 }
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify User is navigated to Shared Home page", "User is not navigated to Shared Home page","FAIL",runManagerInfoObj);
							 blnFlag = false;
						 }						 
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify User is navigated to Shared Home page", "User is not navigated to Shared Home page","FAIL",runManagerInfoObj);
						 blnFlag = false;
					 }
					 
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify Spectrum business Logo is clicked", "Spectrum business Logo is not clicked","FAIL",runManagerInfoObj);
					 blnFlag = false;
				 }
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify Spectrum business Logo is displayed on Home Page", "Spectrum business Logo is not displayed on Home Page","FAIL",runManagerInfoObj);
				 blnFlag = false;
			 }
		 }
		 catch (Exception e)

		 {
			 repfn.FnUpdateTestStepResHTML("Verify User is able to navigate to Sign In and Register Account page", "User is not able to navigate to Sign In and Register Account page due to some exception","FAIL",runManagerInfoObj);
			 blnFlag = false;
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());

		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }

	 /**//**
		 * Method Name : Demo SpectrumLogo Click
		 * Method Description : This method is to click on the Spectrum business logo and navigate to overview page
		 * @return None
		 * @author Ajoy
		 * @param placeholder 
		 * @throws Exception
		 *//*
		 */
		public synchronized boolean SpectrumLogoClick(WebDriver driver, RunManagerInfo runManagerInfoObj)
		{
			
			try
			{
				if(cnf.FnExplicitWait("XPATH",mbo.SpectrumLogoClick,driver)){
					WebElement SpectrumLogoClick=driver.findElement(By.xpath(mbo.SpectrumLogoClick));
					if(cnf.JSClick(SpectrumLogoClick,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Logo is clicked","Spectrum Business Logo is clicked","PASS",runManagerInfoObj);
						
						Thread.sleep(5000);
						
						if(cnf.FnExplicitWait("XPATH",mbo.LoginWindow,driver)){
							repfn.FnUpdateTestStepResHTML("Verify User is navigated to Shared Home page", "User is navigated to Shared Home page","PASS",runManagerInfoObj);
							blnFlag	=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User is navigated to Shared Home page", "User is not navigated to Shared Home page","FAIL",runManagerInfoObj);
							blnFlag	=false;
						}
						
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Logo is clicked","Spectrum Business Logo is not clicked","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Logo is displayed","Spectrum Business Logo is not displayed","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}


			}
			catch(Exception e)
			{
				blnFlag	=false;
				repfn.FnUpdateTestStepResHTML("Login to Spectrum Business.net ", "Login is not performed due to exception","FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		 public synchronized boolean Q1userLogOutQ2UserLogin(WebDriver driver, RunManagerInfo runManagerInfoObj)
		 {

			 try{

				 app.CommonLogout(driver,runManagerInfoObj);
				 SpectrumLogoClick(driver,runManagerInfoObj);
				 app.CommonLogin(driver,runManagerInfoObj);
				 cnf.FnExplicitWait("XPATH", mbo.Home_OverviewLabel,driver);
				 WebElement OverviewLabel=driver.findElement(By.xpath(mbo.Home_OverviewLabel));

				 if(OverviewLabel.isDisplayed()){
					 repfn.FnUpdateTestStepResHTML("Verify User in Home Page After Login with Q2User","User in Home Page After Login with Q2User","PASS",runManagerInfoObj);
					 blnFlag=true;
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify User in Home Page After Login with Q2User","User is not in Home Page After Login with Q2User","FAIL",runManagerInfoObj);
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
		 public synchronized boolean Q2userLogOutQ1UserLogin(WebDriver driver, RunManagerInfo runManagerInfoObj)
		 {

			 try{

				 //Check for Login Link in Header

				 app.CommonLogout(driver,runManagerInfoObj);
				 SpectrumLogoClick(driver,runManagerInfoObj);
				app.CommonLogin(driver,runManagerInfoObj);
				 cnf.FnExplicitWait("XPATH", mbo.Home_OverviewLabel,driver);
				 WebElement OverviewLabel=driver.findElement(By.xpath(mbo.Home_OverviewLabel));

				 if(OverviewLabel.isDisplayed()){
					 repfn.FnUpdateTestStepResHTML("Verify User in Home Page After Login with Q1User","User in Home Page After Login with Q1User","PASS",runManagerInfoObj);
					 blnFlag=true;
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify User in Home Page After Login with Q1User","User is not in Home Page After Login with Q1User","FAIL",runManagerInfoObj);
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
		 public synchronized boolean HeaderChanges(WebDriver driver, RunManagerInfo runManagerInfoObj)
		 {
			 try
			 {
				 if(cnf.FnExplicitWait("XPATH",mbo.SpectrumLogo ,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify if Spectrum Logo is displayed","Spectrum Logo is displayed","PASS",runManagerInfoObj);
					 blnFlag=true;
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if Spectrum Logo is displayed","Spectrum Logo is not displayed","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }

				 if(cnf.FnExplicitWait("XPATH", mbo.LoginBtn,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify if Login link is displayed","Login link is displayed","PASS",runManagerInfoObj);
					 blnFlag=true;
				 }
				 else
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if Login link is displayed","Login link is not displayed","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 catch(Exception e)
			 {
				 blnFlag = false;
				 repfn.FnUpdateTestStepResHTML("Login to Spectrum Business.net ", "Login is not performed due to exception","FAIL",runManagerInfoObj);
				 System.err.println("Message : "+e.getMessage());
				 System.err.println("Cause : "+e.getCause());
			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;
		 }


		 public synchronized boolean V1_Support(WebDriver driver, RunManagerInfo runManagerInfoObj)
		 {
			 try
			 {
				if( cnf.FnExplicitWait("XPATH", mbo.V1_Support,driver)){
				 WebElement Support_Myacc=driver.findElement(By.xpath(mbo.V1_Support));
				
					 repfn.FnUpdateTestStepResHTML("Verify if Support link is displayed in the header","Support link is displayed in the header","PASS",runManagerInfoObj);
					 if(cnf.JSClick(Support_Myacc,driver)){
					 //Thread.sleep(3000);
						 repfn.FnUpdateTestStepResHTML("Verify if the Support link is clicked","Support link is  clicked","PASS",runManagerInfoObj);

					 if(cnf.FnExplicitWait("Xpath",mbo.V1_Support_link ,driver)){
						
						 repfn.FnUpdateTestStepResHTML("Verify if the Shared Support page is displayed","Shared Support page is displayed","PASS",runManagerInfoObj);
						 blnFlag=true;

					 }
					 else{
						
						 repfn.FnUpdateTestStepResHTML("Verify if the Shared Support page is displayed","Shared Support page is not displayed","FAIL",runManagerInfoObj);
						 blnFlag=false;

					 }
					 }else{
						 repfn.FnUpdateTestStepResHTML("Verify if the Support link is clicked","Support link is not clicked","FAIL",runManagerInfoObj);
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
		 public synchronized boolean V2_Support(WebDriver driver, RunManagerInfo runManagerInfoObj)
		 {
			 try
			 {
			if( cnf.FnExplicitWait("XPATH", mbo.Support_MyAccount,driver)){
				 WebElement Support_Myacc=driver.findElement(By.xpath(mbo.Support_MyAccount));
			
					 repfn.FnUpdateTestStepResHTML("Verify if Support link is displayed in the header","Support link is displayed in the header","PASS",runManagerInfoObj);
					if( cnf.JSClick(Support_Myacc,driver)){
					 Thread.sleep(4000);
					 repfn.FnUpdateTestStepResHTML("Verify User is able to click on Support link ","User clicked on Support link","PASS",runManagerInfoObj);
					

					 if(cnf.FnExplicitWait("XPATH", mbo.V2_search_support,driver)){
						
						 repfn.FnUpdateTestStepResHTML(" Verify if the Shared Support page is displayed","Shared Support page is displayed","PASS",runManagerInfoObj);
						 blnFlag=true;

					 }
					 else{
					
						 repfn.FnUpdateTestStepResHTML("Verify if the Shared Support page is displayed","Shared Support page is not displayed","FAIL",runManagerInfoObj);
						 blnFlag=false;

					 }
					}else{
						repfn.FnUpdateTestStepResHTML("Verify User is able to click on Support link ","User is not able to click on Support link","FAIL",runManagerInfoObj);
						 blnFlag=false;
					}
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if Support link is displayed in the header","Support link is not displayed on the header","FAIL",runManagerInfoObj);
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

		 public synchronized boolean FnCheckVoiceTile(WebDriver driver, RunManagerInfo runManagerInfoObj){
			 try{
				 if(cnf.FnExplicitWait("Xpath",mbo.VoiceLink,driver)){				 
					 repfn.FnUpdateTestStepResHTML("Verify if Voice tile link is present in overview page ","Voice tile link is present in overview page ","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if Voice tile link is present in overview page ","Voice tile link is not present in overview page ","PASS",runManagerInfoObj);
					 blnFlag=true;
				 }
			 }

			 catch (Exception e)

			 {
				 repfn.FnUpdateTestStepResHTML("Verify if voice tile link is present in overview page ","Voice tile link is not present in overview page","PASS",runManagerInfoObj);
				 blnFlag=true;
				 System.err.println("Message : "+e.getMessage());
				 System.err.println("Cause : "+e.getCause());
			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;
		 }
		 
		 public synchronized boolean V2UsersWithoutPhoneService(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
			 
			 try
			 {
				 if(cnf.FnExplicitWait("Xpath",mbo.manageUsersList,driver)){	
					 List<WebElement> manageUsersList=driver.findElements(By.xpath(mbo.manageUsersList));
					 WebElement manageUser = manageUsersList.get(0);
					 if(cnf.JSClick(manageUser,driver)){
						 repfn.FnUpdateTestStepResHTML("Verify A User is selected from the list","A User is selected from the list","PASS",runManagerInfoObj);

						 Thread.sleep(5000);
						 if(cnf.FnExplicitWait("Xpath",mbo.manageEditLink,driver)){	
							 repfn.FnUpdateTestStepResHTML("Verify if User Detail window is opened next to the list","User detail window is opened next to the list","PASS",runManagerInfoObj);
							 repfn.FnUpdateTestStepResHTML("Verify if Edit link is present","Edit link is present","PASS",runManagerInfoObj);

							 WebElement editUserLink=driver.findElement(By.xpath(mbo.manageEditLink));
							 if(cnf.JSClick(editUserLink,driver)){
								 repfn.FnUpdateTestStepResHTML("Verify if User has clicked on Edit link","User has clicked on Edit link","PASS",runManagerInfoObj);

								 Thread.sleep(3000);
								 if(cnf.FnExplicitWait("Xpath",mbo.checkPhoneService,driver)){	
									 repfn.FnUpdateTestStepResHTML("Verify if phone service is removed for the user","Phone service is not removed for the user","FAIL",runManagerInfoObj);
									 blnFlag=false;
								 }
								 else{
									 repfn.FnUpdateTestStepResHTML("Verify if phone service is removed for the user","Phone service is removed for the user","PASS",runManagerInfoObj);
									 if(cnf.FnExplicitWait("Xpath",mbo.manageCancelButton,driver)){	
										 repfn.FnUpdateTestStepResHTML("Verify Cancel Link is displayed","Cancel Link is displayed","PASS",runManagerInfoObj);

										 WebElement cancelButton=driver.findElement(By.xpath(mbo.manageCancelButton));
										 if(cnf.JSClick(cancelButton,driver)){
											 repfn.FnUpdateTestStepResHTML("Verify Cancel Link is clicked","Cancel Link is clicked","PASS",runManagerInfoObj);
											 Thread.sleep(5000);

											 if(cnf.FnExplicitWait("Xpath",mbo.manageBackButton,driver)){	
												 repfn.FnUpdateTestStepResHTML("Verify Back Link is displayed","Back Link is displayed","PASS",runManagerInfoObj);

												 WebElement backButton=driver.findElement(By.xpath(mbo.manageBackButton));
												 if(cnf.JSClick(backButton,driver)){
													 repfn.FnUpdateTestStepResHTML("Verify Back Link is clicked","Back Link is clicked","PASS",runManagerInfoObj);
													 blnFlag=true;
													 Thread.sleep(2000);
												 }
												 else{
													 repfn.FnUpdateTestStepResHTML("Verify Back Link is clicked","Back Link is not clicked","FAIL",runManagerInfoObj);
													 blnFlag=false;
												 }
											 }
											 else{
												 repfn.FnUpdateTestStepResHTML("Verify Back Link is displayed","Back Link is not displayed","FAIL",runManagerInfoObj);
												 blnFlag=false;
											 }
										 }
										 else{
											 repfn.FnUpdateTestStepResHTML("Verify Cancel Link is clicked","Cancel Link is not clicked","FAIL",runManagerInfoObj);
											 blnFlag=false;
										 }
									 }
									 else{
										 repfn.FnUpdateTestStepResHTML("Verify Cancel Link is displayed","Cancel Link is not displayed","FAIL",runManagerInfoObj);
										 blnFlag=false;
									 }

								 }


							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify if User has clicked on Edit link","User has not clicked on Edit link","FAIL",runManagerInfoObj);
								 blnFlag=false;
							 }
						 }
						 else{
							 blnFlag=false;
							 repfn.FnUpdateTestStepResHTML("Verify if User Detail window is opened next to the list","User detail window is not opened next to the list","FAIL",runManagerInfoObj);
							 repfn.FnUpdateTestStepResHTML("Verify if Edit link is present","Edit link is not present","FAIL",runManagerInfoObj);
						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify A User is selected from the list","A User is not selected from the list","FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }

			 }
			 catch (Exception e)

			 {
				 repfn.FnUpdateTestStepResHTML("Verify if the user is not able to access Phone options from Manage users page edit page","User is able to access Phone options from Manage users page edit page due to some exception","FAIL",runManagerInfoObj);
				 blnFlag=false;
				 System.err.println("Message : "+e.getMessage());
				 System.err.println("Cause : "+e.getCause());
			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;
		 }

		 public synchronized boolean V2UsersWithoutPhoneServiceNewUser(WebDriver driver, RunManagerInfo runManagerInfoObj) {
				try
				{
					WebElement addNewUser=driver.findElement(By.xpath(mbo.manageAddNewUser));
					if(cnf.FnExplicitlessWait_untilClickable("XPATH", mbo.manageAddNewUser,driver))
					{
						blnFlag=true;
						repfn.FnUpdateTestStepResHTML("Verify if add new user button is clickable ","Add new user button is clickable","PASS",runManagerInfoObj);
						if(cnf.JSClick(addNewUser,driver))
						{
							Thread.sleep(5000);
							blnFlag=true;
							repfn.FnUpdateTestStepResHTML("Verify if add new user button is clicked ","Add new user button is clicked","PASS",runManagerInfoObj);
							WebElement firstName=driver.findElement(By.id(mbo.manageFirstName));
							if(cnf.FnExplicitlessWait_untilClickable("ID", mbo.manageFirstName,driver))
							{
								blnFlag=true;
								String firstNameText="Richard";
								firstName.sendKeys(firstNameText);
								repfn.FnUpdateTestStepResHTML("Verify if user is able to add first name","User is able to add first name: "+firstNameText,"PASS",runManagerInfoObj);
								WebElement lastName=driver.findElement(By.id(mbo.manageLastName));
								if(cnf.FnExplicitlessWait_untilClickable("ID", mbo.manageLastName,driver))
								{
									blnFlag=true;
									String lastNameText="Williams";
									lastName.sendKeys(lastNameText);
									repfn.FnUpdateTestStepResHTML("Verify if user is able to add last name","User is able to add last name: "+lastNameText,"PASS",runManagerInfoObj);
									WebElement emailAddress=driver.findElement(By.xpath((mbo.manageEmailAddress)));
									if(cnf.FnExplicitlessWait_untilClickable("XPATH", mbo.manageEmailAddress,driver))
									{
										blnFlag=true;
										String emailText="RichardWilliams@gmail.com";
										emailAddress.sendKeys(emailText);
										repfn.FnUpdateTestStepResHTML("Verify if user is able to add email address","User is able to add email address: "+emailText,"PASS",runManagerInfoObj);
										WebElement nextButton=driver.findElement(By.xpath(mbo.manageNextButton));
										if(cnf.FnExplicitlessWait_untilClickable("XPATH", mbo.manageNextButton,driver))
										{
											blnFlag=true;
											cnf.JSClick(nextButton,driver);
											Thread.sleep(5000);
											repfn.FnUpdateTestStepResHTML("Verify if user has clicked the next button","User has clicked the next button","PASS",runManagerInfoObj);
											WebElement permissionsRadioButton=driver.findElement(By.xpath(mbo.managePermissionOption));
											if(cnf.FnExplicitlessWait_untilClickable("XPATH", mbo.managePermissionOption,driver))
											{
												blnFlag=true;
												cnf.JSClick(permissionsRadioButton,driver);
												Thread.sleep(5000);
												repfn.FnUpdateTestStepResHTML("Verify if user has selected the role ","User has selected the role","PASS",runManagerInfoObj);
												WebElement nextButtonInRolePage=driver.findElement(By.xpath(mbo.manageNextButton));
												if(cnf.FnExplicitlessWait_untilClickable("XPATH", mbo.manageNextButton,driver))
												{
													blnFlag=true;
													cnf.JSClick(nextButtonInRolePage,driver);
													Thread.sleep(5000);
													repfn.FnUpdateTestStepResHTML("Verify if user has clicked the next button","User has clicked the next button","PASS",runManagerInfoObj);
													
													try
													{
														WebElement checkForPhoneService=driver.findElement(By.xpath(mbo.manageCheckPhoneService));	
														if(cnf.FnExplicitlessWait_untilClickable("XPATH", mbo.manageCheckPhoneService,driver))
														{
															blnFlag=false;
															repfn.FnUpdateTestStepResHTML("Verify if phone service is removed in add new user flow","Phone service is not removed in add new user flow","FAIL",runManagerInfoObj);
														}
														
													}
													catch(Exception e)
													{
														blnFlag=true;
														repfn.FnUpdateTestStepResHTML("Verify if phone service is removed in add new user flow","Phone service is removed in add new user flow","PASS",runManagerInfoObj);
													}
													WebElement confirmButton=driver.findElement(By.xpath(mbo.manageNextButton));
													if(cnf.FnExplicitlessWait_untilClickable("XPATH", mbo.manageNextButton,driver))
													{
														blnFlag=true;
														cnf.JSClick(confirmButton,driver);
														Thread.sleep(5000);
														repfn.FnUpdateTestStepResHTML("Verify if user has clicked the confirm button","User has clicked the confirm button","PASS",runManagerInfoObj);
														Thread.sleep(5000);
													}
													else
													{
														blnFlag=false;
														repfn.FnUpdateTestStepResHTML("Verify if user has clicked the confirm button","User has not clicked the confirm button","FAIL",runManagerInfoObj);
													}
												}
												else
												{
													blnFlag=false;
													repfn.FnUpdateTestStepResHTML("Verify if user has clicked the next button","User has not clicked the next button","FAIL",runManagerInfoObj);
												}
												
											}
											else
											{
												blnFlag=false;
												repfn.FnUpdateTestStepResHTML("Verify if user has selected the role","User has not selected the role","FAIL",runManagerInfoObj);
											}
										}
										else
										{
											blnFlag=false;
											repfn.FnUpdateTestStepResHTML("Verify if user has clicked the next button","User has not clicked the next button","FAIL",runManagerInfoObj);
										}
									}
									else
									{
										blnFlag=false;
										repfn.FnUpdateTestStepResHTML("Verify if user is able to add email address","User is not able to add email address","FAIL",runManagerInfoObj);
									}
								}
								else
								{
									blnFlag=false;
									repfn.FnUpdateTestStepResHTML("Verify if user is able to add last name","User is not able to add last name","PASS",runManagerInfoObj);
								}
								
							}
							else
							{
								blnFlag=false;
								repfn.FnUpdateTestStepResHTML("Verify if user is able to add first name","User is not able to add first name","PASS",runManagerInfoObj);
							}
							
							
						}
						else
						{
							blnFlag=false;
							repfn.FnUpdateTestStepResHTML("Verify if add new user button is clicked ","Add new user button is not clicked","FAIL",runManagerInfoObj);
						}
						
				        
					}
					else
					{
						blnFlag=false;
						repfn.FnUpdateTestStepResHTML("Verify if add new user button is clickable ","Add new user button is not clickable","FAIL",runManagerInfoObj);
					}
					
				}
				catch (Exception e)

				{
			        blnFlag=false;
			        repfn.FnUpdateTestStepResHTML("Verify if the user is able to access Phone options from Manage users page Create New user flow ","User is not able to access Phone options from Manage users page Create New user flow due to some exception","FAIL",runManagerInfoObj);
			        System.err.println("Message : "+e.getMessage());
					System.err.println("Cause : "+e.getCause());
				}
				m1.put("STEPSTATUS", blnFlag);
				return blnFlag;
			}

		
		 public synchronized boolean FnVerifyServiceManageUsers_WithNoVoiceService(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

				try{

					if(cnf.FnExplicitWait("XPATH",mbo.ManageUsers_RoleList,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Users are displayed on Manage User Page", "Users are displayed on Manage User Page","PASS",runManagerInfoObj);

						if(cnf.FnExplicitWait("XPATH",mbo.ManageUsers_VoiceService,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Voice Service is not assigned to the users", "Voice Service is assigned to the users","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Voice Service is not assigned to the users", "Voice Service is not assigned to the users","PASS",runManagerInfoObj);
							blnFlag=true;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Users are displayed on Manage User Page", "Users are not displayed on Manage User Page","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}

				catch (Exception e)

				{		
					repfn.FnUpdateTestStepResHTML("Verify if Voice Service is not present on Manage Users page for user without phone service", "Voice Service is present on Manage Users page for user without phone service due to some exception", "FAIL",runManagerInfoObj);
					blnFlag=false;
					System.err.println("Message : "+e.getMessage());
					System.err.println("Cause : "+e.getCause());
				}

				m1.put("STEPSTATUS", blnFlag);
				return blnFlag;
			}
	
		 
		 
}
