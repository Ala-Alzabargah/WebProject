
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData


import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.Common





new Common().navigateToShahid()
WebUI.delay(2)
WebDriver driver = DriverFactory.getWebDriver()
new Common().checkLanguage()

new Common().login(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)

new Common().selectUser()
WebUI.delay(2)
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
WebUI.click(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/viewPackagesButton'))
WebUI.delay(2)

new Common().checkLanguage()

//choose your package page
WebUI.delay(2)
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


new Common().selectPackage(GlobalVariable.SPORT)

//upgrade your package page
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/sportText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/noCommitmentCancelAnyTimeText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/sportOnShahidText'), 3)
WebUI.verifyElementPresent(findTestObject('upgrdeYourPackagePage/imaginePrice'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/selectedButton'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/selectButton'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/currentSelectedPackText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/startingFrom1Text'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/startingFrom2Text'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/startingFromtextContinueBar'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/upgrdeYourPackagePage/priceMonthText'), 3)
WebUI.click(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/continueButton'))
new Common().checkLanguage()

//choose your plan page
WebUI.delay(3)
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
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/subscribtionText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/totalAmountText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/thisSiteIsProtectedByReCaptcha'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/privacyPolicyText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/termsOfServicesText'), 3)




//WebUI.waitForPageLoad(6)
//WebUI.delay(2)
//
//WebUI.switchToFrame(findTestObject('creditCardFrams/cardFrame'), 3)
//WebUI.setText(findTestObject('Object Repository/Settings Screen/Payment Methods/Credit Card/cardNumberFiled'), '4543474002249996')
//Mobile.tapAtPosition(200, 600)
//WebUI.delay(3)
//WebUI.switchToDefaultContent()
//WebUI.waitForPageLoad(6)
//WebUI.switchToFrame(findTestObject('Object Repository/creditCardFrams/expiryDateFrame'), 3)
//WebUI.delay(2)
//WebUI.setText(findTestObject('Object Repository/CCtexts/expiryDate'), '1225')
//WebUI.switchToDefaultContent()
//WebUI.waitForPageLoad(6)
//WebUI.switchToFrame(findTestObject('Object Repository/creditCardFrams/cvvFrame'), 3)
//WebUI.setText(findTestObject('Object Repository/CCtexts/cvvCreditCard'), '956')
//WebUI.switchToDefaultContent()
//WebUI.delay(2)
//WebUI.click(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/subscribeNowButton'))
//WebUI.delay(2)
//WebUI.verifyElementPresent(findTestObject('Object Repository/CCtexts/CCVerificationMessage'), 2)


WebUI.closeBrowser()


