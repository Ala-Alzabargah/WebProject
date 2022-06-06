import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.github.javafaker.Faker
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.Common
 
TestData UsersData = findTestData('Data Files/Users')

String userType

lastRow = UsersData.getAllData().size()
String profileType

for (int i = 1; i <= lastRow; i++) {
    userType = UsersData.getValue(1, i)

    new Common().navigateToShahid()

    WebDriver driver = DriverFactory.getWebDriver()

    new Common().checkLanguage()

    new Common().login(UsersData.getValue(2, i), UsersData.getValue(3, i))

    WebUI.waitForPageLoad(5)

    new Common().checkLanguage()

    List<WebElement> UserProfile = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
	
	
	int Listsize = UserProfile.size()
	
	int remainsProfiles = 5 - Listsize
	
	
	for (int l = 0; l < remainsProfiles; l++) {
		if (l % 2 == 0) {
			profileType =GlobalVariable.Adult
		} else {
			profileType = GlobalVariable.Kids
		}
	Faker faker = new Faker()
	
		 String name = faker.name().firstName()


    Boolean addButtonCondition = WebUI.waitForElementPresent(findTestObject('Object Repository/'+GlobalVariable.objLanguage+'/UserProfile/addNewProfile'), 
        3)

    Boolean numberofProfileCondition = Listsize < 5

    if (numberofProfileCondition && addButtonCondition) {
        WebUI.click(findTestObject('Object Repository/'+GlobalVariable.objLanguage+'/UserProfile/addNewProfile'))

        WebUI.delay(2)

        WebUI.mouseOver(findTestObject('Object Repository/UserProfile/addProfileAvatar'))

        WebUI.click(findTestObject('Object Repository/UserProfile/addProfileAvatar'))

        WebUI.delay(2)

        new Common().selectAvatar()

        WebUI.delay(2)

        WebUI.setText(findTestObject('Object Repository/UserProfile/enterNameField'), name)
		
		if(profileType.equals(GlobalVariable.Adult)) {

        WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/switchToKidsProfile'), 2)}else if(profileType.equals(GlobalVariable.Kids)) {
		
		WebUI.click(findTestObject('Object Repository/UserProfile/switchToKidsProfile'))
		
		new Common().swipe(600)
        }

        WebUI.click(findTestObject('Object Repository/UserProfile/createButton'))

        if(WebUI.waitForElementPresent(findTestObject('Object Repository/'+GlobalVariable.objLanguage+'/UserProfile/addProfileSuccessfullyText'),4)) {
			new Common().getRandomName(userType,name,profileType)
			
		}else {
			KeywordUtil.markFailedAndStop('Wrong error message appear')
		}
    } else {
        if (addButtonCondition) {
			KeywordUtil.markWarning('number of user profile is above the limit')
        } else if (numberofProfileCondition) {
			KeywordUtil.markWarning('Add new profile button does not exist')

        } else {
			KeywordUtil.markWarning('You have reached the maximum number of profiles\n*Kindly note that the maximum number of profiles per user is 5')
        }
    }
}
}
WebUI.closeBrowser()