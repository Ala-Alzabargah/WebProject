import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject


import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import shahid.Common as Common
import internal.GlobalVariable



new Common().navigateToShahid()
WebUI.delay(2)
WebDriver driver = DriverFactory.getWebDriver()
new Common().shahidSignup(new Common().generateNewUser(), GlobalVariable.SubscribedUser)
new Common().popupNotification()
WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
List<WebElement> UserProfile = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
WebUI.delay(2)
(UserProfile[0]).click()
WebUI.delay(2)
new Common().popupNotification()
new Common().checkLanguage()
if (WebUI.waitForElementVisible(findTestObject('loginThreeLanguages/hamburgerMenu'), 7)) {
	WebUI.click(findTestObject('loginThreeLanguages/hamburgerMenu'))
		WebUI.delay(4)
Mobile.swipe(0, 600, 0, 0)
WebUI.click(findTestObject('Object Repository/moreScreenThreeLanguages/accountSettingsLink'))
}

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

Mobile.swipe(0, 600, 0, 0)
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
new Common().JSclick(findTestObject('Object Repository/subscribtionPage/joinNowButton'))
WebUI.delay(5)


new Common().checkLanguage()

//choose your plan page
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/shahidVIPText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/fullHDtext'), 3)
WebUI.verifyElementVisible(findTestObject('Object Repository/accountSettings/fullHDtext'), 3)
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
WebUI.verifyElementPresent(findTestObject('Object Repository/CCtexts/chooseYourPackageIcon'), 3)


WebUI.waitForPageLoad(6)
WebUI.delay(2)
WebUI.switchToFrame(findTestObject('creditCardFrams/cardFrame'), 3)
WebUI.setText(findTestObject('Object Repository/Settings Screen/Payment Methods/Credit Card/cardNumberFiled'), '4539360659413827')
Mobile.tapAtPosition(200, 600)
WebUI.delay(3)
WebUI.switchToDefaultContent()
WebUI.waitForPageLoad(6)
WebUI.switchToFrame(findTestObject('Object Repository/creditCardFrams/expiryDateFrame'), 3)
WebUI.delay(2)
WebUI.setText(findTestObject('Object Repository/CCtexts/expiryDate'), '1225')
WebUI.switchToDefaultContent()
WebUI.waitForPageLoad(6)
WebUI.switchToFrame(findTestObject('Object Repository/creditCardFrams/cvvFrame'), 3)
WebUI.setText(findTestObject('Object Repository/CCtexts/cvvCreditCard'), '100')
WebUI.switchToDefaultContent()
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/CCtexts/subscribeNowButton'))
WebUI.delay(2)
WebUI.verifyElementPresent(findTestObject('Object Repository/CCtexts/CCVerificationMessage'), 2)
WebUI.delay(10)

