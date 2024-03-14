package org.example;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class Main {

    public static void main(String[]args) {
        WebDriver driver = new ChromeDriver();
        String n = "notebooks";
        String Website = "https://demo.nopcommerce.com/";
        driver.get(Website);
        WebElement productType = driver.findElement(By.linkText("Computers"));
        WebElement subType = driver.findElement(By.cssSelector(".sublist.first-level a[href=\"/"+n+"\"]"));

    //  WebElement subType = driver.findElement(By.linkText("Desktops"));
        System.out.println(productType);
        System.out.println(subType);
        //WebElement subType = driver.findElement(By.cssSelector(".sublist.first-level a[href=\"/notebooks\"]"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(productType).
//                moveToElement((subType)).
//                click().
//                build().
//                perform();
        //select from specific device from menu type selected


    }}

