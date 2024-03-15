package appHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	@Before(order = 0) // it would run first
	public void getProperty()
	{
		configReader = new ConfigReader();
		prop = configReader.init_Prop();
	}
	
	@Before(order = 1) // and it would run second 
	public void launchBrowser()
	{
		String BrowserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(BrowserName);
	}
	
	@After(order = 0) // and it would run second
	public void quitBrowser()
	{
		driver.quit();
	}
	
	@After(order = 1) // it would run first
	public void teardown(Scenario sc)
	{
		if(sc.isFailed())
		{
			//take screenshot
			
			String screenshotName = sc.getName().replaceAll(" ","_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(sourcePath, "image/png", screenshotName);
		}
	}

}
