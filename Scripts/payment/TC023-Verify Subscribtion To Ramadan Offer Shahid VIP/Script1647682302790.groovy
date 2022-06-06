
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.Common


CustomKeywords.'shahid.Common.navigateToShahid'()



CustomKeywords.'shahid.Common.checkLanguage'()
CustomKeywords.'shahid.Common.login'(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)
WebUI.waitForElementPresent(findTestObject('adultDefault'), 10)

WebUI.click(findTestObject('adultDefault'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(2)
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
CustomKeywords.'shahid.Common.checkLanguage'()


//ramadan offer page 
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/getTheRamadanOfferText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/thePriceMonthlyText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/forTheFirstYearText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/ramadanOfferButton'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/termsAndConditionApply'), 3)



WebUI.closeBrowser()
