package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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


	public void signUp(WebDriver wd, String Name, String Number, String Email) {
		commonFunction.click(wd, signUpOption, "Sign Up option on Login Screen");
		wd.findElement(signUpName).sendKeys(Name);
		commonFunction.hideKeyboard();
		wd.findElement(mobileNumberField).sendKeys(Number);
		commonFunction.hideKeyboard();
		wd.findElement(signUpEmailId).sendKeys(Email);
		commonFunction.hideKeyboard();
		commonFunction.click(wd, signUpButton, "Sign Up button on Sign up screen");

	}

	public void signIn(WebDriver wd, String Number) {
		commonFunction.click(wd, loginOnLoginScreen, "Log In option on Login Screen");
		wd.findElement(mobileNumberField).sendKeys(Number);
		commonFunction.click(wd, loginButton, "Log In button on Login Screen");

	}

	public void loginWithFacebook(WebDriver wd) {
		commonFunction.click(wd, loginWithFacebook, "Log In with facebook option on Login Screen");
	}

}
