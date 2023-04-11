package Lesson0;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassA {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.guinnessworldrecords.com/");
        }
    }

