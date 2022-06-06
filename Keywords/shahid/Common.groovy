package shahid

import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.SimpleDateFormat
import com.kms.katalon.core.configuration.RunConfiguration
import org.apache.commons.lang.RandomStringUtils
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.FillPatternType
import org.apache.poi.ss.usermodel.IndexedColors
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field.Xpath
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.github.javafaker.Faker
import org.apache.poi.xssf.usermodel.XSSFCellStyle
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.keyword.excel.ExcelKeywords
import org.apache.poi.ss.usermodel.Row as Row
import org.apache.poi.ss.usermodel.Cell as Cell

import internal.GlobalVariable

public class Common{

	String DeviceName=MobileDriverFactory.getDeviceName()

	def public devicePlatform() {
		Map<String,String> system = new HashMap<>()
		system = RunConfiguration.getExecutionProperties().getAt('drivers').getAt('system')
		GlobalVariable.device=system.keySet().stream().findFirst().get()
		String devicePlatform

		if(GlobalVariable.device==GlobalVariable.mobile) {
			GlobalVariable.devicePlatform=system.getAt(GlobalVariable.device).getAt('devicePlatform')
		}else {
			GlobalVariable.devicePlatform=system.getAt(GlobalVariable.device).getAt('browserType')
		}
	}

	@Keyword
	public def getPackagePrice(String shahidPackage,String plan,String country){
		String packageName=shahidPackage+'/'+plan
		Sheet sheet
		def businessMap = [:]
		Row row
		int rowNumber
		Workbook  workbookXLS = ExcelKeywords.getWorkbook(GlobalVariable.pricePackageSheet)
		sheet = workbookXLS.getSheet(country)
		int rowIndex = sheet.getLastRowNum()
		for(def i=0;i<sheet.getLastRowNum();i++) {
			row =sheet.getRow(i)
			Cell c = row.getCell(0);
			String value = c.getStringCellValue();
			if(value.equals(packageName)) {
				rowNumber=i+1
			}
		}
		print "shahidPackage:: "+shahidPackage+" plan:: "+plan
		print "rowNumber:: "+rowNumber

		businessMap['productName'] =ExcelKeywords.getCellByAddress(sheet, 'B'+rowNumber)
		businessMap['sku'] =ExcelKeywords.getCellByAddress(sheet, 'C'+rowNumber)
		businessMap['amount'] =ExcelKeywords.getCellByAddress(sheet, 'E'+rowNumber)
		return businessMap
	}

	@Keyword
	public String createSheet(String currency,String packageName){
		//currentDate
		def date = new Date()
		def sdf = new SimpleDateFormat('MM-d-yyyy')
		String currentDate= sdf.format(date)
		Workbook  workbookXLS = ExcelKeywords.getWorkbook(GlobalVariable.pricePackageSheet)
		Boolean sheetNameFlag=true
		String sheetName= 'price check'+currency+currentDate
		for(int i=0;i<workbookXLS.getNumberOfSheets();i++) {
			if(sheetName.equals(workbookXLS.getSheetName(i))){
				sheetNameFlag=false
			}
		}
		if(sheetNameFlag) {
			ExcelKeywords.createExcelSheet(workbookXLS,sheetName)
			Sheet sheet = workbookXLS.getSheet(sheetName)

			ExcelKeywords.setValueToCellByAddress(sheet, 'A1', 'Package name')
			ExcelKeywords.setValueToCellByAddress(sheet, 'B1', 'Shahid Price')
			ExcelKeywords.setValueToCellByAddress(sheet, 'C1', 'Expected Shahid Price')
			ExcelKeywords.setValueToCellByAddress(sheet, 'D1', 'Evergent Price')
			ExcelKeywords.setValueToCellByAddress(sheet, 'E1', 'Expected Evergent Price')
			ExcelKeywords.setValueToCellByAddress(sheet, 'F1', 'Evergent SKU')
			ExcelKeywords.setValueToCellByAddress(sheet, 'G1', 'Expected SKU')
			ExcelKeywords.setValueToCellByAddress(sheet, 'H1', 'Evergent Package Name')
			ExcelKeywords.setValueToCellByAddress(sheet, 'I1', 'Expected Package Name')
			ExcelKeywords.setValueToCellByAddress(sheet, 'J1', 'Environment')
			ExcelKeywords.setValueToCellByAddress(sheet, 'K1', 'Status')
			ExcelKeywords.setValueToCellByAddress(sheet, 'L1', 'User')
			ExcelKeywords.setValueToCellByAddress(sheet, 'A2', packageName)
			ExcelKeywords.saveWorkbook(GlobalVariable.pricePackageSheet, workbookXLS)
		}
		return sheetName

	}

	@Keyword
	public def updatePrice(String sheetName,String shahidPrice,String shahidExcpectedPrice,String evergentPrice,String evergentExcpectedPrice){

		Workbook  workbookXLS = ExcelKeywords.getWorkbook(GlobalVariable.pricePackageSheet)
		Sheet sheet = workbookXLS.getSheet(sheetName)
		int lastRowNum = sheet.getLastRowNum() +1
		ExcelKeywords.setValueToCellByAddress(sheet, 'B'+lastRowNum, shahidPrice)
		ExcelKeywords.setValueToCellByAddress(sheet, 'C'+lastRowNum, shahidExcpectedPrice)
		ExcelKeywords.setValueToCellByAddress(sheet, 'D'+lastRowNum, evergentPrice)
		ExcelKeywords.setValueToCellByAddress(sheet, 'E'+lastRowNum, evergentExcpectedPrice)
		ExcelKeywords.saveWorkbook(GlobalVariable.pricePackageSheet, workbookXLS)
	}

	@Keyword
	public def updateSKU(String sheetName,String evergentSKU,String sku){
		Workbook  workbookXLS = ExcelKeywords.getWorkbook(GlobalVariable.pricePackageSheet)
		Sheet sheet = workbookXLS.getSheet(sheetName)
		int lastRowNum = sheet.getLastRowNum() + 1
		ExcelKeywords.setValueToCellByAddress(sheet, 'F'+lastRowNum, evergentSKU)
		ExcelKeywords.setValueToCellByAddress(sheet, 'G'+lastRowNum, sku)
		ExcelKeywords.saveWorkbook(GlobalVariable.pricePackageSheet, workbookXLS)
	}

	@Keyword
	public def updatePackageName(String sheetName,String evergentPackage,String productName){
		Workbook  workbookXLS = ExcelKeywords.getWorkbook(GlobalVariable.pricePackageSheet)
		Sheet sheet = workbookXLS.getSheet(sheetName)
		int lastRowNum = sheet.getLastRowNum() +1
		ExcelKeywords.setValueToCellByAddress(sheet, 'H'+lastRowNum, evergentPackage)
		ExcelKeywords.setValueToCellByAddress(sheet, 'I'+lastRowNum, productName)
		ExcelKeywords.saveWorkbook(GlobalVariable.pricePackageSheet, workbookXLS)
	}

	@Keyword
	public def updateStatus(String sheetName,String user,String status){
		Workbook  workbookXLS = ExcelKeywords.getWorkbook(GlobalVariable.pricePackageSheet)
		Sheet sheet = workbookXLS.getSheet(sheetName)
		int lastRowNum = sheet.getLastRowNum() + 1
		ExcelKeywords.setValueToCellByAddress(sheet, 'J'+lastRowNum, RunConfiguration.getExecutionProfile())
		ExcelKeywords.setValueToCellByAddress(sheet, 'K'+lastRowNum, status)
		ExcelKeywords.setValueToCellByAddress(sheet, 'L'+lastRowNum, user)
		ExcelKeywords.saveWorkbook(GlobalVariable.pricePackageSheet, workbookXLS)
	}

	def public clickAtMyAccount() {

		if(GlobalVariable.device==GlobalVariable.mobile) {
			WebUI.delay(3)
			Mobile.swipe(0, 600, 0, 0)
			WebUI.click(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/HomeScreen/MenuBar/MyaccountLink'))
		}else {
			WebUI.mouseOver(findTestObject('Object Repository/' + GlobalVariable.objLanguage + '/Settings Screen/settingsLink'))
			WebUI.click(findTestObject('Object Repository/' + GlobalVariable.objLanguage + '/Settings Screen/accountSettingsLink'))
		}

		WebUI.waitForPageLoad(8)
	}

	@Keyword
	def public swipe(int y=700) {

		if(GlobalVariable.device==GlobalVariable.mobile) {
			Mobile.swipe(0, y, 0, 0)
		}else {
			WebUI.scrollToPosition(0, y)
		}

		WebUI.waitForPageLoad(8)
	}


	public String setNewPinCode() {
		def a = 1

		def x = 0

		def y = 0

		def codeDigits = []

		String newCode = ''
		for (def c = 1; c <= 4; c++) {
			(codeDigits[x]) = (Math.abs(new Random().nextInt() % [9]) + 0)

			def Xpath = '(//input[@type="tel"])' + [c]

			TestObject digit = WebUI.modifyObjectProperty(findTestObject('Object Repository/Settings Screen/Parental control interface/codeDigitField'),
					'xpath', 'equals', Xpath, true)

			WebUI.setText(digit, (codeDigits[x]).toString())

			newCode += (codeDigits[x]).toString()

			x++
		}
		return newCode
	}

	@Keyword
	def public navigateToShahid(String pageUrl=GlobalVariable.ShahidUrl) {

		WebUI.openBrowser(pageUrl)

		//		WebUI.authenticate(pageUrl, 'FRONTENDUSER', 'aUCmNKHTCyLrW3eJ', 12)

		WebUI.maximizeWindow(FailureHandling.OPTIONAL)
		popupNotification()
		WebUI.click(findTestObject('Object Repository/Login/agreeButton'),FailureHandling.OPTIONAL)

		WebUI.click(findTestObject('Object Repository/Login/downloadAppButton'),FailureHandling.OPTIONAL)
	}

	@Keyword
	def public selectPackage(String packageType) {
		new Common().checkLanguage()
		if(GlobalVariable.device==GlobalVariable.mobile) {
			if(GlobalVariable.VIP==packageType) {
				new Common().JSclick(findTestObject('Object Repository/subscribtionPage/joinNowButton'))
				WebUI.delay(3)
			}else if(GlobalVariable.SPORT==packageType) {
				WebUI.click(findTestObject('Object Repository/paymentThreeLanguages/'+GlobalVariable.objLanguage+'/chooseYourPackageSport'))
				new Common().JSclick(findTestObject('Object Repository/subscribtionPage/joinNowButton'))
				WebUI.delay(3)
			}else if(GlobalVariable.Ultimate==packageType) {
				WebUI.delay(2)
				WebUI.click(findTestObject('Object Repository/upgradeAndDowngrade/payment/selectUltimateButton'))
				WebUI.click(findTestObject('Object Repository/upgradeAndDowngrade/payment/selectUltimatePackage'))
			}
		}else {
			if(GlobalVariable.VIP==packageType) {
				WebUI.delay(3)
				WebUI.click(findTestObject('Object Repository/'+GlobalVariable.objLanguage+'/choosePackageButton'))
				WebUI.delay(1)
			}else if(GlobalVariable.SPORT==packageType) {
				WebUI.click(findTestObject('Object Repository/Settings Screen/'+GlobalVariable.objLanguage+'/chooseYourPackageSportWeb'))
			}else if(GlobalVariable.Ultimate==packageType) {
				WebUI.click(findTestObject('Object Repository/upgradeAndDowngrade/payment/selectUltimateButton'))
				WebUI.click(findTestObject('Object Repository/upgradeAndDowngrade/payment/selectUltimatePackage'))
			}
		}
		WebUI.waitForPageLoad(8)
	}

	@Keyword
	def tapAtBurgerMenu() {
		WebUI.delay(3)
		if (WebUI.waitForElementVisible(findTestObject('Login/burgerIcon'), 3)) {
			WebUI.click(findTestObject('Login/burgerIcon'))
		}
	}

	@Keyword
	def tapAtbackToUserProfiles() {
		WebUI.waitForPageLoad(5)
		if(GlobalVariable.device==GlobalVariable.mobile) {
			tapAtBurgerMenu()
			WebUI.click(findTestObject('Object Repository/HomeScreen/backToUserProfilesPage'))
		}else if(GlobalVariable.device==GlobalVariable.webUI) {
			WebUI.mouseOver(findTestObject('Object Repository/HomeScreen/mainbarUserProfileIcon'))
			WebUI.click(findTestObject('Object Repository/HomeScreen/backToUserProfilesPage'))
		}

		WebUI.waitForPageLoad(5)
	}

	@Keyword
	public String getParentalControlCode(String userType){
		Sheet sheet
		Workbook  workbookXLS = ExcelKeywords.getWorkbook(GlobalVariable.parentalControlCodeDataPath)
		sheet = workbookXLS.getSheet(userType)

		return ExcelKeywords.getCellValueByAddress(sheet, 'A2')
	}


	@Keyword
	public String getUserProfileName(String userType,String profileType,int columnNUm = 2){


		String name
		Workbook  workbookXLS = ExcelKeywords.getWorkbook(GlobalVariable.parentalControlCodeDataPath)
		String sheetName="userprofilename"+userType

		ExcelKeywords.createExcelSheet(workbookXLS, sheetName)

		Sheet sheet = workbookXLS.getSheet(sheetName)

		if(profileType.equals(GlobalVariable.Adult)) {
			name = ExcelKeywords.getCellValueByAddress(sheet, 'A'+columnNUm)
		}else if(profileType.equals(GlobalVariable.Kids)) {
			name = ExcelKeywords.getCellValueByAddress(sheet, 'C'+columnNUm)
		}

		ExcelKeywords.saveWorkbook(GlobalVariable.parentalControlCodeDataPath, workbookXLS)
		println "getUserProfileName:: "+name
		return name
	}

	@Keyword
	def public void NavigateTo(String pageUrl) {

		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(pageUrl)

		new Common().popupNotification()
		if(WebUI.waitForElementPresent(findTestObject('HomeScreen/dissmissButton'), 6)) {
			WebUI.click(findTestObject('HomeScreen/dissmissButton'))
		}
	}

	@Keyword
	def tapAt(String buttonName) {
		int DeviceHeight=(int)Mobile.getDeviceHeight()
		println "DeviceHeight:: "+DeviceHeight
		int y


		if(buttonName=='Facebook') {
			println "Facebook"
			y=DeviceHeight*GlobalVariable.facebookButtonSizeY
			println "Y inside Facebook if::"+y
		}else if(buttonName=='Google') {
			println "Google"
			y=DeviceHeight*GlobalVariable.googleButtonSizeY
			println "Y inside Google if::"+y
		}else if(buttonName=='Apple') {
			println "Apple"
			y=DeviceHeight*GlobalVariable.appleButtonSizeY
			println "Y inside Apple if::"+y
		}
		println "X::"+200+"|| Y:: "+y
		Mobile.tapAtPosition(200, y)
	}

	@Keyword
	def public checkLanguage() {
		String url=WebUI.getUrl()
		if (url.contains('/fr/')) {
			GlobalVariable.objLanguage = 'fr'
		} else if (url.contains('/en/')) {
			GlobalVariable.objLanguage = 'en'
		} else if (url.contains('/ar/')) {
			GlobalVariable.objLanguage = 'ar'
		}
	}

	@Keyword
	boolean isEmailValid(String email) {
		String  emailPattern = /[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[A-Za-z]{2,4}/
		return email ==~ emailPattern
	}

	@Keyword
	def popupNotification(){

		if(WebUI.waitForElementPresent(findTestObject('Object Repository/iframePOPup'), 3)){
			WebUI.switchToFrame(findTestObject('Object Repository/iframePOPup'), 3)
			WebUI.click(findTestObject('Object Repository/popupNot/closePopup'),FailureHandling.CONTINUE_ON_FAILURE)
		}
		WebUI.switchToDefaultContent()
	}

	@Keyword
	def selectUser(int userNumber=0) {
		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 6)
		List<WebElement> UserProfile = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		WebUI.delay(2)

		for(int i=0;i<2;i++) {
			try {
				UserProfile[userNumber].click()
				break
			}
			catch(Exception e) {
				WebUI.click(findTestObject('Object Repository/Login/continueButton'))
			}
		}


		new Common().popupNotification()

		checkLanguage()
	}



	def public login(String username,String password,int loginType=0) {

		tapAtBurgerMenu()
		if(loginType==0) {
			WebUI.click(findTestObject('Login/loginButton'))
		}
		WebUI.setText(findTestObject('Object Repository/Login/usernameField'), username)

		WebUI.click(findTestObject('Object Repository/Login/continueButton'))

		for(int i=0;i<2;i++) {
			try {
				WebUI.setText(findTestObject('Object Repository/Login/PasswordField'), password)
				break
			}
			catch(Exception e) {
				WebUI.click(findTestObject('Object Repository/Login/continueButton'))
			}
		}

		WebUI.click(findTestObject('Object Repository/Login/continueButton'))
	}


	def public facebookLogin(String username,String password) {

		tapAtBurgerMenu()
		WebUI.click(findTestObject('Login/loginButton'))
		WebUI.click(findTestObject('Object Repository/LoginScreen/facebookLoginButton'))
		WebUI.waitForPageLoad(10)
		WebUI.switchToWindowIndex(1)
		WebUI.waitForElementVisible(findTestObject('Object Repository/LoginScreen/Facebook/enterUsernameField'), 10)
		WebUI.setText(findTestObject('Object Repository/LoginScreen/Facebook/enterUsernameField'), username)
		WebUI.setText(findTestObject('Object Repository/LoginScreen/Facebook/enterPasswordField'), password)

		WebUI.click(findTestObject('Object Repository/LoginScreen/Facebook/loginButton'))

		WebUI.delay(1)
		WebUI.switchToWindowIndex(0)
		WebUI.delay(2)
	}

	@Keyword
	def public logout() {
		WebUI.waitForPageLoad(5)

		if(GlobalVariable.device==GlobalVariable.mobile) {
			tapAtBurgerMenu()
			WebUI.delay(3)

			WebUI.scrollToElement(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/logout'),
					3)

			WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/logout'))
		}else if(GlobalVariable.device==GlobalVariable.webUI) {

			WebUI.mouseOver(findTestObject('Object Repository/' + GlobalVariable.objLanguage + '/Settings Screen/settingsLink'))
			WebUI.click(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage) + '/logout'))
		}


		WebUI.delay(8)
	}
	@Keyword
	public def exitKids(String password){
		WebUI.verifyElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/UserProfile/Kids Interface/exitKidsIntefaceTitle'),
				7)

		WebUI.verifyElementVisible(findTestObject('Object Repository/UserProfile/Kids Interface/pinCodeImg'))

		WebUI.verifyElementVisible(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/UserProfile/Kids Interface/exitKidsModeSubtext'))

		WebUI.verifyElementVisible(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/UserProfile/Kids Interface/enterCodeText'))

		WebUI.verifyElementVisible(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/UserProfile/Kids Interface/forgotCodeText'))

		WebUI.click(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/UserProfile/Kids Interface/resetCodeText'))

		WebUI.verifyElementVisible(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/UserProfile/Kids Interface/passwordPopupTitle'))

		WebUI.verifyElementVisible(findTestObject('Object Repository/UserProfile/Kids Interface/cancelButton'))

		//Wrong password
		WebUI.setText(findTestObject('Object Repository/UserProfile/Kids Interface/passwordField'), '0o9i8u')

		WebUI.click(findTestObject('Object Repository/UserProfile/Kids Interface/continueButton'))

		WebUI.waitForElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/UserProfile/Kids Interface/wrongPasswordMsg'),
				5)

		WebUI.setText(findTestObject('Object Repository/UserProfile/Kids Interface/passwordField'), password)

		WebUI.click(findTestObject('Object Repository/UserProfile/Kids Interface/continueButton'))

		WebUI.verifyElementPresent(findTestObject(('Object Repository/' + GlobalVariable.objLanguage) + '/Settings Screen/Parental control interface/parentalControlInterfaceText'),
				5,FailureHandling.CONTINUE_ON_FAILURE)

		if (!(WebUI.getUrl().contains(GlobalVariable.objLanguage + '/widgets/parental-control'))) {
			KeywordUtil.markFailed('Wrong page:: ' + WebUI.getUrl())
		}
	}

	@Keyword
	public def updateParentalControlCode(String newCode,String userType){
		Sheet sheet

		//currentDate
		def date = new Date()
		def sdf = new SimpleDateFormat('MM-d-yyyy||HH:mm:ss')
		String currentDate= sdf.format(date)
		Workbook  workbookXLS = ExcelKeywords.getWorkbook(GlobalVariable.parentalControlCodeDataPath)
		ExcelKeywords.createExcelSheet(workbookXLS, userType)
		sheet = workbookXLS.getSheet(userType)
		ExcelKeywords.setValueToCellByAddress(sheet, 'A1', 'Pin Code')
		ExcelKeywords.setValueToCellByAddress(sheet, 'B1', 'Date')
		ExcelKeywords.setValueToCellByAddress(sheet, 'A2', newCode)
		ExcelKeywords.setValueToCellByAddress(sheet, 'B2', currentDate)


		ExcelKeywords.saveWorkbook(GlobalVariable.parentalControlCodeDataPath, workbookXLS)
	}

	@Keyword
	def ScrollUntilElementPresent(String assetXpath) {
		int retries=1
		for (int i = 0;i<retries; i++) {
			try {

				WebUI.verifyElementVisibleInViewport(findTestObject(assetXpath),3)
			}
			catch (Exception x) {

				scrollElementIntoView()

				retries++
			}
		}
	}

	@Keyword
	def  scrollElementIntoView() {
		WebDriver driver = DriverFactory.getWebDriver()
		JavascriptExecutor js = (JavascriptExecutor) driver
		js.executeScript("javascript:window.scrollBy(550,1000)")
	}

	@Keyword
	def  scrollElementIntoViewLess() {
		WebDriver driver = DriverFactory.getWebDriver()
		JavascriptExecutor js = (JavascriptExecutor) driver
		js.executeScript("javascript:window.scrollBy(100,500)")
	}

	@Keyword
	def  scrollElementIntoViewMore() {
		WebDriver driver = DriverFactory.getWebDriver()
		JavascriptExecutor js = (JavascriptExecutor) driver
		js.executeScript("javascript:window.scrollBy(100,2500)")
	}


	@Keyword
	def  scrollElementIntoViewTop10() {

		int scroll = 70;

		for(int i=1 ; i <=scroll; i++) {

			WebDriver driver = DriverFactory.getWebDriver()
			JavascriptExecutor js = (JavascriptExecutor) driver
			js.executeScript("javascript:window.scrollBy(100,700)")

			if(WebUI.waitForElementPresent(findTestObject('LandingPages/en/top10CarouselTitle'), 3)) {
				scroll = i;
			}

		}

	}



	@Keyword
	public String getRandomName(String userType,String name='',String profileType,int columnNUm=2){



		//currentDate
		def date = new Date()
		def sdf = new SimpleDateFormat('MM-d-yyyy||HH:mm:ss')
		String currentDate= sdf.format(date)

		if(name.isEmpty()) {
			Faker faker = new Faker()

			name= faker.name().firstName()
		}

		Workbook  workbookXLS = ExcelKeywords.getWorkbook(GlobalVariable.parentalControlCodeDataPath)
		String sheetName="userprofilename"+userType
		ExcelKeywords.createExcelSheet(workbookXLS,sheetName)
		Sheet sheet = workbookXLS.getSheet(sheetName)

		//		int columnNUm = sheet.getRow(0).getLastCellNum()

		if(profileType.equals(GlobalVariable.Adult)) {
			ExcelKeywords.setValueToCellByAddress(sheet, 'A1', 'Adult')
			ExcelKeywords.setValueToCellByAddress(sheet, 'B1', 'Change date')
			ExcelKeywords.setValueToCellByAddress(sheet, 'A'+columnNUm, name)
			ExcelKeywords.setValueToCellByAddress(sheet, 'B'+columnNUm, currentDate)
		}else if(profileType.equals(GlobalVariable.Kids)) {
			ExcelKeywords.setValueToCellByAddress(sheet, 'C1', 'Kids')
			ExcelKeywords.setValueToCellByAddress(sheet, 'D1', 'Change date')
			ExcelKeywords.setValueToCellByAddress(sheet, 'C'+columnNUm, name)
			ExcelKeywords.setValueToCellByAddress(sheet, 'D'+columnNUm, currentDate)
		}

		ExcelKeywords.saveWorkbook(GlobalVariable.parentalControlCodeDataPath, workbookXLS)

		println "getRandomName:: "+name
		return name}


	@Keyword
	def selectLanguage(){
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement languageList=driver.findElement(By.xpath("//div[contains(@class,'genreBanner_plusContainer')]//div[contains(@class,'languageTag_language_')]"))
		languageList.click()
		int num=Math.floor(Math.random()*(2-1+1)+1)
		println "*********num:: "+num
		String languageXpath='(//label[contains(@class,"genreBanner_seasonSelectorLabel_")])['+num+']'
		driver.findElement(By.xpath(languageXpath)).click()

	}

	@Keyword
	def tapAtProfile(String User) {
		WebDriver driver = DriverFactory.getWebDriver()
		JavascriptExecutor executor = ((driver) as JavascriptExecutor)

		try {
			WebElement element = driver.findElement(By.xpath(('//img[not(@class) and @alt=\'' + User) + '\']'))
			executor.executeScript('arguments[0].click();', element)
		}
		catch (Exception e) {
			driver.findElement(By.xpath('(//img[@style and not(@class)])[3]')).click()
		}
	}

	@Keyword
	def selectAvatar(){
		WebDriver driver = DriverFactory.getWebDriver()
		String generalAvatarXpath = findTestObject('Object Repository/UserProfile/generalAvatarPath').findPropertyValue("xpath")
		List<WebElement> avatarList = driver.findElements(By.xpath(generalAvatarXpath))
		int avatarListsize=avatarList.size()
		int AvatarNumber = RandomStringUtils.random(1,false,true)

		if(AvatarNumber<=0|| AvatarNumber>avatarListsize || AvatarNumber ==5 || AvatarNumber ==6){
			AvatarNumber =8
		}

		String avatarXpath=generalAvatarXpath+[AvatarNumber]
		println "avatarXpath:: "+avatarXpath
		TestObject avatar =WebUI.modifyObjectProperty(findTestObject('UserProfile/profile1alaa'), 'xpath', 'equals', avatarXpath, true)
		String Avatar6 =avatar.findProperty('src')
		WebUI.delay(2)
		WebUI.mouseOver(avatar)
		WebUI.click(avatar)
	}

	@Keyword
	def public search(String searchValue) {
		checkLanguage()
		WebUI.waitForElementVisible(findTestObject('Object Repository/HomeScreen/MenuBar/CommonElements/searchIcon'), 5)
		WebUI.click(findTestObject('Object Repository/HomeScreen/MenuBar/CommonElements/searchIcon'))
		WebUI.setText(findTestObject(('Object Repository/Top Navigation/' + GlobalVariable.objLanguage + '/searchField')), searchValue)
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/Show Pages/firstSearchResult'))
	}


	@Keyword
	public String getVochersData(String sheetName){
		//currentDate
		def date = new Date()
		def sdf = new SimpleDateFormat('MM-d-yyyy HH-mm-ss')
		String currentDate= sdf.format(date)
		Sheet sheet
		Workbook workbookXLS = ExcelKeywords.getWorkbook(GlobalVariable.voucherSheetPath)
		sheet = workbookXLS.getSheet(sheetName)
		int columns = sheet.getRow(1).lastCellNum
		ExcelKeywords.setValueToCellByAddress(sheet, 'C'+columns, currentDate)
		ExcelKeywords.setValueToCellByAddress(sheet, 'A'+columns, 'Used')
		println "columns:: "+columns
		String value=ExcelKeywords.getCellValueByAddress(sheet, 'B'+columns)
		ExcelKeywords.saveWorkbook(GlobalVariable.voucherSheetPath,workbookXLS)
		return value
	}


	@Keyword
	def public JSclick(TestObject obj){
		WebUiCommonHelper.findWebElement(obj, 60)
		WebElement element = WebUiCommonHelper.findWebElement(obj,60)
		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))
	}

	@Keyword
	def shahidSignup(String ShahidUsername, String ShahidPassword, int svod=1) {

		if (svod==1){
			if (WebUI.waitForElementVisible(findTestObject('loginThreeLanguages/hamburgerMenu'), 7)) {
				WebUI.click(findTestObject('loginThreeLanguages/hamburgerMenu'))
			}
			WebUI.delay(2)
			WebUI.click(findTestObject('Object Repository/HomeScreen/loginButton'))
			WebUI.delay(2)
			WebUI.waitForElementPresent(findTestObject('LoginScreen/usernameField'), 4)
			WebUI.setText(findTestObject('LoginScreen/usernameField'), ShahidUsername)
			WebUI.click(findTestObject('Object Repository/LoginScreen/continueButton'))

			try {
				WebUI.delay(2)
				for(int i=0;i<2;i++) {
					try {
						WebUI.setText(findTestObject('Object Repository/Login/PasswordField'), ShahidPassword)
						break
					}
					catch(Exception e) {
						WebUI.click(findTestObject('Object Repository/Login/continueButton'))
					}
				}
				WebUI.delay(2)
				WebUI.click(findTestObject('Object Repository/SignUpScreen/termsAndConditionsCheckbox'))
				WebUI.click(findTestObject('Object Repository/SignUpScreen/accepttoReceivePromotionsandNewsCheckbox'))
				WebUI.click(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/loginButton'))


			}
			catch(Exception e) {
				println "select profile"

			}
		}


	}

	@Keyword
	public def verifyFooter() {
		int lastRow
		checkLanguage()
		TestData footerValidationData = findTestData('Data Files/usersTypes/footerValidation')

		ScrollUntilElementPresent('Object Repository/Footers/footerUL')

		lastRow = footerValidationData.getAllData().size()
		WebUI.scrollToElement(findTestObject('Object Repository/Footers/homeFooter'), 4)
		String home = WebUI.getText(findTestObject('Object Repository/Footers/homeFooter'))
		String contactUs = WebUI.getText(findTestObject('Object Repository/Footers/contactUsFooter'))
		String helpCenter = WebUI.getText(findTestObject('Object Repository/Footers/helpCenterFooter'))
		String applications = WebUI.getText(findTestObject('Object Repository/Footers/applicationsFooter'))
		String termsAndConditions = WebUI.getText(findTestObject('Object Repository/Footers/termsAndConditionsFooter'))
		String latestNews = WebUI.getText(findTestObject('Object Repository/Footers/latestNewsFooter'))
		String privacyPolicy = WebUI.getText(findTestObject('Object Repository/Footers/privacyPolicyFooter'))
		def footerList = [
			home,
			contactUs,
			helpCenter,
			applications,
			termsAndConditions,
			latestNews,
			privacyPolicy
		]
		for (int i = 1; i <= lastRow; i++) {
			String dataFromDataFile = footerValidationData.getValue(GlobalVariable.objLanguage, i)
			if(!footerList[i-1].contains(dataFromDataFile)) {
				KeywordUtil.markFailed('Text not match :' + WebUI.getUrl())
				System.err.println 'footerList *********************'+ footerList[i-1]
				System.err.println 'footerList *********************'+ dataFromDataFile
			}
		}
	}

	@Keyword
	public def clickOnFooterElement(String footerElement) {
		verifyFooter()
		switch(footerElement) {
			case 'home':
				WebUI.click(findTestObject('Object Repository/Footers/homeFooter'))

				WebUI.delay(5)
				WebUI.waitForPageLoad(10)

				if (!(WebUI.getUrl().contains('/home'))) {
					KeywordUtil.markFailed('URL not match :' + WebUI.getUrl())
				}
				break

			case 'contact-us':
				WebUI.click(findTestObject('Object Repository/Footers/contactUsFooter'))

				WebUI.delay(5)
				WebUI.waitForPageLoad(10)

				if (!(WebUI.getUrl().contains('/contact-us'))) {
					KeywordUtil.markFailed('URL not match :' + WebUI.getUrl())
				}

				WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/callTheFollowingNumbers'), 2)
				WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/saudiArabia'), 2)
				WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/aeu'), 2)
				WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/hkj'), 2)
				WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/internationalNumber'), 2)
				WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/saudiArabiaNumber'), 2)
				WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/uaeNumber'), 2)
				WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/hkjNumber'), 2)
				WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/internationalNumberDigits'), 2)
				WebUI.verifyElementPresent(findTestObject('Object Repository/Footers/whatsappIcon'), 2)

				WebUI.scrollToElement(findTestObject('Object Repository/Footers/'+GlobalVariable.objLanguage+'/phone'), 3)
				WebUI.verifyElementPresent(findTestObject('Object Repository/Footers/'+GlobalVariable.objLanguage+'/Name'), 2)
				WebUI.verifyElementPresent(findTestObject('Object Repository/Footers/'+GlobalVariable.objLanguage+'/Email'), 2)
				WebUI.verifyElementPresent(findTestObject('Object Repository/Footers/'+GlobalVariable.objLanguage+'/Message'), 2)
				WebUI.verifyElementPresent(findTestObject('Object Repository/Footers/'+GlobalVariable.objLanguage+'/selectSubject'), 2)
				WebUI.verifyElementPresent(findTestObject('Object Repository/Footers/'+GlobalVariable.objLanguage+'/sendButton'), 2)

				break

			case 'help.shahid.mbc.net':

				WebUI.click(findTestObject('Object Repository/Footers/helpCenterClick'))

				WebUI.delay(5)
				WebUI.waitForPageLoad(10)

				WebUI.switchToWindowIndex(1)

				if (!(WebUI.getUrl().contains('help.shahid.mbc.net'))) {
					KeywordUtil.markFailed('URL not match :' + WebUI.getUrl())
				}
				WebUI.switchToWindowIndex(0)

				WebUI.navigateToUrl(GlobalVariable.ShahidUrl )

				break

			case 'applications':
				WebUI.click(findTestObject('Object Repository/Footers/applicationsFooter'))

				WebUI.delay(5)
				WebUI.waitForPageLoad(10)

				if (!(WebUI.getUrl().contains('/applications'))) {
					KeywordUtil.markFailed('URL not match :' + WebUI.getUrl())
				}
				break

			case 'terms-and-conditions':
				WebUI.click(findTestObject('Object Repository/Footers/termsAndConditionsFooter'))
				WebUI.delay(5)
				WebUI.waitForPageLoad(10)

				if (!(WebUI.getUrl().contains('/terms-and-conditions'))) {
					KeywordUtil.markFailed('URL not match :' + WebUI.getUrl())
				}

				break

			case 'privacy-policy':
				WebUI.click(findTestObject('Object Repository/Footers/privacyPolicyFooter'))
				WebUI.delay(5)
				WebUI.waitForPageLoad(10)
				if (!(WebUI.getUrl().contains('/privacy-policy'))) {
					KeywordUtil.markFailed('URL not match :' + WebUI.getUrl())
				}
				break


			case 'blog.shahid.mbc.net':
				WebUI.click(findTestObject('Object Repository/Footers/latestNewsFooter'))

				WebUI.delay(5)
				WebUI.waitForPageLoad(10)

				WebUI.switchToWindowIndex(1)

				if (!(WebUI.getUrl().contains('/blog.shahid.mbc.net'))) {
					KeywordUtil.markFailed('URL not match :' + WebUI.getUrl())
				}
				WebUI.switchToWindowIndex(0)
				break


			default:
				KeywordUtil.markFailed('Wrong Footer element:: '+footerElement)
				break

		}
		WebUI.back()
	}
	@Keyword
	def public void VerifyPromoPagesMainBarComponents() {
		tapAtBurgerMenu()
		String PageUrl= WebUI.getUrl()
		String PromoPageUrl
		if(PageUrl.contains('spotify') || PageUrl.contains('arabbank')){
			PromoPageUrl=1
		}else if(PageUrl.contains('mena') ){
			PromoPageUrl=2
		}

		switch (PromoPageUrl) {

			case '1':
				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/SpotifyPromoPage/MainBar/shahidIcon'),2)

				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/SpotifyPromoPage/MainBar/homePageLink'), 2)

			//				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/SpotifyPromoPage/MainBar/knowAboutShahid Know about'), 2)

				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/SpotifyPromoPage/MainBar/loginLink'), 2)
				break

			case '2':
				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/mainBar/shahidIcon'),2)

				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/mainBar/homePageLink'), 2)


			// here we add languagw switcher
				break

			default:
				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/shahidIcon'), 2)

				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/homePageLink'), 3)

				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/seriesAndProgramsLink'), 3)

				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/moviesLink'), 3)

				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/browseLink'), 3)

				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/liveLink'), 3)

				WebUI.verifyElementPresent(findTestObject("Object Repository/PromoPages/Menu Bar/searchIcon"), 3)

				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/loginLink'), 3)

				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/juniorLink'), 2)

				WebUI.click(findTestObject('Object Repository/PromoPages/Menu Bar/tryShahidVIPButton'))
				WebUI.delay(3)
				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/sub-tryShahidVIPButton'), 2)
				WebUI.back()
				break
		}
	}

	@Keyword
	def addAssetToCW(){
		WebDriver driver = DriverFactory.getWebDriver()


		ScrollUntilElementPresent('Object Repository/MovieScreen/firstItemOfCarousel')

		WebUI.mouseOver(findTestObject('Object Repository/MovieScreen/firstItemOfCarousel'))

		WebUI.click(findTestObject('Object Repository/MovieScreen/firstItemOfCarousel'))

		WebUI.waitForPageLoad(5)

		if (WebUI.waitForElementPresent(findTestObject('Object Repository/HomeScreen/comingSoon'), 5)) {
			WebUI.delay(5)
		} else {
			WebUI.doubleClick(findTestObject('Object Repository/MovieScreen/viewNowButton'))
		}

		WebUI.delay(6)

		WebElement playListIcon = driver.findElement(By.id('playlist-icon'))

		JavascriptExecutor executor = ((driver) as JavascriptExecutor)

		executor.executeScript('arguments[0].click();', playListIcon)

		WebElement pauseButton = driver.findElement(By.xpath("(//button[@type='button' and contains(@class,'playing')])[1]"))
		executor.executeScript('arguments[0].click();', pauseButton)
		WebUI.delay(4)
		String assetTitle = WebUI.getText(findTestObject('Object Repository/en/Continue Watching/showTitle'))

		WebElement playButton = driver.findElement(By.xpath('(//button[@type=\'button\' and contains(@class,\'paused\')])[1]'))


		executor.executeScript('arguments[0].click();', playButton)
		WebUI.clickOffset(findTestObject('Object Repository/VideoPlaybackScreen/playProgress'), 650, 0)

		println('********assetTitle:: '+assetTitle)
		executor.executeScript('arguments[0].click();', playButton)


		WebUI.delay(20)

		WebElement forwardButton = driver.findElement(By.xpath('//button[contains(@class,"step-forward")]'))

		executor.executeScript('arguments[0].click();', forwardButton)

		WebUI.delay(1)

		executor.executeScript('arguments[0].click();', forwardButton)

		WebUI.delay(40)

		executor.executeScript('arguments[0].click();', forwardButton)

		WebUI.delay(20)

		executor.executeScript('arguments[0].click();', pauseButton)

		WebUI.navigateToUrl(GlobalVariable.ShahidUrl)

		WebUI.waitForPageLoad(5)

		new Common().ScrollUntilElementPresent('Object Repository/HomeScreen/CW/CWCarousel')

		WebElement CWItem = driver.findElement(By.xpath(('(//img[@title="' + assetTitle) + '"])[1]'))

		CWItem.isDisplayed()

	}


	@Keyword
	public String getTitle(String SheetPath,String sheetName,String column,int counter){
		Sheet sheet
		Workbook  workbookXLS = ExcelKeywords.getWorkbook(SheetPath)
		sheet = workbookXLS.getSheet(sheetName)
		return ExcelKeywords.getCellValueByAddress(sheet,column+counter)

	}

	@Keyword
	public def updateResultSheet(String sheetPAth,String sheetName,String assetName,String watchedTime){
		Sheet sheet


		Workbook  workbookXLS = ExcelKeywords.getWorkbook(sheetPAth)
		println "workbookXLS.getAllNames()"+workbookXLS.numberOfSheets
		sheet = workbookXLS.getSheet(sheetName)


		sheet = workbookXLS.getSheet(sheetName)

		int columns = sheet.getRow(0).lastCellNum

		if(columns >2) {
			columns=columns+1
		}

		//Set Result
		ExcelKeywords.setValueToCellByAddress(sheet, 'A'+columns, assetName)
		ExcelKeywords.setValueToCellByAddress(sheet, 'B'+columns, watchedTime)


		ExcelKeywords.saveWorkbook(sheetPAth,workbookXLS)

	}

	@Keyword
	public def updateUpsellResultSheet(String messageType,String upselltype,String expectedDescription,String actualDescription,int count){
		Sheet sheet

		//currentDate
		def date = new Date()
		def sdf = new SimpleDateFormat('MM-d-yyyy')
		String currentDate= sdf.format(date)
		String sheetName = upselltype+currentDate

		Workbook  workbookXLS = ExcelKeywords.getWorkbook(GlobalVariable.upsellresultSheetPath)
		println "workbookXLS.getAllNames()"+workbookXLS.numberOfSheets
		ExcelKeywords.createExcelSheet(workbookXLS, sheetName)
		ExcelKeywords.saveWorkbook(GlobalVariable.upsellresultSheetPath,workbookXLS)


		sheet = workbookXLS.getSheet(sheetName)
		ExcelKeywords.setValueToCellByAddress(sheet, 'A1', "Message Type")


		ExcelKeywords.setValueToCellByAddress(sheet, 'B1', "Expected Description")


		ExcelKeywords.setValueToCellByAddress(sheet, 'C1', "Actual Description")

		//Set Result
		ExcelKeywords.setValueToCellByAddress(sheet, 'A'+count, messageType)
		ExcelKeywords.setValueToCellByAddress(sheet, 'B'+count, expectedDescription)
		ExcelKeywords.setValueToCellByAddress(sheet, 'C'+count, actualDescription)

		ExcelKeywords.saveWorkbook(GlobalVariable.upsellresultSheetPath,workbookXLS)

	}

	@Keyword
	public String getUpsellTitle(String sheetName,String column,int counter){
		Sheet sheet
		Workbook  workbookXLS = ExcelKeywords.getWorkbook(GlobalVariable.upsellDataSheetPath)
		sheet = workbookXLS.getSheet(sheetName)

		return ExcelKeywords.getCellValueByAddress(sheet,column+counter)

	}

	@Keyword
	def upSellingScreenshot(String upSellType,String testcaseName,String status){

		String picName

		def date = new Date()
		def sdf = new SimpleDateFormat("|MM-d-yyyy HH-mm-ss")
		String currentDate= sdf.format(date)
		def sdf1 = new SimpleDateFormat("|MM-d-yyyy")
		String currentDateWithoutTime= sdf1.format(date)
		String browserName= DriverFactory.getExecutedBrowser().getName()

		WebUI.delay(1)
		WebUI.takeScreenshot(GlobalVariable.ScreenShotsFolderPath+'/'+"upSellingBy"+upSellType+currentDateWithoutTime+'/'+status+'/'+testcaseName+currentDate+'.png')
	}
}
