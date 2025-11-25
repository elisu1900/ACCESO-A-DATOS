package DAO;

import config.DataBaseConnection;
import model.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImp implements CountryDao {

    private static CountryDaoImp instance;

    static {
        instance = new CountryDaoImp();
    }

    private CountryDaoImp() {}

    public static CountryDaoImp getInstance() {
        return instance;
    }

    @Override
    public int add(Country country) throws SQLException {
        String sql = """
                INSERT INTO country(Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadOfState, Capital, Code2)
                VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);
                """;

        int result;
        try (Connection conn = DataBaseConnection.connect();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, country.getCode());
            pstm.setString(2, country.getName());
            pstm.setString(3, country.getContinent());
            pstm.setString(4, country.getRegion());
            pstm.setDouble(5, country.getSurfaceArea());
            if (country.getIndepYear() != null) {
                pstm.setInt(6, country.getIndepYear());
            } else {
                pstm.setNull(6, java.sql.Types.INTEGER);
            }
            pstm.setInt(7, country.getPopulation());
            pstm.setDouble(8, country.getLifeExpectancy());
            pstm.setDouble(9, country.getGnp());
            pstm.setDouble(10, country.getGnpOld());
            pstm.setString(11, country.getLocalName());
            pstm.setString(12, country.getGovernmentForm());
            pstm.setString(13, country.getHeadOfState());
            pstm.setInt(14, country.getCapital());
            pstm.setString(15, country.getCode2());

            result = pstm.executeUpdate();
        }

        return result;
    }

    @Override
    public Country getById(int id) throws SQLException {
        Country result = null;

        String sql = "SELECT * FROM country WHERE Code = ?";

        try (Connection conn = DataBaseConnection.connect();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, String.valueOf(id));

            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    result = new Country();
                    result.setCode(rs.getString("Code"));
                    result.setName(rs.getString("Name"));
                    result.setContinent(rs.getString("Continent"));
                    result.setRegion(rs.getString("Region"));
                    result.setSurfaceArea(rs.getDouble("SurfaceArea"));
                    result.setIndepYear(rs.getInt("IndepYear"));
                    result.setPopulation(rs.getInt("Population"));
                    result.setLifeExpectancy(rs.getDouble("LifeExpectancy"));
                    result.setGnp(rs.getDouble("GNP"));
                    result.setGnpOld(rs.getDouble("GNPOld"));
                    result.setLocalName(rs.getString("LocalName"));
                    result.setGovernmentForm(rs.getString("GovernmentForm"));
                    result.setHeadOfState(rs.getString("HeadOfState"));
                    int capitalValue = rs.getInt("Capital");
                    result.setCapital(rs.wasNull() ? null : capitalValue);
                    result.setCode2(rs.getString("Code2"));
                }
            }
        }
        return result;
    }

    @Override
    public List<Country> getAll() throws SQLException {
        String sql = "SELECT * FROM country";
        List<Country> result = new ArrayList<>();

        try (Connection conn = DataBaseConnection.connect();
             PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {

            Country country;
            while (rs.next()) {
                country = new Country();
                country.setCode(rs.getString("Code"));
                country.setName(rs.getString("Name"));
                country.setContinent(rs.getString("Continent"));
                country.setRegion(rs.getString("Region"));
                country.setSurfaceArea(rs.getDouble("SurfaceArea"));
                country.setIndepYear(rs.getInt("IndepYear"));
                country.setPopulation(rs.getInt("Population"));
                country.setLifeExpectancy(rs.getDouble("LifeExpectancy"));
                country.setGnp(rs.getDouble("GNP"));
                country.setGnpOld(rs.getDouble("GNPOld"));
                country.setLocalName(rs.getString("LocalName"));
                country.setGovernmentForm(rs.getString("GovernmentForm"));
                country.setHeadOfState(rs.getString("HeadOfState"));
                int capitalValue = rs.getInt("Capital");
                country.setCapital(rs.wasNull() ? null : capitalValue);
                country.setCode2(rs.getString("Code2"));
                result.add(country);
            }
        }

        return result;
    }

    @Override
    public int update(Country country) throws SQLException {
        String sql = """
                UPDATE country SET
                Name = ?, Continent = ?, Region = ?, SurfaceArea = ?, IndepYear = ?, Population = ?, 
                LifeExpectancy = ?, GNP = ?, GNPOld = ?, LocalName = ?, GovernmentForm = ?, 
                HeadOfState = ?, Capital = ?, Code2 = ?
                WHERE Code = ?
                """;
        int result;

        try (Connection conn = DataBaseConnection.connect();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, country.getName());
            pstm.setString(2, country.getContinent());
            pstm.setString(3, country.getRegion());
            pstm.setDouble(4, country.getSurfaceArea());
            pstm.setInt(5, country.getIndepYear());
            pstm.setInt(6, country.getPopulation());
            pstm.setDouble(7, country.getLifeExpectancy());
            pstm.setDouble(8, country.getGnp());
            pstm.setDouble(9, country.getGnpOld());
            pstm.setString(10, country.getLocalName());
            pstm.setString(11, country.getGovernmentForm());
            pstm.setString(12, country.getHeadOfState());
            if (country.getCapital() != null) {
                pstm.setInt(13, country.getCapital());
            } else {
                pstm.setNull(13, java.sql.Types.INTEGER);
            }
            pstm.setString(14, country.getCode2());
            pstm.setString(15, country.getCode());

            result = pstm.executeUpdate();
        }

        return result;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM country WHERE Code = ?";
        try (Connection conn = DataBaseConnection.connect();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, String.valueOf(id));
            pstm.executeUpdate();
        }
    }
}