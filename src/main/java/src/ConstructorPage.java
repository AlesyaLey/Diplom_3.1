package src;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ConstructorPage {

    private WebDriver driver;
//Заказ
    private By mainPageHeaderText = By.tagName("h1");
    private By mainPageIngredientsDisplayBuns = By.xpath("//span[text()='Булки']");
    private By mainPageIngredientsDisplayBunsChapterTitle = By.xpath("//h2[text()='Булки']");
    private By mainPageIngredientsDisplaySauces = By.xpath( "//span[text()='Соусы']");
    private By mainPageIngredientsDisplaySaucesChapterTitle = By.xpath("//h2[text()='Соусы']");
    private By mainPageIngredientsDisplayToppings = By.xpath("//span[text()='Начинки']");
    private By mainPageBurgerPreview = By.className("BurgerConstructor_basket__list__l9dp_");
    private By mainPageBurgerPreviewPrice = By.xpath("//div[@class='BurgerConstructor_basket__totalContainer__2Z-ho mr-10']/p");
    private By mainPageLoginButton = By.xpath("//button[text()='Войти в аккаунт']");
}
