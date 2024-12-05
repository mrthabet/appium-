package appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class waitclass {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // إعداد Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android"); 
        caps.setCapability("deviceName", "emulator-5554"); 
        caps.setCapability("app", "C:\\Users\\HP\\Downloads\\Calculator_8.6.1_APKPure.apk"); // مسار التطبيق
        caps.setCapability("automationName", "UiAutomator2");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testMultiply() {
        
        WebElement button5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageButton[@content-desc=\"5\"]")));
        button5.click();

        WebElement multiplyButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageButton[@content-desc=\"multiply\"]")));
        multiplyButton.click();

        WebElement button7 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageButton[@content-desc=\"7\"]")));
        button7.click();

        WebElement equalsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageButton[@content-desc=\"equals\"]")));
        equalsButton.click();

       // WebElement resultElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("result")));
       // String result = resultElement.getText();

        //Assert.assertEquals(result, "35", "Expected result to be 35, but found: " + result);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
