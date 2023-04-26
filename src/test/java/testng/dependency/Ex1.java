package testng.dependency;

import lesson6.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;


public class Ex1 extends BaseTest {
    //тести запускаються по абеки, тому якщо нам потрібно особистий пріоритет то треба його встанови
    // поряд з "@test (priority)
    @BeforeClass
    public void acceptCookies(){
        driver.get("https://klopotenko.com/");
        // WebElement element=(new Waiters(driver)).waitForPresenceOfElementLocatedReturn(By.xpath("//a[@aria-label='dismiss cookie message']"));
      //  element.click();
    }

    @Test (dependsOnMethods = {"checkofCheckBox"})
    public void checkWebPageTitle(){
        driver.get("https://klopotenko.com/");
        //WebElement element=(new Waiters(driver)).waitForPresenceOfElementLocatedReturn(By.xpath("//a[@aria-label='dismiss cookie message']"));
       // element.click();

//assert всьго 4 методи, якщо хочаб один assert не виконується то тест падає і дальніші дії не виконуються.
//в кінці assert ми пишемо сповіщення яке видасть якщо тест впаде/не виконається
//тест буде вважатися пройденим якщо всередині метода правдивий виразю
        assertTrue(driver.getTitle().equals("Євген Клопотенко - Кулінарні рецепти від Євгена Клопотенка"),"Названия страниц не совпадают," +
                " я ожидал другого");
// assertFalse якщо вираз в середині не виконується тест проходить
        assertFalse(driver.getTitle().equals("CЕРГІЙ Клоп4отенко - Кулінарні рецепти від Євгена Клопотенка"),"Названия страниц не совпадают," +
                " я ожидал другого");
//assertEquals всередені 3 параметра, фактичне занчення,з чим порівнювати, яке сповіщення видати якщо вони не співподуть
        assertEquals(driver.getTitle(),"Євген Клопотенко - Кулінарні рецепти від Євгена Клопотенка","Названия страниц не совпадают");
        assertNotEquals(driver.getTitle(),"Євгенй Клопот4енко - Кулінарні рецепти від Євгена Клопотенка","Названия страниц не совпадают");
    }
    @Test (priority = 2)
    public void checkofCheckBox(){
        driver.get("https://klopotenko.com/login/");
        //WebElement element = (new Waiters(driver).waitForPresenceOfElementLocated(By.xpath("//a[@aria-label='dismiss cookie message']")));
        WebElement element=(new Waiters(driver)).waitForPresenceOfElementLocatedReturn(By.xpath("//a[@aria-label='dismiss cookie message']"));
        element.click();
        WebElement checkbox = (new Waiters(driver)).waitForPresenceOfElementLocatedReturn(By.xpath("//i[@class='um-icon-android-checkbox-outline-blank']"));
//JavascriptExecutor это интерфейс, предоставляемый Selenium, который предоставляет механизм для выполнения JavaScript через Selenium WebDriver.
//Иногда эти локаторы Selenium по умолчанию могут не работать. На картинке появляется JavaScriptExecutor.
// используется для выполнения операций на веб-странице.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
       //обран чи чекбокс
        assertFalse(checkbox.isSelected(),"Чекбокс уже нажат");
        checkbox.click();
        WebElement newCheckBox = (new Waiters(driver)
                .waitForPresenceOfElementLocatedReturn(By.xpath("//i[@class='um-icon-android-checkbox-outline']")));
        (new Waiters(driver)).waitForVisabilityOfElement(driver.findElement(By.xpath("//i[@class='um-icon-android-checkbox-outline']")));
        assertFalse(newCheckBox.isSelected(),"Чекбокс уже нажат");
        checkbox.click();
        assertFalse(checkbox.isSelected(), "Чекбокс уже нажат");
    }
    @Test (priority = 3)
    public void countOfIngredients(){
//перевірка що кількість елементів рівна чомусь
        driver.get("https://klopotenko.com/solodko-yaskravo-aromatno-zapechena-morkva-z-rozmarynom-i-mandarynovym-sokom-vid-yevgena-klopotenka/");
        WebElement element = (new Waiters(driver)
                .waitForPresenceOfElementLocatedReturn(By.xpath("//a[@aria-label='dismiss cookie message']")));
        element.click();
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='col-12 col-md-6']/div/div"));
        assertTrue(elements.size()==5,"Количество ингридиентов не равно 5, оно равно "
                +elements.size());
    }
}
