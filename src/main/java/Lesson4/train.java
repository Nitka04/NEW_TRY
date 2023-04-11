package Lesson4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class train {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();// створили екцемпляр классу
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        //пошук кольоров та інших параметров
        driver.get("https://zoo.kiev.ua/");
        WebElement element = driver.findElement(By.cssSelector("[href = 'https://widget.kontramarka.ua/uk/widget11site11623/widget/index']"));
        System.out.println(element.getText());
        System.out.println(element.getCssValue("color"));
        System.out.println(element.getCssValue("background-color"));
        driver.quit();
    }
}
