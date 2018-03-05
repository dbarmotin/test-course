package autotest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeSuite
    public void DriverStart(){
       // System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");


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
