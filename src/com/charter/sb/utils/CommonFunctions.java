package com.charter.sb.utils;

import org.openqa.selenium.WebDriver.TargetLocator;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.charter.sb.controllers.Initialization;

public class CommonFunctions extends Initialization {

	public static final String FILE_DIR = System.getProperty("user.home")+"\\Downloads";
	public static final String FILE_TEXT_EXT = ".pdf";
	public static final String FILE_TEXT_EXT1 = ".csv";
	public static String fileMessage;
	private static final String CHAR_LIST =  "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private static final int RANDOM_STRING_LENGTH = 4;

	/**
	* Method Name : DeleteCookies
	* Method Description : This method is used clear the cookies of the browser
	* @param None
	* @return Boolean
	* @author Dhivya Durairaj
	* @throws Exception
	*/

	public boolean DeleteCookies(WebDriver driver)
	{
		boolean blnFlag = false;
		try
		{
			driver.manage().deleteAllCookies();
			blnFlag = true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			blnFlag = false;
		}
		return blnFlag;
	}
	
	/**
	 * Function Name : IsElementExsistt Function Description : This Function selects
	 * the specified window (and frame, if specified) and enters text in web
	 * TextBox.
	 * 
	 * @param: strControl - object property, strValue - value to enter text box
	 * @return Boolean
	 * @author Pavan Pushadapu
	 * @throws Exception
	 */
	// WEBDRIVER
	public boolean isElementExist(String strControl, String strValue,WebDriver driver) {
		// SelectWindow(strWindowConstruct);
		boolean blnFlag;
		try {
			if (isElementExist(By.id(strControl),driver)) {
				blnFlag=true;
			} else if (isElementExist(By.name(strControl),driver)) {
				blnFlag=true;
			} else if (isElementExist(By.xpath(strControl),driver)) {
				blnFlag=true;
				
			}else
			{
				blnFlag=false;
			}
			

		} catch (Exception e) {
			String strMessage = "Failed to Type value in text box - "
					+ e.getMessage();
			blnFlag = false;
		}
		return blnFlag;
	}
	
	/**
     * Method Name : isElementExist
     * Method Description : This method is used verify whether an element is exist or not
     * @param strByType and strControl
     * @return Boolean
     * @author Pavan Pushadapu
     * @throws Exception
     */

     public boolean isElementExistOne(String strByType, String strControl,WebDriver driver) {
            // SelectWindow(strWindowConstruct);
            boolean blnFlag;
            try {
                   
                   if(strByType.equalsIgnoreCase("ID"))
                   {
                         if (isElementExist(By.id(strControl),driver)) {
                                blnFlag=true;
                         
                                
                         }else
                         {
                                blnFlag=false;
                         }
                   
                   }else if(strByType.equalsIgnoreCase("XPATH"))
                   {
                         if (isElementExist(By.xpath(strControl),driver)) {
                                blnFlag=true;
                                                     
                         }else
                         {
                                blnFlag=false;
                         }
                   }else if(strByType.equalsIgnoreCase("CLASSNAME"))
                   {
                         if (isElementExist(By.className(strControl),driver)) {
                                blnFlag=true;
                                                     
                         }else
                         {
                                blnFlag=false;
                         }
                         
                   }else if(strByType.equalsIgnoreCase("PARTIALLINKTEXT"))
                   {
                         if (isElementExist(By.partialLinkText(strControl),driver)) {
                                blnFlag=true;
                                                     
                         }else
                         {
                                blnFlag=false;
                         }
                         
                   }else
                   {
                         blnFlag=false;
                   }
                   

            } catch (Exception e) {
                   String strMessage = "failed to verify the exsistance of the element - "
                                + e.getMessage();
                   blnFlag = false;
            }
            return blnFlag;
     }


	// =========================== Web Element ======================================
	/**
	* Method Name : isElementExist_Driver
	* Method Description : This method is used verify whether an element is exist or not which directly comes under webdriver
	* @param strControl - property of an object
	* @return Boolean
	* @author Dhivya Durairaj
	* @throws Exception
	*/

	public boolean isElementExist(By selector,WebDriver driver)
	{
	        try {
	                driver.findElement(selector);
	            return true;
	        } catch (NoSuchElementException e) {
	            return false;
	        }
	}

	public boolean isElementExist(WebElement e)
	{
	        try {
	            e.isDisplayed();
	            return true;
	        } catch (NoSuchElementException e1) {
	            return false;
	        }
	}

	
	/**
	* Method Name : isElementExist
	* Method Description : This method is used verify whether an element is exist or not
	* @param WebElement - ele -- under which the object exists;strControl - property of an object
	* @return Boolean
	* @author Dhivya Durairaj
	* @throws Exception
	*/

	public boolean isElementExist(WebElement ele, By selector)
	{
	        try {
	                ele.findElement(selector);	                
	            return true;
	        } catch (NoSuchElementException e) {
	            return false;
	        }
	}

	
	/**
	* Method Name : ElementClick
	* Method Description : This method is created to click on the particular element which can be directly accessed by driver element
	* @param strControl - property of an object
	* @return Boolean
	* @author Dhivya Durairaj
	* @throws Exception
	*/
	public boolean ElementClick(String strControl,WebDriver driver) {		
	
		boolean blnFlag;
		try{						
			if(isElementExist(By.xpath(strControl),driver))
			{
				driver.findElement(By.xpath(strControl)).click();
			}else if(isElementExist(By.id(strControl),driver))
			{
				driver.findElement(By.id(strControl)).click();
			}
			else if(isElementExist(By.linkText(strControl),driver))
			{
				driver.findElement(By.linkText(strControl)).click();
			}
			else if(isElementExist(By.name(strControl),driver))
			{
				driver.findElement(By.name(strControl)).click();
			}
			
			else if(isElementExist(By.cssSelector(strControl),driver))
			{
				driver.findElement(By.cssSelector(strControl)).click();
			}			
		//	driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.MILLISECONDS);
			blnFlag=true;
		}
		catch(Exception e){
			
			blnFlag=false;
			System.err.println(e.getMessage());
			System.err.println(e.getCause());
		}
		return blnFlag;
	}
	
	
	/**
	* Method Name : ElementClick
	* Method Description : This method is created to click on the particular element which can be directly accessed by an web element
	* @param strControl - property of an object
	* @return Boolean
	* @author Dhivya Durairaj
	* @throws Exception
	*/
	public boolean ElementClick(WebElement ele, String strControl) {		
	
		boolean blnFlag;
		try{						
			if(isElementExist(ele,By.xpath(strControl)))
			{
				ele.findElement(By.xpath(strControl)).click();
			}else if(isElementExist(ele,By.id(strControl)))
			{
				ele.findElement(By.id(strControl)).click();
			}
			else if(isElementExist(ele,By.linkText(strControl)))
			{
				ele.findElement(By.linkText(strControl)).click();
			}
			else if(isElementExist(ele,By.name(strControl)))
			{
				ele.findElement(By.name(strControl)).click();
			}
			else if(isElementExist(ele,By.cssSelector(strControl)))
			{
				ele.findElement(By.cssSelector(strControl)).click();
			}			
			//driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.MILLISECONDS);
			blnFlag=true;
		}
		catch(Exception e){
			
			blnFlag=false;
		}
		return blnFlag;
	}
	



	
	/**
	* Method Name : ElementClick
	* Method Description : This method is created to click on the particular element which can be directly accessed by an web element
	* @param strControl - property of an object
	* @return Boolean
	* @author Dhivya Durairaj
	* @throws Exception
	*/
	public boolean ElementClick(WebElement ele,WebDriver driver) {		
	
		boolean blnFlag;
		try{						
		
			blnFlag=JSClick(ele,driver);
		}
		catch(Exception e){
			
			blnFlag=false;
		}
		return blnFlag;
	}
	public boolean ElementClick1(WebElement ele) {		
		
		boolean blnFlag;
		try{						
			if(isElementExist(ele))
			{
				ele.click();
			}
				
			//driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.MILLISECONDS);
			blnFlag=true;
		}
		catch(Exception e){
			
			blnFlag=false;
		}
		return blnFlag;
	}
	
	


	/**
	* Function Name : FnSetWebEdit
	* Function Description : This Function selects the specified window (and frame, if specified) and enters text in web TextBox.
	* @param: strControl - object property, strValue - value to enter text box 
	* @return Boolean
	* @author Dhivya Durairaj
	* @throws Exception
	*/
	//WEBDRIVER
public boolean FnSetWebEdit(String strControl,String strValue,WebDriver driver){
		//SelectWindow(strWindowConstruct);
		boolean blnFlag;
		try{
				if(isElementExist(By.id(strControl),driver))
				{
					driver.findElement(By.id(strControl)).sendKeys(strValue);
				}
				else if(isElementExist(By.name(strControl),driver))
				{
					System.out.println("String "+ strControl);
					driver.findElement(By.name(strControl)).sendKeys(strValue);
				}
				else if(isElementExist(By.xpath(strControl),driver))
				{
					driver.findElement(By.xpath(strControl)).sendKeys(strValue);
				}
				String strMessage= "Typed "+"'"+strValue+"' in the textbox" ;
			//	driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.MILLISECONDS);
				blnFlag=true;

		}
		catch(Exception e){
			String strMessage="Failed to Type value in text box - "+e.getMessage();	
			blnFlag=false;
		}
		return blnFlag;
}


	/**
	* Method Name : onMouseOver
	* Method Description : This method is used to mouseover on a particular web element
	* @param WebElement element 
	* @return Boolean
	* @author Dhivya Durairaj
	* @throws Exception
	*/
	public boolean onMouseOver(WebElement element,WebDriver driver)
	{
		boolean blnFlag = false;
		try
		{
			String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(mouseOverScript, element);
			blnFlag = true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			blnFlag = false;
		}
		return blnFlag;
	}
	
	

	/**
	* Method Name : onMouseClickJS
	* Method Description : This method is used to click on particular mouse right or left using JS
	* @param WebElement element  and click type - Left or Right
	* @return Boolean
	* @author Dhivya Durairaj
	* @throws Exception
	*/
	public boolean onMouseClickJS(WebElement element, String clickType,WebDriver driver)
	{
		boolean blnFlag = false;
		try
		{
			if (clickType.equalsIgnoreCase("Left"))
			{
				if (System.getProperty("browser").contains("firefox"))
				{
					// element.click();
					String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initMouseEvent('click', true, true, window,1,1,1,1,1,false,false,false,false,0,arguments[0]); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { var ev = document.createEventObject();ev.button = 1; arguments[0].fireEvent('onclick',ev);}";
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript(mouseOverScript, element);
				}
				else if (System.getProperty("browser").contains("safari"))
				{
					String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initMouseEvent('click', true, true, window,1,1,1,1,1,false,false,false,false,0,arguments[0]); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { var ev = document.createEventObject();ev.button = 1; arguments[0].fireEvent('onclick',ev);}";
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript(mouseOverScript, element);
				}
				else
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				blnFlag = true;
				
			}
			else
			{
				onMouseRightClick(element,driver);
				//this.smallWait();
				Thread.sleep(1000);
				blnFlag = true;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			blnFlag = false;
		}
		return blnFlag;
	}


	/**
	* Method Name : onMouseRightClick
	* Method Description : This method is used to right click on particular mouse
	* @param strControl - property of an object
	* @return Boolean
	* @author Dhivya Durairaj
	* @throws Exception
	*/
	public boolean onMouseRightClick(WebElement element,WebDriver driver)
	{
		boolean blnFlag = false;
		try
		{
			if (System.getProperty("browser").contains("safari"))
			{
				String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initMouseEvent('click', true, false, window,0,0,0,0,0,false,false,false,false,2,null); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { var ev = document.createEventObject();ev.button = 2; arguments[0].fireEvent('onclick',ev);}";
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript(mouseOverScript, element);
			}
			else
			{
				org.openqa.selenium.interactions.Actions builderq = new org.openqa.selenium.interactions.Actions(driver);
				org.openqa.selenium.interactions.Action rClick = builderq.contextClick(element).build();
				rClick.perform();
			}
			blnFlag = true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			blnFlag = false;
		}
		return blnFlag;
	}
	
		/**
	* Method Name : SendKeyboardInput
	* Method Description : This method is used to send keyboard input
	* @param String st -- input to be sent
	* @return Boolean
	* @author Dhivya Durairaj
	* @throws Exception
	*/
	public boolean SendKeyboardInput(String st)
	{
		boolean blnFlag = false;
		// int ii=0;
		try
		{
			Robot bot = new Robot();
			Thread.sleep(3000);
			int k = 0;
			char[] arr = st.toCharArray();
			for (int i = 0; i < arr.length; i++)
			{
				Thread.sleep(500);
				k = arr[i];
				if (arr[i] < 97)
					bot.keyPress(KeyEvent.VK_SHIFT);
				else
					k -= 32;
				bot.keyPress(k);
				Thread.sleep(500);
				bot.keyRelease(k);
				if (arr[i] < 97)
					bot.keyRelease(KeyEvent.VK_SHIFT);
				blnFlag = true;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return blnFlag;
	}


	/**
	 * Method Name : isTextPresent
	 * Method Description: Method to verify whether a given text is present within the page
	 * @param driver The {@link WebDriver} object
	 * @param textToVerify The text to be verified within the page
	 * @return A boolean value indicating if the searched text is found
	 * @author Dhivya Durairaj
	 */
	public boolean isTextPresent(WebDriver driver, String textToVerify)
	{
		textToVerify = textToVerify.replace(" ", "\\s*");
		String pageSource = driver.getPageSource();
		String[] pageSourceLines = pageSource.trim().split("\\n");
		String pageSourceWithoutNewlines = "";
		for (String pageSourceLine : pageSourceLines)
		{
			pageSourceWithoutNewlines += pageSourceLine + " ";
		}
		
		pageSourceWithoutNewlines = pageSourceWithoutNewlines.trim();
		
		Pattern p = Pattern.compile(textToVerify);
		Matcher m = p.matcher(pageSourceWithoutNewlines);
		if(m.find())
			return true;
		else
			return false;
	}

	

	/**
	 * Method Name : scrollDown
	 * Method Description: Method to scroll down to the page end
	 * @param none	 * 
	 * @return none
	 * @author Dhivya Durairaj
	 */
	
	public void scrollDown(WebDriver driver)
	{
		// ((JavascriptExecutor) driver).executeScript("scroll(0,200);");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	/**
	 * Method Name : scrollDown
	 * Method Description: Method to scroll down to the page end
	 * @param :height - to which the scroll has to be performed
	 * @return none
	 * @author Dhivya Durairaj
	 */
	public void scrollDown(int height,WebDriver driver)
	{
		String str = Integer.toString(height);
		((JavascriptExecutor) driver).executeScript("window.(0," + str + ");");
	}

	

	/**
	 * Method Name : scrollUp
	 * Method Description: Method to scroll up to the page start
	 * @param :none
	 * @return none
	 * @author Dhivya Durairaj
	 */
	public void scrollUp(WebDriver driver)
	{
		// ((JavascriptExecutor) driver).executeScript("scroll(0,200);");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight);");
	}

	
	/**
	 * Method Name : scrollUp
	 * Method Description: Method to scroll up to the page start
	 * @param :height - to which the scroll has to be performed
	 * @return none
	 * @author Dhivya Durairaj
	 */
	public void scrollUp(int height,WebDriver driver)
	{
		if (height > 0)
		{
			String str = Integer.toString(height);
			((JavascriptExecutor) driver).executeScript("scroll(0,-" + str + ");");
		}
		else
		{
			String str = Integer.toString(height * -1);
			
			((JavascriptExecutor) driver).executeScript(("window.scrollTo(0," + str + ");"));
		}
	}

	

	/**
	 * Method Name : ScrollToView
	 * Method Description: Method to scroll to view the particular webelement
	 * @param :element - to focus
	 * @return none
	 * @author Dhivya Durairaj
	 */
	
	public boolean ScrollToView(WebElement element,WebDriver driver)
	{
		boolean blnFlag = false;
		try
		{
			//Thread.sleep(2000);
			int y = element.getLocation().y;
			int y1 = 380;
			// driver.manage().window().getSize().getHeight();
						
			this.scrollUp(y1 / 2 - y,driver);
			//Thread.sleep(2000);
			blnFlag = true;
			System.out.println("Scroll to view is done");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			blnFlag = false;
		}
		return blnFlag;
	}

	
	/**
	 * Function is used to verify the element Font is Bold: 
	 * 
	 * @param element
	 * @return
	 */
	

	/**
	 * Method Name : VerifyFontBold
	 * Method Description: Method to verify whether the font of webelement is bold
	 * @param :element - to verify font
	 * @return none
	 * @author Dhivya Durairaj
	 */
	
	public boolean VerifyFontBold(WebElement element)
	{
		boolean result = false;
		try
		{
			result = (element.getCssValue("font-weight").equalsIgnoreCase("bold") || Integer.parseInt(element.getCssValue("font-weight")) > 400);
		}
		catch (Exception e)
		{
			result = false;
		}
		return result;
	}
	
	/**
	 * Method Name : FnHighligt_IE
	 * Method Description: Method to highlight an element in IE
	 * @param :element - to highlight
	 * @return none
	 * @author Dhivya Durairaj
	 */
	public void FnHighligt_IE(WebElement element,WebDriver driver)
	{
		try
		{
			for (int i = 0; i < 1; i++)
			{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: yellow; border: 3px solid black;");
				Thread.sleep(300);
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
			}		
		}
		catch (Exception e)
		{
			e.printStackTrace();	
		}
	}
	
	/**
	 * Method Name : FnExplicitWait
	 * Method Description: Method to wait explicitly till the element is located
	 * @param :element - to wait 
	 * @return none
	 * @author Dhivya Durairaj
	 */
	public boolean FnExplicitWait1(String strByType,String strConst )
	{
		boolean blnFlag=false;
		try{
			
			System.out.println("inside exp wait");
			WebDriverWait wait = new WebDriverWait(driver,120,1000);
			System.out.println("DRIVER OBJECT::"+driver);
			if(strByType.equalsIgnoreCase("ID"))
			{
				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(strConst)));
				System.out.println(strConst +" element display -" + element.isDisplayed());
				if(element.isDisplayed())			
					blnFlag=true;
			
			}else if(strByType.equalsIgnoreCase("XPATH"))
			{
				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strConst)));
				System.out.println(strConst +" element display -" + element.isDisplayed());
				if(element.isDisplayed())			
					blnFlag=true;
				
			}else if(strByType.equalsIgnoreCase("CLASSNAME"))
			{
				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(strConst)));
				System.out.println(strConst +" element display -" + element.isDisplayed());
				if(element.isDisplayed())			
					blnFlag=true;
				
			}else if(strByType.equalsIgnoreCase("PARTIALTEXT"))
			{
				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(strConst)));
				System.out.println(strConst +" element display -" + element.isDisplayed());
				if(element.isDisplayed())			
					blnFlag=true;
				
			}
			
		}catch(Exception e)
		{
			blnFlag=false;
		}
		return blnFlag;
	}
	public boolean FnExplicitWait(String strByType,String strConst,WebDriver driver)
	{
		
		boolean blnFlag=false;
		try{
			System.out.println("Inside method: FnExplicitWait,Find element:"+strConst);
			WebDriverWait wait = new WebDriverWait(driver,60,1000);
			if(strByType.equalsIgnoreCase("ID"))
			{
				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(strConst)));
				System.out.println(strConst +" element display -" + element.isDisplayed());
				if(element.isDisplayed())			
					blnFlag=true;
			
			}else if(strByType.equalsIgnoreCase("XPATH"))
			{
				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strConst)));
				System.out.println(strConst +" element display -" + element.isDisplayed());
				if(element.isDisplayed())			
					blnFlag=true;
				
			}else if(strByType.equalsIgnoreCase("CLASSNAME"))
			{
				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(strConst)));
				System.out.println(strConst +" element display -" + element.isDisplayed());
				if(element.isDisplayed())			
					blnFlag=true;
				
			}else if(strByType.equalsIgnoreCase("PARTIALTEXT"))
			{
				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(strConst)));
				System.out.println(strConst +" element display -" + element.isDisplayed());
				if(element.isDisplayed())			
					blnFlag=true;
				
			}
			
		}catch(Exception e)
		{
			//e.printStackTrace();
			blnFlag=false;
		}
		return blnFlag;
	}
	
	/**
	 * Method Name : FnExplicitWait_untilClickable Method Description: Method to wait
	 * explicitly till the element is clickable
	 * @param :element - to wait
	 * @return none
	 * @author Pavan Pushadapu
	 */
	public boolean FnExplicitlessWait_untilClickable(String strByType, String strConst,WebDriver driver) {

		boolean blnFlag = false;
		try {
			System.out.println("inside exp wait");
			WebDriverWait wait = new WebDriverWait(driver, 60, 1000);
			if (strByType.equalsIgnoreCase("ID")) {
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable
						(By.id(strConst)));
				System.out.println(strConst + " element display -"
						+ element.isDisplayed());
				if (element.isDisplayed())
					blnFlag = true;

			} else if (strByType.equalsIgnoreCase("XPATH")) {
				WebElement element = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath(strConst)));
				System.out.println(strConst + " element display -"
						+ element.isDisplayed());
				if (element.isDisplayed())
					blnFlag = true;

			} else if (strByType.equalsIgnoreCase("CLASSNAME")) {
				WebElement element = wait.until(ExpectedConditions
						.elementToBeClickable(By.className(strConst)));
				System.out.println(strConst + " element display -"
						+ element.isDisplayed());
				if (element.isDisplayed())
					blnFlag = true;

			} else if (strByType.equalsIgnoreCase("PARTIALTEXT")) {
				WebElement element = wait.until(ExpectedConditions
						.elementToBeClickable(By
								.partialLinkText(strConst)));
				System.out.println(strConst + " element display -"
						+ element.isDisplayed());
				if (element.isDisplayed())
					blnFlag = true;
			} else if (strByType.equalsIgnoreCase("cssSelector")) {
				WebElement element = wait.until(ExpectedConditions
						.elementToBeClickable(By.cssSelector(strConst)));
				System.out.println(strConst + " element display -"
						+ element.isDisplayed());
				if (element.isDisplayed())
					blnFlag = true;

			}else if (strByType.equalsIgnoreCase("tagName")) {
				WebElement element = wait.until(ExpectedConditions
						.elementToBeClickable(By.tagName(strConst)));
				System.out.println(strConst + " element display -"
						+ element.isDisplayed());
				if (element.isDisplayed())
					blnFlag = true;

			}

		} catch (Exception e) {
			blnFlag = false;
		}
		return blnFlag;
	}
	
	/**
	 * Method Name : FnExplicitWait
	 * Method Description: Method to wait explicitly till the element is located
	 * @param :element - to wait
	 * @return none
	 * @author Dhivya Durairaj
	 */
	public boolean FnExplicitlessWait(String strByType,String strConst,WebDriver driver)
	{
		
		boolean blnFlag=false;
		try{
			System.out.println("inside exp wait");
			WebDriverWait wait = new WebDriverWait(driver,60,1000);
			if(strByType.equalsIgnoreCase("ID"))
			{
				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(strConst)));
				System.out.println(strConst +" element display -" + element.isDisplayed());
				if(element.isDisplayed())			
					blnFlag=true;
			
			}else if(strByType.equalsIgnoreCase("XPATH"))
			{
				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strConst)));
				System.out.println(strConst +" element display -" + element.isDisplayed());
				if(element.isDisplayed())			
					blnFlag=true;
				
			}else if(strByType.equalsIgnoreCase("CLASSNAME"))
			{
				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(strConst)));
				System.out.println(strConst +" element display -" + element.isDisplayed());
				if(element.isDisplayed())			
					blnFlag=true;
				
			}else if(strByType.equalsIgnoreCase("PARTIALTEXT"))
			{
				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(strConst)));
				System.out.println(strConst +" element display -" + element.isDisplayed());
				if(element.isDisplayed())			
					blnFlag=true;
			}else if(strByType.equalsIgnoreCase("cssSelector"))
			{
				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(strConst)));
				System.out.println(strConst +" element display -" + element.isDisplayed());
				if(element.isDisplayed())			
					blnFlag=true;
				
			}
			
		}catch(Exception e)
		{
			blnFlag=false;
		}
		return blnFlag;
	}
	
	public boolean JSClick(WebElement e,WebDriver driver)
	{		
		boolean blnFlag=false;
			
			try{
				
				if(e.isDisplayed())
				{
					if(m1.get("BROWSER").toString().equalsIgnoreCase("chrome")||m1.get("BROWSER").toString().equalsIgnoreCase("firefox")){
						blnFlag=ElementClick1(e);						
					}else{
						blnFlag=true;
						System.out.println("inside JS click");
				    	JavascriptExecutor executor = (JavascriptExecutor)driver;
						//executor.executeScript("arguments[0].click();", e);	
						executor.executeScript("var el = arguments[0];setTimeout(function(){el.click();}, 0);",e);
					}
				}
		    }catch(Exception e1)
		    {
		    	blnFlag=true;
		    	if(e.isDisplayed()||e.isSelected())
				{
		    		blnFlag=true;
				
		    		System.out.println("inside action click");
					 Actions builder = new Actions(driver);  
					  Actions actions1=(Actions) builder.build();			  
			          actions1.click(e);
				}	   
		    	
		}
		
		
		return blnFlag;
		
          
	}
	
	
	public boolean FnExplicitWaitFeedback(String strByType,String strConst,WebDriver driver)
	{
		
		boolean blnFlag=false;
		try{
		//	System.out.println("inside exp wait");
			WebDriverWait wait = new WebDriverWait(driver,5,1000);
			if(strByType.equalsIgnoreCase("XPATH"))
			{
				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strConst)));
				//System.out.println(strConst +" element display -" + element.isDisplayed());
				if(element.isDisplayed())			
					blnFlag=true;
			}
			
		}catch(Exception e)
		{
			blnFlag=false;
		}
		return blnFlag;
	}
	/**
	* Method Name : listFile,GenericExtFilter
	* Method Description : This method is used to find a pdf format file in user downlaods
	* @author Harpreet_Kaur16
	
	*/

	public String listFile(String folder, String ext) {

		GenericExtFilter filter = new GenericExtFilter(ext);

		File dir = new File(folder);

		if(dir.isDirectory()==false){
		

			fileMessage = "Directory does not exists : " + FILE_DIR;

			return fileMessage;
		}

		// list out all the file name and filter by the extension
		String[] list = dir.list(filter);

		if (list.length == 0) {
			
			fileMessage = "no files end with : " + ext;

			return fileMessage;
		}

		for (String file : list) {
			String temp = new StringBuffer(FILE_DIR).append(File.separator)
					.append(file).toString();

			fileMessage = "file : " + temp;
		}

		return fileMessage;
	}

	// inner class, generic extension filter
	public class GenericExtFilter implements FilenameFilter {

		private String ext;

		public GenericExtFilter(String ext) {
			this.ext = ext;
		}

		public boolean accept(File dir, String name) {
			return (name.endsWith(ext));
		}
	}
	
	
	     
	    /**
	     * This method generates random string
	     * @return
	     */
	    public String generateRandomString(){
	         
	        StringBuffer randStr = new StringBuffer();
	        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
	            int number = getRandomNumber();
	            char ch = CHAR_LIST.charAt(number);
	            randStr.append(ch);
	        }
	        return randStr.toString();
	    }
	    /**
	     * This method generates random numbers
	     * @return int
	     */
	    private int getRandomNumber() {
	        int randomInt = 0;
	        Random randomGenerator = new Random();
	        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
	        if (randomInt - 1 == -1) {
	            return randomInt;
	        } else {
	            return randomInt - 1;
	        }
	    }
	    public static boolean isValidFormat(String format, String value) {
	        Date date = null;
	        try {
	            SimpleDateFormat sdf = new SimpleDateFormat(format);
	            date = sdf.parse(value);
	            if (!value.equals(sdf.format(date))) {
	                date = null;
	            }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        return date != null;
	    }
		public boolean verifyAmountFormat(String Amount){
			boolean flag=false;
			String amount=Amount;
			if(amount.contains("$")){
		//	String data1[]=amount.split("$");
			//String dollarsign=data1[0];
			String amountdollars = amount.substring(1);
		
				if(amountdollars.contains(".")){
					flag=true;
					/*
				String data2[]=amountdollars.split(".");
				String dollars=data2[0];
				String cent=data2[1];
				if(data2.length==2){
					flag=true;
				}else{
					flag=false;
				}*/
			}else{
				 flag=false;
			}
			
			}else{
				flag=false;
			}
			 return flag;
		}
		
	    
	    /**
	     * This method switches to alert if alert is present
	     * @return int
	     */
        public boolean isAlertPresent(){
			try{
			    driver.switchTo().alert();
			    return true;
			}//try
			catch(Exception e){
			    return false;
			}//catch
			}


}
