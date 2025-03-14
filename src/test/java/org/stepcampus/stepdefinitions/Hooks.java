package org.stepcampus.stepdefinitions;

import io.cucumber.java.Before;
import org.junit.After;
import org.stepcampus.factory.WebDriverManagerUtils;

import java.io.IOException;

public class Hooks extends WebDriverManagerUtils {
    public Hooks() throws IOException {
    }

    @After
    public void Hooks() throws IOException {
        driver.quit();
    }
}
