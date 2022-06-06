import static com.kms.katalon.core.testdata.TestDataFactory.findTestData

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import shahid.Common as Common
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

new Common().navigateToShahid()

WebDriver driver = DriverFactory.getWebDriver()

int Listsize

List<WebElement> top10

new Common().checkLanguage()

WebUI.waitForPageLoad(8)


    CustomKeywords.'shahid.Common.scrollElementIntoViewMore'()
	WebUI.delay(1)
	CustomKeywords.'shahid.Common.scrollElementIntoViewMore'()
	WebUI.delay(1)
	CustomKeywords.'shahid.Common.scrollElementIntoViewMore'()
	WebUI.delay(1)
	CustomKeywords.'shahid.Common.scrollElementIntoViewMore'()
	WebUI.delay(1)
	CustomKeywords.'shahid.Common.scrollElementIntoViewMore'()

WebUI.scrollToElement(findTestObject(('LandingPages/' + GlobalVariable.objLanguage) + '/top10CarouselTitle'), 10)

top10 = driver.findElements(By.xpath("//div[contains(@class,'TopRanking_landscape')]"))

Listsize = top10.size()

if (Listsize != 10) {
    KeywordUtil.markFailedAndStop('top 10 Carousel dosent have 10 elements')
}

WebUI.closeBrowser()

