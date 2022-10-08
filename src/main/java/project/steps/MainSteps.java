package project.steps;

import io.cucumber.java.en.And;
import project.manager.PageManager;

public class MainSteps {

    PageManager pageManager = PageManager.getPageManager();

    @And("^Зайти на сайт \"(.+)\"$")
    public void getSite(String url) {
        pageManager.getMainPage().getSite(url);
    }

    @And("^Перейти в сервис \"Маркет\"$")
    public void goToSectionMarket() {
        pageManager.getMainPage().goToSectionMarket();
    }
}
