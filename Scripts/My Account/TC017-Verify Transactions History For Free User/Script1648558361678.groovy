import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field.Xpath as Xpath
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import shahid.Common as Common
import internal.GlobalVariable as GlobalVariable

//new Common().navigateToShahid()
//
//WebDriver driver = DriverFactory.getWebDriver()
//
//new Common().checkLanguage()
//
//new Common().login(GlobalVariable.FreeUser, GlobalVariable.FreeUserPassword)
//
//new Common().selectUser()
//
//new Common().checkLanguage()
//
//new Common().tapAtBurgerMenu()
//
//new Common().clickAtMyAccount()

WebUI.delay(2)

WebUI.click(findTestObject(GlobalVariable.objLanguage + '/Settings Screen/Account Settings Screen/viewPreviousTransactions'))

WebUI.delay(2)

String noPreviousOperationsText

Boolean FEcondition = false


if (!(WebUI.waitForElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/previousOperationsSection/noPreviousOperationsText'), 
    7))) {
    WebElement PreviousOperationsList = driver.findElement(By.tagName('ul'))

    List PreviousOperationsItem = PreviousOperationsList.findElements(By.tagName('li'))

    int Listsize = PreviousOperationsItem.size()

    println(('{{{{{{' + Listsize) + '}}}}}}')

    for (def x = 1; x <= Listsize; x++) {
        def Xpath = '(//li[contains(@class,\'transactionHistory_transaction-item\')])' + [x]

        TestObject listItem = WebUI.modifyObjectProperty(findTestObject('Object Repository/Settings Screen/previousOperationsSection/previousOperationItem'), 
            'xpath', 'equals', Xpath, true)

        WebUI.waitForElementPresent(listItem, 5)

        String itemText = WebUI.getText(listItem)

        print(itemText)
    }
}

//WebUI.closeBrowser()