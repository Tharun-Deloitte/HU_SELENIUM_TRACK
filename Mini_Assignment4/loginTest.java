package test;

import Assignment_4.CartPage;
import Assignment_4.HomePage;
import Assignment_4.login;
import org.checkerframework.checker.units.qual.C;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

import java.io.IOException;


public class loginTest {
    static WebDriver driver;
    int high,low;
    login l;
    HomePage h;
    CartPage c;

    @BeforeClass
    public static void aset_up() throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.co.in");
        Thread.sleep(5000);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
    }

    @Test
    public void check1() throws InterruptedException {
        l = new login(driver);
        l.username();
        l.setPassword();
        l.click();
    }

    @Test
    public void check2()
    {
        h =new HomePage(driver);
        c=new CartPage(driver);
        try {
            high=h.gethighprice();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        h.addtocart_enabled(high);
        h.AddtoCart(high);
        h.remove_enabled(high);
        h.remove(high);
        h.AddtoCart(high);
        h.click_Cart();
        c.click_continue_to_shopping();
    }

    @Test
    public void check3(){
        h =new HomePage(driver);
        c=new CartPage(driver);
        try {
            low=h.getlowerprice();
        } catch (Exception e) {
            e.printStackTrace();
        }
        h.addtocart_enabled(low);
        h.AddtoCart(low);
        h.click_Cart();
    }

    @Test
    public void check4(){
        c=new CartPage(driver);
        c.check_out();
        c.first_name();
        c.last_name();
        c.pincode();
        c.click_continue();
        c.Finish();
        c.Msg();
    }

    @AfterClass
    public void end(){
        driver.quit();
    }


}
