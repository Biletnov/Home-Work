/* Написать автотест для калькулятора, который совершает арифметические действия
(сложение, вычитание, умножение и деление) и проверяет, что результат, отображаемый на экране соответствует
 ожидаемому (для теста взять приложение «Калькулятор» от Google).

Необходимо помимо решения приложить видеоподтверждение того, что тест проходит
(удачное прохождение в среде разработки и видео с экрана телефона или эмулятора
(для эмулятора можно сделать одно видео, на котором виден сам эмулятор и прохождение теста в среде разработки).
Способ передачи видео следует обговорить с проверяющим. */

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Tests {
    
    private AndroidDriver driver;
    
    @BeforeEach
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5556");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
        capabilities.setCapability(MobileCapabilityType.VERSION, "10");
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
    
    @Test
    public void testCalculatorAddition() {
        WebElement button2 = driver.findElementById("com.google.android.calculator:id/digit_2");
        button2.click();
        
        WebElement buttonPlus = driver.findElementById("com.google.android.calculator:id/op_add");
        buttonPlus.click();
        
        WebElement button3 = driver.findElementById("com.google.android.calculator:id/digit_3");
        button3.click();
        
        WebElement buttonEquals = driver.findElementById("com.google.android.calculator:id/eq");
        buttonEquals.click();
        
        WebElement result = driver.findElementById("com.google.android.calculator:id/result_final");
        
        Assertions.assertEquals("5", result.getText(), "Ожидаемый результат операции: 5");
    }
    
    @Test
    public void testCalculatorSubtraction() {
        WebElement button6 = driver.findElementById("com.google.android.calculator:id/digit_6");
        button6.click();
        
        WebElement buttonMinus = driver.findElementById("com.google.android.calculator:id/op_sub");
        buttonMinus.click();
        
        WebElement button5 = driver.findElementById("com.google.android.calculator:id/digit_5");
        button5.click();
        
        WebElement buttonEquals = driver.findElementById("com.google.android.calculator:id/eq");
        buttonEquals.click();
        
        WebElement result = driver.findElementById("com.google.android.calculator:id/result_final");
        
        Assertions.assertEquals("1", result.getText(), "Ожидаемый результат операции: 1");
    }
    
    @Test
    public void testCalculatorMultiplication() {
        WebElement button4 = driver.findElementById("com.google.android.calculator:id/digit_4");
        button4.click();
        
        WebElement buttonX = driver.findElementById("com.google.android.calculator:id/op_mul");
        buttonX.click();
        
        WebElement button8 = driver.findElementById("com.google.android.calculator:id/digit_8");
        button8.click();
        
        WebElement buttonEquals = driver.findElementById("com.google.android.calculator:id/eq");
        buttonEquals.click();
        
        WebElement result = driver.findElementById("com.google.android.calculator:id/result_final");
        
        Assertions.assertEquals("32", result.getText(), "Ожидаемый результат операции: 32");
    }
    
    @Test
    public void testCalculatorDivision() {
        WebElement button1 = driver.findElementById("com.google.android.calculator:id/digit_1");
        button1.click();
        
        WebElement button0 = driver.findElementById("com.google.android.calculator:id/digit_0");
        button0.click();
        
        WebElement buttonDiv = driver.findElementById("com.google.android.calculator:id/op_div");
        buttonDiv.click();
        
        WebElement button2 = driver.findElementById("com.google.android.calculator:id/digit_2");
        button2.click();
        
        WebElement buttonEquals = driver.findElementById("com.google.android.calculator:id/eq");
        buttonEquals.click();
        
        WebElement result = driver.findElementById("com.google.android.calculator:id/result_final");
        
        Assertions.assertEquals("5", result.getText(), "Ожидаемый результат операции: 5");
    }
    
    @Test
    public void testCalculatorDivisionByZero() {
        WebElement button3 = driver.findElementById("com.google.android.calculator:id/digit_3");
        button3.click();
        
        WebElement buttonDiv = driver.findElementById("com.google.android.calculator:id/op_div");
        buttonDiv.click();
        
        WebElement button0 = driver.findElementById("com.google.android.calculator:id/digit_0");
        button0.click();
        
        WebElement buttonEquals = driver.findElementById("com.google.android.calculator:id/eq");
        buttonEquals.click();
        
        WebElement errMsg = driver.findElementById("com.google.android.calculator:id/result_preview");
        
        Assertions.assertEquals("Can't divide by 0", errMsg.getText(), "Деление на ноль запрещено");
    }
    
    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
