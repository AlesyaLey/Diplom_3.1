package src;

import api.MainStellarBurgersApi;
import api.SaveToken;
import api.UserReq;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.Assert.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
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
    private static final String STELLABURGERS_URL = "https://stellarburgers.nomoreparties.site";
    private static final String REGISTRER_URL = "https://stellarburgers.nomoreparties.site/register";
    private static final String FOGOTPASS_URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    private final String email = RandomStringUtils.randomAlphabetic(9) + "@example.ru";
    private final String password = "password";

    @Before
    @Step("Создание пользователя")
    public void creatUser(){
        UserReq userReq = new UserReq("test",email,password);
        MainStellarBurgersApi api = new MainStellarBurgersApi();
        String token = api.createUser(userReq);
        SaveToken saveToken = new SaveToken();
        saveToken.setToken(token);

    }

    @Test

    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("Успешный вход через кнопку «Личный кабинет»")
    @Step("Вход через кнопку «Личный кабинет»")
    public void testLoginPersonalAccountButtonChrome(){
        String env = System.getProperty("browser", "chrome");
        driver = DriverProperties.getDriver(env);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(STELLABURGERS_URL);

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
        String env = System.getProperty("browser", "chrome");
        driver = DriverProperties.getDriver(env);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(STELLABURGERS_URL);
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
        String env = System.getProperty("browser", "chrome");
        driver = DriverProperties.getDriver(env);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(REGISTRER_URL);
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
        String env = System.getProperty("browser", "chrome");
        driver = DriverProperties.getDriver(env);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(FOGOTPASS_URL);
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
        SaveToken saveToken = new SaveToken();
        String token = saveToken.getToken();
        MainStellarBurgersApi api = new MainStellarBurgersApi();
        api.deleteUser(token);
        driver.quit();
}

}
