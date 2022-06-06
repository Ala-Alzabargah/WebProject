import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.Common as GlobalVariable
import shahid.Common as Common
import internal.GlobalVariable as GlobalVariable



//working on android and ios 


     CustomKeywords.'shahid.Common.navigateToShahid'()

  
    new Common().checkLanguage()
	if (WebUI.waitForElementVisible(findTestObject('loginThreeLanguages/hamburgerMenu'), 7)) {
		WebUI.click(findTestObject('loginThreeLanguages/hamburgerMenu'))
		
	}
	
	WebUI.click(findTestObject('Object Repository/PromoPages/Menu Bar/moviesLink'))
	new Common().popupNotification()
	
	if(GlobalVariable.device==GlobalVariable.mobile) {
		WebUI.scrollToElement(findTestObject('Object Repository/moreScreenThreeLanguages/movieAsset'), 3)
		WebUI.delay(3)
		new Common().JSclick(findTestObject('Object Repository/moreScreenThreeLanguages/movieAsset'))
		WebUI.delay(5)
	
	}else {
		WebUI.scrollToElement(findTestObject('Object Repository/moreScreenThreeLanguages/movieAssetWeb'), 3)
		new Common().JSclick(findTestObject('Object Repository/moreScreenThreeLanguages/movieAssetWeb'))
		
	}
	new Common().JSclick(findTestObject('Object Repository/MovieScreen/addToFavIcon'))
	WebUI.setText(findTestObject('Object Repository/LoginScreen/usernameField'),GlobalVariable.TeamUser)
	WebUI.click(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/continueButton'))

	WebUI.setText(findTestObject('loginThreeLanguages/passwordField'),GlobalVariable.TeamUserPassword)
	WebUI.click(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/loginButton'))

	WebUI.waitForElementPresent(findTestObject('adultDefault'), 10)
	WebUI.delay(1)
	WebUI.click(findTestObject('adultDefault'), FailureHandling.CONTINUE_ON_FAILURE)

    new Common().checkLanguage()

	
	
    	WebUI.navigateToUrl(GlobalVariable.assetLink+GlobalVariable.objLanguage+'/favorite')
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
WebUI.verifyElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+ GlobalVariable.objLanguage+'/addtoMyListButton'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/' + GlobalVariable.objLanguage+'/nothingInTheListText'), 3)

         WebUI.closeBrowser()

