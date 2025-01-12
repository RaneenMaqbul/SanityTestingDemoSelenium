package Sanity_Testing_City;

import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Send_Invitation_City {

/*Register Process*/
	
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
		
/*Send Invitation process*/
		
		//Hover in navbar and Click in account 
				Thread.sleep(5000);
				driver.findElement(By.className("gs-header-actions")).click();
				Thread.sleep(2000);
				driver.findElement(By.linkText("マイページ")).click();
		//Click in Invitation Link
				Thread.sleep(5000);
				driver.findElement(By.linkText("お友達を招待")).click();
        //Scroll down to the invitation box
				Thread.sleep(3000);
				WebElement InvitationBox = driver.findElement(By.xpath("//span[text()='こちらのご招待リンクをコピーし、ブログやメールに貼ってお友達をご招待いただけます。']"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true)", InvitationBox);
				Thread.sleep(2000);
				driver.findElement(By.id("invite-email")).sendKeys("rmaqbul@labellevie.jp");
				driver.findElement(By.xpath("//button[text()='招待状を送信']")).click();
				Thread.sleep(2000);
        //Make sure that validation message displayed
				Boolean ValidationMessage= driver.findElement(By.xpath("//span[text()='ご招待いただいたお友達の初回注文が出荷されると、2,000円分の商品券があなたにプレゼントされます。']")).isDisplayed();
		        Assert.assertTrue(ValidationMessage);

				
	}
	
		

}
