package sitePages;

import User.Info;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class InfoPage extends  BasePage {

    public void pickSomeOneElseRadioButton(){
        clickElement(By.xpath("//*[text()[contains(.,'למישהו אחר')]]"));
    }
    public void receivingBoxName(){
        String str="אח שלי גיבור";
        String str1="//input[@data-parsley-required-message='מי הזוכה המאושר? יש להשלים את שם המקבל/ת']";
        sendKeysToElement(By.xpath(str1),str);
        Assert.assertEquals(str,"אח שלי גיבור");
    }
    public void SenderBoxName(){
String str="//input[@data-parsley-required-message='למי יגידו תודה? שכחת למלא את השם שלך']";
String str2= Info.getUserName();
sendKeysToElement(By.xpath(str),str2);
Assert.assertEquals("evyatar cohen",Info.getUserName());

    }
    public void EventPick(){
        clickElement(By.xpath("//*[text()[contains(.,'לאיזה אירוע')]]"));
    }
    public void uploadPhoto(){
        String str="C:\\Users\\evy\\IdeaProjects\\untitled1\\חח.jpg";
        clickElement(By.className("ui-file"));
        sendKeysToElement(By.name("fileUpload"),str);

    }
    public void sendByEmail() throws InterruptedException {
        String str="//input[@data-parsley-type-message='נראה שחסר משהו במייל, אולי שטרודל?']";
        String email="abc@gmail.com";
        clickElement(By.xpath("//*[text()[contains(.,'במייל')]]"));
        Thread.sleep(1500);
        sendKeysToElement(By.xpath(str),email);
        Thread.sleep(1500);
        clickElement(By.xpath("//*[text()[contains(.,'שמירה')]]"));
        Thread.sleep(1500);
    }
    public void sendByTime(){
       clickElement(By.xpath("//*[text()[contains(.,'מיד אחרי התשלום')]]"));
    }
    public void sendBlessing(){
        sendKeysToElement(By.tagName("textarea"),"מזל טוב אוהב דקל");
    }
}
