package Task3;

import Task3.steps.*;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.HashMap;

public class SberInsuranceTest extends BaseSteps {

    MainPageSteps mainPageSteps = new MainPageSteps();
    ClickButtonSteps clickButtonSteps = new ClickButtonSteps();
    OptionsInsuranceSteps optionsInsuranceSteps = new OptionsInsuranceSteps();
    SendAppSteps sendAppSteps = new SendAppSteps();

    HashMap<String, String> personInfo = new HashMap<>();


    @Title("Заявка на страховку для путешественников")
    @Test
    public void Test(){
        personInfo.put("Фамилия застрахованного", "Прохоров");
        personInfo.put("Имя застрахованного", "Петр");
        personInfo.put("Дата рождения застрахованного", "01.07.1980");
        personInfo.put("Фамилия страхователя", "Кротов");
        personInfo.put("Имя страхователя", "Олег");
        personInfo.put("Отчество страхователя", "Юрьевич");
        personInfo.put("Дата рождения страхователя", "05.09.1978");
        personInfo.put("Серия паспорта", "3402");
        personInfo.put("Номер паспорта", "231209");
        personInfo.put("Дата выдачи", "15.09.2000");
        personInfo.put("Кем выдан", "отделом УФМС России");

        //mainPageSteps.waitSendAppClickable();
        mainPageSteps.selectMainMenu("Страхование");
        mainPageSteps.selectSubMenu("Путешествия");
        mainPageSteps.waitSendAppClickable();
        clickButtonSteps.checkPageTitle("Страхование путешественников");
        clickButtonSteps.sendButton("Оформить онлайн");

        optionsInsuranceSteps.checkPageTitle("Страхование путешественников");
        optionsInsuranceSteps.selectType("Минимальная");
        optionsInsuranceSteps.sendButton("Оформить");

        sendAppSteps.fillFields(personInfo);
        sendAppSteps.checkFillFields(personInfo);
        sendAppSteps.sendButton("Продолжить");

        sendAppSteps.checkErrorMessageField("Мобильный телефон", "Поле не заполнено.");
        sendAppSteps.checkErrorMessageField("Электронная почта", "Поле не заполнено.");
        sendAppSteps.checkErrorMessageField("Повтор электронной почты", "Поле не заполнено.");
    }
}
