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
        okInput.submit(); Thread.sleep(1000);
        driver.navigate().to(" http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/index.php?controller=AdminDashboard&token=f57b9e0913a4757c6ba02314cf473896");
        Thread.sleep(1000);

        By locator=By.className("maintab");
        List<WebElement> elements =driver.findElements(locator);
        ArrayList<String> locators=new ArrayList<String>();
       for(WebElement x : elements)
        {
            locators.add(x.getText());}
            for (String x: locators){

            WebElement menu= driver.findElement(By.linkText(x));
            menu.click();
                System.out.println(x);
                driver.navigate().refresh();
                WebElement menuNew= driver.findElement(By.linkText(x));
                if(menuNew.isEnabled())
                {
                    Thread.sleep(1000);
                    System.out.println("Refresh is OK");}
                Thread.sleep(1000);
       }






    }

    public static WebDriver myChromeDriver(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/drivers/chromedriver.exe");
        return new ChromeDriver();}
}



