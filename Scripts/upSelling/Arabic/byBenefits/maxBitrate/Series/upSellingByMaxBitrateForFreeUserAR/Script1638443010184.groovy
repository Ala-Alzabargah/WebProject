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
String displayName = WebUI.getText(findTestObject('Object Repository/upSelling/displayName'))
String excelDisplayName=new Shahid().getUpsellTitle(GlobalVariable.Benefits, 'L', 13)
if (displayName.equals(excelDisplayName)) {
    titleCondition = true
	KeywordUtil.markPassed("Title text matched")
} else {
    titleCondition = false
	KeywordUtil.markFailed("Title text not matched")
    new Shahid().updateUpsellResultSheet('Title',GlobalVariable.Benefits, excelDisplayName, displayName, count)

    count += 1
}

//Check Message
String message = WebUI.getText(findTestObject('Object Repository/upSelling/message'))
String excelMessage =new Shahid().getUpsellTitle(GlobalVariable.Benefits, 'L', 14)

if (message.equals(excelMessage)){
    messageCondition = true
	KeywordUtil.markPassed("Message text matched")
} else {
    messageCondition = false
	KeywordUtil.markFailed("Message text not matched")
    new Shahid().updateUpsellResultSheet('Message',GlobalVariable.Benefits, excelMessage, message, count)
    count += 1
}

//check HD text
String HDIcons = WebUI.getAttribute(findTestObject('Object Repository/upSelling/HDIcons'), 'alt')
String excelHDIcons=new Shahid().getUpsellTitle(GlobalVariable.Benefits, 'L', 15)

if (HDIcons.equals(excelHDIcons)) {
    HDCondition = true

    KeywordUtil.markPassed('HD Icon text matched')
} else {
    HDCondition = false

    KeywordUtil.markFailed('HD Icon text not matched')

    new Shahid().updateUpsellResultSheet('HD Icon', GlobalVariable.Benefits, excelHDIcons, HDIcons, count)

    count += 1
}

//check offline text
String offlineIcon = WebUI.getAttribute(findTestObject('Object Repository/upSelling/offlineIcon'), 'alt')
String excelOfflineIcon = new Shahid().getUpsellTitle(GlobalVariable.Benefits, 'L', 16)

if (offlineIcon.equals(excelOfflineIcon)) {
    offlineCondition = true

    KeywordUtil.markPassed('offline text matched')
} else {
    offlineCondition = false

    KeywordUtil.markFailed('Offline download not matched')

    new Shahid().updateUpsellResultSheet('Offline download Icon', GlobalVariable.Benefits, excelOfflineIcon, offlineIcon, count)

    count += 1
}

//check watch on TV text
String watchOnTVIcon = WebUI.getAttribute(findTestObject('Object Repository/upSelling/watchOnTVIcon'), 'alt')
String excelWatchOnTVIcon = new Shahid().getUpsellTitle(GlobalVariable.Benefits, 'L', 17)

if (watchOnTVIcon.equals(excelWatchOnTVIcon)) {
    TVCondition = true

    KeywordUtil.markPassed('watch on TV text matched')
} else {
    TVCondition = false

    KeywordUtil.markFailed('Watch on TV text not matched')

    new Shahid().updateUpsellResultSheet('Watch on TV Icon', GlobalVariable.Benefits, excelWatchOnTVIcon, watchOnTVIcon, count)

    count += 1
}

//Check CTA1
String joinNowButton = WebUI.getText(findTestObject('Object Repository/upSelling/joinNowButton'))
String excelJoinNowButton = new Shahid().getUpsellTitle(GlobalVariable.Benefits, 'L', 18)

if (joinNowButton.equals(excelJoinNowButton)) {
    CTA2Condition = true

    KeywordUtil.markPassed('CTA1 text matched')
} else {
    CTA2Condition = false

    KeywordUtil.markFailed('CTA1 text not matched')

    new Shahid().updateUpsellResultSheet('CTA1', GlobalVariable.Benefits, excelJoinNowButton, joinNowButton, count)

    count += 1
}

//check CTA2
String loginButton = WebUI.getText(findTestObject('Object Repository/upSelling/loginButton'))
String excelLoginButton = new Shahid().getUpsellTitle(GlobalVariable.Benefits, 'L', 19)

if (loginButton.equals(excelLoginButton)) {
    CTA1Condition = true

    KeywordUtil.markPassed('CTA2 text matched')
} else {
    CTA1Condition = false

    KeywordUtil.markFailed('CTA2 text not matched')

    new Shahid().updateUpsellResultSheet('CTA2', GlobalVariable.Benefits, excelLoginButton, loginButton, count)

    count += 1
}

WebUI.verifyImagePresent(findTestObject('Object Repository/upSelling/Images/Series/desktopUpsellPlayer_upsellImg'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyImagePresent(findTestObject('Object Repository/upSelling/Images/Series/hdIcon'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyImagePresent(findTestObject('Object Repository/upSelling/Images/Series/offlineDownloadIcon'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyImagePresent(findTestObject('Object Repository/upSelling/Images/Series/watchOnTVIcon'), FailureHandling.CONTINUE_ON_FAILURE)

//Take screenshot
if (!((((((titleCondition && messageCondition) && HDCondition) && offlineCondition) && TVCondition) && CTA1Condition) && 
CTA2Condition)) {
    new Shahid().upSellingScreenshot(GlobalVariable.Benefits, testcaseName, 'Failed')
}