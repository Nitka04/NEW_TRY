package lesson6;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaiterFor {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        // неявніе очікуваня
//кожного разу коли ми очікуємо пошук чогось буде відпрацьвує очікування
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
// неявніе очікуваня завантаження сторінки
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
/*
        driver.get("https://dan-it.com.ua/");
        Thread.sleep(2000);
//оновлення сторінки
        driver.navigate().refresh();
        Thread.sleep(2000);*/
// неявніе очікуваня отработки скріптов сторінки
         driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));


//WebDriverWait -окремий класс який чекає поки не буде зроблена задана умова
 //це явне очікування
       // driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
//очікує поки заданий елемент не знайдеться,якщо він не буде знайден то программа зупинеться
// wait.until(ExpectedConditions.visibilityOfElementLocated(BY))

//visibilityOfElementLocated,frameToBeAvailableAndSwitchToIt,alertIsPresent
     /*   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iframe[@id='iframeResult']"));
//  як би ми це робили без явного очікування
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Try it']")));
        WebElement tryIt= driver.findElement(By.xpath("//button[text()='Try it']"));
        tryIt.click();

        //Alert alert=driver.switchTo().alert();
        //може не встигнути загрузитися используем wait.until
        Alert alert=wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
        alert.accept();
        driver.quit();*/
/*
//elementToBeClickable(), elementToBeSelected(), elementSelectionStateToBe()
        driver.get("https://guinnessworldrecords.com/Account/Login?ReturnUrl=%2faccount");
//очікування наступної дії,поки буде клікабельно вікно вводу, тобо то наступна дія не виконається до завершення очікування і дії в ньому
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='RememberMe']")));
//wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//input[@id='RememberMe']")));
        driver.findElement(By.xpath("//input[@id='Username']")).sendKeys("хомяк");
        wait.until(ExpectedConditions.elementSelectionStateToBe
                (driver.findElement(By.xpath("//input[@id='RememberMe']")), false));
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("dfds");
        WebElement pass= driver.findElement(By.xpath("//input[@id='Password']"));
        driver.get("https://dan-it.com.ua/");

//presenceOfElementLocated(), textToBePresentInElementValue(), invisibilityOf(),
//titleContains(), titleIs()
// очікування поки якийсь елемент не исчесзнет
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@id='Password']")));
 //з'явилась назва сторінки
        wait.until(ExpectedConditions.titleContains("DAN.IT"));
        wait.until(ExpectedConditions.titleContains("програмування в Києві"));
        wait.until(ExpectedConditions.titleIs("Курси програмування в Києві ☑️ IT курси з працевлаштуванням"));
        System.out.println(driver.getTitle());
        driver.quit();
*/
 /*
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        WebElement accept = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ez-accept-all")));
        accept.click();
        WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Username']")));
        wait.until(ExpectedConditions.textToBePresentInElementValue(userNameField,"Хомяк"));
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Password");
        driver.get("https://uhomki.com.ua/");
        wait.until(ExpectedConditions.invisibilityOf(userNameField));
        wait.until(ExpectedConditions.titleIs("\"У Хомки\" Интернет-зоомагазин | Днепр, пр. А. Поля, 59. (остановка \"Медтехника\")"));
        wait.until(ExpectedConditions.titleContains("\"У Хомки\""));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span//a[@href='/ru/oplata-i-dostavka/']")));
        wait.until(ExpectedConditions.textToBePresentInElement(element,"Оплата и доставка"));
        System.out.println(driver.getTitle());
*/

//ВІЛЬНІ ОЧІКУВАННЯ
        FluentWait <WebDriver> fluentWait =new  FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(InvalidElementStateException.class)
                .ignoring(StaleElementReferenceException.class);
        driver.get("https://guinnessworldrecords.com/Account/Login?ReturnUrl=%2faccount");
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ez-accept-all")));
        driver.findElement(By.id("ez-accept-all")).click();

    }
}
