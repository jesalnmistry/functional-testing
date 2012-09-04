package com.twu.ft;

import com.thoughtworks.selenium.Selenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Bing {

    private Selenium selenium;

    @Before
    public void setUp() throws Exception {
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://www.bing.com/";
        selenium = new WebDriverBackedSelenium(driver, baseUrl);
    }

    @Test
    public void testBing() throws Exception {
        selenium.open("/");
        selenium.type("id=sb_form_q", "thoughtworks contact us");
        selenium.click("id=sb_form_go");
        selenium.waitForPageToLoad("30000");
        selenium.click("//ul[@id='wg0']/li/div/div/div/h3/a/strong[3]");
        selenium.waitForPageToLoad("30000");
        assertThat(selenium.isTextPresent("IL 60601"), is(true));
    }

    @After
    public void tearDown() throws Exception {
        selenium.stop();
    }
}
