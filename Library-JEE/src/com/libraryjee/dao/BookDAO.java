package com.libraryjee.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.libraryjee.entity.Book;

public interface BookDAO {
	
	List<Book> getList();
	
	boolean save(Book b) throws FileNotFoundException, IOException;
	
	Book getBook(int id) throws FileNotFoundException, IOException;
	
	boolean update(Book b) throws FileNotFoundException, IOException;
	
	boolean delete(int id) throws FileNotFoundException, IOException;
	
	List<Book> searchList(String search);
	
}
