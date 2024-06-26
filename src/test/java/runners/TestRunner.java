package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = "stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = true,
        tags = "",
        plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"

)
public class TestRunner {



}
