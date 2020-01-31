package test.java.Runner.Options;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",glue= {"test/java/stepdefinations"},plugin = { "pretty" ,"json:target/jsonReports/cucumber-report.json"},
monochrome = true)
public class TestRunner {
}
