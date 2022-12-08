package ru.yandex.praktikum.scooter.pageobjects;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BrowserRule extends ExternalResource {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @Override
    protected void before() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/WebDriver/bin/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "/WebDriver/bin/geckodriver.exe");
        String br = System.getenv("browser");
        if ("chrome".equals(br)) {
            driver = new ChromeDriver();
        } else if ("ff".equals(br)) {
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Override
    protected void after() {
        driver.quit();
    }
}
