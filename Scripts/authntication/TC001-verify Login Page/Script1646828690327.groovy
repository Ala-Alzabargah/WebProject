
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject


import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import shahid.Common as Common
import internal.GlobalVariable



new Common().navigateToShahid()
new Common().checkLanguage()
new Common().tapAtBurgerMenu()
WebUI.click(findTestObject('Object Repository/HomeScreen/loginButton'))

WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/shahidAccountTitle'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/personalFileIcon'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/personalFileText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/continueWatchingIcon'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/continueWatchingText'), 3)
WebUI.verifyElementPresent(findTestObject('loginThreeLanguages/myListIcon'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/myListText') , 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/enterUsernameTitleText'), 2)




WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/usernameField'), 2)

new Common().checkLanguage()
WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/loginButton'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/facebookLoginButton'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/googleLoginButton'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/reCAPTCHAText'), 3)


WebUI.closeBrowser()





