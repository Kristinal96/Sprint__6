package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private WebDriver driver;

    // Локаторы элементов

    private By orderButtonTop = By.cssSelector(".Button_Button__ra12g"); // заказать вверху страницы
    private By orderButtonBottom = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM"); // заказать внизу страницы
    private By cookieConsent = By.className("App_CookieConsent__1yUIN"); // всплывающее окно с согласием на использование файлов cookie
    // Локаторы элементов
    private By accordionHeading1 = By.id("accordion__heading-0"); // первый вопрос
    private By accordionHeading2 = By.id("accordion__heading-1"); // второй вопрос
    private By accordionHeading3 = By.id("accordion__heading-2"); // третий вопрос
    private By accordionHeading4 = By.id("accordion__heading-3"); // четвертый вопрос
    private By accordionHeading5 = By.id("accordion__heading-4"); // пятый вопрос
    private By accordionHeading6 = By.id("accordion__heading-5"); // шестой вопрос
    private By accordionHeading7 = By.id("accordion__heading-6"); // седьмой вопрос
    private By accordionHeading8 = By.id("accordion__heading-7"); // восьмой вопрос

    // Конструктор
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Методы взаимодействия с элементами
    public void clickAccordion(int questionNumber) {
        switch (questionNumber) {
            case 1:
                scrollToElement(driver.findElement(accordionHeading1));
                driver.findElement(accordionHeading1).click();
                break;
            case 2:
                scrollToElement(driver.findElement(accordionHeading2));
                driver.findElement(accordionHeading2).click();
                break;
            case 3:
                scrollToElement(driver.findElement(accordionHeading3));
                driver.findElement(accordionHeading3).click();
                break;
            case 4:
                scrollToElement(driver.findElement(accordionHeading4));
                driver.findElement(accordionHeading4).click();
                break;
            case 5:
                scrollToElement(driver.findElement(accordionHeading5));
                driver.findElement(accordionHeading5).click();
                break;
            case 6:
                scrollToElement(driver.findElement(accordionHeading6));
                driver.findElement(accordionHeading6).click();
                break;
            case 7:
                scrollToElement(driver.findElement(accordionHeading7));
                driver.findElement(accordionHeading7).click();
                break;
            case 8:
                scrollToElement(driver.findElement(accordionHeading8));
                driver.findElement(accordionHeading8).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid question number");
        }
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
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