import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.Common as Common

new Common().navigateToShahid()


	WebUI.waitForElementVisible(findTestObject('Object Repository/Show Pages/heroBanner'), 10)
	WebUI.verifyElementPresent(findTestObject('Object Repository/Show Pages/heroBanner'), 2)

WebUI.closeBrowser()

