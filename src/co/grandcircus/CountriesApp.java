/*
 * @author: Kevin
 */
package co.grandcircus;

import java.util.ArrayList;
import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		CountriesTextFile.createOurFile();

		ArrayList<Country> countryList = new ArrayList<>();
		System.out.println();
		System.out.println("Welcome to the Countries Maintenance Application! ");

		int toContinue = 0;

		while (toContinue != 3) {
			System.out.println("\n1 - See the list of countries\n2 - Add a country\n3 - Exit");

			int userChoice = Validator.getInt(scan, "\nEnter menu number: ", 1, 3);

			if (userChoice == 1) {
				CountriesTextFile.readFromFile("countries.txt");
			} else if (userChoice == 2) {
				String newCountry = Validator.getString(scan, "\nEnter country: ");
				int popCountry = Validator.getInt(scan, "Enter population: ");
				countryList.add(new Country(newCountry, popCountry));
				CountriesTextFile.writeToFile(countryList);
				System.out.println("This country has been saved!");
			} else if (userChoice == 3) {
				toContinue = 3;
				System.out.println("\nGoodbye!");
			}
		}
		scan.close();
	}

}
