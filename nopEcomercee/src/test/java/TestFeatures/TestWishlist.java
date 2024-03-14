package TestFeatures;

import Browser.SetUp_Website;
import Page.SearchPage;
import Page.WishlistPage;
import Page.productPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestWishlist extends SetUp_Website {
    SoftAssert soft = new SoftAssert();
    String emptyWishlist = "The wishlist is empty!";
    String productShortSpell = "mac" ;

     // search for a product
     @Test
    public void SearchWithAutoComplete(){
    SearchPage search = new SearchPage(driver) ;
    search.searchOnSpecificItem(productShortSpell);
    search.SelectItemFormList();
    productPage product = new productPage(driver);
    soft.assertTrue(product.getProductName().contains(productShortSpell));
    }
    @Test
    public void registerAddProductToWishList(){
        // add product to wishlist
        productPage product = new productPage(driver);
        String productName = product.getProductName();
        product.click_on_Add_To_Wishlist_Button();
        product.click_on_Add_To_Link();
        WishlistPage wishlist = new WishlistPage(driver);
        soft.assertTrue(wishlist.getProductName().equalsIgnoreCase(productName));
        wishlist.clickOnRemoveButton();
        soft.assertEquals(wishlist.getMessageOfEmptypage(),(emptyWishlist));
    }

}
