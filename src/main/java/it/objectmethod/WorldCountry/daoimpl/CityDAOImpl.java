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

import it.objectmethod.WorldCountry.model.City;
import it.objectmethod.WorldCountry.dao.ICityDAO;

@Component
public class CityDAOImpl implements ICityDAO {
	
	@Autowired
	DataSource source;

	@Override
	public City printInfoOfCityByName(String cityName) {
		City cityInfo=null;
		try {
			Connection dbConnection=source.getConnection();
			PreparedStatement statement= dbConnection.prepareStatement("SELECT * "
																	 + "FROM city c "
																	 + "WHERE c.Name=?");
			statement.setString(1, cityName);
			ResultSet rSet= statement.executeQuery();
			while (rSet.next()) {
				cityInfo = new City();
				cityInfo.setId(rSet.getInt("ID"));
				cityInfo.setName(rSet.getString("Name"));
				cityInfo.setCountryCode(rSet.getString("CountryCode"));
				cityInfo.setDistrict(rSet.getString("District"));
				cityInfo.setPopulation(rSet.getInt("Population"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cityInfo;
	}

	@Override
	public List<City> printCityByCountry(String countryCode) {
		City city = null;
		List<City> cityList = new ArrayList<City>();
		try {
			Connection conn = source.getConnection();
			String sql = "Select * "
						+"FROM city c "
						+"WHERE c.CountryCode=? ";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, countryCode);
			ResultSet resultSet = st.executeQuery();

			while (resultSet.next()) {
				city = new City();
				city.setId(resultSet.getInt("ID"));
				city.setName(resultSet.getString("Name"));
				city.setCountryCode(resultSet.getString("CountryCode"));
				city.setDistrict(resultSet.getString("District"));
				city.setPopulation(resultSet.getInt("Population"));
				cityList.add(city);
			}
			resultSet.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cityList;
	}

}
