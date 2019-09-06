package com.healthifyme.android.init;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class GlobalVariables implements TestDataCoulmns {

	public AndroidDriver iDriver;
	public DesiredCapabilities capabilities;
	public int iPort;
	public String sUDID;
	public String sPlatformVersion;
	public String sDeviceName;
	public String sAutomationName;
	public String sXcodeOrgId;

	// Property Files Values
	
}