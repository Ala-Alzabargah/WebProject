
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import shahid.Common as Common
import internal.GlobalVariable




TestData UsersData = findTestData('Data Files/users')

UsersData.getAllData().size()
new Common().navigateToShahid()
WebUI.delay(2)
WebDriver driver = DriverFactory.getWebDriver()
new Common().checkLanguage()

int i = 3
new Common().login(UsersData.getValue(2, i), UsersData.getValue(3, i))

new Common().selectUser()
WebUI.delay(2)
new Common().tapAtBurgerMenu()
new Common().clickAtMyAccount()
WebUI.delay(4)



///account settings page
new Common().checkLanguage()
WebUI.waitForElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/accountSettingsDescriptionText'), 2)
WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/changePassword'), 2)
WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/changePersonalInfo'), 2)
WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/devicesManagement'), 2)
WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/parentalControlInterface'), 2)
WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/viewPreviousTransaction'), 2)
WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/specialFeatures'), 2)
WebUI.click(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/viewPlans'))
WebUI.delay(2)


//voucher code page
//invalid voucher

String stackvoucher = new Common().getVochersData(GlobalVariable.voucherOneM)

WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/upgradeYourPackageTextVIPPage'), 3)

WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/unlimitedEntertainmentT'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/enterYourVoucherCodeToUpgradeText'), 3)

WebUI.verifyElementPresent(findTestObject('Object Repository/voucherPageForVIPUsers/currentPackageShahidVIPText'), 3)
WebUI.setText(findTestObject('Object Repository/voucherPageForVIPUsers/enterVoucherCodeForVIP'),stackvoucher )

WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/voucherCodeMustBe12CharacterTextUpgradePage'), 3)
WebUI.click(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/activateOfferButtonUpgradePage'))
WebUI.delay(2)
if(WebUI.verifyElementPresent(findTestObject('Object Repository/voucherPageForVIPUsers/theProvidedCodeCantBeActivatedText'), 3)) {
	KeywordUtil.markFailed("failed")
}else {
	KeywordUtil.markPassed("passed")
}

WebUI.closeBrowser()

