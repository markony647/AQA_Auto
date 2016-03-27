package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header {

    @FindBy(css = "a[class=\"header-right-icons cart-icon empty\"]")
    WebElement cartPictogram;

    public void goToCartPage() {
        cartPictogram.click();
    }
}
