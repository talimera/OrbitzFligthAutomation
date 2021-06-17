package com.orbitz.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports",
                "rerun:target/rerun.txt"},
        features = "src/test/resources/feature",
        glue = "com/orbitz/stepdefinitions",
        dryRun = false,
        tags = "@roundtrip",
        publish = true
)
public class CukesRunner {



}
