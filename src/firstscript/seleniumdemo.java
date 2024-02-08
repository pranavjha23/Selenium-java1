package firstscript;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumdemo {

	public static void main(String[] args) throws InterruptedException {
	
				
		System.setProperty("webdriver.chrome.driver", "E:\\driver\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
	   
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
       
        // Launch the browser and open a website with multiple tabs
		 driver.get("");
		 

	   	  WebElement text =driver.findElement(By.xpath("//span[normalize-space()='No registered robot.']"));
	         String expectedtext ="[No registered robot.]";
	         String actualtext =text.getText();
	         System.out.print(actualtext);
	         
	         assertEquals(actualtext,expectedtext, "Robot register = ");
	         
	         System.out.print("completed");
		 
	}
		
	}


