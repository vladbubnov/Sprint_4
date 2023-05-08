package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FirstPageOrderScooter {

    private WebDriver driver;
    //Локатор для поля ввода "Имя"
    private final By nameUser = By.xpath(".//div[@class='Input_InputContainer__3NykH']" +
            "/input[@placeholder='* Имя']");
    //Локатор для поля ввода "Фамилия"
    private final By surNameUser = By.xpath(".//div[@class='Input_InputContainer__3NykH']" +
            "/input[@placeholder='* Фамилия']");
    //Локатор для поля ввода "Адрес доставки"
    private final By deliveryAddres = By.xpath(".//div[@class='Input_InputContainer__3NykH']" +
            "/input[@placeholder='* Адрес: куда привезти заказ']");
    //Локатор для выпадающего списка "Станция метро"
    private final By metroStation = By.xpath(".//div[@class='select-search__value']" +
            "/input[@placeholder='* Станция метро']");
    //Локатор для поля ввода номера телефона
    private final By phoneNumber = By.xpath(".//div[@class='Input_InputContainer__3NykH']" +
            "/input[@placeholder='* Телефон: на него позвонит курьер']");
    //Локатор кнопки "Далее"
    private final By nextButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']" +
            "/button[@class='Button_Button__ra12g Button_Middle__1CSJM'" +
            " and (text() = 'Далее')]");
    //Локатор необходимой станции метро
    private final By userMetroStation = By.xpath(".//div[@class='select-search has-focus']" +
            "/div[@class='select-search__select']/ul[@class='select-search__options']/li[@data-index='14']");

    public FirstPageOrderScooter(WebDriver driver) {
        this.driver = driver;
    }

    //метод ввода значения в поле "Имя"
    public void setNameUser (String name){
        driver.findElement(nameUser).sendKeys(name);
    }
    //метод ввода значения в поле "Фамилия"
    public void setSurNameUser (String surName){
        driver.findElement(surNameUser).sendKeys(surName);
    }
    //метод ввода значения в поле "Адрес доставки"
    public void setDeliveryAddress(String address){
        driver.findElement(deliveryAddres).sendKeys(address);
    }
    //метод ввода значения в поле "Станция метро"
    public void setMetroStation (){
        driver.findElement(metroStation).click();
        driver.findElement(userMetroStation).click();
    }
    //метод ввода значения в поле "Номер телефона"
    public void setPhoneNumber (String number){
        driver.findElement(phoneNumber).sendKeys(number);
    }
    //метод кликает по кнопке "Далее"
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
    //метод для запонения всех полей ввода на первой странице заказа самоката
    public void setDataFirstPage(String name, String surName, String deliveryAddress, String number) {
        setNameUser(name);
        setSurNameUser(surName);
        setDeliveryAddress(deliveryAddress);
        setMetroStation();
        setPhoneNumber(number);
        clickNextButton();
    }
}
