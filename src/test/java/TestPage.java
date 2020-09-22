

import Drivers.DriverSingelton;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import sitePages.HomePage;
import sitePages.InfoPage;
import sitePages.PickBusiness;
import sitePages.RegistrationPage;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;


public class TestPage {
    private static WebDriver driver;
    static String BuyMe = "https://buyme.co.il/";
    private static NgWebDriver ngWebDriver;
    private static PickBusiness pickBusiness = new PickBusiness();
    private static HomePage homePage = new HomePage();
    private static InfoPage infoPage = new InfoPage();

    @BeforeClass
    public static  void BeforeAll() {
        driver = DriverSingelton.getDriverInstance();
        ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to(BuyMe);


    }

    @Test
    public void TestA_Registration() throws InterruptedException {
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        RegistrationPage register = new RegistrationPage();
        Thread.sleep(1500);
        register.gotoLoginPage();
        Thread.sleep(1500);
        register.gotoRegisterPage();
        Thread.sleep(1500);
        register.setData();
    }


    @Test

    public void TestB1_pickingPrice() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(1500);
        homePage.ClickPriceList();
        driver.findElements(By.className("active-result")).get(1).click();
        Thread.sleep(1500);
       homePage.clickRegionList();
        driver.findElements(By.className("active-result")).get(3).click();
        Thread.sleep(1500);
      homePage.clickCategoryList();
        driver.findElements(By.className("active-result")).get(2).click();
       homePage.findMeGiftButton();
        
    }


    @Test
    public void TestF_PickingGift() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(1500);
        pickBusiness.pickItem();

    }



    @Test
    public void TestG_insertPrice() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(1500);
        pickBusiness.insert_price();
        Thread.sleep(1500);
        pickBusiness.pressButton();

    }

    @Test
    public void TestH_someoneElseBox() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(1500);
        infoPage.pickSomeOneElseRadioButton();
    }

    @Test
    public void TestI_receiverName() throws InterruptedException {
        Thread.sleep(1500);
       infoPage.receivingBoxName();


    }
    @Test
    public void TestJ_SenderName() throws InterruptedException {
        Thread.sleep(1500);
        WebElement ele=driver.findElement(By.xpath("//input[@data-parsley-required-message='למי יגידו תודה? שכחת למלא את השם שלך']"));
        ele.clear();
        Thread.sleep(1500);
     infoPage.SenderBoxName();

    }


    @Test
    public void TestK_pickEvent() throws InterruptedException {
        Thread.sleep(1500);
        infoPage.EventPick();
        Thread.sleep(1500);
        driver.findElements(By.className("active-result")).get(2).click();


    }
    @Test
    public void TestL_addBlessingText() throws InterruptedException {

        WebElement elem = driver.findElement(By.tagName("textarea"));
        Thread.sleep(1500);
        elem.clear();
        Thread.sleep(1500);
        infoPage.sendBlessing();
    }
    @Test
    public void TestM_uploadPhoto() throws InterruptedException, AWTException {
        Thread.sleep(1500);
         infoPage.uploadPhoto();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);

    }

    @Test
    public void TestN_whenToSend() throws InterruptedException {
        Thread.sleep(1500);
        infoPage.sendByTime();

    }
    @Test
    public void sendByMail() throws InterruptedException {

        Thread.sleep(1500);
      infoPage.sendByEmail();
    }





    @AfterClass
    public void close(){
driver.close();

    }



}


