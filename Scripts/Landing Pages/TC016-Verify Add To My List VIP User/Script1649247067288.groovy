import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject



import org.openqa.selenium.By
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.Common as Common




CustomKeywords.'shahid.Common.navigateToShahid'()
CustomKeywords.'shahid.Common.checkLanguage'()



String titleBefor
String title
List<WebElement> myList

CustomKeywords.'shahid.Common.login'(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)

WebUI.waitForElementPresent(findTestObject('adultDefault'), 10)
WebUI.delay(2)
WebUI.click(findTestObject('adultDefault'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(2)
CustomKeywords.'shahid.Common.checkLanguage'()

    titleBefor = WebUI.getAttribute(findTestObject('Object Repository/Show Pages/showPageLogo'), 'title')

    WebUI.waitForElementVisible(findTestObject('Object Repository/LandingPages/' + GlobalVariable.objLanguage + '/addToMyList'), 7)
    WebUI.click(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/addToMyList'))
    WebUI.waitForPageLoad(5)
    new Common().tapAtBurgerMenu()

    WebUI.waitForElementVisible(findTestObject(('Object Repository/Show Pages/' + GlobalVariable.objLanguage) + '/myList'),10)
    WebUI.click(findTestObject(('Object Repository/Show Pages/' + GlobalVariable.objLanguage) + '/myList'))
    WebUI.waitForPageLoad(3)
	
    myList = driver.findElements(By.xpath("(//img[contains(@class,'PortraitItem_')])"))


    for (int z = 1; z <= myList.size(); z++) {
        String xpath = ('(//img[contains(@class,\'PortraitItem_\')])[' + z) + ']'
        TestObject to = new TestObject('objectName')

        to.addProperty('xpath', ConditionType.EQUALS, xpath)

        title = WebUI.getAttribute(to, 'title')

        if (title.equals(titleBefor)) {
            WebUI.click(to)

            WebUI.scrollToElement(findTestObject('Object Repository/Show Pages/addToMyListButton'), 3)

            WebUI.waitForElementVisible(findTestObject('Object Repository/Show Pages/addToMyListButton'), 10)

            WebUI.click(findTestObject('Object Repository/Show Pages/addToMyListButton'))

            break
        } else if (!(title.equals(titleBefor) && (z <= myList.size()))) {
            KeywordUtil.markFailed('Show not added ')
        }
    }

    new Common().tapAtBurgerMenu()

    WebUI.waitForPageLoad(3)

    WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/TVShowsLink'))

    WebUI.waitForPageLoad(3)

    titleBefor = WebUI.getAttribute(findTestObject('Object Repository/Show Pages/showPageLogo'), 'title')

    WebUI.waitForElementVisible(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/addToMyList'), 7)

    WebUI.click(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/addToMyList'))

    WebUI.waitForPageLoad(5)

    new Common().tapAtBurgerMenu()

    WebUI.waitForElementVisible(findTestObject(('Object Repository/Show Pages/' + GlobalVariable.objLanguage) + '/myList'),
        10)

    WebUI.click(findTestObject(('Object Repository/Show Pages/' + GlobalVariable.objLanguage) + '/myList'))

    WebUI.waitForPageLoad(3)

    myList = driver.findElements(By.xpath('(//img[contains(@class,\'PortraitItem_\')])'))

    for (int z = 1; z <= myList.size(); z++) {
        String xpath = ('(//img[contains(@class,\'PortraitItem_\')])[' + z) + ']'

        TestObject to = new TestObject('objectName')

        to.addProperty('xpath', ConditionType.EQUALS, xpath)

        title = WebUI.getAttribute(to, 'title')

        if (title.equals(titleBefor)) {
            WebUI.click(to)

            WebUI.scrollToElement(findTestObject('Object Repository/Show Pages/addToMyListButton'), 3)

            WebUI.waitForElementVisible(findTestObject('Object Repository/Show Pages/addToMyListButton'), 10)

            WebUI.click(findTestObject('Object Repository/Show Pages/addToMyListButton'))

            break
        } else if (!(title.equals(titleBefor) && (z <= myList.size()))) {
            KeywordUtil.markFailed('Show not added ')
        }
    }

    new Common().tapAtBurgerMenu()

    WebUI.waitForPageLoad(3)

    WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/moviesLink'))

    WebUI.waitForPageLoad(3)

    titleBefor = WebUI.getAttribute(findTestObject('Object Repository/Show Pages/showPageLogo'), 'title')

    WebUI.waitForElementVisible(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/addToMyList'),
        7)

    WebUI.click(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/addToMyList'))

    WebUI.waitForPageLoad(5)

    new Common().tapAtBurgerMenu()

    WebUI.waitForElementVisible(findTestObject(('Object Repository/Show Pages/' + GlobalVariable.objLanguage) + '/myList'),
        10)

    WebUI.click(findTestObject(('Object Repository/Show Pages/' + GlobalVariable.objLanguage) + '/myList'))

    WebUI.waitForPageLoad(3)

    myList = driver.findElements(By.xpath('(//img[contains(@class,\'PortraitItem_\')])'))

    for (int z = 1; z <= myList.size(); z++) {
        String xpath = ('(//img[contains(@class,\'PortraitItem_\')])[' + z) + ']'

        TestObject to = new TestObject('objectName')

        to.addProperty('xpath', ConditionType.EQUALS, xpath)

        title = WebUI.getAttribute(to, 'title')

        if (title.equals(titleBefor)) {
            WebUI.click(to)

            WebUI.scrollToElement(findTestObject('Object Repository/Show Pages/addToMyListButton'), 3)

            WebUI.waitForElementVisible(findTestObject('Object Repository/Show Pages/addToMyListButton'), 10)

            WebUI.click(findTestObject('Object Repository/Show Pages/addToMyListButton'))

            break
        } else if (!(title.equals(titleBefor) && (z <= myList.size()))) {
            KeywordUtil.markFailed('Show not added ')
        }
    }

    new Common().tapAtBurgerMenu()

        WebUI.waitForPageLoad(3)

    WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/sportsLink'))

        WebUI.waitForPageLoad(3)


    titleBefor = WebUI.getAttribute(findTestObject('Object Repository/Show Pages/showPageLogo'), 'title')

    WebUI.waitForElementVisible(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/addToMyList'), 7)

    WebUI.click(findTestObject(('Object Repository/LandingPages/' + GlobalVariable.objLanguage) + '/addToMyList'))

        WebUI.waitForPageLoad(5)

    new Common().tapAtBurgerMenu()

    WebUI.waitForElementVisible(findTestObject(('Object Repository/Show Pages/' + GlobalVariable.objLanguage) + '/myList'), 10)

    WebUI.click(findTestObject(('Object Repository/Show Pages/' + GlobalVariable.objLanguage) + '/myList'))

        WebUI.waitForPageLoad(3)

    myList = driver.findElements(By.xpath('(//img[contains(@class,\'PortraitItem_\')])'))

    for (int z = 1; z <= myList.size(); z++) {
        String xpath = ('(//img[contains(@class,\'PortraitItem_\')])[' + z) + ']'

        TestObject to = new TestObject('objectName')

        to.addProperty('xpath', ConditionType.EQUALS, xpath)

        title = WebUI.getAttribute(to, 'title')

        if (title.equals(titleBefor)) {
            WebUI.click(to)

            WebUI.scrollToElement(findTestObject('Object Repository/Show Pages/addToMyListButton'), 3)

            WebUI.waitForElementVisible(findTestObject('Object Repository/Show Pages/addToMyListButton'), 10)

            WebUI.click(findTestObject('Object Repository/Show Pages/addToMyListButton'))

            break
        } else if (!(title.equals(titleBefor) && (z <= myList.size()))) {
            KeywordUtil.markFailed('Show not added ')
        }
    }

	WebUI.closeBrowser()

	
