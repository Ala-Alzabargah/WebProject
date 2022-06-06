import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.testdata.TestData as TestData
import shahid.Common as Common
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

new Common().navigateToShahid()

WebDriver driver = DriverFactory.getWebDriver()

TestData UsersData = findTestData('Data Files/Users')

WebElement pauseButton

JavascriptExecutor executor

lastRow = UsersData.getAllData().size()

for (int i = 1; i <= lastRow; i++) {
	new Common().checkLanguage()
	WebUI.navigateToUrl(GlobalVariable.metadataUrl)
	new Common().checkLanguage()
	WebUI.waitForElementVisible(findTestObject('Object Repository/Player/' + GlobalVariable.objLanguage + '/Login'), 3)
	WebUI.click(findTestObject('Object Repository/Player/' + GlobalVariable.objLanguage + '/Login'))
	WebUI.delay(2)
    new Common().login(UsersData.getValue(2, i), UsersData.getValue(3, i),1)

    WebUI.delay(3)

    new Common().selectUser(0)

    new Common().checkLanguage()

	if (UsersData.getValue(1, i).equals(GlobalVariable.freeUserForDataFile.toString())) {
		WebUI.verifyElementVisible(findTestObject('Object Repository/LandingPages/' + GlobalVariable.objLanguage + '/joinNowbutton'))
	}

    //new Common().logout()
}

WebUI.closeBrowser()