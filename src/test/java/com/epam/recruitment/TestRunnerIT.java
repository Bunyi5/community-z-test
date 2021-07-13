package com.epam.recruitment;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.epam.recruitment",
    plugin = {"pretty", "com.epam.reportportal.cucumber.StepReporter"}
)
public class TestRunnerIT {
}
