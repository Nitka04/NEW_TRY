package Lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
// перегортання основного меню сайту , через використання створенного методу
public class ActionEx2 {
    public static void dranNdrop(Actions actions, WebDriver driver, int x, int y){
        WebElement centr=driver.findElement(By.xpath("//h2[text()='I Buongiorno']"));
        actions.moveByOffset(x, y).clickAndHold().pause(3).
                moveToElement(centr,-50,0).release().build().perform();

    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(4));
        driver.manage().window().maximize();
        driver.get("https://www.ibuongiorno.com/about");
        Thread.sleep(5000);
        int startX = driver.findElement(By.xpath("//span[text()='mute']")).getLocation().x;
        System.out.println(startX);
        int startY = driver.findElement(By.xpath("//h2[text()='I Buongiorno']")).getLocation().y;
        System.out.println(startY);
        int finishX=driver.findElement(By.xpath("//h2[text()='I Buongiorno']")).getLocation().x-100;
        System.out.println(finishX);
        Actions actions=new Actions(driver);
        dranNdrop(actions, driver, startX, startY);
       /* WebElement centr=driver.findElement(By.xpath("//h2[text()='I Buongiorno']"));
        actions.moveByOffset(startX, startY).clickAndHold().pause(3).
                moveToElement(centr,-100,+60).release().build().perform();*/



    }
}