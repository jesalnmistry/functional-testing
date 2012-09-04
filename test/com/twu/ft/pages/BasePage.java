package com.twu.ft.pages;

import com.thoughtworks.selenium.Selenium;

public class BasePage {
    protected final Selenium selenium;

    public BasePage(Selenium selenium) {
        this.selenium = selenium;
    }

    public boolean isTextPresent(String text) {
        return selenium.isTextPresent(text);
    }
}
