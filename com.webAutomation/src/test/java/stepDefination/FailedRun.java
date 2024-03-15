package stepDefination;

import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
		features = {"@target/failedrerun.txt"},
		glue = {"stepDefination", "appHooks"},
		monochrome = true,
		dryRun = false,
		plugin = {"pretty",
				"rerun:target/failedrerun.txt"
				}
				
			)

public class FailedRun {

}
