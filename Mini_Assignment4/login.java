package Assignment_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class login {
    WebDriver driver;
    By button = By.xpath("//input[@id='login-button']");
    By username = By.xpath("//input[@id='user-name']");
    By password = By.xpath("//input[@id='password']");



    public login(WebDriver driver) {

        this.driver = driver;
    }

    public void username() {
        WebElement e1 = driver.findElement(username);
        e1.sendKeys("standard_user");

    }

    public void setPassword() {
        WebElement e2 = driver.findElement(password);
        e2.sendKeys("secret_sauce");
    }

    public void click() {
        WebElement e3 = driver.findElement(button);
        e3.click();
    }
}

