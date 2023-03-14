package com.example.country.Entity;

import com.example.country.Entity.Country;

public class Response {

	String msg;
	String Countryname;
	int id;
	Country country;

	public String getCountryname() {
		return Countryname;
	}

	public void setCountryname(String countryname) {
		Countryname = countryname;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
