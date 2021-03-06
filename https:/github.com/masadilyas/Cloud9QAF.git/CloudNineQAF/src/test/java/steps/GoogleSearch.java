package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import common.GoogleBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;

public class GoogleSearch extends GoogleBase {

	// WebDriver driver;
	HomePage hp;
	

	@Given("^I am on the google homepage$")
	public void i_am_on_the_google_homepage() {

		LaunchBrowser();

		/*
		 * WebDriverManager.chromedriver().setup();
		 * 
		 * driver = new ChromeDriver(); driver.get("http://google.com");
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 * //System.out.println("Launching Browser ");
		 * 
		 */

	}

	@When("^I enter search \"([^\"]*)\"$")
	public void i_enter_search(String term) {

		//WebElement searchBox = driver.findElement(By.name("q"));
		//searchBox.sendKeys(term);
		hp= new HomePage (driver);
		//hp.enterSearchItem(term);

	}

	@When("^I click on google search button$")
	public void i_click_on_google_search_button() {

		WebElement searchButtonElement = driver.findElement(By.name("btnK"));
		searchButtonElement.click();

	}

	@Then("^I receive related search result$")
	public void i_receive_related_search_result() {

		String title = driver.getTitle();
		System.out.println(title);

		Assert.assertEquals(true, title.contains("Google Search"));

		WebElement results = driver.findElement(By.id("result-stats"));
		System.out.println(results.getText());

	}

}
