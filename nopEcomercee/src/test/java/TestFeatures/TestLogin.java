package TestFeatures;
import Browser.SetUp_Website;
import Data.DataDrivenByExcelForLogin;
import Page.HomePage;
import Page.LogInPage;
import Page.MyAccountPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestLogin extends SetUp_Website {

    @DataProvider
    private Object[][] loginData(){
        var data = new Object [][]  {
                {"ahmeds@gmail.com","#Con1997"}
        };
        return data ;
    }
    SoftAssert Soft = new SoftAssert();

    @DataProvider
    private Object[][] loginDataByExcel(){
        return DataDrivenByExcelForLogin.getExcelData() ;
    }

    @Test(dataProvider = "loginDataByExcel")
    public void UserLoginSuccessfully(String email,String pass){
        HomePage user = new HomePage(driver);
        user.ClickLogin();
        LogInPage userLogin = new LogInPage(driver);
        userLogin.LogIn(email, pass);
        MyAccountPage account = new MyAccountPage(driver);
        Soft.assertTrue(account.findLogoutElement().isDisplayed());
        account.logOut();
    }


    @Test(dataProvider = "loginData")
    public void UserLoginUnSuccessfully(String email,String pass){
        HomePage user = new HomePage(driver);
        user.ClickLogin();
        LogInPage userLogin = new LogInPage(driver);
        userLogin.LogIn(email, pass);
        Soft.assertTrue(userLogin.GetMessageOfUnSuccessLogin().equalsIgnoreCase("No customer account found"));
    }


}
