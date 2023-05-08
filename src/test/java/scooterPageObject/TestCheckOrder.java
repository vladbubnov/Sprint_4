package scooterpageobject;

import constants.CustomerData;
import pageobject.FirstPageOrderScooter;
import pageobject.HomePageScooter;
import pageobject.SecondPageOrderScooter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;


public class TestCheckOrder {
    private WebDriver driver;
    private final String URL = "https://qa-scooter.praktikum-services.ru";

    @Before
    public void getPage() {
        //драйвер для браузера Chrome
        driver = new ChromeDriver();
        //переход на страницу тестового приложения
        driver.get(URL);
    }

    @Test
    public void checkOrderInHeaderButton() {
        //создание объекта класса домашней страницы
        HomePageScooter objHomePageScooter = new HomePageScooter(driver);
        // создание объекта класса первой страницы заказа "Для кого самокат"
        FirstPageOrderScooter objOrderNumberOne = new FirstPageOrderScooter(driver);
        // создание объекта класса второй страницы заказа "Про аренду"
        SecondPageOrderScooter objOrderNumberTwo = new SecondPageOrderScooter(driver);
        // создание объекта данных заказчика
        CustomerData objCustomerData = new CustomerData();

        //проверка отображения и закрытие сообщения о использовании кук
        objHomePageScooter.closeCookieMessage();

        //Нажать на кнопку "Заказать" вверху страницы
        objHomePageScooter.clickOnOrderButtonInHeader();

        //вызов метода, который заполняет все поля на странице и нажимает кнопку "Далее"
        objOrderNumberOne.setDataFirstPage(objCustomerData.getNameUser(), objCustomerData.getSurNameUser(),
                objCustomerData.getDeliveryAddressUser(), objCustomerData.getPhoneNumberUser());

        //вызов метода, который заполняет все поля на странице и нажимает кнопку "Заказать"
        objOrderNumberTwo.setDataSecondPage();

        //вызов метода, который нажимает на кнопку "Да" во всплывающем окне "Хотите оформить заказ?"
        objOrderNumberTwo.confirmOrder();

        //проверка, что отобаражается всплывающее окно "Заказ оформлен"
        assertTrue("Кнопка проверить статус не отображается",
                objOrderNumberTwo.isDisplayedCheckStatusButton());
    }

    @Test
    public void checkOrderInBottomButton() {
        //создание объекта класса домашней страницы
        HomePageScooter objHomePageScooter = new HomePageScooter(driver);
        // создание объекта класса первой страницы заказа "Для кого самокат"
        FirstPageOrderScooter objOrderNumberOne = new FirstPageOrderScooter(driver);
        // создание объекта класса второй страницы заказа "Про аренду"
        SecondPageOrderScooter objOrderNumberTwo = new SecondPageOrderScooter(driver);
        // создание объекта данных заказчика
        CustomerData objCustomerData = new CustomerData();

        //проверка отображения и закрытие сообщения о использовании кук
        objHomePageScooter.closeCookieMessage();

        //Нажать на кнопку "Заказать" внизу страницы
        objHomePageScooter.clickOnOrderButtonInBottom();

        //вызов метода, который заполняет все поля на странице и нажимает кнопку "Далее"
        objOrderNumberOne.setDataFirstPage(objCustomerData.getNameUser(), objCustomerData.getSurNameUser(),
                objCustomerData.getDeliveryAddressUser(), objCustomerData.getPhoneNumberUser());

        //вызов метода, который заполняет все поля на странице и нажимает кнопку "Заказать"
        objOrderNumberTwo.setDataSecondPage();

        //вызов метода, который нажимает на кнопку "Да" во всплывающем окне "Хотите оформить заказ?"
        objOrderNumberTwo.confirmOrder();

        //проверка, что отобаражается всплывающее окно "Заказ оформлен"
        assertTrue("Кнопка проверить статус не отображается",
                objOrderNumberTwo.isDisplayedCheckStatusButton());
    }

    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }
}
