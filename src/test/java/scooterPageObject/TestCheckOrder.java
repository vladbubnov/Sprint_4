package scooterPageObject;

import PageObject.FirstPageOrderScooter;
import PageObject.HomePageScooter;
import PageObject.SecondPageOrderScooter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class TestCheckOrder {
    private WebDriver driver;
    private final String locatorsOrderButton;
    private final String name;

    public TestCheckOrder(String name, String locatorsOrderButton) {
        this.locatorsOrderButton = locatorsOrderButton;
        this.name = name;
    }

    @Parameterized.Parameters(name = "Тест: {0}")
    public static Object[][] getData() {
        return new Object[][] {
                {"Заказ самоката, через кнопку 'Заказать' вверху страницы","Button_Button__ra12g"},
                {"Заказ самоката, через кнопку 'Заказать' внизу страницы", "Button_Button__ra12g Button_Middle__1CSJM"},
        };
    }

    @Before
    public void getPage() {
        //драйвер для браузера Chrome
        driver = new ChromeDriver();
        //переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru");
    }

    @Test
    public void TestCheckOrder() {
        //создание объекта класса домашней страницы
        HomePageScooter objHomePageScooter = new HomePageScooter(driver);
        // создание объекта класса первой страницы заказа "Для кого самокат"
        FirstPageOrderScooter objOrderNumberOne = new FirstPageOrderScooter(driver);
        // создание объекта класса второй страницы заказа "Про аренду"
        SecondPageOrderScooter objOrderNumberTwo = new SecondPageOrderScooter(driver);

        //Закрыть сообщение о куках
        objHomePageScooter.clickAcceptCookie();

        //Нажать на кнопку "Заказать"
        objHomePageScooter.clickOnOrderButton(locatorsOrderButton);

        //вызов метода, который заполняет все поля на странице и нажимает кнопку "Далее"
        objOrderNumberOne.setDataFirstPage("Иван", "Иванов",
                "г. Москва, ул.Пирогова, д.18", "89991234567");

        //вызов метода, который заполняет все поля на странице и нажимает кнопку "Заказать"
        objOrderNumberTwo.setDataSecondPage();

        //вызов метода, который нажимает на кнопку "Да" во всплывающем окне "Хотите оформить заказ?"
        objOrderNumberTwo.confirmOrder();

        //проверка, что отобаражается всплывающее окно "Заказ оформлен"
        assertTrue("Кнопка проверить статус не отображается",
                objOrderNumberTwo.displayedCheckStatusButton());
    }

    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }
}
