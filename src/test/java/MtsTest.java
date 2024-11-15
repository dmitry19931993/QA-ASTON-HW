import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MtsTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.mts.by/");
        WebElement acceptCookieButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("cookie-agree"))
        );
        if (acceptCookieButton != null && acceptCookieButton.isDisplayed()){
            acceptCookieButton.click();
        }
    }

    @AfterEach
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

    @Test
    @DisplayName("Checking the block \"Online replenishment without commission\"")
    public void checkTestOnlinePaymentBlockTitle(){
        WebElement paymentSection = driver.findElement(
                By.xpath("//section[@class = 'pay']//div[@class = 'pay__wrapper']//h2")
        );
        String paymentSectionText = paymentSection.getText();
        assertEquals("Онлайн пополнение\nбез комиссии", paymentSectionText);
    }

    @Test
    @DisplayName("Checking the presence of payment system logos")
    public void checkTestPaymentSystemLogos(){
        List<WebElement> logos = driver.findElements(
                By.xpath("//div[@class = 'pay__partners']//ul//li//img")
        );
        String[] expectedLogos = {
                "Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"
        };
        for (int i = 0; i < logos.size(); i++){
            String logoText = logos.get(i).getAttribute("alt");
            assertEquals(expectedLogos[i], logoText);
        }
    }

    @Test
    @DisplayName("Checking the functionality of the link \"More about the service\"")
    public void checkTestLink(){
        WebElement serviceLink = driver.findElement(
                By.xpath("//div[@class = 'pay__wrapper']//a")
        );
        if (serviceLink.isDisplayed()){
            serviceLink.click();
        }
        String currentUrl = driver.getCurrentUrl();
        assertEquals(
                "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                currentUrl
        );
    }

    @Test
    @DisplayName("checking the operation of the \"Continue\" button")
    public void testContinueButton(){
        WebElement connectionPhone = driver.findElement(
                By.xpath("//input[@id = \"connection-phone\"]")
        );
        connectionPhone.sendKeys("336319034");
        WebElement connectionSum = driver.findElement(
                By.xpath("//input[@id = \"connection-sum\"]")
        );
        connectionSum.sendKeys("20");
        WebElement connectionEmail = driver.findElement(
                By.xpath("//input[@id = \"connection-email\"]")
        );
        connectionEmail.sendKeys("mts@mail.ru");
        WebElement continueButton = driver.findElement(By.xpath(
                "//form[@class = \"pay-form opened\"]" +
                        "//button[@class = \"button button__default \"]"
        ));
        if (continueButton != null && continueButton.isDisplayed()){
            continueButton.click();
        }
        driver.switchTo().frame(driver.findElement(
                By.xpath("//iframe[@class = \"bepaid-iframe\"]"))
        );
        WebElement submitButton = driver.findElement(
                By.xpath("//button[@type='submit' and contains(@class, 'colored')]")
        );
        String submitButtonText = submitButton.getAttribute("innerHTML");
        assertEquals(" Оплатить  20.00 BYN <!---->", submitButtonText);
    }
}
