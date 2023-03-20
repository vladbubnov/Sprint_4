package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageScooter {

    private WebDriver driver;

    private final By acceptCookie = By.id("rcc-confirm-button");
    //Локатор для блока "Вопросы о важном"
    private final By questionsAboutImportant = By.className("Home_FAQ__3uVm4");

    //метод возвращает список локаторов кнопок "Выпадающих списков"
    private By locators (String locatorButton) {
        return By.id("accordion__heading-" + locatorButton);
    }
    //метод возвращает список локаторов элементов, содержащих текст в выпадающем списке
    private By locatorActualText (String locatorActualText) {
        return (By.xpath(".//div[@id='accordion__panel-" + locatorActualText + "']/p"));
    }
    //метода возвращает локаторы кнопок "Заказать" вверху и внизу страницы
    private By locatorsOrderButton (String locatorsOrderButton) {
        return (By.xpath(".//button[@class='" + locatorsOrderButton +"' and (text() = 'Заказать')]"));
    }

    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

        //метод закрывает сообщение о куках, если кнопка "да все привыкли" отображается
        public void clickAcceptCookie () {
            if (driver.findElement(acceptCookie).isDisplayed()) ;
            driver.findElement(acceptCookie).click();
        }
        //метод перехода к блоку "Вопросы о важном"
        public void turnToQuestionsAboutImportant () {
            WebElement element = driver.findElement(questionsAboutImportant);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        }
        //метод нажатия на стрелку вниз "Выпадающего списка"
        public void clickOnDropDownList(String number){
            driver.findElement(locators(number)).click();
        }
        //метод нажатия на кнопку "Заказать" вверху и внизу станицы
        public void clickOnOrderButton (String orderButton){
            driver.findElement(locatorsOrderButton(orderButton)).click();
        }
        //метод ожидания прогрузки домашней страницы
        public void waitForLoadProfileDataHomePage(String locatorActualText){
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.elementToBeClickable(locatorActualText(locatorActualText)));
        }
        //метод для получения локаторов элементов, содержащих текст в выпадающем списке
        public By getLocatorActualText(String locatorActualText) {
            return locatorActualText(locatorActualText);
        }
    }


