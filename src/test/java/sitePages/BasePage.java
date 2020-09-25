package sitePages;

import Drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class BasePage {
    private DriverSingleton driverSingleton;

    public void clickElement(By locator) {

        getWebElement(locator).click();
    }



    public void sendKeysToElement(By locator, String text) {
        getWebElement(locator).sendKeys(text);
    }
    private WebElement getWebElement(By locator) {
        return
                driverSingleton.getDriverInstance().findElement(locator);
    }
}