package com.charter.sb.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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

public class ManageUsersService extends Initialization{
	MB_PageObjects mbo = new MB_PageObjects();
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	public static boolean blnFlag = false;
	String Random_int_validation;
	Random rg=new Random();
	int randomInt = rg.nextInt(10000);
	public synchronized boolean ManageUsers_editLinkclick(WebDriver driver, RunManagerInfo runManagerInfoObj) {
		try
		{
			
			Thread.sleep(3000);
			if(cnf.FnExplicitWait("XPATH", mbo.manageEditLink,driver))
			{
				WebElement editUserLink=driver.findElement(By.xpath(mbo.manageEditLink));
				blnFlag=true;
				repfn.FnUpdateTestStepResHTML("Verify if user detail window is opened next to the list","User detail window is opened next to the list","PASS",runManagerInfoObj);
				repfn.FnUpdateTestStepResHTML("Verify if edit link is present","Edit link is present","PASS",runManagerInfoObj);
				if(cnf.JSClick(editUserLink,driver))
				{
					blnFlag=true;
					repfn.FnUpdateTestStepResHTML("Verify if user has clicked on edit link","User has clicked on edit link","PASS",runManagerInfoObj);
					Thread.sleep(5000);
				}
				else
				{
					blnFlag=false;
					repfn.FnUpdateTestStepResHTML("Verify if user has clicked on edit link","User has not clicked on edit link","FAIL",runManagerInfoObj);
				}
			}
			else
			{
				blnFlag=false;
				repfn.FnUpdateTestStepResHTML("Verify if user detail window is opened next to the list","User detail window is not opened next to the list","FAIL",runManagerInfoObj);
				repfn.FnUpdateTestStepResHTML("Verify if edit link is present","Edit link is not present","FAIL",runManagerInfoObj);
			}
		}
		catch (Exception e)

		{
			repfn.FnUpdateTestStepResHTML("Verify if user has clicked on edit link","User has not clicked on edit link due to some exception","FAIL",runManagerInfoObj);
			blnFlag=false;
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}

	public synchronized boolean FNManageusers_EditClick(WebDriver driver, RunManagerInfo runManagerInfoObj) {

		boolean blnFlag = false;
		try {
			Thread.sleep(2000);
			if (cnf.FnExplicitWait("Xpath", mbo.UserDetail_EditBtn,driver)) {
				repfn.FnUpdateTestStepResHTML("Verify Edit button is displayed ","Edit button is displayed ", "PASS",runManagerInfoObj);
				WebElement UserDetail_EditBtn = driver.findElement(By.xpath(mbo.UserDetail_EditBtn));
				Thread.sleep(2000);
				if (cnf.JSClick(UserDetail_EditBtn,driver)) {
					repfn.FnUpdateTestStepResHTML("Verify Edit button is clicked ","Edit button is clicked ", "PASS",runManagerInfoObj);				
					blnFlag = true;
					Thread.sleep(6000);
				} else {
					repfn.FnUpdateTestStepResHTML("Verify if Edit Option is clicked","Edit Option is not getting clicked", "FAIL",runManagerInfoObj);
					blnFlag = false;
				}

			} else {
				repfn.FnUpdateTestStepResHTML("Verify if Edit Option is displayed","Edit Option is not getting displayed", "FAIL",runManagerInfoObj);
				blnFlag = false;
			}
		} catch (Exception e)

		{
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnUpdateTestStepResHTML("Verify Edit Option is displayed and clicked","Edit Option is not displayed and clicked due to some exception","FAIL",runManagerInfoObj);
			blnFlag = false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	public synchronized boolean FNManageusers_EditCancelClick(WebDriver driver, RunManagerInfo runManagerInfoObj) {
		try{
			
			Thread.sleep(2000);
			if (cnf.FnExplicitWait("XPATH",mbo.EditMode_CancelBtn,driver)) {
				repfn.FnUpdateTestStepResHTML("Verify if Cancel Button is getting displayed","Cancel Button is getting displayed","PASS",runManagerInfoObj);
				WebElement EditMode_CancelBtn = driver.findElement(By.xpath(mbo.EditMode_CancelBtn));
				if (cnf.JSClick(EditMode_CancelBtn,driver)) {
					repfn.FnUpdateTestStepResHTML("Verify Cancel Button is clicked ","Cancel Button is clicked", "PASS",runManagerInfoObj);
					
					Thread.sleep(5000);
					
					if (cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)) {
						repfn.FnUpdateTestStepResHTML("Verify Details Information Screen is displayed for the selected phone line",
								"Details Information Screen is displayed for the selected phone line","PASS",runManagerInfoObj);
						Thread.sleep(3000);
						blnFlag = true;
					} 
					else {
						repfn.FnUpdateTestStepResHTML("Verify Details Information Screen is displayed for the selected phone line",
								"Details Information Screen is not displayed for the selected phone line","FAIL",runManagerInfoObj);
						blnFlag = false;
					}		
				}
				else {
					repfn.FnUpdateTestStepResHTML("Verify Cancel Button is clicked ","Cancel Button is not clicked","FAIL",runManagerInfoObj);
					blnFlag = false;
				}
			}
			else {
				repfn.FnUpdateTestStepResHTML("Verify if Cancel Button is getting displayed","Cancel Button is not getting displayed","FAIL",runManagerInfoObj);
				blnFlag = false;
			}
		}
		catch (Exception e)

		{
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnUpdateTestStepResHTML("Verify  Cancel Option Exits","Contact List   does not exist due to some exception","FAIL",runManagerInfoObj);
			blnFlag = false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	 
	public synchronized boolean FNManageusers_EditCancel(WebDriver driver, RunManagerInfo runManagerInfoObj) {

		boolean blnFlag = false;
		try {
			if (cnf.FnExplicitWait("XPATH", mbo.List_of_Users,driver)) {

				List<WebElement> User = driver.findElements(By
						.xpath(mbo.List_of_Users));

				if (User.size() > 0) {
					repfn.FnUpdateTestStepResHTML(
							"Verify if Users are present", "Users are present",
							"PASS",runManagerInfoObj);
				
					if (cnf.JSClick(User.get(0),driver)) {
						repfn.FnUpdateTestStepResHTML(
								"Verify if User  is getting clicked",
								"User is getting clicked", "PASS",runManagerInfoObj);

						if (cnf.FnExplicitWait("Xpath", mbo.UserDetail_EditBtn,driver)) {
							WebElement UserDetail_EditBtn = driver.findElement(By
									.xpath(mbo.UserDetail_EditBtn));

							if(cnf.JSClick(UserDetail_EditBtn,driver)){
								repfn.FnUpdateTestStepResHTML(
										"Verify Edit button is clicked ",
										"Edit button is clicked ",
										"PASS",runManagerInfoObj);
								Thread.sleep(2000);
								blnFlag=FNManageusers_EditCancelClick(driver,runManagerInfoObj);
								Thread.sleep(1000);
								if(blnFlag){

									if (cnf.FnExplicitWait("Xpath",
											mbo.UserDetail_EditBtn,driver)) {
										WebElement UserDetail_EditBtn1 = driver
												.findElement(By
														.xpath(mbo.UserDetail_EditBtn));

										if(cnf.JSClick(UserDetail_EditBtn1,driver)){
											repfn.FnUpdateTestStepResHTML(
													"Verify Edit button is dclicked ",
													"Edit button is clicked ",
													"PASS",runManagerInfoObj);
											Thread.sleep(2000);
									
											if (cnf.FnExplicitWait("XPATH",
													mbo.EditMode_firstName,driver)) {
												repfn.FnUpdateTestStepResHTML(
														"Verify if first Name Field is getting displayed",
														"first Name field is getting displayed",
														"PASS",runManagerInfoObj);
												WebElement EditMode_firstName = driver
														.findElement(By
																.xpath(mbo.EditMode_firstName));
												String firstNameText = "Abcd";
												if(cnf.JSClick(EditMode_firstName,driver))
												{
													repfn.FnUpdateTestStepResHTML(
															"Verify if First Name is clickable",
															"First Name is clicked",
															"PASS",runManagerInfoObj);
													EditMode_firstName.clear();
													EditMode_firstName.sendKeys(firstNameText);	
													blnFlag=FNManageusers_EditCancelClick(driver,runManagerInfoObj);
													Thread.sleep(1000);
													if(blnFlag){
														if(cnf.FnExplicitWait("XPATH", mbo.ManageUsers_CancelEditPopup,driver)){
															repfn.FnUpdateTestStepResHTML(
																	"Verify if Cancel Option is getting displayed in popup",
																	"Cancel Option is getting displayed in popup", "PASS",runManagerInfoObj);
															WebElement CancelPopup = driver.findElement(By
																	.xpath(mbo.ManageUsers_CancelEditPopup)); 

															if(cnf.JSClick(CancelPopup,driver)) 
															{
																repfn.FnUpdateTestStepResHTML(
																		"Verify if Cancel Option is Clickable in popup",
																		"Cancel Option is clicked in popup",
																		"PASS",runManagerInfoObj);
																Thread.sleep(1000);
																FNManageusers_EditCancelClick(driver,runManagerInfoObj);


																if(cnf.FnExplicitWait("XPATH", mbo.ManageUsers_CancelEditPopup,driver)){
																	repfn.FnUpdateTestStepResHTML(
																			"Verify if Confirm Option is getting displayed in popup",
																			"Confirm Option is getting displayed in popup", "PASS",runManagerInfoObj);

																	WebElement CancelConfirm = driver.findElement(By
																			.xpath(mbo.ManageUsers_CancelConfirm)); 
																	if(cnf.JSClick(CancelConfirm,driver)) 
																	{
																		repfn.FnUpdateTestStepResHTML(
																				"Verify if Confirm Option is Clickable in popup",
																				"Confirm Option is clicked in popup",
																				"PASS",runManagerInfoObj);
																		driver.navigate().refresh();
																		blnFlag = true;
																		Thread.sleep(1000);
																	}
																	else
																	{
																		repfn.FnUpdateTestStepResHTML(
																				"Verify if Confirm Option is Clickable in popup",
																				"Confirm Option is not clicked in popup",
																				"FAIL",runManagerInfoObj);
																		blnFlag =false; 
																	}
																}
																else
																{
																	repfn.FnUpdateTestStepResHTML(
																			"Verify if popup is getting displayed",
																			" popup is getting displayed", "FAIL",runManagerInfoObj);
																	blnFlag =false; 
																}
															}
															else
															{
																repfn.FnUpdateTestStepResHTML(
																		"Verify if Cancel Option is Clickable in popup",
																		"Cancel Option is not clicked in popup", "FAIL",runManagerInfoObj);
																blnFlag =false; }
														} 
													else {

															repfn.FnUpdateTestStepResHTML(
																	"Verify if Confirm Option is getting displayed in popup",
																	"Confirm Option is not getting displayed in popup", "FAIL",runManagerInfoObj); 
															blnFlag =false; 
																	}
													}
													else
													{
														blnFlag=false;
													}
												}
												else
												{
													repfn.FnUpdateTestStepResHTML(
															"Verify if First Name is clickable",
															"First Name is not clicked",
															"FAIL",runManagerInfoObj); blnFlag = false;
												}

											} else {
												repfn.FnUpdateTestStepResHTML(
														"Verify if first Name Field is getting displayed",
														"first Name field is not getting displayed",
														"FAIL",runManagerInfoObj); blnFlag = false; }
										}
										else
										{
											repfn.FnUpdateTestStepResHTML(
													"Verify if first Name Field is getting displayed",
													"first Name field is not getting displayed",
													"FAIL",runManagerInfoObj);
											blnFlag = false;
										}

									} else {
										repfn.FnUpdateTestStepResHTML(
												"Verify if Edit button is clicked ",
												"Edit button is not clicked",
												"FAIL",runManagerInfoObj);
										blnFlag = false;
									}
								}else{
									blnFlag = false;
								}
							} else {
								repfn.FnUpdateTestStepResHTML(
										"Verify if Edit Option is clicked",
										"Edit Option is not getting clicked",
										"FAIL",runManagerInfoObj);
								blnFlag = false;
							}

						}
					} else {
						repfn.FnUpdateTestStepResHTML(
								"Verify if User  is getting clicked",
								"User is not getting clicked", "FAIL",runManagerInfoObj);
					}
				} else {
					repfn.FnUpdateTestStepResHTML(
							"Check Whether Edit link is present ",
							"Edit link is not present", "FAIL",runManagerInfoObj);
					blnFlag = false;

				}

			}

			else {
				repfn.FnUpdateTestStepResHTML(
						"Verify if any Users present or not  ",
						"Users not present ", "FAIL",runManagerInfoObj);
				blnFlag = false;
			}

		}

		catch (Exception e)

		{
			repfn.FnUpdateTestStepResHTML(
					"Verifying if the user is able to edit the contact and cancel changes  ",
					" user is not able to edit the contact and cancel changes  ",
					"FAIL",runManagerInfoObj);
			blnFlag = false;
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());

		}

		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;

		
	}

	public synchronized boolean FNManageusers_EditChangesCancel(WebDriver driver, RunManagerInfo runManagerInfoObj) {
		boolean blnFlag = false;
		try {
			if (cnf.FnExplicitWait("XPATH", mbo.EditMode_firstName,driver)) {
				repfn.FnUpdateTestStepResHTML(
						"Verify if first Name Field is getting displayed on Edit User Screen",
						"First Name field is getting displayed on Edit User Screen",
						"PASS",runManagerInfoObj);
				WebElement EditMode_firstName = driver.findElement(By
						.xpath(mbo.EditMode_firstName));
				String firstName = EditMode_firstName.getAttribute("value");

				if (cnf.FnExplicitWait("XPATH", mbo.EditMode_LastName,driver)) {
					repfn.FnUpdateTestStepResHTML(
							"Verify if Last Name Field is getting displayed on Edit User Screen",
							"Last Name field is getting displayed on Edit User Screen",
							"PASS",runManagerInfoObj);
					WebElement EditMode_lastName = driver.findElement(By
							.xpath(mbo.EditMode_LastName));
					String lastName = EditMode_lastName.getAttribute("value");
					String userName = firstName + " " + lastName;

					String firstNameText = "Abcd";
					if (cnf.JSClick(EditMode_firstName,driver)) {
						repfn.FnUpdateTestStepResHTML(
								"Verify if First Name is getting clicked on Edit User Screen",
								"First Name is clicked on Edit User Screen",
								"PASS",runManagerInfoObj);
						EditMode_firstName.clear();
						EditMode_firstName.sendKeys(firstNameText);
						blnFlag = FNManageusers_EditCancelClick(driver,runManagerInfoObj);

						if (blnFlag) {
							if (cnf.FnExplicitWait("XPATH",
									mbo.ManageUsers_CancelEditPopup,driver)) {
								repfn.FnUpdateTestStepResHTML(
										"Verify if Cancel Option is getting displayed in popup",
										"Cancel Option is getting displayed in popup",
										"PASS",runManagerInfoObj);
								WebElement CancelPopup = driver
										.findElement(By
												.xpath(mbo.ManageUsers_CancelEditPopup));

								if (cnf.JSClick(CancelPopup,driver)) {
									repfn.FnUpdateTestStepResHTML(
											"Verify if Cancel Option is Clickable in popup",
											"Cancel Option is clicked in popup",
											"PASS",runManagerInfoObj);
									Thread.sleep(2000);

									blnFlag = FNManageusers_EditCancelClick(driver,runManagerInfoObj);
									if (blnFlag) {
										repfn.FnUpdateTestStepResHTML(
												"Verify if popup is getting displayed",
												" popup is getting displayed",
												"PASS",runManagerInfoObj);

										if (cnf.FnExplicitWait("XPATH",
												mbo.ManageUsers_CancelConfirm,driver)) {
											repfn.FnUpdateTestStepResHTML(
													"Verify if Confirm Option is getting displayed in popup",
													"Confirm Option is getting displayed in popup",
													"PASS",runManagerInfoObj);

											WebElement CancelConfirm = driver
													.findElement(By
															.xpath(mbo.ManageUsers_CancelConfirm));
											if (cnf.JSClick(CancelConfirm,driver)) {
												repfn.FnUpdateTestStepResHTML(
														"Verify if Confirm Option is Clickable in popup",
														"Confirm Option is clicked in popup",
														"PASS",runManagerInfoObj);
												driver.navigate().refresh();

												if (cnf.FnExplicitWait("XPATH",
														mbo.ManageUsersLabel,driver)) {
													WebElement ManageUsers = driver
															.findElement((By
																	.xpath(mbo.ManageUsersLabel)));
													if (ManageUsers
															.getText()
															.equalsIgnoreCase(
																	"Manage Users")) {
														repfn.FnUpdateTestStepResHTML(
																"Verify that the user is on Manage Users Page",
																"User is on Manage Users Page",
																"PASS",runManagerInfoObj);

														if (cnf.FnExplicitWait(
																"XPATH",
																mbo.List_of_Users,driver)) {
															repfn.FnUpdateTestStepResHTML(
																	"Verify if List of users is displayed on Manage Users Screen",
																	"List of users is displayed on Manage Users Screen",
																	"PASS",runManagerInfoObj);
															List<WebElement> User = driver
																	.findElements(By
																			.xpath(mbo.List_of_Users));
															int Size = User
																	.size();
															if (Size > 0) {
																repfn.FnUpdateTestStepResHTML(
																		"Verify if Users are present on Manage Users Screen",
																		"Users are present on Manage Users Screen",
																		"PASS",runManagerInfoObj);
																if (cnf.FnExplicitWait(
																		"XPATH",
																		mbo.User_NameList,driver)) {
																	List<WebElement> User_NameList = driver
																			.findElements(By
																					.xpath(mbo.User_NameList));
																	int count = 0;

																	for (int i = 0; i < User_NameList
																			.size(); i++) {
																		if (User_NameList
																				.get(i)
																				.getText()
																				.equalsIgnoreCase(
																						userName)) {
																			count++;
																			break;
																		}
																	}

																	if (count > 0) {
																		repfn.FnUpdateTestStepResHTML(
																				"Verify if Changes done to user have been discarded",
																				"Changes done to user have been discarded",
																				"PASS",runManagerInfoObj);
																		blnFlag = true;
																	} else {
																		repfn.FnUpdateTestStepResHTML(
																				"Verify if Changes done to user have been discarded",
																				"Changes done to user have not been discarded",
																				"FAIL",runManagerInfoObj);
																		blnFlag = false;
																	}
																} else {
																	blnFlag = false;
																}

															} else {
																repfn.FnUpdateTestStepResHTML(
																		"Verify if Users are present on Manage Users Screen",
																		"Users are not present on Manage Users Screen",
																		"FAIL",runManagerInfoObj);
																blnFlag = false;
															}
														} else {
															repfn.FnUpdateTestStepResHTML(
																	"Verify if List of users is displayed on Manage Users Screen",
																	"List of users is not displayed on Manage Users Screen",
																	"FAIL",runManagerInfoObj);
															blnFlag = false;
														}
													} else {
														repfn.FnUpdateTestStepResHTML(
																"Verify that the user is on Manage Users Page",
																"User is not on Manage Users Page",
																"FAIL",runManagerInfoObj);
														blnFlag = false;
													}
												} else {
													repfn.FnUpdateTestStepResHTML(
															"Verify that the user is on Manage Users Page",
															"User is not on Manage Users Page",
															"FAIL",runManagerInfoObj);
													blnFlag = false;
												}

											}

											else {
												repfn.FnUpdateTestStepResHTML(
														"Verify if Confirm Option is Clickable in popup",
														"Confirm Option is not clicked in popup",
														"FAIL",runManagerInfoObj);
												blnFlag = false;
											}

										} else {
											repfn.FnUpdateTestStepResHTML(
													"Verify if Confirm Option is getting displayed in popup",
													"Confirm Option is not getting displayed in popup",
													"FAIL",runManagerInfoObj);
											blnFlag = false;
										}
									} else {
										repfn.FnUpdateTestStepResHTML(
												"Verify if popup is getting displayed",
												" popup is not getting displayed",
												"FAIL",runManagerInfoObj);
										blnFlag = false;
									}

								} else {
									repfn.FnUpdateTestStepResHTML(
											"Verify if Cancel Option is Clickable in popup",
											"Cancel Option is not clicked in popup",
											"FAIL",runManagerInfoObj);
									blnFlag = false;
								}
							} else {

								repfn.FnUpdateTestStepResHTML(
										"Verify if Confirm Option is getting displayed in popup",
										"Confirm Option is not getting displayed in popup",
										"FAIL",runManagerInfoObj);
								blnFlag = false;
							}
						} else {
							blnFlag = false;
						}
					} else {
						repfn.FnUpdateTestStepResHTML(
								"Verify if First Name is getting clicked on Edit User Screen",
								"First Name is not clicked on Edit User Screen",
								"FAIL",runManagerInfoObj);
						blnFlag = false;
					}
				} else {
					repfn.FnUpdateTestStepResHTML(
							"Verify if Last Name Field is getting displayed on Edit User Screen",
							"Last Name field is not getting displayed on Edit User Screen",
							"FAIL",runManagerInfoObj);
					blnFlag = false;
				}
			} else {
				repfn.FnUpdateTestStepResHTML(
						"Verify if first Name Field is getting displayed on Edit User Screen",
						"first Name field is not getting displayed on Edit User Screen",
						"FAIL",runManagerInfoObj);
				blnFlag = false;
			}

		}

		catch (Exception e)

		{
			repfn.FnUpdateTestStepResHTML(
					"Verifying if the user is able to edit the contact and cancel changes  ",
					" user is not able to edit the contact and cancel changes  ",
					"FAIL",runManagerInfoObj);
			blnFlag = false;
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());

		}

		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;

	}


	 
	public synchronized boolean fnManageVoiceCancel(WebDriver driver, RunManagerInfo runManagerInfoObj) {
		
		try {
			
			boolean tab = app.FnCheckVoiceTab(driver,runManagerInfoObj);
			if(tab){
				if(cnf.FnExplicitWait("XPATH", mbo.manageVoiceLineButton,driver)) {
					blnFlag=addVoiceLine(driver,runManagerInfoObj);
				}
				else{
					if(cnf.FnExplicitWait("XPATH", mbo.NoVoiceLines,driver)) {
						WebElement NoVoiceLinesmsg=driver.findElement(By.xpath(mbo.NoVoiceLinesmsg));
						String msg=NoVoiceLinesmsg.getText();
						repfn.FnUpdateTestStepResHTML("Verify if any voice line is present or not","No voice line button is  present as message displayed is: "+msg, "PASS",runManagerInfoObj);

						boolean blnFlag1 = app.FnUnassignVoiceLineAndReturn(driver,runManagerInfoObj);
						if(blnFlag1){
							boolean blnFlag2 = fnManageVoiceCancel(driver,runManagerInfoObj);
							if(blnFlag2){
								blnFlag = true;
							}
							else{
								blnFlag = false;
							}					
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User is able to unassign Voice Line and Return to adding a new user","User is not able to unassign Voice Line and Return to adding a new user", "FAIL",runManagerInfoObj);
							blnFlag = false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify No Voice line warning message is displayed","No Voice line warning message is not displayed", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
			}
			else{
				if(cnf.FnExplicitWait("XPATH", mbo.manageCancel,driver)) {
					repfn.FnUpdateTestStepResHTML("Verify if \"Cancel\" link is present","\"Cancel\" link is present", "PASS",runManagerInfoObj);
					WebElement cancelLink = driver.findElement(By.xpath(mbo.manageCancel));
					if (cnf.JSClick(cancelLink,driver)) {
						Thread.sleep(5000);
						repfn.FnUpdateTestStepResHTML("Verify if \"Cancel\" link is clicked","\"Cancel\" link is clicked", "PASS",runManagerInfoObj);

						if (cnf.FnExplicitlessWait_untilClickable("XPATH",mbo.manageCancelPopUp,driver)) {
							repfn.FnUpdateTestStepResHTML("Verify if \"Cancel\" link is present in popup","\"Cancel\" link is present in popup","PASS",runManagerInfoObj);
							WebElement cancelPopUp = driver.findElement(By.xpath(mbo.manageCancelPopUp));
							if (cnf.JSClick(cancelPopUp,driver)) {
								Thread.sleep(5000);
								repfn.FnUpdateTestStepResHTML("Verify if \"Cancel\" link is clicked in popup","\"Cancel\" link is clicked in popup","PASS",runManagerInfoObj);
								WebElement cancelLinkAgain = driver.findElement(By.xpath(mbo.manageCancel));
								if (cnf.JSClick(cancelLinkAgain,driver)) {
									Thread.sleep(5000);
									repfn.FnUpdateTestStepResHTML("Verify if \"Cancel\" link is clicked again","\"Cancel\" link is clicked again","PASS",runManagerInfoObj);
									WebElement confirmPopUp = driver.findElement(By.xpath(mbo.manageConfirmPopUp));
									if (cnf.JSClick(confirmPopUp,driver)) {
										Thread.sleep(5000);
										repfn.FnUpdateTestStepResHTML("Verify if \"Confirm\" link is clicked in popup","\"Confirm\" link is clicked in popup","PASS",runManagerInfoObj);

										if(cnf.FnExplicitWait("XPATH",mbo.PageVerificationTwo,driver)){
											WebElement PageVerificationTwo=driver.findElement(By.xpath(mbo.PageVerificationTwo));
											if(PageVerificationTwo.getAttribute("textContent").equalsIgnoreCase("Users")){
												repfn.FnUpdateTestStepResHTML("Verify User is navigated to Manage Users page", "User is navigated to Manage Users page","PASS",runManagerInfoObj);
												blnFlag	=true;
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify User is navigated to Manage Users page", "User is not navigated to Manage Users page","FAIL",runManagerInfoObj);
												blnFlag	=false;
											}
										}
										else{													
											repfn.FnUpdateTestStepResHTML("Verify User is navigated to Manage Users page", "User is not navigated to Manage Users page","FAIL",runManagerInfoObj);
											blnFlag	=false;
										}
									} 
									else {
										blnFlag = false;
										repfn.FnUpdateTestStepResHTML("Verify if \"Confirm\" link is clicked in popup","\"Confirm\" link is not clicked in popup","FAIL",runManagerInfoObj);
									}
								} 
								else {
									blnFlag = false;
									repfn.FnUpdateTestStepResHTML("Verify if \"Cancel\" link is clicked again","\"Cancel\" link is not clicked again","FAIL",runManagerInfoObj);
								}
							} 
							else {
								blnFlag = false;
								repfn.FnUpdateTestStepResHTML("Verify if \"Cancel\" link is clicked in popup","\"Cancel\" link is not clicked in popup","FAIL",runManagerInfoObj);
							}
						} 
						else {
							blnFlag = false;
							repfn.FnUpdateTestStepResHTML("Verify if \"Cancel\" link is present in popup","\"Cancel\" link is not present in popup","FAIL",runManagerInfoObj);
						}
					} 
					else {
						blnFlag = false;
						repfn.FnUpdateTestStepResHTML("Verify if \"Cancel\" link is clicked","\"Cancel\" link is not clicked", "FAIL",runManagerInfoObj);
					}
				} 
				else {
					blnFlag = false;
					repfn.FnUpdateTestStepResHTML("Verify if \"Cancel\" link is present","\"Cancel\" link is present", "FAIL",runManagerInfoObj);
				}
			}
		} 
		
		catch (Exception e) {
			blnFlag = false;
			repfn.FnUpdateTestStepResHTML(
					"Verify that the Account Owner/ Administrator user is able to cancel creating a New User",
					"Account Owner/ Administrator user is not able to cancel creating a New User due to some exception",
					"FAIL",runManagerInfoObj);
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	
	public synchronized boolean addVoiceLine(WebDriver driver, RunManagerInfo runManagerInfoObj){
		
		try{
			
			if(cnf.FnExplicitWait("XPATH",mbo.manageVoiceLineButton,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify if \"Add voice line\" button is present", "\"Add voice line\" button is present", "PASS",runManagerInfoObj);
				WebElement addVoiceLine=driver.findElement(By.xpath(mbo.manageVoiceLineButton));
				if(cnf.JSClick(addVoiceLine,driver)){
					repfn.FnUpdateTestStepResHTML("Verify if \"Add voice line\" button is clicked", "\"Add voice line\" button is clicked", "PASS",runManagerInfoObj);
					if(cnf.FnExplicitWait("XPATH", mbo.VoiceLineValue,driver))
					{
						WebElement VoiceLineValue=driver.findElement(By.xpath(mbo.VoiceLineValue));
						repfn.FnUpdateTestStepResHTML("Verify Voice line is added", "Voice line is added: "+VoiceLineValue.getText(), "PASS",runManagerInfoObj);
						
						if (cnf.FnExplicitWait("XPATH", mbo.manageCancel,driver)) {
							repfn.FnUpdateTestStepResHTML("Verify if \"Cancel\" link is present","\"Cancel\" link is present", "PASS",runManagerInfoObj);
							WebElement cancelLink = driver.findElement(By.xpath(mbo.manageCancel));
							if (cnf.JSClick(cancelLink,driver)) {
								Thread.sleep(5000);
								repfn.FnUpdateTestStepResHTML("Verify if \"Cancel\" link is clicked","\"Cancel\" link is clicked", "PASS",runManagerInfoObj);

								if (cnf.FnExplicitlessWait_untilClickable("XPATH",mbo.manageCancelPopUp,driver)) {
									repfn.FnUpdateTestStepResHTML("Verify if \"Cancel\" link is present in popup","\"Cancel\" link is present in popup","PASS",runManagerInfoObj);
									WebElement cancelPopUp = driver.findElement(By.xpath(mbo.manageCancelPopUp));
									if (cnf.JSClick(cancelPopUp,driver)) {
										Thread.sleep(5000);
										repfn.FnUpdateTestStepResHTML("Verify if \"Cancel\" link is clicked in popup","\"Cancel\" link is clicked in popup","PASS",runManagerInfoObj);
										if (!driver.findElement(By.xpath("//button[@class='sb-btn sb-btn--alternate dropdown-toggle']")).getText().isEmpty()) {

											repfn.FnUpdateTestStepResHTML("Verify if voice line assigned is retained","Voice line assigned is retained","PASS",runManagerInfoObj);
											WebElement cancelLinkAgain = driver.findElement(By.xpath(mbo.manageCancel));
											if (cnf.JSClick(cancelLinkAgain,driver)) {
												Thread.sleep(5000);
												repfn.FnUpdateTestStepResHTML("Verify if \"Cancel\" link is clicked again","\"Cancel\" link is clicked again","PASS",runManagerInfoObj);
												WebElement confirmPopUp = driver.findElement(By.xpath(mbo.manageConfirmPopUp));
												if (cnf.JSClick(confirmPopUp,driver)) {
													Thread.sleep(5000);
													repfn.FnUpdateTestStepResHTML("Verify if \"Confirm\" link is clicked in popup","\"Confirm\" link is clicked in popup","PASS",runManagerInfoObj);

													if(cnf.FnExplicitWait("XPATH",mbo.PageVerificationTwo,driver)){
														WebElement PageVerificationTwo=driver.findElement(By.xpath(mbo.PageVerificationTwo));
														if(PageVerificationTwo.getAttribute("textContent").equalsIgnoreCase("Users")){
															repfn.FnUpdateTestStepResHTML("Verify User is navigated to Manage Users page", "User is navigated to Manage Users page","PASS",runManagerInfoObj);
															blnFlag	=true;
														}
														else{
															repfn.FnUpdateTestStepResHTML("Verify User is navigated to Manage Users page", "User is not navigated to Manage Users page","FAIL",runManagerInfoObj);
															blnFlag	=false;
														}
													}
													else{													
														repfn.FnUpdateTestStepResHTML("Verify User is navigated to Manage Users page", "User is not navigated to Manage Users page","FAIL",runManagerInfoObj);
														blnFlag	=false;
													}
												} 
												else {
													blnFlag = false;
													repfn.FnUpdateTestStepResHTML("Verify if \"Confirm\" link is clicked in popup","\"Confirm\" link is not clicked in popup","FAIL",runManagerInfoObj);
												}
											} 
											else {
												blnFlag = false;
												repfn.FnUpdateTestStepResHTML("Verify if \"Cancel\" link is clicked again","\"Cancel\" link is not clicked again","FAIL",runManagerInfoObj);
											}
										} 
										else {
											blnFlag = false;
											repfn.FnUpdateTestStepResHTML("Verify if voice line assigned is retained","Voice line assigned is not retained","FAIL",runManagerInfoObj);
										}
									} 
									else {
										blnFlag = false;
										repfn.FnUpdateTestStepResHTML("Verify if \"Cancel\" link is clicked in popup","\"Cancel\" link is not clicked in popup","FAIL",runManagerInfoObj);
									}
								} 
								else {
									blnFlag = false;
									repfn.FnUpdateTestStepResHTML("Verify if \"Cancel\" link is present in popup","\"Cancel\" link is not present in popup","FAIL",runManagerInfoObj);
								}
							} 
							else {
								blnFlag = false;
								repfn.FnUpdateTestStepResHTML("Verify if \"Cancel\" link is clicked","\"Cancel\" link is not clicked", "FAIL",runManagerInfoObj);
							}
						} 
						else {
							blnFlag = false;
							repfn.FnUpdateTestStepResHTML("Verify if \"Cancel\" link is present","\"Cancel\" link is present", "FAIL",runManagerInfoObj);
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Voice line is added", "Voice line is not added", "FAIL",runManagerInfoObj);
						blnFlag = false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify if \"Add voice line\" button is clicked", "\"Add voice line\" button is not clicked", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify if \"Add voice line\" button is present", "\"Add voice line\" button is not present", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}		
		}
		
		catch (Exception e) {
			blnFlag = false;
			repfn.FnUpdateTestStepResHTML(
					"Verify that the Account Owner/ Administrator user is able to cancel creating a New User",
					"Account Owner/ Administrator user is not able to cancel creating a New User due to some exception",
					"FAIL",runManagerInfoObj);
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	public synchronized boolean FNManageusers_Edit_EditUserUI(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
		boolean blnFlag = false;
		try {
			// DELETE USER POPUP VERIFY UI
			// Title
			if (cnf.FnExplicitWait("XPATH",mbo.EditMode_UsrDetails,driver)) {
				repfn.FnUpdateTestStepResHTML("Verify if Title is getting displayed","Title is getting displayed ", "PASS",runManagerInfoObj);
				WebElement EditMode_UsrDetails = driver.findElement(By.xpath(mbo.EditMode_UsrDetails));
				String titleText = EditMode_UsrDetails.getText();
				if (!titleText.isEmpty() && "User Details".equalsIgnoreCase(titleText)) {
					repfn.FnUpdateTestStepResHTML("Verify if Title is getting displayed ","Title displayed is :"+titleText, "PASS",runManagerInfoObj);
					blnFlag = true;
				} else {
					repfn.FnUpdateTestStepResHTML("Verify if Title is getting displayed ","User Details is not getting displayed as title","FAIL",runManagerInfoObj);
					blnFlag = false;
				}
			} else {
				repfn.FnUpdateTestStepResHTML("Verify if Title is getting displayed","Title is not getting displayed ", "FAIL",runManagerInfoObj);
				blnFlag = false;
			}
			
			
			// SaveResetButton
			if (cnf.FnExplicitWait("XPATH", mbo.EditMode_SaveResetPassWordBtn,driver)) {

				repfn.FnUpdateTestStepResHTML("Verify Send Reset Password Link is displayed ","Send Reset Password Link is displayed", "PASS",runManagerInfoObj);
				blnFlag = true;
			} else {
				repfn.FnUpdateTestStepResHTML("Verify Send Reset Password Link is displayed ","Send Reset Password Link is not displayed", "FAIL",runManagerInfoObj);
				blnFlag = false;
			}
			
			// Sub Section-User Information
			if (cnf.FnExplicitWait("XPATH",mbo.EditMode_UserDetailsInfo,driver)) {
				repfn.FnUpdateTestStepResHTML("Verify if Subsection1 is getting displayed in popup","Subsection1 is getting displayed in popup", "PASS",runManagerInfoObj);
				WebElement UserDetailsInfo = driver.findElement(By.xpath(mbo.EditMode_UserDetailsInfo));
				String text1 = UserDetailsInfo.getText();
				if (!text1.isEmpty()&& "User Information".equalsIgnoreCase(text1)) {
					repfn.FnUpdateTestStepResHTML("Verify if Text getting displayed in Subsection1 is -User Information","The text displayed in Subsection1 is :"+text1,"PASS",runManagerInfoObj);
					blnFlag = true;

				} else {
					repfn.FnUpdateTestStepResHTML("Verify if Text getting displayed in Subsection1 is -User Information","The text is not getting displayed in Subsection1 ","FAIL",runManagerInfoObj);
					blnFlag = false;
				}

			} else {
				repfn.FnUpdateTestStepResHTML("Verify if Subsection1 is getting displayed in popup","Subsection1 is not getting displayed in popup ", "FAIL",runManagerInfoObj);
				blnFlag = false;
			}

			// EditMode_FirstNameLabel
			if (cnf.FnExplicitWait("XPATH",mbo.EditMode_FirstNameLabel,driver)) {
				repfn.FnUpdateTestStepResHTML("Verify First name Label is displayed ","First name Label  is displayed", "PASS",runManagerInfoObj);
				blnFlag = true;
			} else {
				repfn.FnUpdateTestStepResHTML("Verify First name Label  is displayed ","First name Label  is not displayed", "FAIL",runManagerInfoObj);
				blnFlag = false;
			}
			
			// EditMode_firstName
			if (cnf.FnExplicitWait("XPATH", mbo.EditMode_firstName,driver)) {

				repfn.FnUpdateTestStepResHTML("Verify Verify if the First name field is displayed ","First name field is displayed and editable", "PASS",runManagerInfoObj);
				blnFlag = true;
			} else {
				repfn.FnUpdateTestStepResHTML("Verify Verify if the First name field is displayed ","First name field is  not displayed and  not editable","FAIL",runManagerInfoObj);
				blnFlag = false;
			}
			// EditMode_LastNameLabel
			if (cnf.FnExplicitWait("XPATH", mbo.EditMode_LastNameLabel,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Last name Label is displayed ","Last name Label is displayed", "PASS",runManagerInfoObj);
				blnFlag = true;
			} else {
				repfn.FnUpdateTestStepResHTML("Verify Last name Label is displayed ","Last name Label is not displayed", "FAIL",runManagerInfoObj);
				blnFlag = false;
			}
			// EditMode_LastName
			

			if (cnf.FnExplicitWait("XPATH", mbo.EditMode_LastName,driver)) {

				repfn.FnUpdateTestStepResHTML(" Verify if the Last name field is displayed ","Last name field is displayed and editable", "PASS",runManagerInfoObj);
				blnFlag = true;
			} else {
				repfn.FnUpdateTestStepResHTML(" Verify if the Last name field is displayed ","Last name field is  not displayed and  not editable","FAIL",runManagerInfoObj);
				blnFlag = false;
			}
			// EditMode_PhoneLabel
			if (cnf.FnExplicitWait("XPATH", mbo.EditMode_PhoneLabel,driver)) {
				repfn.FnUpdateTestStepResHTML("Verify Phone Number Label is displayed ","Phone Number Label is displayed", "PASS",runManagerInfoObj);
				blnFlag = true;
			} else {
				repfn.FnUpdateTestStepResHTML("Verify Phone Number Label is displayed ","Phone Number Label is not displayed", "FAIL",runManagerInfoObj);
				blnFlag = false;
			}
			// EditMode_PhoneNumber
			
			if (cnf.FnExplicitWait("XPATH", mbo.EditMode_PhoneNumber,driver)) {

				repfn.FnUpdateTestStepResHTML(" Verify if the Phone Number field is displayed ","Phone Number is  field  displayed and   editable","PASS",runManagerInfoObj);
				blnFlag = true;
			} else {
				repfn.FnUpdateTestStepResHTML(" Verify if the Phone Number field is displayed ","Phone Number is field  is not   displayed and   not  editable","FAIL",runManagerInfoObj);
				blnFlag = false;
			}
			// EditMode_EmailLabel
			if (cnf.FnExplicitWait("XPATH", mbo.EditMode_EmailLabel,driver)) {

				repfn.FnUpdateTestStepResHTML("Verify  Email Address Label is displayed "," Email Address Label is displayed", "PASS",runManagerInfoObj);
				blnFlag = true;
			} else {
				repfn.FnUpdateTestStepResHTML("Verify  Email Address Label is displayed "," Email Address Label is not displayed", "FAIL",runManagerInfoObj);
				blnFlag = false;
			}
			// EditMode_EmailId
			
			if (cnf.FnExplicitWait("XPATH", mbo.EditMode_EmailId,driver)) {

				repfn.FnUpdateTestStepResHTML(" Verify if the Email Address field is displayed ","Email Address  field  is  displayed and    editable","PASS",runManagerInfoObj);
				blnFlag = true;
			} else {
				repfn.FnUpdateTestStepResHTML(" Verify if the Email Address field is displayed ","Email Address  field  is not   displayed and   not  editable","FAIL",runManagerInfoObj);
				blnFlag = false;
			}
			// EditMode_UsrRoleLabel
			if (cnf.FnExplicitWait("XPATH", mbo.EditMode_UsrRoleLabel,driver)) {

				repfn.FnUpdateTestStepResHTML("Verify  Role Label is displayed  "," Role Label is displayed", "PASS",runManagerInfoObj);
				blnFlag = true;
			} else {
				repfn.FnUpdateTestStepResHTML("Verify  Role Label is displayed "," Role Label is  not displayed", "FAIL",runManagerInfoObj);
				blnFlag = false;
			}

			// EditMode_UserRoleDefault

			if (cnf.FnExplicitWait("XPATH", mbo.EditMode_UserRoleDefault,driver)) {
				WebElement EditMode_UserRoleDefault = driver.findElement(By.xpath(mbo.EditMode_UserRoleDefault));
				if(cnf.JSClick(EditMode_UserRoleDefault,driver)){
					repfn.FnUpdateTestStepResHTML("Verify User Role dropdown  is displayed and  clicked ","User Role dropdown is displayed and  clicked", "PASS",runManagerInfoObj);
					blnFlag = true;
					Thread.sleep(5000);
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify User Role dropdown  is displayed and  clicked ","User Role dropdown is not displayed and clicked", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			} else {
				repfn.FnUpdateTestStepResHTML("Verify User Role dropdown is displayed and  clicked ","User Role dropdown is  not displayed and not clicked","FAIL",runManagerInfoObj);
				blnFlag = false;
			}
			// EditMode_AdminRole
					
			if (cnf.FnExplicitWait("XPATH", mbo.EditMode_AdminRole,driver)) {
				WebElement EditMode_AdminRole = driver.findElement(By.xpath(mbo.EditMode_AdminRole));
				// cnf.ElementClick(EditMode_AdminRole);
				repfn.FnUpdateTestStepResHTML("Verify Administrator Role  is displayed in the dropdown ","Administrator Role  is displayed in the dropdown  ","PASS",runManagerInfoObj);
				blnFlag = true;
			} else {
				repfn.FnUpdateTestStepResHTML("Verify  Administrator Role  is displayed in the dropdown "," Administrator Role  is  not displayed in the dropdown","FAIL",runManagerInfoObj);
				blnFlag = false;
			}

	/*		// EditMode_BillingTrans_role
			if (cnf.FnExplicitWait("XPATH", mbo.EditMode_BillingTrans_role)) {
				WebElement EditMode_BillingTrans_role = driver.findElement(By.xpath(mbo.EditMode_BillingTrans_role));
				repfn.FnUpdateTestStepResHTML("Verify Billing and Transaction Role  is displayed in the dropdown "," Billing and Transaction Role  is displayed in the dropdown","PASS",runManagerInfoObj);
				blnFlag = true;
			} else {
				repfn.FnUpdateTestStepResHTML("Verify Billing and Transaction Role  is displayed in the dropdown "," Billing and Transaction Role  is not displayed in the dropdown","FAIL",runManagerInfoObj);
				blnFlag = false;
			}*/

			// EditMode_standardRole
			

		
			if (cnf.FnExplicitWait("XPATH", mbo.EditMode_standardRole,driver)) {
				WebElement EditMode_standardRole = driver.findElement(By.xpath(mbo.EditMode_standardRole));
				repfn.FnUpdateTestStepResHTML("Verify Standard Role  is displayed in the dropdown ","Standard Role  is displayed in the dropdown", "PASS",runManagerInfoObj);
				blnFlag = true;
			} else {
				repfn.FnUpdateTestStepResHTML("Verify Standard Role  is displayed in the dropdown "," Standard Role  is not displayed in the dropdown","FAIL",runManagerInfoObj);
				blnFlag = false;
			}

			// EditMode_DeleteLink
		
			
			if (cnf.FnExplicitWait("XPATH", mbo.EditMode_DeleteLink,driver)) {
				WebElement EditMode_DeleteLink = driver.findElement(By.xpath(mbo.EditMode_DeleteLink));
				repfn.FnUpdateTestStepResHTML("Verify Delete Link  is displayed "," Delete Link is displayed", "PASS",runManagerInfoObj);
				blnFlag = true;
			} else {
				repfn.FnUpdateTestStepResHTML("Verify  Delete Link   is displayed "," Delete Link  is not displayed", "FAIL",runManagerInfoObj);
				blnFlag = false;
			}

			// EditMode_SaveButton
			
			
			if (cnf.FnExplicitWait("XPATH", mbo.EditMode_SaveButton,driver)) {
				WebElement EditMode_SaveButton = driver.findElement(By.xpath(mbo.EditMode_SaveButton));
				repfn.FnUpdateTestStepResHTML("Verify Save Button  is displayed "," Save Button is displayed", "PASS",runManagerInfoObj);
				blnFlag = true;
			} else {
				repfn.FnUpdateTestStepResHTML("Verify  Save Button  is displayed "," Save Button  is not displayed", "FAIL",runManagerInfoObj);
				blnFlag = false;
			}
			// EditMode_CancelBtn

			if (cnf.FnExplicitWait("XPATH", mbo.EditMode_CancelBtn,driver)) {
				WebElement EditMode_CancelBtn = driver.findElement(By.xpath(mbo.EditMode_CancelBtn));
				cnf.JSClick(EditMode_CancelBtn,driver);
				repfn.FnUpdateTestStepResHTML("Verify Close Button is clicked ","Close Button is clicked", "PASS",runManagerInfoObj);
				blnFlag = true;
				Thread.sleep(1000);
			} else {
				repfn.FnUpdateTestStepResHTML("Verify Close Button is clicked ","Close Button is not clicked", "FAIL",runManagerInfoObj);
				blnFlag = false;
			}




		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			// repfn.FnUpdateTestStepResHTML("Verify the UI and all button for admin contact is displayed ","The UI and all button for admin contact is not dispayed  due to some exception ","FAIL",runManagerInfoObj);
			blnFlag = false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	public synchronized boolean FN_ManageUsers_Confirm(WebDriver driver, RunManagerInfo runManagerInfoObj)
	{
		try
		{
			Thread.sleep(2000);
			if(cnf.FnExplicitWait("XPATH", mbo.manageConfirmPopUp,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify if the confirm button is present", "confirm button is present", "PASS",runManagerInfoObj);
				WebElement close=driver.findElement(By.xpath(mbo.manageConfirmPopUp));
				if(cnf.JSClick(close,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify Click on confirm", "confirm button is clicked", "PASS",runManagerInfoObj);
					driver.navigate().refresh();
					Thread.sleep(2000);
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify Click on confirm", "confirm button is not clicked", "FAIL",runManagerInfoObj);
					blnFlag=false;	
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if the confirm button is present", "confirm button is not present", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}

		}
		catch(Exception e)
		{
			repfn.FnUpdateTestStepResHTML("Verify Click on confirm", "confirm button is not clicked due to some exception", "FAIL",runManagerInfoObj);
			blnFlag=false;	
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());	
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	public synchronized boolean FN_ManageUsers_close(WebDriver driver, RunManagerInfo runManagerInfoObj)
	{
		try
		{
			Thread.sleep(2000);
			if(cnf.FnExplicitWait("XPATH", mbo.ManageUsers_close,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify if the Close button is present", "close button is present", "PASS",runManagerInfoObj);
				WebElement close=driver.findElement(By.xpath(mbo.ManageUsers_close));
				if(cnf.JSClick(close,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify Click on Close", "Close button is clicked", "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify Click on Close", "Close button is not clicked", "FAIL",runManagerInfoObj);
					blnFlag=false;	
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if the Close button is present", "close button is not present", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}

		}
		catch(Exception e)
		{
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			repfn.FnUpdateTestStepResHTML("Verify Click on Close", "Close button is not clicked due to some exception", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	public synchronized boolean FN_ManageUsers_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj)
	{
		try
		{
			if(cnf.FnExplicitWait("XPATH", mbo.manageCancelPopUp,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify if the Cancel button is present", "Cancel button is present", "PASS",runManagerInfoObj);
				WebElement close=driver.findElement(By.xpath(mbo.manageCancelPopUp));
				if(cnf.JSClick(close,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify Click on Cancel", "Cancel button is clicked", "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify Click on Cancel", "Cancel button is not clicked", "FAIL",runManagerInfoObj);
					blnFlag=false;	
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if the Cancel button is present", "Cancel button is not present", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}

		}
		catch(Exception e)
		{
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			repfn.FnUpdateTestStepResHTML("Verify Click on Cancel", "Cancel button is not clicked due to some exception", "FAIL",runManagerInfoObj);
			blnFlag=false;	
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	public synchronized boolean FnManageUsersEditUser_ModifyInfo(WebDriver driver, RunManagerInfo runManagerInfoObj)
	{
		try
		{

			if(cnf.FnExplicitWait("ID", mbo.manageUsersFirstName,driver))
			{
				blnFlag=true;
				repfn.FnUpdateTestStepResHTML("Verify if user has navigated to edit user window", " User has navigated to edit user window", "PASS",runManagerInfoObj);
				String firstName=driver.findElement(By.id(mbo.manageUsersFirstName)).getAttribute("value");
				driver.findElement(By.id(mbo.manageUsersFirstName)).clear();
				int RandomInt=randomInt;
				Random_int_validation=firstName+RandomInt;
				driver.findElement(By.id(mbo.manageUsersFirstName)).sendKeys(Random_int_validation);
				repfn.FnUpdateTestStepResHTML("Verify if user is able to modify first name", " User is able to modify first name: "+Random_int_validation, "PASS",runManagerInfoObj);
			}
			else
			{
				blnFlag=false;
				repfn.FnUpdateTestStepResHTML("Verify if user has navigated to edit user window", " User has not navigated to edit user window", "PASS",runManagerInfoObj);
				repfn.FnUpdateTestStepResHTML("Verify if user is able to modify first name", " User is not able to modify first name: "+Random_int_validation, "FAIL",runManagerInfoObj);
			}
		}
		catch(Exception e)
		{
			blnFlag=false;
			repfn.FnUpdateTestStepResHTML("Verify that the Account Owner/ Administrator user is able to create a New User", "Account Owner/ Administrator user is not able to create a New User due to some exception", "FAIL",runManagerInfoObj);
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	public synchronized boolean fnManageVoiceBack(WebDriver driver, RunManagerInfo runManagerInfoObj) {
		try {
			
			boolean tab = app.FnCheckVoiceTab(driver,runManagerInfoObj);
			if(tab){
				if (cnf.FnExplicitWait("XPATH", mbo.manageVoiceLineButton,driver)) {	
					repfn.FnUpdateTestStepResHTML("Verify if \"Add voice line\" button is present", "\"Add voice line\" button is present", "PASS",runManagerInfoObj);
					WebElement addVoiceLine=driver.findElement(By.xpath(mbo.manageVoiceLineButton));
					if(cnf.JSClick(addVoiceLine,driver)){
						repfn.FnUpdateTestStepResHTML("Verify if \"Add voice line\" button is clicked", "\"Add voice line\" button is clicked", "PASS",runManagerInfoObj);
						if(cnf.FnExplicitWait("XPATH", mbo.VoiceLineValue,driver))
						{
							WebElement VoiceLineValue=driver.findElement(By.xpath(mbo.VoiceLineValue));
							repfn.FnUpdateTestStepResHTML("Verify Voice line is added", "Voice line is added: "+VoiceLineValue.getText(), "PASS",runManagerInfoObj);
							blnFlag=app.FnClickBackButton(driver,runManagerInfoObj);
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Voice line is added", "Voice line is not added", "FAIL",runManagerInfoObj);
							blnFlag = false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify if \"Add voice line\" button is clicked", "\"Add voice line\" button is not clicked", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				} 
				else {			
					if(cnf.FnExplicitWait("XPATH", mbo.NoVoiceLines,driver)) {
						WebElement NoVoiceLinesmsg=driver.findElement(By.xpath(mbo.NoVoiceLinesmsg));
						String msg=NoVoiceLinesmsg.getText();
						repfn.FnUpdateTestStepResHTML("Verify if any voice line is present or not","No voice line button is  present as message displayed is: "+msg, "PASS",runManagerInfoObj);

						boolean blnFlag1 = app.FnUnassignVoiceLineAndReturn(driver,runManagerInfoObj);
						if(blnFlag1){
							boolean blnFlag2 = fnManageVoiceBack(driver,runManagerInfoObj);
							if(blnFlag2){
								blnFlag = true;
							}
							else{
								blnFlag = false;
							}					
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User is able to unassign Voice Line and Return to adding a new user","User is not able to unassign Voice Line and Return to adding a new user", "FAIL",runManagerInfoObj);
							blnFlag = false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify No Voice line warning message is displayed","No Voice line warning message is not displayed", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
			}
			else{
				boolean blnFlag3=app.FnClickBackButton(driver,runManagerInfoObj);
				if(blnFlag3){
					blnFlag = true;
				}
				else{
					blnFlag = false;
				}
			}

		} 
		
		catch (Exception e) {
			blnFlag = false;
			repfn.FnUpdateTestStepResHTML(
					"Verify that the Account Owner/ Administrator user is able to create a New User",
					"Account Owner/ Administrator user is not able to create a New User due to some exception",
					"FAIL",runManagerInfoObj);
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}


public synchronized boolean FnGetManageUsersList(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
	
	try{

		if(cnf.FnExplicitWait("XPATH",mbo.ManageUsers_RoleList,driver)){
			repfn.FnUpdateTestStepResHTML("Verify All users are displayed on Manage User Page", "All users are displayed on Manage User Page","PASS",runManagerInfoObj);
			List<WebElement> ManageUsers_RoleList=driver.findElements(By.xpath(mbo.ManageUsers_RoleList));
			List <WebElement> Users = new ArrayList<WebElement>();
			for(WebElement UserRole:ManageUsers_RoleList){
				
				if(UserRole.getText().contains("Standard") || UserRole.getText().contains("Billing and Transactions")){
					Users.add(UserRole);
				}
			}
			
			if(Users.size() > 0){
				repfn.FnUpdateTestStepResHTML("Verify Users with Role as \"Standard\" or \"Billing and Transactions\" are displayed on Manage User Page", 
						"Users with Role as \"Standard\" or \"Billing and Transactions\" are displayed on Manage User Page","PASS",runManagerInfoObj);
				
				WebElement User = Users.get(0);
				if(cnf.JSClick(User,driver)){
					repfn.FnUpdateTestStepResHTML("Verify a User is selected on Manage Users page", "A User is selected on Manage Users page","PASS",runManagerInfoObj);
					Thread.sleep(2000);
					
					if(cnf.FnExplicitWait("XPATH",mbo.UserDetailpopup,driver)){
						 repfn.FnUpdateTestStepResHTML("Verify Details Information Screen is displayed for the selected phone line", "Details Information Screen is displayed for the selected phone line","PASS",runManagerInfoObj);
						 Thread.sleep(3000);
						 blnFlag = true;
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify Details Information Screen is displayed for the selected phone line", "Details Information Screen is not displayed for the selected phone line","FAIL",runManagerInfoObj);
						 blnFlag = false;
					 }
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify a User is selected on Manage Users page", "A User is not selected on Manage Users page","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Users with Role as \"Standard\" or \"Billing and Transactions\" are displayed on Manage User Page", 
						"Users with Role as \"Standard\" or \"Billing and Transactions\" are not displayed on Manage User Page. New user needs to be added","PASS",runManagerInfoObj);
				boolean blnFlag1 = app.FN_AddNewUser(driver,runManagerInfoObj);
				if(blnFlag1){
					boolean blnFlag2 = FnGetManageUsersList(driver,runManagerInfoObj);
					if(blnFlag2){
						blnFlag = true;
					}
					else{
						blnFlag = false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify New user is added","New user is not added","FAIL",runManagerInfoObj);
					blnFlag = false;
				}
			}			
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify All users are displayed on Manage User Page", "All users are not displayed on Manage User Page. ","FAIL",runManagerInfoObj);
			blnFlag	=false;
		}
	}
	
	catch(Exception e)
	{
		repfn.FnUpdateTestStepResHTML("Verify Contact is present in Contacts List ", "Contact is not present in Contacts List  due to some exception","FAIL",runManagerInfoObj);
		blnFlag	=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}

	m1.put("STEPSTATUS", blnFlag);
	return blnFlag; 
	
}
public synchronized boolean FnManageUsersEditUser_ModifyContactInformation(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
{
	String firstName=null;
	String lastName=null;
	String phoneNumber=null;
	String emailAddress=null;
	try
	{
		if(cnf.FnExplicitWait("XPATH", mbo.manageUsersListInManageUsers,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify if list of users is displayed", "List of users is displayed", "PASS",runManagerInfoObj);
			List <WebElement> manageUsersList=driver.findElements(By.xpath(mbo.manageUsersListInManageUsers));
			
			Thread.sleep(5000);
			if(cnf.JSClick(manageUsersList.get(0),driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify A User is selected from the Users List", "A User is selected from the Users List", "PASS",runManagerInfoObj);
				Thread.sleep(7000);
				if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver))	
				{
					repfn.FnUpdateTestStepResHTML("Verify User is navigated to User Details window", "User is navigated to User Details window", "PASS",runManagerInfoObj);
					if(cnf.FnExplicitWait("XPATH", mbo.manageUsersEditLink,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Edit link is displayed", "Edit link is displayed", "PASS",runManagerInfoObj);
						WebElement editLink=driver.findElement(By.xpath(mbo.manageUsersEditLink));
						if(cnf.JSClick(editLink,driver))
						{
							repfn.FnUpdateTestStepResHTML("Verify Edit link is clicked", "Edit link is clicked", "PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("ID", mbo.manageUsersFirstName,driver))
							{
								repfn.FnUpdateTestStepResHTML("Verify First Name Input field is displayed", "First Name Input field is displayed", "PASS",runManagerInfoObj);
								String firstNametemp=driver.findElement(By.id(mbo.manageUsersFirstName)).getAttribute("value");
								driver.findElement(By.id(mbo.manageUsersFirstName)).clear();
								int RandomInt=randomInt;
								firstName = firstNametemp+RandomInt;
								driver.findElement(By.id(mbo.manageUsersFirstName)).sendKeys(firstName);
								repfn.FnUpdateTestStepResHTML("Verify First Name is modified", "First Name is modified. New value is: "+firstName, "PASS",runManagerInfoObj);
								blnFlag=true;								
							}
							else
							{
								blnFlag=false;
								repfn.FnUpdateTestStepResHTML("Verify First Name Input field is displayed", "First Name Input field is not displayed", "FAIL",runManagerInfoObj);
							}
							
							if(cnf.FnExplicitWait("ID", mbo.manageUsersLastName,driver))
							{
								repfn.FnUpdateTestStepResHTML("Verify Last Name Input field is displayed", "Last Name Input field is displayed", "PASS",runManagerInfoObj);
								String lastNameTemp=driver.findElement(By.id(mbo.manageUsersLastName)).getAttribute("value");
								driver.findElement(By.id(mbo.manageUsersLastName)).clear();
								int RandomInt=randomInt;
								lastName=lastNameTemp+RandomInt;
								driver.findElement(By.id(mbo.manageUsersLastName)).sendKeys(lastName);
								repfn.FnUpdateTestStepResHTML("Verify Last Name is modified", "Last Name is modified. New value is: "+lastName, "PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else
							{
								blnFlag=false;
								repfn.FnUpdateTestStepResHTML("Verify Last Name Input field is displayed", "Last Name Input field is not displayed", "FAIL",runManagerInfoObj);
							}
							
							if(cnf.FnExplicitWait("ID", mbo.managePhoneNumber,driver))
							{
								repfn.FnUpdateTestStepResHTML("Verify Phone Number Input field is displayed", "Phone Number Input field is displayed", "PASS",runManagerInfoObj);
								String PhoneNumberTemp=driver.findElement(By.id(mbo.managePhoneNumber)).getAttribute("value");
								driver.findElement(By.id(mbo.managePhoneNumber)).clear();
								int RandomInt=randomInt;
								int randomIntTemp=(String.valueOf(RandomInt).length())<4?2587:RandomInt;
								phoneNumber="932"+randomIntTemp+"545";
								driver.findElement(By.id(mbo.managePhoneNumber)).sendKeys(phoneNumber);
								repfn.FnUpdateTestStepResHTML("Verify Phone Number is modified", " Phone Number is modified. New value is: "+phoneNumber, "PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else
							{
								blnFlag=false;
								repfn.FnUpdateTestStepResHTML("Verify Phone Number Input field is displayed", "Phone Number Input field is not displayed", "FAIL",runManagerInfoObj);
							}
							
							if(cnf.FnExplicitWait("ID", mbo.manageUsersEmailAddress,driver))
							{
								repfn.FnUpdateTestStepResHTML("Verify Email Address Input field is displayed", "Email Address Input field is displayed", "PASS",runManagerInfoObj);
								String emailAddressTemp=driver.findElement(By.id(mbo.manageUsersEmailAddress)).getAttribute("value");
								String[] emailAddressArray=emailAddressTemp.split("@");
								System.out.println("-------Array String------"+emailAddressArray[0]+" "+emailAddressArray[1]);
								String emailAddressBeforeAt=emailAddressArray[0];
								String emailAddressAfterAt=emailAddressArray[1];
								driver.findElement(By.id(mbo.manageUsersEmailAddress)).clear();
								int RandomInt=randomInt;
								emailAddress=emailAddressBeforeAt+RandomInt+"@"+emailAddressAfterAt;
								driver.findElement(By.id(mbo.manageUsersEmailAddress)).sendKeys(emailAddress,Keys.TAB);
								Thread.sleep(2000);
								repfn.FnUpdateTestStepResHTML("Verify Email Address is modified", " Email Address is modified. New value is: "+emailAddress, "PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Email Address Input field is displayed", "Email Address Input field is not displayed", "FAIL",runManagerInfoObj);
								blnFlag=false;
							}
							
							if(cnf.FnExplicitWait("XPATH", mbo.manageSaveButton,driver))
							{
								repfn.FnUpdateTestStepResHTML("Verify if Save button is displayed", "Save button is displayed", "PASS",runManagerInfoObj);
								WebElement saveButton=driver.findElement(By.xpath(mbo.manageSaveButton));
								if(cnf.JSClick(saveButton,driver)){
									repfn.FnUpdateTestStepResHTML("Verify if Save button is clicked", "Save button is clicked", "PASS",runManagerInfoObj);
									Thread.sleep(5000);
									
									if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver))	
									{
										repfn.FnUpdateTestStepResHTML("Verify User is navigated back to User Details window", "User is navigated back to User Details window", "PASS",runManagerInfoObj);
										if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_UneditableAliasName,driver))	
										{
											WebElement NameElement=driver.findElement(By.xpath(mbo.ManageLine_UneditableAliasName));
											String name = NameElement.getAttribute("textContent");
											if(name.contains(firstName))
											{
												repfn.FnUpdateTestStepResHTML("Verify User Contact is modified", "User Contact is modified. New Name is: "+firstName, "PASS",runManagerInfoObj);
												Thread.sleep(4000);
												if(cnf.FnExplicitWait("XPATH", mbo.manageBackLink,driver)){
													repfn.FnUpdateTestStepResHTML("Verify if Close link is present or not", " Close link is present", "PASS",runManagerInfoObj);
													WebElement closeLink=driver.findElement(By.xpath(mbo.manageBackLink));
													if(cnf.JSClick(closeLink,driver))
													{
														repfn.FnUpdateTestStepResHTML("Verify if Close link is clicked", " Close link is clicked", "PASS",runManagerInfoObj);
														Thread.sleep(5000);
														blnFlag=true;	
														driver.navigate().refresh();
													}
													else{
														repfn.FnUpdateTestStepResHTML("Verify if Close link is clicked", " Close link is not clicked", "FAIL",runManagerInfoObj);
														blnFlag=false;
													}
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify if Close link is present or not", " Close link is not present", "FAIL",runManagerInfoObj);
													blnFlag=false;
												}
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify User Contact is modified", "User Contact is not modified", "FAIL",runManagerInfoObj);
												blnFlag=false;
											}
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify User is navigated back to User Details window", "User is not navigated back to User Details window", "FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify if Save button is clicked", "Save button is not clicked", "FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify if Save button is displayed", "Save button is not displayed", "FAIL",runManagerInfoObj);
								blnFlag=false;
							}
							
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Edit link is clicked", "Edit link is not clicked", "FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Edit link is displayed", "Edit link is not displayed", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User is navigated to User Details window", "User is not navigated to User Details window", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}				
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify A User is selected from the Users List", "A User is not selected from the Users List", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify if list of users is displayed", "List of users is not displayed. User needs to be added", "PASS",runManagerInfoObj);
			boolean blnFlag1 = app.FN_AddNewUser(driver,runManagerInfoObj);
			if(blnFlag1){
				boolean blnFlag2 = FnManageUsersEditUser_ModifyContactInformation(driver,runManagerInfoObj);
				if(blnFlag2){
					blnFlag = true;
				}
				else{
					blnFlag = false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify New user is added","New user is not added","FAIL",runManagerInfoObj);
				blnFlag = false;
			}
		}
	}
	catch(Exception e)
	{
		blnFlag=false;
		repfn.FnUpdateTestStepResHTML("Verify User is able to modify Contact Information on Manage User page", "User is not able to modify Contact Information on Manage User page due to some exception", "FAIL",runManagerInfoObj);
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}

public synchronized boolean FnManageUsersEditUser_UserDetails(WebDriver driver, RunManagerInfo runManagerInfoObj)
{
	try
	{
		if(cnf.FnExplicitWait("XPATH", mbo.manageUsersListInManageUsers,driver))
		{
			blnFlag=true;
			repfn.FnUpdateTestStepResHTML("Verify if list of users is displayed", "List of users is displayed", "PASS",runManagerInfoObj);
			List <WebElement> manageUsersList=driver.findElements(By.xpath(mbo.manageUsersListInManageUsers));
			for(int i=0;i<manageUsersList.size();i++)
			{
				if(cnf.JSClick(manageUsersList.get(i),driver))
				{
					Thread.sleep(5000);
					blnFlag=true;
					repfn.FnUpdateTestStepResHTML("Verify if user is able to click on the list item", "User is able to click on the list item", "PASS",runManagerInfoObj);
					if(cnf.FnExplicitlessWait_untilClickable("XPATH", mbo.manageUsersEditLink,driver))	
					{
						blnFlag=true;
						repfn.FnUpdateTestStepResHTML("Verify if user has navigated to user details window", "User has navigated to user details window", "PASS",runManagerInfoObj);
						repfn.FnUpdateTestStepResHTML("Verify if User Details window is opened next to the list (in the same page as an embedded sub window) display with futher details on the selected user", "User Details window is opened next to the list (in the same page as an embedded sub window) display with futher details on the selected user", "PASS",runManagerInfoObj);
						WebElement backLink=driver.findElement(By.xpath(mbo.manageBackLink));
						if(cnf.JSClick(backLink,driver))
						{
							Thread.sleep(5000);
							blnFlag=true;
							repfn.FnUpdateTestStepResHTML("Verify if back link is clicked", " Back link is clicked", "PASS",runManagerInfoObj);
							break;
						}
						else
						{
							blnFlag=false;
							repfn.FnUpdateTestStepResHTML("Verify if back link is clicked", " Back link is not clicked", "FAIL",runManagerInfoObj);
						}
					}
					else
					{
						blnFlag=false;
						repfn.FnUpdateTestStepResHTML("Verify if user has navigated to user details window", "User has not navigated to user details window", "FAIL",runManagerInfoObj);
						repfn.FnUpdateTestStepResHTML("Verify if User Details window is opened next to the list (in the same page as an embedded sub window) display with futher details on the selected user", "User Details window is not opened next to the list (in the same page as an embedded sub window) display with futher details on the selected user", "FAIL",runManagerInfoObj);
					}
				}
				else
				{
					blnFlag=false;
					repfn.FnUpdateTestStepResHTML("Verify if user is able to click on the list item", "User is not able to click on the list item", "FAIL",runManagerInfoObj);
				}
			}
		}
		else
		{
			boolean blnFlag1 = app.FN_AddNewUser(driver,runManagerInfoObj);
			if(blnFlag1){
				boolean blnFlag2 = FnManageUsersEditUser_UserDetails(driver,runManagerInfoObj);
				if(blnFlag2){
					blnFlag = true;
				}
				else{
					blnFlag = false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify New user is added","New user is not added","FAIL",runManagerInfoObj);
				blnFlag = false;
			}
		}
	}
	catch(Exception e)
	{
		blnFlag=false;
		repfn.FnUpdateTestStepResHTML("Verify that the Account Owner/ Administrator user is able to create a New User", "Account Owner/ Administrator user is not able to create a New User due to some exception", "FAIL",runManagerInfoObj);
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean ManageUsers_FirstUserclick(WebDriver driver, RunManagerInfo runManagerInfoObj) {
	 try
	 {
		 if(cnf.FnExplicitWait("XPATH", mbo.manageUsersList,driver)){
			 repfn.FnUpdateTestStepResHTML("Verify User list is displayed","User list is displayed","PASS",runManagerInfoObj);
			 List<WebElement> manageUsersList=driver.findElements(By.xpath(mbo.manageUsersList));
			 if(manageUsersList.size() > 1){
				 if(cnf.JSClick(manageUsersList.get(1),driver))
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if user has clicked on list item ","User has clicked on list item","PASS",runManagerInfoObj);
					 blnFlag=true;
				 }
				 else
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if user has clicked on list item ","User has not clicked on list item","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 else{
					boolean blnFlag1 = app.FN_AddNewUser(driver,runManagerInfoObj);
					if(blnFlag1){
						boolean blnFlag2 = ManageUsers_FirstUserclick(driver,runManagerInfoObj);
						if(blnFlag2){
							blnFlag = true;
						}
						else{
							blnFlag = false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify New user is added","New user is not added","FAIL",runManagerInfoObj);
						blnFlag = false;
					}
			 }
		 }
		 else{
			 repfn.FnUpdateTestStepResHTML("Verify User list is displayed","User list is not displayed","FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }
	 }
	 catch (Exception e)

	 {
		 repfn.FnUpdateTestStepResHTML("Verify if user has clicked on list item ","User has not clicked on list item due to some exception","FAIL",runManagerInfoObj);
		 blnFlag=false;
		 System.err.println("Message : "+e.getMessage());
		 System.err.println("Cause : "+e.getCause());
	 }
	 m1.put("STEPSTATUS", blnFlag);
	 return blnFlag;
}



public synchronized boolean fnEditUserUniqueEmailID(WebDriver driver, RunManagerInfo runManagerInfoObj)
{
	
	String lastName=null;
	String phoneNumber=null;
	String emailAddress=null;
	String extractedEmailId=null;
	String emailAddressInDetail=null;
	try
	{
		if(cnf.FnExplicitWait("XPATH", mbo.manageUsersListInManageUsers,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify if list of users is displayed", "List of users is displayed", "PASS",runManagerInfoObj);
			List <WebElement> manageUsersList=driver.findElements(By.xpath(mbo.manageUsersListInManageUsers));
			if(manageUsersList.size() > 1){
				if(cnf.JSClick(manageUsersList.get(1),driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if user has clicked on the list to extract email id", "User has clicked on the list to extract email id", "PASS",runManagerInfoObj);
					Thread.sleep(5000);
					extractedEmailId=driver.findElement(By.xpath("(//div[@class='sb-detail__text-item ng-binding'])[2]")).getText();
					System.out.println("===Check====="+extractedEmailId);
					if(cnf.FnExplicitWait("XPATH", "//a[@ng-click='detailOptions.backFunction()']",driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify Back link is displayed", "Back link is displayed", "PASS",runManagerInfoObj);
						WebElement backLink=driver.findElement(By.xpath("//a[@ng-click='detailOptions.backFunction()']"));
						if(cnf.JSClick(backLink,driver))
						{
							Thread.sleep(5000);
							blnFlag=true;
							repfn.FnUpdateTestStepResHTML("Verify Back link is clicked", "Back link is clicked", "PASS",runManagerInfoObj);
						}
						else
						{
							blnFlag=false;
							repfn.FnUpdateTestStepResHTML("Verify Back link is clicked", "Back link is not clicked", "FAIL",runManagerInfoObj);
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Back link is displayed", "Back link is not displayed", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else
				{
					blnFlag=false;
					repfn.FnUpdateTestStepResHTML("Verify if user has clicked on the list to extract email id", "User has not clicked on the list to extract email id", "FAIL",runManagerInfoObj);
				}
				
				if(manageUsersList.size() > 2){
					if(cnf.JSClick(manageUsersList.get(2),driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify if user is able to click on the list item", "User is able to click on the list item", "PASS",runManagerInfoObj);
						if(cnf.FnExplicitlessWait_untilClickable("XPATH", mbo.manageUsersEditLink,driver))	
						{
							Thread.sleep(5000);
							emailAddressInDetail=driver.findElement(By.xpath("(//div[@class='sb-detail__text-item ng-binding'])[2]")).getText();
							System.out.println("========Check=========="+emailAddressInDetail);
							blnFlag=true;
							repfn.FnUpdateTestStepResHTML("Verify if user has navigated to user details window", "User has navigated to user details window", "PASS",runManagerInfoObj);
							WebElement editLink=driver.findElement(By.xpath(mbo.manageUsersEditLink));
							
							if(cnf.JSClick(editLink,driver))
							{
								Thread.sleep(5000);
								blnFlag=true;
								repfn.FnUpdateTestStepResHTML("Verify if user has clicked the edit link", "User has clicked the edit link", "PASS",runManagerInfoObj);
								
								if(cnf.FnExplicitWait("ID", mbo.manageUsersFirstName,driver))
								{
									blnFlag=true;
									repfn.FnUpdateTestStepResHTML("Verify if First name is displayed", " First name is displayed", "PASS",runManagerInfoObj);
								}
								else
								{
									blnFlag=false;
									repfn.FnUpdateTestStepResHTML("Verify if First name is displayed", " First name is not displayed", "FAIL",runManagerInfoObj);
								}
								
								if(cnf.FnExplicitWait("ID", mbo.manageUsersLastName,driver))
								{
									blnFlag=true;
									repfn.FnUpdateTestStepResHTML("Verify if Last name is displayed", " Last name is displayed", "PASS",runManagerInfoObj);
								}
								else
								{
									blnFlag=false;
									repfn.FnUpdateTestStepResHTML("Verify if Last name is displayed", " Last name is not displayed", "FAIL",runManagerInfoObj);
								}
								
								if(cnf.FnExplicitWait("ID", mbo.managePhoneNumber,driver))
								{
									blnFlag=true;
									repfn.FnUpdateTestStepResHTML("Verify if Contact number is displayed", " Contact number is displayed", "PASS",runManagerInfoObj);
								}
								else
								{
									blnFlag=false;
									repfn.FnUpdateTestStepResHTML("Verify if Contact number is displayed", " Contact number is not displayed", "FAIL",runManagerInfoObj);
								}
								
								if(cnf.FnExplicitWait("ID", mbo.manageUsersEmailAddress,driver))
								{
									repfn.FnUpdateTestStepResHTML("Verify if Email address is displayed", " Email address is displayed", "PASS",runManagerInfoObj);
									WebElement manageUsersEmailAddress=driver.findElement(By.id(mbo.manageUsersEmailAddress));
									manageUsersEmailAddress.clear();
									manageUsersEmailAddress.sendKeys(extractedEmailId,Keys.TAB);
									Thread.sleep(2000);
									repfn.FnUpdateTestStepResHTML("Verify if user has added email address of another user", "User has added email address of another user: "+extractedEmailId, "PASS",runManagerInfoObj);
									
									if(cnf.FnExplicitWait("XPATH", mbo.manageSaveButton,driver))
									{
										blnFlag=true;
										repfn.FnUpdateTestStepResHTML("Verify if save button is displayed", " Save button is displayed", "PASS",runManagerInfoObj);
										WebElement saveButton=driver.findElement(By.xpath(mbo.manageSaveButton));
										if(saveButton.isEnabled()){
											repfn.FnUpdateTestStepResHTML("Verify if save button is enabled", " Save button is enabled", "PASS",runManagerInfoObj);
											
											if(cnf.JSClick(saveButton,driver))
											{
												Thread.sleep(5000);
												blnFlag=true;
												repfn.FnUpdateTestStepResHTML("Verify if save button is clicked", " Save button is clicked", "PASS",runManagerInfoObj);
												Thread.sleep(3000);
												if(cnf.FnExplicitWait("XPATH","(//div[@class='sb-detail__text-item ng-binding'])[2]",driver)){
													WebElement emailAddVerify=driver.findElement(By.xpath("(//div[@class='sb-detail__text-item ng-binding'])[2]"));
													if(emailAddVerify.getText().contains(extractedEmailId))
													{
														blnFlag=true;
														repfn.FnUpdateTestStepResHTML("Verify if modified email ID is saved", " Modified email ID is saved: "+emailAddVerify.getText(), "PASS",runManagerInfoObj);
													}
													else
													{
														blnFlag=false;
														repfn.FnUpdateTestStepResHTML("Verify if modified email ID is saved", " Modified email ID is not saved: "+emailAddVerify.getText(), "FAIL",runManagerInfoObj);
													}
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify if Email id is displayed", " Email id is not displayed", "FAIL",runManagerInfoObj);
													blnFlag=false;
												}
												
												if(cnf.FnExplicitWait("XPATH", mbo.manageBackLink,driver))
												{
													WebElement backLink=driver.findElement(By.xpath(mbo.manageBackLink));
													if(cnf.JSClick(backLink,driver))
													{
														Thread.sleep(5000);
														blnFlag=true;
														repfn.FnUpdateTestStepResHTML("Verify if back link is clicked", " Back link is clicked", "PASS",runManagerInfoObj);
													}
													else
													{
														blnFlag=false;
														repfn.FnUpdateTestStepResHTML("Verify if back link is clicked", " Back link is not clicked", "FAIL",runManagerInfoObj);
													}
												}
												else{
													blnFlag=false;
													repfn.FnUpdateTestStepResHTML("Verify if back link is displayed", " Back link is not displayed", "FAIL",runManagerInfoObj);
												}												
											}
											else
											{
												blnFlag=false;
												repfn.FnUpdateTestStepResHTML("Verify if save button is clicked", " Save button is not clicked", "FAIL",runManagerInfoObj);
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify if save button is enabled", " Save button is not enabled", "FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else
									{
										blnFlag=false;
										repfn.FnUpdateTestStepResHTML("Verify if save button is displayed", " Save button is not displayed", "FAIL",runManagerInfoObj);
									}
								}
								else
								{
									blnFlag=false;
									repfn.FnUpdateTestStepResHTML("Verify if Email address is displayed", " Email address is not displayed", "FAIL",runManagerInfoObj);
								}
							}
							else
							{
								blnFlag=false;
								repfn.FnUpdateTestStepResHTML("Verify if user has clicked the edit link", "User has not clicked the edit link", "FAIL",runManagerInfoObj);
							}
						}
						else
						{
							blnFlag=false;
							repfn.FnUpdateTestStepResHTML("Verify if user has navigated to user details window", "User has not navigated to user details window", "FAIL",runManagerInfoObj);
						}
					}
					else
					{
						blnFlag=false;
						repfn.FnUpdateTestStepResHTML("Verify if user is able to click on the list item", "User is not able to click on the list item", "FAIL",runManagerInfoObj);
					}
				}
				else{
					boolean blnFlag1 = app.FN_AddNewUser(driver,runManagerInfoObj);
					if(blnFlag1){
						boolean blnFlag2 = fnEditUserUniqueEmailID(driver,runManagerInfoObj);
						if(blnFlag2){
							blnFlag = true;
						}
						else{
							blnFlag = false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify New user is added","New user is not added","FAIL",runManagerInfoObj);
						blnFlag = false;
					}
				}
			}
			else{
				boolean blnFlag1 = app.FN_AddNewUser(driver,runManagerInfoObj);
				if(blnFlag1){
					boolean blnFlag2 = fnEditUserUniqueEmailID(driver,runManagerInfoObj);
					if(blnFlag2){
						blnFlag = true;
					}
					else{
						blnFlag = false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify New user is added","New user is not added","FAIL",runManagerInfoObj);
					blnFlag = false;
				}
			}
		}
		else{
			blnFlag=false;
			repfn.FnUpdateTestStepResHTML("Verify if list of users is displayed", "List of users is not displayed", "FAIL",runManagerInfoObj);
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
public synchronized boolean fnManageUsersSearch(WebDriver driver, RunManagerInfo runManagerInfoObj)
{
	List<String> userNameListInString=new ArrayList<String>();
	List<String> userRoleListInString=new ArrayList<String>();
	String searchName=null;
	String searchRole=null;
	String searchEmail=null;
	
	try
	{
		if(cnf.FnExplicitWait("XPATH", mbo.manageUserNameList,driver)){
			List<WebElement> manageUserNameList=driver.findElements(By.xpath(mbo.manageUserNameList));
			if(manageUserNameList.size() > 1){
				if(cnf.FnExplicitWait("XPATH", mbo.manageusersTitle,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if \"Manage Users\" title is present ", "\"Manage Users\" title is present ", "PASS",runManagerInfoObj);
					List<WebElement> userNameList=driver.findElements(By.xpath(mbo.manageUserNameList));
					List<WebElement> userRoleList=driver.findElements(By.xpath(mbo.manageUsersRoleList));
					for(int i=0;i<userNameList.size();i++)
					{
						userNameListInString.add(userNameList.get(i).getText());
						userRoleListInString.add(userRoleList.get(i).getText());
					}
					
					if(cnf.FnExplicitWait("XPATH", mbo.manageAddNewUser,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify if \"Add New User\" button is present ", "\"Add New User\" button is present ", "PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						blnFlag=false;
						repfn.FnUpdateTestStepResHTML("Verify if \"Add New User\" button is present ", "\"Add New User\" button is not present ", "FAIL",runManagerInfoObj);
					}
					
					if(cnf.FnExplicitWait("XPATH", mbo.manageusersSearch,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify if \"Search bar\" with default text is present", "\"Search bar\" with default text is present", "PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						blnFlag=false;
						repfn.FnUpdateTestStepResHTML("Verify if \"Search bar\" with default text is present", "\"Search bar\" with default text is not present", "FAIL",runManagerInfoObj);
					}
					
					if(cnf.FnExplicitWait("XPATH", mbo.manageUsersListInManageUsers,driver))
					{
						List<WebElement> manageUsersList=driver.findElements(By.xpath(mbo.manageUsersListInManageUsers));
						if(!manageUsersList.isEmpty())
						{
							blnFlag=true;
							repfn.FnUpdateTestStepResHTML("Verify if list of users with name & role  and services are present", "List of users with name & role  and services are present", "PASS",runManagerInfoObj);
						}
						else
						{
							blnFlag=false;
							repfn.FnUpdateTestStepResHTML("Verify if list of users with name & role  and services are present", "List of users with name & role  and services are not present", "FAIL",runManagerInfoObj);
						}
					}
					else
					{
						blnFlag=false;
						repfn.FnUpdateTestStepResHTML("Verify if list of users with name & role  and services are present", "List of users with name & role  and services are not present", "FAIL",runManagerInfoObj);
					}
					
					if(cnf.FnExplicitlessWait_untilClickable("XPATH", mbo.manageusersSearch,driver))
					{
						WebElement searchUserByName=driver.findElement(By.xpath(mbo.manageusersSearch));

						for(int i=0;i<userNameListInString.size();i++)
						{
							if(Pattern.matches(".*[a-zA-Z]+.*", userNameListInString.get(i)))
							{
								searchName=userNameListInString.get(i);
							}
						}
						
						searchUserByName.sendKeys(searchName,Keys.TAB);
						Thread.sleep(5000);
						repfn.FnUpdateTestStepResHTML("Verify if user is able to enter the search text in search bar by name", "User is able to enter the search text in search bar by name: "+searchName, "PASS",runManagerInfoObj);
						
						if(cnf.FnExplicitWait("XPATH", mbo.manageUserNameList,driver))
						{
							List<WebElement> filteredUserName=driver.findElements(By.xpath(mbo.manageUserNameList));
							List<String> filteredUserNameInString=new ArrayList<String>();
							for(WebElement web : filteredUserName) {
								filteredUserNameInString.add(web.getText());
							}
							
							if(userNameListInString.containsAll(filteredUserNameInString))
							{
								blnFlag=true;
								repfn.FnUpdateTestStepResHTML("Verify if search by name is successfull", "Search by name is successfull: "+searchName, "PASS",runManagerInfoObj);
							}
							else
							{
								blnFlag=false;
								repfn.FnUpdateTestStepResHTML("Verify if search by name is successfull", "Search by name is not successfull: "+searchName, "FAIL",runManagerInfoObj);
							}
						}
						else
						{
							blnFlag=false;
							repfn.FnUpdateTestStepResHTML("Verify if search by name is successfull", "Search by name is not successfull: "+searchName, "FAIL",runManagerInfoObj);
						}
						
						if(cnf.FnExplicitlessWait_untilClickable("XPATH", mbo.manageSearchClear,driver))
						{
							blnFlag=true;
							repfn.FnUpdateTestStepResHTML("Verify if user is displayed with \"X\" icon to clear search field ", "User is displayed with \"X\" icon to clear search field", "PASS",runManagerInfoObj);
							WebElement clearIcon=driver.findElement(By.xpath(mbo.manageSearchClear));
							if(cnf.JSClick(clearIcon,driver))
							{
								Thread.sleep(5000);
								blnFlag=true;
								repfn.FnUpdateTestStepResHTML("Verify if user has clicked on clear icon ", "User has clicked on clear icon", "PASS",runManagerInfoObj);
							}
							else
							{
								blnFlag=false;
								repfn.FnUpdateTestStepResHTML("Verify if user has clicked on clear icon ", "User has not clicked on clear icon", "FAIL",runManagerInfoObj);
							}
							driver.navigate().refresh();
						}
						else
						{
							blnFlag=false;
							repfn.FnUpdateTestStepResHTML("Verify if user is displayed with \"X\" icon to clear search field ", "User is not displayed with \"X\" icon to clear search field", "FAIL",runManagerInfoObj);
						}
					}
					else{
						blnFlag=false;
						repfn.FnUpdateTestStepResHTML("Verify if Search bar is displayed ", "Search bar is not displayed", "FAIL",runManagerInfoObj);
					}
					
					if(cnf.FnExplicitWait("XPATH", mbo.manageusersSearch,driver))
					{
						WebElement searchUserByRole=driver.findElement(By.xpath(mbo.manageusersSearch));
						searchRole=userRoleListInString.get(1);
						searchUserByRole.clear();
						searchUserByRole.sendKeys(searchRole,Keys.TAB);
						Thread.sleep(5000);
						repfn.FnUpdateTestStepResHTML("Verify if user is able to enter the search text in search bar by role", "User is able to enter the search text in search bar by role: "+searchRole, "PASS",runManagerInfoObj);
						
						if(cnf.FnExplicitWait("XPATH", mbo.manageUserNameList,driver))
						{
							List<WebElement> filteredRole=driver.findElements(By.xpath(mbo.manageUsersRoleList));
							List<String> filteredRoleInString=new ArrayList<String>();
							for(WebElement web : filteredRole) {
								filteredRoleInString.add(web.getText());
							}
							
							if(userRoleListInString.containsAll(filteredRoleInString))
							{
								blnFlag=true;
								repfn.FnUpdateTestStepResHTML("Verify if search by role is successfull", "Search by role is successfull: "+searchRole, "PASS",runManagerInfoObj);
							}
							else
							{
								blnFlag=false;
								repfn.FnUpdateTestStepResHTML("Verify if search by role is successfull", "Search by role is not successfull: "+searchRole, "FAIL",runManagerInfoObj);
							}
						}
						else
						{
							blnFlag=false;
							repfn.FnUpdateTestStepResHTML("Verify if search by role is successfull", "Search by role is not successfull: "+searchRole, "FAIL",runManagerInfoObj);
						}
						
						if(cnf.FnExplicitlessWait_untilClickable("XPATH", mbo.manageSearchClear,driver))
						{
							blnFlag=true;
							repfn.FnUpdateTestStepResHTML("Verify if user is displayed with \"X\" icon to clear search field ", "User is displayed with \"X\" icon to clear search field", "PASS",runManagerInfoObj);
							WebElement clearIcon=driver.findElement(By.xpath(mbo.manageSearchClear));
							if(cnf.JSClick(clearIcon,driver))
							{
								Thread.sleep(5000);
								blnFlag=true;
								repfn.FnUpdateTestStepResHTML("Verify if user has clicked on clear icon ", "User has clicked on clear icon", "PASS",runManagerInfoObj);
							}
							else
							{
								blnFlag=false;
								repfn.FnUpdateTestStepResHTML("Verify if user has clicked on clear icon ", "User has not clicked on clear icon", "FAIL",runManagerInfoObj);
							}
							driver.navigate().refresh();
						}
						else
						{
							blnFlag=false;
							repfn.FnUpdateTestStepResHTML("Verify if user is displayed with \"X\" icon to clear search field ", "User is not displayed with \"X\" icon to clear search field", "FAIL",runManagerInfoObj);
						}
					}
					else{
						blnFlag=false;
						repfn.FnUpdateTestStepResHTML("Verify if Search bar is displayed ", "Search bar is not displayed", "FAIL",runManagerInfoObj);
					}
					
					if(cnf.FnExplicitlessWait_untilClickable("XPATH", mbo.manageUsersListInManageUsers,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify if list of users is displayed", "List of users is displayed", "PASS",runManagerInfoObj);
						List<WebElement> manageUsersListInManageUsersOne=driver.findElements(By.xpath(mbo.manageUsersListInManageUsers));
						WebElement user = manageUsersListInManageUsersOne.get(1);
						if(cnf.JSClick(user,driver))
						{
							repfn.FnUpdateTestStepResHTML("Verify if user has clicked on the list ", "User has clicked on the list", "PASS",runManagerInfoObj);
							Thread.sleep(3000);
							searchName=driver.findElement(By.xpath("(//div[@class='sb-detail__text-item ng-binding'])[1]")).getText();
							searchEmail=driver.findElement(By.xpath("(//div[@class='sb-detail__text-item ng-binding'])[2]")).getText();
							System.out.println("Email: "+searchEmail);
							
							if(cnf.FnExplicitWait("XPATH", "//a[@ng-click='detailOptions.backFunction()']",driver))
							{
								WebElement backLink=driver.findElement(By.xpath("//a[@ng-click='detailOptions.backFunction()']"));
								if(cnf.JSClick(backLink,driver))
								{
									repfn.FnUpdateTestStepResHTML("Verify if Back link is clicked", "Back link is clicked", "PASS",runManagerInfoObj);
									
									if(cnf.FnExplicitWait("XPATH", mbo.manageusersSearch,driver))
									{
										WebElement searchUserByEmail=driver.findElement(By.xpath(mbo.manageusersSearch));
										searchUserByEmail.clear();
										searchUserByEmail.sendKeys(searchEmail,Keys.TAB);
										Thread.sleep(5000);
										repfn.FnUpdateTestStepResHTML("Verify if user is able to enter the search text in search bar by email", "User is able to enter the search text in search bar by email: "+searchEmail, "PASS",runManagerInfoObj);
										for(String name: userNameListInString)
										{
											if(name.equalsIgnoreCase(searchName))
											{
												blnFlag=true;
											}
										}
										
										if(blnFlag)
										{
											blnFlag=true;
											repfn.FnUpdateTestStepResHTML("Verify if search by email is successfull", "Search by email is successfull ", "PASS",runManagerInfoObj);
										}
										else
										{
											blnFlag=false;
											repfn.FnUpdateTestStepResHTML("Verify if search by email is successfull", "Search by email is not successfull ", "FAIL",runManagerInfoObj);
										}
										
										if(cnf.FnExplicitlessWait_untilClickable("XPATH", mbo.manageSearchClear,driver))
										{
											blnFlag=true;
											repfn.FnUpdateTestStepResHTML("Verify if user is displayed with \"X\" icon to clear search field ", "User is displayed with \"X\" icon to clear search field", "PASS",runManagerInfoObj);
											WebElement clearIcon=driver.findElement(By.xpath(mbo.manageSearchClear));
											if(cnf.JSClick(clearIcon,driver))
											{
												Thread.sleep(5000);
												blnFlag=true;
												repfn.FnUpdateTestStepResHTML("Verify if user has clicked on clear icon ", "User has clicked on clear icon", "PASS",runManagerInfoObj);
											}
											else
											{
												blnFlag=false;
												repfn.FnUpdateTestStepResHTML("Verify if user has clicked on clear icon ", "User has not clicked on clear icon", "FAIL",runManagerInfoObj);
											}

										}
										else
										{
											blnFlag=false;
											repfn.FnUpdateTestStepResHTML("Verify if user is displayed with \"X\" icon to clear search field ", "User is not displayed with \"X\" icon to clear search field", "FAIL",runManagerInfoObj);
										}
									}
									else{
										blnFlag=false;
										repfn.FnUpdateTestStepResHTML("Verify if Search bar is displayed ", "Search bar is not displayed", "FAIL",runManagerInfoObj);
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify if Back link is clicked", "Back link is not clicked", "FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								blnFlag=false;
								repfn.FnUpdateTestStepResHTML("Verify if Back link is displayed", "Back link is not displayed", "FAIL",runManagerInfoObj);
							}
						}
						else{
							blnFlag=false;
							repfn.FnUpdateTestStepResHTML("Verify if user has clicked on the list ", "User has not clicked on the list", "FAIL",runManagerInfoObj);
						}

					}
					else
					{
						blnFlag=false;
						repfn.FnUpdateTestStepResHTML("Verify if list of users is displayed", "List of users is not displayed", "FAIL",runManagerInfoObj);
					}			
				}
				else
				{
					blnFlag=false;
					repfn.FnUpdateTestStepResHTML("Verify if \"Manage Users\" title is present ", "\"Manage Users\" title is present ", "FAIL",runManagerInfoObj);
				}
			}
			else{
				boolean blnFlag1 = app.FN_AddNewUser(driver,runManagerInfoObj);
				if(blnFlag1){
					boolean blnFlag2 = fnManageUsersSearch(driver,runManagerInfoObj);
					if(blnFlag2){
						blnFlag = true;
					}
					else{
						blnFlag = false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify New user is added","New user is not added","FAIL",runManagerInfoObj);
					blnFlag = false;
				}
			}
		}
		else
		{
			blnFlag=false;
			repfn.FnUpdateTestStepResHTML("Verify if list of users is displayed", "List of users is not displayed", "FAIL",runManagerInfoObj);
		}

	}
	catch(Exception e)
	{
		blnFlag=false;
		repfn.FnUpdateTestStepResHTML("Verify that the Account Owner/ Administrator user is able to create a New User", "Account Owner/ Administrator user is not able to create a New User due to some exception", "FAIL",runManagerInfoObj);
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean FN_AdminPermissionclick(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
	 try{
		 
		 if(cnf.FnExplicitWait("XPATH",mbo.AddStepsListHeading,driver)){
				WebElement AddStepsListHeading = driver.findElement(By.xpath(mbo.AddStepsListHeading));
				if(AddStepsListHeading.getText().contains("Set User Role")){
					repfn.FnUpdateTestStepResHTML("Verify User is on Role tab", "User is on Role tab","PASS",runManagerInfoObj);
					
					if(cnf.FnExplicitWait("Xpath", mbo.AddUserAdminRadioButton,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Admin User Radio button is displayed", "Admin User Radio button is displayed","PASS",runManagerInfoObj);
						WebElement AddUserAdminRadioButton = driver.findElement(By.xpath(mbo.AddUserAdminRadioButton));
						if(cnf.JSClick(AddUserAdminRadioButton,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Admin User Radio button is clicked", "Admin User Radio button is clicked","PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Admin User Radio button is clicked", "Admin User Radio button is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Admin User Radio button is displayed", "Admin User Radio button is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User is on Role tab", "User is not on Role tab","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
		 }
	 }
	 catch (Exception e)

	 {
		 repfn.FnUpdateTestStepResHTML("Verify the 'Admin' permission radio button is displayed  and clicked ","Admin permission radio button is displayed  and clicked  due to some exception ","FAIL",runManagerInfoObj);
		 blnFlag=false;
		 System.err.println("Message : "+e.getMessage());
		 System.err.println("Cause : "+e.getCause());

	 }
	 m1.put("STEPSTATUS", blnFlag);
	 return blnFlag;

}



public synchronized boolean FN_AddNewUser_Admin(WebDriver driver, RunManagerInfo runManagerInfoObj) {

	try{
		boolean blnFlag1 = app.FN_addNewUserClick(driver,runManagerInfoObj);
		if(blnFlag1){
			boolean blnFlag2 = app.FNEnteringData_FN_LN_Email_phone(driver,runManagerInfoObj);
			if(blnFlag2){
				boolean blnFlag3 = app.FnNextbuttonClick(driver,runManagerInfoObj);
				if(blnFlag3){
					boolean blnFlag4 = FN_AdminPermissionclick(driver,runManagerInfoObj);
					if(blnFlag4){
						boolean blnFlag5 = app.FnNextbuttonClick(driver,runManagerInfoObj);
						if(blnFlag5){
							boolean tab = app.FnCheckVoiceTab(driver,runManagerInfoObj);
							if(tab){
								boolean blnFlag6 = app.fnManageVoice(driver,runManagerInfoObj);
								if(blnFlag6){
									boolean blnFlag7 = app.FnConfirmbuttonClick(driver,runManagerInfoObj);
									if(blnFlag7){
										blnFlag = true;
									}
									else{
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Voice line is added", "Voice line is not added", "FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								boolean blnFlag8 = app.FnConfirmbuttonClick(driver,runManagerInfoObj);
								if(blnFlag8){
									blnFlag = true;
								}
								else{
									blnFlag=false;
								}
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Next button is Clicked ","Next button is not Clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Admin User Radio button is clicked", "Admin User Radio button is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Next button is Clicked ","Next button is not Clicked","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify User is able to enter FirstName,LastName,Email address and Phonenumber ","User is  not able to enter FirstName,LastName,Email address and Phonenumber","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Add New User Link is Clicked ","Add New User Link is not Clicked","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}

	catch (Exception e) {
		repfn.FnUpdateTestStepResHTML("Verify New user is added","New user is not added due to some exception","FAIL",runManagerInfoObj);
		System.err.println("Message : " + e.getMessage());
		System.err.println("Cause : " + e.getCause());
		blnFlag = false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean FNManageusers_ResetPassword(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
	boolean blnFlag = false;
	try {
		String email=null;
		if (cnf.FnExplicitWait("XPATH", mbo.List_of_Users,driver)) {
			List<WebElement> User = driver.findElements(By.xpath(mbo.List_of_Users));
			
			Thread.sleep(5000);
			if (User.size() > 0) { // /1
				repfn.FnUpdateTestStepResHTML("Verify if Users are present on Manage Users page", "Users are present on Manage Users page","PASS",runManagerInfoObj);
				if (cnf.JSClick(User.get(0),driver)) { // ///2
					repfn.FnUpdateTestStepResHTML("Verify if User is getting clicked","User is getting clicked", "PASS",runManagerInfoObj);
					if (cnf.FnExplicitWait("Xpath", mbo.UserDetail_EditBtn,driver)) { // ///3
						repfn.FnUpdateTestStepResHTML("Verify Edit button is displayed ","Edit button is displayed ", "PASS",runManagerInfoObj);
						WebElement UserDetail_EditBtn = driver.findElement(By.xpath(mbo.UserDetail_EditBtn));
						if (cnf.JSClick(UserDetail_EditBtn,driver)) { // /4
							repfn.FnUpdateTestStepResHTML("Verify Edit button is clicked ","Edit button is clicked ", "PASS",runManagerInfoObj);

							if (cnf.FnExplicitWait("XPATH",mbo.EditMode_EmailId,driver)){	
								WebElement EditMode_EmailId = driver.findElement(By.xpath(mbo.EditMode_EmailId));
								email=EditMode_EmailId.getAttribute("value");
								repfn.FnUpdateTestStepResHTML("Verify if email is getting displayed on Edit Users Screen","Email is getting displayed on Edit Users Screen","PASS",runManagerInfoObj);

								Thread.sleep(7000);

								if (cnf.FnExplicitWait("XPATH",mbo.EditMode_SaveResetPassWordBtn,driver)) { // ///5
									repfn.FnUpdateTestStepResHTML("Verify if Reset Password Link is getting displayed","Reset Password Link is getting displayed","PASS",runManagerInfoObj);
									WebElement ResetPassword = driver.findElement(By.xpath(mbo.EditMode_SaveResetPassWordBtn));

									if (cnf.JSClick(ResetPassword,driver)) { // ///6
										repfn.FnUpdateTestStepResHTML("Verify if Reset Password Option is Clickable","Reset Password Option is clicked","PASS",runManagerInfoObj);
										// POPUP WILL COME ONLY IF RESET PASSWORD LINK IS CLICKED
										
										Thread.sleep(5000);
										if (cnf.FnExplicitWait("XPATH",mbo.ManageUsers_ResetPassword_Text,driver)) {
											repfn.FnUpdateTestStepResHTML("Verify if text is getting displayed in Reset Password popup","Text is getting displayed in Reset Password popup","PASS",runManagerInfoObj);
											WebElement ManageUsers_ResetPasswordPopup_Text = driver.findElement(By.xpath(mbo.ManageUsers_ResetPassword_Text));

											String text = ManageUsers_ResetPasswordPopup_Text.getText();
											if (text.equalsIgnoreCase("Thank You! A reset password link was successfully sent to "+email)) {
												repfn.FnUpdateTestStepResHTML("Verify if popup contains required text","Popup contains required text: "+text,"PASS",runManagerInfoObj);
												blnFlag=true;
											} else {
												repfn.FnUpdateTestStepResHTML("Verify if popup contains required text","Popup does not contain required text","FAIL",runManagerInfoObj);
												blnFlag = false;
											}

										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify if text is getting displayed in Reset Password popup","Text is not getting displayed in Reset Password popup","FAIL",runManagerInfoObj);
											blnFlag = false;
										}

										
									} else {
										repfn.FnUpdateTestStepResHTML("Verify if Reset Password Option is Clickable","Reset Password Option is not clicked","FAIL",runManagerInfoObj);
										blnFlag = false;
									}
								}
								else
								{
									repfn.FnUpdateTestStepResHTML("Verify if Reset Password Link is getting displayed","Reset Password Link is not getting displayed","FAIL",runManagerInfoObj);
									blnFlag = false;
								}
							}
							else {

								repfn.FnUpdateTestStepResHTML("Verify if email is getting displayed on Edit Users Screen","Email is not getting displayed on Edit Users Screen","FAIL",runManagerInfoObj);
								blnFlag = false;
							}
						}
						else
						{
							repfn.FnUpdateTestStepResHTML("Verify Edit button is clicked ","Edit button is not clicked ", "FAIL",runManagerInfoObj);
							blnFlag = false;
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify if Edit button is  displayed","Edit button is not getting displayed","FAIL",runManagerInfoObj);
						blnFlag = false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify if any User is getting clicked","User is not getting clicked ", "FAIL",runManagerInfoObj);
					blnFlag = false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify if Users are present on Manage Users page", "Users are not present on Manage Users page. New user needs to be added","PASS",runManagerInfoObj);
				boolean blnFlag1 = app.FN_AddNewUser(driver,runManagerInfoObj);
				if(blnFlag1){
					boolean blnFlag2 = FNManageusers_ResetPassword(driver,runManagerInfoObj);
					if(blnFlag2){
						blnFlag = true;
					}
					else{
						blnFlag = false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify New user is added","New user is not added","FAIL",runManagerInfoObj);
					blnFlag = false;
				}
			}

		} else {
			repfn.FnUpdateTestStepResHTML("Verify if Users are present on Manage Users Screen", "Users are present on Manage Users Screen","FAIL",runManagerInfoObj);
			blnFlag = false;

		}
	} catch (Exception e) {
		repfn.FnUpdateTestStepResHTML("Verify if Reset Password Link is getting displayed","Reset Password Link is not getting displayed due to some exception","FAIL",runManagerInfoObj);
		System.err.println("Message : " + e.getMessage());
		System.err.println("Cause : " + e.getCause());
		blnFlag = false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean FnFillUserDetailsTabThree_Back(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

	try{

		boolean tab = app.FnCheckVoiceTab(driver,runManagerInfoObj);
		if(tab){
			if(cnf.FnExplicitWait("XPATH",mbo.AddStepsListHeading,driver)){
				WebElement AddStepsListHeading = driver.findElement(By.xpath(mbo.AddStepsListHeading));
				if(AddStepsListHeading.getText().contains("Assign Voice Services")){
					repfn.FnUpdateTestStepResHTML("Verify User is on Voice tab", "User is on Voice tab","PASS",runManagerInfoObj);

					if(cnf.FnExplicitWait("XPATH",mbo.AddUserAddVoiceLineButton,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Add Voice Line button is displayed", "Add Voice Line button is displayed","PASS",runManagerInfoObj);
						blnFlag	=true;
					}
					else{
						if(cnf.FnExplicitWait("XPATH",mbo.AddUserVoiceLineErrorMessage,driver)){	
							WebElement AddUserVoiceLineErrorMessage = driver.findElement(By.xpath(mbo.AddUserVoiceLineErrorMessage));
							repfn.FnUpdateTestStepResHTML("Verify Voice Line Error Message is displayed", "Voice Line Error Message is displayed: "+AddUserVoiceLineErrorMessage.getText(),"PASS",runManagerInfoObj);
							blnFlag	=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Voice Line Error Message is displayed", "Voice Line Error Message is not displayed","FAIL",runManagerInfoObj);
							blnFlag	=false;
						}
					}

					if(cnf.FnExplicitWait("XPATH",mbo.AddUserSkipLink,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Skip Link is displayed", "Skip Link is displayed","PASS",runManagerInfoObj);
						blnFlag	=true;	
					}
					else{				
						repfn.FnUpdateTestStepResHTML("Verify Skip Link is displayed", "Skip Link is not displayed","FAIL",runManagerInfoObj);
						blnFlag	=false;	
					}

					if(cnf.FnExplicitWait("XPATH",mbo.AddUserBackOption,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Back Option is displayed", "Back Option is displayed","PASS",runManagerInfoObj);
						blnFlag	=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Back Option is displayed", "Back Option is not displayed","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}

					if(cnf.FnExplicitWait("XPATH",mbo.AddUserCancelOption,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Cancel Option is displayed", "Cancel Option is displayed","PASS",runManagerInfoObj);
						blnFlag	=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Cancel Option is displayed", "Cancel Option is not displayed","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}

					if(cnf.FnExplicitWait("XPATH",mbo.NextButton,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Next Button is displayed", "Next Button is displayed","PASS",runManagerInfoObj);
						blnFlag	=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Next Button is displayed", "Next Button is not displayed","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}

					if(cnf.FnExplicitWait("XPATH",mbo.AddUserBackOption,driver)){
						WebElement AddUserBackOption = driver.findElement(By.xpath(mbo.AddUserBackOption));
						if(cnf.JSClick(AddUserBackOption,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Back Option is clicked", "Back Option is clicked","PASS",runManagerInfoObj);

							if(cnf.FnExplicitWait("XPATH",mbo.AddStepsListHeading,driver)){
								WebElement AddStepsListHeadingOne = driver.findElement(By.xpath(mbo.AddStepsListHeading));
								if(AddStepsListHeadingOne.getText().contains("Set User Role")){
									repfn.FnUpdateTestStepResHTML("Verify User is on Role tab", "User is on Role tab","PASS",runManagerInfoObj);
									blnFlag	=true;
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify User is on Role tab", "User is not on Role tab","FAIL",runManagerInfoObj);
									blnFlag	=false;
								}
							}					
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Back Option is clicked", "Back Option is not clicked","FAIL",runManagerInfoObj);
							blnFlag	=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Back Option is displayed", "Back Option is not displayed","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}

				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User is on Voice tab", "User is not on Voice tab","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Tab Heading is displayed", "Tab Heading is not displayed","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
		}
		else{
			if(cnf.FnExplicitWait("XPATH",mbo.AddUserBackOption,driver)){
				WebElement AddUserBackOption = driver.findElement(By.xpath(mbo.AddUserBackOption));
				if(cnf.JSClick(AddUserBackOption,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Back Option is clicked", "Back Option is clicked","PASS",runManagerInfoObj);

					if(cnf.FnExplicitWait("XPATH",mbo.AddStepsListHeading,driver)){
						WebElement AddStepsListHeadingOne = driver.findElement(By.xpath(mbo.AddStepsListHeading));
						if(AddStepsListHeadingOne.getText().contains("Set User Role")){
							repfn.FnUpdateTestStepResHTML("Verify User is on Role tab", "User is on Role tab","PASS",runManagerInfoObj);
							blnFlag	=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User is on Role tab", "User is not on Role tab","FAIL",runManagerInfoObj);
							blnFlag	=false;
						}
					}					
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Back Option is clicked", "Back Option is not clicked","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Back Option is displayed", "Back Option is not displayed","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
		}

	}

	catch(Exception e)
	{
		repfn.FnUpdateTestStepResHTML("Verify User is on Add New User page", "User is on Add New User page due to some exception","FAIL",runManagerInfoObj);
		blnFlag	=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}

	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}

public synchronized boolean FNManageusers_Admin(WebDriver driver, RunManagerInfo runManagerInfoObj) {
	boolean blnFlag = false;
	try{

		if(cnf.FnExplicitWait("XPATH",mbo.ManageUsers_RoleList,driver)){
			repfn.FnUpdateTestStepResHTML("Verify All users are displayed on Manage User Page", "All users are displayed on Manage User Page","PASS",runManagerInfoObj);
			List<WebElement> ManageUsers_RoleList=driver.findElements(By.xpath(mbo.ManageUsers_RoleList));
			List <WebElement> Users = new ArrayList<WebElement>();
			for(WebElement UserRole:ManageUsers_RoleList){
				if(UserRole.getText().contains("Administrator")){
					Users.add(UserRole);
				}
			}
			if(Users.size() > 0){
				repfn.FnUpdateTestStepResHTML("Verify Users with Role as \"Administrator\" are displayed on Manage User Page", 
						"Users with Role as \"Administrator\"  are displayed on Manage User Page","PASS",runManagerInfoObj);
				
				if(cnf.FnExplicitWait("XPATH",mbo.ManageUsers_UserNameList,driver)){
					String AppUser=m1.get("AppUser").toString();
					
					List<WebElement> ManageUsers_UserNameList=driver.findElements(By.xpath(mbo.ManageUsers_UserNameList));
					List <WebElement> UsersOne = new ArrayList<WebElement>();
					
					for(WebElement UserRole1:ManageUsers_UserNameList){
						if(!(UserRole1.getText().contains(AppUser))){
							UsersOne.add(UserRole1);
						}				
					}
					
					if(UsersOne.size() > 0){
						WebElement User = UsersOne.get(0);
						if(cnf.JSClick(User,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Administrator is selected on Manage Users page", "Administrator is selected on Manage Users page","PASS",runManagerInfoObj);
							Thread.sleep(2000);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Administrator is selected on Manage Users page", "Administrator is not selected on Manage Users page","FAIL",runManagerInfoObj);
							blnFlag =false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Users with Role as \"Administrator\" are displayed on Manage User Page other than logged-in user", 
								"Users with Role as \"Administrator\"  are not displayed on Manage User Page other than logged-in user. New admin user needs to be added","PASS",runManagerInfoObj);
						boolean blnFlag1 = FN_AddNewUser_Admin(driver,runManagerInfoObj);
						if(blnFlag1){
							boolean blnFlag2 = FNManageusers_Admin(driver,runManagerInfoObj);
							if(blnFlag2){
								blnFlag = true;
							}
							else{
								blnFlag = false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify New user is added","New user is not added","FAIL",runManagerInfoObj);
							blnFlag = false;
						}
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify All users are displayed on Manage User Page", "All users are not displayed on Manage User Page","FAIL",runManagerInfoObj);
					blnFlag =false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Users with Role as \"Administrator\" are displayed on Manage User Page", 
						"Users with Role as \"Administrator\"  are not displayed on Manage User Page. New user needs to be added","PASS",runManagerInfoObj);
				boolean blnFlag1 = FN_AddNewUser_Admin(driver,runManagerInfoObj);
				if(blnFlag1){
					boolean blnFlag2 = FNManageusers_Admin(driver,runManagerInfoObj);
					if(blnFlag2){
						blnFlag = true;
					}
					else{
						blnFlag = false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify New user is added","New user is not added","FAIL",runManagerInfoObj);
					blnFlag = false;
				}
			} 
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify All users are displayed on Manage User Page", "All users are not displayed on Manage User Page","FAIL",runManagerInfoObj);
			blnFlag =false;
		}
	}
	catch (Exception e) {
		repfn.FnUpdateTestStepResHTML("Verify Users with Role as \"Administrator\" are displayed on Manage User Page", 
				"Users with Role as \"Administrator\"  are not displayed on Manage User Page due to some exception","FAIL",runManagerInfoObj);
		System.err.println("Message : " + e.getMessage());
		System.err.println("Cause : " + e.getCause());
		blnFlag = false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean FnFillUserDetailsTabTwo(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
try{
	if(cnf.FnExplicitWait("XPATH",mbo.AddStepsListHeading,driver)){
		WebElement AddStepsListHeading = driver.findElement(By.xpath(mbo.AddStepsListHeading));
		if(AddStepsListHeading.getText().contains("Set User Role")){
			repfn.FnUpdateTestStepResHTML("Verify User is on Role tab", "User is on Role tab","PASS",runManagerInfoObj);
			
			if(cnf.FnExplicitWait("XPATH",mbo.AddUserStandardRadioButton,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Standard User Radio button is displayed", "Standard User Radio button is displayed","PASS",runManagerInfoObj);
				WebElement AddUserStandardRadioButton = driver.findElement(By.xpath(mbo.AddUserStandardRadioButton));
				if(cnf.JSClick(AddUserStandardRadioButton,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Standard User Radio button is clicked", "Standard User Radio button is clicked","PASS",runManagerInfoObj);
					
					if(cnf.FnExplicitWait("XPATH",mbo.NextButton,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Next Button is displayed", "Next Button is displayed","PASS",runManagerInfoObj);
						WebElement NextButton = driver.findElement(By.xpath(mbo.NextButton));
						if(cnf.JSClick(NextButton,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Next Button is clicked", "Next Button is clicked","PASS",runManagerInfoObj);
							blnFlag	=true;
							
							Thread.sleep(3000);
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Next Button is clicked", "Next Button is not clicked","FAIL",runManagerInfoObj);
							blnFlag	=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Next Button is displayed", "Next Button is not displayed","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Standard User Radio button is clicked", "Standard User Radio button is not clicked","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
				
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Standard User Radio button is displayed", "Standard User Radio button is not displayed","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify User is on Role tab", "User is not on Role tab","FAIL",runManagerInfoObj);
			blnFlag	=false;
		}
	}
	else{
		repfn.FnUpdateTestStepResHTML("Verify Tab Heading is displayed", "Tab Heading is not displayed","FAIL",runManagerInfoObj);
		blnFlag	=false;
	}
}

catch(Exception e)
{
	repfn.FnUpdateTestStepResHTML("Verify User is on Add New User page", "User is on Add New User page due to some exception","FAIL",runManagerInfoObj);
	blnFlag	=false;
	System.err.println("Message : "+e.getMessage());
	System.err.println("Cause : "+e.getCause());

}

m1.put("STEPSTATUS", blnFlag);
return blnFlag;
}


public synchronized boolean FnFillUserDetailsTabThree(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

try{
	if(cnf.FnExplicitWait("XPATH",mbo.AddStepsListHeading,driver)){
		WebElement AddStepsListHeading = driver.findElement(By.xpath(mbo.AddStepsListHeading));
		if(AddStepsListHeading.getText().contains("Assign Voice Services")){
			repfn.FnUpdateTestStepResHTML("Verify User is on Voice tab", "User is on Voice tab","PASS",runManagerInfoObj);

			if(cnf.FnExplicitWait("XPATH",mbo.AddUserAddVoiceLineButton,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Add Voice Line button is displayed", "Add Voice Line button is displayed","PASS",runManagerInfoObj);
				WebElement AddUserAddVoiceLineButton = driver.findElement(By.xpath(mbo.AddUserAddVoiceLineButton));
				if(cnf.JSClick(AddUserAddVoiceLineButton,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Add Voice Line button is clicked", "Add Voice Line button is clicked","PASS",runManagerInfoObj);

					if(cnf.FnExplicitWait("XPATH",mbo.AddUserVoiceLineNumber,driver)){
						WebElement AddUserVoiceLineNumber = driver.findElement(By.xpath(mbo.AddUserVoiceLineNumber));
						String LineNumber = AddUserVoiceLineNumber.getAttribute("textContent");
						System.out.println(LineNumber);
						repfn.FnUpdateTestStepResHTML("Verify Line Number is added and displayed", "Line Number is added and displayed as: "+LineNumber,"PASS",runManagerInfoObj);

						if(cnf.FnExplicitWait("XPATH",mbo.NextButton,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Next Button is displayed", "Next Button is displayed","PASS",runManagerInfoObj);
							WebElement NextButton = driver.findElement(By.xpath(mbo.NextButton));
							if(cnf.JSClick(NextButton,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Next Button is clicked", "Next Button is clicked","PASS",runManagerInfoObj);
								blnFlag	=true;

								Thread.sleep(3000);
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Next Button is clicked", "Next Button is not clicked","FAIL",runManagerInfoObj);
								blnFlag	=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Next Button is displayed", "Next Button is not displayed","FAIL",runManagerInfoObj);
							blnFlag	=false;
						}

					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Add Voice Line button is clicked", "Add Voice Line button is not clicked","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
			}
			else {
				if(cnf.FnExplicitWait("XPATH",mbo.AddUserVoiceLineErrorMessage,driver)){				
					WebElement AddUserVoiceLineErrorMessage = driver.findElement(By.xpath(mbo.AddUserVoiceLineErrorMessage));
					repfn.FnUpdateTestStepResHTML("Verify Voice Line Error Message is displayed", "Voice Line Error Message is displayed: "+AddUserVoiceLineErrorMessage.getText(),"PASS",runManagerInfoObj);

					if(cnf.FnExplicitWait("XPATH",mbo.AddUserSkipLink,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Skip Link is displayed", "Skip Link is displayed","PASS",runManagerInfoObj);
						WebElement AddUserSkipLink = driver.findElement(By.xpath(mbo.AddUserSkipLink));
						if(cnf.JSClick(AddUserSkipLink,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Skip Link is clicked", "Skip Link is clicked","PASS",runManagerInfoObj);
							blnFlag	=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Skip Link is clicked", "Skip Link is not clicked","FAIL",runManagerInfoObj);
							blnFlag	=false;
						}
						
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Skip Link is displayed", "Skip Link is not displayed","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Voice Line Error Message is displayed", "Voice Line Error Message is not displayed","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify User is on Voice tab", "User is not on Voice tab","FAIL",runManagerInfoObj);
			blnFlag	=false;
		}

	}
	else{
		repfn.FnUpdateTestStepResHTML("Verify Tab Heading is displayed", "Tab Heading is not displayed","FAIL",runManagerInfoObj);
		blnFlag	=false;
	}

	
}

catch(Exception e)
{
	repfn.FnUpdateTestStepResHTML("Verify User is on Add New User page", "User is not on Add New User page due to some exception","FAIL",runManagerInfoObj);
	blnFlag	=false;
	System.err.println("Message : "+e.getMessage());
	System.err.println("Cause : "+e.getCause());

}

m1.put("STEPSTATUS", blnFlag);
return blnFlag;
}

public synchronized boolean FnFillUserDetailsTabFour_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

String name="";
try{
	if(cnf.FnExplicitWait("XPATH",mbo.AddStepsListHeading,driver)){
		WebElement AddStepsListHeading = driver.findElement(By.xpath(mbo.AddStepsListHeading));
		if(AddStepsListHeading.getText().contains("Confirm Add New User")){
			repfn.FnUpdateTestStepResHTML("Verify User is on Confirm tab", "User is on Confirm tab","PASS",runManagerInfoObj);
			
			if(cnf.FnExplicitWait("XPATH",mbo.AddUserNameFieldVerify,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Name is displayed on Confirm Page", "Name is displayed on Confirm Page","PASS",runManagerInfoObj);
				if(cnf.FnExplicitWait("XPATH",mbo.AddUserNameFieldEditVerify,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Edit Option is displayed besides Name Field on Confirm Page", 
							"Edit Option is displayed besides Name Field on Confirm Page","PASS",runManagerInfoObj);
					blnFlag	=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Edit Option is displayed besides Name Field on Confirm Page", "Edit Option is not displayed besides Name Field on Confirm Page","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Name is displayed on Confirm Page", "Name is not displayed on Confirm Page","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
			
			if(cnf.FnExplicitWait("XPATH",mbo.AddUserRoleFieldVerify,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Role is displayed on Confirm Page", "Role is displayed on Confirm Page","PASS",runManagerInfoObj);
				if(cnf.FnExplicitWait("XPATH",mbo.AddUserRoleFieldEditVerify,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Edit Option is displayed besides Role Field on Confirm Page", 
							"Edit Option is displayed besides Role Field on Confirm Page","PASS",runManagerInfoObj);
					blnFlag	=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Edit Option is displayed besides Role Field on Confirm Page", 
							"Edit Option is not displayed besides Role Field on Confirm Page","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Role is displayed on Confirm Page", "Role is not displayed on Confirm Page","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
			
			if(cnf.FnExplicitWait("XPATH",mbo.AddUserVoiceNumberFieldVerify,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Voice Number is displayed on Confirm Page", "Voice Number is displayed on Confirm Page","PASS",runManagerInfoObj);
				if(cnf.FnExplicitWait("XPATH",mbo.AddUserVoiceNumberFieldEditVerify,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Edit Option is displayed besides Voice Number Field on Confirm Page", 
							"Edit Option is displayed besides Voice Number Field on Confirm Page","PASS",runManagerInfoObj);
					blnFlag	=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Edit Option is displayed besides Voice Number Field on Confirm Page", 
							"Edit Option is not displayed besides Voice Number Field on Confirm Page","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Voice Number is displayed on Confirm Page", "Voice Number is not displayed on Confirm Page","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
			
			
			if(cnf.FnExplicitWait("XPATH",mbo.AddUserBackOption,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Back Option is displayed on Confirm Page", "Back Option is displayed on Confirm Page","PASS",runManagerInfoObj);
				blnFlag	=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Back Option is displayed on Confirm Page", "Back Option is not displayed on Confirm Page","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
			
			if(cnf.FnExplicitWait("XPATH",mbo.AddUserCancelOption,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Cancel Option is displayed on Confirm Page", "Cancel Option is displayed on Confirm Page","PASS",runManagerInfoObj);
				blnFlag	=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Cancel Option is displayed on Confirm Page", "Cancel Option is not displayed on Confirm Page","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
			
			if(cnf.FnExplicitWait("XPATH",mbo.AddUserConfirmOption,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Confirm Option is displayed on Confirm Page", "Confirm Option is displayed on Confirm Page","PASS",runManagerInfoObj);
				blnFlag	=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Confirm Option is displayed on Confirm Page", "Confirm Option is not displayed on Confirm Page","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
			
			if(cnf.FnExplicitWait("XPATH",mbo.AddUserNameOptionValue,driver)){
				WebElement AddUserNameOptionValue = driver.findElement(By.xpath(mbo.AddUserNameOptionValue));
				name = AddUserNameOptionValue.getText();
				blnFlag	=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Name is not displayed", "Name is not displayed","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
			
			
			if(cnf.FnExplicitWait("XPATH",mbo.AddUserCancelOption,driver)){
				WebElement AddUserCancelOption = driver.findElement(By.xpath(mbo.AddUserCancelOption));
				if(cnf.JSClick(AddUserCancelOption,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Cancel Option is clicked", "Cancel Option is clicked","PASS",runManagerInfoObj);
					
					if(cnf.FnExplicitWait("XPATH",mbo.ConfirmCancel,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Confirmation pop-up is displayed", "Confirmation pop-up is displayed","PASS",runManagerInfoObj);
						repfn.FnUpdateTestStepResHTML("Verify Confirm Option is displayed", "Confirm Option is displayed","PASS",runManagerInfoObj);
						WebElement ConfirmCancel = driver.findElement(By.xpath(mbo.ConfirmCancel));
						if(cnf.JSClick(ConfirmCancel,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Confirm Option is clicked", "Confirm Option is clicked","PASS",runManagerInfoObj);
							blnFlag	=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Confirm Option is clicked", "Confirm Option is not clicked","FAIL",runManagerInfoObj);
							blnFlag	=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Confirm Option is displayed", "Confirm Option is not displayed","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Cancel Option is clicked", "Cancel Option is not clicked","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Cancel Option is displayed on Confirm Page", "Cancel Option is not displayed on Confirm Page","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
			
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify User is on Confirm tab", "User is not on Confirm tab","FAIL",runManagerInfoObj);
			blnFlag	=false;
		}
	}
	else{
		repfn.FnUpdateTestStepResHTML("Verify Tab Heading is displayed", "Tab Heading is not displayed","FAIL",runManagerInfoObj);
		blnFlag	=false;
	}
	
	Thread.sleep(5000);
	
	if(cnf.FnExplicitWait("XPATH",mbo.AssignLineSearchBar,driver)){
		repfn.FnUpdateTestStepResHTML("Verify Search bar is displayed", "Search bar is displayed","PASS",runManagerInfoObj);
		WebElement AssignLineSearchBar = driver.findElement(By.xpath(mbo.AssignLineSearchBar));
		AssignLineSearchBar.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),name);
		repfn.FnUpdateTestStepResHTML("Verify Name is entered in Search bar", "Name is entered in Search bar","PASS",runManagerInfoObj);
		
		if(cnf.FnExplicitWait("XPATH",mbo.ManageUsers_RoleList,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Newly Created User is not added", "Newly Created User is added","FAIL",runManagerInfoObj);
			blnFlag	=false;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Newly Created User is not added", "Newly Created User is not added","PASS",runManagerInfoObj);
			blnFlag	=true;
		}
	}
	else{
		repfn.FnUpdateTestStepResHTML("Verify Search bar is displayed", "Search bar is not displayed","FAIL",runManagerInfoObj);
		blnFlag	=false;
	}
}

catch(Exception e)
{
	repfn.FnUpdateTestStepResHTML("Verify User is on Add New User page", "User is on Add New User page due to some exception","FAIL",runManagerInfoObj);
	blnFlag	=false;
	System.err.println("Message : "+e.getMessage());
	System.err.println("Cause : "+e.getCause());

}

m1.put("STEPSTATUS", blnFlag);
return blnFlag;
}

public synchronized boolean FnFillUserDetailsTabFour_Back(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{


try{
	if(cnf.FnExplicitWait("XPATH",mbo.AddStepsListHeading,driver)){
		WebElement AddStepsListHeading = driver.findElement(By.xpath(mbo.AddStepsListHeading));
		if(AddStepsListHeading.getText().contains("Confirm Add New User")){
			repfn.FnUpdateTestStepResHTML("Verify User is on Confirm tab", "User is on Confirm tab","PASS",runManagerInfoObj);
			
			if(cnf.FnExplicitWait("XPATH",mbo.AddUserNameFieldVerify,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Name is displayed on Confirm Page", "Name is displayed on Confirm Page","PASS",runManagerInfoObj);
				if(cnf.FnExplicitWait("XPATH",mbo.AddUserNameFieldEditVerify,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Edit Option is displayed besides Name Field on Confirm Page", 
							"Edit Option is displayed besides Name Field on Confirm Page","PASS",runManagerInfoObj);
					blnFlag	=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Edit Option is displayed besides Name Field on Confirm Page", "Edit Option is not displayed besides Name Field on Confirm Page","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Name is displayed on Confirm Page", "Name is not displayed on Confirm Page","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
			
			if(cnf.FnExplicitWait("XPATH",mbo.AddUserRoleFieldVerify,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Role is displayed on Confirm Page", "Role is displayed on Confirm Page","PASS",runManagerInfoObj);
				if(cnf.FnExplicitWait("XPATH",mbo.AddUserRoleFieldEditVerify,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Edit Option is displayed besides Role Field on Confirm Page", 
							"Edit Option is displayed besides Role Field on Confirm Page","PASS",runManagerInfoObj);
					blnFlag	=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Edit Option is displayed besides Role Field on Confirm Page", 
							"Edit Option is not displayed besides Role Field on Confirm Page","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Role is displayed on Confirm Page", "Role is not displayed on Confirm Page","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
			
			if(cnf.FnExplicitWait("XPATH",mbo.AddUserVoiceNumberFieldVerify,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Voice Number is displayed on Confirm Page", "Voice Number is displayed on Confirm Page","PASS",runManagerInfoObj);
				if(cnf.FnExplicitWait("XPATH",mbo.AddUserVoiceNumberFieldEditVerify,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Edit Option is displayed besides Voice Number Field on Confirm Page", 
							"Edit Option is displayed besides Voice Number Field on Confirm Page","PASS",runManagerInfoObj);
					blnFlag	=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Edit Option is displayed besides Voice Number Field on Confirm Page", 
							"Edit Option is not displayed besides Voice Number Field on Confirm Page","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Voice Number is displayed on Confirm Page", "Voice Number is not displayed on Confirm Page","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
			
			
			if(cnf.FnExplicitWait("XPATH",mbo.AddUserBackOption,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Back Option is displayed on Confirm Page", "Back Option is displayed on Confirm Page","PASS",runManagerInfoObj);
				blnFlag	=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Back Option is displayed on Confirm Page", "Back Option is not displayed on Confirm Page","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
			
			if(cnf.FnExplicitWait("XPATH",mbo.AddUserCancelOption,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Cancel Option is displayed on Confirm Page", "Cancel Option is displayed on Confirm Page","PASS",runManagerInfoObj);
				blnFlag	=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Cancel Option is displayed on Confirm Page", "Cancel Option is not displayed on Confirm Page","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
			
			if(cnf.FnExplicitWait("XPATH",mbo.AddUserConfirmOption,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Confirm Option is displayed on Confirm Page", "Confirm Option is displayed on Confirm Page","PASS",runManagerInfoObj);
				blnFlag	=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Confirm Option is displayed on Confirm Page", "Confirm Option is not displayed on Confirm Page","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
			
			
			if(cnf.FnExplicitWait("XPATH",mbo.AddUserBackOption,driver)){
				WebElement AddUserBackOption = driver.findElement(By.xpath(mbo.AddUserBackOption));
				if(cnf.JSClick(AddUserBackOption,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Back Option is clicked", "Back Option is clicked","PASS",runManagerInfoObj);
			
					if(cnf.FnExplicitWait("XPATH",mbo.AddStepsListHeading,driver)){
						WebElement AddStepsListHeadingOne = driver.findElement(By.xpath(mbo.AddStepsListHeading));
						if(AddStepsListHeadingOne.getText().contains("Assign Voice Services")){
							repfn.FnUpdateTestStepResHTML("Verify User is on Voice tab", "User is on Voice tab","PASS",runManagerInfoObj);
							blnFlag	=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User is on Voice tab", "User is not on Voice tab","FAIL",runManagerInfoObj);
							blnFlag	=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Tab Heading is displayed", "Tab Heading is not displayed","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
					
/*					if(cnf.FnExplicitWait("XPATH",mbo.AddUserCancelOption)){
						WebElement AddUserCancelOption = driver.findElement(By.xpath(mbo.AddUserCancelOption));
						if(cnf.JSClick(AddUserCancelOption)){
							repfn.FnUpdateTestStepResHTML("Verify Cancel Option is clicked", "Cancel Option is clicked","PASS",runManagerInfoObj);
							
							if(cnf.FnExplicitWait("XPATH",mbo.ConfirmCancel)){
								repfn.FnUpdateTestStepResHTML("Verify Confirmation pop-up is displayed", "Confirmation pop-up is displayed","PASS",runManagerInfoObj);
								repfn.FnUpdateTestStepResHTML("Verify Confirm Option is displayed", "Confirm Option is displayed","PASS",runManagerInfoObj);
								WebElement ConfirmCancel = driver.findElement(By.xpath(mbo.ConfirmCancel));
								if(cnf.JSClick(ConfirmCancel)){
									repfn.FnUpdateTestStepResHTML("Verify Confirm Option is clicked", "Confirm Option is clicked","PASS",runManagerInfoObj);
									blnFlag	=true;
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Confirm Option is clicked", "Confirm Option is not clicked","FAIL",runManagerInfoObj);
									blnFlag	=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Confirm Option is displayed", "Confirm Option is not displayed","FAIL",runManagerInfoObj);
								blnFlag	=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Cancel Option is clicked", "Cancel Option is not clicked","FAIL",runManagerInfoObj);
							blnFlag	=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Cancel Option is displayed", "Cancel Option is not displayed","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}*/
					
					
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Back Option is clicked", "Back Option is not clicked","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
				
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Back Option is displayed on Confirm Page", "Back Option is not displayed on Confirm Page","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
			
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify User is on Confirm tab", "User is not on Confirm tab","FAIL",runManagerInfoObj);
			blnFlag	=false;
		}
	}
	else{
		repfn.FnUpdateTestStepResHTML("Verify Tab Heading is displayed", "Tab Heading is not displayed","FAIL",runManagerInfoObj);
		blnFlag	=false;
	}

}

catch(Exception e)
{
	repfn.FnUpdateTestStepResHTML("Verify User is on Add New User page", "User is on Add New User page due to some exception","FAIL",runManagerInfoObj);
	blnFlag	=false;
	System.err.println("Message : "+e.getMessage());
	System.err.println("Cause : "+e.getCause());

}

m1.put("STEPSTATUS", blnFlag);
return blnFlag;
}
public synchronized boolean FnFillUserDetailsTabOne(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

String firstName = "";
String lastName = "";
String Email = "Manavi@charter.net";

try{
	if(cnf.FnExplicitWait("XPATH",mbo.AddStepsListHeading,driver)){
		WebElement AddStepsListHeading = driver.findElement(By.xpath(mbo.AddStepsListHeading));
		if(AddStepsListHeading.getText().contains("Profile Information")){
			repfn.FnUpdateTestStepResHTML("Verify User is on Profile tab", "User is on Profile tab","PASS",runManagerInfoObj);
			
			if(cnf.FnExplicitWait("XPATH",mbo.AddUserFirstName,driver)){
				WebElement AddUserFirstName = driver.findElement(By.xpath(mbo.AddUserFirstName));
				firstName = m1.get("FirstName").toString();
				AddUserFirstName.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),firstName+randomInt);
				repfn.FnUpdateTestStepResHTML("Verify First Name is entered", "First Name is entered","PASS",runManagerInfoObj);
				blnFlag	=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify First Name field is displayed", "First Name field is not displayed","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
			
			if(cnf.FnExplicitWait("XPATH",mbo.AddUserLastName,driver)){
				WebElement AddUserLastName = driver.findElement(By.xpath(mbo.AddUserLastName));
				lastName = m1.get("LastName").toString();
				AddUserLastName.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),lastName);
				repfn.FnUpdateTestStepResHTML("Verify Last Name is entered", "Last Name is entered","PASS",runManagerInfoObj);
				blnFlag	=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Last Name field is displayed", "Last Name field is not displayed","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
			
			if(cnf.FnExplicitWait("XPATH",mbo.AddUserEmail,driver)){
				WebElement AddUserEmail = driver.findElement(By.xpath(mbo.AddUserEmail));
				Email = m1.get("Email").toString();
				AddUserEmail.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),Email);
				repfn.FnUpdateTestStepResHTML("Verify Email is entered", "Email Name is entered","PASS",runManagerInfoObj);
				blnFlag	=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Email field is displayed", "Email field is not displayed","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
			
			if(cnf.FnExplicitWait("XPATH",mbo.NextButton,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Next Button is displayed", "Next Button is displayed","PASS",runManagerInfoObj);
				WebElement NextButton = driver.findElement(By.xpath(mbo.NextButton));
				if(cnf.JSClick(NextButton,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Next Button is clicked", "Next Button is clicked","PASS",runManagerInfoObj);
					blnFlag	=true;
					
					Thread.sleep(3000);
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Next Button is clicked", "Next Button is not clicked","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Next Button is displayed", "Next Button is not displayed","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
			
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify User is on Profile tab", "User is not on Profile tab","FAIL",runManagerInfoObj);
			blnFlag	=false;
		}
	}
	else{
		repfn.FnUpdateTestStepResHTML("Verify Tab Heading is displayed", "Tab Heading is not displayed","FAIL",runManagerInfoObj);
		blnFlag	=false;
	}
}

catch(Exception e)
{
	repfn.FnUpdateTestStepResHTML("Verify User is on Add New User page", "User is on Add New User page due to some exception","FAIL",runManagerInfoObj);
	blnFlag	=false;
	System.err.println("Message : "+e.getMessage());
	System.err.println("Cause : "+e.getCause());

}

m1.put("STEPSTATUS", blnFlag);
return blnFlag;

}
public synchronized boolean FNManageusers_EditUI(WebDriver driver, RunManagerInfo runManagerInfoObj){
	boolean blnFlag = false;
	try {
		// DELETE USER POPUP VERIFY UI
		// Title
		if (cnf.FnExplicitWait("XPATH",mbo.EditMode_UsrDetails,driver)) {
			repfn.FnUpdateTestStepResHTML("Verify if Title is getting displayed","Title is getting displayed ", "PASS",runManagerInfoObj);
			WebElement EditMode_UsrDetails = driver.findElement(By.xpath(mbo.EditMode_UsrDetails));
			String titleText = EditMode_UsrDetails.getText();
			if (!titleText.isEmpty() && "User Details".equalsIgnoreCase(titleText)) {
				repfn.FnUpdateTestStepResHTML("Verify if Title is getting displayed ","Title displayed is : "+titleText, "PASS",runManagerInfoObj);
				blnFlag = true;
			} else {
				repfn.FnUpdateTestStepResHTML("Verify if Title is getting displayed ","\'User Details\' is not getting displayed as title","FAIL",runManagerInfoObj);
				blnFlag = false;
			}
		} else {
			repfn.FnUpdateTestStepResHTML("Verify if Title is getting displayed","Title is not getting displayed ", "FAIL",runManagerInfoObj);
			blnFlag = false;
		}
		
		// Sub Section-User Information
		if (cnf.FnExplicitWait("XPATH",mbo.EditMode_UserDetailsInfo,driver)) {
			repfn.FnUpdateTestStepResHTML("Verify if Subsection1 is getting displayed in popup","Subsection1 is getting displayed in popup", "PASS",runManagerInfoObj);
			WebElement UserDetailsInfo = driver.findElement(By.xpath(mbo.EditMode_UserDetailsInfo));
			String text1 = UserDetailsInfo.getText();
			if (!text1.isEmpty()&& "User Information".equalsIgnoreCase(text1)) {
				repfn.FnUpdateTestStepResHTML("Verify if Text getting displayed in Subsection1 is \'User Information\'","The text displayed in Subsection1 is :"+text1,"PASS",runManagerInfoObj);
				blnFlag = true;

			} else {
				repfn.FnUpdateTestStepResHTML("Verify if Text getting displayed in Subsection1 is \'User Information\'","Text is not getting displayed in Subsection1 ","FAIL",runManagerInfoObj);
				blnFlag = false;
			}

		} else {
			repfn.FnUpdateTestStepResHTML("Verify if Subsection1 is getting displayed in popup","Subsection1 is not getting displayed in popup ", "FAIL",runManagerInfoObj);
			blnFlag = false;
		}

		// EditMode_FirstNameLabel
		if (cnf.FnExplicitWait("XPATH",mbo.EditMode_FirstNameLabel,driver)) {
			repfn.FnUpdateTestStepResHTML("Verify First name Label is displayed ","First name Label  is displayed", "PASS",runManagerInfoObj);
			blnFlag = true;
		} else {
			repfn.FnUpdateTestStepResHTML("Verify First name Label  is displayed ","First name Label  is not displayed", "FAIL",runManagerInfoObj);
			blnFlag = false;
		}
		
		// EditMode_LastNameLabel
		if (cnf.FnExplicitWait("XPATH", mbo.EditMode_LastNameLabel,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Last name Label is displayed ","Last name Label is displayed", "PASS",runManagerInfoObj);
			blnFlag = true;
		} else {
			repfn.FnUpdateTestStepResHTML("Verify Last name Label is displayed ","Last name Label is not displayed", "FAIL",runManagerInfoObj);
			blnFlag = false;
		}
		
		// EditMode_PhoneLabel
		if (cnf.FnExplicitWait("XPATH", mbo.EditMode_PhoneLabel,driver)) {
			repfn.FnUpdateTestStepResHTML("Verify Phone Number Label is displayed ","Phone Number Label is displayed", "PASS",runManagerInfoObj);
			blnFlag = true;
		} else {
			repfn.FnUpdateTestStepResHTML("Verify Phone Number Label is displayed ","Phone Number Label is not displayed", "FAIL",runManagerInfoObj);
			blnFlag = false;
		}
		
		// EditMode_EmailLabel
		if (cnf.FnExplicitWait("XPATH", mbo.EditMode_EmailLabel,driver)) {

			repfn.FnUpdateTestStepResHTML("Verify  Email Address Label is displayed "," Email Address Label is displayed", "PASS",runManagerInfoObj);
			blnFlag = true;
		} else {
			repfn.FnUpdateTestStepResHTML("Verify  Email Address Label is displayed "," Email Address Label is not displayed", "FAIL",runManagerInfoObj);
			blnFlag = false;
		}
		
		// EditMode_UsrRoleLabel
		if (cnf.FnExplicitWait("XPATH", mbo.EditMode_UsrRoleLabel,driver)) {

			repfn.FnUpdateTestStepResHTML("Verify  Role Label is displayed  "," Role Label is displayed", "PASS",runManagerInfoObj);
			blnFlag = true;
		} else {
			repfn.FnUpdateTestStepResHTML("Verify  Role Label is displayed "," Role Label is  not displayed", "FAIL",runManagerInfoObj);
			blnFlag = false;
		}

		// EditMode_CancelBtn

		if (cnf.FnExplicitWait("XPATH", mbo.EditMode_CancelBtn,driver)) {
			WebElement EditMode_CancelBtn = driver.findElement(By.xpath(mbo.EditMode_CancelBtn));
			if(cnf.ElementClick(EditMode_CancelBtn,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Close Button is clicked ","Close Button is clicked", "PASS",runManagerInfoObj);
				blnFlag = true;
				Thread.sleep(1000);
			}
		else {
			repfn.FnUpdateTestStepResHTML("Verify Close Button is clicked ","Close Button is not clicked", "FAIL",runManagerInfoObj);
			blnFlag = false;				
		} 
		}

	} catch (Exception e) {
		repfn.FnUpdateTestStepResHTML("Verify User is able to verify User Details page UI","User is not able to verify User Details page UI due to some exception","FAIL",runManagerInfoObj);
		System.err.println("Message : " + e.getMessage());
		System.err.println("Cause : " + e.getCause());
		blnFlag = false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean FnEditLink_ManagerUser(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
	
	try{
		
		if(cnf.FnExplicitWait("XPATH",mbo.UserDetail_EditBtn,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Edit link is displayed on User Details page", "Edit link is displayed on User Details page","PASS",runManagerInfoObj);
			WebElement UserDetail_EditBtn=driver.findElement(By.xpath(mbo.UserDetail_EditBtn));
			if(cnf.JSClick(UserDetail_EditBtn,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Edit link is clicked", "Edit link is clicked","PASS",runManagerInfoObj);
				
				Thread.sleep(2000);
				if(cnf.FnExplicitWait("XPATH",mbo.ManageLinesEditPage,driver)){
					repfn.FnUpdateTestStepResHTML("Verify User is on Edit User page", "User is on Edit User page","PASS",runManagerInfoObj);
					blnFlag	=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User is on Edit User page", "User is not on Edit User page","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Edit link is clicked", "Edit link is not clicked","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Edit link is displayed on User Details page", "Edit link is not displayed on User Details page","FAIL",runManagerInfoObj);
			blnFlag	=false;
		}
		
	}
	
	catch(Exception e)
	{
		repfn.FnUpdateTestStepResHTML("Verify Contact is present in Contacts List ", "Contact is not present in Contacts List  due to some exception","FAIL",runManagerInfoObj);
		blnFlag	=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}

	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
	
	
}
public synchronized boolean FnModifyUserPermissions(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

	int userRole = Integer.parseInt(m1.get("UserRole").toString());
	System.out.println(userRole);
	String value = "";

	try{


		if(cnf.FnExplicitWait("XPATH",mbo.UserPermissionsDropdownBox,driver)){
			repfn.FnUpdateTestStepResHTML("Verify User Role drop-down is displayed in Edit User page", "User Role drop-down is displayed in Edit User page","PASS",runManagerInfoObj);
			WebElement UserPermissionsDropdownBox=driver.findElement(By.xpath(mbo.UserPermissionsDropdownBox));
			if(cnf.JSClick(UserPermissionsDropdownBox,driver)){
				repfn.FnUpdateTestStepResHTML("Verify User Role drop-down is clicked", "User Role drop-down is clicked","PASS",runManagerInfoObj);

				if(cnf.FnExplicitWait("XPATH",mbo.UserPermissionsDropdownAllValues,driver)){
					WebElement UserPermissionsDropdownAllValues = driver.findElement(By.xpath(mbo.UserPermissionsDropdownAllValues));
					cnf.ScrollToView(UserPermissionsDropdownAllValues,driver);
					repfn.FnUpdateTestStepResHTML("Verify User Role drop-down values are displayed", "User Role drop-down values are displayed","PASS",runManagerInfoObj);

					if(cnf.FnExplicitWait("XPATH",mbo.UserPermissionsDropdownSingleValue,driver)){
						List<WebElement> UserPermissionsDropdownSingleValue=driver.findElements(By.xpath(mbo.UserPermissionsDropdownSingleValue));
						System.out.println(UserPermissionsDropdownSingleValue.get(userRole).getText());

						if(UserPermissionsDropdownSingleValue.get(userRole).isDisplayed()){
							repfn.FnUpdateTestStepResHTML("Verify User Role: "+UserPermissionsDropdownSingleValue.get(userRole).getText()+ " is displayed in the drop-down", "User Role: "+UserPermissionsDropdownSingleValue.get(userRole).getText()+ " is displayed in the drop-down","PASS",runManagerInfoObj);
							WebElement SelectValue = UserPermissionsDropdownSingleValue.get(userRole);
							if(cnf.JSClick(SelectValue,driver)){
								repfn.FnUpdateTestStepResHTML("Verify User Role: "+SelectValue.getText()+ " is clicked", "User Role: "+SelectValue.getText()+ " is clicked.","PASS",runManagerInfoObj);

								value = SelectValue.getText();

								driver.manage().window().setSize(new Dimension(100, 100));
								driver.manage().window().maximize();

								if(cnf.FnExplicitWait("XPATH",mbo.saveButton,driver)){
									repfn.FnUpdateTestStepResHTML("Verify Save button is displayed", "Save button is displayed","PASS",runManagerInfoObj);
									WebElement saveButton = driver.findElement(By.xpath(mbo.saveButton));
									if(saveButton.isEnabled()){
										repfn.FnUpdateTestStepResHTML("Verify Save button is enabled after modifying the User Role", "Save button is enabled after modifying the User Role","PASS",runManagerInfoObj);

										if(cnf.JSClick(saveButton,driver)){
											repfn.FnUpdateTestStepResHTML("Verify Save button is clicked", "Save button is clicked","PASS",runManagerInfoObj);

											Thread.sleep(3000);

											if(cnf.FnExplicitWait("XPATH",mbo.UserPermissionsRoleValueVerification,driver)){
												WebElement UserPermissionsRoleValueVerification = driver.findElement(By.xpath(mbo.UserPermissionsRoleValueVerification));
												if(UserPermissionsRoleValueVerification.getText().contains(value)){
													repfn.FnUpdateTestStepResHTML("Verify User Role is modified successfully", "User Role is modified successfully","PASS",runManagerInfoObj);

													if(cnf.FnExplicitWait("XPATH",mbo.manageBackButton,driver)){
														repfn.FnUpdateTestStepResHTML("Verify Back link is displayed", "Back link is displayed","PASS",runManagerInfoObj);
														WebElement manageBackButton = driver.findElement(By.xpath(mbo.manageBackButton));
														if(cnf.JSClick(manageBackButton,driver)){
															repfn.FnUpdateTestStepResHTML("Verify Back link is clicked", "Back link is clicked","PASS",runManagerInfoObj);
															blnFlag	=true;
														}
														else{
															repfn.FnUpdateTestStepResHTML("Verify Back link is clicked", "Back link is not clicked","FAIL",runManagerInfoObj);
															blnFlag	=false;
														}
													}
													else{
														repfn.FnUpdateTestStepResHTML("Verify Back link is displayed", "Back link is not displayed","FAIL",runManagerInfoObj);
														blnFlag	=false;
													}
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify User Role is modified successfully", "User Role is not modified successfully","FAIL",runManagerInfoObj);
													blnFlag	=false;
												}
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Save button is clicked", "Save button is not clicked","FAIL",runManagerInfoObj);
											blnFlag	=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Save button is enabled after modifying the User Role", "Save button is not enabled after modifying the User Role","FAIL",runManagerInfoObj);
										blnFlag	=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Save button is displayed", "Save button is not displayed","FAIL",runManagerInfoObj);
									blnFlag	=false;
								}

							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify User Role: "+UserPermissionsDropdownSingleValue.get(userRole).getText()+ "is clicked", "User Role: "+UserPermissionsDropdownSingleValue.get(userRole).getText()+ "is not clicked.","FAIL",runManagerInfoObj);
								blnFlag	=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User Role: "+userRole+ "is displayed in the drop-down", "User Role: "+userRole+ "is not displayed in the drop-down","FAIL",runManagerInfoObj);
							blnFlag	=false;
						}
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User Role drop-down values are displayed", "User Role drop-down values are not displayed","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify User Role drop-down is clicked", "User Role drop-down is not clicked","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify User Role drop-down is displayed in Edit User page", "User Role drop-down is not displayed in Edit User page","FAIL",runManagerInfoObj);
			blnFlag	=false;
		}

	}

	catch(Exception e)
	{
		repfn.FnUpdateTestStepResHTML("Verify Contact is present in Contacts List ", "Contact is not present in Contacts List  due to some exception","FAIL",runManagerInfoObj);
		blnFlag	=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}

	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;

}
public synchronized boolean FNManageusers_EditClickDeleteCheck_user(WebDriver driver, RunManagerInfo runManagerInfoObj) {
	boolean blnFlag = false;
	try {
		if (cnf.FnExplicitWait("Xpath", mbo.UserDetail_EditBtn,driver)) {
			repfn.FnUpdateTestStepResHTML("Verify Edit button is displayed ","Edit button is displayed ", "PASS",runManagerInfoObj);
			WebElement UserDetail_EditBtn = driver.findElement(By.xpath(mbo.UserDetail_EditBtn));
			if (cnf.JSClick(UserDetail_EditBtn,driver)) {
				repfn.FnUpdateTestStepResHTML("Verify Edit button is clicked ","Edit button is clicked ", "PASS",runManagerInfoObj);

				if (cnf.FnExplicitWait("Xpath", mbo.EditMode_DeleteLink,driver)) {
					repfn.FnUpdateTestStepResHTML("Verify if Delete User Option is not displayed for admin itself","Delete User Option is displayed","FAIL",runManagerInfoObj);
					blnFlag = false;					
					driver.navigate().refresh();
				} else {
					repfn.FnUpdateTestStepResHTML("Verify if Delete User Option is not displayed","Delete User Option is not displayed for admin itself","PASS",runManagerInfoObj);
					blnFlag = true;
					driver.navigate().refresh();					
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
		repfn.FnUpdateTestStepResHTML("Verify if Delete User Option is not displayed","Delete User Option is displayed due to some exception","FAIL",runManagerInfoObj);
		System.err.println("Message : " + e.getMessage());
		System.err.println("Cause : " + e.getCause());
		blnFlag = false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean FNManageusers_EditandDeleteOption(WebDriver driver, RunManagerInfo runManagerInfoObj) {
	boolean blnFlag = false;
	try {
		if (cnf.FnExplicitWait("Xpath", mbo.UserDetail_EditBtn,driver)) {
			repfn.FnUpdateTestStepResHTML("Verify Edit button is displayed ","Edit button is displayed ", "PASS",runManagerInfoObj);
			WebElement UserDetail_EditBtn = driver.findElement(By.xpath(mbo.UserDetail_EditBtn));
			if (cnf.JSClick(UserDetail_EditBtn,driver)) {
				repfn.FnUpdateTestStepResHTML("Verify Edit button is clicked ","Edit button is clicked ", "PASS",runManagerInfoObj);

				if (cnf.FnExplicitWait("Xpath", mbo.EditMode_DeleteLink,driver)) {
					repfn.FnUpdateTestStepResHTML("Verify if Delete User Option is enabled","Delete User Option is enabled","PASS",runManagerInfoObj);
					blnFlag = true;
					driver.navigate().refresh();
				} else {
					repfn.FnUpdateTestStepResHTML("Verify if Delete User Option is enabled","Delete User Option is not enabled","FAIL",runManagerInfoObj);
					blnFlag = false;
					driver.navigate().refresh();
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
		System.err.println("Message : " + e.getMessage());
		System.err.println("Cause : " + e.getCause());
		blnFlag = false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean FNManageusers_AdminUser(WebDriver driver, RunManagerInfo runManagerInfoObj) {
	boolean blnFlag = false;
	try{

		if(cnf.FnExplicitWait("XPATH",mbo.ManageUsers_UserNameList,driver)){
			repfn.FnUpdateTestStepResHTML("Verify All users are displayed on Manage User Page", "All users are displayed on Manage User Page","PASS",runManagerInfoObj);
			String AppUser=m1.get("AppUser").toString();
		
			List<WebElement> ManageUsers_UserNameList=driver.findElements(By.xpath(mbo.ManageUsers_UserNameList));
			List <WebElement> Users = new ArrayList<WebElement>();
		
			
			for(WebElement UserRole:ManageUsers_UserNameList){
				if(UserRole.getText().contains(AppUser)){
					Users.add(UserRole);
				}				
			}
			
			if(Users.size() > 0){
				repfn.FnUpdateTestStepResHTML("Verify Users with Role as \"Administrator\" are displayed on Manage User Page", 
						"Users with Role as \"Administrator\"  are displayed on Manage User Page","PASS",runManagerInfoObj);

				WebElement User = Users.get(0);
				if(cnf.JSClick(User,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Administrator is selected on Manage Users page", "Administrator is selected on Manage Users page","PASS",runManagerInfoObj);
					Thread.sleep(2000);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Administrator is selected on Manage Users page", "Administrator is not selected on Manage Users page","FAIL",runManagerInfoObj);
					blnFlag =false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Users with Role as \"Administrator\" are displayed on Manage User Page", 
						"Users with Role as \"Administrator\"  are not displayed on Manage User Page","FAIL",runManagerInfoObj);
				blnFlag =false;
			} 
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify All users are displayed on Manage User Page", "All users are not displayed on Manage User Page","FAIL",runManagerInfoObj);
			blnFlag =false;
		}
	}
	catch (Exception e) {
		repfn.FnUpdateTestStepResHTML("Verify Users with Role as \"Administrator\" are displayed on Manage User Page", 
				"Users with Role as \"Administrator\"  are not displayed on Manage User Page due to some exception","FAIL",runManagerInfoObj);
		System.err.println("Message : " + e.getMessage());
		System.err.println("Cause : " + e.getCause());
		blnFlag = false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean FNManageusers_EditClickDeleteCheck(WebDriver driver, RunManagerInfo runManagerInfoObj) {
	boolean blnFlag = false;
	try {
		Thread.sleep(5000);
		if (cnf.FnExplicitWait("Xpath", mbo.UserDetail_EditBtn,driver)) {
			repfn.FnUpdateTestStepResHTML("Verify Edit button is displayed ","Edit button is displayed ", "PASS",runManagerInfoObj);
			WebElement UserDetail_EditBtn = driver.findElement(By.xpath(mbo.UserDetail_EditBtn));
			if (cnf.JSClick(UserDetail_EditBtn,driver)) {
				repfn.FnUpdateTestStepResHTML("Verify Edit button is clicked ","Edit button is clicked ", "PASS",runManagerInfoObj);

				if (cnf.FnExplicitWait("Xpath", mbo.EditMode_DeleteLink,driver)) {
					repfn.FnUpdateTestStepResHTML("Verify if Delete User Option is displayed","Delete User Option is displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
					driver.navigate().refresh();				
				} else {
					repfn.FnUpdateTestStepResHTML("Verify if Delete User Option is displayed","Delete User Option is not displayed","PASS",runManagerInfoObj);
					blnFlag = true;
					driver.navigate().refresh();
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
		repfn.FnUpdateTestStepResHTML("Verify if Delete User Option is not displayed","Delete User Option is displayed due to some exception","FAIL",runManagerInfoObj);
		System.err.println("Message : " + e.getMessage());
		System.err.println("Cause : " + e.getCause());
		blnFlag = false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean FNManageusers_AccountOwner(WebDriver driver, RunManagerInfo runManagerInfoObj) {
	boolean blnFlag = false;
	try{

		if(cnf.FnExplicitWait("XPATH",mbo.ManageUsers_RoleList,driver)){
			repfn.FnUpdateTestStepResHTML("Verify All users are displayed on Manage User Page", "All users are displayed on Manage User Page","PASS",runManagerInfoObj);
			List<WebElement> ManageUsers_RoleList=driver.findElements(By.xpath(mbo.ManageUsers_RoleList));
			List <WebElement> Users = new ArrayList<WebElement>();
			for(WebElement UserRole:ManageUsers_RoleList){
				if(UserRole.getText().equalsIgnoreCase("Account Owner")){
					Users.add(UserRole);
				}
			}
			if(Users.size() > 0){
				repfn.FnUpdateTestStepResHTML("Verify Users with Role as \"Account Owner\" are displayed on Manage User Page", 
						"Users with Role as \"Account Owner\"  are displayed on Manage User Page","PASS",runManagerInfoObj);

				WebElement User = Users.get(0);
				if(cnf.JSClick(User,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Account Owner is selected on Manage Users page", " Account Owner is selected on Manage Users page","PASS",runManagerInfoObj);
					Thread.sleep(2000);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify  Account Owner is selected on Manage Users page", " Account Owner is not selected on Manage Users page","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Users with Role as \"Account Owner\" are displayed on Manage User Page", 
						"Users with Role as \"Account Owner\"  are not displayed on Manage User Page","FAIL",runManagerInfoObj);
				blnFlag =false;
			} 
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify All users are displayed on Manage User Page", "All users are not displayed on Manage User Page","FAIL",runManagerInfoObj);
			blnFlag =false;
		}
	}
	catch (Exception e) {
		repfn.FnUpdateTestStepResHTML("Verify Users with Role as \"Account Owner\" are displayed on Manage User Page", 
				"Users with Role as \"Account Owner\"  are not displayed on Manage User Page due to some exception","FAIL",runManagerInfoObj);
		System.err.println("Message : " + e.getMessage());
		System.err.println("Cause : " + e.getCause());
		blnFlag = false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}

public synchronized boolean FNManageusers_EditClickDeleteOption(WebDriver driver, RunManagerInfo runManagerInfoObj) {
	boolean blnFlag = false;
	try {
		Thread.sleep(5000);
		if (cnf.FnExplicitWait("Xpath", mbo.UserDetail_EditBtn,driver)) {
			repfn.FnUpdateTestStepResHTML("Verify Edit link is displayed ", "Edit link is displayed ", "PASS",runManagerInfoObj);
			WebElement UserDetail_EditBtn = driver.findElement(By.xpath(mbo.UserDetail_EditBtn));
			if (cnf.JSClick(UserDetail_EditBtn,driver)) {
				repfn.FnUpdateTestStepResHTML("Verify Edit link is clicked ","Edit link is clicked ", "PASS",runManagerInfoObj);
				
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

				if (cnf.FnExplicitWait("Xpath", mbo.EditMode_DeleteLink,driver)) {
					repfn.FnUpdateTestStepResHTML("Verify if Delete User Option is displayed","Delete User Option is displayed","PASS",runManagerInfoObj);
					blnFlag=true;
					driver.navigate().refresh();				
				} else {
					repfn.FnUpdateTestStepResHTML("Verify if Delete User Option is displayed","Delete User Option is not displayed","FAIL",runManagerInfoObj);
					blnFlag = false;
					driver.navigate().refresh();
				}
			}
			else {
				repfn.FnUpdateTestStepResHTML("Verify Edit link is clicked ","Edit link is not clicked ", "FAIL",runManagerInfoObj);
				blnFlag = false;
			}
		} else {
			repfn.FnUpdateTestStepResHTML("Verify Edit link is displayed ","Edit link is not displayed ", "FAIL",runManagerInfoObj);
			blnFlag = false;
		}
	} catch (Exception e) {
		System.err.println("Message : " + e.getMessage());
		System.err.println("Cause : " + e.getCause());
		repfn.FnUpdateTestStepResHTML("Verify if Delete User Option is displayed","Delete User Option is not displayed due to some exception","FAIL",runManagerInfoObj);
		blnFlag = false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean FN_sucessMessageVerificationdummy(WebDriver driver, RunManagerInfo runManagerInfoObj){
	 try{
		 if(cnf.FnExplicitWait("XPATH", mbo.AddNewUser_Sucessmessage,driver)){
			repfn.FnUpdateTestStepResHTML("Verify User is taken back to Manage Users page with the confirmation message displayed full-width at top stating that the New User is successfully created.","User is taken back to Manage Users page with the confirmation message displayed full-width at top stating that the New User is successfully created.","PASS",runManagerInfoObj);
			 blnFlag=true;
		 }
		 else{
			 repfn.FnUpdateTestStepResHTML("Verify User is taken back to Manage Users page with the confirmation message displayed full-width at top stating that the New User is successfully created.","User is not  taken back to Manage Users page with the confirmation message displayed full-width at top stating that the New User is successfully created.","FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }
	 }

	 catch (Exception e)
	 {
		 repfn.FnUpdateTestStepResHTML("Verify User is taken back to Manage Users page with the confirmation message displayed full-width at top stating that the New User is successfully created.","User is not  taken back to Manage Users page with the confirmation message displayed full-width at top stating that the New User is successfully created due to some exception","FAIL",runManagerInfoObj);
		 blnFlag=false;
		 System.err.println("Message : "+e.getMessage());
		 System.err.println("Cause : "+e.getCause());
	 }
	 m1.put("STEPSTATUS", blnFlag);
	 return blnFlag;
}
public synchronized boolean FnConfirmbuttonClickdummy(WebDriver driver, RunManagerInfo runManagerInfoObj){
	try{
		if(cnf.FnExplicitWait("Xpath",mbo.AddNewUser_Confirmbtn,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Confirm button is displayed","Confirm button is displayed","PASS",runManagerInfoObj);
			WebElement AddNewUser_Confirmbtn=driver.findElement(By.xpath(mbo.AddNewUser_Confirmbtn));

			if(cnf.JSClick(AddNewUser_Confirmbtn,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Confirm button is Clicked ","Confirm button is Clicked","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Confirm button is Clicked ","Confirm button is not Clicked","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Confirm button is displayed","Confirm button is not displayed","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}

	catch (Exception e)
	{
		repfn.FnUpdateTestStepResHTML("Verify Confirm button is Clicked ","Confirm button is not Clicked due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean FnSkipButtonClick(WebDriver driver, RunManagerInfo runManagerInfoObj){
	try{
		if(cnf.FnExplicitWait("XPATH", mbo.NewUser_Step3_SkipVoice,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify if Skip link is present", "Skip Link is present", "PASS",runManagerInfoObj);
			WebElement Skip=driver.findElement(By.xpath(mbo.NewUser_Step3_SkipVoice));
			if(cnf.JSClick(Skip,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify Click the Skip link", "Skip link is clicked", "PASS",runManagerInfoObj);
				if(cnf.FnExplicitWait("XPATH", mbo.NewUser_Step4Navigated,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if the User is taken to the next step", "User is taken to Confirm Add New User page", "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify if the User is taken to the next step", "User is not taken to the next step", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Click the Skip link", "Skip link is not clickable", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify if Skip link is present", "Skip Link is not present", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}

	}

	catch (Exception e)
	{
		repfn.FnUpdateTestStepResHTML("Verify Confirm button is Clicked ","Confirm button is not Clicked due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean FN_NewUser_step3_UI(WebDriver driver, RunManagerInfo runManagerInfoObj){
	try{

		if(cnf.FnExplicitWait("XPATH", mbo.NewUser_Step3_SkipVoice,driver)){
			repfn.FnUpdateTestStepResHTML("Verify if Skip Link is present", "Skip Link is present", "PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify if Skip Link is present", "Skip Link is not present", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}

		if(cnf.FnExplicitWait("XPATH", mbo.NewUser_step3_text,driver)){

			repfn.FnUpdateTestStepResHTML("Verify if Assign Voice Services text is present","Assign Voice Services Text is present","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify if Assign Voice Services text is present","Assign Voice Services Text is not present","FAIL",runManagerInfoObj);
			blnFlag=false;
		}

		if(cnf.FnExplicitWait("XPATH", mbo.NewUser_Step3_ToolTip,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify if Tool tip is displayed", "Tool tip is displayed", "PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify if Tool tip is displayed", "Tool tip is not displayed", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}

		if(cnf.FnExplicitWait("XPATH", mbo.AddNewUser_AddVoiceLine,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify if Add New Voice Line link is displayed", "Add New VoiceLine Link is displayed", "PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else
		{
			if(cnf.FnExplicitWait("XPATH", mbo.NoVoiceLines,driver)) {		
				WebElement NoVoiceLinesmsg=driver.findElement(By.xpath(mbo.NoVoiceLinesmsg));
				String msg=NoVoiceLinesmsg.getText();
				repfn.FnUpdateTestStepResHTML("Verify if any Voice line is present or not","No voice line button is present as warning message displayed is: "+msg, "PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify No Voice line warning message is displayed","No Voice line warning message is not displayed", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}

		if(cnf.FnExplicitWait("XPATH", mbo.NewUser_step3_Back,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify if Back button is displayed", "Back button is displayed", "PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify if Back button is displayed", "Back button is not displayed", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}

		if(cnf.FnExplicitWait("XPATH", mbo.NewUser_Step3_Cancel,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify if Cancel button is displayed", "Cancel button is displayed", "PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify if Cancel button is displayed", "Cancel button is not displayed", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		
		if(cnf.FnExplicitWait("XPATH", mbo.AddNewUser_Nextbutton,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify if Next button is displayed", "Next button is displayed", "PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify if Next button is displayed", "Next button is not displayed", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}

	catch (Exception e)
	{
		repfn.FnUpdateTestStepResHTML("Verify User is able to verify Voice tab UI",
				"User is not able to verify Voice tab UI due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean fnManageConfirm(WebDriver driver, RunManagerInfo runManagerInfoObj)
{
	try
	{
		if(cnf.FnExplicitWait("XPATH", mbo.verifyVoiceLine,driver))
		{
			blnFlag=true;
			repfn.FnUpdateTestStepResHTML("Verify if user has navigated to confirmation page", "User has navigated to confirmation page", "PASS",runManagerInfoObj);
			if(Pattern.matches("\\(.*[0-9]\\)\\s+.*[0-9]+\\-.*[0-9]", driver.findElement(By.xpath(mbo.verifyVoiceLine)).getText()))
			{
				blnFlag=true;
				repfn.FnUpdateTestStepResHTML("Verify if phone number is in the format (XXX)XXX-XXXX", "Phone number is in the format (XXX)XXX-XXXX", "PASS",runManagerInfoObj);
				if(cnf.FnExplicitWait("XPATH", mbo.manageConfirmButton,driver)){
					WebElement confirmButton=driver.findElement(By.xpath(mbo.manageConfirmButton));
					if(cnf.JSClick(confirmButton,driver))
					{
						Thread.sleep(5000);
						blnFlag=true;
						repfn.FnUpdateTestStepResHTML("Verify if user has clicked the confirm button", "User has clicked the confirm button", "PASS",runManagerInfoObj);
						Thread.sleep(3000);
						if(cnf.FnExplicitWait("XPATH", "//div[@ng-click='toggleDetails($event, user)']/div[@class='sb-manage-users-list-column--name ng-binding']",driver)){
							List<WebElement> manageUsersList=driver.findElements(By.xpath("//div[@ng-click='toggleDetails($event, user)']/div[@class='sb-manage-users-list-column--name ng-binding']"));
							for(WebElement usersList:manageUsersList)
							{
								System.out.println("------------Text==============: "+Random_int_validation);
								if(usersList.getText().contains(Random_int_validation))
								{
									blnFlag=true;
									break;
								}
							}

							if(blnFlag)
							{
								blnFlag=true;
								repfn.FnUpdateTestStepResHTML("Verify if standard user added is saved", "Standard User added is saved", "PASS",runManagerInfoObj);
							}
							else
							{
								blnFlag=false;
								repfn.FnUpdateTestStepResHTML("Verify if standard user added is saved", "Standard User added is not saved", "FAIL",runManagerInfoObj);
							}
						}
						else{
							blnFlag=false;
							repfn.FnUpdateTestStepResHTML("Verify if User list is displayed", "User list is not displayed", "FAIL",runManagerInfoObj);
						}
					}
					else
					{
						blnFlag=false;
						repfn.FnUpdateTestStepResHTML("Verify if user has clicked the confirm button", "User has not clicked the confirm button", "FAIL",runManagerInfoObj);
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify if confirm button is displayed", "Confirm button is not displayed", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else
			{
				blnFlag=false;
				repfn.FnUpdateTestStepResHTML("Verify if phone number is in the format (XXX)XXX-XXXX", "phone number is not in the format (XXX)XXX-XXXX", "FAIL",runManagerInfoObj);
			}
		}
		else
		{
			blnFlag=false;
			repfn.FnUpdateTestStepResHTML("Verify if user has navigated to confirmation page", "User has navigated to confirmation page", "FAIL",runManagerInfoObj);
		}
	}
	catch(Exception e)
	{
		blnFlag=false;
		repfn.FnUpdateTestStepResHTML("Verify that the Account Owner/ Administrator user is able to create a New User", "Account Owner/ Administrator user is not able to create a New User due to some exception", "FAIL",runManagerInfoObj);
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean fnManageConfirmSkip(WebDriver driver, RunManagerInfo runManagerInfoObj)
{
	try
	{
		if(cnf.FnExplicitWait("XPATH", mbo.verifyVoiceLine,driver))
		{
			blnFlag=false;
			repfn.FnUpdateTestStepResHTML("Verify if voice line added is not saved", "Voice line added is saved", "FAIL",runManagerInfoObj);
		}
		else
		{
			blnFlag=true;
			repfn.FnUpdateTestStepResHTML("Verify if voice line added is not saved", "Voice line added is not saved", "PASS",runManagerInfoObj);
			if(cnf.FnExplicitWait("XPATH", mbo.manageConfirmButton,driver)){			
				WebElement confirmButton=driver.findElement(By.xpath(mbo.manageConfirmButton));
				if(cnf.JSClick(confirmButton,driver))
				{
					Thread.sleep(5000);
					blnFlag=true;
					repfn.FnUpdateTestStepResHTML("Verify if user has clicked the confirm button", "User has clicked the confirm button", "PASS",runManagerInfoObj);
					//WebElement cancelLink=driver.findElement(By.xpath(mbo.manageCancelLinkInPopUp));
					//cnf.JSClick(cancelLink);	
					Thread.sleep(5000);
				}
				else
				{
					blnFlag=false;
					repfn.FnUpdateTestStepResHTML("Verify if user has clicked the confirm button", "User has not clicked the confirm button", "FAIL",runManagerInfoObj);
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify if confirm button is displayed", "Confirm button is not displayed", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
	}
	catch(Exception e)
	{
		blnFlag=false;
		repfn.FnUpdateTestStepResHTML("Verify that the Account Owner/ Administrator user is able to create a New User", "Account Owner/ Administrator user is not able to create a New User due to some exception", "FAIL",runManagerInfoObj);
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean fnManageVoiceSkip(WebDriver driver, RunManagerInfo runManagerInfoObj)
{
	try
	{

		if(cnf.FnExplicitWait("XPATH",mbo.manageVoiceLineButton,driver))
		{
			blnFlag=true;
			repfn.FnUpdateTestStepResHTML("Verify if \"Add voice line\" button is present", "\"Add voice line\" button is present", "PASS",runManagerInfoObj);
			for(int i=0;i<1;i++)
			{
				if(cnf.isElementExist(By.xpath(mbo.manageVoiceLineButton),driver))
				{
					WebElement addVoiceLine=driver.findElement(By.xpath(mbo.manageVoiceLineButton));
					cnf.JSClick(addVoiceLine,driver);
					Thread.sleep(3000);
					blnFlag=true;
				}
			}
			if(blnFlag)
			{
				blnFlag=true;
				repfn.FnUpdateTestStepResHTML("Verify if user had added the voice lines", "User has added the voice lines", "PASS",runManagerInfoObj);
				if(cnf.FnExplicitWait("XPATH", mbo.manageSkip,driver))
				{
					blnFlag=true;
					repfn.FnUpdateTestStepResHTML("Verify if \"Skip\" link is present", "\"Skip\" link is present", "PASS",runManagerInfoObj);
					WebElement manageSkip=driver.findElement(By.xpath(mbo.manageSkip));
					if(cnf.JSClick(manageSkip,driver))
					{
						Thread.sleep(5000);
						blnFlag=true;
						repfn.FnUpdateTestStepResHTML("Verify if \"Skip\" link is clicked", "\"Skip\" link is clicked", "PASS",runManagerInfoObj);
					}
					else
					{
						blnFlag=false;
						repfn.FnUpdateTestStepResHTML("Verify if \"Skip\" link is clicked", "\"Skip\" link is clicked", "FAIL",runManagerInfoObj);
					}
				}
				else
				{
					blnFlag=false;
					repfn.FnUpdateTestStepResHTML("Verify if \"Skip\" link is present", "\"Skip\" link is not present", "FAIL",runManagerInfoObj);
				}
			}
			else
			{
				blnFlag=false;
				repfn.FnUpdateTestStepResHTML("Verify if user had added the voice lines", "User has not added the voice lines", "FAIL",runManagerInfoObj);
			}
		}
		else
		{
			if(cnf.FnExplicitWait("XPATH", mbo.NoVoiceLines,driver)) {				
				WebElement NoVoiceLinesmsg=driver.findElement(By.xpath(mbo.NoVoiceLinesmsg));
				String msg=NoVoiceLinesmsg.getText();
				repfn.FnUpdateTestStepResHTML("Verify if any Voice line is present or not","No voice line button is present as warning message displayed is: "+msg, "PASS",runManagerInfoObj);

				boolean blnFlag1 = app.FnUnassignVoiceLineAndReturn(driver,runManagerInfoObj);
				if(blnFlag1){
					boolean blnFlag2 = fnManageVoiceSkip(driver,runManagerInfoObj);
					if(blnFlag2){
						blnFlag = true;
					}
					else{
						blnFlag = false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User is able to unassign Voice Line and Return to adding a new user","User is not able to unassign Voice Line and Return to adding a new user", "FAIL",runManagerInfoObj);
					blnFlag = false;
				}				
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify No Voice line warning message is displayed","No Voice line warning message is not displayed", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
	}
	catch(Exception e)
	{
		blnFlag=false;
		repfn.FnUpdateTestStepResHTML("Verify that the Account Owner/ Administrator user is able to create a New User", "Account Owner/ Administrator user is not able to create a New User due to some exception", "FAIL",runManagerInfoObj);
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean FnDeleteUser(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
	
	String fullName = "";
	
	try{
		
		if(cnf.FnExplicitWait("XPATH",mbo.EditMode_firstName,driver)){
			WebElement EditMode_firstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
			String firstName = EditMode_firstName.getAttribute("value");
			if(cnf.FnExplicitWait("XPATH",mbo.EditMode_LastName,driver)){
				WebElement EditMode_LastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
				String lastName = EditMode_LastName.getAttribute("value");
				
				fullName = firstName+" "+lastName;
			}
		}
		
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
		
		if(cnf.FnExplicitWait("XPATH",mbo.DeleteUserLink,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Delete User link is displayed on Edit User page", "Delete User link is displayed on Edit User page","PASS",runManagerInfoObj);
			WebElement DeleteUserLink=driver.findElement(By.xpath(mbo.DeleteUserLink));
			//cnf.ScrollToView(DeleteUserLink);
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(mbo.DeleteUserLink)));
			driver.manage().window().setSize(new Dimension(100, 100));
			driver.manage().window().maximize();
			
			if(cnf.JSClick(DeleteUserLink,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Delete User link is clicked", "Delete User link is clicked","PASS",runManagerInfoObj);
				
				driver.manage().window().setSize(new Dimension(100, 100));
				driver.manage().window().maximize();
				
				if(cnf.FnExplicitWait("XPATH",mbo.ConfirmCancel,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Confirmation pop-up is displayed", "Confirmation pop-up is displayed","PASS",runManagerInfoObj);
					repfn.FnUpdateTestStepResHTML("Verify Confirm link is displayed", "Confirm link is displayed","PASS",runManagerInfoObj);
					WebElement ConfirmCancel=driver.findElement(By.xpath(mbo.ConfirmCancel));
					if(cnf.JSClick(ConfirmCancel,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Confirm link is clicked", "Confirm link is clicked","PASS",runManagerInfoObj);
						
						Thread.sleep(5000);
						
						if(cnf.FnExplicitWait("XPATH",mbo.AssignLineSearchBar,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Search bar is displayed", "Search bar is displayed","PASS",runManagerInfoObj);
							WebElement AssignLineSearchBar=driver.findElement(By.xpath(mbo.AssignLineSearchBar));
							AssignLineSearchBar.clear();
							AssignLineSearchBar.sendKeys(fullName);
							
							if(cnf.FnExplicitWait("XPATH",mbo.ManageUsers_RoleList,driver)){
								repfn.FnUpdateTestStepResHTML("Verify User is deleted", "User is not deleted","FAIL",runManagerInfoObj);
								blnFlag	=false;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify User is deleted", "User is deleted successfully","PASS",runManagerInfoObj);
								blnFlag	=true;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Search bar is displayed", "Search bar is not displayed","FAIL",runManagerInfoObj);
							blnFlag	=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Confirm link is clicked", "Confirm link is not clicked","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Confirm link is displayed", "Confirm link is not displayed","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Delete User link is clicked", "Delete User link is not clicked","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Delete User link is displayed on Edit User page", "Delete User link is not displayed on Edit User page","FAIL",runManagerInfoObj);
			blnFlag	=false;
		}
		
	}
	
	catch(Exception e)
	{
		repfn.FnUpdateTestStepResHTML("Verify Contact is present in Contacts List ", "Contact is not present in Contacts List  due to some exception","FAIL",runManagerInfoObj);
		blnFlag	=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}

	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
	
	
}
public synchronized boolean FN_NewUser_step2_BackButton(WebDriver driver, RunManagerInfo runManagerInfoObj)
{
	try{

		if(cnf.FnExplicitWait("XPATH", mbo.NewUser_step3_Back,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify if Back button is displayed", "Back button is displayed", "PASS",runManagerInfoObj);
			WebElement AddNewUser_Confirm=driver.findElement(By.xpath(mbo.NewUser_step3_Back));
			cnf.JSClick(AddNewUser_Confirm,driver);
			repfn.FnUpdateTestStepResHTML("Verify Click on Back button", "Back button is clicked", "PASS",runManagerInfoObj);
			if(cnf.FnExplicitWait("XPATH", mbo.AddNewUser_FirstName,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify if User is taken to previous page", "User is returned to the previous page", "PASS",runManagerInfoObj);
				driver.navigate().refresh();
				app.AlertAccept(driver,runManagerInfoObj);
				blnFlag=true;
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if User is taken to previous page", "User is not taken back to previous page", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify if Back button is displayed", "Back button is not displayed", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}

	catch (Exception e)
	{
		repfn.FnUpdateTestStepResHTML("Verify if User is taken to previous page", "User is not taken back to previous page due to some exception", "FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean FN_NewUser_step2_Confirmationpopup_Confirmclick(WebDriver driver, RunManagerInfo runManagerInfoObj)
{
	try{

		if(cnf.FnExplicitWait("XPATH", mbo.NewUser_step2_Confirm,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify if Confirm button is displayed in the Confirmation popup", "Confirm button is displayed in the Confirmation popup", "PASS",runManagerInfoObj);
			WebElement AddNewUser_Confirm=driver.findElement(By.xpath(mbo.NewUser_step2_Confirm));
			cnf.JSClick(AddNewUser_Confirm,driver);
			repfn.FnUpdateTestStepResHTML("Verify Click on Confirm", "Confirm button is clicked", "PASS",runManagerInfoObj);
			if(cnf.FnExplicitWait("XPATH", mbo.AddNewUserLink,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify if User is taken to Manage Users page", "User is returned to the Manage Users page and the changes are discarded.", "PASS",runManagerInfoObj);
				driver.navigate().refresh();
				blnFlag=true;			 
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if User is taken to Manage Users page", "User is not taken back to Manage Users page", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify if Confirm button is displayed in the Confirmation popup", "Confirm button is not displayed in the Confirmation popup", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}

	catch (Exception e)
	{
		repfn.FnUpdateTestStepResHTML("Verify if User is taken to Manage Users page", "User is not taken back to Manage Users page due to some exception", "FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean FN_NewUser_step2_Cancelclick(WebDriver driver, RunManagerInfo runManagerInfoObj){
	try{

		if(cnf.FnExplicitWait("XPATH", mbo.NewUser_Step3_Cancel,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify if Cancel button is displayed", "Cancel button is displayed", "PASS",runManagerInfoObj);
			WebElement AddNewUser_Cancel=driver.findElement(By.xpath(mbo.NewUser_Step3_Cancel));
			Thread.sleep(3000);
			if(cnf.ElementClick1(AddNewUser_Cancel))
			{
				repfn.FnUpdateTestStepResHTML("Verify Click on Cancel", "Cancel button is clicked", "PASS",runManagerInfoObj);
				Thread.sleep(1000);
				if(cnf.FnExplicitWait("XPATH", mbo.NewUser_Step2_Confirmationpopup,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if Confirmation popup is displayed", "confirmation popup is displayed", "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify if Confirmation popup is displayed", "confirmation popup is not displayed", "FAIL",runManagerInfoObj);
					blnFlag=false; 
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Click on Cancel", "Cancel button is not clicked", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}

		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify if Cancel button is displayed", "Cancel button is not displayed", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}

	 catch (Exception e)

	 {
		

		 blnFlag=false;
		 System.err.println("Message : "+e.getMessage());
		 System.err.println("Cause : "+e.getCause());

	 }
	 m1.put("STEPSTATUS", blnFlag);
	 return blnFlag;
}
public synchronized boolean FN_NewUser_step2_Confirmationpopup_Cancelclick(WebDriver driver, RunManagerInfo runManagerInfoObj){
	try{

		if(cnf.FnExplicitWait("XPATH", mbo.AddNewUser_Cancelbtn,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify if Cancel button is displayed in the Confirmation popup", "Cancel button is displayed in the Confirmation popup", "PASS",runManagerInfoObj);
			WebElement AddNewUser_Cancel1=driver.findElement(By.xpath(mbo.AddNewUser_Cancelbtn));
			cnf.JSClick(AddNewUser_Cancel1,driver);
			repfn.FnUpdateTestStepResHTML("Click on Cancel", "Cancel button is clicked", "PASS",runManagerInfoObj);
			if(cnf.FnExplicitWait("XPATH", mbo.AddNewUser_StandardRadiobtn,driver))
			{
				WebElement Standard=driver.findElement(By.xpath(mbo.AddNewUser_StandardRadiobtn));
				if(Standard.isSelected())
				{
					repfn.FnUpdateTestStepResHTML("Verify if User is returned to Set User Permissions screen with the permission selected", "User is returned to Set User Permissions screen with the permission selected", "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify if User is returned to Set User Permissions screen with the permission selected", "User is not returned to Set User Permissions screen with the permission selected", "FAIL",runManagerInfoObj);
					blnFlag=false; 
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Standard User Radio button is displayed", "Standard User Radio button is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}			
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify if Cancel button is displayed in the Confirmation popup", "Cancel button is not displayed in the Confirmation popup", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}

	catch (Exception e)
	{
		repfn.FnUpdateTestStepResHTML("Verify if User is returned to Set User Permissions screen with the permission selected", "User is not returned to Set User Permissions screen with the permission selected due to some exception", "FAIL",runManagerInfoObj);
		blnFlag=false; 
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}

}
