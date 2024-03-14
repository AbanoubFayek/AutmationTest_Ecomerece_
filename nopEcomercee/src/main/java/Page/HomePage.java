package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage extends BasePage {
    private WebDriver driver ;
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    By Register = By.className("ico-register");
    By Login = By.className("ico-login");
    By contactUs = By.linkText("Contact us") ;
    By currencyChangeDropDown = By.id("customerCurrency");
    By productsCurrency =By.cssSelector(".prices span");
    private By pageTitle = By.cssSelector(".page-title h1");

   // select from top menu to hover what you want.
    public void choiceFromTopMenu(String mainType , String subType){
      WebElement productType =  driver.findElement(By.linkText(mainType));
        Actions actions = new Actions(driver);
        actions.moveToElement(productType).moveToElement(specificType(subType)).click().build().perform();
    }
    //select from specific device from menu type selected
    private WebElement specificType(String subType){
       return driver.findElement(By.cssSelector(".sublist.first-level a[href=\"/"+subType+"\"]"));
    }
     public void ClickRegister() {
        driver.findElement(Register).click();
    }
     public void ClickLogin() {
        driver.findElement(Login).click();
    }

     public void ClickOnContactUs(){
        scrollDownByMouseToElement(contactUs);
        ClickElement(contactUs);
    }

    private Select selectCurrency(){
       return new Select(driver.findElement(currencyChangeDropDown));
    }

    public void choiceCurrencyOfProduct(String currency){
       selectCurrency().selectByVisibleText(currency);
    }

    public List<WebElement> FindAllProductsPrices(){
     return driver.findElements(productsCurrency);
    }

    public String getProductTitle(){
       return driver.findElement(pageTitle).getText();
    }
}
