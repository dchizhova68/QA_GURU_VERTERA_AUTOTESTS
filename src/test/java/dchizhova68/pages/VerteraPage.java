package dchizhova68.pages;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Tag;

public class VerteraPage {
    private SelenideElement
            skipButton = $(byTagAndText("span", "Пропустить")),
            aboutInfoBlok = $(".about__info"),
            questionHeader = $(".faq__panel.active").$(".faq__panel--header--text"),
            geoMenuButton = $(".menu__geo--button"),
            currentCityLocator = $(".menu__geo--city"),
            catalogButton = $(".header__button--catalog"),
            sliderPanel = $(".catalog.opened");


    private ElementsCollection
            citiesList = $(".cities").$$("span"),
            categoryList = $$(".category--item--name"),
            breadcrumbsList = $$(".breadcrumbs li");


    @Step("Открыть главную страницу")
    public VerteraPage openPage() {
        open("/");
        return this;
    }

    @Step("Нажать кнопку Пропустить")
    public VerteraPage clickButtonSkip() {
        skipButton.click();
        return this;
    }

    @Step("Выбрать пункт меню {itemName}")
    public VerteraPage clickMenuItem(String itemName) {
        $(byTagAndText("a", itemName)).click();
        return this;
    }

    @Step("Проверить, что на странице есть текст {value}")
    public VerteraPage checkAboutInfo(String value) {
        aboutInfoBlok.shouldHave(text(value));
        return this;
    }

    @Step("Ввести вопрос для поиска")
    public VerteraPage setSearchValue(String searchValue) {
        $(".faq__search--input").setValue(searchValue).pressEnter();

        return this;
    }

    @Step("Проверить, что развернут ответ на заданный вопрос")
    public VerteraPage checkSearchValue(String searchValue) {
        questionHeader.shouldHave(text(searchValue));

        return this;
    }

    @Step("Изменить город")
    public VerteraPage changeCity(String city) {
        geoMenuButton.click();
        citiesList.findBy(text(city)).click();
        return this;
    }

    @Step("Проверить, что город изменен")
    public VerteraPage checkCity(String city) {
        currentCityLocator.shouldHave(text(city));
        return this;
    }

    @Step("Открыть каталог товаров")
    public VerteraPage openCatalog() {
        catalogButton.click();
        return this;
    }

    @Step("Проверить, что панель со слайдером видна")
    public VerteraPage checkSlider() {
        sliderPanel.shouldBe(visible);
        return this;
    }

    @Step("Выбрать категорию {categoryItemName}")
    public VerteraPage clickCategoryItem(String catigory) {
        categoryList.findBy(text(catigory)).click();
        return this;
    }

    @Step("Проверяем навигационную цепочку")
    public VerteraPage checkBreadcrumbs(String catigory) {
        breadcrumbsList.shouldHave(exactTexts("Главная", "Каталог", catigory));
        return this;
    }


}
