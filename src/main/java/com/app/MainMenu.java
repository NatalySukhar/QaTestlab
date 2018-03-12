package com.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class MainMenu {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= myChromeDriver();
        driver.navigate().to("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        WebElement emailInput=driver.findElement(By.name("email"));
        emailInput.sendKeys("webinar.test@gmail.com");
        WebElement passwdInput=driver.findElement(By.id("passwd"));
        passwdInput.sendKeys("Xcg7299bnSmMuRLp9ITw");
        WebElement okInput=driver.findElement(By.name("submitLogin"));
        okInput.submit();
        Thread.sleep(2000);
        By locator=By.className("maintab");
        List<WebElement> elements =driver.findElements(locator);
        ArrayList<String> locators=new ArrayList<String>();
       for(WebElement x : elements)
        {
            locators.add(x.getText());}
            for (String x: locators){

            WebElement menu= driver.findElement(By.linkText(x));
            menu.click();
            Thread.sleep(2000);
            String title= driver.findElement(By.className("breadcrumb")).getText();
            System.out.println( title);
            driver.navigate().refresh();Thread.sleep(1000);
                String titleNew= driver.findElement(By.className("breadcrumb")).getText();
                if(title.equals(titleNew))
                {

                    System.out.println("Refresh is OK");}

       }


        driver.quit();


    }

    public static WebDriver myChromeDriver(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/drivers/chromedriver.exe");
        return new ChromeDriver();}
}



