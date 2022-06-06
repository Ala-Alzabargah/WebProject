import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject


import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import shahid.Common as Common
import internal.GlobalVariable



new Common().navigateToShahid()
new Common().checkLanguage()

new Common().tapAtBurgerMenu()
WebUI.click(findTestObject('Object Repository/HomeScreen/loginButton'))

WebUI.setText(findTestObject('Object Repository/LoginScreen/usernameField'), 'alaa@alaa')
Boolean emailvalidation=new Common().isEmailValid('alaa@alaa')
if(emailvalidation) {
	
	WebUI.click(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/loginButton'))
	String PageUrl=WebUI.getUrl()
	PageUrl.contains('shahid.net/ar/widgets/registration')
	WebUI.verifyElementText(findTestObject('Object Repository/Registration Page/createShahidAccountTitleText'), 'إنشاء حساب SHAHID')

}else {
	WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/invalidEmailMsg'), 3)
}
WebUI.closeBrowser()



