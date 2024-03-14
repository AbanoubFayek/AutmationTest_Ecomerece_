package TestFeatures;

import Browser.SetUp_Website;
import Page.CompareList;
import Page.SearchPage;
import Page.productPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCompareProducts extends SetUp_Website {

    // search for product
    String NotificationOfProductAddedToCompareList = "The product has been added to your" ;
    String product = "Samsung Series 9 NP900X4C Premium Ultrabook" ;
    String product2 = "Asus N551JK-XO076H Laptop";
    int productCompareNumber = 2 ;
    SoftAssert soft = new SoftAssert();
    @Test
    public void SearchOnProduct(){
        // search for first product want to compare
        SearchPage search = new SearchPage(driver) ;
        search.searchOnSpecificItem(product);
        search.clickOnSearchButton();
        soft.assertTrue(search.getSearchedProductDetails().equalsIgnoreCase(product));
        search.clickOnSpecificProduct();
        // add product to compare list
        productPage product = new productPage(driver);
        product.click_on_Add_to_Compare_list_Button();
        // search for another product want to compare against first product
        search.searchOnSpecificItem(product2);
        search.clickOnSearchButton();
        search.clickOnSpecificProduct();
        soft.assertTrue(search.getSearchedProductDetails().equalsIgnoreCase(product2));
        // add another product to compare list
        product.click_on_Add_to_Compare_list_Button();
        product.click_on_Add_To_Link();
        CompareList compare = new CompareList(driver);
        System.out.println(compare.getNumberOfCompareProducts());
        soft.assertEquals(compare.getNumberOfCompareProducts(),productCompareNumber);
        compare.clickOnClearList();
    }




}
