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
    private static class NullElem extends Throwable{
        public String getMessage(){
            return "Element don't have such parament.";
        }
    }

    public static void main(String[] args) throws NullElem {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rozetka.com.ua/");
        WebElement info = driver.findElement(By.xpath("//input[@name='search']"));

       //driver.get("https://garnamama.com/ua");
        //WebElement info=driver.findElement(By.xpath("//div[@id='dock-wrapper']"));
        String id=info.getAttribute("id");
        String name=info.getAttribute("name");
        String clas= info.getAttribute("class");
        String text=info.getAttribute("text");
        String tag=info.getTagName();
           try {
               if ((id == null||id.equals(""))==true) {
                   System.out.println("id: ");
                   throw new NullElem();
               } else {System.out.println("ID of element: " + info.getAttribute("id"));}
           }catch (NullElem e){System.out.println(e.getMessage());}
           try{
            if((name==null||name.equals(""))==true){
                System.out.println("name:");
                throw  new NullElem();
            }else {System.out.println("name of element: "+info.getAttribute("name"));}
            }catch (NullElem e){System.out.println(e.getMessage());}
            try {if((clas==null||clas.equals(""))==true){
                System.out.println("class: ");
                throw new NullElem();
            }else {System.out.println("class of element: "+info.getAttribute("class"));}
            }catch (NullElem e){System.out.println(e.getMessage());}
        try{
            if((text==null||text.equals(""))==true){
                System.out.println("text: ");
                throw new NullElem();
            }else {System.out.println("text of element: "+info.getAttribute("text"));}
            }catch (NullElem e){System.out.println(e.getMessage());}
             try {if((tag==null||tag.equals(""))==true){
                 System.out.println("tag: ");
                     throw new NullElem();
                 }else{System.out.println("tag of element: "+info.getTagName());}
             }catch (NullElem e){System.out.println(e.getMessage());}
             int high=info.getSize().height;
             int length=+info.getSize().width;
             int y=info.getLocation().y+high/2;
             int x=info.getLocation().x+length/2;
        System.out.println("Ccoordinates of the centre contaner:\n"+"x="+x+"\ny="+y);
        driver.quit();
        //тэга элемента
//а также о координатах центра контейнера данного элемента.

    }
}
