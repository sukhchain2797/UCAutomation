package page;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;

import test.CommonFunction;

public class MyProfilePage {

	CommonFunction commonFunction = new CommonFunction();


	private By logOut = By.name("Logout");

	public void clickLogout(AndroidDriver androidDriver) {
		commonFunction.click(androidDriver, logOut, "LogOut option on my profile");
	}

}
