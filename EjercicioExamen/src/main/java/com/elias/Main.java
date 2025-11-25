package com.elias;

import com.elias.config.ConexionDB;
import com.elias.services.CSVService;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/main/resources/datos.csv");
        CSVService.importBooks(file);

        if (ConexionDB.getConexion() != null){
            System.out.println("siii");
        }
    }
}