package Assignment5_Test;

import Assignment5.CartPage;
import Assignment5.HomePage;
import Assignment5.login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.IOException;

@Listeners(Assignment5_Test.TestNGListenr.class)
public class Test {
    static WebDriver driver;
    String high,low;
    login l;
    HomePage h;
    CartPage c;

    @BeforeMethod(alwaysRun = true)
    public static void aset_up() throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.co.in");
        Thread.sleep(5000);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @org.testng.annotations.Test(priority = 1)
    public void Adding_High_Value_Product() {
        l = new login(driver);
        l.get_details();
        l.username();
        l.setPassword();
        l.click();
        h =new HomePage(driver);
        c=new CartPage(driver);
        try {
            high=h.gethighprice();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        h.AddtoCart(high);
        h.click_Cart();
        c.click_continue_to_shopping();
    }

    @org.testng.annotations.Test(priority = 2)
    public void Adding_Low_Value_Prouct()
    {
        l = new login(driver);
        l.get_details();
        l.username();
        l.setPassword();
        l.click();
        h =new HomePage(driver);
        c=new CartPage(driver);
        try {
            low=h.getlowerprice();
        } catch (Exception e) {
            e.printStackTrace();
        }
        h.AddtoCart(low);
        h.click_Cart();
        c.click_continue_to_shopping();
    }

    @org.testng.annotations.Test(priority = 3)
    public void Adding_Both_High_And_LOW_Value_Products_AND_CHECKOUT(){
        l = new login(driver);
        l.get_details();
        l.username();
        l.setPassword();
        l.click();
        h =new HomePage(driver);
        c=new CartPage(driver);
        try {
            high=h.gethighprice();
            low=h.getlowerprice();
        } catch (Exception e) {
            e.printStackTrace();
        }
        h.AddtoCart(high);
        h.AddtoCart(low);
        h.click_Cart();
        c.check_out();
        c.Get_Details();
        c.first_name();
        c.last_name();
        c.pincode();
        c.click_continue();
        c.Finish();
        c.Msg();
    }

    @org.testng.annotations.Test(priority = 4)
    public void Validating_Buttons() throws InterruptedException {
        l = new login(driver);
        l.get_details();
        l.username();
        l.setPassword();
        l.click();
        h=new HomePage(driver);
        Thread.sleep(5000);
        try {
            low=h.getlowerprice();
        } catch (Exception e) {
            e.printStackTrace();
        }
        h.addtocart_enabled(low);
        h.AddtoCart(low);
        h.remove_enabled(low);
        h.remove(low);
    }

    @AfterMethod(alwaysRun = true)
    public void end(){

        //driver.quit();
    }


}
