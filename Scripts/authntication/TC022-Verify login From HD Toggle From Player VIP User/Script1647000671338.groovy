import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.Common

new Common().NavigateTo(GlobalVariable.topChefAsset)
WebDriver driver = DriverFactory.getWebDriver()


WebElement adsButton

JavascriptExecutor executor

	WebUI.refresh()
	WebUI.mouseOver(findTestObject('Object Repository/upSelling/HDToggle'))
	WebUI.click(findTestObject('Object Repository/upSelling/HDToggle'))
	new Common().checkLanguage()
	WebUI.waitForElementVisible(findTestObject('Object Repository/HDlogin/' + GlobalVariable.objLanguage + '/LoginButton'), 3)
	WebUI.click(findTestObject('Object Repository/HDlogin/' + GlobalVariable.objLanguage + '/LoginButton'))
	
	WebUI.waitForElementPresent(findTestObject('Object Repository/Login/usernameField'), 5)
			WebUI.setText(findTestObject('Object Repository/Login/usernameField'),GlobalVariable.SubscribedUser)
			WebUI.click(findTestObject('Object Repository/Login/continueButton'))
			WebUI.setText(findTestObject('Object Repository/Login/PasswordField'),GlobalVariable.SubscribedUserPassword)
			WebUI.click(findTestObject('Object Repository/Login/continueButton'))
	
			WebUI.waitForElementPresent(findTestObject('adultDefault'), 10)
			WebUI.click(findTestObject('adultDefault'), FailureHandling.CONTINUE_ON_FAILURE)

	new Common().checkLanguage()
		
		  WebUI.waitForElementNotPresent(findTestObject('Object Repository/upSelling/HDToggle'), 5)
		  WebUI.closeBrowser()



