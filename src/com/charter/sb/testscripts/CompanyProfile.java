package com.charter.sb.testscripts;

import org.openqa.selenium.WebDriver;







import com.charter.sb.beans.RunManagerInfo;
import com.charter.sb.controllers.Initialization;
import com.charter.sb.resources.MB_PageObjects;
import com.charter.sb.services.CharterAppFunctions;
import com.charter.sb.services.CompanyProfileService;
import com.charter.sb.utils.CommonFunctions;
import com.charter.sb.utils.ReportingFunctions;
import com.charter.sb.utils.RunManager;

public class CompanyProfile extends Initialization {
	MB_PageObjects mbo = new MB_PageObjects();
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	CompanyProfileService cmp=new CompanyProfileService();
	public static boolean blnFlag = false;
	long startTime = System.currentTimeMillis();
	long endtime = System.currentTimeMillis();
	
	public synchronized void Verify_LoginLogout(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception 
	{

		try
		{System.out.println("In method driver value is: "+driver);
			
			for (int iCount=0; iCount<3;iCount++)
			{
				switch(iCount)	          
				{
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
				case 1:
					System.out.println("Case 1");
					blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
					break;
				case 2:
					System.out.println("Case 2");
					blnFlag=app.CommonLogout(driver,runManagerInfoObj);
					break;
					
				}

				if(!blnFlag)
				{
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			} 
			////repfn.FnUpdateEndTest(runManagerInfoObj);
		}	
		catch(Exception e)
		{
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	public synchronized void Verify_SecurityQA_RequiredFields(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception{
		try{
			
			
			
			for(int iCount=0; iCount<6;iCount++){
				switch(iCount)
				{
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
				case 1:
					System.out.println("Case 1");
					blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);                            
					break;
				case 2:
					System.out.println("Case 2");
					blnFlag=cmp.FnVerifyAndClickMyProfileLink(driver,runManagerInfoObj);                            
					break;				
				case 3:
					System.out.println("Case 3");
					blnFlag=cmp.FnVerifyAndClickSecuritySettingsLink(driver,runManagerInfoObj);
					break;				
				case 4:
					System.out.println("Case 4");
					blnFlag=cmp.FnVerifySecurityQA_RequiredFields(driver,runManagerInfoObj);
					break;	
				case 5:
					System.out.println("Case 5");
					blnFlag=app.CommonLogout(driver,runManagerInfoObj);
					break;
					
				
				}

				if(!blnFlag)
				{
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				} 		
			}
			////repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch(Exception e)
		{
			repfn.FnCom_ThrowException(e,driver);                         
		}
}
	public synchronized void Verify_MyProfile_UI(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
	{
		
		try
		{
			for (int iCount=0; iCount<5;iCount++)
			{									
				switch(iCount)
				{	
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
				case 1:
					System.out.println("Case 1");
					blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
					break;									
				case 2:
					System.out.println("Case 2");
					blnFlag=cmp.FnMyProfile(driver,runManagerInfoObj);
					break;										
				case 3:
					System.out.println("Case 3");
					blnFlag=cmp.MyProfile_UI(driver,runManagerInfoObj);									
					break;															
				case 4:
					System.out.println("Case 4");
					blnFlag=app.CommonLogout(driver,runManagerInfoObj);
					break;
					
				
				}

				if(!blnFlag)
				{
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			} 
			////repfn.FnUpdateEndTest(runManagerInfoObj);
		}
		catch(Exception e)
		{
			
			repfn.FnCom_ThrowException(e,driver);
		}

	}
	
	public synchronized void Verify_MyProfile_PasswordHelpIcon(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
	{
		
		try
		{
			
			for (int iCount=0; iCount<6;iCount++)
			{

				switch(iCount)
				{
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
				case 1:
					System.out.println("Case 1");
					blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
					break;									
				case 2:
					System.out.println("Case 2");
					blnFlag=cmp.FnMyProfile(driver,runManagerInfoObj);
					break;										
				case 3:	
					System.out.println("Case 3");
					blnFlag=cmp.MyProfile_SecuritySettings(driver,runManagerInfoObj);									
					break;									
				case 4:
					System.out.println("Case 4");
					blnFlag=cmp.FN_PasswordHelpIcon_Check(driver,runManagerInfoObj);
					break;
				case 5:
					System.out.println("Case 5");
					blnFlag=app.CommonLogout(driver,runManagerInfoObj);
					break;

				}


				if(!blnFlag)
				{
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			} 
			////repfn.FnUpdateEndTest(runManagerInfoObj);
		}
		catch(Exception e)
		{
			repfn.FnCom_ThrowException(e,driver);
		}

	}

	public synchronized void Verify_MyProfile_SS_UI(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception
	{
		
		try
		{
			
			for (int iCount=0;iCount<6;iCount++)
			{									
				switch(iCount)
				{
				case 0:
					System.out.println("Case 0");
					blnFlag=app.UserLogin(driver,runManagerInfoObj);
					break;
				case 1:
					System.out.println("Case 1");
					blnFlag=app.FnOverviewPage(driver,runManagerInfoObj);
					break;									
				case 2:
					System.out.println("Case 2");
					blnFlag=cmp.FnMyProfile(driver,runManagerInfoObj);
					break;										
				case 3:
					System.out.println("Case 3");
					blnFlag=cmp.MyProfile_SecuritySettings(driver,runManagerInfoObj);									
					break;									
				case 4:
					System.out.println("Case 4");
					blnFlag=cmp.MyProfile_SecuritySettings_UI(driver,runManagerInfoObj);
					break;		
				case 5:
					System.out.println("Case 5");
					blnFlag=app.CommonLogout(driver,runManagerInfoObj);
					break;
					
											
				}

				if(!blnFlag)
				{
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			} 
			////repfn.FnUpdateEndTest(runManagerInfoObj);
		}
		catch(Exception e)
		{
			repfn.FnCom_ThrowException(e,driver);

		}

	}
	public synchronized void SecuritySettings_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		try {
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case 2");
						blnFlag = cmp.FnCompanyProfile(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case 3");
						blnFlag = cmp.FnCompanyProfile_SecuritySettings(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case 4");
						blnFlag = cmp.SecurityCode_Cancel(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case 5");
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
			////repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}
	public synchronized void SecuritySettings_Save(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		try {
			
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case 2");
						blnFlag = cmp.FnCompanyProfile(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case 3");
						blnFlag = cmp.FnCompanyProfile_SecuritySettings(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case 4");
						blnFlag = cmp.SecurityCode_Save(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case 5");
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
			////repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}
	public synchronized void SecuritySettings_InvalidScenarios(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		try {
			
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case 2");
						blnFlag = cmp.FnCompanyProfile(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case 3");
						blnFlag = cmp.FnCompanyProfile_SecuritySettings(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case 4");
						blnFlag = cmp.InvalidSecurityCode(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case 5");
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
			////repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}
	

	public synchronized void Sprint28_FN_CompanyProfile_Support(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {

			
			
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = cmp.FnVerifyAndClickCompanyProfileLink(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = cmp.FnVerifyAndClickSupportLink(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}

			////repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}



	public synchronized void FN_CompanyProfile_UI(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		try {
			
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case 1");
						blnFlag = cmp.FnCompanyProfile(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case2");
						blnFlag = cmp.CompanyProfile_UI(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case5");
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
			////repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}
	

	public synchronized void SecuritySettings_UI(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		try {
			

			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case 2");
						blnFlag = cmp.FnCompanyProfile(driver,runManagerInfoObj);
						break;
					case 3:
						System.out.println("Case 3");
						blnFlag = cmp.FnCompanyProfile_SecuritySettings(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case 4");
						blnFlag = cmp.CompanyProfile_SecuritySettings_UI(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case 5");
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
						break;

				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
			////repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}
	
	
	 
	public synchronized void SecuritySettings_ShowCodeLink(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		try {
			
			for (int iCount = 0; iCount < 7; iCount++) {
				switch (iCount) {
					case 1:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case 2");
						blnFlag = cmp.FnCompanyProfile(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case 3");
						blnFlag = cmp.FnCompanyProfile_SecuritySettings(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case 4");
						blnFlag = cmp.CP_SS_ShowCode(driver,runManagerInfoObj);
						break;
					case 6 :
						System.out.println("Case 5");
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
			////repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}

	public synchronized void CompanyProfile_ServiceAddresscheck(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		try {
			
			for (int iCount = 0; iCount < 5; iCount++) {

				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case 2");
						blnFlag = cmp.FnCompanyProfile(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case3");
						blnFlag = cmp.FN_Edit_ServiceAddresschecked(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case4");
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
			////repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}

	public synchronized void CompanyProfile_ServiceAddresscheck_Edit(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		try {
			
			for (int iCount = 0; iCount < 4; iCount++) {

				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case 1");
						blnFlag = cmp.FnCompanyProfile(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case2");
						blnFlag = cmp.EditBillingAddress(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case5");
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
			////repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}
	// Priyanka[28-10-2015]//

	public synchronized void CompanyProfile_ServiceAddresscheck_EditSave(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		try {
			
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case 1");
						blnFlag = cmp.FnCompanyProfile(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case2");
						blnFlag = cmp.EditSaveBillingaddress(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case5");
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
			////repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}
	

	public synchronized void MyProfile_EditnSave(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		try {
			
			for (int iCount = 0; iCount < 5; iCount++) {

				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case 2");
						blnFlag = cmp.FnMyProfile(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case 3");
						blnFlag = cmp.MyProfile_EditAndSave(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case 4");
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
			////repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}
	
	public synchronized void MyProfile_MandatorynSave(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		try {
			

			for (int iCount = 0; iCount < 5; iCount++) {

				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case 2");
						blnFlag = cmp.FnMyProfile(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case 3");
						blnFlag = cmp.MyProfile_Mandatory(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case 4");
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
			////repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}
	// function to validate Password requirements//

	public synchronized void MyProfile_SS_Passwordreqmnts(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		try {
			
			for (int iCount = 0; iCount < 12; iCount++) {

				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case 2");
						blnFlag = cmp.FnMyProfile(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case 3");
						blnFlag = cmp.MyProfile_SecuritySettings(driver,runManagerInfoObj);
						break;
					case 4 :
						
						blnFlag = cmp.SecuritySettings_Usernameerror(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = cmp.SecuritySettings_Symbolserror(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = cmp.SecuritySettings_Phraseerror(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = cmp.SecuritySettings_Red(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = cmp.SecuritySettings_Green(driver,runManagerInfoObj);
						break;
					case 9 :
						blnFlag = cmp.SecuritySettings_Strong(driver,runManagerInfoObj);
						break;
					case 10  :
						blnFlag = cmp.PasswordCheck1(driver,runManagerInfoObj);
						break;
					case 11 :
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
						break;

				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
			////repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}
	
	
	 

	public synchronized void Sprint28_FN_VerifyClearPasswordFields(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {

			
			
			for (int iCount = 0; iCount < 7; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = cmp.FnVerifyAndClickMyProfileLink(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = cmp.FnVerifyAndClickSecuritySettingsLink(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = cmp.FnClearPasswordFields(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = cmp.FnNavigateToProfilePage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}

			////repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}
	public synchronized void Sprint28_FN_MyProfile_PasswordRequiredFeilds(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		try {
			

			for (int iCount = 0; iCount < 7; iCount++) {

				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case 2");
						blnFlag = cmp.FnMyProfile(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case 3");
						blnFlag = cmp.MyProfile_SecuritySettings(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case 4");
						blnFlag = cmp.FN_NewPasswordRequiredFeildIcon_Check(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case 5");
						blnFlag = cmp.FN_RetypePasswordRequiredFeildIcon_Check(driver,runManagerInfoObj);
						break;
					case 6 :
						System.out.println("Case 5");
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
						break;

				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
			////repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}
	public synchronized void MyProfile_SS_PasswordBlanks(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		try {
			
			for (int iCount = 0; iCount < 6; iCount++) {

				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case 2");
						blnFlag = cmp.FnMyProfile(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case 3");
						blnFlag = cmp.MyProfile_SecuritySettings(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case 4");
						blnFlag = cmp.SS_Password(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case 5");
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
			////repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}
	public synchronized void MyProfile_SS_PasswordMasking(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		try {
			
			for (int iCount = 0; iCount < 7; iCount++) {

				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case 2");
						blnFlag = cmp.FnMyProfile(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case 3");
						blnFlag = cmp.MyProfile_SecuritySettings(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case 4");
						blnFlag = cmp.SS_Passwordmasked(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case 5");
						blnFlag = cmp.MyProfile_SS_Save(driver,runManagerInfoObj);
						break;
					case 6 :
						System.out.println("Case 5");
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
			////repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}
	public synchronized void MyProfile_SS_PasswordSave(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		try {
			
			for (int iCount = 0; iCount < 8; iCount++) {

				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case 2");
						blnFlag = cmp.FnMyProfile(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case 3");
						blnFlag = cmp.MyProfile_SecuritySettings(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case 5");
						blnFlag = cmp.SS_Passwordentry(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case 5");
						blnFlag = cmp.SecuritySettings_Strong(driver,runManagerInfoObj);
						break;
					case 6 :
						System.out.println("Case 5");
						blnFlag = cmp.MyProfile_SS_Save(driver,runManagerInfoObj);
						break;
					case 7 :
						System.out.println("Case 5");
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
			////repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}
	public synchronized void MyProfile_SS_ChangeSecurityQuestionAnswer(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			

			for (int iCount = 0; iCount < 6; iCount++) {

				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case 2");
						blnFlag = cmp.FnMyProfile(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case 3");
						blnFlag = cmp.MyProfile_SecuritySettings(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case 4");
						blnFlag = cmp.ChangeSecurityQuestionAnswer(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case 5");
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
						break;

				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
			////repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}

	public synchronized void MyProfile_SS_ChangeSecurityQuestionAnswer_ClearFields(WebDriver driver, RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			

			for (int iCount = 0; iCount < 6; iCount++) {

				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case 2");
						blnFlag = cmp.FnMyProfile(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case 3");
						blnFlag = cmp.MyProfile_SecuritySettings(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case 4");
						blnFlag = cmp.SecurityAnswer_ClearFields(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case 5");
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
						break;

				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
			////repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
		}
	
	
	 
	 

	public synchronized void Sprint28_FN_VerifySecurityQAOptions(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = cmp.FnVerifyAndClickMyProfileLink(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = cmp.FnVerifyAndClickSecuritySettingsLink(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = cmp.FnVerifySecurityQAOptions(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
			////repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	
	
	 

	public synchronized void Sprint28_FN_VerifySecurityQA_RequiredFields(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = cmp.FnVerifyAndClickMyProfileLink(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = cmp.FnVerifyAndClickSecuritySettingsLink(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = cmp.FnVerifySecurityQA_RequiredFields(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
			////repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
		}


	

	 
	public synchronized void FN_MyProfile_UI(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		
		try {
			

			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case 2");
						blnFlag = cmp.FnMyProfile(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case 3");
						blnFlag = cmp.MyProfile_UI(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case 4");
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
			////repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}
	
	
	 
	public synchronized void MyProfile_SS_UI(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		
		try {
			

			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2:
						System.out.println("Case 2");
						blnFlag = cmp.FnMyProfile(driver,runManagerInfoObj);
						break;
					case 3:
						System.out.println("Case 3");
						blnFlag = cmp.MyProfile_SecuritySettings(driver,runManagerInfoObj);
						break;
					case 4:
						System.out.println("Case 5");
						blnFlag = cmp.MyProfile_SecuritySettings_UI(driver,runManagerInfoObj);
						break;
					case 5:
						System.out.println("Case 5");
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
			////repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);

		}

	}
	
	 

	public synchronized void Sprint28_FN_MyProfile_PasswordHelpIcon(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		
		try {
			

			for (int iCount = 0; iCount < 5; iCount++) {

				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;

					case 1 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case 2");
						blnFlag = cmp.FnMyProfile(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case 3");
						blnFlag = cmp.MyProfile_SecuritySettings(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case 4");
						blnFlag = cmp.FN_PasswordHelpIcon_Check(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case 5");
						blnFlag = app.CommonLogout(driver,runManagerInfoObj);
						break;

				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
			////repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}
}
