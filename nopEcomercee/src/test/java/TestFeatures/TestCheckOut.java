package TestFeatures;

import Browser.SetUp_Website;
import Page.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCheckOut extends SetUp_Website {

    @DataProvider
    private Object[][] guestCheckoutData(){
        var data = new Object [][]  {
                {"Ahmed","Hassan","ahmedss1@gmail.com","Egypt","luxor","alalldin.street","205","01223045698"}
        };
        return data ;
    }

    //search for product and select it
    String product = "Samsung Series 9 NP900X4C Premium Ultrabook" ;
    SoftAssert soft = new SoftAssert();
    String productShortSpell = "mac" ;
    @Test(priority = 0)
    public void SearchOnProduct(){
        SearchPage search = new SearchPage(driver) ;
        search.searchOnSpecificItem(product);
        search.clickOnSearchButton();
        soft.assertTrue(search.getSearchedProductDetails().equalsIgnoreCase(product));
        search.clickOnSpecificProduct();
    }

    // add to cart

    String quantity = "3";
    //add to cart , edit quantity and update cart
    @Test(priority = 1)
    public void RegisterAddProductToCartAndCheckoutTheProduct(){
        productPage product = new productPage(driver);
        product.click_on_Add_To_Cart_Button();
        product.click_on_Add_To_Link();
        ShoppingCart cart = new ShoppingCart(driver);
        cart.editQuantity(quantity);
        cart.clickUpdateShopCartButton();
        soft.assertEquals(cart.getQuantity(),quantity);
        soft.assertAll();
        cart.makeCheckOutOFProducts();
    }

    String successCheckOutMessage = "Your order has been successfully processed!";

    // check out the order as Guest
     @Test(priority = 2 ,dataProvider = "guestCheckoutData")
    public void GuestMakeACheckOutForProduct(String fname, String lname, String Email, String Country, String City, String address_1, String zip, String phone)
     {
         LogInPage Guest = new LogInPage(driver);
         Guest.clickOnCheckOutAsGuest();
         CheckOutPage guest = new CheckOutPage(driver);
         guest.fillBillingAddressWithMandatoryFields(fname,lname,Email,Country,City,address_1,zip,phone);
         soft.assertTrue(guest.getOrderCompleteMessage().contains(successCheckOutMessage));
     }

}
