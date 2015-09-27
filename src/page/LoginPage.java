package page;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import test.CommonFunction;

public class LoginPage {

	CommonFunction commonFunction = new CommonFunction();

	private By signUpOption = By.name("SIGN UP");
	private By signUpName = By.name("Name");
	private By mobileNumberField = By.name("Mobile Number");
	private By signUpEmailId = By.name("Email Id");
	private By signUpButton = By.id("com.urbanclap.urbanclap:id/bt_signup");
	private By loginOnLoginScreen = By.name("      LOG IN");
	private By loginButton = By.name("LOG IN");
	private By loginWithFacebook = By.name("Log in with Facebook");


	public void signUp(AndroidDriver androidDriver, String Name, String Number, String Email) {
		commonFunction.click(androidDriver, signUpOption, "Sign Up option on Login Screen");
		androidDriver.findElement(signUpName).sendKeys(Name);
		commonFunction.hideKeyboard(androidDriver);
		androidDriver.findElement(mobileNumberField).sendKeys(Number);
		commonFunction.hideKeyboard(androidDriver);
		androidDriver.findElement(signUpEmailId).sendKeys(Email);
		commonFunction.hideKeyboard(androidDriver);
		commonFunction.click(androidDriver, signUpButton, "Sign Up button on Sign up screen");

	}

	public void signIn(AndroidDriver androidDriver, String Number) {
		commonFunction.click(androidDriver, loginOnLoginScreen, "Log In option on Login Screen");
		androidDriver.findElement(mobileNumberField).sendKeys(Number);
		commonFunction.click(androidDriver, loginButton, "Log In button on Login Screen");

	}

	public void loginWithFacebook(AndroidDriver androidDriver) {
		commonFunction.click(androidDriver, loginWithFacebook, "Log In with facebook option on Login Screen");
	}

}
