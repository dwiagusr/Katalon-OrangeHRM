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

// 1. Prerequisites: Authenticate the session by calling the login test case
WebUI.callTestCase(findTestCase('01_Authentication/TC01_Login_Valid'), [:], FailureHandling.STOP_ON_FAILURE)

// 2. Navigation: Access the PIM module to manage employee records
WebUI.click(findTestObject('Page_PIM/sideMenu_PIM'))

// 3. Data Retrieval: Log the Employee ID retrieved from Global Variable (Passed from TC04)
println('SEARCHING FOR EMPLOYEE WITH ID: ' + GlobalVariable.employee_id)

// 4. Search Operation: Filter the list using the specific Employee ID
WebUI.setText(findTestObject('Page_PIM/Employee_Information/input_Employee_Id'), GlobalVariable.employee_id)
WebUI.click(findTestObject('Page_PIM/Employee_Information/btn_Search'))

// 5. Interaction: Scroll to ensure the Delete button is within the viewport and interactable
WebUI.scrollToElement(findTestObject('Page_PIM/Employee_Information/btn_Delete'), 3)

WebUI.delay(2)

// 6. Delete Action: Trigger the deletion process for the found record
WebUI.click(findTestObject('Page_PIM/Employee_Information/btn_Delete'))

// 7. Modal Confirmation: Wait for and interact with the confirmation dialog
WebUI.waitForElementVisible(findTestObject('Page_PIM/Employee_Information/btn_Confirmation_Yes'), 5)
WebUI.click(findTestObject('Page_PIM/Employee_Information/btn_Confirmation_Yes'))

// 8. Synchronization: Wait for the system to process the deletion and show the notification
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PIM/ntf_Successfully'), 5)

// 9. Validation: Verify that the "Successfully Deleted" toast message is displayed
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_PIM/ntf_Successfully'))

// 10. Cleanup: Terminate the browser session to finalize the test
WebUI.closeBrowser()

