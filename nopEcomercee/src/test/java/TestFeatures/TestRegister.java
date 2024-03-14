package TestFeatures;

import Browser.SetUp_Website;
import Data.DataDrivenByExcelForRegister;
import Page.HomePage;
import Page.LogInPage;
import Page.MyAccountPage;
import Page.RegisterPage;
import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestRegister extends SetUp_Website {

    SoftAssert Soft = new SoftAssert();
    @DataProvider
   private Object[][] registerData(){
       var data = new Object [][]  {
               {"Male","Ahmed","Hassan","ahmedss1@gmail.com","#Con1997","#Con1997"},
               {"Female","Omima","yassan","omasas1@gmail.com","#123456","#123456"}
       };
       return data ;
   }
   @DataProvider
   private Object[][] loginData(){
       var data = new Object [][]  {
               {"ahmedss1@gmail.com","#Con1997"}
       };
       return data ;
   }

    @DataProvider
    private Object[][] registerDataBYExcel(){
       return DataDrivenByExcelForRegister.getExcelData();
    }

    @DataProvider
    private Object[][] registerDataByFakerJava(){
        Faker faker = new Faker() ;
        faker.name().firstName();
        var data = new Object [][]  {
                {"Male",  faker.name().firstName(),faker.name().lastName(),
                        faker.internet().emailAddress(),faker.internet().password()},

                {"Female",  faker.name().firstName(),faker.name().lastName(),
                        faker.internet().emailAddress(),faker.internet().password()}
        };
        return data ;
    }

    @Test (dataProvider = "registerDataBYExcel" ,priority = 0)
    public void registerWithNewAccount
            (String male,String firstname, String lastname,String email, String password )
    {

        HomePage homePage = new HomePage(driver);
        homePage.ClickRegister();
        RegisterPage NewAccount = new RegisterPage(driver);
        NewAccount.Register(male,firstname,lastname,email,password,password);
        Soft.assertTrue(NewAccount.GetSuccessMessage().contains("Your registration completed\n"));
        homePage.ClickLogin();
        LogInPage userLogin = new LogInPage(driver);
        userLogin.LogIn(email,password);
        new MyAccountPage(driver).logOut();
    }

    @Test(priority = 1 , dataProvider = "loginData" , enabled = false)
    public void userLoginSuccessfully(String email,String pass){
        HomePage homePage = new HomePage(driver);
        homePage.ClickLogin();
        LogInPage userLogin = new LogInPage(driver);
        userLogin.LogIn(email,pass);
        MyAccountPage account = new MyAccountPage(driver);
        Soft.assertTrue(account.findLogoutElement().isDisplayed());
    }

    @Test(priority = 2 ,enabled = false)
    public void userLogOut(){
        new MyAccountPage(driver).logOut();
    }
}
