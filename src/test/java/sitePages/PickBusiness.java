package sitePages;

import org.openqa.selenium.By;

public class PickBusiness  extends  BasePage{

    public void pickItem(){
        clickElement(By.xpath("//*[text()[contains(.,'BUYME KOSHER')]]"));
    }
    public void insert_price(){
       int x=120;
       sendKeysToElement(By.className("input-cash"),String.valueOf(x));

    }
    public void pressButton(){
        clickElement(By.className("btn-wrapper"));
    }

}
