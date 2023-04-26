package testng.dependency;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
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
//Якщо є анотація @BeforeClass то вона буде запускатися найпершою
    @BeforeClass
    public void startTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        initialDriver();
        setDriver();
    }
// @AfterClass запускається після проходження усіх тестів классів
    @AfterClass
    public void stopTests(){
        closeDriver();
    }
}
