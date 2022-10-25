package com.metanonia.seleniumsample.util;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WebDriverUtil {
    private WebDriver driver;
    public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static String WEB_DRIVER_PATH = "/usr/local/bin/chromedriver";

    public WebDriverUtil() {
        chrome();
    }

    private void chrome() {
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.addArguments("--lang=ko");
        options.addArguments("--no-sandbox");
        options.addArguments("--diable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.setCapability("ignoreProtectedModeSettings", true);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    public void useDriver(String url) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));  // wait for loading
        log.info("++++++++++++++++++++++===================+++++++++++++ selenium : "+ driver.getTitle());

        WebElement kospi_area = driver.findElement(By.className("kospi_area"));
        WebElement num_quot = kospi_area.findElement(By.className("num_quot"));
        WebElement num = num_quot.findElement(By.className("num"));

        log.info("++++++++++++++++++++++===================+++++++++++++ KOSPI : "+ num.getText());

        quitDriver();
    }

    private void quitDriver() {
        driver.quit();
    }
}
