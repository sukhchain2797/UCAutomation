package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import test.CommonFunction;

public class MyProfilePage {

	CommonFunction commonFunction = new CommonFunction();


	private By logOut = By.name("Logout");

	public void clickLogout(WebDriver wd) {
		commonFunction.click(wd, logOut, "LogOut option on my profile");
	}

}
