package org.example;

//Необходимо написать автотесты для сайта mts.by.
// Суть тестов заключается в проверке блока «Онлайн пополнение без комиссии»:
//Проверить название указанного блока;
// Проверить наличие логотипов платёжных систем;
// Проверить работу ссылки «Подробнее о сервисе»;
// Заполнить поля и проверить работу кнопки «Продолжить»
// (проверяем только вариант «Услуги связи», номер для теста 297777777)

//--------------------------------- Lesson_14 -----------------------------------

//Продолжим работу над блоком «Онлайн пополнение без комиссии» сайта mts.by.
//Проверить надписи в незаполненных полях каждого варианта оплаты услуг:
// услуги связи, домашний интернет, рассрочка, задолженность;
// Для варианта «Услуги связи» заполнить поля в соответствии с пререквизитами из предыдущей темы,
// нажать кнопку «Продолжить» и в появившемся окне проверить корректность отображения суммы (в том числе на кнопке),
// номера телефона, а также надписей в незаполненных полях для ввода реквизитов карты, наличие иконок платёжных систем.

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsTests {
    
    private static WebDriver driver;
    private String testPhoneNumber = "297777777";
    
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://mts.by");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement cookie = driver.findElement(By.id("cookie-agree"));// Принимает cookie
        cookie.click();
    }
    
    @Test//Проверка названия блока
    public void BlockNameTest() {
        WebElement blockTitle = driver.findElement(By.xpath("//h2[text()='Онлайн пополнение ']"));
        assertEquals("Онлайн пополнение\nбез комиссии", blockTitle.getText());
    }
    
    @Test//Проверка наличия логотипов платёжных систем
    public void PayPartnersLogoTest() {
        WebElement logoBlock = driver.findElement(By.className("pay__partners"));
        assertTrue(logoBlock.findElements(By.tagName("img")).size() > 0);
    }
    
    @Test//Проверка работы ссылки «Подробнее о сервисе»
    public void MoreInfoLinkTest() {
        WebElement moreInfoLink = driver.findElement(By.xpath("//a[text()='Подробнее о сервисе']"));
        moreInfoLink.click();
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
    }
    
    @Test//Проверка ввода номера и кнопки "Продолжить"
    public void ButtonTest() {
        WebElement serviceTypeDropdown = driver.findElement(By.className("select__now"));
        assertEquals("Услуги связи", serviceTypeDropdown.getText());
        WebElement phoneNumberInput = driver.findElement(By.id("connection-phone"));
        phoneNumberInput.click();
        phoneNumberInput.sendKeys(testPhoneNumber);
        WebElement inputSum = driver.findElement(By.xpath("//*[@id='connection-sum']"));
        inputSum.sendKeys("100");
        WebElement button = driver.findElement(By.xpath("//*[@id='pay-connection']/button"));
        button.click();
        WebElement bepaidIframe = driver.findElement(By.cssSelector(".bepaid-iframe"));
        driver.switchTo().frame(bepaidIframe);
        WebElement num = driver.findElement(By.xpath("//p[contains(text(), 'Номер:375297777777')]"));
        assertTrue(num.isDisplayed());
    }
    
    @Test//Проверка надписи в незаполненных полях каждого варианта оплаты услуг
    public void UnfilledPaymentOptionsTest() {
        WebElement dropdownButton = driver.findElement(By.className("select__now"));
        dropdownButton.click();
        WebElement option1 = driver.findElement(By.xpath("//ul[@class='select__list']/li[1]/p"));
        assertEquals("Услуги связи", option1.getText());
        option1.click();
        driver.findElement(By.xpath("//input[@id='connection-phone' and @placeholder='Номер телефона']"));
        driver.findElement(By.xpath("//input[@id='connection-sum' and @placeholder='Сумма']"));
        driver.findElement(By.xpath("//input[@id='connection-email' and @placeholder='E-mail для отправки чека']"));
        
        dropdownButton.click();
        WebElement option2 = driver.findElement(By.xpath("//ul[@class='select__list']/li[2]/p"));
        assertEquals("Домашний интернет", option2.getText());
        option2.click();
        driver.findElement(By.xpath("//input[@id='internet-phone' and @placeholder='Номер абонента']"));
        driver.findElement(By.xpath("//input[@id='internet-sum' and @placeholder='Сумма']"));
        driver.findElement(By.xpath("//input[@id='internet-email' and @placeholder='E-mail для отправки чека']"));
        
        dropdownButton.click();
        WebElement option3 = driver.findElement(By.xpath("//ul[@class='select__list']/li[3]/p"));
        assertEquals("Рассрочка", option3.getText());
        option3.click();
        driver.findElement(By.xpath("//input[@id='score-instalment' and @placeholder='Номер счета на 44']"));
        driver.findElement(By.xpath("//input[@id='instalment-sum' and @placeholder='Сумма']"));
        driver.findElement(By.xpath("//input[@id='instalment-email' and @placeholder='E-mail для отправки чека']"));
        
        dropdownButton.click();
        WebElement option4 = driver.findElement(By.xpath("//ul[@class='select__list']/li[4]/p"));
        assertEquals("Задолженность", option4.getText());
        option4.click();
        driver.findElement(By.xpath("//input[@id='score-arrears' and @placeholder='Номер счета на 2073']"));
        driver.findElement(By.xpath("//input[@id='arrears-sum' and @placeholder='Сумма']"));
        driver.findElement(By.xpath("//input[@id='arrears-email' and @placeholder='E-mail для отправки чека']"));
    }
    
    @Test
    public void PopupPaymentTest() {
        WebElement serviceTypeDropdown = driver.findElement(By.className("select__now"));
        assertEquals("Услуги связи", serviceTypeDropdown.getText());
        WebElement phoneNumberInput = driver.findElement(By.id("connection-phone"));
        phoneNumberInput.click();
        phoneNumberInput.sendKeys(testPhoneNumber);
        WebElement inputSum = driver.findElement(By.xpath("//*[@id='connection-sum']"));
        inputSum.sendKeys("100");
        WebElement button = driver.findElement(By.xpath("//*[@id='pay-connection']/button"));
        button.click();
        WebElement bepaidIframe = driver.findElement(By.cssSelector(".bepaid-iframe"));
        driver.switchTo().frame(bepaidIframe);
        WebElement num = driver.findElement(By.xpath("//p[contains(text(), 'Номер:375297777777')]"));
        assertTrue(num.isDisplayed());
        WebElement sum = driver.findElement(By.xpath("//span[contains(text(), '100.00 BYN')]"));
        assertTrue(sum.isDisplayed());
        WebElement buttonSum = driver.findElement(By.xpath("//button[contains(text(), '100.00 BYN')]"));
        assertTrue(buttonSum.isDisplayed());
        //Проверка полей ввода карты
        driver.findElement(By.xpath("//label[contains(text(), 'Номер карты')]"));
        driver.findElement(By.xpath("//label[contains(text(), 'Срок действия')]"));
        driver.findElement(By.xpath("//label[contains(text(), 'CVC')]"));
        driver.findElement(By.xpath("//label[contains(text(), 'Имя держателя (как на карте)')]"));
        //Проверка отображения логотипов
        WebElement logoBlock = driver.findElement(By.className("cards-brands__container"));
        assertTrue(logoBlock.findElements(By.tagName("img")).size() > 0);
    }
    
    @AfterEach
    public void kill() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }
}