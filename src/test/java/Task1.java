import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Task1 {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        baseUrl = "http://www.sberbank.ru/ru/person";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testSberInsurance () throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@aria-label='Страхование']")).click();//раскрываем меню Страхование
        driver.findElement(By.xpath("//*[@data-cga_click_top_menu='Страхование_Путешествия_type_important']")).click();//переходим в Путешествия
        assertEquals("Страхование путешественников", driver.findElement(By.xpath("//h1[@class='kitt-heading  page-teaser-dict__header kitt-heading_size_l']")).getText());//проверяем заголовок
        driver.findElement(By.xpath("//*[@data-test-id='PageTeaserDict_button']")).click();//оформить онлайн
        driver.findElement(By.xpath("//*[contains(text(),'Минимальная')]")).click();//минимальная сумма
        Scroll(5000);                                                     //костыль. иначе не жмется кнопка Оформить. скроллим в конец страницы
        driver.findElement(By.xpath("//*[@class='layout-wrapper']")).click(); //     и кликаем в пустоту
        driver.findElement(By.xpath("//*[contains(text(),'Оформить')]")).click();//жмем оформить

        driver.findElement(By.id("surname_vzr_ins_0")).sendKeys("Прохоров");
        driver.findElement(By.id("name_vzr_ins_0")).sendKeys("Петр");
        driver.findElement(By.id("birthDate_vzr_ins_0")).sendKeys("01.07.1980");
        driver.findElement(By.xpath("//*[@class='page container']")).click();

        driver.findElement(By.id("person_lastName")).sendKeys("Кротов");
        driver.findElement(By.id("person_firstName")).sendKeys("Олег");
        driver.findElement(By.id("person_middleName")).sendKeys("Юрьевич");
        driver.findElement(By.id("person_birthDate")).sendKeys("05.09.1978");
        driver.findElement(By.xpath("//*[@class='page container']")).click();
        driver.findElement(By.xpath("//*[@title='Пол']//*[contains(text(),'Мужской')]")).click();

        driver.findElement(By.id("passportSeries")).sendKeys("3402");
        driver.findElement(By.id("passportNumber")).sendKeys("231209");
        driver.findElement(By.id("documentDate")).sendKeys("15.09.2000");
        driver.findElement(By.xpath("//*[@class='page container']")).click();
        driver.findElement(By.id("documentIssue")).sendKeys("отделом УФМС России");

        //проверяем заполненные поля
        assertEquals("Прохоров", driver.findElement(By.id("surname_vzr_ins_0")).getAttribute("value"));
        assertEquals("Петр", driver.findElement(By.id("name_vzr_ins_0")).getAttribute("value"));
        assertEquals("01.07.1980", driver.findElement(By.id("birthDate_vzr_ins_0")).getAttribute("value"));

        assertEquals("Кротов", driver.findElement(By.id("person_lastName")).getAttribute("value"));
        assertEquals("Олег", driver.findElement(By.id("person_firstName")).getAttribute("value"));
        assertEquals("Юрьевич", driver.findElement(By.id("person_middleName")).getAttribute("value"));
        assertEquals("05.09.1978", driver.findElement(By.id("person_birthDate")).getAttribute("value"));
        assertEquals("Мужской", driver.findElement(By.xpath("//*[@title='Пол']//*[@class='btn ng-untouched ng-pristine ng-valid active']")).getText());

        assertEquals("3402", driver.findElement(By.id("passportSeries")).getAttribute("value"));
        assertEquals("231209", driver.findElement(By.id("passportNumber")).getAttribute("value"));
        assertEquals("15.09.2000", driver.findElement(By.id("documentDate")).getAttribute("value"));
        assertEquals("отделом УФМС России", driver.findElement(By.id("documentIssue")).getAttribute("value"));

        //жмем продолжить, проверяем не заполненные поля
        driver.findElement(By.xpath("//*[contains(text(),'Продолжить')]")).click();
        assertEquals("Поле не заполнено.", driver.findElement(By.xpath("//*[contains(@title, 'Мобильный телефон')]//*[@class='invalid-validate form-control__message']")).getText());
        assertEquals("Поле не заполнено.", driver.findElement(By.xpath("//*[contains(@title, 'Электронная почта')]//*[@class='invalid-validate form-control__message']")).getText());
        assertEquals("Поле не заполнено.", driver.findElement(By.xpath("//*[contains(@title, 'Повтор электронной почты')]//*[@class='invalid-validate form-control__message']")).getText());
    }

    private void Scroll(int yScrollPosition ) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,"+yScrollPosition+")", "");
    }


    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}