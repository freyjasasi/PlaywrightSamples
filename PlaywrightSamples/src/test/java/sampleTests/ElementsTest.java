package sampleTests;

import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

import testBase.TestBase;

public class ElementsTest extends TestBase {

	@Test
	public void multiElements() {
		page.navigate(prop.getProperty("elements"));
		page.getByPlaceholder("Enter your git user name").fill("google");
		page.locator("id=search").click();

		Locator linksLocator = page.locator("ol li a");

		// explicit wait in playwright
		linksLocator.last()
				.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.ATTACHED).setTimeout(3000));
		System.out.println("total links: " + linksLocator.count());

		for (int i = 0; i < linksLocator.count(); i++) {
			System.out.println(i + 1 + "." + linksLocator.nth(i).textContent());
		}

	}

}
