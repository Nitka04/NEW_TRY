package Lesson5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Alerts {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//мтворюємо кнопки для alert
        WebElement alert1 = driver.findElement
                (By.xpath("//button[text()='Click for JS Alert']"));
        WebElement alert2 = driver.findElement
                (By.xpath("//button[text()='Click for JS Confirm']"));
        WebElement alert3 = driver.findElement
                (By.xpath("//button[text()='Click for JS Prompt']"));
        alert1.click();
//спіймати це вікно через виключення
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
//щоб уникнути сітуації коли виникають інщі вспливаючі окна
// треба створити окремий класс
        Alert alertfirst = driver.switchTo().alert();
//виводимо інформацію про нтого
        System.out.println(alertfirst.getText());
//accept() – нажатие ОК; підтвердження дій на ньому
        alertfirst.accept();

//погоджуємо нашого другого алерта
        alert2.click();
        Alert alertSecond = driver.switchTo().alert();
        System.out.println(alertSecond.getText());
        Thread.sleep(2000);
//dismiss() пропускаємо алерт – нажатие Cancel или Esc;
        alertSecond.dismiss();

//result
        alert3.click();
        Alert alertThird = driver.switchTo().alert();
        System.out.println(alertThird.getText());
        Thread.sleep(2000);
        String sendkeys = "Это мой текст";
//sendKeys() – передача текста в поле диалогового окна;
        alertThird.sendKeys(sendkeys);
//після вводу текста обов'язково його підтвердження
        alertThird.accept();
        String result = driver.findElement(By.id("result")).getText();
//підтвердження через  boolean  що нам вдалося зробити тест
        boolean testResult = sendkeys.equals(result.replace("You entered: ",""));
        System.out.println("Наш тест прошел? "+testResult);

        driver.quit();
    }
}
