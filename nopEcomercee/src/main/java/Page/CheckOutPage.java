package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage extends BasePage{
    private WebDriver driver ;
    public CheckOutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /***
     * Billing address selectors
     */
    private By firstname = By.id("BillingNewAddress_FirstName");
    private By lastname = By.id("BillingNewAddress_LastName");
    private By email = By.id("BillingNewAddress_Email");
    private By country = By.id("BillingNewAddress_CountryId");
    private By city =By.id("BillingNewAddress_City");
    private By address1 =By.id("BillingNewAddress_Address1");
    private By postalCode =By.id("BillingNewAddress_ZipPostalCode");
    private By phoneNumber =By.id("BillingNewAddress_PhoneNumber");
    private By continueButtonOfBillingAddress =By.xpath("//div[@id=\"billing-buttons-container\"]/button[text()=\"Continue\"]");

    /**
     * Shipping method selectors
     */
    private By nextDayAirRadioButton = By.id("shippingoption_1") ;
    private By continueButtonOfShippingMethod = By.xpath("//div[@id=\"shipping-method-buttons-container\"]/button[text()=\"Continue\"]");

    /***
     * payment Information selectors
     */
    private By creditCardRadioButton = By.id("paymentmethod_1");
    private By chequeRadioButton = By.id("paymentmethod_0");

    /**
     * when using credit card method
     */
    private By selectCreditCard = By.id("CreditCardType");
    private By cardholderName = By.id("CardholderName");
    private By cardNumber = By.id("CardNumber");
    private By expirationDateMonth = By.id("ExpireMonth");
    private By expirationDateYear = By.id("ExpireYear");
    private By cardCode = By.cssSelector("input[name=\"CardCode\"]");

    /**
     * when using pay by cheque or money order
     */
     private By continueButtonAfterSelectChequeMethod = By.xpath("//div[@id=\"payment-method-buttons-container\"]/button[text()=\"Continue\"]");
    private By continueButtonToConfirmChequeMethod = By.xpath("//div[@id=\"payment-info-buttons-container\"]/button[text()=\"Continue\"]");


    /**
     * confirm order locators
     */
    private By confirmCheckoutButton = By.xpath("//div[@id=\"confirm-order-buttons-container\"]/button[text()=\"Confirm\"]");
    /**
     * message of success processed for checkout locators
     */
      private By orderCompleteMessage = By.cssSelector(".section.order-completed > .title");


    public void fillBillingAddressWithMandatoryFields(String fname , String lname , String Email ,String Country ,String City
    , String address_1 , String zip , String phone ){
        SetTextTOElement(firstname,fname);
        SetTextTOElement(lastname,lname);
        SetTextTOElement(email,Email);
        selectElement(country,Country);
        SetTextTOElement(city,City);
        SetTextTOElement(address1,address_1);
        SetTextTOElement(postalCode,zip);
        SetTextTOElement(phoneNumber,phone);
        ClickElement(continueButtonOfBillingAddress);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(nextDayAirRadioButton));
        ClickElement(nextDayAirRadioButton);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(continueButtonOfShippingMethod));
        ClickElement(continueButtonOfShippingMethod);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(continueButtonAfterSelectChequeMethod));
        ClickElement(continueButtonAfterSelectChequeMethod);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(continueButtonToConfirmChequeMethod));
        ClickElement(continueButtonToConfirmChequeMethod);
        scrollDownByCertainAmount();
        ClickElement(confirmCheckoutButton);
    }

  public String getOrderCompleteMessage(){
        return driver.findElement(orderCompleteMessage).getText();
  }

}
