package com.test.Lambda;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LambdaTest2Ans{
	@SuppressWarnings("deprecation")
	public String Test2() throws InterruptedException {
		LambdaTestSetup.driver.get("https://www.lambdatest.com/selenium-playground");
		
		WebElement Sliders = LambdaTestSetup.driver.findElement(By.xpath("//ul//a[contains(@href, \"https://www.lambdatest.com/selenium-playground/drag-drop\")]"));
		Sliders.click();
		
//		WebElement ProgBandS = test.driver.findElement(By.xpath("//p[contains(text(), \"Progress Bar & Sliders\")]"));
//		ProgBandS.click();
		
		LambdaTestSetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement SliderToSlide = LambdaTestSetup.driver.findElement(By.xpath("//div[@class = \"sp__range sp__range-success\"]//input"));
		int xCoordinate = SliderToSlide.getLocation().getX();
		Actions Drag = new Actions(LambdaTestSetup.driver);
		System.out.println(xCoordinate);
		
		try {
			if(LambdaTestSetup.driver.getCapabilities().getBrowserName().equals("chrome")) {
				Drag.moveToElement(SliderToSlide).clickAndHold().moveByOffset(120, 0).release().perform();
			}
			else {
				Drag.moveToElement(SliderToSlide).clickAndHold().moveByOffset(116, 0).release().perform();
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		LambdaTestSetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement SliderValue = LambdaTestSetup.driver.findElement(By.xpath("//div[@class = \"sp__range sp__range-success\"]//output"));
		if(SliderValue.getText().equals("95")) {
			LambdaTestSetup.status = true;
			System.out.println("The Slider Value is 95");
		}
		else {
			return "Test Failed";
		}
		
		return "Test Passed";
	}

}
