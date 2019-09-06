/***********************************************************************
* @author 				:		Srinivas Hippargi
* @description			: 		Implemented Application Precondition and Postconditions
* @Variables			: 	  	Declared and Initialised AndroidDriver and WebDriver, Instance for GlobalVariables Page
* @BeforeSuiteMethod	: 		DB connection for xyz
* @BeforeTest			: 		Desired Capabilities for launching app and launching portal		
*/

package com.healthifyme.android.library;

import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.healthifyme.android.init.GlobalVariables;

import io.appium.java_client.android.AndroidDriver;

public class BaseLib{

	public static GlobalVariables gv = new GlobalVariables();

	/*
	 * Read Parameters from Jenkins
	 */

	static {

		if (gv.sUDID != null) {
			gv.iPort = Integer.parseInt(System.getProperty("PORT"));
			gv.sUDID = System.getProperty("UDID");
			gv.sPlatformVersion = System.getProperty("VERSION");
			gv.sDeviceName = System.getProperty("DEVICENAME");
			gv.sXcodeOrgId= System.getProperty("XCODEORGID");
			
		} else {

			int rowCount = ExcelLibrary.getExcelRowCount(GenericLib.sConfigPath, "config");
			System.out.println(" Total Row Count ============> " + rowCount);
			ArrayList<String> deviceCount = new ArrayList<String>();
			int runStatus = GenericLib.getHeaderColumnIndex(GenericLib.sConfigPath, "config", "Run Status");
			for (int i = 1; i <= rowCount; i++) {

				if (ExcelLibrary.getExcelData(GenericLib.sConfigPath, "config", i, runStatus).equalsIgnoreCase("Yes")) {
					// System.out.println(i);
					deviceCount.add(ExcelLibrary.getExcelData(GenericLib.sConfigPath, "config", i, runStatus));
				}
			}
			System.out.println(deviceCount.size());

			if (String.valueOf(deviceCount.size()).equalsIgnoreCase("1")) {
				for (int i = 1; i <= rowCount; i++) {

					if (ExcelLibrary.getExcelData(GenericLib.sConfigPath, "config", i, runStatus)
							.equalsIgnoreCase("Yes")) {

						int port = GenericLib.getHeaderColumnIndex(GenericLib.sConfigPath, "config", "Port");
						int udid = GenericLib.getHeaderColumnIndex(GenericLib.sConfigPath, "config", "Device UDID");
						int devName = GenericLib.getHeaderColumnIndex(GenericLib.sConfigPath, "config", "Device Name");
						int devVersion = GenericLib.getHeaderColumnIndex(GenericLib.sConfigPath, "config",
								"Device Version");
						int xcodeOrgId = GenericLib.getHeaderColumnIndex(GenericLib.sConfigPath, "config", "Xcode_Org_Id");
						gv.iPort = Integer
								.parseInt(ExcelLibrary.getExcelData(GenericLib.sConfigPath, "config", i, port).trim());
						gv.sUDID = ExcelLibrary.getExcelData(GenericLib.sConfigPath, "config", i, udid).trim();
						gv.sDeviceName = ExcelLibrary.getExcelData(GenericLib.sConfigPath, "config", i, devName).trim();
						gv.sPlatformVersion = ExcelLibrary.getExcelData(GenericLib.sConfigPath, "config", i, devVersion).trim();
		

					}
				}
			} else {

				System.out.println("************PLEASE SELECT ONE DEVICE IN CONFIG******************");
			}
		}
	}

	/*
	 * This method initializes the database variables that requires to connect to
	 * the database before suite
	 */

	@BeforeSuite
    public void before_suite() throws Exception {

      }
	
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
	@BeforeMethod
	public void _LaunchApp() throws Exception {
		
	
		//** Launch App 
		
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion",gv.sPlatformVersion);
		cap.setCapability("deviceName", gv.sDeviceName);
		cap.setCapability("udid", gv.sUDID);
		cap.setCapability("appPackage", "com.healthifyme.basic");
		cap.setCapability("appActivity", "com.healthifyme.basic.activities.LaunchActivity");
		cap.setCapability("fullReset", false);
		cap.setCapability("noReset", false);
		cap.setCapability("autoGrantPermissions", true);
		cap.setCapability("autoAcceptAlerts", true);
		cap.setCapability("newCommandTimeout", 30000);
		gv.iDriver = new AndroidDriver(new URL("http://127.0.0.1:" + gv.iPort + "/wd/hub"), cap);
		gv.iDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		
	}
	@AfterSuite
	public void OracleCloseConnection() throws Exception {
		
		//gv.iDriver.quit();
		System.out.println("----------Driver Session Closed---------");

	}

}
