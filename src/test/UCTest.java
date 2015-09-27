package test;

import org.apache.commons.exec.ExecuteException;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.*;
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
import io.appium.java_client.android.AndroidDriver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class UCTest {

	private SplashPage splashPage = new SplashPage();

	private AndroidDriver driver;
	
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
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
		driver.quit();  
	}

	public void startApp(){
		splashPage.clickOnSkip(driver);
		splashPage.selectCity(driver, "Delhi NCR");
	}

	@Test(dataProvider = "signup")
	public void signUpTest(String name, String mobileNumber, String email) throws InterruptedException, ExecuteException, IOException{
		log.debug("urbanclap_test::Signup test Started");
		startApp();
		homePage.clickLoginFromOverflowMenu(driver);
		loginPage.signUp(driver, name, mobileNumber, email);
		Thread.sleep(10000);
		log.debug("urbanclap_test::Signup test Ended");
	}

	@Test(dataProvider = "signin")
	public void testSignIN(String mobileNumber) throws InterruptedException{
		log.debug("urbanclap_test::Signin test Started");
		startApp();
		homePage.clickLoginFromOverflowMenu(driver);
		loginPage.signIn(driver, mobileNumber);
		Thread.sleep(10000);
		log.debug("urbanclap_test::Signin test Ended");
	}

	@Test(dataProvider = "signin")
	public void testLogout(String mobileNumber) throws InterruptedException{
		log.debug("urbanclap_test::logout test Started");
		startApp();
		homePage.clickLoginFromOverflowMenu(driver);
		loginPage.signIn(driver, mobileNumber);
		Thread.sleep(10000);
		homePage.clickMyProfileFromOverflowMenu(driver);
		myProfilePage.clickLogout(driver);
		log.debug("urbanclap_test::logout test Ended");
	}

	@Test
	public void testLoginWithFacebook() throws InterruptedException{
		log.debug("urbanclap_test::Login with facebook test Started");
		startApp();
		homePage.clickLoginFromOverflowMenu(driver);
		loginPage.loginWithFacebook(driver);
		Thread.sleep(5000);
		log.debug("urbanclap_test::Login with facebook test Ended");
	}

	@Test
	public void testSearchAndCreatePackage() throws InterruptedException, ExecuteException, IOException{
		log.debug("urbanclap_test::Search and Create Package test Started");
		String[] checklist = {"Manicure","Pedicure"}; 
		startApp();
		homePage.selectProjectCategory(driver);
		projectsPage.searchNowOnprojectsPage(driver);
		searchPage.searchKeyword(driver, "Salon");
		searchPage.selectFromSuggestions(driver, "Salon at Home for Women");
		selectPackage.clickStart(driver);
		selectPackage.clickNext(driver);
		selectPackage.selectRadioButton(driver, "Make your own package");
		selectPackage.selectCheckList(driver, checklist);
		selectPackage.selectRadioButton(driver, "Normal (Rs 250)");
		selectPackage.selectRadioButton(driver, "Lotus (Rs 550)");
		selectPackage.selectDate(driver, "Wednesday - 30th Sep");
		selectPackage.selectTime(driver, "2:00 PM - 3:00 PM");
		selectPackage.clickNext(driver);
		commonFunction.executeCommand("adb shell settings put secure location_providers_allowed gps");
		Thread.sleep(5000);
		selectPackage.clickOnGetLocation(driver);   
		Thread.sleep(5000);
		log.debug("urbanclap_test::Search and Create Package test Ended");
	}





}
