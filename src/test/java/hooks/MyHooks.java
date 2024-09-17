package hooks;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import utilityfile.BaseClass;

public class MyHooks extends BaseClass {
	
	@Before
	public void beforescenario(Scenario scenario) {
		browser();
		MasterUrl();
		
	}

	@After
	public void afterscenario(Scenario scenario) {
	
   
	
	}

	@BeforeStep
	public void beforestep(Scenario scenario) {

	}

	@AfterStep
	public void afterstep(Scenario scenario) {
		boolean failed = scenario.isFailed();
		   if(failed) {
			   byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			   //scenario.embed(screenshot, "image/png");
			   scenario.attach(screenshot, "image/png", "Error screenshot");
			   //attach(screenshot, "image/png", "Error screenshot");
		   }
	}

}
