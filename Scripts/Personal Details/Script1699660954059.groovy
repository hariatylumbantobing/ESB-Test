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

WebUI.verifyElementPresent(findTestObject('Page_Personal Details/div_MyInfo background'), 0)

//first we clear all the text fields
WebUI.clearText(findTestObject('Page_Personal Details/input_first name'))
WebUI.clearText(findTestObject('Page_Personal Details/input_lastname'))
WebUI.clearText(findTestObject('Page_Personal Details/input_middlename'))
WebUI.clearText(findTestObject('Page_Personal Details/input_allnotmandatory'))

//then click save button
WebUI.click(findTestObject('Page_Personal Details/button_Save'))

//verify appears alert
WebUI.verifyElementPresent(findTestObject('Page_Personal Details/span_firstnameRequired'), 0)

//then we set text into first name and lastname
WebUI.setText(findTestObject('Page_Personal Details/input_first name'), 'testhar')
WebUI.setText(findTestObject('Page_Personal Details/input_lastname'), 'testhar')

//then click save button
WebUI.click(findTestObject('Page_Personal Details/button_Save'))

WebUI.delay(2)

//verify appears success updated alert
WebUI.verifyElementPresent(findTestObject('Page_alertpersondetail/div_SuccessSuccessfully'), 0)


WebUI.closeBrowser()

