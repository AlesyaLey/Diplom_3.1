package src;

import static org.junit.Assert.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.chrome.ChromeDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

@DisplayName("Конструктор")
public class ConstructorTest {

    private WebDriver driver;
    private static final String STELLABURGERS_URL = "https://stellarburgers.nomoreparties.site";

    @Test

    @DisplayName("Проверка кликабельности булок")
    @Description("Успешный выбор булочек")
    @Step("Проверка кликабельности булок")
    public void testClickBunTabChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(STELLABURGERS_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickIngredientsTab();
        mainPage.clickBunTab();
        assertTrue(mainPage.getBunTabClassValue().contains("current"));
    }

    @Test

    @DisplayName("Проверка кликабельности соусов")
    @Description("Успешный выбор соусов")
    @Step("Проверка кликабельности соусов")
    public void testClickSauceTabChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(STELLABURGERS_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSaucesTab();
        assertTrue(mainPage.getSauceTabClassValue().contains("current"));
    }


    @Test

    @DisplayName("Проверка кликабельности ингридиентов")
    @Description("Успешный выбор ингридиентов")
    @Step("Проверка кликабельности ингридиентов")
    public void testClickIngredientsTabChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(STELLABURGERS_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickIngredientsTab();
        assertTrue(mainPage.getIngredientsTabClassValue().contains("current"));
    }

    @Test

    @DisplayName("Проверка кликабельности булок")
    @Description("Успешный выбор булочек")
    @Step("Проверка кликабельности булок")
    public void testClickBunTabYandex() {
      //  System.setProperty("webdriver.chrome.driver","src/test/resources/yandexdriver");
       // driver = new ChromeDriver();
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(STELLABURGERS_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickIngredientsTab();
        mainPage.clickBunTab();
        assertTrue(mainPage.getBunTabClassValue().contains("current"));
    }

    @Test

    @DisplayName("Проверка кликабельности соусов")
    @Description("Успешный выбор соусов")
    @Step("Проверка кликабельности соусов")
    public void testClickSauceTabYandex() {
       // System.setProperty("webdriver.chrome.driver","src/test/resources/yandexdriver");
       // driver = new ChromeDriver();
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(STELLABURGERS_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSaucesTab();
        assertTrue(mainPage.getSauceTabClassValue().contains("current"));
    }

    @Test

    @DisplayName("Проверка кликабельности ингридиентов")
    @Description("Успешный выбор ингридиентов")
    @Step("Проверка кликабельности ингридиентов")
    public void testClickIngredientsTabYandex() {
        //System.setProperty("webdriver.chrome.driver","src/test/resources/yandexdriver.exe");
        //driver = new ChromeDriver();
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(STELLABURGERS_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickIngredientsTab();
        assertTrue(mainPage.getIngredientsTabClassValue().contains("current"));
    }

    @After
    @Step("Close browser")
    public void tearDown(){
        driver.quit();
    }
}
