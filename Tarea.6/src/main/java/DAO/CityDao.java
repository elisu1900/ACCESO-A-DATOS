package DAO;

import model.City;

import java.sql.SQLException;
import java.util.List;

public interface CityDao {
    int add(City city) throws SQLException;

    City getById(int id) throws SQLException;

    List<City> getAll() throws SQLException;

    int update(City city) throws SQLException;

    void delete(int id) throws SQLException;
}
