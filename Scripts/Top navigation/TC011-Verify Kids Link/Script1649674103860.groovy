import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword as Keyword
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import shahid.Common as Common
import internal.GlobalVariable as GlobalVariable
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType

new Common().navigateToShahid()

String DeviceName = MobileDriverFactory.getDeviceName()

new Common().checkLanguage()

new Common().tapAtBurgerMenu()

WebUI.delay(3)

WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/kidsLink'))

WebUI.delay(3)

if (!(WebUI.getUrl().contains('/kids'))) {
    KeywordUtil.markFailed('URL not match :' + WebUI.getUrl())
}

WebUI.delay(3)

new Common().tapAtBurgerMenu()

WebUI.delay(5)

WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/ExitKidsModeButton'))

if (!(WebUI.getUrl().contains('/home'))) {
    KeywordUtil.markFailed('URL not match :' + WebUI.getUrl())
}

WebUI.delay(3)

TestData UsersData = findTestData('Data Files/Users')

lastRow = UsersData.getAllData().size()

for (int i = 1; i <= lastRow; i++) {
    new Common().login(UsersData.getValue(2, i), UsersData.getValue(3, i))

    WebUI.delay(5)

    new Common().selectUser(0)

    WebUI.delay(3)

    new Common().checkLanguage()

    new Common().tapAtBurgerMenu()
    
    WebUI.delay(3)

    WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/kidsLink'))

    WebUI.delay(3)

    if (WebUI.waitForElementVisible(findTestObject('Object Repository/Top Navigation/pin'), 2)) {
        for (int x = 0; x < GlobalVariable.parentalControlCode.toString().length(); x++) {
            char codeDigit = GlobalVariable.parentalControlCode.toString().charAt(x)

            def Xpath = '(//input[@type="tel"])' + [x + 1]

            TestObject digit = WebUI.modifyObjectProperty(findTestObject('Object Repository/Custom Keywords OBJ/modifiedCodeDigitField'), 
                'xpath', 'equals', Xpath, true)

            WebUI.setText(digit, codeDigit.toString())
        }
		WebUI.delay(2)
		WebUI.click(WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/Save')))
		
    }
	WebUI.delay(5)
    if (!(WebUI.getUrl().contains('/kids'))) {
        KeywordUtil.markFailed('URL not match :' + WebUI.getUrl())
    }
    
    new Common().tapAtBurgerMenu()
    
    WebUI.delay(5)

    WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/ExitKidsModeButton'))

    WebUI.waitForElementVisible(findTestObject('Object Repository/Top Navigation/pin'), 4)

    for (int x = 0; x < GlobalVariable.parentalControlCode.toString().length(); x++) {
        char codeDigit = GlobalVariable.parentalControlCode.toString().charAt(x)

        def xpath = '(//input[@type="tel"])' + [x + 1]

        TestObject to = new TestObject('objectName')

        to.addProperty('xpath', ConditionType.EQUALS, xpath)

        WebUI.setText(to, codeDigit.toString())

    }
    
    new Common().selectUser(0)

    WebUI.delay(2)

    if (!(WebUI.getUrl().contains('/home'))) {
        KeywordUtil.markFailed('URL not match :' + WebUI.getUrl())
    }
    
    //new Common().logout()
}

WebUI.closeBrowser()