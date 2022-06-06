import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.Common

CustomKeywords.'shahid.Common.navigateToShahid'()
	
	
	new Common().checkLanguage()
	new Common().login(GlobalVariable.SubscribedUser,GlobalVariable.SubscribedUserPassword)
	
	WebUI.waitForElementPresent(findTestObject('adultDefault'), 10)
	WebUI.delay(2)
	WebUI.click(findTestObject('adultDefault'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.delay(2)
	new Common().checkLanguage()
	 if(WebUI.waitForElementVisible(findTestObject('loginThreeLanguages/hamburgerMenu'),7)) {
		WebUI.click(findTestObject('loginThreeLanguages/hamburgerMenu'))
		WebUI.delay(3)
		Mobile.swipe(0, 1000, 0, 0)
		}
	   
		WebUI.click(findTestObject('Object Repository/moreScreenThreeLanguages/myListButton'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/nothingInTheListText'),3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/addtoMyListButton'),3)

        WebUI.closeBrowser()