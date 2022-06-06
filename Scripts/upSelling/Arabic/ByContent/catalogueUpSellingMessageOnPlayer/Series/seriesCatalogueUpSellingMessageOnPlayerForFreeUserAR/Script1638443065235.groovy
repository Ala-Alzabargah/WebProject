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


new Shahid().shahidLogin(GlobalVariable.upSellingRegisteredUser, GlobalVariable.upSellingRegisteredPassword)

new Shahid().selectUser(0)

WebUI.navigateToUrl('https://shahid.mbc.net/ar/series/%D8%A7%D9%84%D9%85%D8%B4%D9%87%D8%AF-%D8%A7%D9%84%D8%A3%D8%AE%D9%8A%D8%B1-%D8%A7%D9%84%D9%85%D9%88%D8%B3%D9%85-1-%D8%A7%D9%84%D8%AD%D9%84%D9%82%D8%A9-1/episode-916022')
WebUI.delay(2)

//Check Title
String displayName = WebUI.getText(findTestObject('Object Repository/upSelling/displayName'))
String excelDisplayName=new Shahid().getUpsellTitle(GlobalVariable.Content, 'C', 3)
if (displayName.equals(excelDisplayName)) {
    titleCondition = true
	KeywordUtil.markPassed("Title text matched")
} else {
    titleCondition = false
	KeywordUtil.markFailed("Title text not matched")
    new Shahid().updateUpsellResultSheet('Title',GlobalVariable.Content, excelDisplayName, displayName, count)

    count += 1
}

//Check Message
String message = WebUI.getText(findTestObject('Object Repository/upSelling/message'))
String excelMessage =new Shahid().getUpsellTitle(GlobalVariable.Content, 'C', 5)

if (message.equals(excelMessage)){
    messageCondition = true
	KeywordUtil.markPassed("Message text matched")
} else {
    messageCondition = false
	KeywordUtil.markFailed("Message text not matched")
    new Shahid().updateUpsellResultSheet('Message',GlobalVariable.Content, excelMessage, message, count)
    count += 1
}

//check HD text
String HDIcons = WebUI.getAttribute(findTestObject('Object Repository/upSelling/HDIcons'), 'alt')
String excelHDIcons=new Shahid().getUpsellTitle(GlobalVariable.Content, 'C', 6)

if (HDIcons.equals(excelHDIcons)) {
    HDCondition = true

    KeywordUtil.markPassed('HD Icon text matched')
} else {
    HDCondition = false

    KeywordUtil.markFailed('HD Icon text not matched')

    new Shahid().updateUpsellResultSheet('HD Icon', GlobalVariable.Content, excelHDIcons, HDIcons, count)

    count += 1
}

//check offline text
String offlineIcon = WebUI.getAttribute(findTestObject('Object Repository/upSelling/offlineIcon'), 'alt')
String excelOfflineIcon = new Shahid().getUpsellTitle(GlobalVariable.Content, 'C', 7)

if (offlineIcon.equals(excelOfflineIcon)) {
    offlineCondition = true

    KeywordUtil.markPassed('offline text matched')
} else {
    offlineCondition = false

    KeywordUtil.markFailed('Offline download not matched')

    new Shahid().updateUpsellResultSheet('Offline download Icon', GlobalVariable.Content, excelOfflineIcon, offlineIcon, count)

    count += 1
}

//check watch on TV text
String watchOnTVIcon = WebUI.getAttribute(findTestObject('Object Repository/upSelling/watchOnTVIcon'), 'alt')
String excelWatchOnTVIcon = new Shahid().getUpsellTitle(GlobalVariable.Content, 'C', 8)

if (watchOnTVIcon.equals(excelWatchOnTVIcon)) {
    TVCondition = true

    KeywordUtil.markPassed('watch on TV text matched')
} else {
    TVCondition = false

    KeywordUtil.markFailed('Watch on TV text not matched')

    new Shahid().updateUpsellResultSheet('Watch on TV Icon', GlobalVariable.Content, excelWatchOnTVIcon, watchOnTVIcon, count)

    count += 1
}

//Check CTA1
String joinNowButton = WebUI.getText(findTestObject('Object Repository/upSelling/joinNowButton'))
String excelJoinNowButton = new Shahid().getUpsellTitle(GlobalVariable.Content, 'C', 9)

if (joinNowButton.equals(excelJoinNowButton)) {
    CTA2Condition = true

    KeywordUtil.markPassed('CTA1 text matched')
} else {
    CTA2Condition = false

    KeywordUtil.markFailed('CTA1 text not matched')

    new Shahid().updateUpsellResultSheet('CTA1', GlobalVariable.Content, excelJoinNowButton, joinNowButton, count)

    count += 1
}


WebUI.verifyImagePresent(findTestObject('Object Repository/upSelling/Images/Series/desktopUpsellPlayer_upsellImg'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyImagePresent(findTestObject('Object Repository/upSelling/Images/Series/hdIcon'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyImagePresent(findTestObject('Object Repository/upSelling/Images/Series/offlineDownloadIcon'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyImagePresent(findTestObject('Object Repository/upSelling/Images/Series/watchOnTVIcon'), FailureHandling.CONTINUE_ON_FAILURE)

//Take screenshot
if (!((((((titleCondition && messageCondition) && HDCondition) && offlineCondition) && TVCondition) && CTA1Condition) && 
CTA2Condition)) {
    new Shahid().upSellingScreenshot(GlobalVariable.Content, testcaseName, 'Failed')
}