package com.test.Lambda;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LambdaTest3Ans{
	public String Test3() throws InterruptedException {
		LambdaTestSetup.driver.get("https://www.lambdatest.com/selenium-playground");
		LambdaTestSetup.driver.get("https://www.lambdatest.com/selenium-playground/");
		LambdaTestSetup.driver.findElement(By.xpath("//a[contains(text(), 'Input Form Submit')]")).click();
		LambdaTestSetup.driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		String errorMessage = LambdaTestSetup.driver.findElement(By.xpath("//input[@id = 'name']")).getAttribute("validationMessage");
		if(errorMessage.equals("Please fill out this field.")) {
			LambdaTestSetup.driver.findElement(By.name("name")).sendKeys("Siddharth Chakrvarthy S");
			LambdaTestSetup.driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("siddharth.zed@gmail.com");
			LambdaTestSetup.driver.findElement(By.name("password")).sendKeys("password");
			LambdaTestSetup.driver.findElement(By.name("company")).sendKeys("ABC Ltd");
			LambdaTestSetup.driver.findElement(By.name("website")).sendKeys("https://abc.com");
			LambdaTestSetup.driver.findElement(By.name("city")).sendKeys("Bengaluru");
			LambdaTestSetup.driver.findElement(By.name("address_line1")).sendKeys("152 coral hill drive");
			LambdaTestSetup.driver.findElement(By.name("address_line2")).sendKeys("hills view road");
			LambdaTestSetup.driver.findElement(By.id("inputState")).sendKeys("Karnataka");
			LambdaTestSetup.driver.findElement(By.name("zip")).sendKeys("560092");
			WebElement dropDown = LambdaTestSetup.driver.findElement(By.name("country"));
			Select select = new Select(dropDown);
			select.selectByVisibleText("United States");
			LambdaTestSetup.driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
			Thread.sleep(5000);
			String message = LambdaTestSetup.driver.findElement(By.xpath("//p[@class='success-msg hidden']")).getText();
			if(message.equals("Thanks for contacting us, we will get & back to you shortly.")) {
				LambdaTestSetup.status = true;
			}
		}
		return "Test Passed";
	}
}
