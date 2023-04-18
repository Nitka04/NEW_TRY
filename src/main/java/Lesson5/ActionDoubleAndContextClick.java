package Lesson5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
// работа з правим кліком миші бдвійним кліком миші
public class ActionDoubleAndContextClick {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
//очікування вспливаючих вікон
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        /*
//вказуємо що саме який елемент очікуємо
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//iframe[@aria-label='Окно диспетчера конфиденциальности']")));
//перемикаємося на вікно прийняти конфідіціальність
        driver.switchTo().frame(iframe);
        Thread.sleep(2000);
//нажимаємо що ми згодні
        driver.findElement(By.xpath("//span[text()='Принять всё']")).click();*/

//для двойного кліка необхідний класс Actions
        Actions actions = new Actions(driver);
// знаходимо елемен по котрому необхідно зробити два кліка правою кнопкою миші
//contextClick- клік правой кнопкой миші
        actions.contextClick(driver.findElement
                (By.xpath("//span[text()='right click me']"))).build().perform();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[text()='Quit']")).click();
//пітдверджуємо дії після кліка правою клавішею
        Thread.sleep(2000);
        Alert alert1 = driver.switchTo().alert();
        System.out.println(alert1.getText());
        alert1.accept();

//doubleClick-двойной клік правою клавішею
        actions.doubleClick
                (driver.findElement(By.xpath
                        ("//button[text()='Double-Click Me To See Alert']"))).build().perform();
// работа з вспрливаючими вікнами.
        Alert alert2 = driver.switchTo().alert();
        System.out.println(alert2.getText());
        alert2.accept();

        driver.quit();
    }
}
