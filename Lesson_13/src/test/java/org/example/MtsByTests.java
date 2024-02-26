package org.example;

//Необходимо написать автотесты для сайта mts.by.
// Суть тестов заключается в проверке блока «Онлайн пополнение без комиссии»:
//Проверить название указанного блока;
// Проверить наличие логотипов платёжных систем;
// Проверить работу ссылки «Подробнее о сервисе»;
// Заполнить поля и проверить работу кнопки «Продолжить»
// (проверяем только вариант «Услуги связи», номер для теста 297777777)

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsByTests {
    
    private WebDriver driver;
    private String testPhoneNumber = "297777777";
    
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://mts.by");
        driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
        WebElement cookie = driver.findElement(By.id("cookie-agree"));// Принимает cookie
        cookie.click();
    }
    
    @Test//Проверка названия блока
    public void BlockCheckName() {
        WebElement blockTitle = driver.findElement(By.xpath("//h2[text()='Онлайн пополнение ']"));
        assertTrue(blockTitle.isDisplayed(), "Онлайн пополнение без комиссии");
    }
    
    @Test//Проверка наличия логотипов платёжных систем
    public void PayPartnersLogoCheck() {
        WebElement logoBlock = driver.findElement(By.className("pay__partners"));
        assertTrue(logoBlock.findElements(By.tagName("img")).size() > 0, "Логотипы не найдены");
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
        WebElement button = driver.findElement(By.xpath("//*[@id='pay-connection']/button"));
        button.click();
    }
    
    @AfterEach
    public void kill() {
        if (driver != null) {
            driver.quit();
        }
    }
}