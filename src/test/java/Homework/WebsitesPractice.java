package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class WebsitesPractice {
//    Tema: initializare browser, gasit un element sau doua, facut o actiune (sendkeys , click ...)

    WebDriver driver;

    @Test

    public void practiceTheInternetHero (){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

       WebElement TestControl = driver.findElement(By.xpath("//*[@id='content']/ul/li[1]/a"));
       TestControl.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

       driver.navigate().back();

        WebElement AddRemoveElements = driver.findElement(By.xpath("//*[@id='content']/ul/li[2]/a"));
        AddRemoveElements.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        WebElement AddElement = driver.findElement(By.xpath("//*[@id='content']/div/button"));
        AddElement.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        WebElement Delete = driver.findElement(By.xpath("//button[@class='added-manually']"));
        Delete.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        driver.navigate().back();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        WebElement BasicAuthentification = driver.findElement(By.xpath("//a[normalize-space()='Basic Auth']"));
        BasicAuthentification.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }


        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        WebElement successMessage = driver.findElement(By.cssSelector("p"));
        System.out.println("Rezultat: " + successMessage.getText());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        driver.navigate().back();
        driver.navigate().back();


    }
}
