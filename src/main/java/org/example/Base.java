package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {



    protected WebDriver driver;
    protected static final String STC_WEB_SITE = "https://subscribe.stctv.com/sa-en/";


    protected WebElement waitForElementToBeVisible(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(selector));
    }

    protected String getPlanValue(String currency, String price) {
        return price + " " + currency + "/month";
    }


}
