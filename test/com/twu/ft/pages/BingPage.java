package com.twu.ft.pages;

import com.thoughtworks.selenium.Selenium;

public class BingPage extends BasePage {
    public BingPage(Selenium selenium) {
        super(selenium);
    }

    public void open() {
        selenium.open("/");
    }

    public void search(String query) {
        selenium.type("id=sb_form_q", query);
        selenium.click("id=sb_form_go");
        selenium.waitForPageToLoad("30000");
    }

    public BasePage goToSearchResult(int resultNumber) {
        selenium.click(String.format("//ul[@id='wg0']/li[%d]//a", resultNumber));
        selenium.waitForPageToLoad("30000");
        return new BasePage(selenium);
    }
}
