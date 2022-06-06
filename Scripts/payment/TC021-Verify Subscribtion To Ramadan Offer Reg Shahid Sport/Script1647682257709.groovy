import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.Common


CustomKeywords.'shahid.Common.navigateToShahid'()



CustomKeywords.'shahid.Common.checkLanguage'()
CustomKeywords.'shahid.Common.login'(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
WebUI.waitForElementPresent(findTestObject('adultDefault'), 10)
WebUI.click(findTestObject('adultDefault'), FailureHandling.CONTINUE_ON_FAILURE)
//new Common().selectUser()

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
//ramadan 
//WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/OtherUpgradeOptionsText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/ramadanOfferText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/getSixMonthsRamadanText'), 3)
WebUI.click(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/ramadanOfferButton'))
WebUI.waitForPageLoad(3)
CustomKeywords.'shahid.Common.checkLanguage'()

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

new Common().selectPackage(GlobalVariable.SPORT)
//CustomKeywords.'shahid.Common.selectPackage'(GlobalVariable.VIP)

//upgrade your package page
//WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/sportText'), 3)
//WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/Get12MonthsForThePriceOf6Text'), 3)
//WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/sportOnShahidText'), 3)
//WebUI.verifyElementPresent(findTestObject('upgrdeYourPackagePage/imaginePrice'), 3)
//WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/selectedButton'), 3)
//WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/selectButton'), 3)
//WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/currentSelectedPackText'), 3)
//WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/ramadanOfferTextContinueBar'), 3)
//WebUI.verifyElementPresent(findTestObject('Object Repository/upgrdeYourPackagePage/priceMonthText'), 3)
//WebUI.click(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/continueButton'))
//CustomKeywords.'shahid.Common.checkLanguage'()

//choose your plan page
WebUI.waitForPageLoad(3)
//WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/ramadanOfferRedText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/shahidVIPText'), 3)
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
WebUI.waitForPageLoad(3)
WebUI.click(findTestObject('Object Repository/Settings Screen/Payment Methods/Credit Card/creditCardButton'))

//credit card page
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/oneStepForUnlimitedEntertainmentT'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/pleaseEnterYourCardDetailsText'), 3)
//WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/doYouHaveAcouponCode'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/subscribtionDetailsText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/package'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/subscribtionText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/totalAmountText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/thisSiteIsProtectedByReCaptcha'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/privacyPolicyText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/termsOfServicesText'), 3)
WebUI.closeBrowser()
