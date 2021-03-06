// This is a group of test-cases that check different points of
// registration process at MyPoints website.
// Each test-case is located in a separate class.
// Main class gives the results after running all the tests.



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

	static int counter = 0;
	// The number of total finished test cases
	static int total = 0;
	static int desirableDelayBeforeClosingWindowAtEachTest = 2000;
	static String email = "dkjfdhkjf5651@gmail.com";
	static String passW = "dfdfdflijl55";
	static String firstName = "Anton";

	public static void main(String[] args) {

		// Executing each test from a different class
		Test01WrongDays.testingWrongDays();
		Test02WrongMonths.testingWrongMonths();
		Test03YearIsMoreThanCurrentYear.testingFutureYear();
		Test04YearIsLessThan1879.testingVeryOldYear();
		Test05LettersInsteadOfDigits.testingLettersInsteadOfDigitsInBirthday();  
		Test06VeryShortPassword.testingVeryShortPasswd();
		Test07CrossForClosingRegForm.testingTheClosingCross();
		Test08TotallyInvalidEmail.testingTotallyInvalidEmail();
		

		// Printing the results of all tests
		MyPointsMain.printingResults();

	}

	static void printingResults() {
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
			System.out.println("The cross for closing registration form works fine");
		} else {
			System.out.println("Test -07- passed: FALSE");
			System.out.println("The cross for closing registration" +
					" form doesn't work fine");
		}
		System.out.println("-----------");
		if (test08passed) {
			counter++;
			System.out.println("Test -08- passed: true");
			System.out.println("Entering something without @ in the email field"
							+ " is being processed properly");
		} else {
			System.out.println("Test -08- passed: FALSE");
			System.out.println("Entering something without @ in the email field"
							+ " isn't being processed properly");
		}
		System.out.println("-----------");
		
		System.out.println("-----------");

		// Printing the total result of all the tests
		System.out.println("Number of tests passed: " + counter + " of "
				+ total);
		System.out.println("Number of tests failed: " + (total - counter)
				+ " of " + total);

	}
	
	static void sleepingABit (){

		// Sleeping a bit before quitting this instance of driver
		try {
			Thread.sleep(MyPointsMain.desirableDelayBeforeClosingWindowAtEachTest);
		} catch (Exception e) {
			System.out.println(e);
		}
	
	}

}
