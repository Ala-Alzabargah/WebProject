import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import shahid.Common as Common
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import org.apache.commons.lang3.*
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
new Common().navigateToShahid()

WebUI.delay(2)

new Common().checkLanguage()

new Common().tapAtBurgerMenu()

WebUI.click(findTestObject('Object Repository/HomeScreen/loginButton'))

WebUI.setText(findTestObject('Object Repository/LoginScreen/usernameField'), GlobalVariable.SubscribedGmail)

WebUI.click(findTestObject(('Object Repository/loginThreeLanguages/' + GlobalVariable.objLanguage) + '/continueButton'))

WebUI.delay(1)

WebUI.click(findTestObject(('Object Repository/loginThreeLanguages/' + GlobalVariable.objLanguage) + '/forgetPasswordLink'))

WebUI.waitForElementPresent(findTestObject(('Object Repository/loginThreeLanguages/' + GlobalVariable.objLanguage) + '/forgetPasswordTitleText'), 
    6)

WebUI.verifyElementPresent(findTestObject(('Object Repository/loginThreeLanguages/' + GlobalVariable.objLanguage) + '/forgetPasswordDescription'), 
    3)

WebUI.setText(findTestObject('Object Repository/LoginScreen/forgetPassword/Email'), GlobalVariable.SubscribedGmail)

WebUI.click(findTestObject('Object Repository/LoginScreen/forgetPassword/ResetPasswordButton'))

if (WebUI.waitForElementPresent(findTestObject(('Object Repository/loginThreeLanguages/' + GlobalVariable.objLanguage) + 
        '/EmailSentSuccessfully'), 6)) {
    WebUI.verifyElementPresent(findTestObject(('Object Repository/loginThreeLanguages/' + GlobalVariable.objLanguage) + 
            '/EmailSentSuccessfully'), 6)

    WebUI.verifyElementPresent(findTestObject(('Object Repository/loginThreeLanguages/' + GlobalVariable.objLanguage) + 
            '/ContinueLoginButton'), 6)

    WebUI.verifyElementPresent(findTestObject(('Object Repository/loginThreeLanguages/' + GlobalVariable.objLanguage) + 
            '/SendLinkAgainButton'), 6)
	

	String email =CustomKeywords.'com.testwithhari.katalon.plugins.Gmail.readLatestEMailBodyContent'(GlobalVariable.SubscribedGmail, GlobalVariable.SubscribedGmailPassword, 'Inbox')
	
	String subEmail= StringUtils.substringAfterLast(email, 'https://')
	println "********subEmail:: "+subEmail
	
	String restPasswordUrl=StringUtils.substringBeforeLast(subEmail, '.sc3')
	println "********restPasswordUrl:: "+restPasswordUrl
	WebUI.navigateToUrl(restPasswordUrl+'.sc3')
	
	WebUI.setText(findTestObject('Object Repository/LoginScreen/forgetPassword/newPassword'), GlobalVariable.NewUserPassword)
	WebUI.setText(findTestObject('Object Repository/LoginScreen/forgetPassword/newPasswordRetype'), GlobalVariable.NewUserPassword)
	WebUI.click(findTestObject('Object Repository/LoginScreen/forgetPassword/changePasswordButton'))
	WebUI.verifyElementVisible(findTestObject('Object Repository/LoginScreen/forgetPassword/Password updated successfully'))
} else {
    WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/forgetPassword/SpinnerIcon'), 6)
}