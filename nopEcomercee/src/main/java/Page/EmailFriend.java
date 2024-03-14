package Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailFriend {
    private WebDriver driver ;

    public EmailFriend(WebDriver driver) {
        this.driver = driver;
    }
    By friendsEmail = By.id("FriendEmail");
    By yourEmail = By.id("YourEmailAddress");
    By personalMessage = By.id("PersonalMessage") ;
    By submit = By.className("buttons") ;

    private void setFriendsEmail(String friends_email){
        driver.findElement(friendsEmail).sendKeys(friends_email);
    }
    private void setYourEmail(String your_email){
        driver.findElement(yourEmail).sendKeys(your_email);
    }
    private void setPersonalMessage(String message){
        driver.findElement(personalMessage).sendKeys(message);
    }
    private void clickSubmitButton(){
        driver.findElement(submit).click();
    }


    public void SendEmailToFriendTOShowProduct(String friends_email,String your_email,String message){
        setFriendsEmail(friends_email);
        setYourEmail(your_email);
        setPersonalMessage(message);
        clickSubmitButton();
    }
}
