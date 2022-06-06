import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword as Keyword
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import shahid.Common 
import internal.GlobalVariable as GlobalVariable
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.testdata.TestData as TestData


new Common().navigateToShahid()

String DeviceName = MobileDriverFactory.getDeviceName()
TestData UsersData = findTestData('Data Files/Users')

new Common().checkLanguage()

String searchValue = 'Al Hayba'

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/HomeScreen/MenuBar/CommonElements/searchIcon'))

WebUI.delay(3)

WebUI.verifyElementPresent(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/searchField'), 
    2)

WebUI.setText(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage + '/searchField')), searchValue)

WebUI.delay(7)

WebUI.verifyElementPresent(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage + '/searchResult')), 3)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/Top Navigation/' + GlobalVariable.objLanguage + '/cancelButton'))

lastRow = UsersData.getAllData().size()

for (int i = 1; i <= lastRow; i++) {
	new Common().login(UsersData.getValue(2, i), UsersData.getValue(3, i))

	WebUI.delay(8)

	new Common().selectUser(0)

	
	WebUI.delay(3)
	
	WebUI.click(findTestObject('Object Repository/HomeScreen/MenuBar/CommonElements/searchIcon'))
	
	WebUI.delay(3)
	new Common().checkLanguage()
	WebUI.verifyElementPresent(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/searchField'),
		2)
	
	WebUI.setText(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage + '/searchField')), searchValue)
	
	WebUI.delay(7)
	
	WebUI.verifyElementPresent(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage + '/searchResult')), 3)
	WebUI.delay(2)
	WebUI.click(findTestObject('Object Repository/Top Navigation/' + GlobalVariable.objLanguage + '/cancelButton'))

	//new Common().logout()
}
WebUI.closeBrowser()