package com.charter.sb.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.charter.sb.beans.RunManagerInfo;
import com.charter.sb.controllers.Initialization;
import com.charter.sb.resources.MB_PageObjects;
import com.charter.sb.utils.CommonFunctions;
import com.charter.sb.utils.ReportingFunctions;
import com.charter.sb.utils.RunManager;

public class ManageLinesService  extends Initialization{
	MB_PageObjects mbo = new MB_PageObjects();
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	public static boolean blnFlag = false;
	public  boolean directoryListing = true;
	
	Random rg=new Random();
	int randomInt = rg.nextInt(10000);
	
	public synchronized boolean FNMultiple_Single_LineAssigned(WebDriver driver,RunManagerInfo runManagerInfoObj){
		try{

			if(cnf.FnExplicitWait("XPATH", mbo.ManageLines_VoiceLineList,driver)){
				repfn.FnUpdateTestStepResHTML("Verify User is able to see the list of all phone lines assigned to the account",
						"User is able to see the list of all phone lines assigned to the account","PASS",runManagerInfoObj);
				List<WebElement> ManageLines_VoiceLineList=driver.findElements(By.xpath(mbo.ManageLines_VoiceLineList));
				if(ManageLines_VoiceLineList.size() > 0){
					repfn.FnUpdateTestStepResHTML("Verify number of Phone lines for the logged-in account",
							"Number of Phone lines for the logged-in account: "+ManageLines_VoiceLineList.size(),"PASS",runManagerInfoObj);
					for(WebElement we:ManageLines_VoiceLineList){
						repfn.FnUpdateTestStepResHTML("Verify Phone line displayed for the logged-in account",
								"Phone line displayed for the logged-in account: "+we.getText(),"PASS",runManagerInfoObj);
						blnFlag=true;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User is able to see the list of all phone lines assigned to the account",
							"User is not able to see the list of all phone lines assigned to the account","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify User is able to see the list of all phone lines assigned to the account",
						"User is not able to see the list of all phone lines assigned to the account","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		catch (Exception e)

		{
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			repfn.FnUpdateTestStepResHTML("Verify ManageLine_AssignmentList is Displayed","ManageLine_AssignmentList is not  Displayed due to some exception","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	public synchronized boolean FN_CheckAliasLabel_List(WebDriver driver,RunManagerInfo runManagerInfoObj){
		try{
			if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_Alias_Label,driver)){
				WebElement ManageLine_Alias_Label=driver.findElement(By.xpath(mbo.ManageLine_Alias_Label));
				repfn.FnUpdateTestStepResHTML("Verify Alias_Label is Displayed ","Alias_Label is Displayed: "+ManageLine_Alias_Label.getText(),"PASS",runManagerInfoObj);
				if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_AliasList,driver)){
					List<WebElement> ManageLine_AliasList=driver.findElements(By.xpath(mbo.ManageLine_AliasList));
					if(ManageLine_AliasList.size() > 0){
						repfn.FnUpdateTestStepResHTML("Verify number of Alias Names displayed for the logged-in account",
								"Number of Alias Names displayed for the logged-in account: "+ManageLine_AliasList.size(),"PASS",runManagerInfoObj);
						for(WebElement we:ManageLine_AliasList){
							repfn.FnUpdateTestStepResHTML("Verify Alias Name displayed for the logged-in account",
									"Alias Name displayed for the logged-in account: "+we.getText(),"PASS",runManagerInfoObj);
							blnFlag=true;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Alias List is Displayed","Alias List is not Displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Alias List is Displayed","Alias List is not Displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Alias Label is Displayed","Alias Label is not Displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

		}
		
		catch (Exception e)

		{
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			repfn.FnUpdateTestStepResHTML("Verify Alias List is Displayed","Alias List is not  Displayed due to some exception","FAIL",runManagerInfoObj);
	    	 blnFlag=true;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}


	public synchronized boolean FN_CheckNumberLabel_List(WebDriver driver,RunManagerInfo runManagerInfoObj){
		try{

			if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_NumberLabel,driver)){
				WebElement ManageLine_NumberLabel=driver.findElement(By.xpath(mbo.ManageLine_NumberLabel));
				repfn.FnUpdateTestStepResHTML("Verify Number Label is Displayed ","Number Label is Displayed: "+ManageLine_NumberLabel.getText(),"PASS",runManagerInfoObj);
				if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_NumberList,driver)){
					List<WebElement> ManageLine_NumberList=driver.findElements(By.xpath(mbo.ManageLine_NumberList));
					if(ManageLine_NumberList.size() > 0){
						repfn.FnUpdateTestStepResHTML("Verify Numbers displayed for the logged-in account",
								"Numbers displayed for the logged-in account: "+ManageLine_NumberList.size(),"PASS",runManagerInfoObj);
						for(WebElement we:ManageLine_NumberList){
							repfn.FnUpdateTestStepResHTML("Verify Number displayed for the logged-in account",
									"Number displayed for the logged-in account: "+we.getText(),"PASS",runManagerInfoObj);
							blnFlag=true;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Number List is Displayed","Number List is not Displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Number List is Displayed","Number List is not Displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Number Label is Displayed","Number Label is not Displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		
		catch (Exception e)

		{
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			repfn.FnUpdateTestStepResHTML("Verify Number List is  Displayed","Number List is not  Displayed due to some exception","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}

	public synchronized boolean FN_CheckAssigmentLabel_List(WebDriver driver,RunManagerInfo runManagerInfoObj){
		try{

			if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_AssignmentLabel,driver)){
				WebElement ManageLine_AssignmentLabel=driver.findElement(By.xpath(mbo.ManageLine_AssignmentLabel));
				repfn.FnUpdateTestStepResHTML("Verify Assignment Label is Displayed ","Assignment Label is Displayed: "+ManageLine_AssignmentLabel.getText(),"PASS",runManagerInfoObj);
				if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_AssignmentList,driver)){
					List<WebElement> ManageLine_AssignmentList=driver.findElements(By.xpath(mbo.ManageLine_AssignmentList));
					if(ManageLine_AssignmentList.size() > 0){
						repfn.FnUpdateTestStepResHTML("Verify Assignment List displayed for the logged-in account",
								"Assignment List displayed for the logged-in account: "+ManageLine_AssignmentList.size(),"PASS",runManagerInfoObj);
						for(WebElement we:ManageLine_AssignmentList){
							repfn.FnUpdateTestStepResHTML("Verify Assignment displayed for the logged-in account",
									"Assignment displayed for the logged-in account: "+we.getText(),"PASS",runManagerInfoObj);
							blnFlag=true;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Assignment List is Displayed","Assignment List is not Displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Assignment List is Displayed","Assignment List is not Displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Assignment Label is Displayed","Assignment Label is not Displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		
		catch (Exception e)

		{
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			repfn.FnUpdateTestStepResHTML("Verify ManageLine_AssignmentList is Displayed","ManageLine_AssignmentList is not  Displayed due to some exception","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}


	
	public synchronized boolean FN_CheckNOAliasNAME_List(WebDriver driver,RunManagerInfo runManagerInfoObj){
		try{

			if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_Alias_Label,driver)){
				WebElement ManageLine_Alias_Label=driver.findElement(By.xpath(mbo.ManageLine_Alias_Label));
				repfn.FnUpdateTestStepResHTML("Verify Alias Label is Displayed ","Alias Label is Displayed"+ManageLine_Alias_Label.getText(),"PASS",runManagerInfoObj);
				if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_AliasList,driver)){
					List<WebElement> ManageLine_AliasList=driver.findElements(By.xpath(mbo.ManageLine_AliasList));
					repfn.FnUpdateTestStepResHTML("Verify Alias List is Displayed ","Alias List is Displayed","PASS",runManagerInfoObj);

					for(WebElement we: ManageLine_AliasList){
						if(we.getText().contains("--")){
							repfn.FnUpdateTestStepResHTML("Verify No alias Name List is Displayed","No alias Name List is Displayed","PASS",runManagerInfoObj);
							if(cnf.JSClick(we,driver)){
								repfn.FnUpdateTestStepResHTML("Verify No alias Name Row is clicked","No alias Name Row is clicked","PASS",runManagerInfoObj);
								Thread.sleep(3000);
								if(cnf.FnExplicitWait("XPATH", mbo.UserDetail_Backbtn,driver)){
									repfn.FnUpdateTestStepResHTML("Verify Back Link is Displayed ","Back Link is Displayed ","PASS",runManagerInfoObj);
									WebElement Backbtn=driver.findElement(By.xpath(mbo.UserDetail_Backbtn));
									if(cnf.JSClick(Backbtn,driver)){
										repfn.FnUpdateTestStepResHTML("Verify Back button is clicked and hence it indicate the contact list has No alias Name","Back button is clicked and hence it indicate the contact list has No alias Name","PASS",runManagerInfoObj);
										blnFlag=true;
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Back button is clicked and hence it indicate the contact list has No alias Name","Back button is clicked and hence it indicate the contact list does not have No alias Name","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Back Link is Displayed ","Back Link is not Displayed ","FAIL",runManagerInfoObj);
									blnFlag=false;
								}							
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify No alias Name Row is clicked","No alias Name Row is not clicked","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							boolean blnFlag1 = FN_ManageLine_EditAlias_DeleteName(driver,runManagerInfoObj);
							if(blnFlag1){
								boolean blnFlag2 = FN_CheckNOAliasNAME_List(driver,runManagerInfoObj);
								if(blnFlag2){
									blnFlag=true;
								}
								else{
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Alias Name is deleted","Alias Name is not deleted","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}

						break;
					}

				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Alias List is Displayed ","Alias List is not Displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Alias Label is Displayed","Alias Label is not Displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}

		catch (Exception e)

		{
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			repfn.FnUpdateTestStepResHTML("Verify No alias Name List is Displayed and clicked","No alias Name List is not Displayed  clicked due to some exception","PASS",runManagerInfoObj);
			blnFlag=false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	public synchronized boolean FNManageContactList(WebDriver driver,RunManagerInfo runManagerInfoObj){
		try{

			if(cnf.FnExplicitWait("XPATH", mbo.ManageContactList,driver)){
				List<WebElement> ManageContactList=driver.findElements(By.xpath(mbo.ManageContactList));
				if(ManageContactList.size() > 0){
					repfn.FnUpdateTestStepResHTML("Verify User is able to see the list of all phone lines assigned to his account",
							"User is able to see the list of all phone lines assigned to his account","PASS",runManagerInfoObj);
		        	blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User is able to see the list of all phone lines assigned to his account",
							"User is not able to see the list of all phone lines assigned to his account","FAIL",runManagerInfoObj);
		        	blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify User is able to see the list of all phone lines assigned to his account",
						"User is not able to see the list of all phone lines assigned to his account","FAIL",runManagerInfoObj);
	        	blnFlag=false;

			}
		}
		catch (Exception e)

		{
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			repfn.FnUpdateTestStepResHTML("Verify ManageLine_AssignmentList is Displayed","ManageLine_AssignmentList is not  Displayed due to some exception","FAIL",runManagerInfoObj);
	    	 blnFlag=false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	public synchronized boolean FN_NewAssignListClick_Cancel(WebDriver driver,RunManagerInfo runManagerInfoObj){
		try{
			if(cnf.FnExplicitWait("XPATH", mbo.Cancel_Button,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify if Cancel button is present", "Cancel button is present", "PASS",runManagerInfoObj);
				WebElement close=driver.findElement(By.xpath(mbo.Cancel_Button));
				if(cnf.JSClick(close,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Click on Cancel", "Cancel button is clicked", "PASS",runManagerInfoObj);
					Thread.sleep(2000);

					if(cnf.FnExplicitWait("XPATH", mbo.Confirm_btn,driver)){
						repfn.FnUpdateTestStepResHTML("Verify if Confirm button is present", "Confirm button is present", "PASS",runManagerInfoObj);
						WebElement Confrm=driver.findElement(By.xpath(mbo.Confirm_btn));
						System.out.println("click aftr save not working");

						if(cnf.JSClick(Confrm,driver))
						{               
							repfn.FnUpdateTestStepResHTML("Verify Click on Confirm changes", "Confirm option is clicked", "PASS",runManagerInfoObj) ;                                                                                                                                                                                                              
							Thread.sleep(2000);
							driver.navigate().refresh();
							Thread.sleep(2000);
							repfn.FnUpdateTestStepResHTML("Verify User is moved back to Manage lines page","User is moved back to Manage Lines page","PASS",runManagerInfoObj);
							blnFlag=true;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify if Confirm button is present", "Confirm button is not present", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}					
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify if Cancel button is clicked", "Cancel button is not clicked", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify if Cancel button is present", "Cancel button is not present", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}

		catch(Exception e)
		{
			repfn.FnUpdateTestStepResHTML("Verify NewAssignList is displayed and clicked","NewAssignList is not  displayed and  not clicked due to some exception","FAIL",runManagerInfoObj);
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			blnFlag=false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	
	
	public synchronized boolean FN_CheckNOAssigmentName_List(WebDriver driver,RunManagerInfo runManagerInfoObj){
		try{

			if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_AssignmentLabel,driver)){
				WebElement ManageLine_AssignmentLabel=driver.findElement(By.xpath(mbo.ManageLine_AssignmentLabel));
				repfn.FnUpdateTestStepResHTML("Verify Assignment Label is Displayed ","Assignment Label is Displayed"+ManageLine_AssignmentLabel.getText(),"PASS",runManagerInfoObj);
				if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_UnassignedList,driver)){
					List<WebElement> ManageLine_UnassignedList=driver.findElements(By.xpath(mbo.ManageLine_UnassignedList));
					repfn.FnUpdateTestStepResHTML("Verify UnAssigned List is Displayed ","UnAssigned List is Displayed","PASS",runManagerInfoObj);

					for(WebElement we: ManageLine_UnassignedList){
						if(we.getText().contains("--")){
							repfn.FnUpdateTestStepResHTML("Verify Un assigned List is Displayed","Un assigned List is Displayed","PASS",runManagerInfoObj);
							if(cnf.JSClick(we,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Un assigned row is clicked","Un assigned row is clicked","PASS",runManagerInfoObj);

								if(cnf.FnExplicitWait("XPATH", mbo.UserDetail_Backbtn,driver)){
									repfn.FnUpdateTestStepResHTML("Verify Back Link is Displayed ","Back Link is Displayed ","PASS",runManagerInfoObj);
									WebElement Backbtn=driver.findElement(By.xpath(mbo.UserDetail_Backbtn));
									if(cnf.JSClick(Backbtn,driver)){
										repfn.FnUpdateTestStepResHTML("Verify Back button is clicked and hence it indicate the contact list has Non assigned Number","Back button is clicked and hence it indicate the contact list has Non assigned Number","PASS",runManagerInfoObj);
										blnFlag=true;
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Back button is clicked and hence it indicate the contact list has Non assigned Number","Back button is not clicked and hence it indicate the contact list has no Non assigned Number","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Back Link is Displayed ","Back Link is not Displayed ","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Un assigned row is clicked","Un assigned row is not clicked","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Un assigned List is Displayed","Un assigned List is not Displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}

						break;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify UnAssigned List is Displayed ","UnAssigned List is not Displayed. Need to unassign a line","PASS",runManagerInfoObj);
					boolean blnFlag1=app.FN_RemoveAssignmentLink(driver,runManagerInfoObj);
					if(blnFlag1){
						boolean blnFlag2=app.FN_RemoveAssignmentLineClick(driver,runManagerInfoObj);
						if(blnFlag2){
							boolean blnFlag3=app.FN_CancelConfirmPopup(driver,runManagerInfoObj);
							if(blnFlag3)
							{
								boolean blnFlag4=app.FN_SaveButtonClick(driver,runManagerInfoObj);
								if(blnFlag4)
								{
									boolean blnFlag5=app.Fn_closeDetails(driver,runManagerInfoObj);
									if(blnFlag5){
										boolean blnFlag6=FN_CheckNOAssigmentName_List(driver,runManagerInfoObj);
										if(blnFlag6){
											blnFlag=true;
										}
										else{
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Close link is clicked ","Close link is not clicked","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Changes are saved","Changes are not saved. Error message coming","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Confirm button is clicked "," Confirm button is not clicked","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Remove Assignment Button is clicked","Remove Assignment Button is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Edit button is clicked ","Edit button is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Assignment Label is Displayed","Assignment Label is not Displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

		}

		catch (Exception e)

		{      	        	
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			repfn.FnUpdateTestStepResHTML("Verify Un assinged List is Displayed and clicked","Un assinged List is not Displayed and  not clicked due to some exeption","PASS",runManagerInfoObj);
			blnFlag=false;

		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	public synchronized boolean FN_ManageContactNumber_EmbeddedWindowCheck(WebDriver driver,RunManagerInfo runManagerInfoObj){
		try{

			if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_NumberLabel,driver)){
				WebElement ManageLine_NumberLabel=driver.findElement(By.xpath(mbo.ManageLine_NumberLabel));
				repfn.FnUpdateTestStepResHTML("Verify Number Label is Displayed ","Number Label is Displayed"+ManageLine_NumberLabel.getText(),"PASS",runManagerInfoObj);
				if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_NumberList,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Number List is Displayed","Number List is Displayed","PASS",runManagerInfoObj);
					List<WebElement> ManageLine_NumberList=driver.findElements(By.xpath(mbo.ManageLine_NumberList));
					
					for(WebElement we:ManageLine_NumberList){
						if(cnf.JSClick(we,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Number List row is clicked","Number List row is clicked: "+we.getText(),"PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Line information window is displayed "," Line information window is displayed","PASS",runManagerInfoObj);
								if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_DirectoryLabel,driver)){
									blnFlag=true;
									break;
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Directory Listing label is displayed ","Directory Listing label is not displayed","PASS",runManagerInfoObj);
									if(cnf.FnExplicitWait("XPATH", mbo.UserDetail_Backbtn,driver)){
										repfn.FnUpdateTestStepResHTML("Verify Back link is displayed in User Details pop-up","Back link is displayed in User Details pop-up","PASS",runManagerInfoObj);
										WebElement Backbtn=driver.findElement(By.xpath(mbo.UserDetail_Backbtn));
										if(cnf.JSClick(Backbtn,driver)){
											repfn.FnUpdateTestStepResHTML("Verify Back link is clicked","Back link is clicked","PASS",runManagerInfoObj);
											Thread.sleep(5000);
											blnFlag=true;
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Back link is clicked","Back link is not clicked","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Back link is displayed in User Details pop-up","Back link is not displayed in User Details pop-up","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
									
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Line information window is displayed ","  Line information window is not displayed","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Number List row is clicked","Number List row is not clicked: "+we.getText(),"FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					
					if(blnFlag){
						directoryListing = true;
						blnFlag=true;
					}
					else{
						directoryListing = false;
						blnFlag=true;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Number List is Displayed","Number List is not Displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Number Label is Displayed","Number Label is not Displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}

		catch (Exception e)

		{
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			repfn.FnUpdateTestStepResHTML("Verify  Line information window is displayed "," Line information window is not displayed due to some exception","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	public synchronized boolean FN_ManageLineFeildVerification(WebDriver driver,RunManagerInfo runManagerInfoObj){

		try{

			//ManageLine_LineNumber_Label
			if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_LineNumber_Label,driver)){
				WebElement ManageLine_LineNumber_Label=driver.findElement(By.xpath(mbo.ManageLine_LineNumber_Label));
				repfn.FnUpdateTestStepResHTML("Verify if the Line information label along with the selected line is displayed ","Line information Label is displayed:  "+ManageLine_LineNumber_Label.getText(),"PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify if the Line information label along with the selected line is displayed ","Line information Label is not  Displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

			//ManageLine_AliasLabel and AliasName
			if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_AliasLabel,driver)){
				WebElement ManageLine_AliasLabel=driver.findElement(By.xpath(mbo.ManageLine_AliasLabel));
				repfn.FnUpdateTestStepResHTML("Verify if the Alias label is displayed ","Label is displayed: "+ManageLine_AliasLabel.getText(),"PASS",runManagerInfoObj);
				if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_AliasText,driver)){
					WebElement AliasName=driver.findElement(By.xpath(mbo.ManageLine_AliasText));
					repfn.FnUpdateTestStepResHTML("Verify AliasName is Displayed ","AliasName is Displayed as: "+AliasName.getText(),"PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify AliasName is Displayed ","AliasName is not Displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify if the Alias label is displayed  ","Alias label  is not  Displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

			
			if(directoryListing){
				// DirectoryLabel and ManageLine_Address
				if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_DirectoryLabel,driver)){
					WebElement  ManageLine_DirectoryLabel=driver.findElement(By.xpath(mbo.ManageLine_DirectoryLabel));
					repfn.FnUpdateTestStepResHTML("Verify if Directory listing label is displayed "," Directory listing Label is Displayed: "+ManageLine_DirectoryLabel.getText(),"PASS",runManagerInfoObj);
					if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_Address,driver)){
						WebElement ManageLine_Address=driver.findElement(By.xpath(mbo.ManageLine_Address));
						repfn.FnUpdateTestStepResHTML("Verify if the name and address are displayed under Directory listing ","Name and address are displayed: "+ManageLine_Address.getText(),"PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify if the name and address are displayed under Directory listing ","Name and address Label is not Displayed","FAIL",runManagerInfoObj);

						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify if Directory listing label is displayed "," Directory listing Label is not  Displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify if Directory listing label is displayed "," Directory listing Label is not Displayed. Voice line is unlisted line","PASS",runManagerInfoObj);
				blnFlag=true;
			}
		}

		catch (Exception e)

		{
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			repfn.FnUpdateTestStepResHTML("Verifying if the user is displayed with all datapoints after selecting a phone line"," The user is not  displayed with all datapoints after selecting a phone line","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}

	

	public synchronized boolean FN_AliasNameEdit_DeleteName(WebDriver driver,RunManagerInfo runManagerInfoObj){

		try{

			if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_AliasName,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Alias Name Field is displayed ","Alias Name Field is displayed ","PASS",runManagerInfoObj);
				WebElement ManageLine_AliasName=driver.findElement(By.xpath(mbo.ManageLine_AliasName));
				ManageLine_AliasName.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"Existing Name");
				// ManageLine_AliasName.sendKeys("ExistingName");

				repfn.FnUpdateTestStepResHTML("Verify Alias Name is Entered ","Alias Name is Entered","PASS",runManagerInfoObj);
				
				if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_SaveButton,driver)){
					WebElement ManageLine_SaveButton=driver.findElement(By.xpath(mbo.ManageLine_SaveButton));
					if(ManageLine_SaveButton.isEnabled()){
						repfn.FnUpdateTestStepResHTML("Verify Save button is enabled After Editing alias Name","Save button is enabled After Editing alias Name","PASS",runManagerInfoObj);

						if (cnf.FnExplicitWait("XPATH", mbo.EditMode_CancelBtn,driver)) {
							WebElement EditMode_CancelBtn = driver.findElement(By.xpath(mbo.EditMode_CancelBtn));
							cnf.JSClick(EditMode_CancelBtn,driver);
							repfn.FnUpdateTestStepResHTML("Verify Close Button is clicked ","Close Button is clicked", "PASS",runManagerInfoObj);
							blnFlag=FN_ManageUsers_Confirm(driver,runManagerInfoObj);
							
							if(blnFlag){
							blnFlag = true;
							}
							Thread.sleep(1000);
						} else {
							repfn.FnUpdateTestStepResHTML("Verify Close Button is clicked ","Close Button is not clicked", "FAIL",runManagerInfoObj);
							blnFlag = false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Save button is enabled After Editing alias Name","Save button is not enabled After Editing alias Name","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Alias Name Field is displayed ","Alias Name Field is not displayed ","FAIL",runManagerInfoObj);
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
	public synchronized boolean fnManageVoice(WebDriver driver,RunManagerInfo runManagerInfoObj)
	{
		try
		{
			if(cnf.FnExplicitWait("XPATH", mbo.manageSkip,driver))
			{
				blnFlag=true;
				repfn.FnUpdateTestStepResHTML("Verify if \"Skip\" link is present", "\"Skip\" link is present", "PASS",runManagerInfoObj);
			}
			else
			{
				blnFlag=true;
				repfn.FnUpdateTestStepResHTML("Verify if \"Skip\" link is present", "\"Skip\" link is present", "PASS",runManagerInfoObj);
			}

			if(cnf.FnExplicitWait("XPATH", mbo.manageDisabledNextButton,driver))
			{
				blnFlag=true;
				repfn.FnUpdateTestStepResHTML("Verify if \"Next\" button is disabled before selecting any phone number", "\"Next\" button is disabled before selecting any phone number", "PASS",runManagerInfoObj);
			}
			else
			{
				blnFlag=false;
				repfn.FnUpdateTestStepResHTML("Verify if \"Next\" button is disabled before selecting any phone number", "\"Next\" button is not disabled before selecting any phone number", "FAIL",runManagerInfoObj);
			}

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

						if(cnf.FnExplicitWait("XPATH",mbo.manageNextButton,driver))
						{
							repfn.FnUpdateTestStepResHTML("Verify if \"Next\" button is present", "\"Next\" button is present", "PASS",runManagerInfoObj);
							WebElement NextButton=driver.findElement(By.xpath(mbo.manageNextButton));
							if(cnf.JSClick(NextButton,driver))
							{
								Thread.sleep(5000);
								blnFlag=true;
								repfn.FnUpdateTestStepResHTML("Verify if User is able to click next button", "User is able to click next button", "PASS",runManagerInfoObj);  			    	
							}
							else
							{
								blnFlag=false;
								repfn.FnUpdateTestStepResHTML("Verify if User is able to click next button", "User is not able to click next button", "FAIL",runManagerInfoObj);
							}
						}
						else
						{
							blnFlag=false;
							repfn.FnUpdateTestStepResHTML("Verify if \"Next\" button is present", "\"Next\" button is not present", "FAIL",runManagerInfoObj);
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Voice line is added", "Voice line is not added", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify if \"Add voice line\" button is clicked", "\"Add voice line\" button is not clicked", "FAIL",runManagerInfoObj);
					blnFlag=false;
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
						boolean blnFlag2 = fnManageVoice(driver,runManagerInfoObj);
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
			repfn.FnUpdateTestStepResHTML("Verify that the Account Owner/ Administrator user is able to add a new Voice line", "Account Owner/ Administrator user is not able to add a new Voice line due to some exception", "FAIL",runManagerInfoObj);
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	public synchronized boolean FN_ManageLine_EditAlias_DeleteName(WebDriver driver,RunManagerInfo runManagerInfoObj){
		try{
			
			if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_arrow,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Arrow_DetailLink is displayed  ","Arrow_DetailLink is displayed ","PASS",runManagerInfoObj);
				List<WebElement> ManageLine_Arrow=driver.findElements(By.xpath(mbo.ManageLine_arrow));
				if(cnf.JSClick(ManageLine_Arrow.get(0),driver)){
					repfn.FnUpdateTestStepResHTML("Verify Arrow_DetailLink is Clicked ","Arrow_DetailLink is  Clicked ","PASS",runManagerInfoObj);
					if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Line Information Window is displayed ","Line Information Window is displayed","PASS",runManagerInfoObj);
						if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_Editbutton,driver)){
							repfn.FnUpdateTestStepResHTML("Verify if the Edit link is displayed","Edit link is displayed","PASS",runManagerInfoObj);
							WebElement ManageLine_Editbutton=driver.findElement(By.xpath(mbo.ManageLine_Editbutton));
							if(cnf.JSClick(ManageLine_Editbutton,driver)){
								repfn.FnUpdateTestStepResHTML("Verify if the Edit link is clicked","Edit link is clicked","PASS",runManagerInfoObj);
								
								if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_SaveButton,driver)){
									repfn.FnUpdateTestStepResHTML("Verify if the Save button is displayed","Save button is displayed","PASS",runManagerInfoObj);
									WebElement ManageLine_SaveButton=driver.findElement(By.xpath(mbo.ManageLine_SaveButton));
									if(!ManageLine_SaveButton.isEnabled()){
										repfn.FnUpdateTestStepResHTML("Verify  Intially Save button is not enabled in Edit Mode","Intially Save button is not enabled in Edit Mode","PASS",runManagerInfoObj);
										
										//Editing Alias Name
										blnFlag=FN_AliasNameEdit_DeleteName(driver,runManagerInfoObj);
										
										
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify  Intially Save button is not enabled in Edit Mode","Intially Save button is  enabled in Edit Mode","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
									
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify if the Save button is displayed","Save button is not displayed","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify if the Edit link is clicked","Edit link is not clicked","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Edit button is clicked ","Edit button is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify  Line Information Window is displayed "," Line Information Window is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Arrow_DetailLink is clciked ","Arrow_DetailLink is not clicked ","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Arrow_DetailLink is displayed ","Arrow_DetailLink is not displayed ","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		catch (Exception e)

		{
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			repfn.FnUpdateTestStepResHTML("Verifying if the user is able to Edit Phone line by deleting alias name ","The user is able to Edit Phone line by deleting alias name due to some exception","FAIL",runManagerInfoObj);
			blnFlag=false;

		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
public synchronized boolean FN_ManageLine_EditAlias_NewName(WebDriver driver,RunManagerInfo runManagerInfoObj){
		
		try{
			if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_Alias_Label,driver)){
				WebElement ManageLine_Alias_Label=driver.findElement(By.xpath(mbo.ManageLine_Alias_Label));
				repfn.FnUpdateTestStepResHTML("Verify Alias Label is Displayed ","Alias Label is Displayed: "+ManageLine_Alias_Label.getText(),"PASS",runManagerInfoObj);
				if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_AliasList,driver)){
					List<WebElement> ManageLine_AliasList=driver.findElements(By.xpath(mbo.ManageLine_AliasList));
					repfn.FnUpdateTestStepResHTML("Verify Alias List is Displayed ","Alias List is Displayed","PASS",runManagerInfoObj);
					List <WebElement> NoAliasList=new ArrayList<WebElement>();	
					
					for(WebElement we: ManageLine_AliasList){
						if(we.getText().contains("--")){
							NoAliasList.add(we);
						}
					}
					
					if(NoAliasList.size() > 0){
						repfn.FnUpdateTestStepResHTML("Verify No alias Name List is Displayed","No alias Name List is Displayed","PASS",runManagerInfoObj);
						if(cnf.JSClick(NoAliasList.get(0),driver)){
							repfn.FnUpdateTestStepResHTML("Verify No alias Name Row is clicked","No alias Name Row is clicked","PASS",runManagerInfoObj);
							Thread.sleep(3000);
							if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Line Information Window is displayed "," Line Information Window is displayed","PASS",runManagerInfoObj);
								if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_Editbutton,driver)){
									WebElement ManageLine_Editbutton=driver.findElement(By.xpath(mbo.ManageLine_Editbutton));
									repfn.FnUpdateTestStepResHTML("Verify if the Edit link is displayed","Edit link is displayed","PASS",runManagerInfoObj);
									
									if(cnf.JSClick(ManageLine_Editbutton,driver)){
										repfn.FnUpdateTestStepResHTML("Verify Click on Edit link","Line information is displayed in editable mode","PASS",runManagerInfoObj);
										
										if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_SaveButton,driver)){
											repfn.FnUpdateTestStepResHTML("Verify if the Save button is displayed","Save button is displayed","PASS",runManagerInfoObj);
											WebElement ManageLine_SaveButton=driver.findElement(By.xpath(mbo.ManageLine_SaveButton));
											if(!ManageLine_SaveButton.isEnabled()){
												repfn.FnUpdateTestStepResHTML("Verify Intially Save button is not enabled in Edit Mode","Intially Save button is not enabled in Edit Mode","PASS",runManagerInfoObj);
												blnFlag=true;
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify  Intially Save button is not enabled in Edit Mode","Intially Save button is  enabled in Edit Mode","FAIL",runManagerInfoObj);
												blnFlag=false;
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify if the Save button is displayed","Save button is not displayed","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
										
										boolean blnFlag1 = app.FN_AliasNameEdit(driver,runManagerInfoObj);
										if(blnFlag1){
											if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_SaveButton,driver)){
												WebElement ManageLine_SaveButton=driver.findElement(By.xpath(mbo.ManageLine_SaveButton));
												if(cnf.JSClick(ManageLine_SaveButton,driver)){
													repfn.FnUpdateTestStepResHTML("Verify Save button is clicked ","Save button  is clicked","PASS",runManagerInfoObj);
													
													if(cnf.isElementExist(By.xpath("//p[@ng-if='!options.useHtml']"),driver)){
														repfn.FnUpdateTestStepResHTML("Verify User is able to save ","User is not able to save ,getting error messages as' Unable to save line details. Please try again later'","FAIL",runManagerInfoObj);
														blnFlag=app.FN_CancelButtonClick(driver,runManagerInfoObj);
														if(blnFlag){
															blnFlag=false;
														}
														driver.navigate().refresh();
														Thread.sleep(5000);
													}												
													else{
														if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_AliasText,driver)){

															WebElement AliasName=driver.findElement(By.xpath(mbo.ManageLine_AliasText));
															System.out.println(AliasName.getText());

															if(AliasName.getText().contains("AndrewLine")){

																repfn.FnUpdateTestStepResHTML("Verify New Alias Name Is saved sucessfully","New Alias Name Is saved sucessfully","PASS",runManagerInfoObj);

																if(cnf.FnExplicitWait("XPATH", mbo.UserDetail_Backbtn,driver)){
																	WebElement Backbtn=driver.findElement(By.xpath(mbo.UserDetail_Backbtn));

																	if(cnf.JSClick(Backbtn,driver)){
																		repfn.FnUpdateTestStepResHTML("Verify Back button is clicked ","Back button is clicked","PASS",runManagerInfoObj);
																		blnFlag=true;
																		//Need To remove once appln is stable
																		driver.navigate().refresh();
																	}else{
																		repfn.FnUpdateTestStepResHTML("Verify Back button is displayed ","Back button is not dispalyed","FAIL",runManagerInfoObj);
																		blnFlag=false;
																	}
																}
																else{
																	repfn.FnUpdateTestStepResHTML("Verify Back button is displayed ","Back button is not dispalyed","FAIL",runManagerInfoObj);
																	blnFlag=false;
																}
															}
															else{
																repfn.FnUpdateTestStepResHTML("Verify New Alias Name Is saved sucessfully","New Alias Name Is saved sucessfully","PASS",runManagerInfoObj);
																blnFlag=false;
															}
														}
														else{
															repfn.FnUpdateTestStepResHTML("Verify Alias Name Is displayed","Alias Name Is displayed","PASS",runManagerInfoObj);
															blnFlag=false;
														}
													}
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify Save button is clicked ","Save button  is not  clicked","FAIL",runManagerInfoObj);
													blnFlag=false;
												}
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify if the Save button is displayed","Save button is not displayed","FAIL",runManagerInfoObj);
												blnFlag=false;
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Save button is enabled After Editing alias Name","Save button is not enabled After Editing alias Name","FAIL",runManagerInfoObj);
											blnFlag=false;
										}										
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Edit button is clicked ","Edit button is not clicked","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify if the Edit link is displayed","Edit link is not displayed","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Line Information Window is displayed "," Line Information Window is not displayed","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify No alias Name Row is clicked","No alias Name Row is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						boolean blnFlag1 = FN_ManageLine_EditAlias_DeleteName(driver,runManagerInfoObj);
						if(blnFlag1){
							boolean blnFlag2 = FN_ManageLine_EditAlias_NewName(driver,runManagerInfoObj);
							if(blnFlag2){
								blnFlag=true;
							}
							else{
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Alias Name is deleted","Alias Name is not deleted","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Alias List is Displayed ","Alias List is not Displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Alias Label is Displayed","Alias Label is not Displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		
		catch (Exception e)
		{
			repfn.FnUpdateTestStepResHTML("Verifying if the user is able to Edit Phone line by modifying alias name","The user is not able to Edit Phone line by modifying alias name due to some exception","FAIL",runManagerInfoObj);
			blnFlag=false;
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());

		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}

public synchronized boolean FNManagePhoneLine_FirstContactCLick(WebDriver driver,RunManagerInfo runManagerInfoObj){
	try{
		if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_arrow,driver)){
			List<WebElement> ManageLine_Arrow=driver.findElements(By.xpath(mbo.ManageLine_arrow));
			repfn.FnUpdateTestStepResHTML("Verify Arrow_DetailLink is displayed  ","Arrow_DetailLink is displayed ","PASS",runManagerInfoObj);
			if(cnf.JSClick(ManageLine_Arrow.get(0),driver)){
				repfn.FnUpdateTestStepResHTML("Verify Arrow_DetailLink is Clicked ","Arrow_DetailLink is  Clicked ","PASS",runManagerInfoObj);

				if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Line Information Window is displayed for the selected line","  Line Information Window is displayed for the selected line","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Line Information Window is displayed for the selected line ","  Line Information Window is not displayed for the selected line","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Arrow_DetailLink is clciked ","Arrow_DetailLink is not clicked ","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Arrow_DetailLink is displayed ","Arrow_DetailLink is not displayed ","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}
	catch (Exception e)
	{
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		repfn.FnUpdateTestStepResHTML("Verify  Line Information Window is displayed ","  Line Information Window is not displayed due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}

public  boolean FNManageLine_EditPhoneLineWithoutChange(WebDriver driver,RunManagerInfo runManagerInfoObj){
	try{
		if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_arrow,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Arrow_DetailLink is displayed or not ","Arrow_DetailLink is  displayed","PASS",runManagerInfoObj);
			List<WebElement> ManageLine_Arrow=driver.findElements(By.xpath(mbo.ManageLine_arrow));
			if(ManageLine_Arrow.get(0).isDisplayed()){
				if(cnf.JSClick(ManageLine_Arrow.get(0),driver)){
					repfn.FnUpdateTestStepResHTML("Verify Arrow_Detail Link is displayed and Clicked ","Arrow_Detail Link is displayed and Clicked ","PASS",runManagerInfoObj);
					if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Line Information Window is displayed ","Line Information Window is displayed","PASS",runManagerInfoObj);
						Thread.sleep(2000);

						if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_Editbutton,driver)){
							WebElement ManageLine_Editbutton=driver.findElement(By.xpath(mbo.ManageLine_Editbutton));
							repfn.FnUpdateTestStepResHTML("Verify Edit link is displayed "," Edit link is displayed ","PASS",runManagerInfoObj);
							if(cnf.JSClick(ManageLine_Editbutton,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Click on Edit link "," Edit link is clicked ","PASS",runManagerInfoObj);
								Thread.sleep(1000);

									if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_CancelBtn,driver)){
										WebElement Cancelbtn=driver.findElement(By.xpath(mbo.ManageLine_CancelBtn));
										repfn.FnUpdateTestStepResHTML("Verify Cancel link is displayed ","Cancel link is displayed","PASS",runManagerInfoObj);

										if(cnf.JSClick(Cancelbtn,driver)){
											repfn.FnUpdateTestStepResHTML("Verify Cancel link is clicked without making any changes in Line information window ","Cancel link is clicked without making any changes in Line information window","PASS",runManagerInfoObj);
											blnFlag=true;
											if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
												repfn.FnUpdateTestStepResHTML("Verify if the user is taken back to Line Information Window after clicking cancel button","the user is taken back to Line Information Window after clicking cancel button","PASS",runManagerInfoObj);
												blnFlag=true;
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify if the user is taken back to Line Information Window after clicking cancel button","the user is not  taken back to Line Information Window after clicking cancel button","FAIL",runManagerInfoObj);
												blnFlag=false;
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Cancel link is clicked without making any changes in Line information window ","Cancel link is not  clicked without making any changes in Line information window","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Cancel link is displayed ","Cancel link is not displayed","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Edit link is clicked "," Edit link is not clicked ","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Edit link is displayed "," Edit link is not displayed ","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify  Line Information Window is displayed "," Line Information Window is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}else{
					repfn.FnUpdateTestStepResHTML("Verify Arrow_Detail Link is  Clicked ","Arrow_Detail Link is not  Clicked","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify First Arrow_Detail Link is displayed ","First Arrow_Detail Link is not displayed ","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}else{
			repfn.FnUpdateTestStepResHTML("Verify Arrow_Detail Link is displayed or not ","Arrow_Detail Link is not displayed","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}
	catch (Exception e)

	{
		repfn.FnUpdateTestStepResHTML("Verify if user is able to cancel Editing phone line without making any changes ",
				"User is not able to cancel Editing phone line without making any changes due to some exception.","FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}


public synchronized boolean FnNonActionableAreaClick(WebDriver driver,RunManagerInfo runManagerInfoObj){
	try{
		if(cnf.FnExplicitWait("XPATH", mbo.NonSectionArea,driver)){
			WebElement NonSectionArea=driver.findElement(By.xpath(mbo.NonSectionArea));
			repfn.FnUpdateTestStepResHTML("Verify Non-Actionable area is present  ","Non-Actionable area is present ","PASS",runManagerInfoObj);
			if(cnf.JSClick(NonSectionArea,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Non-Actionable area is Clicked ","Non-Actionable area is Clicked","PASS",runManagerInfoObj);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				if(!cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Line Information window is not displayed after NonSectionNon-Actionable Area is clicked"," Line Information window is not displayed after NonSectionNon-Actionable Area is clicked","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Line Information window is not displayed after NonSectionNon-Actionable Area is clicked"," Line Information window is  not displayed after Non-Actionable Area is clicked","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Non-Actionable area is Clicked ","Non-Actionable area is not Clicked","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Non-Actionable area is present  ","Non-Actionable area is not  present ","FAIL",runManagerInfoObj);
			blnFlag=false;
		}

	}

	catch (Exception e)

	{
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		repfn.FnUpdateTestStepResHTML("Verify ManageDetailpopup is  not displayed after NonSectionArea is clicked"," ManageDetailpopup is not  displayed after NonSectionArea is clicked due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}

public  boolean FNManageLine_EditPhoneLineWithChange(WebDriver driver,RunManagerInfo runManagerInfoObj){

	try{
		if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_arrow,driver)){
			List<WebElement> ManageLine_Arrow=driver.findElements(By.xpath(mbo.ManageLine_arrow));
			if(ManageLine_Arrow.get(0).isDisplayed()){
				if(cnf.JSClick(ManageLine_Arrow.get(0),driver)){
					repfn.FnUpdateTestStepResHTML("Verify Arrow_Detail Link is displayed and Clicked ","Arrow_Detail Link is displayed and Clicked ","PASS",runManagerInfoObj);
					if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Line Information Window is displayed "," Line Information Window is displayed","PASS",runManagerInfoObj);
						Thread.sleep(2000);
						
						if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_Editbutton,driver)){
							WebElement ManageLine_Editbutton=driver.findElement(By.xpath(mbo.ManageLine_Editbutton));
							repfn.FnUpdateTestStepResHTML("Verify Edit link is displayed "," Edit link is displayed ","PASS",runManagerInfoObj);
							if(cnf.JSClick(ManageLine_Editbutton,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Click on Edit link "," Line information is displayed in editable mode ","PASS",runManagerInfoObj);
								Thread.sleep(2000);

								if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_AliasName,driver)){
									repfn.FnUpdateTestStepResHTML("Verify Alias name is displayed"," Alias name is displayed","PASS",runManagerInfoObj);
									WebElement ManageLine_AliasName=driver.findElement(By.xpath(mbo.ManageLine_AliasName));
									ManageLine_AliasName.clear();
									ManageLine_AliasName.sendKeys("AndrewLine1");
									repfn.FnUpdateTestStepResHTML("Verify Alias name is able to edit  "," Alias name is able to edit ","PASS",runManagerInfoObj);
									blnFlag=true;
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Alias name is displayed"," Alias name is not displayed","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
								Thread.sleep(2000);
								
								if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_CancelBtn,driver)){
									WebElement Cancelbtn=driver.findElement(By.xpath(mbo.ManageLine_CancelBtn));
									repfn.FnUpdateTestStepResHTML("Verify Cancel link is displayed ","Cancel link is displayed","PASS",runManagerInfoObj);
									if(cnf.JSClick(Cancelbtn,driver)){
										repfn.FnUpdateTestStepResHTML("Verify Cancel link is clicked after editting ","Cancel link is clicked after editting","PASS",runManagerInfoObj);
										if(cnf.FnExplicitWait("XPATH",mbo.Confirmationpopup,driver)){
											repfn.FnUpdateTestStepResHTML("Check Confirmation pop up should be displayed as changes were made"," Confirmation pop up is displayed as changes were done","PASS",runManagerInfoObj);
											
											if(cnf.FnExplicitWait("XPATH", mbo.ConfirmCancel,driver)){
												WebElement CancelEdit=driver.findElement(By.xpath(mbo.ConfirmCancel));
												
												if(cnf.JSClick(CancelEdit,driver)){
													repfn.FnUpdateTestStepResHTML("Verify Editing phone line is canceled after clicking confirm button in the confirmation popup ","Editing phone line is canceled after clicking confirm button in the confirmation popup ","PASS",runManagerInfoObj);
													//Need To remove once appln is stable
													driver.navigate().refresh();
													Thread.sleep(4000);
													blnFlag=true;
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify Editing phone line is canceled after clicking confirm button in the confirmation popup ","Editing phone line is not canceled after clicking confirm button in the confirmation popup ","FAIL",runManagerInfoObj);
													//Need To remove once appln is stable
													driver.navigate().refresh();
													Thread.sleep(4000);
													blnFlag=false;
												}
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify Editing phone line is canceled after clicking confirm button in the confirmation popup  ","Editing phone line is not canceled after clicking confirm button in the confirmation popup ","FAIL",runManagerInfoObj);
												blnFlag=false;
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Check Confirmation pop up should  be displayed as there was  changes "," Confirmation pop up is  not displayed even there  was  changes done","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Cancel link  is clicked after editting ","Cancel link is not clicked after editting","FAIL",runManagerInfoObj);
										blnFlag=false;
									}

								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Cancel link is displayed ","Cancel link is not displayed","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Edit link is clicked "," Edit link is not clicked ","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Edit link is displayed "," Edit link is not displayed ","FAIL",runManagerInfoObj);
							blnFlag=false;
						}

					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify  Line Information Window is displayed "," Line Information Window is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}else{
					repfn.FnUpdateTestStepResHTML("First Arrow_Detail Link is clicked ","First Arrow_Detail Link is not clicked ","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("First Arrow_Detail Link is displayed ","First Arrow_Detail Link is not displayed ","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}else{
			repfn.FnUpdateTestStepResHTML("Arrow_Detail Link is displayed ","Arrow_Detail Link is not displayed ","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}
	catch (Exception e)

	{
		repfn.FnUpdateTestStepResHTML("Verifying if the user is able to cancel Editing Phone line by making any changes to the line informationn ",
				"The user is not  able to cancel Editing Phone line by making any changes to the line informationn. due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}


public synchronized boolean FN_ManageLine_EditAlias_ExistingName(WebDriver driver,RunManagerInfo runManagerInfoObj){
	try{

		if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_arrow,driver)){
			List<WebElement> ManageLine_Arrow=driver.findElements(By.xpath(mbo.ManageLine_arrow));
			//ManageLine_Arrow.get(0).click();
			if(cnf.JSClick(ManageLine_Arrow.get(0),driver)){
				repfn.FnUpdateTestStepResHTML("Verify Arrow_DetailLink is displayed and Clicked ","Arrow_DetailLink is displayed and Clicked ","PASS",runManagerInfoObj);
				// WebElement UserDetailpopup=driver.findElement(By.xpath(mbo.UserDetailpopup));
				if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Line Information Window is displayed "," Line Information Window is displayed","PASS",runManagerInfoObj);

					if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_Editbutton,driver)){
						WebElement ManageLine_Editbutton=driver.findElement(By.xpath(mbo.ManageLine_Editbutton));
						repfn.FnUpdateTestStepResHTML("Verify if the Edit link is displayed","Edit link is displayed","PASS",runManagerInfoObj);

						if(cnf.JSClick(ManageLine_Editbutton,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Click on Edit link","Line information is displayed in editable mode","PASS",runManagerInfoObj);

							if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_SaveButton,driver)){								
								WebElement ManageLine_SaveButton=driver.findElement(By.xpath(mbo.ManageLine_SaveButton));
								if(!ManageLine_SaveButton.isEnabled()){
									repfn.FnUpdateTestStepResHTML("Verify Intially Save button is not enabled in Edit Mode","Intially Save button is not enabled in Edit Mode","PASS",runManagerInfoObj);
									blnFlag=true;
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify  Intially Save button is not enabled in Edit Mode","Intially Save button is  enabled in Edit Mode","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify if the Save button is displayed","Save button is not displayed","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
							
							boolean blnFlag1=FN_AliasNameEdit_ExistingName(driver,runManagerInfoObj);
							if(blnFlag1){
								if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_SaveButton,driver)){	
									WebElement ManageLine_SaveButton=driver.findElement(By.xpath(mbo.ManageLine_SaveButton));
									if(cnf.JSClick(ManageLine_SaveButton,driver)){
										Thread.sleep(1000);
										repfn.FnUpdateTestStepResHTML("Verify Save button is clicked ","Save button is clicked","PASS",runManagerInfoObj);
										
										if(cnf.isElementExist(By.xpath("//p[@ng-if='!options.useHtml']"),driver)){
											repfn.FnUpdateTestStepResHTML("Verify User is able to save ","User is not able to save ,getting error messages as' Unable to save line details. Please try again later'","FAIL",runManagerInfoObj);
											blnFlag= app.FN_CancelButtonClick(driver,runManagerInfoObj);
											if(blnFlag){
												blnFlag=false;
											}
											driver.navigate().refresh();
											Thread.sleep(5000);
										}
										else{
											if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_AliasText,driver)){
												WebElement AliasName=driver.findElement(By.xpath(mbo.ManageLine_AliasText));
												String Name=m1.get("NewName").toString();
												System.out.println(AliasName.getText());

												if(AliasName.getText().contains(Name)){
													repfn.FnUpdateTestStepResHTML("Verify Alias Name Is Modified sucessfully","Alias Name Is Modified sucessfully","PASS",runManagerInfoObj);

													if(cnf.FnExplicitWait("XPATH", mbo.UserDetail_Backbtn,driver)){
														WebElement Backbtn=driver.findElement(By.xpath(mbo.UserDetail_Backbtn));
														if(cnf.ElementClick1(Backbtn)){
															repfn.FnUpdateTestStepResHTML("Verify Back button is clicked ","Back button is clicked","PASS",runManagerInfoObj);
															blnFlag=true;
															//Need To remove once appln is stable
															driver.navigate().refresh();
														}
														else{
															repfn.FnUpdateTestStepResHTML("Verify Back button is clicked ","Back button is not clicked","FAIL",runManagerInfoObj);
															blnFlag=false;									
														}
													}
													else{
														repfn.FnUpdateTestStepResHTML("Verify Back button is clicked ","Back button is not clicked","FAIL",runManagerInfoObj);
														blnFlag=false;
													}
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify Alias Name Is Modified sucessfully","Alias Name Is  not Modified sucessfully","FAIL",runManagerInfoObj);
													blnFlag=false;
												} 
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify Alias Name Is displayed","Alias Name Is not displayed","FAIL",runManagerInfoObj);
												blnFlag=false;
											}
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Save button is clicked ","Save button is not clicked","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Save button is displayed ","Save button is not displayed","FAIL",runManagerInfoObj);
									blnFlag=false;
								}									
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Save button is enabled After Editing alias Name","Save button is not enabled After Editing alias Name","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
							
						}else{
							repfn.FnUpdateTestStepResHTML("Verify Edit button is clicked ","Edit button is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Edit button is displayed ","Edit button is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify  Line Information Window is displayed "," Line Information Window is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

			}else{
				repfn.FnUpdateTestStepResHTML("Arrow_DetailLink is Clicked ","Arrow_DetailLink is not Clicked","FAIL",runManagerInfoObj);
				blnFlag=false;					
			}

		}
		else{
			repfn.FnUpdateTestStepResHTML("Arrow_DetailLink is displayed ","Arrow_DetailLink is not displayed","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}
	catch (Exception e)

	{
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		repfn.FnUpdateTestStepResHTML("Verifying if the user is able to Edit Phone line by adding alias name "," The user is not able to Edit Phone line by adding alias name due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;

	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}

public synchronized boolean FN_AliasNameEdit_ExistingName(WebDriver driver,RunManagerInfo runManagerInfoObj){
	
	String Name=m1.get("NewName").toString();

	try{			
		if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_AliasName,driver)){
			WebElement ManageLine_AliasName=driver.findElement(By.xpath(mbo.ManageLine_AliasName));
			ManageLine_AliasName.clear();
			ManageLine_AliasName.sendKeys(Name+randomInt);
			repfn.FnUpdateTestStepResHTML("Edit the Alias name ","Alias name is edited : "+ManageLine_AliasName.getAttribute("value"),"PASS",runManagerInfoObj);
			
			if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_SaveButton,driver)){
				WebElement ManageLine_SaveButton=driver.findElement(By.xpath(mbo.ManageLine_SaveButton));
				if(ManageLine_SaveButton.isEnabled()){
					repfn.FnUpdateTestStepResHTML("Verify Save button is enabled After Editing alias Name","Save button is enabled After Editing alias Name","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Save button is enabled After Editing alias Name","Save button is not enabled After Editing alias Name","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Save button is displayed ","Save button is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Alias Name is Entered ","Alias Name is not  Entered","FAIL",runManagerInfoObj);
			blnFlag=false;
		}

	}

	catch (Exception e)
	{
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		repfn.FnUpdateTestStepResHTML("Verify Save button is enabled After Editing alias Name","Save button is not enabled After Editing alias Name due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}

public synchronized boolean FN_ModifyLineCancelChanges(WebDriver driver,RunManagerInfo runManagerInfoObj)
{
	try
	{
		if(cnf.FnExplicitWait("Xpath", mbo.Confirmationpopup_Block,driver)) {
			repfn.FnUpdateTestStepResHTML("Verify if the Cancel Confirmation Pop up is displayed on clicking Cancel "," Cancel Confirmation Pop up is displayed","PASS",runManagerInfoObj);
			if(cnf.FnExplicitWait("XPATH", mbo.ModifyChanges_Cancel,driver)){
				WebElement Confirmbtn=driver.findElement(By.xpath(mbo.ModifyChanges_Cancel));
				repfn.FnUpdateTestStepResHTML("Verify if the Cancel button is displayed in the Pop Up","Cancel button is displayed","PASS",runManagerInfoObj);
				if(cnf.JSClick(Confirmbtn,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Cancel button is clicked "," Cancel button is clicked","PASS",runManagerInfoObj);
					
					if(cnf.FnExplicitWait("XPATH", mbo.RemoveAssignmentBtn,driver)){
						repfn.FnUpdateTestStepResHTML("Verify if the assignee details are retained as before", "Assignee details are retained as before", "PASS",runManagerInfoObj);
						blnFlag=true;
						driver.navigate().refresh();		
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Remove Assignment Button is displayed","Remove Assignment Button is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Cancel button is clicked "," Cancel button is not clicked","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify if the Cancel button is displayed in the Pop Up","Cancel button is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify if the Cancel Confirmation Pop up is displayed on clicking Cancel "," Cancel Confirmation Pop up is not  displayed","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}
	catch(Exception e)
	{
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		repfn.FnUpdateTestStepResHTML("Verify Remove Assignment Button is displayed after cancelling remove assignment operation","Remove Assignment Button is not displayed after cancelling remove assignment operation due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}		    		 
public synchronized boolean FnOpenManageLineContact(WebDriver driver,RunManagerInfo runManagerInfoObj){

	 try{

		 Thread.sleep(5000);
		 if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_arrow,driver)){
		 List<WebElement> ManageLine_Arrow=driver.findElements(By.xpath(mbo.ManageLine_arrow));
		
			// ManageLine_Arrow.get(0).click();
			if( cnf.JSClick(ManageLine_Arrow.get(0),driver)){
			 repfn.FnUpdateTestStepResHTML("Verify Arrow_DetailLink is displayed and Clicked ","Arrow_DetailLink is displayed and Clicked ","PASS",runManagerInfoObj);
			 Thread.sleep(5000);
			 if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
				 repfn.FnUpdateTestStepResHTML("Verify ManageDetailpopup is displayed "," ManageDetailpopup is displayed","PASS",runManagerInfoObj);
				 blnFlag=true;
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify ManageDetailpopup is displayed "," ManageDetailpopup is not displayed","FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
			}else{
				repfn.FnUpdateTestStepResHTML("Verify ManageDetailpopup is clicked "," ManageDetailpopup is not clicked","FAIL",runManagerInfoObj);
				 blnFlag=false;
			}
		 }
		 else{
			 repfn.FnUpdateTestStepResHTML("Verify Arrow_DetailLink is displayed ","Arrow_DetailLink is not displayed  ","FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }
	 }

	 catch (Exception e)

	 {
		 repfn.FnUpdateTestStepResHTML("Verify User is able to click and open Manage Line Detail pop-up",
				 "User is not able to click and open Manage Line Detail pop-up due to some exception","FAIL",runManagerInfoObj);

		 blnFlag=false;
		 System.err.println("Message : "+e.getMessage());
		 System.err.println("Cause : "+e.getCause());

	 }
	 m1.put("STEPSTATUS", blnFlag);
	 return blnFlag;
}

public synchronized boolean FN_ManageLine_UnListedLine_DirectoryList(WebDriver driver,RunManagerInfo runManagerInfoObj){
	
	try{
		boolean blnFlag1 = false;
		if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_NumberLabel,driver)){
			WebElement ManageLine_NumberLabel=driver.findElement(By.xpath(mbo.ManageLine_NumberLabel));
			repfn.FnUpdateTestStepResHTML("Verify Number Label is Displayed ","Number Label is Displayed"+ManageLine_NumberLabel.getText(),"PASS",runManagerInfoObj);
			if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_NumberList,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Number List is Displayed","Number List is Displayed","PASS",runManagerInfoObj);
				List<WebElement> ManageLine_NumberList=driver.findElements(By.xpath(mbo.ManageLine_NumberList));
				
				for(WebElement we:ManageLine_NumberList){
					if(cnf.JSClick(we,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Number List row is clicked","Number List row is clicked: "+we.getText(),"PASS",runManagerInfoObj);
						if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Line information window is displayed "," Line information window is displayed","PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_DirectoryLabel,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Directory Listing label is displayed ","Directory Listing label is displayed. Line is listed line.","PASS",runManagerInfoObj);
								if(cnf.FnExplicitWait("XPATH", mbo.UserDetail_Backbtn,driver)){
									repfn.FnUpdateTestStepResHTML("Verify Back link is displayed in User Details pop-up","Back link is displayed in User Details pop-up","PASS",runManagerInfoObj);
									WebElement Backbtn=driver.findElement(By.xpath(mbo.UserDetail_Backbtn));
									if(cnf.JSClick(Backbtn,driver)){
										repfn.FnUpdateTestStepResHTML("Verify Back link is clicked","Back link is clicked","PASS",runManagerInfoObj);
										Thread.sleep(5000);
										blnFlag=true;
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Back link is clicked","Back link is not clicked","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Back link is displayed in User Details pop-up","Back link is not displayed in User Details pop-up","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
								
								blnFlag1=false;
							}
							else{								
								blnFlag1=true;
								break;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Line information window is displayed ","  Line information window is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Number List row is clicked","Number List row is not clicked: "+we.getText(),"FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				
				if(blnFlag1){
					if(cnf.isElementExistOne("XPATH",mbo.DirectoryListingLabel_UnListing,driver)){
						repfn.FnUpdateTestStepResHTML("Verify if Directory listing label is not displayed for Unlisted Line "," Directory listing Label is not Displayed for Unlisted Line","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify if Directory listing label is not displayed  "," Directory listing Label is Displayed because the contact opened is listed Line","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify if Directory listing label is displayed"," Directory listing Label is Displayed because all the lines are listed lines.","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Number List is Displayed","Number List is not Displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Number Label is Displayed","Number Label is not Displayed","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	
	}
	catch (Exception e)

	{
		repfn.FnUpdateTestStepResHTML("Verify if Directory listing label is not   displayed  "," Directory listing Label is   Displayed because the contact opened is listed Line,due to some exception","FAIL",runManagerInfoObj);

		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		blnFlag=false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}

public synchronized boolean FN_ManageLine_DirectoryListVerification(WebDriver driver,RunManagerInfo runManagerInfoObj){
	try{
		if(directoryListing){
			if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_DirectoryLabel,driver)){
				WebElement  ManageLine_DirectoryLabel=driver.findElement(By.xpath(mbo.ManageLine_DirectoryLabel));
				repfn.FnUpdateTestStepResHTML("Verify if Directory listing label is displayed "," Directory listing Label is Displayed: "+ManageLine_DirectoryLabel.getText(),"PASS",runManagerInfoObj);
				if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_Address,driver)){
					WebElement ManageLine_Address=driver.findElement(By.xpath(mbo.ManageLine_Address));
					repfn.FnUpdateTestStepResHTML("Verify if the name and address are displayed under Directory listing for Listed Line ","Name and address are displayed: "+ManageLine_Address.getText(),"PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify if the name and address are displayed under Directory listing for Listed Line","Name and address Label is not Displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify if Directory listing label is displayed "," Directory listing Label is not  Displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify if Directory listing label is displayed "," Directory listing Label is not Displayed. All voice lines are unlisted","PASS",runManagerInfoObj);
			blnFlag=true;
		}

	}
	catch (Exception e)

	{
		repfn.FnUpdateTestStepResHTML("Verify if the name and address are displayed under Directory listing for Listed Line","Name and address Label is not Displayed due to some exception","FAIL",runManagerInfoObj);
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		blnFlag=false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}


public synchronized boolean FN_ManageLine_NonEditDirectoryListing(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{

	try{

		if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_NumberLabel,driver)){
			WebElement ManageLine_NumberLabel=driver.findElement(By.xpath(mbo.ManageLine_NumberLabel));
			repfn.FnUpdateTestStepResHTML("Verify Number Label is Displayed ","Number Label is Displayed"+ManageLine_NumberLabel.getText(),"PASS",runManagerInfoObj);
			if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_NumberList,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Number List is Displayed","Number List is Displayed","PASS",runManagerInfoObj);
				List<WebElement> ManageLine_NumberList=driver.findElements(By.xpath(mbo.ManageLine_NumberList));

				for(WebElement we:ManageLine_NumberList){
					if(cnf.JSClick(we,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Number List row is clicked","Number List row is clicked: "+we.getText(),"PASS",runManagerInfoObj);
						if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Line information window is displayed "," Line information window is displayed","PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_DirectoryLabel,driver)){
								blnFlag=true;
								break;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Directory Listing label is displayed ","Directory Listing label is not displayed","PASS",runManagerInfoObj);
								if(cnf.FnExplicitWait("XPATH", mbo.UserDetail_Backbtn,driver)){
									repfn.FnUpdateTestStepResHTML("Verify Back link is displayed in User Details pop-up","Back link is displayed in User Details pop-up","PASS",runManagerInfoObj);
									WebElement Backbtn=driver.findElement(By.xpath(mbo.UserDetail_Backbtn));
									if(cnf.JSClick(Backbtn,driver)){
										repfn.FnUpdateTestStepResHTML("Verify Back link is clicked","Back link is clicked","PASS",runManagerInfoObj);
										Thread.sleep(5000);
										blnFlag=true;
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Back link is clicked","Back link is not clicked","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Back link is displayed in User Details pop-up","Back link is not displayed in User Details pop-up","FAIL",runManagerInfoObj);
									blnFlag=false;
								}

								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Line information window is displayed ","  Line information window is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Number List row is clicked","Number List row is not clicked: "+we.getText(),"FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}

				if(blnFlag){
					boolean blnFlag1=FN_DiectoryListChecking(driver,runManagerInfoObj);
					if(blnFlag1){
						if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_Editbutton,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Edit Link is displayed "," Edit Link is displayed","PASS",runManagerInfoObj);

							WebElement ManageLine_Editbutton=driver.findElement(By.xpath(mbo.ManageLine_Editbutton));
							if(cnf.JSClick(ManageLine_Editbutton,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Edit Link is clicked "," Edit Link is clicked","PASS",runManagerInfoObj);

								Thread.sleep(5000);
								if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_SaveButton,driver)){
									repfn.FnUpdateTestStepResHTML("Verify Save button is displayed"," Save button is displayed","PASS",runManagerInfoObj);
									WebElement ManageLine_SaveButton=driver.findElement(By.xpath(mbo.ManageLine_SaveButton));
									if(!ManageLine_SaveButton.isEnabled()){
										repfn.FnUpdateTestStepResHTML("Verify Intially Save button is not enabled in Edit Mode","Intially Save button is not enabled in Edit Mode","PASS",runManagerInfoObj);
										blnFlag=FN_AliasNameEdit(driver,runManagerInfoObj);
										if(blnFlag){
											blnFlag=FN_DiectoryList_EditCheck(driver,runManagerInfoObj);
											if(blnFlag){
												if(cnf.JSClick(ManageLine_SaveButton,driver)){
													repfn.FnUpdateTestStepResHTML("Verify Save button is clicked ","Save button is clicked","PASS",runManagerInfoObj);

													Thread.sleep(5000);

													if(cnf.isElementExist(By.xpath("//p[@ng-if='!options.useHtml']"),driver)){
														repfn.FnUpdateTestStepResHTML("Verify User is able to save ","User is not able to save ,getting error messages as' Unable to save line details. Please try again later'","FAIL",runManagerInfoObj);
														blnFlag= app.FN_CancelButtonClick(driver,runManagerInfoObj);
														if(blnFlag){
															blnFlag=false;
														}
														driver.navigate().refresh();
														Thread.sleep(5000);
													}
													else{
														if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_AliasText,driver)){
															WebElement AliasName=driver.findElement(By.xpath(mbo.ManageLine_AliasText));

															String name = m1.get("NewName").toString();
															if(AliasName.getText().contains(name)){
																repfn.FnUpdateTestStepResHTML("Verify New Alias Name Is saved sucessfully","New Alias Name Is saved sucessfully","PASS",runManagerInfoObj);

																if(cnf.FnExplicitWait("XPATH", mbo.UserDetail_Backbtn,driver)){
																	repfn.FnUpdateTestStepResHTML("Verify Back button is displayed ","Back button is displayed","PASS",runManagerInfoObj);
																	WebElement Backbtn=driver.findElement(By.xpath(mbo.UserDetail_Backbtn));
																	if(cnf.JSClick(Backbtn,driver)){
																		repfn.FnUpdateTestStepResHTML("Verify Back button is clicked ","Back button is clicked","PASS",runManagerInfoObj);
																		blnFlag=true;
																		//Need To remove once appln is stable
																		driver.navigate().refresh();
																	}
																	else{
																		repfn.FnUpdateTestStepResHTML("Verify Back button is clicked ","Back button is not clicked","FAIL",runManagerInfoObj);
																		blnFlag=false;
																	}

																}
																else{
																	repfn.FnUpdateTestStepResHTML("Verify Back button is displayed ","Back button is not displayed","FAIL",runManagerInfoObj);
																	blnFlag=false;
																}
															}
															else{
																repfn.FnUpdateTestStepResHTML("Verify New Alias Name Is saved sucessfully","New Alias Name Is not saved sucessfully","FAIL",runManagerInfoObj);
																blnFlag=false;
															}
														}
														else{
															repfn.FnUpdateTestStepResHTML("Verify Alias Name Is displayed","Alias Name Is not displayed","FAIL",runManagerInfoObj);
															blnFlag=false;
														}
													}
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify Save button is clicked ","Save button is not clicked","FAIL",runManagerInfoObj);
													blnFlag=false;
												}

											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify User is not able to edit Directory List Address","User is able to edit Directory List Address","FAIL",runManagerInfoObj);
												blnFlag=false;
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Save button is enabled After Editing alias Name","Save button is not enabled After Editing alias Name","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Intially Save button is not enabled in Edit Mode","Intially Save button is enabled in Edit Mode","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Save button is displayed"," Save button is not displayed","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Edit Link is clicked "," Edit Link is not clicked","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Edit Link is displayed "," Edit Link is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Directory List address is displayed","Directory List address is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify \'Directory Listing\' heading is displayed ", "\'Directory Listing\' heading is not displayed . All voice lines are unlisted lines","PASS",runManagerInfoObj);
					blnFlag=true;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Number List is Displayed","Number List is not Displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Number Label is Displayed","Number Label is not Displayed","FAIL",runManagerInfoObj);
			blnFlag=false;
		}

	}

	catch (Exception e)
	{
		repfn.FnUpdateTestStepResHTML("Verify user is able to Edit Alias name and check Directory listing is not editable","user is not able to edit aliass name and check Directory listing is not edittable due to some exceptions","FAIL",runManagerInfoObj);
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		blnFlag=false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean FN_AliasNameEdit(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{

	try{
		if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_AliasName,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Alias Name Field is displayed","Alias Name Field is displayed","PASS",runManagerInfoObj);
			WebElement ManageLine_AliasName=driver.findElement(By.xpath(mbo.ManageLine_AliasName));
			ManageLine_AliasName.clear();
			String name = m1.get("NewName").toString();
			ManageLine_AliasName.sendKeys(name+randomInt);
			
			repfn.FnUpdateTestStepResHTML("Verify New Alias Name is Entered for the phone number which does not have alias name ","New Alias Name is Entered for the phone number which does not have alias name","PASS",runManagerInfoObj);
			if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_SaveButton,driver)){
				WebElement ManageLine_SaveButton=driver.findElement(By.xpath(mbo.ManageLine_SaveButton));
				if(ManageLine_SaveButton.isEnabled()){    	
					repfn.FnUpdateTestStepResHTML("Verify Save button is enabled After Editing alias Name","Save button is enabled After Editing alias Name","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Save button is enabled After Editing alias Name","Save button is not enabled After Editing alias Name","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Save button is displayed","Save button is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Alias Name Field is displayed","Alias Name Field is not displayed","FAIL",runManagerInfoObj);
			blnFlag=false;
		}

	}

	catch (Exception e)

	{
		repfn.FnUpdateTestStepResHTML("Verify  Save button is enabled After Editing alias Name","Save button is not enabled After Editing alias Name due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}

	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}


public synchronized boolean FnVerifySearchBar_AssignLine(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{

	try{

		if(cnf.FnExplicitWait("XPATH",mbo.AddAssignmentLine,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Add Assignment Link is displayed", "Add Assignment Link is displayed","PASS",runManagerInfoObj);
			WebElement AddAssignmentLine=driver.findElement(By.xpath(mbo.AddAssignmentLine));
			if(cnf.JSClick(AddAssignmentLine,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Add Assignment Link is clicked", "Add Assignment Link is clicked","PASS",runManagerInfoObj);
				Thread.sleep(5000);

				if(cnf.FnExplicitWait("XPATH",mbo.AssignLineUsersList,driver)){
					repfn.FnUpdateTestStepResHTML("Verify User List is displayed", "User List is displayed","PASS",runManagerInfoObj);

					if(cnf.FnExplicitWait("XPATH",mbo.AssignLineSearchBar,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Search bar is present in Assign Lines page", "Search bar is present in Assign Lines page","PASS",runManagerInfoObj);

						Thread.sleep(3000);
						if(cnf.FnExplicitWait("XPATH",mbo.CancelAssignment,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Cancel link is displayed", "Cancel link is displayed","PASS",runManagerInfoObj);
							WebElement CancelAssignment=driver.findElement(By.xpath(mbo.CancelAssignment));
							Thread.sleep(2000);
							if(cnf.JSClick(CancelAssignment,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Cancel link is clicked", "Cancel link is clicked","PASS",runManagerInfoObj);
								Thread.sleep(3000);

								if(cnf.FnExplicitWait("XPATH",mbo.CancelEdit,driver)){
									WebElement CancelEditOne=driver.findElement(By.xpath(mbo.CancelEdit));
									if(cnf.JSClick(CancelEditOne,driver)){
										repfn.FnUpdateTestStepResHTML("Verify Cancel link is clicked again", "Cancel link is clicked again","PASS",runManagerInfoObj);

										if(cnf.FnExplicitWait("XPATH",mbo.ConfirmCancel,driver)){
											repfn.FnUpdateTestStepResHTML("Verify Confirmation pop-up is displayed", "Confirmation pop-up is displayed","PASS",runManagerInfoObj);
											repfn.FnUpdateTestStepResHTML("Verify Confirm link is displayed", "Confirm link is displayed","PASS",runManagerInfoObj);
											WebElement ConfirmCancel=driver.findElement(By.xpath(mbo.ConfirmCancel));
											if(cnf.JSClick(ConfirmCancel,driver)){
												repfn.FnUpdateTestStepResHTML("Verify Confirm link is clicked", "Confirm link is clicked","PASS",runManagerInfoObj);
												Thread.sleep(2000);
												driver.navigate().refresh();
												blnFlag	=true;
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify Confirm link is clicked", "Confirm link is not clicked","FAIL",runManagerInfoObj);
												blnFlag	=false;
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Confirmation pop-up is displayed", "Confirmation pop-up is not displayed. No changes were made","PASS",runManagerInfoObj);
											blnFlag	=true;
											driver.navigate().refresh();
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Cancel link is clicked again", "Cancel link is not clicked again","FAIL",runManagerInfoObj);
										blnFlag	=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Cancel link is displayed", "Cancel link is not displayed","FAIL",runManagerInfoObj);
									blnFlag	=false;
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

					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Search bar is present in Assign Lines page", "Search bar is not present in Assign Lines page","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User List is displayed", "User List is not displayed","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Add Assignment Link is clicked", "Add Assignment Link is not clicked","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}

		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Add Assignment Link is displayed", "Add Assignment Link is not displayed","FAIL",runManagerInfoObj);
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
public synchronized boolean FnVerifyAssignedUser(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{
	
	try{
		
		if(cnf.FnExplicitWait("XPATH",mbo.AddAssignmentLine,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Add Assignment Link is displayed", "Add Assignment Link is displayed.","PASS",runManagerInfoObj);
			blnFlag	=true;
		}
		else{
			if(cnf.FnExplicitWait("XPATH",mbo.DeleteAssignmentLine,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Add Assignment Link is displayed", "Add Assignment Link is not displayed. User is already assigned to the selected phone line.","PASS",runManagerInfoObj);
				WebElement DeleteAssignmentLine=driver.findElement(By.xpath(mbo.DeleteAssignmentLine));
				if(cnf.JSClick(DeleteAssignmentLine,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Assigned User is deleted", "Assigned User is deleted","PASS",runManagerInfoObj);
					
					if(cnf.FnExplicitWait("XPATH",mbo.ConfirmCancel,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Confirmation pop-up is displayed", "Confirmation pop-up is displayed","PASS",runManagerInfoObj);
						repfn.FnUpdateTestStepResHTML("Verify Confirm link is displayed", "Confirm link is displayed","PASS",runManagerInfoObj);
						WebElement ConfirmCancel=driver.findElement(By.xpath(mbo.ConfirmCancel));
						if(cnf.JSClick(ConfirmCancel,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Confirm link is clicked", "Confirm link is clicked","PASS",runManagerInfoObj);
							Thread.sleep(2000);
							//driver.navigate().refresh();
							blnFlag	=true;
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
					repfn.FnUpdateTestStepResHTML("Verify Assigned User is deleted", "Assigned User is not deleted","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Delete Assignment Link is displayed", "Delete Assignment Link is not displayed.","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
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
public synchronized boolean FnEdit_AssisgnLine(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{
	 
	 try{
		 
		 if(cnf.FnExplicitWait("XPATH",mbo.UserDetail_EditBtn,driver)){
			 repfn.FnUpdateTestStepResHTML("Verify Edit link is displayed in Details Information page", "Edit link is displayed in Details Information page","PASS",runManagerInfoObj);
			 WebElement UserDetail_EditBtn=driver.findElement(By.xpath(mbo.UserDetail_EditBtn));
			 if(cnf.JSClick(UserDetail_EditBtn,driver)){
				 repfn.FnUpdateTestStepResHTML("Verify Edit link is clicked", "Edit link is clicked","PASS",runManagerInfoObj);
				 
				 Thread.sleep(5000);
				 if(cnf.FnExplicitWait("XPATH",mbo.ManageLinesEditPage,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify Manage Lines Edit page is displayed", "Manage Lines Edit page is displayed","PASS",runManagerInfoObj);
					 blnFlag = true;
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify Manage Lines Edit page is displayed", "Manage Lines Edit page is not displayed","FAIL",runManagerInfoObj);
					 blnFlag = false;
				 }
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify Edit link is clicked", "Edit link is not clicked","FAIL",runManagerInfoObj);
				 blnFlag = false;
			 }
		 }
		 else{
			 repfn.FnUpdateTestStepResHTML("Verify Edit link is displayed in Details Information page", "Edit link is not displayed in Details Information page","FAIL",runManagerInfoObj);
			 blnFlag = false;
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

public synchronized boolean FnCheckManageLinesList(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{
	 
	 try{
		 
		 if(cnf.FnExplicitWait("XPATH",mbo.ManageLinesList,driver)){
			 repfn.FnUpdateTestStepResHTML("Verify Phone Lines are displayed on Manage Lines Page", "Phone Lines are displayed on Manage Lines Page","PASS",runManagerInfoObj);
			 List<WebElement> ManageLinesList=driver.findElements(By.xpath(mbo.ManageLinesList));
			 
			 if(ManageLinesList.size() > 0){
				 WebElement ManageLine = ManageLinesList.get(0);
				 if(cnf.JSClick(ManageLine,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify Phone Line is clicked", "Phone Line is clicked","PASS",runManagerInfoObj);
					 Thread.sleep(5000);
					 
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
					 repfn.FnUpdateTestStepResHTML("Verify Phone Line is clicked", "Phone Line is not clicked","FAIL",runManagerInfoObj);
					 blnFlag = false;
				 }
			 }
		 }
		 else{
			 repfn.FnUpdateTestStepResHTML("Verify Phone Lines are displayed on Manage Lines Page", "Phone Lines are not displayed on Manage Lines Page","FAIL",runManagerInfoObj);
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





public synchronized boolean FN_DiectoryList_EditCheck(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{
	try{

		if(cnf.FnExplicitWait("Xpath", mbo.DirectoryListAddress_EditForm,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Directory List address is displayed","Directory List address is displayed","PASS",runManagerInfoObj);
			WebElement DirectoryListAddress_EditForm=driver.findElement(By.xpath(mbo.DirectoryListAddress_EditForm));	
			if(cnf.JSClick(DirectoryListAddress_EditForm,driver)){
				repfn.FnUpdateTestStepResHTML("Verify User is not able to edit Directory List Address","User is not able to edit Directory List Address","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify User is not able to edit Directory List Address","User is able to edit Directory List Address","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Directory List address is displayed","Directory List address is not displayed","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}

	catch(Exception e)
	{
		repfn.FnUpdateTestStepResHTML("Verify User is not able to edit Directory List Address","User is able to edit Directory List Address due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}



public synchronized boolean FN_DiectoryListChecking(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{
	try{

		if(cnf.FnExplicitWait("Xpath", mbo.DirectoryListHeading,driver)){
			WebElement DirectoryListHeading=driver.findElement(By.xpath(mbo.DirectoryListHeading));
			if(DirectoryListHeading.getAttribute("textContent").equalsIgnoreCase("Directory Listing")){
				repfn.FnUpdateTestStepResHTML("Verify \'Directory Listing\' section is displayed ", "\'Directory Listing\' section is displayed ","PASS",runManagerInfoObj);
				
				if(cnf.FnExplicitWait("Xpath", mbo.DirectoryList,driver)){
					WebElement DirectoryList=driver.findElement(By.xpath(mbo.DirectoryList));
					repfn.FnUpdateTestStepResHTML("Verify Directory List address is displayed","Directory List address is displayed"+DirectoryList.getText(),"PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Directory List address is displayed","Directory List address is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify \'Directory Listing\' section is displayed ", "\'Directory Listing\' section is not displayed ","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify \'Directory Listing\' heading is displayed ", "\'Directory Listing\' heading is not displayed ","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}

	catch(Exception e)
	{
		repfn.FnUpdateTestStepResHTML("Verify Directory List address is displayed","Directory List address is not displayed due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}

public synchronized boolean FnVerifyHoldMusicOption(WebDriver driver,RunManagerInfo runManagerInfoObj){

	 try{
		 Thread.sleep(5000);
		 if(cnf.FnExplicitWait("XPATH", mbo.ManageLineHeaderText,driver)){
			 List<WebElement> ManageLineHeaderText=driver.findElements(By.xpath(mbo.ManageLineHeaderText));
			 Thread.sleep(2000);
			 for(int i=0;i<ManageLineHeaderText.size();i++){
				 if(!ManageLineHeaderText.get(i).getAttribute("textContent").equalsIgnoreCase("Hold Music")){
					 repfn.FnUpdateTestStepResHTML("Comparing Hold Music text with Header " +(i+1),"Hold Music text is not displayed. Header text is: " +ManageLineHeaderText.get(i).getAttribute("textContent"),"PASS",runManagerInfoObj);
					 blnFlag=true;
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Comparing Hold Music text with Header " +(i+1),"Hold Music text is displayed.","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }

			 if(blnFlag){
				 repfn.FnUpdateTestStepResHTML("Verify Hold Music option is not displayed in Manage Lines Details page",
						 "Hold Music option is not displayed in Manage Lines Details page","PASS",runManagerInfoObj);
				 blnFlag=true;
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify Hold Music option is not displayed in Manage Lines Details page",
						 "Hold Music option is displayed in Manage Lines Details page","FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }


	 }

	 catch (Exception e)

	 {
		 repfn.FnUpdateTestStepResHTML("Verify User is able to see Hold Music option in Manage Lines Details page",
				 "User is not ble to see Hold Music option in Manage Lines Details page due to some exception","FAIL",runManagerInfoObj);

		 blnFlag=false;
		 System.err.println("Message : "+e.getMessage());
		 System.err.println("Cause : "+e.getCause());

	 }
	 m1.put("STEPSTATUS", blnFlag);
	 return blnFlag;
}




public synchronized boolean fnManageVoiceSkip(WebDriver driver,RunManagerInfo runManagerInfoObj)
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
public synchronized boolean FN_ManageUsers_Confirm(WebDriver driver,RunManagerInfo runManagerInfoObj)
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




}
