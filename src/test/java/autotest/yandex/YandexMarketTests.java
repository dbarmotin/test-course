package autotest.yandex;

import autotest.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.YandexMarketPage;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$;

public class YandexMarketTests extends BaseTest{

    private static YandexMarketPage yandexMarketPage;
    private static String SORT_ASC_CLASS = "n-filter-sorter_sort_asc";
    private static String SORT_DESC_CLASS = "n-filter-sorter_sort_desc";
    private static String ACTIVE_SORT_BTN_CLASS = "n-filter-sorter_state_select";


    @BeforeClass
    public void beforeTest() throws InterruptedException {
        yandexMarketPage = PageFactory.initElements(driver, YandexMarketPage.class);
        OpenPage("https://market.yandex.ru/catalog/54726/list?was_redir=1&hid=91491&rt=10&text=iphone&local-offers-first=0&deliveryincluded=0&onstock=1&viewtype=list");
    }

    @Test
    public void SortingTest() throws InterruptedException {

        int productsListSize = yandexMarketPage.getProductsList().size();
        Assert.assertEquals(productsListSize,12);

        yandexMarketPage.sortByPrice();
        Assert.assertTrue(yandexMarketPage.getPriceSortBtnAtr("class").contains(SORT_ASC_CLASS));
        Assert.assertTrue(yandexMarketPage.getPriceSortBtnAtr("class").contains(ACTIVE_SORT_BTN_CLASS));

        List<String> ascSortedPrices = yandexMarketPage.getProductPrices();
        List<String> expectedSortList =  ascSortedPrices.stream()
                .sorted()
                .collect(Collectors.toList());
        Assert.assertEquals(ascSortedPrices,expectedSortList);

        yandexMarketPage.sortByPrice();
        Assert.assertTrue(yandexMarketPage.getPriceSortBtnAtr("class").contains(SORT_DESC_CLASS));

        List<String> descSortedPrices = yandexMarketPage.getProductPrices();
        expectedSortList =  descSortedPrices.stream()
                .sorted((o1, o2) -> -o1.compareTo(o2))
                .collect(Collectors.toList());
        Assert.assertEquals(descSortedPrices,expectedSortList);

    }
}
