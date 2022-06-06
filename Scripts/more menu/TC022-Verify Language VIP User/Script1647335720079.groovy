import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.Common as GlobalVariable
import shahid.Common as Common
import internal.GlobalVariable as GlobalVariable



//working on android but not ios


CustomKeywords.'shahid.Common.navigateToShahid'()
new Common().checkLanguage()

if(GlobalVariable.device==GlobalVariable.mobile) {
	
	new Common().tapAtBurgerMenu()
	WebUI.click(findTestObject('Object Repository/moreScreenThreeLanguages/languageButton'))
	WebUI.click(findTestObject('Object Repository/moreScreenThreeLanguages/frLanguage'))
	 WebUI.getUrl().contains('/fr/')
	 
	 
		new Common().tapAtBurgerMenu()
		WebUI.click(findTestObject('Object Repository/moreScreenThreeLanguages/languageButton'))
		WebUI.click(findTestObject('Object Repository/loginThreeLanguages/englishLanguage'))
		WebUI.getUrl().contains('/en/')
		
		
		 
		new Common().tapAtBurgerMenu()
		WebUI.click(findTestObject('Object Repository/moreScreenThreeLanguages/languageButton'))
		WebUI.click(findTestObject('Object Repository/moreScreenThreeLanguages/arLanguage'))
		WebUI.getUrl().contains('/ar/')
		
	  }else {
		  WebUI.click(findTestObject('Object Repository/moreScreenThreeLanguages/languageAnonymous'))
		  WebUI.click(findTestObject('Object Repository/moreScreenThreeLanguages/frLanguage'))
		  WebUI.getUrl().contains('/fr/')
		  
				  
		  WebUI.click(findTestObject('Object Repository/moreScreenThreeLanguages/languageAnonymous'))
		  WebUI.click(findTestObject('Object Repository/loginThreeLanguages/englishLanguage'))
		  WebUI.getUrl().contains('/en/')
		  
		  WebUI.click(findTestObject('Object Repository/moreScreenThreeLanguages/languageAnonymous'))
		  WebUI.click(findTestObject('Object Repository/moreScreenThreeLanguages/arLanguage'))
		  WebUI.getUrl().contains('/ar/')
				
	  }
		  

	new Common().checkLanguage()
	
	CustomKeywords.'shahid.Common.login'(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)
	
		WebUI.waitForElementPresent(findTestObject('adultDefault'), 10)
		WebUI.delay(1)
		WebUI.click(findTestObject('adultDefault'), FailureHandling.CONTINUE_ON_FAILURE)
	
		new Common().checkLanguage()


	if(GlobalVariable.device==GlobalVariable.mobile) {
	new Common().tapAtBurgerMenu()
	
			Mobile.swipe(0, 1000, 0, 0)
			WebUI.click(findTestObject('Object Repository/moreScreenThreeLanguages/languageButton'))
		WebUI.click(findTestObject('Object Repository/moreScreenThreeLanguages/frLanguage'))
		WebUI.delay(3)
		 WebUI.getUrl().contains('/fr/')
		 
		 
	new Common().tapAtBurgerMenu()
		 Mobile.swipe(0, 1000, 0, 0)
		 WebUI.click(findTestObject('Object Repository/moreScreenThreeLanguages/languageButton'))
		 WebUI.click(findTestObject('Object Repository/loginThreeLanguages/englishLanguage'))
		 WebUI.delay(3)
		 WebUI.getUrl().contains('/en/')
		 
		 
	 new Common().tapAtBurgerMenu()
	 Mobile.swipe(0, 1000, 0, 0)
	 WebUI.click(findTestObject('Object Repository/moreScreenThreeLanguages/languageButton'))
	 WebUI.click(findTestObject('Object Repository/moreScreenThreeLanguages/arLanguage'))
	 WebUI.delay(3)
	 WebUI.getUrl().contains('/ar/')
	 new Common().logout()
	}else {
		
		
		WebUI.mouseOver(findTestObject('Object Repository/moreScreenThreeLanguages/profileIcon'))
		WebUI.click(findTestObject('Object Repository/moreScreenThreeLanguages/languagesWeb'))
		WebUI.click(findTestObject('Object Repository/moreScreenThreeLanguages/frLanguage'))
		 WebUI.getUrl().contains('/fr/')
		 
		 WebUI.mouseOver(findTestObject('Object Repository/moreScreenThreeLanguages/profileIcon'))
		 WebUI.click(findTestObject('Object Repository/moreScreenThreeLanguages/languagesWeb'))
		 WebUI.click(findTestObject('Object Repository/loginThreeLanguages/englishLanguage'))
		 WebUI.getUrl().contains('/en/')
		 
		 WebUI.mouseOver(findTestObject('Object Repository/moreScreenThreeLanguages/profileIcon'))
		 WebUI.click(findTestObject('Object Repository/moreScreenThreeLanguages/languagesWeb'))
		 WebUI.click(findTestObject('Object Repository/moreScreenThreeLanguages/arLanguage'))
		 WebUI.getUrl().contains('/ar/')
		  
	}
        WebUI.closeBrowser()
