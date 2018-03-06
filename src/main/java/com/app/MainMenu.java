package com.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

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

        for(WebElement x : elements)
        {
            Thread.sleep(1000);
            x.click();
            Thread.sleep(1000);
            String a=x.getText();
            System.out.println(a);
            Thread.sleep(1000);
            driver.navigate().refresh();Thread.sleep(1000);
            Thread.sleep(1000);
            String b=x.getText();
            Thread.sleep(1000);
            if(a.equals(b))
            {
                Thread.sleep(1000);
                System.out.println("ok");}
            Thread.sleep(1000);
        }



    }

    public static WebDriver myChromeDriver(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/drivers/chromedriver.exe");
        return new ChromeDriver();}
}



