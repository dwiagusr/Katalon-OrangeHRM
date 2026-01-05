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

// 1. Login as Admin using existing TC01
WebUI.callTestCase(findTestCase('01_Authentication/TC01_Login_Valid'), [:], FailureHandling.STOP_ON_FAILURE)

// 2. Navigate to Leave -> Entitlements -> Add Entitlements
WebUI.click(findTestObject('Object Repository/Page_Leave/menu_Leave'))
WebUI.click(findTestObject('Object Repository/Page_Leave/link_Entitlements'))
WebUI.click(findTestObject('Object Repository/Page_Leave/link_AddEntitlements'))

// 3. Fill Employee Name (Using Data from GlobalVariable)
// Typing the name and selecting from the hint list
WebUI.setText(findTestObject('Object Repository/Page_Leave/input_EmployeeName'), var_firstName + " " + var_lastName)
WebUI.delay(5) // Wait for the suggestion list to appear
WebUI.sendKeys(findTestObject('Object Repository/Page_Leave/input_EmployeeName'), Keys.chord(Keys.ARROW_DOWN, Keys.ENTER))


// 4. Select Leave Type
WebUI.click(findTestObject('Object Repository/Page_Leave/ddl_LeaveType'))
// We use our dynamic object to select 'Annual Leave'
WebUI.click(findTestObject('Object Repository/Page_Leave/option_LeaveType', [('text') : 'CAN - Personal']))

// 5. Input Entitlement Amount
WebUI.setText(findTestObject('Object Repository/Page_Leave/input_Entitlement'), '15')

// 6. Save and Confirm
WebUI.click(findTestObject('Object Repository/Page_Leave/btn_Save_Entitlement'))
// Note: OrangeHRM usually shows a confirmation popup here
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Leave/btn_Confirm_Entitlement'), 5)
WebUI.click(findTestObject('Object Repository/Page_Leave/btn_Confirm_Entitlement'))

WebUI.closeBrowser()

