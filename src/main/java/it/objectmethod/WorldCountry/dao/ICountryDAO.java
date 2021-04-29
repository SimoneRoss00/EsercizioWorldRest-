package it.objectmethod.WorldCountry.dao;

import java.util.List;

import it.objectmethod.WorldCountry.model.Country;

public interface ICountryDAO {

	public List<String> printAllContinent();

	public List<Country> printInfoOfCountryValue(String countryName, String continentName);

	public List<Country> printCountryByContinent(String continentName);

}
