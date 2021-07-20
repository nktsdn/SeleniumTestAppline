package Task3.steps;

import Task3.pages.ClickButtonPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;

public class ClickButtonSteps extends BaseSteps{


    @FindBy(xpath = "//h2[contains(text(), 'Страхование путешественников')]")
    public WebElement title;

    @Step("Заголовок: {0}")
    public void checkPageTitle(String expectedTitle) {
        String actualTitle = new ClickButtonPage(driver).title.getText();
        String expectedTitle2 = "Страхование путешественников";
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]", actualTitle, expectedTitle), actualTitle.contains(expectedTitle2));
    }

    @Step("Жмем кнопку: {0}")
    public void sendButton(String menuItem) {
        new ClickButtonPage(driver).sendButton(menuItem);
    }
}
