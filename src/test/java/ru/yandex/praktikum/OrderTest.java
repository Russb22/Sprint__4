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
import ru.yandex.praktikum.scooter.pageobjects.OrderScooterPageObject;
import java.time.Duration;

public class OrderTest {
    private WebDriver driver;
    private final By station1 = By.xpath(".//button[@value='1']");
    private final By station2 = By.xpath(".//button[@value='2']");

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/WebDriver/bin/chromedriver");
        System.setProperty("webdriver.chrome.driver", "/WebDriver/bin/geckodriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://qa-scooter.praktikum-services.ru/");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath(".//button[@class='Button_Button__ra12g']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);                         //прокрутка
    }

    @Test
    public void samokatOrderHeaderButton() {
        OrderScooterPageObject objOrderScooterPageObject = new OrderScooterPageObject(driver);                                                              //создаем объект класса главной страницы приложения
        objOrderScooterPageObject.waitForLoadHomePage();                                                                                                    //вызываем методы
        objOrderScooterPageObject.clickButtonCooke();
        objOrderScooterPageObject.HeaderOrderButtonClick();
        objOrderScooterPageObject.waitForLoadOrderPage();
        objOrderScooterPageObject.nameSurnameAddressPhoneOrder();
        objOrderScooterPageObject.clickMetroStationOrder(station1);
        objOrderScooterPageObject.clickButtonNext();
        objOrderScooterPageObject.choiceDateOrder();
        objOrderScooterPageObject.rentPeriodChoice();
        objOrderScooterPageObject.clickScooterColor();
        objOrderScooterPageObject.commentOrder();
        objOrderScooterPageObject.clickButtonOrderFinishAndConfirm();

        Assert.assertTrue(driver.findElements(By.xpath(".//div[(@class = 'Order_ModalHeader__3FDaJ') or (text()='Заказ оформлен')]")).size() != 0);
    }                                                                                                                                                   // Проверка что появилось окно со статусом заказа
    @Test
    public void samokatOrderMidleButton() {
        OrderScooterPageObject objOrderScooterPageObject = new OrderScooterPageObject(driver);                                                         //создаем объект класса главной страницы приложения
        objOrderScooterPageObject.waitForLoadHomePage();
        objOrderScooterPageObject.clickButtonCooke();
        objOrderScooterPageObject.MidleOrderButtonClick();
        objOrderScooterPageObject.waitForLoadOrderPage();
        objOrderScooterPageObject.nameSurnameAddressPhoneOrder();
        objOrderScooterPageObject.clickMetroStationOrder(station2);
        objOrderScooterPageObject.clickButtonNext();
        objOrderScooterPageObject.choiceDateOrder();
        objOrderScooterPageObject.rentPeriodChoice();
        objOrderScooterPageObject.clickScooterColor();
        objOrderScooterPageObject.commentOrder();
        objOrderScooterPageObject.clickButtonOrderFinishAndConfirm();

        Assert.assertTrue(driver.findElements(By.xpath(".//div[(@class = 'Order_ModalHeader__3FDaJ') or (text()='Заказ оформлен')]")).size() != 0);   // Проверка что появилось окно со статусом заказа
    }
    @After
    public void tearDown() {
        driver.quit();
    }                                                                                                        // Закрыть браузер
}
