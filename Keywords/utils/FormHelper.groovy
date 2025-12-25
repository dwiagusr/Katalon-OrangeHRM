package utils


import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys as Keys

public class FormHelper {

	// Annotation to make this method visible in Katalon Script Mode
	@Keyword
	static def clearAndType(TestObject objectTarget, String newText) {

		// 1. Click on the element to focus
		WebUI.click(objectTarget)

		// 2. Simulate Ctrl + A (Select All)
		WebUI.sendKeys(objectTarget, Keys.chord(Keys.CONTROL, 'a'))

		// 3. Simulate Backspace (Delete content)
		WebUI.sendKeys(objectTarget, Keys.BACK_SPACE.toString())

		// 4. Type the new text
		WebUI.setText(objectTarget, newText)

		// 5. Print log to Console for debugging
		println("✅ [FormHelper] Successfully cleared field and typed: " + newText)
	}
}