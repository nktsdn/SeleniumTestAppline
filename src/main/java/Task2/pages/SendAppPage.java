package Task2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;


public class SendAppPage extends BasePage {


    @FindBy(id = "person_lastName")
    WebElement lastName;

    @FindBy(id = "person_firstName")
    WebElement firstName;

    @FindBy(id = "person_middleName")
    WebElement middleName;

    @FindBy(xpath = "//span[@class = 'checkbox']")
    WebElement noMiddleName;

    @FindBy(id = "passportSeries")
    WebElement passportSeries;

    @FindBy(id = "passportNumber")
    WebElement passportNumber;

    @FindBy(id = "documentIssue")
    WebElement documentIssue;

    @FindBy(id = "name_vzr_ins_0")
    WebElement nameIns;

    @FindBy(id = "surname_vzr_ins_0")
    WebElement surnameIns;

    @FindBy(id = "birthDate_vzr_ins_0")
    WebElement birthDateIns;

    @FindBy(id = "person_birthDate")
    WebElement birthDate;

    @FindBy(id = "documentDate")
    WebElement documentDate;

    @FindBy(xpath = "//label[contains(text(), 'Женский')]")
    public WebElement female;

    @FindBy(xpath = "//label[contains(text(), 'Мужской')]")
    public WebElement male;

    @FindBy(xpath = "//*[contains(text(), 'Продолжить')]")
    public WebElement sendButton;

    public WebElement getSendButton() {
        return sendButton;
    }


    public SendAppPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void fillField(String fieldName, String value){
        try {
            if ("Фамилия застрахованного".equals(fieldName)) { fillField(surnameIns, value); }
            if ("Имя застрахованного".equals(fieldName)) { fillField(nameIns, value); }
            if ("Имя страхователя".equals(fieldName)) { fillField(firstName, value); }
            if ("Дата рождения застрахованного".equals(fieldName)) { fillField(birthDateIns, value); }
            if ("Отчество страхователя".equals(fieldName)) { fillField(middleName, value); }
            if ("Дата рождения страхователя".equals(fieldName)) { fillField(birthDate, value); }
            if ("Серия паспорта".equals(fieldName)) { fillField(passportSeries, value); }
            if ("Номер паспорта".equals(fieldName)) { fillField(passportNumber, value); }
            if ("Когда выдан".equals(fieldName)) { fillField(documentDate, value); }
            if ("Фамилия страхователя".equals(fieldName)) { fillField(lastName, value); }
            if ("Кем выдан".equals(fieldName)) { fillField(documentIssue, value); }
        } catch (Exception e) {
            new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    public String getFillField(String fieldName){
            if ("Фамилия застрахованного".equals(fieldName)) {
                return surnameIns.getAttribute("value");
            }
            if ("Имя".equals(fieldName)) {
                return nameIns.getAttribute("value");
            }
            if ("Дата рождения застрахованного".equals(fieldName)) {
                return birthDateIns.getAttribute("value");
            }
            if ("Имя страхователя".equals(fieldName)) {
                return firstName.getAttribute("value");
            }
            if ("Дата рождения страхователя".equals(fieldName)) {
                return birthDate.getAttribute("value");
            }
            if ("Отчество страхователя".equals(fieldName)) {
                return middleName.getAttribute("value");
            }
            if ("Серия паспорта".equals(fieldName)) {
                return passportSeries.getAttribute("value");
            }
            if ("Номер паспорта".equals(fieldName)) {
                return passportNumber.getAttribute("value");
            }
            if ("Фамилия страхователя".equals(fieldName)) {
                return lastName.getAttribute("value");
            }
            if ("Когда выдан".equals(fieldName)) {
                return documentDate.getAttribute("value");
            }
            if ("Кем выдан".equals(fieldName)) {
                return documentIssue.getAttribute("value");
            }
            throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
    }



    public void checkFieldErrorMessage(String field, String errorMessage){
        if (field.equals("Мобильный телефон") || field.equals("Электронная почта")||field.equals( "Повтор электронной почты")) {
            String xpath = "//*[contains(@title, '" + field + "')]//*[contains(text(), 'Поле не заполнено')]";
            String actualValue = driver.findElement(By.xpath(xpath)).getText();
            assertEquals(errorMessage, actualValue);
        } else {
            String xpath = "//*[@class='alert-form alert-form-error']";
            String actualValue = driver.findElement(By.xpath(xpath)).getText();
            assertEquals(errorMessage, actualValue);
        }

    }
}
