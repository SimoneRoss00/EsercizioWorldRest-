package it.objectmethod.WorldCountry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.WorldCountry.dao.ICityDAO;
import it.objectmethod.WorldCountry.model.City;


@RestController
public class CityController {
	
	@Autowired
	private ICityDAO cityDao;
	@GetMapping("/cityByName")
	public City viewCityInfoByName(@RequestParam("cityName")String name) {
		City city=cityDao.printInfoOfCityByName(name);
		return city;
	}
	
	@GetMapping("/{countryCode}/cityName")
	public List<City>viewCityByCountryCode(@PathVariable("countryCode")String cCode){
		List<City> cityList=cityDao.printCityByCountry(cCode);
		return cityList;
	}

}
