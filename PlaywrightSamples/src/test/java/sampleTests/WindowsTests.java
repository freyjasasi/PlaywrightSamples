package sampleTests;

import java.util.List;

import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.WaitForPopupOptions;

import pageObjects.WindowsPage;
import testBase.TestBase;

public class WindowsTests extends TestBase {

	@Test(groups = { "test", "windowsHandling" })
	public void windowsTests01() {
		page.navigate(prop.getProperty("windowPageUrl"));

		WindowsPage windowsPage = WindowsPage.getInstance();

		System.out.println(page.url());

		Page page2 = page.waitForPopup(() -> {
			windowsPage.getHomePageButtonLocator().click();
		});
		page2.waitForLoadState();
		System.out.println(page2.url());
		page2.close();

		// multiple windows
		page.waitForPopup((new WaitForPopupOptions().setPredicate(p -> p.context().pages().size() == 3)), () -> {
			windowsPage.getMultiWindowButtonLocator().click();
		});

		// to get list of all open windows
		List<Page> pageList = page.context().pages();
		pageList.forEach(pages -> System.out.println(pages.url()));

		// interact with other windows
		Page alertPage = pageList.get(1);
		String title = alertPage.title();
		System.out.println("Alert page title: " + title);

		Page dropdownPage = pageList.get(2);
		System.out.println("Dropdown page title: " + dropdownPage.title());

	}

}
