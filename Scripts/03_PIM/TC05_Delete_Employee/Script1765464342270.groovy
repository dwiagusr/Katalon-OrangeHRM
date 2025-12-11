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

WebUI.callTestCase(findTestCase('01_Authentication/TC01_Login_Valid'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_PIM/sideMenu_PIM'))

// Masukkan ID dari Global Variable (Hasil operan dari TC04)
println('MENCARI KARYAWAN DENGAN ID: ' + GlobalVariable.employee_id)

WebUI.setText(findTestObject('Page_PIM/Employee_Information/input_Employee_Id'), GlobalVariable.employee_id)

WebUI.click(findTestObject('Page_PIM/Employee_Information/btn_Search'))

WebUI.scrollToElement(findTestObject('Page_PIM/Employee_Information/btn_Delete'), 3)

WebUI.delay(2)

WebUI.click(findTestObject('Page_PIM/Employee_Information/btn_Delete'))

WebUI.waitForElementVisible(findTestObject('Page_PIM/Employee_Information/btn_Confirmation_Yes'), 5)

WebUI.click(findTestObject('Page_PIM/Employee_Information/btn_Confirmation_Yes'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PIM/ntf_Successfully'), 5)

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_PIM/ntf_Successfully'))

WebUI.closeBrowser()

