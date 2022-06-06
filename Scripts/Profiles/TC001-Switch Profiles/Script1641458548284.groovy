import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field.Xpath as Xpath
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import shahid.Common
import internal.GlobalVariable as GlobalVariable

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

    WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 4)

    List<WebElement> UserProfile = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))

    int Listsize = UserProfile.size()
	
	println 'UserProfile.size():: '+UserProfile.size() +":::: "+ UserProfile


    String ProfileName = ''



    def UserProfilesName=new String[Listsize]

    TestObject User = new TestObject()

    String xpath

    for (def e = 0; e < Listsize; e++) {
        ProfileName = UserProfile[e].getAttribute('alt')

        (UserProfilesName[e]) = ProfileName

    }
    
	
	
    int index1 = 0

    for (def v = 0; v < Listsize; v++) {
		
		
		println "UserProfilesName:: "+UserProfilesName
		
		WebUI.delay(2)
		println "*****v:: "+v
		if(v!=0) {
			new Common().tapAtbackToUserProfiles()
		}
		UserProfile[v].click()

        new Common().tapAtBurgerMenu()

        if (WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/ExitKidsProfileButton'), 3)) {
            WebUI.click(findTestObject('Object Repository/UserProfile/ExitKidsProfileButton'))

            WebUI.delay(2)

            int a = 1

            //wrong pin code
            for (int x = 0; x < parentalControlCode.length(); x++) {
                codeDigit = invalidParentalControlCode.charAt(x)

                def Xpath = '(//input[@type="tel"])' + [a]

                TestObject digit = WebUI.modifyObjectProperty(findTestObject('Object Repository/Custom Keywords OBJ/modifiedCodeDigitField'), 
                    'xpath', 'equals', Xpath, true)

                WebUI.setText(digit, codeDigit.toString())

                a++
            }
            
            WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/Kids Interface/wrongPinCode'), 3)

            driver.findElement(By.xpath('//img[contains(@class,"CloseModal_close-modal_")]')).click()

            WebUI.click(findTestObject('Object Repository/UserProfile/ExitKidsProfileButton'))

            int s = 1

            for (int y = 0; y < parentalControlCode.length(); y++) {
                codeDigit = parentalControlCode.charAt(y)

                def Xpath = '(//input[@type="tel"])' + [s]

                println('Xpath:: ' + Xpath)

                TestObject digit = WebUI.modifyObjectProperty(findTestObject('Object Repository/Custom Keywords OBJ/modifiedCodeDigitField'), 
                    'xpath', 'equals', Xpath, true)

                WebUI.setText(digit, codeDigit.toString())

                println('codeDigit:: ' + codeDigit)

                println('s:: ' + s++)
            }
        } else {
//            new Common().tapAtBurgerMenu()
//			WebUI.mouseOver(findTestObject('Object Repository/HomeScreen/mainbarUserProfileIcon'))
            WebUI.click(findTestObject('Object Repository/HomeScreen/mainbarUserProfileIcon'))

            WebUI.delay(2)
        }
        
        println(' index1::' + index1)

        index1++
    }
    
    WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/profileManagementText'), 3)

    WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/profileManagementIcon'), 3)

    WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/activeKidsInterfaceText'), 3)

    WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/activeKidsIntefaceDescription'), 3)

    WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/switchToKidsProfile'), 2)
}