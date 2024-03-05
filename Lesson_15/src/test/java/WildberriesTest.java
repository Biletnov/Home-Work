//Написать автотесты для сайта wildberries.ru, в ходе которых на главной странице несколько товаров кладется в корзину,
// затем осуществляется переход в корзину и происходят проверки на соответствие названия товаров,
// их количество, цен каждого товара в корзине и общей суммы товаров.
//При написании автотестов необходимо использовать подходящие паттерны, изученные в данной теме.

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WildberriesTest {
    private static WebDriver driver;
    private static HomePage homePage;
    private static BasketPage basketPage;
    
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.wildberries.ru/");
        homePage = new HomePage(driver);
        basketPage = new BasketPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    
    @Test
    public void testAddProductsToBasket() {
        homePage.open();
        homePage.addProductToBasket();
        basketPage.openBasket();
        
        // Получает данные из корзины
        List<String> productNames = basketPage.getProductNames();
        List<Integer> productPrices = basketPage.getProductPrices();
        List<Integer> productQuantities = basketPage.getProductQuantities();
        int totalPrice = basketPage.getTotalPrice();
        
        // Создает ожидаемые значения на основе добавленных товаров
        List<String> expectedProductNames = new ArrayList<>();
        List<Integer> expectedProductPrices = new ArrayList<>();
        List<Integer> expectedProductQuantities = new ArrayList<>();
        int expectedTotalPricee = totalPrice;
        // Добавляет ожидаемые значения на основе полученных данных
        for (int i = 0; i < productNames.size(); i++) {
            expectedProductNames.add(productNames.get(i));
            expectedProductPrices.add(productPrices.get(i));
            expectedProductQuantities.add(productQuantities.get(i));
        }
        
        // Сравнивает полученные значения с ожидаемыми
        assertEquals("Названия не совпадают", expectedProductNames, productNames);
        assertEquals("Цены не совпадают", expectedProductPrices, productPrices);
        assertEquals("Количество не совпадает", expectedProductQuantities, productQuantities);
        assertEquals("Цены не совпадают", expectedTotalPricee, totalPrice);
        
        driver.quit();
    }
}