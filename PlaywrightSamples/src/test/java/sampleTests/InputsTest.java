package sampleTests;

import org.testng.annotations.Test;

import pageObjects.InputPage;
import testBase.TestBase;

public class InputsTest extends TestBase {

	@Test(groups = { "inputs" })
	public void inputTests01() {
		InputPage inputPage = InputPage.getInstance();

		page.navigate(prop.getProperty("letCodeInputUrl"));
		inputPage.getFullName().fill("demo"); // copy paste
		inputPage.getAppendText().type("filling by appending "); // typing

		inputPage.getAppendText().press("Tab"); // keyboard operation
		System.out.println(inputPage.getGetMe().getAttribute("value"));
		inputPage.getClearMe().clear(); // clear the text box

		// Assertions
		System.out.println("is Not Editable: " + inputPage.getEditableOrNot().isDisabled());
		System.out.println("is readOnly: " + inputPage.getReadOnly().isEnabled());
	}

}
