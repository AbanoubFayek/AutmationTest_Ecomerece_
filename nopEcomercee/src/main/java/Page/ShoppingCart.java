package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCart extends BasePage {
    private WebDriver driver ;
    public ShoppingCart(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    private By RemoveButton = By.cssSelector(".remove-from-cart  button");
    private By UpdateCart = By.id("updatecart");
    private By Quantity = By.cssSelector(".quantity .qty-input");
    private By emptyPage= By.className("no-data");
    private By agreeTerms = By.id("termsofservice");

    private By checkout = By.id("checkout");

    public void editQuantity(String quantity){
        driver.findElement(Quantity).clear();
        driver.findElement(Quantity).sendKeys(quantity);
    }
    public String getQuantity(){
      return   driver.findElement(Quantity).getAttribute("value");
    }
    public void clickUpdateShopCartButton(){
        driver.findElement(UpdateCart).click();
    }
    public String getMessageOfEmptypage(){
        return driver.findElement(emptyPage).getText();
    }
    public void clickOnRemoveButton(){
        driver.findElement(RemoveButton).click();
    }

    public void makeCheckOutOFProducts(){
         scrollDownByMouseToElement(checkout);
         awaitToElementVisible(checkout);
         driver.findElement(agreeTerms).click();
         driver.findElement(checkout).click();
    }

}
