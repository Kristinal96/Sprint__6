package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.MainPage;
import pages.OrderPage1;
import pages.OrderPage2;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderTest2 {

    private WebDriver driver;
    private pages.MainPage mainPage;
    private pages.OrderPage1 orderPage1;
    private pages.OrderPage2 orderPage2;

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage = new pages.MainPage(driver);
        orderPage1 = new pages.OrderPage1(driver);
        orderPage2 = new pages.OrderPage2(driver);
        mainPage.closeCookieConsent(); // Закрываем всплывающее окно с согласием на использование файлов cookie
    }

    @ParameterizedTest
    @MethodSource("orderDataProvider")
    void testOrderFlow(String name, String surname, String address, String metro, String phone, String date, String rentalPeriod, String color, String comment) {
        // Нажать кнопку «Заказать» внизу страницы
        mainPage.clickOrderButtonBottom();

        // Заполнить форму заказа
        orderPage1.setName(name);
        orderPage1.setSurname(surname);
        orderPage1.setAddress(address);
        orderPage1.setMetro(metro);
        orderPage1.setPhone(phone);
        orderPage1.clickNextButton();

        // Заполнить вторую страницу заказа
        orderPage2.setDate(date);
        orderPage2.selectRentalPeriod(rentalPeriod);
        orderPage2.selectColor(color);
        orderPage2.setComment(comment);
        orderPage2.clickOrderButton();
        orderPage2.clickConfirmButton();

        // Проверить, что появилось всплывающее окно с сообщением об успешном создании заказа
        String orderNumberText = orderPage2.getOrderNumber();
        assertTrue(orderNumberText.contains("Номер заказа"), "Текст не содержит номер заказа");
    }

    static Stream<Arguments> orderDataProvider() {
        return Stream.of(
                Arguments.of("Иван", "Иванов", "Москва, ул. Ленина, 1", "Бульвар Рокоссовского", "+79991234567", "15.10.2023", "сутки", "grey", "Пожалуйста, позвоните заранее"),
                Arguments.of("Петр", "Петров", "Санкт-Петербург, ул. Пушкина, 2", "Бульвар Рокоссовского", "+79997654321", "16.04.2024", "сутки", "grey", "Оставьте у двери")
        );
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}