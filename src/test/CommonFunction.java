package test;


import io.appium.java_client.AppiumDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class CommonFunction {

	public static RemoteWebDriver driver;

	private Logger log = Logger.getLogger(UCTest.class.getName());


	public String executeCommand(String command) {

		StringBuffer output = new StringBuffer();

		Process process;
		try {
			process = Runtime.getRuntime().exec(command);
			process.waitFor();
			BufferedReader reader = 
					new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line = "";			
			while ((line = reader.readLine())!= null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		log.debug("urbanclap_command:: Output of command "+command+" is "+output.toString());
		return output.toString();

	}
	
	public void generateReport() {
		
		String[] cmd = { "/bin/sh", "-c", "grep -i 'debug' log.out | grep 'urbanclap_test' > report.txt" };
		try {
			Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void hideKeyboard()
	{
		try
		{
			((AppiumDriver<?>)driver).hideKeyboard();
		}
		catch(Exception e)
		{
			System.out.println("Softkeyboard not present");
		}
	}


	public void createFileIfNotExist(String fileName) throws FileNotFoundException, IOException {
		try {
			String path = getClass().getClassLoader().getResource(".").getPath();
			System.out.println("path is" + path);
			File file = new File(fileName);

			if (file.createNewFile()){
				System.out.println("File is created!");
			}else{
				System.out.println("File already exists.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void click(WebDriver wd, By element, String elementName) {
		try {
			wd.findElement(element).click();
			log.debug("urbanclap_test::"+elementName+" clicked");
		} catch (ElementNotFoundException e) {
			// TODO: handle exception
			log.debug("urbanclap_test::"+elementName+" not Found");
		}
	}
}
