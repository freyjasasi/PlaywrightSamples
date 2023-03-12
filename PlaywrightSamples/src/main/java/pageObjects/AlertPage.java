package pageObjects;

import com.microsoft.playwright.Locator;

import lombok.Getter;
import testBase.TestBase;

@Getter
public class AlertPage extends TestBase {

	private AlertPage() {
	}

	private static AlertPage alertPage;

	public static AlertPage getInstance() {
		if (alertPage == null) {
			alertPage = new AlertPage();
		}
		return alertPage;
	}

	private Locator simpleAlertLocator = page.locator("id=accept");
	private Locator confirmAlertLocator = page.locator("id=confirm");
	private Locator promptAlertLocator = page.locator("id=prompt");
	private Locator promptAlertVerifyLocator = page.locator("id=myName");
	private Locator modernAlertLocator = page.locator("id=modern");

}
