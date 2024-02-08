package firstscript;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.interactions.Actions;


import org.openqa.selenium.JavascriptExecutor;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Message;
import org.openqa.selenium.grid.data.Session;

public class Email {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\driver\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
       driver.get("https://kic-qa-rs.lgerobot.com/rome");
       
       
		 String parentHandle = driver.getWindowHandle();
		 System.out.print("parent window - "+ parentHandle);
	       
	       Thread.sleep(3000);
	       driver.findElement(By.xpath("//*[@id=\"id\"]")).sendKeys("rsdp2_qe_v3@yopmail.com");
	   	   driver.findElement(By.xpath("//*[@id=\"pwd\"]")).sendKeys("!Qaz2wsx");
	       Thread.sleep(1000);
	   	   driver.findElement(By.xpath("//*[@id=\"loginBtn\"]")).click();
	       Thread.sleep(5000);
	       
	    // Navigate to Yopmail and get the OTP from the email
	       driver.switchTo().newWindow(WindowType.TAB);
	         
	        // opening another url in the new tab
	        driver.get("https://yopmail.com");
   	   
	        Thread.sleep(3000);
			 
		       // Enter the Yopmail inbox
		       WebElement yopmailInbox = driver.findElement(By.id("login"));
		       yopmailInbox.sendKeys("rsdp2_qe_v3@yopmail.com");
		       Thread.sleep(2000);
		       yopmailInbox.sendKeys(Keys.ENTER);
		       
		    // Switch to the iframe
		       driver.switchTo().frame("ifmail");
		       Thread.sleep(3000);
		       

		       // Extract the OTP from the email content
		       WebElement otpElement = driver.findElement(By.xpath("/html/body/main/div/div/div/table/tbody/tr/td/table[1]/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td"));
		       String otp = otpElement.getText();
		      // String text = otpElement.getText();
		       System.out.println("Text: " + otp);
		       Thread.sleep(5000);
		       
		       
		       Set<String> handels = driver.getWindowHandles();
		      
			for(String handle : handels) {
		    	   System.out.print(handle);
		    	   if (!handle.equals(parentHandle)) {
		    		   driver.switchTo().window(handle);
		    		   
		    		   System.out.print("Pranav123");
		    		   Thread.sleep(3000);
		    		   driver.close();
		    	   }
		       }
			
			driver.switchTo().window(parentHandle);
			Thread.sleep(3000);
			
			 // Enter the OTP into the OTP field on the login page
		       WebElement otpField = driver.findElement(By.xpath("/html/body/div[10]/div/div/div[2]/ul/li/div[1]/div/input"));
		       otpField.sendKeys(otp)  ;                                                 
		       System.out.println("Page title is2 : " + driver.getTitle());
		                                                                
		       
		       WebElement otpSubmitButton = driver.findElement(By.xpath("//button[@id='verification_OTP_Btn2']"));
		       otpSubmitButton.click();
		       
   	          // Home screen displayed and now click on real time info
		       
		       driver.findElement(By.xpath("//button[@class='gnb_toggle_btn']")).click();
		       
		       // Click on robot operation data tab
		       
		       driver.findElement(By.xpath("//*[@id=\"gnb\"]/ul/li[2]/a/span")).click();
		       
		       
		       
	}

}
