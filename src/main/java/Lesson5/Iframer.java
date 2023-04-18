package Lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Iframer {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe_frameborder_css");
        //driver.findElement(By.xpath("//*[@id=\"accept-choices\"]")).click();
//WebDriverWait явне очікування. Він чекає поки знайдеться певний єлемент і тільки потім продовжує программу.
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@name='iframeResult']")));
        WebElement iFrame1= driver.findElement(By.xpath("//iframe[@name='iframeResult']"));
//переключення на frame
        driver.switchTo().frame(iFrame1);
// створюємо елемент другого веб елементу
        WebElement iframe2 = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//p[text()='An iframe with a thin black border:']/following-sibling::iframe[1]")));
        driver.switchTo().frame(iframe2);
        driver.findElement(By.xpath("//*[@id=\"accept-choices\"]")).click();
        driver.findElement(By.xpath("//a[text()='Not Sure Where To Begin?']")).click();

    }
}
