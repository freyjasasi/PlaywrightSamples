package sampleTests;

import org.testng.annotations.Test;

import testBase.TestBase;

public class OpenAndClose extends TestBase {

	public OpenAndClose() {
		super();
	}

	@Test(groups = { "firstTest", "openAndClose" })
	public void OpenCloseFirstTest() {
		page.navigate(prop.getProperty("url"));
		System.out.println("Url: " + page.url() + " Title: " + page.title());
	}
}
