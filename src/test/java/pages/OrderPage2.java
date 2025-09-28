package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderPage2 {

    private WebDriver driver;

    // Локаторы элементов
    private By dateField = By.cssSelector("input[placeholder='* Когда привезти самокат']"); // дата для заказа
    private By rentalPeriod = By.className("Dropdown-placeholder"); // срок аренды
    private By colorCheckbox = By.id("grey"); // выбор цвета
    private By commentField = By.cssSelector("input[placeholder='Комментарий для курьера']"); // комментарий для курьера
    private By orderButton = By.cssSelector("button.Button_Button__ra12g.Button_Middle__1CSJM"); // кнопка заказать после ввода всех данных
    private By confirmButton = By.cssSelector("button.Button_Button__ra12g.Button_Middle__1CSJM"); // подтверждение заказа
    private By orderNumber = By.className("Order_Text__2broi"); // всплывающее окно после заказа

    // Конструктор
    public OrderPage2(WebDriver driver) {
        this.driver = driver;
    }

    // Методы взаимодействия с элементами
    public void setDate(String date) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(dateField));
        dateInput.sendKeys(date);
        dateInput.sendKeys("\n"); // Нажимаем Enter для выбора даты
    }

    public void selectRentalPeriod(String period) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement rentalPeriodElement = wait.until(ExpectedConditions.elementToBeClickable(rentalPeriod));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", rentalPeriodElement);
        rentalPeriodElement.click();

        // Выбираем нужное количество дней
        WebElement periodOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='" + period + "']")));
        periodOption.click();
    }

    public void selectColor(String color) {
        driver.findElement(By.id(color)).click(); // Используем переданный цвет
    }

    public void setComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickConfirmButton() {
        driver.findElement(confirmButton).click();
    }

    public String getOrderNumber() {
        return driver.findElement(orderNumber).getText();
    }
}