package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Mo Tazrian on 3/8/18.
 */
public class DarkSkyHomePage extends BasePage {

    private By dayOfWeek = By.className("name");
    private String pageTitle = SharedSD.getDriver().getTitle();
    private By lowTemp1 = By.xpath("//*[@id=\"week\"]/a[1]/span[2]/span[1]");
    private By parentBars = By.className("bar");
    private By lowTemp = By.className("minTemp");
    private By highTemp = By.className("maxTemp");
    private By minTemp = By.cssSelector("div.highLowTemp.swip > span.highTemp.swip > span.temp");
    private By maxTemp = By.cssSelector("div.highLowTemp.swip > span.lowTemp.swap > span.temp");
    private By timeMachine = By.cssSelector("#timeMachine > div.buttonContainer > a");
    private By calendarWidget = By.className("calendar");
    private By individualDay = By.tagName("td");
    private By dateShown = By.xpath("//*[@id=\"main\"]/div[1]/div[1]/div");
    private By actualDate = By.className("date");

    private List<String> actualDay = new ArrayList<>();
    private List<String> expectedDay = new ArrayList<>();

    private SimpleDateFormat sdf = new SimpleDateFormat("EEE");

    private List<String> minTempArray = new ArrayList<>();
    private List<String> maxTempArray = new ArrayList<>();
    private List<String> lowTempArray = new ArrayList<>();
    private List<String> highTempArray = new ArrayList<>();

    private SimpleDateFormat sdf2 = new SimpleDateFormat("d");
    private SimpleDateFormat sdf3 = new SimpleDateFormat("EEEE, MMM d, yyyy");
    private Calendar tomorrow;



    public void pageTitleVerification() {
        Assert.assertEquals(pageTitle, "Dark Sky - 260 Broadway, New York City, NY");
    }

    public void createActualArray() {
        List<WebElement> element = SharedSD.getDriver().findElements(dayOfWeek);

        for (WebElement days : element) {
            actualDay.add(days.getText());
        }
    }

    public void createExpectedArray() {
        expectedDay.add("Today");

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());

        int addDay = 1;
        int counter = 0;

        do {
            cal.add(Calendar.DAY_OF_WEEK, addDay);
            expectedDay.add(sdf.format(cal.getTime()));
            counter += 1;
        }
        while (counter < 7);
    }

    public void arrayVerification() {
        Assert.assertEquals(actualDay, expectedDay);
    }

    public void clickOnParentBars() {
        List<WebElement> bar = SharedSD.getDriver().findElements(parentBars);
        for(WebElement button : bar) {
            button.click();
        }
    }

    public void getMinMaxTemps() {
        List<WebElement> elements = SharedSD.getDriver().findElements(lowTemp);
        List<WebElement> elements1 = SharedSD.getDriver().findElements(highTemp);

        for (WebElement el: elements) {
            minTempArray.add(el.getText());
        }
        for (WebElement el: elements1) {
            maxTempArray.add(el.getText());
        }
    }

    public void getLowHighTemps() {
        List<WebElement> elements2 = SharedSD.getDriver().findElements(minTemp);

        for (WebElement e1: elements2) {
            lowTempArray.add(e1.getText());
        }

//        Inside highTempArray
        List<WebElement> elements3 = SharedSD.getDriver().findElements(maxTemp);

        for (WebElement e1: elements3) {
            highTempArray.add(e1.getText());
        }
    }

    public void assertVerification() {
        Assert.assertEquals(lowTempArray, minTempArray);
        Assert.assertEquals(highTempArray, maxTempArray);
    }

    public void clickTimeMachine() {

        clickOn(timeMachine);
    }

    public void selectDateFromCalendar() {
        tomorrow = Calendar.getInstance();
        tomorrow.add(Calendar.DATE, 1);
        String tomDate = sdf2.format(tomorrow.getTime());

        WebElement dateWidget = SharedSD.getDriver().findElement(calendarWidget);
        List<WebElement> weekDay = dateWidget.findElements(individualDay);

        for (WebElement day2 : weekDay) {
            String expectedDay = day2.getText();
            if (expectedDay.equals(tomDate)) {
                day2.click();
                break;
            }
        }
    }

    public void verifyDateNotClickable() {

        WebElement clickable = SharedSD.getDriver().findElement(dateShown);
        Assert.assertFalse(clickable.isSelected());
    }


    public void verifyCorrectFormat() {

        tomorrow = Calendar.getInstance();
        tomorrow.add(Calendar.DATE, 1);

        String tomDate2 = sdf3.format(tomorrow.getTime());

        Assert.assertEquals(SharedSD.getDriver().findElement(actualDate).getText(), SharedSD.getDriver().findElement(dateShown).getText());
    }
}

