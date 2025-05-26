package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.CommonPage;
import pages.HomePage;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class AlertsTest extends BaseTests{


    @Test

    public void AlertsTest(){
        HomePage homePage = new HomePage(driver);
        homePage.isPageLoaded();
        homePage.chooseMenu();
        CommonPage commonPage = new CommonPage(driver);
        commonPage.isPageLoaded();
        commonPage.chooseSubMenu();
        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.isPageLoaded();
        alertsPage.interactWithFirstAlert();
        alertsPage.interactWithTimerAlert();
        alertsPage.interactWithConfirmAlert("Ok");
        alertsPage.interactWithPromptBox("Calin");

    }




//    facem o metoda care sa faca scroll



//    facem o metoda care sa selecteze sub-meniul


//    facem o metoda care sa interactioneze cu prima alerta
//    public void interractWithFirstAlert (){
//        WebElement firstAlertButton = driver.findElement(By.id("alertButton"));
//        firstAlertButton.click();
//        Alert firstAlert = driver.switchTo().alert();
//        firstAlert.accept();
//    }

//    public void interractWithTimerAlert(){
//        WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));
//        timerAlertButton.click();
//      Inainte sa schimbam focusul pe alerta trebuie sa punem un wait explicit
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
//        wait.until(ExpectedConditions.alertIsPresent());
//        Alert timerAlert = driver.switchTo().alert();
//        timerAlert.accept();
//    }

//    public void interractWithConfirmAlert(String alertValue) {
//        WebElement confirmAlertButton = driver.findElement(By.id("confirmButton"));
//        confirmAlertButton.click();
//        Alert confirmAlert = driver.switchTo().alert();
//        if (alertValue.equals("Ok")) {
//            confirmAlert.accept();
//            WebElement alertResultText = driver.findElement(By.id("confirmResult"));
//            assertTrue(alertResultText.getText().contains(alertValue), "You didn`t select OK. You selected: " + alertResultText.getText());
//        }
//        if (alertValue.equals("Cancel")) {
//            confirmAlert.dismiss();
//            WebElement alertResultText = driver.findElement(By.id("confirmResult"));
//            assertTrue(alertResultText.getText().contains("Cancel"), "You didn`t select cancel. You selected: " + alertResultText.getText());
//
//        }
//        faceti ultima alerta pe miercuri
//    }
//    public void interractWithPromptButtonAllert(String alertValue) {
//        WebElement promptButton = driver.findElement(By.id("promtButton"));
//        promptButton.click();
//        Alert promptAlert = driver.switchTo().alert();
//        promptAlert.sendKeys(alertValue);
//        promptAlert.accept();
//        WebElement resultText = driver.findElement(By.id("promptResult"));
//        assertTrue(resultText.getText().contains(alertValue), "The result doesn`t containthe expected name. " + resultText.getText());
//    }
}



