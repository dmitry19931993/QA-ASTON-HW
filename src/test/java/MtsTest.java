import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import steps.MtsMainPageSteps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static steps.DriverInstance.*;

public class MtsTest {

    private MtsMainPageSteps steps;

    @BeforeEach
    public void setUp() {
        driver = getInstance();
        steps = new MtsMainPageSteps(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.mts.by/");
        WebElement acceptCookieButton = driver.findElement(By.id("cookie-agree"));
        if (acceptCookieButton != null && acceptCookieButton.isDisplayed()){
            acceptCookieButton.click();
        }
    }

    @AfterEach
    public void tearDown(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }

    @Test
    @DisplayName("Проверка плейсхолдеров на странице «Услуги связи»")
    public void checkTestCommunicationServicesPlaceholders() {
        List<String> expectedPlaceholders = new ArrayList<>(
                Arrays.asList("Номер телефона", "Сумма", "E-mail для отправки чека")
        );
        steps.chooseCommunicationServiceButton();
        List<String> placeholders = steps.getInputsPlaceholders();
        assertIterableEquals(expectedPlaceholders, placeholders);
    }

    @Test
    @DisplayName("Проверка плейсхолдеров на странице «Домашний интернет»")
    public void checkTestHomeInternetPlaceholders() {
        List<String> expectedPlaceholders = new ArrayList<>(
                Arrays.asList("Номер абонента", "Сумма", "E-mail для отправки чека")
        );
        steps.chooseHomeInternetButton();
        List<String> placeholders = steps.getInputsPlaceholders();
        assertIterableEquals(expectedPlaceholders, placeholders);
    }


    @Test
    @DisplayName("Проверка плейсхолдеров на странице «Рассрочка»")
    public void checkTestCreditPlaceholders() {
        List<String> expectedPlaceholders = new ArrayList<>(
                Arrays.asList("Номер счета на 44", "Сумма", "E-mail для отправки чека")
        );
        steps.chooseCreditButton();
        List<String> placeholders = steps.getInputsPlaceholders();
        assertIterableEquals(expectedPlaceholders, placeholders);
    }


    @Test
    @DisplayName("Проверка плейсхолдеров на странице «Задолженность»")
    public void checkTestDebtPlaceholders() {
        List<String> expectedPlaceholders = new ArrayList<>(
                Arrays.asList("Номер счета на 2073", "Сумма", "E-mail для отправки чека")
        );
        steps.chooseDebtButton();
        List<String> placeholders = steps.getInputsPlaceholders();
        assertIterableEquals(expectedPlaceholders, placeholders);
    }

    @Test
    @DisplayName("Проверка корректности отображения суммы в появившемся окне")
    public void testIframeSumText() {
        steps.sendInputs();
        String iframeSumText = steps.getIframeSumText();
        assertEquals("20.00 BYN", iframeSumText);
    }

    @Test
    @DisplayName("Проверка корректности отображения суммы на кнопке оплаты")
    public void testIframeSumButtonText() {
        steps.sendInputs();
        String iframeSumButtonText = steps.getIframeSumButtonText();
        assertEquals(" Оплатить  20.00 BYN <!---->", iframeSumButtonText);
    }

    @Test
    @DisplayName("Проверка корректности отображения номера телефона в появившемся окне")
    public void testIframePhoneNumberText() {
        steps.sendInputs();
        String iframePhoneText = steps.getIframePhoneText();
        assertEquals("Оплата: Услуги связи\nНомер:375336319034", iframePhoneText);
    }

    @Test
    @DisplayName("Проверка плейсхолдеров во фрейме на странице «Услуги связи»")
    public void testIframeCommunicationServicesPlaceholders() {
        List<String> expectedPlaceholders = new ArrayList<>(Arrays.asList(
                        "Номер карты", "Имя держателя (как на карте)", "Срок действия", "CVC"
                ));
        steps.sendInputs();
        List<String> placeholders = steps.getIframeInputsPlaceholders();
        assertIterableEquals(expectedPlaceholders, placeholders);
    }

    @Test
    @DisplayName("Проверка наличия иконок платежных систем во фрейме на странице «Услуги связи»")
    public void testIframeCommunicationServicesIcons() {
        List<String> expectedIcons = new ArrayList<>(Arrays.asList(
                "visa-system", "mastercard-system", "belkart-system"
        ));
        steps.sendInputs();
        List<String> icons = steps.getIframeIconsName();
        assertIterableEquals(expectedIcons, icons);
    }
}

