import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.awt.color.ProfileDataException as ProfileDataException
import javax.wsdl.Import as Import
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
import com.kms.katalon.core.webui.keyword.builtin.UploadFileKeyword as UploadFileKeyword
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable as GlobalVariable
import utils.FormHelper as FormHelper
import org.apache.poi.ss.usermodel.Picture as Picture

// 1. Prerequisites: Call login test case to ensure an authenticated session
WebUI.callTestCase(findTestCase('01_Authentication/TC01_Login_Valid'), [:], FailureHandling.STOP_ON_FAILURE)

// 2. Navigation: Access the PIM (Personnel Information Management) module
WebUI.click(findTestObject('Object Repository/Page_PIM/sideMenu_PIM'))

// 3. Action: Initiate the 'Add Employee' process
WebUI.click(findTestObject('Object Repository/Page_PIM/addButton_PIM'))

// --- GENERATE UNIQUE IDENTIFIER ---
// Generate a 5-character alphanumeric random string to ensure test data uniqueness
// Example results: "a7X9b", "K1m0P"
String randomId = RandomStringUtils.randomAlphanumeric(5)

// 4. Data Entry: Populate the employee creation form using variables
WebUI.setText(findTestObject('Object Repository/Page_PIM/input_Employee Full Name_firstName'), var_firstName)

WebUI.setText(findTestObject('Object Repository/Page_PIM/input_Employee Full Name_middleName'), var_middleName)

WebUI.setText(findTestObject('Object Repository/Page_PIM/input_Employee Full Name_lastName'), var_lastName)

// 5. ID Management: Clear existing ID and input the newly generated random ID
FormHelper.clearAndType(findTestObject('Object Repository/Page_PIM/input_EmployeeId'), randomId)

// Store the generated ID in a Global Variable for cross-test case data sharing (e.g., for TC05 Search/Delete)
GlobalVariable.employee_id = randomId

// Debugging: Output the generated ID to the console for execution tracking
println('===========================================')

println('NEW GENERATED EMPLOYEE ID: ' + GlobalVariable.employee_id)

println('===========================================')

// 6. Attachment: Upload the profile picture from the local directory
WebUI.uploadFile(findTestObject('Object Repository/Page_PIM/btnUploadImg_AddEmployee'), 'F:\\Patrick.png')

// 7. Submission: Save the initial employee record
WebUI.click(findTestObject('Object Repository/Page_PIM/btnSave_addEmployee'))

// Synchronization: Wait for the success notification to be visible
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PIM/ntf_Successfully'), 5)

// Validation: Confirm the "Successfully Saved" toast message appears
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_PIM/ntf_Successfully'))

WebUI.delay(5)

// 8. Page Redirection: Verify the system successfully navigates to 'Personal Details' page
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_PIM/Personal_Details/header_Personal_Details'))

// Optimization: Scroll to the footer to ensure the 'Save' button is interactable
WebUI.scrollToElement(findTestObject('Object Repository/Page_PIM/Personal_Details/btn_Save_PersonalDetails'), 3)

// 9. Data Enrichment: Update Nationality, Marital Status, and Gender
WebUI.click(findTestObject('Object Repository/Page_PIM/Personal_Details/ddl_Nationality'))

WebUI.click(findTestObject('Object Repository/Page_PIM/Personal_Details/option_Indonesian'))

WebUI.click(findTestObject('Object Repository/Page_PIM/Personal_Details/ddl_MaritalStatus'))

WebUI.click(findTestObject('Object Repository/Page_PIM/Personal_Details/option_Single'))

WebUI.click(findTestObject('Object Repository/Page_PIM/Personal_Details/radio_Male'))

// 10. Final Submission: Save the enriched personal details
WebUI.click(findTestObject('Object Repository/Page_PIM/Personal_Details/btn_Save_PersonalDetails'))

// Final Validation: Ensure the second stage of data entry is saved successfully
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PIM/ntf_Successfully'), 5)

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_PIM/ntf_Successfully'))

// 11. Cleanup: Close the browser to end the test session
WebUI.closeBrowser()

