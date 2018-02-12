package autotest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

public class FirstTest {

    private static WebDriver driver;

    @BeforeClass
    public void DriverStart(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void MailRuLocatorsTest(){
        driver.get("https://account.mail.ru/signup?from=main&rf=auth.mail.ru");
        WebElement headerText = driver.findElement(cssSelector("span.b-panel__header__text"));
        WebElement firstNameLabel = driver.findElement(xpath("//*[@data-field-name = 'firstname']//label"));
        WebElement secondNameLabel = driver.findElement(xpath("//*[@data-field-name = 'lastname']//label"));
        WebElement firstNameInput = driver.findElement(By.name("firstname"));
        WebElement secondNameInput = driver.findElement(By.name("lastname"));
        WebElement birthdate = driver.findElement(xpath("//*[@data-field-name = 'birthdate']//label"));
        WebElement dateDaySelector = driver.findElement(cssSelector("div.b-date__day"));
        List<WebElement> dateDays = driver.findElements(cssSelector("div.b-date__day a"));
        WebElement dateMonthSelector = driver.findElement(cssSelector("div.b-date__month"));
        List<WebElement> dateMonths = driver.findElements(cssSelector("div.b-date__month a"));
        WebElement dateYearSelector = driver.findElement(cssSelector("div.b-date__year"));
        List<WebElement> dateYears = driver.findElements(cssSelector("div.b-date__year a"));
        WebElement menSexBtn = driver.findElement(xpath("(//*[@class= 'b-radiogroup__radio'])[1]"));
        WebElement womenSexBtn = driver.findElement(xpath("(//*[@class= 'b-radiogroup__radio'])[2]"));
        WebElement menSexLabel = driver.findElement(xpath("//*[@data-mnemo = 'sex-male']//span/span/span"));
        WebElement womenSexLabel = driver.findElement(xpath("//*[@data-mnemo = 'sex-female']//span/span/span"));
        WebElement emailLabel = driver.findElement(xpath("//*[@data-field-name = 'email']//label"));
        WebElement emailInput = driver.findElement(cssSelector(".b-email__name > input"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement passwordLabel = driver.findElement(xpath("//*[@data-field-name = 'password']//label"));
        WebElement passwordEye = driver.findElement(cssSelector("div.b-password__eye"));
        WebElement phoneLabel = driver.findElement(xpath("//*[@data-field-name = 'phone']//label"));
        WebElement coutrySelector = driver.findElement(xpath("(//*[@class = 'b-dropdown__ctrl'])[5]"));
        List<WebElement> countries = driver.findElements(xpath("(//*[@class = 'b-dropdown__list'])[5]/a"));
        WebElement phoneNumberInput = driver.findElement(cssSelector(".b-phone__input-box input"));
        WebElement phoneLink = driver.findElement(cssSelector("div.b-form-field__message a"));
        WebElement registerationBtn = driver.findElement(cssSelector("button.btn "));
        WebElement agrigmentLink = driver.findElement(cssSelector("div.b-form__controls__message a"));

    }

    @Test
    public void SoftwareLocatorsTest(){
        driver.get("http://software-testing.ru/");
        WebElement homeLink = driver.findElement(cssSelector("#tpdiv-logo a"));
        WebElement sidebarMenuItem = driver.findElement(xpath("//*[@class = 'menu']/li[4]"));
        WebElement sidebarInstrumentItem = driver.findElement(xpath("//*[text()='Selenium']"));
        WebElement topMenuItem = driver.findElement(xpath("//*[@id='tp-cssmenu']/li[3]/a"));
        WebElement search = driver.findElement(className("inputbox-search"));
        WebElement fontSizeBtn = driver.findElement(cssSelector(".fontSizePlus img"));
        WebElement postTitle = driver.findElements(className("contentheading")).get(3);
    }

    @Test
    public void WeatherTest() {
        driver.get("https://ya.ru/");
        WebElement search = driver.findElement(cssSelector(".input__control.input__input"));
        search.clear();
        search.sendKeys("Погода в Пензе", Keys.ENTER);
        String searchResult = driver.findElement(xpath("//li[@class = 'serp-item'][1]//h2/a")).getText();
        Assert.assertEquals(searchResult,"Погода в Пензе");
    }

    @AfterClass
    public void DriverClose(){
        driver.quit();
    }
}
