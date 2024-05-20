package com.example.project;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.qameta.allure.Attachment;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.net.URL;
import java.util.concurrent.TimeUnit;


@Listeners(value = {AllureTestNg.class})
@Epic("Epic 3")
@Feature("Feature 3")
public class ParallelTestIOSSimulator {

    private IOSDriver<MobileElement> driver;
    @Parameters({"deviceName", "platformVersion","app","udid","port"})
    @BeforeTest
    public void setUp(String deviceName, String platformVersion,String app, String udid, String port) throws Exception {


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
        caps.setCapability("newCommandTimeout", 60);

        // Appium server URL
        URL url = new URL("http://127.0.0.1:" + port);
        driver = new IOSDriver<>(url,caps);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    @Test
    public void sampleCase2() throws InterruptedException {


        MobileElement el1 = driver.findElement(By.id("sort button"));
        el1.click();

        MobileElement el2 = driver.findElementByXPath("//*[contains(@value,'Price - Ascending')]");
        el2.click();

        MobileElement el3 = driver.findElementByAccessibilityId("sort button");
        el3.click();

        MobileElement el4 = driver.findElementByXPath("//*[contains(@value,'Price - Descending')]");
        el4.click();



    }
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
