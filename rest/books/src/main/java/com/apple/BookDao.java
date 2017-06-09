package com.apple;

import java.sql.Connection;
import java.sql.DriverManager;
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

	public List<Book> getBooks() {
		try {
			List<Book> books = new ArrayList<Book>();
			Statement st = getConnection().createStatement();
			ResultSet rs = st.executeQuery("SELECT id, title, authors, price FROM books ORDER BY id");
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setTitle(rs.getString("title"));
				book.setAuthors(rs.getString("authors"));
				book.setPrice(rs.getDouble("price"));
				books.add(book);
			}
			rs.close();
			st.close();
			return books;
		} catch (SQLException se) {
			System.err.println("Threw a SQLException creating the list of blogs.");
			System.err.println(se.getMessage());
			return null;
		}
	}
}
