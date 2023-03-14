package com.example.country.serviceimpl;

import java.util.List;

import com.example.country.Entity.Country;
import com.example.country.Entity.Response;

public interface CountryServiceImpl {

	public List getAllCountries();

	public Response getCountryByID(int id);

	public Response getCountryByName(String name);

	public Country addCountry(Country country);

	public Country updateCountry(Country country);

	public Response deleteCountry(int id);

}
