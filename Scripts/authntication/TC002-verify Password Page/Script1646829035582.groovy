
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject



import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import shahid.Common as Common
import internal.GlobalVariable



new Common().navigateToShahid()
new Common().checkLanguage()



new Common().tapAtBurgerMenu()
WebUI.click(findTestObject('Object Repository/HomeScreen/loginButton'))

WebUI.setText(findTestObject('Object Repository/LoginScreen/usernameField'), GlobalVariable.SubscribedUser)
WebUI.click(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/loginButton'))


if(WebUI.waitForElementPresent(findTestObject('Object Repository/LoginScreen/Error Messages/EC1002'), 2)){
	WebUI.delay(2)
	
}
WebUI.click(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/continueButton'))
	WebUI.waitForElementPresent(findTestObject('loginThreeLanguages/passwordField'), 3)
	WebUI.verifyElementPresent(findTestObject('loginThreeLanguages/passwordField'), 3)
	WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/searchIcon'), 3)
	WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/shahidLogo'), 3)
 
	WebUI.waitForElementPresent(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/loginText'), 8)
   WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/personalFileIcon'), 3)
   WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/personalFileText'), 3)
   WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/continueWatchingIcon'), 3)
   WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/continueWatchingText'), 3)
   WebUI.verifyElementPresent(findTestObject('loginThreeLanguages/myListIcon'), 3)
   WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/myListText') , 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/enterPasswordTitleText'), 3)


//WebUI.verifyElementAttributeValue(findTestObject('Object Repository/LoginScreen/usernameField'), 'value', GlobalVariable.SubscribedUser, 3)

WebUI.verifyElementPresent(findTestObject('loginThreeLanguages/passwordField'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/loginButton'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/forgetPasswordLink'), 3)
WebUI.click(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/forgetPasswordLink'))
WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/forgetPasswordTitleText'), 3)
WebUI.back()

WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/backButton'), 6)
WebUI.verifyElementPresent(findTestObject('loginThreeLanguages/reCAPTCHAText'), 3)



