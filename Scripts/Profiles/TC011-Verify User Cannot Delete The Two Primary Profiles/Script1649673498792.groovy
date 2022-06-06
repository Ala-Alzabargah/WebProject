import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver

import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword

import internal.GlobalVariable
import shahid.Common

TestData UsersData = findTestData('Data Files/Users')

String userType

lastRow = UsersData.getAllData().size()

for (int i = 1; i <= lastRow; i++) {
    userType = UsersData.getValue(1, i)

    new Common().navigateToShahid()

    WebDriver driver = DriverFactory.getWebDriver()

    new Common().checkLanguage()

    String password = UsersData.getValue(3, i)

    new Common().login(UsersData.getValue(2, i), password)

    new Common().checkLanguage()

    String invalidParentalControlCode = '1923'

    char codeDigit

    String parentalControlCode

    parentalControlCode = new Common().getParentalControlCode(userType)

    
	
	
		
	WebUI.click(findTestObject('Object Repository/UserProfile/profileManagementIcon'))

    for (def v = 0; v < 2; v++) {
		
		WebUI.delay(2)
        WebUI.waitForPageLoad(10)
		UserProfile = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		JavascriptExecutor executor = ((driver) as JavascriptExecutor)
		
			executor.executeScript('arguments[0].click();', UserProfile[v])
			WebUI.delay(2)
		WebUI.waitForPageLoad(10)
		
		if(! WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/deleteProfileIcon'), 6)) {
 			KeywordUtil.markPassed('delete icon not Visible for primary profile')
		}else {
			KeywordUtil.markFailed('delete icon Visible for primary profile')
		}
        
  WebUI.click(findTestObject('Object Repository/UserProfile/closeButton'))
    }
    
}

WebUI.closeBrowser()