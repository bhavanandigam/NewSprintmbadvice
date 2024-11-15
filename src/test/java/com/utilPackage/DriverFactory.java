package com.utilPackage;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.utilityClasses.FileUtility;

public class DriverFactory {
//	public static WebDriver driver;
	public static ThreadLocal<WebDriver> driver = new ThreadLocal();

	public static void setUpBrowser() throws Exception {
		FileUtility fileUtility = new FileUtility();
		String browserName = fileUtility.getDataFromPropertiesFiles("browser");
//		String browserName=System.getProperty("browser","chrome");
		String url = fileUtility.getDataFromPropertiesFiles("url");
		if (browserName.equals("chrome")) {
//			driver = new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Users\\admin\\Desktop\\Selenium\\chrome-win64\\chrome-win64\\chrome.exe");
			options.addArguments("--disable-notifications");
			driver.set(new ChromeDriver(options));
			
		} else if (browserName.equals("edge")) {
			driver.set(new EdgeDriver());
			
		} else if (browserName.equals("firefox")) {
			driver.set(new FirefoxDriver());
			
		} else {
			driver.set(new ChromeDriver());
			
		}

		driver.get().manage().window().maximize();
		driver.get().get(url);
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void quitBrowser() {
		if (driver != null)
			driver.get().quit();
	}
}
