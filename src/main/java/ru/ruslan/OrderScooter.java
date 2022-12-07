package ru.ruslan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderScooter {

    private WebDriver driver;
    private By headerOrderButton = By.xpath(".//button[@class='Button_Button__ra12g']");
    private By name = By.xpath(".//input [@placeholder='* Имя']");
    private By surname = By.xpath(".//input [@placeholder='* Фамилия']");
    private By address = By.xpath(".//input [@placeholder='* Адрес: куда привезти заказ']");
    private By metroStationField = By.xpath(".//input[@placeholder='* Станция метро']") ;
    private By phoneNumber = By.xpath(".//input [@placeholder='* Телефон: на него позвонит курьер']");
    private By buttonNext = By.xpath(".//button[(@class = 'Button_Button__ra12g Button_Middle__1CSJM' and @type='button') or (text()='Далее')]");
    private By dateOrder = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By dateOrderChoice = By.xpath(".//div[(@class = 'react-datepicker__day react-datepicker__day--030 react-datepicker__day--selected')]");
    private By buttonRentPeriod = By.className("Dropdown-arrow");
    private By choiceRentPeriod = By.xpath(".//div[(@class = 'Dropdown-option' and text()='трое суток')]");
    private By scooterColor = By.className("Checkbox_Input__14A2w");
    private By commentForCurier = By.xpath(".//input [@placeholder='Комментарий для курьера']");
    private By buttonCooke = By.className("App_CookieButton__3cvqF");
    private By buttonOrderFinish = By.xpath(".//button[(@class = 'Button_Button__ra12g Button_Middle__1CSJM' and (text()='Заказать'))]");
    private By buttonConfirm = By.xpath(".//button[(@class = 'Button_Button__ra12g Button_Middle__1CSJM' and @type='button') or (text()='Да')]");

    public OrderScooter(WebDriver driver) {                                                         // конструктор
        this.driver = driver;}
    public void waitForLoadHomePage() {                                                         //метод ожидания загрузки страницы
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[@class='Button_Button__ra12g']")));
    }
    public void clickButtonCooke() {                                                            //кнопка принять куки
        driver.findElement(buttonCooke).click();}
    public void clickHeaderOrderButton(){                                                       //Кнопка "Заказать"
        driver.findElement(headerOrderButton).click();}
    public void waitForLoadOrderPage() {                                                        //метод ожидания загрузки страницы заказа
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input [@placeholder='* Имя']")));}
    public void nameOrder(){
        driver.findElement(name).sendKeys("Дракс");}                                  // Имя
    public void surnameOrder(){
        driver.findElement(surname).sendKeys("Разрушитель");}                                // Фамилия
    public void addressOrder(){
        driver.findElement(address).sendKeys("Москва");}                              // Ввод адреса
    public void clickMetroStationOrder(By station) {
        driver.findElement(metroStationField).click();
        driver.findElement(station).click();
    }
    public void phoneOrder(){
        driver.findElement(phoneNumber).sendKeys("81234567890");}                   //Номер телефона
    public void clickButtonNext() {
        driver.findElement(buttonNext).click();}                                            //Кнопка "Далее"
    public void clickDateOrder(){
        driver.findElement(dateOrder).sendKeys("30.12.2022");}                  // Ввод даты
    public void  clickDateOrderChoice() {
        driver.findElement(dateOrderChoice).click();}                                   // Выбор даты в календаре
    public void clickButtonRentPeriod() {
        driver.findElement(buttonRentPeriod).click();}                                  //Кликнуть для раскрытия списка сроков
    public void clickChoiceRentPeriod(){
        driver.findElement(choiceRentPeriod).click();}                                  //Кликнуть для выбора срока аренды
    public void clickScooterColor(){
        driver.findElement(scooterColor).click();}                                      //выбор цвета самоката
    public void commentOrder(){
        driver.findElement(commentForCurier).sendKeys("Я есть Грут");}               //комментарий курьеру
    public void clickButtonOrderFinish(){
        driver.findElement(buttonOrderFinish).click();}                                    //кнопка "Заказать" итоговая

    public void clickButtonConfirm(){
        driver.findElement(buttonConfirm).click();}                                          //кнопка подтверждения заказа "Да"


}

