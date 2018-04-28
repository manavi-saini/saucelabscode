package com.charter.sb.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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

public class ContactsService extends Initialization {
	MB_PageObjects mbo = new MB_PageObjects();
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	public static boolean blnFlag = false;
	Random rg=new Random();
	String First_name_validation;
	String Random_int_validation;
	int randomInt = rg.nextInt(10000);
	public synchronized boolean FnContactLinkClick(WebDriver driver, RunManagerInfo runManagerInfoObj){
		try{

			if(cnf.FnExplicitWait("XPATH", mbo.Contacts_Link,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Contacts Link is present in Voice Page ","Contacts Link is present in Voice Page","PASS",runManagerInfoObj);
				WebElement Contacts_Link=driver.findElement(By.xpath(mbo.Contacts_Link));
				cnf.ScrollToView(Contacts_Link,driver);
				if(cnf.JSClick(Contacts_Link,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Contacts Link is Clicked ","Contacts Link is Clicked","PASS",runManagerInfoObj);
					//blnFlag=true;
					Thread.sleep(5000);
					
					if(cnf.FnExplicitWait("XPATH", mbo.verifyContactsPage,driver)){
						repfn.FnUpdateTestStepResHTML("Verify User is navigated to Contacts Page","User is navigated to Contacts Page","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify User is navigated to Contacts Page","User is not navigated to Contacts Page","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Contacts Link is Clicked ","Contacts Link is not Clicked","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Contacts Link is present in Voice Page ","Contacts Link is not present in Voice Page","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

		}

		catch (Exception e)

		{

			repfn.FnUpdateTestStepResHTML("Verify Contacts Link is Clicked ","Contacts Link is not Clicked due to some exception","FAIL",runManagerInfoObj);
			blnFlag=false;
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());

		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	public synchronized boolean FN_SortingA_Z(WebDriver driver, RunManagerInfo runManagerInfoObj){
		try{

			ArrayList<String> al = new ArrayList<String>();
			ArrayList<String> bl = new ArrayList<String>();

			if(cnf.FnExplicitWait("Xpath",mbo.Contact_List,driver)){
				repfn.FnUpdateTestStepResHTML(" Verify Contacts List is displayed in Contacts Page","Contacts List is displayed in Contacts Page","PASS",runManagerInfoObj);
				List<WebElement> Contact_List=driver.findElements(By.xpath(mbo.Contact_List));
				for(WebElement we:Contact_List){

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

				FN_Sorting_arrowClick_A_Z(driver,runManagerInfoObj);

				List<WebElement> Contact_List1=driver.findElements(By.xpath(mbo.Contact_List));
				Thread.sleep(3000);

				for(WebElement we1:Contact_List1){

					String[] names = we1.getText().split(" ");

					if(names.length > 1){
						bl.add(names[names.length-1]);
					}
					else if(names.length == 1){
						bl.add(" ");
					}

					System.out.println("Afte clicking A_Z"+bl);
				}

				Thread.sleep(3000);
				
				if(bl.equals(al)){
					
					repfn.FnUpdateTestStepResHTML(" Verify A-Z sorting is done successfully","A-Z sorting is done successfully as list is sorted according to Last name","PASS",runManagerInfoObj);
					blnFlag=true;
				
				}
				else{
					
					repfn.FnUpdateTestStepResHTML(" Verify A-Z sorting is done successfully","A-Z sorting is not done successfully as list is not sorted according to Last name","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			

			}
			else{
				repfn.FnUpdateTestStepResHTML(" Verify Contacts List is displayed in Contacts Page","Contacts List is not displayed in Contacts Page","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

			
		}
		catch (Exception e)

		{
			repfn.FnUpdateTestStepResHTML(" Verify A-Z sorting is Verified","A-Z sorting is  not Verified due to some exception","FAIL",runManagerInfoObj);
			 blnFlag=false;
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}	

	public synchronized boolean FN_Sorting_arrowClick_A_Z(WebDriver driver, RunManagerInfo runManagerInfoObj){
		try{
			
			if(cnf.FnExplicitWait("Xpath", mbo.Sorting_arrowClick,driver)){
				repfn.FnUpdateTestStepResHTML(" Verify Sorting_arrow is displayed in Contacts Page","Sorting_arrow is displayed in Contacts Page","PASS",runManagerInfoObj);
				WebElement Sorting_arrowClick=driver.findElement(By.xpath(mbo.Sorting_arrowClick));
				if(cnf.JSClick(Sorting_arrowClick,driver)){
					repfn.FnUpdateTestStepResHTML(" Verify Sorting_arrow is clicked in Contacts Page","Sorting_arrow is clicked in Contacts Page","PASS",runManagerInfoObj);
					
					if(cnf.FnExplicitWait("Xpath", mbo.SortingA_Z,driver)){
						repfn.FnUpdateTestStepResHTML(" Verify SortingA_Z is displayed in Sorting Toggle window","SortingA_Z is displayed in Sorting Toggle window","PASS",runManagerInfoObj);
						WebElement SortingA_Z=driver.findElement(By.xpath(mbo.SortingA_Z));
						if(cnf.JSClick(SortingA_Z,driver)){
							repfn.FnUpdateTestStepResHTML(" Verify SortingA_Z is clicked in Sorting Toggle window","SortingA_Z is clicked in Sorting Toggle window","PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML(" Verify SortingA_Z is clicked in Sorting Toggle window","SortingA_Z is not clicked in Sorting Toggle window","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML(" Verify SortingA_Z is displayed in Sorting Toggle window","SortingA_Z is not displayed in Sorting Toggle window","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML(" Verify Sorting_arrow is clicked in Contacts Page","Sorting_arrow is not clicked in Contacts Page","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML(" Verify Sorting_arrow is displayed in Contacts Page","Sorting_arrow is not displayed in Contacts Page","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
			
		}
		catch (Exception e)

		{
			
			repfn.FnUpdateTestStepResHTML(" Verify Sorting_arrow is displayed and clicked in contact Page","Sorting_arrow is  not displayed and not clicked in contact Pag due to some exception","FAIL",runManagerInfoObj);
      	    blnFlag=false;
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}

	public synchronized boolean FN_SortingZ_A(WebDriver driver, RunManagerInfo runManagerInfoObj){
		try{
			ArrayList<String> al = new ArrayList<String>();
			ArrayList<String> bl = new ArrayList<String>();

			if(cnf.FnExplicitWait("Xpath",mbo.Contact_List,driver)){
				repfn.FnUpdateTestStepResHTML(" Verify Contacts List is displayed in Contacts Page","Contacts List is displayed in Contacts Page","PASS",runManagerInfoObj);
				List<WebElement> Contact_List=driver.findElements(By.xpath(mbo.Contact_List));
				for(WebElement we:Contact_List){

					String[] names = we.getText().split(" ");

					if(names.length > 1){
						al.add(names[names.length-1]);
					}
					else if(names.length == 1){
						al.add(" ");
					}

					System.out.println("Befort Sorting"+al);
					//Descending sorting
					Collections.sort(al, Collections.reverseOrder());
					//Collections.reverseOrder(al);
					System.out.println("After sorting"+al);
				}

				blnFlag=FN_Sorting_arrowClick_Z_A(driver,runManagerInfoObj);

				List<WebElement> Contact_List1=driver.findElements(By.xpath(mbo.Contact_List));
				Thread.sleep(3000);

				for(WebElement we1:Contact_List1){

					String[] names = we1.getText().split(" ");
					if(names.length > 1){
						bl.add(names[names.length-1]);
					}
					else if(names.length == 1){
						bl.add(" ");
					}

				}

				Thread.sleep(3000);
			
				if(bl.equals(al)){
					
					repfn.FnUpdateTestStepResHTML(" Verify Z-A sorting is done successfully","Z-A sorting is done successfully as list is sorted according to Last name","PASS",runManagerInfoObj);
					blnFlag=true;
					
				}
				else{
									
					repfn.FnUpdateTestStepResHTML(" Verify Z-A sorting is done successfully","Z-A sorting is not done successfully as list is not sorted according to Last name","FAIL",runManagerInfoObj);
					blnFlag=false;					
				}
				
			}
			else{
				repfn.FnUpdateTestStepResHTML(" Verify Contacts List is displayed in Contacts Page","Contacts List is not displayed in Contacts Page","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

			//driver.navigate().refresh();
		}
		catch (Exception e)

		{			
			//repfn.FnUpdateTestStepResHTML(" Verify Z-A sorting is Verified","Z-A sorting is not  Verified due to some exception","FAIL",runManagerInfoObj);
			blnFlag=false;
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());

		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}

	public synchronized boolean FN_Sorting_arrowClick_Z_A(WebDriver driver, RunManagerInfo runManagerInfoObj){
		try{
			if(cnf.FnExplicitWait("Xpath", mbo.Sorting_arrowClick,driver)){
				repfn.FnUpdateTestStepResHTML(" Verify Sorting_arrow is displayed in Contacts Page","Sorting_arrow is displayed in Contacts Page","PASS",runManagerInfoObj);
				WebElement Sorting_arrowClick=driver.findElement(By.xpath(mbo.Sorting_arrowClick));
				if(cnf.JSClick(Sorting_arrowClick,driver)){
					repfn.FnUpdateTestStepResHTML(" Verify Sorting_arrow is clicked in Contacts Page","Sorting_arrow is clicked in Contacts Page","PASS",runManagerInfoObj);
					
					if(cnf.FnExplicitWait("Xpath", mbo.SortingZ_A,driver)){
						repfn.FnUpdateTestStepResHTML(" Verify SortingZ_A is displayed in Sorting Toggle window","SortingZ_A is displayed in Sorting Toggle window","PASS",runManagerInfoObj);
						WebElement SortingZ_A=driver.findElement(By.xpath(mbo.SortingZ_A));
						if(cnf.JSClick(SortingZ_A,driver)){
							repfn.FnUpdateTestStepResHTML(" Verify SortingZ_A is clicked in Sorting Toggle window","SortingZ_A is clicked in Sorting Toggle window","PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML(" Verify SortingZ_A is clicked in Sorting Toggle window","SortingZ_A is not clicked in Sorting Toggle window","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML(" Verify SortingZ_A is displayed in Sorting Toggle window","SortingZ_A is not displayed in Sorting Toggle window","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML(" Verify Sorting_arrow is clicked in Contacts Page","Sorting_arrow is not clicked in Contacts Page","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML(" Verify Sorting_arrow is displayed in Contacts Page","Sorting_arrow is not displayed in Contacts Page","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
			
		}
		catch (Exception e)

		{
			
			repfn.FnUpdateTestStepResHTML(" Verify Sorting_arrow is displayed and clicked in contact Page","Sorting_arrow is not displayed and not clicked in contact Page due to some exception","FAIL",runManagerInfoObj);
      	    blnFlag=false;
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	 public synchronized boolean FN_FirstcontactClick(WebDriver driver, RunManagerInfo runManagerInfoObj){
		 try{

			 if(cnf.FnExplicitWait("XPATH", mbo.ArrowLink,driver)){
				 repfn.FnUpdateTestStepResHTML("Verify Contact List is displayed","Contact List is displayed","PASS",runManagerInfoObj);
				 List<WebElement> ArrowLink=driver.findElements(By.xpath(mbo.ArrowLink));
				 repfn.FnUpdateTestStepResHTML("Verify Arrow_DetailLink is displayed","Arrow_DetailLink is displayed","PASS",runManagerInfoObj);
				 if(cnf.JSClick(ArrowLink.get(0),driver)){
					 repfn.FnUpdateTestStepResHTML("Verify Arrow_DetailLink is Clicked ","Arrow_DetailLink is Clicked ","PASS",runManagerInfoObj); 

					 if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver))
					 {
						 repfn.FnUpdateTestStepResHTML("Verify User Detail Information Window is displayed "," User Detail Information Window is displayed","PASS",runManagerInfoObj);

						 WebElement ManageLine_Editbutton=driver.findElement(By.xpath(mbo.ManageLine_Editbutton));
						 if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_Editbutton,driver))
						 {
							 repfn.FnUpdateTestStepResHTML("Verify if the Edit link is displayed","Edit link is displayed","PASS",runManagerInfoObj);

							 cnf.ElementClick(ManageLine_Editbutton,driver); 
							 repfn.FnUpdateTestStepResHTML("Verify Click on Edit link","Edit link is clicked","PASS",runManagerInfoObj);
							 if(cnf.FnExplicitWait("XPATH",mbo.ContactInformationWindow,driver))
							 {
								 repfn.FnUpdateTestStepResHTML("Verify Contact Information window is displayed after clicking Edit button","Contact Information window is displayed after clicking Edit button","PASS",runManagerInfoObj);
								 blnFlag=true;
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify Contact Information window is displayed after clicking Edit button","Contact Information window is not displayed after clicking Edit button","FAIL",runManagerInfoObj);
								 blnFlag=false;
							 }
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify Edit button is clicked ","Edit button is not clicked","FAIL",runManagerInfoObj);
							 blnFlag=false;
						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify  User Detail Information Window is displayed "," User Detail Information Window is not displayed","FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify Arrow_DetailLink is Clicked","Arrow_DetailLink is not Clicked ","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify Contact List is displayed","Contact List is not displayed","FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }

		 }

		 catch (Exception e)
		 {
			 repfn.FnUpdateTestStepResHTML("Verify Contact Information window is displayed after clicking Edit button","Contact Information window is not displayed after clicking Edit button","FAIL",runManagerInfoObj);
			 blnFlag=false;
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }




	 public synchronized boolean FNAddcontact_AddressVerificationAfterRemoving(WebDriver driver, RunManagerInfo runManagerInfoObj){
		 try{



			 if(cnf.isElementExist(By.xpath( mbo.AddressVerification),driver)){

				 repfn.FnUpdateTestStepResHTML("Verify Contact  has Newly Added Address","Contact  Has  the  Address ","FAIL",runManagerInfoObj);

				 blnFlag=false; 



			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify Contact  should  not have the Address as it was removed while adding New contact","Contact    does not have  the  Address","PASS",runManagerInfoObj);

				 blnFlag=true;
			 }

		 }
		 catch (Exception e)

		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
			 repfn.FnUpdateTestStepResHTML("Verify Contact  should  not have the Address as it was removed while adding New contact","Contact    does not have  Newly Added Address due to some exception","FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }



	 public synchronized boolean ContactsUI_Check(WebDriver driver, RunManagerInfo runManagerInfoObj){
			try{

				if(cnf.FnExplicitWait("XPATH",mbo.ContactInformationLabel,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if Contact Information Label is present","Contact Information Label is present","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else 
				{
					repfn.FnUpdateTestStepResHTML("Verify if Contact Information Label is present","Contact Information Label is not  present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				if(cnf.FnExplicitWait("XPATH",mbo.NameLabel,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if Name Label is present","Name Label is present","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else 
				{
					repfn.FnUpdateTestStepResHTML("Verify if Name Label is present","Name Label is not  present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}			

				//FirstName		
				if(cnf.FnExplicitWait("XPATH",mbo.FirstNameLabel,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if  First Name Label is present","First Name Label is present","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else 
				{
					repfn.FnUpdateTestStepResHTML("Verify if  First Name Label is present","First Name Label is not  present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				if(cnf.FnExplicitWait("XPATH",mbo.AddContact_FirstName,driver)){
					WebElement AddContact_FirstName=driver.findElement(By.xpath(mbo.AddContact_FirstName));
					repfn.FnUpdateTestStepResHTML("Verify FirstName is Displayed ","FirstName is  Displayed: "+AddContact_FirstName.getAttribute("value"),"PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify FirstName is  Displayed","FirstName is not   Displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				//LastName
				if(cnf.FnExplicitWait("XPATH",mbo.LastNameLabel,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if  Last Name Label is present","Last Name Label is present","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else 
				{
					repfn.FnUpdateTestStepResHTML("Verify if  Last Name Label is present","Last Name Label is not  present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}


				if(cnf.FnExplicitWait("XPATH",mbo.AddContact_LastName,driver)){
					WebElement AddContact_LastName=driver.findElement(By.xpath(mbo.AddContact_LastName));
					repfn.FnUpdateTestStepResHTML("Verify Last Name is Displayed "," Last Name is Displayed: "+AddContact_LastName.getAttribute("value"),"PASS",runManagerInfoObj);
					blnFlag=true;

				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify  Last Name is  Displayed"," Last Name is not   Displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				//Title

				if(cnf.FnExplicitWait("XPATH",mbo.TitleLabel,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if  Title Label is present","Title Label is present","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else 
				{
					repfn.FnUpdateTestStepResHTML("Verify if  Title Label is present","Title Label is not  present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}


				if(cnf.FnExplicitWait("XPATH",mbo.AddContact_Title,driver)){
					WebElement AddContact_Title=driver.findElement(By.xpath(mbo.AddContact_Title));
					repfn.FnUpdateTestStepResHTML("Verify Title details is Displayed "," Title details is Displayed: "+AddContact_Title.getAttribute("value"),"PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify  Title details is  Displayed"," Title details is not Displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				//Company
				if(cnf.FnExplicitWait("XPATH",mbo.CompanyLabel,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if  Company Label is present","Company Label is present","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else 
				{
					repfn.FnUpdateTestStepResHTML("Verify if  Company Label is present","Company Label is not  present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}


				if(cnf.FnExplicitWait("XPATH",mbo.AddContact_Company,driver)){
					WebElement AddContact_Company=driver.findElement(By.xpath(mbo.AddContact_Company));
					repfn.FnUpdateTestStepResHTML("Verify Company Details is Displayed "," Company Details is  Displayed: "+AddContact_Company.getAttribute("value"),"PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify  Company Details is  Displayed"," Company Details is not   Displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				//Phone
				if(cnf.FnExplicitWait("XPATH",mbo.PhoneLabel,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if  Phone Label is present","Phone is present","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else 
				{
					repfn.FnUpdateTestStepResHTML("Verify if  Phone Label is present","Phone is not present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}


				if(cnf.FnExplicitWait("XPATH",mbo.Addcontact_PhoneTypeVerification,driver)){
					List<WebElement> Addcontact_PhoneTypeVerification=driver.findElements(By.xpath(mbo.Addcontact_PhoneTypeVerification));
					if(Addcontact_PhoneTypeVerification.get(0).isDisplayed()){
						repfn.FnUpdateTestStepResHTML("Verify  PhoneNumber Type is displayed "," PhoneNumber Type is displayed: "+Addcontact_PhoneTypeVerification.get(0).getAttribute("textContent") ,"PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify  PhoneNumber Type is displayed "," PhoneNumber Type is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify PhoneNumber Type is displayed "," PhoneNumber Type is not displayed. No phone number is added","PASS",runManagerInfoObj);
					blnFlag=true;
				}


				if(cnf.FnExplicitWait("XPATH",mbo.Addcontact_PhoneNumberVerification,driver)){
					List<WebElement>  Addcontact_PhoneNumberVerification=driver.findElements(By.xpath(mbo. Addcontact_PhoneNumberVerification));
					if(Addcontact_PhoneNumberVerification.get(0).isDisplayed()){
						repfn.FnUpdateTestStepResHTML("Verify PhoneNumber  is displayed "," PhoneNumber is displayed: "+Addcontact_PhoneNumberVerification.get(0).getAttribute("textContent") ,"PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify PhoneNumber is displayed "," PhoneNumber is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify PhoneNumber is displayed "," PhoneNumber is not displayed. No phone number is added","PASS",runManagerInfoObj);
					blnFlag=true;
				}

				//Email

				if(cnf.FnExplicitWait("XPATH",mbo.EmailLabel,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if  Email Label is present","Email is present","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else 
				{
					repfn.FnUpdateTestStepResHTML("Verify if  Email Label is present","Email is not  present","FAIL",runManagerInfoObj);
					blnFlag=false;
				} 


				if(cnf.FnExplicitWait("XPATH",mbo.EmailVerification,driver)){
					List<WebElement> EmailVerification=driver.findElements(By.xpath(mbo.EmailVerification));
					if(EmailVerification.get(0).isDisplayed()){
						repfn.FnUpdateTestStepResHTML("Verify  Email id  is displayed "," Email id is displayed: "+EmailVerification.get(0).getText() ,"PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify  Email id is displayed "," Email id is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Email id is displayed "," Email id is not displayed. No Email id is added","PASS",runManagerInfoObj);
					blnFlag=true;
				}

				//address 
				if(cnf.FnExplicitWait("XPATH",mbo.AddressLabel,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if  Address Label is present","Address is present","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else 
				{
					repfn.FnUpdateTestStepResHTML("Verify if  Address Label is present","Address is not  present","FAIL",runManagerInfoObj);
					blnFlag=false;
				} 

				if(cnf.FnExplicitWait("XPATH",mbo.AddressVerification,driver)){
					List<WebElement> AddressVerification=driver.findElements(By.xpath(mbo.AddressVerification));
					if(AddressVerification.get(0).isDisplayed()){
						repfn.FnUpdateTestStepResHTML("Verify Address is displayed "," Address is displayed: "+AddressVerification.get(0).getText() ,"PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Address is displayed ","Address is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Address is displayed "," Address is not displayed. No Address is added","PASS",runManagerInfoObj);
					blnFlag=true;
				}

				//cancel

				if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_CancelBtn,driver)){
					WebElement Cancelbtn=driver.findElement(By.xpath(mbo.ManageLine_CancelBtn));
					repfn.FnUpdateTestStepResHTML("Verify Cancel link is displayed ","Cancel link is displayed","PASS",runManagerInfoObj);
					if(Cancelbtn.isDisplayed()){
						cnf.JSClick(Cancelbtn,driver);
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

			catch (Exception e)
			{
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				repfn.FnUpdateTestStepResHTML("Verify User is able to verify Edit Details page UI","User is not able to verify Edit Details page UI due to some exception","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
	 public synchronized boolean FnOpenUserDetailsPage(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
		{
			try{
				
				if(cnf.FnExplicitWait("XPATH",mbo.Contacts_Arrow,driver)){
					List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
					if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
						repfn.FnUpdateTestStepResHTML("Verify Arrow_DetailLink is displayed and Clicked ","Arrow_DetailLink is displayed and Clicked ","PASS",runManagerInfoObj);
						
						if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
							repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Arrow_DetailLink is displayed and Clicked ","Arrow_DetailLink is  not displayed and Clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Arrow_DetailLink is displayed and Clicked ","Arrow_DetailLink is not displayed and Clicked ","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
			}

			catch(Exception e)
			{
				repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed due to some exception.","FAIL",runManagerInfoObj);
				blnFlag=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());

			}

			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}

		public synchronized boolean FnOpenUserDetailsPagePrivate(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
		{
			try{
				List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
				if(Contacts_Arrow.get(1).isDisplayed()){
					//Contacts_Arrow.get(1).click();
					cnf.JSClick(Contacts_Arrow.get(1),driver);
					repfn.FnUpdateTestStepResHTML("Verify Arrow_DetailLink is displayed and Clicked ","Arrow_DetailLink is displayed and Clicked ","PASS",runManagerInfoObj);
					if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
						repfn.FnUpdateTestStepResHTML("Verify UUserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Arrow_DetailLink is displayed and Clicked ","Arrow_DetailLink is  not displayed and Clicked","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

			}

			catch(Exception e)
			{
				blnFlag	=false;
				repfn.FnUpdateTestStepResHTML("Login to Charter.net ", "Login is not performed due to exception","FAIL",runManagerInfoObj);

			}

			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}

		public synchronized boolean FnOpenEditUserPage(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
		{
			try{

				if(cnf.FnExplicitWait("XPATH", mbo.UserDetail_EditBtn,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Edit link is diplayed in User Details page "," Edit link is diplayed in User Details page","PASS",runManagerInfoObj);
					WebElement Editbtn=driver.findElement(By.xpath(mbo.UserDetail_EditBtn));
					if(cnf.JSClick(Editbtn,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Edit link is clicked"," Edit link is clicked","PASS",runManagerInfoObj);
						if(cnf.FnExplicitWait("XPATH", mbo.EditModeUserForm,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Edit Mode form is displayed after clicking Edit button "," Edit Mode form is displayed after clicking Edit button","PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Edit Mode form is displayed after clicking Edit button "," Edit Mode form is not displayed after clicking Edit button","FAIL",runManagerInfoObj);
							blnFlag=false;

						}	
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Edit link is clicked"," Edit link is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Edit link is diplayed in User Details page "," Edit link is not diplayed in User Details page","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}

			catch(Exception e)
			{
				repfn.FnUpdateTestStepResHTML("Verify Edit Mode form is displayed after clicking Edit button "," Edit Mode form is not displayed after clicking Edit button due to some exception.","FAIL",runManagerInfoObj);
				blnFlag=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());

			}

			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		
		
		public synchronized boolean Fn_VerifyUserDetailsUI(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
		{
			try{
				if(cnf.FnExplicitWait("XPATH", mbo.personalDetailVerificationSection,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Personal Details section is displayed"," Personal Details section is displayed","PASS",runManagerInfoObj);
					if(cnf.FnExplicitWait("XPATH", mbo.personalDetailVerificationName,driver)){
						WebElement personalDetailVerificationName=driver.findElement(By.xpath(mbo.personalDetailVerificationName));
						repfn.FnUpdateTestStepResHTML("Verify Contact Name is displayed"," Contact Name is displayed: "+personalDetailVerificationName.getText(),"PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Contact Name is displayed"," Contact Name is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

					if(cnf.FnExplicitWait("XPATH", mbo.personalDetailVerificationTitle,driver)){
						WebElement personalDetailVerificationTitle=driver.findElement(By.xpath(mbo.personalDetailVerificationTitle));
						repfn.FnUpdateTestStepResHTML("Verify Contact Title is displayed"," Contact Title is displayed: "+personalDetailVerificationTitle.getText(),"PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Contact Title is displayed"," Contact Title is not displayed. No title has been added.","PASS",runManagerInfoObj);
						blnFlag=true;
					}

					if(cnf.FnExplicitWait("XPATH", mbo.personalDetailVerificationCompany,driver)){
						WebElement personalDetailVerificationCompany=driver.findElement(By.xpath(mbo.personalDetailVerificationCompany));
						repfn.FnUpdateTestStepResHTML("Verify Contact Company is displayed"," Contact Company is displayed: "+personalDetailVerificationCompany.getText(),"PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Contact Company is displayed"," Contact Company is not displayed. No Company has been added.","PASS",runManagerInfoObj);
						blnFlag=true;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Personal Details section is displayed"," Personal Details section is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumberVerification,driver)){
					List<WebElement>  Addcontact_PhoneNumberVerification=driver.findElements(By.xpath(mbo. Addcontact_PhoneNumberVerification));
					repfn.FnUpdateTestStepResHTML("Verify PhoneNumber is displayed ","PhoneNumber : "+ Addcontact_PhoneNumberVerification.get(0).getText()+" is displayed" ,"PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify PhoneNumber is displayed ","PhoneNumber is not displayed. No phone number is added." ,"PASS",runManagerInfoObj);
					blnFlag=true;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.emailAddressVerification,driver)){
					List<WebElement>  emailAddressVerification=driver.findElements(By.xpath(mbo. emailAddressVerification));
					repfn.FnUpdateTestStepResHTML("Verify Email Address is displayed ","Email Address : "+ emailAddressVerification.get(0).getText()+" is displayed" ,"PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Email Address is displayed ","Email Address is not displayed. No Email Address is added." ,"PASS",runManagerInfoObj);
					blnFlag=true;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.UserAddressVerification,driver)){
					List<WebElement>  UserAddressVerification=driver.findElements(By.xpath(mbo. UserAddressVerification));
					repfn.FnUpdateTestStepResHTML("Verify Address is displayed ","Address : "+ UserAddressVerification.get(0).getText()+" is displayed" ,"PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Address is displayed ","Address is not displayed. No Address is added." ,"PASS",runManagerInfoObj);
					blnFlag=true;
				}
			}

			catch(Exception e)
			{
				repfn.FnUpdateTestStepResHTML("Verify User is able to verify User Details page UI"," User is not able to verify User Details page UI due to some exception.","FAIL",runManagerInfoObj);
				blnFlag=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());

			}

			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		
		public synchronized boolean FnVerifyPhoneTypeField(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
			int listSize = 0;
			try{


				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
					List<WebElement> UserContactPhoneType= driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
					listSize = UserContactPhoneType.size();
					if(listSize < 5){
						blnFlag	= true;
					}
					else if(listSize == 5){
						FnVerifyAddNumberOption(driver,runManagerInfoObj);
						blnFlag	= true;
					}

				}
				else{
					blnFlag=FnVerifyAddNumberOption(driver,runManagerInfoObj);
					if(blnFlag){
						if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
							List<WebElement> phoneNumber=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
							WebElement contactPhoneNumber = phoneNumber.get(0);
							phoneNumber.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"9784512545");
							boolean blnFlag1=app.FnSaveDataAndGoBack(driver,runManagerInfoObj);
							boolean blnFlag2=FnOpenUserDetailsPage(driver,runManagerInfoObj);
							boolean blnFlag3=FnOpenEditUserPage(driver,runManagerInfoObj);
							if(blnFlag1 && blnFlag2 && blnFlag3){
								blnFlag	= true;
							}else{
								blnFlag=false;
							}
						}else{
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Phone number field is added", "Phone number field is not added","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
				}
			}

			catch(Exception e)
			{

				repfn.FnUpdateTestStepResHTML("Verify phone type drop-down is displayed in Edit Contact form. ", "Phone type drop-down is not displayed in Edit Contact form due to some exception","FAIL",runManagerInfoObj);
				blnFlag	=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());

			}

			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}
	

		public synchronized boolean FN_addEmailIconClick(WebDriver driver, RunManagerInfo runManagerInfoObj){
			try{


				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailIcon,driver)){
					repfn.FnUpdateTestStepResHTML("Verify if the Add Email Address link is displayed in the Contact details window","Add Email Address link is displayed ","PASS",runManagerInfoObj);
					WebElement Addcontact_EmailIcon=driver.findElement(By.xpath(mbo.Addcontact_EmailIcon));
					if(Addcontact_EmailIcon.isEnabled()){
						if(cnf.ElementClick(Addcontact_EmailIcon,driver)){
							repfn.FnUpdateTestStepResHTML("Verify if the Add Email Address link is enabled and clicked ","Add Email Address link is enabled and clicked","PASS",runManagerInfoObj);
							//Entering EmailId

							if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
								WebElement Addcontact_EmailInputText=driver.findElement(By.xpath(mbo.Addcontact_EmailInputText));
								repfn.FnUpdateTestStepResHTML("Verify if the fields to enter the Email address is displayed ","Field to enter Email address is displayed","PASS",runManagerInfoObj);

								Addcontact_EmailInputText.sendKeys("Infosys"+randomInt+"@gmail.com");
								repfn.FnUpdateTestStepResHTML("Enter Email address ","Email id 1 is entered as Infosys" +randomInt+"@gmail.com" ,"PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Enter Email address ","Email id 1 is not  Entered","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify if the Add Email Address link is enabled and clicked ","Add Email Address link is  not enabled and not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify if the Add Email Address link is displayed in the Contact details window","Add Email Address link is not  displayed ","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

				}else{
					repfn.FnUpdateTestStepResHTML("Verify if the Add Email Address link is displayed in the Contact details window","Add Email Address link is not displayed ","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				//Entering EmailId 2
				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailIcon,driver)){
					repfn.FnUpdateTestStepResHTML("Verify if the Add Email Address link is displayed in the Contact details window","Add Email Address link is displayed ","PASS",runManagerInfoObj);
					WebElement Addcontact_EmailIconOne=driver.findElement(By.xpath(mbo.Addcontact_EmailIcon));
					if(Addcontact_EmailIconOne.isEnabled()){
						repfn.FnUpdateTestStepResHTML("Verify Addcontact_EmailIcon is present in home Page ","Addcontact_EmailIcon is present in home Page","PASS",runManagerInfoObj);
						if(cnf.ElementClick(Addcontact_EmailIconOne,driver)){
							repfn.FnUpdateTestStepResHTML("Verify AAddcontact_EmailIcon is Clicked ","Addcontact_EmailIcon is Clicked","PASS",runManagerInfoObj);
							//Entering EmailId

							if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
								List<WebElement> Addcontact_EmailInputText=driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
								Addcontact_EmailInputText.get(1).sendKeys("Saranya"+randomInt+"@gmail.com");
								repfn.FnUpdateTestStepResHTML("Verify Email id 2 is Entered ","Email id 2 is Entered Saranya"+randomInt+"@gmail.com","PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Email id  2 is Entered ","Email id 2 is not  Entered","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Addcontact_EmailIcon is Clicked ","Addcontact_EmailIcon is not Clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Addcontact_EmailIcon is present in home Page ","Addcontact_EmailIcon is not  present in home Page","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify if the Add Email Address link is displayed in the Contact details window","Add Email Address link is not displayed ","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}

			catch (Exception e)

			{
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				repfn.FnUpdateTestStepResHTML("Verify User is able to add new email ","User is not  able to add new email due to some exception","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}



		public synchronized boolean FN_RemoveEmailIconClick(WebDriver driver, RunManagerInfo runManagerInfoObj){
			try{

				if(cnf.FnExplicitWait("XPATH", mbo.AddContact_RemoveEmail,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Remove Email Icon is present ","Remove Email Icon is present","PASS",runManagerInfoObj);

					List<WebElement> AddContact_RemoveEmail=driver.findElements(By.xpath(mbo.AddContact_RemoveEmail));
					//cnf.ScrollToView(AddContact_RemoveEmail.get(0));
					if(cnf.JSClick(AddContact_RemoveEmail.get(1),driver)){
						repfn.FnUpdateTestStepResHTML("Verify Remove Email Icon is clicked","Remove Email Icon is clicked","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Remove Email Icon is clicked","Remove Email Icon is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

					if(cnf.JSClick(AddContact_RemoveEmail.get(0),driver)){
						repfn.FnUpdateTestStepResHTML("Verify Remove Email Icon is clicked","Remove Email Icon is clicked","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Remove Email Icon is clicked","Remove Email Icon is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}				
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Remove Email Icon is present","Remove Email Icon is not present ","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

			}

			catch (Exception e)
			{
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				repfn.FnUpdateTestStepResHTML("Verify RemoveEmailIcon is present in home Page and clicked","RemoveEmailIcon is not  present in home Page and not  clicked due to some exception","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}


		public synchronized boolean FN_addAddressIconClick(WebDriver driver, RunManagerInfo runManagerInfoObj){
			try{
				WebElement AddContact_AddressIcon=driver.findElement(By.xpath(mbo.AddContact_AddressIcon));
				if(AddContact_AddressIcon.isDisplayed() && AddContact_AddressIcon.isEnabled() ){
					repfn.FnUpdateTestStepResHTML("Verify Add Address button  is displayed and enabled ","Add Address button  is displayed and enabled ","PASS",runManagerInfoObj);
					if(cnf.ElementClick(AddContact_AddressIcon,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Add Address button  is Clicked ","Add Address button  is Clicked","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Add Address button  is Clicked ","Add Address button is not Clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Add Address button  is displayed and enabled  ","Add Address button  is  not displayed and not enabled ","FAIL",runManagerInfoObj);
					blnFlag=false;
				}


				//Entering AddressStreet
				WebElement AddContact_AddressStreet=driver.findElement(By.xpath(mbo.AddContact_AddressStreet));
				if(cnf.FnExplicitWait("XPATH", mbo.AddContact_AddressStreet,driver)){

					AddContact_AddressStreet.sendKeys("No 25 GST Road");
					repfn.FnUpdateTestStepResHTML("Verify Street  Address Details is Entered ","Street  Address Details is Entered","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Street  Address Details is Entered ","Street  Address Details is not  Entered","FAIL",runManagerInfoObj);
					blnFlag=false;
				}


				//Entering  AddressCity
				WebElement AddContact_AddressCity=driver.findElement(By.xpath(mbo.AddContact_AddressCity));
				if(cnf.FnExplicitWait("XPATH", mbo.AddContact_AddressCity,driver)){

					AddContact_AddressCity.sendKeys("CHENNAI");
					repfn.FnUpdateTestStepResHTML("Verify City Details is Entered ","City  Detailsis Entered","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify City Details is Entered ","City Details is not  Entered","FAIL",runManagerInfoObj);
					blnFlag=false;
				}


				//Entering  AddressState
				WebElement AddContact_AddressState=driver.findElement(By.xpath(mbo.AddContact_AddressState));
				if(cnf.FnExplicitWait("XPATH", mbo.AddContact_AddressState,driver)){

					AddContact_AddressState.sendKeys("TAMILNADU");
					repfn.FnUpdateTestStepResHTML("Verify State Details is Entered ","State Details is Entered","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify State Details is Entered ","State Details is not  Entered","FAIL",runManagerInfoObj);
					blnFlag=false;
				}



				//Entering  AddressZipcode
				WebElement AddContact_AddressZipcode=driver.findElement(By.xpath(mbo.AddContact_AddressZipcode));
				if(cnf.FnExplicitWait("XPATH", mbo.AddContact_AddressZipcode,driver)){

					AddContact_AddressZipcode.sendKeys("600045");
					repfn.FnUpdateTestStepResHTML("Verify Zipcode Details is Entered ","Zipcode Details is Entered","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Zipcode Details is Entered ","Zipcode Details is not  Entered","FAIL",runManagerInfoObj);
					blnFlag=false;
				}


				//Entering  AddressCountry
				WebElement AddContact_AddressCountry=driver.findElement(By.xpath(mbo.AddContact_AddressCountry));
				if(cnf.FnExplicitWait("XPATH", mbo.AddContact_AddressCountry,driver)){

					AddContact_AddressCountry.sendKeys("INDIA");
					repfn.FnUpdateTestStepResHTML("Verify Country Details is Entered ","Country Details is Entered","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Country Details is Entered ","Country Details is not  Entered","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

			}


			catch (Exception e)

			{
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				repfn.FnUpdateTestStepResHTML("Verify User is able to enter address feilds ","User is not  able to enter address feilds","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}



		public synchronized boolean FN_RemoveAddressIconClick(WebDriver driver, RunManagerInfo runManagerInfoObj){
			try{

				cnf.FnExplicitWait("XPATH", mbo.AddContact_RemoveAddress,driver);
				WebElement AddContact_RemoveAddress=driver.findElement(By.xpath(mbo.AddContact_RemoveAddress));
				if(AddContact_RemoveAddress.isDisplayed()){
					repfn.FnUpdateTestStepResHTML("Verify RemoveAddressIcon is displayed and clicked ","RemoveAddressIcon is displayed   and clicked","PASS",runManagerInfoObj);
					cnf.JSClick(AddContact_RemoveAddress,driver);
					Thread.sleep(1000);

					/*if(cnf.ElementClick(AddContact_RemoveAddress)){
					repfn.FnUpdateTestStepResHTML("Verify RemoveAddressIcon is Clicked ","RemoveAddressIcon is Clicked","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify RemoveAddressIcon is Clicked ","RemoveAddressIcon is not Clicked","FAIL",runManagerInfoObj);
	                blnFlag=false;
				}*/
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify RemoveAddressIcon is displayed and clicked ","RemoveAddressIcon is not  displayed  and not  clicked","FAIL",runManagerInfoObj);
					blnFlag=false;
				}



			}


			catch (Exception e)

			{
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				repfn.FnUpdateTestStepResHTML("Verify RemoveAddressIcon is displayed  and clicked ","RemoveAddressIcon is not  displayed  and not  clicked due to some exeption","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}


	
	
		public synchronized boolean FnVerifyAddNumberOption(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

			try{

				if(cnf.FnExplicitWait("XPATH", mbo.addNewPhone,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Add New Number option is displayed","Add New Number option is displayed ","PASS",runManagerInfoObj);
					WebElement addNewPhone= driver.findElement(By.xpath(mbo.addNewPhone));
					if(cnf.JSClick(addNewPhone,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Add New Number option is clicked","Add New Number option is clicked ","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Add New Number option is clicked","Add New Number option is not clicked ","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Add New Number option is displayed","Add New Number option is not displayed. All the numbers are already added. ","PASS",runManagerInfoObj);

					if(cnf.FnExplicitWait("XPATH", mbo.deletePhoneNumber,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Delete Number option is displayed","Delete Number option is displayed ","PASS",runManagerInfoObj);
						List<WebElement> deletePhoneNumberList= driver.findElements(By.xpath(mbo.deletePhoneNumber));
						WebElement deletePhoneNumber = deletePhoneNumberList.get(0);
						if(cnf.JSClick(deletePhoneNumber,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Delete Number option is clicked","Delete Number option is clicked ","PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Delete Number option is clicked","Delete Number option is not clicked ","FAIL",runManagerInfoObj);
							blnFlag=false;
						}

					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Delete Number option is displayed","Delete Number option is not displayed ","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}

			}

			catch(Exception e)
			{

				repfn.FnUpdateTestStepResHTML("Verify Add Number option is displayed", "Add Number option is displayed due to exception","FAIL",runManagerInfoObj);
				blnFlag	=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());

			}

			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}
		public synchronized boolean FnClickAddAddress(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

			try{

				Thread.sleep(5000);
				if(cnf.FnExplicitWait("XPATH", mbo.addAddress,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Add address option is displayed ", "Add address option is displayed","PASS",runManagerInfoObj);
					((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(mbo.addAddress)));   
					driver.manage().window().setSize(new Dimension(100, 100));
					driver.manage().window().maximize();
					WebElement addAddress=driver.findElement(By.xpath(mbo.addAddress));
					if(cnf.JSClick(addAddress,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Add address option is clicked ", "Add address option is clicked","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Add address option is clicked ", "Add address option is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Add address option is displayed","Add address option is not displayed. All the addresses are already added. ","PASS",runManagerInfoObj);			
					if(cnf.FnExplicitWait("XPATH", mbo.deleteAddress,driver)){
						List<WebElement> deleteAddressList= driver.findElements(By.xpath(mbo.deleteAddress));
						repfn.FnUpdateTestStepResHTML("Verify Delete address option is displayed ", "Delete address option is displayed","PASS",runManagerInfoObj);
						WebElement deleteAddress = deleteAddressList.get(0);
						if(cnf.JSClick(deleteAddress,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Delete address option is clicked ", "Delete address option is clicked","PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Delete address option is clicked ", "Delete address option is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}

					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Delete address option is displayed ", "Delete address option is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
			}

			catch(Exception e)
			{

				repfn.FnUpdateTestStepResHTML("Verify Add Address option is clicked. ", "Add Address option is not clicked due to some exception.","FAIL",runManagerInfoObj);
				blnFlag	=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());

			}

			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		public synchronized boolean FnDifferentContact1Click_ToViewContactUI(WebDriver driver, RunManagerInfo runManagerInfoObj){
			try{

				if(cnf.FnExplicitWait("XPATH", mbo.ContactNameList,driver)){
					List<WebElement> ContactNameList=driver.findElements(By.xpath(mbo.ContactNameList));
					repfn.FnUpdateTestStepResHTML("Verify Contact List is displayed","Contact List is displayed","PASS",runManagerInfoObj);
					String ContactText=ContactNameList.get(0).getText();
					if(cnf.JSClick(ContactNameList.get(0),driver)){		
						repfn.FnUpdateTestStepResHTML("Verify First contact is clicked ","First contact is clicked: "+ContactText,"PASS",runManagerInfoObj);

						if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
							repfn.FnUpdateTestStepResHTML("Verify User details window is displayed ","User details window is displayed","PASS",runManagerInfoObj);

							if(cnf.FnExplicitWait("XPATH", mbo.ContactNameText,driver)){
								WebElement ContactNameText=driver.findElement(By.xpath(mbo.ContactNameText));					
								repfn.FnUpdateTestStepResHTML("Verify Contact Name is displayed ","Contact Name is displayed","PASS",runManagerInfoObj);
								if(ContactNameText.getText().contains(ContactText)){
									repfn.FnUpdateTestStepResHTML("Verify Contact Name is matching for opened contact","Contact Name is matching for opened contact","PASS",runManagerInfoObj);


									if(cnf.FnExplicitWait("XPATH", mbo.UserDetail_Backbtn,driver)){
										WebElement Backbtn=driver.findElement(By.xpath(mbo.UserDetail_Backbtn));
										repfn.FnUpdateTestStepResHTML("Verify Back button is displayed","Back button is displayed","PASS",runManagerInfoObj);
										if(cnf.JSClick(Backbtn,driver)){ 
											repfn.FnUpdateTestStepResHTML("Verify Back button is clicked ","Back button is clicked","PASS",runManagerInfoObj);
											blnFlag=true;
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
									repfn.FnUpdateTestStepResHTML("Verify contact Name matching for opened contact and Details","Contact Name is not  matching for opened contact and Details","FAIL",runManagerInfoObj);
									blnFlag=false; 
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Contact Name is displayed ","Contact Name is not displayed","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User details window is displayed ","User details window is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}

					}else{
						repfn.FnUpdateTestStepResHTML("Verify First contact is clicked ","First contact is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Contact List is displayed","Contact List is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			catch (Exception e)

			{
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				repfn.FnUpdateTestStepResHTML("Verifying if the user is able to see the information of the selected contact in the contact info window.","the user is not  able to see the information of the selected contact in the contact info window due to some exception","FAIL",runManagerInfoObj);
				blnFlag=false;

			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}

		public synchronized boolean FnDifferentContact2Click_ToViewContactUI(WebDriver driver, RunManagerInfo runManagerInfoObj){
			try{

				if(cnf.FnExplicitWait("XPATH", mbo.ContactNameList,driver)){
					List<WebElement> ContactNameList=driver.findElements(By.xpath(mbo.ContactNameList));
					repfn.FnUpdateTestStepResHTML("Verify Contact List is displayed","Contact List is displayed","PASS",runManagerInfoObj);
					if(ContactNameList.size() > 1){
						String ContactText=ContactNameList.get(1).getText();
						if(cnf.JSClick(ContactNameList.get(1),driver)){		
							repfn.FnUpdateTestStepResHTML("Verify First contact is clicked ","First contact is clicked: "+ContactText,"PASS",runManagerInfoObj);

							if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
								repfn.FnUpdateTestStepResHTML("Verify User details window is displayed ","User details window is displayed","PASS",runManagerInfoObj);

								if(cnf.FnExplicitWait("XPATH", mbo.ContactNameText,driver)){
									WebElement ContactNameText=driver.findElement(By.xpath(mbo.ContactNameText));					
									repfn.FnUpdateTestStepResHTML("Verify Contact Name is displayed ","Contact Name is displayed","PASS",runManagerInfoObj);
									if(ContactNameText.getText().contains(ContactText)){
										repfn.FnUpdateTestStepResHTML("Verify Contact Name is matching for opened contact","Contact Name is matching for opened contact","PASS",runManagerInfoObj);


										if(cnf.FnExplicitWait("XPATH", mbo.UserDetail_Backbtn,driver)){
											WebElement Backbtn=driver.findElement(By.xpath(mbo.UserDetail_Backbtn));
											repfn.FnUpdateTestStepResHTML("Verify Back button is displayed","Back button is displayed","PASS",runManagerInfoObj);
											if(cnf.JSClick(Backbtn,driver)){ 
												repfn.FnUpdateTestStepResHTML("Verify Back button is clicked ","Back button is clicked","PASS",runManagerInfoObj);
												blnFlag=true;
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
										repfn.FnUpdateTestStepResHTML("Verify contact Name matching for opened contact and Details","Contact Name is not  matching for opened contact and Details","FAIL",runManagerInfoObj);
										blnFlag=false; 
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Contact Name is displayed ","Contact Name is not displayed","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify User details window is displayed ","User details window is not displayed","FAIL",runManagerInfoObj);
								blnFlag=false;
							}

						}else{
							repfn.FnUpdateTestStepResHTML("Verify First contact is clicked ","First contact is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify More than 1 contact is present on Contacts page","More than 1 contact is not present on Contacts page","PASS",runManagerInfoObj);
						boolean blnFlag1 = FnClickAddContact(driver,runManagerInfoObj);	
						if(blnFlag1){
							boolean blnFlag2 = FnAddNewContactSave(driver,runManagerInfoObj);
							if(blnFlag2){
								if(cnf.FnExplicitWait("XPATH", mbo.ContactNameList,driver)){
									List<WebElement> ContactNameListOne=driver.findElements(By.xpath(mbo.ContactNameList));
									if(ContactNameListOne.size() > 1){
										String ContactText=ContactNameListOne.get(1).getText();
										if(cnf.JSClick(ContactNameListOne.get(1),driver)){		
											repfn.FnUpdateTestStepResHTML("Verify First contact is clicked ","First contact is clicked: "+ContactText,"PASS",runManagerInfoObj);

											if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
												repfn.FnUpdateTestStepResHTML("Verify User details window is displayed ","User details window is displayed","PASS",runManagerInfoObj);

												if(cnf.FnExplicitWait("XPATH", mbo.ContactNameText,driver)){
													WebElement ContactNameText=driver.findElement(By.xpath(mbo.ContactNameText));					
													repfn.FnUpdateTestStepResHTML("Verify Contact Name is displayed ","Contact Name is displayed","PASS",runManagerInfoObj);
													if(ContactNameText.getText().contains(ContactText)){
														repfn.FnUpdateTestStepResHTML("Verify Contact Name is matching for opened contact","Contact Name is matching for opened contact","PASS",runManagerInfoObj);


														if(cnf.FnExplicitWait("XPATH", mbo.UserDetail_Backbtn,driver)){
															WebElement Backbtn=driver.findElement(By.xpath(mbo.UserDetail_Backbtn));
															repfn.FnUpdateTestStepResHTML("Verify Back button is displayed","Back button is displayed","PASS",runManagerInfoObj);
															if(cnf.JSClick(Backbtn,driver)){ 
																repfn.FnUpdateTestStepResHTML("Verify Back button is clicked ","Back button is clicked","PASS",runManagerInfoObj);
																blnFlag=true;
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
														repfn.FnUpdateTestStepResHTML("Verify contact Name matching for opened contact and Details","Contact Name is not  matching for opened contact and Details","FAIL",runManagerInfoObj);
														blnFlag=false; 
													}
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify Contact Name is displayed ","Contact Name is not displayed","FAIL",runManagerInfoObj);
													blnFlag=false;
												}
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify User details window is displayed ","User details window is not displayed","FAIL",runManagerInfoObj);
												blnFlag=false;
											}

										}else{
											repfn.FnUpdateTestStepResHTML("Verify First contact is clicked ","First contact is not clicked","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify More than 1 contact is present on Contacts page","More than 1 contact is not present on Contacts page","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Contact List is displayed","Contact List is not displayed","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify if User is able to add and save contact"," User is not able to add and save contact", "FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}				
						else{
							repfn.FnUpdateTestStepResHTML("Verify Add Contact form is displayed", "Add Contact form is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Contact List is displayed","Contact List is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			catch (Exception e)

			{
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				repfn.FnUpdateTestStepResHTML("Verifying if the user is able to see the information of the selected contact in the contact info window.","the user is not  able to see the information of the selected contact in the contact info window due to some exception","FAIL",runManagerInfoObj);
				blnFlag=false;

			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}

		public synchronized boolean FnContact_Navg_back(WebDriver driver, RunManagerInfo runManagerInfoObj){
			try{

				if(cnf.FnExplicitWait("XPATH", mbo.Contacts_Arrow,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Arrow_DetailLink is displayed","Arrow_DetailLink is displayed","PASS",runManagerInfoObj);
					List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));

					if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
						repfn.FnUpdateTestStepResHTML("Verify Arrow_DetailLink is clicked ","Arrow_DetailLink is clicked ","PASS",runManagerInfoObj);
						// WebElement UserDetailpopup=driver.findElement(By.xpath(mbo.UserDetailpopup));
						if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
							repfn.FnUpdateTestStepResHTML("Verify UserDetail Window is displayed ","UserDetail Window is displayed","PASS",runManagerInfoObj);


							if(cnf.FnExplicitWait("XPATH", mbo.UserDetail_Backbtn,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Back button is displayed","Back button is displayed","PASS",runManagerInfoObj);
								WebElement Backbtn=driver.findElement(By.xpath(mbo.UserDetail_Backbtn));
								if(cnf.JSClick(Backbtn,driver)){
									repfn.FnUpdateTestStepResHTML("Verify Back button is clicked ","Back button is clicked","PASS",runManagerInfoObj);
									if(cnf.isElementExist(By.xpath(mbo.UserDetailpopup),driver)){
										repfn.FnUpdateTestStepResHTML("Verify User return to contact page after clicking back button","User is not returned to contact page after clicking back button","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify User return to contact page after clicking back button","User return to contact page after clicking back button","PASS",runManagerInfoObj);
										blnFlag=true;

									}
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
							repfn.FnUpdateTestStepResHTML("Verify UserDetail Window is displayed ","UserDetail Window is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}

					}else{
						repfn.FnUpdateTestStepResHTML("Arrow_DetailLink is clicked ","Arrow_DetailLink is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Arrow_DetailLink is displayed","Arrow_DetailLink is not displayed. No contact is added","PASS",runManagerInfoObj);
					boolean blnFlag1 = FnClickAddContact(driver,runManagerInfoObj);	
					if(blnFlag1){
						boolean blnFlag2 = FnAddNewContactSave(driver,runManagerInfoObj);
						if(blnFlag2){
							if(cnf.FnExplicitWait("XPATH", mbo.Contacts_Arrow,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Arrow_DetailLink is displayed","Arrow_DetailLink is displayed","PASS",runManagerInfoObj);
								List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));

								if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
									repfn.FnUpdateTestStepResHTML("Verify Arrow_DetailLink is clicked ","Arrow_DetailLink is clicked ","PASS",runManagerInfoObj);
									// WebElement UserDetailpopup=driver.findElement(By.xpath(mbo.UserDetailpopup));
									if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
										repfn.FnUpdateTestStepResHTML("Verify UserDetail Window is displayed ","UserDetail Window is displayed","PASS",runManagerInfoObj);


										if(cnf.FnExplicitWait("XPATH", mbo.UserDetail_Backbtn,driver)){
											repfn.FnUpdateTestStepResHTML("Verify Back button is displayed","Back button is displayed","PASS",runManagerInfoObj);
											WebElement Backbtn=driver.findElement(By.xpath(mbo.UserDetail_Backbtn));
											if(cnf.JSClick(Backbtn,driver)){
												repfn.FnUpdateTestStepResHTML("Verify Back button is clicked ","Back button is clicked","PASS",runManagerInfoObj);
												if(cnf.isElementExist(By.xpath(mbo.UserDetailpopup),driver)){
													repfn.FnUpdateTestStepResHTML("Verify User return to contact page after clicking back button","User is not returned to contact page after clicking back button","FAIL",runManagerInfoObj);
													blnFlag=false;
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify User return to contact page after clicking back button","User return to contact page after clicking back button","PASS",runManagerInfoObj);
													blnFlag=true;

												}
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
										repfn.FnUpdateTestStepResHTML("Verify UserDetail Window is displayed ","UserDetail Window is not displayed","FAIL",runManagerInfoObj);
										blnFlag=false;
									}

								}else{
									repfn.FnUpdateTestStepResHTML("Arrow_DetailLink is clicked ","Arrow_DetailLink is not clicked","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Arrow_DetailLink is displayed","Arrow_DetailLink is not displayed","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify if User is able to add and save contact"," User is not able to add and save contact", "FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Add Contact form is displayed", "Add Contact form is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}

			}
			catch (Exception e)

			{
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				repfn.FnUpdateTestStepResHTML("Verify User is returned to Contacts page after clicking back button","User is not returned to Contacts page after clicking back button due to some exception","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}


		

		
		 public synchronized boolean FnVerifySearchField(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
			{
				try{

					if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Search field is displayed on Contacts Page", "Search field is displayed on Contacts Page","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Search field is displayed on Contacts Page", "Search field is not displayed on Contacts Page","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

				}
				catch(Exception e)
				{
					repfn.FnUpdateTestStepResHTML("Verify whether Search field is displayed", "Search field is not displayed due to some exception","FAIL",runManagerInfoObj);
					blnFlag	=false;
					System.err.println("Message : "+e.getMessage());
					System.err.println("Cause : "+e.getCause());

				}

				m1.put("STEPSTATUS", blnFlag);
				return blnFlag;
			}
		 public synchronized boolean FN_SearchBar_LastName(WebDriver driver, RunManagerInfo runManagerInfoObj){
				
				String userName = "";
				try{
					
					Thread.sleep(3000);
					if(cnf.FnExplicitWait("Xpath", mbo.SearchBar,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Search Bar is displayed in Contacts Page","Search Bar is displayed in Contacts Page","PASS",runManagerInfoObj);
						WebElement SearchBar=driver.findElement(By.xpath(mbo.SearchBar));
						if(cnf.FnExplicitWait("Xpath", mbo.ContactsName,driver)){
							//repfn.FnUpdateTestStepResHTML("Verify Contacts List is displayed","Contacts List is displayed","PASS",runManagerInfoObj);
							List<WebElement> ContactsName=driver.findElements(By.xpath(mbo.ContactsName));
							
							for(WebElement web:ContactsName){
								System.out.println(web.getText());
								String[] nameOne = web.getText().split(" ");
								System.out.println(nameOne.length);
								if(nameOne.length > 1){
									userName = web.getText();
									break;
								}
								else{
									continue;
								}
							}
							
							if(userName != null || !userName.equalsIgnoreCase(" ")){
								String[] name = userName.split(" ");
								String LastName = name[1];
								SearchBar.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),LastName);
								repfn.FnUpdateTestStepResHTML("Verify Last name is Entered in Search bar","Last name is Entered in Search bar: "+LastName,"PASS",runManagerInfoObj);
								Thread.sleep(3000);
								if(cnf.FnExplicitWait("Xpath", mbo.SearchResultList,driver)){
									List<WebElement> SearchResultList=driver.findElements(By.xpath(mbo.SearchResultList));
									String list1=SearchResultList.get(0).getText();
									if(list1.contains(LastName)){
										repfn.FnUpdateTestStepResHTML("Verify Contacts List is displayed with entered Last Name","Contacts List is displayed with entered Last Name: "+SearchResultList.get(0).getText(),"PASS",runManagerInfoObj);
						                blnFlag=true;
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Contacts List is displayed with entered Last Name","Contacts List is not displayed with entered Last Name: "+SearchResultList.get(0).getText(),"FAIL",runManagerInfoObj);
						                blnFlag=false;
									}						
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Contacts List is displayed with entered Last Name","Contacts List is not displayed with entered Last Name","FAIL",runManagerInfoObj);
					                blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Contacts is displayed with Last Name","No Contact is present with Last Name","FAIL",runManagerInfoObj);
				                blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Contacts List is displayed","Contacts List is not displayed","FAIL",runManagerInfoObj);
			                blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Search Bar is displayed in Contacts Page","Search Bar is not displayed in Contacts Page","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}

				catch (Exception e)

				{
					
					repfn.FnUpdateTestStepResHTML("Verify Contacts List is displayed with entered Last Name","Contacts List is not displayed with entered Last Name due to some exception","FAIL",runManagerInfoObj);
		            blnFlag=false;
					System.err.println("Message : "+e.getMessage());
					System.err.println("Cause : "+e.getCause());
					
				}
				m1.put("STEPSTATUS", blnFlag);
				return blnFlag;
			}


			public synchronized boolean FN_SearchBar_FirstNAME(WebDriver driver, RunManagerInfo runManagerInfoObj){
				
				String userName = "";
				try{
					
					Thread.sleep(3000);
					if(cnf.FnExplicitWait("Xpath", mbo.SearchBar,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Search Bar is displayed in Contacts Page","Search Bar is displayed in Contacts Page","PASS",runManagerInfoObj);
						WebElement SearchBar=driver.findElement(By.xpath(mbo.SearchBar));
						if(cnf.FnExplicitWait("Xpath", mbo.ContactsName,driver)){
							List<WebElement> ContactsName=driver.findElements(By.xpath(mbo.ContactsName));
							for(WebElement web:ContactsName){
								System.out.println(web.getText());
								String[] nameOne = web.getText().split(" ");
								System.out.println(nameOne.length);
								if(nameOne.length > 1){
									userName = web.getText();
									break;
								}
								else{
									continue;
								}
							}
							
							if(userName != null || !userName.equalsIgnoreCase(" ")){
								String[] name = userName.split(" ");
								String FirstName = name[0];
								SearchBar.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),FirstName);
								repfn.FnUpdateTestStepResHTML("Verify First name is Entered in Search bar","First name is Entered in Search bar: "+FirstName,"PASS",runManagerInfoObj);
								Thread.sleep(3000);
								if(cnf.FnExplicitWait("Xpath", mbo.SearchResultList,driver)){
									List<WebElement> SearchResultList=driver.findElements(By.xpath(mbo.SearchResultList));
									String list1=SearchResultList.get(0).getText();
									if(list1.contains(FirstName)){
										repfn.FnUpdateTestStepResHTML("Verify Contacts List is displayed with entered First Name","Contacts List is displayed with entered First Name: "+SearchResultList.get(0).getText(),"PASS",runManagerInfoObj);
						                blnFlag=true;
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Contacts List is displayed with entered First Name","Contacts List is not displayed with entered First Name: "+SearchResultList.get(0).getText(),"FAIL",runManagerInfoObj);
						                blnFlag=false;
									}						
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Contacts List is displayed with entered First Name","Contacts List is not displayed with entered First Name","FAIL",runManagerInfoObj);
					                blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Contacts is displayed with First Name","No Contact is present with First Name","FAIL",runManagerInfoObj);
				                blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Contacts List is displayed","Contacts List is not displayed","FAIL",runManagerInfoObj);
			                blnFlag=false;
						}			
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Search Bar is displayed in Contacts Page","Search Bar is not displayed in Contacts Page","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}

				catch (Exception e)

				{
					
					repfn.FnUpdateTestStepResHTML("Verify Contacts List is displayed with entered First Name","Contacts List is not displayed with entered First Name due to some exception","FAIL",runManagerInfoObj);
		            blnFlag=false;
					System.err.println("Message : "+e.getMessage());
					System.err.println("Cause : "+e.getCause());
					
				}
				m1.put("STEPSTATUS", blnFlag);
				return blnFlag;
			}
			public synchronized boolean FnClearSearchField(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
			{
				String searchText = "Lisa";
				try{

					if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Search field is displayed", "Search field is displayed","PASS",runManagerInfoObj);
						WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
						cnf.ScrollToView(Search_Field,driver);
						Search_Field.sendKeys(searchText);
						if(!Search_Field.getAttribute("value").equalsIgnoreCase("")){
							repfn.FnUpdateTestStepResHTML("Enter Search text in Search field ", "Search text is entered in Search field","PASS",runManagerInfoObj);
							String text = Search_Field.getAttribute("value");
							System.out.println("Search text : " +text);
							if(cnf.FnExplicitWait("XPATH",mbo.clearSearchField,driver)){
								repfn.FnUpdateTestStepResHTML("Verify clear option is displayed ", "Clear option is displayed","PASS",runManagerInfoObj);
								WebElement Clear_SearchField=driver.findElement(By.xpath(mbo.clearSearchField));
								if(cnf.ElementClick(Clear_SearchField,driver)){
									repfn.FnUpdateTestStepResHTML("Verify clear option is clicked ", "Clear option is clicked","PASS",runManagerInfoObj);
									String textOne = Search_Field.getAttribute("value");
									System.out.println("Search text : " +textOne);
									if(Search_Field.getAttribute("value").equalsIgnoreCase("")){
										repfn.FnUpdateTestStepResHTML("Verify whether Search text is cleared ", "Search text is cleared","PASS",runManagerInfoObj);
										blnFlag=true;
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify whether Search text is cleared ", "Search text is not getting cleared","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify clear option is clicked ", "Clear option is not clicked","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify clear option is displayed ", "Clear option is not displayed","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Enter Search text in Search field ", "Search text is not entered in Search field","FAIL",runManagerInfoObj);
							blnFlag=false;
						}

					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ", "Search field is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

				}
				catch(Exception e)
				{
					repfn.FnUpdateTestStepResHTML("Verify whether Search text is cleared ", "Search text is not getting cleared due to some exception","FAIL",runManagerInfoObj);
					blnFlag	=false;
					System.err.println("Message : "+e.getMessage());
					System.err.println("Cause : "+e.getCause());

				}

				m1.put("STEPSTATUS", blnFlag);
				return blnFlag;
			}
			 public synchronized boolean FnAddContact_AddAddressSaveAndVerify(WebDriver driver, RunManagerInfo runManagerInfoObj){

				 String fullName = "";
				 String AddressStreetValue = "";

				 try{

					 Thread.sleep(2000);
					 if(cnf.FnExplicitWait("XPATH", mbo.EditMode_firstName,driver)){
						 WebElement firstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
						 if(firstName.isDisplayed()){
							 String oldFirstName = firstName.getAttribute("value");
							 firstName.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"Manavi"+randomInt);
							 String newFirstName = firstName.getAttribute("value");
							 if(newFirstName != oldFirstName){
								 repfn.FnUpdateTestStepResHTML("Verify First Name field is modified ","First Name field is modified: "+newFirstName,"PASS",runManagerInfoObj); 
								 blnFlag	=true;
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify First Name field is modified ","First Name field is not modified","FAIL",runManagerInfoObj);
								 blnFlag	=false;
							 }

						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify First Name field is displayed ","First Name field is not displayed","FAIL",runManagerInfoObj);
						 blnFlag	=false;
					 }


					 //cnf.FnExplicitWait("XPATH", mbo.EditMode_firstName);   
					 WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
					 String newNameFirst = FirstName.getAttribute("value");


					 if(cnf.FnExplicitWait("XPATH", mbo.EditMode_LastName,driver)){
						 WebElement LastName=driver.findElement(By.xpath(mbo.EditMode_LastName));

						 String oldLastName = LastName.getAttribute("value");
						 LastName.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"Test");
						 String newLastName = LastName.getAttribute("value");
						 if(newLastName != oldLastName){
							 repfn.FnUpdateTestStepResHTML("Verify Last Name field is modified ","Last Name field is modified: "+newLastName,"PASS",runManagerInfoObj);
							 blnFlag=true;
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify Last Name field is modified ","Last Name field is not modified","FAIL",runManagerInfoObj);
							 blnFlag=false;
						 }


					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify Last Name field is displayed ","Last Name field is not displayed","FAIL",runManagerInfoObj);
						 blnFlag	=false;
					 }


					 //cnf.FnExplicitWait("XPATH", mbo.EditMode_LastName);   
					 WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
					 String newNameLast = lastName.getAttribute("value");

					 if(cnf.FnExplicitWait("XPATH", mbo.ContactTitle,driver)){
						 WebElement contactTitle=driver.findElement(By.xpath(mbo.ContactTitle));
						 if(contactTitle.isDisplayed()){
							 String oldTitle = contactTitle.getAttribute("value");
							 contactTitle.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"Developer");
							 String newTitle = contactTitle.getAttribute("value");
							 if(newTitle != oldTitle){
								 repfn.FnUpdateTestStepResHTML("Verify Contact Title field is modified ","Contact Title field is modified","PASS",runManagerInfoObj);
								 blnFlag=true;
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify Contact Title field is modified ","Contact Title field is not modified","FAIL",runManagerInfoObj);
								 blnFlag=false;	
							 }

						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify Contact Title field is displayed ","Contact Title field is not displayed","FAIL",runManagerInfoObj);
						 blnFlag=false;	
					 }



					 if(cnf.FnExplicitWait("XPATH", mbo.ContactCompany,driver)){
						 WebElement contactCompany=driver.findElement(By.xpath(mbo.ContactCompany));
						 if(contactCompany.isDisplayed()){
							 String oldCompany = contactCompany.getAttribute("value");
							 contactCompany.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"TestCo.");
							 String newCompany = contactCompany.getAttribute("value");
							 if(newCompany != oldCompany){
								 repfn.FnUpdateTestStepResHTML("Verify Contact Company field is modified ","Contact Company field is modified","PASS",runManagerInfoObj);
								 blnFlag=true;	
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify Contact Company field is modified ","Contact Company field is not modified","FAIL",runManagerInfoObj);
								 blnFlag=false;	
							 }

						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify Contact Company field is displayed ","Contact Company field is not displayed","FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }


					 boolean blnFlag1=FnClickAddAddress(driver,runManagerInfoObj);
					 if(blnFlag1){
						 boolean blnFlag2=FnCheckAddressFields(driver,runManagerInfoObj);
						 if(blnFlag2){				 
							 boolean blnFlag3=app.FnAddAddress(driver,runManagerInfoObj);
							 if(blnFlag3){

								 if(cnf.FnExplicitWait("XPATH", mbo.addressStreet,driver)){
									 List<WebElement> addressStreet=driver.findElements(By.xpath(mbo.addressStreet));
									 if(addressStreet.get(0).isDisplayed()){
										 AddressStreetValue = addressStreet.get(0).getAttribute("value");
									 }
								 }


								 driver.manage().window().setSize(new Dimension(100, 100));
								 driver.manage().window().maximize();

								 Thread.sleep(2000);
								 if(cnf.FnExplicitWait("XPATH", mbo.CancelEdit,driver)){
									 repfn.FnUpdateTestStepResHTML("Verify Cancel option is displayed ","Cancel option is displayed","PASS",runManagerInfoObj);
									 blnFlag=true;
								 }
								 else{
									 repfn.FnUpdateTestStepResHTML("Verify Cancel option is displayed ","Cancel option is not displayed","FAIL",runManagerInfoObj);
									 blnFlag=false;
								 }

								 Thread.sleep(5000);
								 if(cnf.FnExplicitWait("XPATH", mbo.UserContactDetailsSave,driver)){
									 repfn.FnUpdateTestStepResHTML("Verify Save option is displayed ","Save option is displayed","PASS",runManagerInfoObj);
									 WebElement Save=driver.findElement(By.xpath(mbo. UserContactDetailsSave));

									 Thread.sleep(1000);
									 if(cnf.JSClick(Save,driver)){
										 //cnf.JSClick(Save);
										 repfn.FnUpdateTestStepResHTML("Verify Save option is clicked"," Save option is clicked","PASS",runManagerInfoObj);
										 Thread.sleep(1000);
										 if(cnf.FnExplicitWait("XPATH", mbo.SaveNotWorkingText,driver)){
											 repfn.FnUpdateTestStepResHTML("Verify Save functionality working or not","Save functionality not working","FAIL",runManagerInfoObj);
											 blnFlag=false;
											 if(cnf.FnExplicitWaitFeedback("XPATH", mbo.Cancel_Button,driver))
											 {
												 repfn.FnUpdateTestStepResHTML("Verify Close option is displayed"," Close option is displayed","PASS",runManagerInfoObj);
												 WebElement close=driver.findElement(By.xpath(mbo.Cancel_Button));
												 if(cnf.JSClick(close,driver)){
													 repfn.FnUpdateTestStepResHTML("Verify Close option is clicked"," Close option is clicked","PASS",runManagerInfoObj);
													 Thread.sleep(2000);
													 if(cnf.FnExplicitWait("XPATH", mbo.Confirm_btn,driver))
													 {
														 repfn.FnUpdateTestStepResHTML("Verify Confirm option is displayed"," Confirm option is displayed","PASS",runManagerInfoObj);
														 WebElement Confrm=driver.findElement(By.xpath(mbo.Confirm_btn));
														 System.out.println("click aftr save not working");
														 if(cnf.JSClick(Confrm,driver))
														 {
															 repfn.FnUpdateTestStepResHTML("Verify Confirm option is displayed"," Confirm option is displayed","PASS",runManagerInfoObj);
															 Thread.sleep(2000);
															 driver.navigate().refresh();
															 Thread.sleep(2000);
															 repfn.FnUpdateTestStepResHTML("Verify User is moved back to call logs page","User is moved back to call logs page","PASS",runManagerInfoObj);
															 blnFlag=false;
														 }
														 else{
															 repfn.FnUpdateTestStepResHTML("Verify Confirm option is clicked"," Confirm option is not clicked","FAIL",runManagerInfoObj);
															 blnFlag=false;
														 }
													 }
													 else{
														 repfn.FnUpdateTestStepResHTML("Verify Confirm option is displayed"," Confirm option is not displayed","FAIL",runManagerInfoObj);
														 blnFlag=false;
													 }

												 }
												 else{
													 repfn.FnUpdateTestStepResHTML("Verify Close option is clicked"," Close option is not clicked","FAIL",runManagerInfoObj);
													 blnFlag=false;
												 }
											 }
											 else{
												 repfn.FnUpdateTestStepResHTML("Verify Close option is displayed"," Close option is not displayed","FAIL",runManagerInfoObj);
												 blnFlag=false;
											 }
										 }
										 else{
											 blnFlag=true;	
											 fullName = newNameFirst+" "+newNameLast;

											 Thread.sleep(2000);
											
											 Thread.sleep(5000);

											 if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
												 WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
												 cnf.ScrollToView(Search_Field,driver);
												 Search_Field.sendKeys(fullName);
												 Thread.sleep(2000);
												 //cnf.FnExplicitWait("XPATH", mbo.contactNameList);

												 if(cnf.FnExplicitWait("XPATH", mbo.contactNameList,driver)){
													 List<WebElement> contactNameList= driver.findElements(By.xpath(mbo.contactNameList));
													 repfn.FnUpdateTestStepResHTML("Verify Contact is present in the Contacts List with First Name as: "+newNameFirst," Contact is present in the Contacts List with First Name as: "+newNameFirst,"PASS",runManagerInfoObj);
													 if(contactNameList.get(0).getText().equalsIgnoreCase(fullName)){
														 repfn.FnUpdateTestStepResHTML("Verify Newly added Contact is added to Contacts list", "Newly added Contact is added to Contacts list","PASS",runManagerInfoObj);
														 List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
														 if(Contacts_Arrow.get(0).isDisplayed()){
															 if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
																 repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
																 if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
																	 repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

																	 Thread.sleep(2000);

																	 if(cnf.FnExplicitWait("XPATH",mbo.UserAddressVerification,driver)){
																		 List<WebElement> UserAddressVerification=driver.findElements(By.xpath(mbo.UserAddressVerification));
																		 cnf.ScrollToView(UserAddressVerification.get(0),driver);
																		 if(cnf.FnExplicitWait("XPATH",mbo.UserAddressStreetVerification,driver)){
																			 List<WebElement> UserAddressStreetVerification=driver.findElements(By.xpath(mbo.UserAddressStreetVerification));
																			 WebElement UserStreetAddress=UserAddressStreetVerification.get(0);
																			 if(UserStreetAddress.getText().contains(AddressStreetValue)){
																				 repfn.FnUpdateTestStepResHTML("Verify Address is added to Newly added contact", "Address is added to Newly added contact","PASS",runManagerInfoObj);
																				 blnFlag=true;
																			 }
																			 else{
																				 repfn.FnUpdateTestStepResHTML("Verify Address is added to Newly added contact ", "Address is not added to Newly added contact","FAIL",runManagerInfoObj);
																				 blnFlag=false;
																			 }
																		 }
																	 }
																	 else{
																		 repfn.FnUpdateTestStepResHTML("Verify Address is added ", "Address is not added","FAIL",runManagerInfoObj);
																		 blnFlag=false;
																	 }
																 }
																 else{
																	 repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
																	 blnFlag=false;
																 }
															 }
															 else{
																 repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
																 blnFlag=false;
															 }
														 }
														 else{
															 repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is displayed","User Details Arrow is not displayed","FAIL",runManagerInfoObj);
															 blnFlag=false;
														 }
													 }
													 else{
														 repfn.FnUpdateTestStepResHTML("Verify Newly added is added to Contacts list", "Newly added Contact is not added to Contacts list","FAIL",runManagerInfoObj);
														 blnFlag = false;
													 }
												 }
												 else{
													 repfn.FnUpdateTestStepResHTML("Verify Contact is present in the Contacts List with First Name as: "+newNameFirst," Contact is not present in the Contacts List with First Name as: "+newNameFirst,"FAIL",runManagerInfoObj);
													 blnFlag = false;
												 }
											 }
											 else{
												 repfn.FnUpdateTestStepResHTML("Verify search option displayed or not after clicking on save option ","Search option not displayed","FAIL",runManagerInfoObj);
												 blnFlag = false;
											 }

										 }					
									 }
									 else{
										 repfn.FnUpdateTestStepResHTML("Verify Save option is clicked"," Save option is not clicked","FAIL",runManagerInfoObj);
										 blnFlag=false;	

									 }				
								 }
								 else{
									 repfn.FnUpdateTestStepResHTML("Verify Save option is displayed ","Save option is not displayed","FAIL",runManagerInfoObj);
									 blnFlag=false;
								 }	
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify new address is added.", "New address is not added","FAIL",runManagerInfoObj);
								 blnFlag = false;
							 }
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify all the address fields are displayed.", "All the address fields are not displayed","FAIL",runManagerInfoObj);
							 blnFlag = false;
						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify Add Address option is displayed and clicked. ", "Add Address option is not displayed and clicked","FAIL",runManagerInfoObj);
						 blnFlag = false;
					 }
					 //blnFlag=FnCheckAddressField();		
				 }

				 catch(Exception e)
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if user is able to add a new contact"," User is not able to add a new contact due to some exception", "FAIL",runManagerInfoObj);
					 blnFlag=false;
					 System.err.println("Message : "+e.getMessage());
					 System.err.println("Cause : "+e.getCause());
				 }

				 m1.put("STEPSTATUS", blnFlag);
				 return blnFlag;

			 }

			 public synchronized boolean FnAddContact_AddAddressCancelAndVerify(WebDriver driver, RunManagerInfo runManagerInfoObj){
					
					String fullName = "";
					
					try{

						Thread.sleep(2000);
						if(cnf.FnExplicitWait("XPATH", mbo.EditMode_firstName,driver)){
							WebElement firstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
							if(firstName.isDisplayed()){
								String oldFirstName = firstName.getAttribute("value");
								firstName.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"Manavi"+randomInt);
								String newFirstName = firstName.getAttribute("value");
								if(newFirstName != oldFirstName){
									repfn.FnUpdateTestStepResHTML("Verify First Name field is modified ","First Name field is modified","PASS",runManagerInfoObj); 
									blnFlag	=true;
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify First Name field is modified ","First Name field is not modified","FAIL",runManagerInfoObj);
									blnFlag	=false;
								}

							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify First Name field is displayed ","First Name field is not displayed","FAIL",runManagerInfoObj);
							blnFlag	=false;
						}


						//cnf.FnExplicitWait("XPATH", mbo.EditMode_firstName);   
						WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
						String newNameFirst = FirstName.getAttribute("value");


						if(cnf.FnExplicitWait("XPATH", mbo.EditMode_LastName,driver)){
							WebElement LastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
							if(LastName.isDisplayed()){
								String oldLastName = LastName.getAttribute("value");
								LastName.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"Test");
								String newLastName = LastName.getAttribute("value");
								if(newLastName != oldLastName){
									repfn.FnUpdateTestStepResHTML("Verify Last Name field is modified ","Last Name field is modified","PASS",runManagerInfoObj);
									blnFlag=true;
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Last Name field is modified ","Last Name field is not modified","FAIL",runManagerInfoObj);
									blnFlag=false;
								}

							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Last Name field is displayed ","Last Name field is not displayed","FAIL",runManagerInfoObj);
							blnFlag	=false;
						}


						//cnf.FnExplicitWait("XPATH", mbo.EditMode_LastName);   
						WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
						String newNameLast = lastName.getAttribute("value");

						if(cnf.FnExplicitWait("XPATH", mbo.ContactTitle,driver)){
							WebElement contactTitle=driver.findElement(By.xpath(mbo.ContactTitle));
							if(contactTitle.isDisplayed()){
								String oldTitle = contactTitle.getAttribute("value");
								contactTitle.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"Developer");
								String newTitle = contactTitle.getAttribute("value");
								if(newTitle != oldTitle){
									repfn.FnUpdateTestStepResHTML("Verify Contact Title field is modified ","Contact Title field is modified","PASS",runManagerInfoObj);
									blnFlag=true;
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Contact Title field is modified ","Contact Title field is not modified","FAIL",runManagerInfoObj);
									blnFlag=false;	
								}

							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Contact Title field is displayed ","Contact Title field is not displayed","FAIL",runManagerInfoObj);
							blnFlag	=false;
						}



						if(cnf.FnExplicitWait("XPATH", mbo.ContactCompany,driver)){
							WebElement contactCompany=driver.findElement(By.xpath(mbo.ContactCompany));
							if(contactCompany.isDisplayed()){
								String oldCompany = contactCompany.getAttribute("value");
								contactCompany.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"TestCo.");
								String newCompany = contactCompany.getAttribute("value");
								if(newCompany != oldCompany){
									repfn.FnUpdateTestStepResHTML("Verify Contact Company field is modified ","Contact Company field is modified","PASS",runManagerInfoObj);
									blnFlag=true;	
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Contact Company field is modified ","Contact Company field is not modified","FAIL",runManagerInfoObj);
									blnFlag=false;	
								}

							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Contact Company field is displayed ","Contact Company field is not displayed","FAIL",runManagerInfoObj);
							blnFlag	=false;
						}


						boolean blnFlag1=FnClickAddAddress(driver,runManagerInfoObj);
						if(blnFlag1){
							boolean blnFlag2=FnCheckAddressFields(driver,runManagerInfoObj);
							if(blnFlag2){				 
								boolean blnFlag3=app.FnAddAddress(driver,runManagerInfoObj);
								if(blnFlag3){
									driver.manage().window().setSize(new Dimension(100, 100));
									driver.manage().window().maximize();

									Thread.sleep(2000);
									if(cnf.FnExplicitWait("XPATH", mbo.CancelEdit,driver)){ 
										repfn.FnUpdateTestStepResHTML("Verify Cancel option is displayed ","Cancel option is displayed","PASS",runManagerInfoObj);
										blnFlag=true;
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Cancel option is displayed ","Cancel option is not displayed","FAIL",runManagerInfoObj);
										blnFlag=false;
									}

									Thread.sleep(2000);
									if(cnf.FnExplicitWait("XPATH", mbo.UserContactDetailsSave,driver)){  
										repfn.FnUpdateTestStepResHTML("Verify Save option is displayed ","Save option is displayed","PASS",runManagerInfoObj);
										blnFlag=true;
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Save option is displayed ","Save option is not displayed","FAIL",runManagerInfoObj);
										blnFlag=false;
									}

									fullName = newNameFirst+" "+newNameLast;
									
									Thread.sleep(2000);
									if(cnf.FnExplicitWait("XPATH", mbo.CancelEdit,driver)){
										repfn.FnUpdateTestStepResHTML("Verify Cancel option is displayed ","Cancel option is displayed","PASS",runManagerInfoObj);
										WebElement Cancel=driver.findElement(By.xpath(mbo.CancelEdit));
										if(cnf.JSClick(Cancel,driver)){
											repfn.FnUpdateTestStepResHTML("Verify Cancel option is clicked ","Cancel option is clicked","PASS",runManagerInfoObj);
											if(cnf.FnExplicitWait("XPATH", mbo.ConfirmCancel,driver)){
												repfn.FnUpdateTestStepResHTML("Verify Confirm option is displayed ","Confirm option is displayed","PASS",runManagerInfoObj);
												WebElement ConfirmCancel=driver.findElement(By.xpath(mbo.ConfirmCancel));
												if(cnf.JSClick(ConfirmCancel,driver)){
													repfn.FnUpdateTestStepResHTML("Verify Editing User Contact is canceled"," Confirm Option is clicked. Hence, Editing User Contact is canceled","PASS",runManagerInfoObj);
													blnFlag	= true;
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify Editing User Contact is canceled"," Confirm Option is not clicked. Editing User Contact was not canceled","FAIL",runManagerInfoObj);
													blnFlag	= false;
												}
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify Confirm option is displayed ","Confirm option is not displayed","FAIL",runManagerInfoObj);
												blnFlag=false;
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Cancel option is clicked ","Cancel option is not clicked","FAIL",runManagerInfoObj);
											blnFlag=false;
										}

									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Cancel option is displayed ","Cancel option is not displayed","FAIL",runManagerInfoObj);
										blnFlag=false;
									}


									Thread.sleep(5000);


									if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
										WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
										cnf.ScrollToView(Search_Field,driver);
										Search_Field.clear();
										Search_Field.sendKeys(fullName);
										Thread.sleep(2000);
										//cnf.FnExplicitWait("XPATH", mbo.contactNameList);

										if(cnf.FnExplicitWait("XPATH", mbo.contactNameList,driver)){
											List<WebElement> contactNameList= driver.findElements(By.xpath(mbo.contactNameList));
											//repfn.FnUpdateTestStepResHTML("Verify Contact is present in the Contacts List with First Name as: "+newNameFirst," Contact is present in the Contacts List with First Name as: "+newNameFirst,"PASS",runManagerInfoObj);

											for(WebElement name:contactNameList){
												if(!name.getText().equalsIgnoreCase(fullName)){
													blnFlag	= true;
												}
												else{
													blnFlag	= false;
												}
											}

											if(blnFlag){
												repfn.FnUpdateTestStepResHTML("Verify Newly added Contact is not added to Contacts list", "Newly added Contact is not added to Contacts list","PASS",runManagerInfoObj);
												blnFlag	= true;
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify New Contact is not added to Contacts list", "New Contact is added to Contacts list","FAIL",runManagerInfoObj);
												blnFlag	= false;
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Contact is present in the Contacts List with First Name as: "+newNameFirst," Contact is not present in the Contacts List with First Name as: "+newNameFirst,"PASS",runManagerInfoObj);
											blnFlag	= true;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Search field is displayed", "Search field is not displayed","FAIL",runManagerInfoObj);
										blnFlag	= false;
									}	
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify new address is added.", "New address is not added","FAIL",runManagerInfoObj);
									blnFlag = false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify all the address fields are displayed.", "All the address fields are not displayed","FAIL",runManagerInfoObj);
								blnFlag = false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Add Address option is displayed and clicked. ", "Add Address option is not displayed and clicked","FAIL",runManagerInfoObj);
							blnFlag = false;
						}			
					}
					
					catch(Exception e)
					{
						repfn.FnUpdateTestStepResHTML("Verify if user is able to cancel adding address to new contact and verify"," User is not able to cancel adding address to new contact and verify due to some exception", "FAIL",runManagerInfoObj);
						blnFlag=false;
						System.err.println("Message : "+e.getMessage());
						System.err.println("Cause : "+e.getCause());
					}
					
					m1.put("STEPSTATUS", blnFlag);
					return blnFlag;
					
				}

			 public synchronized boolean FnRemoveAddressAndSave(WebDriver driver, RunManagerInfo runManagerInfoObj){
				 
				 String fullName = "";
				 String AddressStreetValue = "";
					try{
						
						Thread.sleep(3000);

						FnOpenEditUserPage(driver,runManagerInfoObj);
						
						WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
						String newNameFirst = FirstName.getAttribute("value");
						WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
						String lastNameFirst = lastName.getAttribute("value");
						
						if(cnf.FnExplicitWait("XPATH", mbo.addressStreet,driver)){
							List<WebElement> addressStreet=driver.findElements(By.xpath(mbo.addressStreet));
							if(addressStreet.get(0).isDisplayed()){
								 AddressStreetValue = addressStreet.get(0).getAttribute("value");
							}
						}
										
						FnDeleteAddress(driver,runManagerInfoObj);
						
						fullName = newNameFirst+" "+lastNameFirst;
						driver.manage().window().setSize(new Dimension(100, 100));
						driver.manage().window().maximize();
						
						app.FnSaveDataAndGoBack(driver,runManagerInfoObj);
						
						cnf.scrollUp(driver);

						if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
							WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
							cnf.ScrollToView(Search_Field,driver);
							Search_Field.sendKeys(fullName);
							repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
							Thread.sleep(2000);

							List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
							if(Contacts_Arrow.get(0).isDisplayed()){
								repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
								if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
									repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
									if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
										repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

										Thread.sleep(2000);

										if(cnf.FnExplicitWait("XPATH",mbo.UserAddressVerification,driver)){
											List<WebElement> UserAddressVerification=driver.findElements(By.xpath(mbo.UserAddressVerification));
											cnf.ScrollToView(UserAddressVerification.get(0),driver);
											if(cnf.FnExplicitWait("XPATH",mbo.UserAddressStreetVerification,driver)){
												List<WebElement> UserAddressStreetVerification=driver.findElements(By.xpath(mbo.UserAddressStreetVerification));
												WebElement UserStreetAddress=UserAddressStreetVerification.get(0);
												if(!UserStreetAddress.getText().equalsIgnoreCase(AddressStreetValue)){
													repfn.FnUpdateTestStepResHTML("Verify Address is Removed ", "Address is Removed","PASS",runManagerInfoObj);
													blnFlag=true;
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify Address is Removed ", "Address is not Removed","FAIL",runManagerInfoObj);
													blnFlag=false;
												}
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Address is Removed ", "Address is Removed","PASS",runManagerInfoObj);
											blnFlag=true;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						
						
					}
					
					catch(Exception e)
					{
						repfn.FnUpdateTestStepResHTML("Verify if user is able to remove the address added to new contact"," User is not able to remove the address added to new contact due to some exception", "FAIL",runManagerInfoObj);
						blnFlag=false;
						System.err.println("Message : "+e.getMessage());
						System.err.println("Cause : "+e.getCause());
					}
					
					m1.put("STEPSTATUS", blnFlag);
					return blnFlag;
					
				}
			 
			 public synchronized boolean FnAddContact_AddAddressSave_RemoveAddressAndVerify(WebDriver driver, RunManagerInfo runManagerInfoObj){

				 String fullName = "";
				 String AddressStreetValue = "";

				 try{

					 Thread.sleep(2000);
					 if(cnf.FnExplicitWait("XPATH", mbo.EditMode_firstName,driver)){
						 WebElement firstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
						 if(firstName.isDisplayed()){
							 String oldFirstName = firstName.getAttribute("value");
							 firstName.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"Manavi"+randomInt);
							 String newFirstName = firstName.getAttribute("value");
							 if(newFirstName != oldFirstName){
								 repfn.FnUpdateTestStepResHTML("Verify First Name field is modified ","First Name field is modified","PASS",runManagerInfoObj); 
								 blnFlag	=true;
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify First Name field is modified ","First Name field is not modified","FAIL",runManagerInfoObj);
								 blnFlag	=false;
							 }

						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify First Name field is displayed ","First Name field is not displayed","FAIL",runManagerInfoObj);
						 blnFlag	=false;
					 }


					 //cnf.FnExplicitWait("XPATH", mbo.EditMode_firstName);   
					 WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
					 String newNameFirst = FirstName.getAttribute("value");


					 if(cnf.FnExplicitWait("XPATH", mbo.EditMode_LastName,driver)){
						 WebElement LastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
						 if(LastName.isDisplayed()){
							 String oldLastName = LastName.getAttribute("value");
							 LastName.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"Test");
							 String newLastName = LastName.getAttribute("value");
							 if(newLastName != oldLastName){
								 repfn.FnUpdateTestStepResHTML("Verify Last Name field is modified ","Last Name field is modified","PASS",runManagerInfoObj);
								 blnFlag=true;
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify Last Name field is modified ","Last Name field is not modified","FAIL",runManagerInfoObj);
								 blnFlag=false;
							 }

						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify Last Name field is displayed ","Last Name field is not displayed","FAIL",runManagerInfoObj);
						 blnFlag	=false;
					 }


					 //cnf.FnExplicitWait("XPATH", mbo.EditMode_LastName);   
					 WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
					 String newNameLast = lastName.getAttribute("value");

					 if(cnf.FnExplicitWait("XPATH", mbo.ContactTitle,driver)){
						 WebElement contactTitle=driver.findElement(By.xpath(mbo.ContactTitle));
						 if(contactTitle.isDisplayed()){
							 String oldTitle = contactTitle.getAttribute("value");
							 contactTitle.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"Developer");
							 String newTitle = contactTitle.getAttribute("value");
							 if(newTitle != oldTitle){
								 repfn.FnUpdateTestStepResHTML("Verify Contact Title field is modified ","Contact Title field is modified","PASS",runManagerInfoObj);
								 blnFlag=true;
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify Contact Title field is modified ","Contact Title field is not modified","FAIL",runManagerInfoObj);
								 blnFlag=false;	
							 }

						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify Contact Title field is displayed ","Contact Title field is not displayed","FAIL",runManagerInfoObj);
						 blnFlag=false;	
					 }



					 if(cnf.FnExplicitWait("XPATH", mbo.ContactCompany,driver)){
						 WebElement contactCompany=driver.findElement(By.xpath(mbo.ContactCompany));
						 if(contactCompany.isDisplayed()){
							 String oldCompany = contactCompany.getAttribute("value");
							 contactCompany.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"TestCo.");
							 String newCompany = contactCompany.getAttribute("value");
							 if(newCompany != oldCompany){
								 repfn.FnUpdateTestStepResHTML("Verify Contact Company field is modified ","Contact Company field is modified","PASS",runManagerInfoObj);
								 blnFlag=true;	
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify Contact Company field is modified ","Contact Company field is not modified","FAIL",runManagerInfoObj);
								 blnFlag=false;	
							 }

						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify Contact Company field is displayed ","Contact Company field is not displayed","FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }


					 boolean blnFlag1=FnClickAddAddress(driver,runManagerInfoObj);
					 if(blnFlag1){
						 boolean blnFlag2=FnCheckAddressFields(driver,runManagerInfoObj);
						 if(blnFlag2){				 
							 boolean blnFlag3=app.FnAddAddress(driver,runManagerInfoObj);
							 if(blnFlag3){
								 if(cnf.FnExplicitWait("XPATH", mbo.addressStreet,driver)){
									 List<WebElement> addressStreet=driver.findElements(By.xpath(mbo.addressStreet));
									 if(addressStreet.get(0).isDisplayed()){
										 AddressStreetValue = addressStreet.get(0).getAttribute("value");
									 }
								 }

								 driver.manage().window().setSize(new Dimension(100, 100));
								 driver.manage().window().maximize();


								 Thread.sleep(2000);
								 if(cnf.FnExplicitWait("XPATH", mbo.CancelEdit,driver)){
									 repfn.FnUpdateTestStepResHTML("Verify Cancel option is displayed ","Cancel option is displayed","PASS",runManagerInfoObj);
									 blnFlag=true;
								 }
								 else{
									 repfn.FnUpdateTestStepResHTML("Verify Cancel option is displayed ","Cancel option is not displayed","FAIL",runManagerInfoObj);
									 blnFlag=false;
								 }

								 Thread.sleep(2000);

								 fullName = newNameFirst+" "+newNameLast;

								 Thread.sleep(5000);

								 if(cnf.FnExplicitWait("XPATH", mbo.UserContactDetailsSave,driver)){
									 repfn.FnUpdateTestStepResHTML("Verify Save option is displayed ","Save option is displayed","PASS",runManagerInfoObj);
									 WebElement Save=driver.findElement(By.xpath(mbo. UserContactDetailsSave));
									 cnf.ScrollToView(Save,driver);

									 if(cnf.JSClick(Save,driver)){
										 repfn.FnUpdateTestStepResHTML("Verify Save option is clicked"," Save option is clicked","PASS",runManagerInfoObj);
										 if(cnf.FnExplicitWait("XPATH", mbo.SaveNotWorkingText,driver)){
											 repfn.FnUpdateTestStepResHTML("Verify Save functionality working or not","Save functionality not working","FAIL",runManagerInfoObj);
											 blnFlag=false;
											 if(cnf.FnExplicitWaitFeedback("XPATH", mbo.Cancel_Button,driver))
											 {
												 repfn.FnUpdateTestStepResHTML("Verify Close option is displayed"," Close option is displayed","PASS",runManagerInfoObj);
												 WebElement close=driver.findElement(By.xpath(mbo.Cancel_Button));
												 if(cnf.JSClick(close,driver)){
													 repfn.FnUpdateTestStepResHTML("Verify Close option is clicked"," Close option is clicked","PASS",runManagerInfoObj);
													 Thread.sleep(2000);
													 if(cnf.FnExplicitWait("XPATH", mbo.Confirm_btn,driver))
													 {
														 repfn.FnUpdateTestStepResHTML("Verify Confirm option is displayed"," Confirm option is displayed","PASS",runManagerInfoObj);
														 WebElement Confrm=driver.findElement(By.xpath(mbo.Confirm_btn));
														 System.out.println("click aftr save not working");
														 if(cnf.JSClick(Confrm,driver))
														 {
															 repfn.FnUpdateTestStepResHTML("Verify Confirm option is displayed"," Confirm option is displayed","PASS",runManagerInfoObj);
															 Thread.sleep(2000);
															 driver.navigate().refresh();
															 Thread.sleep(2000);
															 repfn.FnUpdateTestStepResHTML("Verify User is moved back to call logs page","User is moved back to call logs page","PASS",runManagerInfoObj);
															 blnFlag=false;
														 }
														 else{
															 repfn.FnUpdateTestStepResHTML("Verify Confirm option is clicked"," Confirm option is not clicked","FAIL",runManagerInfoObj);
															 blnFlag=false;
														 }
													 }
													 else{
														 repfn.FnUpdateTestStepResHTML("Verify Confirm option is displayed"," Confirm option is not displayed","FAIL",runManagerInfoObj);
														 blnFlag=false;
													 }

												 }
												 else{
													 repfn.FnUpdateTestStepResHTML("Verify Close option is clicked"," Close option is not clicked","FAIL",runManagerInfoObj);
													 blnFlag=false;
												 }
											 }
											 else{
												 repfn.FnUpdateTestStepResHTML("Verify Close option is displayed"," Close option is not displayed","FAIL",runManagerInfoObj);
												 blnFlag=false;
											 }
										 }
										 else{
											 blnFlag=true;	
											 Thread.sleep(7000);

											 if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
												 WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
												 cnf.ScrollToView(Search_Field,driver);
												 Search_Field.clear();
												 Search_Field.sendKeys(fullName);
												 Thread.sleep(3000);
												 //cnf.FnExplicitWait("XPATH", mbo.contactNameList);

												 if(cnf.FnExplicitWait("XPATH", mbo.contactNameList,driver)){
													 List<WebElement> contactNameList= driver.findElements(By.xpath(mbo.contactNameList));
													 repfn.FnUpdateTestStepResHTML("Verify Contact is present in the Contacts List with Name as: "+fullName," Contact is present in the Contacts List with Name as: "+fullName,"PASS",runManagerInfoObj);
													 if(contactNameList.get(0).getText().equalsIgnoreCase(fullName)){
														 repfn.FnUpdateTestStepResHTML("Verify Newly added Contact is added to Contacts list", "Newly added Contact is added to Contacts list","PASS",runManagerInfoObj);
														 List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
														 if(Contacts_Arrow.get(0).isDisplayed()){
															 if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
																 repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
																 if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
																	 repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

																	 Thread.sleep(3000);

																	 if(cnf.FnExplicitWait("XPATH",mbo.UserAddressVerification,driver)){
																		 List<WebElement> UserAddressVerification=driver.findElements(By.xpath(mbo.UserAddressVerification));
																		 cnf.ScrollToView(UserAddressVerification.get(0),driver);
																		 if(cnf.FnExplicitWait("XPATH",mbo.UserAddressStreetVerification,driver)){
																			 List<WebElement> UserAddressStreetVerification=driver.findElements(By.xpath(mbo.UserAddressStreetVerification));
																			 WebElement UserStreetAddress=UserAddressStreetVerification.get(0);
																			 if(UserStreetAddress.getText().equalsIgnoreCase(AddressStreetValue)){
																				 repfn.FnUpdateTestStepResHTML("Verify Address is added to Newly added contact", "Address is added to Newly added contact","PASS",runManagerInfoObj);

																				 Thread.sleep(2000);
																				 boolean blnFlag4=FnOpenEditUserPage(driver,runManagerInfoObj);
																				 if(blnFlag4){
																					 boolean blnFlag5=FnDeleteAddress(driver,runManagerInfoObj);
																					 if(blnFlag5){
																						 Thread.sleep(2000);
																						 if(cnf.FnExplicitWait("XPATH", mbo.UserContactDetailsSave,driver)){
																							 repfn.FnUpdateTestStepResHTML("Verify Save link is displayed in Edit Contact form"," Save link is displayed in Edit Contact form","PASS",runManagerInfoObj);
																							 WebElement UserContactDetailsSave=driver.findElement(By.xpath(mbo.UserContactDetailsSave));
																							 if(cnf.JSClick(UserContactDetailsSave,driver)){
																								 repfn.FnUpdateTestStepResHTML("Verify Save link is clicked in Edit Contact form"," Save link is clicked in Edit Contact form","PASS",runManagerInfoObj);
																								 if(cnf.FnExplicitWait("XPATH", mbo.SaveNotWorkingText,driver)){
																									 repfn.FnUpdateTestStepResHTML("Verify Save functionality working or not","Save functionality not working","FAIL",runManagerInfoObj);
																									 blnFlag=false;
																									 if(cnf.FnExplicitWaitFeedback("XPATH", mbo.Cancel_Button,driver))
																									 {
																										 repfn.FnUpdateTestStepResHTML("Verify Close option is displayed"," Close option is displayed","PASS",runManagerInfoObj);
																										 WebElement close=driver.findElement(By.xpath(mbo.Cancel_Button));
																										 if(cnf.JSClick(close,driver)){
																											 repfn.FnUpdateTestStepResHTML("Verify Close option is clicked"," Close option is clicked","PASS",runManagerInfoObj);
																											 Thread.sleep(2000);
																											 if(cnf.FnExplicitWait("XPATH", mbo.Confirm_btn,driver))
																											 {
																												 repfn.FnUpdateTestStepResHTML("Verify Confirm option is displayed"," Confirm option is displayed","PASS",runManagerInfoObj);
																												 WebElement Confrm=driver.findElement(By.xpath(mbo.Confirm_btn));
																												 System.out.println("click aftr save not working");
																												 if(cnf.JSClick(Confrm,driver))
																												 {
																													 repfn.FnUpdateTestStepResHTML("Verify Confirm option is displayed"," Confirm option is displayed","PASS",runManagerInfoObj);
																													 Thread.sleep(2000);
																													 driver.navigate().refresh();
																													 Thread.sleep(2000);
																													 repfn.FnUpdateTestStepResHTML("Verify User is moved back to call logs page","User is moved back to call logs page","PASS",runManagerInfoObj);
																													 blnFlag=false;
																												 }
																												 else{
																													 repfn.FnUpdateTestStepResHTML("Verify Confirm option is clicked"," Confirm option is not clicked","FAIL",runManagerInfoObj);
																													 blnFlag=false;
																												 }
																											 }
																											 else{
																												 repfn.FnUpdateTestStepResHTML("Verify Confirm option is displayed"," Confirm option is not displayed","FAIL",runManagerInfoObj);
																												 blnFlag=false;
																											 }

																										 }
																										 else{
																											 repfn.FnUpdateTestStepResHTML("Verify Close option is clicked"," Close option is not clicked","FAIL",runManagerInfoObj);
																											 blnFlag=false;
																										 }
																									 }
																									 else{
																										 repfn.FnUpdateTestStepResHTML("Verify Close option is displayed"," Close option is not displayed","FAIL",runManagerInfoObj);
																										 blnFlag=false;
																									 }
																								 }
																								 else{
																									 blnFlag	=true;
																									 Thread.sleep(5000);

																									 if(cnf.FnExplicitWait("XPATH",mbo.UserAddressVerification,driver)){
																										 repfn.FnUpdateTestStepResHTML("Verify Address is removed ", "Address is not removed","FAIL",runManagerInfoObj);
																										 blnFlag	=false;
																									 }
																									 else{
																										 repfn.FnUpdateTestStepResHTML("Verify Address is removed ", "Address is removed","PASS",runManagerInfoObj);
																										 blnFlag	=true;
																									 }
																								 }
																							 }
																							 else{
																								 repfn.FnUpdateTestStepResHTML("Verify Save link is clicked in Edit Contact form"," Save link is not clicked in Edit Contact form","FAIL",runManagerInfoObj);
																								 blnFlag	=false;
																							 }
																						 }
																						 else{
																							 repfn.FnUpdateTestStepResHTML("Verify Save link is displayed in Edit Contact form"," Save link is not displayed in Edit Contact form","FAIL",runManagerInfoObj);
																							 blnFlag	=false;
																						 }
																					 }
																					 else{
																						 repfn.FnUpdateTestStepResHTML("Verify if the user is able to delete the address. ", "User is not able to delete the address","FAIL",runManagerInfoObj);
																						 blnFlag	=false;
																					 }
																				 }
																				 else{
																					 repfn.FnUpdateTestStepResHTML("Verify Edit Mode form is displayed after clicking Edit button "," Edit Mode form is not displayed after clicking Edit button","FAIL",runManagerInfoObj);
																					 blnFlag=false;
																				 }
																			 }
																			 else{
																				 repfn.FnUpdateTestStepResHTML("Verify Address is added to Newly added contact ", "Address is not added to Newly added contact","FAIL",runManagerInfoObj);
																				 blnFlag=false;
																			 }
																		 }
																	 }
																	 else{
																		 repfn.FnUpdateTestStepResHTML("Verify Address is added ", "Address is not added","FAIL",runManagerInfoObj);
																		 blnFlag=false;
																	 }
																 }
																 else{
																	 repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
																	 blnFlag=false;
																 }
															 }
															 else{
																 repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
																 blnFlag	= false;
															 }
														 }
														 else{
															 repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is displayed","User Details Arrow is displayed","FAIL",runManagerInfoObj);
															 blnFlag	= false;
														 }
													 }
													 else{
														 repfn.FnUpdateTestStepResHTML("Verify Newly added is added to Contacts list", "Newly added Contact is not added to Contacts list","FAIL",runManagerInfoObj);
														 blnFlag	= false;
													 }
												 }
												 else{
													 repfn.FnUpdateTestStepResHTML("Verify Contact is present in the Contacts List with Name as: "+fullName," Contact is not present in the Contacts List with Name as: "+fullName,"FAIL",runManagerInfoObj);
													 blnFlag	= false;
												 }
											 }
											 else{
												 repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ","Search field is not displayed","FAIL",runManagerInfoObj);
												 blnFlag=false;
											 }
										 }
									 }
									 else{
										 repfn.FnUpdateTestStepResHTML("Verify Save option is clicked"," Save option is not clicked","FAIL",runManagerInfoObj);
										 blnFlag=false;	
									 }
								 }else{
									 repfn.FnUpdateTestStepResHTML("Verify Save option is displayed"," Save option is not displayed","FAIL",runManagerInfoObj);
									 blnFlag=false;
								 }
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify new address is added.", "New address is not added","FAIL",runManagerInfoObj);
								 blnFlag = false;
							 }
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify all the address fields are displayed.", "All the address fields are not displayed","FAIL",runManagerInfoObj);
							 blnFlag = false;
						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify Add Address option is displayed and clicked. ", "Add Address option is not displayed and clicked","FAIL",runManagerInfoObj);
						 blnFlag = false;
					 }
				 }

				 catch(Exception e)
				 {
					 repfn.FnUpdateTestStepResHTML("Verify if user is able to add a new contact"," User is not able to add a new contact due to some exception", "FAIL",runManagerInfoObj);
					 blnFlag=false;
					 System.err.println("Message : "+e.getMessage());
					 System.err.println("Cause : "+e.getCause());
				 }

				 m1.put("STEPSTATUS", blnFlag);
				 return blnFlag;

			 }
		public synchronized boolean FnVerifyAddAddressOption(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
			int listSize = 0;
			try{


				if(cnf.FnExplicitWait("XPATH", mbo.AddressList,driver)){
					List<WebElement> addressCount= driver.findElements(By.xpath(mbo.AddressList));
					listSize = addressCount.size();
					if(listSize == 0 || listSize == 1){
						blnFlag	= true;
					}
					else if(listSize == 2){
						FnClickAddAddress(driver,runManagerInfoObj);
						blnFlag	= true;
					}
				}
				else{
					blnFlag	= true;
				}
			}


			catch(Exception e)
			{

				repfn.FnUpdateTestStepResHTML("Verify Add Address option is displayed in Edit Contact form.", "Add Address option is not displayed in Edit Contact form due to some exception.","FAIL",runManagerInfoObj);
				blnFlag	=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());

			}

			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}
		
		public synchronized boolean FnVerifyAddEmailOption(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
			int listSize = 0;
			try{


				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
					List<WebElement> Addcontact_EmailInputText= driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
					listSize = Addcontact_EmailInputText.size();
					if(listSize == 0 || listSize == 1){
						blnFlag	= true;
					}
					else if(listSize == 2){
						FnClickAddEmailAddress(driver,runManagerInfoObj);
						blnFlag	= true;
					}
				}
				else{
					blnFlag	= true;
				}
			}


			catch(Exception e)
			{

				repfn.FnUpdateTestStepResHTML("Verify Add Email Address option is displayed in Edit Contact form.", "Add Email Address option is not displayed in Edit Contact form due to some exception.","FAIL",runManagerInfoObj);
				blnFlag	=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());

			}

			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}
		public synchronized boolean FnClickAddEmailAddress(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

			try{

				Thread.sleep(5000);
				if(cnf.FnExplicitWait("XPATH", mbo.addEmailButton,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Add Email address option is displayed ", "Add Email address option is displayed","PASS",runManagerInfoObj);
					((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(mbo.addEmailButton)));   
					driver.manage().window().setSize(new Dimension(100, 100));
					driver.manage().window().maximize();
					WebElement addEmailButton=driver.findElement(By.xpath(mbo.addEmailButton));
					if(cnf.JSClick(addEmailButton,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Add Email address option is clicked ", "Add Email address option is clicked","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Add Email address option is clicked ", "Add Email address option is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Add Email address option is displayed","Add Email address option is not displayed. All the Email addresses are already added. ","PASS",runManagerInfoObj);			
					if(cnf.FnExplicitWait("XPATH", mbo.deleteIcon,driver)){
						List<WebElement> deleteAddressList= driver.findElements(By.xpath(mbo.deleteIcon));
						repfn.FnUpdateTestStepResHTML("Verify Delete Email address option is displayed ", "Delete Email address option is displayed","PASS",runManagerInfoObj);
						WebElement deleteAddress = deleteAddressList.get(0);
						if(cnf.JSClick(deleteAddress,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Delete Email address option is clicked ", "Delete Email address option is clicked","PASS",runManagerInfoObj);
							blnFlag=true;					
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Delete Email address option is clicked ", "Delete Email address option is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}

					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Delete Email address option is displayed ", "Delete Email address option is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
			}

			catch(Exception e)
			{
				repfn.FnUpdateTestStepResHTML("Verify Add Email Address option is clicked. ", "Add Email Address option is not clicked due to some exception.","FAIL",runManagerInfoObj);
				blnFlag	=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}

			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		
	
		public synchronized boolean FnAddEmailAddress(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
			int listSize = 0;
			try{

				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
					List<WebElement> addressCount= driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
					listSize = addressCount.size();
				}

				System.out.println(listSize);

				if(listSize == 1){
					if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
						List<WebElement> Addcontact_EmailInputText=driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
						if(Addcontact_EmailInputText.get(0).isDisplayed()){
							String oldAddressValue = Addcontact_EmailInputText.get(0).getAttribute("value");
							System.out.println("old value: " +oldAddressValue);
							Addcontact_EmailInputText.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"abc"+randomInt+"@gmail.com");
							String newAddressValue = Addcontact_EmailInputText.get(0).getAttribute("value");
							System.out.println("new value: " +newAddressValue);
							if(newAddressValue != oldAddressValue){
								repfn.FnUpdateTestStepResHTML("Verify Email Address value is modified "," Email Address value is modified ","PASS",runManagerInfoObj);
								blnFlag	= true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Email Address value is modified "," Email Address value is not modified ","FAIL",runManagerInfoObj);
								blnFlag = false;
							}
						}

					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Email Address field is displayed "," Email Address field is not displayed ","FAIL",runManagerInfoObj);
						blnFlag = false;
					}
				}

				if(listSize == 2){
					if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
						List<WebElement> Addcontact_EmailInputText=driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
						if(Addcontact_EmailInputText.get(1).isDisplayed()){
							String oldAddressValue = Addcontact_EmailInputText.get(1).getAttribute("value");
							System.out.println("old value: " +oldAddressValue);
							Addcontact_EmailInputText.get(1).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"ijk"+randomInt+"@gmail.com");
							String newAddressValue = Addcontact_EmailInputText.get(1).getAttribute("value");
							System.out.println("new value: " +newAddressValue);
							if(newAddressValue != oldAddressValue){
								repfn.FnUpdateTestStepResHTML("Verify Email Address value is modified "," Email Address value is modified ","PASS",runManagerInfoObj);
								blnFlag	= true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Email Address value is modified "," Email Address value is not modified ","FAIL",runManagerInfoObj);
								blnFlag = false;
							}
						}

					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Email Address field is displayed "," Email Address field is not displayed ","FAIL",runManagerInfoObj);
						blnFlag = false;
					}
				}

			}

			catch(Exception e)
			{

				repfn.FnUpdateTestStepResHTML("Verify new email address is added.", "New email address is not added due to some exception.","FAIL",runManagerInfoObj);
				blnFlag	=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());

			}

			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		
		public synchronized boolean FnAddAddress_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

			int listSize = 0;
			String street = "";
			String fullName = "";
			try{

				if(cnf.FnExplicitWait("XPATH", mbo.AddressList,driver)){
					List<WebElement> addressCount= driver.findElements(By.xpath(mbo.AddressList));
					listSize = addressCount.size();
				}

				System.out.println(listSize);

				if(listSize == 1){

					WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
					String newNameFirst = FirstName.getAttribute("value");
					WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
					String lastNameFirst = lastName.getAttribute("value");

					if(cnf.FnExplicitWait("XPATH", mbo.addressStreet,driver)){
						List<WebElement> addressStreet=driver.findElements(By.xpath(mbo.addressStreet));
						if(addressStreet.get(0).isDisplayed()){
							String oldAddressStreetValue = addressStreet.get(0).getAttribute("value");
							System.out.println("old value: " +oldAddressStreetValue);
							repfn.FnUpdateTestStepResHTML("Verify the old address", "The old address is : "+oldAddressStreetValue, "PASS",runManagerInfoObj);
							addressStreet.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"12,"+randomInt+"Manning Street");
							String newAddressStreetValue = addressStreet.get(0).getAttribute("value");
							System.out.println("new value: " +newAddressStreetValue);
							repfn.FnUpdateTestStepResHTML("Modify the address", "Address after modification is : "+newAddressStreetValue, "PASS",runManagerInfoObj);
							if(newAddressStreetValue != oldAddressStreetValue){
								repfn.FnUpdateTestStepResHTML("Verify Address Street value is modified "," Address Street value is modified ","PASS",runManagerInfoObj);

								blnFlag	= true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Address Street value is modified "," Address Street value is not modified ","FAIL",runManagerInfoObj);
								blnFlag = false;
							}
						}

						street = addressStreet.get(0).getAttribute("value");
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Address Street field is displayed "," Address Street field is not displayed ","FAIL",runManagerInfoObj);
						blnFlag = false;
					}



					if(cnf.FnExplicitWait("XPATH", mbo.city,driver)){
						List<WebElement> city=driver.findElements(By.xpath(mbo.city));
						if(city.get(0).isDisplayed()){
							String oldCityValue = city.get(0).getAttribute("value");
							System.out.println("old value: " +oldCityValue);
							city.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"NY");
							String newCityValue = city.get(0).getAttribute("value");
							System.out.println("new value: " +newCityValue);
							if(newCityValue != oldCityValue){
								repfn.FnUpdateTestStepResHTML("Verify City value is modified "," City value is modified ","PASS",runManagerInfoObj);
								blnFlag	= true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify City value is modified "," City value is not modified ","FAIL",runManagerInfoObj);
								blnFlag	=false;
							}
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify City field is displayed "," City field is not displayed ","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}


					if(cnf.FnExplicitWait("XPATH", mbo.state,driver)){
						List<WebElement> state=driver.findElements(By.xpath(mbo.state));
						if(state.get(0).isDisplayed()){
							String oldStateValue = state.get(0).getAttribute("value");
							System.out.println("old value: " +oldStateValue);
							state.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"NY");
							String newStateValue = state.get(0).getAttribute("value");
							System.out.println("new value: " +newStateValue);
							if(newStateValue != oldStateValue){
								repfn.FnUpdateTestStepResHTML("Verify State value is modified "," State value is modified ","PASS",runManagerInfoObj);	
								blnFlag	= true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify State value is modified "," State value is not modified ","FAIL",runManagerInfoObj);
								blnFlag	=false;
							}
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify State field is displayed "," State field is not displayed ","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}


					if(cnf.FnExplicitWait("XPATH", mbo.zip,driver)){
						List<WebElement> zip=driver.findElements(By.xpath(mbo.zip));
						if(zip.get(0).isDisplayed()){
							String oldZipValue = zip.get(0).getAttribute("value");
							System.out.println("old value: " +oldZipValue);
							zip.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"16004");
							String newZipValue = zip.get(0).getAttribute("value");
							System.out.println("new value: " +newZipValue);
							if(newZipValue != oldZipValue){
								repfn.FnUpdateTestStepResHTML("Verify Zip value is modified "," Zip value is modified ","PASS",runManagerInfoObj);
								blnFlag	= true;		
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Zip value is modified "," Zip value is not modified ","FAIL",runManagerInfoObj);
								blnFlag	=false;
							}
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Zip field is displayed "," Zip field is not displayed ","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}


					if(cnf.FnExplicitWait("XPATH", mbo.country,driver)){
						List<WebElement> country=driver.findElements(By.xpath(mbo.country));
						if(country.get(0).isDisplayed()){
							String oldCountryValue = country.get(0).getAttribute("value");
							System.out.println("old value: " +oldCountryValue);
							country.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"USA");
							String newCountryValue = country.get(0).getAttribute("value");
							System.out.println("new value: " +newCountryValue);
							if(newCountryValue != oldCountryValue){
								repfn.FnUpdateTestStepResHTML("Verify Country value is modified "," Country value is modified ","PASS",runManagerInfoObj);
								blnFlag = true;			
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Country value is modified "," Country value is not modified ","FAIL",runManagerInfoObj);
								blnFlag	=false;
							}	
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Country field is displayed "," Country field is not displayed ","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}

					fullName = newNameFirst+" "+lastNameFirst;
					driver.manage().window().setSize(new Dimension(100, 100));
					driver.manage().window().maximize();
					boolean blnFlag1=FnCancelAndGoBack(driver,runManagerInfoObj);

					cnf.scrollUp(driver);

					if(blnFlag1==true){
						if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
							WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
							cnf.ScrollToView(Search_Field,driver);
							Search_Field.sendKeys(fullName);
							repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
							Thread.sleep(2000);

							List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
							if(Contacts_Arrow.get(0).isDisplayed()){
								repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
								if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
									repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
									if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
										repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

										Thread.sleep(2000);

										if(cnf.FnExplicitWait("XPATH",mbo.UserAddressVerification,driver)){
											List<WebElement> UserAddressVerification=driver.findElements(By.xpath(mbo.UserAddressVerification));
											cnf.ScrollToView(UserAddressVerification.get(0),driver);
											if(cnf.FnExplicitWait("XPATH",mbo.UserAddressStreetVerification,driver)){
												List<WebElement> UserAddressStreetVerification=driver.findElements(By.xpath(mbo.UserAddressStreetVerification));
												WebElement UserStreetAddress=UserAddressStreetVerification.get(0);
												if(!UserStreetAddress.getText().contains(street))
												{
													repfn.FnUpdateTestStepResHTML("Verify New Address is added or not ", "New Address is not added","PASS",runManagerInfoObj);
													blnFlag=true;
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify New Address is added or not", "New Address is added","FAIL",runManagerInfoObj);
													blnFlag=false;
												}
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify New Address is displayed in User Details form", "New Address is not displayed in User Details form","PASS",runManagerInfoObj);
											blnFlag=true;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ","Search field is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify if the user is able to cancel the changes in Edit Contact form. ", "User is not able to cancel the changes in Edit Contact form","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}


				}

				if(listSize == 2){
					WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
					String newNameFirst = FirstName.getAttribute("value");
					WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
					String lastNameFirst = lastName.getAttribute("value");

					if(cnf.FnExplicitWait("XPATH", mbo.addressStreet1,driver)){
						List<WebElement> addressStreet=driver.findElements(By.xpath(mbo.addressStreet1));
						if(addressStreet.get(0).isDisplayed()){
							String oldAddressStreetValue = addressStreet.get(0).getAttribute("value");
							System.out.println("old value: " +oldAddressStreetValue);
							addressStreet.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"12,"+randomInt+"Denver Street");
							String newAddressStreetValue = addressStreet.get(0).getAttribute("value");
							System.out.println("new value: " +newAddressStreetValue);
							if(newAddressStreetValue != oldAddressStreetValue){
								repfn.FnUpdateTestStepResHTML("Verify Address Street value is modified "," Address Street value is modified ","PASS",runManagerInfoObj);
								blnFlag	= true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Address Street value is modified "," Address Street value is not modified ","FAIL",runManagerInfoObj);
								blnFlag = false;
							}
						}

						street = addressStreet.get(0).getAttribute("value");
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Address Street field is displayed "," Address Street field is not displayed ","FAIL",runManagerInfoObj);
						blnFlag = false;
					}



					if(cnf.FnExplicitWait("XPATH", mbo.city1,driver)){
						List<WebElement> city=driver.findElements(By.xpath(mbo.city1));
						if(city.get(0).isDisplayed()){
							String oldCityValue = city.get(0).getAttribute("value");
							System.out.println("old value: " +oldCityValue);
							city.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"NY");
							String newCityValue = city.get(0).getAttribute("value");
							System.out.println("new value: " +newCityValue);
							if(newCityValue != oldCityValue){
								repfn.FnUpdateTestStepResHTML("Verify City value is modified "," City value is modified ","PASS",runManagerInfoObj);
								blnFlag	= true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify City value is modified "," City value is not modified ","FAIL",runManagerInfoObj);
								blnFlag	=false;
							}
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify City field is displayed "," City field is not displayed ","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}


					if(cnf.FnExplicitWait("XPATH", mbo.state1,driver)){
						List<WebElement> state=driver.findElements(By.xpath(mbo.state1));
						if(state.get(0).isDisplayed()){
							String oldStateValue = state.get(0).getAttribute("value");
							System.out.println("old value: " +oldStateValue);
							state.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"NY");
							String newStateValue = state.get(0).getAttribute("value");
							System.out.println("new value: " +newStateValue);
							if(newStateValue != oldStateValue){
								repfn.FnUpdateTestStepResHTML("Verify State value is modified "," State value is modified ","PASS",runManagerInfoObj);	
								blnFlag	= true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify State value is modified "," State value is not modified ","FAIL",runManagerInfoObj);
								blnFlag	=false;
							}
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify State field is displayed "," State field is not displayed ","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}


					if(cnf.FnExplicitWait("XPATH", mbo.zip1,driver)){
						List<WebElement> zip=driver.findElements(By.xpath(mbo.zip1));
						if(zip.get(0).isDisplayed()){
							String oldZipValue = zip.get(0).getAttribute("value");
							System.out.println("old value: " +oldZipValue);
							zip.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"16004");
							String newZipValue = zip.get(0).getAttribute("value");
							System.out.println("new value: " +newZipValue);
							if(newZipValue != oldZipValue){
								repfn.FnUpdateTestStepResHTML("Verify Zip value is modified "," Zip value is modified ","PASS",runManagerInfoObj);
								blnFlag	= true;		
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Zip value is modified "," Zip value is not modified ","FAIL",runManagerInfoObj);
								blnFlag	=false;
							}
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Zip field is displayed "," Zip field is not displayed ","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}


					if(cnf.FnExplicitWait("XPATH", mbo.country1,driver)){
						List<WebElement> country=driver.findElements(By.xpath(mbo.country1));
						if(country.get(0).isDisplayed()){
							String oldCountryValue = country.get(0).getAttribute("value");
							System.out.println("old value: " +oldCountryValue);
							country.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"USA");
							String newCountryValue = country.get(0).getAttribute("value");
							System.out.println("new value: " +newCountryValue);
							if(newCountryValue != oldCountryValue){
								repfn.FnUpdateTestStepResHTML("Verify Country value is modified "," Country value is modified ","PASS",runManagerInfoObj);
								blnFlag = true;			
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Country value is modified "," Country value is not modified ","FAIL",runManagerInfoObj);
								blnFlag	=false;
							}	
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Country field is displayed "," Country field is not displayed ","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}

					fullName = newNameFirst+" "+lastNameFirst;
					driver.manage().window().setSize(new Dimension(100, 100));
					driver.manage().window().maximize();
					boolean blnFlag2=FnCancelAndGoBack(driver,runManagerInfoObj);

					cnf.scrollUp(driver);
					if(blnFlag2==true)
					{
						if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
							WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
							cnf.ScrollToView(Search_Field,driver);
							Search_Field.sendKeys(fullName);
							repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
							Thread.sleep(2000);

							List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
							if(Contacts_Arrow.get(0).isDisplayed()){
								repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
								if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
									repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
									if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
										repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

										Thread.sleep(2000);

										if(cnf.FnExplicitWait("XPATH",mbo.UserAddressVerification,driver)){
											List<WebElement> UserAddressVerification=driver.findElements(By.xpath(mbo.UserAddressVerification));
											cnf.ScrollToView(UserAddressVerification.get(1),driver);
											if(cnf.FnExplicitWait("XPATH",mbo.UserAddressStreetVerification,driver)){
												List<WebElement> UserAddressStreetVerification=driver.findElements(By.xpath(mbo.UserAddressStreetVerification));
												WebElement UserStreetAddress=UserAddressStreetVerification.get(1);
												if(!UserStreetAddress.getText().contains(street))
												{
													repfn.FnUpdateTestStepResHTML("Verify New Address is added or not ", "New Address is not added","PASS",runManagerInfoObj);
													blnFlag=true;
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify New Address is added or not", "New Address is added","FAIL",runManagerInfoObj);
													blnFlag=false;
												}
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify New Address is displayed in User Details form", "New Address is not displayed in User Details form","PASS",runManagerInfoObj);
											blnFlag=true;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ","Search field is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify if the user is able to cancel the changes in Edit Contact form. ", "User is not able to cancel the changes in Edit Contact form","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
				}		
			}

			catch(Exception e)
			{
				repfn.FnUpdateTestStepResHTML("Verify new address is added.", "New address is not added due to some exception.","FAIL",runManagerInfoObj);
				blnFlag	=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}

			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		
		public synchronized boolean FnAddAddress_Save(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

			int listSize = 0;
			String street = "";
			String fullName = "";
			try{

				if(cnf.FnExplicitWait("XPATH", mbo.AddressList,driver)){
					List<WebElement> addressCount= driver.findElements(By.xpath(mbo.AddressList));
					listSize = addressCount.size();
				}

				System.out.println(listSize);

				if(listSize == 1){

					WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
					String newNameFirst = FirstName.getAttribute("value");
					WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
					String lastNameFirst = lastName.getAttribute("value");

					if(cnf.FnExplicitWait("XPATH", mbo.addressStreet,driver)){
						List<WebElement> addressStreet=driver.findElements(By.xpath(mbo.addressStreet));
						if(addressStreet.get(0).isDisplayed()){
							String oldAddressStreetValue = addressStreet.get(0).getAttribute("value");
							System.out.println("old value: " +oldAddressStreetValue);
							addressStreet.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"12,"+randomInt+"Roman Street");
							String newAddressStreetValue = addressStreet.get(0).getAttribute("value");
							System.out.println("new value: " +newAddressStreetValue);
							if(newAddressStreetValue != oldAddressStreetValue){
								repfn.FnUpdateTestStepResHTML("Verify Address Street value is modified "," Address Street value is modified ","PASS",runManagerInfoObj);
								blnFlag	= true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Address Street value is modified "," Address Street value is not modified ","FAIL",runManagerInfoObj);
								blnFlag = false;
							}
						}

						street = addressStreet.get(0).getAttribute("value");
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Address Street field is displayed "," Address Street field is not displayed ","FAIL",runManagerInfoObj);
						blnFlag = false;
					}



					if(cnf.FnExplicitWait("XPATH", mbo.city,driver)){
						List<WebElement> city=driver.findElements(By.xpath(mbo.city));
						if(city.get(0).isDisplayed()){
							String oldCityValue = city.get(0).getAttribute("value");
							System.out.println("old value: " +oldCityValue);
							city.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"NY");
							String newCityValue = city.get(0).getAttribute("value");
							System.out.println("new value: " +newCityValue);
							if(newCityValue != oldCityValue){
								repfn.FnUpdateTestStepResHTML("Verify City value is modified "," City value is modified ","PASS",runManagerInfoObj);
								blnFlag	= true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify City value is modified "," City value is not modified ","FAIL",runManagerInfoObj);
								blnFlag	=false;
							}
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify City field is displayed "," City field is not displayed ","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}


					if(cnf.FnExplicitWait("XPATH", mbo.state,driver)){
						List<WebElement> state=driver.findElements(By.xpath(mbo.state));
						if(state.get(0).isDisplayed()){
							String oldStateValue = state.get(0).getAttribute("value");
							System.out.println("old value: " +oldStateValue);
							state.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"NY");
							String newStateValue = state.get(0).getAttribute("value");
							System.out.println("new value: " +newStateValue);
							if(newStateValue != oldStateValue){
								repfn.FnUpdateTestStepResHTML("Verify State value is modified "," State value is modified ","PASS",runManagerInfoObj);	
								blnFlag	= true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify State value is modified "," State value is not modified ","FAIL",runManagerInfoObj);
								blnFlag	=false;
							}
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify State field is displayed "," State field is not displayed ","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}


					if(cnf.FnExplicitWait("XPATH", mbo.zip,driver)){
						List<WebElement> zip=driver.findElements(By.xpath(mbo.zip));
						if(zip.get(0).isDisplayed()){
							String oldZipValue = zip.get(0).getAttribute("value");
							System.out.println("old value: " +oldZipValue);
							zip.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"16004");
							String newZipValue = zip.get(0).getAttribute("value");
							System.out.println("new value: " +newZipValue);
							if(newZipValue != oldZipValue){
								repfn.FnUpdateTestStepResHTML("Verify Zip value is modified "," Zip value is modified ","PASS",runManagerInfoObj);
								blnFlag	= true;		
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Zip value is modified "," Zip value is not modified ","FAIL",runManagerInfoObj);
								blnFlag	=false;
							}
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Zip field is displayed "," Zip field is not displayed ","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}


					if(cnf.FnExplicitWait("XPATH", mbo.country,driver)){
						List<WebElement> country=driver.findElements(By.xpath(mbo.country));
						if(country.get(0).isDisplayed()){
							String oldCountryValue = country.get(0).getAttribute("value");
							System.out.println("old value: " +oldCountryValue);
							country.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"USA");
							String newCountryValue = country.get(0).getAttribute("value");
							System.out.println("new value: " +newCountryValue);
							if(newCountryValue != oldCountryValue){
								repfn.FnUpdateTestStepResHTML("Verify Country value is modified "," Country value is modified ","PASS",runManagerInfoObj);
								blnFlag = true;			
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Country value is modified "," Country value is not modified ","FAIL",runManagerInfoObj);
								blnFlag	=false;
							}	
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Country field is displayed "," Country field is not displayed ","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}

					fullName = newNameFirst+" "+lastNameFirst;
					driver.manage().window().setSize(new Dimension(100, 100));
					driver.manage().window().maximize();
					boolean blnFlag1=app.FnSaveDataAndGoBack(driver,runManagerInfoObj);
					if(blnFlag1==true)
					{

						if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
							WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
							cnf.ScrollToView(Search_Field,driver);
							Search_Field.sendKeys(fullName);
							repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
							Thread.sleep(2000);

							List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
							if(Contacts_Arrow.get(0).isDisplayed()){
								repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
								if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
									repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
									if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
										repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

										Thread.sleep(2000);

										if(cnf.FnExplicitWait("XPATH",mbo.UserAddressVerification,driver)){
											List<WebElement> UserAddressVerification=driver.findElements(By.xpath(mbo.UserAddressVerification));
											cnf.ScrollToView(UserAddressVerification.get(0),driver);
											if(cnf.FnExplicitWait("XPATH",mbo.UserAddressStreetVerification,driver)){
												List<WebElement> UserAddressStreetVerification=driver.findElements(By.xpath(mbo.UserAddressStreetVerification));
												WebElement UserStreetAddress=UserAddressStreetVerification.get(0);
												if(UserStreetAddress.getText().contains(street))
												{
													repfn.FnUpdateTestStepResHTML("Verify New Address is added or not ", "New Address is added","PASS",runManagerInfoObj);
													blnFlag=true;
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify New Address is added or not", "New Address is not added","FAIL",runManagerInfoObj);
													blnFlag=false;
												}
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify New Address is displayed in User Details form", "New Address is not displayed in User Details form","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ","Search field is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify if the user is able to save the changes in Edit Contact form. ", "User is not able to save the changes in Edit Contact form","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}


				}

				if(listSize == 2){
					WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
					String newNameFirst = FirstName.getAttribute("value");
					WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
					String lastNameFirst = lastName.getAttribute("value");

					if(cnf.FnExplicitWait("XPATH", mbo.addressStreet1,driver)){
						List<WebElement> addressStreet=driver.findElements(By.xpath(mbo.addressStreet1));
						if(addressStreet.get(0).isDisplayed()){
							String oldAddressStreetValue = addressStreet.get(0).getAttribute("value");
							System.out.println("old value: " +oldAddressStreetValue);
							addressStreet.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"12,"+randomInt+"Ford Street");
							String newAddressStreetValue = addressStreet.get(0).getAttribute("value");
							System.out.println("new value: " +newAddressStreetValue);
							if(newAddressStreetValue != oldAddressStreetValue){
								repfn.FnUpdateTestStepResHTML("Verify Address Street value is modified "," Address Street value is modified ","PASS",runManagerInfoObj);
								blnFlag	= true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Address Street value is modified "," Address Street value is not modified ","FAIL",runManagerInfoObj);
								blnFlag = false;
							}
						}

						street = addressStreet.get(0).getAttribute("value");
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Address Street field is displayed "," Address Street field is not displayed ","FAIL",runManagerInfoObj);
						blnFlag = false;
					}



					if(cnf.FnExplicitWait("XPATH", mbo.city1,driver)){
						List<WebElement> city=driver.findElements(By.xpath(mbo.city1));
						if(city.get(0).isDisplayed()){
							String oldCityValue = city.get(0).getAttribute("value");
							System.out.println("old value: " +oldCityValue);
							city.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"NY");
							String newCityValue = city.get(0).getAttribute("value");
							System.out.println("new value: " +newCityValue);
							if(newCityValue != oldCityValue){
								repfn.FnUpdateTestStepResHTML("Verify City value is modified "," City value is modified ","PASS",runManagerInfoObj);
								blnFlag	= true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify City value is modified "," City value is not modified ","FAIL",runManagerInfoObj);
								blnFlag	=false;
							}
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify City field is displayed "," City field is not displayed ","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}


					if(cnf.FnExplicitWait("XPATH", mbo.state1,driver)){
						List<WebElement> state=driver.findElements(By.xpath(mbo.state1));
						if(state.get(0).isDisplayed()){
							String oldStateValue = state.get(0).getAttribute("value");
							System.out.println("old value: " +oldStateValue);
							state.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"NY");
							String newStateValue = state.get(0).getAttribute("value");
							System.out.println("new value: " +newStateValue);
							if(newStateValue != oldStateValue){
								repfn.FnUpdateTestStepResHTML("Verify State value is modified "," State value is modified ","PASS",runManagerInfoObj);	
								blnFlag	= true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify State value is modified "," State value is not modified ","FAIL",runManagerInfoObj);
								blnFlag	=false;
							}
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify State field is displayed "," State field is not displayed ","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}


					if(cnf.FnExplicitWait("XPATH", mbo.zip1,driver)){
						List<WebElement> zip=driver.findElements(By.xpath(mbo.zip1));
						if(zip.get(0).isDisplayed()){
							String oldZipValue = zip.get(0).getAttribute("value");
							System.out.println("old value: " +oldZipValue);
							zip.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"16004");
							String newZipValue = zip.get(0).getAttribute("value");
							System.out.println("new value: " +newZipValue);
							if(newZipValue != oldZipValue){
								repfn.FnUpdateTestStepResHTML("Verify Zip value is modified "," Zip value is modified ","PASS",runManagerInfoObj);
								blnFlag	= true;		
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Zip value is modified "," Zip value is not modified ","FAIL",runManagerInfoObj);
								blnFlag	=false;
							}
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Zip field is displayed "," Zip field is not displayed ","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}


					if(cnf.FnExplicitWait("XPATH", mbo.country1,driver)){
						List<WebElement> country=driver.findElements(By.xpath(mbo.country1));
						if(country.get(0).isDisplayed()){
							String oldCountryValue = country.get(0).getAttribute("value");
							System.out.println("old value: " +oldCountryValue);
							country.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"USA");
							String newCountryValue = country.get(0).getAttribute("value");
							System.out.println("new value: " +newCountryValue);
							if(newCountryValue != oldCountryValue){
								repfn.FnUpdateTestStepResHTML("Verify Country value is modified "," Country value is modified ","PASS",runManagerInfoObj);
								blnFlag = true;			
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Country value is modified "," Country value is not modified ","FAIL",runManagerInfoObj);
								blnFlag	=false;
							}	
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Country field is displayed "," Country field is not displayed ","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}

					fullName = newNameFirst+" "+lastNameFirst;

					driver.manage().window().setSize(new Dimension(100, 100));
					driver.manage().window().maximize();
					boolean blnFlag2=app.FnSaveDataAndGoBack(driver,runManagerInfoObj);
					if(blnFlag2==true)
					{
						if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
							WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
							cnf.ScrollToView(Search_Field,driver);
							Search_Field.sendKeys(fullName);
							repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
							Thread.sleep(2000);

							List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
							if(Contacts_Arrow.get(0).isDisplayed()){
								repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
								if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
									repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
									if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
										repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

										Thread.sleep(2000);

										if(cnf.FnExplicitWait("XPATH",mbo.UserAddressVerification,driver)){
											//repfn.FnUpdateTestStepResHTML("Verify Address field is displayed in User Details form", "Address field is displayed in User Details form","PASS",runManagerInfoObj);
											List<WebElement> UserAddressVerification=driver.findElements(By.xpath(mbo.UserAddressVerification1));

											if(cnf.isElementExist(UserAddressVerification.get(0))){
												cnf.ScrollToView(UserAddressVerification.get(0),driver);
												if(cnf.FnExplicitWait("XPATH",mbo.UserAddressStreetVerification1,driver)){
													List<WebElement> UserAddressStreetVerification=driver.findElements(By.xpath(mbo.UserAddressStreetVerification1));
													WebElement UserStreetAddress=UserAddressStreetVerification.get(0);
													if(UserStreetAddress.getText().contains(street)){
														repfn.FnUpdateTestStepResHTML("Verify New Address is added or not ", "New Address is added","PASS",runManagerInfoObj);
														blnFlag=true;
													}
													else{
														repfn.FnUpdateTestStepResHTML("Verify New Address is added or not", "New Address is not added","FAIL",runManagerInfoObj);
														blnFlag=false;
													}
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify Street Address is displayed in User Details form", "Street Address is not displayed in User Details form","FAIL",runManagerInfoObj);
													blnFlag=false;
												}
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify New Address is added or not ", "New Address is not added","FAIL",runManagerInfoObj);
												blnFlag=false;
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Address field is displayed in User Details form", "Address field is not displayed in User Details form","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ","Search field is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify if the user is able to save the changes in Edit Contact form. ", "User is not able to save the changes in Edit Contact form","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}

				}
			}

			catch(Exception e)
			{
				repfn.FnUpdateTestStepResHTML("Verify new address is added.", "New address is not added due to some exception.","FAIL",runManagerInfoObj);
				blnFlag	=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}

			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}

		public synchronized boolean FnClickAddEmail(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

			try{
				cnf.FnExplicitWait("XPATH", mbo.addEmail,driver);   
				WebElement addEmail=driver.findElement(By.xpath(mbo.addEmail));
				if(addEmail.isDisplayed()){
					cnf.JSClick(addEmail,driver);
					repfn.FnUpdateTestStepResHTML("Verify Add Email option is clicked ", "Add Email option is clicked","PASS",runManagerInfoObj);
					blnFlag	=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Add Email option is clicked  ", "Add Email option is not clicked","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}

			}

			catch(Exception e)
			{

				repfn.FnUpdateTestStepResHTML("Verify Add Email option is clicked  ", "Add Email option is not clicked due to exception.","FAIL",runManagerInfoObj);
				blnFlag	=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());

			}

			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		public synchronized boolean FnCheckAddressField(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
			int listSize = 0;
			try{


				if(cnf.FnExplicitWait("XPATH", mbo.addressCount,driver)){
					List<WebElement> addressCount= driver.findElements(By.xpath(mbo.addressCount));
					((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(mbo.addressCount))); 
					driver.manage().window().setSize(new Dimension(100, 100));
					driver.manage().window().maximize();
					blnFlag	= true;

				}
				else{
					boolean blnFlag1=FnClickAddAddress(driver,runManagerInfoObj);
					boolean blnFlag2=app.FnAddAddress(driver,runManagerInfoObj);
					boolean blnFlag3=app.FnSaveDataAndGoBack(driver,runManagerInfoObj);
					boolean blnFlag4=FnOpenUserDetailsPage(driver,runManagerInfoObj);
					boolean blnFlag5=FnOpenEditUserPage(driver,runManagerInfoObj);
					if((blnFlag1 && blnFlag2 && blnFlag3 && blnFlag4 && blnFlag5)==true){
						blnFlag	= true;
					}
					else{
						blnFlag	= false;
					}
				}
			}


			catch(Exception e)
			{

				repfn.FnUpdateTestStepResHTML("Verify address fields are displayed.", "Address fields are not displayed due to some exception.","FAIL",runManagerInfoObj);
				blnFlag	=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());

			}

			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}
		
		public synchronized boolean FnCheckEmailField(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
			int listSize = 0;
			try{


				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
					List<WebElement> Addcontact_EmailInputText= driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
					((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(mbo.Addcontact_EmailInputText))); 
					driver.manage().window().setSize(new Dimension(100, 100));
					driver.manage().window().maximize();
					blnFlag	= true;

				}
				else{
					boolean blnFlag1=FnClickAddEmailAddress(driver,runManagerInfoObj);
					boolean blnFlag2=FnAddEmailAddress(driver,runManagerInfoObj);
					boolean blnFlag3=app.FnSaveDataAndGoBack(driver,runManagerInfoObj);
					boolean blnFlag4=FnOpenUserDetailsPage(driver,runManagerInfoObj);
					boolean blnFlag5=FnOpenEditUserPage(driver,runManagerInfoObj);
					if((blnFlag1 && blnFlag2 && blnFlag3 && blnFlag4 && blnFlag5)==true){
						blnFlag	= true;
					}
					else{
						blnFlag	= false;
					}
				}
			}


			catch(Exception e)
			{

				repfn.FnUpdateTestStepResHTML("Verify email address fields are displayed.", "Email Address fields are not displayed due to some exception.","FAIL",runManagerInfoObj);
				blnFlag	=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());

			}

			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}

		public synchronized boolean FnVerifyPhoneNumberField(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
			int listSize = 0;	
			try{

				if(cnf.FnExplicitWait("XPATH", mbo.EditModeUserPhoneType,driver)){
					List<WebElement> UserContactPhoneType= driver.findElements(By.xpath(mbo.EditModeUserPhoneType));
					listSize = UserContactPhoneType.size();
					if(listSize < 5){
						blnFlag	= true;
					}
					else if(listSize == 5){
						blnFlag=FnVerifyAddNumberOption(driver,runManagerInfoObj);	
						if(blnFlag){
							blnFlag	= true;
						}
						else{
							blnFlag	= false;
						}
					}

				}
				else{
					boolean blnFlag1=FnVerifyAddNumberOption(driver,runManagerInfoObj);
					if(blnFlag1){
						blnFlag	= true;
					}
					else{
						blnFlag	= false;
					}
				}
			}

			catch(Exception e)
			{

				repfn.FnUpdateTestStepResHTML("Verify phone number field is displayed in Edit Contact form.", "Phone number field is not displayed in Edit Contact form due to some exception.","FAIL",runManagerInfoObj);
				blnFlag	=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());

			}

			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}

		public synchronized boolean FnEditUserPhoneType(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
		{
			WebElement phoneType = null;
			String type = null;
			String fullName = "";

			try{

				if(cnf.FnExplicitWait("XPATH", mbo.EditModeUserPhoneType,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Phone Type drop-down is displayed","Phone Type drop-down is displayed","PASS",runManagerInfoObj);
					List<WebElement> UserContactPhoneType= driver.findElements(By.xpath(mbo.EditModeUserPhoneType));
					WebElement contactPhoneType = UserContactPhoneType.get(0);
					System.out.println("phone type: " +UserContactPhoneType.get(0).getText());
					String currentPhoneType = UserContactPhoneType.get(0).getText();
					if(cnf.JSClick(contactPhoneType,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Phone Type drop-down is clicked","Phone Type drop-down is clicked","PASS",runManagerInfoObj);
						if(cnf.FnExplicitWait("XPATH", mbo.phoneTypeCell,driver))
						{
							phoneType = driver.findElement(By.xpath(mbo.phoneTypeCell));
						}
						else{
							if(cnf.FnExplicitWait("XPATH", mbo.phoneTypeHome,driver)){
								phoneType = driver.findElement(By.xpath(mbo.phoneTypeHome));
							}
							else{
								if(cnf.FnExplicitWait("XPATH", mbo.phoneTypeWork,driver)){
									phoneType = driver.findElement(By.xpath(mbo.phoneTypeWork));
								}
								else{
									if(cnf.FnExplicitWait("XPATH", mbo.phoneTypeOffice,driver)){
										phoneType = driver.findElement(By.xpath(mbo.phoneTypeOffice));
									}
									else{
										if(cnf.FnExplicitWait("XPATH", mbo.phoneTypeOther,driver)){
											phoneType = driver.findElement(By.xpath(mbo.phoneTypeOther));
										}

									}

								}
							}
						}

						if(phoneType.isDisplayed()){
							repfn.FnUpdateTestStepResHTML("Verify Phone Type is displayed","Phone Type: " +phoneType.getText()+ " is displayed","PASS",runManagerInfoObj);
							if(cnf.JSClick(phoneType,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Phone Type is Clicked ","Phone Type: " +phoneType.getText()+ " is Clicked ","PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Phone Type is Clicked ","Phone Type is not Clicked ","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Phone Type is displayed","Phone Type is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}

						Thread.sleep(5000);
						if(cnf.FnExplicitWait("XPATH", mbo.EditModeUserPhoneType,driver)){
							List<WebElement> UserPhoneType= driver.findElements(By.xpath(mbo.EditModeUserPhoneType));
							type = UserPhoneType.get(0).getText();
							System.out.println(type);
						}

						Thread.sleep(2000);

						WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
						String newNameFirst = FirstName.getAttribute("value");
						WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
						String lastNameFirst = lastName.getAttribute("value");

						blnFlag=app.FnSaveDataAndGoBack(driver,runManagerInfoObj);
						//app.FnSaveDataAndGoBack();
						if(blnFlag){
							fullName = newNameFirst+" "+lastNameFirst;

							Thread.sleep(5000);
							if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
								WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
								cnf.ScrollToView(Search_Field,driver);
								Search_Field.clear();
								Search_Field.sendKeys(fullName);
								repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
								Thread.sleep(2000);

								List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
								if(Contacts_Arrow.get(0).isDisplayed()){
									repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
									if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
										repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
										if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
											repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

											Thread.sleep(2000);
											if(cnf.FnExplicitWait("XPATH", mbo.UserContactPhoneTypeDisplay,driver)){
												List<WebElement> UserContactPhoneTypeDisplay= driver.findElements(By.xpath(mbo.UserContactPhoneTypeDisplay));
												for(WebElement phoneSavedType : UserContactPhoneTypeDisplay){
													if(phoneSavedType.getText().contains(type)){
														blnFlag=true;
														break;
													}
													else{
														blnFlag=false;
													}
												}
												if(blnFlag){
													repfn.FnUpdateTestStepResHTML("Check whether Phone type is changed or not"," Phone type is changed. New value of Phone Type is: "+type,"PASS",runManagerInfoObj);
													blnFlag=true;
												}
												else{
													repfn.FnUpdateTestStepResHTML("Check whether Phone type is changed or not"," Phone type is not changed","FAIL",runManagerInfoObj);
													blnFlag=false;
												}
											}
											else{
												repfn.FnUpdateTestStepResHTML("Check whether Phone type is displayed or not"," Phone type is not displayed","FAIL",runManagerInfoObj);
												blnFlag=false;
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ","Search field is not displayed","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}else{
							blnFlag=false;
							repfn.FnUpdateTestStepResHTML("Verify Save functionality working or not","Save functionality not working","FAIL",runManagerInfoObj);
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Phone Type drop-down is clicked","Phone Type drop-down is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Phone Type drop-down is displayed","Phone Type drop-down is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}

			catch(Exception e)
			{

				repfn.FnUpdateTestStepResHTML("Verify phone type is modified in Edit Contact form. ", "Phone type is not modified in Edit Contact form due to some exception","FAIL",runManagerInfoObj);
				blnFlag	=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());

			}

			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}
		public synchronized boolean FnVerifyUserPhoneType(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

			try{
				cnf.FnExplicitWait("XPATH", mbo.UserContactPhoneTypeDisplay,driver);
				List<WebElement> UserContactPhoneTypeDisplay= driver.findElements(By.xpath(mbo.UserContactPhoneTypeDisplay));
				if(cnf.FnExplicitWait("XPATH", mbo.UserContactPhoneTypeDisplay,driver)){
					if(UserContactPhoneTypeDisplay.get(0).isDisplayed()){
						if(UserContactPhoneTypeDisplay.get(0).getText().equalsIgnoreCase("Cell")){
							repfn.FnUpdateTestStepResHTML("Verify User Details has been saved"," User Details has been saved","PASS",runManagerInfoObj);
							cnf.FnExplicitWait("XPATH", mbo.UserDetail_Backbtn,driver);
							WebElement backButtonClick = driver.findElement(By.xpath(mbo.UserDetail_Backbtn));
							cnf.JSClick(backButtonClick,driver);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User Details has been saved"," User Details has not been saved","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
				}

			}

			catch(Exception e)
			{
				blnFlag	=false;
				repfn.FnUpdateTestStepResHTML("Login to Charter.net ", "Login is not performed due to exception","FAIL",runManagerInfoObj);

			}

			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}

		public synchronized boolean FnEditPhoneNumberAndCancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

			WebElement phoneType = null;
			String type = null;
			String Number = null;
			String fullName = "";
			int listSize = 0;

			try{
				if(cnf.FnExplicitWait("XPATH", mbo.EditModeUserPhoneType,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Phone Type drop-down is displayed","Phone Type drop-down is displayed","PASS",runManagerInfoObj);
					List<WebElement> UserContactPhoneType= driver.findElements(By.xpath(mbo.EditModeUserPhoneType));
					listSize = UserContactPhoneType.size();
					WebElement contactPhoneType = UserContactPhoneType.get(0);
					System.out.println("phone type: " +UserContactPhoneType.get(0).getText());
					String currentPhoneType = UserContactPhoneType.get(0).getText();
					if(cnf.JSClick(contactPhoneType,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Phone Type drop-down is clicked","Phone Type drop-down is clicked","PASS",runManagerInfoObj);
						if(cnf.FnExplicitWait("XPATH", mbo.phoneTypeCell,driver)){
							phoneType = driver.findElement(By.xpath(mbo.phoneTypeCell));
						}
						else{
							if(cnf.FnExplicitWait("XPATH", mbo.phoneTypeHome,driver)){
								phoneType = driver.findElement(By.xpath(mbo.phoneTypeHome));
							}
							else{
								if(cnf.FnExplicitWait("XPATH", mbo.phoneTypeWork,driver)){
									phoneType = driver.findElement(By.xpath(mbo.phoneTypeWork));
								}
								else{
									if(cnf.FnExplicitWait("XPATH", mbo.phoneTypeOffice,driver)){
										phoneType = driver.findElement(By.xpath(mbo.phoneTypeOffice));
									}
									else{
										if(cnf.FnExplicitWait("XPATH", mbo.phoneTypeOther,driver)){
											phoneType = driver.findElement(By.xpath(mbo.phoneTypeOther));
										}

									}

								}
							}
						}

						if(phoneType.isDisplayed()){
							repfn.FnUpdateTestStepResHTML("Verify Phone Type is displayed","Phone Type: " +phoneType.getText()+ "is displayed","PASS",runManagerInfoObj);
							if(cnf.JSClick(phoneType,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Phone Type is Clicked ","Phone Type: " +phoneType.getText()+ "is Clicked ","PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Phone Type is Clicked ","Phone Type is not Clicked ","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Phone Type is displayed","Phone Type is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}

						if(cnf.FnExplicitWait("XPATH", mbo.UserContactPhoneNumber,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Phone Number field is displayed","Phone Number field is displayed","PASS",runManagerInfoObj);
							List<WebElement> phoneNumber=driver.findElements(By.xpath(mbo.UserContactPhoneNumber));
							WebElement contactPhoneNumber = phoneNumber.get(0);
							System.out.println("blabla: " +phoneNumber.get(0).getAttribute("value"));
							String currentPhoneNumber = phoneNumber.get(0).getAttribute("value");
							System.out.println("Curr phone no: " +currentPhoneNumber);
							phoneNumber.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"978487"+randomInt);
							String newPhoneNumber = phoneNumber.get(0).getAttribute("value");
							System.out.println("New phon no: " +newPhoneNumber);

							if(currentPhoneNumber != newPhoneNumber){
								repfn.FnUpdateTestStepResHTML("Verify Phone Number is modified ","Phone number is modified ","PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Phone Number is modified ","Phone number is not modified ","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Phone Number field is displayed","Phone Number field is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}

						Thread.sleep(5000);
						if(cnf.FnExplicitWait("XPATH", mbo.EditModeUserPhoneType,driver)){
							List<WebElement> UserPhoneType= driver.findElements(By.xpath(mbo.EditModeUserPhoneType));
							type = UserPhoneType.get(0).getText();
							System.out.println(type);
						}

						if(cnf.FnExplicitWait("XPATH", mbo.UserContactPhoneNumber,driver)){
							List<WebElement> UserPhoneNumber= driver.findElements(By.xpath(mbo.UserContactPhoneNumber));
							Number = UserPhoneNumber.get(0).getAttribute("value");
							System.out.println(Number);
						}

						Thread.sleep(2000);

						WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
						String newNameFirst = FirstName.getAttribute("value");
						WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
						String lastNameFirst = lastName.getAttribute("value");

						blnFlag=FnCancelAndGoBack(driver,runManagerInfoObj);

						if(blnFlag){
							fullName = newNameFirst+" "+lastNameFirst;

							Thread.sleep(5000);
							if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
								WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
								cnf.ScrollToView(Search_Field,driver);
								Search_Field.clear();
								Search_Field.sendKeys(fullName);
								repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
								Thread.sleep(2000);

								List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
								if(Contacts_Arrow.get(0).isDisplayed()){
									repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
									if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
										repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
										if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
											repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

											Thread.sleep(2000);
											if(listSize == 1){
												if(cnf.FnExplicitWait("XPATH", mbo.UserContactPhoneTypeDisplay,driver)){
													repfn.FnUpdateTestStepResHTML("Check Phone type and Number have not changed","Phone number is added and saved.","FAIL",runManagerInfoObj);
													blnFlag=false;
												}
												else{
													repfn.FnUpdateTestStepResHTML("Check Phone type and Number have not changed","No Phone number is added and saved.","PASS",runManagerInfoObj);
													blnFlag=true;
												}
											}
											else{
												if(cnf.FnExplicitWait("XPATH", mbo.UserContactPhoneTypeDisplay,driver)){
													List<WebElement> UserContactPhoneTypeDisplay= driver.findElements(By.xpath(mbo.UserContactPhoneTypeDisplay));
													if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumberVerification,driver)){
														List<WebElement> UserContactPhoneNumberDisplay= driver.findElements(By.xpath(mbo.Addcontact_PhoneNumberVerification));												
														if(!UserContactPhoneTypeDisplay.get(0).getText().contains(type) && !UserContactPhoneNumberDisplay.get(0).getText().contains(Number)){
															repfn.FnUpdateTestStepResHTML("Check Phone type and Number have not changed"," Phone type and number have not changed","PASS",runManagerInfoObj);
															blnFlag=true;
														}
														else{
															repfn.FnUpdateTestStepResHTML("Check Phone type and Number have not changed"," Phone type and number have changed","FAIL",runManagerInfoObj);
															blnFlag=false;
														}
													}
													else{
														repfn.FnUpdateTestStepResHTML("Verify Phone number is displayed"," Phone number is not displayed","FAIL",runManagerInfoObj);
														blnFlag=false;
													}
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify Phone type is displayed"," Phone type is not displayed","FAIL",runManagerInfoObj);
													blnFlag=false;
												}
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
						}
						else{
							blnFlag=false;
							repfn.FnUpdateTestStepResHTML("Verify if the user is able to cancel the changes in Edit Contact form. ", "User is not able to cancel the changes in Edit Contact form.","FAIL",runManagerInfoObj);
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Phone Type drop-down is clicked","Phone Type drop-down is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Phone Type drop-down is displayed","Phone Type drop-down is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}


			}

			catch(Exception e)
			{

				repfn.FnUpdateTestStepResHTML("Verify if user is able to cancel editing the phone number and phone type in Edit Contact form.", 
						"User is not able to cancel editing the phone number and phone type in Edit Contact form due to some exception.","FAIL",runManagerInfoObj);
				blnFlag	=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());

			}

			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		public synchronized boolean FnCancelAndGoBack(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

			try{

				Thread.sleep(2000);
				if(cnf.FnExplicitWait("XPATH", mbo.CancelEdit,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Cancel link is displayed in Edit Contact form","Cancel link is displayed in Edit Contact form","PASS",runManagerInfoObj);
					WebElement CancelEdit=driver.findElement(By.xpath(mbo.CancelEdit));
					if(cnf.JSClick(CancelEdit,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Cancel link is clicked in Edit Contact form","Cancel link is clicked in Edit Contact form","PASS",runManagerInfoObj);
						if(cnf.FnExplicitWait("XPATH", mbo.ConfirmCancel,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Confirmation pop-up is present or not", 
									"Confirmation pop-up is present","PASS",runManagerInfoObj);
							repfn.FnUpdateTestStepResHTML("Verify Cancel link is displayed in Confirm pop-up", "Cancel link is displayed in Confirm pop-up","PASS",runManagerInfoObj);
							WebElement ConfirmCancel=driver.findElement(By.xpath(mbo.ConfirmCancel));
							if(cnf.JSClick(ConfirmCancel,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Confirm link is clicked in Confirm pop-up","Confirm link is clicked in Confirm pop-up","PASS",runManagerInfoObj);
								blnFlag	=true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Confirm link is clicked in Confirm pop-up","Confirm link is not clicked in Confirm pop-up","FAIL",runManagerInfoObj);
								blnFlag	=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Confirmation pop-up is present or not", "Confirmation pop-up is not present","FAIL",runManagerInfoObj);
							repfn.FnUpdateTestStepResHTML("Verify Cancel link is displayed in Confirm pop-up", "Cancel link is not displayed in Confirm pop-up","FAIL",runManagerInfoObj);
							blnFlag	=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Cancel link is clicked in Edit Contact form","Cancel link is not clicked in Edit Contact form","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Cancel link is displayed in Edit Contact form","Cancel link is not displayed in Edit Contact form","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}

				Thread.sleep(5000);

				if(cnf.FnExplicitWait("XPATH", mbo.UserDetail_Backbtn,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Back link is displayed in User Details page", "Back link is displayed in User Details page","PASS",runManagerInfoObj);
					WebElement backButton = driver.findElement(By.xpath(mbo.UserDetail_Backbtn));
					if(cnf.JSClick(backButton,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Back link is clicked in User Details page", "Back link is clicked in User Details page","PASS",runManagerInfoObj);
						Thread.sleep(3000);
						blnFlag	=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Back link is clicked in User Details page", "Back link is not clicked in User Details page","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Back link is displayed in User Details page", "Back link is not displayed in User Details page","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}

				Thread.sleep(3000);

			}

			catch(Exception e)
			{

				repfn.FnUpdateTestStepResHTML("Verify if the user is able to cancel the changes in Edit Contact form. ", "User is not able to cancel the changes in Edit Contact form due to some exception.","FAIL",runManagerInfoObj);
				blnFlag	=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());

			}

			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}
	 public synchronized boolean FNAddcontact_EmailVerificationAfterCancel(WebDriver driver, RunManagerInfo runManagerInfoObj){
		 try{
			 
			 if(cnf.FnExplicitWait("XPATH",mbo.EmailVerification,driver)){
				 repfn.FnUpdateTestStepResHTML("Verify Contact should not have the  Email id as it was removed while adding a contact","Contact have the email id","FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }

			 else{
				 repfn.FnUpdateTestStepResHTML("Verify Contact  should not have the  Email id as it was removed while adding a contact","Contact does not have the email id","PASS",runManagerInfoObj);
				 blnFlag=true;
			 }
			 //}
		 }
		 catch (Exception e)

		 {
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
			 repfn.FnUpdateTestStepResHTML("Verify Contact List has  Infosys Mail id","Contact List   does not have Infosys  Mail id due to some exception","FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }

	

	public synchronized boolean FnContactsClick(WebDriver driver, RunManagerInfo runManagerInfoObj)
	{
		try
		{	
			if(cnf.FnExplicitWait("Xpath", mbo.ContactsList,driver)){
				List<WebElement> ContactsList=driver.findElements(By.xpath(mbo.ContactsList));

				if(cnf.FnExplicitWait("Xpath", mbo.ContactsName,driver)){
					List<WebElement> ContactsName=driver.findElements(By.xpath(mbo.ContactsName));

					for(WebElement check:ContactsName)
					{
						String ContactName= check.getText();
						if(!ContactName.isEmpty())
						{
							repfn.FnUpdateTestStepResHTML("Verify if Contacts are displayed", "Contacts are displayed as FirstName Lastname: "+ContactName, "PASS",runManagerInfoObj);
							blnFlag=true;
							break;
						}							
					}

					if(!blnFlag){
						repfn.FnUpdateTestStepResHTML("Verify if Contacts are displayed", "Contacts are not displayed", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					else{
						blnFlag=true;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify if Contact Names are displayed", "Contact Names are not displayed", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}

			}else{
				repfn.FnUpdateTestStepResHTML("Verify if Contacts are present in the contacts list", "No Contact Present in the Contacts list", "PASS",runManagerInfoObj);
				boolean blnFlag1 = FnClickAddContact(driver,runManagerInfoObj);	
				if(blnFlag1){
					boolean blnFlag2 = FnAddNewContactSave(driver,runManagerInfoObj);
					if(blnFlag2){
						if(cnf.FnExplicitWait("Xpath", mbo.ContactsList,driver)){
							List<WebElement> ContactsList=driver.findElements(By.xpath(mbo.ContactsList));

							if(cnf.FnExplicitWait("Xpath", mbo.ContactsName,driver)){
								List<WebElement> ContactsName=driver.findElements(By.xpath(mbo.ContactsName));

								for(WebElement check:ContactsName)
								{
									String ContactName= check.getText();
									if(!ContactName.isEmpty())
									{
										repfn.FnUpdateTestStepResHTML("Verify if Contacts are displayed", "Contacts are displayed as FirstName Lastname: "+ContactName, "PASS",runManagerInfoObj);
										blnFlag=true;
										break;
									}							
								}

								if(!blnFlag){
									repfn.FnUpdateTestStepResHTML("Verify if Contacts are displayed", "Contacts are not displayed", "FAIL",runManagerInfoObj);
									blnFlag=false;
								}
								else{
									blnFlag=true;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify if Contact Names are displayed", "Contact Names are not displayed", "FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify if Contacts are displayed in the contacts list", "Contacts are not displayed in the contacts list", "FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify if User is able to add and save contact"," User is not able to add and save contact", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}				
				else{
					repfn.FnUpdateTestStepResHTML("Verify Add Contact form is displayed", "Add Contact form is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
		}

		catch (Exception e)
		{
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			repfn.FnUpdateTestStepResHTML("Verify if contacts are displayed in contact page", "Contacts are not  displayed in contact page due to some excepton", "FAIL",runManagerInfoObj);
			blnFlag=false;	
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;

	}
	public synchronized boolean FnAddNewContactSave(WebDriver driver, RunManagerInfo runManagerInfoObj) throws InterruptedException {
		try
		{
			Thread.sleep(5000);
			String firstNameText=null;
			String lastNameText=null;
			String title=null;
			String company=null;


			if(cnf.FnExplicitWait("ID", mbo.firstNameText,driver))
			{
				WebElement firstName=driver.findElement(By.id(mbo.firstNameText));
				repfn.FnUpdateTestStepResHTML("Verfiy First Name input field is displayed","First Name input field is displayed ", "PASS",runManagerInfoObj);
				int RandomInt=randomInt;
				firstNameText="Sam"+RandomInt;
				//driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
				//firstName.sendKeys(firstNameText);
				cnf.FnSetWebEdit(mbo.firstNameText, firstNameText,driver);
				repfn.FnUpdateTestStepResHTML("Verify First name is entered"," First name is entered: "+firstNameText, "PASS",runManagerInfoObj);
			}
			else
			{
				blnFlag=false;
				repfn.FnUpdateTestStepResHTML("Verify First name is entered"," First name is not entered", "FAIL",runManagerInfoObj);
			}

			if(cnf.FnExplicitWait("ID", mbo.lastNameText,driver))
			{
				WebElement lastName=driver.findElement(By.id(mbo.lastNameText));
				repfn.FnUpdateTestStepResHTML("Verfiy Last Name input field is displayed","Last Name input field is displayed ", "PASS",runManagerInfoObj);
				//cnf.JSClick(lastName);
				Thread.sleep(5000);
				lastNameText="Jackson";
				//driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
				//lastName.sendKeys(lastNameText);
				cnf.FnSetWebEdit(mbo.lastNameText, lastNameText,driver);
				repfn.FnUpdateTestStepResHTML("Verify Last name is entered"," Last name is entered: "+lastNameText, "PASS",runManagerInfoObj);
			}
			else
			{
				blnFlag=false;
				repfn.FnUpdateTestStepResHTML("Verify Last name is entered"," Last name is not entered", "FAIL",runManagerInfoObj);
			}

			if(cnf.FnExplicitWait("ID", mbo.contactTitle,driver))
			{
				WebElement contactTitle=driver.findElement(By.id(mbo.contactTitle));
				repfn.FnUpdateTestStepResHTML("Verfiy Contact Title input field is displayed","Contact Title input field is displayed ", "PASS",runManagerInfoObj);
				//cnf.JSClick(contactTitle);
				Thread.sleep(5000);
				title="Associate";
				//driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
				//contactTitle.sendKeys(title);
				cnf.FnSetWebEdit(mbo.contactTitle, title,driver);
				repfn.FnUpdateTestStepResHTML("Verify Contact Title is entered","Contact Title is entered: "+title, "PASS",runManagerInfoObj);
			}
			else
			{
				blnFlag=false;
				repfn.FnUpdateTestStepResHTML("Verify Contact Title is entered","Contact Title is not entered", "FAIL",runManagerInfoObj);
			}


			if(cnf.FnExplicitWait("ID", mbo.contactCompany,driver))
			{
				WebElement contactCompany=driver.findElement(By.id(mbo.contactCompany));
				repfn.FnUpdateTestStepResHTML("Verfiy Contact Company input field is displayed","Contact Company input field is displayed ", "PASS",runManagerInfoObj);
				//cnf.JSClick(contactTitle);
				Thread.sleep(5000);
				company="DadsCompany";
				//driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
				//contactCompany.sendKeys(company);
				cnf.FnSetWebEdit(mbo.contactCompany, company,driver);
				repfn.FnUpdateTestStepResHTML("Verify Contact Company is entered","Contact Company is entered: "+company, "PASS",runManagerInfoObj);
			}
			else
			{
				blnFlag=false;
				repfn.FnUpdateTestStepResHTML("Verify Contact Company is entered","Contact Company is not entered", "FAIL",runManagerInfoObj);
			}



			if(cnf.FnExplicitWait("XPATH",mbo.saveButton,driver))
			{
				repfn.FnUpdateTestStepResHTML("Verify Save button is displayed","Save button is displayed ", "PASS",runManagerInfoObj);
				WebElement saveButton=driver.findElement(By.xpath(mbo.saveButton));

				if(cnf.JSClick(saveButton,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Save button is clicked","Save button is clicked ", "PASS",runManagerInfoObj);
					Thread.sleep(5000);

					if(cnf.FnExplicitWait("XPATH", mbo.SaveNotWorkingText,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Save functionality working or not","Save functionality not working","FAIL",runManagerInfoObj);
						if(cnf.FnExplicitWaitFeedback("XPATH", mbo.Cancel_Button,driver))
						{
							WebElement close=driver.findElement(By.xpath(mbo.Cancel_Button));
							if(cnf.JSClick(close,driver))
							{
								Thread.sleep(2000);
								if(cnf.FnExplicitWait("XPATH", mbo.Cancel_Button,driver)){
									WebElement Confrm=driver.findElement(By.xpath(mbo.Confirm_btn));
									System.out.println("click aftr save not working");
									if(cnf.JSClick(Confrm,driver))
									{                                                                                                                                                                                                                              Thread.sleep(2000);
									driver.navigate().refresh();
									Thread.sleep(2000);
									repfn.FnUpdateTestStepResHTML("Verify User is moved back to contacts page","User is moved back to contacts page","PASS",runManagerInfoObj);
									blnFlag=false;
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Confirm button is clicked","Confirm button is not clicked ", "FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Confirm button is displayed","Confirm button is not displayed ", "FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Close button is clicked","Close button is not clicked ", "FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Close button is displayed","Close button is not displayed ", "FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else
					{
						//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						if(cnf.FnExplicitWait("XPATH", mbo.ContactList,driver)){
							List<WebElement> contactDetails=driver.findElements(By.xpath(mbo.ContactList));
							for(WebElement contact:contactDetails)
							{
								if(contact.getText().contains(firstNameText))
								{
									blnFlag=true;
									break;
								}
								else{
									blnFlag=false;
								}
							}
							if(blnFlag)
							{
								blnFlag=true;
								repfn.FnUpdateTestStepResHTML("Verify if Contact added newly is saved "," Newly added contact has been saved: "+firstNameText, "PASS",runManagerInfoObj);
							}
							else{
								blnFlag=false;
								repfn.FnUpdateTestStepResHTML("Verify if Contact added newly is saved "," Newly added contact has not been saved", "FAIL",runManagerInfoObj);
							}
						}
						else{
							blnFlag=false;
							repfn.FnUpdateTestStepResHTML("Verify Contact List is displayed","Contact List is not displayed", "FAIL",runManagerInfoObj);
						}
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Save button is clicked","Save button is not clicked ", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else
			{
				blnFlag=false;
				repfn.FnUpdateTestStepResHTML("Verify Save button is displayed","Save button is not displayed ", "FAIL",runManagerInfoObj);
			}

		}		
		catch(Exception e)
		{
			blnFlag=false;
			repfn.FnUpdateTestStepResHTML("Verify if user is able to add and save contact"," User is not able to add and save contact due to some exception", "FAIL",runManagerInfoObj);
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
		}
		//FnNavigateBackOverviewPage();
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;

	}

	 public synchronized boolean FnClickAddContact(WebDriver driver, RunManagerInfo runManagerInfoObj){

		 try{
			 Thread.sleep(5000);
			 
			 if(cnf.FnExplicitWait("XPATH", mbo.addContactButton,driver)){
				 WebElement addNewContact=driver.findElement(By.xpath(mbo.addContactButton));
				 repfn.FnUpdateTestStepResHTML("Verify Add Contact button is displayed", "Add Contact button is displayed","PASS",runManagerInfoObj);
				 if(cnf.JSClick(addNewContact,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify Add Contact button is clicked", "Add Contact button is clicked","PASS",runManagerInfoObj);
					 if(cnf.FnExplicitWait("XPATH", mbo.EditModeUserForm,driver)){
						 repfn.FnUpdateTestStepResHTML("Verify Add Contact form is displayed", "Add Contact form is displayed","PASS",runManagerInfoObj);
						 blnFlag=true;
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify Add Contact form is displayed", "Add Contact form is not displayed","FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }

				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify Add Contact button is clicked", "Add Contact button is not clicked","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify Add Contact button is displayed", "Add Contact button is not displayed","FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }

		 catch(Exception e)
		 {
			 repfn.FnUpdateTestStepResHTML("Verify if user is able to add a new contact"," User is not able to add a new contact due to some exception", "FAIL",runManagerInfoObj);
			 blnFlag=false;
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
		 }

		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;

	 }

	public synchronized boolean AddContacts(WebDriver driver,RunManagerInfo runManagerInfoObj)
	{
		try
		{	

			if(cnf.FnExplicitWait("XPATH", mbo.ContactsBtn,driver)){
				WebElement Contacts =driver.findElement(By.xpath(mbo.ContactsBtn));

				repfn.FnUpdateTestStepResHTML("Verify if contacts button is present", "Contacts button is present", "PASS",runManagerInfoObj);
				if(cnf.ElementClick(Contacts,driver))
				{

					repfn.FnUpdateTestStepResHTML("Verify if contacts is Clicked", "Contacts is Clicked", "PASS",runManagerInfoObj);
					if(cnf.FnExplicitWait("XPATH", mbo.AddContact,driver)){
						WebElement AddContacts=driver.findElement(By.xpath(mbo.AddContact));


						repfn.FnUpdateTestStepResHTML("Verify if option to Add new contacts is present", "Option to Add new Contacts button is present", "PASS",runManagerInfoObj);
						if(cnf.ElementClick(AddContacts,driver))
						{

							repfn.FnUpdateTestStepResHTML("Verify if Add new contacts is clicked", "Add new Contacts button is clicked", "PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("Xpath", mbo.AddContactspage,driver))
							{

								repfn.FnUpdateTestStepResHTML("Verify if user can view Add new contacts page", "User can view Add new Contacts page", "PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else
							{

								repfn.FnUpdateTestStepResHTML("Verify if Add new contacts page is displayed ", "Add new Contacts button page is not displayed", "FAIL",runManagerInfoObj);
								blnFlag=false;	
							}
						}
						else
						{
							repfn.FnUpdateTestStepResHTML("Verify if Add new contacts is clicked", "Add new Contacts button is not clicked", "FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify if Add new contacts is present", "Add new Contacts button is not present", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}

			}
		}

		catch (Exception e)

		{
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			repfn.FnUpdateTestStepResHTML("Verify if a contact can be added", "Contact could not be added due to some exception","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;

	}

	public synchronized boolean FnContactsDetails(WebDriver driver,RunManagerInfo runManagerInfoObj)
	{
		try
		{	

			if(cnf.FnExplicitWait("XPATH", mbo.FirstContactdetails,driver)){
				WebElement ContactsListing =driver.findElement(By.xpath(mbo.FirstContactdetails));
				repfn.FnUpdateTestStepResHTML("Verify if user has option to see More details of the contacts displayed is present", "User has option to see More details of the contact", "PASS",runManagerInfoObj);
				if(cnf.ElementClick(ContactsListing,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if contacts listing is Clicked", "Contacts Listing is Clicked", "PASS",runManagerInfoObj);
					if(cnf.FnExplicitWait("Xpath",mbo.Contactdetailspage,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify if contacts listing page is loaded", "Contacts Listing page is loaded", "PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify if contacts listing page is loaded", "Contacts Listing page is not loaded", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}

				}
				else
				{
					System.out.println("ContactsListing is not clicked");	
					repfn.FnUpdateTestStepResHTML("Verify if contacts listing is Clicked", "Contacts Listing is not Clicked", "FAIL",runManagerInfoObj);
					blnFlag=false;	
				}
			}
			else
			{
				System.out.println("Contact Listing does not exists");
				repfn.FnUpdateTestStepResHTML("Verify if contacts Listing arrow is present", "Contacts Listing arrow is not present", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}

		}

		catch (Exception e)

		{
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
			repfn.FnUpdateTestStepResHTML("Verify if Contact details are displayed", "Contact Details are not displayed due to some exception","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;

	}
	/**
	 * Method Name : FN_SearchBar_SearchText
	 * Method Description : This method is used to Enter the Text In search bar
	 * @param none
	 * @return Boolean
	 * @author Saranya
	 * @throws Exception
	 * Date:10/12/2015
	 */


	public synchronized boolean FN_SearchBar_SearchText(WebDriver driver, RunManagerInfo runManagerInfoObj){
		try{
			if(cnf.FnExplicitWait("Xpath", mbo.SearchBar,driver)){
				repfn.FnUpdateTestStepResHTML(" Verify Search Bar is displayed in contact Page","Search Bar is displayed in contact Page","PASS",runManagerInfoObj);
				WebElement SearchBar=driver.findElement(By.xpath(mbo.SearchBar));
				if(cnf.FnExplicitWait("Xpath", mbo.ContactsName,driver)){
					List<WebElement> ContactsName=driver.findElements(By.xpath(mbo.ContactsName));
					String contact = ContactsName.get(0).getText();
					SearchBar.sendKeys(contact);
					repfn.FnUpdateTestStepResHTML("Verify Username is entered in Search bar","Username is entered in Search bar: "+contact,"PASS",runManagerInfoObj);
					if(cnf.FnExplicitWait("Xpath", mbo.ContactsList,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Contact is displayed on entering username in Search bar","Contact is displayed on entering username in Search bar","PASS",runManagerInfoObj);
						blnFlag=true;
						SearchBar.clear();
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Contact is displayed on entering username in Search bar","Contact is not displayed on entering username in Search bar","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Contact List is displayed in Contacts Page","Contact List is not displayed in Contacts Page","FAIL",runManagerInfoObj);
					blnFlag=false;
				}				
			}
			else{
				repfn.FnUpdateTestStepResHTML(" Verify Search Bar is displayed in contact Page","Search Bar is not displayed in contact Page","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}

		catch (Exception e)
		{
			repfn.FnUpdateTestStepResHTML(" Verify Search Bar is displayed in contact Page","Search Bar is not displayed in contact Page due to some exception","FAIL",runManagerInfoObj);
			blnFlag=false;
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());
		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}

	

	
	public synchronized boolean FnAddNewNumber(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

		int listSize = 0;

		try{

			List<WebElement> Addcontact_PhoneNumber_inputList=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
			if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
				listSize = Addcontact_PhoneNumber_inputList.size();
			}

			if(listSize == 0){
				for(int i=0;i<(5-listSize);i++){
					FnVerifyAddNumberOption(driver,runManagerInfoObj);
					List<WebElement> Addcontact_PhoneNumber_List=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
					if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
						Addcontact_PhoneNumber_List.get(i).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"777777"+randomInt);
						repfn.FnUpdateTestStepResHTML("Verify Phone Number" +i+" is Entered ","Phone Number " +i+" is Entered","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Phone Number" +i+" is Entered ","Phone Number " +i+" is not Entered","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
			}

			if(listSize == 1){
				List<WebElement> Addcontact_List=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
					listSize = Addcontact_PhoneNumber_inputList.size();
				}

				System.out.println("list size: " +listSize);

				for(int i=listSize;i<=(5-listSize);i++){
					FnVerifyAddNumberOption(driver,runManagerInfoObj);
					List<WebElement> Addcontact_PhoneNumber_List=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
					if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
						Addcontact_PhoneNumber_List.get(i).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"777777"+randomInt);
						repfn.FnUpdateTestStepResHTML("Verify Phone Number" +i+" is Entered ","Phone Number " +i+" is Entered","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Phone Number" +i+" is Entered ","Phone Number " +i+" is not Entered","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}

			}

			if(listSize == 2 || listSize == 3 || listSize == 4){
				List<WebElement> Addcontact_List=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
					listSize = Addcontact_PhoneNumber_inputList.size();
				}

				System.out.println("list size: " +listSize);

				for(int i=listSize;i<=4 ;i++){
					FnVerifyAddNumberOption(driver,runManagerInfoObj);
					List<WebElement> Addcontact_PhoneNumber_List=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
					if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
						Addcontact_PhoneNumber_List.get(i).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"777777"+randomInt);
						repfn.FnUpdateTestStepResHTML("Verify Phone Number" +i+" is Entered ","Phone Number " +i+" is Entered","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Phone Number" +i+" is Entered ","Phone Number " +i+" is not Entered","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}

			}


			if(listSize == 5){
				int listSize_A = 0;
				List<WebElement> Addcontact_List=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
					listSize = Addcontact_List.size();
				}

				System.out.println("list size: " +listSize);
				FnVerifyAddNumberOption(driver,runManagerInfoObj);

				Thread.sleep(5000);
				List<WebElement> AddcontactList=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
					listSize_A = AddcontactList.size();
				}

				System.out.println(listSize_A);

				for(int i=listSize_A;i<=4 ;i++){

					FnVerifyAddNumberOption(driver,runManagerInfoObj);

					List<WebElement> Addcontact_PhoneNumber_List=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
					if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
						Addcontact_PhoneNumber_List.get(i).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"777777"+randomInt);
						repfn.FnUpdateTestStepResHTML("Verify Phone Number" +i+" is Entered ","Phone Number " +i+" is Entered","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Phone Number" +i+" is Entered ","Phone Number " +i+" is not Entered","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}

			}



			WebElement addNewPhone= driver.findElement(By.xpath(mbo.addNewPhone));
			if(!cnf.FnExplicitWait("XPATH", mbo.addNewPhone,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Add Phone option is displayed.","Add Phone option is not displayed.","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Add Phone option is displayed.","Add Phone option is displayed.","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

		}
		catch(Exception e)
		{

			repfn.FnUpdateTestStepResHTML("Verify new phone numbers are added in Edit Contact form.", "New phone numbers are not added in Edit Contact form due to some exception.","FAIL",runManagerInfoObj);
			blnFlag	=false;
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());

		}

		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;

	}

	public synchronized boolean FnAddNewNumber_Save(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

		int listSize = 0;
		String lastNumber = "";
		String fullName = "";

		try{

			if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
				List<WebElement> Addcontact_PhoneNumber_inputList=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
				listSize = Addcontact_PhoneNumber_inputList.size();
			}

			if(listSize == 0){
				for(int i=0;i<(5-listSize);i++){
					blnFlag=FnVerifyAddNumberOption(driver,runManagerInfoObj);
					if(blnFlag){
						if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
							List<WebElement> Addcontact_PhoneNumber_List=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
							Addcontact_PhoneNumber_List.get(i).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"777777"+randomInt);
							repfn.FnUpdateTestStepResHTML("Verify Phone Number" +i+" is Entered ","Phone Number " +i+" is Entered","PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Phone Number" +i+" is Entered ","Phone Number " +i+" is not Entered","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Add Number option is displayed", "Add Number option is not displayed","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
				}
			}

			if(listSize == 1){

				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
					List<WebElement> Addcontact_List=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
					listSize = Addcontact_List.size();
				}

				System.out.println("list size: " +listSize);

				for(int i=listSize;i<=(5-listSize);i++){
					blnFlag=FnVerifyAddNumberOption(driver,runManagerInfoObj);
					if(blnFlag){
						if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
							List<WebElement> Addcontact_PhoneNumber_List=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
							Addcontact_PhoneNumber_List.get(i).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"777777"+randomInt);
							repfn.FnUpdateTestStepResHTML("Verify Phone Number" +i+" is Entered ","Phone Number " +i+" is Entered","PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Phone Number" +i+" is Entered ","Phone Number " +i+" is not Entered","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Add Number option is displayed", "Add Number option is not displayed","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
				}

			}

			if(listSize == 2 || listSize == 3 || listSize == 4){

				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
					List<WebElement> Addcontact_List=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
					listSize = Addcontact_List.size();
				}

				System.out.println("list size: " +listSize);

				for(int i=listSize;i<=4 ;i++){
					blnFlag=FnVerifyAddNumberOption(driver,runManagerInfoObj);
					if(blnFlag){
						if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
							List<WebElement> Addcontact_PhoneNumber_List=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
							Addcontact_PhoneNumber_List.get(i).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"777777"+randomInt);
							repfn.FnUpdateTestStepResHTML("Verify Phone Number" +i+" is Entered ","Phone Number " +i+" is Entered","PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Phone Number" +i+" is Entered ","Phone Number " +i+" is not Entered","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Add Number option is displayed", "Add Number option is not displayed","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
				}

			}


			if(listSize == 5){
				int listSize_A = 0;

				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
					List<WebElement> Addcontact_List=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
					listSize = Addcontact_List.size();
				}

				System.out.println("list size: " +listSize);
				blnFlag=FnVerifyAddNumberOption(driver,runManagerInfoObj);

				Thread.sleep(5000);
				if(blnFlag){
					if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
						List<WebElement> AddcontactList=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
						listSize_A = AddcontactList.size();
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Add Number option is displayed", "Add Number option is not displayed","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}

				System.out.println(listSize_A);

				for(int i=listSize_A;i<=4 ;i++){

					blnFlag=FnVerifyAddNumberOption(driver,runManagerInfoObj);

					if(blnFlag){
						if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
							List<WebElement> Addcontact_PhoneNumber_List=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
							Addcontact_PhoneNumber_List.get(i).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"777777"+randomInt);
							repfn.FnUpdateTestStepResHTML("Verify Phone Number" +i+" is Entered ","Phone Number " +i+" is Entered","PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Phone Number" +i+" is Entered ","Phone Number " +i+" is not Entered","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Add Number option is displayed", "Add Number option is not displayed","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
				}

			}

			if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
				List<WebElement> AddcontactList=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
				lastNumber = AddcontactList.get(4).getAttribute("value");
			}

			String formattedPhone = "(" + lastNumber.substring(0,3) + ") " + lastNumber.substring(3,6) + "-" + lastNumber.substring(6,10);

			//WebElement addNewPhone= driver.findElement(By.xpath(mbo.addNewPhone));
			if(!cnf.FnExplicitWait("XPATH", mbo.addNewPhone,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Add Phone option is displayed.","Add Phone option is not displayed.All the numbers have been added.","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Add Phone option is displayed.","Add Phone option is displayed.","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

			Thread.sleep(2000);

			//cnf.FnExplicitWait("XPATH", mbo.EditMode_firstName);   
			WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
			String newNameFirst = FirstName.getAttribute("value");
			WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
			String lastNameFirst = lastName.getAttribute("value");

			blnFlag=app.FnSaveDataAndGoBack(driver,runManagerInfoObj);
			if(blnFlag){
				fullName = newNameFirst+" "+lastNameFirst;

				Thread.sleep(5000);

				if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
					WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
					cnf.ScrollToView(Search_Field,driver);
					Search_Field.clear();
					Search_Field.sendKeys(fullName);
					repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
					Thread.sleep(2000);

					List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
					if(Contacts_Arrow.get(0).isDisplayed()){
						repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
						if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
							repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
								repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

								Thread.sleep(2000);

								if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumberVerification,driver)){
									repfn.FnUpdateTestStepResHTML("Verify Phone Number list is displayed ","Phone Number list is displayed " ,"PASS",runManagerInfoObj);
									List<WebElement>  Addcontact_PhoneNumberVerification=driver.findElements(By.xpath(mbo. Addcontact_PhoneNumberVerification));
									for(int i=0;i<Addcontact_PhoneNumberVerification.size();i++){
										if(Addcontact_PhoneNumberVerification.get(i).getText().equalsIgnoreCase(formattedPhone)){	
											blnFlag=true;
											break;
										}
										else{
											blnFlag=false;
										}

									}
									if(blnFlag){
										repfn.FnUpdateTestStepResHTML("Verifying if New Phone Number is added ","New Phone Number is added" ,"PASS",runManagerInfoObj);
										blnFlag=true;
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verifying if New Phone Number is added ","New Phone Number is not added" ,"FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Phone Number list is displayed ","Phone Number list is not displayed. No number is added ","FAIL",runManagerInfoObj);
									blnFlag=false;
								}

							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+newNameFirst+ " is not present in Contacts List","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ","Search field is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}	
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if the user is able to save the changes in Edit Contact form. ", "User is not able to save the changes in Edit Contact form","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}


		}
		catch(Exception e)
		{

			repfn.FnUpdateTestStepResHTML("Verify new phone numbers are added in Edit Contact form.", "New phone numbers are not added in Edit Contact form due to some exception.","FAIL",runManagerInfoObj);
			blnFlag	=false;
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());

		}

		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;

	}

	public synchronized boolean FnAddNewNumber_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

		int listSize = 0;
		String lastNumber = "";
		String fullName = "";

		try{


			if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
				List<WebElement> Addcontact_PhoneNumber_inputList=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
				listSize = Addcontact_PhoneNumber_inputList.size();
			}

			if(listSize == 0){
				for(int i=0;i<(5-listSize);i++){
					FnVerifyAddNumberOption(driver,runManagerInfoObj);

					if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
						List<WebElement> Addcontact_PhoneNumber_List=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
						Addcontact_PhoneNumber_List.get(i).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"777777"+randomInt);
						repfn.FnUpdateTestStepResHTML("Verify Phone Number" +i+" is Entered ","Phone Number " +i+" is Entered","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Phone Number" +i+" is Entered ","Phone Number " +i+" is not Entered","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
			}

			if(listSize == 1){

				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
					List<WebElement> Addcontact_List=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
					listSize = Addcontact_List.size();
				}

				System.out.println("list size: " +listSize);

				for(int i=listSize;i<=(5-listSize);i++){
					blnFlag=FnVerifyAddNumberOption(driver,runManagerInfoObj);
					if(blnFlag){
					if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
						List<WebElement> Addcontact_PhoneNumber_List=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
						Addcontact_PhoneNumber_List.get(i).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"777777"+randomInt);
						repfn.FnUpdateTestStepResHTML("Verify Phone Number" +i+" is Entered ","Phone Number " +i+" is Entered","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Phone Number" +i+" is Entered ","Phone Number " +i+" is not Entered","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					}
				}

			}

			if(listSize == 2 || listSize == 3 || listSize == 4){

				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
					List<WebElement> Addcontact_List=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
					listSize = Addcontact_List.size();
				}

				System.out.println("list size: " +listSize);

				for(int i=listSize;i<=4 ;i++){
					blnFlag=FnVerifyAddNumberOption(driver,runManagerInfoObj);
					if(blnFlag){
					if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
						List<WebElement> Addcontact_PhoneNumber_List=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
						Addcontact_PhoneNumber_List.get(i).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"777777"+randomInt);
						repfn.FnUpdateTestStepResHTML("Verify Phone Number" +i+" is Entered ","Phone Number " +i+" is Entered","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Phone Number" +i+" is Entered ","Phone Number " +i+" is not Entered","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					}
				}

			}


			if(listSize == 5){
				int listSize_A = 0;

				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
					List<WebElement> Addcontact_List=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
					listSize = Addcontact_List.size();
				}

				System.out.println("list size: " +listSize);
				blnFlag=FnVerifyAddNumberOption(driver,runManagerInfoObj);

				Thread.sleep(5000);
				if(blnFlag){
				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
					List<WebElement> AddcontactList=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
					listSize_A = AddcontactList.size();
				}
				}

				System.out.println(listSize_A);

				for(int i=listSize_A;i<=4 ;i++){

					blnFlag=FnVerifyAddNumberOption(driver,runManagerInfoObj);

					if(blnFlag){
					if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
						List<WebElement> Addcontact_PhoneNumber_List=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
						Addcontact_PhoneNumber_List.get(i).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"777777"+randomInt);
						repfn.FnUpdateTestStepResHTML("Verify Phone Number" +i+" is Entered ","Phone Number " +i+" is Entered","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Phone Number" +i+" is Entered ","Phone Number " +i+" is not Entered","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					}
				}

			}

			if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
				List<WebElement> AddcontactList=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
				lastNumber = AddcontactList.get(4).getAttribute("value");
			}

			//WebElement addNewPhone= driver.findElement(By.xpath(mbo.addNewPhone));
			if(!cnf.FnExplicitWait("XPATH", mbo.addNewPhone,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Add Phone option is displayed.","Add Phone option is not displayed.All the numbers have been added.","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Add Phone option is displayed.","Add Phone option is displayed.","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

			Thread.sleep(2000);

			//cnf.FnExplicitWait("XPATH", mbo.EditMode_firstName);   
			WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
			String newNameFirst = FirstName.getAttribute("value");
			WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
			String lastNameFirst = lastName.getAttribute("value");


			blnFlag=FnCancelAndGoBack(driver,runManagerInfoObj);
			if(blnFlag){
			fullName = newNameFirst+" "+lastNameFirst;

			Thread.sleep(5000);
			if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
				WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
				cnf.ScrollToView(Search_Field,driver);
				Search_Field.sendKeys(fullName);
				repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
				Thread.sleep(2000);

				List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
				if(Contacts_Arrow.get(0).isDisplayed()){
					repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
					if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
						repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
						if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
							repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

							Thread.sleep(2000);

							if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumberVerification,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Phone Number list is displayed ","Phone Number list is displayed " ,"PASS",runManagerInfoObj);
								List<WebElement>  Addcontact_PhoneNumberVerification=driver.findElements(By.xpath(mbo. Addcontact_PhoneNumberVerification));
								for(int i=0;i<Addcontact_PhoneNumberVerification.size();i++){
									if(!Addcontact_PhoneNumberVerification.get(i).getText().contains(lastNumber)){
										blnFlag=true;
									}
									else{
										blnFlag=false;
									}
								}
								if(blnFlag){
									repfn.FnUpdateTestStepResHTML("Verifying if New PhoneNumber is added ","New PhoneNumber is not added" ,"PASS",runManagerInfoObj);
									blnFlag=true;
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify PhoneNumber is added  ","PhoneNumber is added","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Phone Number list is displayed ","Phone Number list is not displayed. No number is added ","PASS",runManagerInfoObj);
								blnFlag=true;
							}

						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+newNameFirst+ " is not present in Contacts List","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}

			}

		}
		catch(Exception e)
		{

			repfn.FnUpdateTestStepResHTML("Verify new phone numbers are added in Edit Contact form.", "New phone numbers are not added in Edit Contact form due to some exception.","FAIL",runManagerInfoObj);
			blnFlag	=false;
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());

		}

		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;

	}


	public synchronized boolean FNCancelAddcontact_PhoneNumberVerification(WebDriver driver, RunManagerInfo runManagerInfoObj){
		try{


			List<WebElement>  Addcontact_PhoneNumberVerification=driver.findElements(By.xpath(mbo. Addcontact_PhoneNumberVerification));
			if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumberVerification,driver)){
				for(int i=0;i<Addcontact_PhoneNumberVerification.size();i++){
					if(!Addcontact_PhoneNumberVerification.get(i).getAttribute("innerHTML").contains("777")){
						repfn.FnUpdateTestStepResHTML("Verify PhoneNumber is added ","PhoneNumber is not added" ,"PASS",runManagerInfoObj);
						blnFlag=true;
						continue;
					}
					else{
						//repfn.FnUpdateTestStepResHTML("Verify PhoneNumber is added  ","PhoneNumber is added","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

				}
			}

		}
		catch (Exception e)

		{
			repfn.FnUpdateTestStepResHTML("Verify newly added phone numbers are not saved. ","Newly added phone numbers are getting saved due to some exception." ,"FAIL",runManagerInfoObj);
			blnFlag=false;
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());

		}
		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;
	}
	public synchronized boolean FnCheckAddressFields(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

		try{

			//Address Street Label
			if(cnf.FnExplicitWait("XPATH", mbo.addressStreetLabel,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Address Street Label is displayed ","Address Street Label is displayed","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Address Street Label is displayed ","Address Street Label is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

			//Address Street

			if(cnf.FnExplicitWait("XPATH", mbo.addressStreet,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Address Street is displayed ","Address Street is displayed","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Address Street is displayed ","Address Street is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

			//City Label
			if(cnf.FnExplicitWait("XPATH", mbo.cityLabel,driver)){
				repfn.FnUpdateTestStepResHTML("Verify City Label is displayed ","City Label is displayed","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify City Label is displayed ","City Label is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}


			//City
			if(cnf.FnExplicitWait("XPATH", mbo.city,driver)){

				repfn.FnUpdateTestStepResHTML("Verify City is displayed ","City is displayed","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify City is displayed ","City is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

			//State Label
			if(cnf.FnExplicitWait("XPATH", mbo.stateLabel,driver)){

				repfn.FnUpdateTestStepResHTML("Verify State Label is displayed ","State Label is displayed","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify State Label is displayed ","State Label is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}


			//State
			if(cnf.FnExplicitWait("XPATH", mbo.state,driver)){

				repfn.FnUpdateTestStepResHTML("Verify State is displayed ","State is displayed","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify State is displayed ","State is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

			//Zip label
			if(cnf.FnExplicitWait("XPATH", mbo.zipLabel,driver)){

				repfn.FnUpdateTestStepResHTML("Verify Zip Label is displayed ","Zip Label is displayed","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Zip Label is displayed ","Zip Label is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}



			//Zip
			if(cnf.FnExplicitWait("XPATH", mbo.zip,driver)){

				repfn.FnUpdateTestStepResHTML("Verify Zip is displayed ","Zip is displayed","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Zip is displayed ","Zip is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

			//Country Label
			if(cnf.FnExplicitWait("XPATH", mbo.countryLabel,driver)){

				repfn.FnUpdateTestStepResHTML("Verify Country Label is displayed ","Country Label is displayed","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Country Label is displayed ","Country Label is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}




			// Country
			if(cnf.FnExplicitWait("XPATH", mbo.country,driver)){

				repfn.FnUpdateTestStepResHTML("Verify Country is displayed "," Country is displayed","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify  Country is displayed "," Country is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}


		}

		catch(Exception e)
		{

			repfn.FnUpdateTestStepResHTML("Verify all the address fields are displayed.", "All the address fields are not displayed due to some exception.","FAIL",runManagerInfoObj);
			blnFlag	=false;
			System.err.println("Message : "+e.getMessage());
			System.err.println("Cause : "+e.getCause());

		}

		m1.put("STEPSTATUS", blnFlag);
		return blnFlag;


	}
public synchronized boolean FnModifyAddress_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

	String Country = "";
	String fullName = "";
	int listSize = 0;

	try{
		
		if(cnf.FnExplicitWait("XPATH", mbo.addressStreet,driver)){
			List<WebElement> addressStreet=driver.findElements(By.xpath(mbo.addressStreet));
			listSize = addressStreet.size();
		}
		
		if(listSize > 0){
			
			WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
			String newNameFirst = FirstName.getAttribute("value");
			WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
			String lastNameFirst = lastName.getAttribute("value");
			
			if(cnf.FnExplicitWait("XPATH", mbo.country,driver)){
				List<WebElement>  country=driver.findElements(By.xpath(mbo. country));
				if(country.get(0).isDisplayed()){
					String oldValue = country.get(0).getText();
					country.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"United Kingdom"+randomInt);
					String newValue = country.get(0).getText();
					if(newValue != oldValue){
						repfn.FnUpdateTestStepResHTML("Verify Country value is modified "," Country value is modified ","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Country value is modified "," Country value is not modified ","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}

				Country = country.get(0).getAttribute("value");
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Country field is displayed "," Country field is not displayed ","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
			
			fullName = newNameFirst+" "+lastNameFirst;
			driver.manage().window().setSize(new Dimension(100, 100));
			driver.manage().window().maximize();
			blnFlag=FnCancelAndGoBack(driver,runManagerInfoObj);
			
			cnf.scrollUp(driver);
			
			if(blnFlag==true)
			{
				if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
					WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
					cnf.ScrollToView(Search_Field,driver);
					Search_Field.sendKeys(fullName);
					repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
					Thread.sleep(2000);

					List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
					if(Contacts_Arrow.get(0).isDisplayed()){
						repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
						if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
							repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
								repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

								Thread.sleep(2000);

								if(cnf.FnExplicitWait("XPATH",mbo.UserAddressVerification,driver)){
									List<WebElement> UserAddressVerification=driver.findElements(By.xpath(mbo.UserAddressVerification));
									cnf.ScrollToView(UserAddressVerification.get(0),driver);
									if(cnf.FnExplicitWait("XPATH",mbo.UserAddressCountryVerification,driver)){
										List<WebElement> UserAddressCountryVerification=driver.findElements(By.xpath(mbo.UserAddressCountryVerification));
										WebElement UserCountryAddress=UserAddressCountryVerification.get(0);
										if(!UserCountryAddress.getText().contains(Country)){
											repfn.FnUpdateTestStepResHTML("Verify Address is modified or not ", "Address is not modified","PASS",runManagerInfoObj);
											blnFlag=true;
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Address is modified or not ", "Address is modified","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Address is modified or not ", "Address is not modified","PASS",runManagerInfoObj);
										blnFlag=true;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Address field is not displayed in User Details page", "Address field is not displayed in User Details page","PASS",runManagerInfoObj);
									blnFlag=true;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ","Search field is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if the user is able to cancel the changes in Edit Contact form. ", "User is not able to cancel the changes in Edit Contact form","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
			
		}
		else if(listSize == 0){
			repfn.FnUpdateTestStepResHTML("Verify Address is displayed ", "Address is not displayed. No address is added.","PASS",runManagerInfoObj);
			int listSize_A = 0;
			boolean blnFlag1 = FnClickAddAddress(driver,runManagerInfoObj);
			boolean blnFlag2 = app.FnAddAddress(driver,runManagerInfoObj);
			boolean blnFlag3 = app.FnSaveDataAndGoBack(driver,runManagerInfoObj);
			boolean blnFlag4 = FnOpenUserDetailsPage(driver,runManagerInfoObj);
			boolean blnFlag5 = FnOpenEditUserPage(driver,runManagerInfoObj);
			
			if(blnFlag1 && blnFlag2 && blnFlag3 && blnFlag4 && blnFlag5){
				if(cnf.FnExplicitWait("XPATH", mbo.addressStreet,driver)){
					List<WebElement> addressStreet=driver.findElements(By.xpath(mbo.addressStreet));
					listSize_A = addressStreet.size();
				}
				
				if(listSize_A > 0){
					WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
					String newNameFirst = FirstName.getAttribute("value");
					WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
					String lastNameFirst = lastName.getAttribute("value");
					
					if(cnf.FnExplicitWait("XPATH", mbo.country,driver)){
						List<WebElement>  country=driver.findElements(By.xpath(mbo. country));
						if(country.get(0).isDisplayed()){
							String oldValue = country.get(0).getText();
							country.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"United Kingdom"+randomInt);
							String newValue = country.get(0).getText();
							if(newValue != oldValue){
								repfn.FnUpdateTestStepResHTML("Verify Country value is modified "," Country value is modified ","PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Country value is modified "," Country value is not modified ","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}

						Country = country.get(0).getAttribute("value");
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Country field is displayed "," Country field is not displayed ","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					fullName = newNameFirst+" "+lastNameFirst;
					driver.manage().window().setSize(new Dimension(100, 100));
					driver.manage().window().maximize();
					blnFlag=FnCancelAndGoBack(driver,runManagerInfoObj);
					
					cnf.scrollUp(driver);
					
					if(blnFlag==true)
					{
						if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
							WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
							cnf.ScrollToView(Search_Field,driver);
							Search_Field.sendKeys(fullName);
							repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
							Thread.sleep(2000);

							List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
							if(Contacts_Arrow.get(0).isDisplayed()){
								repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
								if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
									repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
									if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
										repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

										Thread.sleep(2000);

										if(cnf.FnExplicitWait("XPATH",mbo.UserAddressVerification,driver)){
											List<WebElement> UserAddressVerification=driver.findElements(By.xpath(mbo.UserAddressVerification));
											cnf.ScrollToView(UserAddressVerification.get(0),driver);
											if(cnf.FnExplicitWait("XPATH",mbo.UserAddressCountryVerification,driver)){
												List<WebElement> UserAddressCountryVerification=driver.findElements(By.xpath(mbo.UserAddressCountryVerification));
												WebElement UserCountryAddress=UserAddressCountryVerification.get(0);
												if(!UserCountryAddress.getText().contains(Country)){
													repfn.FnUpdateTestStepResHTML("Verify Address is modified or not ", "Address is not modified","PASS",runManagerInfoObj);
													blnFlag=true;
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify Address is modified or not ", "Address is modified","FAIL",runManagerInfoObj);
													blnFlag=false;
												}
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify Address is modified or not ", "Address is not modified","PASS",runManagerInfoObj);
												blnFlag=true;
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Address field is not displayed in User Details page", "Address field is not displayed in User Details page","PASS",runManagerInfoObj);
											blnFlag=true;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ","Search field is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify if the user is able to cancel the changes in Edit Contact form. ", "User is not able to cancel the changes in Edit Contact form","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}				
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Address is displayed ", "Address is not displayed","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}	
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Address is added and saved ", "Address is not added and saved","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}	
		}
	}

	catch(Exception e)
	{

		repfn.FnUpdateTestStepResHTML("Verify address field is not modified. ", "Address field is modified due to some exception.","FAIL",runManagerInfoObj);
		blnFlag	=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}

	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}

public synchronized boolean FnPhoneNumber_Save(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

	String phoneNumber = "";
	String fullName = "";
	int listSize = 0;

	try{
		
		if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
			List<WebElement> Addcontact_PhoneNumber_inputText=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
			listSize = Addcontact_PhoneNumber_inputText.size();
		}
		
		if(listSize > 0){
			
			WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
			String newNameFirst = FirstName.getAttribute("value");
			WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
			String lastNameFirst = lastName.getAttribute("value");
			
			if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
				List<WebElement> Addcontact_PhoneNumber_List=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
				Addcontact_PhoneNumber_List.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"666666"+randomInt);
				phoneNumber = Addcontact_PhoneNumber_List.get(0).getAttribute("value");
				repfn.FnUpdateTestStepResHTML("Verify Phone Number is Entered ","Phone Number is Entered: "+phoneNumber,"PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Phone Number is Entered ","Phone Number is not Entered","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
			
			fullName = newNameFirst+" "+lastNameFirst;
			driver.manage().window().setSize(new Dimension(100, 100));
			driver.manage().window().maximize();
			
			String formattedPhone = "(" + phoneNumber.substring(0,3) + ") " + phoneNumber.substring(3,6) + "-" + phoneNumber.substring(6,10); 
			
			blnFlag=app.FnSaveDataAndGoBack(driver,runManagerInfoObj);
			
			cnf.scrollUp(driver);
			
			if(blnFlag==true)
			{
				if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
					WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
					cnf.ScrollToView(Search_Field,driver);
					Search_Field.sendKeys(fullName);
					repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
					Thread.sleep(2000);

					List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
					if(Contacts_Arrow.get(0).isDisplayed()){
						repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
						if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
							repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
								repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

								Thread.sleep(2000);

								if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumberVerification,driver)){
									repfn.FnUpdateTestStepResHTML("Verify Phone Number list is displayed ","Phone Number list is displayed " ,"PASS",runManagerInfoObj);
									List<WebElement>  Addcontact_PhoneNumberVerification=driver.findElements(By.xpath(mbo. Addcontact_PhoneNumberVerification));
									for(int i=0;i<Addcontact_PhoneNumberVerification.size();i++){
										if(Addcontact_PhoneNumberVerification.get(i).getText().contains(formattedPhone)){											
											blnFlag=true;
											break;
										}
										else{
											blnFlag=false;
										}

									}
									if(blnFlag){
										repfn.FnUpdateTestStepResHTML("Verify if Phone Number is modified","Phone Number is modified" ,"PASS",runManagerInfoObj);
										blnFlag=true;
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify if Phone Number is modified ","Phone Number is not modified" ,"FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Phone Number list is displayed ","Phone Number list is not displayed. No number is added ","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ","Search field is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if the user is able to save the changes in Edit Contact form. ", "User is not able to save the changes in Edit Contact form","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
			
		}
		else if(listSize == 0){
			repfn.FnUpdateTestStepResHTML("Verify Phone Number is displayed ", "Phone Number is not displayed. No Phone Number is added.","PASS",runManagerInfoObj);
			int listSize_A = 0;
			FnAddNewNumber_Save(driver,runManagerInfoObj);
			FnOpenEditUserPage(driver,runManagerInfoObj);
			
			if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
				List<WebElement> Addcontact_PhoneNumber_inputText=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
				listSize_A = Addcontact_PhoneNumber_inputText.size();
			}
			
			if(listSize_A > 0){
				WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
				String newNameFirst = FirstName.getAttribute("value");
				WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
				String lastNameFirst = lastName.getAttribute("value");
				
				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
					List<WebElement> Addcontact_PhoneNumber_List=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
					Addcontact_PhoneNumber_List.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"666555"+randomInt);
					phoneNumber = Addcontact_PhoneNumber_List.get(0).getAttribute("value");
					repfn.FnUpdateTestStepResHTML("Verify Phone Number is Entered ","Phone Number is Entered: "+phoneNumber,"PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Phone Number is Entered ","Phone Number is not Entered","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				fullName = newNameFirst+" "+lastNameFirst;
				driver.manage().window().setSize(new Dimension(100, 100));
				driver.manage().window().maximize();
				
				String formattedPhone = "(" + phoneNumber.substring(0,3) + ") " + phoneNumber.substring(3,6) + "-" + phoneNumber.substring(6,10); 
				
				blnFlag=app.FnSaveDataAndGoBack(driver,runManagerInfoObj);
				
				cnf.scrollUp(driver);
				
				if(blnFlag==true)
				{
					if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
						WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
						cnf.ScrollToView(Search_Field,driver);
						Search_Field.sendKeys(fullName);
						repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
						Thread.sleep(2000);

						List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
						if(Contacts_Arrow.get(0).isDisplayed()){
							repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
							if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
								repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
								if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
									repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

									Thread.sleep(2000);

									if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumberVerification,driver)){
										repfn.FnUpdateTestStepResHTML("Verify Phone Number list is displayed ","Phone Number list is displayed " ,"PASS",runManagerInfoObj);
										List<WebElement>  Addcontact_PhoneNumberVerification=driver.findElements(By.xpath(mbo. Addcontact_PhoneNumberVerification));
										for(int i=0;i<Addcontact_PhoneNumberVerification.size();i++){
											if(Addcontact_PhoneNumberVerification.get(i).getText().contains(formattedPhone)){											
												blnFlag=true;
												break;
											}
											else{
												blnFlag=false;
											}

										}
										if(blnFlag){
											repfn.FnUpdateTestStepResHTML("Verify if Phone Number is modified","Phone Number is modified" ,"PASS",runManagerInfoObj);
											blnFlag=true;
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify if Phone Number is modified ","Phone Number is not modified" ,"FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Phone Number list is displayed ","Phone Number list is not displayed. No number is added ","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ","Search field is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify if the user is able to save the changes in Edit Contact form. ", "User is not able to save the changes in Edit Contact form","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}				
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Phone Number is displayed ", "Phone Number is not displayed","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}		
		}
	}

	catch(Exception e)
	{

		repfn.FnUpdateTestStepResHTML("Verify Phone Number is modified. ", "Phone Number is not modified due to some exception.","FAIL",runManagerInfoObj);
		blnFlag	=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}

	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
	
public synchronized boolean FnModifyAddress_Save(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

	String Country = "";
	String fullName = "";
	int listSize = 0;

	try{
		
		if(cnf.FnExplicitWait("XPATH", mbo.addressStreet,driver)){
			List<WebElement> addressStreet=driver.findElements(By.xpath(mbo.addressStreet));
			listSize = addressStreet.size();
		}
		
		if(listSize > 0){
			
			WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
			String newNameFirst = FirstName.getAttribute("value");
			WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
			String lastNameFirst = lastName.getAttribute("value");
			
			if(cnf.FnExplicitWait("XPATH", mbo.country,driver)){
				List<WebElement>  country=driver.findElements(By.xpath(mbo. country));
				if(country.get(0).isDisplayed()){
					String oldValue = country.get(0).getText();
					country.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"United Kingdom"+randomInt);
					String newValue = country.get(0).getText();
					if(newValue != oldValue){
						repfn.FnUpdateTestStepResHTML("Verify Country value is modified "," Country value is modified ","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Country value is modified "," Country value is not modified ","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}

				Country = country.get(0).getAttribute("value");
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Country field is displayed "," Country field is not displayed ","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
			
			fullName = newNameFirst+" "+lastNameFirst;
			driver.manage().window().setSize(new Dimension(100, 100));
			driver.manage().window().maximize();
			blnFlag=app.FnSaveDataAndGoBack(driver,runManagerInfoObj);
			
			cnf.scrollUp(driver);
			
			if(blnFlag==true)
			{
				if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
					WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
					cnf.ScrollToView(Search_Field,driver);
					Search_Field.sendKeys(fullName);
					repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
					Thread.sleep(2000);

					List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
					if(Contacts_Arrow.get(0).isDisplayed()){
						repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
						if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
							repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
								repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

								Thread.sleep(2000);

								if(cnf.FnExplicitWait("XPATH",mbo.UserAddressVerification,driver)){
									List<WebElement> UserAddressVerification=driver.findElements(By.xpath(mbo.UserAddressVerification));
									cnf.ScrollToView(UserAddressVerification.get(0),driver);
									if(cnf.FnExplicitWait("XPATH",mbo.UserAddressCountryVerification,driver)){
										List<WebElement> UserAddressCountryVerification=driver.findElements(By.xpath(mbo.UserAddressCountryVerification));
										WebElement UserCountryAddress=UserAddressCountryVerification.get(0);
										if(UserCountryAddress.getText().contains(Country)){
											repfn.FnUpdateTestStepResHTML("Verify Address is modified or not ", "Address is modified","PASS",runManagerInfoObj);
											blnFlag=true;
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Address is modified or not ", "Address is not modified","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Country value is displayed in User Details page", "Country value is not displayed in User Details page","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Address field is displayed in User Details page", "Address field is not displayed in User Details page","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ","Search field is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if the user is able to save the changes in Edit Contact form. ", "User is not able to save the changes in Edit Contact form","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
			
		}
		else if(listSize == 0){
			repfn.FnUpdateTestStepResHTML("Verify Address is displayed ", "Address is not displayed. No address is added.","PASS",runManagerInfoObj);
			int listSize_A = 0;
			boolean blnFlag1 = FnClickAddAddress(driver,runManagerInfoObj);
			boolean blnFlag2 = app.FnAddAddress(driver,runManagerInfoObj);
			boolean blnFlag3 = app.FnSaveDataAndGoBack(driver,runManagerInfoObj);
			boolean blnFlag4 = FnOpenUserDetailsPage(driver,runManagerInfoObj);
			boolean blnFlag5 = FnOpenEditUserPage(driver,runManagerInfoObj);
			
			if(blnFlag1 && blnFlag2 && blnFlag3 && blnFlag4 && blnFlag5){
				
				if(cnf.FnExplicitWait("XPATH", mbo.addressStreet,driver)){
					List<WebElement> addressStreet=driver.findElements(By.xpath(mbo.addressStreet));
					listSize_A = addressStreet.size();
				}
				
				if(listSize_A > 0){
					WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
					String newNameFirst = FirstName.getAttribute("value");
					WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
					String lastNameFirst = lastName.getAttribute("value");
					
					if(cnf.FnExplicitWait("XPATH", mbo.country,driver)){
						List<WebElement>  country=driver.findElements(By.xpath(mbo. country));
						if(country.get(0).isDisplayed()){
							String oldValue = country.get(0).getText();
							country.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"United Kingdom"+randomInt);
							String newValue = country.get(0).getText();
							if(newValue != oldValue){
								repfn.FnUpdateTestStepResHTML("Verify Country value is modified "," Country value is modified ","PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Country value is modified "," Country value is not modified ","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}

						Country = country.get(0).getAttribute("value");
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Country field is displayed "," Country field is not displayed ","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					fullName = newNameFirst+" "+lastNameFirst;
					driver.manage().window().setSize(new Dimension(100, 100));
					driver.manage().window().maximize();
					blnFlag=app.FnSaveDataAndGoBack(driver,runManagerInfoObj);
					
					cnf.scrollUp(driver);
					
					if(blnFlag==true)
					{
						if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
							WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
							cnf.ScrollToView(Search_Field,driver);
							Search_Field.sendKeys(fullName);
							repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
							Thread.sleep(2000);

							List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
							if(Contacts_Arrow.get(0).isDisplayed()){
								repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
								if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
									repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
									if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
										repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

										Thread.sleep(2000);

										if(cnf.FnExplicitWait("XPATH",mbo.UserAddressVerification,driver)){
											List<WebElement> UserAddressVerification=driver.findElements(By.xpath(mbo.UserAddressVerification));
											cnf.ScrollToView(UserAddressVerification.get(0),driver);
											if(cnf.FnExplicitWait("XPATH",mbo.UserAddressCountryVerification,driver)){
												List<WebElement> UserAddressCountryVerification=driver.findElements(By.xpath(mbo.UserAddressCountryVerification));
												WebElement UserCountryAddress=UserAddressCountryVerification.get(0);
												if(UserCountryAddress.getText().contains(Country)){
													repfn.FnUpdateTestStepResHTML("Verify Address is modified or not ", "Address is modified","PASS",runManagerInfoObj);
													blnFlag=true;
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify Address is modified or not ", "Address is not modified","FAIL",runManagerInfoObj);
													blnFlag=false;
												}
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify Country value is displayed in User Details page", "Country value is not displayed in User Details page","FAIL",runManagerInfoObj);
												blnFlag=false;
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Address field is displayed in User Details page", "Address field is not displayed in User Details page","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ","Search field is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify if the user is able to save the changes in Edit Contact form. ", "User is not able to save the changes in Edit Contact form","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}				
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Address is displayed ", "Address is not displayed","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}	
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Address is added and saved ", "Address is not added and saved","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}	
		}
	}

	catch(Exception e)
	{

		repfn.FnUpdateTestStepResHTML("Verify address field is modified. ", "Address field is not modified due to some exception.","FAIL",runManagerInfoObj);
		blnFlag	=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}

	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}

public synchronized boolean FnDeleteAddress(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
	int listSize = 0;
	try{
		List<WebElement> deleteAddressButtonList=driver.findElements(By.xpath(mbo.deleteAddress));
		if(cnf.FnExplicitWait("XPATH", mbo.deleteAddress,driver)){
			listSize = deleteAddressButtonList.size();
		}

		if(listSize > 0){
			repfn.FnUpdateTestStepResHTML("Verify Address Delete button is displayed ", "Address Delete button is displayed","PASS",runManagerInfoObj);
			cnf.JSClick(deleteAddressButtonList.get(0),driver);
			repfn.FnUpdateTestStepResHTML("Verify Address Delete button is clicked ", "Address Delete button is clicked","PASS",runManagerInfoObj);
			blnFlag	=true;
		}
		else if(listSize == 0){
			repfn.FnUpdateTestStepResHTML("Verify Address Delete button is displayed ", "Address Delete button is not displayed. No address is added.","PASS",runManagerInfoObj);
			int listSize_A = 0;
			FnClickAddAddress(driver,runManagerInfoObj);
			app.FnAddAddress(driver,runManagerInfoObj);
			app.FnSaveDataAndGoBack(driver,runManagerInfoObj);
			FnOpenUserDetailsPage(driver,runManagerInfoObj);
			FnOpenEditUserPage(driver,runManagerInfoObj);
			List<WebElement> deleteAddressBtnList=driver.findElements(By.xpath(mbo.deleteAddress));
			if(cnf.FnExplicitWait("XPATH", mbo.deleteAddress,driver)){
				listSize_A = deleteAddressBtnList.size();
			}

			if(listSize_A > 0){
				repfn.FnUpdateTestStepResHTML("Verify Address Delete button is displayed ", "Address Delete button is displayed","PASS",runManagerInfoObj);
				cnf.JSClick(deleteAddressButtonList.get(0),driver);
				repfn.FnUpdateTestStepResHTML("Verify Address Delete button is clicked ", "Address Delete button is clicked","PASS",runManagerInfoObj);
				blnFlag	=true;
			}
		}

	}

	catch(Exception e)
	{

		repfn.FnUpdateTestStepResHTML("Verify if the user is able to delete the address. ", "User is not able to delete the address due to some exception.","FAIL",runManagerInfoObj);
		blnFlag	=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}

	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;


}

public synchronized boolean FnDeleteAddress_Save(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
	int listSize = 0;
	String AddressStreetValue = "";
	String fullName = "";

	try{

		if(cnf.FnExplicitWait("XPATH", mbo.deleteAddress,driver)){
			List<WebElement> deleteAddressButtonList=driver.findElements(By.xpath(mbo.deleteAddress));
			listSize = deleteAddressButtonList.size();
		}

		if(listSize > 0){
			if(cnf.FnExplicitWait("XPATH", mbo.addressStreet,driver)){
				List<WebElement> addressStreet=driver.findElements(By.xpath(mbo.addressStreet));
				if(addressStreet.get(0).isDisplayed()){
					AddressStreetValue = addressStreet.get(0).getAttribute("value");
				}
			}

			WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
			String newNameFirst = FirstName.getAttribute("value");
			WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
			String lastNameFirst = lastName.getAttribute("value");

			if(cnf.FnExplicitWait("XPATH", mbo.deleteAddress,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Address Delete button is displayed ", "Address Delete button is displayed","PASS",runManagerInfoObj);
				List<WebElement> deleteAddressButtonList=driver.findElements(By.xpath(mbo.deleteAddress));
				if(cnf.JSClick(deleteAddressButtonList.get(0),driver)){
					repfn.FnUpdateTestStepResHTML("Verify Address Delete button is clicked ", "Address Delete button is clicked","PASS",runManagerInfoObj);
					blnFlag	=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Address Delete button is clicked ", "Address Delete button is not clicked","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}

			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Address Delete button is displayed ", "Address Delete button is not displayed","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}

			fullName = newNameFirst+" "+lastNameFirst;

			blnFlag=app.FnSaveDataAndGoBack(driver,runManagerInfoObj);

			Thread.sleep(5000);

			cnf.scrollUp(driver);
			if(blnFlag==true)
			{
				if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
					WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
					cnf.ScrollToView(Search_Field,driver);
					Search_Field.sendKeys(fullName);
					repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
					Thread.sleep(2000);

					List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
					if(Contacts_Arrow.get(0).isDisplayed()){
						repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
						if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
							repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
								repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

								Thread.sleep(2000);

								if(cnf.FnExplicitWait("XPATH",mbo.UserAddressVerification,driver)){
									List<WebElement> UserAddressVerification=driver.findElements(By.xpath(mbo.UserAddressVerification));
									cnf.ScrollToView(UserAddressVerification.get(0),driver);
									if(cnf.FnExplicitWait("XPATH",mbo.UserAddressStreetVerification,driver)){
										List<WebElement> UserAddressStreetVerification=driver.findElements(By.xpath(mbo.UserAddressStreetVerification));
										WebElement UserStreetAddress=UserAddressStreetVerification.get(0);
										if(!UserStreetAddress.getText().contains(AddressStreetValue)){
											repfn.FnUpdateTestStepResHTML("Verify Address is deleted ", "Address is deleted","PASS",runManagerInfoObj);
											blnFlag=true;
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Address is deleted ", "Address is not deleted","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Address is deleted ", "Address is deleted","PASS",runManagerInfoObj);
									blnFlag=true;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Search Field is displayed ","Search Field is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if the user is able to save the changes in Edit Contact form. ", "User is not able to save the changes in Edit Contact form","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
		}
		else if(listSize == 0){
			repfn.FnUpdateTestStepResHTML("Verify Address Delete button is displayed ", "Address Delete button is not displayed. No address is added.","PASS",runManagerInfoObj);
			int listSize_A = 0;
			boolean blnFlag1 = FnClickAddAddress(driver,runManagerInfoObj);
			boolean blnFlag2 = app.FnAddAddress(driver,runManagerInfoObj);
			boolean blnFlag3 = app.FnSaveDataAndGoBack(driver,runManagerInfoObj);
			boolean blnFlag4 = FnOpenUserDetailsPage(driver,runManagerInfoObj);
			boolean blnFlag5 = FnOpenEditUserPage(driver,runManagerInfoObj);
			
			if(blnFlag1 && blnFlag2 && blnFlag3 && blnFlag4 && blnFlag5){
				if(cnf.FnExplicitWait("XPATH", mbo.deleteAddress,driver)){
					List<WebElement> deleteAddressBtnList=driver.findElements(By.xpath(mbo.deleteAddress));
					listSize_A = deleteAddressBtnList.size();
				}

				if(listSize_A > 0){
					if(cnf.FnExplicitWait("XPATH", mbo.addressStreet,driver)){
						List<WebElement> addressStreet=driver.findElements(By.xpath(mbo.addressStreet));
						if(addressStreet.get(0).isDisplayed()){
							AddressStreetValue = addressStreet.get(0).getAttribute("value");
						}
					}

					WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
					String newNameFirst = FirstName.getAttribute("value");
					WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
					String lastNameFirst = lastName.getAttribute("value");

					if(cnf.FnExplicitWait("XPATH", mbo.deleteAddress,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Address Delete button is displayed ", "Address Delete button is displayed","PASS",runManagerInfoObj);
						List<WebElement> deleteAddressButtonList=driver.findElements(By.xpath(mbo.deleteAddress));
						if(cnf.JSClick(deleteAddressButtonList.get(0),driver)){
							repfn.FnUpdateTestStepResHTML("Verify Address Delete button is clicked ", "Address Delete button is clicked","PASS",runManagerInfoObj);
							blnFlag	=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Address Delete button is clicked ", "Address Delete button is not clicked","FAIL",runManagerInfoObj);
							blnFlag	=false;
						}

					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Address Delete button is displayed ", "Address Delete button is not displayed","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}

					fullName = newNameFirst+" "+lastNameFirst;

					blnFlag = app.FnSaveDataAndGoBack(driver,runManagerInfoObj);

					Thread.sleep(5000);

					cnf.scrollUp(driver);

					if(blnFlag){
						if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
							WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
							cnf.ScrollToView(Search_Field,driver);
							Search_Field.sendKeys(fullName);
							repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
							Thread.sleep(2000);

							List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
							if(Contacts_Arrow.get(0).isDisplayed()){
								repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
								if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
									repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
									if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
										repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

										Thread.sleep(2000);

										if(cnf.FnExplicitWait("XPATH",mbo.UserAddressVerification,driver)){
											repfn.FnUpdateTestStepResHTML("Verify Address is deleted ", "Address is not deleted","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Address is deleted ", "Address is deleted","PASS",runManagerInfoObj);
											blnFlag=true;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Search Field is displayed ","Search Field is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify if the user is able to save the changes in Edit Contact form. ", "User is not able to save the changes in Edit Contact form","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Address is displayed ", "Address is not displayed","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Address is added and saved ", "Address is not added and saved","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
		}

	}

	catch(Exception e)
	{

		repfn.FnUpdateTestStepResHTML("Verify if the user is able to delete the address. ", "User is not able to delete the address due to some exception.","FAIL",runManagerInfoObj);
		blnFlag	=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}

	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}

public synchronized boolean FnDeleteAddress_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
	int listSize = 0;
	String AddressStreetValue = "";
	String fullName = "";

	try{

		if(cnf.FnExplicitWait("XPATH", mbo.deleteAddress,driver)){
			List<WebElement> deleteAddressButtonList=driver.findElements(By.xpath(mbo.deleteAddress));
			listSize = deleteAddressButtonList.size();
		}

		if(listSize > 0){
			if(cnf.FnExplicitWait("XPATH", mbo.addressStreet,driver)){
				List<WebElement> addressStreet=driver.findElements(By.xpath(mbo.addressStreet));
				if(addressStreet.get(0).isDisplayed()){
					AddressStreetValue = addressStreet.get(0).getAttribute("value");
				}
			}

			WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
			String newNameFirst = FirstName.getAttribute("value");
			WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
			String lastNameFirst = lastName.getAttribute("value");

			if(cnf.FnExplicitWait("XPATH", mbo.deleteAddress,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Address Delete button is displayed ", "Address Delete button is displayed","PASS",runManagerInfoObj);
				List<WebElement> deleteAddressButtonList=driver.findElements(By.xpath(mbo.deleteAddress));
				if(cnf.JSClick(deleteAddressButtonList.get(0),driver)){
					repfn.FnUpdateTestStepResHTML("Verify Address Delete button is clicked ", "Address Delete button is clicked","PASS",runManagerInfoObj);
					blnFlag	=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Address Delete button is clicked ", "Address Delete button is not clicked","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}

			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Address Delete button is displayed ", "Address Delete button is not displayed","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}

			fullName = newNameFirst+" "+lastNameFirst;

			blnFlag=FnCancelAndGoBack(driver,runManagerInfoObj);

			Thread.sleep(5000);

			cnf.scrollUp(driver);
			if(blnFlag==true)
			{
				if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
					WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
					cnf.ScrollToView(Search_Field,driver);
					Search_Field.sendKeys(fullName);
					repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
					Thread.sleep(2000);

					List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
					if(Contacts_Arrow.get(0).isDisplayed()){
						repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
						if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
							repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
								repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

								Thread.sleep(2000);

								if(cnf.FnExplicitWait("XPATH",mbo.UserAddressVerification,driver)){
									List<WebElement> UserAddressVerification=driver.findElements(By.xpath(mbo.UserAddressVerification));
									cnf.ScrollToView(UserAddressVerification.get(0),driver);
									if(cnf.FnExplicitWait("XPATH",mbo.UserAddressStreetVerification,driver)){
										List<WebElement> UserAddressStreetVerification=driver.findElements(By.xpath(mbo.UserAddressStreetVerification));
										WebElement UserStreetAddress=UserAddressStreetVerification.get(0);
										if(UserStreetAddress.getText().contains(AddressStreetValue)){
											repfn.FnUpdateTestStepResHTML("Verify Address is not deleted ", "Address is not deleted","PASS",runManagerInfoObj);
											blnFlag=true;
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Address is not deleted ", "Address is deleted","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Address is not deleted ", "Address is deleted","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+newNameFirst+ "is not present in Contacts List","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ","Search field is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if the user is able to cancel the changes in Edit Contact form. ", "User is not able to cancel the changes in Edit Contact form","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
		}
		else if(listSize == 0){
			repfn.FnUpdateTestStepResHTML("Verify Address Delete button is displayed ", "Address Delete button is not displayed. No address is added.","PASS",runManagerInfoObj);
			int listSize_A = 0;
			boolean blnFlag1 = FnClickAddAddress(driver,runManagerInfoObj);
			boolean blnFlag2 = app.FnAddAddress(driver,runManagerInfoObj);
			boolean blnFlag3 = app.FnSaveDataAndGoBack(driver,runManagerInfoObj);
			boolean blnFlag4 = FnOpenUserDetailsPage(driver,runManagerInfoObj);
			boolean blnFlag5 = FnOpenEditUserPage(driver,runManagerInfoObj);
			
			if(blnFlag1 && blnFlag2 && blnFlag3 && blnFlag4 && blnFlag5){
				if(cnf.FnExplicitWait("XPATH", mbo.deleteAddress,driver)){
					List<WebElement> deleteAddressBtnList=driver.findElements(By.xpath(mbo.deleteAddress));
					listSize_A = deleteAddressBtnList.size();
				}

				if(listSize_A > 0){
					if(cnf.FnExplicitWait("XPATH", mbo.addressStreet,driver)){
						List<WebElement> addressStreet=driver.findElements(By.xpath(mbo.addressStreet));
						if(addressStreet.get(0).isDisplayed()){
							AddressStreetValue = addressStreet.get(0).getAttribute("value");
						}
					}

					WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
					String newNameFirst = FirstName.getAttribute("value");
					WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
					String lastNameFirst = lastName.getAttribute("value");

					if(cnf.FnExplicitWait("XPATH", mbo.deleteAddress,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Address Delete button is displayed ", "Address Delete button is displayed","PASS",runManagerInfoObj);
						List<WebElement> deleteAddressButtonList=driver.findElements(By.xpath(mbo.deleteAddress));
						if(cnf.JSClick(deleteAddressButtonList.get(0),driver)){
							repfn.FnUpdateTestStepResHTML("Verify Address Delete button is clicked ", "Address Delete button is clicked","PASS",runManagerInfoObj);
							blnFlag	=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Address Delete button is clicked ", "Address Delete button is not clicked","FAIL",runManagerInfoObj);
							blnFlag	=false;
						}

					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Address Delete button is displayed ", "Address Delete button is not displayed","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}

					fullName = newNameFirst+" "+lastNameFirst;

					blnFlag = FnCancelAndGoBack(driver,runManagerInfoObj);

					Thread.sleep(5000);

					if(blnFlag){
						if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
							WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
							cnf.ScrollToView(Search_Field,driver);
							Search_Field.sendKeys(fullName);
							repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
							Thread.sleep(2000);

							List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
							if(Contacts_Arrow.get(0).isDisplayed()){
								repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
								if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
									repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
									if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
										repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

										Thread.sleep(2000);

										if(cnf.FnExplicitWait("XPATH",mbo.UserAddressVerification,driver)){
											List<WebElement> UserAddressVerification=driver.findElements(By.xpath(mbo.UserAddressVerification));
											cnf.ScrollToView(UserAddressVerification.get(0),driver);
											if(cnf.FnExplicitWait("XPATH",mbo.UserAddressStreetVerification,driver)){
												List<WebElement> UserAddressStreetVerification=driver.findElements(By.xpath(mbo.UserAddressStreetVerification));
												WebElement UserStreetAddress=UserAddressStreetVerification.get(0);
												if(UserStreetAddress.getText().contains(AddressStreetValue)){
													repfn.FnUpdateTestStepResHTML("Verify Address is not deleted ", "Address is not deleted","PASS",runManagerInfoObj);
													blnFlag=true;
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify Address is not deleted ", "Address is deleted","FAIL",runManagerInfoObj);
													blnFlag=false;
												}
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Address is not deleted ", "Address is deleted","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ","Search field is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify if the user is cancel to save the changes in Edit Contact form. ", "User is not able to cancel the changes in Edit Contact form","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}

				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Address is displayed ","Address is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Address is added and saved ", "Address is not added and saved","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
		}
	}

	catch(Exception e)
	{

		repfn.FnUpdateTestStepResHTML("Verify if the user is able to delete the address. ", "User is not able to delete the address due to some exception.","FAIL",runManagerInfoObj);
		blnFlag	=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}

	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;


}
public synchronized boolean FnValidateAddressField(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
	int listSize = 0;
	try{
		
		if(cnf.FnExplicitWait("XPATH", mbo.addressCount,driver)){
			List<WebElement> addressCount= driver.findElements(By.xpath(mbo.addressCount));
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(mbo.addressCount))); 
			driver.manage().window().setSize(new Dimension(100, 100));
			driver.manage().window().maximize();
			blnFlag = FnValidateAddress(driver,runManagerInfoObj);
			if(blnFlag){
				blnFlag	= true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify address is validated.", "New address is not validated","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
		}
		else{
			boolean blnFlagOne = FnClickAddAddress(driver,runManagerInfoObj);
			if(blnFlagOne){
				blnFlag = FnValidateAddress(driver,runManagerInfoObj);
				if(blnFlag){
					blnFlag	= true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify address is validated.", "New address is not validated","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify address fields are displayed.", "Address fields are not displayed","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
		}
	}
	catch(Exception e)
	{

		repfn.FnUpdateTestStepResHTML("Verify address fields are displayed.", "Address fields are not displayed due to some exception.","FAIL",runManagerInfoObj);
		blnFlag	=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}

	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;

}

public synchronized boolean FnValidateAddress(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
	int listSize = 0;
	try{

		if(cnf.FnExplicitWait("XPATH", mbo.AddressList,driver)){
			List<WebElement> addressCount= driver.findElements(By.xpath(mbo.AddressList));
			listSize = addressCount.size();
		}

		System.out.println(listSize);

		if(listSize > 0){		
			if(cnf.FnExplicitWait("XPATH", mbo.city,driver)){
				List<WebElement> city=driver.findElements(By.xpath(mbo.city));
				if(city.get(0).isDisplayed()){
					String EnteredCityValue = "mnbvcxzasdfghjklpoiuytrewqazxcvbnmlkj";
					int EnteredCityValuelength = EnteredCityValue.length();
					System.out.println("Entered value: " +EnteredCityValuelength);
					city.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),EnteredCityValue);
					String newCityValue = city.get(0).getAttribute("value");
					int newCityValuelength = newCityValue.length();
					System.out.println("new value: " +newCityValue);
					if(newCityValuelength != EnteredCityValuelength){
						repfn.FnUpdateTestStepResHTML("Verify City value can not take more than 32 varchar value "," City value has 32 varchar limit validation ","PASS",runManagerInfoObj);
						blnFlag	= true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify City value can not take more than 32 varchar value "," City value doesnot have 32 varchar limit validation ","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify City field is displayed "," City field is not displayed ","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}

			
			if(cnf.FnExplicitWait("XPATH", mbo.state,driver)){
				List<WebElement> state=driver.findElements(By.xpath(mbo.state));
				if(state.get(0).isDisplayed()){
					String enteredStateValue = "mnbvcxzasdfghjklpoiuytrewqazxcvbnmlkj";
					int enteredStateValuelength = enteredStateValue.length();
					System.out.println("old value: " +enteredStateValue);
					state.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),enteredStateValue);
					String newStateValue = state.get(0).getAttribute("value");
					int newStateValuelength = newStateValue.length();
					System.out.println("new value: " +newStateValue);
					if(newStateValuelength != enteredStateValuelength){
						repfn.FnUpdateTestStepResHTML("Verify State value can not take more than 32 varchar value  "," State value has 32 varchar limit validation ","PASS",runManagerInfoObj);	
						blnFlag	= true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify State value can not take more than 32 varchar value "," State value doesnot have 32 varchar limit validation ","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify State field is displayed "," State field is not displayed ","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
			
			if(cnf.FnExplicitWait("XPATH", mbo.zip,driver)){
				List<WebElement> zip=driver.findElements(By.xpath(mbo.zip));
				if(zip.get(0).isDisplayed()){
					String enteredZipValue ="12345678900987654321123456789009876";
					int enteredZipValuelength = enteredZipValue.length();
					System.out.println("old value: " +enteredZipValue);
					zip.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),enteredZipValue);
					String newZipValue = zip.get(0).getAttribute("value");
					int newZipValuelength = newZipValue.length();
					System.out.println("new value: " +newZipValue);
					if(newZipValuelength != enteredZipValuelength){
						repfn.FnUpdateTestStepResHTML("Verify Zip value can not take more than 32 varchar value  "," Zip value has 32 varchar limit validation ","PASS",runManagerInfoObj);
						blnFlag	= true;		
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Zip value can not take more than 32 varchar value  "," Zip value doesnot have 32 varchar limit validation ","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Zip field is displayed "," Zip field is not displayed ","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
			
			
			if(cnf.FnExplicitWait("XPATH", mbo.country,driver)){
				List<WebElement> country=driver.findElements(By.xpath(mbo.country));
				if(country.get(0).isDisplayed()){
					String enteredCountryValue = "mnbvcxzasdfghjklpoiuytrewqazxcvbnmlkj";
					int enteredCountryValuelength = enteredCountryValue.length();
					System.out.println("old value: " +enteredCountryValue);
					country.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),enteredCountryValue);
					String newCountryValue = country.get(0).getAttribute("value");
					int newCountryValuelength = newCountryValue.length();
					System.out.println("new value: " +newCountryValue);
					if(newCountryValuelength != enteredCountryValuelength){
						repfn.FnUpdateTestStepResHTML("Verify Country value can not take more than 32 varchar value "," Country value has 32 varchar limit validation ","PASS",runManagerInfoObj);
						blnFlag = true;			
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Country value can not take more than 32 varchar value"," Country value doesnot have 32 varchar limit validation ","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}	
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Country field is displayed "," Country field is not displayed ","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify address fields are displayed.", "Address fields are not displayed","FAIL",runManagerInfoObj);
			blnFlag	=false;
		}

	}

	catch(Exception e)
	{
		repfn.FnUpdateTestStepResHTML("Verify address is validated.", "New address is not validated due to some exception.","FAIL",runManagerInfoObj);
		blnFlag	=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}

	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean FN_RemovePhoneNoClick(WebDriver driver, RunManagerInfo runManagerInfoObj){
	
	int listSize = 0;
	int listSizeOne = 0;
	String phoneType = "";
	String fullName = "";

	try{
		
		if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
			List<WebElement> Addcontact_PhoneNumber_inputText=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
			listSize = Addcontact_PhoneNumber_inputText.size();
			listSizeOne = Addcontact_PhoneNumber_inputText.size();
		}
		
		if(listSize > 0){
			
			WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
			String newNameFirst = FirstName.getAttribute("value");
			WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
			String lastNameFirst = lastName.getAttribute("value");
			
			if(cnf.FnExplicitWait("XPATH", mbo.EditModeUserPhoneType,driver)){
				List<WebElement> EditModeUserPhoneType=driver.findElements(By.xpath(mbo.EditModeUserPhoneType));
				phoneType = EditModeUserPhoneType.get(0).getAttribute("textContent");
			}
			else{
				if(cnf.FnExplicitWait("XPATH", mbo.EditModeUserPhoneTypeInput,driver)){
					List<WebElement> EditModeUserPhoneTypeInput=driver.findElements(By.xpath(mbo.EditModeUserPhoneTypeInput));
					phoneType = EditModeUserPhoneTypeInput.get(0).getAttribute("textContent");
				}
			}
			
			System.out.println("phone type123:"+phoneType);
			
			if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_RemovePhoneNumber,driver)){
				List<WebElement> Addcontact_RemovePhoneNumber=driver.findElements(By.xpath(mbo.Addcontact_RemovePhoneNumber));
				repfn.FnUpdateTestStepResHTML("Verify Remove Phone Number icon is present","Remove Phone Number icon is present","PASS",runManagerInfoObj);
				if(cnf.JSClick(Addcontact_RemovePhoneNumber.get(0),driver)){
					repfn.FnUpdateTestStepResHTML("Verify Remove Phone Number icon is clicked","Remove Phone Number icon is clicked","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Remove Phone Number icon is clicked","Remove Phone Number icon is not clicked","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Remove Phone Number icon is present","Remove Phone Number icon is not present","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
			
			fullName = newNameFirst+" "+lastNameFirst;
			driver.manage().window().setSize(new Dimension(100, 100));
			driver.manage().window().maximize();
			 			
			blnFlag=app.FnSaveDataAndGoBack(driver,runManagerInfoObj);
			
			cnf.scrollUp(driver);
			
			if(blnFlag==true)
			{
				if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
					WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
					cnf.ScrollToView(Search_Field,driver);
					Search_Field.clear();
					Search_Field.sendKeys(fullName);
					repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
					Thread.sleep(2000);

					List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
					if(Contacts_Arrow.get(0).isDisplayed()){
						repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
						if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
							repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
								repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

								Thread.sleep(2000);

								if(listSizeOne > 1){
									if(cnf.FnExplicitWait("XPATH", mbo.UserContactPhoneTypeDisplay,driver)){
										repfn.FnUpdateTestStepResHTML("Verify Phone Number list is displayed ","Phone Number list is displayed " ,"PASS",runManagerInfoObj);
										List<WebElement>  UserContactPhoneTypeDisplay=driver.findElements(By.xpath(mbo. UserContactPhoneTypeDisplay));
										for(int i=0;i<UserContactPhoneTypeDisplay.size();i++){
											if(UserContactPhoneTypeDisplay.get(i).getText().contains(phoneType)){											
												blnFlag=false;
											}
											else{
												blnFlag=true;
											}
										}
										if(blnFlag){
											repfn.FnUpdateTestStepResHTML("Verify if Phone Number is removed","Phone Number is removed" ,"PASS",runManagerInfoObj);
											blnFlag=true;
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify if Phone Number is removed ","Phone Number is not removed" ,"FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Phone Number list is displayed ","Phone Number list is not displayed. No number is added ","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									if(cnf.FnExplicitWait("XPATH", mbo.UserContactPhoneTypeDisplay,driver)){
										repfn.FnUpdateTestStepResHTML("Verify if Phone Number is removed ","Phone Number is not removed" ,"FAIL",runManagerInfoObj);
										blnFlag=false;
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify if Phone Number is removed","Phone Number is removed" ,"PASS",runManagerInfoObj);
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
							repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ","Search field is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if the user is able to save the changes in Edit Contact form. ", "User is not able to save the changes in Edit Contact form","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
		}
		else if(listSize == 0){
			repfn.FnUpdateTestStepResHTML("Verify Phone Number is displayed ", "Phone Number is not displayed. No Phone Number is added.","PASS",runManagerInfoObj);
			int listSize_A = 0;
			int listSizeOne_A = 0;
			boolean blnFlag1 = FnAddNewNumber_Save(driver,runManagerInfoObj);
			boolean blnFlag2 = FnOpenEditUserPage(driver,runManagerInfoObj);
			
			if(blnFlag1 && blnFlag2){
				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
					List<WebElement> Addcontact_PhoneNumber_inputText=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
					listSize_A = Addcontact_PhoneNumber_inputText.size();
					listSizeOne_A = Addcontact_PhoneNumber_inputText.size();
				}
				
				if(listSize_A > 0){
					WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
					String newNameFirst = FirstName.getAttribute("value");
					WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
					String lastNameFirst = lastName.getAttribute("value");
					
					if(cnf.FnExplicitWait("XPATH", mbo.EditModeUserPhoneType,driver)){
						List<WebElement> EditModeUserPhoneType=driver.findElements(By.xpath(mbo.EditModeUserPhoneType));
						phoneType = EditModeUserPhoneType.get(0).getAttribute("textContent");
					}
					else{
						if(cnf.FnExplicitWait("XPATH", mbo.EditModeUserPhoneTypeInput,driver)){
							List<WebElement> EditModeUserPhoneTypeInput=driver.findElements(By.xpath(mbo.EditModeUserPhoneTypeInput));
							phoneType = EditModeUserPhoneTypeInput.get(0).getAttribute("textContent");
						}
					}
					
					if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_RemovePhoneNumber,driver)){
						List<WebElement> Addcontact_RemovePhoneNumber=driver.findElements(By.xpath(mbo.Addcontact_RemovePhoneNumber));
						repfn.FnUpdateTestStepResHTML("Verify Remove Phone Number icon is present","Remove Phone Number icon is present","PASS",runManagerInfoObj);
						if(cnf.JSClick(Addcontact_RemovePhoneNumber.get(0),driver)){
							repfn.FnUpdateTestStepResHTML("Verify Remove Phone Number icon is clicked","Remove Phone Number icon is clicked","PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Remove Phone Number icon is clicked","Remove Phone Number icon is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Remove Phone Number icon is present","Remove Phone Number icon is not present","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					fullName = newNameFirst+" "+lastNameFirst;
					driver.manage().window().setSize(new Dimension(100, 100));
					driver.manage().window().maximize();
					 					
					blnFlag=app.FnSaveDataAndGoBack(driver,runManagerInfoObj);
					
					cnf.scrollUp(driver);
					
					if(blnFlag==true)
					{
						if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
							WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
							cnf.ScrollToView(Search_Field,driver);
							Search_Field.clear();
							Search_Field.sendKeys(fullName);
							repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
							Thread.sleep(2000);

							List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
							if(Contacts_Arrow.get(0).isDisplayed()){
								repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
								if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
									repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
									if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
										repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

										Thread.sleep(2000);

										if(listSizeOne_A > 1){
											if(cnf.FnExplicitWait("XPATH", mbo.UserContactPhoneTypeDisplay,driver)){
												repfn.FnUpdateTestStepResHTML("Verify Phone Number list is displayed ","Phone Number list is displayed " ,"PASS",runManagerInfoObj);
												List<WebElement>  UserContactPhoneTypeDisplay=driver.findElements(By.xpath(mbo. UserContactPhoneTypeDisplay));
												for(int i=0;i<UserContactPhoneTypeDisplay.size();i++){
													if(UserContactPhoneTypeDisplay.get(i).getText().contains(phoneType)){											
														blnFlag=false;
													}
													else{
														blnFlag=true;
													}
												}
												if(blnFlag){
													repfn.FnUpdateTestStepResHTML("Verify if Phone Number is removed","Phone Number is removed" ,"PASS",runManagerInfoObj);
													blnFlag=true;
												}
												else{
													repfn.FnUpdateTestStepResHTML("Verify if Phone Number is removed ","Phone Number is not removed" ,"FAIL",runManagerInfoObj);
													blnFlag=false;
												}
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify Phone Number list is displayed ","Phone Number list is not displayed. No number is added ","FAIL",runManagerInfoObj);
												blnFlag=false;
											}
										}
										else{
											if(cnf.FnExplicitWait("XPATH", mbo.UserContactPhoneTypeDisplay,driver)){
												repfn.FnUpdateTestStepResHTML("Verify if Phone Number is removed ","Phone Number is not removed" ,"FAIL",runManagerInfoObj);
												blnFlag=false;
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify if Phone Number is removed","Phone Number is removed" ,"PASS",runManagerInfoObj);
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
									repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ","Search field is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify if the user is able to save the changes in Edit Contact form. ", "User is not able to save the changes in Edit Contact form","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Phone Number is displayed", "Phone Number is not displayed","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Phone Number is displayed", "Phone Number is not displayed","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
		}
	}

	catch (Exception e)
	{
		repfn.FnUpdateTestStepResHTML("Verify Phone number is removed","Phone number is not removed due to some exception ","FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}

public synchronized boolean FN_RemovePhoneNoClick_Add_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj){
	
	int listSize = 0;
	String phoneType = "";
	String fullName = "";

	try{
		
		if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
			List<WebElement> Addcontact_PhoneNumber_inputText=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
			listSize = Addcontact_PhoneNumber_inputText.size();
		}
		
		if(listSize > 0){
			
			WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
			String newNameFirst = FirstName.getAttribute("value");
			WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
			String lastNameFirst = lastName.getAttribute("value");
			
			if(cnf.FnExplicitWait("XPATH", mbo.EditModeUserPhoneTypeInput,driver)){
				List<WebElement> EditModeUserPhoneType=driver.findElements(By.xpath(mbo.EditModeUserPhoneTypeInput));
				phoneType = EditModeUserPhoneType.get(0).getAttribute("textContent");
			}
			
			if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_RemovePhoneNumber,driver)){
				List<WebElement> Addcontact_RemovePhoneNumber=driver.findElements(By.xpath(mbo.Addcontact_RemovePhoneNumber));
				repfn.FnUpdateTestStepResHTML("Verify Remove Phone Number icon is present","Remove Phone Number icon is present","PASS",runManagerInfoObj);
				if(cnf.JSClick(Addcontact_RemovePhoneNumber.get(0),driver)){
					repfn.FnUpdateTestStepResHTML("Verify Remove Phone Number icon is clicked","Remove Phone Number icon is clicked","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Remove Phone Number icon is clicked","Remove Phone Number icon is not clicked","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Remove Phone Number icon is present","Remove Phone Number icon is not present","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
			
			fullName = newNameFirst+" "+lastNameFirst;
			driver.manage().window().setSize(new Dimension(100, 100));
			driver.manage().window().maximize();
			 
			Thread.sleep(2000);
			
			if(cnf.FnExplicitWait("XPATH", mbo.CancelEdit,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Cancel option is displayed ","Cancel option is displayed","PASS",runManagerInfoObj);
				WebElement Cancel=driver.findElement(By.xpath(mbo.CancelEdit));
					if(cnf.JSClick(Cancel,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Cancel option is clicked ","Cancel option is clicked","PASS",runManagerInfoObj);
						if(cnf.FnExplicitWait("XPATH", mbo.ConfirmCancel,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Confirm option is displayed ","Confirm option is displayed","PASS",runManagerInfoObj);
							WebElement ConfirmCancel=driver.findElement(By.xpath(mbo.ConfirmCancel));
							if(cnf.JSClick(ConfirmCancel,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Adding User Contact is canceled"," Confirm Option is clicked. Hence, Adding User Contact is canceled","PASS",runManagerInfoObj);
								blnFlag	= true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Adding User Contact is canceled"," Confirm Option is not clicked. Adding User Contact was not canceled","FAIL",runManagerInfoObj);
								blnFlag	= false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Confirm option is displayed ","Confirm option is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Cancel option is clicked ","Cancel option is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Cancel option is displayed ","Cancel option is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
			
			Thread.sleep(5000);
							
			if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
				WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
				cnf.ScrollToView(Search_Field,driver);
				Search_Field.clear();
				Search_Field.sendKeys(fullName);
				Thread.sleep(2000);
				//cnf.FnExplicitWait("XPATH", mbo.contactNameList);
				
				if(cnf.FnExplicitWait("XPATH", mbo.contactNameList,driver)){
					List<WebElement> contactNameList= driver.findElements(By.xpath(mbo.contactNameList));
					//repfn.FnUpdateTestStepResHTML("Verify Contact is present in the Contacts List with First Name as: "+newNameFirst," Contact is present in the Contacts List with First Name as: "+newNameFirst,"PASS",runManagerInfoObj);
					
					for(WebElement name:contactNameList){
						if(!name.getText().equalsIgnoreCase(fullName)){
							blnFlag	= true;
						}
						else{
							blnFlag	= false;
						}
					}
					
					if(blnFlag){
						repfn.FnUpdateTestStepResHTML("Verify Newly added Contact is not added to Contacts list", "Newly added Contact is not added to Contacts list","PASS",runManagerInfoObj);
						blnFlag	= true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify New Contact is not added to Contacts list", "New Contact is added to Contacts list","FAIL",runManagerInfoObj);
						blnFlag	= false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Contact is present in the Contacts List with First Name as: "+newNameFirst," Contact is not present in the Contacts List with First Name as: "+newNameFirst,"PASS",runManagerInfoObj);
					blnFlag	= true;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Search field is displayed", "Search field is not displayed","FAIL",runManagerInfoObj);
				blnFlag	= false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Phone Number is displayed", "Phone Number is not displayed","FAIL",runManagerInfoObj);
			blnFlag	= false;
		}

	}

	catch (Exception e)
	{
		repfn.FnUpdateTestStepResHTML("Verify Phone number is removed","Phone number is not removed due to some exception ","FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean FN_RemovePhoneNoClick_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj){
	
	int listSize = 0;
	String phoneType = "";
	String fullName = "";

	try{
		
		if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
			List<WebElement> Addcontact_PhoneNumber_inputText=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
			listSize = Addcontact_PhoneNumber_inputText.size();		
		}
		
		if(listSize > 0){
			
			WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
			String newNameFirst = FirstName.getAttribute("value");
			WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
			String lastNameFirst = lastName.getAttribute("value");
			
			if(cnf.FnExplicitWait("XPATH", mbo.EditModeUserPhoneType,driver)){
				List<WebElement> EditModeUserPhoneType=driver.findElements(By.xpath(mbo.EditModeUserPhoneType));
				phoneType = EditModeUserPhoneType.get(0).getAttribute("textContent");
			}
			else{
				if(cnf.FnExplicitWait("XPATH", mbo.EditModeUserPhoneTypeInput,driver)){
					List<WebElement> EditModeUserPhoneTypeInput=driver.findElements(By.xpath(mbo.EditModeUserPhoneTypeInput));
					phoneType = EditModeUserPhoneTypeInput.get(0).getAttribute("textContent");
				}
			}
			
			if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_RemovePhoneNumber,driver)){
				List<WebElement> Addcontact_RemovePhoneNumber=driver.findElements(By.xpath(mbo.Addcontact_RemovePhoneNumber));
				repfn.FnUpdateTestStepResHTML("Verify Remove Phone Number icon is present","Remove Phone Number icon is present","PASS",runManagerInfoObj);
				if(cnf.JSClick(Addcontact_RemovePhoneNumber.get(0),driver)){
					repfn.FnUpdateTestStepResHTML("Verify Remove Phone Number icon is clicked","Remove Phone Number icon is clicked","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Remove Phone Number icon is clicked","Remove Phone Number icon is not clicked","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Remove Phone Number icon is present","Remove Phone Number icon is not present","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
			
			fullName = newNameFirst+" "+lastNameFirst;
			driver.manage().window().setSize(new Dimension(100, 100));
			driver.manage().window().maximize();
			 
			
			blnFlag=FnCancelAndGoBack(driver,runManagerInfoObj);
			
			cnf.scrollUp(driver);
			
			if(blnFlag==true)
			{
				if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
					WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
					cnf.ScrollToView(Search_Field,driver);
					Search_Field.clear();
					Search_Field.sendKeys(fullName);
					repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
					Thread.sleep(2000);

					List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
					if(Contacts_Arrow.get(0).isDisplayed()){
						repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
						if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
							repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
								repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

								Thread.sleep(2000);

								if(cnf.FnExplicitWait("XPATH", mbo.UserContactPhoneTypeDisplay,driver)){
									repfn.FnUpdateTestStepResHTML("Verify Phone Number list is displayed ","Phone Number list is displayed " ,"PASS",runManagerInfoObj);
									List<WebElement>  UserContactPhoneTypeDisplay=driver.findElements(By.xpath(mbo. UserContactPhoneTypeDisplay));
									for(int i=0;i<UserContactPhoneTypeDisplay.size();i++){
										if(UserContactPhoneTypeDisplay.get(i).getText().contains(phoneType)){											
											blnFlag=true;
											break;
										}
										else{
											blnFlag=false;
										}
									}
									if(blnFlag){
										repfn.FnUpdateTestStepResHTML("Verify if Phone Number is not removed","Phone Number is not removed" ,"PASS",runManagerInfoObj);
										blnFlag=true;
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify if Phone Number is not removed ","Phone Number is removed" ,"FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Phone Number list is displayed ","Phone Number list is not displayed. No number is added ","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ","Search field is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if the user is able to save the changes in Edit Contact form. ", "User is not able to save the changes in Edit Contact form","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
		}
		else if(listSize == 0){
			repfn.FnUpdateTestStepResHTML("Verify Phone Number is displayed ", "Phone Number is not displayed. No Phone Number is added.","PASS",runManagerInfoObj);
			int listSize_A = 0;
			boolean blnFlag1 = FnAddNewNumber_Save(driver,runManagerInfoObj);
			boolean blnFlag2 = FnOpenEditUserPage(driver,runManagerInfoObj);
			
			if(blnFlag1 && blnFlag2){
				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
					List<WebElement> Addcontact_PhoneNumber_inputText=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
					listSize_A = Addcontact_PhoneNumber_inputText.size();
				}
				
				if(listSize_A > 0){
					WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
					String newNameFirst = FirstName.getAttribute("value");
					WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
					String lastNameFirst = lastName.getAttribute("value");
					
					if(cnf.FnExplicitWait("XPATH", mbo.EditModeUserPhoneType,driver)){
						List<WebElement> EditModeUserPhoneType=driver.findElements(By.xpath(mbo.EditModeUserPhoneType));
						phoneType = EditModeUserPhoneType.get(0).getAttribute("textContent");
					}
					else{
						if(cnf.FnExplicitWait("XPATH", mbo.EditModeUserPhoneTypeInput,driver)){
							List<WebElement> EditModeUserPhoneTypeInput=driver.findElements(By.xpath(mbo.EditModeUserPhoneTypeInput));
							phoneType = EditModeUserPhoneTypeInput.get(0).getAttribute("textContent");
						}
					}
					
					if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_RemovePhoneNumber,driver)){
						List<WebElement> Addcontact_RemovePhoneNumber=driver.findElements(By.xpath(mbo.Addcontact_RemovePhoneNumber));
						repfn.FnUpdateTestStepResHTML("Verify Remove Phone Number icon is present","Remove Phone Number icon is present","PASS",runManagerInfoObj);
						if(cnf.JSClick(Addcontact_RemovePhoneNumber.get(0),driver)){
							repfn.FnUpdateTestStepResHTML("Verify Remove Phone Number icon is clicked","Remove Phone Number icon is clicked","PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Remove Phone Number icon is clicked","Remove Phone Number icon is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Remove Phone Number icon is present","Remove Phone Number icon is not present","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					fullName = newNameFirst+" "+lastNameFirst;
					driver.manage().window().setSize(new Dimension(100, 100));
					driver.manage().window().maximize();
					 					
					blnFlag=FnCancelAndGoBack(driver,runManagerInfoObj);
					
					cnf.scrollUp(driver);
					
					if(blnFlag==true)
					{
						if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
							WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
							cnf.ScrollToView(Search_Field,driver);
							Search_Field.clear();
							Search_Field.sendKeys(fullName);
							repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
							Thread.sleep(2000);

							List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
							if(Contacts_Arrow.get(0).isDisplayed()){
								repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
								if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
									repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
									if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
										repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

										Thread.sleep(2000);

										if(cnf.FnExplicitWait("XPATH", mbo.UserContactPhoneTypeDisplay,driver)){
											repfn.FnUpdateTestStepResHTML("Verify Phone Number list is displayed ","Phone Number list is displayed " ,"PASS",runManagerInfoObj);
											List<WebElement>  UserContactPhoneTypeDisplay=driver.findElements(By.xpath(mbo. UserContactPhoneTypeDisplay));
											for(int i=0;i<UserContactPhoneTypeDisplay.size();i++){
												if(UserContactPhoneTypeDisplay.get(i).getText().contains(phoneType)){											
													blnFlag=true;
													break;
												}
												else{
													blnFlag=false;
												}
											}
											if(blnFlag){
												repfn.FnUpdateTestStepResHTML("Verify if Phone Number is not removed","Phone Number is not removed" ,"PASS",runManagerInfoObj);
												blnFlag=true;
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify if Phone Number is not removed ","Phone Number is removed" ,"FAIL",runManagerInfoObj);
												blnFlag=false;
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Phone Number list is displayed ","Phone Number list is not displayed. No number is added ","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ","Search field is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify if the user is able to save the changes in Edit Contact form. ", "User is not able to save the changes in Edit Contact form","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Phone Number is displayed", "Phone Number is not displayed","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Phone Number is displayed", "Phone Number is not displayed","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
		}
	}

	catch (Exception e)
	{
		repfn.FnUpdateTestStepResHTML("Verify Phone number is removed","Phone number is not removed due to some exception ","FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}


public synchronized boolean FN_addcontactClick(WebDriver driver, RunManagerInfo runManagerInfoObj){
	try{

		if(cnf.FnExplicitWait("XPATH",mbo.Add_ContactButton,driver)){
			WebElement Add_ContactButton=driver.findElement(By.xpath(mbo.Add_ContactButton));

			repfn.FnUpdateTestStepResHTML("Verify Add Contact button is present in Contact page ","Add Contact Button is present in Contact page","PASS",runManagerInfoObj);
			if(cnf.ElementClick(Add_ContactButton,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Add Contact Button is Clicked ","Add ContactButton is Clicked","PASS",runManagerInfoObj);
				
				if(cnf.FnExplicitWait("XPATH", mbo.AddContact_Window,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Contact window information is displayed afer clicking Add ContactButton ","Add Contact window information is displayed afer clicking Add ContactButton","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Contact window information is displayed afer clicking Add ContactButton ","Add Contact window information is not  displayed afer clicking Add ContactButton","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Add Contac tButton is Clicked ","Add Contac tButton is not Clicked","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Add Contact Button is present ","Add Contact Button is not  present ","FAIL",runManagerInfoObj);
			blnFlag=false;
		}

	}

	catch (Exception e)

	{
		repfn.FnUpdateTestStepResHTML("Verify user is able to click Add Contact Button ","user is not able to click Add Contact Button due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}



public synchronized boolean FN_addPhoneconClick(WebDriver driver, RunManagerInfo runManagerInfoObj){
	try{


		//Entering Phone Number 1
		if(cnf.FnExplicitWait("Xpath", mbo.Addcontact_PhoneNumberIcon,driver)){
			WebElement Addcontact_PhoneNumberIcon=driver.findElement(By.xpath(mbo.Addcontact_PhoneNumberIcon));

			repfn.FnUpdateTestStepResHTML("Verify Add Phone Number Link is present in Contact page ","Add Phone Number Link is present in Contact page","PASS",runManagerInfoObj);
			if(cnf.ElementClick(Addcontact_PhoneNumberIcon,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Add Phone Number Link is Clicked ","Add Phone Number Link is Clicked","PASS",runManagerInfoObj);
				//Entering EmailId
				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
					WebElement Addcontact_PhoneNumber_inputText=driver.findElement(By.xpath(mbo.Addcontact_PhoneNumber_inputText));

					Addcontact_PhoneNumber_inputText.sendKeys("999999"+randomInt,Keys.TAB);
					repfn.FnUpdateTestStepResHTML("Verify Phone Number 1  is Entered ","Phone Number 1 is Entered","PASS",runManagerInfoObj);


					
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Phone Number 1 is Entered ","Phone Number 1 is not  Entered","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Add Phone Number Link is Clicked ","Add Phone Number Link is not Clicked","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Add Phone Number Link is present in Contact page ","Add Phone Number Link is  not present in Contact page","FAIL",runManagerInfoObj);
			blnFlag=false;
		}


		//Entering Phone Number
		for(int i=1;i<5;i++){
			if(cnf.FnExplicitWait("Xpath", mbo.Addcontact_PhoneNumberIcon,driver)){
				WebElement Addcontact_PhoneNumberIcon=driver.findElement(By.xpath(mbo.Addcontact_PhoneNumberIcon));
				int count=i+1;
				Thread.sleep(1000);
				repfn.FnUpdateTestStepResHTML("Verify Add Phone Number Link is present in Contact page ","Add Phone Number Link is present in Contact page","PASS",runManagerInfoObj);
				if(cnf.JSClick(Addcontact_PhoneNumberIcon,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Add Phone Number Link is clicked","Add Phone Number Link is clicked","PASS",runManagerInfoObj);
					if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
						List<WebElement> Addcontact_PhoneNumber_inputText=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
						Addcontact_PhoneNumber_inputText.get(i).sendKeys("999999"+randomInt,Keys.TAB);
						repfn.FnUpdateTestStepResHTML("Verify  Phone Number " +count+ " is Entered ","Phone Number " +count+" is Entered","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Phone Number Input field is displayed","Phone Number Input field is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Add Phone Number Link is clicked","Add Phone Number Link is not clicked","FAIL",runManagerInfoObj);
					blnFlag=false;							
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Add Phone Number Link is displayed","Add Phone Number Link is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
	}

	catch (Exception e)

	{
		repfn.FnUpdateTestStepResHTML("Verify  Add contact Phone Number Icon is clicked or not "," Add contact Phone Number Icon is not clicked due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}



public synchronized boolean FNAddcontact_PhoneNumberVerification(WebDriver driver, RunManagerInfo runManagerInfoObj){
	try{
		if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneTypeVerification,driver))
		{
			List<WebElement> Addcontact_PhoneTypeVerification=driver.findElements(By.xpath(mbo.Addcontact_PhoneTypeVerification));
			repfn.FnUpdateTestStepResHTML("Verify if Phone type is displayed", "Phone type is displayed", "PASS",runManagerInfoObj);
		

			if(Addcontact_PhoneTypeVerification.get(0).getAttribute("textContent").contains("Home")){
				repfn.FnUpdateTestStepResHTML("Verify Newly added PhoneNumber Type is displayed "," Newly addedPhoneNumber Type:"+Addcontact_PhoneTypeVerification.get(0).getText()+" is displayed" ,"PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify  Newly added PhoneNumber Type is displayed ","Newly added PhoneNumber Type:"+Addcontact_PhoneTypeVerification.get(0).getText()+" is  not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify if Phone type is displayed", "Phone type is not displayed", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}

		if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumberVerification,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify if Phone numbers are displayed", "Phone Numbers are displayed", "PASS",runManagerInfoObj);
			List<WebElement>  Addcontact_PhoneNumberVerification=driver.findElements(By.xpath(mbo. Addcontact_PhoneNumberVerification));
			if( Addcontact_PhoneNumberVerification.get(0).getAttribute("innerHTML").contains("999")){


				repfn.FnUpdateTestStepResHTML("Verify Newly added PhoneNumber  is displayed "," Newly added PhoneNumber :"+ Addcontact_PhoneNumberVerification.get(0).getText()+" is displayed" ,"PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify  Newly added PhoneNumber  is displayed "," Newly added PhoneNumber :"+ Addcontact_PhoneNumberVerification.get(0).getText()+" is  not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify if Phone numbers are displayed", "Phone Numbers are not displayed", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}

	}
	catch (Exception e)

	{
		repfn.FnUpdateTestStepResHTML("Verify Phone Number is displayed ","PhoneNumber is not dispalyed due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}

public synchronized boolean FN_SaveButton_Click(WebDriver driver, RunManagerInfo runManagerInfoObj){
	String firstName = "";

	try{

		Thread.sleep(1000);
		
		driver.manage().window().setSize(new Dimension(100, 100));
		driver.manage().window().maximize();

		if(cnf.FnExplicitWait("XPATH", mbo.AddContact_FirstName,driver)){
			WebElement AddContact_FirstName=driver.findElement(By.xpath(mbo.AddContact_FirstName));
			firstName = AddContact_FirstName.getAttribute("value");
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify FirstName is Entered ","FirstName is not  Entered","FAIL",runManagerInfoObj);
			blnFlag=false;
		}

		if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_SaveButton,driver))
		{
			WebElement Savebtn=driver.findElement(By.xpath(mbo.ManageLine_SaveButton));
			repfn.FnUpdateTestStepResHTML("Verify Save button is displayed  ","Save button is displayed ","PASS",runManagerInfoObj);

			Thread.sleep(4000);
			if(cnf.JSClick(Savebtn,driver)){		  	        
				repfn.FnUpdateTestStepResHTML("Verify Save button is Enabled and clicked ","Save button is Enabled and clicked","PASS",runManagerInfoObj);
				Thread.sleep(5000);
				blnFlag=true;

			}else{
				repfn.FnUpdateTestStepResHTML("Verify save button is clicked "," confirm button is not clicked","FAIL",runManagerInfoObj);
				blnFlag=false;
			}


			if(cnf.FnExplicitWait("XPATH", mbo.SaveNotWorkingText,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Save functionality working or not","Save functionality not working","FAIL",runManagerInfoObj);
				blnFlag=false;
				if(cnf.FnExplicitWaitFeedback("XPATH", mbo.Cancel_Button,driver))
				{
					WebElement close=driver.findElement(By.xpath(mbo.Cancel_Button));
					if(cnf.JSClick(close,driver)){
						Thread.sleep(2000);
						WebElement Confrm=driver.findElement(By.xpath(mbo.Confirm_btn));
						System.out.println("click aftr save not working");
						if(cnf.JSClick(Confrm,driver))
						{                                                                                                                                                                                                                              Thread.sleep(2000);
						driver.navigate().refresh();
						Thread.sleep(2000);
						repfn.FnUpdateTestStepResHTML("Verify User is moved back to contacts page","User is moved back to contacts page","PASS",runManagerInfoObj);
						blnFlag=false;
						}
					}
				}
			}else{

				if(cnf.FnExplicitWait("XPATH", mbo.ContactsName,driver)){
					List<WebElement> ContactsName=driver.findElements(By.xpath(mbo.ContactsName));
					for(WebElement contact:ContactsName)
					{
						if(contact.getText().contains(firstName))
						{
							blnFlag=true;
							repfn.FnUpdateTestStepResHTML("Verify if contact added newly is saved "," Newly added contact has been saved: "+firstName, "PASS",runManagerInfoObj);
							if(cnf.JSClick(contact,driver)){
								blnFlag=true;
								repfn.FnUpdateTestStepResHTML("Verify if Newly added contact is clicked","Newly added contact is clicked", "PASS",runManagerInfoObj);
							}
							else{
								blnFlag=false;
								repfn.FnUpdateTestStepResHTML("Verify if Newly added contact is clicked","Newly added contact is not clicked", "FAIL",runManagerInfoObj);
							}
						}
					}
					if(!blnFlag)
					{
						blnFlag=false;
						repfn.FnUpdateTestStepResHTML("Verify if contact added newly is saved "," Newly added contact has not been saved: "+firstName, "FAIL",runManagerInfoObj);
					}
					else{
						blnFlag=true;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Contacts list is displayed","Contacts list is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Save button is Enabled  ","Save button is not Enabled ","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}

	catch (Exception e)
	{
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		repfn.FnUpdateTestStepResHTML("Verify Save button is Enabled and  clicked ","Save button is not Enabled and  not clicked due to some exception ","FAIL",runManagerInfoObj);
		blnFlag=false;

	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}

public synchronized boolean FNContactListVerificationAfterCanceLLing(WebDriver driver, RunManagerInfo runManagerInfoObj){
	try{
		Thread.sleep(5000);
		if(cnf.FnExplicitWait("Xpath", mbo.ContactList,driver)){
			List<WebElement> ContactList=driver.findElements(By.xpath(mbo.ContactList));
			for(WebElement we:ContactList){
				System.out.println(we.getText());
				if(!we.getText().contains(First_name_validation)){
					blnFlag=true;
				}
				else{
					blnFlag=false;
				}
			}
						
			if(blnFlag){
				repfn.FnUpdateTestStepResHTML("Verify Newly added contact is not displayed in Contacts List","Newly added contact is not displayed in Contacts List","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Newly added contact is not displayed in Contacts List","Newly added contact is displayed in Contacts List","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Contact List is displayed","Contact List is not displayed","FAIL",runManagerInfoObj);
			blnFlag=false;
		}		
	}

	catch (Exception e)
	{
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		repfn.FnUpdateTestStepResHTML("Verify Rose Name is not  displayed in the contact List","Rose Name is   displayed in the contact List due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}



public synchronized boolean FNContactListVerificationAfterSaving(WebDriver driver, RunManagerInfo runManagerInfoObj){
	try{
		if(cnf.FnExplicitWait("Xpath", mbo.ContactList,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Contact List is displayed","Contact List is displayed","PASS",runManagerInfoObj);
			List<WebElement> ContactList=driver.findElements(By.xpath(mbo.ContactList));
			System.out.println(ContactList.size());
			if(ContactList.size()>0){
				repfn.FnUpdateTestStepResHTML("Verify Contact List have contacts","Contact List have contacts","PASS",runManagerInfoObj);
				for(int i=0;i<ContactList.size();i++)
				{
					System.out.println(ContactList.get(i).getText());
					if(ContactList.get(i).getText().contains(Random_int_validation))
					{
						cnf.JSClick(ContactList.get(i),driver);
						Thread.sleep(4000);
						blnFlag=true;
						break;
					}
				}
				
				if(blnFlag)
				{
					repfn.FnUpdateTestStepResHTML("Verify Contact added is displayed in the contact List: "+Random_int_validation,"Contact added is displayed in the contact List as :"+Random_int_validation,"PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify added name displayed in the contact List: "+Random_int_validation,"Added name is not displayed in the contact List","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

			}else{
				repfn.FnUpdateTestStepResHTML("Verify Contact List have contacts","Contact List does not have contacts","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Contact List is displayed","Contact List is not displayed","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}

	catch (Exception e)

	{
		repfn.FnUpdateTestStepResHTML("Verify addded contact name is displayed  in the contact List","Added Contact name is  not displayed  in the contact List due to some exception","PASS",runManagerInfoObj);
		blnFlag=true;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}



public synchronized boolean FN_addInvaLidEmailErrorMessageCheck(WebDriver driver, RunManagerInfo runManagerInfoObj){
	try{

		if(cnf.FnExplicitWait("XPATH", mbo.addEmail,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Add Email Link is displayed ","Add Email Link is displayed","PASS",runManagerInfoObj);
			WebElement Addcontact_EmailIcon=driver.findElement(By.xpath(mbo.addEmail));
			//	cnf.ScrollToView(Addcontact_EmailIcon);
			if(cnf.JSClick(Addcontact_EmailIcon,driver)){
				repfn.FnUpdateTestStepResHTML("Verify First Add Email Link is Clicked ","First Add Email Link is Clicked","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify First Add Email Link is Clicked ","First Add Email Link is  not Clicked","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Add Email Link is displayed ","Add Email Link is not displayed","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		
		Thread.sleep(3000);
		if(cnf.FnExplicitWait("XPATH", mbo.addEmail,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Add Email Link is displayed ","Add Email Link is displayed","PASS",runManagerInfoObj);
			WebElement Addcontact_Email=driver.findElement(By.xpath(mbo.addEmail));

			//cnf.ScrollToView(Addcontact_Email);
			if(cnf.JSClick(Addcontact_Email,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Second Add Email Link is Clicked ","Second Add Email Link is Clicked","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Second Add Email Link is Clicked ","Second Add Email Link is  not Clicked","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Add Email Link is displayed ","Add Email Link is not displayed","FAIL",runManagerInfoObj);
			blnFlag=false;
		}


		if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
			List<WebElement> Addcontact_EmailInputText=driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));	
			for(int j=0;j<Addcontact_EmailInputText.size();j++){
				Addcontact_EmailInputText.get(j).sendKeys("Saranyasaranyasaranyasaranyasaranya"+randomInt+"gmail.com");
				repfn.FnUpdateTestStepResHTML(" Enter an invalid email without @ symbol and with more than 66 characters ","Email id "+(j+1)+"is entered :"+"Saranyasaranyasaranyasaranyasaranyasaranyasaranyasaranya"+randomInt+"gmail.com","PASS",runManagerInfoObj);
				blnFlag=true;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Invalid Email id is Entered ","Invalid Email id is not Entered","FAIL",runManagerInfoObj);
			blnFlag=false;
		}


		//Capturing Error Message
		if(cnf.FnExplicitWait("Xpath", mbo.emailAddressHeading,driver)){
			WebElement emailAddressHeading=driver.findElement(By.xpath(mbo.emailAddressHeading));
			cnf.JSClick(emailAddressHeading,driver);
			if(cnf.FnExplicitWait("Xpath", mbo.AddContact_EmailErrorMsg,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Invalid Error Message is Displayed ","Invalid Error Message is Displayed","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Invalid Error Message is Displayed ","Invalid Error Message is not Displayed","FAIL",runManagerInfoObj);
				blnFlag=false;

			}
		}
		else{
			blnFlag=false;
			repfn.FnUpdateTestStepResHTML("Verify email adress heading displayed or not ","Email adress heading is not Displayed","FAIL",runManagerInfoObj);
		}

		Thread.sleep(5000);
	}


	catch (Exception e)

	{
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		repfn.FnUpdateTestStepResHTML("Verify Invalid Error Message is Displayed for invalid email ","Invalid Error Message is not Displayed for invalid email due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}

public synchronized boolean FNAddcontact_EmailVerification(WebDriver driver, RunManagerInfo runManagerInfoObj){
	try{
		if(cnf.FnExplicitWait("Xpath", mbo.EmailVerification,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Email id Field is present or not","Email id Field is present","PASS",runManagerInfoObj);

			List<WebElement> EmailVerification=driver.findElements(By.xpath(mbo.EmailVerification));
			Thread.sleep(1000);
			if(EmailVerification.size()>0){
				repfn.FnUpdateTestStepResHTML("Verify Email id Field has any email field","Email id Field has email field","PASS",runManagerInfoObj);
				if(EmailVerification.get(0).getText().contains("Infosys") ||EmailVerification.get(1).getText().contains("Saranya")){
					repfn.FnUpdateTestStepResHTML("Verify Contact List has both Email id 1 and Email id 2","Contact List has Email id 1: "+EmailVerification.get(0).getText()+"and Email id 2: "+EmailVerification.get(1).getText(),"PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Contact List has Email id","Contact List does not have  Mail id"+EmailVerification.get(0).getText(),"FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}else{
				repfn.FnUpdateTestStepResHTML("Verify Email id Field has any email field","Email id Field does not have a single email field","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}else{
			repfn.FnUpdateTestStepResHTML("Verify Email id Field is present or not","Email id Field is not present","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}
	catch (Exception e)

	{
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		repfn.FnUpdateTestStepResHTML("Verify Contact List has  Infosys Mail id","Contact List   does not have Infosys  Mail id due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}


public synchronized boolean FNAddcontact_DeleteContact(WebDriver driver, RunManagerInfo runManagerInfoObj){
	try{
		Thread.sleep(1000);
		if(cnf.FnExplicitWait("Xpath", mbo.UserDetail_EditBtn,driver)){
			WebElement UserDetail_EditBtn=driver.findElement(By.xpath(mbo.UserDetail_EditBtn));
			repfn.FnUpdateTestStepResHTML("Verify Edit button is displayed ","Edit button is displayed ","PASS",runManagerInfoObj);
			if(cnf.JSClick(UserDetail_EditBtn,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Edit button is clicked ","Edit button is  clicked ","PASS",runManagerInfoObj);
				blnFlag=true;
				Thread.sleep(3000);

				if(	cnf.FnExplicitWait("Xpath", mbo.DeleteContact,driver)){
					WebElement DeleteContact=driver.findElement(By.xpath(mbo.DeleteContact));
					repfn.FnUpdateTestStepResHTML("Verify Delete Contact button is displayed ","Delete Contact button is displayed ","PASS",runManagerInfoObj);
					//cnf.ScrollToView(DeleteContact);

					if(cnf.JSClick(DeleteContact,driver)){
						Thread.sleep(5000);
						blnFlag=app.FN_CancelConfirmPopup(driver,runManagerInfoObj);
						if(blnFlag){
							Thread.sleep(4000);
							repfn.FnUpdateTestStepResHTML("Verify Delete Contact button is clicked ","Delete Contact button is clicked ","PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Delete Contact button is clicked ","Delete Contact button is not clicked ","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Delete Contact button is  clicked ","Delete Contact button is not  clicked ","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}else{
					repfn.FnUpdateTestStepResHTML("Verify Delete Contact button is displayed ","Delete Contact button is not displayed  ","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}else{
				repfn.FnUpdateTestStepResHTML("Verify Edit button is clicked ","Edit button is not clicked ","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}else{
			repfn.FnUpdateTestStepResHTML("Verify Edit button is displayed ","Edit button is not displayed ","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}
	catch (Exception e)

	{
		repfn.FnUpdateTestStepResHTML("Verify Delete Contact button is clicked ","Delete Contact button is not clicked due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}


public synchronized boolean FNEnteringData_FN_LN_ForCancel(WebDriver driver, RunManagerInfo runManagerInfoObj){
	try{


		//Entering FirstName
		if(cnf.FnExplicitWait("XPATH", mbo.AddContact_FirstName,driver)){
			WebElement AddContact_FirstName=driver.findElement(By.xpath(mbo.AddContact_FirstName));
			int Random=randomInt;
			AddContact_FirstName.sendKeys("Rose"+Random);
			First_name_validation="Rose"+Random;
			repfn.FnUpdateTestStepResHTML("Verify First Name  is Entered ","First Name is Entered as :"+First_name_validation,"PASS",runManagerInfoObj);
			blnFlag=true;

		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify First Name is Entered ","First Name is not  Entered :"+First_name_validation,"FAIL",runManagerInfoObj);
			blnFlag=false;
		}


		//Entering LastName
		if(cnf.FnExplicitWait("XPATH", mbo.AddContact_LastName,driver)){
			WebElement AddContact_LastName=driver.findElement(By.xpath(mbo.AddContact_LastName));

			AddContact_LastName.sendKeys("Mary");
			repfn.FnUpdateTestStepResHTML("Verify Last Name is Entered ","Last Name is Entered","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Last Name is Entered ","Last Name is not  Entered","FAIL",runManagerInfoObj);
			blnFlag=false;
		}

		//Entering Title
		if(cnf.FnExplicitWait("XPATH", mbo.AddContact_Title,driver)){
			WebElement AddContact_Title=driver.findElement(By.xpath(mbo.AddContact_Title));

			AddContact_Title.sendKeys("SampleText");
			repfn.FnUpdateTestStepResHTML("Verify Title is Entered ","Title is Entered","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Title is Entered ","Title is not  Entered","FAIL",runManagerInfoObj);
			blnFlag=false;
		}

		//Entering companyName
		if(cnf.FnExplicitWait("XPATH", mbo.AddContact_Company,driver)){
			WebElement AddContact_Company=driver.findElement(By.xpath(mbo.AddContact_Company));

			AddContact_Company.sendKeys("Infosys");
			repfn.FnUpdateTestStepResHTML("Verify CompanyName is Entered ","CompanyName is Entered","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify CompanyName is Entered ","CompanyName is not  Entered","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}

	catch (Exception e)

	{
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		repfn.FnUpdateTestStepResHTML("Verify User is able to enter FirstName,LastName,Companyname and Title  ","User is  not able to enter FirstName,LastName,Companyname and Title due to some exception ","FAIL",runManagerInfoObj);
		blnFlag=false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}

public synchronized boolean FN_RemovePhoneNoClick_Add_Save(WebDriver driver, RunManagerInfo runManagerInfoObj){
	
	int listSize = 0;
	String phoneType = "";
	String fullName = "";

	try{
		
		if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
			List<WebElement> Addcontact_PhoneNumber_inputText=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
			listSize = Addcontact_PhoneNumber_inputText.size();
		}
		
		if(listSize > 0){
			
			WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
			String newNameFirst = FirstName.getAttribute("value");
			WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
			String lastNameFirst = lastName.getAttribute("value");
			
			Thread.sleep(3000);
			if(cnf.FnExplicitWait("XPATH", mbo.EditModeUserPhoneTypeInput,driver)){
				List<WebElement> EditModeUserPhoneType=driver.findElements(By.xpath(mbo.EditModeUserPhoneTypeInput));
				phoneType = EditModeUserPhoneType.get(0).getAttribute("textContent");
			}
			
			System.out.println("phone type: "+phoneType);
			
			if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_RemovePhoneNumber,driver)){
				List<WebElement> Addcontact_RemovePhoneNumber=driver.findElements(By.xpath(mbo.Addcontact_RemovePhoneNumber));
				repfn.FnUpdateTestStepResHTML("Verify Remove Phone Number icon is present","Remove Phone Number icon is present","PASS",runManagerInfoObj);
				if(cnf.JSClick(Addcontact_RemovePhoneNumber.get(0),driver)){
					repfn.FnUpdateTestStepResHTML("Verify Remove Phone Number icon is clicked","Remove Phone Number icon is clicked","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Remove Phone Number icon is clicked","Remove Phone Number icon is not clicked","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Remove Phone Number icon is present","Remove Phone Number icon is not present","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
			
			fullName = newNameFirst+" "+lastNameFirst;
			driver.manage().window().setSize(new Dimension(100, 100));
			driver.manage().window().maximize();
			 
			Thread.sleep(2000);
			
			boolean blnFlag1 = app.FN_SaveButtonClick(driver,runManagerInfoObj);
			
			if(blnFlag1==true)
			{
				if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
					WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
					cnf.ScrollToView(Search_Field,driver);
					Search_Field.clear();
					Search_Field.sendKeys(fullName);
					repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
					Thread.sleep(2000);

					List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
					if(Contacts_Arrow.get(0).isDisplayed()){
						repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
						if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
							repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
								repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

								Thread.sleep(2000);

								if(cnf.FnExplicitWait("XPATH", mbo.UserContactPhoneTypeDisplay,driver)){
									repfn.FnUpdateTestStepResHTML("Verify Phone Number list is displayed ","Phone Number list is displayed " ,"PASS",runManagerInfoObj);
									List<WebElement>  UserContactPhoneTypeDisplay=driver.findElements(By.xpath(mbo. UserContactPhoneTypeDisplay));
									for(int i=0;i<UserContactPhoneTypeDisplay.size();i++){
										if(UserContactPhoneTypeDisplay.get(i).getText().contains(phoneType)){											
											blnFlag=false;
										}
										else{
											blnFlag=true;
										}
									}
									if(blnFlag){
										repfn.FnUpdateTestStepResHTML("Verify if Phone Number is removed","Phone Number is removed" ,"PASS",runManagerInfoObj);
										blnFlag=true;
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify if Phone Number is removed ","Phone Number is not removed" ,"FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Phone Number list is displayed ","Phone Number list is not displayed. No number is added ","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ","Search field is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if the user is able to save the changes in Edit Contact form. ", "User is not able to save the changes in Edit Contact form","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}			
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Phone Number is displayed", "Phone Number is not displayed","FAIL",runManagerInfoObj);
			blnFlag	= false;
		}

	}

	catch (Exception e)
	{
		repfn.FnUpdateTestStepResHTML("Verify Phone number is removed","Phone number is not removed due to some exception ","FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}


	
public synchronized boolean FNVerifyFNLNTitleCompany(WebDriver driver, RunManagerInfo runManagerInfoObj){
	try{


		//Entering FirstName
		if(cnf.FnExplicitWait("XPATH", mbo.AddContact_FirstName,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify FirstName field is present ","FirstName field is present","PASS",runManagerInfoObj);
			blnFlag=true;

		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify FirstName field is present ","FirstName is not  present","FAIL",runManagerInfoObj);
			blnFlag=false;
		}


		//Entering LastName
		if(cnf.FnExplicitWait("XPATH", mbo.AddContact_LastName,driver)){					
			repfn.FnUpdateTestStepResHTML("Verify LastName field is present ","LastName field is present","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify LastName field is present ","LastName is not  present","FAIL",runManagerInfoObj);
			blnFlag=false;
		}

		//Entering Title
		if(cnf.FnExplicitWait("XPATH", mbo.AddContact_Title,driver)){				
			repfn.FnUpdateTestStepResHTML("Verify Title field is present ","Title is present","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Title field is present ","Title is not  present","FAIL",runManagerInfoObj);
			blnFlag=false;
		}

		//Entering companyName
		if(cnf.FnExplicitWait("XPATH", mbo.AddContact_Company,driver)){					
			repfn.FnUpdateTestStepResHTML("Verify CompanyName field is present ","CompanyName is present","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify CompanyName is present ","CompanyName is not  present","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}

	catch (Exception e)

	{
		repfn.FnUpdateTestStepResHTML("Verify if Personal Details fields are present","Personal Details fields are not present due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}

public synchronized boolean FN_addFurtherDetails(WebDriver driver, RunManagerInfo runManagerInfoObj){
	try{


		//Add Phone Number//
		if(cnf.FnExplicitWait("Xpath", mbo.Addcontact_PhoneNumberIcon,driver))
		{					
			repfn.FnUpdateTestStepResHTML("Verify if Option to Add Phone Number is present","Option to Add Phone Number is present","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify if Option to Add Phone Number is present","Option to Add Phone Number is not present","FAIL",runManagerInfoObj);
			blnFlag=false;	
		}

		//AddEmail//
		
		if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailIcon,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify if Option to Add Email is present","Option to Add Email is present","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify if Option to Add Email is present","Option to Add Email is not present","FAIL",runManagerInfoObj);
			blnFlag=false;
			
		}
		
		//AddAddress//
		
		if(cnf.FnExplicitWait("XPATH", mbo.AddContact_AddressIcon,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify if Option to Add Address is present","Option to Add Address is present","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify if Option to Add Address is present","Option to Add Address is not present","FAIL",runManagerInfoObj);
			blnFlag=false;	
		}
		//Cancel Button//
		
		if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_CancelBtn,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify if Cancel button is present", "Cancel button is present", "PASS",runManagerInfoObj);
			blnFlag=true;
		
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify if Cancel button is present", "Cancel button is not present", "FAIL",runManagerInfoObj);
			blnFlag=false;	
		}
		//Save button//
		
		if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_SaveButton,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify if Save button is present", "Save button is present", "PASS",runManagerInfoObj);
			blnFlag=true;				
		}
		else
		{
			repfn.FnUpdateTestStepResHTML("Verify if Save button is present", "Save button is not present", "FAIL",runManagerInfoObj);
			blnFlag=false;	
		
		}

	}


	catch (Exception e)

	{
		repfn.FnUpdateTestStepResHTML("Verify if option to add further details is present","Option to add further details is not present due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean FN_AddContact_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj){
	try{

		driver.manage().window().setSize(new Dimension(100, 100));
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_CancelBtn,driver)){
			repfn.FnUpdateTestStepResHTML("Verify if the Cancel button is displayed in the Contact details window ","Cancel button is displayed","PASS",runManagerInfoObj);
			WebElement Cancelbtn=driver.findElement(By.xpath(mbo.ManageLine_CancelBtn));

			if(cnf.JSClick(Cancelbtn,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Cancel button is clicked ","Cancel button is clicked","PASS",runManagerInfoObj);
				blnFlag=true;
			}else{
				repfn.FnUpdateTestStepResHTML("Verify Cancel button is clicked ","Cancel button is not clicked","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Cancel button is present ","Cancel button is not present","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}

	catch (Exception e)

	{
		repfn.FnUpdateTestStepResHTML("Verify Cancel button is clicked ","Cancel button is not clicked due to some exception","FAIL",runManagerInfoObj);
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		blnFlag=false;

	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}



//saranya[9/28/2015]


public synchronized boolean FNAddcontact_AddressVerification(WebDriver driver, RunManagerInfo runManagerInfoObj){
	try{
		cnf.FnExplicitWait("Xpath", mbo.AddressVerification,driver);	
		WebElement AddressVerification=driver.findElement(By.xpath(mbo.AddressVerification));
		Thread.sleep(1000);
		System.out.println(AddressVerification.getText());


		if(AddressVerification.getText().contains("TAMILNADU")){
			repfn.FnUpdateTestStepResHTML("Verify Contact List has Newly Added Address","Contact List   Has  Newly Added Address and it is displayed as:"+AddressVerification.getText(),"PASS",runManagerInfoObj);
			blnFlag=true;



		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Contact List has   Newly Added Address","Contact List   does not have  Newly Added Address"+AddressVerification.getText(),"FAIL",runManagerInfoObj);
			blnFlag=false;
		}

	}
	catch (Exception e)

	{
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		repfn.FnUpdateTestStepResHTML("Verify Contact List has   Newly Added Address","Contact List   does not have  Newly Added Address due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}


public synchronized boolean FN_editbuttonclick(WebDriver driver, RunManagerInfo runManagerInfoObj){
	try{
		if(cnf.FnExplicitWait("Xpath", mbo.UserDetail_EditBtn,driver)){
		WebElement UserDetail_EditBtn=driver.findElement(By.xpath(mbo.UserDetail_EditBtn));
		
			
			if(cnf.JSClick(UserDetail_EditBtn,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Edit button is displayed and clicked ","Edit button is displayed and clicked ","PASS",runManagerInfoObj);
			Thread.sleep(2000);
			blnFlag=true;
			}else{
				repfn.FnUpdateTestStepResHTML("Verify Edit button is clicked ","Edit button is not clicked ","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Edit button is displayed ","Edit button is not displayed ","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}
	catch (Exception e)

	{
		repfn.FnUpdateTestStepResHTML("Verify Edit button is displayed and clicked ","Edit button is not displayed and clicked due to some exception ","FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}


public synchronized boolean FN_addInvaLidPhoneNoErrorMessageCheck(WebDriver driver, RunManagerInfo runManagerInfoObj){
	try{


		//Entering  Invalid EmailId 
		if(cnf.FnExplicitWait("Xpath", mbo.Addcontact_PhoneNumberIcon,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Addcontact_PhoneNumberIconis present in home Page ","Addcontact_PhoneNumberIcon is present in home Page","PASS",runManagerInfoObj);
			WebElement Addcontact_PhoneNumberIcon=driver.findElement(By.xpath(mbo.Addcontact_PhoneNumberIcon));

			if(cnf.ElementClick(Addcontact_PhoneNumberIcon,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Addcontact_PhoneNumberIcon is Clicked ","Addcontact_PhoneNumberIcon is Clicked","PASS",runManagerInfoObj);
				//Entering EmailId				
				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
					WebElement Addcontact_PhoneNumber_inputText=driver.findElement(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
					Addcontact_PhoneNumber_inputText.sendKeys("888884444488888444448888844444888",Keys.TAB);
					repfn.FnUpdateTestStepResHTML("Verify  more than 32 numbers is entered in the phone number field’ "," More than 32 numbers is entered in the phone number field","PASS",runManagerInfoObj);
					if(cnf.FnExplicitWait("Xpath", mbo.Addcontact_InvalidPhoneErrorMsg,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Invalid Error Message is Displayed  for Invalid Phone Number","Invalid Error Message is Displayed for Invalid Phone Number","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Invalid Error Message is Displayed for Invalid Phone Number ","Invalid Error Message is not Displayed for Invalid Phone Number","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify  more than 32 numbers is entered in the phone number field "," more than 32 numbers is entered in the phone number field","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Addcontact_PhoneNumberIcon is Clicked ","Addcontact_PhoneNumberIcon is not Clicked","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Addcontact_PhoneNumberIcon is present in home Page ","Addcontact_PhoneNumberIcon is not  present in home Page","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}

	catch (Exception e)

	{
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
		repfn.FnUpdateTestStepResHTML("Verify Invalid Error Message is Displayed for invalid email ","Invalid Error Message is not Displayed  for invalid email due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}



public synchronized boolean FN_addInvalid_PhoneNumberErrorMessageCheck(WebDriver driver, RunManagerInfo runManagerInfoObj){
	 try{


		 //Entering  Invalid EmailId 
		 if(cnf.FnExplicitWait("Xpath", mbo.Addcontact_PhoneNumberIcon,driver)){
			 WebElement Addcontact_PhoneNumberIcon=driver.findElement(By.xpath(mbo.Addcontact_PhoneNumberIcon));

			 repfn.FnUpdateTestStepResHTML("Verify Addcontact_PhoneNumber Icon is present in home Page ","Addcontact_PhoneNumber Icon is present in home Page","PASS",runManagerInfoObj);
			 if(cnf.ElementClick(Addcontact_PhoneNumberIcon,driver)){
				 repfn.FnUpdateTestStepResHTML("Verify Addcontact_PhoneNumber Icon is Clicked ","Addcontact_PhoneNumberIcon is Clicked","PASS",runManagerInfoObj);
				 //Entering EmailId
				
				 if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
					 WebElement Addcontact_PhoneNumber_inputText=driver.findElement(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
					 Addcontact_PhoneNumber_inputText.clear();
					 Addcontact_PhoneNumber_inputText.sendKeys("abcababababababa",Keys.TAB);
					 repfn.FnUpdateTestStepResHTML("Verify  alphabets is entered  in the phone number field "," Alphabets is entered  in the phone number field","PASS",runManagerInfoObj);
					 if(cnf.FnExplicitWait("Xpath", mbo.Addcontact_InvalidPhoneErrorMsg,driver)){
						 repfn.FnUpdateTestStepResHTML("Verify Invalid Error Message is Displayed  for Invalid Phone Number","Invalid Error Message is Displayed for Invalid Phone Number","PASS",runManagerInfoObj);
						 blnFlag=true;
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify Invalid Error Message is Displayed for Invalid Phone Number ","Invalid Error Message is not Displayed for Invalid Phone Number","FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify  alphabets is entered  in the phone number field "," Alphabets is entered  in the phone number field","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify Addcontact_PhoneNumberIcon is Clicked ","Addcontact_PhoneNumberIcon is not Clicked","FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }
		 else{
			 repfn.FnUpdateTestStepResHTML("Verify Addcontact_PhoneNumber Icon is present in home Page ","Addcontact_PhoneNumber Icon is not  present in home Page","FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }



	 }


	 catch (Exception e)

	 {
		 System.err.println("Message : "+e.getMessage());
		 System.err.println("Cause : "+e.getCause());
		 repfn.FnUpdateTestStepResHTML("Verify Invalid Error Message is Displayed for invalid email ","Invalid Error Message is not Displayed  for invalid email due to some exception","FAIL",runManagerInfoObj);
		 blnFlag=false;
	 }
	 m1.put("STEPSTATUS", blnFlag);
	 return blnFlag;
}
public synchronized boolean FN_Edit_InvaLidPhoneNoErrorMessageCheck(WebDriver driver, RunManagerInfo runManagerInfoObj){
	
	int listSize = 0;
	String invalidPhoneNumberOne = "abcdefg";
	String invalidPhoneNumberTwo = "Saranya@@@(234%#@";
	String invalidPhoneNumberThree = "1234567890123456789012345678901234567890";
	
	try{
		
		if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
			List<WebElement> Addcontact_PhoneNumber_inputText=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
			listSize = Addcontact_PhoneNumber_inputText.size();
		}
		
		if(listSize > 0){
			
			if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
				List<WebElement> Addcontact_PhoneNumber_List=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
				Addcontact_PhoneNumber_List.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),invalidPhoneNumberOne,Keys.TAB);
				repfn.FnUpdateTestStepResHTML("Verify Invalid Phone Number is Entered ","Invalid Phone Number is Entered: "+invalidPhoneNumberOne,"PASS",runManagerInfoObj);
				
				if(cnf.FnExplicitWait("Xpath", mbo.Addcontact_InvalidPhoneErrorMsg,driver)){
				    WebElement Addcontact_InvalidPhoneErrorMsg=driver.findElement(By.xpath(mbo.Addcontact_InvalidPhoneErrorMsg));
					repfn.FnUpdateTestStepResHTML("Verify Invalid Error Message is Displayed ","Invalid Error Message is Displayed: "+Addcontact_InvalidPhoneErrorMsg.getText(),"PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Invalid Error Message is Displayed ","Invalid Error Message is not Displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Invalid Phone Number is Entered ","Invalid Phone Number is not Entered","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
			
			if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
				List<WebElement> Addcontact_PhoneNumber_List=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
				Addcontact_PhoneNumber_List.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),invalidPhoneNumberTwo,Keys.TAB);
				repfn.FnUpdateTestStepResHTML("Verify Invalid Phone Number is Entered ","Invalid Phone Number is Entered: "+invalidPhoneNumberTwo,"PASS",runManagerInfoObj);
				
				if(cnf.FnExplicitWait("Xpath", mbo.Addcontact_InvalidPhoneErrorMsg,driver)){
				    WebElement Addcontact_InvalidPhoneErrorMsg=driver.findElement(By.xpath(mbo.Addcontact_InvalidPhoneErrorMsg));
					repfn.FnUpdateTestStepResHTML("Verify Invalid Error Message is Displayed ","Invalid Error Message is Displayed: "+Addcontact_InvalidPhoneErrorMsg.getText(),"PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Invalid Error Message is Displayed ","Invalid Error Message is not Displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Invalid Phone Number is Entered ","Invalid Phone Number is not Entered","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
			
			if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
				List<WebElement> Addcontact_PhoneNumber_List=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
				Addcontact_PhoneNumber_List.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),invalidPhoneNumberThree,Keys.TAB);
				repfn.FnUpdateTestStepResHTML("Verify Invalid Phone Number is Entered ","Invalid Phone Number is Entered: "+invalidPhoneNumberThree,"PASS",runManagerInfoObj);
				
				if(cnf.FnExplicitWait("Xpath", mbo.Addcontact_InvalidPhoneErrorMsg,driver)){
				    WebElement Addcontact_InvalidPhoneErrorMsg=driver.findElement(By.xpath(mbo.Addcontact_InvalidPhoneErrorMsg));
					repfn.FnUpdateTestStepResHTML("Verify Invalid Error Message is Displayed ","Invalid Error Message is Displayed: "+Addcontact_InvalidPhoneErrorMsg.getText(),"PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Invalid Error Message is Displayed ","Invalid Error Message is not Displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Invalid Phone Number is Entered ","Invalid Phone Number is not Entered","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
			
			boolean blnFlag3=FnCancelAndGoBack(driver,runManagerInfoObj);
		
			if(blnFlag3){
				repfn.FnUpdateTestStepResHTML("Verify User is navigated back to Contacts page","User is navigated back to Contacts page","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify User is navigated back to Contacts page","User is not navigated back to Contacts page","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else if(listSize == 0){
			repfn.FnUpdateTestStepResHTML("Verify Phone Number is displayed ", "Phone Number is not displayed. No Phone Number is added.","PASS",runManagerInfoObj);
			int listSize_A = 0;
			boolean blnFlag1=FnAddNewNumber_Save(driver,runManagerInfoObj);			
			boolean blnFlag2=FnOpenEditUserPage(driver,runManagerInfoObj);

			if(blnFlag1 && blnFlag2){
				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
					List<WebElement> Addcontact_PhoneNumber_inputText=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
					listSize_A = Addcontact_PhoneNumber_inputText.size();
				}
				
				if(listSize_A > 0){
					if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
						List<WebElement> Addcontact_PhoneNumber_List=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
						Addcontact_PhoneNumber_List.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),invalidPhoneNumberOne,Keys.TAB);
						repfn.FnUpdateTestStepResHTML("Verify Invalid Phone Number is Entered ","Invalid Phone Number is Entered: "+invalidPhoneNumberOne,"PASS",runManagerInfoObj);
						
						if(cnf.FnExplicitWait("Xpath", mbo.Addcontact_InvalidPhoneErrorMsg,driver)){
						    WebElement Addcontact_InvalidPhoneErrorMsg=driver.findElement(By.xpath(mbo.Addcontact_InvalidPhoneErrorMsg));
							repfn.FnUpdateTestStepResHTML("Verify Invalid Error Message is Displayed ","Invalid Error Message is Displayed: "+Addcontact_InvalidPhoneErrorMsg.getText(),"PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Invalid Error Message is Displayed ","Invalid Error Message is not Displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Invalid Phone Number is Entered ","Invalid Phone Number is not Entered","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
						List<WebElement> Addcontact_PhoneNumber_List=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
						Addcontact_PhoneNumber_List.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),invalidPhoneNumberTwo,Keys.TAB);
						repfn.FnUpdateTestStepResHTML("Verify Invalid Phone Number is Entered ","Invalid Phone Number is Entered: "+invalidPhoneNumberTwo,"PASS",runManagerInfoObj);
						
						if(cnf.FnExplicitWait("Xpath", mbo.Addcontact_InvalidPhoneErrorMsg,driver)){
						    WebElement Addcontact_InvalidPhoneErrorMsg=driver.findElement(By.xpath(mbo.Addcontact_InvalidPhoneErrorMsg));
							repfn.FnUpdateTestStepResHTML("Verify Invalid Error Message is Displayed ","Invalid Error Message is Displayed: "+Addcontact_InvalidPhoneErrorMsg.getText(),"PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Invalid Error Message is Displayed ","Invalid Error Message is not Displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Invalid Phone Number is Entered ","Invalid Phone Number is not Entered","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
						List<WebElement> Addcontact_PhoneNumber_List=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
						Addcontact_PhoneNumber_List.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),invalidPhoneNumberThree,Keys.TAB);
						repfn.FnUpdateTestStepResHTML("Verify Invalid Phone Number is Entered ","Invalid Phone Number is Entered: "+invalidPhoneNumberThree,"PASS",runManagerInfoObj);
						
						if(cnf.FnExplicitWait("Xpath", mbo.Addcontact_InvalidPhoneErrorMsg,driver)){
						    WebElement Addcontact_InvalidPhoneErrorMsg=driver.findElement(By.xpath(mbo.Addcontact_InvalidPhoneErrorMsg));
							repfn.FnUpdateTestStepResHTML("Verify Invalid Error Message is Displayed ","Invalid Error Message is Displayed: "+Addcontact_InvalidPhoneErrorMsg.getText(),"PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Invalid Error Message is Displayed ","Invalid Error Message is not Displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Invalid Phone Number is Entered ","Invalid Phone Number is not Entered","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					boolean blnFlag4=FnCancelAndGoBack(driver,runManagerInfoObj);
											
					if(blnFlag4){
						repfn.FnUpdateTestStepResHTML("Verify User is navigated back to Contacts page","User is navigated back to Contacts page","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify User is navigated back to Contacts page","User is not navigated back to Contacts page","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Phone Number is displayed ", "Phone Number is not displayed","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Phone Number is displayed ", "Phone Number is not displayed","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
		}
		
	}

	catch (Exception e)

	{
		repfn.FnUpdateTestStepResHTML("Verify Invalid Phone Number is Entered ","Invalid Phone Number is not  Entered due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}



public synchronized boolean FNEditcontact_PhoneNumberVerification(WebDriver driver, RunManagerInfo runManagerInfoObj){
	try{
		cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneTypeVerification,driver);
		List<WebElement> Addcontact_PhoneTypeVerification=driver.findElements(By.xpath(mbo.Addcontact_PhoneTypeVerification));


		if(Addcontact_PhoneTypeVerification.get(0).getAttribute("textContent").contains("Home")){


			repfn.FnUpdateTestStepResHTML("Verify PhoneNumber Type is displayed ","PhoneNumber Type:"+Addcontact_PhoneTypeVerification.get(0).getText()+" is displayed" ,"PASS",runManagerInfoObj);

			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify PhoneNumber Type is displayed ","PhoneNumber Type:"+Addcontact_PhoneTypeVerification.get(0).getText()+" is  not displayed","FAIL",runManagerInfoObj);
			blnFlag=false;
		}


		List<WebElement>  Addcontact_PhoneNumberVerification=driver.findElements(By.xpath(mbo. Addcontact_PhoneNumberVerification));
		if( Addcontact_PhoneNumberVerification.get(0).getAttribute("innerHTML").contains("888")){


			repfn.FnUpdateTestStepResHTML("Verify PhoneNumber  is displayed ","PhoneNumber :"+ Addcontact_PhoneNumberVerification.get(0).getText()+" is displayed" ,"PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify PhoneNumber  is displayed ","PhoneNumber :"+ Addcontact_PhoneNumberVerification.get(0).getText()+" is  not displayed","FAIL",runManagerInfoObj);
			blnFlag=false;
		}

	}
	catch (Exception e)

	{
		repfn.FnUpdateTestStepResHTML("Verify Phone Number is displayed ","PhoneNumber : is  not displayed","FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}




public  boolean FNContactList_EditModeVerification(WebDriver driver, RunManagerInfo runManagerInfoObj){
	try{


		List<WebElement> Contact_arrowList=driver.findElements(By.xpath(mbo.Contact_arrowList));
		if(Contact_arrowList.get(0).isDisplayed()){
			//Contact_arrowList.get(0).click();
			cnf.JSClick(Contact_arrowList.get(0),driver);
			repfn.FnUpdateTestStepResHTML("Verify Arrow_DetailLink is displayed and Clicked ","Arrow_DetailLink is displayed and Clicked ","PASS",runManagerInfoObj);
			// WebElement UserDetailpopup=driver.findElement(By.xpath(mbo.UserDetailpopup));
			if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
				repfn.FnUpdateTestStepResHTML("Verify ManageDetailpopup is displayed "," ManageDetailpopup is displayed","PASS",runManagerInfoObj);

				WebElement ManageLine_Editbutton=driver.findElement(By.xpath(mbo.ManageLine_Editbutton));
				if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_Editbutton,driver)){
					cnf.ElementClick(ManageLine_Editbutton,driver); 
					cnf.FnExplicitWait("XPATH", mbo.ManageLine_SaveButton,driver);
					WebElement ManageLine_SaveButton=driver.findElement(By.xpath(mbo.ManageLine_SaveButton));
					if(!ManageLine_SaveButton.isEnabled()){

						repfn.FnUpdateTestStepResHTML("Verify  Intially Save button is not enabled in Edit Mode","Intially Save button is not enabled in Edit Mode","PASS",runManagerInfoObj);

						WebElement Cancelbtn=driver.findElement(By.xpath(mbo.ManageLine_CancelBtn));
						if(cnf.FnExplicitWait("XPATH", mbo.ManageLine_CancelBtn,driver)){
							cnf.ElementClick(Cancelbtn,driver); 
							repfn.FnUpdateTestStepResHTML("Verify Cancel button is clicked ","Cancel button is clicked","PASS",runManagerInfoObj);

							WebElement Backbtn=driver.findElement(By.xpath(mbo.UserDetail_Backbtn));
							if(cnf.FnExplicitWait("XPATH", mbo.UserDetail_Backbtn,driver)){
								cnf.ElementClick(Backbtn,driver); 
								repfn.FnUpdateTestStepResHTML("Verify Back button is clicked ","Back button is clicked","PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Back button is clicked ","Back button is not clicked","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Cancel button is clicked ","Cancel button is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify  Intially Save button is not enabled in Edit Mode","Intially Save button is  enabled in Edit Mode","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Edit button is clicked ","Edit button is not clicked","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify  ManageDetailpopup is displayed "," ManageDetailpopup is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}



		}
		else{
			repfn.FnUpdateTestStepResHTML("Arrow_DetailLink is displayed and Clicked ","Arrow_DetailLink is  not displayed and Clicked","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}
	catch (Exception e)

	{
		repfn.FnUpdateTestStepResHTML("Verifying Edit contact page","Verifying Edit contact page","FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}


public synchronized boolean FnCheckUserDataFields(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

	try{

		// First Name
		if(cnf.FnExplicitWait("XPATH", mbo.EditMode_firstName,driver)){
			repfn.FnUpdateTestStepResHTML("Verify First Name field is displayed ","First Name field is displayed","PASS",runManagerInfoObj);
			blnFlag=true;	
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify First Name field is displayed ","First Name field is not displayed","FAIL",runManagerInfoObj);
			blnFlag=false;	
		}

		//Last Name

		if(cnf.FnExplicitWait("XPATH", mbo.EditMode_LastName,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Last Name field is displayed ","Last Name field is displayed","PASS",runManagerInfoObj);
			blnFlag=true;	
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Last Name field is displayed ","Last Name field is not displayed","FAIL",runManagerInfoObj);
			blnFlag=false;	
		}

		//Title

		if(cnf.FnExplicitWait("XPATH", mbo.ContactTitle,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Contact Title field is displayed ","Contact Title field is displayed","PASS",runManagerInfoObj);
			blnFlag=true;	
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Contact Title field is displayed ","Contact Title field is not displayed","FAIL",runManagerInfoObj);
			blnFlag=false;	
		}

		//Company/Organization

		if(cnf.FnExplicitWait("XPATH", mbo.ContactCompany,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Contact Company field is displayed ","Contact Company field is displayed","PASS",runManagerInfoObj);
			blnFlag=true;	
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Contact Company field is displayed ","Contact Company field is not displayed","FAIL",runManagerInfoObj);
			blnFlag=false;	
		}

		// Phone Number

		if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
			List<WebElement> UserContactList= driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
			repfn.FnUpdateTestStepResHTML("Verify Phone Number field is displayed ","Phone Number field is displayed","PASS",runManagerInfoObj);
			blnFlag=true;	
		}
		else{
			blnFlag = FnVerifyAddNumberOption(driver,runManagerInfoObj);
			if(blnFlag){
				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
					List<WebElement> UserContactListOne= driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
					repfn.FnUpdateTestStepResHTML("Verify Phone Number field is displayed ","Phone Number field is displayed","PASS",runManagerInfoObj);
					blnFlag=true;	
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Phone Number field is displayed ","Phone Number field is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;	
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Phone Number field is displayed ","Phone Number field is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}

		//Email

		if(cnf.FnExplicitWait("XPATH", mbo.EmailList,driver)){
			List<WebElement> Email= driver.findElements(By.xpath(mbo.EmailList));
			repfn.FnUpdateTestStepResHTML("Verify Email field is displayed ","Email field is displayed","PASS",runManagerInfoObj);
			blnFlag=true;	
		}
		else{
			blnFlag=FnClickAddEmail(driver,runManagerInfoObj);
			if(blnFlag){
				if(cnf.FnExplicitWait("XPATH", mbo.EmailList,driver)){
					List<WebElement> EmailOne= driver.findElements(By.xpath(mbo.EmailList));
					repfn.FnUpdateTestStepResHTML("Verify Email field is displayed ","Email field is displayed","PASS",runManagerInfoObj);
					blnFlag=true;	
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Email field is displayed ","Email field is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;	
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Email field is displayed ","Email field is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}

		//Address

		if(cnf.FnExplicitWait("XPATH", mbo.AddressList,driver)){
			List<WebElement> AddressList= driver.findElements(By.xpath(mbo.AddressList));
			repfn.FnUpdateTestStepResHTML("Verify Address fields are displayed ","Address fields are displayed","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			blnFlag=FnClickAddAddress(driver,runManagerInfoObj);
			if(blnFlag){
				if(cnf.FnExplicitWait("XPATH", mbo.AddressList,driver)){
					List<WebElement> AddressListOne= driver.findElements(By.xpath(mbo.AddressList));
					repfn.FnUpdateTestStepResHTML("Verify Address fields are displayed ","Address fields are displayed","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Address fields are displayed ","Address fields are not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;			
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Address fields are displayed ","Address fields are not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;			
			}
		}

	}

	catch(Exception e)
	{

		repfn.FnUpdateTestStepResHTML("Verify all the fields are displayed in Contact Edit form", "All the fields are not displayed in Contact Edit form due to some exception.","FAIL",runManagerInfoObj);
		blnFlag	=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}

	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}

public synchronized boolean FnEditContact(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

	try{

		cnf.FnExplicitWait("XPATH", mbo.EditMode_firstName,driver);   
		WebElement firstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
		if(firstName.isDisplayed()){
			String oldFirstName = firstName.getAttribute("value");
			firstName.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"Billy");
			String newFirstName = firstName.getAttribute("value");
			if(newFirstName != oldFirstName){
				repfn.FnUpdateTestStepResHTML("Verify First Name field is modified ","First Name field is modified","PASS",runManagerInfoObj); 
				blnFlag	=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify First Name field is modified ","First Name field is not modified","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}

		}

		cnf.FnExplicitWait("XPATH", mbo.EditMode_LastName,driver);   
		WebElement LastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
		if(LastName.isDisplayed()){
			String oldLastName = LastName.getAttribute("value");
			LastName.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"Ford");
			String newLastName = LastName.getAttribute("value");
			if(newLastName != oldLastName){
				repfn.FnUpdateTestStepResHTML("Verify Last Name field is modified ","Last Name field is modified","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Last Name field is modified ","Last Name field is not modified","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

		}

		cnf.FnExplicitWait("XPATH", mbo.ContactTitle,driver);   
		WebElement contactTitle=driver.findElement(By.xpath(mbo.ContactTitle));
		if(contactTitle.isDisplayed()){
			String oldTitle = contactTitle.getAttribute("value");
			contactTitle.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"Developer");
			String newTitle = contactTitle.getAttribute("value");
			if(newTitle != oldTitle){
				repfn.FnUpdateTestStepResHTML("Verify Contact Title field is modified ","Contact Title field is modified","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Contact Title field is modified ","Contact Title field is not modified","FAIL",runManagerInfoObj);
				blnFlag=false;	
			}

		}


		cnf.FnExplicitWait("XPATH", mbo.ContactCompany,driver);   
		WebElement contactCompany=driver.findElement(By.xpath(mbo.ContactCompany));
		if(contactCompany.isDisplayed()){
			String oldCompany = contactCompany.getAttribute("value");
			contactCompany.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"TestCo.");
			String newCompany = contactCompany.getAttribute("value");
			if(newCompany != oldCompany){
				repfn.FnUpdateTestStepResHTML("Verify Contact Company field is modified ","Contact Company field is modified","PASS",runManagerInfoObj);
				blnFlag=true;	
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Contact Company field is modified ","Contact Company field is not modified","FAIL",runManagerInfoObj);
				blnFlag=false;	
			}

		}

		//FnVerifyAddNumberOption();

		List<WebElement> Addcontact_PhoneNumber_inputTextList=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
		if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
			Addcontact_PhoneNumber_inputTextList.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"999999"+randomInt);
			repfn.FnUpdateTestStepResHTML("Verify Phone Number is Entered ","Phone Number is Entered","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Phone Number is Entered ","Phone Number is not Entered","FAIL",runManagerInfoObj);
			blnFlag=false;
		}



		//FnClickAddEmail();

		List<WebElement> EmailList=driver.findElements(By.xpath(mbo.EmailList));
		if(cnf.FnExplicitWait("XPATH", mbo.EmailList,driver)){
			EmailList.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"Billy_Ford@abc.com");
			repfn.FnUpdateTestStepResHTML("Verify Email is Entered ","Email is Entered","PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Email is Entered ","Email is not Entered","FAIL",runManagerInfoObj);
			blnFlag=false;
		}

		//Address

		//FnClickAddAddress();

		//cnf.FnExplicitWait("XPATH", mbo.AddressList);
		List<WebElement> AddressList= driver.findElements(By.xpath(mbo.AddressList));
		if(cnf.FnExplicitWait("XPATH", mbo.AddressList,driver)){
			WebElement addressOne = AddressList.get(0);
			if(addressOne.isDisplayed()){
				cnf.ScrollToView(addressOne,driver);
				app.FnAddAddress(driver,runManagerInfoObj);
			}
		}

	}

	catch(Exception e)
	{
		blnFlag	=false;
		repfn.FnUpdateTestStepResHTML("Login to Charter.net ", "Login is not performed due to exception","FAIL",runManagerInfoObj);

	}

	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;

}

public synchronized boolean FnVerifyUserDetails(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
	try{
		cnf.FnExplicitWait("XPATH", mbo.personalDetailVerificationName,driver);
		WebElement personalDetailVerificationName=driver.findElement(By.xpath(mbo.personalDetailVerificationName));
		if(personalDetailVerificationName.getAttribute("textContent").contains("Billy Ford")){
			repfn.FnUpdateTestStepResHTML("Verify Contact Name is displayed ","Contact Name is displayed" ,"PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Contact Name is displayed ","Contact Name is not displayed" ,"FAIL",runManagerInfoObj);
			blnFlag=false;
		}

		List<WebElement>  Addcontact_PhoneNumberVerification=driver.findElements(By.xpath(mbo. Addcontact_PhoneNumberVerification));
		if( Addcontact_PhoneNumberVerification.get(0).getAttribute("innerHTML").contains("999")){	
			repfn.FnUpdateTestStepResHTML("Verify PhoneNumber  is displayed ","PhoneNumber :"+ Addcontact_PhoneNumberVerification.get(0).getText()+" is displayed" ,"PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify PhoneNumber  is displayed ","PhoneNumber :"+ Addcontact_PhoneNumberVerification.get(0).getText()+" is  not displayed","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}

	catch(Exception e)
	{
		blnFlag	=false;
		repfn.FnUpdateTestStepResHTML("Login to Charter.net ", "Login is not performed due to exception","FAIL",runManagerInfoObj);

	}

	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}


public synchronized boolean FnVerifyUserDetailsNotSaved(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
	try{
		cnf.FnExplicitWait("XPATH", mbo.personalDetailVerificationName,driver);
		WebElement personalDetails_Verification=driver.findElement(By.xpath(mbo.personalDetailVerificationName));
		if(!personalDetails_Verification.getAttribute("textContent").contains("Billy Ford")){
			repfn.FnUpdateTestStepResHTML("Verify Contact Name is modified ","Contact Name is not modified" ,"PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Contact Name is modified ","Contact Name is modified" ,"FAIL",runManagerInfoObj);
			blnFlag=false;
		}

		List<WebElement>  Addcontact_PhoneNumberVerification=driver.findElements(By.xpath(mbo. Addcontact_PhoneNumberVerification));
		if(!Addcontact_PhoneNumberVerification.get(0).getAttribute("innerHTML").contains("999")){	
			repfn.FnUpdateTestStepResHTML("Verify PhoneNumber  is modified ","PhoneNumber :"+ Addcontact_PhoneNumberVerification.get(0).getText()+" is not modified" ,"PASS",runManagerInfoObj);
			blnFlag=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify PhoneNumber is modified ","PhoneNumber :"+ Addcontact_PhoneNumberVerification.get(0).getText()+" is modified","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}

	catch(Exception e)
	{
		blnFlag	=false;
		repfn.FnUpdateTestStepResHTML("Login to Charter.net ", "Login is not performed due to exception","FAIL",runManagerInfoObj);

	}

	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}


public synchronized boolean FnCheckInvalidEmail(WebDriver driver, RunManagerInfo runManagerInfoObj) throws InterruptedException {

	int listSize = 0;
	String invalidEmailOne = "";
	String invalidEmailTwo = "";

	try{

		if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
			List<WebElement> Addcontact_EmailInputText=driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
			listSize = Addcontact_EmailInputText.size();
		}

		if(listSize > 0){

			if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
				List<WebElement> Addcontact_EmailInputText=driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
				invalidEmailOne = m1.get("InvalidEmailAdd").toString();
				Addcontact_EmailInputText.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),invalidEmailOne,Keys.TAB);
				repfn.FnUpdateTestStepResHTML("Verify Invalid Email Address is Entered ","Invalid Email Address is Entered: "+invalidEmailOne,"PASS",runManagerInfoObj);

				if(cnf.FnExplicitWait("Xpath", mbo.errorMsg1,driver)){
					WebElement errorMsg1=driver.findElement(By.xpath(mbo.errorMsg1));
					repfn.FnUpdateTestStepResHTML("Verify Invalid Email Address Error Message is Displayed ","Invalid Email Address Error Message is Displayed: "+errorMsg1.getText(),"PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Invalid Email Address Error Message is Displayed ","Invalid Email Address Error Message is not Displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Invalid Email Address is Entered ","Invalid Email Address is not Entered","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

			if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
				List<WebElement> Addcontact_EmailInputText=driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
				if(Addcontact_EmailInputText.size() > 1){
					invalidEmailTwo = m1.get("InvalidEmailAddSec").toString();
					Addcontact_EmailInputText.get(1).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),invalidEmailTwo,Keys.TAB);
					repfn.FnUpdateTestStepResHTML("Verify Invalid Email Address is Entered ","Invalid Email Address is Entered: "+invalidEmailTwo,"PASS",runManagerInfoObj);

					if(cnf.FnExplicitWait("Xpath", mbo.errorMsg2,driver)){
						WebElement errorMsg2=driver.findElement(By.xpath(mbo.errorMsg2));
						repfn.FnUpdateTestStepResHTML("Verify Invalid Email Address Error Message is Displayed ","Invalid Email Address Error Message is Displayed: "+errorMsg2.getText(),"PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Invalid Email Address Error Message is Displayed ","Invalid Email Address Error Message is not Displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					boolean blnFlag1 = FnClickAddEmailAddress(driver,runManagerInfoObj);

					if(blnFlag1){
						if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
							List<WebElement> Addcontact_EmailInputTextList=driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
							invalidEmailTwo = m1.get("InvalidEmailAddSec").toString();
							Addcontact_EmailInputTextList.get(1).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),invalidEmailTwo,Keys.TAB);
							repfn.FnUpdateTestStepResHTML("Verify Invalid Email Address is Entered ","Invalid Email Address is Entered: "+invalidEmailTwo,"PASS",runManagerInfoObj);

							if(cnf.FnExplicitWait("Xpath", mbo.errorMsg2,driver)){
								WebElement errorMsg2=driver.findElement(By.xpath(mbo.errorMsg2));
								repfn.FnUpdateTestStepResHTML("Verify Invalid Email Address Error Message is Displayed ","Invalid Email Address Error Message is Displayed: "+errorMsg2.getText(),"PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Invalid Email Address Error Message is Displayed ","Invalid Email Address Error Message is not Displayed","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Invalid Email Address is Entered ","Invalid Email Address is not Entered","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify User is able to add Email address field", "User is not able to add Email address field","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}						
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Invalid Email Address is Entered ","Invalid Email Address is not Entered","FAIL",runManagerInfoObj);
				blnFlag=false;
			}


			blnFlag=FnCancelAndGoBack(driver,runManagerInfoObj);

			if(blnFlag){
				repfn.FnUpdateTestStepResHTML("Verify User is navigated back to Contacts page","User is navigated back to Contacts page","PASS",runManagerInfoObj);
				blnFlag=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify User is navigated back to Contacts page","User is not navigated back to Contacts page","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else if(listSize == 0){
			repfn.FnUpdateTestStepResHTML("Verify Email Address is displayed ", "Email Address is not displayed. No Email Address is added.","PASS",runManagerInfoObj);
			int listSize_A = 0;
			boolean blnFlag1=FnClickAddEmailAddress(driver,runManagerInfoObj);			

			if(blnFlag1){
				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
					List<WebElement> Addcontact_EmailInputText=driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
					listSize_A = Addcontact_EmailInputText.size();
				}

				if(listSize_A > 0){				
					if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
						List<WebElement> Addcontact_EmailInputText=driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
						invalidEmailOne = m1.get("InvalidEmailAdd").toString();
						Addcontact_EmailInputText.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),invalidEmailOne,Keys.TAB);
						repfn.FnUpdateTestStepResHTML("Verify Invalid Email Address is Entered ","Invalid Email Address is Entered: "+invalidEmailOne,"PASS",runManagerInfoObj);

						if(cnf.FnExplicitWait("Xpath", mbo.errorMsg1,driver)){
							WebElement errorMsg1=driver.findElement(By.xpath(mbo.errorMsg1));
							repfn.FnUpdateTestStepResHTML("Verify Invalid Email Address Error Message is Displayed ","Invalid Email Address Error Message is Displayed: "+errorMsg1.getText(),"PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Invalid Email Address Error Message is Displayed ","Invalid Email Address Error Message is not Displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Invalid Email Address is Entered ","Invalid Email Address is not Entered","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

					if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
						List<WebElement> Addcontact_EmailInputText=driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
						if(Addcontact_EmailInputText.size() > 1){
							invalidEmailTwo = m1.get("InvalidEmailAddSec").toString();
							Addcontact_EmailInputText.get(1).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),invalidEmailTwo,Keys.TAB);
							repfn.FnUpdateTestStepResHTML("Verify Invalid Email Address is Entered ","Invalid Email Address is Entered: "+invalidEmailTwo,"PASS",runManagerInfoObj);

							if(cnf.FnExplicitWait("Xpath", mbo.errorMsg2,driver)){
								WebElement errorMsg2=driver.findElement(By.xpath(mbo.errorMsg2));
								repfn.FnUpdateTestStepResHTML("Verify Invalid Email Address Error Message is Displayed ","Invalid Email Address Error Message is Displayed: "+errorMsg2.getText(),"PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Invalid Email Address Error Message is Displayed ","Invalid Email Address Error Message is not Displayed","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							boolean blnFlag2 = FnClickAddEmailAddress(driver,runManagerInfoObj);

							if(blnFlag2){
								if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
									List<WebElement> Addcontact_EmailInputTextList=driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
									invalidEmailTwo = m1.get("InvalidEmailAddSec").toString();
									Addcontact_EmailInputTextList.get(1).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),invalidEmailTwo,Keys.TAB);
									repfn.FnUpdateTestStepResHTML("Verify Invalid Email Address is Entered ","Invalid Email Address is Entered: "+invalidEmailTwo,"PASS",runManagerInfoObj);

									if(cnf.FnExplicitWait("Xpath", mbo.errorMsg2,driver)){
										WebElement errorMsg2=driver.findElement(By.xpath(mbo.errorMsg2));
										repfn.FnUpdateTestStepResHTML("Verify Invalid Email Address Error Message is Displayed ","Invalid Email Address Error Message is Displayed: "+errorMsg2.getText(),"PASS",runManagerInfoObj);
										blnFlag=true;
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Invalid Email Address Error Message is Displayed ","Invalid Email Address Error Message is not Displayed","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Invalid Email Address is Entered ","Invalid Email Address is not Entered","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify User is able to add Email address field", "User is not able to add Email address field","FAIL",runManagerInfoObj);
								blnFlag	=false;
							}						
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Invalid Email Address is Entered ","Invalid Email Address is not Entered","FAIL",runManagerInfoObj);
						blnFlag=false;
					}


					blnFlag=FnCancelAndGoBack(driver,runManagerInfoObj);

					if(blnFlag){
						repfn.FnUpdateTestStepResHTML("Verify User is navigated back to Contacts page","User is navigated back to Contacts page","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify User is navigated back to Contacts page","User is not navigated back to Contacts page","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Email Address field is displayed ", "Email Address field is not displayed","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify User is able to add Email address field", "User is not able to add Email address field","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}	
		}

	}

	catch (Exception e)

	{
		repfn.FnUpdateTestStepResHTML("Verify User is able to verify Invalid Email Address","User is not able to verify Invalid Email Address due to some exception","FAIL",runManagerInfoObj);
		blnFlag=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean FnEditContact_CancelAndVerify(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
	 try{

		 if(cnf.FnExplicitWait("XPATH", mbo.EditMode_firstName,driver)){
			 WebElement firstName=driver.findElement(By.xpath(mbo.EditMode_firstName));

			 String oldFirstName = firstName.getAttribute("value");
			 firstName.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"William"+randomInt);
			 String newFirstName = firstName.getAttribute("value");
			 if(newFirstName != oldFirstName){
				 repfn.FnUpdateTestStepResHTML("Verify First Name field is modified ","First Name field is modified","PASS",runManagerInfoObj); 
				 blnFlag =true;
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify First Name field is modified ","First Name field is not modified","FAIL",runManagerInfoObj);
				 blnFlag =false;
			 }				 
		 }
		 else{
			 repfn.FnUpdateTestStepResHTML("Verify First Name field is displayed ","First Name field is not displayed","FAIL",runManagerInfoObj);
			 blnFlag =false;
		 }

		 WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
		 String newNameFirst = FirstName.getAttribute("value");


		 if(cnf.FnExplicitWait("XPATH", mbo.EditMode_LastName,driver)){
			 WebElement LastName=driver.findElement(By.xpath(mbo.EditMode_LastName));

			 String oldLastName = LastName.getAttribute("value");
			 LastName.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"Blake");
			 String newLastName = LastName.getAttribute("value");
			 if(newLastName != oldLastName){
				 repfn.FnUpdateTestStepResHTML("Verify Last Name field is modified ","Last Name field is modified","PASS",runManagerInfoObj);
				 blnFlag=true;
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify Last Name field is modified ","Last Name field is not modified","FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }				 
		 }
		 else{
			 repfn.FnUpdateTestStepResHTML("Verify Last Name field is displayed ","Last Name field is not displayed","FAIL",runManagerInfoObj);
			 blnFlag =false;
		 }

		 WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
		 String newNameLast = lastName.getAttribute("value");

		 if(cnf.FnExplicitWait("XPATH", mbo.ContactTitle,driver)){
			 WebElement contactTitle=driver.findElement(By.xpath(mbo.ContactTitle));

			 String oldTitle = contactTitle.getAttribute("value");
			 contactTitle.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"Developer");
			 String newTitle = contactTitle.getAttribute("value");
			 if(newTitle != oldTitle){
				 repfn.FnUpdateTestStepResHTML("Verify Contact Title field is modified ","Contact Title field is modified","PASS",runManagerInfoObj);
				 blnFlag=true;
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify Contact Title field is modified ","Contact Title field is not modified","FAIL",runManagerInfoObj);
				 blnFlag=false;	
			 }
		 }
		 else{
			 repfn.FnUpdateTestStepResHTML("Verify Contact Title field is displayed ","Contact Title field is not displayed","FAIL",runManagerInfoObj);
			 blnFlag =false;
		 }



		 if(cnf.FnExplicitWait("XPATH", mbo.ContactCompany,driver)){
			 WebElement contactCompany=driver.findElement(By.xpath(mbo.ContactCompany));

			 String oldCompany = contactCompany.getAttribute("value");
			 contactCompany.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"TestCo.");
			 String newCompany = contactCompany.getAttribute("value");
			 if(newCompany != oldCompany){
				 repfn.FnUpdateTestStepResHTML("Verify Contact Company field is modified ","Contact Company field is modified","PASS",runManagerInfoObj);
				 blnFlag=true;	
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify Contact Company field is modified ","Contact Company field is not modified","FAIL",runManagerInfoObj);
				 blnFlag=false;	
			 }

		 }			 
		 else{
			 repfn.FnUpdateTestStepResHTML("Verify Contact Company field is displayed ","Contact Company field is not displayed","FAIL",runManagerInfoObj);
			 blnFlag =false;
		 }


		 //FnVerifyAddNumberOption();


		 if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_PhoneNumber_inputText,driver)){
			 List<WebElement> Addcontact_PhoneNumber_inputTextList=driver.findElements(By.xpath(mbo.Addcontact_PhoneNumber_inputText));
			 Addcontact_PhoneNumber_inputTextList.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"994455"+randomInt);
			 repfn.FnUpdateTestStepResHTML("Verify Phone Number is Entered ","Phone Number is Entered","PASS",runManagerInfoObj);
			 blnFlag=true;
		 }
		 else{
			 repfn.FnUpdateTestStepResHTML("Verify Phone Number is Entered ","Phone Number is not Entered","FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }



		 //FnClickAddEmail();


		 if(cnf.FnExplicitWait("XPATH", mbo.EmailList,driver)){
			 List<WebElement> EmailList=driver.findElements(By.xpath(mbo.EmailList));
			 EmailList.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"William_Blake@test.com");
			 repfn.FnUpdateTestStepResHTML("Verify Email is Entered ","Email is Entered","PASS",runManagerInfoObj);
			 blnFlag=true;
		 }
		 else{
			 repfn.FnUpdateTestStepResHTML("Verify Email is Entered ","Email is not Entered","FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }

		 //Address

		 //FnClickAddAddress();

		 //cnf.FnExplicitWait("XPATH", mbo.AddressList);

		 if(cnf.FnExplicitWait("XPATH", mbo.AddressList,driver)){
			 List<WebElement> AddressList= driver.findElements(By.xpath(mbo.AddressList));
			 WebElement addressOne = AddressList.get(0);
			 if(addressOne.isDisplayed()){
				//cnf.ScrollToView(addressOne);
				blnFlag= app.FnAddAddress(driver,runManagerInfoObj);
				if(blnFlag){
					repfn.FnUpdateTestStepResHTML("Verify new address is added.", "New address is added","PASS",runManagerInfoObj);
					blnFlag	=false;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify new address is added.", "New address is not added","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
			 }
		 }
		 else{
			 repfn.FnUpdateTestStepResHTML("Verify Address fields are displayed ","Address fields are not displayed","FAIL",runManagerInfoObj);
			 blnFlag=false;
		 }

		 boolean flag1=FnCancelAndGoBack(driver,runManagerInfoObj);
		 if(flag1){
			 boolean flag2=FnOpenUserDetailsPage(driver,runManagerInfoObj);
			 if(flag2){
				 if(cnf.FnExplicitWait("XPATH", mbo.personalDetailVerificationName,driver)){
					 WebElement personalDetails_Verification=driver.findElement(By.xpath(mbo.personalDetailVerificationName));
					 if(!personalDetails_Verification.getAttribute("textContent").contains(newNameFirst + " " + newNameLast)){
						 repfn.FnUpdateTestStepResHTML("Verify Contact Name is modified ","Contact Name is not modified" ,"PASS",runManagerInfoObj);
						 blnFlag=true;
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify Contact Name is modified ","Contact Name is modified" ,"FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }
		 else{
			 repfn.FnUpdateTestStepResHTML("Verify if the user is able to cancel the changes in Edit Contact form. ", "User is not able to cancel the changes in Edit Contact form","FAIL",runManagerInfoObj);
			 blnFlag = false;
		 }
	 }

	 catch(Exception e)
	 {

		 repfn.FnUpdateTestStepResHTML("Verify if the user is presented with a confirmation popup on cancel of the changes done on the edit contact information window.", 
				 "User is not presented with a confirmation popup on cancel of the changes done on the edit contact information window due to some exception.","FAIL",runManagerInfoObj);
		 blnFlag	=false;
		 System.err.println("Message : "+e.getMessage());
		 System.err.println("Cause : "+e.getCause());

	 }

	 m1.put("STEPSTATUS", blnFlag);
	 return blnFlag;

}
public synchronized boolean FnCancelWithoutChangeAndGoBack(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

	try{

		Thread.sleep(2000);
		if(cnf.FnExplicitWait("XPATH", mbo.CancelEdit,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Cancel link is displayed in Edit Contact form"," Cancel link is displayed in Edit Contact form","PASS",runManagerInfoObj);
			WebElement CancelEdit=driver.findElement(By.xpath(mbo.CancelEdit));
			if(cnf.JSClick(CancelEdit,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Cancel link is clicked in Edit Contact form"," Cancel link is clicked in Edit Contact form","PASS",runManagerInfoObj);
				blnFlag	=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Cancel link is clicked in Edit Contact form"," Cancel link is not clicked in Edit Contact form","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Cancel link is displayed in Edit Contact form"," Cancel link is not displayed in Edit Contact form","FAIL",runManagerInfoObj);
			blnFlag	=false;
		}

		Thread.sleep(5000);

		if(cnf.FnExplicitWait("XPATH", mbo.UserDetail_Backbtn,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Back link is displayed in User Details form"," Back link is displayed in User Details form","PASS",runManagerInfoObj);
			WebElement backButton = driver.findElement(By.xpath(mbo.UserDetail_Backbtn));
			if(cnf.JSClick(backButton,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Back link is clicked in User Details form"," Back link is clicked in User Details form","PASS",runManagerInfoObj);
				blnFlag	=true;
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Back link is clicked in User Details form"," Back link is not clicked in User Details form","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}

		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Back link is displayed in User Details form"," Back link is not displayed in User Details form","FAIL",runManagerInfoObj);
			blnFlag	=false;
		}

		Thread.sleep(2000);
	}

	catch(Exception e)
	{

		repfn.FnUpdateTestStepResHTML("Verify if the user is not presented with a confirmation popup on cancel without making any changes on the edit contact information window.", 
				"User is presented with a confirmation popup on cancel without making any changes on the edit contact information window due to some exception.","FAIL",runManagerInfoObj);
		blnFlag	=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}

	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;

}


public synchronized boolean FnDeleteContact(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

	String fullName = "";
	String firstName = "";
	String lastName = "";

	try{

		if(cnf.FnExplicitWait("XPATH", mbo.EditMode_firstName,driver)){
			WebElement EditMode_firstName= driver.findElement(By.xpath(mbo.EditMode_firstName));
			firstName = EditMode_firstName.getAttribute("value");
			System.out.println("first name: " +firstName);
			blnFlag	=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify First Name input field is displayed", "First Name input field is not displayed","FAIL",runManagerInfoObj);
			blnFlag	=false;
		}

		if(cnf.FnExplicitWait("XPATH", mbo.EditMode_LastName,driver)){
			WebElement EditMode_lastName= driver.findElement(By.xpath(mbo.EditMode_LastName));
			lastName = EditMode_lastName.getAttribute("value");
			System.out.println("last name: " +lastName);
			blnFlag	=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Last Name input field is displayed", "Last Name input field is not displayed","FAIL",runManagerInfoObj);
			blnFlag	=false;
		}

		if(cnf.FnExplicitWait("XPATH", mbo.deleteContact,driver)){
			repfn.FnUpdateTestStepResHTML("Verify User is able to see Delete Contact option", "User is able to see Delete Contact option","PASS",runManagerInfoObj);
			WebElement deleteContact= driver.findElement(By.xpath(mbo.deleteContact));
			if(cnf.JSClick(deleteContact,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Delete Contact link is clicked", "Delete Contact link is clicked","PASS",runManagerInfoObj);
				if(cnf.FnExplicitWait("XPATH", mbo.ConfirmCancel,driver)){
					repfn.FnUpdateTestStepResHTML("Verify popup to confirm Delete Contact is present or not", 
							"Popup to confirm Delete Contact is present","PASS",runManagerInfoObj);
					repfn.FnUpdateTestStepResHTML("Verify Confirm link is displayed in Confirm pop-up", 
							"Confirm link is displayed in Confirm pop-up","PASS",runManagerInfoObj);
					WebElement ConfirmCancel= driver.findElement(By.xpath(mbo.ConfirmCancel));
					if(cnf.JSClick(ConfirmCancel,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Confirm link is clicked in Confirm pop-up", "Confirm link is clicked in Confirm pop-up","PASS",runManagerInfoObj);
						Thread.sleep(5000);

						fullName = firstName + " " + lastName;

						if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
							WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
							cnf.ScrollToView(Search_Field,driver);
							Search_Field.clear();
							Search_Field.sendKeys(fullName);
							repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
							Thread.sleep(2000);

							if(cnf.FnExplicitWait("XPATH",mbo.Contacts_Arrow,driver)){
								repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","PASS",runManagerInfoObj);
								blnFlag=true;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Search field is displayed", "Search field is not displayed","FAIL",runManagerInfoObj);
							blnFlag	= false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Confirm link is clicked in Confirm pop-up", "Confirm link is not clicked in Confirm pop-up","FAIL",runManagerInfoObj);
						blnFlag	= false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify popup to confirm Delete Contact is present or not", 
							"Popup to confirm Delete Contact is not present","FAIL",runManagerInfoObj);
					repfn.FnUpdateTestStepResHTML("Verify Confirm link is displayed in Confirm pop-up", 
							"Confirm link is not displayed in Confirm pop-up","FAIL",runManagerInfoObj);
					blnFlag	= false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Delete Contact link is clicked", "Delete Contact link is not clicked","FAIL",runManagerInfoObj);
				blnFlag	= false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify User is able to see Delete Contact option", "User is not able to see Delete Contact option","FAIL",runManagerInfoObj);
			blnFlag	= false;
		}
	}

	catch(Exception e)
	{

		repfn.FnUpdateTestStepResHTML("Verify Contact is getting deleted. ", "Contact is not getting deleted due to some exception.","FAIL",runManagerInfoObj);
		blnFlag	=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}

	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}




public synchronized boolean FnCancelContactDelete(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{

	String fullName = "";
	String firstName = "";
	String lastName = "";

	try{

		if(cnf.FnExplicitWait("XPATH", mbo.EditMode_firstName,driver)){
			WebElement EditMode_firstName= driver.findElement(By.xpath(mbo.EditMode_firstName));
			firstName = EditMode_firstName.getAttribute("value");
			System.out.println("first name: " +firstName);
			blnFlag	=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify First Name input field is displayed", "First Name input field is not displayed","FAIL",runManagerInfoObj);
			blnFlag	=false;
		}

		if(cnf.FnExplicitWait("XPATH", mbo.EditMode_LastName,driver)){
			WebElement EditMode_lastName= driver.findElement(By.xpath(mbo.EditMode_LastName));
			lastName = EditMode_lastName.getAttribute("value");
			System.out.println("last name: " +lastName);
			blnFlag	=true;
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Last Name input field is displayed", "Last Name input field is not displayed","FAIL",runManagerInfoObj);
			blnFlag	=false;
		}

		if(cnf.FnExplicitWait("XPATH", mbo.deleteContact,driver)){
			repfn.FnUpdateTestStepResHTML("Verify User is able to see Delete Contact option", "User is able to see Delete Contact option","PASS",runManagerInfoObj);
			WebElement deleteContact= driver.findElement(By.xpath(mbo.deleteContact));
			if(cnf.JSClick(deleteContact,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Delete Contact link is clicked", "Delete Contact link is clicked","PASS",runManagerInfoObj);
				if(cnf.FnExplicitWait("XPATH", mbo.CancelDelete,driver)){
					repfn.FnUpdateTestStepResHTML("Verify popup to confirm Delete Contact is present or not", 
							"Popup to confirm Delete Contact is present","PASS",runManagerInfoObj);
					repfn.FnUpdateTestStepResHTML("Verify Cancel link is displayed in Confirm pop-up", "Cancel link is displayed in Confirm pop-up","PASS",runManagerInfoObj);
					WebElement CancelDelete= driver.findElement(By.xpath(mbo.CancelDelete));
					if(cnf.JSClick(CancelDelete,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Cancel link is clicked in Confirm pop-up", "Cancel link is clicked in Confirm pop-up","PASS",runManagerInfoObj);

						Thread.sleep(5000);
						if(cnf.FnExplicitWait("XPATH", mbo.CancelEdit,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Cancel link is displayed in Edit Contact form", "Cancel link is displayed in Edit Contact form","PASS",runManagerInfoObj);
							WebElement CancelEdit= driver.findElement(By.xpath(mbo.CancelEdit));
							if(cnf.JSClick(CancelEdit,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Cancel link is clicked in Edit Contact form", "Cancel link is clicked in Edit Contact form","PASS",runManagerInfoObj);
								Thread.sleep(3000);
								if(cnf.FnExplicitWait("XPATH", mbo.UserDetail_Backbtn,driver)){
									repfn.FnUpdateTestStepResHTML("Verify Back link is displayed in User Details form", "Back link is displayed in User Details form","PASS",runManagerInfoObj);
									WebElement backButton = driver.findElement(By.xpath(mbo.UserDetail_Backbtn));
									if(cnf.JSClick(backButton,driver)){
										repfn.FnUpdateTestStepResHTML("Verify Back link is clicked", "Back link is clicked","PASS",runManagerInfoObj);

										Thread.sleep(5000);

										fullName = firstName + " " + lastName;

										if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
											WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
											cnf.ScrollToView(Search_Field,driver);
											Search_Field.clear();
											Search_Field.sendKeys(fullName);
											repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
											Thread.sleep(2000);


											if(cnf.FnExplicitWait("XPATH", mbo.Contacts_Arrow,driver)){
												repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
												blnFlag=true;
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
												blnFlag=false;
											}

										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Search field is displayed", "Search field is not displayed","FAIL",runManagerInfoObj);
											blnFlag	= false;
										}

									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Back link is clicked", "Back link is not clicked","FAIL",runManagerInfoObj);
										blnFlag	= false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Back link is displayed in User Details form", "Back link is not displayed in User Details form","FAIL",runManagerInfoObj);
									blnFlag	= false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Cancel link is clicked in Edit Contact form", "Cancel link is not clicked in Edit Contact form","FAIL",runManagerInfoObj);
								blnFlag	= false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Cancel link is displayed in Edit Contact form", "Cancel link is not displayed in Edit Contact form","FAIL",runManagerInfoObj);
							blnFlag	= false;
						}

					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Cancel link is clicked", "Cancel link is not clicked","FAIL",runManagerInfoObj);
						blnFlag	= false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify popup to confirm Delete Contact is present or not", 
							"Popup to confirm Delete Contact is not present","FAIL",runManagerInfoObj);
					repfn.FnUpdateTestStepResHTML("Verify Cancel link is displayed in Confirm pop-up", "Cancel link is not displayed in Confirm pop-up","FAIL",runManagerInfoObj);
					blnFlag	= false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Delete Contact link is clicked", "Delete Contact link is not clicked","FAIL",runManagerInfoObj);
				blnFlag	= false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify User is able to see Delete Contact option", "User is not able to see Delete Contact option","FAIL",runManagerInfoObj);
			blnFlag	= false;
		}

	}

	catch(Exception e)
	{
		repfn.FnUpdateTestStepResHTML("Verify Contact Delete is canceled.", "Contact Delete is not canceled due to some exception.","FAIL",runManagerInfoObj);
		blnFlag	=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}

	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}

public synchronized boolean FnDeleteEmailAddressSave(WebDriver driver,RunManagerInfo runManagerInfoObj) {
	
	int listSize = 0;
	String emailAddress = "";
	String fullName = "";
	try
	{
		if(cnf.FnExplicitWait("XPATH", mbo.deleteIcon,driver)){
			List<WebElement> deleteAddressButtonList=driver.findElements(By.xpath(mbo.deleteIcon));
			listSize = deleteAddressButtonList.size();
		}
		
		if(listSize > 0){
			if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
				List<WebElement> Addcontact_EmailInputText=driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
				if(Addcontact_EmailInputText.get(0).isDisplayed()){
					emailAddress = Addcontact_EmailInputText.get(0).getAttribute("value");
				}
			}
			
			WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
			String newNameFirst = FirstName.getAttribute("value");
			WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
			String lastNameFirst = lastName.getAttribute("value");
			
			if(cnf.FnExplicitWait("XPATH", mbo.deleteIcon,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Delete Email Address button is displayed ", "Delete Email Address button is displayed","PASS",runManagerInfoObj);
				List<WebElement> deleteIcon=driver.findElements(By.xpath(mbo.deleteIcon));
				if(cnf.JSClick(deleteIcon.get(0),driver)){
					repfn.FnUpdateTestStepResHTML("Verify Delete Email Address button is clicked ", "Delete Email Address button is clicked","PASS",runManagerInfoObj);
					blnFlag	=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Delete Email Address button is clicked ", "Delete Email Address button is not clicked","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}

			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Delete Email Address button is displayed ", "Delete Email Address button is not displayed","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
			
			fullName = newNameFirst+" "+lastNameFirst;

			blnFlag=app.FnSaveDataAndGoBack(driver,runManagerInfoObj);
			
			Thread.sleep(5000);
			
			cnf.scrollUp(driver);
			
			if(blnFlag == true)
			{
				if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
					WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
					cnf.ScrollToView(Search_Field,driver);
					Search_Field.sendKeys(fullName);
					repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
					Thread.sleep(2000);

					List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
					if(Contacts_Arrow.get(0).isDisplayed()){
						repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
						if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
							repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
								repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

								Thread.sleep(2000);

									if(cnf.FnExplicitWait("XPATH",mbo.emailAddressVerification,driver)){
										List<WebElement> emailAddressVerification=driver.findElements(By.xpath(mbo.emailAddressVerification));
										WebElement emailAddressOne=emailAddressVerification.get(0);
										if(!emailAddressOne.getText().contains(emailAddress)){
											repfn.FnUpdateTestStepResHTML("Verify Email Address is deleted ", "Email Address is deleted","PASS",runManagerInfoObj);
											blnFlag=true;
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Email Address is deleted ", "Email Address is not deleted","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Email Address is deleted ", "Email Address is deleted","PASS",runManagerInfoObj);
										blnFlag=true;
									}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Search Field is displayed ","Search Field is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if the user is able to save the changes in Edit Contact form. ", "User is not able to save the changes in Edit Contact form","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
		}
		else if(listSize == 0){
			repfn.FnUpdateTestStepResHTML("Verify Email Address Delete button is displayed ", "Email Address Delete button is not displayed. No Email address is added.","PASS",runManagerInfoObj);
			int listSize_A = 0;
			boolean blnFlag1 = FnClickAddEmailAddress(driver,runManagerInfoObj);
			boolean blnFlag2 = FnAddEmailAddress(driver,runManagerInfoObj);
			boolean blnFlag3 = app.FnSaveDataAndGoBack(driver,runManagerInfoObj);
			boolean blnFlag4 = FnOpenUserDetailsPage(driver,runManagerInfoObj);
			boolean blnFlag5 = FnOpenEditUserPage(driver,runManagerInfoObj);
			
			if(blnFlag1 && blnFlag2 && blnFlag3 && blnFlag4 && blnFlag5){
				if(cnf.FnExplicitWait("XPATH", mbo.deleteIcon,driver)){
					List<WebElement> deleteAddressBtnList=driver.findElements(By.xpath(mbo.deleteIcon));
					listSize_A = deleteAddressBtnList.size();
				}
				
				if(listSize_A > 0){
					if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
						List<WebElement> Addcontact_EmailInputText=driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
						if(Addcontact_EmailInputText.get(0).isDisplayed()){
							emailAddress = Addcontact_EmailInputText.get(0).getAttribute("value");
						}
					}
					
					WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
					String newNameFirst = FirstName.getAttribute("value");
					WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
					String lastNameFirst = lastName.getAttribute("value");
					
					if(cnf.FnExplicitWait("XPATH", mbo.deleteIcon,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Delete Email Address button is displayed ", "Delete Email Address button is displayed","PASS",runManagerInfoObj);
						List<WebElement> deleteIcon=driver.findElements(By.xpath(mbo.deleteIcon));
						if(cnf.JSClick(deleteIcon.get(0),driver)){
							repfn.FnUpdateTestStepResHTML("Verify Delete Email Address button is clicked ", "Delete Email Address button is clicked","PASS",runManagerInfoObj);
							blnFlag	=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Delete Email Address button is clicked ", "Delete Email Address button is not clicked","FAIL",runManagerInfoObj);
							blnFlag	=false;
						}

					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Delete Email Address button is displayed ", "Delete Email Address button is not displayed","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
					
					fullName = newNameFirst+" "+lastNameFirst;

					blnFlag=app.FnSaveDataAndGoBack(driver,runManagerInfoObj);
					
					Thread.sleep(5000);
					
					cnf.scrollUp(driver);
					
					if(blnFlag == true)
					{
						if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
							WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
							cnf.ScrollToView(Search_Field,driver);
							Search_Field.sendKeys(fullName);
							repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
							Thread.sleep(2000);

							List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
							if(Contacts_Arrow.get(0).isDisplayed()){
								repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
								if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
									repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
									if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
										repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

										Thread.sleep(2000);

										if(cnf.FnExplicitWait("XPATH",mbo.emailAddressVerification,driver)){
											repfn.FnUpdateTestStepResHTML("Verify Email Address is not deleted ", "Email Address is not deleted","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Email Address is not deleted ", "Email Address is deleted","PASS",runManagerInfoObj);
											blnFlag=true;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Search Field is displayed ","Search Field is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify if the user is able to save the changes in Edit Contact form. ", "User is not able to save the changes in Edit Contact form","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Email Address is displayed", "Email Address is not displayed","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Email Address is added and saved ", "Email Address is not added and saved","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
		}
		
	}
	catch(Exception e)
	{
		blnFlag=false;
		repfn.FnUpdateTestStepResHTML("Verify if user is able to delete and save email address"," User is not able to delete and save email address due to some exception", "FAIL",runManagerInfoObj);
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	//FnNavigateBackOverviewPage();
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;

}


public synchronized boolean FnDeleteEmailAddressCancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws InterruptedException {
	
	int listSize = 0;
	String emailAddress = "";
	String fullName = "";

	try{

		if(cnf.FnExplicitWait("XPATH", mbo.deleteIcon,driver)){
			List<WebElement> deleteAddressButtonList=driver.findElements(By.xpath(mbo.deleteIcon));
			listSize = deleteAddressButtonList.size();
		}

		if(listSize > 0){
			if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
				List<WebElement> Addcontact_EmailInputText=driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
				if(Addcontact_EmailInputText.get(0).isDisplayed()){
					emailAddress = Addcontact_EmailInputText.get(0).getAttribute("value");
				}
			}

			WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
			String newNameFirst = FirstName.getAttribute("value");
			WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
			String lastNameFirst = lastName.getAttribute("value");

			if(cnf.FnExplicitWait("XPATH", mbo.deleteIcon,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Delete Email Address button is displayed ", "Delete Email Address button is displayed","PASS",runManagerInfoObj);
				List<WebElement> deleteIcon=driver.findElements(By.xpath(mbo.deleteIcon));
				if(cnf.JSClick(deleteIcon.get(0),driver)){
					repfn.FnUpdateTestStepResHTML("Verify Delete Email Address button is clicked ", "Delete Email Address button is clicked","PASS",runManagerInfoObj);
					blnFlag	=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Delete Email Address button is clicked ", "Delete Email Address button is not clicked","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}

			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Delete Email Address button is displayed ", "Delete Email Address button is not displayed","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}

			fullName = newNameFirst+" "+lastNameFirst;

			blnFlag=FnCancelAndGoBack(driver,runManagerInfoObj);

			Thread.sleep(5000);
			
			cnf.scrollUp(driver);
			if(blnFlag==true)
			{
			if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
				WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
				cnf.ScrollToView(Search_Field,driver);
				Search_Field.sendKeys(fullName);
				repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
				Thread.sleep(2000);

				List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
				if(Contacts_Arrow.get(0).isDisplayed()){
					repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
					if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
						repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
						if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
							repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

							Thread.sleep(2000);

							if(cnf.FnExplicitWait("XPATH",mbo.emailAddressVerification,driver)){
								List<WebElement> emailAddressVerification=driver.findElements(By.xpath(mbo.emailAddressVerification));
								WebElement emailAddressOne=emailAddressVerification.get(0);
								if(emailAddressOne.getText().contains(emailAddress)){
									repfn.FnUpdateTestStepResHTML("Verify Email Address is not deleted ", "Email Address is not deleted","PASS",runManagerInfoObj);
									blnFlag=true;
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Email Address is not deleted ", "Email Address is deleted","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Email Address is deleted ", "Email Address is deleted","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+newNameFirst+ "is not present in Contacts List","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			}
			else
			{
				blnFlag=false;
			}



		}
		else if(listSize == 0){
			repfn.FnUpdateTestStepResHTML("Verify Email Address Delete button is displayed ", "Email Address Delete button is not displayed. No Email address is added.","PASS",runManagerInfoObj);
			int listSize_A = 0;
			boolean blnFlag1 = FnClickAddEmailAddress(driver,runManagerInfoObj);
			boolean blnFlag2 = FnAddEmailAddress(driver,runManagerInfoObj);
			boolean blnFlag3 =app.FnSaveDataAndGoBack(driver,runManagerInfoObj);
			boolean blnFlag4 = FnOpenUserDetailsPage(driver,runManagerInfoObj);
			boolean blnFlag5 = FnOpenEditUserPage(driver,runManagerInfoObj);
			
			if(blnFlag1 && blnFlag2 && blnFlag3 && blnFlag4 && blnFlag5){
				if(cnf.FnExplicitWait("XPATH", mbo.deleteIcon,driver)){
					List<WebElement> deleteAddressBtnList=driver.findElements(By.xpath(mbo.deleteIcon));
					listSize_A = deleteAddressBtnList.size();
				}

				if(listSize_A > 0){
					if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
						List<WebElement> Addcontact_EmailInputText=driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
						if(Addcontact_EmailInputText.get(0).isDisplayed()){
							emailAddress = Addcontact_EmailInputText.get(0).getAttribute("value");
						}
					}

					WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
					String newNameFirst = FirstName.getAttribute("value");
					WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
					String lastNameFirst = lastName.getAttribute("value");

					if(cnf.FnExplicitWait("XPATH", mbo.deleteIcon,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Delete Email Address button is displayed ", "Delete Email Address button is displayed","PASS",runManagerInfoObj);
						List<WebElement> deleteIcon=driver.findElements(By.xpath(mbo.deleteIcon));
						if(cnf.JSClick(deleteIcon.get(0),driver)){
							repfn.FnUpdateTestStepResHTML("Verify Delete Email Address button is clicked ", "Delete Email Address button is clicked","PASS",runManagerInfoObj);
							blnFlag	=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Delete Email Address button is clicked ", "Delete Email Address button is not clicked","FAIL",runManagerInfoObj);
							blnFlag	=false;
						}

					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Delete Email Address button is displayed ", "Delete Email Address button is not displayed","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}

					fullName = newNameFirst+" "+lastNameFirst;

					FnCancelAndGoBack(driver,runManagerInfoObj);

					Thread.sleep(5000);

					if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
						WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
						cnf.ScrollToView(Search_Field,driver);
						Search_Field.sendKeys(fullName);
						repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
						Thread.sleep(2000);

						List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
						if(Contacts_Arrow.get(0).isDisplayed()){
							repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
							if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
								repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
								if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
									repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

									Thread.sleep(2000);

										if(cnf.FnExplicitWait("XPATH",mbo.emailAddressVerification,driver)){
											List<WebElement> emailAddressVerification=driver.findElements(By.xpath(mbo.emailAddressVerification));
											WebElement UserEmailAddress=emailAddressVerification.get(0);
											if(UserEmailAddress.getText().contains(emailAddress)){
												repfn.FnUpdateTestStepResHTML("Verify Address is not deleted ", "Address is not deleted","PASS",runManagerInfoObj);
												blnFlag=true;
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify Address is not deleted ", "Address is deleted","FAIL",runManagerInfoObj);
												blnFlag=false;
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Address is not deleted ", "Address is deleted","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ","Search field is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Email Address is displayed","Email Address is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Email Address is added and saved ", "Email Address is not added and saved","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
		}
	}

	catch(Exception e)
	{

		repfn.FnUpdateTestStepResHTML("Verify if the user is able to delete the address. ", "User is not able to delete the address due to some exception.","FAIL",runManagerInfoObj);
		blnFlag	=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}

	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;


}
public synchronized boolean FnAddEmailAddressSave(WebDriver driver, RunManagerInfo runManagerInfoObj) throws InterruptedException {
	
	int listSize = 0;
	String fullName = "";
	String email = "";
	try
	{
		if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
			List<WebElement> Addcontact_EmailInputText= driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
			listSize = Addcontact_EmailInputText.size();
		}
		
		if(listSize == 1){
			WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
			String newNameFirst = FirstName.getAttribute("value");
			WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
			String lastNameFirst = lastName.getAttribute("value");
			
			if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
				List<WebElement> Addcontact_EmailInputText=driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
				if(Addcontact_EmailInputText.get(0).isDisplayed()){
					String oldAddressValue = Addcontact_EmailInputText.get(0).getAttribute("value");
					System.out.println("old value: " +oldAddressValue);
					Addcontact_EmailInputText.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"xyz"+randomInt+"@gmail.com");
					String newAddressValue = Addcontact_EmailInputText.get(0).getAttribute("value");
					System.out.println("new value: " +newAddressValue);
					if(newAddressValue != oldAddressValue){
						repfn.FnUpdateTestStepResHTML("Verify Email Address value is modified "," Email Address value is modified ","PASS",runManagerInfoObj);
						blnFlag	= true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Email Address value is modified "," Email Address value is not modified ","FAIL",runManagerInfoObj);
						blnFlag = false;
					}
				}
				email = Addcontact_EmailInputText.get(0).getAttribute("value");
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Email Address field is displayed "," Email Address field is not displayed ","FAIL",runManagerInfoObj);
				blnFlag = false;
			}
			
			fullName = newNameFirst+" "+lastNameFirst;
			driver.manage().window().setSize(new Dimension(100, 100));
			driver.manage().window().maximize();
			boolean blnFlag1=app.FnSaveDataAndGoBack(driver,runManagerInfoObj);
			if(blnFlag1==true)
			{

				if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
					WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
					cnf.ScrollToView(Search_Field,driver);
					Search_Field.sendKeys(fullName);
					repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
					Thread.sleep(2000);

					List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
					if(Contacts_Arrow.get(0).isDisplayed()){
						repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
						if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
							repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
								repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

								Thread.sleep(2000);

								if(cnf.FnExplicitWait("XPATH",mbo.emailAddressVerification,driver)){
									List<WebElement> emailAddressVerification=driver.findElements(By.xpath(mbo.emailAddressVerification));
									WebElement emailAddress=emailAddressVerification.get(0);
									if(emailAddress.getText().contains(email))
									{
										repfn.FnUpdateTestStepResHTML("Verify New Email Address is added or not ", "New Email Address is added","PASS",runManagerInfoObj);
										blnFlag=true;
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify New Email Address is added or not", "New Email Address is not added","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify New Email Address is added or not", "New Email Address is not added","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ","Search field is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if the user is able to save the changes in Edit Contact form. ", "User is not able to save the changes in Edit Contact form","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
		}
		
		else if(listSize == 2){
			WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
			String newNameFirst = FirstName.getAttribute("value");
			WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
			String lastNameFirst = lastName.getAttribute("value");
			
			if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
				List<WebElement> Addcontact_EmailInputText=driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
				if(Addcontact_EmailInputText.get(1).isDisplayed()){
					String oldAddressValue = Addcontact_EmailInputText.get(1).getAttribute("value");
					System.out.println("old value: " +oldAddressValue);
					Addcontact_EmailInputText.get(1).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"xyz"+randomInt+"@gmail.com");
					String newAddressValue = Addcontact_EmailInputText.get(1).getAttribute("value");
					System.out.println("new value: " +newAddressValue);
					if(newAddressValue != oldAddressValue){
						repfn.FnUpdateTestStepResHTML("Verify Email Address value is modified "," Email Address value is modified ","PASS",runManagerInfoObj);
						blnFlag	= true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Email Address value is modified "," Email Address value is not modified ","FAIL",runManagerInfoObj);
						blnFlag = false;
					}
				}
				email = Addcontact_EmailInputText.get(1).getAttribute("value");
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Email Address field is displayed "," Email Address field is not displayed ","FAIL",runManagerInfoObj);
				blnFlag = false;
			}
			
			fullName = newNameFirst+" "+lastNameFirst;
			driver.manage().window().setSize(new Dimension(100, 100));
			driver.manage().window().maximize();
			boolean blnFlag1=app.FnSaveDataAndGoBack(driver,runManagerInfoObj);
			if(blnFlag1==true)
			{

				if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
					WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
					cnf.ScrollToView(Search_Field,driver);
					Search_Field.sendKeys(fullName);
					repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
					Thread.sleep(2000);

					List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
					if(Contacts_Arrow.get(0).isDisplayed()){
						repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
						if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
							repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
								repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

								Thread.sleep(2000);

								if(cnf.FnExplicitWait("XPATH",mbo.emailAddressVerification,driver)){
									List<WebElement> emailAddressVerification=driver.findElements(By.xpath(mbo.emailAddressVerification));
									WebElement emailAddress=emailAddressVerification.get(1);
									if(emailAddress.getText().contains(email))
									{
										repfn.FnUpdateTestStepResHTML("Verify New Email Address is added or not ", "New Email Address is added","PASS",runManagerInfoObj);
										blnFlag=true;
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify New Email Address is added or not", "New Email Address is not added","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify New Email Address is added or not", "New Email Address is not added","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ","Search field is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if the user is able to save the changes in Edit Contact form. ", "User is not able to save the changes in Edit Contact form","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
		}
		
	}
	catch(Exception e)
	{
		blnFlag=false;
		repfn.FnUpdateTestStepResHTML("Verify if user is able to add and save email address"," User is not able to add and save email address due to some exception", "FAIL",runManagerInfoObj);
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	//	FnNavigateBackOverviewPage();
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}


public synchronized boolean FnAddNewContactCancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws InterruptedException {
	
	String fullName = "";
	try
	{
		
		Thread.sleep(2000);
		if(cnf.FnExplicitWait("XPATH", mbo.EditMode_firstName,driver)){
			WebElement firstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
			if(firstName.isDisplayed()){
				String oldFirstName = firstName.getAttribute("value");
				firstName.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"Manavi"+randomInt);
				String newFirstName = firstName.getAttribute("value");
				if(newFirstName != oldFirstName){
					repfn.FnUpdateTestStepResHTML("Verify First Name field is modified ","First Name field is modified","PASS",runManagerInfoObj); 
					blnFlag	=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify First Name field is modified ","First Name field is not modified","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}

			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify First Name field is displayed ","First Name field is not displayed","FAIL",runManagerInfoObj);
			blnFlag	=false;
		}


		//cnf.FnExplicitWait("XPATH", mbo.EditMode_firstName);   
		WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
		String newNameFirst = FirstName.getAttribute("value");


		if(cnf.FnExplicitWait("XPATH", mbo.EditMode_LastName,driver)){
			WebElement LastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
			if(LastName.isDisplayed()){
				String oldLastName = LastName.getAttribute("value");
				LastName.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"Test");
				String newLastName = LastName.getAttribute("value");
				if(newLastName != oldLastName){
					repfn.FnUpdateTestStepResHTML("Verify Last Name field is modified ","Last Name field is modified","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Last Name field is modified ","Last Name field is not modified","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Last Name field is displayed ","Last Name field is not displayed","FAIL",runManagerInfoObj);
			blnFlag	=false;
		}


		//cnf.FnExplicitWait("XPATH", mbo.EditMode_LastName);   
		WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
		String newNameLast = lastName.getAttribute("value");

		if(cnf.FnExplicitWait("XPATH", mbo.ContactTitle,driver)){
			WebElement contactTitle=driver.findElement(By.xpath(mbo.ContactTitle));
			if(contactTitle.isDisplayed()){
				String oldTitle = contactTitle.getAttribute("value");
				contactTitle.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"Developer");
				String newTitle = contactTitle.getAttribute("value");
				if(newTitle != oldTitle){
					repfn.FnUpdateTestStepResHTML("Verify Contact Title field is modified ","Contact Title field is modified","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Contact Title field is modified ","Contact Title field is not modified","FAIL",runManagerInfoObj);
					blnFlag=false;	
				}

			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Contact Title field is displayed ","Contact Title field is not displayed","FAIL",runManagerInfoObj);
			blnFlag=false;	
		}



		if(cnf.FnExplicitWait("XPATH", mbo.ContactCompany,driver)){
			WebElement contactCompany=driver.findElement(By.xpath(mbo.ContactCompany));
			if(contactCompany.isDisplayed()){
				String oldCompany = contactCompany.getAttribute("value");
				contactCompany.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"TestCo.");
				String newCompany = contactCompany.getAttribute("value");
				if(newCompany != oldCompany){
					repfn.FnUpdateTestStepResHTML("Verify Contact Company field is modified ","Contact Company field is modified","PASS",runManagerInfoObj);
					blnFlag=true;	
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Contact Company field is modified ","Contact Company field is not modified","FAIL",runManagerInfoObj);
					blnFlag=false;	
				}

			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Contact Company field is displayed ","Contact Company field is not displayed","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		
		fullName = newNameFirst+" "+newNameLast;
		
		Thread.sleep(2000);
		if(cnf.FnExplicitWait("XPATH", mbo.CancelEdit,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Cancel option is displayed ","Cancel option is displayed","PASS",runManagerInfoObj);
			WebElement Cancel=driver.findElement(By.xpath(mbo.CancelEdit));
				if(cnf.JSClick(Cancel,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Cancel option is clicked ","Cancel option is clicked","PASS",runManagerInfoObj);
					if(cnf.FnExplicitWait("XPATH", mbo.ConfirmCancel,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Confirm option is displayed ","Confirm option is displayed","PASS",runManagerInfoObj);
						WebElement ConfirmCancel=driver.findElement(By.xpath(mbo.ConfirmCancel));
						if(cnf.JSClick(ConfirmCancel,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Editing User Contact is canceled"," Confirm Option is clicked. Hence, Editing User Contact is canceled","PASS",runManagerInfoObj);
							blnFlag	= true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Editing User Contact is canceled"," Confirm Option is not clicked. Editing User Contact was not canceled","FAIL",runManagerInfoObj);
							blnFlag	= false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Confirm option is displayed ","Confirm option is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Cancel option is clicked ","Cancel option is not clicked","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Cancel option is displayed ","Cancel option is not displayed","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		

		Thread.sleep(5000);
		
		if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
			WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
			cnf.ScrollToView(Search_Field,driver);
			Search_Field.sendKeys(fullName);
			Thread.sleep(2000);
			//cnf.FnExplicitWait("XPATH", mbo.contactNameList);
			
			if(cnf.FnExplicitWait("XPATH", mbo.contactNameList,driver)){
				List<WebElement> contactNameList= driver.findElements(By.xpath(mbo.contactNameList));
				//repfn.FnUpdateTestStepResHTML("Verify Contact is present in the Contacts List with First Name as: "+newNameFirst," Contact is present in the Contacts List with First Name as: "+newNameFirst,"PASS",runManagerInfoObj);
				
				for(WebElement name:contactNameList){
					if(!name.getText().equalsIgnoreCase(fullName)){
						blnFlag	= true;
					}
					else{
						blnFlag	= false;
					}
				}
				
				if(blnFlag){
					repfn.FnUpdateTestStepResHTML("Verify Newly added Contact is not added to Contacts list", "Newly added Contact is not added to Contacts list","PASS",runManagerInfoObj);
					blnFlag	= true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify New Contact is not added to Contacts list", "New Contact is added to Contacts list","FAIL",runManagerInfoObj);
					blnFlag	= false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Contact is present in the Contacts List with First Name as: "+newNameFirst," Contact is not present in the Contacts List with First Name as: "+newNameFirst,"PASS",runManagerInfoObj);
				blnFlag	= true;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Search field is displayed", "Search field is not displayed","FAIL",runManagerInfoObj);
			blnFlag	= false;
		}
	}
	catch(Exception e)
	{
		blnFlag=false;
		repfn.FnUpdateTestStepResHTML("Verify if user is able to add and cancel contact"," User is not able to add and cancel contact due to some exception", "FAIL",runManagerInfoObj);
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	//	FnNavigateBackOverviewPage();
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;

}

public synchronized boolean FnAddEmptyContactCancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws InterruptedException {
	try
	{
		if(cnf.FnExplicitWait("XPATH", mbo.CancelEdit,driver)){ 
			repfn.FnUpdateTestStepResHTML("Verify Cancel option is displayed ","Cancel option is displayed","PASS",runManagerInfoObj);
			WebElement Cancel=driver.findElement(By.xpath(mbo.CancelEdit));

			if(cnf.JSClick(Cancel,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Cancel option is clicked ","Cancel option is clicked","PASS",runManagerInfoObj);

				if(cnf.FnExplicitWait("XPATH","//div[@ng-click='openDetails($event, contact)']",driver)) {
					repfn.FnUpdateTestStepResHTML("Verify if the user is navigated back to the Contacts page"," The user is navigated back to the Contacts page","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify if the user is navigated back to the Contacts page"," The user is not navigated back to the Contacts page","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Cancel option is clicked ","Cancel option is not clicked","FAIL",runManagerInfoObj);
				blnFlag=false;
			}				
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Cancel option is displayed ","Cancel option is not displayed","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}
	catch(Exception e)
	{
		blnFlag=false;
		repfn.FnUpdateTestStepResHTML("Verify if user is able to add empty data and cancel contact"," User is not able to add empty data and cancel contact due to some exception", "FAIL",runManagerInfoObj);
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	//	FnNavigateBackOverviewPage();
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;

}

public synchronized boolean FnAddEmailAddressCancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws InterruptedException {


	int listSize = 0;
	int listSizeOne = 0;
	String fullName = "";
	String email = "";
	try
	{
		if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
			List<WebElement> Addcontact_EmailInputText= driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
			listSize = Addcontact_EmailInputText.size();
			listSizeOne = Addcontact_EmailInputText.size();
		}

		if(listSize == 0){
			boolean blnFlagOne = FnClickAddEmailAddress(driver,runManagerInfoObj);
			if(blnFlagOne){
				WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
				String newNameFirst = FirstName.getAttribute("value");
				WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
				String lastNameFirst = lastName.getAttribute("value");

				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
					List<WebElement> Addcontact_EmailInputText=driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
					if(Addcontact_EmailInputText.get(0).isDisplayed()){
						String oldAddressValue = Addcontact_EmailInputText.get(0).getAttribute("value");
						System.out.println("old value: " +oldAddressValue);
						Addcontact_EmailInputText.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"xyz"+randomInt+"@gmail.com");
						String newAddressValue = Addcontact_EmailInputText.get(0).getAttribute("value");
						System.out.println("new value: " +newAddressValue);
						if(newAddressValue != oldAddressValue){
							repfn.FnUpdateTestStepResHTML("Verify Email Address value is modified "," Email Address value is modified ","PASS",runManagerInfoObj);
							blnFlag	= true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Email Address value is modified "," Email Address value is not modified ","FAIL",runManagerInfoObj);
							blnFlag = false;
						}
					}
					email = Addcontact_EmailInputText.get(0).getAttribute("value");
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Email Address field is displayed "," Email Address field is not displayed ","FAIL",runManagerInfoObj);
					blnFlag = false;
				}

				fullName = newNameFirst+" "+lastNameFirst;
				driver.manage().window().setSize(new Dimension(100, 100));
				driver.manage().window().maximize();
				boolean blnFlag1=FnCancelAndGoBack(driver,runManagerInfoObj);

				if(blnFlag1==true)
				{

					if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
						WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
						cnf.ScrollToView(Search_Field,driver);
						Search_Field.clear();
						Search_Field.sendKeys(fullName);
						repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
						Thread.sleep(2000);

						List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
						if(Contacts_Arrow.get(0).isDisplayed()){
							repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
							if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
								repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
								if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
									repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

									Thread.sleep(2000);

									if(cnf.FnExplicitWait("XPATH",mbo.emailAddressVerification,driver)){
										repfn.FnUpdateTestStepResHTML("Verify New Email Address is added or not ", "New Email Address is added","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify New Email Address is added or not", "New Email Address is not added","PASS",runManagerInfoObj);
										blnFlag=true;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ","Search field is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify if the user is able to cancel the changes in Edit Contact form. ", "User is not able to cancel the changes in Edit Contact form","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Email Address input field is displayed", "Email Address input field is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}

		else if(listSize == 1){
			boolean blnFlagTwo = FnClickAddEmailAddress(driver,runManagerInfoObj);
			if(blnFlagTwo){
				WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
				String newNameFirst = FirstName.getAttribute("value");
				WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
				String lastNameFirst = lastName.getAttribute("value");

				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
					List<WebElement> Addcontact_EmailInputText=driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
					if(Addcontact_EmailInputText.get(1).isDisplayed()){
						String oldAddressValue = Addcontact_EmailInputText.get(1).getAttribute("value");
						System.out.println("old value: " +oldAddressValue);
						Addcontact_EmailInputText.get(1).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"xyz"+randomInt+"@gmail.com");
						String newAddressValue = Addcontact_EmailInputText.get(1).getAttribute("value");
						System.out.println("new value: " +newAddressValue);
						if(newAddressValue != oldAddressValue){
							repfn.FnUpdateTestStepResHTML("Verify Email Address value is modified "," Email Address value is modified ","PASS",runManagerInfoObj);
							blnFlag	= true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Email Address value is modified "," Email Address value is not modified ","FAIL",runManagerInfoObj);
							blnFlag = false;
						}
					}
					email = Addcontact_EmailInputText.get(1).getAttribute("value");
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Email Address field is displayed "," Email Address field is not displayed ","FAIL",runManagerInfoObj);
					blnFlag = false;
				}

				fullName = newNameFirst+" "+lastNameFirst;
				driver.manage().window().setSize(new Dimension(100, 100));
				driver.manage().window().maximize();
				boolean blnFlag1=FnCancelAndGoBack(driver,runManagerInfoObj);

				if(blnFlag1==true)
				{
					if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
						WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
						cnf.ScrollToView(Search_Field,driver);
						Search_Field.clear();
						Search_Field.sendKeys(fullName);
						repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
						Thread.sleep(2000);

						List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
						if(Contacts_Arrow.get(0).isDisplayed()){
							repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
							if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
								repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
								if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
									repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

									Thread.sleep(2000);

									if(cnf.FnExplicitWait("XPATH",mbo.emailAddressVerification,driver)){
										List<WebElement> emailAddressVerification=driver.findElements(By.xpath(mbo.emailAddressVerification));
										int size = emailAddressVerification.size();
										if(size < 2){
											repfn.FnUpdateTestStepResHTML("Verify New Email Address is added or not", "New Email Address is not added","PASS",runManagerInfoObj);
											blnFlag=true;
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify New Email Address is added or not ", "New Email Address is added","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Email Address is displayed", "Email Address is not displayed","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ","Search field is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify if the user is able to cancel the changes in Edit Contact form. ", "User is not able to cancel the changes in Edit Contact form","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Email Address input field is displayed", "Email Address input field is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}


		}

		else if(listSize == 2){

			if(cnf.FnExplicitWait("XPATH", mbo.deleteIcon,driver)){
				List<WebElement> deleteAddressList= driver.findElements(By.xpath(mbo.deleteIcon));
				repfn.FnUpdateTestStepResHTML("Verify Delete Email address option is displayed ", "Delete Email address option is displayed","PASS",runManagerInfoObj);
				WebElement deleteAddress = deleteAddressList.get(0);
				if(cnf.JSClick(deleteAddress,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Delete Email address option is clicked ", "Delete Email address option is clicked","PASS",runManagerInfoObj);
					blnFlag=true;					
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Delete Email address option is clicked ", "Delete Email address option is not clicked","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Delete Email address option is displayed ", "Delete Email address option is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}

			boolean blnFlagThree = FnClickAddEmailAddress(driver,runManagerInfoObj);

			if(blnFlagThree){

				WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
				String newNameFirst = FirstName.getAttribute("value");
				WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
				String lastNameFirst = lastName.getAttribute("value");


				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
					List<WebElement> Addcontact_EmailInputText=driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
					if(Addcontact_EmailInputText.get(1).isDisplayed()){
						String oldAddressValue = Addcontact_EmailInputText.get(1).getAttribute("value");
						System.out.println("old value: " +oldAddressValue);
						Addcontact_EmailInputText.get(1).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"xyz"+randomInt+"@gmail.com");
						String newAddressValue = Addcontact_EmailInputText.get(1).getAttribute("value");
						System.out.println("new value: " +newAddressValue);
						if(newAddressValue != oldAddressValue){
							repfn.FnUpdateTestStepResHTML("Verify Email Address value is modified "," Email Address value is modified ","PASS",runManagerInfoObj);
							blnFlag	= true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Email Address value is modified "," Email Address value is not modified ","FAIL",runManagerInfoObj);
							blnFlag = false;
						}
					}
					email = Addcontact_EmailInputText.get(1).getAttribute("value");
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Email Address field is displayed "," Email Address field is not displayed ","FAIL",runManagerInfoObj);
					blnFlag = false;
				}


				fullName = newNameFirst+" "+lastNameFirst;
				driver.manage().window().setSize(new Dimension(100, 100));
				driver.manage().window().maximize();
				boolean blnFlag1=FnCancelAndGoBack(driver,runManagerInfoObj);


				if(blnFlag1==true)
				{

					if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
						WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
						cnf.ScrollToView(Search_Field,driver);
						Search_Field.clear();
						Search_Field.sendKeys(fullName);
						repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
						Thread.sleep(2000);

						List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
						if(Contacts_Arrow.get(0).isDisplayed()){
							repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
							if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
								repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
								if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
									repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

									Thread.sleep(2000);

									if(cnf.FnExplicitWait("XPATH",mbo.emailAddressVerification,driver)){
										List<WebElement> emailAddressVerification=driver.findElements(By.xpath(mbo.emailAddressVerification));
										WebElement emailAddress=emailAddressVerification.get(1);
										if(emailAddress.getText().contains(email))
										{
											repfn.FnUpdateTestStepResHTML("Verify New Email Address is added or not ", "New Email Address is added","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify New Email Address is added or not", "New Email Address is not added","PASS",runManagerInfoObj);
											blnFlag=true;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Email Address is displayed or not", "Email Address is not displayed","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ","Search field is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify if the user is able to cancel the changes in Edit Contact form. ", "User is not able to cancel the changes in Edit Contact form","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Email Address input field is displayed", "Email Address input field is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}			
		}
	}
	catch(Exception e)
	{
		blnFlag=false;
		repfn.FnUpdateTestStepResHTML("Verify if user is able to add and cancel saving email address"," User is not able to add and cancel saving email address due to some exception", "FAIL",runManagerInfoObj);
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	//	FnNavigateBackOverviewPage();
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;

}
public synchronized boolean FnModifyEmailAddressSave(WebDriver driver, RunManagerInfo runManagerInfoObj) throws InterruptedException
{

	String Email = "";
	String fullName = "";
	int listSize = 0;

	try{
		
		if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
			List<WebElement> Addcontact_EmailInputText=driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
			listSize = Addcontact_EmailInputText.size();
		}
		
		if(listSize > 0){
			
			WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
			String newNameFirst = FirstName.getAttribute("value");
			WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
			String lastNameFirst = lastName.getAttribute("value");
			
			if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
				List<WebElement> Addcontact_EmailInputText=driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
				if(Addcontact_EmailInputText.get(0).isDisplayed()){
					String oldAddressValue = Addcontact_EmailInputText.get(0).getAttribute("value");
					System.out.println("old value: " +oldAddressValue);
					Addcontact_EmailInputText.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"efg"+randomInt+"@gmail.com");
					String newAddressValue = Addcontact_EmailInputText.get(0).getAttribute("value");
					System.out.println("new value: " +newAddressValue);
					if(newAddressValue != oldAddressValue){
						repfn.FnUpdateTestStepResHTML("Verify Email Address value is modified "," Email Address value is modified ","PASS",runManagerInfoObj);
						blnFlag	= true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Email Address value is modified "," Email Address value is not modified ","FAIL",runManagerInfoObj);
						blnFlag = false;
					}
				}
				
				Email = Addcontact_EmailInputText.get(0).getAttribute("value");

			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Email Address field is displayed "," Email Address field is not displayed ","FAIL",runManagerInfoObj);
				blnFlag = false;
			}
			
			fullName = newNameFirst+" "+lastNameFirst;
			driver.manage().window().setSize(new Dimension(100, 100));
			driver.manage().window().maximize();
			blnFlag=app.FnSaveDataAndGoBack(driver,runManagerInfoObj);
			
			cnf.scrollUp(driver);
			
			if(blnFlag==true)
			{
				if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
					WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
					cnf.ScrollToView(Search_Field,driver);
					Search_Field.sendKeys(fullName);
					repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
					Thread.sleep(2000);

					List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
					if(Contacts_Arrow.get(0).isDisplayed()){
						repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
						if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
							repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
								repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

								Thread.sleep(2000);

									if(cnf.FnExplicitWait("XPATH",mbo.emailAddressVerification,driver)){
										List<WebElement> emailAddressVerification=driver.findElements(By.xpath(mbo.emailAddressVerification));
										WebElement emailAddress=emailAddressVerification.get(0);
										if(emailAddress.getText().contains(Email)){
											repfn.FnUpdateTestStepResHTML("Verify Email Address is modified or not ", "Email Address is modified","PASS",runManagerInfoObj);
											blnFlag=true;
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Email Address is modified or not ", "Email Address is not modified","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Email Address is displayed in User Details page", "Email Address is not displayed in User Details page","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ","Search field is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if the user is able to save the changes in Edit Contact form. ", "User is not able to save the changes in Edit Contact form","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
			
		}
		else if(listSize == 0){
			repfn.FnUpdateTestStepResHTML("Verify Email Address is displayed ", "Email Address is not displayed. No Email address is added.","PASS",runManagerInfoObj);
			int listSize_A = 0;
			boolean blnFlag1 = FnClickAddEmailAddress(driver,runManagerInfoObj);
			boolean blnFlag2 = FnAddEmailAddress(driver,runManagerInfoObj);
			boolean blnFlag3 = app.FnSaveDataAndGoBack(driver,runManagerInfoObj);
			boolean blnFlag4 = FnOpenUserDetailsPage(driver,runManagerInfoObj);
			boolean blnFlag5 = FnOpenEditUserPage(driver,runManagerInfoObj);
			
			if(blnFlag1 && blnFlag2 && blnFlag3 && blnFlag4 && blnFlag5){
				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
					List<WebElement> Addcontact_EmailInputText=driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
					listSize_A = Addcontact_EmailInputText.size();
				}
				
				if(listSize_A > 0){
					WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
					String newNameFirst = FirstName.getAttribute("value");
					WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
					String lastNameFirst = lastName.getAttribute("value");
					
					if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
						List<WebElement> Addcontact_EmailInputText=driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
						if(Addcontact_EmailInputText.get(0).isDisplayed()){
							String oldAddressValue = Addcontact_EmailInputText.get(0).getAttribute("value");
							System.out.println("old value: " +oldAddressValue);
							Addcontact_EmailInputText.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"Work"+randomInt+"@gmail.com");
							String newAddressValue = Addcontact_EmailInputText.get(0).getAttribute("value");
							System.out.println("new value: " +newAddressValue);
							if(newAddressValue != oldAddressValue){
								repfn.FnUpdateTestStepResHTML("Verify Email Address value is modified "," Email Address value is modified ","PASS",runManagerInfoObj);
								blnFlag	= true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Email Address value is modified "," Email Address value is not modified ","FAIL",runManagerInfoObj);
								blnFlag = false;
							}
						}
						
						Email = Addcontact_EmailInputText.get(0).getAttribute("value");

					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Email Address field is displayed "," Email Address field is not displayed ","FAIL",runManagerInfoObj);
						blnFlag = false;
					}
					
					fullName = newNameFirst+" "+lastNameFirst;
					driver.manage().window().setSize(new Dimension(100, 100));
					driver.manage().window().maximize();
					blnFlag=app.FnSaveDataAndGoBack(driver,runManagerInfoObj);
					
					cnf.scrollUp(driver);
					
					if(blnFlag==true)
					{
						if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
							WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
							cnf.ScrollToView(Search_Field,driver);
							Search_Field.sendKeys(fullName);
							repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
							Thread.sleep(2000);

							List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
							if(Contacts_Arrow.get(0).isDisplayed()){
								repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
								if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
									repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
									if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
										repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

										Thread.sleep(2000);

										if(cnf.FnExplicitWait("XPATH",mbo.emailAddressVerification,driver)){
											List<WebElement> emailAddressVerification=driver.findElements(By.xpath(mbo.emailAddressVerification));
											WebElement emailAddress=emailAddressVerification.get(0);
											if(emailAddress.getText().contains(Email)){
												repfn.FnUpdateTestStepResHTML("Verify Email Address is modified or not ", "Email Address is modified","PASS",runManagerInfoObj);
												blnFlag=true;
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify Email Address is modified or not ", "Email Address is not modified","FAIL",runManagerInfoObj);
												blnFlag=false;
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Email Address is displayed in User Details page", "Email Address is not displayed in User Details page","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ","Search field is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify if the user is able to save the changes in Edit Contact form. ", "User is not able to save the changes in Edit Contact form","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}				
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Email Address is displayed ", "Email Address is not displayed","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}	
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Email Address is added and saved ", "Email Address is not added and saved","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
		}
	}

	catch(Exception e)
	{

		repfn.FnUpdateTestStepResHTML("Verify Email address field is modified. ", "Email Address field is not modified due to some exception.","FAIL",runManagerInfoObj);
		blnFlag	=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}

	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}

public synchronized boolean FnModifyEmailAddressCancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws InterruptedException
{

	String Email = "";
	String fullName = "";
	int listSize = 0;

	try{

		if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
			List<WebElement> Addcontact_EmailInputText=driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
			listSize = Addcontact_EmailInputText.size();
		}

		if(listSize > 0){

			WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
			String newNameFirst = FirstName.getAttribute("value");
			WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
			String lastNameFirst = lastName.getAttribute("value");

			if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
				List<WebElement> Addcontact_EmailInputText=driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
				if(Addcontact_EmailInputText.get(0).isDisplayed()){
					String oldAddressValue = Addcontact_EmailInputText.get(0).getAttribute("value");
					System.out.println("old value: " +oldAddressValue);
					Addcontact_EmailInputText.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"Wanka"+randomInt+"@yahoo.com");
					String newAddressValue = Addcontact_EmailInputText.get(0).getAttribute("value");
					System.out.println("new value: " +newAddressValue);
					if(newAddressValue != oldAddressValue){
						repfn.FnUpdateTestStepResHTML("Verify Email Address value is modified "," Email Address value is modified ","PASS",runManagerInfoObj);
						blnFlag	= true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Email Address value is modified "," Email Address value is not modified ","FAIL",runManagerInfoObj);
						blnFlag = false;
					}
				}

				Email = Addcontact_EmailInputText.get(0).getAttribute("value");

			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Email Address field is displayed "," Email Address field is not displayed ","FAIL",runManagerInfoObj);
				blnFlag = false;
			}

			fullName = newNameFirst+" "+lastNameFirst;
			driver.manage().window().setSize(new Dimension(100, 100));
			driver.manage().window().maximize();
			blnFlag=FnCancelAndGoBack(driver,runManagerInfoObj);

			cnf.scrollUp(driver);

			if(blnFlag==true)
			{
				if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
					WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
					cnf.ScrollToView(Search_Field,driver);
					Search_Field.sendKeys(fullName);
					repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
					Thread.sleep(2000);

					List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
					if(Contacts_Arrow.get(0).isDisplayed()){
						repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
						if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
							repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
								repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

								Thread.sleep(2000);

								if(cnf.FnExplicitWait("XPATH",mbo.emailAddressVerification,driver)){
									List<WebElement> emailAddressVerification=driver.findElements(By.xpath(mbo.emailAddressVerification));
									WebElement emailAddress=emailAddressVerification.get(0);
									if(emailAddress.getText().contains(Email)){
										repfn.FnUpdateTestStepResHTML("Verify Email Address is modified or not ", "Email Address is modified","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Email Address is modified or not ", "Email Address is not modified","PASS",runManagerInfoObj);
										blnFlag=true;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Email Address is displayed in User Details page", "Email Address is not displayed in User Details page","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ","Search field is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else
			{
				repfn.FnUpdateTestStepResHTML("Verify if the user is able to cancel the changes in Edit Contact form. ", "User is not able to cancel the changes in Edit Contact form","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}

		}
		else if(listSize == 0){
			repfn.FnUpdateTestStepResHTML("Verify Email Address is displayed ", "Email Address is not displayed. No Email address is added.","PASS",runManagerInfoObj);
			int listSize_A = 0;
			boolean blnFlag1 = FnClickAddEmailAddress(driver,runManagerInfoObj);
			boolean blnFlag2 = FnAddEmailAddress(driver,runManagerInfoObj);
			boolean blnFlag3 = app.FnSaveDataAndGoBack(driver,runManagerInfoObj);
			boolean blnFlag4 = FnOpenUserDetailsPage(driver,runManagerInfoObj);
			boolean blnFlag5 = FnOpenEditUserPage(driver,runManagerInfoObj);

			if(blnFlag1 && blnFlag2 && blnFlag3 && blnFlag4 && blnFlag5){
				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
					List<WebElement> Addcontact_EmailInputText=driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
					listSize_A = Addcontact_EmailInputText.size();
				}

				if(listSize_A > 0){
					WebElement FirstName=driver.findElement(By.xpath(mbo.EditMode_firstName));
					String newNameFirst = FirstName.getAttribute("value");
					WebElement lastName=driver.findElement(By.xpath(mbo.EditMode_LastName));
					String lastNameFirst = lastName.getAttribute("value");

					if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
						List<WebElement> Addcontact_EmailInputText=driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
						if(Addcontact_EmailInputText.get(0).isDisplayed()){
							String oldAddressValue = Addcontact_EmailInputText.get(0).getAttribute("value");
							System.out.println("old value: " +oldAddressValue);
							Addcontact_EmailInputText.get(0).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"Work"+randomInt+"@gmail.com");
							String newAddressValue = Addcontact_EmailInputText.get(0).getAttribute("value");
							System.out.println("new value: " +newAddressValue);
							if(newAddressValue != oldAddressValue){
								repfn.FnUpdateTestStepResHTML("Verify Email Address value is modified "," Email Address value is modified ","PASS",runManagerInfoObj);
								blnFlag	= true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Email Address value is modified "," Email Address value is not modified ","FAIL",runManagerInfoObj);
								blnFlag = false;
							}
						}

						Email = Addcontact_EmailInputText.get(0).getAttribute("value");

					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Email Address field is displayed "," Email Address field is not displayed ","FAIL",runManagerInfoObj);
						blnFlag = false;
					}

					fullName = newNameFirst+" "+lastNameFirst;
					driver.manage().window().setSize(new Dimension(100, 100));
					driver.manage().window().maximize();
					blnFlag=FnCancelAndGoBack(driver,runManagerInfoObj);

					cnf.scrollUp(driver);

					if(blnFlag==true)
					{
						if(cnf.FnExplicitWait("XPATH",mbo.SearchField,driver)){
							WebElement Search_Field=driver.findElement(By.xpath(mbo.SearchField));
							cnf.ScrollToView(Search_Field,driver);
							Search_Field.sendKeys(fullName);
							repfn.FnUpdateTestStepResHTML("Verify User Name is entered in Search field ","User Name:  " +fullName+ " is entered in Search field ","PASS",runManagerInfoObj);
							Thread.sleep(2000);

							List<WebElement> Contacts_Arrow=driver.findElements(By.xpath(mbo.Contacts_Arrow));
							if(Contacts_Arrow.get(0).isDisplayed()){
								repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is present in Contacts List","PASS",runManagerInfoObj);
								if(cnf.JSClick(Contacts_Arrow.get(0),driver)){
									repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is clicked","PASS",runManagerInfoObj);
									if(cnf.FnExplicitWait("XPATH", mbo.UserDetailpopup,driver)){
										repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is displayed","PASS",runManagerInfoObj);

										Thread.sleep(2000);

										if(cnf.FnExplicitWait("XPATH",mbo.emailAddressVerification,driver)){
											List<WebElement> emailAddressVerification=driver.findElements(By.xpath(mbo.emailAddressVerification));
											WebElement emailAddress=emailAddressVerification.get(0);
											if(emailAddress.getText().contains(Email)){
												repfn.FnUpdateTestStepResHTML("Verify Email Address is modified or not ", "Email Address is modified","FAIL",runManagerInfoObj);
												blnFlag=false;
											}
											else{
												repfn.FnUpdateTestStepResHTML("Verify Email Address is modified or not ", "Email Address is not modified","PASS",runManagerInfoObj);
												blnFlag=true;
											}
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Email Address is displayed in User Details page", "Email Address is not displayed in User Details page","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify UserDetailpopup is displayed ","UserDetailpopup is not displayed","FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify User Details Arrow is clicked","User Details Arrow is not clicked","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify User is present in Contacts List","User- "+fullName+ " is not present in Contacts List","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Search field is displayed ","Search field is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify if the user is cancel to save the changes in Edit Contact form. ", "User is not able to cancel the changes in Edit Contact form","FAIL",runManagerInfoObj);
						blnFlag	=false;
					}				
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Email Address is displayed ", "Email Address is not displayed","FAIL",runManagerInfoObj);
					blnFlag	=false;
				}	
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Email Address is added and saved ", "Email Address is not added and saved","FAIL",runManagerInfoObj);
				blnFlag	=false;
			}
		}
	}

	catch(Exception e)
	{

		repfn.FnUpdateTestStepResHTML("Verify Email address field is not modified. ", "Email Address field is modified due to some exception.","FAIL",runManagerInfoObj);
		blnFlag	=false;
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());

	}

	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;
}
public synchronized boolean FnCheckEmailAllotment(WebDriver driver, RunManagerInfo runManagerInfoObj) throws InterruptedException {
	try
	{
		if(cnf.FnExplicitWait("XPATH", mbo.addEmailButton,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify Email address button is displayed", "Email address button is displayed", "PASS",runManagerInfoObj);
			WebElement addEmail=driver.findElement(By.xpath(mbo.addEmailButton));
			if(cnf.JSClick(addEmail,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Email address button is clicked", "Email address button is clicked", "PASS",runManagerInfoObj);
				
				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Email address input field 1 is displayed", "Email address input field 1 is displayed", "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Email address input field 1 is displayed", "Email address input field 1 is not displayed", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Email address button is clicked", "Email address button is not clicked", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Email address button is displayed", "Email address button is not displayed", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		
		if(cnf.FnExplicitWait("XPATH", mbo.addEmailButton,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify Email address button is displayed", "Email address button is displayed", "PASS",runManagerInfoObj);
			WebElement addEmail=driver.findElement(By.xpath(mbo.addEmailButton));
			if(cnf.JSClick(addEmail,driver)){
				repfn.FnUpdateTestStepResHTML("Verify Email address button is clicked", "Email address button is clicked", "PASS",runManagerInfoObj);
				
				if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
					List<WebElement> Addcontact_EmailInputText=driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
					if(Addcontact_EmailInputText.get(1).isDisplayed()){
						repfn.FnUpdateTestStepResHTML("Verify Email address input field 2 is displayed", "Email address input field 2 is displayed", "PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Email address input field 2 is displayed", "Email address input field 2 is not displayed", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Email address input field is displayed", "Email address input field is not displayed", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Email address button is clicked", "Email address button is not clicked", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Email address button is displayed", "Email address button is not displayed", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		
		if(cnf.FnExplicitWait("XPATH", mbo.addEmailButton,driver))
		{
			repfn.FnUpdateTestStepResHTML("Verify Email address button is displayed", "Email address button is displayed", "FAIL",runManagerInfoObj);
			blnFlag=false;
		}
		else{
			if(cnf.FnExplicitWait("XPATH", mbo.Addcontact_EmailInputText,driver)){
				List<WebElement> Addcontact_EmailInputText=driver.findElements(By.xpath(mbo.Addcontact_EmailInputText));
				if(Addcontact_EmailInputText.size() == 2){
					repfn.FnUpdateTestStepResHTML("Verify Email address button is displayed", "Email address button is not displayed. 2 Email address fields are already added. Hence, user can add only 2 email addresses.", "PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify 2 Email address input fields are displayed", "2 Email address input fields are not displayed", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			else{
				repfn.FnUpdateTestStepResHTML("Verify Email address input field is displayed", "Email address input field is not displayed", "FAIL",runManagerInfoObj);
				blnFlag=false;
			}
		}
		
		Thread.sleep(2000);
		if(cnf.FnExplicitWait("XPATH", mbo.CancelEdit,driver)){
			repfn.FnUpdateTestStepResHTML("Verify Cancel option is displayed ","Cancel option is displayed","PASS",runManagerInfoObj);
			WebElement Cancel=driver.findElement(By.xpath(mbo.CancelEdit));
				if(cnf.JSClick(Cancel,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Cancel option is clicked ","Cancel option is clicked","PASS",runManagerInfoObj);
					if(cnf.FnExplicitWait("XPATH", mbo.ConfirmCancel,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Confirm option is displayed ","Confirm option is displayed","PASS",runManagerInfoObj);
						WebElement ConfirmCancel=driver.findElement(By.xpath(mbo.ConfirmCancel));
						if(cnf.JSClick(ConfirmCancel,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Editing User Contact is canceled"," Confirm Option is clicked. Hence, Editing User Contact is canceled","PASS",runManagerInfoObj);
							blnFlag	= true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Editing User Contact is canceled"," Confirm Option is not clicked. Editing User Contact was not canceled","FAIL",runManagerInfoObj);
							blnFlag	= false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Confirm option is displayed ","Confirm option is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Cancel option is clicked ","Cancel option is not clicked","FAIL",runManagerInfoObj);
					blnFlag=false;
				}			
		}
		else{
			repfn.FnUpdateTestStepResHTML("Verify Cancel option is displayed ","Cancel option is not displayed","FAIL",runManagerInfoObj);
			blnFlag=false;
		}
	}
	catch(Exception e)
	{
		blnFlag=false;
		repfn.FnUpdateTestStepResHTML("Verify if User is alloted only two emails"," User is not able to verify his email allotment due to some exception", "FAIL",runManagerInfoObj);
		System.err.println("Message : "+e.getMessage());
		System.err.println("Cause : "+e.getCause());
	}
	//FnNavigateBackOverviewPage();
	m1.put("STEPSTATUS", blnFlag);
	return blnFlag;

}




}
