package com.libraryjee.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.libraryjee.entity.Book;
import com.libraryjee.util.DBConnect;

public class BookDAOImpl implements BookDAO{

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement prepStatement = null;
	
	
	@Override
	public List<Book> getList() {
		List<Book> list = null;
		Book book = null;
		
		try {
			
			list = new ArrayList<>();
			
			String sql = "SELECT * FROM library.books";
			
			connection = DBConnect.openConnection();
			
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				
				book = new Book();
				
				book.setId(resultSet.getInt("book_id"));
				book.setTitle(resultSet.getString("title"));
				book.setAuthor(resultSet.getString("author"));
				book.setPublisher(resultSet.getString("publisher"));
				book.setIsbn(resultSet.getString("isbn"));
				
				list.add(book);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public boolean save(Book b) throws FileNotFoundException, IOException {
		boolean flag = false;
		
		try {
			String sql = "INSERT INTO library.books(title, author, publisher, isbn) VALUES ('" + b.getTitle() + "', '" + b.getAuthor() + "', '" + b.getPublisher() + "', '" + b.getIsbn() + "')";
			connection = DBConnect.openConnection();
			prepStatement = connection.prepareStatement(sql);
			prepStatement.executeUpdate();
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public Book getBook(int id) throws FileNotFoundException, IOException {
		Book book = new Book();
		
		try {
			String sql = "SELECT * FROM library.books WHERE book_id = " + id;
			connection = DBConnect.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				book.setId(resultSet.getInt("book_id"));
				book.setTitle(resultSet.getString("title"));
				book.setAuthor(resultSet.getString("author"));
				book.setPublisher(resultSet.getString("publisher"));
				book.setIsbn(resultSet.getString("isbn"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return book;
	}

	@Override
	public boolean update(Book b) throws FileNotFoundException, IOException {
		boolean flag = false;
		
		try {
			String sql = "UPDATE library.books SET title = '" + b.getTitle() + "', author = '" + b.getAuthor() + "', publisher = '" + b.getPublisher() + 
					"', isbn = '" + b.getIsbn()+ "' WHERE book_id = " + b.getId();
			connection = DBConnect.openConnection();
			prepStatement = connection.prepareStatement(sql);
			prepStatement.executeUpdate();
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean delete(int id) throws FileNotFoundException, IOException {
		boolean flag = false;
		
		try {
			String sql = "DELETE FROM library.books WHERE book_id = " + id;
			connection = DBConnect.openConnection();
			prepStatement = connection.prepareStatement(sql);
			prepStatement.executeUpdate();
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public List<Book> searchList(String search) {
		List<Book> list = null;
		Book book = null;

		try {
			list = new ArrayList<>();
			
			String sql = "SELECT * FROM library.books WHERE title REGEXP '" + search + "' OR author REGEXP '" + search + "' OR "
					+ "publisher REGEXP '" + search + "' OR isbn REGEXP '" + search + "'";

			connection = DBConnect.openConnection();
			prepStatement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery(sql);
			
			

			while (resultSet.next()) {

				book = new Book();

				book.setId(resultSet.getInt("book_id"));
				book.setTitle(resultSet.getString("title"));
				book.setAuthor(resultSet.getString("author"));
				book.setPublisher(resultSet.getString("publisher"));
				book.setIsbn(resultSet.getString("isbn"));

				list.add(book);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
}
