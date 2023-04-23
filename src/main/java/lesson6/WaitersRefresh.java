package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WaitersRefresh {
    private static final long EXPLICITY_WAIT=20L;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITY_WAIT));

        driver.get("https://uhomki.com.ua/ru/");
        System.out.println(driver.getTitle());

        wait.until(ExpectedConditions.titleIs("\"У Хомки\" Интернет-зоомагазин | Днепр, пр. А. Поля, 59. (остановка \"Медтехника\")"));

        WebElement element =
                wait.until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//input[@placeholder='поиск товаров']")));
//(new WebDriverWait(driver, EXPLICITY_WAIT))-це функція wait в іншій формі запису;
        WebElement element1 = (new WebDriverWait(driver, Duration.ofSeconds(EXPLICITY_WAIT)))
                .until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//input[@placeholder='поиск товаров']")));
        Waiters waiters = new Waiters(driver);
    }
}
