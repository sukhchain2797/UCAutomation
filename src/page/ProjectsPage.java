package page;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;

import test.CommonFunction;

public class ProjectsPage {

	CommonFunction commonFunction = new CommonFunction();


	private By searchNow = By.name("SEARCH NOW");

	public void searchNowOnprojectsPage(AndroidDriver androidDriver){
		commonFunction.click(androidDriver, searchNow, "Search Now button on Projects page");
	}

}
