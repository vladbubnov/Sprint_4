package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecondPageOrderScooter {

    private WebDriver driver;

    //Локатор для поля ввода даты "Когда привезти самокат"
    private final By inputDateDelivery = By.xpath(".//div[@class='react-datepicker__input-container']" +
            "/input[@placeholder='* Когда привезти самокат']");
    //Локатор для поля выбора "Срока аренды"
    private final By inputRentalPeriod = By.xpath(".//div[@class='Dropdown-root']" +
            "/div[@class='Dropdown-control' and @aria-haspopup='listbox']");
    //Локатор для поля выбора "Цвета самоката"
    private final By checkboxColourScooter = By.xpath(".//label[@class='Checkbox_Label__3wxSf']" +
            "/input[@id='black']");
    //Локатор для поля ввода ввода "Комментария для курьера"
    private final By inputComment = By.xpath(".//div[@class='Input_InputContainer__3NykH']" +
            "/input[@placeholder='Комментарий для курьера']");
    //Локатор даты доставки
    private final By dateDelivery  = By.xpath(".//div[@class='react-datepicker__week']" +
            "/div[@class='react-datepicker__day react-datepicker__day--024' and (text()='24')]");
    //Локатор срока аренды
    private final By rentalPeriod = By.xpath(".//div[@class='Dropdown-menu']" +
            "/div[@class='Dropdown-option' and (text()='трое суток')]");
    //Локатор кнопки заказать
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM'" +
            " and (text()='Заказать')]");
    //Локатор кнопки "Да" во всплывающем окне "Хотите оформить заказ?"
    private final By buttonConfirmOrderYes = By.xpath(".//div[@class='Order_Buttons__1xGrp']" +
            "/button[@class='Button_Button__ra12g Button_Middle__1CSJM' and (text()='Да')]");
    //Локатор кнокпи "Проверить статус"
    private final By checkStatusButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']" +
            "/button[@class='Button_Button__ra12g Button_Middle__1CSJM' and (text()='Посмотреть статус')]");


    public SecondPageOrderScooter(WebDriver driver){
        this.driver = driver;
    }

    //метод выбора значения в поле "Дата доставки"
    public void setInputDateDelivery() {
        driver.findElement(inputDateDelivery).click();
        driver.findElement(dateDelivery).click();
    }
    //метод выбора значения в поле "Срок аренды"
    public void setRentalPeriod() {
        driver.findElement(inputRentalPeriod).click();
        driver.findElement(rentalPeriod).click();
    }
    //метод выбора чек-бокса цвета самоката
    public void setCheckboxColourScooter() {
        driver.findElement(checkboxColourScooter).click();
    }
    //метод ввода комментария для курьера
    public void setInputComment() {
        driver.findElement(inputComment).sendKeys("3 подъезд");
    }
    //метод кликает по кнопке "Заказать"
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
    //метод для запонения всех полей ввода на второй странице заказа самоката
    public void setDataSecondPage() {
        setInputDateDelivery();
        setRentalPeriod();
        setCheckboxColourScooter();
        setInputComment();
        clickOrderButton();
    }
    //метода нажатия кнопки "Да" во всплывающем окне "Хотите оформить заказ?"
    public void confirmOrder() {
        driver.findElement(buttonConfirmOrderYes).click();
    }
    //метод проверки, что кнопка "Проверить статус" отображается
    public boolean isDisplayedCheckStatusButton() {
        return driver.findElement(checkStatusButton).isDisplayed();
    }
}
