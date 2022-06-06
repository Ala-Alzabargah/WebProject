import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.github.javafaker.Faker as Faker
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
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



    List<WebElement> UserProfile = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))

    WebUI.delay(2)

    int ListsizeBeforedelete = UserProfile.size()

    WebUI.click(findTestObject('Object Repository/UserProfile/profileManagementIcon'))

    WebUI.waitForPageLoad(10)

    String User = new Common().getUserProfileName(userType, GlobalVariable.Adult)

    Faker faker = new Faker()

    String newUser = faker.name().firstName()

    WebUI.delay(2)
   new Common().swipe(600)   
	 WebElement element = driver.findElement(By.xpath(('//img[not(@class) and @alt=\'' + User) + '\']'))

    JavascriptExecutor executor = ((driver) as JavascriptExecutor)

    executor.executeScript('arguments[0].click();', element)

    WebUI.waitForPageLoad(10)

    WebUI.click(findTestObject('Object Repository/UserProfile/deleteProfileIcon'))

    WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/deletePopupTilte'), 6)

    WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/deletePopupDescriptionText'), 4)

    WebUI.click(findTestObject('Object Repository/UserProfile/deletePopupcloseButton'))

    WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/closeButton'), 6)

    WebUI.click(findTestObject('Object Repository/UserProfile/closeButton'))

    WebUI.delay(2)

    WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/closeButton'), 6)

    WebUI.click(findTestObject('Object Repository/UserProfile/closeButton'))

    List<WebElement> UserProfile2 = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))

    int ListsizeAfterdelete22 = UserProfile2.size()

    println('List Size After Delete::' + ListsizeAfterdelete22)

    WebUI.verifyEqual(ListsizeAfterdelete22, ListsizeBeforedelete)

    WebUI.click(findTestObject('Object Repository/UserProfile/profileManagementIcon'))

    WebUI.delay(4)

    WebElement element1 = driver.findElement(By.xpath(('//img[not(@class) and @alt=\'' + User) + '\']'))

    JavascriptExecutor executor1 = ((driver) as JavascriptExecutor)

    executor1.executeScript('arguments[0].click();', element1)

    WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/deleteProfileIcon'), 6)

    WebUI.click(findTestObject('Object Repository/UserProfile/deleteProfileIcon'))

    WebUI.delay(1)

    WebUI.click(findTestObject('Object Repository/UserProfile/deletePopupButton'))

    WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/deleteProfileSuccessfullyText'), 7)

    WebUI.delay(2)

    List<WebElement> UserProfile9 = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))

    int ListsizeAfterdelete1 = UserProfile9.size()

    println('List Size After Delete::' + ListsizeAfterdelete22)

    WebUI.verifyLessThan(ListsizeAfterdelete1, ListsizeBeforedelete)
}

WebUI.closeBrowser()