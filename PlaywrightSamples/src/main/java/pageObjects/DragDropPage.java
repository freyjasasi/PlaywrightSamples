package pageObjects;

import com.microsoft.playwright.Locator;

import lombok.Getter;
import testBase.TestBase;

@Getter
public class DragDropPage extends TestBase {
	private DragDropPage() {
	}

	private static DragDropPage dragDropPage;

	public static DragDropPage getInstance() {
		if (dragDropPage == null) {
			dragDropPage = new DragDropPage();
		}
		return dragDropPage;
	}

	private Locator dragLocator = page.locator("id=draggable");
	private Locator dropLocator = page.locator("id=droppable");
	private Locator verifyDropLocator = page.locator("//div[@id='droppable']//p[1]");

}
