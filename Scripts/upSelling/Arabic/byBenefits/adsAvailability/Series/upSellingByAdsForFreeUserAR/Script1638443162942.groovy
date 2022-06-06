import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.annotation.Keyword as Keyword
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
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
String displayName = WebUI.getText(findTestObject('Object Repository/upSelling/displayName'))

if (displayName.equals(new Shahid().getUpsellTitle(GlobalVariable.Benefits, 'C', 3))) {
    titleCondition = true

    KeywordUtil.markPassed('Title text matched')
} else {
    titleCondition = false

    KeywordUtil.markFailed('Title text not matched')

    new Shahid().updateUpsellResultSheet('Title', GlobalVariable.Benefits, new Shahid().getUpsellTitle(GlobalVariable.Benefits, 
            'C', 3), displayName, count)

    count += 1
}

//Check Message
String message = WebUI.getText(findTestObject('Object Repository/upSelling/message'))

if (message.equals(new Shahid().getUpsellTitle(GlobalVariable.Benefits, 'C', 4))) {
    messageCondition = true

    KeywordUtil.markPassed('Message text matched')
} else {
    messageCondition = false

    KeywordUtil.markFailed('Message text not matched')

    new Shahid().updateUpsellResultSheet('Message', GlobalVariable.Benefits, new Shahid().getUpsellTitle(GlobalVariable.Benefits, 
            'C', 4), message, count)

    count += 1
}

//check HD text
String HDIcons = WebUI.getAttribute(findTestObject('Object Repository/upSelling/HDIcons'), 'alt')

if (HDIcons.equals(new Shahid().getUpsellTitle(GlobalVariable.Benefits, 'C', 5))) {
    HDCondition = true

    KeywordUtil.markPassed('HD Icon text matched')
} else {
    HDCondition = false

    KeywordUtil.markFailed('HD Icon text not matched')

    new Shahid().updateUpsellResultSheet('HD Icon', GlobalVariable.Benefits, new Shahid().getUpsellTitle(GlobalVariable.Benefits, 
            'C', 5), HDIcons, count)

    count += 1
}

//check offline text
String offlineIcon = WebUI.getAttribute(findTestObject('Object Repository/upSelling/offlineIcon'), 'alt')

if (offlineIcon.equals(new Shahid().getUpsellTitle(GlobalVariable.Benefits, 'C', 6))) {
    offlineCondition = true

    KeywordUtil.markPassed('offline text matched')
} else {
    offlineCondition = false

    KeywordUtil.markFailed('Offline download not matched')

    new Shahid().updateUpsellResultSheet('Offline download Icon', GlobalVariable.Benefits, new Shahid().getUpsellTitle(GlobalVariable.Benefits, 
            'C', 6), offlineIcon, count)

    count += 1
}

//check watch on TV text
watchOnTVIcon = WebUI.getAttribute(findTestObject('Object Repository/upSelling/watchOnTVIcon'), 'alt')

if (watchOnTVIcon.equals(new Shahid().getUpsellTitle(GlobalVariable.Benefits, 'C', 7))) {
    TVCondition = true

    KeywordUtil.markPassed('watch on TV text matched')
} else {
    TVCondition = false

    KeywordUtil.markFailed('Watch on TV text not matched')

    new Shahid().updateUpsellResultSheet('Watch on TV Icon', GlobalVariable.Benefits, new Shahid().getUpsellTitle(GlobalVariable.Benefits, 
            'C', 7), watchOnTVIcon, count)

    count += 1
}

//Check CTA1
joinNowButton = WebUI.getText(findTestObject('Object Repository/upSelling/joinNowButton'))

if (joinNowButton.equals(new Shahid().getUpsellTitle(GlobalVariable.Benefits, 'C', 8))) {
    CTA2Condition = true

    KeywordUtil.markPassed('CTA1 text matched')
} else {
    CTA2Condition = false

    KeywordUtil.markFailed('CTA1 text not matched')

    new Shahid().updateUpsellResultSheet('CTA1', GlobalVariable.Benefits, new Shahid().getUpsellTitle(GlobalVariable.Benefits, 
            'C', 8), joinNowButton, count)

    count += 1
}

//check CTA2
loginButton = WebUI.getText(findTestObject('Object Repository/upSelling/loginButton'))

if (loginButton.equals(new Shahid().getUpsellTitle(GlobalVariable.Benefits, 'C', 9))) {
    CTA1Condition = true

    KeywordUtil.markPassed('CTA2 text matched')
} else {
    CTA1Condition = false

    KeywordUtil.markFailed('CTA2 text not matched')

    new Shahid().updateUpsellResultSheet('CTA2', GlobalVariable.Benefits, new Shahid().getUpsellTitle(GlobalVariable.Benefits, 
            'C', 9), loginButton, count)

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