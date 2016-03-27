package pages;


import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import static org.junit.Assert.*;


public class ResultsPage {


    @FindBy(css = "h2 a[href*=\"joystick-for-siemens-c65-cx65-cx70-m65-s65-benq-motorola-e398-nokia-n90-5700\"]")
    public WebElement result;

    @FindBy(css = "span.search-title-highlight")
    public WebElement searchPageText;

    @FindBy(xpath = ".//*[@id='right-panel-content-wrapper']/ul/li/div[2]/div[2]/div/div/a") //bad locator!!!!
    public WebElement addToCartButton;

    @FindBy(name = "btn-plus")
    public WebElement plusSignButton;




    public void verifySearchQueryIsCorrect(String searchItem) {
        boolean isCorrectSearchQuery = searchPageText.getText().equalsIgnoreCase(searchItem);
        assertEquals(isCorrectSearchQuery, true);
    }

    public void verifySearchResultsHaveValidItem(String searchItem) {
        String searchItemLinkText = result.getText().toLowerCase();
        boolean IsContains = searchItemLinkText.contains(searchItem.toLowerCase());
        assertEquals(IsContains, true);
    }


    public void addSeveralItemsToCart(int howMany) {
        addToCartButton.click();
        for(int i=0; i<howMany; i++) {
            plusSignButton.click();
            Timeout.seconds(2);
        }
    }
}
