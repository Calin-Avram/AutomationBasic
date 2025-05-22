package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoQACheckBoxTestOne {
    WebDriver driver;


    @Test
    public void CheckBoxTest (){
        openBrowser();
        chooseMenu();
        chooseSubMenu();
        expandHomeFolder();
        checkAllBoxes();

    }

    public void openBrowser() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void chooseMenu() {
        //      Identific meniul dorit si fac click pe el
        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']")); // am identificat meniul dorit folosind XPath
//      Fac un scroll (pentru ca din cauza reclamelor nu se vede butonul 'Forms')
        scrollToElement(elementsMenu);
//      Acum fac click pe meniu
        elementsMenu.click();
    }

    public void chooseSubMenu() {
        WebElement webTablesSubMeniu = driver.findElement(By.xpath("//span[text()='Check Box']"));
        webTablesSubMeniu.click();
    }


    public void expandHomeFolder(){
        WebElement homeFolderExpand = driver.findElement(By.xpath("//button[@title='Toggle']//*[name()='svg']"));
        homeFolderExpand.click();
    }

    public void checkAllBoxes (){
        WebElement checkAllBox = driver.findElement(By.xpath("//*[@id='tree-node']/ol/li/span/label/span[3]"));
        checkAllBox.click();
    }

}
