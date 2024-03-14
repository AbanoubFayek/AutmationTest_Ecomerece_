package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompareList {
     private  WebDriver driver ;
     public CompareList(WebDriver driver) {
        this.driver = driver;
      }
      private By clearList = By.className("clear-list") ;

      private By compareListTable = By.cssSelector(".table-wrapper tbody");
      private By pricesOfCompareList = By.cssSelector(".product-price td");

      public void clickOnClearList(){
          driver.findElement(clearList).click();
      }


      public int getNumberOfCompareProducts(){
       return ((driver.findElements(pricesOfCompareList).size())-1);   // prices of compare products have price label with it so that elements - 1
      }


}
