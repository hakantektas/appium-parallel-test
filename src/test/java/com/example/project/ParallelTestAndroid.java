package com.example.project;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.testng.AllureTestNg;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;

@Listeners(value = {AllureTestNg.class})
@Epic("Epic 1")
@Feature("Feature 1")
public class ParallelTestAndroid {

    private AndroidDriver<MobileElement> driver;

    @Parameters({"deviceName", "platformVersion","app", "udid", /*"appPackage", "appActivity",*/"port"})
    @BeforeTest
    public void setUp(String deviceName, String platformVersion,String app, String udid, String port) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", deviceName);
        caps.setCapability("platformVersion", platformVersion);
        caps.setCapability("platformName", "Android");
        caps.setCapability("udid", udid);
        caps.setCapability("app", app);
        // caps.setCapability("appPackage", appPackage);
        // caps.setCapability("appActivity", appActivity);
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("noReset", true);
        caps.setCapability("fullReset", false);
        caps.setCapability("newCommandTimeout", "60");

        // Appium server URL
        URL url = new URL("http://127.0.0.1:" + port);

        // Appium driver
        // driver = new AndroidDriver<>(url, caps);

        driver = new AndroidDriver<>(url,caps);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    @Test
    public void sampleCase() throws InterruptedException {
        driver.findElement(MobileBy.id("username_txt")).sendKeys("demo@mobven.com");
        driver.findElement(MobileBy.id("password_txt")).sendKeys("123456Aa.");
        driver.findElement(MobileBy.id("login_btn")).click();

    }
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }
}
