import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.Common as Common

new Common().navigateToShahid(GlobalVariable.ToshibaPromoPageUrl)

//Verify Main Bar Components
new Common().VerifyPromoPagesMainBarComponents()

//Verify Center Section
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/ToshibaPromoPgae/toshibaTVImage'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/ToshibaPromoPgae/toshibaPromoDescriptionText'), 3)

		WebUI.click(findTestObject('Object Repository/PromoPages/ToshibaPromoPgae/activeShahidVIPButton'))
		WebUI.delay(3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/ToshibaPromoPgae/Sub-activeShahidVIPButton'), 2)
		WebUI.back()

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/ToshibaPromoPgae/termsAndConditionsText'), 3)

//Verify Footer Elements
new Common().verifyFooter()

WebUI.closeBrowser()