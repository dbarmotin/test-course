package autotest.yandex;

import autotest.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.YandexMarketPage;

import java.util.List;
import java.util.stream.Collectors;

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
    public void ProductsCountTest(){
        int productsCount = yandexMarketPage.getProductsList().size();
        Assert.assertEquals(productsCount,12);
    }

    @Test
    public void SortingAscTest() throws InterruptedException {
        yandexMarketPage.sortByPrice();
        Assert.assertTrue(yandexMarketPage.getPriceSortBtnAtr("class").contains(SORT_ASC_CLASS));
        Assert.assertTrue(yandexMarketPage.getPriceSortBtnAtr("class").contains(ACTIVE_SORT_BTN_CLASS));

        List<String> ascSortedPrices = yandexMarketPage.getProductPrices();
        List<String> expectedSortList = GetAscSortedList(ascSortedPrices);
        Assert.assertEquals(ascSortedPrices,expectedSortList);

    }

    @Test
    public void SortingDescTest() throws InterruptedException {

        yandexMarketPage.sortByPrice();
        Assert.assertTrue(yandexMarketPage.getPriceSortBtnAtr("class").contains(SORT_DESC_CLASS));
        Assert.assertTrue(yandexMarketPage.getPriceSortBtnAtr("class").contains(ACTIVE_SORT_BTN_CLASS));

        List<String> descSortedPrices = yandexMarketPage.getProductPrices();
        List<String> expectedSortList = GetDescSortedList(descSortedPrices);

        Assert.assertEquals(descSortedPrices,expectedSortList);

    }

    public List<String> GetAscSortedList(List<String> list){
        return list.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<String> GetDescSortedList(List<String> list){
        return list.stream()
                .sorted((o1, o2) -> -o1.compareTo(o2))
                .collect(Collectors.toList());
    }

}
