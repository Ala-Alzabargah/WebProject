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
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

new Common().navigateToShahid()

new Common().checkLanguage()

new Common().ScrollUntilElementPresent('Object Repository/LandingPages/' + GlobalVariable.objLanguage + '/vipTagHome')
WebUI.waitForPageLoad(2)
WebUI.verifyElementVisible(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/vipTagHome'), FailureHandling.CONTINUE_ON_FAILURE)

new Common().tapAtBurgerMenu()
WebUI.waitForPageLoad(2)
WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/TVShowsLink'))
WebUI.waitForPageLoad(2)
new Common().ScrollUntilElementPresent('Object Repository/LandingPages/' + GlobalVariable.objLanguage + '/vipTagTvShow')
WebUI.waitForPageLoad(2)
WebUI.verifyElementVisible(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/vipTagTvShow'), FailureHandling.CONTINUE_ON_FAILURE)

new Common().tapAtBurgerMenu()
WebUI.waitForPageLoad(2)
WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/moviesLink'))
WebUI.waitForPageLoad(2)
new Common().ScrollUntilElementPresent('Object Repository/LandingPages/' + GlobalVariable.objLanguage + '/vipMoviesTag')
WebUI.waitForPageLoad(4)
WebUI.verifyElementVisible(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/vipMoviesTag'), FailureHandling.CONTINUE_ON_FAILURE)

new Common().tapAtBurgerMenu()
WebUI.waitForPageLoad(2)
WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/sportsLink'))
new Common().ScrollUntilElementPresent('Object Repository/LandingPages/' + GlobalVariable.objLanguage + '/vipSportTag')
WebUI.waitForPageLoad(2)
WebUI.verifyElementVisible(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/vipSportTag'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementVisible(findTestObject('Object Repository/LandingPages/imagineTag'),FailureHandling.CONTINUE_ON_FAILURE)


	   WebUI.closeBrowser()
	
	


