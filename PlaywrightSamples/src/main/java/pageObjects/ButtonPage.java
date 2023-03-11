package pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import lombok.Getter;
import testBase.TestBase;

@Getter
public class ButtonPage extends TestBase {

	private ButtonPage() {
	}

	private static ButtonPage buttonPage;

	public static ButtonPage getInstance() {
		if (buttonPage == null) {
			buttonPage = new ButtonPage();
		}
		return buttonPage;
	}

	private Locator homePageButtonLocator = page.locator("id=home");
	private Locator findLocationButtonLocator = page.locator("id=position");
	private Locator findColorButtonLocator = page.locator("id=color");
	private Locator findHeightButtonLocator = page.locator("id=color");
	private Locator disableButtonLocator = page.getByRole(AriaRole.BUTTON,
			new Page.GetByRoleOptions().setName("Disabled"));
	private Locator longPressButtonLocator = page.locator("h2");
}
