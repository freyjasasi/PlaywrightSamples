package sampleTests;

import org.testng.annotations.Test;

import pageObjects.DragDropPage;
import testBase.TestBase;

public class DragAndDropTest extends TestBase {

	@Test(groups = "dragAndDrop")
	public void dragDropTest() {
		page.navigate(prop.getProperty("dropPage"));
		DragDropPage dragDropPage = DragDropPage.getInstance();
		System.out.println("Before Drop: " + dragDropPage.getVerifyDropLocator().textContent());

		dragDropPage.getDragLocator().dragTo(dragDropPage.getDropLocator());

		System.out.println("After Drop: " + dragDropPage.getVerifyDropLocator().textContent());

	}

}
