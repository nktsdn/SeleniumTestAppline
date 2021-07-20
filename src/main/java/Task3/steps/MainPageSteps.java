package Task3.steps;

import Task3.pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPageSteps extends BaseSteps {

    @Step("закрываем сообщение об cookie")
    public void waitSendAppClickable(){
        new MainPage(driver).waitSendAppClickable();
    }

    @Step("выбираем пункт меню {0}")
    public void selectMainMenu(String itemName){
        new MainPage(driver).selectMainMenu(itemName);
    }

    @Step("выбираем пункт меню {0}")
    public void selectSubMenu(String itemName){
        new MainPage(driver).selectSubMenu(itemName);
    }
}
