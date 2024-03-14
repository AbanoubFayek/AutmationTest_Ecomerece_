package Browser;

import Page.HomePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
public class SetUp_Website {

    protected WebDriver  driver = new ChromeDriver();
    final private String Website = "https://demo.nopcommerce.com/" ;

    @BeforeClass
    public void GetWebsite(){
        driver.get(Website);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)) ;
    }

    @AfterClass
    public void ExitChrome(){
        driver.quit();
    }
}
