package Task2;

import org.junit.Test;
import Task2.pages.*;

import static org.junit.Assert.assertTrue;

public class MyRefactoringTest extends BaseTest{
    @Test
    public void SberInsuranceTest() {

        MainPage mainPage = new MainPage(driver);
        mainPage.waitSendAppClickable();
        mainPage.selectMainMenu("Страхование");
        mainPage.selectSubMenu("Путешествия");

        ClickButtonPage clickOnlineButtonPage = new ClickButtonPage(driver);

        String actualTitle = clickOnlineButtonPage.title.getText();
        String expectedTitle = "Страхование путешественников";
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]", actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
        clickOnlineButtonPage.sendButton.click();

        OptionsInsurancePage optionInsurancePage = new OptionsInsurancePage(driver);
        optionInsurancePage.selectType("Минимальная");
        optionInsurancePage.sendButton("Оформить");

        SendAppPage sendAppPage = new SendAppPage(driver);
        sendAppPage.fillField("Фамилия застрахованного", "Прохоров");
        sendAppPage.fillField("Имя застрахованного", "Петр");
        sendAppPage.fillField("Дата рождения застрахованного", "01.07.1980");
        sendAppPage.fillField("Фамилия страхователя", "Кротов");
        sendAppPage.fillField("Имя страхователя", "Олег");
        sendAppPage.fillField("Отчество страхователя", "Юрьевич");
        sendAppPage.fillField("Дата рождения страхователя", "05.09.1978");
        sendAppPage.fillField("Серия паспорта", "3402");
        sendAppPage.fillField("Номер паспорта", "231209");
        sendAppPage.fillField("Дата выдачи", "15.09.2000");
        sendAppPage.fillField("Кем выдан", "отделом УФМС России");
        sendAppPage.male.click();


        sendAppPage.getFillField("Фамилия застрахованного", "Прохоров");
        sendAppPage.getFillField("Имя застрахованного", "Петр");
        sendAppPage.getFillField("Дата рождения застрахованного", "01.07.1980");
        sendAppPage.getFillField("Фамилия страхователя", "Кротов");
        sendAppPage.getFillField("Имя страхователя", "Олег");
        sendAppPage.getFillField("Отчество страхователя", "Юрьевич");
        sendAppPage.getFillField("Дата рождения страхователя", "05.09.1978");
        sendAppPage.getFillField("Серия паспорта", "3402");
        sendAppPage.getFillField("Номер паспорта", "231209");
        sendAppPage.getFillField("Дата выдачи", "15.09.2000");
        sendAppPage.getFillField("Кем выдан", "отделом УФМС России");

        sendAppPage.sendButton.click();

        sendAppPage.checkFieldErrorMessage("Мобильный телефон", "Поле не заполнено.");
        sendAppPage.checkFieldErrorMessage("Электронная почта", "Поле не заполнено.");
        sendAppPage.checkFieldErrorMessage("Повтор электронной почты", "Поле не заполнено.");
    }

}
