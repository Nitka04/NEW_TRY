package testng.groups;

import lesson6.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class AfterBeforeSuite {
    static WebDriver driver;
// @BeforeSuite це вище за класс та метод.ТОбто це найперше зо виконається
// за допомогою нього усе буде запускатися в обному браузері,
// тобто не буде для кожного теста відкривати знову вікно браузера
    @BeforeSuite
    public void acceptCookies(){
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://klopotenko.com/");
        WebElement element = (new Waiters(driver)
                .waitForPresenceOfElementLocatedReturn(By.xpath("//a[@aria-label='dismiss cookie message']")));
        element.click();
    }
// @@AfterSuite це вище за класс та метод.ТОбто це останне що виконається
    @AfterSuite
    public void closeDriver(){
        driver.quit();
    }
      
}
