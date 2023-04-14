package HOMEWORKS.Homework24;
// http://only-testing-blog.blogspot.com/2014/01/textbox.html?
//Написать программу реализующую действие показанное на "видео1.mp4".
//После выполнения программы на консоли должна выводится информация в следующем виде:
//
//Автомобили доступные для выбора:
//Volvo, BMW, Opel, Audi, Toyota, Renault, Maruti Car.
//Страны из первой таблицы:
//USA, Russia, Japan, Mexico, India, Malaysia, Greece.
//Страны из второй таблицы:
//France, Germany, Italy, Spain.
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class First {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://only-testing-blog.blogspot.com/2014/01/textbox.html?");
        WebElement carList= driver.findElement(By.id("Carlist")); //select[@id='Carlist']
        Select car=new Select(carList);
        car.selectByVisibleText("Renault");
        Select country=new Select(driver.findElement(By.xpath("//select[@name='FromLB']")));
         country.selectByValue("Germany");
         country.selectByVisibleText("France");
        country.selectByValue("Italy");
        country.selectByValue("Spain");
        driver.findElement(By.xpath("//input[@onclick='move(this.form.FromLB,this.form.ToLB)']")).click();
        Thread.sleep(1000);
        System.out.println("Автомобили доступные для выбора:");
        List<WebElement> carsLists=car.getOptions();
        for (WebElement carsList:carsLists ){
            System.out.print(carsList.getText()+", ");
        }
        System.out.println("\nСтраны из первой таблицы: ");
        List<WebElement> countryLists=country.getOptions();
        for (WebElement countryList:countryLists ){
            System.out.print(countryList.getText()+", ");
        }
        System.out.println("\nСтраны из второй таблицы: ");
        WebElement chosenCounty=driver.findElement(By.xpath("//select[@name='ToLB']"));
        Select country2=new Select(chosenCounty);
        List<WebElement> chosenCountys=country2.getOptions();
        for (WebElement chosenCounty1:chosenCountys ){
            System.out.print(chosenCounty1.getText()+", ");
        }
        Thread.sleep(2000);
        driver.quit();

    }
}
