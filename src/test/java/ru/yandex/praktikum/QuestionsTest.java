package ru.yandex.praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.praktikum.scooter.pageobjects.QuestionsPageObject;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.is;

public class QuestionsTest {
    private WebDriver driver;
    String textLine = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    String textLineOne = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    String textLineTwo = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    String textLineTree = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    String textLineFour = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    String textLineFive = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    String textLineSix = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    String textLineSeven = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/WebDriver/bin/chromedriver");
        System.setProperty("webdriver.chrome.driver", "/WebDriver/bin/geckodriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://qa-scooter.praktikum-services.ru/");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.id("accordion__heading-7"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    @Test
    public void testHowMuchQuestion() {
        QuestionsPageObject objQuestionsPageObject = new QuestionsPageObject(driver);                             // создаем объект класса главной страницы приложения
        objQuestionsPageObject.waitForLoadLine();                                          // дождаемся загрузки данных главной страницы
        objQuestionsPageObject.cookeButtonClick();
        objQuestionsPageObject.clickHowMuchButton();                     // кликаем на кнопку
        objQuestionsPageObject.textPriceLine();

        QuestionsPageObject objLine = new QuestionsPageObject(driver);                        //создаем объект строки с текстом
        String expectedText = objLine.textPriceLine();               //получаем текст в строке
        MatcherAssert.assertThat(expectedText, is(textLine));       //Делаем проверку текста
    }
    @Test
    public void testSomeScootersQuestion() {
        QuestionsPageObject objQuestionsPageObject = new QuestionsPageObject(driver);          // создаем объект класса главной страницы приложения
        objQuestionsPageObject.waitForLoadLine();                                               // дождаемся загрузки данных главной страницы
        objQuestionsPageObject.cookeButtonClick();
        objQuestionsPageObject.clickSomeScooters();
        objQuestionsPageObject.textSomeScootersRs();

        QuestionsPageObject objLine = new QuestionsPageObject(driver);                    //создаем объект строки с текстом
        String expectedTextOne = objLine.textSomeScootersRs();
        MatcherAssert.assertThat(expectedTextOne, is(textLineOne));
    }
    @Test
    public void testTimeRentQuestion() {
        QuestionsPageObject objQuestionsPageObject = new QuestionsPageObject(driver);                      // создаем объект класса главной страницы приложения
        objQuestionsPageObject.waitForLoadLine();                                   // дождаемся загрузки данных главной страницы
        objQuestionsPageObject.cookeButtonClick();
        objQuestionsPageObject.clickTimeRentRq();
        objQuestionsPageObject.textTimeRentRs();

        QuestionsPageObject objLine = new QuestionsPageObject(driver);                            //создаем объект строки с текстом
        String expectedTextTwo = objLine.textTimeRentRs();
        MatcherAssert.assertThat(expectedTextTwo, is(textLineTwo));
    }
    @Test
    public void testTodayRentQuestion() {
        QuestionsPageObject objQuestionsPageObject = new QuestionsPageObject(driver);                             // создаем объект класса главной страницы приложения
        objQuestionsPageObject.waitForLoadLine();                                          // дождаемся загрузки данных главной страницы
        objQuestionsPageObject.cookeButtonClick();
        objQuestionsPageObject.clickTodayRentRq();
        objQuestionsPageObject.textTodayRentRs();

        QuestionsPageObject objLine = new QuestionsPageObject(driver);                                //создаем объект строки с текстом
        String expectedTextThree = objLine.textTodayRentRs();
        MatcherAssert.assertThat(expectedTextThree, is(textLineTree));
    }
    @Test
    public void testRentEnouthQuestion() {
        QuestionsPageObject objQuestionsPageObject = new QuestionsPageObject(driver);                             // создаем объект класса главной страницы приложения
        objQuestionsPageObject.waitForLoadLine();                                          // дождаемся загрузки данных главной страницы
        objQuestionsPageObject.cookeButtonClick();
        objQuestionsPageObject.clickRentEnouthRq();
        objQuestionsPageObject.textRentEnouthRs();

        QuestionsPageObject objLine = new QuestionsPageObject(driver);                                //создаем объект строки с текстом
        String expectedTextFour = objLine.textRentEnouthRs();
        MatcherAssert.assertThat(expectedTextFour, is(textLineFour));
    }
    @Test
    public void testScooterChargeQuestion() {
        QuestionsPageObject objQuestionsPageObject = new QuestionsPageObject(driver);             // создаем объект класса главной страницы приложения
        objQuestionsPageObject.waitForLoadLine();                          // дождаемся загрузки данных главной страницы
        objQuestionsPageObject.cookeButtonClick();
        objQuestionsPageObject.clickScooterChargeRq();
        objQuestionsPageObject.textScooterChargeRs();

        QuestionsPageObject objLine = new QuestionsPageObject(driver);                                //создаем объект строки с текстом
        String expectedTextFive = objLine.textScooterChargeRs();
        MatcherAssert.assertThat(expectedTextFive, is(textLineFive));
    }
    @Test
    public void testRentCancelQuestion() {
        QuestionsPageObject objQuestionsPageObject = new QuestionsPageObject(driver);                            // создаем объект класса главной страницы приложения
        objQuestionsPageObject.waitForLoadLine();                                          // дождаемся загрузки данных главной страницы
        objQuestionsPageObject.cookeButtonClick();
        objQuestionsPageObject.clickCancelRentRq();
        objQuestionsPageObject.textCancelRentRs();

        QuestionsPageObject objLine = new QuestionsPageObject(driver);                                //создаем объект строки с текстом
        String expectedTextSix = objLine.textCancelRentRs();
        MatcherAssert.assertThat(expectedTextSix, is(textLineSix));
    }
    @Test
    public void testScooterDeliveryQuestion() {
        QuestionsPageObject objQuestionsPageObject = new QuestionsPageObject(driver);                                        // создаем объект класса главной страницы приложения
        objQuestionsPageObject.waitForLoadLine();                                                      // дождаемся загрузки данных главной страницы
        objQuestionsPageObject.cookeButtonClick();
        objQuestionsPageObject.clickScooterDeliveryRq();
        objQuestionsPageObject.textScooterDeliveryRs();

        QuestionsPageObject objLine = new QuestionsPageObject(driver);                                          //создаем объект строки с текстом
        String expectedTextSeven = objLine.textScooterDeliveryRs();
        MatcherAssert.assertThat(expectedTextSeven, is(textLineSeven));
    }
    @After
    public void tearDown() throws Exception {                       // закрываем браузер
        driver.quit();
    }
}