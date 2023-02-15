package com.test.Lambda;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LambdaTestSetup<SomeDriver> {
	String username = "siddharth.zed";
    String accesskey = "Pm2kYcVQTg1dsSq8U1rM9DXgk8kJAQt7GN6eelsMp3tw8OnrPi";
    RemoteWebDriver driver = null;
    String gridURL = "@hub.lambdatest.com/wd/hub";
    public static boolean status = false;
    SomeDriver driver1;  
    //for future use, if remote browser is excluded
    LambdaTestSetup(SomeDriver d) {
    	this.driver1 = d;
    }
    
    
	public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        
        if(driver1.equals("Chrome")) {
        	ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("--start-maximized");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			capabilities.setCapability("browserName", "chrome");
			capabilities.setCapability("version", "108.0");
			capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get any available one.
			capabilities.setCapability("build", "TestLambdaExpertChrome1");
			capabilities.setCapability("name", this.getClass().getName());
			capabilities.setCapability("network", true);
			capabilities.setCapability("visual", true);
			capabilities.setCapability("video",true);
			capabilities.setCapability("console", true);
	        try {
	            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
	        } catch (MalformedURLException e) {
	            System.out.println("Invalid grid URL");
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
        }
        else if(driver1.equals("Firefox")) {
            capabilities.setCapability("browserName", "Firefox");
            capabilities.setCapability("browserVersion", "107.0");
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("user", System.getenv("LT_USERNAME"));
            ltOptions.put("accessKey", System.getenv("LT_ACCESS_KEY"));
            ltOptions.put("build", "Selenium 4");
            ltOptions.put("name", this.getClass().getName());
            ltOptions.put("platformName", "Windows 10");
            ltOptions.put("seCdp", true);
            ltOptions.put("selenium_version", "4.0.0");
            capabilities.setCapability("LT:Options", ltOptions);

            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
            System.out.println(driver);
        }
        else if(driver1.equals("edge")) {
        	EdgeOptions options = new EdgeOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("--start-maximized");
			capabilities.setCapability(EdgeOptions.CAPABILITY, options);
			capabilities.setCapability("browserName", "edge");
			capabilities.setCapability("version", "87.0");
			capabilities.setCapability("platform", "macOS Sierra"); // If this cap isn't specified, it will just get any available one.
			capabilities.setCapability("build", "TestLambdaExpertEdge1");
			capabilities.setCapability("name", "LambdaTestJavaSample");
			capabilities.setCapability("network", true);// To enable network logs
			capabilities.setCapability("visual", true);// To enable step by step screenshot
			capabilities.setCapability("video",true);// To enable video recording
			capabilities.setCapability("console", true);// To capture console logs
			try {
				driver = new RemoteWebDriver(new java.net.URL("https://" + username + ":" + accesskey + gridURL), capabilities);
			}
			catch (Exception e) {
		    	System.out.println(e.getMessage());
			}
        }
        
    }
    public void tearDown() {
        if (driver != null) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
            driver.quit(); //really important statement for preventing your test execution from a timeout.
        }
    }
}
