// This test will check how the website reacts if we type letters instead of digits
// in the field for birthday
// Expected result: it will not open another webpage after trying to submit the
// registration form

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test05LettersInsteadOfDigits {

	static void testingLettersInsteadOfDigitsInBirthday() {

		// The key testing values are day, month, year of birth
		String day1 = "tt";
		String month1 = "pp";
		String year1 = "asdf";

		// 3 parts of this test: firstly, we test letters in field of day
		// secondly, we test letters in field of month
		// thirdly, we test letters in field of year of birth
		// if at least one part is true (wrong value accepted) then the test
		// result is false
		boolean t05part01 = false;
		boolean t05part02 = false;
		boolean t05part03 = false;

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
			driver01.findElement(
				By.xpath("html/body/div[5]/div/div/div[3]/div/form/div[1]/input[11]"))
				.sendKeys(MyPointsMain.email);
		} catch(Exception e){System.out.println(e);}

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

		// Waiting for Privacy policy link to appear
		WebDriverWait wait4 = new WebDriverWait(driver01, 25);
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("html/body/div[5]/div/div/div[3]/div/form/div[2]/p/a[2]")));

		// Clicking on the Step 1 of 2 text to scroll the page neatly
		try{
			driver01.findElement(By.xpath(
					"html/body/div[5]/div/div/div[3]/div/form/div[2]/h2")).click();
		} catch(Exception e){System.out.println(e);}

		// Clicking on the image of Male
		try{
			driver01.findElement(By.xpath(
					"html/body/div[5]/div/div/div[3]/div/form/div[2]/div[1]/div[2]/a[1]"))
				.click();
		} catch(Exception e){System.out.println(e);}

		// Entering first name
		try{
			driver01.findElement(
				By.xpath("html/body/div[5]/div/div/div[3]/div/form/div[2]/div[2]/div[2]/input[1]"))
				.sendKeys(MyPointsMain.firstName);
		} catch(Exception e){System.out.println(e);}

		// ---------------------------------------
		// Trying with day value "tt"

		try{
			driver01.findElement(By.id("birthDateMonth")).sendKeys("03");
		} catch(Exception e){System.out.println(e);}
		try{
			driver01.findElement(By.id("birthDateYear")).sendKeys("1970");
		} catch(Exception e){System.out.println(e);}
		try{
			driver01.findElement(By.id("birthDateDay")).sendKeys(day1);
		} catch(Exception e){System.out.println(e);}
		try{
			driver01.findElement(By.id("address.postalCode")).sendKeys("94043");
		} catch(Exception e){System.out.println(e);}

		try{
		driver01.findElement(
				By.xpath("html/body/div[5]/div/div/div[3]/div/form/div[2]/div[5]/button"))
				.click();
		} catch(Exception e){System.out.println(e);}

		// If the inscription "Step 1 of X" is still on the page then we are at
		// the same page
		// and the website processed the wrong value correctly
		try {
			driver01.findElement(By.xpath(
					"html/body/div[5]/div/div/div[3]/div/form/div[2]/div[1]/div[2]/a[1]"))
					.isDisplayed();
			if (driver01.findElement(By.xpath(
					"html/body/div[5]/div/div/div[3]/div/form/div[2]/div[1]/div[2]/a[1]"))
					.isDisplayed()) {
				t05part01 = false;
			} else
				t05part01 = true;
		} catch (Exception e) {
			System.out.println(e);
		}

		// Re-entering a valid value for day field
		try{
			driver01.findElement(By.id("birthDateDay")).clear();
		} catch(Exception e){System.out.println(e);}
		try{
			driver01.findElement(By.id("birthDateDay")).sendKeys("15");
		} catch(Exception e){System.out.println(e);}

		// Trying with month value "pp"
		try{
			driver01.findElement(By.id("birthDateMonth")).clear();
		} catch(Exception e){System.out.println(e);}
		try{
			driver01.findElement(By.id("birthDateMonth")).sendKeys(month1);
		} catch(Exception e){System.out.println(e);}

		try{
			driver01.findElement(By.xpath(
					"html/body/div[5]/div/div/div[3]/div/form/div[2]/div[5]/button"))
				.click();
		} catch(Exception e){System.out.println(e);}

		try {
			driver01.findElement(By.xpath(
					"html/body/div[5]/div/div/div[3]/div/form/div[2]/div[1]/div[2]/a[1]"))
					.isDisplayed();
			if (driver01.findElement(By.xpath(
					"html/body/div[5]/div/div/div[3]/div/form/div[2]/div[1]/div[2]/a[1]"))
					.isDisplayed()) {
				t05part02 = false;
			} else
				t05part02 = true;
		} catch (Exception e) {
			System.out.println(e);
		}

		// Re-entering a valid value for month field
		try{
			driver01.findElement(By.id("birthDateMonth")).clear();
		} catch(Exception e){System.out.println(e);}
		try{
			driver01.findElement(By.id("birthDateMonth")).sendKeys("07");
		} catch(Exception e){System.out.println(e);}

		// Trying with year value "asdf"
		try{
			driver01.findElement(By.id("birthDateYear")).clear();
		} catch(Exception e){System.out.println(e);}
		try{
			driver01.findElement(By.id("birthDateYear")).sendKeys(year1);
		} catch(Exception e){System.out.println(e);}

		try{
			driver01.findElement(By.xpath(
					"html/body/div[5]/div/div/div[3]/div/form/div[2]/div[5]/button"))
				.click();
		} catch(Exception e){System.out.println(e);}

		try {
			driver01.findElement(By.xpath(
					"html/body/div[5]/div/div/div[3]/div/form/div[2]/div[1]/div[2]/a[1]"))
					.isDisplayed();
			if (driver01.findElement(By.xpath(
					"html/body/div[5]/div/div/div[3]/div/form/div[2]/div[1]/div[2]/a[1]"))
					.isDisplayed()) {
				t05part03 = false;
			} else t05part03 = true;
		} catch (Exception e) {
			System.out.println(e);
		}

		// If all the three values were processed properly then Test05 is passed
		// successfully
		if (!t05part01 && !t05part02 && !t05part03)
			MyPointsMain.test05passed = true;

		// Sleeping a bit before quitting this instance of driver
		try {
			Thread.sleep(MyPointsMain.desirableDelayBeforeClosingWindowAtEachTest);
		} catch (Exception e) {
			System.out.println(e);
		}

		// Incrementing the counter of finished test cases
		MyPointsMain.total++;

		// Quitting this instance of driver
		driver01.quit();

	}

}
