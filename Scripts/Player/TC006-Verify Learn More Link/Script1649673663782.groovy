import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.Common

new Common().navigateToShahid()
println "MobileDriverFactory.getDeviceOS()::   "+MobileDriverFactory.getDeviceOS()
WebDriver driver = DriverFactory.getWebDriver()

JavascriptExecutor executor = ((driver) as JavascriptExecutor)

WebElement pauseButton

WebElement bigPlayButton

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
	
	
	if (WebUI.waitForElementPresent(findTestObject('Object Repository/Player/adsContainer'),3)) {
		String adCountdown = WebUI.getText(findTestObject('Object Repository/Player/adCountdown'))

		println('*******adCountdown:: ' + adCountdown)

		int adTime = (adCountdown[(-2..-1)]).toInteger()

		WebUI.waitForElementNotVisible(findTestObject('Object Repository/Player/adsContainer'), adTime + 5)
			executor.executeScript('arguments[0].click();', pauseButton)
	} else {
		executor.executeScript('arguments[0].click();', pauseButton)
	}
	
WebUI.waitForElementPresent(findTestObject('Object Repository/Player/LearnMoreLabel'), 6)

WebUI.click(findTestObject('Player/LearnMoreLabel'))

