package Sanity_Testing_Stores;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToWaitListStores {
	WebDriver driver;
	@Test(priority=1)
	public void Buy_CC_Stores() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Open the Gilt website
		driver.get("https://www.qa.gilt.jp/z/unlock");
		
		
		//Close PopUp
		WebElement PopUP=driver.findElement(By.className("gs-modal-body"));
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("gs-modal-body")));
		PopUP.click();
		
		//Click in Login
		Thread.sleep(2000);
		driver.findElement(By.linkText("ログイン")).click();
		
		//Fill email and password
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email")));
		driver.findElement(By.id("input-email")).sendKeys("rmaqbul@labellevie.jp");
		driver.findElement(By.id("input-password")).sendKeys("Raneen@123456");
		
		//Click in the Login button
		WebElement button = driver.findElement(By.className("gs-item-body"));
		Actions action = new Actions(driver);
		action.click(button).build().perform();
		
		//Make Sure that you are in Login Page by get the title of page
		String actualURL= driver.getTitle();
		String ExpectedURL= "ギルト";
	    Assert.assertEquals(actualURL, ExpectedURL);
	    
	  
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
			  Thread.sleep(2000);
				boolean Soldout = driver.findElements(By.xpath("//span[text()='売り切れ']")).size()!=0;
				if(Soldout==false) {

			  driver.close();
			//switch back to main window
				driver.switchTo().window(mainWindowHandle);
				}
			  }
			} 
			
			
			
			
		boolean Soldout = driver.findElements(By.xpath("//span[text()='売り切れ']")).size()!=0;
		if(Soldout==true) {
  		//Scroll down to solid out
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='売り切れ']")));
		WebElement SoldOutSectionscrollDown = driver.findElement(By.xpath("//span[text()='売り切れ']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", SoldOutSectionscrollDown);

		//Click in soldout Element 
		Thread.sleep(2000);
		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"look-143454851\"]/div[1]/div[2]/div")));
		Actions action4 = new Actions(driver);
		action4.click(driver.findElement(By.xpath("//*[@id=\"look-143454851\"]/div[1]/div[2]/div"))).build().perform();
		
		//click in size
		Thread.sleep(4000);
		boolean size= driver.findElements(By.cssSelector(".soldout")).size()!=0;
		if(size==true) {
		Actions action66 = new Actions(driver);
		action66.click(driver.findElement(By.cssSelector(".soldout"))).build().perform();
		}
		
		//click in add to waitlist
		Thread.sleep(2000);
		WebDriverWait wait9 = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='ウェイトリストに追加']")));
		driver.findElement(By.xpath("//button[text()='ウェイトリストに追加']")).click();
		//Make Sure that you add the item to waitlist
				Thread.sleep(2000);
		        Boolean result=driver.findElement(By.xpath("//span[text()='商品はお客様のウェイトリストに追加されました。']")).isDisplayed();
		        Assert.assertTrue(result);
		break;
		}
		}
		
	
	
	}}








