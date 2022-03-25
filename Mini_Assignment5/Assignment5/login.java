package Assignment5;

import Assignment_4.ExcelData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;

public class login {
    WebDriver driver;
    By button = By.xpath("//input[@id='login-button']");
    By username = By.xpath("//input[@id='user-name']");
    By password = By.xpath("//input[@id='password']");
    String UN;
    String Pass;
    Assignment_4.ExcelData xls1;

    public void get_details(){
        try {
                xls1 = new ExcelData("C:\\Users\\naratreddy\\IdeaProjects\\Login.xlsx");
            }
        catch (IOException e) {
                e.printStackTrace();
            }
        UN = xls1.getData(0,1,0);
        Pass = xls1.getData(0,1,1);
    }




    public login(WebDriver driver) {

        this.driver = driver;
    }

    public void username() {
        WebElement e1 = driver.findElement(username);
        e1.sendKeys(UN);

    }

    public void setPassword() {
        WebElement e2 = driver.findElement(password);
        e2.sendKeys(Pass);
    }

    public void click() {
        WebElement e3 = driver.findElement(button);
        e3.click();
    }
}

