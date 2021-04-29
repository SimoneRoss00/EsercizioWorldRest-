package it.objectmethod.WorldCountry.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.objectmethod.WorldCountry.dao.ICountryDAO;
import it.objectmethod.WorldCountry.model.Country;

@Component
public class CounrtyDAOImpl implements ICountryDAO {

	@Autowired
	DataSource source;

	@Override
	public List<String> printAllContinent() {
		Country coun = null;
		List<String> continentList = new ArrayList<String>();
		try {
			Connection conn = source.getConnection();
			String sql = "SELECT DISTINCT Continent "
						+"FROM country";
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet resultSet = st.executeQuery();

			while (resultSet.next()) {
				coun = new Country();
				coun.setContinent(resultSet.getString("Continent"));
				continentList.add(coun.getContinent());
			}
			resultSet.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return continentList;
	}

	@Override
	public List<Country> printCountryByContinent(String continentName) {
		Country coun = null;
		List<Country> countryList = new ArrayList<>();
		try {
			Connection conn = source.getConnection();
			String sql = "SELECT * "
						+"FROM country c "
						+"WHERE c.Continent =?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, continentName);
			ResultSet resultSet = st.executeQuery();

			while (resultSet.next()) {
				coun = new Country();
				coun.setCodeCountry(resultSet.getString("Code"));
				coun.setNameCountry(resultSet.getString("Name"));
				coun.setContinent(resultSet.getString("Continent"));
				coun.setRegion(resultSet.getString("Region"));
				coun.setSurfaceArea(resultSet.getInt("SurfaceArea"));
				coun.setIndepYear(resultSet.getInt("IndepYear"));
				coun.setPopulationCountry(resultSet.getInt("Population"));
				coun.setLifeExpectancy(resultSet.getDouble("LifeExpectancy"));
				coun.setGNP(resultSet.getDouble("GNP"));
				coun.setGNPOld(resultSet.getDouble("GNPOld"));
				coun.setLocalName(resultSet.getString("LocalName"));
				coun.setGovernmentForm(resultSet.getString("GovernmentForm"));
				coun.setHeadOfState(resultSet.getString("HeadOfState"));				
				countryList.add(coun);
			}
			resultSet.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return countryList;
	}

	@Override
	public List<Country> printInfoOfCountryValue(String countryName, String continentName) {
		Country coun = null;
		List<Country> countryList = new ArrayList<Country>();
		try {
			Connection conn = source.getConnection();
			String sql = "SELECT * "   
					   + "FROM country "
					   + "WHERE ((''=? OR Name=?)) AND ((''=? OR Continent=?))";
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, countryName);
			st.setString(2, countryName);
			st.setString(3, continentName);
			st.setString(4, continentName);

			ResultSet resultSet = st.executeQuery();

			while (resultSet.next()) {
				coun = new Country();
				coun.setCodeCountry(resultSet.getString("Code"));
				coun.setNameCountry(resultSet.getString("Name"));
				coun.setContinent(resultSet.getString("Continent"));
				coun.setRegion(resultSet.getString("Region"));
				coun.setSurfaceArea(resultSet.getInt("SurfaceArea"));
				coun.setIndepYear(resultSet.getInt("IndepYear"));
				coun.setPopulationCountry(resultSet.getInt("Population"));
				coun.setLifeExpectancy(resultSet.getDouble("LifeExpectancy"));
				coun.setGNP(resultSet.getDouble("GNP"));
				coun.setGNPOld(resultSet.getDouble("GNPOld"));
				coun.setLocalName(resultSet.getString("LocalName"));
				coun.setGovernmentForm(resultSet.getString("GovernmentForm"));
				coun.setHeadOfState(resultSet.getString("HeadOfState"));
				countryList.add(coun);
			}
			resultSet.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return countryList;
	}

}
