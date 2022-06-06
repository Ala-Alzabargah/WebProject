import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.Common as Common

CustomKeywords.'shahid.Common.navigateToShahid'()
CustomKeywords.'shahid.Common.checkLanguage'()

WebUI.waitForElementVisible(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/watchNowButton'), 7)
WebUI.click(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/watchNowButton'))
WebUI.waitForPageLoad(3)
//WebUI.click(findTestObject("Object Repository/LandingPage/vipEpisode"))

new Common().tapAtBurgerMenu()
WebUI.waitForPageLoad(3)
WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/TVShowsLink'))
WebUI.waitForPageLoad(3)
WebUI.waitForElementVisible(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/watchNowButton'), 7)
WebUI.click(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/watchNowButton'))
WebUI.waitForPageLoad(3)


new Common().tapAtBurgerMenu()
WebUI.waitForPageLoad(4)
WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/moviesLink'))
WebUI.waitForElementVisible(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/watchNowButton'), 7)
WebUI.click(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/watchNowButton'))
WebUI.waitForPageLoad(3)


new Common().tapAtBurgerMenu()
WebUI.waitForPageLoad(3)
WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/sportsLink'))
WebUI.waitForPageLoad(6)
WebUI.waitForElementVisible(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/watchNowButton'), 15)
WebUI.click(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/watchNowButton'))
WebUI.waitForPageLoad(3)

WebUI.closeBrowser()
