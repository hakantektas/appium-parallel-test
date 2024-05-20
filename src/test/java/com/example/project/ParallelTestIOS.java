package com.example.project;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.qameta.allure.Attachment;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.testng.AllureTestNg;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.net.URL;
import java.util.concurrent.TimeUnit;


@Listeners(value = {AllureTestNg.class})
@Epic("Epic 2")
@Feature("Feature 2")
public class ParallelTestIOS {

    private IOSDriver driver;

    @Parameters({"deviceName", "platformVersion","app", "udid","port"})
    @BeforeTest

    public void setUp(String deviceName, String platformVersion,String app ,String udid, String port) throws Exception {


        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", deviceName);
        caps.setCapability("platformVersion", platformVersion);
        caps.setCapability("platformName", "iOS");
        caps.setCapability("udid", udid);
        caps.setCapability("app", app);
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("noReset", true);
        caps.setCapability("fullReset", false);
        caps.setCapability("useNewWDA",false);
        caps.setCapability("newCommandTimeout", "60");

        // Appium server URL
        URL url = new URL("http://127.0.0.1:" + port);
        driver = new IOSDriver<>(url,caps);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        // Appium driver
        // driver = new AndroidDriver<>(url, caps);
    }
    @Test
    public void sampleCase() throws InterruptedException {


        var el1 = driver.findElement(MobileBy.AccessibilityId("5"));
        el1.click();
        var el2 = driver.findElement(MobileBy.AccessibilityId("+"));
        el2.click();
        var el3 = driver.findElement(MobileBy.AccessibilityId("2"));
        el3.click();
        var el4 = driver.findElement(MobileBy.AccessibilityId("="));
        el4.click();

        String val1 = driver.findElement(By.xpath("(//*[contains(@value,'7')])[1]")).getAttribute("value");
        Assert.assertEquals(val1,"7");
    }
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
