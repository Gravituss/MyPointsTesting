//This test will check how the website reacts if we type password of 1-2 symbols
//Expected result: it will not pass to the registration form

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test06VeryShortPassword {

	// 2 parts of this test: firstly, we test one-symbol password
	// secondly, we test 2-symbols password
	// if at least one part of test will accept very short password, then the
	// test result is false

	static int t06part0102 = 0;

	static void testingVeryShortPasswd() {

		// The key testing value is password
		String passwd1 = "5";
		String passwd2 = "df";

		Test06VeryShortPassword.testingShortPass(passwd1);
		Test06VeryShortPassword.testingShortPass(passwd2);
		if (t06part0102 == 0) {
			MyPointsMain.test06passed = true;
		}

		// Incrementing the counter of finished test cases
		MyPointsMain.total++;

	}

	static void testingShortPass(String password) {
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

		// Entering email
		try{
			driver01.findElement(By.xpath(
				"html/body/div[5]/div/div/div[3]/div/form/div[1]/input[11]"))
				.sendKeys(MyPointsMain.email);
		} catch(Exception e){System.out.println(e);}

		// Entering password
		try{
			driver01.findElement(By.xpath(
				"html/body/div[5]/div/div/div[3]/div/form/div[1]/input[12]"))
				.sendKeys(password);
		} catch(Exception e){System.out.println(e);}

		// Clicking the button Continue
		try{
			driver01.findElement(
				By.xpath("html/body/div[5]/div/div/div[3]/div/form/div[1]/button"))
				.click();
		} catch(Exception e){System.out.println(e);}

		try {
			Thread.sleep(400);
		} catch (Exception e) {
			System.out.println(e);
		}

		// Checking if MyPoints(R) inscription is still on the page
		try {
			driver01.findElement(
					By.xpath("html/body/div[5]/div/div/div[3]/div/div/h1"))
					.isDisplayed();
			if (driver01.findElement(
					By.xpath("html/body/div[5]/div/div/div[3]/div/div/h1"))
					.isDisplayed()) {;
			} else t06part0102++;
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			driver01.findElement(
					By.xpath("html/body/div[5]/div/div/div[3]/div/div/h1"))
					.click();
		} catch (Exception e) {
			System.out.println(e);
		}


		// Sleeping a bit before quitting this instance of driver
		MyPointsMain.sleepingABit();

		// Quitting this instance of driver
		driver01.quit();

	}

}
