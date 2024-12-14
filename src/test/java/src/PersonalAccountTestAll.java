package src;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.chrome.ChromeDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.firefox.FirefoxDriver;

@DisplayName("Личный кабинет")
public class PersonalAccountTestAll {

    private WebDriver driver;
    private final String email = "testm@ru.ru";
    private final String password = "password";

    @Test
    @DisplayName("переход по клику на «Личный кабинет»")
    @Description("Успешный переход по клику на «Личный кабинет»")
    @Step("Проверка кликабельности кнопки «Личный кабинет»")
    public void testClickPersonalAccountButtonChrome(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
        assertEquals("https://stellarburgers.nomoreparties.site/account", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Переход по клику на «Конструктор»")
    @Description("Успешный переход по клику в «Конструктор»")
    @Step("Переход по клику на «Конструктор»")
    public void testClickConstructorButtonChrome(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
        PersonalAccountPage objPersonalAccountPage = new PersonalAccountPage(driver);
        objPersonalAccountPage.clickConstructorButton();
        assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Клик по логотипу Stellar Burgers")
    @Description("Успешная проверка кликабельности логитипа Stellar Burgers")
    @Step("Клик по логотипу Stellar Burgers")
    public void testClickStellarBurgerLogoChrome(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickStellarBurgersLogo();
        assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Выход из Личного кабинета")
    @Description("Успешный выход из Личного кабинета")
    @Step("Выход из Личного кабинета")
    public void testLogoutFromPersonalAccountChrome(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/login");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickEnterToAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickLogoutButton();
        String name = loginPage.getLoginPageTitle().toString();
        assertEquals("Вход", name);
    }

    @Test
    @DisplayName("переход по клику на «Личный кабинет»")
    @Description("Успешный переход по клику на «Личный кабинет»")
    @Step("Проверка кликабельности кнопки «Личный кабинет»")
    public void testClickPersonalAccountButtonYandex(){
        //System.setProperty("webdriver.chrome.driver","src/test/resources/yandexdriver.exe");
        //driver = new ChromeDriver();
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/login");
        LoginPage LoginPage = new LoginPage(driver);
        LoginPage.login(email, password);
        MainPage MainPage = new MainPage(driver);
        MainPage.clickPersonalAccountButton();
        assertEquals("https://stellarburgers.nomoreparties.site/account", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Переход по клику на «Конструктор»")
    @Description("Успешный переход по клику в «Конструктор»")
    @Step("Переход по клику на «Конструктор»")
    public void testClickConstructorButtonYandex(){
        //System.setProperty("webdriver.chrome.driver","src/test/resources/yandexdriver.exe");
        //driver = new ChromeDriver();
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickConstructorButton();
        assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Клик по логотипу Stellar Burgers")
    @Description("Успешная проверка кликабельности логитипа Stellar Burgers")
    @Step("Клик по логотипу Stellar Burgers")
    public void testClickStellarBurgerLogoYandex(){
        //System.setProperty("webdriver.chrome.driver","src/test/resources/yandexdriver.exe");
       // driver = new ChromeDriver();
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickStellarBurgersLogo();
        assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());
    }

    @Test
    @Step("Выход из Личного кабинета")
    public void testClickLogoutButtonChrome() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickLogoutButton();
        Thread.sleep(1000);
        assertEquals("https://stellarburgers.nomoreparties.site/login", driver.getCurrentUrl());
    }

    @Test
    @Step("Выход из Личного кабинета")
    public void testClickLogoutButtonYandex() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver","src/test/resources/yandexdriver.exe");
       // driver = new ChromeDriver();
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickLogoutButton();
        Thread.sleep(1000);
        assertEquals("https://stellarburgers.nomoreparties.site/login", driver.getCurrentUrl());
    }

    @After
    @Step("Close browser")
    public void tearDown(){
        driver.quit();
    }
}
