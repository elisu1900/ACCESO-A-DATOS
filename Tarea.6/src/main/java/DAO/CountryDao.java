package DAO;


import model.Country;

import java.sql.SQLException;
import java.util.List;

public interface CountryDao {
        int add(Country country) throws SQLException;

        Country getById(int id) throws SQLException;

        List<Country> getAll() throws SQLException;

        int update(Country country) throws SQLException;

        void delete(int id) throws SQLException;

}

