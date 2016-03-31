// This test will check if the closing cross works
// Expected result: the form disappears, so we can't find email text field


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Test07CrossForClosingRegForm {
	
	static void testingTheClosingCross(){
	
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
	
		driver01.findElement(By.xpath(
				".//*[@id='main-header']/div/div[2]/ul[2]/li[2]/a")).click();
				
		// Waiting for some bottom-located web element appear
		// as an indication of the loading the registration form
		WebDriverWait wait3 = new WebDriverWait(driver01, 25);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("html/body/div[5]/div/div/div[3]/div/form/div[1]/button")));
		
		// Sleeping a bit for good visual perceiving the test
		try {
			Thread.sleep(MyPointsMain.desirableDelayBeforeClosingWindowAtEachTest);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// Trying to click on the closing cross
		driver01.findElement(
				By.xpath("html/body/div[5]/div/div/div[2]/div[1]/img")).click();
				
		// If email text area is not displayed then the closing cross worked
		if(!driver01.findElement(
				By.xpath("html/body/div[5]/div/div/div[3]/div/form/div[1]/input[11]"))
				.isDisplayed()){
			MyPointsMain.test07passed = true;
		}
		
		// Incrementing the counter of finished test cases
		MyPointsMain.total++;

		// Sleeping a bit before quitting this instance of driver
		MyPointsMain.sleepingABit();

		// Quitting this instance of driver
		driver01.quit();
	}
}
