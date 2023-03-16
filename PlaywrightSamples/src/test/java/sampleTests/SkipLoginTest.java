package sampleTests;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

import testBase.TestBase;

public class SkipLoginTest extends TestBase {

	@Test(groups = { "oneTime" })
	public void firstTimeLogin() {
		page.navigate(prop.getProperty("bookCart"));
		page.locator("(//span[@class='mat-button-wrapper'])[3]").click();
		page.locator("//input[@data-placeholder='Username']").type("");
		page.locator("//input[@data-placeholder='Password']").type("");
		page.locator("(//span[text()='Login'])[2]").click();

//		 saving auth, once saved you can use any number of times for login
		context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("auths/bookCart_auth.json")));
	}

	@Test(groups = { "skipedLogin" })
	public void skipLogin() {
		BrowserContext context = browser.newContext(
				new Browser.NewContextOptions().setStorageStatePath(Paths.get("auths/bookCartauth.json")));
		Page page = context.newPage();
		page.navigate(prop.getProperty("bookCart"));

		String textContent = page.locator("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]")
				.textContent();
		System.out.println(textContent);
	}

}
