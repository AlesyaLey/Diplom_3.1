package src;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {

    private WebDriver driver;

    private By personalAccountButton = By.xpath("//a[@class='AppHeader_header__link__3D_hX' and @href='/account']");
    private By enterToAccountButton = By.className("button_button__33qZ0");
    private By createOrderButton = By.className("button_button__33qZ0");
    private By bunTab = By.xpath("//span[text()='Булки']/..");
    private By saucesTab = By.xpath("//span[text()='Соусы']/..");
    private By ingredientsTab = By.xpath("//span[text()='Начинки']/..");
    private By mainLogoImage = By.className("AppHeader_header__logo__2D0X2");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickPersonalAccountButton(){
        driver.findElement(personalAccountButton).click();
    }

    public void clickEnterToAccountButton(){
        driver.findElement(enterToAccountButton).click();
    }

    public WebElement waitCreateOrderButtonVisible(){
        return new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(createOrderButton));
    }

    public void clickBunTab(){
        driver.findElement(bunTab).click();
    }

    public void clickSaucesTab(){
        driver.findElement(saucesTab).click();
    }

    public void clickIngredientsTab(){
        driver.findElement(ingredientsTab).click();
    }

    public String getSauceTabClassValue(){
        return driver.findElement(saucesTab).getAttribute("class");
    }

    public String getIngredientsTabClassValue(){
        return driver.findElement(ingredientsTab).getAttribute("class");
    }

    public String getBunTabClassValue(){
        return driver.findElement(bunTab).getAttribute("class");
    }


}