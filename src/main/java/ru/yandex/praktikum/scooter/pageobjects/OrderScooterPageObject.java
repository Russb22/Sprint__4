package ru.yandex.praktikum.scooter.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderScooterPageObject {
    private final WebDriver driver;
    private final By headerOrderButton = By.xpath(".//button[@class='Button_Button__ra12g']");
    private final By midleOrderButton = By.xpath(".//button[(@class = 'Button_Button__ra12g Button_Middle__1CSJM' and (text()='Заказать'))]");
    private final By name = By.xpath(".//input [@placeholder='* Имя']");
    private final By surname = By.xpath(".//input [@placeholder='* Фамилия']");
    private final By address = By.xpath(".//input [@placeholder='* Адрес: куда привезти заказ']");
    private final By metroStationField = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By phoneNumber = By.xpath(".//input [@placeholder='* Телефон: на него позвонит курьер']");
    private final By buttonNext = By.xpath(".//button[(@class = 'Button_Button__ra12g Button_Middle__1CSJM' and @type='button') or (text()='Далее')]");
    private final By dateOrder = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By dateOrderChoice = By.xpath(".//div[(@class = 'react-datepicker__day react-datepicker__day--030 react-datepicker__day--selected')]");
    private final By buttonRentPeriod = By.className("Dropdown-arrow");
    private final By choiceRentPeriod = By.xpath(".//div[(@class = 'Dropdown-option' and text()='трое суток')]");
    private final By scooterColor = By.className("Checkbox_Input__14A2w");
    private final By commentForCurier = By.xpath(".//input [@placeholder='Комментарий для курьера']");
    private final By buttonCooke = By.className("App_CookieButton__3cvqF");
    private final By buttonOrderFinish = By.xpath(".//button[(@class = 'Button_Button__ra12g Button_Middle__1CSJM' and (text()='Заказать'))]");
    private final By buttonConfirm = By.xpath(".//button[(@class = 'Button_Button__ra12g Button_Middle__1CSJM' and @type='button') or (text()='Да')]");

    public OrderScooterPageObject(WebDriver driver) {                                                         // конструктор
        this.driver = driver;}

    public void waitForLoadHomePage() {                                                         //метод ожидания загрузки страницы
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[@class='Button_Button__ra12g']")));}
    public void clickButtonCooke() {                                                            //кнопка принять куки
        driver.findElement(buttonCooke).click();}
    public void HeaderOrderButtonClick(){
        driver.findElement(headerOrderButton).click();}
    public void MidleOrderButtonClick(){
        driver.findElement(midleOrderButton).click();}
    public void waitForLoadOrderPage() {                                                        //метод ожидания загрузки страницы заказа
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input [@placeholder='* Имя']")));}
    public void nameSurnameAddressPhoneOrder() {
        driver.findElement(name).sendKeys("Дракс");
        driver.findElement(surname).sendKeys("Разрушитель");
        driver.findElement(address).sendKeys("Москва");
        driver.findElement(phoneNumber).sendKeys("81234567890");}                   // Имя, фамилия, адрес, телефон
    public void clickMetroStationOrder(By station) {
        driver.findElement(metroStationField).click();                                          //Выбор станции метро
        driver.findElement(station).click();}
    public void clickButtonNext() {
        driver.findElement(buttonNext).click();}                                                //Кнопка "Далее"
    public void choiceDateOrder() {
        driver.findElement(dateOrder).sendKeys("30.12.2022");
        driver.findElement(dateOrderChoice).click();}                                           // Выбор даты
    public void rentPeriodChoice() {
        driver.findElement(buttonRentPeriod).click();
        driver.findElement(choiceRentPeriod).click();}                                          //Выбор срока аренды
    public void clickScooterColor() {
        driver.findElement(scooterColor).click();}                                              //выбор цвета самоката
    public void commentOrder() {
        driver.findElement(commentForCurier).sendKeys("Я есть Грут");}               //комментарий курьеру
    public void clickButtonOrderFinishAndConfirm() {
        driver.findElement(buttonOrderFinish).click();
        driver.findElement(buttonConfirm).click();
    }                                                                                            //кнопка "Заказать" итоговая кнопка "Да"
}

