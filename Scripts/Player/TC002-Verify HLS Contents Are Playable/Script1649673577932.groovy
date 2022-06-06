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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
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

String firstTime

String secondTime

int firstTimeInSeconds

int secondTimeInSeconds

WebElement pauseButton

WebElement bigPlayButton


JavascriptExecutor executor = ((driver) as JavascriptExecutor)

lastRow = UsersData.getAllData().size()

for (int i = 1; i <= lastRow; i++) {
    if (!(UsersData.getValue(1, i).equals(GlobalVariable.freeUserForDataFile.toString()))) {
        new Common().login(UsersData.getValue(2, i), UsersData.getValue(3, i))

        new Common().selectUser()

        new Common().checkLanguage()
    }
    
    WebUI.navigateToUrl(GlobalVariable.HLSContentURL)

    WebUI.delay(4)


    if (GlobalVariable.device == GlobalVariable.mobile) {
		bigPlayButton = driver.findElement(By.xpath('//div[contains(@class,"theo-big-play-button")]'))
        executor.executeScript('arguments[0].click();', bigPlayButton)

        WebUI.delay(4)

        println('MobileDriverFactory.getDeviceOS():: ' + MobileDriverFactory.getDeviceOS())

        if (MobileDriverFactory.getDeviceOS() == 'Android') {
            Mobile.tapAtPosition(200, 500)
        } else if (MobileDriverFactory.getDeviceOS() == 'iOS'){
			Mobile.tapAtPosition(200, 200)
		}
    }
	pauseButton = driver.findElement(By.xpath('//button[contains(@class,\'play-pause-button\')]'))
    if (WebUI.verifyElementVisible(findTestObject('Object Repository/Player/adsContainer'))) {
        String adCountdown = WebUI.getText(findTestObject('Object Repository/Player/adCountdown'))

        println('*******adCountdown:: ' + adCountdown)

        int adTime = (adCountdown[(-2..-1)]).toInteger()

        WebUI.waitForElementNotVisible(findTestObject('Object Repository/Player/adsContainer'), adTime + 5)
    } else {
        executor.executeScript('arguments[0].click();', pauseButton)
    }
    
    executor.executeScript('arguments[0].click();', pauseButton)

    if (UsersData.getValue(1, i).equals(GlobalVariable.freeUserForDataFile.toString())) {
        WebUI.verifyElementPresent(findTestObject('Object Repository/upSelling/HDToggle'), 3)

        WebUI.verifyElementPresent(findTestObject('Object Repository/upSelling/noAds'), 3)
    }
    
    firstTime = WebUI.getText(findTestObject('Object Repository/Player/currentTime'))

    firstTime = (firstTime.split('Time')[1])

    firstTimeInSeconds = (((firstTime.split(':')[0]).toInteger() * 60) + (firstTime.split(':')[1]).toInteger())

    WebUI.click(findTestObject('Object Repository/Player/forwardIcon'))

    WebUI.delay(2)

    WebUI.click(findTestObject('Object Repository/Player/forwardIcon'))

    executor.executeScript('arguments[0].click();', pauseButton)

    WebUI.delay(5)

    executor.executeScript('arguments[0].click();', pauseButton)

    secondTime = WebUI.getText(findTestObject('Object Repository/Player/currentTime'))

    secondTime = (secondTime.split('Time')[1])

    secondTimeInSeconds = (((secondTime.split(':')[0]).toInteger() * 60) + (secondTime.split(':')[1]).toInteger())

    if (secondTimeInSeconds <= firstTimeInSeconds) {
        KeywordUtil.markFailed((('firstTimeInSeconds > secondTimeInSeconds:' + firstTimeInSeconds) + '  ') + secondTimeInSeconds)
    }
}

WebUI.closeBrowser()