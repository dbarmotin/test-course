import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Homework2Tests {
    private static WebDriver driver;

    @BeforeClass
    public void DriverStart(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void YandexTest(){
        driver.get("https://yandex.ru/");

        driver.findElement(By.xpath("//span[text()='Настройка']")).click();
        driver.findElement(By.xpath("//a[text()='Настройки портала']")).click();
        driver.findElement(By.xpath("//a[text()='Язык']")).click();
        driver.findElement(By.className("select__button")).click();
        driver.findElement(By.xpath("//*[@class = 'select__list']//span[text()='English']")).click();
        driver.findElement(By.className("form__save")).click();

        driver.findElement(By.xpath("//span[text()='Настройка']")).click();
        driver.findElement(By.xpath("//a[text()='Настройки портала']")).click();
        
        String title = driver.findElement(By.cssSelector("h1.options__header")).getText();
        Assert.assertEquals(title,"Search settings");
    }


    @AfterClass
    public void DriverClose(){
        driver.quit();
    }

}
