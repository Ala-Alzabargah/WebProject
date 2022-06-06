import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.testdata.TestData as TestData
import shahid.Common as Common
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

new Common().navigateToShahid()

WebDriver driver = DriverFactory.getWebDriver()

TestData UsersData = findTestData('Data Files/Users')

WebUI.navigateToUrl(GlobalVariable.SportContentURL)

new Common().checkLanguage()

WebUI.delay(2)
System.err.println 'WebUI.getText(findTestObject("Player/upsell message")) ****'+WebUI.getText(findTestObject('Player/upsell message'))
if (GlobalVariable.objLanguage == 'en') {
    WebUI.verifyElementText(findTestObject('Player/upsell message'), 'Content only available through Sports on Shahid VIP \n Subscribe and enjoy sports events, originals & more exclusive entertainment!')
} else if (GlobalVariable.objLanguage == 'fr') {
    WebUI.verifyElementText(findTestObject('Player/upsell message'), 'Disponible avec le Pack Sport sur Shahid VIP \n Abonnez-vous & profitez de sports, originaux, séries et films exclusifs et bien plus!')
} else if (GlobalVariable.objLanguage == 'ar') {
    WebUI.verifyElementText(findTestObject('Player/upsell message'), 'محتوى متوفر لمشتركي باقة الرياضة على شاهد VIP \n اشترك وتابع مختلف الرياضات والأعمال الأصلية والمزيد من البرامج الترفيهية الحصرية!')
}

lastRow = UsersData.getAllData().size()

for (int i = 2; i <= lastRow; i++) {
    new Common().login(UsersData.getValue(2, i), UsersData.getValue(3, i))

    WebUI.delay(3)

    new Common().selectUser(0)

    new Common().checkLanguage()

    WebUI.navigateToUrl(GlobalVariable.SportContentURL)

    new Common().checkLanguage()

    WebUI.delay(2)

    if (UsersData.getValue(1, i).equals(GlobalVariable.freeUserForDataFile.toString())) {
        if (GlobalVariable.objLanguage == 'en') {
            WebUI.verifyElementText(findTestObject('Player/upsell message'), 'Content only available through Sports on Shahid VIP \n Subscribe and enjoy sports events, originals &  more exclusive entertainment!')
        } else if (GlobalVariable.objLanguage == 'fr') {
            WebUI.verifyElementText(findTestObject('Player/upsell message'), 'Disponible avec le Pack Sport sur Shahid VIP \n Abonnez-vous & profitez de sports, originaux, séries et films exclusifs et bien plus!')
        } else if (GlobalVariable.objLanguage == 'ar') {
            WebUI.verifyElementText(findTestObject('Player/upsell message'), 'محتوى متوفر لمشتركي باقة الرياضة على شاهد VIP \n اشترك وتابع مختلف الرياضات والأعمال الأصلية والمزيد من البرامج الترفيهية الحصرية!')
        }
    } else if (UsersData.getValue(1, i).equals(GlobalVariable.vipUserForDataFile.toString())) {
        if (GlobalVariable.objLanguage == 'en') {
            WebUI.verifyElementText(findTestObject('Player/upsell message'), 'This content is not available with your current package \n Join Sports on Shahid VIP to watch this and other sports events, originals & more exclusive entertainment')
        } else if (GlobalVariable.objLanguage == 'fr') {
            WebUI.verifyElementText(findTestObject('Player/upsell message'), 'Ce contenu n\'est pas disponible avec votre abonnement actuel \n Abonnez-vous au Pack Sport sur Shahid VIP pour profiter de ce contenu ainsi que d\'autres sports, originaux, et bien plus de divertissements exclusifs')
        } else if (GlobalVariable.objLanguage == 'ar') {
            WebUI.verifyElementText(findTestObject('Player/upsell message'), 'هذا المحتوى غير متوفر على باقتك الحالية \n اشترك في باقة الرياضة على شاهد VIP لمتابعة مختلف الرياضات والأعمال الأصلية والمزيد من البرامج الترفيهية الحصرية')
        }
    } else if (UsersData.getValue(1, i).equals(GlobalVariable.ImagineUserForDataFile.toString())) {
        if (GlobalVariable.objLanguage == 'en') {
            WebUI.verifyElementText(findTestObject('Player/upsell message'), 'This content is not available with your current package \n Join Shahid VIP Ultimate to watch this and other Arabic Originals, exclusive series & movie premieres, Live TV and concerts, sports and more')
        } else if (GlobalVariable.objLanguage == 'fr') {
            WebUI.verifyElementText(findTestObject('Player/upsell message'), 'Ce contenu n\'est pas disponible avec votre abonnement actuel \n Abonnez-vous à Shahid VIP Ultimate pour en profiter ainsi que d\'originaux, de séries et films en exclusivité ou en première, TV et concerts en direct, sport et bien plus')
        } else if (GlobalVariable.objLanguage == 'ar') {
            WebUI.verifyElementText(findTestObject('Player/upsell message'), 'هذا المحتوى غير متوفر على باقتك الحالية \n اشترك في باقة شاهد VIP شامل لمتابعة هذا المحتوى إضافة إلى أقوى الأعمال الأصلية العربية من مسلسلات وبرامج حصرية تعرض لأول مرة والبث المباشر لقنواتك المفضلة والحفلات الخاصة والرياضة والمزيد')
        }
    }
    
    //new Common().logout()
}

WebUI.closeBrowser()

