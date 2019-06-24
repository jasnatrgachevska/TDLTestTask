package hellocucumber;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.utilities;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static org.junit.Assert.*;

public class Stepdefs {
    WebDriver driver;
    @Given("^I authenticate at \"([^\"]*)\" using username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void i_authenticate_at_using_username_and_password(String arg1, String arg2, String arg3) throws Exception {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        (new Thread(new utilities.LoginWindow("postman", "password"))).start();
        driver.get("https://postman-echo.com/basic-auth");    }

    @Then("^I get \"([^\"]*)\" response$")
    public void i_get_response(String arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        WebElement websiteBody = driver.findElement(By.tagName("body"));
        assertEquals(websiteBody.getText(), "{\"authenticated\":true}");
    }
    @After
    public void quit(){
        driver.close();
    }

    @When("^I navigate to \"([^\"]*)\"$")
    public void i_navigate_to(String arg1) {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    @Then("^I verify that main image matches \"([^\"]*)\" image$")
    public void i_verify_that_main_image_matches_image(String arg1) throws Exception {
        WebElement googlgeImage = driver.findElement(By.id("hplogo"));
        assertTrue(utilities.ImgDiffPercent(utilities.getTestImage("src\\test\\resources\\test.png"),
                utilities.getElementScreenshot(driver, googlgeImage)) > 80);
    }

}