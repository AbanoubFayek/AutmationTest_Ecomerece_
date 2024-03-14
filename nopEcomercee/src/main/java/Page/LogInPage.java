package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
     private WebDriver driver ;
     public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

     private By Email = By.id("Email");
     private By password = By.id("Password");
     private By RememberMe = By.id("RememberMe");
     private By forgetPassword = By.className("forgot-password");
     private By LoginButton = By.cssSelector("div.buttons button[type=\"submit\"]");
     private By MyAccount = By.className("ico-account");

     private By UnsuccessfulMessage = By.xpath("//li[text()='No customer account found']") ;
     private By checkoutAsGuest= By.xpath("//button[text()='Checkout as Guest']");


     public String GetMessageOfUnSuccessLogin(){return driver.findElement(UnsuccessfulMessage).getText();}
     private void EnterEmail(String email){
        driver.findElement(Email).sendKeys(email);
    }

    private void EnterPassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }

    private void ClickOnLogInButton(){
         driver.findElement(LoginButton).click();
    }

    public PasswordRecovery ClickOnForgotPasswordLink(){
         driver.findElement(forgetPassword).click();
         return new PasswordRecovery(driver);
    }

    public void ClickOnRememberMe(){
         driver.findElement(RememberMe).click();
    }

    public void clickOnCheckOutAsGuest(){
         driver.findElement(checkoutAsGuest).click();
    }

    public void ClickOnMyAccount(){
         driver.findElement(MyAccount).click();
    }

    public void LogIn(String email,String pass){
         EnterEmail(email);
         EnterPassword(pass);
         ClickOnLogInButton();
    }
}

