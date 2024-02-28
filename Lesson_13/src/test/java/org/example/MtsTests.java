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
    public void BlockCheckName() {
        WebElement blockTitle = driver.findElement(By.xpath("//h2[text()='Онлайн пополнение ']"));
        assertTrue(blockTitle.getText().equals("Онлайн пополнение\nбез комиссии"));
    }
    
    @Test//Проверка наличия логотипов платёжных систем
    public void PayPartnersLogoCheck() {
        WebElement logoBlock = driver.findElement(By.className("pay__partners"));
        assertTrue(logoBlock.findElements(By.tagName("img")).size() > 0);
    }
    
    @Test//Проверка работы ссылки «Подробнее о сервисе»
    public void MoreInfoLinkCheck() {
        WebElement moreInfoLink = driver.findElement(By.xpath("//a[text()='Подробнее о сервисе']"));
        moreInfoLink.click();
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
    }
    
    @Test//Проверка ввода номера и кнопки "Продолжить"
    public void ButtonCheck() {
        WebElement serviceTypeDropdown = driver.findElement(By.className("select__now"));
        assertTrue(serviceTypeDropdown.isDisplayed(), "Услуги связи");
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
    
    @AfterEach
    public void kill() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }
}