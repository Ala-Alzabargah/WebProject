import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.text.SimpleDateFormat as SimpleDateFormat
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field.Xpath as Xpath
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.interactions.Actions as Actions
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import cucumber.api.java.en.Given as Given
import internal.GlobalVariable as GlobalVariable
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.testdata.TestData as TestData
import shahid.Common as Common
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling

new Common().navigateToShahid()


new Common().checkLanguage()
WebUI.waitForElementPresent(findTestObject('Object Repository/LandingPages/heroBanner'), 30)
WebUI.verifyElementVisible(findTestObject('Object Repository/LandingPages/heroBannerSwip'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.waitForPageLoad(12)
WebUI.verifyElementNotVisible(findTestObject('Object Repository/LandingPages/heroBannerSwip'), FailureHandling.CONTINUE_ON_FAILURE)

new Common().tapAtBurgerMenu()
WebUI.waitForPageLoad(2)
WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/TVShowsLink'))
WebUI.waitForPageLoad(2)
WebUI.waitForElementPresent(findTestObject('Object Repository/LandingPages/heroBanner'), 30)
WebUI.verifyElementVisible(findTestObject('Object Repository/LandingPages/heroBannerSwip'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.waitForPageLoad(12)
WebUI.verifyElementNotVisible(findTestObject('Object Repository/LandingPages/heroBannerSwip'), FailureHandling.CONTINUE_ON_FAILURE)

new Common().tapAtBurgerMenu()
WebUI.waitForPageLoad(2)
WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/moviesLink'))
WebUI.waitForPageLoad(2)
WebUI.waitForElementPresent(findTestObject('Object Repository/LandingPages/heroBanner'), 30)
WebUI.verifyElementVisible(findTestObject('Object Repository/LandingPages/heroBannerSwip'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.waitForPageLoad(12)
WebUI.verifyElementNotVisible(findTestObject('Object Repository/LandingPages/heroBannerSwip'), FailureHandling.CONTINUE_ON_FAILURE)

new Common().tapAtBurgerMenu()
WebUI.waitForPageLoad(2)
WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/sportsLink'))
WebUI.waitForPageLoad(2)
WebUI.waitForElementPresent(findTestObject('Object Repository/LandingPages/heroBanner'), 30)
WebUI.verifyElementVisible(findTestObject('Object Repository/LandingPages/heroBannerSwip'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.waitForPageLoad(12)
WebUI.verifyElementNotVisible(findTestObject('Object Repository/LandingPages/heroBannerSwip'), FailureHandling.CONTINUE_ON_FAILURE)




   CustomKeywords.'shahid.Common.login'(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
   WebUI.waitForElementPresent(findTestObject('adultDefault'), 10)
   WebUI.delay(2)
   WebUI.click(findTestObject('adultDefault'), FailureHandling.CONTINUE_ON_FAILURE)
   WebUI.delay(2)
   CustomKeywords.'shahid.Common.checkLanguage'()
    WebUI.waitForElementPresent(findTestObject('Object Repository/LandingPages/heroBanner'), 30)
    WebUI.verifyElementVisible(findTestObject('Object Repository/LandingPages/heroBannerSwip'), FailureHandling.CONTINUE_ON_FAILURE)
    WebUI.waitForPageLoad(12)
    WebUI.verifyElementNotVisible(findTestObject('Object Repository/LandingPages/heroBannerSwip'), FailureHandling.CONTINUE_ON_FAILURE)

    new Common().tapAtBurgerMenu()
    WebUI.waitForPageLoad(2)
    WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/TVShowsLink'))
    WebUI.waitForPageLoad(2)
    WebUI.waitForElementPresent(findTestObject('Object Repository/LandingPages/heroBanner'), 30)
    WebUI.verifyElementVisible(findTestObject('Object Repository/LandingPages/heroBannerSwip'), FailureHandling.CONTINUE_ON_FAILURE)
    WebUI.waitForPageLoad(12)
    WebUI.verifyElementNotVisible(findTestObject('Object Repository/LandingPages/heroBannerSwip'), FailureHandling.CONTINUE_ON_FAILURE)

    new Common().tapAtBurgerMenu()
    WebUI.waitForPageLoad(2)
    WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/moviesLink'))
    WebUI.delay(3)
    WebUI.waitForElementPresent(findTestObject('Object Repository/LandingPages/heroBanner'), 30)
    WebUI.verifyElementVisible(findTestObject('Object Repository/LandingPages/heroBannerSwip'), FailureHandling.CONTINUE_ON_FAILURE)
    WebUI.waitForPageLoad(12)
    WebUI.verifyElementNotVisible(findTestObject('Object Repository/LandingPages/heroBannerSwip'), FailureHandling.CONTINUE_ON_FAILURE)

    new Common().tapAtBurgerMenu()
    WebUI.waitForPageLoad(2)
    WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/sportsLink'))
    WebUI.waitForPageLoad(2)
    WebUI.waitForElementPresent(findTestObject('Object Repository/LandingPages/heroBanner'), 30)
    WebUI.verifyElementVisible(findTestObject('Object Repository/LandingPages/heroBannerSwip'), FailureHandling.CONTINUE_ON_FAILURE)
    WebUI.waitForPageLoad(12)
    WebUI.verifyElementNotVisible(findTestObject('Object Repository/LandingPages/heroBannerSwip'), FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.closeBrowser()


