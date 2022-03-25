package Assignment_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class HomePage {
    WebDriver driver;

    By cart=By.xpath("//a[@class='shopping_cart_link']");
    static ArrayList<String> name=new ArrayList<>();


    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }

    public  int gethighprice() throws InterruptedException {
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
        return  j;
    }


    public int getlowerprice() throws InterruptedException {
        List<WebElement> pr;
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
                e1.isEnabled();
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
                e1.isEnabled();
                System.out.println("Add to cart is clickable");
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

}
