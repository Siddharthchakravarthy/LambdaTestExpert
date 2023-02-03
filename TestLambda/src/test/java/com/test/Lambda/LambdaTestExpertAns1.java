package com.test.Lambda;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class LambdaTestExpertAns1 {
	public void TestExpertAns1() {
		LambdaTestSetup.driver.get("https://www.lambdatest.com/");
		WebDriverWait wait = new WebDriverWait(LambdaTestSetup.driver, Duration.ofSeconds(30));
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*")));
		
		WebElement IntegrationWithAsana = LambdaTestSetup.driver.findElement(By.xpath("//img[@alt='LambdaTest Integration with Asana']"));

		((JavascriptExecutor) LambdaTestSetup.driver).executeScript("arguments[0].scrollIntoView(true);", IntegrationWithAsana);
		
		WebElement SeeAllIntegrations = LambdaTestSetup.driver.findElement(By.xpath("//a[text()='See All Integrations']"));
		
		String originalWindow = LambdaTestSetup.driver.getWindowHandle();
		
		Actions actions = new Actions(LambdaTestSetup.driver);actions.keyDown(Keys.CONTROL).click(SeeAllIntegrations).keyUp(Keys.CONTROL).build().perform();
		
		ArrayList<String> allWindows = new ArrayList<String>(LambdaTestSetup.driver.getWindowHandles());
		for (String window : allWindows) {
			System.out.println("Window handle: " + window);
			if (!window.equals(originalWindow)) {
				LambdaTestSetup.driver.switchTo().window(window);
				break;
			}
		}
		
		String actualUrl = LambdaTestSetup.driver.getCurrentUrl();
		String expectedUrl = "https://www.lambdatest.com/integrations";
		Assert.assertEquals(expectedUrl, actualUrl);
		

		WebElement KatalonWithLambdaTest = LambdaTestSetup.driver.findElement(By.xpath("//a[text()='Integrate Katalon Studio with LambdaTest']"));
		WebElement element4 = LambdaTestSetup.driver.findElement(By.xpath("//a[text()='Integrate Testing Whiz with LambdaTest']"));

		((JavascriptExecutor) LambdaTestSetup.driver).executeScript("arguments[0].scrollIntoView(true);", KatalonWithLambdaTest);

		element4.click();

		String getTitle = LambdaTestSetup.driver.getTitle();
		String expectedTitle = "Running Automation Tests Using TestingWhiz LambdaTest | LambdaTest";
		Assert.assertEquals(expectedTitle, getTitle);

		allWindows.remove(LambdaTestSetup.driver.getWindowHandle());
		LambdaTestSetup.driver.close();
		LambdaTestSetup.driver.switchTo().window(allWindows.get(0));

		System.out.println("Number of windows: " + allWindows.size());

		LambdaTestSetup.driver.navigate().to("https://www.lambdatest.com/blog");

		WebElement communityLink = LambdaTestSetup.driver.findElement(By.linkText("Community"));
		communityLink.click();

		expectedUrl = "https://community.lambdatest.com/";
		actualUrl = LambdaTestSetup.driver.getCurrentUrl();
		
		Assert.assertEquals(expectedUrl, actualUrl);
		System.out.println("This is what it is 1");

	}
	public void TestExpertAns2() {
		LambdaTestSetup.driver.get("https://www.lambdatest.com/");
		WebDriverWait wait = new WebDriverWait(LambdaTestSetup.driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("html")));

		WebElement IntegrationWithAsana = LambdaTestSetup.driver.findElement(By.xpath("//img[@alt='LambdaTest Integration with Asana']"));

		((JavascriptExecutor) LambdaTestSetup.driver).executeScript("arguments[0].scrollIntoView(true);", IntegrationWithAsana);

		WebElement SeeAllIntegrations = LambdaTestSetup.driver.findElement(By.xpath("//a[text()='See All Integrations']"));

		String originalWindow = LambdaTestSetup.driver.getWindowHandle();

		Actions actions = new Actions(LambdaTestSetup.driver);
		actions.keyDown(Keys.COMMAND).click(SeeAllIntegrations).keyUp(Keys.COMMAND).build().perform();

		ArrayList<String> allWindows = new ArrayList<String>(LambdaTestSetup.driver.getWindowHandles());
		for (String window : allWindows) {
			System.out.println("Window handle: " + window);
			if (!window.equals(originalWindow)) {
				LambdaTestSetup.driver.switchTo().window(window);
				break;
			}
		}

		String actualUrl = LambdaTestSetup.driver.getCurrentUrl();
		String expectedUrl = "https://www.lambdatest.com/integrations";
		Assert.assertEquals(expectedUrl, actualUrl);


		WebElement KatalonWithLambdaTest = LambdaTestSetup.driver.findElement(By.xpath("//a[text()='Integrate Katalon Studio with LambdaTest']"));
	
		((JavascriptExecutor) LambdaTestSetup.driver).executeScript("arguments[0].scrollIntoView(true);", KatalonWithLambdaTest);
	
		LambdaTestSetup.driver.findElement(By.xpath("//a[text()='Integrate Testing Whiz with LambdaTest']")).click();
		
		String getTitle = LambdaTestSetup.driver.getTitle();
		String expectedTitle = "Running Automation Tests Using TestingWhiz LambdaTest | LambdaTest";
		Assert.assertEquals(expectedTitle, getTitle);
		
		allWindows.remove(LambdaTestSetup.driver.getWindowHandle());
		LambdaTestSetup.driver.close();
		LambdaTestSetup.driver.switchTo().window(allWindows.get(0));

		System.out.println("Number of windows: " + allWindows.size());

		LambdaTestSetup.driver.navigate().to("https://www.lambdatest.com/blog");

		LambdaTestSetup.driver.findElement(By.linkText("Community")).click();

		expectedUrl = "https://community.lambdatest.com/";
		actualUrl = LambdaTestSetup.driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		System.out.println("This is what it is 2");
		
	}
}
