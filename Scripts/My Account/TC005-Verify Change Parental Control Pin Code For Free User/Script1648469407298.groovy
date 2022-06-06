import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.testdata.TestData as TestData
import shahid.Common
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable as GlobalVariable


String userType

//    new Common().navigateToShahid()
//
//    new Common().checkLanguage()
//
//    new Common().login(GlobalVariable.FreeUser, GlobalVariable.FreeUserPassword)
//
//    new Common().selectUser()
//
//    new Common().tapAtBurgerMenu()
//
//    new Common().clickAtMyAccount()

    WebUI.click(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/parentalControlInterface'))

    WebUI.waitForPageLoad(5)

	String newCode=new Common().setNewPinCode()
    
    WebUI.click(findTestObject('Object Repository/Settings Screen/Parental control interface/SaveButton'))

    if (WebUI.waitForElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Parental control interface/updateDoneMessage'), 
        6)) {
        new Common().updateParentalControlCode(newCode, GlobalVariable.FreeUser)
    }else {
		KeywordUtil.markFailed('update meassage doesn\'t appear')
	}

WebUI.back()
//WebUI.closeBrowser()