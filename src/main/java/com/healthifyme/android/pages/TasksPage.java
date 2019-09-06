package com.healthifyme.android.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.healthifyme.android.listener.MyExtentListners;
import com.healthifyme.android.util.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class TasksPage {

	// Android driver instance creation
	AndroidDriver driver;

	public TasksPage(AndroidDriver driver) {

		// Allocate global driver reference to local driver
		this.driver = driver;
		// Initialize Ajax page initialisation
		PageFactory.initElements(driver, this);
	}

	/** TASKS | Me Screen Section **/

	// Me Tab
	@FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Leaderboard screen']")
	private WebElement eleMeTab;

	public WebElement getEleMeTab() {
		return eleMeTab;
	}

	// Food Objective Tab
	@FindBy(xpath = "//android.widget.LinearLayout[@instance='11']")
	private WebElement eleFoodObjectiveSectionBnr;

	public WebElement getEleFoodObjectiveSectionBnr() {
		return eleFoodObjectiveSectionBnr;
	}

	// BreakFast Meal Tab
	@FindBy(xpath = "//android.widget.TextView[@text='Breakfast']")
	private WebElement eleBreakFastMealTypeTab;

	public WebElement getEleBreakFastMealTypeTab() {
		return eleBreakFastMealTypeTab;
	}

	// Meal Search Box
	@FindBy(xpath = "//android.widget.EditText[@resource-id='com.healthifyme.basic:id/et_search']")
	private WebElement eleMealSearchTxtbx;

	public WebElement getEleMealSearchTxtbx() {
		return eleMealSearchTxtbx;
	}

	// Add Milk + Icon
	@FindBy(xpath = "//android.widget.TextView[@text='Milk']/..//android.widget.ImageView[@resource-id='com.healthifyme.basic:id/iv_expand_icon']")
	private WebElement eleAddMilkIcn;

	public WebElement getEleAddMilkIcn() {
		return eleAddMilkIcn;
	}

	// Add To BreakFast Button
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.healthifyme.basic:id/btn_add']")
	private WebElement eleAddToBreakFastBtn;

	public WebElement getEleAddToBreakFastBtn() {
		return eleAddToBreakFastBtn;
	}

	// Searched Milk Auto Suggestions
	@FindBy(xpath = "//android.widget.TextView[@text='Milk']")
	private WebElement eleSearchedMilkOption;

	public WebElement getEleSearchedMilkOption() {
		return eleSearchedMilkOption;
	}

	/*** Verification **/

	// Milk Added For Breakfast
	@FindBy(xpath = "//android.widget.TextView[@text='Breakfast']")
	private WebElement eleBreakFastTxt;

	public WebElement getEleBreakFastxt() {
		return eleBreakFastTxt;
	}

	// Milk Added For Breakfast
	@FindBy(xpath = "//android.widget.TextView[@text='Milk']")
	private WebElement eleBreakFastMilkTxt;

	public WebElement getEleBreakFastMilkTxt() {
		return eleBreakFastMilkTxt;
	}
	
	//Done Button
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.healthifyme.basic:id/btn_done']")
	private WebElement eleDoneBtn;

	public WebElement getEleDoneBtn() {
		return eleDoneBtn;
	}
	
	//Food Objetive Validation
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.healthifyme.basic:id/tv_card_title']/../..//android.widget.ImageView[@resource-id='com.healthifyme.basic:id/ll_objective_done']")
	private WebElement eleObjectiveDoneTxt;

	public WebElement getEleObjectiveDoneTxt() {
		return eleObjectiveDoneTxt;
	}
	
	public WebElement getFoodDoneObjective(String message) {
		return driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+message+"')]/../..//android.widget.ImageView[@resource-id='com.healthifyme.basic:id/ll_objective_done']"));
	}
	
	
	/**
	 * @author:Srinivas Hippargi
	 * 
	 * Description: Add Meal to Breakfast and Validate
	 * 
	 * @param mealtype,foodtype
	 * 
	 */

	public void _addMealToBreakFast(String meal, AndroidDriver driver) throws Exception {

		MyExtentListners.test.info("************ADD MEAL TO BREAKFAST**************");
		MobileActionUtil.waitForElement(getEleMeTab(), driver, "Me Button", 20);
		MobileActionUtil.clickElement(getEleMeTab(), driver, "Me Button");
		MobileActionUtil.swipeBottomToTop(1, driver, .70, .20);
		MobileActionUtil.clickElement(getEleFoodObjectiveSectionBnr(), driver, "Food Objective Button");
		MobileActionUtil.clickElement(getEleBreakFastMealTypeTab(), driver, " BreakFast Meal Type");
		MobileActionUtil.type(getEleMealSearchTxtbx(), meal, " Meal Search Box", driver);
		MobileActionUtil.clickElement(getEleSearchedMilkOption(), driver, meal);
		MobileActionUtil.clickElement(getEleAddToBreakFastBtn(), driver, " Add To BreakFast");
		MobileActionUtil.waitForElement(getEleBreakFastxt(), driver, "Meal Type", 20);
		
		/** Verify Meal Type And Food Name*/
		
		String expectedMeal = getEleBreakFastxt().getText();
		MobileActionUtil.verifyEqualsText(" Meal Type : ", "Breakfast", expectedMeal);
		String expectedFood = getEleBreakFastMilkTxt().getText();
		MobileActionUtil.verifyEqualsText(" Food Name : ", "Milk", expectedFood);
		MobileActionUtil.clickElement(getEleDoneBtn(), driver, " Done");
		MobileActionUtil.clickElement(getEleMeTab(), driver, "Me Tab");
		MobileActionUtil.waitForElement(getEleObjectiveDoneTxt(), driver, " Objective Done!", 10);
		//String expectedObjectiveDone=getEleObjectiveDoneTxt().getText();
		MobileActionUtil.verifyElementIsDisplayed(getFoodDoneObjective("Food"), driver, " Food Objective Done! Logo");
		//MobileActionUtil.isEleDisplayed(getFoodDoneObjective("Food"), driver, "Food Object Done");
		MyExtentListners.test.info("************MEAL ADDED TO BREAKFAST**************");
		
	}

}
