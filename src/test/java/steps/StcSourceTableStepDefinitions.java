package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.Base;
import org.example.country.Country;
import org.example.country.CountryFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class StcSourceTableStepDefinitions extends Base {

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        this.driver = new ChromeDriver(chromeOptions);
    }

    @Given("user navigates to stctv.com search screen")
    public void goToStcWebsite() {
        driver.get(STC_WEB_SITE);
    }

    @When("I click on the select country button")
    public void clickOnSelectCountry() {
        WebElement countryBtn = waitForElementToBeVisible(By.className("country-current"));
        countryBtn.click();
    }

    @When("country dialog appear")
    public void validateCountryDialogVisibility() {
        WebElement dialog = waitForElementToBeVisible(By.className("country-select"));
        dialog.isDisplayed();
    }

    @And("select {string} from the dialog")
    public void selectFromTheDialog(String country) {
        WebElement elementToBeClicked = waitForElementToBeVisible(By.id(country));
        elementToBeClicked.click();
    }

    @Then("validate {string} and plans {string},{string} and {string} for every country")
    public void validateAndPlansAndForEvery(String currency, String type_lite, String type_classic, String type_premium) {
        WebElement actualLite = waitForElementToBeVisible(By.id("currency-lite"));
        WebElement actualClassic = waitForElementToBeVisible(By.id("currency-classic"));
        WebElement actualPremium = waitForElementToBeVisible(By.id("currency-premium"));


        assertEquals(getPlanValue(currency, type_lite), actualLite.getText());
        assertEquals(getPlanValue(currency, type_classic), actualClassic.getText());
        assertEquals(getPlanValue(currency, type_premium), actualPremium.getText());

    }

    @After
    public void teardown() {
        this.driver.close();
    }

}
