import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.google.api.client.repackaged.org.apache.commons.codec.binary.StringUtils as StringUtils
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.apache.commons.lang3.StringUtils as StringUtils

CustomKeywords.'Shahid.getSssesion'()

//control json
def slurper = new groovy.json.JsonSlurper()

//Set JWT Into s-ssesion
ResponseObject packageConfigurationRes

String column

for (int j = 0; j < 3; j++) {
    // English Language
       if (j == 0) {
        packageConfigurationRes = WS.sendRequest(findTestObject('Object Repository/Upselling Messages/packageConfiguration', 
                [('ssession') : GlobalVariable.Ssession, ('language') : 'EN', ('acceptLanguage') : 'en']))

        column = 'V'

        CustomKeywords.'Shahid.verifyStatusCode'(packageConfigurationRes, 200)

        def packageConfigurationResBody = slurper.parseText(packageConfigurationRes.getResponseBodyContent())


        CustomKeywords.'sample.upsellingMessages.getPlayerUpsellingMessagesMap'(packageConfigurationResBody, 'SHAHID_VIP_GEA_SPORT', 
            'GEA')
    } else if (j == 1) {
        packageConfigurationRes = WS.sendRequest(findTestObject('Object Repository/Upselling Messages/packageConfiguration', 
                [('ssession') : GlobalVariable.Ssession, ('language') : 'AR', ('acceptLanguage') : 'ar']))

        column = 'U'

        CustomKeywords.'Shahid.verifyStatusCode'(packageConfigurationRes, 200)

        def packageConfigurationResBody = slurper.parseText(packageConfigurationRes.getResponseBodyContent())

           CustomKeywords.'sample.upsellingMessages.getPlayerUpsellingMessagesMap'(packageConfigurationResBody, 'SHAHID_VIP_GEA_SPORT', 
            'GEA')
    } else {
        packageConfigurationRes = WS.sendRequest(findTestObject('Object Repository/Upselling Messages/packageConfiguration', 
                [('ssession') : GlobalVariable.Ssession, ('language') : 'FR', ('acceptLanguage') : 'fr']))

        column = 'W'

        CustomKeywords.'Shahid.verifyStatusCode'(packageConfigurationRes, 200)

        def packageConfigurationResBody = slurper.parseText(packageConfigurationRes.getResponseBodyContent())

          CustomKeywords.'sample.upsellingMessages.getPlayerUpsellingMessagesMap'(packageConfigurationResBody, 'SHAHID_VIP_GEA_SPORT', 
            'GEA')
    }
    
    if (!((GlobalVariable.productMap['description']).toString().trim().equals(CustomKeywords.'sample.upsellingMessages.getDataByMessages'(
            14, column)))) {
        CustomKeywords.'sample.upsellingMessages.updateUpsellResultSheet'(CustomKeywords.'sample.upsellingMessages.getDataByMessages'(
                14, 'B'), 'byMessages', CustomKeywords.'sample.upsellingMessages.getDataByMessages'(14, column), GlobalVariable.catalogMap[
            'description'])

        System.err.println('Here:' + StringUtils.difference(CustomKeywords.'sample.upsellingMessages.getDataByMessages'(
                    14, column).toString().trim(), (GlobalVariable.catalogMap['description']).toString().trim()))

        KeywordUtil.markFailed((('description not matche Expected :' + CustomKeywords.'sample.upsellingMessages.getDataByMessages'(
                14, column)) + 'Actual :') + (GlobalVariable.catalogMap['description']))
    }
    
    if (!((GlobalVariable.productMap['cta_upgrade_now'].toString().trim()).equals(CustomKeywords.'sample.upsellingMessages.getDataByMessages'(
            20, column)))) {
        CustomKeywords.'sample.upsellingMessages.updateUpsellResultSheet'(CustomKeywords.'sample.upsellingMessages.getDataByMessages'(
                20, 'B'), 'byMessages', CustomKeywords.'sample.upsellingMessages.getDataByMessages'(20, column), GlobalVariable.productMap[
            'cta_upgrade_now'])

        KeywordUtil.markFailed((('cta_upgrade_now not matche Expected :' + CustomKeywords.'sample.upsellingMessages.getDataByMessages'(
                20, column)) + 'Actual :') + (GlobalVariable.productMap['cta_upgrade_now']))
    }
    
    if (!((GlobalVariable.productMap['cta_downgrade_now'].toString().trim()).equals(CustomKeywords.'sample.upsellingMessages.getDataByMessages'(
            23, column).toString().trim()))) {
        CustomKeywords.'sample.upsellingMessages.updateUpsellResultSheet'(CustomKeywords.'sample.upsellingMessages.getDataByMessages'(
                23, 'B'), 'byMessages', CustomKeywords.'sample.upsellingMessages.getDataByMessages'(23, column), GlobalVariable.productMap[
            'cta_downgrade_now'])

        KeywordUtil.markFailed((('cta_downgrade_now not matche Expected :' + CustomKeywords.'sample.upsellingMessages.getDataByMessages'(
                23, column)) + 'Actual :') + (GlobalVariable.productMap['cta_downgrade_now']).toString().trim())
    }
    
    if (!((GlobalVariable.productMap['upsell_cta_upgrade'].toString().trim()).equals(CustomKeywords.'sample.upsellingMessages.getDataByMessages'(
            26, column).toString().trim()))) {
        CustomKeywords.'sample.upsellingMessages.updateUpsellResultSheet'(CustomKeywords.'sample.upsellingMessages.getDataByMessages'(
                26, 'B'), 'byMessages', CustomKeywords.'sample.upsellingMessages.getDataByMessages'(26, column), GlobalVariable.catalogMap[
            'upsell_cta_upgrade'])

        KeywordUtil.markFailed((('upsell_cta_upgrade not matche Expected :' + CustomKeywords.'sample.upsellingMessages.getDataByMessages'(
                26, column).toString().trim()) + 'Actual :') + (GlobalVariable.catalogMap['upsell_cta_upgrade']).toString().trim())
    }
    
    
}