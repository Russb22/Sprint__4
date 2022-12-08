package ru.yandex.praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.praktikum.scooter.pageobjects.TestList;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.is;

public class SomeScootersQuestion {
    private WebDriver driver;
    String textLineOne = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/WebDriver/bin/chromedriver");
        System.setProperty("webdriver.chrome.driver", "/WebDriver/bin/geckodriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkQuestions() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.id("accordion__heading-7"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

        TestList objTestList = new TestList(driver);          // создаем объект класса главной страницы приложения
        objTestList.waitForLoadLine();                          // дождаемся загрузки данных главной страницы
        objTestList.cookeButtonClick();
        objTestList.clickSomeScooters();
        objTestList.textSomeScootersRs();

        TestList objLine = new TestList(driver);                    //создаем объект строки с текстом
        String expectedTextOne = objLine.textSomeScootersRs();

        MatcherAssert.assertThat(expectedTextOne, is(textLineOne));
    }

    @org.junit.After
    public void tearDown() throws Exception {                       // закрываем браузер
        driver.quit();
    }
}

