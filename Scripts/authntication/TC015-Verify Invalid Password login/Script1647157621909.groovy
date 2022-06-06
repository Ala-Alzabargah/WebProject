import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject


import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import shahid.Common as Common
import internal.GlobalVariable


new Common().navigateToShahid()
WebUI.delay(2)

new Common().checkLanguage()



new Common().tapAtBurgerMenu()
WebUI.click(findTestObject('Object Repository/HomeScreen/loginButton'))

WebUI.setText(findTestObject('Object Repository/LoginScreen/usernameField'), GlobalVariable.TeamUser)

	WebUI.click(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/continueButton'))
	
 WebUI.setText(findTestObject('Object Repository/Login/PasswordField'), '7658678')
 WebUI.click(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/loginButton'))
 WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/invalidUsername'), 3)
 
WebUI.closeBrowser()
