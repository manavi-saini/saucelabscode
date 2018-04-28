package com.charter.sb.testscripts;

import org.openqa.selenium.WebDriver;

import com.charter.sb.beans.RunManagerInfo;
import com.charter.sb.controllers.Initialization;
import com.charter.sb.services.CharterAppFunctions;
import com.charter.sb.services.ManageLinesService;
import com.charter.sb.utils.CommonFunctions;
import com.charter.sb.utils.ReportingFunctions;
import com.charter.sb.utils.RunManager;

public class ManageLines extends Initialization {
	RunManager cfn = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	CharterAppFunctions app = new CharterAppFunctions();
	CommonFunctions cnf = new CommonFunctions();
	public static boolean blnFlag = false;
	long startTime = System.currentTimeMillis();
	long endtime = System.currentTimeMillis();
	ManageLinesService ml=new ManageLinesService();
	
	

	/*
	 * Verifying if the user is able to view all the voice lines assigned in
	 * case of multiple voice lines. Verifying if the user is able to view the
	 * voice lines assigned when there is only a single line assinged. Created
	 * by Saranya Date : 9/30/2015
	 */
	public synchronized void Sprint25_FNManagePhoneLine_ListViewVerification(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
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
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnManageLinkClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = ml.FNMultiple_Single_LineAssigned(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
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
	// saranya[9/30/2015]

	/*
	 * Verifying the details displayed for each of the phone lines. Created by
	 * Saranya Date : 9/30/2015
	 */

	public synchronized void Sprint25_FNManagePhoneLine_Alias_NO_AssigedVerification(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			for (int iCount = 0; iCount < 9; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnManageLinkClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = ml.FNMultiple_Single_LineAssigned(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = ml.FN_CheckAliasLabel_List(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = ml.FN_CheckNumberLabel_List(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = ml.FN_CheckAssigmentLabel_List(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
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
	 * Verifying the details display for each of the phone lines if there is no
	 * information about the lines. Created by Saranya Date : 9/30/2015
	 */

	public synchronized void Sprint25_FnManageContact_Noalias_NoAssignCheck(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnManageLinkClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = ml.FNManageContactList(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = ml.FN_CheckNOAliasNAME_List(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = ml.FN_CheckNOAssigmentName_List(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
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
	 * Verifying if the user is able to line information on selecting any of the
	 * phone lines displayed in the page. Created by Saranya Date : 9/30/2015
	 */
	public synchronized void Sprint25_FnManageContact_EmbeddedWindowCheck(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			for (int iCount = 0; iCount < 9; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnManageLinkClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = ml.FNManageContactList(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = ml.FN_ManageContactNumber_EmbeddedWindowCheck(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = ml.FN_ManageLineFeildVerification(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FN_manageLine_backbtnClick(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
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
	 * Verifying if the user is able to go back to the Manage Lines list after
	 * selecting a phone line Created by Saranya Date : 9/22/2015
	 */
	public synchronized void Sprint25_FNManagePhoneLine_BackBtn(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnManageLinkClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = ml.FNManagePhoneLine_FirstContactCLick(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FN_manageLine_backbtnClick(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
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
	 * Verifying if the user is able to go to Edit Phone line pane after
	 * selecting a phone line Created by Saranya Date : 9/22/2015
	 */
	public synchronized void Sprint25_FNManagePhoneLine_EditModeVerification(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
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
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnManageLinkClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = ml.FNManageLine_EditPhoneLineWithoutChange(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
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
	 * Verifying if the user is displayed with all datapoints after selecting a
	 * phone line Created by Saranya Date : 9/22/2015
	 */
	public synchronized void Sprint25_FN_ManageLineFeildVerification(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnManageLinkClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = ml.FN_ManageContactNumber_EmbeddedWindowCheck(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = ml.FN_ManageLineFeildVerification(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.FN_manageLine_backbtnClick(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
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
	 * Verifying if the user is able to navigate to 'contacts' page from 'Manage
	 * Lines' page Created by Saranya Date : 9/22/2015
	 */
	public synchronized void Sprint25_FN_ManageLine_ContactPage_Navigation(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnManageLinkClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = ml.FN_ManageContactNumber_EmbeddedWindowCheck(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = ml.FN_ManageLineFeildVerification(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.FnContactsTabClick(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
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
	 * Verifying if the user is able to navigate back to Manage lines list
	 * Created by Saranya Date : 9/22/2015
	 */
	public synchronized void Sprint25_FnManageLine_NonActionableAreaClick(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnManageLinkClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = ml.FN_ManageContactNumber_EmbeddedWindowCheck(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = ml.FN_ManageLineFeildVerification(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = ml.FnNonActionableAreaClick(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
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
	 * Verifying if the user is able to cancel Editing Phone line without making
	 * any changes to the line information Created by Saranya Date : 9/21/2015
	 */
	public synchronized void Sprint25_FNManageLine_EditPhoneLineWithoutChange(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
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
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnManageLinkClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = ml.FNManageLine_EditPhoneLineWithoutChange(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FN_manageLine_backbtnClick(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
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
	 * Verifying if the user is able to cancel Editing Phone line by making any
	 * changes to the line informationn Created by Saranya Date : 9/21/2015
	 */
	public synchronized void Sprint25_FNManageLine_EditPhoneLineWithChange(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
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
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnManageLinkClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = ml.FNManageLine_EditPhoneLineWithChange(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
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
	 * Verifying if the user is able to Edit Phone line by adding alias name
	 * Created by Saranya Date : 9/21/2015
	 */
	public synchronized void Sprint25_FN_ManageLine_EditAlias_ExistingName(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
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
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnManageLinkClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = ml.FN_ManageLine_EditAlias_ExistingName(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
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
	 * Verifying if the user is able to Edit Phone line by modifying alias name
	 * Created by Saranya Date : 9/21/2015
	 */
	public synchronized void Sprint25_FN_ManageLine_EditAlias_NewName(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnManageLinkClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = ml.FN_ManageLine_EditAlias_NewName(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
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
	 * Verifying if the user is able to Edit Phone line by deleting alias name
	 * Created by Saranya Date : 9/21/2015
	 */
	public synchronized void Sprint25_FN_ManageLine_EditAlias_DeleteName(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnManageLinkClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = ml.FN_ManageLine_EditAlias_DeleteName(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
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
	 * Verifying if the user is able to create new assignment for the selected
	 * phone line and save it. Created by Saranya Date : 8/10/2015
	 */

	public synchronized void Sprint26_FN_AddingNewAssignLine(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			for (int iCount = 0; iCount < 9; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnManageLinkClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FN_UnassignContactListClick(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FN_NewAssignMentLinkClick(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.FN_NewAssignListClick(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FN_AssignmentFinalSave(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
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
	 * Verifying if the user is able to create new assignment for the selected
	 * phone line and cancel it. Created by Saranya Date : 8/10/2015
	 */
	public synchronized void Sprint26_FN_AddingNewAssignLine_cancel(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			for (int iCount = 0; iCount < 9; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnManageLinkClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FN_UnassignContactListClick(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FN_NewAssignMentLinkClick(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.FN_NewAssignListClick(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = ml.FN_NewAssignListClick_Cancel(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
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
	 * Verifying if the user is able to modify assignment for the selected phone
	 * line and cancel it Created by Saranya Date : 8/10/2015
	 */

	public synchronized void Sprint26_FN_ModifyingExistingLineCancel(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnManageLinkClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FN_RemoveAssignmentLink(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FN_RemoveAssignmentLineClick(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = ml.FN_ModifyLineCancelChanges(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
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
	 * Verifying if the user is able to un-assign phone line for the selected
	 * phone line
	 * 
	 * Created by Saranya Date : 7/10/2015
	 */

	public synchronized void Sprint26_FN_RemovePhoneLine_SaveButtonClick(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			for (int iCount = 0; iCount < 10; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnManageLinkClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FN_RemoveAssignmentLink(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FN_RemoveAssignmentLineClick(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.FN_CancelConfirmPopup(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FN_SaveButtonClick(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = app.FN_VerifyUnassignedPhoneNumber(driver,runManagerInfoObj);
						break;
					case 9 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
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
	 * Verifying if the user is able to un-assign phone line for the selected
	 * phone line and cancel it.
	 * 
	 * Created by Saranya Date : 7/10/2015
	 */

	public synchronized void Sprint26_FN_RemovePhoneLine_CancelButtonClick(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
		try {
			
			for (int iCount = 0; iCount < 8; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnManageLinkClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FN_RemoveAssignmentLink(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FN_RemoveAssignmentLineClick(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = ml.FN_ModifyLineCancelChanges(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
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
	 * Verifying if the user is able assign phone line to the user.
	 * 
	 * Created by Harpreet Kaur Date : 18/11/2015
	 */

	public synchronized void Sprint26_FN_AssignPhoneLine_Save(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			for (int iCount = 0; iCount < 9; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnManageLinkClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FN_UnassignContactListClick(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FN_NewAssignMentLinkClick(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.FN_NewAssignListClick(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = app.FN_AssignmentFinalSave(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
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
	 * Verifying if the user is able Cancel the changes made in assigning phone
	 * line to the user. Created by Manavi Date : 18/11/2015
	 */

	public synchronized void Sprint26_FN_AssignPhoneLine_Cancel(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			for (int iCount = 0; iCount < 9; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnManageLinkClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = app.FN_UnassignContactListClick(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = app.FN_NewAssignMentLinkClick(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = app.FN_NewAssignListClick(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = ml.FN_NewAssignListClick_Cancel(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
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
	 * Verifying if the user is able to view search bar in assign phone line
	 * page. Created by Manavi Date : 19/11/2015
	 */

	public synchronized void Sprint26_FN_AssignPhoneLine_VerifySearchBar(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
		try {
			
			for (int iCount = 0; iCount < 10; iCount++) {
				switch (iCount) {
					case 0:
						System.out.println("Case 0");
						blnFlag=app.UserLogin(driver,runManagerInfoObj);
						break;
					case 1 :
						blnFlag = app.FnOverviewPage(driver,runManagerInfoObj);
						break;
					case 2 :
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnManageLinkClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = ml.FNManageContactList(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = ml.FnCheckManageLinesList(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag = ml.FnEdit_AssisgnLine(driver,runManagerInfoObj);
						break;
					case 7 :
						blnFlag = ml.FnVerifyAssignedUser(driver,runManagerInfoObj);
						break;
					case 8 :
						blnFlag = ml.FnVerifySearchBar_AssignLine(driver,runManagerInfoObj);
						break;
					case 9 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
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
	 * Verify if the user is able to view Directory listing in the Line Info
	 * screen in the Manage Lines page and update the alias name Created by
	 * Saranya Date : 10/7/2015
	 */
	public synchronized void Sprint30_FN_ManageLine_NonEditDirectoryListing(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
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
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnManageLinkClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = ml.FN_ManageLine_NonEditDirectoryListing(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
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
	 * Verify if the user is able to view Directory listing in the Line Info
	 * screen in the Manage Lines page Created by Saranya Date : 12/9/2015
	 */
	public synchronized void Sprint30_FN_ManageLine_DirectoryListing(WebDriver driver,RunManagerInfo runManagerInfoObj) throws Exception {
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
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnManageLinkClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = ml.FN_ManageContactNumber_EmbeddedWindowCheck(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = ml.FN_ManageLine_DirectoryListVerification(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
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
	 * Verify if the user is able to view Directory listing in the Line Info
	 * screen in the Manage Lines page for an unlisted user * Created by Saranya
	 * Created by SaranyaDate : 12/9/2015
	 */

	public synchronized void Sprint30_FN_ManageLine_DirectoryListing_UnlistedLine(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {
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
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnManageLinkClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = ml.FN_ManageLine_UnListedLine_DirectoryList(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
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
	 * Verify whether Hold Music option is removed from Manage Lines. Created by
	 * Manavi Date : 03/11/2015
	 */

	public synchronized void Sprint33_FN_VerifyHoldMusicOption_ManageLines(WebDriver driver,RunManagerInfo runManagerInfoObj)
			throws Exception {

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
						blnFlag = app.FnVoiceClick(driver,runManagerInfoObj);
						break;
					case 3 :
						blnFlag = app.FnManageLinkClick(driver,runManagerInfoObj);
						break;
					case 4 :
						blnFlag = ml.FnOpenManageLineContact(driver,runManagerInfoObj);
						break;
					case 5 :
						blnFlag = ml.FnVerifyHoldMusicOption(driver,runManagerInfoObj);
						break;
					case 6 :
						blnFlag=app.CommonLogout(driver,runManagerInfoObj);
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

}