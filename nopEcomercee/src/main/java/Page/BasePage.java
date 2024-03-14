package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage{

   protected BasePage(WebDriver driver) {
        this.driver = driver;
    }
    protected WebDriver driver ;

    protected void SetTextTOElement(By element, String value ){
        driver.findElement(element).sendKeys(value);
    }

    protected  void ClickElement(By element){
        driver.findElement(element).click();
    }

    protected  void selectElement(By element ,String country){
        new Select(driver.findElement(element)).selectByVisibleText(country);
    }

    protected void scrollDownByMouseToElement(By element){
        WebElement Element = driver.findElement(element) ;
        String script = "arguments[0].scrollIntoView(true);";
        ((JavascriptExecutor)driver).executeScript(script,Element);
    }

    protected void scrollDownByCertainAmount(){
        String script = "window.scrollBy(0,500)";
        ((JavascriptExecutor)driver).executeScript(script);
    }

    protected void awaitToElementVisible(By element){
        WebElement Element = driver.findElement(element) ;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(Element));
    }

}
