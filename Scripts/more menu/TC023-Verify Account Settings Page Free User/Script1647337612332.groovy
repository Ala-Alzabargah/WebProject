import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.Common






CustomKeywords.'shahid.Common.navigateToShahid'()

new Common().checkLanguage()
CustomKeywords.'shahid.Common.login'(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)

	WebUI.waitForElementPresent(findTestObject('adultDefault'), 10)
	WebUI.delay(1)
	WebUI.click(findTestObject('adultDefault'), FailureHandling.CONTINUE_ON_FAILURE)


    new Common().popupNotification()
    new Common().tapAtBurgerMenu()
	new Common().checkLanguage()
    new Common().clickAtMyAccount()
   
        WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/accountSettingsDescriptionText'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/subscribeToShahidVipButton'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/joinNowText'),2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/noCommitmentMessage'), 2)
//		WebUI.verifyElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/shahidOriginalsText'), 2)
		
//		WebUI.verifyElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/viewPackagesButton'),2)

        WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/changePassword'), 2)
        WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/changePersonalInfo'), 2)
        WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/devicesManagement'), 2)

        WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/parentalControlInterface'), 2)

        WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/viewPreviousTransaction'), 2)
        WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/specialFeatures'), 2)

        WebUI.closeBrowser()
	
	


	


























