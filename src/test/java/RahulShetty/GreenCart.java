package RahulShetty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GreenCart {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        String [] vegcol = new String[5];
        vegcol[0] = "Cucumber - 1 Kg";
        vegcol[1] = "Tomato - 1 Kg";
        vegcol[2] = "Capsicum";
        vegcol[3] = "Potato - 1 Kg";
        vegcol[4] = "Corn - 1 Kg";

       // String vegName = "Brinjal - 1 Kg";
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        Thread.sleep(2000);

        // Grt Product Names
        List<WebElement> productsName = driver.findElements(By.xpath("//h4[@class='product-name']"));
        for (int j=0;j<= vegcol.length;j++)
        {
        for (int i = 0; i < productsName.size(); i++) {
            String name = productsName.get(i).getText();
            System.out.println(i + ". " + name);
            if (name.contains(vegcol[j])) {
                System.out.println(i + " in if");
                int n = i + 1;
                System.out.println(driver.findElements(By.xpath("(//div[@class='product-action'])[" + n + "]")));
                driver.findElement(By.xpath("(//div[@class='product-action'])[" + n + "]")).click();
                // driver.findElement(By.xpath("(//div[@class='product-action'])'"+[i]+''").click();
                //driver.findElements(By.xpath("//button[@type='button']")).get(i + 1).click();

            }
            }

        }


    }
}
