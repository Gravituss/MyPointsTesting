import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Test09LinkTermsOfService {
	
	static void testingTheLinkTermsOfService (){
		
		
		WebDriver driver01 = new FirefoxDriver();
		driver01.get("https://www.mypoints.com/emp/u/index.vm");
	
		// Waiting for some very bottom web element will load and appear as
		// an indication of loading the whole web page
		WebDriverWait wait = new WebDriverWait(driver01, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.className("copyright")));
	
		// Maximizing the browser's window
		driver01.manage().window().maximize();
	
		// Waiting for the link "Join now" and clicking on it
		WebDriverWait wait2 = new WebDriverWait(driver01, 25);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//*[@id='main-header']/div/div[2]/ul[2]/li[2]/a")));
	
		try{
			driver01.findElement(
				By.xpath(".//*[@id='main-header']/div/div[2]/ul[2]/li[2]/a"))
				.click();
		} catch(Exception e){System.out.println(e);}
	
		// Waiting for some bottom-located web element appear
		// as an indication of the loading the registration form
		WebDriverWait wait3 = new WebDriverWait(driver01, 25);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("html/body/div[5]/div/div/div[3]/div/form/div[1]/button")));
		
		// Trying to enter email
		try{
			driver01.findElement(
				By.xpath("html/body/div[5]/div/div/div[3]/div/form/div[1]/input[11]"))
				.sendKeys(MyPointsMain.email);
		} catch(Exception e){
			MyPointsMain.test07passed = true;}
		
		// Entering password
		try{
			driver01.findElement(
				By.xpath("html/body/div[5]/div/div/div[3]/div/form/div[1]/input[12]"))
				.sendKeys(MyPointsMain.passW);
		} catch(Exception e){System.out.println(e);}		
		
		// Clicking the button Continue
		try{
			driver01.findElement(
				By.xpath("html/body/div[5]/div/div/div[3]/div/form/div[1]/button"))
				.click();
		} catch(Exception e){System.out.println(e);}
		
		// Getting the handler of the first window
		String window1 = driver01.getWindowHandle();
		
		// Waiting for the link "Terms of Service" and clicking on it
		WebDriverWait wait4 = new WebDriverWait(driver01, 25);
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("html/body/div[5]/div/div/div[3]/div/form/div[2]/p/a[1]")));
	
		try{
			driver01.findElement(
				By.xpath("html/body/div[5]/div/div/div[3]/div/form/div[2]/p/a[1]"))
				.click();
		} catch(Exception e){System.out.println(e);}
		
		// Getting the handler of the second window
		String window2 = driver01.getWindowHandle();
		
		// Switching to the handler of the second window
		driver01.switchTo().window(window1);
		
		/*MyPointsMain.sleepingABit();
		
		
		driver01.switchTo().window(window2);
		

		MyPointsMain.sleepingABit();			driver01.switchTo().window(window1);
		
		MyPointsMain.sleepingABit();
		
		
		driver01.switchTo().window(window2);
		

		MyPointsMain.sleepingABit();			driver01.switchTo().window(window1);
		
		MyPointsMain.sleepingABit();
		
		
		driver01.switchTo().window(window2);
		

		MyPointsMain.sleepingABit();		*/
		
		// Waiting and checking the header of Terms of Service article
		WebDriverWait wait5 = new WebDriverWait(driver01, 25);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("html/body/div[3]/div/h3")));
	
		try{
			driver01.findElement(
				By.xpath("html/body/div[3]/div/h3"))
				.click();
			
			if ((driver01.getPageSource().contains("Terms of Service")) &&
					(driver01.getPageSource().contains("Disclaimer")))
			{MyPointsMain.test09passed = true;}
			
		} catch(Exception e){System.out.println(e);}
		
		// Incrementing the counter of finished test cases
		MyPointsMain.total++;

		// Sleeping a bit before quitting this instance of driver
		MyPointsMain.sleepingABit();

		// Quitting this instance of driver
		driver01.quit();
		
	}

}
