package Sanity_Testing_City;

import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPage {
	WebDriver driver;
	
	 private static String randomEmail() {
	        return "random-" + UUID.randomUUID().toString() + "@example.com";
	    }
	 
	@Test(priority=1)
	public void Register_With_ValidEmail_And_ValidPassword() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Open the Gilt website
		driver.get("https://www.qa.giltcity.jp/z/unlock");
		
		
		//Hover in navbar and Click in Register 
		Thread.sleep(2000);
		driver.findElement(By.className("gs-header-actions")).click();
		driver.findElement(By.linkText("会員登録")).click();
		
		//fill email & password
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        final String randomEmail = randomEmail();
		driver.findElement(By.id("input-email")).sendKeys(randomEmail);
		driver.findElement(By.id("input-password")).sendKeys("Raneen@123456");
		
		//Select BirthDate Option
		
		//Year
		WebElement BirthYear = driver.findElement(By.name("birth.year"));
		Select selectBirthYear = new Select(BirthYear);
		selectBirthYear.selectByVisibleText("2006");
		//Month
		WebElement BirthMonth = driver.findElement(By.name("birth.month"));
		Select selectBirthMonth = new Select(BirthMonth);
		selectBirthMonth.selectByVisibleText("1");
		//Day
		WebElement BirthDates = driver.findElement(By.name("birth.date"));
		Select selectBirthDate = new Select(BirthDates);
		selectBirthDate.selectByValue("number:1");
		
		//Choose Gender radio button
		WebElement Femail = driver.findElement(By.xpath("//span[text()='女性']"));
		Femail.click();
		
		//Click in button
		Thread.sleep(1000);
		WebElement Register_Button= driver.findElement(By.className("gs-item-body"));
		Register_Button.click();

	}
	
	
	
	@Test(priority=2)
	public void Register_With_ValidEmail_And_InvalidPassword() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Open the Gilt website
		driver.get("https://www.qa.giltcity.jp/z/unlock");
		
		
		//Hover in navbar and Click in Register 
		Thread.sleep(2000);
		driver.findElement(By.className("gs-header-actions")).click();
		driver.findElement(By.linkText("会員登録")).click();
		
		//fill email & password
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
       final String randomEmail = randomEmail();
		driver.findElement(By.id("input-email")).sendKeys(randomEmail);
		driver.findElement(By.id("input-password")).sendKeys("Ran@1");
		
		//Select BirthDate Option
		
		//Year
		WebElement BirthYear = driver.findElement(By.name("birth.year"));
		Select selectBirthYear = new Select(BirthYear);
		selectBirthYear.selectByVisibleText("2006");
		//Month
		WebElement BirthMonth = driver.findElement(By.name("birth.month"));
		Select selectBirthMonth = new Select(BirthMonth);
		selectBirthMonth.selectByVisibleText("1");
		//Day
		WebElement BirthDates = driver.findElement(By.name("birth.date"));
		Select selectBirthDate = new Select(BirthDates);
		selectBirthDate.selectByValue("number:1");
		
		//Choose Gender radio button
		WebElement Femail = driver.findElement(By.xpath("//span[text()='女性']"));
		Femail.click();
		
		//Click in button
		Thread.sleep(1000);
		WebElement Register_Button= driver.findElement(By.className("gs-item-body"));
		Register_Button.click();
		
		//Make Sure to displaying validation message
		Boolean ValidationMessage= driver.findElement(By.xpath("//li[text()='8 文字以上でご記入ください']")).isDisplayed();
       Assert.assertTrue(ValidationMessage);

	}
	
	
	@Test(priority=3)
	public void Register_With_InValidEmail_And_ValidPassword() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Open the Gilt website
		driver.get("https://www.qa.giltcity.jp/z/unlock");
		
		
		//Hover in navbar and Click in Register 
		Thread.sleep(2000);
		driver.findElement(By.className("gs-header-actions")).click();
		driver.findElement(By.linkText("会員登録")).click();
		
		//fill email & password
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
       final String randomEmail = randomEmail();
		driver.findElement(By.id("input-email")).sendKeys("Ran@yahoo.com");
		driver.findElement(By.id("input-password")).sendKeys("Ran@12345");
		
		//Select BirthDate Option
		
		//Year
		WebElement BirthYear = driver.findElement(By.name("birth.year"));
		Select selectBirthYear = new Select(BirthYear);
		selectBirthYear.selectByVisibleText("2006");
		//Month
		WebElement BirthMonth = driver.findElement(By.name("birth.month"));
		Select selectBirthMonth = new Select(BirthMonth);
		selectBirthMonth.selectByVisibleText("1");
		//Day
		WebElement BirthDates = driver.findElement(By.name("birth.date"));
		Select selectBirthDate = new Select(BirthDates);
		selectBirthDate.selectByValue("number:1");
		
		//Choose Gender radio button
		WebElement Femail = driver.findElement(By.xpath("//span[text()='女性']"));
		Femail.click();
		
		//Click in button
		Thread.sleep(1000);
		WebElement Register_Button= driver.findElement(By.className("gs-item-body"));
		Register_Button.click();
		
		//Make Sure to displaying the box 
		Thread.sleep(2000);
		Boolean ValidationMessage= driver.findElement(By.xpath("//div[text()='ran@yahoo.co.jpではありませんか？']")).isDisplayed();
       Assert.assertTrue(ValidationMessage);

	}
	
	
	
	@Test(priority=4)
	public void Register_With_InValidEmail_And_InValidPassword() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Open the Gilt website
		driver.get("https://www.qa.giltcity.jp/z/unlock");
		
		
		//Hover in navbar and Click in Register 
		Thread.sleep(2000);
		driver.findElement(By.className("gs-header-actions")).click();
		driver.findElement(By.linkText("会員登録")).click();
		
		
		//fill email & password
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
       final String randomEmail = randomEmail();
		driver.findElement(By.id("input-email")).sendKeys("Ran@yahoo.com");
		driver.findElement(By.id("input-password")).sendKeys("Ran@1");
		
		//Select BirthDate Option
		
		//Year
		WebElement BirthYear = driver.findElement(By.name("birth.year"));
		Select selectBirthYear = new Select(BirthYear);
		selectBirthYear.selectByVisibleText("2006");
		//Month
		WebElement BirthMonth = driver.findElement(By.name("birth.month"));
		Select selectBirthMonth = new Select(BirthMonth);
		selectBirthMonth.selectByVisibleText("1");
		//Day
		WebElement BirthDates = driver.findElement(By.name("birth.date"));
		Select selectBirthDate = new Select(BirthDates);
		selectBirthDate.selectByValue("number:1");
		
		//Choose Gender radio button
		WebElement Femail = driver.findElement(By.xpath("//span[text()='女性']"));
		Femail.click();
		
		//Click in button
		Thread.sleep(1000);
		WebElement Register_Button= driver.findElement(By.className("gs-item-body"));
		Register_Button.click();
		
		//Make Sure to displaying the box when email invalid
		Thread.sleep(2000);
		Boolean ValidationMessage= driver.findElement(By.xpath("//div[text()='ran@yahoo.co.jpではありませんか？']")).isDisplayed();
       Assert.assertTrue(ValidationMessage);
		
		//Make Sure to displaying validation message when password invalid
		Boolean ValidationMessage2= driver.findElement(By.xpath("//li[text()='8 文字以上でご記入ください']")).isDisplayed();
		Assert.assertTrue(ValidationMessage2);

	}
	
	@Test(priority=5)
	public void Register_With_Mail_Gender() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Open the Gilt website
		driver.get("https://www.qa.giltcity.jp/z/unlock");
		
		
		//Hover in navbar and Click in Register 
		Thread.sleep(2000);
		driver.findElement(By.className("gs-header-actions")).click();
		driver.findElement(By.linkText("会員登録")).click();
		
		//fill email & password
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
       final String randomEmail = randomEmail();
		driver.findElement(By.id("input-email")).sendKeys(randomEmail);
		driver.findElement(By.id("input-password")).sendKeys("Raneen@123456");
		
		//Select BirthDate Option
		
		//Year
		WebElement BirthYear = driver.findElement(By.name("birth.year"));
		Select selectBirthYear = new Select(BirthYear);
		selectBirthYear.selectByVisibleText("2006");
		//Month
		WebElement BirthMonth = driver.findElement(By.name("birth.month"));
		Select selectBirthMonth = new Select(BirthMonth);
		selectBirthMonth.selectByVisibleText("1");
		//Day
		WebElement BirthDates = driver.findElement(By.name("birth.date"));
		Select selectBirthDate = new Select(BirthDates);
		selectBirthDate.selectByValue("number:1");
		
		//Choose Gender radio button
		Thread.sleep(1000);
		WebElement Femail = driver.findElement(By.xpath("//span[text()='男性']"));
		Femail.click();
		
		//Click in button
		Thread.sleep(1000);
		WebElement Register_Button= driver.findElement(By.className("gs-item-body"));
		Register_Button.click();

	}
	
	
	@Test(priority=6)
	public void Register_With_Unspecefied_Gender() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Open the Gilt website
		driver.get("https://www.qa.giltcity.jp/z/unlock");
		
		
		//Hover in navbar and Click in Register 
		Thread.sleep(2000);
		driver.findElement(By.className("gs-header-actions")).click();
		driver.findElement(By.linkText("会員登録")).click();
		
		
		//fill email & password
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
       final String randomEmail = randomEmail();
		driver.findElement(By.id("input-email")).sendKeys(randomEmail);
		driver.findElement(By.id("input-password")).sendKeys("Raneen@123456");
		
		//Select BirthDate Option
		
		//Year
		WebElement BirthYear = driver.findElement(By.name("birth.year"));
		Select selectBirthYear = new Select(BirthYear);
		selectBirthYear.selectByVisibleText("2006");
		//Month
		WebElement BirthMonth = driver.findElement(By.name("birth.month"));
		Select selectBirthMonth = new Select(BirthMonth);
		selectBirthMonth.selectByVisibleText("1");
		//Day
		WebElement BirthDates = driver.findElement(By.name("birth.date"));
		Select selectBirthDate = new Select(BirthDates);
		selectBirthDate.selectByValue("number:1");
		
		//Choose Gender radio button
		Thread.sleep(1000);
		WebElement Femail = driver.findElement(By.xpath("//span[text()='指定しない']"));
		Femail.click();
		
		//Click in button
		Thread.sleep(1000);
		WebElement Register_Button= driver.findElement(By.className("gs-item-body"));
		Register_Button.click();

	}
	
	
	
	
	@Test(priority=7)
	public void Register_With_Existing_Email() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Open the Gilt website
		driver.get("https://www.qa.giltcity.jp/z/unlock");
		
		
		//Hover in navbar and Click in Register 
		Thread.sleep(2000);
		driver.findElement(By.className("gs-header-actions")).click();
		driver.findElement(By.linkText("会員登録")).click();
		
		
		//fill email & password
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
       final String randomEmail = randomEmail();
		driver.findElement(By.id("input-email")).sendKeys("rmaqbul@Labellevie.jp");
		driver.findElement(By.id("input-password")).sendKeys("Raneen@123456");
		
		//Select BirthDate Option
		
		//Year
		WebElement BirthYear = driver.findElement(By.name("birth.year"));
		Select selectBirthYear = new Select(BirthYear);
		selectBirthYear.selectByVisibleText("2006");
		//Month
		WebElement BirthMonth = driver.findElement(By.name("birth.month"));
		Select selectBirthMonth = new Select(BirthMonth);
		selectBirthMonth.selectByVisibleText("1");
		//Day
		WebElement BirthDates = driver.findElement(By.name("birth.date"));
		Select selectBirthDate = new Select(BirthDates);
		selectBirthDate.selectByValue("number:1");
		
		//Choose Gender radio button
		WebElement Femail = driver.findElement(By.xpath("//span[text()='女性']"));
		Femail.click();
		
		//Click in button
		Thread.sleep(2000);
		WebElement Register_Button= driver.findElement(By.className("gs-item-body"));
		Register_Button.click();
		
		//Make Sure to displaying the box when registered with existing email
		Thread.sleep(2000);
		Boolean ValidationMessage= driver.findElement(By.xpath("//div[text()='このメールアドレスは既に登録済みです。ログインする場合にはこちらより行って下さい。']")).isDisplayed();
       Assert.assertTrue(ValidationMessage);

	}
}
