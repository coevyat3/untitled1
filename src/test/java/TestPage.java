
import Drivers.DriverSingelton;
import User.Info;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
    public static void BeforeAll() {
        driver = DriverSingelton.getDriverInstance();
        ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to(BuyMe);


    }

    /**
     * @throws InterruptedException
     * Registration steps :
     * go to Login page  by press  login/register button-> press Register to site button
     * Set valuable data into field
     * and click register me buy me button
     *if error occur (" email already in use" -> make sure to change the email value in User/info class.
     */

    @Test
    public void Test01_Registration() throws InterruptedException {
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        RegistrationPage register = new RegistrationPage();
        Thread.sleep(1500);
        register.gotoLoginPage();
        Thread.sleep(1500);
        register.gotoRegisterPage();
        Thread.sleep(1500);
        register.setData();
        try{
            Assert.assertEquals(Info.getUserName(),"evyatar cohen");
            Assert.assertEquals(Info.getEmail(),"tester1@wmail.com");
            Assert.assertEquals(Info.getPassword(),"A1b1c1d1e1");
            Assert.assertEquals(Info.getConfirmPassword(),Info.getPassword());
        }catch (Exception e){
            throw  e;
        }

    }

    /**
     * Pressing the price value selected (by default) from dropdown list and select a valuable price.
     * @throws InterruptedException
     */
    @Test
    public void Test02_pickingPrice() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(1500);
        homePage.ClickPriceList();
        driver.findElements(By.className("active-result")).get(1).click();


    }

    /**
     * Pressing the region value selected from dropdown list and select a valuable region
     * @throws InterruptedException
     */
    @Test
    public void Test03_piecingRegion() throws InterruptedException {
        Thread.sleep(1500);
        homePage.clickRegionList();
        driver.findElements(By.className("active-result")).get(3).click();
    }

    /**
     * Pressing Category value suggested from dropdown and select a valuable category
     * @throws InterruptedException
     */
    @Test
    public void Test04_pickingCategory() throws InterruptedException {

        Thread.sleep(1500);
        homePage.clickCategoryList();
        driver.findElements(By.className("active-result")).get(2).click();

    }

    /**
     * Pressing the find me a gift button
     * @throws InterruptedException
     */
    @Test
    public void Test05_pressingFindMeAGifButton() throws InterruptedException {
        Thread.sleep(1500);
        homePage.findMeGiftButton();

    }

    /**
     * Moving to a new page in site with result list to all gifs suggests according to Navbar (in previous page) data received
     * Picking a gif from list
     * @throws InterruptedException
     */

    @Test
    public void Test06_PickingAGif() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(1500);
        String site = "https://buyme.co.il/search?budget=1&category=16&region=9";
        try {
           Assert.assertEquals(driver.getCurrentUrl(), site);
        } catch (AssertionError e) {
            System.out.println("Not equal");
            throw e;
        }
        Thread.sleep(1500);
        pickBusiness.pickItem();

    }

    /**
     * Moving to new page in site
     * Enter a valuable price and Press the pick button
     * @throws InterruptedException
     */

    @Test
    public void Test07_insertPrice() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(1500);
        pickBusiness.insert_price();
        Thread.sleep(1500);
        pickBusiness.pressButton();

    }

    /**Moving to new Page in site who to send page
     * Picking Someone else value (even tho is picked by default)
     * @throws InterruptedException
     */
    @Test
    public void Test08_someoneElseBox() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(1500);
        infoPage.pickSomeOneElseRadioButton();
    }

    /**
     * Enter data into who to send box .
     * @throws InterruptedException
     */
    @Test
    public void Test09_receiverName() throws InterruptedException {
        Thread.sleep(1500);
       infoPage.receivingBoxName();

    }

    /**
     *Enter data into Who send the gift box. we delete the default (site autocomplete this box value with username ) we delete it and rewrite it again
     * @throws InterruptedException
     */
    @Test
    public void Test10_SenderName() throws InterruptedException {
        Thread.sleep(1500);
        WebElement ele=driver.findElement(By.xpath("//input[@data-parsley-required-message='למי יגידו תודה? שכחת למלא את השם שלך']"));
        ele.clear();
        Thread.sleep(1500);
         infoPage.SenderBoxName();

    }

    /**
     * Picking an Event from the dropdown list .
     * Pressing the default value and select other value from  list.
     * @throws InterruptedException
     */
    @Test
    public void Test11_pickEvent() throws InterruptedException {
        Thread.sleep(1500);
        infoPage.EventPick();
        Thread.sleep(1500);
        driver.findElements(By.className("active-result")).get(2).click();


    }

    /**
     * Delete the textarea blessing text, and add our own blessing
     * @throws InterruptedException
     */
    @Test
    public void Test12_addBlessingText() throws InterruptedException {

        WebElement elem = driver.findElement(By.tagName("textarea"));
        Thread.sleep(1500);
        elem.clear();
        Thread.sleep(1500);
        infoPage.sendBlessing();
    }

    /**
     * Upload a photo to site, making sure cp folder will close automatically when we finish to upload
     * @throws InterruptedException
     * @throws AWTException
     */
    @Test
    public void Test13_uploadPhoto() throws InterruptedException, AWTException {
        Thread.sleep(1500);
         infoPage.uploadPhoto();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);

    }

    /**
     * Picking the default site suggest
     * @throws InterruptedException
     */
    @Test
    public void Test14_whenToSend() throws InterruptedException {
        Thread.sleep(1500);
        infoPage.sendByTime();

    }

    /**
     * Sending By mail
     * Hitting the mail icon, Filling email into email box and press save element.
     * @throws InterruptedException
     */
    @Test
    public void Test15_sendByMail() throws InterruptedException {

        Thread.sleep(1500);
      infoPage.sendByEmail();
    }




    @AfterClass
    public void close(){
driver.close();

    }



}


