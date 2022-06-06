import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import javax.wsdl.Import as Import
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable
import shahid.Common as Common

new Common().navigateToShahid()

new Common().checkLanguage()

new Common().login(GlobalVariable.UltimateUser, GlobalVariable.UltimateUserPassword)

new Common().selectUser()

new Common().clickAtMyAccount()

WebUI.click(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/subscriptionsManagement'))

new Common().swipe(1000)

WebUI.verifyElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/switchPackageButton'), 
    2)

WebUI.verifyElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/switchPackageIconButton'), 
    2)

WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Subscriptions Management/subscriptionInfoMainTitle'), 
    4)

WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Subscriptions Management/subscriptionStatus'), 
    2)

WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Subscriptions Management/deductionDateText'), 
    2)

WebUI.verifyElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/planText'), 
    2)

WebUI.verifyElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/otherUtilities'), 
    2)

if (WebUI.waitForElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/offerNameText'), 
    30)) {
    WebUI.verifyElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/plan'), 
        2)

    WebUI.verifyElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/package'), 
        2)

    WebUI.verifyElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/offerName'), 
        2)

    WebUI.verifyElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/voucherCodeButton'), 
        3)
} else if (WebUI.waitForElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/cardNumber'), 
    3)) {
    WebUI.verifyElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/planCardNumber'), 
        2)

    WebUI.verifyElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/packageCardNumber'), 
        2)

    WebUI.verifyElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/planCardNumber'), 
        2)

    WebUI.verifyElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/cardNumberText'), 
        2)

    WebUI.verifyElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/expiryDateText'), 
        2)

    WebUI.verifyElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/expiryDate'), 
        2)

    WebUI.verifyElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/visaLogo'), 
        2)

    WebUI.click(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/updateButton'))

    WebUI.back()

    WebUI.click(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/viewTransactionHistoryButton'))

    WebUI.back()

    WebUI.click(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/couponCodebutton'))

    WebUI.verifyElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/couponText'), 
        2)

    WebUI.back()

    WebUI.verifyElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/cancelYourSubscribtionButton'), 
        2)

    WebUI.delay(3)
}

WebUI.click(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/doYouNeedHelpWithYourSubscribtionButton'))

new Common().swipe(600)

WebUI.verifyElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/callTheFollowingNumbers'), 
    2)

WebUI.verifyElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/saudiArabia'), 
    2)

WebUI.verifyElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/aeu'), 
    2)

WebUI.verifyElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/hkj'), 
    2)

WebUI.verifyElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/internationalNumber'), 
    2)

WebUI.verifyElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/saudiArabiaNumber'), 
    2)

WebUI.verifyElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/uaeNumber'), 
    2)

WebUI.verifyElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/hkjNumber'), 
    2)

WebUI.verifyElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/internationalNumberDigits'), 
    2)

WebUI.verifyElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/returnToThePreviosStep'), 
    2)

WebUI.verifyElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/returnToPreviousStepicon'), 
    2)

WebUI.closeBrowser()