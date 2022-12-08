package ru.yandex.praktikum.scooter.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TestList {
    private final WebDriver driver;
    private final By cookeButton = By.className("App_CookieButton__3cvqF"); //кнопка куки принять
    private final By howMuchButton = By.id("accordion__heading-0");  // локатор для клика на строку
    private final By priceLine = By.xpath(".//p[text()='Сутки — 400 рублей. Оплата курьеру — наличными или картой.']");  //создание локатора для строки с текстом
    private final By someScooters = By.id("accordion__heading-1");  //клик на строку
    private final By someScootersRs = By.xpath(".//p[text()='Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.']");  //строка ответа
    private final By timeRentRq = By.id("accordion__heading-2");   //клик на строку
    private final By timeRentRs = By.xpath(".//p[text()='Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.']"); //строка ответа
    private final By todayRentRq = By.id("accordion__heading-3");     //клик на строку
    private final By todayRentRs = By.xpath(".//p[text()='Только начиная с завтрашнего дня. Но скоро станем расторопнее.']");     //строка ответа
    private final By rentEnouthRq = By.id("accordion__heading-4");        //клик на строку
    private final By rentEnouthRs = By.xpath(".//p[text()='Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.']");       //строка ответа
    private final By scooterChargeRq = By.id("accordion__heading-5");     //клик на строку
    private final By scooterChargeRs = By.xpath(".//p[text()='Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.']");       //строка ответа
    private final By cancelRentRq = By.id("accordion__heading-6");        //клик на строку
    private final By cancelRentRs = By.xpath(".//p[text()='Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.']");      //строка ответа
    private final By scooterDeliveryRq = By.id("accordion__heading-7");       //клик на строку
    private final By scooterDeliveryRs = By.xpath(".//p[text()='Да, обязательно. Всем самокатов! И Москве, и Московской области.']");     //строка ответа

    public TestList(WebDriver driver) {                     // конструктор
        this.driver = driver;
    }
    public void waitForLoadLine() {                                                                                                                 //метод ожидания загрузки страницы
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__heading-0")));
    }
    public void cookeButtonClick() {                      //кнопка куки принять
        driver.findElement(cookeButton).click();
    }
    public void clickHowMuchButton() {                                                 //метод клика на строку
        driver.findElement(howMuchButton).click();}
    public String textPriceLine() {
        return driver.findElement(priceLine).getAttribute("innerHTML");}       //получение текста строки
    public void clickSomeScooters() {
        driver.findElement(someScooters).click();
    }
    public String textSomeScootersRs() {
        return driver.findElement(someScootersRs).getAttribute("innerHTML");
    }
    public void clickTimeRentRq() {
        driver.findElement(timeRentRq).click();
    }
    public String textTimeRentRs() {
        return driver.findElement(timeRentRs).getAttribute("innerHTML");
    }
    public void clickTodayRentRq() {
        driver.findElement(todayRentRq).click();
    }
    public String textTodayRentRs() {
        return driver.findElement(todayRentRs).getAttribute("innerHTML");
    }
    public void clickRentEnouthRq() {
        driver.findElement(rentEnouthRq).click();
    }

    public String textRentEnouthRs() {
        return driver.findElement(rentEnouthRs).getAttribute("innerHTML");
    }

    public void clickScooterChargeRq() {
        driver.findElement(scooterChargeRq).click();
    }

    public String textScooterChargeRs() {
        return driver.findElement(scooterChargeRs).getAttribute("innerHTML");
    }

    public void clickCancelRentRq() {
        driver.findElement(cancelRentRq).click();
    }

    public String textCancelRentRs() {
        return driver.findElement(cancelRentRs).getAttribute("innerHTML");}

    public void clickScooterDeliveryRq() {
        driver.findElement(scooterDeliveryRq).click();}

    public String textScooterDeliveryRs() {
        return driver.findElement(scooterDeliveryRs).getAttribute("innerHTML");
    }
}
