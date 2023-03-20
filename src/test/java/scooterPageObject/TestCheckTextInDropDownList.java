package scooterPageObject;

import PageObject.HomePageScooter;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)
    public class TestCheckTextInDropDownList{
        private final String expectedText;
        private final String locatorButton;
        private final String locatorActualText;
        private final String name;
        private WebDriver driver;

    public TestCheckTextInDropDownList(String name, String locatorButton, String expectedText,
                                       String locatorActualText) {
        this.expectedText = expectedText;
        this.locatorButton = locatorButton;
        this.locatorActualText = locatorActualText;
        this.name = name;
    }

    @Parameterized.Parameters(name = "Тест: {0}")
    public static Object[][] getData() {
        return new Object[][] {
                {"Сколько стоит?", "0", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", "0"},
                {"Заказ нескольких самокатов", "1", "Пока что у нас так: один заказ", "1"},
                {"Расчет времени аренды",  "2", "Допустим, вы оформляете заказ на 8 мая", "2"},
                {"Заказ самоката сегодня", "3", "Только начиная с завтрашнего дня.", "3"},
                {"Проделение заказа", "4", "Пока что нет! Но если что-то срочное", "4"},
                {"Начилие зарядного устройства", "5", "Самокат приезжает к вам с полной зарядкой.", "5"},
                {"Отмена заказа", "6", "Да, пока самокат не привезли.", "6"},
                {"Доставка за МКАД", "7", "Да, обязательно. Всем самокатов!", "7"},
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
    public void CheckTextInDropDownList(){
        // создание объекта класса домашней страницы
        HomePageScooter objHomePageScooter = new HomePageScooter(driver);

        //Перейти к блоку "Вопросы о важном"
        objHomePageScooter.turnToQuestionsAboutImportant();

        //Закрыть сообщение о куках
        objHomePageScooter.clickAcceptCookie();

        // нажать на стрелку "Сколько это стоит? И как оплатить?"
        objHomePageScooter.clickOnDropDownList(locatorButton);

        ///ожидание загрузки текста
        objHomePageScooter.waitForLoadProfileDataHomePage(locatorActualText);

        // проверить, что в выпадающем списке открывается соответствующий текст
        MatcherAssert.assertThat("Отображается несоответствующий текст", driver.findElement
                (objHomePageScooter.getLocatorActualText(locatorActualText)).getText(), containsString(expectedText));
    }

    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }
}
