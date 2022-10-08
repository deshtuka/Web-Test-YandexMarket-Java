package project.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CatalogPage extends BasePage {

    @FindBy(xpath = "//*[@data-baobab-name='top_menu']//a[contains(@href, 'elektronika')]")
    private WebElement sectionElectronic;

    @FindBy(xpath = "//*[@data-baobab-name='new-category-snippet']//a[contains(@href, 'televizory')]")
    private WebElement subsectionTv;
    @FindBy(xpath = "//*[@data-zone-name='link']//a[contains(@href, 'televizory')]")
    private WebElement subsectionOnlyTv;

    @FindBy(xpath = "//a[contains(@href, 'naushniki-i-audiotekhnika')]")
    private WebElement subsectionAudio;
    @FindBy(xpath = "//*[@data-zone-name='link']//a[contains(@href, 'naushniki')]")
    private WebElement subsectionOnlyAudio;

    public void clickSectionElectronics() {
        // Нажать на раздел Электроника
        this.switchToWindow();
        this.isDisplayed("раздел Электроника", sectionElectronic);
        sectionElectronic.click();
    }

    public void clickSubsection(String subName) {
        // Нажать на подраздел "..."
        switch (subName) {
            case "Телевизоры":
                subsectionTv.click();
                waitUntilVisibilityOf(subsectionOnlyTv);
                subsectionOnlyTv.click();
                break;
            case "Наушники и аудиотехника":
                subsectionAudio.click();
                waitUntilVisibilityOf(subsectionOnlyAudio);
                subsectionOnlyAudio.click();
                break;
            default:
                Assert.fail(String.format("Указанный подраздел \"%s\" отсутствует!", subName));
        }
    }
}
