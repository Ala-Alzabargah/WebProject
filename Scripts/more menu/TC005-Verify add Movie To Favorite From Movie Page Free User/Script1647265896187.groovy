import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.Common


//working on android but not ios 


   CustomKeywords.'shahid.Common.navigateToShahid'()
   CustomKeywords.'shahid.Common.checkLanguage'()
   CustomKeywords.'shahid.Common.login'(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
   WebUI.waitForElementPresent(findTestObject('adultDefault'), 10)
   WebUI.delay(2)
   WebUI.click(findTestObject('adultDefault'), FailureHandling.CONTINUE_ON_FAILURE)
   WebUI.delay(2)
   CustomKeywords.'shahid.Common.checkLanguage'()
   

    if (WebUI.waitForElementVisible(findTestObject('loginThreeLanguages/hamburgerMenu'), 7)) {
        WebUI.click(findTestObject('loginThreeLanguages/hamburgerMenu'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/moreScreen/myAccountButton'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/moreScreen/deviceManagementButton'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/myAccountButton'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/myListLink'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/logoutLink'), 2)
    }
	WebUI.click(findTestObject('Object Repository/PromoPages/Menu Bar/moviesLink'))


    new Common().popupNotification()

	if(GlobalVariable.device==GlobalVariable.mobile) {
		WebUI.scrollToElement(findTestObject('Object Repository/moreScreenThreeLanguages/movieAsset'), 3)
		new Common().JSclick(findTestObject('Object Repository/moreScreenThreeLanguages/movieAsset'))
	
	}else {
		WebUI.scrollToElement(findTestObject('Object Repository/moreScreenThreeLanguages/movieAssetWeb'), 3)
		new Common().JSclick(findTestObject('Object Repository/moreScreenThreeLanguages/movieAssetWeb'))
		
	}
	
    new Common().JSclick(findTestObject('Object Repository/MovieScreen/addToFavIcon'))
    WebUI.navigateToUrl(GlobalVariable.assetLink+GlobalVariable.objLanguage+'/favorite')

	if(GlobalVariable.device==GlobalVariable.mobile) {
		new Common().JSclick(findTestObject('Object Repository/favAsset'))
		WebUI.delay(5)
		new Common().JSclick(findTestObject('Object Repository/MovieScreen/addToFavIcon'))
		WebUI.delay(2)
		WebUI.back()
	}else {
		
		WebUI.mouseOver(findTestObject('Object Repository/moreScreenThreeLanguages/favAseetWeb'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/MovieScreen/favIconHover'))
		WebUI.refresh()
	}
	
	new Common().checkLanguage()
	WebUI.verifyElementPresent(findTestObject(('Object Repository/loginThreeLanguages/' + GlobalVariable.objLanguage) +'/nothingInTheListText'), 3)
    WebUI.verifyElementPresent(findTestObject(('Object Repository/moreScreenThreeLanguages/' + GlobalVariable.objLanguage) +'/addtoMyListButton'), 3)
    WebUI.closeBrowser()

