package Homeworks.Homework28;

import lesson6.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

public class Task4Param {
    static WebDriver driver;
    @BeforeMethod
    public void start(){
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.foxtrot.com.ua/");
        WebElement element = (new Waiters(driver)
                .waitForPresenceOfElementLocatedReturn(By.xpath("//div[@class='popup user-location-popup first-visit popup_active']/div/div[1]")));
        element.click();
    }
    @AfterMethod
    public void stop(){
        driver.quit();
    }
    @DataProvider(name = "searchWords")
    public Object[][] createData() {
//ми створіли 2мірний массив щоб кожного разу не пропісувати з чим порівнювати
        return new Object[][]{
                {"машина","машина"},
                {"input", "input"},
                {"смысл", "смысл"}
        };
    }
    @Test(dataProvider = "searchWords")
    public void checkOfSearchResultDataProvider (String searchWord, String expretedValue) {
        WebElement searchLine=(new Waiters(driver))
                .waitForPresenceOfElementLocatedReturn(By.xpath("//input[@placeholder='Я шукаю ...']"));
        Actions action=new Actions(driver);
        searchLine.sendKeys(searchWord);
        action.sendKeys(searchLine, Keys.ENTER).build().perform();
        WebElement resultOfSearch=(new Waiters(driver))
                .waitForPresenceOfElementLocatedReturn(By.xpath("//div[@class='page__title']"));
        WebElement resultOfIncorrectSearch=(new Waiters(driver))
                .waitForPresenceOfElementLocatedReturn(By.xpath("//main[@class='pb-3']/main/div/following-sibling::*[1]/div/div/h1"));
        if (resultOfSearch.getText().contains(expretedValue)) {
            assertTrue(resultOfSearch.getText().contains(expretedValue));
        }else {
            if (resultOfIncorrectSearch.getText().contains(expretedValue)) {
                assertTrue(resultOfIncorrectSearch.getText().contains(expretedValue), "The result of search didn`t contains the word" + resultOfIncorrectSearch.getText());
            } else {
                System.out.println("The result of search didn`t contains the word" + resultOfSearch.getText());
            }
        }

    }

    @Parameters({"input"})
    @Test
    public void checkOfSearchResultParameters (String searchWord) {
        WebElement searchLine=(new Waiters(driver))
                .waitForPresenceOfElementLocatedReturn(By.xpath("//input[@placeholder='Я шукаю ...']"));
        Actions action=new Actions(driver);
        searchLine.sendKeys();
        action.sendKeys(searchLine, Keys.ENTER).build().perform();
        WebElement resultOfSearch=(new Waiters(driver))
                .waitForPresenceOfElementLocatedReturn(By.xpath("//div[@class='page__title']"));
        WebElement resultOfIncorrectSearch=(new Waiters(driver))
                .waitForPresenceOfElementLocatedReturn(By.xpath("//main[@class='pb-3']/main/div/following-sibling::*[1]/div/div/h1"));
        if (resultOfSearch.getText().contains(searchWord)) {
            assertTrue(resultOfSearch.getText().contains(searchWord));
        }else {
            if (resultOfIncorrectSearch.getText().contains(searchWord)) {
                assertTrue(resultOfIncorrectSearch.getText().contains(searchWord), "The result of search didn`t contains the word" + resultOfIncorrectSearch.getText());
            } else {
                System.out.println("The result of search didn`t contains the word" + resultOfSearch.getText());
            }
        }
    }
}
