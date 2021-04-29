package it.objectmethod.WorldCountry.dao;

import java.util.List;

import it.objectmethod.WorldCountry.model.City;

public interface ICityDAO {
	
	public City printInfoOfCityByName(String cityName);
	
	public List<City> printCityByCountry(String countryCode);
	

}
