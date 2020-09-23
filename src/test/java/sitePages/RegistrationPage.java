package sitePages;

import User.Info;
import org.openqa.selenium.By;


public class RegistrationPage extends BasePage {





    public void gotoLoginPage() {
        clickElement(By.xpath("//span[.='הרשמה']"));
    }

    public void gotoRegisterPage() {
        clickElement(By.xpath("//*[text()[contains(.,'להרשמה')]]"));
    }
    public void setData() throws InterruptedException {

        sendKeysToElement((By.xpath("//input[@placeholder='שם פרטי']")), Info.getUserName());
        sendKeysToElement((By.xpath("//input[@placeholder='מייל']")), Info.getEmail());
        sendKeysToElement((By.xpath("//input[@placeholder='סיסמה']")), Info.getPassword());
        sendKeysToElement((By.xpath("//input[@placeholder='אימות סיסמה']")), Info.getConfirmPassword());
        clickElement(By.xpath("//*[text()[contains(.,'הרשמה ל-BUYME')]]"));
    }

}