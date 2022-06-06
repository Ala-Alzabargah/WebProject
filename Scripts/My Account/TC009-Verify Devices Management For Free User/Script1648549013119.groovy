import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.testdata.TestData as TestData
import shahid.Common
import com.kms.katalon.core.testobject.TestObject
import internal.GlobalVariable as GlobalVariable

	new Common().navigateToShahid()

	new Common().checkLanguage()

	new Common().login(GlobalVariable.FreeUser, GlobalVariable.FreeUserPassword)

	new Common().selectUser()

	new Common().tapAtBurgerMenu()

	new Common().clickAtMyAccount()

WebUI.click(findTestObject('Object Repository/' + GlobalVariable.objLanguage + '/Settings Screen/Account Settings Screen/devicesManagement'))

	WebUI.waitForElementPresent(findTestObject('Object Repository/' + GlobalVariable.objLanguage + '/Settings Screen/Devices Management/devicesManagementText'), 2)

		WebUI.setText(findTestObject('Settings Screen/Devices Management/paringCodeFiled'), "123456")

	WebUI.click(findTestObject('Settings Screen/Devices Management/submitParingCodeButton'))
	
	WebUI.verifyElementPresent(findTestObject('Object Repository/' + GlobalVariable.objLanguage + '/Settings Screen/Devices Management/wrongParingCodeErrorMessage'), 3)

	WebUI.waitForElementPresent(findTestObject('Object Repository/' + GlobalVariable.objLanguage + '/Settings Screen/Devices Management/numberOfDevicesAllowedText'), 2)

	WebUI.waitForElementPresent(findTestObject('Object Repository/' + GlobalVariable.objLanguage + '/Settings Screen/Devices Management/devicesCurrentlyLinkedText'), 2)

	WebUI.waitForElementPresent(findTestObject("Object Repository/Settings Screen/Devices Management/linkedDeviceItem"), 2)
	if(WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Devices Management/deviceInfoContainer'), 3)){
		WebUI.click(findTestObject('Object Repository/Settings Screen/Devices Management/editButton'))
		WebUI.clearText(findTestObject('Object Repository/Settings Screen/Devices Management/updatedevicenameField'))
		WebUI.setText(findTestObject('Object Repository/Settings Screen/Devices Management/updatedevicenameField'), 'update for test')
		WebUI.click(findTestObject('Object Repository/Settings Screen/Devices Management/saveButton'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Devices Management/updateDeviceNameMessage'), 5)
		WebUI.click(findTestObject('Object Repository/Settings Screen/Devices Management/deleteLinkedDeviceButton'))
		WebUI.click(findTestObject('Object Repository/Settings Screen/Devices Management/deletePopUp-YesButton'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Devices Management/deleteDoneText'), 5)
	}
	

WebUI.back()
//WebUI.closeBrowser()