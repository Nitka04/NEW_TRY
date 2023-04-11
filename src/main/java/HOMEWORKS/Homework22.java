package HOMEWORKS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class Homework22 {
    private static class URLS{

        private static final String DanIt="https://dan-it.com.ua/";
        private static final String Homka="https://uhomki.com.ua/ru/koshki/1074/";
    }
    private static class Locators{
       private static final By acceptlanguage= By.xpath("//a[text()='Російська']");
        private static final By IdeaCook=By.xpath("//button[@class='jetbrains-cookies-banner-3-button jetbrains-cookies-banner-3-button--accent jetbrains-cookies-banner-3__action']");
    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//1 exercise;
        /*driver.get(URLS.Homka);*/
        /*driver.findElement(By.className("userbar__button-text")).click();*/
        /*driver.findElement(By.linkText("Вход")).click();*/
        /*driver.findElement(By.partialLinkText("Вх")).click();*/
        /*driver.findElement(By.xpath("//span[text()='Вход'][1]")).click();*/

//2 exercise;
         /*driver.findElement(By.xpath("//div[@class='footer__heading']/following-sibling::*[1]/descendant::li[2]")).click();*/
//3 exercise;
         /*driver.get(URLS.DanIt);
         driver.findElement(Locators.acceptlanguage).click();
        Thread.sleep(1000);
         driver.findElement(By.xpath("//h1[contains(text(), 'IT-образование')]/following-sibling::*[2]/child::a")).click();*/

//4 exercise;
        /*driver.get(URLS.Homka);*/
       /*driver.findElement(By.xpath("//li[@class='products-menu__item j-submenu-item'][7]"));
        Thread.sleep(500);*/
       /* driver.findElement(By.xpath("//span[@class='productsMenu-submenu-t'][77]")).click();*/
       /* driver.findElement(By.xpath("//li[@class='products-menu__item j-submenu-item'][7]/div[2]/ul//li//a//span[text()='Аквариумы']")).click();
*/
       /*driver.findElement(By.xpath())*/
//5 exercise;
        /*driver.get(URLS.DanIt);
        driver.findElement(Locators.acceptlanguage).click();
        driver.findElement(By.xpath("//a[@class='page-header__phone']")).click();*/
//6 exercise;
/*
        driver.get(URLS.DanIt);
        driver.findElement(Locators.acceptlanguage).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul[@class='banner__meta-data banner-meta']/descendant::li[last()]")).click();
*/
//7 exercise;
        /*driver.get("https://www.w3schools.com/");*/
        /*driver.findElement(By.xpath("//a[@id='nav_search_btn']")).click();*/
        /*driver.findElement(By.xpath("//a[@id='nav_translate_btn']")).click();*/
        /*driver.findElement(By.xpath("//a[@id='navbtn_references']")).click();*/
        /*driver.findElement(By.xpath("//a[@id='navbtn_tutorials']")).click();*/
        /*driver.findElement(By.xpath("//a[@id='navbtn_exercises']")).click();*/
        /*driver.findElement(By.xpath("//a[@id='cert_navbtn']")).click();*/
        /*driver.findElement(By.xpath("//a[@id='w3loginbtn']")).click();*/
        /*driver.findElement(By.xpath("//a[@id='signupbtn_topnav']")).click();*/
        /*driver.findElement(By.xpath("//input[@id='search2']")).sendKeys("JAVA");*/
        /*driver.findElement(By.xpath("//a[@id='myLearningFromDefault']")).click();*/
//8 exercise;
       /* driver.get(URLS.DanIt);
        driver.findElement(Locators.acceptlanguage).click();
        driver.findElement(By.xpath("//p[@class='main-info__title'][1]/parent::li/parent::ul//../child::div/child::ul/child::li[3]")).click();*/
//9 exercise;
      /*  driver.get("https://www.jetbrains.com/idea/");
        Thread.sleep(1000);
        driver.findElement(Locators.IdeaCook).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[@class='wt-col-inline menu-second__download-button wt-button wt-button_size_s wt-button_mode_primary']")).click();*/
//10 exercise;
       /* driver.get("https://www.jetbrains.com/idea/download/#section=windows");
        Thread.sleep(1000);
        driver.findElement(Locators.IdeaCook).click();
        Thread.sleep(500);*/
        //first button for Windows
        /*driver.findElement(By.xpath("//a[@class='_main_12yxkch_17 _modeClassic_12yxkch_135 _sizeM_12yxkch_99 _alignIconLeft_12yxkch_77 _light_12yxkch_59" +
                " _flatRight_12yxkch_125 _wtDownloadButton__left_3gbaqk _wtDownloadButton__left_2sbscl _wtDownloadButton__left_45alcl']")).click();*/
       //second button fo Apple
       /* driver.findElement(By.xpath("//a[@class='_main_12yxkch_17 _modeRock_12yxkch_208" +
                " _sizeM_12yxkch_99 _alignIconLeft_12yxkch_77 _light_12yxkch_59 _flatRight_12yxkch_125 _wtDownloadButton__left_3gbaqk" +
                " _wtDownloadButton__left_2sbscl _wtDownloadButton__left_45alcl']")).click();*/
    }
}
