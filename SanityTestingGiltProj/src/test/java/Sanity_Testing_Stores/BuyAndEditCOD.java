package Sanity_Testing_Stores;

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

public class BuyAndEditCOD {
	
	WebDriver driver;
	@Test(priority=1)
	public void Buy_COD_Stores() throws InterruptedException {
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
	    
	  
        //Click in sale
		Thread.sleep(3000);
		List  <WebElement> allSales = driver.findElements(By.className("gs-lazy-image-container"));
		Actions action1 = new Actions(driver);
		action1.click(allSales.get(5)).build().perform();
		
  		
  		
		//Click in product
				Thread.sleep(3000);
				List  <WebElement> allProducts = driver.findElements(By.className("gs-lazy-image-container"));
				Actions action111 = new Actions(driver);
				action111.click(allProducts.get(5)).build().perform(); 
	
		
		//click in size
		Thread.sleep(2000);
        boolean Size = driver.findElements(By.cssSelector(".swatch-size")).size() != 0;
		if (Size==true) {
		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".swatch-size")));
		Thread.sleep(2000);
		WebElement industries = 
				driver.findElement(By.cssSelector(".swatch-size"));
				List<WebElement> links = industries.findElements(By.tagName("li"));
				for (int i = 0; i <= links.size(); i++)
				{
				    System.out.println(links.get(i).getText());
				     
				    System.out.println(links.get(i).getAttribute("class"));
				    System.out.println(links.size());

				    if (links.get(i).getAttribute("class").equals("gs-swatch-unit soldout")) {
				    	continue;
				    }
				    else if(links.get(i).getAttribute("class")!=("gs-swatch-unit soldout")) {
				    Actions action4 = new Actions(driver);
					action4.click(links.get(i)).build().perform();  
				    break;
				    }
				}

		}
		

		//click in Add to cart 
		Thread.sleep(2000);
        boolean AddTocart = driver.findElements(By.xpath("//button[text()='マイバッグに入れる']")).size() != 0;
		if(AddTocart==true) {

		WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='マイバッグに入れる']")));
		driver.findElement(By.xpath("//button[text()='マイバッグに入れる']")).click();
		}
		//click in Proceed to checkout
		Thread.sleep(2000);
		boolean ProccedToCheckout= driver.findElements(By.xpath("//span[text()='レジに進む']")).size() != 0;
		if(ProccedToCheckout==true) {
		WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='レジに進む']")));
		driver.findElement(By.xpath("//span[text()='レジに進む']")).click();
		}
		//Scroll down to payment method
  		Thread.sleep(2000);
  		Boolean PaymentMethodSectionDisplayed= driver.findElements(By.xpath("//h4[text()='お支払い方法']")).size() != 0;
  		if(PaymentMethodSectionDisplayed==true) {
  		WebElement PaymentSectionscrollDown = driver.findElement(By.xpath("//h4[text()='お支払い方法']"));
  		JavascriptExecutor jsss = (JavascriptExecutor) driver;
  		jsss.executeScript("arguments[0].scrollIntoView(true)", PaymentSectionscrollDown);
  		}
  		
  		//click in Payment method 
  		Thread.sleep(2000);
  		Boolean PaymentMethodSection= driver.findElements(By.xpath("//h4[text()='お支払い方法']")).size() != 0;
  		if(PaymentMethodSection==true) {
  		WebDriverWait waitnew1 = new WebDriverWait(driver, Duration.ofSeconds(40));
  		waitnew1.until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[text()='お支払い方法']")));
  		driver.findElement(By.xpath("//h4[text()='お支払い方法']")).click();
  		
  		}
  		
  		//Scroll down to COD section
  				Thread.sleep(2000);
  				Boolean CODSectionDisplayed= driver.findElements(By.xpath("//div[text()='代金引換払い']")).size() != 0;
  				if(CODSectionDisplayed==true) {
  				WebElement CODSectionscrollDown = driver.findElement(By.xpath("//div[text()='代金引換払い']"));
  				JavascriptExecutor jssss = (JavascriptExecutor) driver;
  				jssss.executeScript("arguments[0].scrollIntoView(true)", CODSectionscrollDown);
  				}
  				
  		//click in COD  
  				Thread.sleep(2000);
  				Boolean CODSection= driver.findElements(By.xpath("//div[text()='代金引換払い']")).size() != 0;
  				if(CODSection==true) {
  				WebDriverWait wait19 = new WebDriverWait(driver, Duration.ofSeconds(40));
  				wait19.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='代金引換払い']")));
  				driver.findElement(By.xpath("//div[text()='代金引換払い']")).click();
  				Thread.sleep(2000);
  				driver.findElement(By.xpath("//span[text()='次に進む']")).click();

  				}
  				else if(CODSection==false) {
  					WebDriverWait wait20 = new WebDriverWait(driver, Duration.ofSeconds(40));
  					wait20.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Visa']")));
  					driver.findElement(By.xpath("//div[text()='Visa']")).click();
  					Thread.sleep(2000);
  					driver.findElement(By.xpath("//span[text()='Visa']")).click();	
  				}
    
    
    
		//Scroll down to sender name section
		Thread.sleep(2000);
		boolean senderSectionDisplayed= driver.findElements(By.xpath("//h4[text()='ギフト設定']")).size() != 0;
		if(senderSectionDisplayed==true) {
		WebElement SenderSectionscrollDown = driver.findElement(By.xpath("//h4[text()='ギフト設定']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", SenderSectionscrollDown);
		}
		//click in Sender Name 
				Thread.sleep(2000);
				Boolean SenderSection= driver.findElements(By.xpath("//h4[text()='ギフト設定']")).size() != 0;
				if(SenderSection==true) {
				WebDriverWait wait9 = new WebDriverWait(driver, Duration.ofSeconds(40));
				wait9.until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[text()='ギフト設定']")));
				driver.findElement(By.xpath("//h4[text()='ギフト設定']")).click();
				
				}
	   // Fill sender name
		        Thread.sleep(2000);
		        boolean Sendername= driver.findElements(By.id("greetingSender")).size() != 0;
				if(Sendername==true) {
				WebDriverWait wait10 = new WebDriverWait(driver, Duration.ofSeconds(40));
				wait10.until(ExpectedConditions.elementToBeClickable(By.id("greetingSender")));
				driver.findElement(By.id("greetingSender")).sendKeys("Raneen Maqbul");
				
				}
				
		
		//select the Gift wrapping
				Thread.sleep(2000);
		        boolean GiftWrapping= driver.findElements(By.xpath("//select[@ng-model='unit.gift_wrap.value']")).size() != 0;
		        if(GiftWrapping==true) {
				WebElement GiftWrap = driver.findElement(By.xpath("//select[@ng-model='unit.gift_wrap.value']"));
				Select selectGiftwrap = new Select(GiftWrap);
				selectGiftwrap.selectByIndex(1);
		        }
	  //Scroll down to button Keep 
				Thread.sleep(3000);
		        boolean buttonKeep= driver.findElements(By.cssSelector(".primary")).size() != 0;
		        if(buttonKeep==true) {
				WebElement scrollDownToButtonKeep = driver.findElement(By.cssSelector(".primary"));
				JavascriptExecutor javasc = (JavascriptExecutor) driver;
				javasc.executeScript("arguments[0].scrollIntoView(true)", scrollDownToButtonKeep);
				Thread.sleep(2000);
		        }
	  // click in button send
		        
				 Thread.sleep(2000);
				 boolean buttonSend = driver.findElements(By.cssSelector(".primary")).size() != 0;
				 if(buttonSend==true) {
				 WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(50));
				 wait11.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".primary")));
				 Actions action4 = new Actions(driver);
			    action4.click(driver.findElement(By.cssSelector(".primary"))).build().perform(); 
		}	     
	 //Scroll down to Delivery date section
				Thread.sleep(5000);
				Boolean DeliveryDateSection= driver.findElements(By.xpath("//span[text()='配達日時']")).size() != 0;
				if(DeliveryDateSection==true) {
				WebElement DeliveryDateSectionscrollDown = driver.findElement(By.xpath("//span[text()='配達日時']"));
				JavascriptExecutor jas = (JavascriptExecutor) driver;
				jas.executeScript("arguments[0].scrollIntoView(true)", DeliveryDateSectionscrollDown);
				Thread.sleep(2000);   
				}
				
				
   //click in delivery date section
				Thread.sleep(1000);
				Boolean DeliveryDate= driver.findElements(By.xpath("//span[text()='配達日時']")).size() != 0;
				if(DeliveryDate==true) {
				Thread.sleep(2000);
				WebDriverWait wait12 = new WebDriverWait(driver, Duration.ofSeconds(40));
				wait12.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='配達日時']")));
				driver.findElement(By.xpath("//span[text()='配達日時']")).click();
				}
				
				
	//select the date
				Thread.sleep(1000);
				Boolean SelectDate= driver.findElements(By.xpath("//select[@ng-model='selection.date']")).size() != 0;
				if(SelectDate==true) {
				Thread.sleep(2000);
				WebElement DateSelection = driver.findElement(By.xpath("//select[@ng-model='selection.date']"));
				Select selectTheDate = new Select(DateSelection);
				selectTheDate.selectByIndex(2);
				}
	//select the time	
				Thread.sleep(1000);
				Boolean SelectTime= driver.findElements(By.xpath("//select[@ng-model='selection.time_range']")).size() != 0;
				if(SelectTime==true) {
				Thread.sleep(5000);
				WebElement CountryName2 = driver.findElement(By.xpath("//select[@ng-model='selection.time_range']"));
				Select selectCountryName2 = new Select(CountryName2);
				selectCountryName2.selectByIndex(2);	
				Thread.sleep(2000);
				Actions action5 = new Actions(driver);
			    action5.click(driver.findElement(By.cssSelector(".primary"))).build().perform(); 
				
				}
	//Click in proceed checkout
	Thread.sleep(2000);
	Actions action6 = new Actions(driver);
    action6.click(driver.findElement(By.xpath("//button[text()='注文を確定']"))).build().perform();
  
  
    //Click in Edit button order
    Thread.sleep(2000);
	Actions action7 = new Actions(driver);
    action7.click(driver.findElement(By.xpath("//button[text()='注文変更']"))).build().perform();
    Thread.sleep(2000);
    
    
    
    
    
    
    
    
    /*Edit process for the Gift ceftificate */
  //Scroll down to sender name section
  		Thread.sleep(2000);
  		boolean senderSectionDisplayed2= driver.findElements(By.xpath("//h4[text()='ギフト設定']")).size() != 0;
  		if(senderSectionDisplayed2==true) {
  		WebElement SenderSectionscrollDown2 = driver.findElement(By.xpath("//h4[text()='ギフト設定']"));
  		JavascriptExecutor js2 = (JavascriptExecutor) driver;
  		js2.executeScript("arguments[0].scrollIntoView(true)", SenderSectionscrollDown2);
  		}
  	//click in Sender Name 
		Thread.sleep(2000);
		Boolean SenderSection2= driver.findElements(By.xpath("//h4[text()='ギフト設定']")).size() != 0;
		if(SenderSection2==true) {
		WebDriverWait wait17 = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait17.until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[text()='ギフト設定']")));
		driver.findElement(By.xpath("//h4[text()='ギフト設定']")).click();
		
		// Fill sender name
        Thread.sleep(2000);
        boolean Sendername2= driver.findElements(By.id("greetingSender")).size() != 0;
		if(Sendername2==true) {
		WebDriverWait wait23 = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait23.until(ExpectedConditions.elementToBeClickable(By.id("greetingSender")));
		driver.findElement(By.id("greetingSender")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("greetingSender")).sendKeys("Raneen Forsan");
		
		}
		

//select the Gift wrapping
		Thread.sleep(2000);
        boolean GiftWrapping2= driver.findElements(By.xpath("//select[@ng-model='unit.gift_wrap.value']")).size() != 0;
        if(GiftWrapping2==true) {
		WebElement GiftWrap2 = driver.findElement(By.xpath("//select[@ng-model='unit.gift_wrap.value']"));
		Select selectGiftwrap2 = new Select(GiftWrap2);
		selectGiftwrap2.selectByIndex(2);
        }
//Scroll down to button Keep 
		Thread.sleep(3000);
        boolean buttonKeep2= driver.findElements(By.cssSelector(".primary")).size() != 0;
        if(buttonKeep2==true) {
		WebElement scrollDownToButtonKeep2 = driver.findElement(By.cssSelector(".primary"));
		JavascriptExecutor javasc = (JavascriptExecutor) driver;
		javasc.executeScript("arguments[0].scrollIntoView(true)", scrollDownToButtonKeep2);
		Thread.sleep(2000);
        }
// click in button send
        
		 Thread.sleep(2000);
		 boolean buttonSend2 = driver.findElements(By.cssSelector(".primary")).size() != 0;
		 if(buttonSend2==true) {
		 WebDriverWait wait27 = new WebDriverWait(driver, Duration.ofSeconds(50));
		 wait27.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".primary")));
		 Actions action34 = new Actions(driver);
	    action34.click(driver.findElement(By.cssSelector(".primary"))).build().perform(); 
	    
	    
	    
	    
	    
/*Edit process for the date */

	    //Click in Edit button order
	    
	    Thread.sleep(4000);
		Actions action447 = new Actions(driver);
	    action447.click(driver.findElement(By.xpath("//button[text()='注文変更']"))).build().perform();
	    Thread.sleep(2000);
	  //Scroll down to Delivery date section
		Thread.sleep(5000);
		Boolean DeliveryDateSection2= driver.findElements(By.xpath("//span[text()='配達日時']")).size() != 0;
		if(DeliveryDateSection2==true) {
		WebElement DeliveryDateSectionscrollDown2 = driver.findElement(By.xpath("//span[text()='配達日時']"));
		JavascriptExecutor jas2 = (JavascriptExecutor) driver;
		jas2.executeScript("arguments[0].scrollIntoView(true)", DeliveryDateSectionscrollDown2);
		Thread.sleep(2000);   
		}
		
		
//click in delivery date section
		Thread.sleep(1000);
		Boolean DeliveryDate2= driver.findElements(By.xpath("//span[text()='配達日時']")).size() != 0;
		if(DeliveryDate2==true) {
		Thread.sleep(2000);
		WebDriverWait wait112 = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait112.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='配達日時']")));
		driver.findElement(By.xpath("//span[text()='配達日時']")).click();
		}
		
		
//select the date
		Thread.sleep(1000);
		Boolean SelectDate2= driver.findElements(By.xpath("//select[@ng-model='selection.date']")).size() != 0;
		if(SelectDate2==true) {
		Thread.sleep(2000);
		WebElement DateSelection2 = driver.findElement(By.xpath("//select[@ng-model='selection.date']"));
		Select selectTheDate2 = new Select(DateSelection2);
		selectTheDate2.selectByIndex(3);
		}
//select the time	
		Thread.sleep(1000);
		Boolean SelectTime2= driver.findElements(By.xpath("//select[@ng-model='selection.time_range']")).size() != 0;
		if(SelectTime2==true) {
		Thread.sleep(5000);
		WebElement CountryName112 = driver.findElement(By.xpath("//select[@ng-model='selection.time_range']"));
		Select selectCountryName112 = new Select(CountryName112);
		selectCountryName112.selectByIndex(3);	
		Thread.sleep(2000);
		Actions action15 = new Actions(driver);
	    action15.click(driver.findElement(By.cssSelector(".primary"))).build().perform(); 
//Click in cancel button order
	    Thread.sleep(2000);
		Actions action27 = new Actions(driver);
	    action27.click(driver.findElement(By.xpath("//button[text()='注文キャンセル']"))).build().perform();
	    Thread.sleep(2000);
	    Actions action8 = new Actions(driver);
	    action8.click(driver.findElement(By.xpath("//button[text()='はい']"))).build().perform();
		}

}	     
}	     
	}}

