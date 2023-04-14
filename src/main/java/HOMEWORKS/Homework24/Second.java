package HOMEWORKS.Homework24;
//
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Second {
    public static void dranNdrop(Actions actions, WebElement first, WebElement second,int x,int y){
        int high=second.getSize().height;
        int length=second.getSize().width;
        int y2=second.getLocation().y+high/2;
        int x2=second.getLocation().x+length/2;
        System.out.println(x2+"y"+y2);
        actions.moveToElement(first).clickAndHold().
                moveToElement(second,x,y).pause(4000).release().build().perform();
    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.ashortjourney.com/");
        Thread.sleep(6000);
        Actions click=new Actions(driver);
        WebElement firstDot= driver.findElement(By.cssSelector("circle:nth-of-type(3)"));
        WebElement secondDop=driver.findElement(By.cssSelector("circle:nth-of-type(1)"));
       /*1*/ dranNdrop(click, firstDot, secondDop,0,60);
        Thread.sleep(9000);
        /*2*/click.moveToElement(driver.findElement(By.cssSelector("circle:nth-of-type(3)"))).clickAndHold().
                moveToElement(driver.findElement(By.cssSelector("circle:nth-of-type(1)"))).pause(3000).release(driver.findElement(By.cssSelector("circle:nth-of-type(1)"))).build().perform();
        Thread.sleep(9000);
        /*3*/click.moveToElement(driver.findElement(By.cssSelector("circle:nth-of-type(3)"))).clickAndHold().
                moveToElement(driver.findElement(By.cssSelector("circle:nth-of-type(1)"))).pause(3000).release(driver.findElement(By.cssSelector("circle:nth-of-type(1)"))).build().perform();
        Thread.sleep(9000);
        /*4*/click.moveToElement(driver.findElement(By.cssSelector("circle:nth-of-type(3)"))).clickAndHold().
                moveToElement(driver.findElement(By.cssSelector("circle:nth-of-type(1)"))).pause(3000).release(driver.findElement(By.cssSelector("circle:nth-of-type(1)"))).build().perform();
        Thread.sleep(9000);
        /*5*/click.moveToElement(driver.findElement(By.cssSelector("circle:nth-of-type(3)"))).clickAndHold().
                moveToElement(driver.findElement(By.cssSelector("circle:nth-of-type(1)"))).pause(3000).release(driver.findElement(By.cssSelector("circle:nth-of-type(1)"))).build().perform();
        Thread.sleep(9000);
        /*6*/click.moveToElement(driver.findElement(By.cssSelector("circle:nth-of-type(3)"))).clickAndHold().
                moveToElement(driver.findElement(By.cssSelector("circle:nth-of-type(1)"))).pause(3000).release(driver.findElement(By.cssSelector("circle:nth-of-type(1)"))).build().perform();
        Thread.sleep(9000);
        /*7*/click.moveToElement(driver.findElement(By.cssSelector("circle:nth-of-type(3)"))).clickAndHold().
                moveToElement(driver.findElement(By.cssSelector("circle:nth-of-type(1)"))).pause(3000).release(driver.findElement(By.cssSelector("circle:nth-of-type(1)"))).build().perform();
        Thread.sleep(8000);
        WebElement postCard=driver.findElement(By.xpath("//*[@id=\"postcard-back-content\"]/textarea"));
        postCard.sendKeys("Завдання виканано! Урааа!)))");
        Thread.sleep(5000);
        driver.quit();

        ////*[@id="postcard-back-content"]/textarea
    }
}
