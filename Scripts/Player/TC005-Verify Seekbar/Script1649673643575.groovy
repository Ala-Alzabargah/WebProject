import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.Common 

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
		} else if (MobileDriverFactory.getDeviceOS() == 'IOS'){
			Mobile.tapAtPosition(200, 200)
		}
	}
    
if (MobileDriverFactory.getDeviceOS() == 'Android') {
			Mobile.tapAtPosition(200, 500)
		} else if (MobileDriverFactory.getDeviceOS() == 'iOS') {
			Mobile.tapAtPosition(200, 200)
		}

   pauseButton = driver.findElement(By.xpath('//button[contains(@class,\'play-pause-button\')]'))

    if (WebUI.waitForElementPresent(findTestObject('Object Repository/Player/adsContainer'),3)) {
        String adCountdown = WebUI.getText(findTestObject('Object Repository/Player/adCountdown'))

        println('*******adCountdown:: ' + adCountdown)

        int adTime = (adCountdown[(-2..-1)]).toInteger()

        WebUI.waitForElementNotVisible(findTestObject('Object Repository/Player/adsContainer'), adTime + 5)
			executor.executeScript('arguments[0].click();', pauseButton)
    } else {
        executor.executeScript('arguments[0].click();', pauseButton)
    }

	if (WebUI.waitForElementPresent(findTestObject(('Object Repository/Player/' + GlobalVariable.objLanguage) + '/skipIntro'), 6)) {
		WebUI.waitForElementNotPresent(findTestObject(('Object Repository/Player/' + GlobalVariable.objLanguage) + '/skipIntro'), 7)
	}


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
    } //new Common().logout()
}

WebUI.closeBrowser()