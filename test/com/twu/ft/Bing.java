package com.twu.ft;

import com.thoughtworks.selenium.Selenium;
import com.twu.ft.pages.BasePage;
import com.twu.ft.pages.BingPage;
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
    private BingPage bingPage;

    @Before
    public void setUp() throws Exception {
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://www.bing.com/";
        selenium = new WebDriverBackedSelenium(driver, baseUrl);
        bingPage = new BingPage(selenium);
    }

    @Test
    public void testBing() throws Exception {
        bingPage.open();
        bingPage.search("thoughtworks contact us");
        BasePage searchPage = bingPage.goToSearchResult(2);
        assertThat(searchPage.isTextPresent("IL 60601"), is(true));
    }

    @After
    public void tearDown() throws Exception {
        selenium.stop();
    }
}
