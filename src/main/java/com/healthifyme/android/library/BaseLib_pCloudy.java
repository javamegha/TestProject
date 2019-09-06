package com.healthifyme.android.library;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.healthifyme.android.init.GlobalVariables;

import io.appium.java_client.android.AndroidDriver;

public class BaseLib_pCloudy{

	public static GlobalVariables gv = new GlobalVariables();
	/**
	 * Description : This Function launch the app based on capabilities provided by
	 * testng.xml file
	 * 
	 * @param port
	 * @param UDID
	 * @param version
	 * @param deviceName
	 * @throws Exception
	 */
	@Test
	public void _LaunchApp() throws Exception {
		
	
		//** Launch App 
		
		/*DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("pCloudy_Username","srinivas.h@crowdbetatesters.com");
		capabilities.setCapability("pCloudy_ApiKey","tt65yx4dnqc6ccg93s3bdrw6");
		capabilities.setCapability("pCloudy_ApplicationName", "DemoApp.apk");
		capabilities.setCapability("pCloudy_DurationInMinutes", 10);
		capabilities.setCapability("pCloudy_DeviceFullName","Motorola_MotoM_Android_6.0.0");
		capabilities.setCapability("appPackage", "com.healthifyme.basic");
		capabilities.setCapability("appActivity", "com.healthifyme.basic.activities.LaunchActivity");
		System.out.println("Before Initialization");
		gv.iDriver = new AndroidDriver(new URL("https://device.pcloudy.com/appiumcloud/wd/hub"), capabilities);
		System.out.println("After Initialization");*/
		
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("pCloudy_Username","srinivas.h@crowdbetatesters.com");
		capabilities.setCapability("pCloudy_ApiKey","tt65yx4dnqc6ccg93s3bdrw6");
		capabilities.setCapability("pCloudy_ApplicationName", "DemoApp.apk");
		capabilities.setCapability("pCloudy_DurationInMinutes", 60);
		capabilities.setCapability("pCloudy_DeviceFullName","Motorola_MotoE2_Android_6.0.0");
		capabilities.setCapability("appPackage", "com.healthifyme.basic");
		capabilities.setCapability("appActivity", "com.healthifyme.basic.activities.LaunchActivity");
		System.out.println("Before Initialization");
		gv.iDriver = new AndroidDriver(new URL("https://device.pcloudy.com/appiumcloud/wd/hub"), capabilities);
		System.out.println("After Initialization");
		
		
		/*
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("pCloudy_Username","srinivas.h@crowdbetatesters.com");
		capabilities.setCapability("pCloudy_ApiKey","tt65yx4dnqc6ccg93s3bdrw6");
		capabilities.setCapability("pCloudy_ApplicationName", "DemoApp.apk");
		capabilities.setCapability("pCloudy_DurationInMinutes", 60);
		capabilities.setCapability("pCloudy_DeviceFullName","Lenovo_A526_Android_4.2.2");
		System.out.println("Before Initialization");
		gv.iDriver = new AndroidDriver(new URL("https://device.pcloudy.com/appiumcloud/wd/hub"), capabilities);
		System.out.println("After Initialization");*/
	}
	
	
}
