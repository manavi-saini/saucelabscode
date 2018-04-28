package com.charter.sb.resources;

public class MB_PageObjects {

//Saranya[9/14/2015]
	//Login //div[@ng-click='toggleDropDown($event)']/div[1]/i
	public static String LoginBtn="//i[@class='icon sb_ic_chevron_down ng-scope']";
	public static String LoginWindow="//form[@name='login']";
	public static String UserName="//form[@name='login']//input[@id='username']";
	public static String Password="//*[@id='password']";
    public static String Home_OverviewLabel="//h1[contains(.,'Overview')]";
	public static String SignInBtn="//form[@name='login']//button[.='Sign In' and @type='submit']";
	public static String signout="logout-header-btn";
	public static String AccountLoginText="//div[@class='account-sign-in-header ng-scope']";
	public static String Invalid_credentials_weakpwd="//span[@class='weak-password-header']";
	//Voice Link-ExportCall
	//public static String VoiceLink="//div[@ ng-if='has.phone']/a";
	public static String VoicePageVerification="//div[@ng-hide='loading.numbers']";
	public static String CallLogLink="//div[@ng-hide='loading.numbers']//div[@href='#/voice/call-logs/']";
	public static String VoiceExport_DownloadBtn="//button[@title='Download']";
	//public static String OverviewLink="//div[@role='menu']/div/ul/li[5]";
	
	
	//Saranya[10/14/2015]
	//Manage User Page:
	public static String ManageUserLink="//div[@activity='ACCOUNT_ADMINISTRATION']/a[.='Manage Users']";
	public static String List_of_Users="//div[@ng-click='toggleDetails($event, user)']";
	public static String Manage_UserNameLabel="//div[.='Name']";
	public static String Manage_UserRolesLabel="//div[.='Role']";
	public static String Manage_UserServiceLabel="//div[.='Services']";
	public static String User_NameList="//div[@ng-click='toggleDetails($event, user)']/div[contains(@class,'name')][1]";
	public static String User_RoleList="//div[@ng-click='toggleDetails($event, user)']/div[contains(@class,'role')]";
	public static String User_ServiceList="//div[@services='user.services']/span";
	
	
	//Manage User Details:
	public static String Arrow_DetailLink_User="//div[@ng-click='toggleDetails($event, user)']//div/i";
	public static String UserDetailpopup="//div[@id='sbDetailContent']/div[2]";
	public static String UserDetail_Label="//div[@id='sbDetailContent']/div[2]//div[.='User Details']";
	public static String UserDeatil_RoleLabel="//div[@id='sbDetailContent']/div[2]//div[.='Role']";
	public static String UserDetail_VoiceServiceLabel="//div[@id='sbDetailContent']/div[2]//div[.='Voice Service']";
	public static String UserDetail_Backbtn="//a[@ng-click='detailOptions.backFunction()']";
	public static String UserDetailList="//div[@class='sb-detail__row'][1]//div[contains(@class,'text-item')]";
	public static String UserDetail_EditBtn="//a[@ng-click='detailOptions.editFunction()']";
	
	//Saranya[9/16/2015]
	
	//Manage User Edit Mode
	
	public static String EditModeForm="//form[@name='editUserForm']";
	public static String EditMode_UsrDetails="//form[@name='editUserForm']/div[.='User Details']";
	public static String EditMode_SaveResetPassWordBtn="//button[@ng-click='sendResetPasswordLink()']";
	public static String EditMode_UserDetailsInfo="//form[@name='editUserForm']/div[.='User Information']";
	public static String EditMode_FirstNameLabel="//label[@for='contact-first-name']";//div[@name='contactName']/label[@for='contact-first-name']
	public static String EditMode_firstName="//input[@id='contact-first-name']";
	public static String EditMode_LastNameLabel="//label[@for='contact-last-name']";//div[@name='contactName']/label[@for='contact-last-name']
	public static String EditMode_LastName="//input[@id='contact-last-name']";
	public static String EditMode_PhoneLabel="//label[@for='contact-phone']";//div[@name='contactName']/label[@for='contact-phone']
	public static String EditMode_PhoneNumber="//input[@id='contact-phone']";
	
	public static String EditMode_EmailLabel="//label[@for='contact-email']";//div[@name='contactName']/label[@for='contact-email']";
	public static String EditMode_EmailId="//input[@id='contact-email']";
	public static String EditMode_UsrRoleLabel="//form[@name='editUserForm']/div[.='Role']";
	public static String EditMode_UserRoleDefault="//button[@aria-haspopup='true' and @type='button']";
	//Jhansi-cleanup
	public static String EditMode_AdminRole="//div[contains(@ng-repeat,'role')]/a[contains(@ng-click,'selectRole')]/span[contains(text(),'Administrator')]";	
	public static String EditMode_BillingTrans_role="//div[contains(@ng-repeat,'role')]/a[contains(@ng-click,'selectRole')]/span[contains(text(),'Billing')]";
	public static String EditMode_standardRole="//div[contains(@ng-repeat,'role')]/a[contains(@ng-click,'selectRole')]/span[contains(text(),'Standard')]";
	public static String EditMode_VoiceService="//form[@name='editUserForm']/div[.='Voice Service']";
	public static String EditMode_AddVoiceLineBtn="//button[contains(.,'Add Voice Line')]";
	public static String EditMode_NoVoiceLineMsg="//div[@message='MESSAGE.noAvailablePhoneLines']//span[@ng-if='!html']";
	public static String EditMode_DeleteLink="//a[@class='delete-link']";
	//Jhansi-cleanup
	public static String EditMode_SaveButton="//button[.='SAVE']";
			//"//button[contains(@ng-click,'saveFunction()') and .='SAVE']";
	//"//button[@ng-click='actionSheetOptions.saveFunction()']";

	public static String EditMode_CancelBtn="//a[@ ng-click='actionSheetOptions.cancelFunction()']";
	//Admin User role Change
	
	public static String UserDetail_Role="//div[@id='sbDetailContent']/div[2]/div[5]/div";//div[@id='sbDetailContent']/div[2]/div[5]/div[.='Administrator']";
  
	//Admin FirstNameLastName and Email Id change
	public static String UserNameAfterChange="//div[@id='sbDetailContent']/div[2]/div[3]/div/div[1]";
	public static String MobileNumberAfterChange="//div[@id='sbDetailContent']/div[2]/div[3]/div/div[4]";
	public static String EmaiIdAfterChange="//div[@id='sbDetailContent']/div[2]/div[3]/div/div[3]";
    public static String UserNameChange_ErrorFeild="//p[@ng-if='!options.useHtml']";
    public static String Confirmbtn="//button[.='CONFIRM']";
	public static String Cancelbtn="//div[@ng-if='modalOptions.showFooter']/a[.='CANCEL']";
    public static String ConfirmBtn="//button[@type='button' and .='CONFIRM']";
    
  ///Manavi - Sprint 26 - Edit User Details and Save
    public static String UserContactList="//div[@class='sb-edit__edit-items ng-scope']";
    public static String verifyContactsPage="//ul[@class='nav-left-list sb-options-toolbar-nav--left']/li[contains(text(),'Contacts')]";

   // public static String UserPageVerification="//ul[@class='nav-left-list sb-options-toolbar-nav--left']/li[@class='toolbar-main sb-tablet--hidden toolbar__section ng-binding ng-scope']";

   public static String UserPageVerification="//ul[@class='nav-left-list sb-options-toolbar-nav--left']/li[4]";

    public static String ManageLinesList="//div[@ng-repeat='line in model.lines | filter:isNotTollFree']";
    public static String ManageLinesEditPage="//div[@class='sb-detail-content sb-action-content']";
    public static String DeleteAssignmentLine="//button[@ng-click='deleteAssignment()']";
    public static String AssignedName="//button[@ng-click='deleteAssignment()']/following-sibling::div";
    public static String AddAssignmentLine="//button[@ng-click='addAssignment()']";
    public static String AssignLineUsersList="//form[@name='editLineAssignmentForm']//span";//div[@ng-repeat='user in filteredUsers = (users | filter:users.search:false)']";
    public static String AssignLineRadioButtons="//input[@name='assignedUser']";
    public static String AssignLineUsersName="//input[@name='assignedUser']/following-sibling::span";
    //public static String AssignLineSearchBar="//div[@sb-search-bar='sb-search-bar']/input";
    public static String AssignLineSearchBar="//div[@class='search-bar-input-container']/input[@class='searchBarInput ng-pristine ng-untouched ng-valid ng-valid-maxlength']";
    public static String ManageLineAliasName="//div[@ng-repeat='line in model.lines | filter:isNotTollFree']/div[@class='sb-voice-line-column--alias ng-binding']";
    public static String ManageLineAliasNameText="//input[@title='Alias']";
    public static String AssignPerson="//div[@ng-if='model.line.isAssigned && !model.line.isTollFree']";
    public static String CancelAssignment="//div[@ng-if='!secondaryActionSheetOptions.hideHeaderRow']//a[@ng-click='secondaryActionSheetOptions.cancelFunction()']";
    public static String EditModeUserForm="//form[@name='addContactForm']";
    public static String EditModeUserPhoneType="//button[@ng-if='phoneNumberTypes.length > 0' and contains(@class,'dropdown-toggle')]";
    public static String EditModeUserPhoneTypeInput="//div[@ng-if='phoneNumberTypes.length === 0']";
    //public static String EditModeUserPhoneTypeList="//a[@ng-click='selectPhoneType($event, $index, number, phoneNumberType)']";
    public static String UserContactDetailsSave="//button[@ng-click='actionSheetOptions.saveFunction()']";
    public static String UserContactPhoneTypeDisplay="//div[@ng-repeat='line in model.contactDetails.phoneNumbers']/div[@class='sb-detail__detail-text']/div[@class='sb-detail__header-text ng-binding']";
    public static String UserContactPhoneNumberDisplay="//div[@ng-repeat='line in model.contactDetails.phoneNumbers']/div[@class='sb-detail__detail-text']/div[@class='sb-detail__text-item ng-binding']";
    public static String UserContactPhoneNumber="//div[@class='sb-detail__text-input-container phone-number']/input";
    public static String CancelEdit="//a[@ng-click='actionSheetOptions.cancelFunction()']";
    public static String ConfirmCancel="//button[@ng-if='modalOptions.buttonText && modalOptions.buttonOmniture' and @ng-click='primaryButtonFunction ? primaryButtonFunction($event) : $close()']";
    public static String addNewPhone="//button[@ng-click='addPhoneNumberRow($event)']/i";
    public static String phoneTypeHome="//a[@ng-click='selectPhoneType($event, $index, number, phoneNumberType)']/span[contains(text(),'Home')]";
    public static String phoneTypeWork="//a[@ng-click='selectPhoneType($event, $index, number, phoneNumberType)']/span[contains(text(),'Work')]";
    public static String phoneTypeCell="//a[@ng-click='selectPhoneType($event, $index, number, phoneNumberType)']/span[contains(text(),'Cell')]";
    public static String phoneTypeOffice="//a[@ng-click='selectPhoneType($event, $index, number, phoneNumberType)']/span[contains(text(),'Office')]";
    public static String phoneTypeOther="//a[@ng-click='selectPhoneType($event, $index, number, phoneNumberType)']/span[contains(text(),'Other')]";
    public static String deleteContact="//a[@class='delete-link' and @ng-click='confirmDeleteContact(model.contactDetails)']";
    public static String contactNameList="//div[@class='single-content-name ng-binding']";
    public static String deletePhoneNumber="//button[@ng-click='deletePhoneNumberRow($event, $index, number)']/i";
    public static String deleteAddress="//button[@ng-click='deleteAddress($index)']/i";
    public static String addressCount="//div[@ng-repeat='address in model.contactDetails.addresses']";
    public static String addAddress="//button[@ng-click='addAddress()']/i";
    public static String addEmail="//button[@ng-click='addEmailAddress()']/i";
    public static String addressStreetLabel="//label[@class='sb-detail__label' and contains(text(),'Street')]";
    public static String addressStreet="//input[@id='contact-street-1-0' and @ng-model='address.street']";
    public static String cityLabel="//label[@class='sb-detail__label' and contains(text(),'City')]";
    public static String city="//input[@id='contact-city-0' and @ng-model='address.locality']";
    public static String stateLabel="//label[@class='sb-detail__label' and contains(text(),'State')]";
    public static String state="//input[@id='contact-state-0' and @ng-model='address.region']";
    public static String zipLabel="//label[@class='sb-detail__label' and contains(text(),'Zip')]";
    public static String zip="//input[@id='contact-zip-0' and @ng-model='address.postalCode']";
    public static String countryLabel="//label[@class='sb-detail__label' and contains(text(),'Country')]";
    public static String country="//input[@id='contact-country-0' and @ng-model='address.country']";
    
    public static String addressStreet1="//input[@id='contact-street-1-1' and @ng-model='address.street']";
    public static String city1="//input[@id='contact-city-1' and @ng-model='address.locality']";
    public static String state1="//input[@id='contact-state-1' and @ng-model='address.region']";
    public static String zip1="//input[@id='contact-zip-1' and @ng-model='address.postalCode']";
    public static String country1="//input[@id='contact-country-1' and @ng-model='address.country']";
    
    public static String ContactTitle="//input[@id='contact-title']";
    public static String ContactCompany="//input[@id='contact-company']";
    public static String EmailList="//input[@name='email' and @ng-model='model.contactDetails.emailAddresses[$index]']";
    public static String AddressList="//div[@ng-repeat='address in model.contactDetails.addresses']/fieldset/div";
    public static String Email="//div[@name='email' and @ng-model='model.contactDetails.emailAddresses[$index]']";
    public static String deleteAddressButton="//button[@type='button' and @ng-click='deleteAddress($index)']";
    public static String personalDetailVerificationSection="//div[@class='sb-detail__row']/div";
    public static String personalDetailVerificationName="//div[@class='sb-detail__row']/div/div[1]";
    public static String personalDetailVerificationTitle="//div[@class='sb-detail__row']/div/div[2]";
    public static String personalDetailVerificationCompany="//div[@class='sb-detail__row']/div/div[3]";
    public static String personalDetailVerificationOne="//div[@class='sb-detail__row']/div/div/div[1]";
    public static String emailAddressHeading="//div[@class='sb-detail__section-header sb-detail__header-text' and contains(text(),'Email')]";
    public static String emailAddressVerification="//div[@ng-repeat='email in model.contactDetails.emailAddresses']/div/div/a";
    public static String personalContactLink="//div[@ng-click='openDetails($event, contact)']/div[contains(text(),'Ruchi Dallas')]/following-sibling::div[@class='details-link pull-right']/i";
    public static String UserAddressVerification="//div[@ng-repeat='address in model.contactDetails.addresses']/div[@class='sb-detail__detail-text']";
    public static String UserAddressStreetVerification="//div[@ng-repeat='address in model.contactDetails.addresses']/div[@class='sb-detail__detail-text']/div[1]";
    public static String UserAddressCountryVerification="//div[@ng-repeat='address in model.contactDetails.addresses']/div[@class='sb-detail__detail-text']/div[3]";
    public static String UserAddressVerification1="(//div[@ng-repeat='address in model.contactDetails.addresses']/div[@class='sb-detail__detail-text'])[2]";
    public static String UserAddressStreetVerification1="(//div[@ng-repeat='address in model.contactDetails.addresses']/div[@class='sb-detail__detail-text']/div[1])[2]"; 
    //Manavi - Sprint 27
    public static String verifyMessagesPage="//ul[@class='nav-left-list sb-options-toolbar-nav--left']/li[contains(text(),'Messages')]";
    public static String showDeleteMessages="//button[@title='Deleted Messages' and @href='#/voice/messages//messages/deleted/']";
    public static String deletedMessagesList= "//div[@class='ng-binding sb-unread col-xs-12.col-md-7 text--style-r16-2 voice-message-number-text']";
    public static String deletedFaxMessagesList  ="//div[@ng-if='message.messageType === UICONSTANTS.VOICE_MESSAGE_FAX']/ancestor::div[@class='sb-panel--column sb-panel--second-column']/following-sibling::div[@class='sb-panel--column sb-panel--third-column']/div";
    //public static String deletedMessagescheckbx ="//div[@ng-if='message.messageType === UICONSTANTS.VOICE_MESSAGE_VOICEMAIL']/ancestor::div[@class='sb-panel--column sb-panel--second-column']/preceding-sibling::div[@class='sb-panel--column sb-panel--first-column']/label/input";
    public static String deletedMessagescheckbx ="//div[@ng-if='message.messageType === UICONSTANTS.VOICE_MESSAGE_VOICEMAIL']/ancestor::div[@class='sb-panel--column sb-panel--second-column']/preceding-sibling::div[@class='sb-panel--column sb-panel--first-column']/label/div/i";
    public static String deletePermanent="//button[@title='Delete Permanently']";
    public static String permanentDelete="//button[@title='Permanently Delete']";
   // public static String selectAll="//input[@type='checkbox' and @ng-change='massSelect()']";
    public static String selectAll="//div[@class='select-all-column']//label[@class='sb-checkbox__clickable-area']//i";
    public static String backToMessages="//a[@ui-sref='voice.messages()' and @href='#/voice/messages/']";
    public static String CancelDelete="//a[@ng-click='secondaryButtonFunction ? secondaryButtonFunction($event) : $dismiss()']";
    public static String CancelDeleteTemp="//a[@ng-click='secondaryButtonFunction($event) || $dismiss()']";
    public static String VoiceSettingsButton="//button[@class='settings-button sb-btn sb-btn--alternate sb-btn--icon dropdown-toggle']";
    public static String CallForward="//div[@ng-transclude='ng-transclude']/div[5]//ul[1]/li[2]/div";
    public static String CallForwardOnOff="//div[@ng-transclude='ng-transclude']/div[5]//div[@ng-controller='voiceSettingsCtrl']//li[contains(.,'Forward All Calls')]/div/div[2]/span[2]";
    public static String toggleSwitch="//div/span[@class='sb-toggle-switch__handle']";
    public static String cancelForwardSettings="//a[@ng-click='confirmCancel(true)']";
    public static String saveForwardSettings="//button[@ng-click='saveSettings()']";
    public static String forwardMethod="//div[@sb-toggle-switch-text='sb-toggle-switch-text']/button/span";
    public static String forwardCallNumberDropDown="//div[@ng-click='showDropdown()']";
    public static String forwardCallNumberDropDownList="//ul[@ng-if='showSelectableLines']/li";
    public static String manageForwardLines="//button[@ng-click='manageForwardingLines()']";
    public static String Voice_Pdf="(//div[@ng-if='message.messageType === UICONSTANTS.VOICE_MESSAGE_FAX']/ancestor::div[@class= 'sb-panel--column sb-panel--second-column']/ancestor::div[@ng-click='toggleCollapse($event, message, $index)'])";
    public static String Voice_PdfBlock="//*[@id='message-details-section']/div[2]/span[2]/a[@ng-click='confirmBlockNumber(message); stopCollapseToggle($event)']";
    public static String Voice_Delete="//*[@id='message-details-section']/div[2]/span[3]/a[contains(text(),'Delete')]";
    public static String Voice_Recover="//*[@id='message-details-section']/div[2]/span[4]/a[contains(text(),'Recover')]";
    public static String selectFaxMessage="//div[@ng-if='message.messageType === UICONSTANTS.VOICE_MESSAGE_FAX']/ancestor::div[@class= 'sb-panel--column sb-panel--second-column']/preceding-sibling::div/label/input";
    public static String Billing_Link="//div[@activity='BILLING_ADMINISTRATION']/a[@href='/smb/billing.html#/billing/view-statements']";
    public static String Close_pin_option ="//span[@ng-if='!formData.pin.dirty && !formData.confirmPin.dirty']";
    
    public static String PayBill_Checking_Savings="//div[@class='radio']/label[@for='checkingSavingsAccount']/div[1]/div";
    public static String PayBill_Credit_Debit="//div[@class='radio']/label[@for='creditDebitCard']/div[1]/div";
    public static String PayBill_Credit_Debit_Selection="//div[@class='radio']/label[@for='creditDebitCard']/input[@id='creditDebitCard']";
    public static String PaymentFrequency_OneTime="//div[@class='radio']/label[@for='oneTime']/div[1]/div";
    public static String PaymentFrequency_OneTime_Selection="//div[@class='radio']/label[@for='oneTime']/div[1]/preceding-sibling::input";
    public static String PaymentFrequency_AutoPay="//div[@class='radio']/label[@for='autoPay']/div[1]/div";
    public static String PaymentFrequency_AutoPay_Selection="//div[@class='radio']/label[@for='autoPay']/input[@id='autoPay']";
    public static String RoutingNumber="//div[@class='sb-cell-content']/fieldset[2]/div/div[@class='sb-account-input']/input[1]";
    public static String RoutingNumberError="//*[@id='routingNumberError']";
    public static String PayNowButton="//button[@type='submit' and contains(text(),'PAY')]";
    public static String PayNowButton_WG="//button[@type='submit']";
    public static String ViewStatementsLink="//div[@class='sb-nav-menu__nav-row']/div[@href='#/billing/view-statements']";
    public static String PaymentInformationHeader="//div[@class='sb-section-header ng-scope' and contains(text(),'Payment Information')]";
    public static String BankAccountNumber="//div[@class='sb-cell-content']/fieldset[2]/div/div[@class='sb-account-input']/input[2]";
    public static String BankAccountNumberError="//*[@id='accountNumberError']";
    public static String PaymentAmount="//*[@id='paymentAmount']";
    public static String PaymentDate ="//*[@id='paymentDate']";
    public static String PaymentDateError="//*[@id='paymentDateError']/div";
    public static String PaymentAmountError="//*[@id='paymentAmountError']/div";
    public static String DatePickerButton="//button[@ng-click = 'showDatepicker($event)']";
    public static String DatePicker="//div[@ng-switch='datepickerMode']";
    public static String DatePickerRows="//div[@ng-switch='datepickerMode']/table/tbody/tr";
    public static String SupportLinkPayBill="//a[@ng-click='navigate(URL.CMS_SUPPORT)']";
    public static String EnrollAutoPay="//a[@href='/smb/billing.html#/billing/pay-bill?enrollAutopay=true']/div";
    public static String AutoPayEnabled="//div[@ng-show='autoPayEnrolled']/div[1]/a[@href='/smb/billing.html#/billing/pay-bill']/i";
    public static String VerifyPayementPage="//*[@id='iFrameResizer0']";
    		//"//*[@id='content-container']/main/div[1]/div[2]/div[1]";
    
    
    public static String VerifyPaymentPageOne="//div[@class='sb-floating-panel ng-scope']/div[1]";
    public static String VerifyPaymentPage_RoutingNumber="//div[@class='col-xs-12 col-sm-6 ng-scope']/div[1]/div[2]/span";
    public static String VerifyPaymentPageOne_AccountNumber="//div[@class='col-xs-12 col-sm-6 ng-scope']/div[2]/div[2]/span";
    public static String VerifyPaymentPageOne_PaymentAmount="//div[@class='col-xs-12 col-sm-6']/div[1]/div[2]/span";
    public static String VerifyPaymentPageOne_PaymentDate="//div[@class='col-xs-12 col-sm-6']/div[2]/div[2]/span";
    public static String EditPaymentDetailsLink="//a[@href='#/pay-bill/options' and contains(text(),'Edit Payment Details')]";
    public static String CardNumber="//div[@class='sb-cell-content']/fieldset/div[1]/input";
    public static String CardNumberError="//div[@id='creditCardNumberError']/div";
    public static String ExpirationDate="//input[@id='expirationDate']";
    public static String ExpirationDateError="//div[@id='expirationDateError']/div";
    public static String VerifyPaymentPage_CardNumber="//div[@class='col-xs-12 col-sm-6 ng-scope']/div[1]/div[2]/span";
    public static String VerifyPaymentPageOne_ExpirationDate="//div[@class='col-xs-12 col-sm-6 ng-scope']/div[2]/div[2]/span";
    
    public static String CreditPaymentDueDate_OverviewPage="//div[@ng-if='!model.currentBill.autoPayEnrolled']/div[2]/div[@class='text--style-r14-3 text-gray-1']/span";
    public static String CreditPaymentDueDate_NoDueDate="//*[@id='smbNotificationsPanel']/div[2]/div/div[2]/span";
    public static String CurrentBalanceDueText_ViewStatements="//div[@ng-if='model.isCurrentStatement && !errors.billingStatus']/div[1]";
    public static String CurrentBalanceDueAmount_ViewStatements="//div[@ng-if='model.isCurrentStatement && !errors.billingStatus']/div[3]";
    
    public static String PayBill_PayBillOptionsText="//div[@class='sb-floating-panel sb-row-bottom-border ng-scope']/div[@class='sb-section-header']";
    public static String PayBill_SelectPaymentTypeText="//div[@class='sb-three-col-cell sb-col-border']/div[@class='sb-cell-content']/fieldset/h4";
    public static String PayBill_Credit_Debit_Text="//div[@class='radio']/label[@for='creditDebitCard']";
    public static String PayBill_Checking_Savings_Text="//div[@class='radio']/label[@for='checkingSavingsAccount']";
    public static String PayBill_OtherPaymentMethods_Text="//div[@class='radio']/label[@for='other']";
    public static String PayBill_SelectPaymentFrequencyText="//h4[.='Select Payment Frequency']";//div[@class='sb-three-col-cell sb-second-col']/div[@class='sb-cell-content']/fieldset/h4";
  //  public static String PaymentFrequency_OneTime_Text="//input[@id='oneTime' and @value='false']";//div[@class='radio']/label[@for='oneTime']";
   // public static String PaymentFrequency_AutoPay_Text="//input[@id='autoPay' and @aria-checked='false']";//div[@class='radio']/label[@for='autoPay']";
    public static String PaymentFrequency_OneTime_Text="//label[@for='oneTime']";//div[@class='radio']/label[@for='oneTime']";
    public static String PaymentFrequency_AutoPay_Text="//label[@for='autoPay']";//div[@class='radio']/label[@for='autoPay']"; 	
    public static String PayBill_Credit_DebitCard_Text="//div[@class='sb-three-col-cell sb-col-border']/div[@class='sb-cell-content']/h4";
    public static String PayBill_BankInformation_Text="//div[@class='sb-three-col-cell sb-col-border']/div[@class='sb-cell-content']/h4";
    public static String PayBill_AccountType_Text="//form[@name='forms.paymentInfoEFTForm']/div[1]/div[1]/div/fieldset[1]/legend";
    public static String PayBill_Checking_Text="//form[@name='forms.paymentInfoEFTForm']/div[1]/div[1]/div/fieldset[1]/div/div[1]/label";
    public static String PayBill_Checking_RadioButton="//form[@name='forms.paymentInfoEFTForm']/div[1]/div[1]/div/fieldset[1]/div/div[1]/label[@for='checkingAccount']/div[1]/div";
    public static String PayBill_Savings_Text="//form[@name='forms.paymentInfoEFTForm']/div[1]/div[1]/div/fieldset[1]/div/div[2]/label";
    public static String PayBill_Savings_RadioButton="//form[@name='forms.paymentInfoEFTForm']/div[1]/div[1]/div/fieldset[1]/div/div[2]/label[@for='savingsAccount']/div[1]/div";
    public static String PayBill_RoutingNumberText="//form[@name='forms.paymentInfoEFTForm']/div[1]/div[1]/div/fieldset[2]/div/div[1]/label[1]/span[1]";
    public static String PayBill_RoutingNumberToolTip="//form[@name='forms.paymentInfoEFTForm']/div[1]/div[1]/div/fieldset[2]/div/div[1]/a[1]/i";
    public static String PayBill_AccountNumberText="//form[@name='forms.paymentInfoEFTForm']/div[1]/div[1]/div/fieldset[2]/div/div[1]/label[2]";
    public static String PayBill_AccountNumberToolTip="//form[@name='forms.paymentInfoEFTForm']/div[1]/div[1]/div/fieldset[2]/div/div[1]/a[2]/i";
    public static String PayBill_CardImage="//form[@name='forms.paymentInfoEFTForm']/div[1]/div[1]/div/fieldset[2]/div/div[2]/img";
    public static String PayBill_CardNumber_Text="//div[@class='sb-three-col-cell sb-col-border']/div/fieldset/div[@class='cc-no-box']/label";
    public static String PayBill_CardNumber_RequiredText="//div[@class='sb-three-col-cell sb-col-border']/div/fieldset/div[@class='cc-no-box']/label[@class='sb-input--label required']";
    public static String PayBill_ExpirationDate_Text="//div[@class='sb-three-col-cell sb-col-border']/div/fieldset/label";
    public static String PayBill_ExpirationDate_RequiredText="//div[@class='sb-three-col-cell sb-col-border']/div/fieldset/label[@class='sb-input--label required']";
    public static String PayBill_AmountAndDate_Text="//div[@class='sb-three-col-cell sb-second-col']/div/div[@class='sb-cell-content ng-scope']/h4";
    public static String PayBill_AmountDue_Text="//div[@class='sb-three-col-cell sb-second-col']/div/div[@class='sb-cell-content ng-scope']/fieldset/div[1]/div/label";
    public static String PayBill_AmountDue="//div[@class='sb-three-col-cell sb-second-col']/div/div[@class='sb-cell-content ng-scope']/fieldset/div[1]/div/div/div[@class='current-amt ng-binding']";
    public static String PayBill_DueBy_Text="//div[@class='bill-status']/span/span[@ng-if='billStatus && dueDate']/span[1]";
    public static String PayBill_DueByDate="//div[@class='bill-status']/span/span[@ng-if='billStatus && dueDate']/span[2]/span";
    public static String PayBill_PaymentAmount_Text="//div[@name='forms.paymentAmtDateForm']/div[1]/label[@for='paymentAmount']";
    public static String PayBill_PaymentAmount_RequiredText="//div[@name='forms.paymentAmtDateForm']/div[1]/label[@class='sb-input--label required']";
    public static String PayBill_PaymentDate_Text="//div[@name='forms.paymentAmtDateForm']/div[2]/label[@for='paymentDate']";
    public static String PayBill_PaymentDate_RequiredText="//div[@name='forms.paymentAmtDateForm']/div[2]/label[@class='sb-input--label required']";
    public static String PaymentFrequency_AutoPayOption="//div[@class='radio']/label[@for='autoPay']/div[1]/div";
    public static String PaymentFrequency_AutoPayOption_Selection="//div[@class='radio']/label[@for='autoPay']/input[@id='autoPay']";
    public static String PaymentFrequency_AutoPayOption_InfoIcon="//div[@class='radio']/a[@ng-if=' state.disableAutoPay ']/i";
    public static String ViewStatements_ToolTip="//a[@ng-click='openToolTip(charge.summaryDisplay, charge.description)']/i";
    public static String ViewStatements_StatementDropdown="//div[@class='btn-group statement-select ng-scope']/div[@class='dropdown']/button";
    public static String ViewStatements_DownloadStatementButton="//div[@sb-universal-toolbar='sb-universal-toolbar']/div[2]/div[7]/button";
    public static String Routing_Number_Required_Text= "//label[@for='routingNumber']";
    public static String Account_Number_Required_Text="//*[@id='content-container']/main/div[2]/div/div[2]/div/div/div/form/div[1]/div[1]/div/fieldset[2]/div/div[1]/label[2]";
    	public static String SaveNotWorkingText	="//*[@title='Close Block Message']";
    //public static String ViewStatements_StatementDropdown="//div[@class='btn-group statement-select ng-scope']/div[@class='dropdown']/button";
    
    		//"//div[contains(text(),'Verify Payment Information')]";
    // Manavi - Sprint 28
    public static String Support_Link="//div/a[contains(@href,'/support')]";//div[@class='sb-nav-item header-support-item hidden-xs']/a[@ng-href='http://www.proto-spectrumbusiness.freeddns.org/support']";
    public static String SupportPageVerification="//img[@src='/support/assets/images/site/support-search-background.png']";
    public static String SupportPageVerificationOne="//div[@class='support-hero']/div/h1";
    public static String LoggedInUser="//div[@class='sb-nav-list nav navbar']/div[3]/div[1]";
    public static String CompanyProfile_Link="//div[@activity='ACCOUNT_ADMINISTRATION']/a[@href='/smb/company.html']";
    public static String PageVerificationOne="//ul[@class='nav-left-list sb-options-toolbar-nav--left']/li[2]";
    public static String PageVerificationTwo="//ul[@class='nav-left-list sb-options-toolbar-nav--left']/li[4]";
    public static String SpectrumBusinessLogo="//img[@title='Spectrum Business logo' and @class='logo']";
    public static String IndexPageVerification="//div[@class='error-message-container']//div[@ng-if='isLoggedIn']";
    public static String SignInLink="//a[@href='/login.html#/login']";
    public static String SignInPageVerification="//div[contains(@ng-if,'!isIndexPage')]/div/h5";
    public static String MyProfile_Link="//div[@class='sb-overview__tile-wrapper']/a[@href='/smb/profile.html']";
    public static String SecuritySettingsLink="//div[@class='sidenav-main-links']/div[2]/div[@href='#/profile/security-settings']";
    public static String ProfileLink="//div[@class='sidenav-main-links']/div[1]/div[@href='#/profile/my-profile']";
    public static String SSPasswordField="//input[@id='password']";
    public static String SSRetypePasswordField="//input[@id='passwordConfirmation']";
    public static String clearInput="//span[@ng-mousedown='clearInput($event)']";
    public static String PayBillSideLink="//div[@class='sb-nav-menu__nav-row']/div[@href='#/billing/pay-bill/']";
    public static String PayNow_ViewStatements="//a[contains(@href,'billing/pay-bill') and contains(text(),'PAY')]";
   
    public static String SecurityQuestion_AnswerHeading="//h1[contains(.,'Security Question')]";//div[@class='sb-profile-subpage ng-scope ng-isolate-scope']/h1[2]";
    public static String SecurityQuestionText="//div[@for='question']";//form[@name='form.changeQuestionForm']/div[2]/fieldset[1]/div[@for='question']";
    public static String SecurityQuestionInput="//select[@id='question']";
    public static String SecurityAnswerText="//div[@for='answer']";//form[@name='form.changeQuestionForm']/div[2]/fieldset[2]/div[@for='answer']";
    public static String SecurityAnswerInput="//input[@id='answer']";
    public static String SecurityQASaveButton="//form[@name='form.changeQuestionForm']/div[3]//button[@type='submit']";//form[@name='form.changeQuestionForm']/div[3]/div[@class='sb-company-profile-btns']/button";
    public static String SecurityQARequiredText="//form[@name='form.changeQuestionForm']/div[1]/div/div/div";
    
    public static String Unblock_Check="//a[@ng-click='unblockNumber(details.phoneNumber)']";

    
    //Jhansi[09/30/2015]
    public static String CallLog_SearchBar="//input[@placeholder='Search']";
    //"//input[@class='ng-pristine ng-untouched ng-valid ng-valid-maxlength']";
    
    public static String CallLog_SearchIcon_MagnifyingGlass="//button[@class='sb-btn sb-btn--icon']/i";
    public static String CallLog_AllFilter="//a[@id='dropdownXsFilterDropdown']";
    public static String CallLog_AllFilter_Dropdown="//ul[@id='dropdownXsFilterDropdownMenu']";
    public static String CallLog_AllFilter_Dropdown_Options="//ul[@id='dropdownXsFilterDropdownMenu']/a/span";
    public static String CallLog_AllFilter_Dropdown_All="//a[@ng-click='updateFilter(all)']";
    public static String CallLog_SearchBar_XIcon="//button[@ng-click='reset()']";
    public static String CallLog_AllFilter_FN_FilteredList="//div[@title='Open Details']";
    public static String CallLog_AllFilter_FN_FilteredListName="//div[@ng-class='selectedClass(call.callId)']/div[2]/div[1]";
	
 // Manavi - Sprint 25
 	public static String SearchField="//input[@placeholder='Search']";
     public static String clearSearchField="//button[contains(@class,'clear-input')]/i";
     public static String CityState="//div[@class='sb-detail__detail-text']/div[2]";
     
     // Manavi - Sprint 31
  	public static String ExportCallLogButton="//button[@ng-click='exportCallLog()']";
  	public static String ExportCallPopupTitle="//div[@ng-if='modalOptions.showHeader']/h2[@id='modalTitle']";
  	public static String ExportCallDownloadDateInfo="//div[@class='modal-body']/div/p[@class='text--style-r16-4 ng-binding']";
  	public static String ExportCallFunctionInfo="//div[@class='modal-body']/div/p[@id='phoneExportModalDesc']";
  	public static String ExportCallEmailHeading="//form[@name='forms.contactEmailForm']/div/label[@for='emailInput']";
  	public static String ExportCallEmailInputField="//form[@name='forms.contactEmailForm']/div/input[@id='emailInput']";
  	public static String ExportCallCancelOption="//div[@ng-if='modalOptions.showFooter']/a[@ng-click='secondaryButtonFunction ? secondaryButtonFunction($event) : $dismiss()']";
  	public static String ExportCallExportOption="//div[@ng-if='modalOptions.showFooter']/button[@ng-click='primaryButtonFunction ? primaryButtonFunction($event) : $close()']";
  	public static String ForwardingManagerLink="//div[@ng-hide='loading.numbers']//div[@href='#/voice/forwarding-manager']";
  	public static String CallLogDownloads_CallLogDetailsText="//div[@class='section-head-container']/h1[@class='sb-section-header']";
  	public static String CallLogDownloads_CallLogInfoText="//div[@class='billing-module single-module']/p[@class='downloads-call-log-info']";
  	public static String CallLogDownloads_DownloadCSVLink="//a[@ng-click='downloadCSV(callLog.url)']";
  	public static String CallLogDownloads_DateColumn="//div[@ng-if='hasDownloads']/div[1]/div[1]";
  	public static String CallLogDownloads_StatusColumn="//div[@ng-if='hasDownloads']/div[1]/div[2]";
  	public static String CallLogDownloads_RefreshButton="//button[@ng-click='getCallLogStatus()' and contains(text(),'Refresh')] ";
  	public static String ManageUsers_VoiceService="//div[@class='sb-manage-users-list-column--assignment']/div/span[@class='service-icon-set service-icon-set--voice ng-scope']/span";
    
    // Manavi - Sprint 33
    public static String payBill_Link_V1="//div[@ng-show='!autoPayEnrolled && !hidePayBill']/a[@ng-href='./pay-bill.html']";
    public static String PageVerification_V1="//div[@class='container']/h5";
    public static String payBill_Link_V2="//div[@class='sb-spaced-row']/a[@ng-href='/smb/billing.html#/billing/pay-bill']";
    		
    		//"//div[@class='sb-spaced-row']/a[@ng-href='/smb/billing.html#/billing/pay-bill']";
    public static String ManageLineHeaderText="//div[@class='sb-detail__section-header sb-detail__header-text']";
    
    // Manavi - Q2 Wall of Garden
    public static String Q2Wall_ServiceAnnPageVerification="//div[@ng-bind-html='serviceAnnouncement']";
    public static String Q2Wall_SignInLink="//a[@ng-click='signIn()']";
    public static String Q2Wall_SpectrumBusinessLogo="//div[@class='sb-nav-item']/img[@title='Spectrum Business logo']";
    public static String Q2Wall_SignInPageTitle="//div[@class='jumbotron jumbotron--shared']/div/h5";
    public static String Q2Wall_SignInPageSubTitle="//div[@class='container ng-scope']//div[@class='col-sm-12']//h1[contains(text(),'Sign In')]";
    public static String Q2Wall_SignInPageText="//div[@class='container ng-scope']//p[contains(text(),'Sign in with')]";
    public static String Q2Wall_SignInUserNameHeading="//form[@name='login']/div[1]/label[@for='username']";
    public static String Q2Wall_SignInUserNameRequired="//form[@name='login']/div[1]/label[@for='username']/span[@class='required']";
    public static String Q2Wall_SignInUserNameField="//input[@id='username']";
    public static String Q2Wall_SignInForgotUsernameLink="//form[@name='login']/div[1]/a[contains(text(),'Forgot Username?')]";
    public static String Q2Wall_SignInPasswordHeading="//form[@name='login']/div[2]/label[@for='password']";
    public static String Q2Wall_SignInPasswordRequired="//form[@name='login']/div[2]/label[@for='password']/span[@class='required']";
    public static String Q2Wall_SignInPasswordField="//input[@id='password']";
    public static String Q2Wall_SignInForgotPasswordLink="//form[@name='login']/div[2]/a[contains(text(),'Forgot Password')]";
    public static String Q2Wall_SignInButton="//form[@name='login']/button[@type='submit']";
    public static String Q2Wall_CustomerCareVerbiageOne="//div[@class='col-sm-4 pull-right']/p[1]";
    public static String Q2Wall_CustomerCareVerbiageTwo="//div[@class='col-sm-4 pull-right']/p[2]";
    public static String Q2Wall_AccountPastDueText="//div[@class='wg-payment-options-content ng-scope']/h1";
    
    public static String Q2Wall_HeaderDropdown="//i[@class='icon sb_ic_chevron_down ng-scope']";
    public static String Q2Wall_InvalidCredentials=".//*[@id='tooltipTitle']";
    public static String Q2Wall_CardNumber_HeaderText="//label[@for='cardNumber']";
    public static String Q2Wall_ExpirationDate_HeaderText="//form[@name='forms.paymentInfoForm']/fieldset[1]/div/div[2]/fieldset/legend";
    public static String Q2Wall_PaymentAmount_HeaderText="//label[@for='paymentAmount']";
    public static String Q2Wall_PaymentDate_HeaderText="//label[@for='paymentDate']";
    public static String Q2Wall_RequiredText="//form[@name='forms.paymentInfoForm']/fieldset[1]/legend/div/span";
    public static String Q2Wall_SignOut="//div[@ng-if='user && !loading.login && !loading.logout']/ul/li[3]/div";
    public static String Q2Wall_ViewDetails_Link="//a[@ng-click='viewStatementDetails()']";
    public static String Q2Wall_ViewDetails_DialogBox="//div[@class='modal-dialog']/div[@class='modal-content']/div";
    public static String Q2Wall_ViewDetails_DialogBox_CloseButton="//div[@class='modal-dialog']/div[@class='modal-content']/div/div[3]/button";
    public static String Q2Wall_LocationFinder_NoResultsMessage="//p[@ng-if='model.noResults']";
    
 // Manavi - Sprint 35 - Dev Xpaths
    public static String RegisterAccountLink="//a[@ng-href='/create-account.html']";
    public static String RegisterAccountPageVerification="//*[@id='content-container']/div[1]/div/div/h5";
    public static String SpectrumBusinessLogo_Dev="//a[@href='https://www.dev2-spectrumbusiness.net/index.html']/img";
    public static String SpectrumBusinessLogo_Dev_SupportPage="//div[@class='sb-nav-item']/a/img[@title='Spectrum Business logo']";
    public static String Support_Link_Dev = "//div[@class='sb-nav-item header-support-item hidden-xs']/a[@ng-href='https://www.dev2-spectrumbusiness.net/support']";

    
 // Manavi - Sprint 29
    public static String AddNewUserButton="//button[@ng-click='addNewUser()']";
    public static String AddStepsListFourTitle="//div[@class='sb-new-user-nav ng-isolate-scope']/ul/li[4]/span/following-sibling::span/span[1]";
    public static String AddStepsListFourStatus="//div[@class='sb-new-user-nav ng-isolate-scope']/ul/li[4]/span/following-sibling::span/span[2]";
    public static String AddStepsListHeading="//div[@class='sb-create-member-section-header']/div";
    public static String AddUserFirstName="//input[@id='profileFirstName']";
    public static String AddUserLastName="//input[@id='profileLastName']";
    public static String AddUserEmail="//input[@name='email']";
    public static String NextButton="//button[@type='submit' and contains(text(),'NEXT')]";
    public static String AddUserStandardRadioButton="//input[@id='standardPermissionOption']";//"//div[@class='three-col-box']/div[1]/div/div/div/div/input[@id='basicPermissionOption']";
    public static String AddUserAdminRadioButton="//input[@id='administratorPermissionOption']";
    public static String AddUserAddVoiceLineButton="//button[@ng-click='addNewLineRow($event)']/i";
    public static String AddUserVoiceLineNumber="//div[@class='btn-group unassigned-item-select dropdown']/button/div/div";
    public static String AddUserNameFieldVerify="//div[@ng-if='uppercaseParam === UICONSTANTS.SERVICE_KEY_PROFILE']/div[@class='service-info']/div[contains(text(),'Name')]";
    public static String AddUserNameFieldEditVerify="//div[@class='row sb-create-member-service-item sb-create-member-confirm-top-row']/div[2]/a[contains(text(),'Edit')]";
    public static String AddUserRoleFieldVerify="//div[@ng-if='uppercaseParam === UICONSTANTS.SERVICE_KEY_ROLE']/div[@class='service-info']/div[contains(text(),'Role')]";
    public static String AddUserRoleFieldEditVerify="//div[@class='row sb-create-member-service-item']/div[2]/a[contains(text(),'Edit')]";
    public static String AddUserVoiceNumberFieldVerify="//div[@ng-if='uppercaseParam === UICONSTANTS.SERVICE_KEY_VOICE']/div[@class='service-info']/div[contains(text(),'Voice')]";
    public static String AddUserVoiceNumberFieldEditVerify="//div[@class='row sb-create-member-service-item ng-scope']/div[2]/a[contains(text(),'Edit')]";
    public static String AddUserBackOption="//a[@ng-click='back()']";
    public static String AddUserCancelOption="//a[@ng-click='cancel()']";
    public static String AddUserConfirmOption="//button[@type='submit' and contains(text(),'CONFIRM')]";
    public static String AddUserNameOptionValue="//div[@ng-if='uppercaseParam === UICONSTANTS.SERVICE_KEY_PROFILE']/div[@class='service-info']/div[2]";
    public static String AddUserVoiceLineErrorMessage="//div[@class='sb-alert__container']/div/div[@class='sb-alert__message-cell ng-scope']/span";
    public static String AddUserSkipLink="//a[@ng-click='skipVoiceOptions()']";
    public static String BillPayOptionsLink="//div[@class='sb-nav-menu__nav-row']/div[@href='#/billing/bill-pay-options']";
    
    public static String BillPayOptions_PaperAndOnlineBill="//input[@id='paperAndOnlineBill']";
    
    
 // Manavi - Sprint 30
    public static String ManageUsers_Link="//div[@activity='ACCOUNT_ADMINISTRATION']/a[@href='/smb/manage-members.html#/manage/list']";
    public static String ManageUsers_PageList="//div[@ng-repeat='user in filteredUsers = (model.allUsers  | filter:searchFilter(model.search) )']";
    public static String ManageUsers_RoleList="//div[@ng-repeat='user in filteredUsers = (model.allUsers  | filter:searchFilter(model.search) )']/div[@class='sb-manage-users-list-column--role ng-binding']";
    public static String ManageUsers_UserNameList="//*[contains(@ng-if,'user.username')]";
    public static String DeleteUserLink="//a[@ng-click='confirmDeleteContact(model.user.guid)']";
    public static String UserPermissionsDropdownBox="//div[@class='sb-account-permission-select dropdown']/button";
    public static String UserPermissionsDropdownAllValues="//ul[@class='list-group dropdown-menu']";
    public static String UserPermissionsDropdownSingleValue="//ul[@class='list-group dropdown-menu']/div[@ng-repeat='role in permissions']/a/span";
    public static String UserPermissionsRoleValueVerification="//div[@class='sb-detail__row'][2]/i/following-sibling::div[@class='sb-detail__detail-text']/div[@class='sb-detail__text-item ng-binding']";
    public static String UserPermissionsDropdownSingleValueBT="//ul[@class='list-group dropdown-menu']/div[@ng-repeat='role in permissions']/a/span[contains(text(),'Billing and Transactions')]";
    public static String UserPermissionsDropdownSingleValueStandard="//ul[@class='list-group dropdown-menu']/div[@ng-repeat='role in permissions']/a/span[contains(text(),'Standard')]";
    public static String CloudwareAddOnsHeading="//form[@name='editUserForm']//div[contains(text(),'Cloudware Add-ons')]";
    public static String CloudwareAddOnsButton="//form[@name='editUserForm']//div[@ng-if='hasAppDirect()']/div/div[2]/button";
    public static String Manage_Users_Search="//input[@placeholder='Search']";
  //Saranya[9/18/2015]
    //Sprint 24
    public static String MessageLink="//div[@ng-hide='loading.numbers']//div[@href='#/voice/messages/']";
    public static String Deletebutton="//button[@title='Delete']";
    public static String CheckboxList="//label[@ng-click='stopCollapseToggle($event)']";
    		//"//input[@type='checkbox']";
    public static String DeletePopup="//*[@id='modalTitle']";
    public static String DeletePopup_CancelBtn="//a[.='CANCEL']";//div[@ ng-if='modalOptions.showFooter']/a[.='Cancel']";
    public static String DeletePopup_ConfirmBtn="//button[@type='button' and .='CONFIRM']";
    //Sprint 25
    public static String Contacts_Arrow="//div[@ng-click='openDetails($event, contact)']//div/i";
    public static String Contacts_CallLog_Arrow="//div[@ng-click='toggleDetails($event, call)']/div/div/div[4]/div/i";
    public static String Contacts_Link="//div[@ng-hide='loading.numbers']//div[@href='#/voice/contacts']";
    public static String ContactNameList="//div[@ng-click='openDetails($event, contact)']/div";
    public static String ContactNameText="//div[@id='sbDetailContent']/div[2]/div[4]/div/div[1]";
    
    //Saranya[9/21/2015]
    
    //Sprint 25[Manage Lines]
    
    public static String ManageLineLink="//div[@ng-hide='loading.numbers']//div[@href='#/voice/manage-lines']";
    public static String ManageLine_arrow="//div[@ng-click='toggleDetails($event, line)']//div/i[@class='icon icon--gray icon--small sb_ic_chevron_right']";
    public static String ManageLine_arrow2="//div[@ng-click='toggleDetails($event, line)']//div/i[@class='icon icon--gray icon--small sb_ic_chevron_right']";
    public static String ManageLine_Editbutton="//a[@ng-click='detailOptions.editFunction()']";
    //public static String ManageLine_SaveButton="//button[.='Save']";
	//public static String ManageLine_CancelBtn="//a[@ ng-click='actionSheetOptions.cancelFunction()']";
    public static String ManageLine_AliasName="//input[@ng-model='model.alias']";
	
    public static String ManageLine_AliasText="//div[@id='sbDetailContent']//div[2]/div[4]/div[2]/div";

	//Neha Sprint 26[Manage Lines]
    public static String TollFreeNumber="//div[contains(@ng-repeat,'filter:isTollFree')][1]";
    public static String TollFreeLineNumber="//div[contains(@ng-repeat,'filter:isTollFree')][1]/div[2]";
    public static String TollFreeDetailSheet="//a[@ng-click='detailOptions.backFunction()']";
    public static String TollFreeEdit_RequiredField="//div[@class='sb-detail--required pull-right']";
    public static String LeaveConfirmationPopUp="//div[@class='modal-content']//h2[contains(text(),'Leave Page')]";
    public static String CancelConfirmationPopup="//div[@ng-if='modalOptions.showFooter']//a[contains(text(),'CANCEL')]";
    public static String ConfirmConfirmationPopup="//div[@ng-if='modalOptions.showFooter']//button[contains(text(),'CONFIRM')]";
    public static String ManageLine_UneditableAliasName ="(//div[@class='sb-detail__text-item ng-binding'])[1]";
    public static String ManageLine_LineInformation ="//div[@class='sb-detail__title sb-detail__header-text ng-binding']";
    public static String ManageLine_EditAliasName ="//input[@ng-model='model.alias']";
    public static String ManageLine_DeleteButton ="//span[@class='clearable-inputs sb-clearable-inputs ng-scope']";
    public static String Voice_VoicemailPin ="(//*[contains(@ng-click,'vm-pin')])[2]";
    public static String VoicemailPin_NewPinInput ="//input[contains(@ng-model,'model.pin')]";
    public static String VoicemailPin_ConfirmPinInput ="//input[contains(@ng-model,'model.confirmPin')]";
    public static String VoicemailPin_SavePin ="//div[@ng-controller='voicemailPinCtrl']//button[contains(.,'SAVE')]";
    public static String VoicemailPin_PinSavedMsg ="//p[contains(text(),' New PIN saved successfully.')]";
    public static String VoicemailPin_SavePinCancel ="//a[@ng-click='confirmCancel()']";
    public static String VoicemailPin_ConfirmCancelPopup ="//h2[@id='modalTitle' and contains(text(),'Confirm Cancel Changes')]";
    public static String VoicemailPin_ConfirmButtononPopup ="//button[@sb-grab-focus-on-event='focusPrimaryModalButton']";
    
    //PayNow
    public static String PayBill_CompletePaymentButton ="//div[@class='col-xs-12 col-sm-6']//button[@type='submit']";
    public static String PayBill_PaymentComplete ="//div[@class='sb-section-header' and contains(text(),'Payment Complete')]";
    public static String PayBill_ThankyPaymentMsg ="//div[@class='sb-pay-bill-content-container']";
    
    //View Statement
    public static String ViewStatament_LearnMore ="//div[@ng-repeat='charge in model.chargeDetails.internetCharges']//div[@class='hidden-xs hidden-sm col-md-1']/a/i";
    public static String ViewStatament_Description="//div[@ng-repeat='charge in model.chargeDetails.internetCharges']//div[@class='hidden-xs hidden-sm col-md-1']/a//ancestor::div[@class='sb-content-row single-content-header-row sb-billing-row sb-statement-row-content']/div[2]";
    public static String ViewStatament_Page="//div[@class='sb-subpage__list-container billing-list ng-scope']/div[1]";
    public static String LearnMore_ModalWindow ="//h2[@id='modalTitle']";
    public static String TaxesFees_Icon="//div[@ng-if='model.chargeDetails.taxCharges.length > 0']//div/a/i";
    public static String TaxesFees_Desc ="(//div[@ng-if='model.chargeDetails.taxCharges.length > 0']//div[@class='sb-content-row single-content-header-row sb-billing-row sb-statement-row-header'])[1]";
    public static String ModalWindow_Button="//button[@ng-if='modalOptions.buttonText && modalOptions.buttonOmniture']";
    public static String ViewStatementDefaultDropDown="//button[@ng-if='model.statementList.length > 1']";
    //Saranya[9/22/2015]
    
    public static String ManageLine_LineNumber_Label="//div[@id='sbDetailContent']/div[2]//div[contains(.,'Line Information')]";
	public static String ManageLine_AliasLabel="//div[@id='sbDetailContent']/div[2]//div[contains(.,'Alias')]";
	public static String ManageLine_AssignedTo="//div[@id='sbDetailContent']/div[2]//div[contains(.,'Assigned To')]";
	public static String ManageLine_ContactName="//div[@sb-address='model.line.directoryListing']";
	//"//div[@ ng-if='model.line.isAssigned && !model.line.isTollFree']"
	public static String ManageLine_DirectoryLabel="//div[.='Directory Listing']";
	public static String ManageLine_Address="//div[@sb-address='model.line.directoryListing']";
	public static String ContactsLink="//div[@ng-hide='loading.numbers']//div[@href='#/voice/contacts']";
	public static String NonSectionArea="//div[@section='model.sectionName']";
	
	//Saranya[9/23/2015]
	public static String Add_ContactButton="//button[@ng-click='addContact()' and @type='button']";
	public static String AddContact_FirstName="//input[@id='contact-first-name']";
	public static String AddContact_LastName="//input[@id='contact-last-name']";
	public static String AddContact_Title="//input[@id='contact-title']";
	public static String AddContact_Company="//input[@id='contact-company']";
	public static String Addcontact_EmailIcon="//button[@ng-click='addEmailAddress()'and @type='button']";
	public static String Addcontact_PhoneNumberIcon="//button[@ng-click='addPhoneNumberRow($event)'and @type='button']/i";
	public static String Addcontact_EmailInputText="//input[@name='email']";
	public static String AddContact_EmailInputText2="//form//div[2]/div/div//input[@name='email']";
	public static String AddContact_RemoveEmail="//button[@ng-click='removeEmailAddress($index)'and @type='button']/i";
	public static String AddContact_EmailErrorMsg="//div[@name='contactEmail']//div[contains(@class,'message')]";
	public static String AddContact_AddressIcon="//button[@ng-click='addAddress()'and @type='button']";
	
	public static String AddContact_AddressStreet="//input[@id='contact-street-1-0']";
	public static String AddContact_AddressCity="//input[@id='contact-city-0']";
	public static String AddContact_AddressState="//input[@id='contact-state-0']";
	public static String AddContact_AddressZipcode="//input[@id='contact-zip-0']";
	public static String AddContact_AddressCountry="//input[@id='contact-country-0']";
	public static String AddContact_RemoveAddress="//button[@ng-click='deleteAddress($index)'and @type='button']";
	public static String ContactList="//div[@ng-click='openDetails($event, contact)']/div[1]";
	public static String EmailVerification="//div[@ng-if='model.contactDetails.emailAddresses.length > 0']//a";
	public static String DeleteContact="//a[@class='delete-link']";
	
	
	//Saranya[9/28/2015]
	
	public static String AddressVerification="//div[@ng-repeat='address in model.contactDetails.addresses']/div[1]";
    public static String CallLog_arrowList="//div[@ ng-class='selectedClass(call.callId)']/div[4]/div/i";
    
    
    //Saranya[9/29/2015]
    
    
    public static String Addcontact_PhoneNumberTypes="//button[@ng-if='phoneNumberTypes.length > 0']";
    public static String Addcontact_PhoneNumber_inputText="//input[@name='phoneNumber']";
    public static String Addcontact_InvalidPhoneErrorMsg="//div[@class='input-error-message ng-binding']";//div[@ng-show='number.error']";
    
    public static String Addcontact_RemovePhoneNumber="//button[@ng-click='deletePhoneNumberRow($event, $index, number)']/i";
	public static String Addcontact_PhoneTypeVerification="//div[@ng-repeat='line in model.contactDetails.phoneNumbers']/div/div[1]";
	public static String Addcontact_PhoneNumberVerification="//div[@ng-repeat='line in model.contactDetails.phoneNumbers']/div/div[2]";
	public static String Phone_no_Remove_confirm="//*[@id='modalTitle']";
	
	//Saranya[9/30/2015]
	
	public static String ManageLine_AssignmentLabel="//div[.='Assignment']";
	public static String ManageLine_AssignmentList="//div[contains(@ng-if,'line.isAssigned')]";
	public static String ManageLine_NumberLabel="//div[.='Number']";
	public static String ManageLine_NumberList="//div[@ng-class='selectedClass(line.number)']//div[contains(@class,'table')]";
	public static String ManageLine_Alias_Label="//div[.='Alias']";
	public static String ManageLine_AliasList="//div[@ng-class='selectedClass(line.number)']/div[contains(@class,'alias')]";
	public static String ManageContactList="//div[@ng-click='toggleDetails($event, line)']";
	public static String AssignmentColumn="//div[@ng-if='line.isAssigned && (line.assignment.firstName && line.assignment.lastName)']";
	public static String ManageLines_VoiceLineList="//div[contains(@ng-repeat,'line in model.lines')]//div[contains(@class,'sb-voice-line-text')]";
	public static String ManageLine_UnassignedList="//div[contains(@ng-if,'!line.isAssigned')]";
	
	
	//saranya[1/10/2015]
	public static String Contact_arrowList="//div[@ng-click='openDetails($event, contact)']//div/i";
	
	//Saranya[10/6/2015]
	
    public static String CallLog_CallDetailsWindow="//div[@id='sbDetailContent']";
    public static String CallLog_AddToExistingContact="//a[@ng-click='addToExistingContact()']";
    public static String CallLog_AddToExistingContact_SavedContactList="//div[@class='contacts-list ng-scope']/div[1]/div";
    public static String CallLog_AddToExistingContact_EditMode="//div[@class='sb-edit__row']//input";
    public static String CallLog_AddToExistingContact_PopulatedNum="//div[@class='ng-pristine ng-valid ng-valid-required ng-valid-input']/div/div//input";

  
    public static String VoiceSettingsBtn="//span[contains(.,'VOICE SETTINGS')]/ancestor::button";
    
    public static String FwdAllCalls_SaveBtn="//button[@ng-click='saveForwardingSettings()']";
    public static String FwdAllCalls_FwdImmediate="//div[.='Forward Immediately / No Ring']";
    public static String FwdAllCalls_FwdImmONOFFSlider="//div[@enabled-state='model.immediateForwardingEnabled']/button";
    public static String FwdAllCalls_PhoneNumSelector="//select[@ng-model='model.immediateForwardingDestinationLine']";
    public static String FwdAllCalls_FwdBusyNoAns="//div[.='Forward Busy / No Answer']";
    public static String FwdAllCalls_FwdBusyNoAnsOnOffSlider="//div[@enabled-state='model.busyNoAnswerForwardingEnabled']/button";
    public static String FwdAllCalls_ManangeFwdLinesBtn= "//button[.='Manage Forwarding Lines']";
    public static String FwdAllCalls_PhoneNumSelectorList="//select[@ng-model='model.immediateForwardingDestinationLine']/option";
	public static String FwdBusy_PhoneNumSelector="//select[@ng-disabled='!model.busyNoAnswerForwardingEnabled']";
	public static String FwdBusy_PhoneNumSelectorList="//select[@ng-disabled='!model.busyNoAnswerForwardingEnabled']/option";
	public static String CloseBtn="//span[.='Close']";
	
	
	//Priyanka [9/14/2015]
	
		public static String VoiceBtn="//a[@href='/smb/voice.html']";
		public static String ContactsBtn="//div[@ng-hide='loading.numbers']//div[@href='#/voice/contacts']";
		public static String Voicepage="//div[@ng-hide='loading.numbers']";
		
		
		//Priyanka [9/15/2015]
		
		public static String Contactspage="//button[contains(.,'ADD CONTACT')]";
		public static String ContactsList="//div[@ng-class='detailsOpen(contact)']";
		public static String ContactsName="//div[@ng-class='detailsOpen(contact)']/div[1]";
		public static String FirstContactdetails="(//div[@class='details-link pull-right'])[1]";
		public static String Contactdetailspage="(//div[contains(.,'Contact Information')])[1]";
		public static String AddContact="//button[contains(.,'ADD CONTACT')]";
		public static String AddContactspage="//form[@name='addContactForm']";
		public static String FaxIcon="(//i[@ng-if='message.read'])[1]";
		public static String FaxPreview="//*[@id='message-details-section']/div[1]/div/img";
		public static String FaxPreviewElements="(//div[@class='subpage__link-container'])[1]";
		public static String Messages="//div[@ng-hide='loading.numbers']//div[@href='#/voice/messages/']";
		
		//Priyanka [9/16/2015]
		
		public static String IncomingCallsList="//div[@ng-switch-when='Answered']//i";
		public static String MissedCallsList="//div[@ng-switch-when='Missed']//i";
		public static String OutgoingCallsList="//div[@ng-switch-when='Dialed']//i";
		public static String Calllog_callLogLink="//div[@ng-hide='loading.numbers']//div[@href='#/voice/call-logs/']";
		
		//Priyanka [10/01/2015]
		
		public static String Savedcontacts="//div[contains(@ng-class,'call.type')]";
		public static String ContactsCityAndState="//div[contains(@ng-class,'call.type')]/following-sibling::div";
		public static String PhoneType="//div[@class='text--style-r14-2 ng-binding']";
		public static String TimeDisplay="//div[@ng-class='selectedClass(call.callId)']/div[3]/div";
		
		//Priyanka [9/28/2015]
		
		public static String CallInfo="//div[@class='call-log-details']//div[contains(.,'Call Information')]";
		public static String Name ="//div[@ng-switch='details.type']/div/div[1]";
		public static String CallType ="//div[@ng-switch='details.type']/div/div[2]";
		public static String Date ="//div[@class='call-log-details']/div[3]/div/div[1]";
		public static String Time ="//div[@class='call-log-details']/div[3]/div/div[2]";
		public static String Duration ="//div[@class='call-log-details']/div[3]/div/div[3]";
		public static String PhoneBlock ="//div[@class='call-log-details']/div[contains(.,'Phone')]";
		public static String WorkNumber ="//div[@ng-if='details.contactInfo.phoneNumbers']/div[2]/div[1]/div";
		public static String CellNumber ="//div[@ng-if='details.contactInfo.phoneNumbers']/div[2]/div[2]/div";
		public static String EmailAddress="//div[@ng-repeat='email in details.contactInfo.emailAddresses']//div[@class='sb-detail__text-item']/a";
				//"//div[@ng-if='details.contactInfo.emailAddresses']";
		public static String Address="//div[@ng-repeat='address in details.contactInfo.addresses']/div[@class='sb-detail__detail-text']";
		public static String StreetAddress="//div[@ng-repeat='address in details.contactInfo.addresses']/div[@class='sb-detail__detail-text']/div[1]";
				//"//div[@ng-if='details.contactInfo.addresses']";
		public static String CallLogedit="//a[@ng-click='detailOptions.editFunction()']";
		
		
		
		
			
		 
		 //Priyanka [9/30/2015]
		 
		 public static String SavedContacts_CallLog="//div[@ng-class='selectedClass(call.callId)']/div[2]/div";
		
		 //Priyanka [10/05/2015]
		 
		 public static String Block="//div[contains(@ng-if,'Unknown')]//a[.='Block']";
		 public static String block_Check="//a[@ng-click='confirmBlockNumber(details.phoneNumber)']";
		public static String BlockconfirmPopup="//div[@ng-if='modalOptions.hasController']//h2[.='Confirm Block Number']";
		public static String Cancelbtn_Block="//div[@ng-if='modalOptions.showFooter']//a[.='CANCEL']";//div[@ng-if='modalOptions.hasController']//a[.='Cancel']";
		public static String Confirmbtn_block="//button[.='CONFIRM']";
		public static String Unblockbtn="//div[contains(@ng-if,'Unknown')]//a[.='Unblock']";
		public static String CreateNewContact="//div[contains(@ng-if,'Unknown')]//a[@ng-click='createNewContact()']";
		public static String AddToExistingContact="//div[contains(@ng-if,'Unknown')]//a[@ng-click='addToExistingContact()']";
		
		//Priyanka [10/7/2015]
		public static String SpectrumLogo="//img[@title='Spectrum Business logo']";
		public static String SupportBlock="//div[@cb-navigation='cb-navigation']//a[@ng-href='/support']";
		public static String SupportBtn="//a[@ng-href='https://www.engprod2-spectrumbusiness.net/support']/div/i";
		public static String SupportBtnLink	="//a[@ng-href='https://www.engprod2-spectrumbusiness.net/support']";
		public static String Supportpage="//div[@class='jumbotron']";
		
		// Ajoy Upto [07/10/2015] 
		
		//
		//Changed -->Done
		public static String Overview_VoiceTab_Button="//a[@href='/smb/voice.html']";
		//
		public static String Voice_VoiceMessageList="//div[@ng-if='message.messageType === UICONSTANTS.VOICE_MESSAGE_VOICEMAIL']";
		public static String Voice_VoiceContactName="//div[@class='sb-panel--column sb-panel--third-column' ]";
		/*public static String Overview_VoiceTab="//div[@ng-if='has.phone']";
		public static String Voice_VoiceMessageList="//div[@ng-if='message.messageType === UICONSTANTS.VOICE_MESSAGE_VOICEMAIL']";
		public static String Voice_VoiceContactName="//div[@class='sb-panel--column sb-panel--third-column' ]";*/
		public static String Voice_ReadMessages="//div[@class='ng-binding col-xs-12.col-md-7 text--style-r16-2 voice-message-number-text' ]";
		public static String Voice_BlockMessages_unknown="//div[@id='message-details-section' and contains(@aria-hidden,'false')]/div[2]/span[@class='sb-message-control block-link ng-scope']";
		public static String Voice_BlockMessages="//a[@ng-if='!message.blocked']";
		
		//public static String Voice_DeleteMessages="//a[@ng-click="confirmDelete('single', message); stopCollapseToggle($event);"]";
		public static String CallLog_ContactName="//div [@ng-class='call.type === 'Missed' ? 'missed-call' : '']";
		public static String Calllog_MissedCall="//div[@class='text--style-r16-3 no-wrap ng-binding missed-call']";
		//public  String Calllog_callLogLink="//div[@ng-hide='loading.numbers']//div[@href='#/voice/call-logs/']";
		public static String Calllog_block="//a[@ng-if='!details.blocked']";
		public static String Temp="//*[@id='content-container']/main/div/div[1]/div/div[1]/div[2]";
		public static String sideNavigationUI="//div[1][@ui-view='side-nav']";
		public static String Calllog_InfoWindow="//div[3][@class='call-log-details']";
		public static String UnauthenticatedUser_SharedHomePage_SignIn="//button[.='Sign In' and @type='submit']";
		public static String UnauthenticatedUser_SharedHomePage_RegisterAccount="//a[@class='register-account-btn'and @href='/create-account.html']";//div[@ng-if='!isLoggedIn']//div/a[@href='/create-account.html']
		public static String UnauthenticatedUser_SharedSignInPage="//div[@class='row cb-content login-template ng-scope']";
		public static String UnauthenticatedUser_SharedSignInPage_RegisterAccount="//a[@class='register-account-btn' and @href='/create-account.html']";
		public static String UnauthenticatedUser_RegisterAccount="//h5[@class='ng-binding']";
		public static String SharedHomePage_SupportLink="//div[2][@class='sb-nav-support__text-cell']";
		public static String ManageLines_manageLinesLink="//div[@ng-hide='loading.numbers']//div[@href='#/voice/manage-lines']";
		public static String Overview_ManageUsersTab="//i[@class='icon sb_ic_manage_users tile-main-icon']";
		public static String ManageUsers_AddNewUserButton="//button[@ng-click='addNewUser()']";
		public static String ManageUsers_AddNewUser_FirstName="//input[1][@id='profileFirstName']";
		public static String ManageUsers_AddNewUser_Email="//input[@ng-model='model.newUser.profile.contactEmail']";
		public static String ManageUsers_AddNewUser_LastName="//input[2][@id='profileLastName']";
		public static String ManageUsers_AddNewUser_PhoneNumber="//input[@ng-model='model.newUser.profile.contactPhone']";
		public static String ManageUsers_AddNewUser_NextButton="//button[@ng-disabled='newUserProfileForm.$invalid']";
		public static String ManageUsers_AddNewUser_Permissions="//div[@class='radio-btn radio-btn-row-cell radio-btn-cell']/i";//"//input[@id='basicPermissionOption']";
		public static String ManageUsers_AddNewUser_Permissions_Next="//button[@ng-disabled='newUserPermissionsForm.$invalid']";
		public static String ManageUsers_AddNewUser_AddVoiceLineButton="//button[@ng-click='addNewLineRow($event)']";
		public static String ManageUsers_AddNewUser_Step3Next="//button[@class='sb-btn sb-btn--primary']";
		public static String ManageUsers_AddNewUser_Confirm="//button[@class='sb-btn sb-btn--primary']";
		public String SpectrumLogoClick="//img[@title='Spectrum Business logo']";
		public String LoginLink="//div[2][@ng-if='!user']";
		public String LoginLinkDropDown="//div[@ng-click='toggleDropDown($event)']";
		//public String headerDropdown="//div[4][@ng-click='toggleDropDown($event)']";
		public String UsernameField="//*[@id='content-container']/header/div/div[1]/div/header/nav/div[2]/div[2]/div/div/div[2]/form/div[2]/input";
		public String FooterLink="//i[@class='icon more_topics']";
		public String HeaderUserName="//*[@id='content-container']/header/div/div[1]/div/header/nav/div[2]/div[2]/div/div/div[2]/form/div[2]/input";
		public String ErrorMessageHeaderUsername="//*[@id='content-container']/header/div/div[1]/div/header/nav/div[2]/div[2]/div/div/div[2]/form/div[2]/div";
		public String HeaderPassword="//*[@id='content-container']/header/div/div[1]/div/header/nav/div[2]/div[2]/div/div/div[2]/form/div[3]/input";
		public String SigninButton="//button[@ng-disabled='headerLogin.$invalid || loading.login']";
		public String OverView="html/body/div[2]/div/header/div/div[2]/div/h5";
		public String RememberMe="//input[@id='rememberMe']";
		public String FooterFullView="//*[@class='footer-main-content']";
		public String RegisterAccountHeader="html/body/div[2]/header/div/div[1]/div/header/nav/div[2]/div[2]/div/div/div[4]/div/a";
		public String ForgotPassword_UsernameHeader="html/body/div[2]/header/div/div[1]/div/header/nav/div[2]/div[2]/div/div/div[2]/div";
		//public String LogoutHeader="//li[7][@class='sb-nav-menu__nav-row']";
		public static String Export_Button="//button[@ng-click='openExportModal()']";
		public static String ExportCalls_ReceivedCalls="//label[@for='export-calls-received']/div/i";
		public static String ExportCalls_MissedCalls="//label[@for='export-calls-missed']/div/i";//input[@id='export-calls-missed']";
		public static String ExportCalls_DailledCalls="//label[@for='export-calls-dialed']/div/i";//input[@id='export-calls-dialed']";
		public static String ExportButton_Popup="//button[@ng-click='primaryButtonFunction ? primaryButtonFunction($event) : $close()']";
		public static String Export_CancelButton="//a[@ng-click='secondaryButtonFunction ? secondaryButtonFunction($event) : $dismiss()']";	
		public static String CallLog_BlockPopUp="//button[@ng-click='primaryButtonFunction ? primaryButtonFunction($event) : $close()']";
		public static String Calllog_Unblock="//a[@ng-if='details.blocked']";
		public static String Calllog_BackPopUp="//a[1][@ng-click='detailOptions.backFunction()']";
		public static String AddToExistingContacts="//i[@class='icon icon--gray sb_ic_profile_card details-icon-close']";
		public static String Search="//div[@class='sb-detail-content sb-action-content']//div[@query='model.search']";
		public static String Search_Icon="//div[@class='sb-detail-content sb-action-content']//button[@class='sb-btn sb-btn--icon']";
		public static String ExistingContactList="//div[@ng-click='selectContact(contact)']";
		public static String Populated_Number="//div[@class='sb-detail__text-input-container phone-number']";
		public static String Cancel_Button="//a[@ng-click='actionSheetOptions.cancelFunction()']";
		public static String Confirm_Popup="//button[@ng-click='primaryButtonFunction ? primaryButtonFunction($event) : $close()']";
		public static String Voice_UnreadMessages="(//a[@ng-if='!(line.notifications[0].count + line.notifications[1].count === 0)'])[1]";
		public static String Voice_UnreadMessages_Line="(//h3[@class='text--style-r17-4 text-gray-1 sb-row-bottom-border'])[2]";
		public static String Navigate_To_Voice_Page="//li[4][@class='toolbar-main sb-tablet--hidden toolbar__section ng-binding ng-scope']";
		public static String Overview_MissedCalls="//a[@ng-if='!(line.notifications[0].count + line.notifications[1].count === 0) && line.notifications[1].count > 0']";
		public static String Overview_NoMissedCall="//a[@ng-if='!(line.notifications[0].count + line.notifications[1].count === 0) && line.notifications[1].count === 0']";
		public static String No_Notifications="//p[@class='sb-no-content-text']";//"//a[@ng-if='line.notifications[0].count + line.notifications[1].count === 0']";
		public static String Calllog_Page="//li[4][@class='toolbar-main sb-tablet--hidden toolbar__section ng-binding ng-scope']";
		public static String CallLog_PhoneType="//button[@ng-if='phoneNumberTypes.length > 0']";
		public static String CallLog_Save_ExistingContact="//button[@ng-click='actionSheetOptions.saveFunction()']";
		public static String CallLog_Save_back="//a[1][@ng-click='detailOptions.backFunction()']";
		public static String V2_search_support="//h1[contains(.,'Search Support')]";
		public static String Confirm_btn="//button[contains(.,'CONFIRM')]";
	//Changed
		public static String Edit_Button="//a[2][@ng-click='detailOptions.editFunction()']";
		//
		public static String Remove_Button="//button[@ng-click='deletePhoneNumberRow($event, $index, number)']";
		
		
		
		//Saranya[10/7/2015]
		public static String DirectoryList="//div[@ sb-address='model.line.directoryListing']";
		public static String DirectoryListHeading="//div[@id='sbDetailContent']/div[2]/div[7]";
		public static String DirectoryListAddress_EditForm="//form[@name='editLineInformationForm']/div[6]/div[2]";
		public static String RemoveAssignmentBtn="//button[@ng-click='deleteAssignment()']/i";
		//public static String AddNewAssignmentLine="//button[@ng-click='addAssignment()']";
		public static String RemovePopup="//*[@id='modalTitle']";
		public static String RemovePopupCancelbtn="//div[@ng-if='modalOptions.showFooter']/a";
		public static String AssigmentText="//div[contains(@ng-if,'model.line.isAssigned')]";//div[@ng-if='!model.line.isAssigned']";
		//harpreet_managelines
		public static String RemovePopupConfirmbtn="//*[@ng-click='primaryButtonFunction ? primaryButtonFunction($event) : $close()']";
		public static String AssignLine="//*[@ng-click='addAssignment()']/i";
		public static String AssignLineUserList="//*[@class='sb-content-row single-content-row ng-scope']";
		public static String No_User_cancel="//*[@ng-click='secondaryActionSheetOptions.cancelFunction()']";
		public static String No_User_cancel_cancel="//*[@ng-click='actionSheetOptions.cancelFunction()']";
		public static String Cancel_confirmbtn="//*[@ng-click='primaryButtonFunction ? primaryButtonFunction($event) : $close()']";
		public static String AssignLine_Savebtn="//button[@ng-click='secondaryActionSheetOptions.saveFunction()']";
		public static String AssignLine_Savebtn2="//button[@ng-click='actionSheetOptions.saveFunction()']";
		
		//Harpreet View Statements
		
		  public static String VerifyViewStatementPage="//ul[@class='nav-left-list sb-options-toolbar-nav--left']/li[contains(text(),'View Statements')]";
		 // public static String StatementDropdown="//button[@ng-if='model.statementList.length > 1']";
		  //public static String StatementDropdownlist="//ul[@ng-if='model.statementList.length > 1']/li[2]";
		  public static String StatementSummaryTitle  ="//div[@class='sb-content-row single-content-header-row sb-billing-row billing-header-dark']/div[@class='col-xs-8 col-sm-6 col-md-6 col-lg-6']";
		  public static String CurrentStatementTitle ="//div[@class='sb-content-row single-content-header-row sb-billing-row billing-header-dark']/div[@class='hidden-xs hidden-sm col-md-6 col-lg-6 text-right ng-binding']";
		  public static String PreviousBalance="//div[@class='sb-content-row single-content-header-row sb-billing-row sb-statement-row-content']/div[contains(text(),'Previous Balance')]";
		  public static String PreviousBalanceAmount ="//div[@class='sb-content-row single-content-header-row sb-billing-row sb-statement-row-content']/div[contains(text(),'Previous Balance')]/following-sibling::div";
		  public static String PaymentsReceived="//div[3][@class='sb-content-row single-content-header-row sb-billing-row sb-statement-row-content']/div[contains(text(),'Payments Received')]";
		  public static String PaymentsReceivedAmount="//div[3][@class='sb-content-row single-content-header-row sb-billing-row sb-statement-row-content']/div[contains(text(),'Payments Received')]/following-sibling::div";
		  public static String Adjustments="//div[4][@class='sb-content-row single-content-header-row sb-billing-row sb-statement-row-content']/div[contains(text(),'Adjustments')]";
		  public static String AdjustmentsAmount="//div[4][@class='sb-content-row single-content-header-row sb-billing-row sb-statement-row-content']/div[contains(text(),'Adjustments')]/following-sibling::div";
		  public static String SpectrumBusinessServices ="//div[5][@class='sb-content-row single-content-header-row sb-billing-row sb-statement-row-content']/div[contains(text(),'Spectrum Business Services')]";
		  public static String SpectrumBusinessServicesDuration ="//div[5][@class='sb-content-row single-content-header-row sb-billing-row sb-statement-row-content']/div[2]";
		  public static String SpectrumBusinessServicesAmount ="//div[5][@class='sb-content-row single-content-header-row sb-billing-row sb-statement-row-content']/div[3]";
		  public static String DownloadStatementBtn ="//button[@ng-click='downloadStatement()']";
		  public static String PayNowBtn="//a[@ng-href='/smb/billing.html#/billing/pay-bill']";
		  public static String CurrentBalanceDueTitle ="//*[@ng-if='model.isCurrentStatement && !errors.billingStatus']/div[contains(text(),'Current Balance Due')]";
		  public static String CurrentBalanceDueAmount="//*[@ng-if='model.isCurrentStatement && !errors.billingStatus']/div[3]";
		  //Muthu100115
		  public static String SupportContents="//div[@class='container']";
			public static String SupportIcon="//i[@class='icon icon--small-med sb_ic_support_phone_f header-support-icon']";
			public static String forgotPasswordLink="//a[@ng-href='/account-recovery.html']";
			public static String accountNumber="//input[@id='accountNumber']";
			public static String recoveryOption="//*[@id='content-container']/main/div/div/div/div/div/h1";
			public static String requiredText="//*[@id='content-container']/main/div/div/div/div/div/h1/div/span";
			public static String description="//*[@id='content-container']/main/div/div/div/div/div/div[2]/p";
			public static String selectRecoveryOption="//*[@id='content-container']/main/div/div/div/div/div/div[2]/form/fieldset[1]/legend";
			public static String usernameRadioButton="//input[@id='recoverCharterIdOption']";
			public static String passwordRadioButton="//input[@id='resetPasswordOption']";
			public static String securityCode="//input[@id='securityCode']";
			public static String cancelButton="//button[@ng-click='cancel()']";
			public static String nextButton="//button[@ng-disabled='accountCredentialsForm.$invalid || submitting || !hasRemainingAttempts()']";
			public static String accountNotFound="//h2[contains(.,'Account Not Found')]";
			public static String captchaRequired="//h2[contains(.,'Captcha Required')]";
			public static String saveButton="//button[@ng-click='actionSheetOptions.saveFunction()']";
			public static String backText="//a[@ng-click='detailOptions.backFunction()']";
			public static String cancelText="//a[@ng-click='actionSheetOptions.cancelFunction()']";
			public static String confirmButton="//button[@ng-if='modalOptions.buttonText && modalOptions.buttonOmniture']";
			public static String checkEmailText="//div[text()[contains(.,'Email')]]";
			public static String deleteIcon="//button[@ng-click='removeEmailAddress($index)']";
			public static String addContactButton="//button[@ng-click='addContact()']";
			public static String firstNameText="contact-first-name";
			public static String lastNameText="contact-last-name";
			public static String contactTitle="contact-title";
			public static String contactCompany="contact-company";
			public static String addEmailButton="//button[@ng-click='addEmailAddress()']";
			public static String searchBar="//input[@placeholder='Search']";
			public static String searchMagnifyIcon="//button[@ class='sb-btn sb-btn--icon']";
			public static String errorMsg1="(//div[@ng-if='contactEmail.debouncedError && contactEmail.email.$dirty'])[1]";
			public static String errorMsg2="(//div[@ng-if='contactEmail.debouncedError && contactEmail.email.$dirty'])[2]";
			public static String emailText="//div[text()[contains(.,'Email')]]";
			public static String callLogsList="//div[@ng-class=\"call.type === 'Missed' ? 'missed-call' : '' \"]";
			public static String cancelIcon="//button[@ng-click='reset()']";
			public static String deletedMsgBtn="//button[@ng-if='!deleted']";
			public static String unreadVoiceMsg="//i[@ng-if='!message.read'][contains(.,'New Voice Message')]";
			public static String readVoiceMsg="//i[@ng-if='message.read'][contains(.,'Read Voice Message')]";
			public static String paymentHistory="//div[@class='sb-nav-menu__nav-content'][contains(.,'Payment History')]";
			public static String paymentHistoryRows="//div[@ng-repeat='payment in paymentHistory']";
			public static String pendingStatus="//div[@class='sb-billing-column--status ng-binding']";
			public static String paymentDateOne="//div[@class='sb-billing-column--payment-date ng-binding']";
			public static String paymentDate="(//div[@class='sb-billing-column--payment-date ng-binding'])[";
			public static String paymentTypeOne="//div[@ class='sb-billing-column--type']";
			public static String paymentType="(//div[@ class='sb-billing-column--type'])[";
			public static String paymentAmountOne="//div[@class='sb-billing-column--amount']";
			public static String paymentAmount="(//div[@class='sb-billing-column--amount'])[";
			public static String CancelpaymentSuccessMessage="//p[@ng-if='!options.useHtml']";
			public static String cancelPendingPayment="//a[@ng-click='cancelFuturePayment(payment.cancel, $index)']";
			public static String taxesAndFeesDate="//div[@ng-repeat='charge in model.chargeDetails.taxCharges']/*/div[@class='hidden-xs hidden-sm col-md-3 ng-binding']";
			public static String taxesAndFeesDescription="//div[@ng-repeat='charge in model.chargeDetails.taxCharges']/*/div[@class='col-xs-8 col-sm-8 col-md-5 sb-billing-column ng-binding']";
			public static String taxesAndFeesAmount="//div[@ng-repeat='charge in model.chargeDetails.taxCharges']/*/div[@class='col-xs-4 col-sm-4 col-md-3 text-right ng-binding']";
			public static String taxesAndFeesHeader="//div[@class='col-xs-12'][contains(.,'Taxes, Fees & Charges')]";
			public static String taxesInfoIcon="//div[@class='col-xs-12'][contains(.,'Taxes, Fees & Charges')]//i";
			public static String lastPaymentDate="(//div[@class='sb-billing-column--payment-date ng-binding'])[";
			public static String paymentReceived="//div[contains(@class,'sb-statement-row-content')]/div[contains(.,'Payments Received')]";
			public static String paymentReceivedText="//div[@class='col-xs-8'][contains(.,'Payments Received')]";
			public static String paymentAmountText="//div[contains(@class,'sb-statement-row-content')]/div[contains(.,'Payments Received')]/following-sibling::div";
			public static String chargeDetailsList="//div[@ng-repeat='charge in model.chargeDetails.internetCharges']";
			public static String billPayOptionsTab="//div[@class='sb-nav-menu__nav-content'][contains(.,'Bill Pay Options')]";
			
			public static String returnToBillingButton="//button[@ng-click='done()']";
			public static String cancelButtonForBillPay="//a[@ng-click='cancel()']";
			public static String previousPage="//li[@ng-if='!isESM'][contains(.,'View Statements')]";
			public static String returnToLoginButton="//a[@ng-click='goToLogin()']";
			public static String userNameRecovery="//span[@class='bold ng-binding']";
			public static String checkLoginScreen="//h5[@class='ng-binding']";
			public static String manageUsersList="//div[@ng-click='toggleDetails($event, user)']";
			public static String manageEditLink="//a[@ng-click='detailOptions.editFunction()']";
			public static String checkPhoneService="//div[@ng-if='hasVoiceLines()'][contains(.,'Voice Service')]";
			public static String manageCancelButton="//a[@ng-click='actionSheetOptions.cancelFunction()']";
			public static String manageBackButton="//a[@ng-click='detailOptions.backFunction()']";
			public static String manageAddNewUser="//button[@ng-click='addNewUser()']";
			public static String manageFirstName="profileFirstName";
			public static String manageLastName="profileLastName";
			public static String manageEmailAddress="//input[@ng-model='model.newUser.profile.contactEmail']";
			public static String manageNextButton="//button[@class='sb-btn sb-btn--primary']";
			//public static String managePermissionOption="//div[@class='radio-btn radio-btn-row-cell radio-btn-cell']/i";//"basicPermissionOption";
			//public static String managePermissionOption="//form[@class='ng-pristine ng-valid ng-isolate-scope ng-valid-required']/div[@class='sb-create-member-form-container']";
			public static String managePermissionOption="//input[@id='standardPermissionOption']";
			public static String manageCheckPhoneService="//button[@ng-click='addNewLineRow($event)']";
			public static String Addcontact_EmailInputTextOne="(//input[@name='email'])[1]";
			public static String Addcontact_EmailInputTextTwo="(//input[@name='email'])[2]";
			public static String payBillButton="//a[@class='sb-btn pay-now-btn ng-binding'][contains(.,'PAY NOW')]";
			public static String payBillScreen="//li[@ng-if='!isESM'][contains(.,'Pay Bill')]";
			public static String payBillButtonNotify="(//a[@ng-href='/smb/billing.html#/billing/pay-bill'])[2]";
			public static String checkingSavingsAccount="checkingSavingsAccount";
			public static String routingNumber="//input[@ name='routingNumber']";
			public static String accountNumberInPayBill="accountNumber";
			public static String accountNumberError="accountNumberError";
			public static String creditDebitCard="//label[@class='no-wrap radio-btn-row']/div[@class='radio-btn-row-cell radio-btn-cell radio-btn']/div[@class='icon']";
			public static String manageFirstNameLabel="(//label[@class='sb-create-member--input-label required'])[1]";
			public static String manageLastNameLabel="(//label[@class='sb-create-member--input-label required'])[2]";
			public static String manageEmailAddLabel="(//label[@class='sb-create-member--input-label required'])[3]";
			public static String managePrimaryPhone="//label[@class='sb-create-member--input-label']";
			public static String manageRequired="//div[@class='sb-required pull-right']";
			public static String manageCancel="//a[@ ng-click='cancel()']";
			public static String managePhone="//input[@ng-model='model.newUser.profile.contactPhone']";
			public static String managestandardRole="//input[@id='standardPermissionOption']";//basicPermissionOption
			public static String manageBillingAndTransactions="//input[@id='billingPermissionOption']";//"//label[@for='billingPermissionOption']/div/i";
			public static String manageAdministrator="//input[@id='administratorPermissionOption']";//"//label[@for='administratorPermissionOption']/div/i";
			public static String NoVoiceLines="//div[@class='sb-create-member-header-container']//div[@ng-show='!hasLines']";
			public static String NoVoiceLinesmsg="//div[@class='sb-create-member-header-container']//div[@ng-show='!hasLines']//span[@ng-if='!html']";
			public static String manageBackText="//a[@ng-click='back()']";
			public static String manageSkip="//a[@ng-click='skipVoiceOptions()']";
			public static String manageBackLink="//a[@ng-click='detailOptions.backFunction()']";
			public static String manageCloseLink="//a[@ng-click='actionSheetOptions.cancelFunction()']";
			public static String manageUsersEditLink="//a[@ng-click='detailOptions.editFunction()']";
			public static String manageUsersFirstName="contact-first-name";
			public static String manageUsersLastName="contact-last-name";
			public static String managePhoneNumber="contact-phone";
			public static String manageUsersEmailAddress="contact-email";
			public static String manageDropDownButton="//button[@class='sb-btn dropdown-toggle ng-binding']";
			public static String manageSaveButton="//button[@ng-click='actionSheetOptions.saveFunction()']";
			public static String manageCancelPopUp="//a[@ng-click='secondaryButtonFunction ? secondaryButtonFunction($event) : $dismiss()']";
			public static String manageConfirmPopUp="//button[@ng-click='primaryButtonFunction ? primaryButtonFunction($event) : $close()']";
			public static String manageUsersListInManageUsers="//div[@ng-click='toggleDetails($event, user)']";
			public static String verifyVoiceLine="(//div[@class='line-text ng-binding'])[1]";
			public static String VoiceLineValue="//div[@ng-repeat='line in assignedLines']//button[@type='button']/div/div[1]";
			public static String manageVoiceLineButton="//button[@ng-click='addNewLineRow($event)']";
			public static String manageDisabledNextButton="//button[@disabled='disabled']";
			public static String manageConfirmButton="//button[@ class='sb-btn sb-btn--primary']";
			public static String manageCancelLinkInPopUp="//a[@ng-click='secondaryButtonFunction ? secondaryButtonFunction($event) : $dismiss()']";
			//public static String billingCardNumber="//input[@ng-class=\"{'error': debouncedErrors.cardNumber }\" ]";
			public static String billingExpirationDate="expirationDate";
			public static String billingDisabledPayNowButton="//button[@disabled='disabled']";
			public static String errorMessageForInvalidCard="//div[@id='creditCardNumberError']/div";
			public static String errorMessageForExpirationDate="//div[@class='ng-binding'][contains(.,'Please enter a valid expiration date.')]";
			public static String oneTimePayment="oneTime";
			public static String billingPaymentAmount="paymentAmount";
			public static String billingPaymentDate="paymentDate";
			public static String billingPayNowButton="//button[@class='sb-btn sb-btn--primary pull-right'][contains(.,'Pay Now')]";
			public static String billingCompletePayment="//button[@class='sb-btn sb-btn--primary'][contains(.,'Complete Payment')]";
			public static String billingReturnToOverview="//button[contains(.,'RETURN TO OVERVIEW')]";
			public static String deliveryOption="//div[@class='sb-content-row single-content-header-row billing-header-dark'][contains(.,'Modify Delivery Options')]";
			public static String onlineBillText="(//strong[text()[contains(.,'Online Bill')]])[1]";
			public static String paperBillText="(//strong[text()[contains(.,'Online Bill')]])[2]";
			public static String manageusersTitle="//li[@class='toolbar-main sb-tablet--hidden toolbar__service ng-binding'][contains(.,'Manage Users')]";
			public static String manageUserNameList="//div[@ng-click='toggleDetails($event, user)']/div[@class='sb-manage-users-list-column--name ng-binding']";
			public static String manageUsersRoleList="//div[@ng-click='toggleDetails($event, user)']/div[@class='sb-manage-users-list-column--role ng-binding']";
			//public static String manageusersSearch="//input[@class='ng-pristine ng-untouched ng-valid ng-valid-maxlength'][@placeholder='Search']";
			public static String manageSearchClear="//button[@ng-click='reset()']";
			public static String autoPayId="autoPay";
			public static String autoPayIdNew="//label[@for='autoPay']/div[@class='radio-btn-row-cell radio-btn-cell radio-btn']/div[@class='icon']";
			public static String acceptTermsAndConditions="//label[@for='acceptTermsAndConditions']/div[1]/div/div";
			public static String billingSaveautoPayButtonInConfirm="//button[@type='submit' and .='Save Auto Pay']";//button[@class='sb-btn sb-btn--primary'][contains(.,'Save Auto Pay')]";
			//public static String billingSaveautoPayButton="//button[@class='sb-btn sb-btn--primary pull-right'][contains(.,'Save Auto-Pay')]";
			public static String cancelAutoPay="//a[@ng-click='cancelAutoPay()']";
			//public static String overviewClickAutopay="//a[@class='btn cb-btn-blue index-button'][contains(.,'Overview')]";
			//public static String autoPayUnenrollment="//button[@class='sb-btn sb-btn--primary pull-right ng-binding ng-scope'][contains(.,'Complete Unenrollment')]";
			public static String callForwardingToggle="//button[@class='sb-toggle-switch']";
			public static String saveButtonInVoice="//button[@ng-click='saveSettings()']";
			public static String closeButtonInVoice="//a[@ng-click='confirmCancel(true)']";
			public static String cancelButtonInVoice="//span[@ class='ng-scope'][contains(.,'CANCEL')]";
			public static String forwardingMethodToggle="//button[@class='sb-toggle-switch-text']";
			public static String forwardAllCallsTo="//div[@ng-click='showDropdown()']";
			public static String manageForwardingLines="//button[@ng-click='manageForwardingLines()']";
			public static String voiceSettingsButtonInVoice="//button[@class='settings-button sb-btn sb-btn--alternate sb-btn--icon dropdown-toggle']";
			public static String routingNumberHelpIcon="//div[@class='sb-cell-content']/fieldset[2]/div/div[@class='sb-account-input']//a[1]";
			public static String accountNumberHelpIcon="//div[@class='sb-cell-content']/fieldset[2]/div/div[@class='sb-account-input']//a[2]";
			public static String modalDescription="modalDescription";
			public static String okButtonModal="//button[@class='sb-btn sb-btn--primary pull-right ng-binding ng-scope'][contains(.,'Ok')]";
			public static String spectrumInternetDate="(//div[@ng-repeat='charge in model.chargeDetails.internetCharges']/*/div[@class='hidden-xs hidden-sm col-md-3 ng-binding'])[";
			public static String spectrumInternetDesc="(//div[@ng-repeat='charge in model.chargeDetails.internetCharges']/*/div[@class='col-xs-8 col-sm-8 col-md-5 sb-billing-column ng-binding'])[";
			public static String spectrumInternetAmount="(//div[@ng-repeat='charge in model.chargeDetails.internetCharges']/*/div[@class='col-xs-4 col-sm-4 col-md-3 text-right ng-binding'])[";
			public static String spectrumInternetHelp="(//div[@ng-repeat='charge in model.chargeDetails.internetCharges']/*/div[@class='hidden-xs hidden-sm col-md-1']/*/i[@class='icon icon--small icon--med-blue sb_ic_circle_info_f'])[1]";
			public static String spectrumTVDate="(//div[@ng-repeat='charge in model.chargeDetails.tvCharges']/*/div[@class='hidden-xs hidden-sm col-md-3 ng-binding'])[";
			public static String spectrumTVDesc="(//div[@ng-repeat='charge in model.chargeDetails.tvCharges']/*/div[@class='col-xs-8 col-sm-8 col-md-5 sb-billing-column ng-binding'])[";
			public static String spectrumTVAmount="(//div[@ng-repeat='charge in model.chargeDetails.tvCharges']/*/div[@class='col-xs-4 col-sm-4 col-md-3 text-right ng-binding'])[";
			public static String spectrumPhoneDate="(//div[@ng-repeat='charge in model.chargeDetails.phoneCharges']/*/div[@class='hidden-xs hidden-sm col-md-3 ng-binding'])[";
			public static String spectrumPhoneDesc="(//div[@ng-repeat='charge in model.chargeDetails.phoneCharges']/*/div[@class='col-xs-8 col-sm-8 col-md-5 sb-billing-column ng-binding'])[";
			public static String spectrumPhoneAmount="(//div[@ng-repeat='charge in model.chargeDetails.phoneCharges']/*/div[@class='col-xs-4 col-sm-4 col-md-3 text-right ng-binding'])[";
			public static String spectrumPhoneHelp="(//div[@ng-repeat='charge in model.chargeDetails.phoneCharges']/*/div[@class='hidden-xs hidden-sm col-md-1']/*/i[@class='icon icon--small icon--med-blue sb_ic_circle_info_f'])[1]";
			public static String spectrumTVHelp="(//div[@ng-repeat='charge in model.chargeDetails.tvCharges']/*/div[@class='hidden-xs hidden-sm col-md-1']/*/i[@class='icon icon--small icon--med-blue sb_ic_circle_info_f'])[1]";
			public static String bankInformationTitle="//h4[contains(.,'Bank Information')]";
			public static String accountTypeTitle="//legend[contains(.,'Account Type')]";
			public static String routingNumberTitle="//span[contains(.,'9-Digit Routing Number')]";
			public static String accountNumberTitle="//label[contains(.,'Bank Account Number')]";
			public static String supportLinkInBilling="//a[@ng-click='navigate(URL.CMS_SUPPORT)']";
			public static String notificationPanel="//div[@class='col-sm-4 col-md-4 col-lg-3 sb-notification-panel hidden-xs']";
			public static String notificationMessage="//p[contains(.,'No notifications at this time')]";
			public static String supportHeader="//a[@ng-href='https://www.engprod2-spectrumbusiness.net/support']/div/i";
			public static String helloUser="(//div[@class='ng-binding'])[1]";
			public static String companyName="(//div[@class='ng-binding'])[2]";
			public static String accountDropDown="(//div[@class='sb-nav-menu__nav-content ng-binding'])[3]";
			public static String loginDropDown="//div[@class='sb-nav-item']/div[@class='hidden-xs']";
			public static String securityDropDown="(//div[@class='sb-nav-menu__nav-content'])[1]";
			public static String profileDropDown="(//div[@class='sb-nav-menu__nav-content'])[3]";
			public static String companyDropDown="(//div[@class='sb-nav-menu__nav-content'])[4]";
			public static String signoutDropDown="(//div[@class='sb-nav-menu__nav-content'])[5]";
			public static String otherPaymentOption="other";
			public static String requiredRoutingNumber="(//label[@class='sb-input--label required'])[1]";
			public static String requiredAccountNumber="(//label[@class='sb-input--label required'])[2]";
			public static String requiredTextInPayBill="//div[@class='sb-required']";
			public static String forgotPasswordDevWG="//a[@ class='btn btn-link sm'][contains(.,'Forgot Password')]";
			public static String resetPasswordRB="resetPasswordOption";
			public static String accountNumberIF="accountNumber";
			public static String securityFieldIF="securityCode";
			public static String nextButtonRP="//button[@class='btn btn-primary'][contains(.,'Next')]";
			public static String securityAnswerRP="securityAnswer";
			public static String cancelButtonRP="//button[@ng-click='cancel()']";
			public static String disabledNextButtonRp="//button[@disabled='disabled']"; 
			public static String pastDueBillAdmin="//span[@class='text--style-r14-3 text-gray-1 ng-scope']";
			public static String overpaidBill="//span[@class='bold'][contains(.,'Due By')]/following-sibling::span/span";
			public static String dueByField="//span[@class='bold'][contains(.,'Due By')]";
			public static String printTC="//a[@class='sb-print-tc-link sm semi-bold']";
			public static String disabledSavePaybill="//button[@disabled='disabled']";
			public static String cancelButtonPayBill="//a[@ng-click='cancelPayment()'][contains(.,'CANCEL')]";
			public static String okButtonPayBill="//button[@class='sb-btn sb-btn--primary pull-right ng-binding ng-scope'][contains(.,'Ok')]";
			public static String supportLinkPayBillTC="//a[@ng-click='navigate(URL.CMS_SUPPORT)']";
			public static String supportPageVerify="//div[@class='support-hero']/*/h1[contains(.,'Search Support')]";
			public static String saveAutoPay="//button[@class='sb-btn sb-btn--primary pull-right'][contains(.,'Save Auto-Pay')]";
			public static String saveAutoPayInfo="//button[@class='sb-btn sb-btn--primary'][contains(.,'Save Auto Pay')]";
			public static String EditPaymentDetailsLinkAutoPay="//a[contains(text(),'Edit Payment Details')]";
			//Voice Overview	
		
		//public static String Voice_VoiceOverview="//a[contains(@href,'overview')]/i";//i[@class='icon icon--small-med icon--med-blue sb_ic_3x3_grid_f']";
		public static String Voice_VoiceIcon="//i[@class='icon icon--med-blue sb_ic_phone_large']";
		public static String Voice_SingleLine="//div[@ng-if='model.phoneNumbers.length === 1']";
		public static String Voice_VoiceTile="//a[@href='/smb/voice.html']";
		
		
		
	//Contacts UI 
		public static String Contact_Click="//div[@id='sb-content-container']/main/div/div[2]/div[3]/div/div/div[1]/div/div[1]";
		public static String Contacts_UI = "//div[@ng-hide='loading.numbers']//div[@href='#/voice/contacts']";
		public static String Contact = "//div[@class='single-content-name ng-binding']";
		public static String Contact_Info = "//div[@class='sb-detail__title sb-detail__header-text']";
		public static String ContactUI_Name= "//div[3][@class='sb-detail__section-header sb-detail__header-text']";
		public static String Contact_Name= "//div[1][@class='sb-detail__text-item ng-binding']";
		public static String FirstName = "//div[1][@class='sb-detail__text-item ng-binding']";
		public static String Role = "//div[@id='sbDetailContent']/div[2]/div[4]/div/div[2]";
		public static String Organization = "//div[3][@class='sb-detail__text-item ng-binding']";
		public static String Phone_Email_Address = "//div[1][@class='sb-detail__section-header sb-detail__header-text']";
		public static String Phone_Work ="//div[1][@class='sb-detail__header-text ng-binding']";
		public static String phone_Number = "//div[2][@class= 'sb-detail__text-item ng-binding']";
		public static String Email_Id="//a[@class='ng-binding']";
		//Changed -->Changes Done 
		public static String Address_ContactsUI="//div[7][@class='sb-detail__row ng-scope']";
		//
		
		//Contacts UI EDIT 
		
		public static String Edit = "//a[@ng-click='detailOptions.editFunction()']";

// Voice messages Delete and Cancel
	public static String Overview_Voicetile ="//a[@href='/smb/voice.html']";//div[@ ng-if='has.phone']/a[@href='./voice.html']";
	public static String DeletedMessages_Button="//button[2][@ng-if='!deleted']";
	
	//Same Objects with Same Xpath
	//public static String MessageLink="//div[@ng-hide='loading.numbers']//div[@href='#/voice/messages/']";
	//public static String Voice_VoiceMessageList="//div[@ng-if='message.messageType === UICONSTANTS.VOICE_MESSAGE_VOICEMAIL']";
	//End
	public static String DeleteConfrmPopup="//div[@ng-click='$event.stopPropagation()']";
	public static String Delete_CancelButton="//div[@ng-if='modalOptions.showFooter']//a[.='Cancel']";
	public static String Delete_ConfirmButton="//button[@ng-click='primaryButtonFunction ? primaryButtonFunction($event) : $close()']";
	
//Fax messages Delete and cancel
	
	public static String Voice_FaxMessageList="//div[@ng-if='message.messageType === UICONSTANTS.VOICE_MESSAGE_FAX']";
	public static String Fax_Delete="//div[@id='message-details-section' and  @aria-expanded='true']//a[.='Delete']";//a[@ng-click='confirmDelete('single', message); stopCollapseToggle($event);']";

//Changes for Q2-Demo Automation - Start
	public String VoiceMessagesList = "//div[@class='panel-heading col-xs-12 sb-heading--collapsed']" ;
	public static String Overview_VoiceTab="//a[@href='/smb/voice.html']";//div[@ng-if='has.phone']/a[@href='./voice.html']";
	//Same Objects with Same Xpath
	//public static String Voice_VoiceMessageList="//div[@ng-if='message.messageType === UICONSTANTS.VOICE_MESSAGE_VOICEMAIL']";
	//public static String Voice_VoiceContactName="//div[@class='sb-panel--column sb-panel--third-column' ]";
	//End
	public static String Voice_AllMessagesList = "//div[@class='panel-heading col-xs-12 sb-heading--collapsed']";
	//public static String OverviewLink="//div[@role='menu']/div/ul/li[5]";
	public static String Voice_MissedCallLogs = "//div[@ng-switch-when='Missed']";
	public static String Video_TVPageLoaded = "//body[@ng-app='sbnet.pages.tv']";
	//public static String Voice_CallDetailsList = "//div[@class='col-xs-6']";
	//Changes for Q2-Demo Automation – End


	
	
	//Saranya[10/8/2015]
    public static String ManageLine_SaveButton="//button[@ng-click='actionSheetOptions.saveFunction()']";

	public static String NewAssignList="//form[@ng-submit='saveFunction()']/div[@ng-click='toggleSelectedUser(user)'][2]";
	//public static String NewAssignTEXT="//div[@ng-show='!model.isTollFree']";
	public static String UnassignedContactList="//div[contains(@ng-if,'!line.isAssigned')]";
	//public static String Assign_SaveBtn="//div[@ng-hide='!showAddAssignment']//button[@ng-click='actionSheetOptions.saveFunction()']";
	//public static String cancelbtn_ModifyAssignLine="//div[@ ng-hide='!showAddAssignment']//a[@ ng-click='actionSheetOptions.cancelFunction()']";

	//harpreet
	 public static String Voice_ConfirmPopup ="//button[@ng-click='primaryButtonFunction ? primaryButtonFunction($event) : $close()']";
	    public static String Voice_CancelPopup ="//*[@ng-click='secondaryButtonFunction ? secondaryButtonFunction($event) : $dismiss()']";
	    public static String Invalid_Credentials="//span[@class='alert-icon']";
	    public static String Invalid_credentials="//div[@ng-if='loginError && !useHtml']";
	    public static String Voice_UnBlockLink="//a[@ng-if='message.blocked']";
	    public static String Voice_Voice_UnBlockLink ="//*[@id='message-details-section']/div[2]/span[1]/a[@ng-if='message.blocked']";
	    public static String Voice_FaxDelete= "//div[@ aria-expanded='true']//a[.='Delete']";
	    
	    public static String Voice_faxSavedContact=   "//div[@ng-if='message.messageType === UICONSTANTS.VOICE_MESSAGE_FAX']//ancestor::div/following-sibling::div/div";
	    
	    public static String Voice_FaxPreview="//img[@title='Fax Preview']";	
	    public static String  Voice_Openpdf="//a[@ng-click='downloadFax(message); stopCollapseToggle($event)']";
	    public static String  Call_detailsBlock="sbDetailContent";
	    public static String  Call_CreateNewContactLink=  "//*[@ng-click='createNewContact()']";
	    public static String  Call_ContactFirstName="contact-first-name";
	    public static String  Call_ContactLastName ="contact-last-name";
	    public static String  Call_ContactSave=  "//*[@ng-click='actionSheetOptions.saveFunction()']";
	    public static String  Calldetails_Cancel ="//*[@ng-click='actionSheetOptions.cancelFunction()']";
	    public static String  Calldetails_Back ="//*[@ng-click='detailOptions.backFunction()']";
	    public static String  Call_Searchbox="//*[@placeholder='Search']";
	    public static String  Call_SearchIcon ="//i[@class='icon sb_ic_search']";
	    public static String  Call_DeatilsSectionBack= "//*[@ng-click='detailOptions.backFunction()']";
	    public static String  Call_MissedFilter="//*[@ng-click='updateFilter(missed)']/span";
	    public static String  Call_Filter ="dropdownXsFilterDropdown";
	    public static String Voice_UnBlock="//*[@ng-if='details.blocked']"; 
	    public static String  Call_ExistingContactLink="//*[@ng-click='addToExistingContact()']";
	    public static String  Call_ExistingContact="//div[@class='single-content-name ng-binding']";
	    public static String  Call_ResetButton=("//button[@ng-click='reset()']/i");
	    public static String  missedCalls  ="text--style-r16-3 no-wrap ng-binding missed-call";
	    public static String  unable_To_Save ="//*[@id='sbDetailContent']/div[2]/div[2]/div[1]/div/div[2]/div/div/div/div/div[2]/p";
	    public static String  Contact_edit="//*[@ng-click='detailOptions.editFunction()']" ;
		public static String Voice_Block_Messages="//*[@id='message-details-section']/div[2]/span[1]/a[@ng-if='!message.blocked']";
		public static String Voice_Block_ErrorMessage="//div[@class='sb-block-message__message']/div[2]/p";
		public static String Voice_Voice_ContactName="//div[@ng-if='message.messageType === UICONSTANTS.VOICE_MESSAGE_VOICEMAIL']/ancestor::div[@class='sb-panel--column sb-panel--second-column']/following-sibling::div[@class='sb-panel--column sb-panel--third-column no-caller-location caller-location']/div";
				//"//div[@ng-if='message.messageType === UICONSTANTS.VOICE_MESSAGE_VOICEMAIL']/ancestor::div[@class='sb-panel--column sb-panel--second-column']/following-sibling::div[@class='sb-panel--column sb-panel--third-column']/div";
		
		public static String Fax_ContactName="//div[@ng-if='message.messageType === UICONSTANTS.VOICE_MESSAGE_FAX']/ancestor::div[@class='sb-panel--column sb-panel--second-column']/following-sibling::div[@class='sb-panel--column sb-panel--third-column']/div[contains(text(),'Unknown')]";
		public static String Fax_ContactNameALL="//div[@ng-if='message.messageType === UICONSTANTS.VOICE_MESSAGE_FAX']/ancestor::div[@class='sb-panel--column sb-panel--second-column']/following-sibling::div[@class='sb-panel--column sb-panel--third-column']/div";
		
		public static String Voice_FaxMessageExpandedDiv="//div[@id='message-details-section' and contains(@aria-hidden,'false')]";
		public static String ContactNumber_List ="//*[ @type='text' and @name='phoneNumber']";
		public static String Contact_NumberList="//*[@class='sb-detail__text-item ng-binding']";
    //Ajoy [08/10/2015]
	public static String Past_Due="//div[@ng-if='!model.currentBill.autoPayEnrolled']/span"; //html/body/div[1]/main/div/div/div/div[2]/div/div/div[2]/div[2]/div/div[2]/span
	public static String Pay_Bill="//div[@class='sb-spaced-row']/a[@ng-href='/smb/billing.html#/billing/pay-bill']";//"//a[@ng-href='./pay-bill.html' and @class='btn btn-primary']";
	public static String PayBill_Page="//li[4][@class='toolbar-main sb-tablet--hidden toolbar__section ng-binding ng-scope']";
    
	
	
	//Saranya[10/9/2015]
		public static String VoiceLink="//*[@href='/smb/voice.html']";
	    public static String SearchBar="//input[@type='text' and @placeholder='Search']";
	    public static String SearchResultList=" //div[@ ng-click='openDetails($event, contact)']";
	    public static String Sorting_arrowClick="//*[@id='dropdownXsSortDropdown']/i";
	    public static String SortingA_Z="//a[contains(@ng-click,'asc')]";
	    public static String SortingZ_A="//a[contains(@ng-click,'desc')]";
	    public static String Contact_List=" //div[@ ng-click='openDetails($event, contact)']";
	    
	    
	  //Priyanka[10/9/2015]
	    
	    
	    public static String Logo="//img[@class='logo']";
	    public static String headerDropdown="//i[@class='icon sb_ic_chevron_down ng-scope']";
	    //public static String LogoutHeader="//div[@ng-click='signOut()']";
	    public static String LogoutHeader="//span[contains(.,'Sign Out')]";
	    public static String ReturnToHome="//div[@class='button-row']//a[@href='/index.html']";

	    
	    //saranya[10/12/2015]
	    public static String AddNewLine="//button[@ng-click='addNewLineRow($event)']";
	    public static String ForwardOnLine_StatusLine="//div[contains(@ng-if,'internalLines.length')]/div[contains(.,'Status')]";
		//"//div[@ ng-if='model.lines && model.lines.length > 0']//div[contains(.,'Status')]";
	    public static String ForwardOnLine_ReceivingNoLabel="//div[contains(@ng-if,'internalLines.length')]/div[contains(.,'Receiving Number')]";
		//"//div[@ ng-if='model.lines && model.lines.length > 0']//div[contains(.,'Receiving Number')]";

	    public static String ForwardOnLine_Forward_ifLabel="//div[contains(@ng-if,'internalLines.length')]/div[contains(.,'Forward if')]";
		//"//div[@ ng-if='model.lines && model.lines.length > 0']//div[contains(.,'Forward if')]";
	    public static String ForwardOnLine_Forward_TOLabel="//div[contains(@ng-if,'internalLines.length')]/div[contains(.,'Forward to')]";
		//"//div[@ ng-if='model.lines && model.lines.length > 0']//div[contains(.,'Forward to')]";


	    public static String ForwarInternalLabel=" //div[contains(@class,'toll-free')]//div[contains(.,'Internal Lines')]";
	    public static String ForwarExrernalLabel="//div[contains(@class,'toll-free')]//div[contains(.,'External Lines')]";
	    public static String ForwardLineList="//div[@ng-click='toggleActionSheet($event, line)']";
	    //public static String OverviewLink="//div[@ng-click='goTo('overview')']";
	   // public static String OverviewLink="//ul[@class='sb-nav-menu']/li[5]/div/div[contains(text(),'Overview')]";
	    public static String OverviewLink="//div[@ng-click='goTo(overviewUrl)']";
	    public static String OverviewLink_V1_Support="//ul[@class='sb-nav-menu']/li[5]/div/div[contains(text(),'Overview')]";
	    public static String Access_AdminVoicePanel="//div[@ng-if='hasAdminLine()']/div[@ng-click='manageVoiceAdminLinkClick()']";
	    
	    
	    
	  //Saranya[10/13/2015]
	    
	    public static String MessageLineLink="//div[@ng-hide='loading.numbers']//div[@href='#/voice/messages/']";
	    public static String DeleteMessagebutton="//button[@ng-if='!deleted']";
	    public static String MessageList="//div[@ ng-click='toggleCollapse($event, message, $index)']";
	    
	    //Saranya[10/14/2015]
	    public static String FooterDotLink="//i[@title='Expand or Collapse Footer']";
	    public static String FooterSupportLabel="//h5[.='Support']";
	 
	    public static String Footer_FiberCoaxLabel="//div[@class='ftr-box']//a[contains(.,'Fiber')]";
	    public static String Footer_TechicalSupport="//div[@class='ftr-box']//a[contains(text(),'Technical Support')]";
	    public static String Footer_CharterStore="//div[@class='ftr-box']//a[contains(text(),'Charter Store')]";
	    
	    public static String Footer_ManageAccount="//h5[contains(.,'Manage Account')]";
	    public static String Footer_Overview="//div[@class='ftr-box']//a[contains(.,'Overview')]";
	    public static String Footer_BillingTrans="//div[@class='ftr-box']//a[contains(.,'Billing')]";
	    public static String Footer_CurrentBill="//div[@class='ftr-box']//a[contains(text(),'Current Bill')]";
	    public static String Footer_BillDelivery="//div[@class='ftr-box']//a[contains(text(),'Bill Delivery')]";
	    public static String Footer_BussinessProfile="//div[@class='ftr-box']//a[contains(text(),'Business Profile')]";
	    public static String NewTab_LogoCheck="//img[@class='logo']";
	    public static String LinkedInLogo="//div[@class='join-cta']/a";
	    public static String LinkedInLogoOne="//a[@id='li-logo']";
	    public static String TermsdPage="//div[@id='termsOfService']/p";
	    
	    public static String Footer_CharterCorporate="//h5[contains(.,'Charter Corporate')]";
	    public static String Footer_AboutUs="//div[@class='ftr-box']//a[contains(.,'About Us')]";
	    public static String Footer_AboutUsPage="//h1[@class='header' and contains(.,'About Spectrum Business')]";
	    public static String Footer_Guarantee="//div[@class='ftr-box']//a[contains(.,'Guarantee')]";
	    public static String Footer_GuaranteePage="//h1[@class='header' and contains(.,'Guarantee')]";
	    public static String Footer_CharterLogo="//i[@class='icon icon--med sb_ic_charter_comm_logo']";
	    
	    public static String Footer_PrivatePolicies="//ul[@class='legal-links']/li/a[contains(.,'Privacy Policies')]";
	    public static String Footer_PrivatePoliciesPage="//h1[@class='header' and contains(.,'Privacy Policy')]";
	    public static String Footer_TermsService="//ul[@class='legal-links']/li/a[contains(.,'Terms of Service')]";
	    public static String Footer_TermsServicePage="//div[@id='termsOfService']/h1";
	    public static String Footer_CharterComm="//ul[@class='legal-links']//li[contains(.,'Charter Communications')]";
	    public static String Footer_Linkedin="//i[@title='LinkedIn']";
	    public static String Footer_facebook="//i[@title='Facebook']";
	    public static String Footer_Twitter="//i[@title='Twitter']";
		
	    //public static String CallLogedit="//a[@ng-click='detailOptions.editFunction()']";
		// public static String Calllog_callLogLink="//div[@ng-hide='loading.numbers']//div[@href='#/voice/call-logs/']";
		// public static String Savedcontacts="//div[contains(@ng-class,'call.type')]";
	  //Priyanka [10/7/2015]
	
		public static String HomepageConfirmation="//h1[.='Welcome to Spectrum Business']";
		
		
		
		//Priyanka [10/12/2015]
		
		
	 	
	 	public static String Alias_ForwardingNumber="//input[@ng-model='line.alias']";
	 	public static String Number_forwardingNumber="//input[@ng-model='line.number']";
	 	public static String AddPhoneNo_ForwardingLines="//button[@ng-click='addLine()']";
	   
	    public static String ManageForwardingLines="//div[@ng-if='model.forwardingEnabled']/div[7]/button[contains(.,'MANAGE FORWARDING LINES')]";
	 	public static String NewAlias="//input[@ng-model='line.alias' and @value='']";
	 	public static String NewPhoneNo="//input[@ng-model='line.number' and @value='']";
	 	public static String DuplicateError_Alias="//div[@ng-if='isDuplicate' and contains(.,'Alias')]";
	 	public static String DuplicateError_Number="//div[@ng-if='isDuplicate' and contains(.,'Number')]";
	 	public static String ManageForwardingLines_Save="//button[@ng-click='primaryButtonFunction($event)']";
	 	public static String ManageForwardingLines_Cancel="//a[@ng-click='secondaryButtonFunction($event)']";
	 	public static String EmergencyError="//div[@ng-if='is911']";
	 	public static String DeleteForwardContact="//button[@ng-click='deleteLine($index);']";
	 	
	 	public static String ForwardImmediate="//div[@ng-click='toggleImmediate()']/button[@ng-click='toggleState()']";
	 	public static String ForwardAnswerCall="//div[@ng-click='toggleBusyNoAnswer()']/button[@ng-click='toggleState()' ]";
	 	public static String ForwardImmediate_ContactBtn="//div[@ng-if='model.details.callForwardSettings[0].Enabled']//button;//[@ng-if='model.forwardingNumbers.length > 1']";
	 	public static String FwdImmediate_List="//div[@ng-if='model.details.callForwardSettings[0].Enabled']//ul/li[2]/a/span";
	 	public static String ForwardAnswer_contactBtn="//div[@ng-if='model.details.callForwardSettings[1].Enabled']//button;//[@ ng-if='model.forwardingNumbers.length > 1']";
	 	public static String ForwarAnswer_List="//div[@ng-if='model.details.callForwardSettings[1].Enabled']//ul/li[2]/a/span";
	 	public static String Billing="//div[@activity='BILLING_ADMINISTRATION']/a[.='Billing']";
	    public static String ManageUsers="//a[@href='/smb/manage-members.html#/manage/list']";
	    		//"//div[@class='sb-container__content']/div[6]/div/a[.='Manage Users']";
	    public static String MyProfile_MyAccount="//a[@ng-href='/smb/profile.html']";
	    //Saranya clean Up[12/23/2015]
	    public static String CompanyProfile_MyAccount="//div[@activity='ACCOUNT_ADMINISTRATION']/a[.='Company Profile']";//div[@class='sb-container__content']/div[6]/div/a[.='Company Profile']";
	    public static String Support_MyAccount="//div[@class='sb-container__content']/div[6]/div/a[.='Support']";  
	    public static String Logout="//div[@ng-click='signOut()']";
		public static String VerifyLogout="//div[@class='container']//h5[.='Logout']";
		 public static String CompanyProfileurl="//h1[.='Company Profile']";
		public static String ForgotUserNamePassword="//a[@href='/account-recovery.html'and @class='forgot-username-link ng-scope']";
		public static String FirstTimeHeretext="//h2[.='First Time Here']";
		public static String CreateNewId="//a[@href='/create-account.html'and @class='register-account-link ng-scope' ]";
		public static String CreateNewIdpage="//h5[.='Account Registration']";
		public static String ForgotUserNamePassword_Link="//div[@class='sb-menu--row']//a[@href='/account-recovery.html']//i";
		public static String VerifyRecoveryUsernamePwdpage="//div[@class='container']//h5[.='Recover Username/Password']";
		
		//Saranya[10/15/2015]
	    
	    public static String ManageLine_CancelBtn="//a[@ ng-click='actionSheetOptions.cancelFunction()']"; 
	    public static String Assign_SaveBtn="//button[@ng-click='secondaryActionSheetOptions.saveFunction()']";//div[@ng-hide='!showAddAssignment']//button[@ng-click='actionSheetOptions.saveFunction()']";
		public static String NewAssignTEXT="//div[@ng-show='!model.isTollFree']/div";
		
		
		//Forward:
		public static String cancelbtn_ModifyAssignLine="//a[@ng-click='secondaryActionSheetOptions.cancelFunction()']";//div[@ ng-hide='!showAddAssignment']//a[@ ng-click='actionSheetOptions.cancelFunction()']";

		
		public static String AddNewAssignmentLine="//button[@ng-click='addAssignment()']/i";//button[@ng-click='addAssignment()']";
		
		
		
		
		//Saranya[10/20/2015]
		
		public static String VoiceSettings="//div[@is-open='voiceSettingsMenu.nonMobile']/button";
	    public static String VoiceSettingsMenu="//div[@ng-transclude='ng-transclude']/div[5]//div[@ng-controller='voiceSettingsCtrl']";
		public static String ForwardCall_status="//div[@ng-click='toggleDetails($event, line)']/div[1]";
	    public static String ForwardCall_Offsatus="//div[.='Off']";
	    public static String ForwardCall_Onstatus="//div[.='On']";
	    public static String ForwardCallLink="//div[@ng-hide='loading.numbers']//div[@href='#/voice/forwarding-manager']";
	    public static String ForwardCallList_Internal="//div[@ng-repeat='line in model.lines | filter:isInternal']";
	    public static String ForwardCallList_First="//*[@ng-if='line.alias']";
	    public static String ForwardCallList_First_Status="//div[contains(@class,'status')]";
	    public static String ForwardCall_CloseButton="//a[@ng-click='confirmCancel(true)']/span[.='CLOSE']";//div[@class='sb-menu sb-menu__call-forwarding']/div/a/span[.='CLOSE']";
	    public static String ForwardCall_SaveButton="//button[@ng-click='saveSettings()']";//div[@class='sb-menu sb-menu__call-forwarding']/div/button[.='SAVE']";
	    public static String ForwardingCall_StatusOnOff="//div[@enabled-state='model.forwardingEnabled']/button[@ng-click='toggleState()']";
	    public static String ForwardingMethod="//div[@enabled-label-text='PRIOR TO RING' and @disabled-label-text='IF BUSY OR AWAY']/button[@ng-click='toggleState()']";
	    public static String ForwardAllCallsTo_Dropdown="//div[@ng-click='showDropdown()']//span";
	    public static String ForwardAllCallsTo_NotDropdown="//div[@class='call-forwarding-dropdown']/div[@ng-if='model.priorToRing']/div";
	    public static String ForwardAllCallsTo_NoVoiceLines="//div[@class='call-forwarding-dropdown']/div[@ng-if='model.priorToRing']/div";
	    public static String ForwardOnStatus="//div[@ng-transclude='ng-transclude']/div[5]//ul[1]/li[2]//span[.='On']";
	    public static String ForwardOffStatus="//div[@ng-transclude='ng-transclude']/div[5]//ul[1]/li[2]//span[.='Off']";
	    public static String FwdAllCalls_Menu="//div[@ng-controller='forwardAllCallsCtrl']";
	    public static String VoiceSettingsMenu_FwdAllCalls="//div[@ng-transclude='ng-transclude']/div[5]//ul[1]/li[2]/div[1]//div[contains(.,'Forward All Calls')]";//div[@ng-transclude='ng-transclude']/div[5]//div[@ng-controller='voiceSettingsCtrl']//li[contains(.,'Forward All Calls')]";
	    public static String ForwardCallsToList="//ul[@ng-if='showSelectableLines']/li";
			//"//div[@ng-if='model.priorToRing']//ul/li";	 	
	    public static String ForwardStatusOFFToggle="//div[@enabled-state='model.forwardingEnabled']/button[ @aria-checked='false']";
	 	public static String ForwardStatusONToggle="//div[@enabled-state='model.forwardingEnabled']/button[ @aria-checked='true']";
	 	public static String CancelBtn="//a[@ng-click='confirmCancel(true)']/span[.='CANCEL']";
	 	public static String CancelPopUp="//div[@ng-click='$event.stopPropagation()']";
		public static String CancelPopUp_ConfirmBtn="//button[.='CONFIRM']";
		public static String  Voice_OpenpdfBtn="//div[@ aria-expanded='true']//a[.='Open PDF']";
	    public static String  Voice_BlockBtn="//div[@ aria-expanded='true']//a[.='Block']";
	    public static String  Voice_DeleteBtn="//div[@ aria-expanded='true']//a[.='Delete']";
	    public static String  Voice_UnblockBtn="//div[@ aria-expanded='true']//a[.='Unblock']";
	    public static String  Voice_RecoverBtn="//div[@ aria-expanded='true']//a[.='Recover']";
	    
	    
	    
	    /*
	     * Ajoy Temp
	     */
	   
	  //Fax messages Delete and cancel
		
		
	public static String AddToContacts="//a[@ng-click='createNewContact()']";
		public static String AddToContacts_FirstName="//input[@id='contact-first-name']";
		public static String AddToContacts_Cancel="//a[@ng-click='actionSheetOptions.cancelFunction()']";
		public static String AddToContacts_ConfirmPopup="//button[@ng-if='modalOptions.buttonText && modalOptions.buttonOmniture']";
		
		
		//Saranya[10/27/2015
		
		public static String Exportbutton="//button[contains(.,'EXPORT')]";
		
		
		
		  //Priyanka[27-10-2015] Iteration 2 CompanyProfilePage//
	    
		
		//Saranya ClaenUP[12/23/2015]
		
	    public static String CompanyProfile_ServiceAddresscheckbox="//label[contains(@for,'ServiceAddress')]//div[contains(@class,'checkbox')]/i";
	    public static String CompanyProfile_ServiceAddresscheckbox_Selection="//label[contains(@for,'ServiceAddress')]/input[contains(@id,'ServiceAddress')]";//input[@type='checkbox']";
	   
	    
	    public static String CompanyProfile_StreetAddress1="//div[@for='addressName']";
	    public static String CompanyProfile_StreetAddress2="//input[@id='responsibleParty']";
	    public static String CompanyProfile_StreetAddress3_Noneditable="//input[@id='addressStreet' and @disabled='disabled']";
	    public static String CompanyProfile_StreetAddress4_NonEditable="//input[@id='addressStreet2' and @disabled='disabled']";
	    public static String CompanyProfile_State_NonEditable="//select[@id='addressState' and @disabled='disabled']";
	    public static String CompanyProfile_ZipCode_NonEditable="//input[@id='addressZip' and @disabled='disabled']";
	    public static String CompanyProfile_SubZipcode_NonEditable="//input[@id='addressSubZip' and @disabled='disabled']";
	    public static String CompanyProfile_City_NonEditable="//input[@id='addressCity' and @disabled='disabled']";
	    public static String CompanyProfile_Cross="//span[@ng-if='displayClearable']";
	    
	    /*public static String CompanyProfile_StreetAddress2_editable="//input[@id='responsibleParty']";*/
	    public static String CompanyProfile_StreetAddress3_editable="//input[@id='addressStreet']";
	    public static String CompanyProfile_StreetAddress4_Editable="//input[@id='addressStreet2']";
	    public static String CompanyProfile_State_Editable="//select[@id='addressState']";
	    public static String CompanyProfile_ZipCode_Editable="//input[@id='addressZip']";
	    public static String CompanyProfile_SubZipcode_Editable="//input[@id='addressSubZip']";
	    public static String CompanyProfile_City_Editable="//input[@id='addressCity']";
	    
	    //Priyanka[28-10-2015]//
	    public static String CompanyProfile_Phone1="//input[@name='phoneAreaCode']";
	    public static String CompanyProfile_Phone2="//input[@name='phonePrefix']";
	    public static String CompanyProfile_Phone3="//input[@name='phonePostfix']";
	    public static String CompanyProfile_email="//input[@id='email']";
	    public static String SS_NewSecuritycode="//input[@id='pin']";
	    public static String SS_Pinconfirmation="//input[@id='pinConfirmation']";
	    public static String SS_showCode="//button[@ng-click='toggleSecurityCodeVisibility()' and @aria-expanded='false']/span";
	    public static String SS_HideCode="//button[@ng-click='toggleSecurityCodeVisibility()' and @aria-expanded='true']/span";
	    public static String SS_CodeValue="//span[@id='reveal-security-code']";
	    public static String SS_InvalidSecurityCode="//div[@id='pin_error']"; 
	    
	    
	    //Saranya[10/29/2015]
	    
	    public static  String Confirmationpopup_Block="//div[@ ng-click='$event.stopPropagation()']";
	    public static  String Block_Error="//div[contains(@class,'sb-block-message--error')]//div[@class='sb-block-message__message']/div[2]/p";
		public static String Calllog_Blockcancel="//div[@ng-if='modalOptions.showFooter']/a[.='CANCEL']";//a[@ng-click='secondaryButtonFunction ? secondaryButtonFunction($event) : $dismiss()']";
		public static String Calllog_logList="//div[contains(@ng-class,'call.type')]";//div[@class='text--style-r16-3 no-wrap ng-binding']";
		public static String Voice_VoiceBreadCrumb_VoiceIcon="//ul[contains(@class,'nav-left-list')]";//ul[@class='nav-left-list sb-options-toolbar-nav--left']";
		public static String Voice_VoiceLineDropdown="//button[@ ng-if='model.phoneNumbers.length > 1']";
		public static String Voice_VoiceSetingsButton="//div[@is-open='voiceSettingsMenu.nonMobile']/button";//button[ @class='settings-button sb-btn sb-btn--alternate sb-btn--icon dropdown-toggle']";
        public static String Voice_Phone_Icon="//i[@ng-class='serviceIconClass']";
        public static String Voice_LineList="//a[@ng-click='selectPhoneNumber(line)']/div[1]";
		public static String Voice_VoiceOverview="//a[contains(@href,'overview')]/i";//i[@class='icon icon--small-med icon--med-blue sb_ic_3x3_grid_f']";
		public static String Deletelink="//div[@ aria-expanded='true']//a[.='Delete']";//div[@collapse='message.collapse']/div/span[@ng-if='!deleted']";
		
		//Priyanka[29-10-2015]
		
		  
	    public static String MyProfile_FirstName="//input[@id='profileFirstName']";
	    public static String MyProfile_LastName="//input[@id='profileLastName']";
	    public static String MyProfile_PhoneNumber="//input[@name='phoneNumber']";
	    public static String MyProfile_Email="//input[@name='email']";
	    public static String MyProfile_SaveSuccess="//div[@aria-live='assertive']";
	    public static String MyProfile_fnnameerror="//div[@ng-if='debouncedErrors.firstName && myProfileForm.firstName.$dirty']";
	    public static String MyProfile_lnameerror="//div[@ng-if='debouncedErrors.lastName && myProfileForm.lastName.$dirty']";
	    public static String MyProfile_emailerror="//div[@ng-if='debouncedErrors.email && myProfileForm.email.$dirty && !validEmail']";
	    public static String MyProfile_SecuritySettings="//div[@class='sidenav-main-links']/div[2]/div[.='Security Settings']";
	    public static String MyProfile_SS_Password="//input[@id='password']";
	    public static String MyProfile_SS_ConfirmPassword="//input[@id='passwordConfirmation']";
	    public static String MyProfile_SS_SecurityQuestion = "//select[@id='question']";
	    public static String MyProfile_SS_SecurityAnswer = "//input[@id='answer']";
	    public static String MyProfile_SS_SecuritySaveButton = "(//button[@type='submit'])[2]";
	    public static String MyProfile_SS_SecurityAnswerX = "//span[@ng-mousedown='clearInput($event)']";
	    public static String MyProfile_SS_SecuritySuccessMessage = "//p[@ng-if='!options.useHtml']";
	    public static String Passwordstrength_Fair="//div[@class='password-bar fair-password fairEmpty']";
	    public static String Passwordstrength_Fairenabled="//div[@class='password-bar fair-password fairFull']";
	    public static String Passwordstrength_Moderate="//div[@class='password-bar moderate-password moderateEmpty']";
	    public static String Passwordstrength_Moderateenabled="//div[@class='password-bar moderate-password moderateFull']";
	    public static String Passwordstrength_strong="//div[@class='password-bar strong-password strongEmpty']";
	    public static String Passwordstrength_strongenabled="//div[@class='password-bar strong-password strongFull']";
	    public static String Helpicon="//div[@class='sb-company-security-tooltip-column']//i";
	    public static String Passwordchecklist="//div[@sb-password-checklist='sb-password-checklist']";
	    public static String Lengthchecktext="//div[@sb-password-checklist='sb-password-checklist']/ul/li[3]";
	    public static String Uppercasechecktext="//div[@sb-password-checklist='sb-password-checklist']/ul/li[6]";
	    public static String Lowercasechecktext="//div[@sb-password-checklist='sb-password-checklist']/ul/li[9]";
	    public static String Numberchecktext="//div[@sb-password-checklist='sb-password-checklist']/ul/li[12]";
	    public static String CorrectLength="//div[@sb-password-checklist='sb-password-checklist']/ul/li[1]";
	    public static String CorrectUppercase="//div[@sb-password-checklist='sb-password-checklist']/ul/li[4]";
	    public static String CorrectLowercase="//div[@sb-password-checklist='sb-password-checklist']/ul/li[7]";
	    public static String CorrectNumber="//div[@sb-password-checklist='sb-password-checklist']/ul/li[10]";
	    public static String InCorrectLength="//div[@sb-password-checklist='sb-password-checklist']/ul/li[2]";
	    public static String InCorrectUppercase="//div[@sb-password-checklist='sb-password-checklist']/ul/li[5]";
	    public static String InCorrectLowercase="//div[@sb-password-checklist='sb-password-checklist']/ul/li[8]";
	    public static String InCorrectNumber="//div[@sb-password-checklist='sb-password-checklist']/ul/li[11]";
	    public static String CommonPhrase="//div[@sb-password-checklist='sb-password-checklist']/ul/li[15]";
	    public static String PasswordsameUserid="//div[@sb-password-checklist='sb-password-checklist']/ul/li[14]";
	    public static String SymbolsError="//div[@sb-password-checklist='sb-password-checklist']/ul/li[13]";
	  
//saranya[10/30/2015]
	    
		public static String Voice_CallLogs = "//div[@ng-hide='loading.numbers']//div[@href='#/voice/call-logs/']";//div[@class='sb-nav-menu__nav-row']/div[@ui-sref='voice.callLogs']";
		public static String Voice_CallLogsNavSelected = "//div[@ng-class='selectedClass(call.callId)']";//div[@class='sb-nav-menu__nav-row active disabled']";
		public static String Voice_CallLogsList = "//div[@ng-switch='call.type']";//div[@class='col-xs-1 type-icon-cell']/div/div";
		public static String Voice_CallLogs_MoreDetailsLink = "//div[@ ng-class='selectedClass(call.callId)']/div[4]//i";//div[@class ='details-link pull-right']";
		public static String Voice_FilterOptions = "//ul[@id='dropdownXsFilterDropdownMenu']/a/span";//a[@class='dropdown3__item' or @class= 'dropdown3__item active selected']/span";
		public static String Voice_CallLogFilter = "//div[@filter='model.typeFilter']//a[@id='dropdownXsFilterDropdown']";//div[@class='btn-group dropdown' or @class='btn-group dropdown open']";
		public static String Voice_LogsFilterDropdownExpanded = "//a[@ng-click='updateFilter(all)' or @ng-click='updateFilter(missed)' ]";
		public static String Voice_FilterAll="//a[@ng-click='updateFilter(all)']";
		public static String voice_CallListtype="//div[@ng-switch='call.type']";
		public static String Voice_FilterMissed="//a[@ng-click='updateFilter(missed)']";
		public static String Voice_CallLogFilterDisabled = "//a[@id='dropdownXsFilterDropdown' and @ ng-disabled='disabled']";//div[@class='btn-group dropdown' or @class='btn-group dropdown open']";
        public static String AddContact_Window="//form[@name='addContactForm']";

		 //Priyanka[30-10-2015]//
	    
	    public static String ResetPassword="//input[@id='resetPasswordOption']";
	    public static String RecoverUserName="//input[@id='recoverCharterIdOption']";
	    public static String AccNumber="//input[@id='accountNumber']";
	    public static String ForgotUsername_SecurityCode="//input[@id='securityCode']";
	    public static String forgotUsername_Next="//div[@class='button-row sm-top sm-btm']/button[.='Next']";
	    public static String Alert="//div[@ng-class='blockClass']";
	    public static String forgotPwd_Cancel="//div[@class='button-row sm-top sm-btm']/button[.='Cancel']";
	    public static String AnswerSecurityQuestionpage="//div[@ui-view='main']//h1";
	    public static String SecurityAnswer="//input[@id='securityAnswer']";
	    public static String SecurityAns_Cancel="//div[@class='row simple-layout-template']//button[.='Cancel']";
	    public static String SecurityAns_Next="//div[@class='row simple-layout-template']//button[.='Next']";
	    
	    
	    //Saranya[10/31/2015]
	    
	    public static String ManageUserList="//div[@ ng-class='selectedClass(user.number)']";
		public static String Overview_VideoTab="//div[@ng-if='has.VIDEO']/a";//div[@ng-if='has.video']/a[@href='./tv.html']";
        
		public static String AddNewUserLink="//button[@ ng-click='addNewUser()' and @type='button']";
		public static String ProfileInfoLabel="//div[@class='sb-section-header']";
		public static String AddNewUser_FirstName="//input[@id='profileFirstName']";
		public static String AddNewUser_LastName="//input[@id='profileLastName']";
		public static String AddNewUser_Emailaddres="//input[@ placeholder='Email Address']";
		public static String AddNewUser_PhoneNO="//input[@ placeholder='Phone Number']";
		public static String AddNewUser_Nextbutton="//button[@type='submit']";
		public static String AddNewUser_StandardRadiobtn="//input[@id='standardPermissionOption']";//div[@class='radio-btn radio-btn-row-cell radio-btn-cell']/i
				//"//input[@id='basicPermissionOption']";
		public static String AddNewUser_AddVoiceLine="//button[@ng-click='addNewLineRow($event)']";
		public static String AddNewUser_PhoneIcon="//i[contains(@class,'phone_large')]";
		public static String AddNewUser_closebtn="//button[@ng-click='unassignLine(line, $event)']";
		public static String AddNewUser_Phonedropdown="//button[@aria-haspopup='true' and @type='button']";
		public static String AddNewUser_AdminLine="//div[@ng-if='uline.isAdmin']/i";
		public static String AddNewUser_Confirmbtn="//button[@ type='submit' and .='CONFIRM']";
		public static String AddNewUser_Cancelbtn="//div[@ ng-if='modalOptions.showFooter']/a";
		public static String AddNewUser_Closedbtn="//a[@ ng-click='$dismiss()']";
		public static String AddNewUser_Sucessmessage="//p[contains(.,'Successfully added')]";
		
		  //Priyanka[2-11-2015]//
	    
	    public static String MyProf_SS_Save="//button[@data-sbnet='profile-cancel-button']";
	    public static String SecuritySettings_Save="//button[@type='submit']";
	    public static String SecuritySettings_SuccessSaveMessage="//div[@class='sb-block-message__message']/div[2]/p";
	    
	    //Priyanka[3-11-2015]//
	    
	    public static String PayBillLink="// div[@class='sidenav-main-links ng-scope']//div[@ui-sref='billing.payBill']";
	    public static String PayBill_CardNum="//div[@class='cc-no-box']//input[@name='cardNumber']";
	    public static String PayBill_ExpiryDate="//input[@ng-model='model.expirationDate']";
	    public static String Paybill_Amount="//input[@id='paymentAmount']";
	    public static String PayBill_PaymentDate="//input[@id='paymentDate']";
	    public static String PayBill_PayNow="//div[@class='pull-right ng-scope']//button[.='Pay Now']";
	    public static String PayBillpage="//div[@ng-if='!isLoading.currentBill']//div[.='Pay Bill Options']";
	    public static String PayBill_VerifyPaymentPage="//div[.='Verify Payment Information']";
	    
	    //Priyanka[5-11-2015]//
	    
	    public static String Paybill_EditPamentInfo="//div[@class='row sb-edit-payment-details-link-row']//a";
	    public static String VerifyPay_Card="//div[@class='col-xs-12 col-sm-6 ng-scope']/div[1]/div[2]//span";
	    public static String VerifyPay_ExpDate="//div[@class='col-xs-12 col-sm-6 ng-scope']/div[2]/div[2]/span";
	    public static String VerifyPay_Amount="//div[@class='col-xs-12 col-sm-6']/div[1]/div[2]/span";
	    public static String VerifyPay_PayDate="//div[@class='col-xs-12 col-sm-6']/div[2]/div[2]/span";
	    public static String VerifyPay_Support="//div[@class='sb-pay-bill-content-container']//div[4]//div//a[.='Support']";
	    public static String VerifyPay_Cancel="//div[@class='row sb-verify-button-row']/div[2]/a[.='Cancel']";
	    public static String VerifyPay_confirm="//div[@class='row sb-verify-button-row']/div[2]/button[.='Complete Payment']";
	    public static String PayBill_support="//a[@ng-click='navigate(URL.CMS_SUPPORT)']";
	    
	    //Priyanka[9-11-2015]//
	    
	    public static String MyAccount_Billing=/*"//div[@class='sb-container__content']/div[4]/div/a[.='Billing']"*/ "//div[@class='row sb-overview__tile-section']//div[1]//a[.='Billing']";
	   /* public static String Billing_Link="//div[@activity='BILLING_ADMINISTRATION']/a[@href='/smb/billing.html#/billing/view-statements']";*/
	    
	    //Priya[31/10/2015]
	    public static String v1_overview ="//h5[contains(.,'Overview')]";
	    public static String V1_Support = "//a[contains(@href,'support')]//div[.='Support']";
	    public static String SharedLogout = "//*[@ng-if='userLoggedOut']";
	    public static String V1_Support_link ="//h1[contains(.,'Search Support')]";
	    
	    //saranya[11/3/2015]
	    public static String Confirmationpopup="//div[@ng-click='$event.stopPropagation()']";
	    
	    

	    //saranya[11/4/2015]
	    
	    public static String ArrowLink="//div[@ng-click='openDetails($event, contact)']/div/i";
		public static String ContactInformationLabel= "//form[@name='addContactForm']/div[contains(.,'Contact Information')]";
		public static String ContactInformationWindow= "//div[@name='contactName']";
		public static String NameLabel="//form[@name='addContactForm']/div[contains(.,'Name')][1]";
		public static String FirstNameLabel="//div[@ name='contactName']//label[contains(.,'First Name')]";
		public static String LastNameLabel="//div[@ name='contactName']//label[contains(.,'Last Name')]";
		public static String TitleLabel="//div[@ name='contactName']//label[contains(.,'Title')]";
		public static String CompanyLabel="//div[@ name='contactName']//label[contains(.,'Company')]";
		public static String PhoneLabel="//div[@ng-form='contactPhoneNumberForm']/div[contains(.,'Phone')][1]";
		public static String EmailLabel="//form[@name='addContactForm']//div[contains(.,'Email')][1]";
		public static String AddressLabel="//form[@name='addContactForm']//div[contains(.,'Address')][1]";
		
		 //Priyanka[17-11-2015]//
	    
	    public static String PayBill_DatePicker="//button[@ng-click='showDatepicker($event)']";
	    public static String PayBill_DatePickerExpanded="//div[@ng-switch='datepickerMode']";
	    public static String PayBill_DatePicker_SelectDate="//div[@ng-switch='datepickerMode']//tbody";
	    public static String PayBill_completePaymentbutton="//button[@type='submit' and contains(text(),'PAYMENT')]";
	    public static String Paybill_CompleteTitle="//div[@class='header-cell']//div[.='Payment Complete']";
	    public static String PayBill_success1="//div[@class='sb-pay-bill-content-container']/p[1]";
	    public static String PayBill_success2="//div[@class='sb-pay-bill-content-container']/p[2]";
	    public static String PayBill_complete_returnverview="//button[contains(.,'RETURN TO OVERVIEW')]";
	    
	  //Priyanka[Iteration-3]
	  		//[18-11-2015]
	  		
	  		public static String NewUser_Step3_SkipVoice="//div[@class='sb-create-member-skip-link']//a[@ng-click='skipVoiceOptions()']";
	  		public static String NewUser_step3_text="//div[@class='sb-create-member-section-header' and .='Assign Voice Services']";
	  		public static String NewUser_Step3_ToolTip="//div[@class='sb-create-member-form-content']//div[.='Voice Service']";
	  		public static String NewUser_Step3_Cancel="//a[@ng-click='cancel()']";
				//"//div[@class='sb-create-member-btn-group-right']//a[.='Cancel']";
	  		public static String NewUser_step3_Back="//div[@class='sb-create-member-btn-group-left']//a";
	  		public static String NewUser_Step4Navigated="//div[@class='sb-create-member-section-header' and .='Confirm Add New User']";
	  		
	  	//Priyanka[Iteration-3]
			//19-11-2015
			
			public static String NewUser_Step2_Confirmationpopup="//div[@ng-click='$event.stopPropagation()']";
			public static String NewUser_step2_Confirm="//div[@ ng-if='modalOptions.showFooter']/button";
			public static String ManageUsers_Confirmpopup_Cancel="//div[@ng-if='modalOptions.showFooter']//a[.='CANCEL']";
			public static String ManageUsers_ConfirmPopup_confirm="//div[@ng-if='modalOptions.showFooter']//button[.='CONFIRM']";
      
  
          //GURLEEN 17Nov
            public static String ManageUsers_CancelEditPopup = "//div[@ng-if='modalOptions.showFooter']/a"; 
            public static String ManageUsers_CancelConfirm = "//div[@ng-if='modalOptions.showFooter']/button"; 
            
            //GURLEEN VOICEMAIL GREETINGS
    	    public static String VoiceSettingsMenu_VMGreetings = "//div[@ng-transclude='ng-transclude']/div[5]//div[@ng-controller='voiceSettingsCtrl']//li[contains(.,'Set Voicemail Greeting')]/div/div[2]";
    	    public static String VoiceSettingsMenu_VMGreetings_GreetingsList = "//select[@ng-model='currentModel.selectedGreetingType']";
    	    public static String VoiceSettingsMenu_VMGreetings_GreetingsList1 = "//select[@ng-model='currentModel.selectedGreetingType']/option";
    	    public static String VoiceSettingsMenu_VMGreetings_title = "//div[@class='sb-menu__label']";
    	    public static String VoiceSettingsMenu_VMGreetings_play = "//button[@ng-click='togglePlaying()']";
    	    public static String VoiceSettingsMenu_VMGreetings_close = "//a[@ng-click='confirmCancel()']/span";
    	    public static String VoiceSettingsMenu_VMGreetings_save = "//button[@ng-click='saveRecordedGreeting()']";
    	    
    	  //GURLEEN[27-11-2015]
    		//TotalAmount TC 94 ITR3 Sprint 27
    		public static String TotalAmount = "//div[@ng-if='!errors.billingStatus']";
    		public static String TotalAmountValue = "//div[@class='pull-right ng-binding']";
            
    		//Gurleen[27-11-2015]
    		//Tooltip View Statement
    		public static String Tooltip = "//div[@class='hidden-xs hidden-sm col-md-1']/a[@ng-if='charge.summaryDisplay']/i";
    		public static String Description = "//div[@class='hidden-xs hidden-sm col-md-1']/a[@ng-if='charge.summaryDisplay']/i/ancestor::div[@class='sb-content-row single-content-header-row sb-billing-row sb-statement-row-content']/div[2]";
    		public static String Title = "//h2[@id='modalTitle']";
    		public static String XButton = "//a[@ng-click='$dismiss()']";
    		public static String OkButton = "//button[@ng-if='modalOptions.buttonText && modalOptions.buttonOmniture']";
    		
    		//Manage User Reset Password
    		public static String ManageUsers_ResetPassword = "//div[@class='sb-edit__row']/button[.='sb-btn sb-btn--primary send-pw-reset']";
    		//public static String ManageUsers_ResetPasswordPopup_Text = "//html/body/div[3]/div/div/div/div[2]/p";
    		public static String ManageUsers_ResetPasswordPopup_Text = "//p[@id='tooltipDescription']";
    		public static String ManageUsers_ResetPassword_Text="//p[@ng-if='!options.useHtml']";
    		//public static String ManageUsers_ResetPasswordPopup_Title = "//html/body/div[3]/div/div/div/div[1]/h2";
    		public static String ManageUsers_ResetPasswordPopup_Title = "//h2[@id='tooltipTitle']";
    		//public static String ManageUsers_ResetPasswordPopup_Close = "//html/body/div[3]/div/div/div/div[3]/button";
    		public static String ManageUsers_ResetPasswordPopup_Close = "//button[@class='sb-btn sb-btn--primary pull-right ng-binding ng-scope']";
    		//public static String ManageUsers_ResetPasswordPopup_X = "//html/body/div[3]/div/div/div/div[1]/button";
    		public static String ManageUsers_ResetPasswordPopup_X = "//a[@class='icon sb_ic_x close-modal-icon']";
    		//GURLEEN 19-NOV-2015
    		public static String ManageUsers_DeleteUserPopup_Title = "//div[@ng-if='modalOptions.showHeader']/h2";
    		public static String ManageUsers_DeleteUserPopup_Text = "//p[@id='modalDescription']";
    		public static String ManageUsers_DeleteUserPopup_Cancel = "//div[@ng-if='modalOptions.showFooter']/a";
    		public static String ManageUsers_DeleteUserPopup_Confirm = "//div[@ng-if='modalOptions.showFooter']/button";
    		public static String ManageUsers_DeleteUserPopup_X = "//div[@ng-if='modalOptions.showHeader']/a";
    		public static String ManageUsers_DeleteUserMessage = "//div[@class='sb-block-message__message']/div[2]/p"; 
    		
    	// GURLEEN
    		// CHECK WHETHER THE USER IS NAVIGATED BACK TO MANAGE USERS PAGE
    		public static String ManageUsersLabel="//div[@class='sb-options-toolbar-nav']/ul/li[2]";
    		
    	//Manage User Edit Cancel
    	    public static String ManageUsers_User = "//div[@services='user.services']/span";
    	    public static String ManageUsers_EditUser = "//a[@ng-click='detailOptions.editFunction()']";
    	    public static String ManageUsers_CancelEdit = "//a[@ng-click='actionSheetOptions.cancelFunction()']";
    	    public static String ManageUsers_lastName = "//input[@id='contact-last-name']";
    		public static String ManageUsers_back = "//html/body/div/main/div/div/div[1]/div/div[1]/a[1]";
    		
    		//Priyanka[12-7-2015]
    		
    		public static String Voice_NoNotifications="//div[@class='ng-scope']/p";
    		
//Priyanka[12-8-2015]
    		
    		public static String ManageUsers_close="//div[@id='sbDetailContent']/div[1]/a[@ng-click='actionSheetOptions.cancelFunction()']";

    		

  		  //Jhansi[Iteration-3]
			//25-11-2015
			//View Statements > Charge Details
			public static String Ovw_ViewStatement="//a[@href='/smb/billing.html#/billing/view-statements' and .='View Statements']";
			public static String ViewStatement_ChargeDetailsSection="//div[@ng-if=' !(loading.statements || loading.billingStatus || loading.chargeDetails) && !(errors.statements || errors.chargeDetails || errors.actionBarError)']";
			public static String ViewStatement_ChargeDetailsHdr="//div[@class='sb-subpage__list-container billing-list ng-scope']/div[.='Charge Details']";
          //public static String ViewStatement_Screen="//li[@ng-if='!isESM' and .='View Statements']";//ul[@class='nav-left-list sb-options-toolbar-nav--left']/li[.='View Statements']";
			public static String ViewStatement_Screen="//div[@class='sb-subpage__list-container billing-list ng-scope']/div[1]";
			//Sub sections
			public static String ChargeDetails_SpecInet="//div[@ng-if='model.chargeDetails.internetCharges.length > 0']/div[.='Spectrum Internet']";
			public static String ChargeDetails_SpecTV="//div[@ng-if='model.chargeDetails.tvCharges.length > 0']/div[.='Spectrum TV']";
			public static String ChargeDetails_SpecPhone="//div[@ng-if='model.chargeDetails.phoneCharges.length > 0 || model.chargeDetails.phoneNumberCharges.length > 0']/div[.='Spectrum Phone']";
			public static String ChargeDetails_Taxes_Fees="//div[@ng-if='model.chargeDetails.taxCharges.length > 0']//div[contains(text(),'Taxes, Fees & Charges')]";
		//	public static String ChargeDetails_TaxesCharges="//div[@ng-if='model.chargeDetails.taxCharges.length > 0']";
       //   public static String ChargeDetails_Total="//div[.='Total']";

	//Jhansi[Iteration-3]
			//Nov 26,2015
			//View Statements > Charge Details> sub sections> Details
			public static String SpectrumInet_Date="//div[@ng-if='model.chargeDetails.internetCharges.length > 0']/div[2]/div[.='Date']";
			public static String SpectrumInet_Description="//div[@ng-if='model.chargeDetails.internetCharges.length > 0']/div[2]/div[.='Description']";
			public static String SpectrumInet_Amount="//div[@ng-if='model.chargeDetails.internetCharges.length > 0']/div[2]/div[.='Amount']";
          public static String SpectrumInet_DateVal="//div[@ng-repeat='charge in model.chargeDetails.internetCharges']/div/div[1]";
          public static String SpectrumInet_DescripVal="//div[@ng-repeat='charge in model.chargeDetails.internetCharges']/div/div[2]";
         // public static String SpectrumInet_Alert="//div[@ng-repeat='charge in model.chargeDetails.internetCharges']/div/div[3]";
          public static String SpectrumInet_Alert="//div[@ng-repeat='charge in model.chargeDetails.internetCharges']/*/div[@class='hidden-xs hidden-sm col-md-1']/a[@class='ng-scope']/i";
          public static String SpectrumInet_AmountVal="//div[@ng-repeat='charge in model.chargeDetails.internetCharges']/div/div[4][contains(.,'$')]";

          public static String SpectrumTV_Date="//div[@ng-if='model.chargeDetails.tvCharges.length > 0']/div/div[.='Date']";
          public static String SpectrumTV_Description="//div[@ng-if='model.chargeDetails.tvCharges.length > 0']/div/div[.='Description']";
          public static String SpectrumTV_Amount="//div[@ng-if='model.chargeDetails.tvCharges.length > 0']/div/div[.='Amount']";
          public static String Spectrum_DateVal="//div[@ng-repeat='charge in model.chargeDetails.tvCharges']/div/div[1]";
          public static String Spectrum_DescripVal="//div[@ng-repeat='charge in model.chargeDetails.tvCharges']/div/div[2]";
          public static String Spectrum_AmountVal="//div[@ng-repeat='charge in model.chargeDetails.tvCharges']/div/div[4][contains(.,'$')]";
     
        //Gurleen 29-Jan-2016
			public static String manageusersSearch="//div[@class='search-bar-input-container']/input";
			
         //Jhansi[Iteration-3]
          //Nov 27,2015
          //View Statements > Charge Details> sub sections >Phone Details
          public static String SpectrumPhone_Date="//div[@ng-if='model.chargeDetails.phoneCharges.length > 0 || model.chargeDetails.phoneNumberCharges.length > 0']/div/div[.='Date']";
			public static String SpectrumPhone_Description="//div[@ng-if='model.chargeDetails.phoneCharges.length > 0 || model.chargeDetails.phoneNumberCharges.length > 0']/div/div[.='Description']";
			public static String SpectrumPhone_Amount="//div[@ng-if='model.chargeDetails.phoneCharges.length > 0 || model.chargeDetails.phoneNumberCharges.length > 0']/div/div[.='Amount']";
          public static String SpectrumPhone_DateVal="//div[@ng-repeat='charge in model.chargeDetails.phoneCharges']/div/div[1]";
          public static String SpectrumPhone_DescripVal="//div[@ng-repeat='charge in model.chargeDetails.phoneCharges']/div/div[2]";
        //  public static String SpectrumPhone_Alert="//div[@ng-repeat='charge in model.chargeDetails.phoneCharges']/div/div[3]";
          public static String SpectrumPhone_Alert="//div[@ng-repeat='charge in model.chargeDetails.phoneCharges']/*/div[@class='hidden-xs hidden-sm col-md-1']/a[@class='ng-scope']/i";
          public static String SpectrumPhone_AmountVal="//div[@ng-repeat='charge in model.chargeDetails.phoneCharges']/div/div[4][contains(.,'$')]";
          public static String SpectrumPhone_PhoneNum="//div[@ng-repeat='phoneNumber in model.chargeDetails.phoneNumberCharges']/div/div[contains(.,'Phone Number')]";
          public static String SpectrumPhone_PhoneNum_Date="//div[@ng-repeat='charge in phoneNumber.charges']/div/div[1]";
          public static String SpectrumPhone_PhoneNum_Description="//div[@ng-repeat='charge in phoneNumber.charges']/div/div[2]";
          //public static String SpectrumPhone_PhoneNum_Alert="//div[@ng-repeat='charge in phoneNumber.charges']/div/div[3]";
          public static String SpectrumPhone_PhoneNum_Alert="//div[@ng-repeat='charge in phoneNumber.charges']/*/div[@class='hidden-xs hidden-sm col-md-1']/a[@class='ng-scope']/i";
          public static String SpectrumPhone_PhoneNum_Amount="//div[@ng-repeat='charge in phoneNumber.charges']/div/div[4]";
         
//Jhansi[Iteration-3]
          //Nov 28,2015
         // ExportCall log
          public static String ViewStatement_ExportCallLog="//button[@ng-click='exportCallLog()']";
          public static String ExportCallLog_PopUp="//div[@ng-click='$event.stopPropagation()']";
          public static String ExportCallLog_Hdr="//h2[@id='modalTitle']";
          public static String ExportCallLog_PopUp_EmailTxtBox="//input[@id='emailInput']";
          public static String ExportCallLog_PopUp_ExportBtn="//button[@ng-if='modalOptions.buttonText && modalOptions.buttonOmniture']";
          public static String ExportCallLog_CallDownloads="//ul[@class='nav-left-list sb-options-toolbar-nav--left']/li[.='Call Log Downloads']";
          public static String ExportCallLog_Error="//div[@ng-class='getBlockClass(options.messageType)']";
          public static String ExportCallLog_PopUp_Close="//a[@ng-click='$dismiss()']";
          public static String ExportCallLog_PopUp_SubTitle="//div[@class='modal-body']//p[1]";
          public static String ExportCallLog_PopUp_Text="//p[@id='phoneExportModalDesc']";
          public static String ExportCallLog_PopUp_EmailLabel="//div[@class='sb-detail__detail-text']/label";
          public static String ExportCallLog_PopUp_Cancel="//a[.='CANCEL']";
          public static String BillingSection_StdUser="//div[@class='sb-billing-panel ng-scope']";
          
          //Jhansi[Iteration-3]
          //Dec-1,7,2015
          //Voice Settings
         // public static String VoiceSettingMenu="//div[@is-open='voiceSettingsMenu.nonMobile']//div[@ng-controller='voiceSettingsCtrl']";
          public static String VoiceSettingMenu="//div[@id='voiceSettingsDropdown']//div[@ng-controller='voiceSettingsCtrl']";
          public static String FwdAllCalls="//div[@is-open='voiceSettingsMenu.nonMobile']//div[@ng-controller='voiceSettingsCtrl']//li[contains(.,'Forward All')]";
          		//"//div[@is-open='voiceSettingsMenu.nonMobile']//div[@ng-controller='voiceSettingsCtrl']//ul/li[contains(.,'Forward All')]";
          public static String FwdAllCallsMenu="//div[@ng-switch-when='forward-all-calls']";
          public static String FwdAllCallsMenu_Close="//a[@ng-click='confirmCancel(true)']";
          public static String FwdAllCallsMenu_Save="//form[@name='form.callForwarding']//button[.='SAVE']";
          public static String FwdAllCallsMenu_CallFwding="//div[@class='sb-menu__row call-forwarding-toggle-row']/p[contains(.,'Call Forwarding')]";
          public static String FwdAllCallsMenu_CallFwding_ToggleBtn="//div[@class='sb-menu__row call-forwarding-toggle-row']//button[@ng-click='toggleState()']";
          public static String FwdAllCallsMenu_FwdMethod="//div[@ng-if='model.forwardingEnabled']/div[contains(.,'Forwarding method')]";
          public static String FwdAllCallsMenu_FwdMethod_ToggleBtn="//div[@ng-if='model.forwardingEnabled']//button[@ng-click='toggleState()']";
          public static String FwdAllCallsMenu_FwdAllCallsTo="//div[@ng-if='model.forwardingEnabled']//div[contains(.,'Forward all calls to')]";
          public static String FwdAllCallsMenu_FwdAllCallsTo_Dropdown="//div[@ng-if='model.forwardingEnabled']//div[@ng-click='showDropdown()']";
          public static String FwdAllCallsMenu_ManageFwdingLines="//button[@ng-click='manageForwardingLines()']";
          public static String FwdAllCallsDropdown_List="//ul[@ng-if='showSelectableLines']/li";
         
//Jhansi[Dec 7,2015]
  		//Manange forwarding lines
  		public static String ManageFwdLines_Popup="//div[@class='manage-forwarding-lines ng-scope']";
  		public static String ManageFwdLines_hdr="//h2[@id='modalTitle']";
  		public static String ManageFwdLines_RedX="//button[@ng-click='deleteLine($index);']";
  		public static String ManageFwdLines_AddLineBtn="//button[@ng-click='addLine()']";
  		public static String ManageFwdLines_AddNumTxt="//div[@class='modal-body']/div/div[2]/span";
  		public static String ManageFwdLines_CancelBtn="//a[@ng-click='secondaryButtonFunction($event)']";
  		public static String ManageFwdLines_SaveBtn="//button[@ng-click='primaryButtonFunction($event)']";
          public static String ManageFwdLines_Close="//a[@ng-click='$dismiss()']";
          public static String ManageFwdLines_NumberList="//input[@ng-model='line.number']";
          public static String ManageFwdLines_AliasList="//input[@ng-model='line.alias']";
          public static String ManageFwdLines_Alias="//div[@class='modal-body']/div[1]/div[1]/span[1]";
          public static String ManageFwdLines_Number="//div[@class='modal-body']/div[1]/div[1]/span[2]";

          //Jhansi[Dec 8,2015]
          //forwarding manager
          public static String Voice_FwdingMgr="//div[@aria-labelledby='sideNavDropdown']//div[@ui-sref='voice.forwarding']";
          public static String Voice_FwdingMgr_Hdr="//li[@ng-if='!isESM' and .='Forwarding Manager']";
          public static String Voice_FwdingMgr_DataLoad="//div[@class='sb-subpage--list-container']";
          //Dec 9,2015
          public static String FwdingMgr_InternalLines="//div[@ng-show='internalLines.length > 0']";
          public static String FwdingMgr_InternalLines_Column="//div[@ng-if='model.lines && model.lines.length > 0 && internalLines.length > 0']/div";
  		public static String FwdingMgr_InternalLines_Val="//div[@ng-repeat='line in internalLines = (model.lines | filter:isInternal)']/div[2]";
  		public static String FwdingMgr_ExternalLines="//div[@ng-show='externalLines.length > 0']";
  		public static String FwdingMgr_ExternalLines_Val="//div[@ng-repeat='line in externalLines = (model.lines | filter:isExternal)']/div[2]";
  		public static String FwdingMgr_ExternalLines_Status="//div[@ng-repeat='line in externalLines = (model.lines | filter:isExternal)']/div[1]";

          
        //Priyanka[12-9-2015]
  		
  		public static String CompanyProfile_CompanyName="//div[@class='acct-info']/div[1]";
  		public static String CompanyProfile_UserName="//div[@class='acct-info']/span[2]";
  		public static String CompanyProfile_AccNo="//div[@class='acct-info']/span[4]";
  		public static String CompanyProfile_ServiceAddress="//div[@sb-address='model.accountInfo.service']";
  		public static String CompanyProfile_Logo="//div[@class='logo']";
  		public static String CompanyProfile_LogoChangeLink="//a[@ ng-click='updateLogo($event)']";//div[@class='logo-change-link']";
  		public static String CompanyProfile_BillingAddress="//form[@name='form.changeAddressForm']";
	
  		public static String CP_SS_Heading="//div[@class='sb-subpage__content company-container']//h1";
		public static String CP_SS_NewPinLabel="//div[@for='pin']";
		public static String CP_SS_NewPinLabelRegd="//div[@for='pin']//span[@class='required']";
		public static String CP_SS_Tooltip="//a[@ng-click='openToolTip()']";
		public static String CP_SS_RetypePinLabel="//div[@for='pinConfirmation']";
		public static String CP_SS_RetypePinLabelReqd="//div[@for='pinConfirmation']//span[@class='required']";
		//Saranya[12/9/2015]
		public static String DirectoryListingLabel_UnListing="//div[@ng-show='model.line.directoryListing' and contains(@class,'ng-hide') ]";
		//Jhansi[Dec 9,2015]
		//Ovw applns_Notification panel
		public static String OvwApp_NotificationPanel="//div[@class[contains(.,'notification-panel')]]";
        public static String OvwApp_NotificationHdr="//div[@class='sb-section-header title']";
        public static String OvwApp_NotificationPanel_NoMsg="//div[@class[contains(.,'notification-panel')]]//p";
        
      //Priyanka[12-10-2015]
		
      		public static String MyProfile_SS_Heading="//div[@ui-view='content']//h1[1]";
      		public static String MyProfile_SS_NewPasswordLabel="//div[@for='password']";
      		public static String MyProfile_SS_NewPasswordasterisk="//div[@for='password']//span[@class='required']";
      		public static String MyProfile_SS_ConfirmPasswordLabel="//div[@for='passwordConfirmation']";
      		public static String MyProfile_SS_confirmPasswordasterisk="//div[@for='passwordConfirmation']//span[@class='required']";
         //Saranya[12/10/2015]
    		
    		public static String StatementDropdown="//button[@ng-if='model.statementList.length > 1']";
  		  //Saranya[12/11/2015]
  		    public static String Q2Wall_AccountPastDueLabel="//h1[.='Account Past Due']";
		    public static String Q2Wall_PayNowbtn="//a[contains(text(),'PAY NOW')]";
		    public static String Q2Wall_PaybillLabel="//h5[contains(.,'Pay Bill')]";
		    public static String Q2wall_RoutingNumber="//input[@id='routingNumber']";
		    public static String Q2wall_BankAccountNumber="//input[@id='accountNumber']";
		    public static String Q2wall_Cancelbutton="//button[@ ng-click='cancelPayment()']";
		    public static String Q2wall_BankAccountNumberError="//div[@id='bankAccountError']";
		    public static String Q2Wall_PaymentAmount="//input[@id='paymentAmount']"; 
		    public static String Q2Wall_paymentAmountError="//div[@id='paymentAmountError']";
		    public static String Q2Wall_paymentDate="//input[@id='paymentDate']";
		    public static String Q2Wall_CheckImg="//img[@title='Check']";
		    
		  //Priyanka[12-11-2015]
			
			public static String PayBill_AmountError="//div[@id='paymentAmountError']/div";
			public static String PayBill_Cancel="//div[@class='row button-row']//div[2]/button[1]";
			public static String PayBill_Save="//div[@class='row button-row']//div[2]/button[2]";
			public static String PayBill_AccError="//div[@id='creditCardNumberError']/div";
			public static String PayBill_ExpDateError="//div[@id='expirationDateError']/div";
			public static String PayBill_ExpMonth="//select[@id='expirationMonth']";
			public static String PayBill_ExpYear="//select[@id='expirationYear']";
			
			
			

	  		//Jhansi[Dec 10,2015]
	            //Pay bill
	            public static String PayBill_OTP_RadioBtn="//div[@class='radio']/label[@for='oneTime']/div[1]/div";
	            public static String PayBill_CheckingsSavings_RadioBtn="//div[@class='radio']/label[@for='checkingSavingsAccount']/div[1]/div";
	            public static String PayBill_CheckingsSavings_RadioBtn_Selection="//input[@id='checkingSavingsAccount' and @type='radio']";
	            public static String PayBill_PaymentInfo="//div[@ng-switch='model.paymentMethod']";
	            public static String PayBill_PaymentInfo_Hdr="(//div[@ng-switch='model.paymentMethod']//form//h4)[1]";
	            public static String PaymentInfo_CheckingRadioBtn_Selection="//input[@id='checkingAccount' and @type='radio']";
	            public static String PaymentInfo_CheckingRadioBtn="//form[@name='forms.paymentInfoEFTForm']/div[1]/div[1]/div/fieldset[1]/div/div[1]/label[@for='checkingAccount']/div[1]/div";
	            public static String PaymentInfo_CheckingLabel="//label[@for='checkingAccount']";
	            public static String PaymentInfo_RoutingNum="//input[@name='routingNumber']";
	            public static String PaymentInfo_AccNum="//input[@id='accountNumber']";
	            public static String PaymentInfo_Amt="//input[@id='paymentAmount']";
	            public static String PaymentInfo_Date="//input[@id='paymentDate']";
	            public static String PaymentInfo_PayNowBtn="//button[@type='submit' and contains(text(),'PAY')]";
	            public static String PaymentInfo_VerifyPaymentInfo="//div[@class='sb-floating-panel ng-scope']";
	            public static String PaymentInfo_VerifyPaymentInfo_Hdr="//div[@class='sb-floating-panel ng-scope']/div[1]";
	            public static String VerifyPaymentInfo_Hdr="//form[@name='forms.verifyPaymentForm']/h3";
	            public static String VerifyPaymentInfo_RoutingNum="//label[.='Routing Number:']";
	            public static String VerifyPaymentInfo_AllDetails="//div[@class='row sb-pci-verify-form-row']/div";
	            public static String VerifyPaymentInfo_EditPayLink="//a[@ui-sref='payBill.options']";
	            public static String VerifyPaymentInfo_SupportLink="//a[@ng-click='navigate(URL.CMS_SUPPORT)']";
	            public static String VerifyPaymentInfo_CancelBtn="//a[@ng-click='cancelPayment()']";
	            public static String VerifyPaymentInfo_CompletePaymentBtn="//button[@ng-disabled='forms.paymentInfoForm.$invalid || submitting']";
	            public static String payementIssue="//*[@ng-if='!options.useHtml' and contains(.,'We are unable to process your payment at this time. Please verify the payment information entered is accurate. If you continue to experience issues, please contact customer care at 800.314.7195')]";
	            //Jhansi[Dec 11,2015]
	            //Q2-wall of garden-pay bill\
	            public static String Q2Wall_PayBillScreen="//div[@ng-show='!isLoading.currentBill']";
	            public static String Q2Wall_PayBill_AccNumTitle="//div[@class='acct-num-display']/span[1]";
	            public static String Q2Wall_PayBill_AccNum="//div[@class='acct-num-display']/span[2]";
	            public static String Q2Wall_PayBill_CurrentBillAmt="//div[@data-cbnet='current-bill-amount-due']";
	            public static String Q2Wall_PayBill_StatementTitle="//div[@ng-if='currentStatementDate']/span[1]";
	            public static String Q2Wall_PayBill_StatementDate="//div[@ng-if='currentStatementDate']/span[2]";
	            public static String Q2Wall_PayBill_DueByTitle="//span[@ng-if='billStatus && dueDate']/span[1]";
	            public static String Q2Wall_PayBill_DueBy="//span[@ng-if='billStatus && dueDate']/span[2]";
	            public static String Q2Wall_PayBill_SelectPaymentType="//div[@ng-if='!model.currentBill.autoPayEnrolled']";
	            public static String Q2Wall_PayBill_CreditDebitOption="//label[@for='creditDebitCard']";
	            public static String Q2Wall_PayBill_CreditDebitRadioBtn="//input[@id='creditDebitCard' and @type='radio']";
	            public static String Q2Wall_PayBill_PaymentFreq="//div[@class='support-group pmt-frequency three-col-cell']";
	            public static String Q2Wall_PayBill_OTPOption="//label[@for='oneTime']";
	            public static String Q2Wall_PayBill_OTPRadioBtn="//input[@id='oneTime' and @type='radio']";
	            public static String Q2Wall_PayBill_Autopay="//label[@for='autoPay']";
	            public static String Q2Wall_PayBill_AutopayRadioBtn="//input[@id='autoPay' and @type='radio']";
	  
	            //Priyanka[12-12-2015]
	            
	            public static String PayBill_CreditDebit_CardNum="//input[@id='cardNumber']";
	            public static String PayBill_CreditDebit_ExpMonth="//select[@id='expirationMonth']";
	            public static String PayBill_CreditDebit_ExpYear="//select[@id='expirationYear']";
	            public static String PayBill_CreditDebit_SelectExpMonth="//select[@id='expirationMonth']//option[@value='06']";
	            public static String PayBill_CreditDebit_SelectExpYear="//select[@id='expirationYear']//option[@value='2020']";
	            public static String PayBill_CreditDebit_Amount="//input[@id='paymentAmount']";
	            public static String PayBill_CreditDebit_PayDate="//input[@id='paymentDate']";
	            public static String PayBill_CreditDebit_VerifyCard="//div[@class='col-xs-12 col-sm-6 ng-scope']/div[1]//div[2]//p";
	            public static String PayBill_CreditDebit_VerifyExp="//div[@class='col-xs-12 col-sm-6 ng-scope']/div[2]//div[2]//p";
	            public static String PayBill_CreditDebit_VerifyAmnt="//div[@class='col-xs-12 col-sm-6']/div[1]//div[2]//p";
	            public static String PayBill_CreditDebit_VerifyPayDate="//div[@class='col-xs-12 col-sm-6']/div[2]//div[2]//p";
	            public static String VerifyPay_Heading="//div[@ui-view='content-header']//h2";
	            public static String CreditDebit_VerifyPay_Cancel="//button[@ng-click='cancelPayment()']";
	             
	            //Saranya[12/12/2015]
	            public static String Q2Wall_paymentDateError="//div[@id='paymentDateError']";
	            public static String Q2Wall_PaymentInfo_VerifyPaymentInfo="//h5[.='Pay Bill']";
	            public static String Q2Wall_PaymentInfo_VerifyPaymentInfo_Hdr="//h2[.='Verify Payment Information']";
	            public static String Q2Wall_VerifyPaymentInfo_Hdr="//form[@name='forms.verifyPaymentForm']/h3";
	            public static String Q2Wall_VerifyPaymentInfo_AllDetails="//div[@class='verify-form-inputs']//p";
	            public static String Q2Wall_PayBill_PaymentInfo_Hdr="//form[@name='forms.paymentInfoForm']/h3";
	            
	            //Priyanka[12-14-2015]
	            
	            public static String Q2Wall_EditPay_ConfirmPopup="//div[@ng-click='$event.stopPropagation()']";
	            public static String Q2Wall_EditPay_ConfirmClick="//button[@ng-disabled='working || form.$invalid']";
	            public static String Q2Wall_Edit_CardError="//div[@id='creditCardNumberError']";
	            public static String Q2Wall_Edit_ExpError="//div[@id='expirationDateError']";
	            public static String Q2Wall_ForgotUserName="//div[@class='col-sm-6']//form/div[1]/a";
	            
	            
	          //Jhansi Dec 14,2015
	            // Location Finder UI
	             public static String PaymentCenterTitle="//div[@class='payment-options-container']//b[contains(.,'Payment Center:')]";
	             public static String PaymentCenterDesc="//div[@class='payment-options-container']//p[4][contains(.,'in person')]";
	             public static String FindLocationLink="//a[@ng-click='goToPage(URL.WG_LOCATION_FINDER)']";
	             public static String FindLocationUI_Content="//div[@class[contains(.,'location-finder-content')]]";
	             public static String FindLocationUI_Hdr="//div[@class[contains(.,'location-finder-content')]]/h1";
	             public static String FindLocationUI_txt="//div[@class='location-finder-container']//p";
	             public static String FindLocationUI_Searchtxtbox="//input[@ng-model='model.queryParam']";
	             public static String FindLocationUI_GoBtn="//button[@class[contains(.,'cb-btn-blue')]]";
	             public static String Spec_Logo="//img[@title='Spectrum Business logo']";
	             public static String Hdr_Links="//a[@class[contains(.,'header-support')]]";
	             public static String Footer_Links="//ul[@class='legal-links']/li[3]";
	             
	             //Jhansi Dec14,2015
	             //Payment options-Phone
	             public static String Phone_Hdr="//div[@class='payment-options-container']//b[contains(.,'Phone:')]";
	             public static String Phone_Description="//div[@class='payment-options-container']//p[3][contains(.,'1-800-314-7195')]";
	             //Pay Online
	             public static String PayOnline_Hdr="//div[@class='payment-options-container']//b[contains(.,'Online:')]";
	             public static String PayOnline_Desc="//div[@class='payment-options-container']//p[2][contains(.,'PAY NOW')]";
	             //Mail
	             public static String Mail_Hdr="//div[@class='payment-options-container']//b[contains(.,'Mail:')]";
	             public static String Mail_Desc="//div[@class='payment-options-container']//p[5][contains(.,'5 to 7 days')]";
	             //Payment options
	             public static String PaymentOptions_Content="//div[@class[contains(.,'payment-options-content')]]";
	             public static String PaymentOptions_PgHdr="//h5[.='Your Account']";
	             public static String PaymentOptions_Txt="//div[@class='payment-options-container']//p[contains(.,'Your account is past due')]";
	             

	             //Saranya[12/14/2015]
	             
	             public static String Q2_ConfirmationNavigation="//div[@ng-click='$event.stopPropagation()']";
	             public static String Q2_Confirmbutton="//button[@type='button' and .='CONFIRM']";
	             
	             
	           //Saranya[12/15/2015]
	             
	             public static String SearchResults_Clientaddress_Duration="//div[@class='searched-for']//div[@ng-bind-html='result.Html']";//div[@ng-bind-html='result.Html']";
	             public static String SearchResults_Clientaddress="//div[@ ng-repeat='result in model.result']//p[contains(@class,'address')]";

	             public static String SearchResults=" //div[@class='searched-for']";
	             public static String Q2_SignIn_PageHeader="//h1[.='Sign In']";
	             public static String Q2wall_Cancelbtn="//button[@ ng-click='cancel()']";
	             //Priyanka[12-15-2015]
	             
	             public static String Q2_Arrow="//div[@class='sb-nav-item ng-scope']//div[1]/i";
	             public static String Q2_SignOutLink="//div[@ng-click='signOut()']";
	             
	           //Jhansi Dec 15,2015
	             //Voice 
	             public static String FwdCall_State="//span[@ng-if='!progress.loadingCallForwarding']/span[2]";
	             //View Statements
	             public static String CurrentstatementDropdown="//button[@ng-if='model.statementList.length > 1']";
	             public static String StatementSummarySection="//div[@class='billing-module']";
	             public static String StatementSummary_Hdr="//div[@ng-if[contains(.,'!(loading.statements || loading.billingStatus)')]]/div[1]/div[1]";
	             public static String StatementSummary_currentstaDate="//div[@ng-if[contains(.,'!(loading.statements || loading.billingStatus)')]]/div[1]/div[2]";
	             
	             //Priyanka[12-16-2015]
	             
	           public static String Voice_UnreadMessage="//i[@ng-if='!message.read']";
	           public static String Voice_MissedCall="//div[@class='text--style-r16-3 no-wrap ng-binding missed-call']"; 
	           public static String Voice_Notifications_Line="//div[@class='sb-voice-notification ng-scope']//h3//span";
	           public static String Voice_Notifications_PhoneLine="//div[@ng-if='!(totalUnreadMessage === 0 && totalMissedCalls === 0)']";
	           public static String Voice_Notifications_PerPhoneLine="//div[@ng-if='!(totalUnreadMessage === 0 && totalMissedCalls === 0)']/ancestor::div[@ng-repeat='line in model.phoneLines']";
	           public static String Voice_Notifications_UnreadMessages="//div[@class='sb-voice-notification ng-scope']//div[1]/a";
	           public static String Voice_Notifications_MissedCalls="//div[@class='sb-voice-notification ng-scope']//div[2]/a";
	           public static String Voice_LineNumber="//div[contains(@class,'voice-options-select')]/div[2]/button//div[contains(@class,'voice-line-text')]";
	           public static String Voice_LineNumber_Single="//div[@ng-if='model.phoneNumbers.length === 1']//div[contains(@class,'voice-line-text')]";
	           public static String Voice_LineDropdown="//div[@class='btn-group voice-options-select ng-scope']//button[@dropdown-toggle='dropdown-toggle']";
	           //Saranya[12/16/2015]
	            public static String  NewPasswordLabel="//div[@ for='password']";
	            public static String  RetypePasswordLabel="//div[@for='passwordConfirmation']";
	            public static String  NewPassword_RequiredIcon="//div[@ for='password']/span";
	            public static String  RetypePasswordRequiredIcon="//div[@for='passwordConfirmation']/span";
	            public static String  HelpIcon="//a[@ ng-click='openToolTip()']";
	            public static String HelpToolTip="//div[@class='modal-content']";
	            
	            
	          //Jhansi Dec 16,2015
	            //Payment Info-Credit-Debit-OTP
	            public static String PaymentInfo_CreditDebit_Hdr="(//form[@ng-submit='submitPaymentInfo(model)']//legend)[1]";
	            public static String PaymentInfo_AmtDate_Hdr="//fieldset[@ng-if='!model.recurring']/legend";
	            public static String PaymentInfo_AmtDue_Hdr="//label[.='Amount Due']";
	            public static String PaymentInfo_Amtdue="//div[@class[contains(.,'current-amt')]]";
	            public static String PaymentInfo_DueBy="//span[@ng-if='billStatus && dueDate']/span[1]";
	            public static String PaymentInfo_DueByDate="//span[@ng-if='billStatus && dueDate']/span[2]";
	            public static String CardTypeICon="//div[@ng-switch='cardType']/span";
	            //Forgot password
	            public static String Step3Form="//form[@ng-submit='resetPassword()']";
	            public static String Step3_Hdr="//h1[contains(.,'Step 3')]";
	            public static String Step3_NewPwd="//input[@id='password']";
	            public static String Step3_ConfirmPwd="//input[@id='passwordConfirmation']";
	            public static String Step3_CancelBtn="//button[@ng-click='cancel()']";
	            
	            //Alisha
	            
	            public static String ViewStatement_StatementSummary="//div[@class='col-xs-8 col-sm-6 col-md-6 col-lg-6']";
	    		public static String StatementSummarySection_CurrentSection="//div[@class='hidden-xs hidden-sm col-md-6 col-lg-6 text-right ng-binding']";
	    		public static String StatementSummarySection_PreviousBalance="//div[@class='sb-subpage__list-container billing-list ng-scope']/div[2]/div[@class='col-xs-8']";
	    		//public static String StatementSummarySection_PreviousBalanceValue="//div[@class='sb-subpage__list-container billing-list ng-scope']/div[2]/div[@class='col-xs-4 text-right ng-binding']";
	    		public static String StatementSummarySection_PreviousBalanceValue="//div[@class='sb-subpage__list-container billing-list ng-scope']/div[2]/div[@class='col-xs-4 text-right ng-scope']";
	    		public static String StatementSummarySection_PaymentsReceived="//div[@class='sb-subpage__list-container billing-list ng-scope']/div[3]/div[@class='col-xs-8']";
	    		public static String StatementSummarySection_PaymentsReceivedValue="//div[@class='sb-subpage__list-container billing-list ng-scope']/div[3]/div[@class='col-xs-4 text-right ng-binding']";
	    		public static String StatementSummarySection_SpectrumBusinessServices="//div[@class='sb-subpage__list-container billing-list ng-scope']/div[5]/div[@class='col-xs-8 col-sm-8 col-md-5']";
	    		//public static String StatementSummarySection_PaymentsReceivedValue_DateRange="//div[@class='hidden-xs hidden-sm col-md-5 ng-binding']";
	    		public static String StatementSummarySection_PaymentsReceivedValue_DateRange="//div[@class='col-xs-8 col-sm-8 col-md-5 ng-binding']";
	    		public static String StatementSummarySection_SpectrumBusinessServicesValue="//div[@class='col-xs-4 col-sm-4 col-md-2 text-right ng-binding']";
	    		public static String StatementSummarySection_CurrentBalanceDue="//div[@class='hidden-xs col-sm-8']";
	    		public static String StatementSummarySection_CurrentBalanceDueValue="//div[@class='sb-subpage__list-container billing-list ng-scope']/div[8]/div[@class='col-xs-4 text-right ng-binding']";
	    		public static String DownloadStatementButton="//button[@class='sb-btn sb-btn--alternate sb-btn--icon']";
	    		
	            
	            
	            //Saranya[12/17/2015]
	            public static String ChargeDetailTotalAmountLabel="//div[@ng-if='!errors.billingStatus']";
	            public static String ChargeDetailTotalAmount="//div[contains(@class,'pull-right') and contains(.,'$')]";
	            public static String CallLogDetailsList=" //div[contains(@ng-repeat,'callLog')]";
	            public static String CallLogDetailHeader="//h1[contains(text(),'Call Log Details')]";
	            
	            
	            //Autopay
	        	public static String SaveAutoPayButton="//button[@type='submit' and contains(text(),'Save Auto-Pay')]";
	            public static String  autopay_enrollLink="//a[contains(@href,'enrollAutopay')]/div";
	    		public static String billingSaveautoPayButton="//button[@type='submit' and contains(.,'SAVE AUTO-PAY')]";
	    		public static String  autopay_Terms_conditionLink="//label[@for='acceptTermsAndConditions']//div[@class='icon']";
	    		public static String  autopaySavebtn="//button[@type='submit' and contains(.,'SAVE AUTO-PAY')]";
	    		public static String  autopay_ReturntoOverview="//button[@ng-click='navigate(URL.SMB_OVERVIEW)']";
	    		 //Manage
	    		 public static String  autopay_ManageLink="//a[contains(@href,'pay-bill')]/div";
	    		 public static String  AutoPayOn_NextPayment_Text="//div[@ ng-show='autoPayEnrolled']";
	    		 public static String  AutoPay_Symbol="//div[@ ng-show='autoPayEnrolled']/div/a";
	    		 public static String AutopayCancelbtn="//a[@ng-click='cancelAutoPay()']";
	    		 
	    		 //Priyanka[12-17-2015]
	    		 
	    		 public static String AutoPay_Cancel_Confirmationpopup="//div[@ng-click='$event.stopPropagation()']";
	    		 public static String AutoPay_Cancel_Confirmationpopup_Cancel="//div[@ng-if='modalOptions.showFooter']//a";
	    		 public static String AutoPay_Cancel_Confirmationpopup_Confirm="//div[@ng-if='modalOptions.showFooter']//button";
	    		//Saranya[12/18/2015]
	    			public static String overviewClickAutopay="//div[@ ng-if='isLoggedIn']//a[@ng-href='/smb/overview.html']";

	    			public static String autoPayUnenrollment="//button[@type='button' and .='Complete Unenrollment']";
	    			
	    			 //Priyanka[12-18-2015]
		    		 
		    		 public static String AutoPay_Radiobtn="//input[@id='autoPay']";
		    		 public static String AutoPay_CreditDebit_hdr="//form[@ng-submit='submitPaymentInfo(model)']/div[1]/div[1]//h4";
		    		 public static String AutoPay_CardNo_Label="//label[@for='cardNumber']";
		    		 public static String AutoPay_ExpDate_Label="//label[@for='expirationDate']";
		    		 public static String AutoPay_Savebutton="//button[.='Save Auto-Pay']";
		    		 public static String AutoPay_Support="//a[@ng-click='navigate(URL.CMS_SUPPORT)']";
		    		 public static String SupportPageLinkVerification="//div[@class='support-hero']";

		    		 
		    		 //jhansi-cleanup
		    		 public static String UserDetailRoleList="//div[@class='sb-detail__row'][1]//div[contains(@class,'text-item')]";
		    		 public static String UserDetailVoiceList="//div[@ng-repeat='line in details.services.voice.assignedLines']//div[contains(@class,'assigned-item')]";
		    		 public static String UserDetail_MailId="//div[contains(@class,'sb-detail__text-item')][2]";
		    		
		    		 public static String KeyImg_Role="//div[@class='sb-edit__row']/i[contains(@class,'icon--gray sb_ic_settings_card')]";
		    		 public static String EditMode_DropdownList="//ul[@role='menu']//span";
		    		 
		    		//Priyanka[12-23-2015]
		    		 public static String NewAssignment_Radiobuttonone="//form[@ng-submit='saveFunction()']//label[1]//div//i";
		    		 public static String NewAssignmentEdit_Save="//div[@ng-if='!secondaryActionSheetOptions.hideHeaderRow']//button[@ng-click='secondaryActionSheetOptions.saveFunction()']";
		    		 public static String NewAssignment_Save="//div[@ng-if='!actionSheetOptions.hideHeaderRow']//button[@ng-click='actionSheetOptions.saveFunction()']";
		    		 public static String NewAssignment_Close="//div[@id='sbDetailContent']//a[.='CLOSE']";
		    		 
		    		 //Saranya[Clean UP]
		    		   public static String CompanyProfile_Save="//button[@type='submit' and .='SAVE']";//div[@class='sb-company-profile-btns']//button[.='SAVE']";

			    	public static String billingCardNumber="//input[@name='cardNumber']";//input[@ng-class=\"{'error': debouncedErrors.cardNumber }\" ]";
		  		    public static String StatementDropdownlist="//div[@class='dropdown open']/ul/li[2]/a";//ul[@ng-if='model.statementList.length > 1']/li[2]";

		    		 public static String CompanyProfile_SecuritySettings="//div[@ng-if='isAdmin()']//div[@href='#/company/security']";//div[@ng-if='isAdmin()']/div[3]/div[.='Security Settings']";
		    		 public static String CompanyProfile_Cancel="//a[@ng-click='resetAddressAndContactForm()']";//div[@class='sb-company-profile-btns']//a[.='CANCEL']";
		    		 public static String SecurityProfile_Cancel="//a[@ng-click='resetCodeForm()']";//a[@ng-click='resetAddressAndContactForm()']";
		    		 public static String PayBill_OtherPaymentMethods="//div[@class='radio']/label[@for='other']/div[1]/div";//div[@class='radio']/label[@for='other']/input[@id='other']";
		    		 public static String OtherPayment_PayByPhoneHeading="//h4[contains(.,'Pay by Phone')]";//div[@class='sb-pay-bill-other ng-scope']/div/h4";
		    		 public static String OtherPayment_PayByPhoneOptionOne="//div[@ng-if='!isControlAccount']/ul/li[1]";//div[@class='sb-pay-bill-other ng-scope']/div/ul/li[1]";
		    		 public static String OtherPayment_PayByPhoneOptionTwo="//div[@ng-if='!isControlAccount']/ul/li[2]";//div[@class='sb-pay-bill-other ng-scope']/div/ul/li[2]";
		    		 public static String OtherPayment_PayByMailHeading="//h4[.='Pay By Mail']";//div[@class='sb-pay-bill-other ng-scope']/h4[1]";
		    		 public static String OtherPayment_PayByMailText="//p[contains(text(),'detachable portion')]";//div[@class='sb-pay-bill-other ng-scope']/p[1]";
		    		 public static String OtherPayment_OnlineBankingHeading="//h4[.='Online Banking']";//div[@class='sb-pay-bill-other ng-scope']/h4[2]";
		    		 public static String OtherPayment_OnlineBankingText="//p[contains(text(),'3rd party payment')]";//div[@class='sb-pay-bill-other ng-scope']/p[2]";
		    		 public static String MyProfile_Save="//button[@type='submit' and .='SAVE']";//div[@class='profile-btn-container']/button[.='SAVE']";
		    		 public static String CP_SS_ServiceAddressCheckbox="//div[contains(@class,'checkbox')]/i";//div[@class='checkbox-row-cell checkbox-btn-cell checkbox-btn']//i";
		 			 public static String goGreenText="//h2[contains(.,'Go Green')]";//div[@class='billing-options']/h2[contains(.,'Go Green')]";
					 public static String disabledSavebutton="//button[@disabled='disabled' and .='SAVE']";//button[@disabled='disabled'][contains(.,'Save')]";
					 public static String onlineBill="//div[@class='radio']//label[@ for='onlineBill']//i";//onlineBill";
					 public static String paperAndOnlineBill="//div[@class='radio']//label[@for='paperAndOnlineBill']//i";//paperAndOnlineBill";
					 public static String saveButtonForBillPay="//button[@type='submit' and .='SAVE']";//button[@class='sb-btn sb-btn--primary pull-right']";
//Priyanka[12-24-2015]
		    		 
		    		 public static String SavedAssignee="//div[@class='sb-detail__text-item ng-binding ng-scope']";
		    		 public static String Assignee_Saved="//div[@ng-if='line.isAssigned && (line.assignment.firstName && line.assignment.lastName)']";
		    		 public static String ManageUsersList_AssignedLine="//div[contains(@ng-if,'line.assignment.firstName')]";
		    		 public static String ModifyChanges_Cancel="//div[@ng-if='modalOptions.showFooter']//a";
		    		 public static String Modify_Cancel="//div[@id='sbDetailContent']//a[@ng-click='actionSheetOptions.cancelFunction()']";
//Saranya[12/25/2015]
		    		 public static String Pwd_Fair="//div[contains(@ ng-show,'FAIR')]";

		    		 public static String CurrentBillSection= "//div[@class='sb-floating-panel sb-row-bottom-border ng-scope']";
		    		 public static String PayBillOption= "//div[@class='sb-section-header']";
		    		 public static String PayBill_AccNumTitle= "//div[@class='sb-current-bill']/div[3]/span[1]";
		    		 public static String PayBill_AccNum= "//div[@class='sb-current-bill']/div[3]/span[2]";
		    		 public static String PayBill_CurrentBillAmt= "//div[@class='sb-amount-due ng-binding']";
		    		 public static String AutoPayEnabledIcon="//div[@ng-show='isDisabled']/i[@class='icon icon--blue-4 autopay__icon sb_ic_autopay_f']";
		    		 public static String AutoPayOn="//div[@class='autopay__status clearfix']/div[3]/div/strong[contains(.,'Auto-Pay On')]";
		    		 public static String AutoPaySettings="//div[@class='sb-three-col-cell sb-second-col']/div/h4[contains(.,'Auto Pay Settings')]";
		    		 public static String NextPaymentScheduled="//div[@class='autopay__status clearfix']/div[3]/div[@class='pmt-date-txt ng-scope']";
		    		 public static String PayBill_StatementDate="//div[@ng-if='currentStatementDate']/span[@class='ng-binding']";
		    		 public static String PayBill_StatementTitle="//div[@ng-if='currentStatementDate']/span[@class='bold']";
		    		 public static String PayBill_DueByTitle="//span[@ng-if='billStatus && dueDate']/span[@class='bold']";
		    		 public static String PaymentInfo_Details="//div[@nf-if='model.currentBill.autoPayMethod === CARD']";
		    		 public static String PayBill_DueByDateValue="//span[@ng-if='billStatus && dueDate']/span[2]/span";
		    		 public static String VerifyPaymentInfo_Details= "//div[@class='sb-three-col-cell sb-second-col']";
		    		 public static String PayBill_PaymentTypeTitle= "//div[@class='sb-three-col-cell sb-second-col']/div/div/div[1]/div[1]/label[@class='control-label no-wrap']";
		    		 public static String PayBill_PaymentType="//div[@class='sb-three-col-cell sb-second-col']/div/div/div[1]/div[2]/p[@class='form-control-static auto-pay-info ng-binding']";
		    		 public static String PayBill_ExpirationDateTitle="//div[@class='sb-three-col-cell sb-second-col']/div/div/div[3]/div[1]/label[@class='control-label no-wrap']";
		    		 public static String PayBill_ExpirationDate="//div[@class='sb-three-col-cell sb-second-col']/div/div/div[3]/div[2]/p[@class='form-control-static auto-pay-info ng-binding']";
		    		 public static String PayBill_AccountNumberTitle="//div[@class='sb-three-col-cell sb-second-col']/div/div/div[2]/div[1]/label[@class='control-label no-wrap']";
		    		 public static String PayBill_AccountNumber="//div[@class='sb-three-col-cell sb-second-col']/div/div/div[2]/div[2]/p[@class='form-control-static auto-pay-info ng-binding']";
		    		 // public static String SavedAssignee="//div[@class='sb-detail__text-item ng-binding ng-scope']";
		    		 
		    		//Jhansi Dec 28,2015
		    		 //V1 authenticated user
		    		 public static String Header_HelloTxt="//div[@ng-click='toggleDropDown($event)'][2]/div[1]";
		    		 public static String Header_cmpyName="//div[@ng-click='toggleDropDown($event)'][2]/div[2]";
		    		 public static String Header_AcctNum="//li[contains(@ng-class,'!smbOwnerAuthorized')]/div";
		    		 public static String Header_SecCode="//li[contains(@ng-if,'smbOwnerAuthorized')]/div/span";
		    		 public static String Header_CmpyProfile="//div[@ng-click='goTo(companyProfileUrl)']";
		    		 public static String Header_MyProfile="//div[@ng-click='goTo(myProfileUrl)']";
		    		 public static String Header_Logout="//h5[.='Logout']";
		    		 public static String V1_OvwLabel="//h5[.='Overview']";
		    		 
		    		 //[12-29-2015]
		    		 
		    		 public static String AdminName="//div[@id='sbDetailContent']/div[2]/div[3]/div/div[1]";
		    		 public static String Radiobuttons="//span[contains(@ng-if,'user.firstName')]";
		    		 
		    		 //Q2//
		    		 
		    		 public static String ExpDate_Month="//select[@id='expirationMonth']/option"; 
		    		 public static String ExpDate_Year="//select[@id='expirationYear']/option";
		    		 public static String Q2Wall_PaymentInformationHeader="//div[@class='bottom-divider']/h2[@class='header-ribbon']";

		    		 
		    		 public static String EnrollAutoPayLink="//div[contains(text(),'Enroll in Auto Pay')]";
		    		 public static String ViewstatementsLink="//div[contains(text(),'View Statements')]";
		    		 public static String ViewStatements_Page="//li[4][@class='toolbar-main sb-tablet--hidden toolbar__section ng-binding ng-scope']";
		    		 public static String PaymentHistoryLink="//div[contains(text(),'View Payment History')]";
		    		 public static String PaymentHistory_Page="//li[4][@class='toolbar-main sb-tablet--hidden toolbar__section ng-binding ng-scope']";
		    		 public static String CurrentBillTitle="//h3[contains(text(),'Current Bill')]";
		    		 public static String BillAmount="//*[@id='smbNotificationsPanel']/div[2]/div/div[1]";
		    		 public static String StatementTitle="//div[contains(text(),'Statement:')]";
		    		 public static String StatementDate="//div[contains(text(),'Statement:')]/span";
		    		 public static String DueByTitle="//*[@id='smbNotificationsPanel']/div[2]/div/div[2]/div[2]/div[contains(text(),'Due By:')]";
		    		 public static String DueByDate="//*[@id='smbNotificationsPanel']/div[2]/div/div[2]/div[2]/div[contains(text(),'Due By:')]/span";
		    		 public static String AutoPayIcon="//i[@title='Go to auto-pay settings']";
					 public static String ManageAutoPayLink="//div[contains(text(),'Manage Auto-Pay')]";
					 public static String AutoPayOnText ="//div/strong";
					 public static String SpectrumServicesSection ="//div[contains(text(),'Spectrum Services')]";
					 public static String MoreServicesSection ="//div[contains(text(),'More Services')]";
					 public static String AccountServicesSection ="//div[contains(text(),'Account')]";
					 
					 
}