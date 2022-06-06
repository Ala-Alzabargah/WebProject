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


new Common().navigateToShahid()
WebDriver driver = DriverFactory.getWebDriver()
CustomKeywords.'shahid.Common.login'(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)

WebUI.waitForPageLoad(8)

new Common().selectUser(0)

new Common().checkLanguage()

if (!(WebUI.waitForElementVisible(findTestObject('Object Repository/LandingPages/heroBanner'), 7))) {
	KeywordUtil.markFailedAndStop('couldnt find Hero Banner')
}

new Common().tapAtBurgerMenu()

WebUI.waitForPageLoad(3)

WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/TVShowsLink'))

WebUI.waitForPageLoad(3)

if (!(WebUI.waitForElementVisible(findTestObject('Object Repository/LandingPages/heroBanner'), 7))) {
	KeywordUtil.markFailedAndStop('couldnt find Hero Banner')
}

new Common().tapAtBurgerMenu()

WebUI.waitForPageLoad(3)

WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/moviesLink'))

WebUI.waitForPageLoad(3)

if (!(WebUI.waitForElementVisible(findTestObject('Object Repository/LandingPages/heroBanner'), 7))) {
	KeywordUtil.markFailedAndStop('couldnt find Hero Banner')
}

new Common().tapAtBurgerMenu()

WebUI.waitForPageLoad(3)

WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/sportsLink'))

WebUI.waitForPageLoad(3)

if (!(WebUI.waitForElementVisible(findTestObject('Object Repository/LandingPages/heroBanner'), 7))) {
	KeywordUtil.markFailedAndStop('couldnt find Hero Banner')
}

WebUI.closeBrowser()