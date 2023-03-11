package pageObjects;

import com.microsoft.playwright.Locator;

import lombok.Getter;
import testBase.TestBase;

@Getter
public class InputPage extends TestBase {

	private InputPage() {

	}

	private static InputPage inputPage;

	public static InputPage getInstance() {
		if (inputPage == null) {
			inputPage = new InputPage();
		}
		return inputPage;
	}

	private Locator fullName = page.locator("id=fullName");
	private Locator appendText = page.locator("id=join");
	private Locator getMe = page.locator("id=getMe");
	private Locator clearMe = page.locator("id=clearMe");
	private Locator editableOrNot = page.locator("id=noEdit");
	private Locator readOnly = page.locator("id=dontwrite");

}
