package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;

public class DriverSingleton {
    private static WebDriver driver;

    public static WebDriver getDriverInstance(){
        if(driver == null){
            File file1 = new File("C:\\chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", file1.getAbsolutePath());
            driver = new ChromeDriver();

        }

        return driver;
    }
}