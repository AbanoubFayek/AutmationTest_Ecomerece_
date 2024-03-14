package TestFeatures;

import Browser.SetUp_Website;
import Page.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestEmailFriend extends SetUp_Website {
    // need to Register
    SoftAssert Soft = new SoftAssert();
    @DataProvider
    private Object[][] registerData(){
        var data = new Object [][]  {
                {"Male","Ahmed","Hassan","ahmedss1s3@gmail.com","#Con1997","#Con1997"}
        };
        return data ;
    }
    @Test(dataProvider = "registerData" , priority = 0)
    public void registerWithNewAccount
    (String male,String firstname, String lastname,String email, String password,String confirmPass )
    {
        HomePage homePage = new HomePage(driver);
        homePage.ClickRegister();
        RegisterPage NewAccount = new RegisterPage(driver);
        NewAccount.Register(male,firstname,lastname,email,password,confirmPass);
        Soft.assertTrue(NewAccount.GetSuccessMessage().contains("Your registration completed\n"));
    }


    // need to search for product wanted
    String productShortSpell = "mac" ;
    @Test(priority = 1)
    public void SearchWithAutoComplete(){
        SearchPage search = new SearchPage(driver) ;
        search.searchOnSpecificItem(productShortSpell);
        search.SelectItemFormList();
        productPage product = new productPage(driver);
        Soft.assertTrue(product.getProductName().contains(productShortSpell));
    }
    // Email friend
    @DataProvider
    private Object[][] emailFriendData(){
        var data = new Object [][]  {
                {"ahmedss61@gmail.com","abanoub@gmail.com","see this product its nice to have"}
        };
        return data ;
    }
    @Test(dataProvider = "emailFriendData",priority = 2)
    public void GuestSendEmailToFriendWithProduct(String friendEmail,String registerEmail,String message){
        productPage product = new productPage(driver);
        product.click_on_email_friend_button();
        EmailFriend register = new EmailFriend(driver);
        register.SendEmailToFriendTOShowProduct(friendEmail, registerEmail, message);
    }
    // logout
    @Test(priority = 3 )
    public void userLogOut(){
        new MyAccountPage(driver).logOut();

    }
}
