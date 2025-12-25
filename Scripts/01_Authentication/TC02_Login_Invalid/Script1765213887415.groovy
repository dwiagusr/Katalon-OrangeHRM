import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.awt.im.InputContext
import java.security.InvalidAlgorithmParameterException

import com.github.kklisura.cdt.protocol.types.page.Navigate
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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys
import org.openqa.selenium.UsernameAndPassword as Keys

// 1. Initialize the test execution
WebUI.openBrowser('')
WebUI.maximizeWindow()

// 2. Navigate to the application URL using Global Variable
WebUI.navigateToUrl(GlobalVariable.url)

// 3. Enter valid username from Global Variable
WebUI.setText(findTestObject('Object Repository/Page_Login/input_Username'), GlobalVariable.username)

// 4. Enter an invalid password for negative testing
WebUI.setText(findTestObject('Object Repository/Page_Login/input_Password'), 'InvalidPassword123')

// 5. Execute login action
WebUI.click(findTestObject('Object Repository/Page_Login/btn_Login'))

// 6. VERIFICATION: Ensure the error message "Invalid credentials" is displayed
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Login/msg_InvalidCredential'))

// 7. Cleanup: Terminate the browser session
WebUI.closeBrowser()