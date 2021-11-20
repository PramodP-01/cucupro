package stepdefine;

import java.io.File;
import java.io.IOException;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.apache.commons.io.FileUtils;

@RunWith(Cucumber.class)

public class stepdefinations {
	WebDriver driver;

	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() {
		System.out.println("hello");

		System.setProperty("webdriver.chrome.driver", "/home/pramodp/Downloads/selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

	}

	@When("^User need enter (.+) and (.+)$")
	public void user_need_enter_and(String username, String password) {
		System.out.println(username);
		System.out.println(password);
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("login1")));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("password")));
		driver.findElement(By.id("login1")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
	}

	@Then("^login needs to be happened successfully$")
	public void login_needs_to_be_happened_successfully() {
		System.out.println("to");
		System.out.println(driver.getTitle());
	}

	@And("^user fb homepage needs to be displayed$")
	public void user_fb_homepage_needs_to_be_displayed() {
		System.out.println("cucumber");
	}

	public void screenshot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File copy = new File("/home/pramodp/Desktop/ss.png");
		FileUtils.copyFile(src, copy);

	}

}
