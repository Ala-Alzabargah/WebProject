import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.Common


CustomKeywords.'shahid.Common.navigateToShahid'()



CustomKeywords.'shahid.Common.checkLanguage'()
CustomKeywords.'shahid.Common.login'(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
//WebUI.waitForElementPresent(findTestObject('adultDefault'), 10)
//WebUI.click(findTestObject('adultDefault'), FailureHandling.CONTINUE_ON_FAILURE)
new Common().selectUser()
CustomKeywords.'shahid.Common.checkLanguage'()

new Common().tapAtBurgerMenu()
new Common().clickAtMyAccount()

///account settings page
WebUI.waitForElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/accountSettingsDescriptionText'), 2)
WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/changePassword'), 2)
WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/changePersonalInfo'), 2)
WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/devicesManagement'), 2)
WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/parentalControlInterface'), 2)
WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/viewPreviousTransaction'), 2)
WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/specialFeatures'), 2)

//WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/OtherUpgradeOptionsText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/ramadanOfferText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/getSixMonthsRamadanText'), 3)
WebUI.click(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/ramadanOfferButton'))
WebUI.waitForPageLoad(3)
new Common().checkLanguage()

//choose your package page
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/shahidVipTextChooseYourPackagePage'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/sportOnShahidVipText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/ramadanOfferTextChooseYourPackagePage'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/followingAlternativeMethodsText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/otherPaymentMethodsText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/clickHereOtherPaymentMethods'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/otherPaymentMethodsIcon'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/clickHereButtonIfYouHavaVoucherCode'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/ifYouHaveVoucherCode'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/ifYouHaveAvoucherCodeIcon'), 3)



//voucher code page
//invalid voucher
new Common().checkLanguage()
WebUI.click(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/clickHereButtonIfYouHavaVoucherCode'))

WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/redeemYourVoucherTexts'), 3)

WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/voucherCodeMustBe12Text'), 3)
WebUI.setText(findTestObject('Object Repository/voucherTexts/voucherField'), '1MVApdXTXcd3Ks')


WebUI.click(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/activateOfferButton'))
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/toKnowWhereToBuyVouchersInYourCountryText'), 3)
if(WebUI.verifyElementPresent(findTestObject('Object Repository/voucherTexts/theProvidedCopunOrCodeIsInvalidOrExpiredMsg'), 3)) {
	KeywordUtil.markPassed("passed")
}else {
	KeywordUtil.markFailed("failed")
}

WebUI.closeBrowser()
