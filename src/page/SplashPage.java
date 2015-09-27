package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import test.CommonFunction;

public class SplashPage {

	CommonFunction commonFunction = new CommonFunction();


	private By skipAppTour = By.name("SKIP");

	public void clickOnSkip(WebDriver wd){
		commonFunction.click(wd, skipAppTour, "Skip button");
	}

	public void selectCity(WebDriver wd, String city){
		commonFunction.click(wd, By.name(city), city+" under cities");
	}

}
