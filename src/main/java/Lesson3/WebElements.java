package Lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class WebElements {
    // ми робимо метод який будемо використовувати для тестування
    //clearAndSendKeys(driver,"//input[@name='search']","Samsung");
static void clearAndSendKeys(WebDriver driver, String xpath, String text){
    WebElement element= driver.findElement(By.xpath(xpath));
    element.clear();
    element.sendKeys(text);
}
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();

/*
        driver.get("https://www.guinnessworldrecords.com/search");
//  створили новий вебелемент.який буде погоджувати кукі
        WebElement acceptCookiesButton = driver.findElement(By.id("ez-accept-all"));
 //використовуємо створений нами елемент
        acceptCookiesButton.click();
        WebElement searchField = driver.findElements(By.tagName("input")).get(1);
        searchField.sendKeys("input");
        Thread.sleep(1000);
//clear()- видаляє те що ми написали раніще в sendKeys
        searchField.clear();
        Thread.sleep(2000);
        searchField.sendKeys("Most handstand push ups");
        searchField.sendKeys(Keys.ENTER);
*/
//використання створенного методу та переміщення по списку результата пошука
/*
        driver.get("https://rozetka.com.ua/");
        driver.findElement(By.xpath("//input[@name='search']"))
                .sendKeys("iPhone");
//нижче використовуємо метод для відалення значення яке ми увелі до поісковой строки
        clearAndSendKeys(driver,"//input[@name='search']","Samsung");
        WebElement input = driver.findElement(By.xpath("//input[@name='search']"));
        Thread.sleep(500);
// ARROW_DOWN - опуститися на 1 строку вниз в списке випавшого пошука
//класс Keys. -це клас клавіш, ми обираємо яку клавішу нам потрібно нажати
        input.sendKeys(Keys.ARROW_DOWN);
//Thread.sleep очікування
        Thread.sleep(500);
        input.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500);
        input.sendKeys(Keys.DOWN);
        Thread.sleep(500);
        input.sendKeys(Keys.DOWN);
        input.sendKeys(Keys.ENTER);
*/
//пошук різної інформації про сторінку
        driver.get("https://rozetka.com.ua/");
        WebElement input = driver.findElement(By.xpath("//input[@name='search']"));
//отримаємо різну інформацію
        System.out.println(input.getText());
        System.out.println(input.getTagName());
        System.out.println("Class "+input.getClass());
//placeholder-я шукаю
        System.out.println(input.getAttribute("placeholder"));
        System.out.println("Class "+input.getAttribute("class"));
//background-repeat-перевірка відповідності кольору може використовуватися
        System.out.println(input.getCssValue("background-repeat"));
        input.sendKeys("Lenovo");
//submit підтвердження вводу
        input.submit();
// приклад використання нації веб елементів(які вже зроблені як міні методи)
/*
        driver.get("https://www.guinnessworldrecords.com/search");
        WebElement searchField = driver.findElements(By.tagName("input")).get(1);
        searchField.sendKeys("Most handstand push ups");
        searchField.submit();
*/
    /*    driver.get("https://rozetka.com.ua/");
        WebElement input = driver.findElement(By.xpath("//button[contains(text(),'Найти')]"));
// getLocation показує координати x y располежені лівого верхнього кута елемента
        System.out.println(input.getLocation());
//отримання координат окремо
        System.out.println("координата x "+ input.getLocation().x);
        System.out.println("координата y "+ input.getLocation().y);

        WebElement catalog = driver.findElement(By.xpath("//button[@aria-label='Каталог']"));
        System.out.println(catalog.getLocation());
//getSize -отримання розміру висоту та ширину
        System.out.println("Размер данного элемента "+catalog.getSize());
//отримання окремих значень
        System.out.println("Высота данного элемента "+catalog.getSize().height);
        System.out.println("Ширина данного элемента "+catalog.getSize().width);

*/
//isDisplayed();-повертає булеві значення тру або фолз
// catalog.isEnabled();
//catalog.isSelected()

        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        WebElement acceptCookiesButton = driver.findElement(By.id("ez-accept-all"));
        acceptCookiesButton.click();
        WebElement checkBox = driver.findElement(By.id("RememberMe"));
        System.out.println("Ифно до нажатия:");
        System.out.println(checkBox.isDisplayed());
        System.out.println(checkBox.isEnabled());
//частіше використовувається саме цей оператор обран чи цей обїект чи ні.
        System.out.println(checkBox.isSelected());

        checkBox.click();

        System.out.println("Ифно после нажатия:");
        System.out.println(checkBox.isDisplayed());
        System.out.println(checkBox.isEnabled());
        System.out.println(checkBox.isSelected());

    }
}
