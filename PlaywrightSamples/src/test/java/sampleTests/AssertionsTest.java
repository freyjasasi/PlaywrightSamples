package sampleTests;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.setDefaultAssertionTimeout;

import org.testng.annotations.Test;

import testBase.TestBase;

public class AssertionsTest extends TestBase {

	@Test
	public void assertTest() {
		setDefaultAssertionTimeout(10000); // 10 seconds

		page.navigate(prop.getProperty("letCodeInputUrl"));
		assertThat(page.locator("h1")).hasText("Input"); // test verify
		assertThat(page.locator("id=join")).hasAttribute("value", "I am good"); // attribute check

		page.navigate(prop.getProperty("radioUrl"));
		assertThat(page).hasTitle("LetCode with Koushik"); // title check
		assertThat(page.locator("id=notfoo")).isChecked(); // radio button check
		assertThat(page.locator("id=notG")).not().isChecked(); // radio button not check or reverse the boolean check

		/*
		 * there are many more in asserThat , refer playwright java doc for that
		 */

	}

}
