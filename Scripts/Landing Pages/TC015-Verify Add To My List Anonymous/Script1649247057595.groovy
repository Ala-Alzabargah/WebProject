import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject



import org.openqa.selenium.By
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.Common as Common




CustomKeywords.'shahid.Common.navigateToShahid'()
CustomKeywords.'shahid.Common.checkLanguage'()

//WebUI.waitForElementVisible(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/addToMyList'), 15)
WebUI.refresh()
WebUI.click(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/addToMyList'))
    WebUI.waitForPageLoad(3)
	
if (!(WebUI.getUrl().contains('/login'))) {
    KeywordUtil.markFailed('URL not match :' + WebUI.getUrl())
}

new Common().tapAtBurgerMenu()
    WebUI.waitForPageLoad(3)
    WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/TVShowsLink'))
    WebUI.waitForPageLoad(4)
//WebUI.waitForElementVisible(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/addToMyList'), 15)
	WebUI.refresh()
    WebUI.click(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/addToMyList'))
    WebUI.waitForPageLoad(3)

if (!(WebUI.getUrl().contains('/login'))) {
    KeywordUtil.markFailed('URL not match :' + WebUI.getUrl())
}

new Common().tapAtBurgerMenu()
    WebUI.waitForPageLoad(3)
    WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/moviesLink'))
    WebUI.waitForPageLoad(3)
//    WebUI.waitForElementVisible(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/addToMyList'), 7)
    WebUI.click(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/addToMyList'))
    WebUI.waitForPageLoad(3)

if (!(WebUI.getUrl().contains('/login'))) {
    KeywordUtil.markFailed('URL not match :' + WebUI.getUrl())
}

new Common().tapAtBurgerMenu()
    WebUI.waitForPageLoad(3)
    WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/sportsLink'))
    WebUI.waitForPageLoad(3)
//    WebUI.waitForElementVisible(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/addToMyList'),7)
    WebUI.click(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/addToMyList'))
    WebUI.waitForPageLoad(3)

if (!(WebUI.getUrl().contains('/login'))) {
    KeywordUtil.markFailed('URL not match :' + WebUI.getUrl())
}


WebUI.closeBrowser()

