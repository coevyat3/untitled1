package sitePages;

import User.Info;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;


public class RegistrationPage extends BasePage {


    public void gotoLoginPage() {
        clickElement(By.xpath("//span[.='הרשמה']"));
    }

    public void gotoRegisterPage() {
        clickElement(By.xpath("//*[text()[contains(.,'להרשמה')]]"));
    }
    public void setData()  {

        sendKeysToElement((By.xpath("//input[@placeholder='שם פרטי']")), Info.getUserName());
        sendKeysToElement((By.xpath("//input[@placeholder='מייל']")), Info.getEmail());
        sendKeysToElement((By.xpath("//input[@placeholder='סיסמה']")), Info.getPassword());
        sendKeysToElement((By.xpath("//input[@placeholder='אימות סיסמה']")), Info.getConfirmPassword());
        clickElement(By.xpath("//*[text()[contains(.,'הרשמה ל-BUYME')]]"));
        String name="evyatar cohen",email="test125@yahool.com",password="A1b1c1d1e1",cPassword="A1b1c1d1e1";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(Info.getUserName(),name);
        softAssert.assertEquals(Info.getEmail(),email);
        softAssert.assertEquals(Info.getPassword(),password);
        softAssert.assertEquals(Info.getConfirmPassword(),cPassword);
        softAssert.assertAll();


    }


}