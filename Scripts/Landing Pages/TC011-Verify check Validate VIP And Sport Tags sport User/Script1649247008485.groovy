import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import shahid.Common as Common
import com.kms.katalon.core.model.FailureHandling as FailureHandling

new Common().navigateToShahid()

new Common().checkLanguage()


new Common().ScrollUntilElementPresent('Object Repository/LandingPages/' + GlobalVariable.objLanguage + '/vipTagHome')
WebUI.waitForPageLoad(2)
WebUI.verifyElementVisible(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/vipTagHome'), FailureHandling.CONTINUE_ON_FAILURE)

new Common().tapAtBurgerMenu()
WebUI.waitForPageLoad(2)
WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/TVShowsLink'))
WebUI.waitForPageLoad(2)
new Common().ScrollUntilElementPresent('Object Repository/LandingPages/' + GlobalVariable.objLanguage + '/vipTagTvShow')
WebUI.waitForPageLoad(2)
WebUI.verifyElementVisible(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/vipTagTvShow'), FailureHandling.CONTINUE_ON_FAILURE)

new Common().tapAtBurgerMenu()
WebUI.waitForPageLoad(2)
WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/moviesLink'))
WebUI.waitForPageLoad(2)
new Common().ScrollUntilElementPresent('Object Repository/LandingPages/' + GlobalVariable.objLanguage + '/vipMoviesTag')
WebUI.waitForPageLoad(4)
WebUI.verifyElementVisible(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/vipMoviesTag'), FailureHandling.CONTINUE_ON_FAILURE)

new Common().tapAtBurgerMenu()
WebUI.waitForPageLoad(2)
WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/sportsLink'))
new Common().ScrollUntilElementPresent('Object Repository/LandingPages/' + GlobalVariable.objLanguage + '/vipSportTag')
WebUI.waitForPageLoad(2)
WebUI.verifyElementVisible(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/vipSportTag'), FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'shahid.Common.login'(GlobalVariable.SubscribedSportUser, GlobalVariable.SubscribedSportUserPassword)
WebUI.waitForElementPresent(findTestObject('adultDefault'), 10)
WebUI.delay(2)
WebUI.click(findTestObject('adultDefault'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(2)
CustomKeywords.'shahid.Common.checkLanguage'()

	
	WebUI.verifyElementNotPresent(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/vipTagHome'), 5)

	
	new Common().tapAtBurgerMenu()
	
	WebUI.waitForPageLoad(2)
	WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/TVShowsLink'))
	WebUI.waitForPageLoad(2)


	WebUI.verifyElementNotPresent(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/vipTagTvShow'), 5)
	
	
	new Common().tapAtBurgerMenu()
	
	WebUI.waitForPageLoad(3)

	WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/moviesLink'))


	WebUI.waitForPageLoad(2)

	WebUI.verifyElementNotPresent(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/vipMoviesTag'), 5)

	
	new Common().tapAtBurgerMenu()
	
	WebUI.waitForPageLoad(2)
	WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/sportsLink'))

    WebUI.waitForPageLoad(1)

	
	WebUI.verifyElementNotPresent(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/vipSportTag'), 5)
	
	
	WebUI.closeBrowser()
	
