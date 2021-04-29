package it.objectmethod.WorldCountry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import it.objectmethod.WorldCountry.dao.ICountryDAO;
import it.objectmethod.WorldCountry.model.Country;

@RestController
public class CountryController {

	@Autowired
	private ICountryDAO countryDao;


	@GetMapping("/countryInfoByValues")
	public List<Country> viewInfoOfCountryByValue(@RequestParam("countryName") String countyName, @RequestParam("continentName") String continentName){
		List<Country> infoCountryList=countryDao.printInfoOfCountryValue(countyName, continentName);
		return infoCountryList;
	}
	@GetMapping("/continentName")
	public List<String> viewAllContinent() {
		List<String> continentList = countryDao.printAllContinent();
		return continentList;
	}
	@GetMapping("/countryName")
	public List<Country> viewCountryByContinentName(@RequestParam("continentName") String name) {
		List<Country> countryList = countryDao.printCountryByContinent(name);
		return countryList;
	}
	
	
	

}
