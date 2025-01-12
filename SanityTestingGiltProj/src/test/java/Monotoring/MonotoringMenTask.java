package Monotoring;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MonotoringMenTask {
	WebDriver driver;
	@Test(priority=1)
	public void login_With_Valid_Email_And_Password() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Open the Gilt website
		driver.get("https://www.gilt.jp/z/unlock");
		
		
		//Close PopUp
		WebElement PopUP=driver.findElement(By.className("gs-modal-body"));
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("gs-modal-body")));
		PopUP.click();
		
		//Click in Login
		Thread.sleep(2000);
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
	
        //Click in men store
		Thread.sleep(2000);
		WebDriverWait wait112 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait112.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div[1]/div/div/div/div[2]/div[1]/div/div[1]/h2[2]/a")));
		Actions action222 = new Actions(driver);
		action222.click(driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div/div/div/div[2]/div[1]/div/div[1]/h2[2]/a"))).build().perform();
		
		
		 //Click in sale and open it in new tab
		Thread.sleep(3000);
		List  <WebElement> allSales = driver.findElements(By.className("gs-lazy-image-container"));
		
		for (int i = 0; i <= allSales.size(); i++) {
		
		Thread.sleep(2000);
		WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait7.until(ExpectedConditions.elementToBeClickable(By.className("gs-lazy-image-container")));
		Thread.sleep(2000);
		
		WebElement e1= driver.findElement(By.className("gs-lazy-image-container"));
		Actions action1 = new Actions(driver);
		action1.keyDown(Keys.LEFT_CONTROL).click(allSales.get(i)).keyUp(Keys.LEFT_CONTROL).build().perform();
		
		// switch focus from 1st tab to 2nd tab 
		

		//Get the main window handle
		String mainWindowHandle = driver.getWindowHandle();
		for (String childWindowHandle : driver.getWindowHandles()) {
			  //If window handle is not main window handle then close it 
			  if(!childWindowHandle.equals(mainWindowHandle)){
			  driver.switchTo().window(childWindowHandle);
			  // Close child windows
			  Thread.sleep(4000);
			  boolean filterBar= driver.findElements(By.className("gs-lazy-image-container")).size()!=0;
	          boolean InvitePage= driver.findElements(By.linkText("お友達を招待")).size()!=0;
				if(filterBar==false & InvitePage==false) {
					//System.out.println("Products not founds");
					//System.out.println(driver.getCurrentUrl());
			  
				}
				else if(filterBar==true || InvitePage==true ){
				     driver.close();

				}
				//switch back to main window
				driver.switchTo().window(mainWindowHandle);
			  }
			  }
			} 
			
	
	
	
	
	}}
			
			
			
			
			
			
			
			
			
			
			
			

