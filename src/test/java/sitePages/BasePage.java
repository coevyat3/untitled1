package sitePages;

import Drivers.DriverSingelton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class BasePage {
   private DriverSingelton driverSingelton;




    public void clickElement(By locator) {

        getWebElement(locator).click();
    }



    public void sendKeysToElement(By locator, String text) {
        getWebElement(locator).sendKeys(text);
    }
    private WebElement getWebElement(By locator) {
        return
                driverSingelton.getDriverInstance().findElement(locator);
    }
}