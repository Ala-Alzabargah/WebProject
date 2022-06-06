import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

import internal.GlobalVariable
import shahid.Common

class NewTestListener {
	int numberOfFaultyTestCases = 0
	final HashMap<String,String> results = new HashMap<String,String>()
	@BeforeTestSuite
	def beforeTestSuite(TestSuiteContext testSuiteContext) {
		GlobalVariable.testSuiteName=testSuiteContext.getTestSuiteId().split('Test Suites/')[1]
		println "TestSuiteId:: "+GlobalVariable.testSuiteName
		
	}

	@BeforeTestCase
	def sampleBeforeTestCase(TestCaseContext testCaseContext) {
		new Common().devicePlatform()
	}




	@AfterTestCase
	def sampleAfterTestCase(TestCaseContext testCaseContext) {
		println testCaseContext.getTestCaseId()     // MyBrilliantTestCase
		println testCaseContext.getTestCaseStatus() // PASSED, FAILED, ERROR
		if (testCaseContext.getTestCaseStatus() != "PASSED") {
			numberOfFaultyTestCases += 1
		}
	}

	@AfterTestSuite
	def afterTestSuite(TestSuiteContext testSuiteContext) {
		GlobalVariable.totalOfFailedTC=numberOfFaultyTestCases
		println("Failed Test Cases: " + GlobalVariable.totalOfFailedTC)
		println "TestSuiteId after test suite:: "+GlobalVariable.testSuiteName
		results.put(GlobalVariable.testSuiteName, GlobalVariable.totalOfFailedTC)
		
		println "results:: "+results
	}
}