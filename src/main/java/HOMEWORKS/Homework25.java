package HOMEWORKS;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;

import java.security.Key;
import java.time.Duration;
import java.util.Deque;
import java.util.Set;

import static org.openqa.selenium.Keys.*;

public class Homework25 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://www.google.com/search");
        String descr1= driver.getWindowHandle();
        Set<String> set1 = driver.getWindowHandles();
        Actions actions= new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

        WebElement googleSearch=driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        googleSearch.sendKeys("https://www.guinnessworldrecords.com/account/register");
        googleSearch.sendKeys(Keys.ENTER);
        WebElement guinness= driver.findElement(By.xpath("//h3[text()='Create account | Guinness World Records']"));
        actions.keyDown(CONTROL).click(guinness).keyUp(CONTROL).build().perform();
        Set<String> set2 = driver.getWindowHandles();
        set2.removeAll(set1);
        String descrGuinness=set2.iterator().next();

        //wait.until(ExpectedConditions.textTobe


        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).clear();
        System.out.println("Url= "+driver.getCurrentUrl());
        driver.findElement(By.xpath("//div[@class='RNNXgb']/div/div/following-sibling::*[1]/div[2]/following-sibling::*[1]")).click();
        driver.findElement(By.xpath("//div[@class='RNNXgb']/div/div/following-sibling::*[1]/div[2]/following-sibling::*[1]")).sendKeys("https://www.hyrtutorials.com/p/alertsdemo.html");
        driver.findElement(By.xpath("//div[@class='RNNXgb']/div/div/following-sibling::*[1]/div[2]/following-sibling::*[1]")).sendKeys(ENTER);

        WebElement HYR= driver.findElement(By.xpath("//h3[text()='AlertsDemo - H Y R Tutorials']"));
        actions.keyDown(CONTROL).click(HYR).keyUp(CONTROL).build().perform();
        Set<String> set3 = driver.getWindowHandles();
        set3.removeAll(set1);
        set3.removeAll(set2);
        String descrHyrTutorials=set3.iterator().next();

       driver.findElement(By.xpath("//span[@class='ExCKkf z1asCe rzyADb']")).click();
       driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
       driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys(ENTER);
       driver.findElement(By.xpath("//h3[text()='HTML Forms - W3Schools Tryit Editor']")).click();
       //работа во вкладке W3
       WebElement iframeW3=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@id='iframeResult']")));
       driver.switchTo().frame(iframeW3);
       WebElement W3Name=driver.findElement(By.xpath("//input[@id='fname']"));
       W3Name.clear();
       W3Name.sendKeys("Anna");
       WebElement W3Lname= driver.findElement(By.xpath("//input[@id='lname']"));
       W3Lname.clear();
       W3Lname.sendKeys("Buleiko");
       driver.findElement(By.xpath("//input[@value='Submit']")).click();
        WebElement NoteW3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='w3-panel w3-pale-yellow w3-leftbar w3-border-yellow']/p")));
        System.out.println("Text in Note: "+NoteW3.getText());

 //работа во вкладке гинесс
        driver.switchTo().window(descrGuinness);
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='LastName']")));
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Anna");// данній оператор пришлось задублировать иначе у меня не отрабатівает ввод, даже после wait
        driver.findElement(By.xpath("//input[@id='DateOfBirthDay']")).sendKeys("01");
        driver.findElement(By.xpath("//input[@id='DateOfBirthMonth']")).sendKeys("02");
        driver.findElement(By.xpath("//input[@id='DateOfBirthYear']")).sendKeys("1999");
        Select country=new Select(driver.findElement(By.xpath("//*[@id=\"Country\"]")));
        country.selectByValue("UA");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='State']")));
        driver.findElement(By.xpath("//input[@id='State']")).sendKeys("Kyiv");

        driver.findElement(By.xpath("//input[@id='EmailAddress']")).sendKeys("mail@ukr.net");
        driver.findElement(By.xpath("//input[@id='ConfirmEmailAddress']")).sendKeys("mail@ukr.net");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("12345678");
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123456789");
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Bulieiko");
        //driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Anna");//дубликат
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='field-validation-error']")));
        WebElement NotePassword =driver.findElement(By.xpath("//span[@class='field-validation-error']"));
        System.out.println("The message: "+NotePassword.getText());
       //работа в окне hyrtutorials
        driver.switchTo().window(descrHyrTutorials);
        WebElement alertBoxButton= driver.findElement(By.xpath("//button[@id='alertBox']"));
        WebElement confirmBoxButton= driver.findElement(By.xpath("//button[@id='confirmBox']"));
        WebElement promptBoxButton= driver.findElement(By.xpath("//button[@id='promptBox']"));

        alertBoxButton.click();
        Alert alertBox =driver.switchTo().alert();
        alertBox.accept();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='output']")));
        WebElement  PopupBoxOutput =driver.findElement(By.xpath("//div[@id='output']"));
        System.out.println("The message of AlertBox: "+PopupBoxOutput.getText());

         confirmBoxButton.click();
         Alert confirmBox=driver.switchTo().alert();
        confirmBox.dismiss();
        Thread.sleep(2000);
        System.out.println("The message of ConfirmBox: "+PopupBoxOutput.getText());

         promptBoxButton.click();
        Alert promptBox =driver.switchTo().alert();
        promptBox.sendKeys("Final step of this task");
        promptBox.accept();
        Thread.sleep(2000);
        System.out.println("The message of AlertBox: "+PopupBoxOutput.getText());

        driver.quit();

    }

}
