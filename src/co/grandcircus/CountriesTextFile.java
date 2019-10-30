package co.grandcircus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CountriesTextFile {

	public static ArrayList<Country> readFromFile(String fileName) {
		ArrayList<Country> countryList = new ArrayList<>();
		Path path = Paths.get(fileName);

		File file = path.toFile();

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			while (line != null) {
				String[] countryValues = line.split(",");
				Country c = new Country(countryValues[0], Integer.parseInt(countryValues[1]));
				countryList.add(c);
				System.out.printf(c.getCountryName() + " (pop %,d)\n", c.countryPopulation);
				line = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Something went wrong with the file");
		} catch (IOException e) {
			System.out.println("Something went wrong when we tried to read from the file");
		} return countryList;

	}

	public static void writeToFile(ArrayList<Country> countries) {

		String fileName = "countries.txt";
		Path path = Paths.get(fileName);

		File file = path.toFile();
		PrintWriter output = null;

		try {
			output = new PrintWriter(new FileOutputStream(file, false));
			for (Country country : countries) {
			output.println(country);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Hey, contact customer service.");
		} finally {
			output.close();
		}
	}

	public static void createOurFile() {

		String fileName = "countries.txt";
		Path path = Paths.get(fileName);

		if (Files.notExists(path)) {
			try {
				Files.createFile(path);
				System.out.println("The file was created successfully!");
			} catch (IOException e) {
				System.out.println("Something went terribly wrong!");
			}
		} else {
			System.out.println("The file already exists!");
		}
	}
	
}
