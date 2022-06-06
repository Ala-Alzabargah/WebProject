import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.testdata.TestData as TestData
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import shahid.Common as Common

new Common().navigateToShahid()

WebDriver driver = DriverFactory.getWebDriver()

new Common().login(GlobalVariable.VipUser, GlobalVariable.VipUserPassword)

new Common().selectUser()

String CWAssetXpath

String CWAssetDescriptionText

String assetInfo

for (int i = 1; i <= 1; i++) {
    new Common().ScrollUntilElementPresent('Object Repository/HomeScreen/CW/CWCarousel')

    WebUI.scrollToElement(findTestObject('Object Repository/HomeScreen/CW/CWCarouselTitle'), 3)

    WebUI.scrollToElement(findTestObject('Object Repository/HomeScreen/CW/CWFirstItem'), 3)

    WebUI.delay(2)

    WebElement CWCarousel = driver.findElement(By.xpath('//h2[text()=\'Continue Watching\' or text()=\'متابعة المشاهدة\']//following::div[contains(@class,\'Slider_slider__container\')][1]'))

    CWAssetXpath = '(//h2[text()=\'Continue Watching\' or text()=\'متابعة المشاهدة\']//following::div[contains(@class,\'Slider_item\')])['

    CWAssetXpath = ((CWAssetXpath + i) + ']')

    TestObject CWAsset = WebUI.modifyObjectProperty(findTestObject('Object Repository/HomeScreen/CW/CWThumbnail'), 'xpath', 
        'equals', CWAssetXpath, true)

    WebUI.delay(3)

    WebUI.scrollToElement(CWAsset, 4)

    WebUI.mouseOver(CWAsset)

    String CWAssetDescriptionXpath = '//div[contains(@class,\'item_logoTitle\')]//img[@style]'

    CWAssetDescriptionXpath = (CWAssetDescriptionXpath + [i])

    println('CWAssetDescriptionXpath:: ' + CWAssetDescriptionXpath)

    TestObject CWAssetDescription = WebUI.modifyObjectProperty(findTestObject('Object Repository/VideoPlaybackScreen/CWAssetDescription'), 
        'xpath', 'equals', CWAssetDescriptionXpath, true)

    String assetTitle = WebUI.getAttribute(CWAssetDescription, 'title')

    println('*********assetTitle before remove:: ' + assetTitle)

    WebUI.mouseOver(CWAsset)

    WebUI.click(findTestObject('Object Repository/HomeScreen/CW/removeItem'))

    WebUI.delay(3)

    WebUI.refresh()

    new Common().ScrollUntilElementPresent('Object Repository/HomeScreen/CW/CWCarousel')

    WebUI.scrollToElement(findTestObject('Object Repository/HomeScreen/CW/CWCarouselTitle'), 3)

    WebUI.scrollToElement(findTestObject('Object Repository/HomeScreen/CW/CWFirstItem'), 3)

    WebUI.delay(2)

    CWAssetXpath = '(//h2[text()=\'Continue Watching\' or text()=\'متابعة المشاهدة\']//following::div[contains(@class,\'Slider_item\')])['

    CWAssetXpath = ((CWAssetXpath + i) + ']')

    CWAsset = WebUI.modifyObjectProperty(findTestObject('Object Repository/HomeScreen/CW/CWThumbnail'), 'xpath', 'equals', 
        CWAssetXpath, true)

    WebUI.delay(3)

    WebUI.scrollToElement(CWAsset, 4)

    CWAssetDescriptionXpath = (CWAssetDescriptionXpath + [i])

    println('CWAssetDescriptionXpath:: ' + CWAssetDescriptionXpath)

    CWAssetDescription = WebUI.modifyObjectProperty(findTestObject('Object Repository/VideoPlaybackScreen/CWAssetDescription'), 
        'xpath', 'equals', CWAssetDescriptionXpath, true)

    String FirstAssetTitleAfterRemove = WebUI.getAttribute(CWAssetDescription, 'title')

    println('*********FirstAssetTitleAfterRemove before remove:: ' + FirstAssetTitleAfterRemove)

//    if (FirstAssetTitleAfterRemove.equals(assetTitle)) {
//        KeywordUtil.markFailed('assent not remove from CW carousel -Asset name: ' + FirstAssetTitleAfterRemove)
//    } else {
//        KeywordUtil.markPassed('assent removed from CW carousel -Asset name: ' + assetTitle)
//    }
}

WebUI.closeBrowser()