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

//verify all the elements on Contact Details page appear

WebUI.click(findTestObject('Page_ContactDetail/a_Contact Details'))

WebUI.verifyElementPresent(findTestObject('Page_ContactDetail/div_Street 1'), 0)
WebUI.verifyElementPresent(findTestObject('Page_ContactDetail/div_Street 2'), 0)
WebUI.verifyElementPresent(findTestObject('Page_ContactDetail/div_City'), 0)
WebUI.verifyElementPresent(findTestObject('Page_ContactDetail/div_StateProvince'), 0)
WebUI.verifyElementPresent(findTestObject('Page_ContactDetail/div_ZipPostal Code'), 0)
WebUI.verifyElementPresent(findTestObject('Page_ContactDetail/div_Country'), 0)
WebUI.verifyElementPresent(findTestObject('Page_ContactDetail/div_Home'), 0)
WebUI.verifyElementPresent(findTestObject('Page_ContactDetail/div_Mobile'), 0)
WebUI.verifyElementPresent(findTestObject('Page_ContactDetail/div_Work'), 0)
WebUI.verifyElementPresent(findTestObject('Page_ContactDetail/div_Work Email'), 0)
WebUI.verifyElementPresent(findTestObject('Page_ContactDetail/div_Other Email'), 0)
WebUI.verifyElementPresent(findTestObject('Page_ContactDetail/button_Save'), 0)

//then click save
WebUI.click(findTestObject('Page_ContactDetail/button_Save'), FailureHandling.STOP_ON_FAILURE)

//verify success alert appear
WebUI.verifyElementPresent(findTestObject('Page_alertpersondetail/div_SuccessSuccessfully'), 1)

WebUI.closeBrowser()

