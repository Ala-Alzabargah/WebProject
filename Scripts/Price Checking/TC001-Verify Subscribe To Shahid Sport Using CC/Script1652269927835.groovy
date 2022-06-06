import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import shahid.Common as Common
import shahid.pricesEnum as pricesEnum

new Common().navigateToShahid()

WebUI.delay(2)

WebDriver driver = DriverFactory.getWebDriver()

new Common().checkLanguage()

String Email = RandomStringUtils.random(10, true, true) + '@automationtest.com'

Boolean priceFlag=true
Boolean skuFlag=true
Boolean productNameFlag=true

new Common().shahidSignup(Email, GlobalVariable.newPassword)

new Common().selectUser()

new Common().tapAtBurgerMenu()

new Common().clickAtMyAccount()

//account settings page
WebUI.click(findTestObject(('Object Repository/moreScreenThreeLanguages/' + GlobalVariable.objLanguage) + '/viewPackagesButton'))

//choose your package page
WebUI.delay(3)

new Common().selectPackage(GlobalVariable.SPORT)

String shahidPrice = WebUI.getText(findTestObject('Object Repository/Evergent/shahidSportPrice')).split(' /')[0]

//upgrade your package page
WebUI.click(findTestObject(('Object Repository/paymentThreeLanguages/' + GlobalVariable.objLanguage) + '/continueButton'))

//choose your plan page
WebUI.click(findTestObject('Object Repository/Settings Screen/Payment Methods/Credit Card/creditCardButton'))

WebUI.waitForPageLoad(6)

WebUI.switchToFrame(findTestObject('Object Repository/upgradeAndDowngrade/payment/cardFrame'), 3)

WebUI.setText(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Payment Methods/Credit Card/cardNumberFiled'), 
    '4543474002249996')

WebUI.switchToDefaultContent()

WebUI.waitForPageLoad(6)

WebUI.switchToFrame(findTestObject('Object Repository/upgradeAndDowngrade/payment/expiryDateFrame'), 3)

WebUI.delay(2)

WebUI.setText(findTestObject('Object Repository/CCtexts/expiryDate'), '1225')

WebUI.switchToDefaultContent()

WebUI.waitForPageLoad(6)

WebUI.switchToFrame(findTestObject('Object Repository/upgradeAndDowngrade/payment/cvvFrame'), 3)

WebUI.setText(findTestObject('Object Repository/CCtexts/cvvCreditCard'), '956')

WebUI.switchToDefaultContent()

WebUI.delay(2)

String shahidPlan = WebUI.getText(findTestObject('Object Repository/Evergent/shahidPlan'))

String shahidPackage = WebUI.getText(findTestObject('Object Repository/Evergent/shahidPackage'))

def businessList = new Common().getPackagePrice(shahidPackage, shahidPlan, GlobalVariable.JOD)

String shahidExcpectedPrice = (businessList['amount']).toString() + pricesEnum.JOD.shahidPrice

String evergentExcpectedPrice = (businessList['amount']).toString().replace('.', '٫') +'0'+pricesEnum.JOD.evergentPrice

WebUI.click(findTestObject(('Object Repository/paymentThreeLanguages/' + GlobalVariable.objLanguage) + '/subscribeNowButton'))

WebUI.delay(15)

WebUI.refresh()

WebUI.waitForElementPresent(findTestObject('Object Repository/CCtexts/SubscriptionCongratsMsg'), 10)

//evergent price check
int currentTab = WebUI.getWindowIndex()

JavascriptExecutor js = ((driver) as JavascriptExecutor)

js.executeScript('window.open();')

WebUI.switchToWindowIndex(currentTab + 1)

//WebUI.openBrowser(GlobalVariable.evergentDevUrl)
WebUI.navigateToUrl(GlobalVariable.evergentDevUrl)

WebUI.setText(findTestObject('Object Repository/Evergent/email'), GlobalVariable.evergentUsername)

WebUI.click(findTestObject('Object Repository/Evergent/password'))

WebUI.setText(findTestObject('Object Repository/Evergent/password'), GlobalVariable.evergentPassword)

WebUI.click(findTestObject('Object Repository/Evergent/submit'))

WebUI.click(findTestObject('Object Repository/Evergent/selectMarketArea'))

WebUI.click(findTestObject('Object Repository/Evergent/JODMarket'))

WebUI.click(findTestObject('Object Repository/Evergent/marketSubmit-SearchButton'))

WebUI.click(findTestObject('Object Repository/Evergent/accountManagement'))

WebUI.setText(findTestObject('Object Repository/Evergent/email'), Email)

WebUI.click(findTestObject('Object Repository/Evergent/marketSubmit-SearchButton'))


String evergentSKU = WebUI.getText(findTestObject('Object Repository/Evergent/evergentSKU'))

String evergentPackage = WebUI.getText(findTestObject('Object Repository/Evergent/evergentPackage'))

WebUI.click(findTestObject('Object Repository/Evergent/BillingFinance'))

String evergentPrice = WebUI.getText(findTestObject('Object Repository/Evergent/evergentPrice'))

String productName=businessList['productName'].toString().trim()

String sku=businessList['sku'].toString().trim()

String sheetName = new Common().createSheet(GlobalVariable.JOD, GlobalVariable.SPORT)

//Check prices
if (shahidPrice.trim().toString().equals(shahidExcpectedPrice.trim().toString()) && evergentPrice.trim().toString().equals(evergentExcpectedPrice.trim().toString())) {
    KeywordUtil.markPassed('prices match')
} else {
	priceFlag=false
    KeywordUtil.markFailed((((((('prices not match. -shahidPrice:: ' + shahidPrice) + '. - shahidExcpectedPrice:: ') + shahidExcpectedPrice) + 
        '. -evergentPrice:: ') + evergentPrice) + '. -evergentExcpectedPrice:: ') + evergentExcpectedPrice)

    new Common().updatePrice(sheetName, shahidPrice, shahidExcpectedPrice, evergentPrice, evergentExcpectedPrice)
}

//Check Skus
if (evergentSKU.trim().equals(sku.trim())) {
	KeywordUtil.markPassed('Skus match')
} else {
	skuFlag=false
	KeywordUtil.markFailed('Skus not match. -evergent SKU:: ' + evergentSKU + '. - business Sku:: ' + sku)
	new Common().updateSKU(sheetName, evergentSKU, sku)
}

//Check Product Name
if (evergentPackage.equals(productName.substring(0, productName.length() - 1))) {
	KeywordUtil.markPassed('Product Names match')
} else {
	productNameFlag=false
	KeywordUtil.markFailed('Product Names not match. -evergent Package:: ' + evergentPackage + '. - business Product Name:: ' + productName)
	new Common().updatePackageName(sheetName,evergentPackage,productName)
}

if(priceFlag&&productNameFlag&&skuFlag) {
	new Common().updateStatus(sheetName, Email, 'Failed')
}



