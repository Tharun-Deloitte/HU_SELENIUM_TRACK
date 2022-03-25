package Assignment_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    WebDriver driver;
    List<WebElement> li;
    List<WebElement> pr;
    ArrayList<String> name=new ArrayList<>();
    By cart=By.xpath("//a[@class='shopping_cart_link']");



    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }

    public  int gethighprice() throws InterruptedException {
        li = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        for (WebElement webElement : li) {
            String str = webElement.getText();
            name.add(str.replace(" ", "-").toLowerCase());
        }
        pr = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        Thread.sleep(3000);
        float check=0;
        int j = 0;
        for (int i = 0; i < pr.size(); i++) {
            String str1 = pr.get(i).getText().replace("$","");
            float price= Float.parseFloat(str1);
            if(check<price){
                check=price;
                j=i;
            }
            System.out.println(check);
        }
        return  j;
    }


    public int getlowerprice() throws InterruptedException {
        List<WebElement> li;
        List<WebElement> pr;
        ArrayList<String> name=new ArrayList<>();
        li = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        for (WebElement webElement : li) {
            String str = webElement.getText();
            name.add(str.replace(" ", "-").toLowerCase());
        }
        pr = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        Thread.sleep(3000);
        float check=100;
        int j = 0;
        for (int i = 0; i < pr.size(); i++) {
            String str1 = pr.get(i).getText().replace("$","");
            float price= Float.parseFloat(str1);
            if(check>price){
                check=price;
                j=i;
            }
            System.out.println(check);
        }
        return  j;
    }

    public void AddtoCart(int j){
        WebElement e1=driver.findElement(By.xpath("//button[@id='add-to-cart-"+name.get(j)+"']"));
        e1.click();
    }

    public void remove(int j){

        driver.findElement(By.xpath("//button[@id='remove-"+name.get(j)+"']")).click();
    }

    public void click_Cart(){

        driver.findElement(cart).click();
    }

    public void remove_enabled(int j){
        {
            try{
                WebElement e1=driver.findElement(By.xpath("//button[@id='remove-"+name.get(j)+"']"));
                WebDriverWait wait = new WebDriverWait(driver, 6);
                wait.until(ExpectedConditions.elementToBeClickable(e1));
                System.out.println("Remove is clickable");
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    public void addtocart_enabled(int j){
        {
            try{
                WebElement e1=driver.findElement(By.xpath("//button[@id='add-to-cart-"+name.get(j)+"']"));
                WebDriverWait wait = new WebDriverWait(driver, 6);
                wait.until(ExpectedConditions.elementToBeClickable(e1));
                System.out.println("Add to cart is clickable");
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

}
