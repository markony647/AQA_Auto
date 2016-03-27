package pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {


    @FindBy(css = "input.hide-outline")
    public WebElement searchField;


    public void searchForProduct(String searchItem) {
        searchField.sendKeys(searchItem + Keys.ENTER);
    }
}
