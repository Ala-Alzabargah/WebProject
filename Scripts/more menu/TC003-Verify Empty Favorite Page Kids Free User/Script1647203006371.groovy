import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import shahid.Common as Common
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

CustomKeywords.'shahid.Common.navigateToShahid'()
CustomKeywords.'shahid.Common.checkLanguage'()
CustomKeywords.'shahid.Common.login'(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
WebUI.waitForElementPresent(findTestObject('kidsProfile'), 10)
WebUI.delay(2)
WebUI.click(findTestObject('kidsProfile'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(2)
CustomKeywords.'shahid.Common.checkLanguage'()

if (WebUI.waitForElementVisible(findTestObject('loginThreeLanguages/hamburgerMenu'), 7)) {
    WebUI.click(findTestObject('loginThreeLanguages/hamburgerMenu'))

    WebUI.delay(3)

    Mobile.swipe(0, 1000, 0, 0)
}

WebUI.click(findTestObject('Object Repository/moreScreenThreeLanguages/myListButton'))
WebUI.verifyElementPresent(findTestObject(('Object Repository/loginThreeLanguages/' + GlobalVariable.objLanguage) + '/nothingInTheListText'),  3)

WebUI.verifyElementPresent(findTestObject(('Object Repository/moreScreenThreeLanguages/' + GlobalVariable.objLanguage) + '/addtoMyListButton'), 3)

if (WebUI.waitForElementVisible(findTestObject('loginThreeLanguages/hamburgerMenu'), 7)) {
    WebUI.click(findTestObject('loginThreeLanguages/hamburgerMenu'))
}

WebUI.click(findTestObject(('Object Repository/loginThreeLanguages/' + GlobalVariable.objLanguage) + '/exitKidsProfileButton'))

int x = 1

for (x; x < 5; x++) {
    String dynamicId = x

    String xpath = ('(//input[contains(@class,"PinCode")])[' + dynamicId) + ']'

    System.err.println('********** ' + xpath)

    TestObject to = new TestObject('objectName')

    to.addProperty('xpath', ConditionType.EQUALS, xpath)

    WebUI.sendKeys(to, '1')
}

WebUI.waitForElementPresent(findTestObject('kidsProfile'), 10)
WebUI.delay(2)
WebUI.click(findTestObject('kidsProfile'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(2)

  WebUI.closeBrowser()
