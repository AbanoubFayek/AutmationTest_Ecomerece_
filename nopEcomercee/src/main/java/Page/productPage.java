package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.Script;

public class productPage {
    private WebDriver driver ;

    public productPage(WebDriver driver) {
        this.driver = driver;
    }


    private By addCart = By.xpath("//div[@class='add-to-cart-panel']/button[text()='Add to cart']") ;
    private By wishlistButton = By.id("add-to-wishlist-button-4");

    private By AddToCompareListButton = By.cssSelector(".compare-products button");

    private By wishlistNotificationLink = By.cssSelector(".content a");
    private By notificationSuccess = By.className("content");
    private By emailFriend = By.cssSelector(".email-a-friend");
    private By review = By.linkText("Add your review");
    private By result = By.className("result");

    public String getProductName() {
        return driver.findElement(By.cssSelector(".product-name h1")).getText();
    }
    public void click_on_email_friend_button(){
        driver.findElement(emailFriend).click();}
    public void click_on_Add_Your_Review_link(){
        driver.findElement(review).click();}

    public void click_on_Add_To_Wishlist_Button(){
        driver.findElement(wishlistButton).click();}
    public void click_on_Add_To_Cart_Button(){
        driver.findElement(addCart).click();}

    public void click_on_Add_To_Link(){
        driver.findElement(wishlistNotificationLink).click();

    }

    public CompareList click_on_Add_to_Compare_list_Button(){
//        String Script = "argument[0].scrollToView";
//        ((JavascriptExecutor)driver).executeScript(Script,driver.findElement(AddToCompareListButton));
        driver.findElement(AddToCompareListButton).click();
        return new CompareList(driver);
    }
    public String getSuccessMessage(){
        return driver.findElement(result).getText();
    }

    public String getNotificationSuccess(){return driver.findElement(notificationSuccess).getText();}

    public void ClickOnCompareListButton(){
        driver.findElement(AddToCompareListButton).click();
    }



}
