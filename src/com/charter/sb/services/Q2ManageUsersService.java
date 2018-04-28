package com.charter.sb.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.charter.sb.beans.RunManagerInfo;
import com.charter.sb.controllers.Initialization;
import com.charter.sb.resources.MB_PageObjects;
import com.charter.sb.utils.CommonFunctions;
import com.charter.sb.utils.ReportingFunctions;
import com.charter.sb.utils.RunManager;

public class Q2ManageUsersService extends Initialization {
	MB_PageObjects mbo = new MB_PageObjects();
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	public static boolean blnFlag = false;
	
	Random rg=new Random();
	int randomInt = rg.nextInt(10000);
	ArrayList<String> namelist = new ArrayList<String>();
	ArrayList<String> servicelist = new ArrayList<String>();
	ArrayList<String> rolelist = new ArrayList<String>();
	public  boolean voiceService = true;
	public synchronized boolean FnUSerDetailLinkPopup_DetailCheck(WebDriver driver, RunManagerInfo runManagerInfoObj){
		try{

			//UserDetailLabel
			if(cnf.FnExplicitWait("XPATH", mbo.UserDetail_Label,driver))
			{
				WebElement UserDetail_Label=driver.findElement(By.xpath(mbo.UserDetail_Label));
				repfn.FnUpdateTestStepResHTML("Verify UserDetail Label is displayed in the User details window  ","UserDetail Label is displayed in the User details window with the title: "+" "+UserDetail_Label.getText(),"PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify UserDetail Label is displayed in the User details window  ","UserDetail Label is not displayed in the User details window","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

			if(cnf.FnExplicitWait("XPATH", mbo.UserDetailList,driver))	
			{
				repfn.FnUpdateTestStepResHTML("Verify the presence of User info section in user details window", "User info section is present in user details window", "PASS",runManagerInfoObj);
				List<WebElement> UserDetailList=driver.findElements(By.xpath(mbo.UserDetailList));
				for(WebElement We:UserDetailList) {
					repfn.FnUpdateTestStepResHTML("Verify the User Details is displayed","User Details is displayed: "+" "+We.getText(),"PASS",runManagerInfoObj);
				}
				blnFlag=true;
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify the presence of User info section in user details window", "User info section is not present in user details window", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}

			//Role Label
			if(cnf.FnExplicitWait("XPATH", mbo.UserDeatil_RoleLabel,driver))
			{
				WebElement UserDeatil_RoleLabel=driver.findElement(By.xpath(mbo.UserDeatil_RoleLabel));
				repfn.FnUpdateTestStepResHTML("Verify  Role Label is displayed in the User details window ","Role Label is displayed in the User details window with the title: "+" "+UserDeatil_RoleLabel.getText(),"PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Role Label is displayed in the User details window ","Role Label is not displayed in the User details window","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

			if(cnf.FnExplicitWait("XPATH", mbo.UserDetailRoleList,driver))
			{
				WebElement UserDeatil_RoleList=driver.findElement(By.xpath(mbo.UserDetailRoleList));
				repfn.FnUpdateTestStepResHTML("Verify  Role is displayed in the User details window ","Role is displayed in the User details window with the title:"+" "+UserDeatil_RoleList.getText(),"PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Role is displayed in the User details window ","Role is not displayed in the User details window","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

			if(voiceService){
				if(cnf.FnExplicitWait("XPATH", mbo.UserDetail_VoiceServiceLabel,driver))
				{
					WebElement UserDetail_VoiceServiceLabel=driver.findElement(By.xpath(mbo.UserDetail_VoiceServiceLabel));
					repfn.FnUpdateTestStepResHTML("Verify VoiceService Label is displayed in the User details window "," VoiceService Label is displayed in the User details window","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify VoiceService Label is displayed in the User details window ","VoiceService Label is not displayed in the User details window","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				if(cnf.FnExplicitWait("XPATH", mbo.UserDetailVoiceList,driver))	
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Voice lines in user details window", "Voice lines is present in user details window", "PASS",runManagerInfoObj);
					List<WebElement> UserDetailVoiceList=driver.findElements(By.xpath(mbo.UserDetailVoiceList));
					for(WebElement We:UserDetailVoiceList) {
						repfn.FnUpdateTestStepResHTML("Verify Voice line is displayed","Voice line is displayed: "+" "+We.getText(),"PASS",runManagerInfoObj);
					}
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Voice lines in user details window", "Voice lines is not present in user details window", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Voice Service is not assigned to User"," Voice Service is not assigned to User","PASS",runManagerInfoObj);
				blnFlag=true;
			}

			//Edit button 
			if(cnf.FnExplicitWait("XPATH", mbo.UserDetail_EditBtn,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify Edit button is displayed ","Edit button is displayed","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Edit button is displayed ","Edit button is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}


			//back button
			if(cnf.FnExplicitWait("XPATH", mbo.UserDetail_Backbtn,driver))
			{
				WebElement Backbtn=driver.findElement(By.xpath(mbo.UserDetail_Backbtn));
				repfn.FnUpdateTestStepResHTML("Verify Back button is present ","Back button is present","PASS",runManagerInfoObj);
				if(cnf.JSClick(Backbtn,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify Back button is clicked ","Back button is clicked","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Back button is clicked ","Back button is not clicked","FAIL",runManagerInfoObj);
					blnFlag=false;
				} 
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify Back button is present ","Back button is not  present","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		catch (Exception e)

		{
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			repfn.FnUpdateTestStepResHTML("Verify in  User details window  edit button,back button,VoiceService Label,Role Label and UserDetail Label are displayed ","In User details window edit button,back button,VoiceService Label,Role Label and UserDetail Label are not  displayed due to some exceptions","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	public synchronized boolean FNEditUserUserCheck_Admin(WebDriver driver, RunManagerInfo runManagerInfoObj){
		try{
			//UserDetail Label
			if(cnf.FnExplicitWait("XPATH", mbo.EditMode_UsrDetails,driver)){
				WebElement EditMode_UsrDetails=driver.findElement(By.xpath(mbo.EditMode_UsrDetails));
				repfn.FnUpdateTestStepResHTML("Verify if the User Details label is displayed  ","User Details label is displayed","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify if the User Details label is displayed  ","User Details label is not  displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

			//SaveResetButton
			if(cnf.FnExplicitWait("XPATH", mbo.EditMode_SaveResetPassWordBtn,driver)){
				WebElement SaveResetPassWordBtn=driver.findElement(By.xpath(mbo.EditMode_SaveResetPassWordBtn));
				repfn.FnUpdateTestStepResHTML("Verify Send Reset Password Link is displayed ","Send Reset Password Link is displayed","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Send Reset Password Link is displayed ","Send Reset Password Link is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

			//EditMode_UserDetailsInfoLabel
			if(cnf.FnExplicitWait("XPATH", mbo.EditMode_UserDetailsInfo,driver)){
				WebElement EditMode_UserDetailsInfo=driver.findElement(By.xpath(mbo.EditMode_UserDetailsInfo));
				repfn.FnUpdateTestStepResHTML("Verify if the User Details Information label is displayed  ","User Details Information label is displayed","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify if the User Details Information label is displayed  ","User Details Information label is not  displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}


			//EditMode_FirstNameLabel
			if(cnf.FnExplicitWait("XPATH", mbo.EditMode_FirstNameLabel,driver)){
				WebElement EditMode_FirstNameLabel=driver.findElement(By.xpath(mbo.EditMode_FirstNameLabel));
				//cnf.ScrollToView(EditMode_FirstNameLabel);
				repfn.FnUpdateTestStepResHTML("Verify First name Label is displayed ","First name Label  is displayed","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify First name Label  is displayed ","First name Label  is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

			//EditMode_firstName
			if(cnf.FnExplicitWait("XPATH", mbo.EditMode_firstName,driver)){
				WebElement EditMode_firstName=driver.findElement(By.xpath(mbo.EditMode_firstName));	
				repfn.FnUpdateTestStepResHTML("Verify Verify if the First name field is displayed ","First name field is displayed and editable","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Verify if the First name field is displayed ","First name field is  not displayed and  not editable","FAIL",runManagerInfoObj);
				blnFlag=false;
			}


			//EditMode_LastNameLabel
			if(cnf.FnExplicitWait("XPATH", mbo.EditMode_LastNameLabel,driver)){
				WebElement EditMode_LastNameLabel=driver.findElement(By.xpath(mbo.EditMode_LastNameLabel));
				repfn.FnUpdateTestStepResHTML("Verify Last name Label is displayed ","Last name Label is displayed","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Last name Label is displayed ","Last name Label is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

			//EditMode_LastName
			if(cnf.FnExplicitWait("XPATH", mbo.EditMode_LastName,driver )){
				WebElement EditMode_LastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
				repfn.FnUpdateTestStepResHTML(" Verify if the Last name field is displayed ","Last name field is displayed and editable","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML(" Verify if the Last name field is displayed ","Last name field is  not displayed and  not editable","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

			//EditMode_PhoneLabel
			if(cnf.FnExplicitWait("XPATH", mbo.EditMode_PhoneLabel ,driver)){
				WebElement EditMode_PhoneLabel=driver.findElement(By.xpath(mbo.EditMode_PhoneLabel));
				//cnf.ScrollToView(EditMode_PhoneLabel);
				repfn.FnUpdateTestStepResHTML("Verify Phone Number Label is displayed ","Phone Number Label is displayed","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Phone Number Label is displayed ","Phone Number Label is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

			//EditMode_PhoneNumber
			if(cnf.FnExplicitWait("XPATH", mbo.EditMode_PhoneNumber ,driver)){
				WebElement EditMode_PhoneNumber=driver.findElement(By.xpath(mbo.EditMode_PhoneNumber));
				repfn.FnUpdateTestStepResHTML(" Verify if the Phone Number field is displayed ","Phone Number is  field  displayed and   editable","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML(" Verify if the Phone Number field is displayed ","Phone Number is field  is not   displayed and   not  editable","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

			// EditMode_EmailLabel
			if(cnf.FnExplicitWait("XPATH", mbo.EditMode_EmailLabel,driver)){

				WebElement  EditMode_EmailLabel=driver.findElement(By.xpath(mbo. EditMode_EmailLabel));
				repfn.FnUpdateTestStepResHTML("Verify  Email Address Label is displayed "," Email Address Label is displayed","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify  Email Address Label is displayed "," Email Address Label is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

			//EditMode_EmailId
			if(cnf.FnExplicitWait("XPATH", mbo.EditMode_EmailId,driver )){

				WebElement EditMode_EmailId=driver.findElement(By.xpath(mbo.EditMode_EmailId));
				repfn.FnUpdateTestStepResHTML(" Verify if the Email Address field is displayed ","Email Address  field  is  displayed and    editable","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML(" Verify if the Email Address field is displayed ","Email Address  field  is not   displayed and   not  editable","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

			//EditMode_UsrRoleLabel
			if(cnf.FnExplicitWait("XPATH", mbo.EditMode_UsrRoleLabel,driver)){

				WebElement  EditMode_UsrRoleLabel=driver.findElement(By.xpath(mbo.EditMode_UsrRoleLabel));
				//cnf.ScrollToView(EditMode_UsrRoleLabel);
				repfn.FnUpdateTestStepResHTML("Verify  Role Label is displayed  "," Role Label is displayed","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify  Role Label is displayed "," Role Label is  not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

			//EditMode_UserRoleDefault

			if(cnf.FnExplicitWait("XPATH", mbo.EditMode_UserRoleDefault,driver)){
				WebElement EditMode_UserRoleDefault=driver.findElement(By.xpath(mbo.EditMode_UserRoleDefault));			
				cnf.ElementClick(EditMode_UserRoleDefault,driver); 
				repfn.FnUpdateTestStepResHTML("Verify User Role dropdown  is displayed and  clicked ","User Role dropdown is displayed and  clicked","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify User Role dropdown is displayed and  clicked ","User Role dropdown is  not displayed and not clicked","FAIL",runManagerInfoObj);
				blnFlag=false;

			}

			//EditMode_AdminRole 
			if(cnf.FnExplicitWait("XPATH", mbo.EditMode_AdminRole,driver)){
				WebElement  EditMode_AdminRole =driver.findElement(By.xpath(mbo.EditMode_AdminRole ));			
				// cnf.ElementClick(EditMode_AdminRole);
				repfn.FnUpdateTestStepResHTML("Verify Administrator Role  is displayed in the dropdown ","Administrator Role  is displayed in the dropdown  ","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify  Administrator Role  is displayed in the dropdown "," Administrator Role  is  not displayed in the dropdown","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

			//EditMode_BillingTrans_role
/*			if(cnf.FnExplicitWait("XPATH", mbo.EditMode_BillingTrans_role)){
				WebElement EditMode_BillingTrans_role =driver.findElement(By.xpath(mbo.EditMode_BillingTrans_role ));
				repfn.FnUpdateTestStepResHTML("Verify Billing and Transaction Role  is displayed in the dropdown "," Billing and Transaction Role  is displayed in the dropdown","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Billing and Transaction Role  is displayed in the dropdown "," Billing and Transaction Role  is not displayed in the dropdown","FAIL",runManagerInfoObj);
				blnFlag=false;
			}*/

			//EditMode_standardRole
			if(cnf.FnExplicitWait("XPATH", mbo.EditMode_standardRole,driver)){
				WebElement EditMode_standardRole =driver.findElement(By.xpath(mbo.EditMode_standardRole ));
				repfn.FnUpdateTestStepResHTML("Verify Standard Role  is displayed in the dropdown ","Standard Role  is displayed in the dropdown","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Standard Role  is displayed in the dropdown "," Standard Role  is not displayed in the dropdown","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
			
			if(cnf.FnExplicitWait("XPATH", mbo.EditMode_UserRoleDefault,driver)){
				WebElement EditMode_UserRoleDefault=driver.findElement(By.xpath(mbo.EditMode_UserRoleDefault));			
				cnf.ScrollToView(EditMode_UserRoleDefault,driver);
				cnf.JSClick(EditMode_UserRoleDefault,driver);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify User Role dropdown is displayed","User Role dropdown is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

			if(voiceService){
				if(cnf.FnExplicitWait("XPATH", mbo.EditMode_VoiceService ,driver)){
					WebElement EditMode_VoiceService =driver.findElement(By.xpath(mbo.EditMode_VoiceService ));
					cnf.ScrollToView(EditMode_VoiceService,driver);
					repfn.FnUpdateTestStepResHTML("Verify VoiceService Label is displayed "," VoiceService Label is displayed","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify  VoiceService Label  is displayed "," VoiceService Label is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				//EditMode_AddVoiceLineBtn
				if(cnf.FnExplicitWait("XPATH", mbo.EditMode_AddVoiceLineBtn,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Add VoiceLine Link  is displayed "," Add VoiceLine Link is displayed","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					if(cnf.FnExplicitWait("XPATH", mbo.EditMode_NoVoiceLineMsg,driver)){
						WebElement EditMode_NoVoiceLineMsg =driver.findElement(By.xpath(mbo.EditMode_NoVoiceLineMsg ));
						repfn.FnUpdateTestStepResHTML("Verify Add VoiceLine Link  is displayed "," Add VoiceLine Link is not displayed. No phone lines are available. Warning message is displayed: "+EditMode_NoVoiceLineMsg.getText(),"PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify  Add VoiceLine Link  is displayed "," Add VoiceLine Link is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Voice Service is not assigned to User"," Voice Service is not assigned to User","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			//EditMode_VoiceService

			
			//EditMode_DeleteLink
			if(cnf.FnExplicitWait("XPATH", mbo.EditMode_DeleteLink,driver )){			
				repfn.FnUpdateTestStepResHTML("Verify Delete Link  is displayed "," Delete Link is displayed","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify  Delete Link   is displayed "," Delete Link  is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}


			//EditMode_SaveButton
			if(cnf.FnExplicitWait("XPATH", mbo.EditMode_SaveButton,driver )){
				repfn.FnUpdateTestStepResHTML("Verify Save Button  is displayed "," Save Button is displayed","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify  Save Button  is displayed "," Save Button  is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}


			driver.manage().window().setSize(new Dimension(100, 100));
			driver.manage().window().maximize();
			//EditMode_CancelBtn

			if(cnf.FnExplicitWait("XPATH", mbo.EditMode_CancelBtn ,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Cancel Button  is displayed "," Cancel Button is displayed","PASS",runManagerInfoObj);
				WebElement EditMode_CancelBtn=driver.findElement(By.xpath(mbo.EditMode_CancelBtn));

				if(cnf.JSClick(EditMode_CancelBtn,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Cancel Button is clicked ","Cancel Button is clicked","PASS",runManagerInfoObj);
					blnFlag=true;
					Thread.sleep(1000);
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Cancel Button is clicked ","Cancel Button is not clicked","FAIL",runManagerInfoObj);
					blnFlag=false;
					Thread.sleep(1000);
				}				
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Cancel Button is displayed "," Cancel Button is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

			//back button

			if(cnf.FnExplicitWait("XPATH", mbo.UserDetail_Backbtn,driver )){
				repfn.FnUpdateTestStepResHTML("Verify Back Button  is displayed "," Back Button is displayed","PASS",runManagerInfoObj);
				WebElement Backbtn=driver.findElement(By.xpath(mbo.UserDetail_Backbtn));

				if(cnf.JSClick(Backbtn,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Back Button is clicked ","Back Button is clicked","PASS",runManagerInfoObj);
					blnFlag=true;
					Thread.sleep(1000);
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Back Button is clicked ","Back Button is not clicked","FAIL",runManagerInfoObj);
					blnFlag=false;
					Thread.sleep(1000);
				}	
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Back Button is displayed "," Back Button is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

		}

		catch (Exception e)
		{
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			repfn.FnUpdateTestStepResHTML("Verify the UI and all buttons for admin contact is displayed","The UI and all button for admin contact is not dispayed due to some exception ","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
public synchronized boolean FNEditUserUSer_Admin(WebDriver driver, RunManagerInfo runManagerInfoObj) {
		
		try {
			// Login Using account with admin
			if (cnf.FnExplicitWait("XPATH", mbo.User_RoleList,driver)) {
				List<WebElement> User_RoleList = driver.findElements(By.xpath(mbo.User_RoleList));
				repfn.FnUpdateTestStepResHTML("Verify the presence of role list","Role list is present", "PASS",runManagerInfoObj);
				List <WebElement> SavedCallLogDetail=new ArrayList();
				outerloop:
				for (int i = 0; i <= User_RoleList.size(); i++) {
					System.out.println(User_RoleList.get(i).getText());
					if (User_RoleList.get(i).getText().contains("Standard")|| User_RoleList.get(i).getText().contains("Billing")) {
						if (cnf.JSClick(User_RoleList.get(i),driver)) {
							blnFlag = true;
							break outerloop;
						} else {
							blnFlag = false;
						}
					} else {
						blnFlag = false;
					}
				}

				if(blnFlag){
					if (cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)) {
						repfn.FnUpdateTestStepResHTML("Verify User details window is displayed ","The user details window for the selected user is displayed","PASS",runManagerInfoObj);
						
						if(cnf.FnExplicitWait("XPATH", mbo.UserDetail_VoiceServiceLabel,driver))
						{
							repfn.FnUpdateTestStepResHTML("Verify VoiceService Label is displayed in the User details window "," VoiceService Label is displayed in the User details window","PASS",runManagerInfoObj);
							blnFlag=true;
							voiceService = true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Voice Service is not assigned to User"," Voice Service is not assigned to User","PASS",runManagerInfoObj);
							blnFlag=true;
							voiceService = false;
						}
						
						if (cnf.FnExplicitWait("XPATH", mbo.UserDetail_EditBtn,driver)) {
							repfn.FnUpdateTestStepResHTML("Verify Edit button is displayed "," Edit button is displayed", "PASS",runManagerInfoObj);
							WebElement Editbtn = driver.findElement(By.xpath(mbo.UserDetail_EditBtn));
							if (cnf.JSClick(Editbtn,driver)) {
								repfn.FnUpdateTestStepResHTML("Verify if the Edit link is clicked "," Edit link is clicked", "PASS",runManagerInfoObj);
								if (cnf.FnExplicitWait("XPATH", mbo.EditModeForm,driver)) {
									repfn.FnUpdateTestStepResHTML("Verify Edit Form is displayed","Edit Form is displayed","PASS",runManagerInfoObj);
									blnFlag = true;
									Thread.sleep(1000);

								} else {
									repfn.FnUpdateTestStepResHTML("Verify Edit Form is displayed","Edit Form is not displayed","FAIL",runManagerInfoObj);
									blnFlag = false;
								}
							} else {
								repfn.FnUpdateTestStepResHTML("Verify if the Edit link is clicked "," Edit link is not clicked","FAIL",runManagerInfoObj);
								blnFlag = false;
							}
						} else {
							repfn.FnUpdateTestStepResHTML("Verify Edit button is displayed "," Edit button is not displayed", "FAIL",runManagerInfoObj);
							blnFlag = false;
						}
						
					} else {
						repfn.FnUpdateTestStepResHTML("Verify User details window is displayed ","The user details window for the selected user is  not displayed","FAIL",runManagerInfoObj);
						blnFlag = false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Check whether Admin/Billing/Standard User is displayed and clicked","Admin/Billing/Standard User is not displayed and clicked. There is no Admin/Billing/Standard User in the Users List","PASS",runManagerInfoObj);
					boolean blnFlag1 = app.FN_addNewUserClick(driver,runManagerInfoObj);
					if(blnFlag1){
						boolean blnFlag2 = app.FNEnteringData_FN_LN_Email_phone(driver,runManagerInfoObj);
						if(blnFlag2){
							boolean blnFlag3 = app.FnNextbuttonClick(driver,runManagerInfoObj);
							if(blnFlag3){
								boolean blnFlag4 = app.FN_StandardPermissionclick(driver,runManagerInfoObj);
								if(blnFlag4){
									boolean blnFlag5 =app.FnNextbuttonClick(driver,runManagerInfoObj);
									if(blnFlag5){
										boolean tab = app.FnCheckVoiceTab(driver,runManagerInfoObj);
										if(tab){
											boolean blnFlag6 = app.fnManageVoice(driver,runManagerInfoObj);
											if(blnFlag6){
												boolean blnFlag7 = app.FnConfirmbuttonClick(driver,runManagerInfoObj);
												if(blnFlag7){
													 repfn.FnUpdateTestStepResHTML("Verify Confirm button is displayed and Clicked. New user is added","Confirm button is displayed and Clicked.New user is added","PASS",runManagerInfoObj);
													 boolean blnFlag8 = FNEditUserUSer_Admin(driver,runManagerInfoObj);
													 if(blnFlag8){
														 blnFlag=true;
													 }
													 else{
														 repfn.FnUpdateTestStepResHTML("Verify Edit Form is displayed for newly added User","Edit Form is not displayed for newly added User","FAIL",runManagerInfoObj);
														 blnFlag = false;
													 }
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify Confirm button is displayed and Clicked ","Confirm button is not displayed and Clicked","FAIL",runManagerInfoObj);
													blnFlag=false;
												}
											}
											else{
												blnFlag=false;
												repfn.FnUpdateTestStepResHTML("Verify that the Account Owner/ Administrator user is able to add a new Voice line", "Account Owner/ Administrator user is not able to add a new Voice line", "FAIL",runManagerInfoObj);
											}
										}
										else{
											boolean blnFlag9 = app.FnConfirmbuttonClick(driver,runManagerInfoObj);
											if(blnFlag9){
												 repfn.FnUpdateTestStepResHTML("Verify Confirm button is displayed and Clicked. New user is added","Confirm button is displayed and Clicked.New user is added","PASS",runManagerInfoObj);
												 boolean blnFlag10 = FNEditUserUSer_Admin(driver,runManagerInfoObj);
												 if(blnFlag10){
													 blnFlag=true;
												 }
												 else{
													 repfn.FnUpdateTestStepResHTML("Verify Edit Form is displayed for newly added User","Edit Form is not displayed for newly added User","FAIL",runManagerInfoObj);
													 blnFlag = false;
												 }
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify Confirm button is displayed and Clicked ","Confirm button is not displayed and Clicked","FAIL",runManagerInfoObj);
												blnFlag=false;
											}
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Next button is displayed and Clicked ","Next button is not displayed and Clicked","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Standard User Radio button is displayed and clicked", "Standard User Radio button is not displayed and clicked","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Next button is displayed and Clicked ","Next button is not displayed and Clicked","FAIL",runManagerInfoObj);
								blnFlag=false;
							}							
						}
						else{
							 repfn.FnUpdateTestStepResHTML("Verify User is able to enter FirstName,LastName,Email address and Phonenumber ","User is  not able to enter FirstName,LastName,Email address and Phonenumber","FAIL",runManagerInfoObj);
							 blnFlag=false;
						}
					}
					else{
						 repfn.FnUpdateTestStepResHTML("Verify Add New User Link is displayed and Clicked ","Add New User Link is not displayed and Clicked","FAIL",runManagerInfoObj);
						 blnFlag=false;
					}
				}
			} else {
				repfn.FnUpdateTestStepResHTML("Verify the presence of role list","Role list is not present", "FAIL",runManagerInfoObj);
				blnFlag = false;
			}
		}

		catch (Exception e)
		{
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnUpdateTestStepResHTML("Verify User is able to edit information of Admin/Billing/Standard User","User is not able to edit information of Admin/Billing/Standard User  due to some exception","FAIL",runManagerInfoObj);
			blnFlag = false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	

	public synchronized boolean FnUserRoleListVerification(WebDriver driver, RunManagerInfo runManagerInfoObj){
		try{
			if(cnf.FnExplicitWait("XPATH", mbo.Manage_UserRolesLabel,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify Role Label is present ","Role Label is present","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify Role Label is present ","Role Label is not present","PASS",runManagerInfoObj);
				blnFlag=false;
			}

			if(cnf.FnExplicitWait("XPATH", mbo.User_RoleList,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify Role section is present ","Role section is present","PASS",runManagerInfoObj);

				List<WebElement> User_RoleList=driver.findElements(By.xpath(mbo.User_RoleList));
				for(int y=0;y<User_RoleList.size();y++)
				{
					rolelist.add(User_RoleList.get(y).getText());
					repfn.FnUpdateTestStepResHTML("Verify if the Role section is displayed for each user ","The Role displayed for the user: "+" "+namelist.get(y).toString()+" as:"+" "+User_RoleList.get(y).getText(),"PASS",runManagerInfoObj);
					blnFlag=true;
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify Role section is present ","Role section is not present","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

		}
		catch (Exception e)

		{
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			repfn.FnUpdateTestStepResHTML("Verify Role label and Role section is displayed for a user are  displayed ","Role label and Role section are not  displayed for a user due to some exception","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	public synchronized boolean FnUserServiceListVerification(WebDriver driver, RunManagerInfo runManagerInfoObj){
		try{
			if(cnf.FnExplicitWait("XPATH", mbo.Manage_UserServiceLabel,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify Service Label is present ","Service Label is present","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify Service Label is present ","Service Label is not present","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
			if(cnf.FnExplicitWait("XPATH", mbo.User_ServiceList,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify Service section is present ","Service section is present","PASS",runManagerInfoObj);

				List<WebElement> User_ServiceList=driver.findElements(By.xpath(mbo.User_ServiceList));
				for(int p=0;p<User_ServiceList.size();p++)
				{
					servicelist.add(User_ServiceList.get(p).getText());
					repfn.FnUpdateTestStepResHTML("Verify Service Section is displayed for a user ","Service Section displayed for a user"+" "+namelist.get(p).toString()+" is:"+" "+User_ServiceList.get(p).getText(),"PASS",runManagerInfoObj);
					blnFlag=true;
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify Service section is present ","Service section is not present","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

		}
		catch (Exception e)

		{
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			repfn.FnUpdateTestStepResHTML("Verify Service Section and Service Label are displayed for a user ","Service Section and Service Label are not  displayed for a user due to some exception","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}


	public synchronized boolean FnUserNameListVerification(WebDriver driver, RunManagerInfo runManagerInfoObj){
		try{
			if(cnf.FnExplicitWait("XPATH", mbo.Manage_UserNameLabel,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify the User name label is present", "Username label is present", "PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify the User name label is present", "Username label is not present", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
			
			if(cnf.FnExplicitWait("XPATH", mbo.User_NameList,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify the User name list is present", "Username list is present", "PASS",runManagerInfoObj);
				List<WebElement> User_NameList=driver.findElements(By.xpath(mbo.User_NameList));
				for(int i=0;i<User_NameList.size();i++)
				{
					namelist.add(User_NameList.get(i).getText());
					repfn.FnUpdateTestStepResHTML("Verify the user list display on the Manage users page ","List of all users associated to the account is displayed as: "+" "+User_NameList.get(i).getText(),"PASS",runManagerInfoObj);
					blnFlag=true;
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify the User name list is present", "Username list is not present", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		catch (Exception e)

		{
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			repfn.FnUpdateTestStepResHTML("Verify User Name is dispalyed as List and Name Label are  displayed ","User Name is  not dispalyed as List and Name Label are  not  displayed due to some exception","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	public synchronized boolean FnUSerDetailLinkPopup(WebDriver driver, RunManagerInfo runManagerInfoObj){
		try{
			
			if(cnf.FnExplicitWait("XPATH", mbo.Arrow_DetailLink_User,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify the presence of arrow link to access more details for each user", "Arrow link is displayed to access more details for each user", "PASS",runManagerInfoObj);

				List<WebElement> UserDetailsArrow=driver.findElements(By.xpath(mbo.Arrow_DetailLink_User));
				if(UserDetailsArrow.get(0).isDisplayed()){
					repfn.FnUpdateTestStepResHTML("Verify the presence of arrow link for the first user", "Arrow link is present for the first user", "PASS",runManagerInfoObj);
					if(cnf.JSClick(UserDetailsArrow.get(0),driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify Arrow_DetailLink is clicked ","Arrow_DetailLink is clicked ","PASS",runManagerInfoObj);
						// WebElement UserDetailpopup=driver.findElement(By.xpath(mbo.UserDetailpopup));
						if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
							repfn.FnUpdateTestStepResHTML("Verify User details window is displayed ","User details window is displayed","PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("XPATH", mbo.UserDetail_MailId,driver))
							{
								WebElement mailid=driver.findElement(By.xpath(mbo.UserDetail_MailId));
								repfn.FnUpdateTestStepResHTML("Verify the presence of further detail in user details window", "Further detail present in user details window is"+" "+mailid.getText(), "PASS",runManagerInfoObj);
								if(cnf.FnExplicitWait("XPATH", mbo.UserDetail_Backbtn,driver))
								{
									WebElement Backbtn=driver.findElement(By.xpath(mbo.UserDetail_Backbtn));
									repfn.FnUpdateTestStepResHTML("Verify the presence of back/close button in user details window", "Back/close button is present in user details window", "PASS",runManagerInfoObj);
									if(cnf.JSClick(Backbtn,driver))
									{
										Thread.sleep(1000);
										repfn.FnUpdateTestStepResHTML("Verify Back button is clicked","Back button is clicked","PASS",runManagerInfoObj);
										if(!cnf.FnExplicitWait("XPATH",mbo.UserDetailpopup,driver))
										{
											repfn.FnUpdateTestStepResHTML("Verify User details window is not displayed after clicking Back button","UserDetailpopup is displayed after clicking Back button","PASS",runManagerInfoObj);
											blnFlag=true;
										}
										else
										{
											repfn.FnUpdateTestStepResHTML("Verify User details window is not displayed after clicking Back button","UserDetailpopup is displayed after clicking Back button","FAIL",runManagerInfoObj);
											blnFlag=false;
										} 
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Back button is clicked ","Back button is not clicked","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else
								{
									repfn.FnUpdateTestStepResHTML("Verify the presence of back/close button in user details window", "Back/close button is not present in user details window", "FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of further detail in user details window", "Further detail is not present in user details window", "FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User details window is displayed ","User details window is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Arrow_DetailLink is Clicked ","Arrow_DetailLink is not  Clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of arrow link for the first user", "Arrow link is not present for the first user", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify the presence of arrow link to access more details for each user", "Arrow link is not displayed to access more details for each user", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}

		}
		catch (Exception e)

		{
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			repfn.FnUpdateTestStepResHTML("Verify User details window is displayed ","User details window is not displayed due to some exception","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	public synchronized boolean FnSelectUser(WebDriver driver, RunManagerInfo runManagerInfoObj){
		try{

			// Login Using account with admin
			if (cnf.FnExplicitWait("XPATH", mbo.User_RoleList,driver)) {
				List<WebElement> User_RoleList = driver.findElements(By.xpath(mbo.User_RoleList));
				repfn.FnUpdateTestStepResHTML("Verify the presence of role list","Role list is present", "PASS",runManagerInfoObj);
				outerloop:
				for (int i = 0; i <= User_RoleList.size(); i++) {
					if (User_RoleList.get(i).getText().contains("Standard")|| User_RoleList.get(i).getText().contains("Billing")|| User_RoleList.get(i).getText().contains("Admin")) {
						if(cnf.FnExplicitWait("XPATH", mbo.User_ServiceList,driver)){
							List<WebElement> User_ServiceList = driver.findElements(By.xpath(mbo.User_ServiceList));
							for (int j = 0; j <= User_ServiceList.size(); j++) {
								if(!(User_ServiceList.get(j).getText().contains("--"))){
									if (cnf.JSClick(User_ServiceList.get(j),driver)) {
										blnFlag = true;
										break outerloop;
									} else {
										blnFlag = false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Admin/Billing/Standard User is not displayed with Voice Service assigned","Admin/Billing/Standard User is not displayed with Voice Service assigned","PASS",runManagerInfoObj);
									if(cnf.JSClick(User_ServiceList.get(j),driver)) {
										blnFlag = true;
										voiceService = false;
										break outerloop;
									} else {
										blnFlag = false;
									}									
								}
							}
						}
						else{
							blnFlag = false;
						}
					} else {
						repfn.FnUpdateTestStepResHTML("Verify Admin/Billing/Standard User is displayed","Admin/Billing/Standard User is not displayed","FAIL",runManagerInfoObj);
						blnFlag = false;
					}
				}
				
				if(blnFlag){
					if (cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)) {
						repfn.FnUpdateTestStepResHTML("Verify User details window is displayed ","The user details window for the selected user is displayed","PASS",runManagerInfoObj);
						blnFlag = true;					
					} else {
						repfn.FnUpdateTestStepResHTML("Verify User details window is displayed ","The user details window for the selected user is  not displayed","FAIL",runManagerInfoObj);
						blnFlag = false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Check whether Admin/Billing/Standard User is displayed and clicked","Admin/Billing/Standard User is not displayed and clicked","FAIL",runManagerInfoObj);
					blnFlag = false;
				}
			} else {
				repfn.FnUpdateTestStepResHTML("Verify the presence of role list","Role list is not present", "FAIL",runManagerInfoObj);
				blnFlag = false;
			}		
		}
			
		catch (Exception e)
		{
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			repfn.FnUpdateTestStepResHTML("Verify in  User details window  edit button,back button,VoiceService Label,Role Label and UserDetail Label are displayed ","In User details window edit button,back button,VoiceService Label,Role Label and UserDetail Label are not  displayed due to some exceptions","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	public synchronized boolean FnAdminRoleChange(WebDriver driver, RunManagerInfo runManagerInfoObj) {
		try {

			// EditMode_UserRoleDefault

			if (cnf.FnExplicitWait("XPATH", mbo.EditMode_UserRoleDefault,driver)) {
				WebElement EditMode_UserRoleDefault = driver.findElement(By.xpath(mbo.EditMode_UserRoleDefault));
				repfn.FnUpdateTestStepResHTML("Verify User Role drop down is displayed","User Role drop down is displayed", "PASS",runManagerInfoObj);
				if(cnf.JSClick(EditMode_UserRoleDefault,driver)) {
					repfn.FnUpdateTestStepResHTML("Verify User Role drop down is clicked ","User Role drop down is clicked", "PASS",runManagerInfoObj);

					// EditMode_AdminRole
					if (cnf.FnExplicitWait("XPATH", mbo.EditMode_AdminRole,driver)) {
						WebElement EditMode_AdminRole = driver.findElement(By.xpath(mbo.EditMode_AdminRole));
						repfn.FnUpdateTestStepResHTML("Verify Administrator Role  is displayed in the dropdown ","Administrator Role  is displayed in the dropdown","PASS",runManagerInfoObj);
						blnFlag = true;
					} else {
						repfn.FnUpdateTestStepResHTML("Verify Administrator Role  is displayed in the dropdown ","Administrator Role  is  not displayed in the dropdown ","FAIL",runManagerInfoObj);
						blnFlag = false;
					}

					// EditMode_standardRole
					if (cnf.FnExplicitWait("XPATH", mbo.EditMode_standardRole,driver)) {
						WebElement EditMode_standardRole = driver.findElement(By.xpath(mbo.EditMode_standardRole));

						repfn.FnUpdateTestStepResHTML("Verify Standard Role  is displayed in the dropdown ","Standard Role  is displayed in the dropdown  ","PASS",runManagerInfoObj);
						blnFlag = true;
					} else {
						repfn.FnUpdateTestStepResHTML("Verify Standard Role  is displayed in the dropdown ","Standard Role  is  not displayed in the dropdown  ","FAIL",runManagerInfoObj);
						blnFlag = false;
					}

					// EditMode_BillingTrans_role
					if (cnf.FnExplicitWait("XPATH", mbo.EditMode_AdminRole,driver)) {
						WebElement EditMode_AdminRole = driver.findElement(By.xpath(mbo.EditMode_AdminRole));
						repfn.FnUpdateTestStepResHTML("Verify Administrator Role  is displayed in the dropdown "," Administrator Role  is displayed in the dropdown","PASS",runManagerInfoObj);

						if(cnf.JSClick(EditMode_AdminRole,driver)) {
							repfn.FnUpdateTestStepResHTML("Verify Administrator Role  is clicked in the dropdown "," Administrator Role  is Clicked in the dropdown","PASS",runManagerInfoObj);
							Thread.sleep(1000);

							driver.manage().window().setSize(new Dimension(100, 100));
							driver.manage().window().maximize();
							// EditMode_SaveButton
							if (cnf.FnExplicitWait("XPATH", mbo.EditMode_SaveButton,driver)) {
								WebElement EditMode_SaveButton = driver.findElement(By.xpath(mbo.EditMode_SaveButton));
								repfn.FnUpdateTestStepResHTML("Verify the presence of Save button","Save button is present", "PASS",runManagerInfoObj);
								if (EditMode_SaveButton.isEnabled()) {
									repfn.FnUpdateTestStepResHTML("Verify Save Button  is enabled "," Save Button is enabled", "PASS",runManagerInfoObj);

									if (cnf.JSClick(EditMode_SaveButton,driver)) {
										repfn.FnUpdateTestStepResHTML("Verify Save Button  is clicked "," Save Button is clicked", "PASS",runManagerInfoObj);

										if(cnf.FnExplicitWait("XPATH", mbo.SaveNotWorkingText,driver)){
											repfn.FnUpdateTestStepResHTML("Verify Save functionality working or not","Save functionality not working","FAIL",runManagerInfoObj);
											blnFlag=false;
											if(cnf.FnExplicitWaitFeedback("XPATH", mbo.Cancel_Button,driver))
											{
												WebElement close=driver.findElement(By.xpath(mbo.Cancel_Button));
												if(cnf.JSClick(close,driver)){
													repfn.FnUpdateTestStepResHTML("Verify Cancel button is clicked","Cancel button is clicked","PASS",runManagerInfoObj);
													blnFlag=false;
													Thread.sleep(2000);
													WebElement Confrm=driver.findElement(By.xpath(mbo.Confirm_btn));
													System.out.println("click aftr save not working");
													if(cnf.JSClick(Confrm,driver))
													{
														repfn.FnUpdateTestStepResHTML("Verify Confirm button is clicked","Confirm button is clicked","PASS",runManagerInfoObj);
														Thread.sleep(2000);
														driver.navigate().refresh();
														Thread.sleep(2000);
														//repfn.FnUpdateTestStepResHTML("Verify User is moved back to contacts page","User is moved back to contacts page","PASS",runManagerInfoObj);
														blnFlag=false;
													}
													else{
														repfn.FnUpdateTestStepResHTML("Verify Confirm button is clicked","Confirm button is not clicked","FAIL",runManagerInfoObj);
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
										else{
											if (cnf.FnExplicitWait("XPATH", mbo.UserDetail_Role,driver)) {
												WebElement RoleAfterChange = driver.findElement(By.xpath(mbo.UserDetail_Role));
												repfn.FnUpdateTestStepResHTML("Verify the presence of user role","User role is present", "PASS",runManagerInfoObj);
												String RoleAfterChanging = RoleAfterChange.getText();
												System.out.println("Role" + RoleAfterChanging);
												if (RoleAfterChanging.contains("Administrator")) {
													repfn.FnUpdateTestStepResHTML("Verify Admin able to change the User Role"," Admin is able to change the User Role", "PASS",runManagerInfoObj);
													blnFlag = true;
												} else {
													repfn.FnUpdateTestStepResHTML("Verify Admin able to change the User Role"," Admin is not able to change the User Role","FAIL",runManagerInfoObj);
													blnFlag = false;
												}
											} else {
												repfn.FnUpdateTestStepResHTML("Verify the presence of user role","User role is present", "FAIL",runManagerInfoObj);
												blnFlag = false;
											}

											// back button

											if (cnf.FnExplicitWait("XPATH", mbo.UserDetail_Backbtn,driver)) {
												WebElement Backbtn = driver.findElement(By.xpath(mbo.UserDetail_Backbtn));
												repfn.FnUpdateTestStepResHTML("Verify the presence of back button","Back button is present", "PASS",runManagerInfoObj);

												if (cnf.JSClick(Backbtn,driver)) {
													repfn.FnUpdateTestStepResHTML("Verify Back button is clicked ","Back button is clicked", "PASS",runManagerInfoObj);
													blnFlag = true;
													Thread.sleep(1000);
												} else {
													repfn.FnUpdateTestStepResHTML("Verify Back button is clicked ","Back button is not clicked", "FAIL",runManagerInfoObj);
													blnFlag = false;
												}
											} else {
												repfn.FnUpdateTestStepResHTML("Verify the presence of back button","Back button is not present", "FAIL",runManagerInfoObj);
												blnFlag = false;
											}
										}
									}
									else {
										repfn.FnUpdateTestStepResHTML("Verify Save Button  is clicked "," Save Button is not clicked", "FAIL",runManagerInfoObj);
										blnFlag = false;
									}

								} else {
									repfn.FnUpdateTestStepResHTML("Verify  Save Button  is enabled "," Save Button  is disabled", "FAIL",runManagerInfoObj);
									blnFlag = false;
								}
							} else {
								repfn.FnUpdateTestStepResHTML("Verify the presence of Save button","Save button is not present", "FAIL",runManagerInfoObj);
								blnFlag = false;
							}
						}
						else {
							repfn.FnUpdateTestStepResHTML("Verify Administrator Role  is clicked in the dropdown "," Administrator Role  is  not Clicked in the dropdown","FAIL",runManagerInfoObj);
							blnFlag = false;
						}
					} else {
						repfn.FnUpdateTestStepResHTML("Verify Administrator Role  is displayed in the dropdown "," Administrator Role  is not displayed in the dropdown","FAIL",runManagerInfoObj);
						blnFlag = false;
					}
				} 
				else {
					repfn.FnUpdateTestStepResHTML("Verify User Role drop down is displayed","User Role drop down is not displayed ", "FAIL",runManagerInfoObj);
					blnFlag = false;
				}
			} else {
				repfn.FnUpdateTestStepResHTML("Verify User Role drop down is clicked ","User Role drop down is not clicked", "FAIL",runManagerInfoObj);
				blnFlag = false;
			}
		} 
		
		catch (Exception e)
		{
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnUpdateTestStepResHTML("Verify User is able to change the User Role"," User is not able to change the User Role due to some exception","FAIL",runManagerInfoObj);
			blnFlag = false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}

public synchronized boolean FnAdminUserNameChange(WebDriver driver, RunManagerInfo runManagerInfoObj) {
		
		try {

			if (cnf.FnExplicitWait("XPATH", mbo.EditMode_firstName,driver)) {
				WebElement EditMode_firstName = driver.findElement(By.xpath(mbo.EditMode_firstName));
				EditMode_firstName.clear();
				EditMode_firstName.sendKeys("Sankaran"+randomInt);
				repfn.FnUpdateTestStepResHTML("Verify First Name Field is displayed and editable","First Name Field is displayed and editable", "PASS",runManagerInfoObj);
				blnFlag = true;
			} else {
				repfn.FnUpdateTestStepResHTML("Verify First Name Field is displayed and editable","First Name Field is  not displayed and not editable","FAIL",runManagerInfoObj);
				blnFlag = false;
			}

			// EditMode_LastName
			if (cnf.FnExplicitWait("XPATH", mbo.EditMode_LastName,driver)) {
				WebElement EditMode_LastName = driver.findElement(By.xpath(mbo.EditMode_LastName));
				EditMode_LastName.clear();
				EditMode_LastName.sendKeys("Saranya");
				repfn.FnUpdateTestStepResHTML("Verify Last Name Field is displayed and editable","Last Name Field is displayed and editable", "PASS",runManagerInfoObj);
				blnFlag = true;
			} else {
				repfn.FnUpdateTestStepResHTML("Verify Last Name Field is displayed and editable ","Last Name Field is not  displayed and not editable","FAIL",runManagerInfoObj);
				blnFlag = false;
			}

			// EditMode_EmailId
			if (cnf.FnExplicitWait("XPATH", mbo.EditMode_EmailId,driver)) {
				WebElement EditMode_EmailId = driver.findElement(By.xpath(mbo.EditMode_EmailId));
				EditMode_EmailId.clear();
				EditMode_EmailId.sendKeys("Saranya"+randomInt+"@gmail.com");
				repfn.FnUpdateTestStepResHTML("Verify if the Email Address field is displayed and editable ","Email Address field is displayed and editable", "PASS",runManagerInfoObj);
				blnFlag = true;
			} 
			else {
				repfn.FnUpdateTestStepResHTML("Verify if the Email Address field is displayed and editable ","Email Address field is not displayed and not editable","FAIL",runManagerInfoObj);
				blnFlag = false;
			}

			driver.manage().window().setSize(new Dimension(100, 100));
			driver.manage().window().maximize();
			
			if(cnf.FnExplicitWait("XPATH", mbo.EditMode_SaveButton,driver)) {
				repfn.FnUpdateTestStepResHTML("Verify Save Button is displayed "," Save Button is displayed", "PASS",runManagerInfoObj);
				WebElement EditMode_SaveButton = driver.findElement(By.xpath(mbo.EditMode_SaveButton));
				if(EditMode_SaveButton.isEnabled()){
					repfn.FnUpdateTestStepResHTML("Verify Save Button is Enabled ","Save Button is Enabled","PASS",runManagerInfoObj);
					if(cnf.JSClick(EditMode_SaveButton,driver)) {
						repfn.FnUpdateTestStepResHTML("Verify Save Button is clicked ","Save Button is clicked","PASS",runManagerInfoObj);
						
						if(cnf.FnExplicitWait("XPATH", mbo.SaveNotWorkingText,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Save functionality working or not","Save functionality not working","FAIL",runManagerInfoObj);
							blnFlag=false;
							if(cnf.FnExplicitWaitFeedback("XPATH", mbo.Cancel_Button,driver))
							{
								WebElement close=driver.findElement(By.xpath(mbo.Cancel_Button));
								if(cnf.JSClick(close,driver)){
									repfn.FnUpdateTestStepResHTML("Verify Cancel button is clicked","Cancel button is clicked","PASS",runManagerInfoObj);
									blnFlag=false;
									Thread.sleep(2000);
									WebElement Confrm=driver.findElement(By.xpath(mbo.Confirm_btn));
									System.out.println("click aftr save not working");
									if(cnf.JSClick(Confrm,driver))
									{
										repfn.FnUpdateTestStepResHTML("Verify Confirm button is clicked","Confirm button is clicked","PASS",runManagerInfoObj);
										Thread.sleep(2000);
										driver.navigate().refresh();
										Thread.sleep(2000);
										//repfn.FnUpdateTestStepResHTML("Verify User is moved back to contacts page","User is moved back to contacts page","PASS",runManagerInfoObj);
										blnFlag=false;
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Confirm button is clicked","Confirm button is not clicked","FAIL",runManagerInfoObj);
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
						else{
							blnFlag=true;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Save Button is clicked ","Save Button is not clicked","FAIL",runManagerInfoObj);
						blnFlag = false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Save Button is Enabled ","Save Button is not Enabled","FAIL",runManagerInfoObj);
					blnFlag = false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Save Button is displayed "," Save Button is not displayed", "FAIL",runManagerInfoObj);
				blnFlag = false;
			}

		} 
		
		catch (Exception e)
		{
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnUpdateTestStepResHTML("Verify User is able to change Name and Email Id","User is not able to change Name and Email Id due to some exception ","FAIL",runManagerInfoObj);
			blnFlag = false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}

public synchronized boolean FnUserNameVerificationAfterChange(WebDriver driver, RunManagerInfo runManagerInfoObj) {
	try {

		if(cnf.FnExplicitWait("XPATH", mbo.UserNameAfterChange,driver)) {
			WebElement UserNameAfterChange = driver.findElement(By.xpath(mbo.UserNameAfterChange));
			repfn.FnUpdateTestStepResHTML("Verify the presence of Username","Username is present", "PASS",runManagerInfoObj);
			String UserNameAfterChanged = UserNameAfterChange.getText();
			System.out.println("Last and FirstName" + UserNameAfterChanged);

			if (UserNameAfterChanged.contains("Sankaran")) {
				repfn.FnUpdateTestStepResHTML("Verify User is able to change the User First Name and Last Name"," User is able to change the User First Name and Last Name","PASS",runManagerInfoObj);
				blnFlag = true;
			} else {
				repfn.FnUpdateTestStepResHTML("Verify User able to change the User First Name and Last Name"," User is not able to change the User First Name and Last Name","FAIL",runManagerInfoObj);
				blnFlag = false;
			}
		} 
		else {
			repfn.FnUpdateTestStepResHTML("Verify the presence of Username","Username is not present", "FAIL",runManagerInfoObj);
			blnFlag = false;
		}

		if (cnf.FnExplicitWait("XPATH", mbo.EmaiIdAfterChange,driver)) {
			WebElement EmaiIdAfterChange = driver.findElement(By.xpath(mbo.EmaiIdAfterChange));
			repfn.FnUpdateTestStepResHTML("Verify the presence of Email Id","Email ID is present", "PASS",runManagerInfoObj);
			String EmaiIdAfterChanged = EmaiIdAfterChange.getText();
			System.out.println("EmailId" + EmaiIdAfterChanged);

			if (EmaiIdAfterChanged.contains("Saranya")) {
				repfn.FnUpdateTestStepResHTML("Verify User able to change the User Email Id"," User is able to change the User Email Id","PASS",runManagerInfoObj);
				blnFlag = true;

			} 
			else {
				repfn.FnUpdateTestStepResHTML("Verify User able to change the User Email Id"," User is not able to change the Email Id", "FAIL",runManagerInfoObj);
				blnFlag = false;
			}
		} else {
			repfn.FnUpdateTestStepResHTML("Verify the presence of Email Id","Email ID is not present", "FAIL",runManagerInfoObj);
			blnFlag = false;
		}

		// back button

		if (cnf.FnExplicitWait("XPATH", mbo.UserDetail_Backbtn,driver)) {
			WebElement Backbtn = driver.findElement(By.xpath(mbo.UserDetail_Backbtn));
			repfn.FnUpdateTestStepResHTML("Verify the presence of back button","Back button is present", "PASS",runManagerInfoObj);
			if (cnf.JSClick(Backbtn,driver)) {
				repfn.FnUpdateTestStepResHTML("Verify Back button is clicked ","Back button is clicked", "PASS",runManagerInfoObj);
				blnFlag = true;
				Thread.sleep(1000);
			} else {
				repfn.FnUpdateTestStepResHTML("Verify Back button is clicked ","Back button is not clicked", "FAIL",runManagerInfoObj);
				blnFlag = false;
			}
		} else {
			repfn.FnUpdateTestStepResHTML("Verify the presence of back button","Back button is not present", "FAIL",runManagerInfoObj);
			blnFlag = false;
		}

	}

	catch (Exception e)
	{
		System.err.println("Message : " + e.getMessage());
		System.err.println("Cause : " + e.getCause());
		repfn.FnUpdateTestStepResHTML("Verify User is able to save the changes"," User is not able to save the changes due to some exception ","FAIL",runManagerInfoObj);
		blnFlag = false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}

public synchronized boolean FN_ManagerUserName_SortingA_Z(WebDriver driver, RunManagerInfo runManagerInfoObj){
	try{

		ArrayList<String> al = new ArrayList<String>();
		ArrayList<String> bl = new ArrayList<String>();

		if(cnf.FnExplicitWait("Xpath",mbo.User_NameList,driver)){
			repfn.FnUpdateTestStepResHTML(" Verify the user list display on the Manage users page. ","User should be able to view the list of all users associated to the account and each user in the list should be displayed in the following name format - 'first name last name'","PASS",runManagerInfoObj);
			List<WebElement> User_NameList=driver.findElements(By.xpath(mbo.User_NameList));
			for(WebElement we:User_NameList){

				String[] names = we.getText().split(" ");
				//splitting name and assigning to New List
				if(names.length > 1){
					al.add(names[names.length-1]);
				}
				else if(names.length == 1){
					al.add(" ");
				}

				System.out.println("Befort Sorting"+al);
				//Sorting in ascending order
				Collections.sort(al);

				System.out.println("After sorting"+al);
			}



			List<WebElement> User_NameList1=driver.findElements(By.xpath(mbo.User_NameList));
			Thread.sleep(3000);

			for(WebElement we1:User_NameList1){

				String[] names = we1.getText().split(" ");

				if(names.length > 1){
					bl.add(names[names.length-1]);
				}
				else if(names.length == 1){
					bl.add(" ");
				}

				System.out.println("Default Name List"+bl);
			}

			Thread.sleep(3000);
			// for(int i=0;i<=al.size();i++){
			//if(Contact_List.get(i).getText().contains(al.get(i))){
			//if(bl.get((bl.size())-1).equals(al.get((al.size())-1))){
			if(bl.equals(al)){
				//System.out.println("PASS",runManagerInfoObj+bl.get(i)+al.get(i));
				repfn.FnUpdateTestStepResHTML("Verify the default sorted display of the user list.","The user list displayed should be sorted by last name by default.","PASS",runManagerInfoObj);
				blnFlag=true;
				// break;
			}
			else{
				//System.out.println("FAIL",runManagerInfoObj+bl.get(i)+al.get(i));

				repfn.FnUpdateTestStepResHTML("Verify the default sorted display of the user list.","The user list displayed is not  sorted by last name by default.","FAIL",runManagerInfoObj);
				blnFlag=false;


			}
			//}

		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify the user list display on the Manage users page.","User should not be able to view the list of all users associated to the account and each user in the list should be displayed in the following name format - 'first name last name'","FAIL",runManagerInfoObj);
			blnFlag=false;
		}


	}
	catch (Exception e)

	{
		repfn.FnUpdateTestStepResHTML("Verify the default sorted display of the user list.","The user list displayed is not  sorted by last name by default due to some exception","FAIL",runManagerInfoObj);
		 blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}	
public synchronized boolean FNManageusers_EditandDeleteClick(WebDriver driver, RunManagerInfo runManagerInfoObj) {
	boolean blnFlag = false;
	String firstName=null;
	String lastName=null;
	String Search=null;
	try {
		if (cnf.FnExplicitWait("Xpath", mbo.UserDetail_EditBtn,driver)) {
			repfn.FnUpdateTestStepResHTML("Verify Edit button is displayed ","Edit button is displayed ", "PASS",runManagerInfoObj);
			WebElement UserDetail_EditBtn = driver.findElement(By.xpath(mbo.UserDetail_EditBtn));
			if (cnf.JSClick(UserDetail_EditBtn,driver)) {
				repfn.FnUpdateTestStepResHTML("Verify Edit button is clicked ","Edit button is clicked ", "PASS",runManagerInfoObj);
				Thread.sleep(2000);

				if (cnf.FnExplicitWait("XPATH", mbo.EditMode_firstName,driver)) {
					WebElement EditMode_firstName = driver.findElement(By.xpath(mbo.EditMode_firstName));
					repfn.FnUpdateTestStepResHTML("Verify First Name is displayed","First Name is displayed", "PASS",runManagerInfoObj);
					firstName = EditMode_firstName.getAttribute("value");
					blnFlag = true;
				} else {
					repfn.FnUpdateTestStepResHTML("Verify First Name is displayed","First Name is not displayed", "FAIL",runManagerInfoObj);
					blnFlag = false;
				}

				if (cnf.FnExplicitWait("XPATH", mbo.EditMode_LastName,driver)) {
					WebElement EditMode_LastName = driver.findElement(By.xpath(mbo.EditMode_LastName));
					repfn.FnUpdateTestStepResHTML("Verify Last Name is displayed","Last Name is displayed", "PASS",runManagerInfoObj);
					lastName = EditMode_LastName.getAttribute("value");
					blnFlag = true;
				} else {
					repfn.FnUpdateTestStepResHTML("Verify Last Name is displayed","Last Name is not displayed", "FAIL",runManagerInfoObj);
					blnFlag = false;
				}

				Search = firstName + " " + lastName;
				
				
				if(cnf.FnExplicitWait("Xpath", mbo.CloudwareAddOnsHeading,driver)){
					((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(mbo.CloudwareAddOnsHeading))); 
					
					if(cnf.FnExplicitWait("Xpath", mbo.CloudwareAddOnsButton,driver)){
						((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(mbo.CloudwareAddOnsButton)));
						blnFlag = true;
					}
					else{
						System.out.println("Cloudware Add on Button not present");
						blnFlag = false;
					}
				}
				else{
					System.out.println("Cloudware Add on Heading not present");
					blnFlag = false;
				}
				
				driver.manage().window().setSize(new Dimension(100, 100));
				driver.manage().window().maximize();
				
				if (cnf.FnExplicitWait("Xpath", mbo.EditMode_DeleteLink,driver)) {
					repfn.FnUpdateTestStepResHTML("Verify if Delete User Option is getting displayed","Delete User Option is getting displayed","PASS",runManagerInfoObj);
					//cnf.ScrollToView(driver.findElement(By.xpath(mbo.EditMode_DeleteLink)));
					WebElement ManageUsers_DeleteUser = driver.findElement(By.xpath(mbo.EditMode_DeleteLink));
					if (cnf.JSClick(ManageUsers_DeleteUser,driver)) {
						repfn.FnUpdateTestStepResHTML("Verify if Delete User Option is clickable","Delete User Option is clicked", "PASS",runManagerInfoObj);

						Thread.sleep(2000);
						FNManageUsers_DeleteUserPopupUI(driver,runManagerInfoObj);

						if(cnf.FnExplicitWait("Xpath", mbo.ManageUsers_DeleteUserPopup_Cancel,driver))
						{
							WebElement ManageUsers_DeleteUserPopup_Cancel = driver.findElement(By.xpath(mbo.ManageUsers_DeleteUserPopup_Cancel));

							if (cnf.JSClick(ManageUsers_DeleteUserPopup_Cancel,driver)) {

								repfn.FnUpdateTestStepResHTML("Verify if Delete User Popup Cancel option is clickable","Delete User Popup Cancel option is clicked","PASS",runManagerInfoObj);

								Thread.sleep(5000);

								List<WebElement> User_NameList = driver.findElements(By.xpath(mbo.User_NameList));
								if (User_NameList.size() > 0) {
									repfn.FnUpdateTestStepResHTML("Verify if Users are present on Manage Users Page","Users are present on Manage Users Page", "PASS",runManagerInfoObj);

									for (int i = 0; i < User_NameList.size(); i++) {
										String text1 = User_NameList.get(i).getText();
										if (text1.equalsIgnoreCase(Search)) {
											blnFlag = true;
											break;
										}
									}
									if (blnFlag) {
										repfn.FnUpdateTestStepResHTML("Verify if " + Search + " is present in User Name list on Manage Users Page", "The user "
												+ Search + " is present in User Name list on Manage Users Page", "PASS",runManagerInfoObj);
										blnFlag = true;

									} else {
										repfn.FnUpdateTestStepResHTML("Verify if " + Search + " is present in User Name list on Manage Users Page", "The user "
												+ Search + " is not present in User Name list on Manage Users Page", "FAIL",runManagerInfoObj);
										blnFlag = false;
									}
									driver.navigate().refresh();
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify if Users are present on Manage Users Page","Users are not present on Manage Users Page", "FAIL",runManagerInfoObj);
									blnFlag = false;
								}

							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify if Delete User Popup Cancel option is clickable","Delete User Popup Cancel option is not clicked","FAIL",runManagerInfoObj);
								blnFlag = false;
							}
						}
						else
						{
							repfn.FnUpdateTestStepResHTML("Verify if Delete User Popup Cancel option is getting displayed","Delete User Popup Cancel option is not getting displayed","FAIL",runManagerInfoObj);
							blnFlag = false;
						}


					} else {
						repfn.FnUpdateTestStepResHTML("Verify if Delete User Option is clickable","Delete User Option is not clicked", "FAIL",runManagerInfoObj);
						blnFlag = false;
					}
				} else {
					repfn.FnUpdateTestStepResHTML("Verify if Delete User Option is getting displayed","Delete User Option is not getting displayed","FAIL",runManagerInfoObj);
					blnFlag = false;
				}

			}
			else {
				repfn.FnUpdateTestStepResHTML("Verify Edit button is clicked ","Edit button is not clicked ", "FAIL",runManagerInfoObj);
				blnFlag = false;
			}
		} else {
			repfn.FnUpdateTestStepResHTML("Verify Edit button is displayed ","Edit button is not displayed ", "FAIL",runManagerInfoObj);
			blnFlag = false;
		}
	} catch (Exception e) {
		repfn.FnUpdateTestStepResHTML("Verify if Delete User Option is displayed and clicked","Delete User Option is not displayed and clicked due to some exception","PASS",runManagerInfoObj);
		System.err.println("Message : " + e.getMessage());
		System.err.println("Cause : " + e.getCause());
		blnFlag = false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}


public synchronized boolean FNManageUsers_DeleteUserPopupUI(WebDriver driver, RunManagerInfo runManagerInfoObj){
	boolean blnFlag = false;
	try {
		// DELETE USER POPUP VERIFY UI
		// Title
		if (cnf.FnExplicitWait("XPATH",mbo.ManageUsers_DeleteUserPopup_Title,driver)) {
			repfn.FnUpdateTestStepResHTML("Verify if Title is getting displayed","Title is getting displayed ", "PASS",runManagerInfoObj);
			WebElement ManageUsers_DeleteUserPopup_Title = driver.findElement(By.xpath(mbo.ManageUsers_DeleteUserPopup_Title));
			String titleText = ManageUsers_DeleteUserPopup_Title.getText();
			if (!titleText.isEmpty() && "Delete User".equalsIgnoreCase(titleText)) {
				repfn.FnUpdateTestStepResHTML("Verify if Title is getting displayed as \"Delete User\" ","Title displayed in Delete popup is : "+titleText, "PASS",runManagerInfoObj);
				blnFlag = true;
			} else {
				repfn.FnUpdateTestStepResHTML("Verify if Title is getting displayed as \"Delete User\" "," \"Delete User\" is not getting displayed as title","FAIL",runManagerInfoObj);
				blnFlag = false;
			}
		} else {
			repfn.FnUpdateTestStepResHTML("Verify if Title is getting displayed","Title is not getting displayed ", "FAIL",runManagerInfoObj);
			blnFlag = false;
		}
		// Text
		if (cnf.FnExplicitWait("XPATH",mbo.ManageUsers_DeleteUserPopup_Text,driver)) {
			repfn.FnUpdateTestStepResHTML("Verify if Text is getting displayed","Text is getting displayed ", "PASS",runManagerInfoObj);
			WebElement ManageUsers_DeleteUserPopup_Text = driver.findElement(By.xpath(mbo.ManageUsers_DeleteUserPopup_Text));
			String text1 = ManageUsers_DeleteUserPopup_Text.getText();
			if (!text1.isEmpty()&& "You are about to delete an active user. This action cannot be undone. Are you sure you want to delete this user?".equalsIgnoreCase(text1)) {
				repfn.FnUpdateTestStepResHTML("Verify if Text getting displayed in Delete User Popup is - " + " You are about to delete an active user. This action cannot be undone. Are you sure you want to delete this user?",
						"The text displayed in Delete User Popup is : "+text1, "PASS",runManagerInfoObj);
				blnFlag = true;

			} else {
				repfn.FnUpdateTestStepResHTML(
						"Verify if Text getting displayed in Delete User Popup is - "
								+ " You are about to delete an active user. This action cannot be undone. Are you sure you want to delete this user?",
								" The required text is not getting displayed in Delete User Popup","FAIL",runManagerInfoObj);
				blnFlag = false;
			}

		} else {
			repfn.FnUpdateTestStepResHTML("Verify if Text is getting displayed in popup","Text is not getting displayed in popup ", "FAIL",runManagerInfoObj);
			blnFlag = false;
		}
		// CONFIRM OPTION
		if (cnf.FnExplicitWait("XPATH",mbo.ManageUsers_DeleteUserPopup_Confirm,driver)) {
			repfn.FnUpdateTestStepResHTML("Verify if Confirm option is getting displayed in Delete User Popup","Confirm option is getting displayed in Delete User Popup","PASS",runManagerInfoObj);
			blnFlag = true;
		} else {
			repfn.FnUpdateTestStepResHTML("Verify if Confirm option is getting displayed in Delete User Popup","Confirm option is not getting displayed in Delete User Popup","FAIL",runManagerInfoObj);
			blnFlag = false;
		}

		// CONFIRM TILL HERE
		// X OPTION
		if (cnf.FnExplicitWait("XPATH", mbo.ManageUsers_DeleteUserPopup_X,driver)) {
			repfn.FnUpdateTestStepResHTML("Verify if Delete User Popup X option is getting displayed","Delete User Popup X option is getting displayed","PASS",runManagerInfoObj);
			blnFlag = true;
		} else {
			repfn.FnUpdateTestStepResHTML("Verify if Delete User Popup X option is getting displayed","Delete User Popup X option is not getting displayed","FAIL",runManagerInfoObj);
			blnFlag = false;
		}
		// X TILL HERE
		// CANCEL OPTION
		if (cnf.FnExplicitWait("XPATH",mbo.ManageUsers_DeleteUserPopup_Cancel,driver)) {
			repfn.FnUpdateTestStepResHTML("Verify if Delete User Popup Cancel option is getting displayed","Delete User Popup Cancel option is getting displayed","PASS",runManagerInfoObj);
			blnFlag = true;
		} else {
			repfn.FnUpdateTestStepResHTML("Verify if Delete User Popup Cancel option is getting displayed","Delete User Popup Cancel option is not getting displayed","FAIL",runManagerInfoObj);
			blnFlag = false;
		}

	} catch (Exception e) {
		repfn.FnUpdateTestStepResHTML("Verify User is able to verify Delete User pop-up UI","User is not able to verify Delete User pop-up UI due to some exception ", "PASS",runManagerInfoObj);
		System.err.println("Message : " + e.getMessage());
		System.err.println("Cause : " + e.getCause());
		blnFlag = false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}



}
