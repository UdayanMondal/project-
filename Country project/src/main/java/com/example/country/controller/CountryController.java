package com.example.country.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.country.Entity.Country;
import com.example.country.Entity.Response;
import com.example.country.service.CountryService;

@RestController
@EnableAutoConfiguration
public class CountryController {

	@Autowired
	CountryService countryService;

	@GetMapping(value = "/countries")
	public List getAllCountries() {
		List countries = countryService.getAllCountries();
		return countries;
	}

	@GetMapping("/countries/{id}") //
	public Response getCountryByID(@PathVariable(value = "id") int id) {
		return countryService.getCountryByID(id);
	}

	@GetMapping(value = "/country/{countryname}")
	public Response getCountryByName(@RequestParam(value = "name") String name) {
		return countryService.getCountryByName(name);

	}

	@PostMapping("/addcountry")
	public Country addCountry(@RequestBody Country country) {
		return countryService.addCountry(country);
	}

	@PutMapping("/updatecountry")
	public Country updateCountry(@RequestBody Country country) {
		return countryService.updateCountry(country);
	}

	@DeleteMapping("deletecountry/{id}")
	public Response deleteCountry(@PathVariable(value = "id") int id) {
		return countryService.deleteCountry(id);
	}

}
