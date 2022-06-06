import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.testdata.TestData
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

   WebUI.navigateToUrl(GlobalVariable.metadataUrl)
if (GlobalVariable.device == GlobalVariable.mobile) {
		bigPlayButton = driver.findElement(By.xpath('//div[contains(@class,"theo-big-play-button")]'))

		executor.executeScript('arguments[0].click();', bigPlayButton)

		WebUI.delay(4)

		if (MobileDriverFactory.getDeviceOS() == 'Android') {
			Mobile.tapAtPosition(200, 500)
		} else {
			Mobile.tapAtPosition(200, 200)
		}
	}


    pauseButton = driver.findElement(By.xpath('//button[contains(@class,\'play-pause-button\')]'))

    if (WebUI.waitForElementPresent(findTestObject('Object Repository/Player/adsContainer'),4)) {
        String adCountdown = WebUI.getText(findTestObject('Object Repository/Player/adCountdown'))

        println('*******adCountdown:: ' + adCountdown)

        int adTime = (adCountdown[(-2..-1)]).toInteger()

        WebUI.waitForElementNotVisible(findTestObject('Object Repository/Player/adsContainer'), adTime + 5)
		executor.executeScript('arguments[0].click();', pauseButton)
    } else {
        executor.executeScript('arguments[0].click();', pauseButton)
    }
	
	WebUI.waitForElementPresent(findTestObject('Object Repository/Player/audioButton'), 4)
	WebUI.click(findTestObject('Object Repository/Player/audioButton'))
	WebUI.verifyElementPresent(findTestObject('Object Repository/Player/' + GlobalVariable.objLanguage + '/audio'), 3)
	WebUI.verifyElementPresent(findTestObject('Object Repository/Player/' + GlobalVariable.objLanguage + '/Subtitles'), 3)
	WebUI.verifyElementPresent(findTestObject('Object Repository/Player/' + GlobalVariable.objLanguage + '/subTitleOff'), 3)
	WebUI.verifyElementPresent(findTestObject('Object Repository/Player/' + GlobalVariable.objLanguage + '/subTitleFr'), 3)
	WebUI.verifyElementPresent(findTestObject('Object Repository/Player/' + GlobalVariable.objLanguage + '/subTitleEn'), 3)
	WebUI.verifyElementPresent(findTestObject('Object Repository/Player/' + GlobalVariable.objLanguage + '/subTitleAr'), 3)
	WebUI.verifyElementPresent(findTestObject('Object Repository/Player/' + GlobalVariable.objLanguage + '/audioAr'), 3)
	WebUI.click(findTestObject('Object Repository/Player/CloseAudio'))
	WebUI.delay(2)
	//WebUI.verifyElementPresent(findTestObject('Object Repository/VideoPlaybackScreen/Share Options/facebookButton'), 3)
	

    //new Common().logout()
}

WebUI.closeBrowser()