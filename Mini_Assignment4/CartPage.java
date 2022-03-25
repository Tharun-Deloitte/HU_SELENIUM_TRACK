package Assignment_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class CartPage {

    By continue_shopping=By.xpath("//button[@id='continue-shopping']");
    WebDriver driver;
    By checkout=By.xpath("//button[@id='checkout']");
    By Firstname=By.xpath("//input[@id='first-name']");
    By Lastname=By.xpath("//input[@id='last-name']");
    By pin=By.xpath("//input[@id='postal-code']");
    By cont=By.xpath("//button[@id='continue']");
    By finish=By.xpath("//button[@id='finish']");
    By thankYouMessage = By.xpath("//*[@id='checkout_complete_container']/h2");
    ExcelData xls1;
    {
        try {
            xls1 = new ExcelData("C:\\Users\\naratreddy\\IdeaProjects\\Login.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    String FirstName = xls1.getData(1,0,0);
    String LastName = xls1.getData(1,1,0);
    String ZipCode = xls1.getData(1,2,0);

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
        driver.findElement(Firstname).sendKeys(FirstName);
    }

    public void last_name(){
        driver.findElement(Lastname).sendKeys(LastName);
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
