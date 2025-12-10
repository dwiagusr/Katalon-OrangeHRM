import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.awt.color.ProfileDataException

import javax.wsdl.Import

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
import com.kms.katalon.core.webui.keyword.builtin.UploadFileKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.apache.commons.lang.RandomStringUtils
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable

import org.apache.poi.ss.usermodel.Picture
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('01_Authentication/TC01_Login_Valid'), [:], FailureHandling.STOP_ON_FAILURE)

// Click Side-menu PIM
WebUI.click(findTestObject('Object Repository/Page_PIM/sideMenu_PIM'))

// Click Add Employee
WebUI.click(findTestObject('Object Repository/Page_PIM/addButton_PIM'))

// --- GENERATE RANDOM ID ---
// Membuat string acak kombinasi huruf & angka sepanjang 5 karakter
// Contoh hasil: "a7X9b", "K1m0P"
String randomId = RandomStringUtils.randomAlphanumeric(5)

// Filled In The Form
WebUI.setText(findTestObject('Object Repository/Page_PIM/input_Employee Full Name_firstName'), 'Budi')
WebUI.setText(findTestObject('Object Repository/Page_PIM/input_Employee Full Name_lastName'), 'Tampan')
WebUI.setText(findTestObject('Object Repository/Page_PIM/input_Employee Full Name_middleName'), 'Banget')

// Clear Existing EmployeeID
WebUI.click(findTestObject('Object Repository/Page_PIM/input_EmployeeId'))
WebUI.sendKeys(findTestObject('Object Repository/Page_PIM/input_EmployeeId'), Keys.chord(Keys.CONTROL, 'a'))
WebUI.sendKeys(findTestObject('Object Repository/Page_PIM/input_EmployeeId'), Keys.BACK_SPACE.toString())
// Add Employee ID dengan Variabel Random tadi
WebUI.setText(findTestObject('Object Repository/Page_PIM/input_EmployeeId'), randomId)

// Opsional: Print ke Console biar kita tahu ID berapa yang dibuat robot
println("===========================================")
println("EMPLOYEE ID BARU ADALAH: " + randomId)
println("===========================================")

// Upload Profile Picture
WebUI.uploadFile(findTestObject('Object Repository/Page_PIM/btnUploadImg_AddEmployee'), "F:\\Patrick.png")

// Click Save Btn
WebUI.click(findTestObject('Object Repository/Page_PIM/btnSave_addEmployee'))

// Add DelayfindTestObject('Object Repository/Page_PIM/ntf_Successfully')
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PIM/ntf_Successfully'), 5)

// Verify Toast Message Successfully 
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_PIM/ntf_Successfully'))

// Close Browser
WebUI.closeBrowser()