package com.arine.automation.pages;

import com.arine.automation.exception.AutomationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.arine.automation.pages.BasePage.driverUtil;
import static com.arine.automation.pages.BasePage.waitForLoadingPage;


public class DiscussedPractitionerReportPage {
//    public static final String REMOVE_OPTION_BUTTON = "//*[contains(text(),'%s')]/following-sibling::button";
    public static final String COMBOBOX_BUTTON = "//*[@placeholder='Select Step(s) Performed']";

    public void removeOption(String option) throws AutomationException {
        WebElement button = driverUtil.getWebElement("//*[contains(text(),'"+option+"')]/following-sibling::button");
        button.click();
    }

    public void selectOption(String selectOption) throws AutomationException {
        WebElement btn = driverUtil.getWebElement(COMBOBOX_BUTTON);
        btn.click();

        List<WebElement> options = driverUtil.getWebElements("//*[@role='option']");
        for (WebElement option : options) {
            if (option.getText().equals(selectOption)) {
                option.click();
                break;
            }
        }

    }

    public void clickOnLogIconInPractitionerTable(Integer rowNum) throws AutomationException {
        WebElement logBtn = driverUtil.getWebElement("//*[contains(text(),'Report History')]/parent::div/parent::div/following-sibling::div//table//tr["+rowNum+"]/td[count(//table//th[contains(text(),'Log')]/preceding-sibling::th)+7]//div//div");
        logBtn.click();
    }
}
