package com.elias.DAO;

import com.elias.config.ConexionDB;
import com.elias.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImp implements BookDAO {

    private static BookDAOImp instance;

    static {
        instance = new BookDAOImp();
    }

    private BookDAOImp() {
    }

    public static BookDAOImp getInstance() {
        return instance;
    }

    @Override
    public int add(List<Book> libros) throws SQLException {
        String sql = """
            INSERT INTO Books(isbn, title, author, genre, price, available_units) 
            VALUES(?,?,?,?,?,?)
            ON DUPLICATE KEY UPDATE
                title = VALUES(title),
                author = VALUES(author),
                genre = VALUES(genre),
                price = VALUES(price),
                available_units = VALUES(available_units)
            """;
        int[] resultados;
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false);
            for (Book book : libros) {
                pstm.setString(1, book.getIsbn());
                pstm.setString(2, book.getTitulo());
                pstm.setString(3, book.getAutor());
                pstm.setString(4, book.getGenero());
                pstm.setBigDecimal(5, book.getPrecio());
                pstm.setInt(6, book.getUnidadesDisponibles());

                pstm.addBatch();
            }
            resultados = pstm.executeBatch();
            conn.commit();
        }
        return resultados.length;
    }

    @Override
    public Book getBookById(int id) throws SQLException {
        Book result = null;
        String sql = """
                    SELECT * FROM, books WHERE id =?
                """;
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setInt(1, id);

            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    result = new Book();
                    result.setId(rs.getInt("id"));
                    result.setTitulo(rs.getString("isbn"));
                    result.setAutor(rs.getString("title"));
                    result.setAutor(rs.getString("author"));
                    result.setGenero(rs.getString("genre"));
                    result.setPrecio(rs.getBigDecimal("price"));
                    result.setUnidadesDisponibles(rs.getInt("available_units"));

                }
            }
        }
        return result;
    }

    @Override
    public List<Book> getBookByGenre(String genre) throws SQLException {
        String sql = """
                SEECT * FROM Books WHERE genre = ?
                """;
        List<Book> result = new ArrayList<>();

        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, genre);

            try (ResultSet rs = pstm.executeQuery()) {
                Book book;
                while (rs.next()) {
                    book = new Book();
                    book.setId(rs.getInt("id"));
                    book.setTitulo(rs.getString("isbn"));
                    book.setAutor(rs.getString("title"));
                    book.setAutor(rs.getString("author"));
                    book.setGenero(rs.getString("genre"));
                    book.setPrecio(rs.getBigDecimal("price"));
                    book.setUnidadesDisponibles(rs.getInt("available_units"));

                    result.add(book);
                }
            }
        }
        return result;
    }

    @Override
    public int update(Book book) throws SQLException {
        String sql = """
                UPDATE Books SET 
                title =?, author=?, genre=?, price=?, available_units=?
                """;
        int result;
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, book.getIsbn());
            pstm.setString(2, book.getTitulo());
            pstm.setString(3, book.getAutor());
            pstm.setString(3, book.getGenero());
            pstm.setBigDecimal(4, book.getPrecio());
            pstm.setInt(5, book.getUnidadesDisponibles());
            result = pstm.executeUpdate();
        }
        return result;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = """
                DELETE FROM Books Where id =?
                """;
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setInt(1, id);
            pstm.executeUpdate();

        }
    }
}
