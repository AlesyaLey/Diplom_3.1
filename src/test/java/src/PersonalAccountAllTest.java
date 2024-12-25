package src;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;

import api.MainStellarBurgersApi;
import api.UserReq;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import org.junit.After;
import io.qameta.allure.Step;

@DisplayName("Личный кабинет")
public class PersonalAccountAllTest {

    private WebDriver driver;
    private static final String STELLABURGERS_URL = "https://stellarburgers.nomoreparties.site/";
    private static final String ACCOUNT_URL="https://stellarburgers.nomoreparties.site/account";
    private static final String LOGIN_URL="https://stellarburgers.nomoreparties.site/login";
    private String email;
    private String password = "password";
    private String name;
    MainStellarBurgersApi api;
    UserReq userReq;

    @Before
    @Step("Создать случайного пользователя")
    public void createRegistrationData(){
        api = new MainStellarBurgersApi();
        name = RandomStringUtils.randomAlphabetic(8);
        email = name + "@example.ru";

    }

    @Test
    @DisplayName("переход по клику на «Личный кабинет»")
    @Description("Успешный переход по клику на «Личный кабинет»")
    @Step("Проверка кликабельности кнопки «Личный кабинет»")
    public void testClickPersonalAccountButtonChrome(){
        String env = System.getProperty("browser", "firefox");
        driver = DriverProperties.getDriver(env);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(STELLABURGERS_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
        assertEquals(LOGIN_URL, driver.getCurrentUrl());
        userReq = new UserReq(name,email,password);
        String token = api.createUser(userReq);
        api.deleteUser(token);
    }

    @Test
    @DisplayName("Переход по клику на «Конструктор»")
    @Description("Успешный переход по клику в «Конструктор»")
    @Step("Переход по клику на «Конструктор»")
    public void testClickConstructorButtonChrome(){
        String env = System.getProperty("browser", "chrome");
        driver = DriverProperties.getDriver(env);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(LOGIN_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        loginPage.clickSignInButton();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickConstructorButton();
        assertEquals(STELLABURGERS_URL, driver.getCurrentUrl());
        userReq = new UserReq(name,email,password);
        String token = api.createUser(userReq);
        api.deleteUser(token);
    }

    @Test
    @DisplayName("Клик по логотипу Stellar Burgers")
    @Description("Успешная проверка кликабельности логитипа Stellar Burgers")
    @Step("Клик по логотипу Stellar Burgers")
    public void testClickStellarBurgerLogoChrome(){
        String env = System.getProperty("browser", "chrome");
        driver = DriverProperties.getDriver(env);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(LOGIN_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickStellarBurgersLogo();
        assertEquals(STELLABURGERS_URL, driver.getCurrentUrl());
        userReq = new UserReq(name,email,password);
        String token = api.createUser(userReq);
        api.deleteUser(token);
    }

    @Test
    @DisplayName("Выход из Личного кабинета")
    @Description("Успешный выход из Личного кабинета")
    @Step("Выход из Личного кабинета")
    public void testLogoutFromPersonalAccountChrome(){
        String env = System.getProperty("browser", "chrome");
        driver = DriverProperties.getDriver(env);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(LOGIN_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickEnterToAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickLogoutButton();
        String name = loginPage.getLoginPageTitle().toString();
        assertEquals("Вход", name);
        userReq = new UserReq(name,email,password);
        String token = api.createUser(userReq);
        api.deleteUser(token);
    }


    @Test
    @DisplayName("Выход из Личного кабинета")
    @Description("Успешный выход из Личного кабинета")
    @Step("Выход из Личного кабинета")
    public void testClickLogoutButtonChrome() throws InterruptedException {
        String env = System.getProperty("browser", "chrome");
        driver = DriverProperties.getDriver(env);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(LOGIN_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickLogoutButton();
        assertEquals(LOGIN_URL, driver.getCurrentUrl());
        userReq = new UserReq(name,email,password);
        String token = api.createUser(userReq);
        api.deleteUser(token);
    }

    @After
    @Step("Close browser")
    public void tearDown(){
        driver.quit();
    }
}
