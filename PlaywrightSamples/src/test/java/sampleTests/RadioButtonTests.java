package sampleTests;

import org.testng.annotations.Test;

import com.microsoft.playwright.Locator.IsCheckedOptions;

import pageObjects.RadioPage;
import testBase.TestBase;

public class RadioButtonTests extends TestBase {

	@Test(groups = { "tests", "radioButton" })
	public void radioButtonTests01() throws InterruptedException {
		page.navigate(prop.getProperty("radioUrl"));
		RadioPage radioPage = RadioPage.getInstance();

		radioPage.getYesLocator().check();
		System.out.println("is Yes selected: " + radioPage.getYesLocator().isChecked());

		radioPage.getSelectYesLocator().check();
		System.out.println("is Yes selected 2nd: " + radioPage.getSelectYesLocator().isChecked());
		System.out.println("It should be false: " + radioPage.getSelectNoLocator().isChecked());

		radioPage.getNoBugYesLocator().check();
		System.out.println("No bug Yes, true: " + radioPage.getNoBugYesLocator().isChecked());
		radioPage.getBugLocator().check();
		if (radioPage.getBugLocator().isChecked()) {
			System.out.println("This is bug, Yes and No both selected");
		}

		if (radioPage.getMaybeDisabledLocator().isDisabled()) {
			System.out.println("Yes, its disabled");
		}

		if (radioPage.getFooLocator().isChecked()) {
			System.out.println("Foo is already selected");
		}

		if (radioPage.getRememberLocator().isChecked(new IsCheckedOptions().setTimeout(2000))) {
			System.out.println("Yes check box selected");
		}

		radioPage.getSelectCheckbox().check();
		System.out.println("is terms selected: " + radioPage.getSelectCheckbox().isChecked());

		Thread.sleep(2000);

	}

}
