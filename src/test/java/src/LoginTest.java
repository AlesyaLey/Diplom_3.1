package src;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.Assert.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import io.qameta.allure.Step;
import java.util.concurrent.TimeUnit;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.firefox.FirefoxDriver;

@DisplayName("Логирование - Вход")
public class LoginTest {

    private WebDriver driver;

    private final String email = RandomStringUtils.randomAlphabetic(9) + "@example.ru";
    private final String password = "password";

    @Test

    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("Успешный вход через кнопку «Личный кабинет»")
    @Step("Вход через кнопку «Личный кабинет»")
    public void testLoginPersonalAccountButtonChrome(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        assertNotNull(mainPage.waitCreateOrderButtonVisible());
    }

    @Test

    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Step("Вход по кнопке «Войти в аккаунт» на главной")
    public void testLoginEnterAccountButtonChrome(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickEnterToAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        assertNotNull(mainPage.waitCreateOrderButtonVisible());
    }

    @Test

    @DisplayName("Вход через кнопку в форме регистрации")
    @Step("Вход через кнопку в форме регистрации")
    public void testLoginRegistrationFormChrome(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.scrollToLoginButton();
        registrationPage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        MainPage mainPage = new MainPage(driver);
        assertNotNull(mainPage.waitCreateOrderButtonVisible());
    }

    @Test

    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Step("Вход через кнопку в форме восстановления пароля")
    public void testLoginRecoverPasswordPageChrome(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        RecoverPasswordPage recoverPasswordPage = new RecoverPasswordPage(driver);
        recoverPasswordPage.scrollToLoginButton();
        recoverPasswordPage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        MainPage mainPage = new MainPage(driver);
        assertNotNull(mainPage.waitCreateOrderButtonVisible());
    }

   @Test

    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("Успешный вход через кнопку «Личный кабинет»")
    @Step("Вход через кнопку «Личный кабинет»")
    public void testLoginPersonalAccountButtonYandex(){
      // System.setProperty("webdriver.chrome.driver","src/java/resources/yandexdriver.exe");
       // driver = new ChromeDriver();
        WebDriverManager.firefoxdriver().setup();
       driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        assertNotNull(mainPage.waitCreateOrderButtonVisible());
    }

    @Test

    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Step("Вход по кнопке «Войти в аккаунт» на главной")
    public void testLoginEnterAccountButtonYandex(){
        //System.setProperty("webdriver.yandex.driver","src/java/resources/yandexdriver.exe");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickEnterToAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        assertNotNull(mainPage.waitCreateOrderButtonVisible());
    }

    @Test

    @DisplayName("Вход через кнопку в форме регистрации")
    @Step("Вход через кнопку в форме регистрации")
    public void testLoginRegistrationFormYandex(){
        //System.setProperty("webdriver.chrome.driver","/src/main/resources/yandexdriver.exe");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.scrollToLoginButton();
        registrationPage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        MainPage mainPage = new MainPage(driver);
        assertNotNull(mainPage.waitCreateOrderButtonVisible());
    }

    @Test

    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Step("Вход через кнопку в форме восстановления пароля")
    public void testLoginRecoverPasswordPageYandex(){
        //System.setProperty("webdriver.chrome.driver","src/java/resources/yandexdriver.exe");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        RecoverPasswordPage recoverPasswordPage = new RecoverPasswordPage(driver);
        recoverPasswordPage.scrollToLoginButton();
        recoverPasswordPage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        MainPage mainPage = new MainPage(driver);
        assertNotNull(mainPage.waitCreateOrderButtonVisible());
    }

@After
@Step("Close browser")
public void tearDown(){
    driver.quit();
}

}
