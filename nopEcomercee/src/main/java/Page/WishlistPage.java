package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WishlistPage {
    WebDriver driver ;

    public WishlistPage(WebDriver driver) {
        this.driver = driver;
    }
    private By AddToCartCheckbox= By.cssSelector(".add-to-cart input");
    private By RemoveButton = By.cssSelector(".remove-from-cart  button");
    private By AddToCartButton = By.cssSelector(".buttons  button[name=\"addtocartbutton\"]");
    private By productName = By.cssSelector("tr td a[class=\"product-name\"]");
    private By productsTable = By.cssSelector("form tbody ") ;

    private By emptyPage= By.className("no-data");


    private void getproducttable(){
        List<WebElement> productTable= driver.findElements(productsTable);
        }

    public void clickOnAddChartCheckbox(){
        driver.findElement(AddToCartCheckbox).click();
    }
    public void clickOnRemoveButton(){
        driver.findElement(RemoveButton).click();
    }
    public void clickOnAddChartButton(){
        driver.findElement(AddToCartButton).click();
    }
     public String getProductName(){
        return driver.findElement(productName).getText();
     }
     public String getMessageOfEmptypage(){
      return driver.findElement(emptyPage).getText();
     }
}
