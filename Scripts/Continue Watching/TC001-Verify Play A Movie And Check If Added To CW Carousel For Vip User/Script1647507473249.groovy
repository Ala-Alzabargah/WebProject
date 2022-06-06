import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import shahid.Common as Common

new Common().navigateToShahid()

new Common().login(GlobalVariable.VipUser, GlobalVariable.VipUserPassword)

new Common().selectUser()

new Common().checkLanguage()

WebUI.click(findTestObject('Object Repository/'+GlobalVariable.objLanguage+'/HomeScreen/MenuBar/CommonElements/moviesLink'))
new Common().addAssetToCW()

WebUI.closeBrowser()