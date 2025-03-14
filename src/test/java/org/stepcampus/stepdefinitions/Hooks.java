package org.stepcampus.stepdefinitions;

import org.stepcampus.factory.WebDriverManagerUtils;

import java.io.IOException;

public class Hooks extends WebDriverManagerUtils {

    public Hooks() throws IOException {
        driver.quit();
    }
}
