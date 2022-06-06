import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.Common as Common

new Common().navigateToShahid()

WebDriver driver = DriverFactory.getWebDriver()
TestData showData = findTestData('Data Files/usersTypes/showPagesData')

new Common().checkLanguage()
new Common().login(GlobalVariable.SubscribedUser,GlobalVariable.SubscribedUserPassword)
WebUI.delay(1)
WebUI.waitForElementPresent(findTestObject('adultDefault'), 10)
WebUI.delay(1)
WebUI.click(findTestObject('adultDefault'), FailureHandling.CONTINUE_ON_FAILURE)
new Common().checkLanguage()
// Tv Show , Movie , Sport
def searchValuesList = "Rashash"
int y = 0;

	new Common().search(searchValuesList)
	WebUI.waitForElementVisible(findTestObject('Object Repository/Show Pages/heroBanner'), 10)
	WebUI.waitForElementVisible(findTestObject(('Object Repository/Show Pages/' + GlobalVariable.objLanguage) + '/seasonLabel'), 10)
	WebUI.verifyElementPresent(findTestObject(('Object Repository/Show Pages/' + GlobalVariable.objLanguage) + '/seasonLabel'), 3)
	
	
	String showDescription = WebUI.getText(findTestObject('Object Repository/Show Pages/description'))

	if (!(showDescription.equals(showData.getValue('Description ' + GlobalVariable.objLanguage, y+1)))) {
		KeywordUtil.markFailed('Description not match :' + showData.getValue('Description ' + GlobalVariable.objLanguage, y+1))
		System.err.println "showDescription ****"+showDescription
	}
	
	List<WebElement> metaData = driver.findElements(By.xpath('//div[contains(@class,\'duration_availableSeason\')]//h2'))

	String actualMetaData

	for (int z=1; z <= metaData.size(); z++) {
		String xpath = ('//div[contains(@class,\'duration_availableSeason\')]//h2[' + z) + ']'
		TestObject to = new TestObject('objectName')
		to.addProperty('xpath', ConditionType.EQUALS, xpath)
		actualMetaData = WebUI.getText(to)
		def expectedMetaData = showData.getValue('Meta Data ' + GlobalVariable.objLanguage,  y+1).split(',')

		if (!(actualMetaData.equals(expectedMetaData[z-1].trim()))) {
			System.err.println "expectedMetaData[z].trim() ****"+expectedMetaData[z-1].trim()
			System.err.println "expectedMetaData[z].trim() ****"+actualMetaData
			
			KeywordUtil.markFailed('Meta Data not match :' + expectedMetaData)
		}
	}
	if(y!=2) {
		String stars= WebUI.getText(findTestObject('Object Repository/Show Pages/stars'))
		if (!(stars.equals(showData.getValue('Stars ' + GlobalVariable.objLanguage,  y+1)))) {
			  KeywordUtil.markFailed('Stars not match :' + showData.getValue('Stars ' + GlobalVariable.objLanguage, y+1))
	}

	}
	WebUI.closeBrowser()
