package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;
import static org.openqa.selenium.support.PageFactory.*;

public class YandexPage {

    private static WebDriver driver;

    @FindBy(css = ".input__control.input__input")
    private WebElement searchInput;

    @FindBy(xpath = "//li[@class = 'serp-item'][1]//h2/a")
    private WebElement firstSearchResult;

    @FindBy(xpath = "//span[text()='Настройка']")
    private WebElement settingsLink;

    @FindBy(xpath = "//a[text()='Настройки портала']")
    private WebElement portalSettingsLink;

    @FindBy(xpath = "//a[text()='Язык']")
    private WebElement languageTab;

    @FindBy(css = ".select__button")
    private WebElement selectLanguageBtn;

    @FindBy(xpath = "//*[@class = 'select__list']//span[text()='English']")
    private WebElement englishLanguageBtn;

    @FindBy(css = ".form__save")
    private WebElement saveBtn;

    @FindBy(css = "h1.options__header")
    private WebElement header;

    public YandexPage(final WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }

    public YandexPage settingsClick(){
        settingsLink.click();
        portalSettingsLink.click();
        return this;
    }

    public YandexPage selectTabByName(String tabName){
        driver.findElement(By.xpath("//a[text()='"+tabName+"']")).click();
        return this;
    }

    public YandexPage selectLanguage(String language){
        selectLanguageBtn.click();
        driver.findElement(By.xpath("//*[@class = 'select__list']//span[text()='"+language+"']")).click();
        return this;
    }

    public YandexPage saveChanges(){
        saveBtn.click();
        return this;
    }

    public String getHeader() {
        return header.getText();
    }

    public void search(String text){
        searchInput.clear();
        searchInput.sendKeys(text, Keys.ENTER);
    }

    public String getFirstSearchResult() {
        return firstSearchResult.getText();
    }



}
