package com.charter.sb.testscripts;

import org.openqa.selenium.WebDriver;

import com.charter.sb.beans.RunManagerInfo;
import com.charter.sb.controllers.Initialization;
import com.charter.sb.services.CharterAppFunctions;
import com.charter.sb.services.ContactsService;
import com.charter.sb.utils.CommonFunctions;
import com.charter.sb.utils.ReportingFunctions;
import com.charter.sb.utils.RunManager;

public class Contacts extends Initialization {
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	ContactsService con=new ContactsService();
	public static boolean blnFlag = false;
	long startTime = System.currentTimeMillis();
	long endtime = System.currentTimeMillis();

	
	public synchronized void ContactsDisplay(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		try {		

			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						System.out.println("Case2");
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case2");
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case3");
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case4");
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
				//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}
	public synchronized void VerifyDefault_A_ZSort(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {

			
			
			
			for (int iCount = 0; iCount < 10; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FN_SearchBar_SearchText(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FN_SortingA_Z(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FN_SearchBar_SearchText(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = con.FN_SortingZ_A(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = con.FN_SearchBar_SearchText(driver,runManagerInfoObj);
						break;
					case 9 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
				//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	public synchronized void ContactsListings(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		try {
			
			
					

			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						System.out.println("Case2");
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case3");
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case3");
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case4");
						blnFlag = con.FnContactsDetails(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case5");
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
				//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}
	public synchronized void AddNewContact(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		
		try {
			
			
					

			for (int iCount = 0; iCount < 5; iCount++) {

				switch (iCount) {
					case 0 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						System.out.println("Case2");
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case3");
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case3");
						blnFlag = con.FnClickAddContact(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case4");
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
				//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}

	public synchronized void ContactsUICheck(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		
		System.out.println("Before running test scripts" + startTime);
		try {
			
			
					

			for (int iCount = 0; iCount < 8; iCount++) {

				switch (iCount) {

					case 0 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						System.out.println("Case2");
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case3");
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case1");
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case1");
						blnFlag = con.FN_FirstcontactClick(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case1");
						blnFlag = con.ContactsUI_Check(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.FN_manageLine_backbtnClick(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
				//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Call Log > Call Details_Edit saved contact & Save.Created by Saranya Date
	 * :10/14 /2015/
	 */

	public synchronized void FN_SavedContactLogEdit(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			
			
					

			for (int iCount = 0; iCount < 8; iCount++) {

				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.Fn_VerifyUserDetailsUI(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.FN_manageLine_backbtnClick(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}
				//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}
	/*
	 * Verifying if the user is able to see the information of the selected
	 * contact in the contact info window. Created by Saranya Date : 9/18/2015
	 */
	public synchronized void Sprint25_FnDifferentContactClick_ToViewContactUI(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 7; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnDifferentContact1Click_ToViewContactUI(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnDifferentContact2Click_ToViewContactUI(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
				//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verify the navigation to and fro the contacts list section and the
	 * contact information screen Created by Saranya Date : 9/18/2015
	 */
	public synchronized void Sprint25_FnContact_Navg_back(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContact_Navg_back(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
				//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user is able to search for contacts. Created by Manavi
	 * Date : 18/11/2015
	 */

	public synchronized void Sprint25_FN_VerifySearchBar(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnVerifySearchField(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
				//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	// Saranya[10/9/2015]

	/*
	 * Verifying the search results display once the user starts typing in the
	 * search text area.Verifying if the user is able to search with first name
	 * and last name Created by Saranya Date :10/9 /2015/
	 */

	public synchronized void Sprint25_Fnsearch_firstNameLastName(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 7; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FN_SearchBar_LastName(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FN_SearchBar_FirstNAME(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
				//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user is able to sort the contacts and search.Created by
	 * Saranya Date :10/9 /2015/
	 */
	public synchronized void Sprint25_FnsOrtingA_Z(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 10; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FN_SearchBar_SearchText(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FN_SortingA_Z(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FN_SearchBar_SearchText(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = con.FN_SortingZ_A(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = con.FN_SearchBar_SearchText(driver,runManagerInfoObj);
						break;
					case 9 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
				//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user is able to clear the typed value in search box.
	 * Created by Manavi Date : 8/10/2015
	 */

	public synchronized void Sprint25_FN_ClearSearchValue(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 5; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnClearSearchField(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
				//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user is able to add address to new contact Created by
	 * Saranya Date : 9/28/2015
	 */

	public synchronized void Sprint25_FnAddcontact_AddressVerification(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnClickAddContact(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnAddContact_AddAddressSaveAndVerify(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
				//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user is able to cancel adding address to new contact
	 * Created by Saranya Date : 9/23/2015
	 */
	public synchronized void Sprint25_FnAddcontact_Address_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnClickAddContact(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnAddContact_AddAddressCancelAndVerify(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
				//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user is able to remove the address added to new contact
	 * Created by Saranya Date : 9/28/2015
	 */

	public synchronized void Sprint25_FnAddcontact_Remove_Address(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnClickAddContact(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnAddContact_AddAddressSave_RemoveAddressAndVerify(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
				//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user is able to add 2 email addresses to new contact
	 * Created by Saranya Date : 9/23/2015
	 */

	public synchronized void Sprint25_FnAddcontact_EmailVerification(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 11; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnClickAddContact(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FNEnteringData_FN_LN(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FN_addEmailIconClick(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.FN_SaveButtonClick(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = con.FNContactListVerificationAfterSaving(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = con.FNAddcontact_EmailVerification(driver,runManagerInfoObj);
						break;
					case 9 :
						blnFlag = con.FNAddcontact_DeleteContact(driver,runManagerInfoObj);
						break;
					case 10 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
				//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user is able to cancel adding 2 email addresses to new
	 * contact Created by Saranya Date : 9/23/2015
	 */

	public synchronized void Sprint25_FnAddcontact_Email_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 9; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FN_addcontactClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FNEnteringData_FN_LN_ForCancel(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FN_addEmailIconClick(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.FN_CancelButtonClick(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = con.FNContactListVerificationAfterCanceLLing(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
				//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user is able to remove the 2 email addresses added to
	 * new contact Created by Saranya Date : 9/28/2015
	 */

	public synchronized void Sprint25_FnAddcontact_Remove_Email(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 12; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FN_addcontactClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FNEnteringData_FN_LN(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FN_addEmailIconClick(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FN_RemoveEmailIconClick(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FN_SaveButtonClick(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = con.FNContactListVerificationAfterSaving(driver,runManagerInfoObj);
						break;
					case 9 :
						blnFlag = con.FNAddcontact_EmailVerificationAfterCancel(driver,runManagerInfoObj);
						break;
					case 10 :
						blnFlag = con.FNAddcontact_DeleteContact(driver,runManagerInfoObj);
						break;
					case 11 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
				//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}

	/*
	 * Verifying if the user is not able to enter invalid email addresses when
	 * adding a new contact Created by Saranya Date : 9/23/2015
	 */

	public synchronized void Sprint25_FN_addInvaLidEmailErrorMessageCheck(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 9; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnContactsTabClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FN_addcontactClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FNEnteringData_FN_LN_ForCancel(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FN_addInvaLidEmailErrorMessageCheck(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.FN_CancelButtonClick(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = con.FNContactListVerificationAfterCanceLLing(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
				//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user is able to Add new number to the new contact
	 * Created by Saranya Date : 9/29/2015
	 */

	public synchronized void Sprint26_FnAddcontact_PhoneNumberVerification(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 9; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnContactsTabClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FN_addcontactClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FNEnteringData_FN_LN(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FN_addPhoneconClick(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FN_SaveButton_Click(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = con.FNAddcontact_PhoneNumberVerification(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
				//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user is able to cancel Adding new number to the new
	 * contact Created by Saranya Date : 9/29/2015
	 */

	public synchronized void Sprint26_FnAddcontact_PhoneNO_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 9; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnContactsTabClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FN_addcontactClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FNEnteringData_FN_LN_ForCancel(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FN_addPhoneconClick(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.FN_CancelButtonClick(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = con.FNContactListVerificationAfterCanceLLing(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
				//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user can enter only valid phone number while adding a
	 * new contact. Created by Saranya Date : 9/29/2015
	 */

	public synchronized void Sprint26_FN_addInvaLidPhoneNOErrorMsgCheck(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 9; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnContactsTabClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FN_addcontactClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FNEnteringData_FN_LN_ForCancel(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FN_addInvaLidPhoneNoErrorMessageCheck(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FN_addInvalid_PhoneNumberErrorMessageCheck(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FN_CancelButtonClick(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
				//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user is able to remove phone number added to the new
	 * contact Created by Saranya Date : 9/29/2015
	 */

	public synchronized void Sprint26_FnAddcontact_Remove_PhoneNumber(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FN_addcontactClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FNEnteringData_FN_LN(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FN_addPhoneconClick(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FN_RemovePhoneNoClick_Add_Save(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
				//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user is able to remove phone number added to the new
	 * contact and cancel Created by Saranya Date : 9/29/2015
	 */

	public synchronized void Sprint26_FnAddcontact_RemovePhoneNo_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FN_addcontactClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FNEnteringData_FN_LN_ForCancel(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FN_addPhoneconClick(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FN_RemovePhoneNoClick_Add_Cancel(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
				//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Contacts > EditVerifying Edit contact pageVerifying if the user is able
	 * to Edit the contact and save Created by Saranya Date : 1/10/2015
	 */

	public synchronized void Sprint26_FNContactList_EditModeVerification(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
						System.out.println("Case1");
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						System.out.println("Case2");
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						System.out.println("Case3");
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						System.out.println("Case3");
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						System.out.println("Case1");
						blnFlag = con.FN_FirstcontactClick(driver,runManagerInfoObj);
						break;
					case 5 :
						System.out.println("Case1");
						blnFlag = con.ContactsUI_Check(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.FN_manageLine_backbtnClick(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
				//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Contacts > Edit > Phone - Error verification Verifying if the user can
	 * enter only valid phone number while editing the saved contact.Contacts >
	 * Edit > Phone numberVerifying if the user is able to Edit the contact and
	 * save Created by Saranya Date : 1/10/2015
	 */

	public synchronized void Sprint26_FnEditcontact_ErrorMsg_ValidPhoneNO(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FN_Edit_InvaLidPhoneNoErrorMessageCheck(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
				//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}

	public synchronized void Sprint26_FnEditcontact_PhoneNumber_Save(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 9; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FnPhoneNumber_Save(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FN_manageLine_backbtnClick(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
				//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}

	/*
	 * Verifying if the user is able to edit contact and save phone type.
	 * Created by Manavi Date : 8/10/2015
	 */

	public synchronized void Sprint26_FN_EditContactAndSave(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {

			
			
			
					
			for (int iCount = 0; iCount < 9; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FnVerifyPhoneTypeField(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = con.FnEditUserPhoneType(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;

				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}

				//repfn.FnUpdateEndTest(runManagerInfoObj);

		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user is able to edit phone number and cancel saving the
	 * changes. Created by Manavi Date : 8/10/2015
	 */

	public synchronized void Sprint26_FN_EditPhoneNumber_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			
			
					
			for (int iCount = 0; iCount < 9; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FnVerifyPhoneNumberField(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = con.FnEditPhoneNumberAndCancel(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}

				//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Contacts > Edit > Remove phone number Verifying if the user is able to
	 * remove the existing number Created by Saranya Date : 1/10/2015
	 */

	public synchronized void Sprint26_FnEditcontact_Remove_PhoneNumber_Save(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 9; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FN_RemovePhoneNoClick(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FN_manageLine_backbtnClick(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
				//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}

	/*
	 * Contacts > Edit > Remove phone number and Cancel Verifying if the user is
	 * able to cancel removing the existing number Created by Saranya Date :
	 * 1/10/2015
	 */

	public synchronized void Sprint26_FnEditcontact_Remove_PhoneNumber_Cancel(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 9; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FN_RemovePhoneNoClick_Cancel(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FN_manageLine_backbtnClick(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;

				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
				//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user is able to add a new number Created by Manavi Date
	 * : 13/10/2015
	 */

	public synchronized void Sprint26_FN_AddNewNumber(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			
			
					
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FnAddNewNumber_Save(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}

				//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user is able to cancel adding a new number Created by
	 * Manavi Date : 13/10/2015
	 */

	public synchronized void Sprint26_FN_AddNewNumber_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			
			
					
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FnAddNewNumber_Cancel(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}

				//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user is able to edit user contact. Created by Manavi
	 * Date : 13/10/2015
	 */

	public synchronized void Sprint26_FN_EditContact(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			
			
					
			for (int iCount = 0; iCount < 9; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FnCheckUserDataFields(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FnEditContactAndVerify(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}

				//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user gets a confirmation pop-up on canceling after
	 * making changes. Created by Manavi Date : 14/10/2015
	 */

	public synchronized void Sprint26_FN_CancelWithConfirmation(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			
			
					
			for (int iCount = 0; iCount < 9; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FnCheckUserDataFields(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = con.FnEditContact_CancelAndVerify(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}

				//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user is not getting a confirmation pop-up on canceling
	 * without making changes. Created by Manavi Date : 14/10/2015
	 */

	public synchronized void Sprint26_FN_CancelWithoutConfirmation(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			
			
					
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FnCancelWithoutChangeAndGoBack(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}

				//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}

	/*
	 * Verifying if the user is able to delete a contact. Created by Manavi Date
	 * : 12/10/2015
	 */

	public synchronized void Sprint26_FN_DeleteContact(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			
			
					
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FnDeleteContact(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}

				//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user is able to cancel deleting a contact. Created by
	 * Manavi Date : 9/10/2015
	 */

	public synchronized void Sprint26_FN_DeleteContact_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			
			
					
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FnCancelContactDelete(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}

				//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user is able to modify address and save. Created by
	 * Manavi Date : 12/10/2015
	 */

	public synchronized void Sprint26_FN_ModifyAddress(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			
			
					
			for (int iCount = 0; iCount < 10; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FnCheckAddressField(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = con.FnCheckAddressFields(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = con.FnModifyAddress_Save(driver,runManagerInfoObj);
						break;
					case 9 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}

				//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user is able to cancel modifying the address. Created by
	 * Manavi Date : 12/10/2015
	 */

	public synchronized void Sprint26_FN_ModifyAddress_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			
			
					
			for (int iCount = 0; iCount < 10; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FnCheckAddressField(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = con.FnCheckAddressFields(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = con.FnModifyAddress_Cancel(driver,runManagerInfoObj);
						break;
					case 9 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}

				//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}

	/*
	 * Verifying if the user is able to add a new address Created by Manavi Date
	 * : 13/10/2015
	 */

	public synchronized void Sprint26_FN_AddAddress(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			
			
					
			for (int iCount = 0; iCount < 11; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FnVerifyAddAddressOption(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = con.FnClickAddAddress(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = con.FnCheckAddressFields(driver,runManagerInfoObj);
						break;
					case 9 :
						blnFlag = con.FnAddAddress_Save(driver,runManagerInfoObj);
						break;
					case 10 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}

				//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user is able to cancel adding a new address Created by
	 * Manavi Date : 13/10/2015
	 */

	public synchronized void Sprint26_FN_AddAddress_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			
			
					
			for (int iCount = 0; iCount < 11; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FnVerifyAddAddressOption(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = con.FnClickAddAddress(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = con.FnCheckAddressFields(driver,runManagerInfoObj);
						break;
					case 9 :
						blnFlag = con.FnAddAddress_Cancel(driver,runManagerInfoObj);
						break;
					case 10 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}

				//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user is able to delete the contact address. Created by
	 * Manavi Date : 14/10/2015
	 */

	public synchronized void Sprint26_FN_DeleteAddress(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			
			
					
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FnDeleteAddress_Save(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}

				//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user is able to cancel deleting the contact address.
	 * Created by Manavi Date : 14/10/2015
	 */

	public synchronized void Sprint26_FN_DeleteAddress_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			
			
					
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FnDeleteAddress_Cancel(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}

				//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	public synchronized void Sprint26_FnAddNewContactCancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnClickAddContact(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnAddNewContactCancel(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}

		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnCom_ThrowException(e,driver);
		}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
	}
	public synchronized void Sprint26_FnAddEmptyContactCancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnClickAddContact(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnAddEmptyContactCancel(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}

		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnCom_ThrowException(e,driver);
		}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
	}
	public synchronized void Sprint26_FnAddNewContactSave(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnClickAddContact(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnAddNewContactSave(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}

		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnCom_ThrowException(e,driver);
		}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
	}
	public synchronized void Sprint26_FnAddEmailSave(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 10; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FnVerifyAddEmailOption(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = con.FnClickAddEmailAddress(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = con.FnAddEmailAddressSave(driver,runManagerInfoObj);
						break;
					case 9 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}

		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnCom_ThrowException(e,driver);
		}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
	}
	public synchronized void Sprint26_FnAddEmailCancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FnAddEmailAddressCancel(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}

		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnCom_ThrowException(e,driver);
		}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
	}
	public synchronized void Sprint26_FnModifyEmailSave(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 9; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FnCheckEmailField(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = con.FnModifyEmailAddressSave(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}

		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnCom_ThrowException(e,driver);
		}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
	}
	public synchronized void Sprint26_FnModifyEmailCancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 9; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FnCheckEmailField(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = con.FnModifyEmailAddressCancel(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}

		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnCom_ThrowException(e,driver);
		}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
	}
	public synchronized void Sprint26_FnDeleteEmailSave(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FnDeleteEmailAddressSave(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}

		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnCom_ThrowException(e,driver);
		}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
	}
	public synchronized void Sprint26_FnDeleteEmailCancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FnDeleteEmailAddressCancel(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}

		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnCom_ThrowException(e,driver);
		}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
	}
	public synchronized void Sprint26_FnCheckInvalidEmail(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FnCheckInvalidEmail(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}

		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnCom_ThrowException(e,driver);
		}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
	}
	public synchronized void Sprint26_FnCheckEmailAllotment(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnClickAddContact(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnCheckEmailAllotment(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}

		} catch (Exception e) {
			System.err.println("Message : " + e.getMessage());
			System.err.println("Cause : " + e.getCause());
			repfn.FnCom_ThrowException(e,driver);
		}
			//repfn.FnUpdateEndTest(runManagerInfoObj);
	}

	/*
	 * Iteration-3 Priyanka[18-11-2015] This script verifies the UI of Add
	 * Contact window
	 */

	public synchronized void AddcontactUI(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 11; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FN_addcontactClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FNVerifyFNLNTitleCompany(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FN_addFurtherDetails(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FN_AddContact_Cancel(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
				//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the standard user is able to Access Voice Control Pannel
	 * Created by Saranya Date : 12/10/2015
	 */

	public synchronized void Sprint26_FN_StdUser_VoiceControlPanel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			
			
					
			for (int iCount = 0; iCount < 4; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FN_Access_AdminVoicePanel_StdandUser(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}
				//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user is able to add address to new contact and save
	 * Created by Manavi Date : 29/10/2015
	 */

	public synchronized void Sprint33_FN_VerifyAddAddress_NewContact_Save(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {

			
			
			
					
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnClickAddContact(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnAddContact_AddAddressSaveAndVerify(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}

				//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}

	/*
	 * Verifying if the user is able to add address to new contact and cancel.
	 * Created by Manavi Date : 29/10/2015
	 */

	public synchronized void Sprint33_FN_VerifyAddAddress_NewContact_Cancel(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {

		try {

			
			
			
					
			for (int iCount = 0; iCount < 6; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnClickAddContact(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnAddContact_AddAddressCancelAndVerify(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}

				//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}
	/*
	 * Verifying if the user is able to remove the address added to new contact.
	 * Created by Manavi Date : 30/10/2015
	 */

	public synchronized void Sprint33_FN_RemoveAddress_NewContact(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {

			
			
			
					
			for (int iCount = 0; iCount < 7; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnClickAddContact(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnAddContact_AddAddressSaveAndVerify(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnRemoveAddressAndSave(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}

			}

				//repfn.FnUpdateEndTest(runManagerInfoObj);
		}

		catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}

	}

	/*
	 * Verifying if the user is able to modify address and save. Created by
	 * Manavi Date : 12/10/2015
	 */

	public synchronized void Sprint33_FN_ModifyAddress(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			
			
					
			for (int iCount = 0; iCount < 10; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FnCheckAddressField(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = con.FnCheckAddressFields(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = con.FnModifyAddress_Save(driver,runManagerInfoObj);
						break;
					case 9 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}

				//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user is able to cancel modifying the address. Created by
	 * Manavi Date : 12/10/2015
	 */

	public synchronized void Sprint33_FN_ModifyAddress_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			
			
					
			for (int iCount = 0; iCount < 10; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FnCheckAddressField(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = con.FnCheckAddressFields(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = con.FnModifyAddress_Cancel(driver,runManagerInfoObj);
						break;
					case 9 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}

				//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user is able to add a new address Created by Manavi Date
	 * : 13/10/2015
	 */

	public synchronized void Sprint33_FN_AddAddress(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			
			
					
			for (int iCount = 0; iCount < 11; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FnVerifyAddAddressOption(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = con.FnClickAddAddress(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = con.FnCheckAddressFields(driver,runManagerInfoObj);
						break;
					case 9 :
						blnFlag = con.FnAddAddress_Save(driver,runManagerInfoObj);
						break;
					case 10 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}

				//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user is able to cancel adding a new address Created by
	 * Manavi Date : 13/10/2015
	 */

	public synchronized void Sprint33_FN_AddAddress_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			
			
					
			for (int iCount = 0; iCount < 11; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FnVerifyAddAddressOption(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = con.FnClickAddAddress(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = con.FnCheckAddressFields(driver,runManagerInfoObj);
						break;
					case 9 :
						blnFlag = con.FnAddAddress_Cancel(driver,runManagerInfoObj);
						break;
					case 10 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}

				//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user is able to delete the contact address. Created by
	 * Manavi Date : 14/10/2015
	 */

	public synchronized void Sprint33_FN_DeleteAddress(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			
			
					
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FnDeleteAddress_Save(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}

				//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	/*
	 * Verifying if the user is able to cancel deleting the contact address.
	 * Created by Manavi Date : 14/10/2015
	 */

	public synchronized void Sprint33_FN_DeleteAddress_Cancel(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			
					
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FnDeleteAddress_Cancel(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}

				//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}
	public synchronized void Sprint33_FN_ValidateAddressFormat(WebDriver driver, RunManagerInfo runManagerInfoObj) throws Exception {

		try {
			
			
			
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = con.FnContactLinkClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = con.FnContactsClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = con.FnOpenUserDetailsPage(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = con.FnOpenEditUserPage(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = con.FnValidateAddressField(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FnNavigateBackOverviewPage(driver,runManagerInfoObj);
						break;
				}

				if (!blnFlag) {
					repfn.FnCom_AbortExec(driver,runManagerInfoObj);
					break;
				}
			}

				//repfn.FnUpdateEndTest(runManagerInfoObj);
		} catch (Exception e) {
			repfn.FnCom_ThrowException(e,driver);
		}
	}

}