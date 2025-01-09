package src;

import api.AuthorizationReq;
import api.MainStellarBurgersApi;
import api.UserReq;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import static org.junit.Assert.*;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.chrome.ChromeDriver;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@DisplayName("Регистрация")
public class RegistrationUserTest {

    private WebDriver driver;
    private String name;
    private String email;
    private final String password = "password123";
    private static final String STELLABURGERS_URL = "https://stellarburgers.nomoreparties.site";
    private static final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";
    private UserReq userReq;
    private MainStellarBurgersApi api;


    @Before

    @Step("Создать случайного пользователя")
    public void createRegistrationData(){
        api = new MainStellarBurgersApi();
        name = RandomStringUtils.randomAlphabetic(8);
        email = name + "@example.ru";

    }

    @Test

    @DisplayName("Регистрация")
    @Description("Успешная регистрация")
    @Step("Регистрация")
    public void testRegistrationChrome() throws InterruptedException {
        String env = System.getProperty("browser", "chrome");
        driver = DriverProperties.getDriver(env);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(STELLABURGERS_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickEnterToAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationButton();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration(name, email, password);
        userReq = new UserReq(name, email, password);
        registrationPage.clickRegistrationButton();
        mainPage.clickPersonalAccountButton();
        loginPage.login(email, password);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        mainPage.clickPersonalAccountButton();
        String accountName = personalAccountPage.getNameFieldValue();
        String accountEmail = personalAccountPage.getEmailFieldValue();
        assertEquals(name, accountName);
        assertEquals(email.toLowerCase(), accountEmail);
        personalAccountPage.clickLogoutButton();
        api.deleteUser(userReq.toString());
    }

    @Test

    @DisplayName("Регистрация")
    @Description("Ошибка при указании неверного пароля")
    @Step("Провальная регистрация")
    public void nonTestRegistrationChrome() throws InterruptedException {
        String password = "pass";
        String env = System.getProperty("browser", "chrome");
        driver = DriverProperties.getDriver(env);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(STELLABURGERS_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickEnterToAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationButton();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        String registrationError = registrationPage.waitPasswordErrorVisible(password).getText();
        assertEquals("Некорректный пароль",registrationError);
    }

    @After
    @Step("Close browser")
    public void tearDown(){
            driver.quit();
    }

}
