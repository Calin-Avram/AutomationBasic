package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.FramesPage;
import pages.HomePage;

public class FramesTest extends BaseTest {
//    WebDriver driver;
    @Test
    public void framesTest(){
//        openBrowser();
        HomePage homePage = new HomePage(driver);
        homePage.isPageLoaded();
        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        CommonPage commonPage = new CommonPage(driver);
        commonPage.isPageLoaded();
        commonPage.goToDesiredSubMenu("Frames");
        FramesPage framesPage = new FramesPage(driver);
        framesPage.interactWithFrameOne();
        framesPage.interactWithFrameTwo();
    }

//    public void openBrowser() {
//        driver = new ChromeDriver();
//        driver.get("https://demoqa.com/");
//        driver.manage().window().maximize();
//    }

    //    facem o metoda care alege un meniu
//    public void chooseMenu() {
//        //      Identific meniul dorit si fac click pe el
//        WebElement alertsFrameAndWindowsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']")); // am identificat meniul dorit folosind XPath
////      Fac un scroll (pentru ca din cauza reclamelor nu se vede butonul 'Forms')
//        scrollToElement(alertsFrameAndWindowsMenu);
////      Acum fac click pe meniu
//        alertsFrameAndWindowsMenu.click();
//    }

//    facem o metoda care sa faca scroll

//    public void scrollToElement(WebElement element) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", element);
//    }

//    facem o metoda care sa selecteze sub-meniul

//    public void chooseSubMenu() {
//        WebElement framesSubMeniu = driver.findElement(By.xpath("//span[text()='Frames']"));
//        framesSubMeniu.click();
//    }
//    public void closeBrowser(){
//        driver.quit();
//    }

//    public void interractWithFrameOne(){
//        WebElement frameOneElement = driver.findElement(By.id("frame1"));
//        driver.switchTo().frame(frameOneElement);
//        WebElement frameOneTextValue = driver.findElement(By.id("sampleHeading"));
//        String expectedText = "This is a sample page";
//        Assert.assertEquals(frameOneTextValue.getText(),expectedText, "Test is not displayed properly!" );
//        System.out.println("Frame one text is: " + frameOneTextValue.getText());
//        driver.switchTo().defaultContent();
//    }
//
//
//    public void interractWithFrameTwo(){
//        WebElement frameTwoElement = driver.findElement(By.id("frame2"));
//        driver.switchTo().frame(frameTwoElement);
//        WebElement frameTwoTextValue = driver.findElement(By.id("sampleHeading"));
//        String expectedText = "This is a sample page";
//        Assert.assertEquals(frameTwoTextValue.getText(),expectedText, "Test is not displayed properly!" );
//        System.out.println("Frame two text is: " + frameTwoTextValue.getText());
//        driver.switchTo().defaultContent();
//    }

}
