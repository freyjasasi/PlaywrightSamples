package sampleTests;

import org.testng.annotations.Test;

import com.microsoft.playwright.Frame;

import testBase.TestBase;

public class FrameTests extends TestBase {

	@Test(groups = { "test", "frames" })
	public void framesTest01() {
		page.navigate(prop.getProperty("frameUrl"));

		Frame f_l_name = page.frame("firstFr");

		f_l_name.getByPlaceholder("Enter name").type("Hello");
		f_l_name.locator("[name='lname']").fill("Guru");
		String names = f_l_name.locator("//p[@class='title has-text-info']").textContent();

		System.out.println(names);

	}

}
