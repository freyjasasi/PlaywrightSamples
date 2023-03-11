package sampleTests;

import org.testng.annotations.Test;

import com.microsoft.playwright.options.SelectOption;

import pageObjects.DropDownPage;
import testBase.TestBase;

public class DropDownTests extends TestBase {

	@Test(groups = { "test", "dropDown" })
	public void dropDownTest01() {
		DropDownPage dropDownPage = DropDownPage.getInstance();
		page.navigate(prop.getProperty("dropDownUrl"));

		// select by label
		dropDownPage.getFruitsLocator().selectOption(new SelectOption().setLabel("Apple"));
		System.out.println("Fruits: " + dropDownPage.getFruitSelctedVerifyLocator().textContent()); // TODO

		dropDownPage.getSuperHerosLocator().selectOption("rb");
		System.out.println("Super Hero: " + dropDownPage.getSuperHeroSelcetVerifyLocator().textContent());

		dropDownPage.getLangLocator().selectOption(new SelectOption().setIndex(4));
		System.out.println("Lang: " + dropDownPage.getSuperHeroSelcetVerifyLocator().textContent());

		dropDownPage.getCountryLocator().selectOption("India");

	}

}
