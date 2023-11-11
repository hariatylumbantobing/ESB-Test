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

WebUI.verifyElementPresent(findTestObject('Page_Login-logout/div_logo orange'), 2)

WebUI.verifyElementPresent(findTestObject('Page_Login-logout/div_Username'), 1)

//verify email nya invalid
WebUI.setText(findTestObject('Page_Login-logout/input_Username'), findTestData('Login Creds').getValue(1, 3))
WebUI.verifyElementPresent(findTestObject('Page_Login-logout/div_Password'), 1)
WebUI.setText(findTestObject('Page_Login-logout/input_Password'), findTestData('Login Creds').getValue(2, 3))
WebUI.click(findTestObject('Page_Login-logout/button_Login'))
WebUI.delay(4)
WebUI.verifyElementPresent(findTestObject('Page_Alerts/div_Invalid credentials'), 1)

//proses clear text di usname & pwd
WebUI.clearText(findTestObject('Page_Login-logout/input_Username'))
WebUI.clearText(findTestObject('Page_Login-logout/input_Password'))
WebUI.delay(2)

//verify pwd nya invalid
WebUI.setText(findTestObject('Page_Login-logout/input_Username'), findTestData('Login Creds').getValue(1, 4))
WebUI.setText(findTestObject('Page_Login-logout/input_Password'), findTestData('Login Creds').getValue(2, 4))
WebUI.click(findTestObject('Page_Login-logout/button_Login'))
WebUI.verifyElementPresent(findTestObject('Page_Alerts/div_Invalid credentials'), 1)

WebUI.closeBrowser()

