package pageObjects;

import com.microsoft.playwright.Locator;

import lombok.Getter;
import testBase.TestBase;

@Getter
public class DropDownPage extends TestBase {

	private DropDownPage() {
	}

	private static DropDownPage dropDownPage;

	public static DropDownPage getInstance() {
		if (dropDownPage == null) {
			dropDownPage = new DropDownPage();
		}
		return dropDownPage;
	}

	private Locator fruitsLocator = page.locator("id=fruits");
	private Locator fruitSelctedVerifyLocator = page.locator("(//p[@class='subtitle'])[1]");
	private Locator superHerosLocator = page.locator("id=superheros");
	private Locator superHeroSelcetVerifyLocator = page.locator("(//p[@class='subtitle'])[2]");
	private Locator langLocator = page.locator("id=lang");
	private Locator countryLocator = page.locator("id=country");

}
