package Sanity_Testing_Stores;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage {
	WebDriver driver;
	@Test(priority=1)
	public void login_With_Valid_Email_And_Password() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Open the Gilt website
		driver.get("https://www.qa.gilt.jp/z/unlock");
		
		
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
		
		//Make Sure that you are in Login Page by get the title of page
		String actualURL= driver.getTitle();
		String ExpectedURL= "ギルト";
	    Assert.assertEquals(actualURL, ExpectedURL);
	    
		//Make Sure that you are in Login Page by verify the displaying of email
		Thread.sleep(2000);
        driver.findElement(By.className("gs-header-actions")).click();
        Boolean result=driver.findElement(By.xpath("//div[text()='rmaqbul@labellevie.jp']")).isDisplayed();
        Assert.assertTrue(result);

	}
	
	
	@Test(priority=2)
	public void login_With_InValid_Email_And_Valid_Password() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Open the Gilt website
		driver.get("https://www.qa.gilt.jp/z/unlock");
		
		
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
		driver.findElement(By.id("input-email")).sendKeys("rmaqool@labellevie.jp");
		driver.findElement(By.id("input-password")).sendKeys("Raneen@123456");
		
		//Click in the Login button
		WebElement button = driver.findElement(By.className("gs-item-body"));
		Actions action = new Actions(driver);
		action.click(button).build().perform();
	    
		//Make Sure that validation Message displayed
		Thread.sleep(2000);
        Boolean result=driver.findElement(By.xpath("//div[text()='ログインに失敗しました。メールアドレスとパスワードをご確認ください。']")).isDisplayed();
        Assert.assertTrue(result);

	}
	
	
	
	@Test(priority=3)
	public void login_With_Valid_Email_And_InValid_Password() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Open the Gilt website
		driver.get("https://www.qa.gilt.jp/z/unlock");
		
		
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
		driver.findElement(By.id("input-password")).sendKeys("Raneen@1234567");
		
		//Click in the Login button
		WebElement button = driver.findElement(By.className("gs-item-body"));
		Actions action = new Actions(driver);
		action.click(button).build().perform();
	    
		//Make Sure that validation Message displayed
		Thread.sleep(2000);
        Boolean result=driver.findElement(By.xpath("//div[text()='ログインに失敗しました。メールアドレスとパスワードをご確認ください。']")).isDisplayed();
        Assert.assertTrue(result);

	}
	
	@Test(priority=4)
	public void login_With_InValid_Email_And_InValid_Password() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Open the Gilt website
		driver.get("https://www.qa.gilt.jp/z/unlock");
		
		
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
		driver.findElement(By.id("input-email")).sendKeys("rmaqbull@labellevie.jp");
		driver.findElement(By.id("input-password")).sendKeys("Raneen@1234567");
		
		//Click in the Login button
		WebElement button = driver.findElement(By.className("gs-item-body"));
		Actions action = new Actions(driver);
		action.click(button).build().perform();
	    
		//Make Sure that validation Message displayed
		Thread.sleep(2000);
        Boolean result=driver.findElement(By.xpath("//div[text()='ログインに失敗しました。メールアドレスとパスワードをご確認ください。']")).isDisplayed();
        Assert.assertTrue(result);

	}
	@Test(priority=5)
	public void ISRegisteredLinkWorked() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Open the Gilt website
		driver.get("https://www.qa.gilt.jp/z/unlock");
		
		
		//Close PopUp
		WebElement PopUP=driver.findElement(By.className("gs-modal-body"));
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("gs-modal-body")));
		PopUP.click();
		
		//Click in Login
		 Thread.sleep(2000);
		 driver.findElement(By.linkText("ログイン")).click();
		 
		//Click in Register Link
		 
		 Thread.sleep(2000);
		 driver.findElement(By.linkText("無料会員登録")).click();
		 String ActualResult = driver.getCurrentUrl();
		 String ExpectedResult= "https://www.qa.gilt.jp/register?from=ad_popup_new-202309&return_url=%2F";
		 Assert.assertEquals(ActualResult, ExpectedResult);

		
	}



}
