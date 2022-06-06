import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.Common as Common

new Common().navigateToShahid()


String landingPageTitle

String showPageTitle


new Common().checkLanguage()

  CustomKeywords.'shahid.Common.login'(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUser)
  WebUI.waitForElementPresent(findTestObject('adultDefault'), 10)
  WebUI.delay(2)
  WebUI.click(findTestObject('adultDefault'), FailureHandling.CONTINUE_ON_FAILURE)
  WebUI.delay(2)
  CustomKeywords.'shahid.Common.checkLanguage'()
   
	new Common().checkLanguage()
	WebUI.waitForElementVisible(findTestObject('Object Repository/LandingPages/firstPoster'), 7)
	landingPageTitle = WebUI.getAttribute(findTestObject('Object Repository/LandingPages/firstPoster'), 'title')
	WebUI.click(findTestObject('Object Repository/LandingPages/firstPoster'))
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
   WebUI.waitForPageLoad(3)
	WebUI.waitForElementVisible(findTestObject('Object Repository/LandingPages/firstPoster'), 7)
	landingPageTitle = WebUI.getAttribute(findTestObject('Object Repository/LandingPages/firstPoster'), 'title')
	WebUI.click(findTestObject('Object Repository/LandingPages/firstPoster'))
	WebUI.waitForElementVisible(findTestObject('Object Repository/Show Pages/showPageLogo'), 7)
	showPageTitle = WebUI.getAttribute(findTestObject('Object Repository/Show Pages/showPageLogo'), 'title')

	if (!(landingPageTitle.equals(showPageTitle))) {
		System.err.println('landingPageTitle *** ' + landingPageTitle)
		System.err.println('showPageTitle *** ' + showPageTitle)
		KeywordUtil.markFailed('Title not match')
	}
	
	new Common().tapAtBurgerMenu()
	WebUI.waitForPageLoad(3)
	WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/moviesLink'))
	WebUI.waitForPageLoad(3)
	WebUI.waitForElementVisible(findTestObject('Object Repository/LandingPages/firstPoster'), 7)
	landingPageTitle = WebUI.getAttribute(findTestObject('Object Repository/LandingPages/firstPoster'), 'title')
	WebUI.click(findTestObject('Object Repository/LandingPages/firstPoster'))
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
	WebUI.waitForPageLoad(3)
	new Common().ScrollUntilElementPresent('Object Repository/LandingPages/firstPoster')
	WebUI.waitForElementVisible(findTestObject('Object Repository/LandingPages/firstPoster'), 7)
	landingPageTitle = WebUI.getAttribute(findTestObject('Object Repository/LandingPages/firstPoster'), 'title')
	WebUI.click(findTestObject('Object Repository/LandingPages/firstPoster'))
	WebUI.waitForElementVisible(findTestObject('Object Repository/Show Pages/showPageLogo'), 7)
	showPageTitle = WebUI.getAttribute(findTestObject('Object Repository/Show Pages/showPageLogo'), 'title')

	if (!(landingPageTitle.equals(showPageTitle))) {
		System.err.println('landingPageTitle *** ' + landingPageTitle)
		System.err.println('showPageTitle *** ' + showPageTitle)
		KeywordUtil.markFailed('Title not match')
	}
	
WebUI.closeBrowser()
