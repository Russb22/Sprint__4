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
import ru.ruslan.OrderScooterTwo;

import java.time.Duration;


public class TestOrderTwo {
    private WebDriver driver;
    private By station2 = By.xpath(".//button[@value='2']");                                                          //Станция метро выбор
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/WebDriver/bin/chromedriver");
        System.setProperty("webdriver.chrome.driver", "/WebDriver/bin/geckodriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void samokatOrderTwo() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebElement element = driver.findElement(By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM' and (text()='Заказать'))]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);                              //прокрутка

        OrderScooterTwo objOrderScooterTwo = new OrderScooterTwo(driver);                                                         //создаем объект класса главной страницы приложения
        objOrderScooterTwo.waitForLoadHomePageTwo();
        objOrderScooterTwo.clickButtonCookeTwo();
        objOrderScooterTwo.clickHeaderOrderButtonTwo();
        objOrderScooterTwo.waitForLoadOrderPageTwo();
        objOrderScooterTwo.nameOrderTwo();
        objOrderScooterTwo.surnameOrderTwo();
        objOrderScooterTwo.addressOrderTwo();
        objOrderScooterTwo.clickMetroStationOrderTwo(station2);
        objOrderScooterTwo.phoneOrderTwo();
        objOrderScooterTwo.clickButtonNextTwo();
        objOrderScooterTwo.clickDateOrderTwo();
        objOrderScooterTwo.clickDateOrderChoiceTwo();
        objOrderScooterTwo.clickButtonRentPeriodTwo();
        objOrderScooterTwo.clickChoiceRentPeriodTwo();
        objOrderScooterTwo.clickScooterColorTwo();
        objOrderScooterTwo.commentOrderTwo();
        objOrderScooterTwo.clickButtonOrderFinishTwo();
        objOrderScooterTwo.clickButtonConfirmTwo();

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
        driver.quit();                                                                                                          // Закрыть браузер
    }
}