package com.realitylabs.event.integration;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:root/root-context.xml", "classpath:spring/spring-security.xml", "classpath:spring/spring-servlet.xml"})
public class SPATestIT {
	
	private URI siteBase;
	private static PhantomJSDriverService service;
	private WebDriver driver;
	protected static DesiredCapabilities dCaps;
	
	@BeforeClass
	public static void createAndStartService() throws IOException  {
		service = new PhantomJSDriverService.Builder().usingPhantomJSExecutable(new File(System.getenv("PHANTOM")))
		        .usingAnyFreePort()
		        .build();
		service.start();
	}
	@AfterClass
	public static void stopService() throws IOException  {
		service.stop();
	}
	
	@Before
	public void setUp() throws Exception {
		  siteBase = new URI("http://localhost:8080/SPA");
		  dCaps = new DesiredCapabilities();
		  dCaps.setJavascriptEnabled(true);
		  dCaps.setCapability("takesScreenshot", false);
		  
		  driver = new RemoteWebDriver(service.getUrl(),dCaps);
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	/**
	 * Test that index page is loaded
	 */
	@Test
	public void testWebAppInitiation() {
		driver.navigate().to(siteBase.toString());
		Assert.assertTrue("Assert that the webapp has started and can deliver content", driver.getTitle().equals("SPA Boilerplate"));
	}
	
	/**
	 * Test that angluar is loaded in the app
	 */
	@Test
	public void testAngularInitiation() {
		driver.navigate().to(siteBase.toString());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String actual = js.executeScript("return typeof angular;").toString();
		String expected = "object";
		Assert.assertTrue("Assert that the webapp has initiated angular.js", actual.equals(expected) );
	}
	
	/**
	 * Test that partial loading works
	 * TODO this test needs to be rewritten but serves as a good example of functionaltesting of js.
	 */
	@Test
	public void testPartialLoading() {
		driver.navigate().to(siteBase.toString());
		driver.findElement(By.cssSelector(".nav-route")).click();
		java.util.List<WebElement> selectedElements = driver.findElements(By.cssSelector(".user-title"));
		Assert.assertTrue(selectedElements.size() > 0);
	}
	
}