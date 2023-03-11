package sampleTests;

import org.testng.annotations.Test;

import pageObjects.InputPage;
import testBase.TestBase;

public class InputsTest extends TestBase {

	@Test(groups = { "inputs" })
	public void inputTests01() {
		InputPage inputPage = InputPage.getInstance();
		page.navigate(prop.getProperty("letCodeInputUrl"));
		inputPage.getFullName().fill("demo");
		inputPage.getAppendText().type("filling by appending "); // TODO
		inputPage.getAppendText().press("Tab");
		System.out.println(inputPage.getGetMe().getAttribute("value"));
		inputPage.getClearMe().clear();
		System.out.println("is Not Editable: " + inputPage.getEditableOrNot().isDisabled());
		System.out.println("is readOnly: " + inputPage.getReadOnly().isEnabled()); // TODO
	}

}
