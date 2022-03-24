package selenium_basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario3 {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        // write your code here
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.manage().window().maximize();

        //Url of the website
        driver.get("https://the-internet.herokuapp.com/ ");

        //Click on JavaScript Alerts
        By alerts = By.xpath("/html/body/div[2]/div/ul/li[29]/a");
        driver.findElement(alerts).click();

        By prompt = By.xpath("/html/body/div[2]/div/div/ul/li[3]/button");
        driver.findElement(prompt).click();
        driver.switchTo().alert().sendKeys("Ex- Test");
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        String str = driver.findElement(By.id("result")).getText();
        if (str.contains("Ex- Test"))
        {
            System.out.println("same");
        }
        else
        {
            System.out.println("not same");
        }

    }

}
