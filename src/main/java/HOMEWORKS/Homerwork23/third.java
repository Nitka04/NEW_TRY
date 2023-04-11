package HOMEWORKS.Homerwork23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//Написать метод который выводит сообщение об айди элемента,
//значении тэга элемента , значении класса элемента,
//значении атрибута name элемента, текста данного элемента,
//а также о координатах центра контейнера данного элемента.
//Создать свой тип исключений, который будет вызываться если у элемента
//нет определенного атрибута и на экран будет выводиться сообщение об отсутствии данного атрибута.
public class third {
    //private static ExceptionNull

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://garnamama.com/ua");
        WebElement info=driver.findElement(By.xpath("//div[@id='dock-wrapper']"));
        System.out.println("ID of element: "+info.getAttribute("id"));
        System.out.println("class of element: "+info.getAttribute("class"));
        System.out.println("name of element: "+info.getAttribute("name"));
        System.out.println("text of element: "+info.getAttribute("text"));
        System.out.println("tag of element: "+info.getTagName());
        int high=info.getSize().height;
        int length=+info.getSize().width;
        int y=info.getLocation().y;
        int x=info.getLocation().x;

        System.out.println("tag of element: "+info.getTagName());


        driver.quit();
        //тэга элемента
//а также о координатах центра контейнера данного элемента.

    }
}
