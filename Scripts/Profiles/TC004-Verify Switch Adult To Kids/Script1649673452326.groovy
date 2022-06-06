import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.github.javafaker.Faker as Faker
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import shahid.Common
import internal.GlobalVariable as GlobalVariable

TestData UsersData = findTestData('Data Files/Users')

String userType

lastRow = UsersData.getAllData().size()

for (int i = 1; i <= lastRow; i++) {
    userType = UsersData.getValue(1, i)

    new Common().navigateToShahid()

    WebDriver driver = DriverFactory.getWebDriver()

    new Common().checkLanguage()

    new Common().login(UsersData.getValue(2, i), UsersData.getValue(3, i))

    WebUI.waitForPageLoad(10)

    new Common().checkLanguage()

    WebUI.click(findTestObject('Object Repository/UserProfile/profileManagementIcon'))

    WebUI.waitForPageLoad(10)

    String user = new Common().getUserProfileName(userType, GlobalVariable.Adult)

    WebUI.delay(2)

    WebElement element = driver.findElement(By.xpath(('//img[not(@class) and @alt=\'' + user) + '\']'))

    JavascriptExecutor executor = ((driver) as JavascriptExecutor)

    executor.executeScript('arguments[0].click();', element)

    WebUI.waitForPageLoad(10)

    WebUI.click(findTestObject('Object Repository/UserProfile/switchToKidsProfile'))

    WebUI.delay(1)

    WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/deleteSwitchPopupTilte'), 4)

    WebUI.verifyElementPresent(findTestObject('Object Repository/'+GlobalVariable.objLanguage+'/UserProfile/deleteSwitchPopupDescriptionText'), 4)

    WebUI.click(findTestObject('Object Repository/'+GlobalVariable.objLanguage+'/UserProfile/deleteSwitchPopupcloseButton'))

    WebUI.verifyElementNotPresent(findTestObject('Object Repository/UserProfile/Kids Interface/kidBirthdateField'), 2)

    WebUI.verifyElementNotPresent(findTestObject('Object Repository/UserProfile/Kids Interface/isAgeRestrictedCheckbox'), 
        2)

    WebUI.verifyElementNotPresent(findTestObject('Object Repository/'+GlobalVariable.objLanguage+'/UserProfile/Kids Interface/ageRestrictedText'), 2)

    WebUI.click(findTestObject('Object Repository/UserProfile/closeButton'))

    WebUI.delay(2)

    WebUI.click(findTestObject('Object Repository/UserProfile/closeButton'))

    WebUI.delay(2)

    WebUI.click(findTestObject('Object Repository/UserProfile/profileManagementIcon'))

    WebUI.delay(2)

    WebElement element2 = driver.findElement(By.xpath(('//img[not(@class) and @alt=\'' + user) + '\']'))

    JavascriptExecutor executor2 = ((driver) as JavascriptExecutor)

    executor2.executeScript('arguments[0].click();', element2)

    WebUI.click(findTestObject('Object Repository/UserProfile/switchToKidsProfile'))

    WebUI.delay(1)

    WebUI.click(findTestObject('Object Repository/UserProfile/deleteSwitchPopupButton'))

    WebUI.click(findTestObject('Object Repository/UserProfile/createButton'))

    if (WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/updateProfileSuccessfullyText'), 10)) {
        new Common().getRandomName(userType, user, GlobalVariable.Kids)
    } else {
        KeywordUtil.markFailedAndStop('Wrong error message appear')
    }
}

WebUI.closeBrowser()