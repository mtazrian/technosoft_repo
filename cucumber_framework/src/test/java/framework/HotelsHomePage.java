package framework;

import org.openqa.selenium.By;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Mo Tazrian on 3/14/18.
 */
public class HotelsHomePage extends BasePage {

    private String pageTitle = SharedSD.getDriver().getTitle();
    private By overlay = By.xpath("//*[@id=\"managed-overlay\"]/button");
    private By textBox = By.cssSelector("#qf-0q-destination");
    private SimpleDateFormat sdf = new SimpleDateFormat("d");
    private Calendar tomorrow;

    public void iAmOnHomePage() {
        Assert.assertEquals(pageTitle, "Hotels.com - Cheap Hotels, Discount Rates & Hotel Deals");
    }

    public void typeDestination() {
        clickOn(overlay);

        sendText(textBox, "minnesota");
    }

    public void selectFromAutoComplete() {
        selectFromAutoCompleteByText(By.className("autosuggest-category-result"), "Minnesota City, Minnesota, United States of America");
    }

    public void selectCalendarDates() {
        tomorrow = Calendar.getInstance();
        tomorrow.add(Calendar.DATE, 1);
        String tomDate = sdf.format(tomorrow.getTime());

        clickOn(By.cssSelector("#qf-0q-localised-check-in"));

        clickOn(By.linkText(tomDate));

        clickOn(By.cssSelector("#qf-0q-localised-check-out"));

        tomorrow.add(Calendar.DATE, 6);
        clickOn(By.linkText(sdf.format(tomorrow.getTime())));
    }

    public void selectTravelersFromDropdown() {

        selectDropDown(By.cssSelector("#qf-0q-compact-occupancy"), 2);

        selectDropDown(By.cssSelector("#qf-0q-room-0-adults"), 1);

        selectDropDown(By.cssSelector("#qf-0q-room-0-children"), 2);
    }

    public void selectAgeOfChildren() {

        selectDropDown(By.cssSelector("#qf-0q-room-0-child-0-age"), 3);

        selectDropDown(By.cssSelector("#qf-0q-room-0-child-1-age"), 5);
    }

    public void clickSearch() {

        clickOn(By.cssSelector("#main-content > main > div.resp-row.homepage-container > div > div:nth-child(1) > div > div.resp-row.resp-section > div.resp-col.resp-xs1.resp-s2.resp-m6.resp-ml3.resp-l4.resp-xl4.container-queryform > div > div > form > div.widget-query-group.widget-query-ft > button"));
    }


}
