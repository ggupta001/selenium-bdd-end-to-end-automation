package org.stepcampus.testrunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "org.stepcampus.stepdefinitions",  // Correct path to your step definitions package
        dryRun = false,
        monochrome = true,
        plugin = {"pretty"}
)
public class TestRunner {
}
