package Assignment_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.Zip;

import java.io.IOException;

public class CartPage {

    By continue_shopping=By.xpath("//button[@id='continue-shopping']");
    WebDriver driver;
    By checkout=By.xpath("//button[@id='checkout']");
    By Firstname=By.xpath("//input[@id='first-name']");
    By Lastname=By.xpath("//input[@id='last-name']");
    By pin=By.xpath("//input[@id='postal-code']");
    By cont=By.xpath("//input[@id='continue']");
    By finish=By.xpath("//button[@id='finish']");
    By thankYouMessage = By.xpath("//*[@id='checkout_complete_container']/h2");
    ExcelData xls1;
    String Name,lastname,ZipCode;
    public void Get_Details() {
        try {
            xls1 = new ExcelData("C:\\Users\\naratreddy\\IdeaProjects\\Login.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Name = xls1.getData(1, 0, 0);
        lastname = xls1.getData(1, 1, 0);
        ZipCode = xls1.getData(1, 2, 0);
    }

    public CartPage(WebDriver driver){
        this.driver=driver;
    }


    public void click_continue_to_shopping(){
        driver.findElement(continue_shopping).click();
    }

    public void check_out(){
        driver.findElement(checkout).click();
    }

    public void first_name(){
        driver.findElement(Firstname).sendKeys(Name);
    }

    public void last_name(){
        driver.findElement(Lastname).sendKeys(lastname);
    }

    public void pincode(){
        driver.findElement(pin).sendKeys(ZipCode);
    }

    public void click_continue(){
        driver.findElement(cont).click();
    }

    public void Finish(){
        driver.findElement(finish).click();
    }
    public void Msg(){
        String str = driver.findElement(thankYouMessage).getText();
        if (str.equals("THANK YOU FOR YOUR ORDER")){
            System.out.println("Output is verified");
        }else {
            System.out.println("Output is not verified");
        }
    }
}
