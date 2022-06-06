import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebDriver

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import shahid.utils.Shahid as Shahid

boolean titleCondition

boolean messageCondition

boolean HDCondition

boolean offlineCondition

boolean TVCondition

boolean CTA1Condition

boolean CTA2Condition

int count = 2

new Shahid().NavigateToShahid()

WebUI.delay(2)

WebDriver driver = DriverFactory.getWebDriver()

String testcaseName = RunConfiguration.getExecutionSourceName().toString()

WebUI.navigateToUrl('http://fw.to/qDzbOXL')

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/upSelling/noAds'))


//Check Title
if (WebUI.getText(findTestObject('Object Repository/upSelling/displayName')).equals(new Shahid().getTitle(GlobalVariable.Benefits, 
        'L', 4))) {
    titleCondition = true
	KeywordUtil.markPassed("Title text matched")
} else {
    titleCondition = false
	KeywordUtil.markFailed("Title text not matched")
    new Shahid().updateResultSheet('Title', new Shahid().getTitle(GlobalVariable.Benefits, 'L', 4), WebUI.getText(findTestObject(
                'Object Repository/upSelling/displayName')), count)

    count += 1
}

//Check Message
if (WebUI.getText(findTestObject('Object Repository/upSelling/message')).equals(new Shahid().getTitle(GlobalVariable.Benefits, 
        'L', 5))) {
    messageCondition = true
	KeywordUtil.markPassed("Message text matched")
} else {
    messageCondition = false
	KeywordUtil.markFailed("Message text not matched")
    new Shahid().updateResultSheet('Message', new Shahid().getTitle(GlobalVariable.Benefits, 'L', 5), WebUI.getText(findTestObject(
                'Object Repository/upSelling/message')), count)

    count += 1
}

//check HD text
if (WebUI.getAttribute(findTestObject('Object Repository/upSelling/HDIcons'), 'alt').equals(new Shahid().getTitle(GlobalVariable.Benefits, 
        'L', 6))) {
    HDCondition = true
	KeywordUtil.markPassed("HD Icon text matched")
} else {
    HDCondition = false
	KeywordUtil.markFailed("HD Icon text not matched")
    new Shahid().updateResultSheet('HD Icon', new Shahid().getTitle(GlobalVariable.Benefits, 'L', 6), WebUI.getAttribute(findTestObject(
                'Object Repository/upSelling/HDIcons'), 'alt'), count)

    count += 1
}

//check offline text
if (WebUI.getAttribute(findTestObject('Object Repository/upSelling/offlineIcon'), 'alt').equals(new Shahid().getTitle(GlobalVariable.Benefits, 
        'L', 7))) {
    offlineCondition = true
	KeywordUtil.markPassed("offline text matched")
} else {
    offlineCondition = false
	KeywordUtil.markFailed("Offline download not matched")
    new Shahid().updateResultSheet('Offline download Icon', new Shahid().getTitle(GlobalVariable.Benefits, 'L', 7), WebUI.getAttribute(
            findTestObject('Object offline Download Icon/upSelling/offlineIcon'), 'alt'), count)

    count += 1
}

//check watch on TV text
if (WebUI.getAttribute(findTestObject('Object Repository/upSelling/watchOnTVIcon'), 'alt').equals(new Shahid().getTitle(
        GlobalVariable.Benefits, 'L', 8))) {
    TVCondition = true
	KeywordUtil.markPassed("watch on TV text matched")
} else {
    TVCondition = false
	KeywordUtil.markFailed("Watch on TV text not matched")
    new Shahid().updateResultSheet('Watch on TV Icon', new Shahid().getTitle(GlobalVariable.Benefits, 'L', 8), WebUI.getAttribute(
            findTestObject('Object Repository/upSelling/watchOnTVIcon'), 'alt'), count)

    count += 1
}

//Check CTA1
if (WebUI.getText(findTestObject('Object Repository/upSelling/joinNowButton')).equals(new Shahid().getTitle(GlobalVariable.Benefits,
		'L', 9))) {
	CTA2Condition = true
	KeywordUtil.markPassed("CTA1 text matched")
	
	
} else {
	CTA2Condition = false
	KeywordUtil.markFailed("CTA1 text not matched")
	new Shahid().updateResultSheet('CTA1', new Shahid().getTitle(GlobalVariable.Benefits, 'L', 9), WebUI.getText(findTestObject(
				'Object Repository/upSelling/joinNowButton')), count)
	
	count += 1
}

//check CTA2
if (WebUI.getText(findTestObject('Object Repository/upSelling/loginButton')).equals(new Shahid().getTitle(GlobalVariable.Benefits, 
        'L', 10))) {
    CTA1Condition = true
	KeywordUtil.markPassed("CTA2 text matched")
} else {
    CTA1Condition = false
	
	KeywordUtil.markFailed("CTA2 text not matched")

    new Shahid().updateResultSheet('CTA2', new Shahid().getTitle(GlobalVariable.Benefits, 'L', 10), WebUI.getText(findTestObject(
                'Object Repository/upSelling/loginButton')), count)

    count += 1
}


//WebUI.verifyImagePresent(findTestObject('Object Repository/upSelling/Images/Series/desktopUpsellPlayer'))


//Take screenshot
if (!((((((titleCondition && messageCondition) && HDCondition) && offlineCondition) && TVCondition) && CTA1Condition) && 
CTA2Condition)) {
    new Shahid().upSellingScreenshot(GlobalVariable.Benefits,testcaseName, 'Failed')
}