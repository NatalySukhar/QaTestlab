package com.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Login {
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
        WebElement avatarLink=driver.findElement(By.id("header_employee_box"))   ;
        avatarLink.click();
        WebElement exitButton=driver.findElement(By.id("header_logout"));
        exitButton.click();
        driver.quit();

    }

    public static WebDriver myChromeDriver(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/drivers/chromedriver.exe");
        return new ChromeDriver();}
}
