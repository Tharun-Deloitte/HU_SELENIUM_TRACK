package selenium_basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario1 {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        // write your code here
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://google.co.in");
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        Thread.sleep(5000);
        By frames=By.xpath("/html/body/div[2]/div/ul/li[22]/a");
        driver.findElement(frames).click();
        Thread.sleep(5000);
        By Nested=By.xpath("//a[contains(text(),'Nested Frames')]");
        driver.findElement(Nested).click();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement l = driver.findElement(By.cssSelector("body"));
        System.out.println(l.getText());
        driver.quit();
    }
}
