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

TestNg.xml file contains 5 parameters.

deviceName : Device name 
platformVersion : Device version
udid : udid information of the physical or emulator device
port : If you want to run on how many devices, you must give a port for each one. Appium default port is 4723, in this xml it is given as 4724, 4725 ... by increasing +1 for each device.
app : In the project, separate ipa files for iOS simulator and physical device are included as examples. For Android, a single apk file is used.

Do not forget to set these 5 Appium capability values and check deviceName, platformVersion, udid , port and app values on your testng.xml file.



**Allure Reporting**
 
 Run the following command in project's base directory after test run has been completed. This command will open a browser window with HTML test results.
```
allure serve allure-results
```
<img width="1728" alt="Screenshot 2024-05-18 at 17 49 31" src="https://github.com/hakantektas/appium-parallel-test/assets/72494835/086178a9-9efc-4606-9ef6-cf83bcac9b05">

