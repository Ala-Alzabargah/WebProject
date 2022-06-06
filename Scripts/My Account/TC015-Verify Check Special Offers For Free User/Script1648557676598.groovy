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

//
new Common().checkLanguage()
//
//
//new Common().login(GlobalVariable.FreeUser, GlobalVariable.FreeUserPassword)
//
//new Common().selectUser()
//
//new Common().tapAtBurgerMenu()
//
//new Common().clickAtMyAccount()

WebUI.click(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Account Settings Screen/specialOffers'))

WebUI.waitForElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Special Feature Section/specialOffersTitle'), 
    4)

WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Special Feature Section/noFeatureAvaiableText'), 
    4)

WebUI.verifyElementVisible(findTestObject('Object Repository/Settings Screen/Special Feature Section/noFeatureAvaiableText'))
WebUI.back()
//WebUI.closeBrowser()