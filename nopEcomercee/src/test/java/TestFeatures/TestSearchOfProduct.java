package TestFeatures;
import Browser.SetUp_Website;
import Page.SearchPage;
import Page.productPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestSearchOfProduct extends SetUp_Website {
    String product = "Samsung Series 9 NP900X4C Premium Ultrabook" ;
    SoftAssert soft = new SoftAssert();
    String productShortSpell = "mac" ;
    @Test
    public void SearchOnProduct(){
        SearchPage search = new SearchPage(driver) ;
        search.searchOnSpecificItem(product);
        search.clickOnSearchButton();
        soft.assertTrue(search.getSearchedProductDetails().equalsIgnoreCase(product));
    }
    @Test
    public void SearchWithAutoComplete(){
        SearchPage search = new SearchPage(driver) ;
        search.searchOnSpecificItem(productShortSpell);
        search.SelectItemFormList();
        productPage product = new productPage(driver);
        soft.assertTrue(product.getProductName().contains(productShortSpell));
    }

}
