package Assignment5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    WebDriver driver;

    By cart=By.xpath("//a[@class='shopping_cart_link']");


    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }

    public  String gethighprice() throws InterruptedException {
        ArrayList<String> name=new ArrayList<>();
        List<WebElement> li;
        List<WebElement> pr;
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
        }
        return  name.get(j);
    }


    public String getlowerprice() throws InterruptedException {
        ArrayList<String> name=new ArrayList<>();
        List<WebElement> li;
        List<WebElement> pr;
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
        }
        return  name.get(j);
    }

    public void AddtoCart(String j){
        WebElement e1=driver.findElement(By.xpath("//button[@id='add-to-cart-"+j+"']"));
        e1.click();
    }

    public void remove(String  j){

        driver.findElement(By.xpath("//button[@id='remove-"+j+"']")).click();
    }

    public void click_Cart(){

        driver.findElement(cart).click();
    }

    public void remove_enabled(String j){
        {

            try{
                WebElement e1=driver.findElement(By.xpath("//button[@id='remove-"+j+"']"));
                e1.isEnabled();
                System.out.println("Remove is clickable");
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    public void addtocart_enabled(String j){
        {
            try{
                WebElement e1=driver.findElement(By.xpath("//button[@id='add-to-cart-"+j+"']"));
                e1.isEnabled();
                System.out.println("Add to cart is clickable");
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

}
