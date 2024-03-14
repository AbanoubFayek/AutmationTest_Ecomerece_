package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MyAccountPage extends BasePage {
    private  WebDriver driver ;
    public MyAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    private By Logout = By.className("ico-logout");
    private By changePasswordLink = By.linkText("Change password");
    private By ChangePasswordButton = By.className("buttons");
    private By OldPassword = By.id("OldPassword");
    private By NewPassword = By.id("NewPassword");
    private By ConfirmPassword = By.id("ConfirmNewPassword");
    private By messageSuccessChangedPassword = By.className("content") ;

   public void ClickOnChangePassword(){
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.elementToBeClickable(changePasswordLink));
       driver.findElement(changePasswordLink).click();
    }
    private void ClickOnChangePasswordButton(){
       driver.findElement(ChangePasswordButton).click();
    }

    public void logOut(){
        driver.findElement(Logout).click();
    }

    private void EnterOldPassword(String OldPass){
        driver.findElement(OldPassword).sendKeys(OldPass);
    }

    private void EnterNewPassword(String NewPass){
        driver.findElement(NewPassword).sendKeys(NewPass);
    }

    private void EnterConfirmPassword(String ConfPass){
        driver.findElement(ConfirmPassword).sendKeys(ConfPass);
    }

    public void ChangePassword(String Oldpass , String Newpass){
          EnterOldPassword(Oldpass);
          EnterNewPassword(Newpass);
          EnterConfirmPassword(Newpass);
          ClickOnChangePasswordButton();
    }
    public String getMessageSuccessPasswordChanged(){
       return driver.findElement(messageSuccessChangedPassword).getText();
    }
    public WebElement findLogoutElement(){
      return driver.findElement(Logout) ;
    }



}
