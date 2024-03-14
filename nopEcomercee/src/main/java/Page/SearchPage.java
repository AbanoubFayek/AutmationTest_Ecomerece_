package Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class SearchPage extends BasePage {
    private WebDriver driver ;

    public SearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    private By searchField = By.id("small-searchterms");
    private By searchButton = By.cssSelector("#small-search-box-form button") ;
    private By searchList = By.id("ui-id-1");
    private By SearchedProductDetails = By.cssSelector("div.details h2") ;
    private By product = By.className("product-title");

    public void searchOnSpecificItem(String item) {
        driver.findElement(searchField).sendKeys(item);
    }
    public void clickOnSearchButton(){
        driver.findElement(searchButton).click();
    }

    public String getSearchedProductDetails(){
      return driver.findElement(SearchedProductDetails).getText();
    }

    public void clickOnSpecificProduct(){
        driver.findElement(product).click();
    }

     public void SelectItemFormList(){
         List<WebElement> list = driver.findElements(searchList) ;
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)) ;
         // wait .until(d -> d.findElements(searchList).get(0) );
         wait.until(ExpectedConditions.visibilityOf(list.get(0)));
         list.get(0).click();


    }

     }



