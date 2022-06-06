import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import shahid.Common as Common
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.testdata.TestData as TestData
new Common().navigateToShahid()

String DeviceName = MobileDriverFactory.getDeviceName()

WebDriver driver = DriverFactory.getWebDriver()

TestData UsersData = findTestData('Data Files/Users')

lastRow = UsersData.getAllData().size()

for (int a = 1; a <= lastRow; a++) {
    new Common().login(UsersData.getValue(2, a), UsersData.getValue(3, a))

    WebUI.delay(5)

    new Common().selectUser(0)

    WebUI.delay(3)

    new Common().checkLanguage()

    new Common().tapAtBurgerMenu()
    
    WebUI.delay(3)

    WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/myProfile'))

    WebUI.delay(3)

    WebUI.verifyElementPresent(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/selectProfile'), 
        3)

    WebUI.delay(3)

    WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/profilesManagement'))

    WebUI.delay(3)

    List<WebElement> UserProfile = driver.findElements(By.xpath('(//div[contains(@class,\'profile-edit-icon\')])'))

    int Listsize = UserProfile.size()
    for (def i = 1; i <= Listsize; i++) {
        WebUI.delay(5)

        String xpath = ('(//div[contains(@class,\'profile-edit-icon\')])[' + i) + ']'

        TestObject to = new TestObject('objectName')

        to.addProperty('xpath', ConditionType.EQUALS, xpath)

        WebUI.click(to)

        WebUI.delay(5)

        WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/Save'))

        WebUI.delay(8)
    }
	WebUI.delay(6)
    WebUI.click(findTestObject('Object Repository/Top Navigation/closeEditButton'))

    WebUI.delay(3)

    new Common().selectUser(0)

    //new Common().logout()
}

WebUI.closeBrowser()