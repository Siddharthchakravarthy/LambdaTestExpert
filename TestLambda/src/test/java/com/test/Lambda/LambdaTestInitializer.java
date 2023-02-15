package com.test.Lambda;


import java.net.MalformedURLException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LambdaTestInitializer {
	@Test(timeOut = 60000)
	@Parameters("NameOfbrowser")
	void TestRuns(String NameOfBrowser) throws InterruptedException, MalformedURLException {
		if(NameOfBrowser.equals("Chrome")) {
			//when remote browser is not used
			//LambdaTestSetup<ChromeDriver> g = new LambdaTestSetup<ChromeDriver>(new ChromeDriver());
			
			LambdaTestSetup<String> g = new LambdaTestSetup<String>("Chrome");
			g.setUp();
			new LambdaTestExpertAns1().TestExpertAns1(g);
			g.tearDown();
		}
		else if(NameOfBrowser.equals("edge")) {
			LambdaTestSetup<String> g = new LambdaTestSetup<String>("edge");
			g.setUp();
			new LambdaTestExpertAns1().TestExpertAns2(g);
			g.tearDown();
		}
	}
}
