import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HomePage {
    
    By productLocator1 = By.xpath("//article[@data-card-index='0']");
    By productLocator2 = By.xpath("//article[@data-card-index='2']");
    By productLocator3 = By.xpath("//article[@data-card-index='5']");
    By productLocator4 = By.xpath("//article[@data-card-index='4']");
    By backHomePage = By.xpath("//button[@class='breadcrumbs__back']");
    By addButton = By.xpath("//div[@class='product-page__order-container']/div[@class='order']/button[@aria-label='Добавить в корзину']");
    By sizeLocator = By.xpath("//ul[@class='sizes-list j-quick-order-sizes']/li[1]");
    By popupLocator = By.xpath("//div[@class='popup popup-list-of-sizes shown slideUp']");
    private WebDriver driver;
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void open() {
        driver.get("https://www.wildberries.ru");
    }
    
    private boolean isPopupDisplayed() {
        try {
            driver.findElement(popupLocator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    
    private void selectSize() {
        driver.findElement(sizeLocator).click();
    }
    
    public void addProductToBasket() {
        driver.findElement(productLocator1).click();
        driver.findElement(addButton).click();
        if (isPopupDisplayed()) {
            selectSize();
        }
        driver.findElement(backHomePage).click();
        //2
        driver.findElement(productLocator2).click();
        driver.findElement(addButton).click();
        if (isPopupDisplayed()) {
            selectSize();
        }
        driver.findElement(backHomePage).click();
        //3
        driver.findElement(productLocator3).click();
        driver.findElement(addButton).click();
        if (isPopupDisplayed()) {
            selectSize();
        }
        driver.findElement(backHomePage).click();
        //4
        driver.findElement(productLocator4).click();
        driver.findElement(addButton).click();
        if (isPopupDisplayed()) {
            selectSize();
        }
    }
}