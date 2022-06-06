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

        column = 'G'

        CustomKeywords.'Shahid.verifyStatusCode'(packageConfigurationRes, 200)

        def packageConfigurationResBody = slurper.parseText(packageConfigurationRes.getResponseBodyContent())

        CustomKeywords.'sample.upsellingMessages.getPlayerUpsellingMessagesMap'(packageConfigurationResBody, 'SHAHID_VIP_SPORT', 
            'SPORT')
    } else if (j == 1) {
        packageConfigurationRes = WS.sendRequest(findTestObject('Object Repository/Upselling Messages/packageConfiguration', 
                [('ssession') : GlobalVariable.Ssession, ('language') : 'AR', ('acceptLanguage') : 'ar']))

        column = 'F'

        CustomKeywords.'Shahid.verifyStatusCode'(packageConfigurationRes, 200)

        def packageConfigurationResBody = slurper.parseText(packageConfigurationRes.getResponseBodyContent())

        CustomKeywords.'sample.upsellingMessages.getPlayerUpsellingMessagesMap'(packageConfigurationResBody, 'SHAHID_VIP_SPORT', 
            'SPORT')
    } else {
        packageConfigurationRes = WS.sendRequest(findTestObject('Object Repository/Upselling Messages/packageConfiguration', 
                [('ssession') : GlobalVariable.Ssession, ('language') : 'FR', ('acceptLanguage') : 'fr']))

        column = 'H'

        CustomKeywords.'Shahid.verifyStatusCode'(packageConfigurationRes, 200)

        def packageConfigurationResBody = slurper.parseText(packageConfigurationRes.getResponseBodyContent())

        CustomKeywords.'sample.upsellingMessages.getPlayerUpsellingMessagesMap'(packageConfigurationResBody, 'SHAHID_VIP_SPORT', 
            'SPORT')
    }
    
    if (!((GlobalVariable.catalogMap['displayName']).toString().trim().equals(CustomKeywords.'sample.upsellingMessages.getData'(29, 
            column).toString().trim()))) {
        CustomKeywords.'sample.upsellingMessages.updateUpsellResultSheet'(CustomKeywords.'sample.upsellingMessages.getData'(
             29, 'B'), 'byContent', CustomKeywords.'sample.upsellingMessages.getData'(29, column), GlobalVariable.productMap[
            'messageDisplayName'])

        KeywordUtil.markFailed((('Title not matche Expected :' + CustomKeywords.'sample.upsellingMessages.getData'(29, column)) + 
            'Actual :') + (GlobalVariable.productMap['messageDisplayName']))
    }
    
    if (!((GlobalVariable.productMap['live_player_message_subscribe']).equals(CustomKeywords.'sample.upsellingMessages.getData'(
            30, column)))) {
        CustomKeywords.'sample.upsellingMessages.updateUpsellResultSheet'(CustomKeywords.'sample.upsellingMessages.getData'(
                30, 'B'), 'byContent', CustomKeywords.'sample.upsellingMessages.getData'(4, column), GlobalVariable.productMap[
            'live_player_message_subscribe'])

        System.err.println('Here:' + StringUtils.difference(CustomKeywords.'sample.upsellingMessages.getData'(30, column).toString().trim(), 
                (GlobalVariable.productMap['live_player_message_subscribe']).toString().trim()))

        KeywordUtil.markFailed((('Text not matche Expected :' + CustomKeywords.'sample.upsellingMessages.getData'(30, column)) + 
            'Actual :') + (GlobalVariable.productMap['live_player_message_subscribe']))
    }
    
    if (!((GlobalVariable.catalogMap['live_player_message_subscribe']).equals(CustomKeywords.'sample.upsellingMessages.getData'(
            31, column).toString().trim()))) {
        CustomKeywords.'sample.upsellingMessages.updateUpsellResultSheet'(CustomKeywords.'sample.upsellingMessages.getData'(
                31, 'B'), 'byContent', CustomKeywords.'sample.upsellingMessages.getData'(31, column), GlobalVariable.catalogMap[
            'live_player_message_subscribe'])

        KeywordUtil.markFailed((('Text Anonymous User not matche Expected :' + CustomKeywords.'sample.upsellingMessages.getData'(
               31, column)) + 'Actual :') + (GlobalVariable.catalogMap['live_player_message_subscribe']))
    }
    
    if (!((GlobalVariable.productMap['icon_1.label']).equals(CustomKeywords.'sample.upsellingMessages.getData'(32, column).toString().trim()))) {
        CustomKeywords.'sample.upsellingMessages.updateUpsellResultSheet'(CustomKeywords.'sample.upsellingMessages.getData'(
                32, 'B'), 'byContent', CustomKeywords.'sample.upsellingMessages.getData'(32, column), GlobalVariable.productMap[
            'icon_1.label'])

        KeywordUtil.markFailed((('HDIcons not matche Expected :' + CustomKeywords.'sample.upsellingMessages.getData'(32, 
                column)) + 'Actual :') + (GlobalVariable.productMap['icon_1.label']).toString().trim())
    }
    
    if (!((GlobalVariable.productMap['icon_2.label']).equals(CustomKeywords.'sample.upsellingMessages.getData'(33, column).toString().trim()))) {
        CustomKeywords.'sample.upsellingMessages.updateUpsellResultSheet'(CustomKeywords.'sample.upsellingMessages.getData'(
                33, 'B'), 'byContent', CustomKeywords.'sample.upsellingMessages.getData'(33, column), GlobalVariable.productMap[
            'icon_2.label'])

        KeywordUtil.markFailed((('watchOfflineIcons not matche Expected :' + CustomKeywords.'sample.upsellingMessages.getData'(
                33, column).toString().trim()) + 'Actual :') + (GlobalVariable.productMap['icon_2.label']).toString().trim())
    }
    
    if (!((GlobalVariable.productMap['icon_3.label']).toString().trim().equals(CustomKeywords.'sample.upsellingMessages.getData'(
           34, column).toString().trim()))) {
        CustomKeywords.'sample.upsellingMessages.updateUpsellResultSheet'(CustomKeywords.'sample.upsellingMessages.getData'(
                34, 'B'), 'byContent', CustomKeywords.'sample.upsellingMessages.getData'(34, column), GlobalVariable.productMap[
            'icon_3.label'])

        KeywordUtil.markFailed((('watchOnTVIcons not matche Expected :' + CustomKeywords.'sample.upsellingMessages.getData'(
                34, column)) + 'Actual :') + (GlobalVariable.productMap['icon_3.label']).toString().trim())
    }
    
    if (!((GlobalVariable.productMap['player_cta_subscribe']).equals(CustomKeywords.'sample.upsellingMessages.getData'(35, 
            column).toString().trim()))) {
        CustomKeywords.'sample.upsellingMessages.updateUpsellResultSheet'(CustomKeywords.'sample.upsellingMessages.getData'(
                35, 'B'), 'byContent', CustomKeywords.'sample.upsellingMessages.getData'(35, column), GlobalVariable.productMap[
            'player_cta_subscribe'])

        KeywordUtil.markFailed((('cta_subscribe not matche Expected :' + CustomKeywords.'sample.upsellingMessages.getData'(
                35, column)) + 'Actual :') + (GlobalVariable.productMap['player_cta_subscribe']))
    }
    
    if (!((GlobalVariable.productMap['player_cta_upgrade']).equals(CustomKeywords.'sample.upsellingMessages.getData'(37, 
            column).toString().trim()))) {
        CustomKeywords.'sample.upsellingMessages.updateUpsellResultSheet'(CustomKeywords.'sample.upsellingMessages.getData'(
               37, 'B'), 'byContent', CustomKeywords.'sample.upsellingMessages.getData'(37, column), GlobalVariable.productMap[
            'player_cta_upgrade'])

        KeywordUtil.markFailed((('cta_upgrade not matche Expected :' + CustomKeywords.'sample.upsellingMessages.getData'(
               37, column)) + 'Actual :') + (GlobalVariable.productMap['player_cta_upgrade']).toString().trim())
    }
}