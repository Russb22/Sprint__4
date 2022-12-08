package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.praktikum.scooter.pageobjects.OrderScooter;
import java.time.Duration;

public class TestOrder {
    private WebDriver driver;
    private final By station1 = By.xpath(".//button[@value='1']");

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/WebDriver/bin/chromedriver");
        System.setProperty("webdriver.chrome.driver", "/WebDriver/bin/geckodriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void samokatOrderHeaderButton() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath(".//button[@class='Button_Button__ra12g']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);                         //прокрутка

        OrderScooter objOrderScooter = new OrderScooter(driver);                                                              //создаем объект класса главной страницы приложения
        objOrderScooter.waitForLoadHomePage();                                                                                //вызываем методы
        objOrderScooter.clickButtonCooke();
        objOrderScooter.HeaderOrderButtonClick();
        objOrderScooter.waitForLoadOrderPage();
        objOrderScooter.nameSurnameAddressPhoneOrder();
        objOrderScooter.clickMetroStationOrder(station1);
        objOrderScooter.clickButtonNext();
        objOrderScooter.choiceDateOrder();
        objOrderScooter.rentPeriodChoice();
        objOrderScooter.clickScooterColor();
        objOrderScooter.commentOrder();
        objOrderScooter.clickButtonOrderFinishAndConfirm();

        Assert.assertTrue(driver.findElements(By.xpath(".//div[(@class = 'Order_ModalHeader__3FDaJ') or (text()='Заказ оформлен')]")).size() != 0);
    }                                                                                                                           // Проверка что появилось окно со статусом заказа

    @After
    public void tearDown() {
        driver.quit();
    }                                                                                                        // Закрыть браузер
}
