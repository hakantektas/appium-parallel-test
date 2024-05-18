***Supports***

This project allows you to run parallel tests on iOS and Android devices at the same time. 

In the project 
Appium 2.4.1 , 

Java JDK 21.0.3 , 

Allure Report 2.17.0 , 

TestNG 7.4.0 ,

Appium Java Client 7.6.0 ,

jUnit 4.11 was used.

It supports parallel testing. 

You can run tests simultaneously on IOS, Android physical and emulator, simulator devices.

***Getting Started***

TestNg.xml file contains 5 parameters.

deviceName : Device name 
platformVersion : Device version
udid : udid information of the physical or emulator device
port : If you want to run on how many devices, you must give a port for each one. Appium default port is 4723, in this xml it is given as 4724, 4725 ... by increasing +1 for each device.
app : In the project, separate ipa files for iOS simulator and physical device are included as examples. For Android, a single apk file is used.

Do not forget to set these 5 Appium capability values and check deviceName, platformVersion, udid , port and app values on your testng.xml file.

Ayrıca Proje de mobil App performance testi için sample test senaryosu da mevcut .

bash ```
 @Test
    public void measurePerformanceMetrics() {


        // Get supported performance data types
        List<String> dataTypes = driver.getSupportedPerformanceDataTypes();
        System.out.println("Supported Performance Data Types: ” + dataTypes);
        // Get performance data for CPU
        List<List<Object>> cpuMetrics = driver.getPerformanceData(“app.com.sandjs.bankaccountfakewallet”, “cpuinfo”, 30);
        System.out.println("CPU Metrics: ” + cpuMetrics);

        // Get performance data for memory
        List<List<Object>> memoryMetrics = driver.getPerformanceData(“app.com.sandjs.bankaccountfakewallet”, “memoryinfo”, 30);
        System.out.println("Memory Metrics: ” + memoryMetrics);

        // Get performance data for battery
        List<List<Object>> batteryMetrics = driver.getPerformanceData(“app.com.sandjs.bankaccountfakewallet”, “batteryinfo”, 30);
        System.out.println("Battery Metrics: ” + batteryMetrics);

    }
```

<img width="1302" alt="Screenshot 2024-05-18 at 18 45 46" src="https://github.com/hakantektas/appium-parallel-test/assets/72494835/e168ab68-9e0d-4e00-bbc3-70b9afb3250a">

***Setup and Use***

If you want to run tests on how many devices at the same time, you need to give different port numbers and add mandatory information in Testng.xml.

You can use the following commands to start Appium server via terminal.
appium --port 4723 --use-plugins=device-farm,appium-dashboard --plugin-device-farm-platform=both --log-timestamp --log-level debug

appium --port 4724 --use-plugins=device-farm,appium-dashboard --plugin-device-farm-platform=both --log-timestamp --log-level debug

appium --port 4725 --use-plugins=device-farm,appium-dashboard --plugin-device-farm-platform=both --log-timestamp --log-level debug

appium --port 4726 --use-plugins=device-farm,appium-dashboard --plugin-device-farm-platform=both --log-timestamp --log-level debug

appium --port 4727 --use-plugins=device-farm,appium-dashboard --plugin-device-farm-platform=both --log-timestamp --log-level debug
...

You can review the documents for Appium installation.

https://appium.io/docs/en/latest/quickstart/install/

Appium latest version can be installed with the following command via the terminal.

npm install -g appium@next

**Run the following commands to install Appium drivers**

appium driver install uiautomator2
appium driver install xcuitest
appium driver install espresso
appium driver install mac2

**Run the following commands for Appium plugin installations**

appium plugin install images
appium plugin install execute-driver
appium plugin install relaxed-caps 
appium plugin install appium-dashboard
appium plugin install device-farm

**device-farm :** With Device-Farm plugin, you can monitor all your devices, view available, busy, offline status and device information.

<img width="1722" alt="Screenshot 2024-05-18 at 18 46 43" src="https://github.com/hakantektas/appium-parallel-test/assets/72494835/0ff93daf-eb29-4bee-b25b-a31c03b546a1">


**appium-dashboard :** With Appium Dashboard plugin, you can watch all your test runs live and view their logs.

<img width="1721" alt="Screenshot 2024-05-18 at 18 46 52" src="https://github.com/hakantektas/appium-parallel-test/assets/72494835/bb29cbbb-889d-4229-ad36-35b48b98b1ed">


***Allure Reporting***
 
 Run the following command in project's base directory after test run has been completed. This command will open a browser window with HTML test results.
```
allure serve allure-results
```
<img width="1728" alt="Screenshot 2024-05-18 at 17 49 31" src="https://github.com/hakantektas/appium-parallel-test/assets/72494835/086178a9-9efc-4606-9ef6-cf83bcac9b05">

