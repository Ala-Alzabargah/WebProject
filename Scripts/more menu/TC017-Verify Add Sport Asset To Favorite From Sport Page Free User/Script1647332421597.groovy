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
CustomKeywords.'shahid.Common.login'(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
WebUI.delay(3)
WebUI.waitForElementPresent(findTestObject('adultDefault'), 10)
WebUI.delay(1)
WebUI.click(findTestObject('adultDefault'), FailureHandling.CONTINUE_ON_FAILURE)
CustomKeywords.'shahid.Common.checkLanguage'()

    if (WebUI.waitForElementVisible(findTestObject('loginThreeLanguages/hamburgerMenu'), 7)) {
        WebUI.click(findTestObject('loginThreeLanguages/hamburgerMenu'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/moreScreen/myAccountButton'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/moreScreen/deviceManagementButton'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/myAccountButton'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/myListLink'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/logoutLink'), 2)
		WebUI.delay(4)
    }
	
    WebUI.click(findTestObject('Object Repository/PromoPages/Menu Bar/sportLink'))

	
	if(GlobalVariable.device==GlobalVariable.mobile) {
		new Common().ScrollUntilElementPresent('Object Repository/moreScreenThreeLanguages/movieAsset')
		WebUI.waitForPageLoad(7)
		new Common().JSclick(findTestObject('Object Repository/moreScreenThreeLanguages/movieAsset'))
		WebUI.waitForPageLoad(7)
	
	}else {
		WebUI.delay(3)
		WebUI.waitForPageLoad(7)
		new Common().scrollElementIntoViewLess()
//		new Common().ScrollUntilElementPresent('Object Repository/moreScreenThreeLanguages/sportAssetWeb')
//		WebUI.scrollToElement(findTestObject('Object Repository/moreScreenThreeLanguages/sportAssetWeb'), 4,FailureHandling.STOP_ON_FAILURE)
		WebUI.mouseOver(findTestObject('Object Repository/moreScreenThreeLanguages/sportAssetWeb'))
		WebUI.click(findTestObject('Object Repository/moreScreenThreeLanguages/sportAssetWeb'))
		
		
	}
	WebUI.delay(2)
    new Common().JSclick(findTestObject('Object Repository/MovieScreen/addToFavIcon'))
	
	
    WebUI.navigateToUrl(GlobalVariable.assetLink+GlobalVariable.objLanguage+'/favorite')
    

    WebUI.verifyElementNotPresent(findTestObject('Object Repository/loginThreeLanguages/' + GlobalVariable.objLanguage + '/nothingInTheListText'), 3)
    WebUI.verifyElementNotPresent(findTestObject('Object Repository/moreScreenThreeLanguages/' + GlobalVariable.objLanguage +'/addtoMyListButton'), 3)

	if(GlobalVariable.device==GlobalVariable.mobile) {
		new Common().JSclick(findTestObject('Object Repository/favAsset'))
		WebUI.waitForPageLoad(7)
		new Common().JSclick(findTestObject('Object Repository/MovieScreen/addToFavIcon'))
		WebUI.delay(2)
		WebUI.back()
	}else {
		WebUI.delay(1)
		WebUI.mouseOver(findTestObject('Object Repository/moreScreenThreeLanguages/assetFavView'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/MovieScreen/favIconHover'))
		WebUI.refresh()
	}
	new Common().checkLanguage()
	WebUI.verifyElementPresent(findTestObject(('Object Repository/loginThreeLanguages/' + GlobalVariable.objLanguage) +'/nothingInTheListText'), 3)
    WebUI.verifyElementPresent(findTestObject(('Object Repository/moreScreenThreeLanguages/' + GlobalVariable.objLanguage) +'/addtoMyListButton'), 3)
   
	WebUI.closeBrowser()



