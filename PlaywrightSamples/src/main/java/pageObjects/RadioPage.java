package pageObjects;

import com.microsoft.playwright.Locator;

import lombok.Getter;
import testBase.TestBase;

@Getter
public class RadioPage extends TestBase {

	private RadioPage() {
	}

	private static RadioPage radioPage;

	public static RadioPage getInstance() {
		if (radioPage == null) {
			radioPage = new RadioPage();
		}
		return radioPage;
	}

	private Locator yesLocator = page.locator("id=yes");
	private Locator selectYesLocator = page.locator("id=one");
	private Locator selectNoLocator = page.locator("id=two");
	private Locator noBugYesLocator = page.locator("id=nobug");
	private Locator bugLocator = page.locator("id=bug");
	private Locator fooLocator = page.locator("id=notfoo");
	private Locator maybeDisabledLocator = page.locator("id=maybe");
	private Locator rememberLocator = page.locator("(//input[@type='checkbox'])[1]");
	private Locator selectCheckbox = page.locator("(//input[@type='checkbox'])[2]");

}
