package TestFeatures;

import Browser.SetUp_Website;
import Page.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestMenuHover extends SetUp_Website {
    SoftAssert soft = new SoftAssert() ;
    @DataProvider
    public Object[][] menuData(){
        Object[][] data = new Object[][]{
                {"Computers","desktops"}
        };
        return data ;
    }

    @Test(dataProvider = "menuData")
    public void registerCouldHoverMenu(String mainType,String subType){
        HomePage register = new HomePage(driver);
        register.choiceFromTopMenu(mainType,subType);
        soft.assertTrue(register.getProductTitle().equalsIgnoreCase(subType));
    }
}
