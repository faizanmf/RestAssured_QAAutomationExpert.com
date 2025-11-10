package Frameworks.BDD_Cucumber.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/FeatureFile/CucumberAndTestNG.feature"},
        glue = {"Frameworks.BDD_Cucumber.StepDef"},
        plugin = {},
tags = ""
        )
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {

}