package dchizhova68;

import dchizhova68.pages.VerteraPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.open;

public class VerteraTests extends TestBase {
    VerteraPage verteraPage = new VerteraPage();
    final String[] itemMenu = new String[]{"О нас","Вопросы и ответы"};
    final String searchTextOnPage = "О компании";
    final String searchValue = "Можно ли употреблять продукты компании";
    @Test
    @DisplayName("Проверка cтраницы О нас")
    @Tag("FullScript")
    void openRightMenuTest() {
        verteraPage.openPage()
                .clickButtonSkip()
                .clickMenuItem(itemMenu[0])
                .checkAboutInfo(searchTextOnPage);
    }

    @Test
    @DisplayName("Проверка поиска вопросов")
    @Tag("FullScript")
    void searchTest() {
        verteraPage.openPage()
                .clickButtonSkip()
                .clickMenuItem(itemMenu[1])
                .setSearchValue(searchValue)
                .checkSearchValue(searchValue);
    }

    @CsvSource(value = {
            "Новосибирск",
            "Челябинск"
    })
    @ParameterizedTest
    @DisplayName("Проверка выбора города")
    @Tag("FullScript")
    void changeCityTest(String cityName) {
        verteraPage.openPage()
                .clickButtonSkip()
                .changeCity(cityName)
                .checkCity(cityName);
    }

    @Test
    @DisplayName("Проверка выпадающей панели со слайдером")
    @Tag("FullScript")
    void sliderTest() {
        verteraPage.openPage()
                .clickButtonSkip()
                .openCatalog()
                .checkSlider();
    }

    @CsvSource(value = {
            "Акция",
            "Детское питание"
    })
    @ParameterizedTest
    @Tag("FullScript")
    @DisplayName("Проверка навигационной цепочки")
    void breadcrumbsTest(String category) {
        verteraPage.openPage()
                .clickButtonSkip()
                .openCatalog()
                .clickCategoryItem(category)
                .checkBreadcrumbs(category);
    }


}
