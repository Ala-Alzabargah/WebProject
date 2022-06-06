import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.Common as Common

new Common().navigateToShahid()



    new Common().login(GlobalVariable.SubscribedUser,GlobalVariable.SubscribedUserPassword)

	WebUI.delay(2)
	WebUI.waitForElementPresent(findTestObject('adultDefault'), 10)
	WebUI.delay(2)
	WebUI.click(findTestObject('adultDefault'), FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.waitForElementVisible(findTestObject('Object Repository/Show Pages/heroBanner'), 10)
	WebUI.verifyElementPresent(findTestObject('Object Repository/Show Pages/heroBanner'), 2)


	
   WebUI.closeBrowser()
