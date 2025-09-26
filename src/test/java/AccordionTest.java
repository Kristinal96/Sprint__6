package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import pages.MainPage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccordionTest {

    private WebDriver driver;
    private MainPage mainPage;


    @BeforeEach
    void setUp() {
        // Инициализация Chrome с опциями
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage = new MainPage(driver);
    }

    @Test
    void testAccordion() {
        // Нажимаем на стрелочку
        mainPage.clickAccordion();

        // Проверяем, что текст открылся
        WebElement accordionText = driver.findElement(By.id("accordion__panel-1"));
        assertTrue(accordionText.isDisplayed(), "Текст не открылся");

        // Проверяем, что текст содержит ожидаемое значение
        String expectedText = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        String actualText = accordionText.getText();
        assertEquals(expectedText, actualText, "Текст не соответствует ожидаемому значению");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}