package project.steps;

import io.cucumber.java.en.And;
import project.manager.PageManager;

public class ItemsSteps {

    PageManager pageManager = PageManager.getPageManager();

    @And("^Перейти в расширенный поиск$")
    public void clickButtonCreateTrip() {
        pageManager.getItemsPage().clickButtonAllFilters();
    }

}
