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

WebUI.verifyElementPresent(findTestObject('Page_Personal Details/a_My Info'), 0)

WebUI.click(findTestObject('Page_Personal Details/a_My Info'))

WebUI.delay(1)

//verify all the elements on Job Details page appear
WebUI.click(findTestObject('Page_Job Details/a_Job'))
WebUI.verifyElementPresent(findTestObject('Page_Job Details/Job Details background'), 0)
WebUI.verifyElementPresent(findTestObject('Page_Job Details/div_Joined Date'), 0)
WebUI.verifyElementPresent(findTestObject('Page_Job Details/div_Job TitleHR Manager'), 0)
WebUI.verifyElementPresent(findTestObject('Page_Job Details/div_Job SpecificationNot Defined'), 0)
WebUI.verifyElementPresent(findTestObject('Page_Job Details/div_Job CategoryOfficials and Managers'), 0)
WebUI.verifyElementPresent(findTestObject('Page_Job Details/div_Sub UnitHuman Resources'), 0)
WebUI.verifyElementPresent(findTestObject('Page_Job Details/div_LocationTexas RD'), 0)
WebUI.verifyElementPresent(findTestObject('Page_Job Details/div_Employment StatusFull-Time Permanent'), 0)
WebUI.verifyElementPresent(findTestObject('Page_Job Details/span_details_on_off'), 0)

//click on to contract details
WebUI.click(findTestObject('Page_Job Details/span_details_on_off'), FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementPresent(findTestObject('Page_Job Details/div_Contract Start Date'), 0)
WebUI.verifyElementPresent(findTestObject('Page_Job Details/div_Contract End Date'), 0)
WebUI.verifyElementPresent(findTestObject('Page_Job Details/div_Contract DetailsBrowseNo file selected'), 0)

WebUI.closeBrowser()

