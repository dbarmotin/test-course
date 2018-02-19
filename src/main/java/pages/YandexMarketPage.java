package pages;

import com.codeborne.selenide.impl.WebElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.PageFactory.initElements;

public class YandexMarketPage {

    private static WebDriver driver;

    @FindBy (css = ".n-snippet-card2")
    private List<WebElement> productsList;

    @FindBy (xpath = "//a[text()='по цене']/parent::div")
    private WebElement priceSortBtn;

    @FindBy (css = "div.price")
    private List<WebElement> productPrices;

    public YandexMarketPage(final WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }



    public void sortByPrice(){
        priceSortBtn.click();
    }

    public String getPriceSortBtnAtr(String atr){
        return priceSortBtn.getAttribute(atr);
    }

    public List<WebElement> getProductsList() {
        return productsList;
    }

    public List<String> getProductPrices() throws InterruptedException {

        Thread.sleep(2000);
//        (new WebDriverWait(driver,10))
//                .until(ExpectedConditions.visibilityOfAllElements(productPrices));

        return (List)productPrices.stream().map((e) -> {
            return e.getText();
        }).collect(Collectors.toList());

    }
}
