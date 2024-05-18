package com.example.project;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Attachment;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@Listeners(value = {AllureTestNg.class})
@Epic("Epic 2")
@Feature("Feature 2")
public class AppPerformanceTest {

    private AndroidDriver driver;
    @Parameters({"deviceName", "platformVersion","app","udid", /*"appPackage", "appActivity",*/"port"})
    @BeforeTest
    public void setUp(String deviceName, String platformVersion,String app, String udid, String port) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", deviceName);
        caps.setCapability("platformVersion", platformVersion);
        caps.setCapability("udid", udid);
        caps.setCapability("app", app);
        // caps.setCapability("appPackage", appPackage);
        // caps.setCapability("appActivity", appActivity);
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("noReset", false);
        caps.setCapability("fullReset", true);
        caps.setCapability("newCommandTimeout", 60);

        // Appium server URL
        URL url = new URL("http://127.0.0.1:" + port);


        driver = new AndroidDriver<>(url,caps);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    @Test
    public void sampleCase() throws InterruptedException {
        driver.findElement(MobileBy.id("username_txt")).sendKeys("demo@mobven.com");
        driver.findElement(MobileBy.id("password_txt")).sendKeys("123456Aa.");
        driver.findElement(MobileBy.id("login_btn")).click();

    }
    @Test
    public void measurePerformanceMetrics() {


        // Get supported performance data types
        List<String> dataTypes = driver.getSupportedPerformanceDataTypes();
        System.out.println("Supported Performance Data Types: " + dataTypes);
        // Get performance data for CPU
        List<List<Object>> cpuMetrics = driver.getPerformanceData("app.com.sandjs.bankaccountfakewallet", "cpuinfo", 30);
        System.out.println("CPU Metrics: " + cpuMetrics);

        // Get performance data for memory
        List<List<Object>> memoryMetrics = driver.getPerformanceData("app.com.sandjs.bankaccountfakewallet", "memoryinfo", 30);
        System.out.println("Memory Metrics: " + memoryMetrics);

        // Get performance data for battery
        List<List<Object>> batteryMetrics = driver.getPerformanceData("app.com.sandjs.bankaccountfakewallet", "batteryinfo", 30);
        System.out.println("Battery Metrics: " + batteryMetrics);

    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }
}
