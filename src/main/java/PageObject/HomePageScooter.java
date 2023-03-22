package pageobject;

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
    //Локатор кнопки "Заказать" вверху страницы
    private final By locatorsOrderButtonInHeader = By.xpath(".//button[@class='Button_Button__ra12g'" +
            " and (text() = 'Заказать')]");
    //Локатор кнопки "Заказать" внизу страницы
    private final By locatorsOrderButtonInBottom = By.xpath(".//button[@class=" +
            "'Button_Button__ra12g Button_Middle__1CSJM' and (text() = 'Заказать')]");


    //метод возвращает список локаторов кнопок "Выпадающих списков"
    private By locators (String locatorButton) {
        return By.id("accordion__heading-" + locatorButton);
    }
    //метод возвращает список локаторов элементов, содержащих текст в выпадающем списке
    private By locatorActualText (String locatorActualText) {
        return (By.xpath(".//div[@id='accordion__panel-" + locatorActualText + "']/p"));
    }

    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

        //Метод проверяет отображение сообщения о использовании кук
        public void checkMessageAcceptCookie() {
            driver.findElement(acceptCookie).isDisplayed();
        }
        //метод закрывает сообщение о куках
        public void clickAcceptCookie () {
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
        //метод нажатия на кнопку "Заказать" вверху страницы
        public void clickOnOrderButtonInHeader (){
            driver.findElement(locatorsOrderButtonInHeader).click();
        }
        //метод нажатия на кнопку "Заказать" внизу страницы
        public void clickOnOrderButtonInBottom (){
            driver.findElement(locatorsOrderButtonInBottom).click();
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
        //метод проверяет отображение и закрывает сообщение о использовании кук
        public void closeCookieMessage() {
        checkMessageAcceptCookie();
        clickAcceptCookie();
        }
    }


