package Task3.steps;

import Task3.pages.OptionsInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;


public class OptionsInsuranceSteps extends BaseSteps{

    @Step("заголовок страницы -  равен {0}")
    public void checkPageTitle(String expectedTitle){
        String actualTitle = new OptionsInsurancePage(driver).title.getText();
        String expectedTitle2 = "Страхование путешественников";
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]", actualTitle, expectedTitle), actualTitle.contains(expectedTitle2));
    }

    @Step("нажата кнопка -  {0}")
    public void sendButton(String menuItem){
        new OptionsInsurancePage(driver).sendButton(menuItem);

    }
    @Step("выбран тип страхования -  {0}")
    public void selectType(String itemName) {
        new OptionsInsurancePage(driver).selectType(itemName);

    }
}
