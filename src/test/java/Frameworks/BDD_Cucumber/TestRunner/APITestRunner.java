package Frameworks.BDD_Cucumber.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;


@CucumberOptions(plugin = { "pretty" },
        features = "src/test/resources/FeatureFile/Employee.feature",
        glue = {"Frameworks.BDD_Cucumber.StepDef" }
)

public class APITestRunner extends AbstractTestNGCucumberTests {

}