package com.elias.DAO;

import com.elias.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDAO {

    int add(List<Book> libros)throws SQLException;

    Book getBookById(int id) throws SQLException;

    List<Book> getBookByGenre(String genre) throws SQLException;

    int update(Book book) throws SQLException;

    void delete(int id) throws SQLException;
}
