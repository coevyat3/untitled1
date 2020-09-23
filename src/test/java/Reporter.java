import User.Info;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class Reporter {
        private static ChromeDriver driver;
        private static ExtentReports extent;
        private static ExtentTest test;
        @BeforeClass
        public static void BeforeClass(){
            ExtentSparkReporter htmlReporter= new ExtentSparkReporter("C:\\Users\\evy\\IdeaProjects\\untitled1\\src\\main\\resources\\ReporterData.html");
            extent= new ExtentReports();
            extent.attachReporter(htmlReporter);
            test=extent.createTest("Testing","samples");
            extent.setSystemInfo("Tester", "evyatar");
            test.log(Status.INFO,"@BeforeClass");
            boolean flag= false;
            try{
                File file1 = new File("C:\\chromedriver.exe");
                System.setProperty("webdriver.chrome.driver", file1.getAbsolutePath());
                driver = new ChromeDriver();
              driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                flag=true;
            }catch (Exception e){
                e.printStackTrace();
                test.log(Status.FAIL,"cant locate driver setting "+e.getMessage());
            }finally {
                if(flag){
                    test.log(Status.PASS,"Driver setting Ready ");
                }
            }

        }
        @Test
        public void Test01_openURL(){
            boolean address=false;
            try{
                driver.navigate().to("https://buyme.co.il/");
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
        @Test
        public void Test02_locateLoginButton(){
            new WebDriverWait(driver, 5).until(
                    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
            boolean flag=false;
            try{
Thread.sleep(1500);
               driver.findElement(By.xpath("//span[.='הרשמה']")).click();
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
        @Test
        public void Test03_locateRegistrationButton(){
            boolean flag=false;
            try{
                Thread.sleep(1500);
                driver.findElement(By.xpath("//*[text()[contains(.,'להרשמה')]]")).click();
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
        @Test
        public void Test04_setDataIntoRegistrationBoxes(){
            boolean flag=false;
            try{
                Thread.sleep(1500);
                driver.findElement(By.xpath("//input[@placeholder='שם פרטי']")).sendKeys(Info.getUserName());
                driver.findElement(By.xpath("//input[@placeholder='מייל']")).sendKeys(Info.getEmail());
                driver.findElement(By.xpath("//input[@placeholder='סיסמה']")).sendKeys(Info.getPassword());
                driver.findElement(By.xpath("//input[@placeholder='אימות סיסמה']")).sendKeys(Info.getConfirmPassword());
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
        @Test
        public void Test05_confirmRegistration(){

            boolean flag=false;
            try{
                Thread.sleep(1500);
                driver.findElement(By.xpath("//*[text()[contains(.,'הרשמה ל-BUYME')]]")).click();
                Thread.sleep(1500);
                flag=true;
            }catch (Exception e){
                e.printStackTrace();
                test.log(Status.FAIL,"Cant locate register button "+e.getMessage());
            }finally {
                if(flag){
                    test.log(Status.PASS,"Registration to site successes");
                }
            }
        }
        @Test
        public void Test06_insertPriceValueIntoNavBar(){
            boolean flag=false;
            try{
                Thread.sleep(1500);
                driver.findElement(By.xpath("//span[.='סכום']")).click();
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
        @Test
        public void Test07_insertRegionValueIntoNavBar(){
            boolean flag=false;
            try{
                Thread.sleep(1500);
                driver.findElement(By.xpath("//span[.='אזור']")).click();
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
        @Test
        public void test08_insertCategoryValueIntoNavBar(){
            boolean flag=false;
            try{
                Thread.sleep(1500);
                driver.findElement(By.xpath("//span[.='קטגוריה']")).click();
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
        @Test
        public void test10_findMeAGiftButton(){

            boolean flag=false;
            try{
                Thread.sleep(1500);
                driver.findElement(By.xpath("//*[text()[contains(.,'תמצאו לי מתנה')]]")).click();
                Thread.sleep(1500);
                flag=true;
            }catch (Exception e){
                e.printStackTrace();
                test.log(Status.FAIL,"Cant locate found me a gift button  "+e.getMessage());
            }finally {
                if(flag){
                    test.log(Status.PASS,"Locate find me a gift button & press it");
                }
            }
        }
        @Test
        public void test11_pickingGif(){
            new WebDriverWait(driver, 5).until(
                    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
            boolean flag=false;
            try{
                Thread.sleep(1500);
                driver.findElement(By.xpath("//*[text()[contains(.,'BUYME KOSHER')]]")).click();
                Thread.sleep(1500);
                flag=true;
            }catch (Exception e){
                e.printStackTrace();
                test.log(Status.FAIL,"Cant locate a gif from result list  "+e.getMessage());
            }finally {
                if(flag){
                    test.log(Status.PASS,"Success picking a gif from result list");
                }
            }
        }
        @Test
        public void test12_InsertGifPrice(){
            boolean flag=false;
            try{
                Thread.sleep(1500);
                driver.findElement(By.className("input-cash")).sendKeys(String.valueOf(120));
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
        @Test
        public void test13_ConfirmGifButton(){
            boolean flag=false;
            try{
                Thread.sleep(1500);
                driver.findElement(By.className("btn-wrapper")).click();
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
        @Test
        public void test14_someOneElseRadioButton(){
            new WebDriverWait(driver, 5).until(
                    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
            boolean flag=false;
            try{
                Thread.sleep(1500);
                driver.findElement(By.xpath("//*[text()[contains(.,'למישהו אחר')]]")).click();
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
        @Test
        public void test15_whoToSendTextBox(){
            boolean flag=false;
            String str="אח שלי גיבור ";
            String str1="//input[@data-parsley-required-message='מי הזוכה המאושר? יש להשלים את שם המקבל/ת']";
            try{
                driver.findElement(By.xpath(str1)).sendKeys(str);
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
        @Test
        public void test16_SenderGifTextBox(){
            boolean flag=false;
            String str="//input[@data-parsley-required-message='למי יגידו תודה? שכחת למלא את השם שלך']";
            String str2= Info.getUserName();

            try{
                WebElement wd=driver.findElement(By.xpath(str));
                wd.clear();
                driver.findElement(By.xpath(str)).sendKeys(str2);
                Thread.sleep(1500);
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
        @Test
        public void test17_pickingEventFromDropdown(){
            boolean flag=false;
            try{
                driver.findElement(By.xpath("//*[text()[contains(.,'לאיזה אירוע')]]")).click();
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
        @Test
        public void test18_addingABlessText(){
            boolean flag=false;
            try{
                WebElement elem = driver.findElement(By.tagName("textarea"));
                Thread.sleep(1500);
                elem.clear();
                elem.sendKeys("מזל טוב אוהב דקל");
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
        @Test
        public void test19_uploadAPhoto() throws AWTException {
            boolean flag=false;
            Robot robot = new Robot();
            try{
                String str="C:\\Users\\evy\\IdeaProjects\\untitled1\\חח.jpg";
                driver.findElement(By.className("ui-file")).click();
                driver.findElement(By.name("fileUpload")).sendKeys(str);
                Thread.sleep(1500);
                flag=true;
            }catch (Exception e){
                e.printStackTrace();
                test.log(Status.FAIL,"cant locate element  "+e.getMessage());
            }finally {
                if(flag){
                    robot.keyPress(KeyEvent.VK_ESCAPE);
                    robot.keyRelease(KeyEvent.VK_ESCAPE);
                    test.log(Status.PASS,"Upload photo success");
                }
            }
        }
        @Test
        public void test20_rightAfterPayment(){
            boolean flag=false;
            try{
                driver.findElement(By.className("send-now")).click();
                Thread.sleep(1500);
                flag=true;
            }catch (Exception e){
                e.printStackTrace();
                test.log(Status.FAIL,"Cant locate Registration Button"+ e.getMessage());
            }finally {
                if(flag){
                    test.log(Status.PASS,"Succsess pressing right after payment  radio button");
                }
            }

        }
        @Test
        public void test21_sendWithMail(){
            String str="//input[@data-parsley-type-message='נראה שחסר משהו במייל, אולי שטרודל?']";
            String email="abc@gmail.com";
            boolean flag=false;
            try{
                driver.findElement(By.xpath("//*[text()[contains(.,'במייל')]]")).click();
                Thread.sleep(1500);
                driver.findElement(By.xpath(str)).sendKeys(email);
                Thread.sleep(1500);
                driver.findElement(By.xpath("//*[text()[contains(.,'שמירה')]]")).click();
                flag=true;
            }catch (Exception e){
                e.printStackTrace();
                test.log(Status.FAIL,"what happened"+ e.getMessage());
            }finally {
                if(flag){
                    test.log(Status.PASS,"Success sending gif via mail");
                }
            }
        }



        @AfterClass
        public static void AfterClass(){
            driver.quit();
            extent.flush();

        }
    }

