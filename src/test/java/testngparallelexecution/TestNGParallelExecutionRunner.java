package testngparallelexecution;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
		features = {"src/test/resources/testngparallelexecution"},
		glue = {"testngparallelexecution"},
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
				//"timeline:test-output-thread/"},
		monochrome=true
		//publish = true
		
		)

public class TestNGParallelExecutionRunner extends AbstractTestNGCucumberTests{

	@Override
	@DataProvider(parallel=true)
	public Object [][] scenarios(){
		return super.scenarios();
	}
}
