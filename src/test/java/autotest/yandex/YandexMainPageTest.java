package autotest.yandex;

import autotest.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.YandexPage;

public class YandexMainPageTest extends BaseTest {

    private static YandexPage yandexPage;

    @BeforeClass
    public void beforeTest() throws InterruptedException {
        yandexPage = PageFactory.initElements(driver, YandexPage.class);
    }

    @Test
    public void LanguageTest(){
        OpenPage("https://yandex.ru/");
        yandexPage.settingsClick()
                .selectTabByName("Язык")
                .selectLanguage("English")
                .saveChanges();

        yandexPage.settingsClick();
        String title = yandexPage.getHeader();
        Assert.assertEquals(title,"Search settings");
    }


    @Test
    public void WeatherTest() {
        OpenPage("https://ya.ru/");
        yandexPage.search("Погода в Пензе");
        String searchResult = yandexPage.getFirstSearchResult();
        Assert.assertEquals(searchResult,"Погода в Пензе");
    }

}
