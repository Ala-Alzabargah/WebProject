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

    WebUI.delay(8)

    new Common().selectUser(0)

    WebUI.delay(3)

    new Common().tapAtBurgerMenu()
    
    new Common().checkLanguage()

    WebUI.delay(3)

    WebUI.verifyElementPresent(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/myProfile'), 
        3)

    WebUI.verifyElementPresent(findTestObject('Object Repository/Top Navigation/profileImage'), 3)

    WebUI.scrollToElement(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/myAccount'), 
        3)

    WebUI.delay(3)

    WebUI.verifyElementPresent(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/devicesManagement'), 
        3)

    WebUI.verifyElementPresent(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/logout'), 
        3)

//   WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/logout'))
   WebUI.delay(8)
}

WebUI.closeBrowser()