package ru.yandex.praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.ruslan.TestList;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.is;

public class TestQuestions {
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
}
@Test
    public void checkQuestions() {

    driver.get("https://qa-scooter.praktikum-services.ru/");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
    WebElement element = driver.findElement(By.id("accordion__heading-7"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

        TestList objTestList = new TestList(driver);          // создаем объект класса главной страницы приложения
        objTestList.waitForLoadLine();                 // дождаемся загрузки данных главной страницы
        objTestList.cookeButtonClick();
        objTestList.clickHowMuchButton();                     // кликаем на кнопку
        objTestList.textPriceLine();
        objTestList.clickSomeScooters();
        objTestList.textSomeScootersRs();
        objTestList.clickTimeRentRq();
        objTestList.textTimeRentRs();
        objTestList.clickTodayRentRq();
        objTestList.textTodayRentRs();
        objTestList.clickRentEnouthRq();
        objTestList.textRentEnouthRs();
        objTestList.clickScooterChargeRq();
        objTestList.textScooterChargeRs();
        objTestList.clickCancelRentRq();
        objTestList.textCancelRentRs();
        objTestList.clickScooterDeliveryRq();
        objTestList.textScooterDeliveryRs();

        TestList objLine = new TestList(driver);          //создаем объект строки с текстом
        String expectedText = objLine.textPriceLine();     //получаем текст в строке
        String expectedTextOne = objLine.textSomeScootersRs();
        String expectedTextTwo = objLine.textTimeRentRs();
        String expectedTextThree = objLine.textTodayRentRs();
        String expectedTextFour = objLine.textRentEnouthRs();
        String expectedTextFive = objLine.textScooterChargeRs();
        String expectedTextSix = objLine.textCancelRentRs();
        String expectedTextSeven = objLine.textScooterDeliveryRs();

        MatcherAssert.assertThat(expectedText, is(textLine));
    MatcherAssert.assertThat(expectedTextOne, is(textLineOne));
    MatcherAssert.assertThat(expectedTextTwo, is(textLineTwo));
    MatcherAssert.assertThat(expectedTextThree, is(textLineTree));
    MatcherAssert.assertThat(expectedTextFour, is(textLineFour));
    MatcherAssert.assertThat(expectedTextFive, is(textLineFive));
    MatcherAssert.assertThat(expectedTextSix, is(textLineSix));
    MatcherAssert.assertThat(expectedTextSeven, is(textLineSeven)); //Делаем проверку текста
    }

    @org.junit.After
    public void tearDown() throws Exception {                 // закрываем браузер
        driver.quit();
    }
}

