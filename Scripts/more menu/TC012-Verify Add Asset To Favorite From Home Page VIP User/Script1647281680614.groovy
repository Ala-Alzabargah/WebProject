import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.Common


//working on android but not ios


CustomKeywords.'shahid.Common.navigateToShahid'()
CustomKeywords.'shahid.Common.checkLanguage'()
CustomKeywords.'shahid.Common.login'(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)
WebUI.delay(3)
WebUI.waitForElementPresent(findTestObject('adultDefault'), 10)
WebUI.delay(2)
WebUI.click(findTestObject('adultDefault'), FailureHandling.CONTINUE_ON_FAILURE)
CustomKeywords.'shahid.Common.checkLanguage'()
new Common().checkLanguage()
new Common().popupNotification()




if(GlobalVariable.device==GlobalVariable.mobile) {
	WebUI.scrollToElement(findTestObject('Object Repository/moreScreenThreeLanguages/movieAsset'), 3)
	WebUI.delay(3)
	new Common().JSclick(findTestObject('Object Repository/moreScreenThreeLanguages/movieAsset'))
	WebUI.delay(5)

}else {
	WebUI.delay(1)
	WebUI.scrollToElement(findTestObject('Object Repository/moreScreenThreeLanguages/movieAssetWeb'), 3)
	new Common().JSclick(findTestObject('Object Repository/moreScreenThreeLanguages/movieAssetWeb'))
	
}
	WebUI.click(findTestObject('Object Repository/MovieScreen/addToFavIcon'))
	WebUI.navigateToUrl(GlobalVariable.assetLink+GlobalVariable.objLanguage+'/favorite')
	if(GlobalVariable.device==GlobalVariable.mobile) {
		new Common().JSclick(findTestObject('Object Repository/favAsset'))
		WebUI.click(findTestObject('Object Repository/MovieScreen/addToFavIcon'))
	}else {
		WebUI.mouseOver(findTestObject('Object Repository/moreScreenThreeLanguages/favAseetWeb'))
		WebUI.click(findTestObject('Object Repository/MovieScreen/favIconHover'))
		WebUI.refresh()
	}
	
	new Common().checkLanguage()
	WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/nothingInTheListText'),3)
	WebUI.verifyElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/addtoMyListButton'),3)
	new Common().tapAtBurgerMenu()
	WebUI.closeBrowser()


