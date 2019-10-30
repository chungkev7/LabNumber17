package co.grandcircus;

public class Country {
	private String countryName;
	int countryPopulation;
	
	public Country(String countryName, int countryPopulation) {
		super();
		this.countryName = countryName;
		this.countryPopulation = countryPopulation;
	}
	
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public int getCountryPopulation() {
		return countryPopulation;
	}
	public void setCountryPopulation(int countryPopulation) {
		this.countryPopulation = countryPopulation;
	}

	@Override
	public String toString() {
		return countryName + "," + countryPopulation;
	}
	
}
