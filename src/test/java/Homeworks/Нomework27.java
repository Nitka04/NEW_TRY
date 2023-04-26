package Homeworks;

import lesson6.Waiters;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;

import static org.openqa.selenium.Keys.CONTROL;
import static org.openqa.selenium.Keys.ENTER;
import static org.testng.Assert.*;

public class Нomework27 {
    static WebDriver driver;
    public void initialDriver(){
        driver = new ChromeDriver();
    }
    public void setDriver(){
        driver.manage().window().maximize();
    }
    public void closeDriver(){
        driver.quit();
    }
    @BeforeClass
    public void startTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        initialDriver();
        setDriver();
    }
    @AfterClass
    public void stopTests(){
        closeDriver();
    }

    @Test
    public void CountOfOpenWindows() {
        Actions actions = new Actions(driver);
        driver.get("https://dan-it.com.ua/uk/");
        String descr1 = driver.getWindowHandle();
        Set<String> set1 = driver.getWindowHandles();
        driver.findElement(By.xpath("//button[@class='burger']")).click();
        WebElement courseAdults = (new Waiters(driver)).waitForVisabilityOfElementReturn(By.xpath("//a[text()='Для дорослих']"));
        actions.moveToElement(courseAdults).perform();
        WebElement frontEnd = (new Waiters(driver)).waitForVisabilityOfElementReturn(By.xpath("//a[text()='Для дорослих']/following-sibling::*[1]/li[3]"));
        actions.keyDown(CONTROL).click(frontEnd).keyUp(CONTROL).build().perform();
        Set<String> set2 = driver.getWindowHandles();
        set2.removeAll(set1);
        String descrFrontEnd = set2.iterator().next();
        WebElement frontJAVA = (new Waiters(driver)).waitForPresenceOfElementLocatedReturn(By.xpath("//a[text()='Для дорослих']/following-sibling::*[1]/li[6]"));
        actions.keyDown(CONTROL).click(frontJAVA).keyUp(CONTROL).build().perform();
        Set<String> set3 = driver.getWindowHandles();
        set3.removeAll(set1);
        set3.removeAll(set2);
        String descrJAVA = set3.iterator().next();
        WebElement frontQA = driver.findElement(By.xpath("//a[text()='Для дорослих']/following-sibling::*[1]/li[8]"));
        actions.keyDown(CONTROL).click(frontQA).keyUp(CONTROL).build().perform();
        Set<String> set4 = driver.getWindowHandles();
        set4.removeAll(set1);
        set4.removeAll(set2);
        set4.removeAll(set3);
        String descrQA = set4.iterator().next();
        ArrayList<Long> WindoHandles = new ArrayList(driver.getWindowHandles());
        assertTrue(WindoHandles.size() == 4, "The number of open windows is not equal to 4, there are " + WindoHandles.size());
    }

    @Test
    public void PaymentDelivery() {
        driver.get("https://uhomki.com.ua/ru/");
        //WebElement oplatDostav=
        driver.findElement(By.xpath("//a[text()='Оплата и доставка'][1]")).click();
        assertEquals(driver.getCurrentUrl(),"https://uhomki.com.ua/ru/oplata-i-dostavka/", "The open page is not that expected.");
    }

    @Test
     public void SeachingResult() throws InterruptedException {
        driver.get("https://uhomki.com.ua/ru/");
        Actions actions = new Actions(driver);
       String[] seachWords= {"смесь","спесь","ересь"};
       for (int i=0; i<=seachWords.length-1;i++){
           WebElement search=(new Waiters(driver)).waitForPresenceOfElementLocatedReturn(By.xpath("//input[@class='search__input']"));
           search.clear();
           actions.sendKeys(search,seachWords[i]).perform();
            Thread.sleep(5000);
            actions.sendKeys(search, ENTER).perform();
            WebElement Title=(new Waiters(driver)).waitForVisabilityOfElementReturn(By.xpath("//h1[@class='main-h']"));
            assertTrue(Title.getText().contains(seachWords[i]),"The result of search didn`t contains the word"+seachWords[i]);
       }
    }
    @Test
    public void CheckBoxClick(){
        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        WebElement CheckBox=(new Waiters(driver)).waitForElementToBeClickableReturn(By.xpath("//input[@id='RememberMe']"));
        assertFalse(CheckBox.isSelected(), "Checkbox already selected.");
        CheckBox.click();
        assertTrue(CheckBox.isSelected(),"Checkbox didn`t selected.");
        CheckBox.click();
        assertFalse(CheckBox.isSelected(), "Checkbox already selected.");
    }

    @Test
    public  void checkOfTextAlert(){
        driver.get("http://only-testing-blog.blogspot.com/2014/01/textbox.html?");
        driver.findElement(By.xpath("//input[@value='Show Me Alert']")).click();
        (new Waiters(driver)).waitAlertIsPresent();
        Alert ShowMeText =driver.switchTo().alert();
        assertEquals(ShowMeText.getText(),"Hi.. This is alert message!", "The text are not that had been expected");
    }
    }

