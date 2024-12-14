package src;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import static org.junit.Assert.*;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.chrome.ChromeDriver;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

@DisplayName("Регистрация")
public class RegistrationUserTest {

    private WebDriver driver;
    private String name;
    private String email;
    private final String password = "password123";

    @Before

    @Step("Создать случайного пользователя")
    public void createRegistrationData(){
        name = RandomStringUtils.randomAlphabetic(8);
        email = name + "@example.ru";
    }

    @Test

    @DisplayName("Регистрация в Chrome")
    @Description("Успешная регистрация в Chrome")
    @Step("Регистрация в Chrome")
    public void testRegistrationChrome() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickEnterToAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationButton();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration(name, email, password);
        Thread.sleep(1000);
        loginPage.login(email, password);
        mainPage.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        String accountName = personalAccountPage.getNameFieldValue();
        String accountEmail = personalAccountPage.getEmailFieldValue();
        assertEquals(name, accountName);
        assertEquals(email.toLowerCase(), accountEmail);
        personalAccountPage.clickLogoutButton();
    }

    @Test

    @DisplayName("Регистрация в Chrome")
    @Description("Ошибка при указании неверного пароля")
    @Step("Провальная регистрация в Chrome")
    public void nonTestRegistrationChrome() throws InterruptedException {
        String password = "pass";
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickEnterToAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationButton();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        String Error = registrationPage.waitPasswordErrorVisible(password).getText();
        assertEquals("Некорректный пароль",Error);
    }


    @Test

    @DisplayName("Регистрация в Yandex")
    @Description("Успешная регистрация в Yandex")
    @Step("Регистрация в Yandex")
    public void testRegistrationYandex() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver","src/test/resources/yandexdriver.exe");
       // driver = new ChromeDriver();
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickEnterToAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationButton();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration(name, email, password);
        Thread.sleep(1000);
        loginPage.login(email, password);
        mainPage.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        String accountName = personalAccountPage.getNameFieldValue();
        String accountEmail = personalAccountPage.getEmailFieldValue();
        assertEquals(name, accountName);
        assertEquals(email.toLowerCase(), accountEmail);
        personalAccountPage.clickLogoutButton();
    }
    @Test

    @DisplayName("Регистрация в Yandex")
    @Description("Ошибка при указании неверного пароля")
    @Step("Провальная регистрация в Yandex")
    public void nonTestRegistrationYandex() throws InterruptedException {
        String password = "pass";
        //WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickEnterToAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationButton();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        String Error = registrationPage.waitPasswordErrorVisible(password).getText();
        assertEquals("Некорректный пароль",Error);
    }

    @After
    @Step("Close browser")
    public void tearDown(){
        driver.quit();
    }
}
