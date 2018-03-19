package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import stepdefinition.SharedSD;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mohammadmuntakim on 6/9/17.
 */
public class BasePage {

	public static void clickOn(By locator) {
		try {
			SharedSD.getDriver().findElement(locator).click();
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}

	public static void sendText(By locator, String text) {
		try {
			SharedSD.getDriver().findElement(locator).sendKeys(text);
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}

	public static String getTextFromElement(By locator) {
		String text = null;
		try {
			text = SharedSD.getDriver().findElement(locator).getText();
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}

		return text;
	}

	public static void mouseOver(By locator)  {
		WebElement element = SharedSD.getDriver().findElement(locator);

		Actions action = new Actions(SharedSD.getDriver());
		action.moveToElement(element).build().perform();
		SharedSD.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void selectFromAutoCompleteByText(By locator, String string) {
		try {
			List<WebElement> list = SharedSD.getDriver().findElements(locator);

			for (WebElement elements : list) {

				if (elements.getText().equals(string)) {
					elements.click();
					break;
				}
			}
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}

	public void selectDropDown(By locator, int index) {
		try {
			Select dropdown = new Select(SharedSD.getDriver().findElement(locator));
			dropdown.selectByIndex(index);
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}


	public void clickOnBrowserBackArrow() {
		SharedSD.getDriver().navigate().back();
	}

	public void clickOnBrowserForwardArrow() {
		SharedSD.getDriver().navigate().forward();
	}

	public void refreshBrowser() { SharedSD.getDriver().navigate().refresh(); }

}
