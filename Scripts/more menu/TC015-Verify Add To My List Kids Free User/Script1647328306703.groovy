import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
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
WebUI.waitForElementPresent(findTestObject('Object Repository/kidsProfile'), 10)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/kidsProfile'), FailureHandling.CONTINUE_ON_FAILURE)
CustomKeywords.'shahid.Common.checkLanguage'()

	if (WebUI.waitForElementVisible(findTestObject('loginThreeLanguages/hamburgerMenu'), 7)) {
		WebUI.click(findTestObject('loginThreeLanguages/hamburgerMenu'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/moreScreen/myAccountButton'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/moreScreen/deviceManagementButton'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/logoutLink'), 2)
		WebUI.delay(3)
		Mobile.swipe(0, 1000, 0, 0)
	}
	
	if(GlobalVariable.device==GlobalVariable.mobile) {
		Mobile.swipe(0, 1000, 0, 0)
		new Common().JSclick(findTestObject('Object Repository/moreScreenThreeLanguages/' + GlobalVariable.objLanguage+'/KidsProfileButton'))
		new Common().ScrollUntilElementPresent('Object Repository/kidsAsset')
		new Common().JSclick(findTestObject('Object Repository/kidsAsset'))
		WebUI.delay(4)
	}else {
		new Common().scrollElementIntoViewLess()
		new Common().JSclick(findTestObject('Object Repository/moreScreenThreeLanguages/kidsAssetWeb'))
		
		
	}

	
	new Common().JSclick(findTestObject('Object Repository/MovieScreen/addToFavIcon'))
	
	
	WebUI.navigateToUrl(GlobalVariable.assetLink+GlobalVariable.objLanguage+'/favorite')
	WebUI.verifyElementNotPresent(findTestObject('Object Repository/loginThreeLanguages/' + GlobalVariable.objLanguage+'/nothingInTheListText'), 3)
    WebUI.verifyElementNotPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+ GlobalVariable.objLanguage+'/addtoMyListButton'), 3)
    WebUI.closeBrowser()
    

