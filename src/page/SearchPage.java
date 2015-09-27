package page;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;

import test.CommonFunction;

public class SearchPage {

	CommonFunction commonFunction = new CommonFunction();

	private By searchTextField = By.name("Search for categories");

	public void searchKeyword(AndroidDriver androidDriver, String SearchQuery){
		androidDriver.findElement(searchTextField).sendKeys(SearchQuery);

	}

	public void selectFromSuggestions(AndroidDriver androidDriver, String SearchSuggestion){
		commonFunction.click(androidDriver, By.name(SearchSuggestion), SearchSuggestion+" in search result");
	}

}
