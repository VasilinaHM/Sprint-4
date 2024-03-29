package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private final By AccordionQuestion = By.xpath(".//div[@class='Home_FAQ__3uVm4']"); // локатор для аккордиона

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loadMainPageAccordion() {
        driver.findElement(By.className("App_CookieButton__3cvqF")).click();
        new WebDriverWait(this.driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(AccordionQuestion));
        WebElement element = driver.findElement(AccordionQuestion);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public String clickAccordion(String Question) {
        driver.findElement(By.id(Question)).click(); //нажать на элемент аккордиона
        return driver.findElement(By.id(Question)).getText();
    }

    public void clickOrderButton(By pathButton) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(pathButton));
        WebElement element = driver.findElement(pathButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}