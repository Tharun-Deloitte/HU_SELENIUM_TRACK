package test;

import Assignment_4.CartPage;
import Assignment_4.HomePage;
import Assignment_4.login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;


public class loginTest {
    static WebDriver driver;
    int high,low;
    login l;
    HomePage h;
    CartPage c;

    @BeforeClass(alwaysRun = true)
    public static void aset_up() throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.co.in");
        Thread.sleep(5000);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void D_login_Check() {
        l = new login(driver);
        l.get_details();
        l.username();
        l.setPassword();
        l.click();
    }

    @Test(priority = 2)
    public void C_High_Price()
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

    @Test(priority = 3)
    public void B_Low_Price(){
        try {
            low=h.getlowerprice();
        } catch (Exception e) {
            e.printStackTrace();
        }
        h.AddtoCart(low);
        h.click_Cart();
    }

    @Test(priority = 4)
    public void A_Check_out(){
        c=new CartPage(driver);
        c.check_out();
        c.Get_Details();
        c.first_name();
        c.last_name();
        c.pincode();
        c.click_continue();
        c.Finish();
        c.Msg();
    }

    @AfterClass(alwaysRun = true)
    public void end(){
        driver.quit();
    }


}
