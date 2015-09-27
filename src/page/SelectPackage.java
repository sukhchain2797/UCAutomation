package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import test.CommonFunction;

public class SelectPackage {

	CommonFunction commonFunction = new CommonFunction();


	private By startText = By.name("START");
	private By nextText = By.name("NEXT");
	private By dateOption = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.Spinner[1]/android.widget.TextView[1]");
	private By timeOption = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.Spinner[1]/android.widget.TextView[1]");
	private By getLocation = By.name("Click to get current location");


	public void clickStart(WebDriver wd){
		commonFunction.click(wd, startText, "Start text");
	}

	public void clickNext(WebDriver wd) {
		commonFunction.click(wd, nextText, "Next text");
	}

	public void selectRadioButton(WebDriver wd, String Radiobuttontext){
		commonFunction.click(wd, By.name(Radiobuttontext), Radiobuttontext+" radio button");
		commonFunction.click(wd, nextText, "Next text for radiobutton screen");
	}

	public void selectCheckList(WebDriver wd, String[] Checklist) {
		for(int i=0; i<Checklist.length; i++)
		{
			commonFunction.click(wd, By.name(Checklist[i]), Checklist[i]+" under checklist");
		}
		commonFunction.click(wd, nextText, "Next text for checklist screen");
	}

	public void selectDate(WebDriver wd, String date){
		commonFunction.click(wd, dateOption, "Select Date Option");
		commonFunction.click(wd, By.name(date), date+" selected");
	}

	public void selectTime(WebDriver wd, String time) {
		commonFunction.click(wd, timeOption, "Select time Option");
		commonFunction.click(wd, By.name(time), time+" selected");
	}

	public void clickOnGetLocation(WebDriver wd) {
		commonFunction.click(wd, getLocation, "Get location option");
	}
}
