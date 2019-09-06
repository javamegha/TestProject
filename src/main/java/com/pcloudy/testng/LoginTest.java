package com.pcloudy.testng;

import org.testng.annotations.Test;

import com.healthifyme.android.library.BaseLib;
import com.healthifyme.android.library.BaseLib_pCloudy;
import com.healthifyme.android.library.GenericLib;
import com.healthifyme.android.listener.MyExtentListners;
import com.healthifyme.android.pages.LoginPage;
import com.healthifyme.android.pages.TasksPage;

public class LoginTest extends BaseLib_pCloudy{
	
	/**
	 * 
	 * @author Srinivas Hippargi
	 * 
	 * @description Login to app and add milk as meal to breakfast
	 * 
	 * @category Smoke
	 * 
	 * @param username passwork and mealtype
	 * */
	
	@Test(enabled=true,priority=1,description=" Login to app and add milk as meal to breakfast")
	public void _loginTest() throws Exception {
		
		
		
		// Extent Report information
		MyExtentListners.test.assignCategory("ADD_MEAL_TO_BREAKFAST");
		MyExtentListners.test.pass("HealthifyMe app has launched");
		// Login to App
		LoginPage lp=new LoginPage(gv.iDriver);
		System.out.println(gv.iDriver.getContext());
		String username=GenericLib.getProprtyValue(GenericLib.sUserCredFile, "USERNAME");
		String password=GenericLib.getProprtyValue(GenericLib.sUserCredFile, "PASSWORD");
		lp._login(username,password,gv.iDriver);
		String selectEmail=GenericLib.getProprtyValue(GenericLib.sUserCredFile, "CHOOSEEMAIL");
		// Select Account
		lp._choseAccount(selectEmail, gv.iDriver);
		String meal=GenericLib.getProprtyValue(GenericLib.sUserCredFile, "MEAL");
		// Add Meal To Breakfast
		TasksPage tp=new TasksPage(gv.iDriver);
		tp._addMealToBreakFast(meal,gv.iDriver);
	}

}
