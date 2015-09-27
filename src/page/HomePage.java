package page;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import test.CommonFunction;

public class HomePage {

	CommonFunction commonFunction = new CommonFunction();

	private By projectsCategory = By.name("PROJECTS");
	private By overFlowMenu = By.name("More options");
	private By loginInOverflowMenu = By.name("Login");
	private By myProfileInOverflowMenu = By.name("My Profile");

	public void selectProjectCategory(AndroidDriver androidDriver) {
		commonFunction.click(androidDriver, projectsCategory, "Projects text on Home screen");
	}


	public void clickLoginFromOverflowMenu(AndroidDriver androidDriver) {
		commonFunction.click(androidDriver, overFlowMenu, "Overflow Menu on home screen");
		commonFunction.click(androidDriver, loginInOverflowMenu, "Log In text in overflow menu");
	}

	public void clickMyProfileFromOverflowMenu(AndroidDriver androidDriver) {
		commonFunction.click(androidDriver, overFlowMenu, "Overflow Menu on home screen");
		commonFunction.click(androidDriver, myProfileInOverflowMenu, "My profile in Overflow menu");
	}
}
