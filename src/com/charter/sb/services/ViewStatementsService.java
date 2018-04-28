package com.charter.sb.services;

import java.util.List;
import java.util.regex.Pattern;

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

public class ViewStatementsService extends Initialization {
	MB_PageObjects mbo = new MB_PageObjects();
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	public static boolean blnFlag = false;
	
	 public synchronized boolean FnTaxesandFees(WebDriver driver,RunManagerInfo runManagerInfoObj) {
		 try
		 {

			 if(cnf.FnExplicitWait("XPATH", mbo.taxesAndFeesHeader,driver)){
				 repfn.FnUpdateTestStepResHTML("Verify if \"Taxes, Fees & Charges\" Section is present under Charge Details", "\"Taxes, Fees & Charges\" Section is present under Charge Details", "PASS",runManagerInfoObj);

				 if(cnf.FnExplicitWait("XPATH", "//div[@ng-repeat='charge in model.chargeDetails.taxCharges']",driver))
				 {
					 List<WebElement> taxesAndFees=driver.findElements(By.xpath("//div[@ng-repeat='charge in model.chargeDetails.taxCharges']"));
					 repfn.FnUpdateTestStepResHTML("Verify if \"Taxes, Fees & Charges\" Details are displayed", "\"Taxes, Fees & Charges\" Details are displayed. No of rows displayed are: "+taxesAndFees.size(), "PASS",runManagerInfoObj);

					 if(cnf.FnExplicitWait("XPATH", mbo.taxesInfoIcon,driver)){
						 repfn.FnUpdateTestStepResHTML("Verify if Tool-tip icon is displayed with \"Taxes, Fees & Charges\" Header", "Tool-tip icon is displayed with \"Taxes, Fees & Charges\" Header", "PASS",runManagerInfoObj);
						 blnFlag = true;
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify if Tool-tip icon is displayed with \"Taxes, Fees & Charges\" Header", "Tool-tip icon is not displayed with \"Taxes, Fees & Charges\" Header", "FAIL",runManagerInfoObj);
						 blnFlag = false;
					 }

					 if(cnf.FnExplicitWait("XPATH", mbo.taxesAndFeesDate,driver))
					 {
						 List<WebElement> taxesAndFeesDate=driver.findElements(By.xpath(mbo.taxesAndFeesDate));
						 repfn.FnUpdateTestStepResHTML("Verify Date is displayed for each row under \"Taxes, Fees & Charges\" section", "Date is displayed for "+taxesAndFeesDate.size()+" rows under \"Taxes, Fees & Charges\" section", "PASS",runManagerInfoObj);
						 if(Pattern.matches("([0-9]{2})\\/([0-9]{2})\\/([0-9]{2})\\s-\\s([0-9]{2})\\/([0-9]{2})\\/([0-9]{2})", taxesAndFeesDate.get(0).getText()))
						 {
							 repfn.FnUpdateTestStepResHTML("Verify if Date range in format \"MM/DD/YY - MM/DD/YY\" is correct", "Date range in format \"MM/DD/YY - MM/DD/YY\" is correct", "PASS",runManagerInfoObj);
							 blnFlag = true;
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify if Date range in format \"MM/DD/YY - MM/DD/YY\" is correct", "Date range in format \"MM/DD/YY - MM/DD/YY\" is not correct", "FAIL",runManagerInfoObj);
							 blnFlag = false;
						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify Date is displayed for each row under \"Taxes, Fees & Charges\" section", "Date is not displayed for each row under \"Taxes, Fees & Charges\" section", "FAIL",runManagerInfoObj);
						 blnFlag = false;
					 }

					 if(cnf.FnExplicitWait("XPATH", mbo.taxesAndFeesDescription,driver))
					 {
						 List<WebElement> taxesAndFeesDescription=driver.findElements(By.xpath(mbo.taxesAndFeesDescription));
						 repfn.FnUpdateTestStepResHTML("Verify Description is displayed for each row under \"Taxes, Fees & Charges\" section", "Description is displayed for "+taxesAndFeesDescription.size()+" rows under \"Taxes, Fees & Charges\" section", "PASS",runManagerInfoObj);
						 if(!taxesAndFeesDescription.get(0).getText().isEmpty()){
							 repfn.FnUpdateTestStepResHTML("Verify if \"Description\" is displayed", "\"Description\" is displayed: "+taxesAndFeesDescription.get(0).getText(), "PASS",runManagerInfoObj);
							 blnFlag = true;
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify if \"Description\" is displayed", "\"Description\" is not displayed", "FAIL",runManagerInfoObj);
							 blnFlag = false;
						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify Description is displayed for each row under \"Taxes, Fees & Charges\" section", "Description is not displayed for each row under \"Taxes, Fees & Charges\" section", "FAIL",runManagerInfoObj);
						 blnFlag = false;
					 }

					 if(cnf.FnExplicitWait("XPATH", mbo.taxesAndFeesAmount,driver))
					 {
						 List<WebElement> taxesAndFeesAmount=driver.findElements(By.xpath(mbo.taxesAndFeesAmount));
						 repfn.FnUpdateTestStepResHTML("Verify Amount is displayed for each row under \"Taxes, Fees & Charges\" section", "Amount is displayed for "+taxesAndFeesAmount.size()+" rows under \"Taxes, Fees & Charges\" section", "PASS",runManagerInfoObj);
						 if(Pattern.matches("(\\$([0-9]{1}||[0-9]{2})\\.[0-9]{2})", taxesAndFeesAmount.get(0).getText()))	
						 {
							 repfn.FnUpdateTestStepResHTML("Verify if \"Amount\" is displayed in correct format", "\"Amount\" is displayed in correct format: "+taxesAndFeesAmount.get(0).getText(), "PASS",runManagerInfoObj);
							 blnFlag = true;
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify if \"Amount\" is displayed in correct format", "\"Amount\" is not displayed in correct format", "FAIL",runManagerInfoObj);
							 blnFlag = false;
						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify Amount is displayed for each row under \"Taxes, Fees & Charges\" section", "Amount is not displayed for each row under \"Taxes, Fees & Charges\" section", "FAIL",runManagerInfoObj);
						 blnFlag = false;
					 }

				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify if \"Taxes, Fees & Charges\" Details are displayed", "\"Taxes, Fees & Charges\" Details are not displayed", "FAIL",runManagerInfoObj);
					 blnFlag = false;
				 }
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify if \"Taxes, Fees & Charges\" Section is present under Charge Details", "\"Taxes, Fees & Charges\" Section is not present under Charge Details", "FAIL",runManagerInfoObj);
				 blnFlag = false;
			 }

		 }
		 catch (Exception e)

		 {
			 repfn.FnUpdateTestStepResHTML("Verify if user is able to view Taxes & Fees & Charges section under charge details", "User is not able to view Taxes, Fees & Charges section under charge details due to some exception", "FAIL",runManagerInfoObj);
			 System.err.println("Message : " + e.getMessage());
			 System.err.println("Cause : " + e.getCause());
			 blnFlag = false;
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }
	 public synchronized boolean FnPaymentReceived(WebDriver driver,RunManagerInfo runManagerInfoObj) {
		 try
		 {			 
			 if(cnf.FnExplicitWait("XPATH", mbo.paymentReceived,driver))
			 {
				 blnFlag=true;
				 repfn.FnUpdateTestStepResHTML("Verify if Payment Received row is displayed", "Payment Received row is displayed", "PASS",runManagerInfoObj);
				 if(cnf.FnExplicitWait("XPATH", mbo.paymentReceivedText,driver) && driver.findElement(By.xpath(mbo.paymentReceivedText)).getText().equalsIgnoreCase("Payments Received"))
				 {
					 blnFlag=true;
					 repfn.FnUpdateTestStepResHTML("Verify if Payment Received text is displayed", "Payment Received text is displayed", "PASS",runManagerInfoObj);
					 if(cnf.FnExplicitWait("XPATH", mbo.paymentAmountText,driver))
					 {
						 blnFlag=true;
						 repfn.FnUpdateTestStepResHTML("Verify if Payment Amount is displayed", "Payment Amount is displayed: "+driver.findElement(By.xpath(mbo.paymentAmountText)).getText(), "PASS",runManagerInfoObj);
					 }
					 else
					 {
						 blnFlag=false;
						 repfn.FnUpdateTestStepResHTML("Verify if Payment Amount is displayed", "Payment Amount is not displayed", "PASS",runManagerInfoObj);
					 }
				 }
				 else
				 {
					 blnFlag=false;
					 repfn.FnUpdateTestStepResHTML("Verify if payment received text is displayed", "Payment received text is not displayed", "FAIL",runManagerInfoObj);
				 }
			 }
			 else
			 {
				 blnFlag=false;
				 repfn.FnUpdateTestStepResHTML("Verify if payment received row is displayed", "Payment received row is not displayed", "FAIL",runManagerInfoObj);
			 }
		 }
		 catch (Exception e)

		 {
			 blnFlag=false;
			 repfn.FnUpdateTestStepResHTML("Verify if user is able to see payment received information", "User is not able to see payment received information due to some exception", "FAIL",runManagerInfoObj);
			 System.err.println("Message : " + e.getMessage());
			 System.err.println("Cause : " + e.getCause());

		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;

	 }

	 public synchronized boolean FNPayBillButtonClick(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{
			try{

				Thread.sleep(10000);
				if(cnf.FnExplicitWait("XPATH", mbo.PayNow_ViewStatements,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Pay Now button is displayed","Pay Now button is displayed","PASS",runManagerInfoObj);
					WebElement PayNow_ViewStatements=driver.findElement(By.xpath(mbo.PayNow_ViewStatements));
					if(cnf.JSClick(PayNow_ViewStatements,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Pay Now button is clicked","Pay Now button is clicked","PASS",runManagerInfoObj);
						Thread.sleep(5000);

						if(cnf.FnExplicitWait("XPATH", mbo.PageVerificationTwo,driver)){
							WebElement payBill_PageVerification_2=driver.findElement(By.xpath(mbo.PageVerificationTwo));
							if(payBill_PageVerification_2.getAttribute("textContent").equalsIgnoreCase("Pay Bill")){
								repfn.FnUpdateTestStepResHTML("Verify User is navigated to Pay Bill page","User is navigated to Pay Bill page","PASS",runManagerInfoObj);
								blnFlag=true;
							}

							else{
								repfn.FnUpdateTestStepResHTML("Verify User is navigated to Pay Bill page","User is not navigated to Pay Bill page","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify User is able to verify current page","User is not able to verify current page","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Pay Now button is clicked","Pay Now button is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Pay Now button is displayed","Pay Now button is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}


			}

			catch (Exception e)
			{
				repfn.FnUpdateTestStepResHTML("Verify if user is able to verify and click Pay Bill option", "User is not able to verify and click Pay Bill option due to some exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}
	 public synchronized boolean FnLearnMoreinTaxesAndFees(WebDriver driver,RunManagerInfo runManagerInfoObj){

		 try{
			 if(cnf.FnExplicitWait("XPATH", mbo.ViewStatament_Page,driver)){
				 repfn.FnUpdateTestStepResHTML("Verify User is on View Statements page", "User is on View Statements page","PASS",runManagerInfoObj);
				 Thread.sleep(5000);
				 
				 if(cnf.FnExplicitWait("XPATH", mbo.ChargeDetails_Taxes_Fees,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify Taxes,Fees and Charges section is displayed under Charge Details", "Taxes,Fees and Charges section is displayed under Charge Details","PASS",runManagerInfoObj);
					 
					 if(cnf.FnExplicitWait("XPATH", mbo.TaxesFees_Icon,driver)){
						 repfn.FnUpdateTestStepResHTML("Verify Learn More option is present under Taxes and fees ", "Learn More option is present under Taxes and fees","PASS",runManagerInfoObj);
						 if(cnf.FnExplicitWait("XPATH", mbo.TaxesFees_Desc,driver)){
							 List<WebElement> TaxesFees_LearnMore=driver.findElements(By.xpath(mbo.TaxesFees_Icon));
							 List<WebElement> TaxesFees_Description=driver.findElements(By.xpath(mbo.TaxesFees_Desc));
							 String description= TaxesFees_Description.get(0).getText();
							 String strDesc=description.split(",")[0];

							 if(cnf.JSClick(TaxesFees_LearnMore.get(0),driver)){
								 repfn.FnUpdateTestStepResHTML("Verify Learn More option is clicked", "Learn More option is clicked","PASS",runManagerInfoObj);
								 Thread.sleep(3000);
								 if(cnf.FnExplicitWait("XPATH", mbo.LearnMore_ModalWindow,driver)){
									 repfn.FnUpdateTestStepResHTML("Verify Learn More Modal Window is present", "Learn More Modal Window is present","PASS",runManagerInfoObj);
									 WebElement LearnMore_ModalWindow=driver.findElement(By.xpath(mbo.LearnMore_ModalWindow));
									 String title=LearnMore_ModalWindow.getText();
									 if(title.contains(strDesc)){
										 repfn.FnUpdateTestStepResHTML("Verify User is able to see a modal with the long description of the selected service.", "User is able to see a modal with the long description of the selected service.","PASS",runManagerInfoObj);
										 if(cnf.FnExplicitWait("XPATH", mbo.ModalWindow_Button,driver)){
											 repfn.FnUpdateTestStepResHTML("Verify User is able to see the Ok Button on Modal window", "User is able to see the Ok Button on Modal window","PASS",runManagerInfoObj);
											 WebElement ModalWindow_Button=driver.findElement(By.xpath(mbo.ModalWindow_Button));
											 if(cnf.JSClick(ModalWindow_Button,driver)){
												 repfn.FnUpdateTestStepResHTML("Verify User is able to click the Ok Button on Modal window", "User is able to click the Ok Button on Modal window","PASS",runManagerInfoObj);
												 blnFlag=true;
											 }
											 else{
												 repfn.FnUpdateTestStepResHTML("Verify User is able to click the Ok Button on Modal window", "User is not able to click the Ok Button on Modal window","FAIL",runManagerInfoObj);
												 blnFlag=false;
											 }
										 }
										 else{
											 repfn.FnUpdateTestStepResHTML("Verify User is able to see the Ok Button on Modal window", "User is not able to see the Ok Button on Modal window","FAIL",runManagerInfoObj);
											 blnFlag=false;
										 }
									 }
									 else{
										 repfn.FnUpdateTestStepResHTML("Verify User is able to see a modal with the long description of the selected service.", "User is not able to see a modal with the long description of the selected service.","FAIL",runManagerInfoObj);
										 blnFlag=false;
									 }
								 }
								 else{
									 repfn.FnUpdateTestStepResHTML("Verify Learn More Modal Window is present", "Learn More Modal Window is not present","FAIL",runManagerInfoObj);
									 blnFlag=false;
								 }
							 }
							 else{
								 repfn.FnUpdateTestStepResHTML("Verify Learn More option is clicked", "Learn More option is not clicked","FAIL",runManagerInfoObj);
								 blnFlag=false;
							 }
						 }
						 else{
							 repfn.FnUpdateTestStepResHTML("Verify Description is present under Taxes and fees", "Description is not present under Taxes and fees","FAIL",runManagerInfoObj);
							 blnFlag=false;
						 }
					 }
					 else{
						 repfn.FnUpdateTestStepResHTML("Verify Learn More option is present under Taxes and fees", "Learn More option is present under Taxes and fees","FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }
				 else{
					 repfn.FnUpdateTestStepResHTML("Verify Taxes,Fees and Charges section is displayed under Charge Details", "Taxes,Fees and Charges section is not displayed under Charge Details","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify User is on View Statements page", "User is not on View Statements page","FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }
		 }

		 catch (Exception e)
		 {
			 repfn.FnUpdateTestStepResHTML("Verify User is able to view the modal window with description of service of click of Learn More",
					 "User is not able to view the modal window with description of service of click of Learn More due to some exception","FAIL",runManagerInfoObj);
			 blnFlag=false;
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());
		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }
	
	 public synchronized boolean Fn_ChargeDetails_ToolTip(WebDriver driver,RunManagerInfo runManagerInfoObj){
			
			boolean blnFlag=false;
			String description=null;
			try{
				if(cnf.FnExplicitWait("Xpath", mbo.Description,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify if Charge Details Description with tool tip is displayed ", "Charge Details Description with tool tip is displayed", "PASS",runManagerInfoObj);
					List <WebElement> DescriptionList=driver.findElements(By.xpath(mbo.Description));
					if(DescriptionList.size()>0)
					{
						description=DescriptionList.get(0).getText();
						repfn.FnUpdateTestStepResHTML("Verify Description text displayed", "Description text displayed is: "+description, "PASS",runManagerInfoObj);
						
						if(cnf.FnExplicitWait("Xpath", mbo.Tooltip,driver))
						{
							repfn.FnUpdateTestStepResHTML("Verify the presence of Tooltip in Charge Details section ","Tooltip in Charge Details section is present","PASS",runManagerInfoObj);
							List <WebElement> Tooltip=driver.findElements(By.xpath(mbo.Tooltip));
							if(Tooltip.size()>0)
							{
								if(cnf.JSClick(Tooltip.get(0),driver))
								{
									repfn.FnUpdateTestStepResHTML("Verify Tooltip is clicked ","Tooltip is clicked","PASS",runManagerInfoObj);
									if(cnf.FnExplicitWait("Xpath", mbo.Title,driver))
									{
										repfn.FnUpdateTestStepResHTML("Verify if Title is displayed in the pop-up", "Title is displayed in the pop-up", "PASS",runManagerInfoObj);
										WebElement Title=driver.findElement(By.xpath(mbo.Title));
										if(Title.getText().contains(description)){
											repfn.FnUpdateTestStepResHTML("Verify Correct Title is displayed","Correct Title is displayed, Title text is : "+description,"PASS",runManagerInfoObj);
											blnFlag=true;
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Correct Title is displayed","Correct Title is not displayed","FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}
									else
									{
										repfn.FnUpdateTestStepResHTML("Verify if Title is displayed in the pop-up", "Title is not displayed in the pop-up", "FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}
								else
								{
									repfn.FnUpdateTestStepResHTML("Verify Tooltip is clicked ","Tooltip is not clicked","FAIL",runManagerInfoObj);
									blnFlag = false;
								}
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify the presence of Tooltip in Charge Details section ","Tooltip in Charge Details section is not present","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify the presence of Tooltip in Charge Details section ","Tooltip in Charge Details section is not present","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify if Description is displayed", "Description is not displayed ", "FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify if Charge Details Description with tool tip is displayed ", "Charge Details Description with tool tip is not displayed", "FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}

			catch (Exception e)
			{
				repfn.FnUpdateTestStepResHTML("Verify that clicking on learn more displays a modal with the long description of the service","learn more is not present and not clicked","FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
	 public synchronized boolean Fn_ViewStatementsOkClick(WebDriver driver,RunManagerInfo runManagerInfoObj) {
			boolean blnFlag=false;
			try {

				if(cnf.FnExplicitWait("Xpath", mbo.OkButton,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify Ok button is displayed","Ok button is displayed","PASS",runManagerInfoObj);
					WebElement Okbutton=driver.findElement(By.xpath(mbo.OkButton));
					if(cnf.JSClick(Okbutton,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify Ok button is clicked","Ok button is clicked","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify Ok button is clicked","Ok button is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify Ok button is displayed","Ok button is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

			} catch (Exception e) {
				repfn.FnUpdateTestStepResHTML("Verify Ok button is displayed and clicked","Ok button is not displayed and clicked due to some exception","FAIL",runManagerInfoObj);
				System.err.println("Message : " + e.getMessage());
				System.err.println("Cause : " + e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
	 public synchronized boolean Fn_ViewStatementsTotalAmount(WebDriver driver,RunManagerInfo runManagerInfoObj) {
			boolean blnFlag=false;
			try {
				if(cnf.FnExplicitWait("Xpath", mbo.TotalAmount,driver))
				{
					cnf.ScrollToView(driver.findElement(By.xpath(mbo.TotalAmount)),driver);
					WebElement total=driver.findElement(By.xpath(mbo.TotalAmount));
					String totaltext=total.getText();
					repfn.FnUpdateTestStepResHTML("Verify \'Total for Acct.#\' text is displayed","Text displayed is : "+totaltext,"PASS",runManagerInfoObj);
					if(cnf.FnExplicitWait("Xpath", mbo.TotalAmountValue,driver))
					{
						WebElement totalvalue=driver.findElement(By.xpath(mbo.TotalAmountValue));
						String totalValue=totalvalue.getText();
						repfn.FnUpdateTestStepResHTML("Verify Total Amount Value is displayed","Total Amount Value displayed is : "+totalValue,"PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify Total Amount Value is displayed","Total Amount Value is not displayed","PASS",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify \'Total for Acct.#\' text is displayed","\'Total for Acct.#\' text is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			catch (Exception e) {
				System.err.println("Message : " + e.getMessage());
				System.err.println("Cause : " + e.getCause());
				repfn.FnUpdateTestStepResHTML("Verify \'Total for Acct.#\' text is displayed","\'Total for Acct.#\' text is not displayed","FAIL",runManagerInfoObj);
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
	 public synchronized boolean FnVerifyDefaultView(WebDriver driver,RunManagerInfo runManagerInfoObj){

		 try{
			 Thread.sleep(5000);
			 if(cnf.FnExplicitWait("XPATH", mbo.ViewStatament_Page,driver)){
				 repfn.FnUpdateTestStepResHTML("Verify User is on View Statements page", "User is on View Statements page","PASS",runManagerInfoObj);

				 Thread.sleep(5000);
				 if(cnf.FnExplicitWait("XPATH", mbo.ViewStatementDefaultDropDown,driver)){
					 repfn.FnUpdateTestStepResHTML("Verify Default view dropdown for the view statements page is present", "Default view dropdown for the view statements page is present","PASS",runManagerInfoObj);
					 WebElement DefaultViewTag=driver.findElement(By.xpath(mbo.ViewStatementDefaultDropDown));

					 String description= DefaultViewTag.getText();


					 if(description.contains("Current Statement")){
						 repfn.FnUpdateTestStepResHTML("Verify Default view dropdown for the view statements page is of the current statement", "Default view dropdown for the view statements page is of the current statement","PASS",runManagerInfoObj);
						 blnFlag=true;

					 }else{
						 repfn.FnUpdateTestStepResHTML("Verify Default view dropdown for the view statements page is of the current statement", "Default view dropdown for the view statements page is not of the current statement","FAIL",runManagerInfoObj);
						 blnFlag=false;
					 }
				 }else{
					 repfn.FnUpdateTestStepResHTML("Verify Default view dropdown for the view statements page is present", " Default view dropdown for the view statements page is present","FAIL",runManagerInfoObj);
					 blnFlag=false;
				 }
			 }
			 else{
				 repfn.FnUpdateTestStepResHTML("Verify User is on View Statements page", "User is not on View Statements page","FAIL",runManagerInfoObj);
				 blnFlag=false;
			 }

		 }

		 catch (Exception e)

		 {
			 repfn.FnUpdateTestStepResHTML("Verify default view for the view statements page is of the current statement",
					 "default view for the view statements page is not of the current statemente","FAIL",runManagerInfoObj);
			 blnFlag=false;
			 System.err.println("Message : "+e.getMessage());
			 System.err.println("Cause : "+e.getCause());

		 }
		 m1.put("STEPSTATUS", blnFlag);
		 return blnFlag;
	 }
	 public synchronized boolean Fn_ChargeDetails_SubSection(WebDriver driver,RunManagerInfo runManagerInfoObj){
			try{

				if(cnf.FnExplicitWait("XPATH",mbo.ChargeDetails_SpecInet,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Spectrum Internet section in Charge Details section ","Spectrum Internet section is present in Charge Details section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Spectrum Internet section in Charge Details section ","Spectrum Internet section is not present in Charge Details section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				if(cnf.FnExplicitWait("XPATH",mbo.ChargeDetails_SpecTV,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Spectrum TV section in Charge Details section ","Spectrum TV section is present in Charge Details section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Spectrum TV section in Charge Details section ","Spectrum TV section is not present in Charge Details section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				if(cnf.FnExplicitWait("XPATH",mbo.ChargeDetails_SpecPhone,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Spectrum Phone section in Charge Details section ","Spectrum Phone section is present in Charge Details section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Spectrum Phone section in Charge Details section ","Spectrum Phone section is not present in Charge Details section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}

			catch (Exception e)

			{
				repfn.FnUpdateTestStepResHTML("Verify whether user is able to verify sub sections in Charge Details section","User is not able to verify sub sections in Charge Details section due to some exception","FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
	 public synchronized boolean Fn_ChargeDetails_SpectrumInet_Details(WebDriver driver,RunManagerInfo runManagerInfoObj){
			try{

				if(cnf.FnExplicitWait("XPATH",mbo.ChargeDetails_SpecInet,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Spectrum Internet section in Charge Details section ","Spectrum Internet section is present in Charge Details section","PASS",runManagerInfoObj);

					if(cnf.FnExplicitWait("XPATH",mbo.SpectrumInet_Date,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Date column in Spectrum Internet section ","Date column is present in Spectrum Internet section","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Date column in Spectrum Internet section ","Date column is not present in Spectrum Internet section","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					if(cnf.FnExplicitWait("XPATH",mbo.SpectrumInet_Description,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Description column in Spectrum Internet section ","Description column is present in Spectrum Internet section","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Description column in Spectrum Internet section ","Description column is not present in Spectrum Internet section","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					if(cnf.FnExplicitWait("XPATH",mbo.SpectrumInet_Amount,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Amount column in Spectrum Internet section ","Amount column is present in Spectrum Internet section","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Amount column in Spectrum Internet section ","Amount column is not present in Spectrum Internet section","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					if(cnf.FnExplicitWait("XPATH",mbo.SpectrumInet_DateVal,driver))
					{
						List<WebElement> Dates=driver.findElements(By.xpath(mbo.SpectrumInet_DateVal));
						for(int x=0;x<Dates.size();x++)
						{
							if(Pattern.matches("([0-9]{2})\\/([0-9]{2})\\/([0-9]{2})\\s-\\s([0-9]{2})\\/([0-9]{2})\\/([0-9]{2})", Dates.get(x).getText().toString()))
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of Date value and format  MM/DD/YY - MM/DD/YY in Spectrum Internet section ","Date Value is present in Spectrum Internet section"+" "+Dates.get(x).getText().toString(),"PASS",runManagerInfoObj);
								blnFlag=true;
								break;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of Date value and format  MM/DD/YY - MM/DD/YY in Spectrum Internet section ","Date Value is not present in Spectrum Internet section","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Date value in Spectrum Internet section ","Date Value is not present in Spectrum Internet section","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					if(cnf.FnExplicitWait("XPATH",mbo.SpectrumInet_DescripVal,driver))
					{
						List<WebElement> Desc=driver.findElements(By.xpath(mbo.SpectrumInet_DescripVal));
						for(int y=0;y<Desc.size();y++)
						{
							repfn.FnUpdateTestStepResHTML("Verify the presence of Description value in Spectrum Internet section ","Description Value is present in Spectrum Internet section"+" "+Desc.get(y).getText().toString(),"PASS",runManagerInfoObj);
							blnFlag=true;
							break;
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Description value in Spectrum Internet section ","Description Value is not present in Spectrum Internet section","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					
					if(cnf.FnExplicitWait("XPATH",mbo.SpectrumInet_Alert,driver))
					{
						List<WebElement> Alert=driver.findElements(By.xpath(mbo.SpectrumInet_Alert));
						repfn.FnUpdateTestStepResHTML("Verify the presence of Alert in Spectrum Internet section ","No of Alert icons present in Spectrum Internet section: "+Alert.size(),"PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Alert in Spectrum Internet section ","No Alert icons present in Spectrum Internet section","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					if(cnf.FnExplicitWait("XPATH",mbo.SpectrumInet_AmountVal,driver))
					{
						List<WebElement> amt=driver.findElements(By.xpath(mbo.SpectrumInet_AmountVal));
						for(int u=0;u<amt.size();u++)
						{
							if(Pattern.matches("(\\$([0-9]{1}||[0-9]{2}||[0-9]{3}||[0-9]{4})\\.[0-9]{2})", amt.get(u).getText().toString()))	
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of Amount value and format $XXX.XX in Spectrum Internet section ","Amount present in Spectrum Internet section"+" "+amt.get(u).getText().toString(),"PASS",runManagerInfoObj);
								blnFlag=true;
								break;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of Amount value and format $XXX.XX in Spectrum Internet section ","Amount is not present in Spectrum Internet section","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Amount value in Spectrum Internet section ","Amount is not present in Spectrum Internet section","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Spectrum Internet section in Charge Details section ","Spectrum Internet section is not present in Charge Details section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}

			catch (Exception e)
			{
				repfn.FnUpdateTestStepResHTML("Verify whether user is able to verify Spectrum Internet Details in Charge Details section","User is not able to verify Spectrum Internet Details in Charge Details section due to some exception","FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
	 public synchronized boolean Fn_ChargeDetails_SpectrumTV_Details(WebDriver driver,RunManagerInfo runManagerInfoObj){
			try{

				if(cnf.FnExplicitWait("XPATH",mbo.ChargeDetails_SpecTV,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Spectrum TV section in Charge Details section ","Spectrum TV section is present in Charge Details section","PASS",runManagerInfoObj);

					if(cnf.FnExplicitWait("XPATH",mbo.SpectrumTV_Date,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Date column in Spectrum TV section ","Date column is present in Spectrum TV section","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Date column in Spectrum TV section ","Date column is not present in Spectrum TV section","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					if(cnf.FnExplicitWait("XPATH",mbo.SpectrumTV_Description,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Description column in Spectrum TV section ","Description column is present in Spectrum TV section","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Description column in Spectrum TV section ","Description column is not present in Spectrum TV section","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					if(cnf.FnExplicitWait("XPATH",mbo.SpectrumTV_Amount,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Amount column in Spectrum TV section ","Amount column is present in Spectrum TV section","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Amount column in Spectrum TV section ","Amount column is not present in Spectrum TV section","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					if(cnf.FnExplicitWait("XPATH",mbo.Spectrum_DateVal,driver))
					{
						List<WebElement> Dates=driver.findElements(By.xpath(mbo.Spectrum_DateVal));
						for(int x=0;x<Dates.size();x++)
						{
							if(Pattern.matches("([0-9]{2})\\/([0-9]{2})\\/([0-9]{2})\\s-\\s([0-9]{2})\\/([0-9]{2})\\/([0-9]{2})", Dates.get(x).getText().toString()))
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of Date value and format  MM/DD/YY - MM/DD/YY  in Spectrum TV section ","Date Value is present in Spectrum TV section"+" "+Dates.get(x).getText().toString(),"PASS",runManagerInfoObj);
								blnFlag=true;
								break;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of Date value and format  MM/DD/YY - MM/DD/YY in Spectrum TV section ","Date Value is not present in Spectrum TV section","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Date value in Spectrum TV section ","Date Value is not present in Spectrum TV section","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					if(cnf.FnExplicitWait("XPATH",mbo.Spectrum_DescripVal,driver))
					{
						List<WebElement> Desc=driver.findElements(By.xpath(mbo.Spectrum_DescripVal));
						for(int y=0;y<Desc.size();y++)
						{

							repfn.FnUpdateTestStepResHTML("Verify the presence of Description value in Spectrum TV section ","Description Value is present in Spectrum TV section"+" "+Desc.get(y).getText().toString(),"PASS",runManagerInfoObj);
							blnFlag=true;
							break;
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Description value in Spectrum TV section ","Description Value is not present in Spectrum TV section","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					if(cnf.FnExplicitWait("XPATH",mbo.Spectrum_AmountVal,driver))
					{
						List<WebElement> amt=driver.findElements(By.xpath(mbo.Spectrum_AmountVal));
						for(int u=0;u<amt.size();u++)
						{

							if(Pattern.matches("(\\$([0-9]{1}||[0-9]{2}||[0-9]{3}||[0-9]{4})\\.[0-9]{2})", amt.get(u).getText().toString()))	
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of Amount value and format $XXX.XX in Spectrum TV section ","Amount present in Spectrum TV section"+" "+amt.get(u).getText().toString(),"PASS",runManagerInfoObj);
								blnFlag=true;
								break;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of Amount value in Spectrum TV section ","Amount is not present in Spectrum TV section","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Amount value in Spectrum TV section ","Amount is not present in Spectrum TV section","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Spectrum TV section in Charge Details section ","Spectrum TV section is not present in Charge Details section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}

			catch (Exception e)
			{
				repfn.FnUpdateTestStepResHTML("Verify whether user is able to verify Spectrum TV Details in Charge Details section","User is not able to verify Spectrum TV Details in Charge Details section due to some exception","FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
	 public synchronized boolean Fn_ChargeDetails_SpectrumPhone_Details(WebDriver driver,RunManagerInfo runManagerInfoObj){
			try{

				if(cnf.FnExplicitWait("XPATH", mbo.ChargeDetails_SpecPhone,driver)) {	
					repfn.FnUpdateTestStepResHTML("Verify the presence of Spectrum Phone section in Charge Details section ","Spectrum Phone section is present in Charge Details section","PASS",runManagerInfoObj);
					cnf.ScrollToView(driver.findElement(By.xpath(mbo.ChargeDetails_SpecPhone)),driver);

					if(cnf.FnExplicitWait("XPATH",mbo.SpectrumPhone_Date,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Date column in Spectrum Phone section ","Date column is present in Spectrum Phone section","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Date column in Spectrum Phone section ","Date column is not present in Spectrum Phone section","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

					if(cnf.FnExplicitWait("XPATH",mbo.SpectrumPhone_Description,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Description column in Spectrum Phone section ","Description column is present in Spectrum Phone section","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Description column in Spectrum Phone section ","Description column is not present in Spectrum Phone section","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

					if(cnf.FnExplicitWait("XPATH",mbo.SpectrumPhone_Amount,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Amount column in Spectrum Phone section ","Amount column is present in Spectrum Phone section","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Amount column in Spectrum Phone section ","Amount column is not present in Spectrum Phone section","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

					if(cnf.FnExplicitWait("XPATH",mbo.SpectrumPhone_DateVal,driver))
					{
						List<WebElement> Dates=driver.findElements(By.xpath(mbo.SpectrumPhone_DateVal));
						for(int x=0;x<Dates.size();x++)
						{
							if(Pattern.matches("([0-9]{2})\\/([0-9]{2})\\/([0-9]{2})\\s-\\s([0-9]{2})\\/([0-9]{2})\\/([0-9]{2})", Dates.get(x).getText().toString()))
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of Date value and format MM/DD/YY - MM/DD/YY in Spectrum Phone section ","Date Value is present in Spectrum Phone section"+" "+Dates.get(x).getText().toString(),"PASS",runManagerInfoObj);
								blnFlag=true;
								break;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of Date value and format MM/DD/YY - MM/DD/YY in Spectrum Phone section ","Date Value is not present in Spectrum Phone section","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Date value in Spectrum Phone section ","Date Value is not present in Spectrum Phone section","FAIL",runManagerInfoObj);
						blnFlag=false;
					}


					if(cnf.FnExplicitWait("XPATH",mbo.SpectrumPhone_DescripVal,driver))
					{
						List<WebElement> Desc=driver.findElements(By.xpath(mbo.SpectrumPhone_DescripVal));
						for(int y=0;y<Desc.size();y++)
						{
							repfn.FnUpdateTestStepResHTML("Verify the presence of Description value in Spectrum Phone section ","Description Value is present in Spectrum Phone section"+" "+Desc.get(y).getText().toString(),"PASS",runManagerInfoObj);
							blnFlag=true;
							break;
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Description value in Spectrum Phone section ","Description Value is not present in Spectrum Phone section","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

					if(cnf.FnExplicitWait("XPATH",mbo.SpectrumPhone_Alert,driver))
					{
						List<WebElement> Alert=driver.findElements(By.xpath(mbo.SpectrumPhone_Alert));
						repfn.FnUpdateTestStepResHTML("Verify the presence of Alert in Spectrum Phone section ","No of Alert icons present in Spectrum Phone section"+" "+Alert.size(),"PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Alert in Spectrum Phone section ","No Alert icons present in Spectrum Phone section","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

					if(cnf.FnExplicitWait("XPATH",mbo.SpectrumPhone_AmountVal,driver))
					{
						List<WebElement> amt=driver.findElements(By.xpath(mbo.SpectrumPhone_AmountVal));
						for(int u=0;u<amt.size();u++)
						{
							if(Pattern.matches("(\\$([0-9]{1}||[0-9]{2}||[0-9]{3}||[0-9]{4})\\.[0-9]{2})", amt.get(u).getText().toString()))	
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of Amount value in Spectrum Phone section ","Amount present in Spectrum Phone section"+" "+amt.get(u).getText().toString(),"PASS",runManagerInfoObj);
								blnFlag=true;
								break;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of Amount value in Spectrum Phone section ","Amount is not present in Spectrum Phone section","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Amount value in Spectrum Phone section ","Amount is not present in Spectrum Phone section","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Spectrum Phone section in Charge Details section ","Spectrum Phone section is not present in Charge Details section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}

			catch (Exception e)
			{
				repfn.FnUpdateTestStepResHTML("Verify the presence of Spectrum Phone section in Charge Details section ","Spectrum Phone section is not present in Charge Details section due to some exception","FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		//Jhansi-Nov 26,2015
		//Verify that user is able to view the spectrum phone number in Charge Details section details
		public synchronized boolean Fn_ChargeDetails_SpectrumPhoneNum_Details(WebDriver driver,RunManagerInfo runManagerInfoObj){
			try{

				if(cnf.FnExplicitWait("XPATH",mbo.SpectrumPhone_PhoneNum,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Phone number section in Charge Details section ","Phone number section is present in Charge Details section","PASS",runManagerInfoObj);

					if(cnf.FnExplicitWait("XPATH",mbo.SpectrumPhone_PhoneNum_Date,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Date column in Phone number section ","Date column is present in Phone number section","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Date column in Phone number section ","Date column is not present in Phone number section","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					if(cnf.FnExplicitWait("XPATH",mbo.SpectrumPhone_PhoneNum_Description,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Description column in Phone number section ","Description column is present in Phone number section","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Description column in Phone number section ","Description column is not present in Phone number section","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					if(cnf.FnExplicitWait("XPATH",mbo.SpectrumPhone_PhoneNum_Amount,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Amount column in Phone number section ","Amount column is present in Phone number section","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Amount column in Phone number section ","Amount column is not present in Phone number section","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					if(cnf.FnExplicitWait("XPATH",mbo.SpectrumPhone_PhoneNum_Date,driver))
					{
						List<WebElement> Dates=driver.findElements(By.xpath(mbo.SpectrumPhone_PhoneNum_Date));
						for(int x=0;x<Dates.size();x++)
						{
							if(Pattern.matches("([0-9]{2})\\/([0-9]{2})\\/([0-9]{2})\\s-\\s([0-9]{2})\\/([0-9]{2})\\/([0-9]{2})", Dates.get(x).getText().toString()))
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of Date value and format MM/DD/YY - MM/DD/YY in Phone number section ","Date Value is present in Phone number section"+" "+Dates.get(x).getText().toString(),"PASS",runManagerInfoObj);
								blnFlag=true;
								break;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of Date value and format MM/DD/YY - MM/DD/YY in Phone number section ","Date Value is not present in Phone number section","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Date value in Phone number section ","Date Value is not present in Phone number section","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					if(cnf.FnExplicitWait("XPATH",mbo.SpectrumPhone_PhoneNum_Description,driver))
					{
						List<WebElement> Desc=driver.findElements(By.xpath(mbo.SpectrumPhone_PhoneNum_Description));
						for(int y=0;y<Desc.size();y++)
						{

							repfn.FnUpdateTestStepResHTML("Verify the presence of Description value in Phone number section ","Description Value is present in Phone number section"+" "+Desc.get(y).getText().toString(),"PASS",runManagerInfoObj);
							blnFlag=true;
							break;
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Description value in Phone number section ","Description Value is not present in Phone number section","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					if(cnf.FnExplicitWait("XPATH",mbo.SpectrumPhone_PhoneNum_Alert,driver))
					{
						List<WebElement> Alert=driver.findElements(By.xpath(mbo.SpectrumPhone_PhoneNum_Alert));

						repfn.FnUpdateTestStepResHTML("Verify the presence of Alert in Phone number section ","No of Alert icons present in Phone number section"+" "+Alert.size(),"PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Alert in Phone number section ","No Alert icons present in Phone number section","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
					
					if(cnf.FnExplicitWait("XPATH",mbo.SpectrumPhone_PhoneNum_Amount,driver))
					{
						List<WebElement> amt=driver.findElements(By.xpath(mbo.SpectrumPhone_PhoneNum_Amount));
						for(int u=0;u<amt.size();u++)
						{
							if(Pattern.matches("(\\$([0-9]{1}||[0-9]{2})\\.[0-9]{2})", amt.get(u).getText().toString()))	
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of Amount value and format $XXX.XX in Phone number section ","Amount is present in Phone number section"+" "+amt.get(u).getText().toString(),"PASS",runManagerInfoObj);
								blnFlag=true;
								break;
							}
							else
							{
								repfn.FnUpdateTestStepResHTML("Verify the presence of Amount value and format $XXX.XX in Phone number section ","Amount is not present in Phone number section","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify the presence of Amount value in Phone number section ","Amount is not present in Phone number section","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Spectrum Phone section in Charge Details section ","Spectrum Phone section is not present in Charge Details section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}

			catch (Exception e)

			{
				repfn.FnUpdateTestStepResHTML("Verify the presence of Spectrum Phone section in Charge Details section "," Spectrum Phone section is not present in Charge Details section due to some exception","FAIL",runManagerInfoObj);
				blnFlag=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
	 public synchronized boolean Fn_ChargeDetails_Phone_Details(WebDriver driver,RunManagerInfo runManagerInfoObj){

			try{
				boolean blnFlag1 = Fn_ChargeDetails_SpectrumPhone_Details(driver,runManagerInfoObj);
				if(blnFlag1){
					boolean blnFlag2 = Fn_ChargeDetails_SpectrumPhoneNum_Details(driver,runManagerInfoObj);
					if(blnFlag2){
						blnFlag=true;
					}
					else{
						blnFlag=false;
					}
				}
				else{
					boolean blnFlag2 = Fn_ChargeDetails_SpectrumPhoneNum_Details(driver,runManagerInfoObj);
					if(blnFlag2){
						blnFlag=true;
					}
					else{
						blnFlag=false;
					}
				}
			}

			catch (Exception e)
			{
				repfn.FnUpdateTestStepResHTML("Verify whether user is able to verify Spectrum TV Details in Charge Details section","User is not able to verify Spectrum TV Details in Charge Details section due to some exception","FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
	 public synchronized boolean FnVerifyViewStatementPage(WebDriver driver,RunManagerInfo runManagerInfoObj){
			try{
				if(cnf.FnExplicitWait("XPATH", mbo.VerifyViewStatementPage,driver)){	
					repfn.FnUpdateTestStepResHTML("Verify User is on View Statements page after clicking billing section","User is on ViewStatements page","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify User is on View Statements page  after clicking billing section","User is not on View Statements page","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}

			catch (Exception e)
			{
				repfn.FnUpdateTestStepResHTML("Verify if user is navigated to View Statements Page after clicking billing section", "User is not navigated to ViewStatements page due to some exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
	 public synchronized boolean FnVerifyCurrentStatementUI(WebDriver driver,RunManagerInfo runManagerInfoObj){

			try{
				if(cnf.FnExplicitWait("XPATH", mbo.StatementDropdown,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Statement Dropdown is present or not","Statement Dropdown is present","PASS",runManagerInfoObj);
					WebElement StatementDropdown=driver.findElement(By.xpath(mbo.StatementDropdown));
					String currentDropdownText=StatementDropdown.getText();
					if(currentDropdownText.contains("Current Statement -")){
						String date[]=currentDropdownText.split(" - ");
						String text=date[0];
						String Currentdate=date[1];
						System.out.println(Currentdate);
						if(cnf.isValidFormat("mm/dd/yy",Currentdate))
						{
							repfn.FnUpdateTestStepResHTML("Verify Statement Dropdown with default value as 'Current Statement - MM/DD/YY' ","Statement Dropdown is present with default value as: "+currentDropdownText,"PASS",runManagerInfoObj);
							blnFlag=true;
						}else{
							repfn.FnUpdateTestStepResHTML("Verify Statement Dropdown with default value as 'Current Statement - MM/DD/YY' ","Statement Dropdown is not present with default value as: "+currentDropdownText,"FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Statement Dropdown is displayed with default value as \'Current Statement - MM/DD/YY\' ","Statement Dropdown is displayed with default value as \'Current Statement - MM/DD/YY\' ","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Statement Dropdown is present or not","Statement Dropdown is not present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				if(cnf.FnExplicitWait("XPATH", mbo.StatementSummaryTitle,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Statement Title is present or not","Statement Title is present ","PASS",runManagerInfoObj);

					WebElement SummaryTitle=driver.findElement(By.xpath(mbo.StatementSummaryTitle));
					String title=SummaryTitle.getText();
					if(title.equals("Statement Summary")){
						repfn.FnUpdateTestStepResHTML("Verify Statement Title displayed is 'Statement Summary' ","Statement Title is displayed as: "+title,"PASS",runManagerInfoObj);
						blnFlag=true;
					}else{
						repfn.FnUpdateTestStepResHTML("Verify Statement Title displayed is 'Statement Summary' ","Statement Title is not displayed as: "+title,"FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}else{
					repfn.FnUpdateTestStepResHTML("Verify Statement Title is present or not","Statement Title is not present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				if(cnf.FnExplicitWait("XPATH", mbo.CurrentStatementTitle,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Current Statement Title is present or not","Current Statement Title is present","PASS",runManagerInfoObj);

					WebElement CurrentStatementTitle=driver.findElement(By.xpath(mbo.CurrentStatementTitle));

					String title=CurrentStatementTitle.getText();
					if(title.contains("Current Statement -")){
						String date1[]=title.split(" - ");
						String text1=date1[0];
						String Currentdate1=date1[1];

						if(cnf.isValidFormat("mm/dd/yy",Currentdate1)&&(text1.equals("Current Statement"))){

							repfn.FnUpdateTestStepResHTML("Verify Current Statement Title displayed is 'Current Statement - MM/DD/YY' ","Current Statement Title is displayed as: "+title,"PASS",runManagerInfoObj);
							blnFlag=true;
						}else{
							repfn.FnUpdateTestStepResHTML("Verify Statement Title displayed is 'Current Statement - MM/DD/YY' ","Current Statement Title is not displayed as: "+title,"FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}else{
						repfn.FnUpdateTestStepResHTML("Verify Current Statement Title is displayed as Current Statement-","Current Statement Title is not displayed as Current Statement-","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}else{
					repfn.FnUpdateTestStepResHTML("Verify Current Statement Title is present or not","Current Statement Title is not present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				if(cnf.FnExplicitWait("XPATH", mbo.PreviousBalance,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Previous Balance Title is dispalyed or not","Previous Balance Title is displayed","PASS",runManagerInfoObj);
					if(cnf.FnExplicitWait("XPATH", mbo.PreviousBalanceAmount,driver)){

						WebElement PreviousBalanceAmount=driver.findElement(By.xpath(mbo.PreviousBalanceAmount));

						String amount=PreviousBalanceAmount.getText();
						repfn.FnUpdateTestStepResHTML("Verify Previous Balance amount is displayed or not","Previous Balance amount is displayed: "+amount,"PASS",runManagerInfoObj);

						if(cnf.verifyAmountFormat(amount)){

							repfn.FnUpdateTestStepResHTML("Verify Previous Balance amount is displayed in format $X XXX.XX","Previous Balance Amount is displayed as: "+amount,"PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Previous Balance amount is displayed in format $X XXX.XX","Previous Balance Amount is not displayed as per format: "+amount,"FAIL",runManagerInfoObj);
							blnFlag=false;
						}


					}else{
						repfn.FnUpdateTestStepResHTML("Verify Previous Balance amount is displayed or not","Previous Balance Amount is not getting displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}else{
					repfn.FnUpdateTestStepResHTML("Verify Previous Balance Title is present or not","Previous Balance Title is not present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				if(cnf.FnExplicitWait("XPATH", mbo.PaymentsReceived,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Payments Received Title is dispalyed or not","Payments Received Title is displayed","PASS",runManagerInfoObj);
					if(cnf.FnExplicitWait("XPATH", mbo.PaymentsReceived,driver)){

						WebElement PaymentsReceivedAmount=driver.findElement(By.xpath(mbo.PaymentsReceivedAmount));

						String amount=PaymentsReceivedAmount.getText();
						repfn.FnUpdateTestStepResHTML("Verify Payments Received  amount is displayed or not","Payments Received  amount is displayed: "+amount,"PASS",runManagerInfoObj);
						if(amount!="$0.00"){
							if(amount.contains(".")){
								String amountTemp=amount.substring(1);
								String amountTemp1=amountTemp;

								if(Pattern.matches("(\\$([0-9]{1}||[0-9]{2}||[0-9]{3}||[0-9]{4})\\.[0-9]{2})",amount)){

									repfn.FnUpdateTestStepResHTML("Verify Payments Received Amount is displayed in format -$X,XXX.XX","Payments Received Amount is displayed as: "+amount,"PASS",runManagerInfoObj);
									blnFlag=true;
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Payments Received Amount is displayed in format -$X,XXX.XX","Payments Received Amount is not displayed as per format: "+amount,"FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}else{
								repfn.FnUpdateTestStepResHTML("Verify Payments Received Amount is displayed in format -$X,XXX.XX","Payments Received Amount is not displayed as per format: "+amount,"FAIL",runManagerInfoObj);
								blnFlag=false;
							}

						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Payments Received Amount is displayed as per format or not","Payments Received Amount is getting displayed as per format: "+amount,"PASS",runManagerInfoObj);
							blnFlag=true;
						}

					}else{
						repfn.FnUpdateTestStepResHTML("Verify Payments Received Amount is dispalyed or not","Payments Received Amount is not getting displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

				}else{
					repfn.FnUpdateTestStepResHTML("Verify Payments Received Title is present or not","Payments Received is not present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				if(cnf.FnExplicitWait("XPATH", mbo.CurrentBalanceDueTitle,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Current Balance Due Title is dispalyed or not","Current Balance Due Title is displayed","PASS",runManagerInfoObj);
					if(cnf.FnExplicitWait("XPATH", mbo.CurrentBalanceDueAmount,driver)){

						WebElement CurrentBalanceDueAmount=driver.findElement(By.xpath(mbo.CurrentBalanceDueAmount));

						String amount=CurrentBalanceDueAmount.getText();
						repfn.FnUpdateTestStepResHTML("Verify Current Balance Due Title amount is displayed or not","Current Balance Due amount is displayed: "+amount,"PASS",runManagerInfoObj);

						if(cnf.verifyAmountFormat(amount)){

							repfn.FnUpdateTestStepResHTML("Verify Current Balance Due is displayed in format $X,XXX.XX","Current Balance Due is displayed as: "+amount,"PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Current Balance Due amount is displayed in format $X,XXX.XX","Current Balance Due Amount is not displayed as per format: "+amount,"FAIL",runManagerInfoObj);
							blnFlag=false;
						}


					}else{
						repfn.FnUpdateTestStepResHTML("Verify Current Balance Due amount is dispalyed or not","Current Balance Due Amount is not getting displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}else{
					repfn.FnUpdateTestStepResHTML("Verify Current Balance Due Title is present or not","Current Balance Due Title is not present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				if(cnf.FnExplicitWait("XPATH", mbo.Adjustments,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Adjustments Title is dispalyed or not","Adjustments Title is displayed","PASS",runManagerInfoObj);
					if(cnf.FnExplicitWait("XPATH", mbo.AdjustmentsAmount,driver)){

						WebElement AdjustmentsAmount=driver.findElement(By.xpath(mbo.AdjustmentsAmount));

						String amount=AdjustmentsAmount.getText();
						repfn.FnUpdateTestStepResHTML("Verify Adjustments amount is displayed or not","Adjustments amount is displayed: "+amount,"PASS",runManagerInfoObj);

						if(amount!=("$0.00")){
							/*String amountTemp[]=amount.split("-");
					String amountTemp1=amountTemp[0];*/

							if(cnf.verifyAmountFormat(amount)){

								repfn.FnUpdateTestStepResHTML("Verify Adjustments Amount is displayed in format $X,XXX.XX","Adjustments Amount is displayed as: " +amount,"PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Adjustments Amount is displayed in format $X,XXX.XX","Adjustments Amount is not displayed as per format: " +amount,"FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}else{
							repfn.FnUpdateTestStepResHTML("Verify Adjustments Amount is displayed in format if zero :$0.00","Adjustments Amount is  displayed as per format: " +amount,"FAIL",runManagerInfoObj);
							blnFlag=false;
						}


					}else{
						repfn.FnUpdateTestStepResHTML("Verify Adjustments Amount is dispalyed or not","Adjustments Amount is not getting displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}else{
					repfn.FnUpdateTestStepResHTML("Verify Adjustments Title is present or not","Adjustments title is not present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				if(cnf.FnExplicitWait("XPATH", mbo.SpectrumBusinessServices,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Services Title is dispalyed or not","Spectrum Business Services Title is displayed","PASS",runManagerInfoObj);

					if(cnf.FnExplicitWait("XPATH", mbo.SpectrumBusinessServicesDuration,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Services duration is dispalyed or not","Spectrum Business Services duration is displayed","PASS",runManagerInfoObj);
						WebElement duration=driver.findElement(By.xpath(mbo.SpectrumBusinessServicesDuration));
						String dates=duration.getText();
						String dateduration[]=dates.split("-");
						String date1=dateduration[0];
						String date2=dateduration[1];
						if(cnf.isValidFormat("mm/dd/yy",date1) && cnf.isValidFormat("mm/dd/yy",date2)){
							repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Services duration is displayed with date range MM/DD/YY - MM/DD/YY","Spectrum Business Services amount is displayed as per format: "+dates,"PASS",runManagerInfoObj);
							blnFlag=true;	
						}

					}else{
						repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Services duration is displayed with date range MM/DD/YY - MM/DD/YY","Spectrum Business Services amount is not displayed as per format","FAIL",runManagerInfoObj);

						blnFlag=false;
					}
					if(cnf.FnExplicitWait("XPATH", mbo.SpectrumBusinessServicesAmount,driver)){

						WebElement SpectrumBusinessServicesAmount=driver.findElement(By.xpath(mbo.SpectrumBusinessServicesAmount));

						String amount=SpectrumBusinessServicesAmount.getText();
						repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Services Amount is displayed or not","Spectrum Business Services amount is displayed: "+amount,"PASS",runManagerInfoObj);


						if(cnf.verifyAmountFormat(amount)){

							repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Services Amount is displayed in format $X,XXX.XX","Spectrum Business Services Amount is displayed as: "+amount,"PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Services Amount is displayed in format $X,XXX.XX","Spectrum Business Services is not displayed as per format:  "+amount,"FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}else{
						repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Services Amount is dispalyed or not","Spectrum Business Services Amount is not getting displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}else{
					repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Services Title is dispalyed or not","Spectrum Business Services Title is displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				if(cnf.FnExplicitWait("XPATH", mbo.DownloadStatementBtn,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Download Statement button is present or not","Download Statement button is present","PASS",runManagerInfoObj);
					blnFlag=true;
				}else{
					repfn.FnUpdateTestStepResHTML("Verify Download Statement button is present or not","Download Statement button is not present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				if(cnf.FnExplicitWait("XPATH", mbo.PayNowBtn,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Pay Now button is present or not","Pay Now button is present","PASS",runManagerInfoObj);
					blnFlag=true;
				}else{
					repfn.FnUpdateTestStepResHTML("Verify Pay Now button is present or not","Pay Now button is not present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}

			catch (Exception e)

			{
				repfn.FnUpdateTestStepResHTML("Verify if user is navigated to View Statements Page after clicking billing section", "User is not navigated to ViewStatements page", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}

		public synchronized boolean FnVerifyPreviousStatementUI(WebDriver driver,RunManagerInfo runManagerInfoObj){
			try{
				if(cnf.FnExplicitWait("XPATH", mbo.StatementDropdown,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Statement Dropdown is present or not","Statement Dropdown is present","PASS",runManagerInfoObj);
					WebElement StatementDropdown=driver.findElement(By.xpath(mbo.StatementDropdown));

					if(cnf.JSClick(StatementDropdown,driver)){
						if(cnf.FnExplicitWait("XPATH", mbo.StatementDropdownlist,driver)){
							repfn.FnUpdateTestStepResHTML("Verify Statement Dropdown has previous statement date ","Statement Dropdown has previous statement date present in the dropdown","PASS",runManagerInfoObj);
							WebElement StatementDropdownlist=driver.findElement(By.xpath(mbo.StatementDropdownlist));
							String text=StatementDropdownlist.getText();
							if(cnf.JSClick(StatementDropdownlist,driver)){
								Thread.sleep(2000);
								repfn.FnUpdateTestStepResHTML("Verify Statement Dropdown is clicked for previous statement date ","Statement Dropdown is clicked:"+text,"PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Statement Dropdown is clicked for previous statement date ","Statement Dropdown is not clicked:","FAIL",runManagerInfoObj);
								blnFlag=false;
							}

							if(cnf.FnExplicitWait("XPATH", mbo.StatementSummaryTitle,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Statement Title is present or not","Statement Title is present ","PASS",runManagerInfoObj);

								WebElement SummaryTitle=driver.findElement(By.xpath(mbo.StatementSummaryTitle));
								String title=SummaryTitle.getText();
								if(title.equals("Statement Summary")){
									repfn.FnUpdateTestStepResHTML("Verify Statement Title displayed is 'Statement Summary' ","Statement Title is displayed as:"+title,"PASS",runManagerInfoObj);
									blnFlag=true;
								}else{
									repfn.FnUpdateTestStepResHTML("Verify Statement Title displayed is 'Statement Summary' ","Statement Title is not displayed as:"+title,"FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}else{
								repfn.FnUpdateTestStepResHTML("Verify Statement Title is present or not","Statement Title is not present","FAIL",runManagerInfoObj);
								blnFlag=false;
							}


							if(cnf.FnExplicitWait("XPATH", mbo.CurrentStatementTitle,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Current Statement Title is present or not","Current Statement Title is present","PASS",runManagerInfoObj);

								WebElement CurrentStatementTitle=driver.findElement(By.xpath(mbo.CurrentStatementTitle));

								String title=CurrentStatementTitle.getText();


								if(cnf.isValidFormat("mm/dd/yy",title)){

									repfn.FnUpdateTestStepResHTML("Verify Statement Title displayed in the format 'MM/DD/YY' ","Statement Title is displayed as:"+title,"PASS",runManagerInfoObj);
									blnFlag=true;
								}else{
									repfn.FnUpdateTestStepResHTML("Verify Statement Title displayed is in the format 'MM/DD/YY'","Statement Title is not displayed as:"+title,"FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}else{
								repfn.FnUpdateTestStepResHTML("Verify Statement Title is displayed ","Statement Title is not displayed ","FAIL",runManagerInfoObj);
								blnFlag=false;
							}

							if(cnf.FnExplicitWait("XPATH", mbo.PreviousBalance,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Previous Balance Title is dispalyed or not","Previous Balance Title is displayed","PASS",runManagerInfoObj);
								if(cnf.FnExplicitWait("XPATH", mbo.PreviousBalanceAmount,driver)){

									WebElement PreviousBalanceAmount=driver.findElement(By.xpath(mbo.PreviousBalanceAmount));

									String amount=PreviousBalanceAmount.getText();
									repfn.FnUpdateTestStepResHTML("Verify Previous Balance amount is displayed or not","Previous Balance amount is displayed:"+amount,"PASS",runManagerInfoObj);

									if(cnf.verifyAmountFormat(amount)){

										repfn.FnUpdateTestStepResHTML("Verify Previous Balance amount is displayed in format $X XXX.XX","Previous Balance Amount is displayed as:"+amount,"PASS",runManagerInfoObj);
										blnFlag=true;
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Previous Balance amount is displayed in format $X XXX.XX","Previous Balance Amount is not displayed as per format:"+amount,"FAIL",runManagerInfoObj);
										blnFlag=false;
									}


								}else{
									repfn.FnUpdateTestStepResHTML("Verify Previous Balance amount is displayed or not","Previous Balance Amount is not getting displayed","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}else{
								repfn.FnUpdateTestStepResHTML("Verify Previous Balance Title is present or not","Previous Balance Title is not present","FAIL",runManagerInfoObj);
								blnFlag=false;
							}


							if(cnf.FnExplicitWait("XPATH", mbo.PaymentsReceived,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Payments Received Title is dispalyed or not","Payments Received Title is displayed","PASS",runManagerInfoObj);
								if(cnf.FnExplicitWait("XPATH", mbo.PaymentsReceived,driver)){

									WebElement PaymentsReceivedAmount=driver.findElement(By.xpath(mbo.PaymentsReceivedAmount));

									String amount=PaymentsReceivedAmount.getText();
									repfn.FnUpdateTestStepResHTML("Verify Payments Received  amount is displayed or not","Payments Received  amount is displayed:"+amount,"PASS",runManagerInfoObj);
									/*if(amount!="$0.00"){
							if(amount.contains("-")){
							String amountTemp=amount.substring(1);
							String amountTemp1=amountTemp;

							if(cnf.verifyAmountFormat(amountTemp1)){

								repfn.FnUpdateTestStepResHTML("Verify Payments Received Amount is displayed in format -$X,XXX.XX","Payments Received Amount is displayed as:"+amount,"PASS",runManagerInfoObj);
								blnFlag=true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify Payments Received Amount is displayed in format -$X,XXX.XX","Payments Received Amount is not displayed as per format:"+amount,"FAIL",runManagerInfoObj);
								blnFlag=false;
							}
							}else{
								repfn.FnUpdateTestStepResHTML("Verify Payments Received Amount is displayed in format -$X,XXX.XX","Payments Received Amount is not displayed as per format:"+amount,"FAIL",runManagerInfoObj);
								blnFlag=false;
							}

							}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Payments Received Amount is displayed as per format or not","Payments Received Amount is getting displayed as per format:"+amount,"PASS",runManagerInfoObj);
									blnFlag=true;
								}*/
									if(cnf.verifyAmountFormat(amount)){

										repfn.FnUpdateTestStepResHTML("Verify Payments Received Amount is displayed in format $X,XXX.XX","Payments Received Amount is displayed as:"+amount,"PASS",runManagerInfoObj);
										blnFlag=true;
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Payments Received Amount is displayed in format $X,XXX.XX","Payments Received Amount is not displayed as per format:"+amount,"FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}else{
									repfn.FnUpdateTestStepResHTML("Verify Payments Received Amount is dispalyed or not","Payments Received Amount is not getting displayed","FAIL",runManagerInfoObj);
									blnFlag=false;
								}

							}else{
								repfn.FnUpdateTestStepResHTML("Verify Payments Received Title is present or not","Payments Received is not present","FAIL",runManagerInfoObj);
								blnFlag=false;
							}

							if(cnf.FnExplicitWait("XPATH", mbo.Adjustments,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Adjustments Title is displayed or not","Adjustments Title is displayed","PASS",runManagerInfoObj);
								if(cnf.FnExplicitWait("XPATH", mbo.AdjustmentsAmount,driver)){

									WebElement AdjustmentsAmount=driver.findElement(By.xpath(mbo.AdjustmentsAmount));

									String amount=AdjustmentsAmount.getText();
									repfn.FnUpdateTestStepResHTML("Verify Adjustments amount is displayed or not","Adjustments amount is displayed:"+amount,"PASS",runManagerInfoObj);

									if(amount!=("$0.00")){
										/*String amountTemp[]=amount.split("-");
							String amountTemp1=amountTemp[0];*/

										if(cnf.verifyAmountFormat(amount)){

											repfn.FnUpdateTestStepResHTML("Verify Adjustments Amount is displayed in format $X,XXX.XX","Adjustments Amount is displayed as:"+amount,"PASS",runManagerInfoObj);
											blnFlag=true;
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify Adjustments Amount is displayed in format $X,XXX.XX","Adjustments Amount is not displayed as per format:"+amount,"FAIL",runManagerInfoObj);
											blnFlag=false;
										}
									}else{
										repfn.FnUpdateTestStepResHTML("Verify Adjustments Amount is displayed in format if zero :$0.00","Adjustments Amount is  displayed as per format:"+amount,"FAIL",runManagerInfoObj);
										blnFlag=false;
									}


								}else{
									repfn.FnUpdateTestStepResHTML("Verify Adjustments Amount is displayed or not","Adjustments Amount is not getting displayed","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}else{
								repfn.FnUpdateTestStepResHTML("Verify Adjustments Title is present or not","Adjustments title is not present","FAIL",runManagerInfoObj);
								blnFlag=false;
							}

							if(cnf.FnExplicitWait("XPATH", mbo.SpectrumBusinessServices,driver)){
								repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Services Title is dispalyed or not","Spectrum Business Services Title is displayed","PASS",runManagerInfoObj);

								if(cnf.FnExplicitWait("XPATH", mbo.SpectrumBusinessServicesDuration,driver)){
									repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Services duration is dispalyed or not","Spectrum Business Services duration is displayed","PASS",runManagerInfoObj);
									WebElement duration=driver.findElement(By.xpath(mbo.SpectrumBusinessServicesDuration));
									String dates=duration.getText();
									String dateduration[]=dates.split("-");
									String date1=dateduration[0];
									String date2=dateduration[1];
									if(cnf.isValidFormat("mm/dd/yy",date1) && cnf.isValidFormat("mm/dd/yy",date2)){
										repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Services duration is displayed with date range MM/DD/YY - MM/DD/YY","Spectrum Business Services amount is displayed as per format:"+dates,"PASS",runManagerInfoObj);
										blnFlag=true;	
									}

								}else{
									repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Services duration is displayed with date range MM/DD/YY - MM/DD/YY","Spectrum Business Services amount is not displayed as per format","FAIL",runManagerInfoObj);

									blnFlag=false;
								}

								if(cnf.FnExplicitWait("XPATH", mbo.SpectrumBusinessServicesAmount,driver)){

									WebElement SpectrumBusinessServicesAmount=driver.findElement(By.xpath(mbo.SpectrumBusinessServicesAmount));

									String amount=SpectrumBusinessServicesAmount.getText();
									repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Services Amount is displayed or not","Spectrum Business Services amount is displayed:"+amount,"PASS",runManagerInfoObj);


									if(cnf.verifyAmountFormat(amount)){

										repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Services Amount is displayed in format $X,XXX.XX","Spectrum Business Services Amount is displayed as:"+amount,"PASS",runManagerInfoObj);
										blnFlag=true;
									}
									else{
										repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Services Amount is displayed in format $X,XXX.XX","Spectrum Business Services is not displayed as per format:"+amount,"FAIL",runManagerInfoObj);
										blnFlag=false;
									}
								}else{
									repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Services Amount is dispalyed or not","Spectrum Business Services Amount is not getting displayed","FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}else{
								repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Services Title is dispalyed or not","Spectrum Business Services Title is displayed","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
						}else{
							repfn.FnUpdateTestStepResHTML("Verify Statement Dropdown is clciked or not","Statement Dropdown is not clicked","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}else{
						repfn.FnUpdateTestStepResHTML("Verify Statement Dropdown is clicked or not ","Statement Dropdown not clicked ","FAIL",runManagerInfoObj);
						blnFlag=false;
					}		
				}

				else{
					repfn.FnUpdateTestStepResHTML("Verify Statement Dropdown is present or not","Statement Dropdown is not present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

				if(cnf.FnExplicitWait("XPATH", mbo.DownloadStatementBtn,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Download Statement button is present or not","Download Statement button is present","PASS",runManagerInfoObj);
					blnFlag=true;
				}else{
					repfn.FnUpdateTestStepResHTML("Verify Download Statement button is present or not","Download Statement button is not present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}


			}
			catch (Exception e)

			{
				repfn.FnUpdateTestStepResHTML("Verify if user is navigated to View Statements Page after clicking billing section", "User is not navigated to ViewStatements page", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		public synchronized boolean AutopayEnroll(WebDriver driver,RunManagerInfo runManagerInfoObj){
			try{
				if(cnf.FnExplicitWait("Xpath", mbo.autopay_enrollLink,driver)){
					
					repfn.FnUpdateTestStepResHTML("Verify Whether Autopay Enroll Link is present","Autopay Enroll Link is present","PASS",runManagerInfoObj);
					repfn.FnUpdateTestStepResHTML("Verify  Autopay is not Enrolled so we need to Enroll autopay for this account ","Autopay is not Enrolled so we need to Enroll autopay for this account","PASS",runManagerInfoObj);

					WebElement autopay_enrollLink=driver.findElement(By.xpath(mbo.autopay_enrollLink));
					if(cnf.ElementClick(autopay_enrollLink,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Whether Autopay Enroll Link is clicked","Autopay Enroll Link is clicked","PASS",runManagerInfoObj);
					boolean	blnFlag1=FnAutoPay_UsingCreditCard_Step1(driver,runManagerInfoObj);
					boolean blnFlag2=false;
					if(blnFlag1){
						blnFlag2=FnAutoPay_UsingCreditCard_Step2_Step3(driver,runManagerInfoObj);
					}
					if(blnFlag1 && blnFlag2){
						blnFlag=true;
		          	
						blnFlag=app.FnBilling(driver,runManagerInfoObj);
						blnFlag=FnVerifyViewStatementPage(driver,runManagerInfoObj);
						blnFlag=AutopayIcon_ViewStatementPage(driver,runManagerInfoObj);
					}
					else{
						blnFlag=false;
					}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Whether Autopay Enroll Link is clicked","Autopay Enroll Link is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else if (cnf.FnExplicitWait("Xpath", mbo.autopay_ManageLink,driver)) {
					repfn.FnUpdateTestStepResHTML("Verify Whether Autopay Enroll Link is present Indicates autpay already enrolled","Autopay Enroll Link is present Indicates autpay already enrolled","PASS",runManagerInfoObj);
					
					 blnFlag=app.FnBilling(driver,runManagerInfoObj);
		       	
			         
					 blnFlag=FnVerifyViewStatementPage(driver,runManagerInfoObj);
					//blnFlag=FnVerifyCurrentStatementUI();
					blnFlag=AutopayIcon_ViewStatementPage(driver,runManagerInfoObj);
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Whether Autopay Enroll Link/Manage Auto pay is present","Autopay Enroll Link/Manage Auto pay is not present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			catch (Exception e)
			{
				repfn.FnUpdateTestStepResHTML("Verify Whether Autopay Enroll Link/Manage Auto pay is present","Autopay Enroll Link/Manage Auto pay is not present due to some exception","FAIL",runManagerInfoObj);
				blnFlag=false;

				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		public synchronized boolean FnautoPayEnabledAccount(WebDriver driver,RunManagerInfo runManagerInfoObj) {
		 	try
		 	{
		 		driver.switchTo().frame("iFrameResizer0");
		 		if(cnf.FnExplicitlessWait_untilClickable("XPATH", "//a[@class='pull-left'][contains(.,'Details')]",driver))
		 		{
		 			blnFlag=true;
		 			repfn.FnUpdateTestStepResHTML("Verify if user is able to see details link in pay bill screen", "User is able to see details link in pay bill screen", "PASS",runManagerInfoObj);
		 			WebElement detailsLink=driver.findElement(By.xpath("//a[@class='pull-left'][contains(.,'Details')]"));
		 			if(cnf.JSClick(detailsLink,driver))
		 			{
		 				Thread.sleep(5000);
		 				driver.switchTo().defaultContent();
		 				blnFlag=true;
		 				repfn.FnUpdateTestStepResHTML("Verify if user is able to click details in pay bill screen", "User is able to click details link in pay bill screen", "PASS",runManagerInfoObj);
		 				if(cnf.FnExplicitlessWait_untilClickable("XPATH", "//i[@title='Go to auto-pay settings']",driver))
		 				{
		 					blnFlag=true;
		 					repfn.FnUpdateTestStepResHTML("Verify if auto pay icon is present for the user in the View statements page", "Auto pay icon is present for the user in the View statements page", "PASS",runManagerInfoObj);
		 					if(cnf.FnExplicitWait("XPATH", "//div/Strong[contains(.,'Auto-Pay On')]",driver))
		 					{
		 						blnFlag=true;
		 						repfn.FnUpdateTestStepResHTML("Verify if verbiage \"Auto-Pay On\" is present along with auto pay icon", "Verbiage \"Auto-Pay On\" is present along with auto pay icon", "PASS",runManagerInfoObj);
		 						if(cnf.FnExplicitWait("XPATH", "//div[@class='pmt-date-txt ng-scope']",driver))
		 						{
		 							blnFlag=true;
		 							repfn.FnUpdateTestStepResHTML("Verify if verbiage \"Next Payment Scheduled\" is present along with auto pay icon", "Verbiage \"Next Payment Scheduled\" is present along with auto pay icon", "PASS",runManagerInfoObj);	
		 						}
		 						else
		 						{
		 							blnFlag=true;
		 							repfn.FnUpdateTestStepResHTML("Verify if verbiage \"Next Payment Scheduled\" is present along with auto pay icon", "Verbiage \"Next Payment Scheduled\" is present along with auto pay icon", "PASS",runManagerInfoObj);
		 						}
		 					}
		 					else
		 					{
		 						blnFlag=false;
		 						repfn.FnUpdateTestStepResHTML("Verify if verbiage \"Auto-Pay On\" is present along with auto pay icon", "Verbiage \"Auto-Pay On\" is not present along with auto pay icon", "FAIL",runManagerInfoObj);
		 					}
		 				}
		 				else
		 				{
		 					blnFlag=false;
		 					repfn.FnUpdateTestStepResHTML("Verify if auto pay icon is present for the user in the View statements page", "Auto pay icon is not present for the user in the View statements page", "FAIL",runManagerInfoObj);
		 				}
		 			}
		 			else
		 			{
		 				blnFlag=false;
		 				repfn.FnUpdateTestStepResHTML("Verify if user is able to click details in pay bill screen", "User is not able to click details link in pay bill screen", "PASS",runManagerInfoObj);
		 			}

		 		}
		 		else
		 		{
		 			blnFlag=false;
		 			repfn.FnUpdateTestStepResHTML("Verifying if the Auto-Pay icon is displayed in the View statements screen", "Auto-Pay icon is not displayed in the View statements screen due to some exception", "FAIL",runManagerInfoObj);
		 		}
		 	}
		 	catch(Exception e)
		 	{
		 		blnFlag=false;
		 		repfn.FnUpdateTestStepResHTML("Verify if autopay is enabled for the user", "Autopay is not enabled for the user due to some exception", "FAIL",runManagerInfoObj);
		 		System.err.println("Message : "+e.getMessage());
		 		System.err.println("Cause : "+e.getCause());
		 	}
		 	m1.put("STEPSTATUS", blnFlag);
		 	return blnFlag;
		 } 
		public synchronized boolean FnVerifyToolTip(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{

			try{

				if(cnf.FnExplicitWait("XPATH", mbo.ViewStatements_ToolTip,driver)){			
					List<WebElement> PayBill_OtherPaymentMethods=driver.findElements(By.xpath(mbo.ViewStatements_ToolTip));
					if(PayBill_OtherPaymentMethods.size() > 0){
						if(cnf.FnExplicitWait("XPATH", mbo.Description,driver)){
							List<WebElement> Description=driver.findElements(By.xpath(mbo.Description));

							for(int i=0; i<PayBill_OtherPaymentMethods.size(); i++){
								repfn.FnUpdateTestStepResHTML("Verify Tool tip icon is displayed for Service",
										"Tool tip icon is displayed for Service: "+Description.get(i).getText(),"PASS",runManagerInfoObj);
								blnFlag=true;
							}

						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Service Description is displayed","Service Description is not displayed","FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Tool tip icon is displayed","Tool tip icon is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Tool tip icon is displayed","Tool tip icon is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}

			catch (Exception e)
			{
				repfn.FnUpdateTestStepResHTML("Verify if User is able to verify Tool tip icon on View Statements page", "User is not able to verify Tool tip icon on View Statements page due to some exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;


		}
		public synchronized boolean Fn_ViewStatements_UniversalToolbar(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{
			boolean blnFlag=false;
			try{
				//Statement Selector
				if(cnf.FnExplicitWait("Xpath", mbo.ViewStatementDefaultDropDown,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of \"Statement Selector\" in View Statement Page ","\"Statement Selector\" in View Statement Page is present","PASS",runManagerInfoObj);
					blnFlag=true;			
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify the presence of \"Statement Selector\" in View Statement Page ","\"Statement Selector\" in View Statement Page is not present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				//Download Statement Button
				if(cnf.FnExplicitWait("Xpath", mbo.DownloadStatementBtn,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of \"Download Statement\" button in View Statement Page ","\"Download Statement\" button in View Statement Page is present","PASS",runManagerInfoObj);
					blnFlag=true;			
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify the presence of \"Download Statement\" button in View Statement Page ","\"Download Statement\" button in View Statement Page is not present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				//Export Call Log Button
				if(cnf.FnExplicitWait("Xpath", mbo.ExportCallLogButton,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of \"Export Call Log\" button in View Statement Page ","\"Export Call Log\" button in View Statement Page is present","PASS",runManagerInfoObj);
					blnFlag=true;			
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify the presence of \"Export Call Log\" button in View Statement Page ","\"Export Call Log\" button in View Statement Page is not present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}

			catch (Exception e)
			{
				repfn.FnUpdateTestStepResHTML("Verify the presence of Universal Toolbar in View Statements Page","Universal Toolbar in View Statements Page is not present due to some exception","FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		public synchronized boolean Fn_ViewStatements(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{
			boolean blnFlag=false;
			try{

				if(cnf.FnExplicitWait("Xpath", mbo.Ovw_ViewStatement,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of View Statements link in Overview page ","View Statements link in Overview page is present","PASS",runManagerInfoObj);


					WebElement ViewStatement=driver.findElement(By.xpath(mbo.Ovw_ViewStatement)); 

					if(cnf.JSClick(ViewStatement,driver))
					{
						repfn.FnUpdateTestStepResHTML("Verify View Statement link is clicked ","View Statement link is clicked","PASS",runManagerInfoObj);
						if(cnf.FnExplicitWait("Xpath",mbo.ViewStatement_Screen,driver))
						{
							repfn.FnUpdateTestStepResHTML("Verify if user is taken to View Statement screen", "User is in View Statement screen", "PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else
						{
							repfn.FnUpdateTestStepResHTML("Verify if user is taken to View Statement screen", "User is not in View Statement screen", "FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify View Statement link is clicked ","View Statement link is not clicked","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify the presence of View Statements link in Overview page and clicked","View Statements link in Overview page is not present and not clicked","FAIL",runManagerInfoObj);
					blnFlag=false;
				}


			}

			catch (Exception e)

			{
				repfn.FnUpdateTestStepResHTML("Verify View Statements link in Overview page is displayed and clicked","View Statements link in Overview page is not displayed and clicked due to some exception","FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		public synchronized boolean Fn_ViewStatements_DefaultView(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{
			boolean blnFlag=false;
			try{

				if(cnf.FnExplicitWait("Xpath", mbo.ViewStatementDefaultDropDown,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Select Statement dropdown in Overview page ","Select Statement dropdown in Overview page is present","PASS",runManagerInfoObj);
					WebElement DefaultStatement=driver.findElement(By.xpath(mbo.ViewStatementDefaultDropDown));

					if((DefaultStatement.getText()).contains("Current Statement"))
					{
						repfn.FnUpdateTestStepResHTML("Verify Current Statement is displayed ","Current Statement is displayed","PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else
					{
						repfn.FnUpdateTestStepResHTML("Verify Current Statement is displayed ","Current Statement is not displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Select Statement dropdown in Overview page","Select Statement dropdown in Overview page is not present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}


			}

			catch (Exception e)

			{
				repfn.FnUpdateTestStepResHTML("Verify the presence of Current Statement in View Statement page ","Current Statement in View Statement page is not present due to some exception","FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		public synchronized boolean Fn_ChargeDetails_SpectrumInet_AmountDetails(WebDriver driver,RunManagerInfo runManagerInfoObj){
			try{
				
				if(cnf.isElementExist(By.xpath(mbo.ChargeDetails_SpecInet),driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Spectrum Internet section in Charge Details section ","Spectrum Internet section is present in Charge Details section","PASS",runManagerInfoObj);
			        blnFlag=true;
			       
			          if(cnf.isElementExist(By.xpath(mbo.SpectrumInet_Description),driver))
			          {
			         	repfn.FnUpdateTestStepResHTML("Verify the presence of Description column in Spectrum Internet section ","Description column is present in Spectrum Internet section","PASS",runManagerInfoObj);
			            blnFlag=true;
			           }
				        else
				        {
			        	repfn.FnUpdateTestStepResHTML("Verify the presence of Description column in Spectrum Internet section ","Description column is not present in Spectrum Internet section","FAIL",runManagerInfoObj);
			            blnFlag=true;
			        }
			        if(cnf.isElementExist(By.xpath(mbo.SpectrumInet_Amount),driver))
			        {
			          	repfn.FnUpdateTestStepResHTML("Verify the presence of Amount column in Spectrum Internet section ","Amount column is present in Spectrum Internet section","PASS",runManagerInfoObj);
			            blnFlag=true;
			        }
			        else
			        {
			        	repfn.FnUpdateTestStepResHTML("Verify the presence of Amount column in Spectrum Internet section ","Amount column is not present in Spectrum Internet section","FAIL",runManagerInfoObj);
			            blnFlag=true;
			        }
			     
			      List<WebElement> Desc=driver.findElements(By.xpath(mbo.SpectrumInet_DescripVal));
			      for(int y=0;y<Desc.size();y++)
			       {
			    	   
			    	  repfn.FnUpdateTestStepResHTML("Verify the presence of Description value in Spectrum Internet section  for each sub section","Description Value is present in Spectrum Internet section  for each sub section"+" "+Desc.get(y).getText().toString(),"PASS",runManagerInfoObj);
			          blnFlag=true;
			      }
			   
			      
			      List<WebElement> amt=driver.findElements(By.xpath(mbo.SpectrumInet_AmountVal));
			      for(int u=0;u<amt.size();u++)
			       {
			    	   
			    	  repfn.FnUpdateTestStepResHTML("Verify the presence of Amount value in Spectrum Internet section   for each sub section","Amount present in Spectrum Internet section  for each sub section"+" "+amt.get(u).getText().toString(),"PASS",runManagerInfoObj);
			          blnFlag=true;
			      }
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Spectrum Internet section in Charge Details section ","Spectrum Internet section is not present in Charge Details section","FAIL",runManagerInfoObj);
			       blnFlag=false;
				}
					
				
				
			}

			catch (Exception e)

			{
				repfn.FnUpdateTestStepResHTML("Verify whether user is in Charge Details section","User is in Charge Details section","FAIL",runManagerInfoObj);


				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}

		public synchronized boolean Fn_ChargeDetails_SpectrumTV_AmountDetails(WebDriver driver,RunManagerInfo runManagerInfoObj){
			try{
			
				
				if(cnf.isElementExist(By.xpath(mbo.ChargeDetails_SpecTV),driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Spectrum TV section in Charge Details section ","Spectrum TV section is present in Charge Details section","PASS",runManagerInfoObj);
		        blnFlag=true;
		        
		          if(cnf.isElementExist(By.xpath(mbo.SpectrumTV_Description),driver))
		          {
			         	repfn.FnUpdateTestStepResHTML("Verify the presence of Description column in Spectrum TV section ","Description column is present in Spectrum TV section","PASS",runManagerInfoObj);
			            blnFlag=true;
		           }
				        else
				        {
			        	repfn.FnUpdateTestStepResHTML("Verify the presence of Description column in Spectrum TV section ","Description column is not present in Spectrum TV section","FAIL",runManagerInfoObj);
			            blnFlag=true;
			        }
		        if(cnf.isElementExist(By.xpath(mbo.SpectrumTV_Amount),driver))
		        {
		          	repfn.FnUpdateTestStepResHTML("Verify the presence of Amount column in Spectrum TV section ","Amount column is present in Spectrum TV section","PASS",runManagerInfoObj);
		            blnFlag=true;
		        }
		        else
		        {
		        	repfn.FnUpdateTestStepResHTML("Verify the presence of Amount column in Spectrum TV section ","Amount column is not present in Spectrum TV section","FAIL",runManagerInfoObj);
		            blnFlag=true;
		        }
		      List<WebElement> Dates=driver.findElements(By.xpath(mbo.Spectrum_DateVal));
		      for(int x=0;x<Dates.size();x++)
		      {
		    	  repfn.FnUpdateTestStepResHTML("Verify the presence of Date value in Spectrum TV section ","Date Value is present in Spectrum TV section"+" "+Dates.get(x).getText().toString(),"PASS",runManagerInfoObj);
		          blnFlag=true;
		      }
		      List<WebElement> Desc=driver.findElements(By.xpath(mbo.Spectrum_DescripVal));
		      for(int y=0;y<Desc.size();y++)
		       {
		    	   
		    	  repfn.FnUpdateTestStepResHTML("Verify the presence of Description value in Spectrum TV section  for each sub section ","Description Value is present in Spectrum TV section  for each sub section"+" "+Desc.get(y).getText().toString(),"PASS",runManagerInfoObj);
		          blnFlag=true;
		      }
		      
		      List<WebElement> amt=driver.findElements(By.xpath(mbo.Spectrum_AmountVal));
		      for(int u=0;u<amt.size();u++)
		       {
		    	   
		    	  repfn.FnUpdateTestStepResHTML("Verify the presence of Amount value in Spectrum TV section  for each sub section","Amount present in Spectrum TV section  for each sub section"+" "+amt.get(u).getText().toString(),"PASS",runManagerInfoObj);
		          blnFlag=true;
		      }
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Spectrum TV section in Charge Details section ","Spectrum TV section is not present in Charge Details section","FAIL",runManagerInfoObj);
		       blnFlag=false;
				}
				
				
			}

			catch (Exception e)

			{
				repfn.FnUpdateTestStepResHTML("Verify whether user is in Charge Details section","User is in Charge Details section","FAIL",runManagerInfoObj);


				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}




		public synchronized boolean Fn_ChargeDetails_TotalAmountDetails(WebDriver driver,RunManagerInfo runManagerInfoObj){
			try{
			
				
				if(cnf.isElementExist(By.xpath(mbo.ChargeDetailTotalAmountLabel),driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify User verifies the Total for Acct.# at the bottom of the view bill screen "," User verifies the Total for Acct.# is displayed at the bottom of the view bill screenn","PASS",runManagerInfoObj);
		        blnFlag=true;
		        
		          if(cnf.isElementExist(By.xpath(mbo.ChargeDetailTotalAmount),driver))
		          {
			         	repfn.FnUpdateTestStepResHTML("Verify The total amount  is displayed for all of the Lines of Business the user is subscribed to ","The total amount  is displayed for all of the Lines of Business the user is subscribed to","PASS",runManagerInfoObj);
			            blnFlag=true;
		           }
				        else
				        {
			        	repfn.FnUpdateTestStepResHTML("Verify The total amount  is displayed for all of the Lines of Business the user is subscribed to ","The total amount  is not  displayed for all of the Lines of Business the user is subscribed to","FAIL",runManagerInfoObj);
			            blnFlag=true;
			        }
				}
		        
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify User verifies the Total for Acct.# at the bottom of the view bill screen "," User verifies the Total for Acct.# is not displayed at the bottom of the view bill screenn","FAIL",runManagerInfoObj);
		       blnFlag=false;
				}
				
				
			}

			catch (Exception e)

			{
				repfn.FnUpdateTestStepResHTML("Verify User verifies the Total for Acct.# at the bottom of the view bill screen "," User verifies the Total for Acct.# is not displayed at the bottom of the view bill screenn","FAIL",runManagerInfoObj);
		    

				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}



		public synchronized boolean Fn_ChargeDetails_SpectrumPhone_AmountDetails(WebDriver driver,RunManagerInfo runManagerInfoObj){
			try{
			
				if(cnf.isElementExist(By.xpath(mbo.ChargeDetails_SpecPhone),driver))
			//	if(cnf.isElementExist(By.xpath(mbo.ChargeDetails_SpecPhone)))
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Spectrum Phone section in Charge Details section ","Spectrum Phone section is present in Charge Details section","PASS",runManagerInfoObj);
		        blnFlag=true;
		       
		          if(cnf.isElementExist(By.xpath(mbo.SpectrumPhone_Description),driver))
		          {
			         	repfn.FnUpdateTestStepResHTML("Verify the presence of Description column in Spectrum Phone section ","Description column is present in Spectrum Phone section","PASS",runManagerInfoObj);
			            blnFlag=true;
		           }
				        else
				        {
			        	repfn.FnUpdateTestStepResHTML("Verify the presence of Description column in Spectrum Phone section ","Description column is not present in Spectrum Phone section","FAIL",runManagerInfoObj);
			            blnFlag=true;
			        }
		        if(cnf.isElementExist(By.xpath(mbo.SpectrumPhone_Amount),driver))
		        {
		          	repfn.FnUpdateTestStepResHTML("Verify the presence of Amount column in Spectrum Phone section ","Amount column is present in Spectrum Phone section","PASS",runManagerInfoObj);
		            blnFlag=true;
		        }
		        else
		        {
		        	repfn.FnUpdateTestStepResHTML("Verify the presence of Amount column in Spectrum Phone section ","Amount column is not present in Spectrum Phone section","FAIL",runManagerInfoObj);
		            blnFlag=true;
		        }
		     
		      List<WebElement> Desc=driver.findElements(By.xpath(mbo.SpectrumPhone_DescripVal));
		      for(int y=0;y<Desc.size();y++)
		       {
		    	   
		    	  repfn.FnUpdateTestStepResHTML("Verify the presence of Description value in Spectrum Phone section ","Description Value is present in Spectrum Phone section"+" "+Desc.get(y).getText().toString(),"PASS",runManagerInfoObj);
		          blnFlag=true;
		      }
		      
		      List<WebElement> amt=driver.findElements(By.xpath(mbo.SpectrumPhone_AmountVal));
		      for(int u=0;u<amt.size();u++)
		       {
		    	   
		    	  repfn.FnUpdateTestStepResHTML("Verify the presence of Amount value in Spectrum Phone section ","Amount present in Spectrum Phone section"+" "+amt.get(u).getText().toString(),"PASS",runManagerInfoObj);
		          blnFlag=true;
		      }
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Spectrum Phone section in Charge Details section ","Spectrum Phone section is not present in Charge Details section","FAIL",runManagerInfoObj);
		       blnFlag=false;
				}
				
				
			}

			catch (Exception e)

			{
				repfn.FnUpdateTestStepResHTML("Verify whether user is in Charge Details section","User is in Charge Details section","FAIL",runManagerInfoObj);


				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}


		public synchronized boolean Fn_ChargeDetails_SubSection_DoubleSubscription(WebDriver driver,RunManagerInfo runManagerInfoObj){
			try{

				if(cnf.FnExplicitWait("XPATH",mbo.ChargeDetails_SpecInet,driver) && cnf.FnExplicitWait("XPATH",mbo.ChargeDetails_SpecTV,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Spectrum Internet and  Spectrum TV Section in Charge Details section ","Spectrum Internet and Spectrum TV  is present in Charge Details section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else if (cnf.FnExplicitWait("XPATH",mbo.ChargeDetails_SpecTV,driver) && cnf.FnExplicitWait("XPATH",mbo.ChargeDetails_SpecPhone,driver)){
					repfn.FnUpdateTestStepResHTML("Verify the presence of Spectrum TV and Spectrum Phone section in Charge Details section ","Spectrum TV and  Spectrum Phone is present in Charge Details section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else if(cnf.FnExplicitWait("XPATH",mbo.ChargeDetails_SpecInet,driver) && cnf.FnExplicitWait("XPATH",mbo.ChargeDetails_SpecPhone,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Spectrum Internet and  Spectrum Phone in Charge Details section ","Spectrum Internet and  Spectrum Phone is  present in Charge Details section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Spectrum Internet or Spectrum TV or Spectrum Phone in Charge Details section ","Spectrum Internet or Spectrum TV or Spectrum Phone is not present in Charge Details section ","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

			}

			catch (Exception e)

			{
				repfn.FnUpdateTestStepResHTML("Verify the presence of Spectrum Internet or Spectrum TV or Spectrum Phone in Charge Details section ","Spectrum Internet or Spectrum TV or Spectrum Phone is not present in Charge Details section due to some exception","FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}

		public synchronized boolean Fn_ChargeDetails_SubSection_SingleSubscription(WebDriver driver,RunManagerInfo runManagerInfoObj){
			try{

				if(cnf.FnExplicitWait("XPATH",mbo.ChargeDetails_SpecInet,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Spectrum Internet in Charge Details section ","Spectrum Internet is present in Charge Details section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else if (cnf.FnExplicitWait("XPATH",mbo.ChargeDetails_SpecTV,driver)) {
					repfn.FnUpdateTestStepResHTML("Verify the presence of  Spectrum TV  section in Charge Details section "," Spectrum TV is present in Charge Details section","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else if(cnf.FnExplicitWait("XPATH",mbo.ChargeDetails_SpecPhone,driver)){
					repfn.FnUpdateTestStepResHTML("Verify the presence of Spectrum Phone section in Charge Details section ","Spectrum Phone is present in Charge Details section","PASS",runManagerInfoObj);
					blnFlag=true;	
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify the presence of Spectrum Internet or Spectrum TV or Spectrum Phone in Charge Details section ","Spectrum Internet or Spectrum TV or Spectrum Phone is not present in Charge Details section","FAIL",runManagerInfoObj);
					blnFlag=false;
				}

			}

			catch (Exception e)

			{
				repfn.FnUpdateTestStepResHTML("Verify the presence of Spectrum Internet or Spectrum TV or Spectrum Phone in Charge Details section ","Spectrum Internet or Spectrum TV or Spectrum Phone is not present in Charge Details section due to some exception","FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}


		public synchronized boolean FnLineOfBusiness(WebDriver driver,RunManagerInfo runManagerInfoObj) {
			 try
			 {
				 Thread.sleep(10000);
				 String spectrumInternetText=null;
				 String spectrumTVText=null;
				 String spectrumPhoneText=null;
				 int spectrumInternetRowNo = 0;
				 int spectrumTVRowNo = 0;
				 int spectrumPhoneRowNo = 0;
				 List<WebElement> spectrumInternet=driver.findElements(By.xpath("//div[@ng-repeat='charge in model.chargeDetails.internetCharges']"));
				 System.out.println("====cchhch"+spectrumInternet.get(1).getText());
				 System.out.println("====cchhch"+spectrumInternet.get(3).getText());
				List<WebElement> helpIconsSI=driver.findElements(By.xpath("(//div[@ng-repeat='charge in model.chargeDetails.internetCharges']/*/div[@class='hidden-xs hidden-sm col-md-1']/*/i[@class='icon icon--small icon--med-blue sb_ic_circle_info_f'])"));
				List<WebElement> checkSpectrumInternetDescriptionList=driver.findElements(By.xpath("//div[@ng-repeat='charge in model.chargeDetails.internetCharges']/*/div[@class='col-xs-8 col-sm-8 col-md-5 sb-billing-column ng-binding']")); 
				if(helpIconsSI.size()>0)
				 {
					 for(WebElement listclick:helpIconsSI)
					 {
						 if(cnf.JSClick(listclick,driver))
						 {
							 Thread.sleep(5000);
							 WebElement modalTitle=driver.findElement(By.id("modalTitle"));
							 spectrumInternetText=modalTitle.getText();
							 WebElement okButton=driver.findElement(By.xpath("//button[@class='sb-btn sb-btn--primary pull-right ng-binding ng-scope']"));
							 if(cnf.JSClick(okButton,driver))
							 {
								 Thread.sleep(2000);
								 break;
							 }
						 }
					 }
					 
				 }
				 for(int i=0;i<checkSpectrumInternetDescriptionList.size();i++)
				 {
					 if(spectrumInternetText!=null)
					 {

					 if(spectrumInternetText.contains(checkSpectrumInternetDescriptionList.get(i).getText()))
					 {
						 spectrumInternetRowNo=i;
					 }
					 }
				 }
				 List<WebElement> helpIconsSTV=driver.findElements(By.xpath("(//div[@ng-repeat='charge in model.chargeDetails.tvCharges']/*/div[@class='hidden-xs hidden-sm col-md-1']/*/i[@class='icon icon--small icon--med-blue sb_ic_circle_info_f'])"));
					List<WebElement> checkSpectrumInternetDescriptionListSTV=driver.findElements(By.xpath("//div[@ng-repeat='charge in model.chargeDetails.tvCharges']/*/div[@class='col-xs-8 col-sm-8 col-md-5 sb-billing-column ng-binding']")); 
					if(helpIconsSTV.size()>0)
					 {
						 for(WebElement listclick:helpIconsSTV)
						 {
							 if(cnf.JSClick(listclick,driver))
							 {
								 Thread.sleep(5000);
								 WebElement modalTitle=driver.findElement(By.id("modalTitle"));
								 spectrumTVText=modalTitle.getText();
								 WebElement okButton=driver.findElement(By.xpath("//button[@class='sb-btn sb-btn--primary pull-right ng-binding ng-scope']"));
								 if(cnf.JSClick(okButton,driver))
								 {
									 Thread.sleep(2000);
									 break;
								 }
							 }
						 }
						 
					 }
					 for(int i=0;i<checkSpectrumInternetDescriptionListSTV.size();i++)
					 {
						 if(spectrumTVText!=null)
						 {
							 if(spectrumTVText.contains(checkSpectrumInternetDescriptionListSTV.get(i).getText()))
							 {
								 spectrumTVRowNo=i;
							 }
						 }
						}
					 List<WebElement> helpIconsSP=driver.findElements(By.xpath("(//div[@ng-repeat='charge in model.chargeDetails.phoneCharges']/*/div[@class='hidden-xs hidden-sm col-md-1']/*/i[@class='icon icon--small icon--med-blue sb_ic_circle_info_f'])"));
						List<WebElement> checkSpectrumInternetDescriptionListSP=driver.findElements(By.xpath("//div[@ng-repeat='charge in model.chargeDetails.phoneCharges']/*/div[@class='col-xs-8 col-sm-8 col-md-5 sb-billing-column ng-binding']")); 
						if(helpIconsSP.size()>0)
						 {
							 for(WebElement listclick:helpIconsSP)
							 {
								 if(cnf.JSClick(listclick,driver))
								 {
									 Thread.sleep(5000);
									 WebElement modalTitle=driver.findElement(By.id("modalTitle"));
									 spectrumPhoneText=modalTitle.getText();
									 WebElement okButton=driver.findElement(By.xpath("//button[@class='sb-btn sb-btn--primary pull-right ng-binding ng-scope']"));
									 if(cnf.JSClick(okButton,driver))
									 {
										 Thread.sleep(2000);
										 break;
									 }
								 }
							 }
							 
						 }
						 for(int i=0;i<checkSpectrumInternetDescriptionListSP.size();i++)
						 {
							 if(spectrumPhoneText!=null)
							 {
								 if(spectrumPhoneText.contains(checkSpectrumInternetDescriptionListSP.get(i).getText()))
								 {
									 spectrumPhoneRowNo=i;
								 }
							 }
							}
				 //for(int i=1;i<=spectrumInternet.size();i++)
				 //{
					 WebElement checkTaxesAndFeesHeaderDesc=driver.findElement(By.xpath(mbo.taxesAndFeesHeader));
					 WebElement checkSpectrumInternetInfoIcon = null;
					 if(spectrumInternetRowNo>0)
					 {
						 checkSpectrumInternetInfoIcon=driver.findElement(By.xpath(mbo.spectrumInternetHelp));
					
					 }
					 else
					 {
						 spectrumInternetRowNo=1;
					 }
					 WebElement checkSpectrumInternetDateFormat=driver.findElement(By.xpath(mbo.spectrumInternetDate+spectrumInternetRowNo+"]"));
					 WebElement checkSpectrumInternetDescription=driver.findElement(By.xpath(mbo.spectrumInternetDesc+spectrumInternetRowNo+"]"));
					 WebElement checkSpectrumInternetAmount=driver.findElement(By.xpath(mbo.spectrumInternetAmount+spectrumInternetRowNo+"]"));
					 WebElement checkSpectrumTVInfoIcon = null;
					 if(spectrumTVRowNo>0)
					 {
						 checkSpectrumTVInfoIcon=driver.findElement(By.xpath(mbo.spectrumTVHelp));
					
					 }
					 else
					 {
						 spectrumTVRowNo=1;
					 }
					 WebElement checkSpectrumTVDateFormat=driver.findElement(By.xpath(mbo.spectrumTVDate+spectrumTVRowNo+"]"));
					 WebElement checkSpectrumTVDescription=driver.findElement(By.xpath(mbo.spectrumTVDesc+spectrumTVRowNo+"]"));
					 WebElement checkSpectrumTVAmount=driver.findElement(By.xpath(mbo.spectrumTVAmount+spectrumTVRowNo+"]"));
					 WebElement checkSpectrumPhoneInfoIcon = null;
					 if(spectrumPhoneRowNo>0)
					 {
						 checkSpectrumPhoneInfoIcon=driver.findElement(By.xpath(mbo.spectrumPhoneHelp));
					
					 }
					 else
					 {
						 spectrumPhoneRowNo=1;
					 }
					 WebElement checkSpectrumPhoneDateFormat=driver.findElement(By.xpath(mbo.spectrumPhoneDate+spectrumPhoneRowNo+"]"));
					 WebElement checkSpectrumPhoneDescription=driver.findElement(By.xpath(mbo.spectrumPhoneDesc+spectrumPhoneRowNo+"]"));
					 WebElement checkSpectrumPhoneAmount=driver.findElement(By.xpath(mbo.spectrumPhoneAmount+spectrumPhoneRowNo+"]"));
			
					 if(Pattern.matches("([0-9]{2})\\/([0-9]{2})\\/([0-9]{2})\\s-\\s([0-9]{2})\\/([0-9]{2})\\/([0-9]{2})", checkSpectrumInternetDateFormat.getText().toString()))
					 {
						 blnFlag=true;
						 repfn.FnUpdateTestStepResHTML("Verify if Date range in format \"MM/DD/YY - MM/DD/YY\" for Spectrum Internet is correct", "Date range in format \"MM/DD/YY - MM/DD/YY\" for Spectrum Internet is correct: "+checkSpectrumInternetDateFormat.getText(), "PASS",runManagerInfoObj);
						 if(!checkSpectrumInternetDescription.getText().isEmpty())
						 {
							 blnFlag=true;
							 repfn.FnUpdateTestStepResHTML("Verify if \"Description of service\" for Spectrum Internet  is present", "\"Description of service\" for Spectrum Internet is present: "+checkSpectrumInternetDescription.getText(), "PASS",runManagerInfoObj);
							 if(checkSpectrumInternetInfoIcon!=null && checkSpectrumInternetInfoIcon.isDisplayed())
								{
									blnFlag=true;
									 repfn.FnUpdateTestStepResHTML("Verify if \"Option to learn more about the service\" for Spectrum Internet  is present", "\"Option to learn more about the service\" for Spectrum Internet is present", "PASS",runManagerInfoObj);
							 if(Pattern.matches("(\\$([0-9]{1}||[0-9]{2}||[0-9]{3})\\.[0-9]{2})", checkSpectrumInternetAmount.getText()))	
							 {
								 blnFlag=true;
								 repfn.FnUpdateTestStepResHTML("Verify if \"Amount\" in format \"$XX.XX\" for spectrum Internet is correct", "\"Amount\" format for spectrum Internet is correct: "+checkSpectrumInternetAmount.getText(), "PASS",runManagerInfoObj);
								// break;
							 }
							 else
							 {
								 blnFlag=false;
								 repfn.FnUpdateTestStepResHTML("Verify if \"Amount\" in format for spectrum Internet \"$XX.XX\" is correct", "\"Amount\" format for spectrum Internet is not correct ", "FAIL",runManagerInfoObj);
							 }
								}
								else
								{
									blnFlag=true;
									 repfn.FnUpdateTestStepResHTML("Verify if \"Option to learn more about the service\" for Spectrum Internet  is present", "\"Option to learn more about the service\" for Spectrum Internet is not present for any service", "PASS",runManagerInfoObj);
								}
						 }
						 else
						 {
							 blnFlag=false;
							 repfn.FnUpdateTestStepResHTML("Verify if \"Description of service\" for Spectrum Internet is present", "\"Description of service\" for Spectrum Internet is not present ", "PASS",runManagerInfoObj);

						 }

					 }
					 else
					 {
						 blnFlag=false;
						 repfn.FnUpdateTestStepResHTML("Verify if Date range in format \"MM/DD/YY - MM/DD/YY\" for Spectrum Internet is correct", "Date range in format \"MM/DD/YY - MM/DD/YY\" for Spectrum Internet is not correct", "FAIL",runManagerInfoObj);
					 }
					 if(Pattern.matches("([0-9]{2})\\/([0-9]{2})\\/([0-9]{2})\\s-\\s([0-9]{2})\\/([0-9]{2})\\/([0-9]{2})", checkSpectrumTVDateFormat.getText().toString()))
					 {
						 blnFlag=true;
						 repfn.FnUpdateTestStepResHTML("Verify if Date range in format \"MM/DD/YY - MM/DD/YY\" for Spectrum TV is correct", "Date range in format \"MM/DD/YY - MM/DD/YY\" for Spectrum TV is correct: "+checkSpectrumTVDateFormat.getText(), "PASS",runManagerInfoObj);
						 if(!checkSpectrumTVDescription.getText().isEmpty())
						 {
							 blnFlag=true;
							 repfn.FnUpdateTestStepResHTML("Verify if \"Description of service\" for Spectrum TV  is present", "\"Description of service\" for Spectrum TV is present: "+checkSpectrumTVDescription.getText(), "PASS",runManagerInfoObj);
							 if(checkSpectrumTVInfoIcon!=null && checkSpectrumTVInfoIcon.isDisplayed())
								{
									blnFlag=true;
									 repfn.FnUpdateTestStepResHTML("Verify if \"Option to learn more about the service\" for Spectrum TV  is present", "\"Option to learn more about the service\" for Spectrum TV is present", "PASS",runManagerInfoObj);
							
							 if(Pattern.matches("(\\$([0-9]{1}||[0-9]{2}||[0-9]{3})\\.[0-9]{2})", checkSpectrumTVAmount.getText()))	
							 {
								 blnFlag=true;
								 repfn.FnUpdateTestStepResHTML("Verify if \"Amount\" in format \"$XX.XX\" for Spectrum TV is correct", "\"Amount\" format for Spectrum TV is correct: "+checkSpectrumTVAmount.getText(), "PASS",runManagerInfoObj);
								// break;
							 }
							 else
							 {
								 blnFlag=false;
								 repfn.FnUpdateTestStepResHTML("Verify if \"Amount\" in format for Spectrum TV \"$XX.XX\" is correct", "\"Amount\" format for Spectrum TV is not correct ", "FAIL",runManagerInfoObj);
							 }
								}
							 else
								{
									blnFlag=true;
									 repfn.FnUpdateTestStepResHTML("Verify if \"Option to learn more about the service\" for Spectrum TV  is present", "\"Option to learn more about the service\" for Spectrum TV is not present for any service", "PASS",runManagerInfoObj);
								}
						 }
						 else
						 {
							 blnFlag=false;
							 repfn.FnUpdateTestStepResHTML("Verify if \"Description of service\" for Spectrum TV is present", "\"Description of service\" for Spectrum TV is not present ", "PASS",runManagerInfoObj);

						 }

					 }
					 else
					 {
						 blnFlag=false;
						 repfn.FnUpdateTestStepResHTML("Verify if Date range in format \"MM/DD/YY - MM/DD/YY\" for Spectrum TV is correct", "Date range in format \"MM/DD/YY - MM/DD/YY\" for Spectrum TV is not correct", "FAIL",runManagerInfoObj);
					 }
					 if(Pattern.matches("([0-9]{2})\\/([0-9]{2})\\/([0-9]{2})\\s-\\s([0-9]{2})\\/([0-9]{2})\\/([0-9]{2})", checkSpectrumPhoneDateFormat.getText().toString()))
					 {
						 blnFlag=true;
						 repfn.FnUpdateTestStepResHTML("Verify if Date range in format \"MM/DD/YY - MM/DD/YY\" for Spectrum Phone is correct", "Date range in format \"MM/DD/YY - MM/DD/YY\" for Spectrum Phone is correct: "+checkSpectrumPhoneDateFormat.getText(), "PASS",runManagerInfoObj);
						 if(!checkSpectrumInternetDescription.getText().isEmpty())
						 {
							 blnFlag=true;
							 repfn.FnUpdateTestStepResHTML("Verify if \"Description of service\" for Spectrum Phone  is present", "\"Description of service\" for Spectrum Phone is present: "+checkSpectrumPhoneDescription.getText(), "PASS",runManagerInfoObj);
							 if(checkSpectrumPhoneInfoIcon!=null && checkSpectrumPhoneInfoIcon.isDisplayed())
								{
									blnFlag=true;
									 repfn.FnUpdateTestStepResHTML("Verify if \"Option to learn more about the service\" for Spectrum Internet  is present", "\"Option to learn more about the service\" for Spectrum Phone is present", "PASS",runManagerInfoObj);
							 if(Pattern.matches("(\\$([0-9]{1}||[0-9]{2}||[0-9]{3})\\.[0-9]{2})", checkSpectrumPhoneAmount.getText()))	
							 {
								 blnFlag=true;
								 repfn.FnUpdateTestStepResHTML("Verify if \"Amount\" in format \"$XX.XX\" for spectrum Phone is correct", "\"Amount\" format for spectrum Phone is correct: "+checkSpectrumPhoneAmount.getText(), "PASS",runManagerInfoObj);
								// break;
							 }
							 else
							 {
								 blnFlag=false;
								 repfn.FnUpdateTestStepResHTML("Verify if \"Amount\" in format for spectrum Phone \"$XX.XX\" is correct", "\"Amount\" format for spectrum Phone is not correct ", "FAIL",runManagerInfoObj);
							 }
								}
								else
								{
									blnFlag=true;
									 repfn.FnUpdateTestStepResHTML("Verify if \"Option to learn more about the service\" for Spectrum Phone  is present", "\"Option to learn more about the service\" for Spectrum Phone is not present for any service", "PASS",runManagerInfoObj);
								}
						 }
						 else
						 {
							 blnFlag=false;
							 repfn.FnUpdateTestStepResHTML("Verify if \"Description of service\" for Spectrum Phone is present", "\"Description of service\" for Spectrum Phone is not present ", "PASS",runManagerInfoObj);

						 }

					 }
					 else
					 {
						 blnFlag=false;
						 repfn.FnUpdateTestStepResHTML("Verify if Date range in format \"MM/DD/YY - MM/DD/YY\" for Spectrum Phone is correct", "Date range in format \"MM/DD/YY - MM/DD/YY\" for Spectrum Phone is not correct", "FAIL",runManagerInfoObj);
					 }
				 //}
			 }
			 catch (Exception e)

			 {
				 repfn.FnUpdateTestStepResHTML("Verify if user is able to view Taxes & Fees & Charges section under charge details", "User is not able to view Taxes, Fees & Charges section under charge details due to some exception", "FAIL",runManagerInfoObj);
				 System.err.println("Message : " + e.getMessage());
				 System.err.println("Cause : " + e.getCause());

			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;
		}
		public synchronized boolean FnVerifyStatementScreen(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{

			try{

				if(cnf.FnExplicitWait("XPATH", mbo.ViewStatement_StatementSummary,driver)){			
					WebElement ViewStatement_StatementSummary=driver.findElement(By.xpath(mbo.ViewStatement_StatementSummary));
					if(ViewStatement_StatementSummary.getAttribute("textContent").contains("Statement Summary")){
						repfn.FnUpdateTestStepResHTML("Verify Statement Summary heading displayed is 'Statement Summary' ",
								"Statement Summary heading is displayed as: "+ViewStatement_StatementSummary.getAttribute("textContent"),"PASS",runManagerInfoObj);
						blnFlag=true;
					}
					else{
						repfn.FnUpdateTestStepResHTML("Verify Statement Summary heading is displayed 'Statement Summary'",
								"Statement Summary heading is not displayed 'Statement Summary'","FAIL",runManagerInfoObj);
						blnFlag=false;
					}	
				}			
				else{
					repfn.FnUpdateTestStepResHTML("Verify Statement Summary heading is present or not",
							"Statement Summary heading is not present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}



				if(cnf.FnExplicitWait("XPATH", mbo.StatementSummarySection_CurrentSection,driver)){
					WebElement StatementSummarySection_CurrentSection=driver.findElement(By.xpath(mbo.StatementSummarySection_CurrentSection));
					String title=StatementSummarySection_CurrentSection.getText();
					if(title.contains("Current Statement -")){		  			
						String date[]=title.split(" - ");
						String text1=date[0];
						String Currentdate1=date[1];

						if(cnf.isValidFormat("mm/dd/yy",Currentdate1)&&(text1.equals("Current Statement"))){

							repfn.FnUpdateTestStepResHTML("Verify Current Statement Title displayed is 'Current Statement - MM/DD/YY' ","Current Statement Title is displayed as:"+title,"PASS",runManagerInfoObj);
							blnFlag=true;
						}else{
							repfn.FnUpdateTestStepResHTML("Verify Statement Title displayed is 'Current Statement - MM/DD/YY' ","Current Statement Title is not displayed as:"+title,"FAIL",runManagerInfoObj);
							blnFlag=false;
						}
					}else{
						repfn.FnUpdateTestStepResHTML("Verify Current Statement Title is displayed as Current Statement-","Current Statement Title is not displayed as Current Statement-","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}else{
					repfn.FnUpdateTestStepResHTML("Verify Current Statement Title is present or not","Current Statement Title is not present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}



				if(cnf.FnExplicitWait("XPATH", mbo.StatementSummarySection_PreviousBalance,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Previous Balance Title is displayed or not","Previous Balance Title is displayed","PASS",runManagerInfoObj);
					if(cnf.FnExplicitWait("XPATH", mbo.StatementSummarySection_PreviousBalanceValue,driver)){

						WebElement StatementSummarySection_PreviousBalanceValue=driver.findElement(By.xpath(mbo.StatementSummarySection_PreviousBalanceValue));

						String amount=StatementSummarySection_PreviousBalanceValue.getText();
						repfn.FnUpdateTestStepResHTML("Verify Previous Balance amount is displayed or not","Previous Balance amount is displayed as: "+amount,"PASS",runManagerInfoObj);

						if(Pattern.matches("(\\$([0-9]{1}||[0-9]{2}||[0-9]{3}||[0-9]{4})\\.[0-9]{2})",amount)){

							repfn.FnUpdateTestStepResHTML("Verify Previous Balance amount is displayed in format $X XXX.XX","Previous Balance Amount is displayed as:"+amount,"PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Previous Balance amount is displayed in format $X XXX.XX","Previous Balance Amount is not displayed as per format:"+amount,"FAIL",runManagerInfoObj);
							blnFlag=false;
						}


					}else{
						repfn.FnUpdateTestStepResHTML("Verify Previous Balance amount is displayed or not","Previous Balance Amount is not getting displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}else{
					repfn.FnUpdateTestStepResHTML("Verify Previous Balance Title is displayed or not","Previous Balance Title is not displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}




				if(cnf.FnExplicitWait("XPATH", mbo.StatementSummarySection_PaymentsReceived,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Payments Received Title is displayed or not","Payments Received Title is displayed","PASS",runManagerInfoObj);
					if(cnf.FnExplicitWait("XPATH", mbo.StatementSummarySection_PaymentsReceivedValue,driver)){

						WebElement StatementSummarySection_PaymentsReceivedValue=driver.findElement(By.xpath(mbo.StatementSummarySection_PaymentsReceivedValue));

						String amount=StatementSummarySection_PaymentsReceivedValue.getText(); 
						repfn.FnUpdateTestStepResHTML("Verify Payments Received  amount is displayed or not","Payments Received  amount is displayed as: "+amount,"PASS",runManagerInfoObj);
						if(amount !="$0.00"){
							if(amount.contains(".")){
								String amountTemp=amount.substring(1);
								String amountTemp1=amountTemp;

								if(Pattern.matches("(\\$([0-9]{1}||[0-9]{2}||[0-9]{3}||[0-9]{4})\\.[0-9]{2})",amount)){

									repfn.FnUpdateTestStepResHTML("Verify Payments Received Amount is displayed in format $X,XXX.XX","Payments Received Amount is displayed as:"+amount,"PASS",runManagerInfoObj);
									blnFlag=true;
								}
								else{
									repfn.FnUpdateTestStepResHTML("Verify Payments Received Amount is displayed in format $X,XXX.XX","Payments Received Amount is not displayed as per format:"+amount,"FAIL",runManagerInfoObj);
									blnFlag=false;
								}
							}else{
								repfn.FnUpdateTestStepResHTML("Verify Payments Received Amount is displayed in format $X,XXX.XX","Payments Received Amount is not displayed as per format:"+amount,"FAIL",runManagerInfoObj);
								blnFlag=false;
							}

						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Payments Received Amount is displayed as per format or not","Payments Received Amount is getting displayed as per format:"+amount,"PASS",runManagerInfoObj);
							blnFlag=true;
						}

					}else{
						repfn.FnUpdateTestStepResHTML("Verify Payments Received Amount is dispalyed or not","Payments Received Amount is not getting displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}

				}else{
					repfn.FnUpdateTestStepResHTML("Verify Payments Received Title is present or not","Payments Received is not present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}


				if(cnf.FnExplicitWait("XPATH", mbo.StatementSummarySection_SpectrumBusinessServices,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Services Title is displayed or not","Spectrum Business Services Title is displayed","PASS",runManagerInfoObj);

					if(cnf.FnExplicitWait("XPATH", mbo.StatementSummarySection_PaymentsReceivedValue_DateRange,driver)){
						repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Services duration is displayed or not","Spectrum Business Services duration is displayed","PASS",runManagerInfoObj);
						WebElement StatementSummarySection_PaymentsReceivedValue_DateRange=driver.findElement(By.xpath(mbo.StatementSummarySection_PaymentsReceivedValue_DateRange));
						String dates=StatementSummarySection_PaymentsReceivedValue_DateRange.getText();
						String dateduration[]=dates.split("-");
						String date1=dateduration[0];
						String date2=dateduration[1];
						if(Pattern.matches("([0-9]{2})\\/([0-9]{2})\\/([0-9]{2})\\s-\\s([0-9]{2})\\/([0-9]{2})\\/([0-9]{2})",dates)){
							repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Services duration is displayed with date range MM/DD/YY - MM/DD/YY","Spectrum Business Services amount is displayed as per format:"+dates,"PASS",runManagerInfoObj);
							blnFlag=true;	
						}							
					}else{
						repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Services duration is displayed with date range MM/DD/YY - MM/DD/YY","Spectrum Business Services amount is not displayed as per format","FAIL",runManagerInfoObj);

						blnFlag=false;
					}					

					if(cnf.FnExplicitWait("XPATH", mbo.StatementSummarySection_SpectrumBusinessServicesValue,driver)){						
						WebElement StatementSummarySection_SpectrumBusinessServicesValue=driver.findElement(By.xpath(mbo.StatementSummarySection_SpectrumBusinessServicesValue));						
						String amount=StatementSummarySection_SpectrumBusinessServicesValue.getText();
						repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Services Amount is displayed or not","Spectrum Business Services amount is displayed:"+amount,"PASS",runManagerInfoObj);						

						if(Pattern.matches("(\\$([0-9]{1}||[0-9]{2}||[0-9]{3}||[0-9]{4})\\.[0-9]{2})",amount)){

							repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Services Amount is displayed in format $X,XXX.XX","Spectrum Business Services Amount is displayed as:"+amount,"PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Services Amount is displayed in format $X,XXX.XX","Spectrum Business Services is not displayed as per format:"+amount,"FAIL",runManagerInfoObj);
							blnFlag=false;
						}				
					}else{
						repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Services Amount is displayed or not","Spectrum Business Services Amount is not getting displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}else{
					repfn.FnUpdateTestStepResHTML("Verify Spectrum Business Services Title is displayed or not","Spectrum Business Services Title is displayed","FAIL",runManagerInfoObj);
					blnFlag=false;
				}	


				if(cnf.FnExplicitWait("XPATH", mbo.StatementSummarySection_CurrentBalanceDue,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Current Balance Due Title is dispalyed or not","Current Balance Due Title is displayed","PASS",runManagerInfoObj);
					if(cnf.FnExplicitWait("XPATH", mbo.StatementSummarySection_CurrentBalanceDueValue,driver)){

						WebElement CurrentBalanceDueAmount=driver.findElement(By.xpath(mbo.CurrentBalanceDueAmount));

						String amount=CurrentBalanceDueAmount.getText();
						repfn.FnUpdateTestStepResHTML("Verify Current Balance Due Title amount is displayed or not","Current Balance Due amount is displayed:"+amount,"PASS",runManagerInfoObj);

						if(Pattern.matches("(\\$([0-9]{1}||[0-9]{2}||[0-9]{3}||[0-9]{4})\\.[0-9]{2})",amount)){

							repfn.FnUpdateTestStepResHTML("Verify Current Balance Due is displayed in format $X,XXX.XX","Current Balance Due is displayed as:"+amount,"PASS",runManagerInfoObj);
							blnFlag=true;
						}
						else{
							repfn.FnUpdateTestStepResHTML("Verify Current Balance Due amount is displayed in format $X,XXX.XX","Current Balance Due Amount is not displayed as per format:"+amount,"FAIL",runManagerInfoObj);
							blnFlag=false;
						}


					}else{
						repfn.FnUpdateTestStepResHTML("Verify Current Balance Due amount is dispalyed or not","Current Balance Due Amount is not getting displayed","FAIL",runManagerInfoObj);
						blnFlag=false;
					}
				}else{
					repfn.FnUpdateTestStepResHTML("Verify Current Balance Due Title is present or not","Current Balance Due Title is not present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}



				if(cnf.FnExplicitWait("XPATH", mbo.DownloadStatementButton,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Download Statement button is present or not","Download Statement button is present","PASS",runManagerInfoObj);
					blnFlag=true;
				}else{
					repfn.FnUpdateTestStepResHTML("Verify Download Statement button is present or not","Download Statement button is not present","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			catch (Exception e)
			{
				repfn.FnUpdateTestStepResHTML("Verify if User is able to verify UI elements on View Statements page", "User is not able to verify UI elements on View Statements page due to some exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}

		public synchronized boolean FnVerifyUniversalToolbarOptions(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception{
			
			try{
				
				if(cnf.FnExplicitWait("XPATH", mbo.ViewStatements_StatementDropdown,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Statement Selector Drop-down is displayed on View Statements page","Statement Selector Drop-down is displayed on View Statements page","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Statement Selector Drop-down is displayed on View Statements page","Statement Selector Drop-down is not displayed on View Statements page","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.ViewStatements_DownloadStatementButton,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Download Statement button is displayed on View Statements page","Download Statement button is displayed on View Statements page","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Download Statement button is displayed on View Statements page","Download Statement button is not displayed on View Statements page","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
				
				if(cnf.FnExplicitWait("XPATH", mbo.ExportCallLogButton,driver)){
					repfn.FnUpdateTestStepResHTML("Verify Export Call Log button is displayed on View Statements page","Export Call Log button is displayed on View Statements page","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify Export Call Log button is displayed on View Statements page","Export Call Log button is not displayed on View Statements page","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			
			catch (Exception e)
			{
				repfn.FnUpdateTestStepResHTML("Verify if User is able to verify Universal toolbar options on View Statements page", "User is not able to verify Universal toolbar options on View Statements page due to some exception", "FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}
		public synchronized boolean Fn_ChargeDetails_Phone_ExportCallLog_Presence(WebDriver driver,RunManagerInfo runManagerInfoObj){
			boolean blnFlag=false;
			try{
				if(cnf.FnExplicitWait("XPATH",mbo.ViewStatement_ExportCallLog,driver))
				{
					repfn.FnUpdateTestStepResHTML("Verify whether Export call log button is present in View Statement screen","Export call log button is present in View Statement screen","PASS",runManagerInfoObj);
					blnFlag=true;
				}
				else
				{
					repfn.FnUpdateTestStepResHTML("Verify whether Export call log button is present in View Statement screen","Export call log button is not present in View Statement screen","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			catch(Exception e)
			{
				repfn.FnUpdateTestStepResHTML("Verify whether Export Call logs button is displayed in View Statement screen","Export Call logs button is not displayed in View Statement screen due to some exception","FAIL",runManagerInfoObj);
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
				blnFlag=false;
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;
		}

		public synchronized boolean FnAutoPay_UsingCreditCard_Step2_Step3(WebDriver driver,RunManagerInfo runManagerInfoObj) {
			try
			{
				driver.switchTo().frame("iFrameResizer0");
				if(cnf.FnExplicitWait("Xpath", mbo.autopay_Terms_conditionLink,driver))
				{

					repfn.FnUpdateTestStepResHTML("Verify Autopay Terms and condition check box is present","Autopay Terms and condition check box is present","PASS",runManagerInfoObj);
					WebElement autopay_Terms_conditionLink=driver.findElement(By.xpath(mbo.autopay_Terms_conditionLink));
					if(cnf.ElementClick(autopay_Terms_conditionLink,driver))
					{
						Thread.sleep(5000);

						repfn.FnUpdateTestStepResHTML("Verify Autopay Terms and condition check box is clicked","Autopay Terms and condition check box is clicked","PASS",runManagerInfoObj);
						if(cnf.FnExplicitWait("XPATH", mbo.autopaySavebtn,driver))
						{
							Thread.sleep(5000);
							repfn.FnUpdateTestStepResHTML("Verify if  \"Save Auto-Pay\" button is present", " \"Save Auto-Pay\" button is present", "PASS",runManagerInfoObj);
							WebElement saveAutoPay=driver.findElement(By.xpath(mbo.autopaySavebtn));
							if(cnf.ElementClick1(saveAutoPay))
							{
								Thread.sleep(5000);
								repfn.FnUpdateTestStepResHTML("Verify if  \"Save Auto-Pay\" button is clicked", " \"Save Auto-Pay\" button is clicked", "PASS",runManagerInfoObj);

								
								if(cnf.FnExplicitlessWait("XPATH", mbo.payementIssue, driver))
								{
									WebElement paymentIssue=driver.findElement(By.xpath(mbo.payementIssue));
									repfn.FnUpdateTestStepResHTML("Verify AutoPay option get confirmed sucessfully or not", "AutoPay option did not get confirm due to some payement issue as messgae displayed: "+paymentIssue.getText(), "FAIL",runManagerInfoObj);
									blnFlag=false;
								}
								else{
								if(cnf.FnExplicitWait("XPATH", mbo.autopay_ReturntoOverview,driver))
								{

									repfn.FnUpdateTestStepResHTML("Verify if  Return to overview Link  is present", " Return to overview Link is present", "PASS",runManagerInfoObj);
									WebElement autopay_ReturntoOverview=driver.findElement(By.xpath(mbo.autopay_ReturntoOverview));
									if(cnf.ElementClick(autopay_ReturntoOverview,driver))
									{

										repfn.FnUpdateTestStepResHTML("Verify if  Return to overview Link  is  clicked", " Return to overview Link is  clicked", "PASS",runManagerInfoObj);
										Thread.sleep(5000);
										driver.switchTo().defaultContent();
										if(cnf.FnExplicitWait("Xpath", mbo.autopay_ManageLink,driver)){
											repfn.FnUpdateTestStepResHTML("Verify User has reached overview page", " User has reached overview page", "PASS",runManagerInfoObj);
											blnFlag=true;
										}
										else{
											repfn.FnUpdateTestStepResHTML("Verify User has reached overview page", " User has not  reached overview page", "FAIL",runManagerInfoObj);
											blnFlag=false;
										}

									}
									else
									{
										blnFlag=false;
										repfn.FnUpdateTestStepResHTML("Verify if  Return to overview Link  is  clicked", " Return to overview Link is   not clicked", "FAIL",runManagerInfoObj);
									}
								}
								else
								{
									blnFlag=false;
									repfn.FnUpdateTestStepResHTML("Verify if  Return to overview Link  is present", " Return to overview Link is  not present", "FAIL",runManagerInfoObj);
								}
							}
								
							}
							else
							{
								blnFlag=false;
								repfn.FnUpdateTestStepResHTML("Verify if  \"Save Auto-Pay\" button is clicked", " \"Save Auto-Pay\" button is not clicked", "FAIL",runManagerInfoObj);
							}
						}
						else
						{
							blnFlag=false;
							repfn.FnUpdateTestStepResHTML("Verify if  \"Save Auto-Pay\" button is present", " \"Save Auto-Pay\" button is not present", "FAIL",runManagerInfoObj);
						}
					}
					else
					{
						blnFlag=false;
						repfn.FnUpdateTestStepResHTML("Verify Autopay Terms and condition check box is clicked","Autopay Terms and condition check box is not clicked","FAIL",runManagerInfoObj);
					}
				}
				else
				{
					blnFlag=false;
					repfn.FnUpdateTestStepResHTML("Verify Autopay Terms and condition check box is present","Autopay Terms and condition check box is not  present","FAIL",runManagerInfoObj);
				}

				driver.switchTo().defaultContent();
			}
			catch (Exception e)

			{		
				repfn.FnUpdateTestStepResHTML("Verify User has reached overview page", " User has not  reached overview page due to some exception", "FAIL",runManagerInfoObj);
				blnFlag=false;
				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}






		public synchronized boolean FnAutoPay_UsingCreditCard_Step1(WebDriver driver,RunManagerInfo runManagerInfoObj) {
			try
			{
				driver.switchTo().frame("iFrameResizer0");
				if(cnf.FnExplicitlessWait_untilClickable("XPATH", mbo.creditDebitCard,driver))
				{
					blnFlag=true;
					repfn.FnUpdateTestStepResHTML("Verify if user has navigated to pay bill screen","User has navigated to pay bill screen","PASS",runManagerInfoObj);
					WebElement creditOrDebitCard=driver.findElement(By.xpath(mbo.creditDebitCard));
					if(cnf.JSClick(creditOrDebitCard,driver))
					{
						Thread.sleep(5000);
						blnFlag=true;
						repfn.FnUpdateTestStepResHTML("Verify if user has selected the \"Credit/Debit\" card option","User has selected the \"Credit/Debit\" card option","PASS",runManagerInfoObj);
						if(cnf.FnExplicitlessWait_untilClickable("XPATH", mbo.autoPayIdNew,driver))
						{
							WebElement autoPay=driver.findElement(By.xpath(mbo.autoPayIdNew));
							if(cnf.JSClick(autoPay,driver)){
								repfn.FnUpdateTestStepResHTML("Verify if user has clicked the \"Auto-Pay\" payment option","User has  clicked the \"Auto-Pay\" payment option","PASS",runManagerInfoObj);
								Thread.sleep(5000);
								blnFlag=true;
							}
							else{
								repfn.FnUpdateTestStepResHTML("Verify if user has  clicked the \"Auto-Pay\" payment option","User has  not clicked the \"Auto-Pay\" payment option","FAIL",runManagerInfoObj);
								blnFlag=false;
							}
							blnFlag=true;
							repfn.FnUpdateTestStepResHTML("Verify if user has selected the \"Auto-Pay\" payment option","User has selected the \"Auto-Pay\" payment option","PASS",runManagerInfoObj);
							if(cnf.FnExplicitWait("XPATH", mbo.billingCardNumber,driver))
							{

								repfn.FnUpdateTestStepResHTML("Verify if card number field to enter card number is present","Card number field to enter card number is present","PASS",runManagerInfoObj);
								if(blnFlag)
								{
									driver.findElement(By.xpath(mbo.billingCardNumber)).sendKeys("4444444444444448",Keys.TAB);

									repfn.FnUpdateTestStepResHTML("Verify if user has entered the card number","User has entered the card number: "+"4444444444444448","PASS",runManagerInfoObj);
									if(cnf.FnExplicitWait("ID", mbo.billingExpirationDate,driver))
									{

										repfn.FnUpdateTestStepResHTML("Verify if expiration date field to enter expiration date is present","Expiration date field to enter expiration date is present","PASS",runManagerInfoObj);
										if(blnFlag)
										{
											driver.findElement(By.id(mbo.billingExpirationDate)).sendKeys("11/2020",Keys.TAB);

											repfn.FnUpdateTestStepResHTML("Verify if user has entered the expiration date","User has entered the expiration date: "+"11/2020","PASS",runManagerInfoObj);
											if(cnf.FnExplicitlessWait_untilClickable("XPATH", mbo.billingSaveautoPayButton,driver))
											{

												repfn.FnUpdateTestStepResHTML("Verify if  \"Save Auto-Pay\" button is present", " \"Save Auto-Pay\" button is present", "PASS",runManagerInfoObj);
												WebElement saveAutoPay=driver.findElement(By.xpath(mbo.billingSaveautoPayButton));
												if(cnf.JSClick(saveAutoPay,driver))
												{
													blnFlag=true;
													repfn.FnUpdateTestStepResHTML("Verify if  \"Save Auto-Pay\" button is clicked", " \"Save Auto-Pay\" button is clicked", "PASS",runManagerInfoObj);
												}
												else
												{
													blnFlag=false;
													repfn.FnUpdateTestStepResHTML("Verify if  \"Save Auto-Pay\" button is clicked", " \"Save Auto-Pay\" button is not clicked", "FAIL",runManagerInfoObj);
												}
											}
											else
											{
												blnFlag=false;
												repfn.FnUpdateTestStepResHTML("Verify if  \"Save Auto-Pay\" button is present", " \"Save Auto-Pay\" button is not present", "FAIL",runManagerInfoObj);
											}

										}
										else
										{
											blnFlag=false;
											repfn.FnUpdateTestStepResHTML("Verify if user has entered the expiration date","User has not entered the expiration date: "+"11/2020","FAIL",runManagerInfoObj);
										}
									}
									else
									{
										blnFlag=true;
										repfn.FnUpdateTestStepResHTML("Verify if expiration date field to enter expiration date is present","Expiration date field to enter expiration date is not present","FAIL",runManagerInfoObj);
									}	


								}
								else
								{
									blnFlag=false;
									repfn.FnUpdateTestStepResHTML("Verify if user has entered the card number","User has not entered the card number: "+"4444444444444448","FAIL",runManagerInfoObj);
								}
							}
							else
							{
								blnFlag=false;
								repfn.FnUpdateTestStepResHTML("Verify if card number field to enter card number is present","Card number field to enter card number is not present","FAIL",runManagerInfoObj);
							}
						}
						else
						{
							blnFlag=false;
							repfn.FnUpdateTestStepResHTML("Verify if user has selected the \"Auto-Pay\" payment option","User has not selected the \"Auto-Pay\" payment option","FAIL",runManagerInfoObj);
						}
					}
					else
					{
						blnFlag=false;
						repfn.FnUpdateTestStepResHTML("Verify if user has selected the \"Credit/Debit\" card option","User has not selected the \"Credit/Debit\" card option","FAIL",runManagerInfoObj);
					}
				}
				else
				{
					blnFlag=false;
					repfn.FnUpdateTestStepResHTML("Verify if user has navigated to pay bill screen","User has not navigated to pay bill screen","FAIL",runManagerInfoObj);
				}
				
				driver.switchTo().defaultContent();

			}
			catch (Exception e)

			{		
				blnFlag=false;
				repfn.FnUpdateTestStepResHTML("Verify if  \"Save Auto-Pay\" button is present", " \"Save Auto-Pay\" button is not present due to some exception", "FAIL",runManagerInfoObj);

				System.err.println("Message : "+e.getMessage());
				System.err.println("Cause : "+e.getCause());
			}
			m1.put("STEPSTATUS", blnFlag);
			return blnFlag;

		}


		public synchronized boolean AutopayIcon_ViewStatementPage(WebDriver driver,RunManagerInfo runManagerInfoObj){
			try{
				if(cnf.FnExplicitWait("XPATH", mbo.AutoPayOn_NextPayment_Text,driver)){
					WebElement AutoPayOn_NextPayment_Text=driver.findElement(By.xpath(mbo.AutoPayOn_NextPayment_Text));
					repfn.FnUpdateTestStepResHTML("Verify AutoPayON and _NextPayment Text is available","AutoPayON and _NextPayment Text is available"+ AutoPayOn_NextPayment_Text.getText(),"PASS",runManagerInfoObj);
		          if(cnf.FnExplicitWait("Xpath", mbo.AutoPay_Symbol,driver)){
		  			WebElement AutoPay_Symbol=driver.findElement(By.xpath(mbo.AutoPay_Symbol));
		  			cnf.JSClick(AutoPay_Symbol,driver);
		  			Thread.sleep(3000);
		  			repfn.FnUpdateTestStepResHTML("Verify AutoPay Icon is present and clicked","AutoPay Icon is present and clicked","PASS",runManagerInfoObj);
		             
		  			  driver.switchTo().frame("iFrameResizer0");
		  			if(cnf.isElementExist(By.xpath( mbo.AutopayCancelbtn),driver)){
		      			repfn.FnUpdateTestStepResHTML("Verify User is directed to the edit auto pay page","User is directed to the edit auto pay page","PASS",runManagerInfoObj);
		      			blnFlag=true;
		              }
		              else{
		      			repfn.FnUpdateTestStepResHTML("Verify User is directed to the edit auto pay page","User is not directed to the edit auto pay page","FAIL",runManagerInfoObj);
		      			blnFlag=false;
		              }
		  			driver.switchTo().defaultContent();

		          }
		          else{
		  			repfn.FnUpdateTestStepResHTML("Verify AutoPay Icon is present and clicked","AutoPay Icon is not  present and not clicked","FAIL",runManagerInfoObj);
		  			blnFlag=false;
		          }
				}
				else{
					repfn.FnUpdateTestStepResHTML("Verify AutoPayON and _NextPayment Text is available","AutoPayON and _NextPayment Text is not  available","FAIL",runManagerInfoObj);
					blnFlag=false;
				}
			}
			 catch (Exception e)

			 {		
				 repfn.FnUpdateTestStepResHTML("Verify AutoPayON and _NextPayment Text is available","AutoPayON and _NextPayment Text is not  available due to some exception","FAIL",runManagerInfoObj);
					blnFlag=false;
				 System.err.println("Message : "+e.getMessage());
				 System.err.println("Cause : "+e.getCause());
			 }
			 m1.put("STEPSTATUS", blnFlag);
			 return blnFlag;
		}
}
