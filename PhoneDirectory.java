//#PhoneDirectory.java
import java.util.Scanner;

public class PhoneDirectory {
	// Class variables
	static PhoneRecord[] records = new PhoneRecord[50];
	static int recordCount = 0;
	static Scanner sc;
	static int i;

	public static void main(String[] args) {

		// Display list of commands
		System.out.println("Phone directory commands:\n"
				+ "  a - Add a new phone number\n" + "  d - Display All\n"
				+ "  dl -Display all with same Last Name\n"
				+ "  drl - Delete all with same Last Name\n"
				+ "  f - Find a phone number\n"
				+ "  r - Remove a phone number\n"
				+ "  rc -Remove all records with same zip code\n"
				+ "  q - Quit\n");

		// Read and execute commands
		while (true) {
			sc = new Scanner(System.in);

			// Prompt user to enter a command
			System.out.print("Enter command (a, d, dl, drl, f, r, rc or q): ");
			String command = sc.nextLine();

			// Determine whether command is "a", "f", "q", or
			// illegal; execute command if legal.
			if (command.equalsIgnoreCase("a")) {

				// Command is "a". Call addNumber to add a new
				// name and number to the database
				addNumber();

			} else if (command.equalsIgnoreCase("f")) {

				// Command is "f". Call findNumber to find phone
				// numbers that match the user's criteria.
				findNumber();
			} else if (command.equalsIgnoreCase("d")) {

				// Command is "d". Call displayRecords to display all phone
				// numbers
				displayRecords();
			} else if (command.equalsIgnoreCase("dl")) {

				// Command is "dl". Call displayRecordsWithSameLastName to
				// display all phone
				// numbers with same last name
				displayRecordsWithSameLastName();
			} else if (command.equalsIgnoreCase("r")) {

				// Command is "r". Call removeNumber to remove phone
				// numbers that match the user's criteria.
				removeNumber();
			} else if (command.equalsIgnoreCase("rc")) {

				// Command is "rc". Call removeNumberWithSameZipCode to remove
				// phone
				// numbers that match the user's criteria.
				removeNumberWithSameZipCode();
			} else if (command.equalsIgnoreCase("drl")) {

				// Command is "drl". Call deleteRecordsWithSameLastName to
				// remove records
				// with same last name
				deleteRecordsWithSameLastName();
			} else if (command.equalsIgnoreCase("q")) {

				// Command is "q". Call quit to quit program.
				quit();
				break;
			} else {

				// Command is illegal. Display error message.
				System.out.println("Command was not recognized; "
						+ "please enter only a, d, dl, drl, f, r, rc or q.");
			}

			System.out.println();
		}
	}

	private static void deleteRecordsWithSameLastName() {
		System.out.println("Enter last name: ");
		String lastName = sc.next();
		int i = 0;
		int count = 0;
		for (i = 0; i < recordCount; i++) {

			if (records[i].getLastName().equals(lastName)) {

			}
		}
		System.out.println(recordCount + " "
				+ "records deleted. Total records: " + count);
		count--;
	}

	private static void quit() {
		System.out.println("Quit");

	}

	private static void removeNumberWithSameZipCode() {
		System.out.println("Enter zip code: ");
		int zipCode = sc.nextInt();
		int i = 0;
		int count = 0;
		for (i = 0; i < recordCount; i++) {
			if (records[i].getZipCode() == zipCode) {

			}
			System.out.println(recordCount + " "
					+ "records deleted. Total records: " + count);
			count = 0;
			recordCount--;
		}
	}

	private static void removeNumber() {
		System.out.println("Enter last name: ");
		String lastName = sc.next();
		int i = 0;
		int count = 0;
		for (i = 0; i < recordCount; i++)
			if (records[i].getLastName().equals(lastName))

				System.out.println(recordCount + " "
						+ "records deleted. Total records: " + count);
		count = 0;
		recordCount--;
	}

	private static void findNumber() {
		for (i = 0; i < recordCount; i++) {
			System.out.println(records[i].getNumber());
		}

	}

	private static void displayRecordsWithSameLastName() {

		System.out.println("Enter last name: ");
		String lastName = sc.next();

		int i = 0;
		int count = 0;

		for (i = 0; i < recordCount; i++)
			if (records[i].getLastName().equals(lastName))
				count++;

		System.out.println(count + " Records Found");

		count = 0;

		for (i = 0; i < recordCount; i++)
			if (records[i].getLastName().equals(lastName))
				System.out.println(++count + ". " + records[i].getName() + " "
						+ records[i].getNumber() + " "
						+ records[i].getZipCode());

	}

	private static void displayRecords() {
		for (i = 0; i < recordCount; i++) {
			System.out.println(records[i].getName() + " "
					+ records[i].getNumber() + " " + records[i].getZipCode());

		}

	}

	private static void addNumber() {
		System.out.println("Enter the first name");
		String firstName = sc.next();
		System.out.println("Enter the last name");
		String lastName = sc.next();
		System.out.println("Enter the phone number");
		String phoneNumber = sc.next();
		System.out.println("Enter the zip code");
		int zipCode = sc.nextInt();
		PhoneRecord record = new PhoneRecord(firstName, lastName, phoneNumber,
				zipCode);
		records[recordCount] = record;
		recordCount++;
		for (i = 0; i < recordCount; i++) {

		}
		System.out.println("1 record added. Total Records: " + recordCount);
	}

}
