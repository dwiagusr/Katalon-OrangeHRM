import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import internal.GlobalVariable as GlobalVariable
import utils.FormHelper as FormHelper

// 1. Prerequisites: Authenticate session by calling the existing login test case
WebUI.callTestCase(findTestCase('01_Authentication/TC01_Login_Valid'), [:], FailureHandling.STOP_ON_FAILURE)

// 2. Navigation: Open the PIM (Personnel Information Management) module from the sidebar
WebUI.click(findTestObject('Object Repository/Page_PIM/sideMenu_PIM'))

// 3. Action: Click the 'Add' button to open the new employee creation form
WebUI.click(findTestObject('Object Repository/Page_PIM/addButton_PIM'))

// --- GENERATE UNIQUE IDENTIFIER ---
// Create a 5-character alphanumeric string to ensure unique test data and prevent ID duplication
String randomId = RandomStringUtils.randomAlphanumeric(5)

// 4. Data Entry: Populate name fields using dynamic variables from the Data File (Excel)
WebUI.setText(findTestObject('Object Repository/Page_PIM/input_Employee Full Name_firstName'), var_firstName)
WebUI.setText(findTestObject('Object Repository/Page_PIM/input_Employee Full Name_middleName'), var_middleName)
WebUI.setText(findTestObject('Object Repository/Page_PIM/input_Employee Full Name_lastName'), var_lastName)

// 5. ID Management: Use custom keyword to clear the default ID and type the generated random ID
FormHelper.clearAndType(findTestObject('Object Repository/Page_PIM/input_EmployeeId'), randomId)

// --- CREATE LOGIN DETAILS SECTION ---
// 6. Interaction: Toggle the 'Create Login Details' switch to reveal credential input fields
WebUI.click(findTestObject('Page_PIM/Employee_Information/Toogle_loginDetail'))

// Define unique credentials based on the employee's first name and the random ID
String genUser = var_firstName.toLowerCase() + randomId
String genPass = 'Katalon123!'

// 7. Input Credentials: Set the username and password for the new employee account
WebUI.setText(findTestObject('Page_PIM/Employee_Information/input_Username'), genUser)
WebUI.setText(findTestObject('Page_PIM/Employee_Information/input_Password'), genPass)
WebUI.setText(findTestObject('Page_PIM/Employee_Information/input_ConfirmPassword'), genPass)

// Global Persistence: Save credentials to GlobalVariables for cross-test case data sharing (e.g., for TC06)
GlobalVariable.employee_id = randomId
GlobalVariable.employee_username = genUser
GlobalVariable.employee_password = genPass

// Debugging: Log the generated credentials to the console for execution tracking
println('\n===========================================')
println('NEW EMPLOYEE CREATED')
println('ID       : ' + GlobalVariable.employee_id)
println('USERNAME : ' + GlobalVariable.employee_username)
println('PASSWORD : ' + GlobalVariable.employee_password)
println('===========================================\n')

// 8. Attachment: Upload a profile picture from the specified local directory
WebUI.uploadFile(findTestObject('Page_PIM/btnUploadImg_AddEmployee'), 'F:\\Patrick.png')

// 9. Initial Save: Submit the employee and login details form to create the initial record
WebUI.click(findTestObject('Page_PIM/btnSave_addEmployee'))

// 10. Synchronization: Wait for the system to redirect to the 'Personal Details' enrichment page
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PIM/Personal_Details/header_Personal_Details'), 10)

// 11. Optimization: Scroll down to ensure that the bottom save button is within the viewport
WebUI.scrollToElement(findTestObject('Object Repository/Page_PIM/Personal_Details/btn_Save_PersonalDetails'), 3)

// --- DYNAMIC PERSONAL DETAILS SECTION ---
// 12. Dynamic Selection: Fill Nationality and Marital Status using Parameterized Test Objects
// The '[("text") : var_xxx]' map passes values from Excel to the '${text}' placeholder in the XPath
WebUI.click(findTestObject('Object Repository/Page_PIM/Personal_Details/ddl_Nationality'))
WebUI.click(findTestObject('Object Repository/Page_PIM/Personal_Details/option_Nationality', [('text') : var_nationality]))

WebUI.click(findTestObject('Object Repository/Page_PIM/Personal_Details/ddl_MaritalStatus'))
WebUI.click(findTestObject('Object Repository/Page_PIM/Personal_Details/option_Marital', [('text') : var_maritalStatus]))

// 13. Dynamic Selection: Select Gender using a Parameterized Object
// This replaces the previous redundant if-else logic. Ensure your object XPath is //label[text()='${text}']
WebUI.click(findTestObject('Object Repository/Page_PIM/Personal_Details/radio_Gander', [('text') : var_gender]))

// 14. Final Submission: Save the enriched personal details to the employee profile
WebUI.click(findTestObject('Object Repository/Page_PIM/Personal_Details/btn_Save_PersonalDetails'))

// 15. Validation: Verify that the "Successfully Saved" toast notification is displayed
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PIM/ntf_Successfully'), 5)
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_PIM/ntf_Successfully'))

// 16. Cleanup: Close the browser to end the test iteration
WebUI.closeBrowser()