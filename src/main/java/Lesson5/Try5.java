package Lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
//обирання елементів зі списку. допрацювати
public class Try5 {
    public static void getText(Select select){
        List<WebElement> elements = select.getAllSelectedOptions();
        for(WebElement element:elements){
            System.out.println(element.getText());
        }
    }
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://ktokuda.net/");
        driver.findElement(By.xpath("//div[@class='hike_tour no_active']")).click();
        Thread.sleep(2000);
       WebElement countryList= driver.findElement(By.id("country_list"));
       WebElement transportList= driver.findElement(By.id("transport_list"));
       WebElement cityList= driver.findElement(By.id("city-list"));

       Select countries = new Select (countryList);
       Select transport = new Select (transportList);
       Select city = new Select (cityList);

        countries.selectByValue("61");
        Thread.sleep(2000);
        countries.selectByValue("372");
        Thread.sleep(2000);
        countries.selectByValue("Испания");
        Thread.sleep(2000);
        countries.deselectByVisibleText("Австрия");
        getText(countries);
        Thread.sleep(2000);

     /*  transport.selectByVisibleText("Автобус");
        transport.deselectByIndex(0);
        Thread.sleep(2000);
        getText(transport);

        city.selectByVisibleText("Киев");
        city.deselectByIndex(0);
        getText(city);
*/
        driver.quit();
    }
}
