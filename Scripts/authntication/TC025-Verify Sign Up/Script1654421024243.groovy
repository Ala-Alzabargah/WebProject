import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.commons.lang.RandomStringUtils

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.Common as Common

new Common().navigateToShahid()
String email = (RandomStringUtils.random(10, true, true) + '@automationtest.com').toUpperCase()
new Common().shahidSignup(email, GlobalVariable.newPassword)
new Common().selectUser()

WebUI.delay(3)

WebUI.getUrl().contains('/home')

WebUI.closeBrowser()