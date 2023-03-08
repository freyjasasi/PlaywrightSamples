package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class TestBase {

	public static Properties prop;
	private String path = "configs//config.properties";
	private static Playwright playwright;
	public static Browser browser;

	public TestBase() {
		prop = new Properties();
		try (FileInputStream inputStream = new FileInputStream(path)) {
			prop.load(inputStream);
			playwright = Playwright.create();
			System.out.println("Properties loaded!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		// then open browser based on input from properties file
		String browserName = prop.getProperty("browser");
		boolean headless = Boolean.valueOf(prop.getProperty("headless"));

		if (browserName.equalsIgnoreCase("chromium") | browserName.equalsIgnoreCase("chrome")
				| browserName.equalsIgnoreCase("edge")) {
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
		} else if (browserName.equalsIgnoreCase("webkit")) {
			browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(headless));
		} else if (browserName.equalsIgnoreCase("firefox") | browserName.equalsIgnoreCase("mozilla")) {
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(headless));
		} else {
			System.out.println("please use valid browser name in properties file");
			System.exit(0);
		}
	}

	@BeforeTest
	public void beforeEachTest() {
		initialization();
	}

	@AfterTest
	public void afterEachTest() {
		browser.close();
		playwright.close();
	}
}
