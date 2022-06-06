import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.github.javafaker.Faker as Faker
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import shahid.Common as Common
import internal.GlobalVariable as GlobalVariable

//new Common().navigateToShahid()

new Common().checkLanguage()

String password = GlobalVariable.FreeUserPassword

//new Common().login(GlobalVariable.FreeUser, password)
//
//new Common().selectUser()
//
//new Common().tapAtBurgerMenu()
//
//new Common().clickAtMyAccount()

WebUI.click(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/changePassword'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Change Password Section/changePasswordDescriptionText'), 
    2)

WebUI.setText(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Change Password Section/currentPassword'), 
    password)

WebUI.setText(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Change Password Section/newPassword'), 
    '123456=')

WebUI.setText(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Change Password Section/confirmNewPassword'), 
    '654321')

WebUI.delay(1)

WebUI.verifyElementVisible(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Change Password Section/passwordNotMatchedErrorMessage'))
WebUI.back()
//WebUI.closeBrowser()