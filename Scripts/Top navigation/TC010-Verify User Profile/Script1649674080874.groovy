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

new Common().navigateToShahid()

String DeviceName = MobileDriverFactory.getDeviceName()

TestData UsersData = findTestData('Data Files/Users')

lastRow = UsersData.getAllData().size()

for (int i = 1; i <= lastRow; i++) {
    new Common().login(UsersData.getValue(2, i), UsersData.getValue(3, i))

    WebUI.delay(5)

    new Common().selectUser(0)

    WebUI.delay(3)

    new Common().tapAtBurgerMenu()
    
    WebUI.delay(3)

    new Common().checkLanguage()

    WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/myProfile'))

    WebUI.delay(3)

    WebUI.verifyElementPresent(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/selectProfile'), 
        3)

    WebUI.delay(3)

    WebUI.click(findTestObject('Object Repository/Top Navigation/addProfile'))

    WebUI.delay(3)

    WebUI.verifyElementPresent(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/createProfile'), 
        3)

    WebUI.delay(3)

    WebUI.click(findTestObject('Object Repository/Top Navigation/closeButton'))

    WebUI.delay(3)

    new Common().selectUser(0)

    //new Common().logout()
}

WebUI.closeBrowser()