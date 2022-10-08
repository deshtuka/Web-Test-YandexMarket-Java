package project.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class FilterPage extends BasePage {

    @FindBy(xpath = "//*[@data-filter-id='glprice']//*[@data-prefix='от']//input")
    private WebElement inputPriceFrom;
    @FindBy(xpath = "//h4[text()='Производитель']/ancestor::div[1]")
    private WebElement checkBoxBrand;
    @FindBy(xpath = "//a[contains(text(), 'Показать') and contains(text(), 'предложени')]")
    private WebElement btnShowOffers;

    @FindBy(xpath = "//*[@data-auto='pager-more']")
    private WebElement btnShowMore;

    @FindBy(xpath = "//*[@data-autotest-id='product-snippet']")
    private List<WebElement> countShowItems;

    @FindBy(xpath = "//*[@data-test-id='virtuoso-item-list']/div[2]//a[@data-baobab-name='title']")
    private WebElement nameFirstElement;
    @FindBy(xpath = "//*[@data-grabber='SearchSerp']")
    private WebElement resultSearch;

    @FindBy(xpath = "//*[@id='header-search']")
    private WebElement inputSearch;
    @FindBy(xpath = "//*[@data-r='search-button']")
    private WebElement btnSearch;

    private String saveNameElement = null;

    public void fillFieldPriceFrom(String value) {
        // Заполнение поля "Цена от"
        this.isDisplayed("Цена от", inputPriceFrom);
        this.enterInput(inputPriceFrom, value);
        this.isContainsValue(value, inputPriceFrom);
    }

    public void selectBrandFromList(String nameBrand) {
        // Выбор из списка производителей
        WebElement brandToClick = checkBoxBrand.findElement(By.xpath(String.format(".//input[@value='%s']/..", nameBrand)));
        moveToElement(brandToClick);
        waitToBeClickableAndClick(brandToClick);
        WebElement brandCheckClick = brandToClick.findElement(By.xpath("./input"));
        this.isSelected(nameBrand, brandCheckClick);
    }

    public void clickButtonShowOffers() {
        // Показать предожения
        moveToElement(btnShowOffers);
        waitToBeClickableAndClick(btnShowOffers);
    }

    public void checkCountShowItemsOnFirstPage(Integer countItems) {
        // Проверка, сколько карточек распологается на странице
        moveToElement(btnShowMore);
        Integer count = countShowItems.size();
        Assert.assertEquals("Отображается разное кол-во товаров", countItems, count);
    }

    public void saveFirstElementName() {
        // Сохранить в памяти название первого товара
        moveToElement(nameFirstElement);
        saveNameElement = nameFirstElement.getAttribute("title");
    }

    public void enterSavedNameIntoSearch() {
        // Ввести в поиск сохраненное название
        moveToElement(nameFirstElement);
        if (saveNameElement != null) {
            this.enterInput(inputSearch, saveNameElement);
        }
    }

    public void clickButtonSearch() {
        // Нажать кнопку поиска
        waitToBeClickableAndClick(btnSearch);
    }

    public void checkSavedItemFound() {
        // Проверить, что найден сохраненный товар
        WebElement foundElement = resultSearch.findElement(
                By.xpath(String.format(".//*[contains(@title, '%s')]", saveNameElement)));
        this.isDisplayed(saveNameElement, foundElement);
    }
}
