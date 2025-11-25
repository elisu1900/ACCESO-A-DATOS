package main;


import DAO.CityDao;
import DAO.CityDaoImp;
import model.City;

import java.net.StandardSocketOptions;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        testDao();
    }
    public static void testDao(){
        CityDao dao = CityDaoImp.getInstance();

        City city = new City("ejemplo", "COD","Ejemplo", 1000 );
        try {
            int n = dao.add(city);
            System.out.println("el numero de registro insertados es: " + n);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}