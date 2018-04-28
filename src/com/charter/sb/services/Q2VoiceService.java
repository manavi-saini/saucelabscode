package com.charter.sb.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.charter.sb.beans.RunManagerInfo;
import com.charter.sb.controllers.Initialization;
import com.charter.sb.resources.MB_PageObjects;
import com.charter.sb.utils.CommonFunctions;
import com.charter.sb.utils.ReportingFunctions;
import com.charter.sb.utils.RunManager;

public class Q2VoiceService extends Initialization {
	MB_PageObjects mbo = new MB_PageObjects();
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	public static boolean blnFlag = false;
	Random rg=new Random();
	int randomInt = rg.nextInt(10000);
	String forwardStatus;
	public synchronized boolean FnBlockContact(WebDriver driver, RunManagerInfo runManagerInfoObj)
	{
		try
		{
			if(cnf.FnExplicitWait("XPATH", mbo.Savedcontacts,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify Call logs are displayed", "Call logs are displayed","PASS",runManagerInfoObj);
				List <WebElement> SavedCallLogDetails=driver.findElements(By.xpath(mbo.Savedcontacts));
				List <WebElement> SavedCallLogDetail=new ArrayList();
				
				for(WebElement Contact:SavedCallLogDetails)
				{
					if(Contact.getText().contains("("))
					{
						SavedCallLogDetail.add(Contact);
					}
				}
				
				if(SavedCallLogDetail.size()>0)
				{
					repfn.FnUpdateTestStepResHTML("Verify Call logs are displayed for Unsaved Contacts", "Call logs are displayed for Unsaved Contacts","PASS",runManagerInfoObj);
					for(int i=0;i<1;i++)
					{
						String ContactsText=SavedCallLogDetail.get(i).getText();
						if(cnf.JSClick(SavedCallLogDetail.get(i),driver)){
							repfn.FnUpdateTestStepResHTML("Verify if Unsaved Call log is clicked", "Unsaved Call log is clicked: "+ContactsText,"PASS",runManagerInfoObj);
							Thread.sleep(2000);
							if(cnf.FnExplicitWait("XPATH",mbo.Block,driver))
							{
								repfn.FnUpdateTestStepResHTML("Check Whether Block link is present or not ", "Block link is present for Unsaved contact : " +ContactsText,"PASS",runManagerInfoObj);
								WebElement Block=driver.findElement(By.xpath(mbo.Block));
								if(cnf.JSClick(Block,driver)){
									repfn.FnUpdateTestStepResHTML("Verify if Block link is clicked or not", "Block link is clicked ","PASS",runManagerInfoObj);
									if(cnf.FnExplicitWait("XPATH", mbo.Voice_ConfirmPopup,driver)){
										repfn.FnUpdateTestStepResHTML("Check Whether Confirmation popup present or not ", "Confirmation popup is present" ,"PASS",runManagerInfoObj);
										WebElement ConfirmMessage=driver.findElement(By.xpath(mbo.Voice_ConfirmPopup));

										repfn.FnUpdateTestStepResHTML("Check Whether Confirm option present or not to block the unsaved contact ", "Confirm option is present" ,"PASS",runManagerInfoObj);
										if(cnf.JSClick(ConfirmMessage,driver)){
											repfn.FnUpdateTestStepResHTML("Check Whether Confirm option clicked or not to block the contact ", "Confirm option is clicked to block contact" ,"PASS",runManagerInfoObj);
											Thread.sleep(3000);
											
											if(cnf.FnExplicitWait("Xpath", mbo.Unblockbtn,driver))
											{
												repfn.FnUpdateTestStepResHTML("Verify if Unsaved contact is blocked  ","Unsaved Contact is blocked as Unblock link is getting displayed","PASS",runManagerInfoObj);
												blnFlag=app.FN_BackButtonClick(driver,runManagerInfoObj);
												if(blnFlag){
													blnFlag = true;
												}
												else{
													blnFlag = false;
												}
											}
											else{									
												if(cnf.FnExplicitWait("XPATH", mbo.Voice_Block_ErrorMessage,driver)){	
													WebElement Voice_Block_ErrorMessage=driver.findElement(By.xpath(mbo.Voice_Block_ErrorMessage));
													repfn.FnUpdateTestStepResHTML("Check Whether Unsaved contact is blocked or not", "Unable to block number error message is displayed: "+Voice_Block_ErrorMessage.getText(),"FAIL",runManagerInfoObj);	
													blnFlag=false;
													driver.navigate().refresh();
												}
												else{
													System.out.println("iNSIDE ELSE ");
													repfn.FnUpdateTestStepResHTML("Check Whether Unsaved contact is blocked or not", "Contact is not blocked as Block link is getting displayed","FAIL",runManagerInfoObj);	
													blnFlag=false;
												}
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Check Whether Confirm option clicked or not to block the contact ", "Confirm option is not clicked to block contact" ,"FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Check Whether Confirmation popup is present or not ", "Confirmation popup is not present" ,"FAIL",runManagerInfoObj);	
										repfn.FnUpdateTestStepResHTML("Check Whether Confirm option present or not to block the unsaved contact ", "Confirm option is not present" ,"FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify if Block link is clicked or not", "Block link is not clicked ","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								if(cnf.FnExplicitWait("XPATH",mbo.Unblockbtn,driver))
								{
									repfn.FnUpdateTestStepResHTML("Check Whether UnBlock link is present or not ", "UnBlock link is present for Unsaved contact : " +ContactsText,"PASS",runManagerInfoObj);
									WebElement Unblock=driver.findElement(By.xpath(mbo.Unblockbtn));
									if(cnf.JSClick(Unblock,driver)){
										repfn.FnUpdateTestStepResHTML("Verify if Unblock link is clicked or not","Unblock link is clicked","PASS",runManagerInfoObj);
										Thread.sleep(3000);
										if(cnf.FnExplicitWait("XPATH",mbo.Block,driver))
										{
											repfn.FnUpdateTestStepResHTML("Check Whether Block link is present or not ", "Block link is present for Unsaved contact : " +ContactsText,"PASS",runManagerInfoObj);
											WebElement Block=driver.findElement(By.xpath(mbo.Block));
											if(cnf.JSClick(Block,driver)){
												repfn.FnUpdateTestStepResHTML("Verify if Block link is clicked or not", "Block link is clicked ","PASS",runManagerInfoObj);
												if(cnf.FnExplicitWait("XPATH", mbo.Voice_ConfirmPopup,driver)){
													repfn.FnUpdateTestStepResHTML("Check Whether Confirmation popup present or not ", "Confirmation popup is present" ,"PASS",runManagerInfoObj);
													WebElement ConfirmMessage=driver.findElement(By.xpath(mbo.Voice_ConfirmPopup));

													repfn.FnUpdateTestStepResHTML("Check Whether Confirm option present or not to block the unsaved contact ", "Confirm option is present" ,"PASS",runManagerInfoObj);
													if(cnf.JSClick(ConfirmMessage,driver)){
														repfn.FnUpdateTestStepResHTML("Check Whether Confirm option clicked or not to block the contact ", "Confirm option is clicked to block contact" ,"PASS",runManagerInfoObj);
														Thread.sleep(3000);
														
														if(cnf.FnExplicitWait("Xpath", mbo.Unblockbtn,driver))
														{
															repfn.FnUpdateTestStepResHTML("Verify if Unsaved contact is blocked  ","Unsaved Contact is blocked as Unblock link is getting displayed","PASS",runManagerInfoObj);
															blnFlag=app.FN_BackButtonClick(driver,runManagerInfoObj);
															if(blnFlag){
																blnFlag = true;
															}
															else{
																blnFlag = false;
															}
														}
														else{									
															if(cnf.FnExplicitWait("XPATH", mbo.Voice_Block_ErrorMessage,driver)){	
																WebElement Voice_Block_ErrorMessage=driver.findElement(By.xpath(mbo.Voice_Block_ErrorMessage));
																repfn.FnUpdateTestStepResHTML("Check Whether Unsaved contact is blocked or not", "Unable to block number error message is displayed: "+Voice_Block_ErrorMessage.getText(),"FAIL",runManagerInfoObj);	
																blnFlag=false;
																driver.navigate().refresh();
															}
															else{
																System.out.println("iNSIDE ELSE ");
																repfn.FnUpdateTestStepResHTML("Check Whether Unsaved contact is blocked or not", "Contact is not blocked as Block link is getting displayed","FAIL",runManagerInfoObj);	
																blnFlag=false;
															}
														}
													}
													else{
														repfn.FnUpdateTestStepResHTML("Check Whether Confirm option clicked or not to block the contact ", "Confirm option is not clicked to block contact" ,"FAIL",runManagerInfoObj);
														blnFlag=false;
													}
												}
												else{
													repfn.FnUpdateTestStepResHTML("Check Whether Confirmation popup is present or not ", "Confirmation popup is not present" ,"FAIL",runManagerInfoObj);	
													repfn.FnUpdateTestStepResHTML("Check Whether Confirm option present or not to block the unsaved contact ", "Confirm option is not present" ,"FAIL",runManagerInfoObj);
													blnFlag=false;
												}
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify if Block link is clicked or not", "Block link is not clicked ","FAIL",runManagerInfoObj);
												blnFlag=false;
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify if Block link is present or not", "Block link is not present ","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify if Unblock link is clicked or not","Unblock link is not clicked","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify if Unblock link is present or not","Unblock link is not present","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify if Unsaved Call log is clicked", "Unsaved Call log is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Call logs are displayed for Unsaved Contacts", "Call logs are not displayed for Unsaved Contacts","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Call logs are displayed", "Call logs are not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}

		catch (Exception e)

		{
			repfn.FnUpdateTestStepResHTML("Verify if unsaved contact is blocked or not in call log", " Unsaved contact is not blocked in call log due to some exception", "FAIL",runManagerInfoObj);
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			blnFlag=false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;

	}

	public synchronized boolean FnCancelBlock(WebDriver driver, RunManagerInfo runManagerInfoObj)
	{
		try
		{
			if(cnf.FnExplicitWait("XPATH", mbo.Savedcontacts,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify Call logs are displayed", "Call logs are displayed","PASS",runManagerInfoObj);
				List <WebElement> SavedCallLogDetails=driver.findElements(By.xpath(mbo.Savedcontacts));
				List <WebElement> SavedCallLogDetail=new ArrayList();
				
				for(WebElement Contact:SavedCallLogDetails)
				{
					if(Contact.getText().contains("("))
					{
						SavedCallLogDetail.add(Contact);
					}
				}
				
				if(SavedCallLogDetail.size()>0)
				{
					repfn.FnUpdateTestStepResHTML("Verify Call logs are displayed for Unsaved Contacts", "Call logs are displayed for Unsaved Contacts","PASS",runManagerInfoObj);
					for(int i=0;i<1;i++)
					{
						String ContactsText=SavedCallLogDetail.get(i).getText();
						if(cnf.JSClick(SavedCallLogDetail.get(i),driver)){
							repfn.FnUpdateTestStepResHTML("Verify if Unsaved Call log is clicked", "Unsaved Call log is clicked: "+ContactsText,"PASS",runManagerInfoObj);
							Thread.sleep(2000);
							
							if(cnf.FnExplicitWait("XPATH",mbo.Block,driver))
							{
								repfn.FnUpdateTestStepResHTML("Check Whether Block link is present or not ", "Block link is present for Unsaved contact : " +ContactsText,"PASS",runManagerInfoObj);
								WebElement Block=driver.findElement(By.xpath(mbo.Block));
								Thread.sleep(3000);
								if(cnf.JSClick(Block,driver)){
									repfn.FnUpdateTestStepResHTML("Verify if Block link is clicked or not", "Block link is clicked ","PASS",runManagerInfoObj);
									
									boolean blnFlag1=app.Confirmationpopup(driver,runManagerInfoObj);
									if(blnFlag1){
										repfn.FnUpdateTestStepResHTML("Verify if Confirmation popup is displayed","Confirmation popup is displayed","PASS",runManagerInfoObj);
										boolean blnFlag2=Cancel_Block(driver,runManagerInfoObj);
										if(blnFlag2){
											repfn.FnUpdateTestStepResHTML("Verify if Blocking a contact is cancelled","Blocking a contact is cancelled as Block link is getting displayed","PASS",runManagerInfoObj);
											blnFlag=true;
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify if Blocking a contact is cancelled","Blocking a contact is not cancelled","FAIL",runManagerInfoObj);
											blnFlag=false; 
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify if Confirmation popup is displayed","Confirmation popup is not displayed","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify if Block link is clicked or not", "Block link is not clicked ","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								if(cnf.FnExplicitWait("XPATH",mbo.Unblockbtn,driver))
								{
									repfn.FnUpdateTestStepResHTML("Check Whether UnBlock link is present or not ", "UnBlock link is present for Unsaved contact : " +ContactsText,"PASS",runManagerInfoObj);
									WebElement Unblock=driver.findElement(By.xpath(mbo.Unblockbtn));
									if(cnf.JSClick(Unblock,driver)){
										repfn.FnUpdateTestStepResHTML("Verify if Unblock link is clicked or not","Unblock link is clicked","PASS",runManagerInfoObj);
										Thread.sleep(3000);
										if(cnf.FnExplicitWait("XPATH",mbo.Block,driver))
										{
											repfn.FnUpdateTestStepResHTML("Check Whether Block link is present or not ", "Block link is present for Unsaved contact : " +ContactsText,"PASS",runManagerInfoObj);
											WebElement Block=driver.findElement(By.xpath(mbo.Block));
											if(cnf.JSClick(Block,driver)){
												repfn.FnUpdateTestStepResHTML("Verify if Block link is clicked or not", "Block link is clicked ","PASS",runManagerInfoObj);
												
												boolean blnFlag1=app.Confirmationpopup(driver,runManagerInfoObj);
												if(blnFlag1){
													repfn.FnUpdateTestStepResHTML("Verify if Confirmation popup is displayed","Confirmation popup is displayed","PASS",runManagerInfoObj);
													boolean blnFlag2=Cancel_Block(driver,runManagerInfoObj);
													if(blnFlag2){
														repfn.FnUpdateTestStepResHTML("Verify if Blocking a contact is cancelled","Blocking a contact is cancelled as Block link is getting displayed","PASS",runManagerInfoObj);
														blnFlag=true;
													}
													else{
														repfn.FnUpdateTestStepResHTML("Verify if Blocking a contact is cancelled","Blocking a contact is not cancelled","FAIL",runManagerInfoObj);
														blnFlag=false; 
													}
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify if Confirmation popup is displayed","Confirmation popup is not displayed","FAIL",runManagerInfoObj);
													blnFlag=false;
												}
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify if Block link is clicked or not", "Block link is not clicked ","FAIL",runManagerInfoObj);
												blnFlag=false;
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify if Block link is present or not", "Block link is not present ","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify if Unblock link is clicked or not","Unblock link is not clicked","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify if Unblock link is present or not","Unblock link is not present","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify if Unsaved Call log is clicked", "Unsaved Call log is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Call logs are displayed for Unsaved Contacts", "Call logs are not displayed for Unsaved Contacts","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Call logs are displayed", "Call logs are not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}

		catch (Exception e)

		{
			repfn.FnUpdateTestStepResHTML("Verify if Block operation can be cancelled", "block operation could not be cancelled", "FAIL",runManagerInfoObj);
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			blnFlag=false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;

	}
	public synchronized boolean Cancel_Block(WebDriver driver, RunManagerInfo runManagerInfoObj)
	{
		try
		{

			if(cnf.FnExplicitWait("XPATH",mbo.Cancelbtn_Block,driver ))
			{
				WebElement Cancel=driver.findElement(By.xpath(mbo.Cancelbtn_Block));
				repfn.FnUpdateTestStepResHTML("Verify if Cancel button is displayed","Cancel button is displayed","PASS",runManagerInfoObj);
				if(cnf.JSClick(Cancel,driver)){
					repfn.FnUpdateTestStepResHTML("Verify if Cancel button is clicked or not","Cancel button is clicked","PASS",runManagerInfoObj);
					if(cnf.FnExplicitWait("XPATH", mbo.Block,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify if Block a contact is cancelled","Block a contact is cancelled as Block link is getting displayed","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify if Block a contact is cancelled","Block a contact is not cancelled","FAIL",runManagerInfoObj);
						blnFlag=false; 
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify if Cancel button is clicked or not","Cancel button is not clicked","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if Cancel button is displayed","Cancel button is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		catch (Exception e)

		{
			repfn.FnUpdateTestStepResHTML("Verify if Cancel button is not clicked","Cancel button is not clicked due to some exception","FAIL",runManagerInfoObj);
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			blnFlag=false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	
	
	
	
	public synchronized boolean FnVerifyBlockOption_UnsavedContact(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

		try{
			if(cnf.FnExplicitWait("XPATH",mbo.Savedcontacts,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Call logs are displayed on Call Log page", "Call logs are displayed on Call Log page", "PASS",runManagerInfoObj);
				List <WebElement> CallLogDetails=driver.findElements(By.xpath(mbo.Savedcontacts));
				List <WebElement> ContactNumbers=new ArrayList<WebElement>();

				for(WebElement Contact:CallLogDetails){
					String Contacts=Contact.getText();
					if((Contacts.contains("(")))
					{
						ContactNumbers.add(Contact);
					}
				}

				if(ContactNumbers.size() > 0){
					repfn.FnUpdateTestStepResHTML("Verify Unsaved Numbers are present in Call Log List", "Unsaved Numbers are present in Call Log List","PASS",runManagerInfoObj);

					if(cnf.JSClick(ContactNumbers.get(0),driver)){
						repfn.FnUpdateTestStepResHTML("Verify Unsaved contact is clicked", "Unsaved contact is clicked","PASS",runManagerInfoObj);
						if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
							repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

							if(cnf.FnExplicitWait("XPATH",mbo.block_Check,driver)){
								repfn.FnUpdateTestStepResHTML("Verify User has an option to block the Unsaved Contact","User has an option to block the Unsaved Contact","PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else{
								if(cnf.FnExplicitWait("XPATH",mbo.Unblock_Check,driver)){
									repfn.FnUpdateTestStepResHTML("Verify User has an option to block the Unsaved Contact","User does not have an option to block the Unsaved Contact. It is already blocked.","PASS",runManagerInfoObj);

									WebElement Unblock_Check=driver.findElement(By.xpath(mbo.Unblock_Check));
									if(cnf.JSClick(Unblock_Check,driver)){
										repfn.FnUpdateTestStepResHTML("Verify Unblock link is clicked", "Unblock link is clicked","PASS",runManagerInfoObj);

										Thread.sleep(5000);

										if(cnf.FnExplicitWait("XPATH",mbo.block_Check,driver)){
											repfn.FnUpdateTestStepResHTML("Verify User has an option to block the Unsaved Contact","User has an option to block the Unsaved Contact","PASS",runManagerInfoObj);
											blnFlag=true;
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify User has an option to block the Unsaved Contact","User does not have an option to block the Unsaved Contact","FAIL",runManagerInfoObj);
											blnFlag=false;
										}

									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Unblock link is clicked", "Unblock link is not clicked","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify User has an option to unblock the Unsaved Contact","User does not have an option to unblock the Unsaved Contact. It is already unblocked","PASS",runManagerInfoObj);
									blnFlag=true;
								}
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}

					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Unsaved contact is clicked", "Unsaved contact is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Unsaved Numbers are present in Call Log List", "Unsaved Numbers are not present in Call Log List","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Call logs are displayed on Call Log page", "Call logs are not displayed on Call Log page", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}

		catch (Exception e)

		{		
			repfn.FnUpdateTestStepResHTML("Verify if User is able to verify Block option for Unsaved Contact", "User is not able to verify Block option for Unsaved Contact due to some exception", "FAIL",runManagerInfoObj);
			blnFlag=false;
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
		}

		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;

	}
	
	 public synchronized boolean Fn_FwdAllCallsOptionCheck(WebDriver driver, RunManagerInfo runManagerInfoObj){
		 try{

			 if (cnf.FnExplicitWait("XPATH", mbo.VoiceSettingsMenu_FwdAllCalls,driver)) {

				 WebElement FwdAllCallsOption = driver.findElement(By.xpath(mbo.VoiceSettingsMenu_FwdAllCalls));
				 repfn.FnUpdateTestStepResHTML("Verify the presence of Forward all call options in Voice Setting menu ","Forward all call options in Voice Setting menu is present","PASS",runManagerInfoObj);

				 Thread.sleep(3000);
				 if (cnf.ElementClick1(FwdAllCallsOption)) {
					 repfn.FnUpdateTestStepResHTML("Verify the click of Forward all call options in Voice Setting menu ","Forward all call options in Voice Setting menu is clicked","PASS",runManagerInfoObj);
					 if (cnf.FnExplicitWait("XPATH", mbo.ForwardStatusOFFToggle,driver)) {
						 repfn.FnUpdateTestStepResHTML("Verify the presence of Forward status OFF toggle button","Forward status OFF toggle button is present","PASS",runManagerInfoObj);
						 blnFlag = app.ForwardingStatus_change(driver,runManagerInfoObj);
						 if (blnFlag) {
							 blnFlag = true;
						 } else {
							 blnFlag = false;
						 }

					 }
					 else if (cnf.FnExplicitWait("XPATH",mbo.ForwardStatusONToggle,driver)) {
						 repfn.FnUpdateTestStepResHTML("Verify the presence of Forward status ON toggle button","Forward status ON toggle button is present","PASS",runManagerInfoObj);
						 blnFlag = true;
					 }

				 } else {
					 repfn.FnUpdateTestStepResHTML("Verify the click of Forward All Calls button ","Forward All Calls button is not clicked", "FAIL",runManagerInfoObj);
					 blnFlag = false;
				 }
			 } else {
				 repfn.FnUpdateTestStepResHTML("Verify the presence of Forward all call options in Voice Setting menu ","Forward all call options in Voice Setting menu is not present","FAIL",runManagerInfoObj);
				 blnFlag = false;
			 }

		 } catch (Exception e) {
			 repfn.FnUpdateTestStepResHTML("Verify the presence of Forward all call options in Voice Setting menu ","Forward all call options in Voice Setting menu is not present","FAIL",runManagerInfoObj);
			 blnFlag = false;
		 }

		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;

	 }
	
	 public synchronized boolean FN_DeleteNewExternalforwardingDestination(WebDriver driver,RunManagerInfo runManagerInfoObj)
		{
			try
			{
				boolean blnFlag1 = app.ManageForwardingLines(driver,runManagerInfoObj);
				if (blnFlag1) {
					boolean blnFlag2 = app.AddNewPhoneNumber_FillDetails(driver,runManagerInfoObj);
					if(blnFlag2){
						boolean blnFlag3 = app.ManageforwardingLines_Save(driver,runManagerInfoObj);
						if(blnFlag3){
							boolean blnFlag4 = ManageForwardingLines_DropdownCheck(driver,runManagerInfoObj);
							if(blnFlag4){
								boolean blnFlag5 = DeleteNewExternalforwardingDestination(driver,runManagerInfoObj);
								if(blnFlag5){
									boolean blnFlag6 = ManageForwardingLines_DropdownCheckDelete(driver,runManagerInfoObj);
									if(blnFlag6){
										if (cnf.FnExplicitWait("XPATH",mbo.ForwardStatusONToggle,driver)) {
											repfn.FnUpdateTestStepResHTML("Verify the presence of Forward ON status toggle","Forward ON status toggle is present","PASS",runManagerInfoObj);

											boolean blnFlag7 = app.ForwardingStatus_change(driver,runManagerInfoObj);
											if (blnFlag7) {
												boolean blnFlag8 = app.ForwardCalls_Save(driver,runManagerInfoObj);
												if (blnFlag8) {
													blnFlag = true;
												} 
												else {
													blnFlag = false;
												}
											} 
											else {
												repfn.FnUpdateTestStepResHTML("Verify if Call Forwarding status toggle can be changed","Call Forwarding status Toggle cannot be changed","FAIL",runManagerInfoObj);
												blnFlag = false;
											}
										} else {
											repfn.FnUpdateTestStepResHTML("Verify the presence of Forward ON status toggle","Forward ON status toggle is not present","FAIL",runManagerInfoObj);
											blnFlag = false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify if Newly Added external forwarding destination is deleted","Newly Added external forwarding destination is not deleted","FAIL",runManagerInfoObj); 
										blnFlag=false;
									}
								}
								else{
									blnFlag = false;
									repfn.FnUpdateTestStepResHTML("New forwarding destination could not be deleted","New forwarding destination could not be deleted", "FAIL",runManagerInfoObj);
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify if Newly Added external forwarding destination is present","Newly Added external forwarding destination is not present","FAIL",runManagerInfoObj); 
								blnFlag=false; 
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Save button is displayed and clicked","Save button is not displayed and clicked", "FAIL",runManagerInfoObj);
							blnFlag = false;
						}
					}
					else{
						blnFlag = false;
						repfn.FnUpdateTestStepResHTML("Verify if Add New Phone Number is displayed and clicked to add a new entry","Add New Phone Number is not displayed and clicked", "FAIL",runManagerInfoObj);
					}
				} else {
					repfn.FnUpdateTestStepResHTML("Verify if Manage Forwarding Lines is displayed and clicked","Manage Forwarding Lines is not displayed and clicked", "FAIL",runManagerInfoObj);
					blnFlag = false;
				}
				// SaveChanges_ForwardingCallManager();
				// Close_ManageLines();
				driver.navigate().refresh();
			} 
			
			catch (Exception e) {
				blnFlag = false;
				repfn.FnUpdateTestStepResHTML("New forwarding destination could not be deleted","New forwarding destination could not be deleted due to some exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;


		}
		

		
		
		//To check if new external forwarding destination is displayed in the dropdown//

		public synchronized boolean ManageForwardingLines_DropdownCheck(WebDriver driver, RunManagerInfo runManagerInfoObj)
		{
			String NewAliasAdd = m1.get("AliasName").toString();
			try
			{
				if(cnf.FnExplicitWait("XPATH", mbo.ForwardAllCallsTo_Dropdown,driver))
				{
					WebElement ForwardAllCallsTo_dropdown = driver.findElement(By.xpath(mbo.ForwardAllCallsTo_Dropdown));

					repfn.FnUpdateTestStepResHTML("Verify if Forward All Calls to dropdown is available","Forward All Calls to dropdown is available", "PASS",runManagerInfoObj);
					if(cnf.JSClick(ForwardAllCallsTo_dropdown,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the forward all calls to dropdown is clicked", "Forward all calls to dropdown is clicked", "PASS",runManagerInfoObj);
						Thread.sleep(2000);
						if (cnf.FnExplicitWait("XPATH", mbo.ForwardCallsToList,driver)) {
							List<WebElement> ForwardingCallsList = driver.findElements(By.xpath(mbo.ForwardCallsToList));
							repfn.FnUpdateTestStepResHTML("Verify the presence of Forward calls to list is displayed", "Forward calls to list is displayed", "PASS",runManagerInfoObj);
							for (int i = 0; i < ForwardingCallsList.size(); i++) {
								if (ForwardingCallsList.get(i).getText().contains(NewAliasAdd)) {
									cnf.JSClick(ForwardingCallsList.get((ForwardingCallsList.size())-1),driver);
									blnFlag = true;
									break;
								}
								else { 
									blnFlag=false; 
								}
							}
							if(blnFlag){
								repfn.FnUpdateTestStepResHTML("Verify if Newly Added external forwarding destination is present","Newly Added external forwarding destination is present","PASS",runManagerInfoObj);
								blnFlag = true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify if Newly Added external forwarding destination is present","Newly Added external forwarding destination is not present","FAIL",runManagerInfoObj); 
								blnFlag=false; 
							}
						}
						else
						{
							repfn.FnUpdateTestStepResHTML("Verify the presence of Forward calls to list is displayed", "Forward calls to list is not displayed", "FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					} 
					else {
						repfn.FnUpdateTestStepResHTML("Verify the forward all calls to dropdown is clicked", "Forward all calls to dropdown is not clicked", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}

				} else {
					repfn.FnUpdateTestStepResHTML("Verify if Forward All Calls to dropdown is available","Forward All Calls to dropdown is not available","FAIL",runManagerInfoObj);
					blnFlag = false;
				}

			} 
			
			catch (Exception e) {
				repfn.FnUpdateTestStepResHTML("Verify if Newly Added external forwarding destination is present","Newly Added external forwarding destination is not present due to some exception","FAIL",runManagerInfoObj); 
				blnFlag=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}


		//To verify if the deleted External forwarding Destination is present in the Calls dropdown//

		//To check if new external forwarding destination is displayed in the dropdown//

		public synchronized boolean ManageForwardingLines_DropdownCheckDelete(WebDriver driver, RunManagerInfo runManagerInfoObj)
		{
			String NewAliasAdd = m1.get("AliasName").toString();
			try
			{
				if(cnf.FnExplicitWait("XPATH", mbo.ForwardAllCallsTo_Dropdown,driver))
				{
					WebElement ForwardAllCallsTo_dropdown = driver.findElement(By.xpath(mbo.ForwardAllCallsTo_Dropdown));

					repfn.FnUpdateTestStepResHTML("Verify if Forward All Calls to dropdown is available","Forward All Calls to dropdown is available", "PASS",runManagerInfoObj);
					if(cnf.JSClick(ForwardAllCallsTo_dropdown,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the forward all calls to dropdown is clicked", "Forward all calls to dropdown is clicked", "PASS",runManagerInfoObj);
						Thread.sleep(2000);
						if (cnf.FnExplicitWait("XPATH", mbo.ForwardCallsToList,driver)) {
							List<WebElement> ForwardingCallsList = driver.findElements(By.xpath(mbo.ForwardCallsToList));
							repfn.FnUpdateTestStepResHTML("Verify the presence of Forward calls to list is displayed", "Forward calls to list is displayed", "PASS",runManagerInfoObj);
							for (int i = 0; i < ForwardingCallsList.size(); i++) {
								if (ForwardingCallsList.get(i).getText().contains(NewAliasAdd)) {
									blnFlag = false;
								}
								else { 
									blnFlag = true; 
								}
							}
							if(blnFlag){
								repfn.FnUpdateTestStepResHTML("Verify if Newly Added external forwarding destination is present","Newly Added external forwarding destination is present","PASS",runManagerInfoObj);
								blnFlag = true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify if Newly Added external forwarding destination is present","Newly Added external forwarding destination is not present","FAIL",runManagerInfoObj); 
								blnFlag=false; 
							}
						}
						else
						{
							repfn.FnUpdateTestStepResHTML("Verify the presence of Forward calls to list is displayed", "Forward calls to list is not displayed", "FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					} 
					else {
						repfn.FnUpdateTestStepResHTML("Verify the forward all calls to dropdown is clicked", "Forward all calls to dropdown is not clicked", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}

				} else {				
					if(cnf.FnExplicitWait("XPATH", mbo.ForwardAllCallsTo_NotDropdown,driver))
					{
						WebElement ForwardAllCallsTo_NotDropdown = driver.findElement(By.xpath(mbo.ForwardAllCallsTo_NotDropdown));
						repfn.FnUpdateTestStepResHTML("Verify if Forward All Calls to dropdown is available","Forward All Calls to dropdown is not available. Single Phone Line is displayed: "+ForwardAllCallsTo_NotDropdown.getText(),"PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify if Forward All Calls to dropdown is available","Forward All Calls to dropdown is not available. Single Phone Line is also not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}

			} 
			
			catch (Exception e) {
				repfn.FnUpdateTestStepResHTML("Verify if Newly Added external forwarding destination is deleted","Newly Added external forwarding destination is not deleted due to some exception","FAIL",runManagerInfoObj); 
				blnFlag=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}
		public synchronized boolean DuplicateAlias_ForwardingLines(WebDriver driver, RunManagerInfo runManagerInfoObj){
			try
			{
				
				boolean blnFlag1 = app.AddNewPhoneNumber_FillDetails( driver,  runManagerInfoObj);
				
				if(blnFlag1){
					if (cnf.FnExplicitWait("XPATH", mbo.Alias_ForwardingNumber,driver)) {
						List<WebElement> Alias_ForwardingLines = driver.findElements(By.xpath(mbo.Alias_ForwardingNumber));
						repfn.FnUpdateTestStepResHTML("Verify the presence of Forwarding number alias field","Forwarding number alias field is present", "PASS",runManagerInfoObj);
						
						boolean blnFlag2 = AddNewPhoneNumber( driver,  runManagerInfoObj);
						if (blnFlag2) {
							if (cnf.FnExplicitWait("XPATH", mbo.NewAlias,driver)) {
								WebElement NewAddedAlias = driver.findElement(By.xpath(mbo.NewAlias));
								System.out.println("Empty blank field");
								repfn.FnUpdateTestStepResHTML("Verify if Empty field is displayed to add a new Alias","Empty field is displayed to add a new alias","PASS",runManagerInfoObj);

								NewAddedAlias.sendKeys(Alias_ForwardingLines.get(0).getAttribute("defaultValue"));

								repfn.FnUpdateTestStepResHTML("Verify if New Alias is added","New Alias is added", "PASS",runManagerInfoObj);
								blnFlag = true;
							} 
							else {
								repfn.FnUpdateTestStepResHTML("Verify if Empty field is displayed to add a new Alias","Empty field is not displayed to add a new alias","FAIL",runManagerInfoObj);
								repfn.FnUpdateTestStepResHTML("Verify if New Alias is added","New Alias is not added", "FAIL",runManagerInfoObj);
								blnFlag = false;
							}
						} 
						else {
							repfn.FnUpdateTestStepResHTML("Verify if Add New Phone Number is displayed and clicked ","Add New Phone Number is not displayed and clicked ", "FAIL",runManagerInfoObj);
							blnFlag = false;
						}
					} 
					else {
						repfn.FnUpdateTestStepResHTML("Verify the presence of Forwarding number alias field","Forwarding number alias field is not present", "FAIL",runManagerInfoObj);
						blnFlag = false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify New Alias Name and Phone Number is entered","New Alias Name and Phone Number is not entered","FAIL",runManagerInfoObj);
					blnFlag = false;
				}

			} 
			catch (Exception e) {
				blnFlag = false;
				repfn.FnUpdateTestStepResHTML("Verify if a Duplicate alias name can be entered ","Duplicate alias Name cannot be entered due to some exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}
		public synchronized boolean AddNewPhoneNumber(WebDriver driver, RunManagerInfo runManagerInfoObj){
			try
			{

				if (cnf.FnExplicitWait("XPATH", mbo.AddPhoneNo_ForwardingLines,driver)) {
					WebElement AddPhoneNumber = driver.findElement(By
							.xpath(mbo.AddPhoneNo_ForwardingLines));
					repfn.FnUpdateTestStepResHTML(
							"Verify if Add New Phone number button is present",
							"Add New Phone Number button is present", "PASS",runManagerInfoObj);

					if (cnf.JSClick(AddPhoneNumber,driver)) {
						System.out.println("AddNewPhone Number is clicked");
						repfn.FnUpdateTestStepResHTML(
								"Verify if Add New Phone Number is clicked ",
								"Add New Phone Number is clicked ", "PASS",runManagerInfoObj);
						blnFlag = true;
					} else {
						System.out.println("Add New Phone Number is not clicked");
						repfn.FnUpdateTestStepResHTML(
								"Verify if Add New Phone Number is clicked ",
								"Add New Phone Number is not clicked ", "FAIL",runManagerInfoObj);
						blnFlag = false;

					}
				} else {
					repfn.FnUpdateTestStepResHTML(
							"Verify if Add New Phone number button is present",
							"Add New Phone Number button is not present", "FAIL",runManagerInfoObj);
					blnFlag = false;
				}
			} catch (Exception e) {
				blnFlag = false;
				repfn.FnUpdateTestStepResHTML(
						"Verify if Add New Phone Number can be clicked to add a new entry",
						"Add New Phone Number cannot be clicked", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}
		public synchronized boolean Cancel_ForwardingLines(WebDriver driver, RunManagerInfo runManagerInfoObj)
		{
			try
			{
				Thread.sleep(2000);
				if (cnf.FnExplicitWait("XPATH", mbo.ManageForwardingLines_Cancel,driver)) {
					WebElement Cancel_ForwardingLines = driver.findElement(By.xpath(mbo.ManageForwardingLines_Cancel));
					repfn.FnUpdateTestStepResHTML("Verify if Cancel button is present ","Cancel button is present", "PASS",runManagerInfoObj);
					if (cnf.JSClick(Cancel_ForwardingLines,driver)) {				
						repfn.FnUpdateTestStepResHTML("Verify if Cancel is clicked ","Cancel is clicked", "PASS",runManagerInfoObj);
						blnFlag = true;
					} 
					else {
						repfn.FnUpdateTestStepResHTML("Verify if Cancel is clicked ","Cancel is not clicked", "FAIL",runManagerInfoObj);
						blnFlag = false;
					}
				} 
				else {
					repfn.FnUpdateTestStepResHTML("Verify if Cancel button is present ","Cancel button is not present", "FAIL",runManagerInfoObj);
					blnFlag = false;
				}

			} catch (Exception e) {
				blnFlag = false;
				repfn.FnUpdateTestStepResHTML("Verify if the operation can be cancelled","Cancel operation is not performed due to some exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		 public synchronized boolean CancelDisplayandclick(WebDriver driver, RunManagerInfo runManagerInfoObj)
		 {
			 try
			 {
				 if (cnf.FnExplicitWait("XPATH", mbo.CancelBtn,driver)) {
					 WebElement Cancel = driver.findElement(By.xpath(mbo.CancelBtn));

					 repfn.FnUpdateTestStepResHTML("Verify the presence of cancel button","Cancel button is present", "PASS",runManagerInfoObj);
					 Thread.sleep(6000);
					 if (cnf.JSClick(Cancel,driver)) {
						 repfn.FnUpdateTestStepResHTML("Verify if cancel button is clicked","Cancel button is clicked", "PASS",runManagerInfoObj);
						 blnFlag = true;
					 } 
					 else {
						 System.out.println("Cancel button is not clicked");
						 repfn.FnUpdateTestStepResHTML("Verify if cancel button is clicked","Cancel button is not clicked", "FAIL",runManagerInfoObj);
						 blnFlag = false;
					 }
				 } else {
					 repfn.FnUpdateTestStepResHTML("Verify the presence of cancel button","Cancel button is not present", "FAIL",runManagerInfoObj);
					 blnFlag = false;
				 }

			 } 

			 catch (Exception e) {
				 repfn.FnUpdateTestStepResHTML("Verify the presence of cancel button","Cancel button is not present and clicked due to some exception", "FAIL",runManagerInfoObj);
				 blnFlag = false;
				 System.err.println("Message : "+e.getMessage());
				 System.err.println("Cause : "+e.getCause());
			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;
		 }
		 // To click on Confirm //

		 public synchronized boolean ConfirmDisplayandclick(WebDriver driver, RunManagerInfo runManagerInfoObj)
		 {
			 try
			 {
				 if (cnf.FnExplicitWait("XPATH", mbo.CancelPopUp_ConfirmBtn,driver)) {
					 WebElement Cancel_Confirm = driver.findElement(By.xpath(mbo.CancelPopUp_ConfirmBtn));

					 System.out.println("Confirm button is displayed");
					 repfn.FnUpdateTestStepResHTML("Verify the presence of Confirm button","Confirm button is present", "PASS",runManagerInfoObj);
					 if (cnf.JSClick(Cancel_Confirm,driver)) {
						 repfn.FnUpdateTestStepResHTML("Verify if confirm button is clicked","Confirm button is clicked", "PASS",runManagerInfoObj);
						 blnFlag = true;
	
					 } else {
						 repfn.FnUpdateTestStepResHTML("Verify if confirm button is clicked","Confirm button is not clicked", "FAIL",runManagerInfoObj);
						 blnFlag = false;
					 }
				 } 		 
				 else {
					 repfn.FnUpdateTestStepResHTML("Verify the presence of Confirm button","Confirm button is not present", "FAIL",runManagerInfoObj);
					 blnFlag = false;
				 }

			 } 

			 catch (Exception e) {
				 repfn.FnUpdateTestStepResHTML("Verify the presence of cancel button","Cancel button is not present due to some exception", "FAIL",runManagerInfoObj);
				 blnFlag = false;
				 System.err.println("Message : "+e.getMessage());
				 System.err.println("Cause : "+e.getCause());

			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;
		 }

		 public synchronized boolean FN_CancelChangesMade(WebDriver driver, RunManagerInfo runManagerInfoObj)
		 {
			 try
			 {
				 boolean blnFlag1 = CancelDisplayandclick( driver,  runManagerInfoObj);
				 if (blnFlag1) {
					 boolean blnFlag2 = ConfirmDisplayandclick( driver,  runManagerInfoObj);
					 if(blnFlag2){
						 blnFlag = true;
					 }
					 else{
						 blnFlag = false;
					 }
				 } 
				 else {
					 repfn.FnUpdateTestStepResHTML("Verify the presence of cancel button","Cancel button is not present and clicked", "FAIL",runManagerInfoObj);
					 blnFlag = false;
				 }
			 } 
			 
			 catch (UnhandledAlertException alert) {
				 repfn.FnUpdateTestStepResHTML(
						 "Verify the presence of cancel button",
						 "On Clicking Cancel Button Alert pop up Opens", "FAIL",runManagerInfoObj);
				 blnFlag = false;
			 }
			 
			 catch (Exception e) {
				 repfn.FnUpdateTestStepResHTML("Verify the presence of cancel button","Cancel button is not present due to some exception", "FAIL",runManagerInfoObj);
				 blnFlag = false;
				 System.err.println("Message : "+e.getMessage());
				 System.err.println("Cause : "+e.getCause());
			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;
		 }
		
		public synchronized boolean FN_AddDuplicateNumber(WebDriver driver, RunManagerInfo runManagerInfoObj){
			try
			{

				boolean blnFlag1 = DuplicateAlias_ForwardingLines( driver,  runManagerInfoObj);
				if (blnFlag1) {
					boolean blnFlag2 = DuplicateError_Alias(driver, runManagerInfoObj);
					if (blnFlag2) {
						boolean blnFlag3 = DuplicateNumber_ForwardingLines(driver, runManagerInfoObj);
						if (blnFlag3) {
							boolean blnFlag4 = DuplicateError_Number(driver, runManagerInfoObj);
							if (blnFlag4) {
								boolean blnFlag5 = Cancel_ForwardingLines(driver,runManagerInfoObj);
								if(blnFlag5){
									if (cnf.FnExplicitWait("XPATH",mbo.ForwardCall_SaveButton,driver)) {
										WebElement SaveButton = driver.findElement(By.xpath(mbo.ForwardCall_SaveButton));
										repfn.FnUpdateTestStepResHTML("Verify the presence of Save button","Save button is present", "PASS",runManagerInfoObj);
										if (SaveButton.isEnabled()) {
											repfn.FnUpdateTestStepResHTML("Verify if Save button is enabled","Save button is enabled", "PASS",runManagerInfoObj);
											boolean blnFlag6 = FN_CancelChangesMade(driver,  runManagerInfoObj);
											if (blnFlag6) {
												blnFlag = true;
											} 
											else {
												blnFlag = false;
											}
										} 
										else {
											boolean blnFlag7 = app.Close_ManageLines(driver,runManagerInfoObj);
											if (blnFlag7) {
												blnFlag = true;
											} else {
												blnFlag = false;
											}
										}
									} 
									else {
										repfn.FnUpdateTestStepResHTML("Verify the presence of Save button","Save button is not present", "FAIL",runManagerInfoObj);
										blnFlag = false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify if Cancel is present and clicked ","Cancel is not present and clicked", "FAIL",runManagerInfoObj);
									blnFlag = false;
								}

							} else {
								repfn.FnUpdateTestStepResHTML("Verify if Error message is displayed when duplicate number is entered","Error message is not displayed", "FAIL",runManagerInfoObj);
								blnFlag = false;
							}
						} 
						else {
							blnFlag = false;
							repfn.FnUpdateTestStepResHTML("Verify if Duplicate Number is entered ","Duplicate Number is not added", "FAIL",runManagerInfoObj);
						}
					} 
					else {
						blnFlag = false;
						repfn.FnUpdateTestStepResHTML("Verify if any message is displayed when a Duplicate Alias Name is entered","No message is displayed", "FAIL",runManagerInfoObj);
					}
				} 
				else {
					blnFlag = false;
					repfn.FnUpdateTestStepResHTML("Verify if a Duplicate alias name is entered ","Duplicate alias Name is not entered", "FAIL",runManagerInfoObj);
				}
				driver.navigate().refresh();
				// AlertAccept();

			} 

			catch (Exception e) {
				blnFlag = false;
				repfn.FnUpdateTestStepResHTML("Verify if the user is able to add a duplicate entry of an already existing number in the list.",
						"Verify if the user is not able to add a duplicate entry of an already existing number in the list. due to exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;


		}
		public synchronized boolean ForwardCallsTo_Statuschange_Off(WebDriver driver, RunManagerInfo runManagerInfoObj) {
			try {

				if (cnf.isElementExist(By.xpath(mbo.ForwardStatusOFFToggle),driver)) {
					repfn.FnUpdateTestStepResHTML(
							"Verify Intailly the status is changed from off to ON",
							"status is changed from off to ON", "PASS",runManagerInfoObj);
					blnFlag=app.ForwardingStatus_change(driver, runManagerInfoObj);
					if(blnFlag)
					// ForwardingMethod_change();
					// ForwardCallsToDropdown_SelectContact();
					
						{
						blnFlag=app.ForwardCalls_Save(driver, runManagerInfoObj);
						if(blnFlag)
						{
						
					blnFlag=app.Close_ManageLines(driver,runManagerInfoObj);
					if(blnFlag)
					{
					blnFlag=app.FN_ForwardManager_OnOFFstatusCheck(driver, runManagerInfoObj);
					}
					else
					{
						blnFlag=false;
					}
					}
						else
						{
							blnFlag=false;
						}
						}
					else
					{
						blnFlag=false;
					}
				
				} else if (cnf.isElementExist(By.xpath(mbo.ForwardStatusONToggle),driver)) {
					repfn.FnUpdateTestStepResHTML(
							"Verify Intailly the status is changed from ON to OFF",
							"status is changed from ON to OFF", "PASS",runManagerInfoObj);
					blnFlag=app.ForwardingStatus_change(driver,  runManagerInfoObj);
					if(blnFlag)
					{
					blnFlag=app.ForwardCalls_Save( driver,  runManagerInfoObj);
					if(blnFlag)
					{
					blnFlag=app.Close_ManageLines( driver,  runManagerInfoObj);
					if(blnFlag)
					{
					blnFlag=app.FN_ForwardManager_OnOFFstatusCheck( driver,  runManagerInfoObj);
					}
					else
					{
					blnFlag = false;
					}
					}
					else
					{
						blnFlag=false;
					}
					}
					else
					{
						blnFlag=false;
					}
				} else {
					repfn.FnUpdateTestStepResHTML("Verify able to change status",
							"Not able to change status", "FAIL",runManagerInfoObj);
					blnFlag = false;
				}

			} catch (Exception e) {
				blnFlag = false;
				
				  repfn.FnUpdateTestStepResHTML("Verify if status is changed ",
				  "Status is not changed due to exception","FAIL",runManagerInfoObj);
				 

			}
			return blnFlag;
		}
		

		public synchronized boolean FN_AddNewExternalforwardingDestination(WebDriver driver,RunManagerInfo runManagerInfoObj)
		{
			try
			{
				boolean blnFlag1 = app.ManageForwardingLines(driver,  runManagerInfoObj);
				if (blnFlag1) {
					boolean blnFlag2 = app.AddNewPhoneNumber_FillDetails(driver,runManagerInfoObj);
					if(blnFlag2){
						boolean blnFlag3 = app.ManageforwardingLines_Save(driver, runManagerInfoObj);
						if(blnFlag3){
							boolean blnFlag4 = ManageForwardingLines_DropdownCheck(driver,runManagerInfoObj);
							if(blnFlag4){
								if (cnf.FnExplicitWait("XPATH",mbo.ForwardStatusONToggle,driver)) {
									repfn.FnUpdateTestStepResHTML("Verify the presence of Forward ON status toggle","Forward ON status toggle is present","PASS",runManagerInfoObj);

									boolean blnFlag5 = app.ForwardingStatus_change(driver, runManagerInfoObj);
									if (blnFlag5) {
										boolean blnFlag6 = app.ForwardCalls_Save(driver, runManagerInfoObj);
										if (blnFlag6) {
											blnFlag = true;
										} 
										else {
											blnFlag = false;
										}
									} 
									else {
										repfn.FnUpdateTestStepResHTML("Verify if Call Forwarding status toggle can be changed","Call Forwarding status Toggle cannot be changed","FAIL",runManagerInfoObj);
										blnFlag = false;
									}
								} else {
									repfn.FnUpdateTestStepResHTML("Verify the presence of Forward ON status toggle","Forward ON status toggle is not present","FAIL",runManagerInfoObj);
									blnFlag = false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify if Newly Added external forwarding destination is present","Newly Added external forwarding destination is not present","FAIL",runManagerInfoObj); 
								blnFlag=false; 
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Save button is displayed and clicked","Save button is not displayed and clicked", "FAIL",runManagerInfoObj);
							blnFlag = false;
						}
					}
					else{
						blnFlag = false;
						repfn.FnUpdateTestStepResHTML("Verify if Add New Phone Number is displayed and clicked to add a new entry","Add New Phone Number is not displayed and clicked", "FAIL",runManagerInfoObj);
					}
				} else {
					repfn.FnUpdateTestStepResHTML("Verify if Manage Forwarding Lines is displayed and clicked","Manage Forwarding Lines is not displayed and clicked", "FAIL",runManagerInfoObj);
					blnFlag = false;
				}
				// SaveChanges_ForwardingCallManager();
				// Close_ManageLines();
				driver.navigate().refresh();
			} 
			
			catch (Exception e) {
				blnFlag = false;
				repfn.FnUpdateTestStepResHTML("New forwarding destination cannot be added","New forwarding destination cannot be added due to some exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}
		public synchronized boolean DeleteNewExternalforwardingDestination(WebDriver driver, RunManagerInfo runManagerInfoObj)
		{
			try
			{
				boolean blnFlag1=app.ManageForwardingLines(driver, runManagerInfoObj);
				if(blnFlag1)
				{
					boolean blnFlag2=DeleteLastforwardingDestination(driver, runManagerInfoObj);
					if(blnFlag2)
					{
						blnFlag=true;
					}
					else
					{
						blnFlag=false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify if Manage Forwarding Lines is displayed and clicked","Manage Forwarding Lines is not displayed and clicked", "FAIL",runManagerInfoObj);
					blnFlag = false;
				}
			} 
			
			catch (Exception e) {
				blnFlag = false;
				repfn.FnUpdateTestStepResHTML("New forwarding destination could not be deleted","New forwarding destination could not be deleted due to some exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;


		}
		
		
		
		public synchronized boolean FN_StatusOnretrieval(WebDriver driver, RunManagerInfo runManagerInfoObj)
		{
			try
			{
				Thread.sleep(1000);
				if (cnf.FnExplicitWait("XPATH", mbo.ForwardCall_Onstatus,driver)) {
					List<WebElement> Status_On = driver.findElements(By.xpath(mbo.ForwardCall_Onstatus));
					repfn.FnUpdateTestStepResHTML("Verify if Lines with On Status are displayed","Lines with 'On' status is displayed", "PASS",runManagerInfoObj);
					if (cnf.JSClick(Status_On.get(0),driver)) {
						repfn.FnUpdateTestStepResHTML("Verify if a line with status On is clicked","A line with status On is clicked", "PASS",runManagerInfoObj);

						if(cnf.FnExplicitWait("XPATH",mbo.ForwardStatusONToggle,driver)) {
							repfn.FnUpdateTestStepResHTML("Verify the presence of Forward Status ON toggle","Forward Status ON toggle is present","PASS",runManagerInfoObj);
							blnFlag = true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify the presence of Forward Status ON toggle","Forward Status ON toggle is not present","FAIL",runManagerInfoObj);
							blnFlag = false;
						}
					} 
					else {
						repfn.FnUpdateTestStepResHTML("Verify if a line with status On is clicked","There is no line with Status as On", "FAIL",runManagerInfoObj);
						blnFlag = false;
					}
				}
				else {
					repfn.FnUpdateTestStepResHTML("Verify if Lines with On Status are displayed","Lines with 'On' status is not displayed", "PASS",runManagerInfoObj);
					if(cnf.FnExplicitWait("XPATH", mbo.ForwardCall_Offsatus,driver)) {
						List<WebElement> Status_On = driver.findElements(By.xpath(mbo.ForwardCall_Onstatus));
						repfn.FnUpdateTestStepResHTML("Verify if Lines with Off Status are displayed","Lines with 'Off' status is displayed", "PASS",runManagerInfoObj);
						boolean blnFlag2 = app.FN_ForwardCallLogList_firstContact(driver,runManagerInfoObj);
						if(blnFlag2){
							boolean blnFlag3 = app.ForwardingStatus_change(driver, runManagerInfoObj);
							if(blnFlag3){
								repfn.FnUpdateTestStepResHTML("Verify if Call Forwarding status toggle can be changed","Call Forwarding status Toggle can be changed","PASS",runManagerInfoObj);
								blnFlag = true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify if Call Forwarding status toggle can be changed","Call Forwarding status Toggle cannot be changed","FAIL",runManagerInfoObj);
								blnFlag = false;
							}
						}
						else{
							blnFlag	=false;
							repfn.FnUpdateTestStepResHTML("ForWard Call Log List is displayed and clicked ", "ForWard Call Log List is not  displayed and not clicked","FAIL",runManagerInfoObj);
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify if Lines with Off Status are displayed","Lines with 'Off' status is not displayed", "FAIL",runManagerInfoObj);
						blnFlag = false;
					}
				}
			}

			catch (Exception e) {
				blnFlag = false;
				repfn.FnUpdateTestStepResHTML("Verify if Line with ON status is displayed ","Line with ON status is not displayed due to exception","FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		//to add New external forwarding destination and to delete the same//

		

		
		
		//To delete the last forwarding destination//

		public synchronized boolean DeleteLastforwardingDestination(WebDriver driver, RunManagerInfo runManagerInfoObj)
		{
			try
			{
				if(cnf.FnExplicitWait("XPATH", mbo.DeleteForwardContact,driver))
				{
					List<WebElement> Delete = driver.findElements(By.xpath(mbo.DeleteForwardContact));
					repfn.FnUpdateTestStepResHTML("Verify the presence of Delete Forward contact", "Delete forward contact is present", "PASS",runManagerInfoObj);
					int Last = Delete.size() - 1;

					if (cnf.JSClick(Delete.get(Last),driver)) {
						System.out.println("Delete is clicked");
						repfn.FnUpdateTestStepResHTML("Verify if Last forwarding destination is deleted","Last forwarding destination is deleted", "PASS",runManagerInfoObj);
						boolean blnFlag1=app.ManageforwardingLines_Save(driver,runManagerInfoObj);
						if(blnFlag1)
						{
							blnFlag=true;
						}
						else
						{
							blnFlag=false;
						}
					} 
					else {
						repfn.FnUpdateTestStepResHTML("Verify if last forwarding destination is deleted","Last forwarding destination is not deleted", "FAIL",runManagerInfoObj);
						blnFlag = false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of DeleteForward contact", "Delete forward contact is not present", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			} 
			
			catch (Exception e) {
				blnFlag = false;
				repfn.FnUpdateTestStepResHTML("New forwarding destination could not be deleted","New forwarding destination could not be deleted due to some exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;


		}

		
	



		
		
		
		
		public synchronized boolean Fn_ChargeDetails_Phone_ExportCallLog(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{
			boolean blnFlag=false;
			try{
				if(cnf.FnExplicitWait("XPATH", mbo.ViewStatement_ExportCallLog,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify whether Export Call log button is present in View Statement screen","Export Call log button is present in View Statement screen","PASS",runManagerInfoObj);
					
					WebElement ViewStatement_ExportCallLog=driver.findElement(By.xpath(mbo.ViewStatement_ExportCallLog));

					if(cnf.JSClick(ViewStatement_ExportCallLog,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify whether Export Call log button is clicked","Export Call log button is clicked","PASS",runManagerInfoObj);


						if(cnf.FnExplicitWait("XPATH", mbo.ExportCallLog_PopUp,driver))
						{
							repfn.FnUpdateTestStepResHTML("Verify whether Export Call log pop up is displayed","Export Call log pop up is displayed with header"+" "+driver.findElement(By.xpath(mbo.ExportCallLog_Hdr)).getText(),"PASS",runManagerInfoObj);

							if(cnf.FnExplicitWait("XPATH",mbo.ExportCallLog_PopUp_SubTitle,driver))
							{
								repfn.FnUpdateTestStepResHTML("Verify whether Export Call log pop up is displayed with the subtitle","Export Call log pop up is displayed with the subtitle:"+" "+driver.findElement(By.xpath(mbo.ExportCallLog_PopUp_SubTitle)).getText(),"PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify whether Export Call log pop up is displayed with the subtitle","Export Call log pop up is displayed without subtitle","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
							
							if(cnf.FnExplicitWait("XPATH",mbo.ExportCallLog_PopUp_Text,driver))
							{
								repfn.FnUpdateTestStepResHTML("Verify whether Export Call log pop up is displayed with the text","Export Call log pop up is displayed with the text:"+" "+driver.findElement(By.xpath(mbo.ExportCallLog_PopUp_Text)).getText(),"PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify whether Export Call log pop up is displayed with the text","Export Call log pop up is displayed without text","FAIL",runManagerInfoObj);
								blnFlag=false;
							}

							if(cnf.FnExplicitWait("XPATH",mbo.ExportCallLog_PopUp_EmailLabel,driver))
							{
								repfn.FnUpdateTestStepResHTML("Verify whether Export Call log pop up is displayed with the email label","Export Call log pop up is displayed with the email label:"+" "+driver.findElement(By.xpath(mbo.ExportCallLog_PopUp_EmailLabel)).getText(),"PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify whether Export Call log pop up is displayed with the email label","Export Call log pop up is displayed without email label","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
							
							if(cnf.FnExplicitWait("XPATH",mbo.ExportCallLog_PopUp_EmailTxtBox,driver))
							{
								repfn.FnUpdateTestStepResHTML("Verify whether Export Call log pop up is displayed with email address text box","Export Call log pop up is displayed with email address text box","PASS",runManagerInfoObj);

								WebElement Email=driver.findElement(By.xpath(mbo.ExportCallLog_PopUp_EmailTxtBox));
								// Email.clear();
								// Email.sendKeys("anders@charter.net");
								if(Email.getText()!=null)
								{
									repfn.FnUpdateTestStepResHTML("Verify whether Email address text box is prepopulated with default email address ","Email address text box is prepopulated with default email address:"+" "+Email.getText(),"PASS",runManagerInfoObj);
									blnFlag=true;
								}
								else
								{
									repfn.FnUpdateTestStepResHTML("Verify whether Email address text box is prepopulated with default email address ","Email address text box is not prepopulated with default email address","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify whether Export Call log pop up is displayed with email address text box","Export Call log pop up is displayed without email address text box","FAIL",runManagerInfoObj);
								blnFlag=false;

							}
							
							if(cnf.FnExplicitWait("XPATH",mbo.ExportCallLog_PopUp_ExportBtn,driver))
							{
								repfn.FnUpdateTestStepResHTML("Verify whether Export button is present in Export call log pop up ","Export button is present in Export call log pop up","PASS",runManagerInfoObj);
								blnFlag=true;

							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify whether Export button is present in Export call log pop up ","Export button is not present in Export call log pop up","FAIL",runManagerInfoObj);
								blnFlag=false;
							}


							if(cnf.FnExplicitWait("XPATH",mbo.ExportCallLog_PopUp_Cancel,driver))
							{
								repfn.FnUpdateTestStepResHTML("Verify whether Cancel button is present in Export call log pop up ","Cancel button is present in Export call log pop up","PASS",runManagerInfoObj);

								if(cnf.JSClick(driver.findElement(By.xpath(mbo.ExportCallLog_PopUp_Cancel)),driver))

								{
									repfn.FnUpdateTestStepResHTML("Verify whether Cancel button is clicked ","Cancel button is clicked","PASS",runManagerInfoObj);
									
									Thread.sleep(5000);

									if(cnf.FnExplicitWait("XPATH", mbo.ExportCallLog_PopUp,driver))
									{
										repfn.FnUpdateTestStepResHTML("Verify whether Export call log pop up is dismissed and logs are not exported","Export call log pop up is not dismissed and logs are exported ","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
									else
									{
										repfn.FnUpdateTestStepResHTML("Verify whether Export call log pop up is dismissed and logs are not exported ","Export call log pop up is dismissed and logs are not exported","PASS",runManagerInfoObj);
										blnFlag=true;
									}
								}
								else
								{
									repfn.FnUpdateTestStepResHTML("Verify whether Cancel button is clicked ","Cancel button is not clicked","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify whether Cancel button is present in Export call log pop up ","Cancel button is not present in Export call log pop up","FAIL",runManagerInfoObj);
								blnFlag=false;

							}
						}
						else
						{
							repfn.FnUpdateTestStepResHTML("Verify whether Export Call log pop up is displayed","Export Call log pop up is displayed without header","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify whether Export Call log button is clicked","Export Call log button is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify whether Export Call log button is present in View Statement screen","Export call log button is not present in View Statement screen","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			catch(Exception e)
			{
				repfn.FnUpdateTestStepResHTML("Verify whether User is able to cancel Call log Export","User is not able to cancel Call log Export due to some exception","FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		public synchronized boolean Fn_StdUser_BillingSection(WebDriver driver,RunManagerInfo runManagerInfoObj)
		{
			boolean blnFlag=false;
			try{
				if(!cnf.FnExplicitWait("XPATH", mbo.BillingSection_StdUser,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify whether standard user is displayed with option to view Billing details in overview page ","Standard user is not displayed with option to view Billing details in overview page and hence cannot export call logs or download logs","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify whether standard user is displayed with option to view Billing details in overview page ","Standard user is displayed with option to view Billing details in overview page ","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			catch(Exception e)
			{
				repfn.FnUpdateTestStepResHTML("Verify whether user is in Overview screen","User is in Overview screen","FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		public synchronized boolean FnVerifyVoiceSettings_ForwardingManager(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{
			
			try{
				
				if(cnf.FnExplicitWait("XPATH", mbo.VoiceSettingsButton,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Voice Settings button is not displayed on Forwarding Manager page ", "Voice Settings button is displayed on Forwarding Manager page ", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Voice Settings button is not displayed on Forwarding Manager page ", "Voice Settings button is not displayed on Forwarding Manager page ", "PASS",runManagerInfoObj);
					blnFlag=true;
				}
			}
			
			catch(Exception e)
			{
				blnFlag=false;
				repfn.FnUpdateTestStepResHTML("Verify Voice Settings is not displayed on Forwarding Manager page", "Voice Settings is displayed on Forwarding Manager page due to some exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		public synchronized boolean FnVerifyVoiceSettings_ManageLines(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{
			
			try{
				
				if(cnf.FnExplicitWait("XPATH", mbo.VoiceSettingsButton,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Voice Settings button is not displayed on Manage Lines page ", "Voice Settings button is displayed on Manage Lines page ", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Voice Settings button is not displayed on Manage Lines page ", "Voice Settings button is not displayed on Manage Lines page ", "PASS",runManagerInfoObj);
					blnFlag=true;
				}
			}
			
			catch(Exception e)
			{
				blnFlag=false;
				repfn.FnUpdateTestStepResHTML("Verify Voice Settings is not displayed on Manage lines page", "Voice Settings is displayed on Manage lines page due to some exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		public synchronized boolean OverviewReturn(WebDriver driver, RunManagerInfo runManagerInfoObj) {

			try{

				Thread.sleep(1000);
				if(cnf.FnExplicitWait("Xpath", mbo.LoginBtn,driver)){
					repfn.FnUpdateTestStepResHTML("Verify if the arrow to expand Logged in Profile details is displayed",
							"Arrow to expand Logged In Profile Details is displayed","PASS",runManagerInfoObj);
					WebElement LoginBtn=driver.findElement(By.xpath(mbo.LoginBtn));
					if(cnf.JSClick(LoginBtn,driver)){
						repfn.FnUpdateTestStepResHTML("Verify if the arrow to expand Logged in Profile details is clicked",
								"Arrow to expand Logged in Profile details is clicked","PASS",runManagerInfoObj);
						if(cnf.FnExplicitWait("Xpath", mbo.OverviewLink,driver)){
							repfn.FnUpdateTestStepResHTML("Verify OverView Link is displayed","OverView Link is displayed","PASS",runManagerInfoObj);
							WebElement OverviewLink=driver.findElement(By.xpath(mbo.OverviewLink));
							Thread.sleep(2000);
							if(cnf.ElementClick(OverviewLink,driver)){
								repfn.FnUpdateTestStepResHTML("Verify OverView Link is clicked","OverView Link is clicked","PASS",runManagerInfoObj);
								
								if(cnf.isAlertPresent()){
									driver.switchTo().alert();
									String ErrMsg=driver.switchTo().alert().getText();
									System.out.println(ErrMsg);
									//repfn.FnUpdateTestStepResHTML("verify .... ",".......","PASS/WARNING");// update the reporting function based on your requirement
									driver.switchTo().alert().accept();
									driver.switchTo().defaultContent();
									Thread.sleep(5000);

								}else{
									//repfn.FnUpdateTestStepResHTML("verify .... ",".......","PASS/WARNING");// update the reporting function based on your requirement
									System.out.println("No alert present");                                              
								}						
								blnFlag=true;
								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify OverView Link is clicked","OverView Link is not clicked","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}				
						else{
							repfn.FnUpdateTestStepResHTML("Verify OverView Link is displayed","OverView Link is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify if the arrow to expand Logged in Profile details is clicked"," Arrow to expand Logged in Profile details is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify if the arrow to expand Logged in Profile details is displayed","Arrow to expand Logged in Profile details is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				//WebElement OverviewLabel=driver.findElement(By.xpath(mbo.Home_OverviewLabel));
				if(cnf.FnExplicitWait("Xpath", mbo.Home_OverviewLabel,driver)){
					repfn.FnUpdateTestStepResHTML("Verify User Return back to Overview Page","User Return back to Overview Page","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				
				else{
					repfn.FnUpdateTestStepResHTML("Verify User Return back to Overview Page","User is not Return back to Overview Page","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

			}

			catch (Exception e)

			{
				repfn.FnUpdateTestStepResHTML("Verify User Return back to Overview Page","User is not Return back to Overview Page due to some exceptions","FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		 public synchronized boolean FN_sucessMessageVerification(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{
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
		public synchronized boolean AdminvsAdmin(WebDriver driver,RunManagerInfo runManagerInfoObj)
		{
			String Admin_Name=null;
			try
			{

				if (cnf.FnExplicitWait("XPATH", mbo.User_RoleList,driver)) {
					List<WebElement> User_RoleList = driver.findElements(By.xpath(mbo.User_RoleList));
					repfn.FnUpdateTestStepResHTML("Verify the presence of Role list","Role list is present", "PASS",runManagerInfoObj);
					for (int i = 0; i <= User_RoleList.size(); i++) {

						if(User_RoleList.get(i).getText().contains("Admin")){
							if(cnf.JSClick(User_RoleList.get(i),driver)) {
								blnFlag = true;
								break;
							} 
							else{
								blnFlag = false;
							}
						} 
						else{
							blnFlag = false;
						}
					}

					if(blnFlag){
						repfn.FnUpdateTestStepResHTML("Check whether Admin User role is displayed and clicked","Admin User role is displayed and clicked","PASS",runManagerInfoObj);
						if (cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)) {
							repfn.FnUpdateTestStepResHTML("Verify User details window is displayed ","The user details window for the selected user is displayed","PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("XPATH", mbo.AdminName,driver))						
							{
								WebElement Name=driver.findElement(By.xpath(mbo.AdminName));
								Admin_Name=Name.getAttribute("innerHTML");
								repfn.FnUpdateTestStepResHTML("Verify if the Name of the Admin is displayed", "Name of the Admin is displayed: "+Admin_Name, "PASS",runManagerInfoObj);
								boolean blnFlag1 = app.FN_BackClick(driver, runManagerInfoObj);
								if(blnFlag1){
									boolean blnFlag2 = OverviewReturn(driver, runManagerInfoObj);
									if(blnFlag2){
										boolean blnFlag3 = app.FnVoiceClick(driver,runManagerInfoObj);
										if(blnFlag3){
											boolean blnFlag4 = app.FnManageLinkClick(driver, runManagerInfoObj);
											if(blnFlag4){
												boolean blnFlag5 = app.FN_UnassignContactListClick(driver, runManagerInfoObj);
												if(blnFlag5){
													boolean blnFlag6 = app.FN_NewAssignMentLinkClick(driver, runManagerInfoObj);
													if(blnFlag6){

														if(cnf.FnExplicitWait("XPATH", mbo.Radiobuttons,driver))
														{
															repfn.FnUpdateTestStepResHTML("Verify if list of users are displayed", "List of users are displayed", "PASS",runManagerInfoObj);													
															List <WebElement> Radio=driver.findElements(By.xpath(mbo.Radiobuttons));
															for(int i=0;i<=Radio.size();i++)
															{													
																if(Radio.get(i).getAttribute("textContent").equalsIgnoreCase(Admin_Name))
																{
																	if(cnf.JSClick(Radio.get(i),driver)){
																		blnFlag=true;
																		break;
																	}
																	else
																	{
																		blnFlag=false;
																	}
																}
																else
																{
																	blnFlag=false;
																}
															}

															if(blnFlag){
																repfn.FnUpdateTestStepResHTML("Verify if the Admin name is present and clicked", "Admin name is present and clicked", "PASS",runManagerInfoObj);
																boolean blnFlag7=app.FN_AssignLineSaveButtonClick(driver,runManagerInfoObj);
																if(blnFlag7){
																	boolean blnFlag8=app.FN_AssignmentFinalSave(driver,runManagerInfoObj);
																	if(blnFlag8){
																		repfn.FnUpdateTestStepResHTML("Verify Changes are saved","Changes are saved","PASS",runManagerInfoObj);
																		blnFlag=true;
																	}
																	else{
																		repfn.FnUpdateTestStepResHTML("Verify Changes are saved","Changes are not saved","FAIL",runManagerInfoObj);
																		blnFlag=false;
																	}
																}
																else{
																	repfn.FnUpdateTestStepResHTML("Verify Save button is displayed and clicked "," Save button is not displayed and clicked","FAIL",runManagerInfoObj);
																	blnFlag=false;
																}
															}
															else{
																repfn.FnUpdateTestStepResHTML("Verify if the Admin name is present and clicked", "Admin name is not present and clicked", "FAIL",runManagerInfoObj);
																blnFlag=false;
															}
														}
														else
														{
															repfn.FnUpdateTestStepResHTML("Verify if list of users are displayed", "List of users are not displayed", "FAIL",runManagerInfoObj);
															blnFlag=false;
														}
													}
													else{
														repfn.FnUpdateTestStepResHTML("Verify Click on the Add New Assignee link","Add New Assignment Line is not clicked","FAIL",runManagerInfoObj);
														blnFlag=false;
													}
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify Users with unassigned voice lines are displayed","Users with unassigned voice lines are not displayed","FAIL",runManagerInfoObj);
													blnFlag=false;
												}
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify User is navigated to Manage Lines Page","User is not navigated to Manage Lines Page","FAIL",runManagerInfoObj);
												blnFlag=false;
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Voice Page is Loaded "," Voice Page is not Loaded", "FAIL",runManagerInfoObj);
											blnFlag = false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify User Return back to Overview Page","User is not Return back to Overview Page","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Back link is displayed and clicked","Back link is not displayed and clicked","FAIL",runManagerInfoObj);
									blnFlag=false;
								}						
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify if Name of the Admin is displayed", "Admin Name is not displayed", "FAIL",runManagerInfoObj);
								blnFlag=false;
							}

						} else {
							repfn.FnUpdateTestStepResHTML("Verify User details window is displayed ","The user details window for the selected user is  not displayed","FAIL",runManagerInfoObj);
							blnFlag = false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Check whether Admin User role is displayed and clicked","Admin User role is not displayed and clicked","FAIL",runManagerInfoObj);
						blnFlag = false;
					}			
				}				
				else {
					repfn.FnUpdateTestStepResHTML("Verify the presence of Role list","Role list is not present", "FAIL",runManagerInfoObj);
					blnFlag = false;
				}				
			}
			catch(Exception e)
			{
				repfn.FnUpdateTestStepResHTML("Verify User is able to assign Voice line to Admin user","User is not able to assign Voice line to Admin user due to some exceptions","FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}


	
		public synchronized boolean DuplicateError_Alias(WebDriver driver, RunManagerInfo runManagerInfoObj){
			try
			{

				Thread.sleep(1000);
				if (cnf.FnExplicitWait("XPATH", mbo.DuplicateError_Alias,driver)) {
					WebElement Duplicate = driver.findElement(By.xpath(mbo.DuplicateError_Alias));
					repfn.FnUpdateTestStepResHTML("Verify if Error message is displayed when duplicate alias is entered","Error message is displayed", "PASS",runManagerInfoObj);
					if (cnf.FnExplicitWait("XPATH", mbo.ManageForwardingLines_Save,driver)) {
						WebElement Save = driver.findElement(By.xpath(mbo.ManageForwardingLines_Save));
						repfn.FnUpdateTestStepResHTML("Verify if Save button is present","Save button is present", "PASS",runManagerInfoObj);

						if (!(Save.isEnabled())) {
							System.out.println("Alias Name is duplicate");
							repfn.FnUpdateTestStepResHTML("Verify if Save button is disabled","Save button is disabled", "PASS",runManagerInfoObj);
							blnFlag = true;
						} else {
							repfn.FnUpdateTestStepResHTML("Verify if Save button is enabled","Save button is enabled", "PASS",runManagerInfoObj);
							blnFlag = false;
						}
					} else {
						repfn.FnUpdateTestStepResHTML("Verify if Save button is present","Save button is not present", "FAIL",runManagerInfoObj);
						blnFlag = false;
					}
				} else {
					System.out.println("Alias Name is not duplicate");
					repfn.FnUpdateTestStepResHTML("Verify if Error message is displayed when duplicate alias is entered","Error message is not displayed", "FAIL",runManagerInfoObj);
					blnFlag = false;
				}

			} catch (Exception e) {
				blnFlag = false;
				repfn.FnUpdateTestStepResHTML("Verify if any message is displayed when a Duplicate Alias Name is entered","No message is displayed due to some exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}
		//To display Duplicate error message for Number//

		public synchronized boolean DuplicateError_Number(WebDriver driver, RunManagerInfo runManagerInfoObj){
			try
			{

				Thread.sleep(1000);
				if (cnf.FnExplicitWait("XPATH", mbo.DuplicateError_Number,driver)) {
					WebElement Duplicate = driver.findElement(By.xpath(mbo.DuplicateError_Number));

					repfn.FnUpdateTestStepResHTML("Verify if Error message is displayed when duplicate Number is entered","Error message is displayed", "PASS",runManagerInfoObj);
					if (cnf.FnExplicitWait("XPATH", mbo.ManageForwardingLines_Save,driver)) {
						WebElement Save = driver.findElement(By.xpath(mbo.ManageForwardingLines_Save));
						repfn.FnUpdateTestStepResHTML("Verify if Save button is present","Save button is present", "PASS",runManagerInfoObj);

						if (!(Save.isEnabled())) {
							System.out.println("Number is duplicate");
							repfn.FnUpdateTestStepResHTML("Verify if Save button is disabled","Save button is disabled", "PASS",runManagerInfoObj);
							blnFlag = true;
						}
						else {
							repfn.FnUpdateTestStepResHTML("Verify if Save button is disabled","Save button is enabled", "FAIL",runManagerInfoObj);
							blnFlag = false;
						}
					} 
					else {
						repfn.FnUpdateTestStepResHTML("Verify if Save button is present","Save button is not present", "FAIL",runManagerInfoObj);
						blnFlag = false;
					}
				} else {
					System.out.println("Number is not duplicate");
					repfn.FnUpdateTestStepResHTML("Verify if Error message is displayed when duplicate number is entered","Error message is not displayed", "FAIL",runManagerInfoObj);
					blnFlag = false;
				}

			} catch (Exception e) {
				blnFlag = false;
				repfn.FnUpdateTestStepResHTML("Verify if any message is displayed when a duplicate number is entered","No message is displayed when a duplicate number is entered due to some exception","FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}
		public synchronized boolean DuplicateNumber_ForwardingLines(WebDriver driver, RunManagerInfo runManagerInfoObj)
		{
			try
			{
				if (cnf.FnExplicitWait("XPATH", mbo.Number_forwardingNumber,driver)) {
					List<WebElement> Number_ForwardingLines = driver.findElements(By.xpath(mbo.Number_forwardingNumber));

					repfn.FnUpdateTestStepResHTML("Verify if number is present ","Number is present", "PASS",runManagerInfoObj);

					if (cnf.FnExplicitWait("XPATH", mbo.NewPhoneNo,driver)) {
						WebElement NewAddedNum = driver.findElement(By.xpath(mbo.NewPhoneNo));
						System.out.println("Empty blank field");
						repfn.FnUpdateTestStepResHTML("Verify if Empty field is present to add new phone number","Empty field is present to add new Phone number","PASS",runManagerInfoObj);

						NewAddedNum.sendKeys(Number_ForwardingLines.get(0).getAttribute("defaultValue"));
						repfn.FnUpdateTestStepResHTML("Verify if New Number is added","New Number is added", "PASS",runManagerInfoObj);
						Thread.sleep(1000);
						blnFlag = true;
					} 
					else {
						repfn.FnUpdateTestStepResHTML("Verify if New Number is added","New Number is not added", "FAIL",runManagerInfoObj);
						repfn.FnUpdateTestStepResHTML("Verify if Empty field is present to add new phone number","Empty field is not present to add new Phone number","FAIL",runManagerInfoObj);
						blnFlag = false;
					}
				} else {
					repfn.FnUpdateTestStepResHTML("Verify if Number is present ","Number is present", "PASS",runManagerInfoObj);
					blnFlag = false;
				}

			} catch (Exception e) {
				blnFlag = false;
				repfn.FnUpdateTestStepResHTML("Verify if Duplicate Number is entered ","Duplicate Number is not added due to some exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		public synchronized boolean EmergencyNumber_ForwardingLines(WebDriver driver, RunManagerInfo runManagerInfoObj) {
			try {
				if (cnf.FnExplicitWait("XPATH", mbo.Number_forwardingNumber,driver)) {
					List<WebElement> Number_ForwardingLines = driver.findElements(By.xpath(mbo.Number_forwardingNumber));
					repfn.FnUpdateTestStepResHTML("Verify the presence of number","Number is present in manage forwarding calls", "PASS",runManagerInfoObj);
					if (cnf.FnExplicitWait("XPATH", mbo.NewPhoneNo,driver)) {
						WebElement NewAddedNum = driver.findElement(By.xpath(mbo.NewPhoneNo));
						System.out.println("Empty blank field");
						repfn.FnUpdateTestStepResHTML("Verify if empty Phone number field is displayed to add new emergency number","Empty Phone number field is displayed to add emergency number","PASS",runManagerInfoObj);

						NewAddedNum.sendKeys("911");

						repfn.FnUpdateTestStepResHTML("Verify if New Emergency Number is added","New Emergency Number is added", "PASS",runManagerInfoObj);
						blnFlag = true;
					} else {
						repfn.FnUpdateTestStepResHTML("Verify if empty Phone number field is displayed to add new emergency number","Empty Phone number field is not displayed to add emergency number","FAIL",runManagerInfoObj);
						repfn.FnUpdateTestStepResHTML("Verify if New Emergency Number is added","New Emergency Number is not added", "FAIL",runManagerInfoObj);
						blnFlag = false;
					}
				} else {
					repfn.FnUpdateTestStepResHTML("Verify the presence of number","Number is not present in manage forwarding calls","FAIL",runManagerInfoObj);
					blnFlag = false;
				}
			} 

			catch (Exception e) {
				blnFlag = false;
				repfn.FnUpdateTestStepResHTML("Verify Emergency Number is entered","Emergency Number is not entered due to some exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		public synchronized boolean FN_ForwardingwindowUI(WebDriver driver,RunManagerInfo runManagerInfoObj){
			try{
				// To verify if Close button is present//
				Thread.sleep(1000);
				if (cnf.FnExplicitWait("XPATH", mbo.ForwardCall_SaveButton,driver)) {
					WebElement Save1 = driver.findElement(By.xpath(mbo.ForwardCall_SaveButton));
					repfn.FnUpdateTestStepResHTML("Verify if Save button is available","Save button is available", "PASS",runManagerInfoObj);
					if (Save1.isEnabled()) {
						repfn.FnUpdateTestStepResHTML("Verify if Save button is enabled","Save button is enabled", "PASS",runManagerInfoObj);
						if (cnf.FnExplicitWait("XPATH", mbo.CancelBtn,driver)) {
							repfn.FnUpdateTestStepResHTML("Verify if Cancel button is displayed","Cancel button is displayed", "PASS",runManagerInfoObj);
							blnFlag = true;
						}
						else {
							repfn.FnUpdateTestStepResHTML("Verify if Cancel button is displayed","Cancel button is not displayed", "FAIL",runManagerInfoObj);
							blnFlag = false;
						}
						// To verify the Call Forwarding On/Off status UI//
						if (cnf.FnExplicitWait("XPATH",mbo.ForwardingCall_StatusOnOff,driver)) {
							WebElement On_Off = driver.findElement(By.xpath(mbo.ForwardingCall_StatusOnOff));
							repfn.FnUpdateTestStepResHTML("Verify if Call Forwarding On/Off toggle is available","Call Forwarding On/Off toggle is available","PASS",runManagerInfoObj);
							blnFlag = true;
						} 
						else {
							repfn.FnUpdateTestStepResHTML("Verify if Call Forwarding On/Off toggle is available","Call Forwarding On/Off toggle is not available","FAIL",runManagerInfoObj);
							blnFlag = false;
						}
						// To verify if Forwarding Method is present//
						if (cnf.FnExplicitWait("XPATH", mbo.ForwardingMethod,driver)) {
							WebElement ForwardingMethod = driver.findElement(By.xpath(mbo.ForwardingMethod));
							repfn.FnUpdateTestStepResHTML("Verify if Call forwarding Method is available","Call forwarding Method is available", "PASS",runManagerInfoObj);
							blnFlag = true;
						} else {
							repfn.FnUpdateTestStepResHTML("Verify if Call forwarding Method is available","Call forwarding Method is not available","FAIL",runManagerInfoObj);
							blnFlag = false;
						}

						// to verify if Manage Forwarding Lines is present//
						if (cnf.FnExplicitWait("XPATH", mbo.ManageForwardingLines,driver)) {
							WebElement ManageForwardingLines = driver.findElement(By.xpath(mbo.ManageForwardingLines));
							repfn.FnUpdateTestStepResHTML("Verify if Manage Forwarding Lines is available","Manage Forwarding Lines is available", "PASS",runManagerInfoObj);
							blnFlag = true;
						} else {
							repfn.FnUpdateTestStepResHTML("Verify if Manage Forwarding Lines is available","Manage Forwarding Lines is not available","FAIL",runManagerInfoObj);
							blnFlag = false;
						}
						
						boolean blnFlag1 = app.SaveChanges_ForwardingCallManager(driver, runManagerInfoObj);
						if (blnFlag1) {
							blnFlag = true;
						} else {
							blnFlag = false;
						}
						driver.navigate().refresh();
					}
					else if (!Save1.isEnabled()) {
						repfn.FnUpdateTestStepResHTML("Verify if Save button is enabled","Save button is disabled", "PASS",runManagerInfoObj);
						if (cnf.FnExplicitWait("XPATH", mbo.ForwardCall_CloseButton,driver)) {
							repfn.FnUpdateTestStepResHTML("Verify if close button is displayed","Close button is displayed", "PASS",runManagerInfoObj);
							blnFlag = true;
						} else {
							repfn.FnUpdateTestStepResHTML("Verify if close button is displayed","Close button is not displayed", "FAIL",runManagerInfoObj);
							blnFlag = false;
						}
						// To verify the Call Forwarding On/Off status UI//
						if (cnf.FnExplicitWait("XPATH",mbo.ForwardingCall_StatusOnOff,driver)) {
							WebElement On_Off = driver.findElement(By.xpath(mbo.ForwardingCall_StatusOnOff));
							repfn.FnUpdateTestStepResHTML("Verify if Call Forwarding On/Off toggle is available","Call Forwarding On/Off toggle is available","PASS",runManagerInfoObj);
							blnFlag = true;
						} else {
							repfn.FnUpdateTestStepResHTML("Verify if Call Forwarding On/Off toggle is available","Call Forwarding On/Off toggle is not available","FAIL",runManagerInfoObj);
							blnFlag = false;
						}
						// To verify if Forwarding Method is present//
						if (cnf.FnExplicitWait("XPATH", mbo.ForwardingMethod,driver)) {
							WebElement ForwardingMethod = driver.findElement(By.xpath(mbo.ForwardingMethod));
							repfn.FnUpdateTestStepResHTML("Verify if Call forwarding Method is available","Call forwarding Method is available", "PASS",runManagerInfoObj);
							blnFlag = true;
						} else {
							repfn.FnUpdateTestStepResHTML("Verify if Call forwarding Method is available","Call forwarding Method is not available","FAIL",runManagerInfoObj);
							blnFlag = false;
						}

						// to verify if Manage Forwarding Lines is present//
						if (cnf.FnExplicitWait("XPATH", mbo.ManageForwardingLines,driver)) {
							WebElement ManageForwardingLines = driver.findElement(By.xpath(mbo.ManageForwardingLines));
							repfn.FnUpdateTestStepResHTML("Verify if Manage Forwarding Lines is available","Manage Forwarding Lines is available", "PASS",runManagerInfoObj);
							blnFlag = true;
						} else {
							repfn.FnUpdateTestStepResHTML("Verify if Manage Forwarding Lines is available","Manage Forwarding Lines is not available","FAIL",runManagerInfoObj);
							blnFlag = false;
						}

						driver.navigate().refresh();

					}
				} 
				else {
					repfn.FnUpdateTestStepResHTML("Verify if Save button is available","Save button is not available", "FAIL",runManagerInfoObj);
					blnFlag = false;
				}

			} 
			
			catch (Exception e) {
				blnFlag = false;
				repfn.FnUpdateTestStepResHTML("Verify the UI of Forwarding Call Manager window","UI of Forwarding Call Manager window is not as expected due to some exception","FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			//driver.navigate().refresh();
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}
		
		public synchronized boolean FN_OpenExternalForwardLine(WebDriver driver,RunManagerInfo runManagerInfoObj)
		{
			try
			{
				if(cnf.FnExplicitWait("XPATH",mbo.FwdingMgr_ExternalLines,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify whether \'Forward to External Lines\' section is displayed","\'Forward to External Lines\' section is displayed ","PASS",runManagerInfoObj);

					if(cnf.FnExplicitWait("XPATH",mbo.FwdingMgr_ExternalLines_Val,driver))
					{
						List<WebElement> Val=driver.findElements(By.xpath(mbo.FwdingMgr_ExternalLines_Val));
						repfn.FnUpdateTestStepResHTML("Verify whether \'Forward to External Lines\' number is displayed","\'Forward to External Lines\' number is displayed:"+" "+Val.get(0).getText(),"PASS",runManagerInfoObj);
						if(cnf.JSClick(Val.get(0),driver)){
							repfn.FnUpdateTestStepResHTML("Verify whether External Forwarding line is selected","External Forwarding line is selected","PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("XPATH",mbo.ForwardStatusONToggle,driver)) {
								repfn.FnUpdateTestStepResHTML("Verify the presence of Forward Status ON toggle","Forward Status ON toggle is present","PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else{
								if(cnf.FnExplicitWait("XPATH", mbo.ForwardStatusOFFToggle,driver)){
									WebElement ForwardStatusOFFToggle=driver.findElement(By.xpath(mbo.ForwardStatusOFFToggle));
									repfn.FnUpdateTestStepResHTML("Verify the presence of Forward Status OFF toggle","Forward Status OFF toggle is present","PASS",runManagerInfoObj);
									if(cnf.JSClick(ForwardStatusOFFToggle,driver)){
										repfn.FnUpdateTestStepResHTML("Verify the click on Forward Status OFF toggle","Forward Status OFF toggle is clicked","PASS",runManagerInfoObj);
										
										if(cnf.FnExplicitWait("XPATH",mbo.ForwardStatusONToggle,driver)) {
											repfn.FnUpdateTestStepResHTML("Verify the presence of Forward Status ON toggle","Forward Status ON toggle is present","PASS",runManagerInfoObj);
											blnFlag=true;
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify the presence of Forward Status ON toggle","Forward Status ON toggle is not present","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify the click on Forward Status OFF toggle","Forward Status OFF toggle is not clicked","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify the presence of Forward Status OFF toggle","Forward Status OFF toggle is not present","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}						
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify whether External Forwarding line is selected","External Forwarding line is not selected","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify whether \'Forward to External Lines\' number is displayed","\'Forward to External Lines\' number is not displayed ","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify whether \'Forward to External Lines\' section is displayed","\'Forward to External Lines\' section is not displayed ","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}

			catch (Exception e) {
				blnFlag = false;
				repfn.FnUpdateTestStepResHTML("Verify if Line with ON status is displayed ","Line with ON status is not displayed due to exception","FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		

		public synchronized boolean FN_emergencycontact(WebDriver driver, RunManagerInfo runManagerInfoObj) {
			try {

				boolean blnFlag1 = AddNewPhoneNumber(driver,runManagerInfoObj);
				if (blnFlag1) {
					boolean blnFlag2 = EmergencyNumber_ForwardingLines(driver,runManagerInfoObj);
					if (blnFlag2) {
						boolean blnFlag3 = EmergencyError_Number(driver,runManagerInfoObj);
						if (blnFlag3) {
							boolean blnFlag4 = Cancel_ForwardingLines(driver,runManagerInfoObj);

							if(blnFlag4){
								if (cnf.FnExplicitWait("XPATH",mbo.ForwardCall_SaveButton,driver)) {
									WebElement SaveButton = driver.findElement(By.xpath(mbo.ForwardCall_SaveButton));
									repfn.FnUpdateTestStepResHTML("Verify if Save button is present","Save button is present", "PASS",runManagerInfoObj);
									if (SaveButton.isEnabled()) {
										repfn.FnUpdateTestStepResHTML("Verify if Save button is enabled","Save button is enabled", "PASS",runManagerInfoObj);
										boolean blnFlag5 = FN_CancelChangesMade(driver,runManagerInfoObj);
										if (blnFlag5) {
											blnFlag = true;
										} else {
											blnFlag = false;
										}
									} 
									else{
										boolean blnFlag6 = app.Close_ManageLines(driver, runManagerInfoObj);
										if (blnFlag6) {
											blnFlag = true;
										} else {
											blnFlag = false;
										}
									}
								} 
								else {
									repfn.FnUpdateTestStepResHTML(
											"Verify if Save button is enabled",
											"Save button is disabled", "FAIL",runManagerInfoObj);
									blnFlag = false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify if the operation can be cancelled","Cancel operation is not performed", "FAIL",runManagerInfoObj);
								blnFlag = false;
							}
						} 
						else {
							blnFlag = false;
							repfn.FnUpdateTestStepResHTML("Verify if any message is displayed when an emergency number(911) is entered",
									"No message is displayed when an emergency number is entered","FAIL",runManagerInfoObj);
						}
					} 
					else {
						repfn.FnUpdateTestStepResHTML("Verify Emergency Number is entered","Emergency Number is not entered", "FAIL",runManagerInfoObj);
						blnFlag = false;
					}
				} 
				else {
					repfn.FnUpdateTestStepResHTML("Verify if Add New Phone Number is present and clicked ","Add New Phone Number is not present and clicked ", "FAIL",runManagerInfoObj);
					blnFlag = false;
				}
				
				driver.navigate().refresh();
				
			} 
			
			catch (Exception e) {
				blnFlag = false;
				repfn.FnUpdateTestStepResHTML(
						"Verify if the user is able to add the emergency number 911 as a forwarding destination number",
						"User is not able to add the emergency number 911 as a forwarding destination number due to some exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}

		

		//To display Duplicate error message for Alias//


		
		// Error message displayed when emergency Number is added in Manage Forwarding Lines//

		public synchronized boolean EmergencyError_Number(WebDriver driver, RunManagerInfo runManagerInfoObj) {
			try {

				if (cnf.FnExplicitWait("XPATH", mbo.EmergencyError,driver)) {
					WebElement emergency = driver.findElement(By
							.xpath(mbo.EmergencyError));
					repfn.FnUpdateTestStepResHTML(
							"Verify if Error message is displayed when emergency Number is entered",
							"Error message is displayed", "PASS",runManagerInfoObj);
					if (cnf.FnExplicitWait("XPATH", mbo.ManageForwardingLines_Save,driver)) {
						WebElement Save = driver.findElement(By
								.xpath(mbo.ManageForwardingLines_Save));
						repfn.FnUpdateTestStepResHTML(
								"Verify the presence of Save button",
								"Save button is present", "PASS",runManagerInfoObj);
						if (!(Save.isEnabled())) {
							System.out.println("Number is emergency");
							repfn.FnUpdateTestStepResHTML(
									"Verify if Save button is disabled",
									"Save button is disabled", "PASS",runManagerInfoObj);
							blnFlag = true;
						} else {
							repfn.FnUpdateTestStepResHTML(
									"Verify if Save button is disabled",
									"Save button is enabled", "FAIL",runManagerInfoObj);
							blnFlag = false;
						}
					} else {
						repfn.FnUpdateTestStepResHTML(
								"Verify the presence of Save button",
								"Save button is not present", "FAIL",runManagerInfoObj);
						blnFlag = false;
					}
				} else {
					System.out.println("Number is not emergency");
					repfn.FnUpdateTestStepResHTML(
							"Verify if Error message is displayed when emergency number is entered",
							"Error message is not displayed", "FAIL",runManagerInfoObj);

					blnFlag = false;
				}

			} catch (Exception e) {
				blnFlag = false;
				repfn.FnUpdateTestStepResHTML(
						"Verify if any message is displayed when an emergency number(911) is entered",
						"No message is displayed when an emergency number is entered due to some exception",
						"FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}
		String NewAliasAdd ="";
		public synchronized boolean NewAlias_ForwardingLines(WebDriver driver, RunManagerInfo runManagerInfoObj){
			try
			{

				/*List <WebElement> Alias_ForwardingLines=driver.findElements(By.xpath(mbo.Alias_ForwardingNumber)); 
					System.out.println("attribute vale"+Alias_ForwardingLines.get(0).getAttribute("defaultValue"));*/
				blnFlag=AddNewPhoneNumber(driver,runManagerInfoObj);
				Thread.sleep(1000);
				if(blnFlag)
				{
					
					int RandomInt=randomInt;
				NewAliasAdd ="Test"+RandomInt;
						//m1.get("NewAlias").toString();
				if (cnf.FnExplicitWait("XPATH", mbo.NewAlias,driver)) 
				{
					WebElement NewAddedAlias = driver.findElement(By.xpath(mbo.NewAlias));
					System.out.println("Empty blank field");
					repfn.FnUpdateTestStepResHTML("Verify if Empty blank field is displayed to add new alias","Empty blank field is displayed to add new Alias","PASS",runManagerInfoObj);

					NewAddedAlias.sendKeys(NewAliasAdd);
					System.out.println("New Alias" + NewAliasAdd);
					if (NewAddedAlias.getText() != null) 
					{
						repfn.FnUpdateTestStepResHTML(
								"Verify if New Alias is added",
								"New Alias is added", "PASS",runManagerInfoObj);
						blnFlag = true;
					}

					else {

						repfn.FnUpdateTestStepResHTML(
								"Verify if New Alias is added",
								"New Alias is not added", "FAIL",runManagerInfoObj);
						blnFlag = false;
					}
				} else {
					repfn.FnUpdateTestStepResHTML("Verify if Empty blank field is displayed to add new alias","Empty blank field is not displayed to add new Alias","FAIL",runManagerInfoObj);
					blnFlag = false;
				}
				}
				else
				{
					blnFlag=false;
				}

			} 
			catch (Exception e) {
				blnFlag = false;
				repfn.FnUpdateTestStepResHTML("Verify if Empty blank field is displayed to add new alias","Empty blank field is not displayed to add new Alias due to some exception","FAIL",runManagerInfoObj);


			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
}	

		


