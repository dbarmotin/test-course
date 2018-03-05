package autotest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ReporterConfig;
import org.testng.ReporterConfig.Property;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;
    protected static String driverHome;
    @BeforeSuite
    public void DriverStart() throws IOException {
        Properties property = new Properties();
        InputStream  is = new FileInputStream("src/main/resources/aplication.properties");
        property.load(is);
        driverHome = property.getProperty(driverHome);
       // System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
       // System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
        System.setProperty("webdriver.chrome.driver",driverHome);



        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void OpenPage(String url){
        driver.get(url);
    }

    @AfterSuite
    public void DriverClose(){
        driver.quit();
    }

}
