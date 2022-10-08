package project.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import project.manager.PageManager;

public class FilterSteps {

    PageManager pageManager = PageManager.getPageManager();

    @And("^Задать параметр поиска по цене от \"(\\d+)\" рублей$")
    public void fillFieldPriceFrom(String priceFrom) {
        pageManager.getFilterPage().fillFieldPriceFrom(priceFrom);
    }

    @And("^Выбрать производителя \"(.+)\"$")
    public void selectBrandFromList(String nameBrand) {
        pageManager.getFilterPage().selectBrandFromList(nameBrand);
    }

    @And("^Нажать кнопку \"Показать предложения\"$")
    public void clickButtonShowOffers() {
        pageManager.getFilterPage().clickButtonShowOffers();
    }

    @And("^Кол-во элементов на первой странице \"(\\d+)\"$")
    public void checkCountShowItemsOnFirstPage(Integer countItems) {
        pageManager.getFilterPage().checkCountShowItemsOnFirstPage(countItems);
    }

    @And("^Сохранить в памяти название первого товара$")
    public void saveFirstElementName() {
        pageManager.getFilterPage().saveFirstElementName();
    }

    @And("^Ввести в поиск сохраненное название$")
    public void enterSavedNameIntoSearch() {
        pageManager.getFilterPage().enterSavedNameIntoSearch();
    }

    @And("^Нажать кнопку \"Найти\"$")
    public void clickButtonSearch() {
        pageManager.getFilterPage().clickButtonSearch();
    }

    @And("^Проверить, что сохраненный товар найден$")
    public void checkSavedItemFound() {
        pageManager.getFilterPage().checkSavedItemFound();
    }

}
