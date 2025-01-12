package Sanity_Testing_City;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BuyCity {
	WebDriver driver;
	@Test(priority=1)
	public void BuyFromCity() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Open the Gilt website
		driver.get("https://www.qa.giltcity.jp/z/unlock");
		
		
		//Hover in navbar and Click in Login 
		Thread.sleep(2000);
        driver.findElement(By.className("gs-header-actions")).click();
        driver.findElement(By.linkText("ログイン")).click();
		
		//Fill email and password
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email")));
		driver.findElement(By.id("input-email")).sendKeys("rmaqbul@labellevie.jp");
		driver.findElement(By.id("input-password")).sendKeys("Raneen@123456");
		//Click in the Login button
		WebElement button = driver.findElement(By.className("gs-item-body"));
		Actions action = new Actions(driver);
		action.click(button).build().perform();
     
        //click in offer
      		Thread.sleep(2000);
      		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(20));
    		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.className("gs-offer-image")));
      		List  <WebElement> allOffers = driver.findElements(By.className("gs-offer-image"));
      		Actions action3 = new Actions(driver);
      		action3.click(allOffers.get(5)).build().perform();
      	//click in Package
      		Thread.sleep(2000);
      		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(20));
    		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".gs-item ")));
      		List  <WebElement> allpackages = driver.findElements(By.cssSelector(".gs-item "));
      		Actions action4 = new Actions(driver);
      		action4.click(allpackages.get(0)).build().perform();
      	
      	//Click in text options
	        Thread.sleep(2000);
	        boolean textoption = driver.findElements(By.cssSelector(".gs-form-select-opt")).size() != 0;
            if(textoption==true) {
	        WebElement TextOptionsSelect = driver.findElement(By.name("package_option"));
			Select selectTextOptions = new Select(TextOptionsSelect);
			selectTextOptions.selectByIndex(1);
            System.out.print("text option list displayed");
            
            }
		//Click in Quantity options
	        Thread.sleep(2000);
	        boolean QuantityOptions = driver.findElements(By.name("quantity")).size() != 0;
            if(QuantityOptions==true) {
			WebElement QuantityOptionsElement = driver.findElement(By.name("quantity"));
			Select selectQuantityOptions = new Select(QuantityOptionsElement);
			selectQuantityOptions.selectByIndex(0);
            }
		//Click in Proceed to checkout
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//span[text()='購入手続きへ']")).click();
	    //Scroll down to checkbox 
			Thread.sleep(2000);
	        boolean CheckboxSelective = driver.findElements(By.id("confirmation-restriction-check")).size() != 0;
	        if(CheckboxSelective==true) {
			WebElement scrollDownToCheckbox = driver.findElement(By.id("confirmation-restriction-check"));
			JavascriptExecutor javascc = (JavascriptExecutor) driver;
			javascc.executeScript("arguments[0].scrollIntoView(true)", scrollDownToCheckbox);
	        }
	        //Click in checkbox
	        Thread.sleep(2000);
	        driver.findElement(By.id("confirmation-restriction-check")).click();
	       
	        //Click in the link 
	        Thread.sleep(2000);
	        boolean existsLink = driver.findElements(By.xpath("//a[text()='送り主を指定してください。']")).size() != 0;
	        if(existsLink==true) {
	        	System.out.println("Sender name displayed");

		        Thread.sleep(2000);
	        	driver.findElement(By.xpath("//a[text()='送り主を指定してください。']")).click();
		        Thread.sleep(2000);
	        	driver.findElement(By.id("greetingSender")).sendKeys("Raneen Mabul");
	        	driver.findElement(By.xpath("//span[text()='保 存']")).click();
	        }
	      //Scroll down to button 
			Thread.sleep(2000);
			WebElement scrollDownToButtonSend = driver.findElement(By.xpath("//button[text()='注文を確定']"));
			JavascriptExecutor javascc = (JavascriptExecutor) driver;
			javascc.executeScript("arguments[0].scrollIntoView(true)", scrollDownToButtonSend);
	        
	        //Click in complete order button
	            Thread.sleep(2000);
		        driver.findElement(By.xpath("//button[text()='注文を確定']")).click();

	}
	        }

	

