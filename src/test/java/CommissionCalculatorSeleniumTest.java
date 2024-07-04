import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommissionCalculatorSeleniumTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Đường dẫn đến chromedriver, hãy thay đổi theo đường dẫn trên hệ thống của bạn
        System.setProperty("webdriver.chrome.driver", "D:\\FULearning\\Ky5\\SWT301\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Cấu hình ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testCalculateCommission() throws InterruptedException {
        driver.get("http://localhost:8080/Assigment2_CalculatingCommissions/commission");
        Thread.sleep(3000); // Thêm độ trễ để trang tải đầy đủ

        WebElement isSalaried = driver.findElement(By.id("isSalaried"));
        WebElement itemPrice = driver.findElement(By.id("itemPrice"));
        WebElement itemType = driver.findElement(By.id("itemType"));
        WebElement customerType = driver.findElement(By.id("customerType"));

        isSalaried.click(); // Đánh dấu checkbox
        Thread.sleep(3000); // Thêm độ trễ để quan sát
        itemPrice.sendKeys("5000");
        Thread.sleep(3000); // Thêm độ trễ để quan sát
        itemType.sendKeys("OTHER");
        Thread.sleep(3000); // Thêm độ trễ để quan sát
        customerType.sendKeys("NON_REGULAR");
        Thread.sleep(3000); // Thêm độ trễ để quan sát

        driver.findElement(By.tagName("form")).submit();
        Thread.sleep(3000); // Thêm độ trễ để quan sát

        WebElement commissionResult = driver.findElement(By.tagName("p"));
        String resultText = commissionResult.getText();
        System.out.println("Actual Commission Text: " + resultText);
        assertTrue(resultText.contains("Commission: 0.0"));
    }
}