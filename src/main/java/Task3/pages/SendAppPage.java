package Task3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;


public class SendAppPage extends BasePage {

    @FindBy(xpath = "//*[@class='page container']")
    WebElement pageContainer;

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


    public SendAppPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void fillField(String fieldName, String value){
        try {
            if ("Фамилия застрахованного".equals(fieldName)) { fillField(surnameIns, value); }
            if ("Имя застрахованного".equals(fieldName)) { fillField(nameIns, value); }
            if ("Имя страхователя".equals(fieldName)) { fillField(firstName, value); }
            if ("Дата рождения застрахованного".equals(fieldName)) { fillField(birthDateIns, value); pageContainer.click();}
            if ("Отчество страхователя".equals(fieldName)) { fillField(middleName, value); }
            if ("Дата рождения страхователя".equals(fieldName)) { fillField(birthDate, value); pageContainer.click();}
            if ("Серия паспорта".equals(fieldName)) { fillField(passportSeries, value); }
            if ("Номер паспорта".equals(fieldName)) { fillField(passportNumber, value); }
            if ("Дата выдачи".equals(fieldName)) { fillField(documentDate, value); pageContainer.click();}
            if ("Фамилия страхователя".equals(fieldName)) { fillField(lastName, value); }
            if ("Кем выдан".equals(fieldName)) { fillField(documentIssue, value); }
        } catch (Exception e) {
            new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    public String getFillField(String fieldName) {
        switch (fieldName) {
            case "Фамилия застрахованного":
                return surnameIns.getAttribute("value");
            case "Имя застрахованного":
                return nameIns.getAttribute("value");
            case "Дата рождения застрахованного":
                return birthDateIns.getAttribute("value");
            case "Имя страхователя":
                return firstName.getAttribute("value");
            case "Дата рождения страхователя":
                return birthDate.getAttribute("value");
            case "Отчество страхователя":
                return middleName.getAttribute("value");
            case "Серия паспорта":
                return passportSeries.getAttribute("value");
            case "Номер паспорта":
                return passportNumber.getAttribute("value");
            case "Фамилия страхователя":
                return lastName.getAttribute("value");
            case "Дата выдачи":
                return documentDate.getAttribute("value");
            case "Кем выдан":
                return documentIssue.getAttribute("value");
        }
        throw new AssertionError("Поле "+fieldName+" не найдено");
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
