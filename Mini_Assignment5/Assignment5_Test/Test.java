package Assignment5_Test;

import Assignment5.CartPage;
import Assignment5.HomePage;
import Assignment5.login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.IOException;

@Listeners(Assignment5_Test.TestNGListenr.class)
public class Test extends Base{
    String high,low;

    @BeforeMethod(alwaysRun = true)
    public static void aset_up() throws IOException, InterruptedException {
        System.out.println("Starting the test");
    }

    @org.testng.annotations.Test(priority = 1)
    public void Adding_High_Value_Product() {
        WebDriver driver =initialize();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        login_initialize(driver);
        HomePage h1 =new HomePage(driver);
        CartPage c1=new CartPage(driver);
        try {
            high=h1.gethighprice();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        h1.AddtoCart(high);
        h1.click_Cart();
        c1.click_continue_to_shopping();
        driver.quit();
    }

    @org.testng.annotations.Test(priority = 2)
    public void Adding_Low_Value_Prouct()
    {
        WebDriver driver =initialize();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        login_initialize(driver);
        HomePage h2 =new HomePage(driver);
        CartPage c2=new CartPage(driver);
        try {
            low=h2.getlowerprice();
        } catch (Exception e) {
            e.printStackTrace();
        }
        h2.AddtoCart(low);
        h2.click_Cart();
        c2.click_continue_to_shopping();
        driver.quit();
    }

    @org.testng.annotations.Test(priority = 3)
    public void Adding_Both_High_And_LOW_Value_Products_AND_CHECKOUT(){
        WebDriver driver =initialize();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        login_initialize(driver);
        HomePage h3 =new HomePage(driver);
        CartPage c3=new CartPage(driver);
        try {
            high=h3.gethighprice();
            low=h3.getlowerprice();
        } catch (Exception e) {
            e.printStackTrace();
        }
        h3.AddtoCart(high);
        h3.AddtoCart(low);
        h3.click_Cart();
        c3.check_out();
        c3.Get_Details();
        c3.first_name();
        c3.last_name();
        c3.pincode();
        c3.click_continue();
        c3.Finish();
        c3.Msg();
        driver.quit();
    }

    @org.testng.annotations.Test(priority = 4)
    public void Validating_Buttons() throws InterruptedException {
        WebDriver driver =initialize();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        login_initialize(driver);
        HomePage h4=new HomePage(driver);
        Thread.sleep(5000);
        try {
            low=h4.getlowerprice();
        } catch (Exception e) {
            e.printStackTrace();
        }
        h4.addtocart_enabled(low);
        h4.AddtoCart(low);
        h4.remove_enabled(low);
        h4.remove(low);
        driver.quit();
    }

    @AfterMethod(alwaysRun = true)
    public void end(){
        System.out.println("End of the test");
    }

}
