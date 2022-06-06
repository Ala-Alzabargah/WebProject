import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject


import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import shahid.Common as Common
import internal.GlobalVariable as GlobalVariable




new Common().navigateToShahid()

WebUI.delay(2)
new Common().checkLanguage()
WebUI.click(findTestObject('Login/loginButton'))

//WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/googleLoginButton'),3)
//Mobile.tapAtPosition(200, 640)
//WebUI.delay(1)
//WebUI.switchToWindowIndex(0)
//WebUI.switchToWindowTitle('تسجيل الدخول - حسابات Google')
//WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/googleLoginButton'))
 
WebUI.setText(findTestObject('Object Repository/LoginScreen/Google/googleUsernameField'), GlobalVariable.validGoogleUser)
WebUI.click(findTestObject('Object Repository/loginThreeLanguages/nextGoogleButton'))







