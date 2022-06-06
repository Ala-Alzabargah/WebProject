import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.utils.Shahid as Shahid

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

new Shahid().NavigateToShahid()

WebUI.delay(2)

WebDriver driver = DriverFactory.getWebDriver()

String testcaseName = RunConfiguration.getExecutionSourceName().toString()

WebUI.navigateToUrl('http://fw.to/qDzbOXL')

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/upSelling/HDToggle'))


//Check Title
if (WebUI.getText(findTestObject('Object Repository/upSelling/displayName')).equals(new Shahid().getTitle(GlobalVariable.Benefits, 
        'L', 38))) {
    titleCondition = true
	KeywordUtil.markPassed("Title text matched")
} else {
    titleCondition = false
	KeywordUtil.markFailed("Title text not matched")
    new Shahid().updateResultSheet(GlobalVariable.Benefits,'Title', new Shahid().getTitle(GlobalVariable.Benefits, 'L', 38), WebUI.getText(findTestObject(
                'Object Repository/upSelling/displayName')), count)

    count += 1
}

//Check Message
if (WebUI.getText(findTestObject('Object Repository/upSelling/message')).equals(new Shahid().getTitle(GlobalVariable.Benefits, 
        'L', 39))) {
    messageCondition = true
	KeywordUtil.markPassed("Message text matched")
} else {
    messageCondition = false
	KeywordUtil.markFailed("Message text not matched")
    new Shahid().updateResultSheet(GlobalVariable.Benefits,'Message', new Shahid().getTitle(GlobalVariable.Benefits, 'L', 39), WebUI.getText(findTestObject(
                'Object Repository/upSelling/message')), count)

    count += 1
}

//check HD text
if (WebUI.getAttribute(findTestObject('Object Repository/upSelling/HDIcons'), 'alt').equals(new Shahid().getTitle(GlobalVariable.Benefits, 
        'L', 40))) {
    HDCondition = true
	KeywordUtil.markPassed("HD Icon text matched")
} else {
    HDCondition = false
	KeywordUtil.markFailed("HD Icon text not matched")
    new Shahid().updateResultSheet(GlobalVariable.Benefits,'HD Icon', new Shahid().getTitle(GlobalVariable.Benefits, 'L', 40), WebUI.getAttribute(findTestObject(
                'Object Repository/upSelling/HDIcons'), 'alt'), count)

    count += 1
}

//check offline text
if (WebUI.getAttribute(findTestObject('Object Repository/upSelling/offlineIcon'), 'alt').equals(new Shahid().getTitle(GlobalVariable.Benefits, 
        'L', 41))) {
    offlineCondition = true
	KeywordUtil.markPassed("offline text matched")
} else {
    offlineCondition = false
	KeywordUtil.markFailed("Offline download not matched")
    new Shahid().updateResultSheet(GlobalVariable.Benefits,'Offline download Icon', new Shahid().getTitle(GlobalVariable.Benefits, 'L', 41), WebUI.getAttribute(
            findTestObject('Object Repository/upSelling/offlineIcon'), 'alt'), count)

    count += 1
}

//check watch on TV text
if (WebUI.getAttribute(findTestObject('Object Repository/upSelling/watchOnTVIcon'), 'alt').equals(new Shahid().getTitle(
        GlobalVariable.Benefits, 'L', 42))) {
    TVCondition = true
	KeywordUtil.markPassed("watch on TV text matched")
} else {
    TVCondition = false
	KeywordUtil.markFailed("Watch on TV text not matched")
    new Shahid().updateResultSheet(GlobalVariable.Benefits,'Watch on TV Icon', new Shahid().getTitle(GlobalVariable.Benefits, 'L', 42), WebUI.getAttribute(
            findTestObject('Object Repository/upSelling/watchOnTVIcon'), 'alt'), count)

    count += 1
}

//Check CTA1
if (WebUI.getText(findTestObject('Object Repository/upSelling/joinNowButton')).equals(new Shahid().getTitle(GlobalVariable.Benefits,
		'L', 43))) {
	CTA2Condition = true
	KeywordUtil.markPassed("CTA1 text matched")
	
	
} else {
	CTA2Condition = false
	KeywordUtil.markFailed("CTA1 text not matched")
	new Shahid().updateResultSheet(GlobalVariable.Benefits,'CTA1', new Shahid().getTitle(GlobalVariable.Benefits, 'L', 43), WebUI.getText(findTestObject(
				'Object Repository/upSelling/joinNowButton')), count)
	
	count += 1
}

//check CTA2
if (WebUI.getText(findTestObject('Object Repository/upSelling/loginButton')).equals(new Shahid().getTitle(GlobalVariable.Benefits, 
        'L', 44))) {
    CTA1Condition = true
	KeywordUtil.markPassed("CTA2 text matched")
} else {
    CTA1Condition = false
	
	KeywordUtil.markFailed("CTA2 text not matched")

    new Shahid().updateResultSheet(GlobalVariable.Benefits,'CTA2', new Shahid().getTitle(GlobalVariable.Benefits, 'L', 44), WebUI.getText(findTestObject(
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

	new Shahid().updateResultSheet(GlobalVariable.Benefits,'Display Image', "check screenshots", "check screenshots", count)

	count += 1
}

//Check HD Icon
if(WebUI.verifyImagePresent(findTestObject('Object Repository/upSelling/Images/Series/hdIcon'),FailureHandling.CONTINUE_ON_FAILURE)){
	HDIconCondition = true
	KeywordUtil.markPassed("HD Icon matched")
} else {
	HDIconCondition = false
	
	KeywordUtil.markFailed("HD Icon not matched")

	new Shahid().updateResultSheet(GlobalVariable.Benefits,'HD Icon', "check screenshots", "check screenshots", count)

	count += 1
}

//Check offline download Icon
if(WebUI.verifyImagePresent(findTestObject('Object Repository/upSelling/Images/Series/offlineDownloadIcon'),FailureHandling.CONTINUE_ON_FAILURE)){
	offlineIconCondition = true
	KeywordUtil.markPassed("Offline download icon matched")
} else {
	offlineIconCondition = false
	
	KeywordUtil.markFailed("Offline download icon not matched")

	new Shahid().updateResultSheet(GlobalVariable.Benefits,'offline Icon', "check screenshots", "check screenshots", count)

	count += 1
}

//Check watch on TV Icon
if(WebUI.verifyImagePresent(findTestObject('Object Repository/upSelling/Images/Series/watchOnTVIcon'),FailureHandling.CONTINUE_ON_FAILURE)){
	TVIconCondition = true
	KeywordUtil.markPassed("Watch on TV Icon matched")
} else {
	TVIconCondition = false
	
	KeywordUtil.markFailed("Watch on TV Icon not matched")

	new Shahid().updateResultSheet(GlobalVariable.Benefits,'Watch on TV Icon', "check screenshots", "check screenshots", count)

	count += 1
}



//Take screenshot
if (!(titleCondition && messageCondition && HDCondition && offlineCondition && TVCondition && CTA1Condition && 
CTA2Condition && displayImageCondition && HDIconCondition && offlineIconCondition && TVIconCondition)) {
    new Shahid().upSellingScreenshot(GlobalVariable.Benefits,testcaseName, 'Failed')
}