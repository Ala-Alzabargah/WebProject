import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.Common

import shahid.Common as Common
import internal.GlobalVariable as GlobalVariable



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
	WebUI.navigateToUrl(GlobalVariable.assetLink+GlobalVariable.objLanguage+'/shows/Top-Chef/show-149597')
	WebUI.getUrl().contains('/shows/')
	new Common().JSclick(findTestObject('Object Repository/MovieScreen/addToFavIcon'))
	WebUI.navigateToUrl(GlobalVariable.favoritePageLink+GlobalVariable.objLanguage+'/favorite')

	
	WebUI.waitForElementNotPresent(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/nothingInTheListText'),4)
	WebUI.verifyElementNotPresent(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/nothingInTheListText'),3)
	WebUI.verifyElementNotPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/addtoMyListButton'),3)
	
	
	
	if(GlobalVariable.device==GlobalVariable.mobile) {
		new Common().JSclick(findTestObject('Object Repository/favAsset'))
		WebUI.delay(5)
		new Common().JSclick(findTestObject('Object Repository/MovieScreen/addToFavIcon'))
		WebUI.delay(2)
		WebUI.back()
	}else {
		WebUI.mouseOver(findTestObject('Object Repository/moreScreenThreeLanguages/favAseetWeb'))
		WebUI.click(findTestObject('Object Repository/MovieScreen/favIconHover'))
		WebUI.refresh()
	}
	new Common().checkLanguage()
	WebUI.verifyElementPresent(findTestObject(('Object Repository/loginThreeLanguages/' + GlobalVariable.objLanguage) +'/nothingInTheListText'), 3)
	WebUI.verifyElementPresent(findTestObject(('Object Repository/moreScreenThreeLanguages/' + GlobalVariable.objLanguage) +'/addtoMyListButton'), 3)
    WebUI.closeBrowser()



