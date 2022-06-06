import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.Common as Common


new Common().navigateToShahid()
String DeviceName = MobileDriverFactory.getDeviceName()
WebDriver driver = DriverFactory.getWebDriver()
new Common().checkLanguage()



WebUI.verifyElementVisible(findTestObject('Object Repository/HomeScreen/shahidlogos/shahidlogoanonymous'))


	new Common().login(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
	WebUI.delay(2)
	WebUI.waitForElementPresent(findTestObject('adultDefault'), 10)
	WebUI.delay(2)
	WebUI.click(findTestObject('adultDefault'), FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.verifyElementVisible(findTestObject('Object Repository/HomeScreen/shahidlogos/shahidlogoanonymous'))
	new Common().checkLanguage()
//	new Common().logout()
	WebUI.closeBrowser()



