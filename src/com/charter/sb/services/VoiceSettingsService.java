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

public class VoiceSettingsService extends Initialization {
	MB_PageObjects mbo = new MB_PageObjects();
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	public static boolean blnFlag = false;
	
	public synchronized boolean Fn_ChangeVoicePinUI(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{


	 	try{
	 		
	 		if(cnf.FnExplicitWait("XPATH", mbo.Voice_VoicemailPin,driver)){
	 			repfn.FnUpdateTestStepResHTML("Verify Change Voicemail Pin option is displayed", "Change Voicemail Pin option is displayed","PASS",runManagerInfoObj);
	 			WebElement VoicemailPin=driver.findElement(By.xpath(mbo.Voice_VoicemailPin));
	 			
	 			if(cnf.JSClick(VoicemailPin,driver)){
	 				repfn.FnUpdateTestStepResHTML("Verify Change Voicemail Pin option is clicked or not", "Change Voicemail Pin option is clicked ","PASS",runManagerInfoObj);
	 				
	 				if(cnf.FnExplicitWait("XPATH", mbo.VoicemailPin_NewPinInput,driver))
	 				{
	 					repfn.FnUpdateTestStepResHTML("Verify if Option to enter New Pin is present", "Option to enter new pin is present", "PASS",runManagerInfoObj);
	 					blnFlag=true;
	 				}
	 				else
	 				{
	 					repfn.FnUpdateTestStepResHTML("Verify if Option to enter New Pin is present", "Option to enter new pin is not present", "FAIL",runManagerInfoObj);
	 					blnFlag=false;
	 				}
	 				
	 				if(cnf.FnExplicitWait("XPATH", mbo.VoicemailPin_ConfirmPinInput,driver))
	 				{
	 					repfn.FnUpdateTestStepResHTML("Verify if Option to Reenter New Pin is present", "Option to Reenter new pin is present", "PASS",runManagerInfoObj);
	 					blnFlag=true;
	 				}
	 				else
	 				{
	 					repfn.FnUpdateTestStepResHTML("Verify if Option to Reenter New Pin is present", "Option to Reenter new pin is not present", "FAIL",runManagerInfoObj);
	 					blnFlag=false;
	 				}
	 			}
	 			else{
	 				repfn.FnUpdateTestStepResHTML("Verify Change Voicemail Pin option is clicked or not", "Change Voicemail Pin option is not clicked ","FAIL",runManagerInfoObj);
	 				blnFlag=false;
	 			}
	 		}
	 		else{
	 			repfn.FnUpdateTestStepResHTML("Verify Change Voicemail Pin option is displayed", "Change Voicemail Pin option is not displayed","FAIL",runManagerInfoObj);
	 			blnFlag=false;
	 		}	 	
	 	}
	 	catch (Exception e)

	 	{
	 		repfn.FnUpdateTestStepResHTML("Verify if Change VoiceMail Pin has the expected UI"," Change VoiceMail Pin does not have the expected UI due to some exception","FAIL",runManagerInfoObj);
	 		blnFlag=false;
	 		System.err.println("Message : "+e.getMessage());
	 		System.err.println("Cause : "+e.getCause());

	 	}
	 	m1.put("STEPSTATUS", blnFlag);
	 	return blnFlag;

	 }
	 public synchronized boolean ChangeVoiceMailPin_close(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception
	 {
	 	try
	 	{
	 		if(cnf.FnExplicitWait("XPATH", mbo.Close_pin_option,driver))
	 		{
	 			repfn.FnUpdateTestStepResHTML("Verify Close option is displayed", "Close option is displayed","PASS",runManagerInfoObj);
	 			WebElement Close_pin_option=driver.findElement(By.xpath(mbo.Close_pin_option));
	 			if(cnf.JSClick(Close_pin_option,driver)){
	 				repfn.FnUpdateTestStepResHTML("Verify Close button is clicked or not ", "Close button is clicked","PASS",runManagerInfoObj);
	 				
	 				if(cnf.FnExplicitWait("XPATH", mbo.VoiceSettingsMenu,driver)){
	 					repfn.FnUpdateTestStepResHTML("Verify User is returned to Voicemail settings menu or not ", "User is returned to Voicemail settings menu","PASS",runManagerInfoObj);
		 				blnFlag=true;
	 				}		 			
		 			else{
		 				repfn.FnUpdateTestStepResHTML("Verify User is returned to Voicemail settings menu or not ", "User is not returned to Voicemail settings menu","FAIL",runManagerInfoObj);
		 				blnFlag=false;
		 			}
	 			}
	 			else{
	 				repfn.FnUpdateTestStepResHTML("Verify Close button is clicked or not ", "Close button is not clicked","FAIL",runManagerInfoObj);
	 				blnFlag=false;
	 			}
	 		}
	 		else{
	 			repfn.FnUpdateTestStepResHTML("Verify Close option is displayed", "Close option is not displayed","FAIL",runManagerInfoObj);
	 			blnFlag=false;
	 		}
	 	}
	 	catch(Exception e)
	 	{
	 		repfn.FnUpdateTestStepResHTML("Verify if user is able to close the window","User is not able to close the window due to some exception","FAIL",runManagerInfoObj);
	 		blnFlag=false;
	 		System.err.println("Message : "+e.getMessage());
	 		System.err.println("Cause : "+e.getCause());
	 	}
	 	m1.put("STEPSTATUS", blnFlag);
	 	return blnFlag;
	 }
	 
	 
	 public synchronized boolean Fn_SaveVoicemailPin(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{

			String newPin = m1.get("NewPin").toString();
			try{	 		
				if(cnf.FnExplicitWait("XPATH", mbo.Voice_VoicemailPin,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Change Voicemail Pin option is displayed", "Change Voicemail Pin option is displayed","PASS",runManagerInfoObj);
					WebElement VoicemailPin=driver.findElement(By.xpath(mbo.Voice_VoicemailPin));

					if(cnf.JSClick(VoicemailPin,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Change Voicemail Pin option is clicked or not", "Change Voicemail Pin option is clicked ","PASS",runManagerInfoObj);

						if(cnf.FnExplicitWait("XPATH", mbo.VoicemailPin_NewPinInput,driver))
						{
							repfn.FnUpdateTestStepResHTML("Verify if Option to enter New Pin is present", "Option to enter new pin is present", "PASS",runManagerInfoObj);
							WebElement VoicemailPin_NewPinInput=driver.findElement(By.xpath(mbo.VoicemailPin_NewPinInput));
							VoicemailPin_NewPinInput.sendKeys(newPin);
							repfn.FnUpdateTestStepResHTML("Verify New voicemail Pin is enterd or not ", "New voicemail Pin enterd is: "+newPin,"PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else
						{
							repfn.FnUpdateTestStepResHTML("Verify if Option to enter New Pin is present", "Option to enter new pin is not present", "FAIL",runManagerInfoObj);
							blnFlag=false;
						}

						if(cnf.FnExplicitWait("XPATH", mbo.VoicemailPin_ConfirmPinInput,driver))
						{
							repfn.FnUpdateTestStepResHTML("Verify if Option to Reenter New Pin is present", "Option to Reenter new pin is present", "PASS",runManagerInfoObj);
							WebElement VoicemailPin_ConfirmPinInput=driver.findElement(By.xpath(mbo.VoicemailPin_ConfirmPinInput));
							VoicemailPin_ConfirmPinInput.sendKeys(newPin);
							repfn.FnUpdateTestStepResHTML("Verify confirm voicemail Pin is enterd or not ", "Confirm voicemail Pin entered is: "+newPin,"PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else
						{
							repfn.FnUpdateTestStepResHTML("Verify if Option to Reenter New Pin is present", "Option to Reenter new pin is not present", "FAIL",runManagerInfoObj);
							blnFlag=false;
						}

						if(cnf.FnExplicitWait("XPATH", mbo.VoicemailPin_SavePin,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Save button is displayed", "Save button is displayed","PASS",runManagerInfoObj);
							WebElement VoicemailPin_SavePin=driver.findElement(By.xpath(mbo.VoicemailPin_SavePin));
							if(VoicemailPin_SavePin.isEnabled()){
								repfn.FnUpdateTestStepResHTML("Verify Save button is enabled", "Save button is enabled","PASS",runManagerInfoObj);
								if(cnf.JSClick(VoicemailPin_SavePin,driver)){
									repfn.FnUpdateTestStepResHTML("Verify Save button is clicked", "Save button is clicked","PASS",runManagerInfoObj);
									Thread.sleep(2000);

									if(cnf.FnExplicitWait("XPATH", mbo.VoicemailPin_PinSavedMsg,driver)){
										WebElement VoicemailPin_PinSavedMsg=driver.findElement(By.xpath(mbo.VoicemailPin_PinSavedMsg));
										repfn.FnUpdateTestStepResHTML("Verify User is able to save the changed pin number", "User is able to save the changed pin number, with success message shown as: "+VoicemailPin_PinSavedMsg.getText(),"PASS",runManagerInfoObj);
										blnFlag=true;	 								
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify User is able to save the changed pin number", "User is not able to save the changed pin number as Success message is not displayed","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Save button is clicked", "Save button is not clicked","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Save button is enabled", "Save button is not enabled","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Save button is displayed", "Save button is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Change Voicemail Pin option is clicked or not", "Change Voicemail Pin option is not clicked ","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Change Voicemail Pin option is displayed", "Change Voicemail Pin option is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}	 	

			}
			catch (Exception e)

			{
				repfn.FnUpdateTestStepResHTML("Verify User should be able to save the changed pin number","User is not able to save the changed pin number due to some exception","FAIL",runManagerInfoObj);
				blnFlag=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());

			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}
	 public synchronized boolean Fn_CancelSaveVoicemailPin(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{

			String newPin = m1.get("NewPin").toString();
			try{	 		
				if(cnf.FnExplicitWait("XPATH", mbo.Voice_VoicemailPin,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Change Voicemail Pin option is displayed", "Change Voicemail Pin option is displayed","PASS",runManagerInfoObj);
					WebElement VoicemailPin=driver.findElement(By.xpath(mbo.Voice_VoicemailPin));

					if(cnf.JSClick(VoicemailPin,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Change Voicemail Pin option is clicked or not", "Change Voicemail Pin option is clicked ","PASS",runManagerInfoObj);

						if(cnf.FnExplicitWait("XPATH", mbo.VoicemailPin_NewPinInput,driver))
						{
							repfn.FnUpdateTestStepResHTML("Verify if Option to enter New Pin is present", "Option to enter new pin is present", "PASS",runManagerInfoObj);
							WebElement VoicemailPin_NewPinInput=driver.findElement(By.xpath(mbo.VoicemailPin_NewPinInput));
							VoicemailPin_NewPinInput.sendKeys(newPin);
							repfn.FnUpdateTestStepResHTML("Verify New voicemail Pin is enterd or not ", "New voicemail Pin enterd is: "+newPin,"PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else
						{
							repfn.FnUpdateTestStepResHTML("Verify if Option to enter New Pin is present", "Option to enter new pin is not present", "FAIL",runManagerInfoObj);
							blnFlag=false;
						}

						if(cnf.FnExplicitWait("XPATH", mbo.VoicemailPin_ConfirmPinInput,driver))
						{
							repfn.FnUpdateTestStepResHTML("Verify if Option to Reenter New Pin is present", "Option to Reenter new pin is present", "PASS",runManagerInfoObj);
							WebElement VoicemailPin_ConfirmPinInput=driver.findElement(By.xpath(mbo.VoicemailPin_ConfirmPinInput));
							VoicemailPin_ConfirmPinInput.sendKeys(newPin);
							repfn.FnUpdateTestStepResHTML("Verify confirm voicemail Pin is enterd or not ", "Confirm voicemail Pin entered is: "+newPin,"PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else
						{
							repfn.FnUpdateTestStepResHTML("Verify if Option to Reenter New Pin is present", "Option to Reenter new pin is not present", "FAIL",runManagerInfoObj);
							blnFlag=false;
						}

						if(cnf.FnExplicitWait("XPATH", mbo.VoicemailPin_SavePinCancel,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Cancel link is displayed", "Cancel link is displayed","PASS",runManagerInfoObj);
							WebElement VoicemailPin_SavePinCancel=driver.findElement(By.xpath(mbo.VoicemailPin_SavePinCancel));
							if(cnf.JSClick(VoicemailPin_SavePinCancel,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Cancel link is clicked", "Cancel link is clicked","PASS",runManagerInfoObj);
								Thread.sleep(2000);

								if(cnf.FnExplicitWait("XPATH", mbo.VoicemailPin_ConfirmCancelPopup,driver)){
									repfn.FnUpdateTestStepResHTML("Verify Confirm popup is displayed or not", "Confirm popup is displayed","PASS",runManagerInfoObj);
									if(cnf.FnExplicitWait("XPATH", mbo.VoicemailPin_ConfirmButtononPopup,driver)){
										repfn.FnUpdateTestStepResHTML("Verify Confirm button is displayed", "Confirm button is displayed","PASS",runManagerInfoObj);
										WebElement VoicemailPin_ConfirmButtononPopup=driver.findElement(By.xpath(mbo.VoicemailPin_ConfirmButtononPopup));
										if(cnf.JSClick(VoicemailPin_ConfirmButtononPopup,driver)){
											repfn.FnUpdateTestStepResHTML("Verify Confirm button is clicked", "Confirm button is clicked","PASS",runManagerInfoObj);
											Thread.sleep(2000);

											if(cnf.FnExplicitWait("XPATH", mbo.VoiceSettingsMenu,driver)){
												repfn.FnUpdateTestStepResHTML("Verify User is returned to voicemail settings menu or not ", "User is returned to voicemail settings menu","PASS",runManagerInfoObj);
												blnFlag=true;
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify User is returned to voicemail settings menu or not ", "User is not returned to voicemail settings menu","FAIL",runManagerInfoObj);
												blnFlag=false;
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Confirm button is clicked", "Confirm button is not clicked","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Confirm button is displayed", "Confirm button is not displayed","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Confirm popup is displayed or not", "Confirm popup is not displayed","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Cancel link is clicked", "Cancel link is not clicked","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Cancel link is displayed", "Cancel link is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Change Voicemail Pin option is clicked or not", "Change Voicemail Pin option is not clicked ","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Change Voicemail Pin option is displayed", "Change Voicemail Pin option is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}	 	

			}
			catch (Exception e)

			{
				repfn.FnUpdateTestStepResHTML("Verify User should be able to cancel saving the changed pin number","User is not able to cancel saving the changed pin number due to some exception","FAIL",runManagerInfoObj);
				blnFlag=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());

			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}
	 public synchronized boolean FnVerifyMessagesPage(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{

			try{
				if(cnf.FnExplicitWait("XPATH", mbo.verifyMessagesPage,driver)){
					repfn.FnUpdateTestStepResHTML("Verify user is on Messages page ", "User is on Messages page","PASS",runManagerInfoObj);
					blnFlag	= true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify user is on Messages page ", "User is not on Messages page","FAIL",runManagerInfoObj);
					blnFlag	= false;
				}

			}

			catch(Exception e)
			{
				repfn.FnUpdateTestStepResHTML("Verify user is on Messages page ", "User is not on Messages page","FAIL",runManagerInfoObj);
				blnFlag	=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}

			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;


		}
	 public synchronized boolean FnVerifyCallForward(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{
			try{

				if(cnf.FnExplicitWait("XPATH", mbo.VoiceSettingsButton,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Voice Settings is displayed ", "Voice Settings is displayed ","PASS",runManagerInfoObj);
					WebElement VoiceSettingsButton= driver.findElement(By.xpath(mbo.VoiceSettingsButton));
					if(cnf.JSClick(VoiceSettingsButton,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Voice Settings link is clicked or not ", "Voice Settings link is clicked ","PASS",runManagerInfoObj);

						if(cnf.FnExplicitWait("XPATH", mbo.CallForward,driver)){
							repfn.FnUpdateTestStepResHTML("Verify user has an option to Forward all calls", "User has an option to Forward all calls ","PASS",runManagerInfoObj);
							WebElement CallForward= driver.findElement(By.xpath(mbo.CallForward));
							if(cnf.FnExplicitWait("XPATH", mbo.CallForwardOnOff,driver)){
								WebElement CallForwardOnOff= driver.findElement(By.xpath(mbo.CallForwardOnOff));
								if(CallForwardOnOff.getText().equalsIgnoreCase("(Off)")){
									if(cnf.JSClick(CallForward,driver)){
										repfn.FnUpdateTestStepResHTML("Verify Call Forward Option is clicked or not ", "Call Forward Option is clicked ","PASS",runManagerInfoObj);

										if(cnf.FnExplicitWait("XPATH", mbo.toggleSwitch,driver)){
											repfn.FnUpdateTestStepResHTML("Verify Call Forwarding ON/OFF slide bar is displayed or not ", 
													"Call Forwarding ON/OFF slide bar is displayed","PASS",runManagerInfoObj);
											WebElement toggleSwitch= driver.findElement(By.xpath(mbo.toggleSwitch));
											if(cnf.JSClick(toggleSwitch,driver)){
												repfn.FnUpdateTestStepResHTML("Verify Call Forwarding ON/OFF slide bar is clicked or not ", 
														"Call Forwarding ON/OFF slide bar is clicked","PASS",runManagerInfoObj);
												blnFlag	=true;

											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify Call Forwarding ON/OFF slide bar is clicked or not ", 
														"Call Forwarding ON/OFF slide bar is not clicked","FAIL",runManagerInfoObj);
												blnFlag	=false;
											}

										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Call Forwarding ON/OFF slide bar is displayed or not ", 
													"Call Forwarding ON/OFF slide bar is not displayed","FAIL",runManagerInfoObj);
											blnFlag	=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Call Forward Option is clicked or not ", "Call Forward Option is not clicked ","FAIL",runManagerInfoObj);
										blnFlag	=false;
									}
								}
								else{
									if(cnf.JSClick(CallForward,driver)){
										repfn.FnUpdateTestStepResHTML("Verify Call Forward Option is clicked or not ", "Call Forward Option is clicked ","PASS",runManagerInfoObj);
										blnFlag	=true;
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Call Forward Option is clicked or not ", "Call Forward Option is not clicked ","FAIL",runManagerInfoObj);
										blnFlag	=false;
									}
								}
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify user has an option to Forward all calls", "User does not have option to Forward all calls ","FAIL",runManagerInfoObj);
							blnFlag	=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Voice Settings link is clicked or not ", "Voice Settings link is not clicked ","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Voice Settings is displayed ", "Voice Settings is not displayed ","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
			}

			catch(Exception e)
			{
				repfn.FnUpdateTestStepResHTML("Verify user has an option to Forward all calls", "User does not have option to Forward all calls due to some exception.","FAIL",runManagerInfoObj);
				blnFlag	=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());

			}

			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}
	 public synchronized boolean VerifyCallForwardOptions(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{

			try{

				if(cnf.FnExplicitWait("XPATH", mbo.cancelForwardSettings,driver)){
					repfn.FnUpdateTestStepResHTML("Verify User has an option to cancel the Call Forwarding changes", 
							"User has an option to cancel the Call Forwarding changes","PASS",runManagerInfoObj);
					blnFlag	=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User has an option to cancel the Call Forwarding changes", 
							"User does not have option to cancel the Call Forwarding changes","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}

				if(cnf.FnExplicitWait("XPATH", mbo.saveForwardSettings,driver)){
					repfn.FnUpdateTestStepResHTML("Verify User has an option to save the Call Forwarding changes", 
							"User has an option to save the Call Forwarding changes","PASS",runManagerInfoObj);
					blnFlag	=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User has an option to save the Call Forwarding changes", 
							"User does not have option to save the Call Forwarding changes","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}

				if(cnf.FnExplicitWait("XPATH", mbo.forwardMethod,driver)){
					repfn.FnUpdateTestStepResHTML("Verify User has an option to choose the Call Forwarding method", 
							"User has an option to choose the Call Forwarding method","PASS",runManagerInfoObj);
					blnFlag	=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User has an option to chose the Call Forwarding method", 
							"User does not have option to chose the Call Forwarding method","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}

				if(cnf.FnExplicitWait("XPATH", mbo.forwardCallNumberDropDown,driver)){
					repfn.FnUpdateTestStepResHTML("Verify dropdown to chose the number for Call Forwarding is displayed or not", 
							"Dropdown to chose the number for Call Forwarding is displayed","PASS",runManagerInfoObj);
					WebElement forwardCallNumberDropDown= driver.findElement(By.xpath(mbo.forwardCallNumberDropDown));
					if(cnf.JSClick(forwardCallNumberDropDown,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Forward Calls Number Drop down is clicked", 
								"Forward Calls Number Drop down is clicked","PASS",runManagerInfoObj);
						if(cnf.FnExplicitWait("XPATH", mbo.forwardCallNumberDropDownList,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Call numbers are displayed in dropdown list or not", "Call numbers are displayed in dropdown list","PASS",runManagerInfoObj);
							blnFlag	=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Call numbers are present in dropdown list or not", "Call numbers are not displayed in dropdown list","FAIL",runManagerInfoObj);
							blnFlag	=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Forward Calls Number Drop down is clicked", 
								"Forward Calls Number Drop down is not clicked","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}

					cnf.JSClick(forwardCallNumberDropDown,driver);

				}
				else{
					if(cnf.FnExplicitWait("XPATH", mbo.ForwardAllCallsTo_NotDropdown,driver))
					{
						WebElement ForwardAllCallsTo_NotDropdown = driver.findElement(By.xpath(mbo.ForwardAllCallsTo_NotDropdown));
						if(ForwardAllCallsTo_NotDropdown.getText().contains("No lines")){
							repfn.FnUpdateTestStepResHTML("Verify if Forward All Calls to dropdown is available","Forward All Calls to dropdown is not available. No Phone Line is displayed. Message displayed is: "+ForwardAllCallsTo_NotDropdown.getText(),"PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify if Forward All Calls to dropdown is available","Forward All Calls to dropdown is not available. Phone Line displayed is: "+ForwardAllCallsTo_NotDropdown.getText(),"PASS",runManagerInfoObj);
							blnFlag=true;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify if Forward All Calls to dropdown is available","Forward All Calls to dropdown is not available. Single Phone Line or Message is also not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}

				if(cnf.FnExplicitWait("XPATH", mbo.manageForwardLines,driver)){
					repfn.FnUpdateTestStepResHTML("Verify User has an option to manage forward lines for Call Forwarding", "User has an option to manage forward lines for Call Forwarding","PASS",runManagerInfoObj);
					blnFlag	=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User has an option to manage forward lines for Call Forwarding method", "User does not have option to manage forward lines for Call Forwarding","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}


			}

			catch(Exception e)
			{
				repfn.FnUpdateTestStepResHTML("Verify user is able to see Call Forward options", "User is not able to see Call Forward options due to some exception","FAIL",runManagerInfoObj);
				blnFlag	=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());

			}

			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
	 public synchronized boolean CloseVoiceSettings(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{
			try{

				Thread.sleep(5000);

				if(cnf.FnExplicitWait("XPATH", mbo.cancelForwardSettings,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Cancel link is displayed", "Cancel link  is displayed","PASS",runManagerInfoObj);
					WebElement cancelForwardSettings= driver.findElement(By.xpath(mbo.cancelForwardSettings));
					if(cnf.JSClick(cancelForwardSettings,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Cancel link is clicked", "Cancel link is clicked","PASS",runManagerInfoObj);
						
						if(cnf.FnExplicitWait("XPATH", mbo.VoicemailPin_ConfirmButtononPopup,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Confirmation popup is displayed", "Confirmation popup is displayed as changes were made.","PASS",runManagerInfoObj);
							repfn.FnUpdateTestStepResHTML("Verify Confirm button is displayed", "Confirm button is displayed","PASS",runManagerInfoObj);
							WebElement VoicemailPin_ConfirmButtononPopup=driver.findElement(By.xpath(mbo.VoicemailPin_ConfirmButtononPopup));
							if(cnf.JSClick(VoicemailPin_ConfirmButtononPopup,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Confirm button is clicked", "Confirm button is clicked","PASS",runManagerInfoObj);
								Thread.sleep(2000);
								blnFlag=true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Confirm button is clicked", "Confirm button is not clicked","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Confirmation popup is not displayed", "Confirmation popup is not displayed as no changes were made.","PASS",runManagerInfoObj);
							blnFlag=true;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Cancel link is clicked", "Cancel link is not clicked","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Cancel link is displayed", "Cancel link is not displayed","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}

				if(cnf.FnExplicitWait("XPATH", mbo.VoiceSettingsButton,driver)){
					WebElement VoiceSettingsButton= driver.findElement(By.xpath(mbo.VoiceSettingsButton));
					if(cnf.JSClick(VoiceSettingsButton,driver)){
						blnFlag	= true;
					}
					else{
						blnFlag	=false;
					}
				}
				else{
					blnFlag	=false;
				}
			}

			catch(Exception e)
			{	
				repfn.FnUpdateTestStepResHTML("Verify user is able to close the Voice Settings box.", "User is not able to close the Voice Settings box due to some exception","FAIL",runManagerInfoObj);
				blnFlag	=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}

			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
	 public synchronized boolean Fn_ForwardInternal_External_Lines_LabelCheck(WebDriver driver,RunManagerInfo runManagerInfoObj) {
			try {

				// Internal Line
				if(cnf.FnExplicitWait("XPATH", mbo.ForwarInternalLabel,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify \'Forward to Internal Lines\' Label is displayed ","\'Forward to Internal Lines\' Label is displayed  ", "PASS",runManagerInfoObj);
					blnFlag = true;

				} else {
					repfn.FnUpdateTestStepResHTML("Verify \'Forward to Internal Lines\' Label is displayed ","\'Forward to Internal Lines\' Label is not displayed  ", "FAIL",runManagerInfoObj);
					blnFlag = false;
				}

				// External Line

				if(cnf.FnExplicitWait("XPATH", mbo.ForwarExrernalLabel,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify \'Forward to External Lines\' Label is displayed ","\'Forward to External Lines\' Label is displayed  ", "PASS",runManagerInfoObj);
					blnFlag = true;

				} else {
					repfn.FnUpdateTestStepResHTML("Verify \'Forward to External Lines\' Label is displayed ","\'Forward to External Lines\' Label is not displayed  ", "FAIL",runManagerInfoObj);
					blnFlag = false;
				}

				// Print the Details displaying in the page

				if(cnf.FnExplicitWait("XPATH", mbo.ForwardLineList,driver))
				{
					List<WebElement> ForwardLineList = driver.findElements(By.xpath(mbo.ForwardLineList));
					repfn.FnUpdateTestStepResHTML("Verify Forward Line List is displayed "," Forward Line List is displayed. No of Forward Lines displayed: "+ForwardLineList.size(),"PASS",runManagerInfoObj);
					blnFlag = true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify Forward Line List is displayed "," Forward Line List is not displayed ","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}

			catch (Exception e)
			{
				repfn.FnUpdateTestStepResHTML(
						"Verify Forward Internal Label,Forward External Label and Forward Line List are displayed ",
						" Forward Internal Label,Forward External Label and Forward Line List are not displayed due to some exception ",
						"FAIL",runManagerInfoObj);
				System.err.println("Message : " + e.getMessage());
				System.err.println("Cause : " + e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
	 public synchronized boolean Fn_ForwardTo_If_LabelCheck(WebDriver driver,RunManagerInfo runManagerInfoObj) {
			try {

				// Forward_if
				if(cnf.FnExplicitWait("XPATH", mbo.ForwardOnLine_Forward_ifLabel,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify \'Forward If\' Label is displayed "," \'Forward If\' Label is displayed ", "PASS",runManagerInfoObj);
					blnFlag = true;

				} else {
					repfn.FnUpdateTestStepResHTML("Verify \'Forward If\' Label is displayed "," \'Forward If\' Label is not displayed ", "FAIL",runManagerInfoObj);
					blnFlag = false;
				}

				// Forward_TO

				if(cnf.FnExplicitWait("XPATH", mbo.ForwardOnLine_Forward_TOLabel,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify \'Forward To\' Label is displayed "," \'Forward To\' Label is displayed ", "PASS",runManagerInfoObj);
					blnFlag = true;

				} else {
					repfn.FnUpdateTestStepResHTML("Verify \'Forward To\' Label is displayed "," \'Forward To\' Label is not displayed ", "FAIL",runManagerInfoObj);
					blnFlag = true;
				}

			}

			catch (Exception e)
			{
				repfn.FnUpdateTestStepResHTML("Verify Forward If and Forward To Label are displayed "," Forward If and Forward To Label are not displayed due to some exception ","FAIL",runManagerInfoObj);
				System.err.println("Message : " + e.getMessage());
				System.err.println("Cause : " + e.getCause());
				blnFlag = false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
	 public synchronized boolean Fn_RecevingLabelLabelCheck(WebDriver driver,RunManagerInfo runManagerInfoObj) {
			try {
				// Receiving Number label
				if(cnf.FnExplicitWait("XPATH", mbo.ForwardOnLine_ReceivingNoLabel,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify \'Receiving Number\' Label is displayed "," \'Receiving Number\' Label is displayed", "PASS",runManagerInfoObj);
					blnFlag = true;

				} else {
					repfn.FnUpdateTestStepResHTML("Verify \'Receiving Number\' Label is displayed "," \'Receiving Number\' Label is not displayed", "FAIL",runManagerInfoObj);
					blnFlag = false;
				}
			}

			catch (Exception e)

			{
				repfn.FnUpdateTestStepResHTML("Verify \'Receiving Number\' Label is displayed "," \'Receiving Number\' Label is not  displayed due to some exception ","FAIL",runManagerInfoObj);
				System.err.println("Message : " + e.getMessage());
				System.err.println("Cause : " + e.getCause());
				blnFlag = false;

			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
	 public synchronized boolean Fn_StatusLabelCheck(WebDriver driver,RunManagerInfo runManagerInfoObj) {
			try {
				// Sttus Label
				if(cnf.FnExplicitWait("XPATH", mbo.ForwardOnLine_StatusLine,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify \'Status\' Label is displayed ","\'Status\' Label is displayed", "PASS",runManagerInfoObj);
					blnFlag = true;
				} else {
					repfn.FnUpdateTestStepResHTML("Verify \'Status\' Label is displayed ","\'Status\' Label is not displayed", "FAIL",runManagerInfoObj);
					blnFlag = false;
				}
			}

			catch (Exception e)
			{
				repfn.FnUpdateTestStepResHTML("Verify \'Status\' Label is displayed "," \'Status\' Label is not  displayed due to some exception ","FAIL",runManagerInfoObj);
				blnFlag = false;
				System.err.println("Message : " + e.getMessage());
				System.err.println("Cause : " + e.getCause());

			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
	 public synchronized boolean Fn_VoicemailGreetingsClick(WebDriver driver,RunManagerInfo runManagerInfoObj) {
			boolean blnFlag=false;
			try 
			{
				if(cnf.FnExplicitWait("XPATH", mbo.VoiceSettingsMenu_VMGreetings,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify Set Voicemail Greeting Option is displayed", "Set Voicemail Greeting Option is displayed", "PASS",runManagerInfoObj);
					WebElement VoiceSettingsMenu_VMGreetings=driver.findElement(By.xpath(mbo.VoiceSettingsMenu_VMGreetings));
					if(cnf.ElementClick1(VoiceSettingsMenu_VMGreetings))
					{
						Thread.sleep(5000);
						repfn.FnUpdateTestStepResHTML("Verify Set Voicemail Greeting Option is clicked", "Set Voicemail Greeting Option is clicked", "PASS",runManagerInfoObj);
						blnFlag = true;					
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify Set Voicemail Greeting Option is clicked", "Set Voicemail Greeting Option is not clicked", "FAIL",runManagerInfoObj);
						blnFlag = false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify Set Voicemail Greeting Option is displayed", "Set Voicemail Greeting Option is not displayed", "FAIL",runManagerInfoObj);
					blnFlag = false;
				}
			} catch (Exception e) {
				blnFlag = false;
				repfn.FnUpdateTestStepResHTML("Verify the presence of Voicemail Greeting option ","Voicemail Greeting option is not present due to some exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}

			//GURLEEN  //VMGREETINGS UI-TITLE
		public synchronized boolean Fn_VoicemailGreetingsTitle(WebDriver driver,RunManagerInfo runManagerInfoObj) {
			boolean blnFlag=false;
			try {
				if(cnf.FnExplicitWait("XPATH", mbo.VoiceSettingsMenu_VMGreetings_title,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify Title is displayed", "Title is displayed", "PASS",runManagerInfoObj);
					WebElement VoiceSettingsMenu_VMGreetings=driver.findElement(By.xpath(mbo.VoiceSettingsMenu_VMGreetings_title));

					if("Select Greeting:".equalsIgnoreCase(VoiceSettingsMenu_VMGreetings.getText()))
					{
						repfn.FnUpdateTestStepResHTML("Verify title displayed is \'Select Greeting\'", "Title displayed is  "+VoiceSettingsMenu_VMGreetings.getText(), "PASS",runManagerInfoObj);
						blnFlag = true;					
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify title displayed is \'Select Greeting\'", "Title displayed is not \'Select Greeting\'", "FAIL",runManagerInfoObj);
						blnFlag = false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify Title is displayed", "Title is not displayed", "FAIL",runManagerInfoObj);
					blnFlag = false;
				}
			} catch (Exception e) {
				blnFlag = false;
				repfn.FnUpdateTestStepResHTML("Verify the presence of Voicemail Greeting Title ","Voicemail Greeting Title is not present due to some exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}


			//GURLEEN  //VMGREETINGS UI-PLAY BUTTON
		public synchronized boolean Fn_VoicemailGreetingsPlay(WebDriver driver,RunManagerInfo runManagerInfoObj) {
			boolean blnFlag=false;
			try {
				if(cnf.FnExplicitWait("XPATH", mbo.VoiceSettingsMenu_VMGreetings_play,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify Play button is displayed", "Play button is displayed", "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify Play button is displayed", "Play button is not displayed", "FAIL",runManagerInfoObj);
					blnFlag = false;
				}
			} catch (Exception e) {
				blnFlag = false;
				repfn.FnUpdateTestStepResHTML("Verify the presence of play button","Play button is not present due to some exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
			

		//GURLEEN  //VMGREETINGS UI-CLOSE BUTTON
		public synchronized boolean Fn_VoicemailGreetingsClose(WebDriver driver,RunManagerInfo runManagerInfoObj) {
			boolean blnFlag=false;
			try {
				if(cnf.FnExplicitWait("XPATH", mbo.VoiceSettingsMenu_VMGreetings_close,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify Close button is displayed", "Close button is displayed", "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify Close button is displayed", "Close button is not displayed", "FAIL",runManagerInfoObj);
					blnFlag = false;
				}
			} catch (Exception e) {
				blnFlag = false;
				repfn.FnUpdateTestStepResHTML( "Verify the presence of Close button", "Close button is not present due to some exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}

			//GURLEEN  //VMGREETINGS UI-SAVE BUTTON
		public synchronized boolean Fn_VoicemailGreetingsSave(WebDriver driver,RunManagerInfo runManagerInfoObj) {
			boolean blnFlag=false;
			try {
				if(cnf.FnExplicitWait("XPATH", mbo.VoiceSettingsMenu_VMGreetings_save,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify Save button is displayed", "Save button is displayed", "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify Save button is displayed", "Save button is not displayed", "FAIL",runManagerInfoObj);
					blnFlag = false;
				}
			} catch (Exception e) {
				blnFlag = false;
				repfn.FnUpdateTestStepResHTML( "Verify the presence of Save button", "Save button is not present due to some exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
			
			//GURLEEN 
			//CHECKING THE DROPDOWN AND ITS OPTIONS AVAILABLE
			
		public synchronized boolean Fn_VoicemailGreetingsDropdown(WebDriver driver,RunManagerInfo runManagerInfoObj) {
			boolean blnFlag=false;
			try {
				if(cnf.FnExplicitWait("XPATH", mbo.VoiceSettingsMenu_VMGreetings_GreetingsList,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify dropdown to Select Greetings is displayed", "Dropdown to Select Greetings is displayed", "PASS",runManagerInfoObj);
					WebElement VMGreetings=driver.findElement(By.xpath(mbo.VoiceSettingsMenu_VMGreetings_GreetingsList));
					if(cnf.JSClick(VMGreetings,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify dropdown to Select Greetings is clicked", "Dropdown to Select Greetings is clicked", "PASS",runManagerInfoObj);
						List<WebElement> VMGreetingsList=driver.findElements(By.xpath(mbo.VoiceSettingsMenu_VMGreetings_GreetingsList1));
						int size=VMGreetingsList.size();
						List<String> GreetingsList=new ArrayList<String>();
						GreetingsList.add("Personal Greeting");
						GreetingsList.add("Extended Absence");
						GreetingsList.add("Group");
						GreetingsList.add("System Greeting with Name");
						GreetingsList.add("System Greeting with Number");
						GreetingsList.add("System Greeting");
						int count=0;
						if(size>0)
						{
							for(int i=0;i<size;i++)
							{
								if(GreetingsList.get(i).equalsIgnoreCase(VMGreetingsList.get(i).getText()))
									count++;	
							}
							if(count==6){
								repfn.FnUpdateTestStepResHTML("Verify 6 Greeting choices are displayed in Select Greetings dropdown", "6 Greeting choices are displayed in Select Greetings dropdown", "PASS",runManagerInfoObj);
								blnFlag = true;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify 6 Greeting choices are displayed in Select Greetings dropdown", "6 Greeting choices are not displayed in Select Greetings dropdown", "FAIL",runManagerInfoObj);
								blnFlag = false;
							}
						}
						else
						{
							repfn.FnUpdateTestStepResHTML("Verify 6 Greeting choices are displayed in Select Greetings dropdown", "6 Greeting choices are not displayed in Select Greetings dropdown", "FAIL",runManagerInfoObj);
							blnFlag = false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify dropdown to Select Greetings is clicked", "Dropdown to Select Greetings is not clicked", "FAIL",runManagerInfoObj);
						blnFlag = false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify dropdown to Select Greetings is displayed", "Dropdown to Select Greetings is not displayed", "FAIL",runManagerInfoObj);
					blnFlag = false;
				}
			} catch (Exception e) {
				repfn.FnUpdateTestStepResHTML("Verify 6 Greeting choices are displayed in Select Greetings dropdown", "6 Greeting choices are not displayed in Select Greetings dropdown due to some exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : " + e.getMessage());
				System.err.println("Cause : " + e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		public synchronized boolean fnVoiceSettingsCallForwardingUI(WebDriver driver,RunManagerInfo runManagerInfoObj)
		{
			try
			{
				if(cnf.FnExplicitWait("XPATH", mbo.VoiceSettingsMenu_FwdAllCalls,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify \"Forward All Calls\" option is displayed", "\"Forward All Calls\" option is displayed", "PASS",runManagerInfoObj);
					WebElement forwordAllCall=driver.findElement(By.xpath(mbo.VoiceSettingsMenu_FwdAllCalls));
					if(cnf.FnExplicitWait("XPATH", mbo.ForwardOnStatus,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify if \"Forward All Calls\" status is \"On\"", "\"Forward All Calls\" status is \"On\"", "PASS",runManagerInfoObj);
						if(cnf.ElementClick1(forwordAllCall)){
							repfn.FnUpdateTestStepResHTML("Verify if User has clicked \"Forward All Calls\" option", "User has clicked \"Forward All Calls\" option", "PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("XPATH", mbo.callForwardingToggle,driver))
							{						
								repfn.FnUpdateTestStepResHTML("Verify if User is able to see \"Call Forwarding\" toggle", "User is able to see \"Call Forwarding\" toggle", "PASS",runManagerInfoObj);
								WebElement callForwardingToggle=driver.findElement(By.xpath(mbo.callForwardingToggle));
								if(cnf.JSClick(callForwardingToggle,driver))
								{
									repfn.FnUpdateTestStepResHTML("Verify if User has clicked the \"Call Forwarding\" toggle", "User has clicked the \"Call Forwarding\" toggle", "PASS",runManagerInfoObj);
									if(cnf.FnExplicitWait("XPATH", mbo.saveButtonInVoice,driver))
									{
										WebElement saveButton=driver.findElement(By.xpath(mbo.saveButtonInVoice));
										if(saveButton.isEnabled()){
											repfn.FnUpdateTestStepResHTML("Verify if User is able to see enabled Save button", "User is able to see enabled Save button", "PASS",runManagerInfoObj);
											if(cnf.JSClick(saveButton,driver))
											{
												repfn.FnUpdateTestStepResHTML("Verify if User has clicked the Save button", "User has clicked the Save button", "PASS",runManagerInfoObj);
												if(cnf.FnExplicitWait("XPATH", mbo.closeButtonInVoice,driver))
												{
													repfn.FnUpdateTestStepResHTML("Verify if User is able to see Close button", "User is able to see Close button", "PASS",runManagerInfoObj);
													WebElement closeButton=driver.findElement(By.xpath(mbo.closeButtonInVoice));
													if(cnf.JSClick(closeButton,driver))
													{
														repfn.FnUpdateTestStepResHTML("Verify if User has clicked Close button", "User has clicked Close button", "PASS",runManagerInfoObj);
														blnFlag=true;
													}
													else{
														repfn.FnUpdateTestStepResHTML("Verify if User has clicked Close button", "User has not clicked Close button", "FAIL",runManagerInfoObj);
														blnFlag=false;
													}
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify if User is able to see Close button", "User is not able to see Close button", "FAIL",runManagerInfoObj);
													blnFlag=false;
												}
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify if User has clicked the Save button", "User has not clicked the Save button", "FAIL",runManagerInfoObj);
												blnFlag=false;
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify if User is able to see enabled Save button", "User is not able to see enabled Save button", "FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify if User is able to see Save button", "User is not able to see Save button", "FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify if User has clicked the \"Call Forwarding\" toggle", "User has not clicked the \"Call Forwarding\" toggle", "FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify if User is able to see \"Call Forwarding\" toggle", "User is not able to see \"Call Forwarding\" toggle", "FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify if User has clicked \"Forward All Calls\" option", "User has not clicked \"Forward All Calls\" option", "FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						if(cnf.FnExplicitWait("XPATH", mbo.ForwardOffStatus,driver))
						{
							repfn.FnUpdateTestStepResHTML("Verify if \"Forward All Calls\" status is \"Off\"", "\"Forward All Calls\" status is \"Off\"", "PASS",runManagerInfoObj);
							if(cnf.ElementClick1(forwordAllCall)){
								repfn.FnUpdateTestStepResHTML("Verify if User has clicked \"Forward All Calls\" option", "User has clicked \"Forward All Calls\" option", "PASS",runManagerInfoObj);
								if(cnf.FnExplicitWait("XPATH", mbo.callForwardingToggle,driver))
								{						
									repfn.FnUpdateTestStepResHTML("Verify if User is able to see \"Call Forwarding\" toggle", "User is able to see \"Call Forwarding\" toggle", "PASS",runManagerInfoObj);
									WebElement callForwardingToggle=driver.findElement(By.xpath(mbo.callForwardingToggle));
									if(cnf.JSClick(callForwardingToggle,driver))
									{
										repfn.FnUpdateTestStepResHTML("Verify if User has clicked the \"Call Forwarding\" toggle", "User has clicked the \"Call Forwarding\" toggle", "PASS",runManagerInfoObj);

										if(cnf.FnExplicitWait("XPATH", mbo.cancelButtonInVoice,driver))
										{
											repfn.FnUpdateTestStepResHTML("Verify if Cancel button is present", "Cancel button is present", "PASS",runManagerInfoObj);
											blnFlag=true;
										}
										else
										{
											blnFlag=false;
											repfn.FnUpdateTestStepResHTML("Verify if Cancel button is present", "Cancel button is not present", "FAIL",runManagerInfoObj);
										}

										if(cnf.FnExplicitWait("XPATH", mbo.forwardingMethodToggle,driver))
										{
											blnFlag=true;
											repfn.FnUpdateTestStepResHTML("Verify if Forwarding method toggle is present", "Forwarding method toggle is present", "PASS",runManagerInfoObj);
										}
										else
										{
											blnFlag=false;
											repfn.FnUpdateTestStepResHTML("Verify if Forwarding method toggle is present", "Forwarding method toggle is not present", "FAIL",runManagerInfoObj);
										}

										if(cnf.FnExplicitWait("XPATH", mbo.forwardAllCallsTo,driver))
										{
											blnFlag=true;
											repfn.FnUpdateTestStepResHTML("Verify if Forward all calls dropdown is present", "Forward all calls dropdown is present", "PASS",runManagerInfoObj);
										}
										else
										{
											blnFlag=false;
											repfn.FnUpdateTestStepResHTML("Verify if Forward all calls dropdown is present", "Forward all calls dropdown is not present", "FAIL",runManagerInfoObj);
										}

										if(cnf.FnExplicitWait("XPATH", mbo.manageForwardingLines,driver))
										{
											blnFlag=true;
											repfn.FnUpdateTestStepResHTML("Verify if Manage forwarding lines button is present", "Manage forwarding lines button is present", "PASS",runManagerInfoObj);
										}
										else
										{
											blnFlag=false;
											repfn.FnUpdateTestStepResHTML("Verify if Manage forwarding lines button is present", "Manage forwarding lines button is not present", "FAIL",runManagerInfoObj);
										}

										if(cnf.FnExplicitWait("XPATH", mbo.saveButtonInVoice,driver))
										{
											repfn.FnUpdateTestStepResHTML("Verify if Save button is present", "Save button is present", "PASS",runManagerInfoObj);
											WebElement saveButton=driver.findElement(By.xpath(mbo.saveButtonInVoice));
											if(cnf.JSClick(saveButton,driver))
											{
												Thread.sleep(5000);
												blnFlag=true;
												repfn.FnUpdateTestStepResHTML("Verify if User has clicked the save button", "User has clicked the save button", "PASS",runManagerInfoObj);
											}
											else
											{
												blnFlag=false;
												repfn.FnUpdateTestStepResHTML("Verify if User has clicked the save button", "User has not clicked the save button", "FAIL",runManagerInfoObj);
											}
										}
										else
										{
											blnFlag=false;
											repfn.FnUpdateTestStepResHTML("Verify if Save button is present", "Save button is not present", "FAIL",runManagerInfoObj);
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify if User has clicked the \"Call Forwarding\" toggle", "User has not clicked the \"Call Forwarding\" toggle", "FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify if User is able to see \"Call Forwarding\" toggle", "User is not able to see \"Call Forwarding\" toggle", "FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify if User has clicked \"Forward All Calls\" option", "User has not clicked \"Forward All Calls\" option", "FAIL",runManagerInfoObj);
								blnFlag=false;
							}

						}
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \"Forward All Calls\" option is displayed", "\"Forward All Calls\" option is not displayed", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			catch(Exception e)
			{
				blnFlag=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				repfn.FnUpdateTestStepResHTML("Verify User is able to verify \"Forward All Calls\" option UI", "User is not able to verify \"Forward All Calls\" option UI due to some exception", "FAIL",runManagerInfoObj);

			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		public synchronized boolean Fn_FwdingManagerScreen_UI(WebDriver driver,RunManagerInfo runManagerInfoObj)
		{
			try{
				if(cnf.FnExplicitWait("XPATH",mbo.FwdingMgr_InternalLines_Column,driver))
				{
					List<WebElement> Columns=driver.findElements(By.xpath(mbo.FwdingMgr_InternalLines_Column));
					for(int u=0;u<Columns.size();u++)
					{
						repfn.FnUpdateTestStepResHTML("Verify Columns displayed on Forwarding Manager page","Column displayed on Forwarding Manager page:"+" "+Columns.get(u).getText(),"PASS",runManagerInfoObj);
					}
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify Columns displayed on Forwarding Manager page","Column are not displayed on Forwarding Manager page","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				if(cnf.FnExplicitWait("XPATH",mbo.FwdingMgr_InternalLines,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify whether \'Forward to Internal Lines\' section is displayed","\'Forward to Internal Lines\' section is displayed ","PASS",runManagerInfoObj);

					if(cnf.FnExplicitWait("XPATH",mbo.FwdingMgr_InternalLines_Val,driver))
					{
						List<WebElement> Val=driver.findElements(By.xpath(mbo.FwdingMgr_InternalLines_Val));
						for(int d=0;d<Val.size();d++)
						{
							repfn.FnUpdateTestStepResHTML("Verify whether \'Forward to Internal Lines\' number is displayed","\'Forward to Internal Lines\' number is displayed:"+" "+Val.get(d).getText(),"PASS",runManagerInfoObj);
							blnFlag=true;
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify whether \'Forward to Internal Lines\' number is displayed","\'Forward to Internal Lines\' number is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify whether \'Forward to Internal Lines\' section is displayed","\'Forward to Internal Lines\' section is not displayed ","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				//External Lines
				if(cnf.FnExplicitWait("XPATH",mbo.FwdingMgr_ExternalLines,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify whether \'Forward to External Lines\' section is displayed","\'Forward to External Lines\' section is displayed ","PASS",runManagerInfoObj);

					if(cnf.FnExplicitWait("XPATH",mbo.FwdingMgr_ExternalLines_Val,driver))
					{
						List<WebElement> Val=driver.findElements(By.xpath(mbo.FwdingMgr_ExternalLines_Val));
						for(int d=0;d<Val.size();d++)
						{
							repfn.FnUpdateTestStepResHTML("Verify whether \'Forward to External Lines\' number is displayed","\'Forward to External Lines\' number is displayed:"+" "+Val.get(d).getText(),"PASS",runManagerInfoObj);
							blnFlag=true;
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify whether \'Forward to External Lines\' section is displayed","\'Forward to External Lines\' section is not displayed ","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify whether \'Forward to External Lines\' section is displayed","\'Forward to External Lines\' section is not displayed ","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}

			catch(Exception e)
			{
				repfn.FnUpdateTestStepResHTML("Verify whether User is able to verify Forwarding Lines on Forwarding manager screen","User is not able to verify Forwarding Lines on Forwarding manager screen due to some exception","FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}

		public synchronized boolean FN_NavigateFwdAllCalls(WebDriver driver,RunManagerInfo runManagerInfoObj){
			try{

				if(cnf.FnExplicitWait("XPATH",mbo.VoiceSettingsMenu_FwdAllCalls,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of \'Forward All Calls\' option in Voice Settings menu ", "\'Forward All Calls\' option is present in Voice Settings menu","PASS",runManagerInfoObj);

					//	WebElement FwdallCall=driver.findElement(By.xpath(mbo.FwdAllCalls));
					if(cnf.ElementClick1(driver.findElement(By.xpath(mbo.VoiceSettingsMenu_FwdAllCalls))))
					{
						repfn.FnUpdateTestStepResHTML("Verify the \'Forward All Calls\' option is clicked ", "\'Forward All Calls\' option is clicked","PASS",runManagerInfoObj);

						if(cnf.isElementExistOne("XPATH", mbo.FwdAllCallsMenu,driver))		
						{
							repfn.FnUpdateTestStepResHTML("Verify the \'Forward All Calls\' menu is displayed ", "\'Forward All Calls\' menu is displayed","PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else
						{
							repfn.FnUpdateTestStepResHTML("Verify the \'Forward All Calls\' menu is displayed ", "\'Forward All Calls\' menu is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the \'Forward All Calls\' option is clicked ", "\'Forward All Calls\' option is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify the presence of \'Forward All Calls\' option in Voice Settings menu ", "\'Forward All Calls\' option is not present in Voice Settings menu","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

			}
			catch(Exception e)
			{
				blnFlag	=false;
				repfn.FnUpdateTestStepResHTML("Verify the presence of \'Forward All Calls\' option in Voice Settings menu ", "\'Forward All Calls\' option in Voice Settings menu is not present due to some exception","FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		public synchronized boolean FN_FwdAllCalls_Menus(WebDriver driver,RunManagerInfo runManagerInfoObj){
			try{
				
				if(cnf.FnExplicitWait("XPATH", mbo.ForwardStatusONToggle,driver)){
					if(cnf.FnExplicitWait("XPATH", mbo.FwdAllCallsMenu_Close,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Close button in Forward All Calls menu", "Close button in Forward All Calls menu is present","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Close button in Forward All Calls menu", "Close button in Forward All Calls menu is not present","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					if(cnf.FnExplicitWait("XPATH", mbo.FwdAllCallsMenu_Save,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Save button in Forward All Calls menu", "Save button in Forward All Calls menu is present","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Save button in Forward All Calls menu", "Save button in Forward All Calls menu is not present","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					if(cnf.FnExplicitWait("XPATH", mbo.FwdAllCallsMenu_CallFwding,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of \'Call forwarding\' section/text in Forward All Calls menu", "\'Call forwarding\' section/text in Forward All Calls menu is present","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of \'Call forwarding\' section/text in Forward All Calls menu", "\'Call forwarding\' section/text in Forward All Calls menu is not present","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					if(cnf.FnExplicitWait("XPATH", mbo.FwdAllCallsMenu_CallFwding_ToggleBtn,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Call forwarding toggle button in Forward All Calls menu", "Call forwarding toggle button in Forward All Calls menu is present","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Call forwarding toggle button in Forward All Calls menu", "Call forwarding toggle button in Forward All Calls menu is not present","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					if(cnf.FnExplicitWait("XPATH", mbo.FwdAllCallsMenu_FwdMethod,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Forwarding method text in Forward All Calls menu", "Forwarding method text in Forward All Calls menu is present","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of forwarding method text in Forward All Calls menu", "Forwarding method text in Forward All Calls menu is not present","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					if(cnf.FnExplicitWait("XPATH", mbo.FwdAllCallsMenu_FwdMethod_ToggleBtn,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Forwarding method toggle button in Forward All Calls menu", "Forwarding method toggle button in Forward All Calls menu is present","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Forwarding method toggle button in Forward All Calls menu", "Forwarding method toggle button in Forward All Calls menu is not present","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					if(cnf.FnExplicitWait("XPATH", mbo.FwdAllCallsMenu_FwdAllCallsTo,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of \'Forward All Calls To\' section/text in Forward All Calls menu", "\'Forward All Calls To\' section/text in Forward All Calls menu is present","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of \'Forward All Calls To\' section/text in Forward All Calls menu", "\'Forward All Calls To\' section/text in Forward All Calls menu is not present","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					if(cnf.FnExplicitWait("XPATH", mbo.FwdAllCallsMenu_FwdAllCallsTo_Dropdown,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of \'Forward All Calls To\' dropdown in Forward All Calls menu", "\'Forward All Calls To\' dropdown in Forward All Calls menu is present","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of \'Forward All Calls To\' dropdown in Forward All Calls menu", "\'Forward All Calls To\' dropdown in Forward All Calls menu is not present","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					if(cnf.FnExplicitWait("XPATH", mbo.FwdAllCallsMenu_ManageFwdingLines,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Manage forwarding lines button in Forward All Calls menu", "Manage forwarding lines button in Forward All Calls menu is present","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Manage forwarding lines button in Forward All Calls menu", "Manage forwarding lines button in Forward All Calls menu is not present","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					if(cnf.FnExplicitWait("XPATH", mbo.FwdAllCallsMenu_CallFwding_ToggleBtn,driver)){
						WebElement FwdAllCallsMenu_CallFwding_ToggleBtn=driver.findElement(By.xpath(mbo.FwdAllCallsMenu_CallFwding_ToggleBtn));
						if(cnf.JSClick(FwdAllCallsMenu_CallFwding_ToggleBtn,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Call forwarding toggle button is clicked", "Call forwarding toggle button is clicked","PASS",runManagerInfoObj);

							if(cnf.FnExplicitWait("XPATH", mbo.FwdAllCallsMenu_Close,driver))
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of Close button in Forward All Calls menu", "Close button in Forward All Calls menu is present","PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of Close button in Forward All Calls menu", "Close button in Forward All Calls menu is not present","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
							
							if(cnf.FnExplicitWait("XPATH", mbo.FwdAllCallsMenu_Save,driver))
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of Save button in Forward All Calls menu", "Save button in Forward All Calls menu is present","PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of Save button in Forward All Calls menu", "Save button in Forward All Calls menu is not present","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
							
							if(cnf.FnExplicitWait("XPATH", mbo.FwdAllCallsMenu_CallFwding,driver))
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of \'Call forwarding\' section/text in Forward All Calls menu", "\'Call forwarding\' section/text in Forward All Calls menu is present","PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of \'Call forwarding\' section/text in Forward All Calls menu", "\'Call forwarding\' section/text in Forward All Calls menu is not present","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
							
							if(cnf.FnExplicitWait("XPATH", mbo.FwdAllCallsMenu_CallFwding_ToggleBtn,driver))
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of Call forwarding toggle button in Forward All Calls menu", "Call forwarding toggle button in Forward All Calls menu is present","PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of Call forwarding toggle button in Forward All Calls menu", "Call forwarding toggle button in Forward All Calls menu is not present","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
							
							if(cnf.FnExplicitWait("XPATH", mbo.FwdAllCallsMenu_FwdMethod,driver))
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of Forwarding method text in Forward All Calls menu", "Forwarding method text in Forward All Calls menu is present","PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of forwarding method text in Forward All Calls menu", "Forwarding method text in Forward All Calls menu is not present","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
							
							if(cnf.FnExplicitWait("XPATH", mbo.FwdAllCallsMenu_FwdMethod_ToggleBtn,driver))
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of Forwarding method toggle button in Forward All Calls menu", "Forwarding method toggle button in Forward All Calls menu is present","PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of Forwarding method toggle button in Forward All Calls menu", "Forwarding method toggle button in Forward All Calls menu is not present","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
							
							if(cnf.FnExplicitWait("XPATH", mbo.FwdAllCallsMenu_FwdAllCallsTo,driver))
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of \'Forward All Calls To\' section/text in Forward All Calls menu", "\'Forward All Calls To\' section/text in Forward All Calls menu is present","PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of \'Forward All Calls To\' section/text in Forward All Calls menu", "\'Forward All Calls To\' section/text in Forward All Calls menu is not present","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
							
							if(cnf.FnExplicitWait("XPATH", mbo.FwdAllCallsMenu_FwdAllCallsTo_Dropdown,driver))
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of \'Forward All Calls To\' dropdown in Forward All Calls menu", "\'Forward All Calls To\' dropdown in Forward All Calls menu is present","PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of \'Forward All Calls To\' dropdown in Forward All Calls menu", "\'Forward All Calls To\' dropdown in Forward All Calls menu is not present","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
							
							if(cnf.FnExplicitWait("XPATH", mbo.FwdAllCallsMenu_ManageFwdingLines,driver))
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of Manage forwarding lines button in Forward All Calls menu", "Manage forwarding lines button in Forward All Calls menu is present","PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of Manage forwarding lines button in Forward All Calls menu", "Manage forwarding lines button in Forward All Calls menu is not present","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Call forwarding toggle button is clicked", "Call forwarding toggle button is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Call forwarding toggle button is displayed", "Call forwarding toggle button is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}

			}
			catch(Exception e)
			{
				blnFlag	=false;
				repfn.FnUpdateTestStepResHTML("Verify User is able to verify UI of the Call forwarding settings under Voice settings", "User is not able to verify UI of the Call forwarding settings under Voice settings due to some exception","FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		public synchronized boolean FN_ManageFwdLine_PopUp(WebDriver driver,RunManagerInfo runManagerInfoObj){
			try{


				if(cnf.FnExplicitWait("XPATH", mbo.FwdAllCallsMenu_ManageFwdingLines,driver))
				{
					if(cnf.JSClick(driver.findElement(By.xpath(mbo.FwdAllCallsMenu_ManageFwdingLines)),driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the Manage Forwarding Lines button is clicked", "Manage Forwarding lines button is clicked","PASS",runManagerInfoObj);

						if(cnf.FnExplicitWait("XPATH",mbo.ManageFwdLines_Popup,driver))
						{
							repfn.FnUpdateTestStepResHTML("Verify the Manage Forwarding Lines pop up is displayed", "Manage Forwarding Lines button pop up is displayed","PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else
						{
							repfn.FnUpdateTestStepResHTML("Verify the Manage Forwarding Lines pop up is displayed", "Manage Forwarding lines button pop up is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the Manage Forwarding Lines button is clicked", "Manage Forwarding lines button is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Manage Forwarding Lines button in Forward All Calls option", "Manage Forwarding lines button in Forward All Calls option is present","PASS",runManagerInfoObj);
					blnFlag=false;
				}
			}
			catch(Exception e)
			{
				blnFlag	=false;
				repfn.FnUpdateTestStepResHTML("Verify the presence of Manage Forwarding Lines button in forward all calls option ", "Manage Forwarding lines button in Forward all calls option is not present due to some exception","FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}

		//Jhansi Dec 7,2015
		//Manage fwd line pop up options
		public synchronized boolean FN_ManageFwdLine_PopUp_Options(WebDriver driver,RunManagerInfo runManagerInfoObj){
			try{
				
				if(cnf.FnExplicitWait("XPATH",mbo.ManageFwdLines_hdr,driver))
				{	
					repfn.FnUpdateTestStepResHTML("Verify the Manage Forwarding lines pop up is displayed with header", "Manage Forwarding lines button pop up is displayed with header"+" "+driver.findElement(By.xpath(mbo.ManageFwdLines_hdr)).getText(),"PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the Manage Forwarding lines pop up is displayed with header", "Manage Forwarding lines button pop up is displayed without header","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH",mbo.ManageFwdLines_AddNumTxt,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the \'Add Phone Number\' text is present near \'Add line\' button in Manage Forwarding lines pop up", "\'Add Phone Number\' text is present near \'Add line\' button in Manage Forwarding lines pop up","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the \'Add Phone Number\' text is present near \'Add line\' button in Manage Forwarding lines pop up", "\'Add Phone Number\' text is not present near \'Add line\' button in Manage Forwarding lines pop up","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH",mbo.ManageFwdLines_AddLineBtn,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the \'Add line\' button is present in Manage Forwarding lines pop up", "\'Add line\' button is present in Manage Forwarding lines pop up","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the \'Add line\' button is present in Manage Forwarding lines pop up", "\'Add line\' button is not present in Manage Forwarding lines pop up","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH",mbo.ManageFwdLines_Alias,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the Alias header is present in Manage Forwarding lines pop up", "Alias header is present in Manage Forwarding lines pop up","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the Alias header is present in Manage Forwarding lines pop up", "Alias header is not present in Manage Forwarding lines pop up","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH",mbo.ManageFwdLines_Number,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the Number header is present in Manage Forwarding lines pop up", "Number header is present in Manage Forwarding lines pop up","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the Number header is present in Manage Forwarding lines pop up", "Number header is not present in Manage Forwarding lines pop up","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH",mbo.ManageFwdLines_AliasList,driver))
				{
					List <WebElement> alias=driver.findElements(By.xpath(mbo.ManageFwdLines_AliasList));
					repfn.FnUpdateTestStepResHTML("Verify the alias list present in Manage Forwarding lines pop up", "No. of alias list present in Manage Forwarding lines pop up are"+" "+alias.size(),"PASS",runManagerInfoObj);
					for(int j=0;j<alias.size();j++)
					{
						repfn.FnUpdateTestStepResHTML("Verify the alias list present in Manage Forwarding lines pop up are as follows", "Alias list present in Manage Forwarding lines pop up is"+" "+alias.get(j).getText(),"PASS",runManagerInfoObj);

					}
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the alias list present in Manage Forwarding lines pop up", "No alias list present in Manage Forwarding lines pop up ","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH",mbo.ManageFwdLines_NumberList,driver))
				{
					List <WebElement> numbers=driver.findElements(By.xpath(mbo.ManageFwdLines_NumberList));
					repfn.FnUpdateTestStepResHTML("Verify the numbers list present in Manage Forwarding lines pop up", "No. of number list present in Manage Forwarding lines pop up are"+" "+numbers.size(),"PASS",runManagerInfoObj);
					for(int i=0;i<numbers.size();i++)
					{
						repfn.FnUpdateTestStepResHTML("Verify the numbers list present in Manage Forwardinglines pop up are as follows", "Numbers list present in Manage Forwarding lines pop up is"+" "+numbers.get(i).getText(),"PASS",runManagerInfoObj);

					}
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the numbers list present in Manage Forwarding lines pop up", "No number list present in Manage Forwarding lines pop up ","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH",mbo.ManageFwdLines_RedX,driver))
				{
					List <WebElement> redx=driver.findElements(By.xpath(mbo.ManageFwdLines_RedX));
					repfn.FnUpdateTestStepResHTML("Verify the Red X present in Manage Forwarding lines pop up", "No. of Red X present in Manage Forwarding lines pop up are"+" "+redx.size(),"PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the Red X present in Manage Forwarding lines pop up", "No Red X present in Manage Forwarding lines pop up ","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH",mbo.ManageFwdLines_CancelBtn,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the Cancel button is present in Manage Forwarding lines pop up", "Cancel button is present in Manage Forwarding lines pop up","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the Cancel button is present in Manage Forwarding lines pop up", "Cancel button is not present in Manage Forwarding lines pop up","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH",mbo.ManageFwdLines_SaveBtn,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the Save button is present in Manage Forwarding lines pop up", "Save button is present in Manage Forwarding lines pop up","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the Save button is present in Manage Forwarding lines pop up", "Save button is not present in Manage Forwarding lines pop up","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH",mbo.ManageFwdLines_Close,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the close button is present in Manage Forwarding lines pop up", "Close button is present in Manage Forwarding lines pop up","PASS",runManagerInfoObj);

					if(cnf.JSClick(driver.findElement(By.xpath(mbo.ManageFwdLines_Close)),driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the close button is clicked", "Close button is clicked","PASS",runManagerInfoObj);

						if(!cnf.FnExplicitWait("XPATH", mbo.ManageFwdLines_Popup,driver))
						{
							repfn.FnUpdateTestStepResHTML("Verify if Manage Forwarding lines pop up is dismissed", "Manage forwarding lines pop up is dismissed","PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else
						{
							repfn.FnUpdateTestStepResHTML("Verify if Manage Forwarding lines pop up is dismissed", "Manage forwarding lines pop up is not dismissed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}

					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the close button is clicked", "Close button is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the close button is present in Manage Forwarding lines pop up", "Close button is not present in Manage Forwarding lines pop up","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}

			catch(Exception e)
			{
				blnFlag	=false;
				repfn.FnUpdateTestStepResHTML("Verify the Manage Forwarding lines pop up is displayed", "Manage Forwarding lines button is not displayed due to some exception","FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		 public synchronized boolean ForwardingStatus_change(WebDriver driver,RunManagerInfo runManagerInfoObj)
			{
				try
				{
					if(cnf.FnExplicitWait("XPATH", mbo.ForwardingCall_StatusOnOff,driver)) {
						WebElement Status_OnOff = driver.findElement(By.xpath(mbo.ForwardingCall_StatusOnOff));

						System.out.println("Call toggle is present");
						repfn.FnUpdateTestStepResHTML("Verify if Call Forwarding status toggle is available","Call Forwarding status Toggle is available", "PASS",runManagerInfoObj);
						Thread.sleep(3000);

						if (cnf.JSClick(Status_OnOff,driver)) {
							System.out.println("Call Status is turned off");
							repfn.FnUpdateTestStepResHTML("Verify if Call Forwarding status toggle can be changed","Call Forwarding status Toggle can be changed","PASS",runManagerInfoObj);
							blnFlag = true;
						} 
						else {
							System.out.println("Call Status could not be changed ");
							repfn.FnUpdateTestStepResHTML("Verify if Call Forwarding status toggle can be changed","Call Forwarding status Toggle cannot be changed","FAIL",runManagerInfoObj);
							blnFlag = false;
						}
					} 
					else {
						System.out.println("Call toggle is not present");
						repfn.FnUpdateTestStepResHTML("Verify if Call Forwarding status toggle is available","Call Forwarding status Toggle is not available","FAIL",runManagerInfoObj);
						blnFlag = false;
					}

				} 

				catch (Exception e) {
					repfn.FnUpdateTestStepResHTML("Verify if Call Forwarding status toggle is available and clicked ","Call Forwarding status Toggle is not available and clicked due to some exception","FAIL",runManagerInfoObj);
					blnFlag = false;
					System.err.println("Message : " + e.getMessage());
					System.err.println("Cause : " + e.getCause());
				}

				m1.put("STEPSTATUS", blnFlag);
				return blnFlag;
			}
		 public synchronized boolean ForwardCallsTo_On_Cancel(WebDriver driver,RunManagerInfo runManagerInfoObj)
		 {
		 	try
		 	{
		 		
		 		if(cnf.FnExplicitWait("XPATH", mbo.ForwardStatusOFFToggle,driver)){
		 			repfn.FnUpdateTestStepResHTML("Verify Initially Status is OFF", "Initially Status is OFF","PASS",runManagerInfoObj);
		 			boolean blnFlag1 = ForwardingStatus_change(driver,runManagerInfoObj);
		 			if(blnFlag1){
		 				boolean blnFlag2 = app.ForwardingMethod_change(driver,runManagerInfoObj);
		 				boolean blnFlag3 = app.ForwardCallsToDropdown_SelectContact(driver,runManagerInfoObj);					
		 				boolean blnFlag4 = app.FN_CancelFwdImmediate_FwdBusy(driver,runManagerInfoObj);
		 				
		 				if(blnFlag2 && blnFlag3 && blnFlag4){
		 					boolean blnFlag5 =app. FN_ForwardManager_OFFstatusCheck(driver,runManagerInfoObj);
		 					if(blnFlag5){
		 						blnFlag = true;
		 					}
		 					else{
		 						blnFlag = false;
		 					}
		 				}
		 				else{
		 					repfn.FnUpdateTestStepResHTML("Verify Call Forwarding Changes are discarded","Call Forwarding Changes are not discarded","FAIL",runManagerInfoObj);
		 					blnFlag = false;
		 				}
		 			}
		 			else{
		 				repfn.FnUpdateTestStepResHTML("Verify if Call Forwarding status toggle can be changed","Call Forwarding status Toggle cannot be changed","FAIL",runManagerInfoObj);
		 				blnFlag = false;
		 			}
		 		}
		 		
		 		else if(cnf.FnExplicitWait("XPATH", mbo.ForwardStatusONToggle,driver)){
		 			repfn.FnUpdateTestStepResHTML("Verify Initially Status is OFF", "Initially Status is OFF","PASS",runManagerInfoObj);
		 			boolean blnFlag1 = ForwardingStatus_change(driver,runManagerInfoObj);
		 			if(blnFlag1){
		 				boolean blnFlag2 = app.FN_CancelFwdImmediate_FwdBusy(driver,runManagerInfoObj);
		 				if(blnFlag2){
		 					boolean blnFlag3 =app.FN_ForwardManager_OnstatusCheck(driver,runManagerInfoObj);
		 					if(blnFlag3){
		 						blnFlag = true;
		 					}
		 					else{
		 						blnFlag = false;
		 					}
		 				}
		 				else{
		 					repfn.FnUpdateTestStepResHTML("Verify Call Forwarding Changes are discarded","Call Forwarding Changes are not discarded","FAIL",runManagerInfoObj);
		 					blnFlag = false;
		 				}
		 			}
		 			else{
		 				repfn.FnUpdateTestStepResHTML("Verify if Call Forwarding status toggle can be changed","Call Forwarding status Toggle cannot be changed","FAIL",runManagerInfoObj);
		 				blnFlag = false;
		 			}
		 		}
		 		else{
		 			repfn.FnUpdateTestStepResHTML("Verify User is able to change status of Forward Manage Calls under Voice Settings ", "User is not able to change status of Forward Manage Calls under Voice Settings ","FAIL",runManagerInfoObj);
		 			blnFlag=false;
		 		}

		 	}
		 	catch(Exception e)
		 	{
		 		repfn.FnUpdateTestStepResHTML("Verify User is able to change status of forward manager call and cancel", "User  is not able to change status of forward manager call and cancel due to some exception","FAIL",runManagerInfoObj);
		 		blnFlag=false;
		 		System.err.println("Message : "+e.getMessage());
		 		System.err.println("Cause : "+e.getCause());
		 	}
		 	m1.put("STEPSTATUS", blnFlag);
		 	return blnFlag;

		 }	 
public synchronized boolean ForwardCallsTo_Off_Cancel(WebDriver driver,RunManagerInfo runManagerInfoObj)
{
	try
	{
		
		if(cnf.FnExplicitWait("XPATH", mbo.ForwardStatusOFFToggle,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Initially Status is OFF", "Initially Status is OFF","PASS",runManagerInfoObj);
			boolean blnFlag1 = ForwardingStatus_change(driver,runManagerInfoObj);
			if(blnFlag1){
				boolean blnFlag2 = app.ForwardingMethod_change(driver,runManagerInfoObj);
				boolean blnFlag3 = app.ForwardCallsToDropdown_SelectContact(driver,runManagerInfoObj);					
				boolean blnFlag4 = app.FN_CancelFwdImmediate_FwdBusy(driver,runManagerInfoObj);
				
				if(blnFlag2 && blnFlag3 && blnFlag4){
					boolean blnFlag5 = app.FN_ForwardManager_OFFstatusCheck(driver,runManagerInfoObj);
					if(blnFlag5){
						blnFlag = true;
					}
					else{
						blnFlag = false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Call Forwarding Changes are discarded","Call Forwarding Changes are not discarded","FAIL",runManagerInfoObj);
					blnFlag = false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify if Call Forwarding status toggle can be changed","Call Forwarding status Toggle cannot be changed","FAIL",runManagerInfoObj);
				blnFlag = false;
			}
		}
		
		else if(cnf.FnExplicitWait("XPATH", mbo.ForwardStatusONToggle,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Initially Status is OFF", "Initially Status is OFF","PASS",runManagerInfoObj);
			boolean blnFlag1 = ForwardingStatus_change(driver,runManagerInfoObj);
			if(blnFlag1){
				boolean blnFlag2 = app.FN_CancelFwdImmediate_FwdBusy(driver,runManagerInfoObj);
				if(blnFlag2){
					boolean blnFlag3 = app.FN_ForwardManager_OnstatusCheck(driver,runManagerInfoObj);
					if(blnFlag3){
						blnFlag = true;
					}
					else{
						blnFlag = false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Call Forwarding Changes are discarded","Call Forwarding Changes are not discarded","FAIL",runManagerInfoObj);
					blnFlag = false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify if Call Forwarding status toggle can be changed","Call Forwarding status Toggle cannot be changed","FAIL",runManagerInfoObj);
				blnFlag = false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify User is able to change status of Forward Manage Calls under Voice Settings ", "User is not able to change status of Forward Manage Calls under Voice Settings ","FAIL",runManagerInfoObj);
			blnFlag=false;
		}

	}
	catch(Exception e)
	{
		repfn.FnUpdateTestStepResHTML("Verify User is able to change status of forward manager call and cancel", "User  is not able to change status of forward manager call and cancel due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;

}
		public synchronized boolean fnVerifyVoiceSetting(WebDriver driver,RunManagerInfo runManagerInfoObj)
		{
			try
			{
				String voiceLine=null;
				 String checkStatus=null;
				if(cnf.FnExplicitWait("XPATH", mbo.voiceSettingsButtonInVoice,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if user is able to see \"Voice Settings\" button in call logs page", "User is able to see \"Voice Settings\" button in call logs page", "PASS",runManagerInfoObj);
					blnFlag=true;
					WebElement voiceSettings=driver.findElement(By.xpath(mbo.voiceSettingsButtonInVoice));
					if(cnf.JSClick(voiceSettings,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify if  \"Voice Settings\" button is clicked", "\"Voice Settings\" button is clicked", "PASS",runManagerInfoObj);
						blnFlag=true;
						if(cnf.FnExplicitWait("XPATH", "(//div[@class='ng-binding'])[4]",driver))
						{
							repfn.FnUpdateTestStepResHTML("Verify if voice line number is displayed", "Voice line number is displayed", "PASS",runManagerInfoObj);
							blnFlag=true;
							voiceLine=driver.findElement(By.xpath("(//div[@class='ng-binding'])[4]")).getText();
							System.out.println("===check=="+voiceLine);
							if(cnf.FnExplicitWait("XPATH", mbo.CallForwardOnOff,driver))
							{
								repfn.FnUpdateTestStepResHTML("Verify if forward all calls option is displayed", "Forward all calls option is displayed", "PASS",runManagerInfoObj);
								blnFlag=true;
								checkStatus=driver.findElement(By.xpath(mbo.CallForwardOnOff)).getText();
								System.out.println("===check1=="+checkStatus);
								if(app.FnForwardingManagerClick(driver,runManagerInfoObj))
								{
									if(cnf.FnExplicitWait("XPATH", "//div[@class='col-xs-9 col-sm-4 sb-voice-line-column ng-binding ng-scope']",driver))
									{
										repfn.FnUpdateTestStepResHTML("Verify if list of forwarding lines are present", "List of forwarding lines are present", "PASS",runManagerInfoObj);
										blnFlag=true;
										List<WebElement> forwardingLines=driver.findElements(By.xpath("//div[@class='col-xs-9 col-sm-4 sb-voice-line-column ng-binding ng-scope']"));
										for(WebElement forwardingLinesManage: forwardingLines)
										{
											if(forwardingLinesManage.getText().contains(voiceLine))
											{
												repfn.FnUpdateTestStepResHTML("Verify if voice line number matches with voice line in forwarding manager", "Voice line number matches with voice line in forwarding manager", "PASS",runManagerInfoObj);
												blnFlag=true;
												if(cnf.JSClick(forwardingLinesManage,driver))
												{
													repfn.FnUpdateTestStepResHTML("Verify if voice line is clicked in forwarding manager", "Voice line is clicked in forwarding manager", "PASS",runManagerInfoObj);
													blnFlag=true;
													if(cnf.FnExplicitWait("XPATH", "//button[@ng-click='toggleState()']",driver))
													{
														repfn.FnUpdateTestStepResHTML("Verify if call forwarding toggle is present", "Call forwarding toggle is present", "PASS",runManagerInfoObj);
														blnFlag=true;
														WebElement callForwardingToggle=driver.findElement(By.xpath("//button[@ng-click='toggleState()']"));
														if(cnf.JSClick(callForwardingToggle,driver))
														{
															repfn.FnUpdateTestStepResHTML("Verify if call forwarding toggle is clicked", "Call forwarding toggle is clicked", "PASS",runManagerInfoObj);
															blnFlag=true;
															if(cnf.FnExplicitWait("XPATH", "//button[@ng-click='saveSettings()']",driver))
															{
																repfn.FnUpdateTestStepResHTML("Verify if save button is present", "Save button is present", "PASS",runManagerInfoObj);
																blnFlag=true;
																WebElement saveButton=driver.findElement(By.xpath("//button[@ng-click='saveSettings()']"));
																if(cnf.JSClick(saveButton,driver))
																{
																	repfn.FnUpdateTestStepResHTML("Verify if save button is clicked", "Save button is clicked", "PASS",runManagerInfoObj);
																	blnFlag=true;
																	if(app.FnCallLogClick(driver,runManagerInfoObj))
																	{
																		driver.navigate().refresh();
																		if(cnf.FnExplicitWait("XPATH", mbo.voiceSettingsButtonInVoice,driver))
																		{
																			repfn.FnUpdateTestStepResHTML("Verify if user is able to see \"Voice Settings\" button in call logs page", "User is able to see \"Voice Settings\" button in call logs page", "PASS",runManagerInfoObj);
																			blnFlag=true;
																			WebElement voiceSettingsTemp=driver.findElement(By.xpath(mbo.voiceSettingsButtonInVoice));
																			if(cnf.JSClick(voiceSettingsTemp,driver))
																			{
																				Thread.sleep(5000);
																				repfn.FnUpdateTestStepResHTML("Verify if  \"Voice Settings\" button is clicked", "\"Voice Settings\" button is clicked", "PASS",runManagerInfoObj);
																				blnFlag=true;
																				if(!driver.findElement(By.xpath(mbo.CallForwardOnOff)).getText().equalsIgnoreCase(checkStatus))
																				{
																					repfn.FnUpdateTestStepResHTML("Verify if updated status in forwarding manager is reflected in voice settings", "Updated status in forwarding manager is reflected in voice settings", "PASS",runManagerInfoObj);
																					blnFlag=true;
																				}
																				else
																				{
																					repfn.FnUpdateTestStepResHTML("Verify if updated status in forwarding manager is reflected in voice settings", "Updated status in forwarding manager is not reflected in voice settings", "FAIL",runManagerInfoObj);
																					blnFlag=false;
																				}
																			}
																			else
																			{
																				repfn.FnUpdateTestStepResHTML("Verify if  \"Voice Settings\" button is clicked", "\"Voice Settings\" button is not clicked", "FAIL",runManagerInfoObj);
																				blnFlag=false;
																			}
																		}
																		else
																		{
																			repfn.FnUpdateTestStepResHTML("Verify if user is able to see \"Voice Settings\" button in call logs page", "User is not able to see \"Voice Settings\" button in call logs page", "FAIL",runManagerInfoObj);
																			blnFlag=true;
																		}
																	}
																}
																else
																{
																	repfn.FnUpdateTestStepResHTML("Verify if save button is clicked", "Save button is not clicked", "FAIL",runManagerInfoObj);
																	blnFlag=false;
																}
															}
															else
															{
																repfn.FnUpdateTestStepResHTML("Verify if save button is present", "Save button is not present", "FAIL",runManagerInfoObj);
																blnFlag=false;
															}
														}
														else
														{
															repfn.FnUpdateTestStepResHTML("Verify if call forwarding toggle is clicked", "Call forwarding toggle is clicked", "FAIL",runManagerInfoObj);
															blnFlag=false;
														}
														
													}
													else
													{
														repfn.FnUpdateTestStepResHTML("Verify if call forwarding toggle is present", "Call forwarding toggle is not present", "FAIL",runManagerInfoObj);
														blnFlag=false;
													}
												}
												else
												{
													repfn.FnUpdateTestStepResHTML("Verify if voice line is clicked in forwarding manager", "Voice line is not clicked in forwarding manager", "FAIL",runManagerInfoObj);
													blnFlag=false;
												}
											}
											
										}
									}
									else
									{
										repfn.FnUpdateTestStepResHTML("Verify if list of forwarding lines are present", "List of forwarding lines are not present", "FAIL",runManagerInfoObj);
										blnFlag=false;
									
									}
								}
								else
								{
									
								}
							}
							else
							{

								repfn.FnUpdateTestStepResHTML("Verify if forward all calls option is displayed", "Forward all calls option is not displayed", "FAIL",runManagerInfoObj);
								blnFlag=false;
								
							}
						}
						else
						{

							repfn.FnUpdateTestStepResHTML("Verify if voice line number is displayed", "Voice line number is not displayed", "FAIL",runManagerInfoObj);
							blnFlag=false;
						}
						
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify if  \"Voice Settings\" button is clicked", "\"Voice Settings\" button is not clicked", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify if user is able to see \"Voice Settings\" button in call logs page", "User is not able to see \"Voice Settings\" button in call logs page", "FAIL",runManagerInfoObj);
					blnFlag=true;
				}
			}
			catch(Exception e)
			{
				blnFlag=false;
		           System.err.println("Message : "+e.getMessage());
		           System.err.println("Cause : "+e.getCause());
			}
			 m1.put("STEPSTATUS", blnFlag);
			    return blnFlag;
		}
		
		public synchronized boolean FN_FwdAllCalls_CallFwding_NumbersDisplay(WebDriver driver,RunManagerInfo runManagerInfoObj){
			String callFwdingState="";
			try{
				if(cnf.FnExplicitWait("XPATH",mbo.FwdAllCallsMenu_CallFwding,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of \'Call forwarding\' section/text in Forward All Calls menu", "\'Call forwarding\' section/text in Forward All Calls menu is present","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of \'Call forwarding\' section/text in Forward All Calls menu", "\'Call forwarding\' section/text in Forward All Calls menu is not present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				if(cnf.FnExplicitWait("XPATH",mbo.FwdAllCallsMenu_CallFwding_ToggleBtn,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Call Forwarding toggle button in forward all calls menu", "Call Forwarding toggle button in forward all calls menu is present","PASS",runManagerInfoObj);

					callFwdingState=driver.findElement(By.xpath(mbo.FwdAllCallsMenu_CallFwding_ToggleBtn)).getAttribute("aria-checked");
					if(callFwdingState.equalsIgnoreCase("true"))
					{
						repfn.FnUpdateTestStepResHTML("Verify the Call forwarding toggle button is ON/OFF", "Call forwarding toggle button is ON","PASS",runManagerInfoObj);

						if(cnf.FnExplicitWait("XPATH",mbo.FwdAllCallsMenu_FwdAllCallsTo,driver))
						{
							repfn.FnUpdateTestStepResHTML("Verify the presence of \'Forward All Calls To\' section/txt in Forward All Calls menu", "\'Forward All Calls To\' section/txt in Forward All Calls menu is present","PASS",runManagerInfoObj);

							if(cnf.FnExplicitWait("XPATH",mbo.FwdAllCallsMenu_FwdAllCallsTo_Dropdown,driver))
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of \'Forward All Calls To\' dropdown in Forward All Calls menu", "\'Forward All Calls To\' dropdown in Forward All Calls menu is present","PASS",runManagerInfoObj);
								repfn.FnUpdateTestStepResHTML("Verify the default Call forwarding number in \'Forward All Calls To\' dropdown", "Default call forwarding number in \'Forward All Calls To\' dropdown is "+" "+driver.findElement(By.xpath(mbo.FwdAllCallsMenu_FwdAllCallsTo_Dropdown)).getText(),"PASS",runManagerInfoObj);

								if(cnf.JSClick(driver.findElement(By.xpath(mbo.FwdAllCallsMenu_FwdAllCallsTo_Dropdown)),driver))
								{
									repfn.FnUpdateTestStepResHTML("Verify the \'Forward All Calls To\' dropdown is clicked", "\'Forward All Calls To\' dropdown is clicked","PASS",runManagerInfoObj);

									if(cnf.FnExplicitWait("XPATH", mbo.FwdAllCallsDropdown_List,driver))
									{
										List <WebElement> dropdownList=driver.findElements(By.xpath(mbo.FwdAllCallsDropdown_List));
										repfn.FnUpdateTestStepResHTML("Verify the \'Forward All Calls To\' dropdown list is displayed", "\'Forward All Calls To\' dropdown list is displayed with size"+" "+dropdownList.size(),"PASS",runManagerInfoObj);

										for(int x=0;x<dropdownList.size();x++)
										{
											repfn.FnUpdateTestStepResHTML("Verify the \'Forward All Calls To\' dropdown list contains the forwarding number", "\'Forward All Calls To\' dropdown list contains the forwarding number"+" "+dropdownList.get(x).getText(),"PASS",runManagerInfoObj);

										}
										blnFlag=true;
									}
									else
									{
										repfn.FnUpdateTestStepResHTML("Verify the \'Forward All Calls To\' dropdown list is displayed", "\'Forward All Calls To\' dropdown list is not displayed","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else
								{
									repfn.FnUpdateTestStepResHTML("Verify the \'Forward All Calls To\' dropdown is clicked", "\'Forward All Calls To\' dropdown is not clicked","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of \'Forward All Calls To\' dropdown in Forward All Calls menu", "\'Forward All Calls To\' dropdown in Forward All Calls menu is not present","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else
						{
							repfn.FnUpdateTestStepResHTML("Verify the presence of \'Forward All Calls To\' section/txt in Forward All Calls menu", "\'Forward All Calls To\' section/txt in Forward All Calls menu is not present","FAIL",runManagerInfoObj);
							blnFlag=false;
						}

					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the Call forwarding toggle button is turned ON/OFF", "Call forwarding toggle button is turned OFF","PASS",runManagerInfoObj);
						if(cnf.JSClick(driver.findElement(By.xpath(mbo.FwdAllCallsMenu_CallFwding_ToggleBtn)),driver))
						{
							repfn.FnUpdateTestStepResHTML("Verify the Call forwarding toggle button is clicked", "Call forwarding toggle button is clicked","PASS",runManagerInfoObj);

							callFwdingState=driver.findElement(By.xpath(mbo.FwdAllCallsMenu_CallFwding_ToggleBtn)).getAttribute("aria-checked");
							if(callFwdingState.equalsIgnoreCase("true"))
							{
								repfn.FnUpdateTestStepResHTML("Verify the Call forwarding toggle button is ON/OFF", "Call forwarding toggle button is ON","PASS",runManagerInfoObj);

								if(cnf.FnExplicitWait("XPATH",mbo.FwdAllCallsMenu_FwdAllCallsTo,driver))
								{
									repfn.FnUpdateTestStepResHTML("Verify the presence of \'Forward All Calls To\' section/txt in Forward All Calls menu", "\'Forward All Calls To\' section/txt in Forward All Calls menu is present","PASS",runManagerInfoObj);

									if(cnf.FnExplicitWait("XPATH",mbo.FwdAllCallsMenu_FwdAllCallsTo_Dropdown,driver))
									{
										repfn.FnUpdateTestStepResHTML("Verify the presence of \'Forward All Calls To\' dropdown in Forward All Calls menu", "\'Forward All Calls To\' dropdown in Forward All Calls menu is present","PASS",runManagerInfoObj);
										repfn.FnUpdateTestStepResHTML("Verify the default Call forwarding number in \'Forward All Calls To\' dropdown", "Default call forwarding number in \'Forward All Calls To\' dropdown is "+" "+driver.findElement(By.xpath(mbo.FwdAllCallsMenu_FwdAllCallsTo_Dropdown)).getText(),"PASS",runManagerInfoObj);

										if(cnf.JSClick(driver.findElement(By.xpath(mbo.FwdAllCallsMenu_FwdAllCallsTo_Dropdown)),driver))
										{
											repfn.FnUpdateTestStepResHTML("Verify the \'Forward All Calls To\' dropdown is clicked", "\'Forward All Calls To\' dropdown is clicked","PASS",runManagerInfoObj);

											if(cnf.FnExplicitWait("XPATH", mbo.FwdAllCallsDropdown_List,driver))
											{
												List <WebElement> dropdownList=driver.findElements(By.xpath(mbo.FwdAllCallsDropdown_List));
												repfn.FnUpdateTestStepResHTML("Verify the \'Forward All Calls To\' dropdown list is displayed", "\'Forward All Calls To\' dropdown list is displayed with size"+" "+dropdownList.size(),"PASS",runManagerInfoObj);

												for(int x=0;x<dropdownList.size();x++)
												{
													repfn.FnUpdateTestStepResHTML("Verify the \'Forward All Calls To\' dropdown list contains the forwarding number", "\'Forward All Calls To\' dropdown list contains the forwarding number"+" "+dropdownList.get(x).getText(),"PASS",runManagerInfoObj);

												}
												blnFlag=true;
											}
											else
											{
												repfn.FnUpdateTestStepResHTML("Verify the \'Forward All Calls To\' dropdown list is displayed", "\'Forward All Calls To\' dropdown list is not displayed","FAIL",runManagerInfoObj);
												blnFlag=false;
											}
										}
										else
										{
											repfn.FnUpdateTestStepResHTML("Verify the \'Forward All Calls To\' dropdown is clicked", "\'Forward All Calls To\' dropdown is not clicked","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else
									{
										repfn.FnUpdateTestStepResHTML("Verify the presence of \'Forward All Calls To\' dropdown in Forward All Calls menu", "\'Forward All Calls To\' dropdown in Forward All Calls menu is not present","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else
								{
									repfn.FnUpdateTestStepResHTML("Verify the presence of \'Forward All Calls To\' section/txt in Forward All Calls menu", "\'Forward All Calls To\' section/txt in Forward All Calls menu is not present","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify the Call forwarding toggle button is ON/OFF", "Call forwarding toggle button is OFF","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}	
						else
						{
							repfn.FnUpdateTestStepResHTML("Verify the Call forwarding toggle button is turned ON/OFF", "Call forwarding toggle button is not turned ON","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Call forwarding toggle button in forward all calls menu", "Call forwarding toggle button in forward all calls menu is not present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			catch(Exception e)
			{
				blnFlag	=false;
				repfn.FnUpdateTestStepResHTML("Verify User is able to see the list of previously used phone lines on switching on call forwarding", 
						"User is not able to see the list of previously used phone lines on switching on call forwarding due to some exception","FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		public synchronized boolean Fn_FwdAllCallsOption1(WebDriver driver,RunManagerInfo runManagerInfoObj){
			try{

				if(cnf.FnExplicitWait("XPATH", mbo.VoiceSettingsMenu_FwdAllCalls,driver)){
					repfn.FnUpdateTestStepResHTML("Verify the presence of \'Forward All Calls\' options in Voice Settings menu ", "\'Forward All Calls\' options in Voice Settings menu is present","PASS",runManagerInfoObj);
					WebElement FwdAllCallsOption=driver.findElement(By.xpath(mbo.VoiceSettingsMenu_FwdAllCalls));
					Thread.sleep(3000);
					if(cnf.ElementClick1(FwdAllCallsOption)){
						repfn.FnUpdateTestStepResHTML("Verify the click on \'Forward All Calls\' options in Voice Settings menu ", "\'Forward All Calls\' options in Voice Settings menu is clicked","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify the click on \'Forward All Calls\' options in Voice Settings menu ", "\'Forward All Calls\' options in Voice Settings menu is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify the presence of \'Forward All Calls\' options in Voice Settings menu ", "\'Forward All Calls\' options in Voice Settings menu is not present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}			
					//cnf.FnExplicitWait("XPATH",  mbo.FwdAllCalls_Menu);
			}
			catch(Exception e)
			{
				repfn.FnUpdateTestStepResHTML("Verify the presence of \'Forward All Calls\' options in Voice Setting menu is clicked or not ", "\'Forward All Calls\' options in Voice Setting menu is not present and not clicked due to some exception","FAIL",runManagerInfoObj);
				blnFlag=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
}
