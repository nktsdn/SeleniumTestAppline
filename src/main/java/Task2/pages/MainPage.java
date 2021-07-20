package Task2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage extends BasePage{

    @FindBy(xpath = "//ul[contains(@class,'list_center')]")
    WebElement mainMenu;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void selectMainMenu(String itemName){
        mainMenu.findElement(By.xpath(".//a[text()='"+itemName+"']")).click();
    }

    public void selectSubMenu(String itemName){
        driver.findElement(By.xpath(".//a[text()='"+itemName+"']")).click();
    }
    public void waitSendAppClickable(){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//*[contains(text(), 'Закрыть')][contains(@class,'cookie')]")))).click();
    }

}
