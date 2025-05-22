import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WindowsTest {
    WebDriver driver;

    @Test

    public void windowsTest (){
        openBrowser();
        chooseMenu();
        chooseSubMenu();
        interractWithNewTab();
        interractWithNewWindow();
        interractWithNewWindowsMessage();
        closeBrowser();

    }

    public void openBrowser() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
    }

    //    facem o metoda care alege un meniu
    public void chooseMenu() {
        //      Identific meniul dorit si fac click pe el
        WebElement alertsFrameAndWindowsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']")); // am identificat meniul dorit folosind XPath
//      Fac un scroll (pentru ca din cauza reclamelor nu se vede butonul 'Forms')
        scrollToElement(alertsFrameAndWindowsMenu);
//      Acum fac click pe meniu
        alertsFrameAndWindowsMenu.click();
    }

//    facem o metoda care sa faca scroll

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

//    facem o metoda care sa selecteze sub-meniul

    public void chooseSubMenu() {
        WebElement alertsSubMeniu = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        alertsSubMeniu.click();
    }

    public void interractWithNewTab(){
        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        newTabButton.click();
        List<String> windowsList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowsList.get(1));
        WebElement tabTextValue = driver.findElement(By.id("sampleHeading"));
        String expectedText = "This is a sample page";
        Assert.assertEquals(tabTextValue.getText(),expectedText, "Test is not displayed properly!" );
        driver.close();
        driver.switchTo().window(windowsList.get(0));
    }

    public void interractWithNewWindow(){
        WebElement newWindowButton = driver.findElement(By.id("windowButton"));
        newWindowButton.click();
        List<String> windowsList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowsList.get(1));
        WebElement windowTextValue = driver.findElement(By.id("sampleHeading"));
        String expectedText = "This is a sample page";
        Assert.assertEquals(windowTextValue.getText(),expectedText, "Test is not displayed properly!" );
        driver.close();
        driver.switchTo().window(windowsList.get(0));
    }

    public void interractWithNewWindowsMessage(){
        WebElement newWindowsMessageButton = driver.findElement(By.id("messageWindowButton"));
        newWindowsMessageButton.click();
        List<String> windowsList = new ArrayList<>(driver.getWindowHandles());
        if (windowsList.size() > 1){
            System.out.println("A new window is successfully opened");
        }
        else {
            System.out.println("New window can`t be opened.");
        }
        driver.switchTo().window(windowsList.get(1));
        driver.close();
    }

    public void closeBrowser(){
        driver.quit();
    }
}
