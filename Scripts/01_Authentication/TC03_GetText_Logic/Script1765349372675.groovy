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

// 1. Initialize and Setup Browser
WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.url)
WebUI.maximizeWindow()

// 2. Perform Login with valid credentials from Global Variables
WebUI.setText(findTestObject('Object Repository/Page_Login/input_Username'), GlobalVariable.username )
WebUI.setText(findTestObject('Object Repository/Page_Login/input_Password'), GlobalVariable.password )
WebUI.click(findTestObject('Object Repository/Page_Login/btn_Login'))

// 3. Wait for Dashboard to be visible before asserting
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Dashboard/text_Dashboard'), 10)

// 4. Capture actual text from the Dashboard header
String teksAktual = WebUI.getText(findTestObject('Object Repository/Page_Dashboard/text_Dashboard'))

// 5. Log the execution result for debugging purposes
println("\n============================================")
println("Execution Result: Header found is [" + teksAktual + "]")
println("============================================\n")

// 6. ASSERTION: Validate that the user is successfully redirected to the Dashboard
// The system compares the actual text with the expected "Dashboard" string.
// If it fails (e.g., redirection error), the test execution will stop immediately.
assert teksAktual == "Dashboard"

// 7. Post-test Cleanup: Terminate browser session
WebUI.closeBrowser()