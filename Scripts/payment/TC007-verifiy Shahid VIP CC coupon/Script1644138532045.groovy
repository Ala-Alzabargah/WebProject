
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
new Common().checkLanguage()
WebDriver driver = DriverFactory.getWebDriver()

new Common().login(GlobalVariable.couponCCAcount, GlobalVariable.couponCCPassword)

new Common().selectUser()
WebUI.delay(2)
new Common().tapAtBurgerMenu()
new Common().clickAtMyAccount()
WebUI.delay(4)


///account settings page
WebUI.waitForElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/accountSettingsDescriptionText'), 2)
WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/changePassword'), 2)
WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/changePersonalInfo'), 2)
WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/devicesManagement'), 2)
WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/parentalControlInterface'), 2)
WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/viewPreviousTransaction'), 2)
WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/specialFeatures'), 2)
WebUI.click(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/viewPackagesButton'))
WebUI.delay(2)

new Common().checkLanguage()


//choose your package page
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/shahidVipTextChooseYourPackagePage'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/sportOnShahidVipText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/imagineTextChooseYourPackagePage'), 3)
WebUI.delay(03)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/followingAlternativeMethodsText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/otherPaymentMethodsText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/clickHereOtherPaymentMethods'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/otherPaymentMethodsIcon'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/clickHereButtonIfYouHavaVoucherCode'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/ifYouHaveVoucherCode'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/ifYouHaveAvoucherCodeIcon'), 3)
new Common().selectPackage(GlobalVariable.VIP)
WebUI.delay(5)



//choose your plan page
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/shahidVIPText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/fullHDtext'), 3)
//WebUI.verifyElementVisible(findTestObject('Object Repository/accountSettings/fullHDtext'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/subscribtionPage/whatchOnTvIcon'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/watchOnTVText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/subscribtionPage/downloadAndWhatchOfflineIcon'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/downloadAndWhatchOfflineText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/creditCardDebitSubscribeButtonMonthy'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/creditCardDebitSubscribeButtonYearly'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/package/creditCardDebitYearlyIcon'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/package/creditCardDebitIcon'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/package/monthyPriceText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/creditDebitMonthyText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/creditDebitYearlyText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/followingAlternativeMethodsText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/otherPaymentMethodsText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/clickHereOtherPaymentMethods'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/otherPaymentMethodsIcon'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/clickHereButtonIfYouHavaVoucherCode'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/ifYouHaveVoucherCode'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/ifYouHaveAvoucherCodeIcon'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/subscribtionFeesText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/seeOtherPackagesText'), 3)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/Settings Screen/Payment Methods/Credit Card/creditCardButton'))



//credit card page 
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/oneStepForUnlimitedEntertainmentT'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/pleaseEnterYourCardDetailsText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/doYouHaveAcouponCode'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/subscribtionDetailsText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/package'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/CCtexts/packageShahidVipText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/subscribtionText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/CCtexts/monthlyText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/totalAmountText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/CCtexts/totalAmountPrice'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/CCtexts/willBeDeductedUponTheCompletionOfTheSignupProcessText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/thisSiteIsProtectedByReCaptcha'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/privacyPolicyText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/termsOfServicesText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/chooseYourPackageText'), 3)



//invalid coupon

WebUI.click(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/doYouHaveAcouponCode'))
WebUI.setText(findTestObject('Object Repository/CCtexts/couponField'), '7654')
WebUI.click(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/activeCouponButton'))
if(WebUI.verifyElementPresent(findTestObject('Object Repository/CCtexts/couponVerificationMessageInvalid'), 3)) {
	KeywordUtil.markPassed("passed")
}else {
	KeywordUtil.markFailed("failed")
}
WebUI.click(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/activateText'))
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/couponVerificationMessageInvalid'), 3)
WebUI.refresh()
WebUI.delay(5)


WebUI.closeBrowser()
