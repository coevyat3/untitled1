package User; /**
 * Class not in use in project
 * Needed this class, to check login data saved.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    private WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void press_login(){
        driver.findElement(By.xpath("//*[@id=\"ember676\"]/div/ul[1]/li[3]")).click();
    }
    public void setMail(){
        driver.findElement(By.id("ember1165")).sendKeys(Info.getEmail());

    }
    public void setPassword(){
        driver.findElement(By.id("ember1167")).sendKeys((Info.getPassword()));
    }
    public void pressButton(){
        driver.findElement(By.xpath("//*[@id=\"ember1157\"]/button")).click();
    }



}

