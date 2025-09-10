package com.test.app;

import com.aventstack.extentreports.Status;
import common.TestBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Sample extends TestBaseClass {

    @Test(groups = "Smoke")
    public void tc00VerifyURL() {

        test = extent.createTest("Verify URL", "Test the google link")
                .assignCategory("Functional_TestCase")
                .assignCategory("Positive_TestCase")
                .assignAuthor("Kunal");

        logger.info("Verify URL");

        // Open initial URL
        webdriver.openURL("https://www.jivrus.com/resources/articles/technical/how-to-open-browser-console-log");

        // Open Google
        webdriver.openURL("https://www.google.com");
        test.log(Status.INFO, "Open URL");
        logger.info("Open URL");
    }

    @Test
    public void tc01VerifyEnterText() {

        test = extent.createTest("Verify Search Box", "")
                .assignCategory("Functional_TestCase")
                .assignCategory("Positive_TestCase")
                .assignAuthor("Kunal");

        logger.info("Verify Search Box");

        webdriver.openURL("https://www.google.com");

        // Explicit wait for elements
        WebDriverWait wait = new WebDriverWait(webdriver.getDriver(), Duration.ofSeconds(10));

        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(IConstants.txtName));
        searchBox.clear();
        searchBox.sendKeys("Automation testing");

        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(IConstants.btnGoogleSearch));
        searchButton.click();

        test.log(Status.INFO, "Verify Search Box");
        logger.info("Verify Search Box");
    }
}
