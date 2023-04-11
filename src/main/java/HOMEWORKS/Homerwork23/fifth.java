package HOMEWORKS.Homerwork23;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class fifth {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

       //driver.get("https://uhomki.com.ua/ru/vitaminy-beafar-pasta-malt-s-dvoynym-deystviem-dlya-khorkov-100g/");
      // WebElement search=driver.findElement(By.xpath("//input[@class='search__input']"));

        driver.get("https://uhomki.com.ua/ru/");
        WebElement search=driver.findElement(By.xpath("//input[@class='search__input']"));
        search.sendKeys("хорек");
        Thread.sleep(500);
        search.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//div[@class='catalogCard-main-b']")).click();
        Thread.sleep(500);
        WebElement compare=driver.findElement(By.xpath("//div[@class='comparison-button j-widget-comparison-add']"));
        compare.click();
        Thread.sleep(500);
        driver.navigate().refresh();
        Thread.sleep(500);
        search.sendKeys("медведь");
        //driver.findElement(By.xpath("//input[@id='search_uide9648097e8d6ab1f30e5f4e3d31bf0f2']")).sendKeys("медведь");
        Thread.sleep(500);
        search.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//div[@class='catalogCard-main-b']")).click();
        Thread.sleep(500);
        //WebElement compare=driver.findElement(By.xpath("//div[@class='comparison-button j-widget-comparison-add']"));
        compare.click();
        driver.findElement(By.xpath("//a[@class='comparison-view__button j-compare-link a']")).click();

    }
}
