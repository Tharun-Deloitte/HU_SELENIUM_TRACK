package selenium_basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Headless {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        // write your code here
        System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://google.co.in");
        driver.manage().window().maximize();
        driver.get("https://phptravels.com/demo");
        String parentwindow=driver.getWindowHandle();
        String s=driver.getTitle();
        compare(s);
        By l=By.xpath("//section[1]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/a/small");
        driver.findElement(l).click();
        Thread.sleep(5000);
        String s2=driver.getTitle();
        if(s.compareTo(s2)==0)
        {
            System.out.println("Pass");
        }
        else{
            System.out.println("Fail");
        }
        driver.switchTo().window(parentwindow);
        System.out.println(driver.getCurrentUrl());
        By pricing=By.xpath("//a[text()='Pricing']");
        driver.findElement(pricing).click();
        Thread.sleep(5000);
        driver.navigate().back();
        driver.navigate().refresh();

    }
    public static void compare(String s){
        if(s.contains("PHPTRAVELS"))
            System.out.println("Pass");
        else
            System.out.println("Fail");
    }
}
