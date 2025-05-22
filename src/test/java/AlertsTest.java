import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class AlertsTest {

    public WebDriver driver;

    @Test

    public void AlertsTest(){
        openBrowser();
        chooseMenu();
        chooseSubMenu();
        interractWithFirstAlert();
        interractWithTimerAlert();
        interractWithConfirmAlert("Ok");
        interractWithPromptButtonAllert("Calin");

    }

    //    facem o metoda care deschide un browser
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
        WebElement alertsSubMeniu = driver.findElement(By.xpath("//span[text()='Alerts']"));
        alertsSubMeniu.click();
    }
//    facem o metoda care sa interactioneze cu prima alerta
    public void interractWithFirstAlert (){
        WebElement firstAlertButton = driver.findElement(By.id("alertButton"));
        firstAlertButton.click();
        Alert firstAlert = driver.switchTo().alert();
        firstAlert.accept();
    }

    public void interractWithTimerAlert(){
        WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));
        timerAlertButton.click();
//      Inainte sa schimbam focusul pe alerta trebuie sa punem un wait explicit
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert timerAlert = driver.switchTo().alert();
        timerAlert.accept();
    }

    public void interractWithConfirmAlert(String alertValue) {
        WebElement confirmAlertButton = driver.findElement(By.id("confirmButton"));
        confirmAlertButton.click();
        Alert confirmAlert = driver.switchTo().alert();
        if (alertValue.equals("Ok")) {
            confirmAlert.accept();
            WebElement alertResultText = driver.findElement(By.id("confirmResult"));
            assertTrue(alertResultText.getText().contains(alertValue), "You didn`t select OK. You selected: " + alertResultText.getText());
        }
        if (alertValue.equals("Cancel")) {
            confirmAlert.dismiss();
            WebElement alertResultText = driver.findElement(By.id("confirmResult"));
            assertTrue(alertResultText.getText().contains("Cancel"), "You didn`t select cancel. You selected: " + alertResultText.getText());

        }
//        faceti ultima alerta pe miercuri
    }
    public void interractWithPromptButtonAllert(String alertValue) {
        WebElement promptButton = driver.findElement(By.id("promtButton"));
        promptButton.click();
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys(alertValue);
        promptAlert.accept();
        WebElement resultText = driver.findElement(By.id("promptResult"));
        assertTrue(resultText.getText().contains(alertValue), "The result doesn`t containthe expected name. " + resultText.getText());
    }
}



