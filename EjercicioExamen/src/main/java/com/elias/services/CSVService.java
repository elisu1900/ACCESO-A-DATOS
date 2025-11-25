package com.elias.services;

import com.elias.DAO.BookDAO;
import com.elias.DAO.BookDAOImp;
import com.elias.model.Book;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class CSVService {

    public static List<String> readCSV(File file){
        List<String> result = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String linea = br.readLine();
            while((linea = br.readLine()) != null){
                if (!linea.trim().isEmpty()) {
                    result.add(linea);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<Book> parseBook(List<String> lineas){
        List<Book> libros = new ArrayList<>();

        for (String linea : lineas){
            String [] partes = linea.split(";");
            Book book = new Book();

            if (partes.length != 6){
                System.out.println("Alguna linea del CSV tiene un error, por favor corrigela");
                System.exit(1);
            }
            book.setIsbn(partes[0].trim());
            book.setTitulo(partes[1].trim());
            book.setAutor(partes[2].trim());
            book.setGenero(partes[3].trim());
            book.setPrecio(new BigDecimal(partes[4].trim()));
            book.setUnidadesDisponibles(Integer.parseInt(partes[5].trim()));
            libros.add(book);
        }
        return libros;
    }


    public static void importBooks(File file){
        try {
            BookDAO bookDAO = BookDAOImp.getInstance();
            List<String> lineas = readCSV(file);

            List<Book> libros = parseBook(lineas);


                bookDAO.add(libros);

        } catch (SQLException e){
            e.printStackTrace();
        }



    }
}
