import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest {
    WebDriver driver;
    public int initialTableSize = 0;
    String firstName = "Firicel";
    String lastName = "Celentano";
    String email = "test@test.com";
    String age = "25";
    String salary = "99999999";
    String department = "Testing";

    @Test
//    facem o metoda de test in care chemam toate celelalte metode create
    public void webTableTest() {
        openBrowser();
        chooseMenu();
        chooseSubMenu();
        getTableSize();
        clickToAddNewRecord();
        fillFormValues();
        validateThatNewRecordsAreAddedProperly();
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
        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']")); // am identificat meniul dorit folosind XPath
//      Fac un scroll (pentru ca din cauza reclamelor nu se vede butonul 'Forms')
        scrollToElement(elementsMenu);
//      Acum fac click pe meniu
        elementsMenu.click();
    }

//    facem o metoda care sa faca scroll

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

//    facem o metoda care sa selecteze sub-meniul

    public void chooseSubMenu() {
        WebElement webTablesSubMeniu = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        webTablesSubMeniu.click();
    }

    //    facem o metoda care sa ia numarul initial de randuri din tabel
    public int getTableSize() {
        List<WebElement> tableRowsList = driver.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        initialTableSize = tableRowsList.size();
        System.out.println("Numarul initial de randuri in tabel este: " + initialTableSize);
        return initialTableSize;
    }

    //    facem o metoda care sa faca click pe adaugare rand nou in tabel
    public void clickToAddNewRecord() {
        WebElement addNewRecordBtn = driver.findElement(By.id("addNewRecordButton"));
        addNewRecordBtn.click();
    }

    //    facem o metoda care sa completeze toate campurile din formular
    public void fillFormValues() {
        WebElement firstNameField = driver.findElement(By.id("firstName"));
        firstNameField.sendKeys(firstName);
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        lastNameField.sendKeys(lastName);
        WebElement userEmailField = driver.findElement(By.id("userEmail"));
        userEmailField.sendKeys(email);
        WebElement ageField = driver.findElement(By.id("age"));
        ageField.sendKeys(age);
        WebElement salaryField = driver.findElement(By.id("salary"));
        salaryField.sendKeys(salary);
        WebElement departmentField = driver.findElement(By.id("department"));
        departmentField.sendKeys(department);
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
    }

    //    facem o metoda care sa valideze ca am adaugat o intrare noua in tabel si sa verifice valorile pe care le-am dat
    public void validateThatNewRecordsAreAddedProperly() {
        List<WebElement> tableRowsList = driver.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Assert.assertTrue(tableRowsList.size() > initialTableSize, "There are no new entries in the table! , Initial table size: " + initialTableSize +
                " is the same with actual table size: " + tableRowsList.size());
        String actualTableValues = tableRowsList.get(tableRowsList.size() - 1).getText();
        System.out.println("New record values are: " + actualTableValues);
        Assert.assertTrue(actualTableValues.contains(firstName), "First name value is not correct , expected firstname: " + firstName);
        Assert.assertTrue(actualTableValues.contains(lastName), "Last name value is not correct , expected last name: " + lastName);
        Assert.assertTrue(actualTableValues.contains(email), "Email value is not correct , expected email: " + email);
        Assert.assertTrue(actualTableValues.contains(age), "Age value is not correct , expected age value: " + age);
        Assert.assertTrue(actualTableValues.contains(salary), "Salary value is not correct , expected salary: " + salary);
        Assert.assertTrue(actualTableValues.contains(department), "Department value is not correct , expected department: " + department);
    }

}
//      De facut din Elements> Checkbox