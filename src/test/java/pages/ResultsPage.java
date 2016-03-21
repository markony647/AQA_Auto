package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultsPage {

    @FindBy(css = ".main-info.whole-title>div>h2>a") // bad locator!
    public WebElement result;

    @FindBy(css = "span[class=\"search-title-highlight\"]")
    public WebElement searchParamText;
}
