import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
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

WebUI.openBrowser('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')

WebUI.maximizeWindow()

WebUI.callTestCase(findTestCase('Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_apply-cancel/a_Leave'))

WebUI.click(findTestObject('Page_apply-cancel/li_My Leave'))

//WebUI.verifyElementPresent(findTestObject('Page_apply-cancel/div_Records Found'), 2)
//
//WebUI.verifyElementPresent(findTestObject('Page_apply-cancel/div_tabel leave'), 2)
//kalau isi My Leave ada, lanjut cancel, kalau ngga ada isi My Leave, call test case Assign Leave
if (WebUI.verifyElementPresent(findTestObject('Page_apply-cancel/div_tabel leave'), 2)) {
    WebUI.click(findTestObject('Page_apply-cancel/button_Cancel'), FailureHandling.STOP_ON_FAILURE)
    WebUI.delay(2)
    WebUI.verifyElementPresent(findTestObject('Page_apply-cancel/div_SuccessSuccessfully Updated'), 2)
} else {
    WebUI.callTestCase(findTestCase('Assign Leave'), [:], FailureHandling.STOP_ON_FAILURE)
}

WebUI.closeBrowser()

