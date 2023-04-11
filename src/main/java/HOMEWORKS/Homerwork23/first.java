package HOMEWORKS.Homerwork23;
//Написать программу, которая будет открывать пять различных страниц в новых окнах:
//    https://uhomki.com.ua/ru/koshki/1074/
//    https://zoo.kiev.ua/
//    https://www.w3schools.com/
//    https://taxi838.ua/ru/dnepr/
//    https://klopotenko.com/
//
//Прописать цикл, который будет переключаться поочередно через все страницы,
//для каждой страницы выводить в консоль название и ссылку на эту страницу.
//И будет закрывать ту страницу в названии которой есть слово зоопарк.
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.Set;

public class first {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://uhomki.com.ua/ru/koshki/1074/");
        System.out.println(driver.getWindowHandle());
        String descr1= driver.getWindowHandle();
        Set<String> set1 = driver.getWindowHandles();
        ((JavascriptExecutor)driver).executeScript("window.open()");
        Set<String> set2 = driver.getWindowHandles();
        ((JavascriptExecutor)driver).executeScript("window.open()");
        set2.removeAll(set1);
        String descr2=set2.iterator().next();
        driver.switchTo().window(descr2);
        driver.navigate().to("https://zoo.kiev.ua/");
        Set<String> set3=driver.getWindowHandles();
        ((JavascriptExecutor)driver).executeScript("window.open()");
        set3.removeAll(set1);
        set3.removeAll(set2);
        String descr3=set3.iterator().next();
        driver.switchTo().window(descr3);
        driver.navigate().to("https://www.w3schools.com/");
        Set<String> set4=driver.getWindowHandles();
        set4.removeAll(set1);
        set4.removeAll(set2);
        set4.removeAll(set3);
        ((JavascriptExecutor)driver).executeScript("window.open()");
        String descr4=set4.iterator().next();
        driver.switchTo().window(descr4);
        driver.navigate().to("https://taxi838.ua/ru/dnepr/");
        Set<String> set5=driver.getWindowHandles();
        set5.removeAll(set1);
        set5.removeAll(set2);
        set5.removeAll(set3);
        set5.removeAll(set4);
        String descr5=set5.iterator().next();
        driver.switchTo().window(descr5);
        driver.navigate().to("https://klopotenko.com/");
        String[] url={descr1,descr2,descr3,descr4,descr5};
         for (int i=0;i<=url.length;i++){
             driver.switchTo().window(url[i]);
             System.out.println(driver.getTitle());
             System.out.println(driver.getCurrentUrl());
             Thread.sleep(5000);
             if (driver.getTitle().contains("зоопарк")==true){
                 driver.close();
             }
         }
         driver.quit();
    }
}
