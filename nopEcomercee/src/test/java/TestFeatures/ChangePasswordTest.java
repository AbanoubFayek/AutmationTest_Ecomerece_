package TestFeatures;

import Browser.SetUp_Website;
import Page.HomePage;
import Page.LogInPage;
import Page.MyAccountPage;
import Page.RegisterPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ChangePasswordTest extends SetUp_Website {
    SoftAssert Soft = new SoftAssert();
    @DataProvider
    private Object[][] registerData(){
        var data = new Object [][]  {
                {"Male","Ahmed","Hassan","ahamedsalah13@gmail.com","#Con1997","#Con1997"}
        };
        return data ;
    }
    @DataProvider
    private Object[][] ChangePasswordData(){
        var data = new Object [][]  {
                {"#Con1997","#Con19976"}
        };
        return data ;
    }
    @DataProvider
    private Object[][] loginData(){
        var data = new Object [][]  {
                {"ahamedsalah13@gmail.com","#Con1997"}
        };
        return data ;
    }

    @Test (dataProvider = "registerData" , priority = 0)
    public void registerWithNewAccount
            (String male,String firstname, String lastname,String email, String password,String confirmPass )
    {
        HomePage homePage = new HomePage(driver);
        homePage.ClickRegister();
        RegisterPage NewAccount = new RegisterPage(driver);
        NewAccount.Register(male,firstname,lastname,email,password,confirmPass);
        Soft.assertTrue(NewAccount.GetSuccessMessage().contains("Your registration completed\n"));
    }

    @Test(dataProvider = "loginData",priority = 1)
    public void LoginSuccessfully(String email,String pass){
        HomePage homePage = new HomePage(driver);
        homePage.ClickLogin();
        LogInPage userLogin = new LogInPage(driver);
        userLogin.LogIn(email, pass);
        MyAccountPage account = new MyAccountPage(driver);
        Soft.assertFalse(account.findLogoutElement().isDisplayed());

    }

     @Test(dataProvider = "ChangePasswordData" , priority = 2)
    public void changePassword(String oldPass ,String newPass ){
         LogInPage login = new LogInPage(driver) ;
         login.ClickOnMyAccount();
         MyAccountPage myAccount = new MyAccountPage(driver) ;
         myAccount.ClickOnChangePassword();
         myAccount.ChangePassword(oldPass,newPass);
         Soft.assertTrue(myAccount.getMessageSuccessPasswordChanged().contains("Password was changed"));
     }


}
