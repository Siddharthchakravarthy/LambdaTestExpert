package com.test.Lambda;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LambdaTest1Ans{
	
	public String Test1() {
		LambdaTestSetup.driver.get("https://www.lambdatest.com/selenium-playground");
		WebElement SimpleFDemo = LambdaTestSetup.driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div[1]/div[1]/ul/li[1]/a"));
		SimpleFDemo.click();
		String ValidationOfURL = LambdaTestSetup.driver.getCurrentUrl();
		if(ValidationOfURL.contains("simple-form-demo")) {
			LambdaTestSetup.status = true;
			System.out.println("Yes it does contain simple-form-demo");
		}
		else {
			LambdaTestSetup.status = false;
			System.out.println("The Url is not right");
			return "The test Failed";
		}
		
		String theMessage = "Welcome to LambdaTest";
		WebElement EnterMessage = LambdaTestSetup.driver.findElement(By.cssSelector("input#user-message"));
		WebElement GetCheckedValue = LambdaTestSetup.driver.findElement(By.cssSelector("button#showInput"));
		WebElement RHS = LambdaTestSetup.driver.findElement(By.id("message"));
		
		EnterMessage.sendKeys(theMessage);
		GetCheckedValue.click();
		if(RHS.getText().equals(theMessage)) {
			LambdaTestSetup.status = true;
			System.out.println("Yes the Text entered is the same");
		}
		else {
			LambdaTestSetup.status = false;
			System.out.println("The Text is not entered properly");
			return "Test failed";
		}
		return "Test Passed";
	}
	
}
