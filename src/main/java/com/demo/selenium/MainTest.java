package com.demo.selenium;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.*;

/**
 * @author balvinder
 *
 */
public class MainTest {


	public static void main(String[] args) {
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] {MainTest.class});
		testng.addListener(tla);
		testng.run();
	}
	
	WebDriver driver;
	
	@BeforeTest
	private void beforeTest() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		System.setProperty("webdriver.chrome.driver","/Users/balvinder/Documents/workspace-spring-tool-suite/selenium/src/main/resources/driver/chromedriver");
		driver = new ChromeDriver(options);
	}
	
	@BeforeMethod
	private void open() {
		//driver.get("http://google.com");
		driver.get("http://localhost:9090");
	}
	
//	@Test
//	private void test() {
//		boolean res = driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/img[1]")).isDisplayed();
//		System.out.println("Is the img being displayed" + res);
//		
//	}
//	
//	@Test
//	private void search() {
//		driver.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]"))
//		.sendKeys("Das Balvinder Das");
//		
//		driver.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[3]/center[1]/input[1]"))
//		.click();
//		
//	}
	
	@Test
	private void testHeading() {
		//driver.findElement(By.xpath("/html/body/h1[contains(text(),'Hello World!')]")).isDisplayed();
		String headerText = driver.findElement(By.xpath("/html/body/h1")).getText();
		assertEquals(headerText, "Hello World!");
	}
	
	@AfterClass
	private void close() {
		driver.close();
	}
	
	
	
}
