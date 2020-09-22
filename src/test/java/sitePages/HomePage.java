package sitePages;

import org.openqa.selenium.By;

 public class HomePage extends BasePage {

    public void ClickPriceList() {

       clickElement(By.xpath("//span[.='סכום']"));

    }

    public void clickRegionList() {
        clickElement(By.xpath("//span[.='אזור']"));;
    }

    public void clickCategoryList() {
     clickElement(By.xpath("//span[.='קטגוריה']"));

    }
    public void findMeGiftButton(){
        clickElement(By.xpath("//*[text()[contains(.,'תמצאו לי מתנה')]]"));
    }

}