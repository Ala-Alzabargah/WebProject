import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import shahid.Common
import internal.GlobalVariable

boolean titleCondition

boolean messageCondition

boolean HDCondition

boolean offlineCondition

boolean TVCondition

boolean CTA1Condition

boolean CTA2Condition

boolean HDIconCondition

boolean offlineIconCondition

boolean TVIconCondition

boolean displayImageCondition

int count = 2

new Common().navigateToShahid()

WebUI.delay(2)

WebDriver driver = DriverFactory.getWebDriver()

String testcaseName = RunConfiguration.getExecutionSourceName().toString()

new Common().login(GlobalVariable.FreeUser, GlobalVariable.FreeUserPassword)

new Common().selectUser()

new Common().checkLanguage()

WebUI.navigateToUrl('https://shahid.mbc.net/ar/shows/%D9%81%D8%B1%D9%82-%D8%A7%D9%84%D8%A3%D8%AD%D9%84%D8%A7%D9%85-%D8%A7%D9%84%D9%85%D9%88%D8%B3%D9%85-1-%D8%A7%D9%84%D8%AD%D9%84%D9%82%D8%A9-1/episode-907001')

WebUI.delay(3)


//Check Title
if (WebUI.getText(findTestObject('Object Repository/upSelling/displayName')).equals(new Common().getUpsellTitle(GlobalVariable.Content, 
        'F', 3))) {
    titleCondition = true
	KeywordUtil.markPassed("Title text matched")
} else { 
    titleCondition = false
	KeywordUtil.markFailed("Title text not matched")
    new Common().updateUpsellResultSheet('Title',GlobalVariable.Content, new Common().getUpsellTitle(GlobalVariable.Content, 'F', 3), WebUI.getText(findTestObject(
                'Object Repository/upSelling/displayName')), count)

    count += 1
}

//Check Message
if (WebUI.getText(findTestObject('Object Repository/upSelling/message')).equals(new Common().getUpsellTitle(GlobalVariable.Content, 
        'F', 4))) {
    messageCondition = true
	KeywordUtil.markPassed("Message text matched")
} else {
    messageCondition = false
	KeywordUtil.markFailed("Message text not matched")
    new Common().updateUpsellResultSheet('Message',GlobalVariable.Content, new Common().getUpsellTitle(GlobalVariable.Content, 'F', 4), WebUI.getText(findTestObject(
                'Object Repository/upSelling/message')), count)

    count += 1
}

//check HD text
if (WebUI.getAttribute(findTestObject('Object Repository/upSelling/HDIcons'), 'alt').equals(new Common().getUpsellTitle(GlobalVariable.Content, 
        'F', 6))) {
    HDCondition = true
	KeywordUtil.markPassed("HD Icon text matched")
} else {
    HDCondition = false
	KeywordUtil.markFailed("HD Icon text not matched")
    new Common().updateUpsellResultSheet('HD Icon', GlobalVariable.Content,new Common().getUpsellTitle(GlobalVariable.Content, 'F', 6), WebUI.getAttribute(findTestObject(
                'Object Repository/upSelling/HDIcons'), 'alt'), count)

    count += 1
}

//check offline text
if (WebUI.getAttribute(findTestObject('Object Repository/upSelling/offlineIcon'), 'alt').equals(new Common().getUpsellTitle(GlobalVariable.Content, 
        'F', 7))) {
    offlineCondition = true
	KeywordUtil.markPassed("offline text matched")
} else {
    offlineCondition = false
	KeywordUtil.markFailed("Offline download not matched")
    new Common().updateUpsellResultSheet('Offline download Icon',GlobalVariable.Content, new Common().getUpsellTitle(GlobalVariable.Content, 'F', 7), WebUI.getAttribute(
            findTestObject('Object Repository/upSelling/offlineIcon'), 'alt'), count)

    count += 1
}

//check watch on TV text
if (WebUI.getAttribute(findTestObject('Object Repository/upSelling/watchOnTVIcon'), 'alt').equals(new Common().getUpsellTitle(
        GlobalVariable.Content, 'F', 8))) {
    TVCondition = true
	KeywordUtil.markPassed("watch on TV text matched")
} else {
    TVCondition = false
	KeywordUtil.markFailed("Watch on TV text not matched")
    new Common().updateUpsellResultSheet('Watch on TV Icon',GlobalVariable.Content, new Common().getUpsellTitle(GlobalVariable.Content, 'F', 8), WebUI.getAttribute(
            findTestObject('Object Repository/upSelling/watchOnTVIcon'), 'alt'), count)

    count += 1
}

//Check CTA1
if (WebUI.getText(findTestObject('Object Repository/upSelling/joinNowButton')).equals(new Common().getUpsellTitle(GlobalVariable.Content,
		'F', 9))) {
	CTA2Condition = true
	KeywordUtil.markPassed("CTA1 text matched")
	
	
} else {
	CTA2Condition = false
	KeywordUtil.markFailed("CTA1 text not matched")
	new Common().updateUpsellResultSheet('CTA1',GlobalVariable.Content, new Common().getUpsellTitle(GlobalVariable.Content, 'F', 9), WebUI.getText(findTestObject(
				'Object Repository/upSelling/joinNowButton')), count)
	
	count += 1
}

//check CTA2
if (WebUI.getText(findTestObject('Object Repository/upSelling/loginButton')).equals(new Common().getUpsellTitle(GlobalVariable.Content, 
        'F', 11))) {
    CTA1Condition = true
	KeywordUtil.markPassed("CTA2 text matched")
} else {
    CTA1Condition = false
	
	KeywordUtil.markFailed("CTA2 text not matched")

    new Common().updateUpsellResultSheet('CTA2', GlobalVariable.Content,new Common().getUpsellTitle(GlobalVariable.Content, 'F', 11), WebUI.getText(findTestObject(
                'Object Repository/upSelling/loginButton')), count)

    count += 1
}

//Check displayImage
if (WebUI.verifyImagePresent(findTestObject('Object Repository/upSelling/Images/Series/desktopUpsellPlayer_upsellImg'),FailureHandling.CONTINUE_ON_FAILURE)) {
	displayImageCondition = true
	KeywordUtil.markPassed("DisplayImage matched")
} else {
	displayImageCondition = false
	
	KeywordUtil.markFailed("Display Image not matched")

	new Common().updateUpsellResultSheet('Display Image', GlobalVariable.Content,"check screenshots", "check screenshots", count)

	count += 1
}

//Check HD Icon
if(WebUI.verifyImagePresent(findTestObject('Object Repository/upSelling/Images/Series/hdIcon'),FailureHandling.CONTINUE_ON_FAILURE)){
	HDIconCondition = true
	KeywordUtil.markPassed("HD Icon matched")
} else {
	HDIconCondition = false
	
	KeywordUtil.markFailed("HD Icon not matched")

	new Common().updateUpsellResultSheet('HD Icon',GlobalVariable.Content, "check screenshots", "check screenshots", count)

	count += 1
}

//Check offline download Icon
if(WebUI.verifyImagePresent(findTestObject('Object Repository/upSelling/Images/Series/offlineDownloadIcon'),FailureHandling.CONTINUE_ON_FAILURE)){
	offlineIconCondition = true
	KeywordUtil.markPassed("Offline download icon matched")
} else {
	offlineIconCondition = false
	
	KeywordUtil.markFailed("Offline download icon not matched")

	new Common().updateUpsellResultSheet('offline Icon',GlobalVariable.Content, "check screenshots", "check screenshots", count)

	count += 1
}

//Check watch on TV Icon
if(WebUI.verifyImagePresent(findTestObject('Object Repository/upSelling/Images/Series/watchOnTVIcon'),FailureHandling.CONTINUE_ON_FAILURE)){
	TVIconCondition = true
	KeywordUtil.markPassed("Watch on TV Icon matched")
} else {
	TVIconCondition = false
	
	KeywordUtil.markFailed("Watch on TV Icon not matched")

	new Common().updateUpsellResultSheet('Watch on TV Icon', GlobalVariable.Content,"check screenshots", "check screenshots", count)

	count += 1
}



//Take screenshot
if (!(titleCondition && messageCondition && HDCondition && offlineCondition && TVCondition && CTA1Condition && 
CTA2Condition && displayImageCondition && HDIconCondition && offlineIconCondition && TVIconCondition)) {
    new Common().upSellingScreenshot(GlobalVariable.Content,testcaseName, 'Failed')
}