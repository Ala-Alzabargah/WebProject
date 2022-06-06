import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebDriver

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.Common as Common

new Common().navigateToShahid()

WebDriver driver = DriverFactory.getWebDriver()

String landingPageTitle

String showPageTitle

CustomKeywords.'shahid.Common.login'(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)

WebUI.waitForElementPresent(findTestObject('adultDefault'), 10)
WebUI.delay(2)
WebUI.click(findTestObject('adultDefault'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(2)
CustomKeywords.'shahid.Common.checkLanguage'()


new Common().checkLanguage()
WebUI.waitForElementVisible(findTestObject('Object Repository/Show Pages/showPageLogo'), 7)
landingPageTitle = WebUI.getAttribute(findTestObject('Object Repository/Show Pages/showPageLogo'), 'title')
WebUI.click(findTestObject('Object Repository/Show Pages/showPageLogo'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Show Pages/showPageLogo'), 7)
showPageTitle = WebUI.getAttribute(findTestObject('Object Repository/Show Pages/showPageLogo'), 'title')



if (!(landingPageTitle.equals(showPageTitle))) {
	System.err.println('landingPageTitle *** ' + landingPageTitle)
	System.err.println('showPageTitle *** ' + showPageTitle)
	KeywordUtil.markFailed('Title not match')
}

new Common().tapAtBurgerMenu()
WebUI.waitForPageLoad(3)
WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/TVShowsLink'))
WebUI.waitForPageLoad(2)
WebUI.waitForElementVisible(findTestObject('Object Repository/Show Pages/showPageLogo'), 7)
landingPageTitle = WebUI.getAttribute(findTestObject('Object Repository/Show Pages/showPageLogo'), 'title')
WebUI.click(findTestObject('Object Repository/Show Pages/showPageLogo'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Show Pages/showPageLogo'), 7)
showPageTitle = WebUI.getAttribute(findTestObject('Object Repository/Show Pages/showPageLogo'), 'title')

if (!(landingPageTitle.equals(showPageTitle))) {
	System.err.println('landingPageTitle *** ' + landingPageTitle)
	System.err.println('showPageTitle *** ' + showPageTitle)
	KeywordUtil.markFailed('Title not match')
}
///////////////
new Common().tapAtBurgerMenu()
WebUI.waitForPageLoad(2)
WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/moviesLink'))
WebUI.waitForPageLoad(2)
WebUI.waitForElementVisible(findTestObject('Object Repository/Show Pages/showPageLogo'), 7)
WebUI.waitForPageLoad(4)
landingPageTitle = WebUI.getAttribute(findTestObject('Object Repository/Show Pages/showPageLogo'), 'title')
WebUI.waitForPageLoad(2)
WebUI.click(findTestObject('Object Repository/Show Pages/showPageLogo'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Show Pages/showPageLogo'), 7)
showPageTitle = WebUI.getAttribute(findTestObject('Object Repository/Show Pages/showPageLogo'), 'title')

if (!(landingPageTitle.equals(showPageTitle))) {
	System.err.println('landingPageTitle *** ' + landingPageTitle)
	System.err.println('showPageTitle *** ' + showPageTitle)
	KeywordUtil.markFailed('Title not match')
}

new Common().tapAtBurgerMenu()
WebUI.waitForPageLoad(3)
WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/sportsLink'))
WebUI.waitForPageLoad(7)
WebUI.waitForElementVisible(findTestObject('Object Repository/Show Pages/showPageLogo'), 15)
landingPageTitle = WebUI.getAttribute(findTestObject('Object Repository/Show Pages/showPageLogo'), 'title')
WebUI.click(findTestObject('Object Repository/Show Pages/showPageLogo'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Show Pages/showPageLogo'), 7)
showPageTitle = WebUI.getAttribute(findTestObject('Object Repository/Show Pages/showPageLogo'), 'title')

if (!(landingPageTitle.equals(showPageTitle))) {
	System.err.println('landingPageTitle *** ' + landingPageTitle)
	System.err.println('showPageTitle *** ' + showPageTitle)
	KeywordUtil.markFailed('Title not match')
}
	z
	WebUI.closeBrowser()

