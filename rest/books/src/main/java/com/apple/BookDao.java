package com.apple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
	private Connection connection;

	public BookDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your JDBC Driver? " + "Include in your library path!");
			e.printStackTrace();
			return;
		}
	}

	private Connection getConnection() {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "mysql");
			} catch (SQLException e) {
				System.out.println("Connection Failed! Check output console");
				e.printStackTrace();
			}
		}
		return connection;
	}

	private void closeConnection() throws SQLException {
		if (connection != null) {
			connection.close();
			connection = null;
		}
	}

	private void closeStatement(Statement st) throws SQLException {
		if (st != null) {
			st.close();
			st = null;
		}
	}

	private void closeResultSet(ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
			rs = null;
		}
	}

	public void createBook(Book book) throws SQLException {
		PreparedStatement st = null;
		try {
			st = getConnection().prepareStatement("insert into books (id, title, authors, price) values (?,?,?,?)");
			st.setInt(1, book.getId());
			st.setString(2, book.getTitle());
			st.setString(3, book.getAuthors());
			st.setDouble(4, book.getPrice());

			st.executeUpdate();
		} catch (SQLException se) {
			System.err.println("Threw a SQLException inserting into books.");
			System.err.println(se.getMessage());
		} finally {
			closeStatement(st);
			closeConnection();
		}
	}

	public List<Book> getBooks() throws SQLException {
		List<Book> books = new ArrayList<Book>();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = getConnection().createStatement();
			rs = st.executeQuery("SELECT id, title, authors, price FROM books ORDER BY id");
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setTitle(rs.getString("title"));
				book.setAuthors(rs.getString("authors"));
				book.setPrice(rs.getDouble("price"));
				books.add(book);
			}
		} catch (SQLException se) {
			System.err.println("Threw a SQLException creating the list of books.");
			System.err.println(se.getMessage());
		} finally {
			closeResultSet(rs);
			closeStatement(st);
			closeConnection();
		}
		return books;
	}
	
	public Book getBook(int id) throws SQLException {
		Book book = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = getConnection().prepareStatement("SELECT id, title, authors, price FROM books where id=?");
			st.setInt(1, id);
			rs = st.executeQuery();
			while (rs.next()) {
				book = new Book();
				book.setId(rs.getInt("id"));
				book.setTitle(rs.getString("title"));
				book.setAuthors(rs.getString("authors"));
				book.setPrice(rs.getDouble("price"));
			}
		} catch (SQLException se) {
			System.err.println("Threw a SQLException searching a book.");
			System.err.println(se.getMessage());
		} finally {
			closeResultSet(rs);
			closeStatement(st);
			closeConnection();
		}
		return book;
	}
	
	public void deleteBook(int id) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = getConnection().prepareStatement("delete from books where id=?");
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException se) {
			System.err.println("Threw a SQLException deleting a book.");
			System.err.println(se.getMessage());
		} finally {
			closeResultSet(rs);
			closeStatement(st);
			closeConnection();
		}
	}
}
