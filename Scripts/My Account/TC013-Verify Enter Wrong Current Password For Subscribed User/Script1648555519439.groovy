import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.Common
//
//    new Common().navigateToShahid()
//
//    new Common().checkLanguage()

    String password = GlobalVariable.UltimateUserPassword

//    new Common().login(GlobalVariable.UltimateUser, password)
//
//    new Common().selectUser()
//
//    new Common().tapAtBurgerMenu()
//
//    new Common().clickAtMyAccount()

    WebUI.click(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/changePassword'))

    WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Change Password Section/changePasswordDescriptionText'), 
        2)

    WebUI.setText(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Change Password Section/currentPassword'), 
        'wrongpassword')

    WebUI.setText(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Change Password Section/newPassword'), 
        '654321')

    WebUI.setText(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Change Password Section/confirmNewPassword'), 
        '654321')

    WebUI.delay(1)

    WebUI.click(findTestObject('Object Repository/Settings Screen/Change Password Section/saveButton'))

    WebUI.delay(2)

    WebUI.verifyElementVisible(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Change Password Section/wrongPasswordErrorMessage'))

WebUI.back()
//WebUI.closeBrowser()