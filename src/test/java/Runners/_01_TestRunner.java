package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"C:\\Users\\samet\\IdeaProjects\\Cucumber_Course4\\src\\test\\java\\FeatureFiles\\_01_Login.feature"},
        glue = {"StepDefinitions"}
)
public class _01_TestRunner extends AbstractTestNGCucumberTests{
}
