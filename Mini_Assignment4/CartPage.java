package Assignment_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    By continue_shopping=By.xpath("//button[@id='continue-shopping']");
    WebDriver driver;
    public CartPage(WebDriver driver){
        this.driver=driver;
    }


    public void click_continue_to_shopping(){
        driver.findElement(continue_shopping).click();

    }
}
