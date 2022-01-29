package com.TestDevLab.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class Driver {
    private static AppiumDriver driver;
    private static DesiredCapabilities desiredCapabilities;

    private Driver() {


    }

    public static void setUpDriver() {
        String platform = System.getProperty("platform");
        if (platform == null) {
            platform = ConfigurationReader.get("platform");
        }
        platform = platform.toLowerCase();
        switch (platform) {
            case "android":
                desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigurationReader.get("deviceId"));
                desiredCapabilities.setCapability(MobileCapabilityType.UDID, ConfigurationReader.get("deviceId"));
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
                desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "11");
                desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                desiredCapabilities.setCapability("appPackage", ConfigurationReader.get("appPackage"));
                desiredCapabilities.setCapability("appActivity", ConfigurationReader.get("appActivity"));

                try {
                    driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case "ios":
                desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Iphone7");
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
                desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "12.1");
                desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                desiredCapabilities.setCapability("appPackage", "com.huawei.android.launcher");
                desiredCapabilities.setCapability("appActivity", "com.huawei.android.launcher.unihome.UniHomeLauncher");
                try {
                    driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;


        }
    }

    public static AppiumDriver getDriver() {
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }
}





