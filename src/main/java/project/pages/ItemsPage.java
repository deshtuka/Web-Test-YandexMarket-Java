package project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemsPage extends BasePage {

    @FindBy(xpath = "//*[@data-baobab-name='all_filters_button']//button")
    private WebElement btnAllFilers;

    public void clickButtonAllFilters() {
        // Зайти в расширенный поиск (в самом низу кнопка "Все фильтры")
        this.isDisplayed("Все фильтры", btnAllFilers);
        btnAllFilers.click();
    }
}
