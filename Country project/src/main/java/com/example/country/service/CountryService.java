package com.example.country.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.example.country.Entity.Country;
import com.example.country.Entity.Response;
import com.example.country.serviceimpl.CountryServiceImpl;

@Service
public class CountryService implements CountryServiceImpl {

	static Map<Integer, Country> countryIdMap;

	public CountryService() {
		countryIdMap = new ConcurrentHashMap<Integer, Country>();

		Country india = new Country(1, "India", "Delhi");
		Country japan = new Country(2, "japan", "Tokyo");
		Country usa = new Country(3, "usa", "Washington");
		Country uk = new Country(4, "uk", "london");

		countryIdMap.put(1, india);
		countryIdMap.put(2, japan);
		countryIdMap.put(3, usa);
		countryIdMap.put(4, uk);

	}

	public List getAllCountries() {
		List countries = new ArrayList(countryIdMap.values());
		return countries;
	}

	public Response getCountryByID(int id) {
		Response response = new Response();
		Country country = countryIdMap.get(id);
		if (country == null) {
			response.setId(id);
			response.setMsg("Country by ID " + "  " + "Not Found");
		} else {
			response.setId(id);
			response.setCountry(country);
			response.setMsg("Country by ID is Found Successfully");
			response.setCountryname(country.getCountryname());
		}
		return response;
	}

	public Response getCountryByName(String name) {
		Country country = null;

		Response response = new Response();
		int id = 0;
		for (Entry<Integer, Country> i : countryIdMap.entrySet()) {
			if (i.getValue().getCountryname().equalsIgnoreCase(name)) {

				country = i.getValue();
				id = i.getValue().getId();

			}
		}
		if (country == null) {
			response.setCountryname(name);
			response.setMsg("Country by name is Not found");

		} else

			response.setMsg("country  by name  is Found");
		response.setCountryname(name);
		response.setId(id);
		response.setCountry(country);

		return response;
	}

	// method to generate new ID for adding new record
	public static int getMaxId() {
		int maxID = 0;
		for (int i : countryIdMap.keySet()) {
			if (i > maxID)
				maxID = i;
		}
		return maxID + 1;
	}

	public Country addCountry(Country country) {
		country.setId(getMaxId());
		int id = country.getId();
		countryIdMap.put(id, country);
		return country;
	}

	public Country updateCountry(Country country) {
		if (country.getId() > 0) {
			countryIdMap.put(country.getId(), country);
		}
		return country;
	}

	public Response deleteCountry(int id) {
		Response response = new Response();
		int deletedId = 0;
		if (countryIdMap.entrySet() != null) {
			for (Entry<Integer, Country> e : countryIdMap.entrySet()) {
				deletedId = e.getValue().getId();

				if (deletedId == id) {
					countryIdMap.remove(id);
					response.setId(id);
					response.setMsg("country deleted Successfully ");
					response.setCountryname(e.getValue().getCountryname());
					break;
				} else {
					response.setId(id);
					response.setMsg("ID do not exist in the Map ");
				}
			}

		}

		return response;
	}

}
