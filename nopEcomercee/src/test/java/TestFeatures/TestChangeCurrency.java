package TestFeatures;

import Browser.SetUp_Website;
import Page.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestChangeCurrency extends SetUp_Website {
    SoftAssert Soft = new SoftAssert();
    String currencyEuro = "Euro";
    String currencyDollar = "US Dollar";
    String euroCurrencyCode = "€";
    String dollarCurrencyCode = "$";

    @Test
    public void RegisterChangeCurrency(){
        HomePage register = new HomePage(driver) ;
        register.choiceCurrencyOfProduct(currencyEuro);
        for(WebElement productPrice : register.FindAllProductsPrices())
            Soft.assertTrue(productPrice.getText().contains(euroCurrencyCode));
        register.choiceCurrencyOfProduct(currencyDollar);
        for(WebElement productPrice : register.FindAllProductsPrices())
            Soft.assertTrue(productPrice.getText().contains(dollarCurrencyCode));
    }
}
