package com.charter.sb.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.charter.sb.beans.RunManagerInfo;
import com.charter.sb.controllers.Initialization;
import com.charter.sb.resources.MB_PageObjects;
import com.charter.sb.utils.CommonFunctions;
import com.charter.sb.utils.ReportingFunctions;
import com.charter.sb.utils.RunManager;
import com.google.common.collect.Iterables;

public class MessagesService extends Initialization{
	MB_PageObjects mbo = new MB_PageObjects();
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	public static boolean blnFlag = false;
	WebElement Contact_Edited;
	Random rg=new Random();
	int randomInt = rg.nextInt(10000);
	
	
	public synchronized boolean VoiceIcons_check(WebDriver driver,RunManagerInfo runManagerInfoObj){
		try{

			//Thread.sleep(1000);
			if(cnf.FnExplicitWait("XPATH",mbo.Voice_VoiceOverview,driver)){
				repfn.FnUpdateTestStepResHTML("Verify if  Overview icon  is present to navigate back to overview page","   Overview icon  is present to navigate back to overview page","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else 
			{
				repfn.FnUpdateTestStepResHTML("Verify if  Overview icon  is present to navigate back to overview page","   Overview icon  is  not present to navigate back to overview page","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
			
			if(cnf.FnExplicitWait("XPATH",mbo.Voice_VoiceBreadCrumb_VoiceIcon,driver)){
				repfn.FnUpdateTestStepResHTML("Verify if VoiceBrudcrum  is present","VoiceBrudcrum is present","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else 
			{
				repfn.FnUpdateTestStepResHTML("Verify if VoiceBrudcrum  is present","VoiceBrudcrum is not present","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
			
			if(cnf.FnExplicitWait("XPATH",mbo.Voice_VoiceLineDropdown,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify if Voice line Dropdown is displayed ","Voice line Dropdown is displayed ","PASS",runManagerInfoObj);

				WebElement VoicelineDropdown=driver.findElement(By.xpath(mbo.Voice_VoiceLineDropdown));


				if(cnf.JSClick(VoicelineDropdown,driver)){
					repfn.FnUpdateTestStepResHTML("Verify if Voice line Dropdown is clicked","Voice line Dropdown is clicked","PASS",runManagerInfoObj);
					if(cnf.FnExplicitWait("Xpath", mbo.Voice_LineList,driver)){
						List<WebElement> voiceLineList=driver.findElements(By.xpath(mbo.Voice_LineList));
						if(voiceLineList.size()>0){
							if(voiceLineList.get(1).isDisplayed()){
								cnf.JSClick(voiceLineList.get(1),driver);
								repfn.FnUpdateTestStepResHTML("Verify User is able to change the Line"," User is able to change the Line","PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify User is able to change the Line","User is not able to change the Line","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}else{
							repfn.FnUpdateTestStepResHTML("Verify  Voice line list is present ","Voice line list is not present ","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify  Voice line list is present ","Voice line list is not present ","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

				}else{
					repfn.FnUpdateTestStepResHTML("Verify if Voice line Dropdown is clicked","Voice line Dropdown is not clicked","PASS",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else 
			{
				repfn.FnUpdateTestStepResHTML("Verify if Voice line Dropdown is displayed","Voice line Dropdown is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
			
			
			if(cnf.FnExplicitWait("XPATH",mbo.VoiceSettingsBtn,driver)){
				repfn.FnUpdateTestStepResHTML("Verify if Voice Settings Button  is present","Voice Settings Button is present","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else 
			{
				repfn.FnUpdateTestStepResHTML("Verify if Voice Settings Button  is present","Voice Settings Button is not  present","FAIL",runManagerInfoObj);
				blnFlag=false;
			}


			if(cnf.FnExplicitWait("XPATH",mbo.Voice_Phone_Icon,driver)){
				repfn.FnUpdateTestStepResHTML("Verify if Phone Icon  is present in voice message page","Phone Icon  is present in voice message page","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else 
			{
				repfn.FnUpdateTestStepResHTML("Verify if Phone Icon  is present in voice message page","Phone Icon  is not  present in voice message page","FAIL",runManagerInfoObj);
				blnFlag=false;
			}


		}
		catch (Exception e)

		{
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			repfn.FnUpdateTestStepResHTML("Verifying if the user is able to choose which line to view and settings for that line.","User is not able to choose which line to view and settings for that line due to some exception","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	public synchronized boolean VoiceIcons_SingleLinecheck(WebDriver driver,RunManagerInfo runManagerInfoObj){
		try{


				//Thread.sleep(1000);
				if(cnf.FnExplicitWait("XPATH",mbo.Voice_VoiceOverview,driver)){
					repfn.FnUpdateTestStepResHTML("Verify if  Overview icon  is present to navigate back to overview page","   Overview icon  is present to navigate back to overview page","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else 
				{
					repfn.FnUpdateTestStepResHTML("Verify if  Overview icon  is present to navigate back to overview page","   Overview icon  is  not present to navigate back to overview page","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH",mbo.Voice_VoiceBreadCrumb_VoiceIcon,driver)){
					repfn.FnUpdateTestStepResHTML("Verify if VoiceBrudcrum  is present","VoiceBrudcrum is present","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else 
				{
					repfn.FnUpdateTestStepResHTML("Verify if VoiceBrudcrum  is present","VoiceBrudcrum is not present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH",mbo.Voice_SingleLine,driver)){
					repfn.FnUpdateTestStepResHTML("Verify if Voice Singleline is present","Voice Singleline is present","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else 
				{
					repfn.FnUpdateTestStepResHTML("Verify if Voice Singleline is present","Voice Singleline is not present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH",mbo.VoiceSettingsBtn,driver)){
					repfn.FnUpdateTestStepResHTML("Verify if Voice Settings Button  is present","Voice Settings Button is present","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else 
				{
					repfn.FnUpdateTestStepResHTML("Verify if Voice Settings Button  is present","Voice Settings Button is not  present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				//phone icon
				if(cnf.FnExplicitWait("XPATH",mbo.Voice_Phone_Icon,driver)){
					repfn.FnUpdateTestStepResHTML("Verify if Phone Icon  is present in voice message page","Phone Icon  is present in voice message page","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else 
				{
					repfn.FnUpdateTestStepResHTML("Verify if Phone Icon  is present in voice message page","Phone Icon  is not  present in voice message page","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
		
		}
		catch (Exception e)

		{
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			repfn.FnUpdateTestStepResHTML("Verifying if the user is able view the details and settings for the assigned voice line.","User is  not able view the details and settings for the assigned voice line due to some exception","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}

	public synchronized boolean Deletemessages_Cancel(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception
	{
		boolean blnFlag=false;
		try
		{
			if(cnf.FnExplicitWait("XPATH",mbo.Voice_VoiceMessageList,driver)){
				repfn.FnUpdateTestStepResHTML("Verify if Voice messages are displayed","Voice messages are displayed","PASS",runManagerInfoObj);
				List <WebElement> VoiceMessageList=driver.findElements(By.xpath(mbo.Voice_VoiceMessageList));
				if(VoiceMessageList.size() > 0){
					WebElement one = Iterables.getFirst(VoiceMessageList,driver.findElement(By.xpath(mbo.Voice_VoiceMessageList)));
					if(cnf.JSClick(one,driver)){
						repfn.FnUpdateTestStepResHTML("Verify A Message is selected from the Messages list","A Message is selected from the Messages list","PASS",runManagerInfoObj);

						if(cnf.FnExplicitWait("XPATH",mbo.Deletelink,driver)){
							repfn.FnUpdateTestStepResHTML("Verify if Delete link is present","Delete link is present","PASS",runManagerInfoObj);

							WebElement Delete = driver.findElement(By.xpath(mbo.Deletelink));
							if(cnf.JSClick(Delete,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Delete link is clicked ","Delete link is clicked ","PASS",runManagerInfoObj);

								if(cnf.FnExplicitWait("XPATH", mbo.DeletePopup,driver)){
									repfn.FnUpdateTestStepResHTML("Verify Delete popup is displayed after clicking delete link ","Delete popup is displayed after clicking delete link","PASS",runManagerInfoObj);
									if(cnf.FnExplicitWait("XPATH", mbo.DeletePopup_CancelBtn,driver)){
										repfn.FnUpdateTestStepResHTML("Verify Cancel link is displayed","Cancel link is displayed","PASS",runManagerInfoObj);
										WebElement Cancelbtn=driver.findElement(By.xpath(mbo.DeletePopup_CancelBtn));
										if(cnf.JSClick(Cancelbtn,driver)){
											repfn.FnUpdateTestStepResHTML("Verify Cancel link is clicked","Cancel link is clicked","PASS",runManagerInfoObj);

											Thread.sleep(5000);
											if(cnf.FnExplicitWait("XPATH", mbo.MessageLink,driver)){
												repfn.FnUpdateTestStepResHTML("Verify User is returned to Messages page","User is returned to Messages page","PASS",runManagerInfoObj);
												blnFlag=true;
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify User is returned to Messages page","User is not returned to Messages page","FAIL",runManagerInfoObj);
												blnFlag=false; 
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Cancel link is clicked","Cancel link is not clicked","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Cancel link is displayed","Cancel link is not displayed","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Delete popup is displayed after clicking delete link ","Delete popup is not displayed after clicking delete link","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Delete link is clicked ","Delete link is not clicked ","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify if Delete link is present","Delete link is not present","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify A Message is selected from the Messages list","A Message is not selected from the Messages list","FAIL",runManagerInfoObj);
						blnFlag =false;
					}
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify if Voice messages are displayed","Voice messages are not displayed","FAIL",runManagerInfoObj);
				blnFlag =false;
			}

		}
		catch(Exception e)
		{
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			repfn.FnUpdateTestStepResHTML("Verifying if the user is able to delete and cancel that deletepopup in voice messages from the message list. ", "The user is not able to delete and cancel that deletepopup in voice messages from the message list due to some exception. ","FAIL",runManagerInfoObj);
			blnFlag =false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	public synchronized boolean Deletemessages_Confirm(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception
	{
		boolean blnFlag=false;
		try
		{
			if(cnf.FnExplicitWait("XPATH",mbo.Voice_VoiceMessageList,driver)){
				repfn.FnUpdateTestStepResHTML("Verify if Voice messages are displayed","Voice messages are displayed","PASS",runManagerInfoObj);
				List <WebElement> VoiceMessageList=driver.findElements(By.xpath(mbo.Voice_VoiceMessageList));
				if(VoiceMessageList.size() > 0){
					WebElement one = Iterables.getFirst(VoiceMessageList,driver.findElement(By.xpath(mbo.Voice_VoiceMessageList)));
					if(cnf.JSClick(one,driver)){
						repfn.FnUpdateTestStepResHTML("Verify A Message is selected from the Messages list","A Message is selected from the Messages list","PASS",runManagerInfoObj);

						if(cnf.FnExplicitWait("XPATH",mbo.Deletelink,driver)){
							repfn.FnUpdateTestStepResHTML("Verify if Delete link is present","Delete link is present","PASS",runManagerInfoObj);

							WebElement Delete = driver.findElement(By.xpath(mbo.Deletelink));
							if(cnf.JSClick(Delete,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Delete link is clicked ","Delete link is clicked ","PASS",runManagerInfoObj);

								if(cnf.FnExplicitWait("XPATH", mbo.DeletePopup,driver)){
									repfn.FnUpdateTestStepResHTML("Verify Delete popup is displayed after clicking delete link ","Delete popup is displayed after clicking delete link","PASS",runManagerInfoObj);
									if(cnf.FnExplicitWait("XPATH", mbo.ConfirmBtn,driver)){
										repfn.FnUpdateTestStepResHTML("Verify Confirm button is displayed","Confirm button is displayed","PASS",runManagerInfoObj);
										WebElement ConfirmBtn=driver.findElement(By.xpath(mbo.ConfirmBtn));
										if(cnf.JSClick(ConfirmBtn,driver)){
											repfn.FnUpdateTestStepResHTML("Verify Confirm button is clicked","Confirm button is clicked","PASS",runManagerInfoObj);

											Thread.sleep(5000);
											if(cnf.FnExplicitWait("XPATH", mbo.MessageLink,driver)){
												repfn.FnUpdateTestStepResHTML("Verify User is returned to Messages page","User is returned to Messages page","PASS",runManagerInfoObj);
												blnFlag=true;
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify User is returned to Messages page","User is not returned to Messages page","FAIL",runManagerInfoObj);
												blnFlag=false; 
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
								else{
									repfn.FnUpdateTestStepResHTML("Verify Delete popup is displayed after clicking delete link ","Delete popup is not displayed after clicking delete link","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Delete link is clicked ","Delete link is not clicked ","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify if Delete link is present","Delete link is not present","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify A Message is selected from the Messages list","A Message is not selected from the Messages list","FAIL",runManagerInfoObj);
						blnFlag =false;
					}
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify if Voice messages are displayed","Voice messages are not displayed","FAIL",runManagerInfoObj);
				blnFlag =false;
			}
		}
		catch(Exception e)
		{
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			repfn.FnUpdateTestStepResHTML("Verifying if the user is able to delete a voice message from the message list. ", "The user is not able to delete a voice message from the message list due to some exception. ","FAIL",runManagerInfoObj);
			blnFlag =false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	public synchronized boolean fn_blockNumber(WebDriver driver,RunManagerInfo runManagerInfoObj)
	{
		boolean b1nFlag=false;

		try{

			if(cnf.FnExplicitWait("XPATH", mbo.Voice_Voice_ContactName,driver))
			{
				repfn.FnUpdateTestStepResHTML("Check Whether Voice messages are displayed", "Voice messages are displayed","PASS",runManagerInfoObj);
				List <WebElement> ContactNumber=driver.findElements(By.xpath(mbo.Voice_Voice_ContactName));
				List <WebElement> ContactNumbers=new ArrayList();

				for(WebElement Contacts:ContactNumber)
				{
					String ContactsText=Contacts.getText();	
					if(ContactsText.contains("(") || ContactsText.matches("[0-9]+"))
					{
						ContactNumbers.add(Contacts);
					}
				}

				if(ContactNumbers.size()>0)
				{
					repfn.FnUpdateTestStepResHTML("Check Whether Voice messages present for unsaved contact or not", "Voice messages are present for unsaved contacts","PASS",runManagerInfoObj);
					for(int i=0;i<1;i++)
					{
						String ContactsText=ContactNumbers.get(i).getText();	
						if(cnf.JSClick(ContactNumbers.get(i),driver)){
							repfn.FnUpdateTestStepResHTML("Check Whether Voice message is clicked or not", "Clicked on Voice message for unsaved Contact: "+ContactsText,"PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("XPATH", mbo.Voice_Block_Messages,driver)){
								repfn.FnUpdateTestStepResHTML("Check Whether Block link is present or not ", "Block link is present for unsaved contact : " +ContactsText,"PASS",runManagerInfoObj);
								WebElement BlockLink=driver.findElement(By.xpath(mbo.Voice_Block_Messages));
								if(cnf.JSClick(BlockLink,driver)){
									repfn.FnUpdateTestStepResHTML("Check Whether Block link is clicked or not ", "Block link is clicked" ,"PASS",runManagerInfoObj);
									if(cnf.FnExplicitWait("XPATH", mbo.Voice_ConfirmPopup,driver)){
										repfn.FnUpdateTestStepResHTML("Check Whether Confirmation popup present or not ", "Confirmation popup is present" ,"PASS",runManagerInfoObj);
										WebElement ConfirmMessage=driver.findElement(By.xpath(mbo.Voice_ConfirmPopup));

										repfn.FnUpdateTestStepResHTML("Check Whether Confirm option present or not to block the unknown contact ", "Confirm option is present" ,"PASS",runManagerInfoObj);
										//ConfirmMessage.click();
										if(cnf.JSClick(ConfirmMessage,driver)){
											repfn.FnUpdateTestStepResHTML("Check Whether Confirm option clicked or not to block the contact ", "Confirm option is clicked to block contact" ,"PASS",runManagerInfoObj);
											Thread.sleep(3000);

											if(cnf.FnExplicitWait("XPATH", mbo.Voice_Voice_UnBlockLink,driver)){												
												System.out.println("iNSIDE IF");
												repfn.FnUpdateTestStepResHTML("Check Whether unsaved number is blocked or not", " Unsaved Contact blocked as UnBlock link is getting displayed","PASS",runManagerInfoObj);	
												b1nFlag=true;
											}	
											else
											{
												if(cnf.FnExplicitWait("XPATH", mbo.Voice_Block_ErrorMessage,driver)){	
													WebElement Voice_Block_ErrorMessage=driver.findElement(By.xpath(mbo.Voice_Block_ErrorMessage));
													repfn.FnUpdateTestStepResHTML("Check Whether unsaved number is blocked or not", "Unable to block number error message is displayed","FAIL",runManagerInfoObj);	
													b1nFlag=false;
												}
												else{
													System.out.println("iNSIDE ELSE ");
													repfn.FnUpdateTestStepResHTML("Check Whether unsaved number is blocked or not", "Number is not blocked as Block link is getting displayed","FAIL",runManagerInfoObj);	
													b1nFlag=false;
												}
											}
											Thread.sleep(1000);
										}
										else{
											repfn.FnUpdateTestStepResHTML("Check Whether Confirm option clicked or not to block the contact ", "Confirm option is not clicked to block contact" ,"FAIL",runManagerInfoObj);
											b1nFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Check Whether Confirmation popup is present or not ", "Confirmation popup is not present" ,"FAIL",runManagerInfoObj);	
										repfn.FnUpdateTestStepResHTML("Check Whether Confirm option present or not to block the unknown contact ", "Confirm option is not present" ,"FAIL",runManagerInfoObj);
										b1nFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Check Whether Block link is clicked or not ", "Block link is not clicked" ,"FAIL",runManagerInfoObj);
									b1nFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Check Whether Block link present or not", "Block link not present","FAIL",runManagerInfoObj);	
								b1nFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Check Whether Voice message is clicked or not", "Voice message is not clicked","FAIL",runManagerInfoObj);
							b1nFlag=false;
						}
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Check Whether Voice message present for unsaved contact or not", "No voice message present for unsaved contact","FAIL",runManagerInfoObj);
					b1nFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Check Whether Voice messages are displayed", "Voice messages are not displayed","FAIL",runManagerInfoObj);
				b1nFlag=false;
			}
		}

		catch (Exception e)

		{
			repfn.FnUpdateTestStepResHTML("Verifying if the user is able to successfully block the unsaved contact that sent the voice message","user is not able block the unsaved contact that sent the voice message due to some exception","FAIL",runManagerInfoObj);
			b1nFlag=false;
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());

		}
		driver.navigate().refresh();
		System.out.println("boolean value return to this block method: "+blnFlag);
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	public synchronized boolean fn_blockNumberCancel(WebDriver driver,RunManagerInfo runManagerInfoObj)
	{


		boolean b1nFlag=false;  

		try{
			


			if(cnf.FnExplicitWait("XPATH", mbo.Voice_Voice_ContactName,driver))
			{
				repfn.FnUpdateTestStepResHTML("Check Whether Voice messages are displayed", "Voice messages are displayed","PASS",runManagerInfoObj);
				List <WebElement> ContactNumber=driver.findElements(By.xpath(mbo.Voice_Voice_ContactName));
				List <WebElement> ContactNumbers=new ArrayList();

				for(WebElement Contacts:ContactNumber)
				{
					String ContactsText=Contacts.getText();	
					if(ContactsText.contains("(") || ContactsText.matches("[0-9]+"))
					{

						ContactNumbers.add(Contacts);

					}

				}

				if(ContactNumbers.size()>0)
				{
					repfn.FnUpdateTestStepResHTML("Check Whether Voice messages present for unsaved contact or not", "Voice messages are present for unsaved contacts","PASS",runManagerInfoObj);
					for(int i=0;i<1;i++)
					{
						String ContactsText=ContactNumbers.get(i).getText();	
						if(cnf.JSClick(ContactNumbers.get(i),driver)){
							repfn.FnUpdateTestStepResHTML("Check Whether Voice message is clicked or not", "Clicked on Voice message for unsaved Contact: "+ContactsText,"PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("XPATH", mbo.Voice_Block_Messages,driver)){
								repfn.FnUpdateTestStepResHTML("Check Whether Block link is present or not ", "Block link is present for unsaved contact : " +ContactsText,"PASS",runManagerInfoObj);
								WebElement BlockLink=driver.findElement(By.xpath(mbo.Voice_Block_Messages));
								if(cnf.JSClick(BlockLink,driver)){
									repfn.FnUpdateTestStepResHTML("Check Whether Block link is clicked or not ", "Block link is clicked" ,"PASS",runManagerInfoObj);
									if(cnf.FnExplicitWait("XPATH", mbo.Voice_ConfirmPopup,driver)){
										repfn.FnUpdateTestStepResHTML("Check Whether Confirmation popup present or not ", "Confirmation popup is present" ,"PASS",runManagerInfoObj);
										WebElement Voice_CancelPopup=driver.findElement(By.xpath(mbo.Voice_CancelPopup));

										repfn.FnUpdateTestStepResHTML("Check Whether Cancel option present or not to cancel blocking the unknown contact ", "Cancel option is present" ,"PASS",runManagerInfoObj);
										if(cnf.JSClick(Voice_CancelPopup,driver)){
											repfn.FnUpdateTestStepResHTML("Check Whether Cancel option is clicked or not", "Cancel option is clicked" ,"PASS",runManagerInfoObj);
											Thread.sleep(3000);

											if(cnf.FnExplicitWait("XPATH", mbo.Voice_Block_Messages,driver)){												
												System.out.println("iNSIDE IF");
												repfn.FnUpdateTestStepResHTML("Check Whether Unsaved Contact is blocked or not", " Unsaved Contact is not blocked as Block link is getting displayed","PASS",runManagerInfoObj);	
												b1nFlag=true;
											}	
											else
											{
												System.out.println("iNSIDE ELSE ");
												repfn.FnUpdateTestStepResHTML("Check Whether Unsaved Contact is blocked or not", "Unsaved Contact is blocked as Block link is not getting displayed","FAIL",runManagerInfoObj);	
												b1nFlag=false;
											}
											Thread.sleep(1000);
										}
										else{
											repfn.FnUpdateTestStepResHTML("Check Whether Cancel option is clicked or not", "Cancel option is not clicked" ,"FAIL",runManagerInfoObj);
											b1nFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Check Whether Confirmation popup is present or not ", "Confirmation popup is not present" ,"FAIL",runManagerInfoObj);	
										repfn.FnUpdateTestStepResHTML("Check Whether Cancel option present or not to cancel blocking the unknown contact ", "Cancel option is not present" ,"FAIL",runManagerInfoObj);
										b1nFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Check Whether Block link is clicked or not ", "Block link is not clicked" ,"FAIL",runManagerInfoObj);
									b1nFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Check Whether Block link present or not", "Block link not present","FAIL",runManagerInfoObj);	
								b1nFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Check Whether Voice message is clicked or not", "Voice message is not clicked","FAIL",runManagerInfoObj);
							b1nFlag=false;
						}

					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Check Whether Voice message present for unsaved contact or not", "No voice message present for unsaved contact","FAIL",runManagerInfoObj);
					b1nFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Check Whether Voice messages are displayed", "Voice messages are not displayed","FAIL",runManagerInfoObj);
				b1nFlag=false;
			}
		
		}

		catch (Exception e)

		{
			repfn.FnUpdateTestStepResHTML("Verifying if the User is able to block the unsaved contact that sent the voice message and cancel the changes before saving.","User is not able to cancel blocking the unsaved contact that sent the voice message due to some exception","FAIL",runManagerInfoObj);
			b1nFlag=false;
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());

		}
		driver.navigate().refresh();
		System.out.println("boolean value return to this block method: "+blnFlag);
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	public synchronized boolean FNDeletePromptCancelCheck(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{
		try{

			if(cnf.FnExplicitWait("XPATH", mbo.Deletebutton,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Delete Button is displayed","Delete Button is displayed","PASS",runManagerInfoObj);
				WebElement Deletebutton=driver.findElement(By.xpath(mbo.Deletebutton));
				if(!Deletebutton.isEnabled()){
					repfn.FnUpdateTestStepResHTML("Verify Delete button is not enabled before selecting any mesage to delete","Delete button is not enabled before selecting any mesages to delete","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Delete button is not enabled before selecting any mesages to delete ","Delete button is enabled before selecting any mesages to delete","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				if(cnf.FnExplicitWait("XPATH", mbo.CheckboxList,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Checkbox corresponding to each message is displayed","Checkbox corresponding to each message is displayed","PASS",runManagerInfoObj);
					List<WebElement> Checkbox=driver.findElements(By.xpath(mbo.CheckboxList));

					if(Checkbox.size() > 0){
						if(cnf.JSClick(Checkbox.get(1),driver)){
							repfn.FnUpdateTestStepResHTML("Verify Checkbox corresponding to a message is clicked","Checkbox corresponding to a message is clicked","PASS",runManagerInfoObj);

							if(cnf.FnExplicitWait("XPATH", mbo.Deletebutton,driver)){
								if(Deletebutton.isEnabled()){
									repfn.FnUpdateTestStepResHTML("Verify Delete button is enabled after selecting a message to delete ","Delete button is enabled after selecting a message to delete","PASS",runManagerInfoObj);

									if(cnf.JSClick(Deletebutton,driver)){
										repfn.FnUpdateTestStepResHTML("Verify Delete button is clicked ","Delete button is clicked ","PASS",runManagerInfoObj);

										if(cnf.FnExplicitWait("XPATH", mbo.DeletePopup,driver)){
											repfn.FnUpdateTestStepResHTML("Verify Delete popup is displayed after clicking delete button ","Delete popup is displayed after clicking delete button","PASS",runManagerInfoObj);
											if(cnf.FnExplicitWait("XPATH", mbo.DeletePopup_CancelBtn,driver)){
												repfn.FnUpdateTestStepResHTML("Verify Cancel link is displayed in the pop-up","Cancel link is displayed in the pop-up","PASS",runManagerInfoObj);

												WebElement Cancelbtn=driver.findElement(By.xpath(mbo.DeletePopup_CancelBtn));
												if(cnf.JSClick(Cancelbtn,driver)){
													repfn.FnUpdateTestStepResHTML("Verify Cancel link is clicked","Cancel link is clicked","PASS",runManagerInfoObj);

													Thread.sleep(3000);
													if(cnf.FnExplicitWait("XPATH", mbo.MessageLink,driver)){
														repfn.FnUpdateTestStepResHTML("Verify User is returned to Messages page","User is returned to Messages page","PASS",runManagerInfoObj);
														blnFlag=true;
													}
													else{
														repfn.FnUpdateTestStepResHTML("Verify User is returned to Messages page","User is not returned to Messages page","FAIL",runManagerInfoObj);
														blnFlag=false; 
													}
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify Cancel link is clicked","Cancel link is not clicked","FAIL",runManagerInfoObj);
													blnFlag=false;
												}
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify Cancel link is displayed in the pop-up","Cancel link is not displayed in the pop-up","FAIL",runManagerInfoObj);
												blnFlag=false;
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Delete popup is displayed after clicking delete button ","Delete popup is not displayed after clicking delete button","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Delete button is clicked ","Delete button is not clicked ","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Delete button is enabled after selecting a message to delete ","Delete button is not enabled after selecting a message to delete","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Delete Button is displayed","Delete Button is not displayed","FAIL",runManagerInfoObj);
								blnFlag=false; 
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Checkbox corresponding to a message is clicked","Checkbox corresponding to a message is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false; 
						}
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Checkbox corresponding to each message is displayed","Checkbox corresponding to each message is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false; 
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Delete Button is displayed","Delete Button is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false; 
			}
		}
		catch (Exception e)

		{
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			repfn.FnUpdateTestStepResHTML("Verify User return to message page after deletion","User is not  returned to message page after deletion due to some exception","FAIL",runManagerInfoObj);
			blnFlag=false; 
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;	
	}



	public synchronized boolean FNDeleteMessageConfirm(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{
		
		try{


			if(cnf.FnExplicitWait("XPATH", mbo.Deletebutton,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Delete Button is displayed","Delete Button is displayed","PASS",runManagerInfoObj);
				WebElement Deletebutton=driver.findElement(By.xpath(mbo.Deletebutton));
				if(!Deletebutton.isEnabled()){
					repfn.FnUpdateTestStepResHTML("Verify Delete button is not enabled before selecting any mesage to delete","Delete button is not enabled before selecting any mesages to delete","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Delete button is not enabled before selecting any mesages to delete ","Delete button is enabled before selecting any mesages to delete","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				if(cnf.FnExplicitWait("XPATH", mbo.CheckboxList,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Checkbox corresponding to each message is displayed","Checkbox corresponding to each message is displayed","PASS",runManagerInfoObj);
					List<WebElement> Checkbox=driver.findElements(By.xpath(mbo.CheckboxList));

					if(Checkbox.size() > 0){
						if(cnf.JSClick(Checkbox.get(1),driver)){
							repfn.FnUpdateTestStepResHTML("Verify Checkbox corresponding to a message is clicked","Checkbox corresponding to a message is clicked","PASS",runManagerInfoObj);

							if(cnf.FnExplicitWait("XPATH", mbo.Deletebutton,driver)){
								if(Deletebutton.isEnabled()){
									repfn.FnUpdateTestStepResHTML("Verify Delete button is enabled after selecting a message to delete ","Delete button is enabled after selecting a message to delete","PASS",runManagerInfoObj);

									if(cnf.JSClick(Deletebutton,driver)){
										repfn.FnUpdateTestStepResHTML("Verify Delete button is clicked ","Delete button is clicked ","PASS",runManagerInfoObj);

										if(cnf.FnExplicitWait("XPATH", mbo.DeletePopup,driver)){
											repfn.FnUpdateTestStepResHTML("Verify Delete popup is displayed after clicking delete button ","Delete popup is displayed after clicking delete button","PASS",runManagerInfoObj);
											if(cnf.FnExplicitWait("XPATH", mbo.ConfirmBtn,driver)){
												repfn.FnUpdateTestStepResHTML("Verify Confirm link is displayed in the pop-up","Confirm link is displayed in the pop-up","PASS",runManagerInfoObj);

												WebElement ConfirmBtn=driver.findElement(By.xpath(mbo.ConfirmBtn));
												if(cnf.JSClick(ConfirmBtn,driver)){
													repfn.FnUpdateTestStepResHTML("Verify Confirm link is clicked","Confirm link is clicked","PASS",runManagerInfoObj);

													Thread.sleep(3000);
													if(cnf.FnExplicitWait("XPATH", mbo.MessageLink,driver)){
														repfn.FnUpdateTestStepResHTML("Verify User is returned to Messages page","User is returned to Messages page","PASS",runManagerInfoObj);
														blnFlag=true;
													}
													else{
														repfn.FnUpdateTestStepResHTML("Verify User is returned to Messages page","User is not returned to Messages page","FAIL",runManagerInfoObj);
														blnFlag=false; 
													}
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify Confirm link is clicked","Confirm link is not clicked","FAIL",runManagerInfoObj);
													blnFlag=false;
												}
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify Confirm link is displayed in the pop-up","Confirm link is not displayed in the pop-up","FAIL",runManagerInfoObj);
												blnFlag=false;
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Delete popup is displayed after clicking delete button ","Delete popup is not displayed after clicking delete button","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Delete button is clicked ","Delete button is not clicked ","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Delete button is enabled after selecting a message to delete ","Delete button is not enabled after selecting a message to delete","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Delete Button is displayed","Delete Button is not displayed","FAIL",runManagerInfoObj);
								blnFlag=false; 
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Checkbox corresponding to a message is clicked","Checkbox corresponding to a message is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false; 
						}
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Checkbox corresponding to each message is displayed","Checkbox corresponding to each message is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false; 
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Delete Button is displayed","Delete Button is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false; 
			}
		
			
		}
		catch (Exception e)

		{
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			repfn.FnUpdateTestStepResHTML("Verify User return to message page after deletion","User is not returned to message page after deletion due to some exception" ,"FAIL",runManagerInfoObj);

			blnFlag=false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;	
	}
	
	public synchronized boolean FnCancelDeleteVoiceMessages(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{

		try{

			if(cnf.FnExplicitWait("XPATH", mbo.showDeleteMessages,driver)){
				repfn.FnUpdateTestStepResHTML("Verify user has an option to view Deleted Messages", "User has an option to view Deleted Messages","PASS",runManagerInfoObj);
				WebElement showDeleteMessages= driver.findElement(By.xpath(mbo.showDeleteMessages));
				if(cnf.JSClick(showDeleteMessages,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Deleted Messages link is clicked or not", "Deleted Messages link is clicked","PASS",runManagerInfoObj);

					Thread.sleep(3000);
					if(cnf.FnExplicitWait("XPATH", mbo.deletedMessagesList,driver)){
						List<WebElement> deletedMessagesList=driver.findElements(By.xpath(mbo.deletedMessagesList));
						if(deletedMessagesList.size() > 0){
							repfn.FnUpdateTestStepResHTML("Verify Deleted Messages are displayed", "Deleted Messages are displayed","PASS",runManagerInfoObj);

							if(cnf.FnExplicitWait("XPATH", mbo.deletePermanent,driver)){
								repfn.FnUpdateTestStepResHTML("Verify user has an option to permanent deleting Voice and Fax messages ", 
										"User has an option to permanent deleting Voice and Fax messages","PASS",runManagerInfoObj);
								WebElement deletePermanent= driver.findElement(By.xpath(mbo.deletePermanent));
								if(!deletePermanent.isEnabled()){
									repfn.FnUpdateTestStepResHTML("Verify Delete Permanent button is disabled or not", "Delete Permanent button is disabled","PASS",runManagerInfoObj);
									if(cnf.FnExplicitWait("XPATH", mbo.selectAll,driver)){
										repfn.FnUpdateTestStepResHTML("Verify User has an option to select all the deleted voice messages", 
												"User has an option to select all the deleted voice messages","PASS",runManagerInfoObj);
										WebElement selectAll= driver.findElement(By.xpath(mbo.selectAll));
										if(cnf.JSClick(selectAll,driver)){
											repfn.FnUpdateTestStepResHTML("Verify all the Deleted Messages has been selected or not", "All the Deleted Messages has been selected","PASS",runManagerInfoObj);
											if(cnf.FnExplicitWait("XPATH", mbo.deletePermanent,driver)){
												WebElement PermanentDeleteMessages= driver.findElement(By.xpath(mbo.deletePermanent));
												if(PermanentDeleteMessages.isEnabled()){
													repfn.FnUpdateTestStepResHTML("Verify Delete Permanent button is enabled or not", "Delete Permanent button is enabled","PASS",runManagerInfoObj);
													if(cnf.JSClick(PermanentDeleteMessages,driver)){
														repfn.FnUpdateTestStepResHTML("Verify Permanently Delete link is clicked or not", "Permanently Delete link is clicked","PASS",runManagerInfoObj);

														if(cnf.FnExplicitWait("XPATH", mbo.CancelDelete,driver)){
															repfn.FnUpdateTestStepResHTML("Verify popup to confirm permanent delete is present or not", "Popup to confirm permanent delete is present","PASS",runManagerInfoObj);
															repfn.FnUpdateTestStepResHTML("Verify user has an option to cancel permanent deleting Voice and Fax messages ", 
																	"User has an option to cancel permanent deleting Voice and Fax messages","PASS",runManagerInfoObj);
															WebElement CancelDeleteMessages= driver.findElement(By.xpath(mbo.CancelDelete));
															if(cnf.JSClick(CancelDeleteMessages,driver)){
																repfn.FnUpdateTestStepResHTML("Verify cancel link is clicked or not", "Cancel link is clicked","PASS",runManagerInfoObj);
																Thread.sleep(3000);
																if(cnf.FnExplicitWait("XPATH", mbo.selectAll,driver)){
																	WebElement selectAllAgain= driver.findElement(By.xpath(mbo.selectAll));
																	cnf.JSClick(selectAllAgain,driver);

																	Thread.sleep(5000);

																	if(cnf.FnExplicitWait("XPATH", mbo.deletedMessagesList,driver)){
																		repfn.FnUpdateTestStepResHTML("Verify User is navigated to Deleted Messages page or not", "User is navigated to Deleted Messages page or not","PASS",runManagerInfoObj);
																		List<WebElement> deleteMessagesList=driver.findElements(By.xpath(mbo.deletedMessagesList));
																		if(deleteMessagesList.size()>0){
																			repfn.FnUpdateTestStepResHTML("Verify all deleted messages are not permanently deleted", "All deleted messages are not permanently deleted","PASS",runManagerInfoObj);
																			blnFlag	= true;
																		}
																		else{
																			repfn.FnUpdateTestStepResHTML("Verify all deleted messages are not permanently deleted", "All deleted messages are permanently deleted","FAIL",runManagerInfoObj);
																			blnFlag	= false;
																		}

																		Thread.sleep(3000);
																		if(cnf.FnExplicitWait("XPATH", mbo.backToMessages,driver)){
																			repfn.FnUpdateTestStepResHTML("Verify Back to Messages link is displayed", "Back to Messages link is displayed","PASS",runManagerInfoObj);
																			WebElement backToMessages= driver.findElement(By.xpath(mbo.backToMessages));
																			if(cnf.JSClick(backToMessages,driver)){
																				repfn.FnUpdateTestStepResHTML("Verify Back to Messages link is clicked", "Back to Messages link is clicked","PASS",runManagerInfoObj);
																				//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
																				Thread.sleep(3000);

																				if(cnf.FnExplicitWait("XPATH", mbo.showDeleteMessages,driver)){
																					repfn.FnUpdateTestStepResHTML("Verify User is navigated back to Messages page", "User is navigated back to Messages page","PASS",runManagerInfoObj);
																					blnFlag	= true;
																				}
																				else{
																					repfn.FnUpdateTestStepResHTML("Verify User is navigated back to Messages page", "User is not navigated back to Messages page","FAIL",runManagerInfoObj);
																					blnFlag	= false;
																				}

																			}
																			else{
																				repfn.FnUpdateTestStepResHTML("Verify Back to Messages link is clicked", "Back to Messages link is not clicked","FAIL",runManagerInfoObj);
																				blnFlag	= false;
																			}
																		}
																		else{
																			repfn.FnUpdateTestStepResHTML("Verify Back to Messages link is displayed", "Back to Messages link is not displayed","FAIL",runManagerInfoObj);
																			blnFlag	= false;
																		}

																	}
																	else{
																		repfn.FnUpdateTestStepResHTML("Verify User is navigated to Deleted Messages page or not", 
																				"User is not navigated to Deleted Messages page or not","FAIL",runManagerInfoObj);
																		blnFlag	= false;
																	}


																}
															}
															else{
																repfn.FnUpdateTestStepResHTML("Verify cancel link is clicked or not", "Cancel link is not clicked ","FAIL",runManagerInfoObj);
																blnFlag	= false;
															}
														}
														else{
															repfn.FnUpdateTestStepResHTML("Verify popup to confirm permanent delete is present or not", "Popup to confirm permanent delete is not present","FAIL",runManagerInfoObj);
															repfn.FnUpdateTestStepResHTML("Verify user has an option to cancel permanent deleting Voice and Fax messages ", 
																	"User does not have an option to cancel permanent deleting Voice and Fax messages","FAIL",runManagerInfoObj);
															blnFlag	= false;
														}
													}
													else{
														repfn.FnUpdateTestStepResHTML("Verify Permanently Delete link is clicked or not", "Permanently Delete link is not clicked","FAIL",runManagerInfoObj);
														blnFlag	= false;
													}
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify Delete Permanent button is enabled or not", "Delete Permanent button is disabled","FAIL",runManagerInfoObj);
													blnFlag	= false;
												}
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify all the Deleted Messages has been selected or not", "All the Deleted Messages has not been selected","FAIL",runManagerInfoObj);
											blnFlag	= false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify User has an option to select all the deleted voice messages", 
												"User does not have an option to select all the deleted voice messages","FAIL",runManagerInfoObj);
										blnFlag	= false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Delete Permanent button is disabled or not", "Delete Permanent button is enabled","FAIL",runManagerInfoObj);
									blnFlag	= false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify user has an option to  permanent deleting Voice and Fax messages ", 
										"User does not have an option to  permanent deleting Voice and Fax messages","FAIL",runManagerInfoObj);
								blnFlag	= false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Deleted Messages are displayed", "Deleted Messages are not displayed","FAIL",runManagerInfoObj);
							blnFlag	= false;
						}
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Deleted Messages link is clicked or not", "Deleted Messages link is not clicked","FAIL",runManagerInfoObj);
					blnFlag	= false;
				}

			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify user has an option to view Deleted Messages", "User does not have an option to view Deleted Messages","FAIL",runManagerInfoObj);
				blnFlag	= false;
			}
		}

		catch(Exception e)
		{
			repfn.FnUpdateTestStepResHTML("Verify user is able to cancel permanent deleting Voice and Fax messages ", 
					"User is not able to cancel permanent deleting Voice and Fax messages due to some exception.","FAIL",runManagerInfoObj);
			blnFlag	= false;
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());

		}

		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;

	}
	public synchronized boolean fnViewDeletedMessages(WebDriver driver,RunManagerInfo runManagerInfoObj) {
		try
		{
			
			if(cnf.FnExplicitWait("XPATH", mbo.deletedMsgBtn,driver))
			{
				WebElement deletedMessagesButton=driver.findElement(By.xpath(mbo.deletedMsgBtn));
				blnFlag=true;
				repfn.FnUpdateTestStepResHTML("Verify if there is an option to view the deleted messages"," User should be able to view \"Deleted Messages\" button on the top right corner", "PASS",runManagerInfoObj);
				if(cnf.JSClick(deletedMessagesButton,driver))
				{
					blnFlag=true;
					repfn.FnUpdateTestStepResHTML("Verify the deleted messages link is clicked or not"," Deleted messages link is clicked", "PASS",runManagerInfoObj);
				}
				else
				{
					blnFlag=false;
					repfn.FnUpdateTestStepResHTML("Verify the deleted messages link is clicked or not"," Deleted messages link is not clicked", "FAIL",runManagerInfoObj);
				}
				
				List<WebElement> viewUnreadMessages=driver.findElements(By.xpath(mbo.unreadVoiceMsg));
				if(cnf.FnExplicitWait("XPATH", mbo.unreadVoiceMsg,driver))
				{
					if(!viewUnreadMessages.isEmpty())
					{
						blnFlag=true;
						repfn.FnUpdateTestStepResHTML("Verify if there is an option to view the unread deleted messages"," User should be able to view \"Unread Deleted Messages\"", "PASS",runManagerInfoObj);
					}else if(viewUnreadMessages.isEmpty())
					{
						blnFlag=true;
						repfn.FnUpdateTestStepResHTML("Check Whether the unread messages list is empty or not"," Unread message list is empty ", "PASS",runManagerInfoObj);
					}
					else
					{
						blnFlag=false;
						repfn.FnUpdateTestStepResHTML("Verify if there is an option to view the unread deleted messages"," User should be able to view \"Unread Deleted Messages\"", "FAIL",runManagerInfoObj);
					}

				}
				List<WebElement> viewReadMessages=driver.findElements(By.xpath(mbo.readVoiceMsg));
				if(cnf.FnExplicitWait("XPATH", mbo.readVoiceMsg,driver))
				{
					if(!viewReadMessages.isEmpty())
					{
						blnFlag=true;
						repfn.FnUpdateTestStepResHTML("Verify if there is an option to view the read deleted messages"," User should be able to view \"Read Deleted Messages\"", "PASS",runManagerInfoObj);
					}else if(viewReadMessages.isEmpty())
					{
						blnFlag=true;
						repfn.FnUpdateTestStepResHTML("Check Whether the unread messages list is empty or not"," Unread message list is empty ", "PASS",runManagerInfoObj);
					}
					else
					{
						blnFlag=false;
						repfn.FnUpdateTestStepResHTML("Verify if there is an option to view the Read deleted messages"," User should be able to view \"Read Deleted Messages\"", "FAIL",runManagerInfoObj);
					}

				}

			}
			else
			{
				blnFlag=false;
				repfn.FnUpdateTestStepResHTML("Verify if there is an option to view the deleted messages"," User should be able to view \"Deleted Messages\" button on the top right corner", "FAIL",runManagerInfoObj);
			}
		}
		catch(Exception e)
		{
			blnFlag=false;
			repfn.FnUpdateTestStepResHTML("Verify  if user is able to view read and unread voice messages"," User is not able to view deleted meassages due to some exception", "FAIL",runManagerInfoObj);
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
		}
		app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	public synchronized boolean FnDeleteVoiceMessages(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{

		try{

			if(cnf.FnExplicitWait("XPATH", mbo.showDeleteMessages,driver)){
				repfn.FnUpdateTestStepResHTML("Verify user has an option to view Deleted Messages", "User has an option to view Deleted Messages","PASS",runManagerInfoObj);
				WebElement showDeleteMessages= driver.findElement(By.xpath(mbo.showDeleteMessages));
				if(cnf.JSClick(showDeleteMessages,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Deleted Messages link is clicked or not", "Deleted Messages link is clicked","PASS",runManagerInfoObj);

					Thread.sleep(3000);
					if(cnf.FnExplicitWait("XPATH", mbo.deletedMessagesList,driver)){
						List<WebElement> deletedMessagesList=driver.findElements(By.xpath(mbo.deletedMessagesList));
						if(deletedMessagesList.size() > 0){
							repfn.FnUpdateTestStepResHTML("Verify Deleted Messages are displayed", "Deleted Messages are displayed","PASS",runManagerInfoObj);

							if(cnf.FnExplicitWait("XPATH", mbo.deletePermanent,driver)){
								repfn.FnUpdateTestStepResHTML("Verify user has an option to permanent deleting Voice and Fax messages ", 
										"User has an option to permanent deleting Voice and Fax messages","PASS",runManagerInfoObj);
								WebElement deletePermanent= driver.findElement(By.xpath(mbo.deletePermanent));
								if(!deletePermanent.isEnabled()){
									repfn.FnUpdateTestStepResHTML("Verify Delete Permanent button is disabled or not", "Delete Permanent button is disabled","PASS",runManagerInfoObj);
									if(cnf.FnExplicitWait("XPATH", mbo.selectAll,driver)){
										repfn.FnUpdateTestStepResHTML("Verify User has an option to select all the deleted voice messages", 
												"User has an option to select all the deleted voice messages","PASS",runManagerInfoObj);
										WebElement selectAll= driver.findElement(By.xpath(mbo.selectAll));
										if(cnf.JSClick(selectAll,driver)){
											repfn.FnUpdateTestStepResHTML("Verify all the Deleted Messages has been selected or not", "All the Deleted Messages has been selected","PASS",runManagerInfoObj);
											if(cnf.FnExplicitWait("XPATH", mbo.deletePermanent,driver)){
												WebElement PermanentDeleteMessages= driver.findElement(By.xpath(mbo.deletePermanent));
												if(PermanentDeleteMessages.isEnabled()){
													repfn.FnUpdateTestStepResHTML("Verify Delete Permanent button is enabled or not", "Delete Permanent button is enabled","PASS",runManagerInfoObj);
													if(cnf.JSClick(PermanentDeleteMessages,driver)){
														repfn.FnUpdateTestStepResHTML("Verify Permanently Delete link is clicked or not", "Permanently Delete link is clicked","PASS",runManagerInfoObj);

														if(cnf.FnExplicitWait("XPATH", mbo.Confirmbtn,driver)){
															repfn.FnUpdateTestStepResHTML("Verify popup to confirm permanent delete is present or not", "Popup to confirm permanent delete is present","PASS",runManagerInfoObj);
															repfn.FnUpdateTestStepResHTML("Verify user has an option to permanent delete Voice and Fax messages ", 
																	"User has an option to permanent delete Voice and Fax messages","PASS",runManagerInfoObj);
															WebElement Confirmbtn= driver.findElement(By.xpath(mbo.Confirmbtn));
															if(cnf.JSClick(Confirmbtn,driver)){
																repfn.FnUpdateTestStepResHTML("Verify confirm option is clicked or not", "Confirm option is clicked","PASS",runManagerInfoObj);
																blnFlag	= true;
																//Thread.sleep(3000);
															}
															else{
																repfn.FnUpdateTestStepResHTML("Verify confirm option is clicked or not", "Confirm option is not clicked","FAIL",runManagerInfoObj);
																blnFlag	= false;
															}

															Thread.sleep(5000);

															if(cnf.FnExplicitWait("XPATH", mbo.deletedMessagesList,driver)){
																repfn.FnUpdateTestStepResHTML("Verify Deleted Messages are displayed", "Deleted Messages are displayed","FAIL",runManagerInfoObj);
																blnFlag	= false;

															}
															else{
																repfn.FnUpdateTestStepResHTML("Verify Deleted Messages are displayed", "Deleted Messages are not displayed. All the messages have been deleted permanently","PASS",runManagerInfoObj);
																blnFlag	= true;
															}

															//List<WebElement> deleteMessagesList=driver.findElements(By.xpath(mbo.deletedMessagesList));
															/*if(deleteMessagesList.size() <= 0){
																	repfn.FnUpdateTestStepResHTML("Verify all deleted messages are permanently deleted", "All deleted messages are permanently deleted","PASS",runManagerInfoObj);
																	blnFlag	= true;
																}
																else{
																	repfn.FnUpdateTestStepResHTML("Verify all deleted messages are not permanently deleted", "All deleted messages are not permanently deleted","FAIL",runManagerInfoObj);
																	blnFlag	= false;
																}*/

															Thread.sleep(3000);
															if(cnf.FnExplicitWait("XPATH", mbo.backToMessages,driver)){
																repfn.FnUpdateTestStepResHTML("Verify Back to Messages link is displayed", "Back to Messages link is displayed","PASS",runManagerInfoObj);
																WebElement backToMessages= driver.findElement(By.xpath(mbo.backToMessages));
																if(cnf.JSClick(backToMessages,driver)){
																	repfn.FnUpdateTestStepResHTML("Verify Back to Messages link is clicked", "Back to Messages link is clicked","PASS",runManagerInfoObj);
																	//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
																	Thread.sleep(3000);

																	if(cnf.FnExplicitWait("XPATH", mbo.showDeleteMessages,driver)){
																		repfn.FnUpdateTestStepResHTML("Verify User is navigated back to Messages page", "User is navigated back to Messages page","PASS",runManagerInfoObj);
																		blnFlag	= true;
																	}
																	else{
																		repfn.FnUpdateTestStepResHTML("Verify User is navigated back to Messages page", "User is not navigated back to Messages page","FAIL",runManagerInfoObj);
																		blnFlag	= false;
																	}

																}
																else{
																	repfn.FnUpdateTestStepResHTML("Verify Back to Messages link is clicked", "Back to Messages link is not clicked","FAIL",runManagerInfoObj);
																	blnFlag	= false;
																}
															}
															else{
																repfn.FnUpdateTestStepResHTML("Verify Back to Messages link is displayed", "Back to Messages link is not displayed","FAIL",runManagerInfoObj);
																blnFlag	= false;
															}


														}
														else{
															repfn.FnUpdateTestStepResHTML("Verify popup to confirm permanent delete is present or not", "Popup to confirm permanent delete is not present","FAIL",runManagerInfoObj);
															repfn.FnUpdateTestStepResHTML("Verify user has an option to cancel permanent deleting Voice and Fax messages ", 
																	"User does not have an option to cancel permanent deleting Voice and Fax messages","FAIL",runManagerInfoObj);
															blnFlag	= false;
														}
													}
													else{
														repfn.FnUpdateTestStepResHTML("Verify Permanently Delete link is clicked or not", "Permanently Delete link is not clicked","FAIL",runManagerInfoObj);
														blnFlag	= false;
													}
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify Delete Permanent button is enabled or not", "Delete Permanent button is disabled","FAIL",runManagerInfoObj);
													blnFlag	= false;
												}
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify all the Deleted Messages has been selected or not", "All the Deleted Messages has not been selected","FAIL",runManagerInfoObj);
											blnFlag	= false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify User has an option to select all the deleted voice messages", 
												"User does not have an option to select all the deleted voice messages","FAIL",runManagerInfoObj);
										blnFlag	= false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Delete Permanent button is disabled or not", "Delete Permanent button is enabled","FAIL",runManagerInfoObj);
									blnFlag	= false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify user has an option to  permanent deleting Voice and Fax messages ", 
										"User does not have an option to  permanent deleting Voice and Fax messages","FAIL",runManagerInfoObj);
								blnFlag	= false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Deleted Messages are displayed", "Deleted Messages are not displayed","FAIL",runManagerInfoObj);
							blnFlag	= false;
						}
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Deleted Messages link is clicked or not", "Deleted Messages link is not clicked","FAIL",runManagerInfoObj);
					blnFlag	= false;
				}

			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify user has an option to view Deleted Messages", "User does not have an option to view Deleted Messages","FAIL",runManagerInfoObj);
				blnFlag	= false;
			}

		}

		catch(Exception e)
		{
			repfn.FnUpdateTestStepResHTML("Verify user is able to permanently delete Voice and Fax messages ", 
					"User is not able to permanently delete Voice and Fax messages due to some exception","FAIL",runManagerInfoObj);
			blnFlag	= false;
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());

		}

		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;

	}
	public synchronized boolean FnDeleteVoiceMessage(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{

		int listSize = 0;
		int listSizeOne = 0;
		try{

			if(cnf.FnExplicitWait("XPATH", mbo.showDeleteMessages,driver)){
				repfn.FnUpdateTestStepResHTML("Verify user has an option to view Deleted Messages", "User has an option to view Deleted Messages","PASS",runManagerInfoObj);
				WebElement showDeleteMessages= driver.findElement(By.xpath(mbo.showDeleteMessages));
				if(cnf.JSClick(showDeleteMessages,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Deleted Messages link is clicked or not", "Deleted Messages link is clicked","PASS",runManagerInfoObj);
					Thread.sleep(3000);

					if(cnf.FnExplicitWait("XPATH", mbo.Voice_Voice_ContactName,driver)){
						List<WebElement> deletedMessagesList=driver.findElements(By.xpath(mbo.Voice_Voice_ContactName));
						if(deletedMessagesList.size() > 0){
							repfn.FnUpdateTestStepResHTML("Verify Deleted Messages are present or not", "Deleted Messages are present","PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("XPATH", mbo.deletePermanent,driver)){
								repfn.FnUpdateTestStepResHTML("Verify user has an option to permanent deleting Voice and Fax messages ", 
										"User has an option to permanent deleting Voice and Fax messages","PASS",runManagerInfoObj);
								WebElement deletePermanent= driver.findElement(By.xpath(mbo.deletePermanent));
								if(!deletePermanent.isEnabled()){
									repfn.FnUpdateTestStepResHTML("Verify Delete Permanent button is disabled or not", "Delete Permanent button is disabled","PASS",runManagerInfoObj);
									WebDriverWait explicitWait= new WebDriverWait(driver, 20);
									explicitWait.until(ExpectedConditions.elementToBeClickable(deletedMessagesList.get(0)));
									String deletedMsg=deletedMessagesList.get(0).getText();
									List <WebElement> MessageText=new ArrayList<WebElement>();

									for(WebElement we: deletedMessagesList){
										if(we.getText().contains(deletedMsg))
										{
											MessageText.add(we);
										}
									}

									listSize = MessageText.size();
									System.out.println(listSize);

									List<WebElement> deletedMessagescheckbx=driver.findElements(By.xpath(mbo.deletedMessagescheckbx));
									if(cnf.JSClick(deletedMessagescheckbx.get(0),driver)){
										repfn.FnUpdateTestStepResHTML("Verify Single Voice message is selected to delete", "Single Voice message is selected to delete","PASS",runManagerInfoObj);
										if(cnf.FnExplicitWait("XPATH", mbo.deletePermanent,driver)){
											WebElement PermanentDeleteMessages= driver.findElement(By.xpath(mbo.deletePermanent));
											if(PermanentDeleteMessages.isEnabled()){
												repfn.FnUpdateTestStepResHTML("Verify Delete Permanent button is enabled or not", "Delete Permanent button is enabled","PASS",runManagerInfoObj);
												if(cnf.JSClick(PermanentDeleteMessages,driver)){
													repfn.FnUpdateTestStepResHTML("Verify Permanently Delete link is clicked or not", "Permanently Delete link is clicked","PASS",runManagerInfoObj);

													if(cnf.FnExplicitWait("XPATH", mbo.Confirmbtn,driver)){
														repfn.FnUpdateTestStepResHTML("Verify popup to confirm permanent delete is present or not", "Popup to confirm permanent delete is present","PASS",runManagerInfoObj);
														repfn.FnUpdateTestStepResHTML("Verify user has an option to permanent delete Voice and Fax messages ", 
																"User has an option to permanent delete Voice and Fax messages","PASS",runManagerInfoObj);
														WebElement Confirm= driver.findElement(By.xpath(mbo.Confirmbtn));
														if(cnf.JSClick(Confirm,driver)){
															repfn.FnUpdateTestStepResHTML("Verify Confirm option is clicked or not", "Confirm option is clicked","PASS",runManagerInfoObj);
															Thread.sleep(3000);
															List<WebElement> deleteMessagesList=driver.findElements(By.xpath(mbo.Voice_Voice_ContactName));

															/*																if(deleteMessagesList.get(0).getText().equals(deletedMsg))
																{
																	repfn.FnUpdateTestStepResHTML("Verify voice message is permanently deleted or not", "Voice Message is not permanently deleted","FAIL",runManagerInfoObj);
																	blnFlag	= false;

																}
																else{	
																	repfn.FnUpdateTestStepResHTML("Verify voice message is permanently deleted or not", "Voice Message is permanently deleted","PASS",runManagerInfoObj);
																	blnFlag	= true;
																}*/

															List <WebElement> MessageTextOne=new ArrayList<WebElement>();

															for(WebElement we: deletedMessagesList){
																if(we.getText().contains(deletedMsg))
																{
																	MessageTextOne.add(we);
																}
															}

															listSizeOne = MessageTextOne.size();
															System.out.println(listSizeOne);

															if(listSizeOne != listSize){
																repfn.FnUpdateTestStepResHTML("Verify voice message is permanently deleted or not", "Voice Message is permanently deleted","PASS",runManagerInfoObj);
																blnFlag	= true;
															}
															else{
																repfn.FnUpdateTestStepResHTML("Verify voice message is permanently deleted or not", "Voice Message is not permanently deleted","FAIL",runManagerInfoObj);
																blnFlag	= false;
															}

															Thread.sleep(3000);

															if(cnf.FnExplicitWait("XPATH", mbo.backToMessages,driver)){
																repfn.FnUpdateTestStepResHTML("Verify Back to Messages link is displayed", "Back to Messages link is displayed","PASS",runManagerInfoObj);
																WebElement backToMessages= driver.findElement(By.xpath(mbo.backToMessages));
																if(cnf.JSClick(backToMessages,driver)){
																	repfn.FnUpdateTestStepResHTML("Verify Back to Messages link is clicked", "Back to Messages link is clicked","PASS",runManagerInfoObj);
																	//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
																	Thread.sleep(3000);

																	if(cnf.FnExplicitWait("XPATH", mbo.showDeleteMessages,driver)){
																		repfn.FnUpdateTestStepResHTML("Verify User is navigated back to Messages page", "User is navigated back to Messages page","PASS",runManagerInfoObj);
																		blnFlag	= true;
																	}
																	else{
																		repfn.FnUpdateTestStepResHTML("Verify User is navigated back to Messages page", "User is not navigated back to Messages page","FAIL",runManagerInfoObj);
																		blnFlag	= false;
																	}

																}
																else{
																	repfn.FnUpdateTestStepResHTML("Verify Back to Messages link is clicked", "Back to Messages link is not clicked","FAIL",runManagerInfoObj);
																	blnFlag	= false;
																}
															}
														}
														else{
															repfn.FnUpdateTestStepResHTML("Verify confirm option is clicked or not", "Confirm option is not clicked","FAIL",runManagerInfoObj);
															blnFlag	= false;
														}

													}
													else{
														repfn.FnUpdateTestStepResHTML("Verify popup to confirm permanent delete is present or not", "Popup to confirm permanent delete is not present","FAIL",runManagerInfoObj);
														repfn.FnUpdateTestStepResHTML("Verify user has an option to permanent delete Voice and Fax messages ", 
																"User does not have an option to permanent delete Voice and Fax messages","FAIL",runManagerInfoObj);
													}
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify Permanently Delete link is clicked or not", "Permanently Delete link is not clicked","FAIL",runManagerInfoObj);
													blnFlag	= false;
												}
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify Delete Permanent button is enabled or not", "Delete Permanent button is disabled","FAIL",runManagerInfoObj);
												blnFlag	= false;
											}
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Single Voice message is selected to delete", "Single Voice message is not selected to delete","FAIL",runManagerInfoObj);
										blnFlag	= false;
									}								
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Delete Permanent button is disabled or not", "Delete Permanent button is enabled","FAIL",runManagerInfoObj);
									blnFlag	= false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify user has an option to  permanent deleting Voice and Fax messages ", 
										"User does not have an option to  permanent deleting Voice and Fax messages","FAIL",runManagerInfoObj);
								blnFlag	= false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Deleted Messages are present or not", "Deleted Messages are not present","FAIL",runManagerInfoObj);
							blnFlag	= false;
						}
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Deleted Messages link is clicked or not", "Deleted Messages link is not clicked","FAIL",runManagerInfoObj);
					blnFlag	= false;
				}

			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify user has an option to view Deleted Messages", "User does not have an option to view Deleted Messages","FAIL",runManagerInfoObj);
				blnFlag	= false;
			}
		}

		catch(Exception e)
		{
			repfn.FnUpdateTestStepResHTML("Verify user is able to permanently delete Voice and Fax messages ", 
					"User is not able to permanently delete Voice and Fax messages due to some exception.","FAIL",runManagerInfoObj);
			blnFlag	= false;
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());

		}

		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	public synchronized boolean FnCancelDeleteVoiceMessage(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{

		try{

			if(cnf.FnExplicitWait("XPATH", mbo.showDeleteMessages,driver)){
				repfn.FnUpdateTestStepResHTML("Verify user has an option to view Deleted Messages", "User has an option to view Deleted Messages","PASS",runManagerInfoObj);
				WebElement showDeleteMessages= driver.findElement(By.xpath(mbo.showDeleteMessages));
				if(cnf.JSClick(showDeleteMessages,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Deleted Messages link is clicked or not", "Deleted Messages link is clicked","PASS",runManagerInfoObj);
					Thread.sleep(3000);
					if(cnf.FnExplicitWait("XPATH", mbo.Voice_Voice_ContactName,driver)){
						List<WebElement> deletedMessagesList=driver.findElements(By.xpath(mbo.Voice_Voice_ContactName));
						if(deletedMessagesList.size() > 0){
							repfn.FnUpdateTestStepResHTML("Verify Deleted Messages are present or not", "Deleted Messages are present","PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("XPATH", mbo.deletePermanent,driver)){
								repfn.FnUpdateTestStepResHTML("Verify user has an option to permanent deleting Voice and Fax messages ", 
										"User has an option to permanent deleting Voice and Fax messages","PASS",runManagerInfoObj);
								WebElement deletePermanent= driver.findElement(By.xpath(mbo.deletePermanent));
								if(!deletePermanent.isEnabled()){
									repfn.FnUpdateTestStepResHTML("Verify Delete Permanent button is disabled or not", "Delete Permanent button is disabled","PASS",runManagerInfoObj);
									WebDriverWait explicitWait= new WebDriverWait(driver, 20);
									explicitWait.until(ExpectedConditions.elementToBeClickable(deletedMessagesList.get(0)));
									if(deletedMessagesList.get(0).isDisplayed()){
										String deletedMsg=deletedMessagesList.get(0).getText();
										List<WebElement> deletedMessagescheckbx=driver.findElements(By.xpath(mbo.deletedMessagescheckbx));
										if(cnf.JSClick(deletedMessagescheckbx.get(0),driver)){
											repfn.FnUpdateTestStepResHTML("Verify Single Voice message is selected to delete", "Single Voice message is selected to delete","PASS",runManagerInfoObj);
											if(cnf.FnExplicitWait("XPATH", mbo.deletePermanent,driver)){
												WebElement PermanentDeleteMessages= driver.findElement(By.xpath(mbo.deletePermanent));
												if(PermanentDeleteMessages.isEnabled()){
													repfn.FnUpdateTestStepResHTML("Verify Delete Permanent button is enabled or not", "Delete Permanent button is enabled","PASS",runManagerInfoObj);
													if(cnf.JSClick(PermanentDeleteMessages,driver)){
														repfn.FnUpdateTestStepResHTML("Verify Permanently Delete link is clicked or not", "Permanently Delete link is clicked","PASS",runManagerInfoObj);

														if(cnf.FnExplicitWait("XPATH", mbo.CancelDelete,driver)){
															repfn.FnUpdateTestStepResHTML("Verify popup to confirm permanent delete is present or not", "Popup to confirm permanent delete is present","PASS",runManagerInfoObj);
															repfn.FnUpdateTestStepResHTML("Verify user has an option to cancel permanent deleting Voice and Fax messages ", 
																	"User has an option to cancel permanent deleting Voice and Fax messages","PASS",runManagerInfoObj);
															WebElement CancelDeleteMessages= driver.findElement(By.xpath(mbo.CancelDelete));
															if(cnf.JSClick(CancelDeleteMessages,driver)){
																repfn.FnUpdateTestStepResHTML("Verify cancel link is clicked or not", "Cancel link is clicked","PASS",runManagerInfoObj);
																Thread.sleep(3000);
																List<WebElement> deleteMessagesList=driver.findElements(By.xpath(mbo.Voice_Voice_ContactName));
																for(WebElement msg:deleteMessagesList){
																	String listmsg=msg.getText();

																	if(listmsg.equals(deletedMsg))
																	{
																		repfn.FnUpdateTestStepResHTML("Verify message is not permanently deleted", "Message is not permanently deleted","PASS",runManagerInfoObj);
																		blnFlag	= true;
																		break;
																	}
																}
																if(!blnFlag)
																{
																	repfn.FnUpdateTestStepResHTML("Verify message is not permanently deleted", "Message is permanently deleted","FAIL",runManagerInfoObj);
																	blnFlag	= false;
																}
																Thread.sleep(3000);

																if(cnf.FnExplicitWait("XPATH", mbo.backToMessages,driver)){
																	repfn.FnUpdateTestStepResHTML("Verify Back to Messages link is displayed", "Back to Messages link is displayed","PASS",runManagerInfoObj);
																	WebElement backToMessages= driver.findElement(By.xpath(mbo.backToMessages));
																	if(cnf.JSClick(backToMessages,driver)){
																		repfn.FnUpdateTestStepResHTML("Verify Back to Messages link is clicked", "Back to Messages link is clicked","PASS",runManagerInfoObj);
																		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
																		Thread.sleep(3000);

																		if(cnf.FnExplicitWait("XPATH", mbo.showDeleteMessages,driver)){
																			repfn.FnUpdateTestStepResHTML("Verify User is navigated back to Messages page", "User is navigated back to Messages page","PASS",runManagerInfoObj);
																			blnFlag	= true;
																		}
																		else{
																			repfn.FnUpdateTestStepResHTML("Verify User is navigated back to Messages page", "User is not navigated back to Messages page","FAIL",runManagerInfoObj);
																			blnFlag	= false;
																		}

																	}
																	else{
																		repfn.FnUpdateTestStepResHTML("Verify Back to Messages link is clicked", "Back to Messages link is not clicked","FAIL",runManagerInfoObj);
																		blnFlag	= false;
																	}
																}
																else{
																	repfn.FnUpdateTestStepResHTML("Verify Back to Messages link is displayed", "Back to Messages link is not displayed","FAIL",runManagerInfoObj);
																	blnFlag	= false;
																}
															}
															else{
																repfn.FnUpdateTestStepResHTML("Verify cancel link is clicked or not", "Cancel link is not clicked ","FAIL",runManagerInfoObj);
																blnFlag	= false;
															}

														}
														else{
															repfn.FnUpdateTestStepResHTML("Verify popup to confirm permanent delete is present or not", "Popup to confirm permanent delete is not present","FAIL",runManagerInfoObj);
															repfn.FnUpdateTestStepResHTML("Verify user has an option to cancel permanent deleting Voice and Fax messages ", 
																	"User does not have an option to cancel permanent deleting Voice and Fax messages","FAIL",runManagerInfoObj);
															blnFlag	= false;
														}
													}
													else{
														repfn.FnUpdateTestStepResHTML("Verify Permanently Delete link is clicked or not", "Permanently Delete link is not clicked","FAIL",runManagerInfoObj);
														blnFlag	= false;
													}
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify Delete Permanent button is enabled or not", "Delete Permanent button is disabled","FAIL",runManagerInfoObj);
													blnFlag	= false;
												}
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Single Voice message is selected to delete", "Single Voice message is not selected to delete","FAIL",runManagerInfoObj);
											blnFlag	= false;
										}
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Delete Permanent button is disabled or not", "Delete Permanent button is enabled","FAIL",runManagerInfoObj);
									blnFlag	= false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify user has an option to  permanent deleting Voice and Fax messages ", 
										"User does not have an option to  permanent deleting Voice and Fax messages","FAIL",runManagerInfoObj);
								blnFlag	= false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Deleted Messages are present or not", "Deleted Messages are not present","FAIL",runManagerInfoObj);
							blnFlag	= false;
						}
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Deleted Messages link is clicked or not", "Deleted Messages link is not clicked","FAIL",runManagerInfoObj);
					blnFlag	= false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify user has an option to view Deleted Messages", "User does not have an option to view Deleted Messages","FAIL",runManagerInfoObj);
				blnFlag	= false;
			}
		}

		catch(Exception e)
		{
			repfn.FnUpdateTestStepResHTML("Verify user is able to cancel permanent deleting Voice and Fax messages ", 
					"User is not able to cancel permanent deleting Voice and Fax messages due to some exception.","FAIL",runManagerInfoObj);
			blnFlag	= false;
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());

		}

		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}

	public synchronized boolean FnVerifyGoBackToMessages(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{
		try{

			if(cnf.FnExplicitWait("XPATH", mbo.showDeleteMessages,driver)){
				repfn.FnUpdateTestStepResHTML("Verify user has an option to view Deleted Messages", "User has an option to view Deleted Messages","PASS",runManagerInfoObj);
				WebElement showDeleteMessages= driver.findElement(By.xpath(mbo.showDeleteMessages));
				if(cnf.JSClick(showDeleteMessages,driver)){
					repfn.FnUpdateTestStepResHTML("Verify user has clicked the Deleted Messages link or not", "User has clicked the Deleted Messages link","PASS",runManagerInfoObj);

					Thread.sleep(5000);
					if(cnf.FnExplicitWait("XPATH", mbo.backToMessages,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Back to Messages link is displayed", "Back to Messages link is displayed","PASS",runManagerInfoObj);
						WebElement backToMessages= driver.findElement(By.xpath(mbo.backToMessages));
						if(cnf.JSClick(backToMessages,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Back to Messages link is clicked", "Back to Messages link is clicked","PASS",runManagerInfoObj);
							//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
							Thread.sleep(3000);

							if(cnf.FnExplicitWait("XPATH", mbo.showDeleteMessages,driver)){
								repfn.FnUpdateTestStepResHTML("Verify User is navigated back to Messages page", "User is navigated back to Messages page","PASS",runManagerInfoObj);
								blnFlag	= true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify User is navigated back to Messages page", "User is not navigated back to Messages page","FAIL",runManagerInfoObj);
								blnFlag	= false;
							}

						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Back to Messages link is clicked", "Back to Messages link is not clicked","FAIL",runManagerInfoObj);
							blnFlag	= false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Back to Messages link is displayed", "Back to Messages link is not displayed","FAIL",runManagerInfoObj);
						blnFlag	= false;
					}

				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify user has clicked the Deleted Messages link or not", "User has not clicked the Deleted Messages link","FAIL",runManagerInfoObj);
					blnFlag	= false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify user has an option to view Deleted Messages", "User does not have an option to view Deleted Messages","FAIL",runManagerInfoObj);
				blnFlag	= false;
			}
		}

		catch(Exception e)
		{
			repfn.FnUpdateTestStepResHTML("Verify Back to Messages link is clicked", "Back to Messages link is not clicked due to some exception.","FAIL",runManagerInfoObj);
			blnFlag	= false;
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());

		}

		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}

}
