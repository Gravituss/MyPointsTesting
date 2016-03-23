import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Test08TotallyInvalidEmail {
	
	static void testingTotallyInvalidEmail(){
		
		// The key testing value is email
		String emmail = "some.text";
		
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
				.sendKeys(emmail);
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
		
		// Trying to find email
		try{
			driver01.findElement(
				By.xpath("html/body/div[5]/div/div/div[3]/div/form/div[1]/input[11]"))
				.click();
			
			// If we find the email web element, then Continue button didn't work,
			// so the website operated with wrong email properly
			MyPointsMain.test08passed = true;
		} catch(Exception e){
			MyPointsMain.test07passed = true;}		
		
		// Incrementing the counter of finished test cases
		MyPointsMain.total++;

		// Sleeping a bit before quitting this instance of driver
		MyPointsMain.sleepingABit();

		// Quitting this instance of driver
		driver01.quit();
	
	}

}
