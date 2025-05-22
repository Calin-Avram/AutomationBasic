import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class PracticeFormTest {
    WebDriver driver;
    @Test
    public void practiceFormTest(){

        driver = new ChromeDriver(); // aleg driveru Chrome pentru a naviga
        driver.get("https://demoqa.com/"); // navighez catre pagina website-ului
        driver.manage().window().maximize(); // maximizez fereastra de navigare
//      Identific meniul dorit si fac click pe el
        WebElement FormMeniu = driver.findElement(By.xpath("//h5[text()='Forms']")); // am identificat meniul dorit folosind XPath
//      Fac un scroll (pentru ca din cauza reclamelor nu se vede butonul 'Forms')
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", FormMeniu);
//      Acum fac click pe meniu
        FormMeniu.click();
//      Identific sub-Meniul dorit si fac click pe el
        WebElement PracticeFormSubMeniu = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        PracticeFormSubMeniu.click();
//      Identific elementele din formular si fac actiuni corespunzatoare pe fiecare:
//      In elementul "First Name" introduc textul "Avram"
        WebElement firstNameField = driver.findElement(By.id("firstName"));
//      Am creat variabile la datele introduse pentru a le folosi in Hashmap mai jos (desi in comenturi scrie altceva, initial am introdus text si apoi am modificat
//      pentru a fi mai usor in crearea Hashmap-ului)!!!
        String firstNameText = "Avram";
        firstNameField.sendKeys(firstNameText);
//      In elementul "Last Name introduc textul "Calin"
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        String lastNameText = "Calin";
        lastNameField.sendKeys(lastNameText);
//      In elementul "Email Field" introduc adresa de e-mail "Calin@example.com" , dupa care execut un scroll de 250 pixeli pe pagina
        WebElement emailField = driver.findElement(By.id("userEmail"));
        String emailText = "Calin@example.com";
        emailField.sendKeys(emailText);
        js.executeScript("window.scrollBy(0,250)");
//      Alex sexul persoanei facand click(bifand) pe optiunea "Male" (partea 2: creez o lista cu toate sexele posibile si dau un string value
//      la cel potrivit[ales])
        WebElement genderMale = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement genderFemale = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement genderOther = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
        String genderValueText = "Male";
        List<WebElement> genderList = List.of(genderMale , genderFemale , genderOther);
        for (int i =0; i < genderList.size(); i++){
            if (genderList.get(i).getText().equals(genderValueText)){
                genderList.get(i).click();
                break;
            }
        }
       // genderMale.click();
//      Introduc numar de telefon in casuta corespunzatoare
        WebElement mobilePhoneField = driver.findElement(By.id("userNumber"));
        String mobilePhoneText = "0775432444";
        mobilePhoneField.sendKeys(mobilePhoneText);
//      Deschid fereastra cu zilele, lunile si anul, pentru a alege ziua de nastere
        WebElement dateOfBirthInput = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirthInput.click();
//      Fac un scroll de 500 pixeli pe pagina
        js.executeScript("window.scrollBy(0,500)");
//      Aleg luna care contine textul "April"
        WebElement monthOfBirthElement = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
        Select selectMonth = new Select(monthOfBirthElement);
        String monthValueText = "April";
        selectMonth.selectByContainsVisibleText(monthValueText);
//      Aleg anul nasterii care contine textul "2022"
        WebElement yearOfBirthElement = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
        Select selectYear = new Select(yearOfBirthElement);
        String yearValueText = "2022";
        selectYear.selectByVisibleText(yearValueText);
//      Aleg ziua nasterii "14" dintr-o lista de zile posibile
        List<WebElement> dayOfBirthList = driver.findElements(By.xpath("//div[contains(@class,'react-datepicker__day')]"));
        String dayValueText = "14";
        for (int i=0; i<dayOfBirthList.size(); i++){
            if (dayOfBirthList.get(i).getText().equals(dayValueText)){
                dayOfBirthList.get(i).click();
                break;
            }
        }
//      Aleg subiectele de studiat din lista
        WebElement subjectInputElement = driver.findElement(By.id("subjectsInput"));
        String mathSubjectText = "Maths";
        subjectInputElement.sendKeys(mathSubjectText);
        subjectInputElement.sendKeys(Keys.ENTER);
        String physicsSubjectText = "Physics";
        subjectInputElement.sendKeys(physicsSubjectText);
        subjectInputElement.sendKeys(Keys.ENTER);
//      Bifez toate hobby-urile disponibile
        WebElement sportHobbyElement = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));
        WebElement readingHobbyElement = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']"));
        WebElement musicHobbyElement = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']"));
        List<WebElement> hobbiesList = List.of(sportHobbyElement , readingHobbyElement , musicHobbyElement);
        String sportHobbyText = "Sports";
        String readingHobbyText = "Reading";
        String musicHobbyText = "Music";
        List<String> hobbiesValueTextList = List.of(sportHobbyText , readingHobbyText , musicHobbyText);
        for (String hobby: hobbiesValueTextList){
            for (int i =0; i < hobbiesList.size(); i++){
                if (hobbiesList.get(i).getText().equals(hobby)){
                    hobbiesList.get(i).click();
                    break;
                }
            }

        }

//      Mai fac un scroll pe pagina, de 200 pixeli
        js.executeScript("window.scrollBy(0,200)");
//      Aici am facut eu in fata si am gasit un alt element pt upload decat cel folosit cu colegii
//        WebElement pictureSelectElement = driver.findElement(By.xpath("//*[@id='userForm']/div[8]/div[2]/div/label"));
//        pictureSelectElement.click();

//      Uploadez o poza, un fisier pe site, care l-am downloadat si am dat un filepath
        WebElement uploadFileElement = driver.findElement(By.id("uploadPicture"));
        String pictureFileText = "CAT.jpg";
        String pictureFilePath="src/test/resources/pictures/" + pictureFileText;
        File file = new File(pictureFilePath);
        uploadFileElement.sendKeys(file.getAbsolutePath());
//      Identific elementul "Address Field" de pe pagina , dau click pe el si introduc textul "Targu Mures"
        WebElement addressField = driver.findElement(By.id("currentAddress"));
        String addressText = "Targu Mures";
        addressField.click();
        addressField.sendKeys(addressText);
//      Aleg tara - statul din lista disponibila prin tastarea textului "NCR" si apoi apas tasta Enter
        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
        String stateValueText = "NCR";
        stateInputElement.sendKeys(stateValueText);
        stateInputElement.sendKeys(Keys.ENTER);
//      Aleg orasul din lista disponibila prin tastarea textului "Delhi" si apoi apas tasta Enter
        WebElement cityInputElement = driver.findElement(By.id("react-select-4-input"));
        String cityTextValue = "Delhi";
        cityInputElement.sendKeys(cityTextValue);
        cityInputElement.sendKeys(Keys.ENTER);
//      Apas butonul Submit
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

//      Validez tabelul cu datele de intrare folosite

//      Fac un hashmap cu expected values
        HashMap<String, String> expectedValues = new HashMap<>();
        expectedValues.put("Student Name" , firstNameText + " " + lastNameText);
        expectedValues.put("Student Email" , emailText);
        expectedValues.put("Gender" , genderValueText);
        expectedValues.put("Mobile" , mobilePhoneText);
        expectedValues.put("Date of Birth" , dayValueText + " " + monthValueText + "," + yearValueText );
        expectedValues.put("Subjects" ,mathSubjectText +", " + physicsSubjectText );
        expectedValues.put("Hobbies" , sportHobbyText + ", " + readingHobbyText + ", " + musicHobbyText);
        expectedValues.put("Picture" , pictureFileText);
        expectedValues.put("Address" , addressText);
        expectedValues.put("State and City" , stateValueText + " " + cityTextValue);

//      Fac un hashmap cu valorile actuale
//      Declar listele cu valorile actuale din tabel
        List<WebElement> submitTableKeys = driver.findElements(By.xpath("//tbody//td[1]"));
        List<WebElement> submitTableValues = driver.findElements(By.xpath("//tbody//td[2]"));
        HashMap<String , String> actualValues = new HashMap<>();
        for (int i = 0; i < submitTableKeys.size(); i++){
            actualValues.put(submitTableKeys.get(i).getText() , submitTableValues.get(i).getText());
        }

//      Assert-ul este validare ca un anumit obiect este egal cu altul sau ca valorile dintre anumite obiecte sunt egale, sau ca un element exista
        Assert.assertEquals(actualValues , expectedValues , "Actual Values: " + actualValues + " are not the same with the expected values: " + expectedValues);

    }
}
