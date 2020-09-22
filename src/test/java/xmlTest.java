import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class xmlTest {
    private static WebDriver driver;

    @BeforeClass
    public static void beforeClass() throws Exception {
      String type=getData("browserType");
      if(type.equals("Chrome")) {
          File file1 = new File("C:\\chromedriver.exe");
          System.setProperty("webdriver.chrome.driver", file1.getAbsolutePath());
          driver = new ChromeDriver();
      }
  driver.get(getData("URL"));
    }

@Test
public void openURL(){
        driver.get("https://buyme.co.il/");
}

    public static String getData(String keyName) throws ParserConfigurationException, IOException, SAXException {

        File fXmlFile= new File(("C:\\Users\\evy\\IdeaProjects\\untitled1\\src\\main\\resources\\data.xml"));
        DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
        Document doc=  dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return  doc.getElementsByTagName(keyName).item(0).getTextContent();


    }

    @AfterClass
    public  static  void afterClass() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}