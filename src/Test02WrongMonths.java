// This test will check how the website reacts if we type wrong month
// Expected result: it will not open another webpage after trying to submit the
// registration form

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test02WrongMonths {

	static void testingWrongMonths() {

		// 2 parts of this test: firstly, we test 13th month
		// secondly, we test negative value of month
		// if at least one part is true (wrong value accepted) then the test
		// result is false
		boolean t02part01 = false;
		boolean t02part02 = false;

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

		driver01.findElement(
				By.xpath(".//*[@id='main-header']/div/div[2]/ul[2]/li[2]/a"))
				.click();

		// Waiting for some bottom-located web element appear
		// as an indication of the loading the registration form
		WebDriverWait wait3 = new WebDriverWait(driver01, 25);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By
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
		driver01.findElement(
				By.xpath("html/body/div[5]/div/div/div[3]/div/form/div[1]/button"))
				.click();

		// Waiting for Privacy policy link to appear
		WebDriverWait wait4 = new WebDriverWait(driver01, 25);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("html/body/div[5]/div/div/div[3]/div/form/div[2]/p/a[2]")));

		// Clicking to the Step 1 of 2 text to scroll the page neatly
		driver01.findElement(
				By.xpath("html/body/div[5]/div/div/div[3]/div/form/div[2]/h2"))
				.click();

		// Clicking on the image of Male
		driver01.findElement(
				By.xpath("html/body/div[5]/div/div/div[3]/div/form/div[2]/div[1]/div[2]/a[1]"))
				.click();

		// Entering first name
		driver01.findElement(
				By.xpath("html/body/div[5]/div/div/div[3]/div/form/div[2]/div[2]/div[2]/input[1]"))
				.sendKeys(MyPointsMain.firstName);

		// ---------------------------------------
		// Trying with month value "13"

		driver01.findElement(By.id("birthDateMonth")).sendKeys("13");
		driver01.findElement(By.id("birthDateYear")).sendKeys("1970");
		driver01.findElement(By.id("birthDateDay")).sendKeys("03");
		driver01.findElement(By.id("address.postalCode")).sendKeys("94043");

		driver01.findElement(
				By.xpath("html/body/div[5]/div/div/div[3]/div/form/div[2]/div[5]/button"))
				.click();

		// If the inscription "Step 1 of X" is still on the page then we are at
		// the same page
		// and the website processed the wrong value correctly
		try {
			driver01.findElement(
					By.xpath("html/body/div[5]/div/div/div[3]/div/form/div[2]/div[1]/div[2]/a[1]"))
					.isDisplayed();
			if (driver01.findElement(
					By.xpath("html/body/div[5]/div/div/div[3]/div/form/div[2]/div[1]/div[2]/a[1]"))
					.isDisplayed()) {
				t02part01 = false;
			} else t02part01 = true;
		} catch (Exception e) {
			System.out.println(e);
		}

		// Trying with month value "-1"

		driver01.findElement(By.id("birthDateMonth")).clear();
		driver01.findElement(By.id("birthDateMonth")).sendKeys("-1");

		driver01.findElement(
				By.xpath("html/body/div[5]/div/div/div[3]/div/form/div[2]/div[5]/button"))
				.click();

		try {
			driver01.findElement(
					By.xpath("html/body/div[5]/div/div/div[3]/div/form/div[2]/div[1]/div[2]/a[1]"))
					.isDisplayed();
			if (driver01.findElement(
					By.xpath("html/body/div[5]/div/div/div[3]/div/form/div[2]/div[1]/div[2]/a[1]"))
					.isDisplayed()) {
				t02part02 = false;
			} else t02part02 = true;
		} catch (Exception e) {
			System.out.println(e);
		}

		// If both values were processed properly then Test01 is passed
		// successfully
		if (!t02part01 && !t02part02)
			MyPointsMain.test02passed = true;

		// Sleeping a bit before quitting this instance of driver
		try {
			Thread.sleep(MyPointsMain.desirableDelayBeforeClosingWindowAtEachTest);
		} catch (Exception e) {
			System.out.println(e);
		}

		// Quitting this instance of driver
		driver01.quit();

	}

}