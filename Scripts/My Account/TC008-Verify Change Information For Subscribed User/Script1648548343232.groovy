import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.github.javafaker.Faker as Faker
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import shahid.Common as Common
import internal.GlobalVariable as GlobalVariable


//	new Common().navigateToShahid()
//
//	new Common().checkLanguage()
//
//	new Common().login(GlobalVariable.UltimateUser, GlobalVariable.UltimateUserPassword)
//
//	new Common().selectUser()
//
//	new Common().tapAtBurgerMenu()
//
//	new Common().clickAtMyAccount()

	WebUI.click(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/changePersonalInfo'))

	WebUI.waitForElementVisible(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/infoElements/infoManagementText'),
		4)

	Faker faker = new Faker()

	WebUI.waitForElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/infoElements/infoManagementText'),
		2)

	WebUI.setText(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/infoElements/firstName'),
		faker.name().firstName())

	WebUI.setText(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/infoElements/lastName'),
		faker.name().lastName())

	WebUI.delay(2)

	WebUI.click(findTestObject('Object Repository/Settings Screen/infoElements/genderDropDownButton'))

	WebUI.click(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/infoElements/male'))

	WebUI.delay(2)

	WebUI.click(findTestObject('Object Repository/Settings Screen/infoElements/monthsDropdownButton'))

	WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/infoElements/monthsDropDownList'), 2)

	WebUI.click(findTestObject('Object Repository/Settings Screen/infoElements/monthsDropdownButton'))

	WebUI.click(findTestObject('Object Repository/Settings Screen/infoElements/yearsDropdownButton'))

	WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/infoElements/yearsDropdownList'), 3)

	// Verify Years
	int c = 2002

	for (def x = 5; x <= 105; x++) {
		String Xpath = '(//button[contains(@class,"userInformation")])'

		Xpath = (((Xpath + '[') + x) + ']')

		TestObject YearElement = WebUI.modifyObjectProperty(findTestObject('Object Repository/Settings Screen/infoElements/yearElement'),
			'xpath', 'equals', Xpath, true)

		println(YearElement)

		def b = WebUI.getText(YearElement)

		println(b)

		boolean result = c == b

		c--
	}
	
	WebUI.click(findTestObject('Object Repository/Settings Screen/infoElements/yearsDropdownButton'))

	if (WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/phoneNumberFieldAccountSittings'),
		2)) {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/phoneNumberFieldAccountSittings'),
			2)

		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/infoElements/emailField'), 2)

		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/infoElements/submitButton'), 2)

		WebUI.click(findTestObject('Settings Screen/infoElements/submitButton'))

		WebUI.click(findTestObject('Object Repository/Settings Screen/infoElements/backButton'))

		WebUI.delay(2)
	} else {
		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/infoElements/emailField'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/infoElements/connectMobileNumber'),
			2)

		WebUI.click(findTestObject('Object Repository/Settings Screen/infoElements/connectMobileNumber'))

		WebUI.delay(2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/infoElements/sub-connectMobileNumber'),
			2)

		WebUI.back()

		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/infoElements/submitButton'), 2)

		WebUI.click(findTestObject('Settings Screen/infoElements/submitButton'))

		WebUI.delay(2)

		WebUI.click(findTestObject('Object Repository/Settings Screen/infoElements/backButton'))

		WebUI.delay(2)
	}

WebUI.back()
//WebUI.closeBrowser()