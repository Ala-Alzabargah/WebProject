import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import shahid.Common as Common

String firstTime

String secondTime

int firstTimeInSeconds

int secondTimeInSeconds

new Common().navigateToShahid()

WebDriver driver = DriverFactory.getWebDriver()

JavascriptExecutor executor = ((driver) as JavascriptExecutor)

WebElement pauseButton

WebElement bigPlayButton

TestData UsersData = findTestData('Data Files/Users')

lastRow = UsersData.getAllData().size()

for (int i = 1; i <= lastRow; i++) {
    if (!(UsersData.getValue(1, i).equals(GlobalVariable.freeUserForDataFile.toString()))) {
        new Common().login(UsersData.getValue(2, i), UsersData.getValue(3, i))

        new Common().selectUser()

        new Common().checkLanguage()
    }
    
    WebUI.navigateToUrl(GlobalVariable.HLSContentURL)

    if (GlobalVariable.device == GlobalVariable.mobile) {
        bigPlayButton = driver.findElement(By.xpath('//div[contains(@class,"theo-big-play-button")]'))

        executor.executeScript('arguments[0].click();', bigPlayButton)

        WebUI.delay(4)

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
    
 
    pauseButton = driver.findElement(By.xpath('//button[contains(@class,\'play-pause-button\')]'))

    executor = ((driver) as JavascriptExecutor)

    executor.executeScript('arguments[0].click();', pauseButton)

    WebUI.click(findTestObject(('Object Repository/Player/' + GlobalVariable.objLanguage) + '/skipIntro'))

    firstTime = WebUI.getText(findTestObject('Object Repository/Player/currentTime'))

    firstTime = (firstTime.split('Time')[1])

    firstTimeInSeconds = (((firstTime.split(':')[0]).toInteger() * 60) + (firstTime.split(':')[1]).toInteger())

    WebUI.click(findTestObject('Object Repository/Player/forwardIcon'))

    secondTime = WebUI.getText(findTestObject('Object Repository/Player/currentTime'))

    secondTime = (secondTime.split('Time')[1])

    secondTimeInSeconds = (((secondTime.split(':')[0]).toInteger() * 60) + (secondTime.split(':')[1]).toInteger())

    if (secondTimeInSeconds != (firstTimeInSeconds + 10)) {
        KeywordUtil.markFailed((('firstTimeInSeconds > secondTimeInSeconds:' + firstTimeInSeconds) + '  ') + secondTimeInSeconds)
    }
    
    firstTime = WebUI.getText(findTestObject('Object Repository/Player/currentTime'))

    firstTime = (firstTime.split('Time')[1])

    firstTimeInSeconds = (((firstTime.split(':')[0]).toInteger() * 60) + (firstTime.split(':')[1]).toInteger())

    WebUI.click(findTestObject('Object Repository/Player/backwardIcon'))

    secondTime = WebUI.getText(findTestObject('Object Repository/Player/currentTime'))

    secondTime = (secondTime.split('Time')[1])

    secondTimeInSeconds = (((secondTime.split(':')[0]).toInteger() * 60) + (secondTime.split(':')[1]).toInteger())

    if (secondTimeInSeconds != (firstTimeInSeconds - 10)) {
        KeywordUtil.markFailed((('firstTimeInSeconds > secondTimeInSeconds:' + firstTimeInSeconds) + '  ') + secondTimeInSeconds)
    }
}

WebUI.closeBrowser()