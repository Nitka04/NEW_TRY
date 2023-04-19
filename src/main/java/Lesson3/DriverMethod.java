package Lesson3;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DriverMethod {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();// створили екцемпляр классу
        options.addArguments("--disable-notifications");// прибираємо нотіфвкації котрі вспливають
        //але їх треба з'єднати тому прописуємо це у скобках
        WebDriver driver = new ChromeDriver(options);
        //timeouts() интерфейс для управления ожиданиями драйвера
        //implicitlyWait-неявное ожидание,  будет действовать на протяжении всего пробега автотестов
        // и ожидать указанное время прежде, чем выбросить NoSuchElementException
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
        //.window(): активирует интерфейс для управления текущим окном
        driver.manage().window().maximize();

/*        driver.get("https://rozetka.com.ua/ua/");
//отримання усіх кукіз та відобразити іх в консолі.
        System.out.println(driver.manage().getCookies());

       Set<Cookie> set = driver.manage().getCookies();
//<...> -ми вставляємо множину у котріх немає об'єктів, в данному випадку це множина
// різновідність куків

//виводимо усі кукі данного сайту.
        for (Cookie cookie:set){
            System.out.println(cookie);
        }
//приводимо до массиву щоб дізнатися його довжину.
        System.out.println("Количество куков равно "+ set.toArray().length);
//отримати інформацію про конкретну куку
        //set  не може дублювати тобто не можно через запятую вставіти дві цифри
        System.out.println("Отдельная кука "+ set.toArray()[6]);
        //закінчівши один get  драйвер перейде до іншого .
        driver.get("https://dan-it.com.ua/program/kiev/java/");
        driver.quit();
 */

//driver.getCurrentUrl()- дає можливість отримати url сторінки ю можливість вивести її на консоль.
 /*       driver.get("https://rozetka.com.ua/ua/");
        System.out.println(driver.getCurrentUrl());
        driver.get("https://dan-it.com.ua/program/kiev/java/");
        System.out.println(driver.getCurrentUrl());
        driver.quit();
*/
//gettitle() - отримати назву сторінки
 /*       driver.get("https://dan-it.com.ua/program/kiev/java/");
        System.out.println(driver.getTitle());
        driver.quit();
*/
//getpageSource() -отримати ДОМ дерево та всю інформацію
/*      driver.get("https://dan-it.com.ua/program/kiev/java/");
        System.out.println(driver.getPageSource());
        driver.quit();
 */
//navigate -рухатися по сторінке вперед назад
/*
        driver.get("https://dan-it.com.ua/uk/");
        driver.findElement(By.xpath("//a[text()='Про нас']")).click();
        Thread.sleep(300);
        driver.navigate().back();
        Thread.sleep(300);
        driver.navigate().to("https://rozetka.com.ua/");
        System.out.println(driver.getTitle());
*/
//работа с окнами
/*
        driver.get("https://dan-it.com.ua/program/kiev/java/");
//отримати діскриптер текущего вікна індіфікатор
        System.out.println(driver.getWindowHandle());
        String descr1= driver.getWindowHandle();
//driver.getWindowHandle() и driver.getWindowHandles() дискриптор оконо.
// єто когда мі откріваем новю страницу и продолжить работу в ней
//т.к вебдрайвер думает что мі работаем в предідущей странице.
        Set<String> set1 = driver.getWindowHandles();
//JavascriptExecutor-дозволяє відкрити нове вікно.
//window.open()-метод відкриття нового вікна
        ((JavascriptExecutor)driver).executeScript("window.open()");
//driver.getWindowHandle() и driver.getWindowHandles() дискриптор оконо.
        Set<String> set2 = driver.getWindowHandles();
// видалити усі вказані діскриптори
        set2.removeAll(set1);
// це вже продовження працювати в новому вікні
        String descr2= set2.iterator().next();
//SwichTo()-переключение на інше вікно
        driver.switchTo().window(descr2);
        driver.navigate().to("https://rozetka.com.ua/");
//отримати діскриптер усіх відкритих вікон.
        System.out.println(driver.getWindowHandles());
//переключення на 1ше вікно
        driver.switchTo().window(descr1);
//його закриття
        driver.close();
        Thread.sleep(2000);
        driver.quit();
*/
// driver.findElements()  -пошук єлементів
        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        driver.findElements(By.cssSelector(".columned.block.block-4-12>a"));
        //ArrayList збирає усі результати пошуку до массиву
        ArrayList<WebElement> listOfElem = new ArrayList<>(driver.findElements(By.cssSelector(".columned.block.block-4-12>a")));
        //цикл для виводу текстів усіх  єелементів які ми шукали.
        for(WebElement webElement:listOfElem){
            System.out.println(webElement.getText());
        }
        driver.quit();






    }
}
