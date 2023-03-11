package sampleTests;

import org.testng.annotations.Test;

import pageObjects.DropDownPage;
import testBase.TestBase;

public class DropDownTests extends TestBase {

	@Test(groups = { "test", "dropDown" })
	public void dropDownTest01() {
		DropDownPage dropDownPage = DropDownPage.getInstance();

	}

}
