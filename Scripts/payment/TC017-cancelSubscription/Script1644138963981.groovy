import static com.kms.katalon.core.testdata.TestDataFactory.findTestData

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import shahid.Common as Common
import internal.GlobalVariable



TestData UsersData = findTestData('Data Files/prod users')

UsersData.getAllData().size()
new Common().navigateToShahid()
WebUI.delay(2)
WebDriver driver = DriverFactory.getWebDriver()
new Common().checkLanguage()

int i = 4
new Common().login(UsersData.getValue(2, i), UsersData.getValue(3, i))

new Common().selectUser()
WebUI.delay(2)
new Common().tapAtBurgerMenu()
new Common().clickAtMyAccount()
WebUI.delay(4)


///account settings page
WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/changePassword'), 2)
WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/changePersonalInfo'), 2)
WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/devicesManagement'), 2)
WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/parentalControlInterface'), 2)
WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/viewPreviousTransaction'), 2)
WebUI.waitForElementPresent(findTestObject('Object Repository/moreScreenThreeLanguages/'+GlobalVariable.objLanguage+'/specialFeatures'), 2)
WebUI.click(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/subscribtionManagement'))
WebUI.delay(2)
new Common().checkLanguage()

//subscribtion page
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/viewTransactionHistory'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/doYouNeedHelpWithYourSubsText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/otherUtilitiesText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/subscribtionDetailsTextSwichPackagePage'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/subscribtionDetailsTextSwichPackagePage'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/packageSwitchPackagePage'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/planSwitchPackagePage'), 3)
WebUI.click(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/cancelYourSubscribtionButton'))

//cancel subscribtion page 

WebUI.verifyElementPresent(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/wereSorryToSeeYouLeaveText'), 3)

WebUI.closeBrowser()

