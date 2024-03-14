package TestFeatures;

import Browser.SetUp_Website;
import Page.SearchPage;
import Page.ShoppingCart;
import Page.productPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestShoppingCart extends SetUp_Website {
    String productShortSpell = "asu" ;
    SoftAssert soft = new SoftAssert();
    String emptyPage = "is empty!";

    // search for product
    @Test(priority = 0)
    public void SearchWithAutoComplete(){
        SearchPage search = new SearchPage(driver) ;
        search.searchOnSpecificItem(productShortSpell);
        search.SelectItemFormList();
        productPage product = new productPage(driver);
        soft.assertTrue(product.getProductName().contains(productShortSpell));
        search.clickOnSpecificProduct();
    }
     String quantity = "3";
    //add to cart , edit quantity and update cart
    @Test(priority = 1)
    public void RegisterAddProductToCartAndRemoveIt(){
        productPage product = new productPage(driver);
        product.click_on_Add_To_Cart_Button();
        product.click_on_Add_To_Link();
        ShoppingCart cart = new ShoppingCart(driver);
        cart.editQuantity(quantity);
        cart.clickUpdateShopCartButton();
        soft.assertEquals(cart.getQuantity(),quantity);
        cart.clickOnRemoveButton();
        soft.assertTrue(cart.getMessageOfEmptypage().contains(emptyPage));
        soft.assertAll();
    }
}
