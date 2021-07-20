package Task3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OptionsInsurancePage extends BasePage {


    @FindBy(xpath = "//h2[contains(text(), 'Страхование путешественников')]")
    public WebElement title;

    @FindBy(xpath = "//*[contains(text(), 'Оформить')]")
    public WebElement sendButton;

    public OptionsInsurancePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void selectType(String itemName) {
        driver.findElement(By.xpath("//h3[text() = '" + itemName + "']")).click();
    }

    public void sendButton(String itemName) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 5000)", "");
        driver.findElement(By.xpath("//*[@class='layout-wrapper']")).click();
        driver.findElement(By.xpath("//button[text() = '" + itemName + "']")).click();
    }
}