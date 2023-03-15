package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class TestBase {

	public static Properties prop;

	private String path = "configs//config.properties";
	public static String time = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());

	private static Playwright playwright;
	private static Browser browser; // we can create context where needed
	private static BrowserContext context;
	public static Page page;

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

		context = browser.newContext(
				new Browser.NewContextOptions()
						.setRecordVideoDir(Paths.get("videos/test_recording_" + time))
						.setRecordVideoSize(1280, 720)); // change size as per your screen resolution

		context.tracing()
				.start(new Tracing.StartOptions()
						.setScreenshots(true)
						.setSnapshots(true)
						.setSources(false));

		page = context.newPage();

	}

	@BeforeTest
	public void beforeEachTest() {
		initialization();
	}

	@AfterTest
	public void afterEachTest() {
		context.tracing().stop(new Tracing.StopOptions()
				.setPath(Paths.get("test_traces/traces_" + time + ".zip")));
		/*
		 * to view the traces go to https://trace.playwright.dev/ and upload the zip
		 * file
		 */

		context.close(); // profile
		page.close(); // tab
		browser.close(); // browser instance
		playwright.close(); // playwright instance
	}
}
