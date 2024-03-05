import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BasketPage {
    
    By cartItems = By.xpath("//div[@class='accordion__list']");
    By productName = By.xpath("//span[@class='good-info__good-name']");
    By productPrice = By.xpath("//div[@class='list-item__price-new wallet']");
    By productQuantity = By.xpath("//h1[@data-count]");
    By totalPrice = By.xpath("//div[@class='summary-price']");
    private WebDriver driver;
    
    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void openBasket() {
        driver.get("https://www.wildberries.ru/lk/basket");
    }
    
    public List<String> getProductNames() {
        List<String> names = new ArrayList<>();
        List<WebElement> items = driver.findElements(cartItems);
        for (WebElement item : items) {
            names.add(item.findElement(productName).getText());
        }
        return names;
    }
    
    public List<Integer> getProductPrices() {
        List<Integer> prices = new ArrayList<>();
        List<WebElement> items = driver.findElements(cartItems);
        for (WebElement item : items) {
            String price = item.findElement(productPrice).getText();
            prices.add(Integer.parseInt(price.replaceAll("[^0-9.]", "")));
        }
        return prices;
    }
    
    public List<Integer> getProductQuantities() {
        List<Integer> quantities = new ArrayList<>();
        List<WebElement> items = driver.findElements(cartItems);
        for (WebElement item : items) {
            String quantity = item.findElement(productQuantity).getAttribute("data-count");
            quantities.add(Integer.parseInt(quantity));
        }
        return quantities;
    }
    
    public int getTotalPrice() {
        String total = driver.findElement(totalPrice).getText();
        return Integer.parseInt(total.replaceAll("[^0-9.]", ""));
    }
}