//This test will check how the website reacts if we type the year value more than current year
//Expected result: it will not open another webpage after trying to submit the
//registration form

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test03YearIsMoreThanCurrentYear {

	static void testingFutureYear() {

		// The key testing value is year of birth
		String year = "2075";

		WebDriver driver01 = new FirefoxDriver();
		driver01.get("https://www.mypoints.com/emp/u/index.vm");

		// Waiting for some very bottom web element will load and appear as
		// an indication of loading the whole web page
		WebDriverWait wait = new WebDriverWait(driver01, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.className("copyright")));

		// Maximizing the browser's window
		driver01.manage().window().maximize();

		// Waiting for the link "Join now" and clicking on it
		WebDriverWait wait2 = new WebDriverWait(driver01, 25);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='main-header']/div/div[2]/ul[2]/li[2]/a")));

		driver01.findElement(By.xpath(
				".//*[@id='main-header']/div/div[2]/ul[2]/li[2]/a")).click();

		// Waiting for some bottom-located web element appear
		// as an indication of the loading the registration form
		WebDriverWait wait3 = new WebDriverWait(driver01, 25);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("html/body/div[5]/div/div/div[3]/div/form/div[1]/button")));

		// Entering email
		driver01.findElement(
				By.xpath("html/body/div[5]/div/div/div[3]/div/form/div[1]/input[11]"))
				.sendKeys(MyPointsMain.email);

		// Entering password
		driver01.findElement(
				By.xpath("html/body/div[5]/div/div/div[3]/div/form/div[1]/input[12]"))
				.sendKeys(MyPointsMain.passW);

		// Clicking the button Continue
		driver01.findElement(By.xpath(
				"html/body/div[5]/div/div/div[3]/div/form/div[1]/button")).click();

		// Waiting for Privacy policy link to appear
		WebDriverWait wait4 = new WebDriverWait(driver01, 25);
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("html/body/div[5]/div/div/div[3]/div/form/div[2]/p/a[2]")));

		// Clicking to the Step 1 of 2 text to scroll the page neatly
		driver01.findElement(By.xpath(
				"html/body/div[5]/div/div/div[3]/div/form/div[2]/h2")).click();

		// Clicking on the image of Male
		driver01.findElement(By.xpath(
				"html/body/div[5]/div/div/div[3]/div/form/div[2]/div[1]/div[2]/a[1]")).click();

		// Entering first name
		driver01.findElement(By.xpath(
				"html/body/div[5]/div/div/div[3]/div/form/div[2]/div[2]/div[2]/input[1]"))
				.sendKeys(MyPointsMain.firstName);

		// ---------------------------------------
		// Trying with year value "2075"
		driver01.findElement(By.id("birthDateMonth")).sendKeys("02");
		driver01.findElement(By.id("birthDateYear")).sendKeys(year);
		driver01.findElement(By.id("birthDateDay")).sendKeys("03");
		driver01.findElement(By.id("address.postalCode")).sendKeys("94043");
		driver01.findElement(By.xpath(
				"html/body/div[5]/div/div/div[3]/div/form/div[2]/div[5]/button")).click();

		// If the inscription "Step 1 of X" is still on the page then we are at
		// the same page
		// and the website processed the wrong value correctly
		if (driver01.findElement(By.xpath(
				"html/body/div[5]/div/div/div[3]/div/form/div[2]/div[1]/div[2]/a[1]"))
				.isDisplayed()) {
			MyPointsMain.test03passed = true;
		}
		
		// Incrementing the counter of finished test cases
		MyPointsMain.total++;

		// Sleeping a bit before quitting this instance of driver
		MyPointsMain.sleepingABit();

		// Quitting this instance of driver
		driver01.quit();
	}
}
