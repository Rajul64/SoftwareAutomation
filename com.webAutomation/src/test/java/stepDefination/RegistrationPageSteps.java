package stepDefination;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.Assert;

import com.pages.RegistrationPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationPageSteps {
	
	public static String title;
	public static String expectedTitle;
	private ConfigReader cnfgreader;
	Properties prop;
	
	private RegistrationPage RegPage = new RegistrationPage(DriverFactory.getDriver()); //No one can access this LoginPage class object other then this class only that's why we make it private
	
	@Given("User is on Registration page")
	public void user_is_on_registration_page() {
		cnfgreader = new ConfigReader();
		prop = cnfgreader.init_Prop();
		DriverFactory.getDriver().get(prop.getProperty("url"));
		//https://yourlogo.geiger.com/
	}
	
	@When("User verify the Registration page title")
	public void user_verify_the_registration_page_title() {
		title = RegPage.RegistrationPageTitle();
		expectedTitle = "Cathy Bell / Madison Conradis";
		System.out.println("Registration page title is: " + title);
		Assert.assertTrue(title.contains(expectedTitle));
		
	}

	@When("User click on Register link")
	public void user_click_on_register_link() {
		RegPage.ClickOnRegisterLink();
	}

	@When("User enter the following registration details")
	public void user_enter_the_following_registration_details(DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    // For other transformations you can register a DataTableType.
		List<Map<String, String>> userList = dataTable.asMaps();
		String firstname = userList.get(0).get("FirstName");
		String lastname = userList.get(0).get("LastName");
		String email = userList.get(0).get("Email");
		String phoneNo = userList.get(0).get("PhoneNo"); 
		String pwd = userList.get(0).get("Password"); 
		String confirmPwd = userList.get(0).get("ConfirmPassword"); 
		
		RegPage.EnterUserDetails(firstname, lastname, email, phoneNo, confirmPwd, pwd);
	}

	@When("User selects the TimeZone from drop-down")
	public void user_selects_the_time_zone_from_drop_down() {
		RegPage.SelectTimeZoneFromDropDown();
	}

	@When("User click on Register button")
	public void user_click_on_register_button() throws InterruptedException {
		RegPage.ClickOnRegisterBtn();
		
	}

	@Then("User registration should be successfull")
	public void user_registration_should_be_successfull() {
		String ActualEle = RegPage.UserRegisteredSuccessfully();
		System.out.println("Registered user name is: " + ActualEle);
	}
}
