package sampleTests;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;

import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.options.ScreenshotCaret;

import testBase.TestBase;

public class ScreenShotExample extends TestBase {

	@Test
	public void screenShotDemo() {
		page.navigate(prop.getProperty("homePage"));
		page.getByText("Sign up").click();
		System.out.println(page.url());

		Random random = new Random();

		// takes screenshot only visible part
		page.screenshot(
				new ScreenshotOptions()
						.setPath(Paths.get("./snaps/snap_" + time + "_" + random.nextInt(100) + ".png")));

		// takes full page screenshot
		page.screenshot(new ScreenshotOptions()
				.setPath(Paths.get("./snaps/snap_" + time + "_" + random.nextInt(100) + ".png")).setFullPage(true));

		Locator enterNameLocator = page.getByPlaceholder("Enter your name");
		enterNameLocator.click();
		Locator emailLocator = page.getByPlaceholder("Enter valid email address");
		emailLocator.click();

		// screenshot with caret present
		enterNameLocator.screenshot(new Locator.ScreenshotOptions()
				.setPath(Paths.get("./snaps/snap_" + time + "_" + random.nextInt(100) + ".png"))
				.setCaret(ScreenshotCaret.INITIAL));

		// screenshot with caret in hide
		enterNameLocator.screenshot(new Locator.ScreenshotOptions()
				.setPath(Paths.get("./snaps/snap_" + time + "_" + random.nextInt(100) + ".png"))
				.setCaret(ScreenshotCaret.HIDE));

		// masking the user_name, email field, can be done using page
		// we give as arrays for all locators to be masked in that page screenshot
		page.screenshot(
				new ScreenshotOptions().setPath(Paths.get("./snaps/snap_" + time + "_" + random.nextInt(100) + ".png"))
						.setMask(Arrays.asList(enterNameLocator, emailLocator)));
	}

}
