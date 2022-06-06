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
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

new Common().navigateToShahid()

WebDriver driver = DriverFactory.getWebDriver()

TestData UsersData = findTestData('Data Files/Users')

def searchValue = 'عروس بيروت'

String showDescriptionFirstSeason

String firstSeasonImage

String showDescriptionSecondSeason

List<String> searchValuesList = GlobalVariable.searchValuesList
String secondSeasonImage


lastRow = UsersData.getAllData().size()

new Common().login(GlobalVariable.SubscribedUser,GlobalVariable.SubscribedUserPassword)
WebUI.delay(1)
WebUI.waitForElementPresent(findTestObject('adultDefault'), 10)
WebUI.delay(1)
WebUI.click(findTestObject('adultDefault'), FailureHandling.CONTINUE_ON_FAILURE)
	new Common().checkLanguage()
	new Common().search(searchValue)
	 WebUI.waitForPageLoad(3)
	WebUI.waitForElementVisible(findTestObject('Object Repository/Show Pages/changeSeasonButton'), 10)
	showDescriptionFirstSeason = WebUI.getText(findTestObject('Object Repository/Show Pages/description'))
	firstSeasonImage = WebUI.getAttribute(findTestObject('Object Repository/Show Pages/heroBannerImage'), 'alt')
	WebUI.click(findTestObject('Object Repository/Show Pages/changeSeasonButton'))
	 WebUI.waitForPageLoad(3)
	WebUI.click(findTestObject('Object Repository/Show Pages/SelectFirstSeason'))

	 WebUI.waitForPageLoad(3)

	showDescriptionSecondSeason = WebUI.getText(findTestObject('Object Repository/Show Pages/description'))

	secondSeasonImage = WebUI.getAttribute(findTestObject('Object Repository/Show Pages/heroBannerImage'), 'alt')

	if (showDescriptionFirstSeason.equals(showDescriptionSecondSeason) || firstSeasonImage.equals(secondSeasonImage)) {
		KeywordUtil.markFailed('The season doesn’t change')
	}
	
	WebUI.closeBrowser()



