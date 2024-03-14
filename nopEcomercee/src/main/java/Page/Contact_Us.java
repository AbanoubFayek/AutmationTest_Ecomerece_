package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Contact_Us {
     WebDriver driver ;

    public Contact_Us(WebDriver driver) {
        this.driver = driver;
    }
    By yourName = By.id("FullName") ;
 By Email = By.id("Email") ;

 By enquiry = By.id("Enquiry") ;
 By submit = By.className("buttons") ;
 By result = By.cssSelector("div.page-body .result") ;

    private void EnterName(String name){driver.findElement(yourName).sendKeys(name);}

    private void EnterEmail(String email){
        driver.findElement(Email).sendKeys(email);
    }

    private void EnterEnquiry(String Text){
        driver.findElement(enquiry).sendKeys(Text);
    }

     private void ClickSubmitButton(){
        driver.findElement(submit).click();
    }


    public void PutContactInformation(String name , String mail , String TextEnquiry){
               EnterName(name);
               EnterEmail(mail);
               EnterEnquiry(TextEnquiry);
               ClickSubmitButton();
 }

 public String GetSuccessMessageOfSubmitContactInformation(){
       return driver.findElement(result).getText();
 }


}
