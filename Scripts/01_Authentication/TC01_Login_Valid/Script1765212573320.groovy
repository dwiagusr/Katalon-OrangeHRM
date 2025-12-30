import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.url)
WebUI.maximizeWindow()

WebUI.waitForElementVisible(findTestObject('Page_Login/input_Username'), 10)
WebUI.setText(findTestObject('Page_Login/input_Username'), GlobalVariable.username)
WebUI.setText(findTestObject('Page_Login/input_Password'), GlobalVariable.password)
WebUI.click(findTestObject('Page_Login/btn_Login'))

WebUI.waitForElementVisible(findTestObject('Page_Dashboard/text_Dashboard'), 10)
WebUI.verifyElementVisible(findTestObject('Page_Dashboard/text_Dashboard'))