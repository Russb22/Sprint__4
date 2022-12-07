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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ruslan.OrderScooter;

import java.time.Duration;

public class TestOrderOne {
    private WebDriver driver;
    private By station1 = By.xpath(".//button[@value='1']");                                                  //Станция метро выбор
@Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/WebDriver/bin/chromedriver");
        System.setProperty("webdriver.chrome.driver", "/WebDriver/bin/geckodriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
@Test
public void samokatOrderOne() {
    driver.get("https://qa-scooter.praktikum-services.ru/");
    JavascriptExecutor jse = (JavascriptExecutor)driver;
    WebElement element = driver.findElement(By.xpath(".//button[@class='Button_Button__ra12g']"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);                         //прокрутка

    OrderScooter objOrderScooter = new OrderScooter(driver);                                                              //создаем объект класса главной страницы приложения
    objOrderScooter.waitForLoadHomePage();                                                                                //вызываем методы
    objOrderScooter.clickButtonCooke();
    objOrderScooter.clickHeaderOrderButton();
    objOrderScooter.waitForLoadOrderPage();
    objOrderScooter.nameOrder();
    objOrderScooter.surnameOrder();
    objOrderScooter.addressOrder();
    objOrderScooter.clickMetroStationOrder(station1);
    objOrderScooter.phoneOrder();
    objOrderScooter.clickButtonNext();
    objOrderScooter.clickDateOrder();
    objOrderScooter.clickDateOrderChoice();
    objOrderScooter.clickButtonRentPeriod();
    objOrderScooter.clickChoiceRentPeriod();
    objOrderScooter.clickScooterColor();
    objOrderScooter.commentOrder();
    objOrderScooter.clickButtonOrderFinish();
    objOrderScooter.clickButtonConfirm();

    boolean isOrderCreated = true;
    if(isOrderCreated) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[(@class = 'Button_Button__ra12g Button_Middle__1CSJM' and @type='button') or (text()='Посмотреть статус')]")));
    }                                                                                                                       // Проверка что появилась кнопка Проверить статус

    Assert.assertEquals(isOrderCreated, driver.findElements(By.xpath(".//div[(@class = 'Order_ModalHeader__3FDaJ') or (text()='Заказ оформлен')]")).size() != 0);
                                                                                                                           // Проверка что появилось окно со статусом заказа
    driver.quit();

 }
@After
public void tearDown(){
    driver.quit();                                                                                                        // Закрыть браузер
}
}
