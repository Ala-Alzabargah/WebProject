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

for (int i = 0; i <= 2; i++) {
    new Common().tapAtBurgerMenu()
    
    new Common().checkLanguage()

    WebUI.delay(3)

    WebUI.scrollToElement(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/language'), 
        3)

    WebUI.delay(3)

    println('Hereeee ' + GlobalVariable.objLanguage)

    if (GlobalVariable.objLanguage == 'en') {
        WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/language'))

        WebUI.delay(3)

        WebUI.scrollToElement(findTestObject('Object Repository/Top Navigation/selectLanguageAr'), 2)

        WebUI.click(findTestObject('Object Repository/Top Navigation/selectLanguageAr'))

        WebUI.delay(3)

        if (!(WebUI.getUrl().contains('ar'))) {
            KeywordUtil.markFailed('Language dosent match')
        }
        
        if (WebUI.waitForElementVisible(findTestObject('Login/burgerIcon'), 7)) {
            WebUI.click(findTestObject('Login/burgerIcon'))
        }
        
        new Common().checkLanguage()

        WebUI.delay(3)

        WebUI.scrollToElement(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/language'), 
            3)

        WebUI.delay(3)

        WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/language'))

        WebUI.delay(3)

        WebUI.scrollToElement(findTestObject('Object Repository/Top Navigation/selectLanguageFr'), 2)

        WebUI.click(findTestObject('Object Repository/Top Navigation/selectLanguageFr'))

        WebUI.delay(3)

        if (!(WebUI.getUrl().contains('fr'))) {
            KeywordUtil.markFailed('Language dosent match')
        }
    } else if (GlobalVariable.objLanguage == 'fr') {
        WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/language'))

        WebUI.delay(3)

        WebUI.scrollToElement(findTestObject('Object Repository/Top Navigation/selectLanguageEn'), 2)

        WebUI.click(findTestObject('Object Repository/Top Navigation/selectLanguageEn'))

        WebUI.delay(3)

        if (!(WebUI.getUrl().contains('en'))) {
            KeywordUtil.markFailed('Language dosent match')
        }
        
        if (WebUI.waitForElementVisible(findTestObject('Login/burgerIcon'), 7)) {
            WebUI.click(findTestObject('Login/burgerIcon'))
        }
        
        new Common().checkLanguage()

        WebUI.delay(3)

        WebUI.scrollToElement(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/language'), 
            3)

        WebUI.delay(3)

        WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/language'))

        WebUI.delay(3)

        WebUI.scrollToElement(findTestObject('Object Repository/Top Navigation/selectLanguageAr'), 2)

        WebUI.click(findTestObject('Object Repository/Top Navigation/selectLanguageAr'))

        WebUI.delay(3)

        if (!(WebUI.getUrl().contains('ar'))) {
            KeywordUtil.markFailed('Language dosent match')
        }
    } else if (GlobalVariable.objLanguage == 'ar') {
        WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/language'))

        WebUI.delay(3)

        WebUI.scrollToElement(findTestObject('Object Repository/Top Navigation/selectLanguageEn'), 2)

        WebUI.click(findTestObject('Object Repository/Top Navigation/selectLanguageEn'))

        WebUI.delay(3)

        if (!(WebUI.getUrl().contains('en'))) {
            KeywordUtil.markFailed('Language dosent match')
        }
        
        if (WebUI.waitForElementVisible(findTestObject('Login/burgerIcon'), 7)) {
            WebUI.click(findTestObject('Login/burgerIcon'))
        }
        
        new Common().checkLanguage()

        WebUI.delay(3)

        WebUI.scrollToElement(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/language'), 
            3)

        WebUI.delay(3)

        WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/language'))

        WebUI.delay(3)

        WebUI.scrollToElement(findTestObject('Object Repository/Top Navigation/selectLanguageFr'), 2)

        WebUI.click(findTestObject('Object Repository/Top Navigation/selectLanguageFr'))

        WebUI.delay(3)

        if (!(WebUI.getUrl().contains('fr'))) {
            KeywordUtil.markFailed('Language dosent match')
        }
    }
}

TestData UsersData = findTestData('Data Files/Users')

lastRow = UsersData.getAllData().size()

for (int a = 1; a <= lastRow; a++) {
    new Common().login(UsersData.getValue(2, a), UsersData.getValue(3, a))

    WebUI.delay(5)

    new Common().selectUser(0)

    for (int i = 0; i <= 2; i++) {
        if (WebUI.waitForElementVisible(findTestObject('Login/burgerIcon'), 7)) {
            WebUI.click(findTestObject('Login/burgerIcon'))
        }
        
        new Common().checkLanguage()

        WebUI.delay(3)

        if (i == 0) {
            WebUI.scrollToElement(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/language'), 
                3)
        }
        
        WebUI.delay(3)

        println('Hereeee ' + GlobalVariable.objLanguage)

        if (GlobalVariable.objLanguage == 'en') {
            WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/language'))

            WebUI.delay(3)

            WebUI.scrollToElement(findTestObject('Object Repository/Top Navigation/selectLanguageAr'), 2)

            WebUI.click(findTestObject('Object Repository/Top Navigation/selectLanguageAr'))

            WebUI.delay(3)

            if (!(WebUI.getUrl().contains('ar'))) {
                KeywordUtil.markFailed('Language dosent match')
            }
            
            if (WebUI.waitForElementVisible(findTestObject('Login/burgerIcon'), 7)) {
                WebUI.click(findTestObject('Login/burgerIcon'))
            }
            
            new Common().checkLanguage()

            WebUI.delay(3)

            WebUI.scrollToElement(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/language'), 
                3)

            WebUI.delay(3)

            WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/language'))

            WebUI.delay(3)

            WebUI.scrollToElement(findTestObject('Object Repository/Top Navigation/selectLanguageFr'), 2)

            WebUI.click(findTestObject('Object Repository/Top Navigation/selectLanguageFr'))

            WebUI.delay(3)

            if (!(WebUI.getUrl().contains('fr'))) {
                KeywordUtil.markFailed('Language dosent match')
            }
        } else if (GlobalVariable.objLanguage == 'fr') {
            WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/language'))

            WebUI.delay(3)

            WebUI.scrollToElement(findTestObject('Object Repository/Top Navigation/selectLanguageEn'), 2)

            WebUI.click(findTestObject('Object Repository/Top Navigation/selectLanguageEn'))

            WebUI.delay(3)

            if (!(WebUI.getUrl().contains('en'))) {
                KeywordUtil.markFailed('Language dosent match')
            }
            
            if (WebUI.waitForElementVisible(findTestObject('Login/burgerIcon'), 7)) {
                WebUI.click(findTestObject('Login/burgerIcon'))
            }
            
            new Common().checkLanguage()

            WebUI.delay(3)

            WebUI.scrollToElement(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/language'), 
                3)

            WebUI.delay(3)

            WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/language'))

            WebUI.delay(3)

            WebUI.scrollToElement(findTestObject('Object Repository/Top Navigation/selectLanguageAr'), 2)

            WebUI.click(findTestObject('Object Repository/Top Navigation/selectLanguageAr'))

            WebUI.delay(3)

            if (!(WebUI.getUrl().contains('ar'))) {
                KeywordUtil.markFailed('Language dosent match')
            }
        } else if (GlobalVariable.objLanguage == 'ar') {
            WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/language'))

            WebUI.delay(3)

            WebUI.scrollToElement(findTestObject('Object Repository/Top Navigation/selectLanguageEn'), 2)

            WebUI.click(findTestObject('Object Repository/Top Navigation/selectLanguageEn'))

            WebUI.delay(3)

            if (!(WebUI.getUrl().contains('en'))) {
                KeywordUtil.markFailed('Language dosent match')
            }
            
            if (WebUI.waitForElementVisible(findTestObject('Login/burgerIcon'), 7)) {
                WebUI.click(findTestObject('Login/burgerIcon'))
            }
            
            new Common().checkLanguage()

            WebUI.delay(3)

            WebUI.scrollToElement(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/language'), 
                3)

            WebUI.delay(3)

            WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/language'))

            WebUI.delay(3)

            WebUI.scrollToElement(findTestObject('Object Repository/Top Navigation/selectLanguageFr'), 2)

            WebUI.click(findTestObject('Object Repository/Top Navigation/selectLanguageFr'))

            WebUI.delay(3)

            if (!(WebUI.getUrl().contains('fr'))) {
                KeywordUtil.markFailed('Language dosent match')
            }
        }
    }
    
    new Common().checkLanguage()

    //new Common().logout()
}

WebUI.closeBrowser()