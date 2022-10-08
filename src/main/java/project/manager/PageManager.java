package project.manager;

import project.pages.MainPage;
import project.pages.CatalogPage;
import project.pages.ItemsPage;
import project.pages.FilterPage;

public class PageManager {

    private static PageManager pageManager;

    private MainPage mainPage;
    private CatalogPage catalogPage;
    private ItemsPage itemsPage;
    private FilterPage filterPage;

    private PageManager() {
    }

    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    /** Инициализация объектов страниц */
    public MainPage getMainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }

    public CatalogPage getCatalogPage() {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        return catalogPage;
    }

    public ItemsPage getItemsPage() {
        if (itemsPage == null) {
            itemsPage = new ItemsPage();
        }
        return itemsPage;
    }

    public FilterPage getFilterPage() {
        if (filterPage == null) {
            filterPage = new FilterPage();
        }
        return filterPage;
    }
}