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

new Common().navigateToShahid()

WebDriver driver = DriverFactory.getWebDriver()

TestData UsersData = findTestData('Data Files/Users')

String firstTime

String secondTime

int firstTimeInSeconds

int secondTimeInSeconds

WebElement pauseButton

JavascriptExecutor executor

  WebUI.navigateToUrl(GlobalVariable.HLSContentURL)

WebUI.delay(3)
if (MobileDriverFactory.getDeviceOS() == 'Android') {
			Mobile.tapAtPosition(200, 500)
		} else if (MobileDriverFactory.getDeviceOS() == 'IOS'){
			Mobile.tapAtPosition(200, 200)
		}
WebUI.delay(3)
WebUI.waitForElementPresent(findTestObject('Object Repository/Player/playAdsButton'), 4)
WebUI.delay(3)
pauseButton = driver.findElement(By.xpath('(//button[contains(@class,"vjs-play-control")])[1]'))

    executor = ((driver) as JavascriptExecutor)
	
    executor.executeScript('arguments[0].click();', pauseButton)
	firstTime = WebUI.getText(findTestObject('Object Repository/Player/countdownTimer'))
	firstTime = firstTime.split("\\) ")[1]
	
	firstTimeInSeconds = (((firstTime.split(':')[0]).toInteger() * 60) + (firstTime.split(':')[1]).toInteger())
	WebUI.delay(3)
	secondTime = WebUI.getText(findTestObject('Object Repository/Player/countdownTimer'))
	
	    secondTime = secondTime.split("\\) ")[1]
	
	    secondTimeInSeconds = (((secondTime.split(':')[0]).toInteger() * 60) + (secondTime.split(':')[1]).toInteger())
	
		    if (secondTimeInSeconds != firstTimeInSeconds) {
		        KeywordUtil.markFailed((('firstTimeInSeconds <> secondTimeInSeconds:' + firstTimeInSeconds) + '  ') + secondTimeInSeconds)
		    }


    new Common().login(UsersData.getValue(2, 1), UsersData.getValue(3,1))

    WebUI.delay(3)

    new Common().selectUser(0)

    new Common().checkLanguage()

    WebUI.navigateToUrl(GlobalVariable.HLSContentURL)

WebUI.delay(3)
if (MobileDriverFactory.getDeviceOS() == 'Android') {
			Mobile.tapAtPosition(200, 500)
		} else if (MobileDriverFactory.getDeviceOS() == 'IOS'){
			Mobile.tapAtPosition(200, 200)
		}
WebUI.delay(3)
WebUI.waitForElementPresent(findTestObject('Object Repository/Player/playAdsButton'), 4)
WebUI.delay(3)
pauseButton = driver.findElement(By.xpath('(//button[contains(@class,"vjs-play-control")])[1]'))
	
    executor.executeScript('arguments[0].click();', pauseButton)
	firstTime = WebUI.getText(findTestObject('Object Repository/Player/countdownTimer'))
	firstTime = firstTime.split("\\) ")[1]
	
	firstTimeInSeconds = (((firstTime.split(':')[0]).toInteger() * 60) + (firstTime.split(':')[1]).toInteger())
	WebUI.delay(3)
	secondTime = WebUI.getText(findTestObject('Object Repository/Player/countdownTimer'))
	
	    secondTime = secondTime.split("\\) ")[1]
	
	    secondTimeInSeconds = (((secondTime.split(':')[0]).toInteger() * 60) + (secondTime.split(':')[1]).toInteger())
	
		    if (secondTimeInSeconds != firstTimeInSeconds) {
		        KeywordUtil.markFailed((('firstTimeInSeconds <> secondTimeInSeconds:' + firstTimeInSeconds) + '  ') + secondTimeInSeconds)
		    }
    //new Common().logout()


WebUI.closeBrowser()