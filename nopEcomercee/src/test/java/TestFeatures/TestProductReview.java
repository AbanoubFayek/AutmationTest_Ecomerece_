package TestFeatures;

import Browser.SetUp_Website;
import Page.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestProductReview extends SetUp_Website {
    SoftAssert soft = new SoftAssert();
    String productShortSpell = "mac" ;
    String productReviewSuccessMessage = "Product review is successfully added.\n";
    @DataProvider
    private Object[][] registerData(){
        var data = new Object [][]  {
                {"Male","Ahmed","Hassan","ahmed1k78@gmail.com","#Con1997","#Con1997"}
        };
        return data ;
    }
    @DataProvider
    private Object[][] reviewData(){
        var data = new Object [][]  {
                {"good to have really ","I wanna say that its a good product to use",3}
        };
        return data ;
    }
    @DataProvider
    private Object[][] loginData(){
        var data = new Object [][]  {
                {"ahmed1k78@gmail.com","#Con1997"}
        };
        return data ;
    }

    // need to be registered
    @Test(dataProvider = "registerData",priority = 0 )
    public void registerWithNewAccount
    (String male,String firstname, String lastname,String email, String password,String confirmPass )
    {
        HomePage homePage = new HomePage(driver);
        homePage.ClickRegister();
        RegisterPage NewAccount = new RegisterPage(driver);
        NewAccount.Register(male,firstname,lastname,email,password,confirmPass);
        soft.assertTrue(NewAccount.GetSuccessMessage().contains("Your registration completed\n"));
    }
    // log-in
    @Test(dataProvider = "loginData", priority = 1)
    public void LoginSuccessfully(String email,String pass){
        HomePage home = new HomePage(driver);
        home.ClickLogin();
        LogInPage userLogin = new LogInPage(driver);
        userLogin.LogIn(email, pass);
    }
    //search for product
    @Test (priority = 2)
    public void SearchWithAutoComplete(){
        SearchPage search = new SearchPage(driver) ;
        search.searchOnSpecificItem(productShortSpell);
        search.SelectItemFormList();
        productPage product = new productPage(driver);
        soft.assertTrue(product.getProductName().contains(productShortSpell));

    }
    //review a product => rate a product begins with 1 to 5
     @Test(dataProvider = "reviewData" ,priority = 3)
    public void RegisterCouldReviewProduct(String reviewTitle, String reviewText , int rate){
         productPage product = new productPage(driver);
         product.click_on_Add_Your_Review_link();
         ProductReviewsPage register = new ProductReviewsPage(driver);
         register.GiveAReviewOfProduct(reviewTitle,reviewText,rate);
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
         soft.assertEquals(product.getSuccessMessage(),productReviewSuccessMessage);
     }

    // log out
   // @Test(priority = 4 )
    public void userLogOut(){
        new MyAccountPage(driver).logOut();
    }
}
