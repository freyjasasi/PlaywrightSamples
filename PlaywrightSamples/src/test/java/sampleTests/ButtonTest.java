package sampleTests;

import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;

import pageObjects.ButtonPage;
import testBase.TestBase;

public class ButtonTest extends TestBase {

	@Test(groups = { "button" })
	public void buttonTest01() {
		ButtonPage buttonPage = ButtonPage.getInstance();
		page.navigate(prop.getProperty("buttonPage"));

		System.out.println("Before clicking home page: " + page.title());
		buttonPage.getHomePageButtonLocator().click();
		System.out.println("After clicking home page buttion: " + page.title());
		page.goBack();
		System.out.println("Again in button page: " + page.title());

		System.out.println("is Disabled button: " + buttonPage.getDisableButtonLocator().isDisabled());

		System.out.println("Before button hold: " + buttonPage.getLongPressButtonLocator().textContent());
		buttonPage.getLongPressButtonLocator().click(new Locator.ClickOptions().setDelay(4000));
		System.out.println("After button hold: " + buttonPage.getLongPressButtonLocator().textContent());

	}

}
