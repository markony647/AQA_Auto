package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pages.Header;
import pages.HomePage;
import pages.ResultsPage;

public class SearchProductItemTest {

    String searchItem = "joystick for nokia 5700";

    private WebDriver driver;
    HomePage homePage;
    ResultsPage resultsPage;
    Header header;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        homePage = PageFactory.initElements(driver, HomePage.class);
        resultsPage = PageFactory.initElements(driver, ResultsPage.class);
        header = PageFactory.initElements(driver,Header.class);
        driver.get("http://gsmserver.com");

    }

    @Test
    public void shouldBeCorrectSearchQuery() {
        homePage.searchForProduct(searchItem);
        resultsPage.verifySearchQueryIsCorrect(searchItem);
    }

    @Test
    public void shouldHaveValidItemInSearchResults() {
        homePage.searchForProduct(searchItem);
        resultsPage.verifySearchResultsHaveValidItem(searchItem);
    }

    @Test
    public void shouldBePossibleAddItemsToCart() {
        int productsAddToCartQuantity = 3; 
        homePage.searchForProduct(searchItem);
        resultsPage.addSeveralItemsToCart(productsAddToCartQuantity);
        header.goToCartPage();

    }

    @After
    public void tearDown() throws Exception {
       driver.quit();
    }
}
