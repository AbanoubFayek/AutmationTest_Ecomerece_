package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductReviewsPage {
    private WebDriver driver;

    public ProductReviewsPage(WebDriver driver) {
        this.driver = driver;
    }
    By reviewTitle = By.id("AddProductReview_Title");
    By reviewText = By.id("AddProductReview_ReviewText");
    By ratingOptions = By.cssSelector("input[name=\"AddProductReview.Rating\"]") ;
    By submitReview = By.className("buttons") ;

    private void setReviewTitle(String title){
        driver.findElement(reviewTitle).sendKeys(title);
    }
    private void setReviewText(String text){
        driver.findElement(reviewText).sendKeys(text);
    }

    // rating index begin with 1 to 5 => 1 bad , 5 excellent
    private void setRatingOptions(int ratingNum){
        List<WebElement> rates = driver.findElements(ratingOptions);
        rates.get(ratingNum).click();
    }

    private void clickSubmitReviewButton(){
        driver.findElement(submitReview).click();
    }


    public void GiveAReviewOfProduct(String title,String text , int rateNum){
        setReviewTitle(title);
        setReviewText(text);
        setRatingOptions(rateNum);
        clickSubmitReviewButton();
    }



}
