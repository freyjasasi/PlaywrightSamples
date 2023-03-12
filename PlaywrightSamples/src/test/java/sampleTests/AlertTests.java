package sampleTests;

import org.testng.annotations.Test;

import pageObjects.AlertPage;
import testBase.TestBase;

public class AlertTests extends TestBase {

	@Test(groups = { "test", "alert" })
	public void AlertTests01() {
		page.navigate(prop.getProperty("alertUrl"));
		AlertPage alertPage = AlertPage.getInstance();

		// using normal way
//		Consumer<Dialog> dialogConsumer = dialog -> dialog.accept();
//		page.onDialog(dialogConsumer);

		// lambda way, it will accept all dialogs
		page.onDialog(dialog -> {
			System.out.println(dialog.message());
			dialog.accept("GuruMoorthy");
		});

		alertPage.getSimpleAlertLocator().click();
		alertPage.getConfirmAlertLocator().click();
		alertPage.getPromptAlertLocator().click();
		System.out.println("Prompt Alert Verify Text: " + alertPage.getPromptAlertVerifyLocator().textContent());

	}

}
