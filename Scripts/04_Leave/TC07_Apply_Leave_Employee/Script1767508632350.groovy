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
import org.openqa.selenium.Keys as Keys

// 1. Preparation: Open browser and navigate to URL
WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.url)

WebUI.maximizeWindow()

// 2. Authentication: Login using the credentials generated in TC04
WebUI.setText(findTestObject('Page_Login/input_Username'), GlobalVariable.employee_username)

WebUI.setText(findTestObject('Page_Login/input_Password'), GlobalVariable.employee_password)

WebUI.click(findTestObject('Page_Login/btn_Login'))

// 3. Navigation: Go to Leave -> Apply
WebUI.click(findTestObject('Object Repository/Page_Leave/menu_Leave'))

WebUI.waitForElementVisible(findTestObject('Page_Leave/link_Apply'), 15)

WebUI.click(findTestObject('Page_Leave/link_Apply'))

// 4. Form Entry: Select Leave Type and Dates
WebUI.click(findTestObject('Object Repository/Page_Leave/ddl_LeaveType'))

// Selecting 'Annual Leave' which was set up in TC06
WebUI.click(findTestObject('Object Repository/Page_Leave/option_LeaveType', [('text') : 'CAN - Personal']))

// Format: YYYY-MM-DD
WebUI.setText(findTestObject('Object Repository/Page_Leave/input_FromDate'), '2026-01-15')

WebUI.sendKeys(findTestObject('Object Repository/Page_Leave/input_ToDate'), Keys.chord(Keys.CONTROL, 'a', Keys.BACK_SPACE))
WebUI.setText(findTestObject('Object Repository/Page_Leave/input_ToDate'), '2026-01-16')

// 5. Submission: Add comment and Apply
WebUI.setText(findTestObject('Object Repository/Page_Leave/txt_Comments'), 'Testing automated leave application.')

WebUI.click(findTestObject('Object Repository/Page_Leave/btn_Apply'))

// 6. Validation: Check for success message
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PIM/ntf_Successfully'), 5)

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_PIM/ntf_Successfully'))

WebUI.closeBrowser()

