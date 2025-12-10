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

// Open Browser
WebUI.openBrowser('')

WebUI.maximizeWindow()

// Navigate to URL
WebUI.navigateToUrl(GlobalVariable.url)

// Input valid username
WebUI.setText(findTestObject('Object Repository/Page_Login/input_Username'), GlobalVariable.username)

// Input Invalid Password
WebUI.setText(findTestObject('Object Repository/Page_Login/input_Password'), 'Ngawur')

// 5. Klik Login
WebUI.click(findTestObject('Object Repository/Page_Login/btn_Login'))

// 6. VERIFIKASI: Pastikan pesan error muncul
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Login/msg_InvalidCredential'))

// 7. Tutup Browser
WebUI.closeBrowser()