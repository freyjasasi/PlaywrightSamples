package pageObjects;

import com.microsoft.playwright.Locator;

import lombok.Getter;
import testBase.TestBase;

@Getter
public class WindowsPage extends TestBase {

	private WindowsPage() {
	}

	private static WindowsPage windowsPage;

	public static WindowsPage getInstance() {
		if (windowsPage == null) {
			windowsPage = new WindowsPage();
		}
		return windowsPage;
	}

	private Locator homePageButtonLocator = page.locator("id=home");
	private Locator multiWindowButtonLocator = page.locator("id=multi");
}
