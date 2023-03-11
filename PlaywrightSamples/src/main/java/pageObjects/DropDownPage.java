package pageObjects;

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

}
