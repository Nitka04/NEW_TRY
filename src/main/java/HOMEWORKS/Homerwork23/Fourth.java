package HOMEWORKS.Homerwork23;
//Написать метод, который будет выводить в консоль тексты всех
//элементов, которые можно найти по заданнму параметру.
//Например при помощи него можно будет получить значения всех элементов
//из списков заданных на "Рисунок 4.png" и "Рисунок 5.png".
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fourth {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://uhomki.com.ua/ru/");
        WebElement webEl1=driver.findElement(By.xpath("//footer[@class='footer']/div/div/div/div[2]"));
        System.out.println(webEl1.getText());
        driver.quit();
    }
}
