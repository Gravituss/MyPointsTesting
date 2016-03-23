// 123

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class MyPointsMain {

	// Preparing variables for tests
	static boolean test01passed = false;
	static boolean test02passed = false;
	static boolean test03passed = false;
	static boolean test04passed = false;
	static boolean test05passed = false;
	static boolean test06passed = false;
	static boolean test07passed = false;
	static boolean test08passed = false;
	static boolean test09passed = false;
	static boolean test10passed = false;
	static boolean test11passed = false;
	static boolean test12passed = false;
	static int counter = 0;
	static int total = 12;
	static int desirableDelayBeforeClosingWindowAtEachTest = 2000;
	static String email = "dkjfdhkjf5651@gmail.com";
	static String passW = "dfdfdflijl55";
	static String firstName = "Anton";

	public static void main(String[] args) {

		// Executing each test from a different class
		Test01wrongDays.testingWrongDays();
		
		
		
		
		
		
		
		
		

		// Printing the results of all tests
		if (test01passed) {
			counter++;
			System.out.println("Test -01- passed: true");
			System.out.println("Incorrect days are being processed properly");
		} else {
			System.out.println("Test -01- passed: FALSE");
			System.out
					.println("Incorrect days aren't being processed properly");
		}
		System.out.println("-----------");
		if (test02passed) {
			counter++;
			System.out.println("Test -02- passed: true");
			System.out.println("Incorrect months are being processed properly");
		} else {
			System.out.println("Test -02- passed: FALSE");
			System.out
					.println("Incorrect months aren't being processed properly");
		}
		System.out.println("-----------");
		if (test03passed) {
			counter++;
			System.out.println("Test -03- passed: true");
			System.out
					.println("Year value more than current is being processed properly");
		} else {
			System.out.println("Test -03- passed: FALSE");
			System.out
					.println("Year value more than current isn't being processed properly");
		}
		System.out.println("-----------");
		if (test04passed) {
			counter++;
			System.out.println("Test -04- passed: true");
			System.out
					.println("Year of birth less than 1879 is being processed properly");
		} else {
			System.out.println("Test -04- passed: FALSE");
			System.out
					.println("Year of birth less than 1879 isn't being processed properly");
		}
		System.out.println("-----------");
		if (test05passed) {
			counter++;
			System.out.println("Test -05- passed: true");
			System.out
					.println("Letters in the birthday field are being processed properly");
		} else {
			System.out.println("Test -05- passed: FALSE");
			System.out
					.println("Letters in the birthday field aren't being processed properly");
		}
		System.out.println("-----------");
		if (test06passed) {
			counter++;
			System.out.println("Test -06- passed: true");
			System.out.println("Password that contains only 1-2 symbols"
					+ " is being operated properly");
		} else {
			System.out.println("Test -06- passed: FALSE");
			System.out.println("Password that contains only 1-2 symbols isn't"
					+ " being operated properly");
		}
		System.out.println("-----------");
		if (test07passed) {
			counter++;
			System.out.println("Test -07- passed: true");
			System.out
					.println("The cross for closing registration form works fine");
		} else {
			System.out.println("Test -07- passed: FALSE");
			System.out
					.println("The cross for closing registration form doesn't work fine");
		}
		System.out.println("-----------");
		if (test08passed) {
			counter++;
			System.out.println("Test -08- passed: true");
			System.out
					.println("Entering something without @ in the email field"
							+ " is being processed properly");
		} else {
			System.out.println("Test -08- passed: FALSE");
			System.out
					.println("Entering something without @ in the email field"
							+ " isn't being processed properly");
		}
		System.out.println("-----------");
		if (test09passed) {
			counter++;
			System.out.println("Test -09- passed: true");
			System.out
					.println("The inscription -Tell us a little bit"
							+ " about yourself to help us personalize your feed.- is displayed on"
							+ " the page of the registration form");
		} else {
			System.out.println("Test -09- passed: FALSE");
			System.out
					.println("The inscription -Tell us a little bit"
							+ " about yourself to help us personalize your feed.- isn't"
							+ " displayed on the page of the registration form");
		}
		System.out.println("-----------");
		if (test10passed) {
			counter++;
			System.out.println("Test -10- passed: true");
			System.out.println("The link -Terms of service- works fine");
		} else {
			System.out.println("Test -10- passed: FALSE");
			System.out.println("The link -Terms of service- doesn't work fine");
		}
		System.out.println("-----------");
		if (test11passed) {
			counter++;
			System.out.println("Test -11- passed: true");
			System.out.println("The link -Privacy policy- works fine");
		} else {
			System.out.println("Test -11- passed: FALSE");
			System.out.println("The link -Privacy policy- doesn't work fine");
		}
		System.out.println("-----------");
		if (test12passed) {
			counter++;
			System.out.println("Test -12- passed: true");
			System.out.println("");
		} else {
			System.out.println("Test 12 passed: FALSE");
			System.out.println("");
		}
		System.out.println("-----------");

		// Printing the total result of all the tests
		System.out.println("Number of tests passed: " + counter + " of "
				+ total);
		System.out.println("Number of tests failed: " + (total - counter)
				+ " of " + total);

	}

}
