package testng.dataProvider;

import lesson6.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

public class Ex1 {
    WebDriver driver;
    @BeforeMethod
    public void start(){
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://klopotenko.com/");
        WebElement element = (new Waiters(driver)
                .waitForPresenceOfElementLocatedReturn(By.xpath("//a[@aria-label='dismiss cookie message']")));
        element.click();
    }
    @AfterMethod
    public void stop(){
        driver.quit();
    }

//@DataProvider(name = "необхідне ім'я") в середені ми перераховуємо параметри які ми хочемо використовувати
//тобто якщо нам перевірити 40 якіхось варіантів пошукубщоб для кожного не створбвати новий метод/тест
@DataProvider(name = "searchParameters")
public Object[][] createData(){
//ми створіли 2мірний массив щоб кожного разу не пропісувати з чим порівнювати
    return new Object[][]{
            {"Meat","MEAT"},
            {"Carrot","CARROT"},
            {"Potato","POTATO"}
    };
}
    @DataProvider(name = "searchParametersFalse")
    public Object[][] createData2(){
//в данному прикладі ми робимо 2мірний масив щоб вводити і емейл і підходящій до ньго пароль
        return new Object[][]{
                {"roman@wer.com",345278},
                {"romadsdsne@wer.com",22221221},
                {"romaddsane@wer.com",332323}
        };
    }
    @Test(dataProvider = "searchParameters")
    public void search(String inputMessage, String expretedValue) {
        driver.get("https://klopotenko.com/");
        WebElement search = (new Waiters(driver)).waitForPresenceOfElementLocatedReturn(By.id("open-search"));
        search.click();
        WebElement input = (new Waiters(driver))
                .waitForPresenceOfElementLocatedReturn(By.xpath("//input[@placeholder='Пошук...']"));
        input.sendKeys(inputMessage);
        input.submit();
        (new Waiters(driver)).waitForTitleContains("Ви шукали "+inputMessage);
        assertTrue(driver.findElement(By.tagName("h2")).getText()
                .replace("ЗНАЙДЕНО ЗА ЗАПИТОМ: ", "").equals(expretedValue));
        driver.quit();
    }
    @Test(dataProvider = "searchParametersFalse")
   public void login(String mail, int pass) {
        driver.get("https://klopotenko.com/");
        WebElement element = (new Waiters(driver)
                .waitForPresenceOfElementLocatedReturn(By.xpath("//a[@aria-label='dismiss cookie message']")));
        element.click();
        WebElement loginField = driver.findElement(By.xpath(""));
        WebElement passField = driver.findElement(By.xpath(""));
        loginField.sendKeys(mail);
        String password = String.valueOf(pass);
        passField.sendKeys(password);
        passField.submit();
        driver.quit();
    }

}
