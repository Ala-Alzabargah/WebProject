
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.Common





new Common().navigateToShahid()
new Common().checkLanguage()

new Common().tapAtBurgerMenu()
WebUI.click(findTestObject('Object Repository/HomeScreen/loginButton'))



WebUI.setText(findTestObject('Object Repository/LoginScreen/usernameField'), '2345665')
Boolean emailvalidation=new Common().isEmailValid('alaa@alaa')
if(emailvalidation) {
	
	WebUI.click(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/loginButton'))
	String PageUrl=WebUI.getUrl()
	PageUrl.contains('shahid.net/ar/widgets/registration')
	WebUI.verifyElementText(findTestObject('Object Repository/Registration Page/createShahidAccountTitleText'), 'إنشاء حساب SHAHID')

}else {
	WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/invalidPhoneNumberMsg'), 3)
}

WebUI.closeBrowser()
