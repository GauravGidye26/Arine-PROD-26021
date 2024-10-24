package com.arine.automation.glue;

import com.arine.automation.exception.AutomationException;
import com.arine.automation.pages.DiscussedPractitionerReportPage;
import com.arine.automation.pages.PageFactory;
import com.arine.automation.util.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import groovyjarjarantlr4.v4.runtime.atn.ParseInfo;
import org.openqa.selenium.WebElement;

import static com.arine.automation.glue.CommonSteps.takeScreenshot;
import static com.arine.automation.pages.BasePage.driverUtil;

public class DiscussedPractitionerReportSteps {
    public static WebDriverUtil driverUtil;

    @Then("^Remove \"([^\"]*)\" from Steps Performed ComboBox$")
    public void removeFromComboBox(String option) throws AutomationException {
        PageFactory.discussedPractitionerReportPage().removeOption(option);
        takeScreenshot();
    }

    @Then("^Select \"([^\"]*)\" from Steps Performed ComboBox$")
    public void selectFromStepsPerformedComboBox(String selectOption) throws AutomationException {
        PageFactory.discussedPractitionerReportPage().selectOption(selectOption);
        takeScreenshot();
    }

    @And("^User click on the log icon in the Report History table of row : \"([^\"]*)\"$")
    public void userClickOnTheLogIconInTheReportHistoryTableOfRow(String row) throws AutomationException {
        Integer rowNum = Integer.parseInt(row);
        PageFactory.discussedPractitionerReportPage().clickOnLogIconInPractitionerTable(rowNum);
        takeScreenshot();
    }
}
