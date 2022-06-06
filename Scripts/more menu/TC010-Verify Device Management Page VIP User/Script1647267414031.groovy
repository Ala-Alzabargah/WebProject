import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.Common


	

CustomKeywords.'shahid.Common.navigateToShahid'()
CustomKeywords.'shahid.Common.checkLanguage'()
CustomKeywords.'shahid.Common.login'(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)
WebUI.delay(1)
WebUI.waitForElementPresent(findTestObject('adultDefault'), 10)
WebUI.click(findTestObject('adultDefault'), FailureHandling.CONTINUE_ON_FAILURE)
CustomKeywords.'shahid.Common.checkLanguage'()
new Common().checkLanguage()

new Common().tapAtBurgerMenu()
new Common().clickAtMyAccount()

	
	WebUI.click(findTestObject('Object Repository/moreScreenThreeLanguages/'+ GlobalVariable.objLanguage+'/deviceManagementButton'))

	WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+ GlobalVariable.objLanguage+'/devicesManagementText'), 2)

	WebUI.setText(findTestObject('Settings Screen/Devices Management/paringCodeFiled'), "123456")

	WebUI.click(findTestObject('Object Repository/moreScreenThreeLanguages/'+ GlobalVariable.objLanguage+'/submitParingCodeButton'))
	

	WebUI.verifyElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+ GlobalVariable.objLanguage+'/wrongParingCodeErrorMessage'), 3)
	WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+ GlobalVariable.objLanguage+'/numberOfDevicesAllowedText'), 2)
	
	WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+ GlobalVariable.objLanguage+'/devicesCurrentlyLinkedText'), 2)

	
	

	if(WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Devices Management/deviceInfoContainer'), 3)){
		WebUI.click(findTestObject('Object Repository/Settings Screen/Devices Management/editButton'))
		WebUI.clearText(findTestObject('Object Repository/Settings Screen/Devices Management/updatedevicenameField'))
		WebUI.setText(findTestObject('Object Repository/Settings Screen/Devices Management/updatedevicenameField'), 'update for test')
		
		WebUI.click(findTestObject('Object Repository/moreScreenThreeLanguages/'+ GlobalVariable.objLanguage+'/saveButton'))
		
		WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+ GlobalVariable.objLanguage+'/updateDeviceNameMessage'), 5)
		
		WebUI.click(findTestObject('Object Repository/Settings Screen/Devices Management/deleteLinkedDeviceButton'))
		
		WebUI.click(findTestObject('Object Repository/moreScreenThreeLanguages/'+ GlobalVariable.objLanguage+'/deletePopUp-YesButton'))
		
		WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+ GlobalVariable.objLanguage+'/deleteDoneText'), 5)
		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Devices Management/deviceName'), 5)
		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Devices Management/deviceDate'), 5)
	}
	WebUI.closeBrowser()
	
	


	
