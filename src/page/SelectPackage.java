package page;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;

import test.CommonFunction;

public class SelectPackage {

	CommonFunction commonFunction = new CommonFunction();


	private By startText = By.name("START");
	private By nextText = By.name("NEXT");
	private By dateOption = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.Spinner[1]/android.widget.TextView[1]");
	private By timeOption = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.Spinner[1]/android.widget.TextView[1]");
	private By getLocation = By.name("Click to get current location");


	public void clickStart(AndroidDriver androidDriver){
		commonFunction.click(androidDriver, startText, "Start text");
	}

	public void clickNext(AndroidDriver androidDriver) {
		commonFunction.click(androidDriver, nextText, "Next text");
	}

	public void selectRadioButton(AndroidDriver androidDriver, String Radiobuttontext){
		commonFunction.click(androidDriver, By.name(Radiobuttontext), Radiobuttontext+" radio button");
		commonFunction.click(androidDriver, nextText, "Next text for radiobutton screen");
	}

	public void selectCheckList(AndroidDriver androidDriver, String[] Checklist) {
		for(int i=0; i<Checklist.length; i++)
		{
			commonFunction.click(androidDriver, By.name(Checklist[i]), Checklist[i]+" under checklist");
		}
		commonFunction.click(androidDriver, nextText, "Next text for checklist screen");
	}

	public void selectDate(AndroidDriver androidDriver, String date){
		commonFunction.click(androidDriver, dateOption, "Select Date Option");
		commonFunction.click(androidDriver, By.name(date), date+" selected");
	}

	public void selectTime(AndroidDriver androidDriver, String time) {
		commonFunction.click(androidDriver, timeOption, "Select time Option");
		commonFunction.click(androidDriver, By.name(time), time+" selected");
	}

	public void clickOnGetLocation(AndroidDriver androidDriver) {
		commonFunction.click(androidDriver, getLocation, "Get location option");
	}
}
