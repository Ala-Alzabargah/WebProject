import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.github.javafaker.Faker as Faker
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import shahid.Common as Common
import internal.GlobalVariable as GlobalVariable

TestData UsersData = findTestData('Data Files/Users')

String userType

lastRow = UsersData.getAllData().size()

for (int i = 1; i <= lastRow; i++) {
    userType = UsersData.getValue(1, i)

    new Common().navigateToShahid()

    new Common().checkLanguage()

    new Common().login(UsersData.getValue(2, i), UsersData.getValue(3, i))

    new Common().selectUser()

    WebUI.waitForPageLoad(5)

    new Common().checkLanguage()

    new Common().ScrollUntilElementPresent('Object Repository/HomeScreen/liveStreaming/LiveCarousel')
}

WebUI.closeBrowser()