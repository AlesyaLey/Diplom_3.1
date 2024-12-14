package src;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By emailField = By.xpath("//label[text()='Email']/following-sibling::input");
    private By passwordField = By.xpath("//label[text()='Пароль']/following-sibling::input");
    private By signInButton = By.xpath("//button[text()='Войти']");
    private By registrationButton = By.xpath("//a[text()='Зарегистрироваться']");
    private By resetPasswordButton = By.xpath("//a[text()='Восстановить пароль']");
    private By passwordErrorMessage = By.xpath("//p[text()='Некорректный пароль']");
    private By loginPageInputFieldsTitle = By.xpath("//h2[text()='Вход']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUsername(String username) {
        driver.findElement(emailField).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    public void login(String username, String password){
        setUsername(username);
        setPassword(password);
        clickSignInButton();
    }

    public void clickRegistrationButton(){
        driver.findElement(registrationButton).click();
    }

    public void clickRecoverPasswordButton() {
        driver.findElement(resetPasswordButton).click();
    }

    public void checkMassageError(){
        driver.findElement(passwordErrorMessage).getText();
    }

    public String getLoginPageTitle() {
        return driver.findElement(loginPageInputFieldsTitle).getText();
    }

}
