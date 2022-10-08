package project.steps;

import io.cucumber.java.en.And;
import project.manager.PageManager;

public class CatalogSteps {

    PageManager pageManager = PageManager.getPageManager();

    @And("^Нажать на раздел \"Электроника\"$")
    public void clickSectionElectronics() {
        pageManager.getCatalogPage().clickSectionElectronics();
    }

    @And("^Нажать на подраздел \"(.+)\"$")
    public void clickSubsection(String subName) {
        pageManager.getCatalogPage().clickSubsection(subName);
    }

}
