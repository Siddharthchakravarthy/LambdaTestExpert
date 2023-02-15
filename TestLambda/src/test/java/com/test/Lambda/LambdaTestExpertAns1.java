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
	public void TestExpertAns1(LambdaTestSetup<String> g) {
		g.driver.get("https://www.lambdatest.com/");
		WebDriverWait wait = new WebDriverWait(g.driver, Duration.ofSeconds(30));
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*")));
		
		WebElement IntegrationWithAsana = g.driver.findElement(By.xpath("//img[@alt='LambdaTest Integration with Asana']"));

		((JavascriptExecutor) g.driver).executeScript("arguments[0].scrollIntoView(true);", IntegrationWithAsana);
		
		WebElement SeeAllIntegrations = g.driver.findElement(By.xpath("//a[text()='See All Integrations']"));
		
		String originalWindow = g.driver.getWindowHandle();
		
		Actions actions = new Actions(g.driver);actions.keyDown(Keys.CONTROL).click(SeeAllIntegrations).keyUp(Keys.CONTROL).build().perform();
		
		ArrayList<String> allWindows = new ArrayList<String>(g.driver.getWindowHandles());
		for (String window : allWindows) {
			System.out.println("Window handle: " + window);
			if (!window.equals(originalWindow)) {
				g.driver.switchTo().window(window);
				break;
			}
		}
		
		String actualUrl = g.driver.getCurrentUrl();
		String expectedUrl = "https://www.lambdatest.com/integrations";
		Assert.assertEquals(expectedUrl, actualUrl);
		

		WebElement KatalonWithLambdaTest = g.driver.findElement(By.xpath("//a[text()='Integrate Katalon Studio with LambdaTest']"));
		WebElement element4 = g.driver.findElement(By.xpath("//a[text()='Integrate Testing Whiz with LambdaTest']"));

		((JavascriptExecutor) g.driver).executeScript("arguments[0].scrollIntoView(true);", KatalonWithLambdaTest);

		element4.click();

		String getTitle = g.driver.getTitle();
		String expectedTitle = "Running Automation Tests Using TestingWhiz LambdaTest | LambdaTest";
		Assert.assertEquals(expectedTitle, getTitle);

		allWindows.remove(g.driver.getWindowHandle());
		g.driver.close();
		g.driver.switchTo().window(allWindows.get(0));

		System.out.println("Number of windows: " + allWindows.size());

		g.driver.navigate().to("https://www.lambdatest.com/blog");

		WebElement communityLink = g.driver.findElement(By.linkText("Community"));
		communityLink.click();

		expectedUrl = "https://community.lambdatest.com/";
		actualUrl = g.driver.getCurrentUrl();
		
		Assert.assertEquals(expectedUrl, actualUrl);
		System.out.println("This is what it is 1");

	}
	public void TestExpertAns2(LambdaTestSetup<String> g) {
		g.driver.get("https://www.lambdatest.com/");
		WebDriverWait wait = new WebDriverWait(g.driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("html")));

		WebElement IntegrationWithAsana = g.driver.findElement(By.xpath("//img[@alt='LambdaTest Integration with Asana']"));

		((JavascriptExecutor) g.driver).executeScript("arguments[0].scrollIntoView(true);", IntegrationWithAsana);

		WebElement SeeAllIntegrations = g.driver.findElement(By.xpath("//a[text()='See All Integrations']"));

		String originalWindow = g.driver.getWindowHandle();

		Actions actions = new Actions(g.driver);
		actions.keyDown(Keys.COMMAND).click(SeeAllIntegrations).keyUp(Keys.COMMAND).build().perform();

		ArrayList<String> allWindows = new ArrayList<String>(g.driver.getWindowHandles());
		for (String window : allWindows) {
			System.out.println("Window handle: " + window);
			if (!window.equals(originalWindow)) {
				g.driver.switchTo().window(window);
				break;
			}
		}

		String actualUrl = g.driver.getCurrentUrl();
		String expectedUrl = "https://www.lambdatest.com/integrations";
		Assert.assertEquals(expectedUrl, actualUrl);


		WebElement KatalonWithLambdaTest = g.driver.findElement(By.xpath("//a[text()='Integrate Katalon Studio with LambdaTest']"));
	
		((JavascriptExecutor) g.driver).executeScript("arguments[0].scrollIntoView(true);", KatalonWithLambdaTest);
	
		g.driver.findElement(By.xpath("//a[text()='Integrate Testing Whiz with LambdaTest']")).click();
		
		String getTitle = g.driver.getTitle();
		String expectedTitle = "Running Automation Tests Using TestingWhiz LambdaTest | LambdaTest";
		Assert.assertEquals(expectedTitle, getTitle);
		
		allWindows.remove(g.driver.getWindowHandle());
		g.driver.close();
		g.driver.switchTo().window(allWindows.get(0));

		System.out.println("Number of windows: " + allWindows.size());

		g.driver.navigate().to("https://www.lambdatest.com/blog");

		g.driver.findElement(By.linkText("Community")).click();

		expectedUrl = "https://community.lambdatest.com/";
		actualUrl = g.driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		System.out.println("This is what it is 2");
		
	}
}
