import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.Common

boolean titleCondition

boolean messageCondition

boolean HDCondition

boolean offlineCondition

boolean TVCondition

boolean CTA1Condition

boolean CTA2Condition

int count = 2

new Common().navigateToShahid()

new Common().login(GlobalVariable.FreeUser, GlobalVariable.FreeUserPassword)

new Common().selectUser()

WebDriver driver = DriverFactory.getWebDriver()

String testcaseName = RunConfiguration.getExecutionSourceName().toString()

WebUI.navigateToUrl('http://fw.to/qDzbOXL')

WebUI.waitForPageLoad(6)

WebUI.click(findTestObject('Object Repository/upSelling/noAds'))

//Check Title
String displayName = WebUI.getText(findTestObject('Object Repository/upSelling/displayName'))

if (displayName.equals(new Common().getUpsellTitle(GlobalVariable.Benefits, 'L', 3))) {
    titleCondition = true

    KeywordUtil.markPassed('Title text matched')
} else {
    titleCondition = false

    KeywordUtil.markFailed('Title text not matched')

    new Common().updateUpsellResultSheet('Title', GlobalVariable.Benefits, new Common().getUpsellTitle(GlobalVariable.Benefits, 
            'L', 3), displayName, count)

    count += 1
}

//Check Message
String message = WebUI.getText(findTestObject('Object Repository/upSelling/message'))

if (message.equals(new Common().getUpsellTitle(GlobalVariable.Benefits, 'L', 4))) {
    messageCondition = true

    KeywordUtil.markPassed('Message text matched')
} else {
    messageCondition = false

    KeywordUtil.markFailed('Message text not matched')

    new Common().updateUpsellResultSheet('Message', GlobalVariable.Benefits, new Common().getUpsellTitle(GlobalVariable.Benefits, 
            'L', 4), message, count)

    count += 1
}

//check HD text
String HDIcons = WebUI.getAttribute(findTestObject('Object Repository/upSelling/HDIcons'), 'alt')

if (HDIcons.equals(new Common().getUpsellTitle(GlobalVariable.Benefits, 'L', 5))) {
    HDCondition = true

    KeywordUtil.markPassed('HD Icon text matched')
} else {
    HDCondition = false

    KeywordUtil.markFailed('HD Icon text not matched')

    new Common().updateUpsellResultSheet('HD Icon', GlobalVariable.Benefits, new Common().getUpsellTitle(GlobalVariable.Benefits, 
            'L', 5), HDIcons, count)

    count += 1
}

//check offline text
String offlineIcon = WebUI.getAttribute(findTestObject('Object Repository/upSelling/offlineIcon'), 'alt')

if (offlineIcon.equals(new Common().getUpsellTitle(GlobalVariable.Benefits, 'L', 6))) {
    offlineCondition = true

    KeywordUtil.markPassed('offline text matched')
} else {
    offlineCondition = false

    KeywordUtil.markFailed('Offline download not matched')

    new Common().updateUpsellResultSheet('Offline download Icon', GlobalVariable.Benefits, new Common().getUpsellTitle(GlobalVariable.Benefits, 
            'L', 6), offlineIcon, count)

    count += 1
}

//check watch on TV text
watchOnTVIcon = WebUI.getAttribute(findTestObject('Object Repository/upSelling/watchOnTVIcon'), 'alt')

if (watchOnTVIcon.equals(new Common().getUpsellTitle(GlobalVariable.Benefits, 'L', 7))) {
    TVCondition = true

    KeywordUtil.markPassed('watch on TV text matched')
} else {
    TVCondition = false

    KeywordUtil.markFailed('Watch on TV text not matched')

    new Common().updateUpsellResultSheet('Watch on TV Icon', GlobalVariable.Benefits, new Common().getUpsellTitle(GlobalVariable.Benefits, 
            'L', 7), watchOnTVIcon, count)

    count += 1
}

//Check CTA1
joinNowButton = WebUI.getText(findTestObject('Object Repository/upSelling/joinNowButton'))

if (joinNowButton.equals(new Common().getUpsellTitle(GlobalVariable.Benefits, 'L', 8))) {
    CTA2Condition = true

    KeywordUtil.markPassed('CTA1 text matched')
} else {
    CTA2Condition = false

    KeywordUtil.markFailed('CTA1 text not matched')

    new Common().updateUpsellResultSheet('CTA1', GlobalVariable.Benefits, new Common().getUpsellTitle(GlobalVariable.Benefits, 
            'L', 8), joinNowButton, count)

    count += 1
}

//check CTA2
loginButton = WebUI.getText(findTestObject('Object Repository/upSelling/loginButton'))

if (loginButton.equals(new Common().getUpsellTitle(GlobalVariable.Benefits, 'L', 9))) {
    CTA1Condition = true

    KeywordUtil.markPassed('CTA2 text matched')
} else {
    CTA1Condition = false

    KeywordUtil.markFailed('CTA2 text not matched')

    new Common().updateUpsellResultSheet('CTA2', GlobalVariable.Benefits, new Common().getUpsellTitle(GlobalVariable.Benefits, 
            'L', 9), loginButton, count)

    count += 1
}

WebUI.verifyImagePresent(findTestObject('Object Repository/upSelling/Images/Series/desktopUpsellPlayer_upsellImg'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyImagePresent(findTestObject('Object Repository/upSelling/Images/Series/hdIcon'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyImagePresent(findTestObject('Object Repository/upSelling/Images/Series/offlineDownloadIcon'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyImagePresent(findTestObject('Object Repository/upSelling/Images/Series/watchOnTVIcon'), FailureHandling.CONTINUE_ON_FAILURE)

//Take screenshot
if (!((((((titleCondition && messageCondition) && HDCondition) && offlineCondition) && TVCondition) && CTA1Condition) && 
CTA2Condition)) {
    new Common().upSellingScreenshot(GlobalVariable.Benefits, testcaseName, 'Failed')
}

WebUI.closeBrowser()