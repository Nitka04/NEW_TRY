package testng.groups;

import lesson6.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class BeforeMethodD {
    WebDriver driver;
//@BeforeMethod завдяки цієї анотаціі все що прописано дуде спочатку кожного методу/тесту
    @BeforeMethod
    public void start(){
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://klopotenko.com/");
        WebElement element = (new Waiters(driver)
                .waitForPresenceOfElementLocatedReturn(By.xpath("//a[@aria-label='dismiss cookie message']")));
        element.click();
    }
//@AfterMethod анотація яка закінчує кожен тест/метод тим що в неї прописано.
    @AfterMethod
    public void stop(){
        driver.quit();
    }
    private static class Locators {
//для швидкого використання в тестах,коли багато перевірок;
        private final static By meat = By.xpath("//ul[@id='menu-main_menu_our-ua']//a[text()='М’ясні']");
        private final static By fish = By.xpath("//ul[@id='menu-main_menu_our-ua']//a[text()='Рибне']");
        private final static By veg = By.xpath("//ul[@id='menu-main_menu_our-ua']//a[text()='Овочеві']");
        private final static By garn = By.xpath("//ul[@id='menu-main_menu_our-ua']//a[text()='Гарніри']");
        private final static By pasts = By.xpath("//ul[@id='menu-main_menu_our-ua']//a[text()='Паста']");
        private final static By pizza = By.xpath("//ul[@id='menu-main_menu_our-ua']//a[text()='Піца']");
    }

    static class Labels {
//для швидкого використання в порівняннях або вводу данних в тестах
        private final static String uaLocalisation = "UA";
        private final static String enLocalisation = "EN";
        private final static String meat = "М’ясні";
        private final static String fish = "Рибне";
        private final static String veg = "Овочеві";
        private final static String gar = "Гарніри";
        private final static String pasts = "Паста";
        private final static String pizza = "Піца";

    }
    @Test
    public void checkWebPageTitle() {

        assertTrue(driver.getTitle().equals("Євген Клопотенко - Кулінарні рецепти від Євгена Клопотенка"), "Названия страниц не совпадают," +
                " я ожидал другого");
        assertFalse(driver.getTitle().equals("Євген Клоп4отенко - Кулінарні рецепти від Євгена Клопотенка"), "Названия страниц не совпадают," +
                " я ожидал другого");
        assertEquals(driver.getTitle(), "Євген Клопотенко - Кулінарні рецепти від Євгена Клопотенка", "Названия страниц не совпадают");
        assertNotEquals(driver.getTitle(), "Євген Клопот4енко - Кулінарні рецепти від Євгена Клопотенка", "Названия страниц не совпадают");
    }

    @Test
    public void checkofCheckBox() {
        driver.get("https://klopotenko.com/login/");
        WebElement checkbox = (new Waiters(driver)
                .waitForPresenceOfElementLocatedReturn(By.xpath("//i[@class='um-icon-android-checkbox-outline-blank']")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        assertFalse(checkbox.isSelected(), "Чекбокс уже нажат");
        checkbox.click();
        WebElement newCheckBox = (new Waiters(driver)
                .waitForPresenceOfElementLocatedReturn(By.xpath("//i[@class='um-icon-android-checkbox-outline']")));
        (new Waiters(driver)).waitForVisabilityOfElement(driver.findElement(By.xpath("//i[@class='um-icon-android-checkbox-outline']")));
        assertFalse(newCheckBox.isSelected(), "Чекбокс уже нажат");
        checkbox.click();
        assertFalse(checkbox.isSelected(), "Чекбокс уже нажат");
    }


    @Test
    public void countOfIngredients() {
        driver.get("https://klopotenko.com/solodko-yaskravo-aromatno-zapechena-morkva-z-rozmarynom-i-mandarynovym-sokom-vid-yevgena-klopotenka/");
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='col-12 col-md-6']/div/div"));
        assertTrue(elements.size() == 5, "Количество ингридиентов не равно 5, оно равно "
                + elements.size());
    }

    @Test
    public void checkLocalisation() {
        WebElement ua = driver.findElement(By.xpath("//span[text()='UA']"));
        WebElement en = driver.findElement(By.xpath("//span[text()='EN']"));
        assertTrue(ua.isDisplayed(), "Элемент не отображается");
        assertTrue(en.isDisplayed(), "Элемент не отображается");
        assertEquals(ua.getText(), Labels.uaLocalisation, "Not equals");
        assertEquals(en.getText(), Labels.enLocalisation, "Not equals");
    }

    @Test
    public void searchFunctionality() {
        WebElement search = (new Waiters(driver)).waitForPresenceOfElementLocatedReturn(By.id("open-search"));
        search.click();
        WebElement input = (new Waiters(driver))
                .waitForPresenceOfElementLocatedReturn(By.xpath("//input[@placeholder='Пошук...']"));
        String inputText = "Meat";
        input.sendKeys(inputText);
        input.submit();
        (new Waiters(driver)).waitForTitleContains("Ви шукали Meat");
        assertTrue(driver.findElement(By.tagName("h2")).getText()
                .replace("ЗНАЙДЕНО ЗА ЗАПИТОМ: ", "").equalsIgnoreCase(inputText));
    }

    @Test
//@Ignore ігнорювання тесту
    @Ignore
    public void labelaCheck() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://klopotenko.com/");
        WebElement element = (new Waiters(driver)
                .waitForPresenceOfElementLocatedReturn(By.xpath("//a[@aria-label='dismiss cookie message']")));
        element.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a[text()='Рецепти']"))).perform();
        (new Waiters(driver)).waitForVisabilityOfElement(driver.findElement
                (By.xpath
                        ("//a[@href='https://klopotenko.com/drugi-stravi/']")));
        actions.moveToElement(driver.findElement
                (By.xpath
                        ("//a[@href='https://klopotenko.com/drugi-stravi/']"))).perform();
        actions.moveToElement(driver.findElement
                (By.xpath
                        ("//a[@href='https://klopotenko.com/drugi-stravi/']"))).perform();
        actions.moveToElement(driver.findElement
                (By.xpath
                        ("//a[@href='https://klopotenko.com/drugi-stravi/']"))).perform();
        (new Waiters(driver)).waitForVisabilityOfElement(Locators.meat);
        assertEquals(driver.findElement(Locators.meat).getText(),Labels.meat,"not Equals");
        assertEquals(driver.findElement(Locators.fish).getText(),Labels.fish,"not Equals");
        assertEquals(driver.findElement(Locators.veg).getText(),Labels.veg,"not Equals");
        assertEquals(driver.findElement(Locators.garn).getText(),Labels.gar,"not Equals");
        assertEquals(driver.findElement(Locators.pasts).getText(),Labels.pasts,"not Equals");
        assertEquals(driver.findElement(Locators.pizza).getText(),Labels.pizza,"not Equals");
    }

}
