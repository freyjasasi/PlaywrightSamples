package sampleTests;

import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import testBase.TestBase;

public class OpenAndClose extends TestBase {

	public OpenAndClose() {
		super();
	}

	@Test(groups = { "sample", "openAndClose" })
	public void OpenCloseFirstTest() {
		Page page = browser.newPage();
		page.navigate(prop.getProperty("url"));
		System.out.println(page.url());
	}
}
