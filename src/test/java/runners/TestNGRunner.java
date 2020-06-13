package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//features
//glue
//tags
//plugin


@CucumberOptions(features = {"src/test/resources/features/"},
					glue= {"stepdefinitions"},
					plugin = {"html:target/reports/htmlreports","json:target/reports/jsonreports/myjsonreport.json"},
					tags = {"@SmokeTests"}
		)
public class TestNGRunner extends AbstractTestNGCucumberTests{

}
