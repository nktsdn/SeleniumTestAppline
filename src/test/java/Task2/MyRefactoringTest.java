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

        ClickOnlineButtonPage clickOnlineButtonPage = new ClickOnlineButtonPage(driver);

        String actualTitle = clickOnlineButtonPage.title.getText();
        String expectedTitle = "Страхование путешественников";
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]", actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
        clickOnlineButtonPage.sendButton.click();

        OptionsInsurancePage optionInsurancePage = new OptionsInsurancePage(driver);
        optionInsurancePage.selectType("Минимальная");
        //optionInsurancePage.sendButton.click();
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
        sendAppPage.fillField("Кем выдан", "отделом УФМС России");
        sendAppPage.fillField("Когда выдан", "15.09.2000");
        sendAppPage.male.click();

        sendAppPage.getFillField("Прохоров");
        sendAppPage.getFillField("Петр");
        sendAppPage.getFillField("01.07.1980");
        sendAppPage.getFillField("Кротов");
        sendAppPage.getFillField("Олег");
        sendAppPage.getFillField("Юрьевич");
        sendAppPage.getFillField("05.09.1978");
        sendAppPage.getFillField("3402");
        sendAppPage.getFillField("231209");
        sendAppPage.getFillField("отделом УФМС России");
        sendAppPage.getFillField("15.09.2000");

        sendAppPage.sendButton.click();

        sendAppPage.checkFieldErrorMessage("Мобильный телефон", "Поле не заполнено.");
        sendAppPage.checkFieldErrorMessage("Электронная почта", "Поле не заполнено.");
        sendAppPage.checkFieldErrorMessage("Повтор электронной почты", "Поле не заполнено.");
    }
}
