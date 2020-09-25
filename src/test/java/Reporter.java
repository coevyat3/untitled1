import Drivers.DriverSingleton;
import User.Info;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sitePages.HomePage;
import sitePages.InfoPage;
import sitePages.PickBusiness;
import sitePages.RegistrationPage;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Note : i deleted the screen shot function was not in use all test run should run
 */
public class Reporter  {
    private static String siteTesting="https://buyme.co.il/";
    private static WebDriver driver;
    private static ExtentReports extent;
    private static ExtentTest test;
    private static RegistrationPage register = new RegistrationPage();
    private static HomePage homePage= new HomePage();
    private static PickBusiness pickBusiness= new PickBusiness();
    private static InfoPage infoPage= new InfoPage();
  //  private static String timeNow=String.valueOf(System.currentTimeMillis());
   // private static String filepath="C:\\Users\\evy\\IdeaProjects\\untitled1\\src\\main\\resources\\";
    @BeforeClass
    public static void BeforeClass() {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\Users\\evy\\IdeaProjects\\untitled1\\src\\main\\resources\\ReporterData.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest("Testing", "samples");
        extent.setSystemInfo("Tester", "evyatar");
        test.log(Status.INFO, "@BeforeClass");
        driver = DriverSingleton.getDriverInstance();
    }

    /**
     * Open url
     */
    @Test
    public void Test01_openURL(){
        boolean address=false;
        try{
            driver.navigate().to(siteTesting);
            Thread.sleep(1500);
            address=true;
        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL,"Cant locate site address "+e.getMessage());
        }finally {
            if(address){
                test.log(Status.PASS,"Open Site success");
            }
        }

    }

    /**
     * Locating Login button
     * Letting all element reload.
     * then searching for the element
     */


    @Test
    public void Test02_locateLoginButton(){
        new WebDriverWait(driver, 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        boolean flag=false;
        try{
            register.gotoLoginPage();
            Thread.sleep(1500);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL,"Cant locate Login button "+e.getMessage());
        }finally {
            if(flag){
                test.log(Status.PASS,"Found Login Button");
            }
        }
    }

    /**
     * Locating Register button
     */
    @Test
    public void Test03_locateRegistrationButton(){
        boolean flag=false;
        try{
            register.gotoRegisterPage();
            Thread.sleep(1500);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL,"Cant locate Registration Button"+ e.getMessage());
        }finally {
            if(flag){
                test.log(Status.PASS,"Found Registration Button");
            }
        }
    }

    /**
     * Setting data into registration Boxes.
     * If error occur in registering (error :"Email in used") Change email address in user/info -> email field.
     */
    @Test
    public void Test04_setDataIntoRegistrationBoxes(){
        boolean flag=false;
        try{
            Thread.sleep(1500);
            register.setData();
           Thread.sleep(1500);
            Thread.sleep(1500);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL,"Cant locate site address"+ e.getMessage());
        }finally {
            if(flag){
                test.log(Status.PASS,"Filling Registration Data Success");
            }
        }
    }

    /**
     * Locating price element selected by default and picking price value from list
     */
    @Test
    public void Test06_insertPriceValueIntoNavBar(){
        boolean flag=false;
        try{
            homePage.ClickPriceList();
            Thread.sleep(1500);
            driver.findElements(By.className("active-result")).get(1).click();
            Thread.sleep(1500);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL,"Cant locate price element in  navbar  "+e.getMessage());
        }finally {
            if(flag){
                test.log(Status.PASS,"Located price element & insert new value");
            }
        }
    }

    /**
     * Locating Region element selected from navbar and picking value from the dropdown list
     */
    @Test
    public void Test07_insertRegionValueIntoNavBar(){
        boolean flag=false;
        try{
            Thread.sleep(1500);
            homePage.clickRegionList();
            Thread.sleep(1500);
            driver.findElements(By.className("active-result")).get(3).click();
            Thread.sleep(1500);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL,"Cant locate region element in  navbar  "+e.getMessage());
        }finally {
            if(flag){
                test.log(Status.PASS,"Located region element & insert new value");
            }
        }
    }

    /**
     * Locating the category element selected in navbar and picking category from dropdown list
     */
    @Test
    public void test08_insertCategoryValueIntoNavBar(){
        boolean flag=false;
        try{

            homePage.clickCategoryList();
            Thread.sleep(1500);
            driver.findElements(By.className("active-result")).get(2).click();
            Thread.sleep(1500);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL,"Cant locate region Category element in  navbar  "+e.getMessage());
        }finally {
            if(flag){
                test.log(Status.PASS,"Located category element @ insert new value");
            }
        }
    }

    /**
     * Pressing the find me a gif button
     */
    @Test
    public void test10_findMeAGiftButton(){

        boolean flag=false;
        try{
            Thread.sleep(1500);
            homePage.findMeGiftButton();
            Thread.sleep(1500);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL,"Cant locate found me a gif button ");
        }finally {
            if(flag){
                test.log(Status.PASS,"Locate find me a gift button & press it");
            }
        }
    }

    /**
     * Moving to a new page - gif result page
     * Letting all element reload.
     *  picking 1 item from the result list
     */
    @Test
    public void test11_pickingGif(){
        new WebDriverWait(driver, 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        String site = "https://buyme.co.il/search?budget=1&category=16&region=9";
        boolean flag=false;
        try{
            Thread.sleep(1500);
            pickBusiness.pickItem();
            Assert.assertEquals(driver.getCurrentUrl(), site);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL,"Cant locate a gif from result list  ");
        }finally {
            if(flag){
                test.log(Status.PASS,"Success picking a gif from result list");
            }
        }
    }

    /**
     * Moving to a new page. letting all element reload.
     * Inserting amount into price box for the gif we picked
     */
    @Test
    public void test12_InsertGifPrice(){
        boolean flag=false;
        new WebDriverWait(driver, 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        try{
            Thread.sleep(1500);
            pickBusiness.insert_price();
            Thread.sleep(1500);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL,"cant locate element  "+e.getMessage());
        }finally {
            if(flag){
                test.log(Status.PASS,"Success insert value");
            }
        }
    }

    /**
     * Pressing on find me a gif button.
     */
    @Test
    public void test13_ConfirmGifButton(){
        boolean flag=false;
        try{
            pickBusiness.pressButton();
            Thread.sleep(1500);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL,"cant locate element  "+e.getMessage());
        }finally {
            if(flag){
                test.log(Status.PASS,"Success pressing Picking a gif Button ");
            }
        }
    }

    /**
     * Moving to new page letting all element reload.
     * Pressing someone else box (even tho is the chosen one by default)
     */
    @Test
    public void test14_someOneElseRadioButton(){
        new WebDriverWait(driver, 5).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        boolean flag=false;
        try{
            Thread.sleep(1500);
            infoPage.pickSomeOneElseRadioButton();
            Thread.sleep(1500);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL,"cant locate element  "+e.getMessage());
        }finally {
            if(flag){
                test.log(Status.PASS,"Success picking someone else radio button");
            }
        }
    }

    /**
     * Inserting a value into who to send box
     */
    @Test
    public void test15_whoToSendTextBox(){
        boolean flag=false;
        try{
            infoPage.receivingBoxName();
            Thread.sleep(1500);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL,"cant locate element  "+e.getMessage());
        }finally {
            if(flag){
                test.log(Status.PASS,"Success Filling who to send text box");
            }
        }
    }

    /**
     * first we delete what site already fill in who send the gif box-( user name )
     * and enter again value ( same one but still) into the box.
     */
    @Test
    public void test16_SenderGifTextBox(){
        boolean flag=false;
        try{
            Thread.sleep(1500);
            WebElement ele=driver.findElement(By.xpath("//input[@data-parsley-required-message='למי יגידו תודה? שכחת למלא את השם שלך']"));
            ele.clear();
            Thread.sleep(1500);
            infoPage.SenderBoxName();
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL,"cant locate element  "+e.getMessage());
        }finally {
            if(flag){
                test.log(Status.PASS,"Success Filling who send the gift text box");
            }
        }
    }

    /**
     * Picking an event from event dropdown list.
     */
    @Test
    public void test17_pickingEventFromDropdown(){
        boolean flag=false;
        try{
            infoPage.EventPick();
            Thread.sleep(1500);
            driver.findElements(By.className("active-result")).get(2).click();
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL,"cant locate element  "+e.getMessage());
        }finally {
            if(flag){
                test.log(Status.PASS,"Success picking a event from event list");
            }
        }

    }

    /**
     * deleting first what site suggest for blessing  textarea box
     * adding own blessing.
     *
     */
    @Test
    public void test18_addingABlessText(){
        boolean flag=false;
        try{
            WebElement elem = driver.findElement(By.tagName("textarea"));
            Thread.sleep(1500);
            elem.clear();
            Thread.sleep(1500);
            infoPage.sendBlessing();
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL,"cant locate element  "+e.getMessage());
        }finally {
            if(flag){
                test.log(Status.PASS,"Success adding own blessing ");
            }
        }

    }

    /**
     * Adding a photo in site, and close the pc folder auto.
     * @throws AWTException
     */
    @Test
    public void test19_uploadAPhoto() throws AWTException {
        boolean flag=false;

        try{
            Thread.sleep(1500);
            infoPage.uploadPhoto();
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL,"cant locate element  "+e.getMessage());
        }finally {
            if(flag){

            }
        }
    }

    /**
     * Picking right after payment radio button
     */
    @Test
    public void test20_rightAfterPayment(){
        boolean flag=false;
        try{
            Thread.sleep(1500);
            infoPage.sendByTime();
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL,"Cant locate Right afterPayment Button "+ e.getMessage());
        }finally {
            if(flag){
                test.log(Status.PASS,"Success pressing right after payment  radio button");
            }
        }

    }

    /**
     * Sending email into email box & confirm.
     */
    @Test
    public void test21_sendWithMail(){
        boolean flag=false;
        try{
            Thread.sleep(1500);
            infoPage.sendByEmail();
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL,"Setting email failed "+ e.getMessage());
        }finally {
            if(flag){
                test.log(Status.PASS,"Locator found & insert email into box");
            }
        }
    }


    /**
     * Writing all test data into html file
     * ReporterData.html
     */
    @AfterClass
    public static void AfterClass(){
        test.log(Status.INFO,"@AfterClass");
        driver.quit();
        extent.flush();

    }



}