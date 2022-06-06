import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject


import org.openqa.selenium.WebDriver

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import shahid.Common as Common
import internal.GlobalVariable


new Common().navigateToShahid()
WebDriver driver = DriverFactory.getWebDriver()
new Common().facebookLogin(GlobalVariable.validFacebookUser, GlobalVariable.validFacebookPassword)
new Common().selectUser()
new Common().logout()
