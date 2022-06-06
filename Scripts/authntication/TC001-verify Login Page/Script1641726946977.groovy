import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import shahid.Common as Common
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

//
new Common().navigateToShahid()

new Common().checkLanguage()

new Common().tapAtBurgerMenu()

WebUI.click(findTestObject('Object Repository/HomeScreen/loginButton'))

WebUI.verifyElementPresent(findTestObject(('Object Repository/loginThreeLanguages/' + GlobalVariable.objLanguage) + '/shahidAccountTitle'), 
    3)

WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/personalFileIcon'), 3)

WebUI.verifyElementPresent(findTestObject(('Object Repository/loginThreeLanguages/' + GlobalVariable.objLanguage) + '/personalFileText'), 
    3)

WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/continueWatchingIcon'), 3)

WebUI.verifyElementPresent(findTestObject(('Object Repository/loginThreeLanguages/' + GlobalVariable.objLanguage) + '/continueWatchingText'), 
    3)

WebUI.verifyElementPresent(findTestObject('loginThreeLanguages/myListIcon'), 3)

WebUI.verifyElementPresent(findTestObject(('Object Repository/loginThreeLanguages/' + GlobalVariable.objLanguage) + '/myListText'), 
    3)

WebUI.verifyElementPresent(findTestObject(('Object Repository/loginThreeLanguages/' + GlobalVariable.objLanguage) + '/enterUsernameTitleText'), 
    2)

WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/usernameField'), 2)

new Common().checkLanguage()

WebUI.verifyElementPresent(findTestObject(('Object Repository/loginThreeLanguages/' + GlobalVariable.objLanguage) + '/loginButton'), 
    2)

WebUI.verifyElementPresent(findTestObject(('Object Repository/loginThreeLanguages/' + GlobalVariable.objLanguage) + '/facebookLoginButton'), 
    2)

WebUI.verifyElementPresent(findTestObject(('Object Repository/loginThreeLanguages/' + GlobalVariable.objLanguage) + '/googleLoginButton'), 
    2)

WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/reCAPTCHAText'), 3)

WebUI.closeBrowser()


