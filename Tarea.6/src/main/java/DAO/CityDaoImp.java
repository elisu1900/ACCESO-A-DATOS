package DAO;

import config.DataBaseConnection;
import model.City;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDaoImp implements CityDao{

    private static CityDaoImp instance;
    static{
        instance = new CityDaoImp();
    }
    private CityDaoImp() {};

    public static CityDaoImp getInstance(){
        return instance;
    }


    @Override
    public int add(City city) throws SQLException {
        String sql = """
                INSERT INTO city(Name, CountryCode, District, Population)
                VALUES(?,?,?,?);
                """;

        int result;
        try(Connection conn = DataBaseConnection.connect();
            PreparedStatement pstm = conn.prepareStatement(sql)){

            pstm.setString(1, city.getName());
            pstm.setString(2, city.getCountryCode());
            pstm.setString(3, city.getDistrict());
            pstm.setInt(4, city.getPopulation());

            result = pstm.executeUpdate();
        }

        return result;
    }


    @Override
    public City getById(int id) throws SQLException {

        City result = null;

        String sql = "SELECT* FROM city WHERE ID =?";

        try(Connection conn = DataBaseConnection.connect();
            PreparedStatement pstm = conn.prepareStatement(sql)){
            pstm.setInt(1,id);

            try(ResultSet rs = pstm.executeQuery()){
                while(rs.next()){
                    result = new City();
                    result.setId(rs.getInt("ID"));
                    result.setName(rs.getString("Name"));
                    result.setCountryCode(rs.getString("CountryCode"));
                    result.setDistrict(rs.getString("District"));
                    result.setPopulation(rs.getInt("Population"));
                }
            }
        }
        return result;

    }


    @Override
    public List<City> getAll() throws SQLException {

        String sql =  "SELECT * FROM city";
        List<City> result = new ArrayList<>();

        try(Connection conn = DataBaseConnection.connect();
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery()){

                City city;
                while(rs.next()){
                    city = new City();
                    city.setId(rs.getInt("ID"));
                    city.setName(rs.getString("Name"));
                    city.setCountryCode(rs.getString("CountryCode"));
                    city.setDistrict(rs.getString("District"));
                    city.setPopulation(rs.getInt("Population"));
                    result.add(city);
                }
        }

        return result;
    }

    @Override
    public int update(City city) throws SQLException {

        String sql = """
                UPDATE city SET
                Name = ?, CountryCode = ?, District = ?, Population =?
                """;
        int result;

        try(Connection conn = DataBaseConnection.connect();
            PreparedStatement pstm = conn.prepareStatement(sql)){
            pstm.setString(1, city.getName());
            pstm.setString(2, city.getCountryCode());
            pstm.setString(3, city.getDistrict());
            pstm.setInt(4,city.getPopulation());

            result = pstm.executeUpdate();
        }


        return result;

    }

    @Override
    public void delete(int id) throws SQLException {

        String sql = "DELETE FROM city WHERE id = ?";
        try (Connection conn = DataBaseConnection.connect();
             PreparedStatement pstm = conn.prepareStatement(sql)){

            pstm.setInt(1, id);
            pstm.executeUpdate();

        }

    }
}
