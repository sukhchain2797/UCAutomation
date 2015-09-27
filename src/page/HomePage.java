package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import test.CommonFunction;

public class HomePage {

	CommonFunction commonFunction = new CommonFunction();

	private By projectsCategory = By.name("PROJECTS");
	private By overFlowMenu = By.name("More options");
	private By loginInOverflowMenu = By.name("Login");
	private By myProfileInOverflowMenu = By.name("My Profile");

	public void selectProjectCategory(WebDriver wd) {
		commonFunction.click(wd, projectsCategory, "Projects text on Home screen");
	}


	public void clickLoginFromOverflowMenu(WebDriver wd) {
		commonFunction.click(wd, overFlowMenu, "Overflow Menu on home screen");
		commonFunction.click(wd, loginInOverflowMenu, "Log In text in overflow menu");
	}

	public void clickMyProfileFromOverflowMenu(WebDriver wd) {
		commonFunction.click(wd, overFlowMenu, "Overflow Menu on home screen");
		commonFunction.click(wd, myProfileInOverflowMenu, "My profile in Overflow menu");
	}
}
