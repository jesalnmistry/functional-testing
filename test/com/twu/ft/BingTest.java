package com.twu.ft;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.SeleneseTestCase;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class BingTest extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://www.bing.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testBing () throws Exception {
		selenium.open("/");
		selenium.type("id=sb_form_q", "thoughtworks contact us");
		selenium.click("id=sb_form_go");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Contact us | www.thoughtworks.com");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent("ACR Mansion G"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
