package com.healthifyme.android.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.healthifyme.android.listener.MyExtentListners;
import com.healthifyme.android.util.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage {

	// Android driver instance creation
	AndroidDriver driver;

	public LoginPage(AndroidDriver driver) {

		// Allocate global driver reference to local driver
		this.driver = driver;
		// Initialize Ajax page initialisation
		PageFactory.initElements(driver, this);
	}

	/** Login Screen Section **/

	// LoginBtn
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.healthifyme.basic:id/btn_login']")
	private WebElement eleLoginBtn;

	public WebElement getEleLoginBtn() {
		return eleLoginBtn;
	}

	// UserName Textbox
	@FindBy(xpath ="//android.widget.EditText[@resource-id='com.healthifyme.basic:id/et_username']")
	private WebElement eleUsernameEdtBx;

	public WebElement getEleUsernameEdtBx() {
		return eleUsernameEdtBx;
	}

	//  Password Textbox
	@FindBy(xpath ="//android.widget.EditText[@resource-id='com.healthifyme.basic:id/et_password']")
	private WebElement elePasswordEdtBx;

	public WebElement getElePasswordEdtBx() {
		return elePasswordEdtBx;
	}
	
	//  Login SignUp Button
	@FindBy(xpath ="//android.widget.Button[@resource-id='com.healthifyme.basic:id/btn_login_signup']")
	private WebElement eleLoginSignUpBtn;

	public WebElement getEleLoginSignUpBtn() {
		return eleLoginSignUpBtn;
	}
	
	/** Select email Account */
	
	
	//  Select Email Radio Button

	public WebElement selectEmail(String email) {
		return driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='"+email+"']"));
	}
	
	//Select Account OK button
	@FindBy(xpath ="//android.widget.Button[@text='OK']")
	private WebElement eleSelectEmailOKBtn;

	public WebElement getEleSelectEmailOKBtn() {
		return eleSelectEmailOKBtn;
	}
	
	/*
	 * @author:Srinivas Hippargi
	 * 
	 * Description: Login Method 
	 * 
	 * Params: UserName and Password
	 * 
	 */
	
	public void _login(String username, String password,AndroidDriver driver) throws Exception{
		
		MyExtentListners.test.info("*************LOGIN TEST**************");
		MobileActionUtil.waitForElement(getEleLoginBtn(), driver, "Login Button", 20);
		MobileActionUtil.clickElement(getEleLoginBtn(), driver, "Login Button");
		MobileActionUtil.clearAndType(getEleUsernameEdtBx(), username, " UserName TextBox", driver);
		MobileActionUtil.type(getElePasswordEdtBx(), password, " Password TextBox", driver);
		MobileActionUtil.clickElement(getEleLoginSignUpBtn(), driver, "Login SignUp Button");
		
	}
	
	
	/*
	 * @author:Srinivas Hippargi
	 * 
	 * Description: Login Method 
	 * 
	 * Params: UserName and Password
	 * 
	 */
	
	public void _choseAccount(String email,AndroidDriver driver) throws Exception{
		
		MyExtentListners.test.info("************* CHOOSE ACCOUNT**************");
		MobileActionUtil.waitForElement(selectEmail(email), driver, email + " Account RadioButton", 20);
		MobileActionUtil.clickElement(selectEmail(email), driver, email + " Account RadioButton");
		MobileActionUtil.clickElement(getEleSelectEmailOKBtn(), driver, "Select Account OK Button");
	}
	
	
	
}
