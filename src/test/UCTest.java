package test;

import org.apache.commons.exec.ExecuteException;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.HomePage;
import page.LoginPage;
import page.MyProfilePage;
import page.ProjectsPage;
import page.SearchPage;
import page.SelectPackage;
import page.SplashPage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class UCTest {

	private SplashPage splashPage = new SplashPage();

	private WebDriver webDriver;

	private Logger log = Logger.getLogger(UCTest.class.getName());
	private CommonFunction commonFunction = new CommonFunction();
	private HomePage homePage= new HomePage();
	private LoginPage loginPage = new LoginPage();
	private MyProfilePage myProfilePage = new MyProfilePage();
	private ProjectsPage projectsPage = new ProjectsPage();
	private SearchPage searchPage = new SearchPage();
	private SelectPackage selectPackage = new SelectPackage();


	@DataProvider(name = "signup")
	public static Object[][] signup() {
		return new Object[][] {{"abc", "8527720405", "dww@ws.ss"}};
	}

	@DataProvider(name = "signin")
	public static Object[][] signin() {
		return new Object[][] {{"8527720405"}};
	}


	@BeforeMethod
	public void setUp() throws Exception {
		// set up appium: specify the path to the app folder from your computer
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4");
		capabilities.setCapability("app", "/Users/sukhchain/Desktop/UrbanClap_1.0.22.apk");
		capabilities.setCapability("appPackage", "com.urbanclap.urbanclap");
		webDriver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}


	@AfterClass
	public void AfterClass() throws FileNotFoundException, IOException{
		commonFunction.executeCommand("rm appium.log");
		commonFunction.executeCommand("rm uiauto.log");
		commonFunction.executeCommand("rm log.out");
		commonFunction.executeCommand("cp /tmp/appium.log .");
		commonFunction.executeCommand("adb logcat | grep urbanclap > uiauto.log");
		commonFunction.executeCommand("mv /tmp/log.out .");
		commonFunction.generateReport();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		webDriver.quit();         
	}

	public void startApp(){
		splashPage.clickOnSkip(webDriver);
		splashPage.selectCity(webDriver, "Delhi NCR");
	}

	@Test(dataProvider = "signup")
	public void signUpTest(String name, String mobileNumber, String email) throws InterruptedException, ExecuteException, IOException{
		log.debug("urbanclap_test::Signup test Started");
		startApp();
		homePage.clickLoginFromOverflowMenu(webDriver);
		loginPage.signUp(webDriver, name, mobileNumber, email);
		Thread.sleep(10000);
		log.debug("urbanclap_test::Signup test Ended");
	}

	@Test(dataProvider = "signin")
	public void testSignIN(String mobileNumber) throws InterruptedException{
		log.debug("urbanclap_test::Signin test Started");
		startApp();
		homePage.clickLoginFromOverflowMenu(webDriver);
		loginPage.signIn(webDriver, mobileNumber);
		Thread.sleep(10000);
		log.debug("urbanclap_test::Signin test Ended");
	}

	@Test(dataProvider = "signin")
	public void testLogout(String mobileNumber) throws InterruptedException{
		log.debug("urbanclap_test::logout test Started");
		startApp();
		homePage.clickLoginFromOverflowMenu(webDriver);
		loginPage.signIn(webDriver, mobileNumber);
		Thread.sleep(10000);
		homePage.clickMyProfileFromOverflowMenu(webDriver);
		myProfilePage.clickLogout(webDriver);
		log.debug("urbanclap_test::logout test Ended");
	}

	@Test
	public void testLoginWithFacebook() throws InterruptedException{
		log.debug("urbanclap_test::Login with facebook test Started");
		startApp();
		homePage.clickLoginFromOverflowMenu(webDriver);
		loginPage.loginWithFacebook(webDriver);
		Thread.sleep(5000);
		log.debug("urbanclap_test::Login with facebook test Ended");
	}

	@Test
	public void testSearchAndCreatePackage() throws InterruptedException, ExecuteException, IOException{
		log.debug("urbanclap_test::Search and Create Package test Started");
		String[] checklist = {"Manicure","Pedicure"}; 
		startApp();
		homePage.selectProjectCategory(webDriver);
		projectsPage.searchNowOnprojectsPage(webDriver);
		searchPage.searchKeyword(webDriver, "Salon");
		searchPage.selectFromSuggestions(webDriver, "Salon at Home for Women");
		selectPackage.clickStart(webDriver);
		selectPackage.clickNext(webDriver);
		selectPackage.selectRadioButton(webDriver, "Make your own package");
		selectPackage.selectCheckList(webDriver, checklist);
		selectPackage.selectRadioButton(webDriver, "Normal (Rs 250)");
		selectPackage.selectRadioButton(webDriver, "Lotus (Rs 550)");
		selectPackage.selectDate(webDriver, "Wednesday - 30th Sep");
		selectPackage.selectTime(webDriver, "2:00 PM - 3:00 PM");
		selectPackage.clickNext(webDriver);
		commonFunction.executeCommand("adb shell settings put secure location_providers_allowed gps");
		Thread.sleep(5000);
		selectPackage.clickOnGetLocation(webDriver);   
		Thread.sleep(5000);
		log.debug("urbanclap_test::Search and Create Package test Ended");
	}





}
