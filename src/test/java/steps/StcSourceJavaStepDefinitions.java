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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;

public class StcSourceJavaStepDefinitions extends Base {


    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        this.driver = new ChromeDriver(chromeOptions);
    }

    @Given("user navigates to stctv.com search screen2")
    public void goToStcWebsite() {
        driver.get(STC_WEB_SITE);
    }

    @When("I click on the select country button2")
    public void clickOnSelectCountry() {
        WebElement countryBtn = waitForElementToBeVisible(By.className("country-current"));
        countryBtn.click();
    }

    @When("country dialog appear2")
    public void validateCountryDialogVisibility() {
        WebElement dialog = waitForElementToBeVisible(By.className("country-select"));
        dialog.isDisplayed();
    }

    @And("select {string} from the dialog2")
    public void selectFromTheDialog(String country) {
        WebElement elementToBeClicked = waitForElementToBeVisible(By.id(country));
        elementToBeClicked.click();
    }

    @Then("validate currency and plans for every2 {string}")
    public void validatePlans(String country) throws Exception {
        WebElement actualLite = waitForElementToBeVisible(By.id("currency-lite"));
        WebElement actualClassic = waitForElementToBeVisible(By.id("currency-classic"));
        WebElement actualPremium = waitForElementToBeVisible(By.id("currency-premium"));

        Country countryWithPlans = CountryFactory.provideCountryPlan(country);
        assertEquals(getPlanValue(countryWithPlans.getCountryCurrency(), countryWithPlans.getCountryPlan().getLite()), actualLite.getText());
        assertEquals(getPlanValue(countryWithPlans.getCountryCurrency(), countryWithPlans.getCountryPlan().getClassic()), actualClassic.getText());
        assertEquals(getPlanValue(countryWithPlans.getCountryCurrency(), countryWithPlans.getCountryPlan().getPremium()), actualPremium.getText());
    }




    @After
    public void teardown() {
        this.driver.close();
    }


}
