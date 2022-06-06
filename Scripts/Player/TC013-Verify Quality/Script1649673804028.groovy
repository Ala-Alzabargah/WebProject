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

//  WebUI.navigateToUrl(GlobalVariable.HLSContentURL)
//  new Common().checkLanguage()
//if (WebUI.waitForElementVisible(findTestObject('Object Repository/Player/FirstPlayButton'), 4)) {
//    WebUI.click(findTestObject('Object Repository/Player/FirstPlayButton'))
//}
//
//WebUI.delay(6)
//
//Mobile.tapAtPosition(200, 200)
//
//    pauseButton = driver.findElement(By.xpath('//button[contains(@class,\'play-pause-button\')]'))
//
//    executor = ((driver) as JavascriptExecutor)
//
//    executor.executeScript('arguments[0].click();', pauseButton)
//	
//	WebUI.waitForElementPresent(findTestObject('Object Repository/Player/qualityButton'), 4)
//	WebUI.click(findTestObject('Object Repository/Player/qualityButton'))
//	WebUI.delay(2)
//	WebUI.verifyElementPresent(findTestObject('Object Repository/Player/' + GlobalVariable.objLanguage + '/contentQuality'), 3)
//	WebUI.verifyElementPresent(findTestObject('Object Repository/Player/' + GlobalVariable.objLanguage + '/automaticLabel'), 3)
//	WebUI.verifyElementPresent(findTestObject('Object Repository/VideoPlaybackScreen/Content Quality/quality1080'), 3)
//	WebUI.verifyElementPresent(findTestObject('Object Repository/VideoPlaybackScreen/Content Quality/quality360'), 3)
//	WebUI.verifyElementPresent(findTestObject('Object Repository/VideoPlaybackScreen/Content Quality/quality720'), 3)
//	
//	WebUI.click(findTestObject('Object Repository/Player/closeQuality'))

lastRow = UsersData.getAllData().size()

for (int i = 2; i <= lastRow; i++) {
    new Common().login(UsersData.getValue(2, i), UsersData.getValue(3, i))

    WebUI.delay(3)

    new Common().selectUser(0)

    new Common().checkLanguage()

   WebUI.navigateToUrl(GlobalVariable.HLSContentURL)
  new Common().checkLanguage()
if (WebUI.waitForElementVisible(findTestObject('Object Repository/Player/FirstPlayButton'), 4)) {
    WebUI.click(findTestObject('Object Repository/Player/FirstPlayButton'))
}

WebUI.delay(6)

Mobile.tapAtPosition(200, 200)

    pauseButton = driver.findElement(By.xpath('//button[contains(@class,\'play-pause-button\')]'))

    executor = ((driver) as JavascriptExecutor)

    executor.executeScript('arguments[0].click();', pauseButton)
	
	WebUI.waitForElementPresent(findTestObject('Object Repository/Player/qualityButton'), 4)
	WebUI.click(findTestObject('Object Repository/Player/qualityButton'))
	WebUI.delay(2)
	WebUI.verifyElementPresent(findTestObject('Object Repository/Player/' + GlobalVariable.objLanguage + '/contentQuality'), 3)
	WebUI.verifyElementPresent(findTestObject('Object Repository/Player/' + GlobalVariable.objLanguage + '/automaticLabel'), 3)
	WebUI.verifyElementPresent(findTestObject('Object Repository/VideoPlaybackScreen/Content Quality/quality1080'), 3)
	WebUI.verifyElementPresent(findTestObject('Object Repository/VideoPlaybackScreen/Content Quality/quality360'), 3)
	WebUI.verifyElementPresent(findTestObject('Object Repository/VideoPlaybackScreen/Content Quality/quality720'), 3)
	
	WebUI.click(findTestObject('Object Repository/Player/closeQuality'))

    //new Common().logout()
}

WebUI.closeBrowser()