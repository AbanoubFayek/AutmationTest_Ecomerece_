package utilities;

import Browser.SetUp_Website;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

import java.io.File;
import java.io.IOException;

public class FailureTestsRecords extends SetUp_Website {
     WebDriver driver ;

     @AfterClass
     public void recordFailureTest(ITestResult result){
          if(result.getStatus() == ITestResult.FAILURE) {
               File shots = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;
               try {
                    FileHandler.copy(shots,new File("C:\\Users\\a.fayek\\IdeaProjects\\nopEcomercee"+result.getName()+".png"));
               } catch (IOException e) {
                    throw new RuntimeException(e);
               }
          }
     }
}


