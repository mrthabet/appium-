package appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestMultiply {
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // إعداد Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android"); 
        caps.setCapability("deviceName", "emulator-5554"); 
        caps.setCapability("app", "C:\\Users\\HP\\Downloads\\Calculator_8.6.1_APKPure.apk"); // مسار التطبيق
        caps.setCapability("automationName", "UiAutomator2");

        // إنشاء AndroidDriver مع Appium Server
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }

    @Test
    public void testMultiply() throws InterruptedException {
        // الضغط على الرقم 5
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"5\"]\r\n"+ "")).click();
        Thread.sleep(6000);

        // الضغط على علامة الضرب
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"multiply\"]")).click();
        Thread.sleep(6000);

        // الضغط على الرقم 7
        driver.findElement(By.xpath("	//android.widget.ImageButton[@content-desc=\"7\"]")).click();
        Thread.sleep(6000);
        // الضغط على علامة يساوي
        driver.findElement(By.xpath("	//android.widget.ImageButton[@content-desc=\"equals\"]")).click();
        Thread.sleep(6000);
        // الحصول على النتيجة
       // String result = driver.findElement(By.id("result")).getText();

        // التحقق من أن النتيجة هي 35
       // Assert.assertEquals(result, "35", "Expected result to be 35, but found: " + result);
    }

   // @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}



