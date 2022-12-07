package ru.ruslan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderScooterTwo {
    private WebDriver driver;
    private By midleOrderButton = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM' and (text()='Заказать'))]");
    private By nameTwo = By.xpath(".//input [@placeholder='* Имя']");
    private By surnameTwo = By.xpath(".//input [@placeholder='* Фамилия']");
    private By addressTwo = By.xpath(".//input [@placeholder='* Адрес: куда привезти заказ']");
    private By metroStationFieldTwo = By.xpath(".//input[@placeholder='* Станция метро']") ;
    private By phoneNumberTwo = By.xpath(".//input [@placeholder='* Телефон: на него позвонит курьер']");
    private By buttonNextTwo = By.xpath(".//button[(@class = 'Button_Button__ra12g Button_Middle__1CSJM' and @type='button') or (text()='Далее')]");
    private By dateOrderTwo = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By dateOrderChoiceTwo = By.xpath(".//div[(@class = 'react-datepicker__day react-datepicker__day--029 react-datepicker__day--selected')]");
    private By buttonRentPeriodTwo = By.className("Dropdown-arrow");
    private By choiceRentPeriodTwo = By.xpath(".//div[(@class = 'Dropdown-option' and text()='двое суток')]");
    private By scooterColorTwo = By.xpath(".//input[(@id = 'grey' and @type='checkbox') or (text()='серая безысходность')]");
    private By commentForCurierTwo = By.xpath(".//input [@placeholder='Комментарий для курьера']");
    private By buttonCookeTwo = By.className("App_CookieButton__3cvqF");
    private By buttonOrderFinishTwo = By.xpath(".//button[(@class = 'Button_Button__ra12g Button_Middle__1CSJM' and (text()='Заказать'))]");
    private By buttonConfirmTwo = By.xpath(".//button[(@class = 'Button_Button__ra12g Button_Middle__1CSJM' and @type='button') or (text()='Да')]");

    public OrderScooterTwo(WebDriver driver) {                                                         // конструктор
        this.driver = driver;}
    public void waitForLoadHomePageTwo() {                                                         //метод ожидания загрузки страницы
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[@class='Button_Button__ra12g']")));
    }
    public void clickButtonCookeTwo() {                                                            //кнопка принять куки
        driver.findElement(buttonCookeTwo).click();}
    public void clickHeaderOrderButtonTwo(){                                                       //Кнопка "Заказать"
        driver.findElement(midleOrderButton).click();}
    public void waitForLoadOrderPageTwo() {                                                        //метод ожидания загрузки страницы заказа
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input [@placeholder='* Имя']")));}
    public void nameOrderTwo(){
        driver.findElement(nameTwo).sendKeys("Енот");}                                  // Имя
    public void surnameOrderTwo(){
        driver.findElement(surnameTwo).sendKeys("Реактивный");}                                // Фамилия
    public void addressOrderTwo(){
        driver.findElement(addressTwo).sendKeys("Москва, Щелковское шоссе, 2а");}                   // Ввод адреса
    public void clickMetroStationOrderTwo(By station) {                                          // станция метро
        driver.findElement(metroStationFieldTwo).click();
        driver.findElement(station).click();}
    public void phoneOrderTwo(){
        driver.findElement(phoneNumberTwo).sendKeys("89161234568");}                   //Номер телефона
    public void clickButtonNextTwo() {
        driver.findElement(buttonNextTwo).click();}                                            //Кнопка "Далее"
    public void clickDateOrderTwo(){
        driver.findElement(dateOrderTwo).sendKeys("29.12.2023");}                  // Ввод даты
    public void  clickDateOrderChoiceTwo() {
        driver.findElement(dateOrderChoiceTwo).click();}                                   // Выбор даты в календаре
    public void clickButtonRentPeriodTwo() {
        driver.findElement(buttonRentPeriodTwo).click();}                                  //Кликнуть для раскрытия списка сроков
    public void clickChoiceRentPeriodTwo(){
        driver.findElement(choiceRentPeriodTwo).click();}                                  //Кликнуть для выбора срока аренды
    public void clickScooterColorTwo(){
        driver.findElement(scooterColorTwo).click();}                                      //выбор цвета самоката
    public void commentOrderTwo(){
        driver.findElement(commentForCurierTwo).sendKeys("Рука Баки");}               //комментарий курьеру
    public void clickButtonOrderFinishTwo(){
        driver.findElement(buttonOrderFinishTwo).click();}                                    //кнопка "Заказать" итоговая
    public void clickButtonConfirmTwo(){
        driver.findElement(buttonConfirmTwo).click();}                                          //кнопка подтверждения заказа "Да"


}