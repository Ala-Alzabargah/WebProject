import org.openqa.selenium.By as By
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import shahid.Common as Common

new Common().navigateToShahid()

WebUI.navigateToUrl(GlobalVariable.contentWithADs)

WebUI.waitForPageLoad(10)

WebDriver driver = DriverFactory.getWebDriver()

//
//JavascriptExecutor executor = ((driver) as JavascriptExecutor)
////
//////WebElement pauseButton = driver.findElement(By.xpath('(//button[@type=\'button\' and contains(@class,\'playing\')])[1]'))
//////
//////executor.executeScript('arguments[0].click();', pauseButton)
List adCues = driver.findElements(By.className('adCue'))

for (int i = 0; i <= adCues.size(); i++) {
    WebUI.clickOffset(findTestObject('Object Repository/VideoPlaybackScreen/playProgress'), 750, 0)

    WebUI.verifyElementPresent(findTestObject('Object Repository/ADs/ADsLabel'), 5)

    WebUI.verifyElementPresent(findTestObject('Object Repository/ADs/ADCountdown'), 5)

    String adCountdown = WebUI.getText(findTestObject('Object Repository/Player/adCountdown'))

    println('*******adCountdown:: ' + adCountdown)

    int adTime = (adCountdown[(-2..-1)]).toInteger()

    WebUI.waitForElementNotVisible(findTestObject('Object Repository/Player/adsContainer'), adTime + 5)
}