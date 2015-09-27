package page;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;

import test.CommonFunction;

public class SplashPage {

	CommonFunction commonFunction = new CommonFunction();


	private By skipAppTour = By.name("SKIP");

	public void clickOnSkip(AndroidDriver androidDriver){
		commonFunction.click(androidDriver, skipAppTour, "Skip button");
	}

	public void selectCity(AndroidDriver androidDriver, String city){
		commonFunction.click(androidDriver, By.name(city), city+" under cities");
	}

}
