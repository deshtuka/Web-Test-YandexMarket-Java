package project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//*[@data-statlog='services_pinned.item.all']")
    private WebElement btnAllServices;

    @FindBy(xpath = "//*[@data-statlog='services_pinned.more_popup.item.market']")
    private WebElement btnMarket;

    public void getSite(String url) {
        // Вход на сайт
        this.openSite(url);
    }

    public void goToSectionMarket() {
        // Перейти в сервис "Маркет"
        this.isDisplayed("подраздел Телевизоры", btnAllServices);
        btnAllServices.click();

        this.isDisplayed("только Телевизоры", btnMarket);
        btnMarket.click();
    }
}
