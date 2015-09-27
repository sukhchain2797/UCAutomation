package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import test.CommonFunction;

public class SearchPage {

	CommonFunction commonFunction = new CommonFunction();

	private By searchTextField = By.name("Search for categories");

	public void searchKeyword(WebDriver wd, String SearchQuery){
		wd.findElement(searchTextField).sendKeys(SearchQuery);

	}

	public void selectFromSuggestions(WebDriver wd, String SearchSuggestion){
		commonFunction.click(wd, By.name(SearchSuggestion), SearchSuggestion+" in search result");
	}

}
