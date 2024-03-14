package TestFeatures;

import Browser.SetUp_Website;
import Page.Contact_Us;
import Page.HomePage;
import com.github.javafaker.Faker;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestContactUs extends SetUp_Website {
     SoftAssert soft = new SoftAssert();
     String ExpectedMessage = "Your enquiry has been successfully sent to the store owner." ;
     @DataProvider
     private Object[][] contactUS_Data(){
        var data = new Object [][]  {
                {"Hassan","ahmedss1@gmail.com","I need to have my order as soon as possible please"}
        };
        return data ;
    }
    @DataProvider
    private Object[][] contactUS_Data2(){
     Faker faker = new Faker() ;
     String name = faker.name().fullName();
     String mail = faker.internet().emailAddress();
     String enquiry = faker.book().toString();
        return  new Object[][] {{name,mail,enquiry} };
    }


    @Test (dataProvider = "contactUS_Data2")
    @Severity(SeverityLevel.CRITICAL)
    public void Contact_us(String name , String mail , String enquiry){
        HomePage page = new HomePage(driver);
        page.ClickOnContactUs();
        Contact_Us User = new Contact_Us(driver);
        User.PutContactInformation(name, mail, enquiry);
        soft.assertEquals(User.GetSuccessMessageOfSubmitContactInformation(),ExpectedMessage);
        System.out.println(name +" " + mail + " " + enquiry );
    }




}
