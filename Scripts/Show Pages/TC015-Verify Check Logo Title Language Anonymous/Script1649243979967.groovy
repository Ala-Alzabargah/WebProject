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
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

new Common().navigateToShahid()



// Tv Show , Movie , Sport
def searchValuesList = "rashash"

    int y = 0;

   new Common().search(searchValuesList)

    
      
           new Common().tapAtBurgerMenu()
            new Common().checkLanguage()

            WebUI.waitForPageLoad(3)


            if (GlobalVariable.objLanguage == 'en') {
                WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/language'))
                WebUI.waitForPageLoad(3)
                WebUI.click(findTestObject('Object Repository/Top Navigation/selectLanguageAr'))
                WebUI.waitForPageLoad(3)
                new Common().checkLanguage()
                WebUI.verifyElementPresent(findTestObject(('Object Repository/Show Pages/' + GlobalVariable.objLanguage) + '/tvShowLogo'), 0)
				
             } else if (GlobalVariable.objLanguage == 'fr') {
                WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/language'))
               WebUI.waitForPageLoad(3)
                WebUI.click(findTestObject('Object Repository/Top Navigation/selectLanguageEn'))
                WebUI.waitForPageLoad(3)
                new Common().checkLanguage()
                WebUI.verifyElementPresent(findTestObject(('Object Repository/Show Pages/' + GlobalVariable.objLanguage) + '/tvShowLogo'), 0)
            } else if (GlobalVariable.objLanguage == 'ar') {
                WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/language'))
                WebUI.waitForPageLoad(3)
                WebUI.click(findTestObject('Object Repository/Top Navigation/selectLanguageFr'))
                WebUI.waitForPageLoad(3)
                new Common().checkLanguage()
                WebUI.verifyElementPresent(findTestObject(('Object Repository/Show Pages/' + GlobalVariable.objLanguage) + '/tvShowLogo'), 0)
            }
        
   
	WebUI.closeBrowser()
	


