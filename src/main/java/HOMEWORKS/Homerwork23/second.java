package HOMEWORKS.Homerwork23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Написать метод в параметры которого принимаются два ВебЭлемента.
//метод выводит в консоль информацию какой из двух элементов располагается
// выше на странице,
//какой из элементов располагается левее на странице,
//а также какой из элементов занимает большую площадь.
//Параметры метода могут также включать в себя другие аргументы, если это необходимо.
public class second {
    static void compareOfSizes(WebDriver driver,String xpath1,WebDriver driver2,String xpath2){
        WebElement webEl1=driver.findElement(By.xpath(xpath1));
        WebElement webEl2=driver2.findElement(By.xpath(xpath2));
        int x1=webEl1.getLocation().x;
        int y1=webEl1.getLocation().y;
        int x2=webEl2.getLocation().x;
        int y2=webEl2.getLocation().y;
        int high1=webEl1.getSize().height;
        int high2=webEl2.getSize().height;
        int length1=+webEl1.getSize().width;
        int length2=webEl2.getSize().width;
        if (y1<y2){
            System.out.println("First element is higher.");
        }else {System.out.println("Second element is higher.");}
        if (x1<x2){
            System.out.println("First element is closer to the left side.");
        }else { System.out.println("Second element is closer to the left side.");}
        if(high1*length1*2<high2*length2*2){
            System.out.println("First element area of  is bigger.");
        }else {System.out.println("Second element area of  is bigger.");}
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://garnamama.com/ua");
        WebElement webEl1=driver.findElement(By.xpath("//input[@name='search']"));
        WebElement webEl2=driver.findElement(By.xpath("//a[text()='Детальніше']"));
        compareOfSizes(driver, "//input[@name='search']", driver, "//a[text()='Детальніше']");
        driver.quit();
    }

}
