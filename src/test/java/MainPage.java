package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private WebDriver driver;

    // Локаторы элементов
    private By accordionHeading = By.id("accordion__heading-1"); // выпадающий список
    private By orderButtonTop = By.cssSelector(".Button_Button__ra12g"); // заказать вверху страницы
    private By orderButtonBottom = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM"); // заказать внизу страницы
    private By cookieConsent = By.className("App_CookieConsent__1yUIN"); // всплывающее окно с согласием на использование файлов cookie

    // Конструктор
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Методы взаимодействия с элементами
    public void clickAccordion() {
        WebElement accordion = driver.findElement(accordionHeading);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", accordion);
        accordion.click();
    }

    public void clickOrderButtonTop() {
        driver.findElement(orderButtonTop).click();
    }

    public void clickOrderButtonBottom() {
        driver.findElement(orderButtonBottom).click();
    }

    public void closeCookieConsent() {
        WebElement consent = driver.findElement(cookieConsent);
        if (consent.isDisplayed()) {
            consent.findElement(By.cssSelector("button")).click(); // Нажимаем на кнопку закрытия всплывающего окна
        }
    }
}