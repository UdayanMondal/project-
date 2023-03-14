package com.example.country.Entity;

public class Country {

	int id;
	String countryname;
	String capital;

	@Override
	public String toString() {
		return "CountryBean [id=" + id + ", countryname=" + countryname + ", capital=" + capital + "]";
	}

	public Country(int id, String countryname, String capital) {
		super();
		this.id = id;
		this.countryname = countryname;
		this.capital = capital;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryname() {
		return countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

}
