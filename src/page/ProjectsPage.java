package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import test.CommonFunction;

public class ProjectsPage {

	CommonFunction commonFunction = new CommonFunction();


	private By searchNow = By.name("SEARCH NOW");

	public void searchNowOnprojectsPage(WebDriver wd){
		commonFunction.click(wd, searchNow, "Search Now button on Projects page");
	}

}
