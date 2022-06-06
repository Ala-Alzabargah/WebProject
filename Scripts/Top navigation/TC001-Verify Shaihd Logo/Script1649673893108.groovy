import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.text.SimpleDateFormat as SimpleDateFormat
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field.Xpath as Xpath
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.interactions.Actions as Actions
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import cucumber.api.java.en.Given as Given
import internal.GlobalVariable as GlobalVariable
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.testdata.TestData as TestData
import shahid.Common as Common
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory

new Common().navigateToShahid()

TestData UsersData = findTestData('Data Files/Users')

WebUI.delay(3)

WebUI.verifyElementVisible(findTestObject('Object Repository/HomeScreen/shahidLogo'))

WebUI.delay(3)

UsersData.getAllData().size()

String DeviceName = MobileDriverFactory.getDeviceName()

lastRow = UsersData.getAllData().size()

for (int i = 1; i <= lastRow; i++) {
    new Common().login(UsersData.getValue(2, i), UsersData.getValue(3, i))

    WebUI.delay(8)

    new Common().selectUser(0)

   
    WebUI.waitForPageLoad(7)
	new Common().checkLanguage()
//    if (UsersData.getValue(1, i).equals(GlobalVariable.freeUserForDataFile.toString())) {
//        WebUI.verifyElementVisible(findTestObject('Object Repository/HomeScreen/shahidLogo'))
//    } else {
        WebUI.verifyElementVisible(findTestObject('Object Repository/HomeScreen/shahidlogos/shahidlogovip'))
//    }
    
}

WebUI.closeBrowser()