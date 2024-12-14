package src;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage {

    private WebDriver driver;

    private By constructorButton = By.xpath("//a[@href='/' and @class='AppHeader_header__link__3D_hX']");
    private By stellarBurgersLogo = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']/a[@href='/' ]");
    private By nameField = By.xpath("//label[text()='Имя']/following-sibling::input");
    private By emailField = By.xpath("//label[text()='Логин']/following-sibling::input");
    private By passwordField = By.xpath("//label[text()='Пароль']/following-sibling::input");
    //private By logoutButton = By.xpath("//button[text()='Выход']");
    private By logoutButton = By.className("text_color_inactive");
    private By saveButton = By.xpath("//*[@id=\"root\"]/div/main/div/div/div/div/button[2]");//исправить
    private By cancellButton = By.xpath("//*[@id=\"root\"]/div/main/div/div/div/div/button[1]");


    public PersonalAccountPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickConstructorButton(){
        driver.findElement(constructorButton).click();
    }

    public void clickStellarBurgersLogo(){
        driver.findElement(stellarBurgersLogo).click();
    }

    public void clickLogoutButton(){
        driver.findElement(logoutButton).click();
    }

    public String getNameFieldValue(){
        return driver.findElement(nameField).getAttribute("value");
    }

    public String getEmailFieldValue(){
        return driver.findElement(emailField).getAttribute("value");
    }

    public String getPasswordFieldValue(){
        return driver.findElement(passwordField).getAttribute("value");
    }

    public void clickSaveButton (){
        driver.findElement(saveButton ).click();
    }

    public void clickCancellButton (){
        driver.findElement(cancellButton).click();
    }
}
