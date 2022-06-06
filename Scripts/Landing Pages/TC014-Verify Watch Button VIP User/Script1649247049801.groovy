import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.Common as Common

CustomKeywords.'shahid.Common.navigateToShahid'()
CustomKeywords.'shahid.Common.checkLanguage'()


CustomKeywords.'shahid.Common.login'(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUser)
WebUI.waitForElementPresent(findTestObject('adultDefault'), 10)
WebUI.delay(2)
WebUI.click(findTestObject('adultDefault'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(2)
CustomKeywords.'shahid.Common.checkLanguage'()
	
	
	
	WebUI.waitForElementVisible(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/watchNowButton'), 10)
	WebUI.delay(1)
	WebUI.click(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/watchNowButton'))
	WebUI.waitForPageLoad(3)
//	WebUI.click(findTestObject("Object Repository/LandingPage/vipEpisode"))
		
	if (WebUI.waitForElementVisible(findTestObject('Login/burgerIcon'), 7)) {
		WebUI.click(findTestObject('Login/burgerIcon'))
	}
		
	WebUI.waitForPageLoad(3)
	WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/TVShowsLink'))
	WebUI.waitForPageLoad(3)
	WebUI.waitForElementVisible(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/watchNowButton'), 7)
	WebUI.click(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/watchNowButton'))
	WebUI.waitForPageLoad(3)
	if (WebUI.waitForElementVisible(findTestObject('Login/burgerIcon'), 7)) {
		WebUI.click(findTestObject('Login/burgerIcon'))
	}
		
	WebUI.waitForPageLoad(3)
	WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/moviesLink'))
	WebUI.click(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/watchNowButton'))
	WebUI.waitForPageLoad(3)
		
		
	if (WebUI.waitForElementVisible(findTestObject('Login/burgerIcon'), 7)) {
		WebUI.click(findTestObject('Login/burgerIcon'))
	}
		
		WebUI.waitForPageLoad(3)
		WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/sportsLink'))
		WebUI.waitForPageLoad(6)
		WebUI.waitForElementVisible(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/watchNowButton'), 15)
		WebUI.click(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/watchNowButton'))
		WebUI.waitForPageLoad(3)
		
		WebUI.closeBrowser()