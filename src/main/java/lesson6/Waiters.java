package lesson6;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
//написання методів по очікуванню виконання тестових завдань
public class Waiters {
    private final WebDriver driver;//переменная незмінна
    private static final long EVPLICITY_WAIT=20L;
    public Waiters(WebDriver driver) {//конструктор
        this.driver=driver;
    }

    private FluentWait<WebDriver> fluentWait(Long duration ){ //метод який повертає
        return  new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(InvalidElementStateException.class)
                .ignoring(StaleElementReferenceException.class);
    }
    private void waitForFunction(Function function, Long timeOutInSeconds){ //метод який повертає
        FluentWait<WebDriver> wait=fluentWait(timeOutInSeconds);
    }

    public void  wwaitForVisabilityOfElement (WebElement element){
        waitForFunction(ExpectedConditions.visibilityOf(element), EVPLICITY_WAIT);
    }

    public void  waitForVisabilityOfElement (By by){
        waitForFunction(ExpectedConditions.visibilityOf(driver.findElement(by)), EVPLICITY_WAIT);
    }

    public WebElement waitForVisabilityOfElementReturn (WebElement element){
        return fluentWait(EVPLICITY_WAIT).until(ExpectedConditions.visibilityOf(element));
    }
    public WebElement waitForVisabilityOfElementReturn (By by){
        return fluentWait(EVPLICITY_WAIT).until(ExpectedConditions.visibilityOf(driver.findElement(by)));
    }

    //textToBePresentInElementValue
    public void waitFortextToBePresentInElementValue(WebElement element, String text){
        waitForFunction(ExpectedConditions
                .textToBePresentInElementValue(element,text),EVPLICITY_WAIT);
    }
    public void waitForInvisibilityOf(WebElement element){
        waitForFunction(ExpectedConditions
                .invisibilityOf(element),EVPLICITY_WAIT);
    }
    public void waitForTitleContains(String text){
        waitForFunction(ExpectedConditions
                .titleContains(text),EVPLICITY_WAIT);
    }
    public WebElement waitForPresenceOfElementLocated(By by){
        return fluentWait(EVPLICITY_WAIT)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public void waitSomeSecond(int seconds){
        int milisecond = seconds*1000;
        try {
            Thread.sleep(milisecond);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }



}
