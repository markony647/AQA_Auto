package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pages.MainPage;
import pages.ResultsPage;
import org.junit.Assert;

public class SearchProductItemTest {

    String searchItem = "joystick for nokia 5700";

    WebDriver firefox;
    MainPage mainPage;
    ResultsPage resultsPage;

    @Before
    public void setUp() throws Exception {
        firefox = new FirefoxDriver();
        mainPage = PageFactory.initElements(firefox, MainPage.class);
        resultsPage = PageFactory.initElements(firefox, ResultsPage.class);
        firefox.get("http://gsmserver.com");

    }

    @Test
    public void shouldFindItemTest() {
        mainPage.searchField.sendKeys(searchItem + Keys.ENTER);
        String searchParam = resultsPage.searchParamText.getText();
        boolean correctSearchParam = searchParam.equals(searchItem);
        Assert.assertEquals(correctSearchParam, true);
        String results = resultsPage.result.getText().toLowerCase();
        boolean containsSearchParameter = results.startsWith(searchItem);
        Assert.assertEquals(containsSearchParameter, true);

    }

    @After
    public void tearDown() throws Exception {
       firefox.quit();
    }
}
