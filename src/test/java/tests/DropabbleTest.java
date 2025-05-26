package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DropabbleTest extends BaseTests{
//    WebDriver driver;

    @Test
    public void dropabbleTest() {
//        openBrowser();
        chooseMenu();
        chooseSubMenu();
        pickAndDropElement();
        // closeBrowser();
    }

//    public void openBrowser() {
//        driver = new ChromeDriver();
//        driver.get("https://demoqa.com/");
//        driver.manage().window().maximize();
//    }

    //    facem o metoda care alege un meniu
    public void chooseMenu() {
        //      Identific meniul dorit si fac click pe el
        WebElement interactionsMenu = driver.findElement(By.xpath("//h5[text()='Interactions']")); // am identificat meniul dorit folosind XPath
//      Fac un scroll (pentru ca din cauza reclamelor nu se vede butonul 'Forms')
        scrollToElement(interactionsMenu);
//      Acum fac click pe meniu
        interactionsMenu.click();
    }

//    facem o metoda care sa faca scroll

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

//    facem o metoda care sa selecteze sub-meniul

    public void chooseSubMenu() {
        WebElement droppableSubMenu = driver.findElement(By.xpath("//span[text()='Droppable']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", droppableSubMenu);
        droppableSubMenu.click();
    }

//    public void pickAndDropElement(){
//        WebElement draggableElement = driver.findElement(By.id("draggable"));
//        WebElement droppableElement = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
//        String initialTargetText = droppableElement.getText();
//        Actions action = new Actions(driver);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOf(droppableElement));
//        action.dragAndDrop(draggableElement, droppableElement).release().perform();
//    }
public void pickAndDropElement(){
    WebElement draggableElement = driver.findElement(By.id("draggable"));
    WebElement droppableElement = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
    wait.until(ExpectedConditions.elementToBeClickable(droppableElement));
    String initialTargetText = droppableElement.getText();
    Actions action = new Actions(driver);
    action.dragAndDrop(draggableElement, droppableElement).release().perform();//drag de la draggableElement pana la droppableElement, lasam + perform
    Assert.assertNotEquals(droppableElement.getText(), initialTargetText, "Initial text is the same with actual text after element dropped");
    System.out.println("Initial text is: " + initialTargetText + ". Text after successful drop: " + droppableElement.getText());
}

//    public void closeBrowser() {
//        driver.quit();
//    }
}