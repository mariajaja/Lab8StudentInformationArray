import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Mariah
 *
 */
public class ArrayOnStudents {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		final int CLASS_SIZE = 10;
		int studentNumber = 0;
		boolean isValid = false;
		String userResponse = null;

		do {
			while (!isValid) {// method to validate student's answer, and throw any input exceptions
				try {

					studentNumber = isValidStudent(
							"Which student would you like to learn more about? (enter a number 1-" + CLASS_SIZE + "): ",
							CLASS_SIZE, userInput);
					isValid = true;
				} catch (IndexOutOfBoundsException ex) {
					System.out.println(
							"That student does not exist. Please try again. (enter a number 1-" + CLASS_SIZE + "): ");
					continue;
				} catch (InputMismatchException ex) {
					System.out.println(
							"That student does not exist. Please try again. (enter a number 1-" + CLASS_SIZE + "): ");
					continue;
				}
			}

			// brings array into main method for further use
			String[][] studentInfo = studentInformation();

			userResponse = userChoiceOfKnowledge(userInput, studentInfo, studentNumber);

		} while (userResponse.equalsIgnoreCase("yes"));

	}

	// checking that number is within the class size
	public static int isValidStudent(String prompt, int CLASS_SIZE, Scanner userInput) {
		System.out.print(prompt);

		int studentNumber = userInput.nextInt();

		while (!(studentNumber <= CLASS_SIZE && studentNumber > 0)) {
			System.out.print("That student does not exist. Please try again. (enter a number 1-" + CLASS_SIZE + "): ");
			studentNumber = userInput.nextInt();
		}
		return studentNumber;
	}

	// array containing student's names, hometown, and favorite foods
	public static String[][] studentInformation() {
		String[][] studentInfo = {
				{ "Kim", "Ethan", "Sam", "Khaliah", "Sean", "Rhiannon", "Caitlin", "Louise", "Palak", "Akire" },
				{ "Detroit, MI", "South Haven, MI", "Canton, MI", "London, UK", "Canton, MI", "Westland, MI",
						"Ludington, MI", "Sharon Hill, PA", "Hyderabad, In", "Brooklyn, NY" },
				{ "Colorless Skittles", "Wonder Bread", "Flavorless Chili", "Overcooked Fried Fish",
						"Roomtemp mineral water", "Melted chocolate", "Raw butter noodles", "Expired Candy Cakes",
						"Hot La Croix", "Rock hard carmels" } };
		return studentInfo;
	}

	public static String userChoiceOfKnowledge(Scanner userInput, String[][] studentInfo, int studentNumber) {

		// student's name is introduced and method that filters through other options
		// for user's search of knowledge
		System.out.println("Student " + studentNumber + " is " + getStudentName(studentInfo, studentNumber)
				+ ". What would you like to know about " + getStudentName(studentInfo, studentNumber)
				+ "? (enter \"hometown\" or \"favorite food\"): ");
		String userResponse = userInput.nextLine();

		userResponse = userInput.nextLine();
		if (userResponse.equalsIgnoreCase("hometown")) {
			System.out.println(getHometown(studentInfo, studentNumber));
			userResponse = userInput.nextLine();
			return userResponse;

		} else if (userResponse.equalsIgnoreCase("favorite food")) {
			// prints out string created by getFavFood method
			System.out.println(getFavFood(studentInfo, studentNumber));
			userResponse = userInput.nextLine();
			return userResponse;

		} else {
			do {

				System.out.print(
						"That data does not exist. Please try again. (enter \"hometown\" or \"favorite food\"): ");
				userResponse = userInput.nextLine();
				return userResponse;

			} while (!userResponse.equals("hometown") && !userResponse.equals("favorite food"));
		}
	}

	public static String getStudentName(String[][] studentInfo, int studentNumber) {
		return studentInfo[0][studentNumber - 1];
	}

	// method to figure out hometown and put it into a string to return
	public static String getHometown(String[][] studentInfo, int studentNumber) {
		return getStudentName(studentInfo, studentNumber) + " is from " + studentInfo[1][studentNumber - 1]
				+ ". Would you like to know more about another student? (enter \"yes\" or any other key to quit): ";
	}

	// figures out what favorite food is from array, returns string
	public static String getFavFood(String[][] studentInfo, int studentNumber) {
		return getStudentName(studentInfo, studentNumber) + "'s favorite food is " + studentInfo[2][studentNumber - 1]
				+ ". Would you like to know more about another student? (enter \"yes\" or any other key to quit): ";
	}

	public static boolean findOutMorePrompt(Scanner userInput) {
		String userResponse = userInput.nextLine();
		if (userResponse.equalsIgnoreCase("yes")) {
			return true;
		} else {
			return false;
		}
	}

	// allows for printing of array line for user's choices
	public static void print2D(String[][] array, int row, int col) {

		System.out.println(Arrays.toString(array[row]));
	}

}
