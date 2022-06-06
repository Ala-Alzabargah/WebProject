import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import shahid.Common as Common

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

WebDriver driver = DriverFactory.getWebDriver()

String testcaseName = RunConfiguration.getExecutionSourceName().toString()

new Common().login(GlobalVariable.FreeUser, GlobalVariable.FreeUserPassword)

new Common().selectUser()

new Common().checkLanguage()

WebUI.navigateToUrl('http://fw.to/qDzbOXL')

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/upSelling/HDToggle'))

//Check Title
if (WebUI.getText(findTestObject('Object Repository/upSelling/displayName')).equals(new Common().getUpsellTitle(GlobalVariable.Benefits, 
        'L', 13))) {
    titleCondition = true

    KeywordUtil.markPassed('Title text matched')
} else {
    titleCondition = false

    KeywordUtil.markFailed('Title text not matched')

    new Common().updateUpsellResultSheet(GlobalVariable.Benefits, 'Title', new Common().getUpsellTitle(GlobalVariable.Benefits, 
            'L', 13), WebUI.getText(findTestObject('Object Repository/upSelling/displayName')), count)

    count += 1
}

//Check Message
if (WebUI.getText(findTestObject('Object Repository/upSelling/message')).equals(new Common().getUpsellTitle(GlobalVariable.Benefits, 
        'L', 14))) {
    messageCondition = true

    KeywordUtil.markPassed('Message text matched')
} else {
    messageCondition = false

    KeywordUtil.markFailed('Message text not matched')

    new Common().updateUpsellResultSheet('Message', GlobalVariable.Benefits, new Common().getUpsellTitle(GlobalVariable.Benefits, 
            'L', 14), WebUI.getText(findTestObject('Object Repository/upSelling/message')), count)

    count += 1
}

//check HD text
if (WebUI.getAttribute(findTestObject('Object Repository/upSelling/HDIcons'), 'alt').equals(new Common().getUpsellTitle(
        GlobalVariable.Benefits, 'L', 15))) {
    HDCondition = true

    KeywordUtil.markPassed('HD Icon text matched')
} else {
    HDCondition = false

    KeywordUtil.markFailed('HD Icon text not matched')

    new Common().updateUpsellResultSheet('HD Icon', GlobalVariable.Benefits, new Common().getUpsellTitle(GlobalVariable.Benefits, 
            'L', 15), WebUI.getAttribute(findTestObject('Object Repository/upSelling/HDIcons'), 'alt'), count)

    count += 1
}

//check offline text
if (WebUI.getAttribute(findTestObject('Object Repository/upSelling/offlineIcon'), 'alt').equals(new Common().getUpsellTitle(
        GlobalVariable.Benefits, 'L', 16))) {
    offlineCondition = true

    KeywordUtil.markPassed('offline text matched')
} else {
    offlineCondition = false

    KeywordUtil.markFailed('Offline download not matched')

    new Common().updateUpsellResultSheet('Offline download Icon', GlobalVariable.Benefits, new Common().getUpsellTitle(GlobalVariable.Benefits, 
            'L', 16), WebUI.getAttribute(findTestObject('Object Repository/upSelling/offlineIcon'), 'alt'), count)

    count += 1
}

//check watch on TV text
if (WebUI.getAttribute(findTestObject('Object Repository/upSelling/watchOnTVIcon'), 'alt').equals(new Common().getUpsellTitle(
        GlobalVariable.Benefits, 'L', 17))) {
    TVCondition = true

    KeywordUtil.markPassed('watch on TV text matched')
} else {
    TVCondition = false

    KeywordUtil.markFailed('Watch on TV text not matched')

    new Common().updateUpsellResultSheet('Watch on TV Icon', GlobalVariable.Benefits, new Common().getUpsellTitle(GlobalVariable.Benefits, 
            'L', 17), WebUI.getAttribute(findTestObject('Object Repository/upSelling/watchOnTVIcon'), 'alt'), count)

    count += 1
}

//Check CTA1
if (WebUI.getText(findTestObject('Object Repository/upSelling/joinNowButton')).equals(new Common().getUpsellTitle(GlobalVariable.Benefits, 
        'L', 18))) {
    CTA2Condition = true

    KeywordUtil.markPassed('CTA1 text matched')
} else {
    CTA2Condition = false

    KeywordUtil.markFailed('CTA1 text not matched')

    new Common().updateUpsellResultSheet('CTA1', GlobalVariable.Benefits, new Common().getUpsellTitle(GlobalVariable.Benefits, 
            'L', 18), WebUI.getText(findTestObject('Object Repository/upSelling/joinNowButton')), count)

    count += 1
}

//check CTA2
if (WebUI.getText(findTestObject('Object Repository/upSelling/loginButton')).equals(new Common().getUpsellTitle(GlobalVariable.Benefits, 
        'L', 19))) {
    CTA1Condition = true

    KeywordUtil.markPassed('CTA2 text matched')
} else {
    CTA1Condition = false

    KeywordUtil.markFailed('CTA2 text not matched')

    new Common().updateUpsellResultSheet('CTA2', GlobalVariable.Benefits, new Common().getUpsellTitle(GlobalVariable.Benefits, 
            'L', 19), WebUI.getText(findTestObject('Object Repository/upSelling/loginButton')), count)

    count += 1
}

//Check displayImage
if (WebUI.verifyImagePresent(findTestObject('Object Repository/upSelling/Images/Series/desktopUpsellPlayer_upsellImg'), 
    FailureHandling.CONTINUE_ON_FAILURE)) {
    displayImageCondition = true

    KeywordUtil.markPassed('DisplayImage matched')
} else {
    displayImageCondition = false

    KeywordUtil.markFailed('Display Image not matched')

    new Common().updateUpsellResultSheet(GlobalVariable.Benefits, 'Display Image', 'check screenshots', 'check screenshots', 
        count)

    count += 1
}

//Check HD Icon
if (WebUI.verifyImagePresent(findTestObject('Object Repository/upSelling/Images/Series/hdIcon'), FailureHandling.CONTINUE_ON_FAILURE)) {
    HDIconCondition = true

    KeywordUtil.markPassed('HD Icon matched')
} else {
    HDIconCondition = false

    KeywordUtil.markFailed('HD Icon not matched')

    new Common().updateUpsellResultSheet(GlobalVariable.Benefits, 'HD Icon', 'check screenshots', 'check screenshots', count)

    count += 1
}

//Check offline download Icon
if (WebUI.verifyImagePresent(findTestObject('Object Repository/upSelling/Images/Series/offlineDownloadIcon'), FailureHandling.CONTINUE_ON_FAILURE)) {
    offlineIconCondition = true

    KeywordUtil.markPassed('Offline download icon matched')
} else {
    offlineIconCondition = false

    KeywordUtil.markFailed('Offline download icon not matched')

    new Common().updateUpsellResultSheet(GlobalVariable.Benefits, 'offline Icon', 'check screenshots', 'check screenshots', 
        count)

    count += 1
}

//Check watch on TV Icon
if (WebUI.verifyImagePresent(findTestObject('Object Repository/upSelling/Images/Series/watchOnTVIcon'), FailureHandling.CONTINUE_ON_FAILURE)) {
    TVIconCondition = true

    KeywordUtil.markPassed('Watch on TV Icon matched')
} else {
    TVIconCondition = false

    KeywordUtil.markFailed('Watch on TV Icon not matched')

    new Common().updateUpsellResultSheet(GlobalVariable.Benefits, 'Watch on TV Icon', 'check screenshots', 'check screenshots', 
        count)

    count += 1
}

//Take screenshot
if (!((((((((((titleCondition && messageCondition) && HDCondition) && offlineCondition) && TVCondition) && CTA1Condition) && 
CTA2Condition) && displayImageCondition) && HDIconCondition) && offlineIconCondition) && TVIconCondition)) {
    new Common().upSellingScreenshot(GlobalVariable.Benefits, testcaseName, 'Failed')
}


WebUI.closeBrowser()