package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WebDriver driver ;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    private By Firstname = By.id("FirstName");
    private By Lastname = By.id("LastName") ;
    private By Email = By.id("Email") ;
    private By password = By.id("Password");
    private By ConfirmPassword = By.id("ConfirmPassword");
    private By RegisterButton = By.id("register-button");
    private By MaleGender = By.id("gender-male");
    private By FemaleGender = By.id("gender-female");
    private By result = By.className("result");

    public void EnterFirstname(String first_name){
        driver.findElement(Firstname).sendKeys(first_name);
    }
    public void EnterLastname(String last_name){
        driver.findElement(Lastname).sendKeys(last_name);
    }
    public void EnterEmail(String email){
        driver.findElement(Email).sendKeys(email);
    }
    public void EnterPassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }
    public void EnterConfirmPassword(String confirm_pass){
        driver.findElement(ConfirmPassword).sendKeys(confirm_pass);
    }
    public void ClickRegisterButton(){
        driver.findElement(RegisterButton).click();
    }
    public void ClickOnMaleGender(){
        driver.findElement(MaleGender).click();
    }
    public void ClickOnFemaleGender(){
        driver.findElement(FemaleGender).click();
    }
    public String GetSuccessMessage(){
       return driver.findElement(result).getText();
    }

    public void Register
            (String gender,String firstname, String lastname,String email, String password,String ConfirmPass){
        if(gender.equalsIgnoreCase("male")){
          ClickOnMaleGender();
        }else {
           ClickOnFemaleGender();
        }
        EnterFirstname(firstname);
        EnterLastname(lastname);
        EnterEmail(email);
        EnterPassword(password);
        EnterConfirmPassword(ConfirmPass);
        ClickRegisterButton();
    }
}
