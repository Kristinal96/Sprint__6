package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderPage1 {

    private WebDriver driver;

    // Локаторы элементов
    private By nameField = By.cssSelector("input[placeholder='* Имя']"); // ввод имени для заказа
    private By surnameField = By.cssSelector("input[placeholder='* Фамилия']"); // ввод фамилии для заказа
    private By addressField = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']"); // ввод адреса для заказа
    private By metroField = By.cssSelector("input[placeholder='* Станция метро']"); // выбор станции метро
    private By phoneField = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']"); // телефон для заказа
    private By nextButton = By.cssSelector("button.Button_Button__ra12g.Button_Middle__1CSJM"); // кнопка далее после корретного ввода полей

    // Конструктор
    public OrderPage1(WebDriver driver) {
        this.driver = driver;
    }

    // Методы взаимодействия с элементами
    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void setMetro(String metro) {
        WebElement metroInput = driver.findElement(metroField);
        metroInput.click(); // Нажимаем на поле ввода станции метро
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement metroOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='" + metro + "']")));
        metroOption.click(); // Выбираем станцию из выпадающего списка
    }

    public void setPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
}